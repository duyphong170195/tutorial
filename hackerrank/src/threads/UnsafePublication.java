package threads;

class Holder {
    int x;
}

public class UnsafePublication {
    static volatile Holder holder;

    public static void main(String[] args) {
        Thread writer = new Thread(() -> {
            Holder h = new Holder();
            h.x = 10;
            holder = h;
        });

        Thread reader = new Thread(() -> {
            Holder h = holder;
            if (h != null) {
                System.out.println(h.x); // Might print 0!
            }
        });

        writer.start();
        reader.start();
    }
}
