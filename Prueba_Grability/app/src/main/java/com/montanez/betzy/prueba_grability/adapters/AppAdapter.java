package com.montanez.betzy.prueba_grability.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.montanez.betzy.prueba_grability.R;
import com.montanez.betzy.prueba_grability.model.Entry;
import com.montanez.betzy.prueba_grability.tasks.DownloadImageTask;

import java.util.ArrayList;

public class AppAdapter extends BaseAdapter {
    private ArrayList<Entry> mApps;
    private Context mContext;

    public AppAdapter(Context c, ArrayList<Entry> apps) {
        mContext = c;
        mApps = apps;
    }

    @Override
    public int getCount() {
        return mApps.size();
    }

    @Override
    public Object getItem(int position) {
        return mApps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Entry app = mApps.get(position);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v;

        if (convertView == null) {
            v = inflater.inflate(R.layout.adapter_app, null);
        } else {
            v = convertView;
        }

        ImageView imgAppIcon = (ImageView) v.findViewById(R.id.img_app_icon);
        ArrayList<String> imagenes =  app.getImages();
        if (imagenes.size() > 0)
            new DownloadImageTask(imgAppIcon).execute(imagenes.get(0));

        TextView txtNombre = (TextView) v.findViewById(R.id.txt_app_name);
        txtNombre.setText(app.getName());

        return v;
    }
}
