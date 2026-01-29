package threads;

import java.io.*;
import java.util.*;

public class RandomCsvRowEfficient {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Nitro\\Downloads\\phone_numbers.csv";
        Random random = new Random();
        String result = null;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                if (random.nextInt(count) == 0) {
                    result = line;
                }
            }

            if (result != null) {
                System.out.println("Random row: " + result);
            } else {
                System.out.println("CSV file is empty.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
