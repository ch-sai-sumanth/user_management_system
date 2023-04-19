package com.Geekster.user.management.system.controller;

import com.Geekster.user.management.system.model.User;
import com.Geekster.user.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   @Autowired
   UserService us;

    @PostMapping(value="addUser")
    public String addUserToService(@RequestBody User userData)
    {
        return us.addUserToDao(userData);
    }

    @GetMapping(value="getAllUsers")
    public List<User> getAllUsers()
    {
        return us.getAllUsers();
    }

    @GetMapping(value="getUser/{userid}")
    public User getUserById(@PathVariable String userid)
    {
        return us.getUser(userid);
    }

    @PutMapping(value="updateUserInfo/{userId}")
    public String updateUser(@PathVariable String userId,@RequestBody User updatedUserData)
    {
        return us.updateUser(userId,updatedUserData);
    }
    @DeleteMapping(value="deleteUser")
    public String deleteUser(@RequestBody String userId)
    {
        return us.deleteUser(userId);
    }
}
