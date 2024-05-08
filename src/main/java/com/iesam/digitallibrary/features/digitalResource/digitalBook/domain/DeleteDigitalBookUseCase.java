package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

public class DeleteDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;

    public DeleteDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public void execute(String isbn){
        digitalBookRepository.delete(isbn);
    }
}
