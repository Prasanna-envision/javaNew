package com.envision.javanew.service;

import com.envision.javanew.component.Employ;

import java.util.*;

public class CollectionMethods {
    public static void main(String[] args){
    List<String> list = new ArrayList<>();
        list.add("Prasanna");
        list.add("mahesh");
        list.add("Chiranjeevi");
        list.add("pavan");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Prasanna");
        map.put(2,"mahesh");
        List<Employ> list1=new ArrayList<>();
        list1.add(new Employ(176,"Prasanna","CSE",100000));
        list1.add(new Employ(177,"Mahesh","Civil",200000));
        list1.add(new Employ(178,"Chiranjeevi","Mech",300000));
        Collections.sort(list);//ascending
        Collections.reverse(list);//desecnding
        Collections.sort(list,new MyComprator());
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        Collections.sort(list1,((o1, o2) -> (int) (o1.getSalary()-o2.getSalary())));//ascending
        Collections.sort(list1,((o1, o2) -> (int) (o2.getSalary()-o1.getSalary())));//desending
  //set to list conversion
        List<Map.Entry<Integer,String>> setToList=new ArrayList<>(map.entrySet());
        Collections.sort(setToList,(x,y)-> x.getKey().compareTo(y.getKey()));
    }
}
class MyComprator implements Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}