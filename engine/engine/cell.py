# Benjamin Chappell

from constants import * 
from random import randint
from technology import Technology

class Cell:
    def __init__(self, _world, _location) -> None:
        self.unit = None
        self.world = _world
        self.location = _location
        self.resources = [0, 0, 0]
        self.mountain = False
        self.water = False
        self.fire_rounds = 0
        self.fire_intensity = 0
        self.has_trap = 0
        self.checked = False
        self.rock_art_num = 0

        # Needs stuff to deal with luminosity because I don't fully understand that yet
        # TODO luminosity
    
    def get_opacity(self):
        if self.mountain:
            return 0
        elif self.resources[WOOD] > 0:
            return 2
        else:
            return 1
    
    # TODO luminosity calculations
    def get_luminosity(self):
        return randint(0, 100) # TODO make this right

    def set_rock_art_num(self, n):
        self.rock_art_num = n
    
    def get_rock_art_num(self):
        return self.rock_art_num
    
    def add_mountain(self): self.mountain = True
    def has_mountain(self): return self.mountain

    def add_water(self): self.water = True
    def has_water(self): return self.water

    def put_fire(self, rounds, intensity):
        has_no_fire = self.fire_intensity == 0
        self.fire_rounds = rounds
        self.fire_intensity = intensity
        if has_no_fire:
            # TODO illumination
            pass
    def has_fire(self): return self.fire_intensity > 0

    def set_trap(self, has_trap): self.trap = has_trap
    def add_trap(self): self.set_trap(True)
    def remove_trap(self): self.set_trap(False)
    def has_trap(self): return self.trap

    def get_location(self): return self.location

    def add_resource(self, resource, amount): self.resources[resource] = amount

    # Updates this cell
    def check(self):
        self.resources[FOOD] -= 2
        if self.resources[FOOD] < 0:
            self.resources[FOOD] = 0

        self.fire_rounds -= 1
        if self.fire_rounds < 0: self.fire_rounds = 0

        if self.fire_rounds == 0 and self.fire_intensity > 0:
            # TODO Remove source of light from the world
            self.fire_intensity = 0
        
        deer_spawn = randint(0, 1000)
        if self.get_luminosity() <= 6 and deer_spawn == 333 and self.is_accessible(DEER, None):
            # TODO Put a deer in this location
            pass
    
    def hit(self, attacker):
        attack = attacker.get_attack() # TODO make sure to implement the stuff that applies to this
        if self.unit != None:
            self.unit.receive_damage(attack, attacker.get_team_info()) # TODO Implement Unit class

    def is_passable(self, unit, team):
        if self.mountain:
            return False
        elif not self.water:
            return True
        else:
            return team != None and team.has_tech(Technology.RAFTS) # TODO implement teams

    def get_unit(self): return self.unit
    def set_unit(self, unit): self.unit = unit

    def is_accessible(self, unit, team):
        return self.is_passable(unit, team) and self.unit == None
    
    def gather(self, unit):
        gatherable = self.resources[WOOD] > 0

        for i in range(0, 3):
            if self.resources[i] > 0:
                max_gatherable = 100
                if unit.get_team_info().has_tech(Technology.BOXES): # TODO implement get team info and TeamInfo objects
                    max_gatherable = 200

                can_gather = RESOURCES_WORKER_ROUND
                if unit.get_team_info().has_tech(Technology.UTENSILS):
                    can_gather = RESOURCES_WORKER_ROUND_UTENSILS

                amnt = min(can_gather, self.resources[i])
                amnt = min(amnt, max_gatherable - unit.get_resource(i))
                if amnt >= 0:
                    self.resources[i] = self.resources[i] - amnt
                    unit.add_resource(i, amnt)
        
        wood_left = self.resources[WOOD] > 0
        if gatherable and not wood_left:
            # Recalculate the illumincation on this square TODO
            pass

    def get_resource(self, resource):
        if self.resources[resource] > 0:
            return (resource, self.resources[resource], self.location)
        else: 
            return None
        
    def get_fire_info(self):
        if self.has_fire():
            return (self.fire_rounds, self.fire_intensity, self.location)

    def get_food_info(self): return self.get_resource(FOOD)
    def get_wood_info(self): return self.get_resource(WOOD)
    def get_stone_info(self): return self.get_resource(STONE)

    def get_resources(self):
        r = [self.resources[0], self.resources[1], self.resources[2]]

    def is_obstructed(self): return self.mountain

    rock_art_num = property(get_rock_art_num, set_rock_art_num)     
    unit = property(get_unit, set_unit)