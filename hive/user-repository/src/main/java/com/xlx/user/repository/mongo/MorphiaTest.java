package com.xlx.user.repository.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;

public class MorphiaTest {
    public static void main(String[] args) {
        Morphia morphia = new Morphia();
        Datastore ds =morphia.createDatastore(new MongoClient("127.0.0.1", 27017),"hiveUser");
        ds.save(new User("Test",3,19,0));
        Query<User> query = ds.createQuery(User.class);
        List<User> user = query.asList();
        System.out.println(user.size());
    }
}
