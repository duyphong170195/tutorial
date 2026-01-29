package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeadlockDemo {

    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) throws Exception {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Runnable runnable = () -> System.out.println("I am a runnable"); //1
        Callable<Object> callable = () -> { System.out.println("I am a Callable"); return null; }; //2

//        Future<Object> runnableResult = threadPool.submit(runnable); //3
//        Future<Object> callableResult = threadPool.submit(callable); //4
//        Thread t1 = new Thread(() -> {
//            synchronized (LOCK_A) {
//                sleep(200); // make timing predictable
//                synchronized (LOCK_B) {
//                    System.out.println("t1 acquired A then B");
//                }
//            }
//        }, "T1-A-then-B");
//
//        Thread t2 = new Thread(() -> {
//            synchronized (LOCK_B) {
//                sleep(200);
//                synchronized (LOCK_A) {
//                    System.out.println("t2 acquired B then A");
//                }
//            }
//        }, "T2-B-then-A");
//
//        t1.start();
//        t2.start();
//
//        // Keep JVM alive so you can take thread dumps
//        t1.join();
//        t2.join();
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}

//@GetMapping("download-file")
//@ExecutionTimer(maxThreshold = 60, timeUnit = TimeUnit.SECONDS)
//public ResponseEntity<InputStreamResource> downloadFile(@RequestParam UUID documentId) {
//    return documentService.downloadDocument(documentId);
//}
//
//@Slf4j
//@Aspect
//@Component
//public class ExecutionTimerAspect {
//    @Around("@annotation(executionTimer)")
//    public Object executionTimeLogger(ProceedingJoinPoint joinPoint, ExecutionTimer executionTimer) {
//        try {
//            StopWatch stopWatch = new StopWatch();
//
//            stopWatch.start();
//
//            Object proceed = joinPoint.proceed();
//
//            stopWatch.stop();
//
//            long executionTime = stopWatch.getTotalTimeMillis();
//
//            TimeUnit timeUnit = executionTimer.timeUnit();
//
//            switch (timeUnit) {
//                case MILLISECONDS:
//                    break;
//                case MINUTES:
//                    executionTime = executionTime / 60000;
//
//                    break;
//                case SECONDS:
//                default:
//                    executionTime = executionTime / 1000;
//
//                    break;
//            }
//
//            int maxThresholdTime = executionTimer.maxThreshold();
//
//            if (maxThresholdTime > 0 && executionTime > maxThresholdTime) {
//                log.warn("[executionTimeLogger] {} method was executed in {} {} which was higher than expected " +
//                                "Max Threshold Time of {} {}",
//                        joinPoint.getSignature(), executionTime, timeUnit, maxThresholdTime, timeUnit);
//            } else {
//                log.info("[executionTimeLogger] {} method was executed in {} {}", joinPoint.getSignature(),
//                        executionTime, timeUnit);
//            }
//            return proceed;
//        } catch (Throwable e) {
//            log.error("[executionTimeLogger] There was an error while calculating method execution time for {}",
//                    joinPoint.getSignature(), e);
//
//            return null;
//        }
//    }