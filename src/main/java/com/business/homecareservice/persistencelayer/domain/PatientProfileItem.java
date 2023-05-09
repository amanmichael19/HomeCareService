package com.business.homecareservice.persistencelayer.domain;

import java.time.Instant;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@DynamoDBTable(tableName = "PatientProfile")
public class PatientProfileItem {

    @NonNull
    @DynamoDBHashKey(attributeName = DomainConstants.PATIENTID)
    @DynamoDBIndexRangeKey(attributeName = DomainConstants.PATIENTID, 
        globalSecondaryIndexNames = {DomainConstants.CAREFACILITYID_PATIENTID_INDEX})
    private String patientId;

    @NonNull
    @DynamoDBIndexHashKey(attributeName = "CareFacilityId",
        globalSecondaryIndexNames = {DomainConstants.CAREFACILITYID_PATIENTID_INDEX})
    private String careFacilityId;
    
    
    // DynamoDBRangeKey
    @NonNull
    @DynamoDBAttribute(attributeName = "FirstName")
    private String firstName;

    @NonNull
    @DynamoDBAttribute(attributeName = "LastName")
    private String lastName;

    @NonNull
    @DynamoDBAttribute(attributeName = "DateOfBirth")
    @DynamoDBTypeConverted(converter = InstantConverter.class)
    private Instant dateOfBirth;

}