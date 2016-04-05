package com.montanez.betzy.prueba_grability.services;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

public class AppDataClient {
    private static final String RUTA_APP_DATA = "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void ObtenerDatos(TextHttpResponseHandler responseHandler) {
        client.get(RUTA_APP_DATA, responseHandler);

        //save data on local path



    }
}
