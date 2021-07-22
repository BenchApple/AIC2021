// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.regex;

import instrumented.java.util.Spliterator;
import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.Spliterators;
import instrumented.java.util.NoSuchElementException;
import java.util.Iterator;
import instrumented.java.util.stream.Stream;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.Locale;
import java.io.PrintStream;
import instrumented.java.util.HashMap;
import instrumented.java.util.Arrays;
import java.text.Normalizer;
import java.io.IOException;
import java.io.ObjectInputStream;
import instrumented.java.util.List;
import instrumented.java.util.ArrayList;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Map;
import java.io.Serializable;

public final class Pattern implements Serializable
{
    public static final int UNIX_LINES = 1;
    public static final int CASE_INSENSITIVE = 2;
    public static final int COMMENTS = 4;
    public static final int MULTILINE = 8;
    public static final int LITERAL = 16;
    public static final int DOTALL = 32;
    public static final int UNICODE_CASE = 64;
    public static final int CANON_EQ = 128;
    public static final int UNICODE_CHARACTER_CLASS = 256;
    private static final long serialVersionUID = 5073258162644648461L;
    private String pattern;
    private int flags;
    private transient volatile boolean compiled;
    private transient String normalizedPattern;
    transient Node root;
    transient Node matchRoot;
    transient int[] buffer;
    transient volatile Map<String, Integer> namedGroups;
    transient GroupHead[] groupNodes;
    private transient int[] temp;
    transient int capturingGroupCount;
    transient int localCount;
    private transient int cursor;
    private transient int patternLength;
    private transient boolean hasSupplementary;
    static final int MAX_REPS = Integer.MAX_VALUE;
    static final int GREEDY = 0;
    static final int LAZY = 1;
    static final int POSSESSIVE = 2;
    static final int INDEPENDENT = 3;
    static Node lookbehindEnd;
    static Node accept;
    static Node lastAccept;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public static Pattern compile(final String s) {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            final Pattern pattern = new Pattern(s, n);
            BytecodeManager.incBytecodes(1);
            return pattern;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Pattern compile(final String s, final int n) {
        try {
            BytecodeManager.incBytecodes(5);
            final Pattern pattern = new Pattern(s, n);
            BytecodeManager.incBytecodes(1);
            return pattern;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String pattern() {
        try {
            final String pattern = this.pattern;
            BytecodeManager.incBytecodes(3);
            return pattern;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final String pattern = this.pattern;
            BytecodeManager.incBytecodes(3);
            return pattern;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher matcher(final CharSequence p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/regex/Pattern.compiled:Z
        //     4: ldc_w           3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: ifne            75
        //    13: aload_0        
        //    14: dup            
        //    15: astore_2       
        //    16: pop            
        //    17: ldc             4
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: aload_0        
        //    23: getfield        instrumented/java/util/regex/Pattern.compiled:Z
        //    26: ldc_w           3
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: ifne            44
        //    35: aload_0        
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: invokespecial   instrumented/java/util/regex/Pattern.compile:()V
        //    44: aload_2        
        //    45: pop            
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ldc             1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: goto            75
        //    59: astore_3       
        //    60: aload_2        
        //    61: pop            
        //    62: ldc_w           503
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: aload_3        
        //    69: ldc             2
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: athrow         
        //    75: new             Linstrumented/java/util/regex/Matcher;
        //    78: dup            
        //    79: aload_0        
        //    80: aload_1        
        //    81: ldc_w           5
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokespecial   instrumented/java/util/regex/Matcher.<init>:(Linstrumented/java/util/regex/Pattern;Ljava/lang/CharSequence;)V
        //    90: astore_2       
        //    91: ldc             1
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: aload_2        
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: areturn        
        //   103: athrow         
        //   104: athrow         
        //    StackMapTable: 00 05 FC 00 2C 07 00 04 4E 07 01 2C FA 00 0F FF 00 1B 00 00 00 01 07 01 2C FF 00 00 00 00 00 01 07 01 35
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  22     104    104    105    Ljava/lang/VirtualMachineError;
        //  22     51     59     75     Any
        //  59     68     59     75     Any
        //  0      103    103    104    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    
    public int flags() {
        try {
            final int flags = this.flags;
            BytecodeManager.incBytecodes(3);
            return flags;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean matches(final String s, final CharSequence charSequence) {
        try {
            BytecodeManager.incBytecodes(2);
            final Pattern compile = compile(s);
            BytecodeManager.incBytecodes(1);
            final Pattern pattern = compile;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = pattern.matcher(charSequence);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher2 = matcher;
            BytecodeManager.incBytecodes(2);
            final boolean matches = matcher2.matches();
            BytecodeManager.incBytecodes(1);
            return matches;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String[] split(final CharSequence charSequence, final int n) {
        try {
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n3;
            if (n > 0) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final ArrayList<String> list = new ArrayList<String>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = this.matcher(charSequence);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Matcher matcher2 = matcher;
                BytecodeManager.incBytecodes(2);
                final boolean find = matcher2.find();
                BytecodeManager.incBytecodes(1);
                if (!find) {
                    break;
                }
                final int n5 = n4;
                BytecodeManager.incBytecodes(2);
                if (n5 != 0) {
                    final ArrayList<String> list2 = list;
                    BytecodeManager.incBytecodes(2);
                    final int size = list2.size();
                    final int n6 = n - 1;
                    BytecodeManager.incBytecodes(4);
                    if (size >= n6) {
                        final ArrayList<String> list3 = list;
                        BytecodeManager.incBytecodes(2);
                        final int size2 = list3.size();
                        final int n7 = n - 1;
                        BytecodeManager.incBytecodes(4);
                        if (size2 == n7) {
                            final int n8 = n2;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final int length = charSequence.length();
                            BytecodeManager.incBytecodes(1);
                            final CharSequence subSequence = charSequence.subSequence(n8, length);
                            BytecodeManager.incBytecodes(1);
                            final String string = subSequence.toString();
                            BytecodeManager.incBytecodes(1);
                            final ArrayList<String> list4 = list;
                            final String s = string;
                            BytecodeManager.incBytecodes(3);
                            list4.add(s);
                            BytecodeManager.incBytecodes(1);
                            final Matcher matcher3 = matcher;
                            BytecodeManager.incBytecodes(2);
                            n2 = matcher3.end();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        continue;
                    }
                }
                final int n9 = n2;
                BytecodeManager.incBytecodes(2);
                if (n9 == 0) {
                    final int n10 = n2;
                    final Matcher matcher4 = matcher;
                    BytecodeManager.incBytecodes(3);
                    final int start = matcher4.start();
                    BytecodeManager.incBytecodes(1);
                    if (n10 == start) {
                        final Matcher matcher5 = matcher;
                        BytecodeManager.incBytecodes(2);
                        final int start2 = matcher5.start();
                        final Matcher matcher6 = matcher;
                        BytecodeManager.incBytecodes(2);
                        final int end = matcher6.end();
                        BytecodeManager.incBytecodes(1);
                        if (start2 == end) {
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                    }
                }
                final int n11 = n2;
                final Matcher matcher7 = matcher;
                BytecodeManager.incBytecodes(4);
                final int start3 = matcher7.start();
                BytecodeManager.incBytecodes(1);
                final CharSequence subSequence2 = charSequence.subSequence(n11, start3);
                BytecodeManager.incBytecodes(1);
                final String string2 = subSequence2.toString();
                BytecodeManager.incBytecodes(1);
                final ArrayList<String> list5 = list;
                final String s2 = string2;
                BytecodeManager.incBytecodes(3);
                list5.add(s2);
                BytecodeManager.incBytecodes(1);
                final Matcher matcher8 = matcher;
                BytecodeManager.incBytecodes(2);
                n2 = matcher8.end();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            final int n12 = n2;
            BytecodeManager.incBytecodes(2);
            if (n12 == 0) {
                final String[] array = { null };
                final int n13 = 0;
                BytecodeManager.incBytecodes(5);
                array[n13] = charSequence.toString();
                BytecodeManager.incBytecodes(2);
                return array;
            }
            final int n14 = n4;
            BytecodeManager.incBytecodes(2);
            Label_0495: {
                if (n14 != 0) {
                    final ArrayList<String> list6 = list;
                    BytecodeManager.incBytecodes(2);
                    final int size3 = list6.size();
                    BytecodeManager.incBytecodes(2);
                    if (size3 >= n) {
                        break Label_0495;
                    }
                }
                final ArrayList<String> list7 = list;
                final int n15 = n2;
                BytecodeManager.incBytecodes(5);
                final int length2 = charSequence.length();
                BytecodeManager.incBytecodes(1);
                final CharSequence subSequence3 = charSequence.subSequence(n15, length2);
                BytecodeManager.incBytecodes(1);
                final String string3 = subSequence3.toString();
                BytecodeManager.incBytecodes(1);
                list7.add(string3);
                BytecodeManager.incBytecodes(1);
            }
            final ArrayList<String> list8 = list;
            BytecodeManager.incBytecodes(2);
            int size4 = list8.size();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                while (true) {
                    final int n16 = size4;
                    BytecodeManager.incBytecodes(2);
                    if (n16 <= 0) {
                        break;
                    }
                    final ArrayList<String> list9 = list;
                    final int n17 = size4 - 1;
                    BytecodeManager.incBytecodes(5);
                    final String s3 = list9.get(n17);
                    final String anObject = "";
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = s3.equals(anObject);
                    BytecodeManager.incBytecodes(1);
                    if (!equals) {
                        break;
                    }
                    --size4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final String[] array2 = new String[size4];
            BytecodeManager.incBytecodes(2);
            final ArrayList<String> list10 = list;
            final int n18 = 0;
            final int n19 = size4;
            BytecodeManager.incBytecodes(4);
            final List<String> subList = list10.subList(n18, n19);
            final String[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            final String[] array4 = subList.toArray(array3);
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String[] split(final CharSequence charSequence) {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(4);
            final String[] split = this.split(charSequence, n);
            BytecodeManager.incBytecodes(1);
            return split;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String quote(final String str) {
        try {
            final String str2 = "\\E";
            BytecodeManager.incBytecodes(3);
            final int index = str.indexOf(str2);
            BytecodeManager.incBytecodes(1);
            final int n = index;
            final int n2 = -1;
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str3 = "\\Q";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str3);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final String str4 = "\\E";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            BytecodeManager.incBytecodes(4);
            final int capacity = str.length() * 2;
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb2 = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb3 = sb2;
            final String str5 = "\\Q";
            BytecodeManager.incBytecodes(3);
            sb3.append(str5);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final String str6 = "\\E";
                final int fromIndex = n3;
                BytecodeManager.incBytecodes(4);
                final int index2;
                final int n4 = index2 = str.indexOf(str6, fromIndex);
                final int n5 = -1;
                BytecodeManager.incBytecodes(4);
                if (n4 == n5) {
                    break;
                }
                final StringBuilder sb4 = sb2;
                final int beginIndex = n3;
                final int endIndex = index2;
                BytecodeManager.incBytecodes(5);
                final String substring = str.substring(beginIndex, endIndex);
                BytecodeManager.incBytecodes(1);
                sb4.append(substring);
                BytecodeManager.incBytecodes(1);
                n3 = index2 + 2;
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb5 = sb2;
                final String str7 = "\\E\\\\E\\Q";
                BytecodeManager.incBytecodes(3);
                sb5.append(str7);
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb6 = sb2;
            final int beginIndex2 = n3;
            BytecodeManager.incBytecodes(5);
            final int length = str.length();
            BytecodeManager.incBytecodes(1);
            final String substring2 = str.substring(beginIndex2, length);
            BytecodeManager.incBytecodes(1);
            sb6.append(substring2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb7 = sb2;
            final String str8 = "\\E";
            BytecodeManager.incBytecodes(3);
            sb7.append(str8);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb8 = sb2;
            BytecodeManager.incBytecodes(2);
            final String string2 = sb8.toString();
            BytecodeManager.incBytecodes(1);
            return string2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            this.capturingGroupCount = 1;
            BytecodeManager.incBytecodes(3);
            this.localCount = 0;
            BytecodeManager.incBytecodes(3);
            this.compiled = false;
            BytecodeManager.incBytecodes(3);
            final String pattern = this.pattern;
            BytecodeManager.incBytecodes(3);
            final int length = pattern.length();
            BytecodeManager.incBytecodes(1);
            if (length == 0) {
                final Node lastAccept = Pattern.lastAccept;
                BytecodeManager.incBytecodes(5);
                this.root = new Start(lastAccept);
                BytecodeManager.incBytecodes(1);
                this.matchRoot = Pattern.lastAccept;
                BytecodeManager.incBytecodes(3);
                this.compiled = true;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Pattern(final String pattern, final int flags) {
        try {
            BytecodeManager.incBytecodes(2);
            this.compiled = false;
            BytecodeManager.incBytecodes(3);
            this.pattern = pattern;
            BytecodeManager.incBytecodes(3);
            this.flags = flags;
            BytecodeManager.incBytecodes(3);
            final int n = this.flags & 0x100;
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                this.flags |= 0x40;
                BytecodeManager.incBytecodes(6);
            }
            this.capturingGroupCount = 1;
            BytecodeManager.incBytecodes(3);
            this.localCount = 0;
            BytecodeManager.incBytecodes(3);
            final String pattern2 = this.pattern;
            BytecodeManager.incBytecodes(3);
            final int length = pattern2.length();
            BytecodeManager.incBytecodes(1);
            if (length > 0) {
                BytecodeManager.incBytecodes(2);
                this.compile();
                BytecodeManager.incBytecodes(1);
            }
            else {
                final Node lastAccept = Pattern.lastAccept;
                BytecodeManager.incBytecodes(5);
                this.root = new Start(lastAccept);
                BytecodeManager.incBytecodes(1);
                this.matchRoot = Pattern.lastAccept;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void normalize() {
        try {
            BytecodeManager.incBytecodes(2);
            int n = -1;
            BytecodeManager.incBytecodes(2);
            final String pattern = this.pattern;
            final Normalizer.Form nfd = Normalizer.Form.NFD;
            BytecodeManager.incBytecodes(5);
            this.normalizedPattern = Normalizer.normalize(pattern, nfd);
            BytecodeManager.incBytecodes(1);
            final String normalizedPattern = this.normalizedPattern;
            BytecodeManager.incBytecodes(4);
            this.patternLength = normalizedPattern.length();
            BytecodeManager.incBytecodes(1);
            final int patternLength = this.patternLength;
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder(patternLength);
            BytecodeManager.incBytecodes(1);
            int normalizeCharClass = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = normalizeCharClass;
                final int patternLength2 = this.patternLength;
                BytecodeManager.incBytecodes(4);
                if (n2 >= patternLength2) {
                    break;
                }
                final String normalizedPattern2 = this.normalizedPattern;
                final int index = normalizeCharClass;
                BytecodeManager.incBytecodes(4);
                int n3 = normalizedPattern2.codePointAt(index);
                BytecodeManager.incBytecodes(1);
                final int codePoint = n3;
                BytecodeManager.incBytecodes(2);
                final int type = Character.getType(codePoint);
                final int n4 = 6;
                BytecodeManager.incBytecodes(2);
                Label_0493: {
                    if (type == n4) {
                        final int n5 = n;
                        final int n6 = -1;
                        BytecodeManager.incBytecodes(3);
                        if (n5 != n6) {
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder sb2 = new StringBuilder();
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb3 = sb2;
                            final int codePoint2 = n;
                            BytecodeManager.incBytecodes(3);
                            sb3.appendCodePoint(codePoint2);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb4 = sb2;
                            final int codePoint3 = n3;
                            BytecodeManager.incBytecodes(3);
                            sb4.appendCodePoint(codePoint3);
                            BytecodeManager.incBytecodes(1);
                            while (true) {
                                final int codePoint4 = n3;
                                BytecodeManager.incBytecodes(2);
                                final int type2 = Character.getType(codePoint4);
                                final int n7 = 6;
                                BytecodeManager.incBytecodes(2);
                                if (type2 != n7) {
                                    break;
                                }
                                final int n8 = normalizeCharClass;
                                final int codePoint5 = n3;
                                BytecodeManager.incBytecodes(3);
                                normalizeCharClass = n8 + Character.charCount(codePoint5);
                                BytecodeManager.incBytecodes(2);
                                final int n9 = normalizeCharClass;
                                final int patternLength3 = this.patternLength;
                                BytecodeManager.incBytecodes(4);
                                if (n9 >= patternLength3) {
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                final String normalizedPattern3 = this.normalizedPattern;
                                final int index2 = normalizeCharClass;
                                BytecodeManager.incBytecodes(4);
                                n3 = normalizedPattern3.codePointAt(index2);
                                BytecodeManager.incBytecodes(1);
                                final StringBuilder sb5 = sb2;
                                final int codePoint6 = n3;
                                BytecodeManager.incBytecodes(3);
                                sb5.appendCodePoint(codePoint6);
                                BytecodeManager.incBytecodes(2);
                            }
                            final StringBuilder sb6 = sb2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final String string = sb6.toString();
                            BytecodeManager.incBytecodes(1);
                            final String produceEquivalentAlternation = this.produceEquivalentAlternation(string);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb7 = sb;
                            final StringBuilder sb8 = sb;
                            BytecodeManager.incBytecodes(3);
                            final int length = sb8.length();
                            final int codePoint7 = n;
                            BytecodeManager.incBytecodes(2);
                            final int length2 = length - Character.charCount(codePoint7);
                            BytecodeManager.incBytecodes(2);
                            sb7.setLength(length2);
                            final StringBuilder sb9 = sb;
                            final String str = "(?:";
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append = sb9.append(str);
                            final String str2 = produceEquivalentAlternation;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append2 = append.append(str2);
                            final String str3 = ")";
                            BytecodeManager.incBytecodes(2);
                            append2.append(str3);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_0493;
                        }
                    }
                    final int n10 = n3;
                    final int n11 = 91;
                    BytecodeManager.incBytecodes(3);
                    if (n10 == n11) {
                        final int n12 = n;
                        final int n13 = 92;
                        BytecodeManager.incBytecodes(3);
                        if (n12 != n13) {
                            final StringBuilder sb10 = sb;
                            final int n14 = normalizeCharClass;
                            BytecodeManager.incBytecodes(4);
                            normalizeCharClass = this.normalizeCharClass(sb10, n14);
                            BytecodeManager.incBytecodes(2);
                            break Label_0493;
                        }
                    }
                    final StringBuilder sb11 = sb;
                    final int codePoint8 = n3;
                    BytecodeManager.incBytecodes(3);
                    sb11.appendCodePoint(codePoint8);
                    BytecodeManager.incBytecodes(1);
                }
                n = n3;
                BytecodeManager.incBytecodes(2);
                final int n15 = normalizeCharClass;
                final int codePoint9 = n3;
                BytecodeManager.incBytecodes(3);
                normalizeCharClass = n15 + Character.charCount(codePoint9);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder sb12 = sb;
            BytecodeManager.incBytecodes(3);
            this.normalizedPattern = sb12.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int normalizeCharClass(final StringBuilder sb, int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb2 = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            StringBuilder sb3 = null;
            BytecodeManager.incBytecodes(2);
            int n2 = -1;
            BytecodeManager.incBytecodes(2);
            ++n;
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb4 = sb2;
            final String str = "[";
            BytecodeManager.incBytecodes(3);
            sb4.append(str);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final String normalizedPattern = this.normalizedPattern;
                final int index = n;
                BytecodeManager.incBytecodes(4);
                int n3 = normalizedPattern.codePointAt(index);
                BytecodeManager.incBytecodes(1);
                final int n4 = n3;
                final int n5 = 93;
                BytecodeManager.incBytecodes(3);
                if (n4 == n5) {
                    final int n6 = n2;
                    final int n7 = 92;
                    BytecodeManager.incBytecodes(3);
                    if (n6 != n7) {
                        final StringBuilder sb5 = sb2;
                        final char c = (char)n3;
                        BytecodeManager.incBytecodes(4);
                        sb5.append(c);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb6 = sb3;
                        BytecodeManager.incBytecodes(2);
                        String s;
                        if (sb6 != null) {
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder sb7 = new StringBuilder();
                            final String str2 = "(?:";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb7.append(str2);
                            final StringBuilder sb8 = sb2;
                            BytecodeManager.incBytecodes(2);
                            final String string = sb8.toString();
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append2 = append.append(string);
                            final StringBuilder sb9 = sb3;
                            BytecodeManager.incBytecodes(2);
                            final String string2 = sb9.toString();
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append3 = append2.append(string2);
                            final String str3 = ")";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append4 = append3.append(str3);
                            BytecodeManager.incBytecodes(1);
                            s = append4.toString();
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final StringBuilder sb10 = sb2;
                            BytecodeManager.incBytecodes(2);
                            s = sb10.toString();
                            BytecodeManager.incBytecodes(1);
                        }
                        final String str4 = s;
                        BytecodeManager.incBytecodes(3);
                        sb.append(str4);
                        BytecodeManager.incBytecodes(1);
                        final int n8 = n;
                        BytecodeManager.incBytecodes(2);
                        return n8;
                    }
                }
                final int codePoint = n3;
                BytecodeManager.incBytecodes(2);
                final int type = Character.getType(codePoint);
                final int n9 = 6;
                BytecodeManager.incBytecodes(2);
                if (type == n9) {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb11 = new StringBuilder();
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb12 = sb11;
                    final int codePoint2 = n2;
                    BytecodeManager.incBytecodes(3);
                    sb12.appendCodePoint(codePoint2);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final int codePoint3 = n3;
                        BytecodeManager.incBytecodes(2);
                        final int type2 = Character.getType(codePoint3);
                        final int n10 = 6;
                        BytecodeManager.incBytecodes(2);
                        if (type2 != n10) {
                            break;
                        }
                        final StringBuilder sb13 = sb11;
                        final int codePoint4 = n3;
                        BytecodeManager.incBytecodes(3);
                        sb13.appendCodePoint(codePoint4);
                        BytecodeManager.incBytecodes(1);
                        final int n11 = n;
                        final int codePoint5 = n3;
                        BytecodeManager.incBytecodes(3);
                        n = n11 + Character.charCount(codePoint5);
                        BytecodeManager.incBytecodes(2);
                        final int n12 = n;
                        final String normalizedPattern2 = this.normalizedPattern;
                        BytecodeManager.incBytecodes(4);
                        final int length = normalizedPattern2.length();
                        BytecodeManager.incBytecodes(1);
                        if (n12 >= length) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final String normalizedPattern3 = this.normalizedPattern;
                        final int index2 = n;
                        BytecodeManager.incBytecodes(4);
                        n3 = normalizedPattern3.codePointAt(index2);
                        BytecodeManager.incBytecodes(2);
                    }
                    final StringBuilder sb14 = sb11;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final String string3 = sb14.toString();
                    BytecodeManager.incBytecodes(1);
                    final String produceEquivalentAlternation = this.produceEquivalentAlternation(string3);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb15 = sb2;
                    final StringBuilder sb16 = sb2;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = sb16.length();
                    final int codePoint6 = n2;
                    BytecodeManager.incBytecodes(2);
                    final int length3 = length2 - Character.charCount(codePoint6);
                    BytecodeManager.incBytecodes(2);
                    sb15.setLength(length3);
                    final StringBuilder sb17 = sb3;
                    BytecodeManager.incBytecodes(2);
                    if (sb17 == null) {
                        BytecodeManager.incBytecodes(3);
                        sb3 = new StringBuilder();
                        BytecodeManager.incBytecodes(1);
                    }
                    final StringBuilder sb18 = sb3;
                    final char c2 = '|';
                    BytecodeManager.incBytecodes(3);
                    sb18.append(c2);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb19 = sb3;
                    final String str5 = produceEquivalentAlternation;
                    BytecodeManager.incBytecodes(3);
                    sb19.append(str5);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final StringBuilder sb20 = sb2;
                    final int codePoint7 = n3;
                    BytecodeManager.incBytecodes(3);
                    sb20.appendCodePoint(codePoint7);
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(1);
                }
                final int n13 = n;
                final String normalizedPattern4 = this.normalizedPattern;
                BytecodeManager.incBytecodes(4);
                final int length4 = normalizedPattern4.length();
                BytecodeManager.incBytecodes(1);
                if (n13 == length4) {
                    final String s2 = "Unclosed character class";
                    BytecodeManager.incBytecodes(3);
                    final PatternSyntaxException error = this.error(s2);
                    BytecodeManager.incBytecodes(1);
                    throw error;
                }
                n2 = n3;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String produceEquivalentAlternation(final String str) {
        try {
            final int n = 0;
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final int countChars = countChars(str, n, n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int length = str.length();
            final int n3 = countChars;
            BytecodeManager.incBytecodes(2);
            if (length == n3) {
                BytecodeManager.incBytecodes(2);
                return str;
            }
            final int beginIndex = 0;
            final int endIndex = countChars;
            BytecodeManager.incBytecodes(4);
            final String substring = str.substring(beginIndex, endIndex);
            BytecodeManager.incBytecodes(1);
            final int beginIndex2 = countChars;
            BytecodeManager.incBytecodes(3);
            final String substring2 = str.substring(beginIndex2);
            BytecodeManager.incBytecodes(1);
            final String s = substring2;
            BytecodeManager.incBytecodes(3);
            final String[] producePermutations = this.producePermutations(s);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder(str);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n4;
                final int length2 = producePermutations.length;
                BytecodeManager.incBytecodes(4);
                if (n5 >= length2) {
                    break;
                }
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = substring;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb2.append(str2);
                final String str3 = producePermutations[n4];
                BytecodeManager.incBytecodes(4);
                final StringBuilder append2 = append.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final int n6 = n4;
                BytecodeManager.incBytecodes(2);
                if (n6 > 0) {
                    final StringBuilder sb3 = sb;
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder sb4 = new StringBuilder();
                    final String str4 = "|";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = sb4.append(str4);
                    final String str5 = string;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = append3.append(str5);
                    BytecodeManager.incBytecodes(1);
                    final String string2 = append4.toString();
                    BytecodeManager.incBytecodes(1);
                    sb3.append(string2);
                    BytecodeManager.incBytecodes(1);
                }
                final String s2 = string;
                BytecodeManager.incBytecodes(3);
                final String composeOneStep = this.composeOneStep(s2);
                BytecodeManager.incBytecodes(1);
                final String s3 = composeOneStep;
                BytecodeManager.incBytecodes(2);
                if (s3 != null) {
                    final StringBuilder sb5 = sb;
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder sb6 = new StringBuilder();
                    final String str6 = "|";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = sb6.append(str6);
                    final String s4 = composeOneStep;
                    BytecodeManager.incBytecodes(3);
                    final String produceEquivalentAlternation = this.produceEquivalentAlternation(s4);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append6 = append5.append(produceEquivalentAlternation);
                    BytecodeManager.incBytecodes(1);
                    final String string3 = append6.toString();
                    BytecodeManager.incBytecodes(1);
                    sb5.append(string3);
                    BytecodeManager.incBytecodes(1);
                }
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb7 = sb;
            BytecodeManager.incBytecodes(2);
            final String string4 = sb7.toString();
            BytecodeManager.incBytecodes(1);
            return string4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String[] producePermutations(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            final int n = 0;
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final int countChars = countChars(s, n, n2);
            BytecodeManager.incBytecodes(1);
            if (length == countChars) {
                final String[] array = { s };
                BytecodeManager.incBytecodes(6);
                return array;
            }
            BytecodeManager.incBytecodes(2);
            final int length2 = s.length();
            final int n3 = 0;
            final int n4 = 2;
            BytecodeManager.incBytecodes(4);
            final int countChars2 = countChars(s, n3, n4);
            BytecodeManager.incBytecodes(1);
            if (length2 != countChars2) {
                int n5 = 1;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final int countCodePoints = countCodePoints(s);
                BytecodeManager.incBytecodes(1);
                int n6 = 1;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    final int n8 = countCodePoints;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        break;
                    }
                    n5 *= n6 + 1;
                    BytecodeManager.incBytecodes(6);
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
                final String[] array2 = new String[n5];
                BytecodeManager.incBytecodes(2);
                final int[] array3 = new int[countCodePoints];
                BytecodeManager.incBytecodes(2);
                int n9 = 0;
                int n10 = 0;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n11 = n9;
                    final int n12 = countCodePoints;
                    BytecodeManager.incBytecodes(3);
                    if (n11 >= n12) {
                        break;
                    }
                    final int index = n10;
                    BytecodeManager.incBytecodes(3);
                    final int codePoint = Character.codePointAt(s, index);
                    BytecodeManager.incBytecodes(1);
                    final int[] array4 = array3;
                    final int n13 = n9;
                    final int n14 = codePoint;
                    BytecodeManager.incBytecodes(5);
                    array4[n13] = this.getClass(n14);
                    BytecodeManager.incBytecodes(1);
                    final int n15 = n10;
                    final int codePoint2 = codePoint;
                    BytecodeManager.incBytecodes(3);
                    n10 = n15 + Character.charCount(codePoint2);
                    BytecodeManager.incBytecodes(2);
                    ++n9;
                    BytecodeManager.incBytecodes(2);
                }
                int n16 = 0;
                BytecodeManager.incBytecodes(2);
                int n17 = 0;
                int n18 = 0;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n19 = n17;
                    final int n20 = countCodePoints;
                    BytecodeManager.incBytecodes(3);
                    if (n19 >= n20) {
                        break;
                    }
                    final int n21 = n18;
                    final int n22 = 1;
                    BytecodeManager.incBytecodes(4);
                    final int countChars3 = countChars(s, n21, n22);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    int n23 = n17 - 1;
                    BytecodeManager.incBytecodes(4);
                Label_0747:
                    while (true) {
                        final int n24 = n23;
                        BytecodeManager.incBytecodes(2);
                        if (n24 >= 0) {
                            final int n25 = array3[n23];
                            final int n26 = array3[n17];
                            BytecodeManager.incBytecodes(7);
                            if (n25 == n26) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            --n23;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            BytecodeManager.incBytecodes(4);
                            final StringBuilder sb = new StringBuilder(s);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb2 = sb;
                            final int start = n18;
                            final int end = n18 + countChars3;
                            BytecodeManager.incBytecodes(6);
                            final StringBuilder delete = sb2.delete(start, end);
                            BytecodeManager.incBytecodes(1);
                            final String string = delete.toString();
                            BytecodeManager.incBytecodes(1);
                            final String s2 = string;
                            BytecodeManager.incBytecodes(3);
                            final String[] producePermutations = this.producePermutations(s2);
                            BytecodeManager.incBytecodes(1);
                            final int beginIndex = n18;
                            final int endIndex = n18 + countChars3;
                            BytecodeManager.incBytecodes(6);
                            final String substring = s.substring(beginIndex, endIndex);
                            BytecodeManager.incBytecodes(1);
                            int n27 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n28 = n27;
                                final int length3 = producePermutations.length;
                                BytecodeManager.incBytecodes(4);
                                if (n28 >= length3) {
                                    break Label_0747;
                                }
                                final String[] array5 = array2;
                                final int n29 = n16++;
                                BytecodeManager.incBytecodes(6);
                                final StringBuilder sb3 = new StringBuilder();
                                final String str = substring;
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append = sb3.append(str);
                                final String str2 = producePermutations[n27];
                                BytecodeManager.incBytecodes(4);
                                final StringBuilder append2 = append.append(str2);
                                BytecodeManager.incBytecodes(1);
                                array5[n29] = append2.toString();
                                BytecodeManager.incBytecodes(1);
                                ++n27;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                    ++n17;
                    n18 += countChars3;
                    BytecodeManager.incBytecodes(6);
                }
                final String[] array6 = new String[n16];
                BytecodeManager.incBytecodes(2);
                int n30 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n31 = n30;
                    final int n32 = n16;
                    BytecodeManager.incBytecodes(3);
                    if (n31 >= n32) {
                        break;
                    }
                    array6[n30] = array2[n30];
                    BytecodeManager.incBytecodes(6);
                    ++n30;
                    BytecodeManager.incBytecodes(2);
                }
                final String[] array7 = array6;
                BytecodeManager.incBytecodes(2);
                return array7;
            }
            final int index2 = 0;
            BytecodeManager.incBytecodes(3);
            final int codePoint3 = Character.codePointAt(s, index2);
            BytecodeManager.incBytecodes(1);
            final int codePoint4 = codePoint3;
            BytecodeManager.incBytecodes(3);
            final int charCount = Character.charCount(codePoint4);
            BytecodeManager.incBytecodes(1);
            final int codePoint5 = Character.codePointAt(s, charCount);
            BytecodeManager.incBytecodes(1);
            final int n33 = codePoint5;
            BytecodeManager.incBytecodes(3);
            final int class1 = this.getClass(n33);
            final int n34 = codePoint3;
            BytecodeManager.incBytecodes(3);
            final int class2 = this.getClass(n34);
            BytecodeManager.incBytecodes(1);
            if (class1 == class2) {
                final String[] array8 = { s };
                BytecodeManager.incBytecodes(6);
                return array8;
            }
            final String[] array9 = new String[2];
            BytecodeManager.incBytecodes(2);
            array9[0] = s;
            BytecodeManager.incBytecodes(4);
            final int capacity = 2;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb4 = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb5 = sb4;
            final int codePoint6 = codePoint5;
            BytecodeManager.incBytecodes(3);
            sb5.appendCodePoint(codePoint6);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb6 = sb4;
            final int codePoint7 = codePoint3;
            BytecodeManager.incBytecodes(3);
            sb6.appendCodePoint(codePoint7);
            BytecodeManager.incBytecodes(1);
            final String[] array10 = array9;
            final int n35 = 1;
            final StringBuilder sb7 = sb4;
            BytecodeManager.incBytecodes(4);
            array10[n35] = sb7.toString();
            BytecodeManager.incBytecodes(1);
            final String[] array11 = array9;
            BytecodeManager.incBytecodes(2);
            return array11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int getClass(final int ch) {
        try {
            BytecodeManager.incBytecodes(2);
            final int combiningClass = sun.text.Normalizer.getCombiningClass(ch);
            BytecodeManager.incBytecodes(1);
            return combiningClass;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String composeOneStep(final String s) {
        try {
            final int n = 0;
            final int n2 = 2;
            BytecodeManager.incBytecodes(4);
            final int countChars = countChars(s, n, n2);
            BytecodeManager.incBytecodes(1);
            final int beginIndex = 0;
            final int endIndex = countChars;
            BytecodeManager.incBytecodes(4);
            final String substring = s.substring(beginIndex, endIndex);
            BytecodeManager.incBytecodes(1);
            final String src = substring;
            final Normalizer.Form nfc = Normalizer.Form.NFC;
            BytecodeManager.incBytecodes(3);
            final String normalize = Normalizer.normalize(src, nfc);
            BytecodeManager.incBytecodes(1);
            final String s2 = normalize;
            final String anObject = substring;
            BytecodeManager.incBytecodes(3);
            final boolean equals = s2.equals(anObject);
            BytecodeManager.incBytecodes(1);
            if (equals) {
                final String s3 = null;
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            final int beginIndex2 = countChars;
            BytecodeManager.incBytecodes(3);
            final String substring2 = s.substring(beginIndex2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = normalize;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String str2 = substring2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void RemoveQEQuoting() {
        try {
            final int patternLength = this.patternLength;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = patternLength - 1;
                BytecodeManager.incBytecodes(5);
                if (n2 >= n3) {
                    break;
                }
                final int n4 = this.temp[n];
                final int n5 = 92;
                BytecodeManager.incBytecodes(6);
                if (n4 != n5) {
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int n6 = this.temp[n + 1];
                    final int n7 = 81;
                    BytecodeManager.incBytecodes(8);
                    if (n6 == n7) {
                        break;
                    }
                    n += 2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n8 = n;
            final int n9 = patternLength - 1;
            BytecodeManager.incBytecodes(5);
            if (n8 >= n9) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            int patternLength2 = n;
            BytecodeManager.incBytecodes(2);
            n += 2;
            BytecodeManager.incBytecodes(1);
            final int[] array = new int[patternLength2 + 3 * (patternLength - n) + 2];
            BytecodeManager.incBytecodes(10);
            final int[] temp = this.temp;
            final int n10 = 0;
            final int[] array2 = array;
            final int n11 = 0;
            final int n12 = patternLength2;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(temp, n10, array2, n11, n12);
            int n13 = 1;
            BytecodeManager.incBytecodes(2);
            boolean b = true;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n14 = n;
                final int n15 = patternLength;
                BytecodeManager.incBytecodes(3);
                if (n14 >= n15) {
                    break;
                }
                final int n16 = this.temp[n++];
                BytecodeManager.incBytecodes(6);
                final int n17 = n16;
                BytecodeManager.incBytecodes(2);
                final boolean ascii = ASCII.isAscii(n17);
                BytecodeManager.incBytecodes(1);
                Label_0581: {
                    if (ascii) {
                        final int n18 = n16;
                        BytecodeManager.incBytecodes(2);
                        final boolean alpha = ASCII.isAlpha(n18);
                        BytecodeManager.incBytecodes(1);
                        if (!alpha) {
                            final int n19 = n16;
                            BytecodeManager.incBytecodes(2);
                            final boolean digit = ASCII.isDigit(n19);
                            BytecodeManager.incBytecodes(1);
                            if (digit) {
                                final boolean b2 = b;
                                BytecodeManager.incBytecodes(2);
                                if (b2) {
                                    array[patternLength2++] = 92;
                                    BytecodeManager.incBytecodes(5);
                                    array[patternLength2++] = 120;
                                    BytecodeManager.incBytecodes(5);
                                    array[patternLength2++] = 51;
                                    BytecodeManager.incBytecodes(5);
                                }
                                array[patternLength2++] = n16;
                                BytecodeManager.incBytecodes(6);
                                break Label_0581;
                            }
                            final int n20 = n16;
                            final int n21 = 92;
                            BytecodeManager.incBytecodes(3);
                            if (n20 != n21) {
                                final int n22 = n13;
                                BytecodeManager.incBytecodes(2);
                                if (n22 != 0) {
                                    array[patternLength2++] = 92;
                                    BytecodeManager.incBytecodes(5);
                                }
                                array[patternLength2++] = n16;
                                BytecodeManager.incBytecodes(6);
                                break Label_0581;
                            }
                            final int n23 = n13;
                            BytecodeManager.incBytecodes(2);
                            if (n23 != 0) {
                                final int n24 = this.temp[n];
                                final int n25 = 69;
                                BytecodeManager.incBytecodes(6);
                                if (n24 == n25) {
                                    ++n;
                                    BytecodeManager.incBytecodes(1);
                                    n13 = 0;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0581;
                                }
                                array[patternLength2++] = 92;
                                BytecodeManager.incBytecodes(5);
                                array[patternLength2++] = 92;
                                BytecodeManager.incBytecodes(6);
                                break Label_0581;
                            }
                            else {
                                final int n26 = this.temp[n];
                                final int n27 = 81;
                                BytecodeManager.incBytecodes(6);
                                if (n26 == n27) {
                                    ++n;
                                    BytecodeManager.incBytecodes(1);
                                    n13 = 1;
                                    BytecodeManager.incBytecodes(2);
                                    b = true;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    continue;
                                }
                                array[patternLength2++] = n16;
                                BytecodeManager.incBytecodes(5);
                                final int n28 = n;
                                final int n29 = patternLength;
                                BytecodeManager.incBytecodes(3);
                                if (n28 != n29) {
                                    array[patternLength2++] = this.temp[n++];
                                    BytecodeManager.incBytecodes(9);
                                }
                                break Label_0581;
                            }
                        }
                    }
                    array[patternLength2++] = n16;
                    BytecodeManager.incBytecodes(6);
                }
                b = false;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            this.patternLength = patternLength2;
            BytecodeManager.incBytecodes(3);
            final int[] array3 = array;
            final int n30 = patternLength2 + 2;
            BytecodeManager.incBytecodes(6);
            this.temp = Arrays.copyOf(array3, n30);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void compile() {
        try {
            final int n = 128;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n);
            BytecodeManager.incBytecodes(1);
            Label_0071: {
                if (has) {
                    final int n2 = 16;
                    BytecodeManager.incBytecodes(3);
                    final boolean has2 = this.has(n2);
                    BytecodeManager.incBytecodes(1);
                    if (!has2) {
                        BytecodeManager.incBytecodes(2);
                        this.normalize();
                        BytecodeManager.incBytecodes(1);
                        break Label_0071;
                    }
                }
                this.normalizedPattern = this.pattern;
                BytecodeManager.incBytecodes(4);
            }
            final String normalizedPattern = this.normalizedPattern;
            BytecodeManager.incBytecodes(4);
            this.patternLength = normalizedPattern.length();
            BytecodeManager.incBytecodes(1);
            this.temp = new int[this.patternLength + 2];
            BytecodeManager.incBytecodes(6);
            this.hasSupplementary = false;
            BytecodeManager.incBytecodes(3);
            int patternLength = 0;
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int patternLength2 = this.patternLength;
                BytecodeManager.incBytecodes(4);
                if (n4 >= patternLength2) {
                    break;
                }
                final String normalizedPattern2 = this.normalizedPattern;
                final int index = n3;
                BytecodeManager.incBytecodes(4);
                final int codePoint = normalizedPattern2.codePointAt(index);
                BytecodeManager.incBytecodes(1);
                final int n5 = codePoint;
                BytecodeManager.incBytecodes(2);
                final boolean supplementary = isSupplementary(n5);
                BytecodeManager.incBytecodes(1);
                if (supplementary) {
                    this.hasSupplementary = true;
                    BytecodeManager.incBytecodes(3);
                }
                this.temp[patternLength++] = codePoint;
                BytecodeManager.incBytecodes(6);
                final int n6 = n3;
                final int codePoint2 = codePoint;
                BytecodeManager.incBytecodes(3);
                n3 = n6 + Character.charCount(codePoint2);
                BytecodeManager.incBytecodes(3);
            }
            this.patternLength = patternLength;
            BytecodeManager.incBytecodes(3);
            final int n7 = 16;
            BytecodeManager.incBytecodes(3);
            final boolean has3 = this.has(n7);
            BytecodeManager.incBytecodes(1);
            if (!has3) {
                BytecodeManager.incBytecodes(2);
                this.RemoveQEQuoting();
            }
            this.buffer = new int[32];
            BytecodeManager.incBytecodes(3);
            this.groupNodes = new GroupHead[10];
            BytecodeManager.incBytecodes(3);
            this.namedGroups = null;
            BytecodeManager.incBytecodes(3);
            final int n8 = 16;
            BytecodeManager.incBytecodes(3);
            final boolean has4 = this.has(n8);
            BytecodeManager.incBytecodes(1);
            if (has4) {
                final int[] temp = this.temp;
                final int patternLength3 = this.patternLength;
                final boolean hasSupplementary = this.hasSupplementary;
                BytecodeManager.incBytecodes(9);
                this.matchRoot = this.newSlice(temp, patternLength3, hasSupplementary);
                BytecodeManager.incBytecodes(1);
                this.matchRoot.next = Pattern.lastAccept;
                BytecodeManager.incBytecodes(5);
            }
            else {
                final Node lastAccept = Pattern.lastAccept;
                BytecodeManager.incBytecodes(4);
                this.matchRoot = this.expr(lastAccept);
                BytecodeManager.incBytecodes(1);
                final int patternLength4 = this.patternLength;
                final int cursor = this.cursor;
                BytecodeManager.incBytecodes(5);
                if (patternLength4 != cursor) {
                    BytecodeManager.incBytecodes(2);
                    final int peek = this.peek();
                    final int n9 = 41;
                    BytecodeManager.incBytecodes(2);
                    if (peek == n9) {
                        final String s = "Unmatched closing ')'";
                        BytecodeManager.incBytecodes(3);
                        final PatternSyntaxException error = this.error(s);
                        BytecodeManager.incBytecodes(1);
                        throw error;
                    }
                    final String s2 = "Unexpected internal error";
                    BytecodeManager.incBytecodes(3);
                    final PatternSyntaxException error2 = this.error(s2);
                    BytecodeManager.incBytecodes(1);
                    throw error2;
                }
            }
            final boolean b = this.matchRoot instanceof Slice;
            BytecodeManager.incBytecodes(4);
            Label_0707: {
                if (b) {
                    final Node matchRoot = this.matchRoot;
                    BytecodeManager.incBytecodes(4);
                    this.root = BnM.optimize(matchRoot);
                    BytecodeManager.incBytecodes(1);
                    final Node root = this.root;
                    final Node matchRoot2 = this.matchRoot;
                    BytecodeManager.incBytecodes(5);
                    if (root == matchRoot2) {
                        final boolean hasSupplementary2 = this.hasSupplementary;
                        BytecodeManager.incBytecodes(4);
                        Start root2;
                        if (hasSupplementary2) {
                            final Node matchRoot3;
                            root2 = new StartS(matchRoot3);
                            matchRoot3 = this.matchRoot;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final Node matchRoot4;
                            root2 = new Start(matchRoot4);
                            matchRoot4 = this.matchRoot;
                            BytecodeManager.incBytecodes(5);
                        }
                        this.root = root2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    final boolean b2 = this.matchRoot instanceof Begin;
                    BytecodeManager.incBytecodes(4);
                    if (!b2) {
                        final boolean b3 = this.matchRoot instanceof First;
                        BytecodeManager.incBytecodes(4);
                        if (!b3) {
                            final boolean hasSupplementary3 = this.hasSupplementary;
                            BytecodeManager.incBytecodes(4);
                            Start root3;
                            if (hasSupplementary3) {
                                final Node matchRoot5;
                                root3 = new StartS(matchRoot5);
                                matchRoot5 = this.matchRoot;
                                BytecodeManager.incBytecodes(5);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final Node matchRoot6;
                                root3 = new Start(matchRoot6);
                                matchRoot6 = this.matchRoot;
                                BytecodeManager.incBytecodes(5);
                            }
                            this.root = root3;
                            BytecodeManager.incBytecodes(1);
                            break Label_0707;
                        }
                    }
                    this.root = this.matchRoot;
                    BytecodeManager.incBytecodes(5);
                }
            }
            this.temp = null;
            BytecodeManager.incBytecodes(3);
            this.buffer = null;
            BytecodeManager.incBytecodes(3);
            this.groupNodes = null;
            BytecodeManager.incBytecodes(3);
            this.patternLength = 0;
            BytecodeManager.incBytecodes(3);
            this.compiled = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Map<String, Integer> namedGroups() {
        try {
            final Map<String, Integer> namedGroups = this.namedGroups;
            BytecodeManager.incBytecodes(3);
            if (namedGroups == null) {
                final int n = 2;
                BytecodeManager.incBytecodes(5);
                this.namedGroups = new HashMap<String, Integer>(n);
                BytecodeManager.incBytecodes(1);
            }
            final Map<String, Integer> namedGroups2 = this.namedGroups;
            BytecodeManager.incBytecodes(3);
            return namedGroups2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void printObjectTree(Node next) {
        try {
            while (true) {
                final Node node = next;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final boolean b = next instanceof Prolog;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final PrintStream out = System.out;
                    final Node x = next;
                    BytecodeManager.incBytecodes(3);
                    out.println(x);
                    final Loop loop = ((Prolog)next).loop;
                    BytecodeManager.incBytecodes(4);
                    printObjectTree(loop);
                    final PrintStream out2 = System.out;
                    final String x2 = "**** end contents prolog loop";
                    BytecodeManager.incBytecodes(3);
                    out2.println(x2);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean b2 = next instanceof Loop;
                    BytecodeManager.incBytecodes(3);
                    if (b2) {
                        final PrintStream out3 = System.out;
                        final Node x3 = next;
                        BytecodeManager.incBytecodes(3);
                        out3.println(x3);
                        final Node body = ((Loop)next).body;
                        BytecodeManager.incBytecodes(4);
                        printObjectTree(body);
                        final PrintStream out4 = System.out;
                        final String x4 = "**** end contents Loop body";
                        BytecodeManager.incBytecodes(3);
                        out4.println(x4);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final boolean b3 = next instanceof Curly;
                        BytecodeManager.incBytecodes(3);
                        if (b3) {
                            final PrintStream out5 = System.out;
                            final Node x5 = next;
                            BytecodeManager.incBytecodes(3);
                            out5.println(x5);
                            final Node atom = ((Curly)next).atom;
                            BytecodeManager.incBytecodes(4);
                            printObjectTree(atom);
                            final PrintStream out6 = System.out;
                            final String x6 = "**** end contents Curly body";
                            BytecodeManager.incBytecodes(3);
                            out6.println(x6);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final boolean b4 = next instanceof GroupCurly;
                            BytecodeManager.incBytecodes(3);
                            if (b4) {
                                final PrintStream out7 = System.out;
                                final Node x7 = next;
                                BytecodeManager.incBytecodes(3);
                                out7.println(x7);
                                final Node atom2 = ((GroupCurly)next).atom;
                                BytecodeManager.incBytecodes(4);
                                printObjectTree(atom2);
                                final PrintStream out8 = System.out;
                                final String x8 = "**** end contents GroupCurly body";
                                BytecodeManager.incBytecodes(3);
                                out8.println(x8);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final boolean b5 = next instanceof GroupTail;
                                BytecodeManager.incBytecodes(3);
                                if (b5) {
                                    final PrintStream out9 = System.out;
                                    final Node x9 = next;
                                    BytecodeManager.incBytecodes(3);
                                    out9.println(x9);
                                    final PrintStream out10 = System.out;
                                    BytecodeManager.incBytecodes(4);
                                    final StringBuilder sb = new StringBuilder();
                                    final String str = "Tail next is ";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append = sb.append(str);
                                    final Node next2 = next.next;
                                    BytecodeManager.incBytecodes(3);
                                    final StringBuilder append2 = append.append(next2);
                                    BytecodeManager.incBytecodes(1);
                                    final String string = append2.toString();
                                    BytecodeManager.incBytecodes(1);
                                    out10.println(string);
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                final PrintStream out11 = System.out;
                                final Node x10 = next;
                                BytecodeManager.incBytecodes(3);
                                out11.println(x10);
                            }
                        }
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(3);
                final Node node2 = next;
                BytecodeManager.incBytecodes(2);
                if (node2 != null) {
                    final PrintStream out12 = System.out;
                    final String x11 = "->next:";
                    BytecodeManager.incBytecodes(3);
                    out12.println(x11);
                }
                final Node node3 = next;
                final Node accept = Pattern.accept;
                BytecodeManager.incBytecodes(3);
                if (node3 != accept) {
                    continue;
                }
                final PrintStream out13 = System.out;
                final String x12 = "Accept Node";
                BytecodeManager.incBytecodes(3);
                out13.println(x12);
                next = null;
                BytecodeManager.incBytecodes(3);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean has(final int n) {
        try {
            final int n2 = this.flags & n;
            BytecodeManager.incBytecodes(5);
            boolean b;
            if (n2 != 0) {
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
    
    private void accept(final int n, final String s) {
        try {
            int pastWhitespace = this.temp[this.cursor++];
            BytecodeManager.incBytecodes(11);
            final int n2 = 4;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n2);
            BytecodeManager.incBytecodes(1);
            if (has) {
                final int n3 = pastWhitespace;
                BytecodeManager.incBytecodes(3);
                pastWhitespace = this.parsePastWhitespace(n3);
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = pastWhitespace;
            BytecodeManager.incBytecodes(3);
            if (n != n4) {
                BytecodeManager.incBytecodes(3);
                final PatternSyntaxException error = this.error(s);
                BytecodeManager.incBytecodes(1);
                throw error;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void mark(final int n) {
        try {
            this.temp[this.patternLength] = n;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int peek() {
        try {
            int peekPastWhitespace = this.temp[this.cursor];
            BytecodeManager.incBytecodes(6);
            final int n = 4;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n);
            BytecodeManager.incBytecodes(1);
            if (has) {
                final int n2 = peekPastWhitespace;
                BytecodeManager.incBytecodes(3);
                peekPastWhitespace = this.peekPastWhitespace(n2);
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = peekPastWhitespace;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int read() {
        try {
            int pastWhitespace = this.temp[this.cursor++];
            BytecodeManager.incBytecodes(11);
            final int n = 4;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n);
            BytecodeManager.incBytecodes(1);
            if (has) {
                final int n2 = pastWhitespace;
                BytecodeManager.incBytecodes(3);
                pastWhitespace = this.parsePastWhitespace(n2);
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = pastWhitespace;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int readEscaped() {
        try {
            final int n = this.temp[this.cursor++];
            BytecodeManager.incBytecodes(11);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int next() {
        try {
            int peekPastWhitespace = this.temp[++this.cursor];
            BytecodeManager.incBytecodes(11);
            final int n = 4;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n);
            BytecodeManager.incBytecodes(1);
            if (has) {
                final int n2 = peekPastWhitespace;
                BytecodeManager.incBytecodes(3);
                peekPastWhitespace = this.peekPastWhitespace(n2);
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = peekPastWhitespace;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int nextEscaped() {
        try {
            final int n = this.temp[++this.cursor];
            BytecodeManager.incBytecodes(11);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int peekPastWhitespace(int peekPastLine) {
        try {
            while (true) {
                final int n = peekPastLine;
                BytecodeManager.incBytecodes(2);
                final boolean space = ASCII.isSpace(n);
                BytecodeManager.incBytecodes(1);
                if (!space) {
                    final int n2 = peekPastLine;
                    final int n3 = 35;
                    BytecodeManager.incBytecodes(3);
                    if (n2 != n3) {
                        break;
                    }
                }
                while (true) {
                    final int n4 = peekPastLine;
                    BytecodeManager.incBytecodes(2);
                    final boolean space2 = ASCII.isSpace(n4);
                    BytecodeManager.incBytecodes(1);
                    if (!space2) {
                        break;
                    }
                    peekPastLine = this.temp[++this.cursor];
                    BytecodeManager.incBytecodes(12);
                }
                final int n5 = peekPastLine;
                final int n6 = 35;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    BytecodeManager.incBytecodes(2);
                    peekPastLine = this.peekPastLine();
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n7 = peekPastLine;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int parsePastWhitespace(int pastLine) {
        try {
            while (true) {
                final int n = pastLine;
                BytecodeManager.incBytecodes(2);
                final boolean space = ASCII.isSpace(n);
                BytecodeManager.incBytecodes(1);
                if (!space) {
                    final int n2 = pastLine;
                    final int n3 = 35;
                    BytecodeManager.incBytecodes(3);
                    if (n2 != n3) {
                        break;
                    }
                }
                while (true) {
                    final int n4 = pastLine;
                    BytecodeManager.incBytecodes(2);
                    final boolean space2 = ASCII.isSpace(n4);
                    BytecodeManager.incBytecodes(1);
                    if (!space2) {
                        break;
                    }
                    pastLine = this.temp[this.cursor++];
                    BytecodeManager.incBytecodes(12);
                }
                final int n5 = pastLine;
                final int n6 = 35;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    BytecodeManager.incBytecodes(2);
                    pastLine = this.parsePastLine();
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n7 = pastLine;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int parsePastLine() {
        try {
            int n = this.temp[this.cursor++];
            BytecodeManager.incBytecodes(11);
            while (true) {
                final boolean b = n != 0;
                BytecodeManager.incBytecodes(2);
                if (!b) {
                    break;
                }
                final int n2 = n;
                BytecodeManager.incBytecodes(3);
                final boolean lineSeparator = this.isLineSeparator(n2);
                BytecodeManager.incBytecodes(1);
                if (lineSeparator) {
                    break;
                }
                n = this.temp[this.cursor++];
                BytecodeManager.incBytecodes(12);
            }
            final int n3 = n;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int peekPastLine() {
        try {
            int n = this.temp[++this.cursor];
            BytecodeManager.incBytecodes(11);
            while (true) {
                final boolean b = n != 0;
                BytecodeManager.incBytecodes(2);
                if (!b) {
                    break;
                }
                final int n2 = n;
                BytecodeManager.incBytecodes(3);
                final boolean lineSeparator = this.isLineSeparator(n2);
                BytecodeManager.incBytecodes(1);
                if (lineSeparator) {
                    break;
                }
                n = this.temp[++this.cursor];
                BytecodeManager.incBytecodes(12);
            }
            final int n3 = n;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isLineSeparator(final int n) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n2);
            BytecodeManager.incBytecodes(1);
            if (has) {
                final int n3 = 10;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (n == n3) {
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
            final int n4 = 10;
            BytecodeManager.incBytecodes(3);
            boolean b2 = false;
            Label_0119: {
                if (n != n4) {
                    final int n5 = 13;
                    BytecodeManager.incBytecodes(3);
                    if (n != n5) {
                        final int n6 = n | 0x1;
                        final int n7 = 8233;
                        BytecodeManager.incBytecodes(5);
                        if (n6 != n7) {
                            final int n8 = 133;
                            BytecodeManager.incBytecodes(3);
                            if (n != n8) {
                                b2 = false;
                                BytecodeManager.incBytecodes(1);
                                break Label_0119;
                            }
                        }
                    }
                }
                b2 = true;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int skip() {
        try {
            final int cursor = this.cursor;
            BytecodeManager.incBytecodes(3);
            final int n = this.temp[cursor + 1];
            BytecodeManager.incBytecodes(7);
            this.cursor = cursor + 2;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void unread() {
        try {
            --this.cursor;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private PatternSyntaxException error(final String s) {
        try {
            final String normalizedPattern = this.normalizedPattern;
            final int n = this.cursor - 1;
            BytecodeManager.incBytecodes(10);
            final PatternSyntaxException ex = new PatternSyntaxException(s, normalizedPattern, n);
            BytecodeManager.incBytecodes(1);
            return ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean findSupplementary(final int n, final int n2) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n2) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n5 = this.temp[n3];
                BytecodeManager.incBytecodes(5);
                final boolean supplementary = isSupplementary(n5);
                BytecodeManager.incBytecodes(1);
                if (supplementary) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final boolean isSupplementary(final int n) {
        try {
            final int n2 = 65536;
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0051: {
                if (n < n2) {
                    final char ch = (char)n;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean surrogate = Character.isSurrogate(ch);
                    BytecodeManager.incBytecodes(1);
                    if (!surrogate) {
                        b = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0051;
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
    
    private Node expr(final Node next) {
        try {
            Node node = null;
            BytecodeManager.incBytecodes(2);
            Node node2 = null;
            BytecodeManager.incBytecodes(2);
            Branch branch = null;
            BytecodeManager.incBytecodes(2);
            Node node3 = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                BytecodeManager.incBytecodes(3);
                Node sequence = this.sequence(next);
                BytecodeManager.incBytecodes(1);
                final Node root = this.root;
                BytecodeManager.incBytecodes(3);
                final Node node4 = node;
                BytecodeManager.incBytecodes(2);
                if (node4 == null) {
                    node = sequence;
                    BytecodeManager.incBytecodes(2);
                    node2 = root;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Node node5 = node3;
                    BytecodeManager.incBytecodes(2);
                    if (node5 == null) {
                        BytecodeManager.incBytecodes(3);
                        node3 = new BranchConn();
                        BytecodeManager.incBytecodes(1);
                        node3.next = next;
                        BytecodeManager.incBytecodes(3);
                    }
                    final Node node6 = sequence;
                    BytecodeManager.incBytecodes(3);
                    if (node6 == next) {
                        sequence = null;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        root.next = node3;
                        BytecodeManager.incBytecodes(3);
                    }
                    final Node node7 = node;
                    final Branch branch2 = branch;
                    BytecodeManager.incBytecodes(3);
                    if (node7 == branch2) {
                        final Branch branch3 = branch;
                        final Branch branch4 = (Branch)sequence;
                        BytecodeManager.incBytecodes(3);
                        branch3.add(branch4);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final Branch branch5 = (Branch)node;
                        BytecodeManager.incBytecodes(3);
                        if (branch5 == next) {
                            node = null;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            node2.next = node3;
                            BytecodeManager.incBytecodes(3);
                        }
                        final Branch branch6 = (Branch)node;
                        final Branch branch7 = (Branch)sequence;
                        final Node node8 = node3;
                        BytecodeManager.incBytecodes(6);
                        branch = (Branch)(node = new Branch(branch6, branch7, node8));
                        BytecodeManager.incBytecodes(3);
                    }
                }
                BytecodeManager.incBytecodes(2);
                final int peek = this.peek();
                final int n = 124;
                BytecodeManager.incBytecodes(2);
                if (peek != n) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                this.next();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            final Branch branch8 = (Branch)node;
            BytecodeManager.incBytecodes(2);
            return branch8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node sequence(final Node next) {
        try {
            Node node = null;
            BytecodeManager.incBytecodes(2);
            Node root = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
        Label_1070:
            while (true) {
                BytecodeManager.incBytecodes(2);
                final int peek = this.peek();
                BytecodeManager.incBytecodes(1);
                final int n = peek;
                BytecodeManager.incBytecodes(2);
                Node node4 = null;
                Label_1000: {
                    switch (n) {
                        case 40: {
                            BytecodeManager.incBytecodes(2);
                            final Node group0 = this.group0();
                            BytecodeManager.incBytecodes(1);
                            final Node node2 = group0;
                            BytecodeManager.incBytecodes(2);
                            if (node2 == null) {
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                            final Node node3 = node;
                            BytecodeManager.incBytecodes(2);
                            if (node3 == null) {
                                node = group0;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                root.next = group0;
                                BytecodeManager.incBytecodes(3);
                            }
                            root = this.root;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        case 91: {
                            final boolean b = true;
                            BytecodeManager.incBytecodes(3);
                            node4 = this.clazz(b);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_1000;
                        }
                        case 92: {
                            BytecodeManager.incBytecodes(2);
                            final int nextEscaped = this.nextEscaped();
                            BytecodeManager.incBytecodes(1);
                            final int n2 = nextEscaped;
                            final int n3 = 112;
                            BytecodeManager.incBytecodes(3);
                            if (n2 != n3) {
                                final int n4 = nextEscaped;
                                final int n5 = 80;
                                BytecodeManager.incBytecodes(3);
                                if (n4 != n5) {
                                    BytecodeManager.incBytecodes(2);
                                    this.unread();
                                    BytecodeManager.incBytecodes(2);
                                    node4 = this.atom();
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    break Label_1000;
                                }
                            }
                            boolean b2 = true;
                            BytecodeManager.incBytecodes(2);
                            final int n6 = nextEscaped;
                            final int n7 = 80;
                            BytecodeManager.incBytecodes(3);
                            boolean b3;
                            if (n6 == n7) {
                                b3 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b3 = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            final boolean b4 = b3;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            final int next2 = this.next();
                            BytecodeManager.incBytecodes(1);
                            final int n8 = next2;
                            final int n9 = 123;
                            BytecodeManager.incBytecodes(3);
                            if (n8 != n9) {
                                BytecodeManager.incBytecodes(2);
                                this.unread();
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                b2 = false;
                                BytecodeManager.incBytecodes(2);
                            }
                            final boolean b5 = b2;
                            final boolean b6 = b4;
                            BytecodeManager.incBytecodes(4);
                            node4 = this.family(b5, b6);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_1000;
                        }
                        case 94: {
                            BytecodeManager.incBytecodes(2);
                            this.next();
                            BytecodeManager.incBytecodes(1);
                            final int n10 = 8;
                            BytecodeManager.incBytecodes(3);
                            final boolean has = this.has(n10);
                            BytecodeManager.incBytecodes(1);
                            if (!has) {
                                BytecodeManager.incBytecodes(3);
                                node4 = new Begin();
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break Label_1000;
                            }
                            final int n11 = 1;
                            BytecodeManager.incBytecodes(3);
                            final boolean has2 = this.has(n11);
                            BytecodeManager.incBytecodes(1);
                            if (has2) {
                                BytecodeManager.incBytecodes(3);
                                node4 = new UnixCaret();
                                BytecodeManager.incBytecodes(2);
                                break Label_1000;
                            }
                            BytecodeManager.incBytecodes(3);
                            node4 = new Caret();
                            BytecodeManager.incBytecodes(2);
                            break Label_1000;
                        }
                        case 36: {
                            BytecodeManager.incBytecodes(2);
                            this.next();
                            BytecodeManager.incBytecodes(1);
                            final int n12 = 1;
                            BytecodeManager.incBytecodes(3);
                            final boolean has3 = this.has(n12);
                            BytecodeManager.incBytecodes(1);
                            if (has3) {
                                final int n13 = 8;
                                BytecodeManager.incBytecodes(5);
                                final boolean has4 = this.has(n13);
                                BytecodeManager.incBytecodes(1);
                                node4 = new UnixDollar(has4);
                                BytecodeManager.incBytecodes(2);
                                break Label_1000;
                            }
                            final int n14 = 8;
                            BytecodeManager.incBytecodes(5);
                            final boolean has5 = this.has(n14);
                            BytecodeManager.incBytecodes(1);
                            node4 = new Dollar(has5);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_1000;
                        }
                        case 46: {
                            BytecodeManager.incBytecodes(2);
                            this.next();
                            BytecodeManager.incBytecodes(1);
                            final int n15 = 32;
                            BytecodeManager.incBytecodes(3);
                            final boolean has6 = this.has(n15);
                            BytecodeManager.incBytecodes(1);
                            if (has6) {
                                BytecodeManager.incBytecodes(3);
                                node4 = new All();
                                BytecodeManager.incBytecodes(2);
                                break Label_1000;
                            }
                            final int n16 = 1;
                            BytecodeManager.incBytecodes(3);
                            final boolean has7 = this.has(n16);
                            BytecodeManager.incBytecodes(1);
                            if (has7) {
                                BytecodeManager.incBytecodes(3);
                                node4 = new UnixDot();
                                BytecodeManager.incBytecodes(2);
                                break Label_1000;
                            }
                            BytecodeManager.incBytecodes(3);
                            node4 = new Dot();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_1000;
                        }
                        case 41:
                        case 124: {
                            BytecodeManager.incBytecodes(1);
                            break Label_1070;
                        }
                        case 93:
                        case 125: {
                            BytecodeManager.incBytecodes(2);
                            node4 = this.atom();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_1000;
                        }
                        case 42:
                        case 43:
                        case 63: {
                            BytecodeManager.incBytecodes(2);
                            this.next();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(4);
                            final StringBuilder sb = new StringBuilder();
                            final String str = "Dangling meta character '";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb.append(str);
                            final char c = (char)peek;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append2 = append.append(c);
                            final String str2 = "'";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = append2.append(str2);
                            BytecodeManager.incBytecodes(1);
                            final String string = append3.toString();
                            BytecodeManager.incBytecodes(1);
                            final PatternSyntaxException error = this.error(string);
                            BytecodeManager.incBytecodes(1);
                            throw error;
                        }
                        case 0: {
                            final int cursor = this.cursor;
                            final int patternLength = this.patternLength;
                            BytecodeManager.incBytecodes(5);
                            if (cursor >= patternLength) {
                                BytecodeManager.incBytecodes(1);
                                break Label_1070;
                            }
                            break;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    node4 = this.atom();
                    BytecodeManager.incBytecodes(1);
                }
                final Node node5 = node4;
                BytecodeManager.incBytecodes(3);
                final Node closure = this.closure(node5);
                BytecodeManager.incBytecodes(1);
                final Node node6 = node;
                BytecodeManager.incBytecodes(2);
                if (node6 == null) {
                    root = (node = closure);
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    root.next = closure;
                    BytecodeManager.incBytecodes(3);
                    root = closure;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node node7 = node;
            BytecodeManager.incBytecodes(2);
            if (node7 == null) {
                BytecodeManager.incBytecodes(2);
                return next;
            }
            root.next = next;
            BytecodeManager.incBytecodes(3);
            this.root = root;
            BytecodeManager.incBytecodes(3);
            final Node node8 = node;
            BytecodeManager.incBytecodes(2);
            return node8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node atom() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = -1;
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n3 = this.peek();
            BytecodeManager.incBytecodes(1);
            Label_0670: {
                Block_11: {
                    Label_0526: {
                        int nextEscaped = 0;
                    Label_0243:
                        while (true) {
                            final int n4 = n3;
                            BytecodeManager.incBytecodes(2);
                            switch (n4) {
                                case 42:
                                case 43:
                                case 63:
                                case 123: {
                                    final int n5 = n;
                                    final int n6 = 1;
                                    BytecodeManager.incBytecodes(3);
                                    if (n5 > n6) {
                                        this.cursor = n2;
                                        BytecodeManager.incBytecodes(3);
                                        --n;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    break Label_0670;
                                }
                                case 36:
                                case 40:
                                case 41:
                                case 46:
                                case 91:
                                case 94:
                                case 124: {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0670;
                                }
                                case 92: {
                                    BytecodeManager.incBytecodes(2);
                                    nextEscaped = this.nextEscaped();
                                    BytecodeManager.incBytecodes(1);
                                    final int n7 = nextEscaped;
                                    final int n8 = 112;
                                    BytecodeManager.incBytecodes(3);
                                    if (n7 == n8) {
                                        break Label_0243;
                                    }
                                    final int n9 = nextEscaped;
                                    final int n10 = 80;
                                    BytecodeManager.incBytecodes(3);
                                    if (n9 == n10) {
                                        break Label_0243;
                                    }
                                    BytecodeManager.incBytecodes(2);
                                    this.unread();
                                    n2 = this.cursor;
                                    BytecodeManager.incBytecodes(3);
                                    final boolean b2 = false;
                                    final int n11 = n;
                                    BytecodeManager.incBytecodes(4);
                                    boolean b3;
                                    if (n11 == 0) {
                                        b3 = true;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        b3 = false;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final boolean b4 = false;
                                    BytecodeManager.incBytecodes(2);
                                    final int escape = this.escape(b2, b3, b4);
                                    BytecodeManager.incBytecodes(1);
                                    final int n12 = escape;
                                    BytecodeManager.incBytecodes(2);
                                    if (n12 >= 0) {
                                        final int n13 = escape;
                                        final int n14 = n;
                                        BytecodeManager.incBytecodes(4);
                                        this.append(n13, n14);
                                        ++n;
                                        BytecodeManager.incBytecodes(1);
                                        final int n15 = escape;
                                        BytecodeManager.incBytecodes(2);
                                        final boolean supplementary = isSupplementary(n15);
                                        BytecodeManager.incBytecodes(1);
                                        if (supplementary) {
                                            b = true;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        n3 = this.peek();
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        continue;
                                    }
                                    break Label_0526;
                                }
                                case 0: {
                                    final int cursor = this.cursor;
                                    final int patternLength = this.patternLength;
                                    BytecodeManager.incBytecodes(5);
                                    if (cursor >= patternLength) {
                                        break Block_11;
                                    }
                                    break;
                                }
                            }
                            n2 = this.cursor;
                            BytecodeManager.incBytecodes(3);
                            final int n16 = n3;
                            final int n17 = n;
                            BytecodeManager.incBytecodes(4);
                            this.append(n16, n17);
                            ++n;
                            BytecodeManager.incBytecodes(1);
                            final int n18 = n3;
                            BytecodeManager.incBytecodes(2);
                            final boolean supplementary2 = isSupplementary(n18);
                            BytecodeManager.incBytecodes(1);
                            if (supplementary2) {
                                b = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            BytecodeManager.incBytecodes(2);
                            n3 = this.next();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n19 = n;
                        BytecodeManager.incBytecodes(2);
                        if (n19 > 0) {
                            BytecodeManager.incBytecodes(2);
                            this.unread();
                            BytecodeManager.incBytecodes(1);
                            break Label_0670;
                        }
                        final int n20 = nextEscaped;
                        final int n21 = 80;
                        BytecodeManager.incBytecodes(3);
                        boolean b5;
                        if (n20 == n21) {
                            b5 = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            b5 = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean b6 = b5;
                        BytecodeManager.incBytecodes(1);
                        boolean b7 = true;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(2);
                        final int next = this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n22 = next;
                        final int n23 = 123;
                        BytecodeManager.incBytecodes(3);
                        if (n22 != n23) {
                            BytecodeManager.incBytecodes(2);
                            this.unread();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            b7 = false;
                            BytecodeManager.incBytecodes(2);
                        }
                        final boolean b8 = b7;
                        final boolean b9 = b6;
                        BytecodeManager.incBytecodes(4);
                        final CharProperty family = this.family(b8, b9);
                        BytecodeManager.incBytecodes(1);
                        return family;
                    }
                    final int n24 = n;
                    BytecodeManager.incBytecodes(2);
                    if (n24 == 0) {
                        final Node root = this.root;
                        BytecodeManager.incBytecodes(3);
                        return root;
                    }
                    this.cursor = n2;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    break Label_0670;
                }
                BytecodeManager.incBytecodes(1);
            }
            final int n25 = n;
            final int n26 = 1;
            BytecodeManager.incBytecodes(3);
            if (n25 == n26) {
                final int n27 = this.buffer[0];
                BytecodeManager.incBytecodes(6);
                final CharProperty single = this.newSingle(n27);
                BytecodeManager.incBytecodes(1);
                return single;
            }
            final int[] buffer = this.buffer;
            final int n28 = n;
            final boolean b10 = b;
            BytecodeManager.incBytecodes(6);
            final Node slice = this.newSlice(buffer, n28, b10);
            BytecodeManager.incBytecodes(1);
            return slice;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void append(final int n, final int n2) {
        try {
            final int length = this.buffer.length;
            BytecodeManager.incBytecodes(5);
            if (n2 >= length) {
                final int[] buffer = new int[n2 + n2];
                BytecodeManager.incBytecodes(4);
                final int[] buffer2 = this.buffer;
                final int n3 = 0;
                final int[] array = buffer;
                final int n4 = 0;
                BytecodeManager.incBytecodes(7);
                System.arraycopy(buffer2, n3, array, n4, n2);
                this.buffer = buffer;
                BytecodeManager.incBytecodes(3);
            }
            this.buffer[n2] = n;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node ref(int n) {
        try {
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                if (b2) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                final int peek = this.peek();
                BytecodeManager.incBytecodes(1);
                final int n2 = peek;
                BytecodeManager.incBytecodes(2);
                switch (n2) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57: {
                        final int n3 = n * 10 + (peek - 48);
                        BytecodeManager.incBytecodes(8);
                        final int n4 = this.capturingGroupCount - 1;
                        final int n5 = n3;
                        BytecodeManager.incBytecodes(6);
                        if (n4 < n5) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        n = n3;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(2);
                        this.read();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    default: {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            final int n6 = 2;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n6);
            BytecodeManager.incBytecodes(1);
            if (has) {
                final int n7 = n;
                final int n8 = 64;
                BytecodeManager.incBytecodes(6);
                final boolean has2 = this.has(n8);
                BytecodeManager.incBytecodes(1);
                final CIBackRef ciBackRef = new CIBackRef(n7, has2);
                BytecodeManager.incBytecodes(1);
                return ciBackRef;
            }
            final int n9 = n;
            BytecodeManager.incBytecodes(4);
            final BackRef backRef = new BackRef(n9);
            BytecodeManager.incBytecodes(1);
            return backRef;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int escape(final boolean b, final boolean b2, final boolean b3) {
        try {
            BytecodeManager.incBytecodes(2);
            final int skip = this.skip();
            BytecodeManager.incBytecodes(1);
            final int n = skip;
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 48: {
                    BytecodeManager.incBytecodes(2);
                    final int o = this.o();
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n2 = skip - 48;
                        BytecodeManager.incBytecodes(6);
                        this.root = this.ref(n2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n3 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n3;
                }
                case 65: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        this.root = new Begin();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n4 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n4;
                }
                case 66: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int none = Bound.NONE;
                        final int n5 = 256;
                        BytecodeManager.incBytecodes(7);
                        final boolean has = this.has(n5);
                        BytecodeManager.incBytecodes(1);
                        this.root = new Bound(none, has);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n6 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n6;
                }
                case 67: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 68: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n7 = 256;
                        BytecodeManager.incBytecodes(4);
                        final boolean has2 = this.has(n7);
                        BytecodeManager.incBytecodes(1);
                        CharProperty root;
                        if (has2) {
                            final UnicodeProp digit = UnicodeProp.DIGIT;
                            BytecodeManager.incBytecodes(4);
                            final Utype utype = new Utype(digit);
                            BytecodeManager.incBytecodes(1);
                            root = utype.complement();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n8 = 1024;
                            BytecodeManager.incBytecodes(4);
                            final Ctype ctype = new Ctype(n8);
                            BytecodeManager.incBytecodes(1);
                            root = ctype.complement();
                        }
                        this.root = root;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n9 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n9;
                }
                case 69:
                case 70: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 71: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        this.root = new LastMatch();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n10 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n10;
                }
                case 72: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        final HorizWS horizWS = new HorizWS();
                        BytecodeManager.incBytecodes(1);
                        this.root = horizWS.complement();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n11 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n11;
                }
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 82: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        this.root = new LineEnding();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n12 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n12;
                }
                case 83: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n13 = 256;
                        BytecodeManager.incBytecodes(4);
                        final boolean has3 = this.has(n13);
                        BytecodeManager.incBytecodes(1);
                        CharProperty root2;
                        if (has3) {
                            final UnicodeProp white_SPACE = UnicodeProp.WHITE_SPACE;
                            BytecodeManager.incBytecodes(4);
                            final Utype utype2 = new Utype(white_SPACE);
                            BytecodeManager.incBytecodes(1);
                            root2 = utype2.complement();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n14 = 2048;
                            BytecodeManager.incBytecodes(4);
                            final Ctype ctype2 = new Ctype(n14);
                            BytecodeManager.incBytecodes(1);
                            root2 = ctype2.complement();
                        }
                        this.root = root2;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n15 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n15;
                }
                case 84:
                case 85: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 86: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        final VertWS vertWS = new VertWS();
                        BytecodeManager.incBytecodes(1);
                        this.root = vertWS.complement();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n16 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n16;
                }
                case 87: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n17 = 256;
                        BytecodeManager.incBytecodes(4);
                        final boolean has4 = this.has(n17);
                        BytecodeManager.incBytecodes(1);
                        CharProperty root3;
                        if (has4) {
                            final UnicodeProp word = UnicodeProp.WORD;
                            BytecodeManager.incBytecodes(4);
                            final Utype utype3 = new Utype(word);
                            BytecodeManager.incBytecodes(1);
                            root3 = utype3.complement();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n18 = 67328;
                            BytecodeManager.incBytecodes(4);
                            final Ctype ctype3 = new Ctype(n18);
                            BytecodeManager.incBytecodes(1);
                            root3 = ctype3.complement();
                        }
                        this.root = root3;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n19 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n19;
                }
                case 88:
                case 89: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 90: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n20 = 1;
                        BytecodeManager.incBytecodes(3);
                        final boolean has5 = this.has(n20);
                        BytecodeManager.incBytecodes(1);
                        if (has5) {
                            final boolean b4 = false;
                            BytecodeManager.incBytecodes(5);
                            this.root = new UnixDollar(b4);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final boolean b5 = false;
                            BytecodeManager.incBytecodes(5);
                            this.root = new Dollar(b5);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final int n21 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n21;
                }
                case 97: {
                    final int n22 = 7;
                    BytecodeManager.incBytecodes(2);
                    return n22;
                }
                case 98: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int both = Bound.BOTH;
                        final int n23 = 256;
                        BytecodeManager.incBytecodes(7);
                        final boolean has6 = this.has(n23);
                        BytecodeManager.incBytecodes(1);
                        this.root = new Bound(both, has6);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n24 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n24;
                }
                case 99: {
                    BytecodeManager.incBytecodes(2);
                    final int c = this.c();
                    BytecodeManager.incBytecodes(1);
                    return c;
                }
                case 100: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n25 = 256;
                        BytecodeManager.incBytecodes(4);
                        final boolean has7 = this.has(n25);
                        BytecodeManager.incBytecodes(1);
                        CharProperty root4;
                        if (has7) {
                            final UnicodeProp digit2;
                            root4 = new Utype(digit2);
                            digit2 = UnicodeProp.DIGIT;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n26;
                            root4 = new Ctype(n26);
                            n26 = 1024;
                            BytecodeManager.incBytecodes(4);
                        }
                        this.root = root4;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n27 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n27;
                }
                case 101: {
                    final int n28 = 27;
                    BytecodeManager.incBytecodes(2);
                    return n28;
                }
                case 102: {
                    final int n29 = 12;
                    BytecodeManager.incBytecodes(2);
                    return n29;
                }
                case 103: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 104: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        this.root = new HorizWS();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n30 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n30;
                }
                case 105:
                case 106: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 107: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    final int read = this.read();
                    final int n31 = 60;
                    BytecodeManager.incBytecodes(2);
                    if (read != n31) {
                        final String s = "\\k is not followed by '<' for named capturing group";
                        BytecodeManager.incBytecodes(3);
                        final PatternSyntaxException error = this.error(s);
                        BytecodeManager.incBytecodes(1);
                        throw error;
                    }
                    BytecodeManager.incBytecodes(3);
                    final int read2 = this.read();
                    BytecodeManager.incBytecodes(1);
                    final String groupname = this.groupname(read2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    final Map<String, Integer> namedGroups = this.namedGroups();
                    final String s2 = groupname;
                    BytecodeManager.incBytecodes(2);
                    final boolean containsKey = namedGroups.containsKey(s2);
                    BytecodeManager.incBytecodes(1);
                    if (!containsKey) {
                        BytecodeManager.incBytecodes(4);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "(named capturing group <";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final String str2 = groupname;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(str2);
                        final String str3 = "> does not exit";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = append2.append(str3);
                        BytecodeManager.incBytecodes(1);
                        final String string = append3.toString();
                        BytecodeManager.incBytecodes(1);
                        final PatternSyntaxException error2 = this.error(string);
                        BytecodeManager.incBytecodes(1);
                        throw error2;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n32 = 2;
                        BytecodeManager.incBytecodes(3);
                        final boolean has8 = this.has(n32);
                        BytecodeManager.incBytecodes(1);
                        if (has8) {
                            BytecodeManager.incBytecodes(5);
                            final Map<String, Integer> namedGroups2 = this.namedGroups();
                            final String s3 = groupname;
                            BytecodeManager.incBytecodes(2);
                            final Integer n33 = namedGroups2.get(s3);
                            BytecodeManager.incBytecodes(2);
                            final int intValue = n33;
                            final int n34 = 64;
                            BytecodeManager.incBytecodes(3);
                            final boolean has9 = this.has(n34);
                            BytecodeManager.incBytecodes(1);
                            this.root = new CIBackRef(intValue, has9);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            BytecodeManager.incBytecodes(5);
                            final Map<String, Integer> namedGroups3 = this.namedGroups();
                            final String s4 = groupname;
                            BytecodeManager.incBytecodes(2);
                            final Integer n35 = namedGroups3.get(s4);
                            BytecodeManager.incBytecodes(2);
                            final int intValue2 = n35;
                            BytecodeManager.incBytecodes(1);
                            this.root = new BackRef(intValue2);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final int n36 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n36;
                }
                case 108:
                case 109: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 110: {
                    final int n37 = 10;
                    BytecodeManager.incBytecodes(2);
                    return n37;
                }
                case 111:
                case 112:
                case 113: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 114: {
                    final int n38 = 13;
                    BytecodeManager.incBytecodes(2);
                    return n38;
                }
                case 115: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n39 = 256;
                        BytecodeManager.incBytecodes(4);
                        final boolean has10 = this.has(n39);
                        BytecodeManager.incBytecodes(1);
                        CharProperty root5;
                        if (has10) {
                            final UnicodeProp white_SPACE2;
                            root5 = new Utype(white_SPACE2);
                            white_SPACE2 = UnicodeProp.WHITE_SPACE;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n40;
                            root5 = new Ctype(n40);
                            n40 = 2048;
                            BytecodeManager.incBytecodes(4);
                        }
                        this.root = root5;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n41 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n41;
                }
                case 116: {
                    final int n42 = 9;
                    BytecodeManager.incBytecodes(2);
                    return n42;
                }
                case 117: {
                    BytecodeManager.incBytecodes(2);
                    final int u = this.u();
                    BytecodeManager.incBytecodes(1);
                    return u;
                }
                case 118: {
                    BytecodeManager.incBytecodes(2);
                    if (b3) {
                        final int n43 = 11;
                        BytecodeManager.incBytecodes(2);
                        return n43;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        this.root = new VertWS();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n44 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n44;
                }
                case 119: {
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        final int n45 = 256;
                        BytecodeManager.incBytecodes(4);
                        final boolean has11 = this.has(n45);
                        BytecodeManager.incBytecodes(1);
                        CharProperty root6;
                        if (has11) {
                            final UnicodeProp word2;
                            root6 = new Utype(word2);
                            word2 = UnicodeProp.WORD;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n46;
                            root6 = new Ctype(n46);
                            n46 = 67328;
                            BytecodeManager.incBytecodes(4);
                        }
                        this.root = root6;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n47 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n47;
                }
                case 120: {
                    BytecodeManager.incBytecodes(2);
                    final int x = this.x();
                    BytecodeManager.incBytecodes(1);
                    return x;
                }
                case 121: {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                case 122: {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        BytecodeManager.incBytecodes(4);
                        this.root = new End();
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n48 = -1;
                    BytecodeManager.incBytecodes(2);
                    return n48;
                }
                default: {
                    final int n49 = skip;
                    BytecodeManager.incBytecodes(2);
                    return n49;
                }
            }
            final String s5 = "Illegal/unsupported escape sequence";
            BytecodeManager.incBytecodes(3);
            final PatternSyntaxException error3 = this.error(s5);
            BytecodeManager.incBytecodes(1);
            throw error3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharProperty clazz(final boolean b) {
        try {
            CharProperty charProperty = null;
            BytecodeManager.incBytecodes(2);
            CharProperty charProperty2 = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final BitClass bitClass = new BitClass();
            BytecodeManager.incBytecodes(1);
            int n = 1;
            BytecodeManager.incBytecodes(2);
            boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n2 = this.next();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                switch (n3) {
                    case 94: {
                        final boolean b3 = b2;
                        BytecodeManager.incBytecodes(2);
                        if (!b3) {
                            break;
                        }
                        final int n4 = this.temp[this.cursor - 1];
                        final int n5 = 91;
                        BytecodeManager.incBytecodes(9);
                        if (n4 != n5) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        BytecodeManager.incBytecodes(2);
                        n2 = this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n6 = n;
                        BytecodeManager.incBytecodes(2);
                        int n7;
                        if (n6 == 0) {
                            n7 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n7 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        n = n7;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        continue;
                    }
                    case 91: {
                        b2 = false;
                        BytecodeManager.incBytecodes(2);
                        final boolean b4 = true;
                        BytecodeManager.incBytecodes(3);
                        charProperty2 = this.clazz(b4);
                        BytecodeManager.incBytecodes(1);
                        final CharProperty charProperty3 = charProperty;
                        BytecodeManager.incBytecodes(2);
                        if (charProperty3 == null) {
                            charProperty = charProperty2;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            final CharProperty charProperty4 = charProperty;
                            final CharProperty charProperty5 = charProperty2;
                            BytecodeManager.incBytecodes(3);
                            charProperty = union(charProperty4, charProperty5);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(2);
                        n2 = this.peek();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        continue;
                    }
                    case 38: {
                        b2 = false;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(2);
                        final int next = this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n8 = next;
                        final int n9 = 38;
                        BytecodeManager.incBytecodes(3);
                        if (n8 == n9) {
                            BytecodeManager.incBytecodes(2);
                            n2 = this.next();
                            BytecodeManager.incBytecodes(1);
                            CharProperty charProperty6 = null;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n10 = n2;
                                final int n11 = 93;
                                BytecodeManager.incBytecodes(3);
                                if (n10 == n11) {
                                    break;
                                }
                                final int n12 = n2;
                                final int n13 = 38;
                                BytecodeManager.incBytecodes(3);
                                if (n12 == n13) {
                                    break;
                                }
                                final int n14 = n2;
                                final int n15 = 91;
                                BytecodeManager.incBytecodes(3);
                                if (n14 == n15) {
                                    final CharProperty charProperty7 = charProperty6;
                                    BytecodeManager.incBytecodes(2);
                                    if (charProperty7 == null) {
                                        final boolean b5 = true;
                                        BytecodeManager.incBytecodes(3);
                                        charProperty6 = this.clazz(b5);
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final CharProperty charProperty8 = charProperty6;
                                        final boolean b6 = true;
                                        BytecodeManager.incBytecodes(4);
                                        final CharProperty clazz = this.clazz(b6);
                                        BytecodeManager.incBytecodes(1);
                                        charProperty6 = union(charProperty8, clazz);
                                        BytecodeManager.incBytecodes(2);
                                    }
                                }
                                else {
                                    BytecodeManager.incBytecodes(2);
                                    this.unread();
                                    final boolean b7 = false;
                                    BytecodeManager.incBytecodes(3);
                                    charProperty6 = this.clazz(b7);
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(2);
                                n2 = this.peek();
                                BytecodeManager.incBytecodes(2);
                            }
                            final CharProperty charProperty9 = charProperty6;
                            BytecodeManager.incBytecodes(2);
                            if (charProperty9 != null) {
                                charProperty2 = charProperty6;
                                BytecodeManager.incBytecodes(2);
                            }
                            final CharProperty charProperty10 = charProperty;
                            BytecodeManager.incBytecodes(2);
                            if (charProperty10 == null) {
                                final CharProperty charProperty11 = charProperty6;
                                BytecodeManager.incBytecodes(2);
                                if (charProperty11 == null) {
                                    final String s = "Bad class syntax";
                                    BytecodeManager.incBytecodes(3);
                                    final PatternSyntaxException error = this.error(s);
                                    BytecodeManager.incBytecodes(1);
                                    throw error;
                                }
                                charProperty = charProperty6;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final CharProperty charProperty12 = charProperty;
                                final CharProperty charProperty13 = charProperty2;
                                BytecodeManager.incBytecodes(3);
                                charProperty = intersection(charProperty12, charProperty13);
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        BytecodeManager.incBytecodes(2);
                        this.unread();
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 0: {
                        b2 = false;
                        BytecodeManager.incBytecodes(2);
                        final int cursor = this.cursor;
                        final int patternLength = this.patternLength;
                        BytecodeManager.incBytecodes(5);
                        if (cursor >= patternLength) {
                            final String s2 = "Unclosed character class";
                            BytecodeManager.incBytecodes(3);
                            final PatternSyntaxException error2 = this.error(s2);
                            BytecodeManager.incBytecodes(1);
                            throw error2;
                        }
                        break;
                    }
                    case 93: {
                        b2 = false;
                        BytecodeManager.incBytecodes(2);
                        final CharProperty charProperty14 = charProperty;
                        BytecodeManager.incBytecodes(2);
                        if (charProperty14 != null) {
                            BytecodeManager.incBytecodes(2);
                            if (b) {
                                BytecodeManager.incBytecodes(2);
                                this.next();
                                BytecodeManager.incBytecodes(1);
                            }
                            final CharProperty charProperty15 = charProperty;
                            BytecodeManager.incBytecodes(2);
                            return charProperty15;
                        }
                        break;
                    }
                    default: {
                        b2 = false;
                        BytecodeManager.incBytecodes(2);
                        break;
                    }
                }
                final BitClass bitClass2 = bitClass;
                BytecodeManager.incBytecodes(3);
                charProperty2 = this.range(bitClass2);
                BytecodeManager.incBytecodes(1);
                final int n16 = n;
                BytecodeManager.incBytecodes(2);
                if (n16 != 0) {
                    final CharProperty charProperty16 = charProperty;
                    BytecodeManager.incBytecodes(2);
                    if (charProperty16 == null) {
                        charProperty = charProperty2;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final CharProperty charProperty17 = charProperty;
                        final CharProperty charProperty18 = charProperty2;
                        BytecodeManager.incBytecodes(3);
                        if (charProperty17 != charProperty18) {
                            final CharProperty charProperty19 = charProperty;
                            final CharProperty charProperty20 = charProperty2;
                            BytecodeManager.incBytecodes(3);
                            charProperty = union(charProperty19, charProperty20);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                else {
                    final CharProperty charProperty21 = charProperty;
                    BytecodeManager.incBytecodes(2);
                    if (charProperty21 == null) {
                        final CharProperty charProperty22 = charProperty2;
                        BytecodeManager.incBytecodes(2);
                        charProperty = charProperty22.complement();
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final CharProperty charProperty23 = charProperty;
                        final CharProperty charProperty24 = charProperty2;
                        BytecodeManager.incBytecodes(3);
                        if (charProperty23 != charProperty24) {
                            final CharProperty charProperty25 = charProperty;
                            final CharProperty charProperty26 = charProperty2;
                            BytecodeManager.incBytecodes(3);
                            charProperty = setDifference(charProperty25, charProperty26);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                BytecodeManager.incBytecodes(2);
                n2 = this.peek();
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharProperty bitsOrSingle(final BitClass bitClass, final int n) {
        try {
            final int n2 = 256;
            BytecodeManager.incBytecodes(3);
            Label_0205: {
                if (n < n2) {
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean has = this.has(n3);
                    BytecodeManager.incBytecodes(1);
                    if (has) {
                        final int n4 = 64;
                        BytecodeManager.incBytecodes(3);
                        final boolean has2 = this.has(n4);
                        BytecodeManager.incBytecodes(1);
                        if (has2) {
                            final int n5 = 255;
                            BytecodeManager.incBytecodes(3);
                            if (n == n5) {
                                break Label_0205;
                            }
                            final int n6 = 181;
                            BytecodeManager.incBytecodes(3);
                            if (n == n6) {
                                break Label_0205;
                            }
                            final int n7 = 73;
                            BytecodeManager.incBytecodes(3);
                            if (n == n7) {
                                break Label_0205;
                            }
                            final int n8 = 105;
                            BytecodeManager.incBytecodes(3);
                            if (n == n8) {
                                break Label_0205;
                            }
                            final int n9 = 83;
                            BytecodeManager.incBytecodes(3);
                            if (n == n9) {
                                break Label_0205;
                            }
                            final int n10 = 115;
                            BytecodeManager.incBytecodes(3);
                            if (n == n10) {
                                break Label_0205;
                            }
                            final int n11 = 75;
                            BytecodeManager.incBytecodes(3);
                            if (n == n11) {
                                break Label_0205;
                            }
                            final int n12 = 107;
                            BytecodeManager.incBytecodes(3);
                            if (n == n12) {
                                break Label_0205;
                            }
                            final int n13 = 197;
                            BytecodeManager.incBytecodes(3);
                            if (n == n13) {
                                break Label_0205;
                            }
                            final int n14 = 229;
                            BytecodeManager.incBytecodes(3);
                            if (n == n14) {
                                break Label_0205;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(4);
                    final int flags = this.flags();
                    BytecodeManager.incBytecodes(1);
                    final BitClass add = bitClass.add(n, flags);
                    BytecodeManager.incBytecodes(1);
                    return add;
                }
            }
            BytecodeManager.incBytecodes(3);
            final CharProperty single = this.newSingle(n);
            BytecodeManager.incBytecodes(1);
            return single;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharProperty range(final BitClass bitClass) {
        try {
            BytecodeManager.incBytecodes(2);
            int n = this.peek();
            BytecodeManager.incBytecodes(1);
            final int n2 = n;
            final int n3 = 92;
            BytecodeManager.incBytecodes(3);
            Label_0295: {
                if (n2 == n3) {
                    BytecodeManager.incBytecodes(2);
                    final int nextEscaped = this.nextEscaped();
                    BytecodeManager.incBytecodes(1);
                    final int n4 = nextEscaped;
                    final int n5 = 112;
                    BytecodeManager.incBytecodes(3);
                    if (n4 != n5) {
                        final int n6 = nextEscaped;
                        final int n7 = 80;
                        BytecodeManager.incBytecodes(3);
                        if (n6 != n7) {
                            final int n8 = this.temp[this.cursor + 1];
                            final int n9 = 45;
                            BytecodeManager.incBytecodes(9);
                            boolean b;
                            if (n8 == n9) {
                                b = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            final boolean b2 = b;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            this.unread();
                            final boolean b3 = true;
                            final boolean b4 = true;
                            final boolean b5 = b2;
                            BytecodeManager.incBytecodes(5);
                            n = this.escape(b3, b4, b5);
                            BytecodeManager.incBytecodes(1);
                            final int n10 = n;
                            final int n11 = -1;
                            BytecodeManager.incBytecodes(3);
                            if (n10 == n11) {
                                final CharProperty charProperty = (CharProperty)this.root;
                                BytecodeManager.incBytecodes(4);
                                return charProperty;
                            }
                            BytecodeManager.incBytecodes(1);
                            break Label_0295;
                        }
                    }
                    final int n12 = nextEscaped;
                    final int n13 = 80;
                    BytecodeManager.incBytecodes(3);
                    boolean b6;
                    if (n12 == n13) {
                        b6 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b6 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    final boolean b7 = b6;
                    BytecodeManager.incBytecodes(1);
                    boolean b8 = true;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    final int next = this.next();
                    BytecodeManager.incBytecodes(1);
                    final int n14 = next;
                    final int n15 = 123;
                    BytecodeManager.incBytecodes(3);
                    if (n14 != n15) {
                        BytecodeManager.incBytecodes(2);
                        this.unread();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        b8 = false;
                        BytecodeManager.incBytecodes(2);
                    }
                    final boolean b9 = b8;
                    final boolean b10 = b7;
                    BytecodeManager.incBytecodes(4);
                    final CharProperty family = this.family(b9, b10);
                    BytecodeManager.incBytecodes(1);
                    return family;
                }
                BytecodeManager.incBytecodes(2);
                this.next();
                BytecodeManager.incBytecodes(1);
            }
            final int n16 = n;
            BytecodeManager.incBytecodes(2);
            if (n16 >= 0) {
                BytecodeManager.incBytecodes(2);
                final int peek = this.peek();
                final int n17 = 45;
                BytecodeManager.incBytecodes(2);
                if (peek == n17) {
                    final int n18 = this.temp[this.cursor + 1];
                    BytecodeManager.incBytecodes(8);
                    final int n19 = n18;
                    final int n20 = 91;
                    BytecodeManager.incBytecodes(3);
                    if (n19 == n20) {
                        final int n21 = n;
                        BytecodeManager.incBytecodes(4);
                        final CharProperty bitsOrSingle = this.bitsOrSingle(bitClass, n21);
                        BytecodeManager.incBytecodes(1);
                        return bitsOrSingle;
                    }
                    final int n22 = n18;
                    final int n23 = 93;
                    BytecodeManager.incBytecodes(3);
                    if (n22 != n23) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        int n24 = this.peek();
                        BytecodeManager.incBytecodes(1);
                        final int n25 = n24;
                        final int n26 = 92;
                        BytecodeManager.incBytecodes(3);
                        if (n25 == n26) {
                            final boolean b11 = true;
                            final boolean b12 = false;
                            final boolean b13 = true;
                            BytecodeManager.incBytecodes(5);
                            n24 = this.escape(b11, b12, b13);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            BytecodeManager.incBytecodes(2);
                            this.next();
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n27 = n24;
                        final int n28 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n27 < n28) {
                            final String s = "Illegal character range";
                            BytecodeManager.incBytecodes(3);
                            final PatternSyntaxException error = this.error(s);
                            BytecodeManager.incBytecodes(1);
                            throw error;
                        }
                        final int n29 = 2;
                        BytecodeManager.incBytecodes(3);
                        final boolean has = this.has(n29);
                        BytecodeManager.incBytecodes(1);
                        if (has) {
                            final int n30 = n;
                            final int n31 = n24;
                            BytecodeManager.incBytecodes(4);
                            final CharProperty caseInsensitiveRange = this.caseInsensitiveRangeFor(n30, n31);
                            BytecodeManager.incBytecodes(1);
                            return caseInsensitiveRange;
                        }
                        final int n32 = n;
                        final int n33 = n24;
                        BytecodeManager.incBytecodes(3);
                        final CharProperty range = rangeFor(n32, n33);
                        BytecodeManager.incBytecodes(1);
                        return range;
                    }
                }
                final int n34 = n;
                BytecodeManager.incBytecodes(4);
                final CharProperty bitsOrSingle2 = this.bitsOrSingle(bitClass, n34);
                BytecodeManager.incBytecodes(1);
                return bitsOrSingle2;
            }
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            final String str = "Unexpected character '";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final char c = (char)n;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(c);
            final String str2 = "'";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            final PatternSyntaxException error2 = this.error(string);
            BytecodeManager.incBytecodes(1);
            throw error2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharProperty family(final boolean b, final boolean b2) {
        try {
            BytecodeManager.incBytecodes(2);
            this.next();
            BytecodeManager.incBytecodes(1);
            CharProperty charProperty = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            String value;
            if (b) {
                final int n = this.temp[this.cursor];
                BytecodeManager.incBytecodes(6);
                final int codePoint = n;
                BytecodeManager.incBytecodes(2);
                final boolean supplementaryCodePoint = Character.isSupplementaryCodePoint(codePoint);
                BytecodeManager.incBytecodes(1);
                if (!supplementaryCodePoint) {
                    final char c = (char)n;
                    BytecodeManager.incBytecodes(3);
                    value = String.valueOf(c);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int[] temp = this.temp;
                    final int cursor = this.cursor;
                    final int count = 1;
                    BytecodeManager.incBytecodes(8);
                    value = new String(temp, cursor, count);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(2);
                this.read();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int cursor2 = this.cursor;
                BytecodeManager.incBytecodes(3);
                final int n2 = 125;
                BytecodeManager.incBytecodes(3);
                this.mark(n2);
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final int read = this.read();
                    final int n3 = 125;
                    BytecodeManager.incBytecodes(2);
                    if (read == n3) {
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final int n4 = 0;
                BytecodeManager.incBytecodes(3);
                this.mark(n4);
                final int cursor3 = this.cursor;
                BytecodeManager.incBytecodes(3);
                final int n5 = cursor3;
                final int patternLength = this.patternLength;
                BytecodeManager.incBytecodes(4);
                if (n5 > patternLength) {
                    final String s = "Unclosed character family";
                    BytecodeManager.incBytecodes(3);
                    final PatternSyntaxException error = this.error(s);
                    BytecodeManager.incBytecodes(1);
                    throw error;
                }
                final int n6 = cursor2 + 1;
                final int n7 = cursor3;
                BytecodeManager.incBytecodes(5);
                if (n6 >= n7) {
                    final String s2 = "Empty character family";
                    BytecodeManager.incBytecodes(3);
                    final PatternSyntaxException error2 = this.error(s2);
                    BytecodeManager.incBytecodes(1);
                    throw error2;
                }
                final int[] temp2 = this.temp;
                final int offset = cursor2;
                final int count2 = cursor3 - cursor2 - 1;
                BytecodeManager.incBytecodes(11);
                value = new String(temp2, offset, count2);
                BytecodeManager.incBytecodes(1);
            }
            final String s3 = value;
            final int ch = 61;
            BytecodeManager.incBytecodes(3);
            final int index = s3.indexOf(ch);
            BytecodeManager.incBytecodes(1);
            final int n8 = index;
            final int n9 = -1;
            BytecodeManager.incBytecodes(3);
            if (n8 != n9) {
                final String s4 = value;
                final int beginIndex = index + 1;
                BytecodeManager.incBytecodes(5);
                final String substring = s4.substring(beginIndex);
                BytecodeManager.incBytecodes(1);
                final String s5 = value;
                final int beginIndex2 = 0;
                final int endIndex = index;
                BytecodeManager.incBytecodes(4);
                final String substring2 = s5.substring(beginIndex2, endIndex);
                final Locale english = Locale.ENGLISH;
                BytecodeManager.incBytecodes(2);
                final String lowerCase = substring2.toLowerCase(english);
                BytecodeManager.incBytecodes(1);
                final String s6 = "sc";
                final String anObject = lowerCase;
                BytecodeManager.incBytecodes(3);
                final boolean equals = s6.equals(anObject);
                BytecodeManager.incBytecodes(1);
                Label_0682: {
                    if (!equals) {
                        final String s7 = "script";
                        final String anObject2 = lowerCase;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals2 = s7.equals(anObject2);
                        BytecodeManager.incBytecodes(1);
                        if (!equals2) {
                            final String s8 = "blk";
                            final String anObject3 = lowerCase;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals3 = s8.equals(anObject3);
                            BytecodeManager.incBytecodes(1);
                            if (!equals3) {
                                final String s9 = "block";
                                final String anObject4 = lowerCase;
                                BytecodeManager.incBytecodes(3);
                                final boolean equals4 = s9.equals(anObject4);
                                BytecodeManager.incBytecodes(1);
                                if (!equals4) {
                                    final String s10 = "gc";
                                    final String anObject5 = lowerCase;
                                    BytecodeManager.incBytecodes(3);
                                    final boolean equals5 = s10.equals(anObject5);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals5) {
                                        final String s11 = "general_category";
                                        final String anObject6 = lowerCase;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean equals6 = s11.equals(anObject6);
                                        BytecodeManager.incBytecodes(1);
                                        if (!equals6) {
                                            BytecodeManager.incBytecodes(4);
                                            final StringBuilder sb = new StringBuilder();
                                            final String str = "Unknown Unicode property {name=<";
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append = sb.append(str);
                                            final String str2 = lowerCase;
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append2 = append.append(str2);
                                            final String str3 = ">, ";
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append3 = append2.append(str3);
                                            final String str4 = "value=<";
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append4 = append3.append(str4);
                                            final String str5 = substring;
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append5 = append4.append(str5);
                                            final String str6 = ">}";
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append6 = append5.append(str6);
                                            BytecodeManager.incBytecodes(1);
                                            final String string = append6.toString();
                                            BytecodeManager.incBytecodes(1);
                                            final PatternSyntaxException error3 = this.error(string);
                                            BytecodeManager.incBytecodes(1);
                                            throw error3;
                                        }
                                    }
                                    final String s12 = substring;
                                    BytecodeManager.incBytecodes(3);
                                    charProperty = this.charPropertyNodeFor(s12);
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0682;
                                }
                            }
                            final String s13 = substring;
                            BytecodeManager.incBytecodes(3);
                            charProperty = this.unicodeBlockPropertyFor(s13);
                            BytecodeManager.incBytecodes(2);
                            break Label_0682;
                        }
                    }
                    final String s14 = substring;
                    BytecodeManager.incBytecodes(3);
                    charProperty = this.unicodeScriptPropertyFor(s14);
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                final String s15 = value;
                final String prefix = "In";
                BytecodeManager.incBytecodes(3);
                final boolean startsWith = s15.startsWith(prefix);
                BytecodeManager.incBytecodes(1);
                if (startsWith) {
                    final String s16 = value;
                    final int beginIndex3 = 2;
                    BytecodeManager.incBytecodes(4);
                    final String substring3 = s16.substring(beginIndex3);
                    BytecodeManager.incBytecodes(1);
                    charProperty = this.unicodeBlockPropertyFor(substring3);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final String s17 = value;
                    final String prefix2 = "Is";
                    BytecodeManager.incBytecodes(3);
                    final boolean startsWith2 = s17.startsWith(prefix2);
                    BytecodeManager.incBytecodes(1);
                    if (startsWith2) {
                        final String s18 = value;
                        final int beginIndex4 = 2;
                        BytecodeManager.incBytecodes(3);
                        final String substring4 = s18.substring(beginIndex4);
                        BytecodeManager.incBytecodes(1);
                        final String s19 = substring4;
                        BytecodeManager.incBytecodes(2);
                        final UnicodeProp forName = UnicodeProp.forName(s19);
                        BytecodeManager.incBytecodes(1);
                        final UnicodeProp unicodeProp = forName;
                        BytecodeManager.incBytecodes(2);
                        if (unicodeProp != null) {
                            final UnicodeProp unicodeProp2 = forName;
                            BytecodeManager.incBytecodes(4);
                            charProperty = new Utype(unicodeProp2);
                            BytecodeManager.incBytecodes(1);
                        }
                        final CharProperty charProperty2 = charProperty;
                        BytecodeManager.incBytecodes(2);
                        if (charProperty2 == null) {
                            final String s20 = substring4;
                            BytecodeManager.incBytecodes(2);
                            charProperty = CharPropertyNames.charPropertyFor(s20);
                            BytecodeManager.incBytecodes(1);
                        }
                        final CharProperty charProperty3 = charProperty;
                        BytecodeManager.incBytecodes(2);
                        if (charProperty3 == null) {
                            final String s21 = substring4;
                            BytecodeManager.incBytecodes(3);
                            charProperty = this.unicodeScriptPropertyFor(s21);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n10 = 256;
                        BytecodeManager.incBytecodes(3);
                        final boolean has = this.has(n10);
                        BytecodeManager.incBytecodes(1);
                        if (has) {
                            final String s22 = value;
                            BytecodeManager.incBytecodes(2);
                            final UnicodeProp forPOSIXName = UnicodeProp.forPOSIXName(s22);
                            BytecodeManager.incBytecodes(1);
                            final UnicodeProp unicodeProp3 = forPOSIXName;
                            BytecodeManager.incBytecodes(2);
                            if (unicodeProp3 != null) {
                                final UnicodeProp unicodeProp4 = forPOSIXName;
                                BytecodeManager.incBytecodes(4);
                                charProperty = new Utype(unicodeProp4);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final CharProperty charProperty4 = charProperty;
                        BytecodeManager.incBytecodes(2);
                        if (charProperty4 == null) {
                            final String s23 = value;
                            BytecodeManager.incBytecodes(3);
                            charProperty = this.charPropertyNodeFor(s23);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            if (b2) {
                final boolean b3 = charProperty instanceof Category;
                BytecodeManager.incBytecodes(3);
                Label_1031: {
                    if (!b3) {
                        final boolean b4 = charProperty instanceof Block;
                        BytecodeManager.incBytecodes(3);
                        if (!b4) {
                            break Label_1031;
                        }
                    }
                    this.hasSupplementary = true;
                    BytecodeManager.incBytecodes(3);
                }
                final CharProperty charProperty5 = charProperty;
                BytecodeManager.incBytecodes(2);
                charProperty = charProperty5.complement();
                BytecodeManager.incBytecodes(1);
            }
            final CharProperty charProperty6 = charProperty;
            BytecodeManager.incBytecodes(2);
            return charProperty6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharProperty unicodeScriptPropertyFor(final String s) {
        try {
            try {
                Character.UnicodeScript forName;
                try {
                    BytecodeManager.incBytecodes(2);
                    forName = Character.UnicodeScript.forName(s);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                catch (IllegalArgumentException ex) {
                    BytecodeManager.incBytecodes(501);
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Unknown character script name {";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(s);
                    final String str2 = "}";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str2);
                    BytecodeManager.incBytecodes(1);
                    final String string = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    final PatternSyntaxException error = this.error(string);
                    BytecodeManager.incBytecodes(1);
                    throw error;
                }
                final Character.UnicodeScript unicodeScript = forName;
                BytecodeManager.incBytecodes(4);
                final Script script = new Script(unicodeScript);
                BytecodeManager.incBytecodes(1);
                return script;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private CharProperty unicodeBlockPropertyFor(final String s) {
        try {
            try {
                Character.UnicodeBlock forName;
                try {
                    BytecodeManager.incBytecodes(2);
                    forName = Character.UnicodeBlock.forName(s);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                catch (IllegalArgumentException ex) {
                    BytecodeManager.incBytecodes(501);
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Unknown character block name {";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(s);
                    final String str2 = "}";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str2);
                    BytecodeManager.incBytecodes(1);
                    final String string = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    final PatternSyntaxException error = this.error(string);
                    BytecodeManager.incBytecodes(1);
                    throw error;
                }
                final Character.UnicodeBlock unicodeBlock = forName;
                BytecodeManager.incBytecodes(4);
                final Block block = new Block(unicodeBlock);
                BytecodeManager.incBytecodes(1);
                return block;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private CharProperty charPropertyNodeFor(final String str) {
        try {
            BytecodeManager.incBytecodes(2);
            final CharProperty charProperty = CharPropertyNames.charPropertyFor(str);
            BytecodeManager.incBytecodes(1);
            final CharProperty charProperty2 = charProperty;
            BytecodeManager.incBytecodes(2);
            if (charProperty2 == null) {
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb = new StringBuilder();
                final String str2 = "Unknown character property name {";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final String str3 = "}";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final PatternSyntaxException error = this.error(string);
                BytecodeManager.incBytecodes(1);
                throw error;
            }
            final CharProperty charProperty3 = charProperty;
            BytecodeManager.incBytecodes(2);
            return charProperty3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String groupname(int read) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final int codePoint = read;
            BytecodeManager.incBytecodes(3);
            final char[] chars = Character.toChars(codePoint);
            BytecodeManager.incBytecodes(1);
            sb2.append(chars);
            BytecodeManager.incBytecodes(1);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final int n = read = this.read();
                BytecodeManager.incBytecodes(3);
                final boolean lower = ASCII.isLower(n);
                BytecodeManager.incBytecodes(1);
                if (!lower) {
                    final int n2 = read;
                    BytecodeManager.incBytecodes(2);
                    final boolean upper = ASCII.isUpper(n2);
                    BytecodeManager.incBytecodes(1);
                    if (!upper) {
                        final int n3 = read;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final boolean digit = ASCII.isDigit(n3);
                        BytecodeManager.incBytecodes(1);
                        if (!digit) {
                            break;
                        }
                    }
                }
                final StringBuilder sb3 = sb;
                final int codePoint2 = read;
                BytecodeManager.incBytecodes(3);
                final char[] chars2 = Character.toChars(codePoint2);
                BytecodeManager.incBytecodes(1);
                sb3.append(chars2);
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb4 = sb;
            BytecodeManager.incBytecodes(2);
            final int length = sb4.length();
            BytecodeManager.incBytecodes(1);
            if (length == 0) {
                final String s = "named capturing group has 0 length name";
                BytecodeManager.incBytecodes(3);
                final PatternSyntaxException error = this.error(s);
                BytecodeManager.incBytecodes(1);
                throw error;
            }
            final int n4 = read;
            final int n5 = 62;
            BytecodeManager.incBytecodes(3);
            if (n4 != n5) {
                final String s2 = "named capturing group is missing trailing '>'";
                BytecodeManager.incBytecodes(3);
                final PatternSyntaxException error2 = this.error(s2);
                BytecodeManager.incBytecodes(1);
                throw error2;
            }
            final StringBuilder sb5 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb5.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node group0() {
        try {
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int flags = this.flags;
            BytecodeManager.incBytecodes(3);
            this.root = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int next = this.next();
            BytecodeManager.incBytecodes(1);
            final int n = next;
            final int n2 = 63;
            BytecodeManager.incBytecodes(3);
            Node body = null;
            Node root = null;
            if (n == n2) {
                BytecodeManager.incBytecodes(2);
                final int skip = this.skip();
                BytecodeManager.incBytecodes(1);
                final int n3 = skip;
                BytecodeManager.incBytecodes(2);
                switch (n3) {
                    case 58: {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(3);
                        body = this.createGroup(b2);
                        BytecodeManager.incBytecodes(1);
                        root = this.root;
                        BytecodeManager.incBytecodes(3);
                        final Node node = body;
                        final Node node2 = root;
                        BytecodeManager.incBytecodes(4);
                        node.next = this.expr(node2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 33:
                    case 61: {
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(3);
                        final Node group = this.createGroup(b3);
                        BytecodeManager.incBytecodes(1);
                        final Node root2 = this.root;
                        BytecodeManager.incBytecodes(3);
                        final Node node3 = group;
                        final Node node4 = root2;
                        BytecodeManager.incBytecodes(4);
                        node3.next = this.expr(node4);
                        BytecodeManager.incBytecodes(1);
                        final int n4 = skip;
                        final int n5 = 61;
                        BytecodeManager.incBytecodes(3);
                        if (n4 == n5) {
                            final Node node5 = group;
                            BytecodeManager.incBytecodes(4);
                            root = (body = new Pos(node5));
                            BytecodeManager.incBytecodes(4);
                            break;
                        }
                        final Node node6 = group;
                        BytecodeManager.incBytecodes(4);
                        root = (body = new Neg(node6));
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 62: {
                        final boolean b4 = true;
                        BytecodeManager.incBytecodes(3);
                        final Node group2 = this.createGroup(b4);
                        BytecodeManager.incBytecodes(1);
                        final Node root3 = this.root;
                        BytecodeManager.incBytecodes(3);
                        final Node node7 = group2;
                        final Node node8 = root3;
                        BytecodeManager.incBytecodes(4);
                        node7.next = this.expr(node8);
                        BytecodeManager.incBytecodes(1);
                        final Node node9 = group2;
                        final int n6 = 3;
                        BytecodeManager.incBytecodes(5);
                        root = (body = new Ques(node9, n6));
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 60: {
                        BytecodeManager.incBytecodes(2);
                        final int read = this.read();
                        BytecodeManager.incBytecodes(1);
                        final int n7 = read;
                        BytecodeManager.incBytecodes(2);
                        final boolean lower = ASCII.isLower(n7);
                        BytecodeManager.incBytecodes(1);
                        if (!lower) {
                            final int n8 = read;
                            BytecodeManager.incBytecodes(2);
                            final boolean upper = ASCII.isUpper(n8);
                            BytecodeManager.incBytecodes(1);
                            if (!upper) {
                                final int cursor = this.cursor;
                                BytecodeManager.incBytecodes(3);
                                final boolean b5 = true;
                                BytecodeManager.incBytecodes(3);
                                final Node group3 = this.createGroup(b5);
                                BytecodeManager.incBytecodes(1);
                                final Node root4 = this.root;
                                BytecodeManager.incBytecodes(3);
                                final Node node10 = group3;
                                final Node node11 = root4;
                                BytecodeManager.incBytecodes(4);
                                node10.next = this.expr(node11);
                                BytecodeManager.incBytecodes(1);
                                root4.next = Pattern.lookbehindEnd;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(3);
                                final TreeInfo treeInfo = new TreeInfo();
                                BytecodeManager.incBytecodes(1);
                                final Node node12 = group3;
                                final TreeInfo treeInfo2 = treeInfo;
                                BytecodeManager.incBytecodes(3);
                                node12.study(treeInfo2);
                                BytecodeManager.incBytecodes(1);
                                final boolean maxValid = treeInfo.maxValid;
                                BytecodeManager.incBytecodes(3);
                                if (!maxValid) {
                                    final String s = "Look-behind group does not have an obvious maximum length";
                                    BytecodeManager.incBytecodes(3);
                                    final PatternSyntaxException error = this.error(s);
                                    BytecodeManager.incBytecodes(1);
                                    throw error;
                                }
                                final int n9 = cursor;
                                final int patternLength = this.patternLength;
                                BytecodeManager.incBytecodes(5);
                                final boolean supplementary = this.findSupplementary(n9, patternLength);
                                BytecodeManager.incBytecodes(1);
                                final int n10 = read;
                                final int n11 = 61;
                                BytecodeManager.incBytecodes(3);
                                if (n10 == n11) {
                                    final boolean b6 = supplementary;
                                    BytecodeManager.incBytecodes(2);
                                    Behind behind2;
                                    Behind behind;
                                    if (b6) {
                                        final Node node13;
                                        final int maxLength;
                                        final int minLength;
                                        behind = (behind2 = new BehindS(node13, maxLength, minLength));
                                        node13 = group3;
                                        maxLength = treeInfo.maxLength;
                                        minLength = treeInfo.minLength;
                                        BytecodeManager.incBytecodes(8);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final Node node14;
                                        final int maxLength2;
                                        final int minLength2;
                                        behind = (behind2 = new Behind(node14, maxLength2, minLength2));
                                        node14 = group3;
                                        maxLength2 = treeInfo.maxLength;
                                        minLength2 = treeInfo.minLength;
                                        BytecodeManager.incBytecodes(8);
                                    }
                                    root = behind2;
                                    body = behind;
                                    BytecodeManager.incBytecodes(4);
                                    break;
                                }
                                final int n12 = read;
                                final int n13 = 33;
                                BytecodeManager.incBytecodes(3);
                                if (n12 == n13) {
                                    final boolean b7 = supplementary;
                                    BytecodeManager.incBytecodes(2);
                                    NotBehind notBehind2;
                                    NotBehind notBehind;
                                    if (b7) {
                                        final Node node15;
                                        final int maxLength3;
                                        final int minLength3;
                                        notBehind = (notBehind2 = new NotBehindS(node15, maxLength3, minLength3));
                                        node15 = group3;
                                        maxLength3 = treeInfo.maxLength;
                                        minLength3 = treeInfo.minLength;
                                        BytecodeManager.incBytecodes(8);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final Node node16;
                                        final int maxLength4;
                                        final int minLength4;
                                        notBehind = (notBehind2 = new NotBehind(node16, maxLength4, minLength4));
                                        node16 = group3;
                                        maxLength4 = treeInfo.maxLength;
                                        minLength4 = treeInfo.minLength;
                                        BytecodeManager.incBytecodes(8);
                                    }
                                    root = notBehind2;
                                    body = notBehind;
                                    BytecodeManager.incBytecodes(4);
                                    break;
                                }
                                final String s2 = "Unknown look-behind group";
                                BytecodeManager.incBytecodes(3);
                                final PatternSyntaxException error2 = this.error(s2);
                                BytecodeManager.incBytecodes(1);
                                throw error2;
                            }
                        }
                        final int n14 = read;
                        BytecodeManager.incBytecodes(3);
                        final String groupname = this.groupname(n14);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final Map<String, Integer> namedGroups = this.namedGroups();
                        final String s3 = groupname;
                        BytecodeManager.incBytecodes(2);
                        final boolean containsKey = namedGroups.containsKey(s3);
                        BytecodeManager.incBytecodes(1);
                        if (containsKey) {
                            BytecodeManager.incBytecodes(4);
                            final StringBuilder sb = new StringBuilder();
                            final String str = "Named capturing group <";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb.append(str);
                            final String str2 = groupname;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append2 = append.append(str2);
                            final String str3 = "> is already defined";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = append2.append(str3);
                            BytecodeManager.incBytecodes(1);
                            final String string = append3.toString();
                            BytecodeManager.incBytecodes(1);
                            final PatternSyntaxException error3 = this.error(string);
                            BytecodeManager.incBytecodes(1);
                            throw error3;
                        }
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        final boolean b8 = false;
                        BytecodeManager.incBytecodes(3);
                        body = this.createGroup(b8);
                        BytecodeManager.incBytecodes(1);
                        root = this.root;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        final Map<String, Integer> namedGroups2 = this.namedGroups();
                        final String s4 = groupname;
                        final int i = this.capturingGroupCount - 1;
                        BytecodeManager.incBytecodes(6);
                        final Integer value = i;
                        BytecodeManager.incBytecodes(1);
                        namedGroups2.put(s4, value);
                        BytecodeManager.incBytecodes(1);
                        final Node node17 = body;
                        final Node node18 = root;
                        BytecodeManager.incBytecodes(4);
                        node17.next = this.expr(node18);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 36:
                    case 64: {
                        final String s5 = "Unknown group type";
                        BytecodeManager.incBytecodes(3);
                        final PatternSyntaxException error4 = this.error(s5);
                        BytecodeManager.incBytecodes(1);
                        throw error4;
                    }
                    default: {
                        BytecodeManager.incBytecodes(2);
                        this.unread();
                        BytecodeManager.incBytecodes(2);
                        this.addFlag();
                        BytecodeManager.incBytecodes(2);
                        final int read2 = this.read();
                        BytecodeManager.incBytecodes(1);
                        final int n15 = read2;
                        final int n16 = 41;
                        BytecodeManager.incBytecodes(3);
                        if (n15 == n16) {
                            final Node node19 = null;
                            BytecodeManager.incBytecodes(2);
                            return node19;
                        }
                        final int n17 = read2;
                        final int n18 = 58;
                        BytecodeManager.incBytecodes(3);
                        if (n17 != n18) {
                            final String s6 = "Unknown inline modifier";
                            BytecodeManager.incBytecodes(3);
                            final PatternSyntaxException error5 = this.error(s6);
                            BytecodeManager.incBytecodes(1);
                            throw error5;
                        }
                        final boolean b9 = true;
                        BytecodeManager.incBytecodes(3);
                        body = this.createGroup(b9);
                        BytecodeManager.incBytecodes(1);
                        root = this.root;
                        BytecodeManager.incBytecodes(3);
                        final Node node20 = body;
                        final Node node21 = root;
                        BytecodeManager.incBytecodes(4);
                        node20.next = this.expr(node21);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                }
            }
            else {
                b = true;
                BytecodeManager.incBytecodes(2);
                final boolean b10 = false;
                BytecodeManager.incBytecodes(3);
                body = this.createGroup(b10);
                BytecodeManager.incBytecodes(1);
                root = this.root;
                BytecodeManager.incBytecodes(3);
                final Node node22 = body;
                final Node node23 = root;
                BytecodeManager.incBytecodes(4);
                node22.next = this.expr(node23);
                BytecodeManager.incBytecodes(1);
            }
            final int n19 = 41;
            final String s7 = "Unclosed group";
            BytecodeManager.incBytecodes(4);
            this.accept(n19, s7);
            this.flags = flags;
            BytecodeManager.incBytecodes(3);
            final Node node24 = body;
            BytecodeManager.incBytecodes(3);
            final Node closure = this.closure(node24);
            BytecodeManager.incBytecodes(1);
            final Node node25 = closure;
            final Node node26 = body;
            BytecodeManager.incBytecodes(3);
            if (node25 == node26) {
                this.root = root;
                BytecodeManager.incBytecodes(3);
                final Node node27 = closure;
                BytecodeManager.incBytecodes(2);
                return node27;
            }
            final Node node28 = body;
            final Node node29 = root;
            BytecodeManager.incBytecodes(3);
            if (node28 == node29) {
                this.root = closure;
                BytecodeManager.incBytecodes(3);
                final Node node30 = closure;
                BytecodeManager.incBytecodes(2);
                return node30;
            }
            final boolean b11 = closure instanceof Ques;
            BytecodeManager.incBytecodes(3);
            if (b11) {
                final Ques ques = (Ques)closure;
                BytecodeManager.incBytecodes(3);
                final int type = ques.type;
                final int n20 = 2;
                BytecodeManager.incBytecodes(4);
                if (type == n20) {
                    this.root = closure;
                    BytecodeManager.incBytecodes(3);
                    final Ques ques2 = (Ques)closure;
                    BytecodeManager.incBytecodes(2);
                    return ques2;
                }
                final Node node31 = root;
                BytecodeManager.incBytecodes(4);
                node31.next = new BranchConn();
                BytecodeManager.incBytecodes(1);
                final Node next2 = root.next;
                BytecodeManager.incBytecodes(3);
                final int type2 = ques.type;
                BytecodeManager.incBytecodes(3);
                Branch branch;
                if (type2 == 0) {
                    final Node node32 = body;
                    final Node node33 = null;
                    final Node node34 = next2;
                    BytecodeManager.incBytecodes(6);
                    branch = new Branch(node32, node33, node34);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Node node35 = null;
                    final Node node36 = body;
                    final Node node37 = next2;
                    BytecodeManager.incBytecodes(6);
                    branch = new Branch(node35, node36, node37);
                    BytecodeManager.incBytecodes(1);
                }
                this.root = next2;
                BytecodeManager.incBytecodes(3);
                final Branch branch2 = branch;
                BytecodeManager.incBytecodes(2);
                return branch2;
            }
            else {
                final boolean b12 = closure instanceof Curly;
                BytecodeManager.incBytecodes(3);
                if (!b12) {
                    final String s8 = "Internal logic error";
                    BytecodeManager.incBytecodes(3);
                    final PatternSyntaxException error6 = this.error(s8);
                    BytecodeManager.incBytecodes(1);
                    throw error6;
                }
                final Curly curly = (Curly)closure;
                BytecodeManager.incBytecodes(3);
                final int type3 = curly.type;
                final int n21 = 2;
                BytecodeManager.incBytecodes(4);
                if (type3 == n21) {
                    this.root = closure;
                    BytecodeManager.incBytecodes(3);
                    final Curly curly2 = (Curly)closure;
                    BytecodeManager.incBytecodes(2);
                    return curly2;
                }
                BytecodeManager.incBytecodes(3);
                final TreeInfo treeInfo3 = new TreeInfo();
                BytecodeManager.incBytecodes(1);
                final Node node38 = body;
                final TreeInfo treeInfo4 = treeInfo3;
                BytecodeManager.incBytecodes(3);
                final boolean study = node38.study(treeInfo4);
                BytecodeManager.incBytecodes(1);
                if (study) {
                    final GroupTail groupTail = (GroupTail)root;
                    BytecodeManager.incBytecodes(3);
                    final Node next3 = body.next;
                    final int cmin = curly.cmin;
                    final int cmax = curly.cmax;
                    final int type4 = curly.type;
                    final int localIndex = ((GroupTail)root).localIndex;
                    final int groupIndex = ((GroupTail)root).groupIndex;
                    final boolean b13 = b;
                    BytecodeManager.incBytecodes(19);
                    final GroupCurly root5 = new GroupCurly(next3, cmin, cmax, type4, localIndex, groupIndex, b13);
                    this.root = root5;
                    final GroupCurly groupCurly = root5;
                    BytecodeManager.incBytecodes(3);
                    final GroupCurly groupCurly2 = groupCurly;
                    BytecodeManager.incBytecodes(2);
                    return groupCurly2;
                }
                final int localIndex2 = ((GroupHead)body).localIndex;
                BytecodeManager.incBytecodes(4);
                final int type5 = curly.type;
                BytecodeManager.incBytecodes(3);
                Loop loop;
                if (type5 == 0) {
                    final int localCount = this.localCount;
                    final int n22 = localIndex2;
                    BytecodeManager.incBytecodes(6);
                    loop = new Loop(localCount, n22);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int localCount2 = this.localCount;
                    final int n23 = localIndex2;
                    BytecodeManager.incBytecodes(6);
                    loop = new LazyLoop(localCount2, n23);
                    BytecodeManager.incBytecodes(1);
                }
                final Loop loop2 = loop;
                BytecodeManager.incBytecodes(4);
                final Prolog prolog = new Prolog(loop2);
                BytecodeManager.incBytecodes(1);
                ++this.localCount;
                BytecodeManager.incBytecodes(6);
                loop.cmin = curly.cmin;
                BytecodeManager.incBytecodes(4);
                loop.cmax = curly.cmax;
                BytecodeManager.incBytecodes(4);
                loop.body = body;
                BytecodeManager.incBytecodes(3);
                root.next = loop;
                BytecodeManager.incBytecodes(3);
                this.root = loop;
                BytecodeManager.incBytecodes(3);
                final Prolog prolog2 = prolog;
                BytecodeManager.incBytecodes(2);
                return prolog2;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node createGroup(final boolean b) {
        try {
            final int n = this.localCount++;
            BytecodeManager.incBytecodes(8);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (!b) {
                n2 = this.capturingGroupCount++;
                BytecodeManager.incBytecodes(8);
            }
            final int n3 = n;
            BytecodeManager.incBytecodes(4);
            final GroupHead groupHead = new GroupHead(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = n;
            final int n5 = n2;
            BytecodeManager.incBytecodes(6);
            this.root = new GroupTail(n4, n5);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (!b) {
                final int n6 = n2;
                final int n7 = 10;
                BytecodeManager.incBytecodes(3);
                if (n6 < n7) {
                    this.groupNodes[n2] = groupHead;
                    BytecodeManager.incBytecodes(5);
                }
            }
            final GroupHead groupHead2 = groupHead;
            BytecodeManager.incBytecodes(2);
            return groupHead2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void addFlag() {
        try {
            BytecodeManager.incBytecodes(2);
            int n = this.peek();
            BytecodeManager.incBytecodes(1);
        Label_0327:
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                switch (n2) {
                    case 105: {
                        this.flags |= 0x2;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 109: {
                        this.flags |= 0x8;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 115: {
                        this.flags |= 0x20;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 100: {
                        this.flags |= 0x1;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 117: {
                        this.flags |= 0x40;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 99: {
                        this.flags |= 0x80;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 120: {
                        this.flags |= 0x4;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 85: {
                        this.flags |= 0x140;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 45: {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        this.subFlag();
                    }
                    default: {
                        break Label_0327;
                    }
                }
                BytecodeManager.incBytecodes(2);
                n = this.next();
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void subFlag() {
        try {
            BytecodeManager.incBytecodes(2);
            int n = this.peek();
            BytecodeManager.incBytecodes(1);
        Label_0290:
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                switch (n2) {
                    case 105: {
                        this.flags &= 0xFFFFFFFD;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 109: {
                        this.flags &= 0xFFFFFFF7;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 115: {
                        this.flags &= 0xFFFFFFDF;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 100: {
                        this.flags &= 0xFFFFFFFE;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 117: {
                        this.flags &= 0xFFFFFFBF;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 99: {
                        this.flags &= 0xFFFFFF7F;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 120: {
                        this.flags &= 0xFFFFFFFB;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 85: {
                        this.flags &= 0xFFFFFEBF;
                        BytecodeManager.incBytecodes(6);
                    }
                    default: {
                        break Label_0290;
                    }
                }
                BytecodeManager.incBytecodes(2);
                n = this.next();
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node closure(final Node node) {
        try {
            BytecodeManager.incBytecodes(2);
            final int peek = this.peek();
            BytecodeManager.incBytecodes(1);
            final int n = peek;
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 63: {
                    BytecodeManager.incBytecodes(2);
                    final int next = this.next();
                    BytecodeManager.incBytecodes(1);
                    final int n2 = next;
                    final int n3 = 63;
                    BytecodeManager.incBytecodes(3);
                    if (n2 == n3) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n4 = 1;
                        BytecodeManager.incBytecodes(5);
                        final Ques ques = new Ques(node, n4);
                        BytecodeManager.incBytecodes(1);
                        return ques;
                    }
                    final int n5 = next;
                    final int n6 = 43;
                    BytecodeManager.incBytecodes(3);
                    if (n5 == n6) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n7 = 2;
                        BytecodeManager.incBytecodes(5);
                        final Ques ques2 = new Ques(node, n7);
                        BytecodeManager.incBytecodes(1);
                        return ques2;
                    }
                    final int n8 = 0;
                    BytecodeManager.incBytecodes(5);
                    final Ques ques3 = new Ques(node, n8);
                    BytecodeManager.incBytecodes(1);
                    return ques3;
                }
                case 42: {
                    BytecodeManager.incBytecodes(2);
                    final int next2 = this.next();
                    BytecodeManager.incBytecodes(1);
                    final int n9 = next2;
                    final int n10 = 63;
                    BytecodeManager.incBytecodes(3);
                    if (n9 == n10) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n11 = 0;
                        final int n12 = Integer.MAX_VALUE;
                        final int n13 = 1;
                        BytecodeManager.incBytecodes(7);
                        final Curly curly = new Curly(node, n11, n12, n13);
                        BytecodeManager.incBytecodes(1);
                        return curly;
                    }
                    final int n14 = next2;
                    final int n15 = 43;
                    BytecodeManager.incBytecodes(3);
                    if (n14 == n15) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n16 = 0;
                        final int n17 = Integer.MAX_VALUE;
                        final int n18 = 2;
                        BytecodeManager.incBytecodes(7);
                        final Curly curly2 = new Curly(node, n16, n17, n18);
                        BytecodeManager.incBytecodes(1);
                        return curly2;
                    }
                    final int n19 = 0;
                    final int n20 = Integer.MAX_VALUE;
                    final int n21 = 0;
                    BytecodeManager.incBytecodes(7);
                    final Curly curly3 = new Curly(node, n19, n20, n21);
                    BytecodeManager.incBytecodes(1);
                    return curly3;
                }
                case 43: {
                    BytecodeManager.incBytecodes(2);
                    final int next3 = this.next();
                    BytecodeManager.incBytecodes(1);
                    final int n22 = next3;
                    final int n23 = 63;
                    BytecodeManager.incBytecodes(3);
                    if (n22 == n23) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n24 = 1;
                        final int n25 = Integer.MAX_VALUE;
                        final int n26 = 1;
                        BytecodeManager.incBytecodes(7);
                        final Curly curly4 = new Curly(node, n24, n25, n26);
                        BytecodeManager.incBytecodes(1);
                        return curly4;
                    }
                    final int n27 = next3;
                    final int n28 = 43;
                    BytecodeManager.incBytecodes(3);
                    if (n27 == n28) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n29 = 1;
                        final int n30 = Integer.MAX_VALUE;
                        final int n31 = 2;
                        BytecodeManager.incBytecodes(7);
                        final Curly curly5 = new Curly(node, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        return curly5;
                    }
                    final int n32 = 1;
                    final int n33 = Integer.MAX_VALUE;
                    final int n34 = 0;
                    BytecodeManager.incBytecodes(7);
                    final Curly curly6 = new Curly(node, n32, n33, n34);
                    BytecodeManager.incBytecodes(1);
                    return curly6;
                }
                case 123: {
                    int n35 = this.temp[this.cursor + 1];
                    BytecodeManager.incBytecodes(8);
                    final int n36 = n35;
                    BytecodeManager.incBytecodes(2);
                    final boolean digit = ASCII.isDigit(n36);
                    BytecodeManager.incBytecodes(1);
                    if (!digit) {
                        final String s = "Illegal repetition";
                        BytecodeManager.incBytecodes(3);
                        final PatternSyntaxException error = this.error(s);
                        BytecodeManager.incBytecodes(1);
                        throw error;
                    }
                    BytecodeManager.incBytecodes(2);
                    this.skip();
                    BytecodeManager.incBytecodes(1);
                    int n37 = 0;
                    BytecodeManager.incBytecodes(2);
                    boolean digit2;
                    do {
                        n37 = n37 * 10 + (n35 - 48);
                        BytecodeManager.incBytecodes(8);
                        BytecodeManager.incBytecodes(2);
                        final int n38 = n35 = this.read();
                        BytecodeManager.incBytecodes(3);
                        digit2 = ASCII.isDigit(n38);
                        BytecodeManager.incBytecodes(1);
                    } while (digit2);
                    int n39 = n37;
                    BytecodeManager.incBytecodes(2);
                    final int n40 = n35;
                    final int n41 = 44;
                    BytecodeManager.incBytecodes(3);
                    if (n40 == n41) {
                        BytecodeManager.incBytecodes(2);
                        n35 = this.read();
                        BytecodeManager.incBytecodes(1);
                        n39 = Integer.MAX_VALUE;
                        BytecodeManager.incBytecodes(2);
                        final int n42 = n35;
                        final int n43 = 125;
                        BytecodeManager.incBytecodes(3);
                        if (n42 != n43) {
                            n39 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n44 = n35;
                                BytecodeManager.incBytecodes(2);
                                final boolean digit3 = ASCII.isDigit(n44);
                                BytecodeManager.incBytecodes(1);
                                if (!digit3) {
                                    break;
                                }
                                n39 = n39 * 10 + (n35 - 48);
                                BytecodeManager.incBytecodes(8);
                                BytecodeManager.incBytecodes(2);
                                n35 = this.read();
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                    final int n45 = n35;
                    final int n46 = 125;
                    BytecodeManager.incBytecodes(3);
                    if (n45 != n46) {
                        final String s2 = "Unclosed counted closure";
                        BytecodeManager.incBytecodes(3);
                        final PatternSyntaxException error2 = this.error(s2);
                        BytecodeManager.incBytecodes(1);
                        throw error2;
                    }
                    final int n47 = n37 | n39 | n39 - n37;
                    BytecodeManager.incBytecodes(8);
                    if (n47 < 0) {
                        final String s3 = "Illegal repetition range";
                        BytecodeManager.incBytecodes(3);
                        final PatternSyntaxException error3 = this.error(s3);
                        BytecodeManager.incBytecodes(1);
                        throw error3;
                    }
                    BytecodeManager.incBytecodes(2);
                    final int peek2 = this.peek();
                    BytecodeManager.incBytecodes(1);
                    final int n48 = peek2;
                    final int n49 = 63;
                    BytecodeManager.incBytecodes(3);
                    Curly curly7;
                    if (n48 == n49) {
                        BytecodeManager.incBytecodes(2);
                        this.next();
                        BytecodeManager.incBytecodes(1);
                        final int n50 = n37;
                        final int n51 = n39;
                        final int n52 = 1;
                        BytecodeManager.incBytecodes(7);
                        curly7 = new Curly(node, n50, n51, n52);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int n53 = peek2;
                        final int n54 = 43;
                        BytecodeManager.incBytecodes(3);
                        if (n53 == n54) {
                            BytecodeManager.incBytecodes(2);
                            this.next();
                            BytecodeManager.incBytecodes(1);
                            final int n55 = n37;
                            final int n56 = n39;
                            final int n57 = 2;
                            BytecodeManager.incBytecodes(7);
                            curly7 = new Curly(node, n55, n56, n57);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n58 = n37;
                            final int n59 = n39;
                            final int n60 = 0;
                            BytecodeManager.incBytecodes(7);
                            curly7 = new Curly(node, n58, n59, n60);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final Curly curly8 = curly7;
                    BytecodeManager.incBytecodes(2);
                    return curly8;
                }
                default: {
                    BytecodeManager.incBytecodes(2);
                    return node;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int c() {
        try {
            final int cursor = this.cursor;
            final int patternLength = this.patternLength;
            BytecodeManager.incBytecodes(5);
            if (cursor < patternLength) {
                BytecodeManager.incBytecodes(2);
                final int n = this.read() ^ 0x40;
                BytecodeManager.incBytecodes(3);
                return n;
            }
            final String s = "Illegal control escape sequence";
            BytecodeManager.incBytecodes(3);
            final PatternSyntaxException error = this.error(s);
            BytecodeManager.incBytecodes(1);
            throw error;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int o() {
        try {
            BytecodeManager.incBytecodes(2);
            final int read = this.read();
            BytecodeManager.incBytecodes(1);
            final int n = read - 48 | 55 - read;
            BytecodeManager.incBytecodes(8);
            if (n < 0) {
                final String s = "Illegal octal escape sequence";
                BytecodeManager.incBytecodes(3);
                final PatternSyntaxException error = this.error(s);
                BytecodeManager.incBytecodes(1);
                throw error;
            }
            BytecodeManager.incBytecodes(2);
            final int read2 = this.read();
            BytecodeManager.incBytecodes(1);
            final int n2 = read2 - 48 | 55 - read2;
            BytecodeManager.incBytecodes(8);
            if (n2 >= 0) {
                BytecodeManager.incBytecodes(2);
                final int read3 = this.read();
                BytecodeManager.incBytecodes(1);
                final int n3 = read3 - 48 | 55 - read3;
                BytecodeManager.incBytecodes(8);
                if (n3 >= 0) {
                    final int n4 = read - 48 | 51 - read;
                    BytecodeManager.incBytecodes(8);
                    if (n4 >= 0) {
                        final int n5 = (read - 48) * 64 + (read2 - 48) * 8 + (read3 - 48);
                        BytecodeManager.incBytecodes(16);
                        return n5;
                    }
                }
                BytecodeManager.incBytecodes(2);
                this.unread();
                final int n6 = (read - 48) * 8 + (read2 - 48);
                BytecodeManager.incBytecodes(10);
                return n6;
            }
            BytecodeManager.incBytecodes(2);
            this.unread();
            final int n7 = read - 48;
            BytecodeManager.incBytecodes(4);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int x() {
        try {
            BytecodeManager.incBytecodes(2);
            final int read = this.read();
            BytecodeManager.incBytecodes(1);
            final int n = read;
            BytecodeManager.incBytecodes(2);
            final boolean hexDigit = ASCII.isHexDigit(n);
            BytecodeManager.incBytecodes(1);
            if (hexDigit) {
                BytecodeManager.incBytecodes(2);
                final int read2 = this.read();
                BytecodeManager.incBytecodes(1);
                final int n2 = read2;
                BytecodeManager.incBytecodes(2);
                final boolean hexDigit2 = ASCII.isHexDigit(n2);
                BytecodeManager.incBytecodes(1);
                if (hexDigit2) {
                    final int n3 = read;
                    BytecodeManager.incBytecodes(2);
                    final int n4 = ASCII.toDigit(n3) * 16;
                    final int n5 = read2;
                    BytecodeManager.incBytecodes(4);
                    final int n6 = n4 + ASCII.toDigit(n5);
                    BytecodeManager.incBytecodes(2);
                    return n6;
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n7 = read;
                final int n8 = 123;
                BytecodeManager.incBytecodes(3);
                if (n7 == n8) {
                    BytecodeManager.incBytecodes(2);
                    final int peek = this.peek();
                    BytecodeManager.incBytecodes(1);
                    final boolean hexDigit3 = ASCII.isHexDigit(peek);
                    BytecodeManager.incBytecodes(1);
                    if (hexDigit3) {
                        int n9 = 0;
                        BytecodeManager.incBytecodes(2);
                        int i;
                        int n10;
                        do {
                            BytecodeManager.incBytecodes(2);
                            final int read3;
                            final int n11 = read3 = this.read();
                            BytecodeManager.incBytecodes(3);
                            final boolean hexDigit4 = ASCII.isHexDigit(n11);
                            BytecodeManager.incBytecodes(1);
                            if (hexDigit4) {
                                final int n12 = n9 << 4;
                                final int n13 = read3;
                                BytecodeManager.incBytecodes(5);
                                n9 = n12 + ASCII.toDigit(n13);
                                BytecodeManager.incBytecodes(2);
                                i = n9;
                                n10 = 1114111;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final int n14 = read3;
                                final int n15 = 125;
                                BytecodeManager.incBytecodes(3);
                                if (n14 != n15) {
                                    final String s = "Unclosed hexadecimal escape sequence";
                                    BytecodeManager.incBytecodes(3);
                                    final PatternSyntaxException error = this.error(s);
                                    BytecodeManager.incBytecodes(1);
                                    throw error;
                                }
                                final int n16 = n9;
                                BytecodeManager.incBytecodes(2);
                                return n16;
                            }
                        } while (i <= n10);
                        final String s2 = "Hexadecimal codepoint is too big";
                        BytecodeManager.incBytecodes(3);
                        final PatternSyntaxException error2 = this.error(s2);
                        BytecodeManager.incBytecodes(1);
                        throw error2;
                    }
                }
            }
            final String s3 = "Illegal hexadecimal escape sequence";
            BytecodeManager.incBytecodes(3);
            final PatternSyntaxException error3 = this.error(s3);
            BytecodeManager.incBytecodes(1);
            throw error3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int cursor() {
        try {
            final int cursor = this.cursor;
            BytecodeManager.incBytecodes(3);
            return cursor;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void setcursor(final int cursor) {
        try {
            this.cursor = cursor;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int uxxxx() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = 4;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    final int n5 = n;
                    BytecodeManager.incBytecodes(2);
                    return n5;
                }
                BytecodeManager.incBytecodes(2);
                final int read = this.read();
                BytecodeManager.incBytecodes(1);
                final int n6 = read;
                BytecodeManager.incBytecodes(2);
                final boolean hexDigit = ASCII.isHexDigit(n6);
                BytecodeManager.incBytecodes(1);
                if (!hexDigit) {
                    final String s = "Illegal Unicode escape sequence";
                    BytecodeManager.incBytecodes(3);
                    final PatternSyntaxException error = this.error(s);
                    BytecodeManager.incBytecodes(1);
                    throw error;
                }
                final int n7 = n * 16;
                final int n8 = read;
                BytecodeManager.incBytecodes(5);
                n = n7 + ASCII.toDigit(n8);
                BytecodeManager.incBytecodes(2);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int u() {
        try {
            BytecodeManager.incBytecodes(2);
            final int uxxxx = this.uxxxx();
            BytecodeManager.incBytecodes(1);
            final char ch = (char)uxxxx;
            BytecodeManager.incBytecodes(3);
            final boolean highSurrogate = Character.isHighSurrogate(ch);
            BytecodeManager.incBytecodes(1);
            if (highSurrogate) {
                BytecodeManager.incBytecodes(2);
                final int cursor = this.cursor();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final int read = this.read();
                final int n = 92;
                BytecodeManager.incBytecodes(2);
                if (read == n) {
                    BytecodeManager.incBytecodes(2);
                    final int read2 = this.read();
                    final int n2 = 117;
                    BytecodeManager.incBytecodes(2);
                    if (read2 == n2) {
                        BytecodeManager.incBytecodes(2);
                        final int uxxxx2 = this.uxxxx();
                        BytecodeManager.incBytecodes(1);
                        final char ch2 = (char)uxxxx2;
                        BytecodeManager.incBytecodes(3);
                        final boolean lowSurrogate = Character.isLowSurrogate(ch2);
                        BytecodeManager.incBytecodes(1);
                        if (lowSurrogate) {
                            final char high = (char)uxxxx;
                            final char low = (char)uxxxx2;
                            BytecodeManager.incBytecodes(5);
                            final int codePoint = Character.toCodePoint(high, low);
                            BytecodeManager.incBytecodes(1);
                            return codePoint;
                        }
                    }
                }
                final int n3 = cursor;
                BytecodeManager.incBytecodes(3);
                this.setcursor(n3);
            }
            final int n4 = uxxxx;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final int countChars(final CharSequence charSequence, final int n, final int n2) {
        try {
            final int n3 = 1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                BytecodeManager.incBytecodes(3);
                final char char1 = charSequence.charAt(n);
                BytecodeManager.incBytecodes(1);
                final boolean highSurrogate = Character.isHighSurrogate(char1);
                BytecodeManager.incBytecodes(1);
                if (!highSurrogate) {
                    final boolean $assertionsDisabled = Pattern.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    Label_0100: {
                        if (!$assertionsDisabled) {
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                BytecodeManager.incBytecodes(3);
                                final int length = charSequence.length();
                                BytecodeManager.incBytecodes(1);
                                if (n < length) {
                                    break Label_0100;
                                }
                            }
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                    }
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(2);
                    return n4;
                }
            }
            BytecodeManager.incBytecodes(2);
            final int length2 = charSequence.length();
            BytecodeManager.incBytecodes(1);
            int n5 = n;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (n2 >= 0) {
                final boolean $assertionsDisabled2 = Pattern.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                Label_0191: {
                    if (!$assertionsDisabled2) {
                        BytecodeManager.incBytecodes(2);
                        if (n >= 0) {
                            final int n6 = length2;
                            BytecodeManager.incBytecodes(3);
                            if (n < n6) {
                                break Label_0191;
                            }
                        }
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError2 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError2;
                    }
                }
                int n7 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n8 = n5;
                    final int n9 = length2;
                    BytecodeManager.incBytecodes(3);
                    if (n8 >= n9) {
                        break;
                    }
                    final int n10 = n7;
                    BytecodeManager.incBytecodes(3);
                    if (n10 >= n2) {
                        break;
                    }
                    final int n11 = n5++;
                    BytecodeManager.incBytecodes(4);
                    final char char2 = charSequence.charAt(n11);
                    BytecodeManager.incBytecodes(1);
                    final boolean highSurrogate2 = Character.isHighSurrogate(char2);
                    BytecodeManager.incBytecodes(1);
                    if (highSurrogate2) {
                        final int n12 = n5;
                        final int n13 = length2;
                        BytecodeManager.incBytecodes(3);
                        if (n12 < n13) {
                            final int n14 = n5;
                            BytecodeManager.incBytecodes(3);
                            final char char3 = charSequence.charAt(n14);
                            BytecodeManager.incBytecodes(1);
                            final boolean lowSurrogate = Character.isLowSurrogate(char3);
                            BytecodeManager.incBytecodes(1);
                            if (lowSurrogate) {
                                ++n5;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                    ++n7;
                    BytecodeManager.incBytecodes(2);
                }
                final int n15 = n5 - n;
                BytecodeManager.incBytecodes(4);
                return n15;
            }
            final boolean $assertionsDisabled3 = Pattern.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0376: {
                if (!$assertionsDisabled3) {
                    BytecodeManager.incBytecodes(2);
                    if (n >= 0) {
                        final int n16 = length2;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n16) {
                            break Label_0376;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError3 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError3;
                }
            }
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final int n17 = 0;
                BytecodeManager.incBytecodes(2);
                return n17;
            }
            final int n18 = -n2;
            BytecodeManager.incBytecodes(3);
            int n19 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n20 = n5;
                BytecodeManager.incBytecodes(2);
                if (n20 <= 0) {
                    break;
                }
                final int n21 = n19;
                final int n22 = n18;
                BytecodeManager.incBytecodes(3);
                if (n21 >= n22) {
                    break;
                }
                final int n23 = --n5;
                BytecodeManager.incBytecodes(4);
                final char char4 = charSequence.charAt(n23);
                BytecodeManager.incBytecodes(1);
                final boolean lowSurrogate2 = Character.isLowSurrogate(char4);
                BytecodeManager.incBytecodes(1);
                if (lowSurrogate2) {
                    final int n24 = n5;
                    BytecodeManager.incBytecodes(2);
                    if (n24 > 0) {
                        final int n25 = n5 - 1;
                        BytecodeManager.incBytecodes(5);
                        final char char5 = charSequence.charAt(n25);
                        BytecodeManager.incBytecodes(1);
                        final boolean highSurrogate3 = Character.isHighSurrogate(char5);
                        BytecodeManager.incBytecodes(1);
                        if (highSurrogate3) {
                            --n5;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                ++n19;
                BytecodeManager.incBytecodes(2);
            }
            final int n26 = n - n5;
            BytecodeManager.incBytecodes(4);
            return n26;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final int countCodePoints(final CharSequence charSequence) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = charSequence.length();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                final int n5 = n2++;
                BytecodeManager.incBytecodes(4);
                final char char1 = charSequence.charAt(n5);
                BytecodeManager.incBytecodes(1);
                final boolean highSurrogate = Character.isHighSurrogate(char1);
                BytecodeManager.incBytecodes(1);
                if (!highSurrogate) {
                    continue;
                }
                final int n6 = n2;
                final int n7 = length;
                BytecodeManager.incBytecodes(3);
                if (n6 >= n7) {
                    continue;
                }
                final int n8 = n2;
                BytecodeManager.incBytecodes(3);
                final char char2 = charSequence.charAt(n8);
                BytecodeManager.incBytecodes(1);
                final boolean lowSurrogate = Character.isLowSurrogate(char2);
                BytecodeManager.incBytecodes(1);
                if (!lowSurrogate) {
                    continue;
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n9 = n;
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharProperty newSingle(final int codePoint) {
        try {
            final int n = 2;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n);
            BytecodeManager.incBytecodes(1);
            if (has) {
                final int n2 = 64;
                BytecodeManager.incBytecodes(3);
                final boolean has2 = this.has(n2);
                BytecodeManager.incBytecodes(1);
                if (has2) {
                    BytecodeManager.incBytecodes(2);
                    final int upperCase = Character.toUpperCase(codePoint);
                    BytecodeManager.incBytecodes(1);
                    final int codePoint2 = upperCase;
                    BytecodeManager.incBytecodes(2);
                    final int lowerCase = Character.toLowerCase(codePoint2);
                    BytecodeManager.incBytecodes(1);
                    final int n3 = upperCase;
                    final int n4 = lowerCase;
                    BytecodeManager.incBytecodes(3);
                    if (n3 != n4) {
                        final int n5 = lowerCase;
                        BytecodeManager.incBytecodes(4);
                        final SingleU singleU = new SingleU(n5);
                        BytecodeManager.incBytecodes(1);
                        return singleU;
                    }
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    final boolean ascii = ASCII.isAscii(codePoint);
                    BytecodeManager.incBytecodes(1);
                    if (ascii) {
                        BytecodeManager.incBytecodes(2);
                        final int lower = ASCII.toLower(codePoint);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final int upper = ASCII.toUpper(codePoint);
                        BytecodeManager.incBytecodes(1);
                        final int n6 = lower;
                        final int n7 = upper;
                        BytecodeManager.incBytecodes(3);
                        if (n6 != n7) {
                            final int n8 = lower;
                            final int n9 = upper;
                            BytecodeManager.incBytecodes(5);
                            final SingleI singleI = new SingleI(n8, n9);
                            BytecodeManager.incBytecodes(1);
                            return singleI;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            final boolean supplementary = isSupplementary(codePoint);
            BytecodeManager.incBytecodes(1);
            if (supplementary) {
                BytecodeManager.incBytecodes(4);
                final SingleS singleS = new SingleS(codePoint);
                BytecodeManager.incBytecodes(1);
                return singleS;
            }
            BytecodeManager.incBytecodes(4);
            final Single single = new Single(codePoint);
            BytecodeManager.incBytecodes(1);
            return single;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node newSlice(final int[] array, final int n, final boolean b) {
        try {
            final int[] array2 = new int[n];
            BytecodeManager.incBytecodes(2);
            final int n2 = 2;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n2);
            BytecodeManager.incBytecodes(1);
            if (!has) {
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n) {
                        break;
                    }
                    array2[n3] = array[n3];
                    BytecodeManager.incBytecodes(6);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(2);
                SliceNode sliceNode;
                if (b) {
                    final int[] array3;
                    sliceNode = new SliceS(array3);
                    array3 = array2;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int[] array4;
                    sliceNode = new Slice(array4);
                    array4 = array2;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
                return sliceNode;
            }
            final int n5 = 64;
            BytecodeManager.incBytecodes(3);
            final boolean has2 = this.has(n5);
            BytecodeManager.incBytecodes(1);
            if (has2) {
                int n6 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n) {
                        break;
                    }
                    final int[] array5 = array2;
                    final int n8 = n6;
                    final int codePoint = array[n6];
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int upperCase = Character.toUpperCase(codePoint);
                    BytecodeManager.incBytecodes(1);
                    array5[n8] = Character.toLowerCase(upperCase);
                    BytecodeManager.incBytecodes(1);
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(2);
                SliceNode sliceNode2;
                if (b) {
                    final int[] array6;
                    sliceNode2 = new SliceUS(array6);
                    array6 = array2;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int[] array7;
                    sliceNode2 = new SliceU(array7);
                    array7 = array2;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
                return sliceNode2;
            }
            int n9 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n) {
                    break;
                }
                final int[] array8 = array2;
                final int n11 = n9;
                final int n12 = array[n9];
                BytecodeManager.incBytecodes(6);
                array8[n11] = ASCII.toLower(n12);
                BytecodeManager.incBytecodes(1);
                ++n9;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            SliceNode sliceNode3;
            if (b) {
                final int[] array9;
                sliceNode3 = new SliceIS(array9);
                array9 = array2;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int[] array10;
                sliceNode3 = new SliceI(array10);
                array10 = array2;
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
            return sliceNode3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean inRange(final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0037: {
                if (n <= n2) {
                    BytecodeManager.incBytecodes(3);
                    if (n2 <= n3) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0037;
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
    
    private static CharProperty rangeFor(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(5);
            final CharProperty charProperty = new CharProperty() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                boolean isSatisfiedBy(final int n) {
                    try {
                        final int val$lower = n;
                        final int val$upper = n2;
                        BytecodeManager.incBytecodes(6);
                        final boolean access$200 = Pattern.access$200(val$lower, n, val$upper);
                        BytecodeManager.incBytecodes(1);
                        return access$200;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return charProperty;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharProperty caseInsensitiveRangeFor(final int n, final int n2) {
        try {
            final int n3 = 64;
            BytecodeManager.incBytecodes(3);
            final boolean has = this.has(n3);
            BytecodeManager.incBytecodes(1);
            if (has) {
                BytecodeManager.incBytecodes(6);
                final CharProperty charProperty = new CharProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            final int val$lower = n;
                            final int val$upper = n2;
                            BytecodeManager.incBytecodes(6);
                            final boolean access$200 = Pattern.access$200(val$lower, codePoint, val$upper);
                            BytecodeManager.incBytecodes(1);
                            if (access$200) {
                                final boolean b = true;
                                BytecodeManager.incBytecodes(2);
                                return b;
                            }
                            BytecodeManager.incBytecodes(2);
                            final int upperCase = Character.toUpperCase(codePoint);
                            BytecodeManager.incBytecodes(1);
                            final int val$lower2 = n;
                            final int n = upperCase;
                            final int val$upper2 = n2;
                            BytecodeManager.incBytecodes(6);
                            final boolean access$201 = Pattern.access$200(val$lower2, n, val$upper2);
                            BytecodeManager.incBytecodes(1);
                            boolean b2 = false;
                            Label_0125: {
                                if (!access$201) {
                                    final int val$lower3 = n;
                                    final int codePoint2 = upperCase;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    final int lowerCase = Character.toLowerCase(codePoint2);
                                    final int val$upper3 = n2;
                                    BytecodeManager.incBytecodes(3);
                                    final boolean access$202 = Pattern.access$200(val$lower3, lowerCase, val$upper3);
                                    BytecodeManager.incBytecodes(1);
                                    if (!access$202) {
                                        b2 = false;
                                        BytecodeManager.incBytecodes(1);
                                        break Label_0125;
                                    }
                                }
                                b2 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            BytecodeManager.incBytecodes(1);
                            return b2;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                return charProperty;
            }
            BytecodeManager.incBytecodes(6);
            final CharProperty charProperty2 = new CharProperty() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                boolean isSatisfiedBy(final int n) {
                    try {
                        final int val$lower = n;
                        final int val$upper = n2;
                        BytecodeManager.incBytecodes(6);
                        final boolean access$200 = Pattern.access$200(val$lower, n, val$upper);
                        BytecodeManager.incBytecodes(1);
                        boolean b = false;
                        Label_0138: {
                            Label_0123: {
                                if (!access$200) {
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean ascii = ASCII.isAscii(n);
                                    BytecodeManager.incBytecodes(1);
                                    if (ascii) {
                                        final int val$lower2 = n;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        final int upper = ASCII.toUpper(n);
                                        final int val$upper2 = n2;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean access$201 = Pattern.access$200(val$lower2, upper, val$upper2);
                                        BytecodeManager.incBytecodes(1);
                                        if (access$201) {
                                            break Label_0123;
                                        }
                                        final int val$lower3 = n;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        final int lower = ASCII.toLower(n);
                                        final int val$upper3 = n2;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean access$202 = Pattern.access$200(val$lower3, lower, val$upper3);
                                        BytecodeManager.incBytecodes(1);
                                        if (access$202) {
                                            break Label_0123;
                                        }
                                    }
                                    b = false;
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0138;
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
            };
            BytecodeManager.incBytecodes(1);
            return charProperty2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static CharProperty union(final CharProperty charProperty, final CharProperty charProperty2) {
        try {
            BytecodeManager.incBytecodes(5);
            final CharProperty charProperty3 = new CharProperty() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                boolean isSatisfiedBy(final int n) {
                    try {
                        final CharProperty val$lhs = charProperty;
                        BytecodeManager.incBytecodes(4);
                        final boolean satisfiedBy = val$lhs.isSatisfiedBy(n);
                        BytecodeManager.incBytecodes(1);
                        boolean b = false;
                        Label_0057: {
                            if (!satisfiedBy) {
                                final CharProperty val$rhs = charProperty2;
                                BytecodeManager.incBytecodes(4);
                                final boolean satisfiedBy2 = val$rhs.isSatisfiedBy(n);
                                BytecodeManager.incBytecodes(1);
                                if (!satisfiedBy2) {
                                    b = false;
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0057;
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
            };
            BytecodeManager.incBytecodes(1);
            return charProperty3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static CharProperty intersection(final CharProperty charProperty, final CharProperty charProperty2) {
        try {
            BytecodeManager.incBytecodes(5);
            final CharProperty charProperty3 = new CharProperty() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                boolean isSatisfiedBy(final int n) {
                    try {
                        final CharProperty val$lhs = charProperty;
                        BytecodeManager.incBytecodes(4);
                        final boolean satisfiedBy = val$lhs.isSatisfiedBy(n);
                        BytecodeManager.incBytecodes(1);
                        boolean b = false;
                        Label_0057: {
                            if (satisfiedBy) {
                                final CharProperty val$rhs = charProperty2;
                                BytecodeManager.incBytecodes(4);
                                final boolean satisfiedBy2 = val$rhs.isSatisfiedBy(n);
                                BytecodeManager.incBytecodes(1);
                                if (satisfiedBy2) {
                                    b = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0057;
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
            };
            BytecodeManager.incBytecodes(1);
            return charProperty3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static CharProperty setDifference(final CharProperty charProperty, final CharProperty charProperty2) {
        try {
            BytecodeManager.incBytecodes(5);
            final CharProperty charProperty3 = new CharProperty() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                boolean isSatisfiedBy(final int n) {
                    try {
                        final CharProperty val$rhs = charProperty2;
                        BytecodeManager.incBytecodes(4);
                        final boolean satisfiedBy = val$rhs.isSatisfiedBy(n);
                        BytecodeManager.incBytecodes(1);
                        boolean b = false;
                        Label_0057: {
                            if (!satisfiedBy) {
                                final CharProperty val$lhs = charProperty;
                                BytecodeManager.incBytecodes(4);
                                final boolean satisfiedBy2 = val$lhs.isSatisfiedBy(n);
                                BytecodeManager.incBytecodes(1);
                                if (satisfiedBy2) {
                                    b = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0057;
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
            };
            BytecodeManager.incBytecodes(1);
            return charProperty3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean hasBaseCharacter(final Matcher matcher, final int n, final CharSequence seq) {
        try {
            final boolean transparentBounds = matcher.transparentBounds;
            BytecodeManager.incBytecodes(3);
            int from;
            if (!transparentBounds) {
                from = matcher.from;
                BytecodeManager.incBytecodes(3);
            }
            else {
                from = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n2 = from;
            BytecodeManager.incBytecodes(1);
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int n5 = n2;
                BytecodeManager.incBytecodes(3);
                if (n4 < n5) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int index = n3;
                BytecodeManager.incBytecodes(3);
                final int codePoint = Character.codePointAt(seq, index);
                BytecodeManager.incBytecodes(1);
                final int codePoint2 = codePoint;
                BytecodeManager.incBytecodes(2);
                final boolean letterOrDigit = Character.isLetterOrDigit(codePoint2);
                BytecodeManager.incBytecodes(1);
                if (letterOrDigit) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final int codePoint3 = codePoint;
                BytecodeManager.incBytecodes(2);
                final int type = Character.getType(codePoint3);
                final int n6 = 6;
                BytecodeManager.incBytecodes(2);
                if (type != n6) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                BytecodeManager.incBytecodes(1);
                --n3;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Predicate<String> asPredicate() {
        try {
            final Matcher matcher;
            final boolean b;
            final Predicate<String> predicate = s -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    this.matcher(s);
                    BytecodeManager.incBytecodes(1);
                    matcher.find();
                    BytecodeManager.incBytecodes(1);
                    return b;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            return predicate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Stream<String> splitAsStream(final CharSequence charSequence) {
        try {
            BytecodeManager.incBytecodes(5);
            class MatcherIterator implements Iterator<String>
            {
                private final Matcher matcher;
                private int current;
                private String nextElement;
                private int emptyElementCount;
                
                MatcherIterator() {
                    try {
                        BytecodeManager.incBytecodes(8);
                        final CharSequence val$input2 = charSequence;
                        BytecodeManager.incBytecodes(5);
                        this.matcher = Pattern.this.matcher(val$input2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public String next() {
                    try {
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = this.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            BytecodeManager.incBytecodes(3);
                            final NoSuchElementException ex = new NoSuchElementException();
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        final int emptyElementCount = this.emptyElementCount;
                        BytecodeManager.incBytecodes(3);
                        if (emptyElementCount == 0) {
                            final String nextElement = this.nextElement;
                            BytecodeManager.incBytecodes(3);
                            this.nextElement = null;
                            BytecodeManager.incBytecodes(3);
                            final String s = nextElement;
                            BytecodeManager.incBytecodes(2);
                            return s;
                        }
                        --this.emptyElementCount;
                        BytecodeManager.incBytecodes(6);
                        final String s2 = "";
                        BytecodeManager.incBytecodes(2);
                        return s2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final String nextElement = this.nextElement;
                        BytecodeManager.incBytecodes(3);
                        if (nextElement == null) {
                            final int emptyElementCount = this.emptyElementCount;
                            BytecodeManager.incBytecodes(3);
                            if (emptyElementCount <= 0) {
                                final int current = this.current;
                                final CharSequence val$input = charSequence;
                                BytecodeManager.incBytecodes(5);
                                final int length = val$input.length();
                                BytecodeManager.incBytecodes(1);
                                if (current == length) {
                                    final boolean b = false;
                                    BytecodeManager.incBytecodes(2);
                                    return b;
                                }
                                while (true) {
                                    final Matcher matcher = this.matcher;
                                    BytecodeManager.incBytecodes(3);
                                    final boolean find = matcher.find();
                                    BytecodeManager.incBytecodes(1);
                                    if (find) {
                                        final CharSequence val$input2 = charSequence;
                                        final int current2 = this.current;
                                        final Matcher matcher2 = this.matcher;
                                        BytecodeManager.incBytecodes(8);
                                        final int start = matcher2.start();
                                        BytecodeManager.incBytecodes(1);
                                        final CharSequence subSequence = val$input2.subSequence(current2, start);
                                        BytecodeManager.incBytecodes(1);
                                        this.nextElement = subSequence.toString();
                                        BytecodeManager.incBytecodes(1);
                                        final Matcher matcher3 = this.matcher;
                                        BytecodeManager.incBytecodes(4);
                                        this.current = matcher3.end();
                                        BytecodeManager.incBytecodes(1);
                                        final String nextElement2 = this.nextElement;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean empty = nextElement2.isEmpty();
                                        BytecodeManager.incBytecodes(1);
                                        if (!empty) {
                                            final boolean b2 = true;
                                            BytecodeManager.incBytecodes(2);
                                            return b2;
                                        }
                                        final int current3 = this.current;
                                        BytecodeManager.incBytecodes(3);
                                        if (current3 <= 0) {
                                            continue;
                                        }
                                        ++this.emptyElementCount;
                                        BytecodeManager.incBytecodes(7);
                                    }
                                    else {
                                        final CharSequence val$input3 = charSequence;
                                        final int current4 = this.current;
                                        final CharSequence val$input4 = charSequence;
                                        BytecodeManager.incBytecodes(8);
                                        final int length2 = val$input4.length();
                                        BytecodeManager.incBytecodes(1);
                                        final CharSequence subSequence2 = val$input3.subSequence(current4, length2);
                                        BytecodeManager.incBytecodes(1);
                                        this.nextElement = subSequence2.toString();
                                        BytecodeManager.incBytecodes(1);
                                        final CharSequence val$input5 = charSequence;
                                        BytecodeManager.incBytecodes(4);
                                        this.current = val$input5.length();
                                        BytecodeManager.incBytecodes(1);
                                        final String nextElement3 = this.nextElement;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean empty2 = nextElement3.isEmpty();
                                        BytecodeManager.incBytecodes(1);
                                        if (!empty2) {
                                            final boolean b3 = true;
                                            BytecodeManager.incBytecodes(2);
                                            return b3;
                                        }
                                        this.emptyElementCount = 0;
                                        BytecodeManager.incBytecodes(3);
                                        this.nextElement = null;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean b4 = false;
                                        BytecodeManager.incBytecodes(2);
                                        return b4;
                                    }
                                }
                            }
                        }
                        final boolean b5 = true;
                        BytecodeManager.incBytecodes(2);
                        return b5;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final MatcherIterator matcherIterator = new MatcherIterator();
            final int n = 272;
            BytecodeManager.incBytecodes(2);
            final Spliterator<Object> spliteratorUnknownSize = Spliterators.spliteratorUnknownSize((Iterator<?>)matcherIterator, n);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<String> stream = StreamSupport.stream((Spliterator<String>)spliteratorUnknownSize, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$200(final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(4);
            final boolean inRange = inRange(n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return inRange;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$300(final CharSequence charSequence, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final int countChars = countChars(charSequence, n, n2);
            BytecodeManager.incBytecodes(1);
            return countChars;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$400(final Matcher matcher, final int n, final CharSequence charSequence) {
        try {
            BytecodeManager.incBytecodes(4);
            final boolean hasBaseCharacter = hasBaseCharacter(matcher, n, charSequence);
            BytecodeManager.incBytecodes(1);
            return hasBaseCharacter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ CharProperty access$600(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final CharProperty range = rangeFor(n, n2);
            BytecodeManager.incBytecodes(1);
            return range;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<Pattern> clazz = Pattern.class;
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
            BytecodeManager.incBytecodes(3);
            Pattern.lookbehindEnd = new Node() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
                    try {
                        final int lookbehindTo = matcher.lookbehindTo;
                        BytecodeManager.incBytecodes(4);
                        boolean b;
                        if (n == lookbehindTo) {
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
            };
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            Pattern.accept = new Node();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            Pattern.lastAccept = new LastNode();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class TreeInfo
    {
        int minLength;
        int maxLength;
        boolean maxValid;
        boolean deterministic;
        
        TreeInfo() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                this.reset();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void reset() {
            try {
                this.minLength = 0;
                BytecodeManager.incBytecodes(3);
                this.maxLength = 0;
                BytecodeManager.incBytecodes(3);
                this.maxValid = true;
                BytecodeManager.incBytecodes(3);
                this.deterministic = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class BitClass extends BmpCharProperty
    {
        final boolean[] bits;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        BitClass() {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.bits = new boolean[256];
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private BitClass(final boolean[] bits) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.bits = bits;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        BitClass add(final int n, final int n2) {
            try {
                final boolean $assertionsDisabled = BitClass.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                Label_0050: {
                    if (!$assertionsDisabled) {
                        BytecodeManager.incBytecodes(2);
                        if (n >= 0) {
                            final int n3 = 255;
                            BytecodeManager.incBytecodes(3);
                            if (n <= n3) {
                                break Label_0050;
                            }
                        }
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                final int n4 = n2 & 0x2;
                BytecodeManager.incBytecodes(4);
                if (n4 != 0) {
                    BytecodeManager.incBytecodes(2);
                    final boolean ascii = ASCII.isAscii(n);
                    BytecodeManager.incBytecodes(1);
                    if (ascii) {
                        final boolean[] bits = this.bits;
                        BytecodeManager.incBytecodes(4);
                        bits[ASCII.toUpper(n)] = true;
                        BytecodeManager.incBytecodes(2);
                        final boolean[] bits2 = this.bits;
                        BytecodeManager.incBytecodes(4);
                        bits2[ASCII.toLower(n)] = true;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final int n5 = n2 & 0x40;
                        BytecodeManager.incBytecodes(4);
                        if (n5 != 0) {
                            final boolean[] bits3 = this.bits;
                            BytecodeManager.incBytecodes(4);
                            bits3[Character.toLowerCase(n)] = true;
                            BytecodeManager.incBytecodes(2);
                            final boolean[] bits4 = this.bits;
                            BytecodeManager.incBytecodes(4);
                            bits4[Character.toUpperCase(n)] = true;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                this.bits[n] = true;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int n2 = 256;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0041: {
                    if (n < n2) {
                        final boolean b = this.bits[n];
                        BytecodeManager.incBytecodes(5);
                        if (b) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0041;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Pattern> clazz = Pattern.class;
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
    
    static class Node
    {
        Node next;
        
        Node() {
            try {
                BytecodeManager.incBytecodes(2);
                this.next = Pattern.accept;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean match(final Matcher matcher, final int last, final CharSequence charSequence) {
            try {
                matcher.last = last;
                BytecodeManager.incBytecodes(3);
                matcher.groups[0] = matcher.first;
                BytecodeManager.incBytecodes(6);
                matcher.groups[1] = matcher.last;
                BytecodeManager.incBytecodes(6);
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean study(final TreeInfo treeInfo) {
            try {
                final Node next = this.next;
                BytecodeManager.incBytecodes(3);
                if (next != null) {
                    final Node next2 = this.next;
                    BytecodeManager.incBytecodes(4);
                    final boolean study = next2.study(treeInfo);
                    BytecodeManager.incBytecodes(1);
                    return study;
                }
                final boolean deterministic = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                return deterministic;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class LastNode extends Node
    {
        LastNode() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int last, final CharSequence charSequence) {
            try {
                final int acceptMode = matcher.acceptMode;
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                if (acceptMode == n) {
                    final int to = matcher.to;
                    BytecodeManager.incBytecodes(4);
                    if (last != to) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                matcher.last = last;
                BytecodeManager.incBytecodes(3);
                matcher.groups[0] = matcher.first;
                BytecodeManager.incBytecodes(6);
                matcher.groups[1] = matcher.last;
                BytecodeManager.incBytecodes(6);
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class Start extends Node
    {
        int minLength;
        
        Start(final Node next) {
            try {
                BytecodeManager.incBytecodes(2);
                this.next = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                final TreeInfo treeInfo = new TreeInfo();
                BytecodeManager.incBytecodes(1);
                final Node next2 = this.next;
                final TreeInfo treeInfo2 = treeInfo;
                BytecodeManager.incBytecodes(4);
                next2.study(treeInfo2);
                BytecodeManager.incBytecodes(1);
                this.minLength = treeInfo.minLength;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int first, final CharSequence charSequence) {
            try {
                final int n = first;
                final int n2 = matcher.to - this.minLength;
                BytecodeManager.incBytecodes(7);
                if (n > n2) {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n3 = matcher.to - this.minLength;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final int n4 = first;
                    final int n5 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 > n5) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Node next = this.next;
                    final int n6 = first;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n6, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (match) {
                        matcher.first = first;
                        BytecodeManager.incBytecodes(3);
                        matcher.groups[0] = matcher.first;
                        BytecodeManager.incBytecodes(6);
                        matcher.groups[1] = matcher.last;
                        BytecodeManager.incBytecodes(6);
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    ++first;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                treeInfo.deterministic = false;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class StartS extends Start
    {
        StartS(final Node node) {
            try {
                BytecodeManager.incBytecodes(3);
                super(node);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int first, final CharSequence charSequence) {
            try {
                final int n = first;
                final int n2 = matcher.to - this.minLength;
                BytecodeManager.incBytecodes(7);
                if (n > n2) {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n3 = matcher.to - this.minLength;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final int n4 = first;
                    final int n5 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 > n5) {
                        break;
                    }
                    final Node next = this.next;
                    final int n6 = first;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n6, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (match) {
                        matcher.first = first;
                        BytecodeManager.incBytecodes(3);
                        matcher.groups[0] = matcher.first;
                        BytecodeManager.incBytecodes(6);
                        matcher.groups[1] = matcher.last;
                        BytecodeManager.incBytecodes(6);
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final int n7 = first;
                    final int n8 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n7 == n8) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final int n9 = first++;
                    BytecodeManager.incBytecodes(4);
                    final char char1 = charSequence.charAt(n9);
                    BytecodeManager.incBytecodes(1);
                    final boolean highSurrogate = Character.isHighSurrogate(char1);
                    BytecodeManager.incBytecodes(1);
                    if (!highSurrogate) {
                        continue;
                    }
                    final int n10 = first;
                    BytecodeManager.incBytecodes(3);
                    final int length = charSequence.length();
                    BytecodeManager.incBytecodes(1);
                    if (n10 >= length) {
                        continue;
                    }
                    final int n11 = first;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final char char2 = charSequence.charAt(n11);
                    BytecodeManager.incBytecodes(1);
                    final boolean lowSurrogate = Character.isLowSurrogate(char2);
                    BytecodeManager.incBytecodes(1);
                    if (!lowSurrogate) {
                        continue;
                    }
                    ++first;
                    BytecodeManager.incBytecodes(2);
                }
                matcher.hitEnd = true;
                BytecodeManager.incBytecodes(3);
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Begin extends Node
    {
        Begin() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int first, final CharSequence charSequence) {
            try {
                final boolean anchoringBounds = matcher.anchoringBounds;
                BytecodeManager.incBytecodes(3);
                int from;
                if (anchoringBounds) {
                    from = matcher.from;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    from = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n = from;
                BytecodeManager.incBytecodes(1);
                final int n2 = n;
                BytecodeManager.incBytecodes(3);
                if (first == n2) {
                    final Node next = this.next;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, first, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (match) {
                        matcher.first = first;
                        BytecodeManager.incBytecodes(3);
                        matcher.groups[0] = first;
                        BytecodeManager.incBytecodes(5);
                        matcher.groups[1] = matcher.last;
                        BytecodeManager.incBytecodes(6);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
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
    }
    
    static final class End extends Node
    {
        End() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final boolean anchoringBounds = matcher.anchoringBounds;
                BytecodeManager.incBytecodes(3);
                int n2;
                if (anchoringBounds) {
                    n2 = matcher.to;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    n2 = matcher.getTextLength();
                }
                final int n3 = n2;
                BytecodeManager.incBytecodes(1);
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n == n4) {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    final Node next = this.next;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(1);
                    return match;
                }
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Caret extends Node
    {
        Caret() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                int from = matcher.from;
                BytecodeManager.incBytecodes(3);
                int n2 = matcher.to;
                BytecodeManager.incBytecodes(3);
                final boolean anchoringBounds = matcher.anchoringBounds;
                BytecodeManager.incBytecodes(3);
                if (!anchoringBounds) {
                    from = 0;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    n2 = matcher.getTextLength();
                    BytecodeManager.incBytecodes(1);
                }
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n == n3) {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n4 = from;
                BytecodeManager.incBytecodes(3);
                if (n > n4) {
                    final int n5 = n - 1;
                    BytecodeManager.incBytecodes(5);
                    final char char1 = charSequence.charAt(n5);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int n6 = '\n';
                    BytecodeManager.incBytecodes(3);
                    if (c != n6) {
                        final char c2 = char1;
                        final int n7 = '\r';
                        BytecodeManager.incBytecodes(3);
                        if (c2 != n7) {
                            final int n8 = char1 | '\u0001';
                            final int n9 = 8233;
                            BytecodeManager.incBytecodes(5);
                            if (n8 != n9) {
                                final char c3 = char1;
                                final int n10 = '\u0085';
                                BytecodeManager.incBytecodes(3);
                                if (c3 != n10) {
                                    final boolean b2 = false;
                                    BytecodeManager.incBytecodes(2);
                                    return b2;
                                }
                            }
                        }
                    }
                    final char c4 = char1;
                    final int n11 = '\r';
                    BytecodeManager.incBytecodes(3);
                    if (c4 == n11) {
                        BytecodeManager.incBytecodes(3);
                        final char char2 = charSequence.charAt(n);
                        final int n12 = '\n';
                        BytecodeManager.incBytecodes(2);
                        if (char2 == n12) {
                            final boolean b3 = false;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
                }
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match = next.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UnixCaret extends Node
    {
        UnixCaret() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                int from = matcher.from;
                BytecodeManager.incBytecodes(3);
                int n2 = matcher.to;
                BytecodeManager.incBytecodes(3);
                final boolean anchoringBounds = matcher.anchoringBounds;
                BytecodeManager.incBytecodes(3);
                if (!anchoringBounds) {
                    from = 0;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    n2 = matcher.getTextLength();
                    BytecodeManager.incBytecodes(1);
                }
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n == n3) {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n4 = from;
                BytecodeManager.incBytecodes(3);
                if (n > n4) {
                    final int n5 = n - 1;
                    BytecodeManager.incBytecodes(5);
                    final char char1 = charSequence.charAt(n5);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int n6 = '\n';
                    BytecodeManager.incBytecodes(3);
                    if (c != n6) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match = next.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LastMatch extends Node
    {
        LastMatch() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int oldLast = matcher.oldLast;
                BytecodeManager.incBytecodes(4);
                if (n != oldLast) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match = next.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Dollar extends Node
    {
        boolean multiline;
        
        Dollar(final boolean multiline) {
            try {
                BytecodeManager.incBytecodes(2);
                this.multiline = multiline;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final boolean anchoringBounds = matcher.anchoringBounds;
                BytecodeManager.incBytecodes(3);
                int n2;
                if (anchoringBounds) {
                    n2 = matcher.to;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    n2 = matcher.getTextLength();
                }
                final int n3 = n2;
                BytecodeManager.incBytecodes(1);
                final boolean multiline = this.multiline;
                BytecodeManager.incBytecodes(3);
                if (!multiline) {
                    final int n4 = n3 - 2;
                    BytecodeManager.incBytecodes(5);
                    if (n < n4) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int n5 = n3 - 2;
                    BytecodeManager.incBytecodes(5);
                    if (n == n5) {
                        BytecodeManager.incBytecodes(3);
                        final char char1 = charSequence.charAt(n);
                        BytecodeManager.incBytecodes(1);
                        final char c = char1;
                        final int n6 = '\r';
                        BytecodeManager.incBytecodes(3);
                        if (c != n6) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        final int n7 = n + 1;
                        BytecodeManager.incBytecodes(5);
                        final char char2 = charSequence.charAt(n7);
                        BytecodeManager.incBytecodes(1);
                        final char c2 = char2;
                        final int n8 = '\n';
                        BytecodeManager.incBytecodes(3);
                        if (c2 != n8) {
                            final boolean b3 = false;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
                }
                final int n9 = n3;
                BytecodeManager.incBytecodes(3);
                if (n < n9) {
                    BytecodeManager.incBytecodes(3);
                    final char char3 = charSequence.charAt(n);
                    BytecodeManager.incBytecodes(1);
                    final char c3 = char3;
                    final int n10 = '\n';
                    BytecodeManager.incBytecodes(3);
                    if (c3 == n10) {
                        BytecodeManager.incBytecodes(2);
                        if (n > 0) {
                            final int n11 = n - 1;
                            BytecodeManager.incBytecodes(5);
                            final char char4 = charSequence.charAt(n11);
                            final int n12 = '\r';
                            BytecodeManager.incBytecodes(2);
                            if (char4 == n12) {
                                final boolean b4 = false;
                                BytecodeManager.incBytecodes(2);
                                return b4;
                            }
                        }
                        final boolean multiline2 = this.multiline;
                        BytecodeManager.incBytecodes(3);
                        if (multiline2) {
                            final Node next = this.next;
                            BytecodeManager.incBytecodes(6);
                            final boolean match = next.match(matcher, n, charSequence);
                            BytecodeManager.incBytecodes(1);
                            return match;
                        }
                    }
                    else {
                        final char c4 = char3;
                        final int n13 = '\r';
                        BytecodeManager.incBytecodes(3);
                        if (c4 != n13) {
                            final char c5 = char3;
                            final int n14 = '\u0085';
                            BytecodeManager.incBytecodes(3);
                            if (c5 != n14) {
                                final int n15 = char3 | '\u0001';
                                final int n16 = 8233;
                                BytecodeManager.incBytecodes(5);
                                if (n15 != n16) {
                                    final boolean b5 = false;
                                    BytecodeManager.incBytecodes(2);
                                    return b5;
                                }
                            }
                        }
                        final boolean multiline3 = this.multiline;
                        BytecodeManager.incBytecodes(3);
                        if (multiline3) {
                            final Node next2 = this.next;
                            BytecodeManager.incBytecodes(6);
                            final boolean match2 = next2.match(matcher, n, charSequence);
                            BytecodeManager.incBytecodes(1);
                            return match2;
                        }
                    }
                }
                matcher.hitEnd = true;
                BytecodeManager.incBytecodes(3);
                matcher.requireEnd = true;
                BytecodeManager.incBytecodes(3);
                final Node next3 = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match3 = next3.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                final boolean deterministic = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                return deterministic;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UnixDollar extends Node
    {
        boolean multiline;
        
        UnixDollar(final boolean multiline) {
            try {
                BytecodeManager.incBytecodes(2);
                this.multiline = multiline;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final boolean anchoringBounds = matcher.anchoringBounds;
                BytecodeManager.incBytecodes(3);
                int n2;
                if (anchoringBounds) {
                    n2 = matcher.to;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    n2 = matcher.getTextLength();
                }
                final int n3 = n2;
                BytecodeManager.incBytecodes(1);
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n < n4) {
                    BytecodeManager.incBytecodes(3);
                    final char char1 = charSequence.charAt(n);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int n5 = '\n';
                    BytecodeManager.incBytecodes(3);
                    if (c != n5) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final boolean multiline = this.multiline;
                    BytecodeManager.incBytecodes(3);
                    if (!multiline) {
                        final int n6 = n3 - 1;
                        BytecodeManager.incBytecodes(5);
                        if (n != n6) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                    final boolean multiline2 = this.multiline;
                    BytecodeManager.incBytecodes(3);
                    if (multiline2) {
                        final Node next = this.next;
                        BytecodeManager.incBytecodes(6);
                        final boolean match = next.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                }
                matcher.hitEnd = true;
                BytecodeManager.incBytecodes(3);
                matcher.requireEnd = true;
                BytecodeManager.incBytecodes(3);
                final Node next2 = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match2 = next2.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                final boolean deterministic = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                return deterministic;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LineEnding extends Node
    {
        LineEnding() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int n, final CharSequence charSequence) {
            try {
                final int n2 = n;
                final int to = matcher.to;
                BytecodeManager.incBytecodes(4);
                Label_0232: {
                    if (n2 < to) {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(3);
                        final char char1 = charSequence.charAt(n3);
                        BytecodeManager.incBytecodes(1);
                        final char c = char1;
                        final int n4 = '\n';
                        BytecodeManager.incBytecodes(3);
                        if (c != n4) {
                            final char c2 = char1;
                            final int n5 = '\u000b';
                            BytecodeManager.incBytecodes(3);
                            if (c2 != n5) {
                                final char c3 = char1;
                                final int n6 = '\f';
                                BytecodeManager.incBytecodes(3);
                                if (c3 != n6) {
                                    final char c4 = char1;
                                    final int n7 = '\u0085';
                                    BytecodeManager.incBytecodes(3);
                                    if (c4 != n7) {
                                        final char c5 = char1;
                                        final int n8 = '\u2028';
                                        BytecodeManager.incBytecodes(3);
                                        if (c5 != n8) {
                                            final char c6 = char1;
                                            final int n9 = '\u2029';
                                            BytecodeManager.incBytecodes(3);
                                            if (c6 != n9) {
                                                final char c7 = char1;
                                                final int n10 = '\r';
                                                BytecodeManager.incBytecodes(3);
                                                if (c7 == n10) {
                                                    ++n;
                                                    BytecodeManager.incBytecodes(1);
                                                    final int n11 = n;
                                                    final int to2 = matcher.to;
                                                    BytecodeManager.incBytecodes(4);
                                                    if (n11 < to2) {
                                                        final int n12 = n;
                                                        BytecodeManager.incBytecodes(3);
                                                        final char char2 = charSequence.charAt(n12);
                                                        final int n13 = '\n';
                                                        BytecodeManager.incBytecodes(2);
                                                        if (char2 == n13) {
                                                            ++n;
                                                            BytecodeManager.incBytecodes(1);
                                                        }
                                                    }
                                                    final Node next = this.next;
                                                    final int n14 = n;
                                                    BytecodeManager.incBytecodes(6);
                                                    final boolean match = next.match(matcher, n14, charSequence);
                                                    BytecodeManager.incBytecodes(1);
                                                    return match;
                                                }
                                                BytecodeManager.incBytecodes(1);
                                                break Label_0232;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        final Node next2 = this.next;
                        final int n15 = n + 1;
                        BytecodeManager.incBytecodes(8);
                        final boolean match2 = next2.match(matcher, n15, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match2;
                    }
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                }
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                ++treeInfo.minLength;
                BytecodeManager.incBytecodes(6);
                treeInfo.maxLength += 2;
                BytecodeManager.incBytecodes(6);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class CharProperty extends Node
    {
        private CharProperty() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract boolean isSatisfiedBy(final int p0);
        
        CharProperty complement() {
            try {
                BytecodeManager.incBytecodes(4);
                final CharProperty charProperty = new CharProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int n) {
                        try {
                            final CharProperty this$0 = CharProperty.this;
                            BytecodeManager.incBytecodes(4);
                            final boolean satisfiedBy = this$0.isSatisfiedBy(n);
                            BytecodeManager.incBytecodes(1);
                            boolean b;
                            if (!satisfiedBy) {
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
                };
                BytecodeManager.incBytecodes(1);
                return charProperty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int index, final CharSequence seq) {
            try {
                final int to = matcher.to;
                BytecodeManager.incBytecodes(4);
                if (index < to) {
                    BytecodeManager.incBytecodes(3);
                    final int codePoint = Character.codePointAt(seq, index);
                    BytecodeManager.incBytecodes(1);
                    final int n = codePoint;
                    BytecodeManager.incBytecodes(3);
                    final boolean satisfiedBy = this.isSatisfiedBy(n);
                    BytecodeManager.incBytecodes(1);
                    boolean b = false;
                    Label_0103: {
                        if (satisfiedBy) {
                            final Node next = this.next;
                            final int codePoint2 = codePoint;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final int n2 = index + Character.charCount(codePoint2);
                            BytecodeManager.incBytecodes(3);
                            final boolean match = next.match(matcher, n2, seq);
                            BytecodeManager.incBytecodes(1);
                            if (match) {
                                b = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0103;
                            }
                        }
                        b = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b;
                }
                matcher.hitEnd = true;
                BytecodeManager.incBytecodes(3);
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                ++treeInfo.minLength;
                BytecodeManager.incBytecodes(6);
                ++treeInfo.maxLength;
                BytecodeManager.incBytecodes(6);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class BmpCharProperty extends CharProperty
    {
        private BmpCharProperty() {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int to = matcher.to;
                BytecodeManager.incBytecodes(4);
                if (n < to) {
                    BytecodeManager.incBytecodes(4);
                    final char char1 = charSequence.charAt(n);
                    BytecodeManager.incBytecodes(1);
                    final boolean satisfiedBy = this.isSatisfiedBy(char1);
                    BytecodeManager.incBytecodes(1);
                    boolean b = false;
                    Label_0087: {
                        if (satisfiedBy) {
                            final Node next = this.next;
                            final int n2 = n + 1;
                            BytecodeManager.incBytecodes(7);
                            BytecodeManager.incBytecodes(1);
                            final boolean match = next.match(matcher, n2, charSequence);
                            BytecodeManager.incBytecodes(1);
                            if (match) {
                                b = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0087;
                            }
                        }
                        b = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b;
                }
                matcher.hitEnd = true;
                BytecodeManager.incBytecodes(3);
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class SingleS extends CharProperty
    {
        final int c;
        
        SingleS(final int c) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.c = c;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int c = this.c;
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (n == c) {
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
    }
    
    static final class Single extends BmpCharProperty
    {
        final int c;
        
        Single(final int c) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.c = c;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int c = this.c;
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (n == c) {
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
    }
    
    static final class SingleI extends BmpCharProperty
    {
        final int lower;
        final int upper;
        
        SingleI(final int lower, final int upper) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.lower = lower;
                BytecodeManager.incBytecodes(3);
                this.upper = upper;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int lower = this.lower;
                BytecodeManager.incBytecodes(4);
                boolean b = false;
                Label_0041: {
                    if (n != lower) {
                        final int upper = this.upper;
                        BytecodeManager.incBytecodes(4);
                        if (n != upper) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0041;
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
    }
    
    static final class SingleU extends CharProperty
    {
        final int lower;
        
        SingleU(final int lower) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.lower = lower;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int codePoint) {
            try {
                final int lower = this.lower;
                BytecodeManager.incBytecodes(4);
                boolean b = false;
                Label_0062: {
                    if (lower != codePoint) {
                        final int lower2 = this.lower;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final int upperCase = Character.toUpperCase(codePoint);
                        BytecodeManager.incBytecodes(1);
                        final int lowerCase = Character.toLowerCase(upperCase);
                        BytecodeManager.incBytecodes(1);
                        if (lower2 != lowerCase) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0062;
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
    }
    
    static final class Block extends CharProperty
    {
        final Character.UnicodeBlock block;
        
        Block(final Character.UnicodeBlock block) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.block = block;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int codePoint) {
            try {
                final Character.UnicodeBlock block = this.block;
                BytecodeManager.incBytecodes(4);
                final Character.UnicodeBlock of = Character.UnicodeBlock.of(codePoint);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (block == of) {
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
    }
    
    static final class Script extends CharProperty
    {
        final Character.UnicodeScript script;
        
        Script(final Character.UnicodeScript script) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.script = script;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int codePoint) {
            try {
                final Character.UnicodeScript script = this.script;
                BytecodeManager.incBytecodes(4);
                final Character.UnicodeScript of = Character.UnicodeScript.of(codePoint);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (script == of) {
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
    }
    
    static final class Category extends CharProperty
    {
        final int typeMask;
        
        Category(final int typeMask) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.typeMask = typeMask;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int codePoint) {
            try {
                final int typeMask = this.typeMask;
                final int n = 1;
                BytecodeManager.incBytecodes(5);
                final int n2 = typeMask & n << Character.getType(codePoint);
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (n2 != 0) {
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
    }
    
    static final class Utype extends CharProperty
    {
        final UnicodeProp uprop;
        
        Utype(final UnicodeProp uprop) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.uprop = uprop;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final UnicodeProp uprop = this.uprop;
                BytecodeManager.incBytecodes(4);
                final boolean is = uprop.is(n);
                BytecodeManager.incBytecodes(1);
                return is;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Ctype extends BmpCharProperty
    {
        final int ctype;
        
        Ctype(final int ctype) {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                this.ctype = ctype;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int n2 = 128;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (n < n2) {
                        final int ctype = this.ctype;
                        BytecodeManager.incBytecodes(4);
                        final boolean type = ASCII.isType(n, ctype);
                        BytecodeManager.incBytecodes(1);
                        if (type) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0048;
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
    }
    
    static final class VertWS extends BmpCharProperty
    {
        VertWS() {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int n2 = 10;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0073: {
                    Label_0058: {
                        if (n >= n2) {
                            final int n3 = 13;
                            BytecodeManager.incBytecodes(3);
                            if (n <= n3) {
                                break Label_0058;
                            }
                        }
                        final int n4 = 133;
                        BytecodeManager.incBytecodes(3);
                        if (n != n4) {
                            final int n5 = 8232;
                            BytecodeManager.incBytecodes(3);
                            if (n != n5) {
                                final int n6 = 8233;
                                BytecodeManager.incBytecodes(3);
                                if (n != n6) {
                                    b = false;
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0073;
                                }
                            }
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
    }
    
    static final class HorizWS extends BmpCharProperty
    {
        HorizWS() {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int n2 = 9;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0133: {
                    Label_0118: {
                        if (n != n2) {
                            final int n3 = 32;
                            BytecodeManager.incBytecodes(3);
                            if (n != n3) {
                                final int n4 = 160;
                                BytecodeManager.incBytecodes(3);
                                if (n != n4) {
                                    final int n5 = 5760;
                                    BytecodeManager.incBytecodes(3);
                                    if (n != n5) {
                                        final int n6 = 6158;
                                        BytecodeManager.incBytecodes(3);
                                        if (n != n6) {
                                            final int n7 = 8192;
                                            BytecodeManager.incBytecodes(3);
                                            if (n >= n7) {
                                                final int n8 = 8202;
                                                BytecodeManager.incBytecodes(3);
                                                if (n <= n8) {
                                                    break Label_0118;
                                                }
                                            }
                                            final int n9 = 8239;
                                            BytecodeManager.incBytecodes(3);
                                            if (n != n9) {
                                                final int n10 = 8287;
                                                BytecodeManager.incBytecodes(3);
                                                if (n != n10) {
                                                    final int n11 = 12288;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n != n11) {
                                                        b = false;
                                                        BytecodeManager.incBytecodes(1);
                                                        break Label_0133;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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
    }
    
    static class SliceNode extends Node
    {
        int[] buffer;
        
        SliceNode(final int[] buffer) {
            try {
                BytecodeManager.incBytecodes(2);
                this.buffer = buffer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                treeInfo.minLength += this.buffer.length;
                BytecodeManager.incBytecodes(8);
                treeInfo.maxLength += this.buffer.length;
                BytecodeManager.incBytecodes(8);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Slice extends SliceNode
    {
        Slice(final int[] array) {
            try {
                BytecodeManager.incBytecodes(3);
                super(array);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int[] buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                final int length = buffer.length;
                BytecodeManager.incBytecodes(3);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int n4 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n3 >= n4) {
                        final Node next = this.next;
                        final int n5 = n + length;
                        BytecodeManager.incBytecodes(8);
                        final boolean match = next.match(matcher, n5, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                    final int n6 = n + n2;
                    final int to = matcher.to;
                    BytecodeManager.incBytecodes(6);
                    if (n6 >= to) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int n7 = buffer[n2];
                    final int n8 = n + n2;
                    BytecodeManager.incBytecodes(8);
                    final char char1 = charSequence.charAt(n8);
                    BytecodeManager.incBytecodes(1);
                    if (n7 != char1) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class SliceI extends SliceNode
    {
        SliceI(final int[] array) {
            try {
                BytecodeManager.incBytecodes(3);
                super(array);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int[] buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                final int length = buffer.length;
                BytecodeManager.incBytecodes(3);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int n4 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n3 >= n4) {
                        final Node next = this.next;
                        final int n5 = n + length;
                        BytecodeManager.incBytecodes(8);
                        final boolean match = next.match(matcher, n5, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                    final int n6 = n + n2;
                    final int to = matcher.to;
                    BytecodeManager.incBytecodes(6);
                    if (n6 >= to) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int n7 = n + n2;
                    BytecodeManager.incBytecodes(5);
                    final char char1 = charSequence.charAt(n7);
                    BytecodeManager.incBytecodes(1);
                    final int n8 = buffer[n2];
                    final char c = char1;
                    BytecodeManager.incBytecodes(5);
                    if (n8 != c) {
                        final int n9 = buffer[n2];
                        final char c2 = char1;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int lower = ASCII.toLower(c2);
                        BytecodeManager.incBytecodes(1);
                        if (n9 != lower) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class SliceU extends SliceNode
    {
        SliceU(final int[] array) {
            try {
                BytecodeManager.incBytecodes(3);
                super(array);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int[] buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                final int length = buffer.length;
                BytecodeManager.incBytecodes(3);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int n4 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n3 >= n4) {
                        final Node next = this.next;
                        final int n5 = n + length;
                        BytecodeManager.incBytecodes(8);
                        final boolean match = next.match(matcher, n5, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                    final int n6 = n + n2;
                    final int to = matcher.to;
                    BytecodeManager.incBytecodes(6);
                    if (n6 >= to) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int n7 = n + n2;
                    BytecodeManager.incBytecodes(5);
                    final char char1 = charSequence.charAt(n7);
                    BytecodeManager.incBytecodes(1);
                    final int n8 = buffer[n2];
                    final char c = char1;
                    BytecodeManager.incBytecodes(5);
                    if (n8 != c) {
                        final int n9 = buffer[n2];
                        final char codePoint = char1;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int upperCase = Character.toUpperCase((int)codePoint);
                        BytecodeManager.incBytecodes(1);
                        final int lowerCase = Character.toLowerCase(upperCase);
                        BytecodeManager.incBytecodes(1);
                        if (n9 != lowerCase) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class SliceS extends SliceNode
    {
        SliceS(final int[] array) {
            try {
                BytecodeManager.incBytecodes(3);
                super(array);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence seq) {
            try {
                final int[] buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                int n2 = n;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int length = buffer.length;
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= length) {
                        final Node next = this.next;
                        final int n5 = n2;
                        BytecodeManager.incBytecodes(6);
                        final boolean match = next.match(matcher, n5, seq);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                    final int n6 = n2;
                    final int to = matcher.to;
                    BytecodeManager.incBytecodes(4);
                    if (n6 >= to) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int index = n2;
                    BytecodeManager.incBytecodes(3);
                    final int codePoint = Character.codePointAt(seq, index);
                    BytecodeManager.incBytecodes(1);
                    final int n7 = buffer[n3];
                    final int n8 = codePoint;
                    BytecodeManager.incBytecodes(5);
                    if (n7 != n8) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final int n9 = n2;
                    final int codePoint2 = codePoint;
                    BytecodeManager.incBytecodes(3);
                    n2 = n9 + Character.charCount(codePoint2);
                    BytecodeManager.incBytecodes(2);
                    final int n10 = n2;
                    final int to2 = matcher.to;
                    BytecodeManager.incBytecodes(4);
                    if (n10 > to2) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class SliceIS extends SliceNode
    {
        SliceIS(final int[] array) {
            try {
                BytecodeManager.incBytecodes(3);
                super(array);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        int toLower(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                final int lower = ASCII.toLower(n);
                BytecodeManager.incBytecodes(1);
                return lower;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence seq) {
            try {
                final int[] buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                int n2 = n;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int length = buffer.length;
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= length) {
                        final Node next = this.next;
                        final int n5 = n2;
                        BytecodeManager.incBytecodes(6);
                        final boolean match = next.match(matcher, n5, seq);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                    final int n6 = n2;
                    final int to = matcher.to;
                    BytecodeManager.incBytecodes(4);
                    if (n6 >= to) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int index = n2;
                    BytecodeManager.incBytecodes(3);
                    final int codePoint = Character.codePointAt(seq, index);
                    BytecodeManager.incBytecodes(1);
                    final int n7 = buffer[n3];
                    final int n8 = codePoint;
                    BytecodeManager.incBytecodes(5);
                    if (n7 != n8) {
                        final int n9 = buffer[n3];
                        final int n10 = codePoint;
                        BytecodeManager.incBytecodes(6);
                        final int lower = this.toLower(n10);
                        BytecodeManager.incBytecodes(1);
                        if (n9 != lower) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                    final int n11 = n2;
                    final int codePoint2 = codePoint;
                    BytecodeManager.incBytecodes(3);
                    n2 = n11 + Character.charCount(codePoint2);
                    BytecodeManager.incBytecodes(2);
                    final int n12 = n2;
                    final int to2 = matcher.to;
                    BytecodeManager.incBytecodes(4);
                    if (n12 > to2) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class SliceUS extends SliceIS
    {
        SliceUS(final int[] array) {
            try {
                BytecodeManager.incBytecodes(3);
                super(array);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        int toLower(final int codePoint) {
            try {
                BytecodeManager.incBytecodes(2);
                final int upperCase = Character.toUpperCase(codePoint);
                BytecodeManager.incBytecodes(1);
                final int lowerCase = Character.toLowerCase(upperCase);
                BytecodeManager.incBytecodes(1);
                return lowerCase;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class All extends CharProperty
    {
        All() {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Dot extends CharProperty
    {
        Dot() {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int n2 = 10;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0063: {
                    if (n != n2) {
                        final int n3 = 13;
                        BytecodeManager.incBytecodes(3);
                        if (n != n3) {
                            final int n4 = n | 0x1;
                            final int n5 = 8233;
                            BytecodeManager.incBytecodes(5);
                            if (n4 != n5) {
                                final int n6 = 133;
                                BytecodeManager.incBytecodes(3);
                                if (n != n6) {
                                    b = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0063;
                                }
                            }
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
    }
    
    static final class UnixDot extends CharProperty
    {
        UnixDot() {
            try {
                final CharProperty charProperty = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean isSatisfiedBy(final int n) {
            try {
                final int n2 = 10;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (n != n2) {
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
    }
    
    static final class Ques extends Node
    {
        Node atom;
        int type;
        
        Ques(final Node atom, final int type) {
            try {
                BytecodeManager.incBytecodes(2);
                this.atom = atom;
                BytecodeManager.incBytecodes(3);
                this.type = type;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int last, final CharSequence charSequence) {
            try {
                final int type = this.type;
                BytecodeManager.incBytecodes(3);
                switch (type) {
                    case 0: {
                        final Node atom = this.atom;
                        final int n = last;
                        BytecodeManager.incBytecodes(6);
                        final boolean match = atom.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        boolean b = false;
                        Label_0128: {
                            Label_0113: {
                                if (match) {
                                    final Node next = this.next;
                                    final int last2 = matcher.last;
                                    BytecodeManager.incBytecodes(7);
                                    final boolean match2 = next.match(matcher, last2, charSequence);
                                    BytecodeManager.incBytecodes(1);
                                    if (match2) {
                                        break Label_0113;
                                    }
                                }
                                final Node next2 = this.next;
                                final int n2 = last;
                                BytecodeManager.incBytecodes(5);
                                BytecodeManager.incBytecodes(1);
                                final boolean match3 = next2.match(matcher, n2, charSequence);
                                BytecodeManager.incBytecodes(1);
                                if (!match3) {
                                    b = false;
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0128;
                                }
                            }
                            b = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(1);
                        return b;
                    }
                    case 1: {
                        final Node next3 = this.next;
                        final int n3 = last;
                        BytecodeManager.incBytecodes(6);
                        final boolean match4 = next3.match(matcher, n3, charSequence);
                        BytecodeManager.incBytecodes(1);
                        boolean b2 = false;
                        Label_0226: {
                            Label_0211: {
                                if (!match4) {
                                    final Node atom2 = this.atom;
                                    final int n4 = last;
                                    BytecodeManager.incBytecodes(5);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean match5 = atom2.match(matcher, n4, charSequence);
                                    BytecodeManager.incBytecodes(1);
                                    if (match5) {
                                        final Node next4 = this.next;
                                        final int last3 = matcher.last;
                                        BytecodeManager.incBytecodes(7);
                                        final boolean match6 = next4.match(matcher, last3, charSequence);
                                        BytecodeManager.incBytecodes(1);
                                        if (match6) {
                                            break Label_0211;
                                        }
                                    }
                                    b2 = false;
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0226;
                                }
                            }
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(1);
                        return b2;
                    }
                    case 2: {
                        final Node atom3 = this.atom;
                        final int n5 = last;
                        BytecodeManager.incBytecodes(6);
                        final boolean match7 = atom3.match(matcher, n5, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match7) {
                            last = matcher.last;
                            BytecodeManager.incBytecodes(3);
                        }
                        final Node next5 = this.next;
                        final int n6 = last;
                        BytecodeManager.incBytecodes(6);
                        final boolean match8 = next5.match(matcher, n6, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match8;
                    }
                    default: {
                        final Node atom4 = this.atom;
                        final int n7 = last;
                        BytecodeManager.incBytecodes(6);
                        final boolean match9 = atom4.match(matcher, n7, charSequence);
                        BytecodeManager.incBytecodes(1);
                        boolean b3 = false;
                        Label_0350: {
                            if (match9) {
                                final Node next6 = this.next;
                                final int last4 = matcher.last;
                                BytecodeManager.incBytecodes(7);
                                final boolean match10 = next6.match(matcher, last4, charSequence);
                                BytecodeManager.incBytecodes(1);
                                if (match10) {
                                    b3 = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0350;
                                }
                            }
                            b3 = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return b3;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final int type = this.type;
                final int n = 3;
                BytecodeManager.incBytecodes(4);
                if (type != n) {
                    final int minLength = treeInfo.minLength;
                    BytecodeManager.incBytecodes(3);
                    final Node atom = this.atom;
                    BytecodeManager.incBytecodes(4);
                    atom.study(treeInfo);
                    BytecodeManager.incBytecodes(1);
                    treeInfo.minLength = minLength;
                    BytecodeManager.incBytecodes(3);
                    treeInfo.deterministic = false;
                    BytecodeManager.incBytecodes(3);
                    final Node next = this.next;
                    BytecodeManager.incBytecodes(4);
                    final boolean study = next.study(treeInfo);
                    BytecodeManager.incBytecodes(1);
                    return study;
                }
                final Node atom2 = this.atom;
                BytecodeManager.incBytecodes(4);
                atom2.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                final Node next2 = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study2 = next2.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Curly extends Node
    {
        Node atom;
        int type;
        int cmin;
        int cmax;
        
        Curly(final Node atom, final int cmin, final int cmax, final int type) {
            try {
                BytecodeManager.incBytecodes(2);
                this.atom = atom;
                BytecodeManager.incBytecodes(3);
                this.type = type;
                BytecodeManager.incBytecodes(3);
                this.cmin = cmin;
                BytecodeManager.incBytecodes(3);
                this.cmax = cmax;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int last, final CharSequence charSequence) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int cmin = this.cmin;
                    BytecodeManager.incBytecodes(4);
                    if (n2 < cmin) {
                        final Node atom = this.atom;
                        final int n3 = last;
                        BytecodeManager.incBytecodes(6);
                        final boolean match = atom.match(matcher, n3, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (!match) {
                            final boolean b = false;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        last = matcher.last;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int type = this.type;
                        BytecodeManager.incBytecodes(3);
                        if (type == 0) {
                            final int n4 = last;
                            final int n5 = n;
                            BytecodeManager.incBytecodes(6);
                            final boolean match2 = this.match0(matcher, n4, n5, charSequence);
                            BytecodeManager.incBytecodes(1);
                            return match2;
                        }
                        final int type2 = this.type;
                        final int n6 = 1;
                        BytecodeManager.incBytecodes(4);
                        if (type2 == n6) {
                            final int n7 = last;
                            final int n8 = n;
                            BytecodeManager.incBytecodes(6);
                            final boolean match3 = this.match1(matcher, n7, n8, charSequence);
                            BytecodeManager.incBytecodes(1);
                            return match3;
                        }
                        final int n9 = last;
                        final int n10 = n;
                        BytecodeManager.incBytecodes(6);
                        final boolean match4 = this.match2(matcher, n9, n10, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match4;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean match0(final Matcher matcher, int last, int n, final CharSequence charSequence) {
            try {
                final int n2 = n;
                final int cmax = this.cmax;
                BytecodeManager.incBytecodes(4);
                if (n2 >= cmax) {
                    final Node next = this.next;
                    final int n3 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n3, charSequence);
                    BytecodeManager.incBytecodes(1);
                    return match;
                }
                final int n4 = n;
                BytecodeManager.incBytecodes(2);
                final Node atom = this.atom;
                final int n5 = last;
                BytecodeManager.incBytecodes(6);
                final boolean match2 = atom.match(matcher, n5, charSequence);
                BytecodeManager.incBytecodes(1);
                if (match2) {
                    final int n6 = matcher.last - last;
                    BytecodeManager.incBytecodes(5);
                    final int n7 = n6;
                    BytecodeManager.incBytecodes(2);
                    if (n7 == 0) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        last = matcher.last;
                        BytecodeManager.incBytecodes(3);
                        ++n;
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final int n8 = n;
                            final int cmax2 = this.cmax;
                            BytecodeManager.incBytecodes(4);
                            if (n8 >= cmax2) {
                                break;
                            }
                            final Node atom2 = this.atom;
                            final int n9 = last;
                            BytecodeManager.incBytecodes(6);
                            final boolean match3 = atom2.match(matcher, n9, charSequence);
                            BytecodeManager.incBytecodes(1);
                            if (!match3) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final int n10 = last + n6;
                            final int last2 = matcher.last;
                            BytecodeManager.incBytecodes(6);
                            if (n10 != last2) {
                                final int last3 = matcher.last;
                                final int n11 = n + 1;
                                BytecodeManager.incBytecodes(9);
                                final boolean match4 = this.match0(matcher, last3, n11, charSequence);
                                BytecodeManager.incBytecodes(1);
                                if (match4) {
                                    final boolean b = true;
                                    BytecodeManager.incBytecodes(2);
                                    return b;
                                }
                                break;
                            }
                            else {
                                last += n6;
                                BytecodeManager.incBytecodes(4);
                                ++n;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        while (true) {
                            final int n12 = n;
                            final int n13 = n4;
                            BytecodeManager.incBytecodes(3);
                            if (n12 < n13) {
                                final boolean b2 = false;
                                BytecodeManager.incBytecodes(2);
                                return b2;
                            }
                            final Node next2 = this.next;
                            final int n14 = last;
                            BytecodeManager.incBytecodes(6);
                            final boolean match5 = next2.match(matcher, n14, charSequence);
                            BytecodeManager.incBytecodes(1);
                            if (match5) {
                                final boolean b3 = true;
                                BytecodeManager.incBytecodes(2);
                                return b3;
                            }
                            last -= n6;
                            BytecodeManager.incBytecodes(4);
                            --n;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                final Node next3 = this.next;
                final int n15 = last;
                BytecodeManager.incBytecodes(6);
                final boolean match6 = next3.match(matcher, n15, charSequence);
                BytecodeManager.incBytecodes(1);
                return match6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean match1(final Matcher matcher, int last, int n, final CharSequence charSequence) {
            try {
                while (true) {
                    final Node next = this.next;
                    final int n2 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n2, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (match) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int n3 = n;
                    final int cmax = this.cmax;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= cmax) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Node atom = this.atom;
                    final int n4 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match2 = atom.match(matcher, n4, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (!match2) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final int n5 = last;
                    final int last2 = matcher.last;
                    BytecodeManager.incBytecodes(4);
                    if (n5 == last2) {
                        final boolean b4 = false;
                        BytecodeManager.incBytecodes(2);
                        return b4;
                    }
                    last = matcher.last;
                    BytecodeManager.incBytecodes(3);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean match2(final Matcher matcher, int last, int n, final CharSequence charSequence) {
            try {
                while (true) {
                    final int n2 = n;
                    final int cmax = this.cmax;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= cmax) {
                        break;
                    }
                    final Node atom = this.atom;
                    final int n3 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = atom.match(matcher, n3, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (!match) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final int n4 = last;
                    final int last2 = matcher.last;
                    BytecodeManager.incBytecodes(4);
                    if (n4 == last2) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    last = matcher.last;
                    BytecodeManager.incBytecodes(3);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final Node next = this.next;
                final int n5 = last;
                BytecodeManager.incBytecodes(6);
                final boolean match2 = next.match(matcher, n5, charSequence);
                BytecodeManager.incBytecodes(1);
                return match2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final int minLength = treeInfo.minLength;
                BytecodeManager.incBytecodes(3);
                final int maxLength = treeInfo.maxLength;
                BytecodeManager.incBytecodes(3);
                final boolean maxValid = treeInfo.maxValid;
                BytecodeManager.incBytecodes(3);
                final boolean deterministic = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                treeInfo.reset();
                final Node atom = this.atom;
                BytecodeManager.incBytecodes(4);
                atom.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                int minLength2 = treeInfo.minLength * this.cmin + minLength;
                BytecodeManager.incBytecodes(8);
                final int n = minLength2;
                final int n2 = minLength;
                BytecodeManager.incBytecodes(3);
                if (n < n2) {
                    minLength2 = 268435455;
                    BytecodeManager.incBytecodes(2);
                }
                treeInfo.minLength = minLength2;
                BytecodeManager.incBytecodes(3);
                final boolean b = maxValid & treeInfo.maxValid;
                BytecodeManager.incBytecodes(5);
                if (b) {
                    final int maxLength2 = treeInfo.maxLength * this.cmax + maxLength;
                    BytecodeManager.incBytecodes(8);
                    treeInfo.maxLength = maxLength2;
                    BytecodeManager.incBytecodes(3);
                    final int n3 = maxLength2;
                    final int n4 = maxLength;
                    BytecodeManager.incBytecodes(3);
                    if (n3 < n4) {
                        treeInfo.maxValid = false;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                else {
                    treeInfo.maxValid = false;
                    BytecodeManager.incBytecodes(3);
                }
                final boolean deterministic2 = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                Label_0249: {
                    if (deterministic2) {
                        final int cmin = this.cmin;
                        final int cmax = this.cmax;
                        BytecodeManager.incBytecodes(5);
                        if (cmin == cmax) {
                            treeInfo.deterministic = deterministic;
                            BytecodeManager.incBytecodes(4);
                            break Label_0249;
                        }
                    }
                    treeInfo.deterministic = false;
                    BytecodeManager.incBytecodes(3);
                }
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class GroupCurly extends Node
    {
        Node atom;
        int type;
        int cmin;
        int cmax;
        int localIndex;
        int groupIndex;
        boolean capture;
        
        GroupCurly(final Node atom, final int cmin, final int cmax, final int type, final int localIndex, final int groupIndex, final boolean capture) {
            try {
                BytecodeManager.incBytecodes(2);
                this.atom = atom;
                BytecodeManager.incBytecodes(3);
                this.type = type;
                BytecodeManager.incBytecodes(3);
                this.cmin = cmin;
                BytecodeManager.incBytecodes(3);
                this.cmax = cmax;
                BytecodeManager.incBytecodes(3);
                this.localIndex = localIndex;
                BytecodeManager.incBytecodes(3);
                this.groupIndex = groupIndex;
                BytecodeManager.incBytecodes(3);
                this.capture = capture;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int last, final CharSequence charSequence) {
            try {
                final int[] groups = matcher.groups;
                BytecodeManager.incBytecodes(3);
                final int[] locals = matcher.locals;
                BytecodeManager.incBytecodes(3);
                final int n = locals[this.localIndex];
                BytecodeManager.incBytecodes(5);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                final boolean capture = this.capture;
                BytecodeManager.incBytecodes(3);
                if (capture) {
                    n2 = groups[this.groupIndex];
                    BytecodeManager.incBytecodes(5);
                    n3 = groups[this.groupIndex + 1];
                    BytecodeManager.incBytecodes(7);
                }
                locals[this.localIndex] = -1;
                BytecodeManager.incBytecodes(5);
                boolean b = true;
                BytecodeManager.incBytecodes(2);
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    final int cmin = this.cmin;
                    BytecodeManager.incBytecodes(4);
                    if (n5 >= cmin) {
                        break;
                    }
                    final Node atom = this.atom;
                    final int n6 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = atom.match(matcher, n6, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (!match) {
                        b = false;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final boolean capture2 = this.capture;
                    BytecodeManager.incBytecodes(3);
                    if (capture2) {
                        groups[this.groupIndex] = last;
                        BytecodeManager.incBytecodes(5);
                        groups[this.groupIndex + 1] = matcher.last;
                        BytecodeManager.incBytecodes(8);
                    }
                    last = matcher.last;
                    BytecodeManager.incBytecodes(4);
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                if (b2) {
                    final int type = this.type;
                    BytecodeManager.incBytecodes(3);
                    if (type == 0) {
                        final int n7 = last;
                        final int cmin2 = this.cmin;
                        BytecodeManager.incBytecodes(7);
                        b = this.match0(matcher, n7, cmin2, charSequence);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int type2 = this.type;
                        final int n8 = 1;
                        BytecodeManager.incBytecodes(4);
                        if (type2 == n8) {
                            final int n9 = last;
                            final int cmin3 = this.cmin;
                            BytecodeManager.incBytecodes(7);
                            b = this.match1(matcher, n9, cmin3, charSequence);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n10 = last;
                            final int cmin4 = this.cmin;
                            BytecodeManager.incBytecodes(7);
                            b = this.match2(matcher, n10, cmin4, charSequence);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final boolean b3 = b;
                BytecodeManager.incBytecodes(2);
                if (!b3) {
                    locals[this.localIndex] = n;
                    BytecodeManager.incBytecodes(5);
                    final boolean capture3 = this.capture;
                    BytecodeManager.incBytecodes(3);
                    if (capture3) {
                        groups[this.groupIndex] = n2;
                        BytecodeManager.incBytecodes(5);
                        groups[this.groupIndex + 1] = n3;
                        BytecodeManager.incBytecodes(7);
                    }
                }
                final boolean b4 = b;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean match0(final Matcher matcher, int n, int n2, final CharSequence charSequence) {
            try {
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                final int[] groups = matcher.groups;
                BytecodeManager.incBytecodes(3);
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                int n5 = 0;
                BytecodeManager.incBytecodes(2);
                final boolean capture = this.capture;
                BytecodeManager.incBytecodes(3);
                if (capture) {
                    n4 = groups[this.groupIndex];
                    BytecodeManager.incBytecodes(5);
                    n5 = groups[this.groupIndex + 1];
                    BytecodeManager.incBytecodes(7);
                }
                final int n6 = n2;
                final int cmax = this.cmax;
                BytecodeManager.incBytecodes(4);
                Label_0517: {
                    if (n6 >= cmax) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final Node atom = this.atom;
                        final int n7 = n;
                        BytecodeManager.incBytecodes(6);
                        final boolean match = atom.match(matcher, n7, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (!match) {
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n8 = matcher.last - n;
                            BytecodeManager.incBytecodes(5);
                            final int n9 = n8;
                            BytecodeManager.incBytecodes(2);
                            if (n9 <= 0) {
                                final boolean capture2 = this.capture;
                                BytecodeManager.incBytecodes(3);
                                if (capture2) {
                                    groups[this.groupIndex] = n;
                                    BytecodeManager.incBytecodes(5);
                                    groups[this.groupIndex + 1] = n + n8;
                                    BytecodeManager.incBytecodes(9);
                                }
                                n += n8;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                while (true) {
                                    int i;
                                    int last;
                                    do {
                                        final boolean capture3 = this.capture;
                                        BytecodeManager.incBytecodes(3);
                                        if (capture3) {
                                            groups[this.groupIndex] = n;
                                            BytecodeManager.incBytecodes(5);
                                            groups[this.groupIndex + 1] = n + n8;
                                            BytecodeManager.incBytecodes(9);
                                        }
                                        n += n8;
                                        BytecodeManager.incBytecodes(4);
                                        final int n10 = ++n2;
                                        final int cmax2 = this.cmax;
                                        BytecodeManager.incBytecodes(5);
                                        if (n10 >= cmax2) {
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final Node atom2 = this.atom;
                                            final int n11 = n;
                                            BytecodeManager.incBytecodes(6);
                                            final boolean match2 = atom2.match(matcher, n11, charSequence);
                                            BytecodeManager.incBytecodes(1);
                                            if (match2) {
                                                i = n + n8;
                                                last = matcher.last;
                                                BytecodeManager.incBytecodes(6);
                                                continue;
                                            }
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        while (true) {
                                            final int n12 = n2;
                                            final int n13 = n3;
                                            BytecodeManager.incBytecodes(3);
                                            if (n12 <= n13) {
                                                break Label_0517;
                                            }
                                            final Node next = this.next;
                                            final int n14 = n;
                                            BytecodeManager.incBytecodes(6);
                                            final boolean match3 = next.match(matcher, n14, charSequence);
                                            BytecodeManager.incBytecodes(1);
                                            if (match3) {
                                                final boolean capture4 = this.capture;
                                                BytecodeManager.incBytecodes(3);
                                                if (capture4) {
                                                    groups[this.groupIndex + 1] = n;
                                                    BytecodeManager.incBytecodes(7);
                                                    groups[this.groupIndex] = n - n8;
                                                    BytecodeManager.incBytecodes(7);
                                                }
                                                final boolean b = true;
                                                BytecodeManager.incBytecodes(2);
                                                return b;
                                            }
                                            n -= n8;
                                            BytecodeManager.incBytecodes(4);
                                            final boolean capture5 = this.capture;
                                            BytecodeManager.incBytecodes(3);
                                            if (capture5) {
                                                groups[this.groupIndex + 1] = n;
                                                BytecodeManager.incBytecodes(7);
                                                groups[this.groupIndex] = n - n8;
                                                BytecodeManager.incBytecodes(7);
                                            }
                                            --n2;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                    } while (i == last);
                                    final int n15 = n;
                                    final int n16 = n2;
                                    BytecodeManager.incBytecodes(6);
                                    final boolean match4 = this.match0(matcher, n15, n16, charSequence);
                                    BytecodeManager.incBytecodes(1);
                                    if (match4) {
                                        final boolean b2 = true;
                                        BytecodeManager.incBytecodes(2);
                                        return b2;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                }
                final boolean capture6 = this.capture;
                BytecodeManager.incBytecodes(3);
                if (capture6) {
                    groups[this.groupIndex] = n4;
                    BytecodeManager.incBytecodes(5);
                    groups[this.groupIndex + 1] = n5;
                    BytecodeManager.incBytecodes(7);
                }
                final Node next2 = this.next;
                final int n17 = n;
                BytecodeManager.incBytecodes(6);
                final boolean match5 = next2.match(matcher, n17, charSequence);
                BytecodeManager.incBytecodes(1);
                return match5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean match1(final Matcher matcher, int last, int n, final CharSequence charSequence) {
            try {
                while (true) {
                    final Node next = this.next;
                    final int n2 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n2, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (match) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int n3 = n;
                    final int cmax = this.cmax;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= cmax) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Node atom = this.atom;
                    final int n4 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match2 = atom.match(matcher, n4, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (!match2) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final int n5 = last;
                    final int last2 = matcher.last;
                    BytecodeManager.incBytecodes(4);
                    if (n5 == last2) {
                        final boolean b4 = false;
                        BytecodeManager.incBytecodes(2);
                        return b4;
                    }
                    final boolean capture = this.capture;
                    BytecodeManager.incBytecodes(3);
                    if (capture) {
                        matcher.groups[this.groupIndex] = last;
                        BytecodeManager.incBytecodes(6);
                        matcher.groups[this.groupIndex + 1] = matcher.last;
                        BytecodeManager.incBytecodes(9);
                    }
                    last = matcher.last;
                    BytecodeManager.incBytecodes(3);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean match2(final Matcher matcher, int last, int n, final CharSequence charSequence) {
            try {
                while (true) {
                    final int n2 = n;
                    final int cmax = this.cmax;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= cmax) {
                        break;
                    }
                    final Node atom = this.atom;
                    final int n3 = last;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = atom.match(matcher, n3, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (!match) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final boolean capture = this.capture;
                    BytecodeManager.incBytecodes(3);
                    if (capture) {
                        matcher.groups[this.groupIndex] = last;
                        BytecodeManager.incBytecodes(6);
                        matcher.groups[this.groupIndex + 1] = matcher.last;
                        BytecodeManager.incBytecodes(9);
                    }
                    final int n4 = last;
                    final int last2 = matcher.last;
                    BytecodeManager.incBytecodes(4);
                    if (n4 == last2) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    last = matcher.last;
                    BytecodeManager.incBytecodes(3);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final Node next = this.next;
                final int n5 = last;
                BytecodeManager.incBytecodes(6);
                final boolean match2 = next.match(matcher, n5, charSequence);
                BytecodeManager.incBytecodes(1);
                return match2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final int minLength = treeInfo.minLength;
                BytecodeManager.incBytecodes(3);
                final int maxLength = treeInfo.maxLength;
                BytecodeManager.incBytecodes(3);
                final boolean maxValid = treeInfo.maxValid;
                BytecodeManager.incBytecodes(3);
                final boolean deterministic = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                treeInfo.reset();
                final Node atom = this.atom;
                BytecodeManager.incBytecodes(4);
                atom.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                int minLength2 = treeInfo.minLength * this.cmin + minLength;
                BytecodeManager.incBytecodes(8);
                final int n = minLength2;
                final int n2 = minLength;
                BytecodeManager.incBytecodes(3);
                if (n < n2) {
                    minLength2 = 268435455;
                    BytecodeManager.incBytecodes(2);
                }
                treeInfo.minLength = minLength2;
                BytecodeManager.incBytecodes(3);
                final boolean b = maxValid & treeInfo.maxValid;
                BytecodeManager.incBytecodes(5);
                if (b) {
                    final int maxLength2 = treeInfo.maxLength * this.cmax + maxLength;
                    BytecodeManager.incBytecodes(8);
                    treeInfo.maxLength = maxLength2;
                    BytecodeManager.incBytecodes(3);
                    final int n3 = maxLength2;
                    final int n4 = maxLength;
                    BytecodeManager.incBytecodes(3);
                    if (n3 < n4) {
                        treeInfo.maxValid = false;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                else {
                    treeInfo.maxValid = false;
                    BytecodeManager.incBytecodes(3);
                }
                final boolean deterministic2 = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                Label_0249: {
                    if (deterministic2) {
                        final int cmin = this.cmin;
                        final int cmax = this.cmax;
                        BytecodeManager.incBytecodes(5);
                        if (cmin == cmax) {
                            treeInfo.deterministic = deterministic;
                            BytecodeManager.incBytecodes(4);
                            break Label_0249;
                        }
                    }
                    treeInfo.deterministic = false;
                    BytecodeManager.incBytecodes(3);
                }
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class BranchConn extends Node
    {
        BranchConn() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match = next.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final boolean deterministic = treeInfo.deterministic;
                BytecodeManager.incBytecodes(3);
                return deterministic;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Branch extends Node
    {
        Node[] atoms;
        int size;
        Node conn;
        
        Branch(final Node node, final Node node2, final Node conn) {
            try {
                BytecodeManager.incBytecodes(2);
                this.atoms = new Node[2];
                BytecodeManager.incBytecodes(3);
                this.size = 2;
                BytecodeManager.incBytecodes(3);
                this.conn = conn;
                BytecodeManager.incBytecodes(3);
                this.atoms[0] = node;
                BytecodeManager.incBytecodes(5);
                this.atoms[1] = node2;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void add(final Node node) {
            try {
                final int size = this.size;
                final int length = this.atoms.length;
                BytecodeManager.incBytecodes(6);
                if (size >= length) {
                    final Node[] atoms = new Node[this.atoms.length * 2];
                    BytecodeManager.incBytecodes(6);
                    final Node[] atoms2 = this.atoms;
                    final int n = 0;
                    final Node[] array = atoms;
                    final int n2 = 0;
                    final int length2 = this.atoms.length;
                    BytecodeManager.incBytecodes(9);
                    System.arraycopy(atoms2, n, array, n2, length2);
                    this.atoms = atoms;
                    BytecodeManager.incBytecodes(3);
                }
                this.atoms[this.size++] = node;
                BytecodeManager.incBytecodes(11);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= size) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Node node = this.atoms[n2];
                    BytecodeManager.incBytecodes(5);
                    if (node == null) {
                        final Node next = this.conn.next;
                        BytecodeManager.incBytecodes(7);
                        final boolean match = next.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match) {
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                    else {
                        final Node node2 = this.atoms[n2];
                        BytecodeManager.incBytecodes(8);
                        final boolean match2 = node2.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match2) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final int minLength = treeInfo.minLength;
                BytecodeManager.incBytecodes(3);
                final int maxLength = treeInfo.maxLength;
                BytecodeManager.incBytecodes(3);
                boolean maxValid = treeInfo.maxValid;
                BytecodeManager.incBytecodes(3);
                int min = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
                int max = -1;
                BytecodeManager.incBytecodes(2);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= size) {
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    treeInfo.reset();
                    final Node node = this.atoms[n];
                    BytecodeManager.incBytecodes(5);
                    if (node != null) {
                        final Node node2 = this.atoms[n];
                        BytecodeManager.incBytecodes(6);
                        node2.study(treeInfo);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int a = min;
                    final int minLength2 = treeInfo.minLength;
                    BytecodeManager.incBytecodes(4);
                    min = Math.min(a, minLength2);
                    BytecodeManager.incBytecodes(1);
                    final int a2 = max;
                    final int maxLength2 = treeInfo.maxLength;
                    BytecodeManager.incBytecodes(4);
                    max = Math.max(a2, maxLength2);
                    BytecodeManager.incBytecodes(1);
                    maxValid &= treeInfo.maxValid;
                    BytecodeManager.incBytecodes(5);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final int n3 = minLength + min;
                BytecodeManager.incBytecodes(4);
                final int n4 = maxLength + max;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                treeInfo.reset();
                final Node next = this.conn.next;
                BytecodeManager.incBytecodes(5);
                next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                treeInfo.minLength += n3;
                BytecodeManager.incBytecodes(6);
                treeInfo.maxLength += n4;
                BytecodeManager.incBytecodes(6);
                treeInfo.maxValid &= maxValid;
                BytecodeManager.incBytecodes(6);
                treeInfo.deterministic = false;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class GroupHead extends Node
    {
        int localIndex;
        
        GroupHead(final int localIndex) {
            try {
                BytecodeManager.incBytecodes(2);
                this.localIndex = localIndex;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int n2 = matcher.locals[this.localIndex];
                BytecodeManager.incBytecodes(6);
                matcher.locals[this.localIndex] = n;
                BytecodeManager.incBytecodes(6);
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match = next.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                matcher.locals[this.localIndex] = n2;
                BytecodeManager.incBytecodes(6);
                final boolean b = match;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean matchRef(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int n2 = matcher.locals[this.localIndex];
                BytecodeManager.incBytecodes(6);
                matcher.locals[this.localIndex] = ~n;
                BytecodeManager.incBytecodes(8);
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match = next.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                matcher.locals[this.localIndex] = n2;
                BytecodeManager.incBytecodes(6);
                final boolean b = match;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class GroupRef extends Node
    {
        GroupHead head;
        
        GroupRef(final GroupHead head) {
            try {
                BytecodeManager.incBytecodes(2);
                this.head = head;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final GroupHead head = this.head;
                BytecodeManager.incBytecodes(6);
                final boolean matchRef = head.matchRef(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0069: {
                    if (matchRef) {
                        final Node next = this.next;
                        final int last = matcher.last;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        final boolean match = next.match(matcher, last, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0069;
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
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                treeInfo.deterministic = false;
                BytecodeManager.incBytecodes(3);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class GroupTail extends Node
    {
        int localIndex;
        int groupIndex;
        
        GroupTail(final int localIndex, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.localIndex = localIndex;
                BytecodeManager.incBytecodes(3);
                this.groupIndex = n + n;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int last, final CharSequence charSequence) {
            try {
                final int n = matcher.locals[this.localIndex];
                BytecodeManager.incBytecodes(6);
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    matcher.last = last;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n3 = matcher.groups[this.groupIndex];
                BytecodeManager.incBytecodes(6);
                final int n4 = matcher.groups[this.groupIndex + 1];
                BytecodeManager.incBytecodes(8);
                matcher.groups[this.groupIndex] = n;
                BytecodeManager.incBytecodes(6);
                matcher.groups[this.groupIndex + 1] = last;
                BytecodeManager.incBytecodes(8);
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match = next.match(matcher, last, charSequence);
                BytecodeManager.incBytecodes(1);
                if (match) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                matcher.groups[this.groupIndex] = n3;
                BytecodeManager.incBytecodes(6);
                matcher.groups[this.groupIndex + 1] = n4;
                BytecodeManager.incBytecodes(8);
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Prolog extends Node
    {
        Loop loop;
        
        Prolog(final Loop loop) {
            try {
                BytecodeManager.incBytecodes(2);
                this.loop = loop;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final Loop loop = this.loop;
                BytecodeManager.incBytecodes(6);
                final boolean matchInit = loop.matchInit(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return matchInit;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final Loop loop = this.loop;
                BytecodeManager.incBytecodes(4);
                final boolean study = loop.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class Loop extends Node
    {
        Node body;
        int countIndex;
        int beginIndex;
        int cmin;
        int cmax;
        
        Loop(final int countIndex, final int beginIndex) {
            try {
                BytecodeManager.incBytecodes(2);
                this.countIndex = countIndex;
                BytecodeManager.incBytecodes(3);
                this.beginIndex = beginIndex;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int n2 = matcher.locals[this.beginIndex];
                BytecodeManager.incBytecodes(7);
                if (n > n2) {
                    final int n3 = matcher.locals[this.countIndex];
                    BytecodeManager.incBytecodes(6);
                    final int n4 = n3;
                    final int cmin = this.cmin;
                    BytecodeManager.incBytecodes(4);
                    if (n4 < cmin) {
                        matcher.locals[this.countIndex] = n3 + 1;
                        BytecodeManager.incBytecodes(8);
                        final Node body = this.body;
                        BytecodeManager.incBytecodes(6);
                        final boolean match = body.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        final boolean b = match;
                        BytecodeManager.incBytecodes(2);
                        if (!b) {
                            matcher.locals[this.countIndex] = n3;
                            BytecodeManager.incBytecodes(6);
                        }
                        final boolean b2 = match;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final int n5 = n3;
                    final int cmax = this.cmax;
                    BytecodeManager.incBytecodes(4);
                    if (n5 < cmax) {
                        matcher.locals[this.countIndex] = n3 + 1;
                        BytecodeManager.incBytecodes(8);
                        final Node body2 = this.body;
                        BytecodeManager.incBytecodes(6);
                        final boolean match2 = body2.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        final boolean b3 = match2;
                        BytecodeManager.incBytecodes(2);
                        if (b3) {
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                        matcher.locals[this.countIndex] = n3;
                        BytecodeManager.incBytecodes(7);
                    }
                }
                final Node next = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match3 = next.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean matchInit(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int n2 = matcher.locals[this.countIndex];
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(2);
                final int n3 = 0;
                final int cmin = this.cmin;
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (n3 < cmin) {
                    matcher.locals[this.countIndex] = 1;
                    BytecodeManager.incBytecodes(6);
                    final Node body = this.body;
                    BytecodeManager.incBytecodes(6);
                    b = body.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int n4 = 0;
                    final int cmax = this.cmax;
                    BytecodeManager.incBytecodes(4);
                    if (n4 < cmax) {
                        matcher.locals[this.countIndex] = 1;
                        BytecodeManager.incBytecodes(6);
                        final Node body2 = this.body;
                        BytecodeManager.incBytecodes(6);
                        b = body2.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        final boolean b2 = b;
                        BytecodeManager.incBytecodes(2);
                        if (!b2) {
                            final Node next = this.next;
                            BytecodeManager.incBytecodes(6);
                            b = next.match(matcher, n, charSequence);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    else {
                        final Node next2 = this.next;
                        BytecodeManager.incBytecodes(6);
                        b = next2.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                matcher.locals[this.countIndex] = n2;
                BytecodeManager.incBytecodes(6);
                final boolean b3 = b;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                treeInfo.deterministic = false;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LazyLoop extends Loop
    {
        LazyLoop(final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(4);
                super(n, n2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int n2 = matcher.locals[this.beginIndex];
                BytecodeManager.incBytecodes(7);
                if (n <= n2) {
                    final Node next = this.next;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(1);
                    return match;
                }
                final int n3 = matcher.locals[this.countIndex];
                BytecodeManager.incBytecodes(6);
                final int n4 = n3;
                final int cmin = this.cmin;
                BytecodeManager.incBytecodes(4);
                if (n4 < cmin) {
                    matcher.locals[this.countIndex] = n3 + 1;
                    BytecodeManager.incBytecodes(8);
                    final Node body = this.body;
                    BytecodeManager.incBytecodes(6);
                    final boolean match2 = body.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(1);
                    final boolean b = match2;
                    BytecodeManager.incBytecodes(2);
                    if (!b) {
                        matcher.locals[this.countIndex] = n3;
                        BytecodeManager.incBytecodes(6);
                    }
                    final boolean b2 = match2;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Node next2 = this.next;
                BytecodeManager.incBytecodes(6);
                final boolean match3 = next2.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                if (match3) {
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                final int n5 = n3;
                final int cmax = this.cmax;
                BytecodeManager.incBytecodes(4);
                if (n5 < cmax) {
                    matcher.locals[this.countIndex] = n3 + 1;
                    BytecodeManager.incBytecodes(8);
                    final Node body2 = this.body;
                    BytecodeManager.incBytecodes(6);
                    final boolean match4 = body2.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(1);
                    final boolean b4 = match4;
                    BytecodeManager.incBytecodes(2);
                    if (!b4) {
                        matcher.locals[this.countIndex] = n3;
                        BytecodeManager.incBytecodes(6);
                    }
                    final boolean b5 = match4;
                    BytecodeManager.incBytecodes(2);
                    return b5;
                }
                final boolean b6 = false;
                BytecodeManager.incBytecodes(2);
                return b6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean matchInit(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int n2 = matcher.locals[this.countIndex];
                BytecodeManager.incBytecodes(6);
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                final int n3 = 0;
                final int cmin = this.cmin;
                BytecodeManager.incBytecodes(4);
                if (n3 < cmin) {
                    matcher.locals[this.countIndex] = 1;
                    BytecodeManager.incBytecodes(6);
                    final Node body = this.body;
                    BytecodeManager.incBytecodes(6);
                    b = body.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Node next = this.next;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = next.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (match) {
                        b = true;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final int n4 = 0;
                        final int cmax = this.cmax;
                        BytecodeManager.incBytecodes(4);
                        if (n4 < cmax) {
                            matcher.locals[this.countIndex] = 1;
                            BytecodeManager.incBytecodes(6);
                            final Node body2 = this.body;
                            BytecodeManager.incBytecodes(6);
                            b = body2.match(matcher, n, charSequence);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                matcher.locals[this.countIndex] = n2;
                BytecodeManager.incBytecodes(6);
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                treeInfo.deterministic = false;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class BackRef extends Node
    {
        int groupIndex;
        
        BackRef(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.groupIndex = n + n;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final int n2 = matcher.groups[this.groupIndex];
                BytecodeManager.incBytecodes(6);
                final int n3 = matcher.groups[this.groupIndex + 1];
                BytecodeManager.incBytecodes(8);
                final int n4 = n3 - n2;
                BytecodeManager.incBytecodes(4);
                final int n5 = n2;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n6 = n + n4;
                final int to = matcher.to;
                BytecodeManager.incBytecodes(6);
                if (n6 > to) {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                int n7 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n8 = n7;
                    final int n9 = n4;
                    BytecodeManager.incBytecodes(3);
                    if (n8 >= n9) {
                        final Node next = this.next;
                        final int n10 = n + n4;
                        BytecodeManager.incBytecodes(8);
                        final boolean match = next.match(matcher, n10, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                    final int n11 = n + n7;
                    BytecodeManager.incBytecodes(5);
                    final char char1 = charSequence.charAt(n11);
                    final int n12 = n2 + n7;
                    BytecodeManager.incBytecodes(5);
                    final char char2 = charSequence.charAt(n12);
                    BytecodeManager.incBytecodes(1);
                    if (char1 != char2) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    ++n7;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CIBackRef extends Node
    {
        int groupIndex;
        boolean doUnicodeCase;
        
        CIBackRef(final int n, final boolean doUnicodeCase) {
            try {
                BytecodeManager.incBytecodes(2);
                this.groupIndex = n + n;
                BytecodeManager.incBytecodes(5);
                this.doUnicodeCase = doUnicodeCase;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                int n2 = matcher.groups[this.groupIndex];
                BytecodeManager.incBytecodes(6);
                final int n3 = matcher.groups[this.groupIndex + 1];
                BytecodeManager.incBytecodes(8);
                final int n4 = n3 - n2;
                BytecodeManager.incBytecodes(4);
                final int n5 = n2;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n6 = n + n4;
                final int to = matcher.to;
                BytecodeManager.incBytecodes(6);
                if (n6 > to) {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                int n7 = n;
                BytecodeManager.incBytecodes(2);
                int n8 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n9 = n8;
                    final int n10 = n4;
                    BytecodeManager.incBytecodes(3);
                    if (n9 >= n10) {
                        final Node next = this.next;
                        final int n11 = n + n4;
                        BytecodeManager.incBytecodes(8);
                        final boolean match = next.match(matcher, n11, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match;
                    }
                    final int index = n7;
                    BytecodeManager.incBytecodes(3);
                    final int codePoint = Character.codePointAt(charSequence, index);
                    BytecodeManager.incBytecodes(1);
                    final int index2 = n2;
                    BytecodeManager.incBytecodes(3);
                    final int codePoint2 = Character.codePointAt(charSequence, index2);
                    BytecodeManager.incBytecodes(1);
                    final int n12 = codePoint;
                    final int n13 = codePoint2;
                    BytecodeManager.incBytecodes(3);
                    if (n12 != n13) {
                        final boolean doUnicodeCase = this.doUnicodeCase;
                        BytecodeManager.incBytecodes(3);
                        if (doUnicodeCase) {
                            final int codePoint3 = codePoint;
                            BytecodeManager.incBytecodes(2);
                            final int upperCase = Character.toUpperCase(codePoint3);
                            BytecodeManager.incBytecodes(1);
                            final int codePoint4 = codePoint2;
                            BytecodeManager.incBytecodes(2);
                            final int upperCase2 = Character.toUpperCase(codePoint4);
                            BytecodeManager.incBytecodes(1);
                            final int n14 = upperCase;
                            final int n15 = upperCase2;
                            BytecodeManager.incBytecodes(3);
                            if (n14 != n15) {
                                final int codePoint5 = upperCase;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final int lowerCase = Character.toLowerCase(codePoint5);
                                final int codePoint6 = upperCase2;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final int lowerCase2 = Character.toLowerCase(codePoint6);
                                BytecodeManager.incBytecodes(1);
                                if (lowerCase != lowerCase2) {
                                    final boolean b3 = false;
                                    BytecodeManager.incBytecodes(2);
                                    return b3;
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int n16 = codePoint;
                            BytecodeManager.incBytecodes(2);
                            final int lower = ASCII.toLower(n16);
                            final int n17 = codePoint2;
                            BytecodeManager.incBytecodes(2);
                            final int lower2 = ASCII.toLower(n17);
                            BytecodeManager.incBytecodes(1);
                            if (lower != lower2) {
                                final boolean b4 = false;
                                BytecodeManager.incBytecodes(2);
                                return b4;
                            }
                        }
                    }
                    final int n18 = n7;
                    final int codePoint7 = codePoint;
                    BytecodeManager.incBytecodes(3);
                    n7 = n18 + Character.charCount(codePoint7);
                    BytecodeManager.incBytecodes(2);
                    final int n19 = n2;
                    final int codePoint8 = codePoint2;
                    BytecodeManager.incBytecodes(3);
                    n2 = n19 + Character.charCount(codePoint8);
                    BytecodeManager.incBytecodes(2);
                    ++n8;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class First extends Node
    {
        Node atom;
        
        First(final Node node) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.atom = BnM.optimize(node);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int n, final CharSequence charSequence) {
            try {
                final boolean b = this.atom instanceof BnM;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final Node atom = this.atom;
                    final int n2 = n;
                    BytecodeManager.incBytecodes(6);
                    final boolean match = atom.match(matcher, n2, charSequence);
                    BytecodeManager.incBytecodes(1);
                    boolean b2 = false;
                    Label_0084: {
                        if (match) {
                            final Node next = this.next;
                            final int last = matcher.last;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final boolean match2 = next.match(matcher, last, charSequence);
                            BytecodeManager.incBytecodes(1);
                            if (match2) {
                                b2 = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0084;
                            }
                        }
                        b2 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b2;
                }
                while (true) {
                    final int n3 = n;
                    final int to = matcher.to;
                    BytecodeManager.incBytecodes(4);
                    if (n3 > to) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final Node atom2 = this.atom;
                    final int n4 = n;
                    BytecodeManager.incBytecodes(6);
                    final boolean match3 = atom2.match(matcher, n4, charSequence);
                    BytecodeManager.incBytecodes(1);
                    if (match3) {
                        final Node next2 = this.next;
                        final int last2 = matcher.last;
                        BytecodeManager.incBytecodes(7);
                        final boolean match4 = next2.match(matcher, last2, charSequence);
                        BytecodeManager.incBytecodes(1);
                        return match4;
                    }
                    final int n5 = n;
                    final int n6 = n;
                    final int n7 = 1;
                    BytecodeManager.incBytecodes(5);
                    n = n5 + Pattern.access$300(charSequence, n6, n7);
                    BytecodeManager.incBytecodes(2);
                    ++matcher.first;
                    BytecodeManager.incBytecodes(7);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final Node atom = this.atom;
                BytecodeManager.incBytecodes(4);
                atom.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                treeInfo.deterministic = false;
                BytecodeManager.incBytecodes(3);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Conditional extends Node
    {
        Node cond;
        Node yes;
        Node not;
        
        Conditional(final Node cond, final Node yes, final Node not) {
            try {
                BytecodeManager.incBytecodes(2);
                this.cond = cond;
                BytecodeManager.incBytecodes(3);
                this.yes = yes;
                BytecodeManager.incBytecodes(3);
                this.not = not;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                final Node cond = this.cond;
                BytecodeManager.incBytecodes(6);
                final boolean match = cond.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                if (match) {
                    final Node yes = this.yes;
                    BytecodeManager.incBytecodes(6);
                    final boolean match2 = yes.match(matcher, n, charSequence);
                    BytecodeManager.incBytecodes(1);
                    return match2;
                }
                final Node not = this.not;
                BytecodeManager.incBytecodes(6);
                final boolean match3 = not.match(matcher, n, charSequence);
                BytecodeManager.incBytecodes(1);
                return match3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                final int minLength = treeInfo.minLength;
                BytecodeManager.incBytecodes(3);
                final int maxLength = treeInfo.maxLength;
                BytecodeManager.incBytecodes(3);
                final boolean maxValid = treeInfo.maxValid;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                treeInfo.reset();
                final Node yes = this.yes;
                BytecodeManager.incBytecodes(4);
                yes.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                final int minLength2 = treeInfo.minLength;
                BytecodeManager.incBytecodes(3);
                final int maxLength2 = treeInfo.maxLength;
                BytecodeManager.incBytecodes(3);
                final boolean maxValid2 = treeInfo.maxValid;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                treeInfo.reset();
                final Node not = this.not;
                BytecodeManager.incBytecodes(4);
                not.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                final int n = minLength;
                final int a = minLength2;
                final int minLength3 = treeInfo.minLength;
                BytecodeManager.incBytecodes(6);
                treeInfo.minLength = n + Math.min(a, minLength3);
                BytecodeManager.incBytecodes(2);
                final int n2 = maxLength;
                final int a2 = maxLength2;
                final int maxLength3 = treeInfo.maxLength;
                BytecodeManager.incBytecodes(6);
                treeInfo.maxLength = n2 + Math.max(a2, maxLength3);
                BytecodeManager.incBytecodes(2);
                treeInfo.maxValid &= (maxValid & maxValid2);
                BytecodeManager.incBytecodes(8);
                treeInfo.deterministic = false;
                BytecodeManager.incBytecodes(3);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Pos extends Node
    {
        Node cond;
        
        Pos(final Node cond) {
            try {
                BytecodeManager.incBytecodes(2);
                this.cond = cond;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher p0, final int p1, final CharSequence p2) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     4: istore          4
            //     6: ldc             3
            //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    11: iconst_0       
            //    12: istore          5
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: aload_1        
            //    20: getfield        instrumented/java/util/regex/Matcher.transparentBounds:Z
            //    23: ldc             3
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: ifeq            49
            //    31: aload_1        
            //    32: aload_1        
            //    33: ldc             3
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: invokevirtual   instrumented/java/util/regex/Matcher.getTextLength:()I
            //    41: putfield        instrumented/java/util/regex/Matcher.to:I
            //    44: ldc             1
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: aload_0        
            //    50: getfield        instrumented/java/util/regex/Pattern$Pos.cond:Linstrumented/java/util/regex/Pattern$Node;
            //    53: aload_1        
            //    54: iload_2        
            //    55: aload_3        
            //    56: ldc             6
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: invokevirtual   instrumented/java/util/regex/Pattern$Node.match:(Linstrumented/java/util/regex/Matcher;ILjava/lang/CharSequence;)Z
            //    64: istore          5
            //    66: ldc             1
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: aload_1        
            //    72: iload           4
            //    74: putfield        instrumented/java/util/regex/Matcher.to:I
            //    77: ldc             3
            //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    82: ldc             1
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: goto            111
            //    90: astore          6
            //    92: ldc             501
            //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    97: aload_1        
            //    98: iload           4
            //   100: putfield        instrumented/java/util/regex/Matcher.to:I
            //   103: aload           6
            //   105: ldc             5
            //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   110: athrow         
            //   111: iload           5
            //   113: ldc             2
            //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   118: ifeq            153
            //   121: aload_0        
            //   122: getfield        instrumented/java/util/regex/Pattern$Pos.next:Linstrumented/java/util/regex/Pattern$Node;
            //   125: aload_1        
            //   126: iload_2        
            //   127: aload_3        
            //   128: ldc             6
            //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   133: invokevirtual   instrumented/java/util/regex/Pattern$Node.match:(Linstrumented/java/util/regex/Matcher;ILjava/lang/CharSequence;)Z
            //   136: ldc             1
            //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   141: ifeq            153
            //   144: iconst_1       
            //   145: ldc             2
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: goto            159
            //   153: iconst_0       
            //   154: ldc             1
            //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   159: ldc             1
            //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   164: ireturn        
            //   165: athrow         
            //   166: athrow         
            //    StackMapTable: 00 07 FD 00 31 01 01 68 07 00 1D 14 29 45 01 FF 00 05 00 00 00 01 07 00 1D FF 00 00 00 00 00 01 07 00 21
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  49     166    166    167    Ljava/lang/VirtualMachineError;
            //  49     71     90     111    Any
            //  90     97     90     111    Any
            //  0      165    165    166    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0049:
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
    
    static final class Neg extends Node
    {
        Node cond;
        
        Neg(final Node cond) {
            try {
                BytecodeManager.incBytecodes(2);
                this.cond = cond;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher p0, final int p1, final CharSequence p2) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     4: istore          4
            //     6: ldc             3
            //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    11: iconst_0       
            //    12: istore          5
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: aload_1        
            //    20: getfield        instrumented/java/util/regex/Matcher.transparentBounds:Z
            //    23: ldc             3
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: ifeq            49
            //    31: aload_1        
            //    32: aload_1        
            //    33: ldc             3
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: invokevirtual   instrumented/java/util/regex/Matcher.getTextLength:()I
            //    41: putfield        instrumented/java/util/regex/Matcher.to:I
            //    44: ldc             1
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: iload_2        
            //    50: aload_1        
            //    51: getfield        instrumented/java/util/regex/Matcher.to:I
            //    54: ldc             4
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: if_icmpge       110
            //    62: aload_0        
            //    63: getfield        instrumented/java/util/regex/Pattern$Neg.cond:Linstrumented/java/util/regex/Pattern$Node;
            //    66: aload_1        
            //    67: iload_2        
            //    68: aload_3        
            //    69: ldc             6
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: invokevirtual   instrumented/java/util/regex/Pattern$Node.match:(Linstrumented/java/util/regex/Matcher;ILjava/lang/CharSequence;)Z
            //    77: ldc             1
            //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    82: ifne            94
            //    85: iconst_1       
            //    86: ldc             2
            //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    91: goto            100
            //    94: iconst_0       
            //    95: ldc             1
            //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   100: istore          5
            //   102: ldc             2
            //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   107: goto            165
            //   110: aload_1        
            //   111: iconst_1       
            //   112: putfield        instrumented/java/util/regex/Matcher.requireEnd:Z
            //   115: ldc             3
            //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   120: aload_0        
            //   121: getfield        instrumented/java/util/regex/Pattern$Neg.cond:Linstrumented/java/util/regex/Pattern$Node;
            //   124: aload_1        
            //   125: iload_2        
            //   126: aload_3        
            //   127: ldc             6
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: invokevirtual   instrumented/java/util/regex/Pattern$Node.match:(Linstrumented/java/util/regex/Matcher;ILjava/lang/CharSequence;)Z
            //   135: ldc             1
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: ifne            152
            //   143: iconst_1       
            //   144: ldc             2
            //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   149: goto            158
            //   152: iconst_0       
            //   153: ldc             1
            //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   158: istore          5
            //   160: ldc             1
            //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   165: aload_1        
            //   166: iload           4
            //   168: putfield        instrumented/java/util/regex/Matcher.to:I
            //   171: ldc             3
            //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   176: ldc             1
            //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   181: goto            205
            //   184: astore          6
            //   186: ldc             501
            //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   191: aload_1        
            //   192: iload           4
            //   194: putfield        instrumented/java/util/regex/Matcher.to:I
            //   197: aload           6
            //   199: ldc             5
            //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   204: athrow         
            //   205: iload           5
            //   207: ldc             2
            //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   212: ifeq            247
            //   215: aload_0        
            //   216: getfield        instrumented/java/util/regex/Pattern$Neg.next:Linstrumented/java/util/regex/Pattern$Node;
            //   219: aload_1        
            //   220: iload_2        
            //   221: aload_3        
            //   222: ldc             6
            //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   227: invokevirtual   instrumented/java/util/regex/Pattern$Node.match:(Linstrumented/java/util/regex/Matcher;ILjava/lang/CharSequence;)Z
            //   230: ldc             1
            //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   235: ifeq            247
            //   238: iconst_1       
            //   239: ldc             2
            //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   244: goto            253
            //   247: iconst_0       
            //   248: ldc             1
            //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   253: ldc             1
            //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   258: ireturn        
            //   259: athrow         
            //   260: athrow         
            //    StackMapTable: 00 0D FD 00 31 01 01 2C 45 01 09 29 45 01 06 52 07 00 1D 14 29 45 01 FF 00 05 00 00 00 01 07 00 1D FF 00 00 00 00 00 01 07 00 21
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  49     260    260    261    Ljava/lang/VirtualMachineError;
            //  49     165    184    205    Any
            //  184    191    184    205    Any
            //  0      259    259    260    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0049:
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
    
    static class Behind extends Node
    {
        Node cond;
        int rmax;
        int rmin;
        
        Behind(final Node cond, final int rmax, final int rmin) {
            try {
                BytecodeManager.incBytecodes(2);
                this.cond = cond;
                BytecodeManager.incBytecodes(3);
                this.rmax = rmax;
                BytecodeManager.incBytecodes(3);
                this.rmin = rmin;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int lookbehindTo, final CharSequence charSequence) {
            try {
                final int from = matcher.from;
                BytecodeManager.incBytecodes(3);
                boolean match = false;
                BytecodeManager.incBytecodes(2);
                final boolean transparentBounds = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                int from2;
                if (!transparentBounds) {
                    from2 = matcher.from;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    from2 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n = from2;
                BytecodeManager.incBytecodes(1);
                final int a = lookbehindTo - this.rmax;
                final int b = n;
                BytecodeManager.incBytecodes(6);
                final int max = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
                final int lookbehindTo2 = matcher.lookbehindTo;
                BytecodeManager.incBytecodes(3);
                matcher.lookbehindTo = lookbehindTo;
                BytecodeManager.incBytecodes(3);
                final boolean transparentBounds2 = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                if (transparentBounds2) {
                    matcher.from = 0;
                    BytecodeManager.incBytecodes(3);
                }
                int n2 = lookbehindTo - this.rmin;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final boolean b2 = match;
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        break;
                    }
                    final int n3 = n2;
                    final int n4 = max;
                    BytecodeManager.incBytecodes(3);
                    if (n3 < n4) {
                        break;
                    }
                    final Node cond = this.cond;
                    final int n5 = n2;
                    BytecodeManager.incBytecodes(6);
                    match = cond.match(matcher, n5, charSequence);
                    BytecodeManager.incBytecodes(1);
                    --n2;
                    BytecodeManager.incBytecodes(2);
                }
                matcher.from = from;
                BytecodeManager.incBytecodes(3);
                matcher.lookbehindTo = lookbehindTo2;
                BytecodeManager.incBytecodes(3);
                final boolean b3 = match;
                BytecodeManager.incBytecodes(2);
                boolean b4 = false;
                Label_0261: {
                    if (b3) {
                        final Node next = this.next;
                        BytecodeManager.incBytecodes(6);
                        final boolean match2 = next.match(matcher, lookbehindTo, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match2) {
                            b4 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0261;
                        }
                    }
                    b4 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class BehindS extends Behind
    {
        BehindS(final Node node, final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(5);
                super(node, n, n2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int lookbehindTo, final CharSequence charSequence) {
            try {
                final int n = -this.rmax;
                BytecodeManager.incBytecodes(6);
                final int access$300 = Pattern.access$300(charSequence, lookbehindTo, n);
                BytecodeManager.incBytecodes(1);
                final int n2 = -this.rmin;
                BytecodeManager.incBytecodes(6);
                final int access$301 = Pattern.access$300(charSequence, lookbehindTo, n2);
                BytecodeManager.incBytecodes(1);
                final int from = matcher.from;
                BytecodeManager.incBytecodes(3);
                final boolean transparentBounds = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                int from2;
                if (!transparentBounds) {
                    from2 = matcher.from;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    from2 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n3 = from2;
                BytecodeManager.incBytecodes(1);
                boolean match = false;
                BytecodeManager.incBytecodes(2);
                final int a = lookbehindTo - access$300;
                final int b = n3;
                BytecodeManager.incBytecodes(5);
                final int max = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
                final int lookbehindTo2 = matcher.lookbehindTo;
                BytecodeManager.incBytecodes(3);
                matcher.lookbehindTo = lookbehindTo;
                BytecodeManager.incBytecodes(3);
                final boolean transparentBounds2 = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                if (transparentBounds2) {
                    matcher.from = 0;
                    BytecodeManager.incBytecodes(3);
                }
                int n4 = lookbehindTo - access$301;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final boolean b2 = match;
                    BytecodeManager.incBytecodes(2);
                    if (b2) {
                        break;
                    }
                    final int n5 = n4;
                    final int n6 = max;
                    BytecodeManager.incBytecodes(3);
                    if (n5 < n6) {
                        break;
                    }
                    final Node cond = this.cond;
                    final int n7 = n4;
                    BytecodeManager.incBytecodes(6);
                    match = cond.match(matcher, n7, charSequence);
                    BytecodeManager.incBytecodes(1);
                    final int n8 = n4;
                    final int n9 = n4;
                    final int n10 = max;
                    BytecodeManager.incBytecodes(4);
                    int access$302;
                    if (n9 > n10) {
                        final int n11 = n4;
                        final int n12 = -1;
                        BytecodeManager.incBytecodes(4);
                        access$302 = Pattern.access$300(charSequence, n11, n12);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        access$302 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    n4 = n8 - access$302;
                    BytecodeManager.incBytecodes(3);
                }
                matcher.from = from;
                BytecodeManager.incBytecodes(3);
                matcher.lookbehindTo = lookbehindTo2;
                BytecodeManager.incBytecodes(3);
                final boolean b3 = match;
                BytecodeManager.incBytecodes(2);
                boolean b4 = false;
                Label_0341: {
                    if (b3) {
                        final Node next = this.next;
                        BytecodeManager.incBytecodes(6);
                        final boolean match2 = next.match(matcher, lookbehindTo, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match2) {
                            b4 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0341;
                        }
                    }
                    b4 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class NotBehind extends Node
    {
        Node cond;
        int rmax;
        int rmin;
        
        NotBehind(final Node cond, final int rmax, final int rmin) {
            try {
                BytecodeManager.incBytecodes(2);
                this.cond = cond;
                BytecodeManager.incBytecodes(3);
                this.rmax = rmax;
                BytecodeManager.incBytecodes(3);
                this.rmin = rmin;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int lookbehindTo, final CharSequence charSequence) {
            try {
                final int lookbehindTo2 = matcher.lookbehindTo;
                BytecodeManager.incBytecodes(3);
                final int from = matcher.from;
                BytecodeManager.incBytecodes(3);
                int match = 0;
                BytecodeManager.incBytecodes(2);
                final boolean transparentBounds = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                int from2;
                if (!transparentBounds) {
                    from2 = matcher.from;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    from2 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n = from2;
                BytecodeManager.incBytecodes(1);
                final int a = lookbehindTo - this.rmax;
                final int b = n;
                BytecodeManager.incBytecodes(6);
                final int max = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
                matcher.lookbehindTo = lookbehindTo;
                BytecodeManager.incBytecodes(3);
                final boolean transparentBounds2 = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                if (transparentBounds2) {
                    matcher.from = 0;
                    BytecodeManager.incBytecodes(3);
                }
                int n2 = lookbehindTo - this.rmin;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final int n3 = match;
                    BytecodeManager.incBytecodes(2);
                    if (n3 != 0) {
                        break;
                    }
                    final int n4 = n2;
                    final int n5 = max;
                    BytecodeManager.incBytecodes(3);
                    if (n4 < n5) {
                        break;
                    }
                    final Node cond = this.cond;
                    final int n6 = n2;
                    BytecodeManager.incBytecodes(6);
                    match = (cond.match(matcher, n6, charSequence) ? 1 : 0);
                    BytecodeManager.incBytecodes(1);
                    --n2;
                    BytecodeManager.incBytecodes(2);
                }
                matcher.from = from;
                BytecodeManager.incBytecodes(3);
                matcher.lookbehindTo = lookbehindTo2;
                BytecodeManager.incBytecodes(3);
                final int n7 = match;
                BytecodeManager.incBytecodes(2);
                boolean b2 = false;
                Label_0261: {
                    if (n7 == 0) {
                        final Node next = this.next;
                        BytecodeManager.incBytecodes(6);
                        final boolean match2 = next.match(matcher, lookbehindTo, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match2) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0261;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class NotBehindS extends NotBehind
    {
        NotBehindS(final Node node, final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(5);
                super(node, n, n2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int lookbehindTo, final CharSequence charSequence) {
            try {
                final int n = -this.rmax;
                BytecodeManager.incBytecodes(6);
                final int access$300 = Pattern.access$300(charSequence, lookbehindTo, n);
                BytecodeManager.incBytecodes(1);
                final int n2 = -this.rmin;
                BytecodeManager.incBytecodes(6);
                final int access$301 = Pattern.access$300(charSequence, lookbehindTo, n2);
                BytecodeManager.incBytecodes(1);
                final int from = matcher.from;
                BytecodeManager.incBytecodes(3);
                final int lookbehindTo2 = matcher.lookbehindTo;
                BytecodeManager.incBytecodes(3);
                int match = 0;
                BytecodeManager.incBytecodes(2);
                final boolean transparentBounds = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                int from2;
                if (!transparentBounds) {
                    from2 = matcher.from;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    from2 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n3 = from2;
                BytecodeManager.incBytecodes(1);
                final int a = lookbehindTo - access$300;
                final int b = n3;
                BytecodeManager.incBytecodes(5);
                final int max = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
                matcher.lookbehindTo = lookbehindTo;
                BytecodeManager.incBytecodes(3);
                final boolean transparentBounds2 = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                if (transparentBounds2) {
                    matcher.from = 0;
                    BytecodeManager.incBytecodes(3);
                }
                int n4 = lookbehindTo - access$301;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n5 = match;
                    BytecodeManager.incBytecodes(2);
                    if (n5 != 0) {
                        break;
                    }
                    final int n6 = n4;
                    final int n7 = max;
                    BytecodeManager.incBytecodes(3);
                    if (n6 < n7) {
                        break;
                    }
                    final Node cond = this.cond;
                    final int n8 = n4;
                    BytecodeManager.incBytecodes(6);
                    match = (cond.match(matcher, n8, charSequence) ? 1 : 0);
                    BytecodeManager.incBytecodes(1);
                    final int n9 = n4;
                    final int n10 = n4;
                    final int n11 = max;
                    BytecodeManager.incBytecodes(4);
                    int access$302;
                    if (n10 > n11) {
                        final int n12 = n4;
                        final int n13 = -1;
                        BytecodeManager.incBytecodes(4);
                        access$302 = Pattern.access$300(charSequence, n12, n13);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        access$302 = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    n4 = n9 - access$302;
                    BytecodeManager.incBytecodes(3);
                }
                matcher.from = from;
                BytecodeManager.incBytecodes(3);
                matcher.lookbehindTo = lookbehindTo2;
                BytecodeManager.incBytecodes(3);
                final int n14 = match;
                BytecodeManager.incBytecodes(2);
                boolean b2 = false;
                Label_0341: {
                    if (n14 == 0) {
                        final Node next = this.next;
                        BytecodeManager.incBytecodes(6);
                        final boolean match2 = next.match(matcher, lookbehindTo, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match2) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0341;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Bound extends Node
    {
        static int LEFT;
        static int RIGHT;
        static int BOTH;
        static int NONE;
        int type;
        boolean useUWORD;
        
        Bound(final int type, final boolean useUWORD) {
            try {
                BytecodeManager.incBytecodes(2);
                this.type = type;
                BytecodeManager.incBytecodes(3);
                this.useUWORD = useUWORD;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean isWord(final int codePoint) {
            try {
                final boolean useUWORD = this.useUWORD;
                BytecodeManager.incBytecodes(3);
                boolean is = false;
                Label_0080: {
                    if (useUWORD) {
                        final UnicodeProp word = UnicodeProp.WORD;
                        BytecodeManager.incBytecodes(3);
                        is = word.is(codePoint);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n = 95;
                        BytecodeManager.incBytecodes(3);
                        if (codePoint != n) {
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final boolean letterOrDigit = Character.isLetterOrDigit(codePoint);
                            BytecodeManager.incBytecodes(1);
                            if (!letterOrDigit) {
                                is = false;
                                BytecodeManager.incBytecodes(1);
                                break Label_0080;
                            }
                        }
                        is = true;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                BytecodeManager.incBytecodes(1);
                return is;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        int check(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                int from = matcher.from;
                BytecodeManager.incBytecodes(3);
                int n3 = matcher.to;
                BytecodeManager.incBytecodes(3);
                final boolean transparentBounds = matcher.transparentBounds;
                BytecodeManager.incBytecodes(3);
                if (transparentBounds) {
                    from = 0;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    n3 = matcher.getTextLength();
                    BytecodeManager.incBytecodes(1);
                }
                final int n4 = from;
                BytecodeManager.incBytecodes(3);
                if (n > n4) {
                    BytecodeManager.incBytecodes(3);
                    final int codePointBefore = Character.codePointBefore(charSequence, n);
                    BytecodeManager.incBytecodes(1);
                    final int n5 = codePointBefore;
                    BytecodeManager.incBytecodes(3);
                    final boolean word = this.isWord(n5);
                    BytecodeManager.incBytecodes(1);
                    int n8 = 0;
                    Label_0179: {
                        Label_0164: {
                            if (!word) {
                                final int codePoint = codePointBefore;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final int type = Character.getType(codePoint);
                                final int n6 = 6;
                                BytecodeManager.incBytecodes(2);
                                if (type == n6) {
                                    final int n7 = n - 1;
                                    BytecodeManager.incBytecodes(5);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean access$400 = Pattern.access$400(matcher, n7, charSequence);
                                    BytecodeManager.incBytecodes(1);
                                    if (access$400) {
                                        break Label_0164;
                                    }
                                }
                                n8 = 0;
                                BytecodeManager.incBytecodes(1);
                                break Label_0179;
                            }
                        }
                        n8 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    n2 = n8;
                    BytecodeManager.incBytecodes(1);
                }
                int n9 = 0;
                BytecodeManager.incBytecodes(2);
                final int n10 = n3;
                BytecodeManager.incBytecodes(3);
                if (n < n10) {
                    BytecodeManager.incBytecodes(3);
                    final int codePoint2 = Character.codePointAt(charSequence, n);
                    BytecodeManager.incBytecodes(1);
                    final int n11 = codePoint2;
                    BytecodeManager.incBytecodes(3);
                    final boolean word2 = this.isWord(n11);
                    BytecodeManager.incBytecodes(1);
                    int n13 = 0;
                    Label_0305: {
                        Label_0290: {
                            if (!word2) {
                                final int codePoint3 = codePoint2;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final int type2 = Character.getType(codePoint3);
                                final int n12 = 6;
                                BytecodeManager.incBytecodes(2);
                                if (type2 == n12) {
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean access$401 = Pattern.access$400(matcher, n, charSequence);
                                    BytecodeManager.incBytecodes(1);
                                    if (access$401) {
                                        break Label_0290;
                                    }
                                }
                                n13 = 0;
                                BytecodeManager.incBytecodes(1);
                                break Label_0305;
                            }
                        }
                        n13 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    n9 = n13;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    matcher.hitEnd = true;
                    BytecodeManager.incBytecodes(3);
                    matcher.requireEnd = true;
                    BytecodeManager.incBytecodes(3);
                }
                final int n14 = n2 ^ n9;
                BytecodeManager.incBytecodes(4);
                int n16;
                if (n14 != 0) {
                    final int n15 = n9;
                    BytecodeManager.incBytecodes(2);
                    if (n15 != 0) {
                        n16 = Bound.LEFT;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n16 = Bound.RIGHT;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    n16 = Bound.NONE;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n16;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, final int n, final CharSequence charSequence) {
            try {
                BytecodeManager.incBytecodes(5);
                final int n2 = this.check(matcher, n, charSequence) & this.type;
                BytecodeManager.incBytecodes(4);
                boolean b = false;
                Label_0068: {
                    if (n2 > 0) {
                        final Node next = this.next;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        final boolean match = next.match(matcher, n, charSequence);
                        BytecodeManager.incBytecodes(1);
                        if (match) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0068;
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
        
        static {
            try {
                Bound.LEFT = 1;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(Bound.RIGHT = 2);
                Bound.BOTH = 3;
                BytecodeManager.incBytecodes(2);
                Bound.NONE = 4;
                BytecodeManager.incBytecodes(3);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class BnM extends Node
    {
        int[] buffer;
        int[] lastOcc;
        int[] optoSft;
        
        static Node optimize(final Node node) {
            try {
                final boolean b = node instanceof Slice;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    BytecodeManager.incBytecodes(2);
                    return node;
                }
                final int[] buffer = ((Slice)node).buffer;
                BytecodeManager.incBytecodes(4);
                final int length = buffer.length;
                BytecodeManager.incBytecodes(3);
                final int n = length;
                final int n2 = 4;
                BytecodeManager.incBytecodes(3);
                if (n < n2) {
                    BytecodeManager.incBytecodes(2);
                    return node;
                }
                final int[] array = new int[128];
                BytecodeManager.incBytecodes(2);
                final int[] array2 = new int[length];
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int n5 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n5) {
                        break;
                    }
                    array[buffer[n3] & 0x7F] = n3 + 1;
                    BytecodeManager.incBytecodes(10);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                int n6 = length;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    BytecodeManager.incBytecodes(2);
                    if (n7 <= 0) {
                        break;
                    }
                    int n8 = length - 1;
                    BytecodeManager.incBytecodes(4);
                    Label_0230: {
                        while (true) {
                            final int n9 = n8;
                            final int n10 = n6;
                            BytecodeManager.incBytecodes(3);
                            if (n9 < n10) {
                                break;
                            }
                            final int n11 = buffer[n8];
                            final int n12 = buffer[n8 - n6];
                            BytecodeManager.incBytecodes(9);
                            if (n11 != n12) {
                                break Label_0230;
                            }
                            array2[n8 - 1] = n6;
                            BytecodeManager.incBytecodes(6);
                            --n8;
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            final int n13 = n8;
                            BytecodeManager.incBytecodes(2);
                            if (n13 <= 0) {
                                break;
                            }
                            array2[--n8] = n6;
                            BytecodeManager.incBytecodes(6);
                        }
                    }
                    --n6;
                    BytecodeManager.incBytecodes(2);
                }
                array2[length - 1] = 1;
                BytecodeManager.incBytecodes(6);
                final boolean b2 = node instanceof SliceS;
                BytecodeManager.incBytecodes(3);
                if (b2) {
                    final int[] array3 = buffer;
                    final int[] array4 = array;
                    final int[] array5 = array2;
                    final Node next = node.next;
                    BytecodeManager.incBytecodes(8);
                    final BnMS bnMS = new BnMS(array3, array4, array5, next);
                    BytecodeManager.incBytecodes(1);
                    return bnMS;
                }
                final int[] array6 = buffer;
                final int[] array7 = array;
                final int[] array8 = array2;
                final Node next2 = node.next;
                BytecodeManager.incBytecodes(8);
                final BnM bnM = new BnM(array6, array7, array8, next2);
                BytecodeManager.incBytecodes(1);
                return bnM;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        BnM(final int[] buffer, final int[] lastOcc, final int[] optoSft, final Node next) {
            try {
                BytecodeManager.incBytecodes(2);
                this.buffer = buffer;
                BytecodeManager.incBytecodes(3);
                this.lastOcc = lastOcc;
                BytecodeManager.incBytecodes(3);
                this.optoSft = optoSft;
                BytecodeManager.incBytecodes(3);
                this.next = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int n, final CharSequence charSequence) {
            try {
                final int[] buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                final int length = buffer.length;
                BytecodeManager.incBytecodes(3);
                final int n2 = matcher.to - length;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final int n3 = n;
                    final int n4 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n3 > n4) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    int n5 = length - 1;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n6 = n5;
                        BytecodeManager.incBytecodes(2);
                        if (n6 >= 0) {
                            final int n7 = n + n5;
                            BytecodeManager.incBytecodes(5);
                            final char char1 = charSequence.charAt(n7);
                            BytecodeManager.incBytecodes(1);
                            final char c = char1;
                            final int n8 = buffer[n5];
                            BytecodeManager.incBytecodes(5);
                            if (c != n8) {
                                final int n9 = n;
                                final int a = n5 + 1 - this.lastOcc[char1 & '\u007f'];
                                final int b2 = this.optoSft[n5];
                                BytecodeManager.incBytecodes(16);
                                n = n9 + Math.max(a, b2);
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            --n5;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            matcher.first = n;
                            BytecodeManager.incBytecodes(3);
                            final Node next = this.next;
                            final int n10 = n + length;
                            BytecodeManager.incBytecodes(8);
                            final boolean match = next.match(matcher, n10, charSequence);
                            BytecodeManager.incBytecodes(1);
                            final boolean b3 = match;
                            BytecodeManager.incBytecodes(2);
                            if (b3) {
                                matcher.first = n;
                                BytecodeManager.incBytecodes(3);
                                matcher.groups[0] = matcher.first;
                                BytecodeManager.incBytecodes(6);
                                matcher.groups[1] = matcher.last;
                                BytecodeManager.incBytecodes(6);
                                final boolean b4 = true;
                                BytecodeManager.incBytecodes(2);
                                return b4;
                            }
                            ++n;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean study(final TreeInfo treeInfo) {
            try {
                treeInfo.minLength += this.buffer.length;
                BytecodeManager.incBytecodes(8);
                treeInfo.maxValid = false;
                BytecodeManager.incBytecodes(3);
                final Node next = this.next;
                BytecodeManager.incBytecodes(4);
                final boolean study = next.study(treeInfo);
                BytecodeManager.incBytecodes(1);
                return study;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class BnMS extends BnM
    {
        int lengthInChars;
        
        BnMS(final int[] array, final int[] array2, final int[] array3, final Node node) {
            try {
                BytecodeManager.incBytecodes(6);
                super(array, array2, array3, node);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = this.buffer.length;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= length) {
                        break;
                    }
                    final int lengthInChars = this.lengthInChars;
                    final int codePoint = this.buffer[n];
                    BytecodeManager.incBytecodes(8);
                    this.lengthInChars = lengthInChars + Character.charCount(codePoint);
                    BytecodeManager.incBytecodes(2);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        boolean match(final Matcher matcher, int n, final CharSequence seq) {
            try {
                final int[] buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                final int length = buffer.length;
                BytecodeManager.incBytecodes(3);
                final int n2 = matcher.to - this.lengthInChars;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final int n3 = n;
                    final int n4 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n3 > n4) {
                        matcher.hitEnd = true;
                        BytecodeManager.incBytecodes(3);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final int n5 = n;
                    final int n6 = length;
                    BytecodeManager.incBytecodes(4);
                    int access$300 = Pattern.access$300(seq, n5, n6);
                    int n7 = length - 1;
                    BytecodeManager.incBytecodes(5);
                    while (true) {
                        final int n8 = access$300;
                        BytecodeManager.incBytecodes(2);
                        if (n8 > 0) {
                            final int index = n + access$300;
                            BytecodeManager.incBytecodes(5);
                            final int codePointBefore = Character.codePointBefore(seq, index);
                            BytecodeManager.incBytecodes(1);
                            final int n9 = codePointBefore;
                            final int n10 = buffer[n7];
                            BytecodeManager.incBytecodes(5);
                            if (n9 != n10) {
                                final int a = n7 + 1 - this.lastOcc[codePointBefore & 0x7F];
                                final int b2 = this.optoSft[n7];
                                BytecodeManager.incBytecodes(15);
                                final int max = Math.max(a, b2);
                                BytecodeManager.incBytecodes(1);
                                final int n11 = n;
                                final int n12 = n;
                                final int n13 = max;
                                BytecodeManager.incBytecodes(5);
                                n = n11 + Pattern.access$300(seq, n12, n13);
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final int n14 = access$300;
                            final int codePoint = codePointBefore;
                            BytecodeManager.incBytecodes(3);
                            access$300 = n14 - Character.charCount(codePoint);
                            --n7;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            matcher.first = n;
                            BytecodeManager.incBytecodes(3);
                            final Node next = this.next;
                            final int n15 = n + this.lengthInChars;
                            BytecodeManager.incBytecodes(9);
                            final boolean match = next.match(matcher, n15, seq);
                            BytecodeManager.incBytecodes(1);
                            final boolean b3 = match;
                            BytecodeManager.incBytecodes(2);
                            if (b3) {
                                matcher.first = n;
                                BytecodeManager.incBytecodes(3);
                                matcher.groups[0] = matcher.first;
                                BytecodeManager.incBytecodes(6);
                                matcher.groups[1] = matcher.last;
                                BytecodeManager.incBytecodes(6);
                                final boolean b4 = true;
                                BytecodeManager.incBytecodes(2);
                                return b4;
                            }
                            final int n16 = n;
                            final int n17 = n;
                            final int n18 = 1;
                            BytecodeManager.incBytecodes(5);
                            n = n16 + Pattern.access$300(seq, n17, n18);
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class CharPropertyNames
    {
        private static final HashMap<String, CharPropertyFactory> map;
        
        private CharPropertyNames() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static CharProperty charPropertyFor(final String s) {
            try {
                final HashMap<String, CharPropertyFactory> map = CharPropertyNames.map;
                BytecodeManager.incBytecodes(3);
                final CharPropertyFactory charPropertyFactory = map.get(s);
                BytecodeManager.incBytecodes(2);
                final CharPropertyFactory charPropertyFactory2 = charPropertyFactory;
                BytecodeManager.incBytecodes(2);
                CharProperty make;
                if (charPropertyFactory2 == null) {
                    make = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final CharPropertyFactory charPropertyFactory3 = charPropertyFactory;
                    BytecodeManager.incBytecodes(2);
                    make = charPropertyFactory3.make();
                }
                BytecodeManager.incBytecodes(1);
                return make;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static void defCategory(final String s, final int n) {
            try {
                final HashMap<String, CharPropertyFactory> map = CharPropertyNames.map;
                BytecodeManager.incBytecodes(6);
                final CharPropertyFactory charPropertyFactory = new CharPropertyFactory() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    CharProperty make() {
                        try {
                            final int val$typeMask = n;
                            BytecodeManager.incBytecodes(5);
                            final Category category = new Category(val$typeMask);
                            BytecodeManager.incBytecodes(1);
                            return category;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                map.put(s, charPropertyFactory);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static void defRange(final String s, final int n, final int n2) {
            try {
                final HashMap<String, CharPropertyFactory> map = CharPropertyNames.map;
                BytecodeManager.incBytecodes(7);
                final CharPropertyFactory charPropertyFactory = new CharPropertyFactory() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    CharProperty make() {
                        try {
                            final int val$lower = n;
                            final int val$upper = n2;
                            BytecodeManager.incBytecodes(5);
                            final CharProperty access$600 = Pattern.access$600(val$lower, val$upper);
                            BytecodeManager.incBytecodes(1);
                            return access$600;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                map.put(s, charPropertyFactory);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static void defCtype(final String s, final int n) {
            try {
                final HashMap<String, CharPropertyFactory> map = CharPropertyNames.map;
                BytecodeManager.incBytecodes(6);
                final CharPropertyFactory charPropertyFactory = new CharPropertyFactory() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    CharProperty make() {
                        try {
                            final int val$ctype = n;
                            BytecodeManager.incBytecodes(5);
                            final Ctype ctype = new Ctype(val$ctype);
                            BytecodeManager.incBytecodes(1);
                            return ctype;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                map.put(s, charPropertyFactory);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static void defClone(final String s, final CloneableProperty cloneableProperty) {
            try {
                final HashMap<String, CharPropertyFactory> map = CharPropertyNames.map;
                BytecodeManager.incBytecodes(6);
                final CharPropertyFactory charPropertyFactory = new CharPropertyFactory() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    CharProperty make() {
                        try {
                            final CloneableProperty val$p = cloneableProperty;
                            BytecodeManager.incBytecodes(3);
                            final CloneableProperty clone = val$p.clone();
                            BytecodeManager.incBytecodes(1);
                            return clone;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                map.put(s, charPropertyFactory);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                map = new HashMap<String, CharPropertyFactory>();
                BytecodeManager.incBytecodes(1);
                final String s = "Cn";
                final int n = 1;
                BytecodeManager.incBytecodes(3);
                defCategory(s, n);
                final String s2 = "Lu";
                final int n2 = 2;
                BytecodeManager.incBytecodes(3);
                defCategory(s2, n2);
                final String s3 = "Ll";
                final int n3 = 4;
                BytecodeManager.incBytecodes(3);
                defCategory(s3, n3);
                final String s4 = "Lt";
                final int n4 = 8;
                BytecodeManager.incBytecodes(3);
                defCategory(s4, n4);
                final String s5 = "Lm";
                final int n5 = 16;
                BytecodeManager.incBytecodes(3);
                defCategory(s5, n5);
                final String s6 = "Lo";
                final int n6 = 32;
                BytecodeManager.incBytecodes(3);
                defCategory(s6, n6);
                final String s7 = "Mn";
                final int n7 = 64;
                BytecodeManager.incBytecodes(3);
                defCategory(s7, n7);
                final String s8 = "Me";
                final int n8 = 128;
                BytecodeManager.incBytecodes(3);
                defCategory(s8, n8);
                final String s9 = "Mc";
                final int n9 = 256;
                BytecodeManager.incBytecodes(3);
                defCategory(s9, n9);
                final String s10 = "Nd";
                final int n10 = 512;
                BytecodeManager.incBytecodes(3);
                defCategory(s10, n10);
                final String s11 = "Nl";
                final int n11 = 1024;
                BytecodeManager.incBytecodes(3);
                defCategory(s11, n11);
                final String s12 = "No";
                final int n12 = 2048;
                BytecodeManager.incBytecodes(3);
                defCategory(s12, n12);
                final String s13 = "Zs";
                final int n13 = 4096;
                BytecodeManager.incBytecodes(3);
                defCategory(s13, n13);
                final String s14 = "Zl";
                final int n14 = 8192;
                BytecodeManager.incBytecodes(3);
                defCategory(s14, n14);
                final String s15 = "Zp";
                final int n15 = 16384;
                BytecodeManager.incBytecodes(3);
                defCategory(s15, n15);
                final String s16 = "Cc";
                final int n16 = 32768;
                BytecodeManager.incBytecodes(3);
                defCategory(s16, n16);
                final String s17 = "Cf";
                final int n17 = 65536;
                BytecodeManager.incBytecodes(3);
                defCategory(s17, n17);
                final String s18 = "Co";
                final int n18 = 262144;
                BytecodeManager.incBytecodes(3);
                defCategory(s18, n18);
                final String s19 = "Cs";
                final int n19 = 524288;
                BytecodeManager.incBytecodes(3);
                defCategory(s19, n19);
                final String s20 = "Pd";
                final int n20 = 1048576;
                BytecodeManager.incBytecodes(3);
                defCategory(s20, n20);
                final String s21 = "Ps";
                final int n21 = 2097152;
                BytecodeManager.incBytecodes(3);
                defCategory(s21, n21);
                final String s22 = "Pe";
                final int n22 = 4194304;
                BytecodeManager.incBytecodes(3);
                defCategory(s22, n22);
                final String s23 = "Pc";
                final int n23 = 8388608;
                BytecodeManager.incBytecodes(3);
                defCategory(s23, n23);
                final String s24 = "Po";
                final int n24 = 16777216;
                BytecodeManager.incBytecodes(3);
                defCategory(s24, n24);
                final String s25 = "Sm";
                final int n25 = 33554432;
                BytecodeManager.incBytecodes(3);
                defCategory(s25, n25);
                final String s26 = "Sc";
                final int n26 = 67108864;
                BytecodeManager.incBytecodes(3);
                defCategory(s26, n26);
                final String s27 = "Sk";
                final int n27 = 134217728;
                BytecodeManager.incBytecodes(3);
                defCategory(s27, n27);
                final String s28 = "So";
                final int n28 = 268435456;
                BytecodeManager.incBytecodes(3);
                defCategory(s28, n28);
                final String s29 = "Pi";
                final int n29 = 536870912;
                BytecodeManager.incBytecodes(3);
                defCategory(s29, n29);
                final String s30 = "Pf";
                final int n30 = 1073741824;
                BytecodeManager.incBytecodes(3);
                defCategory(s30, n30);
                final String s31 = "L";
                final int n31 = 62;
                BytecodeManager.incBytecodes(3);
                defCategory(s31, n31);
                final String s32 = "M";
                final int n32 = 448;
                BytecodeManager.incBytecodes(3);
                defCategory(s32, n32);
                final String s33 = "N";
                final int n33 = 3584;
                BytecodeManager.incBytecodes(3);
                defCategory(s33, n33);
                final String s34 = "Z";
                final int n34 = 28672;
                BytecodeManager.incBytecodes(3);
                defCategory(s34, n34);
                final String s35 = "C";
                final int n35 = 884736;
                BytecodeManager.incBytecodes(3);
                defCategory(s35, n35);
                final String s36 = "P";
                final int n36 = 1643118592;
                BytecodeManager.incBytecodes(3);
                defCategory(s36, n36);
                final String s37 = "S";
                final int n37 = 503316480;
                BytecodeManager.incBytecodes(3);
                defCategory(s37, n37);
                final String s38 = "LC";
                final int n38 = 14;
                BytecodeManager.incBytecodes(3);
                defCategory(s38, n38);
                final String s39 = "LD";
                final int n39 = 574;
                BytecodeManager.incBytecodes(3);
                defCategory(s39, n39);
                final String s40 = "L1";
                final int n40 = 0;
                final int n41 = 255;
                BytecodeManager.incBytecodes(4);
                defRange(s40, n40, n41);
                final HashMap<String, CharPropertyFactory> map2 = CharPropertyNames.map;
                final String s41 = "all";
                BytecodeManager.incBytecodes(5);
                final CharPropertyFactory charPropertyFactory = new CharPropertyFactory() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    CharProperty make() {
                        try {
                            BytecodeManager.incBytecodes(3);
                            final All all = new All();
                            BytecodeManager.incBytecodes(1);
                            return all;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                map2.put(s41, charPropertyFactory);
                BytecodeManager.incBytecodes(1);
                final String s42 = "ASCII";
                final int n42 = 0;
                final int n43 = 127;
                BytecodeManager.incBytecodes(4);
                defRange(s42, n42, n43);
                final String s43 = "Alnum";
                final int n44 = 1792;
                BytecodeManager.incBytecodes(3);
                defCtype(s43, n44);
                final String s44 = "Alpha";
                final int n45 = 768;
                BytecodeManager.incBytecodes(3);
                defCtype(s44, n45);
                final String s45 = "Blank";
                final int n46 = 16384;
                BytecodeManager.incBytecodes(3);
                defCtype(s45, n46);
                final String s46 = "Cntrl";
                final int n47 = 8192;
                BytecodeManager.incBytecodes(3);
                defCtype(s46, n47);
                final String s47 = "Digit";
                final int n48 = 48;
                final int n49 = 57;
                BytecodeManager.incBytecodes(4);
                defRange(s47, n48, n49);
                final String s48 = "Graph";
                final int n50 = 5888;
                BytecodeManager.incBytecodes(3);
                defCtype(s48, n50);
                final String s49 = "Lower";
                final int n51 = 97;
                final int n52 = 122;
                BytecodeManager.incBytecodes(4);
                defRange(s49, n51, n52);
                final String s50 = "Print";
                final int n53 = 32;
                final int n54 = 126;
                BytecodeManager.incBytecodes(4);
                defRange(s50, n53, n54);
                final String s51 = "Punct";
                final int n55 = 4096;
                BytecodeManager.incBytecodes(3);
                defCtype(s51, n55);
                final String s52 = "Space";
                final int n56 = 2048;
                BytecodeManager.incBytecodes(3);
                defCtype(s52, n56);
                final String s53 = "Upper";
                final int n57 = 65;
                final int n58 = 90;
                BytecodeManager.incBytecodes(4);
                defRange(s53, n57, n58);
                final String s54 = "XDigit";
                final int n59 = 32768;
                BytecodeManager.incBytecodes(3);
                defCtype(s54, n59);
                final String s55 = "javaLowerCase";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean lowerCase = Character.isLowerCase(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return lowerCase;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s55, cloneableProperty);
                final String s56 = "javaUpperCase";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty2 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean upperCase = Character.isUpperCase(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return upperCase;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s56, cloneableProperty2);
                final String s57 = "javaAlphabetic";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty3 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean alphabetic = Character.isAlphabetic(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return alphabetic;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s57, cloneableProperty3);
                final String s58 = "javaIdeographic";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty4 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean ideographic = Character.isIdeographic(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return ideographic;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s58, cloneableProperty4);
                final String s59 = "javaTitleCase";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty5 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean titleCase = Character.isTitleCase(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return titleCase;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s59, cloneableProperty5);
                final String s60 = "javaDigit";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty6 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean digit = Character.isDigit(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return digit;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s60, cloneableProperty6);
                final String s61 = "javaDefined";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty7 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean defined = Character.isDefined(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return defined;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s61, cloneableProperty7);
                final String s62 = "javaLetter";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty8 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean letter = Character.isLetter(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return letter;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s62, cloneableProperty8);
                final String s63 = "javaLetterOrDigit";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty9 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean letterOrDigit = Character.isLetterOrDigit(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return letterOrDigit;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s63, cloneableProperty9);
                final String s64 = "javaJavaIdentifierStart";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty10 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean javaIdentifierStart = Character.isJavaIdentifierStart(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return javaIdentifierStart;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s64, cloneableProperty10);
                final String s65 = "javaJavaIdentifierPart";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty11 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean javaIdentifierPart = Character.isJavaIdentifierPart(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return javaIdentifierPart;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s65, cloneableProperty11);
                final String s66 = "javaUnicodeIdentifierStart";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty12 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean unicodeIdentifierStart = Character.isUnicodeIdentifierStart(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return unicodeIdentifierStart;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s66, cloneableProperty12);
                final String s67 = "javaUnicodeIdentifierPart";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty13 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean unicodeIdentifierPart = Character.isUnicodeIdentifierPart(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return unicodeIdentifierPart;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s67, cloneableProperty13);
                final String s68 = "javaIdentifierIgnorable";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty14 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean identifierIgnorable = Character.isIdentifierIgnorable(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return identifierIgnorable;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s68, cloneableProperty14);
                final String s69 = "javaSpaceChar";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty15 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean spaceChar = Character.isSpaceChar(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return spaceChar;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s69, cloneableProperty15);
                final String s70 = "javaWhitespace";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty16 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean whitespace = Character.isWhitespace(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return whitespace;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s70, cloneableProperty16);
                final String s71 = "javaISOControl";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty17 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean isoControl = Character.isISOControl(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return isoControl;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s71, cloneableProperty17);
                final String s72 = "javaMirrored";
                BytecodeManager.incBytecodes(4);
                final CloneableProperty cloneableProperty18 = new CloneableProperty() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    boolean isSatisfiedBy(final int codePoint) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            final boolean mirrored = Character.isMirrored(codePoint);
                            BytecodeManager.incBytecodes(1);
                            return mirrored;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                defClone(s72, cloneableProperty18);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private abstract static class CharPropertyFactory
        {
            private CharPropertyFactory() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            abstract CharProperty make();
        }
        
        private abstract static class CloneableProperty extends CharProperty implements Cloneable
        {
            private CloneableProperty() {
                try {
                    final CharProperty charProperty = null;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public CloneableProperty clone() {
                try {
                    try {
                        BytecodeManager.incBytecodes(2);
                        final CloneableProperty cloneableProperty = (CloneableProperty)super.clone();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        return cloneableProperty;
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
        }
    }
}
