package com.example.leaseloco.model;

import org.bson.json.JsonObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoDBOP {

    MongoTemplate mongoTemplate;
    public MongoDBOP(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<JsonObject> getDeals(Map<String,String> params) {
        List<Criteria> criteriaList = new ArrayList<>();
        List<JsonObject> filteredVals;
        // Simple check to avoid empty params exception
        if(params.size() == 0) {
            filteredVals = mongoTemplate.findAll(JsonObject.class, "provideroffers");
            return filteredVals;
        }
        params.forEach((key, value) -> {
            criteriaList.add(Criteria.where(key).is(value));
        });
        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[criteriaList.size()])));
        filteredVals = mongoTemplate.find(query, JsonObject.class, "provideroffers");

        return filteredVals;
    }
}
