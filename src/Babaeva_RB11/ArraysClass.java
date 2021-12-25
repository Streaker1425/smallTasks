package Babaeva_RB11;

import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static Scanner scan = new Scanner(System.in);

    public static int[] initArray(){
        //не указано, какой размер, поэтому сделаем 10
        int[] temp = new int[10];
        for(int i = 0; i < 10; i++){
            System.out.print("Enter element with index " + i + ">");
            temp[i] = scan.nextInt();
        }
        return temp;
    }
    public static int[] initArray(int len){
        Random rand = new Random();
        int[] temp = new int[len];
        for(int i = 0; i < len; i++){
            temp[i] = rand.nextInt() % 100;
        }
        return temp;
    }
    public static void print(int[] arr){
        for(int elem : arr){
            System.out.print(elem + " ");
        }
    }
    public static boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static int[] sort(int[] arr){
        int temp; // временная переменная для обмена элементов местами

        // Сортировка массива пузырьком
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // меняем элементы местами
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.print("Enter length of array>");
        int n;
        while(true){
            n = scan.nextInt();
            if(n>=5  && n<50 || n==0){
                break;
            }
            System.out.print("Try again>");
        }
        int[] arr;
        if(n == 0){
            arr = initArray();
        } else {
            arr = initArray(n);
        }
        print(arr);
        System.out.println();
        arr = sort(arr);
        print(arr);
    }
}
