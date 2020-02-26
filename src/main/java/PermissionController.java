import java.util.Date;

//wanabe endpoint
public class PermissionController {
    AuthenticationModule authenticationModule;

    public PermissionController(AuthenticationModule authenticationModule ) {
        this.authenticationModule = authenticationModule;
    }

    public String getResourceFromToken(String token) throws Exception {
        if (authenticationModule.Authenticate(token)) {
            return authenticationModule.AuthenticateResource(token);
        }
        return "UNAUTHORIZED";
    }
}
