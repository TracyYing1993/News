package demo.newshui.com.org.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import demo.newshui.com.org.utils.AppVersionUtils;
import demo.newshui.com.org.utils.SharedPrfUtils;

/**
 * Created by Administrator on 2016/3/23.
 * 版本信息
 */
public class PublishActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPrfUtils sharedPtf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPtf = new SharedPrfUtils(getApplicationContext(),"mode");
        if(sharedPtf.getInt("modeNum")==-1) {
            setTheme(R.style.ThemeDay);
        }else if(sharedPtf.getInt("modeNum")==1){
            setTheme(R.style.ThemeNight);
        }
        setContentView(R.layout.activity_publish);

        TextView back = (TextView) findViewById(R.id.publish_back);
        back.setOnClickListener(this);
        TextView home = (TextView) findViewById(R.id.publish_home);
        home.setOnClickListener(this);

        TextView text_version=(TextView) this.findViewById(R.id.text_version);
		AppVersionUtils versionUtils=new AppVersionUtils(getApplicationContext());
		String version=versionUtils.getApplicationVersion();//获得版本信息
		text_version.setText("Android v"+version);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.publish_back:
                finish();
                break;
            case R.id.publish_home:
                Intent intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
