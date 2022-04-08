package com.example.leaseloco.model;

import java.util.Map;

public class PrettyGoodCarDeals extends GenericProviderImp {

    public GenericProviderImp createOfferMap(Map<String,String> offer) {

        setProvider("PrettyGoodDeals");
        offer.forEach((key, value) -> {
            value = value.toUpperCase();

            switch (key) {
                case "ID" -> this.setId(value);
                case "MAKE" -> this.setMake(value);
                case "MODEL" -> this.setModel(value);
                case "MILEAGE" -> this.setMileage(value);
                case "PRICE" -> this.setPrice(value);
                case "TERM" -> this.setTerm(value);
                default -> System.out.println("Column not required");
            }
        });
        return this;

    }

}
