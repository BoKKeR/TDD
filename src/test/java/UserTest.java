import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
    User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("user1","testPass");
    }

    @Test
    public void setUsername()  {
        String username = "userChanged";
        testUser.setUsername(username);
        Assertions.assertEquals(testUser.getUsername(), username);
    }

    @Test
    public void setEncryptedPassword()  {
        String password = "pass";
        testUser.setEncryptedPassword(password);
        Assertions.assertEquals(testUser.getEncryptedPassword(), password);
    }
}
