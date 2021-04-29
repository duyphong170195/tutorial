package qualifier;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@Named("numberUtils")
public class NumberUtils {

    @Inject
    @ThirteenDigits
    private NumberGenerator thirteen;

    @Inject
    @EightDigits
    private NumberGenerator eight;

    @Inject
    private NumberGenerator defaultGenerator;

    @Inject
    Logger log;

    public void sync() {
        System.out.println(thirteen.generateNumber());
        System.out.println(eight.generateNumber());
        System.out.println(defaultGenerator.generateNumber());
        System.out.println(log.getName());
    }
}
