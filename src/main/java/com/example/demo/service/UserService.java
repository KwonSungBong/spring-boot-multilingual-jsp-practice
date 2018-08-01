package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    public int insert(User user) {
        return userRepository.insert(user);
    }

    public int update(User user) {
        return userRepository.update(user);
    }

    public int delete(int id) {
        return userRepository.delete(id);
    }

}
