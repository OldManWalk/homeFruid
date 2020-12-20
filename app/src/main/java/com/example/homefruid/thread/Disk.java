package com.example.homefruid.thread;
import com.example.homefruid.MainActivity;
import com.example.homefruid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Disk {
    private static String fruit = "";
    static List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    static Map<String, Object> showitem = new HashMap<String, Object>();
    static int imgid;
    public static List<Map<String, Object>> getData() {
        return data;
    }
    public static void setData(List<Map<String, Object>> data) {
        Disk.data = data;
    }

    static int roleid;



    public static void putFruit(String role, String fruitName) {
        fruit = fruitName;
        if(fruit.equals("苹果"))
        {
            imgid = R.drawable.apple;
        }else{
            imgid = R.drawable.orange;
        }
        if(role.equals("父亲")){
            roleid = R.drawable.bab;
        }else{
            roleid = R.drawable.mom;
        }
        showitem = new HashMap<String, Object>();
        showitem.put("role", roleid);
        showitem.put("do", "往盘子里放入了一个");
        showitem.put("fruid", imgid);
        data.add(showitem);
        System.out.println(role + "往盘子里放入了一个" + fruit);
    }

    public static String getFruit(String role) {
        System.out.println(role + "吃了一个" + fruit);
         if(role.equals("儿子")){
            roleid = R.drawable.boy;
             imgid = R.drawable.orange;
        }else{
            roleid=R.drawable.girl;
            imgid = R.drawable.apple;
        }
        showitem = new HashMap<String, Object>();
        showitem.put("role", roleid);
        showitem.put("do", "吃了一个");
        showitem.put("fruid", imgid);
        data.add(showitem);
        return fruit;
    }
}