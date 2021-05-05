package algorithms;

import java.math.BigInteger;

public class ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger bigInteger = new BigInteger("1");
        for(int i = n; i > 0; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigInteger);
    }




    public static void main(String[] args) {
        extraLongFactorials(5);
    }
}
