import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthenticatorModuleTest {
    AuthenticationModule authenticationModule;
    UserDAO userDAO;
    ArrayList<User> userList;

    @BeforeEach
    void setUp() throws Exception {
        authenticationModule = mock(AuthenticationModule.class);
        userList = new ArrayList<>();
        userList.add(new User("user1", "aaa"));
        userDAO = new UserDAO(userList);
        authenticationModule.EncryptPassword("aa", "aaa");
        authenticationModule.RegisterUser("user1", "1234");
        authenticationModule.RegisterUser("user2", "∞§|$∞``äå§$∞");
        authenticationModule.RegisterUser("user3", "64645564654");
        authenticationModule.RegisterUser("user4", "");
    }

/*    @Test
    public void loginSuccess() throws Exception {
        String loginSuccessfulToken = authenticationModule.AuthenticateUser("user1", "1234");
        System.out.println(loginSuccessfulToken);
        assertEquals("24c9e15e-52af-347c-a25b-757e7bee1f9d", loginSuccessfulToken, "Should be the same token as defined in test, encrypting process changed");
    }*/

    @Test
    public void tokenReturnSucessful() throws Exception {
        // Skriv med Mockito och använd verify

        User testUser = userDAO.findUserByUsername("user1");
        when(authenticationModule.RegisterUser("user1", "pass")).thenReturn();
        authenticationModule.RegisterUser("username","pass");

        //verify(authenticationModule.RegisterUser("username","pass"));
    }

 /*   @Test
    public void loginSuccessSpecialChar() throws Exception {
        when(authenticationModule.EncryptPassword("aaa", "aaa")).thenReturn("aaaa");
        String loginSucessful = authenticationModule.AuthenticateUser("user2", "∞§|$∞``äå§$∞");
        assertEquals("7e58d63b-6019-3ceb-95a1-c487989a3720", loginSucessful, "Password should work with special characters");
    }

    @Test
    public void loginWrongPassword() {

        try {
            String loginSucessful = authenticationModule.AuthenticateUser("user3", "something else");
            assertEquals(loginSucessful, "aa");

        } catch (Exception e) {
            String expectedMessage = "USERNAME OR PASS NOT FOUND";
            Assertions.assertEquals(expectedMessage, e.getMessage(), "Should have thrown an exception");

        }

    }*/
}