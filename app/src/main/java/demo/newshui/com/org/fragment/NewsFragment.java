package demo.newshui.com.org.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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
import demo.newshui.com.org.activity.NewsCollectRecordActivity;
import demo.newshui.com.org.activity.PublishActivity;
import demo.newshui.com.org.activity.R;
import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.urls.UrlsUtils;
import demo.newshui.com.org.widget.AdvertisementImageLoopView;

/**
 * Created by Administrator on 2016/3/21.
 */
public class NewsFragment extends Fragment{
    String[] news_tab_array;
    String[] news_urls={UrlsUtils.INDEX_PATH,UrlsUtils.recreation,UrlsUtils.lift,UrlsUtils.technology,UrlsUtils.military,UrlsUtils.culture,UrlsUtils.sports,UrlsUtils.car,UrlsUtils.smalltopline,UrlsUtils.society,UrlsUtils.funny,UrlsUtils.education};
    int[] colorarray={R.color.color0,R.color.color10,R.color.color20,R.color.color30,R.color.color40,R.color.color50,R.color.color60,R.color.color70,R.color.color80,R.color.color90,R.color.color100,R.color.colorPrimary};
    TabLayout tablayout;
    ViewPager newsViewPager;

    List<Fragment> list_fragment = new ArrayList<>();
    private DrawerLayout drawerLyaout;
    private NavigationView navigationView;
    private ImageView image_more;
    private OnChangedMode listener;

    public interface OnChangedMode{
        void onChanged(boolean isChanged);
    }


    //NavigationView中的HeaderView
    private LinearLayout head_layout;
    private TextView text_login;


    private SharedPrfUtils mode;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener= (OnChangedMode) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode = new SharedPrfUtils(getActivity(), "mode");
        news_tab_array =getResources().getStringArray(R.array.news_tab_array);
        for(int i=0;i<news_tab_array.length;i++) {
            NewsFragment_item_child newsFragment_item_child = new NewsFragment_item_child();
            Bundle bundle = new Bundle();
            bundle.putString("path", news_urls[i]);
            newsFragment_item_child.setArguments(bundle);
            list_fragment.add(newsFragment_item_child);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment_layout, container, false);
        initView(view);
        newsViewPager.setAdapter(new FragmentAdapter(getChildFragmentManager()));
        tablayout.setupWithViewPager(newsViewPager);


        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                newsViewPager.setCurrentItem(tab.getPosition());

                tablayout.setSelectedTabIndicatorColor(getResources().getColor(colorarray[tab.getPosition()]));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        return view;
    }

    public void  initView(View view){

        image_more = ((ImageView) view.findViewById(R.id.image_more));
        newsViewPager= (ViewPager) view.findViewById(R.id.newsViewPager);
        tablayout= (TabLayout) view.findViewById(R.id.tabLayout);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        drawerLyaout = ((DrawerLayout) view.findViewById(R.id.drawerLyaout));
        navigationView = ((NavigationView) view.findViewById(R.id.navigatinView));


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
                if (drawerLyaout.isDrawerOpen(navigationView)) {
                    drawerLyaout.closeDrawer(navigationView);
                } else {
                    drawerLyaout.openDrawer(navigationView);
                }
            }
        });

        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

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
            item.setTitle("新闻收藏记录");
            item.setIcon(R.drawable.night_ic_videooffline_null);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.collect_Record://新闻收藏记录
                        startActivity(new Intent(getActivity(), NewsCollectRecordActivity.class));
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
                drawerLyaout.closeDrawer(navigationView);
                return true;
            }
        });
    }


    class FragmentAdapter extends FragmentPagerAdapter{

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list_fragment.get(position);
        }
        @Override
        public int getCount() {
            return list_fragment.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return news_tab_array[position];
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        drawerLyaout.closeDrawer(navigationView);
    }


}
