package nl.tue.s2id90.group12;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;
import org10x10.dam.game.Move;
import org.zeromq.ZMQ;

/**
 * @author boddmg
 */
public class FakingPlayer1 extends DraughtsPlayer {
    private static final Logger 
	    LOG = Logger.getLogger(DraughtsPlayer.class.getName());
    private ZMQ.Context context;
    private ZMQ.Socket socket;

    public FakingPlayer1() {
        super(UninformedPlayer.class.getResource("resources/optimist.png"));
	context = ZMQ.context(1);
	socket = this.context.socket(ZMQ.REP);
	socket.bind("tcp://*:23333");
    }
    @Override
    /** @return a random move **/
    public Move getMove(DraughtsState s) {
	List<Move> moves = s.getMoves();

		OUTER:
		while (true) {
			String command = socket.recvStr();
			String response = "";
			switch (command) {
				case "getMoves":
					for (int i = 0; i < moves.size(); i++) {
						response += moves.get(i).toString() + "\r\n";
					}		this.socket.send(response);
					LOG.log(Level.INFO, response);
					break;
				case "returnMove":
					this.socket.send("ok");
					int returnMoveIndex = Integer.parseInt(this.socket.recvStr());
					this.socket.send("ok");
					return moves.get(returnMoveIndex);
				default:
					break OUTER;
			}
		}
	return moves.get(0);
    }
    
    @Override
    public Integer getValue() {
        return 0;
    }
}
