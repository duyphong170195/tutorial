package threads;

public class StaleReadDemo {

    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;

        while (true) {
            count++;
            a = 0;
            b = 0;

            int[] result = new int[2];

            Thread t1 = new Thread(() -> {
                a = 1;
                result[0] = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                result[1] = a;
            });

            t1.start();
            t2.start();


            t1.join();
            t2.join();

            // This is the interesting case: both threads see default value 0
            if (result[0] == 0 && result[1] == 0) {
                System.out.println("Reordering observed after " + count + " iterations.");
                System.out.println("t1 saw b = " + result[0]);
                System.out.println("t2 saw a = " + result[1]);
                break;
            }

            // Optional: slow down output for readability
            if (count % 100 == 0) {
                System.out.println("Iteration: " + count);
            }
        }
    }
}
