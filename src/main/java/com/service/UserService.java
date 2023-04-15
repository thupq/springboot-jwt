package com.service;

import com.dto.UserDataDTO;
import com.model.User;
import com.model.response.UserResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    String signin(String username, String password);

    UserResponse signup(User user);

    UserResponse updateUser(Long userId, UserDataDTO appUser);

    void delete(String username);

    UserResponse search(String username);

    User whoami(HttpServletRequest req);

    String refresh(String username);

    UserResponse createUser(UserDataDTO appUser);

    List<UserResponse> getAll();

}
