package com.envision.javanew.service;

import com.envision.javanew.component.Customer;
import com.envision.javanew.component.Employ;
import com.envision.javanew.component.ResourceNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMethods {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Prasanna");
        list.add("mahesh");
        list.add("Chiranjeevi");
        list.add("pavan");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Prasanna");
        map.put(2, "mahesh");
        Map<Employ, Integer> map1 = new HashMap<>();
        map1.put(new Employ(176, "Prasanna", "CSE", 100000), 10);
        map1.put(new Employ(177, "Mahesh", "Civil", 200000), 20);
        List<Employ> list1 = new ArrayList<>();
        list1.add(new Employ(176, "Prasanna", "CSE", 100000));
        list1.add(new Employ(177, "Mahesh", "Civil", 200000));
        list1.add(new Employ(178, "Chiranjeevi", "Mech", 300000));

        List<Customer> list2 = new ArrayList<>();
        list2.add(new Customer(176, "Prasanna", null, Arrays.asList("1000000000", "2000000000")));
        list2.add(new Customer(177, "Mahesh", "mahesh@gmail.com", Arrays.asList("3000000000", "4000000000")));
        list2.add(new Customer(178, "Chiranjeevi", "chiru@gmail.com", Arrays.asList("5000000000", "6000000000")));

        //forEach for list===================================
        list.stream().forEach(x -> System.out.println(x));
        //forEach for map
        map.forEach((key, value) -> System.out.println(key + "," + value));
        map.entrySet().stream().forEach(obj -> System.out.println(obj.getKey()));
        //filter for list==========================================
        list.stream().filter(x -> x.startsWith("P")).forEach(System.out::println);
        List<String> lis = list.stream().filter(x -> x.startsWith("P")).collect(Collectors.toList());
        map.entrySet().stream().filter(obj -> obj.getValue().equalsIgnoreCase("mahesh")).forEach(x -> x.getKey());
        list1.stream().filter(x -> x.getSalary() > 100000).forEach(System.out::println);
        //sorted order for primitive type
        list.stream().sorted().forEach(System.out::println);//ascending
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);//descending
        //sorted order for custom object
        list1.stream().sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).forEach(System.out::println);
        list1.stream().sorted(Comparator.comparing(Employ::getSalary).reversed()).collect(Collectors.toList());
        list1.stream().sorted(Comparator.comparing(Employ::getId).thenComparing(Employ::getName).thenComparing(Employ::getSalary)).collect(Collectors.toList());
        //reversed method will not support
        list1.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).collect(Collectors.toList());
        list1.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).collect(Collectors.toList());
        //sorting map
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employ::getName).thenComparing(Employ::getName))).forEach(System.out::println);
        map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employ::getName).reversed())).forEach(System.out::println);
        //map & flatMap
        List<String> maps = list2.stream().map(x -> x.getEmail()).collect(Collectors.toList());
        List<List<String>> mapss = list2.stream().map(x -> x.getPhoneNumbers()).collect(Collectors.toList());
        List<String> flatmap=list2.stream().flatMap(x->x.getPhoneNumbers().stream()).collect(Collectors.toList());
//optinal
        Optional<Object> opt=Optional.empty();//empty object
       Optional<String> opt1=Optional.of(list2.get(0).getEmail());//if null value returns null point exception
        String opt2=Optional.ofNullable(list2.get(0).getEmail()).orElse("default@gmail.com");//if null return empty else reurn value
       String opt3=Optional.ofNullable(list2.get(0).getEmail()).map(x->x.toUpperCase()).orElseGet(()->"email not avaialable");
       Optional.ofNullable(list2.get(0).getEmail()).orElseThrow(()->new ResourceNotFoundException("email not found"));
        if(opt1.isPresent()) {
           opt1.get();//no such method exception message if value there we can get that.
       }
        list2.stream().filter(x->x.getEmail().equals("mahesh@gmail.com")).findAny().get();
        list2.stream().filter(x->x.getEmail().equals("mahesh@gmail.com")).findAny().orElseGet(()->new Customer());
        list2.stream().filter(x->x.getEmail().equals("mahesh@gmail.com")).findAny().orElseThrow(()->new ResourceNotFoundException("not found"));
//map and reduce
       List<Integer> numbers= Arrays.asList(3,4,5,6,7,8);
        List<String> words = Arrays.asList("corejava", "spring", "hibernate");
        numbers.stream().mapToInt(i->i).sum();
       int i= numbers.stream().reduce(0,(x,y)->x*y);
        Optional<Integer> j=numbers.stream().reduce(Integer::sum);
        Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        words.stream().reduce((x,y)->x.length()>y.length()?x:y).get();
        list1.stream().filter(x->x.getSalary()>100000).map(x->x.getSalary()).mapToDouble(x->x).average().getAsDouble();
        list1.stream().filter(x->x.getSalary()>100000).map(x->x.getSalary()).mapToDouble(x->x).sum();
//BiFunction,BiConsumer,Bipredicate




    }

}

