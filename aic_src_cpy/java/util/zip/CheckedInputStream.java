// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.InputStream;
import java.io.FilterInputStream;

public class CheckedInputStream extends FilterInputStream
{
    private Checksum cksum;
    
    public CheckedInputStream(final InputStream in, final Checksum cksum) {
        try {
            BytecodeManager.incBytecodes(3);
            super(in);
            this.cksum = cksum;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read() throws IOException {
        try {
            final InputStream in = this.in;
            BytecodeManager.incBytecodes(3);
            final int read = in.read();
            BytecodeManager.incBytecodes(1);
            final int n = read;
            final int n2 = -1;
            BytecodeManager.incBytecodes(3);
            if (n != n2) {
                final Checksum cksum = this.cksum;
                final int n3 = read;
                BytecodeManager.incBytecodes(4);
                cksum.update(n3);
            }
            final int n4 = read;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read(final byte[] b, final int off, int read) throws IOException {
        try {
            final InputStream in = this.in;
            final int len = read;
            BytecodeManager.incBytecodes(6);
            read = in.read(b, off, len);
            BytecodeManager.incBytecodes(1);
            final int n = read;
            final int n2 = -1;
            BytecodeManager.incBytecodes(3);
            if (n != n2) {
                final Checksum cksum = this.cksum;
                final int n3 = read;
                BytecodeManager.incBytecodes(6);
                cksum.update(b, off, n3);
            }
            final int n4 = read;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long skip(final long n) throws IOException {
        try {
            final byte[] array = new byte[512];
            BytecodeManager.incBytecodes(2);
            long n2 = 0L;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final long n3 = lcmp(n2, n);
                BytecodeManager.incBytecodes(4);
                if (n3 >= 0) {
                    final long n4 = n2;
                    BytecodeManager.incBytecodes(2);
                    return n4;
                }
                final long n5 = n - n2;
                BytecodeManager.incBytecodes(4);
                final byte[] array2 = array;
                final int n6 = 0;
                final long n7 = lcmp(n5, (long)array.length);
                BytecodeManager.incBytecodes(9);
                int length;
                if (n7 < 0) {
                    length = (int)n5;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    length = array.length;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                final long n8 = this.read(array2, n6, length);
                BytecodeManager.incBytecodes(2);
                final long n9 = lcmp(n8, -1L);
                BytecodeManager.incBytecodes(4);
                if (n9 == 0) {
                    final long n10 = n2;
                    BytecodeManager.incBytecodes(2);
                    return n10;
                }
                n2 += n8;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Checksum getChecksum() {
        try {
            final Checksum cksum = this.cksum;
            BytecodeManager.incBytecodes(3);
            return cksum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
