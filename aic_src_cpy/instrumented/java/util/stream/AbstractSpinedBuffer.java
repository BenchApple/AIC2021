// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import aic2021.engine.BytecodeManager;

abstract class AbstractSpinedBuffer
{
    public static final int MIN_CHUNK_POWER = 4;
    public static final int MIN_CHUNK_SIZE = 16;
    public static final int MAX_CHUNK_POWER = 30;
    public static final int MIN_SPINE_SIZE = 8;
    protected final int initialChunkPower;
    protected int elementIndex;
    protected int spineIndex;
    protected long[] priorElementCount;
    
    protected AbstractSpinedBuffer() {
        try {
            BytecodeManager.incBytecodes(2);
            this.initialChunkPower = 4;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected AbstractSpinedBuffer(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal Capacity: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int a = 4;
            final int n = 32;
            final int j = i - 1;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final int b = n - Integer.numberOfLeadingZeros(j);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            this.initialChunkPower = Math.max(a, b);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isEmpty() {
        try {
            final int spineIndex = this.spineIndex;
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0039: {
                if (spineIndex == 0) {
                    final int elementIndex = this.elementIndex;
                    BytecodeManager.incBytecodes(3);
                    if (elementIndex == 0) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0039;
                    }
                }
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long count() {
        try {
            final int spineIndex = this.spineIndex;
            BytecodeManager.incBytecodes(3);
            long n;
            if (spineIndex == 0) {
                n = this.elementIndex;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n = this.priorElementCount[this.spineIndex] + this.elementIndex;
                BytecodeManager.incBytecodes(9);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected int chunkSize(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            Label_0054: {
                if (n != 0) {
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n != n2) {
                        final int a = this.initialChunkPower + n - 1;
                        final int b = 30;
                        BytecodeManager.incBytecodes(7);
                        BytecodeManager.incBytecodes(1);
                        n3 = Math.min(a, b);
                        break Label_0054;
                    }
                }
                n3 = this.initialChunkPower;
                BytecodeManager.incBytecodes(3);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            final int n5 = 1 << n4;
            BytecodeManager.incBytecodes(4);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract void clear();
}
