package com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;

import java.util.List;

public interface DigitalBookData {
    public void save(DigitalBook model);
    public void saveList(List<DigitalBook> models);
    public DigitalBook findById(String id);
    public List<DigitalBook> findAll();
    public void delete(String modelId);
}
