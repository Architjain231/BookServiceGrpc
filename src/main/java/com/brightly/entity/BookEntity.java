package com.brightly.entity;

public class BookEntity {
    int bookId;
    String bookName;
    String authorName;
    int pages;

    public BookEntity() {
    }

    public BookEntity(int bookId, String bookName, String authorName, int pages) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.pages = pages;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
