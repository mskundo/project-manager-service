//package com.cognizant;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cognizant.entity.User;
//import com.cognizant.repository.UserRepository;
//import com.cognizant.service.UserService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProjectManagerApplicationTests {
//
//	@Mock
//	private UserRepository userRepository;
//
//	@InjectMocks
//	private UserService userService;
//
//	@Before
//	public void setup(){
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testGetAll(){
//		List<User> user = new ArrayList<User>();
//		user.add(new User(1L,"Madhu","kundo","681173",1L,2L));
//		user.add(new User(2L,"Madhu","smita","675567",9L,2L));
//		when(userRepository.findAll()).thenReturn(user);
//		List<User> result = userService.getAll();
//		assertEquals(2, result.size());
//	}
//
//	@Test
//	public void testDeleteUser(){
//		User user = new User(1L,"Madhu","kundo","681173",1L,2L);
//		userService.deleteUser(user.getUserId());
//        verify(userRepository, times(1)).deleteById(user.getUserId());
//	}
//
//	@Test
//	public void testUpdateUser(){
//		User user = new User(1L,"Madhu","kundo","681173",null,null);
//		when(userRepository.save(user)).thenReturn(user);
//		User result = userService.updateUser(user, 1L);
//		assertEquals("Madhu", result.getFirstName());
//		assertEquals("kundo", result.getLastName());
//		assertEquals("681173", result.getEmpId());
//		assertEquals(null, result.getProjectId());
//		assertEquals(null ,result.getTaskId());
//	}
//
//
//
//}
