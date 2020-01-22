import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserDAOTest {
    UserDAO userDAO;
    User testUser1;
    User testUser2;
    User testUser3;
    ArrayList baseUserList;

    @BeforeEach
    void setUp() {
        testUser1 = new User("user1","ddddd865304072BC29B5ACCD7F6478F9");
        testUser2 = new User("user2","8F2BE86530cccccC29B5ACCD7F6478F9");
        testUser3 = new User("user3","8F2BE865304072BC29B5ACddddddd8F9");

        baseUserList = new ArrayList<>(Arrays.asList(testUser1, testUser2, testUser3));
        userDAO = new UserDAO(baseUserList);
    }

    @Test
    public void registerUserSuccess() throws Exception {
        User returnUser = userDAO.findUserByUsername("user1");
        assertEquals(testUser1.getUsername(), returnUser.getUsername());
    }

    @Test
    public void findUserByUsernameException() {
        assertEquals(testUser1.getUsername(), testUser1.getUsername());
    }

    @Test
    public void deleteUserSuccess() {
        userDAO.deleteUser(testUser1);
        assertThrows(Exception.class, ()->userDAO.findUserByUsername("user1"));
    }


}

