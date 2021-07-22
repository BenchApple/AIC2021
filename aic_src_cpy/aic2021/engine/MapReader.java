// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.user.Resource;
import java.io.Reader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import aic2021.util.Symmetry;
import aic2021.util.GameLocation;
import java.util.ArrayList;

class MapReader
{
    private final String dirPath;
    ArrayList<String> text;
    GameLocation locationA;
    GameLocation locationB;
    private Cell[][] map;
    private Symmetry symmetry;
    private FileReader fr;
    private BufferedReader mapReader;
    
    MapReader() {
        this.dirPath = System.getProperty("user.dir") + "/maps/";
        this.text = new ArrayList<String>();
        this.map = null;
    }
    
    String[] readLineAndSplit(final boolean b) throws NumberFormatException, IOException {
        final String line = this.mapReader.readLine();
        if (b) {
            this.text.add(line);
        }
        return line.trim().split("\\s+");
    }
    
    String readSingleLine(final boolean b) throws NumberFormatException, IOException {
        final String line = this.mapReader.readLine();
        if (b) {
            this.text.add(line);
        }
        return line;
    }
    
    void loadMap(final World world, final String str) throws NumberFormatException, IOException {
        this.fr = new FileReader(this.dirPath + str + ".txt");
        this.mapReader = new BufferedReader(this.fr);
        this.readSingleLine(true);
        this.readSingleLine(true);
        final String[] lineAndSplit = this.readLineAndSplit(true);
        final int int1 = Integer.parseInt(lineAndSplit[0]);
        final int int2 = Integer.parseInt(lineAndSplit[1]);
        this.map = new Cell[int1][int2];
        for (int i = 0; i < int1; ++i) {
            for (int j = 0; j < int2; ++j) {
                this.map[i][j] = new Cell(world, new GameLocation(i, j));
            }
        }
        final String[] lineAndSplit2 = this.readLineAndSplit(true);
        GameLocation.offsetX = Integer.parseInt(lineAndSplit2[0]);
        GameLocation.offsetY = Integer.parseInt(lineAndSplit2[1]);
        final String[] lineAndSplit3 = this.readLineAndSplit(true);
        for (int k = 0; k < Symmetry.values().length; ++k) {
            if (lineAndSplit3[0].toLowerCase().equals(Symmetry.values()[k].symName.toLowerCase())) {
                this.symmetry = Symmetry.values()[k];
            }
        }
        for (int int3 = Integer.parseInt(this.readSingleLine(true)), l = 0; l < int3; ++l) {
            final String[] lineAndSplit4 = this.readLineAndSplit(true);
            final Cell cell = this.map[Integer.parseInt(lineAndSplit4[1])][Integer.parseInt(lineAndSplit4[2])];
            final String s = lineAndSplit4[0];
            switch (s) {
                case "M": {
                    cell.addMountain();
                    break;
                }
                case "W": {
                    cell.addWater();
                    break;
                }
                case "D": {
                    cell.addResource(Resource.WOOD, Integer.parseInt(lineAndSplit4[3]));
                    break;
                }
                case "N": {
                    cell.addResource(Resource.STONE, Integer.parseInt(lineAndSplit4[3]));
                    break;
                }
            }
        }
        Integer.parseInt(this.readSingleLine(true));
        final String[] lineAndSplit5 = this.readLineAndSplit(false);
        this.locationA = new GameLocation(Integer.parseInt(lineAndSplit5[0]), Integer.parseInt(lineAndSplit5[1]));
        final String[] lineAndSplit6 = this.readLineAndSplit(false);
        this.locationB = new GameLocation(Integer.parseInt(lineAndSplit6[0]), Integer.parseInt(lineAndSplit6[1]));
        this.mapReader.close();
    }
    
    Cell[][] getMap() {
        if (this.map == null && Game.printWarnings) {
            System.err.println("MapReader.getMap: Warning: Map not loaded when calling 'getMap'");
        }
        return this.map;
    }
    
    GameLocation getLocationA() {
        return this.locationA;
    }
    
    GameLocation getLocationB() {
        return this.locationB;
    }
    
    Symmetry getSymmetry() {
        return this.symmetry;
    }
}
