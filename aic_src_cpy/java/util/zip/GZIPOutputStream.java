// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.OutputStream;

public class GZIPOutputStream extends DeflaterOutputStream
{
    protected CRC32 crc;
    private static final int GZIP_MAGIC = 35615;
    private static final int TRAILER_SIZE = 8;
    
    public GZIPOutputStream(final OutputStream outputStream, final int n) throws IOException {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            this(outputStream, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GZIPOutputStream(final OutputStream out, final int size, final boolean syncFlush) throws IOException {
        try {
            final int level = -1;
            final boolean nowrap = true;
            BytecodeManager.incBytecodes(7);
            final Deflater def = new Deflater(level, nowrap);
            BytecodeManager.incBytecodes(3);
            super(out, def, size, syncFlush);
            BytecodeManager.incBytecodes(4);
            this.crc = new CRC32();
            BytecodeManager.incBytecodes(1);
            this.usesDefaultDeflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.writeHeader();
            final CRC32 crc = this.crc;
            BytecodeManager.incBytecodes(3);
            crc.reset();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GZIPOutputStream(final OutputStream outputStream) throws IOException {
        try {
            final int n = 512;
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            this(outputStream, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GZIPOutputStream(final OutputStream outputStream, final boolean b) throws IOException {
        try {
            final int n = 512;
            BytecodeManager.incBytecodes(5);
            this(outputStream, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void write(final byte[] array, final int n, final int n2) throws IOException {
        try {
            BytecodeManager.incBytecodes(5);
            super.write(array, n, n2);
            final CRC32 crc = this.crc;
            BytecodeManager.incBytecodes(6);
            crc.update(array, n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void finish() throws IOException {
        try {
            final Deflater def = this.def;
            BytecodeManager.incBytecodes(3);
            final boolean finished = def.finished();
            BytecodeManager.incBytecodes(1);
            if (!finished) {
                final Deflater def2 = this.def;
                BytecodeManager.incBytecodes(3);
                def2.finish();
                while (true) {
                    final Deflater def3 = this.def;
                    BytecodeManager.incBytecodes(3);
                    final boolean finished2 = def3.finished();
                    BytecodeManager.incBytecodes(1);
                    if (finished2) {
                        final byte[] array = new byte[8];
                        BytecodeManager.incBytecodes(2);
                        final byte[] array2 = array;
                        final int n = 0;
                        BytecodeManager.incBytecodes(4);
                        this.writeTrailer(array2, n);
                        final OutputStream out = this.out;
                        final byte[] b = array;
                        BytecodeManager.incBytecodes(4);
                        out.write(b);
                        break;
                    }
                    final Deflater def4 = this.def;
                    final byte[] buf = this.buf;
                    final int off = 0;
                    final int length = this.buf.length;
                    BytecodeManager.incBytecodes(9);
                    final int deflate = def4.deflate(buf, off, length);
                    BytecodeManager.incBytecodes(1);
                    final Deflater def5 = this.def;
                    BytecodeManager.incBytecodes(3);
                    final boolean finished3 = def5.finished();
                    BytecodeManager.incBytecodes(1);
                    if (finished3) {
                        final int n2 = deflate;
                        final int n3 = this.buf.length - 8;
                        BytecodeManager.incBytecodes(7);
                        if (n2 <= n3) {
                            final byte[] buf2 = this.buf;
                            final int n4 = deflate;
                            BytecodeManager.incBytecodes(5);
                            this.writeTrailer(buf2, n4);
                            final int n5 = deflate + 8;
                            BytecodeManager.incBytecodes(4);
                            final OutputStream out2 = this.out;
                            final byte[] buf3 = this.buf;
                            final int off2 = 0;
                            final int len = n5;
                            BytecodeManager.incBytecodes(7);
                            out2.write(buf3, off2, len);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    final int n6 = deflate;
                    BytecodeManager.incBytecodes(2);
                    if (n6 > 0) {
                        final OutputStream out3 = this.out;
                        final byte[] buf4 = this.buf;
                        final int off3 = 0;
                        final int len2 = deflate;
                        BytecodeManager.incBytecodes(7);
                        out3.write(buf4, off3, len2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeHeader() throws IOException {
        try {
            final OutputStream out = this.out;
            final byte[] b = { 31, -117, 8, 0, 0, 0, 0, 0, 0, 0 };
            BytecodeManager.incBytecodes(44);
            out.write(b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeTrailer(final byte[] array, final int n) throws IOException {
        try {
            final CRC32 crc = this.crc;
            BytecodeManager.incBytecodes(4);
            final int n2 = (int)crc.getValue();
            BytecodeManager.incBytecodes(4);
            this.writeInt(n2, array, n);
            final Deflater def = this.def;
            BytecodeManager.incBytecodes(4);
            final int totalIn = def.getTotalIn();
            final int n3 = n + 4;
            BytecodeManager.incBytecodes(5);
            this.writeInt(totalIn, array, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeInt(final int n, final byte[] array, final int n2) throws IOException {
        try {
            final int n3 = n & 0xFFFF;
            BytecodeManager.incBytecodes(7);
            this.writeShort(n3, array, n2);
            final int n4 = n >> 16 & 0xFFFF;
            final int n5 = n2 + 2;
            BytecodeManager.incBytecodes(11);
            this.writeShort(n4, array, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeShort(final int n, final byte[] array, final int n2) throws IOException {
        try {
            array[n2] = (byte)(n & 0xFF);
            BytecodeManager.incBytecodes(7);
            array[n2 + 1] = (byte)(n >> 8 & 0xFF);
            BytecodeManager.incBytecodes(11);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
