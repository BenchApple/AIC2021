// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import instrumented.java.util.concurrent.ConcurrentHashMap;
import sun.util.logging.PlatformLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import instrumented.java.util.regex.Pattern;
import java.io.IOException;
import java.io.DataInputStream;
import java.util.spi.LocaleServiceProvider;
import sun.util.locale.provider.LocaleServiceProviderPool;
import instrumented.java.util.spi.CurrencyNameProvider;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.concurrent.ConcurrentMap;
import java.io.Serializable;

public final class Currency implements Serializable
{
    private static final long serialVersionUID = -158308464356906721L;
    private final String currencyCode;
    private final transient int defaultFractionDigits;
    private final transient int numericCode;
    private static ConcurrentMap<String, Currency> instances;
    private static HashSet<Currency> available;
    static int formatVersion;
    static int dataVersion;
    static int[] mainTable;
    static long[] scCutOverTimes;
    static String[] scOldCurrencies;
    static String[] scNewCurrencies;
    static int[] scOldCurrenciesDFD;
    static int[] scNewCurrenciesDFD;
    static int[] scOldCurrenciesNumericCode;
    static int[] scNewCurrenciesNumericCode;
    static String otherCurrencies;
    static int[] otherCurrenciesDFD;
    static int[] otherCurrenciesNumericCode;
    private static final int MAGIC_NUMBER = 1131770436;
    private static final int A_TO_Z = 26;
    private static final int INVALID_COUNTRY_ENTRY = 127;
    private static final int COUNTRY_WITHOUT_CURRENCY_ENTRY = 512;
    private static final int SIMPLE_CASE_COUNTRY_MASK = 0;
    private static final int SIMPLE_CASE_COUNTRY_FINAL_CHAR_MASK = 31;
    private static final int SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_MASK = 480;
    private static final int SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_SHIFT = 5;
    private static final int SIMPLE_CASE_COUNTRY_MAX_DEFAULT_DIGITS = 9;
    private static final int SPECIAL_CASE_COUNTRY_MASK = 512;
    private static final int SPECIAL_CASE_COUNTRY_INDEX_MASK = 31;
    private static final int SPECIAL_CASE_COUNTRY_INDEX_DELTA = 1;
    private static final int COUNTRY_TYPE_MASK = 512;
    private static final int NUMERIC_CODE_MASK = 1047552;
    private static final int NUMERIC_CODE_SHIFT = 10;
    private static final int VALID_FORMAT_VERSION = 2;
    private static final int SYMBOL = 0;
    private static final int DISPLAYNAME = 1;
    
    private Currency(final String currencyCode, final int defaultFractionDigits, final int numericCode) {
        try {
            BytecodeManager.incBytecodes(2);
            this.currencyCode = currencyCode;
            BytecodeManager.incBytecodes(3);
            this.defaultFractionDigits = defaultFractionDigits;
            BytecodeManager.incBytecodes(3);
            this.numericCode = numericCode;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Currency getInstance(final String s) {
        try {
            final int n = Integer.MIN_VALUE;
            final int n2 = 0;
            BytecodeManager.incBytecodes(4);
            final Currency instance = getInstance(s, n, n2);
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Currency getInstance(final String str, int n, int n2) {
        try {
            final ConcurrentMap<String, Currency> instances = Currency.instances;
            BytecodeManager.incBytecodes(3);
            final Currency currency = instances.get(str);
            BytecodeManager.incBytecodes(2);
            final Currency currency2 = currency;
            BytecodeManager.incBytecodes(2);
            if (currency2 != null) {
                final Currency currency3 = currency;
                BytecodeManager.incBytecodes(2);
                return currency3;
            }
            final int n3 = n;
            final int n4 = Integer.MIN_VALUE;
            BytecodeManager.incBytecodes(3);
            Label_0341: {
                if (n3 == n4) {
                    BytecodeManager.incBytecodes(2);
                    final int length = str.length();
                    final int n5 = 3;
                    BytecodeManager.incBytecodes(2);
                    if (length != n5) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalArgumentException ex = new IllegalArgumentException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final int index = 0;
                    BytecodeManager.incBytecodes(3);
                    final char char1 = str.charAt(index);
                    BytecodeManager.incBytecodes(1);
                    final int index2 = 1;
                    BytecodeManager.incBytecodes(3);
                    final char char2 = str.charAt(index2);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final char c2 = char2;
                    BytecodeManager.incBytecodes(3);
                    final int mainTableEntry = getMainTableEntry(c, c2);
                    BytecodeManager.incBytecodes(1);
                    final int n6 = mainTableEntry & 0x200;
                    BytecodeManager.incBytecodes(4);
                    if (n6 == 0) {
                        final int n7 = mainTableEntry;
                        final int n8 = 127;
                        BytecodeManager.incBytecodes(3);
                        if (n7 != n8) {
                            final int index3 = 2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int n9 = str.charAt(index3) - 'A';
                            final int n10 = mainTableEntry & 0x1F;
                            BytecodeManager.incBytecodes(6);
                            if (n9 == n10) {
                                n = (mainTableEntry & 0x1E0) >> 5;
                                BytecodeManager.incBytecodes(6);
                                n2 = (mainTableEntry & 0xFFC00) >> 10;
                                BytecodeManager.incBytecodes(7);
                                break Label_0341;
                            }
                        }
                    }
                    final int index4 = 2;
                    BytecodeManager.incBytecodes(3);
                    final char char3 = str.charAt(index4);
                    final int n11 = '-';
                    BytecodeManager.incBytecodes(2);
                    if (char3 == n11) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalArgumentException ex2 = new IllegalArgumentException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final String otherCurrencies = Currency.otherCurrencies;
                    BytecodeManager.incBytecodes(3);
                    final int index5 = otherCurrencies.indexOf(str);
                    BytecodeManager.incBytecodes(1);
                    final int n12 = index5;
                    final int n13 = -1;
                    BytecodeManager.incBytecodes(3);
                    if (n12 == n13) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalArgumentException ex3 = new IllegalArgumentException();
                        BytecodeManager.incBytecodes(1);
                        throw ex3;
                    }
                    n = Currency.otherCurrenciesDFD[index5 / 4];
                    BytecodeManager.incBytecodes(6);
                    n2 = Currency.otherCurrenciesNumericCode[index5 / 4];
                    BytecodeManager.incBytecodes(6);
                }
            }
            final int n14 = n;
            final int n15 = n2;
            BytecodeManager.incBytecodes(6);
            final Currency currency4 = new Currency(str, n14, n15);
            BytecodeManager.incBytecodes(1);
            final ConcurrentMap<String, Currency> instances2 = Currency.instances;
            final Currency currency5 = currency4;
            BytecodeManager.incBytecodes(4);
            final Currency currency6 = instances2.putIfAbsent(str, currency5);
            BytecodeManager.incBytecodes(2);
            final Currency currency7 = currency6;
            BytecodeManager.incBytecodes(2);
            Currency currency8;
            if (currency7 != null) {
                currency8 = currency6;
                BytecodeManager.incBytecodes(2);
            }
            else {
                currency8 = currency4;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return currency8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Currency getInstance(final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            final String country = locale.getCountry();
            BytecodeManager.incBytecodes(1);
            final String s = country;
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final String s2 = country;
            BytecodeManager.incBytecodes(2);
            final int length = s2.length();
            final int n = 2;
            BytecodeManager.incBytecodes(2);
            if (length != n) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex2 = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final String s3 = country;
            final int index = 0;
            BytecodeManager.incBytecodes(3);
            final char char1 = s3.charAt(index);
            BytecodeManager.incBytecodes(1);
            final String s4 = country;
            final int index2 = 1;
            BytecodeManager.incBytecodes(3);
            final char char2 = s4.charAt(index2);
            BytecodeManager.incBytecodes(1);
            final char c = char1;
            final char c2 = char2;
            BytecodeManager.incBytecodes(3);
            final int mainTableEntry = getMainTableEntry(c, c2);
            BytecodeManager.incBytecodes(1);
            final int n2 = mainTableEntry & 0x200;
            BytecodeManager.incBytecodes(4);
            if (n2 == 0) {
                final int n3 = mainTableEntry;
                final int n4 = 127;
                BytecodeManager.incBytecodes(3);
                if (n3 != n4) {
                    final char c3 = (char)((mainTableEntry & 0x1F) + 65);
                    BytecodeManager.incBytecodes(7);
                    final int n5 = (mainTableEntry & 0x1E0) >> 5;
                    BytecodeManager.incBytecodes(6);
                    final int n6 = (mainTableEntry & 0xFFC00) >> 10;
                    BytecodeManager.incBytecodes(6);
                    final String str = country;
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder sb = new StringBuilder(str);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb2 = sb;
                    final char c4 = c3;
                    BytecodeManager.incBytecodes(3);
                    sb2.append(c4);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb3 = sb;
                    BytecodeManager.incBytecodes(2);
                    final String string = sb3.toString();
                    final int n7 = n5;
                    final int n8 = n6;
                    BytecodeManager.incBytecodes(3);
                    final Currency instance = getInstance(string, n7, n8);
                    BytecodeManager.incBytecodes(1);
                    return instance;
                }
            }
            final int n9 = mainTableEntry;
            final int n10 = 127;
            BytecodeManager.incBytecodes(3);
            if (n9 == n10) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex3 = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            final int n11 = mainTableEntry;
            final int n12 = 512;
            BytecodeManager.incBytecodes(3);
            if (n11 == n12) {
                final Currency currency = null;
                BytecodeManager.incBytecodes(2);
                return currency;
            }
            final int n13 = (mainTableEntry & 0x1F) - 1;
            BytecodeManager.incBytecodes(6);
            final long n14 = lcmp(Currency.scCutOverTimes[n13], Long.MAX_VALUE);
            BytecodeManager.incBytecodes(6);
            if (n14 != 0) {
                BytecodeManager.incBytecodes(1);
                final long n15 = lcmp(System.currentTimeMillis(), Currency.scCutOverTimes[n13]);
                BytecodeManager.incBytecodes(5);
                if (n15 >= 0) {
                    final String s5 = Currency.scNewCurrencies[n13];
                    final int n16 = Currency.scNewCurrenciesDFD[n13];
                    final int n17 = Currency.scNewCurrenciesNumericCode[n13];
                    BytecodeManager.incBytecodes(10);
                    final Currency instance2 = getInstance(s5, n16, n17);
                    BytecodeManager.incBytecodes(1);
                    return instance2;
                }
            }
            final String s6 = Currency.scOldCurrencies[n13];
            final int n18 = Currency.scOldCurrenciesDFD[n13];
            final int n19 = Currency.scOldCurrenciesNumericCode[n13];
            BytecodeManager.incBytecodes(10);
            final Currency instance3 = getInstance(s6, n18, n19);
            BytecodeManager.incBytecodes(1);
            return instance3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Set<Currency> getAvailableCurrencies() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: dup            
        //     3: astore_0       
        //     4: pop            
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: getstatic       instrumented/java/util/Currency.available:Linstrumented/java/util/HashSet;
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: ifnonnull       381
        //    21: new             Linstrumented/java/util/HashSet;
        //    24: dup            
        //    25: sipush          256
        //    28: ldc             4
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokespecial   instrumented/java/util/HashSet.<init>:(I)V
        //    36: putstatic       instrumented/java/util/Currency.available:Linstrumented/java/util/HashSet;
        //    39: ldc             1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: bipush          65
        //    46: istore_1       
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: iload_1        
        //    53: bipush          90
        //    55: ldc             3
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: if_icmpgt       301
        //    63: bipush          65
        //    65: istore_2       
        //    66: ldc             2
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: iload_2        
        //    72: bipush          90
        //    74: ldc             3
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: if_icmpgt       288
        //    82: iload_1        
        //    83: iload_2        
        //    84: ldc             3
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: invokestatic    instrumented/java/util/Currency.getMainTableEntry:(CC)I
        //    92: istore_3       
        //    93: ldc             1
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: iload_3        
        //    99: sipush          512
        //   102: iand           
        //   103: ldc             4
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: ifne            275
        //   111: iload_3        
        //   112: bipush          127
        //   114: ldc             3
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: if_icmpeq       275
        //   122: iload_3        
        //   123: bipush          31
        //   125: iand           
        //   126: bipush          65
        //   128: iadd           
        //   129: i2c            
        //   130: istore          4
        //   132: ldc             7
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: iload_3        
        //   138: sipush          480
        //   141: iand           
        //   142: iconst_5       
        //   143: ishr           
        //   144: istore          5
        //   146: ldc             6
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: iload_3        
        //   152: ldc             1047552
        //   154: iand           
        //   155: bipush          10
        //   157: ishr           
        //   158: istore          6
        //   160: ldc             6
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: new             Ljava/lang/StringBuilder;
        //   168: dup            
        //   169: ldc             3
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: invokespecial   java/lang/StringBuilder.<init>:()V
        //   177: astore          7
        //   179: ldc             1
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: aload           7
        //   186: iload_1        
        //   187: ldc             3
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   195: pop            
        //   196: ldc             1
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: aload           7
        //   203: iload_2        
        //   204: ldc             3
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   212: pop            
        //   213: ldc             1
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: aload           7
        //   220: iload           4
        //   222: ldc             3
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   230: pop            
        //   231: ldc             1
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: getstatic       instrumented/java/util/Currency.available:Linstrumented/java/util/HashSet;
        //   239: aload           7
        //   241: ldc             3
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   249: iload           5
        //   251: iload           6
        //   253: ldc             3
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokestatic    instrumented/java/util/Currency.getInstance:(Ljava/lang/String;II)Linstrumented/java/util/Currency;
        //   261: ldc             1
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: invokevirtual   instrumented/java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   269: pop            
        //   270: ldc             1
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: iload_2        
        //   276: iconst_1       
        //   277: iadd           
        //   278: i2c            
        //   279: istore_2       
        //   280: ldc             6
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: goto            71
        //   288: iload_1        
        //   289: iconst_1       
        //   290: iadd           
        //   291: i2c            
        //   292: istore_1       
        //   293: ldc             6
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: goto            52
        //   301: new             Linstrumented/java/util/StringTokenizer;
        //   304: dup            
        //   305: getstatic       instrumented/java/util/Currency.otherCurrencies:Ljava/lang/String;
        //   308: ldc             "-"
        //   310: ldc             5
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: invokespecial   instrumented/java/util/StringTokenizer.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   318: astore_1       
        //   319: ldc             1
        //   321: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   324: aload_1        
        //   325: ldc             2
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: invokevirtual   instrumented/java/util/StringTokenizer.hasMoreElements:()Z
        //   333: ldc             1
        //   335: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   338: ifeq            381
        //   341: getstatic       instrumented/java/util/Currency.available:Linstrumented/java/util/HashSet;
        //   344: aload_1        
        //   345: ldc             3
        //   347: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   350: invokevirtual   instrumented/java/util/StringTokenizer.nextElement:()Ljava/lang/Object;
        //   353: checkcast       Ljava/lang/String;
        //   356: ldc             2
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: invokestatic    instrumented/java/util/Currency.getInstance:(Ljava/lang/String;)Linstrumented/java/util/Currency;
        //   364: ldc             1
        //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   369: invokevirtual   instrumented/java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   372: pop            
        //   373: ldc             2
        //   375: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   378: goto            324
        //   381: aload_0        
        //   382: pop            
        //   383: ldc             2
        //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   388: ldc             1
        //   390: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   393: goto            413
        //   396: astore          8
        //   398: aload_0        
        //   399: pop            
        //   400: ldc             503
        //   402: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   405: aload           8
        //   407: ldc             2
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: athrow         
        //   413: getstatic       instrumented/java/util/Currency.available:Linstrumented/java/util/HashSet;
        //   416: ldc             2
        //   418: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   421: invokevirtual   instrumented/java/util/HashSet.clone:()Ljava/lang/Object;
        //   424: checkcast       Linstrumented/java/util/Set;
        //   427: astore_0       
        //   428: ldc             2
        //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   433: aload_0        
        //   434: ldc             2
        //   436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   439: areturn        
        //   440: athrow         
        //   441: athrow         
        //    Signature:
        //  ()Linstrumented/java/util/Set<Linstrumented/java/util/Currency;>;
        //    StackMapTable: 00 0B FD 00 34 07 00 04 01 FC 00 12 01 FB 00 CB FA 00 0C FA 00 0C FC 00 16 07 00 DA FA 00 38 4E 07 00 6D FA 00 10 FF 00 1A 00 00 00 01 07 00 6D FF 00 00 00 00 00 01 07 00 CD
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  10     441    441    442    Ljava/lang/VirtualMachineError;
        //  10     388    396    413    Any
        //  396    405    396    413    Any
        //  0      440    440    441    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
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
    
    public String getCurrencyCode() {
        try {
            final String currencyCode = this.currencyCode;
            BytecodeManager.incBytecodes(3);
            return currencyCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getSymbol() {
        try {
            final Locale.Category display = Locale.Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String symbol = this.getSymbol(default1);
            BytecodeManager.incBytecodes(1);
            return symbol;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getSymbol(final Locale locale) {
        try {
            final Class<CurrencyNameProvider> providerClass = CurrencyNameProvider.class;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LocaleServiceProviderPool pool = LocaleServiceProviderPool.getPool((Class<? extends LocaleServiceProvider>)providerClass);
            BytecodeManager.incBytecodes(1);
            final LocaleServiceProviderPool localeServiceProviderPool = pool;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final CurrencyNameGetter access$500 = CurrencyNameGetter.access$500();
            final String currencyCode = this.currencyCode;
            final Object[] array = { null };
            final int n = 0;
            final int i = 0;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            array[n] = i;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String s = (String)localeServiceProviderPool.getLocalizedObject((LocaleServiceProviderPool.LocalizedObjectGetter)access$500, locale, currencyCode, array);
            BytecodeManager.incBytecodes(2);
            final String s2 = s;
            BytecodeManager.incBytecodes(2);
            if (s2 != null) {
                final String s3 = s;
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            final String currencyCode2 = this.currencyCode;
            BytecodeManager.incBytecodes(3);
            return currencyCode2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getDefaultFractionDigits() {
        try {
            final int defaultFractionDigits = this.defaultFractionDigits;
            BytecodeManager.incBytecodes(3);
            return defaultFractionDigits;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getNumericCode() {
        try {
            final int numericCode = this.numericCode;
            BytecodeManager.incBytecodes(3);
            return numericCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayName() {
        try {
            final Locale.Category display = Locale.Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String displayName = this.getDisplayName(default1);
            BytecodeManager.incBytecodes(1);
            return displayName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayName(final Locale locale) {
        try {
            final Class<CurrencyNameProvider> providerClass = CurrencyNameProvider.class;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LocaleServiceProviderPool pool = LocaleServiceProviderPool.getPool((Class<? extends LocaleServiceProvider>)providerClass);
            BytecodeManager.incBytecodes(1);
            final LocaleServiceProviderPool localeServiceProviderPool = pool;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final CurrencyNameGetter access$500 = CurrencyNameGetter.access$500();
            final String currencyCode = this.currencyCode;
            final Object[] array = { null };
            final int n = 0;
            final int i = 1;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            array[n] = i;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String s = (String)localeServiceProviderPool.getLocalizedObject((LocaleServiceProviderPool.LocalizedObjectGetter)access$500, locale, currencyCode, array);
            BytecodeManager.incBytecodes(2);
            final String s2 = s;
            BytecodeManager.incBytecodes(2);
            if (s2 != null) {
                final String s3 = s;
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            final String currencyCode2 = this.currencyCode;
            BytecodeManager.incBytecodes(3);
            return currencyCode2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final String currencyCode = this.currencyCode;
            BytecodeManager.incBytecodes(3);
            return currencyCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Object readResolve() {
        try {
            final String currencyCode = this.currencyCode;
            BytecodeManager.incBytecodes(3);
            final Currency instance = getInstance(currencyCode);
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int getMainTableEntry(final char c, final char c2) {
        try {
            final char c3 = 'A';
            BytecodeManager.incBytecodes(3);
            if (c >= c3) {
                final char c4 = 'Z';
                BytecodeManager.incBytecodes(3);
                if (c <= c4) {
                    final char c5 = 'A';
                    BytecodeManager.incBytecodes(3);
                    if (c2 >= c5) {
                        final char c6 = 'Z';
                        BytecodeManager.incBytecodes(3);
                        if (c2 <= c6) {
                            final int n = Currency.mainTable[(c - 'A') * 26 + (c2 - 'A')];
                            BytecodeManager.incBytecodes(12);
                            return n;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IllegalArgumentException ex = new IllegalArgumentException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void setMainTableEntry(final char c, final char c2, final int n) {
        try {
            final char c3 = 'A';
            BytecodeManager.incBytecodes(3);
            if (c >= c3) {
                final char c4 = 'Z';
                BytecodeManager.incBytecodes(3);
                if (c <= c4) {
                    final char c5 = 'A';
                    BytecodeManager.incBytecodes(3);
                    if (c2 >= c5) {
                        final char c6 = 'Z';
                        BytecodeManager.incBytecodes(3);
                        if (c2 <= c6) {
                            Currency.mainTable[(c - 'A') * 26 + (c2 - 'A')] = n;
                            BytecodeManager.incBytecodes(12);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IllegalArgumentException ex = new IllegalArgumentException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] readIntArray(final DataInputStream dataInputStream, final int n) throws IOException {
        try {
            final int[] array = new int[n];
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n) {
                    break;
                }
                final int[] array2 = array;
                final int n4 = n2;
                BytecodeManager.incBytecodes(4);
                array2[n4] = dataInputStream.readInt();
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long[] readLongArray(final DataInputStream dataInputStream, final int n) throws IOException {
        try {
            final long[] array = new long[n];
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n) {
                    break;
                }
                final long[] array2 = array;
                final int n4 = n2;
                BytecodeManager.incBytecodes(4);
                array2[n4] = dataInputStream.readLong();
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final long[] array3 = array;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String[] readStringArray(final DataInputStream dataInputStream, final int n) throws IOException {
        try {
            final String[] array = new String[n];
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n) {
                    break;
                }
                final String[] array2 = array;
                final int n4 = n2;
                BytecodeManager.incBytecodes(4);
                array2[n4] = dataInputStream.readUTF();
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final String[] array3 = array;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void replaceCurrencyData(final Pattern p0, final String p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   java/lang/String.length:()I
        //     9: iconst_2       
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: if_icmpeq       84
        //    18: new             Ljava/lang/StringBuilder;
        //    21: dup            
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokespecial   java/lang/StringBuilder.<init>:()V
        //    30: ldc_w           "currency.properties entry for "
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    41: aload_1        
        //    42: ldc             2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    50: ldc_w           " is ignored because of the invalid country code."
        //    53: ldc             2
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    61: ldc             1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    69: aconst_null    
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokestatic    instrumented/java/util/Currency.info:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: return         
        //    84: aload_0        
        //    85: aload_2        
        //    86: ldc             3
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: invokevirtual   instrumented/java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Linstrumented/java/util/regex/Matcher;
        //    94: astore_3       
        //    95: ldc             1
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: aload_3        
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: invokevirtual   instrumented/java/util/regex/Matcher.find:()Z
        //   109: ldc             1
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: ifeq            155
        //   117: aload_3        
        //   118: iconst_4       
        //   119: ldc             3
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: ifnonnull       221
        //   135: aload_2        
        //   136: bipush          44
        //   138: ldc             3
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokestatic    instrumented/java/util/Currency.countOccurrences:(Ljava/lang/String;C)I
        //   146: iconst_3       
        //   147: ldc             2
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: if_icmplt       221
        //   155: new             Ljava/lang/StringBuilder;
        //   158: dup            
        //   159: ldc             3
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokespecial   java/lang/StringBuilder.<init>:()V
        //   167: ldc_w           "currency.properties entry for "
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   178: aload_1        
        //   179: ldc             2
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: ldc_w           " ignored because the value format is not recognized."
        //   190: ldc             2
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   206: aconst_null    
        //   207: ldc             2
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: invokestatic    instrumented/java/util/Currency.info:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: return         
        //   221: aload_3        
        //   222: iconst_4       
        //   223: ldc             3
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   231: ldc             1
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: ifnull          340
        //   239: aload_3        
        //   240: iconst_4       
        //   241: ldc             3
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   249: ldc             1
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: invokestatic    instrumented/java/util/Currency.isPastCutoverDate:(Ljava/lang/String;)Z
        //   257: ldc             1
        //   259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   262: ifne            340
        //   265: new             Ljava/lang/StringBuilder;
        //   268: dup            
        //   269: ldc             3
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokespecial   java/lang/StringBuilder.<init>:()V
        //   277: ldc_w           "currency.properties entry for "
        //   280: ldc             2
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   288: aload_1        
        //   289: ldc             2
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   297: ldc_w           " ignored since cutover date has not passed :"
        //   300: ldc             2
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   308: aload_2        
        //   309: ldc             2
        //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   314: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: ldc             1
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   325: aconst_null    
        //   326: ldc             2
        //   328: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   331: invokestatic    instrumented/java/util/Currency.info:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   334: ldc             1
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: return         
        //   340: ldc             1
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: goto            450
        //   348: astore          4
        //   350: ldc_w           501
        //   353: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   356: new             Ljava/lang/StringBuilder;
        //   359: dup            
        //   360: ldc             3
        //   362: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   365: invokespecial   java/lang/StringBuilder.<init>:()V
        //   368: ldc_w           "currency.properties entry for "
        //   371: ldc             2
        //   373: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   376: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: aload_1        
        //   380: ldc             2
        //   382: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   385: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   388: ldc_w           " ignored since exception encountered :"
        //   391: ldc             2
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   399: aload           4
        //   401: ldc             1
        //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   406: ldc             1
        //   408: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   411: invokevirtual   java/text/ParseException.getMessage:()Ljava/lang/String;
        //   414: ldc             1
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   422: ldc             1
        //   424: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   427: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   430: aconst_null    
        //   431: ldc             1
        //   433: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   436: ldc             1
        //   438: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   441: invokestatic    instrumented/java/util/Currency.info:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   444: ldc             1
        //   446: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   449: return         
        //   450: aload_3        
        //   451: iconst_1       
        //   452: ldc             3
        //   454: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   457: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   460: astore          4
        //   462: ldc             1
        //   464: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   467: aload_3        
        //   468: iconst_2       
        //   469: ldc             3
        //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   474: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   477: ldc             1
        //   479: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   482: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   485: istore          5
        //   487: ldc             1
        //   489: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   492: iload           5
        //   494: bipush          10
        //   496: ishl           
        //   497: istore          6
        //   499: ldc             4
        //   501: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   504: aload_3        
        //   505: iconst_3       
        //   506: ldc             3
        //   508: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   511: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   514: ldc             1
        //   516: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   519: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   522: istore          7
        //   524: ldc             1
        //   526: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   529: iload           7
        //   531: bipush          9
        //   533: ldc             3
        //   535: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   538: if_icmple       637
        //   541: new             Ljava/lang/StringBuilder;
        //   544: dup            
        //   545: ldc             3
        //   547: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   550: invokespecial   java/lang/StringBuilder.<init>:()V
        //   553: ldc_w           "currency.properties entry for "
        //   556: ldc             2
        //   558: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   561: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   564: aload_1        
        //   565: ldc             2
        //   567: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   570: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   573: ldc_w           " ignored since the fraction is more than "
        //   576: ldc             2
        //   578: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   581: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   584: bipush          9
        //   586: ldc             2
        //   588: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   591: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   594: ldc_w           ":"
        //   597: ldc             2
        //   599: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   602: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   605: aload_2        
        //   606: ldc             2
        //   608: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   611: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   614: ldc             1
        //   616: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   619: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   622: aconst_null    
        //   623: ldc             2
        //   625: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   628: invokestatic    instrumented/java/util/Currency.info:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   631: ldc             1
        //   633: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   636: return         
        //   637: iconst_0       
        //   638: istore          8
        //   640: ldc             2
        //   642: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   645: iload           8
        //   647: getstatic       instrumented/java/util/Currency.scOldCurrencies:[Ljava/lang/String;
        //   650: arraylength    
        //   651: ldc             4
        //   653: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   656: if_icmpge       702
        //   659: getstatic       instrumented/java/util/Currency.scOldCurrencies:[Ljava/lang/String;
        //   662: iload           8
        //   664: aaload         
        //   665: aload           4
        //   667: ldc             5
        //   669: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   672: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   675: ldc             1
        //   677: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   680: ifeq            691
        //   683: ldc             1
        //   685: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   688: goto            702
        //   691: iinc            8, 1
        //   694: ldc             2
        //   696: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   699: goto            645
        //   702: iload           8
        //   704: getstatic       instrumented/java/util/Currency.scOldCurrencies:[Ljava/lang/String;
        //   707: arraylength    
        //   708: ldc             4
        //   710: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   713: if_icmpne       753
        //   716: iload           6
        //   718: iload           7
        //   720: iconst_5       
        //   721: ishl           
        //   722: aload           4
        //   724: iconst_2       
        //   725: ldc             6
        //   727: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   730: ldc             1
        //   732: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   735: invokevirtual   java/lang/String.charAt:(I)C
        //   738: bipush          65
        //   740: isub           
        //   741: ior            
        //   742: ior            
        //   743: istore          6
        //   745: ldc             6
        //   747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   750: goto            772
        //   753: iload           6
        //   755: sipush          512
        //   758: iload           8
        //   760: iconst_1       
        //   761: iadd           
        //   762: ior            
        //   763: ior            
        //   764: istore          6
        //   766: ldc_w           8
        //   769: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   772: aload_1        
        //   773: iconst_0       
        //   774: ldc             3
        //   776: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   779: invokevirtual   java/lang/String.charAt:(I)C
        //   782: aload_1        
        //   783: iconst_1       
        //   784: ldc             3
        //   786: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   789: invokevirtual   java/lang/String.charAt:(I)C
        //   792: iload           6
        //   794: ldc             2
        //   796: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   799: invokestatic    instrumented/java/util/Currency.setMainTableEntry:(CCI)V
        //   802: ldc             1
        //   804: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   807: return         
        //   808: athrow         
        //   809: athrow         
        //    StackMapTable: 00 0E FB 00 54 FC 00 46 07 01 48 FB 00 41 FB 00 76 47 07 01 35 FB 00 65 FF 00 BA 00 08 07 01 42 07 00 7E 07 00 7E 07 01 48 07 00 7E 01 01 01 00 00 FC 00 07 01 2D 0A 32 12 FF 00 23 00 00 00 01 07 00 6D FF 00 00 00 00 00 01 07 00 CD
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  221    809    809    810    Ljava/lang/VirtualMachineError;
        //  221    334    348    450    Ljava/text/ParseException;
        //  0      808    808    809    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0221:
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
    
    private static boolean isPastCutoverDate(final String s) throws ParseException {
        try {
            final String s2 = "yyyy-MM-dd'T'HH:mm:ss";
            final Locale root = Locale.ROOT;
            BytecodeManager.incBytecodes(5);
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s2, root);
            BytecodeManager.incBytecodes(1);
            final SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
            final String s3 = "UTC";
            BytecodeManager.incBytecodes(3);
            final TimeZone timeZone = TimeZone.getTimeZone(s3);
            BytecodeManager.incBytecodes(1);
            simpleDateFormat2.setTimeZone(timeZone);
            final SimpleDateFormat simpleDateFormat3 = simpleDateFormat;
            final boolean lenient = false;
            BytecodeManager.incBytecodes(3);
            simpleDateFormat3.setLenient(lenient);
            final SimpleDateFormat simpleDateFormat4 = simpleDateFormat;
            BytecodeManager.incBytecodes(3);
            final String trim = s.trim();
            BytecodeManager.incBytecodes(1);
            final Date parse = simpleDateFormat4.parse(trim);
            BytecodeManager.incBytecodes(1);
            final long time = parse.getTime();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(System.currentTimeMillis(), time);
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (n > 0) {
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
    
    private static int countOccurrences(final String s, final char c) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final char[] charArray = s.toCharArray();
            final int length = charArray.length;
            int n2 = 0;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final char c2 = charArray[n2];
                BytecodeManager.incBytecodes(4);
                final char c3 = c2;
                BytecodeManager.incBytecodes(3);
                if (c3 == c) {
                    ++n;
                    BytecodeManager.incBytecodes(1);
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = n;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void info(final String s, final Throwable t) {
        try {
            final String name = "java.util.Currency";
            BytecodeManager.incBytecodes(2);
            final PlatformLogger logger = PlatformLogger.getLogger(name);
            BytecodeManager.incBytecodes(1);
            final PlatformLogger platformLogger = logger;
            final PlatformLogger.Level info = PlatformLogger.Level.INFO;
            BytecodeManager.incBytecodes(3);
            final boolean loggable = platformLogger.isLoggable(info);
            BytecodeManager.incBytecodes(1);
            if (loggable) {
                BytecodeManager.incBytecodes(2);
                if (t != null) {
                    final PlatformLogger platformLogger2 = logger;
                    BytecodeManager.incBytecodes(4);
                    platformLogger2.info(s, t);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final PlatformLogger platformLogger3 = logger;
                    BytecodeManager.incBytecodes(3);
                    platformLogger3.info(s);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final int n = 7;
            BytecodeManager.incBytecodes(4);
            Currency.instances = new ConcurrentHashMap<String, Currency>(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final PrivilegedAction<Void> action = new PrivilegedAction<Void>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public Void run() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     2: ldc             2
                    //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //     7: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
                    //    10: astore_1       
                    //    11: ldc             1
                    //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    16: new             Ljava/lang/StringBuilder;
                    //    19: dup            
                    //    20: ldc             3
                    //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    25: invokespecial   java/lang/StringBuilder.<init>:()V
                    //    28: aload_1        
                    //    29: ldc             2
                    //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    34: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //    37: getstatic       java/io/File.separator:Ljava/lang/String;
                    //    40: ldc             2
                    //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    45: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //    48: ldc             "lib"
                    //    50: ldc             2
                    //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    55: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //    58: getstatic       java/io/File.separator:Ljava/lang/String;
                    //    61: ldc             2
                    //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    66: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //    69: ldc             "currency.data"
                    //    71: ldc             2
                    //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    76: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //    79: ldc             1
                    //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    84: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                    //    87: astore_2       
                    //    88: ldc             1
                    //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    93: new             Ljava/io/DataInputStream;
                    //    96: dup            
                    //    97: new             Ljava/io/BufferedInputStream;
                    //   100: dup            
                    //   101: new             Ljava/io/FileInputStream;
                    //   104: dup            
                    //   105: aload_2        
                    //   106: ldc             8
                    //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   111: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
                    //   114: ldc             1
                    //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   119: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
                    //   122: ldc             1
                    //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   127: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
                    //   130: astore_3       
                    //   131: aconst_null    
                    //   132: astore          4
                    //   134: ldc             3
                    //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   139: aload_3        
                    //   140: ldc             2
                    //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   145: invokevirtual   java/io/DataInputStream.readInt:()I
                    //   148: ldc             1131770436
                    //   150: ldc             2
                    //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   155: if_icmpeq       178
                    //   158: new             Ljava/lang/InternalError;
                    //   161: dup            
                    //   162: ldc             "Currency data is possibly corrupted"
                    //   164: ldc             4
                    //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   169: invokespecial   java/lang/InternalError.<init>:(Ljava/lang/String;)V
                    //   172: ldc             1
                    //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   177: athrow         
                    //   178: aload_3        
                    //   179: ldc             2
                    //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   184: invokevirtual   java/io/DataInputStream.readInt:()I
                    //   187: putstatic       instrumented/java/util/Currency.formatVersion:I
                    //   190: ldc             1
                    //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   195: getstatic       instrumented/java/util/Currency.formatVersion:I
                    //   198: iconst_2       
                    //   199: ldc             3
                    //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   204: if_icmpeq       227
                    //   207: new             Ljava/lang/InternalError;
                    //   210: dup            
                    //   211: ldc             "Currency data format is incorrect"
                    //   213: ldc             4
                    //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   218: invokespecial   java/lang/InternalError.<init>:(Ljava/lang/String;)V
                    //   221: ldc             1
                    //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   226: athrow         
                    //   227: aload_3        
                    //   228: ldc             2
                    //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   233: invokevirtual   java/io/DataInputStream.readInt:()I
                    //   236: putstatic       instrumented/java/util/Currency.dataVersion:I
                    //   239: ldc             1
                    //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   244: aload_3        
                    //   245: sipush          676
                    //   248: ldc             3
                    //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   253: invokestatic    instrumented/java/util/Currency.access$000:(Ljava/io/DataInputStream;I)[I
                    //   256: putstatic       instrumented/java/util/Currency.mainTable:[I
                    //   259: ldc             1
                    //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   264: aload_3        
                    //   265: ldc             2
                    //   267: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   270: invokevirtual   java/io/DataInputStream.readInt:()I
                    //   273: istore          5
                    //   275: ldc             1
                    //   277: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   280: aload_3        
                    //   281: iload           5
                    //   283: ldc             3
                    //   285: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   288: invokestatic    instrumented/java/util/Currency.access$100:(Ljava/io/DataInputStream;I)[J
                    //   291: putstatic       instrumented/java/util/Currency.scCutOverTimes:[J
                    //   294: ldc             1
                    //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   299: aload_3        
                    //   300: iload           5
                    //   302: ldc             3
                    //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   307: invokestatic    instrumented/java/util/Currency.access$200:(Ljava/io/DataInputStream;I)[Ljava/lang/String;
                    //   310: putstatic       instrumented/java/util/Currency.scOldCurrencies:[Ljava/lang/String;
                    //   313: ldc             1
                    //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   318: aload_3        
                    //   319: iload           5
                    //   321: ldc             3
                    //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   326: invokestatic    instrumented/java/util/Currency.access$200:(Ljava/io/DataInputStream;I)[Ljava/lang/String;
                    //   329: putstatic       instrumented/java/util/Currency.scNewCurrencies:[Ljava/lang/String;
                    //   332: ldc             1
                    //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   337: aload_3        
                    //   338: iload           5
                    //   340: ldc             3
                    //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   345: invokestatic    instrumented/java/util/Currency.access$000:(Ljava/io/DataInputStream;I)[I
                    //   348: putstatic       instrumented/java/util/Currency.scOldCurrenciesDFD:[I
                    //   351: ldc             1
                    //   353: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   356: aload_3        
                    //   357: iload           5
                    //   359: ldc             3
                    //   361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   364: invokestatic    instrumented/java/util/Currency.access$000:(Ljava/io/DataInputStream;I)[I
                    //   367: putstatic       instrumented/java/util/Currency.scNewCurrenciesDFD:[I
                    //   370: ldc             1
                    //   372: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   375: aload_3        
                    //   376: iload           5
                    //   378: ldc             3
                    //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   383: invokestatic    instrumented/java/util/Currency.access$000:(Ljava/io/DataInputStream;I)[I
                    //   386: putstatic       instrumented/java/util/Currency.scOldCurrenciesNumericCode:[I
                    //   389: ldc             1
                    //   391: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   394: aload_3        
                    //   395: iload           5
                    //   397: ldc             3
                    //   399: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   402: invokestatic    instrumented/java/util/Currency.access$000:(Ljava/io/DataInputStream;I)[I
                    //   405: putstatic       instrumented/java/util/Currency.scNewCurrenciesNumericCode:[I
                    //   408: ldc             1
                    //   410: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   413: aload_3        
                    //   414: ldc             2
                    //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   419: invokevirtual   java/io/DataInputStream.readInt:()I
                    //   422: istore          6
                    //   424: ldc             1
                    //   426: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   429: aload_3        
                    //   430: ldc             2
                    //   432: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   435: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
                    //   438: putstatic       instrumented/java/util/Currency.otherCurrencies:Ljava/lang/String;
                    //   441: ldc             1
                    //   443: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   446: aload_3        
                    //   447: iload           6
                    //   449: ldc             3
                    //   451: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   454: invokestatic    instrumented/java/util/Currency.access$000:(Ljava/io/DataInputStream;I)[I
                    //   457: putstatic       instrumented/java/util/Currency.otherCurrenciesDFD:[I
                    //   460: ldc             1
                    //   462: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   465: aload_3        
                    //   466: iload           6
                    //   468: ldc             3
                    //   470: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   473: invokestatic    instrumented/java/util/Currency.access$000:(Ljava/io/DataInputStream;I)[I
                    //   476: putstatic       instrumented/java/util/Currency.otherCurrenciesNumericCode:[I
                    //   479: ldc             1
                    //   481: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   484: aload_3        
                    //   485: ldc             2
                    //   487: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   490: ifnull          655
                    //   493: aload           4
                    //   495: ldc             2
                    //   497: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   500: ifnull          542
                    //   503: aload_3        
                    //   504: ldc             2
                    //   506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   509: invokevirtual   java/io/DataInputStream.close:()V
                    //   512: ldc             1
                    //   514: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   517: goto            655
                    //   520: astore          5
                    //   522: aload           4
                    //   524: aload           5
                    //   526: ldc             504
                    //   528: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   531: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                    //   534: ldc             1
                    //   536: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   539: goto            655
                    //   542: aload_3        
                    //   543: ldc             2
                    //   545: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   548: invokevirtual   java/io/DataInputStream.close:()V
                    //   551: ldc             1
                    //   553: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   556: goto            655
                    //   559: astore          5
                    //   561: aload           5
                    //   563: astore          4
                    //   565: aload           5
                    //   567: ldc             505
                    //   569: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   572: athrow         
                    //   573: astore          7
                    //   575: ldc             501
                    //   577: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   580: aload_3        
                    //   581: ldc             2
                    //   583: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   586: ifnull          647
                    //   589: aload           4
                    //   591: ldc             2
                    //   593: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   596: ifnull          638
                    //   599: aload_3        
                    //   600: ldc             2
                    //   602: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   605: invokevirtual   java/io/DataInputStream.close:()V
                    //   608: ldc             1
                    //   610: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   613: goto            647
                    //   616: astore          8
                    //   618: aload           4
                    //   620: aload           8
                    //   622: ldc             504
                    //   624: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   627: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                    //   630: ldc             1
                    //   632: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   635: goto            647
                    //   638: aload_3        
                    //   639: ldc             2
                    //   641: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   644: invokevirtual   java/io/DataInputStream.close:()V
                    //   647: aload           7
                    //   649: ldc             2
                    //   651: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   654: athrow         
                    //   655: ldc             1
                    //   657: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   660: goto            688
                    //   663: astore_2       
                    //   664: ldc             501
                    //   666: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   669: new             Ljava/lang/InternalError;
                    //   672: dup            
                    //   673: aload_2        
                    //   674: ldc             4
                    //   676: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   679: invokespecial   java/lang/InternalError.<init>:(Ljava/lang/Throwable;)V
                    //   682: ldc             1
                    //   684: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   687: athrow         
                    //   688: ldc             "java.util.currency.data"
                    //   690: ldc             2
                    //   692: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   695: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
                    //   698: astore_2       
                    //   699: ldc             1
                    //   701: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   704: aload_2        
                    //   705: ldc             2
                    //   707: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   710: ifnonnull       790
                    //   713: new             Ljava/lang/StringBuilder;
                    //   716: dup            
                    //   717: ldc             3
                    //   719: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   722: invokespecial   java/lang/StringBuilder.<init>:()V
                    //   725: aload_1        
                    //   726: ldc             2
                    //   728: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   731: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   734: getstatic       java/io/File.separator:Ljava/lang/String;
                    //   737: ldc             2
                    //   739: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   742: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   745: ldc             "lib"
                    //   747: ldc             2
                    //   749: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   752: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   755: getstatic       java/io/File.separator:Ljava/lang/String;
                    //   758: ldc             2
                    //   760: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   763: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   766: ldc             "currency.properties"
                    //   768: ldc             2
                    //   770: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   773: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   776: ldc             1
                    //   778: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   781: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                    //   784: astore_2       
                    //   785: ldc             1
                    //   787: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   790: new             Ljava/io/File;
                    //   793: dup            
                    //   794: aload_2        
                    //   795: ldc             4
                    //   797: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   800: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
                    //   803: astore_3       
                    //   804: ldc             1
                    //   806: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   809: aload_3        
                    //   810: ldc             2
                    //   812: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   815: invokevirtual   java/io/File.exists:()Z
                    //   818: ldc             1
                    //   820: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   823: ifeq            1221
                    //   826: new             Linstrumented/java/util/Properties;
                    //   829: dup            
                    //   830: ldc             3
                    //   832: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   835: invokespecial   instrumented/java/util/Properties.<init>:()V
                    //   838: astore          4
                    //   840: ldc             1
                    //   842: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   845: new             Ljava/io/FileReader;
                    //   848: dup            
                    //   849: aload_3        
                    //   850: ldc             4
                    //   852: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   855: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
                    //   858: astore          5
                    //   860: aconst_null    
                    //   861: astore          6
                    //   863: ldc             3
                    //   865: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   868: aload           4
                    //   870: aload           5
                    //   872: ldc             3
                    //   874: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   877: invokevirtual   instrumented/java/util/Properties.load:(Ljava/io/Reader;)V
                    //   880: aload           5
                    //   882: ldc             2
                    //   884: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   887: ifnull          1057
                    //   890: aload           6
                    //   892: ldc             2
                    //   894: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   897: ifnull          940
                    //   900: aload           5
                    //   902: ldc             2
                    //   904: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   907: invokevirtual   java/io/FileReader.close:()V
                    //   910: ldc             1
                    //   912: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   915: goto            1057
                    //   918: astore          7
                    //   920: aload           6
                    //   922: aload           7
                    //   924: ldc             504
                    //   926: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   929: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                    //   932: ldc             1
                    //   934: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   937: goto            1057
                    //   940: aload           5
                    //   942: ldc             2
                    //   944: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   947: invokevirtual   java/io/FileReader.close:()V
                    //   950: ldc             1
                    //   952: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   955: goto            1057
                    //   958: astore          7
                    //   960: aload           7
                    //   962: astore          6
                    //   964: aload           7
                    //   966: ldc             505
                    //   968: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   971: athrow         
                    //   972: astore          9
                    //   974: ldc             501
                    //   976: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   979: aload           5
                    //   981: ldc             2
                    //   983: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   986: ifnull          1049
                    //   989: aload           6
                    //   991: ldc             2
                    //   993: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   996: ifnull          1039
                    //   999: aload           5
                    //  1001: ldc             2
                    //  1003: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1006: invokevirtual   java/io/FileReader.close:()V
                    //  1009: ldc             1
                    //  1011: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1014: goto            1049
                    //  1017: astore          10
                    //  1019: aload           6
                    //  1021: aload           10
                    //  1023: ldc             504
                    //  1025: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1028: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                    //  1031: ldc             1
                    //  1033: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1036: goto            1049
                    //  1039: aload           5
                    //  1041: ldc             2
                    //  1043: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1046: invokevirtual   java/io/FileReader.close:()V
                    //  1049: aload           9
                    //  1051: ldc             2
                    //  1053: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1056: athrow         
                    //  1057: aload           4
                    //  1059: ldc             2
                    //  1061: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1064: invokevirtual   instrumented/java/util/Properties.stringPropertyNames:()Linstrumented/java/util/Set;
                    //  1067: astore          5
                    //  1069: ldc             1
                    //  1071: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1074: ldc             "([A-Z]{3})\\s*,\\s*(\\d{3})\\s*,\\s*(\\d+)\\s*,?\\s*(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2})?"
                    //  1076: ldc             1
                    //  1078: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1081: ldc             1
                    //  1083: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1086: invokestatic    instrumented/java/util/regex/Pattern.compile:(Ljava/lang/String;)Linstrumented/java/util/regex/Pattern;
                    //  1089: astore          6
                    //  1091: ldc             1
                    //  1093: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1096: aload           5
                    //  1098: ldc             2
                    //  1100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1103: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
                    //  1108: astore          7
                    //  1110: ldc             1
                    //  1112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1115: aload           7
                    //  1117: ldc             2
                    //  1119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1122: invokeinterface java/util/Iterator.hasNext:()Z
                    //  1127: ldc             1
                    //  1129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1132: ifeq            1221
                    //  1135: aload           7
                    //  1137: ldc             2
                    //  1139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1142: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
                    //  1147: checkcast       Ljava/lang/String;
                    //  1150: astore          8
                    //  1152: ldc             2
                    //  1154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1157: aload           6
                    //  1159: aload           8
                    //  1161: getstatic       instrumented/java/util/Locale.ROOT:Linstrumented/java/util/Locale;
                    //  1164: ldc             3
                    //  1166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1169: ldc             1
                    //  1171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1174: invokevirtual   java/lang/String.toUpperCase:(Linstrumented/java/util/Locale;)Ljava/lang/String;
                    //  1177: aload           4
                    //  1179: aload           8
                    //  1181: ldc             2
                    //  1183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1186: ldc             1
                    //  1188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1191: invokevirtual   instrumented/java/util/Properties.getProperty:(Ljava/lang/String;)Ljava/lang/String;
                    //  1194: getstatic       instrumented/java/util/Locale.ROOT:Linstrumented/java/util/Locale;
                    //  1197: ldc             2
                    //  1199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1202: invokevirtual   java/lang/String.toUpperCase:(Linstrumented/java/util/Locale;)Ljava/lang/String;
                    //  1205: ldc             1
                    //  1207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1210: invokestatic    instrumented/java/util/Currency.access$300:(Linstrumented/java/util/regex/Pattern;Ljava/lang/String;Ljava/lang/String;)V
                    //  1213: ldc             1
                    //  1215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1218: goto            1115
                    //  1221: ldc             1
                    //  1223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1226: goto            1246
                    //  1229: astore_3       
                    //  1230: ldc             501
                    //  1232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1235: ldc             "currency.properties is ignored because of an IOException"
                    //  1237: aload_3        
                    //  1238: ldc             3
                    //  1240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1243: invokestatic    instrumented/java/util/Currency.access$400:(Ljava/lang/String;Ljava/lang/Throwable;)V
                    //  1246: aconst_null    
                    //  1247: ldc             2
                    //  1249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //  1252: areturn        
                    //  1253: athrow         
                    //  1254: athrow         
                    //    StackMapTable: 00 1B FF 00 B2 00 05 07 00 02 07 00 57 07 00 57 07 00 3E 07 00 18 00 00 30 F7 01 24 07 00 18 15 50 07 00 18 4D 07 00 18 FF 00 2A 00 08 07 00 02 07 00 57 07 00 57 07 00 3E 07 00 18 00 00 07 00 18 00 01 07 00 18 15 08 FF 00 07 00 02 07 00 02 07 00 57 00 00 47 07 00 1E 18 FC 00 65 07 00 57 FF 00 7F 00 07 07 00 02 07 00 57 07 00 57 07 00 30 07 00 AA 07 00 AD 07 00 18 00 01 07 00 18 15 51 07 00 18 4D 07 00 18 FF 00 2C 00 0A 07 00 02 07 00 57 07 00 57 07 00 30 07 00 AA 07 00 AD 07 00 18 00 00 07 00 18 00 01 07 00 18 15 09 FF 00 07 00 05 07 00 02 07 00 57 07 00 57 07 00 30 07 00 AA 00 00 FE 00 39 07 00 C3 07 00 BD 07 00 C9 FF 00 69 00 03 07 00 02 07 00 57 07 00 57 00 00 47 07 00 1E 10 FF 00 06 00 00 00 01 07 00 18 FF 00 00 00 00 00 01 07 00 1C
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                           
                    //  -----  -----  -----  -----  -------------------------------
                    //  16     1254   1254   1255   Ljava/lang/VirtualMachineError;
                    //  503    512    520    542    Ljava/lang/Throwable;
                    //  139    484    559    573    Ljava/lang/Throwable;
                    //  139    484    573    655    Any
                    //  599    608    616    638    Ljava/lang/Throwable;
                    //  559    580    573    655    Any
                    //  16     655    663    688    Ljava/io/IOException;
                    //  900    910    918    940    Ljava/lang/Throwable;
                    //  868    880    958    972    Ljava/lang/Throwable;
                    //  868    880    972    1057   Any
                    //  999    1009   1017   1039   Ljava/lang/Throwable;
                    //  958    979    972    1057   Any
                    //  790    1221   1229   1246   Ljava/io/IOException;
                    //  0      1253   1253   1254   Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0178:
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
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            };
            BytecodeManager.incBytecodes(1);
            AccessController.doPrivileged((PrivilegedAction<Object>)action);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class CurrencyNameGetter implements LocaleServiceProviderPool.LocalizedObjectGetter<CurrencyNameProvider, String>
    {
        private static final CurrencyNameGetter INSTANCE;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        private CurrencyNameGetter() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public String getObject(final CurrencyNameProvider currencyNameProvider, final Locale locale, final String s, final Object... array) {
            try {
                final boolean $assertionsDisabled = CurrencyNameGetter.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final int length = array.length;
                    final int n = 1;
                    BytecodeManager.incBytecodes(4);
                    if (length != n) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                final Integer n2 = (Integer)array[0];
                BytecodeManager.incBytecodes(5);
                final int intValue = n2;
                BytecodeManager.incBytecodes(1);
                final int n3 = intValue;
                BytecodeManager.incBytecodes(2);
                switch (n3) {
                    case 0: {
                        BytecodeManager.incBytecodes(4);
                        final String symbol = currencyNameProvider.getSymbol(s, locale);
                        BytecodeManager.incBytecodes(1);
                        return symbol;
                    }
                    case 1: {
                        BytecodeManager.incBytecodes(4);
                        final String displayName = currencyNameProvider.getDisplayName(s, locale);
                        BytecodeManager.incBytecodes(1);
                        return displayName;
                    }
                    default: {
                        final boolean $assertionsDisabled2 = CurrencyNameGetter.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled2) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError2 = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError2;
                        }
                        final String s2 = null;
                        BytecodeManager.incBytecodes(2);
                        return s2;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ CurrencyNameGetter access$500() {
            try {
                final CurrencyNameGetter instance = CurrencyNameGetter.INSTANCE;
                BytecodeManager.incBytecodes(2);
                return instance;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Currency> clazz = Currency.class;
                BytecodeManager.incBytecodes(2);
                final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
                BytecodeManager.incBytecodes(1);
                boolean $assertionsDisabled2;
                if (!desiredAssertionStatus) {
                    $assertionsDisabled2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    $assertionsDisabled2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                $assertionsDisabled = $assertionsDisabled2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                INSTANCE = new CurrencyNameGetter();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
