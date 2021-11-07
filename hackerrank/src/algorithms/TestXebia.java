package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestXebia
{
    public static void main(String[] args) {
        Random random  = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        // event
        list.stream().filter(number -> number % 2 == 0  ).collect(Collectors.toList());

    }
}
