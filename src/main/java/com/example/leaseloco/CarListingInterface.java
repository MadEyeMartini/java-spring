package com.example.leaseloco;

/**
 * Interface for non-standard CSV files
 */
public interface CarListingInterface {


    public CarListingInterface setProvider(String provider);
    public CarListingInterface setProviderID(String id);
    public CarListingInterface setMake(String make);
    public CarListingInterface setModel(String model);
    public CarListingInterface setDesc(String desc);
    public CarListingInterface setMileage(String mileage);
    public CarListingInterface setPrice(String price);
    public CarListingInterface setTerm(int term);

}
