package qualifier;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

@Alternative

// Neu khong khai bao qualifier o day thi mac dinh la @Default
public class MockGenerator implements NumberGenerator {
    @Override
    public String generateNumber() {
        return "MOCK";
    }
}
