package Babaeva_RB11;

import java.util.Random;
import java.util.Scanner;

public class SquareMatrix {

    public static int size = 0;

    public static int[][] createMatrix(){
        System.out.print("Enter size of new square matrix>");
        while(true) {
            Scanner scan = new Scanner(System.in);
            size = scan.nextInt();
            if (size > 2 && size <= 10) {
                break;
            }
            System.out.print("Value must be from 3 to 10, try again>");
        }
        int[][] matrix = new int[size][size];
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = 21 + rand.nextInt() % 50;
            }
        }
        return matrix;
    }
    public static void print(int[][] matrix){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println("\n");
        }
    }
    public static int[][] transponate(int[][] matrix){
        int[][] temp = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp[i][j] = matrix[j][i];
            }
        }
        return temp;
    }
    public static boolean isSymmetrical(int[][] matrix){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(matrix[i][j] != matrix[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        System.out.println("New matrix is:");
        print(matrix);
        int[][] transMatrix = transponate(matrix);
        System.out.println("\nTransponated matrix is: ");
        print(transMatrix);
        System.out.println("This matrix is symmetrical: " + isSymmetrical(matrix));
        size = 3;
        int[][] symMatrix = new int[][]{
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 4}
        };
        System.out.println("\nNew symetrical matrix is: ");
        print(symMatrix);
        System.out.println("This matrix is symmetrical: " + isSymmetrical(symMatrix));
    }
}
