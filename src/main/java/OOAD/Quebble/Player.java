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

    public boolean substractBalance(int givenBalance) {
        if (credit > givenBalance) {
            this.credit -= givenBalance;
            return true;
        }
        return false;
    }

    public void login(String username, String password) {
        this.username = username;
        this.credit = 1000;
    }
}
