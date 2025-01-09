package com.example.project;


public class User{
    private String name;
    private String  Id;
    private Books[] books = new Books[5]; //can only take out 5 books at a time
    
    public User(String name, String Id){
        this.name=name;
        this.Id = Id;
        
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Books[] getBooks() {
        return this.books;
    }

    public void setBooks(Books[] books) {
        this.books = books;
    }

    public String userInfo(){
        String x = "Name: "+name+", ID: "+Id+", Books: ";
        for(Book b: books){
            x+=b.bookInfo()+ "\n";
        }
        return x;
    }



}