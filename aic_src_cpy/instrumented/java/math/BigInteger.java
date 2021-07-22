// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.math;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import instrumented.java.util.Arrays;
import instrumented.java.util.concurrent.ThreadLocalRandom;
import instrumented.java.util.Random;
import aic2021.engine.BytecodeManager;
import java.io.ObjectStreamField;

public class BigInteger extends Number implements Comparable<BigInteger>
{
    final int signum;
    final int[] mag;
    @Deprecated
    private int bitCount;
    @Deprecated
    private int bitLength;
    @Deprecated
    private int lowestSetBit;
    @Deprecated
    private int firstNonzeroIntNum;
    static final long LONG_MASK = 4294967295L;
    private static final int MAX_MAG_LENGTH = 67108864;
    private static final int PRIME_SEARCH_BIT_LENGTH_LIMIT = 500000000;
    private static final int KARATSUBA_THRESHOLD = 80;
    private static final int TOOM_COOK_THRESHOLD = 240;
    private static final int KARATSUBA_SQUARE_THRESHOLD = 128;
    private static final int TOOM_COOK_SQUARE_THRESHOLD = 216;
    static final int BURNIKEL_ZIEGLER_THRESHOLD = 80;
    static final int BURNIKEL_ZIEGLER_OFFSET = 40;
    private static final int SCHOENHAGE_BASE_CONVERSION_THRESHOLD = 20;
    private static final int MULTIPLY_SQUARE_THRESHOLD = 20;
    private static long[] bitsPerDigit;
    private static final int SMALL_PRIME_THRESHOLD = 95;
    private static final int DEFAULT_PRIME_CERTAINTY = 100;
    private static final BigInteger SMALL_PRIME_PRODUCT;
    private static final int MAX_CONSTANT = 16;
    private static BigInteger[] posConst;
    private static BigInteger[] negConst;
    private static volatile BigInteger[][] powerCache;
    private static final double[] logCache;
    private static final double LOG_TWO;
    public static final BigInteger ZERO;
    public static final BigInteger ONE;
    private static final BigInteger TWO;
    private static final BigInteger NEGATIVE_ONE;
    public static final BigInteger TEN;
    static int[] bnExpModThreshTable;
    private static String[] zeros;
    private static int[] digitsPerLong;
    private static BigInteger[] longRadix;
    private static int[] digitsPerInt;
    private static int[] intRadix;
    private static final long serialVersionUID = -8287574255936472291L;
    private static final ObjectStreamField[] serialPersistentFields;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public BigInteger(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length == 0) {
                final String s = "Zero length BigInteger";
                BytecodeManager.incBytecodes(4);
                final NumberFormatException ex = new NumberFormatException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final byte b = array[0];
            BytecodeManager.incBytecodes(4);
            if (b < 0) {
                BytecodeManager.incBytecodes(3);
                this.mag = makePositive(array);
                BytecodeManager.incBytecodes(1);
                this.signum = -1;
                BytecodeManager.incBytecodes(4);
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.mag = stripLeadingZeroBytes(array);
                BytecodeManager.incBytecodes(1);
                final int length2 = this.mag.length;
                BytecodeManager.incBytecodes(5);
                int signum;
                if (length2 == 0) {
                    signum = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    signum = 1;
                    BytecodeManager.incBytecodes(1);
                }
                this.signum = signum;
                BytecodeManager.incBytecodes(1);
            }
            final int length3 = this.mag.length;
            final int n = 67108864;
            BytecodeManager.incBytecodes(5);
            if (length3 >= n) {
                BytecodeManager.incBytecodes(2);
                this.checkRange();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger(final int[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length == 0) {
                final String s = "Zero length BigInteger";
                BytecodeManager.incBytecodes(4);
                final NumberFormatException ex = new NumberFormatException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n = array[0];
            BytecodeManager.incBytecodes(4);
            if (n < 0) {
                BytecodeManager.incBytecodes(3);
                this.mag = makePositive(array);
                BytecodeManager.incBytecodes(1);
                this.signum = -1;
                BytecodeManager.incBytecodes(4);
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.mag = trustedStripLeadingZeroInts(array);
                BytecodeManager.incBytecodes(1);
                final int length2 = this.mag.length;
                BytecodeManager.incBytecodes(5);
                int signum;
                if (length2 == 0) {
                    signum = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    signum = 1;
                    BytecodeManager.incBytecodes(1);
                }
                this.signum = signum;
                BytecodeManager.incBytecodes(1);
            }
            final int length3 = this.mag.length;
            final int n2 = 67108864;
            BytecodeManager.incBytecodes(5);
            if (length3 >= n2) {
                BytecodeManager.incBytecodes(2);
                this.checkRange();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger(final int signum, final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.mag = stripLeadingZeroBytes(array);
            BytecodeManager.incBytecodes(1);
            final int n = -1;
            BytecodeManager.incBytecodes(3);
            if (signum >= n) {
                final int n2 = 1;
                BytecodeManager.incBytecodes(3);
                if (signum <= n2) {
                    final int length = this.mag.length;
                    BytecodeManager.incBytecodes(4);
                    if (length == 0) {
                        this.signum = 0;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        if (signum == 0) {
                            final String s = "signum-magnitude mismatch";
                            BytecodeManager.incBytecodes(4);
                            final NumberFormatException ex = new NumberFormatException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        this.signum = signum;
                        BytecodeManager.incBytecodes(3);
                    }
                    final int length2 = this.mag.length;
                    final int n3 = 67108864;
                    BytecodeManager.incBytecodes(5);
                    if (length2 >= n3) {
                        BytecodeManager.incBytecodes(2);
                        this.checkRange();
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            final String s2 = "Invalid signum value";
            BytecodeManager.incBytecodes(4);
            final NumberFormatException ex2 = new NumberFormatException(s2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger(final int signum, final int[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.mag = stripLeadingZeroInts(array);
            BytecodeManager.incBytecodes(1);
            final int n = -1;
            BytecodeManager.incBytecodes(3);
            if (signum >= n) {
                final int n2 = 1;
                BytecodeManager.incBytecodes(3);
                if (signum <= n2) {
                    final int length = this.mag.length;
                    BytecodeManager.incBytecodes(4);
                    if (length == 0) {
                        this.signum = 0;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        if (signum == 0) {
                            final String s = "signum-magnitude mismatch";
                            BytecodeManager.incBytecodes(4);
                            final NumberFormatException ex = new NumberFormatException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        this.signum = signum;
                        BytecodeManager.incBytecodes(3);
                    }
                    final int length2 = this.mag.length;
                    final int n3 = 67108864;
                    BytecodeManager.incBytecodes(5);
                    if (length2 >= n3) {
                        BytecodeManager.incBytecodes(2);
                        this.checkRange();
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            final String s2 = "Invalid signum value";
            BytecodeManager.incBytecodes(4);
            final NumberFormatException ex2 = new NumberFormatException(s2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger(final String s, final int radix) {
        try {
            BytecodeManager.incBytecodes(2);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            final int n2 = 2;
            BytecodeManager.incBytecodes(3);
            if (radix >= n2) {
                final int n3 = 36;
                BytecodeManager.incBytecodes(3);
                if (radix <= n3) {
                    final int n4 = length;
                    BytecodeManager.incBytecodes(2);
                    if (n4 == 0) {
                        final String s2 = "Zero length BigInteger";
                        BytecodeManager.incBytecodes(4);
                        final NumberFormatException ex = new NumberFormatException(s2);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    int signum = 1;
                    BytecodeManager.incBytecodes(2);
                    final int ch = 45;
                    BytecodeManager.incBytecodes(3);
                    final int lastIndex = s.lastIndexOf(ch);
                    BytecodeManager.incBytecodes(1);
                    final int ch2 = 43;
                    BytecodeManager.incBytecodes(3);
                    final int lastIndex2 = s.lastIndexOf(ch2);
                    BytecodeManager.incBytecodes(1);
                    final int n5 = lastIndex;
                    BytecodeManager.incBytecodes(2);
                    Label_0262: {
                        if (n5 >= 0) {
                            final int n6 = lastIndex;
                            BytecodeManager.incBytecodes(2);
                            if (n6 == 0) {
                                final int n7 = lastIndex2;
                                BytecodeManager.incBytecodes(2);
                                if (n7 < 0) {
                                    signum = -1;
                                    BytecodeManager.incBytecodes(2);
                                    n = 1;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0262;
                                }
                            }
                            final String s3 = "Illegal embedded sign character";
                            BytecodeManager.incBytecodes(4);
                            final NumberFormatException ex2 = new NumberFormatException(s3);
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final int n8 = lastIndex2;
                        BytecodeManager.incBytecodes(2);
                        if (n8 >= 0) {
                            final int n9 = lastIndex2;
                            BytecodeManager.incBytecodes(2);
                            if (n9 != 0) {
                                final String s4 = "Illegal embedded sign character";
                                BytecodeManager.incBytecodes(4);
                                final NumberFormatException ex3 = new NumberFormatException(s4);
                                BytecodeManager.incBytecodes(1);
                                throw ex3;
                            }
                            n = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    final int n10 = n;
                    final int n11 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n10 == n11) {
                        final String s5 = "Zero length BigInteger";
                        BytecodeManager.incBytecodes(4);
                        final NumberFormatException ex4 = new NumberFormatException(s5);
                        BytecodeManager.incBytecodes(1);
                        throw ex4;
                    }
                    while (true) {
                        final int n12 = n;
                        final int n13 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n12 >= n13) {
                            break;
                        }
                        final int index = n;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final char char1 = s.charAt(index);
                        BytecodeManager.incBytecodes(2);
                        final int digit = Character.digit(char1, radix);
                        BytecodeManager.incBytecodes(1);
                        if (digit != 0) {
                            break;
                        }
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n14 = n;
                    final int n15 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n14 == n15) {
                        this.signum = 0;
                        BytecodeManager.incBytecodes(3);
                        this.mag = BigInteger.ZERO.mag;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final int n16 = length - n;
                    BytecodeManager.incBytecodes(4);
                    this.signum = signum;
                    BytecodeManager.incBytecodes(3);
                    final long n17 = (n16 * BigInteger.bitsPerDigit[radix] >>> 10) + 1L;
                    BytecodeManager.incBytecodes(11);
                    final long n18 = lcmp(n17 + 31L, 4294967296L);
                    BytecodeManager.incBytecodes(6);
                    if (n18 >= 0) {
                        BytecodeManager.incBytecodes(1);
                        reportOverflow();
                    }
                    final int n19 = (int)(n17 + 31L) >>> 5;
                    BytecodeManager.incBytecodes(7);
                    final int[] array = new int[n19];
                    BytecodeManager.incBytecodes(2);
                    int n20 = n16 % BigInteger.digitsPerInt[radix];
                    BytecodeManager.incBytecodes(6);
                    final int n21 = n20;
                    BytecodeManager.incBytecodes(2);
                    if (n21 == 0) {
                        n20 = BigInteger.digitsPerInt[radix];
                        BytecodeManager.incBytecodes(4);
                    }
                    final int beginIndex = n;
                    int n22;
                    final int endIndex = n22 = n + n20;
                    BytecodeManager.incBytecodes(8);
                    final String substring = s.substring(beginIndex, endIndex);
                    BytecodeManager.incBytecodes(1);
                    final int[] array2 = array;
                    final int n23 = n19 - 1;
                    final String s6 = substring;
                    BytecodeManager.incBytecodes(7);
                    array2[n23] = Integer.parseInt(s6, radix);
                    BytecodeManager.incBytecodes(1);
                    final int n24 = array[n19 - 1];
                    BytecodeManager.incBytecodes(6);
                    if (n24 < 0) {
                        final String s7 = "Illegal digit";
                        BytecodeManager.incBytecodes(4);
                        final NumberFormatException ex5 = new NumberFormatException(s7);
                        BytecodeManager.incBytecodes(1);
                        throw ex5;
                    }
                    final int n25 = BigInteger.intRadix[radix];
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n26 = n22;
                        final int n27 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n26 >= n27) {
                            final int[] array3 = array;
                            BytecodeManager.incBytecodes(3);
                            this.mag = trustedStripLeadingZeroInts(array3);
                            BytecodeManager.incBytecodes(1);
                            final int length2 = this.mag.length;
                            final int n28 = 67108864;
                            BytecodeManager.incBytecodes(5);
                            if (length2 >= n28) {
                                BytecodeManager.incBytecodes(2);
                                this.checkRange();
                            }
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final int beginIndex2 = n22;
                        final int endIndex2 = n22 += BigInteger.digitsPerInt[radix];
                        BytecodeManager.incBytecodes(10);
                        final String substring2 = s.substring(beginIndex2, endIndex2);
                        BytecodeManager.incBytecodes(1);
                        final String s8 = substring2;
                        BytecodeManager.incBytecodes(3);
                        final int int1 = Integer.parseInt(s8, radix);
                        BytecodeManager.incBytecodes(1);
                        final int n29 = int1;
                        BytecodeManager.incBytecodes(2);
                        if (n29 < 0) {
                            final String s9 = "Illegal digit";
                            BytecodeManager.incBytecodes(4);
                            final NumberFormatException ex6 = new NumberFormatException(s9);
                            BytecodeManager.incBytecodes(1);
                            throw ex6;
                        }
                        final int[] array4 = array;
                        final int n30 = n25;
                        final int n31 = int1;
                        BytecodeManager.incBytecodes(4);
                        destructiveMulAdd(array4, n30, n31);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final String s10 = "Radix out of range";
            BytecodeManager.incBytecodes(4);
            final NumberFormatException ex7 = new NumberFormatException(s10);
            BytecodeManager.incBytecodes(1);
            throw ex7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BigInteger(final char[] array, final int signum, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n) {
                    break;
                }
                final char ch = array[n2];
                final int radix = 10;
                BytecodeManager.incBytecodes(5);
                final int digit = Character.digit(ch, radix);
                BytecodeManager.incBytecodes(1);
                if (digit != 0) {
                    break;
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = n2;
            BytecodeManager.incBytecodes(3);
            if (n4 == n) {
                this.signum = 0;
                BytecodeManager.incBytecodes(3);
                this.mag = BigInteger.ZERO.mag;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n5 = n - n2;
            BytecodeManager.incBytecodes(4);
            this.signum = signum;
            BytecodeManager.incBytecodes(3);
            final int n6 = 10;
            BytecodeManager.incBytecodes(3);
            int n7;
            if (n < n6) {
                n7 = 1;
                BytecodeManager.incBytecodes(3);
            }
            else {
                final long n8 = (n5 * BigInteger.bitsPerDigit[10] >>> 10) + 1L;
                BytecodeManager.incBytecodes(11);
                final long n9 = lcmp(n8 + 31L, 4294967296L);
                BytecodeManager.incBytecodes(6);
                if (n9 >= 0) {
                    BytecodeManager.incBytecodes(1);
                    reportOverflow();
                }
                n7 = (int)(n8 + 31L) >>> 5;
                BytecodeManager.incBytecodes(7);
            }
            final int[] array2 = new int[n7];
            BytecodeManager.incBytecodes(2);
            int n10 = n5 % BigInteger.digitsPerInt[10];
            BytecodeManager.incBytecodes(6);
            final int n11 = n10;
            BytecodeManager.incBytecodes(2);
            if (n11 == 0) {
                n10 = BigInteger.digitsPerInt[10];
                BytecodeManager.incBytecodes(4);
            }
            final int[] array3 = array2;
            final int n12 = n7 - 1;
            final int n13 = n2;
            int n15;
            final int n14 = n15 = n2 + n10;
            BytecodeManager.incBytecodes(13);
            array3[n12] = this.parseInt(array, n13, n14);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n16 = n15;
                BytecodeManager.incBytecodes(3);
                if (n16 >= n) {
                    break;
                }
                final int n17 = n15;
                final int n18 = n15 += BigInteger.digitsPerInt[10];
                BytecodeManager.incBytecodes(11);
                final int int1 = this.parseInt(array, n17, n18);
                BytecodeManager.incBytecodes(1);
                final int[] array4 = array2;
                final int n19 = BigInteger.intRadix[10];
                final int n20 = int1;
                BytecodeManager.incBytecodes(6);
                destructiveMulAdd(array4, n19, n20);
                BytecodeManager.incBytecodes(1);
            }
            final int[] array5 = array2;
            BytecodeManager.incBytecodes(3);
            this.mag = trustedStripLeadingZeroInts(array5);
            BytecodeManager.incBytecodes(1);
            final int length = this.mag.length;
            final int n21 = 67108864;
            BytecodeManager.incBytecodes(5);
            if (length >= n21) {
                BytecodeManager.incBytecodes(2);
                this.checkRange();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int parseInt(final char[] array, int n, final int n2) {
        try {
            final char ch = array[n++];
            final int radix = 10;
            BytecodeManager.incBytecodes(6);
            int digit = Character.digit(ch, radix);
            BytecodeManager.incBytecodes(1);
            final int n3 = digit;
            final int n4 = -1;
            BytecodeManager.incBytecodes(3);
            if (n3 == n4) {
                BytecodeManager.incBytecodes(6);
                final String s = new String(array);
                BytecodeManager.incBytecodes(1);
                final NumberFormatException ex = new NumberFormatException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            int n5 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                BytecodeManager.incBytecodes(3);
                if (n6 >= n2) {
                    final int n7 = digit;
                    BytecodeManager.incBytecodes(2);
                    return n7;
                }
                final char ch2 = array[n5];
                final int radix2 = 10;
                BytecodeManager.incBytecodes(5);
                final int digit2 = Character.digit(ch2, radix2);
                BytecodeManager.incBytecodes(1);
                final int n8 = digit2;
                final int n9 = -1;
                BytecodeManager.incBytecodes(3);
                if (n8 == n9) {
                    BytecodeManager.incBytecodes(6);
                    final String s2 = new String(array);
                    BytecodeManager.incBytecodes(1);
                    final NumberFormatException ex2 = new NumberFormatException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                digit = 10 * digit + digit2;
                BytecodeManager.incBytecodes(6);
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void destructiveMulAdd(final int[] array, final int n, final int n2) {
        try {
            final long n3 = (long)n & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final long n4 = (long)n2 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            long n5 = 0L;
            BytecodeManager.incBytecodes(2);
            int n6 = length - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                if (n7 < 0) {
                    break;
                }
                final long n8 = n3 * ((long)array[n6] & 0xFFFFFFFFL) + n5;
                BytecodeManager.incBytecodes(11);
                array[n6] = (int)n8;
                BytecodeManager.incBytecodes(5);
                n5 = n8 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n6;
                BytecodeManager.incBytecodes(2);
            }
            final long n9 = ((long)array[length - 1] & 0xFFFFFFFFL) + n4;
            BytecodeManager.incBytecodes(11);
            array[length - 1] = (int)n9;
            BytecodeManager.incBytecodes(7);
            long n10 = n9 >>> 32;
            BytecodeManager.incBytecodes(4);
            int n11 = length - 2;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n12 = n11;
                BytecodeManager.incBytecodes(2);
                if (n12 < 0) {
                    break;
                }
                final long n13 = ((long)array[n11] & 0xFFFFFFFFL) + n10;
                BytecodeManager.incBytecodes(9);
                array[n11] = (int)n13;
                BytecodeManager.incBytecodes(5);
                n10 = n13 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n11;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger(final String s) {
        try {
            final int n = 10;
            BytecodeManager.incBytecodes(4);
            this(s, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger(final int n, final Random random) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(5);
            final byte[] randomBits = randomBits(n, random);
            BytecodeManager.incBytecodes(1);
            this(n2, randomBits);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static byte[] randomBits(final int n, final Random random) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "numBits must be non-negative";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = (int)((n + 7L) / 8L);
            BytecodeManager.incBytecodes(8);
            final byte[] array = new byte[n2];
            BytecodeManager.incBytecodes(2);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 > 0) {
                final byte[] array2 = array;
                BytecodeManager.incBytecodes(3);
                random.nextBytes(array2);
                final int n4 = 8 * n2 - n;
                BytecodeManager.incBytecodes(6);
                final byte[] array3 = array;
                final int n5 = 0;
                array3[n5] &= (byte)((1 << 8 - n4) - 1);
                BytecodeManager.incBytecodes(14);
            }
            final byte[] array4 = array;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger(final int n, final int n2, final Random random) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n3 = 2;
            BytecodeManager.incBytecodes(3);
            if (n < n3) {
                final String s = "bitLength < 2";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n4 = 95;
            BytecodeManager.incBytecodes(3);
            BigInteger bigInteger;
            if (n < n4) {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                bigInteger = smallPrime(n, n2, random);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                bigInteger = largePrime(n, n2, random);
            }
            final BigInteger bigInteger2 = bigInteger;
            BytecodeManager.incBytecodes(1);
            this.signum = 1;
            BytecodeManager.incBytecodes(3);
            this.mag = bigInteger2.mag;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BigInteger probablePrime(final int n, final Random random) {
        try {
            final int n2 = 2;
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final String s = "bitLength < 2";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = 95;
            BytecodeManager.incBytecodes(3);
            BigInteger bigInteger;
            if (n < n3) {
                final int n4 = 100;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                bigInteger = smallPrime(n, n4, random);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n5 = 100;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                bigInteger = largePrime(n, n5, random);
            }
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger smallPrime(final int n, final int n2, final Random random) {
        try {
            final int n3 = n + 31 >>> 5;
            BytecodeManager.incBytecodes(6);
            final int[] array = new int[n3];
            BytecodeManager.incBytecodes(2);
            final int n4 = 1 << (n + 31 & 0x1F);
            BytecodeManager.incBytecodes(8);
            final int n5 = (n4 << 1) - 1;
            BytecodeManager.incBytecodes(6);
            while (true) {
                int n6 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    final int n8 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        break;
                    }
                    final int[] array2 = array;
                    final int n9 = n6;
                    BytecodeManager.incBytecodes(4);
                    array2[n9] = random.nextInt();
                    BytecodeManager.incBytecodes(1);
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
                array[0] = ((array[0] & n5) | n4);
                BytecodeManager.incBytecodes(10);
                final int n10 = 2;
                BytecodeManager.incBytecodes(3);
                if (n > n10) {
                    final int[] array3 = array;
                    final int n11 = n3 - 1;
                    array3[n11] |= 0x1;
                    BytecodeManager.incBytecodes(9);
                }
                final int[] array4 = array;
                final int n12 = 1;
                BytecodeManager.incBytecodes(5);
                final BigInteger bigInteger = new BigInteger(array4, n12);
                BytecodeManager.incBytecodes(1);
                final int n13 = 6;
                BytecodeManager.incBytecodes(3);
                if (n > n13) {
                    final BigInteger bigInteger2 = bigInteger;
                    final BigInteger small_PRIME_PRODUCT = BigInteger.SMALL_PRIME_PRODUCT;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger remainder = bigInteger2.remainder(small_PRIME_PRODUCT);
                    BytecodeManager.incBytecodes(1);
                    final long longValue = remainder.longValue();
                    BytecodeManager.incBytecodes(1);
                    final long n14 = lcmp(longValue % 3L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n14 == 0) {
                        continue;
                    }
                    final long n15 = lcmp(longValue % 5L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n15 == 0) {
                        continue;
                    }
                    final long n16 = lcmp(longValue % 7L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n16 == 0) {
                        continue;
                    }
                    final long n17 = lcmp(longValue % 11L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n17 == 0) {
                        continue;
                    }
                    final long n18 = lcmp(longValue % 13L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n18 == 0) {
                        continue;
                    }
                    final long n19 = lcmp(longValue % 17L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n19 == 0) {
                        continue;
                    }
                    final long n20 = lcmp(longValue % 19L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n20 == 0) {
                        continue;
                    }
                    final long n21 = lcmp(longValue % 23L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n21 == 0) {
                        continue;
                    }
                    final long n22 = lcmp(longValue % 29L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n22 == 0) {
                        continue;
                    }
                    final long n23 = lcmp(longValue % 31L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n23 == 0) {
                        continue;
                    }
                    final long n24 = lcmp(longValue % 37L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n24 == 0) {
                        continue;
                    }
                    final long n25 = lcmp(longValue % 41L, 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n25 == 0) {
                        BytecodeManager.incBytecodes(1);
                        continue;
                    }
                }
                final int n26 = 4;
                BytecodeManager.incBytecodes(3);
                if (n < n26) {
                    final BigInteger bigInteger3 = bigInteger;
                    BytecodeManager.incBytecodes(2);
                    return bigInteger3;
                }
                final BigInteger bigInteger4 = bigInteger;
                BytecodeManager.incBytecodes(4);
                final boolean primeToCertainty = bigInteger4.primeToCertainty(n2, random);
                BytecodeManager.incBytecodes(1);
                if (primeToCertainty) {
                    final BigInteger bigInteger5 = bigInteger;
                    BytecodeManager.incBytecodes(2);
                    return bigInteger5;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger largePrime(final int n, final int n2, final Random random) {
        try {
            BytecodeManager.incBytecodes(5);
            final BigInteger bigInteger = new BigInteger(n, random);
            final int bit = n - 1;
            BytecodeManager.incBytecodes(4);
            BigInteger bigInteger2 = bigInteger.setBit(bit);
            BytecodeManager.incBytecodes(1);
            final int[] mag = bigInteger2.mag;
            final int n3 = bigInteger2.mag.length - 1;
            mag[n3] &= 0xFFFFFFFE;
            BytecodeManager.incBytecodes(12);
            BytecodeManager.incBytecodes(2);
            final int primeSearchLen = getPrimeSearchLen(n);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = bigInteger2;
            final int n4 = primeSearchLen;
            BytecodeManager.incBytecodes(5);
            final BitSieve bitSieve = new BitSieve(bigInteger3, n4);
            BytecodeManager.incBytecodes(1);
            final BitSieve bitSieve2 = bitSieve;
            final BigInteger bigInteger4 = bigInteger2;
            BytecodeManager.incBytecodes(5);
            BigInteger bigInteger5 = bitSieve2.retrieve(bigInteger4, n2, random);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final BigInteger bigInteger6 = bigInteger5;
                BytecodeManager.incBytecodes(2);
                if (bigInteger6 != null) {
                    final BigInteger bigInteger7 = bigInteger5;
                    BytecodeManager.incBytecodes(2);
                    final int bitLength = bigInteger7.bitLength();
                    BytecodeManager.incBytecodes(2);
                    if (bitLength == n) {
                        break;
                    }
                }
                final BigInteger bigInteger8 = bigInteger2;
                final long n5 = 2 * primeSearchLen;
                BytecodeManager.incBytecodes(6);
                final BigInteger value = valueOf(n5);
                BytecodeManager.incBytecodes(1);
                bigInteger2 = bigInteger8.add(value);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger9 = bigInteger2;
                BytecodeManager.incBytecodes(2);
                final int bitLength2 = bigInteger9.bitLength();
                BytecodeManager.incBytecodes(2);
                if (bitLength2 != n) {
                    BytecodeManager.incBytecodes(5);
                    final BigInteger bigInteger10 = new BigInteger(n, random);
                    final int bit2 = n - 1;
                    BytecodeManager.incBytecodes(4);
                    bigInteger2 = bigInteger10.setBit(bit2);
                    BytecodeManager.incBytecodes(1);
                }
                final int[] mag2 = bigInteger2.mag;
                final int n6 = bigInteger2.mag.length - 1;
                mag2[n6] &= 0xFFFFFFFE;
                BytecodeManager.incBytecodes(12);
                final BigInteger bigInteger11 = bigInteger2;
                final int n7 = primeSearchLen;
                BytecodeManager.incBytecodes(5);
                final BitSieve bitSieve3 = new BitSieve(bigInteger11, n7);
                BytecodeManager.incBytecodes(1);
                final BitSieve bitSieve4 = bitSieve3;
                final BigInteger bigInteger12 = bigInteger2;
                BytecodeManager.incBytecodes(5);
                bigInteger5 = bitSieve4.retrieve(bigInteger12, n2, random);
                BytecodeManager.incBytecodes(2);
            }
            final BigInteger bigInteger13 = bigInteger5;
            BytecodeManager.incBytecodes(2);
            return bigInteger13;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger nextProbablePrime() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "start < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(this);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final ArithmeticException ex = new ArithmeticException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 != 0) {
                final BigInteger one = BigInteger.ONE;
                BytecodeManager.incBytecodes(3);
                final boolean equals = this.equals(one);
                BytecodeManager.incBytecodes(1);
                if (!equals) {
                    final BigInteger one2 = BigInteger.ONE;
                    BytecodeManager.incBytecodes(3);
                    BigInteger bigInteger = this.add(one2);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger2 = bigInteger;
                    BytecodeManager.incBytecodes(2);
                    final int bitLength = bigInteger2.bitLength();
                    final int n = 95;
                    BytecodeManager.incBytecodes(2);
                    if (bitLength >= n) {
                        final BigInteger bigInteger3 = bigInteger;
                        final int n2 = 0;
                        BytecodeManager.incBytecodes(3);
                        final boolean testBit = bigInteger3.testBit(n2);
                        BytecodeManager.incBytecodes(1);
                        if (testBit) {
                            final BigInteger bigInteger4 = bigInteger;
                            final BigInteger one3 = BigInteger.ONE;
                            BytecodeManager.incBytecodes(3);
                            bigInteger = bigInteger4.subtract(one3);
                            BytecodeManager.incBytecodes(1);
                        }
                        final BigInteger bigInteger5 = bigInteger;
                        BytecodeManager.incBytecodes(2);
                        final int bitLength2 = bigInteger5.bitLength();
                        BytecodeManager.incBytecodes(1);
                        final int primeSearchLen = getPrimeSearchLen(bitLength2);
                        BytecodeManager.incBytecodes(1);
                        BigInteger retrieve;
                        while (true) {
                            final BigInteger bigInteger6 = bigInteger;
                            final int n3 = primeSearchLen;
                            BytecodeManager.incBytecodes(5);
                            final BitSieve bitSieve = new BitSieve(bigInteger6, n3);
                            BytecodeManager.incBytecodes(1);
                            final BitSieve bitSieve2 = bitSieve;
                            final BigInteger bigInteger7 = bigInteger;
                            final int n4 = 100;
                            final Random random = null;
                            BytecodeManager.incBytecodes(5);
                            retrieve = bitSieve2.retrieve(bigInteger7, n4, random);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger bigInteger8 = retrieve;
                            BytecodeManager.incBytecodes(2);
                            if (bigInteger8 != null) {
                                break;
                            }
                            final BigInteger bigInteger9 = bigInteger;
                            final long n5 = 2 * primeSearchLen;
                            BytecodeManager.incBytecodes(6);
                            final BigInteger value = valueOf(n5);
                            BytecodeManager.incBytecodes(1);
                            bigInteger = bigInteger9.add(value);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                        final BigInteger bigInteger10 = retrieve;
                        BytecodeManager.incBytecodes(2);
                        return bigInteger10;
                    }
                    final BigInteger bigInteger11 = bigInteger;
                    final int n6 = 0;
                    BytecodeManager.incBytecodes(3);
                    final boolean testBit2 = bigInteger11.testBit(n6);
                    BytecodeManager.incBytecodes(1);
                    if (!testBit2) {
                        final BigInteger bigInteger12 = bigInteger;
                        final BigInteger one4 = BigInteger.ONE;
                        BytecodeManager.incBytecodes(3);
                        bigInteger = bigInteger12.add(one4);
                        BytecodeManager.incBytecodes(1);
                    }
                    while (true) {
                        final BigInteger bigInteger13 = bigInteger;
                        BytecodeManager.incBytecodes(2);
                        final int bitLength3 = bigInteger13.bitLength();
                        final int n7 = 6;
                        BytecodeManager.incBytecodes(2);
                        Label_0435: {
                            if (bitLength3 > n7) {
                                final BigInteger bigInteger14 = bigInteger;
                                final BigInteger small_PRIME_PRODUCT = BigInteger.SMALL_PRIME_PRODUCT;
                                BytecodeManager.incBytecodes(3);
                                final BigInteger remainder = bigInteger14.remainder(small_PRIME_PRODUCT);
                                BytecodeManager.incBytecodes(1);
                                final long longValue = remainder.longValue();
                                BytecodeManager.incBytecodes(1);
                                final long n8 = lcmp(longValue % 3L, 0L);
                                BytecodeManager.incBytecodes(6);
                                if (n8 != 0) {
                                    final long n9 = lcmp(longValue % 5L, 0L);
                                    BytecodeManager.incBytecodes(6);
                                    if (n9 != 0) {
                                        final long n10 = lcmp(longValue % 7L, 0L);
                                        BytecodeManager.incBytecodes(6);
                                        if (n10 != 0) {
                                            final long n11 = lcmp(longValue % 11L, 0L);
                                            BytecodeManager.incBytecodes(6);
                                            if (n11 != 0) {
                                                final long n12 = lcmp(longValue % 13L, 0L);
                                                BytecodeManager.incBytecodes(6);
                                                if (n12 != 0) {
                                                    final long n13 = lcmp(longValue % 17L, 0L);
                                                    BytecodeManager.incBytecodes(6);
                                                    if (n13 != 0) {
                                                        final long n14 = lcmp(longValue % 19L, 0L);
                                                        BytecodeManager.incBytecodes(6);
                                                        if (n14 != 0) {
                                                            final long n15 = lcmp(longValue % 23L, 0L);
                                                            BytecodeManager.incBytecodes(6);
                                                            if (n15 != 0) {
                                                                final long n16 = lcmp(longValue % 29L, 0L);
                                                                BytecodeManager.incBytecodes(6);
                                                                if (n16 != 0) {
                                                                    final long n17 = lcmp(longValue % 31L, 0L);
                                                                    BytecodeManager.incBytecodes(6);
                                                                    if (n17 != 0) {
                                                                        final long n18 = lcmp(longValue % 37L, 0L);
                                                                        BytecodeManager.incBytecodes(6);
                                                                        if (n18 != 0) {
                                                                            final long n19 = lcmp(longValue % 41L, 0L);
                                                                            BytecodeManager.incBytecodes(6);
                                                                            if (n19 != 0) {
                                                                                break Label_0435;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                final BigInteger bigInteger15 = bigInteger;
                                final BigInteger two = BigInteger.TWO;
                                BytecodeManager.incBytecodes(3);
                                bigInteger = bigInteger15.add(two);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        final BigInteger bigInteger16 = bigInteger;
                        BytecodeManager.incBytecodes(2);
                        final int bitLength4 = bigInteger16.bitLength();
                        final int n20 = 4;
                        BytecodeManager.incBytecodes(2);
                        if (bitLength4 < n20) {
                            final BigInteger bigInteger17 = bigInteger;
                            BytecodeManager.incBytecodes(2);
                            return bigInteger17;
                        }
                        final BigInteger bigInteger18 = bigInteger;
                        final int n21 = 100;
                        final Random random2 = null;
                        BytecodeManager.incBytecodes(4);
                        final boolean primeToCertainty = bigInteger18.primeToCertainty(n21, random2);
                        BytecodeManager.incBytecodes(1);
                        if (primeToCertainty) {
                            final BigInteger bigInteger19 = bigInteger;
                            BytecodeManager.incBytecodes(2);
                            return bigInteger19;
                        }
                        final BigInteger bigInteger20 = bigInteger;
                        final BigInteger two2 = BigInteger.TWO;
                        BytecodeManager.incBytecodes(3);
                        bigInteger = bigInteger20.add(two2);
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final BigInteger two3 = BigInteger.TWO;
            BytecodeManager.incBytecodes(2);
            return two3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int getPrimeSearchLen(final int n) {
        try {
            final int n2 = 500000001;
            BytecodeManager.incBytecodes(3);
            if (n > n2) {
                final String s = "Prime search implementation restriction on bitLength";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = n / 20 * 64;
            BytecodeManager.incBytecodes(6);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean primeToCertainty(final int a, final Random random) {
        try {
            BytecodeManager.incBytecodes(2);
            final int b = 2147483646;
            BytecodeManager.incBytecodes(3);
            final int n = (Math.min(a, b) + 1) / 2;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(2);
            final int bitLength = this.bitLength();
            BytecodeManager.incBytecodes(1);
            final int n2 = bitLength;
            final int n3 = 100;
            BytecodeManager.incBytecodes(3);
            if (n2 < n3) {
                final int n4 = 50;
                BytecodeManager.incBytecodes(2);
                final int n5 = n;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                int n7;
                if (n5 < n6) {
                    n7 = n;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n7 = n4;
                    BytecodeManager.incBytecodes(1);
                }
                final int n8 = n7;
                BytecodeManager.incBytecodes(1);
                final int n9 = n8;
                BytecodeManager.incBytecodes(4);
                final boolean passesMillerRabin = this.passesMillerRabin(n9, random);
                BytecodeManager.incBytecodes(1);
                return passesMillerRabin;
            }
            final int n10 = bitLength;
            final int n11 = 256;
            BytecodeManager.incBytecodes(3);
            int n12;
            if (n10 < n11) {
                n12 = 27;
                BytecodeManager.incBytecodes(3);
            }
            else {
                final int n13 = bitLength;
                final int n14 = 512;
                BytecodeManager.incBytecodes(3);
                if (n13 < n14) {
                    n12 = 15;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final int n15 = bitLength;
                    final int n16 = 768;
                    BytecodeManager.incBytecodes(3);
                    if (n15 < n16) {
                        n12 = 8;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final int n17 = bitLength;
                        final int n18 = 1024;
                        BytecodeManager.incBytecodes(3);
                        if (n17 < n18) {
                            n12 = 4;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            n12 = 2;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
            }
            final int n19 = n;
            final int n20 = n12;
            BytecodeManager.incBytecodes(3);
            int n21;
            if (n19 < n20) {
                n21 = n;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n21 = n12;
                BytecodeManager.incBytecodes(1);
            }
            final int n22 = n21;
            BytecodeManager.incBytecodes(1);
            final int n23 = n22;
            BytecodeManager.incBytecodes(4);
            final boolean passesMillerRabin2 = this.passesMillerRabin(n23, random);
            BytecodeManager.incBytecodes(1);
            boolean b2 = false;
            Label_0302: {
                if (passesMillerRabin2) {
                    BytecodeManager.incBytecodes(2);
                    final boolean passesLucasLehmer = this.passesLucasLehmer();
                    BytecodeManager.incBytecodes(1);
                    if (passesLucasLehmer) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0302;
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
    
    private boolean passesLucasLehmer() {
        try {
            final BigInteger one = BigInteger.ONE;
            BytecodeManager.incBytecodes(3);
            final BigInteger add = this.add(one);
            BytecodeManager.incBytecodes(1);
            int n = 5;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(3);
                final int jacobiSymbol = jacobiSymbol(n2, this);
                final int n3 = -1;
                BytecodeManager.incBytecodes(2);
                if (jacobiSymbol == n3) {
                    break;
                }
                final int n4 = n;
                BytecodeManager.incBytecodes(2);
                int n5;
                if (n4 < 0) {
                    final int a = n;
                    BytecodeManager.incBytecodes(2);
                    n5 = Math.abs(a) + 2;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n5 = -(n + 2);
                    BytecodeManager.incBytecodes(4);
                }
                n = n5;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = n;
            final BigInteger bigInteger = add;
            BytecodeManager.incBytecodes(4);
            final BigInteger lucasLehmerSequence = lucasLehmerSequence(n6, bigInteger, this);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger2 = lucasLehmerSequence;
            BytecodeManager.incBytecodes(3);
            final BigInteger mod = bigInteger2.mod(this);
            final BigInteger zero = BigInteger.ZERO;
            BytecodeManager.incBytecodes(2);
            final boolean equals = mod.equals(zero);
            BytecodeManager.incBytecodes(1);
            return equals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int jacobiSymbol(int n, final BigInteger bigInteger) {
        try {
            final boolean b = n != 0;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                final int n2 = 0;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            int n3 = 1;
            BytecodeManager.incBytecodes(2);
            final int n4 = bigInteger.mag[bigInteger.mag.length - 1];
            BytecodeManager.incBytecodes(9);
            final int n5 = n;
            BytecodeManager.incBytecodes(2);
            Label_0100: {
                if (n5 < 0) {
                    n = -n;
                    BytecodeManager.incBytecodes(3);
                    final int n6 = n4 & 0x7;
                    BytecodeManager.incBytecodes(4);
                    final int n7 = n6;
                    final int n8 = 3;
                    BytecodeManager.incBytecodes(3);
                    if (n7 != n8) {
                        final int n9 = n6;
                        final int n10 = 7;
                        BytecodeManager.incBytecodes(3);
                        if (n9 != n10) {
                            break Label_0100;
                        }
                    }
                    n3 = -n3;
                    BytecodeManager.incBytecodes(3);
                }
            }
            while (true) {
                final int n11 = n & 0x3;
                BytecodeManager.incBytecodes(4);
                if (n11 != 0) {
                    break;
                }
                n >>= 2;
                BytecodeManager.incBytecodes(5);
            }
            final int n12 = n & 0x1;
            BytecodeManager.incBytecodes(4);
            if (n12 == 0) {
                n >>= 1;
                BytecodeManager.incBytecodes(4);
                final int n13 = (n4 ^ n4 >> 1) & 0x2;
                BytecodeManager.incBytecodes(8);
                if (n13 != 0) {
                    n3 = -n3;
                    BytecodeManager.incBytecodes(3);
                }
            }
            final boolean b2 = n != 0;
            final boolean b3 = true;
            BytecodeManager.incBytecodes(3);
            if (b2 == b3) {
                final int n14 = n3;
                BytecodeManager.incBytecodes(2);
                return n14;
            }
            final int n15 = n & n4 & 0x2;
            BytecodeManager.incBytecodes(6);
            if (n15 != 0) {
                n3 = -n3;
                BytecodeManager.incBytecodes(3);
            }
            final long n16 = n;
            BytecodeManager.incBytecodes(4);
            final BigInteger value = valueOf(n16);
            BytecodeManager.incBytecodes(1);
            final BigInteger mod = bigInteger.mod(value);
            BytecodeManager.incBytecodes(1);
            int intValue = mod.intValue();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n17 = intValue;
                BytecodeManager.incBytecodes(2);
                if (n17 == 0) {
                    final int n18 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n18;
                }
                while (true) {
                    final int n19 = intValue & 0x3;
                    BytecodeManager.incBytecodes(4);
                    if (n19 != 0) {
                        break;
                    }
                    intValue >>= 2;
                    BytecodeManager.incBytecodes(5);
                }
                final int n20 = intValue & 0x1;
                BytecodeManager.incBytecodes(4);
                if (n20 == 0) {
                    intValue >>= 1;
                    BytecodeManager.incBytecodes(4);
                    final int n21 = (n ^ n >> 1) & 0x2;
                    BytecodeManager.incBytecodes(8);
                    if (n21 != 0) {
                        n3 = -n3;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final int n22 = intValue;
                final int n23 = 1;
                BytecodeManager.incBytecodes(3);
                if (n22 == n23) {
                    final int n24 = n3;
                    BytecodeManager.incBytecodes(2);
                    return n24;
                }
                final boolean $assertionsDisabled = BigInteger.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final int n25 = intValue;
                    final int n26 = n;
                    BytecodeManager.incBytecodes(3);
                    if (n25 >= n26) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                final int n27 = intValue;
                final int n28 = n;
                n = n27;
                BytecodeManager.incBytecodes(6);
                final int n29 = n28 & n & 0x2;
                BytecodeManager.incBytecodes(6);
                if (n29 != 0) {
                    n3 = -n3;
                    BytecodeManager.incBytecodes(3);
                }
                intValue = n28 % n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger lucasLehmerSequence(final int n, final BigInteger bigInteger, final BigInteger bigInteger2) {
        try {
            final long n2 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger value = valueOf(n2);
            BytecodeManager.incBytecodes(1);
            BigInteger one = BigInteger.ONE;
            BytecodeManager.incBytecodes(2);
            BigInteger one2 = BigInteger.ONE;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n3 = bigInteger.bitLength() - 2;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(2);
                if (n4 < 0) {
                    break;
                }
                final BigInteger bigInteger3 = one;
                final BigInteger bigInteger4 = one2;
                BytecodeManager.incBytecodes(3);
                final BigInteger multiply = bigInteger3.multiply(bigInteger4);
                BytecodeManager.incBytecodes(2);
                final BigInteger mod = multiply.mod(bigInteger2);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger5 = one2;
                BytecodeManager.incBytecodes(2);
                final BigInteger square = bigInteger5.square();
                final BigInteger bigInteger6 = value;
                final BigInteger bigInteger7 = one;
                BytecodeManager.incBytecodes(3);
                final BigInteger square2 = bigInteger7.square();
                BytecodeManager.incBytecodes(1);
                final BigInteger multiply2 = bigInteger6.multiply(square2);
                BytecodeManager.incBytecodes(1);
                final BigInteger add = square.add(multiply2);
                BytecodeManager.incBytecodes(2);
                BigInteger bigInteger8 = add.mod(bigInteger2);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger9 = bigInteger8;
                final int n5 = 0;
                BytecodeManager.incBytecodes(3);
                final boolean testBit = bigInteger9.testBit(n5);
                BytecodeManager.incBytecodes(1);
                if (testBit) {
                    final BigInteger bigInteger10 = bigInteger8;
                    BytecodeManager.incBytecodes(3);
                    bigInteger8 = bigInteger10.subtract(bigInteger2);
                    BytecodeManager.incBytecodes(1);
                }
                final BigInteger bigInteger11 = bigInteger8;
                final int n6 = 1;
                BytecodeManager.incBytecodes(3);
                final BigInteger shiftRight = bigInteger11.shiftRight(n6);
                BytecodeManager.incBytecodes(1);
                one = mod;
                one2 = shiftRight;
                BytecodeManager.incBytecodes(4);
                final int n7 = n3;
                BytecodeManager.incBytecodes(3);
                final boolean testBit2 = bigInteger.testBit(n7);
                BytecodeManager.incBytecodes(1);
                if (testBit2) {
                    final BigInteger bigInteger12 = one;
                    final BigInteger bigInteger13 = one2;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger add2 = bigInteger12.add(bigInteger13);
                    BytecodeManager.incBytecodes(2);
                    BigInteger bigInteger14 = add2.mod(bigInteger2);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger15 = bigInteger14;
                    final int n8 = 0;
                    BytecodeManager.incBytecodes(3);
                    final boolean testBit3 = bigInteger15.testBit(n8);
                    BytecodeManager.incBytecodes(1);
                    if (testBit3) {
                        final BigInteger bigInteger16 = bigInteger14;
                        BytecodeManager.incBytecodes(3);
                        bigInteger14 = bigInteger16.subtract(bigInteger2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final BigInteger bigInteger17 = bigInteger14;
                    final int n9 = 1;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger shiftRight2 = bigInteger17.shiftRight(n9);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger18 = one2;
                    final BigInteger bigInteger19 = value;
                    final BigInteger bigInteger20 = one;
                    BytecodeManager.incBytecodes(4);
                    final BigInteger multiply3 = bigInteger19.multiply(bigInteger20);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger add3 = bigInteger18.add(multiply3);
                    BytecodeManager.incBytecodes(2);
                    BigInteger bigInteger21 = add3.mod(bigInteger2);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger22 = bigInteger21;
                    final int n10 = 0;
                    BytecodeManager.incBytecodes(3);
                    final boolean testBit4 = bigInteger22.testBit(n10);
                    BytecodeManager.incBytecodes(1);
                    if (testBit4) {
                        final BigInteger bigInteger23 = bigInteger21;
                        BytecodeManager.incBytecodes(3);
                        bigInteger21 = bigInteger23.subtract(bigInteger2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final BigInteger bigInteger24 = bigInteger21;
                    final int n11 = 1;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger shiftRight3 = bigInteger24.shiftRight(n11);
                    BytecodeManager.incBytecodes(1);
                    one = shiftRight2;
                    one2 = shiftRight3;
                    BytecodeManager.incBytecodes(4);
                }
                --n3;
                BytecodeManager.incBytecodes(2);
            }
            final BigInteger bigInteger25 = one;
            BytecodeManager.incBytecodes(2);
            return bigInteger25;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean passesMillerRabin(final int n, Random current) {
        try {
            final BigInteger one = BigInteger.ONE;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract = this.subtract(one);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger = subtract;
            BytecodeManager.incBytecodes(2);
            final BigInteger bigInteger2 = bigInteger;
            BytecodeManager.incBytecodes(2);
            final int lowestSetBit = bigInteger2.getLowestSetBit();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = bigInteger;
            final int n2 = lowestSetBit;
            BytecodeManager.incBytecodes(3);
            final BigInteger shiftRight = bigInteger3.shiftRight(n2);
            BytecodeManager.incBytecodes(1);
            final Random random = current;
            BytecodeManager.incBytecodes(2);
            if (random == null) {
                BytecodeManager.incBytecodes(1);
                current = ThreadLocalRandom.current();
                BytecodeManager.incBytecodes(1);
            }
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            Label_0339: {
            Label_0297:
                while (true) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n) {
                        break Label_0339;
                    }
                    BigInteger bigInteger4;
                    while (true) {
                        BytecodeManager.incBytecodes(4);
                        final int bitLength = this.bitLength();
                        final Random random2 = current;
                        BytecodeManager.incBytecodes(2);
                        bigInteger4 = new BigInteger(bitLength, random2);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger5 = bigInteger4;
                        final BigInteger one2 = BigInteger.ONE;
                        BytecodeManager.incBytecodes(3);
                        final int compareTo = bigInteger5.compareTo(one2);
                        BytecodeManager.incBytecodes(1);
                        if (compareTo > 0) {
                            final BigInteger bigInteger6 = bigInteger4;
                            BytecodeManager.incBytecodes(3);
                            final int compareTo2 = bigInteger6.compareTo(this);
                            BytecodeManager.incBytecodes(1);
                            if (compareTo2 < 0) {
                                break;
                            }
                            continue;
                        }
                    }
                    int n5 = 0;
                    BytecodeManager.incBytecodes(2);
                    final BigInteger bigInteger7 = bigInteger4;
                    final BigInteger bigInteger8 = shiftRight;
                    BytecodeManager.incBytecodes(4);
                    BigInteger bigInteger9 = bigInteger7.modPow(bigInteger8, this);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final int n6 = n5;
                        BytecodeManager.incBytecodes(2);
                        if (n6 == 0) {
                            final BigInteger bigInteger10 = bigInteger9;
                            final BigInteger one3 = BigInteger.ONE;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals = bigInteger10.equals(one3);
                            BytecodeManager.incBytecodes(1);
                            if (equals) {
                                break;
                            }
                        }
                        final BigInteger bigInteger11 = bigInteger9;
                        final BigInteger bigInteger12 = subtract;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals2 = bigInteger11.equals(bigInteger12);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            break;
                        }
                        final int n7 = n5;
                        BytecodeManager.incBytecodes(2);
                        if (n7 > 0) {
                            final BigInteger bigInteger13 = bigInteger9;
                            final BigInteger one4 = BigInteger.ONE;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals3 = bigInteger13.equals(one4);
                            BytecodeManager.incBytecodes(1);
                            if (equals3) {
                                break Label_0297;
                            }
                        }
                        final int n8 = ++n5;
                        final int n9 = lowestSetBit;
                        BytecodeManager.incBytecodes(4);
                        if (n8 == n9) {
                            break Label_0297;
                        }
                        final BigInteger bigInteger14 = bigInteger9;
                        final BigInteger two = BigInteger.TWO;
                        BytecodeManager.incBytecodes(4);
                        bigInteger9 = bigInteger14.modPow(two, this);
                        BytecodeManager.incBytecodes(2);
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BigInteger(final int[] mag, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = mag.length;
            BytecodeManager.incBytecodes(4);
            int signum;
            if (length == 0) {
                signum = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                signum = n;
                BytecodeManager.incBytecodes(1);
            }
            this.signum = signum;
            BytecodeManager.incBytecodes(1);
            this.mag = mag;
            BytecodeManager.incBytecodes(3);
            final int length2 = this.mag.length;
            final int n2 = 67108864;
            BytecodeManager.incBytecodes(5);
            if (length2 >= n2) {
                BytecodeManager.incBytecodes(2);
                this.checkRange();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger(final byte[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            int signum;
            if (length == 0) {
                signum = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                signum = n;
                BytecodeManager.incBytecodes(1);
            }
            this.signum = signum;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.mag = stripLeadingZeroBytes(array);
            BytecodeManager.incBytecodes(1);
            final int length2 = this.mag.length;
            final int n2 = 67108864;
            BytecodeManager.incBytecodes(5);
            if (length2 >= n2) {
                BytecodeManager.incBytecodes(2);
                this.checkRange();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void checkRange() {
        try {
            final int length = this.mag.length;
            final int n = 67108864;
            BytecodeManager.incBytecodes(5);
            Label_0052: {
                if (length <= n) {
                    final int length2 = this.mag.length;
                    final int n2 = 67108864;
                    BytecodeManager.incBytecodes(5);
                    if (length2 != n2) {
                        break Label_0052;
                    }
                    final int n3 = this.mag[0];
                    BytecodeManager.incBytecodes(5);
                    if (n3 >= 0) {
                        break Label_0052;
                    }
                }
                BytecodeManager.incBytecodes(1);
                reportOverflow();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void reportOverflow() {
        try {
            final String s = "BigInteger would overflow supported range";
            BytecodeManager.incBytecodes(4);
            final ArithmeticException ex = new ArithmeticException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BigInteger valueOf(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 > 0) {
                final long n4 = lcmp(n, 16L);
                BytecodeManager.incBytecodes(4);
                if (n4 <= 0) {
                    final BigInteger bigInteger = BigInteger.posConst[(int)n];
                    BytecodeManager.incBytecodes(5);
                    return bigInteger;
                }
            }
            final long n5 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n5 < 0) {
                final long n6 = lcmp(n, -16L);
                BytecodeManager.incBytecodes(4);
                if (n6 >= 0) {
                    final BigInteger bigInteger2 = BigInteger.negConst[(int)(-n)];
                    BytecodeManager.incBytecodes(6);
                    return bigInteger2;
                }
            }
            BytecodeManager.incBytecodes(4);
            final BigInteger bigInteger3 = new BigInteger(n);
            BytecodeManager.incBytecodes(1);
            return bigInteger3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger(long n) {
        try {
            BytecodeManager.incBytecodes(2);
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                n = -n;
                BytecodeManager.incBytecodes(3);
                this.signum = -1;
                BytecodeManager.incBytecodes(4);
            }
            else {
                this.signum = 1;
                BytecodeManager.incBytecodes(3);
            }
            final int n3 = (int)(n >>> 32);
            BytecodeManager.incBytecodes(5);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 == 0) {
                this.mag = new int[1];
                BytecodeManager.incBytecodes(3);
                this.mag[0] = (int)n;
                BytecodeManager.incBytecodes(7);
            }
            else {
                this.mag = new int[2];
                BytecodeManager.incBytecodes(3);
                this.mag[0] = n3;
                BytecodeManager.incBytecodes(5);
                this.mag[1] = (int)n;
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger valueOf(final int[] array) {
        try {
            final int n = array[0];
            BytecodeManager.incBytecodes(4);
            BigInteger bigInteger;
            if (n > 0) {
                final int n2;
                bigInteger = new BigInteger(array, n2);
                n2 = 1;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            else {
                bigInteger = new BigInteger(array);
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger add(final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 == 0) {
                BytecodeManager.incBytecodes(2);
                return bigInteger;
            }
            final int signum3 = bigInteger.signum;
            final int signum4 = this.signum;
            BytecodeManager.incBytecodes(5);
            if (signum3 == signum4) {
                final int[] mag = this.mag;
                final int[] mag2 = bigInteger.mag;
                BytecodeManager.incBytecodes(7);
                final int[] add = add(mag, mag2);
                final int signum5 = this.signum;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigInteger2 = new BigInteger(add, signum5);
                BytecodeManager.incBytecodes(1);
                return bigInteger2;
            }
            BytecodeManager.incBytecodes(3);
            final int compareMagnitude = this.compareMagnitude(bigInteger);
            BytecodeManager.incBytecodes(1);
            final int n = compareMagnitude;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int n2 = compareMagnitude;
            BytecodeManager.incBytecodes(2);
            int[] array;
            if (n2 > 0) {
                final int[] mag3 = this.mag;
                final int[] mag4 = bigInteger.mag;
                BytecodeManager.incBytecodes(5);
                array = subtract(mag3, mag4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int[] mag5 = bigInteger.mag;
                final int[] mag6 = this.mag;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                array = subtract(mag5, mag6);
            }
            final int[] array2 = array;
            BytecodeManager.incBytecodes(1);
            final int[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array3);
            BytecodeManager.incBytecodes(1);
            final int[] array4 = trustedStripLeadingZeroInts;
            final int n3 = compareMagnitude;
            final int signum6 = this.signum;
            BytecodeManager.incBytecodes(7);
            int n4;
            if (n3 == signum6) {
                n4 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n4 = -1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = new BigInteger(array4, n4);
            BytecodeManager.incBytecodes(1);
            return bigInteger3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BigInteger add(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger value = valueOf(n);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            BytecodeManager.incBytecodes(2);
            final int signum2 = Long.signum(n);
            final int signum3 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 == signum3) {
                final int[] mag = this.mag;
                BytecodeManager.incBytecodes(6);
                final long abs = Math.abs(n);
                BytecodeManager.incBytecodes(1);
                final int[] add = add(mag, abs);
                final int signum4 = this.signum;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigInteger = new BigInteger(add, signum4);
                BytecodeManager.incBytecodes(1);
                return bigInteger;
            }
            BytecodeManager.incBytecodes(3);
            final int compareMagnitude = this.compareMagnitude(n);
            BytecodeManager.incBytecodes(1);
            final int n3 = compareMagnitude;
            BytecodeManager.incBytecodes(2);
            if (n3 == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int n4 = compareMagnitude;
            BytecodeManager.incBytecodes(2);
            int[] array;
            if (n4 > 0) {
                final int[] mag2 = this.mag;
                BytecodeManager.incBytecodes(4);
                final long abs2 = Math.abs(n);
                BytecodeManager.incBytecodes(1);
                array = subtract(mag2, abs2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final long abs3 = Math.abs(n);
                final int[] mag3 = this.mag;
                BytecodeManager.incBytecodes(3);
                array = subtract(abs3, mag3);
            }
            final int[] array2 = array;
            BytecodeManager.incBytecodes(1);
            final int[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array3);
            BytecodeManager.incBytecodes(1);
            final int[] array4 = trustedStripLeadingZeroInts;
            final int n5 = compareMagnitude;
            final int signum5 = this.signum;
            BytecodeManager.incBytecodes(7);
            int n6;
            if (n5 == signum5) {
                n6 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n6 = -1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger2 = new BigInteger(array4, n6);
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] add(final int[] array, final long n) {
        try {
            BytecodeManager.incBytecodes(2);
            int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n2 = (int)(n >>> 32);
            BytecodeManager.incBytecodes(5);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            int[] array2;
            long n4;
            if (n3 == 0) {
                array2 = new int[length];
                BytecodeManager.incBytecodes(2);
                n4 = ((long)array[--length] & 0xFFFFFFFFL) + n;
                BytecodeManager.incBytecodes(10);
                array2[length] = (int)n4;
                BytecodeManager.incBytecodes(6);
            }
            else {
                final int n5 = length;
                final int n6 = 1;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    final int[] array3 = new int[2];
                    BytecodeManager.incBytecodes(2);
                    final long n7 = n + ((long)array[0] & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(9);
                    array3[1] = (int)n7;
                    BytecodeManager.incBytecodes(5);
                    array3[0] = (int)(n7 >>> 32);
                    BytecodeManager.incBytecodes(7);
                    final int[] array4 = array3;
                    BytecodeManager.incBytecodes(2);
                    return array4;
                }
                array2 = new int[length];
                BytecodeManager.incBytecodes(2);
                final long n8 = ((long)array[--length] & 0xFFFFFFFFL) + (n & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(12);
                array2[length] = (int)n8;
                BytecodeManager.incBytecodes(5);
                n4 = ((long)array[--length] & 0xFFFFFFFFL) + ((long)n2 & 0xFFFFFFFFL) + (n8 >>> 32);
                BytecodeManager.incBytecodes(17);
                array2[length] = (int)n4;
                BytecodeManager.incBytecodes(5);
            }
            final long n9 = lcmp(n4 >>> 32, 0L);
            BytecodeManager.incBytecodes(6);
            int n10;
            if (n9 != 0) {
                n10 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n10 = 0;
                BytecodeManager.incBytecodes(1);
            }
            int n11 = n10;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n12 = length;
                BytecodeManager.incBytecodes(2);
                if (n12 <= 0) {
                    break;
                }
                final int n13 = n11;
                BytecodeManager.incBytecodes(2);
                if (n13 == 0) {
                    break;
                }
                final int[] array5 = array2;
                final int n14 = --length;
                final int n15 = array[length] + 1;
                array5[n14] = n15;
                BytecodeManager.incBytecodes(11);
                int n16;
                if (n15 == 0) {
                    n16 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n16 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                n11 = n16;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                final int n17 = length;
                BytecodeManager.incBytecodes(2);
                if (n17 <= 0) {
                    break;
                }
                array2[--length] = array[length];
                BytecodeManager.incBytecodes(8);
            }
            final int n18 = n11;
            BytecodeManager.incBytecodes(2);
            if (n18 != 0) {
                final int[] array6 = new int[array2.length + 1];
                BytecodeManager.incBytecodes(5);
                final int[] array7 = array2;
                final int n19 = 0;
                final int[] array8 = array6;
                final int n20 = 1;
                final int length2 = array2.length;
                BytecodeManager.incBytecodes(7);
                System.arraycopy(array7, n19, array8, n20, length2);
                array6[0] = 1;
                BytecodeManager.incBytecodes(4);
                final int[] array9 = array6;
                BytecodeManager.incBytecodes(2);
                return array9;
            }
            final int[] array10 = array2;
            BytecodeManager.incBytecodes(2);
            return array10;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] add(int[] array, int[] array2) {
        try {
            final int length = array.length;
            final int length2 = array2.length;
            BytecodeManager.incBytecodes(5);
            if (length < length2) {
                final int[] array3 = array;
                BytecodeManager.incBytecodes(2);
                array = array2;
                BytecodeManager.incBytecodes(2);
                array2 = array3;
                BytecodeManager.incBytecodes(2);
            }
            int length3 = array.length;
            BytecodeManager.incBytecodes(3);
            int length4 = array2.length;
            BytecodeManager.incBytecodes(3);
            final int[] array4 = new int[length3];
            BytecodeManager.incBytecodes(2);
            long n = 0L;
            BytecodeManager.incBytecodes(2);
            final int n2 = length4;
            final int n3 = 1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                n = ((long)array[--length3] & 0xFFFFFFFFL) + ((long)array2[0] & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(15);
                array4[length3] = (int)n;
                BytecodeManager.incBytecodes(6);
            }
            else {
                while (true) {
                    final int n4 = length4;
                    BytecodeManager.incBytecodes(2);
                    if (n4 <= 0) {
                        break;
                    }
                    n = ((long)array[--length3] & 0xFFFFFFFFL) + ((long)array2[--length4] & 0xFFFFFFFFL) + (n >>> 32);
                    BytecodeManager.incBytecodes(20);
                    array4[length3] = (int)n;
                    BytecodeManager.incBytecodes(6);
                }
            }
            final long n5 = lcmp(n >>> 32, 0L);
            BytecodeManager.incBytecodes(6);
            int n6;
            if (n5 != 0) {
                n6 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n6 = 0;
                BytecodeManager.incBytecodes(1);
            }
            int n7 = n6;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n8 = length3;
                BytecodeManager.incBytecodes(2);
                if (n8 <= 0) {
                    break;
                }
                final int n9 = n7;
                BytecodeManager.incBytecodes(2);
                if (n9 == 0) {
                    break;
                }
                final int[] array5 = array4;
                final int n10 = --length3;
                final int n11 = array[length3] + 1;
                array5[n10] = n11;
                BytecodeManager.incBytecodes(11);
                int n12;
                if (n11 == 0) {
                    n12 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n12 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                n7 = n12;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                final int n13 = length3;
                BytecodeManager.incBytecodes(2);
                if (n13 <= 0) {
                    break;
                }
                array4[--length3] = array[length3];
                BytecodeManager.incBytecodes(8);
            }
            final int n14 = n7;
            BytecodeManager.incBytecodes(2);
            if (n14 != 0) {
                final int[] array6 = new int[array4.length + 1];
                BytecodeManager.incBytecodes(5);
                final int[] array7 = array4;
                final int n15 = 0;
                final int[] array8 = array6;
                final int n16 = 1;
                final int length5 = array4.length;
                BytecodeManager.incBytecodes(7);
                System.arraycopy(array7, n15, array8, n16, length5);
                array6[0] = 1;
                BytecodeManager.incBytecodes(4);
                final int[] array9 = array6;
                BytecodeManager.incBytecodes(2);
                return array9;
            }
            final int[] array10 = array4;
            BytecodeManager.incBytecodes(2);
            return array10;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] subtract(final long n, final int[] array) {
        try {
            final int n2 = (int)(n >>> 32);
            BytecodeManager.incBytecodes(5);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 == 0) {
                final int[] array2 = { 0 };
                BytecodeManager.incBytecodes(2);
                array2[0] = (int)(n - ((long)array[0] & 0xFFFFFFFFL));
                BytecodeManager.incBytecodes(12);
                final int[] array3 = array2;
                BytecodeManager.incBytecodes(2);
                return array3;
            }
            final int[] array4 = new int[2];
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            final int n4 = 1;
            BytecodeManager.incBytecodes(4);
            if (length == n4) {
                final long n5 = ((long)(int)n & 0xFFFFFFFFL) - ((long)array[0] & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(13);
                array4[1] = (int)n5;
                BytecodeManager.incBytecodes(5);
                final long n6 = lcmp(n5 >> 32, 0L);
                BytecodeManager.incBytecodes(6);
                int n7;
                if (n6 != 0) {
                    n7 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n7 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n8 = n7;
                BytecodeManager.incBytecodes(1);
                final int n9 = n8;
                BytecodeManager.incBytecodes(2);
                if (n9 != 0) {
                    array4[0] = n2 - 1;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    array4[0] = n2;
                    BytecodeManager.incBytecodes(4);
                }
                final int[] array5 = array4;
                BytecodeManager.incBytecodes(2);
                return array5;
            }
            final long n10 = ((long)(int)n & 0xFFFFFFFFL) - ((long)array[1] & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(13);
            array4[1] = (int)n10;
            BytecodeManager.incBytecodes(5);
            final long n11 = ((long)n2 & 0xFFFFFFFFL) - ((long)array[0] & 0xFFFFFFFFL) + (n10 >> 32);
            BytecodeManager.incBytecodes(16);
            array4[0] = (int)n11;
            BytecodeManager.incBytecodes(5);
            final int[] array6 = array4;
            BytecodeManager.incBytecodes(2);
            return array6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] subtract(final int[] array, final long n) {
        try {
            final int n2 = (int)(n >>> 32);
            BytecodeManager.incBytecodes(5);
            int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int[] array2 = new int[length];
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            long n4;
            if (n3 == 0) {
                n4 = ((long)array[--length] & 0xFFFFFFFFL) - n;
                BytecodeManager.incBytecodes(10);
                array2[length] = (int)n4;
                BytecodeManager.incBytecodes(6);
            }
            else {
                final long n5 = ((long)array[--length] & 0xFFFFFFFFL) - (n & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(12);
                array2[length] = (int)n5;
                BytecodeManager.incBytecodes(5);
                n4 = ((long)array[--length] & 0xFFFFFFFFL) - ((long)n2 & 0xFFFFFFFFL) + (n5 >> 32);
                BytecodeManager.incBytecodes(17);
                array2[length] = (int)n4;
                BytecodeManager.incBytecodes(5);
            }
            final long n6 = lcmp(n4 >> 32, 0L);
            BytecodeManager.incBytecodes(6);
            boolean b;
            if (n6 != 0) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            boolean b2 = b;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n7 = length;
                BytecodeManager.incBytecodes(2);
                if (n7 <= 0) {
                    break;
                }
                final boolean b3 = b2;
                BytecodeManager.incBytecodes(2);
                if (!b3) {
                    break;
                }
                final int[] array3 = array2;
                final int n8 = --length;
                final int n9 = array[length] - 1;
                array3[n8] = n9;
                final int n10 = -1;
                BytecodeManager.incBytecodes(12);
                boolean b4;
                if (n9 == n10) {
                    b4 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b4 = false;
                    BytecodeManager.incBytecodes(1);
                }
                b2 = b4;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                final int n11 = length;
                BytecodeManager.incBytecodes(2);
                if (n11 <= 0) {
                    break;
                }
                array2[--length] = array[length];
                BytecodeManager.incBytecodes(8);
            }
            final int[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger subtract(final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger negate = bigInteger.negate();
                BytecodeManager.incBytecodes(1);
                return negate;
            }
            final int signum3 = bigInteger.signum;
            final int signum4 = this.signum;
            BytecodeManager.incBytecodes(5);
            if (signum3 != signum4) {
                final int[] mag = this.mag;
                final int[] mag2 = bigInteger.mag;
                BytecodeManager.incBytecodes(7);
                final int[] add = add(mag, mag2);
                final int signum5 = this.signum;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigInteger2 = new BigInteger(add, signum5);
                BytecodeManager.incBytecodes(1);
                return bigInteger2;
            }
            BytecodeManager.incBytecodes(3);
            final int compareMagnitude = this.compareMagnitude(bigInteger);
            BytecodeManager.incBytecodes(1);
            final int n = compareMagnitude;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int n2 = compareMagnitude;
            BytecodeManager.incBytecodes(2);
            int[] array;
            if (n2 > 0) {
                final int[] mag3 = this.mag;
                final int[] mag4 = bigInteger.mag;
                BytecodeManager.incBytecodes(5);
                array = subtract(mag3, mag4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int[] mag5 = bigInteger.mag;
                final int[] mag6 = this.mag;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                array = subtract(mag5, mag6);
            }
            final int[] array2 = array;
            BytecodeManager.incBytecodes(1);
            final int[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array3);
            BytecodeManager.incBytecodes(1);
            final int[] array4 = trustedStripLeadingZeroInts;
            final int n3 = compareMagnitude;
            final int signum6 = this.signum;
            BytecodeManager.incBytecodes(7);
            int n4;
            if (n3 == signum6) {
                n4 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n4 = -1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = new BigInteger(array4, n4);
            BytecodeManager.incBytecodes(1);
            return bigInteger3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] subtract(final int[] array, final int[] array2) {
        try {
            int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int[] array3 = new int[length];
            BytecodeManager.incBytecodes(2);
            int length2 = array2.length;
            BytecodeManager.incBytecodes(3);
            long n = 0L;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = length2;
                BytecodeManager.incBytecodes(2);
                if (n2 <= 0) {
                    break;
                }
                n = ((long)array[--length] & 0xFFFFFFFFL) - ((long)array2[--length2] & 0xFFFFFFFFL) + (n >> 32);
                BytecodeManager.incBytecodes(20);
                array3[length] = (int)n;
                BytecodeManager.incBytecodes(6);
            }
            final long n3 = lcmp(n >> 32, 0L);
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
            boolean b2 = b;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n4 = length;
                BytecodeManager.incBytecodes(2);
                if (n4 <= 0) {
                    break;
                }
                final boolean b3 = b2;
                BytecodeManager.incBytecodes(2);
                if (!b3) {
                    break;
                }
                final int[] array4 = array3;
                final int n5 = --length;
                final int n6 = array[length] - 1;
                array4[n5] = n6;
                final int n7 = -1;
                BytecodeManager.incBytecodes(12);
                boolean b4;
                if (n6 == n7) {
                    b4 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b4 = false;
                    BytecodeManager.incBytecodes(1);
                }
                b2 = b4;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                final int n8 = length;
                BytecodeManager.incBytecodes(2);
                if (n8 <= 0) {
                    break;
                }
                array3[--length] = array[length];
                BytecodeManager.incBytecodes(8);
            }
            final int[] array5 = array3;
            BytecodeManager.incBytecodes(2);
            return array5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger multiply(final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            BytecodeManager.incBytecodes(3);
            if (signum != 0) {
                final int signum2 = this.signum;
                BytecodeManager.incBytecodes(3);
                if (signum2 != 0) {
                    final int length = this.mag.length;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(3);
                    if (bigInteger == this) {
                        final int n = length;
                        final int n2 = 20;
                        BytecodeManager.incBytecodes(3);
                        if (n > n2) {
                            BytecodeManager.incBytecodes(2);
                            final BigInteger square = this.square();
                            BytecodeManager.incBytecodes(1);
                            return square;
                        }
                    }
                    final int length2 = bigInteger.mag.length;
                    BytecodeManager.incBytecodes(4);
                    final int n3 = length;
                    final int n4 = 80;
                    BytecodeManager.incBytecodes(3);
                    if (n3 >= n4) {
                        final int n5 = length2;
                        final int n6 = 80;
                        BytecodeManager.incBytecodes(3);
                        if (n5 >= n6) {
                            final int n7 = length;
                            final int n8 = 240;
                            BytecodeManager.incBytecodes(3);
                            if (n7 < n8) {
                                final int n9 = length2;
                                final int n10 = 240;
                                BytecodeManager.incBytecodes(3);
                                if (n9 < n10) {
                                    BytecodeManager.incBytecodes(3);
                                    final BigInteger multiplyKaratsuba = multiplyKaratsuba(this, bigInteger);
                                    BytecodeManager.incBytecodes(1);
                                    return multiplyKaratsuba;
                                }
                            }
                            BytecodeManager.incBytecodes(3);
                            final BigInteger multiplyToomCook3 = multiplyToomCook3(this, bigInteger);
                            BytecodeManager.incBytecodes(1);
                            return multiplyToomCook3;
                        }
                    }
                    final int signum3 = this.signum;
                    final int signum4 = bigInteger.signum;
                    BytecodeManager.incBytecodes(5);
                    int n11;
                    if (signum3 == signum4) {
                        n11 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n11 = -1;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n12 = n11;
                    BytecodeManager.incBytecodes(1);
                    final int length3 = bigInteger.mag.length;
                    final int n13 = 1;
                    BytecodeManager.incBytecodes(5);
                    if (length3 == n13) {
                        final int[] mag = this.mag;
                        final int n14 = bigInteger.mag[0];
                        final int n15 = n12;
                        BytecodeManager.incBytecodes(8);
                        final BigInteger multiplyByInt = multiplyByInt(mag, n14, n15);
                        BytecodeManager.incBytecodes(1);
                        return multiplyByInt;
                    }
                    final int length4 = this.mag.length;
                    final int n16 = 1;
                    BytecodeManager.incBytecodes(5);
                    if (length4 == n16) {
                        final int[] mag2 = bigInteger.mag;
                        final int n17 = this.mag[0];
                        final int n18 = n12;
                        BytecodeManager.incBytecodes(8);
                        final BigInteger multiplyByInt2 = multiplyByInt(mag2, n17, n18);
                        BytecodeManager.incBytecodes(1);
                        return multiplyByInt2;
                    }
                    final int[] mag3 = this.mag;
                    final int n19 = length;
                    final int[] mag4 = bigInteger.mag;
                    final int n20 = length2;
                    final int[] array = null;
                    BytecodeManager.incBytecodes(9);
                    final int[] multiplyToLen = this.multiplyToLen(mag3, n19, mag4, n20, array);
                    BytecodeManager.incBytecodes(1);
                    final int[] array2 = multiplyToLen;
                    BytecodeManager.incBytecodes(2);
                    final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array2);
                    BytecodeManager.incBytecodes(1);
                    final int[] array3 = trustedStripLeadingZeroInts;
                    final int n21 = n12;
                    BytecodeManager.incBytecodes(5);
                    final BigInteger bigInteger2 = new BigInteger(array3, n21);
                    BytecodeManager.incBytecodes(1);
                    return bigInteger2;
                }
            }
            final BigInteger zero = BigInteger.ZERO;
            BytecodeManager.incBytecodes(2);
            return zero;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger multiplyByInt(final int[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int bitCount = Integer.bitCount(n);
            final int n3 = 1;
            BytecodeManager.incBytecodes(2);
            if (bitCount == n3) {
                BytecodeManager.incBytecodes(5);
                final int numberOfTrailingZeros = Integer.numberOfTrailingZeros(n);
                BytecodeManager.incBytecodes(1);
                final int[] shiftLeft = shiftLeft(array, numberOfTrailingZeros);
                BytecodeManager.incBytecodes(2);
                final BigInteger bigInteger = new BigInteger(shiftLeft, n2);
                BytecodeManager.incBytecodes(1);
                return bigInteger;
            }
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int[] copyOfRange = new int[length + 1];
            BytecodeManager.incBytecodes(4);
            long n4 = 0L;
            BytecodeManager.incBytecodes(2);
            final long n5 = (long)n & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            int n6 = copyOfRange.length - 1;
            BytecodeManager.incBytecodes(5);
            int n7 = length - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n8 = n7;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    break;
                }
                final long n9 = ((long)array[n7] & 0xFFFFFFFFL) * n5 + n4;
                BytecodeManager.incBytecodes(11);
                copyOfRange[n6--] = (int)n9;
                BytecodeManager.incBytecodes(6);
                n4 = n9 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n7;
                BytecodeManager.incBytecodes(2);
            }
            final long n10 = lcmp(n4, 0L);
            BytecodeManager.incBytecodes(4);
            if (n10 == 0) {
                final int[] array2 = copyOfRange;
                final int n11 = 1;
                final int length2 = copyOfRange.length;
                BytecodeManager.incBytecodes(5);
                copyOfRange = Arrays.copyOfRange(array2, n11, length2);
                BytecodeManager.incBytecodes(2);
            }
            else {
                copyOfRange[n6] = (int)n4;
                BytecodeManager.incBytecodes(5);
            }
            final int[] array3 = copyOfRange;
            BytecodeManager.incBytecodes(5);
            final BigInteger bigInteger2 = new BigInteger(array3, n2);
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BigInteger multiply(long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 != 0) {
                final int signum = this.signum;
                BytecodeManager.incBytecodes(3);
                if (signum != 0) {
                    final long n3 = lcmp(n, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(4);
                    if (n3 == 0) {
                        final long n4 = n;
                        BytecodeManager.incBytecodes(3);
                        final BigInteger value = valueOf(n4);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger multiply = this.multiply(value);
                        BytecodeManager.incBytecodes(1);
                        return multiply;
                    }
                    final long n5 = lcmp(n, 0L);
                    BytecodeManager.incBytecodes(4);
                    int signum2;
                    if (n5 > 0) {
                        signum2 = this.signum;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        signum2 = -this.signum;
                        BytecodeManager.incBytecodes(3);
                    }
                    final int n6 = signum2;
                    BytecodeManager.incBytecodes(1);
                    final long n7 = lcmp(n, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n7 < 0) {
                        n = -n;
                        BytecodeManager.incBytecodes(3);
                    }
                    final long n8 = n >>> 32;
                    BytecodeManager.incBytecodes(4);
                    final long n9 = n & 0xFFFFFFFFL;
                    BytecodeManager.incBytecodes(4);
                    final int length = this.mag.length;
                    BytecodeManager.incBytecodes(4);
                    final int[] mag = this.mag;
                    BytecodeManager.incBytecodes(3);
                    final long n10 = lcmp(n8, 0L);
                    BytecodeManager.incBytecodes(4);
                    int[] array;
                    if (n10 == 0) {
                        array = new int[length + 1];
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        array = new int[length + 2];
                        BytecodeManager.incBytecodes(3);
                    }
                    int[] copyOfRange = array;
                    BytecodeManager.incBytecodes(1);
                    long n11 = 0L;
                    BytecodeManager.incBytecodes(2);
                    int n12 = copyOfRange.length - 1;
                    BytecodeManager.incBytecodes(5);
                    int n13 = length - 1;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n14 = n13;
                        BytecodeManager.incBytecodes(2);
                        if (n14 < 0) {
                            break;
                        }
                        final long n15 = ((long)mag[n13] & 0xFFFFFFFFL) * n9 + n11;
                        BytecodeManager.incBytecodes(11);
                        copyOfRange[n12--] = (int)n15;
                        BytecodeManager.incBytecodes(6);
                        n11 = n15 >>> 32;
                        BytecodeManager.incBytecodes(4);
                        --n13;
                        BytecodeManager.incBytecodes(2);
                    }
                    copyOfRange[n12] = (int)n11;
                    BytecodeManager.incBytecodes(5);
                    final long n16 = lcmp(n8, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n16 != 0) {
                        n11 = 0L;
                        BytecodeManager.incBytecodes(2);
                        int n17 = copyOfRange.length - 2;
                        BytecodeManager.incBytecodes(5);
                        int n18 = length - 1;
                        BytecodeManager.incBytecodes(4);
                        while (true) {
                            final int n19 = n18;
                            BytecodeManager.incBytecodes(2);
                            if (n19 < 0) {
                                break;
                            }
                            final long n20 = ((long)mag[n18] & 0xFFFFFFFFL) * n8 + ((long)copyOfRange[n17] & 0xFFFFFFFFL) + n11;
                            BytecodeManager.incBytecodes(18);
                            copyOfRange[n17--] = (int)n20;
                            BytecodeManager.incBytecodes(6);
                            n11 = n20 >>> 32;
                            BytecodeManager.incBytecodes(4);
                            --n18;
                            BytecodeManager.incBytecodes(2);
                        }
                        copyOfRange[0] = (int)n11;
                        BytecodeManager.incBytecodes(5);
                    }
                    final long n21 = lcmp(n11, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n21 == 0) {
                        final int[] array2 = copyOfRange;
                        final int n22 = 1;
                        final int length2 = copyOfRange.length;
                        BytecodeManager.incBytecodes(5);
                        copyOfRange = Arrays.copyOfRange(array2, n22, length2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int[] array3 = copyOfRange;
                    final int n23 = n6;
                    BytecodeManager.incBytecodes(5);
                    final BigInteger bigInteger = new BigInteger(array3, n23);
                    BytecodeManager.incBytecodes(1);
                    return bigInteger;
                }
            }
            final BigInteger zero = BigInteger.ZERO;
            BytecodeManager.incBytecodes(2);
            return zero;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int[] multiplyToLen(final int[] array, final int n, final int[] array2, final int n2, int[] array3) {
        try {
            final int n3 = n - 1;
            BytecodeManager.incBytecodes(4);
            final int n4 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            final int[] array4 = array3;
            BytecodeManager.incBytecodes(2);
            Label_0059: {
                if (array4 != null) {
                    final int length = array3.length;
                    final int n5 = n + n2;
                    BytecodeManager.incBytecodes(6);
                    if (length >= n5) {
                        break Label_0059;
                    }
                }
                array3 = new int[n + n2];
                BytecodeManager.incBytecodes(4);
            }
            long n6 = 0L;
            BytecodeManager.incBytecodes(2);
            int n7 = n4;
            int n8 = n4 + 1 + n3;
            BytecodeManager.incBytecodes(8);
            while (true) {
                final int n9 = n7;
                BytecodeManager.incBytecodes(2);
                if (n9 < 0) {
                    break;
                }
                final long n10 = ((long)array2[n7] & 0xFFFFFFFFL) * ((long)array[n3] & 0xFFFFFFFFL) + n6;
                BytecodeManager.incBytecodes(16);
                array3[n8] = (int)n10;
                BytecodeManager.incBytecodes(5);
                n6 = n10 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n7;
                --n8;
                BytecodeManager.incBytecodes(3);
            }
            array3[n3] = (int)n6;
            BytecodeManager.incBytecodes(5);
            int n11 = n3 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n12 = n11;
                BytecodeManager.incBytecodes(2);
                if (n12 < 0) {
                    break;
                }
                long n13 = 0L;
                BytecodeManager.incBytecodes(2);
                int n14 = n4;
                int n15 = n4 + 1 + n11;
                BytecodeManager.incBytecodes(8);
                while (true) {
                    final int n16 = n14;
                    BytecodeManager.incBytecodes(2);
                    if (n16 < 0) {
                        break;
                    }
                    final long n17 = ((long)array2[n14] & 0xFFFFFFFFL) * ((long)array[n11] & 0xFFFFFFFFL) + ((long)array3[n15] & 0xFFFFFFFFL) + n13;
                    BytecodeManager.incBytecodes(23);
                    array3[n15] = (int)n17;
                    BytecodeManager.incBytecodes(5);
                    n13 = n17 >>> 32;
                    BytecodeManager.incBytecodes(4);
                    --n14;
                    --n15;
                    BytecodeManager.incBytecodes(3);
                }
                array3[n11] = (int)n13;
                BytecodeManager.incBytecodes(5);
                --n11;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array5 = array3;
            BytecodeManager.incBytecodes(2);
            return array5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger multiplyKaratsuba(final BigInteger bigInteger, final BigInteger bigInteger2) {
        try {
            final int length = bigInteger.mag.length;
            BytecodeManager.incBytecodes(4);
            final int length2 = bigInteger2.mag.length;
            BytecodeManager.incBytecodes(4);
            final int a = length;
            final int b = length2;
            BytecodeManager.incBytecodes(3);
            final int n = (Math.max(a, b) + 1) / 2;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger lower = bigInteger.getLower(n2);
            BytecodeManager.incBytecodes(1);
            final int n3 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger upper = bigInteger.getUpper(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger lower2 = bigInteger2.getLower(n4);
            BytecodeManager.incBytecodes(1);
            final int n5 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger upper2 = bigInteger2.getUpper(n5);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = upper;
            final BigInteger bigInteger4 = upper2;
            BytecodeManager.incBytecodes(3);
            final BigInteger multiply = bigInteger3.multiply(bigInteger4);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger5 = lower;
            final BigInteger bigInteger6 = lower2;
            BytecodeManager.incBytecodes(3);
            final BigInteger multiply2 = bigInteger5.multiply(bigInteger6);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger7 = upper;
            final BigInteger bigInteger8 = lower;
            BytecodeManager.incBytecodes(3);
            final BigInteger add = bigInteger7.add(bigInteger8);
            final BigInteger bigInteger9 = upper2;
            final BigInteger bigInteger10 = lower2;
            BytecodeManager.incBytecodes(3);
            final BigInteger add2 = bigInteger9.add(bigInteger10);
            BytecodeManager.incBytecodes(1);
            final BigInteger multiply3 = add.multiply(add2);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger11 = multiply;
            final int n6 = 32 * n;
            BytecodeManager.incBytecodes(5);
            final BigInteger shiftLeft = bigInteger11.shiftLeft(n6);
            final BigInteger bigInteger12 = multiply3;
            final BigInteger bigInteger13 = multiply;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract = bigInteger12.subtract(bigInteger13);
            final BigInteger bigInteger14 = multiply2;
            BytecodeManager.incBytecodes(2);
            final BigInteger subtract2 = subtract.subtract(bigInteger14);
            BytecodeManager.incBytecodes(1);
            final BigInteger add3 = shiftLeft.add(subtract2);
            final int n7 = 32 * n;
            BytecodeManager.incBytecodes(4);
            final BigInteger shiftLeft2 = add3.shiftLeft(n7);
            final BigInteger bigInteger15 = multiply2;
            BytecodeManager.incBytecodes(2);
            final BigInteger add4 = shiftLeft2.add(bigInteger15);
            BytecodeManager.incBytecodes(1);
            final int signum = bigInteger.signum;
            final int signum2 = bigInteger2.signum;
            BytecodeManager.incBytecodes(5);
            if (signum != signum2) {
                final BigInteger bigInteger16 = add4;
                BytecodeManager.incBytecodes(2);
                final BigInteger negate = bigInteger16.negate();
                BytecodeManager.incBytecodes(1);
                return negate;
            }
            final BigInteger bigInteger17 = add4;
            BytecodeManager.incBytecodes(2);
            return bigInteger17;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger multiplyToomCook3(final BigInteger bigInteger, final BigInteger bigInteger2) {
        try {
            final int length = bigInteger.mag.length;
            BytecodeManager.incBytecodes(4);
            final int length2 = bigInteger2.mag.length;
            BytecodeManager.incBytecodes(4);
            final int a = length;
            final int b = length2;
            BytecodeManager.incBytecodes(3);
            final int max = Math.max(a, b);
            BytecodeManager.incBytecodes(1);
            final int n = (max + 2) / 3;
            BytecodeManager.incBytecodes(6);
            final int n2 = max - 2 * n;
            BytecodeManager.incBytecodes(6);
            final int n3 = n;
            final int n4 = n2;
            final int n5 = 0;
            final int n6 = max;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice = bigInteger.getToomSlice(n3, n4, n5, n6);
            BytecodeManager.incBytecodes(1);
            final int n7 = n;
            final int n8 = n2;
            final int n9 = 1;
            final int n10 = max;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice2 = bigInteger.getToomSlice(n7, n8, n9, n10);
            BytecodeManager.incBytecodes(1);
            final int n11 = n;
            final int n12 = n2;
            final int n13 = 2;
            final int n14 = max;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice3 = bigInteger.getToomSlice(n11, n12, n13, n14);
            BytecodeManager.incBytecodes(1);
            final int n15 = n;
            final int n16 = n2;
            final int n17 = 0;
            final int n18 = max;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice4 = bigInteger2.getToomSlice(n15, n16, n17, n18);
            BytecodeManager.incBytecodes(1);
            final int n19 = n;
            final int n20 = n2;
            final int n21 = 1;
            final int n22 = max;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice5 = bigInteger2.getToomSlice(n19, n20, n21, n22);
            BytecodeManager.incBytecodes(1);
            final int n23 = n;
            final int n24 = n2;
            final int n25 = 2;
            final int n26 = max;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice6 = bigInteger2.getToomSlice(n23, n24, n25, n26);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = toomSlice3;
            final BigInteger bigInteger4 = toomSlice6;
            BytecodeManager.incBytecodes(3);
            final BigInteger multiply = bigInteger3.multiply(bigInteger4);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger5 = toomSlice;
            final BigInteger bigInteger6 = toomSlice3;
            BytecodeManager.incBytecodes(3);
            final BigInteger add = bigInteger5.add(bigInteger6);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger7 = toomSlice4;
            final BigInteger bigInteger8 = toomSlice6;
            BytecodeManager.incBytecodes(3);
            final BigInteger add2 = bigInteger7.add(bigInteger8);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger9 = add;
            final BigInteger bigInteger10 = toomSlice2;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract = bigInteger9.subtract(bigInteger10);
            final BigInteger bigInteger11 = add2;
            final BigInteger bigInteger12 = toomSlice5;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract2 = bigInteger11.subtract(bigInteger12);
            BytecodeManager.incBytecodes(1);
            final BigInteger multiply2 = subtract.multiply(subtract2);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger13 = add;
            final BigInteger bigInteger14 = toomSlice2;
            BytecodeManager.incBytecodes(3);
            final BigInteger add3 = bigInteger13.add(bigInteger14);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger15 = add2;
            final BigInteger bigInteger16 = toomSlice5;
            BytecodeManager.incBytecodes(3);
            final BigInteger add4 = bigInteger15.add(bigInteger16);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger17 = add3;
            final BigInteger bigInteger18 = add4;
            BytecodeManager.incBytecodes(3);
            final BigInteger multiply3 = bigInteger17.multiply(bigInteger18);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger19 = add3;
            final BigInteger bigInteger20 = toomSlice;
            BytecodeManager.incBytecodes(3);
            final BigInteger add5 = bigInteger19.add(bigInteger20);
            final int n27 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft = add5.shiftLeft(n27);
            final BigInteger bigInteger21 = toomSlice3;
            BytecodeManager.incBytecodes(2);
            final BigInteger subtract3 = shiftLeft.subtract(bigInteger21);
            final BigInteger bigInteger22 = add4;
            final BigInteger bigInteger23 = toomSlice4;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final BigInteger add6 = bigInteger22.add(bigInteger23);
            final int n28 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft2 = add6.shiftLeft(n28);
            final BigInteger bigInteger24 = toomSlice6;
            BytecodeManager.incBytecodes(2);
            final BigInteger subtract4 = shiftLeft2.subtract(bigInteger24);
            BytecodeManager.incBytecodes(1);
            final BigInteger multiply4 = subtract3.multiply(subtract4);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger25 = toomSlice;
            final BigInteger bigInteger26 = toomSlice4;
            BytecodeManager.incBytecodes(3);
            final BigInteger multiply5 = bigInteger25.multiply(bigInteger26);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger27 = multiply4;
            final BigInteger bigInteger28 = multiply2;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract5 = bigInteger27.subtract(bigInteger28);
            BytecodeManager.incBytecodes(1);
            final BigInteger exactDivideBy3 = subtract5.exactDivideBy3();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger29 = multiply3;
            final BigInteger bigInteger30 = multiply2;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract6 = bigInteger29.subtract(bigInteger30);
            final int n29 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftRight = subtract6.shiftRight(n29);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger31 = multiply3;
            final BigInteger bigInteger32 = multiply;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract7 = bigInteger31.subtract(bigInteger32);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger33 = exactDivideBy3;
            final BigInteger bigInteger34 = subtract7;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract8 = bigInteger33.subtract(bigInteger34);
            final int n30 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftRight2 = subtract8.shiftRight(n30);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger35 = subtract7;
            final BigInteger bigInteger36 = shiftRight;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract9 = bigInteger35.subtract(bigInteger36);
            final BigInteger bigInteger37 = multiply5;
            BytecodeManager.incBytecodes(2);
            final BigInteger subtract10 = subtract9.subtract(bigInteger37);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger38 = shiftRight2;
            final BigInteger bigInteger39 = multiply5;
            final int n31 = 1;
            BytecodeManager.incBytecodes(4);
            final BigInteger shiftLeft3 = bigInteger39.shiftLeft(n31);
            BytecodeManager.incBytecodes(1);
            final BigInteger subtract11 = bigInteger38.subtract(shiftLeft3);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger40 = shiftRight;
            final BigInteger bigInteger41 = subtract11;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract12 = bigInteger40.subtract(bigInteger41);
            BytecodeManager.incBytecodes(1);
            final int n32 = n * 32;
            BytecodeManager.incBytecodes(4);
            final BigInteger bigInteger42 = multiply5;
            final int n33 = n32;
            BytecodeManager.incBytecodes(3);
            final BigInteger shiftLeft4 = bigInteger42.shiftLeft(n33);
            final BigInteger bigInteger43 = subtract11;
            BytecodeManager.incBytecodes(2);
            final BigInteger add7 = shiftLeft4.add(bigInteger43);
            final int n34 = n32;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft5 = add7.shiftLeft(n34);
            final BigInteger bigInteger44 = subtract10;
            BytecodeManager.incBytecodes(2);
            final BigInteger add8 = shiftLeft5.add(bigInteger44);
            final int n35 = n32;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft6 = add8.shiftLeft(n35);
            final BigInteger bigInteger45 = subtract12;
            BytecodeManager.incBytecodes(2);
            final BigInteger add9 = shiftLeft6.add(bigInteger45);
            final int n36 = n32;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft7 = add9.shiftLeft(n36);
            final BigInteger bigInteger46 = multiply;
            BytecodeManager.incBytecodes(2);
            final BigInteger add10 = shiftLeft7.add(bigInteger46);
            BytecodeManager.incBytecodes(1);
            final int signum = bigInteger.signum;
            final int signum2 = bigInteger2.signum;
            BytecodeManager.incBytecodes(5);
            if (signum != signum2) {
                final BigInteger bigInteger47 = add10;
                BytecodeManager.incBytecodes(2);
                final BigInteger negate = bigInteger47.negate();
                BytecodeManager.incBytecodes(1);
                return negate;
            }
            final BigInteger bigInteger48 = add10;
            BytecodeManager.incBytecodes(2);
            return bigInteger48;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger getToomSlice(final int n, final int n2, final int n3, final int n4) {
        try {
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            final int n5 = n4 - length;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            int n6;
            int n7;
            if (n3 == 0) {
                n6 = 0 - n5;
                BytecodeManager.incBytecodes(4);
                n7 = n2 - 1 - n5;
                BytecodeManager.incBytecodes(7);
            }
            else {
                n6 = n2 + (n3 - 1) * n - n5;
                BytecodeManager.incBytecodes(10);
                n7 = n6 + n - 1;
                BytecodeManager.incBytecodes(6);
            }
            final int n8 = n6;
            BytecodeManager.incBytecodes(2);
            if (n8 < 0) {
                n6 = 0;
                BytecodeManager.incBytecodes(2);
            }
            final int n9 = n7;
            BytecodeManager.incBytecodes(2);
            if (n9 < 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int n10 = n7 - n6 + 1;
            BytecodeManager.incBytecodes(6);
            final int n11 = n10;
            BytecodeManager.incBytecodes(2);
            if (n11 <= 0) {
                final BigInteger zero2 = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero2;
            }
            final int n12 = n6;
            BytecodeManager.incBytecodes(2);
            if (n12 == 0) {
                final int n13 = n10;
                final int n14 = length;
                BytecodeManager.incBytecodes(3);
                if (n13 >= n14) {
                    BytecodeManager.incBytecodes(2);
                    final BigInteger abs = this.abs();
                    BytecodeManager.incBytecodes(1);
                    return abs;
                }
            }
            final int[] array = new int[n10];
            BytecodeManager.incBytecodes(2);
            final int[] mag = this.mag;
            final int n15 = n6;
            final int[] array2 = array;
            final int n16 = 0;
            final int n17 = n10;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(mag, n15, array2, n16, n17);
            final int[] array3 = array;
            BytecodeManager.incBytecodes(4);
            final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array3);
            final int n18 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger bigInteger = new BigInteger(trustedStripLeadingZeroInts, n18);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger exactDivideBy3() {
        try {
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            final int[] array = new int[length];
            BytecodeManager.incBytecodes(2);
            long n = 0L;
            BytecodeManager.incBytecodes(2);
            int n2 = length - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 < 0) {
                    break;
                }
                final long n4 = (long)this.mag[n2] & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(8);
                final long n5 = n4 - n;
                BytecodeManager.incBytecodes(4);
                final long n6 = lcmp(n, n4);
                BytecodeManager.incBytecodes(4);
                if (n6 > 0) {
                    n = 1L;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n = 0L;
                    BytecodeManager.incBytecodes(2);
                }
                final long n7 = n5 * 2863311531L & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(6);
                array[n2] = (int)n7;
                BytecodeManager.incBytecodes(5);
                final long n8 = lcmp(n7, 1431655766L);
                BytecodeManager.incBytecodes(4);
                if (n8 >= 0) {
                    ++n;
                    BytecodeManager.incBytecodes(4);
                    final long n9 = lcmp(n7, 2863311531L);
                    BytecodeManager.incBytecodes(4);
                    if (n9 >= 0) {
                        ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array2 = array;
            BytecodeManager.incBytecodes(2);
            final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array2);
            BytecodeManager.incBytecodes(1);
            final int[] array3 = trustedStripLeadingZeroInts;
            final int signum = this.signum;
            BytecodeManager.incBytecodes(6);
            final BigInteger bigInteger = new BigInteger(array3, signum);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger getLower(final int n) {
        try {
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            final int n2 = length;
            BytecodeManager.incBytecodes(3);
            if (n2 <= n) {
                BytecodeManager.incBytecodes(2);
                final BigInteger abs = this.abs();
                BytecodeManager.incBytecodes(1);
                return abs;
            }
            final int[] array = new int[n];
            BytecodeManager.incBytecodes(2);
            final int[] mag = this.mag;
            final int n3 = length - n;
            final int[] array2 = array;
            final int n4 = 0;
            BytecodeManager.incBytecodes(9);
            System.arraycopy(mag, n3, array2, n4, n);
            final int[] array3 = array;
            BytecodeManager.incBytecodes(4);
            final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array3);
            final int n5 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger bigInteger = new BigInteger(trustedStripLeadingZeroInts, n5);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger getUpper(final int n) {
        try {
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            final int n2 = length;
            BytecodeManager.incBytecodes(3);
            if (n2 <= n) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int n3 = length - n;
            BytecodeManager.incBytecodes(4);
            final int[] array = new int[n3];
            BytecodeManager.incBytecodes(2);
            final int[] mag = this.mag;
            final int n4 = 0;
            final int[] array2 = array;
            final int n5 = 0;
            final int n6 = n3;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(mag, n4, array2, n5, n6);
            final int[] array3 = array;
            BytecodeManager.incBytecodes(4);
            final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array3);
            final int n7 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger bigInteger = new BigInteger(trustedStripLeadingZeroInts, n7);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger square() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            final int n = length;
            final int n2 = 128;
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final int[] mag = this.mag;
                final int n3 = length;
                final int[] array = null;
                BytecodeManager.incBytecodes(5);
                final int[] squareToLen = squareToLen(mag, n3, array);
                BytecodeManager.incBytecodes(1);
                final int[] array2 = squareToLen;
                BytecodeManager.incBytecodes(4);
                final int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(array2);
                final int n4 = 1;
                BytecodeManager.incBytecodes(2);
                final BigInteger bigInteger = new BigInteger(trustedStripLeadingZeroInts, n4);
                BytecodeManager.incBytecodes(1);
                return bigInteger;
            }
            final int n5 = length;
            final int n6 = 216;
            BytecodeManager.incBytecodes(3);
            if (n5 < n6) {
                BytecodeManager.incBytecodes(2);
                final BigInteger squareKaratsuba = this.squareKaratsuba();
                BytecodeManager.incBytecodes(1);
                return squareKaratsuba;
            }
            BytecodeManager.incBytecodes(2);
            final BigInteger squareToomCook3 = this.squareToomCook3();
            BytecodeManager.incBytecodes(1);
            return squareToomCook3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final int[] squareToLen(final int[] array, final int n, int[] array2) {
        try {
            final int n2 = n << 1;
            BytecodeManager.incBytecodes(4);
            final int[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            Label_0038: {
                if (array3 != null) {
                    final int length = array2.length;
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(4);
                    if (length >= n3) {
                        break Label_0038;
                    }
                }
                array2 = new int[n2];
                BytecodeManager.incBytecodes(2);
            }
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            int n5 = 0;
            int n6 = 0;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n5;
                BytecodeManager.incBytecodes(3);
                if (n7 >= n) {
                    break;
                }
                final long n8 = (long)array[n5] & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(7);
                final long n9 = n8 * n8;
                BytecodeManager.incBytecodes(4);
                array2[n6++] = (n4 << 31 | (int)(n9 >>> 33));
                BytecodeManager.incBytecodes(12);
                array2[n6++] = (int)(n9 >>> 1);
                BytecodeManager.incBytecodes(8);
                n4 = (int)n9;
                BytecodeManager.incBytecodes(3);
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            int n10 = n;
            int n11 = 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n12 = n10;
                BytecodeManager.incBytecodes(2);
                if (n12 <= 0) {
                    break;
                }
                final int n13 = array[n10 - 1];
                BytecodeManager.incBytecodes(6);
                final int[] array4 = array2;
                final int n14 = n11;
                final int n15 = n10 - 1;
                final int n16 = n13;
                BytecodeManager.incBytecodes(8);
                final int mulAdd = mulAdd(array4, array, n14, n15, n16);
                BytecodeManager.incBytecodes(1);
                final int[] array5 = array2;
                final int n17 = n11 - 1;
                final int n18 = n10;
                final int n19 = mulAdd;
                BytecodeManager.incBytecodes(7);
                addOne(array5, n17, n18, n19);
                BytecodeManager.incBytecodes(1);
                --n10;
                n11 += 2;
                BytecodeManager.incBytecodes(3);
            }
            final int[] array6 = array2;
            final int n20 = n2;
            final int n21 = 1;
            BytecodeManager.incBytecodes(4);
            primitiveLeftShift(array6, n20, n21);
            final int[] array7 = array2;
            final int n22 = n2 - 1;
            array7[n22] |= (array[n - 1] & 0x1);
            BytecodeManager.incBytecodes(15);
            final int[] array8 = array2;
            BytecodeManager.incBytecodes(2);
            return array8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger squareKaratsuba() {
        try {
            final int n = (this.mag.length + 1) / 2;
            BytecodeManager.incBytecodes(8);
            final int n2 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger lower = this.getLower(n2);
            BytecodeManager.incBytecodes(1);
            final int n3 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger upper = this.getUpper(n3);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger = upper;
            BytecodeManager.incBytecodes(2);
            final BigInteger square = bigInteger.square();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger2 = lower;
            BytecodeManager.incBytecodes(2);
            final BigInteger square2 = bigInteger2.square();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = square;
            final int n4 = n * 32;
            BytecodeManager.incBytecodes(5);
            final BigInteger shiftLeft = bigInteger3.shiftLeft(n4);
            final BigInteger bigInteger4 = lower;
            final BigInteger bigInteger5 = upper;
            BytecodeManager.incBytecodes(3);
            final BigInteger add = bigInteger4.add(bigInteger5);
            BytecodeManager.incBytecodes(1);
            final BigInteger square3 = add.square();
            final BigInteger bigInteger6 = square;
            final BigInteger bigInteger7 = square2;
            BytecodeManager.incBytecodes(3);
            final BigInteger add2 = bigInteger6.add(bigInteger7);
            BytecodeManager.incBytecodes(1);
            final BigInteger subtract = square3.subtract(add2);
            BytecodeManager.incBytecodes(1);
            final BigInteger add3 = shiftLeft.add(subtract);
            final int n5 = n * 32;
            BytecodeManager.incBytecodes(4);
            final BigInteger shiftLeft2 = add3.shiftLeft(n5);
            final BigInteger bigInteger8 = square2;
            BytecodeManager.incBytecodes(2);
            final BigInteger add4 = shiftLeft2.add(bigInteger8);
            BytecodeManager.incBytecodes(1);
            return add4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger squareToomCook3() {
        try {
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            final int n = (length + 2) / 3;
            BytecodeManager.incBytecodes(6);
            final int n2 = length - 2 * n;
            BytecodeManager.incBytecodes(6);
            final int n3 = n;
            final int n4 = n2;
            final int n5 = 0;
            final int n6 = length;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice = this.getToomSlice(n3, n4, n5, n6);
            BytecodeManager.incBytecodes(1);
            final int n7 = n;
            final int n8 = n2;
            final int n9 = 1;
            final int n10 = length;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice2 = this.getToomSlice(n7, n8, n9, n10);
            BytecodeManager.incBytecodes(1);
            final int n11 = n;
            final int n12 = n2;
            final int n13 = 2;
            final int n14 = length;
            BytecodeManager.incBytecodes(6);
            final BigInteger toomSlice3 = this.getToomSlice(n11, n12, n13, n14);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger = toomSlice3;
            BytecodeManager.incBytecodes(2);
            final BigInteger square = bigInteger.square();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger2 = toomSlice;
            final BigInteger bigInteger3 = toomSlice3;
            BytecodeManager.incBytecodes(3);
            final BigInteger add = bigInteger2.add(bigInteger3);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger4 = add;
            final BigInteger bigInteger5 = toomSlice2;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract = bigInteger4.subtract(bigInteger5);
            BytecodeManager.incBytecodes(1);
            final BigInteger square2 = subtract.square();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger6 = add;
            final BigInteger bigInteger7 = toomSlice2;
            BytecodeManager.incBytecodes(3);
            final BigInteger add2 = bigInteger6.add(bigInteger7);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger8 = add2;
            BytecodeManager.incBytecodes(2);
            final BigInteger square3 = bigInteger8.square();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger9 = toomSlice;
            BytecodeManager.incBytecodes(2);
            final BigInteger square4 = bigInteger9.square();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger10 = add2;
            final BigInteger bigInteger11 = toomSlice;
            BytecodeManager.incBytecodes(3);
            final BigInteger add3 = bigInteger10.add(bigInteger11);
            final int n15 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft = add3.shiftLeft(n15);
            final BigInteger bigInteger12 = toomSlice3;
            BytecodeManager.incBytecodes(2);
            final BigInteger subtract2 = shiftLeft.subtract(bigInteger12);
            BytecodeManager.incBytecodes(1);
            final BigInteger square5 = subtract2.square();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger13 = square5;
            final BigInteger bigInteger14 = square2;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract3 = bigInteger13.subtract(bigInteger14);
            BytecodeManager.incBytecodes(1);
            final BigInteger exactDivideBy3 = subtract3.exactDivideBy3();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger15 = square3;
            final BigInteger bigInteger16 = square2;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract4 = bigInteger15.subtract(bigInteger16);
            final int n16 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftRight = subtract4.shiftRight(n16);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger17 = square3;
            final BigInteger bigInteger18 = square;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract5 = bigInteger17.subtract(bigInteger18);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger19 = exactDivideBy3;
            final BigInteger bigInteger20 = subtract5;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract6 = bigInteger19.subtract(bigInteger20);
            final int n17 = 1;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftRight2 = subtract6.shiftRight(n17);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger21 = subtract5;
            final BigInteger bigInteger22 = shiftRight;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract7 = bigInteger21.subtract(bigInteger22);
            final BigInteger bigInteger23 = square4;
            BytecodeManager.incBytecodes(2);
            final BigInteger subtract8 = subtract7.subtract(bigInteger23);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger24 = shiftRight2;
            final BigInteger bigInteger25 = square4;
            final int n18 = 1;
            BytecodeManager.incBytecodes(4);
            final BigInteger shiftLeft2 = bigInteger25.shiftLeft(n18);
            BytecodeManager.incBytecodes(1);
            final BigInteger subtract9 = bigInteger24.subtract(shiftLeft2);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger26 = shiftRight;
            final BigInteger bigInteger27 = subtract9;
            BytecodeManager.incBytecodes(3);
            final BigInteger subtract10 = bigInteger26.subtract(bigInteger27);
            BytecodeManager.incBytecodes(1);
            final int n19 = n * 32;
            BytecodeManager.incBytecodes(4);
            final BigInteger bigInteger28 = square4;
            final int n20 = n19;
            BytecodeManager.incBytecodes(3);
            final BigInteger shiftLeft3 = bigInteger28.shiftLeft(n20);
            final BigInteger bigInteger29 = subtract9;
            BytecodeManager.incBytecodes(2);
            final BigInteger add4 = shiftLeft3.add(bigInteger29);
            final int n21 = n19;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft4 = add4.shiftLeft(n21);
            final BigInteger bigInteger30 = subtract8;
            BytecodeManager.incBytecodes(2);
            final BigInteger add5 = shiftLeft4.add(bigInteger30);
            final int n22 = n19;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft5 = add5.shiftLeft(n22);
            final BigInteger bigInteger31 = subtract10;
            BytecodeManager.incBytecodes(2);
            final BigInteger add6 = shiftLeft5.add(bigInteger31);
            final int n23 = n19;
            BytecodeManager.incBytecodes(2);
            final BigInteger shiftLeft6 = add6.shiftLeft(n23);
            final BigInteger bigInteger32 = square;
            BytecodeManager.incBytecodes(2);
            final BigInteger add7 = shiftLeft6.add(bigInteger32);
            BytecodeManager.incBytecodes(1);
            return add7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger divide(final BigInteger bigInteger) {
        try {
            final int length = bigInteger.mag.length;
            final int n = 80;
            BytecodeManager.incBytecodes(5);
            if (length >= n) {
                final int n2 = this.mag.length - bigInteger.mag.length;
                final int n3 = 40;
                BytecodeManager.incBytecodes(9);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(3);
                    final BigInteger divideBurnikelZiegler = this.divideBurnikelZiegler(bigInteger);
                    BytecodeManager.incBytecodes(1);
                    return divideBurnikelZiegler;
                }
            }
            BytecodeManager.incBytecodes(3);
            final BigInteger divideKnuth = this.divideKnuth(bigInteger);
            BytecodeManager.incBytecodes(1);
            return divideKnuth;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger divideKnuth(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final int[] mag = this.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(mag);
            BytecodeManager.incBytecodes(1);
            final int[] mag2 = bigInteger.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mag2);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            mutableBigInteger4.divideKnuth(mutableBigInteger5, mutableBigInteger6, b);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger7 = mutableBigInteger;
            final int n = this.signum * bigInteger.signum;
            BytecodeManager.incBytecodes(7);
            final BigInteger bigInteger2 = mutableBigInteger7.toBigInteger(n);
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger[] divideAndRemainder(final BigInteger bigInteger) {
        try {
            final int length = bigInteger.mag.length;
            final int n = 80;
            BytecodeManager.incBytecodes(5);
            if (length >= n) {
                final int n2 = this.mag.length - bigInteger.mag.length;
                final int n3 = 40;
                BytecodeManager.incBytecodes(9);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(3);
                    final BigInteger[] divideAndRemainderBurnikelZiegler = this.divideAndRemainderBurnikelZiegler(bigInteger);
                    BytecodeManager.incBytecodes(1);
                    return divideAndRemainderBurnikelZiegler;
                }
            }
            BytecodeManager.incBytecodes(3);
            final BigInteger[] divideAndRemainderKnuth = this.divideAndRemainderKnuth(bigInteger);
            BytecodeManager.incBytecodes(1);
            return divideAndRemainderKnuth;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger[] divideAndRemainderKnuth(final BigInteger bigInteger) {
        try {
            final BigInteger[] array = new BigInteger[2];
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final int[] mag = this.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(mag);
            BytecodeManager.incBytecodes(1);
            final int[] mag2 = bigInteger.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mag2);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divideKnuth = mutableBigInteger4.divideKnuth(mutableBigInteger5, mutableBigInteger6);
            BytecodeManager.incBytecodes(1);
            final BigInteger[] array2 = array;
            final int n = 0;
            final MutableBigInteger mutableBigInteger7 = mutableBigInteger;
            final int signum = this.signum;
            final int signum2 = bigInteger.signum;
            BytecodeManager.incBytecodes(8);
            int n2;
            if (signum == signum2) {
                n2 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = -1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            array2[n] = mutableBigInteger7.toBigInteger(n2);
            BytecodeManager.incBytecodes(1);
            final BigInteger[] array3 = array;
            final int n3 = 1;
            final MutableBigInteger mutableBigInteger8 = divideKnuth;
            final int signum3 = this.signum;
            BytecodeManager.incBytecodes(6);
            array3[n3] = mutableBigInteger8.toBigInteger(signum3);
            BytecodeManager.incBytecodes(1);
            final BigInteger[] array4 = array;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger remainder(final BigInteger bigInteger) {
        try {
            final int length = bigInteger.mag.length;
            final int n = 80;
            BytecodeManager.incBytecodes(5);
            if (length >= n) {
                final int n2 = this.mag.length - bigInteger.mag.length;
                final int n3 = 40;
                BytecodeManager.incBytecodes(9);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(3);
                    final BigInteger remainderBurnikelZiegler = this.remainderBurnikelZiegler(bigInteger);
                    BytecodeManager.incBytecodes(1);
                    return remainderBurnikelZiegler;
                }
            }
            BytecodeManager.incBytecodes(3);
            final BigInteger remainderKnuth = this.remainderKnuth(bigInteger);
            BytecodeManager.incBytecodes(1);
            return remainderKnuth;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger remainderKnuth(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final int[] mag = this.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(mag);
            BytecodeManager.incBytecodes(1);
            final int[] mag2 = bigInteger.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mag2);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divideKnuth = mutableBigInteger4.divideKnuth(mutableBigInteger5, mutableBigInteger6);
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger2 = divideKnuth.toBigInteger(signum);
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger divideBurnikelZiegler(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger2 = this.divideAndRemainderBurnikelZiegler(bigInteger)[0];
            BytecodeManager.incBytecodes(3);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger remainderBurnikelZiegler(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger2 = this.divideAndRemainderBurnikelZiegler(bigInteger)[1];
            BytecodeManager.incBytecodes(3);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger[] divideAndRemainderBurnikelZiegler(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(this);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(bigInteger);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
            BytecodeManager.incBytecodes(2);
            final MutableBigInteger divideAndRemainderBurnikelZiegler = mutableBigInteger2.divideAndRemainderBurnikelZiegler(mutableBigInteger3, mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger;
            BytecodeManager.incBytecodes(2);
            final boolean zero = mutableBigInteger5.isZero();
            BytecodeManager.incBytecodes(1);
            BigInteger bigInteger2;
            if (zero) {
                bigInteger2 = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
                final int n = this.signum * bigInteger.signum;
                BytecodeManager.incBytecodes(7);
                bigInteger2 = mutableBigInteger6.toBigInteger(n);
            }
            final BigInteger bigInteger3 = bigInteger2;
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger7 = divideAndRemainderBurnikelZiegler;
            BytecodeManager.incBytecodes(2);
            final boolean zero2 = mutableBigInteger7.isZero();
            BytecodeManager.incBytecodes(1);
            BigInteger bigInteger4;
            if (zero2) {
                bigInteger4 = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final MutableBigInteger mutableBigInteger8 = divideAndRemainderBurnikelZiegler;
                final int signum = this.signum;
                BytecodeManager.incBytecodes(4);
                bigInteger4 = mutableBigInteger8.toBigInteger(signum);
            }
            final BigInteger bigInteger5 = bigInteger4;
            BytecodeManager.incBytecodes(1);
            final BigInteger[] array = { bigInteger3, bigInteger5 };
            BytecodeManager.incBytecodes(10);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger pow(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "Negative exponent";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                BytecodeManager.incBytecodes(2);
                BigInteger one;
                if (n == 0) {
                    one = BigInteger.ONE;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    one = this;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return one;
            }
            BytecodeManager.incBytecodes(2);
            BigInteger bigInteger = this.abs();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger2 = bigInteger;
            BytecodeManager.incBytecodes(2);
            final int lowestSetBit = bigInteger2.getLowestSetBit();
            BytecodeManager.incBytecodes(1);
            final long n2 = lowestSetBit * (long)n;
            BytecodeManager.incBytecodes(6);
            final long n3 = lcmp(n2, 2147483647L);
            BytecodeManager.incBytecodes(4);
            if (n3 > 0) {
                BytecodeManager.incBytecodes(1);
                reportOverflow();
            }
            final int n4 = lowestSetBit;
            BytecodeManager.incBytecodes(2);
            int n6;
            if (n4 > 0) {
                final BigInteger bigInteger3 = bigInteger;
                final int n5 = lowestSetBit;
                BytecodeManager.incBytecodes(3);
                bigInteger = bigInteger3.shiftRight(n5);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger4 = bigInteger;
                BytecodeManager.incBytecodes(2);
                n6 = bigInteger4.bitLength();
                BytecodeManager.incBytecodes(1);
                final int n7 = n6;
                final int n8 = 1;
                BytecodeManager.incBytecodes(3);
                if (n7 == n8) {
                    final int signum2 = this.signum;
                    BytecodeManager.incBytecodes(3);
                    if (signum2 < 0) {
                        final int n9 = n & 0x1;
                        final int n10 = 1;
                        BytecodeManager.incBytecodes(5);
                        if (n9 == n10) {
                            final BigInteger negative_ONE = BigInteger.NEGATIVE_ONE;
                            final int n11 = lowestSetBit * n;
                            BytecodeManager.incBytecodes(5);
                            final BigInteger shiftLeft = negative_ONE.shiftLeft(n11);
                            BytecodeManager.incBytecodes(1);
                            return shiftLeft;
                        }
                    }
                    final BigInteger one2 = BigInteger.ONE;
                    final int n12 = lowestSetBit * n;
                    BytecodeManager.incBytecodes(5);
                    final BigInteger shiftLeft2 = one2.shiftLeft(n12);
                    BytecodeManager.incBytecodes(1);
                    return shiftLeft2;
                }
            }
            else {
                final BigInteger bigInteger5 = bigInteger;
                BytecodeManager.incBytecodes(2);
                n6 = bigInteger5.bitLength();
                BytecodeManager.incBytecodes(1);
                final int n13 = n6;
                final int n14 = 1;
                BytecodeManager.incBytecodes(3);
                if (n13 == n14) {
                    final int signum3 = this.signum;
                    BytecodeManager.incBytecodes(3);
                    if (signum3 < 0) {
                        final int n15 = n & 0x1;
                        final int n16 = 1;
                        BytecodeManager.incBytecodes(5);
                        if (n15 == n16) {
                            final BigInteger negative_ONE2 = BigInteger.NEGATIVE_ONE;
                            BytecodeManager.incBytecodes(2);
                            return negative_ONE2;
                        }
                    }
                    final BigInteger one3 = BigInteger.ONE;
                    BytecodeManager.incBytecodes(2);
                    return one3;
                }
            }
            final long n17 = n6 * (long)n;
            BytecodeManager.incBytecodes(6);
            final int length = bigInteger.mag.length;
            final int n18 = 1;
            BytecodeManager.incBytecodes(5);
            if (length == n18) {
                final long n19 = lcmp(n17, 62L);
                BytecodeManager.incBytecodes(4);
                if (n19 <= 0) {
                    final int signum4 = this.signum;
                    BytecodeManager.incBytecodes(3);
                    int n22 = 0;
                    Label_0403: {
                        if (signum4 < 0) {
                            final int n20 = n & 0x1;
                            final int n21 = 1;
                            BytecodeManager.incBytecodes(5);
                            if (n20 == n21) {
                                n22 = -1;
                                BytecodeManager.incBytecodes(2);
                                break Label_0403;
                            }
                        }
                        n22 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n23 = n22;
                    BytecodeManager.incBytecodes(1);
                    long n24 = 1L;
                    BytecodeManager.incBytecodes(2);
                    long n25 = (long)bigInteger.mag[0] & 0xFFFFFFFFL;
                    BytecodeManager.incBytecodes(8);
                    int n26 = n;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n27 = n26;
                        BytecodeManager.incBytecodes(2);
                        if (n27 == 0) {
                            break;
                        }
                        final int n28 = n26 & 0x1;
                        final int n29 = 1;
                        BytecodeManager.incBytecodes(5);
                        if (n28 == n29) {
                            n24 *= n25;
                            BytecodeManager.incBytecodes(4);
                        }
                        final int n30 = n26 >>>= 1;
                        BytecodeManager.incBytecodes(6);
                        if (n30 == 0) {
                            continue;
                        }
                        n25 *= n25;
                        BytecodeManager.incBytecodes(5);
                    }
                    final int n31 = lowestSetBit;
                    BytecodeManager.incBytecodes(2);
                    if (n31 <= 0) {
                        final long n32 = n24 * n23;
                        BytecodeManager.incBytecodes(5);
                        final BigInteger value = valueOf(n32);
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    final long n33 = lcmp(n2 + n17, 62L);
                    BytecodeManager.incBytecodes(6);
                    if (n33 <= 0) {
                        final long n34 = (n24 << (int)n2) * n23;
                        BytecodeManager.incBytecodes(8);
                        final BigInteger value2 = valueOf(n34);
                        BytecodeManager.incBytecodes(1);
                        return value2;
                    }
                    final long n35 = n24 * n23;
                    BytecodeManager.incBytecodes(5);
                    final BigInteger value3 = valueOf(n35);
                    final int n36 = (int)n2;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger shiftLeft3 = value3.shiftLeft(n36);
                    BytecodeManager.incBytecodes(1);
                    return shiftLeft3;
                }
            }
            BigInteger bigInteger6 = BigInteger.ONE;
            BytecodeManager.incBytecodes(2);
            int n37 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n38 = n37;
                BytecodeManager.incBytecodes(2);
                if (n38 == 0) {
                    break;
                }
                final int n39 = n37 & 0x1;
                final int n40 = 1;
                BytecodeManager.incBytecodes(5);
                if (n39 == n40) {
                    final BigInteger bigInteger7 = bigInteger6;
                    final BigInteger bigInteger8 = bigInteger;
                    BytecodeManager.incBytecodes(3);
                    bigInteger6 = bigInteger7.multiply(bigInteger8);
                    BytecodeManager.incBytecodes(1);
                }
                final int n41 = n37 >>>= 1;
                BytecodeManager.incBytecodes(6);
                if (n41 == 0) {
                    continue;
                }
                final BigInteger bigInteger9 = bigInteger;
                BytecodeManager.incBytecodes(2);
                bigInteger = bigInteger9.square();
                BytecodeManager.incBytecodes(2);
            }
            final int n42 = lowestSetBit;
            BytecodeManager.incBytecodes(2);
            if (n42 > 0) {
                final BigInteger bigInteger10 = bigInteger6;
                final int n43 = lowestSetBit * n;
                BytecodeManager.incBytecodes(5);
                bigInteger6 = bigInteger10.shiftLeft(n43);
                BytecodeManager.incBytecodes(1);
            }
            final int signum5 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum5 < 0) {
                final int n44 = n & 0x1;
                final int n45 = 1;
                BytecodeManager.incBytecodes(5);
                if (n44 == n45) {
                    final BigInteger bigInteger11 = bigInteger6;
                    BytecodeManager.incBytecodes(2);
                    final BigInteger negate = bigInteger11.negate();
                    BytecodeManager.incBytecodes(1);
                    return negate;
                }
            }
            final BigInteger bigInteger12 = bigInteger6;
            BytecodeManager.incBytecodes(2);
            return bigInteger12;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger gcd(final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger abs = this.abs();
                BytecodeManager.incBytecodes(1);
                return abs;
            }
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger abs2 = bigInteger.abs();
                BytecodeManager.incBytecodes(1);
                return abs2;
            }
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(this);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(bigInteger);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger;
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger hybridGCD = mutableBigInteger3.hybridGCD(mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger5 = hybridGCD;
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger2 = mutableBigInteger5.toBigInteger(n);
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int bitLengthForInt(final int i) {
        try {
            final int n = 32;
            BytecodeManager.incBytecodes(3);
            final int n2 = n - Integer.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] leftShift(final int[] array, final int n, final int n2) {
        try {
            final int n3 = n2 >>> 5;
            BytecodeManager.incBytecodes(4);
            final int n4 = n2 & 0x1F;
            BytecodeManager.incBytecodes(4);
            final int n5 = array[0];
            BytecodeManager.incBytecodes(4);
            final int bitLengthForInt = bitLengthForInt(n5);
            BytecodeManager.incBytecodes(1);
            final int n6 = 32 - bitLengthForInt;
            BytecodeManager.incBytecodes(5);
            if (n2 <= n6) {
                final int n7 = n4;
                BytecodeManager.incBytecodes(4);
                primitiveLeftShift(array, n, n7);
                BytecodeManager.incBytecodes(2);
                return array;
            }
            final int n8 = n4;
            final int n9 = 32 - bitLengthForInt;
            BytecodeManager.incBytecodes(5);
            if (n8 <= n9) {
                final int[] array2 = new int[n3 + n];
                BytecodeManager.incBytecodes(4);
                final int n10 = 0;
                final int[] array3 = array2;
                final int n11 = 0;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array, n10, array3, n11, n);
                final int[] array4 = array2;
                final int length = array2.length;
                final int n12 = n4;
                BytecodeManager.incBytecodes(5);
                primitiveLeftShift(array4, length, n12);
                final int[] array5 = array2;
                BytecodeManager.incBytecodes(2);
                return array5;
            }
            final int[] array6 = new int[n3 + n + 1];
            BytecodeManager.incBytecodes(6);
            final int n13 = 0;
            final int[] array7 = array6;
            final int n14 = 0;
            BytecodeManager.incBytecodes(6);
            System.arraycopy(array, n13, array7, n14, n);
            final int[] array8 = array6;
            final int length2 = array6.length;
            final int n15 = 32 - n4;
            BytecodeManager.incBytecodes(7);
            primitiveRightShift(array8, length2, n15);
            final int[] array9 = array6;
            BytecodeManager.incBytecodes(2);
            return array9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void primitiveRightShift(final int[] array, final int n, final int n2) {
        try {
            final int n3 = 32 - n2;
            BytecodeManager.incBytecodes(4);
            int n4 = n - 1;
            int n5 = array[n4];
            BytecodeManager.incBytecodes(8);
            while (true) {
                final int n6 = n4;
                BytecodeManager.incBytecodes(2);
                if (n6 <= 0) {
                    break;
                }
                final int n7 = n5;
                BytecodeManager.incBytecodes(2);
                n5 = array[n4 - 1];
                BytecodeManager.incBytecodes(6);
                array[n4] = (n5 << n3 | n7 >>> n2);
                BytecodeManager.incBytecodes(10);
                --n4;
                BytecodeManager.incBytecodes(2);
            }
            final int n8 = 0;
            array[n8] >>>= n2;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void primitiveLeftShift(final int[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n != 0) {
                BytecodeManager.incBytecodes(2);
                if (n2 != 0) {
                    final int n3 = 32 - n2;
                    BytecodeManager.incBytecodes(4);
                    int n4 = 0;
                    int n5 = array[n4];
                    final int n6 = n4 + n - 1;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n7 = n4;
                        final int n8 = n6;
                        BytecodeManager.incBytecodes(3);
                        if (n7 >= n8) {
                            break;
                        }
                        final int n9 = n5;
                        BytecodeManager.incBytecodes(2);
                        n5 = array[n4 + 1];
                        BytecodeManager.incBytecodes(6);
                        array[n4] = (n9 << n2 | n5 >>> n3);
                        BytecodeManager.incBytecodes(10);
                        ++n4;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n10 = n - 1;
                    array[n10] <<= n2;
                    BytecodeManager.incBytecodes(9);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int bitLength(final int[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final int n2 = 0;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final int n3 = n - 1 << 5;
            final int n4 = array[0];
            BytecodeManager.incBytecodes(9);
            final int n5 = n3 + bitLengthForInt(n4);
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger abs() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            BigInteger negate;
            if (signum >= 0) {
                negate = this;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                negate = this.negate();
            }
            BytecodeManager.incBytecodes(1);
            return negate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger negate() {
        try {
            final int[] mag = this.mag;
            final int n = -this.signum;
            BytecodeManager.incBytecodes(8);
            final BigInteger bigInteger = new BigInteger(mag, n);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int signum() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            return signum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger mod(final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            BytecodeManager.incBytecodes(3);
            if (signum <= 0) {
                final String s = "BigInteger: modulus not positive";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final BigInteger remainder = this.remainder(bigInteger);
            BytecodeManager.incBytecodes(1);
            final int signum2 = remainder.signum;
            BytecodeManager.incBytecodes(3);
            BigInteger add;
            if (signum2 >= 0) {
                add = remainder;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final BigInteger bigInteger2 = remainder;
                BytecodeManager.incBytecodes(3);
                add = bigInteger2.add(bigInteger);
            }
            BytecodeManager.incBytecodes(1);
            return add;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger modPow(BigInteger negate, final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            BytecodeManager.incBytecodes(3);
            if (signum <= 0) {
                final String s = "BigInteger: modulus not positive";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int signum2 = negate.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 == 0) {
                final BigInteger one = BigInteger.ONE;
                BytecodeManager.incBytecodes(3);
                final boolean equals = bigInteger.equals(one);
                BytecodeManager.incBytecodes(1);
                BigInteger bigInteger2;
                if (equals) {
                    bigInteger2 = BigInteger.ZERO;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    bigInteger2 = BigInteger.ONE;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return bigInteger2;
            }
            final BigInteger one2 = BigInteger.ONE;
            BytecodeManager.incBytecodes(3);
            final boolean equals2 = this.equals(one2);
            BytecodeManager.incBytecodes(1);
            if (equals2) {
                final BigInteger one3 = BigInteger.ONE;
                BytecodeManager.incBytecodes(3);
                final boolean equals3 = bigInteger.equals(one3);
                BytecodeManager.incBytecodes(1);
                BigInteger bigInteger3;
                if (equals3) {
                    bigInteger3 = BigInteger.ZERO;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    bigInteger3 = BigInteger.ONE;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return bigInteger3;
            }
            final BigInteger zero = BigInteger.ZERO;
            BytecodeManager.incBytecodes(3);
            final boolean equals4 = this.equals(zero);
            BytecodeManager.incBytecodes(1);
            if (equals4) {
                final int signum3 = negate.signum;
                BytecodeManager.incBytecodes(3);
                if (signum3 >= 0) {
                    final BigInteger zero2 = BigInteger.ZERO;
                    BytecodeManager.incBytecodes(2);
                    return zero2;
                }
            }
            final BigInteger bigInteger4 = BigInteger.negConst[1];
            BytecodeManager.incBytecodes(5);
            final boolean equals5 = this.equals(bigInteger4);
            BytecodeManager.incBytecodes(1);
            if (equals5) {
                final BigInteger bigInteger5 = negate;
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                final boolean testBit = bigInteger5.testBit(n);
                BytecodeManager.incBytecodes(1);
                if (!testBit) {
                    final BigInteger one4 = BigInteger.ONE;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals6 = bigInteger.equals(one4);
                    BytecodeManager.incBytecodes(1);
                    BigInteger bigInteger6;
                    if (equals6) {
                        bigInteger6 = BigInteger.ZERO;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        bigInteger6 = BigInteger.ONE;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return bigInteger6;
                }
            }
            final int signum4 = negate.signum;
            BytecodeManager.incBytecodes(3);
            boolean b2;
            boolean b;
            if (signum4 < 0) {
                b = (b2 = true);
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = (b2 = false);
                BytecodeManager.incBytecodes(1);
            }
            final boolean b3 = b2;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final BigInteger bigInteger7 = negate;
                BytecodeManager.incBytecodes(2);
                negate = bigInteger7.negate();
                BytecodeManager.incBytecodes(1);
            }
            final int signum5 = this.signum;
            BytecodeManager.incBytecodes(3);
            BigInteger mod = null;
            Label_0392: {
                if (signum5 >= 0) {
                    BytecodeManager.incBytecodes(3);
                    final int compareTo = this.compareTo(bigInteger);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo < 0) {
                        mod = this;
                        BytecodeManager.incBytecodes(1);
                        break Label_0392;
                    }
                }
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                mod = this.mod(bigInteger);
                BytecodeManager.incBytecodes(1);
            }
            final BigInteger bigInteger8 = mod;
            BytecodeManager.incBytecodes(1);
            final int n2 = 0;
            BytecodeManager.incBytecodes(3);
            final boolean testBit2 = bigInteger.testBit(n2);
            BytecodeManager.incBytecodes(1);
            BigInteger bigInteger11;
            if (testBit2) {
                final BigInteger bigInteger9 = bigInteger8;
                final BigInteger bigInteger10 = negate;
                BytecodeManager.incBytecodes(4);
                bigInteger11 = bigInteger9.oddModPow(bigInteger10, bigInteger);
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final int lowestSetBit = bigInteger.getLowestSetBit();
                BytecodeManager.incBytecodes(1);
                final int n3 = lowestSetBit;
                BytecodeManager.incBytecodes(3);
                final BigInteger shiftRight = bigInteger.shiftRight(n3);
                BytecodeManager.incBytecodes(1);
                final BigInteger one5 = BigInteger.ONE;
                final int n4 = lowestSetBit;
                BytecodeManager.incBytecodes(3);
                final BigInteger shiftLeft = one5.shiftLeft(n4);
                BytecodeManager.incBytecodes(1);
                final int signum6 = this.signum;
                BytecodeManager.incBytecodes(3);
                BigInteger mod2 = null;
                Label_0554: {
                    if (signum6 >= 0) {
                        final BigInteger bigInteger12 = shiftRight;
                        BytecodeManager.incBytecodes(3);
                        final int compareTo2 = this.compareTo(bigInteger12);
                        BytecodeManager.incBytecodes(1);
                        if (compareTo2 < 0) {
                            mod2 = this;
                            BytecodeManager.incBytecodes(1);
                            break Label_0554;
                        }
                    }
                    final BigInteger bigInteger13 = shiftRight;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    mod2 = this.mod(bigInteger13);
                    BytecodeManager.incBytecodes(1);
                }
                final BigInteger bigInteger14 = mod2;
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger15 = shiftRight;
                final BigInteger one6 = BigInteger.ONE;
                BytecodeManager.incBytecodes(3);
                final boolean equals7 = bigInteger15.equals(one6);
                BytecodeManager.incBytecodes(1);
                BigInteger bigInteger16;
                if (equals7) {
                    bigInteger16 = BigInteger.ZERO;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final BigInteger bigInteger17 = bigInteger14;
                    final BigInteger bigInteger18 = negate;
                    final BigInteger bigInteger19 = shiftRight;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    bigInteger16 = bigInteger17.oddModPow(bigInteger18, bigInteger19);
                }
                final BigInteger bigInteger20 = bigInteger16;
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger21 = bigInteger8;
                final BigInteger bigInteger22 = negate;
                final int n5 = lowestSetBit;
                BytecodeManager.incBytecodes(4);
                final BigInteger modPow2 = bigInteger21.modPow2(bigInteger22, n5);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger23 = shiftLeft;
                final BigInteger bigInteger24 = shiftRight;
                BytecodeManager.incBytecodes(3);
                final BigInteger modInverse = bigInteger23.modInverse(bigInteger24);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger25 = shiftRight;
                final BigInteger bigInteger26 = shiftLeft;
                BytecodeManager.incBytecodes(3);
                final BigInteger modInverse2 = bigInteger25.modInverse(bigInteger26);
                BytecodeManager.incBytecodes(1);
                final int length = bigInteger.mag.length;
                final int n6 = 33554432;
                BytecodeManager.incBytecodes(5);
                if (length < n6) {
                    final BigInteger bigInteger27 = bigInteger20;
                    final BigInteger bigInteger28 = shiftLeft;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger multiply = bigInteger27.multiply(bigInteger28);
                    final BigInteger bigInteger29 = modInverse;
                    BytecodeManager.incBytecodes(2);
                    final BigInteger multiply2 = multiply.multiply(bigInteger29);
                    final BigInteger bigInteger30 = modPow2;
                    final BigInteger bigInteger31 = shiftRight;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger multiply3 = bigInteger30.multiply(bigInteger31);
                    final BigInteger bigInteger32 = modInverse2;
                    BytecodeManager.incBytecodes(2);
                    final BigInteger multiply4 = multiply3.multiply(bigInteger32);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger add = multiply2.add(multiply4);
                    BytecodeManager.incBytecodes(2);
                    bigInteger11 = add.mod(bigInteger);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    final MutableBigInteger mutableBigInteger = new MutableBigInteger();
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger33 = bigInteger20;
                    final BigInteger bigInteger34 = shiftLeft;
                    BytecodeManager.incBytecodes(5);
                    final BigInteger multiply5 = bigInteger33.multiply(bigInteger34);
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(multiply5);
                    final BigInteger bigInteger35 = modInverse;
                    BytecodeManager.incBytecodes(4);
                    final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(bigInteger35);
                    final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
                    BytecodeManager.incBytecodes(2);
                    mutableBigInteger2.multiply(mutableBigInteger3, mutableBigInteger4);
                    BytecodeManager.incBytecodes(3);
                    final MutableBigInteger mutableBigInteger5 = new MutableBigInteger();
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger36 = modPow2;
                    final BigInteger bigInteger37 = shiftRight;
                    BytecodeManager.incBytecodes(5);
                    final BigInteger multiply6 = bigInteger36.multiply(bigInteger37);
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger6 = new MutableBigInteger(multiply6);
                    final BigInteger bigInteger38 = modInverse2;
                    BytecodeManager.incBytecodes(4);
                    final MutableBigInteger mutableBigInteger7 = new MutableBigInteger(bigInteger38);
                    final MutableBigInteger mutableBigInteger8 = mutableBigInteger5;
                    BytecodeManager.incBytecodes(2);
                    mutableBigInteger6.multiply(mutableBigInteger7, mutableBigInteger8);
                    final MutableBigInteger mutableBigInteger9 = mutableBigInteger;
                    final MutableBigInteger mutableBigInteger10 = mutableBigInteger5;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger9.add(mutableBigInteger10);
                    BytecodeManager.incBytecodes(3);
                    final MutableBigInteger mutableBigInteger11 = new MutableBigInteger();
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger12 = mutableBigInteger;
                    BytecodeManager.incBytecodes(5);
                    final MutableBigInteger mutableBigInteger13 = new MutableBigInteger(bigInteger);
                    final MutableBigInteger mutableBigInteger14 = mutableBigInteger11;
                    BytecodeManager.incBytecodes(2);
                    final MutableBigInteger divide = mutableBigInteger12.divide(mutableBigInteger13, mutableBigInteger14);
                    BytecodeManager.incBytecodes(1);
                    bigInteger11 = divide.toBigInteger();
                    BytecodeManager.incBytecodes(1);
                }
            }
            final boolean b4 = b3;
            BytecodeManager.incBytecodes(2);
            BigInteger modInverse3;
            if (b4) {
                final BigInteger bigInteger39 = bigInteger11;
                BytecodeManager.incBytecodes(3);
                modInverse3 = bigInteger39.modInverse(bigInteger);
                BytecodeManager.incBytecodes(1);
            }
            else {
                modInverse3 = bigInteger11;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return modInverse3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger oddModPow(final BigInteger bigInteger, final BigInteger bigInteger2) {
        try {
            final BigInteger one = BigInteger.ONE;
            BytecodeManager.incBytecodes(3);
            final boolean equals = bigInteger.equals(one);
            BytecodeManager.incBytecodes(1);
            if (equals) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int[] mag = this.mag;
            BytecodeManager.incBytecodes(3);
            final int[] array = mag.clone();
            BytecodeManager.incBytecodes(2);
            final int[] mag2 = bigInteger.mag;
            BytecodeManager.incBytecodes(3);
            final int[] mag3 = bigInteger2.mag;
            BytecodeManager.incBytecodes(3);
            final int length = mag3.length;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final int[] array2 = mag2;
            final int length2 = mag2.length;
            BytecodeManager.incBytecodes(4);
            int bitLength = bitLength(array2, length2);
            BytecodeManager.incBytecodes(1);
            final int n2 = bitLength;
            final int n3 = 17;
            BytecodeManager.incBytecodes(3);
            Label_0183: {
                if (n2 == n3) {
                    final int n4 = mag2[0];
                    final int n5 = 65537;
                    BytecodeManager.incBytecodes(5);
                    if (n4 == n5) {
                        break Label_0183;
                    }
                }
                while (true) {
                    final int n6 = bitLength;
                    final int n7 = BigInteger.bnExpModThreshTable[n];
                    BytecodeManager.incBytecodes(5);
                    if (n6 <= n7) {
                        break;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n8 = 1 << n;
            BytecodeManager.incBytecodes(4);
            final int[][] array3 = new int[n8][];
            BytecodeManager.incBytecodes(2);
            int n9 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n8;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    break;
                }
                array3[n9] = new int[length];
                BytecodeManager.incBytecodes(4);
                ++n9;
                BytecodeManager.incBytecodes(2);
            }
            final int n12 = mag3[length - 1];
            BytecodeManager.incBytecodes(6);
            final int n13 = -MutableBigInteger.inverseMod32(n12);
            BytecodeManager.incBytecodes(2);
            final int[] array4 = array;
            final int length3 = array.length;
            final int n14 = length << 5;
            BytecodeManager.incBytecodes(7);
            int[] leftShift = leftShift(array4, length3, n14);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final int[] array5 = leftShift;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(array5);
            BytecodeManager.incBytecodes(1);
            final int[] array6 = mag3;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(array6);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divide = mutableBigInteger4.divide(mutableBigInteger5, mutableBigInteger6);
            BytecodeManager.incBytecodes(1);
            final int[][] array7 = array3;
            final int n15 = 0;
            final MutableBigInteger mutableBigInteger7 = divide;
            BytecodeManager.incBytecodes(4);
            array7[n15] = mutableBigInteger7.toIntArray();
            BytecodeManager.incBytecodes(1);
            final int length4 = array3[0].length;
            final int n16 = length;
            BytecodeManager.incBytecodes(6);
            if (length4 < n16) {
                final int n17 = length - array3[0].length;
                BytecodeManager.incBytecodes(7);
                final int[] array8 = new int[length];
                BytecodeManager.incBytecodes(2);
                int n18 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n19 = n18;
                    final int length5 = array3[0].length;
                    BytecodeManager.incBytecodes(6);
                    if (n19 >= length5) {
                        break;
                    }
                    array8[n18 + n17] = array3[0][n18];
                    BytecodeManager.incBytecodes(10);
                    ++n18;
                    BytecodeManager.incBytecodes(2);
                }
                array3[0] = array8;
                BytecodeManager.incBytecodes(4);
            }
            final int[] array9 = array3[0];
            final int n20 = length;
            final int[] array10 = null;
            BytecodeManager.incBytecodes(6);
            final int[] squareToLen = squareToLen(array9, n20, array10);
            BytecodeManager.incBytecodes(1);
            final int[] array11 = squareToLen;
            final int[] array12 = mag3;
            final int n21 = length;
            final int n22 = n13;
            BytecodeManager.incBytecodes(5);
            int[] montReduce = montReduce(array11, array12, n21, n22);
            BytecodeManager.incBytecodes(1);
            final int[] array13 = montReduce;
            final int n23 = length;
            BytecodeManager.incBytecodes(3);
            final int[] copy = Arrays.copyOf(array13, n23);
            BytecodeManager.incBytecodes(1);
            int n24 = 1;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n25 = n24;
                final int n26 = n8;
                BytecodeManager.incBytecodes(3);
                if (n25 >= n26) {
                    break;
                }
                final int[] array14 = copy;
                final int n27 = length;
                final int[] array15 = array3[n24 - 1];
                final int n28 = length;
                final int[] array16 = null;
                BytecodeManager.incBytecodes(11);
                final int[] multiplyToLen = this.multiplyToLen(array14, n27, array15, n28, array16);
                BytecodeManager.incBytecodes(1);
                final int[][] array17 = array3;
                final int n29 = n24;
                final int[] array18 = multiplyToLen;
                final int[] array19 = mag3;
                final int n30 = length;
                final int n31 = n13;
                BytecodeManager.incBytecodes(7);
                array17[n29] = montReduce(array18, array19, n30, n31);
                BytecodeManager.incBytecodes(1);
                ++n24;
                BytecodeManager.incBytecodes(2);
            }
            int n32 = 1 << (bitLength - 1 & 0x1F);
            BytecodeManager.incBytecodes(8);
            int n33 = 0;
            BytecodeManager.incBytecodes(2);
            int length6 = mag2.length;
            BytecodeManager.incBytecodes(3);
            int n34 = 0;
            BytecodeManager.incBytecodes(2);
            int n35 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n36 = n35;
                final int n37 = n;
                BytecodeManager.incBytecodes(3);
                if (n36 > n37) {
                    break;
                }
                final int n38 = n33 << 1;
                final int n39 = mag2[n34] & n32;
                BytecodeManager.incBytecodes(9);
                boolean b;
                if (n39 != 0) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
                n33 = (n38 | (b ? 1 : 0));
                BytecodeManager.incBytecodes(2);
                n32 >>>= 1;
                BytecodeManager.incBytecodes(4);
                final int n40 = n32;
                BytecodeManager.incBytecodes(2);
                if (n40 == 0) {
                    ++n34;
                    BytecodeManager.incBytecodes(1);
                    n32 = Integer.MIN_VALUE;
                    BytecodeManager.incBytecodes(2);
                    --length6;
                    BytecodeManager.incBytecodes(1);
                }
                ++n35;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            --bitLength;
            BytecodeManager.incBytecodes(1);
            int n41 = 1;
            BytecodeManager.incBytecodes(2);
            int n42 = bitLength - n;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n43 = n33 & 0x1;
                BytecodeManager.incBytecodes(4);
                if (n43 != 0) {
                    break;
                }
                n33 >>>= 1;
                BytecodeManager.incBytecodes(4);
                ++n42;
                BytecodeManager.incBytecodes(2);
            }
            int[] array20 = array3[n33 >>> 1];
            BytecodeManager.incBytecodes(6);
            int n44 = 0;
            BytecodeManager.incBytecodes(2);
            final int n45 = n42;
            final int n46 = bitLength;
            BytecodeManager.incBytecodes(3);
            if (n45 == n46) {
                n41 = 0;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                --bitLength;
                BytecodeManager.incBytecodes(1);
                n44 <<= 1;
                BytecodeManager.incBytecodes(4);
                final int n47 = length6;
                BytecodeManager.incBytecodes(2);
                if (n47 != 0) {
                    final int n48 = n44;
                    final int n49 = mag2[n34] & n32;
                    BytecodeManager.incBytecodes(7);
                    boolean b2;
                    if (n49 != 0) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b2 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    n44 = (n48 | (b2 ? 1 : 0));
                    BytecodeManager.incBytecodes(2);
                    n32 >>>= 1;
                    BytecodeManager.incBytecodes(4);
                    final int n50 = n32;
                    BytecodeManager.incBytecodes(2);
                    if (n50 == 0) {
                        ++n34;
                        BytecodeManager.incBytecodes(1);
                        n32 = Integer.MIN_VALUE;
                        BytecodeManager.incBytecodes(2);
                        --length6;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n51 = n44 & n8;
                BytecodeManager.incBytecodes(4);
                if (n51 != 0) {
                    n42 = bitLength - n;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n52 = n44 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n52 != 0) {
                            break;
                        }
                        n44 >>>= 1;
                        BytecodeManager.incBytecodes(4);
                        ++n42;
                        BytecodeManager.incBytecodes(2);
                    }
                    array20 = array3[n44 >>> 1];
                    BytecodeManager.incBytecodes(6);
                    n44 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                final int n53 = bitLength;
                final int n54 = n42;
                BytecodeManager.incBytecodes(3);
                if (n53 == n54) {
                    final int n55 = n41;
                    BytecodeManager.incBytecodes(2);
                    if (n55 != 0) {
                        final int[] array21 = array20;
                        BytecodeManager.incBytecodes(2);
                        montReduce = array21.clone();
                        BytecodeManager.incBytecodes(2);
                        n41 = 0;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final int[] array22 = montReduce;
                        BytecodeManager.incBytecodes(2);
                        final int[] array23 = array22;
                        final int n56 = length;
                        final int[] array24 = array20;
                        final int n57 = length;
                        final int[] array25 = leftShift;
                        BytecodeManager.incBytecodes(7);
                        final int[] multiplyToLen2 = this.multiplyToLen(array23, n56, array24, n57, array25);
                        BytecodeManager.incBytecodes(1);
                        final int[] array26 = multiplyToLen2;
                        final int[] array27 = mag3;
                        final int n58 = length;
                        final int n59 = n13;
                        BytecodeManager.incBytecodes(5);
                        final int[] montReduce2 = montReduce(array26, array27, n58, n59);
                        BytecodeManager.incBytecodes(1);
                        final int[] array28 = montReduce2;
                        leftShift = montReduce;
                        montReduce = array28;
                        BytecodeManager.incBytecodes(6);
                    }
                }
                final int n60 = bitLength;
                BytecodeManager.incBytecodes(2);
                if (n60 == 0) {
                    break;
                }
                final int n61 = n41;
                BytecodeManager.incBytecodes(2);
                if (n61 != 0) {
                    continue;
                }
                final int[] array29 = montReduce;
                BytecodeManager.incBytecodes(2);
                final int[] array30 = array29;
                final int n62 = length;
                final int[] array31 = leftShift;
                BytecodeManager.incBytecodes(4);
                final int[] squareToLen2 = squareToLen(array30, n62, array31);
                BytecodeManager.incBytecodes(1);
                final int[] array32 = squareToLen2;
                final int[] array33 = mag3;
                final int n63 = length;
                final int n64 = n13;
                BytecodeManager.incBytecodes(5);
                final int[] montReduce3 = montReduce(array32, array33, n63, n64);
                BytecodeManager.incBytecodes(1);
                final int[] array34 = montReduce3;
                leftShift = montReduce;
                montReduce = array34;
                BytecodeManager.incBytecodes(7);
            }
            BytecodeManager.incBytecodes(1);
            final int[] array35 = new int[2 * length];
            BytecodeManager.incBytecodes(4);
            final int[] array36 = montReduce;
            final int n65 = 0;
            final int[] array37 = array35;
            final int n66 = length;
            final int n67 = length;
            BytecodeManager.incBytecodes(6);
            System.arraycopy(array36, n65, array37, n66, n67);
            final int[] array38 = array35;
            final int[] array39 = mag3;
            final int n68 = length;
            final int n69 = n13;
            BytecodeManager.incBytecodes(5);
            final int[] montReduce4 = montReduce(array38, array39, n68, n69);
            BytecodeManager.incBytecodes(1);
            final int[] array40 = montReduce4;
            final int n70 = length;
            BytecodeManager.incBytecodes(3);
            final int[] copy2 = Arrays.copyOf(array40, n70);
            BytecodeManager.incBytecodes(1);
            final int n71 = 1;
            final int[] array41 = copy2;
            BytecodeManager.incBytecodes(5);
            final BigInteger bigInteger3 = new BigInteger(n71, array41);
            BytecodeManager.incBytecodes(1);
            return bigInteger3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] montReduce(final int[] array, final int[] array2, final int n, final int n2) {
        try {
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            int n5 = 0;
            BytecodeManager.incBytecodes(2);
            int i;
            do {
                final int n6 = array[array.length - 1 - n5];
                BytecodeManager.incBytecodes(9);
                final int n7 = n5;
                final int n8 = n2 * n6;
                BytecodeManager.incBytecodes(8);
                final int mulAdd = mulAdd(array, array2, n7, n, n8);
                BytecodeManager.incBytecodes(1);
                final int n9 = n3;
                final int n10 = n5;
                final int n11 = mulAdd;
                BytecodeManager.incBytecodes(6);
                n3 = n9 + addOne(array, n10, n, n11);
                BytecodeManager.incBytecodes(2);
                ++n5;
                BytecodeManager.incBytecodes(1);
                i = --n4;
                BytecodeManager.incBytecodes(3);
            } while (i > 0);
            while (true) {
                final int n12 = n3;
                BytecodeManager.incBytecodes(2);
                if (n12 <= 0) {
                    break;
                }
                final int n13 = n3;
                BytecodeManager.incBytecodes(5);
                n3 = n13 + subN(array, array2, n);
                BytecodeManager.incBytecodes(3);
            }
            while (true) {
                BytecodeManager.incBytecodes(4);
                final int intArrayCmpToLen = intArrayCmpToLen(array, array2, n);
                BytecodeManager.incBytecodes(1);
                if (intArrayCmpToLen < 0) {
                    break;
                }
                BytecodeManager.incBytecodes(4);
                subN(array, array2, n);
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int intArrayCmpToLen(final int[] array, final int[] array2, final int n) {
        try {
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n) {
                    final int n4 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n4;
                }
                final long n5 = (long)array[n2] & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(7);
                final long n6 = (long)array2[n2] & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(7);
                final long n7 = lcmp(n5, n6);
                BytecodeManager.incBytecodes(4);
                if (n7 < 0) {
                    final int n8 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n8;
                }
                final long n9 = lcmp(n5, n6);
                BytecodeManager.incBytecodes(4);
                if (n9 > 0) {
                    final int n10 = 1;
                    BytecodeManager.incBytecodes(2);
                    return n10;
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int subN(final int[] array, final int[] array2, int n) {
        try {
            long n2 = 0L;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = --n;
                BytecodeManager.incBytecodes(3);
                if (n3 < 0) {
                    break;
                }
                n2 = ((long)array[n] & 0xFFFFFFFFL) - ((long)array2[n] & 0xFFFFFFFFL) + (n2 >> 32);
                BytecodeManager.incBytecodes(18);
                array[n] = (int)n2;
                BytecodeManager.incBytecodes(6);
            }
            final int n4 = (int)(n2 >> 32);
            BytecodeManager.incBytecodes(5);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int mulAdd(final int[] array, final int[] array2, int n, final int n2, final int n3) {
        try {
            final long n4 = (long)n3 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            long n5 = 0L;
            BytecodeManager.incBytecodes(2);
            n = array.length - n - 1;
            BytecodeManager.incBytecodes(7);
            int n6 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                if (n7 < 0) {
                    break;
                }
                final long n8 = ((long)array2[n6] & 0xFFFFFFFFL) * n4 + ((long)array[n] & 0xFFFFFFFFL) + n5;
                BytecodeManager.incBytecodes(18);
                array[n--] = (int)n8;
                BytecodeManager.incBytecodes(6);
                n5 = n8 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n6;
                BytecodeManager.incBytecodes(2);
            }
            final int n9 = (int)n5;
            BytecodeManager.incBytecodes(3);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int addOne(final int[] array, int n, int n2, final int n3) {
        try {
            n = array.length - 1 - n2 - n;
            BytecodeManager.incBytecodes(9);
            final long n4 = ((long)array[n] & 0xFFFFFFFFL) + ((long)n3 & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(12);
            array[n] = (int)n4;
            BytecodeManager.incBytecodes(5);
            final long n5 = lcmp(n4 >>> 32, 0L);
            BytecodeManager.incBytecodes(6);
            if (n5 == 0) {
                final int n6 = 0;
                BytecodeManager.incBytecodes(2);
                return n6;
            }
            int i;
            do {
                final int n7 = --n2;
                BytecodeManager.incBytecodes(3);
                if (n7 < 0) {
                    final int n8 = 1;
                    BytecodeManager.incBytecodes(2);
                    return n8;
                }
                final int n9 = --n;
                BytecodeManager.incBytecodes(3);
                if (n9 < 0) {
                    final int n10 = 1;
                    BytecodeManager.incBytecodes(2);
                    return n10;
                }
                final int n11 = n;
                ++array[n11];
                BytecodeManager.incBytecodes(7);
                i = array[n];
                BytecodeManager.incBytecodes(4);
            } while (i == 0);
            final int n12 = 0;
            BytecodeManager.incBytecodes(2);
            return n12;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger modPow2(final BigInteger bigInteger, final int n) {
        try {
            BigInteger bigInteger2 = BigInteger.ONE;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            BigInteger bigInteger3 = this.mod2(n);
            BytecodeManager.incBytecodes(1);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int bitLength = bigInteger.bitLength();
            BytecodeManager.incBytecodes(1);
            final int n3 = 0;
            BytecodeManager.incBytecodes(3);
            final boolean testBit = this.testBit(n3);
            BytecodeManager.incBytecodes(1);
            if (testBit) {
                final int n4 = n - 1;
                final int n5 = bitLength;
                BytecodeManager.incBytecodes(5);
                int n6;
                if (n4 < n5) {
                    n6 = n - 1;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    n6 = bitLength;
                    BytecodeManager.incBytecodes(1);
                }
                bitLength = n6;
                BytecodeManager.incBytecodes(1);
            }
            while (true) {
                final int n7 = n2;
                final int n8 = bitLength;
                BytecodeManager.incBytecodes(3);
                if (n7 >= n8) {
                    break;
                }
                final int n9 = n2;
                BytecodeManager.incBytecodes(3);
                final boolean testBit2 = bigInteger.testBit(n9);
                BytecodeManager.incBytecodes(1);
                if (testBit2) {
                    final BigInteger bigInteger4 = bigInteger2;
                    final BigInteger bigInteger5 = bigInteger3;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger multiply = bigInteger4.multiply(bigInteger5);
                    BytecodeManager.incBytecodes(2);
                    bigInteger2 = multiply.mod2(n);
                    BytecodeManager.incBytecodes(1);
                }
                ++n2;
                BytecodeManager.incBytecodes(1);
                final int n10 = n2;
                final int n11 = bitLength;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    continue;
                }
                final BigInteger bigInteger6 = bigInteger3;
                BytecodeManager.incBytecodes(2);
                final BigInteger square = bigInteger6.square();
                BytecodeManager.incBytecodes(2);
                bigInteger3 = square.mod2(n);
                BytecodeManager.incBytecodes(2);
            }
            final BigInteger bigInteger7 = bigInteger2;
            BytecodeManager.incBytecodes(2);
            return bigInteger7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger mod2(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int bitLength = this.bitLength();
            BytecodeManager.incBytecodes(2);
            if (bitLength <= n) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int n2 = n + 31 >>> 5;
            BytecodeManager.incBytecodes(6);
            final int[] array = new int[n2];
            BytecodeManager.incBytecodes(2);
            final int[] mag = this.mag;
            final int n3 = this.mag.length - n2;
            final int[] array2 = array;
            final int n4 = 0;
            final int n5 = n2;
            BytecodeManager.incBytecodes(11);
            System.arraycopy(mag, n3, array2, n4, n5);
            final int n6 = (n2 << 5) - n;
            BytecodeManager.incBytecodes(6);
            final int[] array3 = array;
            final int n7 = 0;
            array3[n7] = (int)((long)array3[n7] & (1L << 32 - n6) - 1L);
            BytecodeManager.incBytecodes(15);
            final int n8 = array[0];
            BytecodeManager.incBytecodes(4);
            BigInteger bigInteger;
            if (n8 == 0) {
                final int n9;
                final int[] array4;
                bigInteger = new BigInteger(n9, array4);
                n9 = 1;
                array4 = array;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int[] array5;
                final int n10;
                bigInteger = new BigInteger(array5, n10);
                array5 = array;
                n10 = 1;
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger modInverse(final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            if (signum != n) {
                final String s = "BigInteger: modulus not positive";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BigInteger one = BigInteger.ONE;
            BytecodeManager.incBytecodes(3);
            final boolean equals = bigInteger.equals(one);
            BytecodeManager.incBytecodes(1);
            if (equals) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            BigInteger mod = this;
            BytecodeManager.incBytecodes(2);
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            Label_0116: {
                if (signum2 >= 0) {
                    BytecodeManager.incBytecodes(3);
                    final int compareMagnitude = this.compareMagnitude(bigInteger);
                    BytecodeManager.incBytecodes(1);
                    if (compareMagnitude < 0) {
                        break Label_0116;
                    }
                }
                BytecodeManager.incBytecodes(3);
                mod = this.mod(bigInteger);
                BytecodeManager.incBytecodes(1);
            }
            final BigInteger bigInteger2 = mod;
            final BigInteger one2 = BigInteger.ONE;
            BytecodeManager.incBytecodes(3);
            final boolean equals2 = bigInteger2.equals(one2);
            BytecodeManager.incBytecodes(1);
            if (equals2) {
                final BigInteger one3 = BigInteger.ONE;
                BytecodeManager.incBytecodes(2);
                return one3;
            }
            final BigInteger bigInteger3 = mod;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(bigInteger3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(bigInteger);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger;
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableModInverse = mutableBigInteger3.mutableModInverse(mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger5 = mutableModInverse;
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger4 = mutableBigInteger5.toBigInteger(n2);
            BytecodeManager.incBytecodes(1);
            return bigInteger4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger shiftLeft(final int n) {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                final int[] mag = this.mag;
                BytecodeManager.incBytecodes(6);
                final int[] shiftLeft = shiftLeft(mag, n);
                final int signum2 = this.signum;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigInteger = new BigInteger(shiftLeft, signum2);
                BytecodeManager.incBytecodes(1);
                return bigInteger;
            }
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int n2 = -n;
            BytecodeManager.incBytecodes(4);
            final BigInteger shiftRightImpl = this.shiftRightImpl(n2);
            BytecodeManager.incBytecodes(1);
            return shiftRightImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] shiftLeft(final int[] array, final int n) {
        try {
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(4);
            final int n3 = n & 0x1F;
            BytecodeManager.incBytecodes(4);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            int[] array2;
            if (n4 == 0) {
                array2 = new int[length + n2];
                BytecodeManager.incBytecodes(4);
                final int n5 = 0;
                final int[] array3 = array2;
                final int n6 = 0;
                final int n7 = length;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array, n5, array3, n6, n7);
                BytecodeManager.incBytecodes(1);
            }
            else {
                int n8 = 0;
                BytecodeManager.incBytecodes(2);
                final int n9 = 32 - n3;
                BytecodeManager.incBytecodes(4);
                final int n10 = array[0] >>> n9;
                BytecodeManager.incBytecodes(6);
                final int n11 = n10;
                BytecodeManager.incBytecodes(2);
                if (n11 != 0) {
                    array2 = new int[length + n2 + 1];
                    BytecodeManager.incBytecodes(6);
                    array2[n8++] = n10;
                    BytecodeManager.incBytecodes(6);
                }
                else {
                    array2 = new int[length + n2];
                    BytecodeManager.incBytecodes(4);
                }
                int n12 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n13 = n12;
                    final int n14 = length - 1;
                    BytecodeManager.incBytecodes(5);
                    if (n13 >= n14) {
                        break;
                    }
                    array2[n8++] = (array[n12++] << n3 | array[n12] >>> n9);
                    BytecodeManager.incBytecodes(17);
                }
                array2[n8] = array[n12] << n3;
                BytecodeManager.incBytecodes(8);
            }
            final int[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger shiftRight(final int n) {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                BytecodeManager.incBytecodes(3);
                final BigInteger shiftRightImpl = this.shiftRightImpl(n);
                BytecodeManager.incBytecodes(1);
                return shiftRightImpl;
            }
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int[] mag = this.mag;
            final int n2 = -n;
            BytecodeManager.incBytecodes(7);
            final int[] shiftLeft = shiftLeft(mag, n2);
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger = new BigInteger(shiftLeft, signum2);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger shiftRightImpl(final int n) {
        try {
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(4);
            final int n3 = n & 0x1F;
            BytecodeManager.incBytecodes(4);
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final int n4 = n2;
            final int n5 = length;
            BytecodeManager.incBytecodes(3);
            if (n4 >= n5) {
                final int signum = this.signum;
                BytecodeManager.incBytecodes(3);
                BigInteger zero;
                if (signum >= 0) {
                    zero = BigInteger.ZERO;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    zero = BigInteger.negConst[1];
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
                return zero;
            }
            final int n6 = n3;
            BytecodeManager.incBytecodes(2);
            int[] array;
            if (n6 == 0) {
                final int n7 = length - n2;
                BytecodeManager.incBytecodes(4);
                final int[] mag = this.mag;
                final int n8 = n7;
                BytecodeManager.incBytecodes(4);
                array = Arrays.copyOf(mag, n8);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                int n9 = 0;
                BytecodeManager.incBytecodes(2);
                final int n10 = this.mag[0] >>> n3;
                BytecodeManager.incBytecodes(7);
                final int n11 = n10;
                BytecodeManager.incBytecodes(2);
                if (n11 != 0) {
                    array = new int[length - n2];
                    BytecodeManager.incBytecodes(4);
                    array[n9++] = n10;
                    BytecodeManager.incBytecodes(6);
                }
                else {
                    array = new int[length - n2 - 1];
                    BytecodeManager.incBytecodes(6);
                }
                final int n12 = 32 - n3;
                BytecodeManager.incBytecodes(4);
                int n13 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n14 = n13;
                    final int n15 = length - n2 - 1;
                    BytecodeManager.incBytecodes(7);
                    if (n14 >= n15) {
                        break;
                    }
                    array[n9++] = (this.mag[n13++] << n12 | this.mag[n13] >>> n3);
                    BytecodeManager.incBytecodes(19);
                }
            }
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 < 0) {
                int n16 = 0;
                BytecodeManager.incBytecodes(2);
                int n17 = length - 1;
                final int n18 = length - n2;
                BytecodeManager.incBytecodes(8);
                while (true) {
                    final int n19 = n17;
                    final int n20 = n18;
                    BytecodeManager.incBytecodes(3);
                    if (n19 < n20) {
                        break;
                    }
                    final int n21 = n16;
                    BytecodeManager.incBytecodes(2);
                    if (n21 != 0) {
                        break;
                    }
                    final int n22 = this.mag[n17];
                    BytecodeManager.incBytecodes(5);
                    int n23;
                    if (n22 != 0) {
                        n23 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n23 = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    n16 = n23;
                    BytecodeManager.incBytecodes(1);
                    --n17;
                    BytecodeManager.incBytecodes(2);
                }
                final int n24 = n16;
                BytecodeManager.incBytecodes(2);
                if (n24 == 0) {
                    final int n25 = n3;
                    BytecodeManager.incBytecodes(2);
                    if (n25 != 0) {
                        final int n26 = this.mag[length - n2 - 1] << 32 - n3;
                        BytecodeManager.incBytecodes(13);
                        int n27;
                        if (n26 != 0) {
                            n27 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n27 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        n16 = n27;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n28 = n16;
                BytecodeManager.incBytecodes(2);
                if (n28 != 0) {
                    final int[] array2 = array;
                    BytecodeManager.incBytecodes(3);
                    array = this.javaIncrement(array2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int[] array3 = array;
            final int signum3 = this.signum;
            BytecodeManager.incBytecodes(6);
            final BigInteger bigInteger = new BigInteger(array3, signum3);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int[] javaIncrement(int[] array) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = array.length - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 < 0) {
                    break;
                }
                final boolean b = n != 0;
                BytecodeManager.incBytecodes(2);
                if (b) {
                    break;
                }
                n = ++array[n2];
                BytecodeManager.incBytecodes(9);
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            final boolean b2 = n != 0;
            BytecodeManager.incBytecodes(2);
            if (!b2) {
                array = new int[array.length + 1];
                BytecodeManager.incBytecodes(5);
                array[0] = 1;
                BytecodeManager.incBytecodes(4);
            }
            final int[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger and(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(2);
            final int intLength = this.intLength();
            BytecodeManager.incBytecodes(2);
            final int intLength2 = bigInteger.intLength();
            BytecodeManager.incBytecodes(1);
            final int[] array = new int[Math.max(intLength, intLength2)];
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
                final int[] array2 = array;
                final int n3 = n;
                final int n4 = array.length - n - 1;
                BytecodeManager.incBytecodes(10);
                final int int1 = this.getInt(n4);
                final int n5 = array.length - n - 1;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                array2[n3] = (int1 & bigInteger.getInt(n5));
                BytecodeManager.incBytecodes(2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array3);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger or(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(2);
            final int intLength = this.intLength();
            BytecodeManager.incBytecodes(2);
            final int intLength2 = bigInteger.intLength();
            BytecodeManager.incBytecodes(1);
            final int[] array = new int[Math.max(intLength, intLength2)];
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
                final int[] array2 = array;
                final int n3 = n;
                final int n4 = array.length - n - 1;
                BytecodeManager.incBytecodes(10);
                final int int1 = this.getInt(n4);
                final int n5 = array.length - n - 1;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                array2[n3] = (int1 | bigInteger.getInt(n5));
                BytecodeManager.incBytecodes(2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array3);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger xor(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(2);
            final int intLength = this.intLength();
            BytecodeManager.incBytecodes(2);
            final int intLength2 = bigInteger.intLength();
            BytecodeManager.incBytecodes(1);
            final int[] array = new int[Math.max(intLength, intLength2)];
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
                final int[] array2 = array;
                final int n3 = n;
                final int n4 = array.length - n - 1;
                BytecodeManager.incBytecodes(10);
                final int int1 = this.getInt(n4);
                final int n5 = array.length - n - 1;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                array2[n3] = (int1 ^ bigInteger.getInt(n5));
                BytecodeManager.incBytecodes(2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array3);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger not() {
        try {
            BytecodeManager.incBytecodes(2);
            final int[] array = new int[this.intLength()];
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
                final int[] array2 = array;
                final int n3 = n;
                final int n4 = array.length - n - 1;
                BytecodeManager.incBytecodes(10);
                array2[n3] = ~this.getInt(n4);
                BytecodeManager.incBytecodes(3);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array3);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger andNot(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(2);
            final int intLength = this.intLength();
            BytecodeManager.incBytecodes(2);
            final int intLength2 = bigInteger.intLength();
            BytecodeManager.incBytecodes(1);
            final int[] array = new int[Math.max(intLength, intLength2)];
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
                final int[] array2 = array;
                final int n3 = n;
                final int n4 = array.length - n - 1;
                BytecodeManager.incBytecodes(10);
                final int int1 = this.getInt(n4);
                final int n5 = array.length - n - 1;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                array2[n3] = (int1 & ~bigInteger.getInt(n5));
                BytecodeManager.incBytecodes(4);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array3);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean testBit(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "Negative bit address";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(5);
            final int n3 = this.getInt(n2) & 1 << (n & 0x1F);
            BytecodeManager.incBytecodes(7);
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
    
    public BigInteger setBit(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "Negative bit address";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final int intLength = this.intLength();
            final int b = n2 + 2;
            BytecodeManager.incBytecodes(4);
            final int[] array = new int[Math.max(intLength, b)];
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n4 >= length) {
                    break;
                }
                final int[] array2 = array;
                final int n5 = array.length - n3 - 1;
                final int n6 = n3;
                BytecodeManager.incBytecodes(10);
                array2[n5] = this.getInt(n6);
                BytecodeManager.incBytecodes(1);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            final int n7 = array.length - n2 - 1;
            array3[n7] |= 1 << (n & 0x1F);
            BytecodeManager.incBytecodes(16);
            final int[] array4 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array4);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger clearBit(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "Negative bit address";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final int intLength = this.intLength();
            final int b = (n + 1 >>> 5) + 1;
            BytecodeManager.incBytecodes(8);
            final int[] array = new int[Math.max(intLength, b)];
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n4 >= length) {
                    break;
                }
                final int[] array2 = array;
                final int n5 = array.length - n3 - 1;
                final int n6 = n3;
                BytecodeManager.incBytecodes(10);
                array2[n5] = this.getInt(n6);
                BytecodeManager.incBytecodes(1);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            final int n7 = array.length - n2 - 1;
            array3[n7] &= ~(1 << (n & 0x1F));
            BytecodeManager.incBytecodes(18);
            final int[] array4 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array4);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger flipBit(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "Negative bit address";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final int intLength = this.intLength();
            final int b = n2 + 2;
            BytecodeManager.incBytecodes(4);
            final int[] array = new int[Math.max(intLength, b)];
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n4 >= length) {
                    break;
                }
                final int[] array2 = array;
                final int n5 = array.length - n3 - 1;
                final int n6 = n3;
                BytecodeManager.incBytecodes(10);
                array2[n5] = this.getInt(n6);
                BytecodeManager.incBytecodes(1);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array;
            final int n7 = array.length - n2 - 1;
            array3[n7] ^= 1 << (n & 0x1F);
            BytecodeManager.incBytecodes(16);
            final int[] array4 = array;
            BytecodeManager.incBytecodes(2);
            final BigInteger value = valueOf(array4);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getLowestSetBit() {
        try {
            int n = this.lowestSetBit - 2;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -2;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                n = 0;
                BytecodeManager.incBytecodes(2);
                final int signum = this.signum;
                BytecodeManager.incBytecodes(3);
                if (signum == 0) {
                    --n;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    int n4 = 0;
                    BytecodeManager.incBytecodes(2);
                    int int1;
                    while (true) {
                        final int n5 = n4;
                        BytecodeManager.incBytecodes(3);
                        int1 = this.getInt(n5);
                        BytecodeManager.incBytecodes(3);
                        if (int1 != 0) {
                            break;
                        }
                        ++n4;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n6 = n;
                    final int n7 = n4 << 5;
                    final int i = int1;
                    BytecodeManager.incBytecodes(6);
                    n = n6 + (n7 + Integer.numberOfTrailingZeros(i));
                    BytecodeManager.incBytecodes(3);
                }
                this.lowestSetBit = n + 2;
                BytecodeManager.incBytecodes(5);
            }
            final int n8 = n;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int bitLength() {
        try {
            int n = this.bitLength - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final int[] mag = this.mag;
                BytecodeManager.incBytecodes(3);
                final int length = mag.length;
                BytecodeManager.incBytecodes(3);
                final int n4 = length;
                BytecodeManager.incBytecodes(2);
                if (n4 == 0) {
                    n = 0;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final int n5 = length - 1 << 5;
                    final int n6 = this.mag[0];
                    BytecodeManager.incBytecodes(10);
                    final int n7 = n5 + bitLengthForInt(n6);
                    BytecodeManager.incBytecodes(2);
                    final int signum = this.signum;
                    BytecodeManager.incBytecodes(3);
                    if (signum < 0) {
                        final int i = this.mag[0];
                        BytecodeManager.incBytecodes(5);
                        final int bitCount = Integer.bitCount(i);
                        final int n8 = 1;
                        BytecodeManager.incBytecodes(2);
                        int n9;
                        if (bitCount == n8) {
                            n9 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        int n10 = n9;
                        BytecodeManager.incBytecodes(1);
                        int n11 = 1;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n12 = n11;
                            final int n13 = length;
                            BytecodeManager.incBytecodes(3);
                            if (n12 >= n13) {
                                break;
                            }
                            final int n14 = n10;
                            BytecodeManager.incBytecodes(2);
                            if (n14 == 0) {
                                break;
                            }
                            final int n15 = this.mag[n11];
                            BytecodeManager.incBytecodes(5);
                            int n16;
                            if (n15 == 0) {
                                n16 = 1;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                n16 = 0;
                                BytecodeManager.incBytecodes(1);
                            }
                            n10 = n16;
                            BytecodeManager.incBytecodes(1);
                            ++n11;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n17 = n10;
                        BytecodeManager.incBytecodes(2);
                        int n18;
                        if (n17 != 0) {
                            n18 = n7 - 1;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            n18 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        n = n18;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        n = n7;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                this.bitLength = n + 1;
                BytecodeManager.incBytecodes(5);
            }
            final int n19 = n;
            BytecodeManager.incBytecodes(2);
            return n19;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int bitCount() {
        try {
            int n = this.bitCount - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                n = 0;
                BytecodeManager.incBytecodes(2);
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    final int length = this.mag.length;
                    BytecodeManager.incBytecodes(5);
                    if (n5 >= length) {
                        break;
                    }
                    final int n6 = n;
                    final int i = this.mag[n4];
                    BytecodeManager.incBytecodes(6);
                    n = n6 + Integer.bitCount(i);
                    BytecodeManager.incBytecodes(2);
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
                final int signum = this.signum;
                BytecodeManager.incBytecodes(3);
                if (signum < 0) {
                    int n7 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n8 = this.mag.length - 1;
                    BytecodeManager.incBytecodes(6);
                    while (true) {
                        final int n9 = this.mag[n8];
                        BytecodeManager.incBytecodes(5);
                        if (n9 != 0) {
                            break;
                        }
                        n7 += 32;
                        BytecodeManager.incBytecodes(1);
                        --n8;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n10 = n7;
                    final int j = this.mag[n8];
                    BytecodeManager.incBytecodes(6);
                    final int n11 = n10 + Integer.numberOfTrailingZeros(j);
                    BytecodeManager.incBytecodes(2);
                    n += n11 - 1;
                    BytecodeManager.incBytecodes(6);
                }
                this.bitCount = n + 1;
                BytecodeManager.incBytecodes(5);
            }
            final int n12 = n;
            BytecodeManager.incBytecodes(2);
            return n12;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isProbablePrime(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            final BigInteger abs = this.abs();
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger = abs;
            final BigInteger two = BigInteger.TWO;
            BytecodeManager.incBytecodes(3);
            final boolean equals = bigInteger.equals(two);
            BytecodeManager.incBytecodes(1);
            if (equals) {
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final BigInteger bigInteger2 = abs;
            final int n2 = 0;
            BytecodeManager.incBytecodes(3);
            final boolean testBit = bigInteger2.testBit(n2);
            BytecodeManager.incBytecodes(1);
            if (testBit) {
                final BigInteger bigInteger3 = abs;
                final BigInteger one = BigInteger.ONE;
                BytecodeManager.incBytecodes(3);
                final boolean equals2 = bigInteger3.equals(one);
                BytecodeManager.incBytecodes(1);
                if (!equals2) {
                    final BigInteger bigInteger4 = abs;
                    final Random random = null;
                    BytecodeManager.incBytecodes(4);
                    final boolean primeToCertainty = bigInteger4.primeToCertainty(n, random);
                    BytecodeManager.incBytecodes(1);
                    return primeToCertainty;
                }
            }
            final boolean b3 = false;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int compareTo(final BigInteger bigInteger) {
        try {
            final int signum = this.signum;
            final int signum2 = bigInteger.signum;
            BytecodeManager.incBytecodes(5);
            if (signum != signum2) {
                final int signum3 = this.signum;
                final int signum4 = bigInteger.signum;
                BytecodeManager.incBytecodes(5);
                int n;
                if (signum3 > signum4) {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n;
            }
            final int signum5 = this.signum;
            BytecodeManager.incBytecodes(3);
            switch (signum5) {
                case 1: {
                    BytecodeManager.incBytecodes(3);
                    final int compareMagnitude = this.compareMagnitude(bigInteger);
                    BytecodeManager.incBytecodes(1);
                    return compareMagnitude;
                }
                case -1: {
                    BytecodeManager.incBytecodes(3);
                    final int compareMagnitude2 = bigInteger.compareMagnitude(this);
                    BytecodeManager.incBytecodes(1);
                    return compareMagnitude2;
                }
                default: {
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n2;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int compareMagnitude(final BigInteger bigInteger) {
        try {
            final int[] mag = this.mag;
            BytecodeManager.incBytecodes(3);
            final int length = mag.length;
            BytecodeManager.incBytecodes(3);
            final int[] mag2 = bigInteger.mag;
            BytecodeManager.incBytecodes(3);
            final int length2 = mag2.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = length2;
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final int n3 = -1;
                BytecodeManager.incBytecodes(2);
                return n3;
            }
            final int n4 = length;
            final int n5 = length2;
            BytecodeManager.incBytecodes(3);
            if (n4 > n5) {
                final int n6 = 1;
                BytecodeManager.incBytecodes(2);
                return n6;
            }
            int n7 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n8 = n7;
                final int n9 = length;
                BytecodeManager.incBytecodes(3);
                if (n8 >= n9) {
                    final int n10 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n10;
                }
                final int n11 = mag[n7];
                BytecodeManager.incBytecodes(4);
                final int n12 = mag2[n7];
                BytecodeManager.incBytecodes(4);
                final int n13 = n11;
                final int n14 = n12;
                BytecodeManager.incBytecodes(3);
                if (n13 != n14) {
                    final long n15 = lcmp((long)n11 & 0xFFFFFFFFL, (long)n12 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(10);
                    int n16;
                    if (n15 < 0) {
                        n16 = -1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n16 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n16;
                }
                ++n7;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int compareMagnitude(long n) {
        try {
            final boolean $assertionsDisabled = BigInteger.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final long n2 = lcmp(n, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n2 == 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int[] mag = this.mag;
            BytecodeManager.incBytecodes(3);
            final int length = mag.length;
            BytecodeManager.incBytecodes(3);
            final int n3 = length;
            final int n4 = 2;
            BytecodeManager.incBytecodes(3);
            if (n3 > n4) {
                final int n5 = 1;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            final long n6 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n6 < 0) {
                n = -n;
                BytecodeManager.incBytecodes(3);
            }
            final int n7 = (int)(n >>> 32);
            BytecodeManager.incBytecodes(5);
            final int n8 = n7;
            BytecodeManager.incBytecodes(2);
            if (n8 == 0) {
                final int n9 = length;
                final int n10 = 1;
                BytecodeManager.incBytecodes(3);
                if (n9 < n10) {
                    final int n11 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n11;
                }
                final int n12 = length;
                final int n13 = 1;
                BytecodeManager.incBytecodes(3);
                if (n12 > n13) {
                    final int n14 = 1;
                    BytecodeManager.incBytecodes(2);
                    return n14;
                }
                final int n15 = mag[0];
                BytecodeManager.incBytecodes(4);
                final int n16 = (int)n;
                BytecodeManager.incBytecodes(3);
                final int n17 = n15;
                final int n18 = n16;
                BytecodeManager.incBytecodes(3);
                if (n17 != n18) {
                    final long n19 = lcmp((long)n15 & 0xFFFFFFFFL, (long)n16 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(10);
                    int n20;
                    if (n19 < 0) {
                        n20 = -1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n20 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n20;
                }
                final int n21 = 0;
                BytecodeManager.incBytecodes(2);
                return n21;
            }
            else {
                final int n22 = length;
                final int n23 = 2;
                BytecodeManager.incBytecodes(3);
                if (n22 < n23) {
                    final int n24 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n24;
                }
                final int n25 = mag[0];
                BytecodeManager.incBytecodes(4);
                final int n26 = n7;
                BytecodeManager.incBytecodes(2);
                final int n27 = n25;
                final int n28 = n26;
                BytecodeManager.incBytecodes(3);
                if (n27 != n28) {
                    final long n29 = lcmp((long)n25 & 0xFFFFFFFFL, (long)n26 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(10);
                    int n30;
                    if (n29 < 0) {
                        n30 = -1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n30 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n30;
                }
                final int n31 = mag[1];
                BytecodeManager.incBytecodes(4);
                final int n32 = (int)n;
                BytecodeManager.incBytecodes(3);
                final int n33 = n31;
                final int n34 = n32;
                BytecodeManager.incBytecodes(3);
                if (n33 != n34) {
                    final long n35 = lcmp((long)n31 & 0xFFFFFFFFL, (long)n32 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(10);
                    int n36;
                    if (n35 < 0) {
                        n36 = -1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n36 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n36;
                }
                final int n37 = 0;
                BytecodeManager.incBytecodes(2);
                return n37;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            if (o == this) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = o instanceof BigInteger;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final BigInteger bigInteger = (BigInteger)o;
            BytecodeManager.incBytecodes(3);
            final int signum = bigInteger.signum;
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(5);
            if (signum != signum2) {
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            final int[] mag = this.mag;
            BytecodeManager.incBytecodes(3);
            final int length = mag.length;
            BytecodeManager.incBytecodes(3);
            final int[] mag2 = bigInteger.mag;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int length2 = mag2.length;
            BytecodeManager.incBytecodes(4);
            if (n != length2) {
                final boolean b5 = false;
                BytecodeManager.incBytecodes(2);
                return b5;
            }
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    final boolean b6 = true;
                    BytecodeManager.incBytecodes(2);
                    return b6;
                }
                final int n5 = mag2[n2];
                final int n6 = mag[n2];
                BytecodeManager.incBytecodes(7);
                if (n5 != n6) {
                    final boolean b7 = false;
                    BytecodeManager.incBytecodes(2);
                    return b7;
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger min(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            final int compareTo = this.compareTo(bigInteger);
            BytecodeManager.incBytecodes(1);
            BigInteger bigInteger2;
            if (compareTo < 0) {
                bigInteger2 = this;
                BytecodeManager.incBytecodes(2);
            }
            else {
                bigInteger2 = bigInteger;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger max(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            final int compareTo = this.compareTo(bigInteger);
            BytecodeManager.incBytecodes(1);
            BigInteger bigInteger2;
            if (compareTo > 0) {
                bigInteger2 = this;
                BytecodeManager.incBytecodes(2);
            }
            else {
                bigInteger2 = bigInteger;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length = this.mag.length;
                BytecodeManager.incBytecodes(5);
                if (n3 >= length) {
                    break;
                }
                n = (int)(31 * n + ((long)this.mag[n2] & 0xFFFFFFFFL));
                BytecodeManager.incBytecodes(14);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = n * this.signum;
            BytecodeManager.incBytecodes(5);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String toString(int n) {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final String s = "0";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n2 = n;
            final int n3 = 2;
            BytecodeManager.incBytecodes(3);
            Label_0050: {
                if (n2 >= n3) {
                    final int n4 = n;
                    final int n5 = 36;
                    BytecodeManager.incBytecodes(3);
                    if (n4 <= n5) {
                        break Label_0050;
                    }
                }
                n = 10;
                BytecodeManager.incBytecodes(2);
            }
            final int length = this.mag.length;
            final int n6 = 20;
            BytecodeManager.incBytecodes(5);
            if (length <= n6) {
                final int n7 = n;
                BytecodeManager.incBytecodes(3);
                final String smallToString = this.smallToString(n7);
                BytecodeManager.incBytecodes(1);
                return smallToString;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final int signum2 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum2 < 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger negate = this.negate();
                final StringBuilder sb2 = sb;
                final int n8 = n;
                final int n9 = 0;
                BytecodeManager.incBytecodes(4);
                toString(negate, sb2, n8, n9);
                final StringBuilder sb3 = sb;
                final int offset = 0;
                final char c = '-';
                BytecodeManager.incBytecodes(4);
                sb3.insert(offset, c);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final StringBuilder sb4 = sb;
                final int n10 = n;
                final int n11 = 0;
                BytecodeManager.incBytecodes(5);
                toString(this, sb4, n10, n11);
            }
            final StringBuilder sb5 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb5.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String smallToString(final int radix) {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final String s = "0";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = (4 * this.mag.length + 6) / 7;
            BytecodeManager.incBytecodes(10);
            final String[] array = new String[n];
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            BigInteger abs = this.abs();
            BytecodeManager.incBytecodes(1);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int signum2 = abs.signum;
                BytecodeManager.incBytecodes(3);
                if (signum2 == 0) {
                    break;
                }
                final BigInteger bigInteger = BigInteger.longRadix[radix];
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(3);
                final MutableBigInteger mutableBigInteger = new MutableBigInteger();
                BytecodeManager.incBytecodes(1);
                final int[] mag = abs.mag;
                BytecodeManager.incBytecodes(5);
                final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(mag);
                BytecodeManager.incBytecodes(1);
                final int[] mag2 = bigInteger.mag;
                BytecodeManager.incBytecodes(5);
                final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mag2);
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
                final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
                final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
                BytecodeManager.incBytecodes(4);
                final MutableBigInteger divide = mutableBigInteger4.divide(mutableBigInteger5, mutableBigInteger6);
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger7 = mutableBigInteger;
                final int n3 = abs.signum * bigInteger.signum;
                BytecodeManager.incBytecodes(7);
                final BigInteger bigInteger2 = mutableBigInteger7.toBigInteger(n3);
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger8 = divide;
                final int n4 = abs.signum * bigInteger.signum;
                BytecodeManager.incBytecodes(7);
                final BigInteger bigInteger3 = mutableBigInteger8.toBigInteger(n4);
                BytecodeManager.incBytecodes(1);
                final String[] array2 = array;
                final int n5 = n2++;
                final BigInteger bigInteger4 = bigInteger3;
                BytecodeManager.incBytecodes(5);
                final long longValue = bigInteger4.longValue();
                BytecodeManager.incBytecodes(2);
                array2[n5] = Long.toString(longValue, radix);
                BytecodeManager.incBytecodes(1);
                abs = bigInteger2;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            final int capacity = n2 * BigInteger.digitsPerLong[radix] + 1;
            BytecodeManager.incBytecodes(10);
            final StringBuilder sb = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final int signum3 = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum3 < 0) {
                final StringBuilder sb2 = sb;
                final char c = '-';
                BytecodeManager.incBytecodes(3);
                sb2.append(c);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder sb3 = sb;
            final String str = array[n2 - 1];
            BytecodeManager.incBytecodes(7);
            sb3.append(str);
            BytecodeManager.incBytecodes(1);
            int n6 = n2 - 2;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                if (n7 < 0) {
                    break;
                }
                final int n8 = BigInteger.digitsPerLong[radix];
                final String s2 = array[n6];
                BytecodeManager.incBytecodes(7);
                final int n9 = n8 - s2.length();
                BytecodeManager.incBytecodes(2);
                final int n10 = n9;
                BytecodeManager.incBytecodes(2);
                if (n10 != 0) {
                    final StringBuilder sb4 = sb;
                    final String str2 = BigInteger.zeros[n9];
                    BytecodeManager.incBytecodes(5);
                    sb4.append(str2);
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuilder sb5 = sb;
                final String str3 = array[n6];
                BytecodeManager.incBytecodes(5);
                sb5.append(str3);
                BytecodeManager.incBytecodes(1);
                --n6;
                BytecodeManager.incBytecodes(2);
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
    
    private static void toString(final BigInteger bigInteger, final StringBuilder sb, final int n, final int n2) {
        try {
            final int length = bigInteger.mag.length;
            final int n3 = 20;
            BytecodeManager.incBytecodes(5);
            if (length <= n3) {
                BytecodeManager.incBytecodes(3);
                final String smallToString = bigInteger.smallToString(n);
                BytecodeManager.incBytecodes(1);
                final String s = smallToString;
                BytecodeManager.incBytecodes(2);
                final int length2 = s.length();
                BytecodeManager.incBytecodes(2);
                if (length2 < n2) {
                    BytecodeManager.incBytecodes(2);
                    final int length3 = sb.length();
                    BytecodeManager.incBytecodes(1);
                    if (length3 > 0) {
                        final String s2 = smallToString;
                        BytecodeManager.incBytecodes(2);
                        int length4 = s2.length();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final int n4 = length4;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n2) {
                                break;
                            }
                            final char c = '0';
                            BytecodeManager.incBytecodes(3);
                            sb.append(c);
                            BytecodeManager.incBytecodes(1);
                            ++length4;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                final String str = smallToString;
                BytecodeManager.incBytecodes(3);
                sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            final int bitLength = bigInteger.bitLength();
            BytecodeManager.incBytecodes(1);
            final double a = bitLength * BigInteger.LOG_TWO / BigInteger.logCache[n];
            BytecodeManager.incBytecodes(9);
            final double a2 = Math.log(a) / BigInteger.LOG_TWO - 1.0;
            BytecodeManager.incBytecodes(5);
            final int n5 = (int)Math.round(a2);
            BytecodeManager.incBytecodes(2);
            final int n6 = n5;
            BytecodeManager.incBytecodes(3);
            final BigInteger radixConversionCache = getRadixConversionCache(n, n6);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger2 = radixConversionCache;
            BytecodeManager.incBytecodes(3);
            final BigInteger[] divideAndRemainder = bigInteger.divideAndRemainder(bigInteger2);
            BytecodeManager.incBytecodes(1);
            final int n7 = 1 << n5;
            BytecodeManager.incBytecodes(4);
            final BigInteger bigInteger3 = divideAndRemainder[0];
            final int n8 = n2 - n7;
            BytecodeManager.incBytecodes(9);
            toString(bigInteger3, sb, n, n8);
            final BigInteger bigInteger4 = divideAndRemainder[1];
            final int n9 = n7;
            BytecodeManager.incBytecodes(7);
            toString(bigInteger4, sb, n, n9);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger getRadixConversionCache(final int n, final int n2) {
        try {
            final BigInteger[] array = BigInteger.powerCache[n];
            BytecodeManager.incBytecodes(4);
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            if (n2 < length) {
                final BigInteger bigInteger = array[n2];
                BytecodeManager.incBytecodes(4);
                return bigInteger;
            }
            final int length2 = array.length;
            BytecodeManager.incBytecodes(3);
            final BigInteger[] array2 = array;
            final int n3 = n2 + 1;
            BytecodeManager.incBytecodes(5);
            final BigInteger[] array3 = Arrays.copyOf(array2, n3);
            BytecodeManager.incBytecodes(2);
            int n4 = length2;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 > n2) {
                    break;
                }
                final BigInteger[] array4 = array3;
                final int n6 = n4;
                final BigInteger bigInteger2 = array3[n4 - 1];
                final int n7 = 2;
                BytecodeManager.incBytecodes(9);
                array4[n6] = bigInteger2.pow(n7);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final BigInteger[][] powerCache = BigInteger.powerCache;
            BytecodeManager.incBytecodes(2);
            final int length3 = powerCache[n].length;
            BytecodeManager.incBytecodes(6);
            if (n2 >= length3) {
                final BigInteger[][] array5 = powerCache;
                BytecodeManager.incBytecodes(2);
                final BigInteger[][] powerCache2 = array5.clone();
                BytecodeManager.incBytecodes(2);
                powerCache2[n] = array3;
                BytecodeManager.incBytecodes(4);
                BigInteger.powerCache = powerCache2;
                BytecodeManager.incBytecodes(2);
            }
            final BigInteger bigInteger3 = array3[n2];
            BytecodeManager.incBytecodes(4);
            return bigInteger3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final int n = 10;
            BytecodeManager.incBytecodes(3);
            final String string = this.toString(n);
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public byte[] toByteArray() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = this.bitLength() / 8 + 1;
            BytecodeManager.incBytecodes(5);
            final byte[] array = new byte[n];
            BytecodeManager.incBytecodes(2);
            int n2 = n - 1;
            int n3 = 4;
            int int1 = 0;
            int n4 = 0;
            BytecodeManager.incBytecodes(10);
            while (true) {
                final int n5 = n2;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    break;
                }
                final int n6 = n3;
                final int n7 = 4;
                BytecodeManager.incBytecodes(3);
                if (n6 == n7) {
                    final int n8 = n4++;
                    BytecodeManager.incBytecodes(4);
                    int1 = this.getInt(n8);
                    BytecodeManager.incBytecodes(1);
                    n3 = 1;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    int1 >>>= 8;
                    BytecodeManager.incBytecodes(4);
                    ++n3;
                    BytecodeManager.incBytecodes(1);
                }
                array[n2] = (byte)int1;
                BytecodeManager.incBytecodes(5);
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            final byte[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int intValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final int int1 = this.getInt(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = int1;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long longValue() {
        try {
            long n = 0L;
            BytecodeManager.incBytecodes(2);
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 < 0) {
                    break;
                }
                final long n4 = n << 32;
                final int n5 = n2;
                BytecodeManager.incBytecodes(6);
                n = n4 + ((long)this.getInt(n5) & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(5);
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            final long n6 = n;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public float floatValue() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final float n = 0.0f;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            final int n2 = this.mag.length - 1 << 5;
            final int n3 = this.mag[0];
            BytecodeManager.incBytecodes(12);
            final int n4 = n2 + bitLengthForInt(n3) - 1;
            BytecodeManager.incBytecodes(4);
            final int n5 = n4;
            final int n6 = 63;
            BytecodeManager.incBytecodes(3);
            if (n5 < n6) {
                BytecodeManager.incBytecodes(2);
                final float n7 = (float)this.longValue();
                BytecodeManager.incBytecodes(2);
                return n7;
            }
            final int n8 = n4;
            final int n9 = 127;
            BytecodeManager.incBytecodes(3);
            if (n8 > n9) {
                final int signum2 = this.signum;
                BytecodeManager.incBytecodes(3);
                float n10;
                if (signum2 > 0) {
                    n10 = Float.POSITIVE_INFINITY;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n10 = Float.NEGATIVE_INFINITY;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n10;
            }
            final int n11 = n4 - 24;
            BytecodeManager.incBytecodes(4);
            final int n12 = n11 & 0x1F;
            BytecodeManager.incBytecodes(4);
            final int n13 = 32 - n12;
            BytecodeManager.incBytecodes(4);
            final int n14 = n12;
            BytecodeManager.incBytecodes(2);
            int n15;
            if (n14 == 0) {
                n15 = this.mag[0];
                BytecodeManager.incBytecodes(6);
            }
            else {
                n15 = this.mag[0] >>> n12;
                BytecodeManager.incBytecodes(7);
                final int n16 = n15;
                BytecodeManager.incBytecodes(2);
                if (n16 == 0) {
                    n15 = (this.mag[0] << n13 | this.mag[1] >>> n12);
                    BytecodeManager.incBytecodes(14);
                }
            }
            final int n17 = n15 >> 1;
            BytecodeManager.incBytecodes(4);
            final int n18 = n17 & 0x7FFFFF;
            BytecodeManager.incBytecodes(4);
            final int n19 = n15 & 0x1;
            BytecodeManager.incBytecodes(4);
            int n22 = 0;
            Label_0326: {
                Label_0320: {
                    if (n19 != 0) {
                        final int n20 = n18 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n20 == 0) {
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger abs = this.abs();
                            BytecodeManager.incBytecodes(1);
                            final int lowestSetBit = abs.getLowestSetBit();
                            final int n21 = n11;
                            BytecodeManager.incBytecodes(2);
                            if (lowestSetBit >= n21) {
                                break Label_0320;
                            }
                        }
                        n22 = 1;
                        BytecodeManager.incBytecodes(2);
                        break Label_0326;
                    }
                }
                n22 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n23 = n22;
            BytecodeManager.incBytecodes(1);
            final int n24 = n23;
            BytecodeManager.incBytecodes(2);
            int n25;
            if (n24 != 0) {
                n25 = n18 + 1;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n25 = n18;
                BytecodeManager.incBytecodes(1);
            }
            final int n26 = n25;
            BytecodeManager.incBytecodes(1);
            final int n27 = n4 + 127 << 23;
            BytecodeManager.incBytecodes(6);
            final int n28 = n27 + n26;
            BytecodeManager.incBytecodes(4);
            final int n29 = n28 | (this.signum & Integer.MIN_VALUE);
            BytecodeManager.incBytecodes(7);
            final int n30 = n29;
            BytecodeManager.incBytecodes(2);
            final float intBitsToFloat = Float.intBitsToFloat(n30);
            BytecodeManager.incBytecodes(1);
            return intBitsToFloat;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public double doubleValue() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final double n = 0.0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            final int n2 = this.mag.length - 1 << 5;
            final int n3 = this.mag[0];
            BytecodeManager.incBytecodes(12);
            final int n4 = n2 + bitLengthForInt(n3) - 1;
            BytecodeManager.incBytecodes(4);
            final int n5 = n4;
            final int n6 = 63;
            BytecodeManager.incBytecodes(3);
            if (n5 < n6) {
                BytecodeManager.incBytecodes(2);
                final double n7 = (double)this.longValue();
                BytecodeManager.incBytecodes(2);
                return n7;
            }
            final int n8 = n4;
            final int n9 = 1023;
            BytecodeManager.incBytecodes(3);
            if (n8 > n9) {
                final int signum2 = this.signum;
                BytecodeManager.incBytecodes(3);
                double n10;
                if (signum2 > 0) {
                    n10 = Double.POSITIVE_INFINITY;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n10 = Double.NEGATIVE_INFINITY;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n10;
            }
            final int n11 = n4 - 53;
            BytecodeManager.incBytecodes(4);
            final int n12 = n11 & 0x1F;
            BytecodeManager.incBytecodes(4);
            final int n13 = 32 - n12;
            BytecodeManager.incBytecodes(4);
            final int n14 = n12;
            BytecodeManager.incBytecodes(2);
            int n15;
            int n16;
            if (n14 == 0) {
                n15 = this.mag[0];
                BytecodeManager.incBytecodes(5);
                n16 = this.mag[1];
                BytecodeManager.incBytecodes(6);
            }
            else {
                n15 = this.mag[0] >>> n12;
                BytecodeManager.incBytecodes(7);
                n16 = (this.mag[0] << n13 | this.mag[1] >>> n12);
                BytecodeManager.incBytecodes(14);
                final int n17 = n15;
                BytecodeManager.incBytecodes(2);
                if (n17 == 0) {
                    n15 = n16;
                    BytecodeManager.incBytecodes(2);
                    n16 = (this.mag[1] << n13 | this.mag[2] >>> n12);
                    BytecodeManager.incBytecodes(14);
                }
            }
            final long n18 = ((long)n15 & 0xFFFFFFFFL) << 32 | ((long)n16 & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(12);
            final long n19 = n18 >> 1;
            BytecodeManager.incBytecodes(4);
            final long n20 = n19 & 0xFFFFFFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n21 = lcmp(n18 & 0x1L, 0L);
            BytecodeManager.incBytecodes(6);
            int n24 = 0;
            Label_0408: {
                Label_0402: {
                    if (n21 != 0) {
                        final long n22 = lcmp(n20 & 0x1L, 0L);
                        BytecodeManager.incBytecodes(6);
                        if (n22 == 0) {
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger abs = this.abs();
                            BytecodeManager.incBytecodes(1);
                            final int lowestSetBit = abs.getLowestSetBit();
                            final int n23 = n11;
                            BytecodeManager.incBytecodes(2);
                            if (lowestSetBit >= n23) {
                                break Label_0402;
                            }
                        }
                        n24 = 1;
                        BytecodeManager.incBytecodes(2);
                        break Label_0408;
                    }
                }
                n24 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n25 = n24;
            BytecodeManager.incBytecodes(1);
            final int n26 = n25;
            BytecodeManager.incBytecodes(2);
            long n27;
            if (n26 != 0) {
                n27 = n20 + 1L;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n27 = n20;
                BytecodeManager.incBytecodes(1);
            }
            final long n28 = n27;
            BytecodeManager.incBytecodes(1);
            final long n29 = (long)(n4 + 1023) << 52;
            BytecodeManager.incBytecodes(7);
            final long n30 = n29 + n28;
            BytecodeManager.incBytecodes(4);
            final long n31 = n30 | ((long)this.signum & Long.MIN_VALUE);
            BytecodeManager.incBytecodes(8);
            final long n32 = n31;
            BytecodeManager.incBytecodes(2);
            final double longBitsToDouble = Double.longBitsToDouble(n32);
            BytecodeManager.incBytecodes(1);
            return longBitsToDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] stripLeadingZeroInts(final int[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final int n4 = array[n];
                BytecodeManager.incBytecodes(4);
                if (n4 != 0) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = n;
            final int n6 = length;
            BytecodeManager.incBytecodes(4);
            final int[] copyOfRange = Arrays.copyOfRange(array, n5, n6);
            BytecodeManager.incBytecodes(1);
            return copyOfRange;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] trustedStripLeadingZeroInts(final int[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final int n4 = array[n];
                BytecodeManager.incBytecodes(4);
                if (n4 != 0) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = n;
            BytecodeManager.incBytecodes(2);
            int[] copyOfRange;
            if (n5 == 0) {
                copyOfRange = array;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n6 = n;
                final int n7 = length;
                BytecodeManager.incBytecodes(4);
                copyOfRange = Arrays.copyOfRange(array, n6, n7);
            }
            BytecodeManager.incBytecodes(1);
            return copyOfRange;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] stripLeadingZeroBytes(final byte[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final byte b = array[n];
                BytecodeManager.incBytecodes(4);
                if (b != 0) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = length - n + 3 >>> 2;
            BytecodeManager.incBytecodes(8);
            final int[] array2 = new int[n4];
            BytecodeManager.incBytecodes(2);
            int n5 = length - 1;
            BytecodeManager.incBytecodes(4);
            int n6 = n4 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                if (n7 < 0) {
                    break;
                }
                array2[n6] = (array[n5--] & 0xFF);
                BytecodeManager.incBytecodes(9);
                final int n8 = n5 - n + 1;
                BytecodeManager.incBytecodes(6);
                final int a = 3;
                final int b2 = n8;
                BytecodeManager.incBytecodes(3);
                final int min = Math.min(a, b2);
                BytecodeManager.incBytecodes(1);
                int n9 = 8;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n10 = n9;
                    final int n11 = min << 3;
                    BytecodeManager.incBytecodes(5);
                    if (n10 > n11) {
                        break;
                    }
                    final int[] array3 = array2;
                    final int n12 = n6;
                    array3[n12] |= (array[n5--] & 0xFF) << n9;
                    BytecodeManager.incBytecodes(14);
                    n9 += 8;
                    BytecodeManager.incBytecodes(2);
                }
                --n6;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] makePositive(final byte[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final byte b = array[n];
                final int n4 = -1;
                BytecodeManager.incBytecodes(5);
                if (b != n4) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            int n5 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                final int n7 = length;
                BytecodeManager.incBytecodes(3);
                if (n6 >= n7) {
                    break;
                }
                final byte b2 = array[n5];
                BytecodeManager.incBytecodes(4);
                if (b2 != 0) {
                    break;
                }
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            final int n8 = n5;
            final int n9 = length;
            BytecodeManager.incBytecodes(3);
            int n10;
            if (n8 == n9) {
                n10 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n10 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n11 = n10;
            BytecodeManager.incBytecodes(1);
            final int n12 = length - n + n11 + 3 >>> 2;
            BytecodeManager.incBytecodes(10);
            final int[] array2 = new int[n12];
            BytecodeManager.incBytecodes(2);
            int n13 = length - 1;
            BytecodeManager.incBytecodes(4);
            int n14 = n12 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n15 = n14;
                BytecodeManager.incBytecodes(2);
                if (n15 < 0) {
                    break;
                }
                array2[n14] = (array[n13--] & 0xFF);
                BytecodeManager.incBytecodes(9);
                final int a = 3;
                final int b3 = n13 - n + 1;
                BytecodeManager.incBytecodes(7);
                int min = Math.min(a, b3);
                BytecodeManager.incBytecodes(1);
                final int n16 = min;
                BytecodeManager.incBytecodes(2);
                if (n16 < 0) {
                    min = 0;
                    BytecodeManager.incBytecodes(2);
                }
                int n17 = 8;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n18 = n17;
                    final int n19 = 8 * min;
                    BytecodeManager.incBytecodes(5);
                    if (n18 > n19) {
                        break;
                    }
                    final int[] array3 = array2;
                    final int n20 = n14;
                    array3[n20] |= (array[n13--] & 0xFF) << n17;
                    BytecodeManager.incBytecodes(14);
                    n17 += 8;
                    BytecodeManager.incBytecodes(2);
                }
                final int n21 = -1 >>> 8 * (3 - min);
                BytecodeManager.incBytecodes(8);
                array2[n14] = (~array2[n14] & n21);
                BytecodeManager.incBytecodes(10);
                --n14;
                BytecodeManager.incBytecodes(2);
            }
            int n22 = array2.length - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n23 = n22;
                BytecodeManager.incBytecodes(2);
                if (n23 < 0) {
                    break;
                }
                array2[n22] = (int)(((long)array2[n22] & 0xFFFFFFFFL) + 1L);
                BytecodeManager.incBytecodes(12);
                final int n24 = array2[n22];
                BytecodeManager.incBytecodes(4);
                if (n24 != 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                --n22;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int[] makePositive(final int[] array) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final int n3 = array[n];
                final int n4 = -1;
                BytecodeManager.incBytecodes(5);
                if (n3 != n4) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            int n5 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(4);
                if (n6 >= length2) {
                    break;
                }
                final int n7 = array[n5];
                BytecodeManager.incBytecodes(4);
                if (n7 != 0) {
                    break;
                }
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            final int n8 = n5;
            final int length3 = array.length;
            BytecodeManager.incBytecodes(4);
            int n9;
            if (n8 == length3) {
                n9 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n9 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n10 = n9;
            BytecodeManager.incBytecodes(1);
            final int[] array2 = new int[array.length - n + n10];
            BytecodeManager.incBytecodes(7);
            int n11 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n12 = n11;
                final int length4 = array.length;
                BytecodeManager.incBytecodes(4);
                if (n12 >= length4) {
                    break;
                }
                array2[n11 - n + n10] = ~array[n11];
                BytecodeManager.incBytecodes(12);
                ++n11;
                BytecodeManager.incBytecodes(2);
            }
            int n13 = array2.length - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n14 = ++array2[n13];
                BytecodeManager.incBytecodes(9);
                if (n14 != 0) {
                    break;
                }
                --n13;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int intLength() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = (this.bitLength() >>> 5) + 1;
            BytecodeManager.incBytecodes(5);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int signBit() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            int n;
            if (signum < 0) {
                n = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int signInt() {
        try {
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            int n;
            if (signum < 0) {
                n = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int getInt(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final int n2 = 0;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(5);
            if (n >= length) {
                BytecodeManager.incBytecodes(2);
                final int signInt = this.signInt();
                BytecodeManager.incBytecodes(1);
                return signInt;
            }
            final int n3 = this.mag[this.mag.length - n - 1];
            BytecodeManager.incBytecodes(11);
            final int signum = this.signum;
            BytecodeManager.incBytecodes(3);
            int n4;
            if (signum >= 0) {
                n4 = n3;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final int firstNonzeroIntNum = this.firstNonzeroIntNum();
                BytecodeManager.incBytecodes(1);
                if (n <= firstNonzeroIntNum) {
                    n4 = -n3;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n4 = ~n3;
                    BytecodeManager.incBytecodes(3);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int firstNonzeroIntNum() {
        try {
            int n = this.firstNonzeroIntNum - 2;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -2;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                BytecodeManager.incBytecodes(2);
                final int length = this.mag.length;
                BytecodeManager.incBytecodes(4);
                int n4 = length - 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n5 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n5 < 0) {
                        break;
                    }
                    final int n6 = this.mag[n4];
                    BytecodeManager.incBytecodes(5);
                    if (n6 != 0) {
                        break;
                    }
                    --n4;
                    BytecodeManager.incBytecodes(2);
                }
                n = length - n4 - 1;
                BytecodeManager.incBytecodes(6);
                this.firstNonzeroIntNum = n + 2;
                BytecodeManager.incBytecodes(5);
            }
            final int n7 = n;
            BytecodeManager.incBytecodes(2);
            return n7;
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
        //    16: ldc_w           "signum"
        //    19: bipush          -2
        //    21: ldc             4
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokevirtual   java/io/ObjectInputStream$GetField.get:(Ljava/lang/String;I)I
        //    29: istore_3       
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload_2        
        //    36: ldc_w           "magnitude"
        //    39: aconst_null    
        //    40: ldc             4
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: invokevirtual   java/io/ObjectInputStream$GetField.get:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //    48: checkcast       [B
        //    51: checkcast       [B
        //    54: astore          4
        //    56: ldc             3
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: iload_3        
        //    62: iconst_m1      
        //    63: ldc             3
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: if_icmplt       81
        //    71: iload_3        
        //    72: iconst_1       
        //    73: ldc             3
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: if_icmple       141
        //    81: ldc_w           "BigInteger: Invalid signum value"
        //    84: astore          5
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_2        
        //    92: ldc_w           "signum"
        //    95: ldc             3
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: invokevirtual   java/io/ObjectInputStream$GetField.defaulted:(Ljava/lang/String;)Z
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: ifeq            121
        //   111: ldc_w           "BigInteger: Signum not present in stream"
        //   114: astore          5
        //   116: ldc             2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: new             Ljava/io/StreamCorruptedException;
        //   124: dup            
        //   125: aload           5
        //   127: ldc             4
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokespecial   java/io/StreamCorruptedException.<init>:(Ljava/lang/String;)V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: athrow         
        //   141: aload           4
        //   143: ldc             2
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: invokestatic    instrumented/java/math/BigInteger.stripLeadingZeroBytes:([B)[I
        //   151: astore          5
        //   153: ldc             1
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: aload           5
        //   160: arraylength    
        //   161: ldc             3
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: ifne            178
        //   169: iconst_1       
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: goto            184
        //   178: iconst_0       
        //   179: ldc             1
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: iload_3        
        //   185: ldc             2
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: ifne            202
        //   193: iconst_1       
        //   194: ldc             2
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: goto            208
        //   202: iconst_0       
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: ldc             1
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: if_icmpeq       276
        //   216: ldc_w           "BigInteger: signum-magnitude mismatch"
        //   219: astore          6
        //   221: ldc             2
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: aload_2        
        //   227: ldc_w           "magnitude"
        //   230: ldc             3
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: invokevirtual   java/io/ObjectInputStream$GetField.defaulted:(Ljava/lang/String;)Z
        //   238: ldc             1
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: ifeq            256
        //   246: ldc_w           "BigInteger: Magnitude not present in stream"
        //   249: astore          6
        //   251: ldc             2
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: new             Ljava/io/StreamCorruptedException;
        //   259: dup            
        //   260: aload           6
        //   262: ldc             4
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokespecial   java/io/StreamCorruptedException.<init>:(Ljava/lang/String;)V
        //   270: ldc             1
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: athrow         
        //   276: aload_0        
        //   277: iload_3        
        //   278: ldc             3
        //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   283: invokestatic    instrumented/java/math/BigInteger$UnsafeHolder.putSign:(Linstrumented/java/math/BigInteger;I)V
        //   286: aload_0        
        //   287: aload           5
        //   289: ldc             3
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: invokestatic    instrumented/java/math/BigInteger$UnsafeHolder.putMag:(Linstrumented/java/math/BigInteger;[I)V
        //   297: aload           5
        //   299: arraylength    
        //   300: ldc             67108864
        //   302: ldc             4
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: if_icmplt       356
        //   310: aload_0        
        //   311: ldc             2
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: invokespecial   instrumented/java/math/BigInteger.checkRange:()V
        //   319: ldc             1
        //   321: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   324: goto            356
        //   327: astore          6
        //   329: ldc_w           501
        //   332: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   335: new             Ljava/io/StreamCorruptedException;
        //   338: dup            
        //   339: ldc_w           "BigInteger: Out of the supported range"
        //   342: ldc             4
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: invokespecial   java/io/StreamCorruptedException.<init>:(Ljava/lang/String;)V
        //   350: ldc             1
        //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   355: athrow         
        //   356: ldc             1
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: return         
        //   362: athrow         
        //   363: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.ClassNotFoundException
        //    StackMapTable: 00 0D FE 00 51 07 00 0A 01 07 00 72 FC 00 27 07 00 97 FA 00 13 FC 00 24 07 00 85 45 01 51 01 FF 00 05 00 06 07 00 02 07 00 0C 07 00 0A 01 07 00 72 07 00 85 00 02 01 01 FC 00 2F 07 00 97 FA 00 13 72 07 00 F7 1C FF 00 05 00 00 00 01 07 00 83 FF 00 00 00 00 00 01 07 03 38
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  310    363    363    364    Ljava/lang/VirtualMachineError;
        //  310    319    327    356    Ljava/lang/ArithmeticException;
        //  0      362    362    363    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0356:
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
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            BytecodeManager.incBytecodes(1);
            final ObjectOutputStream.PutField putField = putFields;
            final String s = "signum";
            final int signum = this.signum;
            BytecodeManager.incBytecodes(5);
            putField.put(s, signum);
            final ObjectOutputStream.PutField putField2 = putFields;
            final String s2 = "magnitude";
            BytecodeManager.incBytecodes(4);
            final byte[] magSerializedForm = this.magSerializedForm();
            BytecodeManager.incBytecodes(1);
            putField2.put(s2, magSerializedForm);
            final ObjectOutputStream.PutField putField3 = putFields;
            final String s3 = "bitCount";
            final int n = -1;
            BytecodeManager.incBytecodes(4);
            putField3.put(s3, n);
            final ObjectOutputStream.PutField putField4 = putFields;
            final String s4 = "bitLength";
            final int n2 = -1;
            BytecodeManager.incBytecodes(4);
            putField4.put(s4, n2);
            final ObjectOutputStream.PutField putField5 = putFields;
            final String s5 = "lowestSetBit";
            final int n3 = -2;
            BytecodeManager.incBytecodes(4);
            putField5.put(s5, n3);
            final ObjectOutputStream.PutField putField6 = putFields;
            final String s6 = "firstNonzeroByteNum";
            final int n4 = -2;
            BytecodeManager.incBytecodes(4);
            putField6.put(s6, n4);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.writeFields();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private byte[] magSerializedForm() {
        try {
            final int length = this.mag.length;
            BytecodeManager.incBytecodes(4);
            final int n = length;
            BytecodeManager.incBytecodes(2);
            int n2;
            if (n == 0) {
                n2 = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n3 = length - 1 << 5;
                final int n4 = this.mag[0];
                BytecodeManager.incBytecodes(10);
                n2 = n3 + bitLengthForInt(n4);
                BytecodeManager.incBytecodes(1);
            }
            final int n5 = n2;
            BytecodeManager.incBytecodes(1);
            final int n6 = n5 + 7 >>> 3;
            BytecodeManager.incBytecodes(6);
            final byte[] array = new byte[n6];
            BytecodeManager.incBytecodes(2);
            int n7 = n6 - 1;
            int n8 = 4;
            int n9 = length - 1;
            int n10 = 0;
            BytecodeManager.incBytecodes(12);
            while (true) {
                final int n11 = n7;
                BytecodeManager.incBytecodes(2);
                if (n11 < 0) {
                    break;
                }
                final int n12 = n8;
                final int n13 = 4;
                BytecodeManager.incBytecodes(3);
                if (n12 == n13) {
                    n10 = this.mag[n9--];
                    BytecodeManager.incBytecodes(6);
                    n8 = 1;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n10 >>>= 8;
                    BytecodeManager.incBytecodes(4);
                    ++n8;
                    BytecodeManager.incBytecodes(1);
                }
                array[n7] = (byte)n10;
                BytecodeManager.incBytecodes(5);
                --n7;
                BytecodeManager.incBytecodes(2);
            }
            final byte[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long longValueExact() {
        try {
            final int length = this.mag.length;
            final int n = 2;
            BytecodeManager.incBytecodes(5);
            if (length <= n) {
                BytecodeManager.incBytecodes(2);
                final int bitLength = this.bitLength();
                final int n2 = 63;
                BytecodeManager.incBytecodes(2);
                if (bitLength <= n2) {
                    BytecodeManager.incBytecodes(2);
                    final long longValue = this.longValue();
                    BytecodeManager.incBytecodes(1);
                    return longValue;
                }
            }
            final String s = "BigInteger out of long range";
            BytecodeManager.incBytecodes(4);
            final ArithmeticException ex = new ArithmeticException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int intValueExact() {
        try {
            final int length = this.mag.length;
            final int n = 1;
            BytecodeManager.incBytecodes(5);
            if (length <= n) {
                BytecodeManager.incBytecodes(2);
                final int bitLength = this.bitLength();
                final int n2 = 31;
                BytecodeManager.incBytecodes(2);
                if (bitLength <= n2) {
                    BytecodeManager.incBytecodes(2);
                    final int intValue = this.intValue();
                    BytecodeManager.incBytecodes(1);
                    return intValue;
                }
            }
            final String s = "BigInteger out of int range";
            BytecodeManager.incBytecodes(4);
            final ArithmeticException ex = new ArithmeticException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public short shortValueExact() {
        try {
            final int length = this.mag.length;
            final int n = 1;
            BytecodeManager.incBytecodes(5);
            if (length <= n) {
                BytecodeManager.incBytecodes(2);
                final int bitLength = this.bitLength();
                final int n2 = 31;
                BytecodeManager.incBytecodes(2);
                if (bitLength <= n2) {
                    BytecodeManager.incBytecodes(2);
                    final int intValue = this.intValue();
                    BytecodeManager.incBytecodes(1);
                    final int n3 = intValue;
                    final int n4 = -32768;
                    BytecodeManager.incBytecodes(3);
                    if (n3 >= n4) {
                        final int n5 = intValue;
                        final int n6 = 32767;
                        BytecodeManager.incBytecodes(3);
                        if (n5 <= n6) {
                            BytecodeManager.incBytecodes(2);
                            final short shortValue = this.shortValue();
                            BytecodeManager.incBytecodes(1);
                            return shortValue;
                        }
                    }
                }
            }
            final String s = "BigInteger out of short range";
            BytecodeManager.incBytecodes(4);
            final ArithmeticException ex = new ArithmeticException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public byte byteValueExact() {
        try {
            final int length = this.mag.length;
            final int n = 1;
            BytecodeManager.incBytecodes(5);
            if (length <= n) {
                BytecodeManager.incBytecodes(2);
                final int bitLength = this.bitLength();
                final int n2 = 31;
                BytecodeManager.incBytecodes(2);
                if (bitLength <= n2) {
                    BytecodeManager.incBytecodes(2);
                    final int intValue = this.intValue();
                    BytecodeManager.incBytecodes(1);
                    final int n3 = intValue;
                    final int n4 = -128;
                    BytecodeManager.incBytecodes(3);
                    if (n3 >= n4) {
                        final int n5 = intValue;
                        final int n6 = 127;
                        BytecodeManager.incBytecodes(3);
                        if (n5 <= n6) {
                            BytecodeManager.incBytecodes(2);
                            final byte byteValue = this.byteValue();
                            BytecodeManager.incBytecodes(1);
                            return byteValue;
                        }
                    }
                }
            }
            final String s = "BigInteger out of byte range";
            BytecodeManager.incBytecodes(4);
            final ArithmeticException ex = new ArithmeticException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<BigInteger> clazz = BigInteger.class;
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
            BigInteger.bitsPerDigit = new long[] { 0L, 0L, 1024L, 1624L, 2048L, 2378L, 2648L, 2875L, 3072L, 3247L, 3402L, 3543L, 3672L, 3790L, 3899L, 4001L, 4096L, 4186L, 4271L, 4350L, 4426L, 4498L, 4567L, 4633L, 4696L, 4756L, 4814L, 4870L, 4923L, 4975L, 5025L, 5074L, 5120L, 5166L, 5210L, 5253L, 5295L };
            BytecodeManager.incBytecodes(150);
            final long n = 152125131763605L;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            SMALL_PRIME_PRODUCT = valueOf(n);
            BytecodeManager.incBytecodes(1);
            BigInteger.posConst = new BigInteger[17];
            BytecodeManager.incBytecodes(2);
            BigInteger.negConst = new BigInteger[17];
            BytecodeManager.incBytecodes(2);
            final double a = 2.0;
            BytecodeManager.incBytecodes(2);
            LOG_TWO = Math.log(a);
            BytecodeManager.incBytecodes(1);
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = 16;
                BytecodeManager.incBytecodes(3);
                if (n3 > n4) {
                    break;
                }
                final int[] array = { 0 };
                BytecodeManager.incBytecodes(2);
                array[0] = n2;
                BytecodeManager.incBytecodes(4);
                final BigInteger[] posConst = BigInteger.posConst;
                final int n5 = n2;
                final int[] array2 = array;
                final int n6 = 1;
                BytecodeManager.incBytecodes(7);
                posConst[n5] = new BigInteger(array2, n6);
                BytecodeManager.incBytecodes(1);
                final BigInteger[] negConst = BigInteger.negConst;
                final int n7 = n2;
                final int[] array3 = array;
                final int n8 = -1;
                BytecodeManager.incBytecodes(7);
                negConst[n7] = new BigInteger(array3, n8);
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BigInteger.powerCache = new BigInteger[37][];
            BytecodeManager.incBytecodes(2);
            logCache = new double[37];
            BytecodeManager.incBytecodes(2);
            int n9 = 2;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = 36;
                BytecodeManager.incBytecodes(3);
                if (n10 > n11) {
                    break;
                }
                final BigInteger[][] powerCache = BigInteger.powerCache;
                final int n12 = n9;
                final BigInteger[] array4 = { null };
                final int n13 = 0;
                final long n14 = n9;
                BytecodeManager.incBytecodes(8);
                array4[n13] = valueOf(n14);
                powerCache[n12] = array4;
                BytecodeManager.incBytecodes(2);
                final double[] logCache2 = BigInteger.logCache;
                final int n15 = n9;
                final double a2 = n9;
                BytecodeManager.incBytecodes(5);
                logCache2[n15] = Math.log(a2);
                BytecodeManager.incBytecodes(1);
                ++n9;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array5 = new int[0];
            final int n16 = 0;
            BytecodeManager.incBytecodes(5);
            ZERO = new BigInteger(array5, n16);
            BytecodeManager.incBytecodes(1);
            final long n17 = 1L;
            BytecodeManager.incBytecodes(2);
            ONE = valueOf(n17);
            BytecodeManager.incBytecodes(1);
            final long n18 = 2L;
            BytecodeManager.incBytecodes(2);
            TWO = valueOf(n18);
            BytecodeManager.incBytecodes(1);
            final long n19 = -1L;
            BytecodeManager.incBytecodes(2);
            NEGATIVE_ONE = valueOf(n19);
            BytecodeManager.incBytecodes(1);
            final long n20 = 10L;
            BytecodeManager.incBytecodes(2);
            TEN = valueOf(n20);
            BytecodeManager.incBytecodes(1);
            BigInteger.bnExpModThreshTable = new int[] { 7, 25, 81, 241, 673, 1793, Integer.MAX_VALUE };
            BytecodeManager.incBytecodes(30);
            BigInteger.zeros = new String[64];
            BytecodeManager.incBytecodes(2);
            BigInteger.zeros[63] = "000000000000000000000000000000000000000000000000000000000000000";
            BytecodeManager.incBytecodes(4);
            int n21 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n22 = n21;
                final int n23 = 63;
                BytecodeManager.incBytecodes(3);
                if (n22 >= n23) {
                    break;
                }
                final String[] zeros = BigInteger.zeros;
                final int n24 = n21;
                final String s = BigInteger.zeros[63];
                final int beginIndex = 0;
                final int endIndex = n21;
                BytecodeManager.incBytecodes(8);
                zeros[n24] = s.substring(beginIndex, endIndex);
                BytecodeManager.incBytecodes(1);
                ++n21;
                BytecodeManager.incBytecodes(2);
            }
            BigInteger.digitsPerLong = new int[] { 0, 0, 62, 39, 31, 27, 24, 22, 20, 19, 18, 18, 17, 17, 16, 16, 15, 15, 15, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12 };
            BytecodeManager.incBytecodes(150);
            final BigInteger[] longRadix = new BigInteger[37];
            longRadix[1] = (longRadix[0] = null);
            final int n25 = 2;
            final long n26 = 4611686018427387904L;
            BytecodeManager.incBytecodes(12);
            BytecodeManager.incBytecodes(1);
            longRadix[n25] = valueOf(n26);
            final int n27 = 3;
            final long n28 = 4052555153018976267L;
            BytecodeManager.incBytecodes(5);
            longRadix[n27] = valueOf(n28);
            final int n29 = 4;
            final long n30 = 4611686018427387904L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n29] = valueOf(n30);
            final int n31 = 5;
            final long n32 = 7450580596923828125L;
            BytecodeManager.incBytecodes(5);
            longRadix[n31] = valueOf(n32);
            final int n33 = 6;
            final long n34 = 4738381338321616896L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n33] = valueOf(n34);
            final int n35 = 7;
            final long n36 = 3909821048582988049L;
            BytecodeManager.incBytecodes(5);
            longRadix[n35] = valueOf(n36);
            final int n37 = 8;
            final long n38 = 1152921504606846976L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n37] = valueOf(n38);
            final int n39 = 9;
            final long n40 = 1350851717672992089L;
            BytecodeManager.incBytecodes(5);
            longRadix[n39] = valueOf(n40);
            final int n41 = 10;
            final long n42 = 1000000000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n41] = valueOf(n42);
            final int n43 = 11;
            final long n44 = 5559917313492231481L;
            BytecodeManager.incBytecodes(5);
            longRadix[n43] = valueOf(n44);
            final int n45 = 12;
            final long n46 = 2218611106740436992L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n45] = valueOf(n46);
            final int n47 = 13;
            final long n48 = 8650415919381337933L;
            BytecodeManager.incBytecodes(5);
            longRadix[n47] = valueOf(n48);
            final int n49 = 14;
            final long n50 = 2177953337809371136L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n49] = valueOf(n50);
            final int n51 = 15;
            final long n52 = 6568408355712890625L;
            BytecodeManager.incBytecodes(5);
            longRadix[n51] = valueOf(n52);
            final int n53 = 16;
            final long n54 = 1152921504606846976L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n53] = valueOf(n54);
            final int n55 = 17;
            final long n56 = 2862423051509815793L;
            BytecodeManager.incBytecodes(5);
            longRadix[n55] = valueOf(n56);
            final int n57 = 18;
            final long n58 = 6746640616477458432L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n57] = valueOf(n58);
            final int n59 = 19;
            final long n60 = 799006685782884121L;
            BytecodeManager.incBytecodes(5);
            longRadix[n59] = valueOf(n60);
            final int n61 = 20;
            final long n62 = 1638400000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n61] = valueOf(n62);
            final int n63 = 21;
            final long n64 = 3243919932521508681L;
            BytecodeManager.incBytecodes(5);
            longRadix[n63] = valueOf(n64);
            final int n65 = 22;
            final long n66 = 6221821273427820544L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n65] = valueOf(n66);
            final int n67 = 23;
            final long n68 = 504036361936467383L;
            BytecodeManager.incBytecodes(5);
            longRadix[n67] = valueOf(n68);
            final int n69 = 24;
            final long n70 = 876488338465357824L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n69] = valueOf(n70);
            final int n71 = 25;
            final long n72 = 1490116119384765625L;
            BytecodeManager.incBytecodes(5);
            longRadix[n71] = valueOf(n72);
            final int n73 = 26;
            final long n74 = 2481152873203736576L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n73] = valueOf(n74);
            final int n75 = 27;
            final long n76 = 4052555153018976267L;
            BytecodeManager.incBytecodes(5);
            longRadix[n75] = valueOf(n76);
            final int n77 = 28;
            final long n78 = 6502111422497947648L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n77] = valueOf(n78);
            final int n79 = 29;
            final long n80 = 353814783205469041L;
            BytecodeManager.incBytecodes(5);
            longRadix[n79] = valueOf(n80);
            final int n81 = 30;
            final long n82 = 531441000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n81] = valueOf(n82);
            final int n83 = 31;
            final long n84 = 787662783788549761L;
            BytecodeManager.incBytecodes(5);
            longRadix[n83] = valueOf(n84);
            final int n85 = 32;
            final long n86 = 1152921504606846976L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n85] = valueOf(n86);
            final int n87 = 33;
            final long n88 = 1667889514952984961L;
            BytecodeManager.incBytecodes(5);
            longRadix[n87] = valueOf(n88);
            final int n89 = 34;
            final long n90 = 2386420683693101056L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n89] = valueOf(n90);
            final int n91 = 35;
            final long n92 = 3379220508056640625L;
            BytecodeManager.incBytecodes(5);
            longRadix[n91] = valueOf(n92);
            final int n93 = 36;
            final long n94 = 4738381338321616896L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            longRadix[n93] = valueOf(n94);
            BigInteger.longRadix = longRadix;
            BytecodeManager.incBytecodes(2);
            BigInteger.digitsPerInt = new int[] { 0, 0, 30, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5 };
            BytecodeManager.incBytecodes(150);
            BigInteger.intRadix = new int[] { 0, 0, 1073741824, 1162261467, 1073741824, 1220703125, 362797056, 1977326743, 1073741824, 387420489, 1000000000, 214358881, 429981696, 815730721, 1475789056, 170859375, 268435456, 410338673, 612220032, 893871739, 1280000000, 1801088541, 113379904, 148035889, 191102976, 244140625, 308915776, 387420489, 481890304, 594823321, 729000000, 887503681, 1073741824, 1291467969, 1544804416, 1838265625, 60466176 };
            BytecodeManager.incBytecodes(150);
            final ObjectStreamField[] serialPersistentFields2 = new ObjectStreamField[6];
            final int n95 = 0;
            final String name = "signum";
            final Class<Integer> type = Integer.TYPE;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n95] = new ObjectStreamField(name, type);
            final int n96 = 1;
            final String name2 = "magnitude";
            final Class<byte[]> type2 = byte[].class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n96] = new ObjectStreamField(name2, type2);
            final int n97 = 2;
            final String name3 = "bitCount";
            final Class<Integer> type3 = Integer.TYPE;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n97] = new ObjectStreamField(name3, type3);
            final int n98 = 3;
            final String name4 = "bitLength";
            final Class<Integer> type4 = Integer.TYPE;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n98] = new ObjectStreamField(name4, type4);
            final int n99 = 4;
            final String name5 = "firstNonzeroByteNum";
            final Class<Integer> type5 = Integer.TYPE;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n99] = new ObjectStreamField(name5, type5);
            final int n100 = 5;
            final String name6 = "lowestSetBit";
            final Class<Integer> type6 = Integer.TYPE;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n100] = new ObjectStreamField(name6, type6);
            serialPersistentFields = serialPersistentFields2;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class UnsafeHolder
    {
        private static final Unsafe unsafe;
        private static final long signumOffset;
        private static final long magOffset;
        
        private UnsafeHolder() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static void putSign(final BigInteger o, final int x) {
            try {
                final Unsafe unsafe = UnsafeHolder.unsafe;
                final long signumOffset = UnsafeHolder.signumOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putIntVolatile(o, signumOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static void putMag(final BigInteger o, final int[] x) {
            try {
                final Unsafe unsafe = UnsafeHolder.unsafe;
                final long magOffset = UnsafeHolder.magOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putObjectVolatile(o, magOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                try {
                    try {
                        BytecodeManager.incBytecodes(1);
                        unsafe = Unsafe.getUnsafe();
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe2 = UnsafeHolder.unsafe;
                        final Class<BigInteger> clazz = BigInteger.class;
                        final String name = "signum";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField = clazz.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        signumOffset = unsafe2.objectFieldOffset(declaredField);
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe3 = UnsafeHolder.unsafe;
                        final Class<BigInteger> clazz2 = BigInteger.class;
                        final String name2 = "mag";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField2 = clazz2.getDeclaredField(name2);
                        BytecodeManager.incBytecodes(1);
                        magOffset = unsafe3.objectFieldOffset(declaredField2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (Exception ex) {
                        BytecodeManager.incBytecodes(501);
                        final Exception thrown = ex;
                        BytecodeManager.incBytecodes(4);
                        final ExceptionInInitializerError exceptionInInitializerError = new ExceptionInInitializerError(thrown);
                        BytecodeManager.incBytecodes(1);
                        throw exceptionInInitializerError;
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
    }
}
