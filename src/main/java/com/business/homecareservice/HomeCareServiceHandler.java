package com.business.homecareservice;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.business.homecareservice.modules.ApplicationInjector;
import com.business.homecareservice.servicelayer.activity.CreatePatientProfileActivity;
import com.business.homecareservice.servicelayer.activity.GetPatientProfileActivity;
import com.business.homecareservice.servicelayer.activity.UpdatePatientProfileActivity;
import com.business.homecareservice.servicelayer.models.request.CreatePatientProfileRequest;
import com.business.homecareservice.servicelayer.models.request.GetPatientProfileRequest;
import com.business.homecareservice.servicelayer.models.request.UpdatePatientProfileRequest;
import com.business.homecareservice.servicelayer.models.response.ISerializableResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Singleton;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Singleton
@AllArgsConstructor
public class HomeCareServiceHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	@NonNull
	private GetPatientProfileActivity getPatientProfileActivity;

	@NonNull 
	private CreatePatientProfileActivity createPatientProfileActivity;

	@NonNull
	private UpdatePatientProfileActivity updatePatientProfileActivity;

	public HomeCareServiceHandler() {
		this(ApplicationInjector.getInjector().getInstance(GetPatientProfileActivity.class),
			 ApplicationInjector.getInjector().getInstance(CreatePatientProfileActivity.class),
			 ApplicationInjector.getInjector().getInstance(UpdatePatientProfileActivity.class));
	}

	@Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

		LambdaLogger logger = context.getLogger();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		logger.log("Handler input: " + gson.toJson(input));

		ISerializableResponse response = routeRequest(input, logger);

		logger.log("Handler output: " + gson.toJson(response));
        return new APIGatewayProxyResponseEvent().withBody(response.toJson())
												 .withStatusCode(200);
    }

	private ISerializableResponse routeRequest(APIGatewayProxyRequestEvent input, LambdaLogger logger){
		if(input.getPath().contains("getpatientprofile")){
			logger.log("Path contains getpatientprofile");
			Map<String, String> params = input.getQueryStringParameters();
			GetPatientProfileRequest request = GetPatientProfileRequest.builder()
															           .patientId(params.get("patientId"))
																	   .build();
			return getPatientProfileActivity.call(request);
		} else if(input.getPath().contains("createpatientprofile")){
			logger.log("Path contains createpatientprofile");
			CreatePatientProfileRequest request = CreatePatientProfileRequest.fromJson(input.getBody());
			return createPatientProfileActivity.call(request);
		} else if(input.getPath().contains("updatepatientprofile")){
			logger.log("Path contains updatepatientprofile");
			UpdatePatientProfileRequest request = UpdatePatientProfileRequest.fromJson(input.getBody());
			return updatePatientProfileActivity.call(request);
		}
		return null;
	}

	public static void main(String[] args) {
		// Quick test - TODO: DELETE and create unit tests
		// String body = "{\"patientProfile\": {\"patientId\": \"1\",\"careFacilityId\": \"home1\",\"firstName\": \"Abebe\",\"lastName\": \"Bela\",\"dateOfBirth\": \"1990-01-01T00:00:00Z\"}}";
		// CreatePatientProfileRequest request = CreatePatientProfileRequest.fromJson(body);
		// System.out.println(request.getPatientProfile().getFirstName());
		// System.out.println(request.toJson());
	}

}
