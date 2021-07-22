// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.stream.DoubleStream;
import instrumented.java.util.stream.LongStream;
import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.stream.IntStream;
import java.security.SecureRandom;
import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.concurrent.atomic.AtomicLong;

public final class SplittableRandom
{
    private static final long GOLDEN_GAMMA = -7046029254386353131L;
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16;
    private long seed;
    private final long gamma;
    private static final AtomicLong defaultGen;
    static final String BadBound = "bound must be positive";
    static final String BadRange = "bound must be greater than origin";
    static final String BadSize = "size must be non-negative";
    
    private SplittableRandom(final long seed, final long gamma) {
        try {
            BytecodeManager.incBytecodes(2);
            this.seed = seed;
            BytecodeManager.incBytecodes(3);
            this.gamma = gamma;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long mix64(long n) {
        try {
            n = (n ^ n >>> 30) * -4658895280553007687L;
            BytecodeManager.incBytecodes(8);
            n = (n ^ n >>> 27) * -7723592293110705685L;
            BytecodeManager.incBytecodes(8);
            final long n2 = n ^ n >>> 31;
            BytecodeManager.incBytecodes(6);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int mix32(long n) {
        try {
            n = (n ^ n >>> 33) * 7109453100751455733L;
            BytecodeManager.incBytecodes(8);
            final int n2 = (int)((n ^ n >>> 28) * -3808689974395783757L >>> 32);
            BytecodeManager.incBytecodes(11);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long mixGamma(long n) {
        try {
            n = (n ^ n >>> 33) * -49064778989728563L;
            BytecodeManager.incBytecodes(8);
            n = (n ^ n >>> 33) * -4265267296055464877L;
            BytecodeManager.incBytecodes(8);
            n = ((n ^ n >>> 33) | 0x1L);
            BytecodeManager.incBytecodes(8);
            final long i = n ^ n >>> 1;
            BytecodeManager.incBytecodes(6);
            final int bitCount = Long.bitCount(i);
            BytecodeManager.incBytecodes(1);
            final int n2 = bitCount;
            final int n3 = 24;
            BytecodeManager.incBytecodes(3);
            long n4;
            if (n2 < n3) {
                n4 = (n ^ 0xAAAAAAAAAAAAAAAAL);
                BytecodeManager.incBytecodes(4);
            }
            else {
                n4 = n;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long nextSeed() {
        try {
            final long seed = this.seed + this.gamma;
            this.seed = seed;
            BytecodeManager.incBytecodes(9);
            return seed;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long initialSeed() {
        try {
            final String theProp = "java.util.secureRandomSeed";
            BytecodeManager.incBytecodes(4);
            final GetPropertyAction action = new GetPropertyAction(theProp);
            BytecodeManager.incBytecodes(1);
            final String s = AccessController.doPrivileged((PrivilegedAction<String>)action);
            BytecodeManager.incBytecodes(2);
            final String s2 = s;
            BytecodeManager.incBytecodes(2);
            if (s2 != null) {
                final String s3 = s;
                final String anotherString = "true";
                BytecodeManager.incBytecodes(3);
                final boolean equalsIgnoreCase = s3.equalsIgnoreCase(anotherString);
                BytecodeManager.incBytecodes(1);
                if (equalsIgnoreCase) {
                    final int numBytes = 8;
                    BytecodeManager.incBytecodes(2);
                    final byte[] seed = SecureRandom.getSeed(numBytes);
                    BytecodeManager.incBytecodes(1);
                    long n = (long)seed[0] & 0xFFL;
                    BytecodeManager.incBytecodes(7);
                    int n2 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = 8;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            break;
                        }
                        n = (n << 8 | ((long)seed[n2] & 0xFFL));
                        BytecodeManager.incBytecodes(11);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    final long n5 = n;
                    BytecodeManager.incBytecodes(2);
                    return n5;
                }
            }
            BytecodeManager.incBytecodes(1);
            final long currentTimeMillis = System.currentTimeMillis();
            BytecodeManager.incBytecodes(1);
            final long mix64 = mix64(currentTimeMillis);
            BytecodeManager.incBytecodes(1);
            final long nanoTime = System.nanoTime();
            BytecodeManager.incBytecodes(1);
            final long n6 = mix64 ^ mix64(nanoTime);
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final long internalNextLong(final long n, final long n2) {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            long n3 = mix64(nextSeed);
            BytecodeManager.incBytecodes(1);
            final long n4 = lcmp(n, n2);
            BytecodeManager.incBytecodes(4);
            if (n4 < 0) {
                final long n5 = n2 - n;
                final long n6 = n5 - 1L;
                BytecodeManager.incBytecodes(8);
                final long n7 = lcmp(n5 & n6, 0L);
                BytecodeManager.incBytecodes(6);
                if (n7 == 0) {
                    n3 = (n3 & n6) + n;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    final long n8 = lcmp(n5, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n8 > 0) {
                        long n9 = n3 >>> 1;
                        BytecodeManager.incBytecodes(4);
                        long n11;
                        while (true) {
                            final long n10 = lcmp(n9 + n6 - (n11 = n9 % n5), 0L);
                            BytecodeManager.incBytecodes(12);
                            if (n10 >= 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long nextSeed2 = this.nextSeed();
                            BytecodeManager.incBytecodes(1);
                            n9 = mix64(nextSeed2) >>> 1;
                            BytecodeManager.incBytecodes(4);
                        }
                        n3 = n11 + n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        while (true) {
                            final long n12 = lcmp(n3, n);
                            BytecodeManager.incBytecodes(4);
                            if (n12 >= 0) {
                                final long n13 = lcmp(n3, n2);
                                BytecodeManager.incBytecodes(4);
                                if (n13 < 0) {
                                    break;
                                }
                            }
                            BytecodeManager.incBytecodes(2);
                            final long nextSeed3 = this.nextSeed();
                            BytecodeManager.incBytecodes(1);
                            n3 = mix64(nextSeed3);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
            }
            final long n14 = n3;
            BytecodeManager.incBytecodes(2);
            return n14;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int internalNextInt(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            int n3 = mix32(nextSeed);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final int n4 = n2 - n;
                final int n5 = n4 - 1;
                BytecodeManager.incBytecodes(8);
                final int n6 = n4 & n5;
                BytecodeManager.incBytecodes(4);
                if (n6 == 0) {
                    n3 = (n3 & n5) + n;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    final int n7 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n7 > 0) {
                        int n8 = n3 >>> 1;
                        BytecodeManager.incBytecodes(4);
                        int n10;
                        while (true) {
                            final int n9 = n8 + n5 - (n10 = n8 % n4);
                            BytecodeManager.incBytecodes(10);
                            if (n9 >= 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long nextSeed2 = this.nextSeed();
                            BytecodeManager.incBytecodes(1);
                            n8 = mix32(nextSeed2) >>> 1;
                            BytecodeManager.incBytecodes(4);
                        }
                        n3 = n10 + n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        while (true) {
                            final int n11 = n3;
                            BytecodeManager.incBytecodes(3);
                            if (n11 >= n) {
                                final int n12 = n3;
                                BytecodeManager.incBytecodes(3);
                                if (n12 < n2) {
                                    break;
                                }
                            }
                            BytecodeManager.incBytecodes(2);
                            final long nextSeed3 = this.nextSeed();
                            BytecodeManager.incBytecodes(1);
                            n3 = mix32(nextSeed3);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
            }
            final int n13 = n3;
            BytecodeManager.incBytecodes(2);
            return n13;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final double internalNextDouble(final double n, final double value) {
        try {
            BytecodeManager.incBytecodes(2);
            double longBitsToDouble = (this.nextLong() >>> 11) * 1.1102230246251565E-16;
            BytecodeManager.incBytecodes(6);
            final double n2 = dcmpg(n, value);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                longBitsToDouble = longBitsToDouble * (value - n) + n;
                BytecodeManager.incBytecodes(8);
                final double n3 = dcmpl(longBitsToDouble, value);
                BytecodeManager.incBytecodes(4);
                if (n3 >= 0) {
                    BytecodeManager.incBytecodes(2);
                    final long n4 = Double.doubleToLongBits(value) - 1L;
                    BytecodeManager.incBytecodes(3);
                    longBitsToDouble = Double.longBitsToDouble(n4);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final double n5 = longBitsToDouble;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public SplittableRandom(final long n) {
        try {
            final long n2 = -7046029254386353131L;
            BytecodeManager.incBytecodes(4);
            this(n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public SplittableRandom() {
        try {
            BytecodeManager.incBytecodes(2);
            final AtomicLong defaultGen = SplittableRandom.defaultGen;
            final long n = 4354685564936845354L;
            BytecodeManager.incBytecodes(3);
            final long andAdd = defaultGen.getAndAdd(n);
            BytecodeManager.incBytecodes(1);
            final long n2 = andAdd;
            BytecodeManager.incBytecodes(3);
            this.seed = mix64(n2);
            BytecodeManager.incBytecodes(1);
            final long n3 = andAdd - 7046029254386353131L;
            BytecodeManager.incBytecodes(5);
            this.gamma = mixGamma(n3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public SplittableRandom split() {
        try {
            BytecodeManager.incBytecodes(4);
            final long nextLong = this.nextLong();
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final long mixGamma = mixGamma(nextSeed);
            BytecodeManager.incBytecodes(1);
            final SplittableRandom splittableRandom = new SplittableRandom(nextLong, mixGamma);
            BytecodeManager.incBytecodes(1);
            return splittableRandom;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextInt() {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final int mix32 = mix32(nextSeed);
            BytecodeManager.incBytecodes(1);
            return mix32;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextInt(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                final String s = "bound must be positive";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final int mix32 = mix32(nextSeed);
            BytecodeManager.incBytecodes(1);
            final int n2 = n - 1;
            BytecodeManager.incBytecodes(4);
            final int n3 = n & n2;
            BytecodeManager.incBytecodes(4);
            int n4;
            if (n3 == 0) {
                n4 = (mix32 & n2);
                BytecodeManager.incBytecodes(5);
            }
            else {
                int n5 = mix32 >>> 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n6 = n5 + n2 - (n4 = n5 % n);
                    BytecodeManager.incBytecodes(10);
                    if (n6 >= 0) {
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    final long nextSeed2 = this.nextSeed();
                    BytecodeManager.incBytecodes(1);
                    n5 = mix32(nextSeed2) >>> 1;
                    BytecodeManager.incBytecodes(4);
                }
            }
            final int n7 = n4;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextInt(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n >= n2) {
                final String s = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(4);
            final int internalNextInt = this.internalNextInt(n, n2);
            BytecodeManager.incBytecodes(1);
            return internalNextInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long nextLong() {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final long mix64 = mix64(nextSeed);
            BytecodeManager.incBytecodes(1);
            return mix64;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long nextLong(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 <= 0) {
                final String s = "bound must be positive";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final long mix64 = mix64(nextSeed);
            BytecodeManager.incBytecodes(1);
            final long n3 = n - 1L;
            BytecodeManager.incBytecodes(4);
            final long n4 = lcmp(n & n3, 0L);
            BytecodeManager.incBytecodes(6);
            long n5;
            if (n4 == 0) {
                n5 = (mix64 & n3);
                BytecodeManager.incBytecodes(5);
            }
            else {
                long n6 = mix64 >>> 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final long n7 = lcmp(n6 + n3 - (n5 = n6 % n), 0L);
                    BytecodeManager.incBytecodes(12);
                    if (n7 >= 0) {
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    final long nextSeed2 = this.nextSeed();
                    BytecodeManager.incBytecodes(1);
                    n6 = mix64(nextSeed2) >>> 1;
                    BytecodeManager.incBytecodes(4);
                }
            }
            final long n8 = n5;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long nextLong(final long n, final long n2) {
        try {
            final long n3 = lcmp(n, n2);
            BytecodeManager.incBytecodes(4);
            if (n3 >= 0) {
                final String s = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(4);
            final long internalNextLong = this.internalNextLong(n, n2);
            BytecodeManager.incBytecodes(1);
            return internalNextLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double nextDouble() {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final double n = (mix64(nextSeed) >>> 11) * 1.1102230246251565E-16;
            BytecodeManager.incBytecodes(6);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double nextDouble(final double value) {
        try {
            final double n = dcmpl(value, 0.0);
            BytecodeManager.incBytecodes(4);
            if (n <= 0) {
                final String s = "bound must be positive";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final double n2 = (mix64(nextSeed) >>> 11) * 1.1102230246251565E-16 * value;
            BytecodeManager.incBytecodes(8);
            final double n3 = dcmpg(n2, value);
            BytecodeManager.incBytecodes(4);
            double longBitsToDouble;
            if (n3 < 0) {
                longBitsToDouble = n2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final long n4 = Double.doubleToLongBits(value) - 1L;
                BytecodeManager.incBytecodes(3);
                longBitsToDouble = Double.longBitsToDouble(n4);
            }
            BytecodeManager.incBytecodes(1);
            return longBitsToDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double nextDouble(final double n, final double n2) {
        try {
            final double n3 = dcmpg(n, n2);
            BytecodeManager.incBytecodes(4);
            if (n3 >= 0) {
                final String s = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(4);
            final double internalNextDouble = this.internalNextDouble(n, n2);
            BytecodeManager.incBytecodes(1);
            return internalNextDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean nextBoolean() {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final int mix32 = mix32(nextSeed);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (mix32 < 0) {
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
    
    public IntStream ints(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                final String s = "size must be non-negative";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n3 = 0L;
            final int n4 = Integer.MAX_VALUE;
            final int n5 = 0;
            BytecodeManager.incBytecodes(8);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(this, n3, n, n4, n5);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final IntStream intStream = StreamSupport.intStream(randomIntsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IntStream ints() {
        try {
            final long n = 0L;
            final long n2 = Long.MAX_VALUE;
            final int n3 = Integer.MAX_VALUE;
            final int n4 = 0;
            BytecodeManager.incBytecodes(8);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(this, n, n2, n3, n4);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final IntStream intStream = StreamSupport.intStream(randomIntsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IntStream ints(final long n, final int n2, final int n3) {
        try {
            final long n4 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n4 < 0) {
                final String s = "size must be non-negative";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            if (n2 >= n3) {
                final String s2 = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final long n5 = 0L;
            BytecodeManager.incBytecodes(8);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(this, n5, n, n2, n3);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final IntStream intStream = StreamSupport.intStream(randomIntsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IntStream ints(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n >= n2) {
                final String s = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n3 = 0L;
            final long n4 = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(8);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(this, n3, n4, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final IntStream intStream = StreamSupport.intStream(randomIntsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LongStream longs(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                final String s = "size must be non-negative";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n3 = 0L;
            final long n4 = Long.MAX_VALUE;
            final long n5 = 0L;
            BytecodeManager.incBytecodes(8);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(this, n3, n, n4, n5);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LongStream longStream = StreamSupport.longStream(randomLongsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LongStream longs() {
        try {
            final long n = 0L;
            final long n2 = Long.MAX_VALUE;
            final long n3 = Long.MAX_VALUE;
            final long n4 = 0L;
            BytecodeManager.incBytecodes(8);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(this, n, n2, n3, n4);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LongStream longStream = StreamSupport.longStream(randomLongsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LongStream longs(final long n, final long n2, final long n3) {
        try {
            final long n4 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n4 < 0) {
                final String s = "size must be non-negative";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n5 = lcmp(n2, n3);
            BytecodeManager.incBytecodes(4);
            if (n5 >= 0) {
                final String s2 = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final long n6 = 0L;
            BytecodeManager.incBytecodes(8);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(this, n6, n, n2, n3);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LongStream longStream = StreamSupport.longStream(randomLongsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LongStream longs(final long n, final long n2) {
        try {
            final long n3 = lcmp(n, n2);
            BytecodeManager.incBytecodes(4);
            if (n3 >= 0) {
                final String s = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n4 = 0L;
            final long n5 = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(8);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(this, n4, n5, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final LongStream longStream = StreamSupport.longStream(randomLongsSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DoubleStream doubles(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                final String s = "size must be non-negative";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n3 = 0L;
            final double n4 = Double.MAX_VALUE;
            final double n5 = 0.0;
            BytecodeManager.incBytecodes(8);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(this, n3, n, n4, n5);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final DoubleStream doubleStream = StreamSupport.doubleStream(randomDoublesSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DoubleStream doubles() {
        try {
            final long n = 0L;
            final long n2 = Long.MAX_VALUE;
            final double n3 = Double.MAX_VALUE;
            final double n4 = 0.0;
            BytecodeManager.incBytecodes(8);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(this, n, n2, n3, n4);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final DoubleStream doubleStream = StreamSupport.doubleStream(randomDoublesSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DoubleStream doubles(final long n, final double n2, final double n3) {
        try {
            final long n4 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n4 < 0) {
                final String s = "size must be non-negative";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final double n5 = dcmpg(n2, n3);
            BytecodeManager.incBytecodes(4);
            if (n5 >= 0) {
                final String s2 = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final long n6 = 0L;
            BytecodeManager.incBytecodes(8);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(this, n6, n, n2, n3);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final DoubleStream doubleStream = StreamSupport.doubleStream(randomDoublesSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DoubleStream doubles(final double n, final double n2) {
        try {
            final double n3 = dcmpg(n, n2);
            BytecodeManager.incBytecodes(4);
            if (n3 >= 0) {
                final String s = "bound must be greater than origin";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n4 = 0L;
            final long n5 = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(8);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(this, n4, n5, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final DoubleStream doubleStream = StreamSupport.doubleStream(randomDoublesSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            final long initialSeed = initialSeed();
            BytecodeManager.incBytecodes(1);
            defaultGen = new AtomicLong(initialSeed);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class RandomIntsSpliterator implements Spliterator.OfInt
    {
        final SplittableRandom rng;
        long index;
        final long fence;
        final int origin;
        final int bound;
        
        RandomIntsSpliterator(final SplittableRandom rng, final long index, final long fence, final int origin, final int bound) {
            try {
                BytecodeManager.incBytecodes(2);
                this.rng = rng;
                this.index = index;
                this.fence = fence;
                BytecodeManager.incBytecodes(9);
                this.origin = origin;
                this.bound = bound;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public RandomIntsSpliterator trySplit() {
            try {
                final long index = this.index;
                final long n = index + this.fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final long n2 = lcmp(n, index);
                BytecodeManager.incBytecodes(4);
                RandomIntsSpliterator randomIntsSpliterator;
                if (n2 <= 0) {
                    randomIntsSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final SplittableRandom split;
                    final long n3;
                    final long index2;
                    final int origin;
                    final int bound;
                    randomIntsSpliterator = new RandomIntsSpliterator(split, n3, index2, origin, bound);
                    final SplittableRandom rng = this.rng;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    split = rng.split();
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(10);
                }
                BytecodeManager.incBytecodes(1);
                return randomIntsSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long n = this.fence - this.index;
                BytecodeManager.incBytecodes(6);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 17728;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (intConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long index = this.index;
                final long fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final long n = lcmp(index, fence);
                BytecodeManager.incBytecodes(4);
                if (n < 0) {
                    final SplittableRandom rng = this.rng;
                    final int origin = this.origin;
                    final int bound = this.bound;
                    BytecodeManager.incBytecodes(8);
                    final int internalNextInt = rng.internalNextInt(origin, bound);
                    BytecodeManager.incBytecodes(1);
                    intConsumer.accept(internalNextInt);
                    this.index = index + 1L;
                    BytecodeManager.incBytecodes(5);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (intConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                long index = this.index;
                final long fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final long n = lcmp(index, fence);
                BytecodeManager.incBytecodes(4);
                if (n < 0) {
                    this.index = fence;
                    BytecodeManager.incBytecodes(3);
                    final SplittableRandom rng = this.rng;
                    BytecodeManager.incBytecodes(3);
                    final int origin = this.origin;
                    final int bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    long n2;
                    do {
                        final SplittableRandom splittableRandom = rng;
                        final int n3 = origin;
                        final int n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final int internalNextInt = splittableRandom.internalNextInt(n3, n4);
                        BytecodeManager.incBytecodes(1);
                        intConsumer.accept(internalNextInt);
                        n2 = lcmp(++index, fence);
                        BytecodeManager.incBytecodes(8);
                    } while (n2 < 0);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class RandomLongsSpliterator implements Spliterator.OfLong
    {
        final SplittableRandom rng;
        long index;
        final long fence;
        final long origin;
        final long bound;
        
        RandomLongsSpliterator(final SplittableRandom rng, final long index, final long fence, final long origin, final long bound) {
            try {
                BytecodeManager.incBytecodes(2);
                this.rng = rng;
                this.index = index;
                this.fence = fence;
                BytecodeManager.incBytecodes(9);
                this.origin = origin;
                this.bound = bound;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public RandomLongsSpliterator trySplit() {
            try {
                final long index = this.index;
                final long n = index + this.fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final long n2 = lcmp(n, index);
                BytecodeManager.incBytecodes(4);
                RandomLongsSpliterator randomLongsSpliterator;
                if (n2 <= 0) {
                    randomLongsSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final SplittableRandom split;
                    final long n3;
                    final long index2;
                    final long origin;
                    final long bound;
                    randomLongsSpliterator = new RandomLongsSpliterator(split, n3, index2, origin, bound);
                    final SplittableRandom rng = this.rng;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    split = rng.split();
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(10);
                }
                BytecodeManager.incBytecodes(1);
                return randomLongsSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long n = this.fence - this.index;
                BytecodeManager.incBytecodes(6);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 17728;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (longConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long index = this.index;
                final long fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final long n = lcmp(index, fence);
                BytecodeManager.incBytecodes(4);
                if (n < 0) {
                    final SplittableRandom rng = this.rng;
                    final long origin = this.origin;
                    final long bound = this.bound;
                    BytecodeManager.incBytecodes(8);
                    final long internalNextLong = rng.internalNextLong(origin, bound);
                    BytecodeManager.incBytecodes(1);
                    longConsumer.accept(internalNextLong);
                    this.index = index + 1L;
                    BytecodeManager.incBytecodes(5);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (longConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                long index = this.index;
                final long fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final long n = lcmp(index, fence);
                BytecodeManager.incBytecodes(4);
                if (n < 0) {
                    this.index = fence;
                    BytecodeManager.incBytecodes(3);
                    final SplittableRandom rng = this.rng;
                    BytecodeManager.incBytecodes(3);
                    final long origin = this.origin;
                    final long bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    long n2;
                    do {
                        final SplittableRandom splittableRandom = rng;
                        final long n3 = origin;
                        final long n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final long internalNextLong = splittableRandom.internalNextLong(n3, n4);
                        BytecodeManager.incBytecodes(1);
                        longConsumer.accept(internalNextLong);
                        n2 = lcmp(++index, fence);
                        BytecodeManager.incBytecodes(8);
                    } while (n2 < 0);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class RandomDoublesSpliterator implements Spliterator.OfDouble
    {
        final SplittableRandom rng;
        long index;
        final long fence;
        final double origin;
        final double bound;
        
        RandomDoublesSpliterator(final SplittableRandom rng, final long index, final long fence, final double origin, final double bound) {
            try {
                BytecodeManager.incBytecodes(2);
                this.rng = rng;
                this.index = index;
                this.fence = fence;
                BytecodeManager.incBytecodes(9);
                this.origin = origin;
                this.bound = bound;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public RandomDoublesSpliterator trySplit() {
            try {
                final long index = this.index;
                final long n = index + this.fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final long n2 = lcmp(n, index);
                BytecodeManager.incBytecodes(4);
                RandomDoublesSpliterator randomDoublesSpliterator;
                if (n2 <= 0) {
                    randomDoublesSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final SplittableRandom split;
                    final long n3;
                    final long index2;
                    final double origin;
                    final double bound;
                    randomDoublesSpliterator = new RandomDoublesSpliterator(split, n3, index2, origin, bound);
                    final SplittableRandom rng = this.rng;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    split = rng.split();
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(10);
                }
                BytecodeManager.incBytecodes(1);
                return randomDoublesSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long n = this.fence - this.index;
                BytecodeManager.incBytecodes(6);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 17728;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (doubleConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long index = this.index;
                final long fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final long n = lcmp(index, fence);
                BytecodeManager.incBytecodes(4);
                if (n < 0) {
                    final SplittableRandom rng = this.rng;
                    final double origin = this.origin;
                    final double bound = this.bound;
                    BytecodeManager.incBytecodes(8);
                    final double internalNextDouble = rng.internalNextDouble(origin, bound);
                    BytecodeManager.incBytecodes(1);
                    doubleConsumer.accept(internalNextDouble);
                    this.index = index + 1L;
                    BytecodeManager.incBytecodes(5);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (doubleConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                long index = this.index;
                final long fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final long n = lcmp(index, fence);
                BytecodeManager.incBytecodes(4);
                if (n < 0) {
                    this.index = fence;
                    BytecodeManager.incBytecodes(3);
                    final SplittableRandom rng = this.rng;
                    BytecodeManager.incBytecodes(3);
                    final double origin = this.origin;
                    final double bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    long n2;
                    do {
                        final SplittableRandom splittableRandom = rng;
                        final double n3 = origin;
                        final double n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final double internalNextDouble = splittableRandom.internalNextDouble(n3, n4);
                        BytecodeManager.incBytecodes(1);
                        doubleConsumer.accept(internalNextDouble);
                        n2 = lcmp(++index, fence);
                        BytecodeManager.incBytecodes(8);
                    } while (n2 < 0);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
