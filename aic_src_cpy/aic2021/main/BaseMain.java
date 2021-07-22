// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.main;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import aic2021.engine.Game;
import aic2021.user.Team;

class BaseMain
{
    static final String mapsDirectory;
    static final String gamesDirectory;
    static final String challengesDirectory;
    
    static Team playOneGame(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final boolean b, final long n) {
        final Game game = new Game(s, s2, s3, s4, s5, s6, b, n);
        game.start();
        try {
            game.join();
            return game.getWinner();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    static String generateReplayFileName(final String s, final String s2, final String str) {
        return new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + "-" + formatPlayerName(s) + "-" + formatPlayerName(s2) + "-" + str;
    }
    
    static String formatPlayerName(final String s) {
        return s.replace('.', '_');
    }
    
    static {
        mapsDirectory = System.getProperty("user.dir") + File.separator + "maps";
        gamesDirectory = System.getProperty("user.dir") + File.separator + "games";
        challengesDirectory = System.getProperty("user.dir") + File.separator + "challenges";
    }
}
