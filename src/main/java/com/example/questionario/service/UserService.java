package com.example.questionario.service;

import com.example.questionario.mapper.UserMapper;
import com.example.questionario.model.User;
import com.example.questionario.model.UserDTO;
import com.example.questionario.rest.EliminaUtenteidApiDelegate;
import com.example.questionario.rest.RegistrazioneApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.questionario.repository.UserRepository;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Service
public class UserService implements RegistrazioneApiDelegate, EliminaUtenteidApiDelegate {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return RegistrazioneApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> saveUser(UserDTO userDTO) {
        userRepo.save(userMapper.convertUserDTOtoUser(userDTO));
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
