package com.Geekster.user.management.system.service;

import com.Geekster.user.management.system.daoRepo.UserDao;
import com.Geekster.user.management.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao ur;

    public String addUserToDao(User userData)
    {
        boolean status=ur.addUser(userData);
        return status?"user data saved succesfully":"failed to save data";
    }

    public List<User> getAllUsers()
    {
        return ur.getAllUsers();
    }

    public User getUser(String userid)
    {
        return ur.getUser(userid);
    }

    public String updateUser( String userId,User updatedUserData)
    {
        boolean status=ur.updateUser(userId,updatedUserData);
        if(status)
            return "updated succesfully";

        return "no such user found, please enter correct userId to update";
    }
    public String deleteUser(String userId)
    {
        boolean status=ur.deleteUser(userId);

        if(status)
            return "deleted succesfully";

        return "no such user found, please enter correct userId to delete";
    }
}
