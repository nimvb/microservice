package com.example.nimvb.user.service;

import com.example.nimvb.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    UserRepository repository;
    @Override
    public boolean isEmailExists(String email) {
        return repository.existsByEmail(email);
    }
}
