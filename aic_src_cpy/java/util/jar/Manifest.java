// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.io.FilterInputStream;
import java.util.Iterator;
import instrumented.java.util.Set;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import instrumented.java.util.HashMap;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Map;

public class Manifest implements Cloneable
{
    private Attributes attr;
    private Map<String, Attributes> entries;
    
    public Manifest() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.attr = new Attributes();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.entries = new HashMap();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Manifest(final InputStream is) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.attr = new Attributes();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.entries = new HashMap();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.read(is);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Manifest(final Manifest manifest) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.attr = new Attributes();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.entries = new HashMap();
            BytecodeManager.incBytecodes(1);
            final Attributes attr = this.attr;
            BytecodeManager.incBytecodes(4);
            final Attributes mainAttributes = manifest.getMainAttributes();
            BytecodeManager.incBytecodes(1);
            attr.putAll((Map)mainAttributes);
            final Map entries = this.entries;
            BytecodeManager.incBytecodes(4);
            final Map entries2 = manifest.getEntries();
            BytecodeManager.incBytecodes(1);
            entries.putAll(entries2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Attributes getMainAttributes() {
        try {
            final Attributes attr = this.attr;
            BytecodeManager.incBytecodes(3);
            return attr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Map<String, Attributes> getEntries() {
        try {
            final Map entries = this.entries;
            BytecodeManager.incBytecodes(3);
            return (Map<String, Attributes>)entries;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Attributes getAttributes(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final Map entries = this.getEntries();
            BytecodeManager.incBytecodes(2);
            final Attributes attributes = entries.get(s);
            BytecodeManager.incBytecodes(2);
            return attributes;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void clear() {
        try {
            final Attributes attr = this.attr;
            BytecodeManager.incBytecodes(3);
            attr.clear();
            final Map entries = this.entries;
            BytecodeManager.incBytecodes(3);
            entries.clear();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void write(final OutputStream out) throws IOException {
        try {
            BytecodeManager.incBytecodes(4);
            final DataOutputStream dataOutputStream = new DataOutputStream(out);
            BytecodeManager.incBytecodes(1);
            final Attributes attr = this.attr;
            final DataOutputStream out2 = dataOutputStream;
            BytecodeManager.incBytecodes(4);
            attr.writeMain(out2);
            final Map entries = this.entries;
            BytecodeManager.incBytecodes(3);
            final Set<Map.Entry<String, V>> entrySet = entries.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Map.Entry<String, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Map.Entry<String, V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Map.Entry<String, V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<String, V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final String str = "Name: ";
                BytecodeManager.incBytecodes(4);
                final StringBuffer sb = new StringBuffer(str);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<String, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                String s = entry2.getKey();
                BytecodeManager.incBytecodes(2);
                final String s2 = s;
                BytecodeManager.incBytecodes(2);
                if (s2 != null) {
                    final String s3 = s;
                    final String charsetName = "UTF8";
                    BytecodeManager.incBytecodes(3);
                    final byte[] bytes = s3.getBytes(charsetName);
                    BytecodeManager.incBytecodes(1);
                    final byte[] ascii = bytes;
                    final int hibyte = 0;
                    final int offset = 0;
                    final int length = bytes.length;
                    BytecodeManager.incBytecodes(8);
                    s = new String(ascii, hibyte, offset, length);
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuffer sb2 = sb;
                final String str2 = s;
                BytecodeManager.incBytecodes(3);
                sb2.append(str2);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb3 = sb;
                final String str3 = "\r\n";
                BytecodeManager.incBytecodes(3);
                sb3.append(str3);
                BytecodeManager.incBytecodes(1);
                final StringBuffer line = sb;
                BytecodeManager.incBytecodes(2);
                make72Safe(line);
                final DataOutputStream dataOutputStream2 = dataOutputStream;
                final StringBuffer sb4 = sb;
                BytecodeManager.incBytecodes(3);
                final String string = sb4.toString();
                BytecodeManager.incBytecodes(1);
                dataOutputStream2.writeBytes(string);
                final Map.Entry<String, V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final Attributes attributes = (Attributes)entry3.getValue();
                final DataOutputStream os = dataOutputStream;
                BytecodeManager.incBytecodes(3);
                attributes.write(os);
                BytecodeManager.incBytecodes(1);
            }
            final DataOutputStream dataOutputStream3 = dataOutputStream;
            BytecodeManager.incBytecodes(2);
            dataOutputStream3.flush();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void make72Safe(final StringBuffer sb) {
        try {
            BytecodeManager.incBytecodes(2);
            int length = sb.length();
            BytecodeManager.incBytecodes(1);
            final int n = length;
            final int n2 = 72;
            BytecodeManager.incBytecodes(3);
            if (n > n2) {
                int n3 = 70;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int n5 = length - 2;
                    BytecodeManager.incBytecodes(5);
                    if (n4 >= n5) {
                        break;
                    }
                    final int offset = n3;
                    final String str = "\r\n ";
                    BytecodeManager.incBytecodes(4);
                    sb.insert(offset, str);
                    BytecodeManager.incBytecodes(1);
                    n3 += 72;
                    BytecodeManager.incBytecodes(1);
                    length += 3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void read(final InputStream in) throws IOException {
        try {
            BytecodeManager.incBytecodes(4);
            final FastInputStream fastInputStream = new FastInputStream(in);
            BytecodeManager.incBytecodes(1);
            final byte[] array = new byte[512];
            BytecodeManager.incBytecodes(2);
            final Attributes attr = this.attr;
            final FastInputStream is = fastInputStream;
            final byte[] lbuf = array;
            BytecodeManager.incBytecodes(5);
            attr.read(is, lbuf);
            int n = 0;
            int n2 = 0;
            BytecodeManager.incBytecodes(4);
            int max = 2;
            BytecodeManager.incBytecodes(2);
            String name = null;
            BytecodeManager.incBytecodes(2);
            boolean b = true;
            BytecodeManager.incBytecodes(2);
            byte[] array2 = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final FastInputStream fastInputStream2 = fastInputStream;
                final byte[] b2 = array;
                BytecodeManager.incBytecodes(3);
                int line;
                final int n3 = line = fastInputStream2.readLine(b2);
                final int n4 = -1;
                BytecodeManager.incBytecodes(4);
                if (n3 == n4) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final byte b3 = array[--line];
                final int n5 = 10;
                BytecodeManager.incBytecodes(6);
                if (b3 != n5) {
                    final String message = "manifest line too long";
                    BytecodeManager.incBytecodes(4);
                    final IOException ex = new IOException(message);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n6 = line;
                BytecodeManager.incBytecodes(2);
                if (n6 > 0) {
                    final byte b4 = array[line - 1];
                    final int n7 = 13;
                    BytecodeManager.incBytecodes(7);
                    if (b4 == n7) {
                        --line;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n8 = line;
                BytecodeManager.incBytecodes(2);
                if (n8 == 0) {
                    final boolean b5 = b;
                    BytecodeManager.incBytecodes(2);
                    if (b5) {
                        BytecodeManager.incBytecodes(1);
                        continue;
                    }
                }
                b = false;
                BytecodeManager.incBytecodes(2);
                final String s = name;
                BytecodeManager.incBytecodes(2);
                if (s == null) {
                    final byte[] lbuf2 = array;
                    final int len = line;
                    BytecodeManager.incBytecodes(4);
                    name = this.parseName(lbuf2, len);
                    BytecodeManager.incBytecodes(1);
                    final String s2 = name;
                    BytecodeManager.incBytecodes(2);
                    if (s2 == null) {
                        final String message2 = "invalid manifest format";
                        BytecodeManager.incBytecodes(4);
                        final IOException ex2 = new IOException(message2);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final FastInputStream fastInputStream3 = fastInputStream;
                    BytecodeManager.incBytecodes(2);
                    final byte peek = fastInputStream3.peek();
                    final int n9 = 32;
                    BytecodeManager.incBytecodes(2);
                    if (peek == n9) {
                        array2 = new byte[line - 6];
                        BytecodeManager.incBytecodes(4);
                        final byte[] array3 = array;
                        final int n10 = 6;
                        final byte[] array4 = array2;
                        final int n11 = 0;
                        final int n12 = line - 6;
                        BytecodeManager.incBytecodes(8);
                        System.arraycopy(array3, n10, array4, n11, n12);
                        BytecodeManager.incBytecodes(1);
                        continue;
                    }
                }
                else {
                    final byte[] array5 = new byte[array2.length + line - 1];
                    BytecodeManager.incBytecodes(7);
                    final byte[] array6 = array2;
                    final int n13 = 0;
                    final byte[] array7 = array5;
                    final int n14 = 0;
                    final int length = array2.length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array6, n13, array7, n14, length);
                    final byte[] array8 = array;
                    final int n15 = 1;
                    final byte[] array9 = array5;
                    final int length2 = array2.length;
                    final int n16 = line - 1;
                    BytecodeManager.incBytecodes(9);
                    System.arraycopy(array8, n15, array9, length2, n16);
                    final FastInputStream fastInputStream4 = fastInputStream;
                    BytecodeManager.incBytecodes(2);
                    final byte peek2 = fastInputStream4.peek();
                    final int n17 = 32;
                    BytecodeManager.incBytecodes(2);
                    if (peek2 == n17) {
                        array2 = array5;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        continue;
                    }
                    final byte[] bytes = array5;
                    final int offset = 0;
                    final int length3 = array5.length;
                    final String charsetName = "UTF8";
                    BytecodeManager.incBytecodes(8);
                    name = new String(bytes, offset, length3, charsetName);
                    BytecodeManager.incBytecodes(1);
                    array2 = null;
                    BytecodeManager.incBytecodes(2);
                }
                final String name2 = name;
                BytecodeManager.incBytecodes(3);
                Attributes attributes = this.getAttributes(name2);
                BytecodeManager.incBytecodes(1);
                final Attributes attributes2 = attributes;
                BytecodeManager.incBytecodes(2);
                if (attributes2 == null) {
                    final int size = max;
                    BytecodeManager.incBytecodes(4);
                    attributes = new Attributes(size);
                    BytecodeManager.incBytecodes(1);
                    final Map entries = this.entries;
                    final String s3 = name;
                    final Attributes attributes3 = attributes;
                    BytecodeManager.incBytecodes(5);
                    entries.put(s3, attributes3);
                    BytecodeManager.incBytecodes(1);
                }
                final Attributes attributes4 = attributes;
                final FastInputStream is2 = fastInputStream;
                final byte[] lbuf3 = array;
                BytecodeManager.incBytecodes(4);
                attributes4.read(is2, lbuf3);
                ++n;
                BytecodeManager.incBytecodes(1);
                final int n18 = n2;
                final Attributes attributes5 = attributes;
                BytecodeManager.incBytecodes(3);
                n2 = n18 + attributes5.size();
                BytecodeManager.incBytecodes(2);
                final int a = 2;
                final int b6 = n2 / n;
                BytecodeManager.incBytecodes(5);
                max = Math.max(a, b6);
                BytecodeManager.incBytecodes(1);
                name = null;
                BytecodeManager.incBytecodes(2);
                b = true;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String parseName(final byte[] p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: iconst_0       
        //     3: baload         
        //     4: ldc             5
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokespecial   java/util/jar/Manifest.toLower:(I)I
        //    12: bipush          110
        //    14: ldc             2
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: if_icmpne       152
        //    22: aload_0        
        //    23: aload_1        
        //    24: iconst_1       
        //    25: baload         
        //    26: ldc             5
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: invokespecial   java/util/jar/Manifest.toLower:(I)I
        //    34: bipush          97
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: if_icmpne       152
        //    44: aload_0        
        //    45: aload_1        
        //    46: iconst_2       
        //    47: baload         
        //    48: ldc             4
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokespecial   java/util/jar/Manifest.toLower:(I)I
        //    61: bipush          109
        //    63: ldc             2
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: if_icmpne       152
        //    71: aload_0        
        //    72: aload_1        
        //    73: iconst_3       
        //    74: baload         
        //    75: ldc             5
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: invokespecial   java/util/jar/Manifest.toLower:(I)I
        //    83: bipush          101
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: if_icmpne       152
        //    93: aload_1        
        //    94: iconst_4       
        //    95: baload         
        //    96: bipush          58
        //    98: ldc             5
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: if_icmpne       152
        //   106: aload_1        
        //   107: iconst_5       
        //   108: baload         
        //   109: bipush          32
        //   111: ldc             5
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: if_icmpne       152
        //   119: new             Ljava/lang/String;
        //   122: dup            
        //   123: aload_1        
        //   124: bipush          6
        //   126: iload_2        
        //   127: bipush          6
        //   129: isub           
        //   130: ldc             "UTF8"
        //   132: ldc             9
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: invokespecial   java/lang/String.<init>:([BIILjava/lang/String;)V
        //   140: ldc             1
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: areturn        
        //   146: astore_3       
        //   147: ldc             501
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: aconst_null    
        //   153: ldc             2
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: areturn        
        //   159: athrow         
        //   160: athrow         
        //    StackMapTable: 00 04 F7 00 92 07 00 DF 05 FF 00 06 00 00 00 01 07 00 2D FF 00 00 00 00 00 01 07 00 DD
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  119    160    160    161    Ljava/lang/VirtualMachineError;
        //  119    140    146    152    Ljava/lang/Exception;
        //  0      159    159    160    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0152:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private int toLower(final int n) {
        try {
            final int n2 = 65;
            BytecodeManager.incBytecodes(3);
            int n4 = 0;
            Label_0043: {
                if (n >= n2) {
                    final int n3 = 90;
                    BytecodeManager.incBytecodes(3);
                    if (n <= n3) {
                        n4 = 97 + (n - 65);
                        BytecodeManager.incBytecodes(6);
                        break Label_0043;
                    }
                }
                n4 = n;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            final boolean b = o instanceof Manifest;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final Manifest manifest = (Manifest)o;
                BytecodeManager.incBytecodes(3);
                final Attributes attr = this.attr;
                final Manifest manifest2 = manifest;
                BytecodeManager.incBytecodes(4);
                final Attributes mainAttributes = manifest2.getMainAttributes();
                BytecodeManager.incBytecodes(1);
                final boolean equals = attr.equals(mainAttributes);
                BytecodeManager.incBytecodes(1);
                boolean b2 = false;
                Label_0102: {
                    if (equals) {
                        final Map entries = this.entries;
                        final Manifest manifest3 = manifest;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Map entries2 = manifest3.getEntries();
                        BytecodeManager.incBytecodes(1);
                        final boolean equals2 = entries.equals(entries2);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0102;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            final boolean b3 = false;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final Attributes attr = this.attr;
            BytecodeManager.incBytecodes(3);
            final int hashCode = attr.hashCode();
            final Map entries = this.entries;
            BytecodeManager.incBytecodes(3);
            final int n = hashCode + entries.hashCode();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            BytecodeManager.incBytecodes(4);
            final Manifest manifest = new Manifest(this);
            BytecodeManager.incBytecodes(1);
            return manifest;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class FastInputStream extends FilterInputStream
    {
        private byte[] buf;
        private int count;
        private int pos;
        
        FastInputStream(final InputStream in) {
            this(in, 8192);
        }
        
        FastInputStream(final InputStream in, final int size) {
            super(in);
            this.count = 0;
            this.pos = 0;
            this.buf = new byte[size];
        }
        
        @Override
        public int read() throws IOException {
            if (this.pos >= this.count) {
                this.fill();
                if (this.pos >= this.count) {
                    return -1;
                }
            }
            return Byte.toUnsignedInt(this.buf[this.pos++]);
        }
        
        @Override
        public int read(final byte[] b, final int off, int len) throws IOException {
            int avail = this.count - this.pos;
            if (avail <= 0) {
                if (len >= this.buf.length) {
                    return this.in.read(b, off, len);
                }
                this.fill();
                avail = this.count - this.pos;
                if (avail <= 0) {
                    return -1;
                }
            }
            if (len > avail) {
                len = avail;
            }
            System.arraycopy(this.buf, this.pos, b, off, len);
            this.pos += len;
            return len;
        }
        
        public int readLine(final byte[] b, int off, final int len) throws IOException {
            final byte[] tbuf = this.buf;
            int total = 0;
            while (total < len) {
                int avail = this.count - this.pos;
                if (avail <= 0) {
                    this.fill();
                    avail = this.count - this.pos;
                    if (avail <= 0) {
                        return -1;
                    }
                }
                int n = len - total;
                if (n > avail) {
                    n = avail;
                }
                int tpos = this.pos;
                final int maxpos = tpos + n;
                byte c = 0;
                while (tpos < maxpos && (c = tbuf[tpos++]) != 10 && c != 13) {}
                if (c == 13 && tpos < maxpos && tbuf[tpos] == 10) {
                    ++tpos;
                }
                n = tpos - this.pos;
                System.arraycopy(tbuf, this.pos, b, off, n);
                off += n;
                total += n;
                this.pos = tpos;
                c = tbuf[tpos - 1];
                if (c == 10) {
                    break;
                }
                if (c != 13) {
                    continue;
                }
                if (this.count != this.pos) {
                    break;
                }
                this.fill();
                if (this.pos < this.count && tbuf[this.pos] == 10) {
                    if (total < len) {
                        b[off++] = 10;
                        ++total;
                    }
                    else {
                        b[off - 1] = 10;
                    }
                    ++this.pos;
                    break;
                }
                break;
            }
            return total;
        }
        
        public byte peek() throws IOException {
            if (this.pos == this.count) {
                this.fill();
            }
            if (this.pos == this.count) {
                return -1;
            }
            return this.buf[this.pos];
        }
        
        public int readLine(final byte[] b) throws IOException {
            return this.readLine(b, 0, b.length);
        }
        
        @Override
        public long skip(long n) throws IOException {
            if (n <= 0L) {
                return 0L;
            }
            final long avail = this.count - this.pos;
            if (avail <= 0L) {
                return this.in.skip(n);
            }
            if (n > avail) {
                n = avail;
            }
            this.pos += (int)n;
            return n;
        }
        
        @Override
        public int available() throws IOException {
            return this.count - this.pos + this.in.available();
        }
        
        @Override
        public void close() throws IOException {
            if (this.in != null) {
                this.in.close();
                this.in = null;
                this.buf = null;
            }
        }
        
        private void fill() throws IOException {
            final int n2 = 0;
            this.pos = n2;
            this.count = n2;
            final int n = this.in.read(this.buf, 0, this.buf.length);
            if (n > 0) {
                this.count = n;
            }
        }
    }
}
