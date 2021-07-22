// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.security.Permission;
import sun.util.calendar.ZoneInfo;
import java.time.ZoneId;
import sun.util.calendar.ZoneInfoFile;
import sun.util.locale.provider.TimeZoneNameUtility;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public abstract class TimeZone implements Serializable, Cloneable
{
    public static final int SHORT = 0;
    public static final int LONG = 1;
    private static final int ONE_MINUTE = 60000;
    private static final int ONE_HOUR = 3600000;
    private static final int ONE_DAY = 86400000;
    static final long serialVersionUID = 3581463369166924961L;
    static final TimeZone NO_TIMEZONE;
    private String ID;
    private static volatile TimeZone defaultTimeZone;
    static final String GMT_ID = "GMT";
    private static final int GMT_ID_LENGTH = 3;
    private static volatile TimeZone mainAppContextDefault;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public TimeZone() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract int getOffset(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    
    public int getOffset(final long n) {
        try {
            BytecodeManager.incBytecodes(5);
            final Date date = new Date(n);
            BytecodeManager.incBytecodes(1);
            final boolean inDaylightTime = this.inDaylightTime(date);
            BytecodeManager.incBytecodes(1);
            if (inDaylightTime) {
                BytecodeManager.incBytecodes(2);
                final int rawOffset = this.getRawOffset();
                BytecodeManager.incBytecodes(2);
                final int n2 = rawOffset + this.getDSTSavings();
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            BytecodeManager.incBytecodes(2);
            final int rawOffset2 = this.getRawOffset();
            BytecodeManager.incBytecodes(1);
            return rawOffset2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int getOffsets(final long n, final int[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final int rawOffset = this.getRawOffset();
            BytecodeManager.incBytecodes(1);
            int dstSavings = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(5);
            final Date date = new Date(n);
            BytecodeManager.incBytecodes(1);
            final boolean inDaylightTime = this.inDaylightTime(date);
            BytecodeManager.incBytecodes(1);
            if (inDaylightTime) {
                BytecodeManager.incBytecodes(2);
                dstSavings = this.getDSTSavings();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                array[0] = rawOffset;
                BytecodeManager.incBytecodes(4);
                array[1] = dstSavings;
                BytecodeManager.incBytecodes(4);
            }
            final int n2 = rawOffset + dstSavings;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract void setRawOffset(final int p0);
    
    public abstract int getRawOffset();
    
    public String getID() {
        try {
            final String id = this.ID;
            BytecodeManager.incBytecodes(3);
            return id;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setID(final String id) {
        try {
            BytecodeManager.incBytecodes(2);
            if (id == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.ID = id;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getDisplayName() {
        try {
            final boolean b = false;
            final int n = 1;
            final Locale.Category display = Locale.Category.DISPLAY;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final Locale default1 = Locale.getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String displayName = this.getDisplayName(b, n, default1);
            BytecodeManager.incBytecodes(1);
            return displayName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getDisplayName(final Locale locale) {
        try {
            final boolean b = false;
            final int n = 1;
            BytecodeManager.incBytecodes(5);
            final String displayName = this.getDisplayName(b, n, locale);
            BytecodeManager.incBytecodes(1);
            return displayName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getDisplayName(final boolean b, final int n) {
        try {
            final Locale.Category display = Locale.Category.DISPLAY;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final Locale default1 = Locale.getDefault(display);
            BytecodeManager.incBytecodes(1);
            final String displayName = this.getDisplayName(b, n, default1);
            BytecodeManager.incBytecodes(1);
            return displayName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDisplayName(final boolean b, final int i, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i != 0) {
                final int n = 1;
                BytecodeManager.incBytecodes(3);
                if (i != n) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Illegal style: ";
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
            BytecodeManager.incBytecodes(2);
            final String id = this.getID();
            BytecodeManager.incBytecodes(1);
            final String s = id;
            BytecodeManager.incBytecodes(5);
            final String retrieveDisplayName = TimeZoneNameUtility.retrieveDisplayName(s, b, i, locale);
            BytecodeManager.incBytecodes(1);
            final String s2 = retrieveDisplayName;
            BytecodeManager.incBytecodes(2);
            if (s2 != null) {
                final String s3 = retrieveDisplayName;
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            final String s4 = id;
            final String prefix = "GMT";
            BytecodeManager.incBytecodes(3);
            final boolean startsWith = s4.startsWith(prefix);
            BytecodeManager.incBytecodes(1);
            Label_0219: {
                if (startsWith) {
                    final String s5 = id;
                    BytecodeManager.incBytecodes(2);
                    final int length = s5.length();
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(2);
                    if (length > n2) {
                        final String s6 = id;
                        final int index = 3;
                        BytecodeManager.incBytecodes(3);
                        final char char1 = s6.charAt(index);
                        BytecodeManager.incBytecodes(1);
                        final char c = char1;
                        final int n3 = '+';
                        BytecodeManager.incBytecodes(3);
                        if (c != n3) {
                            final char c2 = char1;
                            final int n4 = '-';
                            BytecodeManager.incBytecodes(3);
                            if (c2 != n4) {
                                break Label_0219;
                            }
                        }
                        final String s7 = id;
                        BytecodeManager.incBytecodes(2);
                        return s7;
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            int rawOffset = this.getRawOffset();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (b) {
                final int n5 = rawOffset;
                BytecodeManager.incBytecodes(3);
                rawOffset = n5 + this.getDSTSavings();
                BytecodeManager.incBytecodes(2);
            }
            final int gmtOffset = rawOffset;
            BytecodeManager.incBytecodes(2);
            final String customID = ZoneInfoFile.toCustomID(gmtOffset);
            BytecodeManager.incBytecodes(1);
            return customID;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String[] getDisplayNames(final String s, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(3);
            final String[] retrieveDisplayNames = TimeZoneNameUtility.retrieveDisplayNames(s, locale);
            BytecodeManager.incBytecodes(1);
            return retrieveDisplayNames;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getDSTSavings() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean useDaylightTime = this.useDaylightTime();
            BytecodeManager.incBytecodes(1);
            if (useDaylightTime) {
                final int n = 3600000;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            final int n2 = 0;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract boolean useDaylightTime();
    
    public boolean observesDaylightTime() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean useDaylightTime = this.useDaylightTime();
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0061: {
                if (!useDaylightTime) {
                    BytecodeManager.incBytecodes(4);
                    final Date date = new Date();
                    BytecodeManager.incBytecodes(1);
                    final boolean inDaylightTime = this.inDaylightTime(date);
                    BytecodeManager.incBytecodes(1);
                    if (!inDaylightTime) {
                        b = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0061;
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
    
    public abstract boolean inDaylightTime(final Date p0);
    
    public static synchronized TimeZone getTimeZone(final String s) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final TimeZone timeZone = getTimeZone(s, b);
            BytecodeManager.incBytecodes(1);
            return timeZone;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TimeZone getTimeZone(final ZoneId zoneId) {
        try {
            BytecodeManager.incBytecodes(2);
            String s = zoneId.getId();
            BytecodeManager.incBytecodes(1);
            final String s2 = s;
            final int index = 0;
            BytecodeManager.incBytecodes(3);
            final char char1 = s2.charAt(index);
            BytecodeManager.incBytecodes(1);
            final char c = char1;
            final int n = '+';
            BytecodeManager.incBytecodes(3);
            Label_0138: {
                if (c != n) {
                    final char c2 = char1;
                    final int n2 = '-';
                    BytecodeManager.incBytecodes(3);
                    if (c2 != n2) {
                        final char c3 = char1;
                        final int n3 = 'Z';
                        BytecodeManager.incBytecodes(3);
                        if (c3 != n3) {
                            break Label_0138;
                        }
                        final String s3 = s;
                        BytecodeManager.incBytecodes(2);
                        final int length = s3.length();
                        final int n4 = 1;
                        BytecodeManager.incBytecodes(2);
                        if (length == n4) {
                            s = "UTC";
                            BytecodeManager.incBytecodes(2);
                        }
                        break Label_0138;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "GMT";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                BytecodeManager.incBytecodes(1);
                s = append2.toString();
                BytecodeManager.incBytecodes(2);
            }
            final String s4 = s;
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final TimeZone timeZone = getTimeZone(s4, b);
            BytecodeManager.incBytecodes(1);
            return timeZone;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZoneId toZoneId() {
        try {
            BytecodeManager.incBytecodes(2);
            final String id = this.getID();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final boolean useOldMapping = ZoneInfoFile.useOldMapping();
            BytecodeManager.incBytecodes(1);
            if (useOldMapping) {
                final String s = id;
                BytecodeManager.incBytecodes(2);
                final int length = s.length();
                final int n = 3;
                BytecodeManager.incBytecodes(2);
                if (length == n) {
                    final String s2 = "EST";
                    final String anObject = id;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = s2.equals(anObject);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final String zoneId = "America/New_York";
                        BytecodeManager.incBytecodes(2);
                        final ZoneId of = ZoneId.of(zoneId);
                        BytecodeManager.incBytecodes(1);
                        return of;
                    }
                    final String s3 = "MST";
                    final String anObject2 = id;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals2 = s3.equals(anObject2);
                    BytecodeManager.incBytecodes(1);
                    if (equals2) {
                        final String zoneId2 = "America/Denver";
                        BytecodeManager.incBytecodes(2);
                        final ZoneId of2 = ZoneId.of(zoneId2);
                        BytecodeManager.incBytecodes(1);
                        return of2;
                    }
                    final String s4 = "HST";
                    final String anObject3 = id;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals3 = s4.equals(anObject3);
                    BytecodeManager.incBytecodes(1);
                    if (equals3) {
                        final String zoneId3 = "America/Honolulu";
                        BytecodeManager.incBytecodes(2);
                        final ZoneId of3 = ZoneId.of(zoneId3);
                        BytecodeManager.incBytecodes(1);
                        return of3;
                    }
                }
            }
            final String s5 = id;
            final Map short_IDS = ZoneId.SHORT_IDS;
            BytecodeManager.incBytecodes(3);
            final ZoneId of4 = ZoneId.of(s5, short_IDS);
            BytecodeManager.incBytecodes(1);
            return of4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static TimeZone getTimeZone(final String s, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            Serializable s2 = ZoneInfo.getTimeZone(s);
            BytecodeManager.incBytecodes(1);
            final Serializable s3 = s2;
            BytecodeManager.incBytecodes(2);
            if (s3 == null) {
                BytecodeManager.incBytecodes(2);
                s2 = parseCustomTimeZone(s);
                BytecodeManager.incBytecodes(1);
                final Serializable s4 = s2;
                BytecodeManager.incBytecodes(2);
                if (s4 == null) {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        final String id = "GMT";
                        final int rawOffset = 0;
                        BytecodeManager.incBytecodes(5);
                        s2 = new ZoneInfo(id, rawOffset);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final Serializable s5 = s2;
            BytecodeManager.incBytecodes(2);
            return (TimeZone)s5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static synchronized String[] getAvailableIDs(final int rawOffset) {
        try {
            BytecodeManager.incBytecodes(2);
            final String[] availableIDs = ZoneInfo.getAvailableIDs(rawOffset);
            BytecodeManager.incBytecodes(1);
            return availableIDs;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static synchronized String[] getAvailableIDs() {
        try {
            BytecodeManager.incBytecodes(1);
            final String[] availableIDs = ZoneInfo.getAvailableIDs();
            BytecodeManager.incBytecodes(1);
            return availableIDs;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static native String getSystemTimeZoneID(final String p0);
    
    private static native String getSystemGMTOffsetID();
    
    public static TimeZone getDefault() {
        try {
            BytecodeManager.incBytecodes(1);
            final TimeZone defaultRef = getDefaultRef();
            BytecodeManager.incBytecodes(1);
            final TimeZone timeZone = (TimeZone)defaultRef.clone();
            BytecodeManager.incBytecodes(2);
            return timeZone;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static TimeZone getDefaultRef() {
        try {
            TimeZone timeZone = TimeZone.defaultTimeZone;
            BytecodeManager.incBytecodes(2);
            final TimeZone timeZone2 = timeZone;
            BytecodeManager.incBytecodes(2);
            if (timeZone2 == null) {
                BytecodeManager.incBytecodes(1);
                timeZone = setDefaultZone();
                BytecodeManager.incBytecodes(1);
                final boolean $assertionsDisabled = TimeZone.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final TimeZone timeZone3 = timeZone;
                    BytecodeManager.incBytecodes(2);
                    if (timeZone3 == null) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
            }
            final TimeZone timeZone4 = timeZone;
            BytecodeManager.incBytecodes(2);
            return timeZone4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static synchronized TimeZone setDefaultZone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ldc             "user.timezone"
        //     6: ldc             4
        //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    11: invokespecial   sun/security/action/GetPropertyAction.<init>:(Ljava/lang/String;)V
        //    14: ldc             1
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //    22: checkcast       Ljava/lang/String;
        //    25: astore_1       
        //    26: ldc             2
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: aload_1        
        //    32: ldc             2
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: ifnull          57
        //    40: aload_1        
        //    41: ldc             2
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokevirtual   java/lang/String.isEmpty:()Z
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifeq            144
        //    57: new             Lsun/security/action/GetPropertyAction;
        //    60: dup            
        //    61: ldc_w           "java.home"
        //    64: ldc             4
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: invokespecial   sun/security/action/GetPropertyAction.<init>:(Ljava/lang/String;)V
        //    72: ldc             1
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //    80: checkcast       Ljava/lang/String;
        //    83: astore_2       
        //    84: ldc             2
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload_2        
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokestatic    instrumented/java/util/TimeZone.getSystemTimeZoneID:(Ljava/lang/String;)Ljava/lang/String;
        //    98: astore_1       
        //    99: ldc             1
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: aload_1        
        //   105: ldc             2
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: ifnonnull       121
        //   113: ldc             "GMT"
        //   115: astore_1       
        //   116: ldc             2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: ldc             1
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: goto            144
        //   129: astore_3       
        //   130: ldc_w           501
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: ldc             "GMT"
        //   138: astore_1       
        //   139: ldc             2
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: aload_1        
        //   145: iconst_0       
        //   146: ldc             3
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokestatic    instrumented/java/util/TimeZone.getTimeZone:(Ljava/lang/String;Z)Linstrumented/java/util/TimeZone;
        //   154: astore_0       
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: aload_0        
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: ifnonnull       215
        //   169: ldc             1
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: invokestatic    instrumented/java/util/TimeZone.getSystemGMTOffsetID:()Ljava/lang/String;
        //   177: astore_2       
        //   178: ldc             1
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload_2        
        //   184: ldc             2
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: ifnull          199
        //   192: aload_2        
        //   193: astore_1       
        //   194: ldc             2
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: aload_1        
        //   200: iconst_1       
        //   201: ldc             3
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokestatic    instrumented/java/util/TimeZone.getTimeZone:(Ljava/lang/String;Z)Linstrumented/java/util/TimeZone;
        //   209: astore_0       
        //   210: ldc             1
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: getstatic       instrumented/java/util/TimeZone.$assertionsDisabled:Z
        //   218: ldc             2
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: ifne            253
        //   226: aload_0        
        //   227: ldc             2
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: ifnonnull       253
        //   235: new             Ljava/lang/AssertionError;
        //   238: dup            
        //   239: ldc             3
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: invokespecial   java/lang/AssertionError.<init>:()V
        //   247: ldc             1
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: athrow         
        //   253: aload_1        
        //   254: astore_2       
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: new             Linstrumented/java/util/TimeZone$1;
        //   263: dup            
        //   264: aload_2        
        //   265: ldc             4
        //   267: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   270: invokespecial   instrumented/java/util/TimeZone$1.<init>:(Ljava/lang/String;)V
        //   273: ldc             1
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //   281: pop            
        //   282: ldc             1
        //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   287: aload_0        
        //   288: putstatic       instrumented/java/util/TimeZone.defaultTimeZone:Linstrumented/java/util/TimeZone;
        //   291: ldc             2
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: aload_0        
        //   297: ldc             2
        //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   302: areturn        
        //   303: athrow         
        //   304: athrow         
        //    StackMapTable: 00 09 FD 00 39 00 07 00 85 FC 00 3F 07 00 85 47 07 00 59 FA 00 0E FF 00 36 00 03 07 00 02 07 00 85 07 00 85 00 00 FA 00 0F 25 FF 00 31 00 00 00 01 07 00 39 FF 00 00 00 00 00 01 07 00 F6
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  89     304    304    305    Ljava/lang/VirtualMachineError;
        //  89     121    129    144    Ljava/lang/NullPointerException;
        //  0      303    303    304    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0121:
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
    
    public static void setDefault(final TimeZone defaultTimeZone) {
        try {
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 != null) {
                final SecurityManager securityManager3 = securityManager;
                final String s = "user.timezone";
                final String s2 = "write";
                BytecodeManager.incBytecodes(6);
                final PropertyPermission perm = new PropertyPermission(s, s2);
                BytecodeManager.incBytecodes(1);
                securityManager3.checkPermission(perm);
            }
            TimeZone.defaultTimeZone = defaultTimeZone;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasSameRules(final TimeZone timeZone) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0081: {
                if (timeZone != null) {
                    BytecodeManager.incBytecodes(2);
                    final int rawOffset = this.getRawOffset();
                    BytecodeManager.incBytecodes(2);
                    final int rawOffset2 = timeZone.getRawOffset();
                    BytecodeManager.incBytecodes(1);
                    if (rawOffset == rawOffset2) {
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final boolean useDaylightTime = this.useDaylightTime();
                        BytecodeManager.incBytecodes(2);
                        final boolean useDaylightTime2 = timeZone.useDaylightTime();
                        BytecodeManager.incBytecodes(1);
                        if (useDaylightTime == useDaylightTime2) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0081;
                        }
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
    
    public Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final TimeZone timeZone = (TimeZone)super.clone();
                BytecodeManager.incBytecodes(2);
                timeZone.ID = this.ID;
                BytecodeManager.incBytecodes(4);
                final TimeZone timeZone2 = timeZone;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return timeZone2;
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
    
    private static final TimeZone parseCustomTimeZone(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length;
            final int n = length = s.length();
            final int n2 = 5;
            BytecodeManager.incBytecodes(4);
            if (n >= n2) {
                final String str = "GMT";
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final int index = s.indexOf(str);
                BytecodeManager.incBytecodes(1);
                if (index == 0) {
                    BytecodeManager.incBytecodes(2);
                    final ZoneInfo zoneInfo = ZoneInfoFile.getZoneInfo(s);
                    BytecodeManager.incBytecodes(1);
                    final ZoneInfo zoneInfo2 = zoneInfo;
                    BytecodeManager.incBytecodes(2);
                    if (zoneInfo2 != null) {
                        final ZoneInfo zoneInfo3 = zoneInfo;
                        BytecodeManager.incBytecodes(2);
                        return (TimeZone)zoneInfo3;
                    }
                    int n3 = 3;
                    BytecodeManager.incBytecodes(2);
                    boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    final int index2 = n3++;
                    BytecodeManager.incBytecodes(4);
                    final char char1 = s.charAt(index2);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int n4 = '-';
                    BytecodeManager.incBytecodes(3);
                    if (c == n4) {
                        b = true;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final char c2 = char1;
                        final int n5 = '+';
                        BytecodeManager.incBytecodes(3);
                        if (c2 != n5) {
                            final TimeZone timeZone = null;
                            BytecodeManager.incBytecodes(2);
                            return timeZone;
                        }
                    }
                    int n6 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n7 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n8 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n9 = 0;
                    BytecodeManager.incBytecodes(2);
                    Label_0370: {
                        while (true) {
                            final int n10 = n3;
                            final int n11 = length;
                            BytecodeManager.incBytecodes(3);
                            if (n10 >= n11) {
                                break Label_0370;
                            }
                            final int index3 = n3++;
                            BytecodeManager.incBytecodes(4);
                            final char char2 = s.charAt(index3);
                            BytecodeManager.incBytecodes(1);
                            final char c3 = char2;
                            final int n12 = ':';
                            BytecodeManager.incBytecodes(3);
                            if (c3 == n12) {
                                final int n13 = n8;
                                BytecodeManager.incBytecodes(2);
                                if (n13 > 0) {
                                    final TimeZone timeZone2 = null;
                                    BytecodeManager.incBytecodes(2);
                                    return timeZone2;
                                }
                                final int n14 = n9;
                                final int n15 = 2;
                                BytecodeManager.incBytecodes(3);
                                if (n14 > n15) {
                                    final TimeZone timeZone3 = null;
                                    BytecodeManager.incBytecodes(2);
                                    return timeZone3;
                                }
                                n6 = n7;
                                BytecodeManager.incBytecodes(2);
                                ++n8;
                                BytecodeManager.incBytecodes(1);
                                n7 = 0;
                                BytecodeManager.incBytecodes(2);
                                n9 = 0;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final char c4 = char2;
                                final int n16 = '0';
                                BytecodeManager.incBytecodes(3);
                                if (c4 < n16) {
                                    break;
                                }
                                final char c5 = char2;
                                final int n17 = '9';
                                BytecodeManager.incBytecodes(3);
                                if (c5 > n17) {
                                    break;
                                }
                                n7 = n7 * 10 + (char2 - '0');
                                BytecodeManager.incBytecodes(8);
                                ++n9;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        final TimeZone timeZone4 = null;
                        BytecodeManager.incBytecodes(2);
                        return timeZone4;
                    }
                    final int n18 = n3;
                    final int n19 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n18 != n19) {
                        final TimeZone timeZone5 = null;
                        BytecodeManager.incBytecodes(2);
                        return timeZone5;
                    }
                    final int n20 = n8;
                    BytecodeManager.incBytecodes(2);
                    if (n20 == 0) {
                        final int n21 = n9;
                        final int n22 = 2;
                        BytecodeManager.incBytecodes(3);
                        if (n21 <= n22) {
                            n6 = n7;
                            BytecodeManager.incBytecodes(2);
                            n7 = 0;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            n6 = n7 / 100;
                            BytecodeManager.incBytecodes(4);
                            n7 %= 100;
                            BytecodeManager.incBytecodes(5);
                        }
                    }
                    else {
                        final int n23 = n9;
                        final int n24 = 2;
                        BytecodeManager.incBytecodes(3);
                        if (n23 != n24) {
                            final TimeZone timeZone6 = null;
                            BytecodeManager.incBytecodes(2);
                            return timeZone6;
                        }
                    }
                    final int n25 = n6;
                    final int n26 = 23;
                    BytecodeManager.incBytecodes(3);
                    if (n25 <= n26) {
                        final int n27 = n7;
                        final int n28 = 59;
                        BytecodeManager.incBytecodes(3);
                        if (n27 <= n28) {
                            final int n29 = (n6 * 60 + n7) * 60 * 1000;
                            BytecodeManager.incBytecodes(10);
                            final int n30 = n29;
                            BytecodeManager.incBytecodes(2);
                            ZoneInfo zoneInfo4;
                            if (n30 == 0) {
                                final String zoneId = "GMT";
                                BytecodeManager.incBytecodes(2);
                                zoneInfo4 = ZoneInfoFile.getZoneInfo(zoneId);
                                BytecodeManager.incBytecodes(1);
                                final boolean b2 = b;
                                BytecodeManager.incBytecodes(2);
                                if (b2) {
                                    final ZoneInfo zoneInfo5 = zoneInfo4;
                                    final String id = "GMT-00:00";
                                    BytecodeManager.incBytecodes(3);
                                    zoneInfo5.setID(id);
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final ZoneInfo zoneInfo6 = zoneInfo4;
                                    final String id2 = "GMT+00:00";
                                    BytecodeManager.incBytecodes(3);
                                    zoneInfo6.setID(id2);
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            else {
                                final boolean b3 = b;
                                BytecodeManager.incBytecodes(3);
                                int gmtOffset;
                                if (b3) {
                                    gmtOffset = -n29;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    gmtOffset = n29;
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                zoneInfo4 = ZoneInfoFile.getCustomTimeZone(s, gmtOffset);
                                BytecodeManager.incBytecodes(1);
                            }
                            final ZoneInfo zoneInfo7 = zoneInfo4;
                            BytecodeManager.incBytecodes(2);
                            return (TimeZone)zoneInfo7;
                        }
                    }
                    final TimeZone timeZone7 = null;
                    BytecodeManager.incBytecodes(2);
                    return timeZone7;
                }
            }
            final TimeZone timeZone8 = null;
            BytecodeManager.incBytecodes(2);
            return timeZone8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<TimeZone> clazz = TimeZone.class;
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
            NO_TIMEZONE = null;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
