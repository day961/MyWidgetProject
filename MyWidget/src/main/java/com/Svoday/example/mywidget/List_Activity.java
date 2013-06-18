package com.Svoday.example.mywidget;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by suoday on 13-6-15.
 */
public class List_Activity extends ListActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//            setContentView(R.layout.list_activity);
            setTheme(android.R.style.Theme_Black);
            ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
            HashMap<String,String> map1 = new HashMap<String, String>();
            HashMap<String,String> map2 = new HashMap<String, String>();
            HashMap<String,String> map3 = new HashMap<String, String>();
            map1.put("list_first","aaa");
            map1.put("list_second","111");
            map2.put("list_first","bbb");
            map2.put("list_second","222");
            map3.put("list_first","ccc");
            map3.put("list_second","333");
            list.add(map1);
            list.add(map2);
            list.add(map3);
            SimpleAdapter listAdapter = new SimpleAdapter(this,
                    list,R.layout.list_widget,new String[]{"list_first","list_second"},
                    new int[]{R.id.list_first,R.id.list_second});
            setListAdapter(listAdapter);
        }

    //点击事件
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(id == 1)
            Toast.makeText(List_Activity.this,"the second was push",Toast.LENGTH_SHORT).show();
    }

    //长按事件
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}