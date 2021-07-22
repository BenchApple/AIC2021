// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.io.ObjectInputStream;
import instrumented.java.util.stream.DoubleStream;
import instrumented.java.util.stream.LongStream;
import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.stream.IntStream;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.ObjectStreamField;
import instrumented.java.util.concurrent.atomic.AtomicLong;
import java.io.Serializable;

public class Random implements Serializable
{
    static final long serialVersionUID = 3905348978240129619L;
    private final AtomicLong seed;
    private static final long multiplier = 25214903917L;
    private static final long addend = 11L;
    private static final long mask = 281474976710655L;
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16;
    static final String BadBound = "bound must be positive";
    static final String BadRange = "bound must be greater than origin";
    static final String BadSize = "size must be non-negative";
    private static final AtomicLong seedUniquifier;
    private double nextNextGaussian;
    private boolean haveNextNextGaussian;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final Unsafe unsafe;
    private static final long seedOffset;
    
    public Random() {
        try {
            BytecodeManager.incBytecodes(2);
            final long seedUniquifier = seedUniquifier();
            BytecodeManager.incBytecodes(1);
            final long n = seedUniquifier ^ System.nanoTime();
            BytecodeManager.incBytecodes(2);
            this(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long seedUniquifier() {
        try {
            long n;
            while (true) {
                final AtomicLong seedUniquifier = Random.seedUniquifier;
                BytecodeManager.incBytecodes(2);
                final long value = seedUniquifier.get();
                BytecodeManager.incBytecodes(1);
                n = value * 181783497276652981L;
                BytecodeManager.incBytecodes(4);
                final AtomicLong seedUniquifier2 = Random.seedUniquifier;
                final long n2 = value;
                final long n3 = n;
                BytecodeManager.incBytecodes(4);
                final boolean compareAndSet = seedUniquifier2.compareAndSet(n2, n3);
                BytecodeManager.incBytecodes(1);
                if (compareAndSet) {
                    break;
                }
                BytecodeManager.incBytecodes(1);
            }
            final long n4 = n;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Random(final long seed) {
        try {
            BytecodeManager.incBytecodes(2);
            this.haveNextNextGaussian = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final Class<? extends Random> class1 = this.getClass();
            final Class<Random> clazz = Random.class;
            BytecodeManager.incBytecodes(2);
            if (class1 == clazz) {
                BytecodeManager.incBytecodes(5);
                final long initialScramble = initialScramble(seed);
                BytecodeManager.incBytecodes(1);
                this.seed = new AtomicLong(initialScramble);
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(4);
                this.seed = new AtomicLong();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.setSeed(seed);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long initialScramble(final long n) {
        try {
            final long n2 = (n ^ 0x5DEECE66DL) & 0xFFFFFFFFFFFFL;
            BytecodeManager.incBytecodes(6);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void setSeed(final long n) {
        try {
            final AtomicLong seed = this.seed;
            BytecodeManager.incBytecodes(4);
            final long initialScramble = initialScramble(n);
            BytecodeManager.incBytecodes(1);
            seed.set(initialScramble);
            this.haveNextNextGaussian = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected int next(final int n) {
        try {
            final AtomicLong seed = this.seed;
            BytecodeManager.incBytecodes(3);
            boolean compareAndSet;
            long n2;
            do {
                final AtomicLong atomicLong = seed;
                BytecodeManager.incBytecodes(2);
                final long value = atomicLong.get();
                BytecodeManager.incBytecodes(1);
                n2 = (value * 25214903917L + 11L & 0xFFFFFFFFFFFFL);
                BytecodeManager.incBytecodes(8);
                final AtomicLong atomicLong2 = seed;
                final long n3 = value;
                final long n4 = n2;
                BytecodeManager.incBytecodes(4);
                compareAndSet = atomicLong2.compareAndSet(n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n5 = (int)(n2 >>> 48 - n);
            BytecodeManager.incBytecodes(7);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void nextBytes(final byte[] array) {
        try {
            int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                int nextInt = this.nextInt();
                BytecodeManager.incBytecodes(1);
                final int a = length - n;
                final int b = 4;
                BytecodeManager.incBytecodes(5);
                int min = Math.min(a, b);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final int n4 = min--;
                    BytecodeManager.incBytecodes(3);
                    if (n4 <= 0) {
                        break;
                    }
                    array[n++] = (byte)nextInt;
                    BytecodeManager.incBytecodes(6);
                    nextInt >>= 8;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final long internalNextLong(final long n, final long n2) {
        try {
            BytecodeManager.incBytecodes(2);
            long n3 = this.nextLong();
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
                            n9 = this.nextLong() >>> 1;
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
                            n3 = this.nextLong();
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
            BytecodeManager.incBytecodes(3);
            if (n >= n2) {
                BytecodeManager.incBytecodes(2);
                final int nextInt = this.nextInt();
                BytecodeManager.incBytecodes(1);
                return nextInt;
            }
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 > 0) {
                final int n5 = n3;
                BytecodeManager.incBytecodes(3);
                final int n6 = this.nextInt(n5) + n;
                BytecodeManager.incBytecodes(3);
                return n6;
            }
            int nextInt2;
            while (true) {
                BytecodeManager.incBytecodes(2);
                nextInt2 = this.nextInt();
                BytecodeManager.incBytecodes(1);
                final int n7 = nextInt2;
                BytecodeManager.incBytecodes(3);
                if (n7 >= n) {
                    final int n8 = nextInt2;
                    BytecodeManager.incBytecodes(3);
                    if (n8 < n2) {
                        break;
                    }
                    continue;
                }
            }
            final int n9 = nextInt2;
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final double internalNextDouble(final double n, final double value) {
        try {
            BytecodeManager.incBytecodes(2);
            double n2 = this.nextDouble();
            BytecodeManager.incBytecodes(1);
            final double n3 = dcmpg(n, value);
            BytecodeManager.incBytecodes(4);
            if (n3 < 0) {
                n2 = n2 * (value - n) + n;
                BytecodeManager.incBytecodes(8);
                final double n4 = dcmpl(n2, value);
                BytecodeManager.incBytecodes(4);
                if (n4 >= 0) {
                    BytecodeManager.incBytecodes(2);
                    final long n5 = Double.doubleToLongBits(value) - 1L;
                    BytecodeManager.incBytecodes(3);
                    n2 = Double.longBitsToDouble(n5);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final double n6 = n2;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextInt() {
        try {
            final int n = 32;
            BytecodeManager.incBytecodes(3);
            final int next = this.next(n);
            BytecodeManager.incBytecodes(1);
            return next;
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
            final int n2 = 31;
            BytecodeManager.incBytecodes(3);
            final int next = this.next(n2);
            BytecodeManager.incBytecodes(1);
            final int n3 = n - 1;
            BytecodeManager.incBytecodes(4);
            final int n4 = n & n3;
            BytecodeManager.incBytecodes(4);
            int n5;
            if (n4 == 0) {
                n5 = (int)(n * (long)next >> 31);
                BytecodeManager.incBytecodes(10);
            }
            else {
                int next2 = next;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = next2 - (n5 = next2 % n) + n3;
                    BytecodeManager.incBytecodes(10);
                    if (n6 >= 0) {
                        break;
                    }
                    final int n7 = 31;
                    BytecodeManager.incBytecodes(3);
                    next2 = this.next(n7);
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n8 = n5;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long nextLong() {
        try {
            final int n = 32;
            BytecodeManager.incBytecodes(3);
            final long n2 = (long)this.next(n) << 32;
            final int n3 = 32;
            BytecodeManager.incBytecodes(6);
            final long n4 = n2 + this.next(n3);
            BytecodeManager.incBytecodes(3);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean nextBoolean() {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final int next = this.next(n);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (next != 0) {
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
    
    public float nextFloat() {
        try {
            final int n = 24;
            BytecodeManager.incBytecodes(3);
            final float n2 = this.next(n) / 1.6777216E7f;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double nextDouble() {
        try {
            final int n = 26;
            BytecodeManager.incBytecodes(3);
            final long n2 = (long)this.next(n) << 27;
            final int n3 = 27;
            BytecodeManager.incBytecodes(6);
            final double n4 = (n2 + this.next(n3)) * 1.1102230246251565E-16;
            BytecodeManager.incBytecodes(6);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized double nextGaussian() {
        try {
            final boolean haveNextNextGaussian = this.haveNextNextGaussian;
            BytecodeManager.incBytecodes(3);
            if (haveNextNextGaussian) {
                this.haveNextNextGaussian = false;
                BytecodeManager.incBytecodes(3);
                final double nextNextGaussian = this.nextNextGaussian;
                BytecodeManager.incBytecodes(3);
                return nextNextGaussian;
            }
            double n2;
            double n4;
            double n5;
            while (true) {
                final double n = 2.0;
                BytecodeManager.incBytecodes(3);
                n2 = n * this.nextDouble() - 1.0;
                BytecodeManager.incBytecodes(4);
                final double n3 = 2.0;
                BytecodeManager.incBytecodes(3);
                n4 = n3 * this.nextDouble() - 1.0;
                BytecodeManager.incBytecodes(4);
                n5 = n2 * n2 + n4 * n4;
                BytecodeManager.incBytecodes(8);
                final double n6 = dcmpl(n5, 1.0);
                BytecodeManager.incBytecodes(4);
                if (n6 < 0) {
                    final double n7 = dcmpl(n5, 0.0);
                    BytecodeManager.incBytecodes(4);
                    if (n7 != 0) {
                        break;
                    }
                    continue;
                }
            }
            final double n8 = -2.0;
            final double n9 = n5;
            BytecodeManager.incBytecodes(3);
            final double n10 = n8 * StrictMath.log(n9) / n5;
            BytecodeManager.incBytecodes(4);
            final double sqrt = StrictMath.sqrt(n10);
            BytecodeManager.incBytecodes(1);
            this.nextNextGaussian = n4 * sqrt;
            BytecodeManager.incBytecodes(5);
            this.haveNextNextGaussian = true;
            BytecodeManager.incBytecodes(3);
            final double n11 = n2 * sqrt;
            BytecodeManager.incBytecodes(4);
            return n11;
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
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            final ObjectInputStream.GetField fields = objectInputStream.readFields();
            BytecodeManager.incBytecodes(1);
            final ObjectInputStream.GetField getField = fields;
            final String s = "seed";
            final long n = -1L;
            BytecodeManager.incBytecodes(4);
            final long value = getField.get(s, n);
            BytecodeManager.incBytecodes(1);
            final long n2 = lcmp(value, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                final String reason = "Random: invalid seed";
                BytecodeManager.incBytecodes(4);
                final StreamCorruptedException ex = new StreamCorruptedException(reason);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n3 = value;
            BytecodeManager.incBytecodes(3);
            this.resetSeed(n3);
            final ObjectInputStream.GetField getField2 = fields;
            final String s2 = "nextNextGaussian";
            final double n4 = 0.0;
            BytecodeManager.incBytecodes(5);
            this.nextNextGaussian = getField2.get(s2, n4);
            BytecodeManager.incBytecodes(1);
            final ObjectInputStream.GetField getField3 = fields;
            final String s3 = "haveNextNextGaussian";
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            this.haveNextNextGaussian = getField3.get(s3, b);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            BytecodeManager.incBytecodes(1);
            final ObjectOutputStream.PutField putField = putFields;
            final String s = "seed";
            final AtomicLong seed = this.seed;
            BytecodeManager.incBytecodes(5);
            final long value = seed.get();
            BytecodeManager.incBytecodes(1);
            putField.put(s, value);
            final ObjectOutputStream.PutField putField2 = putFields;
            final String s2 = "nextNextGaussian";
            final double nextNextGaussian = this.nextNextGaussian;
            BytecodeManager.incBytecodes(5);
            putField2.put(s2, nextNextGaussian);
            final ObjectOutputStream.PutField putField3 = putFields;
            final String s3 = "haveNextNextGaussian";
            final boolean haveNextNextGaussian = this.haveNextNextGaussian;
            BytecodeManager.incBytecodes(5);
            putField3.put(s3, haveNextNextGaussian);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.writeFields();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void resetSeed(final long n) {
        try {
            final Unsafe unsafe = Random.unsafe;
            final long seedOffset = Random.seedOffset;
            BytecodeManager.incBytecodes(7);
            final AtomicLong x = new AtomicLong(n);
            BytecodeManager.incBytecodes(1);
            unsafe.putObjectVolatile(this, seedOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ldc2_w          8682522807148012
        //     7: ldc             4
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLong.<init>:(J)V
        //    15: putstatic       instrumented/java/util/Random.seedUniquifier:Linstrumented/java/util/concurrent/atomic/AtomicLong;
        //    18: ldc             1
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: iconst_3       
        //    24: anewarray       Ljava/io/ObjectStreamField;
        //    27: dup            
        //    28: iconst_0       
        //    29: new             Ljava/io/ObjectStreamField;
        //    32: dup            
        //    33: ldc_w           "seed"
        //    36: getstatic       java/lang/Long.TYPE:Ljava/lang/Class;
        //    39: ldc             8
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //    47: aastore        
        //    48: dup            
        //    49: iconst_1       
        //    50: new             Ljava/io/ObjectStreamField;
        //    53: dup            
        //    54: ldc_w           "nextNextGaussian"
        //    57: getstatic       java/lang/Double.TYPE:Ljava/lang/Class;
        //    60: ldc             8
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //    68: aastore        
        //    69: dup            
        //    70: iconst_2       
        //    71: new             Ljava/io/ObjectStreamField;
        //    74: dup            
        //    75: ldc_w           "haveNextNextGaussian"
        //    78: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
        //    81: ldc             8
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //    89: aastore        
        //    90: putstatic       instrumented/java/util/Random.serialPersistentFields:[Ljava/io/ObjectStreamField;
        //    93: ldc             2
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //   106: putstatic       instrumented/java/util/Random.unsafe:Lsun/misc/Unsafe;
        //   109: ldc             1
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: getstatic       instrumented/java/util/Random.unsafe:Lsun/misc/Unsafe;
        //   117: ldc             Linstrumented/java/util/Random;.class
        //   119: ldc_w           "seed"
        //   122: ldc             3
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   143: putstatic       instrumented/java/util/Random.seedOffset:J
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: goto            180
        //   159: astore_0       
        //   160: new             Ljava/lang/Error;
        //   163: dup            
        //   164: aload_0        
        //   165: ldc_w           505
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   174: ldc             1
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: athrow         
        //   180: ldc             1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: return         
        //   186: athrow         
        //   187: athrow         
        //    StackMapTable: 00 04 F7 00 9F 07 01 3C 14 FF 00 05 00 00 00 01 07 00 62 FF 00 00 00 00 00 01 07 01 3A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  114    187    187    188    Ljava/lang/VirtualMachineError;
        //  114    151    159    180    Ljava/lang/Exception;
        //  0      186    186    187    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0180:
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
    
    static final class RandomIntsSpliterator implements Spliterator.OfInt
    {
        final Random rng;
        long index;
        final long fence;
        final int origin;
        final int bound;
        
        RandomIntsSpliterator(final Random rng, final long index, final long fence, final int origin, final int bound) {
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
                    final Random rng;
                    final long n3;
                    final long index2;
                    final int origin;
                    final int bound;
                    randomIntsSpliterator = new RandomIntsSpliterator(rng, n3, index2, origin, bound);
                    rng = this.rng;
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(14);
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
                    final Random rng = this.rng;
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
                    final Random rng = this.rng;
                    BytecodeManager.incBytecodes(3);
                    final int origin = this.origin;
                    final int bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    long n2;
                    do {
                        final Random random = rng;
                        final int n3 = origin;
                        final int n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final int internalNextInt = random.internalNextInt(n3, n4);
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
        final Random rng;
        long index;
        final long fence;
        final long origin;
        final long bound;
        
        RandomLongsSpliterator(final Random rng, final long index, final long fence, final long origin, final long bound) {
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
                    final Random rng;
                    final long n3;
                    final long index2;
                    final long origin;
                    final long bound;
                    randomLongsSpliterator = new RandomLongsSpliterator(rng, n3, index2, origin, bound);
                    rng = this.rng;
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(14);
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
                    final Random rng = this.rng;
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
                    final Random rng = this.rng;
                    BytecodeManager.incBytecodes(3);
                    final long origin = this.origin;
                    final long bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    long n2;
                    do {
                        final Random random = rng;
                        final long n3 = origin;
                        final long n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final long internalNextLong = random.internalNextLong(n3, n4);
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
        final Random rng;
        long index;
        final long fence;
        final double origin;
        final double bound;
        
        RandomDoublesSpliterator(final Random rng, final long index, final long fence, final double origin, final double bound) {
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
                    final Random rng;
                    final long n3;
                    final long index2;
                    final double origin;
                    final double bound;
                    randomDoublesSpliterator = new RandomDoublesSpliterator(rng, n3, index2, origin, bound);
                    rng = this.rng;
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(14);
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
                    final Random rng = this.rng;
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
                    final Random rng = this.rng;
                    BytecodeManager.incBytecodes(3);
                    final double origin = this.origin;
                    final double bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    long n2;
                    do {
                        final Random random = rng;
                        final double n3 = origin;
                        final double n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final double internalNextDouble = random.internalNextDouble(n3, n4);
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
