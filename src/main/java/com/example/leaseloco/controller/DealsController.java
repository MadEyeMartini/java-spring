package com.example.leaseloco.controller;

import com.example.leaseloco.model.MongoDBOP;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class DealsController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/deals")
    @ResponseBody
    public List<JsonObject> allOffers(@RequestParam Map<String, String> params) {
        System.out.println(params.keySet());
        System.out.println(params.values());
        MongoDBOP model = new MongoDBOP(this.mongoTemplate);
        return  model.getDeals(params);
    }


}
