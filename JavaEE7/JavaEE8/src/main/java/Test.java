import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import dao.DAOUtils;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Test {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        BeanManager bm = container.getBeanManager();

        Bean<DAOUtils> bean = (Bean<DAOUtils>) bm.getBeans("daoUtils").iterator().next();

        CreationalContext<DAOUtils> ctx = bm.createCreationalContext(bean);
        DAOUtils jdbc = (DAOUtils) bm.getReference(bean, DAOUtils.class, ctx);

        jdbc.query();
    }
}
