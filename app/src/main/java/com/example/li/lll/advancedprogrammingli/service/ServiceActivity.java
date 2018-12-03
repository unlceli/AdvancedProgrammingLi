package com.example.li.lll.advancedprogrammingli.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.li.lll.advancedprogrammingli.R;

public class ServiceActivity extends AppCompatActivity {

    MyService.Mybinder mybinder = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


        Intent intent = new Intent(ServiceActivity.this, MyService.class);

        //bindsevice 开启服务
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                mybinder = (com.example.li.lll.advancedprogrammingli.service.MyService.Mybinder) iBinder;

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, BIND_AUTO_CREATE);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mybinder.pay();
            }
        });


    }
}
