// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.OutputStream;
import java.io.FilterOutputStream;

public class CheckedOutputStream extends FilterOutputStream
{
    private Checksum cksum;
    
    public CheckedOutputStream(final OutputStream out, final Checksum cksum) {
        try {
            BytecodeManager.incBytecodes(3);
            super(out);
            this.cksum = cksum;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void write(final int n) throws IOException {
        try {
            final OutputStream out = this.out;
            BytecodeManager.incBytecodes(4);
            out.write(n);
            final Checksum cksum = this.cksum;
            BytecodeManager.incBytecodes(4);
            cksum.update(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void write(final byte[] b, final int off, final int len) throws IOException {
        try {
            final OutputStream out = this.out;
            BytecodeManager.incBytecodes(6);
            out.write(b, off, len);
            final Checksum cksum = this.cksum;
            BytecodeManager.incBytecodes(6);
            cksum.update(b, off, len);
            BytecodeManager.incBytecodes(1);
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
