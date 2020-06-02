public class client {

    private Key privateKey;
    private Key sharedKey;
    private Key sharedPublicKey;
    public String name;


    public client(int privateKey, String name) {
        this.privateKey = new Key(privateKey, name);
        this.name = name;
        this.sharedKey = new Key(-1, getName());
        this.sharedPublicKey = new Key(-1, getName());
    }

    public String getName() {
        return name;
    }

    public int mergePublicKeys(Key g, Key n) {
        sharedPublicKey.setKey((int) Math.pow((double) g.getKey(), (double) privateKey.getKey()) % n.getKey());
        //System.out.println(g.getKey() + "^" + privateKey.getKey() + " % " + n.getKey());
        return sharedPublicKey.getKey();
    }

    public int mergeKeys(Key other, Key n) {
        sharedKey.setKey((int) Math.pow((double) other.getKey(), (double) privateKey.getKey()) % n.getKey());
        //System.out.println(other.getKey() + "^" + privateKey.getKey() + " % " + n.getKey());
        return sharedKey.getKey();
    }

    public Key getSharedKey() {
        return sharedKey;
    }

    public Key getSharedPublicKey() {
        return sharedPublicKey;
    }

    public String encrypt(String msg){
        String output = "";
        for(int i =0; i<msg.length(); i++){
            output += (char)(((int)msg.charAt(i)+sharedKey.getKey())%(Integer.MAX_VALUE-704));
        }

        return output;
    }

    public String decrypt(String encryptedMsg){
        String output = "";
        for(int i =0; i<encryptedMsg.length(); i++){
            output += (char)(((int)encryptedMsg.charAt(i)-sharedKey.getKey()%(Integer.MAX_VALUE-704)));
        }
        return output;
    }
}
