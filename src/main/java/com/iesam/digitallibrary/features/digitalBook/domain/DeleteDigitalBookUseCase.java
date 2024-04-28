package com.iesam.digitallibrary.features.digitalBook.domain;

public class DeleteDigitalBookUseCase {
    DigitalBookRepository digitalBookRepository;

    public DeleteDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public void execute(String isbn){
        digitalBookRepository.delete(isbn);
    }
}
