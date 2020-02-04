import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PermissionDAOTest {
    ArrayList<Permission> basePermissionList;
    PermissionDAO permissionDAO;

    @BeforeEach
    void setUp() throws Exception {
        basePermissionList = new ArrayList<Permission>(Arrays.asList(
                new Permission("test",true,true,true,"PANEL")
        ));
        permissionDAO = new PermissionDAO(basePermissionList);
    }

    @Test
    public void verifyPermission() throws Exception {

    }
    @Test
    public void generateToken() throws Exception {

    }

    @Test
    public void getPermissionByUsernameAndResource() throws Exception {
        Permission perm = permissionDAO.getPermissionByUsernameAndResource("test");
        System.out.println(perm.getResource());


    }

    @Test
    public void addPermission() throws Exception {

    }
}
