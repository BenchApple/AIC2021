// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.security.Permission;
import java.security.AccessControlContext;
import sun.util.BuddhistCalendar;
import instrumented.java.util.concurrent.ConcurrentHashMap;
import java.time.Instant;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import sun.util.locale.provider.CalendarDataUtility;
import java.text.DateFormatSymbols;
import sun.util.calendar.ZoneInfo;
import java.text.DateFormat;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.concurrent.ConcurrentMap;
import java.io.Serializable;

public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar>
{
    public static final int ERA = 0;
    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int WEEK_OF_YEAR = 3;
    public static final int WEEK_OF_MONTH = 4;
    public static final int DATE = 5;
    public static final int DAY_OF_MONTH = 5;
    public static final int DAY_OF_YEAR = 6;
    public static final int DAY_OF_WEEK = 7;
    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    public static final int AM_PM = 9;
    public static final int HOUR = 10;
    public static final int HOUR_OF_DAY = 11;
    public static final int MINUTE = 12;
    public static final int SECOND = 13;
    public static final int MILLISECOND = 14;
    public static final int ZONE_OFFSET = 15;
    public static final int DST_OFFSET = 16;
    public static final int FIELD_COUNT = 17;
    public static final int SUNDAY = 1;
    public static final int MONDAY = 2;
    public static final int TUESDAY = 3;
    public static final int WEDNESDAY = 4;
    public static final int THURSDAY = 5;
    public static final int FRIDAY = 6;
    public static final int SATURDAY = 7;
    public static final int JANUARY = 0;
    public static final int FEBRUARY = 1;
    public static final int MARCH = 2;
    public static final int APRIL = 3;
    public static final int MAY = 4;
    public static final int JUNE = 5;
    public static final int JULY = 6;
    public static final int AUGUST = 7;
    public static final int SEPTEMBER = 8;
    public static final int OCTOBER = 9;
    public static final int NOVEMBER = 10;
    public static final int DECEMBER = 11;
    public static final int UNDECIMBER = 12;
    public static final int AM = 0;
    public static final int PM = 1;
    public static final int ALL_STYLES = 0;
    static final int STANDALONE_MASK = 32768;
    public static final int SHORT = 1;
    public static final int LONG = 2;
    public static final int NARROW_FORMAT = 4;
    public static final int NARROW_STANDALONE = 32772;
    public static final int SHORT_FORMAT = 1;
    public static final int LONG_FORMAT = 2;
    public static final int SHORT_STANDALONE = 32769;
    public static final int LONG_STANDALONE = 32770;
    protected int[] fields;
    protected boolean[] isSet;
    private transient int[] stamp;
    protected long time;
    protected boolean isTimeSet;
    protected boolean areFieldsSet;
    transient boolean areAllFieldsSet;
    private boolean lenient;
    private TimeZone zone;
    private transient boolean sharedZone;
    private int firstDayOfWeek;
    private int minimalDaysInFirstWeek;
    private static final ConcurrentMap<Locale, int[]> cachedLocaleData;
    private static final int UNSET = 0;
    private static final int COMPUTED = 1;
    private static final int MINIMUM_USER_STAMP = 2;
    static final int ALL_FIELDS = 131071;
    private int nextStamp;
    static final int currentSerialVersion = 1;
    private int serialVersionOnStream;
    static final long serialVersionUID = -1807547505821590642L;
    static final int ERA_MASK = 1;
    static final int YEAR_MASK = 2;
    static final int MONTH_MASK = 4;
    static final int WEEK_OF_YEAR_MASK = 8;
    static final int WEEK_OF_MONTH_MASK = 16;
    static final int DAY_OF_MONTH_MASK = 32;
    static final int DATE_MASK = 32;
    static final int DAY_OF_YEAR_MASK = 64;
    static final int DAY_OF_WEEK_MASK = 128;
    static final int DAY_OF_WEEK_IN_MONTH_MASK = 256;
    static final int AM_PM_MASK = 512;
    static final int HOUR_MASK = 1024;
    static final int HOUR_OF_DAY_MASK = 2048;
    static final int MINUTE_MASK = 4096;
    static final int SECOND_MASK = 8192;
    static final int MILLISECOND_MASK = 16384;
    static final int ZONE_OFFSET_MASK = 32768;
    static final int DST_OFFSET_MASK = 65536;
    private static final String[] FIELD_NAME;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    protected Calendar() {
        try {
            BytecodeManager.incBytecodes(2);
            final TimeZone defaultRef = TimeZone.getDefaultRef();
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(2);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this(defaultRef, default1);
            this.sharedZone = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected Calendar(final TimeZone zone, final Locale weekCountData) {
        try {
            BytecodeManager.incBytecodes(2);
            this.lenient = true;
            BytecodeManager.incBytecodes(3);
            this.sharedZone = false;
            BytecodeManager.incBytecodes(3);
            this.nextStamp = 2;
            BytecodeManager.incBytecodes(3);
            this.serialVersionOnStream = 1;
            BytecodeManager.incBytecodes(3);
            this.fields = new int[17];
            BytecodeManager.incBytecodes(3);
            this.isSet = new boolean[17];
            BytecodeManager.incBytecodes(3);
            this.stamp = new int[17];
            BytecodeManager.incBytecodes(3);
            this.zone = zone;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.setWeekCountData(weekCountData);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Calendar getInstance() {
        try {
            BytecodeManager.incBytecodes(1);
            final TimeZone default1 = TimeZone.getDefault();
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(2);
            final Locale default2 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            final Calendar calendar = createCalendar(default1, default2);
            BytecodeManager.incBytecodes(1);
            return calendar;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Calendar getInstance(final TimeZone timeZone) {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            final Calendar calendar = createCalendar(timeZone, default1);
            BytecodeManager.incBytecodes(1);
            return calendar;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Calendar getInstance(final Locale locale) {
        try {
            BytecodeManager.incBytecodes(1);
            final TimeZone default1 = TimeZone.getDefault();
            BytecodeManager.incBytecodes(2);
            final Calendar calendar = createCalendar(default1, locale);
            BytecodeManager.incBytecodes(1);
            return calendar;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Calendar getInstance(final TimeZone timeZone, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(3);
            final Calendar calendar = createCalendar(timeZone, locale);
            BytecodeManager.incBytecodes(1);
            return calendar;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Calendar createCalendar(final TimeZone p0, final Locale p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: aload_1        
        //     3: ldc             2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: ldc             1
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: invokestatic    sun/util/locale/provider/LocaleProviderAdapter.getAdapter:(Ljava/lang/Class;Linstrumented/java/util/Locale;)Lsun/util/locale/provider/LocaleProviderAdapter;
        //    16: ldc             1
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokevirtual   sun/util/locale/provider/LocaleProviderAdapter.getCalendarProvider:()Lsun/util/spi/CalendarProvider;
        //    24: astore_2       
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_2        
        //    31: ldc             2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: ifnull          62
        //    39: aload_2        
        //    40: aload_0        
        //    41: aload_1        
        //    42: ldc             4
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   sun/util/spi/CalendarProvider.getInstance:(Linstrumented/java/util/TimeZone;Linstrumented/java/util/Locale;)Linstrumented/java/util/Calendar;
        //    50: ldc             1
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: areturn        
        //    56: astore_3       
        //    57: ldc             501
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: aconst_null    
        //    63: astore_3       
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: aload_1        
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokevirtual   instrumented/java/util/Locale.hasExtensions:()Z
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifeq            376
        //    86: aload_1        
        //    87: ldc             "ca"
        //    89: ldc             3
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/Locale.getUnicodeLocaleType:(Ljava/lang/String;)Ljava/lang/String;
        //    97: astore          4
        //    99: ldc             1
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: aload           4
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: ifnull          376
        //   114: aload           4
        //   116: astore          5
        //   118: iconst_m1      
        //   119: istore          6
        //   121: aload           5
        //   123: ldc             6
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: invokevirtual   java/lang/String.hashCode:()I
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: lookupswitch {
        //          -1581060683: 172
        //          -752730191: 204
        //          283776265: 236
        //          default: 265
        //        }
        //   172: aload           5
        //   174: ldc_w           "buddhist"
        //   177: ldc             3
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   185: ldc             1
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: ifeq            265
        //   193: iconst_0       
        //   194: istore          6
        //   196: ldc             3
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: goto            265
        //   204: aload           5
        //   206: ldc_w           "japanese"
        //   209: ldc             3
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: ifeq            265
        //   225: iconst_1       
        //   226: istore          6
        //   228: ldc             3
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: goto            265
        //   236: aload           5
        //   238: ldc_w           "gregory"
        //   241: ldc             3
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   249: ldc             1
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: ifeq            265
        //   257: iconst_2       
        //   258: istore          6
        //   260: ldc             2
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: iload           6
        //   267: ldc             2
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: tableswitch {
        //                0: 300
        //                1: 328
        //                2: 356
        //          default: 376
        //        }
        //   300: new             Lsun/util/BuddhistCalendar;
        //   303: dup            
        //   304: aload_0        
        //   305: aload_1        
        //   306: ldc             5
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: invokespecial   sun/util/BuddhistCalendar.<init>:(Linstrumented/java/util/TimeZone;Linstrumented/java/util/Locale;)V
        //   314: astore_3       
        //   315: ldc             1
        //   317: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   320: ldc             1
        //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   325: goto            376
        //   328: new             Linstrumented/java/util/JapaneseImperialCalendar;
        //   331: dup            
        //   332: aload_0        
        //   333: aload_1        
        //   334: ldc             5
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: invokespecial   instrumented/java/util/JapaneseImperialCalendar.<init>:(Linstrumented/java/util/TimeZone;Linstrumented/java/util/Locale;)V
        //   342: astore_3       
        //   343: ldc             1
        //   345: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   348: ldc             1
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: goto            376
        //   356: new             Linstrumented/java/util/GregorianCalendar;
        //   359: dup            
        //   360: aload_0        
        //   361: aload_1        
        //   362: ldc             5
        //   364: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   367: invokespecial   instrumented/java/util/GregorianCalendar.<init>:(Linstrumented/java/util/TimeZone;Linstrumented/java/util/Locale;)V
        //   370: astore_3       
        //   371: ldc             1
        //   373: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   376: aload_3        
        //   377: ldc             2
        //   379: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   382: ifnonnull       556
        //   385: aload_1        
        //   386: ldc             2
        //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   391: invokevirtual   instrumented/java/util/Locale.getLanguage:()Ljava/lang/String;
        //   394: ldc_w           "th"
        //   397: ldc             2
        //   399: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   402: if_acmpne       448
        //   405: aload_1        
        //   406: ldc             2
        //   408: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   411: invokevirtual   instrumented/java/util/Locale.getCountry:()Ljava/lang/String;
        //   414: ldc_w           "TH"
        //   417: ldc             2
        //   419: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   422: if_acmpne       448
        //   425: new             Lsun/util/BuddhistCalendar;
        //   428: dup            
        //   429: aload_0        
        //   430: aload_1        
        //   431: ldc             5
        //   433: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   436: invokespecial   sun/util/BuddhistCalendar.<init>:(Linstrumented/java/util/TimeZone;Linstrumented/java/util/Locale;)V
        //   439: astore_3       
        //   440: ldc             2
        //   442: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   445: goto            556
        //   448: aload_1        
        //   449: ldc             2
        //   451: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   454: invokevirtual   instrumented/java/util/Locale.getVariant:()Ljava/lang/String;
        //   457: ldc_w           "JP"
        //   460: ldc             2
        //   462: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   465: if_acmpne       536
        //   468: aload_1        
        //   469: ldc             2
        //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   474: invokevirtual   instrumented/java/util/Locale.getLanguage:()Ljava/lang/String;
        //   477: ldc_w           "ja"
        //   480: ldc             2
        //   482: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   485: if_acmpne       536
        //   488: aload_1        
        //   489: ldc             1
        //   491: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   494: ldc             1
        //   496: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   499: invokevirtual   instrumented/java/util/Locale.getCountry:()Ljava/lang/String;
        //   502: ldc_w           "JP"
        //   505: ldc             2
        //   507: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   510: if_acmpne       536
        //   513: new             Linstrumented/java/util/JapaneseImperialCalendar;
        //   516: dup            
        //   517: aload_0        
        //   518: aload_1        
        //   519: ldc             5
        //   521: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   524: invokespecial   instrumented/java/util/JapaneseImperialCalendar.<init>:(Linstrumented/java/util/TimeZone;Linstrumented/java/util/Locale;)V
        //   527: astore_3       
        //   528: ldc             2
        //   530: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   533: goto            556
        //   536: new             Linstrumented/java/util/GregorianCalendar;
        //   539: dup            
        //   540: aload_0        
        //   541: aload_1        
        //   542: ldc             5
        //   544: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   547: invokespecial   instrumented/java/util/GregorianCalendar.<init>:(Linstrumented/java/util/TimeZone;Linstrumented/java/util/Locale;)V
        //   550: astore_3       
        //   551: ldc             1
        //   553: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   556: aload_3        
        //   557: ldc             2
        //   559: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   562: areturn        
        //   563: athrow         
        //   564: athrow         
        //    StackMapTable: 00 0F FF 00 38 00 03 07 00 AF 07 00 1B 07 00 E6 00 01 07 00 E4 05 FF 00 6D 00 07 07 00 AF 07 00 1B 07 00 E6 07 00 02 07 00 FF 07 00 FF 01 00 00 1F 1F 1C 22 1B 1B F8 00 13 FB 00 47 FB 00 57 13 FF 00 06 00 00 00 01 07 00 C2 FF 00 00 00 00 00 01 07 00 E2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  39     564    564    565    Ljava/lang/VirtualMachineError;
        //  39     50     56     62     Ljava/lang/IllegalArgumentException;
        //  0      563    563    564    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0062:
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
    
    public static synchronized Locale[] getAvailableLocales() {
        try {
            BytecodeManager.incBytecodes(1);
            final Locale[] availableLocales = DateFormat.getAvailableLocales();
            BytecodeManager.incBytecodes(1);
            return availableLocales;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected abstract void computeTime();
    
    protected abstract void computeFields();
    
    public final Date getTime() {
        try {
            BytecodeManager.incBytecodes(4);
            final long timeInMillis = this.getTimeInMillis();
            BytecodeManager.incBytecodes(1);
            final Date date = new Date(timeInMillis);
            BytecodeManager.incBytecodes(1);
            return date;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void setTime(final Date date) {
        try {
            BytecodeManager.incBytecodes(3);
            final long time = date.getTime();
            BytecodeManager.incBytecodes(1);
            this.setTimeInMillis(time);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getTimeInMillis() {
        try {
            final boolean isTimeSet = this.isTimeSet;
            BytecodeManager.incBytecodes(3);
            if (!isTimeSet) {
                BytecodeManager.incBytecodes(2);
                this.updateTime();
            }
            final long time = this.time;
            BytecodeManager.incBytecodes(3);
            return time;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setTimeInMillis(final long time) {
        try {
            final long n = lcmp(this.time, time);
            BytecodeManager.incBytecodes(5);
            if (n == 0) {
                final boolean isTimeSet = this.isTimeSet;
                BytecodeManager.incBytecodes(3);
                if (isTimeSet) {
                    final boolean areFieldsSet = this.areFieldsSet;
                    BytecodeManager.incBytecodes(3);
                    if (areFieldsSet) {
                        final boolean areAllFieldsSet = this.areAllFieldsSet;
                        BytecodeManager.incBytecodes(3);
                        if (areAllFieldsSet) {
                            final boolean b = this.zone instanceof ZoneInfo;
                            BytecodeManager.incBytecodes(4);
                            if (b) {
                                final ZoneInfo zoneInfo = (ZoneInfo)this.zone;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final boolean dirty = zoneInfo.isDirty();
                                BytecodeManager.incBytecodes(1);
                                if (!dirty) {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            this.time = time;
            BytecodeManager.incBytecodes(3);
            this.isTimeSet = true;
            BytecodeManager.incBytecodes(3);
            this.areFieldsSet = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.computeFields();
            final boolean b2 = true;
            this.areFieldsSet = b2;
            this.areAllFieldsSet = b2;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int get(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.complete();
            BytecodeManager.incBytecodes(3);
            final int internalGet = this.internalGet(n);
            BytecodeManager.incBytecodes(1);
            return internalGet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected final int internalGet(final int n) {
        try {
            final int n2 = this.fields[n];
            BytecodeManager.incBytecodes(5);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void internalSet(final int n, final int n2) {
        try {
            this.fields[n] = n2;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void set(final int n, final int n2) {
        try {
            final boolean areFieldsSet = this.areFieldsSet;
            BytecodeManager.incBytecodes(3);
            if (areFieldsSet) {
                final boolean areAllFieldsSet = this.areAllFieldsSet;
                BytecodeManager.incBytecodes(3);
                if (!areAllFieldsSet) {
                    BytecodeManager.incBytecodes(2);
                    this.computeFields();
                }
            }
            BytecodeManager.incBytecodes(4);
            this.internalSet(n, n2);
            this.isTimeSet = false;
            BytecodeManager.incBytecodes(3);
            this.areFieldsSet = false;
            BytecodeManager.incBytecodes(3);
            this.isSet[n] = true;
            BytecodeManager.incBytecodes(5);
            this.stamp[n] = this.nextStamp++;
            BytecodeManager.incBytecodes(11);
            final int nextStamp = this.nextStamp;
            final int n3 = Integer.MAX_VALUE;
            BytecodeManager.incBytecodes(4);
            if (nextStamp == n3) {
                BytecodeManager.incBytecodes(2);
                this.adjustStamp();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final int n, final int n2, final int n3) {
        try {
            final int n4 = 1;
            BytecodeManager.incBytecodes(4);
            this.set(n4, n);
            final int n5 = 2;
            BytecodeManager.incBytecodes(4);
            this.set(n5, n2);
            final int n6 = 5;
            BytecodeManager.incBytecodes(4);
            this.set(n6, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final int n, final int n2, final int n3, final int n4, final int n5) {
        try {
            final int n6 = 1;
            BytecodeManager.incBytecodes(4);
            this.set(n6, n);
            final int n7 = 2;
            BytecodeManager.incBytecodes(4);
            this.set(n7, n2);
            final int n8 = 5;
            BytecodeManager.incBytecodes(4);
            this.set(n8, n3);
            final int n9 = 11;
            BytecodeManager.incBytecodes(4);
            this.set(n9, n4);
            final int n10 = 12;
            BytecodeManager.incBytecodes(4);
            this.set(n10, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        try {
            final int n7 = 1;
            BytecodeManager.incBytecodes(4);
            this.set(n7, n);
            final int n8 = 2;
            BytecodeManager.incBytecodes(4);
            this.set(n8, n2);
            final int n9 = 5;
            BytecodeManager.incBytecodes(4);
            this.set(n9, n3);
            final int n10 = 11;
            BytecodeManager.incBytecodes(4);
            this.set(n10, n4);
            final int n11 = 12;
            BytecodeManager.incBytecodes(4);
            this.set(n11, n5);
            final int n12 = 13;
            BytecodeManager.incBytecodes(4);
            this.set(n12, n6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void clear() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.fields.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    break;
                }
                this.stamp[n] = (this.fields[n] = 0);
                BytecodeManager.incBytecodes(10);
                this.isSet[n++] = false;
                BytecodeManager.incBytecodes(7);
            }
            final boolean b = false;
            this.areFieldsSet = b;
            this.areAllFieldsSet = b;
            BytecodeManager.incBytecodes(6);
            this.isTimeSet = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void clear(final int n) {
        try {
            this.fields[n] = 0;
            BytecodeManager.incBytecodes(5);
            this.stamp[n] = 0;
            BytecodeManager.incBytecodes(5);
            this.isSet[n] = false;
            BytecodeManager.incBytecodes(5);
            final boolean b = false;
            this.areFieldsSet = b;
            this.areAllFieldsSet = b;
            BytecodeManager.incBytecodes(6);
            this.isTimeSet = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean isSet(final int n) {
        try {
            final int n2 = this.stamp[n];
            BytecodeManager.incBytecodes(5);
            boolean b;
            if (n2 != 0) {
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
    
    public String getDisplayName(final int n, final int n2, final Locale locale) {
        try {
            final int n3 = 1;
            final int n4 = 4;
            final int n5 = 645;
            BytecodeManager.incBytecodes(8);
            final boolean checkDisplayNameParams = this.checkDisplayNameParams(n, n2, n3, n4, locale, n5);
            BytecodeManager.incBytecodes(1);
            if (!checkDisplayNameParams) {
                final String s = null;
                BytecodeManager.incBytecodes(2);
                return s;
            }
            BytecodeManager.incBytecodes(2);
            final String calendarType = this.getCalendarType();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final int value = this.get(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final boolean standaloneStyle = this.isStandaloneStyle(n2);
            BytecodeManager.incBytecodes(1);
            if (!standaloneStyle) {
                BytecodeManager.incBytecodes(3);
                final boolean narrowFormatStyle = this.isNarrowFormatStyle(n2);
                BytecodeManager.incBytecodes(1);
                if (!narrowFormatStyle) {
                    BytecodeManager.incBytecodes(2);
                    final DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
                    BytecodeManager.incBytecodes(1);
                    final DateFormatSymbols dateFormatSymbols = instance;
                    BytecodeManager.incBytecodes(5);
                    final String[] fieldStrings = this.getFieldStrings(n, n2, dateFormatSymbols);
                    BytecodeManager.incBytecodes(1);
                    final String[] array = fieldStrings;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final int n6 = value;
                        final int length = fieldStrings.length;
                        BytecodeManager.incBytecodes(4);
                        if (n6 < length) {
                            final String s2 = fieldStrings[value];
                            BytecodeManager.incBytecodes(4);
                            return s2;
                        }
                    }
                    final String s3 = null;
                    BytecodeManager.incBytecodes(2);
                    return s3;
                }
            }
            final String s4 = calendarType;
            final int n7 = value;
            BytecodeManager.incBytecodes(6);
            String s5 = CalendarDataUtility.retrieveFieldValueName(s4, n, n7, n2, locale);
            BytecodeManager.incBytecodes(1);
            final String s6 = s5;
            BytecodeManager.incBytecodes(2);
            if (s6 == null) {
                BytecodeManager.incBytecodes(3);
                final boolean narrowFormatStyle2 = this.isNarrowFormatStyle(n2);
                BytecodeManager.incBytecodes(1);
                if (narrowFormatStyle2) {
                    final String s7 = calendarType;
                    final int n8 = value;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int standaloneStyle2 = this.toStandaloneStyle(n2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    s5 = CalendarDataUtility.retrieveFieldValueName(s7, n, n8, standaloneStyle2, locale);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    final boolean standaloneStyle3 = this.isStandaloneStyle(n2);
                    BytecodeManager.incBytecodes(1);
                    if (standaloneStyle3) {
                        final String s8 = calendarType;
                        final int n9 = value;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        final int baseStyle = this.getBaseStyle(n2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        s5 = CalendarDataUtility.retrieveFieldValueName(s8, n, n9, baseStyle, locale);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final String s9 = s5;
            BytecodeManager.incBytecodes(2);
            return s9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Map<String, Integer> getDisplayNames(final int n, final int n2, final Locale locale) {
        try {
            final int n3 = 0;
            final int n4 = 4;
            final int n5 = 645;
            BytecodeManager.incBytecodes(8);
            final boolean checkDisplayNameParams = this.checkDisplayNameParams(n, n2, n3, n4, locale, n5);
            BytecodeManager.incBytecodes(1);
            if (!checkDisplayNameParams) {
                final Map<String, Integer> map = null;
                BytecodeManager.incBytecodes(2);
                return map;
            }
            BytecodeManager.incBytecodes(2);
            final String calendarType = this.getCalendarType();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (n2 != 0) {
                BytecodeManager.incBytecodes(3);
                final boolean standaloneStyle = this.isStandaloneStyle(n2);
                BytecodeManager.incBytecodes(1);
                if (!standaloneStyle) {
                    BytecodeManager.incBytecodes(3);
                    final boolean narrowFormatStyle = this.isNarrowFormatStyle(n2);
                    BytecodeManager.incBytecodes(1);
                    if (!narrowFormatStyle) {
                        BytecodeManager.incBytecodes(5);
                        final Map<String, Integer> displayNamesImpl = this.getDisplayNamesImpl(n, n2, locale);
                        BytecodeManager.incBytecodes(1);
                        return displayNamesImpl;
                    }
                }
            }
            final String s = calendarType;
            BytecodeManager.incBytecodes(5);
            Map map2 = CalendarDataUtility.retrieveFieldValueNames(s, n, n2, locale);
            BytecodeManager.incBytecodes(1);
            final Map map3 = map2;
            BytecodeManager.incBytecodes(2);
            if (map3 == null) {
                BytecodeManager.incBytecodes(3);
                final boolean narrowFormatStyle2 = this.isNarrowFormatStyle(n2);
                BytecodeManager.incBytecodes(1);
                if (narrowFormatStyle2) {
                    final String s2 = calendarType;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final int standaloneStyle2 = this.toStandaloneStyle(n2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    map2 = CalendarDataUtility.retrieveFieldValueNames(s2, n, standaloneStyle2, locale);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    if (n2 != 0) {
                        final String s3 = calendarType;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int baseStyle = this.getBaseStyle(n2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        map2 = CalendarDataUtility.retrieveFieldValueNames(s3, n, baseStyle, locale);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final Map map4 = map2;
            BytecodeManager.incBytecodes(2);
            return (Map<String, Integer>)map4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Map<String, Integer> getDisplayNamesImpl(final int n, final int n2, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            final DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            BytecodeManager.incBytecodes(1);
            final DateFormatSymbols dateFormatSymbols = instance;
            BytecodeManager.incBytecodes(5);
            final String[] fieldStrings = this.getFieldStrings(n, n2, dateFormatSymbols);
            BytecodeManager.incBytecodes(1);
            final String[] array = fieldStrings;
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(3);
                final HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                BytecodeManager.incBytecodes(1);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int length = fieldStrings.length;
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= length) {
                        break;
                    }
                    final String s = fieldStrings[n3];
                    BytecodeManager.incBytecodes(4);
                    final int length2 = s.length();
                    BytecodeManager.incBytecodes(1);
                    if (length2 == 0) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final HashMap<String, Integer> hashMap2 = hashMap;
                        final String s2 = fieldStrings[n3];
                        final int i = n3;
                        BytecodeManager.incBytecodes(6);
                        final Integer value = i;
                        BytecodeManager.incBytecodes(1);
                        hashMap2.put(s2, value);
                        BytecodeManager.incBytecodes(1);
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final HashMap<String, Integer> hashMap3 = hashMap;
                BytecodeManager.incBytecodes(2);
                return hashMap3;
            }
            final Map<String, Integer> map = null;
            BytecodeManager.incBytecodes(2);
            return map;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean checkDisplayNameParams(final int n, final int n2, final int n3, final int n4, final Locale locale, final int n5) {
        try {
            BytecodeManager.incBytecodes(3);
            final int baseStyle = this.getBaseStyle(n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int length = this.fields.length;
                BytecodeManager.incBytecodes(5);
                if (n < length) {
                    final int n6 = baseStyle;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n3) {
                        final int n7 = baseStyle;
                        BytecodeManager.incBytecodes(3);
                        if (n7 <= n4) {
                            BytecodeManager.incBytecodes(2);
                            if (locale == null) {
                                BytecodeManager.incBytecodes(3);
                                final NullPointerException ex = new NullPointerException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            BytecodeManager.incBytecodes(3);
                            final boolean fieldSet = isFieldSet(n5, n);
                            BytecodeManager.incBytecodes(1);
                            return fieldSet;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IllegalArgumentException ex2 = new IllegalArgumentException();
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String[] getFieldStrings(final int n, final int n2, final DateFormatSymbols dateFormatSymbols) {
        try {
            BytecodeManager.incBytecodes(3);
            final int baseStyle = this.getBaseStyle(n2);
            BytecodeManager.incBytecodes(1);
            final int n3 = baseStyle;
            final int n4 = 4;
            BytecodeManager.incBytecodes(3);
            if (n3 == n4) {
                final String[] array = null;
                BytecodeManager.incBytecodes(2);
                return array;
            }
            String[] array2 = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 0: {
                    BytecodeManager.incBytecodes(2);
                    array2 = dateFormatSymbols.getEras();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 2: {
                    final int n5 = baseStyle;
                    final int n6 = 2;
                    BytecodeManager.incBytecodes(3);
                    String[] array3;
                    if (n5 == n6) {
                        BytecodeManager.incBytecodes(2);
                        array3 = dateFormatSymbols.getMonths();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        array3 = dateFormatSymbols.getShortMonths();
                    }
                    array2 = array3;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 7: {
                    final int n7 = baseStyle;
                    final int n8 = 2;
                    BytecodeManager.incBytecodes(3);
                    String[] array4;
                    if (n7 == n8) {
                        BytecodeManager.incBytecodes(2);
                        array4 = dateFormatSymbols.getWeekdays();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        array4 = dateFormatSymbols.getShortWeekdays();
                    }
                    array2 = array4;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 9: {
                    BytecodeManager.incBytecodes(2);
                    array2 = dateFormatSymbols.getAmPmStrings();
                    BytecodeManager.incBytecodes(1);
                    break;
                }
            }
            final String[] array5 = array2;
            BytecodeManager.incBytecodes(2);
            return array5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void complete() {
        try {
            final boolean isTimeSet = this.isTimeSet;
            BytecodeManager.incBytecodes(3);
            if (!isTimeSet) {
                BytecodeManager.incBytecodes(2);
                this.updateTime();
            }
            final boolean areFieldsSet = this.areFieldsSet;
            BytecodeManager.incBytecodes(3);
            Label_0069: {
                if (areFieldsSet) {
                    final boolean areAllFieldsSet = this.areAllFieldsSet;
                    BytecodeManager.incBytecodes(3);
                    if (areAllFieldsSet) {
                        break Label_0069;
                    }
                }
                BytecodeManager.incBytecodes(2);
                this.computeFields();
                final boolean b = true;
                this.areFieldsSet = b;
                this.areAllFieldsSet = b;
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean isExternallySet(final int n) {
        try {
            final int n2 = this.stamp[n];
            final int n3 = 2;
            BytecodeManager.incBytecodes(6);
            boolean b;
            if (n2 >= n3) {
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
    
    final int getSetStateFields() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length = this.fields.length;
                BytecodeManager.incBytecodes(5);
                if (n3 >= length) {
                    break;
                }
                final int n4 = this.stamp[n2];
                BytecodeManager.incBytecodes(5);
                if (n4 != 0) {
                    n |= 1 << n2;
                    BytecodeManager.incBytecodes(6);
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
    
    final void setFieldsComputed(int n) {
        try {
            final int n2 = n;
            final int n3 = 131071;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    final int length = this.fields.length;
                    BytecodeManager.incBytecodes(5);
                    if (n5 >= length) {
                        break;
                    }
                    this.stamp[n4] = 1;
                    BytecodeManager.incBytecodes(5);
                    this.isSet[n4] = true;
                    BytecodeManager.incBytecodes(5);
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
                final boolean b = true;
                this.areAllFieldsSet = b;
                this.areFieldsSet = b;
                BytecodeManager.incBytecodes(7);
            }
            else {
                int n6 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    final int length2 = this.fields.length;
                    BytecodeManager.incBytecodes(5);
                    if (n7 >= length2) {
                        break;
                    }
                    final int n8 = n & 0x1;
                    final int n9 = 1;
                    BytecodeManager.incBytecodes(5);
                    if (n8 == n9) {
                        this.stamp[n6] = 1;
                        BytecodeManager.incBytecodes(5);
                        this.isSet[n6] = true;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        final boolean areAllFieldsSet = this.areAllFieldsSet;
                        BytecodeManager.incBytecodes(3);
                        if (areAllFieldsSet) {
                            final boolean b2 = this.isSet[n6];
                            BytecodeManager.incBytecodes(5);
                            if (!b2) {
                                this.areAllFieldsSet = false;
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                    }
                    n >>>= 1;
                    BytecodeManager.incBytecodes(4);
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void setFieldsNormalized(int n) {
        try {
            final int n2 = n;
            final int n3 = 131071;
            BytecodeManager.incBytecodes(3);
            if (n2 != n3) {
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    final int length = this.fields.length;
                    BytecodeManager.incBytecodes(5);
                    if (n5 >= length) {
                        break;
                    }
                    final int n6 = n & 0x1;
                    BytecodeManager.incBytecodes(4);
                    if (n6 == 0) {
                        this.stamp[n4] = (this.fields[n4] = 0);
                        BytecodeManager.incBytecodes(10);
                        this.isSet[n4] = false;
                        BytecodeManager.incBytecodes(5);
                    }
                    n >>= 1;
                    BytecodeManager.incBytecodes(4);
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.areFieldsSet = true;
            BytecodeManager.incBytecodes(3);
            this.areAllFieldsSet = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean isPartiallyNormalized() {
        try {
            final boolean areFieldsSet = this.areFieldsSet;
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0039: {
                if (areFieldsSet) {
                    final boolean areAllFieldsSet = this.areAllFieldsSet;
                    BytecodeManager.incBytecodes(3);
                    if (!areAllFieldsSet) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0039;
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
    
    final boolean isFullyNormalized() {
        try {
            final boolean areFieldsSet = this.areFieldsSet;
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0039: {
                if (areFieldsSet) {
                    final boolean areAllFieldsSet = this.areAllFieldsSet;
                    BytecodeManager.incBytecodes(3);
                    if (areAllFieldsSet) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0039;
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
    
    final void setUnnormalized() {
        try {
            final boolean b = false;
            this.areAllFieldsSet = b;
            this.areFieldsSet = b;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isFieldSet(final int n, final int n2) {
        try {
            final int n3 = n & 1 << n2;
            BytecodeManager.incBytecodes(6);
            boolean b;
            if (n3 != 0) {
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
    
    final int selectFields() {
        try {
            int n = 2;
            BytecodeManager.incBytecodes(2);
            final int n2 = this.stamp[0];
            BytecodeManager.incBytecodes(5);
            if (n2 != 0) {
                n |= 0x1;
                BytecodeManager.incBytecodes(4);
            }
            final int n3 = this.stamp[7];
            BytecodeManager.incBytecodes(5);
            final int n4 = this.stamp[2];
            BytecodeManager.incBytecodes(5);
            int n5 = this.stamp[5];
            BytecodeManager.incBytecodes(5);
            final int n6 = this.stamp[4];
            final int n7 = n3;
            BytecodeManager.incBytecodes(6);
            int aggregateStamp = aggregateStamp(n6, n7);
            BytecodeManager.incBytecodes(1);
            final int n8 = this.stamp[8];
            final int n9 = n3;
            BytecodeManager.incBytecodes(6);
            int n10 = aggregateStamp(n8, n9);
            BytecodeManager.incBytecodes(1);
            final int n11 = this.stamp[6];
            BytecodeManager.incBytecodes(5);
            final int n12 = this.stamp[3];
            final int n13 = n3;
            BytecodeManager.incBytecodes(6);
            int aggregateStamp2 = aggregateStamp(n12, n13);
            BytecodeManager.incBytecodes(1);
            int max = n5;
            BytecodeManager.incBytecodes(2);
            final int n14 = aggregateStamp;
            final int n15 = max;
            BytecodeManager.incBytecodes(3);
            if (n14 > n15) {
                max = aggregateStamp;
                BytecodeManager.incBytecodes(2);
            }
            final int n16 = n10;
            final int n17 = max;
            BytecodeManager.incBytecodes(3);
            if (n16 > n17) {
                max = n10;
                BytecodeManager.incBytecodes(2);
            }
            final int n18 = n11;
            final int n19 = max;
            BytecodeManager.incBytecodes(3);
            if (n18 > n19) {
                max = n11;
                BytecodeManager.incBytecodes(2);
            }
            final int n20 = aggregateStamp2;
            final int n21 = max;
            BytecodeManager.incBytecodes(3);
            if (n20 > n21) {
                max = aggregateStamp2;
                BytecodeManager.incBytecodes(2);
            }
            final int n22 = max;
            BytecodeManager.incBytecodes(2);
            if (n22 == 0) {
                aggregateStamp = this.stamp[4];
                BytecodeManager.incBytecodes(5);
                final int a = this.stamp[8];
                final int b = n3;
                BytecodeManager.incBytecodes(6);
                n10 = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
                aggregateStamp2 = this.stamp[3];
                BytecodeManager.incBytecodes(5);
                final int a2 = aggregateStamp;
                final int b2 = n10;
                BytecodeManager.incBytecodes(3);
                final int max2 = Math.max(a2, b2);
                final int b3 = aggregateStamp2;
                BytecodeManager.incBytecodes(2);
                max = Math.max(max2, b3);
                BytecodeManager.incBytecodes(1);
                final int n23 = max;
                BytecodeManager.incBytecodes(2);
                if (n23 == 0) {
                    n5 = (max = n4);
                    BytecodeManager.incBytecodes(4);
                }
            }
            final int n24 = max;
            final int n25 = n5;
            BytecodeManager.incBytecodes(3);
            int n41 = 0;
            Label_0849: {
                Label_0428: {
                    if (n24 != n25) {
                        final int n26 = max;
                        final int n27 = aggregateStamp;
                        BytecodeManager.incBytecodes(3);
                        if (n26 == n27) {
                            final int n28 = this.stamp[4];
                            final int n29 = this.stamp[3];
                            BytecodeManager.incBytecodes(9);
                            if (n28 >= n29) {
                                break Label_0428;
                            }
                        }
                        final int n30 = max;
                        final int n31 = n10;
                        BytecodeManager.incBytecodes(3);
                        if (n30 == n31) {
                            final int n32 = this.stamp[8];
                            final int n33 = this.stamp[3];
                            BytecodeManager.incBytecodes(9);
                            if (n32 >= n33) {
                                break Label_0428;
                            }
                        }
                        final boolean $assertionsDisabled = Calendar.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            final int n34 = max;
                            final int n35 = n11;
                            BytecodeManager.incBytecodes(3);
                            if (n34 != n35) {
                                final int n36 = max;
                                final int n37 = aggregateStamp2;
                                BytecodeManager.incBytecodes(3);
                                if (n36 != n37) {
                                    final int n38 = max;
                                    BytecodeManager.incBytecodes(2);
                                    if (n38 != 0) {
                                        BytecodeManager.incBytecodes(3);
                                        final AssertionError assertionError = new AssertionError();
                                        BytecodeManager.incBytecodes(1);
                                        throw assertionError;
                                    }
                                }
                            }
                        }
                        final int n39 = max;
                        final int n40 = n11;
                        BytecodeManager.incBytecodes(3);
                        if (n39 == n40) {
                            n41 = (n | 0x40);
                            BytecodeManager.incBytecodes(5);
                            break Label_0849;
                        }
                        final boolean $assertionsDisabled2 = Calendar.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled2) {
                            final int n42 = max;
                            final int n43 = aggregateStamp2;
                            BytecodeManager.incBytecodes(3);
                            if (n42 != n43) {
                                BytecodeManager.incBytecodes(3);
                                final AssertionError assertionError2 = new AssertionError();
                                BytecodeManager.incBytecodes(1);
                                throw assertionError2;
                            }
                        }
                        final int n44 = n3;
                        BytecodeManager.incBytecodes(2);
                        if (n44 != 0) {
                            n |= 0x80;
                            BytecodeManager.incBytecodes(4);
                        }
                        n41 = (n | 0x8);
                        BytecodeManager.incBytecodes(4);
                        break Label_0849;
                    }
                }
                n41 = (n | 0x4);
                BytecodeManager.incBytecodes(4);
                final int n45 = max;
                final int n46 = n5;
                BytecodeManager.incBytecodes(3);
                if (n45 == n46) {
                    n41 |= 0x20;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final boolean $assertionsDisabled3 = Calendar.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled3) {
                        final int n47 = max;
                        final int n48 = aggregateStamp;
                        BytecodeManager.incBytecodes(3);
                        if (n47 != n48) {
                            final int n49 = max;
                            final int n50 = n10;
                            BytecodeManager.incBytecodes(3);
                            if (n49 != n50) {
                                BytecodeManager.incBytecodes(3);
                                final AssertionError assertionError3 = new AssertionError();
                                BytecodeManager.incBytecodes(1);
                                throw assertionError3;
                            }
                        }
                    }
                    final int n51 = n3;
                    BytecodeManager.incBytecodes(2);
                    if (n51 != 0) {
                        n41 |= 0x80;
                        BytecodeManager.incBytecodes(4);
                    }
                    final int n52 = aggregateStamp;
                    final int n53 = n10;
                    BytecodeManager.incBytecodes(3);
                    if (n52 == n53) {
                        final int n54 = this.stamp[4];
                        final int n55 = this.stamp[8];
                        BytecodeManager.incBytecodes(9);
                        if (n54 >= n55) {
                            n41 |= 0x10;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            n41 |= 0x100;
                            BytecodeManager.incBytecodes(5);
                        }
                    }
                    else {
                        final int n56 = max;
                        final int n57 = aggregateStamp;
                        BytecodeManager.incBytecodes(3);
                        if (n56 == n57) {
                            n41 |= 0x10;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            final boolean $assertionsDisabled4 = Calendar.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled4) {
                                final int n58 = max;
                                final int n59 = n10;
                                BytecodeManager.incBytecodes(3);
                                if (n58 != n59) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError4 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError4;
                                }
                            }
                            final int n60 = this.stamp[8];
                            BytecodeManager.incBytecodes(5);
                            if (n60 != 0) {
                                n41 |= 0x100;
                                BytecodeManager.incBytecodes(5);
                            }
                        }
                    }
                }
            }
            final int n61 = this.stamp[11];
            BytecodeManager.incBytecodes(5);
            final int n62 = this.stamp[10];
            final int n63 = this.stamp[9];
            BytecodeManager.incBytecodes(9);
            final int aggregateStamp3 = aggregateStamp(n62, n63);
            BytecodeManager.incBytecodes(1);
            final int n64 = aggregateStamp3;
            final int n65 = n61;
            BytecodeManager.incBytecodes(3);
            int n66;
            if (n64 > n65) {
                n66 = aggregateStamp3;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n66 = n61;
                BytecodeManager.incBytecodes(1);
            }
            int max3 = n66;
            BytecodeManager.incBytecodes(1);
            final int n67 = max3;
            BytecodeManager.incBytecodes(2);
            if (n67 == 0) {
                final int a3 = this.stamp[10];
                final int b4 = this.stamp[9];
                BytecodeManager.incBytecodes(9);
                max3 = Math.max(a3, b4);
                BytecodeManager.incBytecodes(1);
            }
            final int n68 = max3;
            BytecodeManager.incBytecodes(2);
            if (n68 != 0) {
                final int n69 = max3;
                final int n70 = n61;
                BytecodeManager.incBytecodes(3);
                if (n69 == n70) {
                    n41 |= 0x800;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    n41 |= 0x400;
                    BytecodeManager.incBytecodes(4);
                    final int n71 = this.stamp[9];
                    BytecodeManager.incBytecodes(5);
                    if (n71 != 0) {
                        n41 |= 0x200;
                        BytecodeManager.incBytecodes(4);
                    }
                }
            }
            final int n72 = this.stamp[12];
            BytecodeManager.incBytecodes(5);
            if (n72 != 0) {
                n41 |= 0x1000;
                BytecodeManager.incBytecodes(4);
            }
            final int n73 = this.stamp[13];
            BytecodeManager.incBytecodes(5);
            if (n73 != 0) {
                n41 |= 0x2000;
                BytecodeManager.incBytecodes(4);
            }
            final int n74 = this.stamp[14];
            BytecodeManager.incBytecodes(5);
            if (n74 != 0) {
                n41 |= 0x4000;
                BytecodeManager.incBytecodes(4);
            }
            final int n75 = this.stamp[15];
            final int n76 = 2;
            BytecodeManager.incBytecodes(6);
            if (n75 >= n76) {
                n41 |= 0x8000;
                BytecodeManager.incBytecodes(4);
            }
            final int n77 = this.stamp[16];
            final int n78 = 2;
            BytecodeManager.incBytecodes(6);
            if (n77 >= n78) {
                n41 |= 0x10000;
                BytecodeManager.incBytecodes(4);
            }
            final int n79 = n41;
            BytecodeManager.incBytecodes(2);
            return n79;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int getBaseStyle(final int n) {
        try {
            final int n2 = n & 0xFFFF7FFF;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int toStandaloneStyle(final int n) {
        try {
            final int n2 = n | 0x8000;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isStandaloneStyle(final int n) {
        try {
            final int n2 = n & 0x8000;
            BytecodeManager.incBytecodes(4);
            boolean b;
            if (n2 != 0) {
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
    
    private boolean isNarrowStyle(final int n) {
        try {
            final int n2 = 4;
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0036: {
                if (n != n2) {
                    final int n3 = 32772;
                    BytecodeManager.incBytecodes(3);
                    if (n != n3) {
                        b = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0036;
                    }
                }
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isNarrowFormatStyle(final int n) {
        try {
            final int n2 = 4;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (n == n2) {
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
    
    private static int aggregateStamp(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n != 0) {
                BytecodeManager.incBytecodes(2);
                if (n2 != 0) {
                    BytecodeManager.incBytecodes(3);
                    int n3;
                    if (n > n2) {
                        n3 = n;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n3 = n2;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
            }
            final int n4 = 0;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Set<String> getAvailableCalendarTypes() {
        try {
            BytecodeManager.incBytecodes(1);
            final Set access$000 = AvailableCalendarTypes.access$000();
            BytecodeManager.incBytecodes(1);
            return (Set<String>)access$000;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getCalendarType() {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<? extends Calendar> class1 = this.getClass();
            BytecodeManager.incBytecodes(1);
            final String name = class1.getName();
            BytecodeManager.incBytecodes(1);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: if_acmpne       17
        //    10: iconst_1       
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: ireturn        
        //    17: aload_1        
        //    18: checkcast       Linstrumented/java/util/Calendar;
        //    21: astore_2       
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: aload_0        
        //    28: aload_2        
        //    29: ldc             3
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: invokestatic    instrumented/java/util/Calendar.getMillisOf:(Linstrumented/java/util/Calendar;)J
        //    37: ldc             1
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokespecial   instrumented/java/util/Calendar.compareTo:(J)I
        //    45: ldc             1
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: ifne            139
        //    53: aload_0        
        //    54: getfield        instrumented/java/util/Calendar.lenient:Z
        //    57: aload_2        
        //    58: getfield        instrumented/java/util/Calendar.lenient:Z
        //    61: ldc             5
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: if_icmpne       139
        //    69: aload_0        
        //    70: getfield        instrumented/java/util/Calendar.firstDayOfWeek:I
        //    73: aload_2        
        //    74: getfield        instrumented/java/util/Calendar.firstDayOfWeek:I
        //    77: ldc             5
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: if_icmpne       139
        //    85: aload_0        
        //    86: getfield        instrumented/java/util/Calendar.minimalDaysInFirstWeek:I
        //    89: aload_2        
        //    90: getfield        instrumented/java/util/Calendar.minimalDaysInFirstWeek:I
        //    93: ldc             5
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: if_icmpne       139
        //   101: aload_0        
        //   102: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   105: aload_2        
        //   106: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   109: ldc             4
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   122: ldc             1
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: ifeq            139
        //   130: iconst_1       
        //   131: ldc             2
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: goto            145
        //   139: iconst_0       
        //   140: ldc             1
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: ldc             1
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: ireturn        
        //   151: astore_2       
        //   152: ldc             501
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: iconst_0       
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ireturn        
        //   164: athrow         
        //   165: athrow         
        //    StackMapTable: 00 06 11 FC 00 79 07 00 02 45 01 FF 00 05 00 02 07 00 02 07 00 05 00 01 07 01 F1 FF 00 0C 00 00 00 01 07 00 C2 FF 00 00 00 00 00 01 07 00 E2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  17     165    165    166    Ljava/lang/VirtualMachineError;
        //  17     145    151    164    Ljava/lang/Exception;
        //  0      164    164    165    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0017:
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
    public int hashCode() {
        try {
            final boolean lenient = this.lenient;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (lenient) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            final int n = (b ? 1 : 0) | this.firstDayOfWeek << 1 | this.minimalDaysInFirstWeek << 4;
            final TimeZone zone = this.zone;
            BytecodeManager.incBytecodes(12);
            BytecodeManager.incBytecodes(1);
            final int n2 = n | zone.hashCode() << 7;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final long millis = getMillisOf(this);
            BytecodeManager.incBytecodes(1);
            final int n3 = (int)millis ^ (int)(millis >> 32) ^ n2;
            BytecodeManager.incBytecodes(10);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean before(final Object o) {
        try {
            final boolean b = o instanceof Calendar;
            BytecodeManager.incBytecodes(3);
            boolean b2 = false;
            Label_0053: {
                if (b) {
                    final Calendar calendar = (Calendar)o;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final int compareTo = this.compareTo(calendar);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo < 0) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0053;
                    }
                }
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean after(final Object o) {
        try {
            final boolean b = o instanceof Calendar;
            BytecodeManager.incBytecodes(3);
            boolean b2 = false;
            Label_0053: {
                if (b) {
                    final Calendar calendar = (Calendar)o;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final int compareTo = this.compareTo(calendar);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo > 0) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0053;
                    }
                }
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int compareTo(final Calendar calendar) {
        try {
            BytecodeManager.incBytecodes(3);
            final long millis = getMillisOf(calendar);
            BytecodeManager.incBytecodes(1);
            final int compareTo = this.compareTo(millis);
            BytecodeManager.incBytecodes(1);
            return compareTo;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract void add(final int p0, final int p1);
    
    public abstract void roll(final int p0, final boolean p1);
    
    public void roll(final int n, int n2) {
        try {
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 <= 0) {
                    break;
                }
                final boolean b = true;
                BytecodeManager.incBytecodes(4);
                this.roll(n, b);
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                final int n4 = n2;
                BytecodeManager.incBytecodes(2);
                if (n4 >= 0) {
                    break;
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(4);
                this.roll(n, b2);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setTimeZone(final TimeZone zone) {
        try {
            this.zone = zone;
            BytecodeManager.incBytecodes(3);
            this.sharedZone = false;
            BytecodeManager.incBytecodes(3);
            final boolean b = false;
            this.areFieldsSet = b;
            this.areAllFieldsSet = b;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public TimeZone getTimeZone() {
        try {
            final boolean sharedZone = this.sharedZone;
            BytecodeManager.incBytecodes(3);
            if (sharedZone) {
                final TimeZone zone = this.zone;
                BytecodeManager.incBytecodes(4);
                this.zone = (TimeZone)zone.clone();
                BytecodeManager.incBytecodes(2);
                this.sharedZone = false;
                BytecodeManager.incBytecodes(3);
            }
            final TimeZone zone2 = this.zone;
            BytecodeManager.incBytecodes(3);
            return zone2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    TimeZone getZone() {
        try {
            final TimeZone zone = this.zone;
            BytecodeManager.incBytecodes(3);
            return zone;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void setZoneShared(final boolean sharedZone) {
        try {
            this.sharedZone = sharedZone;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setLenient(final boolean lenient) {
        try {
            this.lenient = lenient;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isLenient() {
        try {
            final boolean lenient = this.lenient;
            BytecodeManager.incBytecodes(3);
            return lenient;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setFirstDayOfWeek(final int firstDayOfWeek) {
        try {
            final int firstDayOfWeek2 = this.firstDayOfWeek;
            BytecodeManager.incBytecodes(4);
            if (firstDayOfWeek2 == firstDayOfWeek) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            this.firstDayOfWeek = firstDayOfWeek;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.invalidateWeekFields();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getFirstDayOfWeek() {
        try {
            final int firstDayOfWeek = this.firstDayOfWeek;
            BytecodeManager.incBytecodes(3);
            return firstDayOfWeek;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setMinimalDaysInFirstWeek(final int minimalDaysInFirstWeek) {
        try {
            final int minimalDaysInFirstWeek2 = this.minimalDaysInFirstWeek;
            BytecodeManager.incBytecodes(4);
            if (minimalDaysInFirstWeek2 == minimalDaysInFirstWeek) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            this.minimalDaysInFirstWeek = minimalDaysInFirstWeek;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.invalidateWeekFields();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getMinimalDaysInFirstWeek() {
        try {
            final int minimalDaysInFirstWeek = this.minimalDaysInFirstWeek;
            BytecodeManager.incBytecodes(3);
            return minimalDaysInFirstWeek;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isWeekDateSupported() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getWeekYear() {
        try {
            BytecodeManager.incBytecodes(3);
            final UnsupportedOperationException ex = new UnsupportedOperationException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setWeekDate(final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(3);
            final UnsupportedOperationException ex = new UnsupportedOperationException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getWeeksInWeekYear() {
        try {
            BytecodeManager.incBytecodes(3);
            final UnsupportedOperationException ex = new UnsupportedOperationException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract int getMinimum(final int p0);
    
    public abstract int getMaximum(final int p0);
    
    public abstract int getGreatestMinimum(final int p0);
    
    public abstract int getLeastMaximum(final int p0);
    
    public int getActualMinimum(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            int greatestMinimum = this.getGreatestMinimum(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final int minimum = this.getMinimum(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = greatestMinimum;
            final int n3 = minimum;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final int n4 = greatestMinimum;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            BytecodeManager.incBytecodes(2);
            final Calendar calendar = (Calendar)this.clone();
            BytecodeManager.incBytecodes(2);
            final Calendar calendar2 = calendar;
            final boolean lenient = true;
            BytecodeManager.incBytecodes(3);
            calendar2.setLenient(lenient);
            int n5 = greatestMinimum;
            BytecodeManager.incBytecodes(2);
            int i;
            int n6;
            do {
                final Calendar calendar3 = calendar;
                final int n7 = greatestMinimum;
                BytecodeManager.incBytecodes(4);
                calendar3.set(n, n7);
                final Calendar calendar4 = calendar;
                BytecodeManager.incBytecodes(3);
                final int value = calendar4.get(n);
                final int n8 = greatestMinimum;
                BytecodeManager.incBytecodes(2);
                if (value != n8) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                n5 = greatestMinimum;
                BytecodeManager.incBytecodes(2);
                --greatestMinimum;
                BytecodeManager.incBytecodes(1);
                i = greatestMinimum;
                n6 = minimum;
                BytecodeManager.incBytecodes(3);
            } while (i >= n6);
            final int n9 = n5;
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getActualMaximum(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            int leastMaximum = this.getLeastMaximum(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final int maximum = this.getMaximum(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = leastMaximum;
            final int n3 = maximum;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final int n4 = leastMaximum;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            BytecodeManager.incBytecodes(2);
            final Calendar calendar = (Calendar)this.clone();
            BytecodeManager.incBytecodes(2);
            final Calendar calendar2 = calendar;
            final boolean lenient = true;
            BytecodeManager.incBytecodes(3);
            calendar2.setLenient(lenient);
            final int n5 = 3;
            BytecodeManager.incBytecodes(3);
            Label_0115: {
                if (n != n5) {
                    final int n6 = 4;
                    BytecodeManager.incBytecodes(3);
                    if (n != n6) {
                        break Label_0115;
                    }
                }
                final Calendar calendar3 = calendar;
                final int n7 = 7;
                final int firstDayOfWeek = this.firstDayOfWeek;
                BytecodeManager.incBytecodes(5);
                calendar3.set(n7, firstDayOfWeek);
            }
            int n8 = leastMaximum;
            BytecodeManager.incBytecodes(2);
            int i;
            int n9;
            do {
                final Calendar calendar4 = calendar;
                final int n10 = leastMaximum;
                BytecodeManager.incBytecodes(4);
                calendar4.set(n, n10);
                final Calendar calendar5 = calendar;
                BytecodeManager.incBytecodes(3);
                final int value = calendar5.get(n);
                final int n11 = leastMaximum;
                BytecodeManager.incBytecodes(2);
                if (value != n11) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                n8 = leastMaximum;
                BytecodeManager.incBytecodes(2);
                ++leastMaximum;
                BytecodeManager.incBytecodes(1);
                i = leastMaximum;
                n9 = maximum;
                BytecodeManager.incBytecodes(3);
            } while (i <= n9);
            final int n12 = n8;
            BytecodeManager.incBytecodes(2);
            return n12;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final Calendar calendar = (Calendar)super.clone();
                BytecodeManager.incBytecodes(2);
                calendar.fields = new int[17];
                BytecodeManager.incBytecodes(3);
                calendar.isSet = new boolean[17];
                BytecodeManager.incBytecodes(3);
                calendar.stamp = new int[17];
                BytecodeManager.incBytecodes(3);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int n3 = 17;
                    BytecodeManager.incBytecodes(3);
                    if (n2 >= n3) {
                        break;
                    }
                    calendar.fields[n] = this.fields[n];
                    BytecodeManager.incBytecodes(8);
                    calendar.stamp[n] = this.stamp[n];
                    BytecodeManager.incBytecodes(8);
                    calendar.isSet[n] = this.isSet[n];
                    BytecodeManager.incBytecodes(8);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final Calendar calendar2 = calendar;
                final TimeZone zone = this.zone;
                BytecodeManager.incBytecodes(4);
                calendar2.zone = (TimeZone)zone.clone();
                BytecodeManager.incBytecodes(2);
                final Calendar calendar3 = calendar;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return calendar3;
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
    
    static String getFieldName(final int n) {
        try {
            final String s = Calendar.FIELD_NAME[n];
            BytecodeManager.incBytecodes(4);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final int capacity = 800;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            BytecodeManager.incBytecodes(3);
            final Class<? extends Calendar> class1 = this.getClass();
            BytecodeManager.incBytecodes(1);
            final String name = class1.getName();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb2.append(name);
            final char c = '[';
            BytecodeManager.incBytecodes(2);
            append.append(c);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb3 = sb;
            final String s = "time";
            final boolean isTimeSet = this.isTimeSet;
            final long time = this.time;
            BytecodeManager.incBytecodes(7);
            appendValue(sb3, s, isTimeSet, time);
            final StringBuilder sb4 = sb;
            final String str = ",areFieldsSet=";
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = sb4.append(str);
            final boolean areFieldsSet = this.areFieldsSet;
            BytecodeManager.incBytecodes(3);
            append2.append(areFieldsSet);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb5 = sb;
            final String str2 = ",areAllFieldsSet=";
            BytecodeManager.incBytecodes(3);
            final StringBuilder append3 = sb5.append(str2);
            final boolean areAllFieldsSet = this.areAllFieldsSet;
            BytecodeManager.incBytecodes(3);
            append3.append(areAllFieldsSet);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb6 = sb;
            final String str3 = ",lenient=";
            BytecodeManager.incBytecodes(3);
            final StringBuilder append4 = sb6.append(str3);
            final boolean lenient = this.lenient;
            BytecodeManager.incBytecodes(3);
            append4.append(lenient);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb7 = sb;
            final String str4 = ",zone=";
            BytecodeManager.incBytecodes(3);
            final StringBuilder append5 = sb7.append(str4);
            final TimeZone zone = this.zone;
            BytecodeManager.incBytecodes(3);
            append5.append(zone);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb8 = sb;
            final String s2 = ",firstDayOfWeek";
            final boolean b = true;
            final long n = this.firstDayOfWeek;
            BytecodeManager.incBytecodes(7);
            appendValue(sb8, s2, b, n);
            final StringBuilder sb9 = sb;
            final String s3 = ",minimalDaysInFirstWeek";
            final boolean b2 = true;
            final long n2 = this.minimalDaysInFirstWeek;
            BytecodeManager.incBytecodes(7);
            appendValue(sb9, s3, b2, n2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int n5 = 17;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final StringBuilder sb10 = sb;
                final char c2 = ',';
                BytecodeManager.incBytecodes(3);
                sb10.append(c2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb11 = sb;
                final String s4 = Calendar.FIELD_NAME[n3];
                final int n6 = n3;
                BytecodeManager.incBytecodes(7);
                final boolean set = this.isSet(n6);
                final long n7 = this.fields[n3];
                BytecodeManager.incBytecodes(6);
                appendValue(sb11, s4, set, n7);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb12 = sb;
            final char c3 = ']';
            BytecodeManager.incBytecodes(3);
            sb12.append(c3);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb13 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb13.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void appendValue(final StringBuilder sb, final String str, final boolean b, final long lng) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb.append(str);
            final char c = '=';
            BytecodeManager.incBytecodes(2);
            append.append(c);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (b) {
                BytecodeManager.incBytecodes(3);
                sb.append(lng);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final char c2 = '?';
                BytecodeManager.incBytecodes(3);
                sb.append(c2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void setWeekCountData(final Locale locale) {
        try {
            final ConcurrentMap<Locale, int[]> cachedLocaleData = Calendar.cachedLocaleData;
            BytecodeManager.incBytecodes(3);
            int[] array = cachedLocaleData.get(locale);
            BytecodeManager.incBytecodes(2);
            final int[] array2 = array;
            BytecodeManager.incBytecodes(2);
            if (array2 == null) {
                array = new int[2];
                BytecodeManager.incBytecodes(2);
                final int[] array3 = array;
                final int n = 0;
                BytecodeManager.incBytecodes(4);
                array3[n] = CalendarDataUtility.retrieveFirstDayOfWeek(locale);
                BytecodeManager.incBytecodes(1);
                final int[] array4 = array;
                final int n2 = 1;
                BytecodeManager.incBytecodes(4);
                array4[n2] = CalendarDataUtility.retrieveMinimalDaysInFirstWeek(locale);
                BytecodeManager.incBytecodes(1);
                final ConcurrentMap<Locale, int[]> cachedLocaleData2 = Calendar.cachedLocaleData;
                final int[] array5 = array;
                BytecodeManager.incBytecodes(4);
                cachedLocaleData2.putIfAbsent(locale, array5);
                BytecodeManager.incBytecodes(1);
            }
            this.firstDayOfWeek = array[0];
            BytecodeManager.incBytecodes(5);
            this.minimalDaysInFirstWeek = array[1];
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void updateTime() {
        try {
            BytecodeManager.incBytecodes(2);
            this.computeTime();
            this.isTimeSet = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int compareTo(final long n) {
        try {
            BytecodeManager.incBytecodes(2);
            final long millis = getMillisOf(this);
            BytecodeManager.incBytecodes(1);
            final long n2 = lcmp(millis, n);
            BytecodeManager.incBytecodes(4);
            int n3;
            if (n2 > 0) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final long n4 = lcmp(millis, n);
                BytecodeManager.incBytecodes(4);
                if (n4 == 0) {
                    n3 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = -1;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long getMillisOf(final Calendar calendar) {
        try {
            final boolean isTimeSet = calendar.isTimeSet;
            BytecodeManager.incBytecodes(3);
            if (isTimeSet) {
                final long time = calendar.time;
                BytecodeManager.incBytecodes(3);
                return time;
            }
            BytecodeManager.incBytecodes(2);
            final Calendar calendar2 = (Calendar)calendar.clone();
            BytecodeManager.incBytecodes(2);
            final Calendar calendar3 = calendar2;
            final boolean lenient = true;
            BytecodeManager.incBytecodes(3);
            calendar3.setLenient(lenient);
            final Calendar calendar4 = calendar2;
            BytecodeManager.incBytecodes(2);
            final long timeInMillis = calendar4.getTimeInMillis();
            BytecodeManager.incBytecodes(1);
            return timeInMillis;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void adjustStamp() {
        try {
            int n = 2;
            BytecodeManager.incBytecodes(2);
            int nextStamp = 2;
            BytecodeManager.incBytecodes(2);
            while (true) {
                int n2 = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int length = this.stamp.length;
                    BytecodeManager.incBytecodes(5);
                    if (n4 >= length) {
                        break;
                    }
                    final int n5 = this.stamp[n3];
                    BytecodeManager.incBytecodes(5);
                    final int n6 = n5;
                    final int n7 = nextStamp;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n7) {
                        final int n8 = n2;
                        final int n9 = n5;
                        BytecodeManager.incBytecodes(3);
                        if (n8 > n9) {
                            n2 = n5;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    final int n10 = n;
                    final int n11 = n5;
                    BytecodeManager.incBytecodes(3);
                    if (n10 < n11) {
                        n = n5;
                        BytecodeManager.incBytecodes(2);
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final int n12 = n;
                final int n13 = n2;
                BytecodeManager.incBytecodes(3);
                if (n12 != n13) {
                    final int n14 = n2;
                    final int n15 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(3);
                    if (n14 == n15) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                }
                int n16 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n17 = n16;
                    final int length2 = this.stamp.length;
                    BytecodeManager.incBytecodes(5);
                    if (n17 >= length2) {
                        break;
                    }
                    final int n18 = this.stamp[n16];
                    final int n19 = n2;
                    BytecodeManager.incBytecodes(6);
                    if (n18 == n19) {
                        this.stamp[n16] = nextStamp;
                        BytecodeManager.incBytecodes(5);
                    }
                    ++n16;
                    BytecodeManager.incBytecodes(2);
                }
                ++nextStamp;
                BytecodeManager.incBytecodes(1);
                final int n20 = n2;
                final int n21 = n;
                BytecodeManager.incBytecodes(3);
                if (n20 == n21) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                BytecodeManager.incBytecodes(1);
            }
            this.nextStamp = nextStamp;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void invalidateWeekFields() {
        try {
            final int n = this.stamp[4];
            final int n2 = 1;
            BytecodeManager.incBytecodes(6);
            if (n != n2) {
                final int n3 = this.stamp[3];
                final int n4 = 1;
                BytecodeManager.incBytecodes(6);
                if (n3 != n4) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(2);
            final Calendar calendar = (Calendar)this.clone();
            BytecodeManager.incBytecodes(2);
            final Calendar calendar2 = calendar;
            final boolean lenient = true;
            BytecodeManager.incBytecodes(3);
            calendar2.setLenient(lenient);
            final Calendar calendar3 = calendar;
            final int n5 = 4;
            BytecodeManager.incBytecodes(3);
            calendar3.clear(n5);
            final Calendar calendar4 = calendar;
            final int n6 = 3;
            BytecodeManager.incBytecodes(3);
            calendar4.clear(n6);
            final int n7 = this.stamp[4];
            final int n8 = 1;
            BytecodeManager.incBytecodes(6);
            if (n7 == n8) {
                final Calendar calendar5 = calendar;
                final int n9 = 4;
                BytecodeManager.incBytecodes(3);
                final int value = calendar5.get(n9);
                BytecodeManager.incBytecodes(1);
                final int n10 = this.fields[4];
                final int n11 = value;
                BytecodeManager.incBytecodes(6);
                if (n10 != n11) {
                    this.fields[4] = value;
                    BytecodeManager.incBytecodes(5);
                }
            }
            final int n12 = this.stamp[3];
            final int n13 = 1;
            BytecodeManager.incBytecodes(6);
            if (n12 == n13) {
                final Calendar calendar6 = calendar;
                final int n14 = 3;
                BytecodeManager.incBytecodes(3);
                final int value2 = calendar6.get(n14);
                BytecodeManager.incBytecodes(1);
                final int n15 = this.fields[3];
                final int n16 = value2;
                BytecodeManager.incBytecodes(6);
                if (n15 != n16) {
                    this.fields[3] = value2;
                    BytecodeManager.incBytecodes(5);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void writeObject(final ObjectOutputStream p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Calendar.isTimeSet:Z
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifne            35
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   instrumented/java/util/Calendar.updateTime:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: goto            35
        //    29: astore_2       
        //    30: ldc             501
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aconst_null    
        //    36: astore_2       
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: aload_0        
        //    43: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //    46: instanceof      Lsun/util/calendar/ZoneInfo;
        //    49: ldc             4
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifeq            149
        //    57: aload_0        
        //    58: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //    61: checkcast       Lsun/util/calendar/ZoneInfo;
        //    64: ldc             4
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: invokevirtual   sun/util/calendar/ZoneInfo.getLastRuleInstance:()Linstrumented/java/util/SimpleTimeZone;
        //    72: astore_3       
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: aload_3        
        //    79: ldc             2
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: ifnonnull       129
        //    87: new             Linstrumented/java/util/SimpleTimeZone;
        //    90: dup            
        //    91: aload_0        
        //    92: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //    95: ldc             5
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: invokevirtual   instrumented/java/util/TimeZone.getRawOffset:()I
        //   103: aload_0        
        //   104: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   107: ldc             3
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokevirtual   instrumented/java/util/TimeZone.getID:()Ljava/lang/String;
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokespecial   instrumented/java/util/SimpleTimeZone.<init>:(ILjava/lang/String;)V
        //   123: astore_3       
        //   124: ldc             1
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: aload_0        
        //   130: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   133: astore_2       
        //   134: ldc             3
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: aload_0        
        //   140: aload_3        
        //   141: putfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   144: ldc             3
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: aload_1        
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokevirtual   java/io/ObjectOutputStream.defaultWriteObject:()V
        //   158: aload_1        
        //   159: aload_2        
        //   160: ldc             3
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //   168: aload_2        
        //   169: ldc             2
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: ifnull          187
        //   177: aload_0        
        //   178: aload_2        
        //   179: putfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   182: ldc             3
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: ldc             1
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: return         
        //   193: athrow         
        //   194: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 07 5D 07 00 E4 05 FD 00 5D 07 00 AF 07 02 8A FA 00 13 25 FF 00 05 00 00 00 01 07 00 C2 FF 00 00 00 00 00 01 07 00 E2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  12     194    194    195    Ljava/lang/VirtualMachineError;
        //  12     21     29     35     Ljava/lang/IllegalArgumentException;
        //  0      193    193    194    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0035:
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
    
    private void readObject(final ObjectInputStream p0) throws IOException, ClassNotFoundException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_2        
        //     8: ldc             2
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: invokevirtual   java/io/ObjectInputStream.defaultReadObject:()V
        //    16: aload_0        
        //    17: bipush          17
        //    19: newarray        I
        //    21: putfield        instrumented/java/util/Calendar.stamp:[I
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_0        
        //    30: getfield        instrumented/java/util/Calendar.serialVersionOnStream:I
        //    33: iconst_2       
        //    34: ldc             4
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: if_icmplt       105
        //    42: aload_0        
        //    43: iconst_1       
        //    44: putfield        instrumented/java/util/Calendar.isTimeSet:Z
        //    47: ldc             3
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: aload_0        
        //    53: getfield        instrumented/java/util/Calendar.fields:[I
        //    56: ldc             3
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: ifnonnull       77
        //    64: aload_0        
        //    65: bipush          17
        //    67: newarray        I
        //    69: putfield        instrumented/java/util/Calendar.fields:[I
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: aload_0        
        //    78: getfield        instrumented/java/util/Calendar.isSet:[Z
        //    81: ldc             3
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: ifnonnull       186
        //    89: aload_0        
        //    90: bipush          17
        //    92: newarray        Z
        //    94: putfield        instrumented/java/util/Calendar.isSet:[Z
        //    97: ldc             4
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: goto            186
        //   105: aload_0        
        //   106: getfield        instrumented/java/util/Calendar.serialVersionOnStream:I
        //   109: ldc             3
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: iflt            186
        //   117: iconst_0       
        //   118: istore_3       
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: iload_3        
        //   125: bipush          17
        //   127: ldc             3
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: if_icmpge       186
        //   135: aload_0        
        //   136: getfield        instrumented/java/util/Calendar.stamp:[I
        //   139: iload_3        
        //   140: aload_0        
        //   141: getfield        instrumented/java/util/Calendar.isSet:[Z
        //   144: iload_3        
        //   145: baload         
        //   146: ldc             8
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: ifeq            163
        //   154: iconst_1       
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: goto            169
        //   163: iconst_0       
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: iastore        
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: iinc            3, 1
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: goto            124
        //   186: aload_0        
        //   187: iconst_1       
        //   188: putfield        instrumented/java/util/Calendar.serialVersionOnStream:I
        //   191: ldc             3
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: aconst_null    
        //   197: astore_3       
        //   198: ldc             2
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: new             Linstrumented/java/util/Calendar$1;
        //   206: dup            
        //   207: aload_0        
        //   208: aload_2        
        //   209: ldc             5
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokespecial   instrumented/java/util/Calendar$1.<init>:(Linstrumented/java/util/Calendar;Ljava/io/ObjectInputStream;)V
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: invokestatic    instrumented/java/util/Calendar$CalendarAccessControlContext.access$100:()Ljava/security/AccessControlContext;
        //   225: ldc             1
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedExceptionAction;Ljava/security/AccessControlContext;)Ljava/lang/Object;
        //   233: checkcast       Lsun/util/calendar/ZoneInfo;
        //   236: astore_3       
        //   237: ldc             2
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: ldc             1
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: goto            379
        //   250: astore          4
        //   252: ldc             501
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: aload           4
        //   259: ldc             2
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: invokevirtual   java/security/PrivilegedActionException.getException:()Ljava/lang/Exception;
        //   267: astore          5
        //   269: ldc             1
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: aload           5
        //   276: instanceof      Ljava/io/OptionalDataException;
        //   279: ldc             3
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: ifne            379
        //   287: aload           5
        //   289: instanceof      Ljava/lang/RuntimeException;
        //   292: ldc             3
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: ifeq            311
        //   300: aload           5
        //   302: checkcast       Ljava/lang/RuntimeException;
        //   305: ldc             3
        //   307: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   310: athrow         
        //   311: aload           5
        //   313: instanceof      Ljava/io/IOException;
        //   316: ldc             3
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: ifeq            335
        //   324: aload           5
        //   326: checkcast       Ljava/io/IOException;
        //   329: ldc             3
        //   331: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   334: athrow         
        //   335: aload           5
        //   337: instanceof      Ljava/lang/ClassNotFoundException;
        //   340: ldc             3
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: ifeq            359
        //   348: aload           5
        //   350: checkcast       Ljava/lang/ClassNotFoundException;
        //   353: ldc             3
        //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   358: athrow         
        //   359: new             Ljava/lang/RuntimeException;
        //   362: dup            
        //   363: aload           5
        //   365: ldc             4
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   373: ldc             1
        //   375: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   378: athrow         
        //   379: aload_3        
        //   380: ldc             2
        //   382: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   385: ifnull          398
        //   388: aload_0        
        //   389: aload_3        
        //   390: putfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   393: ldc             3
        //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   398: aload_0        
        //   399: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   402: instanceof      Linstrumented/java/util/SimpleTimeZone;
        //   405: ldc             4
        //   407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   410: ifeq            520
        //   413: aload_0        
        //   414: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   417: ldc             3
        //   419: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   422: invokevirtual   instrumented/java/util/TimeZone.getID:()Ljava/lang/String;
        //   425: astore          4
        //   427: ldc             1
        //   429: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   432: aload           4
        //   434: ldc             2
        //   436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   439: invokestatic    instrumented/java/util/TimeZone.getTimeZone:(Ljava/lang/String;)Linstrumented/java/util/TimeZone;
        //   442: astore          5
        //   444: ldc             1
        //   446: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   449: aload           5
        //   451: ldc             2
        //   453: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   456: ifnull          520
        //   459: aload           5
        //   461: aload_0        
        //   462: getfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   465: ldc             4
        //   467: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   470: invokevirtual   instrumented/java/util/TimeZone.hasSameRules:(Linstrumented/java/util/TimeZone;)Z
        //   473: ldc             1
        //   475: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   478: ifeq            520
        //   481: aload           5
        //   483: ldc             2
        //   485: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   488: invokevirtual   instrumented/java/util/TimeZone.getID:()Ljava/lang/String;
        //   491: aload           4
        //   493: ldc             2
        //   495: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   498: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   501: ldc             1
        //   503: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   506: ifeq            520
        //   509: aload_0        
        //   510: aload           5
        //   512: putfield        instrumented/java/util/Calendar.zone:Linstrumented/java/util/TimeZone;
        //   515: ldc             3
        //   517: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   520: ldc             1
        //   522: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   525: return         
        //   526: athrow         
        //   527: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.ClassNotFoundException
        //    StackMapTable: 00 0F FC 00 4D 07 02 A3 1B FC 00 12 01 FF 00 26 00 04 07 00 02 07 02 A3 07 02 A3 01 00 02 07 02 72 01 FF 00 05 00 04 07 00 02 07 02 A3 07 02 A3 01 00 03 07 02 72 01 01 FA 00 10 FF 00 3F 00 04 07 00 02 07 02 A3 07 02 A3 07 01 4F 00 01 07 02 A1 FD 00 3C 07 02 A1 07 01 F1 17 17 F9 00 13 12 FB 00 79 FF 00 05 00 00 00 01 07 00 C2 FF 00 00 00 00 00 01 07 00 E2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  203    527    527    528    Ljava/lang/VirtualMachineError;
        //  203    242    250    379    Ljava/security/PrivilegedActionException;
        //  0      526    526    527    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0311:
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
    
    public final Instant toInstant() {
        try {
            BytecodeManager.incBytecodes(2);
            final long timeInMillis = this.getTimeInMillis();
            BytecodeManager.incBytecodes(1);
            final Instant ofEpochMilli = Instant.ofEpochMilli(timeInMillis);
            BytecodeManager.incBytecodes(1);
            return ofEpochMilli;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<Calendar> clazz = Calendar.class;
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
            final int n = 3;
            BytecodeManager.incBytecodes(4);
            cachedLocaleData = new ConcurrentHashMap<Locale, int[]>(n);
            BytecodeManager.incBytecodes(1);
            FIELD_NAME = new String[] { "ERA", "YEAR", "MONTH", "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR", "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR", "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET" };
            BytecodeManager.incBytecodes(71);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static class Builder
    {
        private static final int NFIELDS = 18;
        private static final int WEEK_YEAR = 17;
        private long instant;
        private int[] fields;
        private int nextStamp;
        private int maxFieldIndex;
        private String type;
        private TimeZone zone;
        private boolean lenient;
        private Locale locale;
        private int firstDayOfWeek;
        private int minimalDaysInFirstWeek;
        
        public Builder() {
            try {
                BytecodeManager.incBytecodes(2);
                this.lenient = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setInstant(final long instant) {
            try {
                final int[] fields = this.fields;
                BytecodeManager.incBytecodes(3);
                if (fields != null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.instant = instant;
                BytecodeManager.incBytecodes(3);
                this.nextStamp = 1;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setInstant(final Date date) {
            try {
                BytecodeManager.incBytecodes(3);
                final long time = date.getTime();
                BytecodeManager.incBytecodes(1);
                final Builder setInstant = this.setInstant(time);
                BytecodeManager.incBytecodes(1);
                return setInstant;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder set(final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    final int n3 = 17;
                    BytecodeManager.incBytecodes(3);
                    if (n < n3) {
                        BytecodeManager.incBytecodes(2);
                        final boolean instantSet = this.isInstantSet();
                        BytecodeManager.incBytecodes(1);
                        if (instantSet) {
                            final String s = "instant has been set";
                            BytecodeManager.incBytecodes(4);
                            final IllegalStateException ex = new IllegalStateException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        BytecodeManager.incBytecodes(2);
                        this.allocateFields();
                        BytecodeManager.incBytecodes(4);
                        this.internalSet(n, n2);
                        BytecodeManager.incBytecodes(2);
                        return this;
                    }
                }
                final String s2 = "field is invalid";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setFields(final int... array) {
            try {
                final int length = array.length;
                BytecodeManager.incBytecodes(3);
                final int n = length % 2;
                BytecodeManager.incBytecodes(4);
                if (n != 0) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalArgumentException ex = new IllegalArgumentException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                final boolean instantSet = this.isInstantSet();
                BytecodeManager.incBytecodes(1);
                if (instantSet) {
                    final String s = "instant has been set";
                    BytecodeManager.incBytecodes(4);
                    final IllegalStateException ex2 = new IllegalStateException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final int n2 = this.nextStamp + length / 2;
                BytecodeManager.incBytecodes(7);
                if (n2 < 0) {
                    final String s2 = "stamp counter overflow";
                    BytecodeManager.incBytecodes(4);
                    final IllegalStateException ex3 = new IllegalStateException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
                BytecodeManager.incBytecodes(2);
                this.allocateFields();
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                Label_0216: {
                    while (true) {
                        final int n4 = n3;
                        final int n5 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n4 >= n5) {
                            break Label_0216;
                        }
                        final int n6 = array[n3++];
                        BytecodeManager.incBytecodes(5);
                        final int n7 = n6;
                        BytecodeManager.incBytecodes(2);
                        if (n7 < 0) {
                            break;
                        }
                        final int n8 = n6;
                        final int n9 = 17;
                        BytecodeManager.incBytecodes(3);
                        if (n8 >= n9) {
                            break;
                        }
                        final int n10 = n6;
                        final int n11 = array[n3++];
                        BytecodeManager.incBytecodes(7);
                        this.internalSet(n10, n11);
                        BytecodeManager.incBytecodes(1);
                    }
                    final String s3 = "field is invalid";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex4 = new IllegalArgumentException(s3);
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
        
        public Builder setDate(final int n, final int n2, final int n3) {
            try {
                final int[] fields = { 1, n, 2, n2, 5, n3 };
                BytecodeManager.incBytecodes(27);
                final Builder setFields = this.setFields(fields);
                BytecodeManager.incBytecodes(1);
                return setFields;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setTimeOfDay(final int n, final int n2, final int n3) {
            try {
                final int n4 = 0;
                BytecodeManager.incBytecodes(6);
                final Builder setTimeOfDay = this.setTimeOfDay(n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
                return setTimeOfDay;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setTimeOfDay(final int n, final int n2, final int n3, final int n4) {
            try {
                final int[] fields = { 11, n, 12, n2, 13, n3, 14, n4 };
                BytecodeManager.incBytecodes(35);
                final Builder setFields = this.setFields(fields);
                BytecodeManager.incBytecodes(1);
                return setFields;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setWeekDate(final int n, final int n2, final int n3) {
            try {
                BytecodeManager.incBytecodes(2);
                this.allocateFields();
                final int n4 = 17;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n4, n);
                final int n5 = 3;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n5, n2);
                final int n6 = 7;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n6, n3);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setTimeZone(final TimeZone zone) {
            try {
                BytecodeManager.incBytecodes(2);
                if (zone == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.zone = zone;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setLenient(final boolean lenient) {
            try {
                this.lenient = lenient;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setCalendarType(String type) {
            try {
                final String s = type;
                final String anObject = "gregorian";
                BytecodeManager.incBytecodes(3);
                final boolean equals = s.equals(anObject);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    type = "gregory";
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                final Set<String> availableCalendarTypes = Calendar.getAvailableCalendarTypes();
                final String s2 = type;
                BytecodeManager.incBytecodes(2);
                final boolean contains = availableCalendarTypes.contains(s2);
                BytecodeManager.incBytecodes(1);
                if (!contains) {
                    final String s3 = type;
                    final String anObject2 = "iso8601";
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean equals2 = s3.equals(anObject2);
                    BytecodeManager.incBytecodes(1);
                    if (!equals2) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "unknown calendar type: ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final String str2 = type;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(str2);
                        BytecodeManager.incBytecodes(1);
                        final String string = append2.toString();
                        BytecodeManager.incBytecodes(1);
                        final IllegalArgumentException ex = new IllegalArgumentException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
                final String type2 = this.type;
                BytecodeManager.incBytecodes(3);
                if (type2 == null) {
                    this.type = type;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final String type3 = this.type;
                    final String anObject3 = type;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals3 = type3.equals(anObject3);
                    BytecodeManager.incBytecodes(1);
                    if (!equals3) {
                        final String s4 = "calendar type override";
                        BytecodeManager.incBytecodes(4);
                        final IllegalStateException ex2 = new IllegalStateException(s4);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setLocale(final Locale locale) {
            try {
                BytecodeManager.incBytecodes(2);
                if (locale == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.locale = locale;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Builder setWeekDefinition(final int firstDayOfWeek, final int minimalDaysInFirstWeek) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean validWeekParameter = this.isValidWeekParameter(firstDayOfWeek);
                BytecodeManager.incBytecodes(1);
                if (validWeekParameter) {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean validWeekParameter2 = this.isValidWeekParameter(minimalDaysInFirstWeek);
                    BytecodeManager.incBytecodes(1);
                    if (validWeekParameter2) {
                        this.firstDayOfWeek = firstDayOfWeek;
                        BytecodeManager.incBytecodes(3);
                        this.minimalDaysInFirstWeek = minimalDaysInFirstWeek;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        return this;
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
        
        public Calendar build() {
            try {
                final Locale locale = this.locale;
                BytecodeManager.incBytecodes(3);
                if (locale == null) {
                    BytecodeManager.incBytecodes(2);
                    this.locale = Locale.getDefault();
                    BytecodeManager.incBytecodes(1);
                }
                final TimeZone zone = this.zone;
                BytecodeManager.incBytecodes(3);
                if (zone == null) {
                    BytecodeManager.incBytecodes(2);
                    this.zone = TimeZone.getDefault();
                    BytecodeManager.incBytecodes(1);
                }
                final String type = this.type;
                BytecodeManager.incBytecodes(3);
                if (type == null) {
                    final Locale locale2 = this.locale;
                    final String s = "ca";
                    BytecodeManager.incBytecodes(5);
                    this.type = locale2.getUnicodeLocaleType(s);
                    BytecodeManager.incBytecodes(1);
                }
                final String type2 = this.type;
                BytecodeManager.incBytecodes(3);
                Label_0179: {
                    if (type2 == null) {
                        final Locale locale3 = this.locale;
                        BytecodeManager.incBytecodes(3);
                        final String country = locale3.getCountry();
                        final String s2 = "TH";
                        BytecodeManager.incBytecodes(2);
                        if (country == s2) {
                            final Locale locale4 = this.locale;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final String language = locale4.getLanguage();
                            final String s3 = "th";
                            BytecodeManager.incBytecodes(2);
                            if (language == s3) {
                                this.type = "buddhist";
                                BytecodeManager.incBytecodes(4);
                                break Label_0179;
                            }
                        }
                        this.type = "gregory";
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final String type3 = this.type;
                int n = -1;
                final String s4 = type3;
                BytecodeManager.incBytecodes(7);
                final int hashCode = s4.hashCode();
                BytecodeManager.incBytecodes(1);
                switch (hashCode) {
                    case 283776265: {
                        final String s5 = type3;
                        final String anObject = "gregory";
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = s5.equals(anObject);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            n = 0;
                            BytecodeManager.incBytecodes(3);
                            break;
                        }
                        break;
                    }
                    case 2095190916: {
                        final String s6 = type3;
                        final String anObject2 = "iso8601";
                        BytecodeManager.incBytecodes(3);
                        final boolean equals2 = s6.equals(anObject2);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            n = 1;
                            BytecodeManager.incBytecodes(3);
                            break;
                        }
                        break;
                    }
                    case -1581060683: {
                        final String s7 = type3;
                        final String anObject3 = "buddhist";
                        BytecodeManager.incBytecodes(3);
                        final boolean equals3 = s7.equals(anObject3);
                        BytecodeManager.incBytecodes(1);
                        if (equals3) {
                            n = 2;
                            BytecodeManager.incBytecodes(3);
                            break;
                        }
                        break;
                    }
                    case -752730191: {
                        final String s8 = type3;
                        final String anObject4 = "japanese";
                        BytecodeManager.incBytecodes(3);
                        final boolean equals4 = s8.equals(anObject4);
                        BytecodeManager.incBytecodes(1);
                        if (equals4) {
                            n = 3;
                            BytecodeManager.incBytecodes(2);
                            break;
                        }
                        break;
                    }
                }
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                Serializable s9 = null;
                switch (n2) {
                    case 0: {
                        final TimeZone zone2 = this.zone;
                        final Locale locale5 = this.locale;
                        final boolean b = true;
                        BytecodeManager.incBytecodes(8);
                        s9 = new GregorianCalendar(zone2, locale5, b);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 1: {
                        final TimeZone zone3 = this.zone;
                        final Locale locale6 = this.locale;
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(8);
                        final GregorianCalendar gregorianCalendar = new GregorianCalendar(zone3, locale6, b2);
                        BytecodeManager.incBytecodes(1);
                        final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
                        final long n3 = Long.MIN_VALUE;
                        BytecodeManager.incBytecodes(5);
                        final Date gregorianChange = new Date(n3);
                        BytecodeManager.incBytecodes(1);
                        gregorianCalendar2.setGregorianChange(gregorianChange);
                        final int n4 = 2;
                        final int n5 = 4;
                        BytecodeManager.incBytecodes(4);
                        this.setWeekDefinition(n4, n5);
                        BytecodeManager.incBytecodes(1);
                        s9 = gregorianCalendar;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 2: {
                        final TimeZone zone4 = this.zone;
                        final Locale locale7 = this.locale;
                        BytecodeManager.incBytecodes(7);
                        s9 = new BuddhistCalendar(zone4, locale7);
                        BytecodeManager.incBytecodes(1);
                        final Serializable s10 = s9;
                        BytecodeManager.incBytecodes(2);
                        ((Calendar)s10).clear();
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 3: {
                        final TimeZone zone5 = this.zone;
                        final Locale locale8 = this.locale;
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(8);
                        s9 = new JapaneseImperialCalendar(zone5, locale8, b3);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    default: {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "unknown calendar type: ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final String type4 = this.type;
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder append2 = append.append(type4);
                        BytecodeManager.incBytecodes(1);
                        final String string = append2.toString();
                        BytecodeManager.incBytecodes(1);
                        final IllegalArgumentException ex = new IllegalArgumentException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
                final Calendar calendar = (Calendar)s9;
                final boolean lenient = this.lenient;
                BytecodeManager.incBytecodes(4);
                calendar.setLenient(lenient);
                final int firstDayOfWeek = this.firstDayOfWeek;
                BytecodeManager.incBytecodes(3);
                if (firstDayOfWeek != 0) {
                    final Calendar calendar2 = (Calendar)s9;
                    final int firstDayOfWeek2 = this.firstDayOfWeek;
                    BytecodeManager.incBytecodes(4);
                    calendar2.setFirstDayOfWeek(firstDayOfWeek2);
                    final Calendar calendar3 = (Calendar)s9;
                    final int minimalDaysInFirstWeek = this.minimalDaysInFirstWeek;
                    BytecodeManager.incBytecodes(4);
                    calendar3.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
                }
                BytecodeManager.incBytecodes(2);
                final boolean instantSet = this.isInstantSet();
                BytecodeManager.incBytecodes(1);
                if (instantSet) {
                    final Calendar calendar4 = (Calendar)s9;
                    final long instant = this.instant;
                    BytecodeManager.incBytecodes(4);
                    calendar4.setTimeInMillis(instant);
                    final Calendar calendar5 = (Calendar)s9;
                    BytecodeManager.incBytecodes(2);
                    calendar5.complete();
                    final Calendar calendar6 = (Calendar)s9;
                    BytecodeManager.incBytecodes(2);
                    return calendar6;
                }
                final int[] fields = this.fields;
                BytecodeManager.incBytecodes(3);
                if (fields != null) {
                    final int n6 = 17;
                    BytecodeManager.incBytecodes(3);
                    final boolean set = this.isSet(n6);
                    BytecodeManager.incBytecodes(1);
                    int n9 = 0;
                    Label_0815: {
                        if (set) {
                            final int n7 = this.fields[17];
                            final int n8 = this.fields[1];
                            BytecodeManager.incBytecodes(9);
                            if (n7 > n8) {
                                n9 = 1;
                                BytecodeManager.incBytecodes(2);
                                break Label_0815;
                            }
                        }
                        n9 = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n10 = n9;
                    BytecodeManager.incBytecodes(1);
                    final int n11 = n10;
                    BytecodeManager.incBytecodes(2);
                    if (n11 != 0) {
                        final Calendar calendar7 = (Calendar)s9;
                        BytecodeManager.incBytecodes(2);
                        final boolean weekDateSupported = calendar7.isWeekDateSupported();
                        BytecodeManager.incBytecodes(1);
                        if (!weekDateSupported) {
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb2 = new StringBuilder();
                            final String str2 = "week date is unsupported by ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = sb2.append(str2);
                            final String type5 = this.type;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append4 = append3.append(type5);
                            BytecodeManager.incBytecodes(1);
                            final String string2 = append4.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                    int n12 = 2;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n13 = n12;
                        final int nextStamp = this.nextStamp;
                        BytecodeManager.incBytecodes(4);
                        if (n13 >= nextStamp) {
                            break;
                        }
                        int n14 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n15 = n14;
                            final int maxFieldIndex = this.maxFieldIndex;
                            BytecodeManager.incBytecodes(4);
                            if (n15 > maxFieldIndex) {
                                break;
                            }
                            final int n16 = this.fields[n14];
                            final int n17 = n12;
                            BytecodeManager.incBytecodes(6);
                            if (n16 == n17) {
                                final Calendar calendar8 = (Calendar)s9;
                                final int n18 = n14;
                                final int n19 = this.fields[18 + n14];
                                BytecodeManager.incBytecodes(9);
                                calendar8.set(n18, n19);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            ++n14;
                            BytecodeManager.incBytecodes(2);
                        }
                        ++n12;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n20 = n10;
                    BytecodeManager.incBytecodes(2);
                    if (n20 != 0) {
                        final int n21 = 3;
                        BytecodeManager.incBytecodes(3);
                        final boolean set2 = this.isSet(n21);
                        BytecodeManager.incBytecodes(1);
                        int n22;
                        if (set2) {
                            n22 = this.fields[21];
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            n22 = 1;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n23 = n22;
                        BytecodeManager.incBytecodes(1);
                        final int n24 = 7;
                        BytecodeManager.incBytecodes(3);
                        final boolean set3 = this.isSet(n24);
                        BytecodeManager.incBytecodes(1);
                        int firstDayOfWeek3;
                        if (set3) {
                            firstDayOfWeek3 = this.fields[25];
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            final Calendar calendar9 = (Calendar)s9;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            firstDayOfWeek3 = calendar9.getFirstDayOfWeek();
                        }
                        final int n25 = firstDayOfWeek3;
                        BytecodeManager.incBytecodes(1);
                        final Calendar calendar10 = (Calendar)s9;
                        final int n26 = this.fields[35];
                        final int n27 = n23;
                        final int n28 = n25;
                        BytecodeManager.incBytecodes(8);
                        calendar10.setWeekDate(n26, n27, n28);
                    }
                    final Calendar calendar11 = (Calendar)s9;
                    BytecodeManager.incBytecodes(2);
                    calendar11.complete();
                }
                final Calendar calendar12 = (Calendar)s9;
                BytecodeManager.incBytecodes(2);
                return calendar12;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void allocateFields() {
            try {
                final int[] fields = this.fields;
                BytecodeManager.incBytecodes(3);
                if (fields == null) {
                    this.fields = new int[36];
                    BytecodeManager.incBytecodes(3);
                    this.nextStamp = 2;
                    BytecodeManager.incBytecodes(3);
                    this.maxFieldIndex = -1;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void internalSet(final int maxFieldIndex, final int n) {
            try {
                this.fields[maxFieldIndex] = this.nextStamp++;
                BytecodeManager.incBytecodes(11);
                final int nextStamp = this.nextStamp;
                BytecodeManager.incBytecodes(3);
                if (nextStamp < 0) {
                    final String s = "stamp counter overflow";
                    BytecodeManager.incBytecodes(4);
                    final IllegalStateException ex = new IllegalStateException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.fields[18 + maxFieldIndex] = n;
                BytecodeManager.incBytecodes(7);
                final int maxFieldIndex2 = this.maxFieldIndex;
                BytecodeManager.incBytecodes(4);
                if (maxFieldIndex > maxFieldIndex2) {
                    final int n2 = 17;
                    BytecodeManager.incBytecodes(3);
                    if (maxFieldIndex < n2) {
                        this.maxFieldIndex = maxFieldIndex;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private boolean isInstantSet() {
            try {
                final int nextStamp = this.nextStamp;
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (nextStamp == n) {
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
        
        private boolean isSet(final int n) {
            try {
                final int[] fields = this.fields;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0041: {
                    if (fields != null) {
                        final int n2 = this.fields[n];
                        BytecodeManager.incBytecodes(5);
                        if (n2 > 0) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0041;
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
        
        private boolean isValidWeekParameter(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                boolean b = false;
                Label_0035: {
                    if (n > 0) {
                        final int n2 = 7;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0035;
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
    }
    
    private static class AvailableCalendarTypes
    {
        private static final Set<String> SET;
        
        private AvailableCalendarTypes() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Set access$000() {
            try {
                final Set<String> set = AvailableCalendarTypes.SET;
                BytecodeManager.incBytecodes(2);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final int n = 3;
                BytecodeManager.incBytecodes(4);
                final HashSet set = new HashSet<String>(n);
                BytecodeManager.incBytecodes(1);
                final HashSet set2 = set;
                final String s = "gregory";
                BytecodeManager.incBytecodes(3);
                set2.add(s);
                BytecodeManager.incBytecodes(1);
                final HashSet<String> set3 = (HashSet<String>)set;
                final String s2 = "buddhist";
                BytecodeManager.incBytecodes(3);
                set3.add(s2);
                BytecodeManager.incBytecodes(1);
                final HashSet<String> set4 = (HashSet<String>)set;
                final String s3 = "japanese";
                BytecodeManager.incBytecodes(3);
                set4.add(s3);
                BytecodeManager.incBytecodes(1);
                final HashSet<String> set5 = (HashSet<String>)set;
                BytecodeManager.incBytecodes(2);
                SET = Collections.unmodifiableSet((Set<?>)set5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class CalendarAccessControlContext
    {
        private static final AccessControlContext INSTANCE;
        
        private CalendarAccessControlContext() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String name = "accessClassInPackage.sun.util.calendar";
                BytecodeManager.incBytecodes(4);
                final RuntimePermission runtimePermission = new RuntimePermission(name);
                BytecodeManager.incBytecodes(1);
                final RuntimePermission runtimePermission2 = runtimePermission;
                BytecodeManager.incBytecodes(2);
                final PermissionCollection permissionCollection = runtimePermission2.newPermissionCollection();
                BytecodeManager.incBytecodes(1);
                final PermissionCollection collection = permissionCollection;
                final RuntimePermission runtimePermission3 = runtimePermission;
                BytecodeManager.incBytecodes(3);
                collection.add(runtimePermission3);
                final ProtectionDomain[] context = { null };
                final int n = 0;
                final CodeSource codesource = null;
                final PermissionCollection permissions = permissionCollection;
                BytecodeManager.incBytecodes(10);
                context[n] = new ProtectionDomain(codesource, permissions);
                BytecodeManager.incBytecodes(2);
                INSTANCE = new AccessControlContext(context);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
