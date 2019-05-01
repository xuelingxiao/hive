package com.xlx.product.repository.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.err.println("获取到的是: " + DbTypeContextHolder.get().name());
        return DbTypeContextHolder.get();
    }
}
