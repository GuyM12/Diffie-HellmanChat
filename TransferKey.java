public class TransferKey {

    public client alice;
    public client bob;
    public Key g;
    public Key n;

    public TransferKey(client alice, client bob, int g, int n){
        this.alice = alice;
        this.bob = bob;
        this.g = new Key(g,"public");
        this.n = new Key(n,"public");
    }

    public void Thransformation(){
        /*System.out.println("alice current shared key ((g^a)%n): " + alice.mergePublicKeys(g,n));
        System.out.println("bob current shared key ((g^b)%n): " + bob.mergePublicKeys(g,n));
        System.out.println("alice current shared key ((g^a*b)%n): " + alice.mergeKeys(bob.getSharedPublicKey(), n));
        System.out.println("bob current shared key ((g^a*b)%n): " + bob.mergeKeys(alice.getSharedPublicKey() , n));*/

        //Transferring the keys between alice and bob.
        alice.mergePublicKeys(g,n);
        bob.mergePublicKeys(g,n);
        alice.mergeKeys(bob.getSharedPublicKey(),n);
        bob.mergeKeys(alice.getSharedPublicKey(),n);


    }
}
