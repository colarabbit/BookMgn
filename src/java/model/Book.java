/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author group 57 isd
 */
public class Book implements Serializable {

    private int bookId;
    private String publisher;
    private String title;
    private String author;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

   

    

    @Override
    public String toString() {
        return "book{" + "bookId=" + bookId + ", publisher=" + publisher + ", title=" + title + ", author=" + author + '}';
    }

   
 
}
