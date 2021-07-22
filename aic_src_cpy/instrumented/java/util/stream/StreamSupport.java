// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.Supplier;
import instrumented.java.util.Objects;
import instrumented.java.util.Spliterator;
import aic2021.engine.BytecodeManager;

public final class StreamSupport
{
    private StreamSupport() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Stream<T> stream(final Spliterator<T> spliterator, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(spliterator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(spliterator);
            BytecodeManager.incBytecodes(2);
            final ReferencePipeline.Head head = new ReferencePipeline.Head<Object, T>(spliterator, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return (Stream<T>)head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Stream<T> stream(final Supplier<? extends Spliterator<T>> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(n);
            BytecodeManager.incBytecodes(2);
            final ReferencePipeline.Head head = new ReferencePipeline.Head<Object, T>(supplier, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return (Stream<T>)head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static IntStream intStream(final Spliterator.OfInt ofInt, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(ofInt);
            BytecodeManager.incBytecodes(2);
            final IntPipeline.Head head = new IntPipeline.Head<Object>(ofInt, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static IntStream intStream(final Supplier<? extends Spliterator.OfInt> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(n);
            BytecodeManager.incBytecodes(2);
            final IntPipeline.Head head = new IntPipeline.Head<Object>(supplier, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static LongStream longStream(final Spliterator.OfLong ofLong, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(ofLong);
            BytecodeManager.incBytecodes(2);
            final LongPipeline.Head head = new LongPipeline.Head<Object>(ofLong, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static LongStream longStream(final Supplier<? extends Spliterator.OfLong> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(n);
            BytecodeManager.incBytecodes(2);
            final LongPipeline.Head head = new LongPipeline.Head<Object>(supplier, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static DoubleStream doubleStream(final Spliterator.OfDouble ofDouble, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(ofDouble);
            BytecodeManager.incBytecodes(2);
            final DoublePipeline.Head head = new DoublePipeline.Head<Object>(ofDouble, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static DoubleStream doubleStream(final Supplier<? extends Spliterator.OfDouble> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int fromCharacteristics = StreamOpFlag.fromCharacteristics(n);
            BytecodeManager.incBytecodes(2);
            final DoublePipeline.Head head = new DoublePipeline.Head<Object>(supplier, fromCharacteristics, b);
            BytecodeManager.incBytecodes(1);
            return head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
