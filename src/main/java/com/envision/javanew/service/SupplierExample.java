package com.envision.javanew.service;

import java.util.Arrays;
import java.util.List;

public class SupplierExample {
    public static void main(String[] args) {


        List<String> list1 = Arrays.asList();

        System.out.println(list1.stream().findAny().orElseGet(() -> "Hi viewers"));
    }
}