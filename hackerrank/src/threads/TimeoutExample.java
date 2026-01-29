package threads;

import java.util.concurrent.*;

public class TimeoutExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> longTask = () -> {
            try {
                // Simulate long work
                Thread.sleep(15000);
                return "Done";
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted");
                return "Interrupted";
            }
        };

        Future<String> future = executor.submit(longTask);

        try {
            // Wait max 10 seconds
            String result = future.get(10, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Timeout! Cancelling task...");
            future.cancel(true); // Sends interrupt signal
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }
}
