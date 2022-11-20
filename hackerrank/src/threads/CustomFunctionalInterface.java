package threads;

@FunctionalInterface
public interface CustomFunctionalInterface {
//    Integer add(Integer a, Integer b, Integer c, Integer d);
//    void add(Integer a, Integer b, Integer c);
    void doSomething();

    int hashCode();

    String toString();

    boolean equals(Object obj);
}
