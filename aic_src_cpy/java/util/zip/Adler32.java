// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import sun.nio.ch.DirectBuffer;
import java.nio.ByteBuffer;
import aic2021.engine.BytecodeManager;

public class Adler32 implements Checksum
{
    private int adler;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public Adler32() {
        try {
            BytecodeManager.incBytecodes(2);
            this.adler = 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void update(final int n) {
        try {
            final int adler = this.adler;
            BytecodeManager.incBytecodes(5);
            this.adler = update(adler, n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void update(final byte[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                BytecodeManager.incBytecodes(2);
                if (n2 >= 0) {
                    final int n3 = array.length - n2;
                    BytecodeManager.incBytecodes(6);
                    if (n <= n3) {
                        final int adler = this.adler;
                        BytecodeManager.incBytecodes(7);
                        this.adler = updateBytes(adler, array, n, n2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final ArrayIndexOutOfBoundsException ex2 = new ArrayIndexOutOfBoundsException();
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void update(final byte[] array) {
        try {
            final int adler = this.adler;
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(8);
            this.adler = updateBytes(adler, array, n, length);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void update(final ByteBuffer byteBuffer) {
        try {
            BytecodeManager.incBytecodes(2);
            final int position = byteBuffer.position();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int limit = byteBuffer.limit();
            BytecodeManager.incBytecodes(1);
            final boolean $assertionsDisabled = Adler32.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int n = position;
                final int n2 = limit;
                BytecodeManager.incBytecodes(3);
                if (n > n2) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int n3 = limit - position;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 <= 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final boolean b = byteBuffer instanceof DirectBuffer;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final int adler = this.adler;
                final DirectBuffer directBuffer = (DirectBuffer)byteBuffer;
                BytecodeManager.incBytecodes(6);
                final long address = directBuffer.address();
                final int n5 = position;
                final int n6 = n3;
                BytecodeManager.incBytecodes(3);
                this.adler = updateByteBuffer(adler, address, n5, n6);
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final boolean hasArray = byteBuffer.hasArray();
                BytecodeManager.incBytecodes(1);
                if (hasArray) {
                    final int adler2 = this.adler;
                    BytecodeManager.incBytecodes(5);
                    final byte[] array = byteBuffer.array();
                    final int n7 = position;
                    BytecodeManager.incBytecodes(3);
                    final int n8 = n7 + byteBuffer.arrayOffset();
                    final int n9 = n3;
                    BytecodeManager.incBytecodes(3);
                    this.adler = updateBytes(adler2, array, n8, n9);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final byte[] array2 = new byte[n3];
                    BytecodeManager.incBytecodes(2);
                    final byte[] dst = array2;
                    BytecodeManager.incBytecodes(3);
                    byteBuffer.get(dst);
                    BytecodeManager.incBytecodes(1);
                    final int adler3 = this.adler;
                    final byte[] array3 = array2;
                    final int n10 = 0;
                    final int length = array2.length;
                    BytecodeManager.incBytecodes(8);
                    this.adler = updateBytes(adler3, array3, n10, length);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n11 = limit;
            BytecodeManager.incBytecodes(3);
            byteBuffer.position(n11);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void reset() {
        try {
            this.adler = 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long getValue() {
        try {
            final long n = (long)this.adler & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(6);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static native int update(final int p0, final int p1);
    
    private static native int updateBytes(final int p0, final byte[] p1, final int p2, final int p3);
    
    private static native int updateByteBuffer(final int p0, final long p1, final int p2, final int p3);
    
    static {
        try {
            final Class<Adler32> clazz = Adler32.class;
            BytecodeManager.incBytecodes(2);
            final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
            BytecodeManager.incBytecodes(1);
            boolean $assertionsDisabled2;
            if (!desiredAssertionStatus) {
                $assertionsDisabled2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                $assertionsDisabled2 = false;
                BytecodeManager.incBytecodes(1);
            }
            $assertionsDisabled = $assertionsDisabled2;
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
