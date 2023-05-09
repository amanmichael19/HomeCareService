package com.business.homecareservice.persistencelayer.domain;

import java.time.Instant;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class InstantConverter implements DynamoDBTypeConverter<String, Instant> {
    
    @Override
    public String convert(final Instant instant){
        return instant == null ? null : instant.toString();
    }

    @Override
    public Instant unconvert(final String strObj){
        return strObj == null ? null : Instant.parse(strObj);
    }
}
