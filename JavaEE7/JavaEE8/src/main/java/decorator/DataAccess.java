package decorator;

public interface DataAccess<T, V> {

    public V getId(T object);
}
