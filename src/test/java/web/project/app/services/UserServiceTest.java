package web.project.app.services;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import web.project.app.model.Role;
import web.project.app.model.User;
import web.project.app.repositories.UserRepository;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private MailSender sender;
    @MockBean
    private PasswordEncoder encoder;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setEmail("somemail@gmail.com");
        boolean isUserCreated = userService.addUser(user);
        Assert.assertTrue(isUserCreated);
        Assert.assertNotNull(user.getActivationCode());
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Mockito.verify(sender, Mockito.times(1)).
                send(ArgumentMatchers.eq(user.getEmail()),
                        ArgumentMatchers.eq("Activation code"),
                        ArgumentMatchers.contains("Welcome to ReTwitter"));
    }

    @Test
    public void addUserFailTest() {
        User user = new User();
        user.setUsername("admin");
        doReturn(new User())
                .when(userRepository).findByUsername("admin");
        boolean isUserCreated = userService.addUser(user);
        Assert.assertFalse(isUserCreated);
        Mockito.verify(userRepository, Mockito.times(0)).save(any(User.class));
        Mockito.verify(sender, Mockito.times(0)).
                send(ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString());
    }

    @Test
    public void activateUserTest() {
        User user = new User();
        user.setActivationCode("bingo!");
        doReturn(user)
                .when(userRepository).findByActivationCode("activate");
        boolean isUserActivated = userService.activateUser("activate");

        Assert.assertTrue(isUserActivated);
        Assert.assertNull(user.getActivationCode());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
    @Test
    public void activateUserFailTest(){
        boolean isUserActivated = userService.activateUser("activate me");
        Assert.assertFalse(isUserActivated);
        Mockito.verify(userRepository, Mockito.times(0)).save(any(User.class));
    }
}