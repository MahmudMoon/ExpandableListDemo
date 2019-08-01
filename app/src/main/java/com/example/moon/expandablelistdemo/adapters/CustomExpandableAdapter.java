package com.example.moon.expandablelistdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.moon.expandablelistdemo.R;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomExpandableAdapter extends BaseExpandableListAdapter {
    ArrayList<String> group_header;
    HashMap<String,ArrayList<String>> group_child;
    Context context;

    public CustomExpandableAdapter(ArrayList<String> group_header, HashMap<String, ArrayList<String>> group_child, Context context) {
        this.group_header = group_header;
        this.group_child = group_child;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return group_header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return group_child.get(group_header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group_header.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return group_child.get(group_header.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupName = (String)getGroup(groupPosition);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        convertView = inflater.inflate(R.layout.group_header_item,null);
        TextView textView = (TextView)convertView.findViewById(R.id.tv_group_header);
        textView.setText(groupName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String)getChild(groupPosition,childPosition);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.group_child_item,null);
        TextView textView = (TextView)convertView.findViewById(R.id.tv_child_item);
        textView.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
