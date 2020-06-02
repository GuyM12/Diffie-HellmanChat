import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        client alice = new client(501146, "alice");
        client bob = new client(4163485, "bob");
        TransferKey conv = new TransferKey(alice, bob, 2, 562155);
        conv.Thransformation();

        //System.out.println((char)(Integer.MAX_VALUE-704));

        //Starting to msg from alice.
        System.out.println("alice:");
        String encryptedMsg = conv.alice.encrypt(scanner.nextLine());
        System.out.println("Sending encrypted msg... \n" + encryptedMsg);
        String decryptedMsg = conv.bob.decrypt(encryptedMsg);
        System.out.println("bob got: \n" + decryptedMsg);

        //Bob answers.
        System.out.println("bob:");
        encryptedMsg = conv.bob.encrypt(scanner.nextLine());
        System.out.println("Sending encrypted msg... \n" + encryptedMsg);
        decryptedMsg = conv.alice.decrypt(encryptedMsg);
        System.out.println("alice got: \n" + decryptedMsg);
    }
}
