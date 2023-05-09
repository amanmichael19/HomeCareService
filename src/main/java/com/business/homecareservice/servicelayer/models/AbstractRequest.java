package com.business.homecareservice.servicelayer.models;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractRequest {
    protected static final ObjectMapper MAPPER = new ObjectMapper();

    protected abstract String toJson();
}
