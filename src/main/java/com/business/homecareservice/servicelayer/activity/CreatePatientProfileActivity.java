package com.business.homecareservice.servicelayer.activity;

import com.business.homecareservice.converters.PatientProfileConverter;
import com.business.homecareservice.persistencelayer.dao.PatientProfileDao;
import com.business.homecareservice.persistencelayer.domain.PatientProfileItem;
import com.business.homecareservice.servicelayer.models.request.CreatePatientProfileRequest;
import com.business.homecareservice.servicelayer.models.response.CreatePatientProfileResponse;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(onConstructor = @__({@Inject}))
public class CreatePatientProfileActivity {
    @NonNull
    private PatientProfileDao patientProfileDao;

    public CreatePatientProfileResponse call(CreatePatientProfileRequest input){
        PatientProfileItem patientProfileItem = PatientProfileConverter.serviceToDomain(input.getPatientProfile());
        patientProfileDao.setPatientProfileItem(patientProfileItem);
        return CreatePatientProfileResponse.builder()
                                           .patientProfile(input.getPatientProfile())
                                           .build();
    }
}
