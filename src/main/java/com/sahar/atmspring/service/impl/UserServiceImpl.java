package com.sahar.atmspring.service.impl;

import com.sahar.atmspring.Exceptions.NotfoundException;
import com.sahar.atmspring.dto.UserDto;
import com.sahar.atmspring.entity.User;
import com.sahar.atmspring.mapper.UserMapper;
import com.sahar.atmspring.repository.UserRepository;
import com.sahar.atmspring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public void saveOrUpdate(UserDto userDto){
        userRepository.save(userMapper.toEntity(userDto));
    }
    @Override
    public UserDto findbyid(long id){
        return userMapper.toDto( userRepository.findById(id).orElseThrow( ()->{
            throw  new NotfoundException("user not found");
        } ));

    }
    @Override
    public List<UserDto>findall(){
        return userMapper.toDto(userRepository.findAll());

    }
    @Override
    public  void  deletebyid(long id){
        userRepository.deleteById(id);
    }
    @Override
    public void delete(UserDto userDto){
        userRepository.delete(userMapper.toEntity(userDto));
    }
    @Override
    public UserDto findbynationalcod(String nationalcod){
        return userMapper.toDto(userRepository.findByNationalcod( nationalcod).orElseThrow( () ->{
            throw new NotfoundException("not find user");
        }));
    }


}
