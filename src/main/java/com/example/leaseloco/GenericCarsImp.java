package com.example.leaseloco;

import com.opencsv.bean.CsvBindByName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("provideroffers")
public class GenericCarsImp {


    private String Provider;

    @CsvBindByName
    @Id
    private String ID;

    @CsvBindByName
    private String MAKE;

    @CsvBindByName
    private String MODEL;

    @CsvBindByName
    private String DESCRIPTION;

    @CsvBindByName
    private String MILEAGE;

    @CsvBindByName
    private String PRICE;

    @CsvBindByName
    private String TERM;




   public GenericCarsImp setProvider(String provider) {
       this.Provider = provider;
       return this;
   }

    public String getProvider() {
        return Provider;
    }

    public String getID() {
        return ID;
    }

    public String getMAKE() {
        return MAKE;
    }

    public String getMODEL() {
        return MODEL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getMILEAGE() {
        return MILEAGE;
    }

    public String getPRICE() {
        return PRICE;
    }

    public String getTERM() {
        return TERM;
    }
}
