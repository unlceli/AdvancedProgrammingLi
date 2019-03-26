package com.example.li.lll.advancedprogrammingli.okhttpdemo;

public interface IHttpRequest {

    void setUrl(String url);

    void setData(byte[] data);

    void setListener(CallBackListener callBackListener);

    void execute();

}
