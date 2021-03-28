package OOAD.Quebble.DAO.Player;

import OOAD.Quebble.Player;

import java.util.ArrayList;

public class PlayerDAO implements IPlayerDao {
    private ArrayList<Player> players;

    public PlayerDAO(){
        players = this.getPlayers();
    }

    private ArrayList<Player> getPlayers(){
        //TODO: Deze in player zetten
        ArrayList<Player> playerslist = new ArrayList<>();
        playerslist.add(new Player("rustigeErik", 1000,null));
        playerslist.add(new Player("gefrustreerdeBanaan", 140, null));
        playerslist.add(new Player("deOngetemdeSlak", 2450, null));
        return playerslist;
    }
    public Player getPlayer(String username){
        for (Player player : players) {
            if (player.getUsername().equals(username))
                return player;
        }
        return null;
    }

}
