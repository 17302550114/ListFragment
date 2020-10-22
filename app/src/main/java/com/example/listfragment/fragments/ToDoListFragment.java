package com.example.listfragment.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listfragment.R;

public class ToDoListFragment extends ListFragment {

    /**
     * 使用ListFragment的要点
     * ListFragment包含一个ListView，其Id必须是list，你需要使用@android：id/list使用
     * 可以自定义ListFragment中的UI，只需重载OnCreateVeiw方法，加载一个UI，但UI中必须包括@android:id/list的ListView
     * 只能使用SimpleAdapter和SimpleCursorAdapter作为适配器
     * 默认ListView中的Item布局是Simple_list_item_1,simple_item_2 and two_line_item
     * 直接使用ListFragment的setListAdapter（）来设置适配器
     * LsitView点击事件的监听，重写ListFragment的onListItemClick（ListView I， View view int postion，long id）方法
     */


    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(),"" + l.getItemAtPosition(position), Toast.LENGTH_SHORT).show();



    }
}