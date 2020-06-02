public class Key {

    private int key;
    private String ownerName;


    public Key(int key, String ownerName) {
        this.key = key;
        this.ownerName = ownerName;
    }


    public int getKey() {
        return key;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setKey(int key) {
        this.key =key;
    }
}
