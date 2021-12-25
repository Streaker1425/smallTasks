package Babaeva_RB11;

import java.util.Scanner;

//завдання 29-30
public class FormatedIO {

    private static final int[] array = {1, 22, 333, 4444, 55555, 666666};


    public static boolean func(int arg){
        if(arg > 4 || arg < 0) return false;
        switch (arg) {
            case 1:{
                for(int i = array.length-1; i>=0; i--){
                    System.out.println(array[i]);
                }
                break;
            }
            case 2:{
                for(Integer elem : array){
                    System.out.print("          ");
                    for(int i = 0; i<6-elem.toString().length(); i++){
                        System.out.print(' ');
                    }
                    System.out.println(elem);
                }
                break;
            }
            case 3:{
                for(int i = array.length-1; i>=0; i--){
                    Integer elem = array[i];
                    for(int j = 0; j<6-elem.toString().length(); j++){
                        System.out.print("0");
                    }
                    System.out.println(array[i]);
                }
                break;
            }
            case 4:{
                //не совсем понятно, что тут вообще происходит, но ладно. Странное задание, странное решение
                System.out.println(array[5]);
                System.out.println(array[0]);
                System.out.println(array[4]);
                System.out.println("+" + array[1]);
                Integer elem = array[3];
                String el = elem.toString();
                for(int i = 0; i<4; i++){
                    if(i!=2){
                        System.out.print(el.charAt(i));
                    } else {
                        System.out.print(" " + el.charAt(i));
                        System.out.print(el.charAt(i));
                    }
                }
                elem = array[2];
                el = "\n " + elem.toString() + elem.toString().charAt(0);
                System.out.println(el);
                break;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Enter number from 0 to 4 (0 - exit)>");
            int answer = scan.nextInt();
            if(answer == 0){
                return;
            }
            if(!func(answer)){
                System.out.println("You entered wrong number!");
            }
        }
    }
}
