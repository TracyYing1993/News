package demo.newshui.com.org.utils.urls;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import demo.newshui.com.org.activity.R;

/**
 * Created by Administrator on 2016/3/22.
 *
 * 用于配置及显示图片加载后的图片工具类
 */
public class ImageLoaderUtils {

    public static DisplayImageOptions getDisplayImageOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//是否进行内存缓存
                .cacheOnDisk(true)//是否进行磁盘缓存
                .build();//构造生成DisplayImageOptions
        return options;
    }
}
