package NAVER;

public class MyKey {
    private String name;
    private int id;

    public MyKey(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // standard getters and setters
 
    @Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
        return id;
    } 
 
    // toString override for pretty logging


    @Override
    public boolean equals(Object o) {
        System.out.println("Calling equals() for key: " + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return id == myKey.id && name.equals(myKey.name);
    }
}