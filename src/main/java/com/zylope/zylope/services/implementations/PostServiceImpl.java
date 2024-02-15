package com.zylope.zylope.services.implementations;

import com.zylope.zylope.repository.PostRepository;
import com.zylope.zylope.repository.UserRepository;
import com.zylope.zylope.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
}
