package com.example.leaseloco.repository;

import com.example.leaseloco.GenericCarsImp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfferRepository extends MongoRepository<GenericCarsImp, String> {


}
