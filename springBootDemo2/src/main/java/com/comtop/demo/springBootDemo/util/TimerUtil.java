package com.comtop.demo.springBootDemo.util;


import ch.qos.logback.core.util.ExecutorServiceUtil;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//java定时器,参考https://blog.csdn.net/mazegong/article/details/77743805
public class TimerUtil {
    //方式一,创建一个thread，然后让它在while循环里一直运行着
    public static void way1(){
        final long time = 1000;
        Runnable way1=new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Hello!!");
                }
            }
        };
        Thread thread1=new Thread(way1);
        thread1.run();
    }
    //方式二
    public static void way2(){
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        Timer timer =new Timer();
        long delay = 0;
        long intebalPeriod = 1* 1000;
        timer.scheduleAtFixedRate(tt,delay,intebalPeriod);
    }
    //方式三
    public static void way3(){
        Runnable r3=new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间(s)，第三个参数为定时执行的间隔时间(s)
        service.scheduleAtFixedRate(r3,2,3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        TimerUtil.way3();
    }
}
