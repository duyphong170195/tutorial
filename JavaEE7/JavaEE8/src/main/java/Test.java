import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import dao.DAOUtils;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import qualifier.NumberUtils;

public class Test {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        BeanManager bm = container.getBeanManager();

        Bean<NumberUtils> bean =     (Bean<NumberUtils>) bm.getBeans("numberUtils").iterator().next();

        CreationalContext<NumberUtils> ctx = bm.createCreationalContext(bean);
        NumberUtils numberUtils = (NumberUtils) bm.getReference(bean, NumberUtils.class, ctx);

        numberUtils.sync();
    }
}
