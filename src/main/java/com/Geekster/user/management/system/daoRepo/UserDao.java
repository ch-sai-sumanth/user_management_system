package com.Geekster.user.management.system.daoRepo;

import com.Geekster.user.management.system.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    List<User> usersList=new ArrayList<>();


    public boolean addUser(User userData)
    {
        usersList.add(userData);
        return true;
    }

    public List<User> getAllUsers()
    {
        return usersList;
    }

    public User getUser(String userid)
    {
       for(User user:usersList)
       {
           String curUserId= String.valueOf(user.getUserId());

           if(curUserId.equals(userid))
               return user;
       }
       return null;
    }

    public boolean updateUser( String userId,User updatedUserData) {

        boolean status=false;
        for(User user:usersList)
        {
            String curUserId= String.valueOf(user.getUserId());

            if(curUserId.equals(userId))
            {
                usersList.remove(user);
                usersList.add(updatedUserData);
                status=true;
                break;
            }
        }
        return status;
    }
    public boolean deleteUser(String userId)
    {
        boolean status=false;
        for(User user:usersList)
        {
            String curUserId= String.valueOf(user.getUserId());

            if(curUserId.equals(userId))
            {
                usersList.remove(user);
                status=true;
                break;
            }
        }
        return status;
    }
}
