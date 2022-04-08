package com.example.leaseloco.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("provideroffers")
public class AmazingCars extends GenericProviderImp {

    public AmazingCars createOfferMap(Map<String, String> offer){
        setProvider("AmazingCars");
        offer.forEach((key, value) -> {
            value = value.toUpperCase();
            switch (key) {
                case "id" -> this.setId(value);
                case "name" -> this.setMake(value);
                case "type" -> this.setModel(value);
                case "mileage" -> this.setMileage(value);
                case "price" -> this.setPrice(value);
                case "term" -> this.setTerm(value);
                default -> System.out.println("Column not required");
            }
        });
        return this;
    }



}
