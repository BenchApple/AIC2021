// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.regex;

import aic2021.engine.BytecodeManager;

final class ASCII
{
    static final int UPPER = 256;
    static final int LOWER = 512;
    static final int DIGIT = 1024;
    static final int SPACE = 2048;
    static final int PUNCT = 4096;
    static final int CNTRL = 8192;
    static final int BLANK = 16384;
    static final int HEX = 32768;
    static final int UNDER = 65536;
    static final int ASCII = 65280;
    static final int ALPHA = 768;
    static final int ALNUM = 1792;
    static final int GRAPH = 5888;
    static final int WORD = 67328;
    static final int XDIGIT = 32768;
    private static final int[] ctype;
    
    ASCII() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int getType(final int n) {
        try {
            final int n2 = n & 0xFFFFFF80;
            BytecodeManager.incBytecodes(4);
            int n3;
            if (n2 == 0) {
                n3 = instrumented.java.util.regex.ASCII.ctype[n];
                BytecodeManager.incBytecodes(4);
            }
            else {
                n3 = 0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isType(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n3 = getType(n) & n2;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (n3 != 0) {
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
    
    static boolean isAscii(final int n) {
        try {
            final int n2 = n & 0xFFFFFF80;
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
    
    static boolean isAlpha(final int n) {
        try {
            final int n2 = 768;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isDigit(final int n) {
        try {
            final int n2 = n - 48 | 57 - n;
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n2 >= 0) {
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
    
    static boolean isAlnum(final int n) {
        try {
            final int n2 = 1792;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isGraph(final int n) {
        try {
            final int n2 = 5888;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isPrint(final int n) {
        try {
            final int n2 = n - 32 | 126 - n;
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n2 >= 0) {
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
    
    static boolean isPunct(final int n) {
        try {
            final int n2 = 4096;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isSpace(final int n) {
        try {
            final int n2 = 2048;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isHexDigit(final int n) {
        try {
            final int n2 = 32768;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isOctDigit(final int n) {
        try {
            final int n2 = n - 48 | 55 - n;
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n2 >= 0) {
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
    
    static boolean isCntrl(final int n) {
        try {
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean isLower(final int n) {
        try {
            final int n2 = n - 97 | 122 - n;
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n2 >= 0) {
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
    
    static boolean isUpper(final int n) {
        try {
            final int n2 = n - 65 | 90 - n;
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n2 >= 0) {
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
    
    static boolean isWord(final int n) {
        try {
            final int n2 = 67328;
            BytecodeManager.incBytecodes(3);
            final boolean type = isType(n, n2);
            BytecodeManager.incBytecodes(1);
            return type;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int toDigit(final int n) {
        try {
            final int n2 = instrumented.java.util.regex.ASCII.ctype[n & 0x7F] & 0x3F;
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int toLower(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean upper = isUpper(n);
            BytecodeManager.incBytecodes(1);
            int n2;
            if (upper) {
                n2 = n + 32;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n2 = n;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int toUpper(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean lower = isLower(n);
            BytecodeManager.incBytecodes(1);
            int n2;
            if (lower) {
                n2 = n - 32;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n2 = n;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            ctype = new int[] { 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 26624, 10240, 10240, 10240, 10240, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 18432, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 33792, 33793, 33794, 33795, 33796, 33797, 33798, 33799, 33800, 33801, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 33034, 33035, 33036, 33037, 33038, 33039, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 4096, 4096, 4096, 4096, 69632, 4096, 33290, 33291, 33292, 33293, 33294, 33295, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 4096, 4096, 4096, 4096, 8192 };
            BytecodeManager.incBytecodes(515);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
