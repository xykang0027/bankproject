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
//finish opening account
    private void rcreatAccount(){
        Account acc = new Account();
        System.out.println("enter your account information");
        String name = sc.next();
        acc.setUsername(name);
        System.out.println("please set your password");
        String password = sc.next();
        System.out.println("piease confirm your password");
        String confirmpassword = sc.next();
        if(confirmpassword.equals(password)) {
            acc.setPassWord(confirmpassword);
        }else {
            System.out.println("the two passwords you entered do not match.please confirm");

        }

    }
}


