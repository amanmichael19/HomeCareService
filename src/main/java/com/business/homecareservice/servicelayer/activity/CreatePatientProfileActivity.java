package com.business.homecareservice.servicelayer.activity;

import com.business.homecareservice.persistencelayer.dao.PatientProfileDao;
import com.business.homecareservice.servicelayer.models.CreatePatientProfileRequest;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(onConstructor = @__({@Inject}))
public class CreatePatientProfileActivity {
    @NonNull
    private PatientProfileDao patientProfileDao;

    public void call(CreatePatientProfileRequest input){
        
    }
}
