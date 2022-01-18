package com.doctor.api.dtos;

import com.doctor.api.models.User;
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

    public SimpleUserDTO mapToSimpleUserDTO(User user){
        return modelMapper.map(user,SimpleUserDTO.class);
    }




}
