import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Token {
    private String username;
    private String token;

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public Token(String username) throws NoSuchAlgorithmException {
        this.username = username;
        this.token = generateToken(username);
    }

    public String generateToken(String username) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        String input = username;
        byte[] hash = digest.digest(input.getBytes());

        return bytesToStringHex(hash);
    }

    public final static char[] hexArray = "0123456789ABCDEF#!¤%&/()=?".toCharArray();

    public static String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 0X0F];
        }
        return new String(hexChars);
    }
}
