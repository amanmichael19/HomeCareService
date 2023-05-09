package com.business.homecareservice.servicelayer.models;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.Value;


@Builder(toBuilder = true)
@Value
@EqualsAndHashCode(callSuper = false)
@JsonDeserialize(builder = UpdatePatientProfileRequest.UpdatePatientProfileRequestBuilder.class)
public class UpdatePatientProfileRequest extends AbstractRequest {
    @NonNull
    private String careFacilityId;

    @NonNull
    private String patientId;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private Instant birthDate;

    @JsonPOJOBuilder(withPrefix = "with")
    public static final class UpdatePatientProfileRequestBuilder { }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public String toJson(){
        return MAPPER.writer().writeValueAsString(this);
    }

    @SneakyThrows(IOException.class)
    public static UpdatePatientProfileRequest fromJson(final String jsonRequest){
        return MAPPER.reader() 
                     .forType(UpdatePatientProfileRequest.class)
                     .readValue(jsonRequest);
    }
}