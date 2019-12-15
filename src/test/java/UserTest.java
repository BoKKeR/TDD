import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



class UserTest {
    User testUser;

    @BeforeEach
    void setUp() {
        this.testUser = new  User("aa","aa");
    }

    @Test
    public void setUsername()  {
        String username = "bbbb";
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
