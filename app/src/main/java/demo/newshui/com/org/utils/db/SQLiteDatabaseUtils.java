package demo.newshui.com.org.utils.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/21.
 *
 * 是一个用于调用增删改的工具类
 */
public class SQLiteDatabaseUtils {
    //新闻收藏表
    private NewsRecordDBHelper newsRecordDBHelper;
    //视频收藏表
    private VideoRecordDBHelper videoRecordDBHelper;
    //访问记录表
    private AccessRecordDBHelper accessRecordDBHelper;

    public static final String ACCESS_RECORD = "access_record";

    public static final String NEWS_RECORD = "news_record";

    public static final String VIDEO_RECORD="video_record";


    /**
     * 初始化数据
     * @param context  传进来的上下文
     */
    public SQLiteDatabaseUtils(Context context) {
       newsRecordDBHelper=new NewsRecordDBHelper(context);
        videoRecordDBHelper=new VideoRecordDBHelper(context);
        accessRecordDBHelper=new AccessRecordDBHelper(context);
    }
    /**
     * 将数据加到表中 返回的是一个影响数据，要判断是否大于0
     */
    public long addAllCloumnData(String tableName,String id,String title,byte[] arrBitmap,
                                 String creat_time,String url,String nickname,String flag) {
        SQLiteDatabase db = null;

        if (ACCESS_RECORD.equals(tableName)) {
            //表示就算内存不在够用，也能读
            db = accessRecordDBHelper.getReadableDatabase();
        } else if (NEWS_RECORD.equals(tableName)) {
            db = newsRecordDBHelper.getReadableDatabase();
        }else if (VIDEO_RECORD.equals(tableName)) {
            db = videoRecordDBHelper.getReadableDatabase();
        }

        long rowd = -1;
        if (db != null) {
            ContentValues values = new ContentValues();
            if (VIDEO_RECORD.equals(tableName)){
                values.put("_id", id);
                values.put("title",title);
                values.put("bitmap",arrBitmap);
                values.put("url",url);
                values.put("nickname",nickname);
            }else if(ACCESS_RECORD.equals(tableName)){
                values.put("_id", id);
                values.put("title",title);
                values.put("bitmap",arrBitmap);
                values.put("url",url);
                values.put("flag",flag);
                values.put("creat_time",creat_time);
            }else{
                values.put("_id", id);
                values.put("title",title);
                values.put("bitmap",arrBitmap);
                values.put("creat_time",creat_time);
            }
            rowd = db.insert(tableName, null, values);
        }
        db.close();
        return rowd;
    }


    /**
     * 该方法用于执行增删改的sql语句
     *
     * @param sql
     *            sql语句
     * @param bindArgs
     *            sql语句中要绑定(占位符)的参数值
     * @return boolean
     */
    public boolean executeSql(String tableName, String sql, Object[] bindArgs) {
        SQLiteDatabase db = null;
        if (ACCESS_RECORD.equals(tableName)) {
            //表示就算内存不在够用，也能读
            db = accessRecordDBHelper.getReadableDatabase();
        } else if (NEWS_RECORD.equals(tableName)) {
            db = newsRecordDBHelper.getReadableDatabase();
        }else if (VIDEO_RECORD.equals(tableName)) {
            db = videoRecordDBHelper.getReadableDatabase();
        }
        try {
            if (db != null) {
                if (bindArgs == null) {
                    db.execSQL(sql);
                } else {
                    db.execSQL(sql, bindArgs);
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    // 查询读取表中的数据返回Cursor
    public Cursor findSelectCursor(String sql, String tableName,
                                   String[] selectionArgs) {
        SQLiteDatabase db = null;
        if (ACCESS_RECORD.equals(tableName)) {
            //表示就算内存不在够用，也能读
            db = accessRecordDBHelper.getReadableDatabase();
        } else if (NEWS_RECORD.equals(tableName)) {
            db = newsRecordDBHelper.getReadableDatabase();
        }else if (VIDEO_RECORD.equals(tableName)) {
            db = videoRecordDBHelper.getReadableDatabase();
        }
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(sql, selectionArgs);
        }
        return cursor;
    }

    // 读取表中的数据返回List<Map<String,String>>
    public List<Map<String, Object>> findAllCloumnData(String tableName) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        // dbHelper.getReadableDatabase() : 如果空间不足，不能写，只能读
        // dbHelper.getWritableDatabase(); 如果空间不足,既不能写，也不能读(报错)

        SQLiteDatabase db = null;
        if (ACCESS_RECORD.equals(tableName)) {
            //表示就算内存不在够用，也能读
            db = accessRecordDBHelper.getReadableDatabase();
        } else if (NEWS_RECORD.equals(tableName)) {
            db = newsRecordDBHelper.getReadableDatabase();
        }else if (VIDEO_RECORD.equals(tableName)) {
            db = videoRecordDBHelper.getReadableDatabase();
        }
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery("select * from " + tableName, null);
            while (cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    if(i==2){
                        map.put(cursor.getColumnName(i), cursor.getBlob(i));
                    }else {
                        map.put(cursor.getColumnName(i), cursor.getString(i));
                    }
                }
                list.add(map);
            }
        }
        cursor.close();

        db.close();

        return list;
    }
}
