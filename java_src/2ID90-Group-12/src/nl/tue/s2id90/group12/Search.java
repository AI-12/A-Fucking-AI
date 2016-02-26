/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.group12;

import java.util.List;
import java.util.Arrays;
import nl.tue.s2id90.draughts.DraughtsState;
import org10x10.dam.game.Move;

/**
 *
 * @author mistree
 */
public class Search {
    
    static public int MinMax(DraughtsState s,int depth, boolean maximizing)
    {
        int best = 0;
        if(depth == 0 || s.getMoves().isEmpty())
            return Evaluate(s,maximizing);
        
        List<Move> moves = s.getMoves();
        if(maximizing)
        {         
            best = -0xFFFF;
            for (Move m : moves) 
            {
                best = Math.max(best, MinMax(s,depth-1,false));
            }
            return best;
        } else 
        {
            best = 0xFFFF;
            for (Move m : moves) 
            {
                best = Math.min(best, MinMax(s,depth-1,true));
            }
            return best;
        }
    }
    
    static public int AlphaBeta(DraughtsState s,int depth, boolean maximizing)
    {
        return AlphaBeta(s,depth,-0xFFFF,0xFFFF,true);
    }
    
    static private int AlphaBeta(DraughtsState s,int depth, int a, int b , boolean maximizing)
    {
        int aa = a,bb=b;
        if(depth == 0 || s.getMoves().isEmpty())
            return Evaluate(s,maximizing);
        
        List<Move> moves = s.getMoves();
        if(maximizing)
        {           
            for (Move m : moves) 
            {
                s.doMove(m);
                aa = Math.max(aa, AlphaBeta(s,depth-1,aa,bb,false));
                s.undoMove(m);
                if(aa>=bb)
                    break;
            }
            return aa;
        } else 
        {
            for (Move m : moves) 
            {
                s.doMove(m);
                bb = Math.min(bb, AlphaBeta(s,depth-1,aa,bb,true));
                s.undoMove(m);
                if(aa>=bb)
                    break;
            }
            return bb;
        }
    }
    
    static private int Evaluate(DraughtsState s, boolean maximizing)
    {
        int WhiteCount = (int)Arrays.stream(s.getPieces()).filter(x -> x == DraughtsState.WHITEPIECE).count();
        int BlackCount = (int)Arrays.stream(s.getPieces()).filter(x -> x == DraughtsState.BLACKPIECE).count();  
        if(maximizing)
            return WhiteCount - BlackCount;
        else
            return BlackCount - WhiteCount;
    }
}
