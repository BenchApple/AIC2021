// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.tournament;

import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class TournamentRound
{
    private final ArrayList<TournamentMatch> matches;
    private TournamentBracketType bracketType;
    private int currentMatchToPlay;
    final int mapSetId;
    String roundFolderPath;
    private List<String> mapNames;
    private int roundId;
    private static final boolean DEBUG = false;
    
    TournamentRound(final TournamentBracketType bracketType, final int mapSetId, final TournamentMatch[] a) {
        this.currentMatchToPlay = 0;
        this.bracketType = bracketType;
        this.matches = new ArrayList<TournamentMatch>(Arrays.asList(a));
        this.mapSetId = mapSetId;
    }
    
    TournamentBracketType GetBracketType() {
        return this.bracketType;
    }
    
    List<TournamentMatch> GetMatches() {
        return this.matches;
    }
    
    int GetRoundId() {
        return this.roundId;
    }
    
    String GetLongName() {
        return this.bracketType.fullName + " " + this.roundId;
    }
    
    String GetShortName() {
        return this.bracketType.shortName + this.roundId;
    }
    
    boolean HasAnyMatchWithoutByes() {
        final Iterator<TournamentMatch> iterator = this.matches.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().HasByes()) {
                return true;
            }
        }
        return false;
    }
    
    private boolean IsRoundCompletelyPlayed() {
        return this.currentMatchToPlay == this.matches.size();
    }
    
    TournamentMatch GetMatchToBePlayed() {
        if (this.IsRoundCompletelyPlayed()) {
            return null;
        }
        return this.matches.get(this.currentMatchToPlay);
    }
    
    void SetIdAndMatchIds(final int roundId) {
        this.roundId = roundId;
        int n = 1;
        for (final TournamentMatch tournamentMatch : this.matches) {
            if (!tournamentMatch.HasByes()) {
                tournamentMatch.SetRoundAndMatchId(roundId, n);
                ++n;
            }
        }
    }
    
    void SetMapNames(final List<String> mapNames) {
        this.mapNames = mapNames;
    }
    
    void SetFolderPath(final String roundFolderPath) {
        this.roundFolderPath = roundFolderPath;
    }
    
    boolean IsCurrentMatchPlayable() {
        return !this.IsRoundCompletelyPlayed() && !this.matches.get(this.currentMatchToPlay).HasByes();
    }
    
    boolean MoveToNextMatch() {
        if (!this.IsRoundCompletelyPlayed()) {
            ++this.currentMatchToPlay;
        }
        boolean b;
        boolean b2;
        for (b = this.IsRoundCompletelyPlayed(), b2 = this.IsCurrentMatchPlayable(); !b && !b2; b = this.IsRoundCompletelyPlayed(), b2 = this.IsCurrentMatchPlayable()) {
            ++this.currentMatchToPlay;
        }
        return b2;
    }
    
    private void PlayCurrentMatch() {
        if (!this.IsCurrentMatchPlayable() && !this.MoveToNextMatch()) {
            return;
        }
        this.matches.get(this.currentMatchToPlay).PlayMatch(this.mapNames);
    }
    
    boolean PlayRound() {
        boolean b = false;
        if (this.IsCurrentMatchPlayable()) {
            this.PlayCurrentMatch();
            b = true;
        }
        while (this.MoveToNextMatch()) {
            this.PlayCurrentMatch();
            b = true;
        }
        return b;
    }
    
    public void WriteRoundDataToFile() {
        final String string = this.roundFolderPath + File.separator + "round_data.txt";
        try {
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(string));
            final Iterator<TournamentMatch> iterator = this.matches.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().HasByes()) {
                    bufferedWriter.write("0 ");
                }
                else {
                    bufferedWriter.write("1 ");
                }
            }
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write(this.mapNames.size() + System.lineSeparator());
            final Iterator<String> iterator2 = this.mapNames.iterator();
            while (iterator2.hasNext()) {
                bufferedWriter.write(iterator2.next() + System.lineSeparator());
            }
            bufferedWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Could not write round " + this.GetLongName() + " data to file");
        }
        for (final TournamentMatch tournamentMatch : this.matches) {
            if (!tournamentMatch.HasByes()) {
                tournamentMatch.WriteMatchDataToFile();
            }
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("- Round ").append(this.GetLongName()).append(":\n");
        final Iterator<TournamentMatch> iterator = this.matches.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
