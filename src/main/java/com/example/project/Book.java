package com.example.project;

public class Book{
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //constructor
    public Book(String title, String author, int yearPublished, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    //getters and setters 
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String bookInfo(){
        return "Title: "+ title + ", Author: "+ author + ", Year: " + yearPublished + ", ISBN: "+isbn+", Quantity: " + quantity;
    }

}