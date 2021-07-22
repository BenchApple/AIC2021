// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.util.zip.ZipEntry;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.InputStream;
import sun.security.util.ManifestEntryVerifier;
import java.util.zip.ZipInputStream;

public class JarInputStream extends ZipInputStream
{
    private Manifest man;
    private JarEntry first;
    private JarVerifier jv;
    private ManifestEntryVerifier mev;
    private final boolean doVerify;
    private boolean tryManifest;
    
    public JarInputStream(final InputStream inputStream) throws IOException {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            this(inputStream, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarInputStream(final InputStream in, final boolean doVerify) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            super(in);
            this.doVerify = doVerify;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            JarEntry jarEntry = (JarEntry)super.getNextEntry();
            BytecodeManager.incBytecodes(2);
            final JarEntry jarEntry2 = jarEntry;
            BytecodeManager.incBytecodes(2);
            if (jarEntry2 != null) {
                final JarEntry jarEntry3 = jarEntry;
                BytecodeManager.incBytecodes(2);
                final String name = jarEntry3.getName();
                final String anotherString = "META-INF/";
                BytecodeManager.incBytecodes(2);
                final boolean equalsIgnoreCase = name.equalsIgnoreCase(anotherString);
                BytecodeManager.incBytecodes(1);
                if (equalsIgnoreCase) {
                    BytecodeManager.incBytecodes(2);
                    jarEntry = (JarEntry)super.getNextEntry();
                    BytecodeManager.incBytecodes(2);
                }
            }
            final JarEntry jarEntry4 = jarEntry;
            BytecodeManager.incBytecodes(4);
            this.first = this.checkManifest(jarEntry4);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private JarEntry checkManifest(final JarEntry jarEntry) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            if (jarEntry != null) {
                final String s = "META-INF/MANIFEST.MF";
                BytecodeManager.incBytecodes(3);
                final String name = jarEntry.getName();
                BytecodeManager.incBytecodes(1);
                final boolean equalsIgnoreCase = s.equalsIgnoreCase(name);
                BytecodeManager.incBytecodes(1);
                if (equalsIgnoreCase) {
                    BytecodeManager.incBytecodes(4);
                    this.man = new Manifest();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(5);
                    final BufferedInputStream bufferedInputStream = new BufferedInputStream(this);
                    BytecodeManager.incBytecodes(1);
                    final byte[] bytes = this.getBytes(bufferedInputStream);
                    BytecodeManager.incBytecodes(1);
                    final Manifest man = this.man;
                    final byte[] buf = bytes;
                    BytecodeManager.incBytecodes(6);
                    final ByteArrayInputStream is = new ByteArrayInputStream(buf);
                    BytecodeManager.incBytecodes(1);
                    man.read(is);
                    BytecodeManager.incBytecodes(2);
                    this.closeEntry();
                    final boolean doVerify = this.doVerify;
                    BytecodeManager.incBytecodes(3);
                    if (doVerify) {
                        final byte[] rawBytes = bytes;
                        BytecodeManager.incBytecodes(5);
                        this.jv = new JarVerifier(rawBytes);
                        BytecodeManager.incBytecodes(1);
                        final Manifest man2 = this.man;
                        BytecodeManager.incBytecodes(6);
                        this.mev = new ManifestEntryVerifier(man2);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(2);
                    final JarEntry jarEntry2 = (JarEntry)super.getNextEntry();
                    BytecodeManager.incBytecodes(2);
                    return jarEntry2;
                }
            }
            BytecodeManager.incBytecodes(2);
            return jarEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private byte[] getBytes(final InputStream inputStream) throws IOException {
        try {
            final byte[] array = new byte[8192];
            BytecodeManager.incBytecodes(2);
            final int size = 2048;
            BytecodeManager.incBytecodes(4);
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final byte[] b = array;
                final int off = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(6);
                final int read = inputStream.read(b, off, length);
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (read == n) {
                    break;
                }
                final ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                final byte[] b2 = array;
                final int off2 = 0;
                final int len = read;
                BytecodeManager.incBytecodes(5);
                byteArrayOutputStream2.write(b2, off2, len);
                BytecodeManager.incBytecodes(1);
            }
            final ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
            BytecodeManager.incBytecodes(2);
            final byte[] byteArray = byteArrayOutputStream3.toByteArray();
            BytecodeManager.incBytecodes(1);
            return byteArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Manifest getManifest() {
        try {
            final Manifest man = this.man;
            BytecodeManager.incBytecodes(3);
            return man;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ZipEntry getNextEntry() throws IOException {
        try {
            final JarEntry first = this.first;
            BytecodeManager.incBytecodes(3);
            JarEntry jarEntry;
            if (first == null) {
                BytecodeManager.incBytecodes(2);
                jarEntry = (JarEntry)super.getNextEntry();
                BytecodeManager.incBytecodes(2);
                final boolean tryManifest = this.tryManifest;
                BytecodeManager.incBytecodes(3);
                if (tryManifest) {
                    final JarEntry jarEntry2 = jarEntry;
                    BytecodeManager.incBytecodes(3);
                    jarEntry = this.checkManifest(jarEntry2);
                    BytecodeManager.incBytecodes(1);
                    this.tryManifest = false;
                    BytecodeManager.incBytecodes(4);
                }
            }
            else {
                jarEntry = this.first;
                BytecodeManager.incBytecodes(3);
                final JarEntry first2 = this.first;
                BytecodeManager.incBytecodes(3);
                final String name = first2.getName();
                final String anotherString = "META-INF/INDEX.LIST";
                BytecodeManager.incBytecodes(2);
                final boolean equalsIgnoreCase = name.equalsIgnoreCase(anotherString);
                BytecodeManager.incBytecodes(1);
                if (equalsIgnoreCase) {
                    this.tryManifest = true;
                    BytecodeManager.incBytecodes(3);
                }
                this.first = null;
                BytecodeManager.incBytecodes(3);
            }
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv != null) {
                final JarEntry jarEntry3 = jarEntry;
                BytecodeManager.incBytecodes(2);
                if (jarEntry3 != null) {
                    final JarVerifier jv2 = this.jv;
                    BytecodeManager.incBytecodes(3);
                    final boolean nothingToVerify = jv2.nothingToVerify();
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    if (nothingToVerify == b) {
                        this.jv = null;
                        BytecodeManager.incBytecodes(3);
                        this.mev = null;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final JarVerifier jv3 = this.jv;
                        final JarEntry je = jarEntry;
                        final ManifestEntryVerifier mev = this.mev;
                        BytecodeManager.incBytecodes(6);
                        jv3.beginEntry(je, mev);
                    }
                }
            }
            final JarEntry jarEntry4 = jarEntry;
            BytecodeManager.incBytecodes(2);
            return jarEntry4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarEntry getNextJarEntry() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final JarEntry jarEntry = (JarEntry)this.getNextEntry();
            BytecodeManager.incBytecodes(2);
            return jarEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) throws IOException {
        try {
            final JarEntry first = this.first;
            BytecodeManager.incBytecodes(3);
            int read;
            if (first == null) {
                BytecodeManager.incBytecodes(5);
                read = super.read(array, n, n2);
                BytecodeManager.incBytecodes(2);
            }
            else {
                read = -1;
                BytecodeManager.incBytecodes(2);
            }
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv != null) {
                final JarVerifier jv2 = this.jv;
                final int n3 = read;
                final ManifestEntryVerifier mev = this.mev;
                BytecodeManager.incBytecodes(9);
                jv2.update(n3, array, n, n2, mev);
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
    protected ZipEntry createZipEntry(final String s) {
        try {
            BytecodeManager.incBytecodes(4);
            final JarEntry jarEntry = new JarEntry(s);
            BytecodeManager.incBytecodes(1);
            final Manifest man = this.man;
            BytecodeManager.incBytecodes(3);
            if (man != null) {
                final JarEntry jarEntry2 = jarEntry;
                final Manifest man2 = this.man;
                BytecodeManager.incBytecodes(5);
                jarEntry2.attr = man2.getAttributes(s);
                BytecodeManager.incBytecodes(1);
            }
            final JarEntry jarEntry3 = jarEntry;
            BytecodeManager.incBytecodes(2);
            return jarEntry3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
