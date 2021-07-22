// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.stream.DoubleStream;
import instrumented.java.util.stream.LongStream;
import instrumented.java.util.Spliterator;
import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.stream.IntStream;
import java.security.SecureRandom;
import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.ObjectStreamField;
import instrumented.java.util.concurrent.atomic.AtomicLong;
import instrumented.java.util.concurrent.atomic.AtomicInteger;
import instrumented.java.util.Random;

public class ThreadLocalRandom extends Random
{
    private static final AtomicInteger probeGenerator;
    private static final AtomicLong seeder;
    private static final long GAMMA = -7046029254386353131L;
    private static final int PROBE_INCREMENT = -1640531527;
    private static final long SEEDER_INCREMENT = -4942790177534073029L;
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16;
    private static final float FLOAT_UNIT = 5.9604645E-8f;
    private static final ThreadLocal<Double> nextLocalGaussian;
    boolean initialized;
    static final ThreadLocalRandom instance;
    static final String BadBound = "bound must be positive";
    static final String BadRange = "bound must be greater than origin";
    static final String BadSize = "size must be non-negative";
    private static final long serialVersionUID = -5851777807851030925L;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final Unsafe UNSAFE;
    private static final long SEED;
    private static final long PROBE;
    private static final long SECONDARY;
    
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
    
    private static long mix64(long n) {
        try {
            n = (n ^ n >>> 33) * -49064778989728563L;
            BytecodeManager.incBytecodes(8);
            n = (n ^ n >>> 33) * -4265267296055464877L;
            BytecodeManager.incBytecodes(8);
            final long n2 = n ^ n >>> 33;
            BytecodeManager.incBytecodes(6);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int mix32(long n) {
        try {
            n = (n ^ n >>> 33) * -49064778989728563L;
            BytecodeManager.incBytecodes(8);
            final int n2 = (int)((n ^ n >>> 33) * -4265267296055464877L >>> 32);
            BytecodeManager.incBytecodes(11);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private ThreadLocalRandom() {
        try {
            BytecodeManager.incBytecodes(2);
            this.initialized = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final void localInit() {
        try {
            final AtomicInteger probeGenerator = ThreadLocalRandom.probeGenerator;
            final int n = -1640531527;
            BytecodeManager.incBytecodes(3);
            final int addAndGet = probeGenerator.addAndGet(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = addAndGet;
            BytecodeManager.incBytecodes(2);
            int n3;
            if (n2 == 0) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = addAndGet;
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            final AtomicLong seeder = ThreadLocalRandom.seeder;
            final long n5 = -4942790177534073029L;
            BytecodeManager.incBytecodes(3);
            final long andAdd = seeder.getAndAdd(n5);
            BytecodeManager.incBytecodes(1);
            final long mix64 = mix64(andAdd);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe = ThreadLocalRandom.UNSAFE;
            final Thread o = currentThread;
            final long seed = ThreadLocalRandom.SEED;
            final long x = mix64;
            BytecodeManager.incBytecodes(5);
            unsafe.putLong(o, seed, x);
            final Unsafe unsafe2 = ThreadLocalRandom.UNSAFE;
            final Thread o2 = currentThread;
            final long probe = ThreadLocalRandom.PROBE;
            final int x2 = n4;
            BytecodeManager.incBytecodes(5);
            unsafe2.putInt(o2, probe, x2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static ThreadLocalRandom current() {
        try {
            final Unsafe unsafe = ThreadLocalRandom.UNSAFE;
            BytecodeManager.incBytecodes(2);
            final Thread currentThread = Thread.currentThread();
            final long probe = ThreadLocalRandom.PROBE;
            BytecodeManager.incBytecodes(2);
            final int int1 = unsafe.getInt(currentThread, probe);
            BytecodeManager.incBytecodes(1);
            if (int1 == 0) {
                BytecodeManager.incBytecodes(1);
                localInit();
            }
            final ThreadLocalRandom instance = ThreadLocalRandom.instance;
            BytecodeManager.incBytecodes(2);
            return instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void setSeed(final long n) {
        try {
            final boolean initialized = this.initialized;
            BytecodeManager.incBytecodes(3);
            if (initialized) {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final long nextSeed() {
        try {
            final Unsafe unsafe = ThreadLocalRandom.UNSAFE;
            BytecodeManager.incBytecodes(2);
            final Thread currentThread = Thread.currentThread();
            final long seed = ThreadLocalRandom.SEED;
            final Unsafe unsafe2 = ThreadLocalRandom.UNSAFE;
            final Thread o = currentThread;
            final long seed2 = ThreadLocalRandom.SEED;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final long x = unsafe2.getLong(o, seed2) - 7046029254386353131L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            unsafe.putLong(currentThread, seed, x);
            final long n = x;
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected int next(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final int n2 = (int)(mix64(nextSeed) >>> 64 - n);
            BytecodeManager.incBytecodes(6);
            return n2;
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
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
    public float nextFloat() {
        try {
            BytecodeManager.incBytecodes(2);
            final long nextSeed = this.nextSeed();
            BytecodeManager.incBytecodes(1);
            final float n = (mix32(nextSeed) >>> 8) * 5.9604645E-8f;
            BytecodeManager.incBytecodes(6);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public double nextGaussian() {
        try {
            final ThreadLocal<Double> nextLocalGaussian = ThreadLocalRandom.nextLocalGaussian;
            BytecodeManager.incBytecodes(2);
            final Double n = nextLocalGaussian.get();
            BytecodeManager.incBytecodes(2);
            final Double n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 != null) {
                final ThreadLocal<Double> nextLocalGaussian2 = ThreadLocalRandom.nextLocalGaussian;
                final Double value = null;
                BytecodeManager.incBytecodes(3);
                nextLocalGaussian2.set(value);
                final Double n3 = n;
                BytecodeManager.incBytecodes(2);
                final double doubleValue = n3;
                BytecodeManager.incBytecodes(1);
                return doubleValue;
            }
            double n5;
            double n7;
            double n8;
            while (true) {
                final double n4 = 2.0;
                BytecodeManager.incBytecodes(3);
                n5 = n4 * this.nextDouble() - 1.0;
                BytecodeManager.incBytecodes(4);
                final double n6 = 2.0;
                BytecodeManager.incBytecodes(3);
                n7 = n6 * this.nextDouble() - 1.0;
                BytecodeManager.incBytecodes(4);
                n8 = n5 * n5 + n7 * n7;
                BytecodeManager.incBytecodes(8);
                final double n9 = dcmpl(n8, 1.0);
                BytecodeManager.incBytecodes(4);
                if (n9 < 0) {
                    final double n10 = dcmpl(n8, 0.0);
                    BytecodeManager.incBytecodes(4);
                    if (n10 != 0) {
                        break;
                    }
                    continue;
                }
            }
            final double n11 = -2.0;
            final double n12 = n8;
            BytecodeManager.incBytecodes(3);
            final double n13 = n11 * StrictMath.log(n12) / n8;
            BytecodeManager.incBytecodes(4);
            final double sqrt = StrictMath.sqrt(n13);
            BytecodeManager.incBytecodes(1);
            final ThreadLocal<Double> nextLocalGaussian3 = ThreadLocalRandom.nextLocalGaussian;
            final double value2 = n7 * sqrt;
            BytecodeManager.incBytecodes(7);
            final Double value3 = new Double(value2);
            BytecodeManager.incBytecodes(1);
            nextLocalGaussian3.set(value3);
            final double n14 = n5 * sqrt;
            BytecodeManager.incBytecodes(4);
            return n14;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(n3, n, n4, n5);
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
    
    @Override
    public IntStream ints() {
        try {
            final long n = 0L;
            final long n2 = Long.MAX_VALUE;
            final int n3 = Integer.MAX_VALUE;
            final int n4 = 0;
            BytecodeManager.incBytecodes(7);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(n, n2, n3, n4);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(n5, n, n2, n3);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomIntsSpliterator randomIntsSpliterator = new RandomIntsSpliterator(n3, n4, n, n2);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(n3, n, n4, n5);
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
    
    @Override
    public LongStream longs() {
        try {
            final long n = 0L;
            final long n2 = Long.MAX_VALUE;
            final long n3 = Long.MAX_VALUE;
            final long n4 = 0L;
            BytecodeManager.incBytecodes(7);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(n, n2, n3, n4);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(n6, n, n2, n3);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomLongsSpliterator randomLongsSpliterator = new RandomLongsSpliterator(n4, n5, n, n2);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(n3, n, n4, n5);
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
    
    @Override
    public DoubleStream doubles() {
        try {
            final long n = 0L;
            final long n2 = Long.MAX_VALUE;
            final double n3 = Double.MAX_VALUE;
            final double n4 = 0.0;
            BytecodeManager.incBytecodes(7);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(n, n2, n3, n4);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(n6, n, n2, n3);
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
    
    @Override
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
            BytecodeManager.incBytecodes(7);
            final RandomDoublesSpliterator randomDoublesSpliterator = new RandomDoublesSpliterator(n4, n5, n, n2);
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
    
    static final int getProbe() {
        try {
            final Unsafe unsafe = ThreadLocalRandom.UNSAFE;
            BytecodeManager.incBytecodes(2);
            final Thread currentThread = Thread.currentThread();
            final long probe = ThreadLocalRandom.PROBE;
            BytecodeManager.incBytecodes(2);
            final int int1 = unsafe.getInt(currentThread, probe);
            BytecodeManager.incBytecodes(1);
            return int1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int advanceProbe(int n) {
        try {
            n ^= n << 13;
            BytecodeManager.incBytecodes(6);
            n ^= n >>> 17;
            BytecodeManager.incBytecodes(6);
            n ^= n << 5;
            BytecodeManager.incBytecodes(6);
            final Unsafe unsafe = ThreadLocalRandom.UNSAFE;
            BytecodeManager.incBytecodes(2);
            final Thread currentThread = Thread.currentThread();
            final long probe = ThreadLocalRandom.PROBE;
            final int x = n;
            BytecodeManager.incBytecodes(3);
            unsafe.putInt(currentThread, probe, x);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int nextSecondarySeed() {
        try {
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe = ThreadLocalRandom.UNSAFE;
            final Thread o = currentThread;
            final long secondary = ThreadLocalRandom.SECONDARY;
            BytecodeManager.incBytecodes(4);
            final int int1;
            final int n = int1 = unsafe.getInt(o, secondary);
            BytecodeManager.incBytecodes(3);
            int n4;
            if (n != 0) {
                final int n2 = int1 ^ int1 << 13;
                BytecodeManager.incBytecodes(6);
                final int n3 = n2 ^ n2 >>> 17;
                BytecodeManager.incBytecodes(6);
                n4 = (n3 ^ n3 << 5);
                BytecodeManager.incBytecodes(7);
            }
            else {
                BytecodeManager.incBytecodes(1);
                localInit();
                final Unsafe unsafe2 = ThreadLocalRandom.UNSAFE;
                final Thread o2 = currentThread;
                final long seed = ThreadLocalRandom.SEED;
                BytecodeManager.incBytecodes(4);
                final int n5 = n4 = (int)unsafe2.getLong(o2, seed);
                BytecodeManager.incBytecodes(4);
                if (n5 == 0) {
                    n4 = 1;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final Unsafe unsafe3 = ThreadLocalRandom.UNSAFE;
            final Thread o3 = currentThread;
            final long secondary2 = ThreadLocalRandom.SECONDARY;
            final int x = n4;
            BytecodeManager.incBytecodes(5);
            unsafe3.putInt(o3, secondary2, x);
            final int n6 = n4;
            BytecodeManager.incBytecodes(2);
            return n6;
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
            final String s = "rnd";
            final Unsafe unsafe = ThreadLocalRandom.UNSAFE;
            BytecodeManager.incBytecodes(4);
            final Thread currentThread = Thread.currentThread();
            final long seed = ThreadLocalRandom.SEED;
            BytecodeManager.incBytecodes(2);
            final long long1 = unsafe.getLong(currentThread, seed);
            BytecodeManager.incBytecodes(1);
            putField.put(s, long1);
            final ObjectOutputStream.PutField putField2 = putFields;
            final String s2 = "initialized";
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            putField2.put(s2, b);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.writeFields();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Object readResolve() {
        try {
            BytecodeManager.incBytecodes(1);
            final ThreadLocalRandom current = current();
            BytecodeManager.incBytecodes(1);
            return current;
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
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokespecial   instrumented/java/util/concurrent/atomic/AtomicInteger.<init>:()V
        //    12: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.probeGenerator:Linstrumented/java/util/concurrent/atomic/AtomicInteger;
        //    15: ldc             1
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: new             Linstrumented/java/util/concurrent/atomic/AtomicLong;
        //    23: dup            
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.initialSeed:()J
        //    32: ldc             1
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLong.<init>:(J)V
        //    40: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.seeder:Linstrumented/java/util/concurrent/atomic/AtomicLong;
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: new             Ljava/lang/ThreadLocal;
        //    51: dup            
        //    52: ldc             3
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokespecial   java/lang/ThreadLocal.<init>:()V
        //    60: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.nextLocalGaussian:Ljava/lang/ThreadLocal;
        //    63: ldc             1
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: new             Linstrumented/java/util/concurrent/ThreadLocalRandom;
        //    71: dup            
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokespecial   instrumented/java/util/concurrent/ThreadLocalRandom.<init>:()V
        //    80: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.instance:Linstrumented/java/util/concurrent/ThreadLocalRandom;
        //    83: ldc             1
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: iconst_2       
        //    89: anewarray       Ljava/io/ObjectStreamField;
        //    92: dup            
        //    93: iconst_0       
        //    94: new             Ljava/io/ObjectStreamField;
        //    97: dup            
        //    98: ldc_w           "rnd"
        //   101: getstatic       java/lang/Long.TYPE:Ljava/lang/Class;
        //   104: ldc             8
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //   112: aastore        
        //   113: dup            
        //   114: iconst_1       
        //   115: new             Ljava/io/ObjectStreamField;
        //   118: dup            
        //   119: ldc_w           "initialized"
        //   122: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
        //   125: ldc             8
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //   133: aastore        
        //   134: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.serialPersistentFields:[Ljava/io/ObjectStreamField;
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ldc             1
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //   150: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.UNSAFE:Lsun/misc/Unsafe;
        //   153: ldc             1
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: ldc             Ljava/lang/Thread;.class
        //   160: astore_0       
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: getstatic       instrumented/java/util/concurrent/ThreadLocalRandom.UNSAFE:Lsun/misc/Unsafe;
        //   169: aload_0        
        //   170: ldc_w           "threadLocalRandomSeed"
        //   173: ldc             3
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: ldc             1
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   186: ldc             1
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   194: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.SEED:J
        //   197: ldc             1
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: getstatic       instrumented/java/util/concurrent/ThreadLocalRandom.UNSAFE:Lsun/misc/Unsafe;
        //   205: aload_0        
        //   206: ldc_w           "threadLocalRandomProbe"
        //   209: ldc             3
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: ldc             1
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   222: ldc             1
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   230: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.PROBE:J
        //   233: ldc             1
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: getstatic       instrumented/java/util/concurrent/ThreadLocalRandom.UNSAFE:Lsun/misc/Unsafe;
        //   241: aload_0        
        //   242: ldc_w           "threadLocalRandomSecondarySeed"
        //   245: ldc             3
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: ldc             1
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   258: ldc             1
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   266: putstatic       instrumented/java/util/concurrent/ThreadLocalRandom.SECONDARY:J
        //   269: ldc             1
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: ldc             1
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: goto            308
        //   282: astore_0       
        //   283: ldc_w           501
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: new             Ljava/lang/Error;
        //   292: dup            
        //   293: aload_0        
        //   294: ldc             4
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   302: ldc             1
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: athrow         
        //   308: ldc             1
        //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   313: return         
        //   314: athrow         
        //   315: athrow         
        //    StackMapTable: 00 04 F7 01 1A 07 01 6C 19 FF 00 05 00 00 00 01 07 00 8A FF 00 00 00 00 00 01 07 01 6A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  142    315    315    316    Ljava/lang/VirtualMachineError;
        //  142    274    282    308    Ljava/lang/Exception;
        //  0      314    314    315    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0308:
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
        long index;
        final long fence;
        final int origin;
        final int bound;
        
        RandomIntsSpliterator(final long index, final long fence, final int origin, final int bound) {
            try {
                BytecodeManager.incBytecodes(2);
                this.index = index;
                this.fence = fence;
                BytecodeManager.incBytecodes(6);
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
                    final long n3;
                    final long index2;
                    final int origin;
                    final int bound;
                    randomIntsSpliterator = new RandomIntsSpliterator(n3, index2, origin, bound);
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(12);
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
                    BytecodeManager.incBytecodes(2);
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    final int origin = this.origin;
                    final int bound = this.bound;
                    BytecodeManager.incBytecodes(5);
                    final int internalNextInt = current.internalNextInt(origin, bound);
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
                    final int origin = this.origin;
                    final int bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    BytecodeManager.incBytecodes(1);
                    long n2;
                    do {
                        final ThreadLocalRandom threadLocalRandom = current;
                        final int n3 = origin;
                        final int n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final int internalNextInt = threadLocalRandom.internalNextInt(n3, n4);
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
        long index;
        final long fence;
        final long origin;
        final long bound;
        
        RandomLongsSpliterator(final long index, final long fence, final long origin, final long bound) {
            try {
                BytecodeManager.incBytecodes(2);
                this.index = index;
                this.fence = fence;
                BytecodeManager.incBytecodes(6);
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
                    final long n3;
                    final long index2;
                    final long origin;
                    final long bound;
                    randomLongsSpliterator = new RandomLongsSpliterator(n3, index2, origin, bound);
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(12);
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
                    BytecodeManager.incBytecodes(2);
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    final long origin = this.origin;
                    final long bound = this.bound;
                    BytecodeManager.incBytecodes(5);
                    final long internalNextLong = current.internalNextLong(origin, bound);
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
                    final long origin = this.origin;
                    final long bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    BytecodeManager.incBytecodes(1);
                    long n2;
                    do {
                        final ThreadLocalRandom threadLocalRandom = current;
                        final long n3 = origin;
                        final long n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final long internalNextLong = threadLocalRandom.internalNextLong(n3, n4);
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
        long index;
        final long fence;
        final double origin;
        final double bound;
        
        RandomDoublesSpliterator(final long index, final long fence, final double origin, final double bound) {
            try {
                BytecodeManager.incBytecodes(2);
                this.index = index;
                this.fence = fence;
                BytecodeManager.incBytecodes(6);
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
                    final long n3;
                    final long index2;
                    final double origin;
                    final double bound;
                    randomDoublesSpliterator = new RandomDoublesSpliterator(n3, index2, origin, bound);
                    n3 = index;
                    index2 = n;
                    this.index = index2;
                    origin = this.origin;
                    bound = this.bound;
                    BytecodeManager.incBytecodes(12);
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
                    BytecodeManager.incBytecodes(2);
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    final double origin = this.origin;
                    final double bound = this.bound;
                    BytecodeManager.incBytecodes(5);
                    final double internalNextDouble = current.internalNextDouble(origin, bound);
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
                    final double origin = this.origin;
                    final double bound = this.bound;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    BytecodeManager.incBytecodes(1);
                    long n2;
                    do {
                        final ThreadLocalRandom threadLocalRandom = current;
                        final double n3 = origin;
                        final double n4 = bound;
                        BytecodeManager.incBytecodes(5);
                        final double internalNextDouble = threadLocalRandom.internalNextDouble(n3, n4);
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
