package com.xlx.user.repository.mongo;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor
@Document("User")
public class User {

    public User(String name,Integer id,Integer age,Integer sex){
        this.name = name;
        this.id = id;
        this.age = age;
        this.sex = sex;
    }

    @Id
    private ObjectId databaseId;
    private String name;
    private Integer id;
    private Integer age;
    private Integer sex;
}
