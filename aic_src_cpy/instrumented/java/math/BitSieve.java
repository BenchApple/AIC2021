// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.math;

import instrumented.java.util.Random;
import aic2021.engine.BytecodeManager;

class BitSieve
{
    private long[] bits;
    private int length;
    private static BitSieve smallSieve;
    
    private BitSieve() {
        try {
            BytecodeManager.incBytecodes(2);
            this.length = 9600;
            BytecodeManager.incBytecodes(3);
            final int n = this.length - 1;
            BytecodeManager.incBytecodes(6);
            this.bits = new long[unitIndex(n) + 1];
            BytecodeManager.incBytecodes(3);
            final int n2 = 0;
            BytecodeManager.incBytecodes(3);
            this.set(n2);
            int sieveSearch = 1;
            BytecodeManager.incBytecodes(2);
            int n3 = 3;
            BytecodeManager.incBytecodes(2);
            int i;
            int length;
            do {
                final int length2 = this.length;
                final int n4 = sieveSearch + n3;
                final int n5 = n3;
                BytecodeManager.incBytecodes(8);
                this.sieveSingle(length2, n4, n5);
                final int length3 = this.length;
                final int n6 = sieveSearch + 1;
                BytecodeManager.incBytecodes(7);
                sieveSearch = this.sieveSearch(length3, n6);
                BytecodeManager.incBytecodes(1);
                n3 = 2 * sieveSearch + 1;
                BytecodeManager.incBytecodes(6);
                final int n7 = sieveSearch;
                BytecodeManager.incBytecodes(2);
                if (n7 <= 0) {
                    break;
                }
                i = n3;
                length = this.length;
                BytecodeManager.incBytecodes(4);
            } while (i < length);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BitSieve(final BigInteger bigInteger, final int length) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = length - 1;
            BytecodeManager.incBytecodes(5);
            this.bits = new long[unitIndex(n) + 1];
            BytecodeManager.incBytecodes(3);
            this.length = length;
            BytecodeManager.incBytecodes(3);
            final int n2 = 0;
            BytecodeManager.incBytecodes(2);
            final BitSieve smallSieve = BitSieve.smallSieve;
            final int length2 = BitSieve.smallSieve.length;
            final int n3 = n2;
            BytecodeManager.incBytecodes(5);
            int n4 = smallSieve.sieveSearch(length2, n3);
            BytecodeManager.incBytecodes(1);
            int n5 = n4 * 2 + 1;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(bigInteger);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            int i;
            do {
                final MutableBigInteger mutableBigInteger3 = mutableBigInteger;
                final int n6 = n5;
                final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
                BytecodeManager.incBytecodes(4);
                final int divideOneWord = mutableBigInteger3.divideOneWord(n6, mutableBigInteger4);
                BytecodeManager.incBytecodes(1);
                int n7 = n5 - divideOneWord;
                BytecodeManager.incBytecodes(4);
                final int n8 = n7 % 2;
                BytecodeManager.incBytecodes(4);
                if (n8 == 0) {
                    n7 += n5;
                    BytecodeManager.incBytecodes(4);
                }
                final int n9 = (n7 - 1) / 2;
                final int n10 = n5;
                BytecodeManager.incBytecodes(9);
                this.sieveSingle(length, n9, n10);
                final BitSieve smallSieve2 = BitSieve.smallSieve;
                final int length3 = BitSieve.smallSieve.length;
                final int n11 = n4 + 1;
                BytecodeManager.incBytecodes(7);
                n4 = smallSieve2.sieveSearch(length3, n11);
                BytecodeManager.incBytecodes(1);
                n5 = n4 * 2 + 1;
                BytecodeManager.incBytecodes(6);
                i = n4;
                BytecodeManager.incBytecodes(2);
            } while (i > 0);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int unitIndex(final int n) {
        try {
            final int n2 = n >>> 6;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long bit(final int n) {
        try {
            final long n2 = 1L << (n & 0x3F);
            BytecodeManager.incBytecodes(6);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean get(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int unitIndex = unitIndex(n);
            BytecodeManager.incBytecodes(1);
            final long n2 = this.bits[unitIndex];
            BytecodeManager.incBytecodes(6);
            final long n3 = lcmp(n2 & bit(n), 0L);
            BytecodeManager.incBytecodes(4);
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
    
    private void set(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int unitIndex = unitIndex(n);
            BytecodeManager.incBytecodes(1);
            final long[] bits = this.bits;
            final int n2 = unitIndex;
            final long n3 = bits[n2];
            BytecodeManager.incBytecodes(7);
            bits[n2] = (n3 | bit(n));
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int sieveSearch(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n2 >= n) {
                final int n3 = -1;
                BytecodeManager.incBytecodes(2);
                return n3;
            }
            int n4 = n2;
            BytecodeManager.incBytecodes(2);
            int i;
            int n5;
            do {
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                final boolean value = this.get(n6);
                BytecodeManager.incBytecodes(1);
                if (!value) {
                    final int n7 = n4;
                    BytecodeManager.incBytecodes(2);
                    return n7;
                }
                ++n4;
                BytecodeManager.incBytecodes(1);
                i = n4;
                n5 = n - 1;
                BytecodeManager.incBytecodes(5);
            } while (i < n5);
            final int n8 = -1;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void sieveSingle(final int n, int n2, final int n3) {
        try {
            while (true) {
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n) {
                    break;
                }
                final int n5 = n2;
                BytecodeManager.incBytecodes(3);
                this.set(n5);
                n2 += n3;
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BigInteger retrieve(final BigInteger bigInteger, final int n, final Random random) {
        try {
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length = this.bits.length;
                BytecodeManager.incBytecodes(5);
                if (n4 >= length) {
                    final BigInteger bigInteger2 = null;
                    BytecodeManager.incBytecodes(2);
                    return bigInteger2;
                }
                long n5 = ~this.bits[n3];
                BytecodeManager.incBytecodes(7);
                int n6 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    final int n8 = 64;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                        break;
                    }
                    final long n9 = lcmp(n5 & 0x1L, 1L);
                    BytecodeManager.incBytecodes(6);
                    if (n9 == 0) {
                        final long n10 = n2;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger value = BigInteger.valueOf(n10);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger add = bigInteger.add(value);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger3 = add;
                        BytecodeManager.incBytecodes(4);
                        final boolean primeToCertainty = bigInteger3.primeToCertainty(n, random);
                        BytecodeManager.incBytecodes(1);
                        if (primeToCertainty) {
                            final BigInteger bigInteger4 = add;
                            BytecodeManager.incBytecodes(2);
                            return bigInteger4;
                        }
                    }
                    n5 >>>= 1;
                    BytecodeManager.incBytecodes(4);
                    n2 += 2;
                    BytecodeManager.incBytecodes(1);
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            BitSieve.smallSieve = new BitSieve();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
