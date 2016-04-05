package com.montanez.betzy.prueba_grability.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    @SerializedName("entry")
    private List<Entry> entries;

    public Feed() {
        entries = new ArrayList<Entry>();
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
