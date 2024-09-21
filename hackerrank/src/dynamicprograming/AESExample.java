package dynamicprograming;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESExample {

    public static void main(String[] args) throws Exception {
        String data = "Hello, World!";
        String key = "e82e9d5c7c56b286"; // 128-bit key (16 bytes) represented as a string in hexadecimal format

        byte[] encryptedData = encrypt(data, key);
        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));

        String decryptedData = decrypt(encryptedData, key);
        System.out.println("Decrypted Data: " + decryptedData);
    }

    public static byte[] encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[32])); // IV is 16 bytes for AES
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16])); // IV is 16 bytes for AES
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData);
    }
}