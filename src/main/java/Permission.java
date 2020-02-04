public class Permission {
    String Username;
    Boolean Read;
    Boolean Write;
    Boolean Execute;
    String Resource;

    public Permission(String username, Boolean read, Boolean write, Boolean execute, String resource) {
        Username = username;
        Read = read;
        Write = write;
        Execute = execute;
        Resource = resource;
    }

    public Boolean getRead() {
        return Read;
    }

    public void setRead(Boolean read) {
        Read = read;
    }

    public Boolean getWrite() {
        return Write;
    }

    public void setWrite(Boolean write) {
        Write = write;
    }

    public Boolean getExecute() {
        return Execute;
    }

    public void setExecute(Boolean execute) {
        Execute = execute;
    }

    public String getResource() {
        return Resource;
    }

    public void setResource(String resource) {
        Resource = resource;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getResourceList() {
       return "Resource:" + Resource + " Execute:" + Execute + " Read:" + Read + " Write:" + Write;
    }
}
