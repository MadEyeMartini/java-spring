package com.example.leaseloco;


import com.example.leaseloco.controller.DealsController;
import com.example.leaseloco.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LeaselocoApplication implements CommandLineRunner {

    @Autowired
    OfferRepository providerOfferRepo;

    @Autowired
    MongoTemplate mongoTemplate;
    public static void main(String[] args) {
        SpringApplication.run(LeaselocoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    CSVInput csvInput = new CSVInput(providerOfferRepo, mongoTemplate);
    new DealsController();
    }


}
