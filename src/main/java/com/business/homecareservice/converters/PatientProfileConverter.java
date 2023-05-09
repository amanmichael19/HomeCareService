package com.business.homecareservice.converters;

import com.business.homecareservice.persistencelayer.domain.PatientProfileItem;
import com.business.homecareservice.servicelayer.models.PatientProfile;

public class PatientProfileConverter {
    
    public static PatientProfile domainToService(PatientProfileItem domainItem){
        return PatientProfile.builder()
                             .patientId(domainItem.getPatientId())
                             .careFacilityId(domainItem.getCareFacilityId())
                             .firstName(domainItem.getFirstName())
                             .lastName(domainItem.getLastName())
                             .dateOfBirth(domainItem.getDateOfBirth())
                             .build();
    }

    public static PatientProfileItem serviceToDomain(PatientProfile serviceObject){
        return PatientProfileItem.builder()
                                 .patientId(serviceObject.getPatientId())
                                 .careFacilityId(serviceObject.getCareFacilityId())
                                 .firstName(serviceObject.getFirstName())
                                 .lastName(serviceObject.getLastName())
                                 .dateOfBirth(serviceObject.getDateOfBirth())
                                 .build();
    }
}
