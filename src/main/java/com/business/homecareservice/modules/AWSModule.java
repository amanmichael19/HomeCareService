package com.business.homecareservice.modules;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import lombok.NonNull;

public class AWSModule extends AbstractModule {

    protected void configure(){
        String region = "us-west-2";
        bind(Regions.class).toInstance(Regions.fromName(region));
    }

    @Provides
    @Singleton
    public AWSCredentialsProvider getAWSCredentialsProvider(){
        return DefaultAWSCredentialsProviderChain.getInstance();
    }

    @Provides
    @Singleton
    public DynamoDBMapper dynamoDBMapper(@NonNull final AmazonDynamoDB dynamoDB){
        return new DynamoDBMapper(dynamoDB);
    }

    @Provides
    @Singleton
    public AmazonDynamoDB amazonDynamoDB(@NonNull final Regions region){
        return AmazonDynamoDBClientBuilder.standard()
                                          .withRegion(region)
                                          .build();
    }
}
