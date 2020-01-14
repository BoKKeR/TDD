import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class AuthenticatorModuleTest {
    AuthenticationModule mockedAuthenticationModule;
    AuthenticationModule authenticationModule;
    UserDAO mockedUserDAO ;


    @BeforeEach
    void setUp() throws Exception {

        mockedUserDAO = mock(UserDAO.class);
        mockedAuthenticationModule = mock(AuthenticationModule.class);

        authenticationModule = new AuthenticationModule(mockedUserDAO);

        // Registration mocks
        when(mockedUserDAO.registerUser(new User("user1", "encryptedPass1")))
                .thenReturn(new ArrayList<User>(Arrays.asList(new User("user1","encryptedPass1"))));
        when(mockedUserDAO.registerUser(new User("user2", "encryptedPass2")))
                .thenReturn(new ArrayList<User>(Arrays.asList(new User("user2","encryptedPass2"))));

        // Encryption mock
        when(mockedAuthenticationModule.EncryptPassword("user1", "encryptedPassword1")).thenReturn("encryptedPassword1");

        // Find user by username mocks
        when(mockedUserDAO.findUserByUsername( "user1"))
                .thenReturn((new User("user1","encryptedPass1")));
        when(mockedUserDAO.findUserByUsername( "user2"))
                .thenReturn((new User("user2","encryptedPass2")));

        //when(authenticationModule.AuthenticateUser("user1", "1234")).thenReturn(true);
        //authenticationModule.RegisterUser("user3", "1234");
    }

    @Test
    public void AuthenticateUser() throws  Exception {
        Boolean loginSuccessfulResponse = authenticationModule.AuthenticateUser("user1", "plainTextPassword");

        assertEquals(true, loginSuccessfulResponse,
                "Should return true as defined in test");
    }

    @Test //Done
    public void EncryptPassword() throws Exception  {
        String encryptPassword = authenticationModule.EncryptPassword("user498", "awawrfwa");
        assertEquals("41C13EE4949A38BB809E2D7635321732", encryptPassword,
                "Should return the predefined password as defined in test, encryption method changed");
    }

    @Test
    public void RegisterUser() throws Exception {
        authenticationModule.RegisterUser("user498", "awawrfwa");
        assertEquals("41C13EE4949A38BB809E2D7635321732", "",
                "Should return the predefined password as defined in test, encryption method changed");
    }

    @Test
    public void loginWrongPassword() {

        try {
            Boolean loginSuccessful = mockedAuthenticationModule.AuthenticateUser("user3", "something else");
            Assertions.fail("aaaa");

        } catch (Exception e) {
            String expectedMessage = "USERNAME OR PASS NOT FOUND";
            Assertions.assertEquals(expectedMessage, e.getMessage(), "Should have thrown an exception");

        }

    }
}