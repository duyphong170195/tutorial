package threads;

import datastructures.Nodee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        String mutable = new String("mutalble");
        mutable.concat("bbbb");
        System.out.println(mutable);
        char[] arrs = {'a', 'b', 'c'};
        System.out.println(arrs.toString());
        Person person = new Person();



        // We will store the threads so that we can check if they are done
        Function<String, String> function1 = a -> a + "f1";

        Function<String, String> function2 = b -> b + "f2" ;

        Function<String, String> compose = function2.compose(function1);
        Function<String, String> thenApply = function2.andThen(function1);

        System.out.println(compose.apply("hello"));
        System.out.println(thenApply.apply("hello"));
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a*b;

//        System.out.println(function.apply(3));

//        biFunction.apply(3, 4).
        Consumer<String> consumer =  a-> System.out.println(a);

        consumer.accept("phong");

        Predicate<Integer> predicate = a -> a%2 == 0;
        System.out.println(predicate.test(3));

//        CustomFunctionalInterface customFunctionalInterface = (a,b,c,d) -> a+b+c+d;
//        System.out.println(customFunctionalInterface.add(1, 2, 3, 4));

        Supplier<String> supplier = () -> "my name";


//        Runnable task = new MyRunnable(3L);
//        Thread worker = new Thread(task);
//        // We can set the name of the thread
//        worker.setName(String.valueOf(5));
//        // Start the thread, never call method run() direct
//        worker.start();
//        int running = 0;
//        do {
//            running = 0;
//            for (Thread thread : threads) {
//                if (thread.isAlive()) {
//                    running++;
//                }
//            }
//            System.out.println("We have " + running + " running threads. ");
//        } while (running > 0);








        String email = "phong.nguyenduy@gmail.com";
        String[] strings = email.split("@");
        StringBuilder stringBuilder = new StringBuilder(strings[0]);
        stringBuilder.setCharAt(2, '-');
        System.out.println(stringBuilder);
        for(int i = 1; i < strings[0].length() - 2; i++) {
            stringBuilder.setCharAt(i, '-');
        }

        List<Integer> numberList = Arrays.asList(10,4,2,8,4);

        int maxNumber = numberList.get(0);
        int minNumber = numberList.get(0);
        for(int i = 1 ; i < numberList.size(); i++) {
            if(maxNumber < numberList.get(i)) maxNumber = numberList.get(i);
            if(minNumber > numberList.get(i)) minNumber = numberList.get(i);
        }

        System.out.println("max number = " + maxNumber);
        System.out.println("min number = " + minNumber);




//        StringBuilder stringBuilder2 = new StringBuilder()

//
//
//
//        phong.nguyenduy@gmail.com
//                output:
//        p-------------y@g---l.com

    }
}