package homework11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        insertSeparator();
        System.out.println("Задача 1");
        // Напишите метод public static void findMinMax, который будет находить в стриме минимальный и максимальный элементы
        // в соответствии с порядком, заданным Comparator'ом. Данный метод принимает на вход 3 элемента:
        // Stream <? extends T> stream
        // Comparator <? super T> order
        // BiConsumer <? super T, ? super T> minMaxConsumer
        // Найденные минимальный и максимальный элементы передавайте в minMaxConsumer следующим образом:
        // minMaxConsumer.accept(min, max);
        // Если стрим не содержит элементов, то вызывайте:
        // minMaxConsumer.accept(null, null);
        insertSeparator();

        List<Integer> numbers = Arrays.asList(234, 98, 34, 876, 2, 156, 913);
        List<Integer> numbers1 = List.of();

        BiConsumer<Integer, Integer> minMaxConsumer = (maxValue, minValue)  -> {
            System.out.println("Максимальное значение: " + maxValue);
            System.out.println("Минимальное значение: " + minValue);
        };

        findMinMax(numbers.stream(), new Order(), minMaxConsumer);
        findMinMax(numbers1.stream(), new Order(), minMaxConsumer);

        insertSeparator();

        System.out.println("Задача 2");
        // Реализуйте метод, который принимает на вход список целых чисел, определяет в списке количество четных чисел и
        // выводит их в консоль. Решите задание именно с применением Stream API.
        insertSeparator();

        List<Integer> numberList = Arrays.asList(36, 90, 45, 12, 74, 53, 9, 78, 65, 2);
        findEvenNumbers(numberList);

        insertSeparator();
    }

    public static void findMinMax(Stream<Integer> stream,
                                  Comparator<Integer> order,
                                  BiConsumer<Integer, Integer> minMaxConsumer) {
        List<Integer> list = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (!list.isEmpty()) {
            Integer minValue = list.get(0);
            Integer maxValue = list.get(list.size() - 1);
            minMaxConsumer.accept(maxValue, minValue);
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void findEvenNumbers(List<Integer> list) {
        long numberOfEvens = list.stream()
                .filter(number -> number % 2 == 0)
                .count();
        List<Integer> listOfEvens = list.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Четные числа: " + listOfEvens.toString().replace("[", "").replace("]", ""));
        System.out.println("Количество четных чисел в списке: " + numberOfEvens);
    }

    public static void insertSeparator() {
        System.out.println("=========================================================");
    }
}