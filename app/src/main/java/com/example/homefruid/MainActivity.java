package com.example.homefruid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ToggleButton;

import com.example.homefruid.thread.Disk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    private Map<String, Object> showitem = new HashMap<String, Object>();
    private Intent intent;
    private ToggleButton start;
    private  Button hand;
    private SimpleAdapter myAdapter;
    Disk disk;
    private Timer timer;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start =findViewById(R.id.btnstart);
        hand=findViewById(R.id.hand);
        //创建启动Service的Intent,以及Intent属性
        intent = new Intent(MainActivity.this,FruiService.class);
        //为两个按钮设置点击事件,分别是启动与停止service
        hand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                        startService(intent);
                  timer = new Timer();
                   TimerTask task = new TimerTask() {
                       private int count;
                       @Override
                       public void run() {
                           handler.sendEmptyMessage(0x123);
                       }
                   };
                   timer.schedule(task, 0, 100);
               } else {    // 停止链接Socket
                        stopService(intent);
                        timer.cancel();
               }
           }
       });
         data= new ArrayList<Map<String, Object>>();
         listView = (ListView) findViewById(R.id.listitem);
    }

    public Handler handler = new Handler() {
        @Override
        // 当有消息发送出来的时候就执行Handler的这个方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            disk = new Disk();
            data = disk.getData();
            myAdapter = new SimpleAdapter(getApplicationContext(), data, R.layout.textmassage, new String[]{"role", "do", "fruid"}, new int[]{R.id.role, R.id.text, R.id.fruid});
            //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
            listView.setAdapter(myAdapter);
        }
    };
}