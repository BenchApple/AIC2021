// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.math;

import instrumented.java.util.Arrays;
import aic2021.engine.BytecodeManager;

class MutableBigInteger
{
    int[] value;
    int intLen;
    int offset;
    static final MutableBigInteger ONE;
    static final int KNUTH_POW2_THRESH_LEN = 6;
    static final int KNUTH_POW2_THRESH_ZEROS = 3;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    MutableBigInteger() {
        try {
            BytecodeManager.incBytecodes(2);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            this.value = new int[1];
            BytecodeManager.incBytecodes(3);
            this.intLen = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            this.value = new int[1];
            BytecodeManager.incBytecodes(3);
            this.intLen = 1;
            BytecodeManager.incBytecodes(3);
            this.value[0] = n;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger(final int[] value) {
        try {
            BytecodeManager.incBytecodes(2);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            this.value = value;
            BytecodeManager.incBytecodes(3);
            this.intLen = value.length;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger(final BigInteger bigInteger) {
        try {
            BytecodeManager.incBytecodes(2);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            this.intLen = bigInteger.mag.length;
            BytecodeManager.incBytecodes(5);
            final int[] mag = bigInteger.mag;
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(6);
            this.value = Arrays.copyOf(mag, intLen);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger(final MutableBigInteger mutableBigInteger) {
        try {
            BytecodeManager.incBytecodes(2);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            this.intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(4);
            final int[] value = mutableBigInteger.value;
            final int offset = mutableBigInteger.offset;
            final int n = mutableBigInteger.offset + this.intLen;
            BytecodeManager.incBytecodes(11);
            this.value = Arrays.copyOfRange(value, offset, n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ones(final int intLen) {
        try {
            final int length = this.value.length;
            BytecodeManager.incBytecodes(5);
            if (intLen > length) {
                this.value = new int[intLen];
                BytecodeManager.incBytecodes(3);
            }
            final int[] value = this.value;
            final int n = -1;
            BytecodeManager.incBytecodes(4);
            Arrays.fill(value, n);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            this.intLen = intLen;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int[] getMagnitudeArray() {
        try {
            final int offset = this.offset;
            BytecodeManager.incBytecodes(3);
            if (offset <= 0) {
                final int length = this.value.length;
                final int intLen = this.intLen;
                BytecodeManager.incBytecodes(6);
                if (length == intLen) {
                    final int[] value = this.value;
                    BytecodeManager.incBytecodes(3);
                    return value;
                }
            }
            final int[] value2 = this.value;
            final int offset2 = this.offset;
            final int n = this.offset + this.intLen;
            BytecodeManager.incBytecodes(10);
            final int[] copyOfRange = Arrays.copyOfRange(value2, offset2, n);
            BytecodeManager.incBytecodes(1);
            return copyOfRange;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long toLong() {
        try {
            final boolean $assertionsDisabled = MutableBigInteger.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int intLen = this.intLen;
                final int n = 2;
                BytecodeManager.incBytecodes(4);
                if (intLen > n) {
                    final String detailMessage = "this MutableBigInteger exceeds the range of long";
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int intLen2 = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen2 == 0) {
                final long n2 = 0L;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final long n3 = (long)this.value[this.offset] & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(9);
            final int intLen3 = this.intLen;
            final int n4 = 2;
            BytecodeManager.incBytecodes(4);
            long n5;
            if (intLen3 == n4) {
                n5 = (n3 << 32 | ((long)this.value[this.offset + 1] & 0xFFFFFFFFL));
                BytecodeManager.incBytecodes(15);
            }
            else {
                n5 = n3;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BigInteger toBigInteger(final int n) {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen != 0) {
                BytecodeManager.incBytecodes(2);
                if (n != 0) {
                    BytecodeManager.incBytecodes(4);
                    final int[] magnitudeArray = this.getMagnitudeArray();
                    BytecodeManager.incBytecodes(2);
                    final BigInteger bigInteger = new BigInteger(magnitudeArray, n);
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
    
    BigInteger toBigInteger() {
        try {
            BytecodeManager.incBytecodes(2);
            this.normalize();
            BytecodeManager.incBytecodes(3);
            final boolean zero = this.isZero();
            BytecodeManager.incBytecodes(1);
            int n;
            if (zero) {
                n = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 1;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger = this.toBigInteger(n);
            BytecodeManager.incBytecodes(1);
            return bigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    BigDecimal toBigDecimal(final int n, final int n2) {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen != 0) {
                BytecodeManager.incBytecodes(2);
                if (n != 0) {
                    BytecodeManager.incBytecodes(2);
                    final int[] magnitudeArray = this.getMagnitudeArray();
                    BytecodeManager.incBytecodes(1);
                    final int length = magnitudeArray.length;
                    BytecodeManager.incBytecodes(3);
                    final int n3 = magnitudeArray[0];
                    BytecodeManager.incBytecodes(4);
                    final int n4 = length;
                    final int n5 = 2;
                    BytecodeManager.incBytecodes(3);
                    Label_0102: {
                        if (n4 <= n5) {
                            final int n6 = n3;
                            BytecodeManager.incBytecodes(2);
                            if (n6 < 0) {
                                final int n7 = length;
                                final int n8 = 2;
                                BytecodeManager.incBytecodes(3);
                                if (n7 == n8) {
                                    break Label_0102;
                                }
                            }
                            final int n9 = length;
                            final int n10 = 2;
                            BytecodeManager.incBytecodes(3);
                            long n11;
                            if (n9 == n10) {
                                n11 = (((long)magnitudeArray[1] & 0xFFFFFFFFL) | ((long)n3 & 0xFFFFFFFFL) << 32);
                                BytecodeManager.incBytecodes(14);
                            }
                            else {
                                n11 = ((long)n3 & 0xFFFFFFFFL);
                                BytecodeManager.incBytecodes(4);
                            }
                            final long n12 = n11;
                            BytecodeManager.incBytecodes(1);
                            final int n13 = -1;
                            BytecodeManager.incBytecodes(3);
                            long n14;
                            if (n == n13) {
                                n14 = -n12;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                n14 = n12;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(2);
                            final BigDecimal value = BigDecimal.valueOf(n14, n2);
                            BytecodeManager.incBytecodes(1);
                            return value;
                        }
                    }
                    final int[] array = magnitudeArray;
                    BytecodeManager.incBytecodes(7);
                    final BigInteger bigInteger = new BigInteger(array, n);
                    final long n15 = Long.MIN_VALUE;
                    final int n16 = 0;
                    BytecodeManager.incBytecodes(4);
                    final BigDecimal bigDecimal = new BigDecimal(bigInteger, n15, n2, n16);
                    BytecodeManager.incBytecodes(1);
                    return bigDecimal;
                }
            }
            BytecodeManager.incBytecodes(2);
            final BigDecimal zeroValue = BigDecimal.zeroValueOf(n2);
            BytecodeManager.incBytecodes(1);
            return zeroValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    long toCompactValue(final int n) {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen != 0) {
                BytecodeManager.incBytecodes(2);
                if (n != 0) {
                    BytecodeManager.incBytecodes(2);
                    final int[] magnitudeArray = this.getMagnitudeArray();
                    BytecodeManager.incBytecodes(1);
                    final int length = magnitudeArray.length;
                    BytecodeManager.incBytecodes(3);
                    final int n2 = magnitudeArray[0];
                    BytecodeManager.incBytecodes(4);
                    final int n3 = length;
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(3);
                    Label_0091: {
                        if (n3 <= n4) {
                            final int n5 = n2;
                            BytecodeManager.incBytecodes(2);
                            if (n5 < 0) {
                                final int n6 = length;
                                final int n7 = 2;
                                BytecodeManager.incBytecodes(3);
                                if (n6 == n7) {
                                    break Label_0091;
                                }
                            }
                            final int n8 = length;
                            final int n9 = 2;
                            BytecodeManager.incBytecodes(3);
                            long n10;
                            if (n8 == n9) {
                                n10 = (((long)magnitudeArray[1] & 0xFFFFFFFFL) | ((long)n2 & 0xFFFFFFFFL) << 32);
                                BytecodeManager.incBytecodes(14);
                            }
                            else {
                                n10 = ((long)n2 & 0xFFFFFFFFL);
                                BytecodeManager.incBytecodes(4);
                            }
                            final long n11 = n10;
                            BytecodeManager.incBytecodes(1);
                            final int n12 = -1;
                            BytecodeManager.incBytecodes(3);
                            long n13;
                            if (n == n12) {
                                n13 = -n11;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                n13 = n11;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            return n13;
                        }
                    }
                    final long n14 = Long.MIN_VALUE;
                    BytecodeManager.incBytecodes(2);
                    return n14;
                }
            }
            final long n15 = 0L;
            BytecodeManager.incBytecodes(2);
            return n15;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void clear() {
        try {
            final int n = 0;
            this.intLen = n;
            this.offset = n;
            BytecodeManager.incBytecodes(6);
            int n2 = 0;
            final int length = this.value.length;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                this.value[n2] = 0;
                BytecodeManager.incBytecodes(5);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void reset() {
        try {
            final int n = 0;
            this.intLen = n;
            this.offset = n;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int compare(final MutableBigInteger mutableBigInteger) {
        try {
            final int intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen2 = this.intLen;
            final int n = intLen;
            BytecodeManager.incBytecodes(4);
            if (intLen2 < n) {
                final int n2 = -1;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final int intLen3 = this.intLen;
            final int n3 = intLen;
            BytecodeManager.incBytecodes(4);
            if (intLen3 > n3) {
                final int n4 = 1;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            final int[] value = mutableBigInteger.value;
            BytecodeManager.incBytecodes(3);
            int offset = this.offset;
            int offset2 = mutableBigInteger.offset;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n5 = offset;
                final int n6 = this.intLen + this.offset;
                BytecodeManager.incBytecodes(7);
                if (n5 >= n6) {
                    final int n7 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n7;
                }
                final int n8 = this.value[offset] + Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(7);
                final int n9 = value[offset2] + Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(6);
                final int n10 = n8;
                final int n11 = n9;
                BytecodeManager.incBytecodes(3);
                if (n10 < n11) {
                    final int n12 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n12;
                }
                final int n13 = n8;
                final int n14 = n9;
                BytecodeManager.incBytecodes(3);
                if (n13 > n14) {
                    final int n15 = 1;
                    BytecodeManager.incBytecodes(2);
                    return n15;
                }
                ++offset;
                ++offset2;
                BytecodeManager.incBytecodes(3);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int compareShifted(final MutableBigInteger mutableBigInteger, final int n) {
        try {
            final int intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int n2 = this.intLen - n;
            BytecodeManager.incBytecodes(5);
            final int n3 = n2;
            final int n4 = intLen;
            BytecodeManager.incBytecodes(3);
            if (n3 < n4) {
                final int n5 = -1;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            final int n6 = n2;
            final int n7 = intLen;
            BytecodeManager.incBytecodes(3);
            if (n6 > n7) {
                final int n8 = 1;
                BytecodeManager.incBytecodes(2);
                return n8;
            }
            final int[] value = mutableBigInteger.value;
            BytecodeManager.incBytecodes(3);
            int offset = this.offset;
            int offset2 = mutableBigInteger.offset;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n9 = offset;
                final int n10 = n2 + this.offset;
                BytecodeManager.incBytecodes(6);
                if (n9 >= n10) {
                    final int n11 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n11;
                }
                final int n12 = this.value[offset] + Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(7);
                final int n13 = value[offset2] + Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(6);
                final int n14 = n12;
                final int n15 = n13;
                BytecodeManager.incBytecodes(3);
                if (n14 < n15) {
                    final int n16 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n16;
                }
                final int n17 = n12;
                final int n18 = n13;
                BytecodeManager.incBytecodes(3);
                if (n17 > n18) {
                    final int n19 = 1;
                    BytecodeManager.incBytecodes(2);
                    return n19;
                }
                ++offset;
                ++offset2;
                BytecodeManager.incBytecodes(3);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int compareHalf(final MutableBigInteger mutableBigInteger) {
        try {
            final int intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen2 = this.intLen;
            BytecodeManager.incBytecodes(3);
            final int n = intLen2;
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                final int n2 = intLen;
                BytecodeManager.incBytecodes(2);
                int n3;
                if (n2 <= 0) {
                    n3 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n3;
            }
            final int n4 = intLen2;
            final int n5 = intLen;
            BytecodeManager.incBytecodes(3);
            if (n4 > n5) {
                final int n6 = 1;
                BytecodeManager.incBytecodes(2);
                return n6;
            }
            final int n7 = intLen2;
            final int n8 = intLen - 1;
            BytecodeManager.incBytecodes(5);
            if (n7 < n8) {
                final int n9 = -1;
                BytecodeManager.incBytecodes(2);
                return n9;
            }
            final int[] value = mutableBigInteger.value;
            BytecodeManager.incBytecodes(3);
            int n10 = 0;
            BytecodeManager.incBytecodes(2);
            int n11 = 0;
            BytecodeManager.incBytecodes(2);
            final int n12 = intLen2;
            final int n13 = intLen;
            BytecodeManager.incBytecodes(3);
            if (n12 != n13) {
                final int n14 = value[n10];
                final int n15 = 1;
                BytecodeManager.incBytecodes(5);
                if (n14 != n15) {
                    final int n16 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n16;
                }
                ++n10;
                BytecodeManager.incBytecodes(1);
                n11 = Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(3);
            }
            final int[] value2 = this.value;
            BytecodeManager.incBytecodes(3);
            int offset = this.offset;
            int n17 = n10;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n18 = offset;
                final int n19 = intLen2 + this.offset;
                BytecodeManager.incBytecodes(6);
                if (n18 >= n19) {
                    final int n20 = n11;
                    BytecodeManager.incBytecodes(2);
                    int n21;
                    if (n20 == 0) {
                        n21 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n21 = -1;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n21;
                }
                final int n22 = value[n17++];
                BytecodeManager.incBytecodes(5);
                final long n23 = (long)((n22 >>> 1) + n11) & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(9);
                final long n24 = (long)value2[offset++] & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(8);
                final long n25 = lcmp(n24, n23);
                BytecodeManager.incBytecodes(4);
                if (n25 != 0) {
                    final long n26 = lcmp(n24, n23);
                    BytecodeManager.incBytecodes(4);
                    int n27;
                    if (n26 < 0) {
                        n27 = -1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n27 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n27;
                }
                n11 = (n22 & 0x1) << 31;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final int getLowestSetBit() {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                final int n = -1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = this.intLen - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 <= 0) {
                    break;
                }
                final int n4 = this.value[n2 + this.offset];
                BytecodeManager.incBytecodes(8);
                if (n4 != 0) {
                    break;
                }
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = this.value[n2 + this.offset];
            BytecodeManager.incBytecodes(8);
            final int n6 = n5;
            BytecodeManager.incBytecodes(2);
            if (n6 == 0) {
                final int n7 = -1;
                BytecodeManager.incBytecodes(2);
                return n7;
            }
            final int n8 = this.intLen - 1 - n2 << 5;
            final int i = n5;
            BytecodeManager.incBytecodes(10);
            final int n9 = n8 + Integer.numberOfTrailingZeros(i);
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final int getInt(final int n) {
        try {
            final int n2 = this.value[this.offset + n];
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final long getLong(final int n) {
        try {
            final long n2 = (long)this.value[this.offset + n] & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(11);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void normalize() {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                this.offset = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            int offset = this.offset;
            BytecodeManager.incBytecodes(3);
            final int n = this.value[offset];
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n2 = offset + this.intLen;
            BytecodeManager.incBytecodes(5);
            int i;
            do {
                ++offset;
                BytecodeManager.incBytecodes(1);
                final int n3 = offset;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                i = this.value[offset];
                BytecodeManager.incBytecodes(5);
            } while (i == 0);
            final int n5 = offset - this.offset;
            BytecodeManager.incBytecodes(5);
            this.intLen -= n5;
            BytecodeManager.incBytecodes(6);
            final int intLen2 = this.intLen;
            BytecodeManager.incBytecodes(4);
            int offset2;
            if (intLen2 == 0) {
                offset2 = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                offset2 = this.offset + n5;
                BytecodeManager.incBytecodes(4);
            }
            this.offset = offset2;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final void ensureCapacity(final int intLen) {
        try {
            final int length = this.value.length;
            BytecodeManager.incBytecodes(5);
            if (length < intLen) {
                this.value = new int[intLen];
                BytecodeManager.incBytecodes(3);
                this.offset = 0;
                BytecodeManager.incBytecodes(3);
                this.intLen = intLen;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int[] toIntArray() {
        try {
            final int[] array = new int[this.intLen];
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int intLen = this.intLen;
                BytecodeManager.incBytecodes(4);
                if (n2 >= intLen) {
                    break;
                }
                array[n] = this.value[this.offset + n];
                BytecodeManager.incBytecodes(10);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void setInt(final int n, final int n2) {
        try {
            this.value[this.offset + n] = n2;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void setValue(final int[] value, final int intLen) {
        try {
            this.value = value;
            BytecodeManager.incBytecodes(3);
            this.intLen = intLen;
            BytecodeManager.incBytecodes(3);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void copyValue(final MutableBigInteger mutableBigInteger) {
        try {
            final int intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int length = this.value.length;
            final int n = intLen;
            BytecodeManager.incBytecodes(5);
            if (length < n) {
                this.value = new int[intLen];
                BytecodeManager.incBytecodes(3);
            }
            final int[] value = mutableBigInteger.value;
            final int offset = mutableBigInteger.offset;
            final int[] value2 = this.value;
            final int n2 = 0;
            final int n3 = intLen;
            BytecodeManager.incBytecodes(9);
            System.arraycopy(value, offset, value2, n2, n3);
            this.intLen = intLen;
            BytecodeManager.incBytecodes(3);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void copyValue(final int[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int length2 = this.value.length;
            final int n = length;
            BytecodeManager.incBytecodes(5);
            if (length2 < n) {
                this.value = new int[length];
                BytecodeManager.incBytecodes(3);
            }
            final int n2 = 0;
            final int[] value = this.value;
            final int n3 = 0;
            final int n4 = length;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(array, n2, value, n3, n4);
            this.intLen = length;
            BytecodeManager.incBytecodes(3);
            this.offset = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean isOne() {
        try {
            final int intLen = this.intLen;
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            boolean b = false;
            Label_0046: {
                if (intLen == n) {
                    final int n2 = this.value[this.offset];
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(7);
                    if (n2 == n3) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0046;
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
    
    boolean isZero() {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (intLen == 0) {
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
    
    boolean isEven() {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0053: {
                if (intLen != 0) {
                    final int n = this.value[this.offset + this.intLen - 1] & 0x1;
                    BytecodeManager.incBytecodes(13);
                    if (n != 0) {
                        b = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0053;
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
    
    boolean isOdd() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean zero = this.isZero();
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (zero) {
                b = false;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n = this.value[this.offset + this.intLen - 1] & 0x1;
                final int n2 = 1;
                BytecodeManager.incBytecodes(14);
                if (n == n2) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean isNormal() {
        try {
            final int n = this.intLen + this.offset;
            final int length = this.value.length;
            BytecodeManager.incBytecodes(9);
            if (n > length) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final int n2 = this.value[this.offset];
            BytecodeManager.incBytecodes(6);
            boolean b3;
            if (n2 != 0) {
                b3 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b3 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger = this.toBigInteger(n);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger2 = bigInteger;
            BytecodeManager.incBytecodes(2);
            final String string = bigInteger2.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void safeRightShift(final int n) {
        try {
            final int n2 = n / 32;
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(6);
            if (n2 >= intLen) {
                BytecodeManager.incBytecodes(2);
                this.reset();
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.rightShift(n);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void rightShift(final int n) {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(4);
            final int n3 = n & 0x1F;
            BytecodeManager.incBytecodes(4);
            this.intLen -= n2;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n5 = this.value[this.offset];
            BytecodeManager.incBytecodes(6);
            final int bitLengthForInt = BigInteger.bitLengthForInt(n5);
            BytecodeManager.incBytecodes(1);
            final int n6 = n3;
            final int n7 = bitLengthForInt;
            BytecodeManager.incBytecodes(3);
            if (n6 >= n7) {
                final int n8 = 32 - n3;
                BytecodeManager.incBytecodes(5);
                this.primitiveLeftShift(n8);
                --this.intLen;
                BytecodeManager.incBytecodes(7);
            }
            else {
                final int n9 = n3;
                BytecodeManager.incBytecodes(3);
                this.primitiveRightShift(n9);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void safeLeftShift(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                BytecodeManager.incBytecodes(3);
                this.leftShift(n);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void leftShift(final int n) {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n2 = n >>> 5;
            BytecodeManager.incBytecodes(4);
            final int n3 = n & 0x1F;
            BytecodeManager.incBytecodes(4);
            final int n4 = this.value[this.offset];
            BytecodeManager.incBytecodes(6);
            final int bitLengthForInt = BigInteger.bitLengthForInt(n4);
            BytecodeManager.incBytecodes(1);
            final int n5 = 32 - bitLengthForInt;
            BytecodeManager.incBytecodes(5);
            if (n <= n5) {
                final int n6 = n3;
                BytecodeManager.incBytecodes(3);
                this.primitiveLeftShift(n6);
                BytecodeManager.incBytecodes(1);
                return;
            }
            int intLen2 = this.intLen + n2 + 1;
            BytecodeManager.incBytecodes(7);
            final int n7 = n3;
            final int n8 = 32 - bitLengthForInt;
            BytecodeManager.incBytecodes(5);
            if (n7 <= n8) {
                --intLen2;
                BytecodeManager.incBytecodes(1);
            }
            final int length = this.value.length;
            final int n9 = intLen2;
            BytecodeManager.incBytecodes(5);
            if (length < n9) {
                final int[] array = new int[intLen2];
                BytecodeManager.incBytecodes(2);
                int n10 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n11 = n10;
                    final int intLen3 = this.intLen;
                    BytecodeManager.incBytecodes(4);
                    if (n11 >= intLen3) {
                        break;
                    }
                    array[n10] = this.value[this.offset + n10];
                    BytecodeManager.incBytecodes(10);
                    ++n10;
                    BytecodeManager.incBytecodes(2);
                }
                final int[] array2 = array;
                final int n12 = intLen2;
                BytecodeManager.incBytecodes(4);
                this.setValue(array2, n12);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n13 = this.value.length - this.offset;
                final int n14 = intLen2;
                BytecodeManager.incBytecodes(8);
                if (n13 >= n14) {
                    int n15 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n16 = n15;
                        final int n17 = intLen2 - this.intLen;
                        BytecodeManager.incBytecodes(6);
                        if (n16 >= n17) {
                            break;
                        }
                        this.value[this.offset + this.intLen + n15] = 0;
                        BytecodeManager.incBytecodes(11);
                        ++n15;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    int n18 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n19 = n18;
                        final int intLen4 = this.intLen;
                        BytecodeManager.incBytecodes(4);
                        if (n19 >= intLen4) {
                            break;
                        }
                        this.value[n18] = this.value[this.offset + n18];
                        BytecodeManager.incBytecodes(11);
                        ++n18;
                        BytecodeManager.incBytecodes(2);
                    }
                    int intLen5 = this.intLen;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int n20 = intLen5;
                        final int n21 = intLen2;
                        BytecodeManager.incBytecodes(3);
                        if (n20 >= n21) {
                            break;
                        }
                        this.value[intLen5] = 0;
                        BytecodeManager.incBytecodes(5);
                        ++intLen5;
                        BytecodeManager.incBytecodes(2);
                    }
                    this.offset = 0;
                    BytecodeManager.incBytecodes(3);
                }
            }
            this.intLen = intLen2;
            BytecodeManager.incBytecodes(3);
            final int n22 = n3;
            BytecodeManager.incBytecodes(2);
            if (n22 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n23 = n3;
            final int n24 = 32 - bitLengthForInt;
            BytecodeManager.incBytecodes(5);
            if (n23 <= n24) {
                final int n25 = n3;
                BytecodeManager.incBytecodes(3);
                this.primitiveLeftShift(n25);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n26 = 32 - n3;
                BytecodeManager.incBytecodes(5);
                this.primitiveRightShift(n26);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int divadd(final int[] array, final int[] array2, final int n) {
        try {
            long n2 = 0L;
            BytecodeManager.incBytecodes(2);
            int n3 = array.length - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(2);
                if (n4 < 0) {
                    break;
                }
                final long n5 = ((long)array[n3] & 0xFFFFFFFFL) + ((long)array2[n3 + n] & 0xFFFFFFFFL) + n2;
                BytecodeManager.incBytecodes(18);
                array2[n3 + n] = (int)n5;
                BytecodeManager.incBytecodes(7);
                n2 = n5 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = (int)n2;
            BytecodeManager.incBytecodes(3);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int mulsub(final int[] array, final int[] array2, final int n, final int n2, int n3) {
        try {
            final long n4 = (long)n & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            long n5 = 0L;
            BytecodeManager.incBytecodes(2);
            n3 += n2;
            BytecodeManager.incBytecodes(4);
            int n6 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                if (n7 < 0) {
                    break;
                }
                final long n8 = ((long)array2[n6] & 0xFFFFFFFFL) * n4 + n5;
                BytecodeManager.incBytecodes(11);
                final long n9 = array[n3] - n8;
                BytecodeManager.incBytecodes(7);
                array[n3--] = (int)n9;
                BytecodeManager.incBytecodes(6);
                final long n10 = n8 >>> 32;
                final long n11 = lcmp(n9 & 0xFFFFFFFFL, (long)~(int)n8 & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(15);
                int n12;
                if (n11 > 0) {
                    n12 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n12 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                n5 = n10 + n12;
                BytecodeManager.incBytecodes(3);
                --n6;
                BytecodeManager.incBytecodes(2);
            }
            final int n13 = (int)n5;
            BytecodeManager.incBytecodes(3);
            return n13;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int mulsubBorrow(final int[] array, final int[] array2, final int n, final int n2, int n3) {
        try {
            final long n4 = (long)n & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            long n5 = 0L;
            BytecodeManager.incBytecodes(2);
            n3 += n2;
            BytecodeManager.incBytecodes(4);
            int n6 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                if (n7 < 0) {
                    break;
                }
                final long n8 = ((long)array2[n6] & 0xFFFFFFFFL) * n4 + n5;
                BytecodeManager.incBytecodes(11);
                final long n9 = array[n3--] - n8;
                BytecodeManager.incBytecodes(8);
                final long n10 = n8 >>> 32;
                final long n11 = lcmp(n9 & 0xFFFFFFFFL, (long)~(int)n8 & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(15);
                int n12;
                if (n11 > 0) {
                    n12 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n12 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                n5 = n10 + n12;
                BytecodeManager.incBytecodes(3);
                --n6;
                BytecodeManager.incBytecodes(2);
            }
            final int n13 = (int)n5;
            BytecodeManager.incBytecodes(3);
            return n13;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final void primitiveRightShift(final int n) {
        try {
            final int[] value = this.value;
            BytecodeManager.incBytecodes(3);
            final int n2 = 32 - n;
            BytecodeManager.incBytecodes(4);
            int n3 = this.offset + this.intLen - 1;
            int n4 = value[n3];
            BytecodeManager.incBytecodes(12);
            while (true) {
                final int n5 = n3;
                final int offset = this.offset;
                BytecodeManager.incBytecodes(4);
                if (n5 <= offset) {
                    break;
                }
                final int n6 = n4;
                BytecodeManager.incBytecodes(2);
                n4 = value[n3 - 1];
                BytecodeManager.incBytecodes(6);
                value[n3] = (n4 << n2 | n6 >>> n);
                BytecodeManager.incBytecodes(10);
                --n3;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array = value;
            final int offset2 = this.offset;
            array[offset2] >>>= n;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final void primitiveLeftShift(final int n) {
        try {
            final int[] value = this.value;
            BytecodeManager.incBytecodes(3);
            final int n2 = 32 - n;
            BytecodeManager.incBytecodes(4);
            int offset = this.offset;
            int n3 = value[offset];
            final int n4 = offset + this.intLen - 1;
            BytecodeManager.incBytecodes(14);
            while (true) {
                final int n5 = offset;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n6) {
                    break;
                }
                final int n7 = n3;
                BytecodeManager.incBytecodes(2);
                n3 = value[offset + 1];
                BytecodeManager.incBytecodes(6);
                value[offset] = (n7 << n | n3 >>> n2);
                BytecodeManager.incBytecodes(10);
                ++offset;
                BytecodeManager.incBytecodes(2);
            }
            final int[] array = value;
            final int n8 = this.offset + this.intLen - 1;
            array[n8] <<= n;
            BytecodeManager.incBytecodes(13);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger getLower(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean zero = this.isZero();
            BytecodeManager.incBytecodes(1);
            if (zero) {
                final BigInteger zero2 = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero2;
            }
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(4);
            if (intLen < n) {
                final int n2 = 1;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigInteger = this.toBigInteger(n2);
                BytecodeManager.incBytecodes(1);
                return bigInteger;
            }
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(2);
                if (n4 <= 0) {
                    break;
                }
                final int n5 = this.value[this.offset + this.intLen - n3];
                BytecodeManager.incBytecodes(11);
                if (n5 != 0) {
                    break;
                }
                --n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = n3;
            BytecodeManager.incBytecodes(2);
            int n7;
            if (n6 > 0) {
                n7 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n7 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n8 = n7;
            BytecodeManager.incBytecodes(1);
            final int[] value = this.value;
            final int n9 = this.offset + this.intLen - n3;
            final int n10 = this.offset + this.intLen;
            BytecodeManager.incBytecodes(17);
            final int[] copyOfRange = Arrays.copyOfRange(value, n9, n10);
            final int n11 = n8;
            BytecodeManager.incBytecodes(2);
            final BigInteger bigInteger2 = new BigInteger(copyOfRange, n11);
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void keepLower(final int intLen) {
        try {
            final int intLen2 = this.intLen;
            BytecodeManager.incBytecodes(4);
            if (intLen2 >= intLen) {
                this.offset += this.intLen - intLen;
                BytecodeManager.incBytecodes(9);
                this.intLen = intLen;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void add(final MutableBigInteger mutableBigInteger) {
        try {
            int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            int intLen2 = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen3 = this.intLen;
            final int intLen4 = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(5);
            int n;
            if (intLen3 > intLen4) {
                n = this.intLen;
                BytecodeManager.incBytecodes(3);
            }
            else {
                n = mutableBigInteger.intLen;
                BytecodeManager.incBytecodes(2);
            }
            int intLen5 = n;
            BytecodeManager.incBytecodes(1);
            final int length = this.value.length;
            final int n2 = intLen5;
            BytecodeManager.incBytecodes(5);
            int[] value;
            if (length < n2) {
                value = new int[intLen5];
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = this.value;
                BytecodeManager.incBytecodes(2);
            }
            int[] value2 = value;
            BytecodeManager.incBytecodes(1);
            int n3 = value2.length - 1;
            BytecodeManager.incBytecodes(5);
            long n4 = 0L;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = intLen;
                BytecodeManager.incBytecodes(2);
                if (n5 <= 0) {
                    break;
                }
                final int n6 = intLen2;
                BytecodeManager.incBytecodes(2);
                if (n6 <= 0) {
                    break;
                }
                --intLen;
                --intLen2;
                BytecodeManager.incBytecodes(2);
                final long n7 = ((long)this.value[intLen + this.offset] & 0xFFFFFFFFL) + ((long)mutableBigInteger.value[intLen2 + mutableBigInteger.offset] & 0xFFFFFFFFL) + n4;
                BytecodeManager.incBytecodes(24);
                value2[n3--] = (int)n7;
                BytecodeManager.incBytecodes(6);
                n4 = n7 >>> 32;
                BytecodeManager.incBytecodes(5);
            }
            while (true) {
                final int n8 = intLen;
                BytecodeManager.incBytecodes(2);
                if (n8 <= 0) {
                    break;
                }
                --intLen;
                BytecodeManager.incBytecodes(1);
                final long n9 = lcmp(n4, 0L);
                BytecodeManager.incBytecodes(4);
                if (n9 == 0) {
                    final int[] array = value2;
                    final int[] value3 = this.value;
                    BytecodeManager.incBytecodes(4);
                    if (array == value3) {
                        final int n10 = n3;
                        final int n11 = intLen + this.offset;
                        BytecodeManager.incBytecodes(6);
                        if (n10 == n11) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                }
                final long n12 = ((long)this.value[intLen + this.offset] & 0xFFFFFFFFL) + n4;
                BytecodeManager.incBytecodes(13);
                value2[n3--] = (int)n12;
                BytecodeManager.incBytecodes(6);
                n4 = n12 >>> 32;
                BytecodeManager.incBytecodes(5);
            }
            while (true) {
                final int n13 = intLen2;
                BytecodeManager.incBytecodes(2);
                if (n13 <= 0) {
                    break;
                }
                --intLen2;
                BytecodeManager.incBytecodes(1);
                final long n14 = ((long)mutableBigInteger.value[intLen2 + mutableBigInteger.offset] & 0xFFFFFFFFL) + n4;
                BytecodeManager.incBytecodes(13);
                value2[n3--] = (int)n14;
                BytecodeManager.incBytecodes(6);
                n4 = n14 >>> 32;
                BytecodeManager.incBytecodes(5);
            }
            final long n15 = lcmp(n4, 0L);
            BytecodeManager.incBytecodes(4);
            if (n15 > 0) {
                ++intLen5;
                BytecodeManager.incBytecodes(1);
                final int length2 = value2.length;
                final int n16 = intLen5;
                BytecodeManager.incBytecodes(4);
                if (length2 < n16) {
                    final int[] array2 = new int[intLen5];
                    BytecodeManager.incBytecodes(2);
                    final int[] array3 = value2;
                    final int n17 = 0;
                    final int[] array4 = array2;
                    final int n18 = 1;
                    final int length3 = value2.length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array3, n17, array4, n18, length3);
                    array2[0] = 1;
                    BytecodeManager.incBytecodes(4);
                    value2 = array2;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    value2[n3--] = 1;
                    BytecodeManager.incBytecodes(5);
                }
            }
            this.value = value2;
            BytecodeManager.incBytecodes(3);
            this.intLen = intLen5;
            BytecodeManager.incBytecodes(3);
            this.offset = value2.length - intLen5;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void addShifted(final MutableBigInteger mutableBigInteger, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean zero = mutableBigInteger.isZero();
            BytecodeManager.incBytecodes(1);
            if (zero) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            int n2 = mutableBigInteger.intLen + n;
            BytecodeManager.incBytecodes(5);
            final int intLen2 = this.intLen;
            final int n3 = n2;
            BytecodeManager.incBytecodes(4);
            int intLen3;
            if (intLen2 > n3) {
                intLen3 = this.intLen;
                BytecodeManager.incBytecodes(3);
            }
            else {
                intLen3 = n2;
                BytecodeManager.incBytecodes(1);
            }
            int intLen4 = intLen3;
            BytecodeManager.incBytecodes(1);
            final int length = this.value.length;
            final int n4 = intLen4;
            BytecodeManager.incBytecodes(5);
            int[] value;
            if (length < n4) {
                value = new int[intLen4];
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = this.value;
                BytecodeManager.incBytecodes(2);
            }
            int[] value2 = value;
            BytecodeManager.incBytecodes(1);
            int n5 = value2.length - 1;
            BytecodeManager.incBytecodes(5);
            long n6 = 0L;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n7 = intLen;
                BytecodeManager.incBytecodes(2);
                if (n7 <= 0) {
                    break;
                }
                final int n8 = n2;
                BytecodeManager.incBytecodes(2);
                if (n8 <= 0) {
                    break;
                }
                --intLen;
                --n2;
                BytecodeManager.incBytecodes(2);
                final int n9 = n2 + mutableBigInteger.offset;
                final int length2 = mutableBigInteger.value.length;
                BytecodeManager.incBytecodes(8);
                int n10;
                if (n9 < length2) {
                    n10 = mutableBigInteger.value[n2 + mutableBigInteger.offset];
                    BytecodeManager.incBytecodes(8);
                }
                else {
                    n10 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n11 = n10;
                BytecodeManager.incBytecodes(1);
                final long n12 = ((long)this.value[intLen + this.offset] & 0xFFFFFFFFL) + ((long)n11 & 0xFFFFFFFFL) + n6;
                BytecodeManager.incBytecodes(18);
                value2[n5--] = (int)n12;
                BytecodeManager.incBytecodes(6);
                n6 = n12 >>> 32;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            while (true) {
                final int n13 = intLen;
                BytecodeManager.incBytecodes(2);
                if (n13 <= 0) {
                    break;
                }
                --intLen;
                BytecodeManager.incBytecodes(1);
                final long n14 = lcmp(n6, 0L);
                BytecodeManager.incBytecodes(4);
                if (n14 == 0) {
                    final int[] array = value2;
                    final int[] value3 = this.value;
                    BytecodeManager.incBytecodes(4);
                    if (array == value3) {
                        final int n15 = n5;
                        final int n16 = intLen + this.offset;
                        BytecodeManager.incBytecodes(6);
                        if (n15 == n16) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                }
                final long n17 = ((long)this.value[intLen + this.offset] & 0xFFFFFFFFL) + n6;
                BytecodeManager.incBytecodes(13);
                value2[n5--] = (int)n17;
                BytecodeManager.incBytecodes(6);
                n6 = n17 >>> 32;
                BytecodeManager.incBytecodes(5);
            }
            while (true) {
                final int n18 = n2;
                BytecodeManager.incBytecodes(2);
                if (n18 <= 0) {
                    break;
                }
                --n2;
                BytecodeManager.incBytecodes(1);
                final int n19 = n2 + mutableBigInteger.offset;
                final int length3 = mutableBigInteger.value.length;
                BytecodeManager.incBytecodes(8);
                int n20;
                if (n19 < length3) {
                    n20 = mutableBigInteger.value[n2 + mutableBigInteger.offset];
                    BytecodeManager.incBytecodes(8);
                }
                else {
                    n20 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n21 = n20;
                BytecodeManager.incBytecodes(1);
                final long n22 = ((long)n21 & 0xFFFFFFFFL) + n6;
                BytecodeManager.incBytecodes(7);
                value2[n5--] = (int)n22;
                BytecodeManager.incBytecodes(6);
                n6 = n22 >>> 32;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            final long n23 = lcmp(n6, 0L);
            BytecodeManager.incBytecodes(4);
            if (n23 > 0) {
                ++intLen4;
                BytecodeManager.incBytecodes(1);
                final int length4 = value2.length;
                final int n24 = intLen4;
                BytecodeManager.incBytecodes(4);
                if (length4 < n24) {
                    final int[] array2 = new int[intLen4];
                    BytecodeManager.incBytecodes(2);
                    final int[] array3 = value2;
                    final int n25 = 0;
                    final int[] array4 = array2;
                    final int n26 = 1;
                    final int length5 = value2.length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array3, n25, array4, n26, length5);
                    array2[0] = 1;
                    BytecodeManager.incBytecodes(4);
                    value2 = array2;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    value2[n5--] = 1;
                    BytecodeManager.incBytecodes(5);
                }
            }
            this.value = value2;
            BytecodeManager.incBytecodes(3);
            this.intLen = intLen4;
            BytecodeManager.incBytecodes(3);
            this.offset = value2.length - intLen4;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void addDisjoint(final MutableBigInteger mutableBigInteger, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean zero = mutableBigInteger.isZero();
            BytecodeManager.incBytecodes(1);
            if (zero) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            final int n2 = mutableBigInteger.intLen + n;
            BytecodeManager.incBytecodes(5);
            final int intLen2 = this.intLen;
            final int n3 = n2;
            BytecodeManager.incBytecodes(4);
            int intLen3;
            if (intLen2 > n3) {
                intLen3 = this.intLen;
                BytecodeManager.incBytecodes(3);
            }
            else {
                intLen3 = n2;
                BytecodeManager.incBytecodes(1);
            }
            final int intLen4 = intLen3;
            BytecodeManager.incBytecodes(1);
            final int length = this.value.length;
            final int n4 = intLen4;
            BytecodeManager.incBytecodes(5);
            int[] value;
            if (length < n4) {
                value = new int[intLen4];
                BytecodeManager.incBytecodes(3);
            }
            else {
                value = this.value;
                BytecodeManager.incBytecodes(3);
                final int[] value2 = this.value;
                final int n5 = this.offset + this.intLen;
                final int length2 = this.value.length;
                final int n6 = 0;
                BytecodeManager.incBytecodes(12);
                Arrays.fill(value2, n5, length2, n6);
            }
            final int n7 = value.length - 1;
            BytecodeManager.incBytecodes(5);
            final int[] value3 = this.value;
            final int offset = this.offset;
            final int[] array = value;
            final int n8 = n7 + 1 - intLen;
            final int n9 = intLen;
            BytecodeManager.incBytecodes(12);
            System.arraycopy(value3, offset, array, n8, n9);
            final int n10 = n2 - intLen;
            BytecodeManager.incBytecodes(4);
            final int n11 = n7 - intLen;
            BytecodeManager.incBytecodes(4);
            final int a = n10;
            final int b = mutableBigInteger.value.length - mutableBigInteger.offset;
            BytecodeManager.incBytecodes(8);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            final int[] value4 = mutableBigInteger.value;
            final int offset2 = mutableBigInteger.offset;
            final int[] array2 = value;
            final int n12 = n11 + 1 - n10;
            final int n13 = min;
            BytecodeManager.incBytecodes(12);
            System.arraycopy(value4, offset2, array2, n12, n13);
            int n14 = n11 + 1 - n10 + min;
            BytecodeManager.incBytecodes(8);
            while (true) {
                final int n15 = n14;
                final int n16 = n11 + 1;
                BytecodeManager.incBytecodes(5);
                if (n15 >= n16) {
                    break;
                }
                value[n14] = 0;
                BytecodeManager.incBytecodes(4);
                ++n14;
                BytecodeManager.incBytecodes(2);
            }
            this.value = value;
            BytecodeManager.incBytecodes(3);
            this.intLen = intLen4;
            BytecodeManager.incBytecodes(3);
            this.offset = value.length - intLen4;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void addLower(final MutableBigInteger mutableBigInteger, final int intLen) {
        try {
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(mutableBigInteger);
            BytecodeManager.incBytecodes(1);
            final int n = mutableBigInteger2.offset + mutableBigInteger2.intLen;
            BytecodeManager.incBytecodes(7);
            if (n >= intLen) {
                mutableBigInteger2.offset = mutableBigInteger2.offset + mutableBigInteger2.intLen - intLen;
                BytecodeManager.incBytecodes(9);
                mutableBigInteger2.intLen = intLen;
                BytecodeManager.incBytecodes(3);
            }
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            mutableBigInteger3.normalize();
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(3);
            this.add(mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int subtract(MutableBigInteger mutableBigInteger) {
        try {
            MutableBigInteger mutableBigInteger2 = this;
            BytecodeManager.incBytecodes(2);
            int[] value = this.value;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger2;
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
            BytecodeManager.incBytecodes(3);
            final int compare = mutableBigInteger3.compare(mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final int n = compare;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(2);
                this.reset();
                final int n2 = 0;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final int n3 = compare;
            BytecodeManager.incBytecodes(2);
            if (n3 < 0) {
                final MutableBigInteger mutableBigInteger5 = mutableBigInteger2;
                BytecodeManager.incBytecodes(2);
                mutableBigInteger2 = mutableBigInteger;
                BytecodeManager.incBytecodes(2);
                mutableBigInteger = mutableBigInteger5;
                BytecodeManager.incBytecodes(2);
            }
            final int intLen = mutableBigInteger2.intLen;
            BytecodeManager.incBytecodes(3);
            final int length = value.length;
            final int n4 = intLen;
            BytecodeManager.incBytecodes(4);
            if (length < n4) {
                value = new int[intLen];
                BytecodeManager.incBytecodes(2);
            }
            long n5 = 0L;
            BytecodeManager.incBytecodes(2);
            int intLen2 = mutableBigInteger2.intLen;
            BytecodeManager.incBytecodes(3);
            int intLen3 = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            int n6 = value.length - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n7 = intLen3;
                BytecodeManager.incBytecodes(2);
                if (n7 <= 0) {
                    break;
                }
                --intLen2;
                --intLen3;
                BytecodeManager.incBytecodes(2);
                n5 = ((long)mutableBigInteger2.value[intLen2 + mutableBigInteger2.offset] & 0xFFFFFFFFL) - ((long)mutableBigInteger.value[intLen3 + mutableBigInteger.offset] & 0xFFFFFFFFL) - (int)(-(n5 >> 32));
                BytecodeManager.incBytecodes(29);
                value[n6--] = (int)n5;
                BytecodeManager.incBytecodes(7);
            }
            while (true) {
                final int n8 = intLen2;
                BytecodeManager.incBytecodes(2);
                if (n8 <= 0) {
                    break;
                }
                --intLen2;
                BytecodeManager.incBytecodes(1);
                n5 = ((long)mutableBigInteger2.value[intLen2 + mutableBigInteger2.offset] & 0xFFFFFFFFL) - (int)(-(n5 >> 32));
                BytecodeManager.incBytecodes(18);
                value[n6--] = (int)n5;
                BytecodeManager.incBytecodes(7);
            }
            this.value = value;
            BytecodeManager.incBytecodes(3);
            this.intLen = intLen;
            BytecodeManager.incBytecodes(3);
            this.offset = this.value.length - intLen;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(2);
            this.normalize();
            final int n9 = compare;
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int difference(MutableBigInteger mutableBigInteger) {
        try {
            MutableBigInteger mutableBigInteger2 = this;
            BytecodeManager.incBytecodes(2);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger2;
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
            BytecodeManager.incBytecodes(3);
            final int compare = mutableBigInteger3.compare(mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final int n = compare;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final int n2 = 0;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final int n3 = compare;
            BytecodeManager.incBytecodes(2);
            if (n3 < 0) {
                final MutableBigInteger mutableBigInteger5 = mutableBigInteger2;
                BytecodeManager.incBytecodes(2);
                mutableBigInteger2 = mutableBigInteger;
                BytecodeManager.incBytecodes(2);
                mutableBigInteger = mutableBigInteger5;
                BytecodeManager.incBytecodes(2);
            }
            long n4 = 0L;
            BytecodeManager.incBytecodes(2);
            int intLen = mutableBigInteger2.intLen;
            BytecodeManager.incBytecodes(3);
            int intLen2 = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n5 = intLen2;
                BytecodeManager.incBytecodes(2);
                if (n5 <= 0) {
                    break;
                }
                --intLen;
                --intLen2;
                BytecodeManager.incBytecodes(2);
                n4 = ((long)mutableBigInteger2.value[mutableBigInteger2.offset + intLen] & 0xFFFFFFFFL) - ((long)mutableBigInteger.value[mutableBigInteger.offset + intLen2] & 0xFFFFFFFFL) - (int)(-(n4 >> 32));
                BytecodeManager.incBytecodes(29);
                mutableBigInteger2.value[mutableBigInteger2.offset + intLen] = (int)n4;
                BytecodeManager.incBytecodes(10);
            }
            while (true) {
                final int n6 = intLen;
                BytecodeManager.incBytecodes(2);
                if (n6 <= 0) {
                    break;
                }
                --intLen;
                BytecodeManager.incBytecodes(1);
                n4 = ((long)mutableBigInteger2.value[mutableBigInteger2.offset + intLen] & 0xFFFFFFFFL) - (int)(-(n4 >> 32));
                BytecodeManager.incBytecodes(18);
                mutableBigInteger2.value[mutableBigInteger2.offset + intLen] = (int)n4;
                BytecodeManager.incBytecodes(10);
            }
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            mutableBigInteger6.normalize();
            final int n7 = compare;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void multiply(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2) {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen2 = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen3 = intLen + intLen2;
            BytecodeManager.incBytecodes(4);
            final int length = mutableBigInteger2.value.length;
            final int n = intLen3;
            BytecodeManager.incBytecodes(5);
            if (length < n) {
                mutableBigInteger2.value = new int[intLen3];
                BytecodeManager.incBytecodes(3);
            }
            mutableBigInteger2.offset = 0;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger2.intLen = intLen3;
            BytecodeManager.incBytecodes(3);
            long n2 = 0L;
            BytecodeManager.incBytecodes(2);
            int n3 = intLen2 - 1;
            int n4 = intLen2 + intLen - 1;
            BytecodeManager.incBytecodes(10);
            while (true) {
                final int n5 = n3;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    break;
                }
                final long n6 = ((long)mutableBigInteger.value[n3 + mutableBigInteger.offset] & 0xFFFFFFFFL) * ((long)this.value[intLen - 1 + this.offset] & 0xFFFFFFFFL) + n2;
                BytecodeManager.incBytecodes(26);
                mutableBigInteger2.value[n4] = (int)n6;
                BytecodeManager.incBytecodes(6);
                n2 = n6 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n3;
                --n4;
                BytecodeManager.incBytecodes(3);
            }
            mutableBigInteger2.value[intLen - 1] = (int)n2;
            BytecodeManager.incBytecodes(8);
            int n7 = intLen - 2;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n8 = n7;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    break;
                }
                long n9 = 0L;
                BytecodeManager.incBytecodes(2);
                int n10 = intLen2 - 1;
                int n11 = intLen2 + n7;
                BytecodeManager.incBytecodes(8);
                while (true) {
                    final int n12 = n10;
                    BytecodeManager.incBytecodes(2);
                    if (n12 < 0) {
                        break;
                    }
                    final long n13 = ((long)mutableBigInteger.value[n10 + mutableBigInteger.offset] & 0xFFFFFFFFL) * ((long)this.value[n7 + this.offset] & 0xFFFFFFFFL) + ((long)mutableBigInteger2.value[n11] & 0xFFFFFFFFL) + n9;
                    BytecodeManager.incBytecodes(32);
                    mutableBigInteger2.value[n11] = (int)n13;
                    BytecodeManager.incBytecodes(6);
                    n9 = n13 >>> 32;
                    BytecodeManager.incBytecodes(4);
                    --n10;
                    --n11;
                    BytecodeManager.incBytecodes(3);
                }
                mutableBigInteger2.value[n7] = (int)n9;
                BytecodeManager.incBytecodes(6);
                --n7;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            mutableBigInteger2.normalize();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void mul(final int n, final MutableBigInteger mutableBigInteger) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.copyValue(this);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(2);
                mutableBigInteger.clear();
                BytecodeManager.incBytecodes(1);
                return;
            }
            final long n3 = (long)n & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final int length = mutableBigInteger.value.length;
            final int n4 = this.intLen + 1;
            BytecodeManager.incBytecodes(8);
            int[] value;
            if (length < n4) {
                value = new int[this.intLen + 1];
                BytecodeManager.incBytecodes(5);
            }
            else {
                value = mutableBigInteger.value;
                BytecodeManager.incBytecodes(2);
            }
            final int[] value2 = value;
            BytecodeManager.incBytecodes(1);
            long n5 = 0L;
            BytecodeManager.incBytecodes(2);
            int n6 = this.intLen - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                if (n7 < 0) {
                    break;
                }
                final long n8 = n3 * ((long)this.value[n6 + this.offset] & 0xFFFFFFFFL) + n5;
                BytecodeManager.incBytecodes(15);
                value2[n6 + 1] = (int)n8;
                BytecodeManager.incBytecodes(7);
                n5 = n8 >>> 32;
                BytecodeManager.incBytecodes(4);
                --n6;
                BytecodeManager.incBytecodes(2);
            }
            final long n9 = lcmp(n5, 0L);
            BytecodeManager.incBytecodes(4);
            if (n9 == 0) {
                mutableBigInteger.offset = 1;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.intLen = this.intLen;
                BytecodeManager.incBytecodes(5);
            }
            else {
                mutableBigInteger.offset = 0;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.intLen = this.intLen + 1;
                BytecodeManager.incBytecodes(6);
                value2[0] = (int)n5;
                BytecodeManager.incBytecodes(5);
            }
            mutableBigInteger.value = value2;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int divideOneWord(final int i, final MutableBigInteger mutableBigInteger) {
        try {
            final long n = (long)i & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final int intLen = this.intLen;
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            if (intLen == n2) {
                final long n3 = (long)this.value[this.offset] & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(9);
                final int n4 = (int)(n3 / n);
                BytecodeManager.incBytecodes(5);
                final int n5 = (int)(n3 - n4 * n);
                BytecodeManager.incBytecodes(8);
                mutableBigInteger.value[0] = n4;
                BytecodeManager.incBytecodes(5);
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                int intLen2;
                if (n6 == 0) {
                    intLen2 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    intLen2 = 1;
                    BytecodeManager.incBytecodes(1);
                }
                mutableBigInteger.intLen = intLen2;
                BytecodeManager.incBytecodes(1);
                mutableBigInteger.offset = 0;
                BytecodeManager.incBytecodes(3);
                final int n7 = n5;
                BytecodeManager.incBytecodes(2);
                return n7;
            }
            final int length = mutableBigInteger.value.length;
            final int intLen3 = this.intLen;
            BytecodeManager.incBytecodes(6);
            if (length < intLen3) {
                mutableBigInteger.value = new int[this.intLen];
                BytecodeManager.incBytecodes(4);
            }
            mutableBigInteger.offset = 0;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger.intLen = this.intLen;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(1);
            int n8 = this.value[this.offset];
            BytecodeManager.incBytecodes(6);
            long n9 = (long)n8 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final long n10 = lcmp(n9, n);
            BytecodeManager.incBytecodes(4);
            if (n10 < 0) {
                mutableBigInteger.value[0] = 0;
                BytecodeManager.incBytecodes(6);
            }
            else {
                mutableBigInteger.value[0] = (int)(n9 / n);
                BytecodeManager.incBytecodes(8);
                n8 = (int)(n9 - mutableBigInteger.value[0] * n);
                BytecodeManager.incBytecodes(11);
                n9 = ((long)n8 & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(5);
            }
            int intLen4 = this.intLen;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n11 = --intLen4;
                BytecodeManager.incBytecodes(3);
                if (n11 <= 0) {
                    break;
                }
                final long n12 = n9 << 32 | ((long)this.value[this.offset + this.intLen - intLen4] & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(18);
                final long n13 = lcmp(n12, 0L);
                BytecodeManager.incBytecodes(4);
                int n14;
                if (n13 >= 0) {
                    n14 = (int)(n12 / n);
                    BytecodeManager.incBytecodes(5);
                    n8 = (int)(n12 - n14 * n);
                    BytecodeManager.incBytecodes(9);
                }
                else {
                    final long n15 = n12;
                    BytecodeManager.incBytecodes(3);
                    final long divWord = divWord(n15, i);
                    BytecodeManager.incBytecodes(1);
                    n14 = (int)(divWord & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(5);
                    n8 = (int)(divWord >>> 32);
                    BytecodeManager.incBytecodes(5);
                }
                mutableBigInteger.value[this.intLen - intLen4] = n14;
                BytecodeManager.incBytecodes(8);
                n9 = ((long)n8 & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(2);
            mutableBigInteger.normalize();
            final int n16 = numberOfLeadingZeros;
            BytecodeManager.incBytecodes(2);
            if (n16 > 0) {
                final int n17 = n8 % i;
                BytecodeManager.incBytecodes(4);
                return n17;
            }
            final int n18 = n8;
            BytecodeManager.incBytecodes(2);
            return n18;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger divide(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger divide = this.divide(mutableBigInteger, mutableBigInteger2, b);
            BytecodeManager.incBytecodes(1);
            return divide;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger divide(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2, final boolean b) {
        try {
            final int intLen = mutableBigInteger.intLen;
            final int n = 80;
            BytecodeManager.incBytecodes(4);
            if (intLen >= n) {
                final int n2 = this.intLen - mutableBigInteger.intLen;
                final int n3 = 40;
                BytecodeManager.incBytecodes(7);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(4);
                    final MutableBigInteger divideAndRemainderBurnikelZiegler = this.divideAndRemainderBurnikelZiegler(mutableBigInteger, mutableBigInteger2);
                    BytecodeManager.incBytecodes(1);
                    return divideAndRemainderBurnikelZiegler;
                }
            }
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger divideKnuth = this.divideKnuth(mutableBigInteger, mutableBigInteger2, b);
            BytecodeManager.incBytecodes(1);
            return divideKnuth;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger divideKnuth(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger divideKnuth = this.divideKnuth(mutableBigInteger, mutableBigInteger2, b);
            BytecodeManager.incBytecodes(1);
            return divideKnuth;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger divideKnuth(MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2, final boolean b) {
        try {
            final int intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                final String s = "BigInteger divide by zero";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int intLen2 = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen2 == 0) {
                final int n = 0;
                mutableBigInteger2.offset = n;
                mutableBigInteger2.intLen = n;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(2);
                MutableBigInteger mutableBigInteger3;
                if (b) {
                    mutableBigInteger3 = new MutableBigInteger();
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    mutableBigInteger3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return mutableBigInteger3;
            }
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
            BytecodeManager.incBytecodes(3);
            final int compare = this.compare(mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final int n2 = compare;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                final int n3 = 0;
                mutableBigInteger2.offset = n3;
                mutableBigInteger2.intLen = n3;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(2);
                MutableBigInteger mutableBigInteger5;
                if (b) {
                    mutableBigInteger5 = new MutableBigInteger(this);
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    mutableBigInteger5 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return mutableBigInteger5;
            }
            final int n4 = compare;
            BytecodeManager.incBytecodes(2);
            if (n4 == 0) {
                mutableBigInteger2.value[0] = (mutableBigInteger2.intLen = 1);
                BytecodeManager.incBytecodes(8);
                mutableBigInteger2.offset = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                MutableBigInteger mutableBigInteger6;
                if (b) {
                    mutableBigInteger6 = new MutableBigInteger();
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    mutableBigInteger6 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return mutableBigInteger6;
            }
            BytecodeManager.incBytecodes(2);
            mutableBigInteger2.clear();
            final int intLen3 = mutableBigInteger.intLen;
            final int n5 = 1;
            BytecodeManager.incBytecodes(4);
            if (intLen3 != n5) {
                final int intLen4 = this.intLen;
                final int n6 = 6;
                BytecodeManager.incBytecodes(4);
                if (intLen4 >= n6) {
                    BytecodeManager.incBytecodes(2);
                    final int lowestSetBit = this.getLowestSetBit();
                    final MutableBigInteger mutableBigInteger7 = mutableBigInteger;
                    BytecodeManager.incBytecodes(2);
                    final int lowestSetBit2 = mutableBigInteger7.getLowestSetBit();
                    BytecodeManager.incBytecodes(1);
                    final int min = Math.min(lowestSetBit, lowestSetBit2);
                    BytecodeManager.incBytecodes(1);
                    final int n7 = min;
                    final int n8 = 96;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        BytecodeManager.incBytecodes(4);
                        final MutableBigInteger mutableBigInteger8 = new MutableBigInteger(this);
                        BytecodeManager.incBytecodes(1);
                        final MutableBigInteger mutableBigInteger9 = mutableBigInteger;
                        BytecodeManager.incBytecodes(4);
                        mutableBigInteger = new MutableBigInteger(mutableBigInteger9);
                        BytecodeManager.incBytecodes(1);
                        final MutableBigInteger mutableBigInteger10 = mutableBigInteger8;
                        final int n9 = min;
                        BytecodeManager.incBytecodes(3);
                        mutableBigInteger10.rightShift(n9);
                        final MutableBigInteger mutableBigInteger11 = mutableBigInteger;
                        final int n10 = min;
                        BytecodeManager.incBytecodes(3);
                        mutableBigInteger11.rightShift(n10);
                        final MutableBigInteger mutableBigInteger12 = mutableBigInteger8;
                        final MutableBigInteger mutableBigInteger13 = mutableBigInteger;
                        BytecodeManager.incBytecodes(4);
                        final MutableBigInteger divideKnuth = mutableBigInteger12.divideKnuth(mutableBigInteger13, mutableBigInteger2);
                        BytecodeManager.incBytecodes(1);
                        final MutableBigInteger mutableBigInteger14 = divideKnuth;
                        final int n11 = min;
                        BytecodeManager.incBytecodes(3);
                        mutableBigInteger14.leftShift(n11);
                        final MutableBigInteger mutableBigInteger15 = divideKnuth;
                        BytecodeManager.incBytecodes(2);
                        return mutableBigInteger15;
                    }
                }
                final MutableBigInteger mutableBigInteger16 = mutableBigInteger;
                BytecodeManager.incBytecodes(5);
                final MutableBigInteger divideMagnitude = this.divideMagnitude(mutableBigInteger16, mutableBigInteger2, b);
                BytecodeManager.incBytecodes(1);
                return divideMagnitude;
            }
            final int n12 = mutableBigInteger.value[mutableBigInteger.offset];
            BytecodeManager.incBytecodes(8);
            final int divideOneWord = this.divideOneWord(n12, mutableBigInteger2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (!b) {
                final MutableBigInteger mutableBigInteger17 = null;
                BytecodeManager.incBytecodes(2);
                return mutableBigInteger17;
            }
            final int n13 = divideOneWord;
            BytecodeManager.incBytecodes(2);
            if (n13 == 0) {
                BytecodeManager.incBytecodes(3);
                final MutableBigInteger mutableBigInteger18 = new MutableBigInteger();
                BytecodeManager.incBytecodes(1);
                return mutableBigInteger18;
            }
            final int n14 = divideOneWord;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger19 = new MutableBigInteger(n14);
            BytecodeManager.incBytecodes(1);
            return mutableBigInteger19;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger divideAndRemainderBurnikelZiegler(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2) {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen2 = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int n = 0;
            mutableBigInteger2.intLen = n;
            mutableBigInteger2.offset = n;
            BytecodeManager.incBytecodes(6);
            final int n2 = intLen;
            final int n3 = intLen2;
            BytecodeManager.incBytecodes(3);
            if (n2 < n3) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final int n4 = 1;
            final int n5 = 32;
            final int i = intLen2 / 80;
            BytecodeManager.incBytecodes(6);
            final int n6 = n4 << n5 - Integer.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(3);
            final int n7 = (intLen2 + n6 - 1) / n6;
            BytecodeManager.incBytecodes(8);
            final int n8 = n7 * n6;
            BytecodeManager.incBytecodes(4);
            final long n9 = 32L * n8;
            BytecodeManager.incBytecodes(5);
            final long a = 0L;
            final long n10 = n9;
            BytecodeManager.incBytecodes(4);
            final long b = n10 - mutableBigInteger.bitLength();
            BytecodeManager.incBytecodes(2);
            final int n11 = (int)Math.max(a, b);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mutableBigInteger);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger3;
            final int n12 = n11;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger4.safeLeftShift(n12);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger5 = new MutableBigInteger(this);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger5;
            final int n13 = n11;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger6.safeLeftShift(n13);
            final MutableBigInteger mutableBigInteger7 = mutableBigInteger5;
            BytecodeManager.incBytecodes(2);
            int n14 = (int)((mutableBigInteger7.bitLength() + n9) / n9);
            BytecodeManager.incBytecodes(6);
            final int n15 = n14;
            final int n16 = 2;
            BytecodeManager.incBytecodes(3);
            if (n15 < n16) {
                n14 = 2;
                BytecodeManager.incBytecodes(2);
            }
            final MutableBigInteger mutableBigInteger8 = mutableBigInteger5;
            final int n17 = n14 - 1;
            final int n18 = n14;
            final int n19 = n8;
            BytecodeManager.incBytecodes(7);
            final MutableBigInteger block = mutableBigInteger8.getBlock(n17, n18, n19);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger9 = mutableBigInteger5;
            final int n20 = n14 - 2;
            final int n21 = n14;
            final int n22 = n8;
            BytecodeManager.incBytecodes(7);
            MutableBigInteger mutableBigInteger10 = mutableBigInteger9.getBlock(n20, n21, n22);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger11 = mutableBigInteger10;
            final MutableBigInteger mutableBigInteger12 = block;
            final int n23 = n8;
            BytecodeManager.incBytecodes(4);
            mutableBigInteger11.addDisjoint(mutableBigInteger12, n23);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger13 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            int n24 = n14 - 2;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n25 = n24;
                BytecodeManager.incBytecodes(2);
                if (n25 <= 0) {
                    break;
                }
                final MutableBigInteger mutableBigInteger14 = mutableBigInteger10;
                final MutableBigInteger mutableBigInteger15 = mutableBigInteger3;
                final MutableBigInteger mutableBigInteger16 = mutableBigInteger13;
                BytecodeManager.incBytecodes(4);
                final MutableBigInteger divide2n1n = mutableBigInteger14.divide2n1n(mutableBigInteger15, mutableBigInteger16);
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger17 = mutableBigInteger5;
                final int n26 = n24 - 1;
                final int n27 = n14;
                final int n28 = n8;
                BytecodeManager.incBytecodes(7);
                mutableBigInteger10 = mutableBigInteger17.getBlock(n26, n27, n28);
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger18 = mutableBigInteger10;
                final MutableBigInteger mutableBigInteger19 = divide2n1n;
                final int n29 = n8;
                BytecodeManager.incBytecodes(4);
                mutableBigInteger18.addDisjoint(mutableBigInteger19, n29);
                final MutableBigInteger mutableBigInteger20 = mutableBigInteger13;
                final int n30 = n24 * n8;
                BytecodeManager.incBytecodes(6);
                mutableBigInteger2.addShifted(mutableBigInteger20, n30);
                --n24;
                BytecodeManager.incBytecodes(2);
            }
            final MutableBigInteger mutableBigInteger21 = mutableBigInteger10;
            final MutableBigInteger mutableBigInteger22 = mutableBigInteger3;
            final MutableBigInteger mutableBigInteger23 = mutableBigInteger13;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divide2n1n2 = mutableBigInteger21.divide2n1n(mutableBigInteger22, mutableBigInteger23);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger24 = mutableBigInteger13;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger2.add(mutableBigInteger24);
            final MutableBigInteger mutableBigInteger25 = divide2n1n2;
            final int n31 = n11;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger25.rightShift(n31);
            final MutableBigInteger mutableBigInteger26 = divide2n1n2;
            BytecodeManager.incBytecodes(2);
            return mutableBigInteger26;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private MutableBigInteger divide2n1n(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2) {
        try {
            final int intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int n = intLen % 2;
            BytecodeManager.incBytecodes(4);
            if (n == 0) {
                final int n2 = intLen;
                final int n3 = 80;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(4);
                    final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(this);
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger4 = mutableBigInteger3;
                    final int n4 = 32 * (intLen / 2);
                    BytecodeManager.incBytecodes(7);
                    mutableBigInteger4.safeRightShift(n4);
                    final int n5 = intLen / 2;
                    BytecodeManager.incBytecodes(5);
                    this.keepLower(n5);
                    BytecodeManager.incBytecodes(3);
                    final MutableBigInteger mutableBigInteger5 = new MutableBigInteger();
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger6 = mutableBigInteger3;
                    final MutableBigInteger mutableBigInteger7 = mutableBigInteger5;
                    BytecodeManager.incBytecodes(4);
                    final MutableBigInteger divide3n2n = mutableBigInteger6.divide3n2n(mutableBigInteger, mutableBigInteger7);
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger8 = divide3n2n;
                    final int n6 = intLen / 2;
                    BytecodeManager.incBytecodes(6);
                    this.addDisjoint(mutableBigInteger8, n6);
                    BytecodeManager.incBytecodes(4);
                    final MutableBigInteger divide3n2n2 = this.divide3n2n(mutableBigInteger, mutableBigInteger2);
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger9 = mutableBigInteger5;
                    final int n7 = intLen / 2;
                    BytecodeManager.incBytecodes(6);
                    mutableBigInteger2.addDisjoint(mutableBigInteger9, n7);
                    final MutableBigInteger mutableBigInteger10 = divide3n2n2;
                    BytecodeManager.incBytecodes(2);
                    return mutableBigInteger10;
                }
            }
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divideKnuth = this.divideKnuth(mutableBigInteger, mutableBigInteger2);
            BytecodeManager.incBytecodes(1);
            return divideKnuth;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private MutableBigInteger divide3n2n(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2) {
        try {
            final int n = mutableBigInteger.intLen / 2;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(this);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger3;
            final int n2 = 32 * n;
            BytecodeManager.incBytecodes(5);
            mutableBigInteger4.safeRightShift(n2);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger5 = new MutableBigInteger(mutableBigInteger);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger5;
            final int n3 = n * 32;
            BytecodeManager.incBytecodes(5);
            mutableBigInteger6.safeRightShift(n3);
            final int n4 = n;
            BytecodeManager.incBytecodes(3);
            final BigInteger lower = mutableBigInteger.getLower(n4);
            BytecodeManager.incBytecodes(1);
            final int n5 = n;
            BytecodeManager.incBytecodes(4);
            final int compareShifted = this.compareShifted(mutableBigInteger, n5);
            BytecodeManager.incBytecodes(1);
            MutableBigInteger divide2n1n;
            MutableBigInteger mutableBigInteger9;
            if (compareShifted < 0) {
                final MutableBigInteger mutableBigInteger7 = mutableBigInteger3;
                final MutableBigInteger mutableBigInteger8 = mutableBigInteger5;
                BytecodeManager.incBytecodes(4);
                divide2n1n = mutableBigInteger7.divide2n1n(mutableBigInteger8, mutableBigInteger2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(4);
                final BigInteger bigInteger = mutableBigInteger2.toBigInteger();
                final BigInteger bigInteger2 = lower;
                BytecodeManager.incBytecodes(2);
                final BigInteger multiply = bigInteger.multiply(bigInteger2);
                BytecodeManager.incBytecodes(1);
                mutableBigInteger9 = new MutableBigInteger(multiply);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger2.ones(n6);
                final MutableBigInteger mutableBigInteger10 = mutableBigInteger3;
                final MutableBigInteger mutableBigInteger11 = mutableBigInteger5;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger10.add(mutableBigInteger11);
                final MutableBigInteger mutableBigInteger12 = mutableBigInteger5;
                final int n7 = 32 * n;
                BytecodeManager.incBytecodes(5);
                mutableBigInteger12.leftShift(n7);
                final MutableBigInteger mutableBigInteger13 = mutableBigInteger3;
                final MutableBigInteger mutableBigInteger14 = mutableBigInteger5;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger13.subtract(mutableBigInteger14);
                BytecodeManager.incBytecodes(1);
                divide2n1n = mutableBigInteger3;
                BytecodeManager.incBytecodes(2);
                final BigInteger bigInteger3 = lower;
                BytecodeManager.incBytecodes(4);
                mutableBigInteger9 = new MutableBigInteger(bigInteger3);
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger15 = mutableBigInteger9;
                final int n8 = 32 * n;
                BytecodeManager.incBytecodes(5);
                mutableBigInteger15.leftShift(n8);
                final MutableBigInteger mutableBigInteger16 = mutableBigInteger9;
                final BigInteger bigInteger4 = lower;
                BytecodeManager.incBytecodes(5);
                final MutableBigInteger mutableBigInteger17 = new MutableBigInteger(bigInteger4);
                BytecodeManager.incBytecodes(1);
                mutableBigInteger16.subtract(mutableBigInteger17);
                BytecodeManager.incBytecodes(1);
            }
            final MutableBigInteger mutableBigInteger18 = divide2n1n;
            final int n9 = 32 * n;
            BytecodeManager.incBytecodes(5);
            mutableBigInteger18.leftShift(n9);
            final MutableBigInteger mutableBigInteger19 = divide2n1n;
            final int n10 = n;
            BytecodeManager.incBytecodes(4);
            mutableBigInteger19.addLower(this, n10);
            while (true) {
                final MutableBigInteger mutableBigInteger20 = divide2n1n;
                final MutableBigInteger mutableBigInteger21 = mutableBigInteger9;
                BytecodeManager.incBytecodes(3);
                final int compare = mutableBigInteger20.compare(mutableBigInteger21);
                BytecodeManager.incBytecodes(1);
                if (compare >= 0) {
                    break;
                }
                final MutableBigInteger mutableBigInteger22 = divide2n1n;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger22.add(mutableBigInteger);
                final MutableBigInteger one = MutableBigInteger.ONE;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger2.subtract(one);
                BytecodeManager.incBytecodes(2);
            }
            final MutableBigInteger mutableBigInteger23 = divide2n1n;
            final MutableBigInteger mutableBigInteger24 = mutableBigInteger9;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger23.subtract(mutableBigInteger24);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger25 = divide2n1n;
            BytecodeManager.incBytecodes(2);
            return mutableBigInteger25;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private MutableBigInteger getBlock(final int n, final int n2, final int n3) {
        try {
            final int n4 = n * n3;
            BytecodeManager.incBytecodes(4);
            final int n5 = n4;
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(4);
            if (n5 >= intLen) {
                BytecodeManager.incBytecodes(3);
                final MutableBigInteger mutableBigInteger = new MutableBigInteger();
                BytecodeManager.incBytecodes(1);
                return mutableBigInteger;
            }
            final int n6 = n2 - 1;
            BytecodeManager.incBytecodes(5);
            int intLen2;
            if (n == n6) {
                intLen2 = this.intLen;
                BytecodeManager.incBytecodes(4);
            }
            else {
                intLen2 = (n + 1) * n3;
                BytecodeManager.incBytecodes(6);
            }
            final int n7 = intLen2;
            final int intLen3 = this.intLen;
            BytecodeManager.incBytecodes(4);
            if (n7 > intLen3) {
                BytecodeManager.incBytecodes(3);
                final MutableBigInteger mutableBigInteger2 = new MutableBigInteger();
                BytecodeManager.incBytecodes(1);
                return mutableBigInteger2;
            }
            final int[] value = this.value;
            final int n8 = this.offset + this.intLen - intLen2;
            final int n9 = this.offset + this.intLen - n4;
            BytecodeManager.incBytecodes(17);
            final int[] copyOfRange = Arrays.copyOfRange(value, n8, n9);
            BytecodeManager.incBytecodes(1);
            final int[] array = copyOfRange;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(array);
            BytecodeManager.incBytecodes(1);
            return mutableBigInteger3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    long bitLength() {
        try {
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                final long n = 0L;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            final long n2 = this.intLen * 32L;
            final int i = this.value[this.offset];
            BytecodeManager.incBytecodes(11);
            final long n3 = n2 - Integer.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(3);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    long divide(long n, final MutableBigInteger mutableBigInteger) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 == 0) {
                final String s = "BigInteger divide by zero";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                final int n3 = 0;
                mutableBigInteger.offset = n3;
                mutableBigInteger.intLen = n3;
                BytecodeManager.incBytecodes(6);
                final long n4 = 0L;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            final long n5 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n5 < 0) {
                n = -n;
                BytecodeManager.incBytecodes(3);
            }
            final int n6 = (int)(n >>> 32);
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(2);
            mutableBigInteger.clear();
            final int n7 = n6;
            BytecodeManager.incBytecodes(2);
            if (n7 == 0) {
                final int n8 = (int)n;
                BytecodeManager.incBytecodes(5);
                final long n9 = (long)this.divideOneWord(n8, mutableBigInteger) & 0xFFFFFFFFL;
                BytecodeManager.incBytecodes(4);
                return n9;
            }
            final long n10 = n;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divideLongMagnitude = this.divideLongMagnitude(n10, mutableBigInteger);
            BytecodeManager.incBytecodes(1);
            final long long1 = divideLongMagnitude.toLong();
            BytecodeManager.incBytecodes(1);
            return long1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void copyAndShift(final int[] array, int n, final int n2, final int[] array2, final int n3, final int n4) {
        try {
            final int n5 = 32 - n4;
            BytecodeManager.incBytecodes(4);
            int n6 = array[n];
            BytecodeManager.incBytecodes(4);
            int n7 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n8 = n7;
                final int n9 = n2 - 1;
                BytecodeManager.incBytecodes(5);
                if (n8 >= n9) {
                    break;
                }
                final int n10 = n6;
                BytecodeManager.incBytecodes(2);
                n6 = array[++n];
                BytecodeManager.incBytecodes(5);
                array2[n3 + n7] = (n10 << n4 | n6 >>> n5);
                BytecodeManager.incBytecodes(12);
                ++n7;
                BytecodeManager.incBytecodes(2);
            }
            array2[n3 + n2 - 1] = n6 << n4;
            BytecodeManager.incBytecodes(10);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private MutableBigInteger divideMagnitude(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2, final boolean b) {
        try {
            final int i = mutableBigInteger.value[mutableBigInteger.offset];
            BytecodeManager.incBytecodes(6);
            final int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(1);
            final int intLen = mutableBigInteger.intLen;
            BytecodeManager.incBytecodes(3);
            final int n = numberOfLeadingZeros;
            BytecodeManager.incBytecodes(2);
            int[] copyOfRange;
            MutableBigInteger mutableBigInteger3;
            if (n > 0) {
                copyOfRange = new int[intLen];
                BytecodeManager.incBytecodes(2);
                final int[] value = mutableBigInteger.value;
                final int offset = mutableBigInteger.offset;
                final int n2 = intLen;
                final int[] array = copyOfRange;
                final int n3 = 0;
                final int n4 = numberOfLeadingZeros;
                BytecodeManager.incBytecodes(9);
                copyAndShift(value, offset, n2, array, n3, n4);
                final int j = this.value[this.offset];
                BytecodeManager.incBytecodes(6);
                final int numberOfLeadingZeros2 = Integer.numberOfLeadingZeros(j);
                final int n5 = numberOfLeadingZeros;
                BytecodeManager.incBytecodes(2);
                if (numberOfLeadingZeros2 >= n5) {
                    final int[] array2 = new int[this.intLen + 1];
                    BytecodeManager.incBytecodes(5);
                    final int[] array3 = array2;
                    BytecodeManager.incBytecodes(4);
                    mutableBigInteger3 = new MutableBigInteger(array3);
                    BytecodeManager.incBytecodes(1);
                    mutableBigInteger3.intLen = this.intLen;
                    BytecodeManager.incBytecodes(4);
                    mutableBigInteger3.offset = 1;
                    BytecodeManager.incBytecodes(3);
                    final int[] value2 = this.value;
                    final int offset2 = this.offset;
                    final int intLen2 = this.intLen;
                    final int[] array4 = array2;
                    final int n6 = 1;
                    final int n7 = numberOfLeadingZeros;
                    BytecodeManager.incBytecodes(10);
                    copyAndShift(value2, offset2, intLen2, array4, n6, n7);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int[] array5 = new int[this.intLen + 2];
                    BytecodeManager.incBytecodes(5);
                    final int[] array6 = array5;
                    BytecodeManager.incBytecodes(4);
                    mutableBigInteger3 = new MutableBigInteger(array6);
                    BytecodeManager.incBytecodes(1);
                    mutableBigInteger3.intLen = this.intLen + 1;
                    BytecodeManager.incBytecodes(6);
                    mutableBigInteger3.offset = 1;
                    BytecodeManager.incBytecodes(3);
                    int offset3 = this.offset;
                    BytecodeManager.incBytecodes(3);
                    int n8 = 0;
                    BytecodeManager.incBytecodes(2);
                    final int n9 = 32 - numberOfLeadingZeros;
                    BytecodeManager.incBytecodes(4);
                    int n10 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n11 = n10;
                        final int n12 = this.intLen + 1;
                        BytecodeManager.incBytecodes(6);
                        if (n11 >= n12) {
                            break;
                        }
                        final int n13 = n8;
                        BytecodeManager.incBytecodes(2);
                        n8 = this.value[offset3];
                        BytecodeManager.incBytecodes(5);
                        array5[n10] = (n13 << numberOfLeadingZeros | n8 >>> n9);
                        BytecodeManager.incBytecodes(10);
                        ++n10;
                        ++offset3;
                        BytecodeManager.incBytecodes(3);
                    }
                    array5[this.intLen + 1] = n8 << numberOfLeadingZeros;
                    BytecodeManager.incBytecodes(9);
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                final int[] value3 = mutableBigInteger.value;
                final int offset4 = mutableBigInteger.offset;
                final int n14 = mutableBigInteger.offset + mutableBigInteger.intLen;
                BytecodeManager.incBytecodes(10);
                copyOfRange = Arrays.copyOfRange(value3, offset4, n14);
                BytecodeManager.incBytecodes(1);
                final int[] array7 = new int[this.intLen + 1];
                BytecodeManager.incBytecodes(7);
                mutableBigInteger3 = new MutableBigInteger(array7);
                BytecodeManager.incBytecodes(1);
                final int[] value4 = this.value;
                final int offset5 = this.offset;
                final int[] value5 = mutableBigInteger3.value;
                final int n15 = 1;
                final int intLen3 = this.intLen;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(value4, offset5, value5, n15, intLen3);
                mutableBigInteger3.intLen = this.intLen;
                BytecodeManager.incBytecodes(4);
                mutableBigInteger3.offset = 1;
                BytecodeManager.incBytecodes(3);
            }
            final int intLen4 = mutableBigInteger3.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen5 = intLen4 - intLen + 1;
            BytecodeManager.incBytecodes(6);
            final int length = mutableBigInteger2.value.length;
            final int n16 = intLen5;
            BytecodeManager.incBytecodes(5);
            if (length < n16) {
                mutableBigInteger2.value = new int[intLen5];
                BytecodeManager.incBytecodes(3);
                mutableBigInteger2.offset = 0;
                BytecodeManager.incBytecodes(3);
            }
            mutableBigInteger2.intLen = intLen5;
            BytecodeManager.incBytecodes(3);
            final int[] value6 = mutableBigInteger2.value;
            BytecodeManager.incBytecodes(3);
            final int intLen6 = mutableBigInteger3.intLen;
            final int n17 = intLen4;
            BytecodeManager.incBytecodes(4);
            if (intLen6 == n17) {
                mutableBigInteger3.offset = 0;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger3.value[0] = 0;
                BytecodeManager.incBytecodes(5);
                final MutableBigInteger mutableBigInteger4 = mutableBigInteger3;
                ++mutableBigInteger4.intLen;
                BytecodeManager.incBytecodes(6);
            }
            final int n18 = copyOfRange[0];
            BytecodeManager.incBytecodes(4);
            final long n19 = (long)n18 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final int n20 = copyOfRange[1];
            BytecodeManager.incBytecodes(4);
            int n21 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n22 = n21;
                final int n23 = intLen5 - 1;
                BytecodeManager.incBytecodes(5);
                if (n22 >= n23) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                final int n24 = mutableBigInteger3.value[n21 + mutableBigInteger3.offset];
                BytecodeManager.incBytecodes(8);
                final int n25 = n24 + Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(4);
                final int n26 = mutableBigInteger3.value[n21 + 1 + mutableBigInteger3.offset];
                BytecodeManager.incBytecodes(10);
                final int n27 = n24;
                final int n28 = n18;
                BytecodeManager.incBytecodes(3);
                int n29;
                int n30;
                if (n27 == n28) {
                    n29 = -1;
                    BytecodeManager.incBytecodes(2);
                    n30 = n24 + n26;
                    BytecodeManager.incBytecodes(4);
                    final int n31 = n30 + Integer.MIN_VALUE;
                    final int n32 = n25;
                    BytecodeManager.incBytecodes(5);
                    boolean b3;
                    if (n31 < n32) {
                        b3 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b3 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    b2 = b3;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n33 = (long)n24 << 32 | ((long)n26 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(10);
                    final long n34 = lcmp(n33, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n34 >= 0) {
                        n29 = (int)(n33 / n19);
                        BytecodeManager.incBytecodes(5);
                        n30 = (int)(n33 - n29 * n19);
                        BytecodeManager.incBytecodes(9);
                    }
                    else {
                        final long n35 = n33;
                        final int n36 = n18;
                        BytecodeManager.incBytecodes(3);
                        final long divWord = divWord(n35, n36);
                        BytecodeManager.incBytecodes(1);
                        n29 = (int)(divWord & 0xFFFFFFFFL);
                        BytecodeManager.incBytecodes(5);
                        n30 = (int)(divWord >>> 32);
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final int n37 = n29;
                BytecodeManager.incBytecodes(2);
                if (n37 == 0) {
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean b4 = b2;
                    BytecodeManager.incBytecodes(2);
                    if (!b4) {
                        final long n38 = (long)mutableBigInteger3.value[n21 + 2 + mutableBigInteger3.offset] & 0xFFFFFFFFL;
                        BytecodeManager.incBytecodes(13);
                        final long n39 = ((long)n30 & 0xFFFFFFFFL) << 32 | n38;
                        BytecodeManager.incBytecodes(9);
                        final long n40 = ((long)n20 & 0xFFFFFFFFL) * ((long)n29 & 0xFFFFFFFFL);
                        BytecodeManager.incBytecodes(10);
                        final long n41 = n40;
                        final long n42 = n39;
                        BytecodeManager.incBytecodes(4);
                        final boolean unsignedLongCompare = this.unsignedLongCompare(n41, n42);
                        BytecodeManager.incBytecodes(1);
                        if (unsignedLongCompare) {
                            --n29;
                            BytecodeManager.incBytecodes(1);
                            final int n43 = (int)(((long)n30 & 0xFFFFFFFFL) + n19);
                            BytecodeManager.incBytecodes(8);
                            final long n44 = lcmp((long)n43 & 0xFFFFFFFFL, n19);
                            BytecodeManager.incBytecodes(7);
                            if (n44 >= 0) {
                                final long n45 = n40 - ((long)n20 & 0xFFFFFFFFL);
                                BytecodeManager.incBytecodes(7);
                                final long n46 = ((long)n43 & 0xFFFFFFFFL) << 32 | n38;
                                BytecodeManager.incBytecodes(9);
                                final long n47 = n45;
                                final long n48 = n46;
                                BytecodeManager.incBytecodes(4);
                                final boolean unsignedLongCompare2 = this.unsignedLongCompare(n47, n48);
                                BytecodeManager.incBytecodes(1);
                                if (unsignedLongCompare2) {
                                    --n29;
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
                    }
                    mutableBigInteger3.value[n21 + mutableBigInteger3.offset] = 0;
                    BytecodeManager.incBytecodes(8);
                    final int[] value7 = mutableBigInteger3.value;
                    final int[] array8 = copyOfRange;
                    final int n49 = n29;
                    final int n50 = intLen;
                    final int n51 = n21 + mutableBigInteger3.offset;
                    BytecodeManager.incBytecodes(11);
                    final int mulsub = this.mulsub(value7, array8, n49, n50, n51);
                    BytecodeManager.incBytecodes(1);
                    final int n52 = mulsub + Integer.MIN_VALUE;
                    final int n53 = n25;
                    BytecodeManager.incBytecodes(5);
                    if (n52 > n53) {
                        final int[] array9 = copyOfRange;
                        final int[] value8 = mutableBigInteger3.value;
                        final int n54 = n21 + 1 + mutableBigInteger3.offset;
                        BytecodeManager.incBytecodes(11);
                        this.divadd(array9, value8, n54);
                        BytecodeManager.incBytecodes(1);
                        --n29;
                        BytecodeManager.incBytecodes(1);
                    }
                    value6[n21] = n29;
                    BytecodeManager.incBytecodes(4);
                }
                ++n21;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            final int n55 = mutableBigInteger3.value[intLen5 - 1 + mutableBigInteger3.offset];
            BytecodeManager.incBytecodes(10);
            final int n56 = n55 + Integer.MIN_VALUE;
            BytecodeManager.incBytecodes(4);
            final int n57 = mutableBigInteger3.value[intLen5 + mutableBigInteger3.offset];
            BytecodeManager.incBytecodes(8);
            final int n58 = n55;
            final int n59 = n18;
            BytecodeManager.incBytecodes(3);
            int n60;
            int n61;
            if (n58 == n59) {
                n60 = -1;
                BytecodeManager.incBytecodes(2);
                n61 = n55 + n57;
                BytecodeManager.incBytecodes(4);
                final int n62 = n61 + Integer.MIN_VALUE;
                final int n63 = n56;
                BytecodeManager.incBytecodes(5);
                boolean b6;
                if (n62 < n63) {
                    b6 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b6 = false;
                    BytecodeManager.incBytecodes(1);
                }
                b5 = b6;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final long n64 = (long)n55 << 32 | ((long)n57 & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(10);
                final long n65 = lcmp(n64, 0L);
                BytecodeManager.incBytecodes(4);
                if (n65 >= 0) {
                    n60 = (int)(n64 / n19);
                    BytecodeManager.incBytecodes(5);
                    n61 = (int)(n64 - n60 * n19);
                    BytecodeManager.incBytecodes(9);
                }
                else {
                    final long n66 = n64;
                    final int n67 = n18;
                    BytecodeManager.incBytecodes(3);
                    final long divWord2 = divWord(n66, n67);
                    BytecodeManager.incBytecodes(1);
                    n60 = (int)(divWord2 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(5);
                    n61 = (int)(divWord2 >>> 32);
                    BytecodeManager.incBytecodes(5);
                }
            }
            final int n68 = n60;
            BytecodeManager.incBytecodes(2);
            if (n68 != 0) {
                final boolean b7 = b5;
                BytecodeManager.incBytecodes(2);
                if (!b7) {
                    final long n69 = (long)mutableBigInteger3.value[intLen5 + 1 + mutableBigInteger3.offset] & 0xFFFFFFFFL;
                    BytecodeManager.incBytecodes(13);
                    final long n70 = ((long)n61 & 0xFFFFFFFFL) << 32 | n69;
                    BytecodeManager.incBytecodes(9);
                    final long n71 = ((long)n20 & 0xFFFFFFFFL) * ((long)n60 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(10);
                    final long n72 = n71;
                    final long n73 = n70;
                    BytecodeManager.incBytecodes(4);
                    final boolean unsignedLongCompare3 = this.unsignedLongCompare(n72, n73);
                    BytecodeManager.incBytecodes(1);
                    if (unsignedLongCompare3) {
                        --n60;
                        BytecodeManager.incBytecodes(1);
                        final int n74 = (int)(((long)n61 & 0xFFFFFFFFL) + n19);
                        BytecodeManager.incBytecodes(8);
                        final long n75 = lcmp((long)n74 & 0xFFFFFFFFL, n19);
                        BytecodeManager.incBytecodes(7);
                        if (n75 >= 0) {
                            final long n76 = n71 - ((long)n20 & 0xFFFFFFFFL);
                            BytecodeManager.incBytecodes(7);
                            final long n77 = ((long)n74 & 0xFFFFFFFFL) << 32 | n69;
                            BytecodeManager.incBytecodes(9);
                            final long n78 = n76;
                            final long n79 = n77;
                            BytecodeManager.incBytecodes(4);
                            final boolean unsignedLongCompare4 = this.unsignedLongCompare(n78, n79);
                            BytecodeManager.incBytecodes(1);
                            if (unsignedLongCompare4) {
                                --n60;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                }
                mutableBigInteger3.value[intLen5 - 1 + mutableBigInteger3.offset] = 0;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(2);
                int n83;
                if (b) {
                    final int[] value9 = mutableBigInteger3.value;
                    final int[] array10 = copyOfRange;
                    final int n80 = n60;
                    final int n81 = intLen;
                    final int n82 = intLen5 - 1 + mutableBigInteger3.offset;
                    BytecodeManager.incBytecodes(13);
                    n83 = this.mulsub(value9, array10, n80, n81, n82);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int[] value10 = mutableBigInteger3.value;
                    final int[] array11 = copyOfRange;
                    final int n84 = n60;
                    final int n85 = intLen;
                    final int n86 = intLen5 - 1 + mutableBigInteger3.offset;
                    BytecodeManager.incBytecodes(13);
                    n83 = this.mulsubBorrow(value10, array11, n84, n85, n86);
                    BytecodeManager.incBytecodes(1);
                }
                final int n87 = n83 + Integer.MIN_VALUE;
                final int n88 = n56;
                BytecodeManager.incBytecodes(5);
                if (n87 > n88) {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        final int[] array12 = copyOfRange;
                        final int[] value11 = mutableBigInteger3.value;
                        final int n89 = intLen5 - 1 + 1 + mutableBigInteger3.offset;
                        BytecodeManager.incBytecodes(13);
                        this.divadd(array12, value11, n89);
                        BytecodeManager.incBytecodes(1);
                    }
                    --n60;
                    BytecodeManager.incBytecodes(1);
                }
                value6[intLen5 - 1] = n60;
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(2);
            if (b) {
                final int n90 = numberOfLeadingZeros;
                BytecodeManager.incBytecodes(2);
                if (n90 > 0) {
                    final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
                    final int n91 = numberOfLeadingZeros;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger5.rightShift(n91);
                }
                final MutableBigInteger mutableBigInteger6 = mutableBigInteger3;
                BytecodeManager.incBytecodes(2);
                mutableBigInteger6.normalize();
            }
            BytecodeManager.incBytecodes(2);
            mutableBigInteger2.normalize();
            BytecodeManager.incBytecodes(2);
            MutableBigInteger mutableBigInteger7;
            if (b) {
                mutableBigInteger7 = mutableBigInteger3;
                BytecodeManager.incBytecodes(2);
            }
            else {
                mutableBigInteger7 = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return mutableBigInteger7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private MutableBigInteger divideLongMagnitude(long n, final MutableBigInteger mutableBigInteger) {
        try {
            final int[] array = new int[this.intLen + 1];
            BytecodeManager.incBytecodes(7);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(array);
            BytecodeManager.incBytecodes(1);
            final int[] value = this.value;
            final int offset = this.offset;
            final int[] value2 = mutableBigInteger2.value;
            final int n2 = 1;
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(10);
            System.arraycopy(value, offset, value2, n2, intLen);
            mutableBigInteger2.intLen = this.intLen;
            BytecodeManager.incBytecodes(4);
            mutableBigInteger2.offset = 1;
            BytecodeManager.incBytecodes(3);
            final int intLen2 = mutableBigInteger2.intLen;
            BytecodeManager.incBytecodes(3);
            final int intLen3 = intLen2 - 2 + 1;
            BytecodeManager.incBytecodes(6);
            final int length = mutableBigInteger.value.length;
            final int n3 = intLen3;
            BytecodeManager.incBytecodes(5);
            if (length < n3) {
                mutableBigInteger.value = new int[intLen3];
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.offset = 0;
                BytecodeManager.incBytecodes(3);
            }
            mutableBigInteger.intLen = intLen3;
            BytecodeManager.incBytecodes(3);
            final int[] value3 = mutableBigInteger.value;
            BytecodeManager.incBytecodes(3);
            final long i = n;
            BytecodeManager.incBytecodes(2);
            final int numberOfLeadingZeros = Long.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(1);
            final int n4 = numberOfLeadingZeros;
            BytecodeManager.incBytecodes(2);
            if (n4 > 0) {
                n <<= numberOfLeadingZeros;
                BytecodeManager.incBytecodes(4);
                final MutableBigInteger mutableBigInteger3 = mutableBigInteger2;
                final int n5 = numberOfLeadingZeros;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger3.leftShift(n5);
            }
            final int intLen4 = mutableBigInteger2.intLen;
            final int n6 = intLen2;
            BytecodeManager.incBytecodes(4);
            if (intLen4 == n6) {
                mutableBigInteger2.offset = 0;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger2.value[0] = 0;
                BytecodeManager.incBytecodes(5);
                final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
                ++mutableBigInteger4.intLen;
                BytecodeManager.incBytecodes(6);
            }
            final int n7 = (int)(n >>> 32);
            BytecodeManager.incBytecodes(5);
            final long n8 = (long)n7 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final int n9 = (int)(n & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(5);
            int n10 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n11 = n10;
                final int n12 = intLen3;
                BytecodeManager.incBytecodes(3);
                if (n11 >= n12) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                final int n13 = mutableBigInteger2.value[n10 + mutableBigInteger2.offset];
                BytecodeManager.incBytecodes(8);
                final int n14 = n13 + Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(4);
                final int n15 = mutableBigInteger2.value[n10 + 1 + mutableBigInteger2.offset];
                BytecodeManager.incBytecodes(10);
                final int n16 = n13;
                final int n17 = n7;
                BytecodeManager.incBytecodes(3);
                int n18;
                int n19;
                if (n16 == n17) {
                    n18 = -1;
                    BytecodeManager.incBytecodes(2);
                    n19 = n13 + n15;
                    BytecodeManager.incBytecodes(4);
                    final int n20 = n19 + Integer.MIN_VALUE;
                    final int n21 = n14;
                    BytecodeManager.incBytecodes(5);
                    boolean b2;
                    if (n20 < n21) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b2 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    b = b2;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n22 = (long)n13 << 32 | ((long)n15 & 0xFFFFFFFFL);
                    BytecodeManager.incBytecodes(10);
                    final long n23 = lcmp(n22, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n23 >= 0) {
                        n18 = (int)(n22 / n8);
                        BytecodeManager.incBytecodes(5);
                        n19 = (int)(n22 - n18 * n8);
                        BytecodeManager.incBytecodes(9);
                    }
                    else {
                        final long n24 = n22;
                        final int n25 = n7;
                        BytecodeManager.incBytecodes(3);
                        final long divWord = divWord(n24, n25);
                        BytecodeManager.incBytecodes(1);
                        n18 = (int)(divWord & 0xFFFFFFFFL);
                        BytecodeManager.incBytecodes(5);
                        n19 = (int)(divWord >>> 32);
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final int n26 = n18;
                BytecodeManager.incBytecodes(2);
                if (n26 == 0) {
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean b3 = b;
                    BytecodeManager.incBytecodes(2);
                    if (!b3) {
                        final long n27 = (long)mutableBigInteger2.value[n10 + 2 + mutableBigInteger2.offset] & 0xFFFFFFFFL;
                        BytecodeManager.incBytecodes(13);
                        final long n28 = ((long)n19 & 0xFFFFFFFFL) << 32 | n27;
                        BytecodeManager.incBytecodes(9);
                        final long n29 = ((long)n9 & 0xFFFFFFFFL) * ((long)n18 & 0xFFFFFFFFL);
                        BytecodeManager.incBytecodes(10);
                        final long n30 = n29;
                        final long n31 = n28;
                        BytecodeManager.incBytecodes(4);
                        final boolean unsignedLongCompare = this.unsignedLongCompare(n30, n31);
                        BytecodeManager.incBytecodes(1);
                        if (unsignedLongCompare) {
                            --n18;
                            BytecodeManager.incBytecodes(1);
                            final int n32 = (int)(((long)n19 & 0xFFFFFFFFL) + n8);
                            BytecodeManager.incBytecodes(8);
                            final long n33 = lcmp((long)n32 & 0xFFFFFFFFL, n8);
                            BytecodeManager.incBytecodes(7);
                            if (n33 >= 0) {
                                final long n34 = n29 - ((long)n9 & 0xFFFFFFFFL);
                                BytecodeManager.incBytecodes(7);
                                final long n35 = ((long)n32 & 0xFFFFFFFFL) << 32 | n27;
                                BytecodeManager.incBytecodes(9);
                                final long n36 = n34;
                                final long n37 = n35;
                                BytecodeManager.incBytecodes(4);
                                final boolean unsignedLongCompare2 = this.unsignedLongCompare(n36, n37);
                                BytecodeManager.incBytecodes(1);
                                if (unsignedLongCompare2) {
                                    --n18;
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
                    }
                    mutableBigInteger2.value[n10 + mutableBigInteger2.offset] = 0;
                    BytecodeManager.incBytecodes(8);
                    final int[] value4 = mutableBigInteger2.value;
                    final int n38 = n7;
                    final int n39 = n9;
                    final int n40 = n18;
                    final int n41 = n10 + mutableBigInteger2.offset;
                    BytecodeManager.incBytecodes(11);
                    final int mulsubLong = this.mulsubLong(value4, n38, n39, n40, n41);
                    BytecodeManager.incBytecodes(1);
                    final int n42 = mulsubLong + Integer.MIN_VALUE;
                    final int n43 = n14;
                    BytecodeManager.incBytecodes(5);
                    if (n42 > n43) {
                        final int n44 = n7;
                        final int n45 = n9;
                        final int[] value5 = mutableBigInteger2.value;
                        final int n46 = n10 + 1 + mutableBigInteger2.offset;
                        BytecodeManager.incBytecodes(12);
                        this.divaddLong(n44, n45, value5, n46);
                        BytecodeManager.incBytecodes(1);
                        --n18;
                        BytecodeManager.incBytecodes(1);
                    }
                    value3[n10] = n18;
                    BytecodeManager.incBytecodes(4);
                }
                ++n10;
                BytecodeManager.incBytecodes(2);
            }
            final int n47 = numberOfLeadingZeros;
            BytecodeManager.incBytecodes(2);
            if (n47 > 0) {
                final MutableBigInteger mutableBigInteger5 = mutableBigInteger2;
                final int n48 = numberOfLeadingZeros;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger5.rightShift(n48);
            }
            BytecodeManager.incBytecodes(2);
            mutableBigInteger.normalize();
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            mutableBigInteger6.normalize();
            final MutableBigInteger mutableBigInteger7 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            return mutableBigInteger7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int divaddLong(final int n, final int n2, final int[] array, final int n3) {
        try {
            final long n4 = 0L;
            BytecodeManager.incBytecodes(2);
            final long n5 = ((long)n2 & 0xFFFFFFFFL) + ((long)array[1 + n3] & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(14);
            array[1 + n3] = (int)n5;
            BytecodeManager.incBytecodes(7);
            final long n6 = ((long)n & 0xFFFFFFFFL) + ((long)array[n3] & 0xFFFFFFFFL) + n4;
            BytecodeManager.incBytecodes(14);
            array[n3] = (int)n6;
            BytecodeManager.incBytecodes(5);
            final long n7 = n6 >>> 32;
            BytecodeManager.incBytecodes(4);
            final int n8 = (int)n7;
            BytecodeManager.incBytecodes(3);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int mulsubLong(final int[] array, final int n, final int n2, final int n3, int n4) {
        try {
            final long n5 = (long)n3 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            n4 += 2;
            BytecodeManager.incBytecodes(1);
            final long n6 = ((long)n2 & 0xFFFFFFFFL) * n5;
            BytecodeManager.incBytecodes(7);
            final long n7 = array[n4] - n6;
            BytecodeManager.incBytecodes(7);
            array[n4--] = (int)n7;
            BytecodeManager.incBytecodes(6);
            final long n8 = n6 >>> 32;
            final long n9 = lcmp(n7 & 0xFFFFFFFFL, (long)~(int)n6 & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(15);
            int n10;
            if (n9 > 0) {
                n10 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n10 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final long n11 = n8 + n10;
            BytecodeManager.incBytecodes(3);
            final long n12 = ((long)n & 0xFFFFFFFFL) * n5 + n11;
            BytecodeManager.incBytecodes(9);
            final long n13 = array[n4] - n12;
            BytecodeManager.incBytecodes(7);
            array[n4--] = (int)n13;
            BytecodeManager.incBytecodes(6);
            final long n14 = n12 >>> 32;
            final long n15 = lcmp(n13 & 0xFFFFFFFFL, (long)~(int)n12 & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(15);
            int n16;
            if (n15 > 0) {
                n16 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n16 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final long n17 = n14 + n16;
            BytecodeManager.incBytecodes(3);
            final int n18 = (int)n17;
            BytecodeManager.incBytecodes(3);
            return n18;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean unsignedLongCompare(final long n, final long n2) {
        try {
            final long n3 = lcmp(n + Long.MIN_VALUE, n2 + Long.MIN_VALUE);
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n3 > 0) {
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
    
    static long divWord(final long n, final int n2) {
        try {
            final long n3 = (long)n2 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final long n4 = lcmp(n3, 1L);
            BytecodeManager.incBytecodes(4);
            if (n4 == 0) {
                final long n5 = (int)n;
                BytecodeManager.incBytecodes(4);
                final long n6 = 0L;
                BytecodeManager.incBytecodes(2);
                final long n7 = n6 << 32 | (n5 & 0xFFFFFFFFL);
                BytecodeManager.incBytecodes(8);
                return n7;
            }
            long n8 = (n >>> 1) / (n3 >>> 1);
            BytecodeManager.incBytecodes(8);
            long n9 = n - n8 * n3;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final long n10 = lcmp(n9, 0L);
                BytecodeManager.incBytecodes(4);
                if (n10 >= 0) {
                    break;
                }
                n9 += n3;
                BytecodeManager.incBytecodes(4);
                --n8;
                BytecodeManager.incBytecodes(5);
            }
            while (true) {
                final long n11 = lcmp(n9, n3);
                BytecodeManager.incBytecodes(4);
                if (n11 < 0) {
                    break;
                }
                n9 -= n3;
                BytecodeManager.incBytecodes(4);
                ++n8;
                BytecodeManager.incBytecodes(5);
            }
            final long n12 = n9 << 32 | (n8 & 0xFFFFFFFFL);
            BytecodeManager.incBytecodes(8);
            return n12;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger hybridGCD(MutableBigInteger mutableBigInteger) {
        try {
            MutableBigInteger mutableBigInteger2 = this;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int intLen = mutableBigInteger.intLen;
                BytecodeManager.incBytecodes(3);
                if (intLen == 0) {
                    final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
                    BytecodeManager.incBytecodes(2);
                    return mutableBigInteger4;
                }
                final int a = mutableBigInteger2.intLen - mutableBigInteger.intLen;
                BytecodeManager.incBytecodes(6);
                final int abs = Math.abs(a);
                final int n = 2;
                BytecodeManager.incBytecodes(2);
                if (abs < n) {
                    final MutableBigInteger mutableBigInteger5 = mutableBigInteger2;
                    final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
                    BytecodeManager.incBytecodes(3);
                    final MutableBigInteger binaryGCD = mutableBigInteger5.binaryGCD(mutableBigInteger6);
                    BytecodeManager.incBytecodes(1);
                    return binaryGCD;
                }
                final MutableBigInteger mutableBigInteger7 = mutableBigInteger2;
                final MutableBigInteger mutableBigInteger8 = mutableBigInteger;
                final MutableBigInteger mutableBigInteger9 = mutableBigInteger3;
                BytecodeManager.incBytecodes(4);
                final MutableBigInteger divide = mutableBigInteger7.divide(mutableBigInteger8, mutableBigInteger9);
                BytecodeManager.incBytecodes(1);
                mutableBigInteger2 = mutableBigInteger;
                BytecodeManager.incBytecodes(2);
                mutableBigInteger = divide;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private MutableBigInteger binaryGCD(MutableBigInteger mutableBigInteger) {
        try {
            MutableBigInteger mutableBigInteger2 = this;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            final int lowestSetBit = mutableBigInteger4.getLowestSetBit();
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger;
            BytecodeManager.incBytecodes(2);
            final int lowestSetBit2 = mutableBigInteger5.getLowestSetBit();
            BytecodeManager.incBytecodes(1);
            final int n = lowestSetBit;
            final int n2 = lowestSetBit2;
            BytecodeManager.incBytecodes(3);
            int n3;
            if (n < n2) {
                n3 = lowestSetBit;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = lowestSetBit2;
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            final int n5 = n4;
            BytecodeManager.incBytecodes(2);
            if (n5 != 0) {
                final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger6.rightShift(n6);
                final MutableBigInteger mutableBigInteger7 = mutableBigInteger;
                final int n7 = n4;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger7.rightShift(n7);
            }
            final int n8 = n4;
            final int n9 = lowestSetBit;
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
            final int n12 = n11;
            BytecodeManager.incBytecodes(2);
            MutableBigInteger mutableBigInteger8;
            if (n12 != 0) {
                mutableBigInteger8 = mutableBigInteger;
                BytecodeManager.incBytecodes(2);
            }
            else {
                mutableBigInteger8 = mutableBigInteger2;
                BytecodeManager.incBytecodes(1);
            }
            MutableBigInteger mutableBigInteger9 = mutableBigInteger8;
            BytecodeManager.incBytecodes(1);
            final int n13 = n11;
            BytecodeManager.incBytecodes(2);
            int n14;
            if (n13 != 0) {
                n14 = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n14 = 1;
                BytecodeManager.incBytecodes(1);
            }
            int difference = n14;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final MutableBigInteger mutableBigInteger10 = mutableBigInteger9;
                BytecodeManager.incBytecodes(2);
                final int lowestSetBit3 = mutableBigInteger10.getLowestSetBit();
                BytecodeManager.incBytecodes(3);
                if (lowestSetBit3 < 0) {
                    break;
                }
                final MutableBigInteger mutableBigInteger11 = mutableBigInteger9;
                final int n15 = lowestSetBit3;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger11.rightShift(n15);
                final int n16 = difference;
                BytecodeManager.incBytecodes(2);
                if (n16 > 0) {
                    mutableBigInteger2 = mutableBigInteger9;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    mutableBigInteger = mutableBigInteger9;
                    BytecodeManager.incBytecodes(2);
                }
                final int intLen = mutableBigInteger2.intLen;
                final int n17 = 2;
                BytecodeManager.incBytecodes(4);
                if (intLen < n17) {
                    final int intLen2 = mutableBigInteger.intLen;
                    final int n18 = 2;
                    BytecodeManager.incBytecodes(4);
                    if (intLen2 < n18) {
                        final int n19 = mutableBigInteger2.value[mutableBigInteger2.offset];
                        BytecodeManager.incBytecodes(6);
                        final int n20 = mutableBigInteger.value[mutableBigInteger.offset];
                        BytecodeManager.incBytecodes(6);
                        final int n21 = n19;
                        final int n22 = n20;
                        BytecodeManager.incBytecodes(3);
                        final int binaryGcd = binaryGcd(n21, n22);
                        BytecodeManager.incBytecodes(1);
                        mutableBigInteger3.value[0] = binaryGcd;
                        BytecodeManager.incBytecodes(5);
                        mutableBigInteger3.intLen = 1;
                        BytecodeManager.incBytecodes(3);
                        mutableBigInteger3.offset = 0;
                        BytecodeManager.incBytecodes(3);
                        final int n23 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n23 > 0) {
                            final MutableBigInteger mutableBigInteger12 = mutableBigInteger3;
                            final int n24 = n4;
                            BytecodeManager.incBytecodes(3);
                            mutableBigInteger12.leftShift(n24);
                        }
                        final MutableBigInteger mutableBigInteger13 = mutableBigInteger3;
                        BytecodeManager.incBytecodes(2);
                        return mutableBigInteger13;
                    }
                }
                final MutableBigInteger mutableBigInteger14 = mutableBigInteger2;
                final MutableBigInteger mutableBigInteger15 = mutableBigInteger;
                BytecodeManager.incBytecodes(3);
                final int n25 = difference = mutableBigInteger14.difference(mutableBigInteger15);
                BytecodeManager.incBytecodes(3);
                if (n25 == 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final int n26 = difference;
                BytecodeManager.incBytecodes(2);
                MutableBigInteger mutableBigInteger16;
                if (n26 >= 0) {
                    mutableBigInteger16 = mutableBigInteger2;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    mutableBigInteger16 = mutableBigInteger;
                    BytecodeManager.incBytecodes(1);
                }
                mutableBigInteger9 = mutableBigInteger16;
                BytecodeManager.incBytecodes(2);
            }
            final int n27 = n4;
            BytecodeManager.incBytecodes(2);
            if (n27 > 0) {
                final MutableBigInteger mutableBigInteger17 = mutableBigInteger2;
                final int n28 = n4;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger17.leftShift(n28);
            }
            final MutableBigInteger mutableBigInteger18 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            return mutableBigInteger18;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int binaryGcd(int n, int n2) {
        try {
            final boolean b = n2 != 0;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                final int n3 = n;
                BytecodeManager.incBytecodes(2);
                return n3;
            }
            final boolean b2 = n != 0;
            BytecodeManager.incBytecodes(2);
            if (!b2) {
                final int n4 = n2;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            final int i = n;
            BytecodeManager.incBytecodes(2);
            final int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            BytecodeManager.incBytecodes(1);
            final int j = n2;
            BytecodeManager.incBytecodes(2);
            final int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(j);
            BytecodeManager.incBytecodes(1);
            n >>>= numberOfTrailingZeros;
            BytecodeManager.incBytecodes(4);
            n2 >>>= numberOfTrailingZeros2;
            BytecodeManager.incBytecodes(4);
            final int n5 = numberOfTrailingZeros;
            final int n6 = numberOfTrailingZeros2;
            BytecodeManager.incBytecodes(3);
            int n7;
            if (n5 < n6) {
                n7 = numberOfTrailingZeros;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n7 = numberOfTrailingZeros2;
                BytecodeManager.incBytecodes(1);
            }
            final int n8 = n7;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n9 = n;
                final int n10 = n2;
                BytecodeManager.incBytecodes(3);
                if (n9 == n10) {
                    break;
                }
                final int n11 = n + Integer.MIN_VALUE;
                final int n12 = n2 + Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(7);
                if (n11 > n12) {
                    n -= n2;
                    BytecodeManager.incBytecodes(4);
                    final int n13 = n;
                    final int k = n;
                    BytecodeManager.incBytecodes(3);
                    n = n13 >>> Integer.numberOfTrailingZeros(k);
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n2 -= n;
                    BytecodeManager.incBytecodes(4);
                    final int n14 = n2;
                    final int l = n2;
                    BytecodeManager.incBytecodes(3);
                    n2 = n14 >>> Integer.numberOfTrailingZeros(l);
                    BytecodeManager.incBytecodes(3);
                }
            }
            final int n15 = n << n8;
            BytecodeManager.incBytecodes(4);
            return n15;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger mutableModInverse(final MutableBigInteger mutableBigInteger) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean odd = mutableBigInteger.isOdd();
            BytecodeManager.incBytecodes(1);
            if (odd) {
                BytecodeManager.incBytecodes(3);
                final MutableBigInteger modInverse = this.modInverse(mutableBigInteger);
                BytecodeManager.incBytecodes(1);
                return modInverse;
            }
            BytecodeManager.incBytecodes(2);
            final boolean even = this.isEven();
            BytecodeManager.incBytecodes(1);
            if (even) {
                final String s = "BigInteger not invertible.";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int lowestSetBit = mutableBigInteger.getLowestSetBit();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(mutableBigInteger);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger2;
            final int n = lowestSetBit;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger3.rightShift(n);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            final boolean one = mutableBigInteger4.isOne();
            BytecodeManager.incBytecodes(1);
            if (one) {
                final int n2 = lowestSetBit;
                BytecodeManager.incBytecodes(3);
                final MutableBigInteger modInverseMP2 = this.modInverseMP2(n2);
                BytecodeManager.incBytecodes(1);
                return modInverseMP2;
            }
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger2;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger modInverse2 = this.modInverse(mutableBigInteger5);
            BytecodeManager.incBytecodes(1);
            final int n3 = lowestSetBit;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger modInverseMP3 = this.modInverseMP2(n3);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
            final int n4 = lowestSetBit;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger modInverseBP2 = modInverseBP2(mutableBigInteger6, n4);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger7 = mutableBigInteger2;
            final int n5 = lowestSetBit;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger modInverseMP4 = mutableBigInteger7.modInverseMP2(n5);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger8 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger9 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger10 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger11 = modInverse2;
            final int n6 = lowestSetBit;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger11.leftShift(n6);
            final MutableBigInteger mutableBigInteger12 = modInverse2;
            final MutableBigInteger mutableBigInteger13 = modInverseBP2;
            final MutableBigInteger mutableBigInteger14 = mutableBigInteger10;
            BytecodeManager.incBytecodes(4);
            mutableBigInteger12.multiply(mutableBigInteger13, mutableBigInteger14);
            final MutableBigInteger mutableBigInteger15 = modInverseMP3;
            final MutableBigInteger mutableBigInteger16 = mutableBigInteger2;
            final MutableBigInteger mutableBigInteger17 = mutableBigInteger8;
            BytecodeManager.incBytecodes(4);
            mutableBigInteger15.multiply(mutableBigInteger16, mutableBigInteger17);
            final MutableBigInteger mutableBigInteger18 = mutableBigInteger8;
            final MutableBigInteger mutableBigInteger19 = modInverseMP4;
            final MutableBigInteger mutableBigInteger20 = mutableBigInteger9;
            BytecodeManager.incBytecodes(4);
            mutableBigInteger18.multiply(mutableBigInteger19, mutableBigInteger20);
            final MutableBigInteger mutableBigInteger21 = mutableBigInteger10;
            final MutableBigInteger mutableBigInteger22 = mutableBigInteger9;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger21.add(mutableBigInteger22);
            final MutableBigInteger mutableBigInteger23 = mutableBigInteger10;
            final MutableBigInteger mutableBigInteger24 = mutableBigInteger8;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divide = mutableBigInteger23.divide(mutableBigInteger, mutableBigInteger24);
            BytecodeManager.incBytecodes(1);
            return divide;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger modInverseMP2(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean even = this.isEven();
            BytecodeManager.incBytecodes(1);
            if (even) {
                final String s = "Non-invertible. (GCD != 1)";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = 64;
            BytecodeManager.incBytecodes(3);
            if (n > n2) {
                BytecodeManager.incBytecodes(3);
                final MutableBigInteger euclidModInverse = this.euclidModInverse(n);
                BytecodeManager.incBytecodes(1);
                return euclidModInverse;
            }
            final int n3 = this.value[this.offset + this.intLen - 1];
            BytecodeManager.incBytecodes(11);
            final int inverseMod32 = inverseMod32(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = 33;
            BytecodeManager.incBytecodes(3);
            if (n < n4) {
                final int n5 = 32;
                BytecodeManager.incBytecodes(3);
                int n6;
                if (n == n5) {
                    n6 = inverseMod32;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n6 = (inverseMod32 & (1 << n) - 1);
                    BytecodeManager.incBytecodes(7);
                }
                final int n7 = n6;
                BytecodeManager.incBytecodes(1);
                final int n8 = n7;
                BytecodeManager.incBytecodes(4);
                final MutableBigInteger mutableBigInteger = new MutableBigInteger(n8);
                BytecodeManager.incBytecodes(1);
                return mutableBigInteger;
            }
            long n9 = (long)this.value[this.offset + this.intLen - 1] & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(14);
            final int intLen = this.intLen;
            final int n10 = 1;
            BytecodeManager.incBytecodes(4);
            if (intLen > n10) {
                n9 |= (long)this.value[this.offset + this.intLen - 2] << 32;
                BytecodeManager.incBytecodes(16);
            }
            final long n11 = (long)inverseMod32 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            final long n12 = n11 * (2L - n9 * n11);
            BytecodeManager.incBytecodes(8);
            final int n13 = 64;
            BytecodeManager.incBytecodes(3);
            long n14;
            if (n == n13) {
                n14 = n12;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n14 = (n12 & (1L << n) - 1L);
                BytecodeManager.incBytecodes(7);
            }
            final long n15 = n14;
            BytecodeManager.incBytecodes(1);
            final int[] array = new int[2];
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(array);
            BytecodeManager.incBytecodes(1);
            mutableBigInteger2.value[0] = (int)(n15 >>> 32);
            BytecodeManager.incBytecodes(8);
            mutableBigInteger2.value[1] = (int)n15;
            BytecodeManager.incBytecodes(6);
            mutableBigInteger2.intLen = 2;
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            mutableBigInteger3.normalize();
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(2);
            return mutableBigInteger4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int inverseMod32(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n2 = n * (2 - n * n);
            BytecodeManager.incBytecodes(8);
            final int n3 = n2 * (2 - n * n2);
            BytecodeManager.incBytecodes(8);
            final int n4 = n3 * (2 - n * n3);
            BytecodeManager.incBytecodes(8);
            final int n5 = n4 * (2 - n * n4);
            BytecodeManager.incBytecodes(8);
            final int n6 = n5;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static MutableBigInteger modInverseBP2(final MutableBigInteger mutableBigInteger, final int n) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(n2);
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mutableBigInteger);
            BytecodeManager.incBytecodes(2);
            final MutableBigInteger fixup = fixup(mutableBigInteger2, mutableBigInteger3, n);
            BytecodeManager.incBytecodes(1);
            return fixup;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private MutableBigInteger modInverse(final MutableBigInteger mutableBigInteger) {
        try {
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger(mutableBigInteger);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            MutableBigInteger mutableBigInteger3 = new MutableBigInteger(this);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(4);
            MutableBigInteger mutableBigInteger5 = new MutableBigInteger(mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            SignedMutableBigInteger signedMutableBigInteger = new SignedMutableBigInteger(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            SignedMutableBigInteger signedMutableBigInteger2 = new SignedMutableBigInteger();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger3;
            BytecodeManager.incBytecodes(2);
            final boolean even = mutableBigInteger6.isEven();
            BytecodeManager.incBytecodes(1);
            if (even) {
                final MutableBigInteger mutableBigInteger7 = mutableBigInteger3;
                BytecodeManager.incBytecodes(2);
                final int lowestSetBit = mutableBigInteger7.getLowestSetBit();
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger8 = mutableBigInteger3;
                final int n3 = lowestSetBit;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger8.rightShift(n3);
                final SignedMutableBigInteger signedMutableBigInteger3 = signedMutableBigInteger2;
                final int n4 = lowestSetBit;
                BytecodeManager.incBytecodes(3);
                signedMutableBigInteger3.leftShift(n4);
                n2 = lowestSetBit;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                final MutableBigInteger mutableBigInteger9 = mutableBigInteger3;
                BytecodeManager.incBytecodes(2);
                final boolean one = mutableBigInteger9.isOne();
                BytecodeManager.incBytecodes(1);
                if (one) {
                    break;
                }
                final MutableBigInteger mutableBigInteger10 = mutableBigInteger3;
                BytecodeManager.incBytecodes(2);
                final boolean zero = mutableBigInteger10.isZero();
                BytecodeManager.incBytecodes(1);
                if (zero) {
                    final String s = "BigInteger not invertible.";
                    BytecodeManager.incBytecodes(4);
                    final ArithmeticException ex = new ArithmeticException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final MutableBigInteger mutableBigInteger11 = mutableBigInteger3;
                final MutableBigInteger mutableBigInteger12 = mutableBigInteger5;
                BytecodeManager.incBytecodes(3);
                final int compare = mutableBigInteger11.compare(mutableBigInteger12);
                BytecodeManager.incBytecodes(1);
                if (compare < 0) {
                    final MutableBigInteger mutableBigInteger13 = mutableBigInteger3;
                    mutableBigInteger3 = mutableBigInteger5;
                    mutableBigInteger5 = mutableBigInteger13;
                    BytecodeManager.incBytecodes(6);
                    final SignedMutableBigInteger signedMutableBigInteger4 = signedMutableBigInteger2;
                    signedMutableBigInteger2 = signedMutableBigInteger;
                    signedMutableBigInteger = signedMutableBigInteger4;
                    BytecodeManager.incBytecodes(6);
                }
                final int n5 = (mutableBigInteger3.value[mutableBigInteger3.offset + mutableBigInteger3.intLen - 1] ^ mutableBigInteger5.value[mutableBigInteger5.offset + mutableBigInteger5.intLen - 1]) & 0x3;
                BytecodeManager.incBytecodes(24);
                if (n5 == 0) {
                    final MutableBigInteger mutableBigInteger14 = mutableBigInteger3;
                    final MutableBigInteger mutableBigInteger15 = mutableBigInteger5;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger14.subtract(mutableBigInteger15);
                    BytecodeManager.incBytecodes(1);
                    final SignedMutableBigInteger signedMutableBigInteger5 = signedMutableBigInteger;
                    final SignedMutableBigInteger signedMutableBigInteger6 = signedMutableBigInteger2;
                    BytecodeManager.incBytecodes(3);
                    signedMutableBigInteger5.signedSubtract(signedMutableBigInteger6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final MutableBigInteger mutableBigInteger16 = mutableBigInteger3;
                    final MutableBigInteger mutableBigInteger17 = mutableBigInteger5;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger16.add(mutableBigInteger17);
                    final SignedMutableBigInteger signedMutableBigInteger7 = signedMutableBigInteger;
                    final SignedMutableBigInteger signedMutableBigInteger8 = signedMutableBigInteger2;
                    BytecodeManager.incBytecodes(3);
                    signedMutableBigInteger7.signedAdd(signedMutableBigInteger8);
                }
                final MutableBigInteger mutableBigInteger18 = mutableBigInteger3;
                BytecodeManager.incBytecodes(2);
                final int lowestSetBit2 = mutableBigInteger18.getLowestSetBit();
                BytecodeManager.incBytecodes(1);
                final MutableBigInteger mutableBigInteger19 = mutableBigInteger3;
                final int n6 = lowestSetBit2;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger19.rightShift(n6);
                final SignedMutableBigInteger signedMutableBigInteger9 = signedMutableBigInteger2;
                final int n7 = lowestSetBit2;
                BytecodeManager.incBytecodes(3);
                signedMutableBigInteger9.leftShift(n7);
                n2 += lowestSetBit2;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            while (true) {
                final int sign = signedMutableBigInteger.sign;
                BytecodeManager.incBytecodes(3);
                if (sign >= 0) {
                    break;
                }
                final SignedMutableBigInteger signedMutableBigInteger10 = signedMutableBigInteger;
                final MutableBigInteger mutableBigInteger20 = mutableBigInteger2;
                BytecodeManager.incBytecodes(3);
                signedMutableBigInteger10.signedAdd(mutableBigInteger20);
                BytecodeManager.incBytecodes(1);
            }
            final SignedMutableBigInteger signedMutableBigInteger11 = signedMutableBigInteger;
            final MutableBigInteger mutableBigInteger21 = mutableBigInteger2;
            final int n8 = n2;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger fixup = fixup(signedMutableBigInteger11, mutableBigInteger21, n8);
            BytecodeManager.incBytecodes(1);
            return fixup;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static MutableBigInteger fixup(final MutableBigInteger mutableBigInteger, final MutableBigInteger mutableBigInteger2, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final int n2 = mutableBigInteger2.value[mutableBigInteger2.offset + mutableBigInteger2.intLen - 1];
            BytecodeManager.incBytecodes(11);
            final int n3 = -inverseMod32(n2);
            BytecodeManager.incBytecodes(2);
            int n4 = 0;
            final int n5 = n >> 5;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n6 = n4;
                final int n7 = n5;
                BytecodeManager.incBytecodes(3);
                if (n6 >= n7) {
                    break;
                }
                final int n8 = n3 * mutableBigInteger.value[mutableBigInteger.offset + mutableBigInteger.intLen - 1];
                BytecodeManager.incBytecodes(13);
                final int n9 = n8;
                final MutableBigInteger mutableBigInteger4 = mutableBigInteger3;
                BytecodeManager.incBytecodes(4);
                mutableBigInteger2.mul(n9, mutableBigInteger4);
                final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.add(mutableBigInteger5);
                --mutableBigInteger.intLen;
                BytecodeManager.incBytecodes(6);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final int n10 = n & 0x1F;
            BytecodeManager.incBytecodes(4);
            final int n11 = n10;
            BytecodeManager.incBytecodes(2);
            if (n11 != 0) {
                final int n12 = n3 * mutableBigInteger.value[mutableBigInteger.offset + mutableBigInteger.intLen - 1];
                BytecodeManager.incBytecodes(13);
                final int n13 = n12 & (1 << n10) - 1;
                BytecodeManager.incBytecodes(8);
                final int n14 = n13;
                final MutableBigInteger mutableBigInteger6 = mutableBigInteger3;
                BytecodeManager.incBytecodes(4);
                mutableBigInteger2.mul(n14, mutableBigInteger6);
                final MutableBigInteger mutableBigInteger7 = mutableBigInteger3;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.add(mutableBigInteger7);
                final int n15 = n10;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.rightShift(n15);
            }
            while (true) {
                BytecodeManager.incBytecodes(3);
                final int compare = mutableBigInteger.compare(mutableBigInteger2);
                BytecodeManager.incBytecodes(1);
                if (compare < 0) {
                    break;
                }
                BytecodeManager.incBytecodes(3);
                mutableBigInteger.subtract(mutableBigInteger2);
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            return mutableBigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MutableBigInteger euclidModInverse(final int n) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(n2);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger2 = mutableBigInteger;
            BytecodeManager.incBytecodes(3);
            mutableBigInteger2.leftShift(n);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger4 = new MutableBigInteger(mutableBigInteger3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            MutableBigInteger mutableBigInteger5 = new MutableBigInteger(this);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            MutableBigInteger mutableBigInteger6 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger7 = mutableBigInteger;
            final MutableBigInteger mutableBigInteger8 = mutableBigInteger5;
            final MutableBigInteger mutableBigInteger9 = mutableBigInteger6;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divide = mutableBigInteger7.divide(mutableBigInteger8, mutableBigInteger9);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            MutableBigInteger mutableBigInteger10 = divide;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final MutableBigInteger mutableBigInteger11 = mutableBigInteger6;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger12 = new MutableBigInteger(mutableBigInteger11);
            BytecodeManager.incBytecodes(1);
            final int n3 = 1;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger mutableBigInteger13 = new MutableBigInteger(n3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            MutableBigInteger mutableBigInteger14 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final MutableBigInteger mutableBigInteger15 = mutableBigInteger10;
                BytecodeManager.incBytecodes(2);
                final boolean one = mutableBigInteger15.isOne();
                BytecodeManager.incBytecodes(1);
                if (one) {
                    final MutableBigInteger mutableBigInteger16 = mutableBigInteger4;
                    final MutableBigInteger mutableBigInteger17 = mutableBigInteger12;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger16.subtract(mutableBigInteger17);
                    BytecodeManager.incBytecodes(1);
                    final MutableBigInteger mutableBigInteger18 = mutableBigInteger4;
                    BytecodeManager.incBytecodes(2);
                    return mutableBigInteger18;
                }
                final MutableBigInteger mutableBigInteger19 = mutableBigInteger5;
                final MutableBigInteger mutableBigInteger20 = mutableBigInteger10;
                final MutableBigInteger mutableBigInteger21 = mutableBigInteger6;
                BytecodeManager.incBytecodes(4);
                final MutableBigInteger divide2 = mutableBigInteger19.divide(mutableBigInteger20, mutableBigInteger21);
                BytecodeManager.incBytecodes(1);
                final int intLen = divide2.intLen;
                BytecodeManager.incBytecodes(3);
                if (intLen == 0) {
                    final String s = "BigInteger not invertible.";
                    BytecodeManager.incBytecodes(4);
                    final ArithmeticException ex = new ArithmeticException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final MutableBigInteger mutableBigInteger22 = divide2;
                BytecodeManager.incBytecodes(2);
                mutableBigInteger5 = mutableBigInteger22;
                BytecodeManager.incBytecodes(2);
                final int intLen2 = mutableBigInteger6.intLen;
                final int n4 = 1;
                BytecodeManager.incBytecodes(4);
                if (intLen2 == n4) {
                    final MutableBigInteger mutableBigInteger23 = mutableBigInteger12;
                    final int n5 = mutableBigInteger6.value[mutableBigInteger6.offset];
                    final MutableBigInteger mutableBigInteger24 = mutableBigInteger14;
                    BytecodeManager.incBytecodes(8);
                    mutableBigInteger23.mul(n5, mutableBigInteger24);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final MutableBigInteger mutableBigInteger25 = mutableBigInteger6;
                    final MutableBigInteger mutableBigInteger26 = mutableBigInteger12;
                    final MutableBigInteger mutableBigInteger27 = mutableBigInteger14;
                    BytecodeManager.incBytecodes(4);
                    mutableBigInteger25.multiply(mutableBigInteger26, mutableBigInteger27);
                }
                final MutableBigInteger mutableBigInteger28 = mutableBigInteger6;
                BytecodeManager.incBytecodes(2);
                final MutableBigInteger mutableBigInteger29 = mutableBigInteger14;
                BytecodeManager.incBytecodes(2);
                final MutableBigInteger mutableBigInteger30 = mutableBigInteger28;
                BytecodeManager.incBytecodes(2);
                final MutableBigInteger mutableBigInteger31 = mutableBigInteger13;
                final MutableBigInteger mutableBigInteger32 = mutableBigInteger29;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger31.add(mutableBigInteger32);
                final MutableBigInteger mutableBigInteger33 = mutableBigInteger5;
                BytecodeManager.incBytecodes(2);
                final boolean one2 = mutableBigInteger33.isOne();
                BytecodeManager.incBytecodes(1);
                if (one2) {
                    final MutableBigInteger mutableBigInteger34 = mutableBigInteger13;
                    BytecodeManager.incBytecodes(2);
                    return mutableBigInteger34;
                }
                final MutableBigInteger mutableBigInteger35 = mutableBigInteger10;
                final MutableBigInteger mutableBigInteger36 = mutableBigInteger5;
                final MutableBigInteger mutableBigInteger37 = mutableBigInteger29;
                BytecodeManager.incBytecodes(4);
                final MutableBigInteger divide3 = mutableBigInteger35.divide(mutableBigInteger36, mutableBigInteger37);
                BytecodeManager.incBytecodes(1);
                final int intLen3 = divide3.intLen;
                BytecodeManager.incBytecodes(3);
                if (intLen3 == 0) {
                    final String s2 = "BigInteger not invertible.";
                    BytecodeManager.incBytecodes(4);
                    final ArithmeticException ex2 = new ArithmeticException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(2);
                mutableBigInteger10 = divide3;
                BytecodeManager.incBytecodes(2);
                final int intLen4 = mutableBigInteger29.intLen;
                final int n6 = 1;
                BytecodeManager.incBytecodes(4);
                if (intLen4 == n6) {
                    final MutableBigInteger mutableBigInteger38 = mutableBigInteger13;
                    final int n7 = mutableBigInteger29.value[mutableBigInteger29.offset];
                    final MutableBigInteger mutableBigInteger39 = mutableBigInteger30;
                    BytecodeManager.incBytecodes(8);
                    mutableBigInteger38.mul(n7, mutableBigInteger39);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final MutableBigInteger mutableBigInteger40 = mutableBigInteger29;
                    final MutableBigInteger mutableBigInteger41 = mutableBigInteger13;
                    final MutableBigInteger mutableBigInteger42 = mutableBigInteger30;
                    BytecodeManager.incBytecodes(4);
                    mutableBigInteger40.multiply(mutableBigInteger41, mutableBigInteger42);
                }
                final MutableBigInteger mutableBigInteger43 = mutableBigInteger29;
                mutableBigInteger6 = mutableBigInteger30;
                mutableBigInteger14 = mutableBigInteger43;
                BytecodeManager.incBytecodes(6);
                final MutableBigInteger mutableBigInteger44 = mutableBigInteger12;
                final MutableBigInteger mutableBigInteger45 = mutableBigInteger6;
                BytecodeManager.incBytecodes(3);
                mutableBigInteger44.add(mutableBigInteger45);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<MutableBigInteger> clazz = MutableBigInteger.class;
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
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            ONE = new MutableBigInteger(n);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
