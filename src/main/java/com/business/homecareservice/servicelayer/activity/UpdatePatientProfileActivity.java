package com.business.homecareservice.servicelayer.activity;

import com.business.homecareservice.persistencelayer.dao.PatientProfileDao;
import com.business.homecareservice.servicelayer.models.UpdatePatientProfileRequest;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(onConstructor = @__({@Inject}))
public class UpdatePatientProfileActivity {
    @NonNull
    private PatientProfileDao patientProfileDao;

    public void call(UpdatePatientProfileRequest input){

    }
}
