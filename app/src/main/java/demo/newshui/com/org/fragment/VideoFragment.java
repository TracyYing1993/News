package demo.newshui.com.org.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.newshui.com.org.activity.AccessRecordActivity;
import demo.newshui.com.org.activity.LoginActivity;
import demo.newshui.com.org.activity.NewsApplication;
import demo.newshui.com.org.activity.PublishActivity;
import demo.newshui.com.org.activity.R;
import demo.newshui.com.org.activity.VideoCollectActivity;
import demo.newshui.com.org.adapter.ViderViewpagerAdapter;
import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.urls.UrlsUtils;

/**
 * Created by Administrator on 2016/3/21.
 */
public class VideoFragment extends Fragment {

    private TabLayout tabLayout;
    private List<VideoViewPagerFragment> pagerFragment;
    private ViderViewpagerAdapter adapter;
    private String [] tabTitle;
    private String[]urlArr = {UrlsUtils.amuse,UrlsUtils.Gossip,UrlsUtils.Talkshow,
    UrlsUtils.Networkdrama,UrlsUtils.beauty,UrlsUtils.game,UrlsUtils.healthy,UrlsUtils.Tourism,
    UrlsUtils.videocar};
    private NavigationView navigationView;
    private LinearLayout head_layout;
    private TextView text_login;
    private ImageView image_more;
    private DrawerLayout drawerLyaout_video;
    private NewsFragment.OnChangedMode listener;
    private SharedPrfUtils mode;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener= (NewsFragment.OnChangedMode) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode = new SharedPrfUtils(getActivity(), "mode");
        pagerFragment = new ArrayList<>();
        tabTitle = getResources().getStringArray(R.array.video_tab_array);
        for (int i = 0; i < tabTitle.length; i++) {
            VideoViewPagerFragment videoViewPagerFragment = new VideoViewPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", urlArr[i]);
            videoViewPagerFragment.setArguments(bundle);
            pagerFragment.add(videoViewPagerFragment);
        }
        adapter = new ViderViewpagerAdapter(getChildFragmentManager(),pagerFragment,tabTitle);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment_layout, container, false);
        drawerLyaout_video = ((DrawerLayout) view.findViewById(R.id.drawerLyaout_video));
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.videoViewPager);
        image_more = ((ImageView) view.findViewById(R.id.video_more));
        tabLayout = ((TabLayout) view.findViewById(R.id.video_tabLayout));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        navigationView = ((NavigationView) view.findViewById(R.id.navigatinView_video));

        ViewGroup.LayoutParams layoutParams = navigationView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels * 3 / 4;
        navigationView.setLayoutParams(layoutParams);

        head_layout = (LinearLayout) LayoutInflater.from(getActivity()).
                inflate(R.layout.heae_navigation_layout, navigationView, false);
        text_login = ((TextView) head_layout.findViewById(R.id.text_navigation));

        //添加头部
        navigationView.addHeaderView(head_layout);

        intNavigationViewData();


        image_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLyaout_video.isDrawerOpen(navigationView)) {
                    drawerLyaout_video.closeDrawer(navigationView);
                } else {
                    drawerLyaout_video.openDrawer(navigationView);
                }
            }
        });

        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });


        return view;
    }

    private void intNavigationViewData() {
        Menu menu = navigationView.getMenu();
        MenuItem item1 = menu.findItem(R.id.menu_dark);
        if(item1!=null) {
            if (mode.getInt("modeNum") == 1) {
                item1.setTitle("白天模式");
                item1.setIcon(R.drawable.icon_sidebar_sun);
            } else if (mode.getInt("modeNum") == -1) {
                item1.setTitle("夜间模式");
                item1.setIcon(R.drawable.icon_sidebar_night);
            }
        }
        MenuItem item = menu.findItem(R.id.collect_Record);
        if(item!=null){
            item.setTitle("视频收藏记录");
            item.setIcon(R.drawable.icotab_videopress_v5);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.collect_Record://收藏记录
                        //视频
                        startActivity(new Intent(getActivity(), VideoCollectActivity.class));
                        break;
                    case R.id.history_Record://访问历史记录
                        startActivity(new Intent(getActivity(), AccessRecordActivity.class));
                        break;
                    case R.id.menu_version://版本信息
                        startActivity(new Intent(getActivity(), PublishActivity.class));
                        break;
                    case R.id.menu_dark:// 白夜间切换模式
                        if(!NewsApplication.isRefreshMode){
                            item.setTitle("白天模式");
                            item.setIcon(R.drawable.icon_sidebar_sun);
                            //夜间模式
                            mode.putInt("modeNum", 1);
                            NewsApplication.isRefreshMode=!NewsApplication.isRefreshMode;
                            listener.onChanged(true);
                        }else{
                            item.setTitle("夜间模式");
                            item.setIcon(R.drawable.icon_sidebar_night);
                            mode.putInt("modeNum", -1);
                            getActivity().setTheme(R.style.ThemeDay);
                            listener.onChanged(false);
                            NewsApplication.isRefreshMode=!NewsApplication.isRefreshMode;//白天模式
                        }
                        break;
                }
                drawerLyaout_video.closeDrawer(navigationView);
                return true;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        drawerLyaout_video.closeDrawer(navigationView);
    }
}
