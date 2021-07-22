// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.time.Instant;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.Era;
import sun.util.calendar.ZoneInfo;
import java.text.DateFormat;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarUtils;
import aic2021.engine.BytecodeManager;
import sun.util.calendar.BaseCalendar;
import java.io.Serializable;

public class Date implements Serializable, Cloneable, Comparable<Date>
{
    private static final BaseCalendar gcal;
    private static BaseCalendar jcal;
    private transient long fastTime;
    private transient BaseCalendar.Date cdate;
    private static int defaultCenturyStart;
    private static final long serialVersionUID = 7523967970034938905L;
    private static final String[] wtb;
    private static final int[] ttb;
    
    public Date() {
        try {
            BytecodeManager.incBytecodes(2);
            final long currentTimeMillis = System.currentTimeMillis();
            BytecodeManager.incBytecodes(1);
            this(currentTimeMillis);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Date(final long fastTime) {
        try {
            BytecodeManager.incBytecodes(2);
            this.fastTime = fastTime;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public Date(final int n, final int n2, final int n3) {
        try {
            final int n4 = 0;
            final int n5 = 0;
            final int n6 = 0;
            BytecodeManager.incBytecodes(8);
            this(n, n2, n3, n4, n5, n6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public Date(final int n, final int n2, final int n3, final int n4, final int n5) {
        try {
            final int n6 = 0;
            BytecodeManager.incBytecodes(8);
            this(n, n2, n3, n4, n5, n6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public Date(final int n, int mod, final int dayOfMonth, final int hours, final int minutes, final int seconds) {
        try {
            BytecodeManager.incBytecodes(2);
            int n2 = n + 1900;
            BytecodeManager.incBytecodes(4);
            final int n3 = mod;
            final int n4 = 12;
            BytecodeManager.incBytecodes(3);
            if (n3 >= n4) {
                n2 += mod / 12;
                BytecodeManager.incBytecodes(6);
                mod %= 12;
                BytecodeManager.incBytecodes(5);
            }
            else {
                final int n5 = mod;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    final int n6 = n2;
                    final int n7 = mod;
                    final int d = 12;
                    BytecodeManager.incBytecodes(4);
                    n2 = n6 + CalendarUtils.floorDivide(n7, d);
                    BytecodeManager.incBytecodes(2);
                    final int x = mod;
                    final int y = 12;
                    BytecodeManager.incBytecodes(3);
                    mod = CalendarUtils.mod(x, y);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n8 = n2;
            BytecodeManager.incBytecodes(2);
            final BaseCalendar calendarSystem = getCalendarSystem(n8);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar = calendarSystem;
            BytecodeManager.incBytecodes(3);
            final TimeZone defaultRef = TimeZone.getDefaultRef();
            BytecodeManager.incBytecodes(1);
            this.cdate = (BaseCalendar.Date)baseCalendar.newCalendarDate(defaultRef);
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date cdate = this.cdate;
            final int normalizedYear = n2;
            final int month = mod + 1;
            BytecodeManager.incBytecodes(8);
            final BaseCalendar.Date setNormalizedDate = cdate.setNormalizedDate(normalizedYear, month, dayOfMonth);
            final int millis = 0;
            BytecodeManager.incBytecodes(5);
            setNormalizedDate.setTimeOfDay(hours, minutes, seconds, millis);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.getTimeImpl();
            BytecodeManager.incBytecodes(1);
            this.cdate = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public Date(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final long parse = parse(s);
            BytecodeManager.incBytecodes(1);
            this(parse);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
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
        //    13: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //    16: checkcast       Linstrumented/java/util/Date;
        //    19: astore_1       
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload_0        
        //    26: getfield        instrumented/java/util/Date.cdate:Lsun/util/calendar/BaseCalendar$Date;
        //    29: ldc             3
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: ifnull          61
        //    37: aload_1        
        //    38: aload_0        
        //    39: getfield        instrumented/java/util/Date.cdate:Lsun/util/calendar/BaseCalendar$Date;
        //    42: ldc             4
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   sun/util/calendar/BaseCalendar$Date.clone:()Ljava/lang/Object;
        //    50: checkcast       Lsun/util/calendar/BaseCalendar$Date;
        //    53: putfield        instrumented/java/util/Date.cdate:Lsun/util/calendar/BaseCalendar$Date;
        //    56: ldc             2
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: ldc             1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: goto            75
        //    69: astore_2       
        //    70: ldc             501
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aload_1        
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: areturn        
        //    82: athrow         
        //    83: athrow         
        //    StackMapTable: 00 05 FC 00 3D 07 00 02 47 07 00 74 05 FF 00 06 00 00 00 01 07 00 36 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  7      83     83     84     Ljava/lang/VirtualMachineError;
        //  7      61     69     75     Ljava/lang/CloneNotSupportedException;
        //  0      82     82     83     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0061:
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
    public static long UTC(final int n, int mod, final int dayOfMonth, final int hours, final int minutes, final int seconds) {
        try {
            int n2 = n + 1900;
            BytecodeManager.incBytecodes(4);
            final int n3 = mod;
            final int n4 = 12;
            BytecodeManager.incBytecodes(3);
            if (n3 >= n4) {
                n2 += mod / 12;
                BytecodeManager.incBytecodes(6);
                mod %= 12;
                BytecodeManager.incBytecodes(5);
            }
            else {
                final int n5 = mod;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    final int n6 = n2;
                    final int n7 = mod;
                    final int d = 12;
                    BytecodeManager.incBytecodes(4);
                    n2 = n6 + CalendarUtils.floorDivide(n7, d);
                    BytecodeManager.incBytecodes(2);
                    final int x = mod;
                    final int y = 12;
                    BytecodeManager.incBytecodes(3);
                    mod = CalendarUtils.mod(x, y);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n8 = mod + 1;
            BytecodeManager.incBytecodes(4);
            final int n9 = n2;
            BytecodeManager.incBytecodes(2);
            final BaseCalendar calendarSystem = getCalendarSystem(n9);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar = calendarSystem;
            final TimeZone timeZone = null;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar.Date date = (BaseCalendar.Date)baseCalendar.newCalendarDate(timeZone);
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date date2 = date;
            final int normalizedYear = n2;
            final int month = n8;
            BytecodeManager.incBytecodes(5);
            final BaseCalendar.Date setNormalizedDate = date2.setNormalizedDate(normalizedYear, month, dayOfMonth);
            final int millis = 0;
            BytecodeManager.incBytecodes(5);
            setNormalizedDate.setTimeOfDay(hours, minutes, seconds, millis);
            BytecodeManager.incBytecodes(1);
            final long n10 = 0L;
            BytecodeManager.incBytecodes(4);
            final Date date3 = new Date(n10);
            BytecodeManager.incBytecodes(1);
            final Date date4 = date3;
            final BaseCalendar.Date date5 = date;
            BytecodeManager.incBytecodes(3);
            date4.normalize(date5);
            BytecodeManager.incBytecodes(1);
            final long fastTime = date3.fastTime;
            BytecodeManager.incBytecodes(3);
            return fastTime;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public static long parse(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: istore_1       
        //     3: ldc             2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: iconst_m1      
        //     9: istore_2       
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: iconst_m1      
        //    16: istore_3       
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: iconst_m1      
        //    23: istore          4
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: iconst_m1      
        //    31: istore          5
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: iconst_m1      
        //    39: istore          6
        //    41: ldc             2
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: iconst_m1      
        //    47: istore          7
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: iconst_m1      
        //    55: istore          8
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: iconst_0       
        //    63: istore          9
        //    65: ldc             2
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: iconst_m1      
        //    71: istore          10
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: iconst_m1      
        //    79: istore          11
        //    81: ldc             2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: iconst_m1      
        //    87: istore          12
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: iconst_0       
        //    95: istore          13
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: aload_0        
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: ifnonnull       119
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: goto            1890
        //   119: aload_0        
        //   120: ldc             2
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: invokevirtual   java/lang/String.length:()I
        //   128: istore          14
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: iload           9
        //   137: iload           14
        //   139: ldc             3
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: if_icmpge       1458
        //   147: aload_0        
        //   148: iload           9
        //   150: ldc             3
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokevirtual   java/lang/String.charAt:(I)C
        //   158: istore          8
        //   160: ldc             1
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: iinc            9, 1
        //   168: ldc             1
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: iload           8
        //   175: bipush          32
        //   177: ldc             3
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: if_icmple       135
        //   185: iload           8
        //   187: bipush          44
        //   189: ldc             3
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: if_icmpne       205
        //   197: ldc             1
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: goto            135
        //   205: iload           8
        //   207: bipush          40
        //   209: ldc             3
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: if_icmpne       319
        //   217: iconst_1       
        //   218: istore          15
        //   220: ldc             2
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: iload           9
        //   227: iload           14
        //   229: ldc             3
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: if_icmpge       135
        //   237: aload_0        
        //   238: iload           9
        //   240: ldc             3
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: invokevirtual   java/lang/String.charAt:(I)C
        //   248: istore          8
        //   250: ldc             1
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: iinc            9, 1
        //   258: ldc             1
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: iload           8
        //   265: bipush          40
        //   267: ldc             3
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: if_icmpne       286
        //   275: iinc            15, 1
        //   278: ldc             2
        //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   283: goto            225
        //   286: iload           8
        //   288: bipush          41
        //   290: ldc             3
        //   292: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   295: if_icmpne       225
        //   298: iinc            15, -1
        //   301: iload           15
        //   303: ldc             3
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: ifgt            225
        //   311: ldc             1
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: goto            135
        //   319: bipush          48
        //   321: iload           8
        //   323: ldc             3
        //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   328: if_icmpgt       973
        //   331: iload           8
        //   333: bipush          57
        //   335: ldc             3
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: if_icmpgt       973
        //   343: iload           8
        //   345: bipush          48
        //   347: isub           
        //   348: istore          10
        //   350: ldc             4
        //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   355: iload           9
        //   357: iload           14
        //   359: ldc             3
        //   361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   364: if_icmpge       432
        //   367: bipush          48
        //   369: aload_0        
        //   370: iload           9
        //   372: ldc             4
        //   374: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   377: invokevirtual   java/lang/String.charAt:(I)C
        //   380: dup            
        //   381: istore          8
        //   383: ldc             3
        //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   388: if_icmpgt       432
        //   391: iload           8
        //   393: bipush          57
        //   395: ldc             3
        //   397: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   400: if_icmpgt       432
        //   403: iload           10
        //   405: bipush          10
        //   407: imul           
        //   408: iload           8
        //   410: iadd           
        //   411: bipush          48
        //   413: isub           
        //   414: istore          10
        //   416: ldc             8
        //   418: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   421: iinc            9, 1
        //   424: ldc             2
        //   426: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   429: goto            355
        //   432: iload           13
        //   434: bipush          43
        //   436: ldc             3
        //   438: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   441: if_icmpeq       467
        //   444: iload           13
        //   446: bipush          45
        //   448: ldc             3
        //   450: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   453: if_icmpne       578
        //   456: iload_1        
        //   457: ldc             -2147483648
        //   459: ldc             3
        //   461: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   464: if_icmpeq       578
        //   467: iload           10
        //   469: bipush          24
        //   471: ldc             3
        //   473: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   476: if_icmpge       494
        //   479: iload           10
        //   481: bipush          60
        //   483: imul           
        //   484: istore          10
        //   486: ldc             5
        //   488: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   491: goto            515
        //   494: iload           10
        //   496: bipush          100
        //   498: irem           
        //   499: iload           10
        //   501: bipush          100
        //   503: idiv           
        //   504: bipush          60
        //   506: imul           
        //   507: iadd           
        //   508: istore          10
        //   510: ldc             10
        //   512: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   515: iload           13
        //   517: bipush          43
        //   519: ldc             3
        //   521: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   524: if_icmpne       537
        //   527: iload           10
        //   529: ineg           
        //   530: istore          10
        //   532: ldc             3
        //   534: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   537: iload           12
        //   539: ldc             2
        //   541: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   544: ifeq            566
        //   547: iload           12
        //   549: iconst_m1      
        //   550: ldc             3
        //   552: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   555: if_icmpeq       566
        //   558: ldc             1
        //   560: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   563: goto            1890
        //   566: iload           10
        //   568: istore          12
        //   570: ldc             3
        //   572: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   575: goto            962
        //   578: iload           10
        //   580: bipush          70
        //   582: ldc             3
        //   584: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   587: if_icmplt       668
        //   590: iload_1        
        //   591: ldc             -2147483648
        //   593: ldc             3
        //   595: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   598: if_icmpeq       609
        //   601: ldc             1
        //   603: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   606: goto            1890
        //   609: iload           8
        //   611: bipush          32
        //   613: ldc             3
        //   615: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   618: if_icmple       657
        //   621: iload           8
        //   623: bipush          44
        //   625: ldc             3
        //   627: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   630: if_icmpeq       657
        //   633: iload           8
        //   635: bipush          47
        //   637: ldc             3
        //   639: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   642: if_icmpeq       657
        //   645: iload           9
        //   647: iload           14
        //   649: ldc             3
        //   651: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   654: if_icmplt       1890
        //   657: iload           10
        //   659: istore_1       
        //   660: ldc             3
        //   662: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   665: goto            962
        //   668: iload           8
        //   670: bipush          58
        //   672: ldc             3
        //   674: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   677: if_icmpne       726
        //   680: iload           4
        //   682: ldc             2
        //   684: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   687: ifge            703
        //   690: iload           10
        //   692: i2b            
        //   693: istore          4
        //   695: ldc             4
        //   697: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   700: goto            962
        //   703: iload           5
        //   705: ldc             2
        //   707: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   710: ifge            1890
        //   713: iload           10
        //   715: i2b            
        //   716: istore          5
        //   718: ldc             4
        //   720: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   723: goto            962
        //   726: iload           8
        //   728: bipush          47
        //   730: ldc             3
        //   732: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   735: if_icmpne       782
        //   738: iload_2        
        //   739: ldc             2
        //   741: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   744: ifge            761
        //   747: iload           10
        //   749: iconst_1       
        //   750: isub           
        //   751: i2b            
        //   752: istore_2       
        //   753: ldc             6
        //   755: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   758: goto            962
        //   761: iload_3        
        //   762: ldc             2
        //   764: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   767: ifge            1890
        //   770: iload           10
        //   772: i2b            
        //   773: istore_3       
        //   774: ldc             4
        //   776: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   779: goto            962
        //   782: iload           9
        //   784: iload           14
        //   786: ldc             3
        //   788: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   791: if_icmpge       838
        //   794: iload           8
        //   796: bipush          44
        //   798: ldc             3
        //   800: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   803: if_icmpeq       838
        //   806: iload           8
        //   808: bipush          32
        //   810: ldc             3
        //   812: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   815: if_icmple       838
        //   818: iload           8
        //   820: bipush          45
        //   822: ldc             3
        //   824: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   827: if_icmpeq       838
        //   830: ldc             1
        //   832: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   835: goto            1890
        //   838: iload           4
        //   840: ldc             2
        //   842: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   845: iflt            871
        //   848: iload           5
        //   850: ldc             2
        //   852: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   855: ifge            871
        //   858: iload           10
        //   860: i2b            
        //   861: istore          5
        //   863: ldc             4
        //   865: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   868: goto            962
        //   871: iload           5
        //   873: ldc             2
        //   875: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   878: iflt            904
        //   881: iload           6
        //   883: ldc             2
        //   885: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   888: ifge            904
        //   891: iload           10
        //   893: i2b            
        //   894: istore          6
        //   896: ldc             4
        //   898: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   901: goto            962
        //   904: iload_3        
        //   905: ldc             2
        //   907: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   910: ifge            925
        //   913: iload           10
        //   915: i2b            
        //   916: istore_3       
        //   917: ldc             4
        //   919: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   922: goto            962
        //   925: iload_1        
        //   926: ldc             -2147483648
        //   928: ldc             3
        //   930: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   933: if_icmpne       1890
        //   936: iload_2        
        //   937: ldc             2
        //   939: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   942: iflt            1890
        //   945: iload_3        
        //   946: ldc             2
        //   948: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   951: iflt            1890
        //   954: iload           10
        //   956: istore_1       
        //   957: ldc             2
        //   959: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   962: iconst_0       
        //   963: istore          13
        //   965: ldc             3
        //   967: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   970: goto            135
        //   973: iload           8
        //   975: bipush          47
        //   977: ldc             3
        //   979: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   982: if_icmpeq       1021
        //   985: iload           8
        //   987: bipush          58
        //   989: ldc             3
        //   991: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   994: if_icmpeq       1021
        //   997: iload           8
        //   999: bipush          43
        //  1001: ldc             3
        //  1003: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1006: if_icmpeq       1021
        //  1009: iload           8
        //  1011: bipush          45
        //  1013: ldc             3
        //  1015: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1018: if_icmpne       1033
        //  1021: iload           8
        //  1023: istore          13
        //  1025: ldc             3
        //  1027: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1030: goto            135
        //  1033: iload           9
        //  1035: iconst_1       
        //  1036: isub           
        //  1037: istore          15
        //  1039: ldc             4
        //  1041: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1044: iload           9
        //  1046: iload           14
        //  1048: ldc             3
        //  1050: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1053: if_icmpge       1141
        //  1056: aload_0        
        //  1057: iload           9
        //  1059: ldc             3
        //  1061: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1064: invokevirtual   java/lang/String.charAt:(I)C
        //  1067: istore          8
        //  1069: ldc             1
        //  1071: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1074: bipush          65
        //  1076: iload           8
        //  1078: ldc             3
        //  1080: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1083: if_icmpgt       1098
        //  1086: iload           8
        //  1088: bipush          90
        //  1090: ldc             3
        //  1092: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1095: if_icmple       1130
        //  1098: bipush          97
        //  1100: iload           8
        //  1102: ldc             3
        //  1104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1107: if_icmpgt       1141
        //  1110: iload           8
        //  1112: bipush          122
        //  1114: ldc             3
        //  1116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1119: if_icmple       1130
        //  1122: ldc             1
        //  1124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1127: goto            1141
        //  1130: iinc            9, 1
        //  1133: ldc             2
        //  1135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1138: goto            1044
        //  1141: iload           9
        //  1143: iload           15
        //  1145: iconst_1       
        //  1146: iadd           
        //  1147: ldc             5
        //  1149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1152: if_icmpgt       1163
        //  1155: ldc             1
        //  1157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1160: goto            1890
        //  1163: getstatic       instrumented/java/util/Date.wtb:[Ljava/lang/String;
        //  1166: arraylength    
        //  1167: istore          16
        //  1169: ldc             3
        //  1171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1174: iinc            16, -1
        //  1177: iload           16
        //  1179: ldc             3
        //  1181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1184: iflt            1424
        //  1187: getstatic       instrumented/java/util/Date.wtb:[Ljava/lang/String;
        //  1190: iload           16
        //  1192: aaload         
        //  1193: iconst_1       
        //  1194: iconst_0       
        //  1195: aload_0        
        //  1196: iload           15
        //  1198: iload           9
        //  1200: iload           15
        //  1202: isub           
        //  1203: ldc             11
        //  1205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1208: invokevirtual   java/lang/String.regionMatches:(ZILjava/lang/String;II)Z
        //  1211: ldc             1
        //  1213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1216: ifeq            1174
        //  1219: getstatic       instrumented/java/util/Date.ttb:[I
        //  1222: iload           16
        //  1224: iaload         
        //  1225: istore          17
        //  1227: ldc             4
        //  1229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1232: iload           17
        //  1234: ldc             2
        //  1236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1239: ifeq            1424
        //  1242: iload           17
        //  1244: iconst_1       
        //  1245: ldc             3
        //  1247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1250: if_icmpne       1307
        //  1253: iload           4
        //  1255: bipush          12
        //  1257: ldc             3
        //  1259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1262: if_icmpgt       1890
        //  1265: iload           4
        //  1267: iconst_1       
        //  1268: ldc             3
        //  1270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1273: if_icmpge       1284
        //  1276: ldc             1
        //  1278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1281: goto            1890
        //  1284: iload           4
        //  1286: bipush          12
        //  1288: ldc             3
        //  1290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1293: if_icmpge       1424
        //  1296: iinc            4, 12
        //  1299: ldc             2
        //  1301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1304: goto            1424
        //  1307: iload           17
        //  1309: bipush          14
        //  1311: ldc             3
        //  1313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1316: if_icmpne       1373
        //  1319: iload           4
        //  1321: bipush          12
        //  1323: ldc             3
        //  1325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1328: if_icmpgt       1890
        //  1331: iload           4
        //  1333: iconst_1       
        //  1334: ldc             3
        //  1336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1339: if_icmpge       1350
        //  1342: ldc             1
        //  1344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1347: goto            1890
        //  1350: iload           4
        //  1352: bipush          12
        //  1354: ldc             3
        //  1356: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1359: if_icmpne       1424
        //  1362: iconst_0       
        //  1363: istore          4
        //  1365: ldc             3
        //  1367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1370: goto            1424
        //  1373: iload           17
        //  1375: bipush          13
        //  1377: ldc             3
        //  1379: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1382: if_icmpgt       1408
        //  1385: iload_2        
        //  1386: ldc             2
        //  1388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1391: ifge            1890
        //  1394: iload           17
        //  1396: iconst_2       
        //  1397: isub           
        //  1398: i2b            
        //  1399: istore_2       
        //  1400: ldc             6
        //  1402: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1405: goto            1424
        //  1408: iload           17
        //  1410: sipush          10000
        //  1413: isub           
        //  1414: istore          12
        //  1416: ldc             5
        //  1418: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1421: goto            1424
        //  1424: iload           16
        //  1426: ldc             2
        //  1428: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1431: ifge            1442
        //  1434: ldc             1
        //  1436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1439: goto            1890
        //  1442: iconst_0       
        //  1443: istore          13
        //  1445: ldc             2
        //  1447: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1450: ldc             1
        //  1452: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1455: goto            135
        //  1458: iload_1        
        //  1459: ldc             -2147483648
        //  1461: ldc             3
        //  1463: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1466: if_icmpeq       1890
        //  1469: iload_2        
        //  1470: ldc             2
        //  1472: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1475: iflt            1890
        //  1478: iload_3        
        //  1479: ldc             2
        //  1481: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1484: ifge            1495
        //  1487: ldc             1
        //  1489: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1492: goto            1890
        //  1495: iload_1        
        //  1496: bipush          100
        //  1498: ldc             3
        //  1500: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1503: if_icmpge       1629
        //  1506: ldc             Linstrumented/java/util/Date;.class
        //  1508: dup            
        //  1509: astore          15
        //  1511: pop            
        //  1512: ldc             4
        //  1514: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1517: getstatic       instrumented/java/util/Date.defaultCenturyStart:I
        //  1520: ldc             2
        //  1522: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1525: ifne            1558
        //  1528: getstatic       instrumented/java/util/Date.gcal:Lsun/util/calendar/BaseCalendar;
        //  1531: ldc             2
        //  1533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1536: invokevirtual   sun/util/calendar/BaseCalendar.getCalendarDate:()Lsun/util/calendar/CalendarDate;
        //  1539: ldc             1
        //  1541: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1544: invokevirtual   sun/util/calendar/CalendarDate.getYear:()I
        //  1547: bipush          80
        //  1549: isub           
        //  1550: putstatic       instrumented/java/util/Date.defaultCenturyStart:I
        //  1553: ldc             3
        //  1555: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1558: aload           15
        //  1560: pop            
        //  1561: ldc             2
        //  1563: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1566: ldc             1
        //  1568: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1571: goto            1592
        //  1574: astore          18
        //  1576: aload           15
        //  1578: pop            
        //  1579: ldc             503
        //  1581: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1584: aload           18
        //  1586: ldc             2
        //  1588: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1591: athrow         
        //  1592: iload_1        
        //  1593: getstatic       instrumented/java/util/Date.defaultCenturyStart:I
        //  1596: bipush          100
        //  1598: idiv           
        //  1599: bipush          100
        //  1601: imul           
        //  1602: iadd           
        //  1603: istore_1       
        //  1604: ldc             8
        //  1606: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1609: iload_1        
        //  1610: getstatic       instrumented/java/util/Date.defaultCenturyStart:I
        //  1613: ldc             3
        //  1615: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1618: if_icmpge       1629
        //  1621: iinc            1, 100
        //  1624: ldc             1
        //  1626: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1629: iload           6
        //  1631: ldc             2
        //  1633: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1636: ifge            1647
        //  1639: iconst_0       
        //  1640: istore          6
        //  1642: ldc             2
        //  1644: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1647: iload           5
        //  1649: ldc             2
        //  1651: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1654: ifge            1665
        //  1657: iconst_0       
        //  1658: istore          5
        //  1660: ldc             2
        //  1662: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1665: iload           4
        //  1667: ldc             2
        //  1669: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1672: ifge            1683
        //  1675: iconst_0       
        //  1676: istore          4
        //  1678: ldc             2
        //  1680: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1683: iload_1        
        //  1684: ldc             2
        //  1686: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1689: invokestatic    instrumented/java/util/Date.getCalendarSystem:(I)Lsun/util/calendar/BaseCalendar;
        //  1692: astore          15
        //  1694: ldc             1
        //  1696: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1699: iload           12
        //  1701: iconst_m1      
        //  1702: ldc             3
        //  1704: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1707: if_icmpne       1800
        //  1710: aload           15
        //  1712: ldc             2
        //  1714: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1717: invokestatic    instrumented/java/util/TimeZone.getDefaultRef:()Linstrumented/java/util/TimeZone;
        //  1720: ldc             1
        //  1722: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1725: invokevirtual   sun/util/calendar/BaseCalendar.newCalendarDate:(Linstrumented/java/util/TimeZone;)Lsun/util/calendar/CalendarDate;
        //  1728: checkcast       Lsun/util/calendar/BaseCalendar$Date;
        //  1731: astore          16
        //  1733: ldc             2
        //  1735: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1738: aload           16
        //  1740: iload_1        
        //  1741: iload_2        
        //  1742: iconst_1       
        //  1743: iadd           
        //  1744: iload_3        
        //  1745: ldc             7
        //  1747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1750: invokevirtual   sun/util/calendar/BaseCalendar$Date.setDate:(III)Lsun/util/calendar/CalendarDate;
        //  1753: pop            
        //  1754: ldc             1
        //  1756: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1759: aload           16
        //  1761: iload           4
        //  1763: iload           5
        //  1765: iload           6
        //  1767: iconst_0       
        //  1768: ldc             6
        //  1770: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1773: invokevirtual   sun/util/calendar/BaseCalendar$Date.setTimeOfDay:(IIII)Lsun/util/calendar/CalendarDate;
        //  1776: pop            
        //  1777: ldc             1
        //  1779: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1782: aload           15
        //  1784: aload           16
        //  1786: ldc             3
        //  1788: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1791: invokevirtual   sun/util/calendar/BaseCalendar.getTime:(Lsun/util/calendar/CalendarDate;)J
        //  1794: ldc             1
        //  1796: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1799: lreturn        
        //  1800: aload           15
        //  1802: aconst_null    
        //  1803: ldc             3
        //  1805: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1808: invokevirtual   sun/util/calendar/BaseCalendar.newCalendarDate:(Linstrumented/java/util/TimeZone;)Lsun/util/calendar/CalendarDate;
        //  1811: checkcast       Lsun/util/calendar/BaseCalendar$Date;
        //  1814: astore          16
        //  1816: ldc             2
        //  1818: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1821: aload           16
        //  1823: iload_1        
        //  1824: iload_2        
        //  1825: iconst_1       
        //  1826: iadd           
        //  1827: iload_3        
        //  1828: ldc             7
        //  1830: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1833: invokevirtual   sun/util/calendar/BaseCalendar$Date.setDate:(III)Lsun/util/calendar/CalendarDate;
        //  1836: pop            
        //  1837: ldc             1
        //  1839: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1842: aload           16
        //  1844: iload           4
        //  1846: iload           5
        //  1848: iload           6
        //  1850: iconst_0       
        //  1851: ldc             6
        //  1853: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1856: invokevirtual   sun/util/calendar/BaseCalendar$Date.setTimeOfDay:(IIII)Lsun/util/calendar/CalendarDate;
        //  1859: pop            
        //  1860: ldc             1
        //  1862: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1865: aload           15
        //  1867: aload           16
        //  1869: ldc             3
        //  1871: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1874: invokevirtual   sun/util/calendar/BaseCalendar.getTime:(Lsun/util/calendar/CalendarDate;)J
        //  1877: iload           12
        //  1879: ldc             60000
        //  1881: imul           
        //  1882: i2l            
        //  1883: ladd           
        //  1884: ldc             6
        //  1886: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1889: lreturn        
        //  1890: new             Ljava/lang/IllegalArgumentException;
        //  1893: dup            
        //  1894: ldc             3
        //  1896: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1899: invokespecial   java/lang/IllegalArgumentException.<init>:()V
        //  1902: ldc             1
        //  1904: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1907: athrow         
        //  1908: athrow         
        //  1909: athrow         
        //    StackMapTable: 00 37 FF 00 77 00 0E 07 00 81 01 01 01 01 01 01 01 01 01 01 01 01 01 00 00 FC 00 0F 01 FB 00 45 FC 00 13 01 3C FA 00 20 23 FB 00 4C 22 1A 14 15 1C 0B 1E 2F 0A 22 16 22 14 37 20 20 14 24 0A 2F 0B FC 00 0A 01 35 1F 0A 15 FC 00 0A 01 FC 00 6D 01 16 2A 16 22 FA 00 0F 11 F9 00 0F 24 FC 00 3E 07 00 05 4F 07 00 36 FA 00 11 24 11 11 11 FC 00 74 07 00 10 F9 00 59 FF 00 11 00 00 00 01 07 00 36 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  1517   1909   1909   1910   Ljava/lang/VirtualMachineError;
        //  1517   1566   1574   1592   Any
        //  1574   1584   1574   1592   Any
        //  0      1908   1908   1909   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_1558:
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
    public int getYear() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int n = normalize.getYear() - 1900;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void setYear(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date calendarDate = this.getCalendarDate();
            final int normalizedYear = n + 1900;
            BytecodeManager.incBytecodes(4);
            calendarDate.setNormalizedYear(normalizedYear);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public int getMonth() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int n = normalize.getMonth() - 1;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void setMonth(int mod) {
        try {
            int floorDivide = 0;
            BytecodeManager.incBytecodes(2);
            final int n = mod;
            final int n2 = 12;
            BytecodeManager.incBytecodes(3);
            if (n >= n2) {
                floorDivide = mod / 12;
                BytecodeManager.incBytecodes(4);
                mod %= 12;
                BytecodeManager.incBytecodes(5);
            }
            else {
                final int n3 = mod;
                BytecodeManager.incBytecodes(2);
                if (n3 < 0) {
                    final int n4 = mod;
                    final int d = 12;
                    BytecodeManager.incBytecodes(3);
                    floorDivide = CalendarUtils.floorDivide(n4, d);
                    BytecodeManager.incBytecodes(1);
                    final int x = mod;
                    final int y = 12;
                    BytecodeManager.incBytecodes(3);
                    mod = CalendarUtils.mod(x, y);
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date calendarDate = this.getCalendarDate();
            BytecodeManager.incBytecodes(1);
            final int n5 = floorDivide;
            BytecodeManager.incBytecodes(2);
            if (n5 != 0) {
                final BaseCalendar.Date date = calendarDate;
                final BaseCalendar.Date date2 = calendarDate;
                BytecodeManager.incBytecodes(3);
                final int normalizedYear = date2.getNormalizedYear() + floorDivide;
                BytecodeManager.incBytecodes(3);
                date.setNormalizedYear(normalizedYear);
            }
            final BaseCalendar.Date date3 = calendarDate;
            final int month = mod + 1;
            BytecodeManager.incBytecodes(5);
            date3.setMonth(month);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public int getDate() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int dayOfMonth = normalize.getDayOfMonth();
            BytecodeManager.incBytecodes(1);
            return dayOfMonth;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void setDate(final int dayOfMonth) {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date calendarDate = this.getCalendarDate();
            BytecodeManager.incBytecodes(2);
            calendarDate.setDayOfMonth(dayOfMonth);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public int getDay() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int n = normalize.getDayOfWeek() - 1;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public int getHours() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int hours = normalize.getHours();
            BytecodeManager.incBytecodes(1);
            return hours;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void setHours(final int hours) {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date calendarDate = this.getCalendarDate();
            BytecodeManager.incBytecodes(2);
            calendarDate.setHours(hours);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public int getMinutes() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int minutes = normalize.getMinutes();
            BytecodeManager.incBytecodes(1);
            return minutes;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void setMinutes(final int minutes) {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date calendarDate = this.getCalendarDate();
            BytecodeManager.incBytecodes(2);
            calendarDate.setMinutes(minutes);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public int getSeconds() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int seconds = normalize.getSeconds();
            BytecodeManager.incBytecodes(1);
            return seconds;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void setSeconds(final int seconds) {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date calendarDate = this.getCalendarDate();
            BytecodeManager.incBytecodes(2);
            calendarDate.setSeconds(seconds);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getTime() {
        try {
            BytecodeManager.incBytecodes(2);
            final long timeImpl = this.getTimeImpl();
            BytecodeManager.incBytecodes(1);
            return timeImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final long getTimeImpl() {
        try {
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            if (cdate != null) {
                final BaseCalendar.Date cdate2 = this.cdate;
                BytecodeManager.incBytecodes(3);
                final boolean normalized = cdate2.isNormalized();
                BytecodeManager.incBytecodes(1);
                if (!normalized) {
                    BytecodeManager.incBytecodes(2);
                    this.normalize();
                    BytecodeManager.incBytecodes(1);
                }
            }
            final long fastTime = this.fastTime;
            BytecodeManager.incBytecodes(3);
            return fastTime;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setTime(final long fastTime) {
        try {
            this.fastTime = fastTime;
            BytecodeManager.incBytecodes(3);
            this.cdate = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean before(final Date date) {
        try {
            BytecodeManager.incBytecodes(2);
            final long millis = getMillisOf(this);
            BytecodeManager.incBytecodes(2);
            final long n = lcmp(millis, getMillisOf(date));
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (n < 0) {
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
    
    public boolean after(final Date date) {
        try {
            BytecodeManager.incBytecodes(2);
            final long millis = getMillisOf(this);
            BytecodeManager.incBytecodes(2);
            final long n = lcmp(millis, getMillisOf(date));
            BytecodeManager.incBytecodes(2);
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
    
    @Override
    public boolean equals(final Object o) {
        try {
            final boolean b = o instanceof Date;
            BytecodeManager.incBytecodes(3);
            boolean b2 = false;
            Label_0057: {
                if (b) {
                    BytecodeManager.incBytecodes(2);
                    final long time = this.getTime();
                    final Date date = (Date)o;
                    BytecodeManager.incBytecodes(3);
                    final long n = lcmp(time, date.getTime());
                    BytecodeManager.incBytecodes(2);
                    if (n == 0) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0057;
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
    
    static final long getMillisOf(final Date date) {
        try {
            final BaseCalendar.Date cdate = date.cdate;
            BytecodeManager.incBytecodes(3);
            if (cdate != null) {
                final BaseCalendar.Date cdate2 = date.cdate;
                BytecodeManager.incBytecodes(3);
                final boolean normalized = cdate2.isNormalized();
                BytecodeManager.incBytecodes(1);
                if (!normalized) {
                    final BaseCalendar.Date cdate3 = date.cdate;
                    BytecodeManager.incBytecodes(3);
                    final BaseCalendar.Date date2 = (BaseCalendar.Date)cdate3.clone();
                    BytecodeManager.incBytecodes(2);
                    final BaseCalendar gcal = Date.gcal;
                    final BaseCalendar.Date date3 = date2;
                    BytecodeManager.incBytecodes(3);
                    final long time = gcal.getTime(date3);
                    BytecodeManager.incBytecodes(1);
                    return time;
                }
            }
            final long fastTime = date.fastTime;
            BytecodeManager.incBytecodes(3);
            return fastTime;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int compareTo(final Date date) {
        try {
            BytecodeManager.incBytecodes(2);
            final long millis = getMillisOf(this);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final long millis2 = getMillisOf(date);
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(millis, millis2);
            BytecodeManager.incBytecodes(4);
            int n2;
            if (n < 0) {
                n2 = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final long n3 = lcmp(millis, millis2);
                BytecodeManager.incBytecodes(4);
                if (n3 == 0) {
                    n2 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n2 = 1;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            BytecodeManager.incBytecodes(2);
            final long time = this.getTime();
            BytecodeManager.incBytecodes(1);
            final int n = (int)time ^ (int)(time >> 32);
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date normalize = this.normalize();
            BytecodeManager.incBytecodes(1);
            final int capacity = 28;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date = normalize;
            BytecodeManager.incBytecodes(2);
            int dayOfWeek = date.getDayOfWeek();
            BytecodeManager.incBytecodes(1);
            final int n = dayOfWeek;
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                dayOfWeek = 8;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb2 = sb;
            final String s = Date.wtb[dayOfWeek];
            BytecodeManager.incBytecodes(5);
            final StringBuilder convertToAbbr = convertToAbbr(sb2, s);
            final char c = ' ';
            BytecodeManager.incBytecodes(2);
            convertToAbbr.append(c);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb3 = sb;
            final String[] wtb = Date.wtb;
            final BaseCalendar.Date date2 = normalize;
            BytecodeManager.incBytecodes(4);
            final String s2 = wtb[date2.getMonth() - 1 + 2 + 7];
            BytecodeManager.incBytecodes(8);
            final StringBuilder convertToAbbr2 = convertToAbbr(sb3, s2);
            final char c2 = ' ';
            BytecodeManager.incBytecodes(2);
            convertToAbbr2.append(c2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb4 = sb;
            final BaseCalendar.Date date3 = normalize;
            BytecodeManager.incBytecodes(3);
            final int dayOfMonth = date3.getDayOfMonth();
            final int width = 2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder sprintf0d = CalendarUtils.sprintf0d(sb4, dayOfMonth, width);
            final char c3 = ' ';
            BytecodeManager.incBytecodes(2);
            sprintf0d.append(c3);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb5 = sb;
            final BaseCalendar.Date date4 = normalize;
            BytecodeManager.incBytecodes(3);
            final int hours = date4.getHours();
            final int width2 = 2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder sprintf0d2 = CalendarUtils.sprintf0d(sb5, hours, width2);
            final char c4 = ':';
            BytecodeManager.incBytecodes(2);
            sprintf0d2.append(c4);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb6 = sb;
            final BaseCalendar.Date date5 = normalize;
            BytecodeManager.incBytecodes(3);
            final int minutes = date5.getMinutes();
            final int width3 = 2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder sprintf0d3 = CalendarUtils.sprintf0d(sb6, minutes, width3);
            final char c5 = ':';
            BytecodeManager.incBytecodes(2);
            sprintf0d3.append(c5);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb7 = sb;
            final BaseCalendar.Date date6 = normalize;
            BytecodeManager.incBytecodes(3);
            final int seconds = date6.getSeconds();
            final int width4 = 2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder sprintf0d4 = CalendarUtils.sprintf0d(sb7, seconds, width4);
            final char c6 = ' ';
            BytecodeManager.incBytecodes(2);
            sprintf0d4.append(c6);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date7 = normalize;
            BytecodeManager.incBytecodes(2);
            final TimeZone zone = date7.getZone();
            BytecodeManager.incBytecodes(1);
            final TimeZone timeZone = zone;
            BytecodeManager.incBytecodes(2);
            if (timeZone != null) {
                final StringBuilder sb8 = sb;
                final TimeZone timeZone2 = zone;
                final BaseCalendar.Date date8 = normalize;
                BytecodeManager.incBytecodes(4);
                final boolean daylightTime = date8.isDaylightTime();
                final int n3 = 0;
                final Locale us = Locale.US;
                BytecodeManager.incBytecodes(3);
                final String displayName = timeZone2.getDisplayName(daylightTime, n3, us);
                BytecodeManager.incBytecodes(1);
                sb8.append(displayName);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final StringBuilder sb9 = sb;
                final String str = "GMT";
                BytecodeManager.incBytecodes(3);
                sb9.append(str);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder sb10 = sb;
            final char c7 = ' ';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb10.append(c7);
            final BaseCalendar.Date date9 = normalize;
            BytecodeManager.incBytecodes(2);
            final int year = date9.getYear();
            BytecodeManager.incBytecodes(1);
            append.append(year);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb11 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb11.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final StringBuilder convertToAbbr(final StringBuilder sb, final String s) {
        try {
            final int index = 0;
            BytecodeManager.incBytecodes(4);
            final char char1 = s.charAt(index);
            BytecodeManager.incBytecodes(1);
            final char upperCase = Character.toUpperCase(char1);
            BytecodeManager.incBytecodes(1);
            sb.append(upperCase);
            BytecodeManager.incBytecodes(1);
            final int index2 = 1;
            BytecodeManager.incBytecodes(4);
            final char char2 = s.charAt(index2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(char2);
            final int index3 = 2;
            BytecodeManager.incBytecodes(3);
            final char char3 = s.charAt(index3);
            BytecodeManager.incBytecodes(1);
            append.append(char3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            return sb;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public String toLocaleString() {
        try {
            BytecodeManager.incBytecodes(1);
            final DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
            BytecodeManager.incBytecodes(1);
            final DateFormat dateFormat = dateTimeInstance;
            BytecodeManager.incBytecodes(3);
            final String format = dateFormat.format(this);
            BytecodeManager.incBytecodes(1);
            return format;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public String toGMTString() {
        try {
            BytecodeManager.incBytecodes(2);
            final long time = this.getTime();
            BytecodeManager.incBytecodes(1);
            final long n = time;
            BytecodeManager.incBytecodes(2);
            final BaseCalendar calendarSystem = getCalendarSystem(n);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar = calendarSystem;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final long time2 = this.getTime();
            final TimeZone timeZone = null;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar.Date date = (BaseCalendar.Date)baseCalendar.getCalendarDate(time2, timeZone);
            BytecodeManager.incBytecodes(2);
            final int capacity = 32;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final BaseCalendar.Date date2 = date;
            BytecodeManager.incBytecodes(3);
            final int dayOfMonth = date2.getDayOfMonth();
            final int width = 1;
            BytecodeManager.incBytecodes(2);
            final StringBuilder sprintf0d = CalendarUtils.sprintf0d(sb2, dayOfMonth, width);
            final char c = ' ';
            BytecodeManager.incBytecodes(2);
            sprintf0d.append(c);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb3 = sb;
            final String[] wtb = Date.wtb;
            final BaseCalendar.Date date3 = date;
            BytecodeManager.incBytecodes(4);
            final String s = wtb[date3.getMonth() - 1 + 2 + 7];
            BytecodeManager.incBytecodes(8);
            final StringBuilder convertToAbbr = convertToAbbr(sb3, s);
            final char c2 = ' ';
            BytecodeManager.incBytecodes(2);
            convertToAbbr.append(c2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb4 = sb;
            final BaseCalendar.Date date4 = date;
            BytecodeManager.incBytecodes(3);
            final int year = date4.getYear();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb4.append(year);
            final char c3 = ' ';
            BytecodeManager.incBytecodes(2);
            append.append(c3);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb5 = sb;
            final BaseCalendar.Date date5 = date;
            BytecodeManager.incBytecodes(3);
            final int hours = date5.getHours();
            final int width2 = 2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder sprintf0d2 = CalendarUtils.sprintf0d(sb5, hours, width2);
            final char c4 = ':';
            BytecodeManager.incBytecodes(2);
            sprintf0d2.append(c4);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb6 = sb;
            final BaseCalendar.Date date6 = date;
            BytecodeManager.incBytecodes(3);
            final int minutes = date6.getMinutes();
            final int width3 = 2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder sprintf0d3 = CalendarUtils.sprintf0d(sb6, minutes, width3);
            final char c5 = ':';
            BytecodeManager.incBytecodes(2);
            sprintf0d3.append(c5);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb7 = sb;
            final BaseCalendar.Date date7 = date;
            BytecodeManager.incBytecodes(3);
            final int seconds = date7.getSeconds();
            final int width4 = 2;
            BytecodeManager.incBytecodes(2);
            CalendarUtils.sprintf0d(sb7, seconds, width4);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb8 = sb;
            final String str = " GMT";
            BytecodeManager.incBytecodes(3);
            sb8.append(str);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb9 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb9.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public int getTimezoneOffset() {
        try {
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            int n;
            if (cdate == null) {
                BytecodeManager.incBytecodes(1);
                final TimeZone defaultRef = TimeZone.getDefaultRef();
                BytecodeManager.incBytecodes(1);
                final boolean b = defaultRef instanceof ZoneInfo;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final ZoneInfo zoneInfo = (ZoneInfo)defaultRef;
                    final long fastTime = this.fastTime;
                    final int[] offsets = null;
                    BytecodeManager.incBytecodes(6);
                    n = zoneInfo.getOffsets(fastTime, offsets);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final TimeZone timeZone = defaultRef;
                    final long fastTime2 = this.fastTime;
                    BytecodeManager.incBytecodes(4);
                    n = timeZone.getOffset(fastTime2);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(2);
                this.normalize();
                BytecodeManager.incBytecodes(1);
                final BaseCalendar.Date cdate2 = this.cdate;
                BytecodeManager.incBytecodes(3);
                n = cdate2.getZoneOffset();
                BytecodeManager.incBytecodes(1);
            }
            final int n2 = -n / 60000;
            BytecodeManager.incBytecodes(5);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final BaseCalendar.Date getCalendarDate() {
        try {
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            if (cdate == null) {
                final long fastTime = this.fastTime;
                BytecodeManager.incBytecodes(3);
                final BaseCalendar calendarSystem = getCalendarSystem(fastTime);
                BytecodeManager.incBytecodes(1);
                final BaseCalendar baseCalendar = calendarSystem;
                final long fastTime2 = this.fastTime;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final TimeZone defaultRef = TimeZone.getDefaultRef();
                BytecodeManager.incBytecodes(1);
                this.cdate = (BaseCalendar.Date)baseCalendar.getCalendarDate(fastTime2, defaultRef);
                BytecodeManager.incBytecodes(2);
            }
            final BaseCalendar.Date cdate2 = this.cdate;
            BytecodeManager.incBytecodes(3);
            return cdate2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final BaseCalendar.Date normalize() {
        try {
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            if (cdate == null) {
                final long fastTime = this.fastTime;
                BytecodeManager.incBytecodes(3);
                final BaseCalendar calendarSystem = getCalendarSystem(fastTime);
                BytecodeManager.incBytecodes(1);
                final BaseCalendar baseCalendar = calendarSystem;
                final long fastTime2 = this.fastTime;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final TimeZone defaultRef = TimeZone.getDefaultRef();
                BytecodeManager.incBytecodes(1);
                this.cdate = (BaseCalendar.Date)baseCalendar.getCalendarDate(fastTime2, defaultRef);
                BytecodeManager.incBytecodes(2);
                final BaseCalendar.Date cdate2 = this.cdate;
                BytecodeManager.incBytecodes(3);
                return cdate2;
            }
            final BaseCalendar.Date cdate3 = this.cdate;
            BytecodeManager.incBytecodes(3);
            final boolean normalized = cdate3.isNormalized();
            BytecodeManager.incBytecodes(1);
            if (!normalized) {
                final BaseCalendar.Date cdate4 = this.cdate;
                BytecodeManager.incBytecodes(5);
                this.cdate = this.normalize(cdate4);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final TimeZone defaultRef2 = TimeZone.getDefaultRef();
            BytecodeManager.incBytecodes(1);
            final TimeZone timeZone = defaultRef2;
            final BaseCalendar.Date cdate5 = this.cdate;
            BytecodeManager.incBytecodes(4);
            final TimeZone zone = cdate5.getZone();
            BytecodeManager.incBytecodes(1);
            if (timeZone != zone) {
                final BaseCalendar.Date cdate6 = this.cdate;
                final TimeZone zone2 = defaultRef2;
                BytecodeManager.incBytecodes(4);
                cdate6.setZone(zone2);
                BytecodeManager.incBytecodes(1);
                final BaseCalendar.Date cdate7 = this.cdate;
                BytecodeManager.incBytecodes(3);
                final BaseCalendar calendarSystem2 = getCalendarSystem(cdate7);
                BytecodeManager.incBytecodes(1);
                final BaseCalendar baseCalendar2 = calendarSystem2;
                final long fastTime3 = this.fastTime;
                final BaseCalendar.Date cdate8 = this.cdate;
                BytecodeManager.incBytecodes(6);
                baseCalendar2.getCalendarDate(fastTime3, cdate8);
                BytecodeManager.incBytecodes(1);
            }
            final BaseCalendar.Date cdate9 = this.cdate;
            BytecodeManager.incBytecodes(3);
            return cdate9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final BaseCalendar.Date normalize(BaseCalendar.Date date) {
        try {
            final BaseCalendar.Date date2 = date;
            BytecodeManager.incBytecodes(2);
            final int normalizedYear = date2.getNormalizedYear();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date3 = date;
            BytecodeManager.incBytecodes(2);
            final int month = date3.getMonth();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date4 = date;
            BytecodeManager.incBytecodes(2);
            final int dayOfMonth = date4.getDayOfMonth();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date5 = date;
            BytecodeManager.incBytecodes(2);
            final int hours = date5.getHours();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date6 = date;
            BytecodeManager.incBytecodes(2);
            final int minutes = date6.getMinutes();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date7 = date;
            BytecodeManager.incBytecodes(2);
            final int seconds = date7.getSeconds();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date8 = date;
            BytecodeManager.incBytecodes(2);
            final int millis = date8.getMillis();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date9 = date;
            BytecodeManager.incBytecodes(2);
            TimeZone timeZone = date9.getZone();
            BytecodeManager.incBytecodes(1);
            final int n = normalizedYear;
            final int n2 = 1582;
            BytecodeManager.incBytecodes(3);
            if (n != n2) {
                final int n3 = normalizedYear;
                final int n4 = 280000000;
                BytecodeManager.incBytecodes(3);
                if (n3 <= n4) {
                    final int n5 = normalizedYear;
                    final int n6 = -280000000;
                    BytecodeManager.incBytecodes(3);
                    if (n5 >= n6) {
                        final int n7 = normalizedYear;
                        BytecodeManager.incBytecodes(2);
                        final BaseCalendar calendarSystem = getCalendarSystem(n7);
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar baseCalendar = calendarSystem;
                        final BaseCalendar.Date date10 = date;
                        BytecodeManager.incBytecodes(3);
                        final BaseCalendar calendarSystem2 = getCalendarSystem(date10);
                        BytecodeManager.incBytecodes(1);
                        if (baseCalendar != calendarSystem2) {
                            final BaseCalendar baseCalendar2 = calendarSystem;
                            final TimeZone timeZone2 = timeZone;
                            BytecodeManager.incBytecodes(3);
                            date = (BaseCalendar.Date)baseCalendar2.newCalendarDate(timeZone2);
                            BytecodeManager.incBytecodes(2);
                            final BaseCalendar.Date date11 = date;
                            final int normalizedYear2 = normalizedYear;
                            final int month2 = month;
                            final int dayOfMonth2 = dayOfMonth;
                            BytecodeManager.incBytecodes(5);
                            final BaseCalendar.Date setNormalizedDate = date11.setNormalizedDate(normalizedYear2, month2, dayOfMonth2);
                            final int hours2 = hours;
                            final int minutes2 = minutes;
                            final int seconds2 = seconds;
                            final int millis2 = millis;
                            BytecodeManager.incBytecodes(5);
                            setNormalizedDate.setTimeOfDay(hours2, minutes2, seconds2, millis2);
                            BytecodeManager.incBytecodes(1);
                        }
                        final BaseCalendar baseCalendar3 = calendarSystem;
                        final BaseCalendar.Date date12 = date;
                        BytecodeManager.incBytecodes(4);
                        this.fastTime = baseCalendar3.getTime(date12);
                        BytecodeManager.incBytecodes(1);
                        final long fastTime = this.fastTime;
                        BytecodeManager.incBytecodes(3);
                        final BaseCalendar calendarSystem3 = getCalendarSystem(fastTime);
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar baseCalendar4 = calendarSystem3;
                        final BaseCalendar baseCalendar5 = calendarSystem;
                        BytecodeManager.incBytecodes(3);
                        if (baseCalendar4 != baseCalendar5) {
                            final BaseCalendar baseCalendar6 = calendarSystem3;
                            final TimeZone timeZone3 = timeZone;
                            BytecodeManager.incBytecodes(3);
                            date = (BaseCalendar.Date)baseCalendar6.newCalendarDate(timeZone3);
                            BytecodeManager.incBytecodes(2);
                            final BaseCalendar.Date date13 = date;
                            final int normalizedYear3 = normalizedYear;
                            final int month3 = month;
                            final int dayOfMonth3 = dayOfMonth;
                            BytecodeManager.incBytecodes(5);
                            final BaseCalendar.Date setNormalizedDate2 = date13.setNormalizedDate(normalizedYear3, month3, dayOfMonth3);
                            final int hours3 = hours;
                            final int minutes3 = minutes;
                            final int seconds3 = seconds;
                            final int millis3 = millis;
                            BytecodeManager.incBytecodes(5);
                            setNormalizedDate2.setTimeOfDay(hours3, minutes3, seconds3, millis3);
                            BytecodeManager.incBytecodes(1);
                            final BaseCalendar baseCalendar7 = calendarSystem3;
                            final BaseCalendar.Date date14 = date;
                            BytecodeManager.incBytecodes(4);
                            this.fastTime = baseCalendar7.getTime(date14);
                            BytecodeManager.incBytecodes(1);
                        }
                        final BaseCalendar.Date date15 = date;
                        BytecodeManager.incBytecodes(2);
                        return date15;
                    }
                }
            }
            final TimeZone timeZone4 = timeZone;
            BytecodeManager.incBytecodes(2);
            if (timeZone4 == null) {
                final String s = "GMT";
                BytecodeManager.incBytecodes(2);
                timeZone = TimeZone.getTimeZone(s);
                BytecodeManager.incBytecodes(1);
            }
            final TimeZone timeZone5 = timeZone;
            BytecodeManager.incBytecodes(4);
            final GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone5);
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
            BytecodeManager.incBytecodes(2);
            gregorianCalendar2.clear();
            final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
            final int n8 = 14;
            final int n9 = millis;
            BytecodeManager.incBytecodes(4);
            gregorianCalendar3.set(n8, n9);
            final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
            final int n10 = normalizedYear;
            final int n11 = month - 1;
            final int n12 = dayOfMonth;
            final int n13 = hours;
            final int n14 = minutes;
            final int n15 = seconds;
            BytecodeManager.incBytecodes(10);
            gregorianCalendar4.set(n10, n11, n12, n13, n14, n15);
            final GregorianCalendar gregorianCalendar5 = gregorianCalendar;
            BytecodeManager.incBytecodes(3);
            this.fastTime = gregorianCalendar5.getTimeInMillis();
            BytecodeManager.incBytecodes(1);
            final long fastTime2 = this.fastTime;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar calendarSystem4 = getCalendarSystem(fastTime2);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar8 = calendarSystem4;
            final long fastTime3 = this.fastTime;
            final TimeZone timeZone6 = timeZone;
            BytecodeManager.incBytecodes(5);
            date = (BaseCalendar.Date)baseCalendar8.getCalendarDate(fastTime3, timeZone6);
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date date16 = date;
            BytecodeManager.incBytecodes(2);
            return date16;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final BaseCalendar getCalendarSystem(final int n) {
        try {
            final int n2 = 1582;
            BytecodeManager.incBytecodes(3);
            if (n >= n2) {
                final BaseCalendar gcal = Date.gcal;
                BytecodeManager.incBytecodes(2);
                return gcal;
            }
            BytecodeManager.incBytecodes(1);
            final BaseCalendar julianCalendar = getJulianCalendar();
            BytecodeManager.incBytecodes(1);
            return julianCalendar;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final BaseCalendar getCalendarSystem(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                final long n3 = -12219292800000L;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final TimeZone defaultRef = TimeZone.getDefaultRef();
                BytecodeManager.incBytecodes(2);
                final long n4 = lcmp(n, n3 - defaultRef.getOffset(n));
                BytecodeManager.incBytecodes(4);
                if (n4 < 0) {
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar julianCalendar = getJulianCalendar();
                    BytecodeManager.incBytecodes(1);
                    return julianCalendar;
                }
            }
            final BaseCalendar gcal = Date.gcal;
            BytecodeManager.incBytecodes(2);
            return gcal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final BaseCalendar getCalendarSystem(final BaseCalendar.Date date) {
        try {
            final BaseCalendar jcal = Date.jcal;
            BytecodeManager.incBytecodes(2);
            if (jcal == null) {
                final BaseCalendar gcal = Date.gcal;
                BytecodeManager.incBytecodes(2);
                return gcal;
            }
            BytecodeManager.incBytecodes(2);
            final Era era = date.getEra();
            BytecodeManager.incBytecodes(1);
            if (era != null) {
                final BaseCalendar jcal2 = Date.jcal;
                BytecodeManager.incBytecodes(2);
                return jcal2;
            }
            final BaseCalendar gcal2 = Date.gcal;
            BytecodeManager.incBytecodes(2);
            return gcal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final synchronized BaseCalendar getJulianCalendar() {
        try {
            final BaseCalendar jcal = Date.jcal;
            BytecodeManager.incBytecodes(2);
            if (jcal == null) {
                final String calendarName = "julian";
                BytecodeManager.incBytecodes(2);
                Date.jcal = (BaseCalendar)CalendarSystem.forName(calendarName);
                BytecodeManager.incBytecodes(2);
            }
            final BaseCalendar jcal2 = Date.jcal;
            BytecodeManager.incBytecodes(2);
            return jcal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            final long timeImpl = this.getTimeImpl();
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeLong(timeImpl);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(3);
            this.fastTime = objectInputStream.readLong();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Date from(final Instant instant) {
        try {
            try {
                BytecodeManager.incBytecodes(4);
                final long epochMilli = instant.toEpochMilli();
                BytecodeManager.incBytecodes(1);
                final Date date = new Date(epochMilli);
                BytecodeManager.incBytecodes(1);
                return date;
            }
            catch (ArithmeticException ex) {
                BytecodeManager.incBytecodes(501);
                final ArithmeticException cause = ex;
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(cause);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public Instant toInstant() {
        try {
            BytecodeManager.incBytecodes(2);
            final long time = this.getTime();
            BytecodeManager.incBytecodes(1);
            final Instant ofEpochMilli = Instant.ofEpochMilli(time);
            BytecodeManager.incBytecodes(1);
            return ofEpochMilli;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            gcal = CalendarSystem.getGregorianCalendar();
            BytecodeManager.incBytecodes(1);
            wtb = new String[] { "am", "pm", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "gmt", "ut", "utc", "est", "edt", "cst", "cdt", "mst", "mdt", "pst", "pdt" };
            BytecodeManager.incBytecodes(130);
            ttb = new int[] { 14, 1, 0, 0, 0, 0, 0, 0, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 10000, 10000, 10000, 10300, 10240, 10360, 10300, 10420, 10360, 10480, 10420 };
            BytecodeManager.incBytecodes(131);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
