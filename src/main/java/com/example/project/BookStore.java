package com.example.project;

public class BookStore{
    private Book[] books;
    private User[] users=new User[10]; //max 20 users for the book store
    private int currentUserIndex=-1;

    public BookStore(){}

    public User[] getUsers(){ //required
        return users;
    }

    public void setUsers(User[] users){ //required
        this.users = users;
    }

    public Book[] getBooks(){ //required
        return books;
    }

    public void addUser(User user){
        if(currentUserIndex<users.length){
            currentUserIndex++;
            this.users[currentUserIndex]=user;
        }   
    }

    public void removeUser(User user){ 
        for(int i=0; i<users.length;i++){
            if(users[i]!=null){
                if(users[i].getId().equals(user.getId())){
                    users[i]=null;  
                }
            }
        }
        this.consolidateUsers(); //you must consolidate if removing any item from array
    }

    public void consolidateUsers(){ // consolidate user arrays .. you don't need to consolidate books array because it is dynamic
        User[] newUsers = new User[users.length];
        int counter = 0;

        for(User user: users){
            if(user!=null){
                newUsers[counter]=user;
                counter++;
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
            for(int i=0; i<index;i++){
                newBooks[i]=books[i];
            }
            newBooks[index]=book;
            for(int i=index;i<newBooks.length-1;i++){
                newBooks[i+1]=books[i];
            }
            books=newBooks;
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
        if (index!=-1){
            for(int i=0;i<index;i++){ //consiladting books
                newBooks[i]=books[i];
            }
            for(int i=index;i<books.length-1;i++){
                newBooks[i]=books[i+1];
            }
            books=newBooks;
        }
        

    }

    public String bookStoreBookInfo(){
        String x = "";
        for(int i =0 ; i<books.length;i++){
            x+="Book #"+(i+1)+": ";
            if(books[i]!=null){
                x+=books[i].bookInfo()+"\n";   
            }else{
                x+="book empty\n";
            }
            
        }
        return x;
    }

    public String bookStoreUserInfo(){
        String x="";
        for(int i=0;i<users.length;i++){
            if(users[i]!=null){
                x+=users[i].userInfo();
            }else{
                x+="user empty\n";
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
        IdGenerate.generateID();
        User u4 = new User("Alex",IdGenerate.getCurrentId());

        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Insert me","Author",1900, "1234", 1);
        BookStore store = new BookStore(); //create a new bookstore with 6 empty books
        store.addBook(b1);store.addBook(b2);store.addBook(b3);store.addBook(b4);store.addBook(b5);
        store.addUser(u1);store.addUser(u2);store.addUser(u3);store.addUser(u4);
        store.removeUser(u4);
        store.removeBook(b1); store.removeBook(b1); store.removeBook(b1); 
        // store.insertBook(insertedBook, 4);
        // //System.out.println(store.bookStoreUserInfo());
        System.out.println(store.bookStoreBookInfo());
        // store.removeBook(insertedBook);
        // System.out.println(store.bookStoreBookInfo());

                
        
    

    }



}