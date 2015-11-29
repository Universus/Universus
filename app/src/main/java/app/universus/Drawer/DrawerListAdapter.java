package app.universus.Drawer;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import app.universus.Drawer.DrawerItem;
import app.universus.Helpers.ImagenCircular;
import app.universus.com.universus.R;

public class DrawerListAdapter extends ArrayAdapter<DrawerItem> {


    public DrawerListAdapter(Context context, List<DrawerItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_list_item, null);
        }


        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView name = (TextView) convertView.findViewById(R.id.name);

        DrawerItem item = getItem(position);
        ImagenCircular imagen = new ImagenCircular(item.getIcono());
        icon.setImageDrawable(imagen);
        name.setText(item.getName());

        return convertView;
    }
}
