package com.iesam.digitallibrary.features.digitalBook.domain;

public class DigitalBook {
    public final String isbn;
    public final String title;
    public final String author;
    public final String publisher;
    public final String genre;
    public final String synopsis;
    public final String pageCount;

    public DigitalBook(String isbn, String title, String author, String publisher, String genre, String synopsis, String pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.synopsis = synopsis;
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getPageCount() {
        return pageCount;
    }

}
