package com.example.homefruid.thread;

import com.example.homefruid.FruiService;

public class Farther extends Thread {

    String name = "父亲";

    @Override
    public void run() {
        try {
            while(true) {
                FruiService.disk.acquire();
                Disk.putFruit(name,"桔子");
                sleep(1000);
                FruiService.haveOrange.release();
            }
        } catch (InterruptedException e) {

        }
    }
}
