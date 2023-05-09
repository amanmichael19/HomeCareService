package com.business.homecareservice.servicelayer.models.request;

import java.io.IOException;

import com.business.homecareservice.servicelayer.models.PatientProfile;
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
public class UpdatePatientProfileRequest implements ISerializableRequest {
    @NonNull
    private PatientProfile patientProfile;

    // need to specify withPrefix="" because lombok's @Builder creates methods with no prefix and jackson deserializer
    // needs to use those correct methods to create the object
    @JsonPOJOBuilder(withPrefix = "")
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