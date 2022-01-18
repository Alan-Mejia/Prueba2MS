package com.doctor.doctorservice.dtos;

import com.doctor.doctorservice.models.Doctor;
import org.modelmapper.ModelMapper;

public class GenericMapperDTO {
    private final ModelMapper modelMapper = new ModelMapper();

    private static GenericMapperDTO genericMapperDTO;

    private GenericMapperDTO(){}

    public static GenericMapperDTO singleInstance(){
        if(genericMapperDTO == null){
            genericMapperDTO = new GenericMapperDTO();
        }
        return genericMapperDTO;
    }

    public SimpleDoctorDTO mapToSimpleDoctorDTO(Doctor doctor){
        return modelMapper.map(doctor, SimpleDoctorDTO.class);
    }




}
