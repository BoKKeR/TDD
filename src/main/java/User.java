public class User {

    private String username;
    private String encryptedPassword;
    private String token;
    private Permission permission;

    public User(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public User(String username, String encryptedPassword, Permission permission) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.permission = permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setWritePermission(Boolean write) {
        this.permission.setWrite(write);
    }

    public void setReadPermission(Boolean read) {
        this.permission.setRead(read);
    }

    public boolean getWritePermission() {
        return this.permission.isWrite();
    }

    public boolean getReadPermission() {
        return this.permission.isRead();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
