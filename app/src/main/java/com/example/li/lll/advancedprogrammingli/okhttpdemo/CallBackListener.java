package com.example.li.lll.advancedprogrammingli.okhttpdemo;

import java.io.InputStream;

public interface CallBackListener {

    void onSuccess(InputStream inputStream);

    void onFailure();
}
