package demo.newshui.com.org.fragment;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.LinearLayout.LayoutParams;

import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import demo.newshui.com.org.activity.NewsWebActivity;
import demo.newshui.com.org.activity.R;
import demo.newshui.com.org.adapter.NewsHuiBaseAdapter;
import demo.newshui.com.org.bean.NewsBean;
import demo.newshui.com.org.utils.db.SQLiteDatabaseUtils;
import demo.newshui.com.org.utils.netutils.OkHttpUtils;
import demo.newshui.com.org.widget.AdvertisementImageLoopView;


public class NewsFragment_item_child extends Fragment implements OkHttpUtils.callBack {

    private static final String TAG = NewsFragment_item_child.class.getSimpleName();
    int pager = 1;
    String url;
    String path;
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listview;
    Gson gson = new Gson();
    private NewsHuiBaseAdapter adapter;

    private View foot_View;
    private boolean isBottom, isRefresh;
    private NewsBean newsBean;
    private View emptyview;

    private SQLiteDatabaseUtils db;
    private NewsBean.ArticlesEntity articles;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //实例化数据库工具类
        db = new SQLiteDatabaseUtils(getActivity());

        url = getArguments().getString("path");
        // 下载Json数据并解析,开启一个线程进行下载,第一屏数据
        if (!TextUtils.isEmpty(url)) {
            adapter = new NewsHuiBaseAdapter(getActivity(), url);
            Log.e("temp", "intoViewHolderUI: url== " + url);
            OkHttpUtils.callBackUIDataFormatOne(OkHttpUtils.getReplaceFormat(url, "%p", pager), OkHttpUtils.TYPE_TEXT, this);
            // loopView = new AdvertisementImageLoopView(getActivity(),url);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_fragment_item_child_layout, container, false);
        initView(view);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                articles = (NewsBean.ArticlesEntity) adapter.getItem(position);
                int newsId = articles.getNewsId();
                //获得图片路径并下载
                List<String> pics = articles.getPics();
                if(pics!=null) {
                    String imgurl = pics.get(0);
                    if (!TextUtils.isEmpty(imgurl)) {
                        Intent intent = new Intent(getActivity(), NewsWebActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("webUrl", newsId);
                        bundle.putString("title", articles.getTitle());
                        bundle.putString("imageUrl", imgurl);
                        bundle.putString("create_time", OkHttpUtils.getFormatTime(articles.getTime()));
                        intent.putExtras(bundle);
                        startActivity(intent);

                        Log.e(TAG, "onItemClick: 已在里面");
                        OkHttpUtils.callBackUIDataFormatOne(imgurl, OkHttpUtils.TYPE_BYTE, NewsFragment_item_child.this);
                    }
                }

            }
        });
        return view;
    }

    public void initView(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        listview = (ListView) view.findViewById(R.id.listview);
        //填充一个上拉刷新的footView
        foot_View = LayoutInflater.from(getActivity()).inflate(R.layout.footer_view_layout, listview, false);


        //先将footView隐藏，在上拉时在显示出来
        foot_View.setVisibility(View.GONE);

        emptyview = view.findViewById(R.id.emptyview);

        // listview.addHeaderView(loopView);

        listview.setEmptyView(emptyview); //设置加载动画

        listview.setAdapter(adapter);

        listview.addFooterView(foot_View);

        initswipeRefreshData();
        //为ListView添加监听事件
        setScrollListener();

    }

    private void setScrollListener() {
        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //判断是否停止滚动和到了底部
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && isBottom) {
                    //显示footView
                    foot_View.setVisibility(View.VISIBLE);
                    OkHttpUtils.callBackUIDataFormatOne(OkHttpUtils.getReplaceFormat(url, "%p", ++pager), OkHttpUtils.TYPE_TEXT, NewsFragment_item_child.this);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //计算是否到了底部
                isBottom = ((firstVisibleItem + visibleItemCount) == totalItemCount);
            }
        });

    }

    private void initswipeRefreshData() {
        //刷新时旋转的颜色
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        //添加监听事件
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //做更新操作
                updataData();
            }
        });

    }

    private void updataData() {
        isRefresh = true;
        OkHttpUtils.callBackUIDataFormatOne(OkHttpUtils.getReplaceFormat(url, "%p", 1), OkHttpUtils.TYPE_TEXT, this);
    }

    @Override
    public void callBackUIString(String data) {
        if (data != null) {// 判断数据是否为空
            // 不为空，就用Gson进行Json解析
            //隐藏FootView
            foot_View.setVisibility(View.GONE);
            if (isRefresh) {
                //停止刷新
                swipeRefreshLayout.setRefreshing(false);
                adapter.getRefreshData();//刷新数据
                isRefresh = false;
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
            //用Gson解析JSon数据
            newsBean = gson.fromJson(data, NewsBean.class);
            adapter.setListData(newsBean.getArticles());
        }

    }

    @Override
    public void callBackUIByte(byte[] datas) {
        if (datas != null) {
            //存储到访问记录表中,返回的是影响数
            if(articles!=null) {
                long rows = db.addAllCloumnData(SQLiteDatabaseUtils.ACCESS_RECORD, articles.getNewsId() + "",
                        articles.getTitle(), datas, OkHttpUtils.getFormatTime(articles.getTime()),"11",null,"1");
                if (rows > 0) {
                    Log.e(TAG, "onItemClick: 添加访问记录成功");
                } else {
                    Log.e(TAG, "onItemClick: 添加访问记录失败");
                }
            }
        }
    }

    @Override
    public void callBackVideo(String data) {

    }
}
