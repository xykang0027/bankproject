package teamproject;

import java.util.ArrayList;
import java.util.List;
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
        while (true){
            System.out.println("Please enter your login card number");
        String cardid = sc.next();
        Account acc = getAccountByCardId(cardid);
        if (acc == null) {
            System.out.println("The cardid you enter is nonexistent");
        }
        else{
            while (true) {
                System.out.println("Please enter password");
                String passWord = sc.next();
                if(acc.getPassWord().equals(passWord)){
                    loginAcc = acc;
                    System.out.println("Congratulations," + acc.getUsername() + " login successful");
                    showLoginAccount();
                    return;
                }
                else{
                    System.out.println("The password you entered is incorrect. Please re-enter it");
                }
            }
        }
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
        System.out.println("please confirm your password");
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
        while (true) {
            System.out.println(loginAcc.getUsername() + "you can choose these functions to deal with your account");
            System.out.println("1.check account");
            System.out.println("2.save money");
            System.out.println("3.take money");
            System.out.println("4.transfer money");
            System.out.println("5.change password");
            System.out.println("6.leave");
            System.out.println("Cancel current account");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    showLoginAccount();
                    //check account
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
                    System.out.println(loginAcc.getUsername() + "You have successfully logged out of the system!");
                    return;
                case 7:
                    break;
                default:
                    System.out.println("the operate you choose is not exsit,please choose another");
            }
        }
    }

    private void updatePassWord() {
        System.out.println("change password");
        while (true) {
            System.out.println("please input your origin password：");
            String passWord = sc.next();

            if (loginAcc.getPassWord().equals(passWord)) {
                while (true) {
                    System.out.println("please input new password：");
                    String newPassWord = sc.next();

                    System.out.println("please input new password again：");
                    String okPassWord = sc.next();

                    if (okPassWord.equals(newPassWord)) {
                        loginAcc.setPassWord(okPassWord);
                        System.out.println("congratulation,you have changed your password successfully~~~");
                        return;
                    } else {
                        System.out.println("the two password you input is different");
                    }
                }
            } else {
                System.out.println("the origin password is not exist");
            }
        }
    }
    private void depositMoney() {
        System.out.println("save money");
        System.out.println("please input the amount you want to save：");
        double money = sc.nextDouble();

        loginAcc.setMoney(loginAcc.getMoney() + money);
        System.out.println("congratulation,you have saved：" + money + "in your account" + loginAcc.getMoney());
    }
    private void showLoginAccount(){
        System.out.println("here is the information of your account");
        System.out.println("account number：" + loginAcc.getCardID());
        System.out.println("user：" + loginAcc.getUsername());
        System.out.println("money：" + loginAcc.getMoney());
        System.out.println("limitation of each time：" + loginAcc.getLimit());
    }

    private void transferMoney() {
        System.out.println("transfer money");
        if (accounts.size() < 2) {
            System.out.println("you are the only account in system, you can not transfer money");
            return;
        }

        if (loginAcc.getMoney() == 0) {
            System.out.println("you don not have enough money");
            return;
        }

        while (true) {
            System.out.println("please input target account number：");
            String cardId = sc.next();

            Account acc = getAccountByCardId(cardId);
            if (acc == null) {
                System.out.println("this account is not exist");
            } else {

                System.out.println("please input the amount of money you want to transfer：");
                double money = sc.nextDouble();

                if (loginAcc.getMoney() >= money) {
                    loginAcc.setMoney(loginAcc.getMoney() - money);

                    acc.setMoney(acc.getMoney() + money);
                    System.out.println("success");
                    return; // 跳出转账方法。。
                } else {
                    System.out.println("you do not have enough money ,you can only transfer：" + loginAcc.getMoney());
                }
            }
        }
    }
    private void drawMoney() {
        System.out.println("take money");
        if(loginAcc.getMoney() < 100){
            System.out.println("you do not have enough money,please save more");
            return;
        }


        while (true) {
            System.out.println("please input the amount of money you want to take out：");
            double money = sc.nextDouble();

            if(loginAcc.getMoney() >= money){
                if(money > loginAcc.getLimit()){
                    System.out.println("it is over the limitation,you can only take：" + loginAcc.getLimit()+"each time");
                }else {
                    loginAcc.setMoney(loginAcc.getMoney() - money);
                    System.out.println("you have taken：" + money + "successfully,now you have：" + loginAcc.getMoney());
                    break;
                }
            }else {
                System.out.println("you do not have enough money：" + loginAcc.getMoney());
            }
        }
    }

}


