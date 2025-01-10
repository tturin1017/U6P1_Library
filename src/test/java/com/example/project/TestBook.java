package com.example.project;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestBook {
    @Test
    public void testBookConstructor(){
        Book b = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        assertEquals("The Great Gatsby",b.getTitle(), "Title doesn't match");
        assertEquals("Scott Fitzgerald",b.getAuthor(), "Author doesn't match");
        assertEquals(1925, b.getYearPublished(), "Year published doesn't match");
        assertEquals("979-8351145013", b.getIsbn(), "ISBN doesn't match");
        assertEquals(3, b.getQuantity(), "quantity doesn't match");
    }

    @Test
    public void testSetters(){
        Book b = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        b.setTitle("Untitled");
        b.setAuthor("John Doe");
        b.setIsbn("0000");
        b.setQuantity(1);
        b.setYearPublished(1900);
        assertEquals("Untitled",b.getTitle(), "Title doesn't match");
        assertEquals("John Doe",b.getAuthor(), "Author doesn't match");
        assertEquals(1900, b.getYearPublished(), "Year published doesn't match");
        assertEquals("0000", b.getIsbn(), "ISBN doesn't match");
        assertEquals(1, b.getQuantity(), "quantity doesn't match");
    }

    @Test
    public void testBookInfo(){
        Book b = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        String expected = "Title: The Great Gatsby, Author: Scott Fitzgerald, Year: 1925, ISBN: 979-8351145013, Quantity: 3";
        assertEquals(expected, b.bookInfo() ,"bookInfo() doesn't match expected string");
    }

}
