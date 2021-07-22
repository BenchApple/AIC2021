// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import sun.util.calendar.CalendarSystem;
import java.io.IOException;
import java.io.ObjectInputStream;
import sun.util.calendar.CalendarUtils;
import sun.util.calendar.ZoneInfo;
import sun.util.calendar.BaseCalendar;
import java.util.Iterator;
import sun.util.locale.provider.CalendarDataUtility;
import sun.util.calendar.AbstractCalendar;
import sun.util.calendar.CalendarDate;
import aic2021.engine.BytecodeManager;
import sun.util.calendar.Era;
import sun.util.calendar.Gregorian;
import sun.util.calendar.LocalGregorianCalendar;

class JapaneseImperialCalendar extends Calendar
{
    public static final int BEFORE_MEIJI = 0;
    public static final int MEIJI = 1;
    public static final int TAISHO = 2;
    public static final int SHOWA = 3;
    public static final int HEISEI = 4;
    private static final int EPOCH_OFFSET = 719163;
    private static final int EPOCH_YEAR = 1970;
    private static final int ONE_SECOND = 1000;
    private static final int ONE_MINUTE = 60000;
    private static final int ONE_HOUR = 3600000;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;
    private static final LocalGregorianCalendar jcal;
    private static final Gregorian gcal;
    private static final Era BEFORE_MEIJI_ERA;
    private static final Era[] eras;
    private static final long[] sinceFixedDates;
    static final int[] MIN_VALUES;
    static final int[] LEAST_MAX_VALUES;
    static final int[] MAX_VALUES;
    private static final long serialVersionUID = -3364572813905467929L;
    private transient LocalGregorianCalendar.Date jdate;
    private transient int[] zoneOffsets;
    private transient int[] originalFields;
    private transient long cachedFixedDate;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    JapaneseImperialCalendar(final TimeZone timeZone, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(4);
            super(timeZone, locale);
            this.cachedFixedDate = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(3);
            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
            BytecodeManager.incBytecodes(4);
            this.jdate = jcal.newCalendarDate(timeZone);
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
    
    JapaneseImperialCalendar(final TimeZone timeZone, final Locale locale, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            super(timeZone, locale);
            this.cachedFixedDate = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(3);
            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
            BytecodeManager.incBytecodes(4);
            this.jdate = jcal.newCalendarDate(timeZone);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getCalendarType() {
        try {
            final String s = "japanese";
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
            final boolean b = o instanceof JapaneseImperialCalendar;
            BytecodeManager.incBytecodes(3);
            boolean b2 = false;
            Label_0050: {
                if (b) {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = super.equals(o);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0050;
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
            final int hashCode = super.hashCode();
            final LocalGregorianCalendar.Date jdate = this.jdate;
            BytecodeManager.incBytecodes(3);
            final int n = hashCode ^ jdate.hashCode();
            BytecodeManager.incBytecodes(2);
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
                        final LocalGregorianCalendar.Date jdate = this.jdate;
                        BytecodeManager.incBytecodes(3);
                        final LocalGregorianCalendar.Date date = (LocalGregorianCalendar.Date)jdate.clone();
                        BytecodeManager.incBytecodes(2);
                        final LocalGregorianCalendar.Date date2 = date;
                        BytecodeManager.incBytecodes(3);
                        date2.addYear(n2);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date3 = date;
                        BytecodeManager.incBytecodes(3);
                        this.pinDayOfMonth(date3);
                        final int n5 = 0;
                        final LocalGregorianCalendar.Date date4 = date;
                        BytecodeManager.incBytecodes(4);
                        final int eraIndex = getEraIndex(date4);
                        BytecodeManager.incBytecodes(1);
                        this.set(n5, eraIndex);
                        final int n6 = 1;
                        final LocalGregorianCalendar.Date date5 = date;
                        BytecodeManager.incBytecodes(4);
                        final int year = date5.getYear();
                        BytecodeManager.incBytecodes(1);
                        this.set(n6, year);
                        final int n7 = 2;
                        final LocalGregorianCalendar.Date date6 = date;
                        BytecodeManager.incBytecodes(4);
                        final int n8 = date6.getMonth() - 1;
                        BytecodeManager.incBytecodes(3);
                        this.set(n7, n8);
                        final int n9 = 5;
                        final LocalGregorianCalendar.Date date7 = date;
                        BytecodeManager.incBytecodes(4);
                        final int dayOfMonth = date7.getDayOfMonth();
                        BytecodeManager.incBytecodes(1);
                        this.set(n9, dayOfMonth);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n10 = 2;
                        BytecodeManager.incBytecodes(3);
                        if (n == n10) {
                            final LocalGregorianCalendar.Date jdate2 = this.jdate;
                            BytecodeManager.incBytecodes(3);
                            final LocalGregorianCalendar.Date date8 = (LocalGregorianCalendar.Date)jdate2.clone();
                            BytecodeManager.incBytecodes(2);
                            final LocalGregorianCalendar.Date date9 = date8;
                            BytecodeManager.incBytecodes(3);
                            date9.addMonth(n2);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date10 = date8;
                            BytecodeManager.incBytecodes(3);
                            this.pinDayOfMonth(date10);
                            final int n11 = 0;
                            final LocalGregorianCalendar.Date date11 = date8;
                            BytecodeManager.incBytecodes(4);
                            final int eraIndex2 = getEraIndex(date11);
                            BytecodeManager.incBytecodes(1);
                            this.set(n11, eraIndex2);
                            final int n12 = 1;
                            final LocalGregorianCalendar.Date date12 = date8;
                            BytecodeManager.incBytecodes(4);
                            final int year2 = date12.getYear();
                            BytecodeManager.incBytecodes(1);
                            this.set(n12, year2);
                            final int n13 = 2;
                            final LocalGregorianCalendar.Date date13 = date8;
                            BytecodeManager.incBytecodes(4);
                            final int n14 = date13.getMonth() - 1;
                            BytecodeManager.incBytecodes(3);
                            this.set(n13, n14);
                            final int n15 = 5;
                            final LocalGregorianCalendar.Date date14 = date8;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth2 = date14.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n15, dayOfMonth2);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            BytecodeManager.incBytecodes(2);
                            if (n == 0) {
                                final int n16 = 0;
                                BytecodeManager.incBytecodes(3);
                                int n17 = this.internalGet(n16) + n2;
                                BytecodeManager.incBytecodes(3);
                                final int n18 = n17;
                                BytecodeManager.incBytecodes(2);
                                if (n18 < 0) {
                                    n17 = 0;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final int n19 = n17;
                                    final int n20 = JapaneseImperialCalendar.eras.length - 1;
                                    BytecodeManager.incBytecodes(6);
                                    if (n19 > n20) {
                                        n17 = JapaneseImperialCalendar.eras.length - 1;
                                        BytecodeManager.incBytecodes(5);
                                    }
                                }
                                final int n21 = 0;
                                final int n22 = n17;
                                BytecodeManager.incBytecodes(4);
                                this.set(n21, n22);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                long n23 = n2;
                                BytecodeManager.incBytecodes(3);
                                long n24 = 0L;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(2);
                                switch (n) {
                                    case 10:
                                    case 11: {
                                        n23 *= 3600000L;
                                        BytecodeManager.incBytecodes(4);
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 12: {
                                        n23 *= 60000L;
                                        BytecodeManager.incBytecodes(4);
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    case 13: {
                                        n23 *= 1000L;
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
                                        n23 *= 7L;
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
                                        n23 = n2 / 2;
                                        BytecodeManager.incBytecodes(5);
                                        n24 = 12 * (n2 % 2);
                                        BytecodeManager.incBytecodes(7);
                                        break;
                                    }
                                }
                                final int n25 = 10;
                                BytecodeManager.incBytecodes(3);
                                if (n >= n25) {
                                    final long timeInMillis = this.time + n23;
                                    BytecodeManager.incBytecodes(6);
                                    this.setTimeInMillis(timeInMillis);
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                long cachedFixedDate = this.cachedFixedDate;
                                BytecodeManager.incBytecodes(3);
                                final long n26 = n24;
                                final int n27 = 11;
                                BytecodeManager.incBytecodes(4);
                                final long n28 = n26 + this.internalGet(n27);
                                BytecodeManager.incBytecodes(3);
                                final long n29 = n28 * 60L;
                                BytecodeManager.incBytecodes(4);
                                final long n30 = n29;
                                final int n31 = 12;
                                BytecodeManager.incBytecodes(4);
                                final long n32 = n30 + this.internalGet(n31);
                                BytecodeManager.incBytecodes(3);
                                final long n33 = n32 * 60L;
                                BytecodeManager.incBytecodes(4);
                                final long n34 = n33;
                                final int n35 = 13;
                                BytecodeManager.incBytecodes(4);
                                final long n36 = n34 + this.internalGet(n35);
                                BytecodeManager.incBytecodes(3);
                                final long n37 = n36 * 1000L;
                                BytecodeManager.incBytecodes(4);
                                final long n38 = n37;
                                final int n39 = 14;
                                BytecodeManager.incBytecodes(4);
                                long n40 = n38 + this.internalGet(n39);
                                BytecodeManager.incBytecodes(3);
                                final long n41 = lcmp(n40, 86400000L);
                                BytecodeManager.incBytecodes(4);
                                if (n41 >= 0) {
                                    ++cachedFixedDate;
                                    BytecodeManager.incBytecodes(4);
                                    n40 -= 86400000L;
                                    BytecodeManager.incBytecodes(5);
                                }
                                else {
                                    final long n42 = lcmp(n40, 0L);
                                    BytecodeManager.incBytecodes(4);
                                    if (n42 < 0) {
                                        --cachedFixedDate;
                                        BytecodeManager.incBytecodes(4);
                                        n40 += 86400000L;
                                        BytecodeManager.incBytecodes(4);
                                    }
                                }
                                final long n43 = cachedFixedDate + n23;
                                BytecodeManager.incBytecodes(4);
                                final int n44 = 15;
                                BytecodeManager.incBytecodes(3);
                                final int internalGet = this.internalGet(n44);
                                final int n45 = 16;
                                BytecodeManager.incBytecodes(3);
                                final int n46 = internalGet + this.internalGet(n45);
                                BytecodeManager.incBytecodes(2);
                                final long timeInMillis2 = (n43 - 719163L) * 86400000L + n40 - n46;
                                BytecodeManager.incBytecodes(12);
                                this.setTimeInMillis(timeInMillis2);
                                final int n47 = n46;
                                final int n48 = 15;
                                BytecodeManager.incBytecodes(4);
                                final int internalGet2 = this.internalGet(n48);
                                final int n49 = 16;
                                BytecodeManager.incBytecodes(3);
                                final int n50 = n47 - (internalGet2 + this.internalGet(n49));
                                BytecodeManager.incBytecodes(3);
                                final int n51 = n50;
                                BytecodeManager.incBytecodes(2);
                                if (n51 != 0) {
                                    final long timeInMillis3 = this.time + n50;
                                    BytecodeManager.incBytecodes(7);
                                    this.setTimeInMillis(timeInMillis3);
                                    final long cachedFixedDate2 = this.cachedFixedDate;
                                    BytecodeManager.incBytecodes(3);
                                    final long n52 = lcmp(cachedFixedDate2, n43);
                                    BytecodeManager.incBytecodes(4);
                                    if (n52 != 0) {
                                        final long timeInMillis4 = this.time - n50;
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
                    int n4 = this.getMinimum(n);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(3);
                    int n5 = this.getMaximum(n);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    switch (n) {
                        case 0:
                        case 9:
                        case 12:
                        case 13:
                        case 14: {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 10:
                        case 11: {
                            final int n6 = n5 + 1;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(3);
                            final int internalGet = this.internalGet(n);
                            BytecodeManager.incBytecodes(1);
                            int n7 = (internalGet + n2) % n6;
                            BytecodeManager.incBytecodes(6);
                            final int n8 = n7;
                            BytecodeManager.incBytecodes(2);
                            if (n8 < 0) {
                                n7 += n6;
                                BytecodeManager.incBytecodes(4);
                            }
                            this.time += 3600000 * (n7 - internalGet);
                            BytecodeManager.incBytecodes(11);
                            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
                            final long time = this.time;
                            BytecodeManager.incBytecodes(5);
                            final TimeZone zone = this.getZone();
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date calendarDate = jcal.getCalendarDate(time, zone);
                            BytecodeManager.incBytecodes(1);
                            final int n9 = 5;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet2 = this.internalGet(n9);
                            final LocalGregorianCalendar.Date date = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int dayOfMonth = date.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            if (internalGet2 != dayOfMonth) {
                                final LocalGregorianCalendar.Date date2 = calendarDate;
                                final LocalGregorianCalendar.Date jdate = this.jdate;
                                BytecodeManager.incBytecodes(4);
                                final Era era = jdate.getEra();
                                BytecodeManager.incBytecodes(1);
                                date2.setEra(era);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date date3 = calendarDate;
                                final int n10 = 1;
                                BytecodeManager.incBytecodes(4);
                                final int internalGet3 = this.internalGet(n10);
                                final int n11 = 2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final int month = this.internalGet(n11) + 1;
                                final int n12 = 5;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final int internalGet4 = this.internalGet(n12);
                                BytecodeManager.incBytecodes(1);
                                date3.setDate(internalGet3, month, internalGet4);
                                BytecodeManager.incBytecodes(1);
                                final int n13 = 10;
                                BytecodeManager.incBytecodes(3);
                                if (n == n13) {
                                    final boolean $assertionsDisabled = JapaneseImperialCalendar.$assertionsDisabled;
                                    BytecodeManager.incBytecodes(2);
                                    if (!$assertionsDisabled) {
                                        final int n14 = 9;
                                        BytecodeManager.incBytecodes(3);
                                        final int internalGet5 = this.internalGet(n14);
                                        final int n15 = 1;
                                        BytecodeManager.incBytecodes(2);
                                        if (internalGet5 != n15) {
                                            BytecodeManager.incBytecodes(3);
                                            final AssertionError assertionError = new AssertionError();
                                            BytecodeManager.incBytecodes(1);
                                            throw assertionError;
                                        }
                                    }
                                    final LocalGregorianCalendar.Date date4 = calendarDate;
                                    final int n16 = 12;
                                    BytecodeManager.incBytecodes(3);
                                    date4.addHours(n16);
                                    BytecodeManager.incBytecodes(1);
                                }
                                final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date5 = calendarDate;
                                BytecodeManager.incBytecodes(4);
                                this.time = jcal2.getTime(date5);
                                BytecodeManager.incBytecodes(1);
                            }
                            final LocalGregorianCalendar.Date date6 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int hours = date6.getHours();
                            BytecodeManager.incBytecodes(1);
                            final int n17 = hours % n6;
                            BytecodeManager.incBytecodes(6);
                            this.internalSet(n, n17);
                            final int n18 = 10;
                            BytecodeManager.incBytecodes(3);
                            if (n == n18) {
                                final int n19 = 11;
                                final int n20 = hours;
                                BytecodeManager.incBytecodes(4);
                                this.internalSet(n19, n20);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final int n21 = 9;
                                final int n22 = hours / 12;
                                BytecodeManager.incBytecodes(6);
                                this.internalSet(n21, n22);
                                final int n23 = 10;
                                final int n24 = hours % 12;
                                BytecodeManager.incBytecodes(6);
                                this.internalSet(n23, n24);
                            }
                            final LocalGregorianCalendar.Date date7 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int zoneOffset = date7.getZoneOffset();
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date8 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final int daylightSaving = date8.getDaylightSaving();
                            BytecodeManager.incBytecodes(1);
                            final int n25 = 15;
                            final int n26 = zoneOffset - daylightSaving;
                            BytecodeManager.incBytecodes(6);
                            this.internalSet(n25, n26);
                            final int n27 = 16;
                            final int n28 = daylightSaving;
                            BytecodeManager.incBytecodes(4);
                            this.internalSet(n27, n28);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 1: {
                            BytecodeManager.incBytecodes(3);
                            n4 = this.getActualMinimum(n);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(3);
                            n5 = this.getActualMaximum(n);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 2: {
                            final LocalGregorianCalendar.Date jdate2 = this.jdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear = jdate2.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean transitionYear = this.isTransitionYear(normalizedYear);
                            BytecodeManager.incBytecodes(1);
                            Label_2222: {
                                if (!transitionYear) {
                                    final LocalGregorianCalendar.Date jdate3 = this.jdate;
                                    BytecodeManager.incBytecodes(3);
                                    final int year = jdate3.getYear();
                                    BytecodeManager.incBytecodes(1);
                                    final int n29 = year;
                                    final int n30 = 1;
                                    BytecodeManager.incBytecodes(4);
                                    final int maximum = this.getMaximum(n30);
                                    BytecodeManager.incBytecodes(1);
                                    if (n29 == maximum) {
                                        final LocalGregorianCalendar jcal3 = JapaneseImperialCalendar.jcal;
                                        final long time2 = this.time;
                                        BytecodeManager.incBytecodes(5);
                                        final TimeZone zone2 = this.getZone();
                                        BytecodeManager.incBytecodes(1);
                                        final LocalGregorianCalendar.Date calendarDate2 = jcal3.getCalendarDate(time2, zone2);
                                        BytecodeManager.incBytecodes(1);
                                        final LocalGregorianCalendar jcal4 = JapaneseImperialCalendar.jcal;
                                        final long n31 = Long.MAX_VALUE;
                                        BytecodeManager.incBytecodes(4);
                                        final TimeZone zone3 = this.getZone();
                                        BytecodeManager.incBytecodes(1);
                                        final LocalGregorianCalendar.Date calendarDate3 = jcal4.getCalendarDate(n31, zone3);
                                        BytecodeManager.incBytecodes(1);
                                        final LocalGregorianCalendar.Date date9 = calendarDate3;
                                        BytecodeManager.incBytecodes(2);
                                        final int n32 = date9.getMonth() - 1;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(3);
                                        final int internalGet6 = this.internalGet(n);
                                        final int n33 = n2;
                                        final int n34 = n4;
                                        final int n35 = n32;
                                        BytecodeManager.incBytecodes(4);
                                        int rolledValue = getRolledValue(internalGet6, n33, n34, n35);
                                        BytecodeManager.incBytecodes(1);
                                        final int n36 = rolledValue;
                                        final int n37 = n32;
                                        BytecodeManager.incBytecodes(3);
                                        if (n36 == n37) {
                                            final LocalGregorianCalendar.Date date10 = calendarDate2;
                                            final int n38 = -400;
                                            BytecodeManager.incBytecodes(3);
                                            date10.addYear(n38);
                                            BytecodeManager.incBytecodes(1);
                                            final LocalGregorianCalendar.Date date11 = calendarDate2;
                                            final int month2 = rolledValue + 1;
                                            BytecodeManager.incBytecodes(5);
                                            date11.setMonth(month2);
                                            BytecodeManager.incBytecodes(1);
                                            final LocalGregorianCalendar.Date date12 = calendarDate2;
                                            BytecodeManager.incBytecodes(2);
                                            final int dayOfMonth2 = date12.getDayOfMonth();
                                            final LocalGregorianCalendar.Date date13 = calendarDate3;
                                            BytecodeManager.incBytecodes(2);
                                            final int dayOfMonth3 = date13.getDayOfMonth();
                                            BytecodeManager.incBytecodes(1);
                                            if (dayOfMonth2 > dayOfMonth3) {
                                                final LocalGregorianCalendar.Date date14 = calendarDate2;
                                                final LocalGregorianCalendar.Date date15 = calendarDate3;
                                                BytecodeManager.incBytecodes(3);
                                                final int dayOfMonth4 = date15.getDayOfMonth();
                                                BytecodeManager.incBytecodes(1);
                                                date14.setDayOfMonth(dayOfMonth4);
                                                BytecodeManager.incBytecodes(1);
                                                final LocalGregorianCalendar jcal5 = JapaneseImperialCalendar.jcal;
                                                final LocalGregorianCalendar.Date date16 = calendarDate2;
                                                BytecodeManager.incBytecodes(3);
                                                jcal5.normalize(date16);
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            final LocalGregorianCalendar.Date date17 = calendarDate2;
                                            BytecodeManager.incBytecodes(2);
                                            final int dayOfMonth5 = date17.getDayOfMonth();
                                            final LocalGregorianCalendar.Date date18 = calendarDate3;
                                            BytecodeManager.incBytecodes(2);
                                            final int dayOfMonth6 = date18.getDayOfMonth();
                                            BytecodeManager.incBytecodes(1);
                                            if (dayOfMonth5 == dayOfMonth6) {
                                                final LocalGregorianCalendar.Date date19 = calendarDate2;
                                                BytecodeManager.incBytecodes(1);
                                                BytecodeManager.incBytecodes(1);
                                                final long timeOfDay = date19.getTimeOfDay();
                                                final LocalGregorianCalendar.Date date20 = calendarDate3;
                                                BytecodeManager.incBytecodes(2);
                                                final long n39 = lcmp(timeOfDay, date20.getTimeOfDay());
                                                BytecodeManager.incBytecodes(2);
                                                if (n39 > 0) {
                                                    final LocalGregorianCalendar.Date date21 = calendarDate2;
                                                    final int month3 = rolledValue + 1;
                                                    BytecodeManager.incBytecodes(5);
                                                    date21.setMonth(month3);
                                                    BytecodeManager.incBytecodes(1);
                                                    final LocalGregorianCalendar.Date date22 = calendarDate2;
                                                    final LocalGregorianCalendar.Date date23 = calendarDate3;
                                                    BytecodeManager.incBytecodes(3);
                                                    final int dayOfMonth7 = date23.getDayOfMonth() - 1;
                                                    BytecodeManager.incBytecodes(3);
                                                    date22.setDayOfMonth(dayOfMonth7);
                                                    BytecodeManager.incBytecodes(1);
                                                    final LocalGregorianCalendar jcal6 = JapaneseImperialCalendar.jcal;
                                                    final LocalGregorianCalendar.Date date24 = calendarDate2;
                                                    BytecodeManager.incBytecodes(3);
                                                    jcal6.normalize(date24);
                                                    BytecodeManager.incBytecodes(1);
                                                    final LocalGregorianCalendar.Date date25 = calendarDate2;
                                                    BytecodeManager.incBytecodes(2);
                                                    rolledValue = date25.getMonth() - 1;
                                                    BytecodeManager.incBytecodes(3);
                                                }
                                            }
                                            final int n40 = 5;
                                            final LocalGregorianCalendar.Date date26 = calendarDate2;
                                            BytecodeManager.incBytecodes(4);
                                            final int dayOfMonth8 = date26.getDayOfMonth();
                                            BytecodeManager.incBytecodes(1);
                                            this.set(n40, dayOfMonth8);
                                        }
                                        final int n41 = 2;
                                        final int n42 = rolledValue;
                                        BytecodeManager.incBytecodes(4);
                                        this.set(n41, n42);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final int n43 = year;
                                        final int n44 = 1;
                                        BytecodeManager.incBytecodes(4);
                                        final int minimum = this.getMinimum(n44);
                                        BytecodeManager.incBytecodes(1);
                                        if (n43 == minimum) {
                                            final LocalGregorianCalendar jcal7 = JapaneseImperialCalendar.jcal;
                                            final long time3 = this.time;
                                            BytecodeManager.incBytecodes(5);
                                            final TimeZone zone4 = this.getZone();
                                            BytecodeManager.incBytecodes(1);
                                            final LocalGregorianCalendar.Date calendarDate4 = jcal7.getCalendarDate(time3, zone4);
                                            BytecodeManager.incBytecodes(1);
                                            final LocalGregorianCalendar jcal8 = JapaneseImperialCalendar.jcal;
                                            final long n45 = Long.MIN_VALUE;
                                            BytecodeManager.incBytecodes(4);
                                            final TimeZone zone5 = this.getZone();
                                            BytecodeManager.incBytecodes(1);
                                            final LocalGregorianCalendar.Date calendarDate5 = jcal8.getCalendarDate(n45, zone5);
                                            BytecodeManager.incBytecodes(1);
                                            final LocalGregorianCalendar.Date date27 = calendarDate5;
                                            BytecodeManager.incBytecodes(2);
                                            final int n46 = date27.getMonth() - 1;
                                            BytecodeManager.incBytecodes(3);
                                            BytecodeManager.incBytecodes(3);
                                            final int internalGet7 = this.internalGet(n);
                                            final int n47 = n2;
                                            final int n48 = n46;
                                            final int n49 = n5;
                                            BytecodeManager.incBytecodes(4);
                                            int rolledValue2 = getRolledValue(internalGet7, n47, n48, n49);
                                            BytecodeManager.incBytecodes(1);
                                            final int n50 = rolledValue2;
                                            final int n51 = n46;
                                            BytecodeManager.incBytecodes(3);
                                            if (n50 == n51) {
                                                final LocalGregorianCalendar.Date date28 = calendarDate4;
                                                final int n52 = 400;
                                                BytecodeManager.incBytecodes(3);
                                                date28.addYear(n52);
                                                BytecodeManager.incBytecodes(1);
                                                final LocalGregorianCalendar.Date date29 = calendarDate4;
                                                final int month4 = rolledValue2 + 1;
                                                BytecodeManager.incBytecodes(5);
                                                date29.setMonth(month4);
                                                BytecodeManager.incBytecodes(1);
                                                final LocalGregorianCalendar.Date date30 = calendarDate4;
                                                BytecodeManager.incBytecodes(2);
                                                final int dayOfMonth9 = date30.getDayOfMonth();
                                                final LocalGregorianCalendar.Date date31 = calendarDate5;
                                                BytecodeManager.incBytecodes(2);
                                                final int dayOfMonth10 = date31.getDayOfMonth();
                                                BytecodeManager.incBytecodes(1);
                                                if (dayOfMonth9 < dayOfMonth10) {
                                                    final LocalGregorianCalendar.Date date32 = calendarDate4;
                                                    final LocalGregorianCalendar.Date date33 = calendarDate5;
                                                    BytecodeManager.incBytecodes(3);
                                                    final int dayOfMonth11 = date33.getDayOfMonth();
                                                    BytecodeManager.incBytecodes(1);
                                                    date32.setDayOfMonth(dayOfMonth11);
                                                    BytecodeManager.incBytecodes(1);
                                                    final LocalGregorianCalendar jcal9 = JapaneseImperialCalendar.jcal;
                                                    final LocalGregorianCalendar.Date date34 = calendarDate4;
                                                    BytecodeManager.incBytecodes(3);
                                                    jcal9.normalize(date34);
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                final LocalGregorianCalendar.Date date35 = calendarDate4;
                                                BytecodeManager.incBytecodes(2);
                                                final int dayOfMonth12 = date35.getDayOfMonth();
                                                final LocalGregorianCalendar.Date date36 = calendarDate5;
                                                BytecodeManager.incBytecodes(2);
                                                final int dayOfMonth13 = date36.getDayOfMonth();
                                                BytecodeManager.incBytecodes(1);
                                                if (dayOfMonth12 == dayOfMonth13) {
                                                    final LocalGregorianCalendar.Date date37 = calendarDate4;
                                                    BytecodeManager.incBytecodes(1);
                                                    BytecodeManager.incBytecodes(1);
                                                    final long timeOfDay2 = date37.getTimeOfDay();
                                                    final LocalGregorianCalendar.Date date38 = calendarDate5;
                                                    BytecodeManager.incBytecodes(2);
                                                    final long n53 = lcmp(timeOfDay2, date38.getTimeOfDay());
                                                    BytecodeManager.incBytecodes(2);
                                                    if (n53 < 0) {
                                                        final LocalGregorianCalendar.Date date39 = calendarDate4;
                                                        final int month5 = rolledValue2 + 1;
                                                        BytecodeManager.incBytecodes(5);
                                                        date39.setMonth(month5);
                                                        BytecodeManager.incBytecodes(1);
                                                        final LocalGregorianCalendar.Date date40 = calendarDate4;
                                                        final LocalGregorianCalendar.Date date41 = calendarDate5;
                                                        BytecodeManager.incBytecodes(3);
                                                        final int dayOfMonth14 = date41.getDayOfMonth() + 1;
                                                        BytecodeManager.incBytecodes(3);
                                                        date40.setDayOfMonth(dayOfMonth14);
                                                        BytecodeManager.incBytecodes(1);
                                                        final LocalGregorianCalendar jcal10 = JapaneseImperialCalendar.jcal;
                                                        final LocalGregorianCalendar.Date date42 = calendarDate4;
                                                        BytecodeManager.incBytecodes(3);
                                                        jcal10.normalize(date42);
                                                        BytecodeManager.incBytecodes(1);
                                                        final LocalGregorianCalendar.Date date43 = calendarDate4;
                                                        BytecodeManager.incBytecodes(2);
                                                        rolledValue2 = date43.getMonth() - 1;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                }
                                                final int n54 = 5;
                                                final LocalGregorianCalendar.Date date44 = calendarDate4;
                                                BytecodeManager.incBytecodes(4);
                                                final int dayOfMonth15 = date44.getDayOfMonth();
                                                BytecodeManager.incBytecodes(1);
                                                this.set(n54, dayOfMonth15);
                                            }
                                            final int n55 = 2;
                                            final int n56 = rolledValue2;
                                            BytecodeManager.incBytecodes(4);
                                            this.set(n55, n56);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n57 = 2;
                                            BytecodeManager.incBytecodes(3);
                                            int n58 = (this.internalGet(n57) + n2) % 12;
                                            BytecodeManager.incBytecodes(5);
                                            final int n59 = n58;
                                            BytecodeManager.incBytecodes(2);
                                            if (n59 < 0) {
                                                n58 += 12;
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            final int n60 = 2;
                                            final int n61 = n58;
                                            BytecodeManager.incBytecodes(4);
                                            this.set(n60, n61);
                                            final int n62 = n58;
                                            BytecodeManager.incBytecodes(3);
                                            final int monthLength = this.monthLength(n62);
                                            BytecodeManager.incBytecodes(1);
                                            final int n63 = 5;
                                            BytecodeManager.incBytecodes(3);
                                            final int internalGet8 = this.internalGet(n63);
                                            final int n64 = monthLength;
                                            BytecodeManager.incBytecodes(2);
                                            if (internalGet8 > n64) {
                                                final int n65 = 5;
                                                final int n66 = monthLength;
                                                BytecodeManager.incBytecodes(4);
                                                this.set(n65, n66);
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final LocalGregorianCalendar.Date jdate4 = this.jdate;
                                    BytecodeManager.incBytecodes(3);
                                    final int eraIndex = getEraIndex(jdate4);
                                    BytecodeManager.incBytecodes(1);
                                    CalendarDate calendarDate6 = null;
                                    BytecodeManager.incBytecodes(2);
                                    final LocalGregorianCalendar.Date jdate5 = this.jdate;
                                    BytecodeManager.incBytecodes(3);
                                    final int year2 = jdate5.getYear();
                                    final int n67 = 1;
                                    BytecodeManager.incBytecodes(2);
                                    if (year2 == n67) {
                                        final Era era2 = JapaneseImperialCalendar.eras[eraIndex];
                                        BytecodeManager.incBytecodes(4);
                                        calendarDate6 = era2.getSinceDate();
                                        BytecodeManager.incBytecodes(1);
                                        final CalendarDate calendarDate7 = calendarDate6;
                                        BytecodeManager.incBytecodes(2);
                                        n4 = calendarDate7.getMonth() - 1;
                                        BytecodeManager.incBytecodes(4);
                                    }
                                    else {
                                        final int n68 = eraIndex;
                                        final int n69 = JapaneseImperialCalendar.eras.length - 1;
                                        BytecodeManager.incBytecodes(6);
                                        if (n68 < n69) {
                                            final Era era3 = JapaneseImperialCalendar.eras[eraIndex + 1];
                                            BytecodeManager.incBytecodes(6);
                                            calendarDate6 = era3.getSinceDate();
                                            BytecodeManager.incBytecodes(1);
                                            final CalendarDate calendarDate8 = calendarDate6;
                                            BytecodeManager.incBytecodes(2);
                                            final int year3 = calendarDate8.getYear();
                                            final LocalGregorianCalendar.Date jdate6 = this.jdate;
                                            BytecodeManager.incBytecodes(3);
                                            final int normalizedYear2 = jdate6.getNormalizedYear();
                                            BytecodeManager.incBytecodes(1);
                                            if (year3 == normalizedYear2) {
                                                final CalendarDate calendarDate9 = calendarDate6;
                                                BytecodeManager.incBytecodes(2);
                                                n5 = calendarDate9.getMonth() - 1;
                                                BytecodeManager.incBytecodes(3);
                                                final CalendarDate calendarDate10 = calendarDate6;
                                                BytecodeManager.incBytecodes(2);
                                                final int dayOfMonth16 = calendarDate10.getDayOfMonth();
                                                final int n70 = 1;
                                                BytecodeManager.incBytecodes(2);
                                                if (dayOfMonth16 == n70) {
                                                    --n5;
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                        }
                                    }
                                    final int n71 = n4;
                                    final int n72 = n5;
                                    BytecodeManager.incBytecodes(3);
                                    if (n71 == n72) {
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                    BytecodeManager.incBytecodes(3);
                                    final int internalGet9 = this.internalGet(n);
                                    final int n73 = n2;
                                    final int n74 = n4;
                                    final int n75 = n5;
                                    BytecodeManager.incBytecodes(4);
                                    final int rolledValue3 = getRolledValue(internalGet9, n73, n74, n75);
                                    BytecodeManager.incBytecodes(1);
                                    final int n76 = 2;
                                    final int n77 = rolledValue3;
                                    BytecodeManager.incBytecodes(4);
                                    this.set(n76, n77);
                                    final int n78 = rolledValue3;
                                    final int n79 = n4;
                                    BytecodeManager.incBytecodes(3);
                                    if (n78 == n79) {
                                        final CalendarDate calendarDate11 = calendarDate6;
                                        BytecodeManager.incBytecodes(2);
                                        final int month6 = calendarDate11.getMonth();
                                        final int n80 = 1;
                                        BytecodeManager.incBytecodes(2);
                                        if (month6 == n80) {
                                            final CalendarDate calendarDate12 = calendarDate6;
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                            final int dayOfMonth17 = calendarDate12.getDayOfMonth();
                                            final int n81 = 1;
                                            BytecodeManager.incBytecodes(2);
                                            if (dayOfMonth17 == n81) {
                                                break Label_2222;
                                            }
                                        }
                                        final LocalGregorianCalendar.Date jdate7 = this.jdate;
                                        BytecodeManager.incBytecodes(3);
                                        final int dayOfMonth18 = jdate7.getDayOfMonth();
                                        final CalendarDate calendarDate13 = calendarDate6;
                                        BytecodeManager.incBytecodes(2);
                                        final int dayOfMonth19 = calendarDate13.getDayOfMonth();
                                        BytecodeManager.incBytecodes(1);
                                        if (dayOfMonth18 < dayOfMonth19) {
                                            final int n82 = 5;
                                            final CalendarDate calendarDate14 = calendarDate6;
                                            BytecodeManager.incBytecodes(4);
                                            final int dayOfMonth20 = calendarDate14.getDayOfMonth();
                                            BytecodeManager.incBytecodes(1);
                                            this.set(n82, dayOfMonth20);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    else {
                                        final int n83 = rolledValue3;
                                        final int n84 = n5;
                                        BytecodeManager.incBytecodes(3);
                                        if (n83 == n84) {
                                            final CalendarDate calendarDate15 = calendarDate6;
                                            BytecodeManager.incBytecodes(2);
                                            final int n85 = calendarDate15.getMonth() - 1;
                                            final int n86 = rolledValue3;
                                            BytecodeManager.incBytecodes(4);
                                            if (n85 == n86) {
                                                final CalendarDate calendarDate16 = calendarDate6;
                                                BytecodeManager.incBytecodes(2);
                                                final int dayOfMonth21 = calendarDate16.getDayOfMonth();
                                                BytecodeManager.incBytecodes(1);
                                                final LocalGregorianCalendar.Date jdate8 = this.jdate;
                                                BytecodeManager.incBytecodes(3);
                                                final int dayOfMonth22 = jdate8.getDayOfMonth();
                                                final int n87 = dayOfMonth21;
                                                BytecodeManager.incBytecodes(2);
                                                if (dayOfMonth22 >= n87) {
                                                    final int n88 = 5;
                                                    final int n89 = dayOfMonth21 - 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    this.set(n88, n89);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 3: {
                            final LocalGregorianCalendar.Date jdate9 = this.jdate;
                            BytecodeManager.incBytecodes(3);
                            final int normalizedYear3 = jdate9.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final int n90 = 3;
                            BytecodeManager.incBytecodes(3);
                            n5 = this.getActualMaximum(n90);
                            BytecodeManager.incBytecodes(1);
                            final int n91 = 7;
                            final int n92 = 7;
                            BytecodeManager.incBytecodes(5);
                            final int internalGet10 = this.internalGet(n92);
                            BytecodeManager.incBytecodes(1);
                            this.set(n91, internalGet10);
                            final int n93 = 3;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet11 = this.internalGet(n93);
                            BytecodeManager.incBytecodes(1);
                            final int n94 = internalGet11 + n2;
                            BytecodeManager.incBytecodes(4);
                            final LocalGregorianCalendar.Date jdate10 = this.jdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear4 = jdate10.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean transitionYear2 = this.isTransitionYear(normalizedYear4);
                            BytecodeManager.incBytecodes(1);
                            if (transitionYear2) {
                                final long cachedFixedDate = this.cachedFixedDate;
                                BytecodeManager.incBytecodes(3);
                                final long n95 = cachedFixedDate - 7 * (internalGet11 - n4);
                                BytecodeManager.incBytecodes(9);
                                final long n96 = n95;
                                BytecodeManager.incBytecodes(2);
                                final LocalGregorianCalendar.Date calendarDate17 = getCalendarDate(n96);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date date45 = calendarDate17;
                                BytecodeManager.incBytecodes(2);
                                final Era era4 = date45.getEra();
                                final LocalGregorianCalendar.Date jdate11 = this.jdate;
                                BytecodeManager.incBytecodes(3);
                                final Era era5 = jdate11.getEra();
                                BytecodeManager.incBytecodes(1);
                                Label_2859: {
                                    if (era4 == era5) {
                                        final LocalGregorianCalendar.Date date46 = calendarDate17;
                                        BytecodeManager.incBytecodes(2);
                                        final int year4 = date46.getYear();
                                        final LocalGregorianCalendar.Date jdate12 = this.jdate;
                                        BytecodeManager.incBytecodes(3);
                                        final int year5 = jdate12.getYear();
                                        BytecodeManager.incBytecodes(1);
                                        if (year4 == year5) {
                                            break Label_2859;
                                        }
                                    }
                                    ++n4;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final long n97 = cachedFixedDate + 7 * (n5 - internalGet11);
                                BytecodeManager.incBytecodes(9);
                                final LocalGregorianCalendar jcal11 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date47 = calendarDate17;
                                final long fixedDate = n97;
                                BytecodeManager.incBytecodes(4);
                                jcal11.getCalendarDateFromFixedDate(date47, fixedDate);
                                final LocalGregorianCalendar.Date date48 = calendarDate17;
                                BytecodeManager.incBytecodes(2);
                                final Era era6 = date48.getEra();
                                final LocalGregorianCalendar.Date jdate13 = this.jdate;
                                BytecodeManager.incBytecodes(3);
                                final Era era7 = jdate13.getEra();
                                BytecodeManager.incBytecodes(1);
                                Label_2962: {
                                    if (era6 == era7) {
                                        final LocalGregorianCalendar.Date date49 = calendarDate17;
                                        BytecodeManager.incBytecodes(2);
                                        final int year6 = date49.getYear();
                                        final LocalGregorianCalendar.Date jdate14 = this.jdate;
                                        BytecodeManager.incBytecodes(3);
                                        final int year7 = jdate14.getYear();
                                        BytecodeManager.incBytecodes(1);
                                        if (year6 == year7) {
                                            break Label_2962;
                                        }
                                    }
                                    --n5;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n98 = internalGet11;
                                final int n99 = n2;
                                final int n100 = n4;
                                final int n101 = n5;
                                BytecodeManager.incBytecodes(5);
                                final int n102 = getRolledValue(n98, n99, n100, n101) - 1;
                                BytecodeManager.incBytecodes(3);
                                final long n103 = n95 + n102 * 7;
                                BytecodeManager.incBytecodes(7);
                                final LocalGregorianCalendar.Date calendarDate18 = getCalendarDate(n103);
                                BytecodeManager.incBytecodes(1);
                                final int n104 = 2;
                                final LocalGregorianCalendar.Date date50 = calendarDate18;
                                BytecodeManager.incBytecodes(4);
                                final int n105 = date50.getMonth() - 1;
                                BytecodeManager.incBytecodes(3);
                                this.set(n104, n105);
                                final int n106 = 5;
                                final LocalGregorianCalendar.Date date51 = calendarDate18;
                                BytecodeManager.incBytecodes(4);
                                final int dayOfMonth23 = date51.getDayOfMonth();
                                BytecodeManager.incBytecodes(1);
                                this.set(n106, dayOfMonth23);
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final LocalGregorianCalendar.Date jdate15 = this.jdate;
                            BytecodeManager.incBytecodes(3);
                            final int year8 = jdate15.getYear();
                            BytecodeManager.incBytecodes(1);
                            final int n107 = year8;
                            final int n108 = 1;
                            BytecodeManager.incBytecodes(4);
                            final int maximum2 = this.getMaximum(n108);
                            BytecodeManager.incBytecodes(1);
                            if (n107 == maximum2) {
                                final int n109 = 3;
                                BytecodeManager.incBytecodes(3);
                                n5 = this.getActualMaximum(n109);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final int n110 = year8;
                                final int n111 = 1;
                                BytecodeManager.incBytecodes(4);
                                final int minimum2 = this.getMinimum(n111);
                                BytecodeManager.incBytecodes(1);
                                if (n110 == minimum2) {
                                    final int n112 = 3;
                                    BytecodeManager.incBytecodes(3);
                                    n4 = this.getActualMinimum(n112);
                                    BytecodeManager.incBytecodes(1);
                                    final int n113 = 3;
                                    BytecodeManager.incBytecodes(3);
                                    n5 = this.getActualMaximum(n113);
                                    BytecodeManager.incBytecodes(1);
                                    final int n114 = n94;
                                    final int n115 = n4;
                                    BytecodeManager.incBytecodes(3);
                                    if (n114 > n115) {
                                        final int n116 = n94;
                                        final int n117 = n5;
                                        BytecodeManager.incBytecodes(3);
                                        if (n116 < n117) {
                                            final int n118 = 3;
                                            final int n119 = n94;
                                            BytecodeManager.incBytecodes(4);
                                            this.set(n118, n119);
                                            BytecodeManager.incBytecodes(1);
                                            return;
                                        }
                                    }
                                }
                            }
                            final int n120 = n94;
                            final int n121 = n4;
                            BytecodeManager.incBytecodes(3);
                            if (n120 > n121) {
                                final int n122 = n94;
                                final int n123 = n5;
                                BytecodeManager.incBytecodes(3);
                                if (n122 < n123) {
                                    final int n124 = 3;
                                    final int n125 = n94;
                                    BytecodeManager.incBytecodes(4);
                                    this.set(n124, n125);
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                            }
                            final long cachedFixedDate2 = this.cachedFixedDate;
                            BytecodeManager.incBytecodes(3);
                            final long n126 = cachedFixedDate2 - 7 * (internalGet11 - n4);
                            BytecodeManager.incBytecodes(9);
                            final int n127 = year8;
                            final int n128 = 1;
                            BytecodeManager.incBytecodes(4);
                            final int minimum3 = this.getMinimum(n128);
                            BytecodeManager.incBytecodes(1);
                            if (n127 != minimum3) {
                                final Gregorian gcal = JapaneseImperialCalendar.gcal;
                                final long fixedDate2 = n126;
                                BytecodeManager.incBytecodes(3);
                                final int yearFromFixedDate = gcal.getYearFromFixedDate(fixedDate2);
                                final int n129 = normalizedYear3;
                                BytecodeManager.incBytecodes(2);
                                if (yearFromFixedDate != n129) {
                                    ++n4;
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                            else {
                                final LocalGregorianCalendar jcal12 = JapaneseImperialCalendar.jcal;
                                final long n130 = Long.MIN_VALUE;
                                BytecodeManager.incBytecodes(4);
                                final TimeZone zone6 = this.getZone();
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date calendarDate19 = jcal12.getCalendarDate(n130, zone6);
                                BytecodeManager.incBytecodes(1);
                                final long n131 = n126;
                                final LocalGregorianCalendar jcal13 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date52 = calendarDate19;
                                BytecodeManager.incBytecodes(4);
                                final long n132 = lcmp(n131, jcal13.getFixedDate(date52));
                                BytecodeManager.incBytecodes(2);
                                if (n132 < 0) {
                                    ++n4;
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final long n133 = cachedFixedDate2;
                            final int n134 = 7;
                            final int n135 = n5;
                            final int n136 = 3;
                            BytecodeManager.incBytecodes(6);
                            final long n137 = n133 + n134 * (n135 - this.internalGet(n136));
                            BytecodeManager.incBytecodes(5);
                            final Gregorian gcal2 = JapaneseImperialCalendar.gcal;
                            final long fixedDate3 = n137;
                            BytecodeManager.incBytecodes(3);
                            final int yearFromFixedDate2 = gcal2.getYearFromFixedDate(fixedDate3);
                            final int n138 = normalizedYear3;
                            BytecodeManager.incBytecodes(2);
                            if (yearFromFixedDate2 != n138) {
                                --n5;
                                BytecodeManager.incBytecodes(2);
                                break;
                            }
                            break;
                        }
                        case 4: {
                            final LocalGregorianCalendar.Date jdate16 = this.jdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear5 = jdate16.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean transitionYear3 = this.isTransitionYear(normalizedYear5);
                            BytecodeManager.incBytecodes(1);
                            final int n139 = 7;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet12 = this.internalGet(n139);
                            BytecodeManager.incBytecodes(2);
                            int n140 = internalGet12 - this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(2);
                            final int n141 = n140;
                            BytecodeManager.incBytecodes(2);
                            if (n141 < 0) {
                                n140 += 7;
                                BytecodeManager.incBytecodes(1);
                            }
                            final long cachedFixedDate3 = this.cachedFixedDate;
                            BytecodeManager.incBytecodes(3);
                            final boolean b2 = transitionYear3;
                            BytecodeManager.incBytecodes(2);
                            long fixedDateMonth1;
                            int n143;
                            if (b2) {
                                final LocalGregorianCalendar.Date jdate17 = this.jdate;
                                final long n142 = cachedFixedDate3;
                                BytecodeManager.incBytecodes(5);
                                fixedDateMonth1 = this.getFixedDateMonth1(jdate17, n142);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(2);
                                n143 = this.actualMonthLength();
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final long n144 = cachedFixedDate3;
                                final int n145 = 5;
                                BytecodeManager.incBytecodes(4);
                                fixedDateMonth1 = n144 - this.internalGet(n145) + 1L;
                                BytecodeManager.incBytecodes(5);
                                final LocalGregorianCalendar jcal14 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date jdate18 = this.jdate;
                                BytecodeManager.incBytecodes(4);
                                n143 = jcal14.getMonthLength(jdate18);
                                BytecodeManager.incBytecodes(1);
                            }
                            final long fixedDate4 = fixedDateMonth1 + 6L;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final int firstDayOfWeek = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                            long dayOfWeekDateOnOrBefore = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate4, firstDayOfWeek);
                            BytecodeManager.incBytecodes(1);
                            final int n146 = (int)(dayOfWeekDateOnOrBefore - fixedDateMonth1);
                            BytecodeManager.incBytecodes(6);
                            final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
                            BytecodeManager.incBytecodes(1);
                            if (n146 >= minimalDaysInFirstWeek) {
                                dayOfWeekDateOnOrBefore -= 7L;
                                BytecodeManager.incBytecodes(4);
                            }
                            BytecodeManager.incBytecodes(3);
                            final int actualMaximum = this.getActualMaximum(n);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(3);
                            final int internalGet13 = this.internalGet(n);
                            final int n147 = n2;
                            final int n148 = 1;
                            final int n149 = actualMaximum;
                            BytecodeManager.incBytecodes(4);
                            final int n150 = getRolledValue(internalGet13, n147, n148, n149) - 1;
                            BytecodeManager.incBytecodes(3);
                            long n151 = dayOfWeekDateOnOrBefore + n150 * 7 + n140;
                            BytecodeManager.incBytecodes(10);
                            final long n152 = lcmp(n151, fixedDateMonth1);
                            BytecodeManager.incBytecodes(4);
                            if (n152 < 0) {
                                n151 = fixedDateMonth1;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final long n153 = lcmp(n151, fixedDateMonth1 + n143);
                                BytecodeManager.incBytecodes(7);
                                if (n153 >= 0) {
                                    n151 = fixedDateMonth1 + n143 - 1L;
                                    BytecodeManager.incBytecodes(7);
                                }
                            }
                            final int n154 = 5;
                            final int n155 = (int)(n151 - fixedDateMonth1) + 1;
                            BytecodeManager.incBytecodes(9);
                            this.set(n154, n155);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 5: {
                            final LocalGregorianCalendar.Date jdate19 = this.jdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear6 = jdate19.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean transitionYear4 = this.isTransitionYear(normalizedYear6);
                            BytecodeManager.incBytecodes(1);
                            if (!transitionYear4) {
                                final LocalGregorianCalendar jcal15 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date jdate20 = this.jdate;
                                BytecodeManager.incBytecodes(4);
                                n5 = jcal15.getMonthLength(jdate20);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final LocalGregorianCalendar.Date jdate21 = this.jdate;
                            final long cachedFixedDate4 = this.cachedFixedDate;
                            BytecodeManager.incBytecodes(6);
                            final long fixedDateMonth2 = this.getFixedDateMonth1(jdate21, cachedFixedDate4);
                            BytecodeManager.incBytecodes(1);
                            final int n156 = (int)(this.cachedFixedDate - fixedDateMonth2);
                            final int n157 = n2;
                            final int n158 = 0;
                            BytecodeManager.incBytecodes(8);
                            BytecodeManager.incBytecodes(1);
                            final int n159 = this.actualMonthLength() - 1;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int rolledValue4 = getRolledValue(n156, n157, n158, n159);
                            BytecodeManager.incBytecodes(1);
                            final long n160 = fixedDateMonth2 + rolledValue4;
                            BytecodeManager.incBytecodes(5);
                            final LocalGregorianCalendar.Date calendarDate20 = getCalendarDate(n160);
                            BytecodeManager.incBytecodes(1);
                            final boolean $assertionsDisabled2 = JapaneseImperialCalendar.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            Label_3730: {
                                if (!$assertionsDisabled2) {
                                    final LocalGregorianCalendar.Date date53 = calendarDate20;
                                    BytecodeManager.incBytecodes(2);
                                    final int eraIndex2 = getEraIndex(date53);
                                    BytecodeManager.incBytecodes(2);
                                    final int internalGetEra = this.internalGetEra();
                                    BytecodeManager.incBytecodes(1);
                                    if (eraIndex2 == internalGetEra) {
                                        final LocalGregorianCalendar.Date date54 = calendarDate20;
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        final int year9 = date54.getYear();
                                        final int n161 = 1;
                                        BytecodeManager.incBytecodes(3);
                                        final int internalGet14 = this.internalGet(n161);
                                        BytecodeManager.incBytecodes(1);
                                        if (year9 == internalGet14) {
                                            final LocalGregorianCalendar.Date date55 = calendarDate20;
                                            BytecodeManager.incBytecodes(2);
                                            final int n162 = date55.getMonth() - 1;
                                            final int n163 = 2;
                                            BytecodeManager.incBytecodes(5);
                                            final int internalGet15 = this.internalGet(n163);
                                            BytecodeManager.incBytecodes(1);
                                            if (n162 == internalGet15) {
                                                break Label_3730;
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError2 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError2;
                                }
                            }
                            final int n164 = 5;
                            final LocalGregorianCalendar.Date date56 = calendarDate20;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth24 = date56.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n164, dayOfMonth24);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 6: {
                            BytecodeManager.incBytecodes(3);
                            n5 = this.getActualMaximum(n);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date jdate22 = this.jdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear7 = jdate22.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean transitionYear5 = this.isTransitionYear(normalizedYear7);
                            BytecodeManager.incBytecodes(1);
                            if (!transitionYear5) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final int n165 = 6;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet16 = this.internalGet(n165);
                            final int n166 = n2;
                            final int n167 = n4;
                            final int n168 = n5;
                            BytecodeManager.incBytecodes(4);
                            final int rolledValue5 = getRolledValue(internalGet16, n166, n167, n168);
                            BytecodeManager.incBytecodes(1);
                            final long cachedFixedDate5 = this.cachedFixedDate;
                            final int n169 = 6;
                            BytecodeManager.incBytecodes(5);
                            final long n170 = cachedFixedDate5 - this.internalGet(n169);
                            BytecodeManager.incBytecodes(3);
                            final long n171 = n170 + rolledValue5;
                            BytecodeManager.incBytecodes(5);
                            final LocalGregorianCalendar.Date calendarDate21 = getCalendarDate(n171);
                            BytecodeManager.incBytecodes(1);
                            final boolean $assertionsDisabled3 = JapaneseImperialCalendar.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            Label_3969: {
                                if (!$assertionsDisabled3) {
                                    final LocalGregorianCalendar.Date date57 = calendarDate21;
                                    BytecodeManager.incBytecodes(2);
                                    final int eraIndex3 = getEraIndex(date57);
                                    BytecodeManager.incBytecodes(2);
                                    final int internalGetEra2 = this.internalGetEra();
                                    BytecodeManager.incBytecodes(1);
                                    if (eraIndex3 == internalGetEra2) {
                                        final LocalGregorianCalendar.Date date58 = calendarDate21;
                                        BytecodeManager.incBytecodes(2);
                                        final int year10 = date58.getYear();
                                        final int n172 = 1;
                                        BytecodeManager.incBytecodes(3);
                                        final int internalGet17 = this.internalGet(n172);
                                        BytecodeManager.incBytecodes(1);
                                        if (year10 == internalGet17) {
                                            break Label_3969;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError3 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError3;
                                }
                            }
                            final int n173 = 2;
                            final LocalGregorianCalendar.Date date59 = calendarDate21;
                            BytecodeManager.incBytecodes(4);
                            final int n174 = date59.getMonth() - 1;
                            BytecodeManager.incBytecodes(3);
                            this.set(n173, n174);
                            final int n175 = 5;
                            final LocalGregorianCalendar.Date date60 = calendarDate21;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth25 = date60.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n175, dayOfMonth25);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 7: {
                            final LocalGregorianCalendar.Date jdate23 = this.jdate;
                            BytecodeManager.incBytecodes(3);
                            final int normalizedYear8 = jdate23.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final int n176 = normalizedYear8;
                            BytecodeManager.incBytecodes(3);
                            final boolean transitionYear6 = this.isTransitionYear(n176);
                            BytecodeManager.incBytecodes(1);
                            if (!transitionYear6) {
                                final int n177 = normalizedYear8 - 1;
                                BytecodeManager.incBytecodes(5);
                                final boolean transitionYear7 = this.isTransitionYear(n177);
                                BytecodeManager.incBytecodes(1);
                                if (!transitionYear7) {
                                    final int n178 = 3;
                                    BytecodeManager.incBytecodes(3);
                                    final int internalGet18 = this.internalGet(n178);
                                    BytecodeManager.incBytecodes(1);
                                    final int n179 = internalGet18;
                                    final int n180 = 1;
                                    BytecodeManager.incBytecodes(3);
                                    if (n179 > n180) {
                                        final int n181 = internalGet18;
                                        final int n182 = 52;
                                        BytecodeManager.incBytecodes(3);
                                        if (n181 < n182) {
                                            final int n183 = 3;
                                            final int n184 = 3;
                                            BytecodeManager.incBytecodes(5);
                                            final int internalGet19 = this.internalGet(n184);
                                            BytecodeManager.incBytecodes(1);
                                            this.set(n183, internalGet19);
                                            n5 = 7;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            break;
                                        }
                                    }
                                }
                            }
                            n2 %= 7;
                            BytecodeManager.incBytecodes(4);
                            final boolean b3 = n2 != 0;
                            BytecodeManager.incBytecodes(2);
                            if (!b3) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final long cachedFixedDate6 = this.cachedFixedDate;
                            BytecodeManager.incBytecodes(3);
                            final long fixedDate5 = cachedFixedDate6;
                            BytecodeManager.incBytecodes(3);
                            final int firstDayOfWeek2 = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                            final long dayOfWeekDateOnOrBefore2 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate5, firstDayOfWeek2);
                            BytecodeManager.incBytecodes(1);
                            long n185 = cachedFixedDate6 + n2;
                            BytecodeManager.incBytecodes(5);
                            final long n186 = lcmp(n185, dayOfWeekDateOnOrBefore2);
                            BytecodeManager.incBytecodes(4);
                            if (n186 < 0) {
                                n185 += 7L;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                final long n187 = lcmp(n185, dayOfWeekDateOnOrBefore2 + 7L);
                                BytecodeManager.incBytecodes(6);
                                if (n187 >= 0) {
                                    n185 -= 7L;
                                    BytecodeManager.incBytecodes(4);
                                }
                            }
                            final long n188 = n185;
                            BytecodeManager.incBytecodes(2);
                            final LocalGregorianCalendar.Date calendarDate22 = getCalendarDate(n188);
                            BytecodeManager.incBytecodes(1);
                            final int n189 = 0;
                            final LocalGregorianCalendar.Date date61 = calendarDate22;
                            BytecodeManager.incBytecodes(4);
                            final int eraIndex4 = getEraIndex(date61);
                            BytecodeManager.incBytecodes(1);
                            this.set(n189, eraIndex4);
                            final LocalGregorianCalendar.Date date62 = calendarDate22;
                            BytecodeManager.incBytecodes(3);
                            final int year11 = date62.getYear();
                            final LocalGregorianCalendar.Date date63 = calendarDate22;
                            BytecodeManager.incBytecodes(2);
                            final int n190 = date63.getMonth() - 1;
                            final LocalGregorianCalendar.Date date64 = calendarDate22;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth26 = date64.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(year11, n190, dayOfMonth26);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        case 8: {
                            n4 = 1;
                            BytecodeManager.incBytecodes(2);
                            final LocalGregorianCalendar.Date jdate24 = this.jdate;
                            BytecodeManager.incBytecodes(4);
                            final int normalizedYear9 = jdate24.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean transitionYear8 = this.isTransitionYear(normalizedYear9);
                            BytecodeManager.incBytecodes(1);
                            if (!transitionYear8) {
                                final int n191 = 5;
                                BytecodeManager.incBytecodes(3);
                                final int internalGet20 = this.internalGet(n191);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar jcal16 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date jdate25 = this.jdate;
                                BytecodeManager.incBytecodes(4);
                                final int monthLength2 = jcal16.getMonthLength(jdate25);
                                BytecodeManager.incBytecodes(1);
                                final int n192 = monthLength2 % 7;
                                BytecodeManager.incBytecodes(4);
                                n5 = monthLength2 / 7;
                                BytecodeManager.incBytecodes(4);
                                final int n193 = (internalGet20 - 1) % 7;
                                BytecodeManager.incBytecodes(6);
                                final int n194 = n193;
                                final int n195 = n192;
                                BytecodeManager.incBytecodes(3);
                                if (n194 < n195) {
                                    ++n5;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n196 = 7;
                                final int n197 = 7;
                                BytecodeManager.incBytecodes(5);
                                final int internalGet21 = this.internalGet(n197);
                                BytecodeManager.incBytecodes(1);
                                this.set(n196, internalGet21);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final long cachedFixedDate7 = this.cachedFixedDate;
                            BytecodeManager.incBytecodes(3);
                            final LocalGregorianCalendar.Date jdate26 = this.jdate;
                            final long n198 = cachedFixedDate7;
                            BytecodeManager.incBytecodes(5);
                            final long fixedDateMonth3 = this.getFixedDateMonth1(jdate26, n198);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            final int actualMonthLength = this.actualMonthLength();
                            BytecodeManager.incBytecodes(1);
                            final int n199 = actualMonthLength % 7;
                            BytecodeManager.incBytecodes(4);
                            int n200 = actualMonthLength / 7;
                            BytecodeManager.incBytecodes(4);
                            final int n201 = (int)(cachedFixedDate7 - fixedDateMonth3) % 7;
                            BytecodeManager.incBytecodes(7);
                            final int n202 = n201;
                            final int n203 = n199;
                            BytecodeManager.incBytecodes(3);
                            if (n202 < n203) {
                                ++n200;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(3);
                            final int internalGet22 = this.internalGet(n);
                            final int n204 = n2;
                            final int n205 = n4;
                            final int n206 = n200;
                            BytecodeManager.incBytecodes(4);
                            final int n207 = getRolledValue(internalGet22, n204, n205, n206) - 1;
                            BytecodeManager.incBytecodes(3);
                            final long n208 = fixedDateMonth3 + n207 * 7 + n201;
                            BytecodeManager.incBytecodes(10);
                            final long n209 = n208;
                            BytecodeManager.incBytecodes(2);
                            final LocalGregorianCalendar.Date calendarDate23 = getCalendarDate(n209);
                            BytecodeManager.incBytecodes(1);
                            final int n210 = 5;
                            final LocalGregorianCalendar.Date date65 = calendarDate23;
                            BytecodeManager.incBytecodes(4);
                            final int dayOfMonth27 = date65.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            this.set(n210, dayOfMonth27);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    BytecodeManager.incBytecodes(5);
                    final int internalGet23 = this.internalGet(n);
                    final int n211 = n2;
                    final int n212 = n4;
                    final int n213 = n5;
                    BytecodeManager.incBytecodes(4);
                    final int rolledValue6 = getRolledValue(internalGet23, n211, n212, n213);
                    BytecodeManager.incBytecodes(1);
                    this.set(n, rolledValue6);
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
    public String getDisplayName(final int n, final int n2, final Locale locale) {
        try {
            final int n3 = 1;
            final int n4 = 4;
            final int n5 = 647;
            BytecodeManager.incBytecodes(8);
            final boolean checkDisplayNameParams = this.checkDisplayNameParams(n, n2, n3, n4, locale, n5);
            BytecodeManager.incBytecodes(1);
            if (!checkDisplayNameParams) {
                final String s = null;
                BytecodeManager.incBytecodes(2);
                return s;
            }
            BytecodeManager.incBytecodes(3);
            final int value = this.get(n);
            BytecodeManager.incBytecodes(1);
            final int n6 = 1;
            BytecodeManager.incBytecodes(3);
            Label_0120: {
                if (n == n6) {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final int baseStyle = this.getBaseStyle(n2);
                    final int n7 = 2;
                    BytecodeManager.incBytecodes(2);
                    if (baseStyle == n7) {
                        final int n8 = value;
                        final int n9 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n8 == n9) {
                            final int n10 = 0;
                            BytecodeManager.incBytecodes(3);
                            final int value2 = this.get(n10);
                            BytecodeManager.incBytecodes(1);
                            if (value2 != 0) {
                                break Label_0120;
                            }
                        }
                    }
                    final String s2 = null;
                    BytecodeManager.incBytecodes(2);
                    return s2;
                }
            }
            BytecodeManager.incBytecodes(2);
            final String calendarType = this.getCalendarType();
            final int n11 = value;
            BytecodeManager.incBytecodes(5);
            String retrieveFieldValueName = CalendarDataUtility.retrieveFieldValueName(calendarType, n, n11, n2, locale);
            BytecodeManager.incBytecodes(1);
            final String s3 = retrieveFieldValueName;
            BytecodeManager.incBytecodes(2);
            if (s3 == null) {
                BytecodeManager.incBytecodes(2);
                if (n == 0) {
                    final int n12 = value;
                    final int length = JapaneseImperialCalendar.eras.length;
                    BytecodeManager.incBytecodes(4);
                    if (n12 < length) {
                        final Era era = JapaneseImperialCalendar.eras[value];
                        BytecodeManager.incBytecodes(4);
                        final int n13 = 1;
                        BytecodeManager.incBytecodes(3);
                        String s4;
                        if (n2 == n13) {
                            final Era era2 = era;
                            BytecodeManager.incBytecodes(2);
                            s4 = era2.getAbbreviation();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final Era era3 = era;
                            BytecodeManager.incBytecodes(2);
                            s4 = era3.getName();
                        }
                        retrieveFieldValueName = s4;
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final String s5 = retrieveFieldValueName;
            BytecodeManager.incBytecodes(2);
            return s5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map<String, Integer> getDisplayNames(final int n, final int n2, final Locale locale) {
        try {
            final int n3 = 0;
            final int n4 = 4;
            final int n5 = 647;
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
            BytecodeManager.incBytecodes(4);
            final Map retrieveFieldValueNames = CalendarDataUtility.retrieveFieldValueNames(calendarType, n, n2, locale);
            BytecodeManager.incBytecodes(1);
            final Map map2 = retrieveFieldValueNames;
            BytecodeManager.incBytecodes(2);
            if (map2 != null) {
                BytecodeManager.incBytecodes(2);
                if (n == 0) {
                    final Map map3 = retrieveFieldValueNames;
                    BytecodeManager.incBytecodes(2);
                    int n6 = map3.size();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    if (n2 == 0) {
                        BytecodeManager.incBytecodes(3);
                        final HashSet<Object> set = new HashSet<Object>();
                        BytecodeManager.incBytecodes(1);
                        final Map map4 = retrieveFieldValueNames;
                        BytecodeManager.incBytecodes(2);
                        final Set<String> keySet = map4.keySet();
                        BytecodeManager.incBytecodes(1);
                        final Iterator<String> iterator = keySet.iterator();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final Iterator<String> iterator2 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = iterator2.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                break;
                            }
                            final Iterator<String> iterator3 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final String s = iterator3.next();
                            BytecodeManager.incBytecodes(2);
                            final HashSet<Object> set2 = set;
                            final Map map5 = retrieveFieldValueNames;
                            final String s2 = s;
                            BytecodeManager.incBytecodes(4);
                            final Object value = map5.get(s2);
                            BytecodeManager.incBytecodes(1);
                            set2.add(value);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                        final HashSet<Object> set3 = set;
                        BytecodeManager.incBytecodes(2);
                        n6 = set3.size();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n7 = n6;
                    final int length = JapaneseImperialCalendar.eras.length;
                    BytecodeManager.incBytecodes(4);
                    if (n7 < length) {
                        BytecodeManager.incBytecodes(3);
                        final int baseStyle = this.getBaseStyle(n2);
                        BytecodeManager.incBytecodes(1);
                        int n8 = n6;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n9 = n8;
                            final int length2 = JapaneseImperialCalendar.eras.length;
                            BytecodeManager.incBytecodes(4);
                            if (n9 >= length2) {
                                break;
                            }
                            final Era era = JapaneseImperialCalendar.eras[n8];
                            BytecodeManager.incBytecodes(4);
                            final int n10 = baseStyle;
                            BytecodeManager.incBytecodes(2);
                            Label_0393: {
                                if (n10 != 0) {
                                    final int n11 = baseStyle;
                                    final int n12 = 1;
                                    BytecodeManager.incBytecodes(3);
                                    if (n11 != n12) {
                                        final int n13 = baseStyle;
                                        final int n14 = 4;
                                        BytecodeManager.incBytecodes(3);
                                        if (n13 != n14) {
                                            break Label_0393;
                                        }
                                    }
                                }
                                final Map map6 = retrieveFieldValueNames;
                                final Era era2 = era;
                                BytecodeManager.incBytecodes(3);
                                final String abbreviation = era2.getAbbreviation();
                                final int i = n8;
                                BytecodeManager.incBytecodes(2);
                                final Integer value2 = i;
                                BytecodeManager.incBytecodes(1);
                                map6.put(abbreviation, value2);
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n15 = baseStyle;
                            BytecodeManager.incBytecodes(2);
                            Label_0452: {
                                if (n15 != 0) {
                                    final int n16 = baseStyle;
                                    final int n17 = 2;
                                    BytecodeManager.incBytecodes(3);
                                    if (n16 != n17) {
                                        break Label_0452;
                                    }
                                }
                                final Map map7 = retrieveFieldValueNames;
                                final Era era3 = era;
                                BytecodeManager.incBytecodes(3);
                                final String name = era3.getName();
                                final int j = n8;
                                BytecodeManager.incBytecodes(2);
                                final Integer value3 = j;
                                BytecodeManager.incBytecodes(1);
                                map7.put(name, value3);
                                BytecodeManager.incBytecodes(1);
                            }
                            ++n8;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
            }
            final Map map8 = retrieveFieldValueNames;
            BytecodeManager.incBytecodes(2);
            return (Map<String, Integer>)map8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getMinimum(final int n) {
        try {
            final int n2 = JapaneseImperialCalendar.MIN_VALUES[n];
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
                case 1: {
                    final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
                    final long n2 = Long.MAX_VALUE;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final TimeZone zone = this.getZone();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date calendarDate = jcal.getCalendarDate(n2, zone);
                    BytecodeManager.incBytecodes(1);
                    final int a = JapaneseImperialCalendar.LEAST_MAX_VALUES[1];
                    final LocalGregorianCalendar.Date date = calendarDate;
                    BytecodeManager.incBytecodes(5);
                    final int year = date.getYear();
                    BytecodeManager.incBytecodes(1);
                    final int max = Math.max(a, year);
                    BytecodeManager.incBytecodes(1);
                    return max;
                }
                default: {
                    final int n3 = JapaneseImperialCalendar.MAX_VALUES[n];
                    BytecodeManager.incBytecodes(4);
                    return n3;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getGreatestMinimum(final int n) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            int n3;
            if (n == n2) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = JapaneseImperialCalendar.MIN_VALUES[n];
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
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
                case 1: {
                    final int a = JapaneseImperialCalendar.LEAST_MAX_VALUES[1];
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(6);
                    final int maximum = this.getMaximum(n2);
                    BytecodeManager.incBytecodes(1);
                    final int min = Math.min(a, maximum);
                    BytecodeManager.incBytecodes(1);
                    return min;
                }
                default: {
                    final int n3 = JapaneseImperialCalendar.LEAST_MAX_VALUES[n];
                    BytecodeManager.incBytecodes(4);
                    return n3;
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
            final int n2 = 14;
            BytecodeManager.incBytecodes(3);
            final boolean fieldSet = Calendar.isFieldSet(n2, n);
            BytecodeManager.incBytecodes(1);
            if (!fieldSet) {
                BytecodeManager.incBytecodes(3);
                final int minimum = this.getMinimum(n);
                BytecodeManager.incBytecodes(1);
                return minimum;
            }
            int minimum2 = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final JapaneseImperialCalendar normalizedCalendar = this.getNormalizedCalendar();
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
            final JapaneseImperialCalendar japaneseImperialCalendar = normalizedCalendar;
            BytecodeManager.incBytecodes(3);
            final long timeInMillis = japaneseImperialCalendar.getTimeInMillis();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final TimeZone zone = this.getZone();
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar.Date calendarDate = jcal.getCalendarDate(timeInMillis, zone);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar.Date date = calendarDate;
            BytecodeManager.incBytecodes(2);
            final int eraIndex = getEraIndex(date);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 1: {
                    final int n3 = eraIndex;
                    BytecodeManager.incBytecodes(2);
                    if (n3 > 0) {
                        minimum2 = 1;
                        BytecodeManager.incBytecodes(2);
                        final Era era = JapaneseImperialCalendar.eras[eraIndex];
                        BytecodeManager.incBytecodes(5);
                        final TimeZone zone2 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final long since = era.getSince(zone2);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
                        final long n4 = since;
                        BytecodeManager.incBytecodes(4);
                        final TimeZone zone3 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date calendarDate2 = jcal2.getCalendarDate(n4, zone3);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date2 = calendarDate;
                        final LocalGregorianCalendar.Date date3 = calendarDate2;
                        BytecodeManager.incBytecodes(3);
                        final int year = date3.getYear();
                        BytecodeManager.incBytecodes(1);
                        date2.setYear(year);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar jcal3 = JapaneseImperialCalendar.jcal;
                        final LocalGregorianCalendar.Date date4 = calendarDate;
                        BytecodeManager.incBytecodes(3);
                        jcal3.normalize(date4);
                        BytecodeManager.incBytecodes(1);
                        final boolean $assertionsDisabled = JapaneseImperialCalendar.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            final LocalGregorianCalendar.Date date5 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            final boolean leapYear = date5.isLeapYear();
                            final LocalGregorianCalendar.Date date6 = calendarDate2;
                            BytecodeManager.incBytecodes(2);
                            final boolean leapYear2 = date6.isLeapYear();
                            BytecodeManager.incBytecodes(1);
                            if (leapYear != leapYear2) {
                                BytecodeManager.incBytecodes(3);
                                final AssertionError assertionError = new AssertionError();
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                        final LocalGregorianCalendar.Date date7 = calendarDate;
                        BytecodeManager.incBytecodes(3);
                        final long yearOffsetInMillis = this.getYearOffsetInMillis(date7);
                        final LocalGregorianCalendar.Date date8 = calendarDate2;
                        BytecodeManager.incBytecodes(3);
                        final long n5 = lcmp(yearOffsetInMillis, this.getYearOffsetInMillis(date8));
                        BytecodeManager.incBytecodes(2);
                        if (n5 < 0) {
                            ++minimum2;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(3);
                    minimum2 = this.getMinimum(n);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar jcal4 = JapaneseImperialCalendar.jcal;
                    final long n6 = Long.MIN_VALUE;
                    BytecodeManager.incBytecodes(4);
                    final TimeZone zone4 = this.getZone();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date calendarDate3 = jcal4.getCalendarDate(n6, zone4);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date9 = calendarDate3;
                    BytecodeManager.incBytecodes(2);
                    int year2 = date9.getYear();
                    BytecodeManager.incBytecodes(1);
                    final int n7 = year2;
                    final int n8 = 400;
                    BytecodeManager.incBytecodes(3);
                    if (n7 > n8) {
                        year2 -= 400;
                        BytecodeManager.incBytecodes(1);
                    }
                    final LocalGregorianCalendar.Date date10 = calendarDate;
                    final int year3 = year2;
                    BytecodeManager.incBytecodes(3);
                    date10.setYear(year3);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar jcal5 = JapaneseImperialCalendar.jcal;
                    final LocalGregorianCalendar.Date date11 = calendarDate;
                    BytecodeManager.incBytecodes(3);
                    jcal5.normalize(date11);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date12 = calendarDate;
                    BytecodeManager.incBytecodes(3);
                    final long yearOffsetInMillis2 = this.getYearOffsetInMillis(date12);
                    final LocalGregorianCalendar.Date date13 = calendarDate3;
                    BytecodeManager.incBytecodes(3);
                    final long n9 = lcmp(yearOffsetInMillis2, this.getYearOffsetInMillis(date13));
                    BytecodeManager.incBytecodes(2);
                    if (n9 < 0) {
                        ++minimum2;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 2: {
                    final int n10 = eraIndex;
                    final int n11 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n10 <= n11) {
                        break;
                    }
                    final LocalGregorianCalendar.Date date14 = calendarDate;
                    BytecodeManager.incBytecodes(2);
                    final int year4 = date14.getYear();
                    final int n12 = 1;
                    BytecodeManager.incBytecodes(2);
                    if (year4 == n12) {
                        final Era era2 = JapaneseImperialCalendar.eras[eraIndex];
                        BytecodeManager.incBytecodes(5);
                        final TimeZone zone5 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final long since2 = era2.getSince(zone5);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar jcal6 = JapaneseImperialCalendar.jcal;
                        final long n13 = since2;
                        BytecodeManager.incBytecodes(4);
                        final TimeZone zone6 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date calendarDate4 = jcal6.getCalendarDate(n13, zone6);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date15 = calendarDate4;
                        BytecodeManager.incBytecodes(2);
                        minimum2 = date15.getMonth() - 1;
                        BytecodeManager.incBytecodes(3);
                        final LocalGregorianCalendar.Date date16 = calendarDate;
                        BytecodeManager.incBytecodes(2);
                        final int dayOfMonth = date16.getDayOfMonth();
                        final LocalGregorianCalendar.Date date17 = calendarDate4;
                        BytecodeManager.incBytecodes(2);
                        final int dayOfMonth2 = date17.getDayOfMonth();
                        BytecodeManager.incBytecodes(1);
                        if (dayOfMonth < dayOfMonth2) {
                            ++minimum2;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    break;
                }
                case 3: {
                    minimum2 = 1;
                    BytecodeManager.incBytecodes(2);
                    final LocalGregorianCalendar jcal7 = JapaneseImperialCalendar.jcal;
                    final long n14 = Long.MIN_VALUE;
                    BytecodeManager.incBytecodes(4);
                    final TimeZone zone7 = this.getZone();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date calendarDate5 = jcal7.getCalendarDate(n14, zone7);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date18 = calendarDate5;
                    final int n15 = 400;
                    BytecodeManager.incBytecodes(3);
                    date18.addYear(n15);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar jcal8 = JapaneseImperialCalendar.jcal;
                    final LocalGregorianCalendar.Date date19 = calendarDate5;
                    BytecodeManager.incBytecodes(3);
                    jcal8.normalize(date19);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date20 = calendarDate;
                    final LocalGregorianCalendar.Date date21 = calendarDate5;
                    BytecodeManager.incBytecodes(3);
                    final Era era3 = date21.getEra();
                    BytecodeManager.incBytecodes(1);
                    date20.setEra(era3);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date22 = calendarDate;
                    final LocalGregorianCalendar.Date date23 = calendarDate5;
                    BytecodeManager.incBytecodes(3);
                    final int year5 = date23.getYear();
                    BytecodeManager.incBytecodes(1);
                    date22.setYear(year5);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar jcal9 = JapaneseImperialCalendar.jcal;
                    final LocalGregorianCalendar.Date date24 = calendarDate;
                    BytecodeManager.incBytecodes(3);
                    jcal9.normalize(date24);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar jcal10 = JapaneseImperialCalendar.jcal;
                    final LocalGregorianCalendar.Date date25 = calendarDate5;
                    BytecodeManager.incBytecodes(3);
                    final long fixedDate = jcal10.getFixedDate(date25);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar jcal11 = JapaneseImperialCalendar.jcal;
                    final LocalGregorianCalendar.Date date26 = calendarDate;
                    BytecodeManager.incBytecodes(3);
                    final long fixedDate2 = jcal11.getFixedDate(date26);
                    BytecodeManager.incBytecodes(1);
                    final long n16 = fixedDate;
                    final long n17 = fixedDate2;
                    BytecodeManager.incBytecodes(4);
                    final int weekNumber = this.getWeekNumber(n16, n17);
                    BytecodeManager.incBytecodes(1);
                    final long n18 = fixedDate2 - 7 * (weekNumber - 1);
                    BytecodeManager.incBytecodes(9);
                    final long n19 = lcmp(n18, fixedDate);
                    BytecodeManager.incBytecodes(4);
                    if (n19 >= 0) {
                        final long n20 = lcmp(n18, fixedDate);
                        BytecodeManager.incBytecodes(4);
                        if (n20 != 0) {
                            break;
                        }
                        final LocalGregorianCalendar.Date date27 = calendarDate;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final long timeOfDay = date27.getTimeOfDay();
                        final LocalGregorianCalendar.Date date28 = calendarDate5;
                        BytecodeManager.incBytecodes(2);
                        final long n21 = lcmp(timeOfDay, date28.getTimeOfDay());
                        BytecodeManager.incBytecodes(2);
                        if (n21 >= 0) {
                            break;
                        }
                    }
                    ++minimum2;
                    BytecodeManager.incBytecodes(1);
                    break;
                }
            }
            final int n22 = minimum2;
            BytecodeManager.incBytecodes(2);
            return n22;
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
            JapaneseImperialCalendar normalizedCalendar = this.getNormalizedCalendar();
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar.Date jdate = normalizedCalendar.jdate;
            BytecodeManager.incBytecodes(3);
            final LocalGregorianCalendar.Date date = jdate;
            BytecodeManager.incBytecodes(2);
            date.getNormalizedYear();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            switch (index) {
                case 2: {
                    n2 = 11;
                    BytecodeManager.incBytecodes(2);
                    final LocalGregorianCalendar.Date date2 = jdate;
                    BytecodeManager.incBytecodes(3);
                    final int normalizedYear = date2.getNormalizedYear();
                    BytecodeManager.incBytecodes(1);
                    final boolean transitionYear = this.isTransitionYear(normalizedYear);
                    BytecodeManager.incBytecodes(1);
                    if (transitionYear) {
                        final LocalGregorianCalendar.Date date3 = jdate;
                        BytecodeManager.incBytecodes(2);
                        int eraIndex = getEraIndex(date3);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date4 = jdate;
                        BytecodeManager.incBytecodes(2);
                        final int year = date4.getYear();
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(2);
                        if (year != n3) {
                            ++eraIndex;
                            BytecodeManager.incBytecodes(1);
                            final boolean $assertionsDisabled = JapaneseImperialCalendar.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled) {
                                final int n4 = eraIndex;
                                final int length = JapaneseImperialCalendar.eras.length;
                                BytecodeManager.incBytecodes(4);
                                if (n4 >= length) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError;
                                }
                            }
                        }
                        final long n5 = JapaneseImperialCalendar.sinceFixedDates[eraIndex];
                        BytecodeManager.incBytecodes(4);
                        final long cachedFixedDate = normalizedCalendar.cachedFixedDate;
                        BytecodeManager.incBytecodes(3);
                        final long n6 = lcmp(cachedFixedDate, n5);
                        BytecodeManager.incBytecodes(4);
                        if (n6 < 0) {
                            final LocalGregorianCalendar.Date date5 = jdate;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date6 = (LocalGregorianCalendar.Date)date5.clone();
                            BytecodeManager.incBytecodes(2);
                            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date7 = date6;
                            final long fixedDate = n5 - 1L;
                            BytecodeManager.incBytecodes(6);
                            jcal.getCalendarDateFromFixedDate(date7, fixedDate);
                            final LocalGregorianCalendar.Date date8 = date6;
                            BytecodeManager.incBytecodes(2);
                            n2 = date8.getMonth() - 1;
                            BytecodeManager.incBytecodes(3);
                        }
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
                    final long n7 = Long.MAX_VALUE;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final TimeZone zone = this.getZone();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date calendarDate = jcal2.getCalendarDate(n7, zone);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date9 = jdate;
                    BytecodeManager.incBytecodes(2);
                    final Era era = date9.getEra();
                    final LocalGregorianCalendar.Date date10 = calendarDate;
                    BytecodeManager.incBytecodes(2);
                    final Era era2 = date10.getEra();
                    BytecodeManager.incBytecodes(1);
                    if (era == era2) {
                        final LocalGregorianCalendar.Date date11 = jdate;
                        BytecodeManager.incBytecodes(2);
                        final int year2 = date11.getYear();
                        final LocalGregorianCalendar.Date date12 = calendarDate;
                        BytecodeManager.incBytecodes(2);
                        final int year3 = date12.getYear();
                        BytecodeManager.incBytecodes(1);
                        if (year2 == year3) {
                            final LocalGregorianCalendar.Date date13 = calendarDate;
                            BytecodeManager.incBytecodes(2);
                            n2 = date13.getMonth() - 1;
                            BytecodeManager.incBytecodes(3);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 5: {
                    final LocalGregorianCalendar jcal3 = JapaneseImperialCalendar.jcal;
                    final LocalGregorianCalendar.Date date14 = jdate;
                    BytecodeManager.incBytecodes(3);
                    n2 = jcal3.getMonthLength(date14);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 6: {
                    final LocalGregorianCalendar.Date date15 = jdate;
                    BytecodeManager.incBytecodes(3);
                    final int normalizedYear2 = date15.getNormalizedYear();
                    BytecodeManager.incBytecodes(1);
                    final boolean transitionYear2 = this.isTransitionYear(normalizedYear2);
                    BytecodeManager.incBytecodes(1);
                    if (transitionYear2) {
                        final LocalGregorianCalendar.Date date16 = jdate;
                        BytecodeManager.incBytecodes(2);
                        int eraIndex2 = getEraIndex(date16);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date17 = jdate;
                        BytecodeManager.incBytecodes(2);
                        final int year4 = date17.getYear();
                        final int n8 = 1;
                        BytecodeManager.incBytecodes(2);
                        if (year4 != n8) {
                            ++eraIndex2;
                            BytecodeManager.incBytecodes(1);
                            final boolean $assertionsDisabled2 = JapaneseImperialCalendar.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled2) {
                                final int n9 = eraIndex2;
                                final int length2 = JapaneseImperialCalendar.eras.length;
                                BytecodeManager.incBytecodes(4);
                                if (n9 >= length2) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError2 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError2;
                                }
                            }
                        }
                        final long n10 = JapaneseImperialCalendar.sinceFixedDates[eraIndex2];
                        BytecodeManager.incBytecodes(4);
                        final long cachedFixedDate2 = normalizedCalendar.cachedFixedDate;
                        BytecodeManager.incBytecodes(3);
                        final Gregorian gcal = JapaneseImperialCalendar.gcal;
                        final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
                        BytecodeManager.incBytecodes(3);
                        final Gregorian.Date calendarDate2 = gcal.newCalendarDate(no_TIMEZONE);
                        BytecodeManager.incBytecodes(1);
                        final Gregorian.Date date18 = calendarDate2;
                        final LocalGregorianCalendar.Date date19 = jdate;
                        BytecodeManager.incBytecodes(3);
                        final int normalizedYear3 = date19.getNormalizedYear();
                        final int month = 1;
                        final int dayOfMonth = 1;
                        BytecodeManager.incBytecodes(3);
                        date18.setDate(normalizedYear3, month, dayOfMonth);
                        BytecodeManager.incBytecodes(1);
                        final long n11 = lcmp(cachedFixedDate2, n10);
                        BytecodeManager.incBytecodes(4);
                        if (n11 < 0) {
                            final long n12 = n10;
                            final Gregorian gcal2 = JapaneseImperialCalendar.gcal;
                            final Gregorian.Date date20 = calendarDate2;
                            BytecodeManager.incBytecodes(4);
                            n2 = (int)(n12 - gcal2.getFixedDate(date20));
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            final Gregorian.Date date21 = calendarDate2;
                            final int n13 = 1;
                            BytecodeManager.incBytecodes(3);
                            date21.addYear(n13);
                            BytecodeManager.incBytecodes(1);
                            final Gregorian gcal3 = JapaneseImperialCalendar.gcal;
                            final Gregorian.Date date22 = calendarDate2;
                            BytecodeManager.incBytecodes(3);
                            n2 = (int)(gcal3.getFixedDate(date22) - n10);
                            BytecodeManager.incBytecodes(4);
                        }
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final LocalGregorianCalendar jcal4 = JapaneseImperialCalendar.jcal;
                    final long n14 = Long.MAX_VALUE;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final TimeZone zone2 = this.getZone();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date calendarDate3 = jcal4.getCalendarDate(n14, zone2);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date23 = jdate;
                    BytecodeManager.incBytecodes(2);
                    final Era era3 = date23.getEra();
                    final LocalGregorianCalendar.Date date24 = calendarDate3;
                    BytecodeManager.incBytecodes(2);
                    final Era era4 = date24.getEra();
                    BytecodeManager.incBytecodes(1);
                    Label_1142: {
                        if (era3 == era4) {
                            final LocalGregorianCalendar.Date date25 = jdate;
                            BytecodeManager.incBytecodes(2);
                            final int year5 = date25.getYear();
                            final LocalGregorianCalendar.Date date26 = calendarDate3;
                            BytecodeManager.incBytecodes(2);
                            final int year6 = date26.getYear();
                            BytecodeManager.incBytecodes(1);
                            if (year5 == year6) {
                                final LocalGregorianCalendar jcal5 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date27 = calendarDate3;
                                BytecodeManager.incBytecodes(3);
                                final long fixedDate2 = jcal5.getFixedDate(date27);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date date28 = calendarDate3;
                                final long n15 = fixedDate2;
                                BytecodeManager.incBytecodes(4);
                                final long fixedDateJan1 = this.getFixedDateJan1(date28, n15);
                                BytecodeManager.incBytecodes(1);
                                n2 = (int)(fixedDate2 - fixedDateJan1) + 1;
                                BytecodeManager.incBytecodes(7);
                                BytecodeManager.incBytecodes(1);
                                break Label_1142;
                            }
                        }
                        final LocalGregorianCalendar.Date date29 = jdate;
                        BytecodeManager.incBytecodes(2);
                        final int year7 = date29.getYear();
                        final int n16 = 1;
                        BytecodeManager.incBytecodes(3);
                        final int minimum = this.getMinimum(n16);
                        BytecodeManager.incBytecodes(1);
                        if (year7 == minimum) {
                            final LocalGregorianCalendar jcal6 = JapaneseImperialCalendar.jcal;
                            final long n17 = Long.MIN_VALUE;
                            BytecodeManager.incBytecodes(4);
                            final TimeZone zone3 = this.getZone();
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date calendarDate4 = jcal6.getCalendarDate(n17, zone3);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal7 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date30 = calendarDate4;
                            BytecodeManager.incBytecodes(3);
                            final long fixedDate3 = jcal7.getFixedDate(date30);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date31 = calendarDate4;
                            final int n18 = 1;
                            BytecodeManager.incBytecodes(3);
                            date31.addYear(n18);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date32 = calendarDate4;
                            final int month2 = 1;
                            BytecodeManager.incBytecodes(3);
                            final CalendarDate setMonth = date32.setMonth(month2);
                            final int dayOfMonth2 = 1;
                            BytecodeManager.incBytecodes(2);
                            setMonth.setDayOfMonth(dayOfMonth2);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal8 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date33 = calendarDate4;
                            BytecodeManager.incBytecodes(3);
                            jcal8.normalize(date33);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal9 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date34 = calendarDate4;
                            BytecodeManager.incBytecodes(3);
                            final long fixedDate4 = jcal9.getFixedDate(date34);
                            BytecodeManager.incBytecodes(1);
                            n2 = (int)(fixedDate4 - fixedDate3);
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final LocalGregorianCalendar jcal10 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date35 = jdate;
                            BytecodeManager.incBytecodes(3);
                            n2 = jcal10.getYearLength(date35);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 3: {
                    final LocalGregorianCalendar.Date date36 = jdate;
                    BytecodeManager.incBytecodes(3);
                    final int normalizedYear4 = date36.getNormalizedYear();
                    BytecodeManager.incBytecodes(1);
                    final boolean transitionYear3 = this.isTransitionYear(normalizedYear4);
                    BytecodeManager.incBytecodes(1);
                    if (!transitionYear3) {
                        final LocalGregorianCalendar jcal11 = JapaneseImperialCalendar.jcal;
                        final long n19 = Long.MAX_VALUE;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final TimeZone zone4 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date calendarDate5 = jcal11.getCalendarDate(n19, zone4);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date37 = jdate;
                        BytecodeManager.incBytecodes(2);
                        final Era era5 = date37.getEra();
                        final LocalGregorianCalendar.Date date38 = calendarDate5;
                        BytecodeManager.incBytecodes(2);
                        final Era era6 = date38.getEra();
                        BytecodeManager.incBytecodes(1);
                        if (era5 == era6) {
                            final LocalGregorianCalendar.Date date39 = jdate;
                            BytecodeManager.incBytecodes(2);
                            final int year8 = date39.getYear();
                            final LocalGregorianCalendar.Date date40 = calendarDate5;
                            BytecodeManager.incBytecodes(2);
                            final int year9 = date40.getYear();
                            BytecodeManager.incBytecodes(1);
                            if (year8 == year9) {
                                final LocalGregorianCalendar jcal12 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date41 = calendarDate5;
                                BytecodeManager.incBytecodes(3);
                                final long fixedDate5 = jcal12.getFixedDate(date41);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date date42 = calendarDate5;
                                final long n20 = fixedDate5;
                                BytecodeManager.incBytecodes(4);
                                final long fixedDateJan2 = this.getFixedDateJan1(date42, n20);
                                BytecodeManager.incBytecodes(1);
                                final long n21 = fixedDateJan2;
                                final long n22 = fixedDate5;
                                BytecodeManager.incBytecodes(4);
                                n2 = this.getWeekNumber(n21, n22);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        final LocalGregorianCalendar.Date date43 = jdate;
                        BytecodeManager.incBytecodes(2);
                        final Era era7 = date43.getEra();
                        BytecodeManager.incBytecodes(1);
                        if (era7 == null) {
                            final LocalGregorianCalendar.Date date44 = jdate;
                            BytecodeManager.incBytecodes(2);
                            final int year10 = date44.getYear();
                            final int n23 = 1;
                            BytecodeManager.incBytecodes(3);
                            final int minimum2 = this.getMinimum(n23);
                            BytecodeManager.incBytecodes(1);
                            if (year10 == minimum2) {
                                final LocalGregorianCalendar jcal13 = JapaneseImperialCalendar.jcal;
                                final long n24 = Long.MIN_VALUE;
                                BytecodeManager.incBytecodes(4);
                                final TimeZone zone5 = this.getZone();
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date calendarDate6 = jcal13.getCalendarDate(n24, zone5);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date date45 = calendarDate6;
                                final int n25 = 400;
                                BytecodeManager.incBytecodes(3);
                                date45.addYear(n25);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar jcal14 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date46 = calendarDate6;
                                BytecodeManager.incBytecodes(3);
                                jcal14.normalize(date46);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date date47 = calendarDate5;
                                final LocalGregorianCalendar.Date date48 = calendarDate6;
                                BytecodeManager.incBytecodes(3);
                                final Era era8 = date48.getEra();
                                BytecodeManager.incBytecodes(1);
                                date47.setEra(era8);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar.Date date49 = calendarDate5;
                                final LocalGregorianCalendar.Date date50 = calendarDate6;
                                BytecodeManager.incBytecodes(3);
                                final int year11 = date50.getYear() + 1;
                                final int month3 = 1;
                                final int dayOfMonth3 = 1;
                                BytecodeManager.incBytecodes(5);
                                date49.setDate(year11, month3, dayOfMonth3);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar jcal15 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date51 = calendarDate5;
                                BytecodeManager.incBytecodes(3);
                                jcal15.normalize(date51);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar jcal16 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date52 = calendarDate6;
                                BytecodeManager.incBytecodes(3);
                                final long fixedDate6 = jcal16.getFixedDate(date52);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar jcal17 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date53 = calendarDate5;
                                BytecodeManager.incBytecodes(3);
                                final long fixedDate7 = jcal17.getFixedDate(date53);
                                BytecodeManager.incBytecodes(1);
                                final long fixedDate8 = fixedDate7 + 6L;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final int firstDayOfWeek = this.getFirstDayOfWeek();
                                BytecodeManager.incBytecodes(1);
                                long dayOfWeekDateOnOrBefore = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate8, firstDayOfWeek);
                                BytecodeManager.incBytecodes(1);
                                final int n26 = (int)(dayOfWeekDateOnOrBefore - fixedDate7);
                                BytecodeManager.incBytecodes(5);
                                final int n27 = n26;
                                BytecodeManager.incBytecodes(3);
                                final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
                                BytecodeManager.incBytecodes(1);
                                if (n27 >= minimalDaysInFirstWeek) {
                                    dayOfWeekDateOnOrBefore -= 7L;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final long n28 = fixedDate6;
                                final long n29 = dayOfWeekDateOnOrBefore;
                                BytecodeManager.incBytecodes(4);
                                n2 = this.getWeekNumber(n28, n29);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        final Gregorian gcal4 = JapaneseImperialCalendar.gcal;
                        final TimeZone no_TIMEZONE2 = TimeZone.NO_TIMEZONE;
                        BytecodeManager.incBytecodes(3);
                        final Gregorian.Date calendarDate7 = gcal4.newCalendarDate(no_TIMEZONE2);
                        BytecodeManager.incBytecodes(1);
                        final Gregorian.Date date54 = calendarDate7;
                        final LocalGregorianCalendar.Date date55 = jdate;
                        BytecodeManager.incBytecodes(3);
                        final int normalizedYear5 = date55.getNormalizedYear();
                        final int month4 = 1;
                        final int dayOfMonth4 = 1;
                        BytecodeManager.incBytecodes(3);
                        date54.setDate(normalizedYear5, month4, dayOfMonth4);
                        BytecodeManager.incBytecodes(1);
                        final Gregorian gcal5 = JapaneseImperialCalendar.gcal;
                        final Gregorian.Date date56 = calendarDate7;
                        BytecodeManager.incBytecodes(3);
                        final int dayOfWeek = gcal5.getDayOfWeek(date56);
                        BytecodeManager.incBytecodes(1);
                        final int n30 = dayOfWeek;
                        BytecodeManager.incBytecodes(3);
                        int n31 = n30 - this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(2);
                        final int n32 = n31;
                        BytecodeManager.incBytecodes(2);
                        if (n32 < 0) {
                            n31 += 7;
                            BytecodeManager.incBytecodes(1);
                        }
                        n2 = 52;
                        BytecodeManager.incBytecodes(2);
                        final int n33 = n31;
                        BytecodeManager.incBytecodes(3);
                        final int n34 = n33 + this.getMinimalDaysInFirstWeek() - 1;
                        BytecodeManager.incBytecodes(4);
                        final int n35 = n34;
                        final int n36 = 6;
                        BytecodeManager.incBytecodes(3);
                        Label_1875: {
                            if (n35 != n36) {
                                final LocalGregorianCalendar.Date date57 = jdate;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final boolean leapYear = date57.isLeapYear();
                                BytecodeManager.incBytecodes(1);
                                if (!leapYear) {
                                    break Label_1875;
                                }
                                final int n37 = n34;
                                final int n38 = 5;
                                BytecodeManager.incBytecodes(3);
                                if (n37 != n38) {
                                    final int n39 = n34;
                                    final int n40 = 12;
                                    BytecodeManager.incBytecodes(3);
                                    if (n39 != n40) {
                                        break Label_1875;
                                    }
                                }
                            }
                            ++n2;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final JapaneseImperialCalendar japaneseImperialCalendar = normalizedCalendar;
                    BytecodeManager.incBytecodes(3);
                    if (japaneseImperialCalendar == this) {
                        final JapaneseImperialCalendar japaneseImperialCalendar2 = normalizedCalendar;
                        BytecodeManager.incBytecodes(2);
                        normalizedCalendar = (JapaneseImperialCalendar)japaneseImperialCalendar2.clone();
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n41 = 6;
                    BytecodeManager.incBytecodes(3);
                    final int actualMaximum = this.getActualMaximum(n41);
                    BytecodeManager.incBytecodes(1);
                    final JapaneseImperialCalendar japaneseImperialCalendar3 = normalizedCalendar;
                    final int n42 = 6;
                    final int n43 = actualMaximum;
                    BytecodeManager.incBytecodes(4);
                    japaneseImperialCalendar3.set(n42, n43);
                    final JapaneseImperialCalendar japaneseImperialCalendar4 = normalizedCalendar;
                    final int n44 = 3;
                    BytecodeManager.incBytecodes(3);
                    n2 = japaneseImperialCalendar4.get(n44);
                    BytecodeManager.incBytecodes(1);
                    final int n45 = n2;
                    final int n46 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n45 == n46) {
                        final int n47 = actualMaximum;
                        final int n48 = 7;
                        BytecodeManager.incBytecodes(3);
                        if (n47 > n48) {
                            final JapaneseImperialCalendar japaneseImperialCalendar5 = normalizedCalendar;
                            final int n49 = 3;
                            final int n50 = -1;
                            BytecodeManager.incBytecodes(4);
                            japaneseImperialCalendar5.add(n49, n50);
                            final JapaneseImperialCalendar japaneseImperialCalendar6 = normalizedCalendar;
                            final int n51 = 3;
                            BytecodeManager.incBytecodes(3);
                            n2 = japaneseImperialCalendar6.get(n51);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 4: {
                    final LocalGregorianCalendar jcal18 = JapaneseImperialCalendar.jcal;
                    final long n52 = Long.MAX_VALUE;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final TimeZone zone6 = this.getZone();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date calendarDate8 = jcal18.getCalendarDate(n52, zone6);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date58 = jdate;
                    BytecodeManager.incBytecodes(2);
                    final Era era9 = date58.getEra();
                    final LocalGregorianCalendar.Date date59 = calendarDate8;
                    BytecodeManager.incBytecodes(2);
                    final Era era10 = date59.getEra();
                    BytecodeManager.incBytecodes(1);
                    Label_2415: {
                        if (era9 == era10) {
                            final LocalGregorianCalendar.Date date60 = jdate;
                            BytecodeManager.incBytecodes(2);
                            final int year12 = date60.getYear();
                            final LocalGregorianCalendar.Date date61 = calendarDate8;
                            BytecodeManager.incBytecodes(2);
                            final int year13 = date61.getYear();
                            BytecodeManager.incBytecodes(1);
                            if (year12 == year13) {
                                final LocalGregorianCalendar jcal19 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date62 = calendarDate8;
                                BytecodeManager.incBytecodes(3);
                                final long fixedDate9 = jcal19.getFixedDate(date62);
                                BytecodeManager.incBytecodes(1);
                                final long n53 = fixedDate9;
                                final LocalGregorianCalendar.Date date63 = calendarDate8;
                                BytecodeManager.incBytecodes(3);
                                final long n54 = n53 - date63.getDayOfMonth() + 1L;
                                BytecodeManager.incBytecodes(5);
                                final long n55 = n54;
                                final long n56 = fixedDate9;
                                BytecodeManager.incBytecodes(4);
                                n2 = this.getWeekNumber(n55, n56);
                                BytecodeManager.incBytecodes(1);
                                break Label_2415;
                            }
                        }
                        final Gregorian gcal6 = JapaneseImperialCalendar.gcal;
                        final TimeZone no_TIMEZONE3 = TimeZone.NO_TIMEZONE;
                        BytecodeManager.incBytecodes(3);
                        final Gregorian.Date calendarDate9 = gcal6.newCalendarDate(no_TIMEZONE3);
                        BytecodeManager.incBytecodes(1);
                        final Gregorian.Date date64 = calendarDate9;
                        final LocalGregorianCalendar.Date date65 = jdate;
                        BytecodeManager.incBytecodes(3);
                        final int normalizedYear6 = date65.getNormalizedYear();
                        final LocalGregorianCalendar.Date date66 = jdate;
                        BytecodeManager.incBytecodes(2);
                        final int month5 = date66.getMonth();
                        final int dayOfMonth5 = 1;
                        BytecodeManager.incBytecodes(2);
                        date64.setDate(normalizedYear6, month5, dayOfMonth5);
                        BytecodeManager.incBytecodes(1);
                        final Gregorian gcal7 = JapaneseImperialCalendar.gcal;
                        final Gregorian.Date date67 = calendarDate9;
                        BytecodeManager.incBytecodes(3);
                        final int dayOfWeek2 = gcal7.getDayOfWeek(date67);
                        BytecodeManager.incBytecodes(1);
                        final Gregorian gcal8 = JapaneseImperialCalendar.gcal;
                        final Gregorian.Date date68 = calendarDate9;
                        BytecodeManager.incBytecodes(3);
                        final int monthLength = gcal8.getMonthLength(date68);
                        BytecodeManager.incBytecodes(1);
                        final int n57 = dayOfWeek2;
                        BytecodeManager.incBytecodes(3);
                        int n58 = n57 - this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(2);
                        final int n59 = n58;
                        BytecodeManager.incBytecodes(2);
                        if (n59 < 0) {
                            n58 += 7;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n60 = 7 - n58;
                        BytecodeManager.incBytecodes(4);
                        n2 = 3;
                        BytecodeManager.incBytecodes(2);
                        final int n61 = n60;
                        BytecodeManager.incBytecodes(3);
                        final int minimalDaysInFirstWeek2 = this.getMinimalDaysInFirstWeek();
                        BytecodeManager.incBytecodes(1);
                        if (n61 >= minimalDaysInFirstWeek2) {
                            ++n2;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n62 = monthLength - (n60 + 21);
                        BytecodeManager.incBytecodes(6);
                        final int n63 = n62;
                        BytecodeManager.incBytecodes(2);
                        if (n63 > 0) {
                            ++n2;
                            BytecodeManager.incBytecodes(1);
                            final int n64 = n62;
                            final int n65 = 7;
                            BytecodeManager.incBytecodes(3);
                            if (n64 > n65) {
                                ++n2;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 8: {
                    final LocalGregorianCalendar.Date date69 = jdate;
                    BytecodeManager.incBytecodes(2);
                    final int dayOfWeek3 = date69.getDayOfWeek();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date70 = jdate;
                    BytecodeManager.incBytecodes(2);
                    final BaseCalendar.Date date71 = (BaseCalendar.Date)date70.clone();
                    BytecodeManager.incBytecodes(2);
                    final LocalGregorianCalendar jcal20 = JapaneseImperialCalendar.jcal;
                    final BaseCalendar.Date date72 = date71;
                    BytecodeManager.incBytecodes(3);
                    final int monthLength2 = jcal20.getMonthLength(date72);
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar.Date date73 = date71;
                    final int dayOfMonth6 = 1;
                    BytecodeManager.incBytecodes(3);
                    date73.setDayOfMonth(dayOfMonth6);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar jcal21 = JapaneseImperialCalendar.jcal;
                    final BaseCalendar.Date date74 = date71;
                    BytecodeManager.incBytecodes(3);
                    jcal21.normalize(date74);
                    BytecodeManager.incBytecodes(1);
                    final BaseCalendar.Date date75 = date71;
                    BytecodeManager.incBytecodes(2);
                    final int dayOfWeek4 = date75.getDayOfWeek();
                    BytecodeManager.incBytecodes(1);
                    int n66 = dayOfWeek3 - dayOfWeek4;
                    BytecodeManager.incBytecodes(4);
                    final int n67 = n66;
                    BytecodeManager.incBytecodes(2);
                    if (n67 < 0) {
                        n66 += 7;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n68 = monthLength2 - n66;
                    BytecodeManager.incBytecodes(4);
                    n2 = (n68 + 6) / 7;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 1: {
                    final LocalGregorianCalendar jcal22 = JapaneseImperialCalendar.jcal;
                    final JapaneseImperialCalendar japaneseImperialCalendar7 = normalizedCalendar;
                    BytecodeManager.incBytecodes(3);
                    final long timeInMillis = japaneseImperialCalendar7.getTimeInMillis();
                    BytecodeManager.incBytecodes(2);
                    final TimeZone zone7 = this.getZone();
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date calendarDate10 = jcal22.getCalendarDate(timeInMillis, zone7);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date76 = jdate;
                    BytecodeManager.incBytecodes(2);
                    final int eraIndex3 = getEraIndex(date76);
                    BytecodeManager.incBytecodes(1);
                    final int n69 = eraIndex3;
                    final int n70 = JapaneseImperialCalendar.eras.length - 1;
                    BytecodeManager.incBytecodes(6);
                    LocalGregorianCalendar.Date date77;
                    if (n69 == n70) {
                        final LocalGregorianCalendar jcal23 = JapaneseImperialCalendar.jcal;
                        final long n71 = Long.MAX_VALUE;
                        BytecodeManager.incBytecodes(4);
                        final TimeZone zone8 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        date77 = jcal23.getCalendarDate(n71, zone8);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date78 = date77;
                        BytecodeManager.incBytecodes(2);
                        n2 = date78.getYear();
                        BytecodeManager.incBytecodes(1);
                        final int n72 = n2;
                        final int n73 = 400;
                        BytecodeManager.incBytecodes(3);
                        if (n72 > n73) {
                            final LocalGregorianCalendar.Date date79 = calendarDate10;
                            final int year14 = n2 - 400;
                            BytecodeManager.incBytecodes(5);
                            date79.setYear(year14);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    else {
                        final LocalGregorianCalendar jcal24 = JapaneseImperialCalendar.jcal;
                        final Era era11 = JapaneseImperialCalendar.eras[eraIndex3 + 1];
                        BytecodeManager.incBytecodes(8);
                        final TimeZone zone9 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final long n74 = era11.getSince(zone9) - 1L;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final TimeZone zone10 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        date77 = jcal24.getCalendarDate(n74, zone10);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date80 = date77;
                        BytecodeManager.incBytecodes(2);
                        n2 = date80.getYear();
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date date81 = calendarDate10;
                        final int year15 = n2;
                        BytecodeManager.incBytecodes(3);
                        date81.setYear(year15);
                        BytecodeManager.incBytecodes(1);
                    }
                    final LocalGregorianCalendar jcal25 = JapaneseImperialCalendar.jcal;
                    final LocalGregorianCalendar.Date date82 = calendarDate10;
                    BytecodeManager.incBytecodes(3);
                    jcal25.normalize(date82);
                    BytecodeManager.incBytecodes(1);
                    final LocalGregorianCalendar.Date date83 = calendarDate10;
                    BytecodeManager.incBytecodes(3);
                    final long yearOffsetInMillis = this.getYearOffsetInMillis(date83);
                    final LocalGregorianCalendar.Date date84 = date77;
                    BytecodeManager.incBytecodes(3);
                    final long n75 = lcmp(yearOffsetInMillis, this.getYearOffsetInMillis(date84));
                    BytecodeManager.incBytecodes(2);
                    if (n75 > 0) {
                        --n2;
                        BytecodeManager.incBytecodes(1);
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
            final int n76 = n2;
            BytecodeManager.incBytecodes(2);
            return n76;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getYearOffsetInMillis(final CalendarDate date) {
        try {
            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
            BytecodeManager.incBytecodes(3);
            final long n = (jcal.getDayOfYear(date) - 1L) * 86400000L;
            BytecodeManager.incBytecodes(5);
            final long n2 = n;
            BytecodeManager.incBytecodes(3);
            final long n3 = n2 + date.getTimeOfDay();
            BytecodeManager.incBytecodes(3);
            final long n4 = n3 - date.getZoneOffset();
            BytecodeManager.incBytecodes(3);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object clone() {
        try {
            BytecodeManager.incBytecodes(2);
            final JapaneseImperialCalendar japaneseImperialCalendar = (JapaneseImperialCalendar)super.clone();
            BytecodeManager.incBytecodes(2);
            final JapaneseImperialCalendar japaneseImperialCalendar2 = japaneseImperialCalendar;
            final LocalGregorianCalendar.Date jdate = this.jdate;
            BytecodeManager.incBytecodes(4);
            japaneseImperialCalendar2.jdate = (LocalGregorianCalendar.Date)jdate.clone();
            BytecodeManager.incBytecodes(2);
            japaneseImperialCalendar.originalFields = null;
            BytecodeManager.incBytecodes(3);
            japaneseImperialCalendar.zoneOffsets = null;
            BytecodeManager.incBytecodes(3);
            final JapaneseImperialCalendar japaneseImperialCalendar3 = japaneseImperialCalendar;
            BytecodeManager.incBytecodes(2);
            return japaneseImperialCalendar3;
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
            final LocalGregorianCalendar.Date jdate = this.jdate;
            final TimeZone zone = timeZone;
            BytecodeManager.incBytecodes(4);
            jdate.setZone(zone);
            BytecodeManager.incBytecodes(1);
            final TimeZone timeZone2 = timeZone;
            BytecodeManager.incBytecodes(2);
            return timeZone2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void setTimeZone(final TimeZone timeZone) {
        try {
            BytecodeManager.incBytecodes(3);
            super.setTimeZone(timeZone);
            final LocalGregorianCalendar.Date jdate = this.jdate;
            BytecodeManager.incBytecodes(4);
            jdate.setZone(timeZone);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void computeFields() {
        try {
            BytecodeManager.incBytecodes(2);
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
                Label_0141: {
                    if (n2 == 0) {
                        final long n3 = lcmp(this.cachedFixedDate, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n3 != 0) {
                            break Label_0141;
                        }
                    }
                    final int n4 = setStateFields;
                    final int n5 = n;
                    final int n6 = setStateFields & 0x18000;
                    BytecodeManager.incBytecodes(7);
                    setStateFields = (n4 | this.computeFields(n5, n6));
                    BytecodeManager.incBytecodes(2);
                    final boolean $assertionsDisabled = JapaneseImperialCalendar.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled) {
                        final int n7 = setStateFields;
                        final int n8 = 131071;
                        BytecodeManager.incBytecodes(3);
                        if (n7 != n8) {
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
                final int n9 = setStateFields;
                final int n10 = 0;
                BytecodeManager.incBytecodes(4);
                this.computeFields(n9, n10);
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
            final long n18 = lcmp(cachedFixedDate, this.cachedFixedDate);
            BytecodeManager.incBytecodes(5);
            Label_0488: {
                if (n18 == 0) {
                    final long n19 = lcmp(cachedFixedDate, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n19 >= 0) {
                        break Label_0488;
                    }
                }
                final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
                final LocalGregorianCalendar.Date jdate = this.jdate;
                final long fixedDate = cachedFixedDate;
                BytecodeManager.incBytecodes(5);
                jcal.getCalendarDateFromFixedDate(jdate, fixedDate);
                this.cachedFixedDate = cachedFixedDate;
                BytecodeManager.incBytecodes(3);
            }
            final LocalGregorianCalendar.Date jdate2 = this.jdate;
            BytecodeManager.incBytecodes(3);
            final int eraIndex = getEraIndex(jdate2);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar.Date jdate3 = this.jdate;
            BytecodeManager.incBytecodes(3);
            final int year = jdate3.getYear();
            BytecodeManager.incBytecodes(1);
            final int n20 = 0;
            final int n21 = eraIndex;
            BytecodeManager.incBytecodes(4);
            this.internalSet(n20, n21);
            final int n22 = 1;
            final int n23 = year;
            BytecodeManager.incBytecodes(4);
            this.internalSet(n22, n23);
            int n24 = n | 0x3;
            BytecodeManager.incBytecodes(4);
            final LocalGregorianCalendar.Date jdate4 = this.jdate;
            BytecodeManager.incBytecodes(3);
            final int n25 = jdate4.getMonth() - 1;
            BytecodeManager.incBytecodes(3);
            final LocalGregorianCalendar.Date jdate5 = this.jdate;
            BytecodeManager.incBytecodes(3);
            final int dayOfMonth = jdate5.getDayOfMonth();
            BytecodeManager.incBytecodes(1);
            final int n26 = n & 0xA4;
            BytecodeManager.incBytecodes(4);
            if (n26 != 0) {
                final int n27 = 2;
                final int n28 = n25;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n27, n28);
                final int n29 = 5;
                final int n30 = dayOfMonth;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n29, n30);
                final int n31 = 7;
                final LocalGregorianCalendar.Date jdate6 = this.jdate;
                BytecodeManager.incBytecodes(5);
                final int dayOfWeek = jdate6.getDayOfWeek();
                BytecodeManager.incBytecodes(1);
                this.internalSet(n31, dayOfWeek);
                n24 |= 0xA4;
                BytecodeManager.incBytecodes(4);
            }
            final int n32 = n & 0x7E00;
            BytecodeManager.incBytecodes(4);
            if (n32 != 0) {
                final int n33 = n15;
                BytecodeManager.incBytecodes(2);
                if (n33 != 0) {
                    final int n34 = n15 / 3600000;
                    BytecodeManager.incBytecodes(4);
                    final int n35 = 11;
                    final int n36 = n34;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n35, n36);
                    final int n37 = 9;
                    final int n38 = n34 / 12;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n37, n38);
                    final int n39 = 10;
                    final int n40 = n34 % 12;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n39, n40);
                    final int n41 = n15 % 3600000;
                    BytecodeManager.incBytecodes(4);
                    final int n42 = 12;
                    final int n43 = n41 / 60000;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n42, n43);
                    final int n44 = n41 % 60000;
                    BytecodeManager.incBytecodes(4);
                    final int n45 = 13;
                    final int n46 = n44 / 1000;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n45, n46);
                    final int n47 = 14;
                    final int n48 = n44 % 1000;
                    BytecodeManager.incBytecodes(6);
                    this.internalSet(n47, n48);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n49 = 11;
                    final int n50 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n49, n50);
                    final int n51 = 9;
                    final int n52 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n51, n52);
                    final int n53 = 10;
                    final int n54 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n53, n54);
                    final int n55 = 12;
                    final int n56 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n55, n56);
                    final int n57 = 13;
                    final int n58 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n57, n58);
                    final int n59 = 14;
                    final int n60 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.internalSet(n59, n60);
                }
                n24 |= 0x7E00;
                BytecodeManager.incBytecodes(4);
            }
            final int n61 = n & 0x18000;
            BytecodeManager.incBytecodes(4);
            if (n61 != 0) {
                final int n62 = 15;
                final int n63 = this.zoneOffsets[0];
                BytecodeManager.incBytecodes(7);
                this.internalSet(n62, n63);
                final int n64 = 16;
                final int n65 = this.zoneOffsets[1];
                BytecodeManager.incBytecodes(7);
                this.internalSet(n64, n65);
                n24 |= 0x18000;
                BytecodeManager.incBytecodes(4);
            }
            final int n66 = n & 0x158;
            BytecodeManager.incBytecodes(4);
            if (n66 != 0) {
                final LocalGregorianCalendar.Date jdate7 = this.jdate;
                BytecodeManager.incBytecodes(3);
                final int normalizedYear = jdate7.getNormalizedYear();
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date jdate8 = this.jdate;
                BytecodeManager.incBytecodes(4);
                final int normalizedYear2 = jdate8.getNormalizedYear();
                BytecodeManager.incBytecodes(1);
                final boolean transitionYear = this.isTransitionYear(normalizedYear2);
                BytecodeManager.incBytecodes(1);
                final boolean b2 = transitionYear;
                BytecodeManager.incBytecodes(2);
                long n68;
                int n69;
                if (b2) {
                    final LocalGregorianCalendar.Date jdate9 = this.jdate;
                    final long n67 = cachedFixedDate;
                    BytecodeManager.incBytecodes(5);
                    n68 = this.getFixedDateJan1(jdate9, n67);
                    BytecodeManager.incBytecodes(1);
                    n69 = (int)(cachedFixedDate - n68) + 1;
                    BytecodeManager.incBytecodes(8);
                }
                else {
                    final int n70 = normalizedYear;
                    final int n71 = JapaneseImperialCalendar.MIN_VALUES[1];
                    BytecodeManager.incBytecodes(5);
                    if (n70 == n71) {
                        final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
                        final long n72 = Long.MIN_VALUE;
                        BytecodeManager.incBytecodes(4);
                        final TimeZone zone2 = this.getZone();
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar.Date calendarDate = jcal2.getCalendarDate(n72, zone2);
                        BytecodeManager.incBytecodes(1);
                        final LocalGregorianCalendar jcal3 = JapaneseImperialCalendar.jcal;
                        final LocalGregorianCalendar.Date date = calendarDate;
                        BytecodeManager.incBytecodes(3);
                        n68 = jcal3.getFixedDate(date);
                        BytecodeManager.incBytecodes(1);
                        n69 = (int)(cachedFixedDate - n68) + 1;
                        BytecodeManager.incBytecodes(7);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final LocalGregorianCalendar jcal4 = JapaneseImperialCalendar.jcal;
                        final LocalGregorianCalendar.Date jdate10 = this.jdate;
                        BytecodeManager.incBytecodes(4);
                        n69 = (int)jcal4.getDayOfYear(jdate10);
                        BytecodeManager.incBytecodes(2);
                        n68 = cachedFixedDate - n69 + 1L;
                        BytecodeManager.incBytecodes(7);
                    }
                }
                final boolean b3 = transitionYear;
                BytecodeManager.incBytecodes(2);
                long fixedDateMonth1;
                if (b3) {
                    final LocalGregorianCalendar.Date jdate11 = this.jdate;
                    final long n73 = cachedFixedDate;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    fixedDateMonth1 = this.getFixedDateMonth1(jdate11, n73);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    fixedDateMonth1 = cachedFixedDate - dayOfMonth + 1L;
                    BytecodeManager.incBytecodes(6);
                }
                final long n74 = fixedDateMonth1;
                BytecodeManager.incBytecodes(1);
                final int n75 = 6;
                final int n76 = n69;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n75, n76);
                final int n77 = 8;
                final int n78 = (dayOfMonth - 1) / 7 + 1;
                BytecodeManager.incBytecodes(10);
                this.internalSet(n77, n78);
                final long n79 = n68;
                final long n80 = cachedFixedDate;
                BytecodeManager.incBytecodes(4);
                int n81 = this.getWeekNumber(n79, n80);
                BytecodeManager.incBytecodes(1);
                final int n82 = n81;
                BytecodeManager.incBytecodes(2);
                if (n82 == 0) {
                    final long n83 = n68 - 1L;
                    BytecodeManager.incBytecodes(4);
                    final long n84 = n83;
                    BytecodeManager.incBytecodes(2);
                    final LocalGregorianCalendar.Date calendarDate2 = getCalendarDate(n84);
                    BytecodeManager.incBytecodes(1);
                    final boolean b4 = transitionYear;
                    BytecodeManager.incBytecodes(2);
                    long n85 = 0L;
                    Label_1813: {
                        if (!b4) {
                            final LocalGregorianCalendar.Date date2 = calendarDate2;
                            BytecodeManager.incBytecodes(3);
                            final int normalizedYear3 = date2.getNormalizedYear();
                            BytecodeManager.incBytecodes(1);
                            final boolean transitionYear2 = this.isTransitionYear(normalizedYear3);
                            BytecodeManager.incBytecodes(1);
                            if (!transitionYear2) {
                                n85 = n68 - 365L;
                                BytecodeManager.incBytecodes(4);
                                final LocalGregorianCalendar.Date date3 = calendarDate2;
                                BytecodeManager.incBytecodes(2);
                                final boolean leapYear = date3.isLeapYear();
                                BytecodeManager.incBytecodes(1);
                                if (leapYear) {
                                    --n85;
                                    BytecodeManager.incBytecodes(5);
                                }
                                break Label_1813;
                            }
                        }
                        final boolean b5 = transitionYear;
                        BytecodeManager.incBytecodes(2);
                        if (b5) {
                            final LocalGregorianCalendar.Date jdate12 = this.jdate;
                            BytecodeManager.incBytecodes(3);
                            final int year2 = jdate12.getYear();
                            final int n86 = 1;
                            BytecodeManager.incBytecodes(2);
                            if (year2 == n86) {
                                final int n87 = eraIndex;
                                final int n88 = 4;
                                BytecodeManager.incBytecodes(3);
                                if (n87 > n88) {
                                    final Era era = JapaneseImperialCalendar.eras[eraIndex - 1];
                                    BytecodeManager.incBytecodes(6);
                                    final CalendarDate sinceDate = era.getSinceDate();
                                    BytecodeManager.incBytecodes(1);
                                    final int n89 = normalizedYear;
                                    final CalendarDate calendarDate3 = sinceDate;
                                    BytecodeManager.incBytecodes(3);
                                    final int year3 = calendarDate3.getYear();
                                    BytecodeManager.incBytecodes(1);
                                    if (n89 == year3) {
                                        final LocalGregorianCalendar.Date date4 = calendarDate2;
                                        final CalendarDate calendarDate4 = sinceDate;
                                        BytecodeManager.incBytecodes(3);
                                        final int month = calendarDate4.getMonth();
                                        BytecodeManager.incBytecodes(1);
                                        final CalendarDate setMonth = date4.setMonth(month);
                                        final CalendarDate calendarDate5 = sinceDate;
                                        BytecodeManager.incBytecodes(2);
                                        final int dayOfMonth2 = calendarDate5.getDayOfMonth();
                                        BytecodeManager.incBytecodes(1);
                                        setMonth.setDayOfMonth(dayOfMonth2);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final LocalGregorianCalendar.Date date5 = calendarDate2;
                                    final int month2 = 1;
                                    BytecodeManager.incBytecodes(3);
                                    final CalendarDate setMonth2 = date5.setMonth(month2);
                                    final int dayOfMonth3 = 1;
                                    BytecodeManager.incBytecodes(2);
                                    setMonth2.setDayOfMonth(dayOfMonth3);
                                    BytecodeManager.incBytecodes(1);
                                }
                                final LocalGregorianCalendar jcal5 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date6 = calendarDate2;
                                BytecodeManager.incBytecodes(3);
                                jcal5.normalize(date6);
                                BytecodeManager.incBytecodes(1);
                                final LocalGregorianCalendar jcal6 = JapaneseImperialCalendar.jcal;
                                final LocalGregorianCalendar.Date date7 = calendarDate2;
                                BytecodeManager.incBytecodes(3);
                                n85 = jcal6.getFixedDate(date7);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                n85 = n68 - 365L;
                                BytecodeManager.incBytecodes(4);
                                final LocalGregorianCalendar.Date date8 = calendarDate2;
                                BytecodeManager.incBytecodes(2);
                                final boolean leapYear2 = date8.isLeapYear();
                                BytecodeManager.incBytecodes(1);
                                if (leapYear2) {
                                    --n85;
                                    BytecodeManager.incBytecodes(5);
                                }
                            }
                        }
                        else {
                            final Era[] eras = JapaneseImperialCalendar.eras;
                            final LocalGregorianCalendar.Date jdate13 = this.jdate;
                            BytecodeManager.incBytecodes(4);
                            final Era era2 = eras[getEraIndex(jdate13)];
                            BytecodeManager.incBytecodes(2);
                            final CalendarDate sinceDate2 = era2.getSinceDate();
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date9 = calendarDate2;
                            final CalendarDate calendarDate6 = sinceDate2;
                            BytecodeManager.incBytecodes(3);
                            final int month3 = calendarDate6.getMonth();
                            BytecodeManager.incBytecodes(1);
                            final CalendarDate setMonth3 = date9.setMonth(month3);
                            final CalendarDate calendarDate7 = sinceDate2;
                            BytecodeManager.incBytecodes(2);
                            final int dayOfMonth4 = calendarDate7.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            setMonth3.setDayOfMonth(dayOfMonth4);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal7 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date10 = calendarDate2;
                            BytecodeManager.incBytecodes(3);
                            jcal7.normalize(date10);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal8 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date11 = calendarDate2;
                            BytecodeManager.incBytecodes(3);
                            n85 = jcal8.getFixedDate(date11);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final long n90 = n85;
                    final long n91 = n83;
                    BytecodeManager.incBytecodes(4);
                    n81 = this.getWeekNumber(n90, n91);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean b6 = transitionYear;
                    BytecodeManager.incBytecodes(2);
                    if (!b6) {
                        final int n92 = n81;
                        final int n93 = 52;
                        BytecodeManager.incBytecodes(3);
                        if (n92 >= n93) {
                            long n94 = n68 + 365L;
                            BytecodeManager.incBytecodes(4);
                            final LocalGregorianCalendar.Date jdate14 = this.jdate;
                            BytecodeManager.incBytecodes(3);
                            final boolean leapYear3 = jdate14.isLeapYear();
                            BytecodeManager.incBytecodes(1);
                            if (leapYear3) {
                                ++n94;
                                BytecodeManager.incBytecodes(4);
                            }
                            final long fixedDate2 = n94 + 6L;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final int firstDayOfWeek = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                            final long dayOfWeekDateOnOrBefore = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate2, firstDayOfWeek);
                            BytecodeManager.incBytecodes(1);
                            final int n95 = (int)(dayOfWeekDateOnOrBefore - n94);
                            BytecodeManager.incBytecodes(5);
                            final int n96 = n95;
                            BytecodeManager.incBytecodes(3);
                            final int minimalDaysInFirstWeek = this.getMinimalDaysInFirstWeek();
                            BytecodeManager.incBytecodes(1);
                            if (n96 >= minimalDaysInFirstWeek) {
                                final long n97 = lcmp(cachedFixedDate, dayOfWeekDateOnOrBefore - 7L);
                                BytecodeManager.incBytecodes(6);
                                if (n97 >= 0) {
                                    n81 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final LocalGregorianCalendar.Date jdate15 = this.jdate;
                        BytecodeManager.incBytecodes(3);
                        final LocalGregorianCalendar.Date date12 = (LocalGregorianCalendar.Date)jdate15.clone();
                        BytecodeManager.incBytecodes(2);
                        final LocalGregorianCalendar.Date jdate16 = this.jdate;
                        BytecodeManager.incBytecodes(3);
                        final int year4 = jdate16.getYear();
                        final int n98 = 1;
                        BytecodeManager.incBytecodes(2);
                        long n99;
                        if (year4 == n98) {
                            final LocalGregorianCalendar.Date date13 = date12;
                            final int localYear = 1;
                            BytecodeManager.incBytecodes(3);
                            date13.addYear(localYear);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date14 = date12;
                            final int month4 = 1;
                            BytecodeManager.incBytecodes(3);
                            final CalendarDate setMonth4 = date14.setMonth(month4);
                            final int dayOfMonth5 = 1;
                            BytecodeManager.incBytecodes(2);
                            setMonth4.setDayOfMonth(dayOfMonth5);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal9 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date15 = date12;
                            BytecodeManager.incBytecodes(3);
                            n99 = jcal9.getFixedDate(date15);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final LocalGregorianCalendar.Date date16 = date12;
                            BytecodeManager.incBytecodes(2);
                            final int n100 = getEraIndex(date16) + 1;
                            BytecodeManager.incBytecodes(3);
                            final Era era3 = JapaneseImperialCalendar.eras[n100];
                            BytecodeManager.incBytecodes(4);
                            final CalendarDate sinceDate3 = era3.getSinceDate();
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date17 = date12;
                            final Era era4 = JapaneseImperialCalendar.eras[n100];
                            BytecodeManager.incBytecodes(5);
                            date17.setEra(era4);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar.Date date18 = date12;
                            final int year5 = 1;
                            final CalendarDate calendarDate8 = sinceDate3;
                            BytecodeManager.incBytecodes(4);
                            final int month5 = calendarDate8.getMonth();
                            final CalendarDate calendarDate9 = sinceDate3;
                            BytecodeManager.incBytecodes(2);
                            final int dayOfMonth6 = calendarDate9.getDayOfMonth();
                            BytecodeManager.incBytecodes(1);
                            date18.setDate(year5, month5, dayOfMonth6);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal10 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date19 = date12;
                            BytecodeManager.incBytecodes(3);
                            jcal10.normalize(date19);
                            BytecodeManager.incBytecodes(1);
                            final LocalGregorianCalendar jcal11 = JapaneseImperialCalendar.jcal;
                            final LocalGregorianCalendar.Date date20 = date12;
                            BytecodeManager.incBytecodes(3);
                            n99 = jcal11.getFixedDate(date20);
                            BytecodeManager.incBytecodes(1);
                        }
                        final long fixedDate3 = n99 + 6L;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int firstDayOfWeek2 = this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(1);
                        final long dayOfWeekDateOnOrBefore2 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate3, firstDayOfWeek2);
                        BytecodeManager.incBytecodes(1);
                        final int n101 = (int)(dayOfWeekDateOnOrBefore2 - n99);
                        BytecodeManager.incBytecodes(5);
                        final int n102 = n101;
                        BytecodeManager.incBytecodes(3);
                        final int minimalDaysInFirstWeek2 = this.getMinimalDaysInFirstWeek();
                        BytecodeManager.incBytecodes(1);
                        if (n102 >= minimalDaysInFirstWeek2) {
                            final long n103 = lcmp(cachedFixedDate, dayOfWeekDateOnOrBefore2 - 7L);
                            BytecodeManager.incBytecodes(6);
                            if (n103 >= 0) {
                                n81 = 1;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                }
                final int n104 = 3;
                final int n105 = n81;
                BytecodeManager.incBytecodes(4);
                this.internalSet(n104, n105);
                final int n106 = 4;
                final long n107 = n74;
                final long n108 = cachedFixedDate;
                BytecodeManager.incBytecodes(6);
                final int weekNumber = this.getWeekNumber(n107, n108);
                BytecodeManager.incBytecodes(1);
                this.internalSet(n106, weekNumber);
                n24 |= 0x158;
                BytecodeManager.incBytecodes(4);
            }
            final int n109 = n24;
            BytecodeManager.incBytecodes(2);
            return n109;
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
            final boolean $assertionsDisabled = JapaneseImperialCalendar.$assertionsDisabled;
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
            final int selectFields = this.selectFields();
            BytecodeManager.incBytecodes(1);
            final int n11 = 0;
            BytecodeManager.incBytecodes(3);
            final boolean set = this.isSet(n11);
            BytecodeManager.incBytecodes(1);
            int internalGet2;
            int internalGet4;
            if (set) {
                final int n12 = 0;
                BytecodeManager.incBytecodes(3);
                internalGet2 = this.internalGet(n12);
                BytecodeManager.incBytecodes(1);
                final int n13 = 1;
                BytecodeManager.incBytecodes(3);
                final boolean set2 = this.isSet(n13);
                BytecodeManager.incBytecodes(1);
                int internalGet3;
                if (set2) {
                    final int n14 = 1;
                    BytecodeManager.incBytecodes(3);
                    internalGet3 = this.internalGet(n14);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    internalGet3 = 1;
                    BytecodeManager.incBytecodes(1);
                }
                internalGet4 = internalGet3;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n15 = 1;
                BytecodeManager.incBytecodes(3);
                final boolean set3 = this.isSet(n15);
                BytecodeManager.incBytecodes(1);
                if (set3) {
                    internalGet2 = JapaneseImperialCalendar.eras.length - 1;
                    BytecodeManager.incBytecodes(5);
                    final int n16 = 1;
                    BytecodeManager.incBytecodes(3);
                    internalGet4 = this.internalGet(n16);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    internalGet2 = 3;
                    BytecodeManager.incBytecodes(2);
                    internalGet4 = 45;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final long n17 = 0L;
            BytecodeManager.incBytecodes(2);
            final int n18 = selectFields;
            final int n19 = 11;
            BytecodeManager.incBytecodes(3);
            final boolean fieldSet = Calendar.isFieldSet(n18, n19);
            BytecodeManager.incBytecodes(1);
            long n22;
            if (fieldSet) {
                final long n20 = n17;
                final int n21 = 11;
                BytecodeManager.incBytecodes(4);
                n22 = n20 + this.internalGet(n21);
                BytecodeManager.incBytecodes(4);
            }
            else {
                final long n23 = n17;
                final int n24 = 10;
                BytecodeManager.incBytecodes(4);
                n22 = n23 + this.internalGet(n24);
                BytecodeManager.incBytecodes(3);
                final int n25 = selectFields;
                final int n26 = 9;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet2 = Calendar.isFieldSet(n25, n26);
                BytecodeManager.incBytecodes(1);
                if (fieldSet2) {
                    final long n27 = n22;
                    final int n28 = 12;
                    final int n29 = 9;
                    BytecodeManager.incBytecodes(5);
                    n22 = n27 + n28 * this.internalGet(n29);
                    BytecodeManager.incBytecodes(4);
                }
            }
            final long n30 = n22 * 60L;
            BytecodeManager.incBytecodes(4);
            final long n31 = n30;
            final int n32 = 12;
            BytecodeManager.incBytecodes(4);
            final long n33 = n31 + this.internalGet(n32);
            BytecodeManager.incBytecodes(3);
            final long n34 = n33 * 60L;
            BytecodeManager.incBytecodes(4);
            final long n35 = n34;
            final int n36 = 13;
            BytecodeManager.incBytecodes(4);
            final long n37 = n35 + this.internalGet(n36);
            BytecodeManager.incBytecodes(3);
            final long n38 = n37 * 1000L;
            BytecodeManager.incBytecodes(4);
            final long n39 = n38;
            final int n40 = 14;
            BytecodeManager.incBytecodes(4);
            final long n41 = n39 + this.internalGet(n40);
            BytecodeManager.incBytecodes(3);
            long n42 = n41 / 86400000L;
            BytecodeManager.incBytecodes(4);
            long n43 = n41 % 86400000L;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final long n44 = lcmp(n43, 0L);
                BytecodeManager.incBytecodes(4);
                if (n44 >= 0) {
                    break;
                }
                n43 += 86400000L;
                BytecodeManager.incBytecodes(4);
                --n42;
                BytecodeManager.incBytecodes(5);
            }
            final long n45 = n42;
            final int n46 = internalGet2;
            final int n47 = internalGet4;
            final int n48 = selectFields;
            BytecodeManager.incBytecodes(6);
            final long n49 = n45 + this.getFixedDate(n46, n47, n48);
            BytecodeManager.incBytecodes(2);
            final long n50 = (n49 - 719163L) * 86400000L + n43;
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
            final int n51 = selectFields & 0x18000;
            BytecodeManager.incBytecodes(4);
            final int n52 = n51;
            final int n53 = 98304;
            BytecodeManager.incBytecodes(3);
            if (n52 != n53) {
                final boolean b = zone instanceof ZoneInfo;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final ZoneInfo zoneInfo = (ZoneInfo)zone;
                    final long wall = n50;
                    final int[] zoneOffsets2 = this.zoneOffsets;
                    BytecodeManager.incBytecodes(6);
                    zoneInfo.getOffsetsByWall(wall, zoneOffsets2);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final TimeZone timeZone = zone;
                    final long n54 = n50;
                    final TimeZone timeZone2 = zone;
                    BytecodeManager.incBytecodes(4);
                    final long n55 = n54 - timeZone2.getRawOffset();
                    final int[] zoneOffsets3 = this.zoneOffsets;
                    BytecodeManager.incBytecodes(5);
                    timeZone.getOffsets(n55, zoneOffsets3);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n56 = n51;
            BytecodeManager.incBytecodes(2);
            if (n56 != 0) {
                final int n57 = n51;
                final int n58 = 15;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet3 = Calendar.isFieldSet(n57, n58);
                BytecodeManager.incBytecodes(1);
                if (fieldSet3) {
                    final int[] zoneOffsets4 = this.zoneOffsets;
                    final int n59 = 0;
                    final int n60 = 15;
                    BytecodeManager.incBytecodes(6);
                    zoneOffsets4[n59] = this.internalGet(n60);
                    BytecodeManager.incBytecodes(1);
                }
                final int n61 = n51;
                final int n62 = 16;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet4 = Calendar.isFieldSet(n61, n62);
                BytecodeManager.incBytecodes(1);
                if (fieldSet4) {
                    final int[] zoneOffsets5 = this.zoneOffsets;
                    final int n63 = 1;
                    final int n64 = 16;
                    BytecodeManager.incBytecodes(6);
                    zoneOffsets5[n63] = this.internalGet(n64);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final long time = n50 - (this.zoneOffsets[0] + this.zoneOffsets[1]);
            BytecodeManager.incBytecodes(13);
            this.time = time;
            BytecodeManager.incBytecodes(3);
            final int n65 = selectFields;
            BytecodeManager.incBytecodes(4);
            final int n66 = n65 | this.getSetStateFields();
            final int n67 = n51;
            BytecodeManager.incBytecodes(3);
            final int computeFields = this.computeFields(n66, n67);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final boolean lenient2 = this.isLenient();
            BytecodeManager.incBytecodes(1);
            if (!lenient2) {
                int n68 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n69 = n68;
                    final int n70 = 17;
                    BytecodeManager.incBytecodes(3);
                    if (n69 >= n70) {
                        break;
                    }
                    final int n71 = n68;
                    BytecodeManager.incBytecodes(3);
                    final boolean externallySet2 = this.isExternallySet(n71);
                    BytecodeManager.incBytecodes(1);
                    if (!externallySet2) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n72 = this.originalFields[n68];
                        final int n73 = n68;
                        BytecodeManager.incBytecodes(7);
                        final int internalGet5 = this.internalGet(n73);
                        BytecodeManager.incBytecodes(1);
                        if (n72 != internalGet5) {
                            final int n74 = n68;
                            BytecodeManager.incBytecodes(3);
                            final int internalGet6 = this.internalGet(n74);
                            BytecodeManager.incBytecodes(1);
                            final int[] originalFields2 = this.originalFields;
                            final int n75 = 0;
                            final int[] fields = this.fields;
                            final int n76 = 0;
                            final int length = this.fields.length;
                            BytecodeManager.incBytecodes(10);
                            System.arraycopy(originalFields2, n75, fields, n76, length);
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb = new StringBuilder();
                            final int n77 = n68;
                            BytecodeManager.incBytecodes(2);
                            final String fieldName2 = Calendar.getFieldName(n77);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append = sb.append(fieldName2);
                            final String str = "=";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append2 = append.append(str);
                            final int i = internalGet6;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = append2.append(i);
                            final String str2 = ", expected ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append4 = append3.append(str2);
                            final int j = this.originalFields[n68];
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder append5 = append4.append(j);
                            BytecodeManager.incBytecodes(1);
                            final String string = append5.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalArgumentException ex2 = new IllegalArgumentException(string);
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                    ++n68;
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
    
    private long getFixedDate(final int n, int n2, final int n3) {
        try {
            int internalGet = 0;
            BytecodeManager.incBytecodes(2);
            int n4 = 1;
            BytecodeManager.incBytecodes(2);
            final int n5 = 2;
            BytecodeManager.incBytecodes(3);
            final boolean fieldSet = Calendar.isFieldSet(n3, n5);
            BytecodeManager.incBytecodes(1);
            if (fieldSet) {
                final int n6 = 2;
                BytecodeManager.incBytecodes(3);
                internalGet = this.internalGet(n6);
                BytecodeManager.incBytecodes(1);
                final int n7 = internalGet;
                final int n8 = 11;
                BytecodeManager.incBytecodes(3);
                if (n7 > n8) {
                    n2 += internalGet / 12;
                    BytecodeManager.incBytecodes(6);
                    internalGet %= 12;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n9 = internalGet;
                    BytecodeManager.incBytecodes(2);
                    if (n9 < 0) {
                        final int[] array = { 0 };
                        BytecodeManager.incBytecodes(2);
                        final int n10 = n2;
                        final int n11 = internalGet;
                        final int d = 12;
                        final int[] r = array;
                        BytecodeManager.incBytecodes(5);
                        n2 = n10 + CalendarUtils.floorDivide(n11, d, r);
                        BytecodeManager.incBytecodes(2);
                        internalGet = array[0];
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            else {
                final boolean b = n2 != 0;
                final boolean b2 = true;
                BytecodeManager.incBytecodes(3);
                if (b == b2) {
                    BytecodeManager.incBytecodes(2);
                    if (n != 0) {
                        final Era era = JapaneseImperialCalendar.eras[n];
                        BytecodeManager.incBytecodes(4);
                        final CalendarDate sinceDate = era.getSinceDate();
                        BytecodeManager.incBytecodes(1);
                        final CalendarDate calendarDate = sinceDate;
                        BytecodeManager.incBytecodes(2);
                        internalGet = calendarDate.getMonth() - 1;
                        BytecodeManager.incBytecodes(3);
                        final CalendarDate calendarDate2 = sinceDate;
                        BytecodeManager.incBytecodes(2);
                        n4 = calendarDate2.getDayOfMonth();
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final int n12 = n2;
            final int n13 = JapaneseImperialCalendar.MIN_VALUES[1];
            BytecodeManager.incBytecodes(5);
            if (n12 == n13) {
                final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
                final long n14 = Long.MIN_VALUE;
                BytecodeManager.incBytecodes(4);
                final TimeZone zone = this.getZone();
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date calendarDate3 = jcal.getCalendarDate(n14, zone);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date date = calendarDate3;
                BytecodeManager.incBytecodes(2);
                final int n15 = date.getMonth() - 1;
                BytecodeManager.incBytecodes(3);
                final int n16 = internalGet;
                final int n17 = n15;
                BytecodeManager.incBytecodes(3);
                if (n16 < n17) {
                    internalGet = n15;
                    BytecodeManager.incBytecodes(2);
                }
                final int n18 = internalGet;
                final int n19 = n15;
                BytecodeManager.incBytecodes(3);
                if (n18 == n19) {
                    final LocalGregorianCalendar.Date date2 = calendarDate3;
                    BytecodeManager.incBytecodes(2);
                    n4 = date2.getDayOfMonth();
                    BytecodeManager.incBytecodes(1);
                }
            }
            final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
            BytecodeManager.incBytecodes(3);
            final LocalGregorianCalendar.Date calendarDate4 = jcal2.newCalendarDate(no_TIMEZONE);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar.Date date3 = calendarDate4;
            BytecodeManager.incBytecodes(3);
            Era era2;
            if (n > 0) {
                era2 = JapaneseImperialCalendar.eras[n];
                BytecodeManager.incBytecodes(4);
            }
            else {
                era2 = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            date3.setEra(era2);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar.Date date4 = calendarDate4;
            final int year = n2;
            final int month = internalGet + 1;
            final int dayOfMonth = n4;
            BytecodeManager.incBytecodes(7);
            date4.setDate(year, month, dayOfMonth);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar jcal3 = JapaneseImperialCalendar.jcal;
            final LocalGregorianCalendar.Date date5 = calendarDate4;
            BytecodeManager.incBytecodes(3);
            jcal3.normalize(date5);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar jcal4 = JapaneseImperialCalendar.jcal;
            final LocalGregorianCalendar.Date date6 = calendarDate4;
            BytecodeManager.incBytecodes(3);
            long n20 = jcal4.getFixedDate(date6);
            BytecodeManager.incBytecodes(1);
            final int n21 = 2;
            BytecodeManager.incBytecodes(3);
            final boolean fieldSet2 = Calendar.isFieldSet(n3, n21);
            BytecodeManager.incBytecodes(1);
            if (fieldSet2) {
                final int n22 = 5;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet3 = Calendar.isFieldSet(n3, n22);
                BytecodeManager.incBytecodes(1);
                if (fieldSet3) {
                    final int n23 = 5;
                    BytecodeManager.incBytecodes(3);
                    final boolean set = this.isSet(n23);
                    BytecodeManager.incBytecodes(1);
                    if (set) {
                        final long n24 = n20;
                        final int n25 = 5;
                        BytecodeManager.incBytecodes(4);
                        final long n26 = n24 + this.internalGet(n25);
                        BytecodeManager.incBytecodes(3);
                        n20 = n26 - n4;
                        BytecodeManager.incBytecodes(6);
                    }
                }
                else {
                    final int n27 = 4;
                    BytecodeManager.incBytecodes(3);
                    final boolean fieldSet4 = Calendar.isFieldSet(n3, n27);
                    BytecodeManager.incBytecodes(1);
                    if (fieldSet4) {
                        final long fixedDate = n20 + 6L;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int firstDayOfWeek = this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(1);
                        long n28 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate, firstDayOfWeek);
                        BytecodeManager.incBytecodes(1);
                        final long n29 = n28 - n20;
                        BytecodeManager.incBytecodes(5);
                        final long n30 = lcmp(n29, (long)this.getMinimalDaysInFirstWeek());
                        BytecodeManager.incBytecodes(3);
                        if (n30 >= 0) {
                            n28 -= 7L;
                            BytecodeManager.incBytecodes(4);
                        }
                        final int n31 = 7;
                        BytecodeManager.incBytecodes(3);
                        final boolean fieldSet5 = Calendar.isFieldSet(n3, n31);
                        BytecodeManager.incBytecodes(1);
                        if (fieldSet5) {
                            final long fixedDate2 = n28 + 6L;
                            final int n32 = 7;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final int internalGet2 = this.internalGet(n32);
                            BytecodeManager.incBytecodes(1);
                            n28 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate2, internalGet2);
                            BytecodeManager.incBytecodes(1);
                        }
                        final long n33 = n28;
                        final int n34 = 7;
                        final int n35 = 4;
                        BytecodeManager.incBytecodes(5);
                        n20 = n33 + n34 * (this.internalGet(n35) - 1);
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n36 = 7;
                        BytecodeManager.incBytecodes(3);
                        final boolean fieldSet6 = Calendar.isFieldSet(n3, n36);
                        BytecodeManager.incBytecodes(1);
                        int n38;
                        if (fieldSet6) {
                            final int n37 = 7;
                            BytecodeManager.incBytecodes(3);
                            n38 = this.internalGet(n37);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            BytecodeManager.incBytecodes(2);
                            n38 = this.getFirstDayOfWeek();
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n39 = 8;
                        BytecodeManager.incBytecodes(3);
                        final boolean fieldSet7 = Calendar.isFieldSet(n3, n39);
                        BytecodeManager.incBytecodes(1);
                        int internalGet3;
                        if (fieldSet7) {
                            final int n40 = 8;
                            BytecodeManager.incBytecodes(3);
                            internalGet3 = this.internalGet(n40);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            internalGet3 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n41 = internalGet3;
                        BytecodeManager.incBytecodes(2);
                        if (n41 >= 0) {
                            final long fixedDate3 = n20 + 7 * internalGet3 - 1L;
                            final int dayOfWeek = n38;
                            BytecodeManager.incBytecodes(10);
                            n20 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate3, dayOfWeek);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n42 = internalGet;
                            final int n43 = n2;
                            BytecodeManager.incBytecodes(4);
                            final int n44 = this.monthLength(n42, n43) + 7 * (internalGet3 + 1);
                            BytecodeManager.incBytecodes(7);
                            final long fixedDate4 = n20 + n44 - 1L;
                            final int dayOfWeek2 = n38;
                            BytecodeManager.incBytecodes(8);
                            n20 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate4, dayOfWeek2);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            else {
                final int n45 = 6;
                BytecodeManager.incBytecodes(3);
                final boolean fieldSet8 = Calendar.isFieldSet(n3, n45);
                BytecodeManager.incBytecodes(1);
                if (fieldSet8) {
                    final LocalGregorianCalendar.Date date7 = calendarDate4;
                    BytecodeManager.incBytecodes(3);
                    final int normalizedYear = date7.getNormalizedYear();
                    BytecodeManager.incBytecodes(1);
                    final boolean transitionYear = this.isTransitionYear(normalizedYear);
                    BytecodeManager.incBytecodes(1);
                    if (transitionYear) {
                        final LocalGregorianCalendar.Date date8 = calendarDate4;
                        final long n46 = n20;
                        BytecodeManager.incBytecodes(4);
                        n20 = this.getFixedDateJan1(date8, n46);
                        BytecodeManager.incBytecodes(1);
                    }
                    final long n47 = n20;
                    final int n48 = 6;
                    BytecodeManager.incBytecodes(4);
                    final long n49 = n47 + this.internalGet(n48);
                    BytecodeManager.incBytecodes(3);
                    n20 = n49 - 1L;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final long fixedDate5 = n20 + 6L;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final int firstDayOfWeek2 = this.getFirstDayOfWeek();
                    BytecodeManager.incBytecodes(1);
                    long n50 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate5, firstDayOfWeek2);
                    BytecodeManager.incBytecodes(1);
                    final long n51 = n50 - n20;
                    BytecodeManager.incBytecodes(5);
                    final long n52 = lcmp(n51, (long)this.getMinimalDaysInFirstWeek());
                    BytecodeManager.incBytecodes(3);
                    if (n52 >= 0) {
                        n50 -= 7L;
                        BytecodeManager.incBytecodes(4);
                    }
                    final int n53 = 7;
                    BytecodeManager.incBytecodes(3);
                    final boolean fieldSet9 = Calendar.isFieldSet(n3, n53);
                    BytecodeManager.incBytecodes(1);
                    if (fieldSet9) {
                        final int n54 = 7;
                        BytecodeManager.incBytecodes(3);
                        final int internalGet4 = this.internalGet(n54);
                        BytecodeManager.incBytecodes(1);
                        final int n55 = internalGet4;
                        BytecodeManager.incBytecodes(3);
                        final int firstDayOfWeek3 = this.getFirstDayOfWeek();
                        BytecodeManager.incBytecodes(1);
                        if (n55 != firstDayOfWeek3) {
                            final long fixedDate6 = n50 + 6L;
                            final int dayOfWeek3 = internalGet4;
                            BytecodeManager.incBytecodes(5);
                            n50 = AbstractCalendar.getDayOfWeekDateOnOrBefore(fixedDate6, dayOfWeek3);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final long n56 = n50;
                    final long n57 = 7L;
                    final int n58 = 3;
                    BytecodeManager.incBytecodes(5);
                    n20 = n56 + n57 * (this.internalGet(n58) - 1L);
                    BytecodeManager.incBytecodes(6);
                }
            }
            final long n59 = n20;
            BytecodeManager.incBytecodes(2);
            return n59;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getFixedDateJan1(final LocalGregorianCalendar.Date date, final long n) {
        try {
            BytecodeManager.incBytecodes(2);
            date.getEra();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Era era = date.getEra();
            BytecodeManager.incBytecodes(1);
            if (era != null) {
                BytecodeManager.incBytecodes(2);
                final int year = date.getYear();
                final int n2 = 1;
                BytecodeManager.incBytecodes(2);
                if (year == n2) {
                    BytecodeManager.incBytecodes(2);
                    int eraIndex = getEraIndex(date);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final int n3 = eraIndex;
                        BytecodeManager.incBytecodes(2);
                        if (n3 <= 0) {
                            break;
                        }
                        final Era era2 = JapaneseImperialCalendar.eras[eraIndex];
                        BytecodeManager.incBytecodes(4);
                        final CalendarDate sinceDate = era2.getSinceDate();
                        BytecodeManager.incBytecodes(1);
                        final Gregorian gcal = JapaneseImperialCalendar.gcal;
                        final CalendarDate date2 = sinceDate;
                        BytecodeManager.incBytecodes(3);
                        final long fixedDate = gcal.getFixedDate(date2);
                        BytecodeManager.incBytecodes(1);
                        final long n4 = lcmp(fixedDate, n);
                        BytecodeManager.incBytecodes(4);
                        if (n4 <= 0) {
                            final long n5 = fixedDate;
                            BytecodeManager.incBytecodes(2);
                            return n5;
                        }
                        BytecodeManager.incBytecodes(1);
                        --eraIndex;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final Gregorian gcal2 = JapaneseImperialCalendar.gcal;
            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
            BytecodeManager.incBytecodes(3);
            final Gregorian.Date calendarDate = gcal2.newCalendarDate(no_TIMEZONE);
            BytecodeManager.incBytecodes(1);
            final Gregorian.Date date3 = calendarDate;
            BytecodeManager.incBytecodes(3);
            final int normalizedYear = date.getNormalizedYear();
            final int month = 1;
            final int dayOfMonth = 1;
            BytecodeManager.incBytecodes(3);
            date3.setDate(normalizedYear, month, dayOfMonth);
            BytecodeManager.incBytecodes(1);
            final Gregorian gcal3 = JapaneseImperialCalendar.gcal;
            final Gregorian.Date date4 = calendarDate;
            BytecodeManager.incBytecodes(3);
            final long fixedDate2 = gcal3.getFixedDate(date4);
            BytecodeManager.incBytecodes(1);
            return fixedDate2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getFixedDateMonth1(final LocalGregorianCalendar.Date date, final long n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int transitionEraIndex = getTransitionEraIndex(date);
            BytecodeManager.incBytecodes(1);
            final int n2 = transitionEraIndex;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 != n3) {
                final long n4 = JapaneseImperialCalendar.sinceFixedDates[transitionEraIndex];
                BytecodeManager.incBytecodes(4);
                final long n5 = lcmp(n4, n);
                BytecodeManager.incBytecodes(4);
                if (n5 <= 0) {
                    final long n6 = n4;
                    BytecodeManager.incBytecodes(2);
                    return n6;
                }
            }
            BytecodeManager.incBytecodes(3);
            final long n7 = n - date.getDayOfMonth() + 1L;
            BytecodeManager.incBytecodes(5);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static LocalGregorianCalendar.Date getCalendarDate(final long fixedDate) {
        try {
            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
            BytecodeManager.incBytecodes(3);
            final LocalGregorianCalendar.Date calendarDate = jcal.newCalendarDate(no_TIMEZONE);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
            final LocalGregorianCalendar.Date date = calendarDate;
            BytecodeManager.incBytecodes(4);
            jcal2.getCalendarDateFromFixedDate(date, fixedDate);
            final LocalGregorianCalendar.Date date2 = calendarDate;
            BytecodeManager.incBytecodes(2);
            return date2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int monthLength(final int n, final int gregorianYear) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean gregorianLeapYear = CalendarUtils.isGregorianLeapYear(gregorianYear);
            BytecodeManager.incBytecodes(1);
            int n2;
            if (gregorianLeapYear) {
                n2 = GregorianCalendar.LEAP_MONTH_LENGTH[n];
                BytecodeManager.incBytecodes(4);
            }
            else {
                n2 = GregorianCalendar.MONTH_LENGTH[n];
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int monthLength(final int n) {
        try {
            final boolean $assertionsDisabled = JapaneseImperialCalendar.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final LocalGregorianCalendar.Date jdate = this.jdate;
                BytecodeManager.incBytecodes(3);
                final boolean normalized = jdate.isNormalized();
                BytecodeManager.incBytecodes(1);
                if (!normalized) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final LocalGregorianCalendar.Date jdate2 = this.jdate;
            BytecodeManager.incBytecodes(3);
            final boolean leapYear = jdate2.isLeapYear();
            BytecodeManager.incBytecodes(1);
            int n2;
            if (leapYear) {
                n2 = GregorianCalendar.LEAP_MONTH_LENGTH[n];
                BytecodeManager.incBytecodes(4);
            }
            else {
                n2 = GregorianCalendar.MONTH_LENGTH[n];
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int actualMonthLength() {
        try {
            final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
            final LocalGregorianCalendar.Date jdate = this.jdate;
            BytecodeManager.incBytecodes(4);
            int monthLength = jcal.getMonthLength(jdate);
            BytecodeManager.incBytecodes(1);
            final LocalGregorianCalendar.Date jdate2 = this.jdate;
            BytecodeManager.incBytecodes(3);
            final int transitionEraIndex = getTransitionEraIndex(jdate2);
            BytecodeManager.incBytecodes(1);
            final int n = transitionEraIndex;
            final int n2 = -1;
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                final long n3 = JapaneseImperialCalendar.sinceFixedDates[transitionEraIndex];
                BytecodeManager.incBytecodes(4);
                final Era era = JapaneseImperialCalendar.eras[transitionEraIndex];
                BytecodeManager.incBytecodes(4);
                final CalendarDate sinceDate = era.getSinceDate();
                BytecodeManager.incBytecodes(1);
                final long n4 = lcmp(n3, this.cachedFixedDate);
                BytecodeManager.incBytecodes(5);
                if (n4 <= 0) {
                    final int n5 = monthLength;
                    final CalendarDate calendarDate = sinceDate;
                    BytecodeManager.incBytecodes(3);
                    monthLength = n5 - (calendarDate.getDayOfMonth() - 1);
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final CalendarDate calendarDate2 = sinceDate;
                    BytecodeManager.incBytecodes(2);
                    monthLength = calendarDate2.getDayOfMonth() - 1;
                    BytecodeManager.incBytecodes(3);
                }
            }
            final int n6 = monthLength;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int getTransitionEraIndex(final LocalGregorianCalendar.Date date) {
        try {
            BytecodeManager.incBytecodes(2);
            int eraIndex = getEraIndex(date);
            BytecodeManager.incBytecodes(1);
            final Era era = JapaneseImperialCalendar.eras[eraIndex];
            BytecodeManager.incBytecodes(4);
            final CalendarDate sinceDate = era.getSinceDate();
            BytecodeManager.incBytecodes(1);
            final CalendarDate calendarDate = sinceDate;
            BytecodeManager.incBytecodes(2);
            final int year = calendarDate.getYear();
            BytecodeManager.incBytecodes(2);
            final int normalizedYear = date.getNormalizedYear();
            BytecodeManager.incBytecodes(1);
            if (year == normalizedYear) {
                final CalendarDate calendarDate2 = sinceDate;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int month = calendarDate2.getMonth();
                BytecodeManager.incBytecodes(2);
                final int month2 = date.getMonth();
                BytecodeManager.incBytecodes(1);
                if (month == month2) {
                    final int n = eraIndex;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
            }
            final int n2 = eraIndex;
            final int n3 = JapaneseImperialCalendar.eras.length - 1;
            BytecodeManager.incBytecodes(6);
            if (n2 < n3) {
                final Era era2 = JapaneseImperialCalendar.eras[++eraIndex];
                BytecodeManager.incBytecodes(5);
                final CalendarDate sinceDate2 = era2.getSinceDate();
                BytecodeManager.incBytecodes(1);
                final CalendarDate calendarDate3 = sinceDate2;
                BytecodeManager.incBytecodes(2);
                final int year2 = calendarDate3.getYear();
                BytecodeManager.incBytecodes(2);
                final int normalizedYear2 = date.getNormalizedYear();
                BytecodeManager.incBytecodes(1);
                if (year2 == normalizedYear2) {
                    final CalendarDate calendarDate4 = sinceDate2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int month3 = calendarDate4.getMonth();
                    BytecodeManager.incBytecodes(2);
                    final int month4 = date.getMonth();
                    BytecodeManager.incBytecodes(1);
                    if (month3 == month4) {
                        final int n4 = eraIndex;
                        BytecodeManager.incBytecodes(2);
                        return n4;
                    }
                }
            }
            final int n5 = -1;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isTransitionYear(final int n) {
        try {
            int n2 = JapaneseImperialCalendar.eras.length - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 <= 0) {
                    break;
                }
                final Era era = JapaneseImperialCalendar.eras[n2];
                BytecodeManager.incBytecodes(4);
                final CalendarDate sinceDate = era.getSinceDate();
                BytecodeManager.incBytecodes(1);
                final int year = sinceDate.getYear();
                BytecodeManager.incBytecodes(1);
                final int n4 = year;
                BytecodeManager.incBytecodes(3);
                if (n == n4) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n5 = year;
                BytecodeManager.incBytecodes(3);
                if (n > n5) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int getEraIndex(final LocalGregorianCalendar.Date date) {
        try {
            BytecodeManager.incBytecodes(2);
            final Era era = date.getEra();
            BytecodeManager.incBytecodes(1);
            int n = JapaneseImperialCalendar.eras.length - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 <= 0) {
                    final int n3 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n3;
                }
                final Era era2 = JapaneseImperialCalendar.eras[n];
                final Era era3 = era;
                BytecodeManager.incBytecodes(5);
                if (era2 == era3) {
                    final int n4 = n;
                    BytecodeManager.incBytecodes(2);
                    return n4;
                }
                --n;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private JapaneseImperialCalendar getNormalizedCalendar() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean fullyNormalized = this.isFullyNormalized();
            BytecodeManager.incBytecodes(1);
            JapaneseImperialCalendar japaneseImperialCalendar;
            if (fullyNormalized) {
                japaneseImperialCalendar = this;
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(2);
                japaneseImperialCalendar = (JapaneseImperialCalendar)this.clone();
                BytecodeManager.incBytecodes(2);
                final JapaneseImperialCalendar japaneseImperialCalendar2 = japaneseImperialCalendar;
                final boolean lenient = true;
                BytecodeManager.incBytecodes(3);
                japaneseImperialCalendar2.setLenient(lenient);
                final JapaneseImperialCalendar japaneseImperialCalendar3 = japaneseImperialCalendar;
                BytecodeManager.incBytecodes(2);
                japaneseImperialCalendar3.complete();
            }
            final JapaneseImperialCalendar japaneseImperialCalendar4 = japaneseImperialCalendar;
            BytecodeManager.incBytecodes(2);
            return japaneseImperialCalendar4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void pinDayOfMonth(final LocalGregorianCalendar.Date date) {
        try {
            BytecodeManager.incBytecodes(2);
            final int year = date.getYear();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int dayOfMonth = date.getDayOfMonth();
            BytecodeManager.incBytecodes(1);
            final int n = year;
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final int minimum = this.getMinimum(n2);
            BytecodeManager.incBytecodes(1);
            if (n != minimum) {
                final int dayOfMonth2 = 1;
                BytecodeManager.incBytecodes(3);
                date.setDayOfMonth(dayOfMonth2);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
                BytecodeManager.incBytecodes(3);
                jcal.normalize(date);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
                BytecodeManager.incBytecodes(3);
                final int monthLength = jcal2.getMonthLength(date);
                BytecodeManager.incBytecodes(1);
                final int n3 = dayOfMonth;
                final int n4 = monthLength;
                BytecodeManager.incBytecodes(3);
                if (n3 > n4) {
                    final int dayOfMonth3 = monthLength;
                    BytecodeManager.incBytecodes(3);
                    date.setDayOfMonth(dayOfMonth3);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int dayOfMonth4 = dayOfMonth;
                    BytecodeManager.incBytecodes(3);
                    date.setDayOfMonth(dayOfMonth4);
                    BytecodeManager.incBytecodes(1);
                }
                final LocalGregorianCalendar jcal3 = JapaneseImperialCalendar.jcal;
                BytecodeManager.incBytecodes(3);
                jcal3.normalize(date);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final LocalGregorianCalendar jcal4 = JapaneseImperialCalendar.jcal;
                final long n5 = Long.MIN_VALUE;
                BytecodeManager.incBytecodes(4);
                final TimeZone zone = this.getZone();
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date calendarDate = jcal4.getCalendarDate(n5, zone);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar jcal5 = JapaneseImperialCalendar.jcal;
                final long time = this.time;
                BytecodeManager.incBytecodes(5);
                final TimeZone zone2 = this.getZone();
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date calendarDate2 = jcal5.getCalendarDate(time, zone2);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date date2 = calendarDate2;
                BytecodeManager.incBytecodes(2);
                final long timeOfDay = date2.getTimeOfDay();
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date date3 = calendarDate2;
                final int localYear = 400;
                BytecodeManager.incBytecodes(3);
                date3.addYear(localYear);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date date4 = calendarDate2;
                BytecodeManager.incBytecodes(3);
                final int month = date.getMonth();
                BytecodeManager.incBytecodes(1);
                date4.setMonth(month);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date date5 = calendarDate2;
                final int dayOfMonth5 = 1;
                BytecodeManager.incBytecodes(3);
                date5.setDayOfMonth(dayOfMonth5);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar jcal6 = JapaneseImperialCalendar.jcal;
                final LocalGregorianCalendar.Date date6 = calendarDate2;
                BytecodeManager.incBytecodes(3);
                jcal6.normalize(date6);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar jcal7 = JapaneseImperialCalendar.jcal;
                final LocalGregorianCalendar.Date date7 = calendarDate2;
                BytecodeManager.incBytecodes(3);
                final int monthLength2 = jcal7.getMonthLength(date7);
                BytecodeManager.incBytecodes(1);
                final int n6 = dayOfMonth;
                final int n7 = monthLength2;
                BytecodeManager.incBytecodes(3);
                if (n6 > n7) {
                    final LocalGregorianCalendar.Date date8 = calendarDate2;
                    final int dayOfMonth6 = monthLength2;
                    BytecodeManager.incBytecodes(3);
                    date8.setDayOfMonth(dayOfMonth6);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int n8 = dayOfMonth;
                    final LocalGregorianCalendar.Date date9 = calendarDate;
                    BytecodeManager.incBytecodes(3);
                    final int dayOfMonth7 = date9.getDayOfMonth();
                    BytecodeManager.incBytecodes(1);
                    if (n8 < dayOfMonth7) {
                        final LocalGregorianCalendar.Date date10 = calendarDate2;
                        final LocalGregorianCalendar.Date date11 = calendarDate;
                        BytecodeManager.incBytecodes(3);
                        final int dayOfMonth8 = date11.getDayOfMonth();
                        BytecodeManager.incBytecodes(1);
                        date10.setDayOfMonth(dayOfMonth8);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final LocalGregorianCalendar.Date date12 = calendarDate2;
                        final int dayOfMonth9 = dayOfMonth;
                        BytecodeManager.incBytecodes(3);
                        date12.setDayOfMonth(dayOfMonth9);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final LocalGregorianCalendar.Date date13 = calendarDate2;
                BytecodeManager.incBytecodes(2);
                final int dayOfMonth10 = date13.getDayOfMonth();
                final LocalGregorianCalendar.Date date14 = calendarDate;
                BytecodeManager.incBytecodes(2);
                final int dayOfMonth11 = date14.getDayOfMonth();
                BytecodeManager.incBytecodes(1);
                if (dayOfMonth10 == dayOfMonth11) {
                    final long n9 = timeOfDay;
                    final LocalGregorianCalendar.Date date15 = calendarDate;
                    BytecodeManager.incBytecodes(3);
                    final long n10 = lcmp(n9, date15.getTimeOfDay());
                    BytecodeManager.incBytecodes(2);
                    if (n10 < 0) {
                        final LocalGregorianCalendar.Date date16 = calendarDate2;
                        final int a = dayOfMonth + 1;
                        final int b = monthLength2;
                        BytecodeManager.incBytecodes(6);
                        final int min = Math.min(a, b);
                        BytecodeManager.incBytecodes(1);
                        date16.setDayOfMonth(min);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int year2 = year;
                final LocalGregorianCalendar.Date date17 = calendarDate2;
                BytecodeManager.incBytecodes(4);
                final int month2 = date17.getMonth();
                final LocalGregorianCalendar.Date date18 = calendarDate2;
                BytecodeManager.incBytecodes(2);
                final int dayOfMonth12 = date18.getDayOfMonth();
                BytecodeManager.incBytecodes(1);
                date.setDate(year2, month2, dayOfMonth12);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int getRolledValue(final int n, int n2, final int n3, final int n4) {
        try {
            final boolean $assertionsDisabled = JapaneseImperialCalendar.$assertionsDisabled;
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
            final boolean $assertionsDisabled2 = JapaneseImperialCalendar.$assertionsDisabled;
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
                internalGet = JapaneseImperialCalendar.eras.length - 1;
                BytecodeManager.incBytecodes(4);
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
            final LocalGregorianCalendar.Date jdate = this.jdate;
            BytecodeManager.incBytecodes(3);
            if (jdate == null) {
                final LocalGregorianCalendar jcal = JapaneseImperialCalendar.jcal;
                BytecodeManager.incBytecodes(4);
                final TimeZone zone = this.getZone();
                BytecodeManager.incBytecodes(1);
                this.jdate = jcal.newCalendarDate(zone);
                BytecodeManager.incBytecodes(1);
                this.cachedFixedDate = Long.MIN_VALUE;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<JapaneseImperialCalendar> clazz = JapaneseImperialCalendar.class;
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
            final String calendarName = "japanese";
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            jcal = (LocalGregorianCalendar)CalendarSystem.forName(calendarName);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            gcal = CalendarSystem.getGregorianCalendar();
            BytecodeManager.incBytecodes(1);
            final String name = "BeforeMeiji";
            final String abbr = "BM";
            final long since = Long.MIN_VALUE;
            final boolean localTime = false;
            BytecodeManager.incBytecodes(7);
            BEFORE_MEIJI_ERA = new Era(name, abbr, since, localTime);
            BytecodeManager.incBytecodes(1);
            MIN_VALUES = new int[] { 0, -292275055, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, -46800000, 0 };
            BytecodeManager.incBytecodes(70);
            LEAST_MAX_VALUES = new int[] { 0, 0, 0, 0, 4, 28, 0, 7, 4, 1, 11, 23, 59, 59, 999, 50400000, 1200000 };
            BytecodeManager.incBytecodes(70);
            MAX_VALUES = new int[] { 0, 292278994, 11, 53, 6, 31, 366, 7, 6, 1, 11, 23, 59, 59, 999, 50400000, 7200000 };
            BytecodeManager.incBytecodes(70);
            final LocalGregorianCalendar jcal2 = JapaneseImperialCalendar.jcal;
            BytecodeManager.incBytecodes(2);
            final Era[] eras2 = jcal2.getEras();
            BytecodeManager.incBytecodes(1);
            final int n = eras2.length + 1;
            BytecodeManager.incBytecodes(5);
            eras = new Era[n];
            BytecodeManager.incBytecodes(2);
            sinceFixedDates = new long[n];
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            final long[] sinceFixedDates2 = JapaneseImperialCalendar.sinceFixedDates;
            final int n3 = n2;
            final Gregorian gcal2 = JapaneseImperialCalendar.gcal;
            final Era before_MEIJI_ERA = JapaneseImperialCalendar.BEFORE_MEIJI_ERA;
            BytecodeManager.incBytecodes(5);
            final CalendarDate sinceDate = before_MEIJI_ERA.getSinceDate();
            BytecodeManager.incBytecodes(1);
            sinceFixedDates2[n3] = gcal2.getFixedDate(sinceDate);
            BytecodeManager.incBytecodes(1);
            JapaneseImperialCalendar.eras[n2++] = JapaneseImperialCalendar.BEFORE_MEIJI_ERA;
            BytecodeManager.incBytecodes(5);
            final Era[] array = eras2;
            final int length = array.length;
            int n4 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n5 = n4;
                final int n6 = length;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n6) {
                    break;
                }
                final Era era = array[n4];
                BytecodeManager.incBytecodes(4);
                final Era era2 = era;
                BytecodeManager.incBytecodes(2);
                final CalendarDate sinceDate2 = era2.getSinceDate();
                BytecodeManager.incBytecodes(1);
                final long[] sinceFixedDates3 = JapaneseImperialCalendar.sinceFixedDates;
                final int n7 = n2;
                final Gregorian gcal3 = JapaneseImperialCalendar.gcal;
                final CalendarDate date = sinceDate2;
                BytecodeManager.incBytecodes(5);
                sinceFixedDates3[n7] = gcal3.getFixedDate(date);
                BytecodeManager.incBytecodes(1);
                JapaneseImperialCalendar.eras[n2++] = era;
                BytecodeManager.incBytecodes(5);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            JapaneseImperialCalendar.LEAST_MAX_VALUES[0] = (JapaneseImperialCalendar.MAX_VALUES[0] = JapaneseImperialCalendar.eras.length - 1);
            BytecodeManager.incBytecodes(11);
            int min = Integer.MAX_VALUE;
            BytecodeManager.incBytecodes(2);
            int n8 = Integer.MAX_VALUE;
            BytecodeManager.incBytecodes(2);
            final Gregorian gcal4 = JapaneseImperialCalendar.gcal;
            final TimeZone no_TIMEZONE = TimeZone.NO_TIMEZONE;
            BytecodeManager.incBytecodes(3);
            final Gregorian.Date calendarDate = gcal4.newCalendarDate(no_TIMEZONE);
            BytecodeManager.incBytecodes(1);
            int n9 = 1;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int length2 = JapaneseImperialCalendar.eras.length;
                BytecodeManager.incBytecodes(4);
                if (n10 >= length2) {
                    break;
                }
                final long n11 = JapaneseImperialCalendar.sinceFixedDates[n9];
                BytecodeManager.incBytecodes(4);
                final Era era3 = JapaneseImperialCalendar.eras[n9];
                BytecodeManager.incBytecodes(4);
                final CalendarDate sinceDate3 = era3.getSinceDate();
                BytecodeManager.incBytecodes(1);
                final Gregorian.Date date2 = calendarDate;
                final CalendarDate calendarDate2 = sinceDate3;
                BytecodeManager.incBytecodes(3);
                final int year = calendarDate2.getYear();
                final int month = 1;
                final int dayOfMonth = 1;
                BytecodeManager.incBytecodes(3);
                date2.setDate(year, month, dayOfMonth);
                BytecodeManager.incBytecodes(1);
                final Gregorian gcal5 = JapaneseImperialCalendar.gcal;
                final Gregorian.Date date3 = calendarDate;
                BytecodeManager.incBytecodes(3);
                final long fixedDate = gcal5.getFixedDate(date3);
                BytecodeManager.incBytecodes(1);
                final long n12 = lcmp(n11, fixedDate);
                BytecodeManager.incBytecodes(4);
                if (n12 != 0) {
                    final int a = (int)(n11 - fixedDate) + 1;
                    final int b = n8;
                    BytecodeManager.incBytecodes(8);
                    n8 = Math.min(a, b);
                    BytecodeManager.incBytecodes(1);
                }
                final Gregorian.Date date4 = calendarDate;
                final CalendarDate calendarDate3 = sinceDate3;
                BytecodeManager.incBytecodes(3);
                final int year2 = calendarDate3.getYear();
                final int month2 = 12;
                final int dayOfMonth2 = 31;
                BytecodeManager.incBytecodes(3);
                date4.setDate(year2, month2, dayOfMonth2);
                BytecodeManager.incBytecodes(1);
                final Gregorian gcal6 = JapaneseImperialCalendar.gcal;
                final Gregorian.Date date5 = calendarDate;
                BytecodeManager.incBytecodes(3);
                final long fixedDate2 = gcal6.getFixedDate(date5);
                BytecodeManager.incBytecodes(1);
                final long n13 = lcmp(n11, fixedDate2);
                BytecodeManager.incBytecodes(4);
                if (n13 != 0) {
                    final int a2 = (int)(fixedDate2 - n11) + 1;
                    final int b2 = n8;
                    BytecodeManager.incBytecodes(8);
                    n8 = Math.min(a2, b2);
                    BytecodeManager.incBytecodes(1);
                }
                final long n14 = n11 - 1L;
                BytecodeManager.incBytecodes(4);
                final LocalGregorianCalendar.Date calendarDate4 = getCalendarDate(n14);
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date date6 = calendarDate4;
                BytecodeManager.incBytecodes(2);
                int year3 = date6.getYear();
                BytecodeManager.incBytecodes(1);
                final LocalGregorianCalendar.Date date7 = calendarDate4;
                BytecodeManager.incBytecodes(2);
                final int month3 = date7.getMonth();
                final int n15 = 1;
                BytecodeManager.incBytecodes(2);
                Label_1009: {
                    if (month3 == n15) {
                        final LocalGregorianCalendar.Date date8 = calendarDate4;
                        BytecodeManager.incBytecodes(2);
                        final int dayOfMonth3 = date8.getDayOfMonth();
                        final int n16 = 1;
                        BytecodeManager.incBytecodes(2);
                        if (dayOfMonth3 == n16) {
                            break Label_1009;
                        }
                    }
                    --year3;
                    BytecodeManager.incBytecodes(1);
                }
                final int a3 = year3;
                final int b3 = min;
                BytecodeManager.incBytecodes(3);
                min = Math.min(a3, b3);
                BytecodeManager.incBytecodes(1);
                ++n9;
                BytecodeManager.incBytecodes(2);
            }
            JapaneseImperialCalendar.LEAST_MAX_VALUES[1] = min;
            BytecodeManager.incBytecodes(4);
            JapaneseImperialCalendar.LEAST_MAX_VALUES[6] = n8;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
