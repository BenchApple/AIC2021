# Benjamin Chappell
# This is the world class that the fuckers made

from map_reader import MapReader
from team_info import TeamInfo
from team import Team

class World:
    def __init__(self, mapfile, teamA_name, teamB_name) -> None:
        self.map_reader = MapReader()
        self.map_reader.load_map(self, mapfile)
        self.grid = self.map_reader.get_map()
        self.starting_loc_A = self.map_reader.get_location_A()
        self.starting_loc_B = self.map_reader.get_location_B()

        self.teamA_info = TeamInfo(Team.A, self.starting_loc_A, teamA_name) 
        self.teamB_info = TeamInfo(Team.B, self.starting_loc_B, teamB_name) 
        self.dummy_info = TeamInfo(Team.NEUTRAL, GameLocation(0, 0), "Neutral") # TODO implement gamelocation

        self.symmetry = self.map_reader.get_symmetry()
        self.nUnits = [0, 0, 0]

        self.winner = None
        self.win_condition = None
        self.round = -1
        self.unitID = 0
        self.directions = 

        self.initial_check()
