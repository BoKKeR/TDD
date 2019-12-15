import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermissionTest {
    UserDAO userDAO = new UserDAO(new ArrayList<>());

    @BeforeEach
    void setUp() {
        userDAO.registerUser(new User("user1", "aaa", new Permission(true, false)));
    }

    @Test
    public void setInitialPermissionSuccess() throws Exception {
        User testUser = userDAO.findUserByUsername("user1");
        testUser.setPermission(new Permission(true, true));
        Boolean writePermissionSet = testUser.getWritePermission();
        Boolean readPermissionSet = testUser.getReadPermission();
        assertEquals(true, writePermissionSet);
        assertEquals(true, readPermissionSet);
    }

    @Test
    public void setGetWritePermissionSuccess() throws Exception {
        User testUser = userDAO.findUserByUsername("user1");
        testUser.setWritePermission(true);
        Boolean writePermissionSet = testUser.getWritePermission();
        assertEquals(true, writePermissionSet);
    }

    @Test
    public void setGetReadPermissionSuccess() throws Exception {
        User testUser = userDAO.findUserByUsername("user1");
        testUser.setReadPermission(true);
        Boolean readPermissionSet = testUser.getReadPermission();
        assertEquals(true, readPermissionSet);
    }

}
