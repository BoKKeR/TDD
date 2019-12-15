import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class AuthenticationModule {
    UserDAO userDAO;

    public AuthenticationModule(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String AuthenticateUser(String username, String password)throws Exception{
        User user = userDAO.findUserByUsername(username);

        String encryptedPassword = this.EncryptPassword(username, password);

        if (encryptedPassword.equals( user.getEncryptedPassword())) {
            if (user.getToken() == null) {
                String compareToken = UUID.nameUUIDFromBytes(username.getBytes()).toString();
                user.setToken(compareToken);
            }
            return user.getToken();
        }
        throw new Exception("USERNAME OR PASS NOT FOUND");
    }

    public String EncryptPassword(String username, String password) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        String input = username + password;
        byte[] hash = digest.digest(input.getBytes());

        return bytesToStringHex(hash);
        //return UUID.randomUUID().toString();
    }

    public final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 0X0F];
        }
        return new String(hexChars);
    }

    public void RegisterUser (String username, String password)throws NoSuchAlgorithmException{
        String encryptedPassword = this.EncryptPassword(username, password);
        this.userDAO.registerUser(new User(username, encryptedPassword));
    }

}
