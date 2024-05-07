package com.iesam.digitallibrary.features.digitalBook.data;

import com.iesam.digitallibrary.features.digitalBook.data.local.DigitalBookData;
import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBookRepository;

import java.util.ArrayList;

public class DigitalBookDataRepository implements DigitalBookRepository {
    private DigitalBookData digitalBookData;

    public DigitalBookDataRepository(DigitalBookData digitalBookData) {
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
        else{
            System.out.println("El libro que quieres modificar no existe");
        }
    }
    @Override
    public ArrayList<DigitalBook> obtains() {
        return (ArrayList<DigitalBook>) digitalBookData.findAll();
    }

    @Override
    public DigitalBook obtain(String isbn) {
        return digitalBookData.findById(isbn);
    }
}
