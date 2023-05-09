package com.business.homecareservice.servicelayer.models;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = PatientProfile.PatientProfileBuilder.class)
public class PatientProfile {
    @NonNull
    private String patientId;

    @NonNull
    private String careFacilityId;
    
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private Instant dateOfBirth;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class PatientProfileBuilder { }
}
