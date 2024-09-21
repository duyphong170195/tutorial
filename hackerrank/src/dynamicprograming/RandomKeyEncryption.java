package dynamicprograming;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class RandomKeyEncryption {

    public static void main(String[] args) throws Exception {
        String data = "Hello, World!";
        
        // Generate a random AES key
        SecretKey key = generateRandomAESKey();
        
        // Encrypt the data using the random key
        byte[] encryptedData = encrypt(data, key);

        // Print the encrypted data
        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));
    }

    public static SecretKey generateRandomAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // 256-bit key size for AES
        return keyGen.generateKey();
    }

    public static byte[] encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
}
