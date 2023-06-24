package com.example.test.Service;

import com.example.test.DTO.UserDTO;
import com.example.test.Entity.UserEntity;
import com.example.test.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO save() {
        UserEntity userEntity = new UserEntity();
        return UserDTO.toDTO(userRepository.save(userEntity));
    }
}
