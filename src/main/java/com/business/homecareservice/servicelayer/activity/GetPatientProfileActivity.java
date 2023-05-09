package com.business.homecareservice.servicelayer.activity;

import com.business.homecareservice.persistencelayer.dao.PatientProfileDao;
import com.business.homecareservice.servicelayer.models.GetPatientProfileRequest;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(onConstructor = @__({@Inject}))
public class GetPatientProfileActivity {

    @NonNull
    private PatientProfileDao patientProfileDao;

    public void call(GetPatientProfileRequest input){
        
    }

    
}
