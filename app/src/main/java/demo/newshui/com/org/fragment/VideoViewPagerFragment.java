package demo.newshui.com.org.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import demo.newshui.com.org.activity.R;
import demo.newshui.com.org.activity.VideoWebActivity;
import demo.newshui.com.org.adapter.VideoItemBaseAdapter;
import demo.newshui.com.org.bean.VideoBean;
import demo.newshui.com.org.bean.VideoItemBean;
import demo.newshui.com.org.bean.VideoOtherBean;
import demo.newshui.com.org.utils.db.SQLiteDatabaseUtils;
import demo.newshui.com.org.utils.netutils.OkHttpUtils;
import demo.newshui.com.org.utils.urls.UrlsUtils;

/**
 * Created by Administrator on 2016/3/22.
 */
public class VideoViewPagerFragment extends Fragment implements OkHttpUtils.callBack {

    private Gson gson;
    private VideoItemBaseAdapter adapter;
    private String url;
    private SwipeRefreshLayout swiperefresh;
    private boolean isRefresh;
    private View foot_View;
    private VideoItemBean videoBean;
    private SQLiteDatabaseUtils db;
    private ListView listView;
    private int  column_id=0;
    private int cursor = 20;
    private static int allColumn;
    private boolean isBottom;
    private List<VideoItemBean> list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //实例化数据库工具类
        db = new SQLiteDatabaseUtils(getActivity());

        url = getArguments().getString("url");
        gson = new Gson();
        Log.e("TAG", "进来了" + url);
        OkHttpUtils.callBackUIDataFormatOne(url, OkHttpUtils.TYPE_TEXT, this);
        list = new ArrayList<>();
        adapter = new VideoItemBaseAdapter(list);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_inside_fragment_layout, container, false);
        swiperefresh = ((SwipeRefreshLayout) view.findViewById(R.id.swiperefresh_video));
        listView = (ListView) view.findViewById(R.id.video_inside_listView);
        //添加EmptyView  加载杯子动画
        View emptyview = view.findViewById(R.id.emptyview_video);
        listView.setEmptyView(emptyview);
        foot_View = LayoutInflater.from(getActivity()).inflate(R.layout.footer_view_layout, listView, false);
        //先将footView隐藏，在上拉时在显示出来
        foot_View.setVisibility(View.GONE);
        listView.addFooterView(foot_View);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                videoBean = (VideoItemBean) adapter.getItem(position);
                long vid = videoBean.getVid();
                long aid = videoBean.getAid();
                Log.e("tag", "要替换的两个：aid" + aid + "   vid" + vid);
                Intent intent = new Intent(getContext(), VideoWebActivity.class);
                Bundle bundle = new Bundle();
                url = UrlsUtils.VIDEO_URL.replace("%c", String.valueOf(vid));
                url = url.replace("%d", String.valueOf(aid));
                bundle.putString("url", url);

                bundle.putString("_id", videoBean.getAid() + "");
                bundle.putString("title", videoBean.getVideoName() + "");
                bundle.putString("imageUrl", videoBean.getPic_url());
                bundle.putString("nickname", videoBean.getNickName());

                intent.putExtras(bundle);
                startActivity(intent);
                //存储到记录表中
                //获得图片路径并下载
                String imgurl = videoBean.getPic_url();
                if (!TextUtils.isEmpty(imgurl)) {
                    Log.e("temp", "onItemClick: 已在里面");
                    OkHttpUtils.callBackUIDataFormatOne(imgurl, OkHttpUtils.TYPE_BYTE, VideoViewPagerFragment.this);
                }
            }
        });

        listView.setAdapter(adapter);
        setScrollListener();
        initSwipeRefresh();

        return view;
    }

    private void initSwipeRefresh() {
        //刷新时旋转的颜色
        swiperefresh.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        //添加监听事件
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //做更新操作
                updateData();
            }
        });

    }

    private void setScrollListener() {
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //判断是否停止滚动和到了底部
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && isBottom) {

                    //显示footView
                    foot_View.setVisibility(View.VISIBLE);
                    int count = adapter.getCount();
                    VideoItemBean item = (VideoItemBean) adapter.getItem(count - 1);
                    if (item.getColumn_id()!=660){
                        String url = UrlsUtils.VIDEO_PAGE.replace("%d", String.valueOf(item.getColumn_id()));

                        if (cursor == 20) {
                            Log.e("TAG", "xxxxxxxxxxxx进来了" + cursor+"url:"+url);
                            String postUrl = url.replace("%c", String.valueOf(cursor));
                            OkHttpUtils.callBackForVideo(postUrl, OkHttpUtils.TYPE_TEXT, VideoViewPagerFragment.this);
                            Log.e("TAG", "xxxxxxxxxxxx进来了" + cursor + "url:" + url);
                            cursor+=20;

                        } else{
                            foot_View.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "已经是底部", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        foot_View.setVisibility(View.GONE);
                        //Toast.makeText(getContext(), "已经是底部", Toast.LENGTH_SHORT).show();
                    }

                    Log.e("TAG", url + "  " + count + "  :" + item.getColumn_id());


                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //计算是否到了底部
                isBottom = ((firstVisibleItem + visibleItemCount) == totalItemCount);
            }
        });

    }

    private void updateData() {
        isRefresh = true;
        Log.e("tag", "url="+url);
        OkHttpUtils.callBackUIDataFormatOne(url, OkHttpUtils.TYPE_TEXT, this);
    }

    @Override
    public void callBackUIString(String data) {
        if (data != null) {
            if (isRefresh) {
                //停止刷新
                swiperefresh.setRefreshing(false);
                adapter.getRefreshData();//刷新数据
                isRefresh = false;
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
            VideoBean videoBean = gson.fromJson(data, VideoBean.class);
            List<VideoItemBean> videoList = new ArrayList<>();
            List<VideoBean.DataEntity.ColumnsEntity> columns = videoBean.getData().getColumns();
            if (columns != null) {
                for (int i = 0; i < columns.size(); i++) {
                    VideoBean.DataEntity.ColumnsEntity columnsEntity = columns.get(i);

                    if (i == columns.size()-1){
                        column_id = columnsEntity.getColumn_id();
                        Log.e("TAGGGGG","进来了"+column_id);
                    }
                    List<VideoBean.DataEntity.ColumnsEntity.DataListEntity> data_list = columnsEntity.getData_list();
                    for (int j = 0; j < data_list.size(); j++) {
                        VideoItemBean videoItemBean = new VideoItemBean();
                        VideoBean.DataEntity.ColumnsEntity.DataListEntity dataListEntity = data_list.get(j);
                        long vid = dataListEntity.getVid();
                        long aid = dataListEntity.getAid();
                        String nickname = dataListEntity.getNickname();
                        String video_name = dataListEntity.getVideo_name();
                        int play_count = dataListEntity.getPlay_count();
                        String pic_url = dataListEntity.getHor_w8_pic();
                        videoItemBean.setVid(vid);
                        videoItemBean.setAid(aid);
                        videoItemBean.setNickName(nickname);
                        videoItemBean.setVideoName(video_name);
                        videoItemBean.setPlayCount(play_count);
                        videoItemBean.setPic_url(pic_url);
                        videoItemBean.setColumn_id(column_id);
                        videoList.add(videoItemBean);

                    }
                }
                list.addAll(videoList);
                int count = adapter.getCount();

                VideoItemBean item = (VideoItemBean) adapter.getItem(count-1);
                allColumn = item.getColumn_id();
                Log.e("COUNT2",count+"::::"+allColumn);
                adapter.notifyDataSetChanged();

            }




            for (VideoItemBean videoItemBean : videoList) {

                Log.e("temp", "callBackUIString: "+videoItemBean);
            }

        }


    }

    @Override
    public void callBackUIByte(byte[] datas) {
        if (datas != null) {
            //存储到访问记录表中,返回的是影响数
            if (videoBean != null) {
                long rows = db.addAllCloumnData(SQLiteDatabaseUtils.ACCESS_RECORD, videoBean.getAid() + "",
                        videoBean.getVideoName(), datas, videoBean.getNickName(), url, null, "2");
                if (rows > 0) {
                    Log.e("temp", "onItemClick: 添加访问记录成功");
                } else {
                    Log.e("temp", "onItemClick: 添加访问记录失败");
                }
            }
        }
    }

    @Override
    public void callBackVideo(String data) {
        Log.e("TAG",data);
        VideoOtherBean videoOtherBean = gson.fromJson(data, VideoOtherBean.class);
        List<VideoOtherBean.DataEntity.VideosEntity> videos = videoOtherBean.getData().getVideos();
        List<VideoItemBean> v_list = new ArrayList<>();
        for (int i = 0; i < videos.size(); i++) {
            VideoOtherBean.DataEntity.VideosEntity videosEntity = videos.get(i);
            VideoItemBean videoItemBean = new VideoItemBean();
            videoItemBean.setColumn_id(allColumn);
            Log.e("TAG", "column" + allColumn);
            videoItemBean.setVid(videosEntity.getVid());
            videoItemBean.setAid(Long.parseLong(videosEntity.getAid()));
            videoItemBean.setPic_url(videosEntity.getHor_w8_pic());
            videoItemBean.setPlayCount(videosEntity.getPlay_count());
            videoItemBean.setNickName(videosEntity.getNickname());
            videoItemBean.setVideoName(videosEntity.getVideo_name());
            v_list.add(videoItemBean);
        }

        list.addAll(v_list);
        adapter.notifyDataSetChanged();
    }
}
