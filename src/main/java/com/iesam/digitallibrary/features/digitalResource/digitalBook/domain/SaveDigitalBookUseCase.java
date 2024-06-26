package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

public class SaveDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;

    public SaveDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }
    public void execute(DigitalBook digitalBook){
        digitalBookRepository.save(digitalBook);
    }
}
