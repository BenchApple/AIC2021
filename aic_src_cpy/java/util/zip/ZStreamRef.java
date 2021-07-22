// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import aic2021.engine.BytecodeManager;

class ZStreamRef
{
    private long address;
    
    ZStreamRef(final long address) {
        try {
            BytecodeManager.incBytecodes(2);
            this.address = address;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    long address() {
        try {
            final long address = this.address;
            BytecodeManager.incBytecodes(3);
            return address;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void clear() {
        try {
            this.address = 0L;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
