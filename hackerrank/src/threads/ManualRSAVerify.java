package threads;

import java.security.*;
import java.security.spec.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class ManualRSAVerify {
    public static void main(String[] args) throws Exception {
        String message = "hello world";

        // Generate RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // Step 1: Sign using standard Signature API
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(privateKey);
        signer.update(message.getBytes("UTF-8"));
        byte[] signature = signer.sign();
        System.out.println("--" + new String(

        ));

        // Step 2: Manually "decrypt" signature using RSA public key to get DigestInfo
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decrypted = cipher.doFinal(signature);

        // Print the "DigestInfo" bytes
        System.out.println("Decrypted DigestInfo (hex):");
        for (byte b : decrypted) {
            System.out.printf("%02x", b);
        }

        System.out.println();

        // Step 3 (optional): Verify manually (parse ASN.1 DigestInfo)
        // SHA-256 ASN.1 prefix (should match beginning of decrypted output):
        //   0x30 0x31  (SEQUENCE)
        //   0x30 0x0d  (SEQUENCE of algorithm identifier)
        //   ...
        //   Then final 32 bytes are the hash

        byte[] sha256Digest = MessageDigest.getInstance("SHA-256").digest(message.getBytes("UTF-8"));

        System.out.println("Expected SHA-256 digest:");
        for (byte b : sha256Digest) {
            System.out.printf("%02x", b);
        }
    }
}
