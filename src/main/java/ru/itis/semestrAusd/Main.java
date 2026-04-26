package ru.itis.semestrAusd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        RadixSort radixSort = new RadixSort();
        TestsCreator testsCreator = new TestsCreator();

        testsCreator.generate(); //генерируем тесты

        //читаем файл" tests.txt" и сортируем массивы
        try(BufferedReader reader = new BufferedReader(new FileReader("tests.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] massive = line.trim().split(" ");//преобразуем строку в массив
                int[] arr = new int[massive.length];
                for(int i = 0; i < massive.length; i++){
                    arr[i] = Integer.parseInt(massive[i]);
                }

                long beginTime = System.nanoTime();
                radixSort.radixSort(arr);
                long endTime = System.nanoTime();
                System.out.println("Количество элементов " + arr.length + ", время работы " + (endTime - beginTime) + ", количество итераций " + radixSort.iterations);

                radixSort.iterations = 0; //обнуляем счетчик для следующего массива
            }
        } catch (IOException e){
            System.out.println("Ошибка в прочтении файла " + e.getMessage());
        }
    }
}
