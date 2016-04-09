package demo.newshui.com.org.adapter;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/22.
 *
 * 用于对控件绑定的超类
 */
public class ViewHolderParent {
    View view;
    public ViewHolderParent(View view){
        this.view =view;
        ButterKnife.bind(this, view);
    }
}
