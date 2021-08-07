package algorithms;

public class Encryption {

    public static String encryption(String s) {
        // Write your code here
        String noSpaceStr = s.replaceAll("\\s", "");
        double length = Math.sqrt(noSpaceStr.length());
        int column = (int) Math.ceil(length);

        int maxIndex = noSpaceStr.length() - 1;
        String result = "";
        for (int i = 0; i < column; i++) {
            String each = noSpaceStr.charAt(i) + "";
            int indexSpace = i;
            for (int j = 0; j < column; j++) {
                indexSpace += column;
                if (indexSpace > maxIndex)
                    break;

                each += noSpaceStr.charAt(indexSpace);
            }
            result += each + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(encryption("haveaniceday"));
    }


}
