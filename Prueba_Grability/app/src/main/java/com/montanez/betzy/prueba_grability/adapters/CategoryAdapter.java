package com.montanez.betzy.prueba_grability.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.montanez.betzy.prueba_grability.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mCategories;

    public CategoryAdapter(Context c) {
        mContext = c;
        mCategories = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v;

        if (convertView == null) {
            v = inflater.inflate(R.layout.adapter_category, null);
        } else {
            v = convertView;
        }

        TextView txtTitulo = (TextView) v.findViewById(R.id.txt_category_title);
        TextView txtNombre = (TextView) v.findViewById(R.id.txt_category_name);

        txtTitulo.setText(mCategories.get(position).substring(0, 1));
        txtNombre.setText(mCategories.get(position));

        return v;
    }

    public void setCategories(ArrayList<String> categories) {
        this.mCategories = categories;
    }
}
