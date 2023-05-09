package com.business.homecareservice.persistencelayer.dao;

import java.util.Optional;

import com.amazonaws.SdkBaseException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.business.homecareservice.persistencelayer.domain.PatientProfileItem;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor(onConstructor = @__({@Inject}))
@Singleton
@Log4j2
public class PatientProfileDao {
    @NonNull
    private final DynamoDBMapper dynamoDBMapper;
    // TODO: Add converters
    // @NonNull
    // private final PatientProfileConverter patientProfileConverter;

    public Optional<PatientProfileItem> getPatientProfileItem(@NonNull final String patientId) {
        PatientProfileItem patientProfileItem;
        try {
            patientProfileItem = dynamoDBMapper.load(PatientProfileItem.class, patientId);
        } catch(SdkBaseException e) {
            log.error("Exception thrown when getting patient profile with patientId={}.", 
                patientId, e);
            throw e;
        }
        return Optional.ofNullable(patientProfileItem);
    }

    public void setPatientProfileItem(@NonNull final PatientProfileItem patientProfileItem) {
        try {
            dynamoDBMapper.save(patientProfileItem);
        } catch(SdkBaseException e) {
            log.error("Exception thrown when setting patient profile with patientProfileItem={}.", 
                patientProfileItem, e);
            throw e;
        }
    }
}
