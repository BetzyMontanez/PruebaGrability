package com.montanez.betzy.prueba_grability.model;

import java.io.Serializable;

public class Category implements Serializable {
    private Attributes attributes;

    public String getName() {
        return attributes.getLabel();
    }

    private class Attributes implements Serializable {
        private String label;

        public String getLabel() {
            return label;
        }
    }
}
