import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AuthenticatorModuleTest {
    AuthenticationModule mockedAuthenticationModule;
    AuthenticationModule authenticationModule;
    UserDAO mockedUserDAO;
    TokenDAO mockedTokenDAO;

    @BeforeEach
    void setUp() throws Exception {

        mockedUserDAO = mock(UserDAO.class);
        mockedTokenDAO = mock(TokenDAO.class);
        authenticationModule = new AuthenticationModule(mockedUserDAO, mockedTokenDAO);

        User testUser1 = new User("user1", "B4141716BACF8AEC19069EB1CCBACB13");
        User testUser2 = new User("user2", "encryptedPass1");
        User testUser3 = new User("user3", "encryptedPass1");

        // Register user mock
        when(mockedUserDAO.registerUser(testUser1))
                .thenReturn(new ArrayList<>(Arrays.asList(testUser1)));
        when(mockedUserDAO.registerUser(testUser2))
                .thenReturn(new ArrayList<>(Arrays.asList(testUser2)));
        when(mockedUserDAO.registerUser(testUser3))
                .thenReturn(new ArrayList<>(Arrays.asList(testUser3)));

        // Find user by username mocks
        when(mockedUserDAO.findUserByUsername( "user1"))
                .thenReturn(testUser1);
        when(mockedUserDAO.findUserByUsername( "user2"))
                .thenReturn(testUser2);
        when(mockedUserDAO.findUserByUsername( "user3"))
                .thenReturn(testUser3);

        // Mocking token generation and return
        when(mockedTokenDAO.getTokenByUsername("user1"))
                .thenReturn("B4141716BACF8AEC19069EB1CCBACB13");

        // Mocking token verification
        when(mockedTokenDAO.verifyToken("token"))
                .thenReturn(true);

    }

    @Test
    public void AuthenticateUser() throws  Exception {
        String loginToken = authenticationModule.AuthenticateUser("user1", "encryptedPass1");

        assertEquals("B4141716BACF8AEC19069EB1CCBACB13", loginToken,
                "Should pass the token value");
    }

    @Test
    public void EncryptPassword() throws Exception  {
        String encryptPassword = authenticationModule.EncryptPassword("user1", "testMe");
        assertEquals("8F2BE865304072BC29B5ACCD7F6478F9", encryptPassword,
                "Should return the predefined password as defined in test, encryption method changed");
    }

    @Test
    public void RegisterUser() throws Exception {
        String testUsername = "user3";
        authenticationModule.RegisterUser(testUsername, "encryptedPass1");
        assertEquals(mockedUserDAO.findUserByUsername(testUsername).getUsername(), testUsername,
                "Should return the predefined username");
    }

    @Test
    public void LoginWrongPassword() {
        assertThrows(Exception.class, ()->mockedAuthenticationModule.AuthenticateUser("user1", "testMe"));
    }

    @Test
    public void AuthenticateResource() throws Exception {
        assertEquals(authenticationModule.AuthenticateResource("token"), true);
    }
}