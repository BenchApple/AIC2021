// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.util.random;

public class SymmetricRandom
{
    SymmetricEnum sym;
    SymmetricRandomDualQueue rand;
    
    public SymmetricRandom() {
        this.sym = null;
        this.rand = null;
    }
    
    public void setDual(final SymmetricRandomDualQueue rand, final SymmetricEnum sym) {
        this.rand = rand;
        this.sym = sym;
    }
    
    public Double poll() {
        if (this.sym == null) {
            return CustomRandom.getInstance().getRandom();
        }
        return this.rand.poll(this.sym);
    }
    
    public SymmetricEnum getSym() {
        return this.sym;
    }
}
