package demo.newshui.com.org.utils;

/**
 * Created by Administrator on 2016/3/12.
 * 用于将时间转换为秒数的工具类
 */
public class TimeFormatSecondUtils {

    public static String secToSecndTime(int secondNum) {
        String timeStr = null;
        int minute = 0;
        int second = 0;
        if (secondNum <= 0)
            return "00:00";
        else {
            minute = secondNum / 60;
            if (minute < 60) {
                second = secondNum % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    //格式化时间
    private  static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
}
