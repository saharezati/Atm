package com.sahar.atmspring.mapper;

import com.sahar.atmspring.dto.UserDto;
import com.sahar.atmspring.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaesMapper<User, UserDto> {
}
