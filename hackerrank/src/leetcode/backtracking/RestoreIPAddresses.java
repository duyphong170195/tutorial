package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RestoreIPAddresses {

    public static void main(String[] args) {

        String s = "25625789135";
        String s1  = s.substring(0, 2);
        String s2  = s.substring(2, 4);
        String s3  = s.substring(4, 6);
        String s4  = s.substring(6);
        System.out.println();

        List<String> result = restoreIpAddresses2("25525511135");
        System.out.println(result);

//        Long.valueOf("5255255255");

    }

    public static List<String> restoreIpAddresses(String s) {

        if(s.trim().equals("") || s.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(1, 1, 1, s, result);
        return result.stream().distinct().collect(Collectors.toList());
    }


    public static void backtrack(int i, int j , int m, String s, List<String> result) {

        if( i+j+m  > s.length()) {
            return;
        }


        String s1  = s.substring(0, i);
        String s2  = s.substring(i, i+ j);
        String s3  = s.substring(i + j,  i + j + m);
        String s4  = s.substring(i + j + m);

//        System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", s3 = " + s3 + ", s4 = " + s4);

        if((s1.length() > 1 && s1.startsWith("0"))
           || (s2.length() > 1 && s2.startsWith("0"))
           || (s3.length() > 1 && s3.startsWith("0"))
           || (s4.length() > 1 && s4.startsWith("0"))
        ) {

        } else if(s1.length() > 0 && Long.valueOf(s1) <= 255
                && s2.length() > 0 && Long.valueOf(s2) <= 255
                && s3.length() > 0 && Long.valueOf(s3) <= 255
                && s4.length() > 0 && Long.valueOf(s4) <= 255) {
            StringBuilder builder = new StringBuilder();

            builder.append(s1);
            builder.append(".");
            builder.append(s2);
            builder.append(".");
            builder.append(s3);
            builder.append(".");
            builder.append(s4);

            result.add(builder.toString());
        }

        if(s3.length() < 3) {
            backtrack(i, j, m + 1, s, result);
        }

        if(s2.length() < 3) {
            backtrack(i, j + 1, m, s, result);
        }
        if(s1.length() < 3) {
            backtrack(i + 1, j, m, s, result);
        }
    }


    public static List<String> restoreIpAddresses2(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }

    private static void backtrack(List<String> result, String s, int start, String current, int count) {
        // If we've inserted 3 dots and reached the end of the string, add to result
        if (count == 4) {
            System.out.println("current = " + current);
            if (start == s.length()) {
                result.add(current.substring(0, current.length() - 1)); // Remove trailing dot
            }
            return;
        }


        // Try segments of length 1, 2, or 3
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break; // Avoid out of bounds
            System.out.println("current = " + current);
            String segment = s.substring(start, start + i);
            if (isValidSegment(segment)) {
                backtrack(result, s, start + i, current + segment + ".", count + 1);
            }
        }
    }

    private static boolean isValidSegment(String segment) {
        // Check if it's within the range of 0-255 and has no leading zeros unless it's "0"
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }

    public List<String> restoreIpAddresses3(final String s) {
        if(s.length() < 4 || s.length() > 12)
            return List.of();

        final List<String> result = new ArrayList<>();

        backTrack(result, new StringBuilder(), s, 0, 0);

        return result;
    }

    private void backTrack(
            final List<String> result,
            final StringBuilder address,
            final String s,
            final int start,
            final int count) {
        if(start >= s.length() && count == 4) {
            result.add(address.substring(0, address.length() - 1));
            return;
        }

        if(s.length() - start > 3 * (4 - count))
            return;

        final int begining = address.length();

        for(int i = start; i < Math.min(start + 3, s.length()); ++i) {
            address.append(s.charAt(i));

            final String number = address.substring(begining, address.length());

            if(Integer.valueOf(number) <= 255) {
                address.append('.');
                backTrack(result, address, s, i + 1, count + 1);
                address.setLength(address.length() - 1);
            }

            if(number.equals("0"))
                break;
        }

        address.setLength(begining);
    }

}
