package OOAD.Quebble;

public class Player {
    public String username;
    public int credit;

    public Player() { }
    public Player(String username, int credit) {
        this.username = username;
        this.credit = credit;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean hasSufficientBalance(int givenBalance){
        return this.credit > givenBalance;
    }

    public void substractBalance(int givenBalance) {
        this.credit -= givenBalance;
    }

    public void login(String username, String password) {
        //TODO: omzetten naar echte user.
        this.username = username;
        this.credit = 1000;
    }
}
