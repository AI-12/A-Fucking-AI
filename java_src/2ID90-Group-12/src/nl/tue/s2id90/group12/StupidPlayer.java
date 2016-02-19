package nl.tue.s2id90.group12;


import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;
import org10x10.dam.game.Move;

/**
 * A simple draughts player that plays random moves
 * and values all moves with value 0.
 * @author huub
 */
public class StupidPlayer extends DraughtsPlayer {

    public StupidPlayer() {
        super(StupidPlayer.class.getResource("resources/smiley.png"));
    }
    @Override
    /** @return an illegal move **/
    public Move getMove(DraughtsState s) {
       return null;
    }

    @Override
    public Integer getValue() {
        return 0;
    }
}
