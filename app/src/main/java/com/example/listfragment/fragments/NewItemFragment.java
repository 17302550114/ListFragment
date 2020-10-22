package com.example.listfragment.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listfragment.R;


public class NewItemFragment extends Fragment {

    private EditText mEditNewItem;

    public NewItemFragment() {
    }

    //声明一个接口，定义要向Activity传值的方法
    public interface OnNewItemAddedListener {
        public void newItemAdded(String content);
    }

    //声明一个接口引用变量
    private OnNewItemAddedListener onNewItemAddedListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //要求该Fragment附着的Activity必须完成这个方法实现
        try {
            onNewItemAddedListener = (OnNewItemAddedListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_item, container, false);
        mEditNewItem = view.findViewById(R.id.edit_new_item);
        mEditNewItem.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //判断键按下
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    //判断按下ENTER
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        String content = mEditNewItem.getText().toString();
                        onNewItemAddedListener.newItemAdded(content);
                        mEditNewItem.setText("");
//                        Fragment fragmentToDoList = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_to_do_list);
                        return true;
                    }
                }
                return false;
            }
        });
        return view;
    }
}