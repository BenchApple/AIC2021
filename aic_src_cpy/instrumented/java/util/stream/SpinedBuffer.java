// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.PrimitiveIterator;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.Objects;
import instrumented.java.util.ArrayList;
import instrumented.java.util.Spliterator;
import instrumented.java.util.Spliterators;
import java.util.Iterator;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.Arrays;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.Consumer;

class SpinedBuffer<E> extends AbstractSpinedBuffer implements Consumer<E>, Iterable<E>
{
    protected E[] curChunk;
    protected E[][] spine;
    private static final int SPLITERATOR_CHARACTERISTICS = 16464;
    
    SpinedBuffer(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            super(n);
            this.curChunk = (E[])new Object[1 << this.initialChunkPower];
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    SpinedBuffer() {
        try {
            BytecodeManager.incBytecodes(2);
            this.curChunk = (E[])new Object[1 << this.initialChunkPower];
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected long capacity() {
        try {
            final int spineIndex = this.spineIndex;
            BytecodeManager.incBytecodes(3);
            long n;
            if (spineIndex == 0) {
                n = this.curChunk.length;
                BytecodeManager.incBytecodes(5);
            }
            else {
                n = this.priorElementCount[this.spineIndex] + this.spine[this.spineIndex].length;
                BytecodeManager.incBytecodes(13);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void inflateSpine() {
        try {
            final E[][] spine = this.spine;
            BytecodeManager.incBytecodes(3);
            if (spine == null) {
                this.spine = (E[][])new Object[8][];
                BytecodeManager.incBytecodes(4);
                this.priorElementCount = new long[8];
                BytecodeManager.incBytecodes(3);
                this.spine[0] = this.curChunk;
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected final void ensureCapacity(final long n) {
        try {
            BytecodeManager.incBytecodes(2);
            long capacity = this.capacity();
            BytecodeManager.incBytecodes(1);
            final long n2 = lcmp(n, capacity);
            BytecodeManager.incBytecodes(4);
            if (n2 > 0) {
                BytecodeManager.incBytecodes(2);
                this.inflateSpine();
                int n3 = this.spineIndex + 1;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final long n4 = lcmp(n, capacity);
                    BytecodeManager.incBytecodes(4);
                    if (n4 <= 0) {
                        break;
                    }
                    final int n5 = n3;
                    final int length = this.spine.length;
                    BytecodeManager.incBytecodes(5);
                    if (n5 >= length) {
                        final int n6 = this.spine.length * 2;
                        BytecodeManager.incBytecodes(6);
                        final E[][] spine = this.spine;
                        final int n7 = n6;
                        BytecodeManager.incBytecodes(5);
                        this.spine = Arrays.copyOf(spine, n7);
                        BytecodeManager.incBytecodes(2);
                        final long[] priorElementCount = this.priorElementCount;
                        final int n8 = n6;
                        BytecodeManager.incBytecodes(5);
                        this.priorElementCount = Arrays.copyOf(priorElementCount, n8);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n9 = n3;
                    BytecodeManager.incBytecodes(3);
                    final int chunkSize = this.chunkSize(n9);
                    BytecodeManager.incBytecodes(1);
                    this.spine[n3] = (E[])new Object[chunkSize];
                    BytecodeManager.incBytecodes(6);
                    this.priorElementCount[n3] = this.priorElementCount[n3 - 1] + this.spine[n3 - 1].length;
                    BytecodeManager.incBytecodes(19);
                    capacity += chunkSize;
                    BytecodeManager.incBytecodes(5);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void increaseCapacity() {
        try {
            BytecodeManager.incBytecodes(3);
            final long n = this.capacity() + 1L;
            BytecodeManager.incBytecodes(3);
            this.ensureCapacity(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public E get(final long i) {
        try {
            final int spineIndex = this.spineIndex;
            BytecodeManager.incBytecodes(3);
            if (spineIndex == 0) {
                final long n = lcmp(i, (long)this.elementIndex);
                BytecodeManager.incBytecodes(6);
                if (n < 0) {
                    final E e = this.curChunk[(int)i];
                    BytecodeManager.incBytecodes(6);
                    return e;
                }
                BytecodeManager.incBytecodes(4);
                final String string = Long.toString(i);
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            else {
                BytecodeManager.incBytecodes(3);
                final long n2 = lcmp(i, this.count());
                BytecodeManager.incBytecodes(2);
                if (n2 >= 0) {
                    BytecodeManager.incBytecodes(4);
                    final String string2 = Long.toString(i);
                    BytecodeManager.incBytecodes(1);
                    final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int spineIndex2 = this.spineIndex;
                    BytecodeManager.incBytecodes(4);
                    if (n4 > spineIndex2) {
                        BytecodeManager.incBytecodes(4);
                        final String string3 = Long.toString(i);
                        BytecodeManager.incBytecodes(1);
                        final IndexOutOfBoundsException ex3 = new IndexOutOfBoundsException(string3);
                        BytecodeManager.incBytecodes(1);
                        throw ex3;
                    }
                    final long n5 = lcmp(i, this.priorElementCount[n3] + this.spine[n3].length);
                    BytecodeManager.incBytecodes(14);
                    if (n5 < 0) {
                        final E e2 = this.spine[n3][(int)(i - this.priorElementCount[n3])];
                        BytecodeManager.incBytecodes(13);
                        return e2;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void copyInto(final E[] array, int n) {
        try {
            final long n2 = n;
            BytecodeManager.incBytecodes(4);
            final long n3 = n2 + this.count();
            BytecodeManager.incBytecodes(2);
            final long n4 = lcmp(n3, (long)array.length);
            BytecodeManager.incBytecodes(6);
            if (n4 <= 0) {
                final long n5 = lcmp(n3, (long)n);
                BytecodeManager.incBytecodes(5);
                if (n5 >= 0) {
                    final int spineIndex = this.spineIndex;
                    BytecodeManager.incBytecodes(3);
                    if (spineIndex == 0) {
                        final E[] curChunk = this.curChunk;
                        final int n6 = 0;
                        final int n7 = n;
                        final int elementIndex = this.elementIndex;
                        BytecodeManager.incBytecodes(8);
                        System.arraycopy(curChunk, n6, array, n7, elementIndex);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        int n8 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n9 = n8;
                            final int spineIndex2 = this.spineIndex;
                            BytecodeManager.incBytecodes(4);
                            if (n9 >= spineIndex2) {
                                break;
                            }
                            final E[] array2 = this.spine[n8];
                            final int n10 = 0;
                            final int n11 = n;
                            final int length = this.spine[n8].length;
                            BytecodeManager.incBytecodes(13);
                            System.arraycopy(array2, n10, array, n11, length);
                            n += this.spine[n8].length;
                            BytecodeManager.incBytecodes(8);
                            ++n8;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int elementIndex2 = this.elementIndex;
                        BytecodeManager.incBytecodes(3);
                        if (elementIndex2 > 0) {
                            final E[] curChunk2 = this.curChunk;
                            final int n12 = 0;
                            final int n13 = n;
                            final int elementIndex3 = this.elementIndex;
                            BytecodeManager.incBytecodes(8);
                            System.arraycopy(curChunk2, n12, array, n13, elementIndex3);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            final String s = "does not fit";
            BytecodeManager.incBytecodes(4);
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public E[] asArray(final IntFunction<E[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            final long count = this.count();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(count, 2147483639L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final String s = "Stream size exceeds max array size";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = (int)count;
            BytecodeManager.incBytecodes(4);
            final E[] array = intFunction.apply(n2);
            BytecodeManager.incBytecodes(2);
            final E[] array2 = array;
            final int n3 = 0;
            BytecodeManager.incBytecodes(4);
            this.copyInto(array2, n3);
            final E[] array3 = array;
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            final E[][] spine = this.spine;
            BytecodeManager.incBytecodes(3);
            if (spine != null) {
                this.curChunk = this.spine[0];
                BytecodeManager.incBytecodes(6);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = this.curChunk.length;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= length) {
                        break;
                    }
                    this.curChunk[n] = null;
                    BytecodeManager.incBytecodes(5);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                this.spine = null;
                BytecodeManager.incBytecodes(4);
                this.priorElementCount = null;
                BytecodeManager.incBytecodes(4);
            }
            else {
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int elementIndex = this.elementIndex;
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= elementIndex) {
                        break;
                    }
                    this.curChunk[n3] = null;
                    BytecodeManager.incBytecodes(5);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.elementIndex = 0;
            BytecodeManager.incBytecodes(3);
            this.spineIndex = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<E> spliterator = this.spliterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator = Spliterators.iterator((Spliterator<? extends E>)spliterator);
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void forEach(final Consumer<? super E> consumer) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int spineIndex = this.spineIndex;
                BytecodeManager.incBytecodes(4);
                if (n2 >= spineIndex) {
                    break;
                }
                final E[] array = this.spine[n];
                final int length = array.length;
                int n3 = 0;
                BytecodeManager.incBytecodes(10);
                while (true) {
                    final int n4 = n3;
                    final int n5 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n5) {
                        break;
                    }
                    final E e = array[n3];
                    BytecodeManager.incBytecodes(4);
                    final E e2 = e;
                    BytecodeManager.incBytecodes(3);
                    consumer.accept(e2);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            int n6 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n7 = n6;
                final int elementIndex = this.elementIndex;
                BytecodeManager.incBytecodes(4);
                if (n7 >= elementIndex) {
                    break;
                }
                final E e3 = this.curChunk[n6];
                BytecodeManager.incBytecodes(6);
                consumer.accept(e3);
                ++n6;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void accept(final E e) {
        try {
            final int elementIndex = this.elementIndex;
            final int length = this.curChunk.length;
            BytecodeManager.incBytecodes(6);
            if (elementIndex == length) {
                BytecodeManager.incBytecodes(2);
                this.inflateSpine();
                final int n = this.spineIndex + 1;
                final int length2 = this.spine.length;
                BytecodeManager.incBytecodes(8);
                Label_0073: {
                    if (n < length2) {
                        final E[] array = this.spine[this.spineIndex + 1];
                        BytecodeManager.incBytecodes(8);
                        if (array != null) {
                            break Label_0073;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    this.increaseCapacity();
                }
                this.elementIndex = 0;
                BytecodeManager.incBytecodes(3);
                ++this.spineIndex;
                BytecodeManager.incBytecodes(6);
                this.curChunk = this.spine[this.spineIndex];
                BytecodeManager.incBytecodes(7);
            }
            this.curChunk[this.elementIndex++] = e;
            BytecodeManager.incBytecodes(11);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(3);
            final ArrayList<Object> list = new ArrayList<Object>();
            BytecodeManager.incBytecodes(1);
            final ArrayList<Object> list2 = list;
            BytecodeManager.incBytecodes(4);
            list2.getClass();
            final Consumer<Object> consumer = list2::add;
            BytecodeManager.incBytecodes(2);
            this.forEach(consumer);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "SpinedBuffer:";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final ArrayList<Object> list3 = list;
            BytecodeManager.incBytecodes(2);
            final String string = list3.toString();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(string);
            BytecodeManager.incBytecodes(1);
            final String string2 = append2.toString();
            BytecodeManager.incBytecodes(1);
            return string2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Spliterator<E> spliterator() {
        try {
            final int n = 0;
            final int spineIndex = this.spineIndex;
            final int n2 = 0;
            final int elementIndex = this.elementIndex;
            BytecodeManager.incBytecodes(10);
            class Splitr implements Spliterator<E>
            {
                int splSpineIndex = n;
                final int lastSpineIndex = spineIndex;
                int splElementIndex = n2;
                final int lastSpineElementFence = elementIndex;
                E[] splChunk;
                static final /* synthetic */ boolean $assertionsDisabled;
                
                Splitr(final int lastSpineIndex, final int splElementIndex, final int lastSpineElementFence) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(3);
                        final boolean $assertionsDisabled = Splitr.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        Label_0115: {
                            if (!$assertionsDisabled) {
                                final E[][] spine = SpinedBuffer.this.spine;
                                BytecodeManager.incBytecodes(3);
                                if (spine == null) {
                                    BytecodeManager.incBytecodes(2);
                                    if (splSpineIndex == 0) {
                                        BytecodeManager.incBytecodes(2);
                                        if (lastSpineIndex == 0) {
                                            break Label_0115;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError;
                                }
                            }
                        }
                        final E[][] spine2 = SpinedBuffer.this.spine;
                        BytecodeManager.incBytecodes(4);
                        E[] curChunk;
                        if (spine2 == null) {
                            curChunk = SpinedBuffer.this.curChunk;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            curChunk = SpinedBuffer.this.spine[splSpineIndex];
                            BytecodeManager.incBytecodes(4);
                        }
                        this.splChunk = curChunk;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public long estimateSize() {
                    try {
                        final int splSpineIndex = this.splSpineIndex;
                        final int lastSpineIndex = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(5);
                        long n;
                        if (splSpineIndex == lastSpineIndex) {
                            n = this.lastSpineElementFence - (long)this.splElementIndex;
                            BytecodeManager.incBytecodes(8);
                        }
                        else {
                            n = SpinedBuffer.this.priorElementCount[this.lastSpineIndex] + this.lastSpineElementFence - SpinedBuffer.this.priorElementCount[this.splSpineIndex] - this.splElementIndex;
                            BytecodeManager.incBytecodes(21);
                        }
                        BytecodeManager.incBytecodes(1);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public int characteristics() {
                    try {
                        final int n = 16464;
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean tryAdvance(final Consumer<? super E> consumer) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        Objects.requireNonNull(consumer);
                        BytecodeManager.incBytecodes(1);
                        final int splSpineIndex = this.splSpineIndex;
                        final int lastSpineIndex = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(5);
                        Label_0063: {
                            if (splSpineIndex >= lastSpineIndex) {
                                final int splSpineIndex2 = this.splSpineIndex;
                                final int lastSpineIndex2 = this.lastSpineIndex;
                                BytecodeManager.incBytecodes(5);
                                if (splSpineIndex2 == lastSpineIndex2) {
                                    final int splElementIndex = this.splElementIndex;
                                    final int lastSpineElementFence = this.lastSpineElementFence;
                                    BytecodeManager.incBytecodes(5);
                                    if (splElementIndex < lastSpineElementFence) {
                                        break Label_0063;
                                    }
                                }
                                final boolean b = false;
                                BytecodeManager.incBytecodes(2);
                                return b;
                            }
                        }
                        final E e = this.splChunk[this.splElementIndex++];
                        BytecodeManager.incBytecodes(12);
                        consumer.accept(e);
                        final int splElementIndex2 = this.splElementIndex;
                        final int length = this.splChunk.length;
                        BytecodeManager.incBytecodes(6);
                        if (splElementIndex2 == length) {
                            this.splElementIndex = 0;
                            BytecodeManager.incBytecodes(3);
                            ++this.splSpineIndex;
                            BytecodeManager.incBytecodes(6);
                            final E[][] spine = SpinedBuffer.this.spine;
                            BytecodeManager.incBytecodes(4);
                            if (spine != null) {
                                final int splSpineIndex3 = this.splSpineIndex;
                                final int lastSpineIndex3 = this.lastSpineIndex;
                                BytecodeManager.incBytecodes(5);
                                if (splSpineIndex3 <= lastSpineIndex3) {
                                    this.splChunk = SpinedBuffer.this.spine[this.splSpineIndex];
                                    BytecodeManager.incBytecodes(8);
                                }
                            }
                        }
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void forEachRemaining(final Consumer<? super E> consumer) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        Objects.requireNonNull(consumer);
                        BytecodeManager.incBytecodes(1);
                        final int splSpineIndex = this.splSpineIndex;
                        final int lastSpineIndex = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(5);
                        Label_0292: {
                            if (splSpineIndex >= lastSpineIndex) {
                                final int splSpineIndex2 = this.splSpineIndex;
                                final int lastSpineIndex2 = this.lastSpineIndex;
                                BytecodeManager.incBytecodes(5);
                                if (splSpineIndex2 != lastSpineIndex2) {
                                    break Label_0292;
                                }
                                final int splElementIndex = this.splElementIndex;
                                final int lastSpineElementFence = this.lastSpineElementFence;
                                BytecodeManager.incBytecodes(5);
                                if (splElementIndex >= lastSpineElementFence) {
                                    break Label_0292;
                                }
                            }
                            int splElementIndex2 = this.splElementIndex;
                            BytecodeManager.incBytecodes(3);
                            int splSpineIndex3 = this.splSpineIndex;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final int n = splSpineIndex3;
                                final int lastSpineIndex3 = this.lastSpineIndex;
                                BytecodeManager.incBytecodes(4);
                                if (n >= lastSpineIndex3) {
                                    break;
                                }
                                final E[] array = SpinedBuffer.this.spine[splSpineIndex3];
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final int n2 = splElementIndex2;
                                    final int length = array.length;
                                    BytecodeManager.incBytecodes(4);
                                    if (n2 >= length) {
                                        break;
                                    }
                                    final E e = array[splElementIndex2];
                                    BytecodeManager.incBytecodes(5);
                                    consumer.accept(e);
                                    ++splElementIndex2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                splElementIndex2 = 0;
                                BytecodeManager.incBytecodes(2);
                                ++splSpineIndex3;
                                BytecodeManager.incBytecodes(2);
                            }
                            final int splSpineIndex4 = this.splSpineIndex;
                            final int lastSpineIndex4 = this.lastSpineIndex;
                            BytecodeManager.incBytecodes(5);
                            E[] splChunk;
                            if (splSpineIndex4 == lastSpineIndex4) {
                                splChunk = this.splChunk;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                splChunk = SpinedBuffer.this.spine[this.lastSpineIndex];
                                BytecodeManager.incBytecodes(6);
                            }
                            final E[] array2 = splChunk;
                            BytecodeManager.incBytecodes(1);
                            final int lastSpineElementFence2 = this.lastSpineElementFence;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final int n3 = splElementIndex2;
                                final int n4 = lastSpineElementFence2;
                                BytecodeManager.incBytecodes(3);
                                if (n3 >= n4) {
                                    break;
                                }
                                final E e2 = array2[splElementIndex2];
                                BytecodeManager.incBytecodes(5);
                                consumer.accept(e2);
                                ++splElementIndex2;
                                BytecodeManager.incBytecodes(2);
                            }
                            this.splSpineIndex = this.lastSpineIndex;
                            BytecodeManager.incBytecodes(4);
                            this.splElementIndex = this.lastSpineElementFence;
                            BytecodeManager.incBytecodes(4);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public Spliterator<E> trySplit() {
                    try {
                        final int splSpineIndex = this.splSpineIndex;
                        final int lastSpineIndex = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(5);
                        if (splSpineIndex < lastSpineIndex) {
                            final SpinedBuffer this$0 = SpinedBuffer.this;
                            final int splSpineIndex2 = this.splSpineIndex;
                            final int n = this.lastSpineIndex - 1;
                            final int splElementIndex = this.splElementIndex;
                            final int length = SpinedBuffer.this.spine[this.lastSpineIndex - 1].length;
                            BytecodeManager.incBytecodes(22);
                            final Splitr splitr = this$0.new Splitr(splSpineIndex2, n, splElementIndex, length);
                            BytecodeManager.incBytecodes(1);
                            this.splSpineIndex = this.lastSpineIndex;
                            BytecodeManager.incBytecodes(4);
                            this.splElementIndex = 0;
                            BytecodeManager.incBytecodes(3);
                            this.splChunk = SpinedBuffer.this.spine[this.splSpineIndex];
                            BytecodeManager.incBytecodes(8);
                            final Splitr splitr2 = splitr;
                            BytecodeManager.incBytecodes(2);
                            return splitr2;
                        }
                        final int splSpineIndex3 = this.splSpineIndex;
                        final int lastSpineIndex2 = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(5);
                        if (splSpineIndex3 != lastSpineIndex2) {
                            final Spliterator<E> spliterator = null;
                            BytecodeManager.incBytecodes(2);
                            return spliterator;
                        }
                        final int n2 = (this.lastSpineElementFence - this.splElementIndex) / 2;
                        BytecodeManager.incBytecodes(8);
                        final int n3 = n2;
                        BytecodeManager.incBytecodes(2);
                        if (n3 == 0) {
                            final Spliterator<E> spliterator2 = null;
                            BytecodeManager.incBytecodes(2);
                            return spliterator2;
                        }
                        final E[] splChunk = this.splChunk;
                        final int splElementIndex2 = this.splElementIndex;
                        final int n4 = this.splElementIndex + n2;
                        BytecodeManager.incBytecodes(9);
                        final Spliterator<E> spliterator3 = Arrays.spliterator(splChunk, splElementIndex2, n4);
                        BytecodeManager.incBytecodes(1);
                        this.splElementIndex += n2;
                        BytecodeManager.incBytecodes(6);
                        final Spliterator<E> spliterator4 = spliterator3;
                        BytecodeManager.incBytecodes(2);
                        return spliterator4;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                static {
                    try {
                        final Class<SpinedBuffer> clazz = SpinedBuffer.class;
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
                        BytecodeManager.incBytecodes(2);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Splitr splitr = new Splitr(spineIndex, elementIndex);
            BytecodeManager.incBytecodes(1);
            return splitr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    abstract static class OfPrimitive<E, T_ARR, T_CONS> extends AbstractSpinedBuffer implements Iterable<E>
    {
        T_ARR curChunk;
        T_ARR[] spine;
        
        OfPrimitive(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                super(n);
                final int n2 = 1 << this.initialChunkPower;
                BytecodeManager.incBytecodes(7);
                this.curChunk = this.newArray(n2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        OfPrimitive() {
            try {
                BytecodeManager.incBytecodes(2);
                final int n = 1 << this.initialChunkPower;
                BytecodeManager.incBytecodes(7);
                this.curChunk = this.newArray(n);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public abstract Iterator<E> iterator();
        
        public abstract void forEach(final Consumer<? super E> p0);
        
        protected abstract T_ARR[] newArrayArray(final int p0);
        
        public abstract T_ARR newArray(final int p0);
        
        protected abstract int arrayLength(final T_ARR p0);
        
        protected abstract void arrayForEach(final T_ARR p0, final int p1, final int p2, final T_CONS p3);
        
        protected long capacity() {
            try {
                final int spineIndex = this.spineIndex;
                BytecodeManager.incBytecodes(3);
                long n;
                if (spineIndex == 0) {
                    final T_ARR curChunk = this.curChunk;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    n = this.arrayLength(curChunk);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n2 = this.priorElementCount[this.spineIndex];
                    final T_ARR t_ARR = this.spine[this.spineIndex];
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                    n = n2 + this.arrayLength(t_ARR);
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void inflateSpine() {
            try {
                final T_ARR[] spine = this.spine;
                BytecodeManager.incBytecodes(3);
                if (spine == null) {
                    final int n = 8;
                    BytecodeManager.incBytecodes(4);
                    this.spine = this.newArrayArray(n);
                    BytecodeManager.incBytecodes(1);
                    this.priorElementCount = new long[8];
                    BytecodeManager.incBytecodes(3);
                    this.spine[0] = this.curChunk;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected final void ensureCapacity(final long n) {
            try {
                BytecodeManager.incBytecodes(2);
                long capacity = this.capacity();
                BytecodeManager.incBytecodes(1);
                final long n2 = lcmp(n, capacity);
                BytecodeManager.incBytecodes(4);
                if (n2 > 0) {
                    BytecodeManager.incBytecodes(2);
                    this.inflateSpine();
                    int n3 = this.spineIndex + 1;
                    BytecodeManager.incBytecodes(5);
                    while (true) {
                        final long n4 = lcmp(n, capacity);
                        BytecodeManager.incBytecodes(4);
                        if (n4 <= 0) {
                            break;
                        }
                        final int n5 = n3;
                        final int length = this.spine.length;
                        BytecodeManager.incBytecodes(5);
                        if (n5 >= length) {
                            final int n6 = this.spine.length * 2;
                            BytecodeManager.incBytecodes(6);
                            final T_ARR[] spine = this.spine;
                            final int n7 = n6;
                            BytecodeManager.incBytecodes(5);
                            this.spine = Arrays.copyOf(spine, n7);
                            BytecodeManager.incBytecodes(1);
                            final long[] priorElementCount = this.priorElementCount;
                            final int n8 = n6;
                            BytecodeManager.incBytecodes(5);
                            this.priorElementCount = Arrays.copyOf(priorElementCount, n8);
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n9 = n3;
                        BytecodeManager.incBytecodes(3);
                        final int chunkSize = this.chunkSize(n9);
                        BytecodeManager.incBytecodes(1);
                        final T_ARR[] spine2 = this.spine;
                        final int n10 = n3;
                        final int n11 = chunkSize;
                        BytecodeManager.incBytecodes(6);
                        spine2[n10] = this.newArray(n11);
                        BytecodeManager.incBytecodes(1);
                        final long[] priorElementCount2 = this.priorElementCount;
                        final int n12 = n3;
                        final long n13 = this.priorElementCount[n3 - 1];
                        final T_ARR t_ARR = this.spine[n3 - 1];
                        BytecodeManager.incBytecodes(17);
                        priorElementCount2[n12] = n13 + this.arrayLength(t_ARR);
                        BytecodeManager.incBytecodes(3);
                        capacity += chunkSize;
                        BytecodeManager.incBytecodes(5);
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected void increaseCapacity() {
            try {
                BytecodeManager.incBytecodes(3);
                final long n = this.capacity() + 1L;
                BytecodeManager.incBytecodes(3);
                this.ensureCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected int chunkFor(final long i) {
            try {
                final int spineIndex = this.spineIndex;
                BytecodeManager.incBytecodes(3);
                if (spineIndex == 0) {
                    final long n = lcmp(i, (long)this.elementIndex);
                    BytecodeManager.incBytecodes(6);
                    if (n < 0) {
                        final int n2 = 0;
                        BytecodeManager.incBytecodes(2);
                        return n2;
                    }
                    BytecodeManager.incBytecodes(4);
                    final String string = Long.toString(i);
                    BytecodeManager.incBytecodes(1);
                    final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    final long n3 = lcmp(i, this.count());
                    BytecodeManager.incBytecodes(2);
                    if (n3 >= 0) {
                        BytecodeManager.incBytecodes(4);
                        final String string2 = Long.toString(i);
                        BytecodeManager.incBytecodes(1);
                        final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string2);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    int n4 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n5 = n4;
                        final int spineIndex2 = this.spineIndex;
                        BytecodeManager.incBytecodes(4);
                        if (n5 > spineIndex2) {
                            BytecodeManager.incBytecodes(4);
                            final String string3 = Long.toString(i);
                            BytecodeManager.incBytecodes(1);
                            final IndexOutOfBoundsException ex3 = new IndexOutOfBoundsException(string3);
                            BytecodeManager.incBytecodes(1);
                            throw ex3;
                        }
                        final long n6 = this.priorElementCount[n4];
                        final T_ARR t_ARR = this.spine[n4];
                        BytecodeManager.incBytecodes(11);
                        final long n7 = lcmp(i, n6 + this.arrayLength(t_ARR));
                        BytecodeManager.incBytecodes(4);
                        if (n7 < 0) {
                            final int n8 = n4;
                            BytecodeManager.incBytecodes(2);
                            return n8;
                        }
                        ++n4;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void copyInto(final T_ARR t_ARR, int n) {
            try {
                final long n2 = n;
                BytecodeManager.incBytecodes(4);
                final long n3 = n2 + this.count();
                BytecodeManager.incBytecodes(2);
                final long n4 = n3;
                BytecodeManager.incBytecodes(4);
                final long n5 = lcmp(n4, (long)this.arrayLength(t_ARR));
                BytecodeManager.incBytecodes(3);
                if (n5 <= 0) {
                    final long n6 = lcmp(n3, (long)n);
                    BytecodeManager.incBytecodes(5);
                    if (n6 >= 0) {
                        final int spineIndex = this.spineIndex;
                        BytecodeManager.incBytecodes(3);
                        if (spineIndex == 0) {
                            final T_ARR curChunk = this.curChunk;
                            final int n7 = 0;
                            final int n8 = n;
                            final int elementIndex = this.elementIndex;
                            BytecodeManager.incBytecodes(8);
                            System.arraycopy(curChunk, n7, t_ARR, n8, elementIndex);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            int n9 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n10 = n9;
                                final int spineIndex2 = this.spineIndex;
                                BytecodeManager.incBytecodes(4);
                                if (n10 >= spineIndex2) {
                                    break;
                                }
                                final T_ARR t_ARR2 = this.spine[n9];
                                final int n11 = 0;
                                final int n12 = n;
                                final T_ARR t_ARR3 = this.spine[n9];
                                BytecodeManager.incBytecodes(13);
                                final int arrayLength = this.arrayLength(t_ARR3);
                                BytecodeManager.incBytecodes(1);
                                System.arraycopy(t_ARR2, n11, t_ARR, n12, arrayLength);
                                final int n13 = n;
                                final T_ARR t_ARR4 = this.spine[n9];
                                BytecodeManager.incBytecodes(7);
                                n = n13 + this.arrayLength(t_ARR4);
                                BytecodeManager.incBytecodes(2);
                                ++n9;
                                BytecodeManager.incBytecodes(2);
                            }
                            final int elementIndex2 = this.elementIndex;
                            BytecodeManager.incBytecodes(3);
                            if (elementIndex2 > 0) {
                                final T_ARR curChunk2 = this.curChunk;
                                final int n14 = 0;
                                final int n15 = n;
                                final int elementIndex3 = this.elementIndex;
                                BytecodeManager.incBytecodes(8);
                                System.arraycopy(curChunk2, n14, t_ARR, n15, elementIndex3);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                final String s = "does not fit";
                BytecodeManager.incBytecodes(4);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public T_ARR asPrimitiveArray() {
            try {
                BytecodeManager.incBytecodes(2);
                final long count = this.count();
                BytecodeManager.incBytecodes(1);
                final long n = lcmp(count, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n2 = (int)count;
                BytecodeManager.incBytecodes(4);
                final T_ARR array = this.newArray(n2);
                BytecodeManager.incBytecodes(1);
                final T_ARR t_ARR = array;
                final int n3 = 0;
                BytecodeManager.incBytecodes(4);
                this.copyInto(t_ARR, n3);
                final T_ARR t_ARR2 = array;
                BytecodeManager.incBytecodes(2);
                return t_ARR2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected void preAccept() {
            try {
                final int elementIndex = this.elementIndex;
                final T_ARR curChunk = this.curChunk;
                BytecodeManager.incBytecodes(6);
                final int arrayLength = this.arrayLength(curChunk);
                BytecodeManager.incBytecodes(1);
                if (elementIndex == arrayLength) {
                    BytecodeManager.incBytecodes(2);
                    this.inflateSpine();
                    final int n = this.spineIndex + 1;
                    final int length = this.spine.length;
                    BytecodeManager.incBytecodes(8);
                    Label_0081: {
                        if (n < length) {
                            final T_ARR t_ARR = this.spine[this.spineIndex + 1];
                            BytecodeManager.incBytecodes(8);
                            if (t_ARR != null) {
                                break Label_0081;
                            }
                        }
                        BytecodeManager.incBytecodes(2);
                        this.increaseCapacity();
                    }
                    this.elementIndex = 0;
                    BytecodeManager.incBytecodes(3);
                    ++this.spineIndex;
                    BytecodeManager.incBytecodes(6);
                    this.curChunk = this.spine[this.spineIndex];
                    BytecodeManager.incBytecodes(7);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final T_ARR[] spine = this.spine;
                BytecodeManager.incBytecodes(3);
                if (spine != null) {
                    this.curChunk = this.spine[0];
                    BytecodeManager.incBytecodes(6);
                    this.spine = null;
                    BytecodeManager.incBytecodes(3);
                    this.priorElementCount = null;
                    BytecodeManager.incBytecodes(3);
                }
                this.elementIndex = 0;
                BytecodeManager.incBytecodes(3);
                this.spineIndex = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final T_CONS t_CONS) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int spineIndex = this.spineIndex;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= spineIndex) {
                        break;
                    }
                    final T_ARR t_ARR = this.spine[n];
                    final int n3 = 0;
                    final T_ARR t_ARR2 = this.spine[n];
                    BytecodeManager.incBytecodes(12);
                    final int arrayLength = this.arrayLength(t_ARR2);
                    BytecodeManager.incBytecodes(2);
                    this.arrayForEach(t_ARR, n3, arrayLength, t_CONS);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final T_ARR curChunk = this.curChunk;
                final int n4 = 0;
                final int elementIndex = this.elementIndex;
                BytecodeManager.incBytecodes(8);
                this.arrayForEach(curChunk, n4, elementIndex, t_CONS);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract class BaseSpliterator<T_SPLITR extends Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>> implements Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>
        {
            int splSpineIndex;
            final int lastSpineIndex;
            int splElementIndex;
            final int lastSpineElementFence;
            T_ARR splChunk;
            static final /* synthetic */ boolean $assertionsDisabled;
            
            BaseSpliterator(final int splSpineIndex, final int lastSpineIndex, final int splElementIndex, final int lastSpineElementFence) {
                try {
                    BytecodeManager.incBytecodes(5);
                    this.splSpineIndex = splSpineIndex;
                    BytecodeManager.incBytecodes(3);
                    this.lastSpineIndex = lastSpineIndex;
                    BytecodeManager.incBytecodes(3);
                    this.splElementIndex = splElementIndex;
                    BytecodeManager.incBytecodes(3);
                    this.lastSpineElementFence = lastSpineElementFence;
                    BytecodeManager.incBytecodes(3);
                    final boolean $assertionsDisabled = BaseSpliterator.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    Label_0115: {
                        if (!$assertionsDisabled) {
                            final T_ARR[] spine = SpinedBuffer.OfPrimitive.this.spine;
                            BytecodeManager.incBytecodes(3);
                            if (spine == null) {
                                BytecodeManager.incBytecodes(2);
                                if (splSpineIndex == 0) {
                                    BytecodeManager.incBytecodes(2);
                                    if (lastSpineIndex == 0) {
                                        break Label_0115;
                                    }
                                }
                                BytecodeManager.incBytecodes(3);
                                final AssertionError assertionError = new AssertionError();
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                    }
                    final T_ARR[] spine2 = SpinedBuffer.OfPrimitive.this.spine;
                    BytecodeManager.incBytecodes(4);
                    T_ARR curChunk;
                    if (spine2 == null) {
                        curChunk = SpinedBuffer.OfPrimitive.this.curChunk;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        curChunk = SpinedBuffer.OfPrimitive.this.spine[splSpineIndex];
                        BytecodeManager.incBytecodes(4);
                    }
                    this.splChunk = curChunk;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            abstract T_SPLITR newSpliterator(final int p0, final int p1, final int p2, final int p3);
            
            abstract void arrayForOne(final T_ARR p0, final int p1, final T_CONS p2);
            
            abstract T_SPLITR arraySpliterator(final T_ARR p0, final int p1, final int p2);
            
            @Override
            public long estimateSize() {
                try {
                    final int splSpineIndex = this.splSpineIndex;
                    final int lastSpineIndex = this.lastSpineIndex;
                    BytecodeManager.incBytecodes(5);
                    long n;
                    if (splSpineIndex == lastSpineIndex) {
                        n = this.lastSpineElementFence - (long)this.splElementIndex;
                        BytecodeManager.incBytecodes(8);
                    }
                    else {
                        n = SpinedBuffer.OfPrimitive.this.priorElementCount[this.lastSpineIndex] + this.lastSpineElementFence - SpinedBuffer.OfPrimitive.this.priorElementCount[this.splSpineIndex] - this.splElementIndex;
                        BytecodeManager.incBytecodes(21);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int characteristics() {
                try {
                    final int n = 16464;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final T_CONS t_CONS) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    final int splSpineIndex = this.splSpineIndex;
                    final int lastSpineIndex = this.lastSpineIndex;
                    BytecodeManager.incBytecodes(5);
                    Label_0063: {
                        if (splSpineIndex >= lastSpineIndex) {
                            final int splSpineIndex2 = this.splSpineIndex;
                            final int lastSpineIndex2 = this.lastSpineIndex;
                            BytecodeManager.incBytecodes(5);
                            if (splSpineIndex2 == lastSpineIndex2) {
                                final int splElementIndex = this.splElementIndex;
                                final int lastSpineElementFence = this.lastSpineElementFence;
                                BytecodeManager.incBytecodes(5);
                                if (splElementIndex < lastSpineElementFence) {
                                    break Label_0063;
                                }
                            }
                            final boolean b = false;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                    }
                    final T_ARR splChunk = this.splChunk;
                    final int n = this.splElementIndex++;
                    BytecodeManager.incBytecodes(12);
                    this.arrayForOne(splChunk, n, t_CONS);
                    final int splElementIndex2 = this.splElementIndex;
                    final SpinedBuffer.OfPrimitive this$0 = SpinedBuffer.OfPrimitive.this;
                    final T_ARR splChunk2 = this.splChunk;
                    BytecodeManager.incBytecodes(7);
                    final int arrayLength = this$0.arrayLength(splChunk2);
                    BytecodeManager.incBytecodes(1);
                    if (splElementIndex2 == arrayLength) {
                        this.splElementIndex = 0;
                        BytecodeManager.incBytecodes(3);
                        ++this.splSpineIndex;
                        BytecodeManager.incBytecodes(6);
                        final T_ARR[] spine = SpinedBuffer.OfPrimitive.this.spine;
                        BytecodeManager.incBytecodes(4);
                        if (spine != null) {
                            final int splSpineIndex3 = this.splSpineIndex;
                            final int lastSpineIndex3 = this.lastSpineIndex;
                            BytecodeManager.incBytecodes(5);
                            if (splSpineIndex3 <= lastSpineIndex3) {
                                this.splChunk = SpinedBuffer.OfPrimitive.this.spine[this.splSpineIndex];
                                BytecodeManager.incBytecodes(8);
                            }
                        }
                    }
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final T_CONS t_CONS) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    final int splSpineIndex = this.splSpineIndex;
                    final int lastSpineIndex = this.lastSpineIndex;
                    BytecodeManager.incBytecodes(5);
                    Label_0256: {
                        if (splSpineIndex >= lastSpineIndex) {
                            final int splSpineIndex2 = this.splSpineIndex;
                            final int lastSpineIndex2 = this.lastSpineIndex;
                            BytecodeManager.incBytecodes(5);
                            if (splSpineIndex2 != lastSpineIndex2) {
                                break Label_0256;
                            }
                            final int splElementIndex = this.splElementIndex;
                            final int lastSpineElementFence = this.lastSpineElementFence;
                            BytecodeManager.incBytecodes(5);
                            if (splElementIndex >= lastSpineElementFence) {
                                break Label_0256;
                            }
                        }
                        int splElementIndex2 = this.splElementIndex;
                        BytecodeManager.incBytecodes(3);
                        int splSpineIndex3 = this.splSpineIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int n = splSpineIndex3;
                            final int lastSpineIndex3 = this.lastSpineIndex;
                            BytecodeManager.incBytecodes(4);
                            if (n >= lastSpineIndex3) {
                                break;
                            }
                            final T_ARR t_ARR = SpinedBuffer.OfPrimitive.this.spine[splSpineIndex3];
                            BytecodeManager.incBytecodes(6);
                            final SpinedBuffer.OfPrimitive this$0 = SpinedBuffer.OfPrimitive.this;
                            final T_ARR t_ARR2 = t_ARR;
                            final int n2 = splElementIndex2;
                            final SpinedBuffer.OfPrimitive this$2 = SpinedBuffer.OfPrimitive.this;
                            final T_ARR t_ARR3 = t_ARR;
                            BytecodeManager.incBytecodes(8);
                            final int arrayLength = this$2.arrayLength(t_ARR3);
                            BytecodeManager.incBytecodes(2);
                            this$0.arrayForEach(t_ARR2, n2, arrayLength, t_CONS);
                            splElementIndex2 = 0;
                            BytecodeManager.incBytecodes(2);
                            ++splSpineIndex3;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int splSpineIndex4 = this.splSpineIndex;
                        final int lastSpineIndex4 = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(5);
                        T_ARR splChunk;
                        if (splSpineIndex4 == lastSpineIndex4) {
                            splChunk = this.splChunk;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            splChunk = SpinedBuffer.OfPrimitive.this.spine[this.lastSpineIndex];
                            BytecodeManager.incBytecodes(6);
                        }
                        final T_ARR t_ARR4 = splChunk;
                        BytecodeManager.incBytecodes(1);
                        final SpinedBuffer.OfPrimitive this$3 = SpinedBuffer.OfPrimitive.this;
                        final T_ARR t_ARR5 = t_ARR4;
                        final int n3 = splElementIndex2;
                        final int lastSpineElementFence2 = this.lastSpineElementFence;
                        BytecodeManager.incBytecodes(8);
                        this$3.arrayForEach(t_ARR5, n3, lastSpineElementFence2, t_CONS);
                        this.splSpineIndex = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(4);
                        this.splElementIndex = this.lastSpineElementFence;
                        BytecodeManager.incBytecodes(4);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public T_SPLITR trySplit() {
                try {
                    final int splSpineIndex = this.splSpineIndex;
                    final int lastSpineIndex = this.lastSpineIndex;
                    BytecodeManager.incBytecodes(5);
                    if (splSpineIndex < lastSpineIndex) {
                        final int splSpineIndex2 = this.splSpineIndex;
                        final int n = this.lastSpineIndex - 1;
                        final int splElementIndex = this.splElementIndex;
                        final SpinedBuffer.OfPrimitive this$0 = SpinedBuffer.OfPrimitive.this;
                        final T_ARR t_ARR = SpinedBuffer.OfPrimitive.this.spine[this.lastSpineIndex - 1];
                        BytecodeManager.incBytecodes(19);
                        BytecodeManager.incBytecodes(1);
                        final int arrayLength = this$0.arrayLength(t_ARR);
                        BytecodeManager.incBytecodes(1);
                        final Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> spliterator = (Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>)this.newSpliterator(splSpineIndex2, n, splElementIndex, arrayLength);
                        BytecodeManager.incBytecodes(1);
                        this.splSpineIndex = this.lastSpineIndex;
                        BytecodeManager.incBytecodes(4);
                        this.splElementIndex = 0;
                        BytecodeManager.incBytecodes(3);
                        this.splChunk = SpinedBuffer.OfPrimitive.this.spine[this.splSpineIndex];
                        BytecodeManager.incBytecodes(8);
                        final Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> ofPrimitive = spliterator;
                        BytecodeManager.incBytecodes(2);
                        return (T_SPLITR)ofPrimitive;
                    }
                    final int splSpineIndex3 = this.splSpineIndex;
                    final int lastSpineIndex2 = this.lastSpineIndex;
                    BytecodeManager.incBytecodes(5);
                    if (splSpineIndex3 != lastSpineIndex2) {
                        final Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> ofPrimitive2 = null;
                        BytecodeManager.incBytecodes(2);
                        return (T_SPLITR)ofPrimitive2;
                    }
                    final int n2 = (this.lastSpineElementFence - this.splElementIndex) / 2;
                    BytecodeManager.incBytecodes(8);
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n3 == 0) {
                        final Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> ofPrimitive3 = null;
                        BytecodeManager.incBytecodes(2);
                        return (T_SPLITR)ofPrimitive3;
                    }
                    final T_ARR splChunk = this.splChunk;
                    final int splElementIndex2 = this.splElementIndex;
                    final int n4 = n2;
                    BytecodeManager.incBytecodes(7);
                    final Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> arraySpliterator = (Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>)this.arraySpliterator(splChunk, splElementIndex2, n4);
                    BytecodeManager.incBytecodes(1);
                    this.splElementIndex += n2;
                    BytecodeManager.incBytecodes(6);
                    final Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> ofPrimitive4 = arraySpliterator;
                    BytecodeManager.incBytecodes(2);
                    return (T_SPLITR)ofPrimitive4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static {
                try {
                    final Class<SpinedBuffer> clazz = SpinedBuffer.class;
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
                    BytecodeManager.incBytecodes(2);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static class OfInt extends OfPrimitive<Integer, int[], IntConsumer> implements IntConsumer
    {
        OfInt() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        OfInt(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                super(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final Consumer<? super Integer> consumer) {
            try {
                final boolean b = consumer instanceof IntConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final IntConsumer intConsumer = (IntConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    ((OfPrimitive<E, T_ARR, IntConsumer>)this).forEach(intConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfInt> class1 = this.getClass();
                        final String s = "{0} calling SpinedBuffer.OfInt.forEach(Consumer)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(2);
                    final Spliterator.OfInt spliterator = this.spliterator();
                    BytecodeManager.incBytecodes(2);
                    spliterator.forEachRemaining(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected int[][] newArrayArray(final int n) {
            try {
                final int[][] array = new int[n][];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int[] newArray(final int n) {
            try {
                final int[] array = new int[n];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected int arrayLength(final int[] array) {
            try {
                final int length = array.length;
                BytecodeManager.incBytecodes(3);
                return length;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected void arrayForEach(final int[] array, final int n, final int n2, final IntConsumer intConsumer) {
            try {
                int n3 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n2) {
                        break;
                    }
                    final int n5 = array[n3];
                    BytecodeManager.incBytecodes(5);
                    intConsumer.accept(n5);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.preAccept();
                ((int[])(Object)this.curChunk)[this.elementIndex++] = n;
                BytecodeManager.incBytecodes(12);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public int get(final long n) {
            try {
                BytecodeManager.incBytecodes(3);
                final int chunk = this.chunkFor(n);
                BytecodeManager.incBytecodes(1);
                final int spineIndex = this.spineIndex;
                BytecodeManager.incBytecodes(3);
                if (spineIndex == 0) {
                    final int n2 = chunk;
                    BytecodeManager.incBytecodes(2);
                    if (n2 == 0) {
                        final int n3 = ((int[])(Object)this.curChunk)[(int)n];
                        BytecodeManager.incBytecodes(7);
                        return n3;
                    }
                }
                final int n4 = ((int[][])(Object)this.spine)[chunk][(int)(n - this.priorElementCount[chunk])];
                BytecodeManager.incBytecodes(14);
                return n4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public PrimitiveIterator.OfInt iterator() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfInt spliterator = this.spliterator();
                BytecodeManager.incBytecodes(1);
                final PrimitiveIterator.OfInt iterator = Spliterators.iterator(spliterator);
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Spliterator.OfInt spliterator() {
            try {
                final int n = 0;
                final int spineIndex = this.spineIndex;
                final int n2 = 0;
                final int elementIndex = this.elementIndex;
                BytecodeManager.incBytecodes(10);
                class Splitr extends BaseSpliterator<Spliterator.OfInt> implements Spliterator.OfInt
                {
                    Splitr(final int n2, final int n3, final int n4) {
                        try {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(7);
                            super(n, n2, n3, n4);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    Splitr newSpliterator(final int n, final int n2, final int n3, final int n4) {
                        try {
                            final SpinedBuffer.OfInt this$0 = SpinedBuffer.OfInt.this;
                            BytecodeManager.incBytecodes(9);
                            final Splitr splitr = this$0.new Splitr(n, n2, n3, n4);
                            BytecodeManager.incBytecodes(1);
                            return splitr;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    void arrayForOne(final int[] array, final int n, final IntConsumer intConsumer) {
                        try {
                            final int n2 = array[n];
                            BytecodeManager.incBytecodes(5);
                            intConsumer.accept(n2);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    Spliterator.OfInt arraySpliterator(final int[] array, final int n, final int n2) {
                        try {
                            final int n3 = n + n2;
                            BytecodeManager.incBytecodes(6);
                            final Spliterator.OfInt spliterator = Arrays.spliterator(array, n, n3);
                            BytecodeManager.incBytecodes(1);
                            return spliterator;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                }
                final Splitr splitr = new Splitr(n, spineIndex, n2, elementIndex);
                BytecodeManager.incBytecodes(1);
                return splitr;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(2);
                final int[] array = ((OfPrimitive<E, int[], T_CONS>)this).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final int length = array.length;
                final int n = 200;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final String format = "%s[length=%d, chunks=%d]%s";
                    final Object[] args = new Object[4];
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends OfInt> class1 = this.getClass();
                    BytecodeManager.incBytecodes(1);
                    args[n2] = class1.getSimpleName();
                    final int n3 = 1;
                    final int length2 = array.length;
                    BytecodeManager.incBytecodes(6);
                    args[n3] = length2;
                    final int n4 = 2;
                    final int spineIndex = this.spineIndex;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    args[n4] = spineIndex;
                    final int n5 = 3;
                    final int[] array2 = array;
                    BytecodeManager.incBytecodes(5);
                    args[n5] = Arrays.toString(array2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    return format2;
                }
                final int[] array3 = array;
                final int n6 = 200;
                BytecodeManager.incBytecodes(3);
                final int[] copy = Arrays.copyOf(array3, n6);
                BytecodeManager.incBytecodes(1);
                final String format3 = "%s[length=%d, chunks=%d]%s...";
                final Object[] args2 = new Object[4];
                final int n7 = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final Class<? extends OfInt> class2 = this.getClass();
                BytecodeManager.incBytecodes(1);
                args2[n7] = class2.getSimpleName();
                final int n8 = 1;
                final int length3 = array.length;
                BytecodeManager.incBytecodes(6);
                args2[n8] = length3;
                final int n9 = 2;
                final int spineIndex2 = this.spineIndex;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                args2[n9] = spineIndex2;
                final int n10 = 3;
                final int[] array4 = copy;
                BytecodeManager.incBytecodes(5);
                args2[n10] = Arrays.toString(array4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format4 = String.format(format3, args2);
                BytecodeManager.incBytecodes(1);
                return format4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class OfLong extends OfPrimitive<Long, long[], LongConsumer> implements LongConsumer
    {
        OfLong() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        OfLong(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                super(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final Consumer<? super Long> consumer) {
            try {
                final boolean b = consumer instanceof LongConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final LongConsumer longConsumer = (LongConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    ((OfPrimitive<E, T_ARR, LongConsumer>)this).forEach(longConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfLong> class1 = this.getClass();
                        final String s = "{0} calling SpinedBuffer.OfLong.forEach(Consumer)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(2);
                    final Spliterator.OfLong spliterator = this.spliterator();
                    BytecodeManager.incBytecodes(2);
                    spliterator.forEachRemaining(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected long[][] newArrayArray(final int n) {
            try {
                final long[][] array = new long[n][];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long[] newArray(final int n) {
            try {
                final long[] array = new long[n];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected int arrayLength(final long[] array) {
            try {
                final int length = array.length;
                BytecodeManager.incBytecodes(3);
                return length;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected void arrayForEach(final long[] array, final int n, final int n2, final LongConsumer longConsumer) {
            try {
                int n3 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n2) {
                        break;
                    }
                    final long n5 = array[n3];
                    BytecodeManager.incBytecodes(5);
                    longConsumer.accept(n5);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final long n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.preAccept();
                ((long[])(Object)this.curChunk)[this.elementIndex++] = n;
                BytecodeManager.incBytecodes(12);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public long get(final long n) {
            try {
                BytecodeManager.incBytecodes(3);
                final int chunk = this.chunkFor(n);
                BytecodeManager.incBytecodes(1);
                final int spineIndex = this.spineIndex;
                BytecodeManager.incBytecodes(3);
                if (spineIndex == 0) {
                    final int n2 = chunk;
                    BytecodeManager.incBytecodes(2);
                    if (n2 == 0) {
                        final long n3 = ((long[])(Object)this.curChunk)[(int)n];
                        BytecodeManager.incBytecodes(7);
                        return n3;
                    }
                }
                final long n4 = ((long[][])(Object)this.spine)[chunk][(int)(n - this.priorElementCount[chunk])];
                BytecodeManager.incBytecodes(14);
                return n4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public PrimitiveIterator.OfLong iterator() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfLong spliterator = this.spliterator();
                BytecodeManager.incBytecodes(1);
                final PrimitiveIterator.OfLong iterator = Spliterators.iterator(spliterator);
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Spliterator.OfLong spliterator() {
            try {
                final int n = 0;
                final int spineIndex = this.spineIndex;
                final int n2 = 0;
                final int elementIndex = this.elementIndex;
                BytecodeManager.incBytecodes(10);
                class Splitr extends BaseSpliterator<Spliterator.OfLong> implements Spliterator.OfLong
                {
                    Splitr(final int n2, final int n3, final int n4) {
                        try {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(7);
                            super(n, n2, n3, n4);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    Splitr newSpliterator(final int n, final int n2, final int n3, final int n4) {
                        try {
                            final SpinedBuffer.OfLong this$0 = SpinedBuffer.OfLong.this;
                            BytecodeManager.incBytecodes(9);
                            final Splitr splitr = this$0.new Splitr(n, n2, n3, n4);
                            BytecodeManager.incBytecodes(1);
                            return splitr;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    void arrayForOne(final long[] array, final int n, final LongConsumer longConsumer) {
                        try {
                            final long n2 = array[n];
                            BytecodeManager.incBytecodes(5);
                            longConsumer.accept(n2);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    Spliterator.OfLong arraySpliterator(final long[] array, final int n, final int n2) {
                        try {
                            final int n3 = n + n2;
                            BytecodeManager.incBytecodes(6);
                            final Spliterator.OfLong spliterator = Arrays.spliterator(array, n, n3);
                            BytecodeManager.incBytecodes(1);
                            return spliterator;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                }
                final Splitr splitr = new Splitr(n, spineIndex, n2, elementIndex);
                BytecodeManager.incBytecodes(1);
                return splitr;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(2);
                final long[] array = ((OfPrimitive<E, long[], T_CONS>)this).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final int length = array.length;
                final int n = 200;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final String format = "%s[length=%d, chunks=%d]%s";
                    final Object[] args = new Object[4];
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends OfLong> class1 = this.getClass();
                    BytecodeManager.incBytecodes(1);
                    args[n2] = class1.getSimpleName();
                    final int n3 = 1;
                    final int length2 = array.length;
                    BytecodeManager.incBytecodes(6);
                    args[n3] = length2;
                    final int n4 = 2;
                    final int spineIndex = this.spineIndex;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    args[n4] = spineIndex;
                    final int n5 = 3;
                    final long[] array2 = array;
                    BytecodeManager.incBytecodes(5);
                    args[n5] = Arrays.toString(array2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    return format2;
                }
                final long[] array3 = array;
                final int n6 = 200;
                BytecodeManager.incBytecodes(3);
                final long[] copy = Arrays.copyOf(array3, n6);
                BytecodeManager.incBytecodes(1);
                final String format3 = "%s[length=%d, chunks=%d]%s...";
                final Object[] args2 = new Object[4];
                final int n7 = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final Class<? extends OfLong> class2 = this.getClass();
                BytecodeManager.incBytecodes(1);
                args2[n7] = class2.getSimpleName();
                final int n8 = 1;
                final int length3 = array.length;
                BytecodeManager.incBytecodes(6);
                args2[n8] = length3;
                final int n9 = 2;
                final int spineIndex2 = this.spineIndex;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                args2[n9] = spineIndex2;
                final int n10 = 3;
                final long[] array4 = copy;
                BytecodeManager.incBytecodes(5);
                args2[n10] = Arrays.toString(array4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format4 = String.format(format3, args2);
                BytecodeManager.incBytecodes(1);
                return format4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class OfDouble extends OfPrimitive<Double, double[], DoubleConsumer> implements DoubleConsumer
    {
        OfDouble() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        OfDouble(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                super(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final Consumer<? super Double> consumer) {
            try {
                final boolean b = consumer instanceof DoubleConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final DoubleConsumer doubleConsumer = (DoubleConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    ((OfPrimitive<E, T_ARR, DoubleConsumer>)this).forEach(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfDouble> class1 = this.getClass();
                        final String s = "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(2);
                    final Spliterator.OfDouble spliterator = this.spliterator();
                    BytecodeManager.incBytecodes(2);
                    spliterator.forEachRemaining(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected double[][] newArrayArray(final int n) {
            try {
                final double[][] array = new double[n][];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public double[] newArray(final int n) {
            try {
                final double[] array = new double[n];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected int arrayLength(final double[] array) {
            try {
                final int length = array.length;
                BytecodeManager.incBytecodes(3);
                return length;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected void arrayForEach(final double[] array, final int n, final int n2, final DoubleConsumer doubleConsumer) {
            try {
                int n3 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n2) {
                        break;
                    }
                    final double n5 = array[n3];
                    BytecodeManager.incBytecodes(5);
                    doubleConsumer.accept(n5);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final double n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.preAccept();
                ((double[])(Object)this.curChunk)[this.elementIndex++] = n;
                BytecodeManager.incBytecodes(12);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public double get(final long n) {
            try {
                BytecodeManager.incBytecodes(3);
                final int chunk = this.chunkFor(n);
                BytecodeManager.incBytecodes(1);
                final int spineIndex = this.spineIndex;
                BytecodeManager.incBytecodes(3);
                if (spineIndex == 0) {
                    final int n2 = chunk;
                    BytecodeManager.incBytecodes(2);
                    if (n2 == 0) {
                        final double n3 = ((double[])(Object)this.curChunk)[(int)n];
                        BytecodeManager.incBytecodes(7);
                        return n3;
                    }
                }
                final double n4 = ((double[][])(Object)this.spine)[chunk][(int)(n - this.priorElementCount[chunk])];
                BytecodeManager.incBytecodes(14);
                return n4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public PrimitiveIterator.OfDouble iterator() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfDouble spliterator = this.spliterator();
                BytecodeManager.incBytecodes(1);
                final PrimitiveIterator.OfDouble iterator = Spliterators.iterator(spliterator);
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Spliterator.OfDouble spliterator() {
            try {
                final int n = 0;
                final int spineIndex = this.spineIndex;
                final int n2 = 0;
                final int elementIndex = this.elementIndex;
                BytecodeManager.incBytecodes(10);
                class Splitr extends BaseSpliterator<Spliterator.OfDouble> implements Spliterator.OfDouble
                {
                    Splitr(final int n2, final int n3, final int n4) {
                        try {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(7);
                            super(n, n2, n3, n4);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    Splitr newSpliterator(final int n, final int n2, final int n3, final int n4) {
                        try {
                            final SpinedBuffer.OfDouble this$0 = SpinedBuffer.OfDouble.this;
                            BytecodeManager.incBytecodes(9);
                            final Splitr splitr = this$0.new Splitr(n, n2, n3, n4);
                            BytecodeManager.incBytecodes(1);
                            return splitr;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    void arrayForOne(final double[] array, final int n, final DoubleConsumer doubleConsumer) {
                        try {
                            final double n2 = array[n];
                            BytecodeManager.incBytecodes(5);
                            doubleConsumer.accept(n2);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    Spliterator.OfDouble arraySpliterator(final double[] array, final int n, final int n2) {
                        try {
                            final int n3 = n + n2;
                            BytecodeManager.incBytecodes(6);
                            final Spliterator.OfDouble spliterator = Arrays.spliterator(array, n, n3);
                            BytecodeManager.incBytecodes(1);
                            return spliterator;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                }
                final Splitr splitr = new Splitr(n, spineIndex, n2, elementIndex);
                BytecodeManager.incBytecodes(1);
                return splitr;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(2);
                final double[] array = ((OfPrimitive<E, double[], T_CONS>)this).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final int length = array.length;
                final int n = 200;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final String format = "%s[length=%d, chunks=%d]%s";
                    final Object[] args = new Object[4];
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends OfDouble> class1 = this.getClass();
                    BytecodeManager.incBytecodes(1);
                    args[n2] = class1.getSimpleName();
                    final int n3 = 1;
                    final int length2 = array.length;
                    BytecodeManager.incBytecodes(6);
                    args[n3] = length2;
                    final int n4 = 2;
                    final int spineIndex = this.spineIndex;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    args[n4] = spineIndex;
                    final int n5 = 3;
                    final double[] array2 = array;
                    BytecodeManager.incBytecodes(5);
                    args[n5] = Arrays.toString(array2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    return format2;
                }
                final double[] array3 = array;
                final int n6 = 200;
                BytecodeManager.incBytecodes(3);
                final double[] copy = Arrays.copyOf(array3, n6);
                BytecodeManager.incBytecodes(1);
                final String format3 = "%s[length=%d, chunks=%d]%s...";
                final Object[] args2 = new Object[4];
                final int n7 = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final Class<? extends OfDouble> class2 = this.getClass();
                BytecodeManager.incBytecodes(1);
                args2[n7] = class2.getSimpleName();
                final int n8 = 1;
                final int length3 = array.length;
                BytecodeManager.incBytecodes(6);
                args2[n8] = length3;
                final int n9 = 2;
                final int spineIndex2 = this.spineIndex;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                args2[n9] = spineIndex2;
                final int n10 = 3;
                final double[] array4 = copy;
                BytecodeManager.incBytecodes(5);
                args2[n10] = Arrays.toString(array4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format4 = String.format(format3, args2);
                BytecodeManager.incBytecodes(1);
                return format4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
