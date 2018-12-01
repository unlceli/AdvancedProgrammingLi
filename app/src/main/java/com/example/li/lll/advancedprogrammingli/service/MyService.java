package com.example.li.lll.advancedprogrammingli.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new Mybinder();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);

    }

    class Mybinder extends Binder {
        public void pay() {
            payService();
        }//通过Binder实例将service中的方法暴露出去


    }

    private void payService() {
        Log.i("MyService", "payService: --------");
    }
}
