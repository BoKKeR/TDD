import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

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

        when(mockedAuthenticationModule.AuthenticateResource("token"))
                .thenReturn(true);
    }

    @Test
    public void getDateEndpointAccessibility() throws Exception {
        assertEquals(permissionController.getDate("token"), new Date().toString());
    }
}
