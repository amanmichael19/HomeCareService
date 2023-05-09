package com.business.homecareservice.modules;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class ApplicationModule extends AbstractModule {

    protected void configure(){
        String region = "us-west-2";
        bind(Regions.class).toInstance(Regions.fromName(region));
    }

    @Provides
    @Singleton
    public AWSCredentialsProvider getAWSCredentialsProvider(){
        return DefaultAWSCredentialsProviderChain.getInstance();
    }

    
}
