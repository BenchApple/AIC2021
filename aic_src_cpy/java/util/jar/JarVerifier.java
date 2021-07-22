// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.util.Objects;
import java.io.InputStream;
import instrumented.java.util.HashSet;
import java.util.Collections;
import instrumented.java.util.Set;
import java.util.Iterator;
import java.security.cert.CertPath;
import instrumented.java.util.Collection;
import java.security.cert.Certificate;
import java.io.IOException;
import instrumented.java.util.Locale;
import sun.security.util.ManifestEntryVerifier;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import instrumented.java.util.HashMap;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Enumeration;
import java.security.CodeSource;
import java.net.URL;
import instrumented.java.util.Map;
import instrumented.java.util.List;
import sun.security.util.ManifestDigester;
import java.io.ByteArrayOutputStream;
import sun.security.util.SignatureFileVerifier;
import instrumented.java.util.ArrayList;
import java.security.CodeSigner;
import instrumented.java.util.Hashtable;
import sun.security.util.Debug;

class JarVerifier
{
    static final Debug debug;
    private Hashtable<String, CodeSigner[]> verifiedSigners;
    private Hashtable<String, CodeSigner[]> sigFileSigners;
    private Hashtable<String, byte[]> sigFileData;
    private ArrayList<SignatureFileVerifier> pendingBlocks;
    private ArrayList<CodeSigner[]> signerCache;
    private boolean parsingBlockOrSF;
    private boolean parsingMeta;
    private boolean anyToVerify;
    private ByteArrayOutputStream baos;
    private volatile ManifestDigester manDig;
    byte[] manifestRawBytes;
    boolean eagerValidation;
    private Object csdomain;
    private List<Object> manifestDigests;
    private Map<URL, Map<CodeSigner[], CodeSource>> urlToCodeSourceMap;
    private Map<CodeSigner[], CodeSource> signerToCodeSource;
    private URL lastURL;
    private Map<CodeSigner[], CodeSource> lastURLMap;
    private CodeSigner[] emptySigner;
    private Map<String, CodeSigner[]> signerMap;
    private Enumeration<String> emptyEnumeration;
    private List<CodeSigner[]> jarCodeSigners;
    
    public JarVerifier(final byte[] manifestRawBytes) {
        try {
            BytecodeManager.incBytecodes(2);
            this.parsingBlockOrSF = false;
            BytecodeManager.incBytecodes(3);
            this.parsingMeta = true;
            BytecodeManager.incBytecodes(3);
            this.anyToVerify = true;
            BytecodeManager.incBytecodes(3);
            this.manifestRawBytes = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.csdomain = new Object();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.urlToCodeSourceMap = new HashMap();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.signerToCodeSource = new HashMap();
            BytecodeManager.incBytecodes(1);
            this.emptySigner = new CodeSigner[0];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(5);
            this.emptyEnumeration = (Enumeration)new java.util.Enumeration<String>() {
                String name;
                final /* synthetic */ Enumeration val$entries;
                final /* synthetic */ java.util.Map val$map;
                
                @Override
                public boolean hasMoreElements() {
                    if (this.name != null) {
                        return true;
                    }
                    while (this.val$entries.hasMoreElements()) {
                        final ZipEntry e = this.val$entries.nextElement();
                        final String value = e.getName();
                        if (!e.isDirectory()) {
                            if (JarVerifier.isSigningRelated(value)) {
                                continue;
                            }
                            if (this.val$map.get(value) == null) {
                                this.name = value;
                                return true;
                            }
                            continue;
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
            this.manifestRawBytes = manifestRawBytes;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.sigFileSigners = new Hashtable();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.verifiedSigners = new Hashtable();
            BytecodeManager.incBytecodes(1);
            final int n = 11;
            BytecodeManager.incBytecodes(5);
            this.sigFileData = new Hashtable(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.pendingBlocks = new ArrayList();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.baos = new ByteArrayOutputStream();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.manifestDigests = new ArrayList();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void beginEntry(final JarEntry entry, final ManifestEntryVerifier manifestEntryVerifier) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            if (entry == null) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final Debug debug = JarVerifier.debug;
            BytecodeManager.incBytecodes(2);
            if (debug != null) {
                final Debug debug2 = JarVerifier.debug;
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb = new StringBuilder();
                final String str = "beginEntry ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final String name = entry.getName();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(name);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                debug2.println(string);
            }
            BytecodeManager.incBytecodes(2);
            String s = entry.getName();
            BytecodeManager.incBytecodes(1);
            final boolean parsingMeta = this.parsingMeta;
            BytecodeManager.incBytecodes(3);
            Label_0317: {
                if (parsingMeta) {
                    final String s2 = s;
                    final Locale english = Locale.ENGLISH;
                    BytecodeManager.incBytecodes(3);
                    final String upperCase = s2.toUpperCase(english);
                    BytecodeManager.incBytecodes(1);
                    final String s3 = upperCase;
                    final String prefix = "META-INF/";
                    BytecodeManager.incBytecodes(3);
                    final boolean startsWith = s3.startsWith(prefix);
                    BytecodeManager.incBytecodes(1);
                    if (!startsWith) {
                        final String s4 = upperCase;
                        final String prefix2 = "/META-INF/";
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean startsWith2 = s4.startsWith(prefix2);
                        BytecodeManager.incBytecodes(1);
                        if (!startsWith2) {
                            break Label_0317;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final boolean directory = entry.isDirectory();
                    BytecodeManager.incBytecodes(1);
                    if (directory) {
                        final String name2 = null;
                        BytecodeManager.incBytecodes(4);
                        manifestEntryVerifier.setEntry(name2, entry);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final String s5 = upperCase;
                    final String anObject = "META-INF/MANIFEST.MF";
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = s5.equals(anObject);
                    BytecodeManager.incBytecodes(1);
                    if (!equals) {
                        final String s6 = upperCase;
                        final String anObject2 = "META-INF/INDEX.LIST";
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean equals2 = s6.equals(anObject2);
                        BytecodeManager.incBytecodes(1);
                        if (!equals2) {
                            final String s7 = upperCase;
                            BytecodeManager.incBytecodes(2);
                            final boolean blockOrSF = SignatureFileVerifier.isBlockOrSF(s7);
                            BytecodeManager.incBytecodes(1);
                            if (blockOrSF) {
                                this.parsingBlockOrSF = true;
                                BytecodeManager.incBytecodes(3);
                                final ByteArrayOutputStream baos = this.baos;
                                BytecodeManager.incBytecodes(3);
                                baos.reset();
                                final String name3 = null;
                                BytecodeManager.incBytecodes(4);
                                manifestEntryVerifier.setEntry(name3, entry);
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            break Label_0317;
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            final boolean parsingMeta2 = this.parsingMeta;
            BytecodeManager.incBytecodes(3);
            if (parsingMeta2) {
                BytecodeManager.incBytecodes(2);
                this.doneWithMeta();
            }
            BytecodeManager.incBytecodes(2);
            final boolean directory2 = entry.isDirectory();
            BytecodeManager.incBytecodes(1);
            if (directory2) {
                final String name4 = null;
                BytecodeManager.incBytecodes(4);
                manifestEntryVerifier.setEntry(name4, entry);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final String s8 = s;
            final String prefix3 = "./";
            BytecodeManager.incBytecodes(3);
            final boolean startsWith3 = s8.startsWith(prefix3);
            BytecodeManager.incBytecodes(1);
            if (startsWith3) {
                final String s9 = s;
                final int beginIndex = 2;
                BytecodeManager.incBytecodes(3);
                s = s9.substring(beginIndex);
                BytecodeManager.incBytecodes(1);
            }
            final String s10 = s;
            final String prefix4 = "/";
            BytecodeManager.incBytecodes(3);
            final boolean startsWith4 = s10.startsWith(prefix4);
            BytecodeManager.incBytecodes(1);
            if (startsWith4) {
                final String s11 = s;
                final int beginIndex2 = 1;
                BytecodeManager.incBytecodes(3);
                s = s11.substring(beginIndex2);
                BytecodeManager.incBytecodes(1);
            }
            final Hashtable sigFileSigners = this.sigFileSigners;
            final String s12 = s;
            BytecodeManager.incBytecodes(4);
            final Object value = sigFileSigners.get(s12);
            BytecodeManager.incBytecodes(1);
            if (value == null) {
                final Hashtable verifiedSigners = this.verifiedSigners;
                final String s13 = s;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final Object value2 = verifiedSigners.get(s13);
                BytecodeManager.incBytecodes(1);
                if (value2 == null) {
                    final String name5 = null;
                    BytecodeManager.incBytecodes(4);
                    manifestEntryVerifier.setEntry(name5, entry);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            final String name6 = s;
            BytecodeManager.incBytecodes(4);
            manifestEntryVerifier.setEntry(name6, entry);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void update(final int b, final ManifestEntryVerifier mev) throws IOException {
        try {
            final int n = -1;
            BytecodeManager.incBytecodes(3);
            if (b != n) {
                final boolean parsingBlockOrSF = this.parsingBlockOrSF;
                BytecodeManager.incBytecodes(3);
                if (parsingBlockOrSF) {
                    final ByteArrayOutputStream baos = this.baos;
                    BytecodeManager.incBytecodes(4);
                    baos.write(b);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final byte buffer = (byte)b;
                    BytecodeManager.incBytecodes(4);
                    mev.update(buffer);
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.processEntry(mev);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void update(final int n, final byte[] array, final int n2, final int n3, final ManifestEntryVerifier mev) throws IOException {
        try {
            final int n4 = -1;
            BytecodeManager.incBytecodes(3);
            if (n != n4) {
                final boolean parsingBlockOrSF = this.parsingBlockOrSF;
                BytecodeManager.incBytecodes(3);
                if (parsingBlockOrSF) {
                    final ByteArrayOutputStream baos = this.baos;
                    BytecodeManager.incBytecodes(6);
                    baos.write(array, n2, n);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(5);
                    mev.update(array, n2, n);
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.processEntry(mev);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void processEntry(final ManifestEntryVerifier p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/jar/JarVerifier.parsingBlockOrSF:Z
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifne            104
        //    12: aload_1        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokevirtual   sun/security/util/ManifestEntryVerifier.getEntry:()Ljava/util/jar/JarEntry;
        //    21: astore_2       
        //    22: ldc             1
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: aload_2        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: ifnull          96
        //    36: aload_2        
        //    37: getfield        java/util/jar/JarEntry.signers:[Ljava/security/CodeSigner;
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnonnull       96
        //    48: aload_2        
        //    49: aload_1        
        //    50: aload_0        
        //    51: getfield        java/util/jar/JarVerifier.verifiedSigners:Linstrumented/java/util/Hashtable;
        //    54: aload_0        
        //    55: getfield        java/util/jar/JarVerifier.sigFileSigners:Linstrumented/java/util/Hashtable;
        //    58: ldc_w           7
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   sun/security/util/ManifestEntryVerifier.verify:(Linstrumented/java/util/Hashtable;Linstrumented/java/util/Hashtable;)[Ljava/security/CodeSigner;
        //    67: putfield        java/util/jar/JarEntry.signers:[Ljava/security/CodeSigner;
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aload_2        
        //    76: aload_2        
        //    77: getfield        java/util/jar/JarEntry.signers:[Ljava/security/CodeSigner;
        //    80: ldc             4
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokestatic    java/util/jar/JarVerifier.mapSignersToCertArray:([Ljava/security/CodeSigner;)[Ljava/security/cert/Certificate;
        //    88: putfield        java/util/jar/JarEntry.certs:[Ljava/security/cert/Certificate;
        //    91: ldc             1
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: goto            1068
        //   104: aload_0        
        //   105: iconst_0       
        //   106: putfield        java/util/jar/JarVerifier.parsingBlockOrSF:Z
        //   109: ldc             3
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   117: ldc             2
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: ifnull          139
        //   125: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   128: ldc_w           "processEntry: processing block"
        //   131: ldc             3
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   139: aload_1        
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokevirtual   sun/security/util/ManifestEntryVerifier.getEntry:()Ljava/util/jar/JarEntry;
        //   148: ldc             1
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: invokevirtual   java/util/jar/JarEntry.getName:()Ljava/lang/String;
        //   156: getstatic       instrumented/java/util/Locale.ENGLISH:Linstrumented/java/util/Locale;
        //   159: ldc             1
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: invokevirtual   java/lang/String.toUpperCase:(Linstrumented/java/util/Locale;)Ljava/lang/String;
        //   172: astore_2       
        //   173: ldc             1
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: aload_2        
        //   179: ldc_w           ".SF"
        //   182: ldc             3
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //   190: ldc             1
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: ifeq            414
        //   198: aload_2        
        //   199: iconst_0       
        //   200: aload_2        
        //   201: ldc             4
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokevirtual   java/lang/String.length:()I
        //   209: iconst_3       
        //   210: isub           
        //   211: ldc             3
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   219: astore_3       
        //   220: ldc             1
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: aload_0        
        //   226: getfield        java/util/jar/JarVerifier.baos:Ljava/io/ByteArrayOutputStream;
        //   229: ldc             3
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   237: astore          4
        //   239: ldc             1
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload_0        
        //   245: getfield        java/util/jar/JarVerifier.sigFileData:Linstrumented/java/util/Hashtable;
        //   248: aload_3        
        //   249: aload           4
        //   251: ldc             5
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: invokevirtual   instrumented/java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   259: pop            
        //   260: ldc             1
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: aload_0        
        //   266: getfield        java/util/jar/JarVerifier.pendingBlocks:Linstrumented/java/util/ArrayList;
        //   269: ldc             3
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokevirtual   instrumented/java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //   277: astore          5
        //   279: ldc             1
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: aload           5
        //   286: ldc             2
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: invokeinterface java/util/Iterator.hasNext:()Z
        //   296: ldc             1
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: ifeq            408
        //   304: aload           5
        //   306: ldc             2
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   316: checkcast       Lsun/security/util/SignatureFileVerifier;
        //   319: astore          6
        //   321: ldc             2
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: aload           6
        //   328: aload_3        
        //   329: ldc             3
        //   331: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   334: invokevirtual   sun/security/util/SignatureFileVerifier.needSignatureFile:(Ljava/lang/String;)Z
        //   337: ldc             1
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: ifeq            400
        //   345: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   348: ldc             2
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: ifnull          370
        //   356: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   359: ldc_w           "processEntry: processing pending block"
        //   362: ldc             3
        //   364: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   367: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   370: aload           6
        //   372: aload           4
        //   374: ldc             3
        //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   379: invokevirtual   sun/security/util/SignatureFileVerifier.setSignatureFile:([B)V
        //   382: aload           6
        //   384: aload_0        
        //   385: getfield        java/util/jar/JarVerifier.sigFileSigners:Linstrumented/java/util/Hashtable;
        //   388: aload_0        
        //   389: getfield        java/util/jar/JarVerifier.manifestDigests:Linstrumented/java/util/List;
        //   392: ldc             6
        //   394: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   397: invokevirtual   sun/security/util/SignatureFileVerifier.process:(Linstrumented/java/util/Hashtable;Linstrumented/java/util/List;)V
        //   400: ldc             1
        //   402: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   405: goto            284
        //   408: ldc             1
        //   410: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   413: return         
        //   414: aload_2        
        //   415: iconst_0       
        //   416: aload_2        
        //   417: ldc_w           "."
        //   420: ldc             5
        //   422: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   425: invokevirtual   java/lang/String.lastIndexOf:(Ljava/lang/String;)I
        //   428: ldc             1
        //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   433: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   436: astore_3       
        //   437: ldc             1
        //   439: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   442: aload_0        
        //   443: getfield        java/util/jar/JarVerifier.signerCache:Linstrumented/java/util/ArrayList;
        //   446: ldc             3
        //   448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   451: ifnonnull       475
        //   454: aload_0        
        //   455: new             Linstrumented/java/util/ArrayList;
        //   458: dup            
        //   459: ldc             4
        //   461: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   464: invokespecial   instrumented/java/util/ArrayList.<init>:()V
        //   467: putfield        java/util/jar/JarVerifier.signerCache:Linstrumented/java/util/ArrayList;
        //   470: ldc             1
        //   472: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   475: aload_0        
        //   476: getfield        java/util/jar/JarVerifier.manDig:Lsun/security/util/ManifestDigester;
        //   479: ldc             3
        //   481: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   484: ifnonnull       582
        //   487: aload_0        
        //   488: getfield        java/util/jar/JarVerifier.manifestRawBytes:[B
        //   491: dup            
        //   492: astore          4
        //   494: pop            
        //   495: ldc             5
        //   497: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   500: aload_0        
        //   501: getfield        java/util/jar/JarVerifier.manDig:Lsun/security/util/ManifestDigester;
        //   504: ldc             3
        //   506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   509: ifnonnull       547
        //   512: aload_0        
        //   513: new             Lsun/security/util/ManifestDigester;
        //   516: dup            
        //   517: aload_0        
        //   518: getfield        java/util/jar/JarVerifier.manifestRawBytes:[B
        //   521: ldc             6
        //   523: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   526: invokespecial   sun/security/util/ManifestDigester.<init>:([B)V
        //   529: putfield        java/util/jar/JarVerifier.manDig:Lsun/security/util/ManifestDigester;
        //   532: ldc             1
        //   534: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   537: aload_0        
        //   538: aconst_null    
        //   539: putfield        java/util/jar/JarVerifier.manifestRawBytes:[B
        //   542: ldc             3
        //   544: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   547: aload           4
        //   549: pop            
        //   550: ldc             2
        //   552: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   555: ldc             1
        //   557: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   560: goto            582
        //   563: astore          7
        //   565: aload           4
        //   567: pop            
        //   568: ldc_w           503
        //   571: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   574: aload           7
        //   576: ldc             2
        //   578: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   581: athrow         
        //   582: new             Lsun/security/util/SignatureFileVerifier;
        //   585: dup            
        //   586: aload_0        
        //   587: getfield        java/util/jar/JarVerifier.signerCache:Linstrumented/java/util/ArrayList;
        //   590: aload_0        
        //   591: getfield        java/util/jar/JarVerifier.manDig:Lsun/security/util/ManifestDigester;
        //   594: aload_2        
        //   595: aload_0        
        //   596: getfield        java/util/jar/JarVerifier.baos:Ljava/io/ByteArrayOutputStream;
        //   599: ldc_w           9
        //   602: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   605: ldc             1
        //   607: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   610: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   613: ldc             1
        //   615: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   618: invokespecial   sun/security/util/SignatureFileVerifier.<init>:(Linstrumented/java/util/ArrayList;Lsun/security/util/ManifestDigester;Ljava/lang/String;[B)V
        //   621: astore          4
        //   623: ldc             1
        //   625: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   628: aload           4
        //   630: ldc             2
        //   632: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   635: invokevirtual   sun/security/util/SignatureFileVerifier.needSignatureFileBytes:()Z
        //   638: ldc             1
        //   640: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   643: ifeq            742
        //   646: aload_0        
        //   647: getfield        java/util/jar/JarVerifier.sigFileData:Linstrumented/java/util/Hashtable;
        //   650: aload_3        
        //   651: ldc             4
        //   653: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   656: invokevirtual   instrumented/java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   659: checkcast       [B
        //   662: astore          5
        //   664: ldc             2
        //   666: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   669: aload           5
        //   671: ldc             2
        //   673: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   676: ifnonnull       730
        //   679: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   682: ldc             2
        //   684: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   687: ifnull          704
        //   690: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   693: ldc_w           "adding pending block"
        //   696: ldc             3
        //   698: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   701: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   704: aload_0        
        //   705: getfield        java/util/jar/JarVerifier.pendingBlocks:Linstrumented/java/util/ArrayList;
        //   708: aload           4
        //   710: ldc             4
        //   712: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   715: invokevirtual   instrumented/java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   718: pop            
        //   719: ldc             1
        //   721: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   724: ldc             1
        //   726: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   729: return         
        //   730: aload           4
        //   732: aload           5
        //   734: ldc             3
        //   736: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   739: invokevirtual   sun/security/util/SignatureFileVerifier.setSignatureFile:([B)V
        //   742: aload           4
        //   744: aload_0        
        //   745: getfield        java/util/jar/JarVerifier.sigFileSigners:Linstrumented/java/util/Hashtable;
        //   748: aload_0        
        //   749: getfield        java/util/jar/JarVerifier.manifestDigests:Linstrumented/java/util/List;
        //   752: ldc             6
        //   754: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   757: invokevirtual   sun/security/util/SignatureFileVerifier.process:(Linstrumented/java/util/Hashtable;Linstrumented/java/util/List;)V
        //   760: ldc             1
        //   762: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   765: goto            1068
        //   768: astore_2       
        //   769: ldc_w           501
        //   772: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   775: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   778: ldc             2
        //   780: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   783: ifnull          837
        //   786: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   789: new             Ljava/lang/StringBuilder;
        //   792: dup            
        //   793: ldc             4
        //   795: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   798: invokespecial   java/lang/StringBuilder.<init>:()V
        //   801: ldc_w           "processEntry caught: "
        //   804: ldc             2
        //   806: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   809: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   812: aload_2        
        //   813: ldc             2
        //   815: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   818: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   821: ldc             1
        //   823: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   826: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   829: ldc             1
        //   831: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   834: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   837: ldc             1
        //   839: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   842: goto            1068
        //   845: astore_2       
        //   846: ldc_w           501
        //   849: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   852: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   855: ldc             2
        //   857: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   860: ifnull          914
        //   863: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   866: new             Ljava/lang/StringBuilder;
        //   869: dup            
        //   870: ldc             4
        //   872: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   875: invokespecial   java/lang/StringBuilder.<init>:()V
        //   878: ldc_w           "processEntry caught: "
        //   881: ldc             2
        //   883: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   886: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   889: aload_2        
        //   890: ldc             2
        //   892: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   895: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   898: ldc             1
        //   900: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   903: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   906: ldc             1
        //   908: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   911: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   914: ldc             1
        //   916: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   919: goto            1068
        //   922: astore_2       
        //   923: ldc_w           501
        //   926: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   929: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   932: ldc             2
        //   934: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   937: ifnull          991
        //   940: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //   943: new             Ljava/lang/StringBuilder;
        //   946: dup            
        //   947: ldc             4
        //   949: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   952: invokespecial   java/lang/StringBuilder.<init>:()V
        //   955: ldc_w           "processEntry caught: "
        //   958: ldc             2
        //   960: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   963: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   966: aload_2        
        //   967: ldc             2
        //   969: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   972: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   975: ldc             1
        //   977: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   980: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   983: ldc             1
        //   985: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   988: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //   991: ldc             1
        //   993: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   996: goto            1068
        //   999: astore_2       
        //  1000: ldc_w           501
        //  1003: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1006: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //  1009: ldc             2
        //  1011: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1014: ifnull          1068
        //  1017: getstatic       java/util/jar/JarVerifier.debug:Lsun/security/util/Debug;
        //  1020: new             Ljava/lang/StringBuilder;
        //  1023: dup            
        //  1024: ldc             4
        //  1026: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1029: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1032: ldc_w           "processEntry caught: "
        //  1035: ldc             2
        //  1037: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1040: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1043: aload_2        
        //  1044: ldc             2
        //  1046: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1049: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //  1052: ldc             1
        //  1054: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1057: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1060: ldc             1
        //  1062: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1065: invokevirtual   sun/security/util/Debug.println:(Ljava/lang/String;)V
        //  1068: ldc             1
        //  1070: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1073: return         
        //  1074: athrow         
        //  1075: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 19 FB 00 60 07 22 FF 00 90 00 06 07 00 02 07 00 BC 07 00 AA 07 00 AA 07 01 29 07 01 2B 00 00 FC 00 55 07 00 CA FA 00 1D 07 F8 00 05 FC 00 3C 07 00 AA FC 00 47 07 00 04 4F 07 00 84 FA 00 12 FD 00 79 07 00 CA 07 01 29 19 FA 00 0B FF 00 19 00 02 07 00 02 07 00 BC 00 01 07 00 88 FB 00 44 47 07 00 F6 FB 00 44 47 07 00 F8 FB 00 44 47 07 00 FA FB 00 44 FF 00 05 00 00 00 01 07 00 84 FF 00 00 00 00 00 01 07 00 F4
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  104    1075   1075   1076   Ljava/lang/VirtualMachineError;
        //  500    555    563    582    Any
        //  563    574    563    582    Any
        //  104    408    768    845    Ljava/io/IOException;
        //  414    724    768    845    Ljava/io/IOException;
        //  730    760    768    845    Ljava/io/IOException;
        //  104    408    845    922    Ljava/security/SignatureException;
        //  414    724    845    922    Ljava/security/SignatureException;
        //  730    760    845    922    Ljava/security/SignatureException;
        //  104    408    922    999    Ljava/security/NoSuchAlgorithmException;
        //  414    724    922    999    Ljava/security/NoSuchAlgorithmException;
        //  730    760    922    999    Ljava/security/NoSuchAlgorithmException;
        //  104    408    999    1068   Ljava/security/cert/CertificateException;
        //  414    724    999    1068   Ljava/security/cert/CertificateException;
        //  730    760    999    1068   Ljava/security/cert/CertificateException;
        //  0      1074   1074   1075   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0104:
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
    
    @Deprecated
    public Certificate[] getCerts(final String name) {
        try {
            BytecodeManager.incBytecodes(3);
            final CodeSigner[] codeSigners = this.getCodeSigners(name);
            BytecodeManager.incBytecodes(1);
            final Certificate[] mapSignersToCertArray = mapSignersToCertArray(codeSigners);
            BytecodeManager.incBytecodes(1);
            return mapSignersToCertArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Certificate[] getCerts(final JarFile jar, final JarEntry entry) {
        try {
            BytecodeManager.incBytecodes(4);
            final CodeSigner[] codeSigners = this.getCodeSigners(jar, entry);
            BytecodeManager.incBytecodes(1);
            final Certificate[] mapSignersToCertArray = mapSignersToCertArray(codeSigners);
            BytecodeManager.incBytecodes(1);
            return mapSignersToCertArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CodeSigner[] getCodeSigners(final String s) {
        try {
            final Hashtable verifiedSigners = this.verifiedSigners;
            BytecodeManager.incBytecodes(4);
            final CodeSigner[] array = verifiedSigners.get(s);
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CodeSigner[] getCodeSigners(final JarFile p0, final JarEntry p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   java/util/jar/JarEntry.getName:()Ljava/lang/String;
        //     9: astore_3       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_0        
        //    16: getfield        java/util/jar/JarVerifier.eagerValidation:Z
        //    19: ldc             3
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifeq            150
        //    27: aload_0        
        //    28: getfield        java/util/jar/JarVerifier.sigFileSigners:Linstrumented/java/util/Hashtable;
        //    31: aload_3        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokevirtual   instrumented/java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    40: ldc             1
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          150
        //    48: aload_1        
        //    49: aload_2        
        //    50: ldc             3
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: invokevirtual   java/util/jar/JarFile.getInputStream:(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
        //    58: astore          4
        //    60: ldc             1
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: sipush          1024
        //    68: newarray        B
        //    70: astore          5
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: aload           5
        //    79: arraylength    
        //    80: istore          6
        //    82: ldc             3
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: iload           6
        //    89: iconst_m1      
        //    90: ldc             3
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: if_icmpeq       124
        //    98: aload           4
        //   100: aload           5
        //   102: iconst_0       
        //   103: aload           5
        //   105: arraylength    
        //   106: ldc             6
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   java/io/InputStream.read:([BII)I
        //   114: istore          6
        //   116: ldc             2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: goto            87
        //   124: aload           4
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokevirtual   java/io/InputStream.close:()V
        //   134: ldc             1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: goto            150
        //   142: astore          4
        //   144: ldc_w           501
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: aload_0        
        //   151: aload_3        
        //   152: ldc             3
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokevirtual   java/util/jar/JarVerifier.getCodeSigners:(Ljava/lang/String;)[Ljava/security/CodeSigner;
        //   160: ldc             1
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: areturn        
        //   166: athrow         
        //   167: athrow         
        //    StackMapTable: 00 06 FF 00 57 00 07 07 00 02 07 01 6F 07 00 95 07 00 AA 07 01 75 07 01 29 01 00 00 24 FF 00 11 00 04 07 00 02 07 01 6F 07 00 95 07 00 AA 00 01 07 00 88 07 FF 00 0F 00 00 00 01 07 00 84 FF 00 00 00 00 00 01 07 00 F4
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  48     167    167    168    Ljava/lang/VirtualMachineError;
        //  48     134    142    150    Ljava/io/IOException;
        //  0      166    166    167    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0087:
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
    
    private static Certificate[] mapSignersToCertArray(final CodeSigner[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(3);
                final ArrayList list = new ArrayList();
                BytecodeManager.incBytecodes(1);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = array.length;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= length) {
                        break;
                    }
                    final ArrayList list2 = list;
                    final CodeSigner codeSigner = array[n];
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final CertPath signerCertPath = codeSigner.getSignerCertPath();
                    BytecodeManager.incBytecodes(1);
                    final List certificates = signerCertPath.getCertificates();
                    BytecodeManager.incBytecodes(1);
                    list2.addAll(certificates);
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final ArrayList list3 = list;
                final ArrayList list4 = list;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final Certificate[] array2 = new Certificate[list4.size()];
                BytecodeManager.incBytecodes(1);
                final Certificate[] array3 = list3.toArray(array2);
                BytecodeManager.incBytecodes(2);
                return array3;
            }
            final Certificate[] array4 = null;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean nothingToVerify() {
        try {
            final boolean anyToVerify = this.anyToVerify;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (!anyToVerify) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void doneWithMeta() {
        try {
            this.parsingMeta = false;
            BytecodeManager.incBytecodes(3);
            final Hashtable sigFileSigners = this.sigFileSigners;
            BytecodeManager.incBytecodes(4);
            final boolean empty = sigFileSigners.isEmpty();
            BytecodeManager.incBytecodes(1);
            boolean anyToVerify;
            if (!empty) {
                anyToVerify = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                anyToVerify = false;
                BytecodeManager.incBytecodes(1);
            }
            this.anyToVerify = anyToVerify;
            BytecodeManager.incBytecodes(1);
            this.baos = null;
            BytecodeManager.incBytecodes(3);
            this.sigFileData = null;
            BytecodeManager.incBytecodes(3);
            this.pendingBlocks = null;
            BytecodeManager.incBytecodes(3);
            this.signerCache = null;
            BytecodeManager.incBytecodes(3);
            this.manDig = null;
            BytecodeManager.incBytecodes(3);
            final Hashtable sigFileSigners2 = this.sigFileSigners;
            final String s = "META-INF/MANIFEST.MF";
            BytecodeManager.incBytecodes(4);
            final boolean containsKey = sigFileSigners2.containsKey(s);
            BytecodeManager.incBytecodes(1);
            if (containsKey) {
                final Hashtable sigFileSigners3 = this.sigFileSigners;
                final String s2 = "META-INF/MANIFEST.MF";
                BytecodeManager.incBytecodes(4);
                final CodeSigner[] array = sigFileSigners3.remove(s2);
                BytecodeManager.incBytecodes(2);
                final Hashtable verifiedSigners = this.verifiedSigners;
                final String s3 = "META-INF/MANIFEST.MF";
                final CodeSigner[] array2 = array;
                BytecodeManager.incBytecodes(5);
                verifiedSigners.put(s3, array2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized CodeSource mapSignersToCodeSource(final URL url, final CodeSigner[] signers) {
        try {
            final URL lastURL = this.lastURL;
            BytecodeManager.incBytecodes(4);
            Object lastURLMap;
            if (url == lastURL) {
                lastURLMap = this.lastURLMap;
                BytecodeManager.incBytecodes(4);
            }
            else {
                final Map urlToCodeSourceMap = this.urlToCodeSourceMap;
                BytecodeManager.incBytecodes(4);
                lastURLMap = urlToCodeSourceMap.get(url);
                BytecodeManager.incBytecodes(2);
                final Map map = (Map)lastURLMap;
                BytecodeManager.incBytecodes(2);
                if (map == null) {
                    BytecodeManager.incBytecodes(3);
                    lastURLMap = new HashMap<Object, Object>();
                    BytecodeManager.incBytecodes(1);
                    final Map urlToCodeSourceMap2 = this.urlToCodeSourceMap;
                    final Map map2 = (Map)lastURLMap;
                    BytecodeManager.incBytecodes(5);
                    urlToCodeSourceMap2.put(url, map2);
                    BytecodeManager.incBytecodes(1);
                }
                this.lastURLMap = (Map)lastURLMap;
                BytecodeManager.incBytecodes(3);
                this.lastURL = url;
                BytecodeManager.incBytecodes(3);
            }
            final HashMap hashMap = (HashMap)lastURLMap;
            BytecodeManager.incBytecodes(3);
            CodeSource codeSource = hashMap.get(signers);
            BytecodeManager.incBytecodes(2);
            final CodeSource codeSource2 = codeSource;
            BytecodeManager.incBytecodes(2);
            if (codeSource2 == null) {
                final Object csdomain = this.csdomain;
                BytecodeManager.incBytecodes(7);
                codeSource = new VerifierCodeSource(csdomain, url, signers);
                BytecodeManager.incBytecodes(1);
                final Map signerToCodeSource = this.signerToCodeSource;
                final CodeSource codeSource3 = codeSource;
                BytecodeManager.incBytecodes(5);
                signerToCodeSource.put(signers, codeSource3);
                BytecodeManager.incBytecodes(1);
            }
            final CodeSource codeSource4 = codeSource;
            BytecodeManager.incBytecodes(2);
            return codeSource4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CodeSource[] mapSignersToCodeSources(final URL url, final List<CodeSigner[]> list, final boolean b) {
        try {
            BytecodeManager.incBytecodes(3);
            final ArrayList<CodeSource> list2 = new ArrayList<CodeSource>();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(3);
                final int size = list.size();
                BytecodeManager.incBytecodes(1);
                if (n2 >= size) {
                    break;
                }
                final ArrayList<CodeSource> list3 = list2;
                final int n3 = n;
                BytecodeManager.incBytecodes(6);
                final CodeSigner[] signers = list.get(n3);
                BytecodeManager.incBytecodes(2);
                final CodeSource mapSignersToCodeSource = this.mapSignersToCodeSource(url, signers);
                BytecodeManager.incBytecodes(1);
                list3.add(mapSignersToCodeSource);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            if (b) {
                final ArrayList<CodeSource> list4 = list2;
                final CodeSigner[] signers2 = null;
                BytecodeManager.incBytecodes(5);
                final CodeSource mapSignersToCodeSource2 = this.mapSignersToCodeSource(url, signers2);
                BytecodeManager.incBytecodes(1);
                list4.add(mapSignersToCodeSource2);
                BytecodeManager.incBytecodes(1);
            }
            final ArrayList<CodeSource> list5 = list2;
            final ArrayList<CodeSource> list6 = list2;
            BytecodeManager.incBytecodes(3);
            final CodeSource[] array = new CodeSource[list6.size()];
            BytecodeManager.incBytecodes(1);
            final CodeSource[] array2 = list5.toArray(array);
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CodeSigner[] findMatchingSigners(final CodeSource codeSource) {
        try {
            final boolean b = codeSource instanceof VerifierCodeSource;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final VerifierCodeSource verifierCodeSource = (VerifierCodeSource)codeSource;
                BytecodeManager.incBytecodes(3);
                final VerifierCodeSource verifierCodeSource2 = verifierCodeSource;
                final Object csdomain = this.csdomain;
                BytecodeManager.incBytecodes(4);
                final boolean sameDomain = verifierCodeSource2.isSameDomain(csdomain);
                BytecodeManager.incBytecodes(1);
                if (sameDomain) {
                    final VerifierCodeSource verifierCodeSource3 = (VerifierCodeSource)codeSource;
                    BytecodeManager.incBytecodes(3);
                    final CodeSigner[] access$000 = VerifierCodeSource.access$000(verifierCodeSource3);
                    BytecodeManager.incBytecodes(1);
                    return access$000;
                }
            }
            BytecodeManager.incBytecodes(3);
            final URL location = codeSource.getLocation();
            BytecodeManager.incBytecodes(2);
            final List jarCodeSigners = this.getJarCodeSigners();
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            final CodeSource[] mapSignersToCodeSources = this.mapSignersToCodeSources(location, jarCodeSigners, b2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final ArrayList<VerifierCodeSource> list = new ArrayList<VerifierCodeSource>();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = mapSignersToCodeSources.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final ArrayList<VerifierCodeSource> list2 = list;
                final CodeSource codeSource2 = mapSignersToCodeSources[n];
                BytecodeManager.incBytecodes(5);
                list2.add((VerifierCodeSource)codeSource2);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final ArrayList<VerifierCodeSource> list3 = list;
            BytecodeManager.incBytecodes(3);
            final int index = list3.indexOf(codeSource);
            BytecodeManager.incBytecodes(1);
            final int n3 = index;
            final int n4 = -1;
            BytecodeManager.incBytecodes(3);
            if (n3 != n4) {
                final ArrayList<VerifierCodeSource> list4 = list;
                final int n5 = index;
                BytecodeManager.incBytecodes(3);
                final VerifierCodeSource verifierCodeSource4 = list4.get(n5);
                BytecodeManager.incBytecodes(2);
                CodeSigner[] array = VerifierCodeSource.access$000(verifierCodeSource4);
                BytecodeManager.incBytecodes(1);
                final CodeSigner[] array2 = array;
                BytecodeManager.incBytecodes(2);
                if (array2 == null) {
                    array = this.emptySigner;
                    BytecodeManager.incBytecodes(3);
                }
                final CodeSigner[] array3 = array;
                BytecodeManager.incBytecodes(2);
                return array3;
            }
            final CodeSigner[] array4 = null;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized Map<String, CodeSigner[]> signerMap() {
        try {
            final Map signerMap = this.signerMap;
            BytecodeManager.incBytecodes(3);
            if (signerMap == null) {
                final Hashtable verifiedSigners = this.verifiedSigners;
                BytecodeManager.incBytecodes(6);
                final int size = verifiedSigners.size();
                final Hashtable sigFileSigners = this.sigFileSigners;
                BytecodeManager.incBytecodes(3);
                final int n = size + sigFileSigners.size();
                BytecodeManager.incBytecodes(2);
                this.signerMap = new HashMap(n);
                BytecodeManager.incBytecodes(1);
                final Map signerMap2 = this.signerMap;
                final Hashtable verifiedSigners2 = this.verifiedSigners;
                BytecodeManager.incBytecodes(5);
                signerMap2.putAll(verifiedSigners2);
                final Map signerMap3 = this.signerMap;
                final Hashtable sigFileSigners2 = this.sigFileSigners;
                BytecodeManager.incBytecodes(5);
                signerMap3.putAll(sigFileSigners2);
            }
            final Map signerMap4 = this.signerMap;
            BytecodeManager.incBytecodes(3);
            return (Map<String, CodeSigner[]>)signerMap4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized Enumeration<String> entryNames(final JarFile jarFile, final CodeSource[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final Map signerMap = this.signerMap();
            BytecodeManager.incBytecodes(1);
            final Map map = signerMap;
            BytecodeManager.incBytecodes(2);
            final Set entrySet = map.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            final ArrayList list = new ArrayList<CodeSigner[]>(length);
            BytecodeManager.incBytecodes(1);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(4);
                if (n3 >= length2) {
                    break;
                }
                final CodeSource cs = array[n2];
                BytecodeManager.incBytecodes(5);
                final CodeSigner[] matchingSigners = this.findMatchingSigners(cs);
                BytecodeManager.incBytecodes(1);
                final CodeSigner[] array2 = matchingSigners;
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length3 = matchingSigners.length;
                    BytecodeManager.incBytecodes(3);
                    if (length3 > 0) {
                        final ArrayList list2 = list;
                        final CodeSigner[] array3 = matchingSigners;
                        BytecodeManager.incBytecodes(3);
                        list2.add(array3);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n = 1;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                else {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final ArrayList list3 = list;
            BytecodeManager.incBytecodes(2);
            final int n4 = n;
            BytecodeManager.incBytecodes(2);
            Enumeration enumeration;
            if (n4 != 0) {
                BytecodeManager.incBytecodes(3);
                enumeration = this.unsignedEntryNames(jarFile);
                BytecodeManager.incBytecodes(1);
            }
            else {
                enumeration = this.emptyEnumeration;
                BytecodeManager.incBytecodes(2);
            }
            final Enumeration enumeration2 = enumeration;
            BytecodeManager.incBytecodes(1);
            final Iterator iterator2 = iterator;
            final ArrayList list4 = list3;
            final Enumeration enumeration3 = enumeration2;
            BytecodeManager.incBytecodes(7);
            final java.util.Enumeration<String> enumeration4 = new java.util.Enumeration<String>(this, iterator2, list4, enumeration3) {
                String name;
                
                @Override
                public boolean hasMoreElements() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Could not show original bytecode, likely due to the same error.
                    // 
                    // The error that occurred was:
                    // 
                    // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'java/util/jar/JarVerifier$1.hasMoreElements:()Z'.
                    //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:66)
                    //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
                    //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
                    // Caused by: java.lang.ClassCastException: class com.strobel.assembler.ir.ConstantPool$Utf8StringConstantEntry cannot be cast to class com.strobel.assembler.ir.ConstantPool$InvokeDynamicInfoEntry (com.strobel.assembler.ir.ConstantPool$Utf8StringConstantEntry and com.strobel.assembler.ir.ConstantPool$InvokeDynamicInfoEntry are in unnamed module of loader 'app')
                    //     at com.strobel.assembler.metadata.ClassFileReader$Scope.lookupDynamicCallSite(ClassFileReader.java:1271)
                    //     at com.strobel.assembler.metadata.MethodReader.readBodyCore(MethodReader.java:196)
                    //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:62)
                    //     ... 33 more
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
                
                @Override
                public String nextElement() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Could not show original bytecode, likely due to the same error.
                    // 
                    // The error that occurred was:
                    // 
                    // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'java/util/jar/JarVerifier$1.nextElement:()Ljava/lang/String;'.
                    //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:66)
                    //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
                    //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
                    // Caused by: java.lang.ClassCastException: class com.strobel.assembler.ir.ConstantPool$Utf8StringConstantEntry cannot be cast to class com.strobel.assembler.ir.ConstantPool$FieldReferenceEntry (com.strobel.assembler.ir.ConstantPool$Utf8StringConstantEntry and com.strobel.assembler.ir.ConstantPool$FieldReferenceEntry are in unnamed module of loader 'app')
                    //     at com.strobel.assembler.metadata.ClassFileReader$Scope.lookupField(ClassFileReader.java:1232)
                    //     at com.strobel.assembler.metadata.MethodReader.readBodyCore(MethodReader.java:214)
                    //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:62)
                    //     ... 33 more
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            };
            BytecodeManager.incBytecodes(1);
            return (Enumeration<String>)enumeration4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<JarEntry> entries2(final JarFile jarFile, final Enumeration<? extends ZipEntry> enumeration) {
        try {
            BytecodeManager.incBytecodes(3);
            final HashMap hashMap = new HashMap();
            BytecodeManager.incBytecodes(1);
            final HashMap hashMap2 = hashMap;
            BytecodeManager.incBytecodes(3);
            final Map signerMap = this.signerMap();
            BytecodeManager.incBytecodes(1);
            hashMap2.putAll(signerMap);
            BytecodeManager.incBytecodes(2);
            final HashMap hashMap3 = hashMap;
            BytecodeManager.incBytecodes(7);
            final java.util.Enumeration<JarEntry> enumeration2 = new java.util.Enumeration<JarEntry>() {
                Enumeration<String> signers = null;
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
                        this.entry = jarFile.newEntry(je);
                        return true;
                    }
                    if (this.signers == null) {
                        this.signers = Collections.enumeration((java.util.Collection<String>)((java.util.Map)hashMap3).keySet());
                    }
                    if (this.signers.hasMoreElements()) {
                        final String name = this.signers.nextElement();
                        this.entry = jarFile.newEntry(name);
                        return true;
                    }
                    return false;
                }
                
                @Override
                public JarEntry nextElement() {
                    if (this.hasMoreElements()) {
                        final JarEntry je = this.entry;
                        ((java.util.Map)hashMap3).remove(je.getName());
                        this.entry = null;
                        return je;
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
    
    static boolean isSigningRelated(final String name) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean signingRelated = SignatureFileVerifier.isSigningRelated(name);
            BytecodeManager.incBytecodes(1);
            return signingRelated;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Enumeration<String> unsignedEntryNames(final JarFile jarFile) {
        try {
            BytecodeManager.incBytecodes(2);
            final Map signerMap = this.signerMap();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Enumeration<JarEntry> entries = jarFile.entries();
            BytecodeManager.incBytecodes(1);
            final Enumeration<JarEntry> enumeration = entries;
            final Map map = signerMap;
            BytecodeManager.incBytecodes(6);
            final JarVerifier.JarVerifier$4 jarVerifier$4 = new JarVerifier.JarVerifier$4(this, (Enumeration)enumeration, map);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<String>)jarVerifier$4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized List<CodeSigner[]> getJarCodeSigners() {
        try {
            final List jarCodeSigners = this.jarCodeSigners;
            BytecodeManager.incBytecodes(3);
            if (jarCodeSigners == null) {
                BytecodeManager.incBytecodes(3);
                final HashSet set = new HashSet();
                BytecodeManager.incBytecodes(1);
                final HashSet set2 = set;
                BytecodeManager.incBytecodes(3);
                final Map signerMap = this.signerMap();
                BytecodeManager.incBytecodes(1);
                final Collection<? extends E> values = signerMap.values();
                BytecodeManager.incBytecodes(1);
                set2.addAll(values);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(4);
                this.jarCodeSigners = new ArrayList();
                BytecodeManager.incBytecodes(1);
                final List jarCodeSigners2 = this.jarCodeSigners;
                final HashSet set3 = set;
                BytecodeManager.incBytecodes(4);
                jarCodeSigners2.addAll(set3);
                BytecodeManager.incBytecodes(1);
            }
            final List jarCodeSigners3 = this.jarCodeSigners;
            BytecodeManager.incBytecodes(3);
            return (List<CodeSigner[]>)jarCodeSigners3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized CodeSource[] getCodeSources(final JarFile jarFile, final URL url) {
        try {
            BytecodeManager.incBytecodes(3);
            final Enumeration unsignedEntryNames = this.unsignedEntryNames(jarFile);
            BytecodeManager.incBytecodes(1);
            final boolean hasMoreElements = unsignedEntryNames.hasMoreElements();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final List jarCodeSigners = this.getJarCodeSigners();
            final boolean b = hasMoreElements;
            BytecodeManager.incBytecodes(2);
            final CodeSource[] mapSignersToCodeSources = this.mapSignersToCodeSources(url, jarCodeSigners, b);
            BytecodeManager.incBytecodes(1);
            return mapSignersToCodeSources;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CodeSource getCodeSource(final URL url, final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final Map signerMap = this.signerMap();
            BytecodeManager.incBytecodes(2);
            final CodeSigner[] array = signerMap.get(s);
            BytecodeManager.incBytecodes(2);
            final CodeSigner[] signers = array;
            BytecodeManager.incBytecodes(4);
            final CodeSource mapSignersToCodeSource = this.mapSignersToCodeSource(url, signers);
            BytecodeManager.incBytecodes(1);
            return mapSignersToCodeSource;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CodeSource getCodeSource(final URL url, final JarFile jar, final JarEntry entry) {
        try {
            BytecodeManager.incBytecodes(6);
            final CodeSigner[] codeSigners = this.getCodeSigners(jar, entry);
            BytecodeManager.incBytecodes(1);
            final CodeSource mapSignersToCodeSource = this.mapSignersToCodeSource(url, codeSigners);
            BytecodeManager.incBytecodes(1);
            return mapSignersToCodeSource;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setEagerValidation(final boolean eagerValidation) {
        try {
            this.eagerValidation = eagerValidation;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized List<Object> getManifestDigests() {
        try {
            final List manifestDigests = this.manifestDigests;
            BytecodeManager.incBytecodes(3);
            final List<Object> unmodifiableList = instrumented.java.util.Collections.unmodifiableList((List<?>)manifestDigests);
            BytecodeManager.incBytecodes(1);
            return unmodifiableList;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static CodeSource getUnsignedCS(final URL location) {
        try {
            final Object csdomain = null;
            final Certificate[] certs = null;
            BytecodeManager.incBytecodes(7);
            final VerifierCodeSource verifierCodeSource = new VerifierCodeSource(csdomain, location, certs);
            BytecodeManager.incBytecodes(1);
            return verifierCodeSource;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String option = "jar";
            BytecodeManager.incBytecodes(2);
            debug = Debug.getInstance(option);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class VerifierStream extends InputStream
    {
        private InputStream is;
        private JarVerifier jv;
        private ManifestEntryVerifier mev;
        private long numLeft;
        
        VerifierStream(final Manifest man, final JarEntry je, final InputStream is, final JarVerifier jv) throws IOException {
            this.is = Objects.requireNonNull(is);
            this.jv = jv;
            this.mev = new ManifestEntryVerifier(man);
            this.jv.beginEntry(je, this.mev);
            this.numLeft = je.getSize();
            if (this.numLeft == 0L) {
                this.jv.update(-1, this.mev);
            }
        }
        
        @Override
        public int read() throws IOException {
            this.ensureOpen();
            if (this.numLeft > 0L) {
                final int b = this.is.read();
                this.jv.update(b, this.mev);
                --this.numLeft;
                if (this.numLeft == 0L) {
                    this.jv.update(-1, this.mev);
                }
                return b;
            }
            return -1;
        }
        
        @Override
        public int read(final byte[] b, final int off, int len) throws IOException {
            this.ensureOpen();
            if (this.numLeft > 0L && this.numLeft < len) {
                len = (int)this.numLeft;
            }
            if (this.numLeft > 0L) {
                final int n = this.is.read(b, off, len);
                this.jv.update(n, b, off, len, this.mev);
                this.numLeft -= n;
                if (this.numLeft == 0L) {
                    this.jv.update(-1, b, off, len, this.mev);
                }
                return n;
            }
            return -1;
        }
        
        @Override
        public void close() throws IOException {
            if (this.is != null) {
                this.is.close();
            }
            this.is = null;
            this.mev = null;
            this.jv = null;
        }
        
        @Override
        public int available() throws IOException {
            this.ensureOpen();
            return this.is.available();
        }
        
        private void ensureOpen() throws IOException {
            if (this.is == null) {
                throw new IOException("stream closed");
            }
        }
    }
    
    private static class VerifierCodeSource extends CodeSource
    {
        private static final long serialVersionUID = -9047366145967768825L;
        URL vlocation;
        CodeSigner[] vsigners;
        Certificate[] vcerts;
        Object csdomain;
        
        VerifierCodeSource(final Object csdomain, final URL location, final CodeSigner[] signers) {
            super(location, signers);
            this.csdomain = csdomain;
            this.vlocation = location;
            this.vsigners = signers;
        }
        
        VerifierCodeSource(final Object csdomain, final URL location, final Certificate[] certs) {
            super(location, certs);
            this.csdomain = csdomain;
            this.vlocation = location;
            this.vcerts = certs;
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof VerifierCodeSource) {
                final VerifierCodeSource that = (VerifierCodeSource)obj;
                if (this.isSameDomain(that.csdomain)) {
                    if (that.vsigners != this.vsigners || that.vcerts != this.vcerts) {
                        return false;
                    }
                    if (that.vlocation != null) {
                        return that.vlocation.equals(this.vlocation);
                    }
                    return this.vlocation == null || this.vlocation.equals(that.vlocation);
                }
            }
            return super.equals(obj);
        }
        
        boolean isSameDomain(final Object csdomain) {
            return this.csdomain == csdomain;
        }
        
        private CodeSigner[] getPrivateSigners() {
            return this.vsigners;
        }
        
        private Certificate[] getPrivateCertificates() {
            return this.vcerts;
        }
    }
}
