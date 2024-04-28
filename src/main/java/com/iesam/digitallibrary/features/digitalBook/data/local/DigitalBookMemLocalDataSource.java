package com.iesam.digitallibrary.features.digitalBook.data.local;


import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBook;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DigitalBookMemLocalDataSource implements DigitalBookData {

    private static DigitalBookMemLocalDataSource digitalBookMemLocalDataSource=null;
    public static DigitalBookMemLocalDataSource newInstance(){
        if(digitalBookMemLocalDataSource ==null){
            digitalBookMemLocalDataSource= new DigitalBookMemLocalDataSource();
        }
        return digitalBookMemLocalDataSource;
    }
    private Map<String, DigitalBook> dataStore = new TreeMap<>();

    public void save(DigitalBook model) {
        dataStore.put(model.getIdbn(), model);
    }

    public void saveList(List<DigitalBook> models) {
        for (DigitalBook demo : models) {
            save(demo);
        }
    }

    public DigitalBook findById(String id) {
        return dataStore.get(id);
    }

    public List<DigitalBook> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String modelId) {
        dataStore.remove(modelId);
    }
}