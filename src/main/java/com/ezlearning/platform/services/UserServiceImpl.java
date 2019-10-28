package com.ezlearning.platform.services;

import com.ezlearning.platform.auth.AuthGroup;
import com.ezlearning.platform.auth.AuthGroupRepository;
import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private UserRepository userRepository;
    private AuthGroupRepository authGroupRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    public void createUser(UserDto userDto) throws Exception {
        if (null != userRepository.findByUsername(userDto.getUsername())) {
            throw new Exception("Ya existe un usuario con el nombre " + userDto.getUsername());
        }
        String username = userDto.getUsername();
        String password = new BCryptPasswordEncoder(11).encode(userDto.getPassword());
        User user = new User(username, password);
        AuthGroup group = new AuthGroup();

        group.setUsername(userDto.getUsername());
        group.setAuthgroup("USER");

        userRepository.save(user);
        authGroupRepository.save(group);
    }
}
