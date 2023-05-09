package com.business.homecareservice.servicelayer.models.request;

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
public class GetPatientProfileRequest implements ISerializableRequest {

    @NonNull
    private String patientId;

    // need to specify withPrefix="" because lombok's @Builder creates methods with no prefix and jackson deserializer
    // needs to use those correct methods to create the object
    @JsonPOJOBuilder(withPrefix = "")
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
