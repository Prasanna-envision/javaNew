package com.envision.javanew.service;

import java.util.Collections;
import java.util.List;

public class BookService {

    public List<Book> getBooksinSort() {
        List<Book> books = new BookDAO().getBooks();
        //Ascending order
        Collections.sort(books, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        //descending order
        Collections.sort(books, (o1, o2) -> o2.getName().compareTo(o1.getName()));
        return books;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getBooksinSort());
    }

   /* public List<Book> getBooksinSort() {
        List<Book> books = new BookDAO().getBooks();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare (Book o1, Book o2){
                return o2.getName().compareTo(o1.getName());
            }
        });
         return books;
        }*/
        //old way to write Comparator implementation
    /*
     public List<Book> getBooksinSort() {
        List<Book> books = new BookDAO().getBooks();
        Collections.sort(books, new MyComparator());
        return books;
    }
     * class MyComparator implements Comparator<Book> {
     *
     * @Override public int compare(Book o1, Book o2) { return
     * o2.getName().compareTo(o1.getName()); }
     */
    }
