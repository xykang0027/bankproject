package teamproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private Account loginAcc;
    //opening

    public void start() {
        while (true) {
            System.out.println("welcome to join the ATM");
            System.out.println("1,log in");
            System.out.println("2,User account opening");
            System.out.println("take your choices");
            int command = sc.nextInt();
            switch (command) {
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

    private void login() {
        System.out.println("==System login==");
        if (accounts.size() == 0) {
            return;
        }
        System.out.println("Please enter your login card number");
        String cardid = sc.next();
        Account acc = getAccountByCardId(cardid);
        if (acc == null) {
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
        if (okPassWord.equals(passWord)) {
            acc.setPassWord(okPassWord);
        } else {
            System.out.println("the two passwords you entered do not match.please confirm");

        }
        System.out.println("Please enter your withdrawal limit");
        double limit = sc.nextDouble();
        acc.setLimit(limit);
        String newcardid = createCardid();
        acc.setCardID(newcardid);


        accounts.add(acc);
        System.out.println("Congratulations!" + acc.getUsername() + "Account opened successfully, your card number is" + acc.getCardID());
    }

    private String createCardid() {
        String cardid = "";
        Random r = new Random();
        for (int i = 0; i < 8; i++) {
            int data = r.nextInt(8);
            cardid += data;
        }
        Account acc = getAccountByCardId(cardid);
        if (acc == null) {
            return cardid;
        }
        return cardid;
    }

    private Account getAccountByCardId(String cardid) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardID().equals(cardid)) {
                return acc;
            }
        }
        return null;
    }

    private void showUserCommand() {
        System.out.println("you can choose these functions to deal with your account");
        System.out.println("1.check account");
        System.out.println("2.save money");
        System.out.println("3.take money");
        System.out.println("4.transfer money");
        System.out.println("5.change password");
        System.out.println("6.leave");
        int command = sc.nextInt();
        switch (command) {
            case 1:
                //check money
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("the operate you choose is not exsit,please choose another");
        }
    }
    private void updatePassWord() {
        System.out.println("==账户密码修改操作==");
        while (true) {
            System.out.println("请您输入当前账户的密码：");
            String passWord = sc.next();

            if(loginAcc.getPassWord().equals(passWord)){
                while (true) {
                    System.out.println("请您输入新密码：");
                    String newPassWord = sc.next();

                    System.out.println("请您再次输入密码：");
                    String okPassWord = sc.next();

                    if(okPassWord.equals(newPassWord)){
                        loginAcc.setPassWord(okPassWord);
                        System.out.println("恭喜您，您的密码修改成功~~~");
                        return;
                    }else {
                        System.out.println("您输入的2次密码不一致~~");
                    }
                }
            }else {
                System.out.println("您当前输入的密码不正确~~");
            }
        }
    }


}



