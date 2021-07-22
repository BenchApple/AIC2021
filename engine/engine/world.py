# Benjamin Chappell
# This is the world class that the fuckers made

from map_reader import MapReader
from team_info import TeamInfo

class World:
    def __init__(self, mapfile, teamA_name, teamB_name) -> None:
        self.map_reader = MapReader()
        self.map_reader.load_map(self, mapfile)
        self.grid = self.map_reader.get_map()
        self.starting_loc_A = self.map_reader.get_location_A()
        self.starting_loc_B = self.map_reader.get_location_B()

        # TODO implement the Team enum class thingie
        self.teamA_info = TeamInfo() # TODO fill this in with the proper parameters