package qualifier;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Inject
    @ThirteenDigits
    private String prefix;
    @Inject @ThirteenDigits
    private int editorNumber;
    @Inject
    @Random
    private double postfix;

    public String generateNumber() {
        return prefix + editorNumber + postfix;
    }

    @AroundInvoke
    private Object logMethod(InvocationContext ic) throws Exception {
        Map<String, String> map = new HashMap<>();
        logger.entering("eeeeen" + ic.getTarget().toString(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting("eeeeex" +ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
