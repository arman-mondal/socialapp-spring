package com.arman.socialapp.Services;

import com.arman.socialapp.Models.Users;
import com.arman.socialapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Users createUser(Users user){

        return userRepository.save(user);
    }
    public Users getUserById(Long id){
        return userRepository.findById(id).orElse(null);

    }
    public Users getUserByEmail(String email){
        return userRepository.findByEmail(email);

    }
    public Users deleteUserById(Long id){
        Users user=userRepository.findById(id).orElse(null);
         userRepository.delete(user);
        return user;
    }
    public Users updateUser(Users user){
        return userRepository.save(user);
    }
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }



}
