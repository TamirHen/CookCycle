package com.cookCycle.junitTests;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.User;
import com.cookCycle.repository.UserRepository;
import com.cookCycle.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserTests {

    @Mock
    private UserRepository userMockRepository;

    @InjectMocks
    private UserService userMockService;

    @Test
    public void getAllUsersShouldReturnCorrectNumberOfUsers() {
        final List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            users.add(new User("test" + i + "@cookcycle.com"));
        }
        Mockito.when(userMockRepository.findAll()).thenReturn(users);
        final List<User> expected = userMockService.getAllUsers();

        Assert.assertEquals(expected.size(), users.size());
    }

    @Test
    public void whenCallingGetByUsernameItCallsFindByIdOnce() throws Throwable {
        final String username = "test@cookcycle.com";
        final User user = new User(username);
        Mockito.when(userMockRepository.findById(username)).thenReturn(Optional.of(user));
        final User expected = userMockService.getUserByUsername(username);
        Mockito.verify(userMockRepository, Mockito.times(1)).findById(username);
    }

    @Test
    public void whenCallingGetByUsernameItReturnsUserObject() throws Throwable {
        final String username = "test@cookcycle.com";
        final User user = new User(username);
        Mockito.when(userMockRepository.findById(username)).thenReturn(Optional.of(user));
        final User expected = userMockService.getUserByUsername(username);
        Assert.assertNotNull(expected);
        Assert.assertEquals(user, expected);

    }

    @Test
    public void whenCreatingUserItCallsSaveOnce() {
        final User user = new User("test@cookcycle.com");
        Mockito.when(userMockRepository.save(Mockito.any(User.class))).thenReturn(user);
        userMockService.addUser(user);

        Mockito.verify(userMockRepository, Mockito.times(1)).save(user);
    }

}
