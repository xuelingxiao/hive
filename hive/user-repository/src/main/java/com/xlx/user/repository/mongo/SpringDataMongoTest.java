package com.xlx.user.repository.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class SpringDataMongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void print(){
        Set<String> collections = mongoTemplate.getCollectionNames();
        System.out.println(collections);

        //查询
        Query query = new Query();
        List<User> list = mongoTemplate.find(query,User.class);
        System.out.println(list);
    }
}
