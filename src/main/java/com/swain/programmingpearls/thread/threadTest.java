package com.swain.programmingpearls.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * thread 的几种实现
 */
public class threadTest {
    public static void main (String[] args) {
        //继承thread
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();

        //实现runnable
        Thread runThread = new Thread(new AchieveRunnable());
        runThread.start();

        //调用callable 可以有返回值 可以捕获异常
        Callable<String> tc = new TestCallable();
        FutureTask<String> task = new FutureTask<String>(tc);
        new Thread(task).start();
        try {
            System.out.println(task.get());//获取返回值
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //runable 匿名内部类方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现Runnable 匿名内部类方式：" + Thread.currentThread().getName());
            }
        }).start();

        //runnable Lamda表达式
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Lamda表达式:" + i);
            }
        }).start();

        System.out.println("主线程");

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i<5; i++)
        {
            AchieveRunnable achieveRunnable = new AchieveRunnable();
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
            executorService.execute(achieveRunnable);
        }
        //关闭线程池
        executorService.shutdown();
    }

    /**
     * 继承thread类
     */
    public static class ExtendsThread extends Thread {
        public void run(){
            System.out.println("方法一 继承Thread线程：" + Thread.currentThread().getName());
        }
    }

    /**
     * 实现runnable
     */
    public static class AchieveRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("方法二 实现Runnable：" + Thread.currentThread().getName());
        }
    }

    /**
     * 通过Callable和FutureTask创建线程
     */
    public static class TestCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("方法三 实现callable：" + Thread.currentThread().getName());
            return "我是callable的返回";
        }
    }
}

