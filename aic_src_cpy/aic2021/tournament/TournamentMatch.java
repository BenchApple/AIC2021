// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.tournament;

import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import aic2021.engine.Game;
import java.io.File;
import aic2021.user.Team;

class TournamentMatch
{
    private TournamentBracketType bracketType;
    private TeamAndMatch winnersMatch;
    private TeamAndMatch losersMatch;
    private int roundId;
    private int matchId;
    private String matchFolderPath;
    private TournamentMatchPlayer teamA;
    private TournamentMatchPlayer teamB;
    private Team winner;
    
    private TournamentMatch(final TournamentBracketType bracketType) {
        this.bracketType = bracketType;
        this.roundId = 0;
        this.matchId = 0;
        this.teamA = new TournamentMatchPlayer(Team.A);
        this.teamB = new TournamentMatchPlayer(Team.B);
        this.winnersMatch = null;
        this.losersMatch = null;
        this.winner = null;
    }
    
    static TournamentMatch FinalMatch(final TournamentBracketType tournamentBracketType) {
        return new TournamentMatch(tournamentBracketType);
    }
    
    static TournamentMatch SinglesMatch(final TournamentMatch tournamentMatch, final Team team) {
        final TournamentMatch tournamentMatch2 = new TournamentMatch(TournamentBracketType.Singles);
        tournamentMatch2.winnersMatch = new TeamAndMatch(tournamentMatch, team);
        return tournamentMatch2;
    }
    
    static TournamentMatch LosersMatch(final TournamentMatch tournamentMatch, final Team team) {
        final TournamentMatch tournamentMatch2 = new TournamentMatch(TournamentBracketType.Losers);
        tournamentMatch2.winnersMatch = new TeamAndMatch(tournamentMatch, team);
        return tournamentMatch2;
    }
    
    static TournamentMatch WinnersMatch(final TournamentMatch tournamentMatch, final Team team, final TournamentMatch tournamentMatch2, final Team team2) {
        final TournamentMatch tournamentMatch3 = new TournamentMatch(TournamentBracketType.Winners);
        tournamentMatch3.winnersMatch = new TeamAndMatch(tournamentMatch, team);
        tournamentMatch3.losersMatch = new TeamAndMatch(tournamentMatch2, team2);
        return tournamentMatch3;
    }
    
    boolean HasByes() {
        return this.teamA.IsBye() || this.teamB.IsBye();
    }
    
    boolean IsPlayable() {
        return !this.HasByes();
    }
    
    private TournamentMatchPlayer GetPlayer(final Team team) {
        return (team == Team.A) ? this.teamA : this.teamB;
    }
    
    String GetShortName() {
        return this.bracketType.shortName + this.roundId + "-" + this.matchId;
    }
    
    int GetId() {
        return this.matchId;
    }
    
    void AdvancePlayersAgainstByes() {
        this.ResetScore();
        if (this.teamA.IsBye()) {
            this.SetAsWinner(this.teamB);
            this.SetAsLoser(this.teamA);
        }
        else if (this.teamB.IsBye()) {
            this.SetAsWinner(this.teamA);
            this.SetAsLoser(this.teamB);
        }
    }
    
    void SkipGamesWithByes() {
        while (this.winnersMatch != null && this.winnersMatch.match.HasByes()) {
            this.winnersMatch = this.winnersMatch.match.winnersMatch;
        }
        while (this.losersMatch != null && this.losersMatch.match.HasByes()) {
            this.losersMatch = this.losersMatch.match.winnersMatch;
        }
    }
    
    void SetPlayerName(final TournamentPlayer tournamentPlayer, final Team team) {
        this.GetPlayer(team).SetName(tournamentPlayer);
    }
    
    private void SetTeamTempName(final String s, final Team team) {
        this.GetPlayer(team).SetTempName(s);
    }
    
    void SetSuccessorsTempNames() {
        if (this.HasByes()) {
            return;
        }
        if (this.winnersMatch != null && this.bracketType != this.winnersMatch.match.bracketType) {
            this.winnersMatch.match.SetTeamTempName("Winner of " + this.GetShortName(), this.winnersMatch.team);
        }
        if (this.losersMatch != null && this.bracketType != this.losersMatch.match.bracketType) {
            this.losersMatch.match.SetTeamTempName("Loser of " + this.GetShortName(), this.losersMatch.team);
        }
    }
    
    void SetRoundAndMatchId(final int roundId, final int matchId) {
        this.roundId = roundId;
        this.matchId = matchId;
    }
    
    void SetFolderPath(final String matchFolderPath) {
        this.matchFolderPath = matchFolderPath;
    }
    
    private void ResetScore() {
        this.teamA.ResetScore();
        this.teamB.ResetScore();
    }
    
    private Team PlaySingleGame(final int i, final String str) {
        final String string = "Game" + i + "-" + this.teamA.GetNameForFile() + "_vs_" + this.teamB.GetNameForFile() + "-" + str;
        Team team;
        try {
            System.out.println("Playing match " + this.GetShortName() + ", game " + i);
            new StringBuilder().append((this.bracketType == TournamentBracketType.Singles) ? "" : (this.bracketType.fullName + " ")).append("Round ").append(this.roundId).append(" - Match ").append(this.matchId).append(" - Game ").append(i).toString();
            final Game game = new Game(this.teamA.GetPackageName(), this.teamB.GetPackageName(), str, this.matchFolderPath + File.separator + string + ".txt", this.teamA.GetDisplayName(), this.teamB.GetDisplayName(), false, System.currentTimeMillis());
            game.start();
            game.join();
            team = game.getWinner();
        }
        catch (Exception ex) {
            System.out.println("Exception while playing game. Will set Team A as winner.");
            team = Team.A;
            ex.printStackTrace();
        }
        return team;
    }
    
    private void SetAsWinner(final TournamentMatchPlayer tournamentMatchPlayer) {
        this.winner = tournamentMatchPlayer.GetTeam();
        if (this.winnersMatch != null) {
            this.winnersMatch.match.SetPlayerName(tournamentMatchPlayer.GetPlayer(), this.winnersMatch.team);
        }
    }
    
    private void SetAsLoser(final TournamentMatchPlayer tournamentMatchPlayer) {
        if (this.losersMatch != null) {
            this.losersMatch.match.SetPlayerName(tournamentMatchPlayer.GetPlayer(), this.losersMatch.team);
        }
    }
    
    void PlayMatch(final List<String> list) {
        this.ResetScore();
        if (this.HasByes()) {
            return;
        }
        final ArrayList<Team> list2 = new ArrayList<Team>();
        int n = 0;
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(this.PlaySingleGame(++n, iterator.next()));
        }
        final Iterator<Team> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            this.GetPlayer(iterator2.next()).IncrementScore();
            if (this.teamA.GetScore() > list.size() / 2) {
                this.SetAsWinner(this.teamA);
                this.SetAsLoser(this.teamB);
                break;
            }
            if (this.teamB.GetScore() > list.size() / 2) {
                this.SetAsWinner(this.teamB);
                this.SetAsLoser(this.teamA);
                break;
            }
        }
    }
    
    public void WriteMatchDataToFile() {
        final String string = this.matchFolderPath + File.separator + "match_data.txt";
        try {
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(string));
            bufferedWriter.write(this.teamA.GetDisplayName() + System.lineSeparator());
            bufferedWriter.write(this.teamA.GetScore() + System.lineSeparator());
            bufferedWriter.write(this.teamA.GetTempName() + System.lineSeparator());
            bufferedWriter.write(this.teamB.GetDisplayName() + System.lineSeparator());
            bufferedWriter.write(this.teamB.GetScore() + System.lineSeparator());
            bufferedWriter.write(this.teamB.GetTempName() + System.lineSeparator());
            String string2 = "W";
            if (this.winnersMatch != null) {
                string2 = string2 + " " + this.winnersMatch.match.bracketType.shortName + " " + this.winnersMatch.match.roundId + " " + this.winnersMatch.match.matchId + " " + this.winnersMatch.team;
            }
            bufferedWriter.write(string2 + System.lineSeparator());
            String string3 = "L";
            if (this.losersMatch != null) {
                string3 = string3 + " " + this.losersMatch.match.bracketType.shortName + " " + this.losersMatch.match.roundId + " " + this.losersMatch.match.matchId + " " + this.losersMatch.team;
            }
            bufferedWriter.write(string3 + System.lineSeparator());
            bufferedWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Could not write tournament data to file");
        }
    }
    
    @Override
    public String toString() {
        return "  - Match " + this.GetShortName() + ": " + this.teamA + " vs " + this.teamB + ". Winner: " + this.winner + "\n";
    }
    
    private static class TeamAndMatch
    {
        public final Team team;
        final TournamentMatch match;
        
        TeamAndMatch(final TournamentMatch match, final Team team) {
            this.match = match;
            this.team = team;
        }
    }
}
