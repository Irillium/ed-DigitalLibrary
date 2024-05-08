package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

import java.util.ArrayList;

public class GetDigitalBooksUseCase {
    private DigitalBookRepository digitalBookRepository;

    public GetDigitalBooksUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public ArrayList<DigitalBook> execute(){
        return  digitalBookRepository.obtains();
    }
}
