// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.security.cert.Certificate;
import sun.misc.JavaUtilJarAccess;
import sun.misc.SharedSecrets;
import instrumented.java.util.ArrayList;
import instrumented.java.util.List;
import java.net.URL;
import java.util.NoSuchElementException;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;
import instrumented.java.util.Locale;
import instrumented.java.util.Spliterator;
import instrumented.java.util.stream.StreamSupport;
import java.util.Iterator;
import instrumented.java.util.Spliterators;
import instrumented.java.util.stream.Stream;
import java.util.function.Function;
import instrumented.java.util.Enumeration;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.zip.ZipEntry;
import java.io.IOException;
import java.io.File;
import aic2021.engine.BytecodeManager;
import java.lang.ref.SoftReference;
import java.util.zip.ZipFile;

public class JarFile extends ZipFile
{
    private SoftReference<Manifest> manRef;
    private JarEntry manEntry;
    private JarVerifier jv;
    private boolean jvInitialized;
    private boolean verify;
    private boolean hasClassPathAttribute;
    private volatile boolean hasCheckedSpecialAttributes;
    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    private static final char[] CLASSPATH_CHARS;
    private static final int[] CLASSPATH_LASTOCC;
    private static final int[] CLASSPATH_OPTOSFT;
    private static String javaHome;
    private static volatile String[] jarNames;
    
    public JarFile(final String pathname) throws IOException {
        try {
            BytecodeManager.incBytecodes(5);
            final File file = new File(pathname);
            final boolean b = true;
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            this(file, b, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarFile(final String pathname, final boolean b) throws IOException {
        try {
            BytecodeManager.incBytecodes(5);
            final File file = new File(pathname);
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            this(file, b, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarFile(final File file) throws IOException {
        try {
            final boolean b = true;
            final int n = 1;
            BytecodeManager.incBytecodes(5);
            this(file, b, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarFile(final File file, final boolean b) throws IOException {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(5);
            this(file, b, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarFile(final File file, final boolean verify, final int mode) throws IOException {
        try {
            BytecodeManager.incBytecodes(4);
            super(file, mode);
            this.verify = verify;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Manifest getManifest() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final Manifest manifestFromReference = this.getManifestFromReference();
            BytecodeManager.incBytecodes(1);
            return manifestFromReference;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Manifest getManifestFromReference() throws IOException {
        try {
            final SoftReference<Manifest> manRef = this.manRef;
            BytecodeManager.incBytecodes(3);
            Manifest manifest;
            if (manRef != null) {
                final SoftReference<Manifest> manRef2 = this.manRef;
                BytecodeManager.incBytecodes(3);
                manifest = manRef2.get();
                BytecodeManager.incBytecodes(2);
            }
            else {
                manifest = null;
                BytecodeManager.incBytecodes(1);
            }
            Manifest manifest2 = manifest;
            BytecodeManager.incBytecodes(1);
            final Manifest manifest3 = manifest2;
            BytecodeManager.incBytecodes(2);
            if (manifest3 == null) {
                BytecodeManager.incBytecodes(2);
                final JarEntry manEntry = this.getManEntry();
                BytecodeManager.incBytecodes(1);
                final JarEntry jarEntry = manEntry;
                BytecodeManager.incBytecodes(2);
                if (jarEntry != null) {
                    final boolean verify = this.verify;
                    BytecodeManager.incBytecodes(3);
                    if (verify) {
                        final JarEntry jarEntry2 = manEntry;
                        BytecodeManager.incBytecodes(3);
                        final byte[] bytes = this.getBytes(jarEntry2);
                        BytecodeManager.incBytecodes(1);
                        final byte[] buf = bytes;
                        BytecodeManager.incBytecodes(6);
                        final ByteArrayInputStream is = new ByteArrayInputStream(buf);
                        BytecodeManager.incBytecodes(1);
                        manifest2 = new Manifest(is);
                        BytecodeManager.incBytecodes(1);
                        final boolean jvInitialized = this.jvInitialized;
                        BytecodeManager.incBytecodes(3);
                        if (!jvInitialized) {
                            final byte[] rawBytes = bytes;
                            BytecodeManager.incBytecodes(5);
                            this.jv = new JarVerifier(rawBytes);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final JarEntry entry = manEntry;
                        BytecodeManager.incBytecodes(5);
                        final InputStream inputStream = super.getInputStream(entry);
                        BytecodeManager.incBytecodes(1);
                        manifest2 = new Manifest(inputStream);
                        BytecodeManager.incBytecodes(1);
                    }
                    final Manifest referent = manifest2;
                    BytecodeManager.incBytecodes(5);
                    this.manRef = new SoftReference<Manifest>(referent);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Manifest manifest4 = manifest2;
            BytecodeManager.incBytecodes(2);
            return manifest4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private native String[] getMetaInfEntryNames();
    
    public JarEntry getJarEntry(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final JarEntry jarEntry = (JarEntry)this.getEntry(s);
            BytecodeManager.incBytecodes(2);
            return jarEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ZipEntry getEntry(final String name) {
        try {
            BytecodeManager.incBytecodes(3);
            final ZipEntry entry = super.getEntry(name);
            BytecodeManager.incBytecodes(1);
            final ZipEntry zipEntry = entry;
            BytecodeManager.incBytecodes(2);
            if (zipEntry != null) {
                final ZipEntry zipEntry2 = entry;
                BytecodeManager.incBytecodes(5);
                final JarFileEntry jarFileEntry = new JarFileEntry(zipEntry2);
                BytecodeManager.incBytecodes(1);
                return jarFileEntry;
            }
            final ZipEntry zipEntry3 = null;
            BytecodeManager.incBytecodes(2);
            return zipEntry3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<JarEntry> entries() {
        try {
            final Function<String, JarEntry> function = null;
            BytecodeManager.incBytecodes(5);
            final JarFile.JarEntryIterator jarEntryIterator = new JarFile.JarEntryIterator(this, function);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<JarEntry>)jarEntryIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Stream<JarEntry> stream() {
        try {
            final Function<String, JarEntry> function = null;
            BytecodeManager.incBytecodes(5);
            final JarFile.JarEntryIterator jarEntryIterator = new JarFile.JarEntryIterator(this, function);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final long n = this.size();
            final int n2 = 1297;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final Spliterator<Object> spliterator = Spliterators.spliterator((Iterator<?>)jarEntryIterator, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<JarEntry> stream = StreamSupport.stream((Spliterator<JarEntry>)spliterator, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void maybeInstantiateVerifier() throws IOException {
        try {
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv != null) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final boolean verify = this.verify;
            BytecodeManager.incBytecodes(3);
            if (verify) {
                BytecodeManager.incBytecodes(2);
                final String[] metaInfEntryNames = this.getMetaInfEntryNames();
                BytecodeManager.incBytecodes(1);
                final String[] array = metaInfEntryNames;
                BytecodeManager.incBytecodes(2);
                Label_0215: {
                    if (array != null) {
                        int n = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n2 = n;
                            final int length = metaInfEntryNames.length;
                            BytecodeManager.incBytecodes(4);
                            if (n2 >= length) {
                                break Label_0215;
                            }
                            final String s = metaInfEntryNames[n];
                            final Locale english = Locale.ENGLISH;
                            BytecodeManager.incBytecodes(5);
                            final String upperCase = s.toUpperCase(english);
                            BytecodeManager.incBytecodes(1);
                            final String s2 = upperCase;
                            final String suffix = ".DSA";
                            BytecodeManager.incBytecodes(3);
                            final boolean endsWith = s2.endsWith(suffix);
                            BytecodeManager.incBytecodes(1);
                            if (endsWith) {
                                break;
                            }
                            final String s3 = upperCase;
                            final String suffix2 = ".RSA";
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean endsWith2 = s3.endsWith(suffix2);
                            BytecodeManager.incBytecodes(1);
                            if (endsWith2) {
                                break;
                            }
                            final String s4 = upperCase;
                            final String suffix3 = ".EC";
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean endsWith3 = s4.endsWith(suffix3);
                            BytecodeManager.incBytecodes(1);
                            if (endsWith3) {
                                break;
                            }
                            final String s5 = upperCase;
                            final String suffix4 = ".SF";
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean endsWith4 = s5.endsWith(suffix4);
                            BytecodeManager.incBytecodes(1);
                            if (endsWith4) {
                                break;
                            }
                            ++n;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(2);
                        this.getManifest();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                this.verify = false;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void initializeVerifier() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: ldc             2
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: invokespecial   java/util/jar/JarFile.getMetaInfEntryNames:()[Ljava/lang/String;
        //    16: astore_2       
        //    17: ldc             1
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: aload_2        
        //    23: ldc             2
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ifnull          307
        //    31: iconst_0       
        //    32: istore_3       
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: iload_3        
        //    39: aload_2        
        //    40: arraylength    
        //    41: ldc             4
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: if_icmpge       307
        //    49: aload_2        
        //    50: iload_3        
        //    51: aaload         
        //    52: getstatic       instrumented/java/util/Locale.ENGLISH:Linstrumented/java/util/Locale;
        //    55: ldc             5
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokevirtual   java/lang/String.toUpperCase:(Linstrumented/java/util/Locale;)Ljava/lang/String;
        //    63: astore          4
        //    65: ldc             1
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: ldc             "META-INF/MANIFEST.MF"
        //    72: aload           4
        //    74: ldc             3
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    82: ldc             1
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: ifne            113
        //    90: aload           4
        //    92: ldc             1
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: invokestatic    sun/security/util/SignatureFileVerifier.isBlockOrSF:(Ljava/lang/String;)Z
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: ifeq            296
        //   113: aload_0        
        //   114: aload_2        
        //   115: iload_3        
        //   116: aaload         
        //   117: ldc             5
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: invokevirtual   java/util/jar/JarFile.getJarEntry:(Ljava/lang/String;)Ljava/util/jar/JarEntry;
        //   125: astore          5
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: aload           5
        //   134: ldc             2
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: ifnonnull       162
        //   142: new             Ljava/util/jar/JarException;
        //   145: dup            
        //   146: ldc             "corrupted jar file"
        //   148: ldc             4
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: invokespecial   java/util/jar/JarException.<init>:(Ljava/lang/String;)V
        //   156: ldc             1
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: athrow         
        //   162: aload_1        
        //   163: ldc             2
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: ifnonnull       203
        //   171: new             Lsun/security/util/ManifestEntryVerifier;
        //   174: dup            
        //   175: aload_0        
        //   176: ldc             3
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: ldc             1
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: invokespecial   java/util/jar/JarFile.getManifestFromReference:()Ljava/util/jar/Manifest;
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokespecial   sun/security/util/ManifestEntryVerifier.<init>:(Ljava/util/jar/Manifest;)V
        //   197: astore_1       
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: aload_0        
        //   204: aload           5
        //   206: ldc             3
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: invokespecial   java/util/jar/JarFile.getBytes:(Ljava/util/zip/ZipEntry;)[B
        //   214: astore          6
        //   216: ldc             1
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: aload           6
        //   223: ldc             2
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: ifnull          296
        //   231: aload           6
        //   233: arraylength    
        //   234: ldc             3
        //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   239: ifle            296
        //   242: aload_0        
        //   243: getfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   246: aload           5
        //   248: aload_1        
        //   249: ldc             5
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: invokevirtual   java/util/jar/JarVerifier.beginEntry:(Ljava/util/jar/JarEntry;Lsun/security/util/ManifestEntryVerifier;)V
        //   257: aload_0        
        //   258: getfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   261: aload           6
        //   263: arraylength    
        //   264: aload           6
        //   266: iconst_0       
        //   267: aload           6
        //   269: arraylength    
        //   270: aload_1        
        //   271: ldc             10
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: invokevirtual   java/util/jar/JarVerifier.update:(I[BIILsun/security/util/ManifestEntryVerifier;)V
        //   279: aload_0        
        //   280: getfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   283: iconst_m1      
        //   284: aconst_null    
        //   285: iconst_0       
        //   286: iconst_0       
        //   287: aload_1        
        //   288: ldc             8
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: invokevirtual   java/util/jar/JarVerifier.update:(I[BIILsun/security/util/ManifestEntryVerifier;)V
        //   296: iinc            3, 1
        //   299: ldc             2
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: goto            38
        //   307: ldc             1
        //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   312: goto            374
        //   315: astore_2       
        //   316: ldc             501
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: aload_0        
        //   322: aconst_null    
        //   323: putfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   326: ldc             3
        //   328: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   331: aload_0        
        //   332: iconst_0       
        //   333: putfield        java/util/jar/JarFile.verify:Z
        //   336: ldc             3
        //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   341: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   344: ldc             2
        //   346: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   349: ifnull          374
        //   352: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   355: ldc             "jarfile parsing error!"
        //   357: ldc             3
        //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   362: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   365: aload_2        
        //   366: ldc             2
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: invokevirtual   java/io/IOException.printStackTrace:()V
        //   374: aload_0        
        //   375: getfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   378: ldc             3
        //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   383: ifnull          486
        //   386: aload_0        
        //   387: getfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   390: ldc             3
        //   392: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   395: invokevirtual   java/util/jar/JarVerifier.doneWithMeta:()V
        //   398: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   401: ldc             2
        //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   406: ifnull          422
        //   409: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   412: ldc             "done with meta!"
        //   414: ldc             3
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   422: aload_0        
        //   423: getfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   426: ldc             3
        //   428: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   431: invokevirtual   java/util/jar/JarVerifier.nothingToVerify:()Z
        //   434: ldc             1
        //   436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   439: ifeq            486
        //   442: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   445: ldc             2
        //   447: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   450: ifnull          466
        //   453: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   456: ldc             "nothing to verify!"
        //   458: ldc             3
        //   460: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   463: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   466: aload_0        
        //   467: aconst_null    
        //   468: putfield        java/util/jar/JarFile.jv:Ljava/util/jar/JarVerifier;
        //   471: ldc             3
        //   473: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   476: aload_0        
        //   477: iconst_0       
        //   478: putfield        java/util/jar/JarFile.verify:Z
        //   481: ldc             3
        //   483: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   486: ldc             1
        //   488: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   491: return         
        //   492: athrow         
        //   493: athrow         
        //    StackMapTable: 00 0D FE 00 26 07 00 C4 07 00 A5 01 FC 00 4A 07 00 AD FC 00 30 07 00 75 28 F9 00 5C F9 00 0A 47 07 00 32 3A 2F 2B 13 FF 00 05 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 C2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  7      493    493    494    Ljava/lang/VirtualMachineError;
        //  7      307    315    374    Ljava/io/IOException;
        //  0      492    492    493    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
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
    
    private byte[] getBytes(final ZipEntry p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokespecial   java/util/zip/ZipFile.getInputStream:(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
        //    10: astore_2       
        //    11: aconst_null    
        //    12: astore_3       
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: aload_2        
        //    19: aload_1        
        //    20: ldc             3
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   java/util/zip/ZipEntry.getSize:()J
        //    28: l2i            
        //    29: iconst_1       
        //    30: ldc             3
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokestatic    sun/misc/IOUtils.readFully:(Ljava/io/InputStream;IZ)[B
        //    38: astore          4
        //    40: ldc             1
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: aload_2        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifnull          111
        //    54: aload_3        
        //    55: ldc             2
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: ifnull          102
        //    63: aload_2        
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: invokevirtual   java/io/InputStream.close:()V
        //    72: ldc             1
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: goto            111
        //    80: astore          5
        //    82: aload_3        
        //    83: aload           5
        //    85: ldc_w           504
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: goto            111
        //   102: aload_2        
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: invokevirtual   java/io/InputStream.close:()V
        //   111: aload           4
        //   113: ldc             2
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: areturn        
        //   119: astore          4
        //   121: aload           4
        //   123: astore_3       
        //   124: aload           4
        //   126: ldc_w           505
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: athrow         
        //   133: astore          6
        //   135: ldc             501
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: aload_2        
        //   141: ldc             2
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: ifnull          206
        //   149: aload_3        
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: ifnull          197
        //   158: aload_2        
        //   159: ldc             2
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokevirtual   java/io/InputStream.close:()V
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: goto            206
        //   175: astore          7
        //   177: aload_3        
        //   178: aload           7
        //   180: ldc_w           504
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: goto            206
        //   197: aload_2        
        //   198: ldc             2
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: invokevirtual   java/io/InputStream.close:()V
        //   206: aload           6
        //   208: ldc             2
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: athrow         
        //   214: athrow         
        //   215: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 0A FF 00 50 00 05 07 00 02 07 00 8A 07 01 07 07 00 44 07 01 0C 00 01 07 00 44 15 08 FF 00 07 00 04 07 00 02 07 00 8A 07 01 07 07 00 44 00 01 07 00 44 4D 07 00 44 FF 00 29 00 07 07 00 02 07 00 8A 07 01 07 07 00 44 00 00 07 00 44 00 01 07 00 44 15 08 FF 00 07 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 C2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  18     215    215    216    Ljava/lang/VirtualMachineError;
        //  63     72     80     102    Ljava/lang/Throwable;
        //  18     45     119    133    Ljava/lang/Throwable;
        //  18     45     133    214    Any
        //  158    167    175    197    Ljava/lang/Throwable;
        //  119    140    133    214    Any
        //  0      214    214    215    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0102:
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
    
    @Override
    public synchronized InputStream getInputStream(final ZipEntry entry) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.maybeInstantiateVerifier();
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv == null) {
                BytecodeManager.incBytecodes(3);
                final InputStream inputStream = super.getInputStream(entry);
                BytecodeManager.incBytecodes(1);
                return inputStream;
            }
            final boolean jvInitialized = this.jvInitialized;
            BytecodeManager.incBytecodes(3);
            if (!jvInitialized) {
                BytecodeManager.incBytecodes(2);
                this.initializeVerifier();
                this.jvInitialized = true;
                BytecodeManager.incBytecodes(3);
                final JarVerifier jv2 = this.jv;
                BytecodeManager.incBytecodes(3);
                if (jv2 == null) {
                    BytecodeManager.incBytecodes(3);
                    final InputStream inputStream2 = super.getInputStream(entry);
                    BytecodeManager.incBytecodes(1);
                    return inputStream2;
                }
            }
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Manifest manifestFromReference = this.getManifestFromReference();
            final boolean b = entry instanceof JarFileEntry;
            BytecodeManager.incBytecodes(3);
            JarEntry jarEntry;
            if (b) {
                jarEntry = (JarEntry)entry;
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final String name = entry.getName();
                BytecodeManager.incBytecodes(1);
                jarEntry = this.getJarEntry(name);
            }
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final InputStream inputStream3 = super.getInputStream(entry);
            final JarVerifier jv3 = this.jv;
            BytecodeManager.incBytecodes(3);
            final JarVerifier.VerifierStream verifierStream = new JarVerifier.VerifierStream(manifestFromReference, jarEntry, inputStream3, jv3);
            BytecodeManager.incBytecodes(1);
            return verifierStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private JarEntry getManEntry() {
        try {
            final JarEntry manEntry = this.manEntry;
            BytecodeManager.incBytecodes(3);
            if (manEntry == null) {
                final String s = "META-INF/MANIFEST.MF";
                BytecodeManager.incBytecodes(4);
                this.manEntry = this.getJarEntry(s);
                BytecodeManager.incBytecodes(1);
                final JarEntry manEntry2 = this.manEntry;
                BytecodeManager.incBytecodes(3);
                if (manEntry2 == null) {
                    BytecodeManager.incBytecodes(2);
                    final String[] metaInfEntryNames = this.getMetaInfEntryNames();
                    BytecodeManager.incBytecodes(1);
                    final String[] array = metaInfEntryNames;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        int n = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n2 = n;
                            final int length = metaInfEntryNames.length;
                            BytecodeManager.incBytecodes(4);
                            if (n2 >= length) {
                                break;
                            }
                            final String s2 = "META-INF/MANIFEST.MF";
                            final String s3 = metaInfEntryNames[n];
                            final Locale english = Locale.ENGLISH;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final String upperCase = s3.toUpperCase(english);
                            BytecodeManager.incBytecodes(1);
                            final boolean equals = s2.equals(upperCase);
                            BytecodeManager.incBytecodes(1);
                            if (equals) {
                                final String s4 = metaInfEntryNames[n];
                                BytecodeManager.incBytecodes(6);
                                this.manEntry = this.getJarEntry(s4);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            ++n;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
            }
            final JarEntry manEntry3 = this.manEntry;
            BytecodeManager.incBytecodes(3);
            return manEntry3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean hasClassPathAttribute() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkForSpecialAttributes();
            final boolean hasClassPathAttribute = this.hasClassPathAttribute;
            BytecodeManager.incBytecodes(3);
            return hasClassPathAttribute;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean match(final char[] array, final byte[] array2, final int[] array3, final int[] array4) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = array2.length - length;
            BytecodeManager.incBytecodes(5);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = n;
                BytecodeManager.incBytecodes(3);
                if (n3 > n4) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                int n5 = length - 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n6 = n5;
                    BytecodeManager.incBytecodes(2);
                    if (n6 < 0) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final char c = (char)array2[n2 + n5];
                    BytecodeManager.incBytecodes(7);
                    final int n7 = c - 'A' | 'Z' - c;
                    BytecodeManager.incBytecodes(8);
                    char c2;
                    if (n7 >= 0) {
                        c2 = (char)(c + ' ');
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        c2 = c;
                        BytecodeManager.incBytecodes(1);
                    }
                    final char c3 = c2;
                    BytecodeManager.incBytecodes(1);
                    final char c4 = c3;
                    final char c5 = array[n5];
                    BytecodeManager.incBytecodes(5);
                    if (c4 != c5) {
                        final int n8 = n2;
                        final int a = n5 + 1 - array3[c3 & '\u007f'];
                        final int b3 = array4[n5];
                        BytecodeManager.incBytecodes(14);
                        n2 = n8 + Math.max(a, b3);
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    --n5;
                    BytecodeManager.incBytecodes(2);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void checkForSpecialAttributes() throws IOException {
        try {
            final boolean hasCheckedSpecialAttributes = this.hasCheckedSpecialAttributes;
            BytecodeManager.incBytecodes(3);
            if (hasCheckedSpecialAttributes) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            final boolean knownNotToHaveSpecialAttributes = this.isKnownNotToHaveSpecialAttributes();
            BytecodeManager.incBytecodes(1);
            if (!knownNotToHaveSpecialAttributes) {
                BytecodeManager.incBytecodes(2);
                final JarEntry manEntry = this.getManEntry();
                BytecodeManager.incBytecodes(1);
                final JarEntry jarEntry = manEntry;
                BytecodeManager.incBytecodes(2);
                if (jarEntry != null) {
                    final JarEntry jarEntry2 = manEntry;
                    BytecodeManager.incBytecodes(3);
                    final byte[] bytes = this.getBytes(jarEntry2);
                    BytecodeManager.incBytecodes(1);
                    final char[] classpath_CHARS = JarFile.CLASSPATH_CHARS;
                    final byte[] array = bytes;
                    final int[] classpath_LASTOCC = JarFile.CLASSPATH_LASTOCC;
                    final int[] classpath_OPTOSFT = JarFile.CLASSPATH_OPTOSFT;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = this.match(classpath_CHARS, array, classpath_LASTOCC, classpath_OPTOSFT);
                    BytecodeManager.incBytecodes(1);
                    if (match) {
                        this.hasClassPathAttribute = true;
                        BytecodeManager.incBytecodes(3);
                    }
                }
            }
            this.hasCheckedSpecialAttributes = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isKnownNotToHaveSpecialAttributes() {
        try {
            final String javaHome = JarFile.javaHome;
            BytecodeManager.incBytecodes(2);
            if (javaHome == null) {
                final String theProp = "java.home";
                BytecodeManager.incBytecodes(4);
                final GetPropertyAction action = new GetPropertyAction(theProp);
                BytecodeManager.incBytecodes(1);
                JarFile.javaHome = AccessController.doPrivileged((PrivilegedAction<String>)action);
                BytecodeManager.incBytecodes(2);
            }
            final String[] jarNames = JarFile.jarNames;
            BytecodeManager.incBytecodes(2);
            if (jarNames == null) {
                final String[] jarNames2 = new String[11];
                BytecodeManager.incBytecodes(2);
                final String separator = File.separator;
                BytecodeManager.incBytecodes(2);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                final String[] array = jarNames2;
                final int n2 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb = new StringBuilder();
                final String str = separator;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = "rt.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                BytecodeManager.incBytecodes(1);
                array[n2] = append2.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array2 = jarNames2;
                final int n3 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb2 = new StringBuilder();
                final String str3 = separator;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str3);
                final String str4 = "jsse.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str4);
                BytecodeManager.incBytecodes(1);
                array2[n3] = append4.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array3 = jarNames2;
                final int n4 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb3 = new StringBuilder();
                final String str5 = separator;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = sb3.append(str5);
                final String str6 = "jce.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = append5.append(str6);
                BytecodeManager.incBytecodes(1);
                array3[n4] = append6.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array4 = jarNames2;
                final int n5 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb4 = new StringBuilder();
                final String str7 = separator;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = sb4.append(str7);
                final String str8 = "charsets.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(str8);
                BytecodeManager.incBytecodes(1);
                array4[n5] = append8.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array5 = jarNames2;
                final int n6 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb5 = new StringBuilder();
                final String str9 = separator;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append9 = sb5.append(str9);
                final String str10 = "dnsns.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append10 = append9.append(str10);
                BytecodeManager.incBytecodes(1);
                array5[n6] = append10.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array6 = jarNames2;
                final int n7 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb6 = new StringBuilder();
                final String str11 = separator;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append11 = sb6.append(str11);
                final String str12 = "zipfs.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append12 = append11.append(str12);
                BytecodeManager.incBytecodes(1);
                array6[n7] = append12.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array7 = jarNames2;
                final int n8 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb7 = new StringBuilder();
                final String str13 = separator;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append13 = sb7.append(str13);
                final String str14 = "localedata.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append14 = append13.append(str14);
                BytecodeManager.incBytecodes(1);
                array7[n8] = append14.toString();
                BytecodeManager.incBytecodes(1);
                final String s = jarNames2[n++] = "cldrdata.jar";
                BytecodeManager.incBytecodes(7);
                final String[] array8 = jarNames2;
                final int n9 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb8 = new StringBuilder();
                final String str15 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append15 = sb8.append(str15);
                final String str16 = "sunjce_provider.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append16 = append15.append(str16);
                BytecodeManager.incBytecodes(1);
                array8[n9] = append16.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array9 = jarNames2;
                final int n10 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb9 = new StringBuilder();
                final String str17 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append17 = sb9.append(str17);
                final String str18 = "sunpkcs11.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append18 = append17.append(str18);
                BytecodeManager.incBytecodes(1);
                array9[n10] = append18.toString();
                BytecodeManager.incBytecodes(1);
                final String[] array10 = jarNames2;
                final int n11 = n++;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb10 = new StringBuilder();
                final String str19 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append19 = sb10.append(str19);
                final String str20 = "sunec.jar";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append20 = append19.append(str20);
                BytecodeManager.incBytecodes(1);
                array10[n11] = append20.toString();
                BytecodeManager.incBytecodes(1);
                JarFile.jarNames = jarNames2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            final String name = this.getName();
            BytecodeManager.incBytecodes(1);
            final String javaHome2 = JarFile.javaHome;
            BytecodeManager.incBytecodes(2);
            final String s2 = name;
            final String prefix = javaHome2;
            BytecodeManager.incBytecodes(3);
            final boolean startsWith = s2.startsWith(prefix);
            BytecodeManager.incBytecodes(1);
            if (startsWith) {
                final String[] jarNames3 = JarFile.jarNames;
                BytecodeManager.incBytecodes(2);
                int n12 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n13 = n12;
                    final int length = jarNames3.length;
                    BytecodeManager.incBytecodes(4);
                    if (n13 >= length) {
                        break;
                    }
                    final String s3 = name;
                    final String suffix = jarNames3[n12];
                    BytecodeManager.incBytecodes(5);
                    final boolean endsWith = s3.endsWith(suffix);
                    BytecodeManager.incBytecodes(1);
                    if (endsWith) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    ++n12;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void ensureInitialization() {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.maybeInstantiateVerifier();
                    BytecodeManager.incBytecodes(1);
                }
                catch (IOException ex) {
                    BytecodeManager.incBytecodes(501);
                    final IOException cause = ex;
                    BytecodeManager.incBytecodes(4);
                    final RuntimeException ex2 = new RuntimeException(cause);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final JarVerifier jv = this.jv;
                BytecodeManager.incBytecodes(3);
                if (jv != null) {
                    final boolean jvInitialized = this.jvInitialized;
                    BytecodeManager.incBytecodes(3);
                    if (!jvInitialized) {
                        BytecodeManager.incBytecodes(2);
                        this.initializeVerifier();
                        this.jvInitialized = true;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    JarEntry newEntry(final ZipEntry zipEntry) {
        try {
            BytecodeManager.incBytecodes(5);
            final JarFileEntry jarFileEntry = new JarFileEntry(zipEntry);
            BytecodeManager.incBytecodes(1);
            return jarFileEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Enumeration<String> entryNames(final CodeSource[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureInitialization();
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv != null) {
                final JarVerifier jv2 = this.jv;
                BytecodeManager.incBytecodes(5);
                final Enumeration entryNames = jv2.entryNames(this, array);
                BytecodeManager.incBytecodes(1);
                return (Enumeration<String>)entryNames;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n3 >= length) {
                    break;
                }
                final CodeSource codeSource = array[n2];
                BytecodeManager.incBytecodes(4);
                final CodeSigner[] codeSigners = codeSource.getCodeSigners();
                BytecodeManager.incBytecodes(1);
                if (codeSigners == null) {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = n;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(2);
                final Enumeration<String> unsignedEntryNames = this.unsignedEntryNames();
                BytecodeManager.incBytecodes(1);
                return unsignedEntryNames;
            }
            BytecodeManager.incBytecodes(4);
            final Function<String, JarEntry> function = new Function<String, JarEntry>() {
                @Override
                public JarEntry apply(final String name) {
                    return new JarFileEntry(name);
                }
            };
            BytecodeManager.incBytecodes(1);
            return (Enumeration<String>)function;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Enumeration<JarEntry> entries2() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureInitialization();
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv != null) {
                final JarVerifier jv2 = this.jv;
                BytecodeManager.incBytecodes(5);
                final Enumeration entries = super.entries();
                BytecodeManager.incBytecodes(1);
                final Enumeration entries2 = jv2.entries2(this, entries);
                BytecodeManager.incBytecodes(1);
                return (Enumeration<JarEntry>)entries2;
            }
            BytecodeManager.incBytecodes(2);
            final Enumeration entries3 = super.entries();
            BytecodeManager.incBytecodes(1);
            final Enumeration enumeration = entries3;
            BytecodeManager.incBytecodes(5);
            final java.util.Enumeration<JarEntry> enumeration2 = new java.util.Enumeration<JarEntry>() {
                JarEntry entry;
                
                @Override
                public boolean hasMoreElements() {
                    if (this.entry != null) {
                        return true;
                    }
                    while (((Enumeration)enumeration).hasMoreElements()) {
                        final JarEntry je = ((Enumeration<JarEntry>)enumeration).nextElement();
                        if (JarVerifier.isSigningRelated(je.getName())) {
                            continue;
                        }
                        this.entry = je;
                        return true;
                    }
                    return false;
                }
                
                @Override
                public JarEntry nextElement() {
                    if (this.hasMoreElements()) {
                        final JarEntry je = this.entry;
                        this.entry = null;
                        return JarFile.this.newEntry(je);
                    }
                    throw new NoSuchElementException();
                }
            };
            BytecodeManager.incBytecodes(1);
            return (Enumeration<JarEntry>)enumeration2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    CodeSource[] getCodeSources(final URL url) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureInitialization();
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv != null) {
                final JarVerifier jv2 = this.jv;
                BytecodeManager.incBytecodes(5);
                final CodeSource[] codeSources = jv2.getCodeSources(this, url);
                BytecodeManager.incBytecodes(1);
                return codeSources;
            }
            BytecodeManager.incBytecodes(2);
            final Enumeration<String> unsignedEntryNames = this.unsignedEntryNames();
            BytecodeManager.incBytecodes(1);
            final Enumeration<String> enumeration = unsignedEntryNames;
            BytecodeManager.incBytecodes(2);
            final boolean hasMoreElements = enumeration.hasMoreElements();
            BytecodeManager.incBytecodes(1);
            if (hasMoreElements) {
                final CodeSource[] array = { null };
                final int n = 0;
                BytecodeManager.incBytecodes(5);
                array[n] = JarVerifier.getUnsignedCS(url);
                BytecodeManager.incBytecodes(2);
                return array;
            }
            final CodeSource[] array2 = null;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Enumeration<String> unsignedEntryNames() {
        try {
            BytecodeManager.incBytecodes(2);
            final Enumeration<JarEntry> entries = this.entries();
            BytecodeManager.incBytecodes(1);
            final Enumeration<JarEntry> enumeration = entries;
            BytecodeManager.incBytecodes(5);
            final java.util.Enumeration<String> enumeration2 = new java.util.Enumeration<String>() {
                String name;
                
                @Override
                public boolean hasMoreElements() {
                    if (this.name != null) {
                        return true;
                    }
                    while (((Enumeration)enumeration).hasMoreElements()) {
                        final ZipEntry e = ((Enumeration<ZipEntry>)enumeration).nextElement();
                        final String value = e.getName();
                        if (!e.isDirectory()) {
                            if (JarVerifier.isSigningRelated(value)) {
                                continue;
                            }
                            this.name = value;
                            return true;
                        }
                    }
                    return false;
                }
                
                @Override
                public String nextElement() {
                    if (this.hasMoreElements()) {
                        final String value = this.name;
                        this.name = null;
                        return value;
                    }
                    throw new NoSuchElementException();
                }
            };
            BytecodeManager.incBytecodes(1);
            return (Enumeration<String>)enumeration2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    CodeSource getCodeSource(final URL url, final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureInitialization();
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv == null) {
                BytecodeManager.incBytecodes(2);
                final CodeSource unsignedCS = JarVerifier.getUnsignedCS(url);
                BytecodeManager.incBytecodes(1);
                return unsignedCS;
            }
            final boolean eagerValidation = this.jv.eagerValidation;
            BytecodeManager.incBytecodes(4);
            if (eagerValidation) {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                final JarEntry jarEntry = this.getJarEntry(s);
                BytecodeManager.incBytecodes(1);
                final JarEntry jarEntry2 = jarEntry;
                BytecodeManager.incBytecodes(2);
                CodeSource codeSource;
                if (jarEntry2 != null) {
                    final JarVerifier jv2 = this.jv;
                    final JarEntry je = jarEntry;
                    BytecodeManager.incBytecodes(6);
                    codeSource = jv2.getCodeSource(url, this, je);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final JarVerifier jv3 = this.jv;
                    BytecodeManager.incBytecodes(5);
                    codeSource = jv3.getCodeSource(url, s);
                    BytecodeManager.incBytecodes(1);
                }
                final CodeSource codeSource2 = codeSource;
                BytecodeManager.incBytecodes(2);
                return codeSource2;
            }
            final JarVerifier jv4 = this.jv;
            BytecodeManager.incBytecodes(5);
            final CodeSource codeSource3 = jv4.getCodeSource(url, s);
            BytecodeManager.incBytecodes(1);
            return codeSource3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void setEagerValidation(final boolean eagerValidation) {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.maybeInstantiateVerifier();
                    BytecodeManager.incBytecodes(1);
                }
                catch (IOException ex) {
                    BytecodeManager.incBytecodes(501);
                    final IOException cause = ex;
                    BytecodeManager.incBytecodes(4);
                    final RuntimeException ex2 = new RuntimeException(cause);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final JarVerifier jv = this.jv;
                BytecodeManager.incBytecodes(3);
                if (jv != null) {
                    final JarVerifier jv2 = this.jv;
                    BytecodeManager.incBytecodes(4);
                    jv2.setEagerValidation(eagerValidation);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    List<Object> getManifestDigests() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureInitialization();
            final JarVerifier jv = this.jv;
            BytecodeManager.incBytecodes(3);
            if (jv != null) {
                final JarVerifier jv2 = this.jv;
                BytecodeManager.incBytecodes(3);
                final List manifestDigests = jv2.getManifestDigests();
                BytecodeManager.incBytecodes(1);
                return (List<Object>)manifestDigests;
            }
            BytecodeManager.incBytecodes(3);
            final ArrayList<Object> list = new ArrayList<Object>();
            BytecodeManager.incBytecodes(1);
            return list;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            final JavaUtilJarAccessImpl javaUtilJarAccess = new JavaUtilJarAccessImpl();
            BytecodeManager.incBytecodes(1);
            SharedSecrets.setJavaUtilJarAccess((JavaUtilJarAccess)javaUtilJarAccess);
            CLASSPATH_CHARS = new char[] { 'c', 'l', 'a', 's', 's', '-', 'p', 'a', 't', 'h' };
            BytecodeManager.incBytecodes(42);
            CLASSPATH_LASTOCC = new int[128];
            BytecodeManager.incBytecodes(2);
            CLASSPATH_OPTOSFT = new int[10];
            BytecodeManager.incBytecodes(2);
            JarFile.CLASSPATH_LASTOCC[99] = 1;
            BytecodeManager.incBytecodes(4);
            JarFile.CLASSPATH_LASTOCC[108] = 2;
            BytecodeManager.incBytecodes(4);
            JarFile.CLASSPATH_LASTOCC[115] = 5;
            BytecodeManager.incBytecodes(4);
            JarFile.CLASSPATH_LASTOCC[45] = 6;
            BytecodeManager.incBytecodes(4);
            JarFile.CLASSPATH_LASTOCC[112] = 7;
            BytecodeManager.incBytecodes(4);
            JarFile.CLASSPATH_LASTOCC[97] = 8;
            BytecodeManager.incBytecodes(4);
            JarFile.CLASSPATH_LASTOCC[116] = 9;
            BytecodeManager.incBytecodes(4);
            JarFile.CLASSPATH_LASTOCC[104] = 10;
            BytecodeManager.incBytecodes(4);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = 9;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                JarFile.CLASSPATH_OPTOSFT[n] = 10;
                BytecodeManager.incBytecodes(4);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            JarFile.CLASSPATH_OPTOSFT[9] = 1;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class JarFileEntry extends JarEntry
    {
        private String basename;
        
        JarFileEntry(final String name) {
            super(name);
            this.basename = name;
        }
        
        JarFileEntry(final String name, final ZipEntry vze) {
            super(vze);
            this.basename = name;
        }
        
        @Override
        public Attributes getAttributes() throws IOException {
            final Manifest man = JarFile.this.getManifest();
            if (man != null) {
                return man.getAttributes(super.getName());
            }
            return null;
        }
        
        @Override
        public Certificate[] getCertificates() {
            try {
                JarFile.this.maybeInstantiateVerifier();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (this.certs == null && JarFile.this.jv != null) {
                this.certs = JarFile.this.jv.getCerts(JarFile.this, this.realEntry());
            }
            return (Certificate[])((this.certs == null) ? null : ((Certificate[])this.certs.clone()));
        }
        
        @Override
        public CodeSigner[] getCodeSigners() {
            try {
                JarFile.this.maybeInstantiateVerifier();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (this.signers == null && JarFile.this.jv != null) {
                this.signers = JarFile.this.jv.getCodeSigners(JarFile.this, this.realEntry());
            }
            return (CodeSigner[])((this.signers == null) ? null : ((CodeSigner[])this.signers.clone()));
        }
        
        @Override
        public String getRealName() {
            return super.getName();
        }
        
        @Override
        public String getName() {
            return this.basename;
        }
        
        JarFileEntry realEntry() {
            if (JarFile.this.isMultiRelease() && JarFile.this.versionFeature != JarFile.BASE_VERSION_FEATURE) {
                final String entryName = super.getName();
                return (entryName == this.basename || entryName.equals(this.basename)) ? this : new JarFileEntry(entryName, this);
            }
            return this;
        }
        
        JarFileEntry withBasename(final String name) {
            this.basename = name;
            return this;
        }
    }
}
