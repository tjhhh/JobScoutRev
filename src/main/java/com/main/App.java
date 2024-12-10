package com.main;

/**
 * Hello world!
 *
 */
import java.util.*;
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(20,"hujan","ojan"));
        books.add(new Book(50,"Terang","dia"));

        for(Book book : books){
            try{
                System.out.println("Judul: "+book.getTitle()+" ,Penulis: "+ book.getAuthor()+" ,Halaman: "+ book.getPage());
            }catch(NullPointerException e){
                System.out.println("Salah Nulis"+e.getMessage());
            }
        }
    }
}
