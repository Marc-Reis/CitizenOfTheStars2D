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
public class PasswortCipher {

    public static void main(String args[]) {

        String name = "Marc";
        String lastname = "Reis";
        String email = "Marc.Reis@gmail.com";
        String password = "SuperGeheim!";

        PasswortCipher myCipher = new PasswortCipher();

        String cipheredPassword = myCipher.cipherPassword(password);

        String candidatePassword1 = "DasBekommenDieNieRaus!";
        String candidatePassword2 = password;

        System.out.println(" does " + candidatePassword1 + " fit?" + 
                myCipher.checkPassword(candidatePassword1, cipheredPassword) +" >"+cipheredPassword) ;
        System.out.println(" does " + candidatePassword2 + " fit?" + 
                myCipher.checkPassword(candidatePassword2, cipheredPassword)+ " "+cipheredPassword);
        
        
        myCipher.phpTest();

    }

    public String cipherPassword(String password) {
        String hashedString = BCrypt.hashpw(password, BCrypt.gensalt(10));
        return hashedString;
    }

    public boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
    
    private void phpTest() {
        String cipher_php = "$2y$10$1X2Fq2Gq2YDgG7OAYrwE.OEEDED1kb30mvox/pcQniK4OwHIoAR3W".replaceFirst("2y", "2a");
        System.out.println("hash php " + cipher_php);        
        if (BCrypt.checkpw("SuperGeheim!", cipher_php)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}
