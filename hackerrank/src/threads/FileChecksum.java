package threads;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HexFormat;

public class FileChecksum {
    public static void main(String[] args) {
        String filePath = "D:\\tutorial\\hackerrank\\src\\threads\\hello.txt"; // file to checksum

        try (InputStream fis = new FileInputStream(filePath)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] buffer = new byte[8192]; // read in chunks
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
                String a = new String(buffer);
            }

            byte[] hashBytes = digest.digest();

            // Convert bytes → hex string

            String checksum = HexFormat.of().formatHex(hashBytes);

            System.out.println("SHA-256 checksum: " + checksum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
