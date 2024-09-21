package algorithms;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class WriteAheadLogExample {

    private static final String WAL_FILE = "wal.log";
    private static final String DB_FILE = "database.txt";
    private Map<String, String> database = new HashMap<>();

    public WriteAheadLogExample() {
        loadDatabase();
    }

    // Append changes to WAL before applying them to the in-memory database
    public void put(String key, String value) throws IOException {
        // 1. Write the change to the WAL
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WAL_FILE, true))) {
            writer.write(key + ":" + value);
            writer.newLine();
        }

        // 2. Apply the change to the in-memory database
        database.put(key, value);

        // 3. Persist the change to the actual database file
        persistDatabase();
    }

    // Apply WAL entries after a crash to recover the state
    public void applyWAL() throws IOException {
        if (Files.exists(Paths.get(WAL_FILE))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(WAL_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] entry = line.split(":");
                    if (entry.length == 2) {
                        database.put(entry[0], entry[1]);
                    }
                }
            }
            // Once the WAL is applied, it can be deleted
            Files.delete(Paths.get(WAL_FILE));
            persistDatabase(); // Save the recovered data to the main database file
        }
    }

    // Simulate database persistence to a file
    private void persistDatabase() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_FILE))) {
            for (Map.Entry<String, String> entry : database.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        }
    }

    // Load the database from the file
    private void loadDatabase() {
        if (Files.exists(Paths.get(DB_FILE))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(DB_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] entry = line.split(":");
                    if (entry.length == 2) {
                        database.put(entry[0], entry[1]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to view the current database state
    public void printDatabase() {
        System.out.println("Current Database State:");
        for (Map.Entry<String, String> entry : database.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        WriteAheadLogExample walExample = new WriteAheadLogExample();

        // Simulating recovery by applying WAL if necessary
        walExample.applyWAL();

        // Adding new entries (these will first be written to the WAL)
        walExample.put("name", "Alice");
        walExample.put("city", "Wonderland");

        // Print the database state
        walExample.printDatabase();
    }
}
