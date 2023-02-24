package web.project.app;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void test(){
        int x=2;
        int y=2;
        Assert.assertEquals(4,x*y);
        Assert.assertEquals(4,x+y);
    }
}
