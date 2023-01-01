package com.sahar.atmspring.service;

import com.sahar.atmspring.dto.UserDto;
import com.sahar.atmspring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveOrUpdate(UserDto userDto);

    UserDto findbyid(long id);

    List<UserDto> findall();

    void  deletebyid(long id);

    void delete(UserDto userDto);

     UserDto findbynationalcod(String nationalcod);
}
