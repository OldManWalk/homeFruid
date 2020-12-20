package com.example.homefruid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.homefruid.thread.Son;
import com.example.homefruid.thread.Farther;
import com.example.homefruid.thread.Mother;
import com.example.homefruid.thread.Daughter;

import java.util.concurrent.Semaphore;

public class FruiService extends Service {
    //初始化桌子为空的信号量为1，使父亲和母亲的线程能运行，1：桌子为空    0：桌子不为空
    public static Semaphore disk = new Semaphore(1);
    //初始化信号量为0，使儿子和女儿线程阻塞
    public static Semaphore haveOrange= new Semaphore(0);
    public static Semaphore haveApple = new Semaphore(0);
    private final String TAG = "FruiService";
    Farther farther ;
    Mother mother ;
    Son son ;
    Daughter daughter ;
    //定义onBinder方法所返回的对象
    private MyBinder binder = new MyBinder();
    public class MyBinder extends Binder
    {

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind方法被调用!");
        return null;
    }
    //Service断开连接时回调
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind方法被调用!");
        return true;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind方法被调用!");
        super.onRebind(intent);
    }
    //Service被创建时调用
    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate方法被调用!");
        super.onCreate();
    }

    //Service被启动时调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        farther=new Farther();
        mother =new Mother();
        son =new Son();
        daughter = new Daughter();
        farther.start();
        mother.start();
        son.start();
        daughter.start();
        Log.i(TAG, "onStartCommand方法被调用!");
        return super.onStartCommand(intent, flags, startId);
    }

    //Service被关闭之前回调
    @Override
    public void onDestroy() {
        farther.interrupt();
        mother.interrupt();
        son.interrupt();
        daughter.interrupt();
        disk = new Semaphore(1);
        haveOrange= new Semaphore(0);
        haveApple = new Semaphore(0);
        Log.i(TAG, "onDestory方法被调用!");
        super.onDestroy();
    }

}
