package com.montanez.betzy.prueba_grability.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.TextHttpResponseHandler;
import com.montanez.betzy.prueba_grability.R;
import com.montanez.betzy.prueba_grability.adapters.CategoryAdapter;
import com.montanez.betzy.prueba_grability.model.DataWrapper;
import com.montanez.betzy.prueba_grability.model.Entry;
import com.montanez.betzy.prueba_grability.services.AppDataClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import cz.msebera.android.httpclient.Header;

public class AppCategoryActivity extends AppCompatActivity {
    CategoryAdapter mAdapter;
    DataWrapper mData;
    LinkedHashMap<String, ArrayList<Entry>> mDataByCategory;
    ArrayList<String> mCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_category);

        // Controles
        GridView grdCategorias = (GridView) findViewById(R.id.grd_categorias);
        mAdapter = new CategoryAdapter(this);
        grdCategorias.setAdapter(mAdapter);

        grdCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent appIntent = new Intent(AppCategoryActivity.this, AppActivity.class);
                appIntent.putExtra(AppActivity.APP_CATEGORY_KEY, mCategories.get(position));
                appIntent.putExtra(AppActivity.APP_ENTRIES_KEY, mDataByCategory.get(mCategories.get(position)));

                AppCategoryActivity.this.startActivity(appIntent);
            }
        });

        traerDatos();
    }

    private void traerDatos() {
        AppDataClient.ObtenerDatos(new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                Gson gson = new GsonBuilder().create();
                mData = gson.fromJson(response, DataWrapper.class);

                // Cargar categorias
                mCategories = obtenerCategorias();
                mAdapter.setCategories(mCategories);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String response, Throwable throwable) {
                mData = null;
            }
        });
    }

    private ArrayList<String> obtenerCategorias() {
        mDataByCategory = new LinkedHashMap<>();

        for(Entry entry : mData.getFeed().getEntries()) {
            if (!mDataByCategory.containsKey(entry.getCategory().getName())) {
                ArrayList<Entry> list = new ArrayList<>();
                list.add(entry);

                mDataByCategory.put(entry.getCategory().getName(), list);
            } else {
                mDataByCategory.get(entry.getCategory().getName()).add(entry);
            }
        }

        ArrayList<String> categorias = new ArrayList<>(mDataByCategory.keySet());
        Collections.sort(categorias);

        return categorias;
    }
}
