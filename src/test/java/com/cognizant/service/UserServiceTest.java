package com.cognizant.service;


import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;
import com.cognizant.util.UserMockData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @InjectMocks
    public UserService userService;

    @Mock
    public UserRepository userRepository;

    @Test
    public void saveUserTest(){
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new UserMockData().getSingleUser());
        User output = userService.saveUser(new UserMockData().getUserRecord());

        Assert.assertEquals(new UserMockData().getSingleUser().getUserId(),output.getUserId());
        Assert.assertEquals(new UserMockData().getSingleUser().getFirstName(),output.getFirstName());
        Assert.assertEquals(new UserMockData().getSingleUser().getLastName(),output.getLastName());
        Assert.assertEquals(new UserMockData().getSingleUser().getEmpId(),output.getEmpId());
    }

    @Test
    public void updateUserTest(){

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new UserMockData().getSingleUser());

        User output = userService.updateUser(new UserMockData().getSingleUserNoUserId(), (long)1);

        Assert.assertEquals(new UserMockData().getSingleUser().getUserId(),output.getUserId());
        Assert.assertEquals(new UserMockData().getSingleUser().getFirstName(),output.getFirstName());
        Assert.assertEquals(new UserMockData().getSingleUser().getLastName(),output.getLastName());
        Assert.assertEquals(new UserMockData().getSingleUser().getEmpId(),output.getEmpId());

    }

    @Test
    public void updateTaskIdUserTest(){

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new UserMockData().getSingleUserWithTaskId());

        User output = userService.updateTaskIdUser((long)1, new UserMockData().getSingleUser());

        Assert.assertEquals(new UserMockData().getSingleUser().getUserId(),output.getUserId());
        Assert.assertEquals(new UserMockData().getSingleUser().getFirstName(),output.getFirstName());
        Assert.assertEquals(new UserMockData().getSingleUser().getLastName(),output.getLastName());
        Assert.assertEquals(new UserMockData().getSingleUser().getEmpId(),output.getEmpId());
        Assert.assertEquals(new UserMockData().getSingleUser().getTaskId(),output.getTaskId());

    }

    @Test
    public void deleteUserTest(){

        String output = userService.deleteUser((long)1);

        Assert.assertEquals("user deleted successfully", output);
    }

    @Test
    public void getAllTest(){
        Mockito.when(userRepository.findAll()).thenReturn(new UserMockData().getUserList());
        List<User> output = userService.getAll();

        Assert.assertEquals(2,output.size());


    }

    @Test
    public void updatProjectIdUserTest(){
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new UserMockData().getSingleUserWithProjectId());

        User output = userService.updatProjectIdUser((long)1, new UserMockData().getSingleUser());

        Assert.assertEquals(new UserMockData().getSingleUser().getUserId(),output.getUserId());
        Assert.assertEquals(new UserMockData().getSingleUser().getFirstName(),output.getFirstName());
        Assert.assertEquals(new UserMockData().getSingleUser().getLastName(),output.getLastName());
        Assert.assertEquals(new UserMockData().getSingleUser().getEmpId(),output.getEmpId());
        Assert.assertEquals(new UserMockData().getSingleUser().getProjectId(),output.getProjectId());
    }


}
