package demo.newshui.com.org.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.netutils.MyTask;
import demo.newshui.com.org.utils.netutils.OkHttpUtils;

/**
 * Created by Administrator on 2016/3/22.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text_back, text_weixin,text_send,text_weibo,text_qq,text_so,text_login_atOnce;
    private EditText edit_phone,edit_yanzheng;
    private String phone,yanzheng;

    private SharedPrfUtils sharedPtf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPtf = new SharedPrfUtils(getApplicationContext(),"mode");
        if(sharedPtf.getInt("modeNum")==-1) {
            setTheme(R.style.ThemeDay);
        }else if(sharedPtf.getInt("modeNum")==1){
            setTheme(R.style.ThemeNight);
        }
        setContentView(R.layout.activtiy_login);

        edit_phone = ((EditText) findViewById(R.id.edit_phone));
        edit_yanzheng = ((EditText) findViewById(R.id.edit_yanzheng));

        text_send = ((TextView) findViewById(R.id.text_send));
        text_send.setOnClickListener(this);
        text_login_atOnce = ((TextView) findViewById(R.id.text_login_atOnce));
        text_login_atOnce.setOnClickListener(this);
        text_weixin = ((TextView) findViewById(R.id.text_weixin));
        text_weixin.setOnClickListener(this);
        text_weibo = ((TextView) findViewById(R.id.text_weibo));
        text_weibo.setOnClickListener(this);
        text_qq = ((TextView) findViewById(R.id.text_qq));
        text_qq.setOnClickListener(this);
        text_so = ((TextView) findViewById(R.id.text_so));
        text_so.setOnClickListener(this);
        text_back = ((TextView) findViewById(R.id.text_back));
        text_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_send: //发送验证
                sendYanzheng();
                break;
            case R.id.text_login_atOnce:  //立即登录
                loginAtOnce();
                break;
            case R.id.text_weixin:
                new MyTask(this).execute("http://www.baidu.com/");
                break;
            case R.id.text_weibo:
                new MyTask(this).execute("http://www.baidu.com/");
                break;
            case R.id.text_qq:
                new MyTask(this).execute("http://www.baidu.com/");
                break;
            case R.id.text_so:
                new MyTask(this).execute("http://www.baidu.com/");
                break;
            case R.id.text_back:
                finish();
                break;
        }
    }

    private void loginAtOnce() {
        yanzheng = edit_yanzheng.getText().toString();
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(yanzheng) && isNumeric(yanzheng) ){
            new MyTask(this).execute("http://www.baidu.com/");
        }else{
            Toast.makeText(LoginActivity.this, "请输入正确的的手机号和验证码", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendYanzheng() {
        phone = edit_phone.getText().toString();
        if (!TextUtils.isEmpty(phone)){
            if (isNumeric(phone) && phone.length() == 11) {
                Toast.makeText(LoginActivity.this, "已发送，请注意查收", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(LoginActivity.this, "请输入正确的的手机号", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(LoginActivity.this, "请输入正确的的手机号", Toast.LENGTH_SHORT).show();
        }
    }

    //判断是否为数字
    public  boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


