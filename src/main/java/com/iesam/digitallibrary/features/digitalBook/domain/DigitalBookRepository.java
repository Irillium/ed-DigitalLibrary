package com.iesam.digitallibrary.features.digitalBook.domain;


import java.util.ArrayList;


public interface DigitalBookRepository {
    void save(DigitalBook digitalBook);
    void delete(String isbn);
    void modify(String isbn, DigitalBook book);

    ArrayList<DigitalBook> obtains();

}
