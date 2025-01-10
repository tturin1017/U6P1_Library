package com.example.project;


public class User{
    private String name;
    private String  Id;
    private Book[] books = new Book[5]; //can only take out 5 books at a time
    
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

    public Book[] getBooks() {
        return this.books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public String bookListInfo(){
        String x = "";
        for(Book b: books){
            if(b!=null){
                x+=b.bookInfo()+ "\n";
            }else{
                x+="null\n";
            }
        }
        return x;
    }

    public String userInfo(){ //return Name: John\nID: 101\nBooks:\n[print out book info]
        String x = "Name: "+name+"\nId: "+Id+"\nBooks: \n"+bookListInfo();
        
        return x;
    }
}