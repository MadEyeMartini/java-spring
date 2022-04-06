package com.example.leaseloco;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class AmazingCarsImp {


    private String Provider;

    @CsvBindByName
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
    private int TERM;


    public AmazingCarsImp(String Provider, String ID, String MAKE, String MODEL, String DESCRIPTION, String MILEAGE, String PRICE, int TERM) {
        this.Provider = Provider;
        this.ID = ID;
        this.MAKE = MAKE;
        this.MODEL = MODEL;
        this.DESCRIPTION = DESCRIPTION;
        this.MILEAGE = MILEAGE;
        this.PRICE = PRICE;
        this.TERM = TERM;
    }

    public AmazingCarsImp setProvider(String provider) {
        this.Provider = provider;
        return this;
    }
}
