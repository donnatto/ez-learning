package com.ezlearning.platform.services.core.impl;

import com.ezlearning.platform.auth.AuthGroup;
import com.ezlearning.platform.auth.AuthGroupRepository;
import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.dto.UserDto;
import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

@Service
@Slf4j
public class UserServiceImpl {

    private AmazonS3ClientService s3ClientService;
    private UserRepository userRepository;
    private AuthGroupRepository authGroupRepository;

    @Autowired
    public UserServiceImpl(AmazonS3ClientService s3ClientService, UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.s3ClientService = s3ClientService;
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    public void createUser(UserDto userDto, MultipartFile image) throws Exception {

        if (null != userRepository.findByUsername(userDto.getUsername())) {
            throw new Exception("Ya existe un usuario con el nombre " + userDto.getUsername());
        } else if (null != userRepository.findByEmail(userDto.getEmail())) {
            throw new Exception("Ya existe un usuario con el email " + userDto.getEmail());
        }
        String username = userDto.getUsername();
        String password = new BCryptPasswordEncoder(11).encode(userDto.getPassword());
        String nombre = userDto.getNombre();
        String apellido = userDto.getApellido();
        String email = userDto.getEmail();
        log.info("Getting image");
        log.info("about to upload");
        String imgurl = s3ClientService.upload(convert(image), image.getOriginalFilename()).toString();
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

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
