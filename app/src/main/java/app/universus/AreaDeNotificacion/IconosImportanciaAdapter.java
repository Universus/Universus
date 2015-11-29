package app.universus.AreaDeNotificacion;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.universus.Drawer.Elemento;
import app.universus.com.universus.R;

public class IconosImportanciaAdapter extends BaseExpandableListAdapter {

    private String[] nombres = {"Importante", "Recordatorio", "No se que poner"};
    private List<Elemento> padres;
    private HashMap<String, List<Elemento>> opciones;
    Context context;

    public IconosImportanciaAdapter(Context context, List<Elemento> padres,
            HashMap<String, List<Elemento>> hijos){
        this.context = context;
        this.padres = padres;
        this.opciones = hijos;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.opciones.get(this.padres.get(groupPosition).getDescipcion())
                .get(childPosititon);
    }


    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Elemento hijo = (Elemento) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.elemento_view, null);
            }

            TextView descripcion = (TextView) convertView
                    .findViewById(R.id.elemento__descripcionr);

            descripcion.setText(hijo.getDescipcion());

            ImageView imagen = (ImageView) convertView
                    .findViewById(R.id.elemento__imagen);

            imagen.setImageResource(hijo.getPath());
            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return this.opciones.get(padres.get(groupPosition).getDescipcion())
                    .size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this.padres.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this.padres.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            Elemento padre = (Elemento) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.elemento_view, null);
            }

            TextView descriocion = (TextView) convertView
                    .findViewById(R.id.elemento__descripcionr);
            descriocion .setTypeface(null, Typeface.BOLD);
            descriocion .setText(padre.getDescipcion());

            ImageView imagen = (ImageView) convertView
                    .findViewById(R.id.elemento__imagen);
            imagen.setImageResource(padre.getPath());

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
