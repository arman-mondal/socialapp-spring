package com.arman.socialapp.Controllers;

import com.arman.socialapp.Models.Users;
import com.arman.socialapp.Services.UserServices;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;

    // Fix the constructor argument name and assignment:
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserById(@RequestParam("id") Long id) {
        Users user = userServices.getUserById(id);
        if (user == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public Users createUser(@RequestBody Users user) {
        return userServices.createUser(user);
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user) {
        return userServices.updateUser(user);
    }
}
