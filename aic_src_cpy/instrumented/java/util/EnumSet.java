// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable
{
    final Class<E> elementType;
    final Enum<?>[] universe;
    private static Enum<?>[] ZERO_LENGTH_ENUM_ARRAY;
    
    EnumSet(final Class<E> elementType, final Enum<?>[] universe) {
        try {
            BytecodeManager.incBytecodes(2);
            this.elementType = elementType;
            BytecodeManager.incBytecodes(3);
            this.universe = universe;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> noneOf(final Class<E> obj) {
        try {
            BytecodeManager.incBytecodes(2);
            final E[] universe = getUniverse(obj);
            BytecodeManager.incBytecodes(1);
            final E[] array = universe;
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(obj);
                final String str = " not an enum";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final ClassCastException ex = new ClassCastException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int length = universe.length;
            final int n = 64;
            BytecodeManager.incBytecodes(4);
            if (length <= n) {
                final E[] array2 = universe;
                BytecodeManager.incBytecodes(5);
                final RegularEnumSet set = new RegularEnumSet<E>((Class<Enum>)obj, array2);
                BytecodeManager.incBytecodes(1);
                return (EnumSet<E>)set;
            }
            final E[] array3 = universe;
            BytecodeManager.incBytecodes(5);
            final JumboEnumSet set2 = new JumboEnumSet<E>((Class<Enum>)obj, array3);
            BytecodeManager.incBytecodes(1);
            return (EnumSet<E>)set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> allOf(final Class<E> clazz) {
        try {
            BytecodeManager.incBytecodes(2);
            final EnumSet<Enum> none = noneOf((Class<Enum>)clazz);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = (EnumSet<E>)none;
            BytecodeManager.incBytecodes(2);
            set.addAll();
            final EnumSet<E> set2 = (EnumSet<E>)none;
            BytecodeManager.incBytecodes(2);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    abstract void addAll();
    
    public static <E extends Enum<E>> EnumSet<E> copyOf(final EnumSet<E> set) {
        try {
            BytecodeManager.incBytecodes(2);
            final EnumSet<E> clone = set.clone();
            BytecodeManager.incBytecodes(1);
            return clone;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> copyOf(final Collection<E> collection) {
        try {
            final boolean b = collection instanceof EnumSet;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final EnumSet<E> set = (EnumSet<E>)collection;
                BytecodeManager.incBytecodes(3);
                final EnumSet<E> clone = set.clone();
                BytecodeManager.incBytecodes(1);
                return clone;
            }
            BytecodeManager.incBytecodes(2);
            final boolean empty = collection.isEmpty();
            BytecodeManager.incBytecodes(1);
            if (empty) {
                final String s = "Collection is empty";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator2 = iterator;
            BytecodeManager.incBytecodes(2);
            final Enum<E> enum1 = iterator2.next();
            BytecodeManager.incBytecodes(2);
            final Enum<E> enum2 = enum1;
            BytecodeManager.incBytecodes(2);
            final EnumSet<E> of = of(enum2);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<E> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator3.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final EnumSet<E> set2 = of;
                final Iterator<E> iterator4 = iterator;
                BytecodeManager.incBytecodes(3);
                final Enum<E> next = iterator4.next();
                BytecodeManager.incBytecodes(1);
                set2.add((E)next);
                BytecodeManager.incBytecodes(2);
            }
            final EnumSet<E> set3 = of;
            BytecodeManager.incBytecodes(2);
            return set3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> complementOf(final EnumSet<E> set) {
        try {
            BytecodeManager.incBytecodes(2);
            final EnumSet<Enum> copy = copyOf((EnumSet<Enum>)set);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set2 = (EnumSet<E>)copy;
            BytecodeManager.incBytecodes(2);
            set2.complement();
            final EnumSet<E> set3 = (EnumSet<E>)copy;
            BytecodeManager.incBytecodes(2);
            return set3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<E> declaringClass = e.getDeclaringClass();
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> none = noneOf(declaringClass);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = none;
            BytecodeManager.incBytecodes(3);
            set.add(e);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set2 = none;
            BytecodeManager.incBytecodes(2);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(final E e, final E e2) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<E> declaringClass = e.getDeclaringClass();
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> none = noneOf(declaringClass);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = none;
            BytecodeManager.incBytecodes(3);
            set.add(e);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set2 = none;
            BytecodeManager.incBytecodes(3);
            set2.add(e2);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set3 = none;
            BytecodeManager.incBytecodes(2);
            return set3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(final E e, final E e2, final E e3) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<E> declaringClass = e.getDeclaringClass();
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> none = noneOf(declaringClass);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = none;
            BytecodeManager.incBytecodes(3);
            set.add(e);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set2 = none;
            BytecodeManager.incBytecodes(3);
            set2.add(e2);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set3 = none;
            BytecodeManager.incBytecodes(3);
            set3.add(e3);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set4 = none;
            BytecodeManager.incBytecodes(2);
            return set4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(final E e, final E e2, final E e3, final E e4) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<E> declaringClass = e.getDeclaringClass();
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> none = noneOf(declaringClass);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = none;
            BytecodeManager.incBytecodes(3);
            set.add(e);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set2 = none;
            BytecodeManager.incBytecodes(3);
            set2.add(e2);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set3 = none;
            BytecodeManager.incBytecodes(3);
            set3.add(e3);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set4 = none;
            BytecodeManager.incBytecodes(3);
            set4.add(e4);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set5 = none;
            BytecodeManager.incBytecodes(2);
            return set5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(final E e, final E e2, final E e3, final E e4, final E e5) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<E> declaringClass = e.getDeclaringClass();
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> none = noneOf(declaringClass);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = none;
            BytecodeManager.incBytecodes(3);
            set.add(e);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set2 = none;
            BytecodeManager.incBytecodes(3);
            set2.add(e2);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set3 = none;
            BytecodeManager.incBytecodes(3);
            set3.add(e3);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set4 = none;
            BytecodeManager.incBytecodes(3);
            set4.add(e4);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set5 = none;
            BytecodeManager.incBytecodes(3);
            set5.add(e5);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set6 = none;
            BytecodeManager.incBytecodes(2);
            return set6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @SafeVarargs
    public static <E extends Enum<E>> EnumSet<E> of(final E e, final E... array) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<E> declaringClass = e.getDeclaringClass();
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> none = noneOf(declaringClass);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = none;
            BytecodeManager.incBytecodes(3);
            set.add(e);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            int n = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final Enum<E> enum1 = array[n];
                BytecodeManager.incBytecodes(4);
                final EnumSet<E> set2 = none;
                final Enum<E> enum2 = enum1;
                BytecodeManager.incBytecodes(3);
                set2.add((E)enum2);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final EnumSet<E> set3 = none;
            BytecodeManager.incBytecodes(2);
            return set3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E extends Enum<E>> EnumSet<E> range(final E obj, final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final int compareTo = obj.compareTo(e);
            BytecodeManager.incBytecodes(1);
            if (compareTo > 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(obj);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(e);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final Class<E> declaringClass = obj.getDeclaringClass();
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> none = noneOf(declaringClass);
            BytecodeManager.incBytecodes(1);
            final EnumSet<E> set = none;
            BytecodeManager.incBytecodes(4);
            set.addRange(obj, e);
            final EnumSet<E> set2 = none;
            BytecodeManager.incBytecodes(2);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    abstract void addRange(final E p0, final E p1);
    
    public EnumSet<E> clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final EnumSet set = (EnumSet)super.clone();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            catch (CloneNotSupportedException ex) {
                BytecodeManager.incBytecodes(501);
                final CloneNotSupportedException detailMessage = ex;
                BytecodeManager.incBytecodes(4);
                final AssertionError assertionError = new AssertionError((Object)detailMessage);
                BytecodeManager.incBytecodes(1);
                throw assertionError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    abstract void complement();
    
    final void typeCheck(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<? extends Enum> class1 = e.getClass();
            BytecodeManager.incBytecodes(1);
            final Class<? extends Enum> clazz = class1;
            final Class<E> elementType = this.elementType;
            BytecodeManager.incBytecodes(4);
            if (clazz != elementType) {
                final Class<E> clazz2 = (Class<E>)class1;
                BytecodeManager.incBytecodes(2);
                final Class<? super E> superclass = clazz2.getSuperclass();
                final Class<E> elementType2 = this.elementType;
                BytecodeManager.incBytecodes(3);
                if (superclass != elementType2) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final Class<E> obj = (Class<E>)class1;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(obj);
                    final String str = " != ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str);
                    final Class<E> elementType3 = this.elementType;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append3 = append2.append(elementType3);
                    BytecodeManager.incBytecodes(1);
                    final String string = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    final ClassCastException ex = new ClassCastException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <E extends Enum<E>> E[] getUniverse(final Class<E> clazz) {
        try {
            BytecodeManager.incBytecodes(1);
            final JavaLangAccess javaLangAccess = SharedSecrets.getJavaLangAccess();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Enum[] enumConstantsShared = javaLangAccess.getEnumConstantsShared((Class)clazz);
            BytecodeManager.incBytecodes(1);
            return (E[])enumConstantsShared;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Object writeReplace() {
        try {
            BytecodeManager.incBytecodes(4);
            final SerializationProxy serializationProxy = new SerializationProxy(this);
            BytecodeManager.incBytecodes(1);
            return serializationProxy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws InvalidObjectException {
        try {
            final String reason = "Proxy required";
            BytecodeManager.incBytecodes(4);
            final InvalidObjectException ex = new InvalidObjectException(reason);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Enum[] access$000() {
        try {
            final Enum<?>[] zero_LENGTH_ENUM_ARRAY = EnumSet.ZERO_LENGTH_ENUM_ARRAY;
            BytecodeManager.incBytecodes(2);
            return zero_LENGTH_ENUM_ARRAY;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            EnumSet.ZERO_LENGTH_ENUM_ARRAY = (Enum<?>[])new Enum[0];
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class SerializationProxy<E extends Enum<E>> implements Serializable
    {
        private final Class<E> elementType;
        private final Enum<?>[] elements;
        private static final long serialVersionUID = 362491234563181265L;
        
        SerializationProxy(final EnumSet<E> set) {
            try {
                BytecodeManager.incBytecodes(2);
                this.elementType = set.elementType;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(3);
                final Enum[] access$000 = EnumSet.access$000();
                BytecodeManager.incBytecodes(1);
                this.elements = set.toArray(access$000);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final Class<E> elementType = this.elementType;
                BytecodeManager.incBytecodes(3);
                final EnumSet<E> none = EnumSet.noneOf(elementType);
                BytecodeManager.incBytecodes(1);
                final Enum<?>[] elements = this.elements;
                final int length = elements.length;
                int n = 0;
                BytecodeManager.incBytecodes(8);
                while (true) {
                    final int n2 = n;
                    final int n3 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n2 >= n3) {
                        break;
                    }
                    final Enum<?> enum1 = elements[n];
                    BytecodeManager.incBytecodes(4);
                    final EnumSet<E> set = none;
                    final Enum<?> enum2 = enum1;
                    BytecodeManager.incBytecodes(3);
                    set.add((E)enum2);
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final EnumSet<E> set2 = none;
                BytecodeManager.incBytecodes(2);
                return set2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
