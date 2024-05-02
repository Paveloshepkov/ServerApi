package ru.novosoft.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseEquipmentModel {

    @JsonProperty("equipment")
    private List<MetrEquipItemModel> equipItemModels;

    public ResponseEquipmentModel(List<MetrEquipItemModel> equipItemModels) {
        this.equipItemModels = equipItemModels;
    }

    public List<MetrEquipItemModel> getTasks() {
        return equipItemModels;
    }

    public void setTasks(List<MetrEquipItemModel> equipItemModels) {
        this.equipItemModels = equipItemModels;
    }
}
