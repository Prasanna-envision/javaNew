package com.envision.javanew.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//old way to implement consumer
/*public class ConumerExample implements Consumer<Book> {
    @Override
    public void accept(Book t) {
        System.out.println(t.getName());
    }
}*/
//new way

public class ConumerExample {
//old way
   /* public ResponseEntity cons() {
        Consumer<Book> con = (t) -> {
            System.out.println(t.getName());
        };
        con.accept((Book) bookDAO.getBooks());
        return null;
    }*/
    public static void main(String[] args) {
        /*
         * Consumer<Integer> consumer = t -> System.out.println("Printing  : " + t);
         *
         * consumer.accept(10);
         */
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list1.stream().forEach(t -> System.out.println("print  : " + t));



    }
}