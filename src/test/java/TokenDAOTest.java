import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenDAOTest {
    TokenDAO tokenDAO;
    User testUser1;
    ArrayList baseTokenList;

    @BeforeEach
    void setUp() {
        testUser1 = new User("user1","ddddd865304072BC29B5ACCD7F6478F9");
        tokenDAO = new TokenDAO(baseTokenList);
        baseTokenList = new ArrayList<>(Arrays.asList(testUser1));
    }

    @Test
    public void addToken() throws Exception {

        assertEquals(testUser1.getUsername(), returnUser.getUsername());
    }

    @Test
    public void generateToken() throws Exception {
    }

    @Test
    public void getUserByToken() throws Exception {

        assertEquals(testUser1.getUsername(), returnUser.getUsername());
    }


}

