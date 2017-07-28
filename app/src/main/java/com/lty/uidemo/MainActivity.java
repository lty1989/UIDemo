package com.lty.uidemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lty.uidemo.viewpager.ViewPagerActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(getData());
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClicked(int position) {
                Intent intent = new Intent();
                if (position == 0) {
                    intent.setClass(MainActivity.this, ViewPagerActivity.class);
                }
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }


    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        data.add("FloatAction");
        data.add("DrawerLayout");
        data.add("Navigation");
        data.add("FloatingAction");
        data.add("CoordinatorLayout");
        data.add("AppBarLayout");
        data.add("CollapsingToobar");
        return data;
    }
}
