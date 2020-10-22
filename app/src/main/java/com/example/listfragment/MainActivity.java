package com.example.listfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.listfragment.fragments.NewItemFragment;
import com.example.listfragment.fragments.ToDoListFragment;

import java.util.ArrayList;

/**
 * Fragment和Activity通信
 * Fragment和Fragment通信
 * 都依靠他们所附着的Activity来完成通信代码，而不是在Fragment中直接获得引用来完成烟业务代码
 * 缺点：耦合性
 */

public class MainActivity extends AppCompatActivity implements NewItemFragment.OnNewItemAddedListener {
    /**
     * 操作一个ListView
     * ListView
     * Adapter
     * Data
     */

    private ArrayList<String> data;

    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //构建数据
        data = new ArrayList<String>();

        //构建适配器
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        //在Activity中获取所管辖的Fragment
        ToDoListFragment fragment = (ToDoListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_to_do_list);
        fragment.setListAdapter(adapter);
    }

    @Override
    public void newItemAdded(String content) {
        //数据源加入值
        data.add(content);
        //通知数据更新
        adapter.notifyDataSetChanged();
    }
}