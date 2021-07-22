// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.tournament;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import aic2021.user.Team;
import java.util.List;

public class TournamentCreator
{
    private static final TournamentPlayer BYE;
    
    public static void RunDoubleEliminationTournament(final String s, List<TournamentPlayer> subList, final List<String> list) {
        final TournamentMatch finalMatch = TournamentMatch.FinalMatch(TournamentBracketType.Winners);
        final TournamentMatch winnersMatch = TournamentMatch.WinnersMatch(finalMatch, Team.A, finalMatch, Team.B);
        final TournamentMatch losersMatch = TournamentMatch.LosersMatch(winnersMatch, Team.B);
        final TournamentMatch winnersMatch2 = TournamentMatch.WinnersMatch(winnersMatch, Team.A, losersMatch, Team.A);
        final TournamentMatch losersMatch2 = TournamentMatch.LosersMatch(losersMatch, Team.B);
        final TournamentMatch losersMatch3 = TournamentMatch.LosersMatch(losersMatch2, Team.A);
        final TournamentMatch losersMatch4 = TournamentMatch.LosersMatch(losersMatch2, Team.B);
        final TournamentMatch winnersMatch3 = TournamentMatch.WinnersMatch(winnersMatch2, Team.A, losersMatch4, Team.A);
        final TournamentMatch winnersMatch4 = TournamentMatch.WinnersMatch(winnersMatch2, Team.B, losersMatch3, Team.A);
        final TournamentMatch losersMatch5 = TournamentMatch.LosersMatch(losersMatch3, Team.B);
        final TournamentMatch losersMatch6 = TournamentMatch.LosersMatch(losersMatch4, Team.B);
        final TournamentMatch losersMatch7 = TournamentMatch.LosersMatch(losersMatch5, Team.A);
        final TournamentMatch losersMatch8 = TournamentMatch.LosersMatch(losersMatch5, Team.B);
        final TournamentMatch losersMatch9 = TournamentMatch.LosersMatch(losersMatch6, Team.A);
        final TournamentMatch losersMatch10 = TournamentMatch.LosersMatch(losersMatch6, Team.B);
        final TournamentMatch winnersMatch5 = TournamentMatch.WinnersMatch(winnersMatch3, Team.A, losersMatch8, Team.A);
        final TournamentMatch winnersMatch6 = TournamentMatch.WinnersMatch(winnersMatch3, Team.B, losersMatch7, Team.A);
        final TournamentMatch winnersMatch7 = TournamentMatch.WinnersMatch(winnersMatch4, Team.A, losersMatch10, Team.A);
        final TournamentMatch winnersMatch8 = TournamentMatch.WinnersMatch(winnersMatch4, Team.B, losersMatch9, Team.A);
        final TournamentMatch losersMatch11 = TournamentMatch.LosersMatch(losersMatch7, Team.B);
        final TournamentMatch losersMatch12 = TournamentMatch.LosersMatch(losersMatch8, Team.B);
        final TournamentMatch losersMatch13 = TournamentMatch.LosersMatch(losersMatch9, Team.B);
        final TournamentMatch losersMatch14 = TournamentMatch.LosersMatch(losersMatch10, Team.B);
        final TournamentMatch losersMatch15 = TournamentMatch.LosersMatch(losersMatch11, Team.A);
        final TournamentMatch losersMatch16 = TournamentMatch.LosersMatch(losersMatch11, Team.B);
        final TournamentMatch losersMatch17 = TournamentMatch.LosersMatch(losersMatch12, Team.A);
        final TournamentMatch losersMatch18 = TournamentMatch.LosersMatch(losersMatch12, Team.B);
        final TournamentMatch losersMatch19 = TournamentMatch.LosersMatch(losersMatch13, Team.A);
        final TournamentMatch losersMatch20 = TournamentMatch.LosersMatch(losersMatch13, Team.B);
        final TournamentMatch losersMatch21 = TournamentMatch.LosersMatch(losersMatch14, Team.A);
        final TournamentMatch losersMatch22 = TournamentMatch.LosersMatch(losersMatch14, Team.B);
        final TournamentMatch winnersMatch9 = TournamentMatch.WinnersMatch(winnersMatch5, Team.A, losersMatch22, Team.A);
        final TournamentMatch winnersMatch10 = TournamentMatch.WinnersMatch(winnersMatch5, Team.B, losersMatch21, Team.A);
        final TournamentMatch winnersMatch11 = TournamentMatch.WinnersMatch(winnersMatch6, Team.A, losersMatch20, Team.A);
        final TournamentMatch winnersMatch12 = TournamentMatch.WinnersMatch(winnersMatch6, Team.B, losersMatch19, Team.A);
        final TournamentMatch winnersMatch13 = TournamentMatch.WinnersMatch(winnersMatch7, Team.A, losersMatch18, Team.A);
        final TournamentMatch winnersMatch14 = TournamentMatch.WinnersMatch(winnersMatch7, Team.B, losersMatch17, Team.A);
        final TournamentMatch winnersMatch15 = TournamentMatch.WinnersMatch(winnersMatch8, Team.A, losersMatch16, Team.A);
        final TournamentMatch winnersMatch16 = TournamentMatch.WinnersMatch(winnersMatch8, Team.B, losersMatch15, Team.A);
        final TournamentMatch losersMatch23 = TournamentMatch.LosersMatch(losersMatch15, Team.B);
        final TournamentMatch losersMatch24 = TournamentMatch.LosersMatch(losersMatch16, Team.B);
        final TournamentMatch losersMatch25 = TournamentMatch.LosersMatch(losersMatch17, Team.B);
        final TournamentMatch losersMatch26 = TournamentMatch.LosersMatch(losersMatch18, Team.B);
        final TournamentMatch losersMatch27 = TournamentMatch.LosersMatch(losersMatch19, Team.B);
        final TournamentMatch losersMatch28 = TournamentMatch.LosersMatch(losersMatch20, Team.B);
        final TournamentMatch losersMatch29 = TournamentMatch.LosersMatch(losersMatch21, Team.B);
        final TournamentMatch losersMatch30 = TournamentMatch.LosersMatch(losersMatch22, Team.B);
        final TournamentMatch winnersMatch17 = TournamentMatch.WinnersMatch(winnersMatch9, Team.A, losersMatch23, Team.A);
        final TournamentMatch winnersMatch18 = TournamentMatch.WinnersMatch(winnersMatch9, Team.B, losersMatch23, Team.B);
        final TournamentMatch winnersMatch19 = TournamentMatch.WinnersMatch(winnersMatch10, Team.A, losersMatch24, Team.A);
        final TournamentMatch winnersMatch20 = TournamentMatch.WinnersMatch(winnersMatch10, Team.B, losersMatch24, Team.B);
        final TournamentMatch winnersMatch21 = TournamentMatch.WinnersMatch(winnersMatch11, Team.A, losersMatch25, Team.A);
        final TournamentMatch winnersMatch22 = TournamentMatch.WinnersMatch(winnersMatch11, Team.B, losersMatch25, Team.B);
        final TournamentMatch winnersMatch23 = TournamentMatch.WinnersMatch(winnersMatch12, Team.A, losersMatch26, Team.A);
        final TournamentMatch winnersMatch24 = TournamentMatch.WinnersMatch(winnersMatch12, Team.B, losersMatch26, Team.B);
        final TournamentMatch winnersMatch25 = TournamentMatch.WinnersMatch(winnersMatch13, Team.A, losersMatch27, Team.A);
        final TournamentMatch winnersMatch26 = TournamentMatch.WinnersMatch(winnersMatch13, Team.B, losersMatch27, Team.B);
        final TournamentMatch winnersMatch27 = TournamentMatch.WinnersMatch(winnersMatch14, Team.A, losersMatch28, Team.A);
        final TournamentMatch winnersMatch28 = TournamentMatch.WinnersMatch(winnersMatch14, Team.B, losersMatch28, Team.B);
        final TournamentMatch winnersMatch29 = TournamentMatch.WinnersMatch(winnersMatch15, Team.A, losersMatch29, Team.A);
        final TournamentMatch winnersMatch30 = TournamentMatch.WinnersMatch(winnersMatch15, Team.B, losersMatch29, Team.B);
        final TournamentMatch winnersMatch31 = TournamentMatch.WinnersMatch(winnersMatch16, Team.A, losersMatch30, Team.A);
        final TournamentMatch winnersMatch32 = TournamentMatch.WinnersMatch(winnersMatch16, Team.B, losersMatch30, Team.B);
        int n = 0;
        final TournamentRound tournamentRound = new TournamentRound(TournamentBracketType.Winners, ++n, new TournamentMatch[] { winnersMatch17, winnersMatch18, winnersMatch19, winnersMatch20, winnersMatch21, winnersMatch22, winnersMatch23, winnersMatch24, winnersMatch25, winnersMatch26, winnersMatch27, winnersMatch28, winnersMatch29, winnersMatch30, winnersMatch31, winnersMatch32 });
        final TournamentRound tournamentRound2 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch23, losersMatch24, losersMatch25, losersMatch26, losersMatch27, losersMatch28, losersMatch29, losersMatch30 });
        final TournamentRound tournamentRound3 = new TournamentRound(TournamentBracketType.Winners, n, new TournamentMatch[] { winnersMatch9, winnersMatch10, winnersMatch11, winnersMatch12, winnersMatch13, winnersMatch14, winnersMatch15, winnersMatch16 });
        final TournamentRound tournamentRound4 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch15, losersMatch16, losersMatch17, losersMatch18, losersMatch19, losersMatch20, losersMatch21, losersMatch22 });
        final TournamentRound tournamentRound5 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch11, losersMatch12, losersMatch13, losersMatch14 });
        final TournamentRound tournamentRound6 = new TournamentRound(TournamentBracketType.Winners, n, new TournamentMatch[] { winnersMatch5, winnersMatch6, winnersMatch7, winnersMatch8 });
        final TournamentRound tournamentRound7 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch7, losersMatch8, losersMatch9, losersMatch10 });
        final TournamentRound tournamentRound8 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch5, losersMatch6 });
        final TournamentRound tournamentRound9 = new TournamentRound(TournamentBracketType.Winners, n, new TournamentMatch[] { winnersMatch3, winnersMatch4 });
        final TournamentRound tournamentRound10 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch3, losersMatch4 });
        final TournamentRound tournamentRound11 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch2 });
        final TournamentRound tournamentRound12 = new TournamentRound(TournamentBracketType.Winners, n, new TournamentMatch[] { winnersMatch2 });
        final TournamentRound tournamentRound13 = new TournamentRound(TournamentBracketType.Losers, ++n, new TournamentMatch[] { losersMatch });
        final TournamentRound tournamentRound14 = new TournamentRound(TournamentBracketType.Winners, ++n, new TournamentMatch[] { winnersMatch });
        final TournamentRound tournamentRound15 = new TournamentRound(TournamentBracketType.Winners, ++n, new TournamentMatch[] { finalMatch });
        final int i = n * 3;
        if (i > list.size()) {
            System.err.println("To run the tournament, we need at least " + i + " maps, but there are only " + list.size() + " in the tournament data file.");
            return;
        }
        final ArrayList list2 = new ArrayList<TournamentRound>(Arrays.asList(tournamentRound, tournamentRound2, tournamentRound3, tournamentRound4, tournamentRound5, tournamentRound6, tournamentRound7, tournamentRound8, tournamentRound9, tournamentRound10, tournamentRound11, tournamentRound12, tournamentRound13, tournamentRound14, tournamentRound15));
        if (subList.size() > 32) {
            System.out.println("Warning: created tournament with " + subList.size() + " players, but the maximum is " + 32);
            subList = subList.subList(0, 32);
        }
        while (subList.size() < 32) {
            subList.add(TournamentCreator.BYE);
        }
        final ArrayList list3 = new ArrayList<TournamentMatch>(Arrays.asList(winnersMatch17, winnersMatch25, winnersMatch29, winnersMatch21, winnersMatch23, winnersMatch31, winnersMatch27, winnersMatch19, winnersMatch20, winnersMatch28, winnersMatch32, winnersMatch24, winnersMatch22, winnersMatch30, winnersMatch26, winnersMatch18));
        for (int j = 0; j < list3.size(); ++j) {
            list3.get(j).SetPlayerName(subList.get(j), Team.A);
            list3.get(j).SetPlayerName(subList.get(subList.size() - 1 - j), Team.B);
        }
        new Tournament(s, "Doubles", list, (ArrayList<TournamentRound>)list2);
    }
    
    private static TournamentRound CreateSingleElimRound(final TournamentRound tournamentRound, final int n) {
        if (tournamentRound == null) {
            return new TournamentRound(TournamentBracketType.Singles, n, new TournamentMatch[] { TournamentMatch.FinalMatch(TournamentBracketType.Singles) });
        }
        final int n2 = tournamentRound.mapSetId - 1;
        final List<TournamentMatch> getMatches = tournamentRound.GetMatches();
        final ArrayList<TournamentMatch> list = new ArrayList<TournamentMatch>();
        for (final TournamentMatch tournamentMatch : getMatches) {
            list.add(TournamentMatch.SinglesMatch(tournamentMatch, Team.A));
            list.add(TournamentMatch.SinglesMatch(tournamentMatch, Team.B));
        }
        return new TournamentRound(TournamentBracketType.Singles, n2, list.toArray(new TournamentMatch[list.size()]));
    }
    
    private static boolean IsPowerOfTwo(final int n) {
        return n > 0 && (n == 1 || (n & n - 1) == 0x0);
    }
    
    public static void RunSingleEliminationTournament(final String s, List<TournamentPlayer> subList, final List<String> list) {
        if (subList.size() > 128) {
            System.out.println("Warning: created tournament with " + subList.size() + " players, but the maximum is " + 128);
            subList = subList.subList(0, 128);
        }
        while (!IsPowerOfTwo(subList.size())) {
            subList.add(TournamentCreator.BYE);
        }
        int n = 0;
        for (int i = subList.size(); i > 1; i /= 2, ++n) {}
        final int j = n * 3;
        if (j > list.size()) {
            System.err.println("To run the tournament, we need at least " + j + " maps, but there are only " + list.size() + " in the tournament data file.");
            return;
        }
        final ArrayList list2 = new ArrayList<TournamentRound>();
        for (int k = 0; k < n; ++k) {
            list2.add(0, CreateSingleElimRound(list2.isEmpty() ? null : list2.get(0), n));
        }
        final ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        for (int l = 0; l < n; ++l) {
            final int size = list3.size();
            for (int index = size - 1; index >= 0; --index) {
                list3.add(index + 1, 2 * size + 1 - list3.get(index));
            }
        }
        final List<TournamentMatch> getMatches = list2.get(0).GetMatches();
        for (int n2 = 0; n2 < getMatches.size(); ++n2) {
            final TournamentMatch tournamentMatch = getMatches.get(n2);
            tournamentMatch.SetPlayerName(subList.get(list3.get(2 * n2) - 1), Team.A);
            tournamentMatch.SetPlayerName(subList.get(list3.get(2 * n2 + 1) - 1), Team.B);
        }
        new Tournament(s, "Singles", list, list2);
    }
    
    static {
        BYE = new TournamentPlayer("BYE", "BYE");
    }
}
