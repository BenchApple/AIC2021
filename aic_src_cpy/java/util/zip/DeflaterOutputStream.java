// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.OutputStream;
import java.io.FilterOutputStream;

public class DeflaterOutputStream extends FilterOutputStream
{
    protected Deflater def;
    protected byte[] buf;
    private boolean closed;
    private final boolean syncFlush;
    boolean usesDefaultDeflater;
    
    public DeflaterOutputStream(final OutputStream out, final Deflater def, final int n, final boolean syncFlush) {
        try {
            BytecodeManager.incBytecodes(3);
            super(out);
            this.closed = false;
            BytecodeManager.incBytecodes(3);
            this.usesDefaultDeflater = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (out != null) {
                BytecodeManager.incBytecodes(2);
                if (def != null) {
                    BytecodeManager.incBytecodes(2);
                    if (n <= 0) {
                        final String s = "buffer size <= 0";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.def = def;
                    BytecodeManager.incBytecodes(3);
                    this.buf = new byte[n];
                    BytecodeManager.incBytecodes(3);
                    this.syncFlush = syncFlush;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex2 = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DeflaterOutputStream(final OutputStream out, final Deflater def, final int size) {
        try {
            final boolean syncFlush = false;
            BytecodeManager.incBytecodes(6);
            this(out, def, size, syncFlush);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DeflaterOutputStream(final OutputStream out, final Deflater def, final boolean syncFlush) {
        try {
            final int size = 512;
            BytecodeManager.incBytecodes(6);
            this(out, def, size, syncFlush);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DeflaterOutputStream(final OutputStream out, final Deflater def) {
        try {
            final int size = 512;
            final boolean syncFlush = false;
            BytecodeManager.incBytecodes(6);
            this(out, def, size, syncFlush);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DeflaterOutputStream(final OutputStream out, final boolean syncFlush) {
        try {
            BytecodeManager.incBytecodes(5);
            final Deflater def = new Deflater();
            final int size = 512;
            BytecodeManager.incBytecodes(3);
            this(out, def, size, syncFlush);
            this.usesDefaultDeflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DeflaterOutputStream(final OutputStream out) {
        try {
            final boolean syncFlush = false;
            BytecodeManager.incBytecodes(4);
            this(out, syncFlush);
            this.usesDefaultDeflater = true;
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
            final byte[] array = { 0 };
            BytecodeManager.incBytecodes(2);
            array[0] = (byte)(n & 0xFF);
            BytecodeManager.incBytecodes(7);
            final byte[] b = array;
            final int off = 0;
            final int len = 1;
            BytecodeManager.incBytecodes(5);
            this.write(b, off, len);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void write(final byte[] input, final int off, final int len) throws IOException {
        try {
            final Deflater def = this.def;
            BytecodeManager.incBytecodes(3);
            final boolean finished = def.finished();
            BytecodeManager.incBytecodes(1);
            if (finished) {
                final String message = "write beyond end of stream";
                BytecodeManager.incBytecodes(4);
                final IOException ex = new IOException(message);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n = off | len | off + len | input.length - (off + len);
            BytecodeManager.incBytecodes(15);
            if (n < 0) {
                BytecodeManager.incBytecodes(3);
                final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(2);
            if (len == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final Deflater def2 = this.def;
            BytecodeManager.incBytecodes(3);
            final boolean finished2 = def2.finished();
            BytecodeManager.incBytecodes(1);
            if (!finished2) {
                final Deflater def3 = this.def;
                BytecodeManager.incBytecodes(6);
                def3.setInput(input, off, len);
                while (true) {
                    final Deflater def4 = this.def;
                    BytecodeManager.incBytecodes(3);
                    final boolean needsInput = def4.needsInput();
                    BytecodeManager.incBytecodes(1);
                    if (needsInput) {
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    this.deflate();
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
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
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    this.deflate();
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void close() throws IOException {
        try {
            final boolean closed = this.closed;
            BytecodeManager.incBytecodes(3);
            if (!closed) {
                BytecodeManager.incBytecodes(2);
                this.finish();
                final boolean usesDefaultDeflater = this.usesDefaultDeflater;
                BytecodeManager.incBytecodes(3);
                if (usesDefaultDeflater) {
                    final Deflater def = this.def;
                    BytecodeManager.incBytecodes(3);
                    def.end();
                }
                final OutputStream out = this.out;
                BytecodeManager.incBytecodes(3);
                out.close();
                this.closed = true;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void deflate() throws IOException {
        try {
            final Deflater def = this.def;
            final byte[] buf = this.buf;
            final int off = 0;
            final int length = this.buf.length;
            BytecodeManager.incBytecodes(9);
            final int deflate = def.deflate(buf, off, length);
            BytecodeManager.incBytecodes(1);
            final int n = deflate;
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                final OutputStream out = this.out;
                final byte[] buf2 = this.buf;
                final int off2 = 0;
                final int len = deflate;
                BytecodeManager.incBytecodes(7);
                out.write(buf2, off2, len);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void flush() throws IOException {
        try {
            final boolean syncFlush = this.syncFlush;
            BytecodeManager.incBytecodes(3);
            Label_0112: {
                if (syncFlush) {
                    final Deflater def = this.def;
                    BytecodeManager.incBytecodes(3);
                    final boolean finished = def.finished();
                    BytecodeManager.incBytecodes(1);
                    if (!finished) {
                        BytecodeManager.incBytecodes(2);
                        int i;
                        int length;
                        do {
                            final Deflater def2 = this.def;
                            final byte[] buf = this.buf;
                            final int off = 0;
                            final int length2 = this.buf.length;
                            final int flush = 2;
                            BytecodeManager.incBytecodes(10);
                            final int deflate;
                            final int n = deflate = def2.deflate(buf, off, length2, flush);
                            BytecodeManager.incBytecodes(3);
                            if (n <= 0) {
                                break Label_0112;
                            }
                            final OutputStream out = this.out;
                            final byte[] buf2 = this.buf;
                            final int off2 = 0;
                            final int len = deflate;
                            BytecodeManager.incBytecodes(7);
                            out.write(buf2, off2, len);
                            i = deflate;
                            length = this.buf.length;
                            BytecodeManager.incBytecodes(5);
                        } while (i >= length);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final OutputStream out2 = this.out;
            BytecodeManager.incBytecodes(3);
            out2.flush();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
