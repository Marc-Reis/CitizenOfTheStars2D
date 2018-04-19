/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author MarcR
 */
public class PasswortHasher {

    public static void main(String args[]) {

        String name = "Marc";
        String lastname = "Reis";
        String email = "Marc.Reis@gmail.com";
        String password = "SuperGeheim!";

        PasswortHasher myHasher = new PasswortHasher();

        String hashedPassword = myHasher.hashPassword(password);

        String candidatePassword1 = "DasBekommenDieNieRaus!";
        String candidatePassword2 = password;

        System.out.println(" does " + candidatePassword1 + " fit?" + myHasher.checkPassword(candidatePassword1, hashedPassword));
        System.out.println(" does " + candidatePassword2 + " fit?" + myHasher.checkPassword(candidatePassword2, hashedPassword));

    }

    public String hashPassword(String password) {
        String hashedString = BCrypt.hashpw(password, BCrypt.gensalt(10));
        return hashedString;
    }

    public boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }

    private void phpTest() {
        String hash_php = "$2y$10$jcAZVcV2VVeQEmgUJI8rNe6ITRQnmaOFtyuHEMBLVRKyaqjp5swSO".replaceFirst("2y", "2a");
        System.out.println("hash php " + hash_php);
        //String a_hash = BCrypt.hashpw("123456", BCrypt.gensalt());
        //System.out.println("Encrypt " + a_hash);
        if (BCrypt.checkpw("SuperGeheim!", hash_php)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}
