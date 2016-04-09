package demo.newshui.com.org.utils.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/3/22.
 * 用于创建新闻收藏表
 */
public class NewsRecordDBHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DBNAME = "news_record.db";

    public NewsRecordDBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建数据库中的新闻收藏表
        db.execSQL("create table news_record "
                + " (_id varchar(100) primary key  not null,"
                + " title varchar(100) not null," +
                " bitmap BLOB not null," +
                "creat_time varchar(50) not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("drop table if exists news_record");
            onCreate(db);
        }
    }
}
