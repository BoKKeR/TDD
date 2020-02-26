import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PermissionControllerTest {
    PermissionController permissionController;
    AuthenticationModule mockedAuthenticationModule;

    @BeforeEach
    void setUp() throws Exception {
        mockedAuthenticationModule = mock(AuthenticationModule.class);
        permissionController = new PermissionController(mockedAuthenticationModule);

        when(mockedAuthenticationModule.Authenticate("token"))
                .thenReturn(true);

        when(mockedAuthenticationModule.AuthenticateResource("token")).thenReturn("resource");
    }

    @Test
    public void getResourceFromToken() throws Exception {
        assertEquals( "resource", permissionController.getResourceFromToken("token"));
    }
}
