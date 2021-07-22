// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarUtils;
import aic2021.engine.BytecodeManager;
import sun.util.calendar.Gregorian;

public class SimpleTimeZone extends TimeZone
{
    private int startMonth;
    private int startDay;
    private int startDayOfWeek;
    private int startTime;
    private int startTimeMode;
    private int endMonth;
    private int endDay;
    private int endDayOfWeek;
    private int endTime;
    private int endTimeMode;
    private int startYear;
    private int rawOffset;
    private boolean useDaylight;
    private static final int millisPerHour = 3600000;
    private static final int millisPerDay = 86400000;
    private final byte[] monthLength;
    private static final byte[] staticMonthLength;
    private static final byte[] staticLeapMonthLength;
    private int startMode;
    private int endMode;
    private int dstSavings;
    private static final Gregorian gcal;
    private transient long cacheYear;
    private transient long cacheStart;
    private transient long cacheEnd;
    private static final int DOM_MODE = 1;
    private static final int DOW_IN_MONTH_MODE = 2;
    private static final int DOW_GE_DOM_MODE = 3;
    private static final int DOW_LE_DOM_MODE = 4;
    public static final int WALL_TIME = 0;
    public static final int STANDARD_TIME = 1;
    public static final int UTC_TIME = 2;
    static final long serialVersionUID = -403250971215465050L;
    static final int currentSerialVersion = 2;
    private int serialVersionOnStream;
    
    public SimpleTimeZone(final int rawOffset, final String id) {
        try {
            BytecodeManager.incBytecodes(2);
            this.useDaylight = false;
            BytecodeManager.incBytecodes(3);
            this.monthLength = SimpleTimeZone.staticMonthLength;
            BytecodeManager.incBytecodes(3);
            this.serialVersionOnStream = 2;
            BytecodeManager.incBytecodes(3);
            this.rawOffset = rawOffset;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.setID(id);
            this.dstSavings = 3600000;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public SimpleTimeZone(final int n, final String s, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) {
        try {
            final int n10 = 0;
            final int n11 = 0;
            final int n12 = 3600000;
            BytecodeManager.incBytecodes(15);
            this(n, s, n2, n3, n4, n5, n10, n6, n7, n8, n9, n11, n12);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public SimpleTimeZone(final int n, final String s, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10) {
        try {
            final int n11 = 0;
            final int n12 = 0;
            BytecodeManager.incBytecodes(15);
            this(n, s, n2, n3, n4, n5, n11, n6, n7, n8, n9, n12, n10);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public SimpleTimeZone(final int rawOffset, final String id, final int startMonth, final int startDay, final int startDayOfWeek, final int startTime, final int startTimeMode, final int endMonth, final int endDay, final int endDayOfWeek, final int endTime, final int endTimeMode, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.useDaylight = false;
            BytecodeManager.incBytecodes(3);
            this.monthLength = SimpleTimeZone.staticMonthLength;
            BytecodeManager.incBytecodes(3);
            this.serialVersionOnStream = 2;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.setID(id);
            this.rawOffset = rawOffset;
            BytecodeManager.incBytecodes(3);
            this.startMonth = startMonth;
            BytecodeManager.incBytecodes(3);
            this.startDay = startDay;
            BytecodeManager.incBytecodes(3);
            this.startDayOfWeek = startDayOfWeek;
            BytecodeManager.incBytecodes(3);
            this.startTime = startTime;
            BytecodeManager.incBytecodes(3);
            this.startTimeMode = startTimeMode;
            BytecodeManager.incBytecodes(3);
            this.endMonth = endMonth;
            BytecodeManager.incBytecodes(3);
            this.endDay = endDay;
            BytecodeManager.incBytecodes(3);
            this.endDayOfWeek = endDayOfWeek;
            BytecodeManager.incBytecodes(3);
            this.endTime = endTime;
            BytecodeManager.incBytecodes(3);
            this.endTimeMode = endTimeMode;
            BytecodeManager.incBytecodes(3);
            this.dstSavings = n;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.decodeRules();
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal daylight saving value: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(n);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setStartYear(final int startYear) {
        try {
            this.startYear = startYear;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.invalidateCache();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setStartRule(final int startMonth, final int startDay, final int startDayOfWeek, final int startTime) {
        try {
            this.startMonth = startMonth;
            BytecodeManager.incBytecodes(3);
            this.startDay = startDay;
            BytecodeManager.incBytecodes(3);
            this.startDayOfWeek = startDayOfWeek;
            BytecodeManager.incBytecodes(3);
            this.startTime = startTime;
            BytecodeManager.incBytecodes(3);
            this.startTimeMode = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.decodeStartRule();
            BytecodeManager.incBytecodes(2);
            this.invalidateCache();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setStartRule(final int n, final int n2, final int n3) {
        try {
            final int n4 = 0;
            BytecodeManager.incBytecodes(6);
            this.setStartRule(n, n2, n4, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setStartRule(final int n, final int n2, final int n3, final int n4, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (b) {
                final int n5 = -n3;
                BytecodeManager.incBytecodes(7);
                this.setStartRule(n, n2, n5, n4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n6 = -n2;
                final int n7 = -n3;
                BytecodeManager.incBytecodes(8);
                this.setStartRule(n, n6, n7, n4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setEndRule(final int endMonth, final int endDay, final int endDayOfWeek, final int endTime) {
        try {
            this.endMonth = endMonth;
            BytecodeManager.incBytecodes(3);
            this.endDay = endDay;
            BytecodeManager.incBytecodes(3);
            this.endDayOfWeek = endDayOfWeek;
            BytecodeManager.incBytecodes(3);
            this.endTime = endTime;
            BytecodeManager.incBytecodes(3);
            this.endTimeMode = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.decodeEndRule();
            BytecodeManager.incBytecodes(2);
            this.invalidateCache();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setEndRule(final int n, final int n2, final int n3) {
        try {
            final int n4 = 0;
            BytecodeManager.incBytecodes(6);
            this.setEndRule(n, n2, n4, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setEndRule(final int n, final int n2, final int n3, final int n4, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (b) {
                final int n5 = -n3;
                BytecodeManager.incBytecodes(7);
                this.setEndRule(n, n2, n5, n4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n6 = -n2;
                final int n7 = -n3;
                BytecodeManager.incBytecodes(8);
                this.setEndRule(n, n6, n7, n4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getOffset(final long n) {
        try {
            final int[] array = null;
            BytecodeManager.incBytecodes(4);
            final int offsets = this.getOffsets(n, array);
            BytecodeManager.incBytecodes(1);
            return offsets;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    int getOffsets(final long p0, final int[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: istore          4
        //     6: ldc             3
        //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    11: aload_0        
        //    12: getfield        instrumented/java/util/SimpleTimeZone.useDaylight:Z
        //    15: ldc             3
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: ifeq            315
        //    23: aload_0        
        //    24: dup            
        //    25: astore          5
        //    27: pop            
        //    28: ldc             4
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: aload_0        
        //    34: getfield        instrumented/java/util/SimpleTimeZone.cacheStart:J
        //    37: lconst_0       
        //    38: lcmp           
        //    39: ldc             5
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: ifeq            105
        //    47: lload_1        
        //    48: aload_0        
        //    49: getfield        instrumented/java/util/SimpleTimeZone.cacheStart:J
        //    52: lcmp           
        //    53: ldc             5
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: iflt            105
        //    61: lload_1        
        //    62: aload_0        
        //    63: getfield        instrumented/java/util/SimpleTimeZone.cacheEnd:J
        //    66: lcmp           
        //    67: ldc             5
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: ifge            105
        //    75: iload           4
        //    77: aload_0        
        //    78: getfield        instrumented/java/util/SimpleTimeZone.dstSavings:I
        //    81: iadd           
        //    82: istore          4
        //    84: ldc             5
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload           5
        //    91: pop            
        //    92: ldc             2
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: goto            315
        //   105: aload           5
        //   107: pop            
        //   108: ldc             2
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: ldc             1
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: goto            139
        //   121: astore          6
        //   123: aload           5
        //   125: pop            
        //   126: ldc             503
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload           6
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: athrow         
        //   139: lload_1        
        //   140: ldc2_w          -12219292800000
        //   143: lcmp           
        //   144: ldc             4
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: iflt            163
        //   152: getstatic       instrumented/java/util/SimpleTimeZone.gcal:Lsun/util/calendar/Gregorian;
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: goto            186
        //   163: ldc             "julian"
        //   165: ldc             1
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokestatic    sun/util/calendar/CalendarSystem.forName:(Ljava/lang/String;)Lsun/util/calendar/CalendarSystem;
        //   178: checkcast       Lsun/util/calendar/BaseCalendar;
        //   181: ldc             1
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: astore          5
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: aload           5
        //   195: getstatic       instrumented/java/util/TimeZone.NO_TIMEZONE:Linstrumented/java/util/TimeZone;
        //   198: ldc             3
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: invokevirtual   sun/util/calendar/BaseCalendar.newCalendarDate:(Linstrumented/java/util/TimeZone;)Lsun/util/calendar/CalendarDate;
        //   206: checkcast       Lsun/util/calendar/BaseCalendar$Date;
        //   209: astore          6
        //   211: ldc             2
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: aload           5
        //   218: lload_1        
        //   219: aload_0        
        //   220: getfield        instrumented/java/util/SimpleTimeZone.rawOffset:I
        //   223: i2l            
        //   224: ladd           
        //   225: aload           6
        //   227: ldc             8
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: invokevirtual   sun/util/calendar/BaseCalendar.getCalendarDate:(JLsun/util/calendar/CalendarDate;)Lsun/util/calendar/CalendarDate;
        //   235: pop            
        //   236: ldc             1
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: aload           6
        //   243: ldc             2
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: invokevirtual   sun/util/calendar/BaseCalendar$Date.getNormalizedYear:()I
        //   251: istore          7
        //   253: ldc             1
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: iload           7
        //   260: aload_0        
        //   261: getfield        instrumented/java/util/SimpleTimeZone.startYear:I
        //   264: ldc             4
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: if_icmplt       315
        //   272: aload           6
        //   274: iconst_0       
        //   275: iconst_0       
        //   276: iconst_0       
        //   277: iconst_0       
        //   278: ldc             6
        //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   283: invokevirtual   sun/util/calendar/BaseCalendar$Date.setTimeOfDay:(IIII)Lsun/util/calendar/CalendarDate;
        //   286: pop            
        //   287: ldc             1
        //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   292: aload_0        
        //   293: aload           5
        //   295: aload           6
        //   297: iload           7
        //   299: lload_1        
        //   300: ldc             6
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: invokespecial   instrumented/java/util/SimpleTimeZone.getOffset:(Lsun/util/calendar/BaseCalendar;Lsun/util/calendar/BaseCalendar$Date;IJ)I
        //   308: istore          4
        //   310: ldc             1
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: aload_3        
        //   316: ldc             2
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: ifnull          351
        //   324: aload_3        
        //   325: iconst_0       
        //   326: aload_0        
        //   327: getfield        instrumented/java/util/SimpleTimeZone.rawOffset:I
        //   330: iastore        
        //   331: ldc             5
        //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   336: aload_3        
        //   337: iconst_1       
        //   338: iload           4
        //   340: aload_0        
        //   341: getfield        instrumented/java/util/SimpleTimeZone.rawOffset:I
        //   344: isub           
        //   345: iastore        
        //   346: ldc             7
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: iload           4
        //   353: ldc             2
        //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   358: ireturn        
        //   359: athrow         
        //   360: athrow         
        //    StackMapTable: 00 09 FD 00 69 01 07 00 B2 4F 07 00 58 FA 00 11 17 56 07 00 09 FB 00 80 23 FF 00 07 00 00 00 01 07 00 58 FF 00 00 00 00 00 01 07 00 AC
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  33     360    360    361    Ljava/lang/VirtualMachineError;
        //  33     97     121    139    Any
        //  105    113    121    139    Any
        //  121    131    121    139    Any
        //  0      359    359    360    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0105:
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
    public int getOffset(final int i, final int n, final int n2, final int n3, final int n4, final int n5) {
        try {
            final int n6 = 1;
            BytecodeManager.incBytecodes(3);
            if (i != n6) {
                BytecodeManager.incBytecodes(2);
                if (i != 0) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Illegal era ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(i);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex = new IllegalArgumentException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            int n7 = n;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (i == 0) {
                n7 = 1 - n7;
                BytecodeManager.incBytecodes(4);
            }
            final int n8 = n7;
            final int n9 = 292278994;
            BytecodeManager.incBytecodes(3);
            if (n8 >= n9) {
                n7 = 2800 + n7 % 2800;
                BytecodeManager.incBytecodes(7);
            }
            else {
                final int n10 = n7;
                final int n11 = -292269054;
                BytecodeManager.incBytecodes(3);
                if (n10 <= n11) {
                    final long x = n7;
                    final long y = 28L;
                    BytecodeManager.incBytecodes(4);
                    n7 = (int)CalendarUtils.mod(x, y);
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n12 = n2 + 1;
            BytecodeManager.incBytecodes(4);
            BaseCalendar gcal = SimpleTimeZone.gcal;
            BytecodeManager.incBytecodes(2);
            final BaseCalendar baseCalendar = gcal;
            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
            BytecodeManager.incBytecodes(3);
            BaseCalendar.Date date = (BaseCalendar.Date)baseCalendar.newCalendarDate(no_TIMEZONE);
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date date2 = date;
            final int year = n7;
            final int month = n12;
            BytecodeManager.incBytecodes(5);
            date2.setDate(year, month, n3);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar2 = gcal;
            final BaseCalendar.Date date3 = date;
            BytecodeManager.incBytecodes(3);
            final long time = baseCalendar2.getTime(date3);
            BytecodeManager.incBytecodes(1);
            long n13 = time + (n5 - this.rawOffset);
            BytecodeManager.incBytecodes(8);
            final long n14 = lcmp(n13, -12219292800000L);
            BytecodeManager.incBytecodes(4);
            if (n14 < 0) {
                final String calendarName = "julian";
                BytecodeManager.incBytecodes(2);
                gcal = (BaseCalendar)CalendarSystem.forName(calendarName);
                BytecodeManager.incBytecodes(2);
                final BaseCalendar baseCalendar3 = gcal;
                final TimeZone no_TIMEZONE2 = TimeZone.NO_TIMEZONE;
                BytecodeManager.incBytecodes(3);
                date = (BaseCalendar.Date)baseCalendar3.newCalendarDate(no_TIMEZONE2);
                BytecodeManager.incBytecodes(2);
                final BaseCalendar.Date date4 = date;
                final int normalizedYear = n7;
                final int month2 = n12;
                BytecodeManager.incBytecodes(5);
                date4.setNormalizedDate(normalizedYear, month2, n3);
                BytecodeManager.incBytecodes(1);
                final BaseCalendar baseCalendar4 = gcal;
                final BaseCalendar.Date date5 = date;
                BytecodeManager.incBytecodes(3);
                n13 = baseCalendar4.getTime(date5) + n5 - this.rawOffset;
                BytecodeManager.incBytecodes(8);
            }
            final BaseCalendar.Date date6 = date;
            BytecodeManager.incBytecodes(2);
            final int normalizedYear2 = date6.getNormalizedYear();
            final int n15 = n7;
            BytecodeManager.incBytecodes(2);
            if (normalizedYear2 == n15) {
                final BaseCalendar.Date date7 = date;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int month3 = date7.getMonth();
                final int n16 = n12;
                BytecodeManager.incBytecodes(2);
                if (month3 == n16) {
                    final BaseCalendar.Date date8 = date;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int dayOfMonth = date8.getDayOfMonth();
                    BytecodeManager.incBytecodes(2);
                    if (dayOfMonth == n3) {
                        final int n17 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n4 >= n17) {
                            final int n18 = 7;
                            BytecodeManager.incBytecodes(3);
                            if (n4 <= n18) {
                                BytecodeManager.incBytecodes(2);
                                if (n5 >= 0) {
                                    final int n19 = 86400000;
                                    BytecodeManager.incBytecodes(3);
                                    if (n5 < n19) {
                                        final boolean useDaylight = this.useDaylight;
                                        BytecodeManager.incBytecodes(3);
                                        if (useDaylight) {
                                            final int startYear = this.startYear;
                                            BytecodeManager.incBytecodes(4);
                                            if (n >= startYear) {
                                                final int n20 = 1;
                                                BytecodeManager.incBytecodes(3);
                                                if (i == n20) {
                                                    final BaseCalendar baseCalendar5 = gcal;
                                                    final BaseCalendar.Date date9 = date;
                                                    final int n21 = n7;
                                                    final long n22 = n13;
                                                    BytecodeManager.incBytecodes(6);
                                                    final int offset = this.getOffset(baseCalendar5, date9, n21, n22);
                                                    BytecodeManager.incBytecodes(1);
                                                    return offset;
                                                }
                                            }
                                        }
                                        final int rawOffset = this.rawOffset;
                                        BytecodeManager.incBytecodes(3);
                                        return rawOffset;
                                    }
                                }
                            }
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
    
    private int getOffset(final BaseCalendar p0, final BaseCalendar.Date p1, final int p2, final long p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: dup            
        //     2: astore          6
        //     4: pop            
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_0        
        //    11: getfield        instrumented/java/util/SimpleTimeZone.cacheStart:J
        //    14: lconst_0       
        //    15: lcmp           
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            110
        //    24: lload           4
        //    26: aload_0        
        //    27: getfield        instrumented/java/util/SimpleTimeZone.cacheStart:J
        //    30: lcmp           
        //    31: ldc             5
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: iflt            77
        //    39: lload           4
        //    41: aload_0        
        //    42: getfield        instrumented/java/util/SimpleTimeZone.cacheEnd:J
        //    45: lcmp           
        //    46: ldc             5
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifge            77
        //    54: aload_0        
        //    55: getfield        instrumented/java/util/SimpleTimeZone.rawOffset:I
        //    58: aload_0        
        //    59: getfield        instrumented/java/util/SimpleTimeZone.dstSavings:I
        //    62: iadd           
        //    63: aload           6
        //    65: pop            
        //    66: ldc             7
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: ldc             1
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ireturn        
        //    77: iload_3        
        //    78: i2l            
        //    79: aload_0        
        //    80: getfield        instrumented/java/util/SimpleTimeZone.cacheYear:J
        //    83: lcmp           
        //    84: ldc             6
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ifne            110
        //    92: aload_0        
        //    93: getfield        instrumented/java/util/SimpleTimeZone.rawOffset:I
        //    96: aload           6
        //    98: pop            
        //    99: ldc             4
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ireturn        
        //   110: aload           6
        //   112: pop            
        //   113: ldc             2
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: ldc             1
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: goto            144
        //   126: astore          7
        //   128: aload           6
        //   130: pop            
        //   131: ldc             503
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: aload           7
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: athrow         
        //   144: aload_0        
        //   145: aload_1        
        //   146: aload_2        
        //   147: iload_3        
        //   148: ldc             5
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: invokespecial   instrumented/java/util/SimpleTimeZone.getStart:(Lsun/util/calendar/BaseCalendar;Lsun/util/calendar/BaseCalendar$Date;I)J
        //   156: lstore          6
        //   158: ldc             1
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: aload_0        
        //   164: aload_1        
        //   165: aload_2        
        //   166: iload_3        
        //   167: ldc             5
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: invokespecial   instrumented/java/util/SimpleTimeZone.getEnd:(Lsun/util/calendar/BaseCalendar;Lsun/util/calendar/BaseCalendar$Date;I)J
        //   175: lstore          8
        //   177: ldc             1
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: aload_0        
        //   183: getfield        instrumented/java/util/SimpleTimeZone.rawOffset:I
        //   186: istore          10
        //   188: ldc             3
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: lload           6
        //   195: lload           8
        //   197: lcmp           
        //   198: ldc             4
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: ifgt            331
        //   206: lload           4
        //   208: lload           6
        //   210: lcmp           
        //   211: ldc             4
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: iflt            246
        //   219: lload           4
        //   221: lload           8
        //   223: lcmp           
        //   224: ldc             4
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: ifge            246
        //   232: iload           10
        //   234: aload_0        
        //   235: getfield        instrumented/java/util/SimpleTimeZone.dstSavings:I
        //   238: iadd           
        //   239: istore          10
        //   241: ldc             5
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: aload_0        
        //   247: dup            
        //   248: astore          11
        //   250: pop            
        //   251: ldc             4
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: aload_0        
        //   257: iload_3        
        //   258: i2l            
        //   259: putfield        instrumented/java/util/SimpleTimeZone.cacheYear:J
        //   262: ldc             4
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: aload_0        
        //   268: lload           6
        //   270: putfield        instrumented/java/util/SimpleTimeZone.cacheStart:J
        //   273: ldc             3
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: aload_0        
        //   279: lload           8
        //   281: putfield        instrumented/java/util/SimpleTimeZone.cacheEnd:J
        //   284: ldc             3
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: aload           11
        //   291: pop            
        //   292: ldc             2
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: ldc             1
        //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   302: goto            323
        //   305: astore          12
        //   307: aload           11
        //   309: pop            
        //   310: ldc             503
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: aload           12
        //   317: ldc             2
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: athrow         
        //   323: ldc             1
        //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   328: goto            551
        //   331: lload           4
        //   333: lload           8
        //   335: lcmp           
        //   336: ldc             4
        //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   341: ifge            395
        //   344: aload_0        
        //   345: aload_1        
        //   346: aload_2        
        //   347: iload_3        
        //   348: iconst_1       
        //   349: isub           
        //   350: ldc             7
        //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   355: invokespecial   instrumented/java/util/SimpleTimeZone.getStart:(Lsun/util/calendar/BaseCalendar;Lsun/util/calendar/BaseCalendar$Date;I)J
        //   358: lstore          6
        //   360: ldc             1
        //   362: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   365: lload           4
        //   367: lload           6
        //   369: lcmp           
        //   370: ldc             4
        //   372: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   375: iflt            456
        //   378: iload           10
        //   380: aload_0        
        //   381: getfield        instrumented/java/util/SimpleTimeZone.dstSavings:I
        //   384: iadd           
        //   385: istore          10
        //   387: ldc             6
        //   389: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   392: goto            456
        //   395: lload           4
        //   397: lload           6
        //   399: lcmp           
        //   400: ldc             4
        //   402: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   405: iflt            456
        //   408: aload_0        
        //   409: aload_1        
        //   410: aload_2        
        //   411: iload_3        
        //   412: iconst_1       
        //   413: iadd           
        //   414: ldc             7
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: invokespecial   instrumented/java/util/SimpleTimeZone.getEnd:(Lsun/util/calendar/BaseCalendar;Lsun/util/calendar/BaseCalendar$Date;I)J
        //   422: lstore          8
        //   424: ldc             1
        //   426: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   429: lload           4
        //   431: lload           8
        //   433: lcmp           
        //   434: ldc             4
        //   436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   439: ifge            456
        //   442: iload           10
        //   444: aload_0        
        //   445: getfield        instrumented/java/util/SimpleTimeZone.dstSavings:I
        //   448: iadd           
        //   449: istore          10
        //   451: ldc             5
        //   453: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   456: lload           6
        //   458: lload           8
        //   460: lcmp           
        //   461: ldc             4
        //   463: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   466: ifgt            551
        //   469: aload_0        
        //   470: dup            
        //   471: astore          11
        //   473: pop            
        //   474: ldc             4
        //   476: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   479: aload_0        
        //   480: aload_0        
        //   481: getfield        instrumented/java/util/SimpleTimeZone.startYear:I
        //   484: i2l            
        //   485: lconst_1       
        //   486: lsub           
        //   487: putfield        instrumented/java/util/SimpleTimeZone.cacheYear:J
        //   490: ldc             7
        //   492: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   495: aload_0        
        //   496: lload           6
        //   498: putfield        instrumented/java/util/SimpleTimeZone.cacheStart:J
        //   501: ldc             3
        //   503: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   506: aload_0        
        //   507: lload           8
        //   509: putfield        instrumented/java/util/SimpleTimeZone.cacheEnd:J
        //   512: ldc             3
        //   514: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   517: aload           11
        //   519: pop            
        //   520: ldc             2
        //   522: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   525: ldc             1
        //   527: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   530: goto            551
        //   533: astore          13
        //   535: aload           11
        //   537: pop            
        //   538: ldc             503
        //   540: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   543: aload           13
        //   545: ldc             2
        //   547: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   550: athrow         
        //   551: iload           10
        //   553: ldc             2
        //   555: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   558: ireturn        
        //   559: athrow         
        //   560: athrow         
        //    StackMapTable: 00 0E FC 00 4D 07 00 B2 20 4F 07 00 58 FA 00 11 FE 00 65 04 04 01 FF 00 3A 00 09 07 00 02 07 00 09 07 00 07 01 04 04 04 01 07 00 B2 00 01 07 00 58 FA 00 11 07 3F 3C FF 00 4C 00 09 07 00 02 07 00 09 07 00 07 01 04 04 04 01 07 00 B2 00 01 07 00 58 FA 00 11 FF 00 07 00 00 00 01 07 00 58 FF 00 00 00 00 00 01 07 00 AC
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  10     560    560    561    Ljava/lang/VirtualMachineError;
        //  10     71     126    144    Any
        //  77     104    126    144    Any
        //  110    118    126    144    Any
        //  126    136    126    144    Any
        //  256    297    305    323    Any
        //  305    315    305    323    Any
        //  479    525    533    551    Any
        //  533    543    533    551    Any
        //  0      559    559    560    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0077:
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
    
    private long getStart(final BaseCalendar baseCalendar, final BaseCalendar.Date date, final int n) {
        try {
            int startTime = this.startTime;
            BytecodeManager.incBytecodes(3);
            final int startTimeMode = this.startTimeMode;
            final int n2 = 2;
            BytecodeManager.incBytecodes(4);
            if (startTimeMode != n2) {
                startTime -= this.rawOffset;
                BytecodeManager.incBytecodes(5);
            }
            final int startMode = this.startMode;
            final int startMonth = this.startMonth;
            final int startDay = this.startDay;
            final int startDayOfWeek = this.startDayOfWeek;
            final int n3 = startTime;
            BytecodeManager.incBytecodes(14);
            final long transition = this.getTransition(baseCalendar, date, startMode, n, startMonth, startDay, startDayOfWeek, n3);
            BytecodeManager.incBytecodes(1);
            return transition;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getEnd(final BaseCalendar baseCalendar, final BaseCalendar.Date date, final int n) {
        try {
            int endTime = this.endTime;
            BytecodeManager.incBytecodes(3);
            final int endTimeMode = this.endTimeMode;
            final int n2 = 2;
            BytecodeManager.incBytecodes(4);
            if (endTimeMode != n2) {
                endTime -= this.rawOffset;
                BytecodeManager.incBytecodes(5);
            }
            final int endTimeMode2 = this.endTimeMode;
            BytecodeManager.incBytecodes(3);
            if (endTimeMode2 == 0) {
                endTime -= this.dstSavings;
                BytecodeManager.incBytecodes(5);
            }
            final int endMode = this.endMode;
            final int endMonth = this.endMonth;
            final int endDay = this.endDay;
            final int endDayOfWeek = this.endDayOfWeek;
            final int n3 = endTime;
            BytecodeManager.incBytecodes(14);
            final long transition = this.getTransition(baseCalendar, date, endMode, n, endMonth, endDay, endDayOfWeek, n3);
            BytecodeManager.incBytecodes(1);
            return transition;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getTransition(final BaseCalendar baseCalendar, BaseCalendar.Date date, final int n, final int normalizedYear, final int n2, final int n3, final int dayOfWeek, final int n4) {
        try {
            final BaseCalendar.Date date2 = date;
            BytecodeManager.incBytecodes(3);
            date2.setNormalizedYear(normalizedYear);
            final BaseCalendar.Date date3 = date;
            final int month = n2 + 1;
            BytecodeManager.incBytecodes(5);
            date3.setMonth(month);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 1: {
                    final BaseCalendar.Date date4 = date;
                    BytecodeManager.incBytecodes(3);
                    date4.setDayOfMonth(n3);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 2: {
                    final BaseCalendar.Date date5 = date;
                    final int dayOfMonth = 1;
                    BytecodeManager.incBytecodes(3);
                    date5.setDayOfMonth(dayOfMonth);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    if (n3 < 0) {
                        final BaseCalendar.Date date6 = date;
                        final BaseCalendar.Date date7 = date;
                        BytecodeManager.incBytecodes(4);
                        final int monthLength = baseCalendar.getMonthLength(date7);
                        BytecodeManager.incBytecodes(1);
                        date6.setDayOfMonth(monthLength);
                        BytecodeManager.incBytecodes(1);
                    }
                    final BaseCalendar.Date date8 = date;
                    BytecodeManager.incBytecodes(5);
                    date = (BaseCalendar.Date)baseCalendar.getNthDayOfWeek(n3, dayOfWeek, date8);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 3: {
                    final BaseCalendar.Date date9 = date;
                    BytecodeManager.incBytecodes(3);
                    date9.setDayOfMonth(n3);
                    BytecodeManager.incBytecodes(1);
                    final int nth = 1;
                    final BaseCalendar.Date date10 = date;
                    BytecodeManager.incBytecodes(5);
                    date = (BaseCalendar.Date)baseCalendar.getNthDayOfWeek(nth, dayOfWeek, date10);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 4: {
                    final BaseCalendar.Date date11 = date;
                    BytecodeManager.incBytecodes(3);
                    date11.setDayOfMonth(n3);
                    BytecodeManager.incBytecodes(1);
                    final int nth2 = -1;
                    final BaseCalendar.Date date12 = date;
                    BytecodeManager.incBytecodes(5);
                    date = (BaseCalendar.Date)baseCalendar.getNthDayOfWeek(nth2, dayOfWeek, date12);
                    BytecodeManager.incBytecodes(2);
                    break;
                }
            }
            final BaseCalendar.Date date13 = date;
            BytecodeManager.incBytecodes(3);
            final long n5 = baseCalendar.getTime(date13) + n4;
            BytecodeManager.incBytecodes(4);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getRawOffset() {
        try {
            final int rawOffset = this.rawOffset;
            BytecodeManager.incBytecodes(3);
            return rawOffset;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void setRawOffset(final int rawOffset) {
        try {
            this.rawOffset = rawOffset;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setDSTSavings(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal daylight saving value: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(n);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.dstSavings = n;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getDSTSavings() {
        try {
            final boolean useDaylight = this.useDaylight;
            BytecodeManager.incBytecodes(3);
            int dstSavings;
            if (useDaylight) {
                dstSavings = this.dstSavings;
                BytecodeManager.incBytecodes(3);
            }
            else {
                dstSavings = 0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return dstSavings;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean useDaylightTime() {
        try {
            final boolean useDaylight = this.useDaylight;
            BytecodeManager.incBytecodes(3);
            return useDaylight;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean observesDaylightTime() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean useDaylightTime = this.useDaylightTime();
            BytecodeManager.incBytecodes(1);
            return useDaylightTime;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean inDaylightTime(final Date date) {
        try {
            BytecodeManager.incBytecodes(3);
            final long time = date.getTime();
            BytecodeManager.incBytecodes(1);
            final int offset = this.getOffset(time);
            final int rawOffset = this.rawOffset;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (offset != rawOffset) {
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
    public Object clone() {
        try {
            BytecodeManager.incBytecodes(2);
            final Object clone = super.clone();
            BytecodeManager.incBytecodes(1);
            return clone;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized int hashCode() {
        try {
            final int n = this.startMonth ^ this.startDay ^ this.startDayOfWeek ^ this.startTime ^ this.endMonth ^ this.endDay ^ this.endDayOfWeek ^ this.endTime ^ this.rawOffset;
            BytecodeManager.incBytecodes(27);
            return n;
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
            final boolean b2 = o instanceof SimpleTimeZone;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final SimpleTimeZone simpleTimeZone = (SimpleTimeZone)o;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final String id = this.getID();
            final SimpleTimeZone simpleTimeZone2 = simpleTimeZone;
            BytecodeManager.incBytecodes(2);
            final String id2 = simpleTimeZone2.getID();
            BytecodeManager.incBytecodes(1);
            final boolean equals = id.equals(id2);
            BytecodeManager.incBytecodes(1);
            boolean b4 = false;
            Label_0118: {
                if (equals) {
                    final SimpleTimeZone simpleTimeZone3 = simpleTimeZone;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean hasSameRules = this.hasSameRules(simpleTimeZone3);
                    BytecodeManager.incBytecodes(1);
                    if (hasSameRules) {
                        b4 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0118;
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
    
    @Override
    public boolean hasSameRules(final TimeZone timeZone) {
        try {
            BytecodeManager.incBytecodes(3);
            if (this == timeZone) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = timeZone instanceof SimpleTimeZone;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final SimpleTimeZone simpleTimeZone = (SimpleTimeZone)timeZone;
            BytecodeManager.incBytecodes(3);
            final int rawOffset = this.rawOffset;
            final int rawOffset2 = simpleTimeZone.rawOffset;
            BytecodeManager.incBytecodes(5);
            boolean b4 = false;
            Label_0329: {
                Label_0323: {
                    if (rawOffset == rawOffset2) {
                        final boolean useDaylight = this.useDaylight;
                        final boolean useDaylight2 = simpleTimeZone.useDaylight;
                        BytecodeManager.incBytecodes(5);
                        if (useDaylight == useDaylight2) {
                            final boolean useDaylight3 = this.useDaylight;
                            BytecodeManager.incBytecodes(3);
                            if (useDaylight3) {
                                final int dstSavings = this.dstSavings;
                                final int dstSavings2 = simpleTimeZone.dstSavings;
                                BytecodeManager.incBytecodes(5);
                                if (dstSavings != dstSavings2) {
                                    break Label_0323;
                                }
                                final int startMode = this.startMode;
                                final int startMode2 = simpleTimeZone.startMode;
                                BytecodeManager.incBytecodes(5);
                                if (startMode != startMode2) {
                                    break Label_0323;
                                }
                                final int startMonth = this.startMonth;
                                final int startMonth2 = simpleTimeZone.startMonth;
                                BytecodeManager.incBytecodes(5);
                                if (startMonth != startMonth2) {
                                    break Label_0323;
                                }
                                final int startDay = this.startDay;
                                final int startDay2 = simpleTimeZone.startDay;
                                BytecodeManager.incBytecodes(5);
                                if (startDay != startDay2) {
                                    break Label_0323;
                                }
                                final int startDayOfWeek = this.startDayOfWeek;
                                final int startDayOfWeek2 = simpleTimeZone.startDayOfWeek;
                                BytecodeManager.incBytecodes(5);
                                if (startDayOfWeek != startDayOfWeek2) {
                                    break Label_0323;
                                }
                                final int startTime = this.startTime;
                                final int startTime2 = simpleTimeZone.startTime;
                                BytecodeManager.incBytecodes(5);
                                if (startTime != startTime2) {
                                    break Label_0323;
                                }
                                final int startTimeMode = this.startTimeMode;
                                final int startTimeMode2 = simpleTimeZone.startTimeMode;
                                BytecodeManager.incBytecodes(5);
                                if (startTimeMode != startTimeMode2) {
                                    break Label_0323;
                                }
                                final int endMode = this.endMode;
                                final int endMode2 = simpleTimeZone.endMode;
                                BytecodeManager.incBytecodes(5);
                                if (endMode != endMode2) {
                                    break Label_0323;
                                }
                                final int endMonth = this.endMonth;
                                final int endMonth2 = simpleTimeZone.endMonth;
                                BytecodeManager.incBytecodes(5);
                                if (endMonth != endMonth2) {
                                    break Label_0323;
                                }
                                final int endDay = this.endDay;
                                final int endDay2 = simpleTimeZone.endDay;
                                BytecodeManager.incBytecodes(5);
                                if (endDay != endDay2) {
                                    break Label_0323;
                                }
                                final int endDayOfWeek = this.endDayOfWeek;
                                final int endDayOfWeek2 = simpleTimeZone.endDayOfWeek;
                                BytecodeManager.incBytecodes(5);
                                if (endDayOfWeek != endDayOfWeek2) {
                                    break Label_0323;
                                }
                                final int endTime = this.endTime;
                                final int endTime2 = simpleTimeZone.endTime;
                                BytecodeManager.incBytecodes(5);
                                if (endTime != endTime2) {
                                    break Label_0323;
                                }
                                final int endTimeMode = this.endTimeMode;
                                final int endTimeMode2 = simpleTimeZone.endTimeMode;
                                BytecodeManager.incBytecodes(5);
                                if (endTimeMode != endTimeMode2) {
                                    break Label_0323;
                                }
                                final int startYear = this.startYear;
                                final int startYear2 = simpleTimeZone.startYear;
                                BytecodeManager.incBytecodes(5);
                                if (startYear != startYear2) {
                                    break Label_0323;
                                }
                            }
                            b4 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0329;
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
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final Class<? extends SimpleTimeZone> class1 = this.getClass();
            BytecodeManager.incBytecodes(1);
            final String name = class1.getName();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(name);
            final String str = "[id=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String id = this.getID();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append3 = append2.append(id);
            final String str2 = ",offset=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(str2);
            final int rawOffset = this.rawOffset;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append5 = append4.append(rawOffset);
            final String str3 = ",dstSavings=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(str3);
            final int dstSavings = this.dstSavings;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append7 = append6.append(dstSavings);
            final String str4 = ",useDaylight=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append8 = append7.append(str4);
            final boolean useDaylight = this.useDaylight;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append9 = append8.append(useDaylight);
            final String str5 = ",startYear=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append10 = append9.append(str5);
            final int startYear = this.startYear;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append11 = append10.append(startYear);
            final String str6 = ",startMode=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append12 = append11.append(str6);
            final int startMode = this.startMode;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append13 = append12.append(startMode);
            final String str7 = ",startMonth=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append14 = append13.append(str7);
            final int startMonth = this.startMonth;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append15 = append14.append(startMonth);
            final String str8 = ",startDay=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append16 = append15.append(str8);
            final int startDay = this.startDay;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append17 = append16.append(startDay);
            final String str9 = ",startDayOfWeek=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append18 = append17.append(str9);
            final int startDayOfWeek = this.startDayOfWeek;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append19 = append18.append(startDayOfWeek);
            final String str10 = ",startTime=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append20 = append19.append(str10);
            final int startTime = this.startTime;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append21 = append20.append(startTime);
            final String str11 = ",startTimeMode=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append22 = append21.append(str11);
            final int startTimeMode = this.startTimeMode;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append23 = append22.append(startTimeMode);
            final String str12 = ",endMode=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append24 = append23.append(str12);
            final int endMode = this.endMode;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append25 = append24.append(endMode);
            final String str13 = ",endMonth=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append26 = append25.append(str13);
            final int endMonth = this.endMonth;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append27 = append26.append(endMonth);
            final String str14 = ",endDay=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append28 = append27.append(str14);
            final int endDay = this.endDay;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append29 = append28.append(endDay);
            final String str15 = ",endDayOfWeek=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append30 = append29.append(str15);
            final int endDayOfWeek = this.endDayOfWeek;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append31 = append30.append(endDayOfWeek);
            final String str16 = ",endTime=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append32 = append31.append(str16);
            final int endTime = this.endTime;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append33 = append32.append(endTime);
            final String str17 = ",endTimeMode=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append34 = append33.append(str17);
            final int endTimeMode = this.endTimeMode;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append35 = append34.append(endTimeMode);
            final char c = ']';
            BytecodeManager.incBytecodes(2);
            final StringBuilder append36 = append35.append(c);
            BytecodeManager.incBytecodes(1);
            final String string = append36.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void invalidateCache() {
        try {
            this.cacheYear = this.startYear - 1;
            BytecodeManager.incBytecodes(7);
            final long n = 0L;
            this.cacheEnd = n;
            this.cacheStart = n;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void decodeRules() {
        try {
            BytecodeManager.incBytecodes(2);
            this.decodeStartRule();
            BytecodeManager.incBytecodes(2);
            this.decodeEndRule();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void decodeStartRule() {
        try {
            final int startDay = this.startDay;
            BytecodeManager.incBytecodes(4);
            boolean useDaylight = false;
            Label_0040: {
                if (startDay != 0) {
                    final int endDay = this.endDay;
                    BytecodeManager.incBytecodes(3);
                    if (endDay != 0) {
                        useDaylight = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0040;
                    }
                }
                useDaylight = false;
                BytecodeManager.incBytecodes(1);
            }
            this.useDaylight = useDaylight;
            BytecodeManager.incBytecodes(1);
            final int startDay2 = this.startDay;
            BytecodeManager.incBytecodes(3);
            Label_0617: {
                if (startDay2 != 0) {
                    final int startMonth = this.startMonth;
                    BytecodeManager.incBytecodes(3);
                    if (startMonth >= 0) {
                        final int startMonth2 = this.startMonth;
                        final int n = 11;
                        BytecodeManager.incBytecodes(4);
                        if (startMonth2 <= n) {
                            final int startTime = this.startTime;
                            BytecodeManager.incBytecodes(3);
                            if (startTime >= 0) {
                                final int startTime2 = this.startTime;
                                final int n2 = 86400000;
                                BytecodeManager.incBytecodes(4);
                                if (startTime2 <= n2) {
                                    final int startDayOfWeek = this.startDayOfWeek;
                                    BytecodeManager.incBytecodes(3);
                                    if (startDayOfWeek == 0) {
                                        this.startMode = 1;
                                        BytecodeManager.incBytecodes(4);
                                    }
                                    else {
                                        final int startDayOfWeek2 = this.startDayOfWeek;
                                        BytecodeManager.incBytecodes(3);
                                        if (startDayOfWeek2 > 0) {
                                            this.startMode = 2;
                                            BytecodeManager.incBytecodes(4);
                                        }
                                        else {
                                            this.startDayOfWeek = -this.startDayOfWeek;
                                            BytecodeManager.incBytecodes(5);
                                            final int startDay3 = this.startDay;
                                            BytecodeManager.incBytecodes(3);
                                            if (startDay3 > 0) {
                                                this.startMode = 3;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                this.startDay = -this.startDay;
                                                BytecodeManager.incBytecodes(5);
                                                this.startMode = 4;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                        }
                                        final int startDayOfWeek3 = this.startDayOfWeek;
                                        final int n3 = 7;
                                        BytecodeManager.incBytecodes(4);
                                        if (startDayOfWeek3 > n3) {
                                            BytecodeManager.incBytecodes(5);
                                            final StringBuilder sb = new StringBuilder();
                                            final String str = "Illegal start day of week ";
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append = sb.append(str);
                                            final int startDayOfWeek4 = this.startDayOfWeek;
                                            BytecodeManager.incBytecodes(3);
                                            final StringBuilder append2 = append.append(startDayOfWeek4);
                                            BytecodeManager.incBytecodes(1);
                                            final String string = append2.toString();
                                            BytecodeManager.incBytecodes(1);
                                            final IllegalArgumentException ex = new IllegalArgumentException(string);
                                            BytecodeManager.incBytecodes(1);
                                            throw ex;
                                        }
                                    }
                                    final int startMode = this.startMode;
                                    final int n4 = 2;
                                    BytecodeManager.incBytecodes(4);
                                    if (startMode == n4) {
                                        final int startDay4 = this.startDay;
                                        final int n5 = -5;
                                        BytecodeManager.incBytecodes(4);
                                        if (startDay4 >= n5) {
                                            final int startDay5 = this.startDay;
                                            final int n6 = 5;
                                            BytecodeManager.incBytecodes(4);
                                            if (startDay5 <= n6) {
                                                break Label_0617;
                                            }
                                        }
                                        BytecodeManager.incBytecodes(5);
                                        final StringBuilder sb2 = new StringBuilder();
                                        final String str2 = "Illegal start day of week in month ";
                                        BytecodeManager.incBytecodes(2);
                                        final StringBuilder append3 = sb2.append(str2);
                                        final int startDay6 = this.startDay;
                                        BytecodeManager.incBytecodes(3);
                                        final StringBuilder append4 = append3.append(startDay6);
                                        BytecodeManager.incBytecodes(1);
                                        final String string2 = append4.toString();
                                        BytecodeManager.incBytecodes(1);
                                        final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                                        BytecodeManager.incBytecodes(1);
                                        throw ex2;
                                    }
                                    final int startDay7 = this.startDay;
                                    final int n7 = 1;
                                    BytecodeManager.incBytecodes(4);
                                    if (startDay7 >= n7) {
                                        final int startDay8 = this.startDay;
                                        final byte b = SimpleTimeZone.staticMonthLength[this.startMonth];
                                        BytecodeManager.incBytecodes(7);
                                        if (startDay8 <= b) {
                                            break Label_0617;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(5);
                                    final StringBuilder sb3 = new StringBuilder();
                                    final String str3 = "Illegal start day ";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append5 = sb3.append(str3);
                                    final int startDay9 = this.startDay;
                                    BytecodeManager.incBytecodes(3);
                                    final StringBuilder append6 = append5.append(startDay9);
                                    BytecodeManager.incBytecodes(1);
                                    final String string3 = append6.toString();
                                    BytecodeManager.incBytecodes(1);
                                    final IllegalArgumentException ex3 = new IllegalArgumentException(string3);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex3;
                                }
                            }
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb4 = new StringBuilder();
                            final String str4 = "Illegal start time ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append7 = sb4.append(str4);
                            final int startTime3 = this.startTime;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append8 = append7.append(startTime3);
                            BytecodeManager.incBytecodes(1);
                            final String string4 = append8.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalArgumentException ex4 = new IllegalArgumentException(string4);
                            BytecodeManager.incBytecodes(1);
                            throw ex4;
                        }
                    }
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb5 = new StringBuilder();
                    final String str5 = "Illegal start month ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append9 = sb5.append(str5);
                    final int startMonth3 = this.startMonth;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append10 = append9.append(startMonth3);
                    BytecodeManager.incBytecodes(1);
                    final String string5 = append10.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex5 = new IllegalArgumentException(string5);
                    BytecodeManager.incBytecodes(1);
                    throw ex5;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void decodeEndRule() {
        try {
            final int startDay = this.startDay;
            BytecodeManager.incBytecodes(4);
            boolean useDaylight = false;
            Label_0040: {
                if (startDay != 0) {
                    final int endDay = this.endDay;
                    BytecodeManager.incBytecodes(3);
                    if (endDay != 0) {
                        useDaylight = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0040;
                    }
                }
                useDaylight = false;
                BytecodeManager.incBytecodes(1);
            }
            this.useDaylight = useDaylight;
            BytecodeManager.incBytecodes(1);
            final int endDay2 = this.endDay;
            BytecodeManager.incBytecodes(3);
            Label_0617: {
                if (endDay2 != 0) {
                    final int endMonth = this.endMonth;
                    BytecodeManager.incBytecodes(3);
                    if (endMonth >= 0) {
                        final int endMonth2 = this.endMonth;
                        final int n = 11;
                        BytecodeManager.incBytecodes(4);
                        if (endMonth2 <= n) {
                            final int endTime = this.endTime;
                            BytecodeManager.incBytecodes(3);
                            if (endTime >= 0) {
                                final int endTime2 = this.endTime;
                                final int n2 = 86400000;
                                BytecodeManager.incBytecodes(4);
                                if (endTime2 <= n2) {
                                    final int endDayOfWeek = this.endDayOfWeek;
                                    BytecodeManager.incBytecodes(3);
                                    if (endDayOfWeek == 0) {
                                        this.endMode = 1;
                                        BytecodeManager.incBytecodes(4);
                                    }
                                    else {
                                        final int endDayOfWeek2 = this.endDayOfWeek;
                                        BytecodeManager.incBytecodes(3);
                                        if (endDayOfWeek2 > 0) {
                                            this.endMode = 2;
                                            BytecodeManager.incBytecodes(4);
                                        }
                                        else {
                                            this.endDayOfWeek = -this.endDayOfWeek;
                                            BytecodeManager.incBytecodes(5);
                                            final int endDay3 = this.endDay;
                                            BytecodeManager.incBytecodes(3);
                                            if (endDay3 > 0) {
                                                this.endMode = 3;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                this.endDay = -this.endDay;
                                                BytecodeManager.incBytecodes(5);
                                                this.endMode = 4;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                        }
                                        final int endDayOfWeek3 = this.endDayOfWeek;
                                        final int n3 = 7;
                                        BytecodeManager.incBytecodes(4);
                                        if (endDayOfWeek3 > n3) {
                                            BytecodeManager.incBytecodes(5);
                                            final StringBuilder sb = new StringBuilder();
                                            final String str = "Illegal end day of week ";
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append = sb.append(str);
                                            final int endDayOfWeek4 = this.endDayOfWeek;
                                            BytecodeManager.incBytecodes(3);
                                            final StringBuilder append2 = append.append(endDayOfWeek4);
                                            BytecodeManager.incBytecodes(1);
                                            final String string = append2.toString();
                                            BytecodeManager.incBytecodes(1);
                                            final IllegalArgumentException ex = new IllegalArgumentException(string);
                                            BytecodeManager.incBytecodes(1);
                                            throw ex;
                                        }
                                    }
                                    final int endMode = this.endMode;
                                    final int n4 = 2;
                                    BytecodeManager.incBytecodes(4);
                                    if (endMode == n4) {
                                        final int endDay4 = this.endDay;
                                        final int n5 = -5;
                                        BytecodeManager.incBytecodes(4);
                                        if (endDay4 >= n5) {
                                            final int endDay5 = this.endDay;
                                            final int n6 = 5;
                                            BytecodeManager.incBytecodes(4);
                                            if (endDay5 <= n6) {
                                                break Label_0617;
                                            }
                                        }
                                        BytecodeManager.incBytecodes(5);
                                        final StringBuilder sb2 = new StringBuilder();
                                        final String str2 = "Illegal end day of week in month ";
                                        BytecodeManager.incBytecodes(2);
                                        final StringBuilder append3 = sb2.append(str2);
                                        final int endDay6 = this.endDay;
                                        BytecodeManager.incBytecodes(3);
                                        final StringBuilder append4 = append3.append(endDay6);
                                        BytecodeManager.incBytecodes(1);
                                        final String string2 = append4.toString();
                                        BytecodeManager.incBytecodes(1);
                                        final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                                        BytecodeManager.incBytecodes(1);
                                        throw ex2;
                                    }
                                    final int endDay7 = this.endDay;
                                    final int n7 = 1;
                                    BytecodeManager.incBytecodes(4);
                                    if (endDay7 >= n7) {
                                        final int endDay8 = this.endDay;
                                        final byte b = SimpleTimeZone.staticMonthLength[this.endMonth];
                                        BytecodeManager.incBytecodes(7);
                                        if (endDay8 <= b) {
                                            break Label_0617;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(5);
                                    final StringBuilder sb3 = new StringBuilder();
                                    final String str3 = "Illegal end day ";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append5 = sb3.append(str3);
                                    final int endDay9 = this.endDay;
                                    BytecodeManager.incBytecodes(3);
                                    final StringBuilder append6 = append5.append(endDay9);
                                    BytecodeManager.incBytecodes(1);
                                    final String string3 = append6.toString();
                                    BytecodeManager.incBytecodes(1);
                                    final IllegalArgumentException ex3 = new IllegalArgumentException(string3);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex3;
                                }
                            }
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb4 = new StringBuilder();
                            final String str4 = "Illegal end time ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append7 = sb4.append(str4);
                            final int endTime3 = this.endTime;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append8 = append7.append(endTime3);
                            BytecodeManager.incBytecodes(1);
                            final String string4 = append8.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalArgumentException ex4 = new IllegalArgumentException(string4);
                            BytecodeManager.incBytecodes(1);
                            throw ex4;
                        }
                    }
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb5 = new StringBuilder();
                    final String str5 = "Illegal end month ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append9 = sb5.append(str5);
                    final int endMonth3 = this.endMonth;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append10 = append9.append(endMonth3);
                    BytecodeManager.incBytecodes(1);
                    final String string5 = append10.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex5 = new IllegalArgumentException(string5);
                    BytecodeManager.incBytecodes(1);
                    throw ex5;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void makeRulesCompatible() {
        try {
            final int startMode = this.startMode;
            BytecodeManager.incBytecodes(3);
            switch (startMode) {
                case 1: {
                    this.startDay = 1 + this.startDay / 7;
                    BytecodeManager.incBytecodes(8);
                    this.startDayOfWeek = 1;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 3: {
                    final int startDay = this.startDay;
                    final int n = 1;
                    BytecodeManager.incBytecodes(4);
                    if (startDay != n) {
                        this.startDay = 1 + this.startDay / 7;
                        BytecodeManager.incBytecodes(9);
                        break;
                    }
                    break;
                }
                case 4: {
                    final int startDay2 = this.startDay;
                    final int n2 = 30;
                    BytecodeManager.incBytecodes(4);
                    if (startDay2 >= n2) {
                        this.startDay = -1;
                        BytecodeManager.incBytecodes(4);
                        break;
                    }
                    this.startDay = 1 + this.startDay / 7;
                    BytecodeManager.incBytecodes(8);
                    break;
                }
            }
            final int endMode = this.endMode;
            BytecodeManager.incBytecodes(3);
            switch (endMode) {
                case 1: {
                    this.endDay = 1 + this.endDay / 7;
                    BytecodeManager.incBytecodes(8);
                    this.endDayOfWeek = 1;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 3: {
                    final int endDay = this.endDay;
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (endDay != n3) {
                        this.endDay = 1 + this.endDay / 7;
                        BytecodeManager.incBytecodes(9);
                        break;
                    }
                    break;
                }
                case 4: {
                    final int endDay2 = this.endDay;
                    final int n4 = 30;
                    BytecodeManager.incBytecodes(4);
                    if (endDay2 >= n4) {
                        this.endDay = -1;
                        BytecodeManager.incBytecodes(4);
                        break;
                    }
                    this.endDay = 1 + this.endDay / 7;
                    BytecodeManager.incBytecodes(8);
                    break;
                }
            }
            final int startTimeMode = this.startTimeMode;
            BytecodeManager.incBytecodes(3);
            switch (startTimeMode) {
                case 2: {
                    this.startTime += this.rawOffset;
                    BytecodeManager.incBytecodes(7);
                    break;
                }
            }
            while (true) {
                final int startTime = this.startTime;
                BytecodeManager.incBytecodes(3);
                if (startTime >= 0) {
                    break;
                }
                this.startTime += 86400000;
                BytecodeManager.incBytecodes(6);
                this.startDayOfWeek = 1 + (this.startDayOfWeek + 5) % 7;
                BytecodeManager.incBytecodes(11);
            }
            while (true) {
                final int startTime2 = this.startTime;
                final int n5 = 86400000;
                BytecodeManager.incBytecodes(4);
                if (startTime2 < n5) {
                    break;
                }
                this.startTime -= 86400000;
                BytecodeManager.incBytecodes(6);
                this.startDayOfWeek = 1 + this.startDayOfWeek % 7;
                BytecodeManager.incBytecodes(9);
            }
            final int endTimeMode = this.endTimeMode;
            BytecodeManager.incBytecodes(3);
            switch (endTimeMode) {
                case 2: {
                    this.endTime += this.rawOffset + this.dstSavings;
                    BytecodeManager.incBytecodes(10);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 1: {
                    this.endTime += this.dstSavings;
                    BytecodeManager.incBytecodes(7);
                    break;
                }
            }
            while (true) {
                final int endTime = this.endTime;
                BytecodeManager.incBytecodes(3);
                if (endTime >= 0) {
                    break;
                }
                this.endTime += 86400000;
                BytecodeManager.incBytecodes(6);
                this.endDayOfWeek = 1 + (this.endDayOfWeek + 5) % 7;
                BytecodeManager.incBytecodes(11);
            }
            while (true) {
                final int endTime2 = this.endTime;
                final int n6 = 86400000;
                BytecodeManager.incBytecodes(4);
                if (endTime2 < n6) {
                    break;
                }
                this.endTime -= 86400000;
                BytecodeManager.incBytecodes(6);
                this.endDayOfWeek = 1 + this.endDayOfWeek % 7;
                BytecodeManager.incBytecodes(9);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private byte[] packRules() {
        try {
            final byte[] array = new byte[6];
            BytecodeManager.incBytecodes(2);
            array[0] = (byte)this.startDay;
            BytecodeManager.incBytecodes(6);
            array[1] = (byte)this.startDayOfWeek;
            BytecodeManager.incBytecodes(6);
            array[2] = (byte)this.endDay;
            BytecodeManager.incBytecodes(6);
            array[3] = (byte)this.endDayOfWeek;
            BytecodeManager.incBytecodes(6);
            array[4] = (byte)this.startTimeMode;
            BytecodeManager.incBytecodes(6);
            array[5] = (byte)this.endTimeMode;
            BytecodeManager.incBytecodes(6);
            final byte[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void unpackRules(final byte[] array) {
        try {
            this.startDay = array[0];
            BytecodeManager.incBytecodes(5);
            this.startDayOfWeek = array[1];
            BytecodeManager.incBytecodes(5);
            this.endDay = array[2];
            BytecodeManager.incBytecodes(5);
            this.endDayOfWeek = array[3];
            BytecodeManager.incBytecodes(5);
            final int length = array.length;
            final int n = 6;
            BytecodeManager.incBytecodes(4);
            if (length >= n) {
                this.startTimeMode = array[4];
                BytecodeManager.incBytecodes(5);
                this.endTimeMode = array[5];
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int[] packTimes() {
        try {
            final int[] array = new int[2];
            BytecodeManager.incBytecodes(2);
            array[0] = this.startTime;
            BytecodeManager.incBytecodes(5);
            array[1] = this.endTime;
            BytecodeManager.incBytecodes(5);
            final int[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void unpackTimes(final int[] array) {
        try {
            this.startTime = array[0];
            BytecodeManager.incBytecodes(5);
            this.endTime = array[1];
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final byte[] packRules = this.packRules();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int[] packTimes = this.packTimes();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.makeRulesCompatible();
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final int length = packRules.length;
            BytecodeManager.incBytecodes(4);
            objectOutputStream.writeInt(length);
            final byte[] buf = packRules;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.write(buf);
            final int[] obj = packTimes;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.writeObject(obj);
            final byte[] array = packRules;
            BytecodeManager.incBytecodes(3);
            this.unpackRules(array);
            final int[] array2 = packTimes;
            BytecodeManager.incBytecodes(3);
            this.unpackTimes(array2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            final int serialVersionOnStream = this.serialVersionOnStream;
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            if (serialVersionOnStream < n) {
                final int startDayOfWeek = this.startDayOfWeek;
                BytecodeManager.incBytecodes(3);
                if (startDayOfWeek == 0) {
                    this.startDayOfWeek = 1;
                    BytecodeManager.incBytecodes(3);
                }
                final int endDayOfWeek = this.endDayOfWeek;
                BytecodeManager.incBytecodes(3);
                if (endDayOfWeek == 0) {
                    this.endDayOfWeek = 1;
                    BytecodeManager.incBytecodes(3);
                }
                final int n2 = 2;
                this.endMode = n2;
                this.startMode = n2;
                BytecodeManager.incBytecodes(6);
                this.dstSavings = 3600000;
                BytecodeManager.incBytecodes(4);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final int int1 = objectInputStream.readInt();
                BytecodeManager.incBytecodes(1);
                final byte[] array = new byte[int1];
                BytecodeManager.incBytecodes(2);
                final byte[] buf = array;
                BytecodeManager.incBytecodes(3);
                objectInputStream.readFully(buf);
                final byte[] array2 = array;
                BytecodeManager.incBytecodes(3);
                this.unpackRules(array2);
            }
            final int serialVersionOnStream2 = this.serialVersionOnStream;
            final int n3 = 2;
            BytecodeManager.incBytecodes(4);
            if (serialVersionOnStream2 >= n3) {
                BytecodeManager.incBytecodes(2);
                final int[] array3 = (int[])objectInputStream.readObject();
                BytecodeManager.incBytecodes(3);
                final int[] array4 = array3;
                BytecodeManager.incBytecodes(3);
                this.unpackTimes(array4);
            }
            this.serialVersionOnStream = 2;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            staticMonthLength = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            BytecodeManager.incBytecodes(50);
            staticLeapMonthLength = new byte[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            BytecodeManager.incBytecodes(50);
            BytecodeManager.incBytecodes(1);
            gcal = CalendarSystem.getGregorianCalendar();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
