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
        super(AlphaPlayer.class.getResource("resources/sai.png"));
    }
    @Override
    /** @return a random move **/
    public Move getMove(DraughtsState s) {
        List<Move> moves = s.getMoves();
        int Index = 0;
        int Value = -0xFFFF;
        for(int i=0; i<moves.size();i++)
        {
            int h;
            s.doMove(moves.get(i));
            h = Search.AlphaBeta(s, 7, true);
            s.undoMove(moves.get(i));
            if(h>Value)
            {
                Value = h;
                Index = i;
            }
        }
        return moves.get(Index);
    }

    @Override
    public Integer getValue() {
        return 0;
    }
}
