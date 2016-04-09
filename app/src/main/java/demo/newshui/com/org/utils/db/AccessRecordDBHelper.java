package demo.newshui.com.org.utils.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/3/22.
 * <p/>
 * 用于创建访问记录表
 */
public class AccessRecordDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DBNAME = "access_record.db";

    public AccessRecordDBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建数据库中的访问记录
        db.execSQL("create table access_record "
                + " (_id varchar(100) primary key  not null,"
                + " title varchar(100) not null," +
                " bitmap BLOB not null," +
                " url varchar(100) ," +
                " flag varchar(10) not null," +
                "creat_time varchar(50) not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("drop table if exists access_record");
            onCreate(db);
        }
    }
}
