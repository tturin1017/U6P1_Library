package com.example.project;

public class Library{
    private Book[] books;

    public Library(int size){
        books = new Book[size];
    }

    public Library(Books[] books){
        this.books = books;
    }

    public void addBook(Book book){ //adds book to the end of array
        //create a new list 
        Book[] newBooks = Book[books.length+1];
        for(int i=0; i<books.length; i++){
            newBooks[i] = books[i];
        }
        newBooks[books.length-1]=book;
    }

    public void insertBook(Book book, int index){
        //if index is out of bounds, do not update the book array
        Book[] newBooks = Book[books.length+1];
        for(int i=0; i<books.length;i++){
            
        }
        
    }

}