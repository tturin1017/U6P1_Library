package com.example.project;

public class BookStore{
    private Book[] books;
    private User[] users=new User[20]; //max 20 users for the book store
    private int currentUserIndex=-1;

    public Library(int size){
        books = new Book[size];
    }

    public Library(Books[] books){
        this.books = books;
    }

    public void addUser(User user){
        if(currentUserIndex<users.length){
            currentUserIndex++;
            this.users[currentUserIndex]=user;
        }   
    }

    public void removeUser(User user){
        for(int i=0; i<users.length;i++){
            if(users[i].getId().equals(user.getId())){
                users[i]=null;
            }
        }
        this.consolidateUsers(); //you must consolidate if removing any item from array
    }

    public void consolidateUsers(){ // consolidate both user arrays .. you don't need to consolidate books array because it is dynamic
        User[] newUsers = new User[users.length];
        for(int i=0; i<users.length;i++){ 
            if(users[i]!=null){
                newUsers[i]=users[i];
            }
        }
        users = newUsers;
    }


    public void addBook(Book book){ //adds book to the end of array //book array is dynamic, not static
        //create a new list 
        Book[] newBooks = Book[books.length+1];
        for(int i=0; i<books.length; i++){
            newBooks[i] = books[i];
        }
        newBooks[books.length-1]=book;
        this.books = newBooks;
    }

    public void insertBook(Book book, int index){
        //if index is out of bounds, do not update the book array
        if(index<books.length+1){
            Book[] newBooks = Book[books.length+1];
            for(int i=0; i<books.length;i++){
                if(i==index){
                    newBooks[i]=book; //the book that is to be inserted
                }else if(i>index){
                    newBooks[i]=books[i-1]; //the book after inserted book
                }else{
                    newBooks[i]=books[i];//books before inserterd book
                }
            }
        }
    }

    public void removeBook(Book book){ // removes a copy of the book and removes null from array (consolidates)
        Books[] newBooks = new Books[books.length-1];
        int index = -1;
        for(int i=0; i<books.length;i++){
            if(book.getIsbn().equals(books[i].getIsbn())){ //find the isbn number
                books[i].setQuantity(books[i].getQuantity()-1);
                if(books[i].getQuantity()==0){//remove book 
                    books[i]=null;
                    index = i;
                }
            }
        }
        
        for(int i=0;i<newBooks.length;i++){
            if(i<index){ //before the null item
                newBooks[i]=books[i];
            }else if(index>=i){
                newBooks[i]=books[i+1];
            }
        }
        

        
    }

    public static void main(String[] args) { //your main program goes here
        IdGenerate g = new IdGenerate();
        g.generateID();
        User u1 = new User("John",g.getCurrentId());
        g.generateID();
        User u2 = new User("Jane",g.getCurrentId());
        g.generateID();
        User u3 = new User("Mary",g.getCurrentId());
        System.out.println(u1.userInfo());



    }



}