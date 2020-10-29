package OOAD.Quebble;

public class Player {
    private static Player instance = null;
    public String username;
    public int credit;

    private Player() {
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public boolean hasSufficientBalance(int givenBalance){
        return credit > givenBalance;
    }

    public void substractBalance(int givenBalance) {
        this.credit -= givenBalance;
    }

    public void login(String username, String password) {
        this.username = username;
        this.credit = 1000;
    }
}
