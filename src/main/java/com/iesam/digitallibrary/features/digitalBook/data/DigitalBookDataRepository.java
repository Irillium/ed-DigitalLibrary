package com.iesam.digitallibrary.features.digitalBook.data;

import com.iesam.digitallibrary.features.digitalBook.data.local.DigitalBookData;
import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBookRepository;

public class DigitalBookDataRepository implements DigitalBookRepository {
    private DigitalBookData digitalBookData;

    public DigitalBookDataRepository(DigitalBookData digitalBookData) {
        this.digitalBookData = digitalBookData;
    }

    @Override
    public void save(DigitalBook digitalBook) {
        digitalBookData.save(digitalBook);
    }
}
