package demo.newshui.com.org.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import demo.newshui.com.org.activity.R;

public class VideoBaseAdapterDB extends BaseAdapter {

    private List<Map<String, Object>> list=new ArrayList<>();
    private Context context;

    public VideoBaseAdapterDB(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myholder;
        if(convertView==null){
            myholder = new MyHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.table_item_listview_layout,null);

            myholder.left_image_table = (ImageView) convertView.findViewById(R.id.left_image_table);
            myholder.create_time_table = (TextView) convertView.findViewById(R.id.create_time_table);
            myholder.title_text_table = (TextView) convertView.findViewById(R.id.title_text_table);

            convertView.setTag(myholder);
        }else{
            myholder = (MyHolder) convertView.getTag();

        }

        myholder.title_text_table.setText((String) list.get(position).get("title"));
        byte[] data = (byte[]) list.get(position).get("bitmap");
        if(data!=null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            myholder.left_image_table.setImageBitmap(bitmap);
        }
        myholder.create_time_table.setText((String)list.get(position).get("nickname"));

        return convertView;
    }
    public void addData(List<Map<String,Object>>data){
        this.list.addAll(data);
        notifyDataSetChanged();
    }
    class MyHolder{
        ImageView left_image_table;
        TextView title_text_table;
        TextView create_time_table;

    }

}