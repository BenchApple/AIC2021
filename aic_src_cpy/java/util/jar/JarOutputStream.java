// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.io.IOException;
import java.io.BufferedOutputStream;
import java.util.zip.ZipEntry;
import aic2021.engine.BytecodeManager;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

public class JarOutputStream extends ZipOutputStream
{
    private static final int JAR_MAGIC = 51966;
    private boolean firstEntry;
    
    public JarOutputStream(final OutputStream out, final Manifest manifest) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            super(out);
            this.firstEntry = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (manifest == null) {
                final String s = "man";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final String name = "META-INF/MANIFEST.MF";
            BytecodeManager.incBytecodes(4);
            final ZipEntry zipEntry = new ZipEntry(name);
            BytecodeManager.incBytecodes(1);
            final ZipEntry ze = zipEntry;
            BytecodeManager.incBytecodes(3);
            this.putNextEntry(ze);
            BytecodeManager.incBytecodes(5);
            final BufferedOutputStream out2 = new BufferedOutputStream(this);
            BytecodeManager.incBytecodes(1);
            manifest.write(out2);
            BytecodeManager.incBytecodes(2);
            this.closeEntry();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarOutputStream(final OutputStream out) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            super(out);
            this.firstEntry = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void putNextEntry(final ZipEntry e) throws IOException {
        try {
            final boolean firstEntry = this.firstEntry;
            BytecodeManager.incBytecodes(3);
            if (firstEntry) {
                BytecodeManager.incBytecodes(2);
                final byte[] extra = e.getExtra();
                BytecodeManager.incBytecodes(1);
                final byte[] array = extra;
                BytecodeManager.incBytecodes(2);
                Label_0140: {
                    if (array != null) {
                        final byte[] edata = extra;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasMagic = hasMagic(edata);
                        BytecodeManager.incBytecodes(1);
                        if (hasMagic) {
                            break Label_0140;
                        }
                    }
                    final byte[] array2 = extra;
                    BytecodeManager.incBytecodes(2);
                    byte[] array3;
                    if (array2 == null) {
                        array3 = new byte[4];
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final byte[] array4 = new byte[extra.length + 4];
                        BytecodeManager.incBytecodes(5);
                        final byte[] array5 = extra;
                        final int n = 0;
                        final byte[] array6 = array4;
                        final int n2 = 4;
                        final int length = extra.length;
                        BytecodeManager.incBytecodes(7);
                        System.arraycopy(array5, n, array6, n2, length);
                        array3 = array4;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte[] b = array3;
                    final int off = 0;
                    final int value = 51966;
                    BytecodeManager.incBytecodes(4);
                    set16(b, off, value);
                    final byte[] b2 = array3;
                    final int off2 = 2;
                    final int value2 = 0;
                    BytecodeManager.incBytecodes(4);
                    set16(b2, off2, value2);
                    final byte[] extra2 = array3;
                    BytecodeManager.incBytecodes(3);
                    e.setExtra(extra2);
                }
                this.firstEntry = false;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(3);
            super.putNextEntry(e);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean hasMagic(final byte[] array) {
        try {
            try {
                try {
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = array.length;
                        BytecodeManager.incBytecodes(4);
                        if (n2 >= length) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final int off = n;
                        BytecodeManager.incBytecodes(3);
                        final int get16 = get16(array, off);
                        final int n3 = 51966;
                        BytecodeManager.incBytecodes(2);
                        if (get16 == n3) {
                            final boolean b = true;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            return b;
                        }
                        final int n4 = n;
                        final int off2 = n + 2;
                        BytecodeManager.incBytecodes(6);
                        n = n4 + (get16(array, off2) + 4);
                        BytecodeManager.incBytecodes(5);
                    }
                }
                catch (ArrayIndexOutOfBoundsException ex) {
                    BytecodeManager.incBytecodes(501);
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static int get16(final byte[] array, final int n) {
        try {
            final byte x = array[n];
            BytecodeManager.incBytecodes(4);
            final int unsignedInt = Byte.toUnsignedInt(x);
            final byte x2 = array[n + 1];
            BytecodeManager.incBytecodes(6);
            final int n2 = unsignedInt | Byte.toUnsignedInt(x2) << 8;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void set16(final byte[] array, final int n, final int n2) {
        try {
            array[n + 0] = (byte)n2;
            BytecodeManager.incBytecodes(7);
            array[n + 1] = (byte)(n2 >> 8);
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
