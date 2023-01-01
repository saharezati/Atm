package com.sahar.atmspring.controller;

import com.sahar.atmspring.dto.UserDto;
import com.sahar.atmspring.entity.User;
import com.sahar.atmspring.mapper.UserMapper;
import com.sahar.atmspring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findall() {
        List<UserDto> userDto = userService.findall( );
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("")
    public ResponseEntity<UserDto> findbyid(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.findbyid(id));
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody @Valid UserDto userDto) {
        userService.saveOrUpdate(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletbyid(@PathVariable(name = "id") Long id) {
        userService.deletebyid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserDto> findbynationalcod(@RequestParam(name = "nationalcod") String nationalcod) {
        UserDto userDto = userService.findbynationalcod(nationalcod);
        return ResponseEntity.ok(userDto);
    }
}
