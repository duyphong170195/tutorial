package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PaymentService {

    // Simulate third-party callback-style API
    interface Callback {
        void onSuccess(String transactionId);
        void onFailure(Exception e);
    }

    void pay(String orderId, Callback callback) {
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate API delay
                if (Math.random() > 0.5) {
                    callback.onSuccess(orderId);
                } else {
                    callback.onFailure(new RuntimeException("Payment failed"));
                }
            } catch (InterruptedException e) {
                callback.onFailure(e);
            }
        }).start();
    }

    // Wrap it in a CompletableFuture
    public CompletableFuture<String> payAsync(String orderId) {
        CompletableFuture<String> future = new CompletableFuture<>();

        pay(orderId, new Callback() {
            @Override
            public void onSuccess(String orderId) {
                future.complete(orderId); // ✅ Success
            }

            @Override
            public void onFailure(Exception e) {
                future.completeExceptionally(e); // ❌ Failure
            }
        });

        return future;
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.payAsync("ORDER001")
               .thenAccept(txnId -> System.out.println("Payment success: " + txnId))
               .exceptionally(ex -> {
                   System.out.println("Payment failed: " + ex.getMessage());
                   return null;
               });

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                      // corePoolSize
                4,                      // maximumPoolSize
                10, TimeUnit.SECONDS,   // keepAliveTime
                new LinkedBlockingQueue<>()
        );
//        executor.submit();
//        Executors.newFixedThreadPool()
    }
}
