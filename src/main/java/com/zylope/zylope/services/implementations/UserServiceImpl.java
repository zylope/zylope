package com.zylope.zylope.services.implementations;

import com.zylope.zylope.dto.LoginDTO;
import com.zylope.zylope.models.User;
import com.zylope.zylope.repository.PostRepository;
import com.zylope.zylope.repository.UserRepository;
import com.zylope.zylope.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public String createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())){
            return "This username is already taken";
        }
        if (userRepository.existsByEmail(user.getEmail())){
            return "This email is already taken";
        }
        userRepository.save(new User(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                this.passwordEncoder.encode(user.getPassword()),
                user.getEmail(),
                user.getSex(),
                user.getCountry()));
        return "Success";
    }

    @Override
    public String loginUser(LoginDTO loginDTO){
        Optional<User> u1 = userRepository.findByEmail(loginDTO.getEmail());
        if(u1.isPresent()) {
            String password = loginDTO.getPassword();
            String encodedPassword = u1.get().getPassword();
            if (passwordEncoder.matches(password,encodedPassword)){
                return "Login Success";
            } else {
                return "Password not match";
            }
        } else {
            return "email not exist";
        }
    }
}
