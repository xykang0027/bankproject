package teamproject;
public class Account {
    private String cardID;
    private String username;
    private char sex;
    private String passWord;
    private double money;
    private double limit;//限额

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String setPassWord(String okpassWord) {
        return okpassWord;
    }

    public String getPassWord() {
        return passWord;
    }
}