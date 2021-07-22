# Benjamin Chappell
# Mimics the team_info class
# TODO finish this file

from constants import *
from technology import Technology

class TeamInfo:
    def __init__(self, team, starting_loc, team_name) -> None:
        self.team = team
        self.resources = [100, 100, 100]
        self.team_name = team_name
        self.initial_location = starting_loc
        self.opponent = team.get_opponent()
        self.tech_level = 0
        self.max_level_techs = 0

        self.techs = [False for i in range(0, Technology.WHEEL)]
    
    def get_team_name(self): return self.team_name
    def get_team(self): return self.team

    def add_resources(self, new_resources):
        self.resources = [self.resources[0] + new_resources[0], 
                          self.resources[1] + new_resources[1], 
                          self.resources[2] + new_resources[2]]
    
    def add_resource(self, amount, resource):
        self.resources[resource] = self.resources[resource] + amount
    
    def has_resource(self, amount, resource):
        return self.resources[resource] >= amount
    
    def get_total_resources(self):
        return sum(self.resources)
    
    def get_tech_level(self): return self.tech_level
    def get_n_techs(self): return sum(self.techs)
    def has_tech(self, tech): return self.techs[tech]

    def research_tech(self, tech):
        self.techs[tech] = True

        if tech.get_level_required() == self.tech_level:
            self.max_level_techs = self.max_level_techs + 1

            if self.max_level_techs >= 3:
                self.max_level_techs = 0
                self.tech_level += 1
        
        # TODO COmplete Technology Class
        if tech == Technology.SCHOOLS:
            self.tech_level = 3

    def get_tech_costs(self):
        pass
        # I don't see the value of this function but if it's deemed neccesary later on I'll implement it
        # TODO See if this method is used anywhere