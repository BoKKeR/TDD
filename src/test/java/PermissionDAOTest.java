import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermissionDAOTest {
    ArrayList<Permission> basePermissionList;
    PermissionDAO permissionDAO;

    @BeforeEach
    void setUp() {
        basePermissionList = new ArrayList<>(Arrays.asList(
                new Permission("test",true,true,true,"PANEL"),
                new Permission("test",true,true,true,"PANEL"),
                new Permission("test",true,true,true,"PANEL")
        ));
        permissionDAO = new PermissionDAO(basePermissionList);
    }

    @Test
    public void getPermissionByUsernameAndResource() throws Exception {
        Permission perm = permissionDAO.getPermissionByUsernameAndResource("test");
        assertEquals(true, perm.getRead());
    }

    @Test
    public void getResourceByUsername() {
        String resource = permissionDAO.getResourceByUsername("test");
        assertEquals("PANEL", resource);
    }

    @Test
    public void addPermission() throws Exception {
        permissionDAO.addPermission("user2",true, false, true, "PANEL");
        assertEquals("PANEL", permissionDAO.getResourceByUsername("user2"));
    }
}
