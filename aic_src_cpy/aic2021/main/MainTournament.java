// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.main;

import java.io.FileNotFoundException;
import java.util.List;
import aic2021.tournament.TournamentCreator;
import aic2021.tournament.TournamentPlayer;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class MainTournament extends BaseMain
{
    private static final String tournamentDataFile;
    
    public static void main(final String[] array) {
        runTournament();
    }
    
    private static void runTournament() {
        final File source = new File(MainTournament.tournamentDataFile);
        try {
            final Scanner useDelimiter = new Scanner(source).useDelimiter("\\Z");
            final String[] split = useDelimiter.next().split("\\r?\\n");
            int n = 0;
            useDelimiter.close();
            final String s = split[n++];
            final String str = split[n++];
            final int int1 = Integer.parseInt(split[n++]);
            final ArrayList<TournamentPlayer> list = new ArrayList<TournamentPlayer>();
            for (int i = 0; i < int1; ++i) {
                final String s2 = split[n++];
                list.add(new TournamentPlayer(s2.substring(s2.indexOf(32) + 1), s2.substring(0, s2.indexOf(32))));
            }
            final int int2 = Integer.parseInt(split[n++]);
            final ArrayList<String> list2 = new ArrayList<String>();
            for (int j = 0; j < int2; ++j) {
                list2.add(split[n++]);
            }
            final String lowerCase = str.toLowerCase();
            switch (lowerCase) {
                case "singles": {
                    TournamentCreator.RunSingleEliminationTournament(s, list, list2);
                    break;
                }
                case "doubles": {
                    TournamentCreator.RunDoubleEliminationTournament(s, list, list2);
                    break;
                }
                default: {
                    System.err.println("runTournament: Unexpected tournament type: " + str);
                    break;
                }
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Could not find file " + source.getAbsolutePath());
        }
    }
    
    static {
        tournamentDataFile = System.getProperty("user.dir") + File.separator + "tournament_data.txt";
    }
}
