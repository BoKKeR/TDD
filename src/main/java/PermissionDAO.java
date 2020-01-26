import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class PermissionDAO {
    ArrayList<Permission> PermissionList;


    public PermissionDAO(ArrayList<Permission> tokenList) {
        PermissionList = tokenList;
    }

    public Permission addPermission(String username,Boolean read, Boolean write, Boolean execute, String resource) throws NoSuchAlgorithmException {
        Permission permission = new Permission(username ,read,write,execute,resource);
        this.PermissionList.add(permission);
        return permission;
    }

    public Permission getPermissionByUsername(String username) throws Exception {

        for (Permission permission: PermissionList) {
            if (permission.getUsername().equals(username)) {
                return permission;
            }

        }
        return addPermission(username,true, false, false, "PANEL");
    }

    public Boolean verifyPermission(String requestToken) throws Exception {

        for (Permission permission: PermissionList) {
            if (permission.getUsername().equals(requestToken)) {
                return true;
            }
        }
        return false;
    }

}
