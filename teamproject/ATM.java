package teamproject;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts=new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    //opening

    public void start (){
        while (true) {
            System.out .println("welcome to joim the ATM");
            System.out. println("1,log in");
            System.out. println("2,User account opening");
            System.out. println("take your choices");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //log in
                    break;
                case 2:
                    //account opening
                    break;
                default:
                    System.out.println("no operation ");
            }
        }
    }
}


