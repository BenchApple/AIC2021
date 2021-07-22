// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.tournament;

import java.util.EnumMap;
import java.util.Iterator;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Tournament
{
    private final String tournamentName;
    private final String tournamentFolderPath;
    private final List<String> maps;
    private final ArrayList<TournamentRound> roundsInPlayingOrder;
    private int currentRound;
    public static final int MAPS_PER_MATCH = 3;
    private static final boolean DEBUG = false;
    
    Tournament(final String tournamentName, final String s, final List<String> maps, final ArrayList<TournamentRound> roundsInPlayingOrder) {
        this.currentRound = 0;
        this.tournamentName = tournamentName;
        this.tournamentFolderPath = this.GenerateTournamentPath();
        this.maps = maps;
        this.roundsInPlayingOrder = roundsInPlayingOrder;
        this.Initialize();
        this.WriteTournamentDataToFile(s);
    }
    
    private String GenerateTournamentPath() {
        String pathname = "Tournaments" + File.separator + this.tournamentName.replace(' ', '_') + "-" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        int i = 0;
        while (new File(pathname).exists()) {
            ++i;
        }
        if (i > 0) {
            pathname = pathname + "_" + i;
        }
        new File(pathname).mkdirs();
        return pathname;
    }
    
    private void WriteTournamentDataToFile(final String str) {
        final String string = this.tournamentFolderPath + File.separator + "tournament_data.txt";
        try {
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(string));
            bufferedWriter.write(this.tournamentName + System.lineSeparator());
            bufferedWriter.write(str + System.lineSeparator());
            int i = 0;
            final StringBuilder sb = new StringBuilder();
            for (final TournamentRound tournamentRound : this.roundsInPlayingOrder) {
                if (tournamentRound.HasAnyMatchWithoutByes()) {
                    ++i;
                    sb.append(tournamentRound.GetBracketType() + " " + tournamentRound.GetRoundId() + System.lineSeparator());
                }
            }
            bufferedWriter.write(i + System.lineSeparator());
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Could not write tournament data to file");
        }
        for (final TournamentRound tournamentRound2 : this.roundsInPlayingOrder) {
            if (tournamentRound2.HasAnyMatchWithoutByes()) {
                tournamentRound2.WriteRoundDataToFile();
            }
        }
    }
    
    private TournamentMatch GetMatchToBePlayed() {
        if (this.currentRound >= this.roundsInPlayingOrder.size()) {
            return null;
        }
        return this.roundsInPlayingOrder.get(this.currentRound).GetMatchToBePlayed();
    }
    
    private void Initialize() {
        this.AdvancePlayersAgainstByes();
        this.SkipGamesWithByes();
        this.SetRoundIds();
        this.SetRoundMaps();
        this.SetMatchTempNames();
        this.CreateReplayFolders();
        final TournamentMatch getMatchToBePlayed = this.GetMatchToBePlayed();
        if (getMatchToBePlayed == null || !getMatchToBePlayed.IsPlayable()) {
            this.MoveToNextMatch();
        }
        this.PlayUntilEnd();
    }
    
    private void AdvancePlayersAgainstByes() {
        final Iterator<TournamentRound> iterator = this.roundsInPlayingOrder.iterator();
        while (iterator.hasNext()) {
            for (final TournamentMatch tournamentMatch : iterator.next().GetMatches()) {
                if (tournamentMatch.HasByes()) {
                    tournamentMatch.AdvancePlayersAgainstByes();
                }
            }
        }
    }
    
    private void SkipGamesWithByes() {
        final Iterator<TournamentRound> iterator = this.roundsInPlayingOrder.iterator();
        while (iterator.hasNext()) {
            final Iterator<TournamentMatch> iterator2 = iterator.next().GetMatches().iterator();
            while (iterator2.hasNext()) {
                iterator2.next().SkipGamesWithByes();
            }
        }
    }
    
    private void SetRoundIds() {
        final EnumMap<TournamentBracketType, Integer> enumMap = new EnumMap<TournamentBracketType, Integer>(TournamentBracketType.class);
        for (final TournamentRound tournamentRound : this.roundsInPlayingOrder) {
            if (tournamentRound.HasAnyMatchWithoutByes()) {
                final TournamentBracketType getBracketType = tournamentRound.GetBracketType();
                enumMap.putIfAbsent(getBracketType, 1);
                final int intValue = enumMap.get(getBracketType);
                tournamentRound.SetIdAndMatchIds(intValue);
                enumMap.put(getBracketType, intValue + 1);
            }
        }
    }
    
    private void SetRoundMaps() {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (final TournamentRound tournamentRound : this.roundsInPlayingOrder) {
            if (!tournamentRound.HasAnyMatchWithoutByes()) {
                continue;
            }
            final int mapSetId = tournamentRound.mapSetId;
            final int n = list.contains(mapSetId) ? list.indexOf(mapSetId) : list.size();
            final int n2 = n * 3;
            final int i = (n + 1) * 3;
            if (i > this.maps.size()) {
                System.out.println("Round " + tournamentRound.GetLongName() + " tried to use map number " + i + " but there are only " + this.maps.size() + " maps in total.");
            }
            else {
                tournamentRound.SetMapNames(this.maps.subList(n2, i));
                if (list.contains(mapSetId)) {
                    continue;
                }
                list.add(mapSetId);
            }
        }
    }
    
    private void SetMatchTempNames() {
        final Iterator<TournamentRound> iterator = this.roundsInPlayingOrder.iterator();
        while (iterator.hasNext()) {
            final Iterator<TournamentMatch> iterator2 = iterator.next().GetMatches().iterator();
            while (iterator2.hasNext()) {
                iterator2.next().SetSuccessorsTempNames();
            }
        }
    }
    
    private void CreateReplayFolders() {
        int n = 0;
        for (final TournamentRound tournamentRound : this.roundsInPlayingOrder) {
            if (tournamentRound.GetRoundId() == 0) {
                continue;
            }
            final String string = this.tournamentFolderPath + File.separator + ++n + "-" + tournamentRound.GetShortName();
            tournamentRound.SetFolderPath(string);
            new File(string).mkdir();
            for (final TournamentMatch tournamentMatch : tournamentRound.GetMatches()) {
                if (tournamentMatch.GetId() == 0) {
                    continue;
                }
                final String string2 = string + File.separator + tournamentMatch.GetShortName();
                new File(string2).mkdir();
                tournamentMatch.SetFolderPath(string2);
            }
        }
    }
    
    private void MoveToNextMatch() {
        while (this.currentRound < this.roundsInPlayingOrder.size() && !this.roundsInPlayingOrder.get(this.currentRound).MoveToNextMatch()) {
            ++this.currentRound;
            if (this.currentRound < this.roundsInPlayingOrder.size() && this.roundsInPlayingOrder.get(this.currentRound).IsCurrentMatchPlayable()) {
                return;
            }
        }
    }
    
    private boolean PlayRound() {
        if (this.currentRound < this.roundsInPlayingOrder.size()) {
            final boolean playRound = this.roundsInPlayingOrder.get(this.currentRound).PlayRound();
            if (playRound) {
                this.MoveToNextMatch();
            }
            return playRound;
        }
        return false;
    }
    
    private void PlayUntilEnd() {
        for (boolean playRound = true; playRound; playRound = this.PlayRound()) {}
    }
}
