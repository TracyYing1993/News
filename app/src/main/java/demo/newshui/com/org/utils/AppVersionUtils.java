package demo.newshui.com.org.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class AppVersionUtils {
	
	private Context context;

	public AppVersionUtils(Context context) {
		this.context = context;
	}
	
	/**
	 * ��ȡ�汾��
	 * 
	 * @return ��ǰӦ�õİ汾��
	 */
	public String getApplicationVersion(){
		PackageManager manager=context.getPackageManager();
		PackageInfo packageInfo=null;
		try {
			packageInfo=manager.getPackageInfo(context.getPackageName(), 0);//��õ�ǰӦ�õİ汾
			
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return packageInfo.versionName;//�汾��
	}
	

}
