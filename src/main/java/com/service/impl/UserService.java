package com.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.common.constant.Constants;
import com.dto.UserDataDTO;
import com.exception.validator.ValidateException;
import com.model.response.UserResponse;
import com.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exception.CustomException;
import com.model.AppUser;
import com.repository.UserRepository;
import com.security.JwtTokenProvider;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(AppUser appUser) {
        if (!userRepository.existsByUsername(appUser.getUsername())) {
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            appUser.setCreatedBy(SecurityUtils.getCurrentUser());
            appUser.setCreatedDate(LocalDateTime.now());
            appUser.setLastUpdatedBy(SecurityUtils.getCurrentUser());
            appUser.setLastUpdatedDate(LocalDateTime.now());
            userRepository.save(appUser);
            return jwtTokenProvider.createToken(appUser.getUsername(), appUser.getAppUserRoles());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public UserResponse updateUser(Long userId, UserDataDTO appUser) {
//        List<AppUser> listUser = userRepository.findByUsernameActive(appUser.getUsername(), Integer.parseInt(Constants.STATUS.ACTIVE));
        AppUser user = userRepository.findById(userId).orElseThrow(() -> new ValidateException("User không tồn tại hoặc đã bị xóa"));

        if (Constants.STATUS.ACTIVE.equals(user.getStatus())) {
            throw new ValidateException("User không tồn tại hoặc đã bị xóa");
        }
        AppUser response = modelMapper.map(appUser, AppUser.class);
        response.setPassword(passwordEncoder.encode(appUser.getPassword()));
        response.setLastUpdatedBy(SecurityUtils.getCurrentUser());
        response.setLastUpdatedDate(LocalDateTime.now());
        userRepository.save(response);

        return modelMapper.map(response, UserResponse.class);

    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public AppUser search(String username) {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return appUser;
    }

    public AppUser whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRoles());
    }

}
