// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

class MyClassLoader extends ClassLoader
{
    MyClassLoader() {
        super(MyClassLoader.class.getClassLoader());
        this.clearAssertionStatus();
        this.setDefaultAssertionStatus(true);
    }
    
    @Override
    protected Class<?> loadClass(final String s, final boolean resolve) throws ClassNotFoundException {
        if (Game.printWarnings) {
            System.err.println("Name of Class: " + s);
        }
        return super.loadClass(s, resolve);
    }
}
