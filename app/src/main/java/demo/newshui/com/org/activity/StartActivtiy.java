package demo.newshui.com.org.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import demo.newshui.com.org.utils.SharedPrfUtils;

/**
 * Created by Administrator on 2016/3/21.
 * 每次开启软件时，开始页面显示动画，并判断是否是第一次运行软件，看是跳入HomeActivty还是WelcomeActivity
 */
public class StartActivtiy extends AppCompatActivity{
    /** 保存是否是第一次运行程序的标记 */
    public final static String IS_FIRST_RUN = "isFirstRun";
    /** 不是第一次运行标识 */
    public final static int NOT_FIRST = 1;
    /** 是第一次运行标识 */
    public final static int IS_FIRST = -1;
    private SharedPrfUtils utils;
    /** 用于跳转到不同界面，并且延迟三秒 */
    private Handler handler;
    private ImageView img_home_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //开始动画
        img_home_start = ((ImageView) findViewById(R.id.img_start_anim));
        img_home_start.setBackgroundResource(R.drawable.anim_home_start);
        AnimationDrawable anim = (AnimationDrawable) img_home_start.getBackground();
        anim.start();
        initData();
    }

    private void initData() {
        utils = new SharedPrfUtils(StartActivtiy.this,"SharedPreferencesHelper");
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0:
                        goActivity(HomeActivity.class);
                        break;
                    case 1:
                        goActivity(WelcomeActivtiy.class);
                        break;
                }
            };
        };
        int isFirst = utils.getInt(IS_FIRST_RUN);
        if (isFirst == NOT_FIRST){      // 判断是否是第一次运行
            handler.sendEmptyMessageDelayed(0,2400); // 延迟时间为动画总时长
        }else{
            handler.sendEmptyMessageDelayed(1,2400);
        }
    }

    // 路转到某页面

    protected void goActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        this.finish();
    }
}
