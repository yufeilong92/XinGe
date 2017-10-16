package com.lawyee.xinge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XGPushConfig.enableDebug(this,true);
        setContentView(R.layout.activity_main);
        XGPushManager.registerPush(this,callback);

    }
    private XGIOperateCallback callback =new  XGIOperateCallback(){

        @Override
        public void onSuccess(Object data, int i) {
            Log.d("TPush", "注册成功，设备token为：" + data);
        }

        @Override
        public void onFail(Object data, int errCode, String msg) {
            Log.d("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
        }
    };
}
