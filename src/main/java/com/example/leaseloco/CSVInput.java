package com.example.leaseloco;


import com.example.leaseloco.repository.OfferRepository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CSVInput {


    OfferRepository providerOfferRepo;

    public CSVInput(OfferRepository providerOfferRepo) {
        this.providerOfferRepo = providerOfferRepo;
        readData("PrettyGoodCarDeals","data.csv");

    }

    // Make the assumption there is an uploaded file and that with the uploaded file is the provider name
    public void readData(String providerName, String file) {

        try {
            Resource resource = new ClassPathResource(file);
            InputStream input = resource.getInputStream();
            Reader filereader = Files.newBufferedReader(Paths.get(resource.getURI()));
            CsvToBean<GenericCarsImp> csvToBean = new CsvToBeanBuilder<GenericCarsImp>(filereader)
                    .withType(GenericCarsImp.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            for (GenericCarsImp amzCar : csvToBean) {
                amzCar.setProvider(providerName);
                System.out.println("Provider ID: " + amzCar.getID());
                System.out.println("Make: " + amzCar.getMAKE());
                System.out.println("==========================");
                this.providerOfferRepo.save(amzCar);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
