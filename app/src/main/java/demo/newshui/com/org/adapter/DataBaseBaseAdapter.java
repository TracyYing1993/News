package demo.newshui.com.org.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import demo.newshui.com.org.activity.R;

/**
 * Created by Administrator on 2016/3/23.
 */
public class DataBaseBaseAdapter extends BaseAdapter {

    private List<Map<String, Object>> data=new ArrayList<>();
    private Context context;

    public DataBaseBaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderDB vh;
        if(convertView==null){
            vh=new ViewHolderDB();
            convertView= LayoutInflater.from(context).inflate(R.layout.table_item_listview_layout,null);
            vh.left_image_table= ((ImageView) convertView.findViewById(R.id.left_image_table));
            vh.title_text_table= ((TextView) convertView.findViewById(R.id.title_text_table));
            vh.create_time_table= ((TextView) convertView.findViewById(R.id.create_time_table));
            convertView.setTag(vh);
        }else{
            vh= (ViewHolderDB) convertView.getTag();
        }
        initToUi(vh,position);
        return convertView;
    }

    private void initToUi(ViewHolderDB vh, int position) {
        Map<String, Object> obj = this.data.get(position);
        vh.title_text_table.setText((String) obj.get("title"));
        vh.create_time_table.setText((String)obj.get("creat_time"));
        byte[] bitmap = (byte[]) obj.get("bitmap");
        if(bitmap!=null){
            Bitmap bm= BitmapFactory.decodeByteArray(bitmap,0,bitmap.length);
            vh.left_image_table.setImageBitmap(bm);
        }
    }

    class ViewHolderDB{
        ImageView left_image_table;
        TextView title_text_table,create_time_table;

    }

    public void addData(List<Map<String,Object>>data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
