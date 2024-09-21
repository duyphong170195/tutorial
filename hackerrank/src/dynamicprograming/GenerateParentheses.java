package dynamicprograming;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class GenerateParentheses {
/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    Example 2:

    Input: n = 1
    Output: ["()"]
*/

    public static void main(String[] args) {

        List<List<String>> result = new ArrayList<>();

    }

    public static void solve(int open, int close, int n, String currentState, List<List<String>> result) {


        if(open < n) {

        }

        if(close < open) {

        }

    }

//    public static void main(String[] args) {
//        // Specify the folder path
//        String folderPath = "/home/phongnd13/Documents/VHR_Fixbug_Project/vhr-csi-be";
//
//        // Specify the text to be replaced and the replacement text
//        String searchText = "vinhome.vinhomeapp";
//        String replaceText = "vol.volapp";
//
//        // Call the method to replace text in all files
//        replaceTextInFiles(folderPath, searchText, replaceText);
//    }
//
//    public static void replaceTextInFiles(String folderPath, String searchText, String replaceText) {
//        File folder = new File(folderPath);
//        File[] files = folder.listFiles();
//
//        // Iterate through each file in the folder
//        for (File file : files) {
//            if (file.isFile()) {
//                // Replace text in the current file
//                System.out.println(file.getName());
//                if(file.getName().endsWith(".java")) {
//                    replaceTextInFile(file, searchText, replaceText);
//                }
//            } else if (file.isDirectory()) {
//                // Recursively call the method for subfolders
//                replaceTextInFiles(file.getAbsolutePath(), searchText, replaceText);
//            }
//        }
//    }
//
//    public static void replaceTextInFile(File file, String searchText, String replaceText) {
//        try {
//            // Read the contents of the file
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            StringBuilder content = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                content.append(line).append(System.lineSeparator());
//            }
//            reader.close();
//
//            // Replace the text and write the modified content back to the file
//            String modifiedContent = content.toString().replace(searchText, replaceText);
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write(modifiedContent);
//            writer.close();
//
//            System.out.println("Text replaced in file: " + file.getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
