package demo.newshui.com.org.fragment;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.newshui.com.org.activity.LoginActivity;
import demo.newshui.com.org.activity.R;

/**
 * Created by Administrator on 2016/3/21.
 */
public class MeFragment extends Fragment {
    private TextView login;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment_layout, container, false);
        login = (TextView) view.findViewById(R.id.login); //登录
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
