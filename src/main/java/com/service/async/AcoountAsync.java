package com.service.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AcoountAsync {
    @Async("fixedTaskExecutor")
    public void processThread1(int i) {
        try {
            System.out.println("Start...");
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
