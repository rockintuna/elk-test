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

    public HttpLoggingService() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
    }

    class LoggerThread implements Runnable {

        public LoggerThread() {
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                //using tcp
                //40,000 logs
                //40,000 hits
                //0 misses

                //using filebeat
                //40,000 logs
                //40,000 hits
                //0 misses
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