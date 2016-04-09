package demo.newshui.com.org.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import demo.newshui.com.org.activity.R;

/**
 * Created by Administrator on 2016/3/22.
 * ListView的emptyview的 杯子 动画
 */
public class LoadingCupAnimView extends RelativeLayout {
    private  Context context;
    private ImageView img_cup;

    public LoadingCupAnimView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public LoadingCupAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.anim_cup_loading_layout,this,true);
        img_cup = ((ImageView) view.findViewById(R.id.img_load_cup));
        img_cup.setBackgroundResource(R.drawable.anim_cup_loadind);
        AnimationDrawable anim = (AnimationDrawable) img_cup.getBackground();
        anim.start();
    }
}
