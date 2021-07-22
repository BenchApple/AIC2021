// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import sun.util.locale.LocaleSyntaxException;
import sun.util.locale.LocaleObjectCache;
import sun.util.locale.LocaleMatcher;
import java.io.ObjectStreamException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import sun.util.locale.LocaleUtils;
import java.text.MessageFormat;
import sun.util.locale.provider.LocaleResources;
import sun.util.locale.provider.LocaleProviderAdapter;
import java.util.spi.LocaleServiceProvider;
import instrumented.java.util.spi.LocaleNameProvider;
import sun.util.locale.ParseStatus;
import sun.util.locale.InternalLocaleBuilder;
import sun.util.locale.LanguageTag;
import sun.util.locale.provider.LocaleServiceProviderPool;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;
import aic2021.engine.BytecodeManager;
import java.io.ObjectStreamField;
import sun.util.locale.LocaleExtensions;
import sun.util.locale.BaseLocale;
import java.io.Serializable;

public final class Locale implements Cloneable, Serializable
{
    private static final Cache LOCALECACHE;
    public static final Locale ENGLISH;
    public static final Locale FRENCH;
    public static final Locale GERMAN;
    public static final Locale ITALIAN;
    public static final Locale JAPANESE;
    public static final Locale KOREAN;
    public static final Locale CHINESE;
    public static final Locale SIMPLIFIED_CHINESE;
    public static final Locale TRADITIONAL_CHINESE;
    public static final Locale FRANCE;
    public static final Locale GERMANY;
    public static final Locale ITALY;
    public static final Locale JAPAN;
    public static final Locale KOREA;
    public static final Locale CHINA;
    public static final Locale PRC;
    public static final Locale TAIWAN;
    public static final Locale UK;
    public static final Locale US;
    public static final Locale CANADA;
    public static final Locale CANADA_FRENCH;
    public static final Locale ROOT;
    public static final char PRIVATE_USE_EXTENSION = 'x';
    public static final char UNICODE_LOCALE_EXTENSION = 'u';
    static final long serialVersionUID = 9149081749638150636L;
    private static final int DISPLAY_LANGUAGE = 0;
    private static final int DISPLAY_COUNTRY = 1;
    private static final int DISPLAY_VARIANT = 2;
    private static final int DISPLAY_SCRIPT = 3;
    private transient BaseLocale baseLocale;
    private transient LocaleExtensions localeExtensions;
    private transient volatile int hashCodeValue;
    private static volatile Locale defaultLocale;
    private static volatile Locale defaultDisplayLocale;
    private static volatile Locale defaultFormatLocale;
    private transient volatile String languageTag;
    private static final ObjectStreamField[] serialPersistentFields;
    private static volatile String[] isoLanguages;
    private static volatile String[] isoCountries;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private Locale(final BaseLocale baseLocale, final LocaleExtensions localeExtensions) {
        try {
            BytecodeManager.incBytecodes(2);
            this.hashCodeValue = 0;
            BytecodeManager.incBytecodes(3);
            this.baseLocale = baseLocale;
            BytecodeManager.incBytecodes(3);
            this.localeExtensions = localeExtensions;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Locale(final String s, final String region, final String variant) {
        try {
            BytecodeManager.incBytecodes(2);
            this.hashCodeValue = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (s != null) {
                BytecodeManager.incBytecodes(2);
                if (region != null) {
                    BytecodeManager.incBytecodes(2);
                    if (variant != null) {
                        BytecodeManager.incBytecodes(3);
                        final String convertOldISOCodes = convertOldISOCodes(s);
                        final String script = "";
                        BytecodeManager.incBytecodes(4);
                        this.baseLocale = BaseLocale.getInstance(convertOldISOCodes, script, region, variant);
                        BytecodeManager.incBytecodes(1);
                        final String s2 = "";
                        BytecodeManager.incBytecodes(6);
                        this.localeExtensions = getCompatibilityExtensions(s, s2, region, variant);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Locale(final String s, final String s2) {
        try {
            final String s3 = "";
            BytecodeManager.incBytecodes(5);
            this(s, s2, s3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Locale(final String s) {
        try {
            final String s2 = "";
            final String s3 = "";
            BytecodeManager.incBytecodes(5);
            this(s, s2, s3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Locale createConstant(final String language, final String region) {
        try {
            BytecodeManager.incBytecodes(3);
            final BaseLocale instance = BaseLocale.createInstance(language, region);
            BytecodeManager.incBytecodes(1);
            final BaseLocale baseLocale = instance;
            final LocaleExtensions localeExtensions = null;
            BytecodeManager.incBytecodes(3);
            final Locale instance2 = getInstance(baseLocale, localeExtensions);
            BytecodeManager.incBytecodes(1);
            return instance2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Locale getInstance(final String s, final String s2, final String s3) {
        try {
            final String s4 = "";
            final LocaleExtensions localeExtensions = null;
            BytecodeManager.incBytecodes(6);
            final Locale instance = getInstance(s, s4, s2, s3, localeExtensions);
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Locale getInstance(final String language, final String script, final String region, final String variant, LocaleExtensions compatibilityExtensions) {
        try {
            BytecodeManager.incBytecodes(2);
            if (language != null) {
                BytecodeManager.incBytecodes(2);
                if (script != null) {
                    BytecodeManager.incBytecodes(2);
                    if (region != null) {
                        BytecodeManager.incBytecodes(2);
                        if (variant != null) {
                            final LocaleExtensions localeExtensions = compatibilityExtensions;
                            BytecodeManager.incBytecodes(2);
                            if (localeExtensions == null) {
                                BytecodeManager.incBytecodes(5);
                                compatibilityExtensions = getCompatibilityExtensions(language, script, region, variant);
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(5);
                            final BaseLocale instance = BaseLocale.getInstance(language, script, region, variant);
                            BytecodeManager.incBytecodes(1);
                            final BaseLocale baseLocale = instance;
                            final LocaleExtensions localeExtensions2 = compatibilityExtensions;
                            BytecodeManager.incBytecodes(3);
                            final Locale instance2 = getInstance(baseLocale, localeExtensions2);
                            BytecodeManager.incBytecodes(1);
                            return instance2;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Locale getInstance(final BaseLocale baseLocale, final LocaleExtensions localeExtensions) {
        try {
            final Object object = null;
            BytecodeManager.incBytecodes(6);
            final LocaleKey localeKey = new LocaleKey(baseLocale, localeExtensions);
            BytecodeManager.incBytecodes(1);
            final Cache localecache = Locale.LOCALECACHE;
            final LocaleKey key = localeKey;
            BytecodeManager.incBytecodes(3);
            final Locale locale = localecache.get(key);
            BytecodeManager.incBytecodes(2);
            return locale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Locale getDefault() {
        try {
            final Locale defaultLocale = Locale.defaultLocale;
            BytecodeManager.incBytecodes(2);
            return defaultLocale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Locale getDefault(final Category p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0        
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokevirtual   instrumented/java/util/Locale$Category.ordinal:()I
        //    12: iaload         
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: lookupswitch {
        //                1: 44
        //                2: 132
        //          default: 220
        //        }
        //    44: getstatic       instrumented/java/util/Locale.defaultDisplayLocale:Linstrumented/java/util/Locale;
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: ifnonnull       123
        //    55: ldc             Linstrumented/java/util/Locale;.class
        //    57: dup            
        //    58: astore_1       
        //    59: pop            
        //    60: ldc             4
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: getstatic       instrumented/java/util/Locale.defaultDisplayLocale:Linstrumented/java/util/Locale;
        //    68: ldc             2
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ifnonnull       93
        //    76: aload_0        
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokestatic    instrumented/java/util/Locale.initDefault:(Linstrumented/java/util/Locale$Category;)Linstrumented/java/util/Locale;
        //    85: putstatic       instrumented/java/util/Locale.defaultDisplayLocale:Linstrumented/java/util/Locale;
        //    88: ldc             1
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_1        
        //    94: pop            
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: goto            123
        //   108: astore_2       
        //   109: aload_1        
        //   110: pop            
        //   111: ldc             503
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: aload_2        
        //   117: ldc             2
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: athrow         
        //   123: getstatic       instrumented/java/util/Locale.defaultDisplayLocale:Linstrumented/java/util/Locale;
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: areturn        
        //   132: getstatic       instrumented/java/util/Locale.defaultFormatLocale:Linstrumented/java/util/Locale;
        //   135: ldc             2
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: ifnonnull       211
        //   143: ldc             Linstrumented/java/util/Locale;.class
        //   145: dup            
        //   146: astore_1       
        //   147: pop            
        //   148: ldc             4
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: getstatic       instrumented/java/util/Locale.defaultFormatLocale:Linstrumented/java/util/Locale;
        //   156: ldc             2
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: ifnonnull       181
        //   164: aload_0        
        //   165: ldc             2
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: invokestatic    instrumented/java/util/Locale.initDefault:(Linstrumented/java/util/Locale$Category;)Linstrumented/java/util/Locale;
        //   173: putstatic       instrumented/java/util/Locale.defaultFormatLocale:Linstrumented/java/util/Locale;
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: aload_1        
        //   182: pop            
        //   183: ldc             2
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: goto            211
        //   196: astore_3       
        //   197: aload_1        
        //   198: pop            
        //   199: ldc             503
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: aload_3        
        //   205: ldc             2
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: athrow         
        //   211: getstatic       instrumented/java/util/Locale.defaultFormatLocale:Linstrumented/java/util/Locale;
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: areturn        
        //   220: getstatic       instrumented/java/util/Locale.$assertionsDisabled:Z
        //   223: ldc             2
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: ifne            251
        //   231: new             Ljava/lang/AssertionError;
        //   234: dup            
        //   235: ldc             "Unknown Category"
        //   237: ldc             4
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //   245: ldc             1
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: athrow         
        //   251: ldc             1
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: invokestatic    instrumented/java/util/Locale.getDefault:()Linstrumented/java/util/Locale;
        //   259: ldc             1
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: areturn        
        //   265: athrow         
        //   266: athrow         
        //    StackMapTable: 00 0C 2C FC 00 30 07 00 04 4E 07 00 7E FA 00 0E 08 FC 00 30 07 00 04 4E 07 00 7E FA 00 0E 08 1E FF 00 0D 00 00 00 01 07 00 7E FF 00 00 00 00 00 01 07 00 B8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  65     266    266    267    Ljava/lang/VirtualMachineError;
        //  65     100    108    123    Any
        //  108    116    108    123    Any
        //  153    188    196    211    Any
        //  196    204    196    211    Any
        //  0      265    265    266    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    private static Locale initDefault() {
        try {
            final String theProp = "user.language";
            final String defaultVal = "en";
            BytecodeManager.incBytecodes(5);
            final GetPropertyAction action = new GetPropertyAction(theProp, defaultVal);
            BytecodeManager.incBytecodes(1);
            final String s = AccessController.doPrivileged((PrivilegedAction<String>)action);
            BytecodeManager.incBytecodes(2);
            final String theProp2 = "user.region";
            BytecodeManager.incBytecodes(4);
            final GetPropertyAction action2 = new GetPropertyAction(theProp2);
            BytecodeManager.incBytecodes(1);
            final String s2 = AccessController.doPrivileged((PrivilegedAction<String>)action2);
            BytecodeManager.incBytecodes(2);
            final String s3 = s2;
            BytecodeManager.incBytecodes(2);
            String substring;
            String substring2;
            String s7;
            if (s3 != null) {
                final String s4 = s2;
                final int ch = 95;
                BytecodeManager.incBytecodes(3);
                final int index = s4.indexOf(ch);
                BytecodeManager.incBytecodes(1);
                final int n = index;
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    final String s5 = s2;
                    final int beginIndex = 0;
                    final int endIndex = index;
                    BytecodeManager.incBytecodes(4);
                    substring = s5.substring(beginIndex, endIndex);
                    BytecodeManager.incBytecodes(1);
                    final String s6 = s2;
                    final int beginIndex2 = index + 1;
                    BytecodeManager.incBytecodes(5);
                    substring2 = s6.substring(beginIndex2);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    substring = s2;
                    BytecodeManager.incBytecodes(2);
                    substring2 = "";
                    BytecodeManager.incBytecodes(2);
                }
                s7 = "";
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final String theProp3 = "user.script";
                final String defaultVal2 = "";
                BytecodeManager.incBytecodes(5);
                final GetPropertyAction action3 = new GetPropertyAction(theProp3, defaultVal2);
                BytecodeManager.incBytecodes(1);
                s7 = AccessController.doPrivileged((PrivilegedAction<String>)action3);
                BytecodeManager.incBytecodes(2);
                final String theProp4 = "user.country";
                final String defaultVal3 = "";
                BytecodeManager.incBytecodes(5);
                final GetPropertyAction action4 = new GetPropertyAction(theProp4, defaultVal3);
                BytecodeManager.incBytecodes(1);
                substring = AccessController.doPrivileged((PrivilegedAction<String>)action4);
                BytecodeManager.incBytecodes(2);
                final String theProp5 = "user.variant";
                final String defaultVal4 = "";
                BytecodeManager.incBytecodes(5);
                final GetPropertyAction action5 = new GetPropertyAction(theProp5, defaultVal4);
                BytecodeManager.incBytecodes(1);
                substring2 = AccessController.doPrivileged((PrivilegedAction<String>)action5);
                BytecodeManager.incBytecodes(2);
            }
            final String s8 = s;
            final String s9 = s7;
            final String s10 = substring;
            final String s11 = substring2;
            final LocaleExtensions localeExtensions = null;
            BytecodeManager.incBytecodes(6);
            final Locale instance = getInstance(s8, s9, s10, s11, localeExtensions);
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Locale initDefault(final Category category) {
        try {
            final String languageKey = category.languageKey;
            final Locale defaultLocale = Locale.defaultLocale;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String language = defaultLocale.getLanguage();
            BytecodeManager.incBytecodes(1);
            final GetPropertyAction action = new GetPropertyAction(languageKey, language);
            BytecodeManager.incBytecodes(1);
            final String s = AccessController.doPrivileged((PrivilegedAction<String>)action);
            final String scriptKey = category.scriptKey;
            final Locale defaultLocale2 = Locale.defaultLocale;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String script = defaultLocale2.getScript();
            BytecodeManager.incBytecodes(1);
            final GetPropertyAction action2 = new GetPropertyAction(scriptKey, script);
            BytecodeManager.incBytecodes(1);
            final String s2 = AccessController.doPrivileged((PrivilegedAction<String>)action2);
            final String countryKey = category.countryKey;
            final Locale defaultLocale3 = Locale.defaultLocale;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String country = defaultLocale3.getCountry();
            BytecodeManager.incBytecodes(1);
            final GetPropertyAction action3 = new GetPropertyAction(countryKey, country);
            BytecodeManager.incBytecodes(1);
            final String s3 = AccessController.doPrivileged((PrivilegedAction<String>)action3);
            final String variantKey = category.variantKey;
            final Locale defaultLocale4 = Locale.defaultLocale;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String variant = defaultLocale4.getVariant();
            BytecodeManager.incBytecodes(1);
            final GetPropertyAction action4 = new GetPropertyAction(variantKey, variant);
            BytecodeManager.incBytecodes(1);
            final String s4 = AccessController.doPrivileged((PrivilegedAction<String>)action4);
            final LocaleExtensions localeExtensions = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final Locale instance = getInstance(s, s2, s3, s4, localeExtensions);
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static synchronized void setDefault(final Locale defaultLocale) {
        try {
            final Category display = Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            setDefault(display, defaultLocale);
            final Category format = Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            setDefault(format, defaultLocale);
            Locale.defaultLocale = defaultLocale;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static synchronized void setDefault(final Category category, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            if (category == null) {
                final String s = "Category cannot be NULL";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (locale == null) {
                final String s2 = "Can't set default locale to NULL";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex2 = new NullPointerException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 != null) {
                final SecurityManager securityManager3 = securityManager;
                final String s3 = "user.language";
                final String s4 = "write";
                BytecodeManager.incBytecodes(6);
                final PropertyPermission perm = new PropertyPermission(s3, s4);
                BytecodeManager.incBytecodes(1);
                securityManager3.checkPermission(perm);
            }
            final int[] $SwitchMap$java$util$Locale$Category = Locale$1.$SwitchMap$java$util$Locale$Category;
            BytecodeManager.incBytecodes(3);
            final int n = $SwitchMap$java$util$Locale$Category[category.ordinal()];
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 1: {
                    Locale.defaultDisplayLocale = locale;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 2: {
                    Locale.defaultFormatLocale = locale;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                default: {
                    final boolean $assertionsDisabled = Locale.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled) {
                        final String detailMessage = "Unknown Category";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                    break;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Locale[] getAvailableLocales() {
        try {
            BytecodeManager.incBytecodes(1);
            final Locale[] allAvailableLocales = LocaleServiceProviderPool.getAllAvailableLocales();
            BytecodeManager.incBytecodes(1);
            return allAvailableLocales;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String[] getISOCountries() {
        try {
            final String[] isoCountries = Locale.isoCountries;
            BytecodeManager.incBytecodes(2);
            if (isoCountries == null) {
                final String s = "ADANDAEAREAFAFGAGATGAIAIAALALBAMARMANANTAOAGOAQATAARARGASASMATAUTAUAUSAWABWAXALAAZAZEBABIHBBBRBBDBGDBEBELBFBFABGBGRBHBHRBIBDIBJBENBLBLMBMBMUBNBRNBOBOLBQBESBRBRABSBHSBTBTNBVBVTBWBWABYBLRBZBLZCACANCCCCKCDCODCFCAFCGCOGCHCHECICIVCKCOKCLCHLCMCMRCNCHNCOCOLCRCRICUCUBCVCPVCWCUWCXCXRCYCYPCZCZEDEDEUDJDJIDKDNKDMDMADODOMDZDZAECECUEEESTEGEGYEHESHERERIESESPETETHFIFINFJFJIFKFLKFMFSMFOFROFRFRAGAGABGBGBRGDGRDGEGEOGFGUFGGGGYGHGHAGIGIBGLGRLGMGMBGNGINGPGLPGQGNQGRGRCGSSGSGTGTMGUGUMGWGNBGYGUYHKHKGHMHMDHNHNDHRHRVHTHTIHUHUNIDIDNIEIRLILISRIMIMNININDIOIOTIQIRQIRIRNISISLITITAJEJEYJMJAMJOJORJPJPNKEKENKGKGZKHKHMKIKIRKMCOMKNKNAKPPRKKRKORKWKWTKYCYMKZKAZLALAOLBLBNLCLCALILIELKLKALRLBRLSLSOLTLTULULUXLVLVALYLBYMAMARMCMCOMDMDAMEMNEMFMAFMGMDGMHMHLMKMKDMLMLIMMMMRMNMNGMOMACMPMNPMQMTQMRMRTMSMSRMTMLTMUMUSMVMDVMWMWIMXMEXMYMYSMZMOZNANAMNCNCLNENERNFNFKNGNGANINICNLNLDNONORNPNPLNRNRUNUNIUNZNZLOMOMNPAPANPEPERPFPYFPGPNGPHPHLPKPAKPLPOLPMSPMPNPCNPRPRIPSPSEPTPRTPWPLWPYPRYQAQATREREUROROURSSRBRURUSRWRWASASAUSBSLBSCSYCSDSDNSESWESGSGPSHSHNSISVNSJSJMSKSVKSLSLESMSMRSNSENSOSOMSRSURSSSSDSTSTPSVSLVSXSXMSYSYRSZSWZTCTCATDTCDTFATFTGTGOTHTHATJTJKTKTKLTLTLSTMTKMTNTUNTOTONTRTURTTTTOTVTUVTWTWNTZTZAUAUKRUGUGAUMUMIUSUSAUYURYUZUZBVAVATVCVCTVEVENVGVGBVIVIRVNVNMVUVUTWFWLFWSWSMYEYEMYTMYTZAZAFZMZMBZWZWE";
                BytecodeManager.incBytecodes(2);
                Locale.isoCountries = getISO2Table(s);
                BytecodeManager.incBytecodes(1);
            }
            final String[] array = new String[Locale.isoCountries.length];
            BytecodeManager.incBytecodes(3);
            final String[] isoCountries2 = Locale.isoCountries;
            final int n = 0;
            final String[] array2 = array;
            final int n2 = 0;
            final int length = Locale.isoCountries.length;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(isoCountries2, n, array2, n2, length);
            final String[] array3 = array;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String[] getISOLanguages() {
        try {
            final String[] isoLanguages = Locale.isoLanguages;
            BytecodeManager.incBytecodes(2);
            if (isoLanguages == null) {
                final String s = "aaaarababkaeaveafafrakakaamamhanargararaasasmavavaayaymazazebabakbebelbgbulbhbihbibisbmbambnbenbobodbrbrebsboscacatcechechchacocoscrcrecscescuchucvchvcycymdadandedeudvdivdzdzoeeeweelellenengeoepoesspaetesteueusfafasfffulfifinfjfijfofaofrfrafyfrygaglegdglaglglggngrngugujgvglvhahauhehebhihinhohmohrhrvhthathuhunhyhyehzheriainaidindieileigiboiiiiiikipkinindioidoisislititaiuikuiwhebjajpnjiyidjvjavkakatkgkonkikikkjkuakkkazklkalkmkhmknkankokorkrkaukskaskukurkvkomkwcorkykirlalatlbltzlgluglilimlnlinlolaoltlitlulublvlavmgmlgmhmahmimrimkmkdmlmalmnmonmomolmrmarmsmsamtmltmymyananaunbnobndndenenepngndonlnldnnnnononornrnblnvnavnynyaocociojojiomormororiososspapanpipliplpolpspusptporququermrohrnrunroronrurusrwkinsasanscsrdsdsndsesmesgsagsisinskslkslslvsmsmosnsnasosomsqsqisrsrpsssswstsotsusunsvsweswswatatamteteltgtgkththatitirtktuktltgltntsntotontrturtstsotttattwtwitytahuguigukukrururduzuzbvevenvivievovolwawlnwowolxhxhoyiyidyoyorzazhazhzhozuzul";
                BytecodeManager.incBytecodes(2);
                Locale.isoLanguages = getISO2Table(s);
                BytecodeManager.incBytecodes(1);
            }
            final String[] array = new String[Locale.isoLanguages.length];
            BytecodeManager.incBytecodes(3);
            final String[] isoLanguages2 = Locale.isoLanguages;
            final int n = 0;
            final String[] array2 = array;
            final int n2 = 0;
            final int length = Locale.isoLanguages.length;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(isoLanguages2, n, array2, n2, length);
            final String[] array3 = array;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String[] getISO2Table(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = s.length() / 5;
            BytecodeManager.incBytecodes(3);
            final String[] array = new String[n];
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            int n3 = 0;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n4 = n2;
                final int n5 = n;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final String[] array2 = array;
                final int n6 = n2;
                final int beginIndex = n3;
                final int endIndex = n3 + 2;
                BytecodeManager.incBytecodes(8);
                array2[n6] = s.substring(beginIndex, endIndex);
                BytecodeManager.incBytecodes(1);
                ++n2;
                n3 += 5;
                BytecodeManager.incBytecodes(3);
            }
            final String[] array3 = array;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getLanguage() {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String language = baseLocale.getLanguage();
            BytecodeManager.incBytecodes(1);
            return language;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getScript() {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String script = baseLocale.getScript();
            BytecodeManager.incBytecodes(1);
            return script;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getCountry() {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String region = baseLocale.getRegion();
            BytecodeManager.incBytecodes(1);
            return region;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getVariant() {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String variant = baseLocale.getVariant();
            BytecodeManager.incBytecodes(1);
            return variant;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasExtensions() {
        try {
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (localeExtensions != null) {
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
    
    public Locale stripExtensions() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean hasExtensions = this.hasExtensions();
            BytecodeManager.incBytecodes(1);
            Locale instance;
            if (hasExtensions) {
                final BaseLocale baseLocale = this.baseLocale;
                final LocaleExtensions localeExtensions = null;
                BytecodeManager.incBytecodes(4);
                instance = getInstance(baseLocale, localeExtensions);
                BytecodeManager.incBytecodes(1);
            }
            else {
                instance = this;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getExtension(final char c) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean validKey = LocaleExtensions.isValidKey(c);
            BytecodeManager.incBytecodes(1);
            if (!validKey) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Ill-formed extension key: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(c);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final boolean hasExtensions = this.hasExtensions();
            BytecodeManager.incBytecodes(1);
            String extensionValue;
            if (hasExtensions) {
                final LocaleExtensions localeExtensions = this.localeExtensions;
                BytecodeManager.incBytecodes(4);
                final Character value = c;
                BytecodeManager.incBytecodes(1);
                extensionValue = localeExtensions.getExtensionValue(value);
                BytecodeManager.incBytecodes(1);
            }
            else {
                extensionValue = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return extensionValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Set<Character> getExtensionKeys() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean hasExtensions = this.hasExtensions();
            BytecodeManager.incBytecodes(1);
            if (!hasExtensions) {
                BytecodeManager.incBytecodes(1);
                final Set<Character> emptySet = Collections.emptySet();
                BytecodeManager.incBytecodes(1);
                return emptySet;
            }
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            final Set keys = localeExtensions.getKeys();
            BytecodeManager.incBytecodes(1);
            return (Set<Character>)keys;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Set<String> getUnicodeLocaleAttributes() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean hasExtensions = this.hasExtensions();
            BytecodeManager.incBytecodes(1);
            if (!hasExtensions) {
                BytecodeManager.incBytecodes(1);
                final Set<String> emptySet = Collections.emptySet();
                BytecodeManager.incBytecodes(1);
                return emptySet;
            }
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            final Set unicodeLocaleAttributes = localeExtensions.getUnicodeLocaleAttributes();
            BytecodeManager.incBytecodes(1);
            return (Set<String>)unicodeLocaleAttributes;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getUnicodeLocaleType(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean unicodeExtensionKey = isUnicodeExtensionKey(s);
            BytecodeManager.incBytecodes(1);
            if (!unicodeExtensionKey) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Ill-formed Unicode locale key: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(s);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final boolean hasExtensions = this.hasExtensions();
            BytecodeManager.incBytecodes(1);
            String unicodeLocaleType;
            if (hasExtensions) {
                final LocaleExtensions localeExtensions = this.localeExtensions;
                BytecodeManager.incBytecodes(4);
                unicodeLocaleType = localeExtensions.getUnicodeLocaleType(s);
                BytecodeManager.incBytecodes(1);
            }
            else {
                unicodeLocaleType = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return unicodeLocaleType;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Set<String> getUnicodeLocaleKeys() {
        try {
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            if (localeExtensions == null) {
                BytecodeManager.incBytecodes(1);
                final Set<String> emptySet = Collections.emptySet();
                BytecodeManager.incBytecodes(1);
                return emptySet;
            }
            final LocaleExtensions localeExtensions2 = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            final Set unicodeLocaleKeys = localeExtensions2.getUnicodeLocaleKeys();
            BytecodeManager.incBytecodes(1);
            return (Set<String>)unicodeLocaleKeys;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BaseLocale getBaseLocale() {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            return baseLocale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    LocaleExtensions getLocaleExtensions() {
        try {
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            return localeExtensions;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final String toString() {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String language = baseLocale.getLanguage();
            BytecodeManager.incBytecodes(1);
            final int length = language.length();
            BytecodeManager.incBytecodes(1);
            int n;
            if (length != 0) {
                n = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(1);
            final BaseLocale baseLocale2 = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String script = baseLocale2.getScript();
            BytecodeManager.incBytecodes(1);
            final int length2 = script.length();
            BytecodeManager.incBytecodes(1);
            int n3;
            if (length2 != 0) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            final BaseLocale baseLocale3 = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String region = baseLocale3.getRegion();
            BytecodeManager.incBytecodes(1);
            final int length3 = region.length();
            BytecodeManager.incBytecodes(1);
            int n5;
            if (length3 != 0) {
                n5 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n5 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n6 = n5;
            BytecodeManager.incBytecodes(1);
            final BaseLocale baseLocale4 = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String variant = baseLocale4.getVariant();
            BytecodeManager.incBytecodes(1);
            final int length4 = variant.length();
            BytecodeManager.incBytecodes(1);
            int n7;
            if (length4 != 0) {
                n7 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n7 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n8 = n7;
            BytecodeManager.incBytecodes(1);
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            int n9 = 0;
            Label_0252: {
                if (localeExtensions != null) {
                    final LocaleExtensions localeExtensions2 = this.localeExtensions;
                    BytecodeManager.incBytecodes(3);
                    final String id = localeExtensions2.getID();
                    BytecodeManager.incBytecodes(1);
                    final int length5 = id.length();
                    BytecodeManager.incBytecodes(1);
                    if (length5 != 0) {
                        n9 = 1;
                        BytecodeManager.incBytecodes(2);
                        break Label_0252;
                    }
                }
                n9 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n10 = n9;
            BytecodeManager.incBytecodes(1);
            final BaseLocale baseLocale5 = this.baseLocale;
            BytecodeManager.incBytecodes(5);
            final String language2 = baseLocale5.getLanguage();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb = new StringBuilder(language2);
            BytecodeManager.incBytecodes(1);
            final int n11 = n6;
            BytecodeManager.incBytecodes(2);
            Label_0380: {
                if (n11 == 0) {
                    final int n12 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n12 == 0) {
                        break Label_0380;
                    }
                    final int n13 = n8;
                    BytecodeManager.incBytecodes(2);
                    if (n13 == 0) {
                        final int n14 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n14 == 0) {
                            final int n15 = n10;
                            BytecodeManager.incBytecodes(2);
                            if (n15 == 0) {
                                break Label_0380;
                            }
                        }
                    }
                }
                final StringBuilder sb2 = sb;
                final char c = '_';
                BytecodeManager.incBytecodes(3);
                final StringBuilder append = sb2.append(c);
                final BaseLocale baseLocale6 = this.baseLocale;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final String region2 = baseLocale6.getRegion();
                BytecodeManager.incBytecodes(1);
                append.append(region2);
                BytecodeManager.incBytecodes(1);
            }
            final int n16 = n8;
            BytecodeManager.incBytecodes(2);
            Label_0451: {
                if (n16 != 0) {
                    final int n17 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n17 == 0) {
                        final int n18 = n6;
                        BytecodeManager.incBytecodes(2);
                        if (n18 == 0) {
                            break Label_0451;
                        }
                    }
                    final StringBuilder sb3 = sb;
                    final char c2 = '_';
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append2 = sb3.append(c2);
                    final BaseLocale baseLocale7 = this.baseLocale;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final String variant2 = baseLocale7.getVariant();
                    BytecodeManager.incBytecodes(1);
                    append2.append(variant2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n19 = n4;
            BytecodeManager.incBytecodes(2);
            Label_0522: {
                if (n19 != 0) {
                    final int n20 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n20 == 0) {
                        final int n21 = n6;
                        BytecodeManager.incBytecodes(2);
                        if (n21 == 0) {
                            break Label_0522;
                        }
                    }
                    final StringBuilder sb4 = sb;
                    final String str = "_#";
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append3 = sb4.append(str);
                    final BaseLocale baseLocale8 = this.baseLocale;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final String script2 = baseLocale8.getScript();
                    BytecodeManager.incBytecodes(1);
                    append3.append(script2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n22 = n10;
            BytecodeManager.incBytecodes(2);
            Label_0623: {
                if (n22 != 0) {
                    final int n23 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n23 == 0) {
                        final int n24 = n6;
                        BytecodeManager.incBytecodes(2);
                        if (n24 == 0) {
                            break Label_0623;
                        }
                    }
                    final StringBuilder sb5 = sb;
                    final char c3 = '_';
                    BytecodeManager.incBytecodes(3);
                    sb5.append(c3);
                    BytecodeManager.incBytecodes(1);
                    final int n25 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n25 == 0) {
                        final StringBuilder sb6 = sb;
                        final char c4 = '#';
                        BytecodeManager.incBytecodes(3);
                        sb6.append(c4);
                        BytecodeManager.incBytecodes(1);
                    }
                    final StringBuilder sb7 = sb;
                    final LocaleExtensions localeExtensions3 = this.localeExtensions;
                    BytecodeManager.incBytecodes(4);
                    final String id2 = localeExtensions3.getID();
                    BytecodeManager.incBytecodes(1);
                    sb7.append(id2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final StringBuilder sb8 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb8.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String toLanguageTag() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Locale.languageTag:Ljava/lang/String;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          22
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Locale.languageTag:Ljava/lang/String;
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: areturn        
        //    22: aload_0        
        //    23: getfield        instrumented/java/util/Locale.baseLocale:Lsun/util/locale/BaseLocale;
        //    26: aload_0        
        //    27: getfield        instrumented/java/util/Locale.localeExtensions:Lsun/util/locale/LocaleExtensions;
        //    30: ldc             5
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokestatic    sun/util/locale/LanguageTag.parseLocale:(Lsun/util/locale/BaseLocale;Lsun/util/locale/LocaleExtensions;)Lsun/util/locale/LanguageTag;
        //    38: astore_1       
        //    39: ldc             1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: new             Ljava/lang/StringBuilder;
        //    47: dup            
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokespecial   java/lang/StringBuilder.<init>:()V
        //    56: astore_2       
        //    57: ldc             1
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: aload_1        
        //    63: ldc             2
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: invokevirtual   sun/util/locale/LanguageTag.getLanguage:()Ljava/lang/String;
        //    71: astore_3       
        //    72: ldc             1
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: aload_3        
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: invokevirtual   java/lang/String.length:()I
        //    86: ldc             1
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: ifle            118
        //    94: aload_2        
        //    95: aload_3        
        //    96: ldc             3
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: invokestatic    sun/util/locale/LanguageTag.canonicalizeLanguage:(Ljava/lang/String;)Ljava/lang/String;
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: pop            
        //   113: ldc             1
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: aload_1        
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokevirtual   sun/util/locale/LanguageTag.getScript:()Ljava/lang/String;
        //   127: astore_3       
        //   128: ldc             1
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: aload_3        
        //   134: ldc             2
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokevirtual   java/lang/String.length:()I
        //   142: ldc             1
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: ifle            192
        //   150: aload_2        
        //   151: ldc_w           "-"
        //   154: ldc             3
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   162: pop            
        //   163: ldc             1
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: aload_2        
        //   169: aload_3        
        //   170: ldc             3
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokestatic    sun/util/locale/LanguageTag.canonicalizeScript:(Ljava/lang/String;)Ljava/lang/String;
        //   178: ldc             1
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   186: pop            
        //   187: ldc             1
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: aload_1        
        //   193: ldc             2
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokevirtual   sun/util/locale/LanguageTag.getRegion:()Ljava/lang/String;
        //   201: astore_3       
        //   202: ldc             1
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: aload_3        
        //   208: ldc             2
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: invokevirtual   java/lang/String.length:()I
        //   216: ldc             1
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: ifle            266
        //   224: aload_2        
        //   225: ldc_w           "-"
        //   228: ldc             3
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   236: pop            
        //   237: ldc             1
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: aload_2        
        //   243: aload_3        
        //   244: ldc             3
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: invokestatic    sun/util/locale/LanguageTag.canonicalizeRegion:(Ljava/lang/String;)Ljava/lang/String;
        //   252: ldc             1
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   260: pop            
        //   261: ldc             1
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: aload_1        
        //   267: ldc             2
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: invokevirtual   sun/util/locale/LanguageTag.getVariants:()Linstrumented/java/util/List;
        //   275: astore          4
        //   277: ldc             1
        //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   282: aload           4
        //   284: ldc             2
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokeinterface instrumented/java/util/List.iterator:()Ljava/util/Iterator;
        //   294: astore          5
        //   296: ldc             1
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: aload           5
        //   303: ldc             2
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: invokeinterface java/util/Iterator.hasNext:()Z
        //   313: ldc             1
        //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   318: ifeq            386
        //   321: aload           5
        //   323: ldc             2
        //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   328: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   333: checkcast       Ljava/lang/String;
        //   336: astore          6
        //   338: ldc             2
        //   340: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   343: aload_2        
        //   344: ldc_w           "-"
        //   347: ldc             3
        //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   352: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   355: pop            
        //   356: ldc             1
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: aload_2        
        //   362: aload           6
        //   364: ldc             3
        //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   369: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   372: pop            
        //   373: ldc             1
        //   375: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   378: ldc             1
        //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   383: goto            301
        //   386: aload_1        
        //   387: ldc             2
        //   389: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   392: invokevirtual   sun/util/locale/LanguageTag.getExtensions:()Linstrumented/java/util/List;
        //   395: astore          4
        //   397: ldc             1
        //   399: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   402: aload           4
        //   404: ldc             2
        //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   409: invokeinterface instrumented/java/util/List.iterator:()Ljava/util/Iterator;
        //   414: astore          5
        //   416: ldc             1
        //   418: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   421: aload           5
        //   423: ldc             2
        //   425: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   428: invokeinterface java/util/Iterator.hasNext:()Z
        //   433: ldc             1
        //   435: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   438: ifeq            514
        //   441: aload           5
        //   443: ldc             2
        //   445: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   448: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   453: checkcast       Ljava/lang/String;
        //   456: astore          6
        //   458: ldc             2
        //   460: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   463: aload_2        
        //   464: ldc_w           "-"
        //   467: ldc             3
        //   469: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   472: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   475: pop            
        //   476: ldc             1
        //   478: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   481: aload_2        
        //   482: aload           6
        //   484: ldc             3
        //   486: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   489: invokestatic    sun/util/locale/LanguageTag.canonicalizeExtension:(Ljava/lang/String;)Ljava/lang/String;
        //   492: ldc             1
        //   494: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   497: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   500: pop            
        //   501: ldc             1
        //   503: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   506: ldc             1
        //   508: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   511: goto            421
        //   514: aload_1        
        //   515: ldc             2
        //   517: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   520: invokevirtual   sun/util/locale/LanguageTag.getPrivateuse:()Ljava/lang/String;
        //   523: astore_3       
        //   524: ldc             1
        //   526: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   529: aload_3        
        //   530: ldc             2
        //   532: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   535: invokevirtual   java/lang/String.length:()I
        //   538: ldc             1
        //   540: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   543: ifle            626
        //   546: aload_2        
        //   547: ldc             2
        //   549: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   552: invokevirtual   java/lang/StringBuilder.length:()I
        //   555: ldc             1
        //   557: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   560: ifle            581
        //   563: aload_2        
        //   564: ldc_w           "-"
        //   567: ldc             3
        //   569: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   572: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   575: pop            
        //   576: ldc             1
        //   578: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   581: aload_2        
        //   582: ldc_w           "x"
        //   585: ldc             3
        //   587: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   590: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   593: ldc_w           "-"
        //   596: ldc             2
        //   598: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   601: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   604: pop            
        //   605: ldc             1
        //   607: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   610: aload_2        
        //   611: aload_3        
        //   612: ldc             3
        //   614: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   617: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   620: pop            
        //   621: ldc             1
        //   623: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   626: aload_2        
        //   627: ldc             2
        //   629: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   632: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   635: astore          5
        //   637: ldc             1
        //   639: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   642: aload_0        
        //   643: dup            
        //   644: astore          6
        //   646: pop            
        //   647: ldc             4
        //   649: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   652: aload_0        
        //   653: getfield        instrumented/java/util/Locale.languageTag:Ljava/lang/String;
        //   656: ldc             3
        //   658: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   661: ifnonnull       675
        //   664: aload_0        
        //   665: aload           5
        //   667: putfield        instrumented/java/util/Locale.languageTag:Ljava/lang/String;
        //   670: ldc             3
        //   672: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   675: aload           6
        //   677: pop            
        //   678: ldc             2
        //   680: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   683: ldc             1
        //   685: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   688: goto            709
        //   691: astore          7
        //   693: aload           6
        //   695: pop            
        //   696: ldc             503
        //   698: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   701: aload           7
        //   703: ldc             2
        //   705: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   708: athrow         
        //   709: aload_0        
        //   710: getfield        instrumented/java/util/Locale.languageTag:Ljava/lang/String;
        //   713: ldc             3
        //   715: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   718: areturn        
        //   719: athrow         
        //   720: athrow         
        //    StackMapTable: 00 0F 16 FE 00 5F 07 01 A6 07 01 66 07 00 81 FB 00 49 FB 00 49 FD 00 22 07 01 BE 07 01 C4 FA 00 54 FC 00 22 07 01 C4 FA 00 5C FB 00 42 2C FD 00 30 07 00 81 07 00 04 4F 07 00 7E FA 00 11 FF 00 09 00 00 00 01 07 00 7E FF 00 00 00 00 00 01 07 00 B8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  652    720    720    721    Ljava/lang/VirtualMachineError;
        //  652    683    691    709    Any
        //  691    701    691    709    Any
        //  0      719    719    720    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0675:
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
    
    public static Locale forLanguageTag(final String languageTag) {
        try {
            final ParseStatus sts = null;
            BytecodeManager.incBytecodes(3);
            final LanguageTag parse = LanguageTag.parse(languageTag, sts);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final InternalLocaleBuilder internalLocaleBuilder = new InternalLocaleBuilder();
            BytecodeManager.incBytecodes(1);
            final InternalLocaleBuilder internalLocaleBuilder2 = internalLocaleBuilder;
            final LanguageTag languageTag2 = parse;
            BytecodeManager.incBytecodes(3);
            internalLocaleBuilder2.setLanguageTag(languageTag2);
            BytecodeManager.incBytecodes(1);
            final InternalLocaleBuilder internalLocaleBuilder3 = internalLocaleBuilder;
            BytecodeManager.incBytecodes(2);
            final BaseLocale baseLocale = internalLocaleBuilder3.getBaseLocale();
            BytecodeManager.incBytecodes(1);
            final InternalLocaleBuilder internalLocaleBuilder4 = internalLocaleBuilder;
            BytecodeManager.incBytecodes(2);
            LocaleExtensions localeExtensions = internalLocaleBuilder4.getLocaleExtensions();
            BytecodeManager.incBytecodes(1);
            final LocaleExtensions localeExtensions2 = localeExtensions;
            BytecodeManager.incBytecodes(2);
            if (localeExtensions2 == null) {
                final BaseLocale baseLocale2 = baseLocale;
                BytecodeManager.incBytecodes(2);
                final String variant = baseLocale2.getVariant();
                BytecodeManager.incBytecodes(1);
                final int length = variant.length();
                BytecodeManager.incBytecodes(1);
                if (length > 0) {
                    final BaseLocale baseLocale3 = baseLocale;
                    BytecodeManager.incBytecodes(2);
                    final String language = baseLocale3.getLanguage();
                    final BaseLocale baseLocale4 = baseLocale;
                    BytecodeManager.incBytecodes(2);
                    final String script = baseLocale4.getScript();
                    final BaseLocale baseLocale5 = baseLocale;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String region = baseLocale5.getRegion();
                    final BaseLocale baseLocale6 = baseLocale;
                    BytecodeManager.incBytecodes(2);
                    final String variant2 = baseLocale6.getVariant();
                    BytecodeManager.incBytecodes(1);
                    localeExtensions = getCompatibilityExtensions(language, script, region, variant2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final BaseLocale baseLocale7 = baseLocale;
            final LocaleExtensions localeExtensions3 = localeExtensions;
            BytecodeManager.incBytecodes(3);
            final Locale instance = getInstance(baseLocale7, localeExtensions3);
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getISO3Language() throws MissingResourceException {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String language = baseLocale.getLanguage();
            BytecodeManager.incBytecodes(1);
            final String s = language;
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            final int n = 3;
            BytecodeManager.incBytecodes(2);
            if (length == n) {
                final String s2 = language;
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            final String s3 = language;
            final String s4 = "aaaarababkaeaveafafrakakaamamhanargararaasasmavavaayaymazazebabakbebelbgbulbhbihbibisbmbambnbenbobodbrbrebsboscacatcechechchacocoscrcrecscescuchucvchvcycymdadandedeudvdivdzdzoeeeweelellenengeoepoesspaetesteueusfafasfffulfifinfjfijfofaofrfrafyfrygaglegdglaglglggngrngugujgvglvhahauhehebhihinhohmohrhrvhthathuhunhyhyehzheriainaidindieileigiboiiiiiikipkinindioidoisislititaiuikuiwhebjajpnjiyidjvjavkakatkgkonkikikkjkuakkkazklkalkmkhmknkankokorkrkaukskaskukurkvkomkwcorkykirlalatlbltzlgluglilimlnlinlolaoltlitlulublvlavmgmlgmhmahmimrimkmkdmlmalmnmonmomolmrmarmsmsamtmltmymyananaunbnobndndenenepngndonlnldnnnnononornrnblnvnavnynyaocociojojiomormororiososspapanpipliplpolpspusptporququermrohrnrunroronrurusrwkinsasanscsrdsdsndsesmesgsagsisinskslkslslvsmsmosnsnasosomsqsqisrsrpsssswstsotsusunsvsweswswatatamteteltgtgkththatitirtktuktltgltntsntotontrturtstsotttattwtwitytahuguigukukrururduzuzbvevenvivievovolwawlnwowolxhxhoyiyidyoyorzazhazhzhozuzul";
            BytecodeManager.incBytecodes(3);
            final String iso3Code = getISO3Code(s3, s4);
            BytecodeManager.incBytecodes(1);
            final String s5 = iso3Code;
            BytecodeManager.incBytecodes(2);
            if (s5 == null) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Couldn't find 3-letter language code for ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = language;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str3 = "FormatData_";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String string2 = this.toString();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(string2);
                BytecodeManager.incBytecodes(1);
                final String string3 = append4.toString();
                final String s6 = "ShortLanguage";
                BytecodeManager.incBytecodes(2);
                final MissingResourceException ex = new MissingResourceException(string, string3, s6);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final String s7 = iso3Code;
            BytecodeManager.incBytecodes(2);
            return s7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getISO3Country() throws MissingResourceException {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String region = baseLocale.getRegion();
            final String s = "ADANDAEAREAFAFGAGATGAIAIAALALBAMARMANANTAOAGOAQATAARARGASASMATAUTAUAUSAWABWAXALAAZAZEBABIHBBBRBBDBGDBEBELBFBFABGBGRBHBHRBIBDIBJBENBLBLMBMBMUBNBRNBOBOLBQBESBRBRABSBHSBTBTNBVBVTBWBWABYBLRBZBLZCACANCCCCKCDCODCFCAFCGCOGCHCHECICIVCKCOKCLCHLCMCMRCNCHNCOCOLCRCRICUCUBCVCPVCWCUWCXCXRCYCYPCZCZEDEDEUDJDJIDKDNKDMDMADODOMDZDZAECECUEEESTEGEGYEHESHERERIESESPETETHFIFINFJFJIFKFLKFMFSMFOFROFRFRAGAGABGBGBRGDGRDGEGEOGFGUFGGGGYGHGHAGIGIBGLGRLGMGMBGNGINGPGLPGQGNQGRGRCGSSGSGTGTMGUGUMGWGNBGYGUYHKHKGHMHMDHNHNDHRHRVHTHTIHUHUNIDIDNIEIRLILISRIMIMNININDIOIOTIQIRQIRIRNISISLITITAJEJEYJMJAMJOJORJPJPNKEKENKGKGZKHKHMKIKIRKMCOMKNKNAKPPRKKRKORKWKWTKYCYMKZKAZLALAOLBLBNLCLCALILIELKLKALRLBRLSLSOLTLTULULUXLVLVALYLBYMAMARMCMCOMDMDAMEMNEMFMAFMGMDGMHMHLMKMKDMLMLIMMMMRMNMNGMOMACMPMNPMQMTQMRMRTMSMSRMTMLTMUMUSMVMDVMWMWIMXMEXMYMYSMZMOZNANAMNCNCLNENERNFNFKNGNGANINICNLNLDNONORNPNPLNRNRUNUNIUNZNZLOMOMNPAPANPEPERPFPYFPGPNGPHPHLPKPAKPLPOLPMSPMPNPCNPRPRIPSPSEPTPRTPWPLWPYPRYQAQATREREUROROURSSRBRURUSRWRWASASAUSBSLBSCSYCSDSDNSESWESGSGPSHSHNSISVNSJSJMSKSVKSLSLESMSMRSNSENSOSOMSRSURSSSSDSTSTPSVSLVSXSXMSYSYRSZSWZTCTCATDTCDTFATFTGTGOTHTHATJTJKTKTKLTLTLSTMTKMTNTUNTOTONTRTURTTTTOTVTUVTWTWNTZTZAUAUKRUGUGAUMUMIUSUSAUYURYUZUZBVAVATVCVCTVEVENVGVGBVIVIRVNVNMVUVUTWFWLFWSWSMYEYEMYTMYTZAZAFZMZMBZWZWE";
            BytecodeManager.incBytecodes(2);
            final String iso3Code = getISO3Code(region, s);
            BytecodeManager.incBytecodes(1);
            final String s2 = iso3Code;
            BytecodeManager.incBytecodes(2);
            if (s2 == null) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Couldn't find 3-letter country code for ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final BaseLocale baseLocale2 = this.baseLocale;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final String region2 = baseLocale2.getRegion();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(region2);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "FormatData_";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                BytecodeManager.incBytecodes(2);
                final String string2 = this.toString();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(string2);
                BytecodeManager.incBytecodes(1);
                final String string3 = append4.toString();
                final String s3 = "ShortCountry";
                BytecodeManager.incBytecodes(2);
                final MissingResourceException ex = new MissingResourceException(string, string3, s3);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final String s4 = iso3Code;
            BytecodeManager.incBytecodes(2);
            return s4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String getISO3Code(final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            final int n = length;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final String s3 = "";
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            BytecodeManager.incBytecodes(2);
            final int length2 = s2.length();
            BytecodeManager.incBytecodes(1);
            int n2 = length2;
            BytecodeManager.incBytecodes(2);
            final int n3 = length;
            final int n4 = 2;
            BytecodeManager.incBytecodes(3);
            if (n3 == n4) {
                final int index = 0;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index);
                BytecodeManager.incBytecodes(1);
                final int index2 = 1;
                BytecodeManager.incBytecodes(3);
                final char char2 = s.charAt(index2);
                BytecodeManager.incBytecodes(1);
                n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n2;
                    final int n6 = length2;
                    BytecodeManager.incBytecodes(3);
                    if (n5 >= n6) {
                        break;
                    }
                    final int index3 = n2;
                    BytecodeManager.incBytecodes(3);
                    final char char3 = s2.charAt(index3);
                    final char c = char1;
                    BytecodeManager.incBytecodes(2);
                    if (char3 == c) {
                        final int index4 = n2 + 1;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final char char4 = s2.charAt(index4);
                        final char c2 = char2;
                        BytecodeManager.incBytecodes(2);
                        if (char4 == c2) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    n2 += 5;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n7 = n2;
            final int n8 = length2;
            BytecodeManager.incBytecodes(3);
            String substring;
            if (n7 < n8) {
                final int beginIndex = n2 + 2;
                final int endIndex = n2 + 5;
                BytecodeManager.incBytecodes(8);
                substring = s2.substring(beginIndex, endIndex);
                BytecodeManager.incBytecodes(1);
            }
            else {
                substring = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return substring;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getDisplayLanguage() {
        try {
            final Category display = Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String displayLanguage = this.getDisplayLanguage(default1);
            BytecodeManager.incBytecodes(1);
            return displayLanguage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayLanguage(final Locale locale) {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(4);
            final String language = baseLocale.getLanguage();
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final String displayString = this.getDisplayString(language, locale, n);
            BytecodeManager.incBytecodes(1);
            return displayString;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayScript() {
        try {
            final Category display = Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String displayScript = this.getDisplayScript(default1);
            BytecodeManager.incBytecodes(1);
            return displayScript;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayScript(final Locale locale) {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(4);
            final String script = baseLocale.getScript();
            final int n = 3;
            BytecodeManager.incBytecodes(3);
            final String displayString = this.getDisplayString(script, locale, n);
            BytecodeManager.incBytecodes(1);
            return displayString;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getDisplayCountry() {
        try {
            final Category display = Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String displayCountry = this.getDisplayCountry(default1);
            BytecodeManager.incBytecodes(1);
            return displayCountry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayCountry(final Locale locale) {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(4);
            final String region = baseLocale.getRegion();
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final String displayString = this.getDisplayString(region, locale, n);
            BytecodeManager.incBytecodes(1);
            return displayString;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String getDisplayString(final String str, final Locale locale, final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = str.length();
            BytecodeManager.incBytecodes(1);
            if (length == 0) {
                final String s = "";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            BytecodeManager.incBytecodes(2);
            if (locale == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Class<LocaleNameProvider> providerClass = LocaleNameProvider.class;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LocaleServiceProviderPool pool = LocaleServiceProviderPool.getPool((Class<? extends LocaleServiceProvider>)providerClass);
            BytecodeManager.incBytecodes(1);
            final int n = 2;
            BytecodeManager.incBytecodes(3);
            String string;
            if (i == n) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str2 = "%%";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(1);
                string = append2.toString();
                BytecodeManager.incBytecodes(1);
            }
            else {
                string = str;
                BytecodeManager.incBytecodes(1);
            }
            final String s2 = string;
            BytecodeManager.incBytecodes(1);
            final LocaleServiceProviderPool localeServiceProviderPool = pool;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LocaleNameGetter access$500 = LocaleNameGetter.access$500();
            final String s3 = s2;
            final Object[] array = new Object[2];
            final int n2 = 0;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            array[n2] = i;
            array[1] = str;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s4 = (String)localeServiceProviderPool.getLocalizedObject((LocaleServiceProviderPool.LocalizedObjectGetter)access$500, locale, s3, array);
            BytecodeManager.incBytecodes(2);
            final String s5 = s4;
            BytecodeManager.incBytecodes(2);
            if (s5 != null) {
                final String s6 = s4;
                BytecodeManager.incBytecodes(2);
                return s6;
            }
            BytecodeManager.incBytecodes(2);
            return str;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getDisplayVariant() {
        try {
            final Category display = Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String displayVariant = this.getDisplayVariant(default1);
            BytecodeManager.incBytecodes(1);
            return displayVariant;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayVariant(final Locale locale) {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String variant = baseLocale.getVariant();
            BytecodeManager.incBytecodes(1);
            final int length = variant.length();
            BytecodeManager.incBytecodes(1);
            if (length == 0) {
                final String s = "";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            BytecodeManager.incBytecodes(1);
            final LocaleProviderAdapter forJRE = LocaleProviderAdapter.forJRE();
            BytecodeManager.incBytecodes(2);
            final LocaleResources localeResources = forJRE.getLocaleResources(locale);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final String[] displayVariantArray = this.getDisplayVariantArray(locale);
            BytecodeManager.incBytecodes(1);
            final String[] array = displayVariantArray;
            final LocaleResources localeResources2 = localeResources;
            final String key = "ListPattern";
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final String localeName = localeResources2.getLocaleName(key);
            final LocaleResources localeResources3 = localeResources;
            final String key2 = "ListCompositionPattern";
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final String localeName2 = localeResources3.getLocaleName(key2);
            BytecodeManager.incBytecodes(1);
            final String formatList = formatList(array, localeName, localeName2);
            BytecodeManager.incBytecodes(1);
            return formatList;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getDisplayName() {
        try {
            final Category display = Category.DISPLAY;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = getDefault(display);
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
            BytecodeManager.incBytecodes(1);
            final LocaleProviderAdapter forJRE = LocaleProviderAdapter.forJRE();
            BytecodeManager.incBytecodes(2);
            final LocaleResources localeResources = forJRE.getLocaleResources(locale);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final String displayLanguage = this.getDisplayLanguage(locale);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final String displayScript = this.getDisplayScript(locale);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final String displayCountry = this.getDisplayCountry(locale);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final String[] displayVariantArray = this.getDisplayVariantArray(locale);
            BytecodeManager.incBytecodes(1);
            final LocaleResources localeResources2 = localeResources;
            final String key = "DisplayNamePattern";
            BytecodeManager.incBytecodes(3);
            final String localeName = localeResources2.getLocaleName(key);
            BytecodeManager.incBytecodes(1);
            final LocaleResources localeResources3 = localeResources;
            final String key2 = "ListPattern";
            BytecodeManager.incBytecodes(3);
            final String localeName2 = localeResources3.getLocaleName(key2);
            BytecodeManager.incBytecodes(1);
            final LocaleResources localeResources4 = localeResources;
            final String key3 = "ListCompositionPattern";
            BytecodeManager.incBytecodes(3);
            final String localeName3 = localeResources4.getLocaleName(key3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final String s = displayLanguage;
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            if (length == 0) {
                final String s2 = displayScript;
                BytecodeManager.incBytecodes(2);
                final int length2 = s2.length();
                BytecodeManager.incBytecodes(1);
                if (length2 == 0) {
                    final String s3 = displayCountry;
                    BytecodeManager.incBytecodes(2);
                    final int length3 = s3.length();
                    BytecodeManager.incBytecodes(1);
                    if (length3 == 0) {
                        final int length4 = displayVariantArray.length;
                        BytecodeManager.incBytecodes(3);
                        if (length4 == 0) {
                            final String s4 = "";
                            BytecodeManager.incBytecodes(2);
                            return s4;
                        }
                        final String[] array = displayVariantArray;
                        final String s5 = localeName2;
                        final String s6 = localeName3;
                        BytecodeManager.incBytecodes(4);
                        final String formatList = formatList(array, s5, s6);
                        BytecodeManager.incBytecodes(1);
                        return formatList;
                    }
                }
            }
            final int n = 4;
            BytecodeManager.incBytecodes(4);
            final ArrayList list = new ArrayList<Object>(n);
            BytecodeManager.incBytecodes(1);
            final String s7 = displayLanguage;
            BytecodeManager.incBytecodes(2);
            final int length5 = s7.length();
            BytecodeManager.incBytecodes(1);
            if (length5 != 0) {
                final ArrayList list2 = list;
                final String s8 = displayLanguage;
                BytecodeManager.incBytecodes(3);
                list2.add(s8);
                BytecodeManager.incBytecodes(1);
            }
            final String s9 = displayScript;
            BytecodeManager.incBytecodes(2);
            final int length6 = s9.length();
            BytecodeManager.incBytecodes(1);
            if (length6 != 0) {
                final ArrayList list3 = list;
                final String s10 = displayScript;
                BytecodeManager.incBytecodes(3);
                list3.add(s10);
                BytecodeManager.incBytecodes(1);
            }
            final String s11 = displayCountry;
            BytecodeManager.incBytecodes(2);
            final int length7 = s11.length();
            BytecodeManager.incBytecodes(1);
            if (length7 != 0) {
                final ArrayList list4 = list;
                final String s12 = displayCountry;
                BytecodeManager.incBytecodes(3);
                list4.add(s12);
                BytecodeManager.incBytecodes(1);
            }
            final int length8 = displayVariantArray.length;
            BytecodeManager.incBytecodes(3);
            if (length8 != 0) {
                final ArrayList list5 = list;
                final String[] array2 = displayVariantArray;
                BytecodeManager.incBytecodes(3);
                final List<String> list6 = Arrays.asList(array2);
                BytecodeManager.incBytecodes(1);
                list5.addAll(list6);
                BytecodeManager.incBytecodes(1);
            }
            final ArrayList list7 = list;
            final int n2 = 0;
            BytecodeManager.incBytecodes(3);
            final String s13 = list7.get(n2);
            BytecodeManager.incBytecodes(2);
            final ArrayList list8 = list;
            BytecodeManager.incBytecodes(2);
            final int size = list8.size();
            BytecodeManager.incBytecodes(1);
            final int n3 = size;
            final int n4 = 1;
            BytecodeManager.incBytecodes(3);
            String[] array4;
            if (n3 > n4) {
                final ArrayList list9 = list;
                final int n5 = 1;
                final int n6 = size;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final List<Object> subList = list9.subList(n5, n6);
                final String[] array3 = new String[size - 1];
                BytecodeManager.incBytecodes(4);
                array4 = subList.toArray(array3);
                BytecodeManager.incBytecodes(2);
            }
            else {
                array4 = new String[0];
                BytecodeManager.incBytecodes(1);
            }
            final String[] array5 = array4;
            BytecodeManager.incBytecodes(1);
            final Object[] array6 = new Object[3];
            final int n7 = 0;
            BytecodeManager.incBytecodes(3);
            final int length9 = array5.length;
            BytecodeManager.incBytecodes(5);
            int value;
            if (length9 != 0) {
                value = 2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = 1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            array6[n7] = new Integer(value);
            array6[1] = s13;
            final int n8 = 2;
            final int length10 = array5.length;
            BytecodeManager.incBytecodes(10);
            Object formatList2;
            if (length10 != 0) {
                final String[] array7 = array5;
                final String s14 = localeName2;
                final String s15 = localeName3;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                formatList2 = formatList(array7, s14, s15);
                BytecodeManager.incBytecodes(1);
            }
            else {
                formatList2 = null;
                BytecodeManager.incBytecodes(1);
            }
            array6[n8] = formatList2;
            final Object[] array8 = array6;
            BytecodeManager.incBytecodes(2);
            final String s16 = localeName;
            BytecodeManager.incBytecodes(2);
            if (s16 != null) {
                final String pattern = localeName;
                BytecodeManager.incBytecodes(4);
                final MessageFormat messageFormat = new MessageFormat(pattern);
                final Object[] obj = array8;
                BytecodeManager.incBytecodes(2);
                final String format = messageFormat.format(obj);
                BytecodeManager.incBytecodes(1);
                return format;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final String str = (String)array8[1];
            BytecodeManager.incBytecodes(6);
            sb2.append(str);
            BytecodeManager.incBytecodes(1);
            final int length11 = array8.length;
            final int n9 = 2;
            BytecodeManager.incBytecodes(4);
            if (length11 > n9) {
                final StringBuilder sb3 = sb;
                final String str2 = " (";
                BytecodeManager.incBytecodes(3);
                sb3.append(str2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb4 = sb;
                final String str3 = (String)array8[2];
                BytecodeManager.incBytecodes(6);
                sb4.append(str3);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb5 = sb;
                final char c = ')';
                BytecodeManager.incBytecodes(3);
                sb5.append(c);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder sb6 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb6.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final Locale locale = (Locale)super.clone();
                BytecodeManager.incBytecodes(2);
                final Locale locale2 = locale;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return locale2;
            }
            catch (CloneNotSupportedException ex) {
                BytecodeManager.incBytecodes(501);
                final CloneNotSupportedException cause = ex;
                BytecodeManager.incBytecodes(4);
                final InternalError internalError = new InternalError(cause);
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public int hashCode() {
        try {
            int hashCodeValue = this.hashCodeValue;
            BytecodeManager.incBytecodes(3);
            final int n = hashCodeValue;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final BaseLocale baseLocale = this.baseLocale;
                BytecodeManager.incBytecodes(3);
                hashCodeValue = baseLocale.hashCode();
                BytecodeManager.incBytecodes(1);
                final LocaleExtensions localeExtensions = this.localeExtensions;
                BytecodeManager.incBytecodes(3);
                if (localeExtensions != null) {
                    final int n2 = hashCodeValue;
                    final LocaleExtensions localeExtensions2 = this.localeExtensions;
                    BytecodeManager.incBytecodes(4);
                    hashCodeValue = (n2 ^ localeExtensions2.hashCode());
                    BytecodeManager.incBytecodes(2);
                }
                this.hashCodeValue = hashCodeValue;
                BytecodeManager.incBytecodes(3);
            }
            final int n3 = hashCodeValue;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            if (this == o) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = o instanceof Locale;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final BaseLocale baseLocale = ((Locale)o).baseLocale;
            BytecodeManager.incBytecodes(4);
            final BaseLocale baseLocale2 = this.baseLocale;
            final BaseLocale obj = baseLocale;
            BytecodeManager.incBytecodes(4);
            final boolean equals = baseLocale2.equals(obj);
            BytecodeManager.incBytecodes(1);
            if (!equals) {
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(3);
            if (localeExtensions == null) {
                final LocaleExtensions localeExtensions2 = ((Locale)o).localeExtensions;
                BytecodeManager.incBytecodes(4);
                boolean b5;
                if (localeExtensions2 == null) {
                    b5 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b5 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b5;
            }
            final LocaleExtensions localeExtensions3 = this.localeExtensions;
            final LocaleExtensions localeExtensions4 = ((Locale)o).localeExtensions;
            BytecodeManager.incBytecodes(6);
            final boolean equals2 = localeExtensions3.equals(localeExtensions4);
            BytecodeManager.incBytecodes(1);
            return equals2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String[] getDisplayVariantArray(final Locale locale) {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(5);
            final String variant = baseLocale.getVariant();
            final String s = "_";
            BytecodeManager.incBytecodes(2);
            final StringTokenizer stringTokenizer = new StringTokenizer(variant, s);
            BytecodeManager.incBytecodes(1);
            final StringTokenizer stringTokenizer2 = stringTokenizer;
            BytecodeManager.incBytecodes(2);
            final String[] array = new String[stringTokenizer2.countTokens()];
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
                final String[] array2 = array;
                final int n3 = n;
                final StringTokenizer stringTokenizer3 = stringTokenizer;
                BytecodeManager.incBytecodes(5);
                final String nextToken = stringTokenizer3.nextToken();
                final int n4 = 2;
                BytecodeManager.incBytecodes(3);
                array2[n3] = this.getDisplayString(nextToken, locale, n4);
                BytecodeManager.incBytecodes(1);
                ++n;
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
    
    private static String formatList(String[] composeList, final String pattern, final String pattern2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (pattern != null) {
                BytecodeManager.incBytecodes(2);
                if (pattern2 != null) {
                    final int length = composeList.length;
                    final int n = 3;
                    BytecodeManager.incBytecodes(4);
                    if (length > n) {
                        BytecodeManager.incBytecodes(4);
                        final MessageFormat messageFormat = new MessageFormat(pattern2);
                        BytecodeManager.incBytecodes(1);
                        final MessageFormat messageFormat2 = messageFormat;
                        final String[] array = composeList;
                        BytecodeManager.incBytecodes(3);
                        composeList = composeList(messageFormat2, array);
                        BytecodeManager.incBytecodes(1);
                    }
                    final Object[] array2 = new Object[composeList.length + 1];
                    BytecodeManager.incBytecodes(5);
                    final String[] array3 = composeList;
                    final int n2 = 0;
                    final Object[] array4 = array2;
                    final int n3 = 1;
                    final int length2 = composeList.length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array3, n2, array4, n3, length2);
                    final Object[] array5 = array2;
                    final int n4 = 0;
                    final int length3 = composeList.length;
                    BytecodeManager.incBytecodes(7);
                    array5[n4] = new Integer(length3);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(4);
                    final MessageFormat messageFormat3 = new MessageFormat(pattern);
                    BytecodeManager.incBytecodes(1);
                    final MessageFormat messageFormat4 = messageFormat3;
                    final Object[] obj = array2;
                    BytecodeManager.incBytecodes(3);
                    final String format = messageFormat4.format(obj);
                    BytecodeManager.incBytecodes(1);
                    return format;
                }
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n5 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                final int length4 = composeList.length;
                BytecodeManager.incBytecodes(4);
                if (n6 >= length4) {
                    break;
                }
                final int n7 = n5;
                BytecodeManager.incBytecodes(2);
                if (n7 > 0) {
                    final StringBuilder sb2 = sb;
                    final char c = ',';
                    BytecodeManager.incBytecodes(3);
                    sb2.append(c);
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuilder sb3 = sb;
                final String str = composeList[n5];
                BytecodeManager.incBytecodes(5);
                sb3.append(str);
                BytecodeManager.incBytecodes(1);
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb4 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb4.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String[] composeList(final MessageFormat messageFormat, final String[] array) {
        try {
            final int length = array.length;
            final int n = 3;
            BytecodeManager.incBytecodes(4);
            if (length <= n) {
                BytecodeManager.incBytecodes(2);
                return array;
            }
            final String[] array2 = { array[0], array[1] };
            BytecodeManager.incBytecodes(14);
            final String[] obj = array2;
            BytecodeManager.incBytecodes(3);
            final String format = messageFormat.format(obj);
            BytecodeManager.incBytecodes(1);
            final String[] array3 = new String[array.length - 1];
            BytecodeManager.incBytecodes(5);
            final int n2 = 2;
            final String[] array4 = array3;
            final int n3 = 1;
            final int n4 = array3.length - 1;
            BytecodeManager.incBytecodes(9);
            System.arraycopy(array, n2, array4, n3, n4);
            array3[0] = format;
            BytecodeManager.incBytecodes(4);
            final String[] array5 = array3;
            BytecodeManager.incBytecodes(3);
            final String[] composeList = composeList(messageFormat, array5);
            BytecodeManager.incBytecodes(1);
            return composeList;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean isUnicodeExtensionKey(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            final int n = 2;
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0050: {
                if (length == n) {
                    BytecodeManager.incBytecodes(2);
                    final boolean alphaNumericString = LocaleUtils.isAlphaNumericString(s);
                    BytecodeManager.incBytecodes(1);
                    if (alphaNumericString) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0050;
                    }
                }
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
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            BytecodeManager.incBytecodes(1);
            final ObjectOutputStream.PutField putField = putFields;
            final String s = "language";
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(5);
            final String language = baseLocale.getLanguage();
            BytecodeManager.incBytecodes(1);
            putField.put(s, language);
            final ObjectOutputStream.PutField putField2 = putFields;
            final String s2 = "script";
            final BaseLocale baseLocale2 = this.baseLocale;
            BytecodeManager.incBytecodes(5);
            final String script = baseLocale2.getScript();
            BytecodeManager.incBytecodes(1);
            putField2.put(s2, script);
            final ObjectOutputStream.PutField putField3 = putFields;
            final String s3 = "country";
            final BaseLocale baseLocale3 = this.baseLocale;
            BytecodeManager.incBytecodes(5);
            final String region = baseLocale3.getRegion();
            BytecodeManager.incBytecodes(1);
            putField3.put(s3, region);
            final ObjectOutputStream.PutField putField4 = putFields;
            final String s4 = "variant";
            final BaseLocale baseLocale4 = this.baseLocale;
            BytecodeManager.incBytecodes(5);
            final String variant = baseLocale4.getVariant();
            BytecodeManager.incBytecodes(1);
            putField4.put(s4, variant);
            final ObjectOutputStream.PutField putField5 = putFields;
            final String s5 = "extensions";
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(5);
            String id;
            if (localeExtensions == null) {
                id = "";
                BytecodeManager.incBytecodes(2);
            }
            else {
                final LocaleExtensions localeExtensions2 = this.localeExtensions;
                BytecodeManager.incBytecodes(3);
                id = localeExtensions2.getID();
            }
            BytecodeManager.incBytecodes(1);
            putField5.put(s5, id);
            final ObjectOutputStream.PutField putField6 = putFields;
            final String s6 = "hashcode";
            final int n = -1;
            BytecodeManager.incBytecodes(4);
            putField6.put(s6, n);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.writeFields();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream p0) throws IOException, ClassNotFoundException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   java/io/ObjectInputStream.readFields:()Ljava/io/ObjectInputStream$GetField;
        //     9: astore_2       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_2        
        //    16: ldc_w           "language"
        //    19: ldc             ""
        //    21: ldc             4
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokevirtual   java/io/ObjectInputStream$GetField.get:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //    29: checkcast       Ljava/lang/String;
        //    32: astore_3       
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: aload_2        
        //    39: ldc_w           "script"
        //    42: ldc             ""
        //    44: ldc             4
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokevirtual   java/io/ObjectInputStream$GetField.get:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //    52: checkcast       Ljava/lang/String;
        //    55: astore          4
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: aload_2        
        //    63: ldc_w           "country"
        //    66: ldc             ""
        //    68: ldc             4
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokevirtual   java/io/ObjectInputStream$GetField.get:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //    76: checkcast       Ljava/lang/String;
        //    79: astore          5
        //    81: ldc             2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: aload_2        
        //    87: ldc_w           "variant"
        //    90: ldc             ""
        //    92: ldc             4
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: invokevirtual   java/io/ObjectInputStream$GetField.get:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //   100: checkcast       Ljava/lang/String;
        //   103: astore          6
        //   105: ldc             2
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: aload_2        
        //   111: ldc_w           "extensions"
        //   114: ldc             ""
        //   116: ldc             4
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: invokevirtual   java/io/ObjectInputStream$GetField.get:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //   124: checkcast       Ljava/lang/String;
        //   127: astore          7
        //   129: ldc             2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: aload_0        
        //   135: aload_3        
        //   136: ldc             3
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: invokestatic    instrumented/java/util/Locale.convertOldISOCodes:(Ljava/lang/String;)Ljava/lang/String;
        //   144: aload           4
        //   146: aload           5
        //   148: aload           6
        //   150: ldc             4
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokestatic    sun/util/locale/BaseLocale.getInstance:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lsun/util/locale/BaseLocale;
        //   158: putfield        instrumented/java/util/Locale.baseLocale:Lsun/util/locale/BaseLocale;
        //   161: ldc             1
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload           7
        //   168: ldc             2
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: invokevirtual   java/lang/String.length:()I
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: ifle            284
        //   184: new             Lsun/util/locale/InternalLocaleBuilder;
        //   187: dup            
        //   188: ldc             3
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokespecial   sun/util/locale/InternalLocaleBuilder.<init>:()V
        //   196: astore          8
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: aload           8
        //   205: aload           7
        //   207: ldc             3
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: invokevirtual   sun/util/locale/InternalLocaleBuilder.setExtensions:(Ljava/lang/String;)Lsun/util/locale/InternalLocaleBuilder;
        //   215: pop            
        //   216: ldc             1
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: aload_0        
        //   222: aload           8
        //   224: ldc             3
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: invokevirtual   sun/util/locale/InternalLocaleBuilder.getLocaleExtensions:()Lsun/util/locale/LocaleExtensions;
        //   232: putfield        instrumented/java/util/Locale.localeExtensions:Lsun/util/locale/LocaleExtensions;
        //   235: ldc             1
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: ldc             1
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: goto            294
        //   248: astore          8
        //   250: ldc_w           501
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: new             Linstrumented/java/util/IllformedLocaleException;
        //   259: dup            
        //   260: aload           8
        //   262: ldc             4
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokevirtual   sun/util/locale/LocaleSyntaxException.getMessage:()Ljava/lang/String;
        //   270: ldc             1
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: invokespecial   instrumented/java/util/IllformedLocaleException.<init>:(Ljava/lang/String;)V
        //   278: ldc             1
        //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   283: athrow         
        //   284: aload_0        
        //   285: aconst_null    
        //   286: putfield        instrumented/java/util/Locale.localeExtensions:Lsun/util/locale/LocaleExtensions;
        //   289: ldc             3
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: ldc             1
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: return         
        //   300: athrow         
        //   301: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.ClassNotFoundException
        //    StackMapTable: 00 05 FF 00 F8 00 08 07 00 02 07 00 0D 07 00 0B 07 00 81 07 00 81 07 00 81 07 00 81 07 00 81 00 01 07 02 C2 23 09 FF 00 05 00 00 00 01 07 00 7E FF 00 00 00 00 00 01 07 00 B8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                   
        //  -----  -----  -----  -----  ---------------------------------------
        //  184    301    301    302    Ljava/lang/VirtualMachineError;
        //  184    240    248    284    Lsun/util/locale/LocaleSyntaxException;
        //  0      300    300    301    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0284:
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
    
    private Object readResolve() throws ObjectStreamException {
        try {
            final BaseLocale baseLocale = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String language = baseLocale.getLanguage();
            final BaseLocale baseLocale2 = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String script = baseLocale2.getScript();
            final BaseLocale baseLocale3 = this.baseLocale;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final String region = baseLocale3.getRegion();
            final BaseLocale baseLocale4 = this.baseLocale;
            BytecodeManager.incBytecodes(3);
            final String variant = baseLocale4.getVariant();
            final LocaleExtensions localeExtensions = this.localeExtensions;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final Locale instance = getInstance(language, script, region, variant, localeExtensions);
            BytecodeManager.incBytecodes(1);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String convertOldISOCodes(String intern) {
        try {
            final String s = intern;
            BytecodeManager.incBytecodes(2);
            final String lowerString = LocaleUtils.toLowerString(s);
            BytecodeManager.incBytecodes(1);
            intern = lowerString.intern();
            BytecodeManager.incBytecodes(1);
            final String s2 = intern;
            final String s3 = "he";
            BytecodeManager.incBytecodes(3);
            if (s2 == s3) {
                final String s4 = "iw";
                BytecodeManager.incBytecodes(2);
                return s4;
            }
            final String s5 = intern;
            final String s6 = "yi";
            BytecodeManager.incBytecodes(3);
            if (s5 == s6) {
                final String s7 = "ji";
                BytecodeManager.incBytecodes(2);
                return s7;
            }
            final String s8 = intern;
            final String s9 = "id";
            BytecodeManager.incBytecodes(3);
            if (s8 == s9) {
                final String s10 = "in";
                BytecodeManager.incBytecodes(2);
                return s10;
            }
            final String s11 = intern;
            BytecodeManager.incBytecodes(2);
            return s11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static LocaleExtensions getCompatibilityExtensions(final String s, final String s2, final String s3, final String s4) {
        try {
            LocaleExtensions localeExtensions = null;
            BytecodeManager.incBytecodes(2);
            final String s5 = "ja";
            BytecodeManager.incBytecodes(3);
            final boolean caseIgnoreMatch = LocaleUtils.caseIgnoreMatch(s, s5);
            BytecodeManager.incBytecodes(1);
            Label_0215: {
                if (caseIgnoreMatch) {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int length = s2.length();
                    BytecodeManager.incBytecodes(1);
                    if (length == 0) {
                        final String s6 = "jp";
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean caseIgnoreMatch2 = LocaleUtils.caseIgnoreMatch(s3, s6);
                        BytecodeManager.incBytecodes(1);
                        if (caseIgnoreMatch2) {
                            final String s7 = "JP";
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean equals = s7.equals(s4);
                            BytecodeManager.incBytecodes(1);
                            if (equals) {
                                localeExtensions = LocaleExtensions.CALENDAR_JAPANESE;
                                BytecodeManager.incBytecodes(3);
                                break Label_0215;
                            }
                        }
                    }
                }
                final String s8 = "th";
                BytecodeManager.incBytecodes(3);
                final boolean caseIgnoreMatch3 = LocaleUtils.caseIgnoreMatch(s, s8);
                BytecodeManager.incBytecodes(1);
                if (caseIgnoreMatch3) {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int length2 = s2.length();
                    BytecodeManager.incBytecodes(1);
                    if (length2 == 0) {
                        final String s9 = "th";
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean caseIgnoreMatch4 = LocaleUtils.caseIgnoreMatch(s3, s9);
                        BytecodeManager.incBytecodes(1);
                        if (caseIgnoreMatch4) {
                            final String s10 = "TH";
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean equals2 = s10.equals(s4);
                            BytecodeManager.incBytecodes(1);
                            if (equals2) {
                                localeExtensions = LocaleExtensions.NUMBER_THAI;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                }
            }
            final LocaleExtensions localeExtensions2 = localeExtensions;
            BytecodeManager.incBytecodes(2);
            return localeExtensions2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static List<Locale> filter(final List<LanguageRange> list, final Collection<Locale> collection, final FilteringMode filteringMode) {
        try {
            BytecodeManager.incBytecodes(4);
            final List filter = LocaleMatcher.filter((List)list, (Collection)collection, filteringMode);
            BytecodeManager.incBytecodes(1);
            return (List<Locale>)filter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static List<Locale> filter(final List<LanguageRange> list, final Collection<Locale> collection) {
        try {
            final FilteringMode autoselect_FILTERING = FilteringMode.AUTOSELECT_FILTERING;
            BytecodeManager.incBytecodes(4);
            final List<Locale> filter = filter(list, collection, autoselect_FILTERING);
            BytecodeManager.incBytecodes(1);
            return filter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static List<String> filterTags(final List<LanguageRange> list, final Collection<String> collection, final FilteringMode filteringMode) {
        try {
            BytecodeManager.incBytecodes(4);
            final List filterTags = LocaleMatcher.filterTags((List)list, (Collection)collection, filteringMode);
            BytecodeManager.incBytecodes(1);
            return (List<String>)filterTags;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static List<String> filterTags(final List<LanguageRange> list, final Collection<String> collection) {
        try {
            final FilteringMode autoselect_FILTERING = FilteringMode.AUTOSELECT_FILTERING;
            BytecodeManager.incBytecodes(4);
            final List<String> filterTags = filterTags(list, collection, autoselect_FILTERING);
            BytecodeManager.incBytecodes(1);
            return filterTags;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Locale lookup(final List<LanguageRange> list, final Collection<Locale> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            final Locale lookup = LocaleMatcher.lookup((List)list, (Collection)collection);
            BytecodeManager.incBytecodes(1);
            return lookup;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String lookupTag(final List<LanguageRange> list, final Collection<String> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            final String lookupTag = LocaleMatcher.lookupTag((List)list, (Collection)collection);
            BytecodeManager.incBytecodes(1);
            return lookupTag;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ BaseLocale access$600(final Locale locale) {
        try {
            final BaseLocale baseLocale = locale.baseLocale;
            BytecodeManager.incBytecodes(3);
            return baseLocale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ LocaleExtensions access$700(final Locale locale) {
        try {
            final LocaleExtensions localeExtensions = locale.localeExtensions;
            BytecodeManager.incBytecodes(3);
            return localeExtensions;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ LocaleExtensions access$800(final String s, final String s2, final String s3, final String s4) {
        try {
            BytecodeManager.incBytecodes(5);
            final LocaleExtensions compatibilityExtensions = getCompatibilityExtensions(s, s2, s3, s4);
            BytecodeManager.incBytecodes(1);
            return compatibilityExtensions;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<Locale> clazz = Locale.class;
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
            final Object object = null;
            BytecodeManager.incBytecodes(4);
            LOCALECACHE = new Cache();
            BytecodeManager.incBytecodes(1);
            final String s = "en";
            final String s2 = "";
            BytecodeManager.incBytecodes(3);
            ENGLISH = createConstant(s, s2);
            BytecodeManager.incBytecodes(1);
            final String s3 = "fr";
            final String s4 = "";
            BytecodeManager.incBytecodes(3);
            FRENCH = createConstant(s3, s4);
            BytecodeManager.incBytecodes(1);
            final String s5 = "de";
            final String s6 = "";
            BytecodeManager.incBytecodes(3);
            GERMAN = createConstant(s5, s6);
            BytecodeManager.incBytecodes(1);
            final String s7 = "it";
            final String s8 = "";
            BytecodeManager.incBytecodes(3);
            ITALIAN = createConstant(s7, s8);
            BytecodeManager.incBytecodes(1);
            final String s9 = "ja";
            final String s10 = "";
            BytecodeManager.incBytecodes(3);
            JAPANESE = createConstant(s9, s10);
            BytecodeManager.incBytecodes(1);
            final String s11 = "ko";
            final String s12 = "";
            BytecodeManager.incBytecodes(3);
            KOREAN = createConstant(s11, s12);
            BytecodeManager.incBytecodes(1);
            final String s13 = "zh";
            final String s14 = "";
            BytecodeManager.incBytecodes(3);
            CHINESE = createConstant(s13, s14);
            BytecodeManager.incBytecodes(1);
            final String s15 = "zh";
            final String s16 = "CN";
            BytecodeManager.incBytecodes(3);
            SIMPLIFIED_CHINESE = createConstant(s15, s16);
            BytecodeManager.incBytecodes(1);
            final String s17 = "zh";
            final String s18 = "TW";
            BytecodeManager.incBytecodes(3);
            TRADITIONAL_CHINESE = createConstant(s17, s18);
            BytecodeManager.incBytecodes(1);
            final String s19 = "fr";
            final String s20 = "FR";
            BytecodeManager.incBytecodes(3);
            FRANCE = createConstant(s19, s20);
            BytecodeManager.incBytecodes(1);
            final String s21 = "de";
            final String s22 = "DE";
            BytecodeManager.incBytecodes(3);
            GERMANY = createConstant(s21, s22);
            BytecodeManager.incBytecodes(1);
            final String s23 = "it";
            final String s24 = "IT";
            BytecodeManager.incBytecodes(3);
            ITALY = createConstant(s23, s24);
            BytecodeManager.incBytecodes(1);
            final String s25 = "ja";
            final String s26 = "JP";
            BytecodeManager.incBytecodes(3);
            JAPAN = createConstant(s25, s26);
            BytecodeManager.incBytecodes(1);
            final String s27 = "ko";
            final String s28 = "KR";
            BytecodeManager.incBytecodes(3);
            KOREA = createConstant(s27, s28);
            BytecodeManager.incBytecodes(1);
            CHINA = Locale.SIMPLIFIED_CHINESE;
            BytecodeManager.incBytecodes(2);
            PRC = Locale.SIMPLIFIED_CHINESE;
            BytecodeManager.incBytecodes(2);
            TAIWAN = Locale.TRADITIONAL_CHINESE;
            BytecodeManager.incBytecodes(2);
            final String s29 = "en";
            final String s30 = "GB";
            BytecodeManager.incBytecodes(3);
            UK = createConstant(s29, s30);
            BytecodeManager.incBytecodes(1);
            final String s31 = "en";
            final String s32 = "US";
            BytecodeManager.incBytecodes(3);
            US = createConstant(s31, s32);
            BytecodeManager.incBytecodes(1);
            final String s33 = "en";
            final String s34 = "CA";
            BytecodeManager.incBytecodes(3);
            CANADA = createConstant(s33, s34);
            BytecodeManager.incBytecodes(1);
            final String s35 = "fr";
            final String s36 = "CA";
            BytecodeManager.incBytecodes(3);
            CANADA_FRENCH = createConstant(s35, s36);
            BytecodeManager.incBytecodes(1);
            final String s37 = "";
            final String s38 = "";
            BytecodeManager.incBytecodes(3);
            ROOT = createConstant(s37, s38);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            Locale.defaultLocale = initDefault();
            BytecodeManager.incBytecodes(1);
            Locale.defaultDisplayLocale = null;
            BytecodeManager.incBytecodes(2);
            Locale.defaultFormatLocale = null;
            BytecodeManager.incBytecodes(2);
            final ObjectStreamField[] serialPersistentFields2 = new ObjectStreamField[6];
            final int n = 0;
            final String name = "language";
            final Class<String> type = String.class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n] = new ObjectStreamField(name, type);
            final int n2 = 1;
            final String name2 = "country";
            final Class<String> type2 = String.class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n2] = new ObjectStreamField(name2, type2);
            final int n3 = 2;
            final String name3 = "variant";
            final Class<String> type3 = String.class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n3] = new ObjectStreamField(name3, type3);
            final int n4 = 3;
            final String name4 = "hashcode";
            final Class<Integer> type4 = Integer.TYPE;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n4] = new ObjectStreamField(name4, type4);
            final int n5 = 4;
            final String name5 = "script";
            final Class<String> type5 = String.class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n5] = new ObjectStreamField(name5, type5);
            final int n6 = 5;
            final String name6 = "extensions";
            final Class<String> type6 = String.class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n6] = new ObjectStreamField(name6, type6);
            serialPersistentFields = serialPersistentFields2;
            BytecodeManager.incBytecodes(2);
            Locale.isoLanguages = null;
            BytecodeManager.incBytecodes(2);
            Locale.isoCountries = null;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class Cache extends LocaleObjectCache<LocaleKey, Locale>
    {
        private Cache() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected Locale createObject(final LocaleKey localeKey) {
            try {
                BytecodeManager.incBytecodes(4);
                final BaseLocale access$200 = LocaleKey.access$200(localeKey);
                BytecodeManager.incBytecodes(2);
                final LocaleExtensions access$201 = LocaleKey.access$300(localeKey);
                final Object object = null;
                BytecodeManager.incBytecodes(2);
                final Locale locale = new Locale(access$200, access$201, object);
                BytecodeManager.incBytecodes(1);
                return locale;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class LocaleKey
    {
        private final BaseLocale base;
        private final LocaleExtensions exts;
        private final int hash;
        
        private LocaleKey(final BaseLocale base, final LocaleExtensions exts) {
            try {
                BytecodeManager.incBytecodes(2);
                this.base = base;
                BytecodeManager.incBytecodes(3);
                this.exts = exts;
                BytecodeManager.incBytecodes(3);
                final BaseLocale base2 = this.base;
                BytecodeManager.incBytecodes(3);
                int hashCode = base2.hashCode();
                BytecodeManager.incBytecodes(1);
                final LocaleExtensions exts2 = this.exts;
                BytecodeManager.incBytecodes(3);
                if (exts2 != null) {
                    final int n = hashCode;
                    final LocaleExtensions exts3 = this.exts;
                    BytecodeManager.incBytecodes(4);
                    hashCode = (n ^ exts3.hashCode());
                    BytecodeManager.incBytecodes(2);
                }
                this.hash = hashCode;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                if (this == o) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = o instanceof LocaleKey;
                BytecodeManager.incBytecodes(3);
                if (!b2) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                final LocaleKey localeKey = (LocaleKey)o;
                BytecodeManager.incBytecodes(3);
                final int hash = this.hash;
                final int hash2 = localeKey.hash;
                BytecodeManager.incBytecodes(5);
                if (hash == hash2) {
                    final BaseLocale base = this.base;
                    final BaseLocale base2 = localeKey.base;
                    BytecodeManager.incBytecodes(5);
                    final boolean equals = base.equals(base2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final LocaleExtensions exts = this.exts;
                        BytecodeManager.incBytecodes(3);
                        if (exts == null) {
                            final LocaleExtensions exts2 = localeKey.exts;
                            BytecodeManager.incBytecodes(3);
                            boolean b4;
                            if (exts2 == null) {
                                b4 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b4 = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            return b4;
                        }
                        final LocaleExtensions exts3 = this.exts;
                        final LocaleExtensions exts4 = localeKey.exts;
                        BytecodeManager.incBytecodes(5);
                        final boolean equals2 = exts3.equals(exts4);
                        BytecodeManager.incBytecodes(1);
                        return equals2;
                    }
                }
                final boolean b5 = false;
                BytecodeManager.incBytecodes(2);
                return b5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final int hash = this.hash;
                BytecodeManager.incBytecodes(3);
                return hash;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ BaseLocale access$200(final LocaleKey localeKey) {
            try {
                final BaseLocale base = localeKey.base;
                BytecodeManager.incBytecodes(3);
                return base;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ LocaleExtensions access$300(final LocaleKey localeKey) {
            try {
                final LocaleExtensions exts = localeKey.exts;
                BytecodeManager.incBytecodes(3);
                return exts;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class LocaleNameGetter implements LocaleServiceProviderPool.LocalizedObjectGetter<LocaleNameProvider, String>
    {
        private static final LocaleNameGetter INSTANCE;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        private LocaleNameGetter() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public String getObject(final LocaleNameProvider localeNameProvider, final Locale locale, final String s, final Object... array) {
            try {
                final boolean $assertionsDisabled = LocaleNameGetter.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final int length = array.length;
                    final int n = 2;
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
                final String s2 = (String)array[1];
                BytecodeManager.incBytecodes(5);
                final int n3 = intValue;
                BytecodeManager.incBytecodes(2);
                switch (n3) {
                    case 0: {
                        final String s3 = s2;
                        BytecodeManager.incBytecodes(4);
                        final String displayLanguage = localeNameProvider.getDisplayLanguage(s3, locale);
                        BytecodeManager.incBytecodes(1);
                        return displayLanguage;
                    }
                    case 1: {
                        final String s4 = s2;
                        BytecodeManager.incBytecodes(4);
                        final String displayCountry = localeNameProvider.getDisplayCountry(s4, locale);
                        BytecodeManager.incBytecodes(1);
                        return displayCountry;
                    }
                    case 2: {
                        final String s5 = s2;
                        BytecodeManager.incBytecodes(4);
                        final String displayVariant = localeNameProvider.getDisplayVariant(s5, locale);
                        BytecodeManager.incBytecodes(1);
                        return displayVariant;
                    }
                    case 3: {
                        final String s6 = s2;
                        BytecodeManager.incBytecodes(4);
                        final String displayScript = localeNameProvider.getDisplayScript(s6, locale);
                        BytecodeManager.incBytecodes(1);
                        return displayScript;
                    }
                    default: {
                        final boolean $assertionsDisabled2 = LocaleNameGetter.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled2) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError2 = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError2;
                        }
                        final String s7 = null;
                        BytecodeManager.incBytecodes(2);
                        return s7;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ LocaleNameGetter access$500() {
            try {
                final LocaleNameGetter instance = LocaleNameGetter.INSTANCE;
                BytecodeManager.incBytecodes(2);
                return instance;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Locale> clazz = Locale.class;
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
                INSTANCE = new LocaleNameGetter();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public enum Category
    {
        DISPLAY(s2, s3, s4, s5), 
        FORMAT(s7, s8, s9, s10);
        
        final String languageKey;
        final String scriptKey;
        final String countryKey;
        final String variantKey;
        
        private Category(final String languageKey, final String scriptKey, final String countryKey, final String variantKey) {
            try {
                BytecodeManager.incBytecodes(4);
                super(name, ordinal);
                this.languageKey = languageKey;
                BytecodeManager.incBytecodes(3);
                this.scriptKey = scriptKey;
                BytecodeManager.incBytecodes(3);
                this.countryKey = countryKey;
                BytecodeManager.incBytecodes(3);
                this.variantKey = variantKey;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String s = "DISPLAY";
                final int n = 0;
                final String s2 = "user.language.display";
                final String s3 = "user.script.display";
                final String s4 = "user.country.display";
                final String s5 = "user.variant.display";
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                final String s6 = "FORMAT";
                final int n2 = 1;
                final String s7 = "user.language.format";
                final String s8 = "user.script.format";
                final String s9 = "user.country.format";
                final String s10 = "user.variant.format";
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(11);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public static final class Builder
    {
        private final InternalLocaleBuilder localeBuilder;
        
        public Builder() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(4);
                this.localeBuilder = new InternalLocaleBuilder();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setLocale(final Locale locale) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(4);
                        final BaseLocale access$600 = Locale.access$600(locale);
                        BytecodeManager.incBytecodes(2);
                        final LocaleExtensions access$601 = Locale.access$700(locale);
                        BytecodeManager.incBytecodes(1);
                        localeBuilder.setLocale(access$600, access$601);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder setLanguageTag(final String languageTag) {
            try {
                BytecodeManager.incBytecodes(3);
                final ParseStatus parseStatus = new ParseStatus();
                BytecodeManager.incBytecodes(1);
                final ParseStatus sts = parseStatus;
                BytecodeManager.incBytecodes(3);
                final LanguageTag parse = LanguageTag.parse(languageTag, sts);
                BytecodeManager.incBytecodes(1);
                final ParseStatus parseStatus2 = parseStatus;
                BytecodeManager.incBytecodes(2);
                final boolean error = parseStatus2.isError();
                BytecodeManager.incBytecodes(1);
                if (error) {
                    final ParseStatus parseStatus3 = parseStatus;
                    BytecodeManager.incBytecodes(4);
                    final String errorMessage = parseStatus3.getErrorMessage();
                    final ParseStatus parseStatus4 = parseStatus;
                    BytecodeManager.incBytecodes(2);
                    final int errorIndex = parseStatus4.getErrorIndex();
                    BytecodeManager.incBytecodes(1);
                    final IllformedLocaleException ex = new IllformedLocaleException(errorMessage, errorIndex);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                final LanguageTag languageTag2 = parse;
                BytecodeManager.incBytecodes(4);
                localeBuilder.setLanguageTag(languageTag2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setLanguage(final String language) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(4);
                        localeBuilder.setLanguage(language);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder setScript(final String script) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(4);
                        localeBuilder.setScript(script);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder setRegion(final String region) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(4);
                        localeBuilder.setRegion(region);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder setVariant(final String variant) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(4);
                        localeBuilder.setVariant(variant);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder setExtension(final char singleton, final String value) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(5);
                        localeBuilder.setExtension(singleton, value);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder setUnicodeLocaleKeyword(final String key, final String type) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(5);
                        localeBuilder.setUnicodeLocaleKeyword(key, type);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder addUnicodeLocaleAttribute(final String attribute) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(4);
                        localeBuilder.addUnicodeLocaleAttribute(attribute);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder removeUnicodeLocaleAttribute(final String attribute) {
            try {
                try {
                    try {
                        final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                        BytecodeManager.incBytecodes(4);
                        localeBuilder.removeUnicodeLocaleAttribute(attribute);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (LocaleSyntaxException ex2) {
                        BytecodeManager.incBytecodes(501);
                        final LocaleSyntaxException ex = ex2;
                        BytecodeManager.incBytecodes(4);
                        final String message = ex.getMessage();
                        final LocaleSyntaxException ex3 = ex2;
                        BytecodeManager.incBytecodes(2);
                        final int errorIndex = ex3.getErrorIndex();
                        BytecodeManager.incBytecodes(1);
                        final IllformedLocaleException ex4 = new IllformedLocaleException(message, errorIndex);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public Builder clear() {
            try {
                final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                BytecodeManager.incBytecodes(3);
                localeBuilder.clear();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder clearExtensions() {
            try {
                final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                BytecodeManager.incBytecodes(3);
                localeBuilder.clearExtensions();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Locale build() {
            try {
                final InternalLocaleBuilder localeBuilder = this.localeBuilder;
                BytecodeManager.incBytecodes(3);
                final BaseLocale baseLocale = localeBuilder.getBaseLocale();
                BytecodeManager.incBytecodes(1);
                final InternalLocaleBuilder localeBuilder2 = this.localeBuilder;
                BytecodeManager.incBytecodes(3);
                LocaleExtensions localeExtensions = localeBuilder2.getLocaleExtensions();
                BytecodeManager.incBytecodes(1);
                final LocaleExtensions localeExtensions2 = localeExtensions;
                BytecodeManager.incBytecodes(2);
                if (localeExtensions2 == null) {
                    final BaseLocale baseLocale2 = baseLocale;
                    BytecodeManager.incBytecodes(2);
                    final String variant = baseLocale2.getVariant();
                    BytecodeManager.incBytecodes(1);
                    final int length = variant.length();
                    BytecodeManager.incBytecodes(1);
                    if (length > 0) {
                        final BaseLocale baseLocale3 = baseLocale;
                        BytecodeManager.incBytecodes(2);
                        final String language = baseLocale3.getLanguage();
                        final BaseLocale baseLocale4 = baseLocale;
                        BytecodeManager.incBytecodes(2);
                        final String script = baseLocale4.getScript();
                        final BaseLocale baseLocale5 = baseLocale;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final String region = baseLocale5.getRegion();
                        final BaseLocale baseLocale6 = baseLocale;
                        BytecodeManager.incBytecodes(2);
                        final String variant2 = baseLocale6.getVariant();
                        BytecodeManager.incBytecodes(1);
                        localeExtensions = Locale.access$800(language, script, region, variant2);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final BaseLocale baseLocale7 = baseLocale;
                final LocaleExtensions localeExtensions3 = localeExtensions;
                BytecodeManager.incBytecodes(3);
                final Locale instance = Locale.getInstance(baseLocale7, localeExtensions3);
                BytecodeManager.incBytecodes(1);
                return instance;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public enum FilteringMode
    {
        AUTOSELECT_FILTERING, 
        EXTENDED_FILTERING, 
        IGNORE_EXTENDED_RANGES, 
        MAP_EXTENDED_RANGES, 
        REJECT_EXTENDED_RANGES;
        
        private FilteringMode() {
            try {
                BytecodeManager.incBytecodes(4);
                super(name, ordinal);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String s = "AUTOSELECT_FILTERING";
                final int n = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s2 = "EXTENDED_FILTERING";
                final int n2 = 1;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s3 = "IGNORE_EXTENDED_RANGES";
                final int n3 = 2;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s4 = "MAP_EXTENDED_RANGES";
                final int n4 = 3;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s5 = "REJECT_EXTENDED_RANGES";
                final int n5 = 4;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(23);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public static final class LanguageRange
    {
        public static final double MAX_WEIGHT = 1.0;
        public static final double MIN_WEIGHT = 0.0;
        private final String range;
        private final double weight;
        private volatile int hash;
        
        public LanguageRange(final String s) {
            try {
                final double n = 1.0;
                BytecodeManager.incBytecodes(4);
                this(s, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public LanguageRange(String lowerCase, final double n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.hash = 0;
                BytecodeManager.incBytecodes(3);
                final String s = lowerCase;
                BytecodeManager.incBytecodes(2);
                if (s == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final double n2 = dcmpg(n, 0.0);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final double n3 = dcmpl(n, 1.0);
                    BytecodeManager.incBytecodes(4);
                    if (n3 <= 0) {
                        final String s2 = lowerCase;
                        BytecodeManager.incBytecodes(2);
                        lowerCase = s2.toLowerCase();
                        BytecodeManager.incBytecodes(1);
                        int n4 = 0;
                        BytecodeManager.incBytecodes(2);
                        final String s3 = lowerCase;
                        final String regex = "-";
                        BytecodeManager.incBytecodes(3);
                        final String[] split = s3.split(regex);
                        BytecodeManager.incBytecodes(1);
                        final String s4 = split[0];
                        final boolean b = true;
                        BytecodeManager.incBytecodes(5);
                        final boolean subtagIllFormed = isSubtagIllFormed(s4, b);
                        BytecodeManager.incBytecodes(1);
                        Label_0292: {
                            if (!subtagIllFormed) {
                                final String s5 = lowerCase;
                                final String suffix = "-";
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final boolean endsWith = s5.endsWith(suffix);
                                BytecodeManager.incBytecodes(1);
                                if (!endsWith) {
                                    int n5 = 1;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final int n6 = n5;
                                        final int length = split.length;
                                        BytecodeManager.incBytecodes(4);
                                        if (n6 >= length) {
                                            break Label_0292;
                                        }
                                        final String s6 = split[n5];
                                        final boolean b2 = false;
                                        BytecodeManager.incBytecodes(5);
                                        final boolean subtagIllFormed2 = isSubtagIllFormed(s6, b2);
                                        BytecodeManager.incBytecodes(1);
                                        if (subtagIllFormed2) {
                                            n4 = 1;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            break Label_0292;
                                        }
                                        ++n5;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                }
                            }
                            n4 = 1;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n7 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n7 != 0) {
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb = new StringBuilder();
                            final String str = "range=";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb.append(str);
                            final String str2 = lowerCase;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append2 = append.append(str2);
                            BytecodeManager.incBytecodes(1);
                            final String string = append2.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalArgumentException ex2 = new IllegalArgumentException(string);
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        this.range = lowerCase;
                        BytecodeManager.incBytecodes(3);
                        this.weight = n;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str3 = "weight=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str3);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(n);
                BytecodeManager.incBytecodes(1);
                final String string2 = append4.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex3 = new IllegalArgumentException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static boolean isSubtagIllFormed(final String s, final boolean b) {
            try {
                final String anObject = "";
                BytecodeManager.incBytecodes(3);
                final boolean equals = s.equals(anObject);
                BytecodeManager.incBytecodes(1);
                if (!equals) {
                    BytecodeManager.incBytecodes(2);
                    final int length = s.length();
                    final int n = 8;
                    BytecodeManager.incBytecodes(2);
                    if (length <= n) {
                        final String anObject2 = "*";
                        BytecodeManager.incBytecodes(3);
                        final boolean equals2 = s.equals(anObject2);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        BytecodeManager.incBytecodes(2);
                        final char[] charArray = s.toCharArray();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        Label_0285: {
                            if (!b) {
                                final char[] array = charArray;
                                final int length2 = array.length;
                                int n2 = 0;
                                BytecodeManager.incBytecodes(7);
                                while (true) {
                                    final int n3 = n2;
                                    final int n4 = length2;
                                    BytecodeManager.incBytecodes(3);
                                    if (n3 >= n4) {
                                        break Label_0285;
                                    }
                                    final char c = array[n2];
                                    BytecodeManager.incBytecodes(4);
                                    final char c2 = c;
                                    final int n5 = '0';
                                    BytecodeManager.incBytecodes(3);
                                    if (c2 < n5) {
                                        break;
                                    }
                                    final char c3 = c;
                                    final int n6 = '9';
                                    BytecodeManager.incBytecodes(3);
                                    if (c3 > n6) {
                                        final char c4 = c;
                                        final int n7 = 'a';
                                        BytecodeManager.incBytecodes(3);
                                        if (c4 < n7) {
                                            break;
                                        }
                                    }
                                    final char c5 = c;
                                    final int n8 = 'z';
                                    BytecodeManager.incBytecodes(3);
                                    if (c5 > n8) {
                                        break;
                                    }
                                    ++n2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final boolean b3 = true;
                                BytecodeManager.incBytecodes(2);
                                return b3;
                            }
                            final char[] array2 = charArray;
                            final int length3 = array2.length;
                            int n9 = 0;
                            BytecodeManager.incBytecodes(7);
                            Label_0174: {
                                while (true) {
                                    final int n10 = n9;
                                    final int n11 = length3;
                                    BytecodeManager.incBytecodes(3);
                                    if (n10 >= n11) {
                                        break Label_0174;
                                    }
                                    final char c6 = array2[n9];
                                    BytecodeManager.incBytecodes(4);
                                    final char c7 = c6;
                                    final int n12 = 'a';
                                    BytecodeManager.incBytecodes(3);
                                    if (c7 < n12) {
                                        break;
                                    }
                                    final char c8 = c6;
                                    final int n13 = 'z';
                                    BytecodeManager.incBytecodes(3);
                                    if (c8 > n13) {
                                        break;
                                    }
                                    ++n9;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final boolean b4 = true;
                                BytecodeManager.incBytecodes(2);
                                return b4;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean b5 = false;
                        BytecodeManager.incBytecodes(2);
                        return b5;
                    }
                }
                final boolean b6 = true;
                BytecodeManager.incBytecodes(2);
                return b6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public String getRange() {
            try {
                final String range = this.range;
                BytecodeManager.incBytecodes(3);
                return range;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public double getWeight() {
            try {
                final double weight = this.weight;
                BytecodeManager.incBytecodes(3);
                return weight;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static List<LanguageRange> parse(final String s) {
            try {
                BytecodeManager.incBytecodes(2);
                final List parse = LocaleMatcher.parse(s);
                BytecodeManager.incBytecodes(1);
                return (List<LanguageRange>)parse;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static List<LanguageRange> parse(final String s, final Map<String, List<String>> map) {
            try {
                BytecodeManager.incBytecodes(2);
                final List<LanguageRange> parse = parse(s);
                BytecodeManager.incBytecodes(2);
                final List<LanguageRange> mapEquivalents = mapEquivalents(parse, map);
                BytecodeManager.incBytecodes(1);
                return mapEquivalents;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static List<LanguageRange> mapEquivalents(final List<LanguageRange> list, final Map<String, List<String>> map) {
            try {
                BytecodeManager.incBytecodes(3);
                final List mapEquivalents = LocaleMatcher.mapEquivalents((List)list, (Map)map);
                BytecodeManager.incBytecodes(1);
                return (List<LanguageRange>)mapEquivalents;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final int hash = this.hash;
                BytecodeManager.incBytecodes(3);
                if (hash == 0) {
                    final int n = 17;
                    BytecodeManager.incBytecodes(2);
                    final int n2 = 37 * n;
                    final String range = this.range;
                    BytecodeManager.incBytecodes(6);
                    final int n3 = n2 + range.hashCode();
                    BytecodeManager.incBytecodes(2);
                    final double weight = this.weight;
                    BytecodeManager.incBytecodes(3);
                    final long doubleToLongBits = Double.doubleToLongBits(weight);
                    BytecodeManager.incBytecodes(1);
                    final int hash2 = 37 * n3 + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
                    BytecodeManager.incBytecodes(11);
                    this.hash = hash2;
                    BytecodeManager.incBytecodes(3);
                }
                final int hash3 = this.hash;
                BytecodeManager.incBytecodes(3);
                return hash3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                if (this == o) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = o instanceof LanguageRange;
                BytecodeManager.incBytecodes(3);
                if (!b2) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                final LanguageRange languageRange = (LanguageRange)o;
                BytecodeManager.incBytecodes(3);
                final int hash = this.hash;
                final int hash2 = languageRange.hash;
                BytecodeManager.incBytecodes(5);
                boolean b4 = false;
                Label_0123: {
                    if (hash == hash2) {
                        final String range = this.range;
                        final String range2 = languageRange.range;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final boolean equals = range.equals(range2);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            final double n = dcmpl(this.weight, languageRange.weight);
                            BytecodeManager.incBytecodes(6);
                            if (n == 0) {
                                b4 = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0123;
                            }
                        }
                    }
                    b4 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
