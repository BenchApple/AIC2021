// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.time.ZoneId;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.io.IOException;
import java.io.ObjectInputStream;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.ZoneInfo;
import sun.util.calendar.AbstractCalendar;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarUtils;
import aic2021.engine.BytecodeManager;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.Era;
import sun.util.calendar.JulianCalendar;
import sun.util.calendar.Gregorian;

public class GregorianCalendar extends Calendar
{
    public static final int BC = 0;
    static final int BCE = 0;
    public static final int AD = 1;
    static final int CE = 1;
    private static final int EPOCH_OFFSET = 719163;
    private static final int EPOCH_YEAR = 1970;
    static final int[] MONTH_LENGTH;
    static final int[] LEAP_MONTH_LENGTH;
    private static final int ONE_SECOND = 1000;
    private static final int ONE_MINUTE = 60000;
    private static final int ONE_HOUR = 3600000;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;
    static final int[] MIN_VALUES;
    static final int[] LEAST_MAX_VALUES;
    static final int[] MAX_VALUES;
    static final long serialVersionUID = -8125100834729963327L;
    private static final Gregorian gcal;
    private static JulianCalendar jcal;
    private static Era[] jeras;
    static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
    private long gregorianCutover;
    private transient long gregorianCutoverDate;
    private transient int gregorianCutoverYear;
    private transient int gregorianCutoverYearJulian;
    private transient BaseCalendar.Date gdate;
    private transient BaseCalendar.Date cdate;
    private transient BaseCalendar calsys;
    private transient int[] zoneOffsets;
    private transient int[] originalFields;
    private transient long cachedFixedDate;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public GregorianCalendar() {
        try {
            BytecodeManager.incBytecodes(2);
            final TimeZone defaultRef = TimeZone.getDefaultRef();
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(2);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this(defaultRef, default1);
            final boolean zoneShared = true;
            BytecodeManager.incBytecodes(3);
            this.setZoneShared(zoneShared);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GregorianCalendar(final TimeZone timeZone) {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(4);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this(timeZone, default1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GregorianCalendar(final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            final TimeZone defaultRef = TimeZone.getDefaultRef();
            BytecodeManager.incBytecodes(2);
            this(defaultRef, locale);
            final boolean zoneShared = true;
            BytecodeManager.incBytecodes(3);
            this.setZoneShared(zoneShared);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GregorianCalendar(final TimeZone timeZone, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(4);
            super(timeZone, locale);
            this.gregorianCutover = -12219292800000L;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverDate = 577736L;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYear = 1582;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYearJulian = 1582;
            BytecodeManager.incBytecodes(3);
            this.cachedFixedDate = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(3);
            final Gregorian gcal = GregorianCalendar.gcal;
            BytecodeManager.incBytecodes(4);
            this.gdate = gcal.newCalendarDate(timeZone);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final long currentTimeMillis = System.currentTimeMillis();
            BytecodeManager.incBytecodes(1);
            this.setTimeInMillis(currentTimeMillis);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GregorianCalendar(final int n, final int n2, final int n3) {
        try {
            final int n4 = 0;
            final int n5 = 0;
            final int n6 = 0;
            final int n7 = 0;
            BytecodeManager.incBytecodes(9);
            this(n, n2, n3, n4, n5, n6, n7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GregorianCalendar(final int n, final int n2, final int n3, final int n4, final int n5) {
        try {
            final int n6 = 0;
            final int n7 = 0;
            BytecodeManager.incBytecodes(9);
            this(n, n2, n3, n4, n5, n6, n7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GregorianCalendar(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        try {
            final int n7 = 0;
            BytecodeManager.incBytecodes(9);
            this(n, n2, n3, n4, n5, n6, n7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    GregorianCalendar(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        try {
            BytecodeManager.incBytecodes(2);
            this.gregorianCutover = -12219292800000L;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverDate = 577736L;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYear = 1582;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYearJulian = 1582;
            BytecodeManager.incBytecodes(3);
            this.cachedFixedDate = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(3);
            final Gregorian gcal = GregorianCalendar.gcal;
            BytecodeManager.incBytecodes(4);
            final TimeZone zone = this.getZone();
            BytecodeManager.incBytecodes(1);
            this.gdate = gcal.newCalendarDate(zone);
            BytecodeManager.incBytecodes(1);
            final int n8 = 1;
            BytecodeManager.incBytecodes(4);
            this.set(n8, n);
            final int n9 = 2;
            BytecodeManager.incBytecodes(4);
            this.set(n9, n2);
            final int n10 = 5;
            BytecodeManager.incBytecodes(4);
            this.set(n10, n3);
            final int n11 = 12;
            BytecodeManager.incBytecodes(3);
            Label_0204: {
                if (n4 >= n11) {
                    final int n12 = 23;
                    BytecodeManager.incBytecodes(3);
                    if (n4 <= n12) {
                        final int n13 = 9;
                        final int n14 = 1;
                        BytecodeManager.incBytecodes(4);
                        this.internalSet(n13, n14);
                        final int n15 = 10;
                        final int n16 = n4 - 12;
                        BytecodeManager.incBytecodes(6);
                        this.internalSet(n15, n16);
                        BytecodeManager.incBytecodes(1);
                        break Label_0204;
                    }
                }
                final int n17 = 10;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n17, n4);
            }
            final int fieldsComputed = 1536;
            BytecodeManager.incBytecodes(3);
            this.setFieldsComputed(fieldsComputed);
            final int n18 = 11;
            BytecodeManager.incBytecodes(4);
            this.set(n18, n4);
            final int n19 = 12;
            BytecodeManager.incBytecodes(4);
            this.set(n19, n5);
            final int n20 = 13;
            BytecodeManager.incBytecodes(4);
            this.set(n20, n6);
            final int n21 = 14;
            BytecodeManager.incBytecodes(4);
            this.internalSet(n21, n7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    GregorianCalendar(final TimeZone timeZone, final Locale locale, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            super(timeZone, locale);
            this.gregorianCutover = -12219292800000L;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverDate = 577736L;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYear = 1582;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYearJulian = 1582;
            BytecodeManager.incBytecodes(3);
            this.cachedFixedDate = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(3);
            final Gregorian gcal = GregorianCalendar.gcal;
            BytecodeManager.incBytecodes(4);
            final TimeZone zone = this.getZone();
            BytecodeManager.incBytecodes(1);
            this.gdate = gcal.newCalendarDate(zone);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setGregorianChange(final Date date) {
        try {
            BytecodeManager.incBytecodes(2);
            final long time = date.getTime();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(time, this.gregorianCutover);
            BytecodeManager.incBytecodes(5);
            if (n == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            this.complete();
            final long gregorianChange = time;
            BytecodeManager.incBytecodes(3);
            this.setGregorianChange(gregorianChange);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void setGregorianChange(final long n) {
        try {
            this.gregorianCutover = n;
            BytecodeManager.incBytecodes(3);
            final long d = 86400000L;
            BytecodeManager.incBytecodes(4);
            this.gregorianCutoverDate = CalendarUtils.floorDivide(n, d) + 719163L;
            BytecodeManager.incBytecodes(3);
            final long n2 = lcmp(n, Long.MAX_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n2 == 0) {
                ++this.gregorianCutoverDate;
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date gregorianCutoverDate = this.getGregorianCutoverDate();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date = gregorianCutoverDate;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYear = date.getYear();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar julianCalendarSystem = getJulianCalendarSystem();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar = julianCalendarSystem;
            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar.Date date2 = (BaseCalendar.Date)baseCalendar.newCalendarDate(no_TIMEZONE);
            BytecodeManager.incBytecodes(2);
            final BaseCalendar baseCalendar2 = julianCalendarSystem;
            final BaseCalendar.Date date3 = date2;
            final long fixedDate = this.gregorianCutoverDate - 1L;
            BytecodeManager.incBytecodes(7);
            baseCalendar2.getCalendarDateFromFixedDate(date3, fixedDate);
            final BaseCalendar.Date date4 = date2;
            BytecodeManager.incBytecodes(3);
            this.gregorianCutoverYearJulian = date4.getNormalizedYear();
            BytecodeManager.incBytecodes(1);
            final long n3 = lcmp(this.time, this.gregorianCutover);
            BytecodeManager.incBytecodes(6);
            if (n3 < 0) {
                BytecodeManager.incBytecodes(2);
                this.setUnnormalized();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final Date getGregorianChange() {
        try {
            final long gregorianCutover = this.gregorianCutover;
            BytecodeManager.incBytecodes(5);
            final Date date = new Date(gregorianCutover);
            BytecodeManager.incBytecodes(1);
            return date;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isLeapYear(final int n) {
        try {
            final int n2 = n & 0x3;
            BytecodeManager.incBytecodes(4);
            if (n2 != 0) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int gregorianCutoverYear = this.gregorianCutoverYear;
            BytecodeManager.incBytecodes(4);
            if (n > gregorianCutoverYear) {
                final int n3 = n % 100;
                BytecodeManager.incBytecodes(4);
                boolean b2 = false;
                Label_0071: {
                    if (n3 == 0) {
                        final int n4 = n % 400;
                        BytecodeManager.incBytecodes(4);
                        if (n4 != 0) {
                            b2 = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0071;
                        }
                    }
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
            BytecodeManager.incBytecodes(4);
            if (n < gregorianCutoverYearJulian) {
                final boolean b3 = true;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final int gregorianCutoverYear2 = this.gregorianCutoverYear;
            final int gregorianCutoverYearJulian2 = this.gregorianCutoverYearJulian;
            BytecodeManager.incBytecodes(5);
            boolean b5;
            if (gregorianCutoverYear2 == gregorianCutoverYearJulian2) {
                final long gregorianCutoverDate = this.gregorianCutoverDate;
                BytecodeManager.incBytecodes(4);
                final BaseCalendar.Date calendarDate = this.getCalendarDate(gregorianCutoverDate);
                BytecodeManager.incBytecodes(1);
                final BaseCalendar.Date date = calendarDate;
                BytecodeManager.incBytecodes(2);
                final int month = date.getMonth();
                final int n5 = 3;
                BytecodeManager.incBytecodes(2);
                boolean b4;
                if (month < n5) {
                    b4 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b4 = false;
                    BytecodeManager.incBytecodes(1);
                }
                b5 = b4;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int gregorianCutoverYear3 = this.gregorianCutoverYear;
                BytecodeManager.incBytecodes(4);
                boolean b6;
                if (n == gregorianCutoverYear3) {
                    b6 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b6 = false;
                    BytecodeManager.incBytecodes(1);
                }
                b5 = b6;
                BytecodeManager.incBytecodes(1);
            }
            final boolean b7 = b5;
            BytecodeManager.incBytecodes(2);
            boolean b8 = false;
            Label_0271: {
                if (b7) {
                    final int n6 = n % 100;
                    BytecodeManager.incBytecodes(4);
                    if (n6 == 0) {
                        final int n7 = n % 400;
                        BytecodeManager.incBytecodes(4);
                        if (n7 != 0) {
                            b8 = false;
                            BytecodeManager.incBytecodes(2);
                            break Label_0271;
                        }
                    }
                    b8 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b8 = true;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return b8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getCalendarType() {
        try {
            final String s = "gregory";
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            final boolean b = o instanceof GregorianCalendar;
            BytecodeManager.incBytecodes(3);
            boolean b2 = false;
            Label_0070: {
                if (b) {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = super.equals(o);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final long n = lcmp(this.gregorianCutover, ((GregorianCalendar)o).gregorianCutover);
                        BytecodeManager.incBytecodes(7);
                        if (n == 0) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0070;
                        }
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
    public int hashCode() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = super.hashCode() ^ (int)this.gregorianCutoverDate;
            BytecodeManager.incBytecodes(5);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void add(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int n3 = 15;
                BytecodeManager.incBytecodes(3);
                if (n < n3) {
                    BytecodeManager.incBytecodes(2);
                    this.complete();
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n == n4) {
                        final int n5 = 1;
                        BytecodeManager.incBytecodes(3);
                        final int internalGet = this.internalGet(n5);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final int internalGetEra = this.internalGetEra();
                        final int n6 = 1;
                        BytecodeManager.incBytecodes(2);
                        if (internalGetEra == n6) {
                            final int n7 = internalGet + n2;
                            BytecodeManager.incBytecodes(4);
                            final int n8 = n7;
                            BytecodeManager.incBytecodes(2);
                            if (n8 > 0) {
                                final int n9 = 1;
                                final int n10 = n7;
                                BytecodeManager.incBytecodes(4);
                                this.set(n9, n10);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final int n11 = 1;
                                final int n12 = 1 - n7;
                                BytecodeManager.incBytecodes(6);
                                this.set(n11, n12);
                                final int n13 = 0;
                                final int n14 = 0;
                                BytecodeManager.incBytecodes(4);
                                this.set(n13, n14);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        else {
                            final int n15 = internalGet - n2;
                            BytecodeManager.incBytecodes(4);
                            final int n16 = n15;
                            BytecodeManager.incBytecodes(2);
                            if (n16 > 0) {
                                final int n17 = 1;
                                final int n18 = n15;
                                BytecodeManager.incBytecodes(4);
                                this.set(n17, n18);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final int n19 = 1;
                                final int n20 = 1 - n15;
                                BytecodeManager.incBytecodes(6);
                                this.set(n19, n20);
                                final int n21 = 0;
                                final int n22 = 1;
                                BytecodeManager.incBytecodes(4);
                                this.set(n21, n22);
                            }
                        }
                        BytecodeManager.incBytecodes(2);
                        this.pinDayOfMonth();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n23 = 2;
                        BytecodeManager.incBytecodes(3);
                        if (n == n23) {
                            final int n24 = 2;
                            BytecodeManager.incBytecodes(3);
                            final int n25 = this.internalGet(n24) + n2;
                            BytecodeManager.incBytecodes(3);
                            final int n26 = 1;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet2 = this.internalGet(n26);
                            BytecodeManager.incBytecodes(1);
                            final int n27 = n25;
                            BytecodeManager.incBytecodes(2);
                            int n28;
                            if (n27 >= 0) {
                                n28 = n25 / 12;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                n28 = (n25 + 1) / 12 - 1;
                                BytecodeManager.incBytecodes(8);
                            }
                            final int n29 = n28;
                            BytecodeManager.incBytecodes(2);
                            if (n29 != 0) {
                                BytecodeManager.incBytecodes(2);
                                final int internalGetEra2 = this.internalGetEra();
                                final int n30 = 1;
                                BytecodeManager.incBytecodes(2);
                                if (internalGetEra2 == n30) {
                                    final int n31 = internalGet2 + n28;
                                    BytecodeManager.incBytecodes(4);
                                    final int n32 = n31;
                                    BytecodeManager.incBytecodes(2);
                                    if (n32 > 0) {
                                        final int n33 = 1;
                                        final int n34 = n31;
                                        BytecodeManager.incBytecodes(4);
                                        this.set(n33, n34);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final int n35 = 1;
                                        final int n36 = 1 - n31;
                                        BytecodeManager.incBytecodes(6);
                                        this.set(n35, n36);
                                        final int n37 = 0;
                                        final int n38 = 0;
                                        BytecodeManager.incBytecodes(4);
                                        this.set(n37, n38);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                                else {
                                    final int n39 = internalGet2 - n28;
                                    BytecodeManager.incBytecodes(4);
                                    final int n40 = n39;
                                    BytecodeManager.incBytecodes(2);
                                    if (n40 > 0) {
                                        final int n41 = 1;
                                        final int n42 = n39;
                                        BytecodeManager.incBytecodes(4);
                                        this.set(n41, n42);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final int n43 = 1;
                                        final int n44 = 1 - n39;
                                        BytecodeManager.incBytecodes(6);
                                        this.set(n43, n44);
                                        final int n45 = 0;
                                        final int n46 = 1;
                                        BytecodeManager.incBytecodes(4);
                                        this.set(n45, n46);
                                    }
                                }
                            }
                            final int n47 = n25;
                            BytecodeManager.incBytecodes(2);
                            if (n47 >= 0) {
                                final int n48 = 2;
                                final int n49 = n25 % 12;
                                BytecodeManager.incBytecodes(6);
                                this.set(n48, n49);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                int n50 = n25 % 12;
                                BytecodeManager.incBytecodes(4);
                                final int n51 = n50;
                                BytecodeManager.incBytecodes(2);
                                if (n51 < 0) {
                                    n50 += 12;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n52 = 2;
                                final int n53 = 0 + n50;
                                BytecodeManager.incBytecodes(6);
                                this.set(n52, n53);
                            }
                            BytecodeManager.incBytecodes(2);
                            this.pinDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            BytecodeManager.incBytecodes(2);
                            if (n == 0) {
                                final int n54 = 0;
                                BytecodeManager.incBytecodes(3);
                                int n55 = this.internalGet(n54) + n2;
                                BytecodeManager.incBytecodes(3);
                                final int n56 = n55;
                                BytecodeManager.incBytecodes(2);
                                if (n56 < 0) {
                                    n55 = 0;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final int n57 = n55;
                                final int n58 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n57 > n58) {
                                    n55 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final int n59 = 0;
                                final int n60 = n55;
                                BytecodeManager.incBytecodes(4);
                                this.set(n59, n60);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                long n61 = n2;
                                BytecodeManager.incBytecodes(3);
                                long n62 = 0L;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(2);
                                switch (n) {
                                    case 10:
                                    case 11: {
                                        n61 *= 3600000L;
                                        BytecodeManager.incBytecodes(4);
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 12: {
                                        n61 *= 60000L;
                                        BytecodeManager.incBytecodes(4);
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 13: {
                                        n61 *= 1000L;
                                        BytecodeManager.incBytecodes(4);
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 14: {
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 3:
                                    case 4:
                                    case 8: {
                                        n61 *= 7L;
                                        BytecodeManager.incBytecodes(4);
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 5:
                                    case 6:
                                    case 7: {
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 9: {
                                        n61 = n2 / 2;
                                        BytecodeManager.incBytecodes(5);
                                        n62 = 12 * (n2 % 2);
                                        BytecodeManager.incBytecodes(7);
                                        break;
                                    }
                                }
                                final int n63 = 10;
                                BytecodeManager.incBytecodes(3);
                                if (n >= n63) {
                                    final long timeInMillis = this.time + n61;
                                    BytecodeManager.incBytecodes(6);
                                    this.setTimeInMillis(timeInMillis);
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                BytecodeManager.incBytecodes(2);
                                long currentFixedDate = this.getCurrentFixedDate();
                                BytecodeManager.incBytecodes(1);
                                final long n64 = n62;
                                final int n65 = 11;
                                BytecodeManager.incBytecodes(4);
                                final long n66 = n64 + this.internalGet(n65);
                                BytecodeManager.incBytecodes(3);
                                final long n67 = n66 * 60L;
                                BytecodeManager.incBytecodes(4);
                                final long n68 = n67;
                                final int n69 = 12;
                                BytecodeManager.incBytecodes(4);
                                final long n70 = n68 + this.internalGet(n69);
                                BytecodeManager.incBytecodes(3);
                                final long n71 = n70 * 60L;
                                BytecodeManager.incBytecodes(4);
                                final long n72 = n71;
                                final int n73 = 13;
                                BytecodeManager.incBytecodes(4);
                                final long n74 = n72 + this.internalGet(n73);
                                BytecodeManager.incBytecodes(3);
                                final long n75 = n74 * 1000L;
                                BytecodeManager.incBytecodes(4);
                                final long n76 = n75;
                                final int n77 = 14;
                                BytecodeManager.incBytecodes(4);
                                long n78 = n76 + this.internalGet(n77);
                                BytecodeManager.incBytecodes(3);
                                final long n79 = lcmp(n78, 86400000L);
                                BytecodeManager.incBytecodes(4);
                                if (n79 >= 0) {
                                    ++currentFixedDate;
                                    BytecodeManager.incBytecodes(4);
                                    n78 -= 86400000L;
                                    BytecodeManager.incBytecodes(5);
                                }
                                else {
                                    final long n80 = lcmp(n78, 0L);
                                    BytecodeManager.incBytecodes(4);
                                    if (n80 < 0) {
                                        --currentFixedDate;
                                        BytecodeManager.incBytecodes(4);
                                        n78 += 86400000L;
                                        BytecodeManager.incBytecodes(4);
                                    }
                                }
                                final long n81 = currentFixedDate + n61;
                                BytecodeManager.incBytecodes(4);
                                final int n82 = 15;
                                BytecodeManager.incBytecodes(3);
                                final int internalGet3 = this.internalGet(n82);
                                final int n83 = 16;
                                BytecodeManager.incBytecodes(3);
                                final int n84 = internalGet3 + this.internalGet(n83);
                                BytecodeManager.incBytecodes(2);
                                final long timeInMillis2 = (n81 - 719163L) * 86400000L + n78 - n84;
                                BytecodeManager.incBytecodes(12);
                                this.setTimeInMillis(timeInMillis2);
                                final int n85 = n84;
                                final int n86 = 15;
                                BytecodeManager.incBytecodes(4);
                                final int internalGet4 = this.internalGet(n86);
                                final int n87 = 16;
                                BytecodeManager.incBytecodes(3);
                                final int n88 = n85 - (internalGet4 + this.internalGet(n87));
                                BytecodeManager.incBytecodes(3);
                                final int n89 = n88;
                                BytecodeManager.incBytecodes(2);
                                if (n89 != 0) {
                                    final long timeInMillis3 = this.time + n88;
                                    BytecodeManager.incBytecodes(7);
                                    this.setTimeInMillis(timeInMillis3);
                                    BytecodeManager.incBytecodes(2);
                                    final long currentFixedDate2 = this.getCurrentFixedDate();
                                    BytecodeManager.incBytecodes(1);
                                    final long n90 = lcmp(currentFixedDate2, n81);
                                    BytecodeManager.incBytecodes(4);
                                    if (n90 != 0) {
                                        final long timeInMillis4 = this.time - n88;
                                        BytecodeManager.incBytecodes(7);
                                        this.setTimeInMillis(timeInMillis4);
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
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
    
    @Override
    public void roll(final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            int n2;
            if (b) {
                n2 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = -1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            this.roll(n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void roll(final int n, int n2) {
        try {
            final boolean b = n2 != 0;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int n3 = 15;
                BytecodeManager.incBytecodes(3);
                if (n < n3) {
                    BytecodeManager.incBytecodes(2);
                    this.complete();
                    BytecodeManager.incBytecodes(3);
                    int minimum = this.getMinimum(n);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(3);
                    int n4 = this.getMaximum(n);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    switch (n) {
                        case 0:
                        case 1:
                        case 9:
                        case 12:
                        case 13:
                        case 14: {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 10:
                        case 11: {
                            final int n5 = n4 + 1;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(3);
                            final int internalGet = this.internalGet(n);
                            BytecodeManager.incBytecodes(1);
                            int n6 = (internalGet + n2) % n5;
                            BytecodeManager.incBytecodes(6);
                            final int n7 = n6;
                            BytecodeManager.incBytecodes(2);
                            if (n7 < 0) {
                                n6 += n5;
                                BytecodeManager.incBytecodes(4);
                            }
                            this.time += 3600000 * (n6 - internalGet);
                            BytecodeManager.incBytecodes(11);
                            final BaseCalendar calsys = this.calsys;
                            final long time = this.time;
                            BytecodeManager.incBytecodes(6);
                            final TimeZone zone = this.getZone();
                            BytecodeManager.incBytecodes(1);
                            final CalendarDate calendarDate = calsys.getCalendarDate(time, zone);
                            BytecodeManager.incBytecodes(1);
                            final int n8 = 5;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet2 = this.internalGet(n8);
                            final CalendarDate calendarDate2 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int dayOfMonth = calendarDate2.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            if (internalGet2 != dayOfMonth) {
                                final CalendarDate calendarDate3 = calendarDate;
                                final int n9 = 1;
                                BytecodeManager.incBytecodes(4);
                                final int internalGet3 = this.internalGet(n9);
                                final int n10 = 2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final int month = this.internalGet(n10) + 1;
                                final int n11 = 5;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final int internalGet4 = this.internalGet(n11);
                                BytecodeManager.incBytecodes(1);
                                calendarDate3.setDate(internalGet3, month, internalGet4);
                                BytecodeManager.incBytecodes(1);
                                final int n12 = 10;
                                BytecodeManager.incBytecodes(3);
                                if (n == n12) {
                                    final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
                                    BytecodeManager.incBytecodes(2);
                                    if (!$assertionsDisabled) {
                                        final int n13 = 9;
                                        BytecodeManager.incBytecodes(3);
                                        final int internalGet5 = this.internalGet(n13);
                                        final int n14 = 1;
                                        BytecodeManager.incBytecodes(2);
                                        if (internalGet5 != n14) {
                                            BytecodeManager.incBytecodes(3);
                                            final AssertionError assertionError = new AssertionError();
                                            BytecodeManager.incBytecodes(1);
                                            throw assertionError;
                                        }
                                    }
                                    final CalendarDate calendarDate4 = calendarDate;
                                    final int n15 = 12;
                                    BytecodeManager.incBytecodes(3);
                                    calendarDate4.addHours(n15);
                                    BytecodeManager.incBytecodes(1);
                                }
                                final BaseCalendar calsys2 = this.calsys;
                                final CalendarDate date = calendarDate;
                                BytecodeManager.incBytecodes(5);
                                this.time = calsys2.getTime(date);
                                BytecodeManager.incBytecodes(1);
                            }
                            final CalendarDate calendarDate5 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int hours = calendarDate5.getHours();
                            BytecodeManager.incBytecodes(1);
                            final int n16 = hours % n5;
                            BytecodeManager.incBytecodes(6);
                            this.internalSet(n, n16);
                            final int n17 = 10;
                            BytecodeManager.incBytecodes(3);
                            if (n == n17) {
                                final int n18 = 11;
                                final int n19 = hours;
                                BytecodeManager.incBytecodes(4);
                                this.internalSet(n18, n19);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final int n20 = 9;
                                final int n21 = hours / 12;
                                BytecodeManager.incBytecodes(6);
                                this.internalSet(n20, n21);
                                final int n22 = 10;
                                final int n23 = hours % 12;
                                BytecodeManager.incBytecodes(6);
                                this.internalSet(n22, n23);
                            }
                            final CalendarDate calendarDate6 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int zoneOffset = calendarDate6.getZoneOffset();
                            BytecodeManager.incBytecodes(1);
                            final CalendarDate calendarDate7 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int daylightSaving = calendarDate7.getDaylightSaving();
                            BytecodeManager.incBytecodes(1);
                            final int n24 = 15;
                            final int n25 = zoneOffset - daylightSaving;
                            BytecodeManager.incBytecodes(6);
                            this.internalSet(n24, n25);
                            final int n26 = 16;
                            final int n27 = daylightSaving;
                            BytecodeManager.incBytecodes(4);
                            this.internalSet(n26, n27);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 2: {
                            final BaseCalendar.Date cdate = this.cdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear = cdate.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean cutoverYear = this.isCutoverYear(normalizedYear);
                            BytecodeManager.incBytecodes(1);
                            if (!cutoverYear) {
                                final int n28 = 2;
                                BytecodeManager.incBytecodes(3);
                                int n29 = (this.internalGet(n28) + n2) % 12;
                                BytecodeManager.incBytecodes(5);
                                final int n30 = n29;
                                BytecodeManager.incBytecodes(2);
                                if (n30 < 0) {
                                    n29 += 12;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n31 = 2;
                                final int n32 = n29;
                                BytecodeManager.incBytecodes(4);
                                this.set(n31, n32);
                                final int n33 = n29;
                                BytecodeManager.incBytecodes(3);
                                final int monthLength = this.monthLength(n33);
                                BytecodeManager.incBytecodes(1);
                                final int n34 = 5;
                                BytecodeManager.incBytecodes(3);
                                final int internalGet6 = this.internalGet(n34);
                                final int n35 = monthLength;
                                BytecodeManager.incBytecodes(2);
                                if (internalGet6 > n35) {
                                    final int n36 = 5;
                                    final int n37 = monthLength;
                                    BytecodeManager.incBytecodes(4);
                                    this.set(n36, n37);
                                }
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final int n38 = 2;
                                BytecodeManager.incBytecodes(3);
                                final int n39 = this.getActualMaximum(n38) + 1;
                                BytecodeManager.incBytecodes(3);
                                final int n40 = 2;
                                BytecodeManager.incBytecodes(3);
                                int n41 = (this.internalGet(n40) + n2) % n39;
                                BytecodeManager.incBytecodes(5);
                                final int n42 = n41;
                                BytecodeManager.incBytecodes(2);
                                if (n42 < 0) {
                                    n41 += n39;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final int n43 = 2;
                                final int n44 = n41;
                                BytecodeManager.incBytecodes(4);
                                this.set(n43, n44);
                                final int n45 = 5;
                                BytecodeManager.incBytecodes(3);
                                final int actualMaximum = this.getActualMaximum(n45);
                                BytecodeManager.incBytecodes(1);
                                final int n46 = 5;
                                BytecodeManager.incBytecodes(3);
                                final int internalGet7 = this.internalGet(n46);
                                final int n47 = actualMaximum;
                                BytecodeManager.incBytecodes(2);
                                if (internalGet7 > n47) {
                                    final int n48 = 5;
                                    final int n49 = actualMaximum;
                                    BytecodeManager.incBytecodes(4);
                                    this.set(n48, n49);
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 3: {
                            final BaseCalendar.Date cdate2 = this.cdate;
                            BytecodeManager.incBytecodes(3);
                            final int normalizedYear2 = cdate2.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final int n50 = 3;
                            BytecodeManager.incBytecodes(3);
                            int actualMaximum2 = this.getActualMaximum(n50);
                            BytecodeManager.incBytecodes(1);
                            final int n51 = 7;
                            final int n52 = 7;
                            BytecodeManager.incBytecodes(5);
                            final int internalGet8 = this.internalGet(n52);
                            BytecodeManager.incBytecodes(1);
                            this.set(n51, internalGet8);
                            final int n53 = 3;
                            BytecodeManager.incBytecodes(3);
                            int internalGet9 = this.internalGet(n53);
                            BytecodeManager.incBytecodes(1);
                            final int n54 = internalGet9 + n2;
                            BytecodeManager.incBytecodes(4);
                            final int n55 = normalizedYear2;
                            BytecodeManager.incBytecodes(3);
                            final boolean cutoverYear2 = this.isCutoverYear(n55);
                            BytecodeManager.incBytecodes(1);
                            if (!cutoverYear2) {
                                BytecodeManager.incBytecodes(2);
                                final int weekYear = this.getWeekYear();
                                BytecodeManager.incBytecodes(1);
                                final int n56 = weekYear;
                                final int n57 = normalizedYear2;
                                BytecodeManager.incBytecodes(3);
                                if (n56 == n57) {
                                    final int n58 = n54;
                                    final int n59 = minimum;
                                    BytecodeManager.incBytecodes(3);
                                    if (n58 > n59) {
                                        final int n60 = n54;
                                        final int n61 = actualMaximum2;
                                        BytecodeManager.incBytecodes(3);
                                        if (n60 < n61) {
                                            final int n62 = 3;
                                            final int n63 = n54;
                                            BytecodeManager.incBytecodes(4);
                                            this.set(n62, n63);
                                            BytecodeManager.incBytecodes(1);
                                            return;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(2);
                                    final long currentFixedDate = this.getCurrentFixedDate();
                                    BytecodeManager.incBytecodes(1);
                                    final long n64 = currentFixedDate - 7 * (internalGet9 - minimum);
                                    BytecodeManager.incBytecodes(9);
                                    final BaseCalendar calsys3 = this.calsys;
                                    final long fixedDate = n64;
                                    BytecodeManager.incBytecodes(4);
                                    final int yearFromFixedDate = calsys3.getYearFromFixedDate(fixedDate);
                                    final int n65 = normalizedYear2;
                                    BytecodeManager.incBytecodes(2);
                                    if (yearFromFixedDate != n65) {
                                        ++minimum;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final long n66 = currentFixedDate;
                                    final int n67 = 7;
                                    final int n68 = actualMaximum2;
                                    final int n69 = 3;
                                    BytecodeManager.incBytecodes(6);
                                    final long n70 = n66 + n67 * (n68 - this.internalGet(n69));
                                    BytecodeManager.incBytecodes(5);
                                    final BaseCalendar calsys4 = this.calsys;
                                    final long fixedDate2 = n70;
                                    BytecodeManager.incBytecodes(4);
                                    final int yearFromFixedDate2 = calsys4.getYearFromFixedDate(fixedDate2);
                                    final int n71 = normalizedYear2;
                                    BytecodeManager.incBytecodes(2);
                                    if (yearFromFixedDate2 != n71) {
                                        --actualMaximum2;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final int n72 = weekYear;
                                    final int n73 = normalizedYear2;
                                    BytecodeManager.incBytecodes(3);
                                    if (n72 > n73) {
                                        final int n74 = n2;
                                        BytecodeManager.incBytecodes(2);
                                        if (n74 < 0) {
                                            ++n2;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        internalGet9 = actualMaximum2;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    else {
                                        final int n75 = n2;
                                        BytecodeManager.incBytecodes(2);
                                        if (n75 > 0) {
                                            n2 -= internalGet9 - actualMaximum2;
                                            BytecodeManager.incBytecodes(6);
                                        }
                                        internalGet9 = minimum;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                }
                                final int n76 = internalGet9;
                                final int n77 = n2;
                                final int n78 = minimum;
                                final int n79 = actualMaximum2;
                                BytecodeManager.incBytecodes(7);
                                final int rolledValue = getRolledValue(n76, n77, n78, n79);
                                BytecodeManager.incBytecodes(1);
                                this.set(n, rolledValue);
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long currentFixedDate2 = this.getCurrentFixedDate();
                            BytecodeManager.incBytecodes(1);
                            final int gregorianCutoverYear = this.gregorianCutoverYear;
                            final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                            BytecodeManager.incBytecodes(5);
                            BaseCalendar baseCalendar;
                            if (gregorianCutoverYear == gregorianCutoverYearJulian) {
                                BytecodeManager.incBytecodes(2);
                                baseCalendar = this.getCutoverCalendarSystem();
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final int n80 = normalizedYear2;
                                final int gregorianCutoverYear2 = this.gregorianCutoverYear;
                                BytecodeManager.incBytecodes(4);
                                if (n80 == gregorianCutoverYear2) {
                                    baseCalendar = GregorianCalendar.gcal;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    BytecodeManager.incBytecodes(1);
                                    baseCalendar = getJulianCalendarSystem();
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final long n81 = currentFixedDate2 - 7 * (internalGet9 - minimum);
                            BytecodeManager.incBytecodes(9);
                            final BaseCalendar baseCalendar2 = baseCalendar;
                            final long fixedDate3 = n81;
                            BytecodeManager.incBytecodes(3);
                            final int yearFromFixedDate3 = baseCalendar2.getYearFromFixedDate(fixedDate3);
                            final int n82 = normalizedYear2;
                            BytecodeManager.incBytecodes(2);
                            if (yearFromFixedDate3 != n82) {
                                ++minimum;
                                BytecodeManager.incBytecodes(1);
                            }
                            final long n83 = currentFixedDate2 + 7 * (actualMaximum2 - internalGet9);
                            BytecodeManager.incBytecodes(9);
                            final long n84 = lcmp(n83, this.gregorianCutoverDate);
                            BytecodeManager.incBytecodes(5);
                            BaseCalendar baseCalendar3;
                            if (n84 >= 0) {
                                baseCalendar3 = GregorianCalendar.gcal;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                BytecodeManager.incBytecodes(1);
                                baseCalendar3 = getJulianCalendarSystem();
                            }
                            final BaseCalendar baseCalendar4 = baseCalendar3;
                            BytecodeManager.incBytecodes(1);
                            final BaseCalendar baseCalendar5 = baseCalendar4;
                            final long fixedDate4 = n83;
                            BytecodeManager.incBytecodes(3);
                            final int yearFromFixedDate4 = baseCalendar5.getYearFromFixedDate(fixedDate4);
                            final int n85 = normalizedYear2;
                            BytecodeManager.incBytecodes(2);
                            if (yearFromFixedDate4 != n85) {
                                --actualMaximum2;
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n86 = internalGet9;
                            final int n87 = n2;
                            final int n88 = minimum;
                            final int n89 = actualMaximum2;
                            BytecodeManager.incBytecodes(5);
                            final int n90 = getRolledValue(n86, n87, n88, n89) - 1;
                            BytecodeManager.incBytecodes(3);
                            final long n91 = n81 + n90 * 7;
                            BytecodeManager.incBytecodes(8);
                            final BaseCalendar.Date calendarDate8 = this.getCalendarDate(n91);
                            BytecodeManager.incBytecodes(1);
                            final int n92 = 2;
                            final BaseCalendar.Date date2 = calendarDate8;
                            BytecodeManager.incBytecodes(4);
                            final int n93 = date2.getMonth() - 1;
                            BytecodeManager.incBytecodes(3);
                            this.set(n92, n93);
                            final int n94 = 5;
                            final BaseCalendar.Date date3 = calendarDate8;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth2 = date3.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n94, dayOfMonth2);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 4: {
                            final BaseCalendar.Date cdate3 = this.cdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear3 = cdate3.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean cutoverYear3 = this.isCutoverYear(normalizedYear3);
                            BytecodeManager.incBytecodes(1);
                            final int n95 = 7;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet10 = this.internalGet(n95);
                            BytecodeManager.incBytecodes(2);
                            int n96 = internalGet10 - this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(2);
                            final int n97 = n96;
                            BytecodeManager.incBytecodes(2);
                            if (n97 < 0) {
                                n96 += 7;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(2);
                            final long currentFixedDate3 = this.getCurrentFixedDate();
                            BytecodeManager.incBytecodes(1);
                            final boolean b2 = cutoverYear3;
                            BytecodeManager.incBytecodes(2);
                            long fixedDateMonth1;
                            int n99;
                            if (b2) {
                                final BaseCalendar.Date cdate4 = this.cdate;
                                final long n98 = currentFixedDate3;
                                BytecodeManager.incBytecodes(5);
                                fixedDateMonth1 = this.getFixedDateMonth1(cdate4, n98);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(2);
                                n99 = this.actualMonthLength();
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final long n100 = currentFixedDate3;
                                final int n101 = 5;
                                BytecodeManager.incBytecodes(4);
                                fixedDateMonth1 = n100 - this.internalGet(n101) + 1L;
                                BytecodeManager.incBytecodes(5);
                                final BaseCalendar calsys5 = this.calsys;
                                final BaseCalendar.Date cdate5 = this.cdate;
                                BytecodeManager.incBytecodes(5);
                                n99 = calsys5.getMonthLength(cdate5);
                                BytecodeManager.incBytecodes(1);
                            }
                            final long fixedDate5 = fixedDateMonth1 + 6L;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final int firstDayOfWeek = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                            long dayOfWeekDateOnOrBefore = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate5, firstDayOfWeek);
                            BytecodeManager.incBytecodes(1);
                            final int n102 = (int)(dayOfWeekDateOnOrBefore - fixedDateMonth1);
                            BytecodeManager.incBytecodes(6);
                            final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
                            BytecodeManager.incBytecodes(1);
                            if (n102 >= minimalDaysInFirstWeek) {
                                dayOfWeekDateOnOrBefore -= 7L;
                                BytecodeManager.incBytecodes(4);
                            }
                            BytecodeManager.incBytecodes(3);
                            final int actualMaximum3 = this.getActualMaximum(n);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(3);
                            final int internalGet11 = this.internalGet(n);
                            final int n103 = n2;
                            final int n104 = 1;
                            final int n105 = actualMaximum3;
                            BytecodeManager.incBytecodes(4);
                            final int n106 = getRolledValue(internalGet11, n103, n104, n105) - 1;
                            BytecodeManager.incBytecodes(3);
                            long n107 = dayOfWeekDateOnOrBefore + n106 * 7 + n96;
                            BytecodeManager.incBytecodes(10);
                            final long n108 = lcmp(n107, fixedDateMonth1);
                            BytecodeManager.incBytecodes(4);
                            if (n108 < 0) {
                                n107 = fixedDateMonth1;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final long n109 = lcmp(n107, fixedDateMonth1 + n99);
                                BytecodeManager.incBytecodes(7);
                                if (n109 >= 0) {
                                    n107 = fixedDateMonth1 + n99 - 1L;
                                    BytecodeManager.incBytecodes(7);
                                }
                            }
                            final boolean b3 = cutoverYear3;
                            BytecodeManager.incBytecodes(2);
                            int dayOfMonth3;
                            if (b3) {
                                final long n110 = n107;
                                BytecodeManager.incBytecodes(3);
                                final BaseCalendar.Date calendarDate9 = this.getCalendarDate(n110);
                                BytecodeManager.incBytecodes(1);
                                final BaseCalendar.Date date4 = calendarDate9;
                                BytecodeManager.incBytecodes(2);
                                dayOfMonth3 = date4.getDayOfMonth();
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                dayOfMonth3 = (int)(n107 - fixedDateMonth1) + 1;
                                BytecodeManager.incBytecodes(7);
                            }
                            final int n111 = 5;
                            final int n112 = dayOfMonth3;
                            BytecodeManager.incBytecodes(4);
                            this.set(n111, n112);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 5: {
                            final BaseCalendar.Date cdate6 = this.cdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear4 = cdate6.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean cutoverYear4 = this.isCutoverYear(normalizedYear4);
                            BytecodeManager.incBytecodes(1);
                            if (!cutoverYear4) {
                                final BaseCalendar calsys6 = this.calsys;
                                final BaseCalendar.Date cdate7 = this.cdate;
                                BytecodeManager.incBytecodes(5);
                                n4 = calsys6.getMonthLength(cdate7);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long currentFixedDate4 = this.getCurrentFixedDate();
                            BytecodeManager.incBytecodes(1);
                            final BaseCalendar.Date cdate8 = this.cdate;
                            final long n113 = currentFixedDate4;
                            BytecodeManager.incBytecodes(5);
                            final long fixedDateMonth2 = this.getFixedDateMonth1(cdate8, n113);
                            BytecodeManager.incBytecodes(1);
                            final int n114 = (int)(currentFixedDate4 - fixedDateMonth2);
                            final int n115 = n2;
                            final int n116 = 0;
                            BytecodeManager.incBytecodes(8);
                            final int n117 = this.actualMonthLength() - 1;
                            BytecodeManager.incBytecodes(3);
                            final int rolledValue2 = getRolledValue(n114, n115, n116, n117);
                            BytecodeManager.incBytecodes(1);
                            final long n118 = fixedDateMonth2 + rolledValue2;
                            BytecodeManager.incBytecodes(6);
                            final BaseCalendar.Date calendarDate10 = this.getCalendarDate(n118);
                            BytecodeManager.incBytecodes(1);
                            final boolean $assertionsDisabled2 = GregorianCalendar.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled2) {
                                final BaseCalendar.Date date5 = calendarDate10;
                                BytecodeManager.incBytecodes(2);
                                final int n119 = date5.getMonth() - 1;
                                final int n120 = 2;
                                BytecodeManager.incBytecodes(5);
                                final int internalGet12 = this.internalGet(n120);
                                BytecodeManager.incBytecodes(1);
                                if (n119 != internalGet12) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError2 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError2;
                                }
                            }
                            final int n121 = 5;
                            final BaseCalendar.Date date6 = calendarDate10;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth4 = date6.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n121, dayOfMonth4);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 6: {
                            BytecodeManager.incBytecodes(3);
                            n4 = this.getActualMaximum(n);
                            BytecodeManager.incBytecodes(1);
                            final BaseCalendar.Date cdate9 = this.cdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear5 = cdate9.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean cutoverYear5 = this.isCutoverYear(normalizedYear5);
                            BytecodeManager.incBytecodes(1);
                            if (!cutoverYear5) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long currentFixedDate5 = this.getCurrentFixedDate();
                            BytecodeManager.incBytecodes(1);
                            final long n122 = currentFixedDate5;
                            final int n123 = 6;
                            BytecodeManager.incBytecodes(4);
                            final long n124 = n122 - this.internalGet(n123) + 1L;
                            BytecodeManager.incBytecodes(5);
                            final int n125 = (int)(currentFixedDate5 - n124) + 1;
                            final int n126 = n2;
                            final int n127 = minimum;
                            final int n128 = n4;
                            BytecodeManager.incBytecodes(10);
                            final int rolledValue3 = getRolledValue(n125, n126, n127, n128);
                            BytecodeManager.incBytecodes(1);
                            final long n129 = n124 + rolledValue3 - 1L;
                            BytecodeManager.incBytecodes(8);
                            final BaseCalendar.Date calendarDate11 = this.getCalendarDate(n129);
                            BytecodeManager.incBytecodes(1);
                            final int n130 = 2;
                            final BaseCalendar.Date date7 = calendarDate11;
                            BytecodeManager.incBytecodes(4);
                            final int n131 = date7.getMonth() - 1;
                            BytecodeManager.incBytecodes(3);
                            this.set(n130, n131);
                            final int n132 = 5;
                            final BaseCalendar.Date date8 = calendarDate11;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth5 = date8.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n132, dayOfMonth5);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 7: {
                            final BaseCalendar.Date cdate10 = this.cdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear6 = cdate10.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean cutoverYear6 = this.isCutoverYear(normalizedYear6);
                            BytecodeManager.incBytecodes(1);
                            if (!cutoverYear6) {
                                final int n133 = 3;
                                BytecodeManager.incBytecodes(3);
                                final int internalGet13 = this.internalGet(n133);
                                BytecodeManager.incBytecodes(1);
                                final int n134 = internalGet13;
                                final int n135 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n134 > n135) {
                                    final int n136 = internalGet13;
                                    final int n137 = 52;
                                    BytecodeManager.incBytecodes(3);
                                    if (n136 < n137) {
                                        final int n138 = 3;
                                        final int n139 = internalGet13;
                                        BytecodeManager.incBytecodes(4);
                                        this.set(n138, n139);
                                        n4 = 7;
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                }
                            }
                            n2 %= 7;
                            BytecodeManager.incBytecodes(4);
                            final boolean b4 = n2 != 0;
                            BytecodeManager.incBytecodes(2);
                            if (!b4) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long currentFixedDate6 = this.getCurrentFixedDate();
                            BytecodeManager.incBytecodes(1);
                            final long fixedDate6 = currentFixedDate6;
                            BytecodeManager.incBytecodes(3);
                            final int firstDayOfWeek2 = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                            final long dayOfWeekDateOnOrBefore2 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate6, firstDayOfWeek2);
                            BytecodeManager.incBytecodes(1);
                            long n140 = currentFixedDate6 + n2;
                            BytecodeManager.incBytecodes(5);
                            final long n141 = lcmp(n140, dayOfWeekDateOnOrBefore2);
                            BytecodeManager.incBytecodes(4);
                            if (n141 < 0) {
                                n140 += 7L;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                final long n142 = lcmp(n140, dayOfWeekDateOnOrBefore2 + 7L);
                                BytecodeManager.incBytecodes(6);
                                if (n142 >= 0) {
                                    n140 -= 7L;
                                    BytecodeManager.incBytecodes(4);
                                }
                            }
                            final long n143 = n140;
                            BytecodeManager.incBytecodes(3);
                            final BaseCalendar.Date calendarDate12 = this.getCalendarDate(n143);
                            BytecodeManager.incBytecodes(1);
                            final int n144 = 0;
                            final BaseCalendar.Date date9 = calendarDate12;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear7 = date9.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            int n145;
                            if (normalizedYear7 <= 0) {
                                n145 = 0;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                n145 = 1;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            this.set(n144, n145);
                            final BaseCalendar.Date date10 = calendarDate12;
                            BytecodeManager.incBytecodes(3);
                            final int year = date10.getYear();
                            final BaseCalendar.Date date11 = calendarDate12;
                            BytecodeManager.incBytecodes(2);
                            final int n146 = date11.getMonth() - 1;
                            final BaseCalendar.Date date12 = calendarDate12;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth6 = date12.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(year, n146, dayOfMonth6);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 8: {
                            minimum = 1;
                            BytecodeManager.incBytecodes(2);
                            final BaseCalendar.Date cdate11 = this.cdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear8 = cdate11.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean cutoverYear7 = this.isCutoverYear(normalizedYear8);
                            BytecodeManager.incBytecodes(1);
                            if (!cutoverYear7) {
                                final int n147 = 5;
                                BytecodeManager.incBytecodes(3);
                                final int internalGet14 = this.internalGet(n147);
                                BytecodeManager.incBytecodes(1);
                                final BaseCalendar calsys7 = this.calsys;
                                final BaseCalendar.Date cdate12 = this.cdate;
                                BytecodeManager.incBytecodes(5);
                                final int monthLength2 = calsys7.getMonthLength(cdate12);
                                BytecodeManager.incBytecodes(1);
                                final int n148 = monthLength2 % 7;
                                BytecodeManager.incBytecodes(4);
                                n4 = monthLength2 / 7;
                                BytecodeManager.incBytecodes(4);
                                final int n149 = (internalGet14 - 1) % 7;
                                BytecodeManager.incBytecodes(6);
                                final int n150 = n149;
                                final int n151 = n148;
                                BytecodeManager.incBytecodes(3);
                                if (n150 < n151) {
                                    ++n4;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n152 = 7;
                                final int n153 = 7;
                                BytecodeManager.incBytecodes(5);
                                final int internalGet15 = this.internalGet(n153);
                                BytecodeManager.incBytecodes(1);
                                this.set(n152, internalGet15);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long currentFixedDate7 = this.getCurrentFixedDate();
                            BytecodeManager.incBytecodes(1);
                            final BaseCalendar.Date cdate13 = this.cdate;
                            final long n154 = currentFixedDate7;
                            BytecodeManager.incBytecodes(5);
                            final long fixedDateMonth3 = this.getFixedDateMonth1(cdate13, n154);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            final int actualMonthLength = this.actualMonthLength();
                            BytecodeManager.incBytecodes(1);
                            final int n155 = actualMonthLength % 7;
                            BytecodeManager.incBytecodes(4);
                            int n156 = actualMonthLength / 7;
                            BytecodeManager.incBytecodes(4);
                            final int n157 = (int)(currentFixedDate7 - fixedDateMonth3) % 7;
                            BytecodeManager.incBytecodes(7);
                            final int n158 = n157;
                            final int n159 = n155;
                            BytecodeManager.incBytecodes(3);
                            if (n158 < n159) {
                                ++n156;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(3);
                            final int internalGet16 = this.internalGet(n);
                            final int n160 = n2;
                            final int n161 = minimum;
                            final int n162 = n156;
                            BytecodeManager.incBytecodes(4);
                            final int n163 = getRolledValue(internalGet16, n160, n161, n162) - 1;
                            BytecodeManager.incBytecodes(3);
                            final long n164 = fixedDateMonth3 + n163 * 7 + n157;
                            BytecodeManager.incBytecodes(10);
                            final long n165 = lcmp(n164, this.gregorianCutoverDate);
                            BytecodeManager.incBytecodes(5);
                            BaseCalendar baseCalendar6;
                            if (n165 >= 0) {
                                baseCalendar6 = GregorianCalendar.gcal;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                BytecodeManager.incBytecodes(1);
                                baseCalendar6 = getJulianCalendarSystem();
                            }
                            final BaseCalendar baseCalendar7 = baseCalendar6;
                            BytecodeManager.incBytecodes(1);
                            final BaseCalendar baseCalendar8 = baseCalendar7;
                            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
                            BytecodeManager.incBytecodes(3);
                            final BaseCalendar.Date date13 = (BaseCalendar.Date)baseCalendar8.newCalendarDate(no_TIMEZONE);
                            BytecodeManager.incBytecodes(2);
                            final BaseCalendar baseCalendar9 = baseCalendar7;
                            final BaseCalendar.Date date14 = date13;
                            final long fixedDate7 = n164;
                            BytecodeManager.incBytecodes(4);
                            baseCalendar9.getCalendarDateFromFixedDate(date14, fixedDate7);
                            final int n166 = 5;
                            final BaseCalendar.Date date15 = date13;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth7 = date15.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n166, dayOfMonth7);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    BytecodeManager.incBytecodes(5);
                    final int internalGet17 = this.internalGet(n);
                    final int n167 = n2;
                    final int n168 = minimum;
                    final int n169 = n4;
                    BytecodeManager.incBytecodes(4);
                    final int rolledValue4 = getRolledValue(internalGet17, n167, n168, n169);
                    BytecodeManager.incBytecodes(1);
                    this.set(n, rolledValue4);
                    BytecodeManager.incBytecodes(1);
                    return;
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
    
    @Override
    public int getMinimum(final int n) {
        try {
            final int n2 = GregorianCalendar.MIN_VALUES[n];
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getMaximum(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 8: {
                    final int gregorianCutoverYear = this.gregorianCutoverYear;
                    final int n2 = 200;
                    BytecodeManager.incBytecodes(4);
                    if (gregorianCutoverYear > n2) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    final GregorianCalendar gregorianCalendar = (GregorianCalendar)this.clone();
                    BytecodeManager.incBytecodes(2);
                    final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
                    final boolean lenient = true;
                    BytecodeManager.incBytecodes(3);
                    gregorianCalendar2.setLenient(lenient);
                    final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
                    final long gregorianCutover = this.gregorianCutover;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar3.setTimeInMillis(gregorianCutover);
                    final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
                    BytecodeManager.incBytecodes(3);
                    final int actualMaximum = gregorianCalendar4.getActualMaximum(n);
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar5 = gregorianCalendar;
                    final long timeInMillis = this.gregorianCutover - 1L;
                    BytecodeManager.incBytecodes(6);
                    gregorianCalendar5.setTimeInMillis(timeInMillis);
                    final GregorianCalendar gregorianCalendar6 = gregorianCalendar;
                    BytecodeManager.incBytecodes(3);
                    final int actualMaximum2 = gregorianCalendar6.getActualMaximum(n);
                    BytecodeManager.incBytecodes(1);
                    final int a = GregorianCalendar.MAX_VALUES[n];
                    final int a2 = actualMaximum;
                    final int b = actualMaximum2;
                    BytecodeManager.incBytecodes(6);
                    final int max = Math.max(a2, b);
                    BytecodeManager.incBytecodes(1);
                    final int max2 = Math.max(a, max);
                    BytecodeManager.incBytecodes(1);
                    return max2;
                }
            }
            final int n3 = GregorianCalendar.MAX_VALUES[n];
            BytecodeManager.incBytecodes(4);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getGreatestMinimum(final int n) {
        try {
            final int n2 = 5;
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                BytecodeManager.incBytecodes(2);
                final BaseCalendar.Date gregorianCutoverDate = this.getGregorianCutoverDate();
                BytecodeManager.incBytecodes(1);
                final BaseCalendar.Date date = gregorianCutoverDate;
                final long gregorianCutoverDate2 = this.gregorianCutoverDate;
                BytecodeManager.incBytecodes(5);
                final long fixedDateMonth1 = this.getFixedDateMonth1(date, gregorianCutoverDate2);
                BytecodeManager.incBytecodes(1);
                final long n3 = fixedDateMonth1;
                BytecodeManager.incBytecodes(3);
                final BaseCalendar.Date calendarDate = this.getCalendarDate(n3);
                BytecodeManager.incBytecodes(1);
                final int a = GregorianCalendar.MIN_VALUES[n];
                final BaseCalendar.Date date2 = calendarDate;
                BytecodeManager.incBytecodes(5);
                final int dayOfMonth = date2.getDayOfMonth();
                BytecodeManager.incBytecodes(1);
                final int max = Math.max(a, dayOfMonth);
                BytecodeManager.incBytecodes(1);
                return max;
            }
            final int n4 = GregorianCalendar.MIN_VALUES[n];
            BytecodeManager.incBytecodes(4);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getLeastMaximum(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 8: {
                    BytecodeManager.incBytecodes(2);
                    final GregorianCalendar gregorianCalendar = (GregorianCalendar)this.clone();
                    BytecodeManager.incBytecodes(2);
                    final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
                    final boolean lenient = true;
                    BytecodeManager.incBytecodes(3);
                    gregorianCalendar2.setLenient(lenient);
                    final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
                    final long gregorianCutover = this.gregorianCutover;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar3.setTimeInMillis(gregorianCutover);
                    final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
                    BytecodeManager.incBytecodes(3);
                    final int actualMaximum = gregorianCalendar4.getActualMaximum(n);
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar5 = gregorianCalendar;
                    final long timeInMillis = this.gregorianCutover - 1L;
                    BytecodeManager.incBytecodes(6);
                    gregorianCalendar5.setTimeInMillis(timeInMillis);
                    final GregorianCalendar gregorianCalendar6 = gregorianCalendar;
                    BytecodeManager.incBytecodes(3);
                    final int actualMaximum2 = gregorianCalendar6.getActualMaximum(n);
                    BytecodeManager.incBytecodes(1);
                    final int a = GregorianCalendar.LEAST_MAX_VALUES[n];
                    final int a2 = actualMaximum;
                    final int b = actualMaximum2;
                    BytecodeManager.incBytecodes(6);
                    final int min = Math.min(a2, b);
                    BytecodeManager.incBytecodes(1);
                    final int min2 = Math.min(a, min);
                    BytecodeManager.incBytecodes(1);
                    return min2;
                }
                default: {
                    final int n2 = GregorianCalendar.LEAST_MAX_VALUES[n];
                    BytecodeManager.incBytecodes(4);
                    return n2;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getActualMinimum(final int n) {
        try {
            final int n2 = 5;
            BytecodeManager.incBytecodes(3);
            Label_0140: {
                if (n == n2) {
                    BytecodeManager.incBytecodes(2);
                    final GregorianCalendar normalizedCalendar = this.getNormalizedCalendar();
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar.Date cdate = normalizedCalendar.cdate;
                    BytecodeManager.incBytecodes(3);
                    final int normalizedYear = cdate.getNormalizedYear();
                    BytecodeManager.incBytecodes(1);
                    final int n3 = normalizedYear;
                    final int gregorianCutoverYear = this.gregorianCutoverYear;
                    BytecodeManager.incBytecodes(4);
                    if (n3 != gregorianCutoverYear) {
                        final int n4 = normalizedYear;
                        final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                        BytecodeManager.incBytecodes(4);
                        if (n4 != gregorianCutoverYearJulian) {
                            break Label_0140;
                        }
                    }
                    final BaseCalendar.Date cdate2 = normalizedCalendar.cdate;
                    final BaseCalendar calsys = normalizedCalendar.calsys;
                    final BaseCalendar.Date cdate3 = normalizedCalendar.cdate;
                    BytecodeManager.incBytecodes(8);
                    final long fixedDate = calsys.getFixedDate(cdate3);
                    BytecodeManager.incBytecodes(1);
                    final long fixedDateMonth1 = this.getFixedDateMonth1(cdate2, fixedDate);
                    BytecodeManager.incBytecodes(1);
                    final long n5 = fixedDateMonth1;
                    BytecodeManager.incBytecodes(3);
                    final BaseCalendar.Date calendarDate = this.getCalendarDate(n5);
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar.Date date = calendarDate;
                    BytecodeManager.incBytecodes(2);
                    final int dayOfMonth = date.getDayOfMonth();
                    BytecodeManager.incBytecodes(1);
                    return dayOfMonth;
                }
            }
            BytecodeManager.incBytecodes(3);
            final int minimum = this.getMinimum(n);
            BytecodeManager.incBytecodes(1);
            return minimum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getActualMaximum(final int index) {
        try {
            final int n = 0x1FE81 & 1 << index;
            BytecodeManager.incBytecodes(6);
            if (n != 0) {
                BytecodeManager.incBytecodes(3);
                final int maximum = this.getMaximum(index);
                BytecodeManager.incBytecodes(1);
                return maximum;
            }
            BytecodeManager.incBytecodes(2);
            GregorianCalendar normalizedCalendar = this.getNormalizedCalendar();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date cdate = normalizedCalendar.cdate;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar calsys = normalizedCalendar.calsys;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar.Date date = cdate;
            BytecodeManager.incBytecodes(2);
            int normalizedYear = date.getNormalizedYear();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            switch (index) {
                case 2: {
                    final GregorianCalendar gregorianCalendar = normalizedCalendar;
                    final int n2 = normalizedYear;
                    BytecodeManager.incBytecodes(3);
                    final boolean cutoverYear = gregorianCalendar.isCutoverYear(n2);
                    BytecodeManager.incBytecodes(1);
                    if (!cutoverYear) {
                        n3 = 11;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    long n4;
                    long fixedDate;
                    do {
                        final Gregorian gcal = GregorianCalendar.gcal;
                        final int year = ++normalizedYear;
                        final int month = 1;
                        final int dayOfMonth = 1;
                        final BaseCalendar.Date cache = null;
                        BytecodeManager.incBytecodes(7);
                        fixedDate = gcal.getFixedDate(year, month, dayOfMonth, cache);
                        BytecodeManager.incBytecodes(1);
                        n4 = lcmp(fixedDate, this.gregorianCutoverDate);
                        BytecodeManager.incBytecodes(5);
                    } while (n4 < 0);
                    final BaseCalendar.Date date2 = cdate;
                    BytecodeManager.incBytecodes(2);
                    final BaseCalendar.Date date3 = (BaseCalendar.Date)date2.clone();
                    BytecodeManager.incBytecodes(2);
                    final BaseCalendar baseCalendar = calsys;
                    final BaseCalendar.Date date4 = date3;
                    final long fixedDate2 = fixedDate - 1L;
                    BytecodeManager.incBytecodes(6);
                    baseCalendar.getCalendarDateFromFixedDate(date4, fixedDate2);
                    final BaseCalendar.Date date5 = date3;
                    BytecodeManager.incBytecodes(2);
                    n3 = date5.getMonth() - 1;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 5: {
                    final BaseCalendar baseCalendar2 = calsys;
                    final BaseCalendar.Date date6 = cdate;
                    BytecodeManager.incBytecodes(3);
                    n3 = baseCalendar2.getMonthLength(date6);
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar2 = normalizedCalendar;
                    final int n5 = normalizedYear;
                    BytecodeManager.incBytecodes(3);
                    final boolean cutoverYear2 = gregorianCalendar2.isCutoverYear(n5);
                    BytecodeManager.incBytecodes(1);
                    if (!cutoverYear2) {
                        break;
                    }
                    final BaseCalendar.Date date7 = cdate;
                    BytecodeManager.incBytecodes(2);
                    final int dayOfMonth2 = date7.getDayOfMonth();
                    final int n6 = n3;
                    BytecodeManager.incBytecodes(2);
                    if (dayOfMonth2 == n6) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final GregorianCalendar gregorianCalendar3 = normalizedCalendar;
                    BytecodeManager.incBytecodes(2);
                    final long currentFixedDate = gregorianCalendar3.getCurrentFixedDate();
                    BytecodeManager.incBytecodes(1);
                    final long n7 = lcmp(currentFixedDate, this.gregorianCutoverDate);
                    BytecodeManager.incBytecodes(5);
                    if (n7 >= 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final GregorianCalendar gregorianCalendar4 = normalizedCalendar;
                    BytecodeManager.incBytecodes(2);
                    final int actualMonthLength = gregorianCalendar4.actualMonthLength();
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar5 = normalizedCalendar;
                    final BaseCalendar.Date cdate2 = normalizedCalendar.cdate;
                    final long n8 = currentFixedDate;
                    BytecodeManager.incBytecodes(5);
                    final long n9 = gregorianCalendar5.getFixedDateMonth1(cdate2, n8) + actualMonthLength - 1L;
                    BytecodeManager.incBytecodes(6);
                    final GregorianCalendar gregorianCalendar6 = normalizedCalendar;
                    final long n10 = n9;
                    BytecodeManager.incBytecodes(3);
                    final BaseCalendar.Date calendarDate = gregorianCalendar6.getCalendarDate(n10);
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar.Date date8 = calendarDate;
                    BytecodeManager.incBytecodes(2);
                    n3 = date8.getDayOfMonth();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 6: {
                    final GregorianCalendar gregorianCalendar7 = normalizedCalendar;
                    final int n11 = normalizedYear;
                    BytecodeManager.incBytecodes(3);
                    final boolean cutoverYear3 = gregorianCalendar7.isCutoverYear(n11);
                    BytecodeManager.incBytecodes(1);
                    if (!cutoverYear3) {
                        final BaseCalendar baseCalendar3 = calsys;
                        final BaseCalendar.Date date9 = cdate;
                        BytecodeManager.incBytecodes(3);
                        n3 = baseCalendar3.getYearLength(date9);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final int gregorianCutoverYear = this.gregorianCutoverYear;
                    final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                    BytecodeManager.incBytecodes(5);
                    long n12;
                    if (gregorianCutoverYear == gregorianCutoverYearJulian) {
                        final GregorianCalendar gregorianCalendar8 = normalizedCalendar;
                        BytecodeManager.incBytecodes(2);
                        final BaseCalendar cutoverCalendarSystem = gregorianCalendar8.getCutoverCalendarSystem();
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar baseCalendar4 = cutoverCalendarSystem;
                        final int year2 = normalizedYear;
                        final int month2 = 1;
                        final int dayOfMonth3 = 1;
                        final BaseCalendar.Date cache2 = null;
                        BytecodeManager.incBytecodes(6);
                        n12 = baseCalendar4.getFixedDate(year2, month2, dayOfMonth3, cache2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n13 = normalizedYear;
                        final int gregorianCutoverYearJulian2 = this.gregorianCutoverYearJulian;
                        BytecodeManager.incBytecodes(4);
                        if (n13 == gregorianCutoverYearJulian2) {
                            final BaseCalendar baseCalendar5 = calsys;
                            final int year3 = normalizedYear;
                            final int month3 = 1;
                            final int dayOfMonth4 = 1;
                            final BaseCalendar.Date cache3 = null;
                            BytecodeManager.incBytecodes(6);
                            n12 = baseCalendar5.getFixedDate(year3, month3, dayOfMonth4, cache3);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n12 = this.gregorianCutoverDate;
                            BytecodeManager.incBytecodes(3);
                        }
                    }
                    final Gregorian gcal2 = GregorianCalendar.gcal;
                    final int year4 = ++normalizedYear;
                    final int month4 = 1;
                    final int dayOfMonth5 = 1;
                    final BaseCalendar.Date cache4 = null;
                    BytecodeManager.incBytecodes(7);
                    long n14 = gcal2.getFixedDate(year4, month4, dayOfMonth5, cache4);
                    BytecodeManager.incBytecodes(1);
                    final long n15 = lcmp(n14, this.gregorianCutoverDate);
                    BytecodeManager.incBytecodes(5);
                    if (n15 < 0) {
                        n14 = this.gregorianCutoverDate;
                        BytecodeManager.incBytecodes(3);
                    }
                    final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled) {
                        final long n16 = n12;
                        final BaseCalendar baseCalendar6 = calsys;
                        final BaseCalendar.Date date10 = cdate;
                        BytecodeManager.incBytecodes(4);
                        final int normalizedYear2 = date10.getNormalizedYear();
                        final BaseCalendar.Date date11 = cdate;
                        BytecodeManager.incBytecodes(2);
                        final int month5 = date11.getMonth();
                        final BaseCalendar.Date date12 = cdate;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final int dayOfMonth6 = date12.getDayOfMonth();
                        final BaseCalendar.Date cache5 = cdate;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final long n17 = lcmp(n16, baseCalendar6.getFixedDate(normalizedYear2, month5, dayOfMonth6, cache5));
                        BytecodeManager.incBytecodes(2);
                        if (n17 > 0) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                    }
                    final boolean $assertionsDisabled2 = GregorianCalendar.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled2) {
                        final long n18 = n14;
                        final BaseCalendar baseCalendar7 = calsys;
                        final BaseCalendar.Date date13 = cdate;
                        BytecodeManager.incBytecodes(4);
                        final int normalizedYear3 = date13.getNormalizedYear();
                        final BaseCalendar.Date date14 = cdate;
                        BytecodeManager.incBytecodes(2);
                        final int month6 = date14.getMonth();
                        final BaseCalendar.Date date15 = cdate;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final int dayOfMonth7 = date15.getDayOfMonth();
                        final BaseCalendar.Date cache6 = cdate;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final long n19 = lcmp(n18, baseCalendar7.getFixedDate(normalizedYear3, month6, dayOfMonth7, cache6));
                        BytecodeManager.incBytecodes(2);
                        if (n19 < 0) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError2 = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError2;
                        }
                    }
                    n3 = (int)(n14 - n12);
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 3: {
                    final GregorianCalendar gregorianCalendar9 = normalizedCalendar;
                    final int n20 = normalizedYear;
                    BytecodeManager.incBytecodes(3);
                    final boolean cutoverYear4 = gregorianCalendar9.isCutoverYear(n20);
                    BytecodeManager.incBytecodes(1);
                    if (!cutoverYear4) {
                        final BaseCalendar baseCalendar8 = calsys;
                        final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
                        BytecodeManager.incBytecodes(3);
                        final CalendarDate calendarDate2 = baseCalendar8.newCalendarDate(no_TIMEZONE);
                        BytecodeManager.incBytecodes(1);
                        final CalendarDate calendarDate3 = calendarDate2;
                        final BaseCalendar.Date date16 = cdate;
                        BytecodeManager.incBytecodes(3);
                        final int year5 = date16.getYear();
                        final int month7 = 1;
                        final int dayOfMonth8 = 1;
                        BytecodeManager.incBytecodes(3);
                        calendarDate3.setDate(year5, month7, dayOfMonth8);
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar baseCalendar9 = calsys;
                        final CalendarDate date17 = calendarDate2;
                        BytecodeManager.incBytecodes(3);
                        final int dayOfWeek = baseCalendar9.getDayOfWeek(date17);
                        BytecodeManager.incBytecodes(1);
                        final int n21 = dayOfWeek;
                        BytecodeManager.incBytecodes(3);
                        int n22 = n21 - this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(2);
                        final int n23 = n22;
                        BytecodeManager.incBytecodes(2);
                        if (n23 < 0) {
                            n22 += 7;
                            BytecodeManager.incBytecodes(1);
                        }
                        n3 = 52;
                        BytecodeManager.incBytecodes(2);
                        final int n24 = n22;
                        BytecodeManager.incBytecodes(3);
                        final int n25 = n24 + this.getMinimalDaysInFirstWeek() - 1;
                        BytecodeManager.incBytecodes(4);
                        final int n26 = n25;
                        final int n27 = 6;
                        BytecodeManager.incBytecodes(3);
                        if (n26 != n27) {
                            final BaseCalendar.Date date18 = cdate;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final boolean leapYear = date18.isLeapYear();
                            BytecodeManager.incBytecodes(1);
                            if (!leapYear) {
                                break;
                            }
                            final int n28 = n25;
                            final int n29 = 5;
                            BytecodeManager.incBytecodes(3);
                            if (n28 != n29) {
                                final int n30 = n25;
                                final int n31 = 12;
                                BytecodeManager.incBytecodes(3);
                                if (n30 != n31) {
                                    break;
                                }
                            }
                        }
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                        break;
                    }
                    final GregorianCalendar gregorianCalendar10 = normalizedCalendar;
                    BytecodeManager.incBytecodes(3);
                    if (gregorianCalendar10 == this) {
                        final GregorianCalendar gregorianCalendar11 = normalizedCalendar;
                        BytecodeManager.incBytecodes(2);
                        normalizedCalendar = (GregorianCalendar)gregorianCalendar11.clone();
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n32 = 6;
                    BytecodeManager.incBytecodes(3);
                    final int actualMaximum = this.getActualMaximum(n32);
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar12 = normalizedCalendar;
                    final int n33 = 6;
                    final int n34 = actualMaximum;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar12.set(n33, n34);
                    final GregorianCalendar gregorianCalendar13 = normalizedCalendar;
                    final int n35 = 3;
                    BytecodeManager.incBytecodes(3);
                    n3 = gregorianCalendar13.get(n35);
                    BytecodeManager.incBytecodes(1);
                    final int n36 = 1;
                    BytecodeManager.incBytecodes(3);
                    final int internalGet = this.internalGet(n36);
                    final GregorianCalendar gregorianCalendar14 = normalizedCalendar;
                    BytecodeManager.incBytecodes(2);
                    final int weekYear = gregorianCalendar14.getWeekYear();
                    BytecodeManager.incBytecodes(1);
                    if (internalGet != weekYear) {
                        final GregorianCalendar gregorianCalendar15 = normalizedCalendar;
                        final int n37 = 6;
                        final int n38 = actualMaximum - 7;
                        BytecodeManager.incBytecodes(6);
                        gregorianCalendar15.set(n37, n38);
                        final GregorianCalendar gregorianCalendar16 = normalizedCalendar;
                        final int n39 = 3;
                        BytecodeManager.incBytecodes(3);
                        n3 = gregorianCalendar16.get(n39);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 4: {
                    final GregorianCalendar gregorianCalendar17 = normalizedCalendar;
                    final int n40 = normalizedYear;
                    BytecodeManager.incBytecodes(3);
                    final boolean cutoverYear5 = gregorianCalendar17.isCutoverYear(n40);
                    BytecodeManager.incBytecodes(1);
                    if (cutoverYear5) {
                        final GregorianCalendar gregorianCalendar18 = normalizedCalendar;
                        BytecodeManager.incBytecodes(3);
                        if (gregorianCalendar18 == this) {
                            final GregorianCalendar gregorianCalendar19 = normalizedCalendar;
                            BytecodeManager.incBytecodes(2);
                            normalizedCalendar = (GregorianCalendar)gregorianCalendar19.clone();
                            BytecodeManager.incBytecodes(2);
                        }
                        final GregorianCalendar gregorianCalendar20 = normalizedCalendar;
                        final int n41 = 1;
                        BytecodeManager.incBytecodes(3);
                        final int internalGet2 = gregorianCalendar20.internalGet(n41);
                        BytecodeManager.incBytecodes(1);
                        final GregorianCalendar gregorianCalendar21 = normalizedCalendar;
                        final int n42 = 2;
                        BytecodeManager.incBytecodes(3);
                        final int internalGet3 = gregorianCalendar21.internalGet(n42);
                        BytecodeManager.incBytecodes(1);
                        int i;
                        int n43;
                        do {
                            final GregorianCalendar gregorianCalendar22 = normalizedCalendar;
                            final int n44 = 4;
                            BytecodeManager.incBytecodes(3);
                            n3 = gregorianCalendar22.get(n44);
                            BytecodeManager.incBytecodes(1);
                            final GregorianCalendar gregorianCalendar23 = normalizedCalendar;
                            final int n45 = 4;
                            final int n46 = 1;
                            BytecodeManager.incBytecodes(4);
                            gregorianCalendar23.add(n45, n46);
                            final GregorianCalendar gregorianCalendar24 = normalizedCalendar;
                            final int n47 = 1;
                            BytecodeManager.incBytecodes(3);
                            final int value = gregorianCalendar24.get(n47);
                            final int n48 = internalGet2;
                            BytecodeManager.incBytecodes(2);
                            if (value != n48) {
                                break;
                            }
                            final GregorianCalendar gregorianCalendar25 = normalizedCalendar;
                            final int n49 = 2;
                            BytecodeManager.incBytecodes(3);
                            i = gregorianCalendar25.get(n49);
                            n43 = internalGet3;
                            BytecodeManager.incBytecodes(2);
                        } while (i == n43);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final BaseCalendar baseCalendar10 = calsys;
                    final TimeZone timeZone = null;
                    BytecodeManager.incBytecodes(3);
                    final CalendarDate calendarDate4 = baseCalendar10.newCalendarDate(timeZone);
                    BytecodeManager.incBytecodes(1);
                    final CalendarDate calendarDate5 = calendarDate4;
                    final BaseCalendar.Date date19 = cdate;
                    BytecodeManager.incBytecodes(3);
                    final int year6 = date19.getYear();
                    final BaseCalendar.Date date20 = cdate;
                    BytecodeManager.incBytecodes(2);
                    final int month8 = date20.getMonth();
                    final int dayOfMonth9 = 1;
                    BytecodeManager.incBytecodes(2);
                    calendarDate5.setDate(year6, month8, dayOfMonth9);
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar baseCalendar11 = calsys;
                    final CalendarDate date21 = calendarDate4;
                    BytecodeManager.incBytecodes(3);
                    final int dayOfWeek2 = baseCalendar11.getDayOfWeek(date21);
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar baseCalendar12 = calsys;
                    final CalendarDate date22 = calendarDate4;
                    BytecodeManager.incBytecodes(3);
                    final int monthLength = baseCalendar12.getMonthLength(date22);
                    BytecodeManager.incBytecodes(1);
                    final int n50 = dayOfWeek2;
                    BytecodeManager.incBytecodes(3);
                    int n51 = n50 - this.getFirstDayOfWeek();
                    BytecodeManager.incBytecodes(2);
                    final int n52 = n51;
                    BytecodeManager.incBytecodes(2);
                    if (n52 < 0) {
                        n51 += 7;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n53 = 7 - n51;
                    BytecodeManager.incBytecodes(4);
                    n3 = 3;
                    BytecodeManager.incBytecodes(2);
                    final int n54 = n53;
                    BytecodeManager.incBytecodes(3);
                    final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
                    BytecodeManager.incBytecodes(1);
                    if (n54 >= minimalDaysInFirstWeek) {
                        ++n3;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n55 = monthLength - (n53 + 21);
                    BytecodeManager.incBytecodes(6);
                    final int n56 = n55;
                    BytecodeManager.incBytecodes(2);
                    if (n56 <= 0) {
                        break;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(1);
                    final int n57 = n55;
                    final int n58 = 7;
                    BytecodeManager.incBytecodes(3);
                    if (n57 > n58) {
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                        break;
                    }
                    break;
                }
                case 8: {
                    final BaseCalendar.Date date23 = cdate;
                    BytecodeManager.incBytecodes(2);
                    final int dayOfWeek3 = date23.getDayOfWeek();
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar26 = normalizedCalendar;
                    final int n59 = normalizedYear;
                    BytecodeManager.incBytecodes(3);
                    final boolean cutoverYear6 = gregorianCalendar26.isCutoverYear(n59);
                    BytecodeManager.incBytecodes(1);
                    int n60;
                    int n61;
                    if (!cutoverYear6) {
                        final BaseCalendar.Date date24 = cdate;
                        BytecodeManager.incBytecodes(2);
                        final BaseCalendar.Date date25 = (BaseCalendar.Date)date24.clone();
                        BytecodeManager.incBytecodes(2);
                        final BaseCalendar baseCalendar13 = calsys;
                        final BaseCalendar.Date date26 = date25;
                        BytecodeManager.incBytecodes(3);
                        n60 = baseCalendar13.getMonthLength(date26);
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar.Date date27 = date25;
                        final int dayOfMonth10 = 1;
                        BytecodeManager.incBytecodes(3);
                        date27.setDayOfMonth(dayOfMonth10);
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar baseCalendar14 = calsys;
                        final BaseCalendar.Date date28 = date25;
                        BytecodeManager.incBytecodes(3);
                        baseCalendar14.normalize(date28);
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar.Date date29 = date25;
                        BytecodeManager.incBytecodes(2);
                        n61 = date29.getDayOfWeek();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final GregorianCalendar gregorianCalendar27 = normalizedCalendar;
                        BytecodeManager.incBytecodes(3);
                        if (gregorianCalendar27 == this) {
                            BytecodeManager.incBytecodes(2);
                            normalizedCalendar = (GregorianCalendar)this.clone();
                            BytecodeManager.incBytecodes(2);
                        }
                        final GregorianCalendar gregorianCalendar28 = normalizedCalendar;
                        BytecodeManager.incBytecodes(2);
                        n60 = gregorianCalendar28.actualMonthLength();
                        BytecodeManager.incBytecodes(1);
                        final GregorianCalendar gregorianCalendar29 = normalizedCalendar;
                        final int n62 = 5;
                        final GregorianCalendar gregorianCalendar30 = normalizedCalendar;
                        final int n63 = 5;
                        BytecodeManager.incBytecodes(5);
                        final int actualMinimum = gregorianCalendar30.getActualMinimum(n63);
                        BytecodeManager.incBytecodes(1);
                        gregorianCalendar29.set(n62, actualMinimum);
                        final GregorianCalendar gregorianCalendar31 = normalizedCalendar;
                        final int n64 = 7;
                        BytecodeManager.incBytecodes(3);
                        n61 = gregorianCalendar31.get(n64);
                        BytecodeManager.incBytecodes(1);
                    }
                    int n65 = dayOfWeek3 - n61;
                    BytecodeManager.incBytecodes(4);
                    final int n66 = n65;
                    BytecodeManager.incBytecodes(2);
                    if (n66 < 0) {
                        n65 += 7;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n67 = n60 - n65;
                    BytecodeManager.incBytecodes(4);
                    n3 = (n67 + 6) / 7;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 1: {
                    final GregorianCalendar gregorianCalendar32 = normalizedCalendar;
                    BytecodeManager.incBytecodes(3);
                    if (gregorianCalendar32 == this) {
                        BytecodeManager.incBytecodes(2);
                        normalizedCalendar = (GregorianCalendar)this.clone();
                        BytecodeManager.incBytecodes(2);
                    }
                    final GregorianCalendar gregorianCalendar33 = normalizedCalendar;
                    BytecodeManager.incBytecodes(2);
                    final long yearOffsetInMillis = gregorianCalendar33.getYearOffsetInMillis();
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar34 = normalizedCalendar;
                    BytecodeManager.incBytecodes(2);
                    final int internalGetEra = gregorianCalendar34.internalGetEra();
                    final int n68 = 1;
                    BytecodeManager.incBytecodes(2);
                    if (internalGetEra == n68) {
                        final GregorianCalendar gregorianCalendar35 = normalizedCalendar;
                        final long timeInMillis = Long.MAX_VALUE;
                        BytecodeManager.incBytecodes(3);
                        gregorianCalendar35.setTimeInMillis(timeInMillis);
                        final GregorianCalendar gregorianCalendar36 = normalizedCalendar;
                        final int n69 = 1;
                        BytecodeManager.incBytecodes(3);
                        n3 = gregorianCalendar36.get(n69);
                        BytecodeManager.incBytecodes(1);
                        final GregorianCalendar gregorianCalendar37 = normalizedCalendar;
                        BytecodeManager.incBytecodes(2);
                        final long yearOffsetInMillis2 = gregorianCalendar37.getYearOffsetInMillis();
                        BytecodeManager.incBytecodes(1);
                        final long n70 = lcmp(yearOffsetInMillis, yearOffsetInMillis2);
                        BytecodeManager.incBytecodes(4);
                        if (n70 > 0) {
                            --n3;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final GregorianCalendar gregorianCalendar38 = normalizedCalendar;
                        BytecodeManager.incBytecodes(2);
                        final long n71 = lcmp(gregorianCalendar38.getTimeInMillis(), this.gregorianCutover);
                        BytecodeManager.incBytecodes(4);
                        BaseCalendar baseCalendar15;
                        if (n71 >= 0) {
                            baseCalendar15 = GregorianCalendar.gcal;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            BytecodeManager.incBytecodes(1);
                            baseCalendar15 = getJulianCalendarSystem();
                        }
                        final BaseCalendar baseCalendar16 = baseCalendar15;
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar baseCalendar17 = baseCalendar16;
                        final long n72 = Long.MIN_VALUE;
                        BytecodeManager.incBytecodes(4);
                        final TimeZone zone = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final CalendarDate calendarDate6 = baseCalendar17.getCalendarDate(n72, zone);
                        BytecodeManager.incBytecodes(1);
                        final BaseCalendar baseCalendar18 = calsys;
                        final CalendarDate date30 = calendarDate6;
                        BytecodeManager.incBytecodes(3);
                        final long n73 = (baseCalendar18.getDayOfYear(date30) - 1L) * 24L;
                        final CalendarDate calendarDate7 = calendarDate6;
                        BytecodeManager.incBytecodes(6);
                        final long n74 = n73 + calendarDate7.getHours();
                        BytecodeManager.incBytecodes(3);
                        final long n75 = n74 * 60L;
                        BytecodeManager.incBytecodes(4);
                        final long n76 = n75;
                        final CalendarDate calendarDate8 = calendarDate6;
                        BytecodeManager.incBytecodes(3);
                        final long n77 = n76 + calendarDate8.getMinutes();
                        BytecodeManager.incBytecodes(3);
                        final long n78 = n77 * 60L;
                        BytecodeManager.incBytecodes(4);
                        final long n79 = n78;
                        final CalendarDate calendarDate9 = calendarDate6;
                        BytecodeManager.incBytecodes(3);
                        final long n80 = n79 + calendarDate9.getSeconds();
                        BytecodeManager.incBytecodes(3);
                        final long n81 = n80 * 1000L;
                        BytecodeManager.incBytecodes(4);
                        final long n82 = n81;
                        final CalendarDate calendarDate10 = calendarDate6;
                        BytecodeManager.incBytecodes(3);
                        final long n83 = n82 + calendarDate10.getMillis();
                        BytecodeManager.incBytecodes(3);
                        final CalendarDate calendarDate11 = calendarDate6;
                        BytecodeManager.incBytecodes(2);
                        n3 = calendarDate11.getYear();
                        BytecodeManager.incBytecodes(1);
                        final int n84 = n3;
                        BytecodeManager.incBytecodes(2);
                        if (n84 <= 0) {
                            final boolean $assertionsDisabled3 = GregorianCalendar.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled3) {
                                final BaseCalendar baseCalendar19 = baseCalendar16;
                                final Gregorian gcal3 = GregorianCalendar.gcal;
                                BytecodeManager.incBytecodes(3);
                                if (baseCalendar19 != gcal3) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError3 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError3;
                                }
                            }
                            n3 = 1 - n3;
                            BytecodeManager.incBytecodes(4);
                        }
                        final long n85 = lcmp(yearOffsetInMillis, n83);
                        BytecodeManager.incBytecodes(4);
                        if (n85 < 0) {
                            --n3;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                default: {
                    BytecodeManager.incBytecodes(4);
                    final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(index);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            final int n86 = n3;
            BytecodeManager.incBytecodes(2);
            return n86;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getYearOffsetInMillis() {
        try {
            final int n = 6;
            BytecodeManager.incBytecodes(3);
            final long n2 = (this.internalGet(n) - 1) * 24;
            BytecodeManager.incBytecodes(6);
            final long n3 = n2;
            final int n4 = 11;
            BytecodeManager.incBytecodes(4);
            final long n5 = n3 + this.internalGet(n4);
            BytecodeManager.incBytecodes(3);
            final long n6 = n5 * 60L;
            BytecodeManager.incBytecodes(4);
            final long n7 = n6;
            final int n8 = 12;
            BytecodeManager.incBytecodes(4);
            final long n9 = n7 + this.internalGet(n8);
            BytecodeManager.incBytecodes(3);
            final long n10 = n9 * 60L;
            BytecodeManager.incBytecodes(4);
            final long n11 = n10;
            final int n12 = 13;
            BytecodeManager.incBytecodes(4);
            final long n13 = n11 + this.internalGet(n12);
            BytecodeManager.incBytecodes(3);
            final long n14 = n13 * 1000L;
            BytecodeManager.incBytecodes(4);
            final long n15 = n14;
            final int n16 = 14;
            BytecodeManager.incBytecodes(4);
            final long n17 = n15 + this.internalGet(n16);
            final int n18 = 15;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int internalGet = this.internalGet(n18);
            final int n19 = 16;
            BytecodeManager.incBytecodes(3);
            final long n20 = n17 - (internalGet + this.internalGet(n19));
            BytecodeManager.incBytecodes(4);
            return n20;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object clone() {
        try {
            BytecodeManager.incBytecodes(2);
            final GregorianCalendar gregorianCalendar = (GregorianCalendar)super.clone();
            BytecodeManager.incBytecodes(2);
            final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
            final BaseCalendar.Date gdate = this.gdate;
            BytecodeManager.incBytecodes(4);
            gregorianCalendar2.gdate = (BaseCalendar.Date)gdate.clone();
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            if (cdate != null) {
                final BaseCalendar.Date cdate2 = this.cdate;
                final BaseCalendar.Date gdate2 = this.gdate;
                BytecodeManager.incBytecodes(5);
                if (cdate2 != gdate2) {
                    final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
                    final BaseCalendar.Date cdate3 = this.cdate;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar3.cdate = (BaseCalendar.Date)cdate3.clone();
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    gregorianCalendar.cdate = gregorianCalendar.gdate;
                    BytecodeManager.incBytecodes(4);
                }
            }
            gregorianCalendar.originalFields = null;
            BytecodeManager.incBytecodes(3);
            gregorianCalendar.zoneOffsets = null;
            BytecodeManager.incBytecodes(3);
            final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
            BytecodeManager.incBytecodes(2);
            return gregorianCalendar4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public TimeZone getTimeZone() {
        try {
            BytecodeManager.incBytecodes(2);
            final TimeZone timeZone = super.getTimeZone();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date gdate = this.gdate;
            final TimeZone zone = timeZone;
            BytecodeManager.incBytecodes(4);
            gdate.setZone(zone);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            if (cdate != null) {
                final BaseCalendar.Date cdate2 = this.cdate;
                final BaseCalendar.Date gdate2 = this.gdate;
                BytecodeManager.incBytecodes(5);
                if (cdate2 != gdate2) {
                    final BaseCalendar.Date cdate3 = this.cdate;
                    final TimeZone zone2 = timeZone;
                    BytecodeManager.incBytecodes(4);
                    cdate3.setZone(zone2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final TimeZone timeZone2 = timeZone;
            BytecodeManager.incBytecodes(2);
            return timeZone2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void setTimeZone(final TimeZone zone) {
        try {
            BytecodeManager.incBytecodes(3);
            super.setTimeZone(zone);
            final BaseCalendar.Date gdate = this.gdate;
            BytecodeManager.incBytecodes(4);
            gdate.setZone(zone);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            if (cdate != null) {
                final BaseCalendar.Date cdate2 = this.cdate;
                final BaseCalendar.Date gdate2 = this.gdate;
                BytecodeManager.incBytecodes(5);
                if (cdate2 != gdate2) {
                    final BaseCalendar.Date cdate3 = this.cdate;
                    BytecodeManager.incBytecodes(4);
                    cdate3.setZone(zone);
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean isWeekDateSupported() {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getWeekYear() {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            int value = this.get(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int internalGetEra = this.internalGetEra();
            BytecodeManager.incBytecodes(1);
            if (internalGetEra == 0) {
                value = 1 - value;
                BytecodeManager.incBytecodes(4);
            }
            final int n2 = value;
            final int n3 = this.gregorianCutoverYear + 1;
            BytecodeManager.incBytecodes(6);
            if (n2 > n3) {
                final int n4 = 3;
                BytecodeManager.incBytecodes(3);
                final int internalGet = this.internalGet(n4);
                BytecodeManager.incBytecodes(1);
                final int n5 = 2;
                BytecodeManager.incBytecodes(3);
                final int internalGet2 = this.internalGet(n5);
                BytecodeManager.incBytecodes(1);
                if (internalGet2 == 0) {
                    final int n6 = internalGet;
                    final int n7 = 52;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n7) {
                        --value;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    final int n8 = internalGet;
                    final int n9 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n8 == n9) {
                        ++value;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n10 = value;
                BytecodeManager.incBytecodes(2);
                return n10;
            }
            final int n11 = 6;
            BytecodeManager.incBytecodes(3);
            final int internalGet3 = this.internalGet(n11);
            BytecodeManager.incBytecodes(1);
            final int n12 = 6;
            BytecodeManager.incBytecodes(3);
            final int actualMaximum = this.getActualMaximum(n12);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
            BytecodeManager.incBytecodes(1);
            final int n13 = internalGet3;
            final int n14 = minimalDaysInFirstWeek;
            BytecodeManager.incBytecodes(3);
            if (n13 > n14) {
                final int n15 = internalGet3;
                final int n16 = actualMaximum - 6;
                BytecodeManager.incBytecodes(5);
                if (n15 < n16) {
                    final int n17 = value;
                    BytecodeManager.incBytecodes(2);
                    return n17;
                }
            }
            BytecodeManager.incBytecodes(2);
            final GregorianCalendar gregorianCalendar = (GregorianCalendar)this.clone();
            BytecodeManager.incBytecodes(2);
            final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
            final boolean lenient = true;
            BytecodeManager.incBytecodes(3);
            gregorianCalendar2.setLenient(lenient);
            final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
            final String s = "GMT";
            BytecodeManager.incBytecodes(3);
            final TimeZone timeZone = TimeZone.getTimeZone(s);
            BytecodeManager.incBytecodes(1);
            gregorianCalendar3.setTimeZone(timeZone);
            final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
            final int n18 = 6;
            final int n19 = 1;
            BytecodeManager.incBytecodes(4);
            gregorianCalendar4.set(n18, n19);
            final GregorianCalendar gregorianCalendar5 = gregorianCalendar;
            BytecodeManager.incBytecodes(2);
            gregorianCalendar5.complete();
            BytecodeManager.incBytecodes(2);
            final int firstDayOfWeek = this.getFirstDayOfWeek();
            final GregorianCalendar gregorianCalendar6 = gregorianCalendar;
            final int n20 = 7;
            BytecodeManager.incBytecodes(3);
            int n21 = firstDayOfWeek - gregorianCalendar6.get(n20);
            BytecodeManager.incBytecodes(2);
            final int n22 = n21;
            BytecodeManager.incBytecodes(2);
            if (n22 != 0) {
                final int n23 = n21;
                BytecodeManager.incBytecodes(2);
                if (n23 < 0) {
                    n21 += 7;
                    BytecodeManager.incBytecodes(1);
                }
                final GregorianCalendar gregorianCalendar7 = gregorianCalendar;
                final int n24 = 6;
                final int n25 = n21;
                BytecodeManager.incBytecodes(4);
                gregorianCalendar7.add(n24, n25);
            }
            final GregorianCalendar gregorianCalendar8 = gregorianCalendar;
            final int n26 = 6;
            BytecodeManager.incBytecodes(3);
            final int value2 = gregorianCalendar8.get(n26);
            BytecodeManager.incBytecodes(1);
            final int n27 = internalGet3;
            final int n28 = value2;
            BytecodeManager.incBytecodes(3);
            if (n27 < n28) {
                final int n29 = value2;
                final int n30 = minimalDaysInFirstWeek;
                BytecodeManager.incBytecodes(3);
                if (n29 <= n30) {
                    --value;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                final GregorianCalendar gregorianCalendar9 = gregorianCalendar;
                final int n31 = 1;
                final int n32 = value + 1;
                BytecodeManager.incBytecodes(6);
                gregorianCalendar9.set(n31, n32);
                final GregorianCalendar gregorianCalendar10 = gregorianCalendar;
                final int n33 = 6;
                final int n34 = 1;
                BytecodeManager.incBytecodes(4);
                gregorianCalendar10.set(n33, n34);
                final GregorianCalendar gregorianCalendar11 = gregorianCalendar;
                BytecodeManager.incBytecodes(2);
                gregorianCalendar11.complete();
                BytecodeManager.incBytecodes(2);
                final int firstDayOfWeek2 = this.getFirstDayOfWeek();
                final GregorianCalendar gregorianCalendar12 = gregorianCalendar;
                final int n35 = 7;
                BytecodeManager.incBytecodes(3);
                int n36 = firstDayOfWeek2 - gregorianCalendar12.get(n35);
                BytecodeManager.incBytecodes(2);
                final int n37 = n36;
                BytecodeManager.incBytecodes(2);
                if (n37 != 0) {
                    final int n38 = n36;
                    BytecodeManager.incBytecodes(2);
                    if (n38 < 0) {
                        n36 += 7;
                        BytecodeManager.incBytecodes(1);
                    }
                    final GregorianCalendar gregorianCalendar13 = gregorianCalendar;
                    final int n39 = 6;
                    final int n40 = n36;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar13.add(n39, n40);
                }
                final GregorianCalendar gregorianCalendar14 = gregorianCalendar;
                final int n41 = 6;
                BytecodeManager.incBytecodes(3);
                int n42 = gregorianCalendar14.get(n41) - 1;
                BytecodeManager.incBytecodes(3);
                final int n43 = n42;
                BytecodeManager.incBytecodes(2);
                if (n43 == 0) {
                    n42 = 7;
                    BytecodeManager.incBytecodes(2);
                }
                final int n44 = n42;
                final int n45 = minimalDaysInFirstWeek;
                BytecodeManager.incBytecodes(3);
                if (n44 >= n45) {
                    final int n46 = actualMaximum - internalGet3 + 1;
                    BytecodeManager.incBytecodes(6);
                    final int n47 = n46;
                    final int n48 = 7 - n42;
                    BytecodeManager.incBytecodes(5);
                    if (n47 <= n48) {
                        ++value;
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final int n49 = value;
            BytecodeManager.incBytecodes(2);
            return n49;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void setWeekDate(final int n, final int n2, final int i) {
        try {
            final int n3 = 1;
            BytecodeManager.incBytecodes(3);
            if (i >= n3) {
                final int n4 = 7;
                BytecodeManager.incBytecodes(3);
                if (i <= n4) {
                    BytecodeManager.incBytecodes(2);
                    final GregorianCalendar gregorianCalendar = (GregorianCalendar)this.clone();
                    BytecodeManager.incBytecodes(2);
                    final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
                    final boolean lenient = true;
                    BytecodeManager.incBytecodes(3);
                    gregorianCalendar2.setLenient(lenient);
                    final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
                    final int n5 = 0;
                    BytecodeManager.incBytecodes(3);
                    final int value = gregorianCalendar3.get(n5);
                    BytecodeManager.incBytecodes(1);
                    final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
                    BytecodeManager.incBytecodes(2);
                    gregorianCalendar4.clear();
                    final GregorianCalendar gregorianCalendar5 = gregorianCalendar;
                    final String s = "GMT";
                    BytecodeManager.incBytecodes(3);
                    final TimeZone timeZone = TimeZone.getTimeZone(s);
                    BytecodeManager.incBytecodes(1);
                    gregorianCalendar5.setTimeZone(timeZone);
                    final GregorianCalendar gregorianCalendar6 = gregorianCalendar;
                    final int n6 = 0;
                    final int n7 = value;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar6.set(n6, n7);
                    final GregorianCalendar gregorianCalendar7 = gregorianCalendar;
                    final int n8 = 1;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar7.set(n8, n);
                    final GregorianCalendar gregorianCalendar8 = gregorianCalendar;
                    final int n9 = 3;
                    final int n10 = 1;
                    BytecodeManager.incBytecodes(4);
                    gregorianCalendar8.set(n9, n10);
                    final GregorianCalendar gregorianCalendar9 = gregorianCalendar;
                    final int n11 = 7;
                    BytecodeManager.incBytecodes(4);
                    final int firstDayOfWeek = this.getFirstDayOfWeek();
                    BytecodeManager.incBytecodes(1);
                    gregorianCalendar9.set(n11, firstDayOfWeek);
                    BytecodeManager.incBytecodes(3);
                    int n12 = i - this.getFirstDayOfWeek();
                    BytecodeManager.incBytecodes(2);
                    final int n13 = n12;
                    BytecodeManager.incBytecodes(2);
                    if (n13 < 0) {
                        n12 += 7;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n14 = n12 + 7 * (n2 - 1);
                    BytecodeManager.incBytecodes(8);
                    final int n15 = n14;
                    BytecodeManager.incBytecodes(2);
                    if (n15 != 0) {
                        final GregorianCalendar gregorianCalendar10 = gregorianCalendar;
                        final int n16 = 6;
                        final int n17 = n14;
                        BytecodeManager.incBytecodes(4);
                        gregorianCalendar10.add(n16, n17);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final GregorianCalendar gregorianCalendar11 = gregorianCalendar;
                        BytecodeManager.incBytecodes(2);
                        gregorianCalendar11.complete();
                    }
                    BytecodeManager.incBytecodes(2);
                    final boolean lenient2 = this.isLenient();
                    BytecodeManager.incBytecodes(1);
                    Label_0421: {
                        if (!lenient2) {
                            final GregorianCalendar gregorianCalendar12 = gregorianCalendar;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final int weekYear = gregorianCalendar12.getWeekYear();
                            BytecodeManager.incBytecodes(2);
                            if (weekYear == n) {
                                final GregorianCalendar gregorianCalendar13 = gregorianCalendar;
                                final int n18 = 3;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final int internalGet = gregorianCalendar13.internalGet(n18);
                                BytecodeManager.incBytecodes(2);
                                if (internalGet == n2) {
                                    final GregorianCalendar gregorianCalendar14 = gregorianCalendar;
                                    final int n19 = 7;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final int internalGet2 = gregorianCalendar14.internalGet(n19);
                                    BytecodeManager.incBytecodes(2);
                                    if (internalGet2 == i) {
                                        break Label_0421;
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(3);
                            final IllegalArgumentException ex = new IllegalArgumentException();
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                    }
                    final int n20 = 0;
                    final GregorianCalendar gregorianCalendar15 = gregorianCalendar;
                    final int n21 = 0;
                    BytecodeManager.incBytecodes(5);
                    final int internalGet3 = gregorianCalendar15.internalGet(n21);
                    BytecodeManager.incBytecodes(1);
                    this.set(n20, internalGet3);
                    final int n22 = 1;
                    final GregorianCalendar gregorianCalendar16 = gregorianCalendar;
                    final int n23 = 1;
                    BytecodeManager.incBytecodes(5);
                    final int internalGet4 = gregorianCalendar16.internalGet(n23);
                    BytecodeManager.incBytecodes(1);
                    this.set(n22, internalGet4);
                    final int n24 = 2;
                    final GregorianCalendar gregorianCalendar17 = gregorianCalendar;
                    final int n25 = 2;
                    BytecodeManager.incBytecodes(5);
                    final int internalGet5 = gregorianCalendar17.internalGet(n25);
                    BytecodeManager.incBytecodes(1);
                    this.set(n24, internalGet5);
                    final int n26 = 5;
                    final GregorianCalendar gregorianCalendar18 = gregorianCalendar;
                    final int n27 = 5;
                    BytecodeManager.incBytecodes(5);
                    final int internalGet6 = gregorianCalendar18.internalGet(n27);
                    BytecodeManager.incBytecodes(1);
                    this.set(n26, internalGet6);
                    final int n28 = 3;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n28, n2);
                    BytecodeManager.incBytecodes(2);
                    this.complete();
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "invalid dayOfWeek: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            final IllegalArgumentException ex2 = new IllegalArgumentException(string);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getWeeksInWeekYear() {
        try {
            BytecodeManager.incBytecodes(2);
            GregorianCalendar normalizedCalendar = this.getNormalizedCalendar();
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar = normalizedCalendar;
            BytecodeManager.incBytecodes(2);
            final int weekYear = gregorianCalendar.getWeekYear();
            BytecodeManager.incBytecodes(1);
            final int n = weekYear;
            final GregorianCalendar gregorianCalendar2 = normalizedCalendar;
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final int internalGet = gregorianCalendar2.internalGet(n2);
            BytecodeManager.incBytecodes(1);
            if (n == internalGet) {
                final GregorianCalendar gregorianCalendar3 = normalizedCalendar;
                final int n3 = 3;
                BytecodeManager.incBytecodes(3);
                final int actualMaximum = gregorianCalendar3.getActualMaximum(n3);
                BytecodeManager.incBytecodes(1);
                return actualMaximum;
            }
            final GregorianCalendar gregorianCalendar4 = normalizedCalendar;
            BytecodeManager.incBytecodes(3);
            if (gregorianCalendar4 == this) {
                final GregorianCalendar gregorianCalendar5 = normalizedCalendar;
                BytecodeManager.incBytecodes(2);
                normalizedCalendar = (GregorianCalendar)gregorianCalendar5.clone();
                BytecodeManager.incBytecodes(2);
            }
            final GregorianCalendar gregorianCalendar6 = normalizedCalendar;
            final int n4 = weekYear;
            final int n5 = 2;
            final int n6 = 7;
            BytecodeManager.incBytecodes(6);
            final int internalGet2 = this.internalGet(n6);
            BytecodeManager.incBytecodes(1);
            gregorianCalendar6.setWeekDate(n4, n5, internalGet2);
            final GregorianCalendar gregorianCalendar7 = normalizedCalendar;
            final int n7 = 3;
            BytecodeManager.incBytecodes(3);
            final int actualMaximum2 = gregorianCalendar7.getActualMaximum(n7);
            BytecodeManager.incBytecodes(1);
            return actualMaximum2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void computeFields() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean partiallyNormalized = this.isPartiallyNormalized();
            BytecodeManager.incBytecodes(1);
            int setStateFields;
            if (partiallyNormalized) {
                BytecodeManager.incBytecodes(2);
                setStateFields = this.getSetStateFields();
                BytecodeManager.incBytecodes(1);
                final int n = ~setStateFields & 0x1FFFF;
                BytecodeManager.incBytecodes(6);
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                Label_0130: {
                    if (n2 == 0) {
                        final BaseCalendar calsys = this.calsys;
                        BytecodeManager.incBytecodes(3);
                        if (calsys != null) {
                            break Label_0130;
                        }
                    }
                    final int n3 = setStateFields;
                    final int n4 = n;
                    final int n5 = setStateFields & 0x18000;
                    BytecodeManager.incBytecodes(7);
                    setStateFields = (n3 | this.computeFields(n4, n5));
                    BytecodeManager.incBytecodes(2);
                    final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled) {
                        final int n6 = setStateFields;
                        final int n7 = 131071;
                        BytecodeManager.incBytecodes(3);
                        if (n6 != n7) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                setStateFields = 131071;
                BytecodeManager.incBytecodes(2);
                final int n8 = setStateFields;
                final int n9 = 0;
                BytecodeManager.incBytecodes(4);
                this.computeFields(n8, n9);
                BytecodeManager.incBytecodes(1);
            }
            final int fieldsComputed = setStateFields;
            BytecodeManager.incBytecodes(3);
            this.setFieldsComputed(fieldsComputed);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int computeFields(final int n, final int n2) {
        try {
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final TimeZone zone = this.getZone();
            BytecodeManager.incBytecodes(1);
            final int[] zoneOffsets = this.zoneOffsets;
            BytecodeManager.incBytecodes(3);
            if (zoneOffsets == null) {
                this.zoneOffsets = new int[2];
                BytecodeManager.incBytecodes(3);
            }
            final int n4 = 98304;
            BytecodeManager.incBytecodes(3);
            if (n2 != n4) {
                final boolean b = zone instanceof ZoneInfo;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final ZoneInfo zoneInfo = (ZoneInfo)zone;
                    final long time = this.time;
                    final int[] zoneOffsets2 = this.zoneOffsets;
                    BytecodeManager.incBytecodes(7);
                    n3 = zoneInfo.getOffsets(time, zoneOffsets2);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final TimeZone timeZone = zone;
                    final long time2 = this.time;
                    BytecodeManager.incBytecodes(4);
                    n3 = timeZone.getOffset(time2);
                    BytecodeManager.incBytecodes(1);
                    final int[] zoneOffsets3 = this.zoneOffsets;
                    final int n5 = 0;
                    final TimeZone timeZone2 = zone;
                    BytecodeManager.incBytecodes(5);
                    zoneOffsets3[n5] = timeZone2.getRawOffset();
                    BytecodeManager.incBytecodes(1);
                    this.zoneOffsets[1] = n3 - this.zoneOffsets[0];
                    BytecodeManager.incBytecodes(10);
                }
            }
            BytecodeManager.incBytecodes(2);
            if (n2 != 0) {
                final int n6 = 15;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet = Calendar.isFieldSet(n2, n6);
                BytecodeManager.incBytecodes(1);
                if (fieldSet) {
                    final int[] zoneOffsets4 = this.zoneOffsets;
                    final int n7 = 0;
                    final int n8 = 15;
                    BytecodeManager.incBytecodes(6);
                    zoneOffsets4[n7] = this.internalGet(n8);
                    BytecodeManager.incBytecodes(1);
                }
                final int n9 = 16;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet2 = Calendar.isFieldSet(n2, n9);
                BytecodeManager.incBytecodes(1);
                if (fieldSet2) {
                    final int[] zoneOffsets5 = this.zoneOffsets;
                    final int n10 = 1;
                    final int n11 = 16;
                    BytecodeManager.incBytecodes(6);
                    zoneOffsets5[n10] = this.internalGet(n11);
                    BytecodeManager.incBytecodes(1);
                }
                n3 = this.zoneOffsets[0] + this.zoneOffsets[1];
                BytecodeManager.incBytecodes(10);
            }
            final long n12 = n3 / 86400000L;
            BytecodeManager.incBytecodes(5);
            final int n13 = n3 % 86400000;
            BytecodeManager.incBytecodes(4);
            long n14 = n12 + this.time / 86400000L;
            BytecodeManager.incBytecodes(7);
            int n15 = n13 + (int)(this.time % 86400000L);
            BytecodeManager.incBytecodes(8);
            final long n16 = lcmp((long)n15, 86400000L);
            BytecodeManager.incBytecodes(5);
            if (n16 >= 0) {
                n15 -= (int)86400000L;
                BytecodeManager.incBytecodes(6);
                ++n14;
                BytecodeManager.incBytecodes(5);
            }
            else {
                while (true) {
                    final int n17 = n15;
                    BytecodeManager.incBytecodes(2);
                    if (n17 >= 0) {
                        break;
                    }
                    n15 += (int)86400000L;
                    BytecodeManager.incBytecodes(6);
                    --n14;
                    BytecodeManager.incBytecodes(5);
                }
            }
            final long cachedFixedDate = n14 + 719163L;
            BytecodeManager.incBytecodes(4);
            int n18 = 1;
            BytecodeManager.incBytecodes(2);
            final long n19 = lcmp(cachedFixedDate, this.gregorianCutoverDate);
            BytecodeManager.incBytecodes(5);
            int n24;
            if (n19 >= 0) {
                final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n20 = lcmp(this.cachedFixedDate, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n20 != 0) {
                        final BaseCalendar.Date gdate = this.gdate;
                        BytecodeManager.incBytecodes(3);
                        final boolean normalized = gdate.isNormalized();
                        BytecodeManager.incBytecodes(1);
                        if (!normalized) {
                            final String detailMessage = "cache control: not normalized";
                            BytecodeManager.incBytecodes(4);
                            final AssertionError assertionError = new AssertionError((Object)detailMessage);
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                    }
                }
                final boolean $assertionsDisabled2 = GregorianCalendar.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled2) {
                    final long n21 = lcmp(this.cachedFixedDate, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n21 != 0) {
                        final Gregorian gcal = GregorianCalendar.gcal;
                        final BaseCalendar.Date gdate2 = this.gdate;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final int normalizedYear = gdate2.getNormalizedYear();
                        final BaseCalendar.Date gdate3 = this.gdate;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final int month = gdate3.getMonth();
                        final BaseCalendar.Date gdate4 = this.gdate;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final int dayOfMonth = gdate4.getDayOfMonth();
                        final BaseCalendar.Date gdate5 = this.gdate;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final long n22 = lcmp(gcal.getFixedDate(normalizedYear, month, dayOfMonth, gdate5), this.cachedFixedDate);
                        BytecodeManager.incBytecodes(4);
                        if (n22 != 0) {
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb = new StringBuilder();
                            final String str = "cache control: inconsictency, cachedFixedDate=";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb.append(str);
                            final long cachedFixedDate2 = this.cachedFixedDate;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append2 = append.append(cachedFixedDate2);
                            final String str2 = ", computed=";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = append2.append(str2);
                            final Gregorian gcal2 = GregorianCalendar.gcal;
                            final BaseCalendar.Date gdate6 = this.gdate;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final int normalizedYear2 = gdate6.getNormalizedYear();
                            final BaseCalendar.Date gdate7 = this.gdate;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int month2 = gdate7.getMonth();
                            final BaseCalendar.Date gdate8 = this.gdate;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int dayOfMonth2 = gdate8.getDayOfMonth();
                            final BaseCalendar.Date gdate9 = this.gdate;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final long fixedDate = gcal2.getFixedDate(normalizedYear2, month2, dayOfMonth2, gdate9);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append4 = append3.append(fixedDate);
                            final String str3 = ", date=";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append5 = append4.append(str3);
                            final BaseCalendar.Date gdate10 = this.gdate;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append6 = append5.append(gdate10);
                            BytecodeManager.incBytecodes(1);
                            final String string = append6.toString();
                            BytecodeManager.incBytecodes(1);
                            final AssertionError assertionError2 = new AssertionError((Object)string);
                            BytecodeManager.incBytecodes(1);
                            throw assertionError2;
                        }
                    }
                }
                final long n23 = lcmp(cachedFixedDate, this.cachedFixedDate);
                BytecodeManager.incBytecodes(5);
                if (n23 != 0) {
                    final Gregorian gcal3 = GregorianCalendar.gcal;
                    final BaseCalendar.Date gdate11 = this.gdate;
                    final long fixedDate2 = cachedFixedDate;
                    BytecodeManager.incBytecodes(5);
                    gcal3.getCalendarDateFromFixedDate(gdate11, fixedDate2);
                    this.cachedFixedDate = cachedFixedDate;
                    BytecodeManager.incBytecodes(3);
                }
                final BaseCalendar.Date gdate12 = this.gdate;
                BytecodeManager.incBytecodes(3);
                n24 = gdate12.getYear();
                BytecodeManager.incBytecodes(1);
                final int n25 = n24;
                BytecodeManager.incBytecodes(2);
                if (n25 <= 0) {
                    n24 = 1 - n24;
                    BytecodeManager.incBytecodes(4);
                    n18 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                this.calsys = GregorianCalendar.gcal;
                BytecodeManager.incBytecodes(3);
                this.cdate = this.gdate;
                BytecodeManager.incBytecodes(4);
                final boolean $assertionsDisabled3 = GregorianCalendar.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled3) {
                    final BaseCalendar.Date cdate = this.cdate;
                    BytecodeManager.incBytecodes(3);
                    final int dayOfWeek = cdate.getDayOfWeek();
                    BytecodeManager.incBytecodes(1);
                    if (dayOfWeek <= 0) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb2 = new StringBuilder();
                        final String str4 = "dow=";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append7 = sb2.append(str4);
                        final BaseCalendar.Date cdate2 = this.cdate;
                        BytecodeManager.incBytecodes(3);
                        final int dayOfWeek2 = cdate2.getDayOfWeek();
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder append8 = append7.append(dayOfWeek2);
                        final String str5 = ", date=";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append9 = append8.append(str5);
                        final BaseCalendar.Date cdate3 = this.cdate;
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder append10 = append9.append(cdate3);
                        BytecodeManager.incBytecodes(1);
                        final String string2 = append10.toString();
                        BytecodeManager.incBytecodes(1);
                        final AssertionError assertionError3 = new AssertionError((Object)string2);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError3;
                    }
                }
            }
            else {
                BytecodeManager.incBytecodes(2);
                this.calsys = getJulianCalendarSystem();
                BytecodeManager.incBytecodes(1);
                final JulianCalendar jcal = GregorianCalendar.jcal;
                BytecodeManager.incBytecodes(4);
                final TimeZone zone2 = this.getZone();
                BytecodeManager.incBytecodes(1);
                this.cdate = jcal.newCalendarDate(zone2);
                BytecodeManager.incBytecodes(1);
                final JulianCalendar jcal2 = GregorianCalendar.jcal;
                final BaseCalendar.Date cdate4 = this.cdate;
                final long fixedDate3 = cachedFixedDate;
                BytecodeManager.incBytecodes(5);
                jcal2.getCalendarDateFromFixedDate(cdate4, fixedDate3);
                final BaseCalendar.Date cdate5 = this.cdate;
                BytecodeManager.incBytecodes(3);
                final Era era = cdate5.getEra();
                BytecodeManager.incBytecodes(1);
                final Era era2 = era;
                final Era era3 = GregorianCalendar.jeras[0];
                BytecodeManager.incBytecodes(5);
                if (era2 == era3) {
                    n18 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                final BaseCalendar.Date cdate6 = this.cdate;
                BytecodeManager.incBytecodes(3);
                n24 = cdate6.getYear();
                BytecodeManager.incBytecodes(1);
            }
            final int n26 = 0;
            final int n27 = n18;
            BytecodeManager.incBytecodes(4);
            this.internalSet(n26, n27);
            final int n28 = 1;
            final int n29 = n24;
            BytecodeManager.incBytecodes(4);
            this.internalSet(n28, n29);
            int n30 = n | 0x3;
            BytecodeManager.incBytecodes(4);
            final BaseCalendar.Date cdate7 = this.cdate;
            BytecodeManager.incBytecodes(3);
            final int n31 = cdate7.getMonth() - 1;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar.Date cdate8 = this.cdate;
            BytecodeManager.incBytecodes(3);
            final int dayOfMonth3 = cdate8.getDayOfMonth();
            BytecodeManager.incBytecodes(1);
            final int n32 = n & 0xA4;
            BytecodeManager.incBytecodes(4);
            if (n32 != 0) {
                final int n33 = 2;
                final int n34 = n31;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n33, n34);
                final int n35 = 5;
                final int n36 = dayOfMonth3;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n35, n36);
                final int n37 = 7;
                final BaseCalendar.Date cdate9 = this.cdate;
                BytecodeManager.incBytecodes(5);
                final int dayOfWeek3 = cdate9.getDayOfWeek();
                BytecodeManager.incBytecodes(1);
                this.internalSet(n37, dayOfWeek3);
                n30 |= 0xA4;
                BytecodeManager.incBytecodes(4);
            }
            final int n38 = n & 0x7E00;
            BytecodeManager.incBytecodes(4);
            if (n38 != 0) {
                final int n39 = n15;
                BytecodeManager.incBytecodes(2);
                if (n39 != 0) {
                    final int n40 = n15 / 3600000;
                    BytecodeManager.incBytecodes(4);
                    final int n41 = 11;
                    final int n42 = n40;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n41, n42);
                    final int n43 = 9;
                    final int n44 = n40 / 12;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n43, n44);
                    final int n45 = 10;
                    final int n46 = n40 % 12;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n45, n46);
                    final int n47 = n15 % 3600000;
                    BytecodeManager.incBytecodes(4);
                    final int n48 = 12;
                    final int n49 = n47 / 60000;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n48, n49);
                    final int n50 = n47 % 60000;
                    BytecodeManager.incBytecodes(4);
                    final int n51 = 13;
                    final int n52 = n50 / 1000;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n51, n52);
                    final int n53 = 14;
                    final int n54 = n50 % 1000;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n53, n54);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n55 = 11;
                    final int n56 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n55, n56);
                    final int n57 = 9;
                    final int n58 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n57, n58);
                    final int n59 = 10;
                    final int n60 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n59, n60);
                    final int n61 = 12;
                    final int n62 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n61, n62);
                    final int n63 = 13;
                    final int n64 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n63, n64);
                    final int n65 = 14;
                    final int n66 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n65, n66);
                }
                n30 |= 0x7E00;
                BytecodeManager.incBytecodes(4);
            }
            final int n67 = n & 0x18000;
            BytecodeManager.incBytecodes(4);
            if (n67 != 0) {
                final int n68 = 15;
                final int n69 = this.zoneOffsets[0];
                BytecodeManager.incBytecodes(7);
                this.internalSet(n68, n69);
                final int n70 = 16;
                final int n71 = this.zoneOffsets[1];
                BytecodeManager.incBytecodes(7);
                this.internalSet(n70, n71);
                n30 |= 0x18000;
                BytecodeManager.incBytecodes(4);
            }
            final int n72 = n & 0x158;
            BytecodeManager.incBytecodes(4);
            if (n72 != 0) {
                final BaseCalendar.Date cdate10 = this.cdate;
                BytecodeManager.incBytecodes(3);
                final int normalizedYear3 = cdate10.getNormalizedYear();
                BytecodeManager.incBytecodes(1);
                final BaseCalendar calsys = this.calsys;
                final int year = normalizedYear3;
                final int month3 = 1;
                final int dayOfMonth4 = 1;
                final BaseCalendar.Date cdate11 = this.cdate;
                BytecodeManager.incBytecodes(8);
                long n73 = calsys.getFixedDate(year, month3, dayOfMonth4, cdate11);
                BytecodeManager.incBytecodes(1);
                int n74 = (int)(cachedFixedDate - n73) + 1;
                BytecodeManager.incBytecodes(7);
                long fixedDateMonth1 = cachedFixedDate - dayOfMonth3 + 1L;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(2);
                final BaseCalendar calsys2 = this.calsys;
                final Gregorian gcal4 = GregorianCalendar.gcal;
                BytecodeManager.incBytecodes(4);
                int n75;
                if (calsys2 == gcal4) {
                    n75 = this.gregorianCutoverYear;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n75 = this.gregorianCutoverYearJulian;
                    BytecodeManager.incBytecodes(2);
                }
                final int n76 = n75;
                BytecodeManager.incBytecodes(1);
                int n77 = dayOfMonth3 - 1;
                BytecodeManager.incBytecodes(4);
                final int n78 = normalizedYear3;
                final int n79 = n76;
                BytecodeManager.incBytecodes(3);
                if (n78 == n79) {
                    final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                    final int gregorianCutoverYear = this.gregorianCutoverYear;
                    BytecodeManager.incBytecodes(5);
                    if (gregorianCutoverYearJulian <= gregorianCutoverYear) {
                        final BaseCalendar.Date cdate12 = this.cdate;
                        final long n80 = cachedFixedDate;
                        BytecodeManager.incBytecodes(5);
                        n73 = this.getFixedDateJan1(cdate12, n80);
                        BytecodeManager.incBytecodes(1);
                        final long n81 = lcmp(cachedFixedDate, this.gregorianCutoverDate);
                        BytecodeManager.incBytecodes(5);
                        if (n81 >= 0) {
                            final BaseCalendar.Date cdate13 = this.cdate;
                            final long n82 = cachedFixedDate;
                            BytecodeManager.incBytecodes(5);
                            fixedDateMonth1 = this.getFixedDateMonth1(cdate13, n82);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final int n83 = (int)(cachedFixedDate - n73) + 1;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(4);
                    n74 = n83;
                    BytecodeManager.incBytecodes(2);
                    n77 = (int)(cachedFixedDate - fixedDateMonth1);
                    BytecodeManager.incBytecodes(5);
                }
                final int n84 = 6;
                final int n85 = n74;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n84, n85);
                final int n86 = 8;
                final int n87 = n77 / 7 + 1;
                BytecodeManager.incBytecodes(8);
                this.internalSet(n86, n87);
                final long n88 = n73;
                final long n89 = cachedFixedDate;
                BytecodeManager.incBytecodes(4);
                int n90 = this.getWeekNumber(n88, n89);
                BytecodeManager.incBytecodes(1);
                final int n91 = n90;
                BytecodeManager.incBytecodes(2);
                Label_2765: {
                    if (n91 == 0) {
                        final long n92 = n73 - 1L;
                        BytecodeManager.incBytecodes(4);
                        long n93 = n73 - 365L;
                        BytecodeManager.incBytecodes(4);
                        final int n94 = normalizedYear3;
                        final int n95 = n76 + 1;
                        BytecodeManager.incBytecodes(5);
                        if (n94 > n95) {
                            final int gregorianYear = normalizedYear3 - 1;
                            BytecodeManager.incBytecodes(4);
                            final boolean gregorianLeapYear = CalendarUtils.isGregorianLeapYear(gregorianYear);
                            BytecodeManager.incBytecodes(1);
                            if (gregorianLeapYear) {
                                --n93;
                                BytecodeManager.incBytecodes(5);
                            }
                        }
                        else {
                            final int n96 = normalizedYear3;
                            final int gregorianCutoverYearJulian2 = this.gregorianCutoverYearJulian;
                            BytecodeManager.incBytecodes(4);
                            if (n96 <= gregorianCutoverYearJulian2) {
                                final int normalizedJulianYear = normalizedYear3 - 1;
                                BytecodeManager.incBytecodes(4);
                                final boolean julianLeapYear = CalendarUtils.isJulianLeapYear(normalizedJulianYear);
                                BytecodeManager.incBytecodes(1);
                                if (julianLeapYear) {
                                    --n93;
                                    BytecodeManager.incBytecodes(5);
                                }
                            }
                            else {
                                final BaseCalendar calsys3 = this.calsys;
                                BytecodeManager.incBytecodes(3);
                                final long n97 = n92;
                                BytecodeManager.incBytecodes(3);
                                final BaseCalendar.Date calendarDate = this.getCalendarDate(n97);
                                BytecodeManager.incBytecodes(1);
                                final int normalizedYear4 = calendarDate.getNormalizedYear();
                                BytecodeManager.incBytecodes(1);
                                final int n98 = normalizedYear4;
                                final int gregorianCutoverYear2 = this.gregorianCutoverYear;
                                BytecodeManager.incBytecodes(4);
                                if (n98 == gregorianCutoverYear2) {
                                    BytecodeManager.incBytecodes(2);
                                    final BaseCalendar cutoverCalendarSystem = this.getCutoverCalendarSystem();
                                    BytecodeManager.incBytecodes(1);
                                    final BaseCalendar baseCalendar = cutoverCalendarSystem;
                                    final JulianCalendar jcal3 = GregorianCalendar.jcal;
                                    BytecodeManager.incBytecodes(3);
                                    if (baseCalendar == jcal3) {
                                        final JulianCalendar julianCalendar = (JulianCalendar)cutoverCalendarSystem;
                                        final int year2 = normalizedYear4;
                                        final int month4 = 1;
                                        final int dayOfMonth5 = 1;
                                        final BaseCalendar.Date cache = null;
                                        BytecodeManager.incBytecodes(6);
                                        n93 = julianCalendar.getFixedDate(year2, month4, dayOfMonth5, cache);
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        n93 = this.gregorianCutoverDate;
                                        BytecodeManager.incBytecodes(3);
                                        final Gregorian gcal5 = GregorianCalendar.gcal;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                }
                                else {
                                    final int n99 = normalizedYear4;
                                    final int gregorianCutoverYearJulian3 = this.gregorianCutoverYearJulian;
                                    BytecodeManager.incBytecodes(4);
                                    if (n99 <= gregorianCutoverYearJulian3) {
                                        BytecodeManager.incBytecodes(1);
                                        final BaseCalendar julianCalendarSystem = getJulianCalendarSystem();
                                        BytecodeManager.incBytecodes(1);
                                        final BaseCalendar baseCalendar2 = julianCalendarSystem;
                                        final int year3 = normalizedYear4;
                                        final int month5 = 1;
                                        final int dayOfMonth6 = 1;
                                        final BaseCalendar.Date cache2 = null;
                                        BytecodeManager.incBytecodes(6);
                                        n93 = baseCalendar2.getFixedDate(year3, month5, dayOfMonth6, cache2);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                        }
                        final long n100 = n93;
                        final long n101 = n92;
                        BytecodeManager.incBytecodes(4);
                        n90 = this.getWeekNumber(n100, n101);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n102 = normalizedYear3;
                        final int gregorianCutoverYear3 = this.gregorianCutoverYear;
                        BytecodeManager.incBytecodes(4);
                        if (n102 <= gregorianCutoverYear3) {
                            final int n103 = normalizedYear3;
                            final int n104 = this.gregorianCutoverYearJulian - 1;
                            BytecodeManager.incBytecodes(6);
                            if (n103 >= n104) {
                                BaseCalendar baseCalendar3 = this.calsys;
                                BytecodeManager.incBytecodes(3);
                                int gregorianCutoverYear4 = normalizedYear3 + 1;
                                BytecodeManager.incBytecodes(4);
                                final int n105 = gregorianCutoverYear4;
                                final int n106 = this.gregorianCutoverYearJulian + 1;
                                BytecodeManager.incBytecodes(6);
                                if (n105 == n106) {
                                    final int n107 = gregorianCutoverYear4;
                                    final int gregorianCutoverYear5 = this.gregorianCutoverYear;
                                    BytecodeManager.incBytecodes(4);
                                    if (n107 < gregorianCutoverYear5) {
                                        gregorianCutoverYear4 = this.gregorianCutoverYear;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                }
                                final int n108 = gregorianCutoverYear4;
                                final int gregorianCutoverYear6 = this.gregorianCutoverYear;
                                BytecodeManager.incBytecodes(4);
                                if (n108 == gregorianCutoverYear6) {
                                    BytecodeManager.incBytecodes(2);
                                    baseCalendar3 = this.getCutoverCalendarSystem();
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n109 = gregorianCutoverYear4;
                                final int gregorianCutoverYear7 = this.gregorianCutoverYear;
                                BytecodeManager.incBytecodes(4);
                                long n111 = 0L;
                                Label_2673: {
                                    if (n109 <= gregorianCutoverYear7) {
                                        final int gregorianCutoverYearJulian4 = this.gregorianCutoverYearJulian;
                                        final int gregorianCutoverYear8 = this.gregorianCutoverYear;
                                        BytecodeManager.incBytecodes(5);
                                        if (gregorianCutoverYearJulian4 != gregorianCutoverYear8) {
                                            final int n110 = gregorianCutoverYear4;
                                            final int gregorianCutoverYearJulian5 = this.gregorianCutoverYearJulian;
                                            BytecodeManager.incBytecodes(4);
                                            if (n110 != gregorianCutoverYearJulian5) {
                                                n111 = this.gregorianCutoverDate;
                                                BytecodeManager.incBytecodes(3);
                                                final Gregorian gcal6 = GregorianCalendar.gcal;
                                                BytecodeManager.incBytecodes(2);
                                                break Label_2673;
                                            }
                                        }
                                    }
                                    final BaseCalendar baseCalendar4 = baseCalendar3;
                                    final int year4 = gregorianCutoverYear4;
                                    final int month6 = 1;
                                    final int dayOfMonth7 = 1;
                                    final BaseCalendar.Date cache3 = null;
                                    BytecodeManager.incBytecodes(6);
                                    n111 = baseCalendar4.getFixedDate(year4, month6, dayOfMonth7, cache3);
                                    BytecodeManager.incBytecodes(2);
                                }
                                final long fixedDate4 = n111 + 6L;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final int firstDayOfWeek = this.getFirstDayOfWeek();
                                BytecodeManager.incBytecodes(1);
                                final long dayOfWeekDateOnOrBefore = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate4, firstDayOfWeek);
                                BytecodeManager.incBytecodes(1);
                                final int n112 = (int)(dayOfWeekDateOnOrBefore - n111);
                                BytecodeManager.incBytecodes(5);
                                final int n113 = n112;
                                BytecodeManager.incBytecodes(3);
                                final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
                                BytecodeManager.incBytecodes(1);
                                if (n113 < minimalDaysInFirstWeek) {
                                    break Label_2765;
                                }
                                final long n114 = lcmp(cachedFixedDate, dayOfWeekDateOnOrBefore - 7L);
                                BytecodeManager.incBytecodes(6);
                                if (n114 >= 0) {
                                    n90 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                                break Label_2765;
                            }
                        }
                        final int n115 = n90;
                        final int n116 = 52;
                        BytecodeManager.incBytecodes(3);
                        if (n115 >= n116) {
                            long n117 = n73 + 365L;
                            BytecodeManager.incBytecodes(4);
                            final BaseCalendar.Date cdate14 = this.cdate;
                            BytecodeManager.incBytecodes(3);
                            final boolean leapYear = cdate14.isLeapYear();
                            BytecodeManager.incBytecodes(1);
                            if (leapYear) {
                                ++n117;
                                BytecodeManager.incBytecodes(4);
                            }
                            final long fixedDate5 = n117 + 6L;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final int firstDayOfWeek2 = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                            final long dayOfWeekDateOnOrBefore2 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate5, firstDayOfWeek2);
                            BytecodeManager.incBytecodes(1);
                            final int n118 = (int)(dayOfWeekDateOnOrBefore2 - n117);
                            BytecodeManager.incBytecodes(5);
                            final int n119 = n118;
                            BytecodeManager.incBytecodes(3);
                            final int minimalDaysInFirstWeek2 = this.getMinimalDaysInFirstWeek();
                            BytecodeManager.incBytecodes(1);
                            if (n119 >= minimalDaysInFirstWeek2) {
                                final long n120 = lcmp(cachedFixedDate, dayOfWeekDateOnOrBefore2 - 7L);
                                BytecodeManager.incBytecodes(6);
                                if (n120 >= 0) {
                                    n90 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final int n121 = 3;
                final int n122 = n90;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n121, n122);
                final int n123 = 4;
                final long n124 = fixedDateMonth1;
                final long n125 = cachedFixedDate;
                BytecodeManager.incBytecodes(6);
                final int weekNumber = this.getWeekNumber(n124, n125);
                BytecodeManager.incBytecodes(1);
                this.internalSet(n123, weekNumber);
                n30 |= 0x158;
                BytecodeManager.incBytecodes(4);
            }
            final int n126 = n30;
            BytecodeManager.incBytecodes(2);
            return n126;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int getWeekNumber(final long n, final long n2) {
        try {
            final long fixedDate = n + 6L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int firstDayOfWeek = this.getFirstDayOfWeek();
            BytecodeManager.incBytecodes(1);
            long dayOfWeekDateOnOrBefore = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate, firstDayOfWeek);
            BytecodeManager.incBytecodes(1);
            final int n3 = (int)(dayOfWeekDateOnOrBefore - n);
            BytecodeManager.incBytecodes(5);
            final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int n4 = n3;
                final int n5 = 7;
                BytecodeManager.incBytecodes(3);
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int n6 = n3;
            BytecodeManager.incBytecodes(3);
            final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
            BytecodeManager.incBytecodes(1);
            if (n6 >= minimalDaysInFirstWeek) {
                dayOfWeekDateOnOrBefore -= 7L;
                BytecodeManager.incBytecodes(4);
            }
            final int n7 = (int)(n2 - dayOfWeekDateOnOrBefore);
            BytecodeManager.incBytecodes(5);
            final int n8 = n7;
            BytecodeManager.incBytecodes(2);
            if (n8 >= 0) {
                final int n9 = n7 / 7 + 1;
                BytecodeManager.incBytecodes(6);
                return n9;
            }
            final int n10 = n7;
            final int d = 7;
            BytecodeManager.incBytecodes(3);
            final int n11 = CalendarUtils.floorDivide(n10, d) + 1;
            BytecodeManager.incBytecodes(3);
            return n11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void computeTime() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean lenient = this.isLenient();
            BytecodeManager.incBytecodes(1);
            Label_0182: {
                if (!lenient) {
                    final int[] originalFields = this.originalFields;
                    BytecodeManager.incBytecodes(3);
                    if (originalFields == null) {
                        this.originalFields = new int[17];
                        BytecodeManager.incBytecodes(3);
                    }
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int n3 = 17;
                        BytecodeManager.incBytecodes(3);
                        if (n2 >= n3) {
                            break Label_0182;
                        }
                        final int n4 = n;
                        BytecodeManager.incBytecodes(3);
                        final int internalGet = this.internalGet(n4);
                        BytecodeManager.incBytecodes(1);
                        final int n5 = n;
                        BytecodeManager.incBytecodes(3);
                        final boolean externallySet = this.isExternallySet(n5);
                        BytecodeManager.incBytecodes(1);
                        if (externallySet) {
                            final int n6 = internalGet;
                            final int n7 = n;
                            BytecodeManager.incBytecodes(4);
                            final int minimum = this.getMinimum(n7);
                            BytecodeManager.incBytecodes(1);
                            if (n6 < minimum) {
                                break;
                            }
                            final int n8 = internalGet;
                            final int n9 = n;
                            BytecodeManager.incBytecodes(4);
                            final int maximum = this.getMaximum(n9);
                            BytecodeManager.incBytecodes(1);
                            if (n8 > maximum) {
                                break;
                            }
                        }
                        this.originalFields[n] = internalGet;
                        BytecodeManager.incBytecodes(5);
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n10 = n;
                    BytecodeManager.incBytecodes(4);
                    final String fieldName = Calendar.getFieldName(n10);
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex = new IllegalArgumentException(fieldName);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            BytecodeManager.incBytecodes(2);
            int selectFields = this.selectFields();
            BytecodeManager.incBytecodes(1);
            final int n11 = 1;
            BytecodeManager.incBytecodes(3);
            final boolean set = this.isSet(n11);
            BytecodeManager.incBytecodes(1);
            int internalGet2;
            if (set) {
                final int n12 = 1;
                BytecodeManager.incBytecodes(3);
                internalGet2 = this.internalGet(n12);
                BytecodeManager.incBytecodes(1);
            }
            else {
                internalGet2 = 1970;
                BytecodeManager.incBytecodes(1);
            }
            int n13 = internalGet2;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int internalGetEra = this.internalGetEra();
            BytecodeManager.incBytecodes(1);
            final int n14 = internalGetEra;
            BytecodeManager.incBytecodes(2);
            if (n14 == 0) {
                n13 = 1 - n13;
                BytecodeManager.incBytecodes(5);
            }
            else {
                final int n15 = internalGetEra;
                final int n16 = 1;
                BytecodeManager.incBytecodes(3);
                if (n15 != n16) {
                    final String s = "Invalid era";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex2 = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
            }
            final int n17 = n13;
            BytecodeManager.incBytecodes(2);
            if (n17 <= 0) {
                final int n18 = 0;
                BytecodeManager.incBytecodes(3);
                final boolean set2 = this.isSet(n18);
                BytecodeManager.incBytecodes(1);
                if (!set2) {
                    selectFields |= 0x1;
                    BytecodeManager.incBytecodes(4);
                    final int fieldsComputed = 1;
                    BytecodeManager.incBytecodes(3);
                    this.setFieldsComputed(fieldsComputed);
                }
            }
            final long n19 = 0L;
            BytecodeManager.incBytecodes(2);
            final int n20 = selectFields;
            final int n21 = 11;
            BytecodeManager.incBytecodes(3);
            final boolean fieldSet = Calendar.isFieldSet(n20, n21);
            BytecodeManager.incBytecodes(1);
            long n24;
            if (fieldSet) {
                final long n22 = n19;
                final int n23 = 11;
                BytecodeManager.incBytecodes(4);
                n24 = n22 + this.internalGet(n23);
                BytecodeManager.incBytecodes(4);
            }
            else {
                final long n25 = n19;
                final int n26 = 10;
                BytecodeManager.incBytecodes(4);
                n24 = n25 + this.internalGet(n26);
                BytecodeManager.incBytecodes(3);
                final int n27 = selectFields;
                final int n28 = 9;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet2 = Calendar.isFieldSet(n27, n28);
                BytecodeManager.incBytecodes(1);
                if (fieldSet2) {
                    final long n29 = n24;
                    final int n30 = 12;
                    final int n31 = 9;
                    BytecodeManager.incBytecodes(5);
                    n24 = n29 + n30 * this.internalGet(n31);
                    BytecodeManager.incBytecodes(4);
                }
            }
            final long n32 = n24 * 60L;
            BytecodeManager.incBytecodes(4);
            final long n33 = n32;
            final int n34 = 12;
            BytecodeManager.incBytecodes(4);
            final long n35 = n33 + this.internalGet(n34);
            BytecodeManager.incBytecodes(3);
            final long n36 = n35 * 60L;
            BytecodeManager.incBytecodes(4);
            final long n37 = n36;
            final int n38 = 13;
            BytecodeManager.incBytecodes(4);
            final long n39 = n37 + this.internalGet(n38);
            BytecodeManager.incBytecodes(3);
            final long n40 = n39 * 1000L;
            BytecodeManager.incBytecodes(4);
            final long n41 = n40;
            final int n42 = 14;
            BytecodeManager.incBytecodes(4);
            final long n43 = n41 + this.internalGet(n42);
            BytecodeManager.incBytecodes(3);
            long n44 = n43 / 86400000L;
            BytecodeManager.incBytecodes(4);
            long n45 = n43 % 86400000L;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final long n46 = lcmp(n45, 0L);
                BytecodeManager.incBytecodes(4);
                if (n46 >= 0) {
                    break;
                }
                n45 += 86400000L;
                BytecodeManager.incBytecodes(4);
                --n44;
                BytecodeManager.incBytecodes(5);
            }
            final int n47 = n13;
            final int gregorianCutoverYear = this.gregorianCutoverYear;
            BytecodeManager.incBytecodes(4);
            long n54 = 0L;
            Label_1181: {
                long n52 = 0L;
                long n58 = 0L;
                Label_0914: {
                    if (n47 > gregorianCutoverYear) {
                        final int n48 = n13;
                        final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                        BytecodeManager.incBytecodes(4);
                        if (n48 > gregorianCutoverYearJulian) {
                            final long n49 = n44;
                            final Gregorian gcal = GregorianCalendar.gcal;
                            final int n50 = n13;
                            final int n51 = selectFields;
                            BytecodeManager.incBytecodes(6);
                            n52 = n49 + this.getFixedDate(gcal, n50, n51);
                            BytecodeManager.incBytecodes(2);
                            final long n53 = lcmp(n52, this.gregorianCutoverDate);
                            BytecodeManager.incBytecodes(5);
                            if (n53 >= 0) {
                                n54 = n52;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break Label_1181;
                            }
                            final long n55 = n44;
                            BytecodeManager.incBytecodes(3);
                            final BaseCalendar julianCalendarSystem = getJulianCalendarSystem();
                            final int n56 = n13;
                            final int n57 = selectFields;
                            BytecodeManager.incBytecodes(3);
                            n58 = n55 + this.getFixedDate(julianCalendarSystem, n56, n57);
                            BytecodeManager.incBytecodes(3);
                            break Label_0914;
                        }
                    }
                    final int n59 = n13;
                    final int gregorianCutoverYear2 = this.gregorianCutoverYear;
                    BytecodeManager.incBytecodes(4);
                    if (n59 < gregorianCutoverYear2) {
                        final int n60 = n13;
                        final int gregorianCutoverYearJulian2 = this.gregorianCutoverYearJulian;
                        BytecodeManager.incBytecodes(4);
                        if (n60 < gregorianCutoverYearJulian2) {
                            final long n61 = n44;
                            BytecodeManager.incBytecodes(3);
                            final BaseCalendar julianCalendarSystem2 = getJulianCalendarSystem();
                            final int n62 = n13;
                            final int n63 = selectFields;
                            BytecodeManager.incBytecodes(3);
                            n58 = n61 + this.getFixedDate(julianCalendarSystem2, n62, n63);
                            BytecodeManager.incBytecodes(2);
                            final long n64 = lcmp(n58, this.gregorianCutoverDate);
                            BytecodeManager.incBytecodes(5);
                            if (n64 < 0) {
                                n54 = n58;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break Label_1181;
                            }
                            n52 = n58;
                            BytecodeManager.incBytecodes(3);
                            break Label_0914;
                        }
                    }
                    final long n65 = n44;
                    BytecodeManager.incBytecodes(3);
                    final BaseCalendar julianCalendarSystem3 = getJulianCalendarSystem();
                    final int n66 = n13;
                    final int n67 = selectFields;
                    BytecodeManager.incBytecodes(3);
                    n58 = n65 + this.getFixedDate(julianCalendarSystem3, n66, n67);
                    BytecodeManager.incBytecodes(2);
                    final long n68 = n44;
                    final Gregorian gcal2 = GregorianCalendar.gcal;
                    final int n69 = n13;
                    final int n70 = selectFields;
                    BytecodeManager.incBytecodes(6);
                    n52 = n68 + this.getFixedDate(gcal2, n69, n70);
                    BytecodeManager.incBytecodes(2);
                }
                final int n71 = selectFields;
                final int n72 = 6;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet3 = Calendar.isFieldSet(n71, n72);
                BytecodeManager.incBytecodes(1);
                Label_1014: {
                    if (!fieldSet3) {
                        final int n73 = selectFields;
                        final int n74 = 3;
                        BytecodeManager.incBytecodes(3);
                        final boolean fieldSet4 = Calendar.isFieldSet(n73, n74);
                        BytecodeManager.incBytecodes(1);
                        if (!fieldSet4) {
                            break Label_1014;
                        }
                    }
                    final int gregorianCutoverYear3 = this.gregorianCutoverYear;
                    final int gregorianCutoverYearJulian3 = this.gregorianCutoverYearJulian;
                    BytecodeManager.incBytecodes(5);
                    if (gregorianCutoverYear3 == gregorianCutoverYearJulian3) {
                        n54 = n58;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        break Label_1181;
                    }
                    final int n75 = n13;
                    final int gregorianCutoverYear4 = this.gregorianCutoverYear;
                    BytecodeManager.incBytecodes(4);
                    if (n75 == gregorianCutoverYear4) {
                        n54 = n52;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        break Label_1181;
                    }
                }
                final long n76 = lcmp(n52, this.gregorianCutoverDate);
                BytecodeManager.incBytecodes(5);
                if (n76 >= 0) {
                    final long n77 = lcmp(n58, this.gregorianCutoverDate);
                    BytecodeManager.incBytecodes(5);
                    if (n77 >= 0) {
                        n54 = n52;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final BaseCalendar calsys = this.calsys;
                        final Gregorian gcal3 = GregorianCalendar.gcal;
                        BytecodeManager.incBytecodes(4);
                        if (calsys != gcal3) {
                            final BaseCalendar calsys2 = this.calsys;
                            BytecodeManager.incBytecodes(3);
                            if (calsys2 != null) {
                                n54 = n58;
                                BytecodeManager.incBytecodes(3);
                                break Label_1181;
                            }
                        }
                        n54 = n52;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                else {
                    final long n78 = lcmp(n58, this.gregorianCutoverDate);
                    BytecodeManager.incBytecodes(5);
                    if (n78 < 0) {
                        n54 = n58;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        final boolean lenient2 = this.isLenient();
                        BytecodeManager.incBytecodes(1);
                        if (!lenient2) {
                            final String s2 = "the specified date doesn't exist";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex3 = new IllegalArgumentException(s2);
                            BytecodeManager.incBytecodes(1);
                            throw ex3;
                        }
                        n54 = n58;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final long n79 = (n54 - 719163L) * 86400000L + n45;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(2);
            final TimeZone zone = this.getZone();
            BytecodeManager.incBytecodes(1);
            final int[] zoneOffsets = this.zoneOffsets;
            BytecodeManager.incBytecodes(3);
            if (zoneOffsets == null) {
                this.zoneOffsets = new int[2];
                BytecodeManager.incBytecodes(3);
            }
            final int n80 = selectFields & 0x18000;
            BytecodeManager.incBytecodes(4);
            final int n81 = n80;
            final int n82 = 98304;
            BytecodeManager.incBytecodes(3);
            if (n81 != n82) {
                final boolean b = zone instanceof ZoneInfo;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final ZoneInfo zoneInfo = (ZoneInfo)zone;
                    final long wall = n79;
                    final int[] zoneOffsets2 = this.zoneOffsets;
                    BytecodeManager.incBytecodes(6);
                    zoneInfo.getOffsetsByWall(wall, zoneOffsets2);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int n83 = selectFields;
                    final int n84 = 15;
                    BytecodeManager.incBytecodes(3);
                    final boolean fieldSet5 = Calendar.isFieldSet(n83, n84);
                    BytecodeManager.incBytecodes(1);
                    int n86;
                    if (fieldSet5) {
                        final int n85 = 15;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        n86 = this.internalGet(n85);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final TimeZone timeZone = zone;
                        BytecodeManager.incBytecodes(2);
                        n86 = timeZone.getRawOffset();
                    }
                    final int n87 = n86;
                    BytecodeManager.incBytecodes(1);
                    final TimeZone timeZone2 = zone;
                    final long n88 = n79 - n87;
                    final int[] zoneOffsets3 = this.zoneOffsets;
                    BytecodeManager.incBytecodes(8);
                    timeZone2.getOffsets(n88, zoneOffsets3);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n89 = n80;
            BytecodeManager.incBytecodes(2);
            if (n89 != 0) {
                final int n90 = n80;
                final int n91 = 15;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet6 = Calendar.isFieldSet(n90, n91);
                BytecodeManager.incBytecodes(1);
                if (fieldSet6) {
                    final int[] zoneOffsets4 = this.zoneOffsets;
                    final int n92 = 0;
                    final int n93 = 15;
                    BytecodeManager.incBytecodes(6);
                    zoneOffsets4[n92] = this.internalGet(n93);
                    BytecodeManager.incBytecodes(1);
                }
                final int n94 = n80;
                final int n95 = 16;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet7 = Calendar.isFieldSet(n94, n95);
                BytecodeManager.incBytecodes(1);
                if (fieldSet7) {
                    final int[] zoneOffsets5 = this.zoneOffsets;
                    final int n96 = 1;
                    final int n97 = 16;
                    BytecodeManager.incBytecodes(6);
                    zoneOffsets5[n96] = this.internalGet(n97);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final long time = n79 - (this.zoneOffsets[0] + this.zoneOffsets[1]);
            BytecodeManager.incBytecodes(13);
            this.time = time;
            BytecodeManager.incBytecodes(3);
            final int n98 = selectFields;
            BytecodeManager.incBytecodes(4);
            final int n99 = n98 | this.getSetStateFields();
            final int n100 = n80;
            BytecodeManager.incBytecodes(3);
            final int computeFields = this.computeFields(n99, n100);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final boolean lenient3 = this.isLenient();
            BytecodeManager.incBytecodes(1);
            if (!lenient3) {
                int n101 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n102 = n101;
                    final int n103 = 17;
                    BytecodeManager.incBytecodes(3);
                    if (n102 >= n103) {
                        break;
                    }
                    final int n104 = n101;
                    BytecodeManager.incBytecodes(3);
                    final boolean externallySet2 = this.isExternallySet(n104);
                    BytecodeManager.incBytecodes(1);
                    if (!externallySet2) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n105 = this.originalFields[n101];
                        final int n106 = n101;
                        BytecodeManager.incBytecodes(7);
                        final int internalGet3 = this.internalGet(n106);
                        BytecodeManager.incBytecodes(1);
                        if (n105 != internalGet3) {
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder sb = new StringBuilder();
                            final int i = this.originalFields[n101];
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder append = sb.append(i);
                            final String str = " -> ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append2 = append.append(str);
                            final int n107 = n101;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet4 = this.internalGet(n107);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append3 = append2.append(internalGet4);
                            BytecodeManager.incBytecodes(1);
                            final String string = append3.toString();
                            BytecodeManager.incBytecodes(1);
                            final int[] originalFields2 = this.originalFields;
                            final int n108 = 0;
                            final int[] fields = this.fields;
                            final int n109 = 0;
                            final int length = this.fields.length;
                            BytecodeManager.incBytecodes(10);
                            System.arraycopy(originalFields2, n108, fields, n109, length);
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb2 = new StringBuilder();
                            final int n110 = n101;
                            BytecodeManager.incBytecodes(2);
                            final String fieldName2 = Calendar.getFieldName(n110);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append4 = sb2.append(fieldName2);
                            final String str2 = ": ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append5 = append4.append(str2);
                            final String str3 = string;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append6 = append5.append(str3);
                            BytecodeManager.incBytecodes(1);
                            final String string2 = append6.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalArgumentException ex4 = new IllegalArgumentException(string2);
                            BytecodeManager.incBytecodes(1);
                            throw ex4;
                        }
                    }
                    ++n101;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int fieldsNormalized = computeFields;
            BytecodeManager.incBytecodes(3);
            this.setFieldsNormalized(fieldsNormalized);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getFixedDate(final BaseCalendar baseCalendar, int n, final int n2) {
        try {
            int internalGet = 0;
            BytecodeManager.incBytecodes(2);
            final int n3 = 2;
            BytecodeManager.incBytecodes(3);
            final boolean fieldSet = Calendar.isFieldSet(n2, n3);
            BytecodeManager.incBytecodes(1);
            if (fieldSet) {
                final int n4 = 2;
                BytecodeManager.incBytecodes(3);
                internalGet = this.internalGet(n4);
                BytecodeManager.incBytecodes(1);
                final int n5 = internalGet;
                final int n6 = 11;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    n += internalGet / 12;
                    BytecodeManager.incBytecodes(6);
                    internalGet %= 12;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n7 = internalGet;
                    BytecodeManager.incBytecodes(2);
                    if (n7 < 0) {
                        final int[] array = { 0 };
                        BytecodeManager.incBytecodes(2);
                        final int n8 = n;
                        final int n9 = internalGet;
                        final int d = 12;
                        final int[] r = array;
                        BytecodeManager.incBytecodes(5);
                        n = n8 + CalendarUtils.floorDivide(n9, d, r);
                        BytecodeManager.incBytecodes(2);
                        internalGet = array[0];
                        BytecodeManager.incBytecodes(4);
                    }
                }
            }
            final int year = n;
            final int month = internalGet + 1;
            final int dayOfMonth = 1;
            final Gregorian gcal = GregorianCalendar.gcal;
            BytecodeManager.incBytecodes(9);
            BaseCalendar.Date gdate;
            if (baseCalendar == gcal) {
                gdate = this.gdate;
                BytecodeManager.incBytecodes(3);
            }
            else {
                gdate = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            long n10 = baseCalendar.getFixedDate(year, month, dayOfMonth, gdate);
            BytecodeManager.incBytecodes(1);
            final int n11 = 2;
            BytecodeManager.incBytecodes(3);
            final boolean fieldSet2 = Calendar.isFieldSet(n2, n11);
            BytecodeManager.incBytecodes(1);
            if (fieldSet2) {
                final int n12 = 5;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet3 = Calendar.isFieldSet(n2, n12);
                BytecodeManager.incBytecodes(1);
                if (fieldSet3) {
                    final int n13 = 5;
                    BytecodeManager.incBytecodes(3);
                    final boolean set = this.isSet(n13);
                    BytecodeManager.incBytecodes(1);
                    if (set) {
                        final long n14 = n10;
                        final int n15 = 5;
                        BytecodeManager.incBytecodes(4);
                        final long n16 = n14 + this.internalGet(n15);
                        BytecodeManager.incBytecodes(3);
                        n10 = n16 - 1L;
                        BytecodeManager.incBytecodes(5);
                    }
                }
                else {
                    final int n17 = 4;
                    BytecodeManager.incBytecodes(3);
                    final boolean fieldSet4 = Calendar.isFieldSet(n2, n17);
                    BytecodeManager.incBytecodes(1);
                    if (fieldSet4) {
                        final long fixedDate = n10 + 6L;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int firstDayOfWeek = this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(1);
                        long n18 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate, firstDayOfWeek);
                        BytecodeManager.incBytecodes(1);
                        final long n19 = n18 - n10;
                        BytecodeManager.incBytecodes(5);
                        final long n20 = lcmp(n19, (long)this.getMinimalDaysInFirstWeek());
                        BytecodeManager.incBytecodes(3);
                        if (n20 >= 0) {
                            n18 -= 7L;
                            BytecodeManager.incBytecodes(4);
                        }
                        final int n21 = 7;
                        BytecodeManager.incBytecodes(3);
                        final boolean fieldSet5 = Calendar.isFieldSet(n2, n21);
                        BytecodeManager.incBytecodes(1);
                        if (fieldSet5) {
                            final long fixedDate2 = n18 + 6L;
                            final int n22 = 7;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final int internalGet2 = this.internalGet(n22);
                            BytecodeManager.incBytecodes(1);
                            n18 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate2, internalGet2);
                            BytecodeManager.incBytecodes(1);
                        }
                        final long n23 = n18;
                        final int n24 = 7;
                        final int n25 = 4;
                        BytecodeManager.incBytecodes(5);
                        n10 = n23 + n24 * (this.internalGet(n25) - 1);
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n26 = 7;
                        BytecodeManager.incBytecodes(3);
                        final boolean fieldSet6 = Calendar.isFieldSet(n2, n26);
                        BytecodeManager.incBytecodes(1);
                        int n28;
                        if (fieldSet6) {
                            final int n27 = 7;
                            BytecodeManager.incBytecodes(3);
                            n28 = this.internalGet(n27);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            BytecodeManager.incBytecodes(2);
                            n28 = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n29 = 8;
                        BytecodeManager.incBytecodes(3);
                        final boolean fieldSet7 = Calendar.isFieldSet(n2, n29);
                        BytecodeManager.incBytecodes(1);
                        int internalGet3;
                        if (fieldSet7) {
                            final int n30 = 8;
                            BytecodeManager.incBytecodes(3);
                            internalGet3 = this.internalGet(n30);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            internalGet3 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n31 = internalGet3;
                        BytecodeManager.incBytecodes(2);
                        if (n31 >= 0) {
                            final long fixedDate3 = n10 + 7 * internalGet3 - 1L;
                            final int dayOfWeek = n28;
                            BytecodeManager.incBytecodes(10);
                            n10 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate3, dayOfWeek);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n32 = internalGet;
                            final int n33 = n;
                            BytecodeManager.incBytecodes(4);
                            final int n34 = this.monthLength(n32, n33) + 7 * (internalGet3 + 1);
                            BytecodeManager.incBytecodes(7);
                            final long fixedDate4 = n10 + n34 - 1L;
                            final int dayOfWeek2 = n28;
                            BytecodeManager.incBytecodes(8);
                            n10 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate4, dayOfWeek2);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            else {
                final int n35 = n;
                final int gregorianCutoverYear = this.gregorianCutoverYear;
                BytecodeManager.incBytecodes(4);
                if (n35 == gregorianCutoverYear) {
                    final Gregorian gcal2 = GregorianCalendar.gcal;
                    BytecodeManager.incBytecodes(3);
                    if (baseCalendar == gcal2) {
                        final long n36 = lcmp(n10, this.gregorianCutoverDate);
                        BytecodeManager.incBytecodes(5);
                        if (n36 < 0) {
                            final int gregorianCutoverYear2 = this.gregorianCutoverYear;
                            final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                            BytecodeManager.incBytecodes(5);
                            if (gregorianCutoverYear2 != gregorianCutoverYearJulian) {
                                n10 = this.gregorianCutoverDate;
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                    }
                }
                final int n37 = 6;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet8 = Calendar.isFieldSet(n2, n37);
                BytecodeManager.incBytecodes(1);
                if (fieldSet8) {
                    final long n38 = n10;
                    final int n39 = 6;
                    BytecodeManager.incBytecodes(4);
                    final long n40 = n38 + this.internalGet(n39);
                    BytecodeManager.incBytecodes(3);
                    n10 = n40 - 1L;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final long fixedDate5 = n10 + 6L;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final int firstDayOfWeek2 = this.getFirstDayOfWeek();
                    BytecodeManager.incBytecodes(1);
                    long n41 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate5, firstDayOfWeek2);
                    BytecodeManager.incBytecodes(1);
                    final long n42 = n41 - n10;
                    BytecodeManager.incBytecodes(5);
                    final long n43 = lcmp(n42, (long)this.getMinimalDaysInFirstWeek());
                    BytecodeManager.incBytecodes(3);
                    if (n43 >= 0) {
                        n41 -= 7L;
                        BytecodeManager.incBytecodes(4);
                    }
                    final int n44 = 7;
                    BytecodeManager.incBytecodes(3);
                    final boolean fieldSet9 = Calendar.isFieldSet(n2, n44);
                    BytecodeManager.incBytecodes(1);
                    if (fieldSet9) {
                        final int n45 = 7;
                        BytecodeManager.incBytecodes(3);
                        final int internalGet4 = this.internalGet(n45);
                        BytecodeManager.incBytecodes(1);
                        final int n46 = internalGet4;
                        BytecodeManager.incBytecodes(3);
                        final int firstDayOfWeek3 = this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(1);
                        if (n46 != firstDayOfWeek3) {
                            final long fixedDate6 = n41 + 6L;
                            final int dayOfWeek3 = internalGet4;
                            BytecodeManager.incBytecodes(5);
                            n41 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate6, dayOfWeek3);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final long n47 = n41;
                    final long n48 = 7L;
                    final int n49 = 3;
                    BytecodeManager.incBytecodes(5);
                    n10 = n47 + n48 * (this.internalGet(n49) - 1L);
                    BytecodeManager.incBytecodes(6);
                }
            }
            final long n50 = n10;
            BytecodeManager.incBytecodes(2);
            return n50;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private GregorianCalendar getNormalizedCalendar() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean fullyNormalized = this.isFullyNormalized();
            BytecodeManager.incBytecodes(1);
            GregorianCalendar gregorianCalendar;
            if (fullyNormalized) {
                gregorianCalendar = this;
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(2);
                gregorianCalendar = (GregorianCalendar)this.clone();
                BytecodeManager.incBytecodes(2);
                final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
                final boolean lenient = true;
                BytecodeManager.incBytecodes(3);
                gregorianCalendar2.setLenient(lenient);
                final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
                BytecodeManager.incBytecodes(2);
                gregorianCalendar3.complete();
            }
            final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
            BytecodeManager.incBytecodes(2);
            return gregorianCalendar4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static synchronized BaseCalendar getJulianCalendarSystem() {
        try {
            final JulianCalendar jcal = GregorianCalendar.jcal;
            BytecodeManager.incBytecodes(2);
            if (jcal == null) {
                final String calendarName = "julian";
                BytecodeManager.incBytecodes(2);
                GregorianCalendar.jcal = (JulianCalendar)CalendarSystem.forName(calendarName);
                BytecodeManager.incBytecodes(2);
                final JulianCalendar jcal2 = GregorianCalendar.jcal;
                BytecodeManager.incBytecodes(2);
                GregorianCalendar.jeras = jcal2.getEras();
                BytecodeManager.incBytecodes(1);
            }
            final JulianCalendar jcal3 = GregorianCalendar.jcal;
            BytecodeManager.incBytecodes(2);
            return jcal3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BaseCalendar getCutoverCalendarSystem() {
        try {
            final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
            final int gregorianCutoverYear = this.gregorianCutoverYear;
            BytecodeManager.incBytecodes(5);
            if (gregorianCutoverYearJulian < gregorianCutoverYear) {
                final Gregorian gcal = GregorianCalendar.gcal;
                BytecodeManager.incBytecodes(2);
                return gcal;
            }
            BytecodeManager.incBytecodes(1);
            final BaseCalendar julianCalendarSystem = getJulianCalendarSystem();
            BytecodeManager.incBytecodes(1);
            return julianCalendarSystem;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isCutoverYear(final int n) {
        try {
            final BaseCalendar calsys = this.calsys;
            final Gregorian gcal = GregorianCalendar.gcal;
            BytecodeManager.incBytecodes(4);
            int n2;
            if (calsys == gcal) {
                n2 = this.gregorianCutoverYear;
                BytecodeManager.incBytecodes(3);
            }
            else {
                n2 = this.gregorianCutoverYearJulian;
                BytecodeManager.incBytecodes(2);
            }
            final int n3 = n2;
            BytecodeManager.incBytecodes(1);
            final int n4 = n3;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (n == n4) {
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
    
    private long getFixedDateJan1(final BaseCalendar.Date date, final long n) {
        try {
            final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                BytecodeManager.incBytecodes(2);
                final int normalizedYear = date.getNormalizedYear();
                final int gregorianCutoverYear = this.gregorianCutoverYear;
                BytecodeManager.incBytecodes(3);
                if (normalizedYear != gregorianCutoverYear) {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int normalizedYear2 = date.getNormalizedYear();
                    final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                    BytecodeManager.incBytecodes(3);
                    if (normalizedYear2 != gregorianCutoverYearJulian) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
            }
            final int gregorianCutoverYear2 = this.gregorianCutoverYear;
            final int gregorianCutoverYearJulian2 = this.gregorianCutoverYearJulian;
            BytecodeManager.incBytecodes(5);
            if (gregorianCutoverYear2 != gregorianCutoverYearJulian2) {
                final long n2 = lcmp(n, this.gregorianCutoverDate);
                BytecodeManager.incBytecodes(5);
                if (n2 >= 0) {
                    final long gregorianCutoverDate = this.gregorianCutoverDate;
                    BytecodeManager.incBytecodes(3);
                    return gregorianCutoverDate;
                }
            }
            BytecodeManager.incBytecodes(1);
            final BaseCalendar julianCalendarSystem = getJulianCalendarSystem();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar = julianCalendarSystem;
            BytecodeManager.incBytecodes(3);
            final int normalizedYear3 = date.getNormalizedYear();
            final int month = 1;
            final int dayOfMonth = 1;
            final BaseCalendar.Date cache = null;
            BytecodeManager.incBytecodes(4);
            final long fixedDate = baseCalendar.getFixedDate(normalizedYear3, month, dayOfMonth, cache);
            BytecodeManager.incBytecodes(1);
            return fixedDate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getFixedDateMonth1(final BaseCalendar.Date date, final long n) {
        try {
            final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                BytecodeManager.incBytecodes(2);
                final int normalizedYear = date.getNormalizedYear();
                final int gregorianCutoverYear = this.gregorianCutoverYear;
                BytecodeManager.incBytecodes(3);
                if (normalizedYear != gregorianCutoverYear) {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int normalizedYear2 = date.getNormalizedYear();
                    final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                    BytecodeManager.incBytecodes(3);
                    if (normalizedYear2 != gregorianCutoverYearJulian) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            final BaseCalendar.Date gregorianCutoverDate = this.getGregorianCutoverDate();
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date2 = gregorianCutoverDate;
            BytecodeManager.incBytecodes(2);
            final int month = date2.getMonth();
            final int n2 = 1;
            BytecodeManager.incBytecodes(2);
            if (month == n2) {
                final BaseCalendar.Date date3 = gregorianCutoverDate;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int dayOfMonth = date3.getDayOfMonth();
                final int n3 = 1;
                BytecodeManager.incBytecodes(2);
                if (dayOfMonth == n3) {
                    BytecodeManager.incBytecodes(3);
                    final long n4 = n - date.getDayOfMonth() + 1L;
                    BytecodeManager.incBytecodes(5);
                    return n4;
                }
            }
            BytecodeManager.incBytecodes(2);
            final int month2 = date.getMonth();
            final BaseCalendar.Date date4 = gregorianCutoverDate;
            BytecodeManager.incBytecodes(2);
            final int month3 = date4.getMonth();
            BytecodeManager.incBytecodes(1);
            long n5 = 0L;
            if (month2 == month3) {
                BytecodeManager.incBytecodes(2);
                final BaseCalendar.Date lastJulianDate = this.getLastJulianDate();
                BytecodeManager.incBytecodes(1);
                final int gregorianCutoverYear2 = this.gregorianCutoverYear;
                final int gregorianCutoverYearJulian2 = this.gregorianCutoverYearJulian;
                BytecodeManager.incBytecodes(5);
                Label_0309: {
                    if (gregorianCutoverYear2 == gregorianCutoverYearJulian2) {
                        final BaseCalendar.Date date5 = gregorianCutoverDate;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final int month4 = date5.getMonth();
                        final BaseCalendar.Date date6 = lastJulianDate;
                        BytecodeManager.incBytecodes(2);
                        final int month5 = date6.getMonth();
                        BytecodeManager.incBytecodes(1);
                        if (month4 == month5) {
                            final JulianCalendar jcal = GregorianCalendar.jcal;
                            BytecodeManager.incBytecodes(3);
                            final int normalizedYear3 = date.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final int month6 = date.getMonth();
                            final int dayOfMonth2 = 1;
                            final BaseCalendar.Date cache = null;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            n5 = jcal.getFixedDate(normalizedYear3, month6, dayOfMonth2, cache);
                            BytecodeManager.incBytecodes(2);
                            break Label_0309;
                        }
                    }
                    n5 = this.gregorianCutoverDate;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(3);
                n5 = n - date.getDayOfMonth() + 1L;
                BytecodeManager.incBytecodes(5);
            }
            final long n6 = n5;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BaseCalendar.Date getCalendarDate(final long fixedDate) {
        try {
            final long n = lcmp(fixedDate, this.gregorianCutoverDate);
            BytecodeManager.incBytecodes(5);
            BaseCalendar baseCalendar;
            if (n >= 0) {
                baseCalendar = GregorianCalendar.gcal;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(1);
                baseCalendar = getJulianCalendarSystem();
            }
            final BaseCalendar baseCalendar2 = baseCalendar;
            BytecodeManager.incBytecodes(1);
            final BaseCalendar baseCalendar3 = baseCalendar2;
            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
            BytecodeManager.incBytecodes(3);
            final BaseCalendar.Date date = (BaseCalendar.Date)baseCalendar3.newCalendarDate(no_TIMEZONE);
            BytecodeManager.incBytecodes(2);
            final BaseCalendar baseCalendar4 = baseCalendar2;
            final BaseCalendar.Date date2 = date;
            BytecodeManager.incBytecodes(4);
            baseCalendar4.getCalendarDateFromFixedDate(date2, fixedDate);
            final BaseCalendar.Date date3 = date;
            BytecodeManager.incBytecodes(2);
            return date3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BaseCalendar.Date getGregorianCutoverDate() {
        try {
            final long gregorianCutoverDate = this.gregorianCutoverDate;
            BytecodeManager.incBytecodes(4);
            final BaseCalendar.Date calendarDate = this.getCalendarDate(gregorianCutoverDate);
            BytecodeManager.incBytecodes(1);
            return calendarDate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BaseCalendar.Date getLastJulianDate() {
        try {
            final long n = this.gregorianCutoverDate - 1L;
            BytecodeManager.incBytecodes(6);
            final BaseCalendar.Date calendarDate = this.getCalendarDate(n);
            BytecodeManager.incBytecodes(1);
            return calendarDate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int monthLength(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean leapYear = this.isLeapYear(n2);
            BytecodeManager.incBytecodes(1);
            int n3;
            if (leapYear) {
                n3 = GregorianCalendar.LEAP_MONTH_LENGTH[n];
                BytecodeManager.incBytecodes(4);
            }
            else {
                n3 = GregorianCalendar.MONTH_LENGTH[n];
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int monthLength(final int n) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            int internalGet = this.internalGet(n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int internalGetEra = this.internalGetEra();
            BytecodeManager.incBytecodes(1);
            if (internalGetEra == 0) {
                internalGet = 1 - internalGet;
                BytecodeManager.incBytecodes(4);
            }
            final int n3 = internalGet;
            BytecodeManager.incBytecodes(4);
            final int monthLength = this.monthLength(n, n3);
            BytecodeManager.incBytecodes(1);
            return monthLength;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int actualMonthLength() {
        try {
            final BaseCalendar.Date cdate = this.cdate;
            BytecodeManager.incBytecodes(3);
            final int normalizedYear = cdate.getNormalizedYear();
            BytecodeManager.incBytecodes(1);
            final int n = normalizedYear;
            final int gregorianCutoverYear = this.gregorianCutoverYear;
            BytecodeManager.incBytecodes(4);
            if (n != gregorianCutoverYear) {
                final int n2 = normalizedYear;
                final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                BytecodeManager.incBytecodes(4);
                if (n2 != gregorianCutoverYearJulian) {
                    final BaseCalendar calsys = this.calsys;
                    final BaseCalendar.Date cdate2 = this.cdate;
                    BytecodeManager.incBytecodes(5);
                    final int monthLength = calsys.getMonthLength(cdate2);
                    BytecodeManager.incBytecodes(1);
                    return monthLength;
                }
            }
            final BaseCalendar.Date cdate3 = this.cdate;
            BytecodeManager.incBytecodes(3);
            BaseCalendar.Date calendarDate = (BaseCalendar.Date)cdate3.clone();
            BytecodeManager.incBytecodes(2);
            final BaseCalendar calsys2 = this.calsys;
            final BaseCalendar.Date date = calendarDate;
            BytecodeManager.incBytecodes(4);
            final long fixedDate = calsys2.getFixedDate(date);
            BytecodeManager.incBytecodes(1);
            final BaseCalendar.Date date2 = calendarDate;
            final long n3 = fixedDate;
            BytecodeManager.incBytecodes(4);
            final long fixedDateMonth1 = this.getFixedDateMonth1(date2, n3);
            BytecodeManager.incBytecodes(1);
            final long n4 = fixedDateMonth1;
            final BaseCalendar calsys3 = this.calsys;
            final BaseCalendar.Date date3 = calendarDate;
            BytecodeManager.incBytecodes(5);
            final long n5 = n4 + calsys3.getMonthLength(date3);
            BytecodeManager.incBytecodes(3);
            final long n6 = lcmp(n5, this.gregorianCutoverDate);
            BytecodeManager.incBytecodes(5);
            if (n6 < 0) {
                final int n7 = (int)(n5 - fixedDateMonth1);
                BytecodeManager.incBytecodes(5);
                return n7;
            }
            final BaseCalendar.Date cdate4 = this.cdate;
            final BaseCalendar.Date gdate = this.gdate;
            BytecodeManager.incBytecodes(5);
            if (cdate4 != gdate) {
                final Gregorian gcal = GregorianCalendar.gcal;
                final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
                BytecodeManager.incBytecodes(3);
                calendarDate = gcal.newCalendarDate(no_TIMEZONE);
                BytecodeManager.incBytecodes(1);
            }
            final Gregorian gcal2 = GregorianCalendar.gcal;
            final BaseCalendar.Date date4 = calendarDate;
            final long fixedDate2 = n5;
            BytecodeManager.incBytecodes(4);
            gcal2.getCalendarDateFromFixedDate(date4, fixedDate2);
            final BaseCalendar.Date date5 = calendarDate;
            final long n8 = n5;
            BytecodeManager.incBytecodes(4);
            final long fixedDateMonth2 = this.getFixedDateMonth1(date5, n8);
            BytecodeManager.incBytecodes(1);
            final int n9 = (int)(fixedDateMonth2 - fixedDateMonth1);
            BytecodeManager.incBytecodes(5);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int yearLength(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean leapYear = this.isLeapYear(n);
            BytecodeManager.incBytecodes(1);
            int n2;
            if (leapYear) {
                n2 = 366;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = 365;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int yearLength() {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            int internalGet = this.internalGet(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int internalGetEra = this.internalGetEra();
            BytecodeManager.incBytecodes(1);
            if (internalGetEra == 0) {
                internalGet = 1 - internalGet;
                BytecodeManager.incBytecodes(4);
            }
            final int n2 = internalGet;
            BytecodeManager.incBytecodes(3);
            final int yearLength = this.yearLength(n2);
            BytecodeManager.incBytecodes(1);
            return yearLength;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void pinDayOfMonth() {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final int internalGet = this.internalGet(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = internalGet;
            final int gregorianCutoverYear = this.gregorianCutoverYear;
            BytecodeManager.incBytecodes(4);
            int n5 = 0;
            Label_0101: {
                if (n2 <= gregorianCutoverYear) {
                    final int n3 = internalGet;
                    final int gregorianCutoverYearJulian = this.gregorianCutoverYearJulian;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= gregorianCutoverYearJulian) {
                        BytecodeManager.incBytecodes(2);
                        final GregorianCalendar normalizedCalendar = this.getNormalizedCalendar();
                        BytecodeManager.incBytecodes(1);
                        final GregorianCalendar gregorianCalendar = normalizedCalendar;
                        final int n4 = 5;
                        BytecodeManager.incBytecodes(3);
                        n5 = gregorianCalendar.getActualMaximum(n4);
                        BytecodeManager.incBytecodes(1);
                        break Label_0101;
                    }
                }
                final int n6 = 2;
                BytecodeManager.incBytecodes(4);
                final int internalGet2 = this.internalGet(n6);
                BytecodeManager.incBytecodes(1);
                n5 = this.monthLength(internalGet2);
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = 5;
            BytecodeManager.incBytecodes(3);
            final int internalGet3 = this.internalGet(n7);
            BytecodeManager.incBytecodes(1);
            final int n8 = internalGet3;
            final int n9 = n5;
            BytecodeManager.incBytecodes(3);
            if (n8 > n9) {
                final int n10 = 5;
                final int n11 = n5;
                BytecodeManager.incBytecodes(4);
                this.set(n10, n11);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getCurrentFixedDate() {
        try {
            final BaseCalendar calsys = this.calsys;
            final Gregorian gcal = GregorianCalendar.gcal;
            BytecodeManager.incBytecodes(4);
            long n;
            if (calsys == gcal) {
                n = this.cachedFixedDate;
                BytecodeManager.incBytecodes(3);
            }
            else {
                final BaseCalendar calsys2 = this.calsys;
                final BaseCalendar.Date cdate = this.cdate;
                BytecodeManager.incBytecodes(5);
                n = calsys2.getFixedDate(cdate);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int getRolledValue(final int n, int n2, final int n3, final int n4) {
        try {
            final boolean $assertionsDisabled = GregorianCalendar.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0049: {
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(3);
                    if (n >= n3) {
                        BytecodeManager.incBytecodes(3);
                        if (n <= n4) {
                            break Label_0049;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int n5 = n4 - n3 + 1;
            BytecodeManager.incBytecodes(6);
            n2 %= n5;
            BytecodeManager.incBytecodes(4);
            int n6 = n + n2;
            BytecodeManager.incBytecodes(4);
            final int n7 = n6;
            BytecodeManager.incBytecodes(3);
            if (n7 > n4) {
                n6 -= n5;
                BytecodeManager.incBytecodes(5);
            }
            else {
                final int n8 = n6;
                BytecodeManager.incBytecodes(3);
                if (n8 < n3) {
                    n6 += n5;
                    BytecodeManager.incBytecodes(4);
                }
            }
            final boolean $assertionsDisabled2 = GregorianCalendar.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0181: {
                if (!$assertionsDisabled2) {
                    final int n9 = n6;
                    BytecodeManager.incBytecodes(3);
                    if (n9 >= n3) {
                        final int n10 = n6;
                        BytecodeManager.incBytecodes(3);
                        if (n10 <= n4) {
                            break Label_0181;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            final int n11 = n6;
            BytecodeManager.incBytecodes(2);
            return n11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int internalGetEra() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final boolean set = this.isSet(n);
            BytecodeManager.incBytecodes(1);
            int internalGet;
            if (set) {
                final int n2 = 0;
                BytecodeManager.incBytecodes(3);
                internalGet = this.internalGet(n2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                internalGet = 1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return internalGet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            final BaseCalendar.Date gdate = this.gdate;
            BytecodeManager.incBytecodes(3);
            if (gdate == null) {
                final Gregorian gcal = GregorianCalendar.gcal;
                BytecodeManager.incBytecodes(4);
                final TimeZone zone = this.getZone();
                BytecodeManager.incBytecodes(1);
                this.gdate = gcal.newCalendarDate(zone);
                BytecodeManager.incBytecodes(1);
                this.cachedFixedDate = Long.MIN_VALUE;
                BytecodeManager.incBytecodes(3);
            }
            final long gregorianCutover = this.gregorianCutover;
            BytecodeManager.incBytecodes(4);
            this.setGregorianChange(gregorianCutover);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZonedDateTime toZonedDateTime() {
        try {
            BytecodeManager.incBytecodes(2);
            final long timeInMillis = this.getTimeInMillis();
            BytecodeManager.incBytecodes(1);
            final Instant ofEpochMilli = Instant.ofEpochMilli(timeInMillis);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final TimeZone timeZone = this.getTimeZone();
            BytecodeManager.incBytecodes(1);
            final ZoneId zoneId = timeZone.toZoneId();
            BytecodeManager.incBytecodes(1);
            final ZonedDateTime ofInstant = ZonedDateTime.ofInstant(ofEpochMilli, zoneId);
            BytecodeManager.incBytecodes(1);
            return ofInstant;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static GregorianCalendar from(final ZonedDateTime p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0        
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: invokevirtual   java/time/ZonedDateTime.getZone:()Ljava/time/ZoneId;
        //    13: ldc             1
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokestatic    instrumented/java/util/TimeZone.getTimeZone:(Ljava/time/ZoneId;)Linstrumented/java/util/TimeZone;
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokespecial   instrumented/java/util/GregorianCalendar.<init>:(Linstrumented/java/util/TimeZone;)V
        //    29: astore_1       
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload_1        
        //    36: new             Linstrumented/java/util/Date;
        //    39: dup            
        //    40: ldc2_w          -9223372036854775808
        //    43: ldc             5
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokespecial   instrumented/java/util/Date.<init>:(J)V
        //    51: ldc             1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/GregorianCalendar.setGregorianChange:(Linstrumented/java/util/Date;)V
        //    59: aload_1        
        //    60: iconst_2       
        //    61: ldc             3
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: invokevirtual   instrumented/java/util/GregorianCalendar.setFirstDayOfWeek:(I)V
        //    69: aload_1        
        //    70: iconst_4       
        //    71: ldc             3
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: invokevirtual   instrumented/java/util/GregorianCalendar.setMinimalDaysInFirstWeek:(I)V
        //    79: aload_1        
        //    80: aload_0        
        //    81: ldc             3
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: invokevirtual   java/time/ZonedDateTime.toEpochSecond:()J
        //    89: ldc2_w          1000
        //    92: ldc             2
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: invokestatic    java/lang/Math.multiplyExact:(JJ)J
        //   100: aload_0        
        //   101: getstatic       java/time/temporal/ChronoField.MILLI_OF_SECOND:Ljava/time/temporal/ChronoField;
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ldc             1
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokevirtual   java/time/ZonedDateTime.get:(Ljava/time/temporal/TemporalField;)I
        //   117: i2l            
        //   118: ldc             1
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: ldc             1
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: invokestatic    java/lang/Math.addExact:(JJ)J
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokevirtual   instrumented/java/util/GregorianCalendar.setTimeInMillis:(J)V
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: goto            173
        //   147: astore_2       
        //   148: ldc_w           501
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: new             Ljava/lang/IllegalArgumentException;
        //   157: dup            
        //   158: aload_2        
        //   159: ldc             4
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/Throwable;)V
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: athrow         
        //   173: aload_1        
        //   174: ldc             2
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: areturn        
        //   180: athrow         
        //   181: athrow         
        //    StackMapTable: 00 04 FF 00 93 00 02 07 02 BB 07 00 02 00 01 07 02 C5 19 FF 00 06 00 00 00 01 07 00 70 FF 00 00 00 00 00 01 07 02 C3
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  79     181    181    182    Ljava/lang/VirtualMachineError;
        //  79     139    147    173    Ljava/lang/ArithmeticException;
        //  0      180    180    181    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0173:
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
    
    static {
        try {
            final Class<GregorianCalendar> clazz = GregorianCalendar.class;
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
            MONTH_LENGTH = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            BytecodeManager.incBytecodes(50);
            LEAP_MONTH_LENGTH = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            BytecodeManager.incBytecodes(50);
            MIN_VALUES = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, -46800000, 0 };
            BytecodeManager.incBytecodes(70);
            LEAST_MAX_VALUES = new int[] { 1, 292269054, 11, 52, 4, 28, 365, 7, 4, 1, 11, 23, 59, 59, 999, 50400000, 1200000 };
            BytecodeManager.incBytecodes(70);
            MAX_VALUES = new int[] { 1, 292278994, 11, 53, 6, 31, 366, 7, 6, 1, 11, 23, 59, 59, 999, 50400000, 7200000 };
            BytecodeManager.incBytecodes(70);
            BytecodeManager.incBytecodes(1);
            gcal = CalendarSystem.getGregorianCalendar();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
