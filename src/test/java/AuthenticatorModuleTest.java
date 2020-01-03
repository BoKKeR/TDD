import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthenticatorModuleTest {
    AuthenticationModule authenticationModule;
    UserDAO userDAO ;
    ArrayList<User> userList;

    @BeforeEach
    void setUp() throws Exception {

        userDAO = mock(UserDAO.class);
        //Arrays.asList(new User("aa","bbb"));
        when(userDAO.registerUser(new User("user1", "encryptedPass")))
                .thenReturn(new ArrayList<User>(Arrays.asList(new User("user1","encryptedPass"))));
        when(userDAO.registerUser(new User("user2", "encryptedPass")))
                .thenReturn(new ArrayList<User>(Arrays.asList(new User("user2","encryptedPass"))));
        when(userDAO.findUserByUsername( "user1"))
                .thenReturn((new User("user1","encryptedPass")));

        //userDAO = new UserDAO(userList);
        authenticationModule = mock(AuthenticationModule.class);
        //authenticationModule = new AuthenticationModule(userDAO);

        doReturn("encryptedPass").when(authenticationModule.EncryptPassword("user1", "1234"));
        authenticationModule.RegisterUser("user3", "1234");

    }

    @Test
    public void loginSuccess() throws Exception {
        Boolean loginSuccessfulResponse = authenticationModule.AuthenticateUser("user1", "1234");
        assertEquals(true, loginSuccessfulResponse,
                "Should return true as defined in test");
    }

    @Test
    public void testMock() throws Exception {
        String loginSuccessfulResponse = authenticationModule.EncryptPassword("user2","encryptedPass");
        assertEquals("encryptedPass", loginSuccessfulResponse,
                "Should return true as defined in test");
    }

    @Test
    public void loginWrongPassword() {

        try {
            Boolean loginSuccessful = authenticationModule.AuthenticateUser("user3", "something else");
            assertEquals(loginSuccessful, false);

        } catch (Exception e) {
            String expectedMessage = "USERNAME OR PASS NOT FOUND";
            Assertions.assertEquals(expectedMessage, e.getMessage(), "Should have thrown an exception");

        }

    }
}