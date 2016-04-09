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

import demo.newshui.com.org.adapter.DataBaseBaseAdapter;
import demo.newshui.com.org.utils.SharedPrfUtils;
import demo.newshui.com.org.utils.db.SQLiteDatabaseUtils;

/**
 * Created by Administrator on 2016/3/23.
 */
public class AccessRecordActivity  extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView_table;
    private TextView text_empty_table, text_record_count,table_title;
    private DataBaseBaseAdapter adapter;
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

        table_title.setText("访问记录表");

        // 查出所有的记录数
        Cursor cursor1 = db.findSelectCursor(
                "select count(*) from access_record",
                SQLiteDatabaseUtils.ACCESS_RECORD, null);
        cursor1.moveToFirst();
        int count = cursor1.getInt(0);// 就在第一列

        text_record_count.setText("共有:" + count + " 条访问记录");
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
                builder.setMessage("确认要清空所有访问记录吗？");
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean result = db.executeSql(
                                SQLiteDatabaseUtils.ACCESS_RECORD,
                                "delete from access_record", null);
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
                                SQLiteDatabaseUtils.ACCESS_RECORD,
                                "delete from access_record where _id=?",
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
        List<Map<String, Object>>  data = db.findAllCloumnData(SQLiteDatabaseUtils.ACCESS_RECORD);
        adapter=new DataBaseBaseAdapter(this);
        adapter.addData(data);
        listView_table.setAdapter(adapter);

        // 查出所有的记录数
        Cursor cursor2 = db.findSelectCursor(
                "select count(*) from access_record",
                SQLiteDatabaseUtils.ACCESS_RECORD, null);
        cursor2.moveToFirst();
        int count = cursor2.getInt(0);// 就在第一列
        text_record_count.setText("共有:" + count + " 条记录");
        cursor2.close();
    }


    private void initData() {
        //获得用集合封装的数据 
        List<Map<String, Object>>  data = db.findAllCloumnData(SQLiteDatabaseUtils.ACCESS_RECORD);
        adapter=new DataBaseBaseAdapter(this);
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
        Map<String, String> map = (Map<String, String>) adapter
                .getItem(position);
        String url=map.get("url");
        String flag=map.get("flag");
        Intent intent = new Intent();
        if(flag.equals("1")) {
            String _id = map.get("_id");
            intent.setClass(this, NewsWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("webUrl", Integer.parseInt(_id));
            Log.e("temp", "onItemClick: " + _id);
            intent.putExtras(bundle);
        }else if(flag.equals("2")){
         if(!TextUtils.isEmpty(url)){
             intent.setClass(this, VideoWebActivity.class);
             Bundle bundle = new Bundle();
             bundle.putString("url", url);
             intent.putExtras(bundle);
         }
        }
        startActivity(intent);
    }
}
