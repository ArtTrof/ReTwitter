package web.project.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import web.project.app.controller.MessageController;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("admin")
@TestPropertySource("/application-test.properties")
@Sql(value={"/create-user-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value={"/create-user-after-sql.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class MessageControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MessageController messageController;

//    @Test
//    public void mainPageTest()throws Exception{
//        this.mockMvc.perform(get("/main"))
//                .andDo(print())
//                .andExpect(authenticated())
//                .andExpect(xpath("//*[@id='navbarSupportedContent']/div").string("admin"));
//    }
//    @Test
//    public void messageListTest()throws Exception{
//        this.mockMvc.perform(get("/main"))
//                .andDo(print())
//                .andExpect(authenticated())
//                .andExpect(xpath("").nodeCount(0));
//    }
}
