package com.swain.programmingpearls.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorSwain {

    public static void main(String[] args) {
        ScheduledExecutorSwain scheduledExecutorSwain = new ScheduledExecutorSwain();
//        try {
//            scheduledExecutorSwain.test_schedule4Runnable();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            scheduledExecutorSwain.test_schedule4Callable();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            scheduledExecutorSwain.test_scheduleAtFixedRate();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
        try {
            scheduledExecutorSwain.test_scheduleWithFixedDelay();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void test_schedule4Runnable() throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture future = service.schedule(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
        }, 1000, TimeUnit.MILLISECONDS);
        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));

        System.out.println("Runnable future's result is: " + future.get() +
                ", and time is: " + format(System.currentTimeMillis()));
    }

    public void test_schedule4Callable() throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> future = service.schedule(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
            return "success";
        }, 1000, TimeUnit.MILLISECONDS);
        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));

        System.out.println("Callable future's result is: " + future.get() +
                ", and time is: " + format(System.currentTimeMillis()));
    }

    public void test_scheduleAtFixedRate() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleAtFixedRate(() -> {
            try {
//                Thread.sleep(3000L);
                System.out.println(format(System.currentTimeMillis()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
        }, 1000L, 3000L, TimeUnit.MILLISECONDS);

        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));
    }

    public void test_scheduleWithFixedDelay() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleWithFixedDelay(() -> {
            try {
//                Thread.sleep(3000L);
                System.out.println(format(System.currentTimeMillis()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
        }, 1000L, 3000L, TimeUnit.MILLISECONDS);

        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));
        while (true) {
        }
    }

    private String format(long currentTimeMillis) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        res = simpleDateFormat.format(new Date(currentTimeMillis));
        return res;
    }
}
