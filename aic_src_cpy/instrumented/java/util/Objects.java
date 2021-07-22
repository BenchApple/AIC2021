// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Supplier;
import aic2021.engine.BytecodeManager;

public final class Objects
{
    private Objects() {
        try {
            BytecodeManager.incBytecodes(2);
            final String detailMessage = "No java.util.Objects instances for you!";
            BytecodeManager.incBytecodes(4);
            final AssertionError assertionError = new AssertionError((Object)detailMessage);
            BytecodeManager.incBytecodes(1);
            throw assertionError;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final Object o, final Object obj) {
        try {
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0052: {
                Label_0037: {
                    if (o != obj) {
                        BytecodeManager.incBytecodes(2);
                        if (o != null) {
                            BytecodeManager.incBytecodes(3);
                            final boolean equals = o.equals(obj);
                            BytecodeManager.incBytecodes(1);
                            if (equals) {
                                break Label_0037;
                            }
                        }
                        b = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0052;
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
    
    public static boolean deepEquals(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (o == o2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (o != null) {
                BytecodeManager.incBytecodes(2);
                if (o2 != null) {
                    BytecodeManager.incBytecodes(3);
                    final boolean deepEquals0 = Arrays.deepEquals0(o, o2);
                    BytecodeManager.incBytecodes(1);
                    return deepEquals0;
                }
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            int hashCode;
            if (o != null) {
                BytecodeManager.incBytecodes(2);
                hashCode = o.hashCode();
                BytecodeManager.incBytecodes(1);
            }
            else {
                hashCode = 0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return hashCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hash(final Object... array) {
        try {
            BytecodeManager.incBytecodes(2);
            final int hashCode = Arrays.hashCode(array);
            BytecodeManager.incBytecodes(1);
            return hashCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final Object obj) {
        try {
            BytecodeManager.incBytecodes(2);
            final String value = String.valueOf(obj);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final Object o, final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            String string;
            if (o != null) {
                BytecodeManager.incBytecodes(2);
                string = o.toString();
                BytecodeManager.incBytecodes(1);
            }
            else {
                string = s;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> int compare(final T t, final T t2, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(3);
            int compare;
            if (t == t2) {
                compare = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(4);
                compare = comparator.compare(t, t2);
            }
            BytecodeManager.incBytecodes(1);
            return compare;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> T requireNonNull(final T t) {
        try {
            BytecodeManager.incBytecodes(2);
            if (t == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            return t;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> T requireNonNull(final T t, final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            if (t == null) {
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            return t;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean isNull(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (o == null) {
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
    
    public static boolean nonNull(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (o != null) {
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
    
    public static <T> T requireNonNull(final T t, final Supplier<String> supplier) {
        try {
            BytecodeManager.incBytecodes(2);
            if (t == null) {
                BytecodeManager.incBytecodes(4);
                final String s = supplier.get();
                BytecodeManager.incBytecodes(2);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            return t;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
