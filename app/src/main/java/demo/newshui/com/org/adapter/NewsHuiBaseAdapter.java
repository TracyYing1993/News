package demo.newshui.com.org.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import demo.newshui.com.org.activity.R;
import demo.newshui.com.org.bean.NewsBean;
import demo.newshui.com.org.utils.netutils.OkHttpUtils;
import demo.newshui.com.org.utils.urls.ImageLoaderUtils;
import demo.newshui.com.org.widget.AdvertisementImageLoopView;

/**
 * Created by Administrator on 2016/3/22.
 * 新闻汇的基本适配器
 */
public class NewsHuiBaseAdapter extends BaseAdapter {
    private static final String TAG = NewsHuiBaseAdapter.class.getSimpleName();
    Map<Integer, View> orderview = new HashMap<Integer, View>();
    List<NewsBean.ArticlesEntity> list_articles=new ArrayList<NewsBean.ArticlesEntity>();
    Context context;

    private String url;

    public NewsHuiBaseAdapter(Context context, String url) {
        this.context = context;
        this.url=url;
    }

    @Override
    public int getCount() {
        return this.list_articles.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list_articles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /***
     * templateType  判断格式类型
     * 如果等于 1 布局格式为   左边小图 右边文字
     * 如果等于 2 布局格式为   3附图
     * 如果等于 3 布局格式为   开头一张大图
     * 如果等于 7 布局格式为   直播
     * 如果等于 28 布局格式为  开头可以翻页的大图
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获得第一项的articles
        NewsBean.ArticlesEntity articles = list_articles.get(position);
        ViewHolderParent holderParent = null;
        if (orderview.get(position) == null) {
            int templateType = articles.getTemplateType();
            Log.e(TAG, "getView:templateType= " + templateType);
            if(templateType==28){
                //广告轮播
                //convertView = LayoutInflater.from(context).inflate(R.layout.loop_image_layout, parent, false);
                convertView=new AdvertisementImageLoopView(context,url);
                holderParent = new ViewHolderLoopImageView(convertView);
                convertView.setTag(holderParent);

                orderview.put(position, convertView);
            }else if (templateType == 2) {
                Log.e(TAG, "getView:templateType= " + templateType);
                convertView = LayoutInflater.from(context).inflate(R.layout.news_item_type2_layout, parent, false);
                holderParent = new ViewHolder2(convertView);
                convertView.setTag(holderParent);
                orderview.put(position, convertView);
            }else if (templateType == 12) {
                Log.e(TAG, "getView:templateType= " + templateType);
                convertView = LayoutInflater.from(context).inflate(R.layout.news_item_advert_layout, parent, false);
                holderParent = new ViewHolder12(convertView);
                convertView.setTag(holderParent);
                orderview.put(position, convertView);
            } else if (templateType == 1) {
                Log.e(TAG, "getView:templateType= " + templateType);
                convertView = LayoutInflater.from(context).inflate(R.layout.news_item_type1_layout, parent, false);
                holderParent = new ViewHolder1(convertView);
                convertView.setTag(holderParent);
                orderview.put(position, convertView);
            } else if (templateType == 7) {
                Log.e(TAG, "getView:templateType= " + templateType);
                convertView = LayoutInflater.from(context).inflate(R.layout.news_item_type7_layout, parent, false);
                holderParent = new ViewHolder7(convertView);
                convertView.setTag(holderParent);
                orderview.put(position, convertView);
            } else if (templateType == 8) {
                Log.e(TAG, "getView:templateType= " + templateType);
                convertView = LayoutInflater.from(context).inflate(R.layout.news_item_type_advert_layout, parent, false);
                holderParent = new ViewHolderAD(convertView);
                convertView.setTag(holderParent);
                orderview.put(position, convertView);
            }else if (templateType == 14) {
                Log.e(TAG, "getView:templateType= " + templateType);
                convertView = LayoutInflater.from(context).inflate(R.layout.news_item_type_advert_layout, parent, false);
                holderParent = new ViewHolderAD(convertView);
                convertView.setTag(holderParent);
                orderview.put(position, convertView);
            }else if(templateType == 13){
                Log.e(TAG, "getView:templateType= " + templateType);
                convertView = LayoutInflater.from(context).inflate(R.layout.news_item_type_advert_layout, parent, false);
                holderParent = new ViewHolderAD(convertView);
                convertView.setTag(holderParent);
                orderview.put(position, convertView);
            }

        } else {
            convertView=orderview.get(position);
            holderParent = (ViewHolderParent) convertView.getTag();
        }
        intoViewHolderUI(articles, holderParent);

        return convertView;
    }

    private void intoViewHolderUI(NewsBean.ArticlesEntity articles, ViewHolderParent holderParent) {
        int templateType = articles.getTemplateType();
        DisplayImageOptions options = ImageLoaderUtils.getDisplayImageOptions();
         if (templateType == 2) {
            initViewHolderUiTwo(options, articles, (ViewHolder2) holderParent);
        }else if (templateType == 12) {
            initViewHolderUiTwelve(articles, (ViewHolder12) holderParent, options);
        }else if (templateType == 1) {
            initViewHolderUiOne(articles, (ViewHolder1) holderParent, options);
        }else if(templateType == 7){
            initViewHolderUiSeven(articles, (ViewHolder7) holderParent);
        }else if(templateType==8||templateType==14){
            ViewHolderAD myHolderAd =(ViewHolderAD) holderParent;
            myHolderAd.imageview_anim.setBackgroundResource(R.drawable.animation);
            AnimationDrawable anim = (AnimationDrawable) myHolderAd.imageview_anim.getBackground();
            anim.start();
            myHolderAd.commentNum12.setText(articles.getCommentNum()+"");
            String imageview_extension = articles.getIconNight();
            ImageLoader.getInstance().displayImage(imageview_extension, myHolderAd.imageview_extension, options);
        }

    }

    private void initViewHolderUiTwelve(NewsBean.ArticlesEntity articles, ViewHolder12 holderParent, DisplayImageOptions options) {
        ViewHolder12 myHolder12 = holderParent;
        NewsBean.ArticlesEntity.DataEntity data = articles.getData();
        if(data!=null) {
            NewsBean.ArticlesEntity.DataEntity.ResourceEntity res = data.getResource();
            ImageView image_advTitle = myHolder12.image_advTitle;
            TextView text_advTitle = myHolder12.text_advTitle;
            if (res != null) {
                String file = res.getFile();
                if (!TextUtils.isEmpty(file)) {
                    Log.e(TAG, "downloadImg: file=" + file);
                    ImageLoader.getInstance().displayImage(file, image_advTitle, options);
                }
            }
            NewsBean.ArticlesEntity.DataEntity.Resource1Entity resource1 = data.getResource1();
            if(resource1!=null){
                text_advTitle.setText(resource1.getText());
            }
        }
    }

    private void initViewHolderUiSeven(NewsBean.ArticlesEntity articles, ViewHolder7 holderParent) {
        final ViewHolder7 myHolder7 = holderParent;
        myHolder7.title_format7.setText(articles.getTitle());
        myHolder7.left_hostTeam_format7.setText(articles.getHostTeam());
        myHolder7.right_visitorTeam_format7.setText(articles.getVisitorTeam());
        myHolder7.left_hostTeam_fenshu.setText(articles.getHostTotal()+"");
        myHolder7.right_visitorTeam_fenshu.setText(articles.getVisitorTotal() + "");
        myHolder7.bottom_left_text_format7.setText("有"+articles.getCommentNum()+"人参与");
        myHolder7.bottom_right_text_format7.setText(articles.getIconText());
        String linear_bgpic=  articles.getBgPic();
        OkHttpUtils.callBackUIDataFormatOne(linear_bgpic, OkHttpUtils.TYPE_BYTE, new OkHttpUtils.callBack() {
            @Override
            public void callBackUIString(String data) {
            }

            @Override
            public void callBackUIByte(byte[] datas) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(datas, 0, datas.length);
                myHolder7.imageview_bgpic.setImageBitmap(bitmap);
            }

            @Override
            public void callBackVideo(String data) {

            }
        });
    }

    private void initViewHolderUiOne(NewsBean.ArticlesEntity articles, ViewHolder1 holderParent, DisplayImageOptions options) {
        try {

            ViewHolder1 myHolder = holderParent;
            myHolder.title_text.setText(articles.getTitle());
            myHolder.commentNum.setText(articles.getCommentNum() + "");
            List<String> pics = articles.getPics();
            if (pics.isEmpty()) {
                myHolder.left_image.setImageResource(R.mipmap.ic_launcher);
            } else {
                String imgurl = articles.getPics().get(0);
                ImageLoader.getInstance().displayImage(imgurl, myHolder.left_image, options);
            }

                String iconText = articles.getIconText();
            if(!TextUtils.isEmpty(iconText)) {
                myHolder.text_source.setVisibility(View.VISIBLE);
                myHolder.text_source.setText(iconText);
            }else{
                myHolder.text_source.setVisibility(View.GONE);
            }
            String time = articles.getTime();
            myHolder.time_text.setText(OkHttpUtils.getFormatTime(time));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //更新UI中的数据
    private void initViewHolderUiTwo(DisplayImageOptions options, NewsBean.ArticlesEntity articles, ViewHolder2 holderParent) {
        ViewHolder2 myHolder2 = holderParent;
        myHolder2.title_text_format2.setText(articles.getTitle());
        String imageview_one = articles.getPics().get(0);
        String imageview_two = articles.getPics().get(1);
        String imageview_three = articles.getPics().get(2);


        ImageLoader.getInstance().displayImage(imageview_one, myHolder2.imageview_format_one, options);
        ImageLoader.getInstance().displayImage(imageview_two, myHolder2.imageview_format_two, options);
        ImageLoader.getInstance().displayImage(imageview_three, myHolder2.imageview_format_three, options);
        myHolder2.commentNum_format2.setText(articles.getCommentNum()+"");
        String time = articles.getTime();
        Date date = new Date(Long.parseLong(time));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_format2 = format.format(date);
        myHolder2.time_format2.setText(time_format2);
    }

    class ViewHolderLoopImageView extends ViewHolderParent{

        public ViewHolderLoopImageView(View view) {
            super(view);

        }
    }

    class ViewHolder1 extends ViewHolderParent {
        @Bind(R.id.left_image)
        ImageView left_image;
        @Bind(R.id.commentNum)
        TextView commentNum;
        @Bind(R.id.title_text)
        TextView title_text;
        @Bind(R.id.time_text)
        TextView time_text;
        @Bind(R.id.text_source)
        TextView text_source;

        public ViewHolder1(View view) {
            super(view);
        }
    }

    class ViewHolderAD extends ViewHolderParent {
        @Bind(R.id.imageview_anim)
        ImageView imageview_anim;
        @Bind(R.id.commentNum12)
        TextView commentNum12;
        @Bind(R.id.imageview_extension)
        ImageView imageview_extension;

        public ViewHolderAD(View view) {
            super(view);
        }
    }

    class ViewHolder12 extends ViewHolderParent{

        @Bind(R.id.text_advTitle)
        TextView text_advTitle;
        @Bind(R.id.image_advTitle)
        ImageView image_advTitle;

        public ViewHolder12(View view) {
            super(view);
        }
    }

    class ViewHolder2 extends ViewHolderParent {
        @Bind(R.id.title_text_format2)
        TextView title_text_format2;
        @Bind(R.id.imageview_format_one)
        ImageView imageview_format_one;
        @Bind(R.id.imageview_format_two)
        ImageView imageview_format_two;
        @Bind(R.id.imageview_format_three)
        ImageView imageview_format_three;
        @Bind(R.id.commentNum_format2)
        TextView commentNum_format2;
        @Bind(R.id.time_format2)
        TextView time_format2;

        public ViewHolder2(View view) {
            super(view);
        }
    }


    class ViewHolder7 extends ViewHolderParent {
        @Bind(R.id.title_format7)
        TextView title_format7;
        @Bind(R.id.left_hostTeam_format7)
        TextView left_hostTeam_format7;
        @Bind(R.id.left_hostTeam_fenshu)
        TextView left_hostTeam_fenshu;
        @Bind(R.id.right_visitorTeam_fenshu)
        TextView right_visitorTeam_fenshu;
        @Bind(R.id.right_visitorTeam_format7)
        TextView right_visitorTeam_format7;
        @Bind(R.id.bottom_left_text_format7)
        TextView bottom_left_text_format7;
        @Bind(R.id.bottom_right_text_format7)
        TextView bottom_right_text_format7;
        @Bind(R.id.imageview_bgpic)
        ImageView imageview_bgpic;

        public ViewHolder7(View view) {
            super(view);
        }
    }

    public void setListData(List<NewsBean.ArticlesEntity> list){
        this.list_articles.addAll(list);
        notifyDataSetChanged();
    }

    public void getRefreshData(){
        this.list_articles.clear();
        notifyDataSetChanged();
    }


}
