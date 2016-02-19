package nl.tue.s2id90.group12;


import java.util.ArrayList;
import java.util.List;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;
import org10x10.dam.game.Move;

/**
 * A simple draughts player that plays the first moves that comes to mind
 * and values all moves with value 0.
 * @author huub
 */
public class AlphaPlayer extends DraughtsPlayer {

    public AlphaPlayer() {
        super(AlphaPlayer.class.getResource("resources/optimist.png"));
    }
    @Override
    /** @return a random move **/
    public Move getMove(DraughtsState s) {
        List<Move> moves = s.getMoves();
        int[] h = new int[moves.size()];
        for(int i=0; i<moves.size();i++)
        {
            s.doMove(moves.get(i));
            h[i] = Search.AlphaBeta(s, 5, true);
            s.undoMove(moves.get(i));
        }
        return moves.get(0);
    }

    @Override
    public Integer getValue() {
        return 0;
    }
}
