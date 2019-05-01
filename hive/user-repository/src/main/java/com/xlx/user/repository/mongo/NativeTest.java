package com.xlx.user.repository.mongo;

import com.mongodb.*;

public class NativeTest {

    public static void main(String[] args) {
        MongoClient mongo = new MongoClient("127.0.0.1", 27017);
        DB db = new DB(mongo, "User");

        DBCollection hiveUser = db.getCollection("hiveUser");
        DBCursor cursor = hiveUser.find();
        for (DBObject c : cursor) {
            System.out.println(c);
        }
    }
}
