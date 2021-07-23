# Benjamin Chappell

from enum import Enum

class Team(Enum):
    A = 0
    B = 1
    NEUTRAL = 2

    def get_opponent(team):
        if team == Team.A:
            return Team.B
        elif team == Team.B:
            return Team.A
        return None