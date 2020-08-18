//package pl.dawidkaszuba.homeBudget.controller;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import pl.dawidkaszuba.homeBudget.app.configuration.JwtTokenUtil;
//
//import static org.junit.Assert.assertNotNull;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class HomeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    UserDetails userDetails;
//
//
//    @Test
//    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().is(401));
//    }
//
//    @Test
//    public void shouldGenerateAuthToken() throws Exception {
//
//
//        String token = jwtTokenUtil.generateToken()
//
//        assertNotNull(token);
//        mockMvc.perform(MockMvcRequestBuilders.get("/test").header("Authorization", token)).andExpect(status().isOk());
//    }
//
//}