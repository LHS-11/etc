package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main78953 {
    public static void main(String[] args) {


        Calculator cal = (a1, a2) -> a1 + a2;
        System.out.println(cal.sum(10,25));

        BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> n1+n2;

        System.out.println(biFunction.apply(10,20));

        BiConsumer<Integer,Integer> biConsumer=(n1,n2) -> System.out.println(n1+n2);

        biConsumer.accept(10,20);

        Function<Integer, Integer> function = i -> i+1;

        System.out.println(function.apply(10));

        Supplier<Integer> supplier = () ->10;

        System.out.println(supplier.get());

        List<Integer> list=List.of(1,2,3,4,5,6,7,8,9);
        ArrayList<Integer> arrayList = new ArrayList<>(list);

//        Integer integer = arrayList.stream().reduce().get();
//        System.out.println(integer);
//        list.stream().map().forEach(s-> System.out.println(s));

        // Function, Consumer, Supplier, Predicate
    }
}
