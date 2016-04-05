package com.montanez.betzy.prueba_grability.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.montanez.betzy.prueba_grability.R;
import com.montanez.betzy.prueba_grability.model.Entry;

public class AppDetailActivity extends AppCompatActivity {
    public static final String APP_ENTRY_KEY = "appEntry";

    private Entry mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);

        // Datos
        mApp = (Entry) getIntent().getSerializableExtra(AppDetailActivity.APP_ENTRY_KEY);

        // Controles
        TextView txtApp = (TextView) findViewById(R.id.txt_app);
        txtApp.setText(mApp.getName());

        TextView txtAppSummary = (TextView) findViewById(R.id.txt_app_summary);
        txtAppSummary.setText(mApp.getSummary());
    }
}
