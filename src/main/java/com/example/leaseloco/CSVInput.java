package com.example.leaseloco;


import com.example.leaseloco.model.AmazingCars;
import com.example.leaseloco.model.GenericProviderImp;
import com.example.leaseloco.model.PrettyGoodCarDeals;
import com.example.leaseloco.repository.OfferRepository;
import com.opencsv.CSVReaderHeaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;


public class CSVInput {


    OfferRepository providerOfferRepo;
    MongoTemplate mongoTemplate;
    public CSVInput(OfferRepository providerOfferRepo, MongoTemplate mongoTemplate) {
        this.providerOfferRepo = providerOfferRepo;
        this.mongoTemplate = mongoTemplate;


        //Testing, not really tried this with Java
        // This will populate the database or if ran again it will overwrite, in an ideal scenario we would not run this each time it starts but we would require an interface
        // or to check if the database is already populated.
        new Thread(() -> {
            readData("PrettyGoodCarDeals","data.csv");
            readData("AmazingCars","pricing.csv");
        }).start();


    }

    /*
    Assumptions:
    1. We know the provider name for each file and a file has been uploaded
     */
    public void readData(String providerName, String file) {
        GenericProviderImp Provider;

        // In reality this would use a database. It would detect the provider name and find the document that contains all headers that provider uses.
        if(providerName.equals("AmazingCars")) {
            System.out.println("Called");
            Provider = new AmazingCars();
        } else {
            Provider = new PrettyGoodCarDeals();
        }

        try {
            Resource resource = new ClassPathResource(file);
            InputStream input = resource.getInputStream();

            // Another method that would make this task a lot easier, however it is not realistic for multiple providers. Header names would need to be hardcoded.
            // I felt a better method to demonstrate a "database" was to use a switch case.

          /* CsvToBean<GenericProviderImp> csvToBean = new CsvToBeanBuilder<GenericProviderImp>(filereader)
                    .withType(GenericProviderImp.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
           ;*/

                     /*   for (GenericProviderImp amzCar : csvToBean) {
                amzCar.setProvider(providerName);
                System.out.println(amzCar.);
                this.providerOfferRepo.save(amzCar);
            }
*/

            /*
              Mongo operations should be in their own class but due to lack of time will leave here for now, can refactor later
             */
            CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(Paths.get(resource.getURI()).toString()));
            Map<String, String> values;
            while ((values = reader.readMap()) != null) {
                System.out.println("Value: "+values);
                    Provider.createOfferMap(values);
                   // this.providerOfferRepo.save(Provider);
                    Query query = new Query();
                 //   query.addCriteria(Criteria.where("Provider").is(providerName));
                    query.addCriteria(Criteria.where("id").is(Provider.getId()).and("provider").is(Provider.getProvider()));
                    Update update = new Update();

                NumberFormat fmtShort = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.SHORT);
                Currency pound = Currency.getInstance(Locale.UK);
                    // Inefficient and requires refactoring. A quick way to handle duplicate or new data (price updates)
                    update.set("provider", Provider.getProvider());
                    update.set("id", Provider.getId());
                    update.set("make", Provider.getMake());
                    update.set("model", Provider.getModel());
                    update.set("mileage", fmtShort.format(Integer.parseInt(Provider.getMileage().replaceAll("K", ""))));
                    update.set("price",Provider.getPrice().replaceAll("£",""));
                    update.set("term", Provider.getTerm());
                    //System.out.println(this.mongoTemplate.findOne(query, GenericProviderImp.class).getProvider());
                    this.mongoTemplate.upsert(query, update, GenericProviderImp.class);
            }

        } catch (Exception e) {
e.printStackTrace();        }
    }




}
