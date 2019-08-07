package com.zzzfyrw.common.weather.entity;

import java.util.List;

public class ChartData {

    private String[] categories;
    private List<Serie> modelSerie;

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public List<Serie> getModelSerie() {
        return modelSerie;
    }

    public void setModelSerie(List<Serie> modelSerie) {
        this.modelSerie = modelSerie;
    }
}
