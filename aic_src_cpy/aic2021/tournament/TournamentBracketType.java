// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.tournament;

enum TournamentBracketType
{
    Winners("Winners", "W"), 
    Losers("Losers", "L"), 
    Singles("Round", "R");
    
    String fullName;
    String shortName;
    
    private TournamentBracketType(final String fullName, final String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }
}
