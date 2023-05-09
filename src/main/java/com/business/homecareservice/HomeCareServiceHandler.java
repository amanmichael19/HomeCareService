package com.business.homecareservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.business.homecareservice.servicelayer.activity.CreatePatientProfileActivity;
import com.business.homecareservice.servicelayer.activity.GetPatientProfileActivity;
import com.business.homecareservice.servicelayer.activity.UpdatePatientProfileActivity;

import lombok.NonNull;

public class HomeCareServiceHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	@NonNull
	private GetPatientProfileActivity getPatientProfileActivity;

	@NonNull 
	private CreatePatientProfileActivity createPatientProfileActivity;

	@NonNull
	private UpdatePatientProfileActivity updatePatientProfileActivity;

	@Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        return null;
    }

	public static void main(String[] args) {
	}

}
