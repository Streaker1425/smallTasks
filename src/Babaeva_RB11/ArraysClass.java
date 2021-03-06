package Babaeva_RB11;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class ArraysClass {
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
            if(temp[i]<0){
                temp[i] *= -1;
            }
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
    public static int[] shiftElements(int[] arr){
        int last = 0;
        for (int i = arr.length-1; i > 0; i--){
            if(i == arr.length-1){
                last = arr[i];
                arr[i] = arr[i-1];
            } else {
                arr[i] = arr[i-1];
            }
        }
        arr[0] = last;
        return arr;
    }
    public static int[] shiftElements(int[] arr, int amount){
        for(int i = 0; i < amount; i++){
            shiftElements(arr);
        }
        return arr;
    }
    public static double defineAverage(int[] arr){
        int sum = 0;
        for(int elem : arr){
            sum += elem;
        }
        return (double) sum / (arr.length);
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
        System.out.print("Your array is: ");
        print(arr);


        System.out.print("\nSorted array is: ");
        print(sort(arr));
        System.out.print("\nShifted array is: ");
        print(shiftElements(arr));
        System.out.print("\nThree times shifted array is: ");
        print(shiftElements(arr, 3));
        System.out.println("\nAverage number of array is: " + defineAverage(arr));
    }
}
