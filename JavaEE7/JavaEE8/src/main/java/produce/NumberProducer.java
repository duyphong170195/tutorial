package produce;

import qualifier.ThirteenDigits;

import javax.enterprise.inject.Produces;
import java.util.Random;

public class NumberProducer {

    @Produces
    @ThirteenDigits
    private String prefix13digits = "13-";

    @Produces @ThirteenDigits
    private int editorNumber = 84356;

    @Produces
    @qualifier.Random
    public double random() {
        return Math.abs(new Random().nextInt());
    }
}
