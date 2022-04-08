package com.example.leaseloco.profiles;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("provideroffers")

/**
 * This could use annotation to automatically bind headers to values, it would need to be hardcoded and does not represent a "true" solution (or at least I believe so).
 * Using annotations a single class could be used by using OpenCSV Profiles, this is easier to do but not very scalable as annotations are hardcoded.
 * A switch case better represents how it could work using a database, similar to user settings it could store headers for each provider.
 */
public class GenericProviderImp {


    private String Provider;

    private String Id;

    private String Make;

    private String Model;

    private String Mileage;

    private String Price;

    private String Term;


   public GenericProviderImp setProvider(String provider) {
       this.Provider = provider;
       return this;
   }


    public GenericProviderImp createOfferMap(Map<String,String> offer) {

        setProvider("PrettyGoodDeals");
        offer.forEach((key, value) -> {
            switch (key) {
                case "ID":
                    this.setId(value);
                    break;
                case "MAKE":
                    this.setMake(value);
                    break;
                case "MODEL":
                    this.setModel(value);
                    break;
                case "MILEAGE":
                    this.setMileage(value);
                    break;
                case "PRICE":
                    this.setPrice(value);
                    break;
                case "TERM":
                    this.setTerm(value);
                    break;
                default:
                    System.out.println("Column not required");
            }
        });
       return this;

    }

    public void setId(String ID) {
        this.Id = ID;
    }

    public void setMake(String MAKE) {
        this.Make = MAKE;
    }

    public void setModel(String MODEL) {
        this.Model = MODEL;
    }

    public void setMileage(String MILEAGE) {
        this.Mileage = MILEAGE;
    }

    public void setPrice(String PRICE) {
        this.Price = PRICE;
    }

    public void setTerm(String TERM) {
        this.Term = TERM;
    }
}
