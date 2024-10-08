package dynamicprograming;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

public class RangeGenerator {
    public static List<List<Integer>> generateRanges(int number, int numRanges) {
        List<List<Integer>> ranges = new ArrayList<>();

        if (numRanges <= 0) {
            return ranges;
        }

        if (numRanges == 1) {
            List<Integer> singleRange = new ArrayList<>();
            singleRange.add(1);
            singleRange.add(number);
            ranges.add(singleRange);
            return ranges;
        }

        int step = number / numRanges;
        int remainder = number % numRanges;

        int start = 0;
        for (int i = 0; i < numRanges; i++) {
            int end = start + step - 1;
            if (remainder > 0) {
                end++;
                remainder--;
            }
            List<Integer> range = new ArrayList<>();
            range.add(start);
            range.add(end);
            ranges.add(range);
            start = end + 1;
        }

        return ranges;
    }

//    public static void main(String[] args) {
////        int number = 20;
////        int numRanges = 4;
////        List<List<Integer>> result = generateRanges(number, numRanges);
////        for (List<Integer> range : result) {
////            System.out.println("[" + range.get(0) + ", " + range.get(1) + "]");
////        }
//
//        double numberd = (double) 101/100;
//        int b = (int) Math.ceil( numberd);
//
//        System.out.println(generateRanges(b, 10));;
//        System.out.println(b);
//
//    }

    public static void main(String[] args) {

        Object value = Instant.now();

//        if(object instanceof  Instant) {
//            System.out.println("instant");
//        }
        String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
        ZoneId systemDefault = ZoneId.systemDefault();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY_HH_MM).withZone(systemDefault);
        value = formatter.format((TemporalAccessor) value);
        System.out.println(value);

        Boolean secondaryBoolean = null;

        System.out.println(secondaryBoolean != null && secondaryBoolean);

        String a= "hello";
        switch (a) {
            case "hello":
            case "bello":
                System.out.println("true");
        }

        String value222 = System.getenv().get("PATH");
        System.out.println(value222);
    }
}