package com.example.leaseloco.repository;

import com.example.leaseloco.model.GenericProviderImp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfferRepository extends MongoRepository<GenericProviderImp, String> {


}
