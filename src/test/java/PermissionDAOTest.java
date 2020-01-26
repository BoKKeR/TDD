import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PermissionDAOTest {
    ArrayList<Permission> basePermissionList;
    PermissionDAO permissionDAO;

    @BeforeEach
    void setUp() throws Exception {
        basePermissionList = new ArrayList<>(Arrays.asList());
        permissionDAO = new PermissionDAO(basePermissionList);
    }

    @Test
    public void verifyPermission() throws Exception {

    }
    @Test
    public void generateToken() throws Exception {

    }

    @Test
    public void getPermissionByUsername() {

    }

    @Test
    public void addPermission() throws Exception {

    }
}
