package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(4);
        numberList.add(5);
        numberList.add(9);
        numberList.add(10);
        numberList.add(40);
        numberList.add(50);
        numberList.add(90);
        numberList.add(100);
        numberList.add(400);
        numberList.add(500);
        numberList.add(900);
        numberList.add(1000);



        Map<Integer, String> numbersToRomanMap = new HashMap<>();
        numbersToRomanMap.put(1, "I");
        numbersToRomanMap.put(4, "VI");
        numbersToRomanMap.put(5, "V");
        numbersToRomanMap.put(9, "IX");
        numbersToRomanMap.put(10, "X");
        numbersToRomanMap.put(40, "XL");
        numbersToRomanMap.put(50, "L");
        numbersToRomanMap.put(90, "XC");
        numbersToRomanMap.put(100, "C");
        numbersToRomanMap.put(400, "CD");
        numbersToRomanMap.put(500, "D");
        numbersToRomanMap.put(900, "CM");
        numbersToRomanMap.put(1000, "M");

        int numClone = num;
        StringBuilder result = new StringBuilder();
        while (numClone != 0) {
            int numberToRoman = locateNumberInRange(numberList, 0, numberList.size()-1, numClone);
            int countRoman = numClone/numberToRoman;
            String romanCharacter = numbersToRomanMap.get(numberToRoman);
            result.append(romanCharacter.repeat(countRoman));
            numClone = numClone%numberToRoman;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(8878787));
        System.out.println(intToRoman2(8878787));

    }

    public static int locateNumberInRange(List<Integer> numbers, int l, int r, int number) {
        // 1,2,3,4,5,6,7,8,9
        // size = 9
        // 9/2 = 4

        int middle = l + (r - l) / 2;
        // truong hop trong range
        // truong hop
        if(l == r && r == middle) {
            return numbers.get(middle);
        }

        if(number == numbers.get(middle)) {
            return number;
        }
        if(number == numbers.get(middle-1)) {
            return number;
        }
        if(number == numbers.get(middle+1)) {
            return number;
        }
        if(number > numbers.get(middle) && number < numbers.get(middle + 1)) {
            return numbers.get(middle);
        }
        if(number > numbers.get(middle-1) && number < numbers.get(middle)) {
            return numbers.get(middle-1);
        }

        // number = 20
        if(number >  numbers.get(middle)) {
            return locateNumberInRange(numbers, middle + 1, r, number);
        } else {
            return locateNumberInRange(numbers, l, middle, number);
        }
    }

    public static String intToRoman2(int num) {
        int[] no={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] code={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<no.length;i++)
        {
            while(num >= no[i])
            {
                sb.append(code[i]);
                num-=no[i];
            }
        }

        return sb.toString();
    }
}
/*
* Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV

I             1
VI            4
V             5
IX            9
X             10
XL            40
L             50
XC            90
C             100
CD            400
D             500
CM            900
M             1000

    27/10 = 2
    7/5 = 1
    2/1 =2

    58/50 = 1 -> L
    8/5   = 1 -> V
    3/1   = 3 -> III
* */