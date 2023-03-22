package web.project.app;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
//class for test
 class DumbPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return String.format("secret: %s",rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
class DumbPasswordEncoderTest {

    @Test
    void encode() {
        DumbPasswordEncoder dumbPasswordEncoder = new DumbPasswordEncoder();
        Assert.assertEquals("secret: myPassword",dumbPasswordEncoder.encode("myPassword"));
    }

}