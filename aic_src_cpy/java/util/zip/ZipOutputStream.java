// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;
import java.nio.file.attribute.FileTime;
import java.util.Iterator;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.IOException;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.HashSet;
import instrumented.java.util.Vector;

public class ZipOutputStream extends DeflaterOutputStream implements ZipConstants
{
    private static final boolean inhibitZip64;
    private XEntry current;
    private Vector<XEntry> xentries;
    private HashSet<String> names;
    private CRC32 crc;
    private long written;
    private long locoff;
    private byte[] comment;
    private int method;
    private boolean finished;
    private boolean closed;
    private final ZipCoder zc;
    public static final int STORED = 0;
    public static final int DEFLATED = 8;
    
    private static int version(final ZipEntry zipEntry) throws ZipException {
        try {
            final int method = zipEntry.method;
            BytecodeManager.incBytecodes(3);
            switch (method) {
                case 8: {
                    final int n = 20;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                case 0: {
                    final int n2 = 10;
                    BytecodeManager.incBytecodes(2);
                    return n2;
                }
                default: {
                    final String s = "unsupported compression method";
                    BytecodeManager.incBytecodes(4);
                    final ZipException ex = new ZipException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
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
    
    public ZipOutputStream(final OutputStream outputStream) {
        try {
            final Charset utf_8 = StandardCharsets.UTF_8;
            BytecodeManager.incBytecodes(4);
            this(outputStream, utf_8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipOutputStream(final OutputStream out, final Charset charset) {
        try {
            final int level = -1;
            final boolean nowrap = true;
            BytecodeManager.incBytecodes(7);
            final Deflater def = new Deflater(level, nowrap);
            BytecodeManager.incBytecodes(1);
            super(out, def);
            BytecodeManager.incBytecodes(4);
            this.xentries = new Vector<XEntry>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.names = new HashSet<String>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.crc = new CRC32();
            BytecodeManager.incBytecodes(1);
            this.written = 0L;
            BytecodeManager.incBytecodes(3);
            this.locoff = 0L;
            BytecodeManager.incBytecodes(3);
            this.method = 8;
            BytecodeManager.incBytecodes(3);
            this.closed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (charset == null) {
                final String s = "charset is null";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            this.zc = ZipCoder.get(charset);
            BytecodeManager.incBytecodes(1);
            this.usesDefaultDeflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setComment(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            if (s != null) {
                final ZipCoder zc = this.zc;
                BytecodeManager.incBytecodes(5);
                this.comment = zc.getBytes(s);
                BytecodeManager.incBytecodes(1);
                final int length = this.comment.length;
                final int n = 65535;
                BytecodeManager.incBytecodes(5);
                if (length > n) {
                    final String s2 = "ZIP file comment too long.";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setMethod(final int method) {
        try {
            final int n = 8;
            BytecodeManager.incBytecodes(3);
            if (method != n) {
                BytecodeManager.incBytecodes(2);
                if (method != 0) {
                    final String s = "invalid compression method";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            this.method = method;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setLevel(final int level) {
        try {
            final Deflater def = this.def;
            BytecodeManager.incBytecodes(4);
            def.setLevel(level);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void putNextEntry(final ZipEntry entry) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final XEntry current = this.current;
            BytecodeManager.incBytecodes(3);
            if (current != null) {
                BytecodeManager.incBytecodes(2);
                this.closeEntry();
            }
            final long n = lcmp(entry.xdostime, -1L);
            BytecodeManager.incBytecodes(5);
            if (n == 0) {
                BytecodeManager.incBytecodes(2);
                final long currentTimeMillis = System.currentTimeMillis();
                BytecodeManager.incBytecodes(1);
                entry.setTime(currentTimeMillis);
            }
            final int method = entry.method;
            final int n2 = -1;
            BytecodeManager.incBytecodes(4);
            if (method == n2) {
                entry.method = this.method;
                BytecodeManager.incBytecodes(4);
            }
            entry.flag = 0;
            BytecodeManager.incBytecodes(3);
            final int method2 = entry.method;
            BytecodeManager.incBytecodes(3);
            switch (method2) {
                case 8: {
                    final long n3 = lcmp(entry.size, -1L);
                    BytecodeManager.incBytecodes(5);
                    if (n3 != 0) {
                        final long n4 = lcmp(entry.csize, -1L);
                        BytecodeManager.incBytecodes(5);
                        if (n4 != 0) {
                            final long n5 = lcmp(entry.crc, -1L);
                            BytecodeManager.incBytecodes(5);
                            if (n5 != 0) {
                                break;
                            }
                        }
                    }
                    entry.flag = 8;
                    BytecodeManager.incBytecodes(4);
                    break;
                }
                case 0: {
                    final long n6 = lcmp(entry.size, -1L);
                    BytecodeManager.incBytecodes(5);
                    if (n6 == 0) {
                        entry.size = entry.csize;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        final long n7 = lcmp(entry.csize, -1L);
                        BytecodeManager.incBytecodes(5);
                        if (n7 == 0) {
                            entry.csize = entry.size;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            final long n8 = lcmp(entry.size, entry.csize);
                            BytecodeManager.incBytecodes(6);
                            if (n8 != 0) {
                                final String s = "STORED entry where compressed != uncompressed size";
                                BytecodeManager.incBytecodes(4);
                                final ZipException ex = new ZipException(s);
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                        }
                    }
                    final long n9 = lcmp(entry.size, -1L);
                    BytecodeManager.incBytecodes(5);
                    if (n9 != 0) {
                        final long n10 = lcmp(entry.crc, -1L);
                        BytecodeManager.incBytecodes(5);
                        if (n10 != 0) {
                            break;
                        }
                    }
                    final String s2 = "STORED entry missing size, compressed size, or crc-32";
                    BytecodeManager.incBytecodes(4);
                    final ZipException ex2 = new ZipException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                default: {
                    final String s3 = "unsupported compression method";
                    BytecodeManager.incBytecodes(4);
                    final ZipException ex3 = new ZipException(s3);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
            }
            final HashSet<String> names = this.names;
            final String name = entry.name;
            BytecodeManager.incBytecodes(5);
            final boolean add = names.add(name);
            BytecodeManager.incBytecodes(1);
            if (!add) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "duplicate entry: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String name2 = entry.name;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append2 = append.append(name2);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final ZipException ex4 = new ZipException(string);
                BytecodeManager.incBytecodes(1);
                throw ex4;
            }
            final ZipCoder zc = this.zc;
            BytecodeManager.incBytecodes(3);
            final boolean utf8 = zc.isUTF8();
            BytecodeManager.incBytecodes(1);
            if (utf8) {
                entry.flag |= 0x800;
                BytecodeManager.incBytecodes(6);
            }
            final long written = this.written;
            BytecodeManager.incBytecodes(7);
            this.current = new XEntry(entry, written);
            BytecodeManager.incBytecodes(1);
            final Vector<XEntry> xentries = this.xentries;
            final XEntry current2 = this.current;
            BytecodeManager.incBytecodes(5);
            xentries.add(current2);
            BytecodeManager.incBytecodes(1);
            final XEntry current3 = this.current;
            BytecodeManager.incBytecodes(4);
            this.writeLOC(current3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void closeEntry() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final XEntry current = this.current;
            BytecodeManager.incBytecodes(3);
            if (current != null) {
                final ZipEntry entry = this.current.entry;
                BytecodeManager.incBytecodes(4);
                final int method = entry.method;
                BytecodeManager.incBytecodes(3);
                switch (method) {
                    case 8: {
                        final Deflater def = this.def;
                        BytecodeManager.incBytecodes(3);
                        def.finish();
                        while (true) {
                            final Deflater def2 = this.def;
                            BytecodeManager.incBytecodes(3);
                            final boolean finished = def2.finished();
                            BytecodeManager.incBytecodes(1);
                            if (finished) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            this.deflate();
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n = entry.flag & 0x8;
                        BytecodeManager.incBytecodes(5);
                        if (n == 0) {
                            final long size = entry.size;
                            final Deflater def3 = this.def;
                            BytecodeManager.incBytecodes(5);
                            final long n2 = lcmp(size, def3.getBytesRead());
                            BytecodeManager.incBytecodes(2);
                            if (n2 != 0) {
                                BytecodeManager.incBytecodes(5);
                                final StringBuilder sb = new StringBuilder();
                                final String str = "invalid entry size (expected ";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append = sb.append(str);
                                final long size2 = entry.size;
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder append2 = append.append(size2);
                                final String str2 = " but got ";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append3 = append2.append(str2);
                                final Deflater def4 = this.def;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final long bytesRead = def4.getBytesRead();
                                BytecodeManager.incBytecodes(1);
                                final StringBuilder append4 = append3.append(bytesRead);
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
                            final long csize = entry.csize;
                            final Deflater def5 = this.def;
                            BytecodeManager.incBytecodes(5);
                            final long n3 = lcmp(csize, def5.getBytesWritten());
                            BytecodeManager.incBytecodes(2);
                            if (n3 != 0) {
                                BytecodeManager.incBytecodes(5);
                                final StringBuilder sb2 = new StringBuilder();
                                final String str4 = "invalid entry compressed size (expected ";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append6 = sb2.append(str4);
                                final long csize2 = entry.csize;
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder append7 = append6.append(csize2);
                                final String str5 = " but got ";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append8 = append7.append(str5);
                                final Deflater def6 = this.def;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final long bytesWritten = def6.getBytesWritten();
                                BytecodeManager.incBytecodes(1);
                                final StringBuilder append9 = append8.append(bytesWritten);
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
                            final long crc = entry.crc;
                            final CRC32 crc2 = this.crc;
                            BytecodeManager.incBytecodes(5);
                            final long n4 = lcmp(crc, crc2.getValue());
                            BytecodeManager.incBytecodes(2);
                            if (n4 != 0) {
                                BytecodeManager.incBytecodes(5);
                                final StringBuilder sb3 = new StringBuilder();
                                final String str7 = "invalid entry CRC-32 (expected 0x";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append11 = sb3.append(str7);
                                final long crc3 = entry.crc;
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
                        }
                        else {
                            final ZipEntry zipEntry = entry;
                            final Deflater def7 = this.def;
                            BytecodeManager.incBytecodes(4);
                            zipEntry.size = def7.getBytesRead();
                            BytecodeManager.incBytecodes(1);
                            final ZipEntry zipEntry2 = entry;
                            final Deflater def8 = this.def;
                            BytecodeManager.incBytecodes(4);
                            zipEntry2.csize = def8.getBytesWritten();
                            BytecodeManager.incBytecodes(1);
                            final ZipEntry zipEntry3 = entry;
                            final CRC32 crc5 = this.crc;
                            BytecodeManager.incBytecodes(4);
                            zipEntry3.crc = crc5.getValue();
                            BytecodeManager.incBytecodes(1);
                            final ZipEntry zipEntry4 = entry;
                            BytecodeManager.incBytecodes(3);
                            this.writeEXT(zipEntry4);
                        }
                        final Deflater def9 = this.def;
                        BytecodeManager.incBytecodes(3);
                        def9.reset();
                        this.written += entry.csize;
                        BytecodeManager.incBytecodes(7);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 0: {
                        final long n5 = lcmp(entry.size, this.written - this.locoff);
                        BytecodeManager.incBytecodes(9);
                        if (n5 != 0) {
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb4 = new StringBuilder();
                            final String str10 = "invalid entry size (expected ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append16 = sb4.append(str10);
                            final long size3 = entry.size;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append17 = append16.append(size3);
                            final String str11 = " but got ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append18 = append17.append(str11);
                            final long lng = this.written - this.locoff;
                            BytecodeManager.incBytecodes(6);
                            final StringBuilder append19 = append18.append(lng);
                            final String str12 = " bytes)";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append20 = append19.append(str12);
                            BytecodeManager.incBytecodes(1);
                            final String string4 = append20.toString();
                            BytecodeManager.incBytecodes(1);
                            final ZipException ex4 = new ZipException(string4);
                            BytecodeManager.incBytecodes(1);
                            throw ex4;
                        }
                        final long crc6 = entry.crc;
                        final CRC32 crc7 = this.crc;
                        BytecodeManager.incBytecodes(5);
                        final long n6 = lcmp(crc6, crc7.getValue());
                        BytecodeManager.incBytecodes(2);
                        if (n6 != 0) {
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb5 = new StringBuilder();
                            final String str13 = "invalid entry crc-32 (expected 0x";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append21 = sb5.append(str13);
                            final long crc8 = entry.crc;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final String hexString3 = Long.toHexString(crc8);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append22 = append21.append(hexString3);
                            final String str14 = " but got 0x";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append23 = append22.append(str14);
                            final CRC32 crc9 = this.crc;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final long value2 = crc9.getValue();
                            BytecodeManager.incBytecodes(1);
                            final String hexString4 = Long.toHexString(value2);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append24 = append23.append(hexString4);
                            final String str15 = ")";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append25 = append24.append(str15);
                            BytecodeManager.incBytecodes(1);
                            final String string5 = append25.toString();
                            BytecodeManager.incBytecodes(1);
                            final ZipException ex5 = new ZipException(string5);
                            BytecodeManager.incBytecodes(1);
                            throw ex5;
                        }
                        break;
                    }
                    default: {
                        final String s = "invalid compression method";
                        BytecodeManager.incBytecodes(4);
                        final ZipException ex6 = new ZipException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex6;
                    }
                }
                final CRC32 crc10 = this.crc;
                BytecodeManager.incBytecodes(3);
                crc10.reset();
                this.current = null;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void write(final byte[] b, final int off, final int len) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (off >= 0) {
                BytecodeManager.incBytecodes(2);
                if (len >= 0) {
                    final int n = b.length - len;
                    BytecodeManager.incBytecodes(6);
                    if (off <= n) {
                        BytecodeManager.incBytecodes(2);
                        if (len == 0) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final XEntry current = this.current;
                        BytecodeManager.incBytecodes(3);
                        if (current == null) {
                            final String s = "no current ZIP entry";
                            BytecodeManager.incBytecodes(4);
                            final ZipException ex = new ZipException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        final ZipEntry entry = this.current.entry;
                        BytecodeManager.incBytecodes(4);
                        final int method = entry.method;
                        BytecodeManager.incBytecodes(3);
                        switch (method) {
                            case 8: {
                                BytecodeManager.incBytecodes(5);
                                super.write(b, off, len);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            case 0: {
                                this.written += len;
                                BytecodeManager.incBytecodes(7);
                                final long n2 = lcmp(this.written - this.locoff, entry.size);
                                BytecodeManager.incBytecodes(9);
                                if (n2 > 0) {
                                    final String s2 = "attempt to write past end of STORED entry";
                                    BytecodeManager.incBytecodes(4);
                                    final ZipException ex2 = new ZipException(s2);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex2;
                                }
                                final OutputStream out = this.out;
                                BytecodeManager.incBytecodes(6);
                                out.write(b, off, len);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            default: {
                                final String s3 = "invalid compression method";
                                BytecodeManager.incBytecodes(4);
                                final ZipException ex3 = new ZipException(s3);
                                BytecodeManager.incBytecodes(1);
                                throw ex3;
                            }
                        }
                        final CRC32 crc = this.crc;
                        BytecodeManager.incBytecodes(6);
                        crc.update(b, off, len);
                        BytecodeManager.incBytecodes(1);
                        return;
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
    public void finish() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final boolean finished = this.finished;
            BytecodeManager.incBytecodes(3);
            if (finished) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final XEntry current = this.current;
            BytecodeManager.incBytecodes(3);
            if (current != null) {
                BytecodeManager.incBytecodes(2);
                this.closeEntry();
            }
            final long written = this.written;
            BytecodeManager.incBytecodes(3);
            final Vector<XEntry> xentries = this.xentries;
            BytecodeManager.incBytecodes(3);
            final Iterator<XEntry> iterator = xentries.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<XEntry> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<XEntry> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final XEntry xEntry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final XEntry xEntry2 = xEntry;
                BytecodeManager.incBytecodes(3);
                this.writeCEN(xEntry2);
                BytecodeManager.incBytecodes(1);
            }
            final long n = written;
            final long n2 = this.written - written;
            BytecodeManager.incBytecodes(7);
            this.writeEND(n, n2);
            this.finished = true;
            BytecodeManager.incBytecodes(3);
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
    
    private void writeLOC(final XEntry xEntry) throws IOException {
        try {
            final ZipEntry entry = xEntry.entry;
            BytecodeManager.incBytecodes(3);
            final int flag = entry.flag;
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            final byte[] extra = entry.extra;
            BytecodeManager.incBytecodes(4);
            int extraLen = this.getExtraLen(extra);
            BytecodeManager.incBytecodes(1);
            final long n = 67324752L;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n);
            final int n2 = flag & 0x8;
            final int n3 = 8;
            BytecodeManager.incBytecodes(5);
            if (n2 == n3) {
                final ZipEntry zipEntry = entry;
                BytecodeManager.incBytecodes(3);
                final int version = version(zipEntry);
                BytecodeManager.incBytecodes(1);
                this.writeShort(version);
                final int n4 = flag;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n4);
                final int method = entry.method;
                BytecodeManager.incBytecodes(4);
                this.writeShort(method);
                final long xdostime = entry.xdostime;
                BytecodeManager.incBytecodes(4);
                this.writeInt(xdostime);
                final long n5 = 0L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n5);
                final long n6 = 0L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n6);
                final long n7 = 0L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n7);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final long n8 = lcmp(entry.csize, 4294967295L);
                BytecodeManager.incBytecodes(5);
                Label_0243: {
                    if (n8 < 0) {
                        final long n9 = lcmp(entry.size, 4294967295L);
                        BytecodeManager.incBytecodes(5);
                        if (n9 < 0) {
                            final ZipEntry zipEntry2 = entry;
                            BytecodeManager.incBytecodes(3);
                            final int version2 = version(zipEntry2);
                            BytecodeManager.incBytecodes(1);
                            this.writeShort(version2);
                            break Label_0243;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                    final int n10 = 45;
                    BytecodeManager.incBytecodes(3);
                    this.writeShort(n10);
                    BytecodeManager.incBytecodes(1);
                }
                final int n11 = flag;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n11);
                final int method2 = entry.method;
                BytecodeManager.incBytecodes(4);
                this.writeShort(method2);
                final long xdostime2 = entry.xdostime;
                BytecodeManager.incBytecodes(4);
                this.writeInt(xdostime2);
                final long crc = entry.crc;
                BytecodeManager.incBytecodes(4);
                this.writeInt(crc);
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                if (b2) {
                    final long n12 = 4294967295L;
                    BytecodeManager.incBytecodes(3);
                    this.writeInt(n12);
                    final long n13 = 4294967295L;
                    BytecodeManager.incBytecodes(3);
                    this.writeInt(n13);
                    extraLen += 20;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long csize = entry.csize;
                    BytecodeManager.incBytecodes(4);
                    this.writeInt(csize);
                    final long size = entry.size;
                    BytecodeManager.incBytecodes(4);
                    this.writeInt(size);
                }
            }
            final ZipCoder zc = this.zc;
            final String name = entry.name;
            BytecodeManager.incBytecodes(5);
            final byte[] bytes = zc.getBytes(name);
            BytecodeManager.incBytecodes(1);
            final int length = bytes.length;
            BytecodeManager.incBytecodes(4);
            this.writeShort(length);
            int n14 = 0;
            BytecodeManager.incBytecodes(2);
            int n15 = 0;
            BytecodeManager.incBytecodes(2);
            final FileTime mtime = entry.mtime;
            BytecodeManager.incBytecodes(3);
            if (mtime != null) {
                n14 += 4;
                BytecodeManager.incBytecodes(1);
                n15 |= 0x1;
                BytecodeManager.incBytecodes(4);
            }
            final FileTime atime = entry.atime;
            BytecodeManager.incBytecodes(3);
            if (atime != null) {
                n14 += 4;
                BytecodeManager.incBytecodes(1);
                n15 |= 0x2;
                BytecodeManager.incBytecodes(4);
            }
            final FileTime ctime = entry.ctime;
            BytecodeManager.incBytecodes(3);
            if (ctime != null) {
                n14 += 4;
                BytecodeManager.incBytecodes(1);
                n15 |= 0x4;
                BytecodeManager.incBytecodes(4);
            }
            final int n16 = n15;
            BytecodeManager.incBytecodes(2);
            if (n16 != 0) {
                extraLen += n14 + 5;
                BytecodeManager.incBytecodes(6);
            }
            final int n17 = extraLen;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n17);
            final byte[] array = bytes;
            final int n18 = 0;
            final int length2 = bytes.length;
            BytecodeManager.incBytecodes(6);
            this.writeBytes(array, n18, length2);
            final boolean b3 = b;
            BytecodeManager.incBytecodes(2);
            if (b3) {
                final int n19 = 1;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n19);
                final int n20 = 16;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n20);
                final long size2 = entry.size;
                BytecodeManager.incBytecodes(4);
                this.writeLong(size2);
                final long csize2 = entry.csize;
                BytecodeManager.incBytecodes(4);
                this.writeLong(csize2);
            }
            final int n21 = n15;
            BytecodeManager.incBytecodes(2);
            if (n21 != 0) {
                final int n22 = 21589;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n22);
                final int n23 = n14 + 1;
                BytecodeManager.incBytecodes(5);
                this.writeShort(n23);
                final int n24 = n15;
                BytecodeManager.incBytecodes(3);
                this.writeByte(n24);
                final FileTime mtime2 = entry.mtime;
                BytecodeManager.incBytecodes(3);
                if (mtime2 != null) {
                    final FileTime mtime3 = entry.mtime;
                    BytecodeManager.incBytecodes(4);
                    final long fileTimeToUnixTime = ZipUtils.fileTimeToUnixTime(mtime3);
                    BytecodeManager.incBytecodes(1);
                    this.writeInt(fileTimeToUnixTime);
                }
                final FileTime atime2 = entry.atime;
                BytecodeManager.incBytecodes(3);
                if (atime2 != null) {
                    final FileTime atime3 = entry.atime;
                    BytecodeManager.incBytecodes(4);
                    final long fileTimeToUnixTime2 = ZipUtils.fileTimeToUnixTime(atime3);
                    BytecodeManager.incBytecodes(1);
                    this.writeInt(fileTimeToUnixTime2);
                }
                final FileTime ctime2 = entry.ctime;
                BytecodeManager.incBytecodes(3);
                if (ctime2 != null) {
                    final FileTime ctime3 = entry.ctime;
                    BytecodeManager.incBytecodes(4);
                    final long fileTimeToUnixTime3 = ZipUtils.fileTimeToUnixTime(ctime3);
                    BytecodeManager.incBytecodes(1);
                    this.writeInt(fileTimeToUnixTime3);
                }
            }
            final byte[] extra2 = entry.extra;
            BytecodeManager.incBytecodes(4);
            this.writeExtra(extra2);
            this.locoff = this.written;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeEXT(final ZipEntry zipEntry) throws IOException {
        try {
            final long n = 134695760L;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n);
            final long crc = zipEntry.crc;
            BytecodeManager.incBytecodes(4);
            this.writeInt(crc);
            final long n2 = lcmp(zipEntry.csize, 4294967295L);
            BytecodeManager.incBytecodes(5);
            Label_0117: {
                if (n2 < 0) {
                    final long n3 = lcmp(zipEntry.size, 4294967295L);
                    BytecodeManager.incBytecodes(5);
                    if (n3 < 0) {
                        final long csize = zipEntry.csize;
                        BytecodeManager.incBytecodes(4);
                        this.writeInt(csize);
                        final long size = zipEntry.size;
                        BytecodeManager.incBytecodes(4);
                        this.writeInt(size);
                        break Label_0117;
                    }
                }
                final long csize2 = zipEntry.csize;
                BytecodeManager.incBytecodes(4);
                this.writeLong(csize2);
                final long size2 = zipEntry.size;
                BytecodeManager.incBytecodes(4);
                this.writeLong(size2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeCEN(final XEntry xEntry) throws IOException {
        try {
            final ZipEntry entry = xEntry.entry;
            BytecodeManager.incBytecodes(3);
            final int flag = entry.flag;
            BytecodeManager.incBytecodes(3);
            final ZipEntry zipEntry = entry;
            BytecodeManager.incBytecodes(2);
            final int version = version(zipEntry);
            BytecodeManager.incBytecodes(1);
            long csize = entry.csize;
            BytecodeManager.incBytecodes(3);
            long size = entry.size;
            BytecodeManager.incBytecodes(3);
            long offset = xEntry.offset;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            final long n2 = lcmp(entry.csize, 4294967295L);
            BytecodeManager.incBytecodes(5);
            if (n2 >= 0) {
                csize = 4294967295L;
                BytecodeManager.incBytecodes(2);
                n += 8;
                BytecodeManager.incBytecodes(1);
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            final long n3 = lcmp(entry.size, 4294967295L);
            BytecodeManager.incBytecodes(5);
            if (n3 >= 0) {
                size = 4294967295L;
                BytecodeManager.incBytecodes(2);
                n += 8;
                BytecodeManager.incBytecodes(1);
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            final long n4 = lcmp(xEntry.offset, 4294967295L);
            BytecodeManager.incBytecodes(5);
            if (n4 >= 0) {
                offset = 4294967295L;
                BytecodeManager.incBytecodes(2);
                n += 8;
                BytecodeManager.incBytecodes(1);
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            final long n5 = 33639248L;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n5);
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            if (b2) {
                final int n6 = 45;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n6);
                final int n7 = 45;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n7);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n8 = version;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n8);
                final int n9 = version;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n9);
            }
            final int n10 = flag;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n10);
            final int method = entry.method;
            BytecodeManager.incBytecodes(4);
            this.writeShort(method);
            final long xdostime = entry.xdostime;
            BytecodeManager.incBytecodes(4);
            this.writeInt(xdostime);
            final long crc = entry.crc;
            BytecodeManager.incBytecodes(4);
            this.writeInt(crc);
            final long n11 = csize;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n11);
            final long n12 = size;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n12);
            final ZipCoder zc = this.zc;
            final String name = entry.name;
            BytecodeManager.incBytecodes(5);
            final byte[] bytes = zc.getBytes(name);
            BytecodeManager.incBytecodes(1);
            final int length = bytes.length;
            BytecodeManager.incBytecodes(4);
            this.writeShort(length);
            final byte[] extra = entry.extra;
            BytecodeManager.incBytecodes(4);
            int extraLen = this.getExtraLen(extra);
            BytecodeManager.incBytecodes(1);
            final boolean b3 = b;
            BytecodeManager.incBytecodes(2);
            if (b3) {
                extraLen += n + 4;
                BytecodeManager.incBytecodes(6);
            }
            int n13 = 0;
            BytecodeManager.incBytecodes(2);
            final FileTime mtime = entry.mtime;
            BytecodeManager.incBytecodes(3);
            if (mtime != null) {
                extraLen += 4;
                BytecodeManager.incBytecodes(1);
                n13 |= 0x1;
                BytecodeManager.incBytecodes(4);
            }
            final FileTime atime = entry.atime;
            BytecodeManager.incBytecodes(3);
            if (atime != null) {
                n13 |= 0x2;
                BytecodeManager.incBytecodes(4);
            }
            final FileTime ctime = entry.ctime;
            BytecodeManager.incBytecodes(3);
            if (ctime != null) {
                n13 |= 0x4;
                BytecodeManager.incBytecodes(4);
            }
            final int n14 = n13;
            BytecodeManager.incBytecodes(2);
            if (n14 != 0) {
                extraLen += 5;
                BytecodeManager.incBytecodes(1);
            }
            final int n15 = extraLen;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n15);
            final String comment = entry.comment;
            BytecodeManager.incBytecodes(3);
            byte[] bytes2;
            if (comment != null) {
                final ZipCoder zc2 = this.zc;
                final String comment2 = entry.comment;
                BytecodeManager.incBytecodes(5);
                bytes2 = zc2.getBytes(comment2);
                BytecodeManager.incBytecodes(1);
                final int length2 = bytes2.length;
                final int b4 = 65535;
                BytecodeManager.incBytecodes(5);
                final int min = Math.min(length2, b4);
                BytecodeManager.incBytecodes(1);
                this.writeShort(min);
                BytecodeManager.incBytecodes(1);
            }
            else {
                bytes2 = null;
                BytecodeManager.incBytecodes(2);
                final int n16 = 0;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n16);
            }
            final int n17 = 0;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n17);
            final int n18 = 0;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n18);
            final long n19 = 0L;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n19);
            final long n20 = offset;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n20);
            final byte[] array = bytes;
            final int n21 = 0;
            final int length3 = bytes.length;
            BytecodeManager.incBytecodes(6);
            this.writeBytes(array, n21, length3);
            final boolean b5 = b;
            BytecodeManager.incBytecodes(2);
            if (b5) {
                final int n22 = 1;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n22);
                final int n23 = n;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n23);
                final long n24 = lcmp(size, 4294967295L);
                BytecodeManager.incBytecodes(4);
                if (n24 == 0) {
                    final long size2 = entry.size;
                    BytecodeManager.incBytecodes(4);
                    this.writeLong(size2);
                }
                final long n25 = lcmp(csize, 4294967295L);
                BytecodeManager.incBytecodes(4);
                if (n25 == 0) {
                    final long csize2 = entry.csize;
                    BytecodeManager.incBytecodes(4);
                    this.writeLong(csize2);
                }
                final long n26 = lcmp(offset, 4294967295L);
                BytecodeManager.incBytecodes(4);
                if (n26 == 0) {
                    final long offset2 = xEntry.offset;
                    BytecodeManager.incBytecodes(4);
                    this.writeLong(offset2);
                }
            }
            final boolean b6 = n13 != 0;
            BytecodeManager.incBytecodes(2);
            if (b6) {
                final int n27 = 21589;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n27);
                final FileTime mtime2 = entry.mtime;
                BytecodeManager.incBytecodes(3);
                if (mtime2 != null) {
                    final int n28 = 5;
                    BytecodeManager.incBytecodes(3);
                    this.writeShort(n28);
                    final int n29 = n13;
                    BytecodeManager.incBytecodes(3);
                    this.writeByte(n29);
                    final FileTime mtime3 = entry.mtime;
                    BytecodeManager.incBytecodes(4);
                    final long fileTimeToUnixTime = ZipUtils.fileTimeToUnixTime(mtime3);
                    BytecodeManager.incBytecodes(1);
                    this.writeInt(fileTimeToUnixTime);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n30 = 1;
                    BytecodeManager.incBytecodes(3);
                    this.writeShort(n30);
                    final int n31 = n13;
                    BytecodeManager.incBytecodes(3);
                    this.writeByte(n31);
                }
            }
            final byte[] extra2 = entry.extra;
            BytecodeManager.incBytecodes(4);
            this.writeExtra(extra2);
            final byte[] array2 = bytes2;
            BytecodeManager.incBytecodes(2);
            if (array2 != null) {
                final byte[] array3 = bytes2;
                final int n32 = 0;
                final int length4 = bytes2.length;
                final int b7 = 65535;
                BytecodeManager.incBytecodes(7);
                final int min2 = Math.min(length4, b7);
                BytecodeManager.incBytecodes(1);
                this.writeBytes(array3, n32, min2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeEND(final long n, final long n2) throws IOException {
        try {
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            long n4 = n2;
            BytecodeManager.incBytecodes(2);
            long n5 = n;
            BytecodeManager.incBytecodes(2);
            final long n6 = lcmp(n4, 4294967295L);
            BytecodeManager.incBytecodes(4);
            if (n6 >= 0) {
                n4 = 4294967295L;
                BytecodeManager.incBytecodes(2);
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            final long n7 = lcmp(n5, 4294967295L);
            BytecodeManager.incBytecodes(4);
            if (n7 >= 0) {
                n5 = 4294967295L;
                BytecodeManager.incBytecodes(2);
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            final Vector<XEntry> xentries = this.xentries;
            BytecodeManager.incBytecodes(3);
            int size = xentries.size();
            BytecodeManager.incBytecodes(1);
            final int n8 = size;
            final int n9 = 65535;
            BytecodeManager.incBytecodes(3);
            if (n8 >= n9) {
                final int n10 = n3;
                final boolean inhibitZip64 = ZipOutputStream.inhibitZip64;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (!inhibitZip64) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
                n3 = (n10 | (b ? 1 : 0));
                BytecodeManager.incBytecodes(2);
                final int n11 = n3;
                BytecodeManager.incBytecodes(2);
                if (n11 != 0) {
                    size = 65535;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n12 = n3;
            BytecodeManager.incBytecodes(2);
            if (n12 != 0) {
                final long written = this.written;
                BytecodeManager.incBytecodes(3);
                final long n13 = 101075792L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n13);
                final long n14 = 44L;
                BytecodeManager.incBytecodes(3);
                this.writeLong(n14);
                final int n15 = 45;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n15);
                final int n16 = 45;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n16);
                final long n17 = 0L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n17);
                final long n18 = 0L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n18);
                final Vector<XEntry> xentries2 = this.xentries;
                BytecodeManager.incBytecodes(4);
                final long n19 = xentries2.size();
                BytecodeManager.incBytecodes(2);
                this.writeLong(n19);
                final Vector<XEntry> xentries3 = this.xentries;
                BytecodeManager.incBytecodes(4);
                final long n20 = xentries3.size();
                BytecodeManager.incBytecodes(2);
                this.writeLong(n20);
                BytecodeManager.incBytecodes(3);
                this.writeLong(n2);
                BytecodeManager.incBytecodes(3);
                this.writeLong(n);
                final long n21 = 117853008L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n21);
                final long n22 = 0L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n22);
                final long n23 = written;
                BytecodeManager.incBytecodes(3);
                this.writeLong(n23);
                final long n24 = 1L;
                BytecodeManager.incBytecodes(3);
                this.writeInt(n24);
            }
            final long n25 = 101010256L;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n25);
            final int n26 = 0;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n26);
            final int n27 = 0;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n27);
            final int n28 = size;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n28);
            final int n29 = size;
            BytecodeManager.incBytecodes(3);
            this.writeShort(n29);
            final long n30 = n4;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n30);
            final long n31 = n5;
            BytecodeManager.incBytecodes(3);
            this.writeInt(n31);
            final byte[] comment = this.comment;
            BytecodeManager.incBytecodes(3);
            if (comment != null) {
                final int length = this.comment.length;
                BytecodeManager.incBytecodes(5);
                this.writeShort(length);
                final byte[] comment2 = this.comment;
                final int n32 = 0;
                final int length2 = this.comment.length;
                BytecodeManager.incBytecodes(8);
                this.writeBytes(comment2, n32, length2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n33 = 0;
                BytecodeManager.incBytecodes(3);
                this.writeShort(n33);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int getExtraLen(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3 + 4;
                final int n5 = length;
                BytecodeManager.incBytecodes(5);
                if (n4 > n5) {
                    break;
                }
                final int off = n3;
                BytecodeManager.incBytecodes(3);
                final int get16 = ZipUtils.get16(array, off);
                BytecodeManager.incBytecodes(1);
                final int off2 = n3 + 2;
                BytecodeManager.incBytecodes(5);
                final int get17 = ZipUtils.get16(array, off2);
                BytecodeManager.incBytecodes(1);
                final int n6 = get17;
                BytecodeManager.incBytecodes(2);
                if (n6 < 0) {
                    break;
                }
                final int n7 = n3 + 4 + get17;
                final int n8 = length;
                BytecodeManager.incBytecodes(7);
                if (n7 > n8) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final int n9 = get16;
                final int n10 = 21589;
                BytecodeManager.incBytecodes(3);
                Label_0160: {
                    if (n9 != n10) {
                        final int n11 = get16;
                        final int n12 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n11 != n12) {
                            break Label_0160;
                        }
                    }
                    n2 += get17 + 4;
                    BytecodeManager.incBytecodes(6);
                }
                n3 += get17 + 4;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            final int n13 = length - n2;
            BytecodeManager.incBytecodes(4);
            return n13;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeExtra(final byte[] array) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                final int length = array.length;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                Label_0176: {
                    while (true) {
                        final int n2 = n + 4;
                        final int n3 = length;
                        BytecodeManager.incBytecodes(5);
                        if (n2 > n3) {
                            break Label_0176;
                        }
                        final int off = n;
                        BytecodeManager.incBytecodes(3);
                        final int get16 = ZipUtils.get16(array, off);
                        BytecodeManager.incBytecodes(1);
                        final int off2 = n + 2;
                        BytecodeManager.incBytecodes(5);
                        final int get17 = ZipUtils.get16(array, off2);
                        BytecodeManager.incBytecodes(1);
                        final int n4 = get17;
                        BytecodeManager.incBytecodes(2);
                        if (n4 < 0) {
                            break;
                        }
                        final int n5 = n + 4 + get17;
                        final int n6 = length;
                        BytecodeManager.incBytecodes(7);
                        if (n5 > n6) {
                            break;
                        }
                        final int n7 = get16;
                        final int n8 = 21589;
                        BytecodeManager.incBytecodes(3);
                        if (n7 != n8) {
                            final int n9 = get16;
                            final int n10 = 1;
                            BytecodeManager.incBytecodes(3);
                            if (n9 != n10) {
                                final int n11 = n;
                                final int n12 = get17 + 4;
                                BytecodeManager.incBytecodes(7);
                                this.writeBytes(array, n11, n12);
                            }
                        }
                        n += get17 + 4;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n13 = n;
                    final int n14 = length - n;
                    BytecodeManager.incBytecodes(7);
                    this.writeBytes(array, n13, n14);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final int n15 = n;
                final int n16 = length;
                BytecodeManager.incBytecodes(3);
                if (n15 < n16) {
                    final int n17 = n;
                    final int n18 = length - n;
                    BytecodeManager.incBytecodes(7);
                    this.writeBytes(array, n17, n18);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeByte(final int n) throws IOException {
        try {
            final OutputStream out = this.out;
            BytecodeManager.incBytecodes(3);
            final OutputStream outputStream = out;
            final int n2 = n & 0xFF;
            BytecodeManager.incBytecodes(5);
            outputStream.write(n2);
            ++this.written;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeShort(final int n) throws IOException {
        try {
            final OutputStream out = this.out;
            BytecodeManager.incBytecodes(3);
            final OutputStream outputStream = out;
            final int n2 = n >>> 0 & 0xFF;
            BytecodeManager.incBytecodes(7);
            outputStream.write(n2);
            final OutputStream outputStream2 = out;
            final int n3 = n >>> 8 & 0xFF;
            BytecodeManager.incBytecodes(7);
            outputStream2.write(n3);
            this.written += 2L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeInt(final long n) throws IOException {
        try {
            final OutputStream out = this.out;
            BytecodeManager.incBytecodes(3);
            final OutputStream outputStream = out;
            final int n2 = (int)(n >>> 0 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream.write(n2);
            final OutputStream outputStream2 = out;
            final int n3 = (int)(n >>> 8 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream2.write(n3);
            final OutputStream outputStream3 = out;
            final int n4 = (int)(n >>> 16 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream3.write(n4);
            final OutputStream outputStream4 = out;
            final int n5 = (int)(n >>> 24 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream4.write(n5);
            this.written += 4L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeLong(final long n) throws IOException {
        try {
            final OutputStream out = this.out;
            BytecodeManager.incBytecodes(3);
            final OutputStream outputStream = out;
            final int n2 = (int)(n >>> 0 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream.write(n2);
            final OutputStream outputStream2 = out;
            final int n3 = (int)(n >>> 8 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream2.write(n3);
            final OutputStream outputStream3 = out;
            final int n4 = (int)(n >>> 16 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream3.write(n4);
            final OutputStream outputStream4 = out;
            final int n5 = (int)(n >>> 24 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream4.write(n5);
            final OutputStream outputStream5 = out;
            final int n6 = (int)(n >>> 32 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream5.write(n6);
            final OutputStream outputStream6 = out;
            final int n7 = (int)(n >>> 40 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream6.write(n7);
            final OutputStream outputStream7 = out;
            final int n8 = (int)(n >>> 48 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream7.write(n8);
            final OutputStream outputStream8 = out;
            final int n9 = (int)(n >>> 56 & 0xFFL);
            BytecodeManager.incBytecodes(8);
            outputStream8.write(n9);
            this.written += 8L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeBytes(final byte[] b, final int off, final int len) throws IOException {
        try {
            final OutputStream out = super.out;
            BytecodeManager.incBytecodes(6);
            out.write(b, off, len);
            this.written += len;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String theProp = "jdk.util.zip.inhibitZip64";
            final String defaultVal = "false";
            BytecodeManager.incBytecodes(5);
            final GetPropertyAction action = new GetPropertyAction(theProp, defaultVal);
            BytecodeManager.incBytecodes(1);
            final String s = AccessController.doPrivileged((PrivilegedAction<String>)action);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            inhibitZip64 = Boolean.parseBoolean(s);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class XEntry
    {
        final ZipEntry entry;
        final long offset;
        
        public XEntry(final ZipEntry entry, final long offset) {
            this.entry = entry;
            this.offset = offset;
        }
    }
}
