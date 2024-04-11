package me.rockintuna.elktest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HttpLoggingService {
    Logger logger = LoggerFactory.getLogger(HttpLoggingService.class);


    Thread thread1 = new Thread(new LoggerThread());
    Thread thread2 = new Thread(new LoggerThread());
    Thread thread3 = new Thread(new LoggerThread());
    Thread thread4 = new Thread(new LoggerThread());
    Thread thread5 = new Thread(new LoggerThread());
    Thread thread6 = new Thread(new LoggerThread());
    Thread thread7 = new Thread(new LoggerThread());
    Thread thread8 = new Thread(new LoggerThread());

    public HttpLoggingService() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        //80,000 logs
        //66,168 hits
        //13,832 misses
    }

    class LoggerThread implements Runnable {

        public LoggerThread() {
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                logger.info("Hello, World! {}", i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}