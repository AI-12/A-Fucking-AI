/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.group12;

import net.xeoh.plugins.base.annotations.PluginImplementation;
import nl.tue.s2id90.draughts.DraughtsPlayerProvider;
import nl.tue.s2id90.draughts.DraughtsPlugin;



/**
 *
 * @author huub
 */
@PluginImplementation
public class MyDraughtsPlugin extends DraughtsPlayerProvider implements DraughtsPlugin {
    public MyDraughtsPlugin() {
        // make two players available to the AICompetition tool
        // During the final competition you should make only your 
        // best player available. For testing it might be handy
        // to make more than one player available.
        super(	new UninformedPlayer(),
		new OptimisticPlayer(),
		new StupidPlayer(),
		new FakingPlayer1());
    }
}
