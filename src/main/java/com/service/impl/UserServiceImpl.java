package com.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.common.constant.Constants;
import com.dto.UserDataDTO;
import com.exception.validator.ValidateException;
import com.model.response.UserResponse;
import com.security.SecurityUtils;
import com.service.UserService;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

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
            throw new ValidateException("Invalid username/password supplied");
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
            throw new ValidateException("Username is already in use");
        }
    }

    public UserResponse updateUser(Long userId, UserDataDTO appUser) {
//        List<AppUser> listUser = userRepository.findByUsernameActive(appUser.getUsername(), Integer.parseInt(Constants.STATUS.ACTIVE));
        AppUser user = userRepository.findById(userId).orElseThrow(() -> new ValidateException("User không tồn tại hoặc đã bị xóa"));

        if (Constants.STATUS.ACTIVE.equals(user.getStatus())) {
            throw new ValidateException("User không tồn tại hoặc đã bị xóa");
        }
//        AppUser response = modelMapper.map(appUser, AppUser.class);
        user.setPassword(passwordEncoder.encode(appUser.getPassword()));
        user.setLastUpdatedBy(SecurityUtils.getCurrentUser());
        user.setLastUpdatedDate(LocalDateTime.now());
        userRepository.save(user);

        return modelMapper.map(user, UserResponse.class);

    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public UserResponse search(String username) {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser == null) {
//            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
            throw new ValidateException("User không tồn tại hoặc đã bị xóa");
        }
        return modelMapper.map(appUser, UserResponse.class);
    }

    public AppUser whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRoles());
    }

    @Override
    public UserResponse createUser(UserDataDTO appUser) {
        if (!userRepository.existsByUsername(appUser.getUsername())) {
            AppUser au = modelMapper.map(appUser, AppUser.class);
            au.setPassword(passwordEncoder.encode(appUser.getPassword()));
            au.setStatus(Integer.valueOf(Constants.STATUS.ACTIVE));
            au.setCreatedBy(SecurityUtils.getCurrentUser());
            au.setCreatedDate(LocalDateTime.now());
            au.setLastUpdatedBy(SecurityUtils.getCurrentUser());
            au.setLastUpdatedDate(LocalDateTime.now());
            userRepository.save(au);
            return modelMapper.map(au, UserResponse.class);
        } else {
            throw new ValidateException("Username đã được sử dụng");
//            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @Override
    public List<UserResponse> getAll() {
        List<UserResponse> responseList = userRepository.findAll().stream()
                .map(u -> {
                    return modelMapper.map(u, UserResponse.class);
                }).collect(Collectors.toList());
        return null;
    }

}
