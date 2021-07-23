# Benuamin Chappell
# Technology Class

from enum import Enum
from constants import *

class Technology(Enum):
    DOMESTICATION = 0
    MILITARY_TRAINING = 1
    BOXES = 2
    RAFTS = 3
    ROCK_ART = 4
    COIN = 5
    UTENSILS = 6
    SHARPENERS = 7
    COOKING = 8
    EUGENICS = 9
    NAVIGATION = 10
    JOBS = 11
    OIL = 12
    VOCABULARY = 13
    HUTS = 14
    TACTICS = 15
    CRYSTALS = 16
    COMBUSTION = 17
    SCHOOLS = 18
    POISON = 19
    EXPERTISE = 20
    FLINT = 21
    HOUSES = 22
    WHEEL = 23

    def get_level_required(tech):
        return TECHNOLOGY_LEVEL_REQUIRED[tech]
    
    def get_food_cost(tech): return TECHNOLOGY_FOOD_COSTS[tech]
    def get_wood_cost(tech): return TECHNOLOGY_WOOD_COSTS[tech]
    def get_stone_cost(tech): return TECHNOLOGY_STONE_COSTS[tech]