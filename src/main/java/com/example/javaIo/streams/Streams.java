package com.example.javaIo.streams;

import java.util.ArrayList;
import java.util.List;

public class Streams {

    // 1. Функциональные интерфейсы - это интерфейсы с одним абстрактным методом

    // У нас есть интерфейс Worker с одним методом work() - ничего не принимает и ничего не возвращает
    // Так же есть класс Директор, который имеет один метод, заставляющий Worker работать.
    //Метод принимает в параметрах объект типа Worker и вызывает у него метод work()
    //создаем в методе psvm директора и заставляем одного работника работать при помощи анонимного класса new Worker

    public static void main(String[] args) {
          Director director = new Director();
        director.toDoTheWork(new Worker() { // анонимный класс, его мы смогли создать при помощи интерфейса с одним абстрактным методом
            @Override
            public void work() {
                System.out.println("working");
            }
        });

        //перепишем анонимный метод на лямбда выражение: у нас в нем только один метод work который ниячего не принимает и содержит
        //только одну строчку кода
        //director.toDoTheWork(() -> System.out.println("working"));

        // если бы была НЕ ОДНА строчка кода, то нужно было бы это писать уже в {} скобках
//        director.makeItWork(() -> {
//            System.out.println("working");
//            System.out.println("break");
//            System.out.println("done");
//        });


        //Реализуем ПРОСТОЙ способ фильтрации коллекции через циклы:
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);

        //Нужно отфильтровать коллекцию чисел, и вернуть коллекцию, содержащую только четные числа:
       // filterList(array);

        //Но что если нам нужно в этой коллекции так же оставить только те числа которые делятся на 5 ?
        //Тогда нам нужно метод filterList сделать более абстрактным

        //возьмем новый метод фильтр и здесь мы сами можем решать по какому принципу фильтровать числа:
        filterList(array, new Predicate() {
            @Override
            public boolean test(int i) {
                return i % 2 == 0;
            }
        });

//мы можем переписать его в лямбда выражение:
//        filterList(array, (n) -> {     // --- метод test принимает на вход параметр типа int, назовем его как угодно, будет n
//            return n % 2 == 0;     // здесь в {} пишем условие фильтрации
//        });
//
//        filterList(array, (n) -> n % 2 == 0);  //поскольку выражение в одну строчку мы можем переписать короче


        //Что если нужно к каждому элементу применить какую-либо модификацию? Например, из типа int сделать тип String

        //стримы: фильтр внутри, map внутри и collect завершает
//        List<String> listOfResult = array.stream()
//                .filter(new java.util.function.Predicate<Integer>() {  //промежуточный оператор
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer % 2 == 0;
//                    }
//                }).map(new Function<Integer, String>() {   // промежуточный оператор
//                    @Override
//                    public String apply(Integer integer) {
//                        return integer.toString() + " I'm a string";
//                    }
//                }).collect(Collectors.toList());    //терминальный оператор - завершающий
//
//
//        System.out.println(listOfResult);

//переделаем в лямбда выражения:
        List<String> listOfResult = array.stream()
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer.toString() + " I'm a string")
                .toList();


    }


//    public static List<Integer> filterList(List<Integer> list) {

//        List<Integer> result = new ArrayList<>();
//
//        for (int element : list) {
//            if (element % 2 == 0) {
//                result.add(element);
//            }
//        }
//        System.out.println(result);
//        return result;
//    }

    //изменим с предикатом:
    public static List<Integer> filterList(List<Integer> list, Predicate predicate) {

        List<Integer> result = new ArrayList<>();

        for (int element : list) {
            if (predicate.test(element)) { //если число проходит проверку то мы его оставляем
                result.add(element);
            }
        }
        System.out.println(result);
        return result;
    }


}
