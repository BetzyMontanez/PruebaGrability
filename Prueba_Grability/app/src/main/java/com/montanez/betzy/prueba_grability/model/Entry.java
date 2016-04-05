package com.montanez.betzy.prueba_grability.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Entry implements Serializable {
    @SerializedName("im:name")
    private Im name;

    @SerializedName("im:image")
    private List<Im> images;

    private Im summary;

    private Category category;

    public Entry() {
        images = new ArrayList<Im>();
    }

    public String getName() {
        return name.getLabel();
    }

    public ArrayList<String> getImages() {
        ArrayList<String> rutaImagenes = new ArrayList<>();
        for (Im img : images) {
            rutaImagenes.add(img.getLabel());
        }

        return rutaImagenes;
    }

    public String getSummary() {
        return summary.getLabel();
    }

    public Category getCategory() {
        return category;
    }

    private class Im implements Serializable {
        private String label;

        public String getLabel() {
            return label;
        }
    }
}
