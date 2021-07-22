// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import instrumented.java.util.EventListener;

public interface NodeChangeListener extends EventListener
{
    void childAdded(final NodeChangeEvent p0);
    
    void childRemoved(final NodeChangeEvent p0);
}
