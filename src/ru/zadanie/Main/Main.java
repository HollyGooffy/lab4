package ru.zadanie.Main;

import ru.zadanie.first.Box;
import ru.zadanie.second.DoPointInBox;
import ru.zadanie.second.PointBox;
import ru.zadanie.first.Storage;
import ru.zadanie.third_1.Apply;
import ru.zadanie.third_1.Transform;
import ru.zadanie.third_2.FIlterInt;
import ru.zadanie.third_2.Filter;
import ru.zadanie.third_3.Reduce;
import ru.zadanie.third_3.Reducer;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        /* Задание 1.1 */
        System.out.println("Задание 1.1");
        Box<Integer> intBox = new Box<>();

        intBox.put(3);

        // Извлекаем значение из коробки и выводим его на экран
        if (intBox.isEmpty()) {
            System.out.println("ru.zadanie.first.Box is empty");
        } else {
            Integer value = intBox.get();
            System.out.println(value);
        }


        /* Задание 1.2 */
        System.out.println("Задание 1.2");

        // Создаем хранилище чисел со значением null
        Storage<Integer> intStorageNull = new Storage<>(null, 0);
        System.out.println(intStorageNull.getValue());

        // Создаем хранилище чисел со значением 99
        Storage<Integer> intStorage99 = new Storage<>(99, -1);
        System.out.println(intStorage99.getValue());

        // Создаем хранилище строк со значением null
        Storage<String> stringStorageNull = new Storage<>(null, "default");
        System.out.println(stringStorageNull.getValue());

        // Создаем хранилище строк со значением "hello"
        Storage<String> stringStorageHello = new Storage<>("hello", "hello world");
        System.out.println(stringStorageHello.getValue());


        /* Задание 2.1 */
        System.out.println("Задание 2.1");

        // Первая параметризация
        Box<PointBox<Double>> pointBox = new Box<>();
        DoPointInBox.putInBox(pointBox, 1.0, 2.0, 3.0);

        if (!pointBox.isEmpty()) {
            PointBox<Double> point = pointBox.get();
            System.out.println(point);
        } else {
            System.out.println("Box is empty");
        }


        // Вторая параметризация
        Box<PointBox<Integer>> integerBox = new Box<>();
        DoPointInBox.putInBox(integerBox, 1, 2, 3);

        if (!integerBox.isEmpty()) {
            PointBox<Integer> point = integerBox.get();
            System.out.println(point);
        } else {
            System.out.println("Box is empty");
        }


        // Третья параметризация
        Box<PointBox<String>> stringBox = new Box<>();
        DoPointInBox.putInBox(stringBox, "раз", "два", "три");

        if (!stringBox.isEmpty()) {
            PointBox<String> point = stringBox.get();
            System.out.println(point);
        } else {
            System.out.println("Box is empty");
        }


        /* Задание 3.1 */

        // Длина строк в списке
        System.out.println("Задание 3.1");

        List<String> stringList = List.of("qwerty", "asdfg", "zx");
        List<Integer> integerList = Transform.transform(stringList, new Apply<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.println("Длина строк: " + integerList);


        //Положительные числа
        List<Integer> num = List.of(1, -3, 7);
        List<Integer> posNum = Transform.transform(num, new Apply<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return Math.abs(n);
            }
        });
        System.out.println("Положительные числа: " + posNum);


        //Поиск максимального значения в каждом подсписке
        List<int[]> arrays = List.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9});
        List<Integer> maxValue = Transform.transform(arrays, new Apply<int[], Integer>() {
            @Override
            public Integer apply(int[] array) {
                int max = array[0];
                for (int num : array) {
                    if (num > max) {
                        max = num;
                    }
                }
                return max;
            }
        });

        // Вывод исходного списка массивов
        System.out.print("Значения из массива: ");
        for (int[] array : arrays) {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("] ");
        }
        System.out.println();

        // Вывод результата поиска максимального значения в каждом подсписке
        System.out.println("Максимальное значение из каждого массива: " + maxValue);


        /* Задание 3.2 */
        //Фильтрация строк
        System.out.println("Задание 3.2");
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStr = Filter.filter(strings, new FIlterInt<String>() {
            @Override
            public boolean test(String s) {
                return s.length() >= 3;
            }
        });
        System.out.println("Фильтрация строк: " + filteredStr);


        //Фильтрация положительных чисел
        List<Integer> number = List.of(1, -3, 7);
        List<Integer> filteredInt = Filter.filter(number, new FIlterInt<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n < 0;
            }
        });
        System.out.println("Фильтрация чисел: " + filteredInt);


        //Фильтрация массивов
        List<int[]> arr = List.of(new int[]{-1, -3, -3}, new int[]{4, 5, -4}, new int[]{7, 8, 9});
        List<int[]> filteredArr = Filter.filter(arr, new FIlterInt<int[]>() {
            @Override
            public boolean test(int[] array) {
                for (int num : array) {
                    if (num > 0) {
                        return false;
                    }
                }
                return true;
            }
        });

        System.out.println("Фильтрация списков: ");
        for (int[] array : filteredArr) {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);


            }
        }



        /* Задание 3.3 */

        // Склейка строк
        System.out.println("Задание 3.3 ");
        List<String> strings1 = List.of("qwerty", "asdfg", "zx");
        String plusString = Reduce.reduce(strings1, new Reducer<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + s2;
            }
        }, "");
        System.out.println("Склейка строк: " + plusString);


        //Сумма чисел
        List<Integer> num3_3 = List.of(1, -3, 7);
        Integer sum = Reduce.reduce(num3_3, new Reducer<Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 + n2;
            }
        }, 0);
        System.out.println("Сумма чисел: " + sum);


        //Количество элементов
        List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(6, 7, 8));
        Integer countEl = Reduce.reduce(lists, new Reducer<List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
                List<Integer> combineited = new ArrayList<>(list1);
                combineited.addAll(list2);
                return combineited;
            }
        }, new ArrayList<>()).size();
        System.out.println("Количество элементов: " + countEl);


    }
}



