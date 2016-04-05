package com.montanez.betzy.prueba_grability.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.montanez.betzy.prueba_grability.R;
import com.montanez.betzy.prueba_grability.adapters.AppAdapter;
import com.montanez.betzy.prueba_grability.model.Entry;

import java.util.ArrayList;

public class AppActivity extends AppCompatActivity {
    public static final String APP_CATEGORY_KEY = "appCategory";
    public static final String APP_ENTRIES_KEY = "appEntries";

    AppAdapter mAdapter;
    ArrayList<Entry> mDataApps;
    String mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        // Datos
        mCategory = getIntent().getStringExtra(AppActivity.APP_CATEGORY_KEY);
        mDataApps = (ArrayList<Entry>) getIntent().getSerializableExtra(AppActivity.APP_ENTRIES_KEY);

        // Controles
        TextView txtCategory = (TextView) findViewById(R.id.txt_category);
        txtCategory.setText(mCategory);

        GridView grdApps = (GridView) findViewById(R.id.grd_apps);
        mAdapter = new AppAdapter(this, mDataApps);
        grdApps.setAdapter(mAdapter);

        grdApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent appDetailIntent = new Intent(AppActivity.this, AppDetailActivity.class);
                appDetailIntent.putExtra(AppDetailActivity.APP_ENTRY_KEY, mDataApps.get(position));

                startActivity(appDetailIntent);
            }
        });
    }
}
