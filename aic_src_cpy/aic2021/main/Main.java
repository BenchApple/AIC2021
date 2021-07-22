// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.main;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;

class Main extends BaseMain
{
    public static void main(final String[] array) {
        new File(Main.gamesDirectory).mkdirs();
        final String s = array[0];
        final String s2 = array[1];
        final String s3 = array[2];
        String generateReplayFileName = array[3];
        String s4 = array[4];
        String s5 = array[5];
        final boolean equals = array[6].equals("1");
        final long seed = getSeed(array[7]);
        if (s4.equals("_default_")) {
            s4 = s;
        }
        if (s5.equals("_default_")) {
            s5 = s2;
        }
        if (generateReplayFileName.equals("_default_")) {
            generateReplayFileName = generateReplayFileName(s4, s5, s3);
        }
        BaseMain.playOneGame(s, s2, s3, Main.gamesDirectory + File.separator + generateReplayFileName + ".txt", s4, s5, equals, seed);
    }
    
    static String generateReplayFileName(final String s, final String s2, final String str) {
        return new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + "-" + formatPlayerName(s) + "-" + formatPlayerName(s2) + "-" + str;
    }
    
    static String formatPlayerName(final String s) {
        return s.replace('.', '_');
    }
    
    static long getSeed(final String s) {
        if (s.equals("0")) {
            return System.currentTimeMillis();
        }
        try {
            return Long.parseLong(s);
        }
        catch (NumberFormatException ex) {
            System.err.println("Invalid seed. Using random seed instead.");
            return System.currentTimeMillis();
        }
    }
}
