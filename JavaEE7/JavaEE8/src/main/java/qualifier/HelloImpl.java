package qualifier;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Named
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello Phong");
    }
}
