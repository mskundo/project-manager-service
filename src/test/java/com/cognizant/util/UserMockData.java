package com.cognizant.util;

import com.cognizant.entity.User;
import com.cognizant.model.UserRecord;

import java.util.ArrayList;
import java.util.List;

public class UserMockData {

    public UserRecord getUserRecord(){

        return new UserRecord(
                (long)1,"Sam","Smith","101"
        );
    }

    public User getSingleUser(){
        return new User(
                (long)1,
                "Sam",
                "Smith",
                "101",
                (long)0,
                (long)0
        );
    }

    public User getSingleUserNoUserId(){
        return new User(
                "Sam",
                "Smith",
                "101"
        );
    }

    public User getSingleUserWithTaskId(){
        return new User(
                (long)1,
                "Sam",
                "Smith",
                "101",
                (long)1,
                (long)0
        );
    }

    public User getSingleUserWithProjectId(){
        return new User(
                (long)1,
                "Sam",
                "Smith",
                "101",
                (long)0,
                (long)1
        );
    }

    public List<User> getUserList(){

        List<User> userList = new ArrayList();

        userList.add(new User(
                (long)1,
                "Sam",
                "Smith",
                "101",
                (long)0,
                (long)0));

        userList.add(new User(
                (long)2,
                "Jom",
                "Smith",
                "102",
                (long)0,
                (long)0));

        return userList;
    }
}
