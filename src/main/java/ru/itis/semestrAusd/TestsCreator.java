package ru.itis.semestrAusd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TestsCreator {
    private final Random generator= new Random();

    public void generate(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++){
            int size = generator.nextInt(100, 10001); //размер ArrayList от 100 - 10000
            ArrayList<Integer> arr = new ArrayList<>(size);
            for(int j = 0; j < size; j++){
                arr.add(generator.nextInt(0,10001)); //элементы от 0 до 10000
            }
            String line = arr.toString().replaceAll("[\\[\\]\\,]", "").trim();//trim() удаляет пробелы в начале и в конце строки
            sb.append(line).append("\n");
        }
         try(BufferedWriter writer = new BufferedWriter(new FileWriter("tests.txt"))){
             writer.write(sb.toString());
         } catch (IOException e){
             System.out.println("Ошибка в записи файла" + e.getMessage());
         }//trim() удаляет пробелы в начале и в конце строки
    }
}
