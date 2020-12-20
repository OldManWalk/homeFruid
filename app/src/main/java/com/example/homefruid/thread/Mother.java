package com.example.homefruid.thread;

import com.example.homefruid.FruiService;

public class Mother extends Thread {

    String name = "母亲";

    @Override
    public void run() {
        try {
            while(true) {
                FruiService.disk.acquire();
                Disk.putFruit(name,"苹果");
                sleep(1000);
                FruiService.haveApple.release();
            }
        } catch (InterruptedException e) {

        }
    }
}
