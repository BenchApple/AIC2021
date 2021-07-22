// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.regex;

import instrumented.java.util.Locale;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.HashMap;

enum UnicodeProp
{
    ALPHABETIC {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
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
    }, 
    LETTER {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
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
    }, 
    IDEOGRAPHIC {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
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
    }, 
    LOWERCASE {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
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
    }, 
    UPPERCASE {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
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
    }, 
    TITLECASE {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
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
    }, 
    WHITE_SPACE {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
            try {
                final int n = 28672;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final int n2 = n >> Character.getType(codePoint) & 0x1;
                BytecodeManager.incBytecodes(4);
                boolean b = false;
                Label_0077: {
                    Label_0062: {
                        if (n2 == 0) {
                            final int n3 = 9;
                            BytecodeManager.incBytecodes(3);
                            if (codePoint >= n3) {
                                final int n4 = 13;
                                BytecodeManager.incBytecodes(3);
                                if (codePoint <= n4) {
                                    break Label_0062;
                                }
                            }
                            final int n5 = 133;
                            BytecodeManager.incBytecodes(3);
                            if (codePoint != n5) {
                                b = false;
                                BytecodeManager.incBytecodes(1);
                                break Label_0077;
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
    }, 
    CONTROL {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
            try {
                BytecodeManager.incBytecodes(2);
                final int type = Character.getType(codePoint);
                final int n = 15;
                BytecodeManager.incBytecodes(2);
                boolean b;
                if (type == n) {
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
    }, 
    PUNCTUATION {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
            try {
                final int n = 1643118592;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final int n2 = n >> Character.getType(codePoint) & 0x1;
                BytecodeManager.incBytecodes(4);
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
    }, 
    HEX_DIGIT {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int n) {
            try {
                final UnicodeProp digit = UnicodeProp$10.DIGIT;
                BytecodeManager.incBytecodes(3);
                final boolean is = digit.is(n);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0167: {
                    Label_0152: {
                        if (!is) {
                            final int n2 = 48;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n2) {
                                final int n3 = 57;
                                BytecodeManager.incBytecodes(3);
                                if (n <= n3) {
                                    break Label_0152;
                                }
                            }
                            final int n4 = 65;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n4) {
                                final int n5 = 70;
                                BytecodeManager.incBytecodes(3);
                                if (n <= n5) {
                                    break Label_0152;
                                }
                            }
                            final int n6 = 97;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n6) {
                                final int n7 = 102;
                                BytecodeManager.incBytecodes(3);
                                if (n <= n7) {
                                    break Label_0152;
                                }
                            }
                            final int n8 = 65296;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n8) {
                                final int n9 = 65305;
                                BytecodeManager.incBytecodes(3);
                                if (n <= n9) {
                                    break Label_0152;
                                }
                            }
                            final int n10 = 65313;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n10) {
                                final int n11 = 65318;
                                BytecodeManager.incBytecodes(3);
                                if (n <= n11) {
                                    break Label_0152;
                                }
                            }
                            final int n12 = 65345;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n12) {
                                final int n13 = 65350;
                                BytecodeManager.incBytecodes(3);
                                if (n <= n13) {
                                    break Label_0152;
                                }
                            }
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0167;
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
    }, 
    ASSIGNED {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
            try {
                BytecodeManager.incBytecodes(2);
                final int type = Character.getType(codePoint);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (type != 0) {
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
    }, 
    NONCHARACTER_CODE_POINT {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int n) {
            try {
                final int n2 = n & 0xFFFE;
                final int n3 = 65534;
                BytecodeManager.incBytecodes(5);
                boolean b = false;
                Label_0051: {
                    Label_0036: {
                        if (n2 != n3) {
                            final int n4 = 64976;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n4) {
                                final int n5 = 65007;
                                BytecodeManager.incBytecodes(3);
                                if (n <= n5) {
                                    break Label_0036;
                                }
                            }
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
    }, 
    DIGIT {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
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
    }, 
    ALNUM {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int n) {
            try {
                final UnicodeProp alphabetic = UnicodeProp$14.ALPHABETIC;
                BytecodeManager.incBytecodes(3);
                final boolean is = alphabetic.is(n);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0055: {
                    if (!is) {
                        final UnicodeProp digit = UnicodeProp$14.DIGIT;
                        BytecodeManager.incBytecodes(3);
                        final boolean is2 = digit.is(n);
                        BytecodeManager.incBytecodes(1);
                        if (!is2) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0055;
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
    }, 
    BLANK {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
            try {
                BytecodeManager.incBytecodes(2);
                final int type = Character.getType(codePoint);
                final int n = 12;
                BytecodeManager.incBytecodes(2);
                boolean b = false;
                Label_0045: {
                    if (type != n) {
                        final int n2 = 9;
                        BytecodeManager.incBytecodes(3);
                        if (codePoint != n2) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0045;
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
    }, 
    GRAPH {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
            try {
                final int n = 585729;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final int n2 = n >> Character.getType(codePoint) & 0x1;
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (n2 == 0) {
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
    }, 
    PRINT {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int n) {
            try {
                final UnicodeProp graph = UnicodeProp$17.GRAPH;
                BytecodeManager.incBytecodes(3);
                final boolean is = graph.is(n);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0075: {
                    Label_0069: {
                        if (!is) {
                            final UnicodeProp blank = UnicodeProp$17.BLANK;
                            BytecodeManager.incBytecodes(3);
                            final boolean is2 = blank.is(n);
                            BytecodeManager.incBytecodes(1);
                            if (!is2) {
                                break Label_0069;
                            }
                        }
                        final UnicodeProp control = UnicodeProp$17.CONTROL;
                        BytecodeManager.incBytecodes(3);
                        final boolean is3 = control.is(n);
                        BytecodeManager.incBytecodes(1);
                        if (!is3) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0075;
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
    }, 
    WORD {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int codePoint) {
            try {
                final UnicodeProp alphabetic = UnicodeProp$18.ALPHABETIC;
                BytecodeManager.incBytecodes(3);
                final boolean is = alphabetic.is(codePoint);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0087: {
                    if (!is) {
                        final int n = 8389568;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final int n2 = n >> Character.getType(codePoint) & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n2 == 0) {
                            final UnicodeProp join_CONTROL = UnicodeProp$18.JOIN_CONTROL;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean is2 = join_CONTROL.is(codePoint);
                            BytecodeManager.incBytecodes(1);
                            if (!is2) {
                                b = false;
                                BytecodeManager.incBytecodes(1);
                                break Label_0087;
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
    }, 
    JOIN_CONTROL {
        {
            try {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(5);
                super(s, n, unicodeProp);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean is(final int n) {
            try {
                final int n2 = 8204;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0039: {
                    if (n != n2) {
                        final int n3 = 8205;
                        BytecodeManager.incBytecodes(3);
                        if (n != n3) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0039;
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
    
    private static final HashMap<String, String> posix;
    private static final HashMap<String, String> aliases;
    
    private UnicodeProp() {
        try {
            BytecodeManager.incBytecodes(4);
            super(name, ordinal);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static UnicodeProp forName(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       instrumented/java/util/Locale.ENGLISH:Linstrumented/java/util/Locale;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokevirtual   java/lang/String.toUpperCase:(Linstrumented/java/util/Locale;)Ljava/lang/String;
        //    12: astore_0       
        //    13: ldc             1
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: getstatic       instrumented/java/util/regex/UnicodeProp.aliases:Linstrumented/java/util/HashMap;
        //    21: aload_0        
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokevirtual   instrumented/java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: checkcast       Ljava/lang/String;
        //    33: astore_1       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_1        
        //    40: ldc             2
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          55
        //    48: aload_1        
        //    49: astore_0       
        //    50: ldc             2
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: aload_0        
        //    56: ldc             2
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: invokestatic    instrumented/java/util/regex/UnicodeProp.valueOf:(Ljava/lang/String;)Linstrumented/java/util/regex/UnicodeProp;
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: areturn        
        //    70: astore_2       
        //    71: ldc             501
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aconst_null    
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: areturn        
        //    83: athrow         
        //    84: athrow         
        //    StackMapTable: 00 04 FC 00 37 07 00 71 4E 07 00 69 FF 00 0C 00 00 00 01 07 00 58 FF 00 00 00 00 00 01 07 00 67
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  55     84     84     85     Ljava/lang/VirtualMachineError;
        //  55     64     70     83     Ljava/lang/IllegalArgumentException;
        //  0      83     83     84     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0055:
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
    
    public static UnicodeProp forPOSIXName(String s) {
        try {
            final HashMap<String, String> posix = UnicodeProp.posix;
            final String s2 = s;
            final Locale english = Locale.ENGLISH;
            BytecodeManager.incBytecodes(4);
            final String upperCase = s2.toUpperCase(english);
            BytecodeManager.incBytecodes(1);
            s = posix.get(upperCase);
            BytecodeManager.incBytecodes(2);
            final String s3 = s;
            BytecodeManager.incBytecodes(2);
            if (s3 == null) {
                final UnicodeProp unicodeProp = null;
                BytecodeManager.incBytecodes(2);
                return unicodeProp;
            }
            final String s4 = s;
            BytecodeManager.incBytecodes(2);
            final UnicodeProp value = valueOf(s4);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract boolean is(final int p0);
    
    static {
        try {
            final String s = "ALPHABETIC";
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s2 = "LETTER";
            final int n2 = 1;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s3 = "IDEOGRAPHIC";
            final int n3 = 2;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s4 = "LOWERCASE";
            final int n4 = 3;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s5 = "UPPERCASE";
            final int n5 = 4;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s6 = "TITLECASE";
            final int n6 = 5;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s7 = "WHITE_SPACE";
            final int n7 = 6;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s8 = "CONTROL";
            final int n8 = 7;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s9 = "PUNCTUATION";
            final int n9 = 8;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s10 = "HEX_DIGIT";
            final int n10 = 9;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s11 = "ASSIGNED";
            final int n11 = 10;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s12 = "NONCHARACTER_CODE_POINT";
            final int n12 = 11;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s13 = "DIGIT";
            final int n13 = 12;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s14 = "ALNUM";
            final int n14 = 13;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s15 = "BLANK";
            final int n15 = 14;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s16 = "GRAPH";
            final int n16 = 15;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s17 = "PRINT";
            final int n17 = 16;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s18 = "WORD";
            final int n18 = 17;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s19 = "JOIN_CONTROL";
            final int n19 = 18;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(78);
            BytecodeManager.incBytecodes(3);
            posix = new HashMap<String, String>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            aliases = new HashMap<String, String>();
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix2 = UnicodeProp.posix;
            final String s20 = "ALPHA";
            final String s21 = "ALPHABETIC";
            BytecodeManager.incBytecodes(4);
            posix2.put(s20, s21);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix3 = UnicodeProp.posix;
            final String s22 = "LOWER";
            final String s23 = "LOWERCASE";
            BytecodeManager.incBytecodes(4);
            posix3.put(s22, s23);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix4 = UnicodeProp.posix;
            final String s24 = "UPPER";
            final String s25 = "UPPERCASE";
            BytecodeManager.incBytecodes(4);
            posix4.put(s24, s25);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix5 = UnicodeProp.posix;
            final String s26 = "SPACE";
            final String s27 = "WHITE_SPACE";
            BytecodeManager.incBytecodes(4);
            posix5.put(s26, s27);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix6 = UnicodeProp.posix;
            final String s28 = "PUNCT";
            final String s29 = "PUNCTUATION";
            BytecodeManager.incBytecodes(4);
            posix6.put(s28, s29);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix7 = UnicodeProp.posix;
            final String s30 = "XDIGIT";
            final String s31 = "HEX_DIGIT";
            BytecodeManager.incBytecodes(4);
            posix7.put(s30, s31);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix8 = UnicodeProp.posix;
            final String s32 = "ALNUM";
            final String s33 = "ALNUM";
            BytecodeManager.incBytecodes(4);
            posix8.put(s32, s33);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix9 = UnicodeProp.posix;
            final String s34 = "CNTRL";
            final String s35 = "CONTROL";
            BytecodeManager.incBytecodes(4);
            posix9.put(s34, s35);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix10 = UnicodeProp.posix;
            final String s36 = "DIGIT";
            final String s37 = "DIGIT";
            BytecodeManager.incBytecodes(4);
            posix10.put(s36, s37);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix11 = UnicodeProp.posix;
            final String s38 = "BLANK";
            final String s39 = "BLANK";
            BytecodeManager.incBytecodes(4);
            posix11.put(s38, s39);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix12 = UnicodeProp.posix;
            final String s40 = "GRAPH";
            final String s41 = "GRAPH";
            BytecodeManager.incBytecodes(4);
            posix12.put(s40, s41);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> posix13 = UnicodeProp.posix;
            final String s42 = "PRINT";
            final String s43 = "PRINT";
            BytecodeManager.incBytecodes(4);
            posix13.put(s42, s43);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> aliases2 = UnicodeProp.aliases;
            final String s44 = "WHITESPACE";
            final String s45 = "WHITE_SPACE";
            BytecodeManager.incBytecodes(4);
            aliases2.put(s44, s45);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> aliases3 = UnicodeProp.aliases;
            final String s46 = "HEXDIGIT";
            final String s47 = "HEX_DIGIT";
            BytecodeManager.incBytecodes(4);
            aliases3.put(s46, s47);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> aliases4 = UnicodeProp.aliases;
            final String s48 = "NONCHARACTERCODEPOINT";
            final String s49 = "NONCHARACTER_CODE_POINT";
            BytecodeManager.incBytecodes(4);
            aliases4.put(s48, s49);
            BytecodeManager.incBytecodes(1);
            final HashMap<String, String> aliases5 = UnicodeProp.aliases;
            final String s50 = "JOINCONTROL";
            final String s51 = "JOIN_CONTROL";
            BytecodeManager.incBytecodes(4);
            aliases5.put(s50, s51);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
