package com.zylope.zylope.services;
import com.zylope.zylope.dto.LoginDTO;
import com.zylope.zylope.models.User;
public interface UserService {
    String createUser(User user);
    String loginUser(LoginDTO loginDTO);
}
