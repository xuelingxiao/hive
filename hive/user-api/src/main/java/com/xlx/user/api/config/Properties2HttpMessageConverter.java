package com.xlx.user.api.config;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class Properties2HttpMessageConverter extends AbstractHttpMessageConverter<Person> {

    public Properties2HttpMessageConverter(){
        super(MediaType.valueOf("application/properties+person"));
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream= outputMessage.getBody();
        Properties properties = new Properties();
        properties.put("name",person.getName());
        properties.put("id",person.getId());
        properties.store(new OutputStreamWriter(outputStream, Charset.forName("utf-8")) ,"# properties message converter");
    }

    @Override
    protected boolean supports(Class clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    protected Person readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream im= inputMessage.getBody();
        Person person = new Person();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(im));
        person.setId(properties.get("id").toString());
        person.setName(properties.get("name").toString());
        return person;
    }
}
