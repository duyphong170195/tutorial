package leetcode.twopointers;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {

        String[] arrays = s.split("\\s+");

        StringBuilder builder = new StringBuilder();
        for(int i = arrays.length -1; i >= 0; i--) {
            builder.append(arrays[i] + " ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String a = reverseWords("a good   example");
        System.out.println(a);
    }
}
