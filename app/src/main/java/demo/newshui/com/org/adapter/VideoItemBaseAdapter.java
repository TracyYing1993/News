package demo.newshui.com.org.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import demo.newshui.com.org.activity.R;
import demo.newshui.com.org.bean.VideoBean;
import demo.newshui.com.org.bean.VideoItemBean;
import demo.newshui.com.org.utils.urls.ImageLoaderUtils;

/**
 * Created by Administrator on 2016/3/22.
 */
public class VideoItemBaseAdapter extends BaseAdapter {

    private List<VideoItemBean> list;

    public VideoItemBaseAdapter(List<VideoItemBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if (convertView == null){
            myHolder = new MyHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_layout,null,false);
            myHolder.imageView = (ImageView) convertView.findViewById(R.id.video_img);
            myHolder.res = (TextView) convertView.findViewById(R.id.video_res);
            myHolder.play_count = (TextView) convertView.findViewById(R.id.video_play_count);
            myHolder.video_title = (TextView) convertView.findViewById(R.id.video_title);

            convertView.setTag(myHolder);


        }else{
            myHolder = (MyHolder) convertView.getTag();
        }
        VideoItemBean videoItemBean = list.get(position);
        myHolder.video_title.setText(videoItemBean.getVideoName());
        myHolder.res.setText(videoItemBean.getNickName());
        myHolder.play_count.setText(videoItemBean.getPlayCount()+"");
        //剩图片
        DisplayImageOptions options = ImageLoaderUtils.getDisplayImageOptions();
        ImageLoader.getInstance().displayImage(videoItemBean.getPic_url(),myHolder.imageView,options);


        return convertView;
    }

    class MyHolder {
        private ImageView imageView;
        private TextView video_title;
        private TextView res;
        private TextView play_count;
    }

    public void getRefreshData(){
        this.list.clear();
        notifyDataSetChanged();
    }
}
