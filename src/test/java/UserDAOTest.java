import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDAOTest {
    UserDAO userDAO = new UserDAO(new ArrayList<>());

    @BeforeEach
    void setUp() {
        userDAO.registerUser(new User("user1", "aaa"));
    }

    @Test
    public void registerUserSuccess() throws Exception {
        User testUser = userDAO.findUserByUsername("user1");
        assertEquals(new User("user1", "aaa").getUsername(), testUser.getUsername());
    }

    @Test
    public void deleteUserSuccess() throws Exception {
        User testUser = userDAO.findUserByUsername("user1");
        userDAO.deleteUser(testUser);
        try{
        assertEquals(userDAO.findUserByUsername("user1").getUsername(), testUser.getUsername());
        }
        catch (Exception e){
            String expectedMessage = "User not found in list";
            Assertions.assertEquals(expectedMessage, e.getMessage());
        }
    }
}

