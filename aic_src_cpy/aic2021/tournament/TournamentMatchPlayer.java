// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.tournament;

import aic2021.user.Team;

class TournamentMatchPlayer
{
    private final Team team;
    private TournamentPlayer name;
    private String tempName;
    private int score;
    private static final TournamentPlayer TBD;
    private static final TournamentPlayer BYE;
    
    TournamentMatchPlayer(final Team team) {
        this.tempName = "";
        this.team = team;
        this.SetName(TournamentMatchPlayer.TBD);
        this.score = 0;
    }
    
    Team GetTeam() {
        return this.team;
    }
    
    TournamentPlayer GetPlayer() {
        return this.name;
    }
    
    String GetDisplayName() {
        return this.name.displayName;
    }
    
    String GetPackageName() {
        return this.name.packageName;
    }
    
    String GetTempName() {
        return this.tempName;
    }
    
    String GetNameForFile() {
        return this.GetDisplayName().replace(' ', '_');
    }
    
    void SetName(final TournamentPlayer name) {
        this.name = name;
    }
    
    public void SetTempName(final String tempName) {
        this.tempName = tempName;
    }
    
    boolean IsBye() {
        return this.name.displayName.equals(TournamentMatchPlayer.BYE.displayName);
    }
    
    int GetScore() {
        return this.score;
    }
    
    void IncrementScore() {
        ++this.score;
    }
    
    void ResetScore() {
        this.score = 0;
    }
    
    @Override
    public String toString() {
        if (this.team == Team.A) {
            return this.name + " " + this.score;
        }
        return this.score + " " + this.name;
    }
    
    static {
        TBD = new TournamentPlayer("TBD", "TBD");
        BYE = new TournamentPlayer("BYE", "BYE");
    }
}
