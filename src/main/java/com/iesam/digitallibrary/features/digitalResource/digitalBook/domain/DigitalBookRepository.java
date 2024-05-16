package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

import java.util.ArrayList;

public interface DigitalBookRepository {
    void save(DigitalBook digitalBook);
    void delete(String isbn);
    void modify(String isbn, DigitalBook book);
    ArrayList<DigitalBook> obtains();
    DigitalBook obtain(String isbn);

}
