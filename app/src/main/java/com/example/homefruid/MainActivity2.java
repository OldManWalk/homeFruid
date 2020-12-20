package com.example.homefruid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.homefruid.thread.Disk;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout button1;
    LinearLayout button2;
    LinearLayout button3;
    LinearLayout button4;
    ImageView imgview;
    com.github.zagum.switchicon.SwitchIconView switchIconView1;
    com.github.zagum.switchicon.SwitchIconView switchIconView2;
    com.github.zagum.switchicon.SwitchIconView switchIconView3;
    com.github.zagum.switchicon.SwitchIconView switchIconView4;
    List<String> data;
    ListView list_test;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        switchIconView1=findViewById(R.id.switchIconView1);
        switchIconView2=findViewById(R.id.switchIconView2);
        switchIconView3=findViewById(R.id.switchIconView3);
        switchIconView4=findViewById(R.id.switchIconView4);
        switchIconView1.setIconEnabled(true);
        switchIconView2.setIconEnabled(true);
        imgview=findViewById(R.id.panzi);
        data = new ArrayList<String>();
        adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,data);
        list_test = (ListView) findViewById(R.id.tv_TV);
        list_test.setAdapter(adapter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIconView1.switchState();
                switchIconView2.switchState();
                switchIconView4.switchState();
                imgview.setImageResource(R.drawable.apple);
                data.add("爸爸放进去了一个苹果");
                handler.sendEmptyMessage(0x123);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIconView2.switchState();
                switchIconView1.switchState();
                switchIconView3.switchState();
                imgview.setImageResource(R.drawable.orange);
                data.add("妈妈放进去了一个橘子");
                handler.sendEmptyMessage(0x123);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIconView3.switchState();
                switchIconView1.switchState();
                switchIconView2.switchState();
                imgview.setImageResource(R.drawable.panzi);
                data.add("儿子吃了一个橘子");
                handler.sendEmptyMessage(0x123);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIconView4.switchState();
                switchIconView1.switchState();
                switchIconView2.switchState();
                imgview.setImageResource(R.drawable.panzi);
                data.add("女儿吃了一个苹果");
                adapter = new ArrayAdapter<String>(MainActivity2.this,android.R.layout.simple_expandable_list_item_1,data);
                list_test.setAdapter(adapter);
                handler.sendEmptyMessage(0x123);
            }
        });


    }


    public Handler handler = new Handler() {
        @Override
        // 当有消息发送出来的时候就执行Handler的这个方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
             adapter = new ArrayAdapter<String>(MainActivity2.this,android.R.layout.simple_expandable_list_item_1,data);
           list_test.setAdapter(adapter);      }
    };
}