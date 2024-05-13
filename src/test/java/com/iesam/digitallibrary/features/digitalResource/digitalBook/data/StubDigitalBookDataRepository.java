package com.iesam.digitallibrary.features.digitalResource.digitalBook.data;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local.DigitalBookData;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBookRepository;

import java.util.ArrayList;
import java.util.List;

public class StubDigitalBookDataRepository implements DigitalBookRepository {
    DigitalBookData digitalBookData;

    public StubDigitalBookDataRepository(DigitalBookData digitalBookData) {
        this.digitalBookData = digitalBookData;
    }

    @Override
    public void save(DigitalBook digitalBook) {
        digitalBookData.save(digitalBook);
    }

    @Override
    public void delete(String isbn) {
        digitalBookData.delete(isbn);
    }

    @Override
    public void modify(String isbn, DigitalBook book) {
        if(digitalBookData.findById(isbn)!=null){
            digitalBookData.delete(isbn);
            digitalBookData.save(book);
        }
    }

    @Override
    public ArrayList<DigitalBook> obtains() {
        List<DigitalBook> books= digitalBookData.findAll();
        if(!books.isEmpty()) {
            return new ArrayList<>(books);
        }
        else{
            return null;
        }
    }

    @Override
    public DigitalBook obtain(String isbn) {
        return digitalBookData.findById(isbn);
    }
}
