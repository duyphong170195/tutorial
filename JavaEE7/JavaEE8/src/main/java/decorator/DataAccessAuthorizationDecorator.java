package decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class DataAccessAuthorizationDecorator<T, V> implements DataAccess<T, V> {
    @Inject
    @Delegate
    DataAccess<T, V> delegate;

    public V getId(T object) {
        System.out.println("Hello decorator");
        return delegate.getId(object);
    }
}
