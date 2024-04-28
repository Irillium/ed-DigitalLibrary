package com.iesam.digitallibrary.features.digitalBook.domain;

import java.util.ArrayList;

public class GetDigitalBooksUseCase {
    DigitalBookRepository digitalBookRepository;

    public GetDigitalBooksUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public ArrayList<DigitalBook> execute(){
        return  digitalBookRepository.obtains();
    }
}
