// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.main;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import aic2021.util.random.CustomRandom;
import java.util.EnumMap;
import aic2021.user.Team;
import java.util.ArrayList;
import java.io.File;

class MainChallenge extends BaseMain
{
    public static void main(final String[] array) {
        runChallenge(array[0], array[1]);
    }
    
    private static void runChallenge(final String str, final String str2) {
        final File file = new File(MainChallenge.mapsDirectory);
        final ArrayList<String> list = new ArrayList<String>();
        final File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (final File file2 : listFiles) {
                if (file2.isFile()) {
                    list.add(file2.getName().split("\\.")[0]);
                }
            }
        }
        else {
            System.err.println("runChallenge: Couldn't find maps in the folder " + file.getAbsolutePath());
        }
        final String generateChallengeFolder = generateChallengeFolder(str, str2);
        final EnumMap<Team, Integer> enumMap = new EnumMap<Team, Integer>(Team.class);
        enumMap.put(Team.A, 0);
        enumMap.put(Team.B, 0);
        for (final String s : list) {
            final Team playOneGame = BaseMain.playOneGame(str, str2, s, generateChallengeFolder + File.separator + BaseMain.generateReplayFileName(str, str2, s) + ".txt", str, str2, false, System.currentTimeMillis());
            if (playOneGame != null) {
                enumMap.put(playOneGame, enumMap.get(playOneGame) + 1);
                System.out.println(str + " vs " + str2 + " at " + s + " with seed " + CustomRandom.getInstance().getSeed() + ". Winner: " + playOneGame);
            }
            else {
                System.err.println(str + " vs " + str2 + " at " + s + ". Error.");
            }
            final Team playOneGame2 = BaseMain.playOneGame(str2, str, s, generateChallengeFolder + File.separator + BaseMain.generateReplayFileName(str2, str, s) + ".txt", str2, str, false, System.currentTimeMillis());
            if (playOneGame2 != null) {
                final Team opponent = playOneGame2.getOpponent();
                enumMap.put(opponent, enumMap.get(opponent) + 1);
                System.out.println(str2 + " vs " + str + " at " + s + " with seed " + CustomRandom.getInstance().getSeed() + ". Winner: " + opponent);
            }
            else {
                System.err.println(str2 + " vs " + str + " at " + s + ". Error.");
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total victories " + str + ": " + enumMap.get(Team.A));
        System.out.println("Total victories " + str2 + ": " + enumMap.get(Team.B));
    }
    
    private static String generateChallengeFolder(final String s, final String s2) {
        final String string = MainChallenge.challengesDirectory + File.separator + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + "-" + BaseMain.formatPlayerName(s) + "-" + BaseMain.formatPlayerName(s2);
        new File(string).mkdirs();
        return string;
    }
}
