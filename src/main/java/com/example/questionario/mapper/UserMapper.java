package com.example.questionario.mapper;

import com.example.questionario.model.User;
import com.example.questionario.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper ISTANCE = Mappers.getMapper(UserMapper.class);


    User convertUserDTOtoUser (UserDTO userDTO);

}
