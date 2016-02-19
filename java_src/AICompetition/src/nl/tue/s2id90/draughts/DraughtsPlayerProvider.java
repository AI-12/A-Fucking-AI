package nl.tue.s2id90.draughts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nl.tue.s2id90.contest.PlayerProvider;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;

/**
 *
 * @author huub
 */
public class DraughtsPlayerProvider extends PlayerProvider<DraughtsPlayer> {
    List<DraughtsPlayer> players = new ArrayList<>();
    public DraughtsPlayerProvider(DraughtsPlayer ... arg) {
        players.addAll(Arrays.asList(arg));
    }

    @Override
    public List<DraughtsPlayer> getPlayers() {
        return players;
    }       
}
