package com.example.questionario.service;

import com.example.questionario.mapper.UserMapper;
import com.example.questionario.model.User;
import com.example.questionario.model.UserDTO;
import com.example.questionario.rest.RegistrazioneApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.questionario.repository.UserRepository;

@Service
public class UserService implements RegistrazioneApiDelegate {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseEntity<Void> saveUser(UserDTO userDTO) {
        userRepo.save(userMapper.convertUserDTOtoUser(userDTO));
        return ResponseEntity.ok(null);
    }
}
