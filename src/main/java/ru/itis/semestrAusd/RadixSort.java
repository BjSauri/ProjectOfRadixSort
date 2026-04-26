package ru.itis.semestrAusd;

public class RadixSort {
    public int iterations = 0;

    public void radixSort(int[] array){
        int digit = 0;
        int max = 0;
        for(int i = 0; i < array.length; i++){ //ищем максимальный элемент
            digit = Math.max(digit, array[i]);
            iterations++;
        }

        while(digit > 0){//считаем кол-во разрядов в макс элементе
            iterations++;
            digit = digit / 10;
            max++;
        }

        for(int i = 0; i < max; i++){
            iterations++;
            execute(array, i);
        }
    }

    public void execute(int[] array, int r){
        int r10 = 1;
        int l = array.length;
        int[] countDigits = new int[10];
        int[] answer = new int[l];
        int[] executions = new int[10];
        executions[0] = 0;

        for(int i = 0; i < r; i++){
            r10 *= 10;
            iterations++;
        }

        for(int i = 0; i < r; i++){
            countDigits[(array[i] / r10) % 10]++;
            iterations++;
        }

        for(int i = 0; i < 10; i++){
            executions[i] = executions[i - 1] + countDigits[i - 1];
            iterations++;
        }

        for(int i = 0; i < l; i++){
            int x = (array[i] / r10) % 10;
            answer[executions[x]] = array[i];
            executions[x]++;
            iterations++;
        }

        for(int i = 0; i < l; i++){
            array[i] = answer[i];
            iterations++;
        }
    }
}
