package com.montanez.betzy.prueba_grability.model;

import com.google.gson.annotations.SerializedName;

public class DataWrapper {
    @SerializedName("feed")
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }
}
