package demo.newshui.com.org.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import demo.newshui.com.org.activity.R;

/**
 * Created by Administrator on 2016/3/23.
 */
public class VideoLoadingCircle  extends RelativeLayout {
    private Context context;
    public VideoLoadingCircle(Context context) {
        super(context);
        this.context = context;
        initView();
    }
    public VideoLoadingCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }
    private void initView() {
        LayoutInflater infalter = LayoutInflater.from(context);
        View view = infalter.inflate(R.layout.video_loading_circle_layout, this, true);
        ImageView circle_icon = (ImageView) view.findViewById(R.id.circle_load);
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.anim_video_rotate);
        circle_icon.setAnimation(anim);
    }
}

