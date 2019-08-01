package com.example.moon.expandablelistdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.example.moon.expandablelistdemo.R;
import com.example.moon.expandablelistdemo.adapters.CustomExpandableAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> group_header;
    private HashMap<String, ArrayList<String>> group_child;
    private ExpandableListView expandableListView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.exp_list_view);
        group_header = new ArrayList<>();
        group_child = new HashMap<>();
        prepareData();
        if(group_header.size()>0 && group_child.size()>0){
            CustomExpandableAdapter customExpandableAdapter = new CustomExpandableAdapter(group_header,group_child,getApplicationContext());
            expandableListView.setAdapter(customExpandableAdapter);
        }else{
            Log.i(TAG, "onCreate: "+"Data Not Ready");
        }




    }

    private void prepareData() {
        group_header.add("Item 1");
        group_header.add("Item 2");
        group_header.add("Item 3");

        ArrayList<String> item_1 = new ArrayList<>();
        item_1.add("subItem 1_1");
        item_1.add("subItem 1_2");
        item_1.add("subItem 1_3");
        item_1.add("subItem 1_4");

        ArrayList<String> item_2 = new ArrayList<>();
        item_2.add("subItem 2_1");
        item_2.add("subItem 2_2");
        item_2.add("subItem 2_3");

        ArrayList<String> item_3 = new ArrayList<>();
        item_3.add("subItem 3_1");
        item_3.add("subItem 3_2");
        item_3.add("subItem 3_3");

        group_child.put(group_header.get(0),item_1);
        group_child.put(group_header.get(1),item_2);
        group_child.put(group_header.get(2),item_3);
    }
}
