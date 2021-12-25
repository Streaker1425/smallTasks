import java.util.Scanner;

public class FormatedIO {

    public static boolean func(int arg){
        if(arg > 4 || arg < 0) return false;
        System.out.println("jopa");
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Enter number fron 0 to 4 (0 - exit)>");
            int answer = scan.nextInt();
            if(!func(answer)){
                System.out.println("You entered wrong number!");
            } else {
                System.out.println("Here`s result: ");
            }
        }
    }
}
