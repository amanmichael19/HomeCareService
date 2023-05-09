package com.business.homecareservice.servicelayer.models;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper=false)
@Builder(toBuilder = true)
@JsonDeserialize(builder = GetPatientProfileRequest.GetPatientProfileRequestBuilder.class)
public class GetPatientProfileRequest extends AbstractRequest {

    @NonNull
    private String patientId;

    @JsonPOJOBuilder(withPrefix = "with")
    public static final class GetPatientProfileRequestBuilder { }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public String toJson(){
        return MAPPER.writer().writeValueAsString(this);
    }

    @SneakyThrows(IOException.class)
    public static GetPatientProfileRequest fromJson(final String jsonRequest){
        return MAPPER.reader() 
                     .forType(GetPatientProfileRequest.class)
                     .readValue(jsonRequest);
    }
}
