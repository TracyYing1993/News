package demo.newshui.com.org.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import demo.newshui.com.org.adapter.VideoBaseAdapterDB;
import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.db.SQLiteDatabaseUtils;


public class VideoCollectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView_table;
    private TextView text_empty_table, text_record_count,table_title;
    private VideoBaseAdapterDB adapter;
    private SQLiteDatabaseUtils db;
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
        setContentView(R.layout.table_layout);
        db = new SQLiteDatabaseUtils(getApplicationContext());
        listView_table = (ListView) this.findViewById(R.id.listView_table);

        text_empty_table = (TextView) this.findViewById(R.id.text_empty_table);

        table_title= ((TextView) findViewById(R.id.table_title));

        text_record_count = (TextView) this.findViewById(R.id.text_record_count);

        listView_table.setEmptyView(text_empty_table);

        table_title.setText("视频收藏记录表");

        // 查出所有的记录数
        Cursor cursor1 = db.findSelectCursor(
                "select count(*) from video_record",
                SQLiteDatabaseUtils.VIDEO_RECORD, null);
        cursor1.moveToFirst();
        int count = cursor1.getInt(0);// 就在第一列

        text_record_count.setText("共有:" + count + " 条记录");
        cursor1.close();

        initData();

        registerForContextMenu(listView_table);

        listView_table.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.clear_all_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clearAll:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.collect);
                builder.setTitle("清空记录：");
                builder.setMessage("确认要清空所有收藏记录吗？");
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean result = db.executeSql(
                                SQLiteDatabaseUtils.VIDEO_RECORD,
                                "delete from video_record", null);
                        if (result) {
                            Toast.makeText(getApplicationContext(), "清空成功",
                                    Toast.LENGTH_SHORT).show();
                            fillDataBaseRefresh();
                        } else {
                            Toast.makeText(getApplicationContext(), "清空失败",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Map<String, String> map = (Map<String, String>) adapter
                .getItem(info.position);
        menu.setHeaderTitle(map.get("title"));
        // 填充菜单
        getMenuInflater().inflate(R.menu.delete_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        Map<String, String> map = (Map<String, String>) adapter
                .getItem(info.position);
        final String id = map.get("_id");
        switch (item.getItemId()) {
            case R.id.delete:// 删除
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.collect);
                builder.setTitle("删除记录：");
                builder.setMessage("确认要删除该记录吗？");
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("temp", id + ".......");
                        boolean result = db.executeSql(
                                SQLiteDatabaseUtils.VIDEO_RECORD,
                                "delete from video_record where _id=?",
                                new String[] { id });
                        if (result) {
                            Toast.makeText(getApplicationContext(), "删除成功",
                                    Toast.LENGTH_SHORT).show();
                            fillDataBaseRefresh();

                        } else {
                            Toast.makeText(getApplicationContext(), "删除失败",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.show();

                break;

        }
        return super.onContextItemSelected(item);
    }
    /**
     * 该方法是用于更新listView中的数据和将数据库中的数据用SimpleCursorAdapter进行将数据绑定到listView中
     *
     */
    public void fillDataBaseRefresh() {
        //获得用集合封装的数据
        List<Map<String, Object>> data = db.findAllCloumnData(SQLiteDatabaseUtils.NEWS_RECORD);
        adapter=new VideoBaseAdapterDB(this);
        adapter.addData(data);
        listView_table.setAdapter(adapter);

        // 查出所有的记录数
        Cursor cursor2 = db.findSelectCursor(
                "select count(*) from video_record",
                SQLiteDatabaseUtils.VIDEO_RECORD, null);
        cursor2.moveToFirst();
        int count = cursor2.getInt(0);// 就在第一列
        text_record_count.setText("共有:" + count + " 条访问记录");
        cursor2.close();
    }
    private void initData() {
        //获得用集合封装的数据
        List<Map<String, Object>>  data = db.findAllCloumnData(SQLiteDatabaseUtils.VIDEO_RECORD);
        adapter=new VideoBaseAdapterDB(this);
        adapter.addData(data);
        listView_table.setAdapter(adapter);
    }

    public void clickButton(View view){
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_rightHome:
                Intent intent2 = new Intent(this, HomeActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String, Object> map = (Map<String, Object>) adapter
                .getItem(position);
        Intent intent = new Intent(this, VideoWebActivity.class);
        Bundle bundle = new Bundle();
        String url= (String) map.get("url");
        String aid= (String) map.get("_id");
        String videoname= (String) map.get("title");
        String nickname= (String) map.get("nickname");
        byte[] datas = (byte[]) map.get("bitmap");
        if(!TextUtils.isEmpty(url)) {
            bundle.putString("url", url);
            bundle.putString("_id", aid);
            bundle.putString("title", videoname);
            bundle.putByteArray("bitmap", datas);
            bundle.putString("nickname", nickname);
            intent.putExtras(bundle);
            startActivity(intent);

            //存储到记录表中
            long rows = db.addAllCloumnData(SQLiteDatabaseUtils.ACCESS_RECORD, aid + "",
                    videoname, datas, nickname, url, null,"2");
            if (rows > 0) {
                Log.e("temp", "onItemClick: 添加访问记录成功");
            } else {
                Log.e("temp", "onItemClick: 添加访问记录失败");
            }
        }
    }
}
