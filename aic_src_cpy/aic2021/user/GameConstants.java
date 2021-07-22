// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public class GameConstants
{
    public static final int MAX_ROUNDS = 2000;
    public static final int INITIAL_FOOD = 100;
    public static final int INITIAL_STONE = 100;
    public static final int INITIAL_WOOD = 100;
    public static final int ADDITIONAL_RESOURCES_COIN = 1;
    public static final int ADDITIONAL_RESOURCES_POISON = -1;
    public static final int FOOD_ROUND = 2;
    public static final int STONE_ROUND = 2;
    public static final int WOOD_ROUND = 2;
    public static final int FARM_PRODUCTION = 1;
    public static final int QUARRY_PRODUCTION = 1;
    public static final int MAX_TOTAL_UNITS = 75;
    public static final int MAX_TOTAL_UNITS_INCREASE_HUTS = 25;
    public static final int MAX_TOTAL_UNITS_INCREASE_HOUSES = 25;
    public static final int TECH_LEVEL_THRESHOLD = 3;
    public static final int MIN_DEER_LUMINOSITY = 6;
    public static final int DETECTION_LEVEL_DECREASE_CRYSTALS = 2;
    public static final int LUMINOUS_INTENSITY_INCREASE_COMBUSTION = 2;
    public static final double DEER_SPAWN_PROBABILITY = 1.0E-4;
    public static final int DEER_FOOD = 500;
    public static final float RESOURCES_RETURNED_TACTICS = 0.2f;
    public static final int FOOD_DECAY = 2;
    public static int RESOURCES_WORKER_ROUND;
    public static int RESOURCES_WORKER_ROUND_UTENSILS;
    public static double ATTACK_RATIO_INCREASE_SHARPENERS;
    public static double ATTACK_COOLDOWN_RATIO_DECREASE_EXPERTISE;
    public static double MAX_HEALTH_RATIO_INCREASE_COOKING;
    public static final int SAWMILL_PRODUCTION = 1;
    public static final int TORCH_WOOD_COST = 10;
    public static final int TORCH_INTENSITY = 16;
    public static final int FIRE_INTENSITY = 16;
    public static final int TORCH_DURATION = 150;
    public static final int TORCH_DURATION_OIL = 250;
    public static final float ADDIITONAL_COOLDOWN_WATER = 2.0f;
    public static final float MOVEMENT_COOLDOWN_DECREASE_EUGENICS = 0.5f;
    public static final int MAX_HEALTH_INCREASE_EUGENICS = 20;
    public static final int MAX_RESOURCE_CAPACITY = 100;
    public static final int MAX_RESOURCE_CAPACITY_BOXES = 200;
    public static final int MAX_ROCK_ART_NUMBER = 100000;
    public static final int MIN_ROCK_ART_NUMBER = 0;
    public static final int SMOKE_SIGNAL_COOLDOWN = 10;
    public static final int SMOKE_SIGNAL_COOLDOWN_VOCABULARY = 2;
    public static final int STANDARD_OPACITY = 1;
    public static final int FOREST_OPACITY = 2;
    public static final int MOUNTAIN_OPACITY = 100;
    public static final int CONSTRUCTION_TURNS = 10;
    public static final int MAX_ENERGY = 15000;
    public static final int EXCEPTION_ENERGY_PENALTY = 500;
    public static final int MAX_MAP_SIZE = 50;
    public static final int MIN_MAP_SIZE = 20;
    public static final int MAX_ID = 10000;
    public static final int[] WOOD_UNIT_COSTS;
    public static final int[] STONE_UNIT_COSTS;
    public static final int[] FOOD_UNIT_COSTS;
    public static final int[] ATTACK_UNITS;
    public static final int[] ATTACK_RANGE_UNITS;
    public static final int[] MIN_ATTACK_RANGE_UNITS;
    public static final int[] MAX_HP_UNITS;
    public static final float[] ATTACK_COOLDOWN_UNITS;
    public static final float[] MOVEMENT_COOLDOWN_UNITS;
    public static final int[] VIISON_RANGE_UNITS;
    public static final int[] MOVEMENT_RANGE;
    public static final int[] DETECTION_LEVEL;
    public static final int[] TORCH_THROW_RANGE;
    public static final int[] LUMINOUS_INTENSITY_UNITS;
    public static final int[] TECHNOLOGY_FOOD_COSTS;
    public static final int[] TECHNOLOGY_WOOD_COSTS;
    public static final int[] TECHNOLOGY_STONE_COSTS;
    
    static {
        GameConstants.RESOURCES_WORKER_ROUND = 5;
        GameConstants.RESOURCES_WORKER_ROUND_UTENSILS = 10;
        GameConstants.ATTACK_RATIO_INCREASE_SHARPENERS = 0.2;
        GameConstants.ATTACK_COOLDOWN_RATIO_DECREASE_EXPERTISE = 0.2;
        GameConstants.MAX_HEALTH_RATIO_INCREASE_COOKING = 0.2;
        WOOD_UNIT_COSTS = new int[] { 0, 10, 75, 150, 150, 0, 150, 30, 20, 40, 100, 30, 0 };
        STONE_UNIT_COSTS = new int[] { 0, 20, 75, 150, 150, 150, 0, 10, 30, 80, 40, 30, 0 };
        FOOD_UNIT_COSTS = new int[] { 0, 20, 0, 0, 0, 150, 150, 15, 20, 60, 60, 140, 0 };
        ATTACK_UNITS = new int[] { 40, 4, 0, 0, 0, 0, 0, 0, 0, 15, 5, 2, 0 };
        ATTACK_RANGE_UNITS = new int[] { 18, 5, 0, 0, 0, 0, 0, 0, 2, 5, 18, 2, 0 };
        MIN_ATTACK_RANGE_UNITS = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 9, 0, 0 };
        MAX_HP_UNITS = new int[] { 400, 10, 75, 200, 50, 50, 50, 10, 15, 70, 20, 120, 15 };
        ATTACK_COOLDOWN_UNITS = new float[] { 2.0f, 2.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 20.0f, 4.0f, 2.0f, 1.0f, 1.0f };
        MOVEMENT_COOLDOWN_UNITS = new float[] { 1.0f, 2.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 3.0f, 4.0f, 4.0f, 2.0f, 6.0f };
        VIISON_RANGE_UNITS = new int[] { 50, 25, 25, 25, 16, 16, 16, 50, 16, 20, 32, 32, 25 };
        MOVEMENT_RANGE = new int[] { 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2 };
        DETECTION_LEVEL = new int[] { 0, 11, 8, 8, 11, 11, 11, 5, 11, 10, 10, 8, 0 };
        TORCH_THROW_RANGE = new int[] { 0, 2, 0, 0, 0, 0, 0, 18, 2, 2, 2, 2, 0 };
        LUMINOUS_INTENSITY_UNITS = new int[] { 20, 0, 16, 16, 16, 16, 16, 0, 0, 0, 0, 0, 0 };
        TECHNOLOGY_FOOD_COSTS = new int[] { 300, 100, 0, 0, 100, 500, 0, 0, 400, 200, 0, 800, 500, 500, 0, 350, 0, 0, 3500, 1500, 500, 0, 0, 1500 };
        TECHNOLOGY_WOOD_COSTS = new int[] { 50, 150, 300, 500, 100, 100, 100, 400, 400, 400, 500, 200, 500, 250, 500, 350, 0, 1500, 0, 0, 500, 0, 750, 1500 };
        TECHNOLOGY_STONE_COSTS = new int[] { 50, 150, 100, 100, 200, 100, 300, 600, 200, 400, 500, 200, 0, 250, 500, 350, 1500, 0, 0, 0, 500, 1500, 750, 1500 };
    }
}
