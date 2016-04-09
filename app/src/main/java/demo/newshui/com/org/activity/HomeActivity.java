package demo.newshui.com.org.activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import demo.newshui.com.org.fragment.MeFragment;
import demo.newshui.com.org.fragment.NewsFragment;
import demo.newshui.com.org.fragment.VideoFragment;
import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.dialog.DialogUtil;


public class HomeActivity extends AppCompatActivity implements NewsFragment.OnChangedMode{

    private static final String TAG = HomeActivity.class.getSimpleName();
    private RadioGroup radioTab;
    private FragmentManager fragmentManager;
    private NewsFragment newsfragment;
    private VideoFragment videoFragment;
    private MeFragment meFragment;
    private SharedPrfUtils sharedPtf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPtf = new SharedPrfUtils(getApplicationContext(),"mode");
        int modeNum = sharedPtf.getInt("modeNum");
        if(modeNum ==-1) {
            Log.e(TAG, "onCreate:modeNum= "+modeNum);
            setTheme(R.style.ThemeDay);
        }else if(modeNum==1){
            Log.e(TAG, "onCreate:modeNum= "+modeNum);
            setTheme(R.style.ThemeNight);
        }
        setContentView(R.layout.activity_home);
        radioTab = ((RadioGroup) findViewById(R.id.radioTab));
        initRadioGroup();
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        newsfragment = new NewsFragment();
        transaction.replace(R.id.fragmentContainer, newsfragment);
        transaction.commit();
    }

    private void initRadioGroup() {


        radioTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                //先隐藏之前的Fragment
                hideBeforeFragment(transaction);
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton.getId() == checkedId) {
                        //替换Fragment
                        switch (i) {
                            case 0:

                                if (newsfragment == null) {
                                    newsfragment = new NewsFragment();
                                    transaction.add(R.id.fragmentContainer, newsfragment);
                                } else {
                                    transaction.show(newsfragment);
                                }
                                break;
                            case 1:

                                if (videoFragment == null) {
                                    videoFragment = new VideoFragment();
                                    transaction.add(R.id.fragmentContainer, videoFragment);
                                } else {
                                    transaction.show(videoFragment);
                                }
                                break;
                            case 2:

                                if (meFragment == null) {
                                    meFragment = new MeFragment();
                                    transaction.add(R.id.fragmentContainer, meFragment);
                                } else {
                                    transaction.show(meFragment);
                                }
                                break;
                        }

                        transaction.commit();
                        //改变颜色
                        radioButton.setTextColor(getResources().getColor(R.color.textColor));
                    } else {
                        radioButton.setTextColor(Color.WHITE);
                    }
                }
            }
        });
    }

    private void hideBeforeFragment(FragmentTransaction transaction) {
        if (newsfragment != null) {
            transaction.hide(newsfragment);
        }
        if (videoFragment != null) {
            transaction.hide(videoFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }
    @Override
    public void onBackPressed() {

        DialogUtil.getBuilderDilog(this, R.drawable.collect, "提示",
                "确认要退出吗？");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onChanged(boolean isChanged) {
        int modeNum = sharedPtf.getInt("modeNum");

        if(isChanged) {
            Log.e(TAG, "onCreate:11modeNum= "+modeNum);
            setTheme(R.style.ThemeNight);
        }else{
            setTheme(R.style.ThemeDay);
            Log.e(TAG, "onCreate:11modeNum= " + modeNum);
        }

        setContentView(R.layout.activity_home);
        radioTab = ((RadioGroup) findViewById(R.id.radioTab));
        initRadioGroup();
       // fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //先隐藏之前的Fragment
        hideBeforeFragment(transaction);
        newsfragment = new NewsFragment();
        transaction.replace(R.id.fragmentContainer, newsfragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NewsApplication.isRefreshMode=!NewsApplication.isRefreshMode;//白天模式
    }
}
