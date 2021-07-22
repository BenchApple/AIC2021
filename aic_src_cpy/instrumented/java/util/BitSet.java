// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Supplier;
import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.stream.IntStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import aic2021.engine.BytecodeManager;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class BitSet implements Cloneable, Serializable
{
    private static final int ADDRESS_BITS_PER_WORD = 6;
    private static final int BITS_PER_WORD = 64;
    private static final int BIT_INDEX_MASK = 63;
    private static final long WORD_MASK = -1L;
    private static final ObjectStreamField[] serialPersistentFields;
    private long[] words;
    private transient int wordsInUse;
    private transient boolean sizeIsSticky;
    private static final long serialVersionUID = 7997698588986878753L;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private static int wordIndex(final int n) {
        try {
            final int n2 = n >> 6;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void checkInvariants() {
        try {
            final boolean $assertionsDisabled = BitSet.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int wordsInUse = this.wordsInUse;
                BytecodeManager.incBytecodes(3);
                if (wordsInUse != 0) {
                    final long n = lcmp(this.words[this.wordsInUse - 1], 0L);
                    BytecodeManager.incBytecodes(10);
                    if (n == 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
            }
            final boolean $assertionsDisabled2 = BitSet.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0120: {
                if (!$assertionsDisabled2) {
                    final int wordsInUse2 = this.wordsInUse;
                    BytecodeManager.incBytecodes(3);
                    if (wordsInUse2 >= 0) {
                        final int wordsInUse3 = this.wordsInUse;
                        final int length = this.words.length;
                        BytecodeManager.incBytecodes(6);
                        if (wordsInUse3 <= length) {
                            break Label_0120;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            final boolean $assertionsDisabled3 = BitSet.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled3) {
                final int wordsInUse4 = this.wordsInUse;
                final int length2 = this.words.length;
                BytecodeManager.incBytecodes(6);
                if (wordsInUse4 != length2) {
                    final long n2 = lcmp(this.words[this.wordsInUse], 0L);
                    BytecodeManager.incBytecodes(8);
                    if (n2 != 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError3 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError3;
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void recalculateWordsInUse() {
        try {
            int n = this.wordsInUse - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    break;
                }
                final long n3 = lcmp(this.words[n], 0L);
                BytecodeManager.incBytecodes(7);
                if (n3 != 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                --n;
                BytecodeManager.incBytecodes(2);
            }
            this.wordsInUse = n + 1;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BitSet() {
        try {
            BytecodeManager.incBytecodes(2);
            this.wordsInUse = 0;
            BytecodeManager.incBytecodes(3);
            this.sizeIsSticky = false;
            BytecodeManager.incBytecodes(3);
            final int n = 64;
            BytecodeManager.incBytecodes(3);
            this.initWords(n);
            this.sizeIsSticky = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BitSet(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            this.wordsInUse = 0;
            BytecodeManager.incBytecodes(3);
            this.sizeIsSticky = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "nbits < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final NegativeArraySizeException ex = new NegativeArraySizeException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            this.initWords(i);
            this.sizeIsSticky = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void initWords(final int n) {
        try {
            final int n2 = n - 1;
            BytecodeManager.incBytecodes(5);
            this.words = new long[wordIndex(n2) + 1];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BitSet(final long[] words) {
        try {
            BytecodeManager.incBytecodes(2);
            this.wordsInUse = 0;
            BytecodeManager.incBytecodes(3);
            this.sizeIsSticky = false;
            BytecodeManager.incBytecodes(3);
            this.words = words;
            BytecodeManager.incBytecodes(3);
            this.wordsInUse = words.length;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BitSet valueOf(final long[] array) {
        try {
            int length = array.length;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n = length;
                BytecodeManager.incBytecodes(2);
                if (n <= 0) {
                    break;
                }
                final long n2 = lcmp(array[length - 1], 0L);
                BytecodeManager.incBytecodes(8);
                if (n2 != 0) {
                    break;
                }
                --length;
                BytecodeManager.incBytecodes(2);
            }
            final int n3 = length;
            BytecodeManager.incBytecodes(5);
            final long[] copy = Arrays.copyOf(array, n3);
            BytecodeManager.incBytecodes(1);
            final BitSet set = new BitSet(copy);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BitSet valueOf(LongBuffer slice) {
        try {
            final LongBuffer longBuffer = slice;
            BytecodeManager.incBytecodes(2);
            slice = longBuffer.slice();
            BytecodeManager.incBytecodes(1);
            final LongBuffer longBuffer2 = slice;
            BytecodeManager.incBytecodes(2);
            int remaining = longBuffer2.remaining();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n = remaining;
                BytecodeManager.incBytecodes(2);
                if (n <= 0) {
                    break;
                }
                final LongBuffer longBuffer3 = slice;
                final int n2 = remaining - 1;
                BytecodeManager.incBytecodes(5);
                final long n3 = lcmp(longBuffer3.get(n2), 0L);
                BytecodeManager.incBytecodes(3);
                if (n3 != 0) {
                    break;
                }
                --remaining;
                BytecodeManager.incBytecodes(2);
            }
            final long[] array = new long[remaining];
            BytecodeManager.incBytecodes(2);
            final LongBuffer longBuffer4 = slice;
            final long[] dst = array;
            BytecodeManager.incBytecodes(3);
            longBuffer4.get(dst);
            BytecodeManager.incBytecodes(1);
            final long[] array2 = array;
            BytecodeManager.incBytecodes(4);
            final BitSet set = new BitSet(array2);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BitSet valueOf(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final ByteBuffer wrap = ByteBuffer.wrap(array);
            BytecodeManager.incBytecodes(1);
            final BitSet value = valueOf(wrap);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BitSet valueOf(ByteBuffer order) {
        try {
            final ByteBuffer byteBuffer = order;
            BytecodeManager.incBytecodes(2);
            final ByteBuffer slice = byteBuffer.slice();
            final ByteOrder little_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            BytecodeManager.incBytecodes(2);
            order = slice.order(little_ENDIAN);
            BytecodeManager.incBytecodes(1);
            final ByteBuffer byteBuffer2 = order;
            BytecodeManager.incBytecodes(2);
            int remaining = byteBuffer2.remaining();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n = remaining;
                BytecodeManager.incBytecodes(2);
                if (n <= 0) {
                    break;
                }
                final ByteBuffer byteBuffer3 = order;
                final int n2 = remaining - 1;
                BytecodeManager.incBytecodes(5);
                final byte value = byteBuffer3.get(n2);
                BytecodeManager.incBytecodes(1);
                if (value != 0) {
                    break;
                }
                --remaining;
                BytecodeManager.incBytecodes(2);
            }
            final long[] array = new long[(remaining + 7) / 8];
            BytecodeManager.incBytecodes(6);
            final ByteBuffer byteBuffer4 = order;
            final int n3 = remaining;
            BytecodeManager.incBytecodes(3);
            byteBuffer4.limit(n3);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final ByteBuffer byteBuffer5 = order;
                BytecodeManager.incBytecodes(2);
                final int remaining2 = byteBuffer5.remaining();
                final int n5 = 8;
                BytecodeManager.incBytecodes(2);
                if (remaining2 < n5) {
                    break;
                }
                final long[] array2 = array;
                final int n6 = n4++;
                final ByteBuffer byteBuffer6 = order;
                BytecodeManager.incBytecodes(5);
                array2[n6] = byteBuffer6.getLong();
                BytecodeManager.incBytecodes(2);
            }
            final ByteBuffer byteBuffer7 = order;
            BytecodeManager.incBytecodes(2);
            final int remaining3 = byteBuffer7.remaining();
            int n7 = 0;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n8 = n7;
                final int n9 = remaining3;
                BytecodeManager.incBytecodes(3);
                if (n8 >= n9) {
                    break;
                }
                final long[] array3 = array;
                final int n10 = n4;
                final long n11 = array3[n10];
                final ByteBuffer byteBuffer8 = order;
                BytecodeManager.incBytecodes(6);
                array3[n10] = (n11 | ((long)byteBuffer8.get() & 0xFFL) << 8 * n7);
                BytecodeManager.incBytecodes(9);
                ++n7;
                BytecodeManager.incBytecodes(2);
            }
            final long[] array4 = array;
            BytecodeManager.incBytecodes(4);
            final BitSet set = new BitSet(array4);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public byte[] toByteArray() {
        try {
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(3);
            final int n = wordsInUse;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final byte[] array = new byte[0];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            int n2 = 8 * (wordsInUse - 1);
            BytecodeManager.incBytecodes(6);
            long n3 = this.words[wordsInUse - 1];
            BytecodeManager.incBytecodes(7);
            while (true) {
                final long n4 = lcmp(n3, 0L);
                BytecodeManager.incBytecodes(4);
                if (n4 == 0) {
                    break;
                }
                ++n2;
                BytecodeManager.incBytecodes(1);
                n3 >>>= 8;
                BytecodeManager.incBytecodes(5);
            }
            final byte[] array2 = new byte[n2];
            BytecodeManager.incBytecodes(2);
            final byte[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            final ByteBuffer wrap = ByteBuffer.wrap(array3);
            final ByteOrder little_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            BytecodeManager.incBytecodes(2);
            final ByteBuffer order = wrap.order(little_ENDIAN);
            BytecodeManager.incBytecodes(1);
            int n5 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                final int n7 = wordsInUse - 1;
                BytecodeManager.incBytecodes(5);
                if (n6 >= n7) {
                    break;
                }
                final ByteBuffer byteBuffer = order;
                final long n8 = this.words[n5];
                BytecodeManager.incBytecodes(6);
                byteBuffer.putLong(n8);
                BytecodeManager.incBytecodes(1);
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            long n9 = this.words[wordsInUse - 1];
            BytecodeManager.incBytecodes(7);
            while (true) {
                final long n10 = lcmp(n9, 0L);
                BytecodeManager.incBytecodes(4);
                if (n10 == 0) {
                    break;
                }
                final ByteBuffer byteBuffer2 = order;
                final byte b = (byte)(n9 & 0xFFL);
                BytecodeManager.incBytecodes(7);
                byteBuffer2.put(b);
                BytecodeManager.incBytecodes(1);
                n9 >>>= 8;
                BytecodeManager.incBytecodes(5);
            }
            final byte[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long[] toLongArray() {
        try {
            final long[] words = this.words;
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(5);
            final long[] copy = Arrays.copyOf(words, wordsInUse);
            BytecodeManager.incBytecodes(1);
            return copy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ensureCapacity(final int b) {
        try {
            final int length = this.words.length;
            BytecodeManager.incBytecodes(5);
            if (length < b) {
                final int a = 2 * this.words.length;
                BytecodeManager.incBytecodes(7);
                final int max = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
                final long[] words = this.words;
                final int n = max;
                BytecodeManager.incBytecodes(5);
                this.words = Arrays.copyOf(words, n);
                BytecodeManager.incBytecodes(1);
                this.sizeIsSticky = false;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void expandTo(final int n) {
        try {
            final int wordsInUse = n + 1;
            BytecodeManager.incBytecodes(4);
            final int wordsInUse2 = this.wordsInUse;
            final int n2 = wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (wordsInUse2 < n2) {
                final int n3 = wordsInUse;
                BytecodeManager.incBytecodes(3);
                this.ensureCapacity(n3);
                this.wordsInUse = wordsInUse;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void checkRange(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(n);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "toIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(n2);
                BytecodeManager.incBytecodes(1);
                final String string2 = append4.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            if (n > n2) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb3 = new StringBuilder();
                final String str3 = "fromIndex: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = sb3.append(str3);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = append5.append(n);
                final String str4 = " > toIndex: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str4);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(n2);
                BytecodeManager.incBytecodes(1);
                final String string3 = append8.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex3 = new IndexOutOfBoundsException(string3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void flip(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "bitIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int wordIndex = wordIndex(i);
            BytecodeManager.incBytecodes(1);
            final int n = wordIndex;
            BytecodeManager.incBytecodes(3);
            this.expandTo(n);
            final long[] words = this.words;
            final int n2 = wordIndex;
            words[n2] ^= 1L << i;
            BytecodeManager.incBytecodes(10);
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void flip(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            checkRange(n, n2);
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            final int wordIndex = wordIndex(n);
            BytecodeManager.incBytecodes(1);
            final int n3 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            final int wordIndex2 = wordIndex(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = wordIndex2;
            BytecodeManager.incBytecodes(3);
            this.expandTo(n4);
            final long n5 = -1L << n;
            BytecodeManager.incBytecodes(4);
            final long n6 = -1L >>> -n2;
            BytecodeManager.incBytecodes(5);
            final int n7 = wordIndex;
            final int n8 = wordIndex2;
            BytecodeManager.incBytecodes(3);
            if (n7 == n8) {
                final long[] words = this.words;
                final int n9 = wordIndex;
                words[n9] ^= (n5 & n6);
                BytecodeManager.incBytecodes(11);
            }
            else {
                final long[] words2 = this.words;
                final int n10 = wordIndex;
                words2[n10] ^= n5;
                BytecodeManager.incBytecodes(8);
                int n11 = wordIndex + 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n12 = n11;
                    final int n13 = wordIndex2;
                    BytecodeManager.incBytecodes(3);
                    if (n12 >= n13) {
                        break;
                    }
                    final long[] words3 = this.words;
                    final int n14 = n11;
                    words3[n14] ^= -1L;
                    BytecodeManager.incBytecodes(8);
                    ++n11;
                    BytecodeManager.incBytecodes(2);
                }
                final long[] words4 = this.words;
                final int n15 = wordIndex2;
                words4[n15] ^= n6;
                BytecodeManager.incBytecodes(8);
            }
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void set(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "bitIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int wordIndex = wordIndex(i);
            BytecodeManager.incBytecodes(1);
            final int n = wordIndex;
            BytecodeManager.incBytecodes(3);
            this.expandTo(n);
            final long[] words = this.words;
            final int n2 = wordIndex;
            words[n2] |= 1L << i;
            BytecodeManager.incBytecodes(10);
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void set(final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (b) {
                BytecodeManager.incBytecodes(3);
                this.set(n);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.clear(n);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void set(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            checkRange(n, n2);
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            final int wordIndex = wordIndex(n);
            BytecodeManager.incBytecodes(1);
            final int n3 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            final int wordIndex2 = wordIndex(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = wordIndex2;
            BytecodeManager.incBytecodes(3);
            this.expandTo(n4);
            final long n5 = -1L << n;
            BytecodeManager.incBytecodes(4);
            final long n6 = -1L >>> -n2;
            BytecodeManager.incBytecodes(5);
            final int n7 = wordIndex;
            final int n8 = wordIndex2;
            BytecodeManager.incBytecodes(3);
            if (n7 == n8) {
                final long[] words = this.words;
                final int n9 = wordIndex;
                words[n9] |= (n5 & n6);
                BytecodeManager.incBytecodes(11);
            }
            else {
                final long[] words2 = this.words;
                final int n10 = wordIndex;
                words2[n10] |= n5;
                BytecodeManager.incBytecodes(8);
                int n11 = wordIndex + 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n12 = n11;
                    final int n13 = wordIndex2;
                    BytecodeManager.incBytecodes(3);
                    if (n12 >= n13) {
                        break;
                    }
                    this.words[n11] = -1L;
                    BytecodeManager.incBytecodes(5);
                    ++n11;
                    BytecodeManager.incBytecodes(2);
                }
                final long[] words3 = this.words;
                final int n14 = wordIndex2;
                words3[n14] |= n6;
                BytecodeManager.incBytecodes(8);
            }
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void set(final int n, final int n2, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (b) {
                BytecodeManager.incBytecodes(4);
                this.set(n, n2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(4);
                this.clear(n, n2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void clear(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "bitIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int wordIndex = wordIndex(i);
            BytecodeManager.incBytecodes(1);
            final int n = wordIndex;
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (n >= wordsInUse) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final long[] words = this.words;
            final int n2 = wordIndex;
            words[n2] &= ~(1L << i);
            BytecodeManager.incBytecodes(12);
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void clear(final int n, int length) {
        try {
            final int n2 = length;
            BytecodeManager.incBytecodes(3);
            checkRange(n, n2);
            final int n3 = length;
            BytecodeManager.incBytecodes(3);
            if (n == n3) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            final int wordIndex = wordIndex(n);
            BytecodeManager.incBytecodes(1);
            final int n4 = wordIndex;
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (n4 >= wordsInUse) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n5 = length - 1;
            BytecodeManager.incBytecodes(4);
            int wordIndex2 = wordIndex(n5);
            BytecodeManager.incBytecodes(1);
            final int n6 = wordIndex2;
            final int wordsInUse2 = this.wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (n6 >= wordsInUse2) {
                BytecodeManager.incBytecodes(2);
                length = this.length();
                BytecodeManager.incBytecodes(1);
                wordIndex2 = this.wordsInUse - 1;
                BytecodeManager.incBytecodes(5);
            }
            final long n7 = -1L << n;
            BytecodeManager.incBytecodes(4);
            final long n8 = -1L >>> -length;
            BytecodeManager.incBytecodes(5);
            final int n9 = wordIndex;
            final int n10 = wordIndex2;
            BytecodeManager.incBytecodes(3);
            if (n9 == n10) {
                final long[] words = this.words;
                final int n11 = wordIndex;
                words[n11] &= ~(n7 & n8);
                BytecodeManager.incBytecodes(13);
            }
            else {
                final long[] words2 = this.words;
                final int n12 = wordIndex;
                words2[n12] &= ~n7;
                BytecodeManager.incBytecodes(10);
                int n13 = wordIndex + 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n14 = n13;
                    final int n15 = wordIndex2;
                    BytecodeManager.incBytecodes(3);
                    if (n14 >= n15) {
                        break;
                    }
                    this.words[n13] = 0L;
                    BytecodeManager.incBytecodes(5);
                    ++n13;
                    BytecodeManager.incBytecodes(2);
                }
                final long[] words3 = this.words;
                final int n16 = wordIndex2;
                words3[n16] &= ~n8;
                BytecodeManager.incBytecodes(10);
            }
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void clear() {
        try {
            while (true) {
                final int wordsInUse = this.wordsInUse;
                BytecodeManager.incBytecodes(3);
                if (wordsInUse <= 0) {
                    break;
                }
                this.words[--this.wordsInUse] = 0L;
                BytecodeManager.incBytecodes(12);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean get(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "bitIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(2);
            final int wordIndex = wordIndex(i);
            BytecodeManager.incBytecodes(1);
            final int n = wordIndex;
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(4);
            boolean b = false;
            Label_0138: {
                if (n < wordsInUse) {
                    final long n2 = lcmp(this.words[wordIndex] & 1L << i, 0L);
                    BytecodeManager.incBytecodes(11);
                    if (n2 != 0) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0138;
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
    
    public BitSet get(final int n, int n2) {
        try {
            final int n3 = n2;
            BytecodeManager.incBytecodes(3);
            checkRange(n, n3);
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(2);
            final int length = this.length();
            BytecodeManager.incBytecodes(1);
            final int n4 = length;
            BytecodeManager.incBytecodes(3);
            if (n4 > n) {
                final int n5 = n2;
                BytecodeManager.incBytecodes(3);
                if (n != n5) {
                    final int n6 = n2;
                    final int n7 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n6 > n7) {
                        n2 = length;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n8 = n2 - n;
                    BytecodeManager.incBytecodes(6);
                    final BitSet set = new BitSet(n8);
                    BytecodeManager.incBytecodes(1);
                    final int n9 = n2 - n - 1;
                    BytecodeManager.incBytecodes(6);
                    final int wordsInUse = wordIndex(n9) + 1;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    int wordIndex = wordIndex(n);
                    BytecodeManager.incBytecodes(1);
                    final int n10 = n & 0x3F;
                    BytecodeManager.incBytecodes(4);
                    int n11;
                    if (n10 == 0) {
                        n11 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n11 = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n12 = n11;
                    BytecodeManager.incBytecodes(1);
                    int n13 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n14 = n13;
                        final int n15 = wordsInUse - 1;
                        BytecodeManager.incBytecodes(5);
                        if (n14 >= n15) {
                            break;
                        }
                        final long[] words = set.words;
                        final int n16 = n13;
                        final int n17 = n12;
                        BytecodeManager.incBytecodes(5);
                        long n18;
                        if (n17 != 0) {
                            n18 = this.words[wordIndex];
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            n18 = (this.words[wordIndex] >>> n | this.words[wordIndex + 1] << -n);
                            BytecodeManager.incBytecodes(16);
                        }
                        words[n16] = n18;
                        BytecodeManager.incBytecodes(1);
                        ++n13;
                        ++wordIndex;
                        BytecodeManager.incBytecodes(3);
                    }
                    final long n19 = -1L >>> -n2;
                    BytecodeManager.incBytecodes(5);
                    final long[] words2 = set.words;
                    final int n20 = wordsInUse - 1;
                    final int n21 = n2 - 1 & 0x3F;
                    final int n22 = n & 0x3F;
                    BytecodeManager.incBytecodes(14);
                    long n23;
                    if (n21 < n22) {
                        n23 = (this.words[wordIndex] >>> n | (this.words[wordIndex + 1] & n19) << -n);
                        BytecodeManager.incBytecodes(19);
                    }
                    else {
                        n23 = (this.words[wordIndex] & n19) >>> n;
                        BytecodeManager.incBytecodes(8);
                    }
                    words2[n20] = n23;
                    BytecodeManager.incBytecodes(1);
                    set.wordsInUse = wordsInUse;
                    BytecodeManager.incBytecodes(3);
                    final BitSet set2 = set;
                    BytecodeManager.incBytecodes(2);
                    set2.recalculateWordsInUse();
                    final BitSet set3 = set;
                    BytecodeManager.incBytecodes(2);
                    set3.checkInvariants();
                    final BitSet set4 = set;
                    BytecodeManager.incBytecodes(2);
                    return set4;
                }
            }
            final int n24 = 0;
            BytecodeManager.incBytecodes(4);
            final BitSet set5 = new BitSet(n24);
            BytecodeManager.incBytecodes(1);
            return set5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextSetBit(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(2);
            int wordIndex = wordIndex(i);
            BytecodeManager.incBytecodes(1);
            final int n = wordIndex;
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (n >= wordsInUse) {
                final int n2 = -1;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            long n3 = this.words[wordIndex] & -1L << i;
            BytecodeManager.incBytecodes(9);
            while (true) {
                final long n4 = lcmp(n3, 0L);
                BytecodeManager.incBytecodes(4);
                if (n4 != 0) {
                    final int n5 = wordIndex * 64;
                    final long j = n3;
                    BytecodeManager.incBytecodes(5);
                    final int n6 = n5 + Long.numberOfTrailingZeros(j);
                    BytecodeManager.incBytecodes(2);
                    return n6;
                }
                final int n7 = ++wordIndex;
                final int wordsInUse2 = this.wordsInUse;
                BytecodeManager.incBytecodes(5);
                if (n7 == wordsInUse2) {
                    final int n8 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n8;
                }
                n3 = this.words[wordIndex];
                BytecodeManager.incBytecodes(6);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextClearBit(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex < 0: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(2);
            int wordIndex = wordIndex(i);
            BytecodeManager.incBytecodes(1);
            final int n = wordIndex;
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (n >= wordsInUse) {
                BytecodeManager.incBytecodes(2);
                return i;
            }
            long n2 = ~this.words[wordIndex] & -1L << i;
            BytecodeManager.incBytecodes(11);
            while (true) {
                final long n3 = lcmp(n2, 0L);
                BytecodeManager.incBytecodes(4);
                if (n3 != 0) {
                    final int n4 = wordIndex * 64;
                    final long j = n2;
                    BytecodeManager.incBytecodes(5);
                    final int n5 = n4 + Long.numberOfTrailingZeros(j);
                    BytecodeManager.incBytecodes(2);
                    return n5;
                }
                final int n6 = ++wordIndex;
                final int wordsInUse2 = this.wordsInUse;
                BytecodeManager.incBytecodes(5);
                if (n6 == wordsInUse2) {
                    final int n7 = this.wordsInUse * 64;
                    BytecodeManager.incBytecodes(5);
                    return n7;
                }
                n2 = ~this.words[wordIndex];
                BytecodeManager.incBytecodes(8);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int previousSetBit(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                final int n = -1;
                BytecodeManager.incBytecodes(3);
                if (i == n) {
                    final int n2 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n2;
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex < -1: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            else {
                BytecodeManager.incBytecodes(2);
                this.checkInvariants();
                BytecodeManager.incBytecodes(2);
                int wordIndex = wordIndex(i);
                BytecodeManager.incBytecodes(1);
                final int n3 = wordIndex;
                final int wordsInUse = this.wordsInUse;
                BytecodeManager.incBytecodes(4);
                if (n3 >= wordsInUse) {
                    BytecodeManager.incBytecodes(2);
                    final int n4 = this.length() - 1;
                    BytecodeManager.incBytecodes(3);
                    return n4;
                }
                long n5 = this.words[wordIndex] & -1L >>> -(i + 1);
                BytecodeManager.incBytecodes(12);
                while (true) {
                    final long n6 = lcmp(n5, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n6 != 0) {
                        final int n7 = (wordIndex + 1) * 64 - 1;
                        final long j = n5;
                        BytecodeManager.incBytecodes(9);
                        final int n8 = n7 - Long.numberOfLeadingZeros(j);
                        BytecodeManager.incBytecodes(2);
                        return n8;
                    }
                    final int n9 = wordIndex--;
                    BytecodeManager.incBytecodes(3);
                    if (n9 == 0) {
                        final int n10 = -1;
                        BytecodeManager.incBytecodes(2);
                        return n10;
                    }
                    n5 = this.words[wordIndex];
                    BytecodeManager.incBytecodes(6);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int previousClearBit(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                final int n = -1;
                BytecodeManager.incBytecodes(3);
                if (i == n) {
                    final int n2 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n2;
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex < -1: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            else {
                BytecodeManager.incBytecodes(2);
                this.checkInvariants();
                BytecodeManager.incBytecodes(2);
                int wordIndex = wordIndex(i);
                BytecodeManager.incBytecodes(1);
                final int n3 = wordIndex;
                final int wordsInUse = this.wordsInUse;
                BytecodeManager.incBytecodes(4);
                if (n3 >= wordsInUse) {
                    BytecodeManager.incBytecodes(2);
                    return i;
                }
                long n4 = ~this.words[wordIndex] & -1L >>> -(i + 1);
                BytecodeManager.incBytecodes(14);
                while (true) {
                    final long n5 = lcmp(n4, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n5 != 0) {
                        final int n6 = (wordIndex + 1) * 64 - 1;
                        final long j = n4;
                        BytecodeManager.incBytecodes(9);
                        final int n7 = n6 - Long.numberOfLeadingZeros(j);
                        BytecodeManager.incBytecodes(2);
                        return n7;
                    }
                    final int n8 = wordIndex--;
                    BytecodeManager.incBytecodes(3);
                    if (n8 == 0) {
                        final int n9 = -1;
                        BytecodeManager.incBytecodes(2);
                        return n9;
                    }
                    n4 = ~this.words[wordIndex];
                    BytecodeManager.incBytecodes(8);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int length() {
        try {
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(3);
            if (wordsInUse == 0) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            final int n2 = 64 * (this.wordsInUse - 1);
            final int n3 = 64;
            final long i = this.words[this.wordsInUse - 1];
            BytecodeManager.incBytecodes(14);
            BytecodeManager.incBytecodes(1);
            final int n4 = n2 + (n3 - Long.numberOfLeadingZeros(i));
            BytecodeManager.incBytecodes(3);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isEmpty() {
        try {
            final int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (wordsInUse == 0) {
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
    
    public boolean intersects(final BitSet set) {
        try {
            final int wordsInUse = this.wordsInUse;
            final int wordsInUse2 = set.wordsInUse;
            BytecodeManager.incBytecodes(5);
            int n = Math.min(wordsInUse, wordsInUse2) - 1;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final long n3 = lcmp(this.words[n] & set.words[n], 0L);
                BytecodeManager.incBytecodes(12);
                if (n3 != 0) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                --n;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int cardinality() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int wordsInUse = this.wordsInUse;
                BytecodeManager.incBytecodes(4);
                if (n3 >= wordsInUse) {
                    break;
                }
                final int n4 = n;
                final long i = this.words[n2];
                BytecodeManager.incBytecodes(6);
                n = n4 + Long.bitCount(i);
                BytecodeManager.incBytecodes(2);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = n;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void and(final BitSet set) {
        try {
            BytecodeManager.incBytecodes(3);
            if (this == set) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            while (true) {
                final int wordsInUse = this.wordsInUse;
                final int wordsInUse2 = set.wordsInUse;
                BytecodeManager.incBytecodes(5);
                if (wordsInUse <= wordsInUse2) {
                    break;
                }
                this.words[--this.wordsInUse] = 0L;
                BytecodeManager.incBytecodes(12);
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int wordsInUse3 = this.wordsInUse;
                BytecodeManager.incBytecodes(4);
                if (n2 >= wordsInUse3) {
                    break;
                }
                final long[] words = this.words;
                final int n3 = n;
                words[n3] &= set.words[n];
                BytecodeManager.incBytecodes(11);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void or(final BitSet set) {
        try {
            BytecodeManager.incBytecodes(3);
            if (this == set) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int wordsInUse = this.wordsInUse;
            final int wordsInUse2 = set.wordsInUse;
            BytecodeManager.incBytecodes(5);
            final int min = Math.min(wordsInUse, wordsInUse2);
            BytecodeManager.incBytecodes(1);
            final int wordsInUse3 = this.wordsInUse;
            final int wordsInUse4 = set.wordsInUse;
            BytecodeManager.incBytecodes(5);
            if (wordsInUse3 < wordsInUse4) {
                final int wordsInUse5 = set.wordsInUse;
                BytecodeManager.incBytecodes(4);
                this.ensureCapacity(wordsInUse5);
                this.wordsInUse = set.wordsInUse;
                BytecodeManager.incBytecodes(4);
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = min;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final long[] words = this.words;
                final int n4 = n;
                words[n4] |= set.words[n];
                BytecodeManager.incBytecodes(11);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = min;
            final int wordsInUse6 = set.wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (n5 < wordsInUse6) {
                final long[] words2 = set.words;
                final int n6 = min;
                final long[] words3 = this.words;
                final int n7 = min;
                final int n8 = this.wordsInUse - min;
                BytecodeManager.incBytecodes(11);
                System.arraycopy(words2, n6, words3, n7, n8);
            }
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void xor(final BitSet set) {
        try {
            final int wordsInUse = this.wordsInUse;
            final int wordsInUse2 = set.wordsInUse;
            BytecodeManager.incBytecodes(5);
            final int min = Math.min(wordsInUse, wordsInUse2);
            BytecodeManager.incBytecodes(1);
            final int wordsInUse3 = this.wordsInUse;
            final int wordsInUse4 = set.wordsInUse;
            BytecodeManager.incBytecodes(5);
            if (wordsInUse3 < wordsInUse4) {
                final int wordsInUse5 = set.wordsInUse;
                BytecodeManager.incBytecodes(4);
                this.ensureCapacity(wordsInUse5);
                this.wordsInUse = set.wordsInUse;
                BytecodeManager.incBytecodes(4);
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = min;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final long[] words = this.words;
                final int n4 = n;
                words[n4] ^= set.words[n];
                BytecodeManager.incBytecodes(11);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = min;
            final int wordsInUse6 = set.wordsInUse;
            BytecodeManager.incBytecodes(4);
            if (n5 < wordsInUse6) {
                final long[] words2 = set.words;
                final int n6 = min;
                final long[] words3 = this.words;
                final int n7 = min;
                final int n8 = set.wordsInUse - min;
                BytecodeManager.incBytecodes(11);
                System.arraycopy(words2, n6, words3, n7, n8);
            }
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void andNot(final BitSet set) {
        try {
            final int wordsInUse = this.wordsInUse;
            final int wordsInUse2 = set.wordsInUse;
            BytecodeManager.incBytecodes(5);
            int n = Math.min(wordsInUse, wordsInUse2) - 1;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    break;
                }
                final long[] words = this.words;
                final int n3 = n;
                words[n3] &= ~set.words[n];
                BytecodeManager.incBytecodes(13);
                --n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            long n = 1234L;
            BytecodeManager.incBytecodes(2);
            int wordsInUse = this.wordsInUse;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n2 = --wordsInUse;
                BytecodeManager.incBytecodes(3);
                if (n2 < 0) {
                    break;
                }
                n ^= this.words[wordsInUse] * (wordsInUse + 1);
                BytecodeManager.incBytecodes(13);
            }
            final int n3 = (int)(n >> 32 ^ n);
            BytecodeManager.incBytecodes(7);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int size() {
        try {
            final int n = this.words.length * 64;
            BytecodeManager.incBytecodes(6);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            final boolean b = o instanceof BitSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            BytecodeManager.incBytecodes(3);
            if (this == o) {
                final boolean b3 = true;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final BitSet set = (BitSet)o;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            final BitSet set2 = set;
            BytecodeManager.incBytecodes(2);
            set2.checkInvariants();
            final int wordsInUse = this.wordsInUse;
            final int wordsInUse2 = set.wordsInUse;
            BytecodeManager.incBytecodes(5);
            if (wordsInUse != wordsInUse2) {
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int wordsInUse3 = this.wordsInUse;
                BytecodeManager.incBytecodes(4);
                if (n2 >= wordsInUse3) {
                    final boolean b5 = true;
                    BytecodeManager.incBytecodes(2);
                    return b5;
                }
                final long n3 = lcmp(this.words[n], set.words[n]);
                BytecodeManager.incBytecodes(10);
                if (n3 != 0) {
                    final boolean b6 = false;
                    BytecodeManager.incBytecodes(2);
                    return b6;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/BitSet.sizeIsSticky:Z
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifne            21
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   instrumented/java/util/BitSet.trimToSize:()V
        //    21: aload_0        
        //    22: ldc             2
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //    30: checkcast       Linstrumented/java/util/BitSet;
        //    33: astore_1       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_1        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/BitSet.words:[J
        //    44: ldc             4
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    52: checkcast       [J
        //    55: putfield        instrumented/java/util/BitSet.words:[J
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: aload_1        
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: invokespecial   instrumented/java/util/BitSet.checkInvariants:()V
        //    72: aload_1        
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: areturn        
        //    84: astore_1       
        //    85: ldc_w           501
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: new             Ljava/lang/InternalError;
        //    94: dup            
        //    95: aload_1        
        //    96: ldc             4
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: invokespecial   java/lang/InternalError.<init>:(Ljava/lang/Throwable;)V
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: athrow         
        //   110: athrow         
        //   111: athrow         
        //    StackMapTable: 00 04 15 7E 07 01 38 FF 00 19 00 00 00 01 07 00 45 FF 00 00 00 00 00 01 07 01 36
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  21     111    111    112    Ljava/lang/VirtualMachineError;
        //  21     78     84     110    Ljava/lang/CloneNotSupportedException;
        //  0      110    110    111    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0021:
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
    
    private void trimToSize() {
        try {
            final int wordsInUse = this.wordsInUse;
            final int length = this.words.length;
            BytecodeManager.incBytecodes(6);
            if (wordsInUse != length) {
                final long[] words = this.words;
                final int wordsInUse2 = this.wordsInUse;
                BytecodeManager.incBytecodes(6);
                this.words = Arrays.copyOf(words, wordsInUse2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                this.checkInvariants();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            final boolean sizeIsSticky = this.sizeIsSticky;
            BytecodeManager.incBytecodes(3);
            if (!sizeIsSticky) {
                BytecodeManager.incBytecodes(2);
                this.trimToSize();
            }
            BytecodeManager.incBytecodes(2);
            final ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            BytecodeManager.incBytecodes(1);
            final ObjectOutputStream.PutField putField = putFields;
            final String s = "bits";
            final long[] words = this.words;
            BytecodeManager.incBytecodes(5);
            putField.put(s, words);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.writeFields();
            BytecodeManager.incBytecodes(1);
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
            final String s = "bits";
            final Object o = null;
            BytecodeManager.incBytecodes(5);
            this.words = (long[])getField.get(s, o);
            BytecodeManager.incBytecodes(3);
            this.wordsInUse = this.words.length;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(2);
            this.recalculateWordsInUse();
            final int length = this.words.length;
            BytecodeManager.incBytecodes(5);
            boolean sizeIsSticky = false;
            Label_0117: {
                if (length > 0) {
                    final long n = lcmp(this.words[this.words.length - 1], 0L);
                    BytecodeManager.incBytecodes(11);
                    if (n == 0) {
                        sizeIsSticky = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0117;
                    }
                }
                sizeIsSticky = false;
                BytecodeManager.incBytecodes(1);
            }
            this.sizeIsSticky = sizeIsSticky;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            final int wordsInUse = this.wordsInUse;
            final int n = 128;
            BytecodeManager.incBytecodes(4);
            int cardinality;
            if (wordsInUse > n) {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                cardinality = this.cardinality();
                BytecodeManager.incBytecodes(1);
            }
            else {
                cardinality = this.wordsInUse * 64;
                BytecodeManager.incBytecodes(4);
            }
            final int n2 = cardinality;
            BytecodeManager.incBytecodes(1);
            final int capacity = 6 * n2 + 2;
            BytecodeManager.incBytecodes(8);
            final StringBuilder sb = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '{';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            final int n3 = 0;
            BytecodeManager.incBytecodes(3);
            int n4 = this.nextSetBit(n3);
            BytecodeManager.incBytecodes(1);
            final int n5 = n4;
            final int n6 = -1;
            BytecodeManager.incBytecodes(3);
            if (n5 != n6) {
                final StringBuilder sb3 = sb;
                final int i = n4;
                BytecodeManager.incBytecodes(3);
                sb3.append(i);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final int n7 = ++n4;
                    BytecodeManager.incBytecodes(3);
                    if (n7 < 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final int n8 = n4;
                    BytecodeManager.incBytecodes(3);
                    final int n9 = n4 = this.nextSetBit(n8);
                    BytecodeManager.incBytecodes(3);
                    if (n9 < 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final int n10 = n4;
                    BytecodeManager.incBytecodes(3);
                    final int nextClearBit = this.nextClearBit(n10);
                    BytecodeManager.incBytecodes(1);
                    int j;
                    int n11;
                    do {
                        final StringBuilder sb4 = sb;
                        final String str = ", ";
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder append = sb4.append(str);
                        final int k = n4;
                        BytecodeManager.incBytecodes(2);
                        append.append(k);
                        BytecodeManager.incBytecodes(1);
                        j = ++n4;
                        n11 = nextClearBit;
                        BytecodeManager.incBytecodes(4);
                    } while (j != n11);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final StringBuilder sb5 = sb;
            final char c2 = '}';
            BytecodeManager.incBytecodes(3);
            sb5.append(c2);
            BytecodeManager.incBytecodes(1);
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
    
    public IntStream stream() {
        try {
            final PrimitiveIterator.OfInt ofInt;
            long n;
            final int n2;
            final Object o;
            class BitSetIterator implements PrimitiveIterator.OfInt
            {
                int next;
                
                BitSetIterator() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final BitSet this$2 = BitSet.this;
                        final int n = 0;
                        BytecodeManager.incBytecodes(5);
                        this.next = this$2.nextSetBit(n);
                        BytecodeManager.incBytecodes(2);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final int next = this.next;
                        final int n = -1;
                        BytecodeManager.incBytecodes(4);
                        boolean b;
                        if (next != n) {
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
                public int nextInt() {
                    try {
                        final int next = this.next;
                        final int n = -1;
                        BytecodeManager.incBytecodes(4);
                        if (next != n) {
                            final int next2 = this.next;
                            BytecodeManager.incBytecodes(3);
                            final BitSet this$0 = BitSet.this;
                            final int n2 = this.next + 1;
                            BytecodeManager.incBytecodes(8);
                            this.next = this$0.nextSetBit(n2);
                            BytecodeManager.incBytecodes(1);
                            final int n3 = next2;
                            BytecodeManager.incBytecodes(2);
                            return n3;
                        }
                        BytecodeManager.incBytecodes(3);
                        final NoSuchElementException ex = new NoSuchElementException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Supplier<Object> supplier = () -> {
                try {
                    // new(instrumented.java.util.BitSet.BitSetIterator.class)
                    BytecodeManager.incBytecodes(4);
                    new BitSetIterator();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    n = this.cardinality();
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    Spliterators.spliterator(ofInt, n, n2);
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n3 = 16469;
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final IntStream intStream = StreamSupport.intStream((Supplier<? extends Spliterator.OfInt>)supplier, n3, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<BitSet> clazz = BitSet.class;
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
            final ObjectStreamField[] serialPersistentFields2 = { null };
            final int n = 0;
            final String name = "bits";
            final Class<long[]> type = long[].class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n] = new ObjectStreamField(name, type);
            serialPersistentFields = serialPersistentFields2;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
