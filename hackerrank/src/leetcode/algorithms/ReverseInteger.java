package leetcode.algorithms;

public class ReverseInteger {

    public static int solution(int A, int B) {
        // write your code in Java SE 8
        int i = (int) Math.sqrt(A);
        int count = 0;
        while (true) {
            int sum = i * (i +1);
            if(sum > B) {
                break;
            }

            if(sum >= A  && sum <= B) {
                count ++;
            }

            i++;
        }
        return count;
    }

    public static int solution2(int A, int B) {
        // write your code in Java SE 8
        ;
        int i = (int)Math.sqrt(A);
        return i;
    }


    public static int reverse(int x) {
        if(x == 0) {
            return 0;
        }
        int a = x;

        String signedNumber = "";
        if(a < 0) {
            signedNumber += "-";
            a/=-1;
        }

        if(x % 10 == 0) {
           String number = String.valueOf(x);
           String removeZero = "";
           int i = number.length() -1 ;
           while (number.charAt(i) == '0') {
               i--;
           }
            removeZero = number.substring(0, i + 1);


            a = Integer.valueOf(removeZero);
        }

        String numberString = String.valueOf(a);
        String result = "";
       for(int i = numberString.length() -1; i >=0; i--) {
           result += numberString.charAt(i) + "";
       }

        try{
            return Integer.valueOf(signedNumber + result);
        } catch (ArithmeticException | NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
//        System.out.println(reverse(901000));
        System.out.println(solution(6, 20));
        System.out.println("Cơm cháo");
    }
}
