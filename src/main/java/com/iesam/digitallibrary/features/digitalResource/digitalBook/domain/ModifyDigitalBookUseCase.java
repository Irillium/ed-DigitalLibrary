package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

public class ModifyDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;

    public ModifyDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public void execute(String isbn,DigitalBook book){
        digitalBookRepository.modify(isbn,book);
    }
}
