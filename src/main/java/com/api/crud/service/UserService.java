package com.api.crud.service;

import com.api.crud.model.UserModel;
import com.api.crud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();

    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public UserModel updateById(UserModel recuest, Long id){
        UserModel user = userRepository.findById(id).get();

        user.setFirtsName(recuest.getFirtsName());
        user.setLastName(recuest.getLastName());
        user.setEmail(recuest.getEmail());

        return user;
    }

    public Boolean deleteUser(long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
