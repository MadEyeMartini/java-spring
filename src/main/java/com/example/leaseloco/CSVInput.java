package com.example.leaseloco;


import com.example.leaseloco.profiles.AmazingCars;
import com.example.leaseloco.profiles.GenericProviderImp;
import com.example.leaseloco.profiles.PrettyGoodCarDeals;
import com.example.leaseloco.repository.OfferRepository;

import com.opencsv.CSVReaderHeaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class CSVInput {


    OfferRepository providerOfferRepo;

    public CSVInput(OfferRepository providerOfferRepo) {
        this.providerOfferRepo = providerOfferRepo;
        readData("PrettyGoodCarDeals","data.csv");
        readData("AmazingCars","pricing.csv");

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
            Reader filereader = Files.newBufferedReader(Paths.get(resource.getURI()));

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
            CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(Paths.get(resource.getURI()).toString()));
            Map<String, String> values;
            while ((values = reader.readMap()) != null) {
                System.out.println("Value: "+values);
                if (providerName.equals("AmazingCars")) {
                    Provider.createOfferMap(values);
                    this.providerOfferRepo.save(Provider);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
