//package leetcode.dynamic_programming;
//
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class RegularExpressionMatching {
//
//    // Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//    //
//    //'.' Matches any single character.
//    //'*' Matches zero or more of the preceding element.
//    //The matching should cover the entire input string (not partial).
///*
//    Example 1:
//
//    Input: s = "aa", p = "a"
//    Output: false
//    Explanation: "a" does not match the entire string "aa".
//    Example 2:
//
//    Input: s = "aa", p = "a*"
//    Output: true
//    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//    Example 3:
//
//    Input: s = "ab", p = ".*"
//    Output: true
//    Explanation: ".*" means "zero or more (*) of any character (.)".
//
//
//    Constraints:
//
//            1 <= s.length <= 20
//            1 <= p.length <= 20
//    s contains only lowercase English letters.
//    p contains only lowercase English letters, '.', and '*'.
//    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
//        */
//    public boolean isMatch(String s, String p) {
//
////        if(s.charAt())
//        return true;
//    }
//
//    public static void main(String[] args) {
//        // Create a pattern from regex
//        Pattern pattern = Pattern.compile(".*a.*f");
////
////        // Get the String to be matched
//        String stringToBeMatched = "abdvsadfewfwvaabfdrgrefdsf";
//
////        Pattern pattern = Pattern.compile("a*");
//
//        // Get the String to be matched
////        String stringToBeMatched = "aaaaaa";
//
//        // Create a matcher for the input String
//        Matcher matcher = pattern.matcher(stringToBeMatched);
//
//        // Get the Pattern using pattern() method
//        System.out.println("Pattern used: " + matcher.matches());
//    }
//
//
//
//    public static long getMaximumSumOfStrengths(List<Integer> arr) {
//        // Write your code here
//        int n = arr.size();
//
//        long base = 0L;
//
//        for(int i = 0; i< n; i++) {
//            base += (long) arr.get(i) * (i+1L);
//        }
//
//        if(n<2) return base;
//
//        long[] dp = new long[n+1];
//        dp[0] = 0L;
//        dp[1] = 0L;
//
//        for(int i = 2; i <=n; i++) {
//            long delta = (long) arr.get(i-2) - (long) arr.get(i-1);
//            if(delta < 0) delta = 0;
//            dp[i] = Math.max(dp[i-1], dp[i-2] + delta);
//        }
//
//        return base + dp[n];
//    }
//
//    public static String getPhoneNumbers(String country, String phoneNumber) {
//        try {
//            String base = "https://jsonmock.hackerrank.com/api/countries?name=";
//            String encoded = URLEncoder.encode(country, "UTF-8");
//            URL url = new URL(base + encoded);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(5000);
//            conn.setReadTimeout(5000);
//
//            int status = conn.getResponseCode();
//            BufferedReader in;
//            if (status >= 200 && status < 400) {
//                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            } else {
//                return "-1";
//            }
//
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = in.readLine()) != null) {
//                sb.append(line);
//            }
//            in.close();
//            conn.disconnect();
//
//            JSONObject root = new JSONObject(sb.toString());
//            JSONArray data = root.getJSONArray("data");
//
//            if (data.length() == 0) {
//                return "-1";
//            }
//
//            JSONObject countryRecord = data.getJSONObject(0);
//
//            if (!countryRecord.has("callingCodes")) {
//                return "-1";
//            }
//            JSONArray callingCodes = countryRecord.getJSONArray("callingCodes");
//            if (callingCodes.length() == 0) {
//                return "-1";
//            }
//
//            String code = callingCodes.getString(callingCodes.length() - 1);
//
//            return "+" + code + phoneNumber;
//
//        } catch (Exception e) {
//            return "-1";
//        }
//    }
//
//    public static String getPhoneNumbers(String country, String phoneNumber) {
//        try {
//            String baseUrl = "https://jsonmock.hackerrank.com/api/countries?name=";
//            String encoded = URLEncoder.encode(country, "UTF-8");
//            URL url = new URL(baseUrl + encoded);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(5000);
//            conn.setReadTimeout(5000);
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String line;
//
//            while ((line = in.readLine()) != null) {
//                response.append(line);
//            }
//            in.close();
//            conn.disconnect();
//
//            JSONParser parser = new JSONParser();
//            JSONObject root = (JSONObject) parser.parse(response.toString());
//
//            JSONArray data = (JSONArray) root.get("data");
//            if (data == null || data.isEmpty()) {
//                return "-1";
//            }
//
//            JSONObject countryObj = (JSONObject) data.get(0);
//            JSONArray callingCodes = (JSONArray) countryObj.get("callingCodes");
//
//            if (callingCodes == null || callingCodes.isEmpty()) {
//                return "-1";
//            }
//
//            String code = (String) callingCodes.get(callingCodes.size() - 1);
//
//            return "+" + code + phoneNumber;
//
//        } catch (Exception e) {
//            return "-1";
//        }
//    }
//}
