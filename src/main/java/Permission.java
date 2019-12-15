public class Permission {
    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    private boolean read;

    public Permission(boolean read, boolean write) {
        this.read = read;
        this.write = write;
    }

    private boolean write;
}
