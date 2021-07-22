// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import sun.nio.ch.DirectBuffer;
import java.nio.ByteBuffer;
import aic2021.engine.BytecodeManager;

public class CRC32 implements Checksum
{
    private int crc;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public CRC32() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void update(final int n) {
        try {
            final int crc = this.crc;
            BytecodeManager.incBytecodes(5);
            this.crc = update(crc, n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void update(final byte[] b, final int off, final int len) {
        try {
            BytecodeManager.incBytecodes(2);
            if (b == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (off >= 0) {
                BytecodeManager.incBytecodes(2);
                if (len >= 0) {
                    final int n = b.length - len;
                    BytecodeManager.incBytecodes(6);
                    if (off <= n) {
                        final int crc = this.crc;
                        BytecodeManager.incBytecodes(7);
                        this.crc = updateBytes(crc, b, off, len);
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
    public void update(final byte[] b) {
        try {
            final int crc = this.crc;
            final int off = 0;
            final int length = b.length;
            BytecodeManager.incBytecodes(8);
            this.crc = updateBytes(crc, b, off, length);
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
            final boolean $assertionsDisabled = CRC32.$assertionsDisabled;
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
                final int crc = this.crc;
                final DirectBuffer directBuffer = (DirectBuffer)byteBuffer;
                BytecodeManager.incBytecodes(6);
                final long address = directBuffer.address();
                final int off = position;
                final int len = n3;
                BytecodeManager.incBytecodes(3);
                this.crc = updateByteBuffer(crc, address, off, len);
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final boolean hasArray = byteBuffer.hasArray();
                BytecodeManager.incBytecodes(1);
                if (hasArray) {
                    final int crc2 = this.crc;
                    BytecodeManager.incBytecodes(5);
                    final byte[] array = byteBuffer.array();
                    final int n5 = position;
                    BytecodeManager.incBytecodes(3);
                    final int off2 = n5 + byteBuffer.arrayOffset();
                    final int len2 = n3;
                    BytecodeManager.incBytecodes(3);
                    this.crc = updateBytes(crc2, array, off2, len2);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final byte[] array2 = new byte[n3];
                    BytecodeManager.incBytecodes(2);
                    final byte[] dst = array2;
                    BytecodeManager.incBytecodes(3);
                    byteBuffer.get(dst);
                    BytecodeManager.incBytecodes(1);
                    final int crc3 = this.crc;
                    final byte[] b2 = array2;
                    final int off3 = 0;
                    final int length = array2.length;
                    BytecodeManager.incBytecodes(8);
                    this.crc = updateBytes(crc3, b2, off3, length);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n6 = limit;
            BytecodeManager.incBytecodes(3);
            byteBuffer.position(n6);
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
            this.crc = 0;
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
            final long n = (long)this.crc & 0xFFFFFFFFL;
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
            final Class<CRC32> clazz = CRC32.class;
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
