import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermissionTest {

    Permission permission;

    @BeforeEach
    void setUp() {
        permission = new Permission ("test",true,true,true,"PANEL");
    }


    @Test
    public void getResourceList() {
        String getResourceList = permission.getResourceList();
        assertEquals(
                "Resource:" + permission.getResource() +
                        " Execute:" + permission.getExecute() +
                        " Read:" + permission.getRead() +
                        " Write:" + permission.getWrite(), getResourceList);
    }
}
