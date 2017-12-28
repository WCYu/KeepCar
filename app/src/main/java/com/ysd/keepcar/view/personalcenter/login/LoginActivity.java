package com.ysd.keepcar.view.personalcenter.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ysd.keepcar.R;
import com.ysd.keepcar.utils.NoDoubleClickListener;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.MainActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//登陆页面
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText shoujihao_login;
    private EditText yanzhengma_login;
    private TextView huoqu_login;
    private Button denglu_login;

    private EventHandler eventHandler;
    private String s1;
    private String s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }


    private void initView() {
        shoujihao_login = (EditText) findViewById(R.id.shoujihao_login);
        yanzhengma_login = (EditText) findViewById(R.id.yanzhengma_login);
        huoqu_login = (TextView) findViewById(R.id.huoqu_login);
        denglu_login = (Button) findViewById(R.id.denglu_login);

        denglu_login.setOnClickListener(this);
        huoqu_login.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.denglu_login:
                s2 = yanzhengma_login.getText().toString();
                Map<String,Object> map1 = new HashMap<>();
                map1.put("accountUname", s1);
                map1.put("vCode",s2);
                String s3 = ZJson.toJSONMap(map1);
                OkhttpUtil.getInstance().post(UrlPath.URLPATHAPP + UrlPath.URLPATHLOGIN, s3, new Callback() {
                    @Override
                    public void onFailure(Call call, final IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, string, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case R.id.huoqu_login:

                s1 = shoujihao_login.getText().toString();

                Map<String,Object> map2 = new HashMap<>();
                map2.put("accountUname", s1);
                final String s = ZJson.toJSONMap(map2);
                Log.e("TAG", "s----------"+s );

                OkhttpUtil.getInstance().post(UrlPath.URLPATHAPP + UrlPath.URLPATHVERCODE, s, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "11111----------"+e );
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, string, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
        }
    }
}
