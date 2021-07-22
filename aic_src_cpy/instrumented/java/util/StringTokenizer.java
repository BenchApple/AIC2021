// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class StringTokenizer implements Enumeration<Object>
{
    private int currentPosition;
    private int newPosition;
    private int maxPosition;
    private String str;
    private String delimiters;
    private boolean retDelims;
    private boolean delimsChanged;
    private int maxDelimCodePoint;
    private boolean hasSurrogates;
    private int[] delimiterCodePoints;
    
    private void setMaxDelimCodePoint() {
        try {
            final String delimiters = this.delimiters;
            BytecodeManager.incBytecodes(3);
            if (delimiters == null) {
                this.maxDelimCodePoint = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            int maxDelimCodePoint = 0;
            BytecodeManager.incBytecodes(2);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final String delimiters2 = this.delimiters;
                BytecodeManager.incBytecodes(4);
                final int length = delimiters2.length();
                BytecodeManager.incBytecodes(1);
                if (n3 >= length) {
                    break;
                }
                final String delimiters3 = this.delimiters;
                final int index = n2;
                BytecodeManager.incBytecodes(4);
                int n4 = delimiters3.charAt(index);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = 55296;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n6) {
                    final int n7 = n4;
                    final int n8 = 57343;
                    BytecodeManager.incBytecodes(3);
                    if (n7 <= n8) {
                        final String delimiters4 = this.delimiters;
                        final int index2 = n2;
                        BytecodeManager.incBytecodes(4);
                        n4 = delimiters4.codePointAt(index2);
                        BytecodeManager.incBytecodes(1);
                        this.hasSurrogates = true;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final int n9 = maxDelimCodePoint;
                final int n10 = n4;
                BytecodeManager.incBytecodes(3);
                if (n9 < n10) {
                    maxDelimCodePoint = n4;
                    BytecodeManager.incBytecodes(2);
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                final int n11 = n2;
                final int codePoint = n4;
                BytecodeManager.incBytecodes(3);
                n2 = n11 + Character.charCount(codePoint);
                BytecodeManager.incBytecodes(3);
            }
            this.maxDelimCodePoint = maxDelimCodePoint;
            BytecodeManager.incBytecodes(3);
            final boolean hasSurrogates = this.hasSurrogates;
            BytecodeManager.incBytecodes(3);
            if (hasSurrogates) {
                this.delimiterCodePoints = new int[n];
                BytecodeManager.incBytecodes(3);
                int n12 = 0;
                int n13 = 0;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n14 = n12;
                    final int n15 = n;
                    BytecodeManager.incBytecodes(3);
                    if (n14 >= n15) {
                        break;
                    }
                    final String delimiters5 = this.delimiters;
                    final int index3 = n13;
                    BytecodeManager.incBytecodes(4);
                    final int codePoint2 = delimiters5.codePointAt(index3);
                    BytecodeManager.incBytecodes(1);
                    this.delimiterCodePoints[n12] = codePoint2;
                    BytecodeManager.incBytecodes(5);
                    ++n12;
                    final int n16 = n13;
                    final int codePoint3 = codePoint2;
                    BytecodeManager.incBytecodes(4);
                    n13 = n16 + Character.charCount(codePoint3);
                    BytecodeManager.incBytecodes(3);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringTokenizer(final String str, final String delimiters, final boolean retDelims) {
        try {
            BytecodeManager.incBytecodes(2);
            this.hasSurrogates = false;
            BytecodeManager.incBytecodes(3);
            this.currentPosition = 0;
            BytecodeManager.incBytecodes(3);
            this.newPosition = -1;
            BytecodeManager.incBytecodes(3);
            this.delimsChanged = false;
            BytecodeManager.incBytecodes(3);
            this.str = str;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.maxPosition = str.length();
            BytecodeManager.incBytecodes(1);
            this.delimiters = delimiters;
            BytecodeManager.incBytecodes(3);
            this.retDelims = retDelims;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.setMaxDelimCodePoint();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringTokenizer(final String s, final String s2) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            this(s, s2, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringTokenizer(final String s) {
        try {
            final String s2 = " \t\n\r\f";
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            this(s, s2, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int skipDelimiters(final int n) {
        try {
            final String delimiters = this.delimiters;
            BytecodeManager.incBytecodes(3);
            if (delimiters == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            int n2 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final boolean retDelims = this.retDelims;
                BytecodeManager.incBytecodes(3);
                if (retDelims) {
                    break;
                }
                final int n3 = n2;
                final int maxPosition = this.maxPosition;
                BytecodeManager.incBytecodes(4);
                if (n3 >= maxPosition) {
                    break;
                }
                final boolean hasSurrogates = this.hasSurrogates;
                BytecodeManager.incBytecodes(3);
                if (!hasSurrogates) {
                    final String str = this.str;
                    final int index = n2;
                    BytecodeManager.incBytecodes(4);
                    final char char1 = str.charAt(index);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int maxDelimCodePoint = this.maxDelimCodePoint;
                    BytecodeManager.incBytecodes(4);
                    if (c > maxDelimCodePoint) {
                        break;
                    }
                    final String delimiters2 = this.delimiters;
                    final char ch = char1;
                    BytecodeManager.incBytecodes(4);
                    final int index2 = delimiters2.indexOf(ch);
                    BytecodeManager.incBytecodes(1);
                    if (index2 < 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final String str2 = this.str;
                    final int index3 = n2;
                    BytecodeManager.incBytecodes(4);
                    final int codePoint = str2.codePointAt(index3);
                    BytecodeManager.incBytecodes(1);
                    final int n4 = codePoint;
                    final int maxDelimCodePoint2 = this.maxDelimCodePoint;
                    BytecodeManager.incBytecodes(4);
                    if (n4 > maxDelimCodePoint2) {
                        break;
                    }
                    final int n5 = codePoint;
                    BytecodeManager.incBytecodes(3);
                    final boolean delimiter = this.isDelimiter(n5);
                    BytecodeManager.incBytecodes(1);
                    if (!delimiter) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final int n6 = n2;
                    final int codePoint2 = codePoint;
                    BytecodeManager.incBytecodes(3);
                    n2 = n6 + Character.charCount(codePoint2);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n7 = n2;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int scanToken(final int n) {
        try {
            int n2 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int maxPosition = this.maxPosition;
                BytecodeManager.incBytecodes(4);
                if (n3 >= maxPosition) {
                    break;
                }
                final boolean hasSurrogates = this.hasSurrogates;
                BytecodeManager.incBytecodes(3);
                if (!hasSurrogates) {
                    final String str = this.str;
                    final int index = n2;
                    BytecodeManager.incBytecodes(4);
                    final char char1 = str.charAt(index);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int maxDelimCodePoint = this.maxDelimCodePoint;
                    BytecodeManager.incBytecodes(4);
                    if (c <= maxDelimCodePoint) {
                        final String delimiters = this.delimiters;
                        final char ch = char1;
                        BytecodeManager.incBytecodes(4);
                        final int index2 = delimiters.indexOf(ch);
                        BytecodeManager.incBytecodes(1);
                        if (index2 >= 0) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final String str2 = this.str;
                    final int index3 = n2;
                    BytecodeManager.incBytecodes(4);
                    final int codePoint = str2.codePointAt(index3);
                    BytecodeManager.incBytecodes(1);
                    final int n4 = codePoint;
                    final int maxDelimCodePoint2 = this.maxDelimCodePoint;
                    BytecodeManager.incBytecodes(4);
                    if (n4 <= maxDelimCodePoint2) {
                        final int n5 = codePoint;
                        BytecodeManager.incBytecodes(3);
                        final boolean delimiter = this.isDelimiter(n5);
                        BytecodeManager.incBytecodes(1);
                        if (delimiter) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    final int n6 = n2;
                    final int codePoint2 = codePoint;
                    BytecodeManager.incBytecodes(3);
                    n2 = n6 + Character.charCount(codePoint2);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final boolean retDelims = this.retDelims;
            BytecodeManager.incBytecodes(3);
            if (retDelims) {
                final int n7 = n2;
                BytecodeManager.incBytecodes(3);
                if (n == n7) {
                    final boolean hasSurrogates2 = this.hasSurrogates;
                    BytecodeManager.incBytecodes(3);
                    if (!hasSurrogates2) {
                        final String str3 = this.str;
                        final int index4 = n2;
                        BytecodeManager.incBytecodes(4);
                        final char char2 = str3.charAt(index4);
                        BytecodeManager.incBytecodes(1);
                        final char c2 = char2;
                        final int maxDelimCodePoint3 = this.maxDelimCodePoint;
                        BytecodeManager.incBytecodes(4);
                        if (c2 <= maxDelimCodePoint3) {
                            final String delimiters2 = this.delimiters;
                            final char ch2 = char2;
                            BytecodeManager.incBytecodes(4);
                            final int index5 = delimiters2.indexOf(ch2);
                            BytecodeManager.incBytecodes(1);
                            if (index5 >= 0) {
                                ++n2;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final String str4 = this.str;
                        final int index6 = n2;
                        BytecodeManager.incBytecodes(4);
                        final int codePoint3 = str4.codePointAt(index6);
                        BytecodeManager.incBytecodes(1);
                        final int n8 = codePoint3;
                        final int maxDelimCodePoint4 = this.maxDelimCodePoint;
                        BytecodeManager.incBytecodes(4);
                        if (n8 <= maxDelimCodePoint4) {
                            final int n9 = codePoint3;
                            BytecodeManager.incBytecodes(3);
                            final boolean delimiter2 = this.isDelimiter(n9);
                            BytecodeManager.incBytecodes(1);
                            if (delimiter2) {
                                final int n10 = n2;
                                final int codePoint4 = codePoint3;
                                BytecodeManager.incBytecodes(3);
                                n2 = n10 + Character.charCount(codePoint4);
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                }
            }
            final int n11 = n2;
            BytecodeManager.incBytecodes(2);
            return n11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isDelimiter(final int n) {
        try {
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length = this.delimiterCodePoints.length;
                BytecodeManager.incBytecodes(5);
                if (n3 >= length) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n4 = this.delimiterCodePoints[n2];
                BytecodeManager.incBytecodes(6);
                if (n4 == n) {
                    final boolean b2 = true;
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
    
    public boolean hasMoreTokens() {
        try {
            final int currentPosition = this.currentPosition;
            BytecodeManager.incBytecodes(5);
            this.newPosition = this.skipDelimiters(currentPosition);
            BytecodeManager.incBytecodes(1);
            final int newPosition = this.newPosition;
            final int maxPosition = this.maxPosition;
            BytecodeManager.incBytecodes(5);
            boolean b;
            if (newPosition < maxPosition) {
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
    
    public String nextToken() {
        try {
            final int newPosition = this.newPosition;
            BytecodeManager.incBytecodes(4);
            int currentPosition = 0;
            Label_0055: {
                if (newPosition >= 0) {
                    final boolean delimsChanged = this.delimsChanged;
                    BytecodeManager.incBytecodes(3);
                    if (!delimsChanged) {
                        currentPosition = this.newPosition;
                        BytecodeManager.incBytecodes(3);
                        break Label_0055;
                    }
                }
                final int currentPosition2 = this.currentPosition;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                currentPosition = this.skipDelimiters(currentPosition2);
            }
            this.currentPosition = currentPosition;
            BytecodeManager.incBytecodes(1);
            this.delimsChanged = false;
            BytecodeManager.incBytecodes(3);
            this.newPosition = -1;
            BytecodeManager.incBytecodes(3);
            final int currentPosition3 = this.currentPosition;
            final int maxPosition = this.maxPosition;
            BytecodeManager.incBytecodes(5);
            if (currentPosition3 >= maxPosition) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int currentPosition4 = this.currentPosition;
            BytecodeManager.incBytecodes(3);
            final int currentPosition5 = this.currentPosition;
            BytecodeManager.incBytecodes(5);
            this.currentPosition = this.scanToken(currentPosition5);
            BytecodeManager.incBytecodes(1);
            final String str = this.str;
            final int beginIndex = currentPosition4;
            final int currentPosition6 = this.currentPosition;
            BytecodeManager.incBytecodes(6);
            final String substring = str.substring(beginIndex, currentPosition6);
            BytecodeManager.incBytecodes(1);
            return substring;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String nextToken(final String delimiters) {
        try {
            this.delimiters = delimiters;
            BytecodeManager.incBytecodes(3);
            this.delimsChanged = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.setMaxDelimCodePoint();
            BytecodeManager.incBytecodes(2);
            final String nextToken = this.nextToken();
            BytecodeManager.incBytecodes(1);
            return nextToken;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean hasMoreElements() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean hasMoreTokens = this.hasMoreTokens();
            BytecodeManager.incBytecodes(1);
            return hasMoreTokens;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object nextElement() {
        try {
            BytecodeManager.incBytecodes(2);
            final String nextToken = this.nextToken();
            BytecodeManager.incBytecodes(1);
            return nextToken;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int countTokens() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = this.currentPosition;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n3 = n2;
                final int maxPosition = this.maxPosition;
                BytecodeManager.incBytecodes(4);
                if (n3 >= maxPosition) {
                    break;
                }
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                final int skipDelimiters = this.skipDelimiters(n4);
                BytecodeManager.incBytecodes(1);
                final int n5 = skipDelimiters;
                final int maxPosition2 = this.maxPosition;
                BytecodeManager.incBytecodes(4);
                if (n5 >= maxPosition2) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final int n6 = skipDelimiters;
                BytecodeManager.incBytecodes(3);
                n2 = this.scanToken(n6);
                BytecodeManager.incBytecodes(1);
                ++n;
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
}
