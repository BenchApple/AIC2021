// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.io.IOException;
import java.io.DataOutputStream;
import instrumented.java.util.Collection;
import java.util.Iterator;
import instrumented.java.util.Set;
import instrumented.java.util.HashMap;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Map;

public class Attributes implements Map<Object, Object>, Cloneable
{
    protected Map<Object, Object> map;
    
    public Attributes() {
        try {
            final int size = 11;
            BytecodeManager.incBytecodes(3);
            this(size);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Attributes(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(5);
            this.map = new HashMap(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Attributes(final Attributes attributes) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(5);
            this.map = new HashMap((Map)attributes);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object get(final Object o) {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(4);
            final Object value = map.get(o);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getValue(final String name) {
        try {
            BytecodeManager.incBytecodes(5);
            final Name name2 = new Name(name);
            BytecodeManager.incBytecodes(1);
            final String s = (String)this.get(name2);
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getValue(final Name name) {
        try {
            BytecodeManager.incBytecodes(3);
            final String s = (String)this.get(name);
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        try {
            final Map map = this.map;
            final Name name = (Name)o;
            final String s = (String)o2;
            BytecodeManager.incBytecodes(7);
            final String put = map.put(name, s);
            BytecodeManager.incBytecodes(1);
            return put;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String putValue(final String name, final String value) {
        try {
            BytecodeManager.incBytecodes(5);
            final Name name2 = new Name(name);
            BytecodeManager.incBytecodes(2);
            final String s = (String)this.put(name2, value);
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object remove(final Object o) {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(4);
            final Object remove = map.remove(o);
            BytecodeManager.incBytecodes(1);
            return remove;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(4);
            final boolean containsValue = map.containsValue(o);
            BytecodeManager.incBytecodes(1);
            return containsValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsKey(final Object o) {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(4);
            final boolean containsKey = map.containsKey(o);
            BytecodeManager.incBytecodes(1);
            return containsKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void putAll(final Map<?, ?> map) {
        try {
            final Class<Attributes> clazz = Attributes.class;
            BytecodeManager.incBytecodes(3);
            final boolean instance = clazz.isInstance(map);
            BytecodeManager.incBytecodes(1);
            if (!instance) {
                BytecodeManager.incBytecodes(3);
                final ClassCastException ex = new ClassCastException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final Set<Entry<?, ?>> entrySet = map.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<Object, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Entry<Object, V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Entry<Object, V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Entry<Object, V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Entry<Object, V> entry2 = entry;
                BytecodeManager.incBytecodes(3);
                final Object key = entry2.getKey();
                final Entry<Object, V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final V value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                this.put(key, value);
                BytecodeManager.incBytecodes(2);
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
            final Map map = this.map;
            BytecodeManager.incBytecodes(3);
            map.clear();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(3);
            final int size = map.size();
            BytecodeManager.incBytecodes(1);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(3);
            final boolean empty = map.isEmpty();
            BytecodeManager.incBytecodes(1);
            return empty;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Object> keySet() {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(3);
            final Set<Object> keySet = map.keySet();
            BytecodeManager.incBytecodes(1);
            return keySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Collection<Object> values() {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(3);
            final Collection<Object> values = map.values();
            BytecodeManager.incBytecodes(1);
            return values;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Entry<Object, Object>> entrySet() {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(3);
            final Set<Entry<Object, Object>> entrySet = map.entrySet();
            BytecodeManager.incBytecodes(1);
            return entrySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(4);
            final boolean equals = map.equals(o);
            BytecodeManager.incBytecodes(1);
            return equals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final Map map = this.map;
            BytecodeManager.incBytecodes(3);
            final int hashCode = map.hashCode();
            BytecodeManager.incBytecodes(1);
            return hashCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            BytecodeManager.incBytecodes(4);
            final Attributes attributes = new Attributes(this);
            BytecodeManager.incBytecodes(1);
            return attributes;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void write(final DataOutputStream dataOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final Set entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<Name, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Entry<Name, V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Entry<Name, V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Entry<Name, V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Entry<Name, V> entry2 = entry;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final Name name = entry2.getKey();
                BytecodeManager.incBytecodes(2);
                final String string = name.toString();
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb = new StringBuffer(string);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb2 = sb;
                final String str = ": ";
                BytecodeManager.incBytecodes(3);
                sb2.append(str);
                BytecodeManager.incBytecodes(1);
                final Entry<Name, V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                String s = (String)entry3.getValue();
                BytecodeManager.incBytecodes(2);
                final String s2 = s;
                BytecodeManager.incBytecodes(2);
                if (s2 != null) {
                    final String s3 = s;
                    final String charsetName = "UTF8";
                    BytecodeManager.incBytecodes(3);
                    final byte[] bytes = s3.getBytes(charsetName);
                    BytecodeManager.incBytecodes(1);
                    final byte[] ascii = bytes;
                    final int hibyte = 0;
                    final int offset = 0;
                    final int length = bytes.length;
                    BytecodeManager.incBytecodes(8);
                    s = new String(ascii, hibyte, offset, length);
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuffer sb3 = sb;
                final String str2 = s;
                BytecodeManager.incBytecodes(3);
                sb3.append(str2);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb4 = sb;
                final String str3 = "\r\n";
                BytecodeManager.incBytecodes(3);
                sb4.append(str3);
                BytecodeManager.incBytecodes(1);
                final StringBuffer line = sb;
                BytecodeManager.incBytecodes(2);
                Manifest.make72Safe(line);
                final StringBuffer sb5 = sb;
                BytecodeManager.incBytecodes(3);
                final String string2 = sb5.toString();
                BytecodeManager.incBytecodes(1);
                dataOutputStream.writeBytes(string2);
                BytecodeManager.incBytecodes(1);
            }
            final String s4 = "\r\n";
            BytecodeManager.incBytecodes(3);
            dataOutputStream.writeBytes(s4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void writeMain(final DataOutputStream dataOutputStream) throws IOException {
        try {
            final Name manifest_VERSION = Name.MANIFEST_VERSION;
            BytecodeManager.incBytecodes(2);
            String s = manifest_VERSION.toString();
            BytecodeManager.incBytecodes(1);
            final String name = s;
            BytecodeManager.incBytecodes(3);
            String s2 = this.getValue(name);
            BytecodeManager.incBytecodes(1);
            final String s3 = s2;
            BytecodeManager.incBytecodes(2);
            if (s3 == null) {
                final Name signature_VERSION = Name.SIGNATURE_VERSION;
                BytecodeManager.incBytecodes(2);
                s = signature_VERSION.toString();
                BytecodeManager.incBytecodes(1);
                final String name2 = s;
                BytecodeManager.incBytecodes(3);
                s2 = this.getValue(name2);
                BytecodeManager.incBytecodes(1);
            }
            final String s4 = s2;
            BytecodeManager.incBytecodes(2);
            if (s4 != null) {
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb = new StringBuilder();
                final String str = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = ": ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                final String str3 = s2;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str3);
                final String str4 = "\r\n";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string = append4.toString();
                BytecodeManager.incBytecodes(1);
                dataOutputStream.writeBytes(string);
            }
            BytecodeManager.incBytecodes(2);
            final Set entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<Name, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Entry<Name, V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Entry<Name, V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Entry<Name, V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Entry<Name, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final Name name3 = entry2.getKey();
                BytecodeManager.incBytecodes(2);
                final String string2 = name3.toString();
                BytecodeManager.incBytecodes(1);
                final String s5 = s2;
                BytecodeManager.incBytecodes(2);
                if (s5 != null) {
                    final String s6 = string2;
                    final String anotherString = s;
                    BytecodeManager.incBytecodes(3);
                    final boolean equalsIgnoreCase = s6.equalsIgnoreCase(anotherString);
                    BytecodeManager.incBytecodes(1);
                    if (!equalsIgnoreCase) {
                        final String str5 = string2;
                        BytecodeManager.incBytecodes(4);
                        final StringBuffer sb2 = new StringBuffer(str5);
                        BytecodeManager.incBytecodes(1);
                        final StringBuffer sb3 = sb2;
                        final String str6 = ": ";
                        BytecodeManager.incBytecodes(3);
                        sb3.append(str6);
                        BytecodeManager.incBytecodes(1);
                        final Entry<Name, V> entry3 = entry;
                        BytecodeManager.incBytecodes(2);
                        String s7 = (String)entry3.getValue();
                        BytecodeManager.incBytecodes(2);
                        final String s8 = s7;
                        BytecodeManager.incBytecodes(2);
                        if (s8 != null) {
                            final String s9 = s7;
                            final String charsetName = "UTF8";
                            BytecodeManager.incBytecodes(3);
                            final byte[] bytes = s9.getBytes(charsetName);
                            BytecodeManager.incBytecodes(1);
                            final byte[] ascii = bytes;
                            final int hibyte = 0;
                            final int offset = 0;
                            final int length = bytes.length;
                            BytecodeManager.incBytecodes(8);
                            s7 = new String(ascii, hibyte, offset, length);
                            BytecodeManager.incBytecodes(1);
                        }
                        final StringBuffer sb4 = sb2;
                        final String str7 = s7;
                        BytecodeManager.incBytecodes(3);
                        sb4.append(str7);
                        BytecodeManager.incBytecodes(1);
                        final StringBuffer sb5 = sb2;
                        final String str8 = "\r\n";
                        BytecodeManager.incBytecodes(3);
                        sb5.append(str8);
                        BytecodeManager.incBytecodes(1);
                        final StringBuffer line = sb2;
                        BytecodeManager.incBytecodes(2);
                        Manifest.make72Safe(line);
                        final StringBuffer sb6 = sb2;
                        BytecodeManager.incBytecodes(3);
                        final String string3 = sb6.toString();
                        BytecodeManager.incBytecodes(1);
                        dataOutputStream.writeBytes(string3);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            final String s10 = "\r\n";
            BytecodeManager.incBytecodes(3);
            dataOutputStream.writeBytes(s10);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void read(final Manifest.FastInputStream p0, final byte[] p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: aconst_null    
        //     3: astore          4
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aconst_null    
        //    11: astore          5
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: aload_1        
        //    19: aload_2        
        //    20: ldc             3
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   java/util/jar/Manifest$FastInputStream.readLine:([B)I
        //    28: dup            
        //    29: istore          6
        //    31: iconst_m1      
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: if_icmpeq       771
        //    40: iconst_0       
        //    41: istore          7
        //    43: ldc             2
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: aload_2        
        //    49: iinc            6, -1
        //    52: iload           6
        //    54: baload         
        //    55: bipush          10
        //    57: ldc             6
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_icmpeq       85
        //    65: new             Ljava/io/IOException;
        //    68: dup            
        //    69: ldc             "line too long"
        //    71: ldc             4
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: athrow         
        //    85: iload           6
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: ifle            119
        //    95: aload_2        
        //    96: iload           6
        //    98: iconst_1       
        //    99: isub           
        //   100: baload         
        //   101: bipush          13
        //   103: ldc             7
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: if_icmpne       119
        //   111: iinc            6, -1
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: iload           6
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: ifne            137
        //   129: ldc             1
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: goto            771
        //   137: iconst_0       
        //   138: istore          8
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: aload_2        
        //   146: iconst_0       
        //   147: baload         
        //   148: bipush          32
        //   150: ldc             5
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: if_icmpne       327
        //   158: aload_3        
        //   159: ldc             2
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: ifnonnull       187
        //   167: new             Ljava/io/IOException;
        //   170: dup            
        //   171: ldc             "misplaced continuation line"
        //   173: ldc             4
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   181: ldc             1
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: athrow         
        //   187: iconst_1       
        //   188: istore          7
        //   190: ldc             2
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: aload           5
        //   197: arraylength    
        //   198: iload           6
        //   200: iadd           
        //   201: iconst_1       
        //   202: isub           
        //   203: newarray        B
        //   205: astore          9
        //   207: ldc             7
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: aload           5
        //   214: iconst_0       
        //   215: aload           9
        //   217: iconst_0       
        //   218: aload           5
        //   220: arraylength    
        //   221: ldc             7
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   229: aload_2        
        //   230: iconst_1       
        //   231: aload           9
        //   233: aload           5
        //   235: arraylength    
        //   236: iload           6
        //   238: iconst_1       
        //   239: isub           
        //   240: ldc             9
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   248: aload_1        
        //   249: ldc             2
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: invokevirtual   java/util/jar/Manifest$FastInputStream.peek:()B
        //   257: bipush          32
        //   259: ldc             2
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: if_icmpne       284
        //   267: aload           9
        //   269: astore          5
        //   271: ldc             2
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: ldc             1
        //   278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   281: goto            18
        //   284: new             Ljava/lang/String;
        //   287: dup            
        //   288: aload           9
        //   290: iconst_0       
        //   291: aload           9
        //   293: arraylength    
        //   294: ldc             "UTF8"
        //   296: ldc             8
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: invokespecial   java/lang/String.<init>:([BIILjava/lang/String;)V
        //   304: astore          4
        //   306: ldc             1
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: aconst_null    
        //   312: astore          5
        //   314: ldc             2
        //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   319: ldc             1
        //   321: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   324: goto            527
        //   327: aload_2        
        //   328: iload           8
        //   330: iinc            8, 1
        //   333: baload         
        //   334: bipush          58
        //   336: ldc             6
        //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   341: if_icmpeq       376
        //   344: iload           8
        //   346: iload           6
        //   348: ldc             3
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: if_icmplt       327
        //   356: new             Ljava/io/IOException;
        //   359: dup            
        //   360: ldc             "invalid header field"
        //   362: ldc             4
        //   364: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   367: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   370: ldc             1
        //   372: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   375: athrow         
        //   376: aload_2        
        //   377: iload           8
        //   379: iinc            8, 1
        //   382: baload         
        //   383: bipush          32
        //   385: ldc             6
        //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   390: if_icmpeq       413
        //   393: new             Ljava/io/IOException;
        //   396: dup            
        //   397: ldc             "invalid header field"
        //   399: ldc             4
        //   401: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   404: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   407: ldc             1
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: athrow         
        //   413: new             Ljava/lang/String;
        //   416: dup            
        //   417: aload_2        
        //   418: iconst_0       
        //   419: iconst_0       
        //   420: iload           8
        //   422: iconst_2       
        //   423: isub           
        //   424: ldc             9
        //   426: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   429: invokespecial   java/lang/String.<init>:([BIII)V
        //   432: astore_3       
        //   433: ldc             1
        //   435: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   438: aload_1        
        //   439: ldc             2
        //   441: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   444: invokevirtual   java/util/jar/Manifest$FastInputStream.peek:()B
        //   447: bipush          32
        //   449: ldc             2
        //   451: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   454: if_icmpne       498
        //   457: iload           6
        //   459: iload           8
        //   461: isub           
        //   462: newarray        B
        //   464: astore          5
        //   466: ldc             4
        //   468: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   471: aload_2        
        //   472: iload           8
        //   474: aload           5
        //   476: iconst_0       
        //   477: iload           6
        //   479: iload           8
        //   481: isub           
        //   482: ldc             8
        //   484: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   487: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   490: ldc             1
        //   492: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   495: goto            18
        //   498: new             Ljava/lang/String;
        //   501: dup            
        //   502: aload_2        
        //   503: iload           8
        //   505: iload           6
        //   507: iload           8
        //   509: isub           
        //   510: ldc             "UTF8"
        //   512: ldc             9
        //   514: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   517: invokespecial   java/lang/String.<init>:([BIILjava/lang/String;)V
        //   520: astore          4
        //   522: ldc             1
        //   524: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   527: aload_0        
        //   528: aload_3        
        //   529: aload           4
        //   531: ldc             4
        //   533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   536: invokevirtual   java/util/jar/Attributes.putValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   539: ldc             1
        //   541: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   544: ifnull          689
        //   547: iload           7
        //   549: ldc             2
        //   551: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   554: ifne            689
        //   557: ldc             "java.util.jar"
        //   559: ldc             2
        //   561: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   564: invokestatic    sun/util/logging/PlatformLogger.getLogger:(Ljava/lang/String;)Lsun/util/logging/PlatformLogger;
        //   567: new             Ljava/lang/StringBuilder;
        //   570: dup            
        //   571: ldc             3
        //   573: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   576: invokespecial   java/lang/StringBuilder.<init>:()V
        //   579: ldc             "Duplicate name in Manifest: "
        //   581: ldc             2
        //   583: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   586: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   589: aload_3        
        //   590: ldc             2
        //   592: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   595: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   598: ldc             ".\n"
        //   600: ldc             2
        //   602: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   605: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   608: ldc             "Ensure that the manifest does not "
        //   610: ldc             2
        //   612: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   615: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   618: ldc_w           "have duplicate entries, and\n"
        //   621: ldc             2
        //   623: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   626: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   629: ldc_w           "that blank lines separate "
        //   632: ldc             2
        //   634: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   637: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   640: ldc_w           "individual sections in both your\n"
        //   643: ldc             2
        //   645: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   648: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   651: ldc_w           "manifest and in the META-INF/MANIFEST.MF "
        //   654: ldc             2
        //   656: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   659: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   662: ldc_w           "entry in the jar file."
        //   665: ldc             2
        //   667: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   670: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   673: ldc             1
        //   675: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   678: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   681: ldc             1
        //   683: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   686: invokevirtual   sun/util/logging/PlatformLogger.warning:(Ljava/lang/String;)V
        //   689: ldc             1
        //   691: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   694: goto            763
        //   697: astore          9
        //   699: ldc_w           501
        //   702: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   705: new             Ljava/io/IOException;
        //   708: dup            
        //   709: new             Ljava/lang/StringBuilder;
        //   712: dup            
        //   713: ldc             5
        //   715: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   718: invokespecial   java/lang/StringBuilder.<init>:()V
        //   721: ldc_w           "invalid header field name: "
        //   724: ldc             2
        //   726: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   729: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   732: aload_3        
        //   733: ldc             2
        //   735: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   738: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   741: ldc             1
        //   743: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   746: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   749: ldc             1
        //   751: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   754: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   757: ldc             1
        //   759: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   762: athrow         
        //   763: ldc             1
        //   765: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   768: goto            18
        //   771: ldc             1
        //   773: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   776: return         
        //   777: athrow         
        //   778: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 11 FE 00 12 07 00 40 07 00 40 07 00 D4 FD 00 42 01 01 21 11 FC 00 31 01 FC 00 60 07 00 D4 FA 00 2A 30 24 FB 00 54 1C FB 00 A1 47 07 00 D2 F9 00 41 07 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 D0
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  527    778    778    779    Ljava/lang/VirtualMachineError;
        //  527    689    697    763    Ljava/lang/IllegalArgumentException;
        //  0      777    777    778    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0527:
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
    
    public static class Name
    {
        private final String name;
        private final int hashCode;
        private static final Map<String, Name> KNOWN_NAMES;
        public static final Name MANIFEST_VERSION;
        public static final Name SIGNATURE_VERSION;
        public static final Name CONTENT_TYPE;
        public static final Name CLASS_PATH;
        public static final Name MAIN_CLASS;
        public static final Name SEALED;
        public static final Name EXTENSION_LIST;
        public static final Name EXTENSION_NAME;
        @Deprecated
        public static final Name EXTENSION_INSTALLATION;
        public static final Name IMPLEMENTATION_TITLE;
        public static final Name IMPLEMENTATION_VERSION;
        public static final Name IMPLEMENTATION_VENDOR;
        @Deprecated
        public static final Name IMPLEMENTATION_VENDOR_ID;
        @Deprecated
        public static final Name IMPLEMENTATION_URL;
        public static final Name SPECIFICATION_TITLE;
        public static final Name SPECIFICATION_VERSION;
        public static final Name SPECIFICATION_VENDOR;
        public static final Name MULTI_RELEASE;
        
        static final Name of(final String name) {
            // 
            // This method could not be decompiled.
            // 
            // Could not show original bytecode, likely due to the same error.
            // 
            // The error that occurred was:
            // 
            // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'java/util/jar/Attributes$Name.of:(Ljava/lang/String;)Ljava/util/jar/Attributes$Name;'.
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:66)
            //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
            //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // Caused by: java.lang.NullPointerException
            //     at com.strobel.assembler.metadata.MethodReader.readBodyCore(MethodReader.java:170)
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:62)
            //     ... 19 more
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        public Name(final String name) {
            // 
            // This method could not be decompiled.
            // 
            // Could not show original bytecode, likely due to the same error.
            // 
            // The error that occurred was:
            // 
            // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'java/util/jar/Attributes$Name.<init>:(Ljava/lang/String;)V'.
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:66)
            //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
            //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // Caused by: java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 245
            //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
            //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
            //     at com.strobel.assembler.ir.ConstantPool.getEntry(ConstantPool.java:68)
            //     at com.strobel.assembler.metadata.ClassFileReader$Scope.lookupMethod(ClassFileReader.java:1238)
            //     at com.strobel.assembler.metadata.MethodReader.readBodyCore(MethodReader.java:203)
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:62)
            //     ... 19 more
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        private final int hash(final String name) {
            // 
            // This method could not be decompiled.
            // 
            // Could not show original bytecode, likely due to the same error.
            // 
            // The error that occurred was:
            // 
            // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'java/util/jar/Attributes$Name.hash:(Ljava/lang/String;)I'.
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:66)
            //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
            //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // Caused by: java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 245
            //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
            //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
            //     at com.strobel.assembler.ir.ConstantPool.getEntry(ConstantPool.java:68)
            //     at com.strobel.assembler.metadata.ClassFileReader$Scope.lookupField(ClassFileReader.java:1232)
            //     at com.strobel.assembler.metadata.MethodReader.readBodyCore(MethodReader.java:214)
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:62)
            //     ... 19 more
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public boolean equals(final Object o) {
            // 
            // This method could not be decompiled.
            // 
            // Could not show original bytecode, likely due to the same error.
            // 
            // The error that occurred was:
            // 
            // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'java/util/jar/Attributes$Name.equals:(Ljava/lang/Object;)Z'.
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:66)
            //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
            //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // Caused by: java.lang.ClassCastException: class com.strobel.assembler.ir.ConstantPool$NameAndTypeDescriptorEntry cannot be cast to class com.strobel.assembler.ir.ConstantPool$ConstantEntry (com.strobel.assembler.ir.ConstantPool$NameAndTypeDescriptorEntry and com.strobel.assembler.ir.ConstantPool$ConstantEntry are in unnamed module of loader 'app')
            //     at com.strobel.assembler.ir.ConstantPool.lookupConstant(ConstantPool.java:120)
            //     at com.strobel.assembler.metadata.ClassFileReader$Scope.lookupConstant(ClassFileReader.java:1319)
            //     at com.strobel.assembler.metadata.MethodReader.readBodyCore(MethodReader.java:286)
            //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:62)
            //     ... 19 more
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public int hashCode() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: iconst_m1      
            //     2: i2f            
            //     3: aconst_null    
            //     4: caload         
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 1
            //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
            //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
            //     at com.strobel.assembler.ir.StackMappingVisitor.getStackValue(StackMappingVisitor.java:68)
            //     at com.strobel.decompiler.ast.AstBuilder.createModifiedStack(AstBuilder.java:2578)
            //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2032)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        @Override
        public String toString() {
            // 
            // This method could not be decompiled.
            // 
            // Could not show original bytecode, likely due to the same error.
            // 
            // The error that occurred was:
            // 
            // java.lang.ArrayIndexOutOfBoundsException: arraycopy: last source index 3997 out of bounds for byte[3990]
            //     at java.base/java.lang.System.arraycopy(Native Method)
            //     at com.strobel.assembler.ir.attributes.CodeAttribute.<init>(CodeAttribute.java:60)
            //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:700)
            //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        private static void addName(final Map<String, Name> names, final Name name) {
            // 
            // This method could not be decompiled.
            // 
            // Could not show original bytecode, likely due to the same error.
            // 
            // The error that occurred was:
            // 
            // java.lang.ArrayIndexOutOfBoundsException: arraycopy: last source index 4066 out of bounds for byte[3990]
            //     at java.base/java.lang.System.arraycopy(Native Method)
            //     at com.strobel.assembler.ir.attributes.CodeAttribute.<init>(CodeAttribute.java:60)
            //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:700)
            //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        static {
            // 
            // This method could not be decompiled.
            // 
            // Could not show original bytecode, likely due to the same error.
            // 
            // The error that occurred was:
            // 
            // java.lang.ArrayIndexOutOfBoundsException: arraycopy: last source index 4784 out of bounds for byte[3990]
            //     at java.base/java.lang.System.arraycopy(Native Method)
            //     at com.strobel.assembler.ir.attributes.CodeAttribute.<init>(CodeAttribute.java:60)
            //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:700)
            //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    }
}
