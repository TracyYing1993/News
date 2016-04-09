package demo.newshui.com.org.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import demo.newshui.com.org.fragment.VideoViewPagerFragment;

/**
 * Created by Administrator on 2016/3/22.
 */
public class ViderViewpagerAdapter extends FragmentPagerAdapter {

    private List<VideoViewPagerFragment> list;
    private String[] tabArr;

    public ViderViewpagerAdapter(FragmentManager fm,List<VideoViewPagerFragment> list,String[] tabArr) {
        super(fm);
        this.list = list;
        this.tabArr = tabArr;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabArr[position];
    }
}
