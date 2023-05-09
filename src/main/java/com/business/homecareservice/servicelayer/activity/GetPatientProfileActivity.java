package com.business.homecareservice.servicelayer.activity;

import java.util.Optional;

import com.business.homecareservice.converters.PatientProfileConverter;
import com.business.homecareservice.persistencelayer.dao.PatientProfileDao;
import com.business.homecareservice.persistencelayer.domain.PatientProfileItem;
import com.business.homecareservice.servicelayer.models.PatientProfile;
import com.business.homecareservice.servicelayer.models.request.GetPatientProfileRequest;
import com.business.homecareservice.servicelayer.models.response.GetPatientProfileResponse;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(onConstructor = @__({@Inject}))
public class GetPatientProfileActivity {

    @NonNull
    private PatientProfileDao patientProfileDao;

    public GetPatientProfileResponse call(GetPatientProfileRequest input){
        Optional<PatientProfileItem> patientProfileItemOptional =  patientProfileDao.getPatientProfileItem(input.getPatientId());
        PatientProfile patientProfile = PatientProfileConverter.domainToService(patientProfileItemOptional.get());
        return GetPatientProfileResponse.builder()
                                        .patientProfile(patientProfile)
                                        .build();
    }
}
