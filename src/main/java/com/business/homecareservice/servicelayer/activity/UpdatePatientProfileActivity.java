package com.business.homecareservice.servicelayer.activity;

import com.business.homecareservice.converters.PatientProfileConverter;
import com.business.homecareservice.persistencelayer.dao.PatientProfileDao;
import com.business.homecareservice.persistencelayer.domain.PatientProfileItem;
import com.business.homecareservice.servicelayer.models.PatientProfile;
import com.business.homecareservice.servicelayer.models.request.UpdatePatientProfileRequest;
import com.business.homecareservice.servicelayer.models.response.UpdatePatientProfileResponse;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(onConstructor = @__({@Inject}))
public class UpdatePatientProfileActivity {
    @NonNull
    private PatientProfileDao patientProfileDao;

    public UpdatePatientProfileResponse call(UpdatePatientProfileRequest input){
        PatientProfile inputPatientProfile = input.getPatientProfile();
        PatientProfileItem prevPatientProfileItem = patientProfileDao.getPatientProfileItem(inputPatientProfile.getPatientId()).get();
        if (prevPatientProfileItem != null){
            PatientProfileItem updatedItem = updatePatientProfile(prevPatientProfileItem, inputPatientProfile);
            patientProfileDao.setPatientProfileItem(updatedItem);
            return UpdatePatientProfileResponse.builder()
                                               .patientProfile(PatientProfileConverter.domainToService(updatedItem))
                                               .build();
        }
        // TODO: handle exceptions
        return null;
    }

    private PatientProfileItem updatePatientProfile(PatientProfileItem prevItem,
                                                    PatientProfile input){
        return PatientProfileItem.builder()
                                 .patientId(prevItem.getPatientId()) // don't update the ID as it is the primary key
                                 .careFacilityId(input.getCareFacilityId() != null ? input.getCareFacilityId() : prevItem.getCareFacilityId())
                                 .firstName(input.getFirstName() != null ? input.getFirstName() : prevItem.getFirstName())
                                 .lastName(input.getLastName() != null ? input.getLastName() : prevItem.getLastName())
                                 .build();
    }
}
