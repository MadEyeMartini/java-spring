package com.example.leaseloco;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class GenericCarsImp implements CarListingInterface{

    private String Provider;
    private String ProviderID;
    private String Make;
    private String Model;
    private String Description;
    private String Mileage;
    private BigDecimal Price;
    private Integer Term;

    @Override
    public GenericCarsImp setProvider(String provider) {
        this.Provider = provider;
        return this;
    }

    @Override
    public GenericCarsImp setProviderID(String id) {
        this.ProviderID = id;
        return this;
    }

    @Override
    public GenericCarsImp setMake(String make) {
        this.Make = make;
        return this;
    }

    @Override
    public GenericCarsImp setModel(String model) {
        this.Model = model;
        return this;
    }

    @Override
    public GenericCarsImp setDesc(String desc) {
        this.Description = desc;
        return this;
    }

    @Override
    public GenericCarsImp setMileage(String mileage) {
        this.Mileage = mileage;
        return this;
    }

    @Override
    public GenericCarsImp setPrice(String price) {
        this.Price = new BigDecimal(price);
        return this;
    }

    @Override
    public GenericCarsImp setTerm(int term) {
        this.Term = term;
        return this;
    }
}
