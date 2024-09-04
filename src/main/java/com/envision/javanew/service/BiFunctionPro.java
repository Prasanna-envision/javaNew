package com.envision.javanew.service;

import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionPro implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return Stream.of(list1, list2)
                .flatMap(List::stream)
                .distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        BiFunctionPro bifun = new BiFunctionPro();

        //Bi function for streams
        List<Integer> list1 = Stream.of(1, 3, 4, 6, 7, 9, 19).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(11, 3, 43, 6, 7, 19).collect(Collectors.toList());
        BiFunction<List<Integer>, List<Integer>, List<Integer>> bifunc = (x, y) -> Stream.of(x, y)
                .flatMap(z -> z.stream()).distinct().collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> func = x -> x.stream().sorted().collect(Collectors.toList());
       List<Integer> res= bifunc.andThen(func).apply(list1, list2);


        Map<String, Integer> map = new HashMap<>();
        map.put("basant", 5000);
        map.put("santosh", 15000);
        map.put("javed", 12000);
        map.replaceAll((x, y) -> y + 1000);
        bifun.apply(list1, list2);


        BiPredicate<String,String> equalsPredicate= (s1, s2) ->s1.equals(s2);
        BiPredicate<String,String> lengthPredicate=(s1,s2)->s1.length()==s2.length();
       boolean op= equalsPredicate.test("Prasanna","Prasanna");
       boolean op1=equalsPredicate.and(lengthPredicate).test("Pra","Pra");
       boolean op2=equalsPredicate.or(lengthPredicate).test("pra","pra");
       


    }
}
