// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Comparator;
import instrumented.java.util.Spliterator;
import instrumented.java.util.EnumMap;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Map;

enum StreamOpFlag
{
    DISTINCT(n2, setAndClear), 
    SORTED(n4, setAndClear2), 
    ORDERED(n6, clear2), 
    SIZED(n8, clear3), 
    SHORT_CIRCUIT(n10, set10);
    
    private static final int SET_BITS = 1;
    private static final int CLEAR_BITS = 2;
    private static final int PRESERVE_BITS = 3;
    private final Map<Type, Integer> maskTable;
    private final int bitPosition;
    private final int set;
    private final int clear;
    private final int preserve;
    static final int SPLITERATOR_CHARACTERISTICS_MASK;
    static final int STREAM_MASK;
    static final int OP_MASK;
    static final int TERMINAL_OP_MASK;
    static final int UPSTREAM_TERMINAL_OP_MASK;
    private static final int FLAG_MASK;
    private static final int FLAG_MASK_IS;
    private static final int FLAG_MASK_NOT;
    static final int INITIAL_OPS_VALUE;
    static final int IS_DISTINCT;
    static final int NOT_DISTINCT;
    static final int IS_SORTED;
    static final int NOT_SORTED;
    static final int IS_ORDERED;
    static final int NOT_ORDERED;
    static final int IS_SIZED;
    static final int NOT_SIZED;
    static final int IS_SHORT_CIRCUIT;
    
    private static MaskBuilder set(final Type type) {
        try {
            final Class<Type> clazz = Type.class;
            BytecodeManager.incBytecodes(6);
            final EnumMap enumMap = new EnumMap<Type, Integer>((Class<Enum>)clazz);
            BytecodeManager.incBytecodes(1);
            final MaskBuilder maskBuilder = new MaskBuilder((Map<Type, Integer>)enumMap);
            BytecodeManager.incBytecodes(2);
            final MaskBuilder set = maskBuilder.set(type);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private StreamOpFlag(int bitPosition, final MaskBuilder maskBuilder) {
        try {
            BytecodeManager.incBytecodes(4);
            super(name, ordinal);
            BytecodeManager.incBytecodes(3);
            this.maskTable = maskBuilder.build();
            BytecodeManager.incBytecodes(1);
            bitPosition *= 2;
            BytecodeManager.incBytecodes(4);
            this.bitPosition = bitPosition;
            BytecodeManager.incBytecodes(3);
            this.set = 1 << bitPosition;
            BytecodeManager.incBytecodes(5);
            this.clear = 2 << bitPosition;
            BytecodeManager.incBytecodes(5);
            this.preserve = 3 << bitPosition;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int set() {
        try {
            final int set = this.set;
            BytecodeManager.incBytecodes(3);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int clear() {
        try {
            final int clear = this.clear;
            BytecodeManager.incBytecodes(3);
            return clear;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean isStreamFlag() {
        try {
            final Map<Type, Integer> maskTable = this.maskTable;
            final Type stream = Type.STREAM;
            BytecodeManager.incBytecodes(4);
            final Integer n = maskTable.get(stream);
            BytecodeManager.incBytecodes(2);
            final int intValue = n;
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (intValue > 0) {
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
    
    boolean isKnown(final int n) {
        try {
            final int n2 = n & this.preserve;
            final int set = this.set;
            BytecodeManager.incBytecodes(7);
            boolean b;
            if (n2 == set) {
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
    
    boolean isCleared(final int n) {
        try {
            final int n2 = n & this.preserve;
            final int clear = this.clear;
            BytecodeManager.incBytecodes(7);
            boolean b;
            if (n2 == clear) {
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
    
    boolean isPreserved(final int n) {
        try {
            final int n2 = n & this.preserve;
            final int preserve = this.preserve;
            BytecodeManager.incBytecodes(7);
            boolean b;
            if (n2 == preserve) {
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
    
    boolean canSet(final Type type) {
        try {
            final Map<Type, Integer> maskTable = this.maskTable;
            BytecodeManager.incBytecodes(4);
            final Integer n = maskTable.get(type);
            BytecodeManager.incBytecodes(2);
            final int n2 = n & 0x1;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (n2 > 0) {
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
    
    private static int createMask(final Type type) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final StreamOpFlag[] values = values();
            final int length = values.length;
            int n2 = 0;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final StreamOpFlag streamOpFlag = values[n2];
                BytecodeManager.incBytecodes(4);
                final int n5 = n;
                final Map<Type, Integer> maskTable = streamOpFlag.maskTable;
                BytecodeManager.incBytecodes(5);
                final Integer n6 = maskTable.get(type);
                BytecodeManager.incBytecodes(2);
                n = (n5 | n6 << streamOpFlag.bitPosition);
                BytecodeManager.incBytecodes(5);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = n;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int createFlagMask() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final StreamOpFlag[] values = values();
            final int length = values.length;
            int n2 = 0;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final StreamOpFlag streamOpFlag = values[n2];
                BytecodeManager.incBytecodes(4);
                n |= streamOpFlag.preserve;
                BytecodeManager.incBytecodes(5);
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
    
    private static int getMask(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            int flag_MASK;
            if (n == 0) {
                flag_MASK = StreamOpFlag.FLAG_MASK;
                BytecodeManager.incBytecodes(2);
            }
            else {
                flag_MASK = ~(n | (StreamOpFlag.FLAG_MASK_IS & n) << 1 | (StreamOpFlag.FLAG_MASK_NOT & n) >> 1);
                BytecodeManager.incBytecodes(15);
            }
            BytecodeManager.incBytecodes(1);
            return flag_MASK;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int combineOpFlags(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final int n3 = (n2 & getMask(n)) | n;
            BytecodeManager.incBytecodes(4);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int toStreamFlags(final int n) {
        try {
            final int n2 = ~n >> 1 & StreamOpFlag.FLAG_MASK_IS & n;
            BytecodeManager.incBytecodes(10);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int toCharacteristics(final int n) {
        try {
            final int n2 = n & StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int fromCharacteristics(final Spliterator<?> spliterator) {
        try {
            BytecodeManager.incBytecodes(2);
            final int characteristics = spliterator.characteristics();
            BytecodeManager.incBytecodes(1);
            final int n = characteristics & 0x4;
            BytecodeManager.incBytecodes(4);
            if (n != 0) {
                BytecodeManager.incBytecodes(2);
                final Comparator<?> comparator = spliterator.getComparator();
                BytecodeManager.incBytecodes(1);
                if (comparator != null) {
                    final int n2 = characteristics & StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK & 0xFFFFFFFB;
                    BytecodeManager.incBytecodes(6);
                    return n2;
                }
            }
            final int n3 = characteristics & StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK;
            BytecodeManager.incBytecodes(4);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int fromCharacteristics(final int n) {
        try {
            final int n2 = n & StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String s = "DISTINCT";
            final int n = 0;
            final int n2 = 0;
            final Type spliterator = Type.SPLITERATOR;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final MaskBuilder set = set(spliterator);
            final Type stream = Type.STREAM;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder set2 = set.set(stream);
            final Type op = Type.OP;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder setAndClear = set2.setAndClear(op);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String s2 = "SORTED";
            final int n3 = 1;
            final int n4 = 1;
            final Type spliterator2 = Type.SPLITERATOR;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final MaskBuilder set3 = set(spliterator2);
            final Type stream2 = Type.STREAM;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder set4 = set3.set(stream2);
            final Type op2 = Type.OP;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder setAndClear2 = set4.setAndClear(op2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String s3 = "ORDERED";
            final int n5 = 2;
            final int n6 = 2;
            final Type spliterator3 = Type.SPLITERATOR;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final MaskBuilder set5 = set(spliterator3);
            final Type stream3 = Type.STREAM;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder set6 = set5.set(stream3);
            final Type op3 = Type.OP;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder setAndClear3 = set6.setAndClear(op3);
            final Type terminal_OP = Type.TERMINAL_OP;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder clear = setAndClear3.clear(terminal_OP);
            final Type upstream_TERMINAL_OP = Type.UPSTREAM_TERMINAL_OP;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final MaskBuilder clear2 = clear.clear(upstream_TERMINAL_OP);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String s4 = "SIZED";
            final int n7 = 3;
            final int n8 = 3;
            final Type spliterator4 = Type.SPLITERATOR;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final MaskBuilder set7 = set(spliterator4);
            final Type stream4 = Type.STREAM;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder set8 = set7.set(stream4);
            final Type op4 = Type.OP;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder clear3 = set8.clear(op4);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String s5 = "SHORT_CIRCUIT";
            final int n9 = 4;
            final int n10 = 12;
            final Type op5 = Type.OP;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final MaskBuilder set9 = set(op5);
            final Type terminal_OP2 = Type.TERMINAL_OP;
            BytecodeManager.incBytecodes(2);
            final MaskBuilder set10 = set9.set(terminal_OP2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(22);
            final Type spliterator5 = Type.SPLITERATOR;
            BytecodeManager.incBytecodes(2);
            SPLITERATOR_CHARACTERISTICS_MASK = createMask(spliterator5);
            BytecodeManager.incBytecodes(1);
            final Type stream5 = Type.STREAM;
            BytecodeManager.incBytecodes(2);
            STREAM_MASK = createMask(stream5);
            BytecodeManager.incBytecodes(1);
            final Type op6 = Type.OP;
            BytecodeManager.incBytecodes(2);
            OP_MASK = createMask(op6);
            BytecodeManager.incBytecodes(1);
            final Type terminal_OP3 = Type.TERMINAL_OP;
            BytecodeManager.incBytecodes(2);
            TERMINAL_OP_MASK = createMask(terminal_OP3);
            BytecodeManager.incBytecodes(1);
            final Type upstream_TERMINAL_OP2 = Type.UPSTREAM_TERMINAL_OP;
            BytecodeManager.incBytecodes(2);
            UPSTREAM_TERMINAL_OP_MASK = createMask(upstream_TERMINAL_OP2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            FLAG_MASK = createFlagMask();
            BytecodeManager.incBytecodes(1);
            FLAG_MASK_IS = StreamOpFlag.STREAM_MASK;
            BytecodeManager.incBytecodes(2);
            FLAG_MASK_NOT = StreamOpFlag.STREAM_MASK << 1;
            BytecodeManager.incBytecodes(4);
            INITIAL_OPS_VALUE = (StreamOpFlag.FLAG_MASK_IS | StreamOpFlag.FLAG_MASK_NOT);
            BytecodeManager.incBytecodes(4);
            IS_DISTINCT = StreamOpFlag.DISTINCT.set;
            BytecodeManager.incBytecodes(3);
            NOT_DISTINCT = StreamOpFlag.DISTINCT.clear;
            BytecodeManager.incBytecodes(3);
            IS_SORTED = StreamOpFlag.SORTED.set;
            BytecodeManager.incBytecodes(3);
            NOT_SORTED = StreamOpFlag.SORTED.clear;
            BytecodeManager.incBytecodes(3);
            IS_ORDERED = StreamOpFlag.ORDERED.set;
            BytecodeManager.incBytecodes(3);
            NOT_ORDERED = StreamOpFlag.ORDERED.clear;
            BytecodeManager.incBytecodes(3);
            IS_SIZED = StreamOpFlag.SIZED.set;
            BytecodeManager.incBytecodes(3);
            NOT_SIZED = StreamOpFlag.SIZED.clear;
            BytecodeManager.incBytecodes(3);
            IS_SHORT_CIRCUIT = StreamOpFlag.SHORT_CIRCUIT.set;
            BytecodeManager.incBytecodes(4);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    enum Type
    {
        SPLITERATOR, 
        STREAM, 
        OP, 
        TERMINAL_OP, 
        UPSTREAM_TERMINAL_OP;
        
        private Type() {
            try {
                BytecodeManager.incBytecodes(4);
                super(name, ordinal);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String s = "SPLITERATOR";
                final int n = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s2 = "STREAM";
                final int n2 = 1;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s3 = "OP";
                final int n3 = 2;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s4 = "TERMINAL_OP";
                final int n4 = 3;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s5 = "UPSTREAM_TERMINAL_OP";
                final int n5 = 4;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(23);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class MaskBuilder
    {
        final Map<Type, Integer> map;
        
        MaskBuilder(final Map<Type, Integer> map) {
            try {
                BytecodeManager.incBytecodes(2);
                this.map = map;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        MaskBuilder mask(final Type type, final Integer n) {
            try {
                final Map<Type, Integer> map = this.map;
                BytecodeManager.incBytecodes(5);
                map.put(type, n);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        MaskBuilder set(final Type type) {
            try {
                final int i = 1;
                BytecodeManager.incBytecodes(4);
                final Integer value = i;
                BytecodeManager.incBytecodes(1);
                final MaskBuilder mask = this.mask(type, value);
                BytecodeManager.incBytecodes(1);
                return mask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        MaskBuilder clear(final Type type) {
            try {
                final int i = 2;
                BytecodeManager.incBytecodes(4);
                final Integer value = i;
                BytecodeManager.incBytecodes(1);
                final MaskBuilder mask = this.mask(type, value);
                BytecodeManager.incBytecodes(1);
                return mask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        MaskBuilder setAndClear(final Type type) {
            try {
                final int i = 3;
                BytecodeManager.incBytecodes(4);
                final Integer value = i;
                BytecodeManager.incBytecodes(1);
                final MaskBuilder mask = this.mask(type, value);
                BytecodeManager.incBytecodes(1);
                return mask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Map<Type, Integer> build() {
            try {
                BytecodeManager.incBytecodes(1);
                final Type[] values = Type.values();
                final int length = values.length;
                int n = 0;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final int n2 = n;
                    final int n3 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n2 >= n3) {
                        break;
                    }
                    final Type type = values[n];
                    BytecodeManager.incBytecodes(4);
                    final Map<Type, Integer> map = this.map;
                    final Type type2 = type;
                    final int i = 0;
                    BytecodeManager.incBytecodes(5);
                    final Integer value = i;
                    BytecodeManager.incBytecodes(1);
                    map.putIfAbsent(type2, value);
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final Map<Type, Integer> map2 = this.map;
                BytecodeManager.incBytecodes(3);
                return map2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
