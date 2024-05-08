package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

public class GetDigitalBookUseCase {
    DigitalBookRepository digitalBookRepository;

    public GetDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public DigitalBook execute(String isbn){
        return  digitalBookRepository.obtain(isbn);
    }
}
