// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.EOFException;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.IOException;
import aic2021.engine.BytecodeManager;

public class ZipInputStream extends InflaterInputStream implements ZipConstants
{
    private ZipEntry entry;
    private int flag;
    private CRC32 crc;
    private long remaining;
    private byte[] tmpbuf;
    private static final int STORED = 0;
    private static final int DEFLATED = 8;
    private boolean closed;
    private boolean entryEOF;
    private ZipCoder zc;
    private byte[] b;
    
    private void ensureOpen() throws IOException {
        try {
            final boolean closed = this.closed;
            BytecodeManager.incBytecodes(3);
            if (closed) {
                final String message = "Stream closed";
                BytecodeManager.incBytecodes(4);
                final IOException ex = new IOException(message);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipInputStream(final InputStream inputStream) {
        try {
            final Charset utf_8 = StandardCharsets.UTF_8;
            BytecodeManager.incBytecodes(4);
            this(inputStream, utf_8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipInputStream(final InputStream in, final Charset charset) {
        try {
            final int size = 512;
            BytecodeManager.incBytecodes(6);
            final PushbackInputStream in2 = new PushbackInputStream(in, size);
            final boolean nowrap = true;
            BytecodeManager.incBytecodes(4);
            final Inflater inf = new Inflater(nowrap);
            final int size2 = 512;
            BytecodeManager.incBytecodes(2);
            super(in2, inf, size2);
            BytecodeManager.incBytecodes(4);
            this.crc = new CRC32();
            BytecodeManager.incBytecodes(1);
            this.tmpbuf = new byte[512];
            BytecodeManager.incBytecodes(3);
            this.closed = false;
            BytecodeManager.incBytecodes(3);
            this.entryEOF = false;
            BytecodeManager.incBytecodes(3);
            this.b = new byte[256];
            BytecodeManager.incBytecodes(3);
            this.usesDefaultInflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (in == null) {
                final String s = "in is null";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (charset == null) {
                final String s2 = "charset is null";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex2 = new NullPointerException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            this.zc = ZipCoder.get(charset);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipEntry getNextEntry() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final ZipEntry entry = this.entry;
            BytecodeManager.incBytecodes(3);
            if (entry != null) {
                BytecodeManager.incBytecodes(2);
                this.closeEntry();
            }
            final CRC32 crc = this.crc;
            BytecodeManager.incBytecodes(3);
            crc.reset();
            final Inflater inf = this.inf;
            BytecodeManager.incBytecodes(3);
            inf.reset();
            BytecodeManager.incBytecodes(3);
            final ZipEntry loc = this.readLOC();
            this.entry = loc;
            BytecodeManager.incBytecodes(3);
            if (loc == null) {
                final ZipEntry zipEntry = null;
                BytecodeManager.incBytecodes(2);
                return zipEntry;
            }
            final int method = this.entry.method;
            BytecodeManager.incBytecodes(4);
            if (method == 0) {
                this.remaining = this.entry.size;
                BytecodeManager.incBytecodes(5);
            }
            this.entryEOF = false;
            BytecodeManager.incBytecodes(3);
            final ZipEntry entry2 = this.entry;
            BytecodeManager.incBytecodes(3);
            return entry2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void closeEntry() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            while (true) {
                final byte[] tmpbuf = this.tmpbuf;
                final int n = 0;
                final int length = this.tmpbuf.length;
                BytecodeManager.incBytecodes(8);
                final int read = this.read(tmpbuf, n, length);
                final int n2 = -1;
                BytecodeManager.incBytecodes(2);
                if (read == n2) {
                    break;
                }
                BytecodeManager.incBytecodes(1);
            }
            this.entryEOF = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int available() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final boolean entryEOF = this.entryEOF;
            BytecodeManager.incBytecodes(3);
            if (entryEOF) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            final int n2 = 1;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read(final byte[] array, final int n, int n2) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 >= 0) {
                    final int n4 = array.length - n2;
                    BytecodeManager.incBytecodes(6);
                    if (n <= n4) {
                        final boolean b = n2 != 0;
                        BytecodeManager.incBytecodes(2);
                        if (!b) {
                            final int n5 = 0;
                            BytecodeManager.incBytecodes(2);
                            return n5;
                        }
                        final ZipEntry entry = this.entry;
                        BytecodeManager.incBytecodes(3);
                        if (entry == null) {
                            final int n6 = -1;
                            BytecodeManager.incBytecodes(2);
                            return n6;
                        }
                        final int method = this.entry.method;
                        BytecodeManager.incBytecodes(4);
                        switch (method) {
                            case 8: {
                                final int len = n2;
                                BytecodeManager.incBytecodes(5);
                                n2 = super.read(array, n, len);
                                BytecodeManager.incBytecodes(1);
                                final int n7 = n2;
                                final int n8 = -1;
                                BytecodeManager.incBytecodes(3);
                                if (n7 == n8) {
                                    final ZipEntry entry2 = this.entry;
                                    BytecodeManager.incBytecodes(4);
                                    this.readEnd(entry2);
                                    this.entryEOF = true;
                                    BytecodeManager.incBytecodes(3);
                                    this.entry = null;
                                    BytecodeManager.incBytecodes(4);
                                }
                                else {
                                    final CRC32 crc = this.crc;
                                    final int len2 = n2;
                                    BytecodeManager.incBytecodes(6);
                                    crc.update(array, n, len2);
                                }
                                final int n9 = n2;
                                BytecodeManager.incBytecodes(2);
                                return n9;
                            }
                            case 0: {
                                final long n10 = lcmp(this.remaining, 0L);
                                BytecodeManager.incBytecodes(5);
                                if (n10 <= 0) {
                                    this.entryEOF = true;
                                    BytecodeManager.incBytecodes(3);
                                    this.entry = null;
                                    BytecodeManager.incBytecodes(3);
                                    final int n11 = -1;
                                    BytecodeManager.incBytecodes(2);
                                    return n11;
                                }
                                final long n12 = lcmp((long)n2, this.remaining);
                                BytecodeManager.incBytecodes(6);
                                if (n12 > 0) {
                                    n2 = (int)this.remaining;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final InputStream in = this.in;
                                final int len3 = n2;
                                BytecodeManager.incBytecodes(6);
                                n2 = in.read(array, n, len3);
                                BytecodeManager.incBytecodes(1);
                                final int n13 = n2;
                                final int n14 = -1;
                                BytecodeManager.incBytecodes(3);
                                if (n13 == n14) {
                                    final String s = "unexpected EOF";
                                    BytecodeManager.incBytecodes(4);
                                    final ZipException ex = new ZipException(s);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex;
                                }
                                final CRC32 crc2 = this.crc;
                                final int len4 = n2;
                                BytecodeManager.incBytecodes(6);
                                crc2.update(array, n, len4);
                                this.remaining -= n2;
                                BytecodeManager.incBytecodes(7);
                                final long n15 = lcmp(this.remaining, 0L);
                                BytecodeManager.incBytecodes(5);
                                if (n15 == 0) {
                                    final long crc3 = this.entry.crc;
                                    final CRC32 crc4 = this.crc;
                                    BytecodeManager.incBytecodes(6);
                                    final long n16 = lcmp(crc3, crc4.getValue());
                                    BytecodeManager.incBytecodes(2);
                                    if (n16 != 0) {
                                        BytecodeManager.incBytecodes(5);
                                        final StringBuilder sb = new StringBuilder();
                                        final String str = "invalid entry CRC (expected 0x";
                                        BytecodeManager.incBytecodes(2);
                                        final StringBuilder append = sb.append(str);
                                        final long crc5 = this.entry.crc;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        final String hexString = Long.toHexString(crc5);
                                        BytecodeManager.incBytecodes(1);
                                        final StringBuilder append2 = append.append(hexString);
                                        final String str2 = " but got 0x";
                                        BytecodeManager.incBytecodes(2);
                                        final StringBuilder append3 = append2.append(str2);
                                        final CRC32 crc6 = this.crc;
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        final long value = crc6.getValue();
                                        BytecodeManager.incBytecodes(1);
                                        final String hexString2 = Long.toHexString(value);
                                        BytecodeManager.incBytecodes(1);
                                        final StringBuilder append4 = append3.append(hexString2);
                                        final String str3 = ")";
                                        BytecodeManager.incBytecodes(2);
                                        final StringBuilder append5 = append4.append(str3);
                                        BytecodeManager.incBytecodes(1);
                                        final String string = append5.toString();
                                        BytecodeManager.incBytecodes(1);
                                        final ZipException ex2 = new ZipException(string);
                                        BytecodeManager.incBytecodes(1);
                                        throw ex2;
                                    }
                                }
                                final int n17 = n2;
                                BytecodeManager.incBytecodes(2);
                                return n17;
                            }
                            default: {
                                final String s2 = "invalid compression method";
                                BytecodeManager.incBytecodes(4);
                                final ZipException ex3 = new ZipException(s2);
                                BytecodeManager.incBytecodes(1);
                                throw ex3;
                            }
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IndexOutOfBoundsException ex4 = new IndexOutOfBoundsException();
            BytecodeManager.incBytecodes(1);
            throw ex4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long skip(final long a) throws IOException {
        try {
            final long n = lcmp(a, 0L);
            BytecodeManager.incBytecodes(4);
            if (n < 0) {
                final String s = "negative skip length";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final long b = 2147483647L;
            BytecodeManager.incBytecodes(3);
            final int n2 = (int)Math.min(a, b);
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int n5 = n2;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                int length = n2 - n3;
                BytecodeManager.incBytecodes(4);
                final int n6 = length;
                final int length2 = this.tmpbuf.length;
                BytecodeManager.incBytecodes(5);
                if (n6 > length2) {
                    length = this.tmpbuf.length;
                    BytecodeManager.incBytecodes(4);
                }
                final byte[] tmpbuf = this.tmpbuf;
                final int n7 = 0;
                final int n8 = length;
                BytecodeManager.incBytecodes(6);
                final int read = this.read(tmpbuf, n7, n8);
                BytecodeManager.incBytecodes(1);
                final int n9 = read;
                final int n10 = -1;
                BytecodeManager.incBytecodes(3);
                if (n9 == n10) {
                    this.entryEOF = true;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                n3 += read;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            final long n11 = n3;
            BytecodeManager.incBytecodes(3);
            return n11;
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
                super.close();
                this.closed = true;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private ZipEntry readLOC() throws IOException {
        try {
            try {
                try {
                    final byte[] tmpbuf = this.tmpbuf;
                    final int n = 0;
                    final int n2 = 30;
                    BytecodeManager.incBytecodes(6);
                    this.readFully(tmpbuf, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                catch (EOFException ex3) {
                    BytecodeManager.incBytecodes(501);
                    final ZipEntry zipEntry = null;
                    BytecodeManager.incBytecodes(2);
                    return zipEntry;
                }
                final byte[] tmpbuf2 = this.tmpbuf;
                final int off = 0;
                BytecodeManager.incBytecodes(4);
                final long n3 = lcmp(ZipUtils.get32(tmpbuf2, off), 67324752L);
                BytecodeManager.incBytecodes(3);
                if (n3 != 0) {
                    final ZipEntry zipEntry2 = null;
                    BytecodeManager.incBytecodes(2);
                    return zipEntry2;
                }
                final byte[] tmpbuf3 = this.tmpbuf;
                final int off2 = 6;
                BytecodeManager.incBytecodes(5);
                this.flag = ZipUtils.get16(tmpbuf3, off2);
                BytecodeManager.incBytecodes(1);
                final byte[] tmpbuf4 = this.tmpbuf;
                final int off3 = 26;
                BytecodeManager.incBytecodes(4);
                final int get16 = ZipUtils.get16(tmpbuf4, off3);
                BytecodeManager.incBytecodes(1);
                int length = this.b.length;
                BytecodeManager.incBytecodes(4);
                final int n4 = get16;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 > n5) {
                    int i;
                    int n6;
                    do {
                        length *= 2;
                        BytecodeManager.incBytecodes(4);
                        i = get16;
                        n6 = length;
                        BytecodeManager.incBytecodes(3);
                    } while (i > n6);
                    this.b = new byte[length];
                    BytecodeManager.incBytecodes(3);
                }
                final byte[] b = this.b;
                final int n7 = 0;
                final int n8 = get16;
                BytecodeManager.incBytecodes(6);
                this.readFully(b, n7, n8);
                final int n9 = this.flag & 0x800;
                BytecodeManager.incBytecodes(6);
                String s;
                if (n9 != 0) {
                    final ZipCoder zc = this.zc;
                    final byte[] b2 = this.b;
                    final int len = get16;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    s = zc.toStringUTF8(b2, len);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final ZipCoder zc2 = this.zc;
                    final byte[] b3 = this.b;
                    final int length2 = get16;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    s = zc2.toString(b3, length2);
                }
                BytecodeManager.incBytecodes(1);
                final ZipEntry zipEntry3 = this.createZipEntry(s);
                BytecodeManager.incBytecodes(1);
                final int n10 = this.flag & 0x1;
                final int n11 = 1;
                BytecodeManager.incBytecodes(6);
                if (n10 == n11) {
                    final String s2 = "encrypted ZIP entry not supported";
                    BytecodeManager.incBytecodes(4);
                    final ZipException ex = new ZipException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final ZipEntry zipEntry4 = zipEntry3;
                final byte[] tmpbuf5 = this.tmpbuf;
                final int off4 = 8;
                BytecodeManager.incBytecodes(5);
                zipEntry4.method = ZipUtils.get16(tmpbuf5, off4);
                BytecodeManager.incBytecodes(1);
                final ZipEntry zipEntry5 = zipEntry3;
                final byte[] tmpbuf6 = this.tmpbuf;
                final int off5 = 10;
                BytecodeManager.incBytecodes(5);
                zipEntry5.xdostime = ZipUtils.get32(tmpbuf6, off5);
                BytecodeManager.incBytecodes(1);
                final int n12 = this.flag & 0x8;
                final int n13 = 8;
                BytecodeManager.incBytecodes(6);
                if (n12 == n13) {
                    final int method = zipEntry3.method;
                    final int n14 = 8;
                    BytecodeManager.incBytecodes(4);
                    if (method != n14) {
                        final String s3 = "only DEFLATED entries can have EXT descriptor";
                        BytecodeManager.incBytecodes(4);
                        final ZipException ex2 = new ZipException(s3);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                else {
                    final ZipEntry zipEntry6 = zipEntry3;
                    final byte[] tmpbuf7 = this.tmpbuf;
                    final int off6 = 14;
                    BytecodeManager.incBytecodes(5);
                    zipEntry6.crc = ZipUtils.get32(tmpbuf7, off6);
                    BytecodeManager.incBytecodes(1);
                    final ZipEntry zipEntry7 = zipEntry3;
                    final byte[] tmpbuf8 = this.tmpbuf;
                    final int off7 = 18;
                    BytecodeManager.incBytecodes(5);
                    zipEntry7.csize = ZipUtils.get32(tmpbuf8, off7);
                    BytecodeManager.incBytecodes(1);
                    final ZipEntry zipEntry8 = zipEntry3;
                    final byte[] tmpbuf9 = this.tmpbuf;
                    final int off8 = 22;
                    BytecodeManager.incBytecodes(5);
                    zipEntry8.size = ZipUtils.get32(tmpbuf9, off8);
                    BytecodeManager.incBytecodes(1);
                }
                final byte[] tmpbuf10 = this.tmpbuf;
                final int off9 = 28;
                BytecodeManager.incBytecodes(4);
                final int get17 = ZipUtils.get16(tmpbuf10, off9);
                BytecodeManager.incBytecodes(1);
                final int n15 = get17;
                BytecodeManager.incBytecodes(2);
                if (n15 > 0) {
                    final byte[] array = new byte[get17];
                    BytecodeManager.incBytecodes(2);
                    final byte[] array2 = array;
                    final int n16 = 0;
                    final int n17 = get17;
                    BytecodeManager.incBytecodes(5);
                    this.readFully(array2, n16, n17);
                    final ZipEntry zipEntry9 = zipEntry3;
                    final byte[] extra = array;
                    final long n18 = lcmp(zipEntry3.csize, 4294967295L);
                    BytecodeManager.incBytecodes(7);
                    boolean doZIP64 = false;
                    Label_0566: {
                        if (n18 != 0) {
                            final long n19 = lcmp(zipEntry3.size, 4294967295L);
                            BytecodeManager.incBytecodes(5);
                            if (n19 != 0) {
                                doZIP64 = false;
                                BytecodeManager.incBytecodes(1);
                                break Label_0566;
                            }
                        }
                        doZIP64 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                    zipEntry9.setExtra0(extra, doZIP64);
                }
                final ZipEntry zipEntry10 = zipEntry3;
                BytecodeManager.incBytecodes(2);
                return zipEntry10;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    protected ZipEntry createZipEntry(final String name) {
        try {
            BytecodeManager.incBytecodes(4);
            final ZipEntry zipEntry = new ZipEntry(name);
            BytecodeManager.incBytecodes(1);
            return zipEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readEnd(final ZipEntry zipEntry) throws IOException {
        try {
            final Inflater inf = this.inf;
            BytecodeManager.incBytecodes(3);
            final int remaining = inf.getRemaining();
            BytecodeManager.incBytecodes(1);
            final int n = remaining;
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                final PushbackInputStream pushbackInputStream = (PushbackInputStream)this.in;
                final byte[] buf = this.buf;
                final int off = this.len - remaining;
                final int len = remaining;
                BytecodeManager.incBytecodes(11);
                pushbackInputStream.unread(buf, off, len);
            }
            final int n2 = this.flag & 0x8;
            final int n3 = 8;
            BytecodeManager.incBytecodes(6);
            Label_0534: {
                if (n2 == n3) {
                    final Inflater inf2 = this.inf;
                    BytecodeManager.incBytecodes(3);
                    final long n4 = lcmp(inf2.getBytesWritten(), 4294967295L);
                    BytecodeManager.incBytecodes(3);
                    if (n4 <= 0) {
                        final Inflater inf3 = this.inf;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final long n5 = lcmp(inf3.getBytesRead(), 4294967295L);
                        BytecodeManager.incBytecodes(3);
                        if (n5 <= 0) {
                            final byte[] tmpbuf = this.tmpbuf;
                            final int n6 = 0;
                            final int n7 = 16;
                            BytecodeManager.incBytecodes(6);
                            this.readFully(tmpbuf, n6, n7);
                            final byte[] tmpbuf2 = this.tmpbuf;
                            final int off2 = 0;
                            BytecodeManager.incBytecodes(4);
                            final long get32 = ZipUtils.get32(tmpbuf2, off2);
                            BytecodeManager.incBytecodes(1);
                            final long n8 = lcmp(get32, 134695760L);
                            BytecodeManager.incBytecodes(4);
                            if (n8 != 0) {
                                zipEntry.crc = get32;
                                BytecodeManager.incBytecodes(3);
                                final byte[] tmpbuf3 = this.tmpbuf;
                                final int off3 = 4;
                                BytecodeManager.incBytecodes(5);
                                zipEntry.csize = ZipUtils.get32(tmpbuf3, off3);
                                BytecodeManager.incBytecodes(1);
                                final byte[] tmpbuf4 = this.tmpbuf;
                                final int off4 = 8;
                                BytecodeManager.incBytecodes(5);
                                zipEntry.size = ZipUtils.get32(tmpbuf4, off4);
                                BytecodeManager.incBytecodes(1);
                                final PushbackInputStream pushbackInputStream2 = (PushbackInputStream)this.in;
                                final byte[] tmpbuf5 = this.tmpbuf;
                                final int off5 = 11;
                                final int len2 = 4;
                                BytecodeManager.incBytecodes(8);
                                pushbackInputStream2.unread(tmpbuf5, off5, len2);
                                BytecodeManager.incBytecodes(1);
                                break Label_0534;
                            }
                            final byte[] tmpbuf6 = this.tmpbuf;
                            final int off6 = 4;
                            BytecodeManager.incBytecodes(5);
                            zipEntry.crc = ZipUtils.get32(tmpbuf6, off6);
                            BytecodeManager.incBytecodes(1);
                            final byte[] tmpbuf7 = this.tmpbuf;
                            final int off7 = 8;
                            BytecodeManager.incBytecodes(5);
                            zipEntry.csize = ZipUtils.get32(tmpbuf7, off7);
                            BytecodeManager.incBytecodes(1);
                            final byte[] tmpbuf8 = this.tmpbuf;
                            final int off8 = 12;
                            BytecodeManager.incBytecodes(5);
                            zipEntry.size = ZipUtils.get32(tmpbuf8, off8);
                            BytecodeManager.incBytecodes(1);
                            break Label_0534;
                        }
                    }
                    final byte[] tmpbuf9 = this.tmpbuf;
                    final int n9 = 0;
                    final int n10 = 24;
                    BytecodeManager.incBytecodes(6);
                    this.readFully(tmpbuf9, n9, n10);
                    final byte[] tmpbuf10 = this.tmpbuf;
                    final int off9 = 0;
                    BytecodeManager.incBytecodes(4);
                    final long get33 = ZipUtils.get32(tmpbuf10, off9);
                    BytecodeManager.incBytecodes(1);
                    final long n11 = lcmp(get33, 134695760L);
                    BytecodeManager.incBytecodes(4);
                    if (n11 != 0) {
                        zipEntry.crc = get33;
                        BytecodeManager.incBytecodes(3);
                        final byte[] tmpbuf11 = this.tmpbuf;
                        final int off10 = 4;
                        BytecodeManager.incBytecodes(5);
                        zipEntry.csize = ZipUtils.get64(tmpbuf11, off10);
                        BytecodeManager.incBytecodes(1);
                        final byte[] tmpbuf12 = this.tmpbuf;
                        final int off11 = 12;
                        BytecodeManager.incBytecodes(5);
                        zipEntry.size = ZipUtils.get64(tmpbuf12, off11);
                        BytecodeManager.incBytecodes(1);
                        final PushbackInputStream pushbackInputStream3 = (PushbackInputStream)this.in;
                        final byte[] tmpbuf13 = this.tmpbuf;
                        final int off12 = 19;
                        final int len3 = 4;
                        BytecodeManager.incBytecodes(8);
                        pushbackInputStream3.unread(tmpbuf13, off12, len3);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final byte[] tmpbuf14 = this.tmpbuf;
                        final int off13 = 4;
                        BytecodeManager.incBytecodes(5);
                        zipEntry.crc = ZipUtils.get32(tmpbuf14, off13);
                        BytecodeManager.incBytecodes(1);
                        final byte[] tmpbuf15 = this.tmpbuf;
                        final int off14 = 8;
                        BytecodeManager.incBytecodes(5);
                        zipEntry.csize = ZipUtils.get64(tmpbuf15, off14);
                        BytecodeManager.incBytecodes(1);
                        final byte[] tmpbuf16 = this.tmpbuf;
                        final int off15 = 16;
                        BytecodeManager.incBytecodes(5);
                        zipEntry.size = ZipUtils.get64(tmpbuf16, off15);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            final long size = zipEntry.size;
            final Inflater inf4 = this.inf;
            BytecodeManager.incBytecodes(5);
            final long n12 = lcmp(size, inf4.getBytesWritten());
            BytecodeManager.incBytecodes(2);
            if (n12 != 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "invalid entry size (expected ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final long size2 = zipEntry.size;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append2 = append.append(size2);
                final String str2 = " but got ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final Inflater inf5 = this.inf;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final long bytesWritten = inf5.getBytesWritten();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(bytesWritten);
                final String str3 = " bytes)";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append5.toString();
                BytecodeManager.incBytecodes(1);
                final ZipException ex = new ZipException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long csize = zipEntry.csize;
            final Inflater inf6 = this.inf;
            BytecodeManager.incBytecodes(5);
            final long n13 = lcmp(csize, inf6.getBytesRead());
            BytecodeManager.incBytecodes(2);
            if (n13 != 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str4 = "invalid entry compressed size (expected ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = sb2.append(str4);
                final long csize2 = zipEntry.csize;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append7 = append6.append(csize2);
                final String str5 = " but got ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(str5);
                final Inflater inf7 = this.inf;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final long bytesRead = inf7.getBytesRead();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append9 = append8.append(bytesRead);
                final String str6 = " bytes)";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append10 = append9.append(str6);
                BytecodeManager.incBytecodes(1);
                final String string2 = append10.toString();
                BytecodeManager.incBytecodes(1);
                final ZipException ex2 = new ZipException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final long crc = zipEntry.crc;
            final CRC32 crc2 = this.crc;
            BytecodeManager.incBytecodes(5);
            final long n14 = lcmp(crc, crc2.getValue());
            BytecodeManager.incBytecodes(2);
            if (n14 != 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb3 = new StringBuilder();
                final String str7 = "invalid entry CRC (expected 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append11 = sb3.append(str7);
                final long crc3 = zipEntry.crc;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final String hexString = Long.toHexString(crc3);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append12 = append11.append(hexString);
                final String str8 = " but got 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append13 = append12.append(str8);
                final CRC32 crc4 = this.crc;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final long value = crc4.getValue();
                BytecodeManager.incBytecodes(1);
                final String hexString2 = Long.toHexString(value);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append14 = append13.append(hexString2);
                final String str9 = ")";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append15 = append14.append(str9);
                BytecodeManager.incBytecodes(1);
                final String string3 = append15.toString();
                BytecodeManager.incBytecodes(1);
                final ZipException ex3 = new ZipException(string3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readFully(final byte[] b, int n, int n2) throws IOException {
        try {
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 <= 0) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final InputStream in = this.in;
                final int off = n;
                final int len = n2;
                BytecodeManager.incBytecodes(6);
                final int read = in.read(b, off, len);
                BytecodeManager.incBytecodes(1);
                final int n4 = read;
                final int n5 = -1;
                BytecodeManager.incBytecodes(3);
                if (n4 == n5) {
                    BytecodeManager.incBytecodes(3);
                    final EOFException ex = new EOFException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                n += read;
                BytecodeManager.incBytecodes(4);
                n2 -= read;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
