package teamproject;
import java.util.ArrayList;
import java.util.Random;
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
                    creatAccount();
                    break;
                default:
                    System.out.println("no operation ");
            }
        }
    }
    private void login(){
        System.out.println("==System login==");
        if(accounts.size()==0){
            return;
        }
        System.out.println("Please enter your login card number");
        String cardid=sc.next();
        Account acc = getAccountByCardId(cardid);
        if(acc == null){
            System.out.println("The cardid you enter is nonexistent");
        }
    }
//finish opening account
    private void creatAccount() {
        System.out.println("**System account opening operation**");
        Account acc = new Account();
        System.out.println("enter your account information");
        String name = sc.next();
        acc.setUsername(name);
        System.out.println("please set your password");
        String passWord = sc.next();
        System.out.println("piease confirm your password");
        String okPassWord = sc.next();
        if(okPassWord.equals(passWord)) {
            acc.setPassWord(okPassWord);
        }else {
            System.out.println("the two passwords you entered do not match.please confirm");

        }
        System.out.println("Please enter your withdrawal limit");
        double limit = sc.nextDouble();
        acc.setLimit(limit);
         String newcardid = createCardid();
         acc.setCardID(newcardid);


        accounts.add(acc);
        System.out.println("Congratulations!"+acc.getUsername()+"Account opened successfully, your card number is:");
    }
 private String createCardid(){
        String cardid="";
        Random r=new Random();
        for(int i =0;i<8;i++){
            int data = r.nextInt(8);
            cardid+=data;
        }
      Account acc =  getAccountByCardId(cardid);
        if(acc==null) {
            return cardid;
        }
     return cardid;
 }
 private Account getAccountByCardId(String cardid){
        for(int i =0;i < accounts.size();i++){
            Account acc =accounts.get(i);
            if(acc.getCardID().equals(cardid)){
                return acc;
            }
        }
        return null;
 }
}


