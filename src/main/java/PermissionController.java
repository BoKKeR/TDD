import java.util.Date;

public class PermissionController {
    AuthenticationModule authenticationModule;

    public PermissionController(AuthenticationModule authenticationModule ) {
        this.authenticationModule = authenticationModule;
    }

    public String getDate(String token) throws Exception {
        if (authenticationModule.AuthenticateResource(token)) {
            return new Date().toString();
        }
        return "UNAUTHORIZED";
    }
}
