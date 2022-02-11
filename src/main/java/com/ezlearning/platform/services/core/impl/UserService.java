package com.ezlearning.platform.services.core.impl;

import com.ezlearning.platform.auth.AuthGroup;
import com.ezlearning.platform.auth.AuthGroupRepository;
import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public void createUser(UserDto userDto) throws IllegalStateException {

        if (null != userRepository.findByUsername(userDto.getUsername())) {
            throw new IllegalStateException("Ya existe un usuario con el nombre " + userDto.getUsername());
        } else if (null != userRepository.findByEmail(userDto.getEmail())) {
            throw new IllegalStateException("Ya existe un usuario con el email " + userDto.getEmail());
        }
        String username = userDto.getUsername();
        String password = new BCryptPasswordEncoder(11).encode(userDto.getPassword());
        String nombre = userDto.getNombre();
        String apellido = userDto.getApellido();
        String email = userDto.getEmail();
        log.info("Getting image");
        log.info("about to upload");
        String imgurl = userDto.getImgurl();
        LocalDate fecha = LocalDate.now();
        User user = new User(username, password, nombre, apellido, email, imgurl, fecha);
        AuthGroup group = new AuthGroup();

        group.setUsername(userDto.getUsername());
        group.setAuthgroup("USER");

        userRepository.save(user);
        authGroupRepository.save(group);
    }

    public void update(User user) {
        User current = userRepository.findByUsername(user.getUsername());

        current.setNombre(user.getNombre());
        current.setApellido(user.getApellido());
        current.setEmail(user.getEmail());
        current.setImgurl(user.getImgurl());

        userRepository.save(current);
    }

    public void patch(User user) {
        User current = userRepository.findByUsername(user.getUsername());

        current.setDetalle(user.getDetalle());

        userRepository.save(current);
    }
}
