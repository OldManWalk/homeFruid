package com.example.homefruid.thread;

import android.os.Looper;

import com.example.homefruid.FruiService;
import com.example.homefruid.MainActivity;

public class Daughter extends Thread{
    private String name = "女儿";
    @Override
    public void run() {
        try {

            while(true) {
                FruiService.haveApple.acquire();
                Disk.getFruit(name);
                sleep(1000);
                FruiService.disk.release();

            }
        } catch (InterruptedException e) {

        }
    }
}
