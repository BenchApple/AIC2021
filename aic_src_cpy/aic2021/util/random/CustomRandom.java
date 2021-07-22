// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.util.random;

import java.util.Random;

public class CustomRandom
{
    static CustomRandom instance;
    Random rand;
    long seed;
    int randomCont;
    
    public CustomRandom(final long n) {
        this.randomCont = 0;
        this.rand = new Random(n);
        this.seed = n;
    }
    
    public static CustomRandom getInstance() {
        if (CustomRandom.instance != null) {
            return CustomRandom.instance;
        }
        System.err.println("ERROR: Random not initialized. Report to devs");
        return CustomRandom.instance = new CustomRandom(System.currentTimeMillis());
    }
    
    public static CustomRandom getNewInstance(final long n) {
        return CustomRandom.instance = new CustomRandom(n);
    }
    
    public long getSeed() {
        return this.seed;
    }
    
    public Double getRandom() {
        return this.rand.nextDouble();
    }
    
    static {
        CustomRandom.instance = null;
    }
}
