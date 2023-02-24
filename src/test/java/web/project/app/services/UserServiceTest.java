package web.project.app.services;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
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

import static org.junit.jupiter.api.Assertions.*;

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

//    @Test
//    void addUser() {
//        User user = new User();
//        boolean isUserCreated = userService.addUser(user);
//        user.setEmail("some@gmail.com");
//        Assert.assertTrue(isUserCreated);
//        Assert.assertNotNull(user.getActivationCode());
//        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
//
//        Mockito.verify(userRepository, Mockito.times(1)).save(user);
//        Mockito.verify(sender, Mockito.times(1))
//                .send(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
//                        ArgumentMatchers.anyString());
//    }
//    @Test
//    public void addUserFailTest(){
//        User user = new User();
//        Mockito.doReturn(new User()).when(userRepository).findByUsername("john");
//        boolean isUserCreated = userService.addUser(user);
//        user.setUsername("john");
//        assertFalse(isUserCreated);
//    }
}