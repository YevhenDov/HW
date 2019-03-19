package com.scheduledfuture;

import java.util.concurrent.*;

public class Scheduled {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> scheduledFuture1 = service.schedule(new FirstTask(), 5, TimeUnit.SECONDS);
        ScheduledFuture<String> scheduledFuture2 = service.schedule(new SecondTask(), 3, TimeUnit.SECONDS);
        ScheduledFuture<String> scheduledFuture3 = service.schedule(new ThirdTask(), 1, TimeUnit.SECONDS);

        System.out.println(scheduledFuture1.getDelay(TimeUnit.SECONDS) + 1 + " second remaining for First thread.");
        System.out.println(scheduledFuture2.getDelay(TimeUnit.SECONDS) + 1 + " second remaining for Second thread.");
        System.out.println(scheduledFuture3.getDelay(TimeUnit.SECONDS) + 1 + " second remaining.for Third thread.");
    }

    static class FirstTask implements Callable<String> {
        @Override
        public String call() {
            return "First task.";
        }
    }

    static class SecondTask implements Callable<String> {
        @Override
        public String call() {
            return "Second task.";
        }
    }


    static class ThirdTask implements Callable<String> {
        @Override
        public String call() {
            return "Third task.";
        }
    }
}
