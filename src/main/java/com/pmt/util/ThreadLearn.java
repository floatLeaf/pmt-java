package com.pmt.util;

import org.springframework.stereotype.Component;

@Component
public class ThreadLearn extends Thread{
    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            count--;
            System.out.println(count);
            if (count == 2) return;
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
