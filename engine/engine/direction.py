# Benjamin Chappell
# Directino class

from enum import Enum

class Direction(Enum):
    NORTH = 0
    NORTHWEST = 1
    WEST = 2
    SOUTHWEST = 3
    SOUTH = 4
    SOUTHEAST = 5
    EAST = 6
    NORTHEAST = 7
    ZERO = 8

    def __init__(self, dx, dy) -> None:
        self.dx = dx
        self.dy = dy
        self.lum_norm = None
        self.norm = None

    def is_equal(self, dir):
        if dir == None:
            return False
        else:
            return dir.dx == self.dx and dir.dy == self.dy

if __name__ == "__main__":
    a = Direction.NORTH