package com.iesam.digitallibrary.features.digitalBook.domain;

public class ModifyDigitalBookUseCase {
    DigitalBookRepository digitalBookRepository;

    public ModifyDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public void execute(String isbn,DigitalBook book){
        digitalBookRepository.modify(isbn,book);
    }
}
