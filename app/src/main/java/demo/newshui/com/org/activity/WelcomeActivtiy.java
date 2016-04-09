package demo.newshui.com.org.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import demo.newshui.com.org.adapter.WelcomePagerAdapter;
import demo.newshui.com.org.utils.SharedPrfUtils;

/**
 * Created by Administrator on 2016/3/21.
 * 欢迎界面
 */
public class WelcomeActivtiy extends AppCompatActivity{
    private SharedPrfUtils utils;
    private ViewPager viewPager;
    private WelcomePagerAdapter adapter;
    private List<View> imgList;  //存放ImageView的集合
    private int [] img_arr = {R.mipmap.guide_first,R.mipmap.guide_second,R.mipmap.guide_third};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_welcome);

        putIntoSharePref(); //存入到SharePrefrences
        setImageToList(); //设置图片资源
        setViewPager();  //设置ViewPager

    }

    private void setViewPager() {
        viewPager = (ViewPager) this.findViewById(R.id.viewpager_welcome);
        adapter = new WelcomePagerAdapter(imgList,this);
        viewPager.setAdapter(adapter);
    }

    private void setImageToList() {
        imgList = new ArrayList<View>();
        for (int i = 0;i < img_arr.length-1 ;i++){  //前两张欢迎图
            ImageView imgView = new ImageView(this);
            imgView.setBackgroundResource(img_arr[i]);
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgList.add(imgView);
        }
        LayoutInflater inflater = LayoutInflater.from(this);  //最后一张欢迎图
        View view = inflater.inflate(R.layout.activity_welcome_click, null);//第三张带点击的图片
        imgList.add(view);
    }

    private void putIntoSharePref() {
        utils = new SharedPrfUtils(WelcomeActivtiy.this,"SharedPreferencesHelper");
        /** 存入到SharePrefrences中 */
        utils.putInt(StartActivtiy.IS_FIRST_RUN, StartActivtiy.NOT_FIRST);
    }
}
