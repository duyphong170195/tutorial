package threads;

public class VisibilityIssue {
    static boolean flag = false;
    static int data = 0;

    public static void main(String[] args) {
        Thread writer = new Thread(() -> {
            data = 42;
            flag = true;
        });

        Thread reader = new Thread(() -> {
            while (!flag); // spin until flag is true
            System.out.println("Read data: " + data);
        });

        writer.start();
        reader.start();
    }
}
