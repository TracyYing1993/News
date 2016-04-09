package demo.newshui.com.org.activity;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import demo.newshui.com.org.bean.VideoPlayBean;
import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.db.SQLiteDatabaseUtils;
import demo.newshui.com.org.utils.netutils.OkHttpUtils;

public class VideoWebActivity extends AppCompatActivity implements OkHttpUtils.callBack, View.OnClickListener {
    private TextureView textureview;
    private Surface surface;
    private MediaPlayer player;
    private ImageView imageView;
    private Button btn_play;
    private String url;
    private Gson gson;
    private String video_url;
    private View view_anim;
    private TextView text_play_time, text_title, text_describe, text_author, text_count, text_year;
    private FloatingActionButton floatingActionBtn;
    private RelativeLayout share_container;
    private String id;
    private String title;
    private String imageUrl;
    private String nickname;
    private boolean isClick=true;

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
        setContentView(R.layout.activtiy_video_play);
        db=new SQLiteDatabaseUtils(this);
        floatingActionBtn = ((FloatingActionButton) findViewById(R.id.floatingActionBtn_videoweb));
        share_container = ((RelativeLayout) findViewById(R.id.share_container_videoweb));


        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("url");
        id = bundle.getString("_id");
        title = bundle.getString("title");
        imageUrl = bundle.getString("imageUrl");
        nickname = bundle.getString("nickname");


        Log.e("tag", "传进来的URl，替换了两次的================" + url);
        gson = new Gson();
        OkHttpUtils.callBackUIDataFormatOne(url, OkHttpUtils.TYPE_TEXT, this);

        text_play_time = ((TextView) findViewById(R.id.text_webvideo_time));
        text_title = ((TextView) findViewById(R.id.text_videotitle_content));
        text_describe = ((TextView) findViewById(R.id.text_video_describe));
        text_author = ((TextView) findViewById(R.id.text_video_author));
        text_count = ((TextView) findViewById(R.id.text_video_count));
        text_year = ((TextView) findViewById(R.id.text_year));

        textureview = ((TextureView) findViewById(R.id.texttrueView));
        imageView = ((ImageView) findViewById(R.id.video_img)); //视屏占位图
        view_anim = findViewById(R.id.video_loading_view); //视频播放前的加载动画
        btn_play = ((Button) findViewById(R.id.btn_play)); //播放按钮
        btn_play.setOnClickListener(this);

        floatingActionBtn.setOnClickListener(new View.OnClickListener() {
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
        oks.setTitleUrl(video_url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片

        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(video_url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(video_url);

        // 启动分享GUI
        oks.show(this);

    }


    @Override
    public void callBackUIString(String data) {
        VideoPlayBean videoplaybean = gson.fromJson(data, VideoPlayBean.class);
        VideoPlayBean.DataEntity list = videoplaybean.getData();
        video_url = list.getDownload_url();
        Log.e("tag", "视频播放的Url------------------------》");
        text_play_time.setText(list.getTip());
        text_title.setText(list.getVideo_name());
        text_describe.setText(list.getVideo_desc());
        text_author.setText(list.getDirector());
        text_count.setText(list.getPlay_count() + "次");
        text_year.setText("时间：" + list.getPublish_time());
    }

    @Override
    public void callBackUIByte(byte[] datas) {

    }

    @Override
    public void callBackVideo(String data) {

    }

    @Override
    public void onClick(View v) {
        btn_play.setVisibility(View.GONE);  //隐藏播放按钮
        imageView.setVisibility(View.GONE);  //隐藏视频占位图
        view_anim.setVisibility(View.VISIBLE); //设置视频动画可见
        textureview.setVisibility(View.VISIBLE);
        textureview.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
                surface = new Surface(surfaceTexture);
                new Thread(new Runnable() {
                    @Override
                    public void run() {  //开启线程播放音乐
                        player = new MediaPlayer();
                        try {
                            player.setDataSource(video_url);
                            player.setSurface(surface);
                            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    view_anim.setVisibility(View.GONE); //隐藏动画
                                    player.start();
                                }
                            });
                            player.prepare();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //触摸暂停
                        textureview.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (player.isPlaying()) {
                                    player.pause();
                                } else {
                                    player.start();
                                }
                            }
                        });

                        //播放完成后再显示占位图和按钮
                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                textureview.setVisibility(View.GONE);
                                btn_play.setVisibility(View.VISIBLE);  //显示播放按钮
                                imageView.setVisibility(View.VISIBLE);  //显示视频占位图
                            }
                        });

                    }
                }).start();
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                surfaceTexture = null;
                surface = null;
                player.stop();
                player.release();
                return true;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            }
        });
    }

    public void clickButton(View view) {
        switch (view.getId()) {
            case R.id.btn_oneKeyShare_videoweb:
                //一键分享
                oneshare();
                break;
            case R.id.btn_collect_videoweb:
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
                                Log.e("temp", "callBackUIByte: "+datas.length);
                                //存储到访问记录表中,返回的是影响数
                                long rows = db.addAllCloumnData(SQLiteDatabaseUtils.VIDEO_RECORD, id + "",
                                        title, datas, null, video_url, nickname,null);
                                if (rows > 0) {
                                    Toast.makeText(VideoWebActivity.this, "添加视频收藏成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(VideoWebActivity.this, "添加视频收藏失败", Toast.LENGTH_SHORT).show();

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
