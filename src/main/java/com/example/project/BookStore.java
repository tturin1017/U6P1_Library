package com.example.project;

public class BookStore{
    private Book[] books;
    private User[] users=new User[20]; //max 20 users for the book store
    private int currentUserIndex=-1;

    public BookStore(){}

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
        if(books==null){ //first book to be added to empty array
            Book[] newBooks = new Book[1];
            newBooks[0] = book;
            this.books = newBooks;
        }else{ //if the books array is not empty
            Book[] newBooks = new Book[books.length+1];
            for(int i=0; i<books.length; i++){
                newBooks[i] = books[i];
            }
            newBooks[newBooks.length-1]=book; //insert new book at the last item in the array
            this.books = newBooks;
        }
    }

    public void insertBook(Book book, int index){
        //if index is out of bounds, do not update the book array
        if(index<books.length+1){
            Book[] newBooks = new Book[books.length+1];
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
        Book[] newBooks = new Book[books.length-1];
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

    public String bookStoreInfo(){
        String x = "";
        for(int i =0 ; i<books.length;i++){
            x+="Book #"+(i+1)+": ";
            if(books[i]!=null){
                x+=books[i].bookInfo()+"\n";   
            }else{
                x+="empty";
            }
            
        }
        return x;
    }
    public static void main(String[] args) { //your main program goes here

        IdGenerate.generateID();
        User u1 = new User("John",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u2 = new User("Jane",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u3 = new User("Mary",IdGenerate.getCurrentId());

        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);

        BookStore store = new BookStore(); //create a new bookstore with 6 empty books
        store.addBook(b1);store.addBook(b2);store.addBook(b3);store.addBook(b4);

        
        //System.out.println(store.bookStoreInfo());

                  
        
    

    }



}