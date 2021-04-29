package qualifier;

import javax.inject.Inject;


@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

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
}
