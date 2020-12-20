package com.example.homefruid.thread;

import com.example.homefruid.FruiService;

public class Son extends Thread{

    private String name = "儿子";

    @Override
    public void run() {
        try {
            while(true) {
                FruiService.haveOrange.acquire();
                Disk.getFruit(name);
                sleep(1000);
                FruiService.disk.release();
            }
        } catch (InterruptedException e) {

        }
    }
}
