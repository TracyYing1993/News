package demo.newshui.com.org.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.db.SQLiteDatabaseUtils;
import demo.newshui.com.org.utils.netutils.OkHttpUtils;
import demo.newshui.com.org.utils.urls.UrlsUtils;

public class NewsWebActivity extends AppCompatActivity {

    WebView webview;
    String fullPath;//完整地址

    FloatingActionButton floationgaction;
    private RelativeLayout share_container;
    private boolean isClick = true;
    private int newsId;
    private String title;
    private String imageUrl;
    private String create_time;

    private SQLiteDatabaseUtils db;
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
        setContentView(R.layout.news_web_layout);
        db=new SQLiteDatabaseUtils(this);

        String weburl = UrlsUtils.clickitem;

        webview = (WebView) this.findViewById(R.id.news_webview);
        floationgaction = (FloatingActionButton) this.findViewById(R.id.floatingActionBtn);
        share_container = ((RelativeLayout) findViewById(R.id.share_container));


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        //获取传过来的每项的newsId
        newsId = extras.getInt("webUrl");
        title = extras.getString("title");
        imageUrl = extras.getString("imageUrl");
        create_time = extras.getString("create_time");


        Log.e("MainActivity", "NewsWebActivity" + newsId);
        fullPath = OkHttpUtils.getReplaceFormat(weburl, "%c", newsId);

        webview.loadUrl(fullPath);

        floationgaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick) {
                    share_container.setVisibility(View.VISIBLE);
                    isClick = !isClick;
                } else {
                    share_container.setVisibility(View.GONE);
                    isClick = !isClick;
                }
            }
        });


    }

    //一键分享功能
    public void oneshare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        // oks.setTitle(getString(R.string.share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(fullPath);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片

        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(fullPath);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(fullPath);

        // 启动分享GUI
        oks.show(this);

    }

    public void clickButton(View view) {
        switch (view.getId()) {
            case R.id.btn_oneKeyShare_web:
                //一键分享
                oneshare();
                break;
            case R.id.btn_collect_web:
                //收藏
                if (!TextUtils.isEmpty(imageUrl)) {
                    Log.e("temp", "onItemClick: 已在Web图里面");
                    OkHttpUtils.callBackUIDataFormatOne(imageUrl, OkHttpUtils.TYPE_BYTE, new OkHttpUtils.callBack() {
                        @Override
                        public void callBackUIString(String data) {

                        }

                        @Override
                        public void callBackUIByte(byte[] datas) {
                            if (datas != null) {
                                //存储到访问记录表中,返回的是影响数
                                long rows = db.addAllCloumnData(SQLiteDatabaseUtils.NEWS_RECORD, newsId + "",
                                        title, datas, create_time, null, null,null);
                                if (rows > 0) {
                                    Toast.makeText(NewsWebActivity.this, "添加新闻收藏成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(NewsWebActivity.this, "添加新闻收藏失败", Toast.LENGTH_SHORT).show();

                                }
                                share_container.setVisibility(View.GONE);
                                isClick = !isClick;
                            }
                        }

                        @Override
                        public void callBackVideo(String data) {

                        }
                    });
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }

}
