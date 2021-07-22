// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.regex;

import instrumented.java.util.Objects;
import instrumented.java.util.Map;
import aic2021.engine.BytecodeManager;

public final class Matcher implements MatchResult
{
    Pattern parentPattern;
    int[] groups;
    int from;
    int to;
    int lookbehindTo;
    CharSequence text;
    static final int ENDANCHOR = 1;
    static final int NOANCHOR = 0;
    int acceptMode;
    int first;
    int last;
    int oldLast;
    int lastAppendPosition;
    int[] locals;
    boolean hitEnd;
    boolean requireEnd;
    boolean transparentBounds;
    boolean anchoringBounds;
    
    Matcher() {
        try {
            BytecodeManager.incBytecodes(2);
            this.acceptMode = 0;
            BytecodeManager.incBytecodes(3);
            this.first = -1;
            this.last = 0;
            BytecodeManager.incBytecodes(6);
            this.oldLast = -1;
            BytecodeManager.incBytecodes(3);
            this.lastAppendPosition = 0;
            BytecodeManager.incBytecodes(3);
            this.transparentBounds = false;
            BytecodeManager.incBytecodes(3);
            this.anchoringBounds = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Matcher(final Pattern parentPattern, final CharSequence text) {
        try {
            BytecodeManager.incBytecodes(2);
            this.acceptMode = 0;
            BytecodeManager.incBytecodes(3);
            this.first = -1;
            this.last = 0;
            BytecodeManager.incBytecodes(6);
            this.oldLast = -1;
            BytecodeManager.incBytecodes(3);
            this.lastAppendPosition = 0;
            BytecodeManager.incBytecodes(3);
            this.transparentBounds = false;
            BytecodeManager.incBytecodes(3);
            this.anchoringBounds = true;
            BytecodeManager.incBytecodes(3);
            this.parentPattern = parentPattern;
            BytecodeManager.incBytecodes(3);
            this.text = text;
            BytecodeManager.incBytecodes(3);
            final int capturingGroupCount = parentPattern.capturingGroupCount;
            final int b = 10;
            BytecodeManager.incBytecodes(4);
            final int max = Math.max(capturingGroupCount, b);
            BytecodeManager.incBytecodes(1);
            this.groups = new int[max * 2];
            BytecodeManager.incBytecodes(5);
            this.locals = new int[parentPattern.localCount];
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            this.reset();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Pattern pattern() {
        try {
            final Pattern parentPattern = this.parentPattern;
            BytecodeManager.incBytecodes(3);
            return parentPattern;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public MatchResult toMatchResult() {
        try {
            final Pattern parentPattern = this.parentPattern;
            final CharSequence text = this.text;
            BytecodeManager.incBytecodes(7);
            final String string = text.toString();
            BytecodeManager.incBytecodes(1);
            final Matcher matcher = new Matcher(parentPattern, string);
            BytecodeManager.incBytecodes(1);
            matcher.first = this.first;
            BytecodeManager.incBytecodes(4);
            matcher.last = this.last;
            BytecodeManager.incBytecodes(4);
            final Matcher matcher2 = matcher;
            final int[] groups = this.groups;
            BytecodeManager.incBytecodes(4);
            matcher2.groups = groups.clone();
            BytecodeManager.incBytecodes(2);
            final Matcher matcher3 = matcher;
            BytecodeManager.incBytecodes(2);
            return matcher3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher usePattern(final Pattern parentPattern) {
        try {
            BytecodeManager.incBytecodes(2);
            if (parentPattern == null) {
                final String s = "Pattern cannot be null";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.parentPattern = parentPattern;
            BytecodeManager.incBytecodes(3);
            final int capturingGroupCount = parentPattern.capturingGroupCount;
            final int b = 10;
            BytecodeManager.incBytecodes(4);
            final int max = Math.max(capturingGroupCount, b);
            BytecodeManager.incBytecodes(1);
            this.groups = new int[max * 2];
            BytecodeManager.incBytecodes(5);
            this.locals = new int[parentPattern.localCount];
            BytecodeManager.incBytecodes(4);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.groups.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    break;
                }
                this.groups[n] = -1;
                BytecodeManager.incBytecodes(5);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length2 = this.locals.length;
                BytecodeManager.incBytecodes(5);
                if (n4 >= length2) {
                    break;
                }
                this.locals[n3] = -1;
                BytecodeManager.incBytecodes(5);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher reset() {
        try {
            this.first = -1;
            BytecodeManager.incBytecodes(3);
            this.last = 0;
            BytecodeManager.incBytecodes(3);
            this.oldLast = -1;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.groups.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    break;
                }
                this.groups[n] = -1;
                BytecodeManager.incBytecodes(5);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length2 = this.locals.length;
                BytecodeManager.incBytecodes(5);
                if (n4 >= length2) {
                    break;
                }
                this.locals[n3] = -1;
                BytecodeManager.incBytecodes(5);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            this.lastAppendPosition = 0;
            BytecodeManager.incBytecodes(3);
            this.from = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.to = this.getTextLength();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher reset(final CharSequence text) {
        try {
            this.text = text;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final Matcher reset = this.reset();
            BytecodeManager.incBytecodes(1);
            return reset;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int start() {
        try {
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first < 0) {
                final String s = "No match available";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int first2 = this.first;
            BytecodeManager.incBytecodes(3);
            return first2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int start(final int i) {
        try {
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first < 0) {
                final String s = "No match available";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (i >= 0) {
                BytecodeManager.incBytecodes(3);
                final int groupCount = this.groupCount();
                BytecodeManager.incBytecodes(1);
                if (i <= groupCount) {
                    final int n = this.groups[i * 2];
                    BytecodeManager.incBytecodes(7);
                    return n;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "No group ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int start(final String s) {
        try {
            final int[] groups = this.groups;
            BytecodeManager.incBytecodes(5);
            final int n = groups[this.getMatchedGroupIndex(s) * 2];
            BytecodeManager.incBytecodes(4);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int end() {
        try {
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first < 0) {
                final String s = "No match available";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int last = this.last;
            BytecodeManager.incBytecodes(3);
            return last;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int end(final int i) {
        try {
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first < 0) {
                final String s = "No match available";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (i >= 0) {
                BytecodeManager.incBytecodes(3);
                final int groupCount = this.groupCount();
                BytecodeManager.incBytecodes(1);
                if (i <= groupCount) {
                    final int n = this.groups[i * 2 + 1];
                    BytecodeManager.incBytecodes(9);
                    return n;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "No group ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int end(final String s) {
        try {
            final int[] groups = this.groups;
            BytecodeManager.incBytecodes(5);
            final int n = groups[this.getMatchedGroupIndex(s) * 2 + 1];
            BytecodeManager.incBytecodes(6);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String group() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final String group = this.group(n);
            BytecodeManager.incBytecodes(1);
            return group;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String group(final int i) {
        try {
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first < 0) {
                final String s = "No match found";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (i >= 0) {
                BytecodeManager.incBytecodes(3);
                final int groupCount = this.groupCount();
                BytecodeManager.incBytecodes(1);
                if (i <= groupCount) {
                    final int n = this.groups[i * 2];
                    final int n2 = -1;
                    BytecodeManager.incBytecodes(8);
                    if (n != n2) {
                        final int n3 = this.groups[i * 2 + 1];
                        final int n4 = -1;
                        BytecodeManager.incBytecodes(10);
                        if (n3 != n4) {
                            final int n5 = this.groups[i * 2];
                            final int n6 = this.groups[i * 2 + 1];
                            BytecodeManager.incBytecodes(16);
                            final CharSequence subSequence = this.getSubSequence(n5, n6);
                            BytecodeManager.incBytecodes(1);
                            final String string = subSequence.toString();
                            BytecodeManager.incBytecodes(1);
                            return string;
                        }
                    }
                    final String s2 = null;
                    BytecodeManager.incBytecodes(2);
                    return s2;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "No group ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            BytecodeManager.incBytecodes(1);
            final String string2 = append2.toString();
            BytecodeManager.incBytecodes(1);
            final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String group(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final int matchedGroupIndex = this.getMatchedGroupIndex(s);
            BytecodeManager.incBytecodes(1);
            final int n = this.groups[matchedGroupIndex * 2];
            final int n2 = -1;
            BytecodeManager.incBytecodes(8);
            if (n != n2) {
                final int n3 = this.groups[matchedGroupIndex * 2 + 1];
                final int n4 = -1;
                BytecodeManager.incBytecodes(10);
                if (n3 != n4) {
                    final int n5 = this.groups[matchedGroupIndex * 2];
                    final int n6 = this.groups[matchedGroupIndex * 2 + 1];
                    BytecodeManager.incBytecodes(16);
                    final CharSequence subSequence = this.getSubSequence(n5, n6);
                    BytecodeManager.incBytecodes(1);
                    final String string = subSequence.toString();
                    BytecodeManager.incBytecodes(1);
                    return string;
                }
            }
            final String s2 = null;
            BytecodeManager.incBytecodes(2);
            return s2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int groupCount() {
        try {
            final int n = this.parentPattern.capturingGroupCount - 1;
            BytecodeManager.incBytecodes(6);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean matches() {
        try {
            final int from = this.from;
            final int n = 1;
            BytecodeManager.incBytecodes(5);
            final boolean match = this.match(from, n);
            BytecodeManager.incBytecodes(1);
            return match;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean find() {
        try {
            int n = this.last;
            BytecodeManager.incBytecodes(3);
            final int n2 = n;
            final int first = this.first;
            BytecodeManager.incBytecodes(4);
            if (n2 == first) {
                ++n;
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = n;
            final int from = this.from;
            BytecodeManager.incBytecodes(4);
            if (n3 < from) {
                n = this.from;
                BytecodeManager.incBytecodes(3);
            }
            final int n4 = n;
            final int to = this.to;
            BytecodeManager.incBytecodes(4);
            if (n4 > to) {
                int n5 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = n5;
                    final int length = this.groups.length;
                    BytecodeManager.incBytecodes(5);
                    if (n6 >= length) {
                        break;
                    }
                    this.groups[n5] = -1;
                    BytecodeManager.incBytecodes(5);
                    ++n5;
                    BytecodeManager.incBytecodes(2);
                }
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int n7 = n;
            BytecodeManager.incBytecodes(3);
            final boolean search = this.search(n7);
            BytecodeManager.incBytecodes(1);
            return search;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean find(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int textLength = this.getTextLength();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int n2 = textLength;
                BytecodeManager.incBytecodes(3);
                if (n <= n2) {
                    BytecodeManager.incBytecodes(2);
                    this.reset();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(3);
                    final boolean search = this.search(n);
                    BytecodeManager.incBytecodes(1);
                    return search;
                }
            }
            final String s = "Illegal start index";
            BytecodeManager.incBytecodes(4);
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean lookingAt() {
        try {
            final int from = this.from;
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            final boolean match = this.match(from, n);
            BytecodeManager.incBytecodes(1);
            return match;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String quoteReplacement(final String s) {
        try {
            final int ch = 92;
            BytecodeManager.incBytecodes(3);
            final int index = s.indexOf(ch);
            final int n = -1;
            BytecodeManager.incBytecodes(2);
            if (index == n) {
                final int ch2 = 36;
                BytecodeManager.incBytecodes(3);
                final int index2 = s.indexOf(ch2);
                final int n2 = -1;
                BytecodeManager.incBytecodes(2);
                if (index2 == n2) {
                    BytecodeManager.incBytecodes(2);
                    return s;
                }
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                final int length = s.length();
                BytecodeManager.incBytecodes(1);
                if (n4 >= length) {
                    break;
                }
                final int index3 = n3;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index3);
                BytecodeManager.incBytecodes(1);
                final char c = char1;
                final int n5 = '\\';
                BytecodeManager.incBytecodes(3);
                Label_0145: {
                    if (c != n5) {
                        final char c2 = char1;
                        final int n6 = '$';
                        BytecodeManager.incBytecodes(3);
                        if (c2 != n6) {
                            break Label_0145;
                        }
                    }
                    final StringBuilder sb2 = sb;
                    final char c3 = '\\';
                    BytecodeManager.incBytecodes(3);
                    sb2.append(c3);
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuilder sb3 = sb;
                final char c4 = char1;
                BytecodeManager.incBytecodes(3);
                sb3.append(c4);
                BytecodeManager.incBytecodes(1);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb4 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb4.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher appendReplacement(final StringBuffer sb, final String s) {
        try {
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first < 0) {
                final String s2 = "No match available";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb2 = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            Label_1138: {
                while (true) {
                    final int n2 = n;
                    BytecodeManager.incBytecodes(3);
                    final int length = s.length();
                    BytecodeManager.incBytecodes(1);
                    if (n2 >= length) {
                        break Label_1138;
                    }
                    final int index = n;
                    BytecodeManager.incBytecodes(3);
                    final char char1 = s.charAt(index);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int n3 = '\\';
                    BytecodeManager.incBytecodes(3);
                    if (c == n3) {
                        ++n;
                        BytecodeManager.incBytecodes(1);
                        final int n4 = n;
                        BytecodeManager.incBytecodes(3);
                        final int length2 = s.length();
                        BytecodeManager.incBytecodes(1);
                        if (n4 == length2) {
                            final String s3 = "character to be escaped is missing";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex2 = new IllegalArgumentException(s3);
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final int index2 = n;
                        BytecodeManager.incBytecodes(3);
                        final char char2 = s.charAt(index2);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb3 = sb2;
                        final char c2 = char2;
                        BytecodeManager.incBytecodes(3);
                        sb3.append(c2);
                        BytecodeManager.incBytecodes(1);
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final char c3 = char1;
                        final int n5 = '$';
                        BytecodeManager.incBytecodes(3);
                        if (c3 == n5) {
                            ++n;
                            BytecodeManager.incBytecodes(1);
                            final int n6 = n;
                            BytecodeManager.incBytecodes(3);
                            final int length3 = s.length();
                            BytecodeManager.incBytecodes(1);
                            if (n6 == length3) {
                                final String s4 = "Illegal group reference: group index is missing";
                                BytecodeManager.incBytecodes(4);
                                final IllegalArgumentException ex3 = new IllegalArgumentException(s4);
                                BytecodeManager.incBytecodes(1);
                                throw ex3;
                            }
                            final int index3 = n;
                            BytecodeManager.incBytecodes(3);
                            char c4 = s.charAt(index3);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            final char c5 = c4;
                            final int n7 = '{';
                            BytecodeManager.incBytecodes(3);
                            int intValue;
                            if (c5 == n7) {
                                ++n;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder sb4 = new StringBuilder();
                                BytecodeManager.incBytecodes(1);
                                while (true) {
                                    final int n8 = n;
                                    BytecodeManager.incBytecodes(3);
                                    final int length4 = s.length();
                                    BytecodeManager.incBytecodes(1);
                                    if (n8 >= length4) {
                                        break;
                                    }
                                    final int index4 = n;
                                    BytecodeManager.incBytecodes(3);
                                    c4 = s.charAt(index4);
                                    BytecodeManager.incBytecodes(1);
                                    final char c6 = c4;
                                    BytecodeManager.incBytecodes(2);
                                    final boolean lower = ASCII.isLower(c6);
                                    BytecodeManager.incBytecodes(1);
                                    if (!lower) {
                                        final char c7 = c4;
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean upper = ASCII.isUpper(c7);
                                        BytecodeManager.incBytecodes(1);
                                        if (!upper) {
                                            final char c8 = c4;
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                            final boolean digit = ASCII.isDigit(c8);
                                            BytecodeManager.incBytecodes(1);
                                            if (!digit) {
                                                break;
                                            }
                                        }
                                    }
                                    final StringBuilder sb5 = sb4;
                                    final char c9 = c4;
                                    BytecodeManager.incBytecodes(3);
                                    sb5.append(c9);
                                    BytecodeManager.incBytecodes(1);
                                    ++n;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final StringBuilder sb6 = sb4;
                                BytecodeManager.incBytecodes(2);
                                final int length5 = sb6.length();
                                BytecodeManager.incBytecodes(1);
                                if (length5 == 0) {
                                    final String s5 = "named capturing group has 0 length name";
                                    BytecodeManager.incBytecodes(4);
                                    final IllegalArgumentException ex4 = new IllegalArgumentException(s5);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex4;
                                }
                                final char c10 = c4;
                                final int n9 = '}';
                                BytecodeManager.incBytecodes(3);
                                if (c10 != n9) {
                                    final String s6 = "named capturing group is missing trailing '}'";
                                    BytecodeManager.incBytecodes(4);
                                    final IllegalArgumentException ex5 = new IllegalArgumentException(s6);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex5;
                                }
                                final StringBuilder sb7 = sb4;
                                BytecodeManager.incBytecodes(2);
                                final String string = sb7.toString();
                                BytecodeManager.incBytecodes(1);
                                final String s7 = string;
                                final int index5 = 0;
                                BytecodeManager.incBytecodes(3);
                                final char char3 = s7.charAt(index5);
                                BytecodeManager.incBytecodes(1);
                                final boolean digit2 = ASCII.isDigit(char3);
                                BytecodeManager.incBytecodes(1);
                                if (digit2) {
                                    BytecodeManager.incBytecodes(5);
                                    final StringBuilder sb8 = new StringBuilder();
                                    final String str = "capturing group name {";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append = sb8.append(str);
                                    final String str2 = string;
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append2 = append.append(str2);
                                    final String str3 = "} starts with digit character";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append3 = append2.append(str3);
                                    BytecodeManager.incBytecodes(1);
                                    final String string2 = append3.toString();
                                    BytecodeManager.incBytecodes(1);
                                    final IllegalArgumentException ex6 = new IllegalArgumentException(string2);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex6;
                                }
                                final Pattern parentPattern = this.parentPattern;
                                BytecodeManager.incBytecodes(3);
                                final Map<String, Integer> namedGroups = parentPattern.namedGroups();
                                final String s8 = string;
                                BytecodeManager.incBytecodes(2);
                                final boolean containsKey = namedGroups.containsKey(s8);
                                BytecodeManager.incBytecodes(1);
                                if (!containsKey) {
                                    BytecodeManager.incBytecodes(5);
                                    final StringBuilder sb9 = new StringBuilder();
                                    final String str4 = "No group with name {";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append4 = sb9.append(str4);
                                    final String str5 = string;
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append5 = append4.append(str5);
                                    final String str6 = "}";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append6 = append5.append(str6);
                                    BytecodeManager.incBytecodes(1);
                                    final String string3 = append6.toString();
                                    BytecodeManager.incBytecodes(1);
                                    final IllegalArgumentException ex7 = new IllegalArgumentException(string3);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex7;
                                }
                                final Pattern parentPattern2 = this.parentPattern;
                                BytecodeManager.incBytecodes(3);
                                final Map<String, Integer> namedGroups2 = parentPattern2.namedGroups();
                                final String s9 = string;
                                BytecodeManager.incBytecodes(2);
                                final Integer n10 = namedGroups2.get(s9);
                                BytecodeManager.incBytecodes(2);
                                intValue = n10;
                                BytecodeManager.incBytecodes(1);
                                ++n;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                intValue = c4 - '0';
                                BytecodeManager.incBytecodes(4);
                                final int n11 = intValue;
                                BytecodeManager.incBytecodes(2);
                                if (n11 < 0) {
                                    break;
                                }
                                final int n12 = intValue;
                                final int n13 = 9;
                                BytecodeManager.incBytecodes(3);
                                if (n12 > n13) {
                                    break;
                                }
                                ++n;
                                BytecodeManager.incBytecodes(1);
                                boolean b = false;
                                BytecodeManager.incBytecodes(2);
                                while (true) {
                                    final boolean b2 = b;
                                    BytecodeManager.incBytecodes(2);
                                    if (b2) {
                                        break;
                                    }
                                    final int n14 = n;
                                    BytecodeManager.incBytecodes(3);
                                    final int length6 = s.length();
                                    BytecodeManager.incBytecodes(1);
                                    if (n14 >= length6) {
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    final int index6 = n;
                                    BytecodeManager.incBytecodes(3);
                                    final int n15 = s.charAt(index6) - '0';
                                    BytecodeManager.incBytecodes(3);
                                    final int n16 = n15;
                                    BytecodeManager.incBytecodes(2);
                                    if (n16 < 0) {
                                        break;
                                    }
                                    final int n17 = n15;
                                    final int n18 = 9;
                                    BytecodeManager.incBytecodes(3);
                                    if (n17 > n18) {
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    final int n19 = intValue * 10 + n15;
                                    BytecodeManager.incBytecodes(6);
                                    BytecodeManager.incBytecodes(2);
                                    final int groupCount = this.groupCount();
                                    final int n20 = n19;
                                    BytecodeManager.incBytecodes(2);
                                    if (groupCount < n20) {
                                        b = true;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    else {
                                        intValue = n19;
                                        BytecodeManager.incBytecodes(2);
                                        ++n;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final int n21 = intValue;
                            BytecodeManager.incBytecodes(3);
                            final int start = this.start(n21);
                            final int n22 = -1;
                            BytecodeManager.incBytecodes(2);
                            if (start != n22) {
                                final int n23 = intValue;
                                BytecodeManager.incBytecodes(3);
                                final int end = this.end(n23);
                                final int n24 = -1;
                                BytecodeManager.incBytecodes(2);
                                if (end != n24) {
                                    final StringBuilder sb10 = sb2;
                                    final CharSequence text = this.text;
                                    final int n25 = intValue;
                                    BytecodeManager.incBytecodes(6);
                                    final int start2 = this.start(n25);
                                    final int n26 = intValue;
                                    BytecodeManager.incBytecodes(3);
                                    final int end2 = this.end(n26);
                                    BytecodeManager.incBytecodes(1);
                                    sb10.append(text, start2, end2);
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final StringBuilder sb11 = sb2;
                            final char c11 = char1;
                            BytecodeManager.incBytecodes(3);
                            sb11.append(c11);
                            BytecodeManager.incBytecodes(1);
                            ++n;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final String s10 = "Illegal group reference";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex8 = new IllegalArgumentException(s10);
                BytecodeManager.incBytecodes(1);
                throw ex8;
            }
            final CharSequence text2 = this.text;
            final int lastAppendPosition = this.lastAppendPosition;
            final int first2 = this.first;
            BytecodeManager.incBytecodes(8);
            sb.append(text2, lastAppendPosition, first2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder s11 = sb2;
            BytecodeManager.incBytecodes(3);
            sb.append((CharSequence)s11);
            BytecodeManager.incBytecodes(1);
            this.lastAppendPosition = this.last;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringBuffer appendTail(final StringBuffer sb) {
        try {
            final CharSequence text = this.text;
            final int lastAppendPosition = this.lastAppendPosition;
            BytecodeManager.incBytecodes(7);
            final int textLength = this.getTextLength();
            BytecodeManager.incBytecodes(1);
            sb.append(text, lastAppendPosition, textLength);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            return sb;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String replaceAll(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            this.reset();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final boolean find = this.find();
            BytecodeManager.incBytecodes(1);
            final boolean b = find;
            BytecodeManager.incBytecodes(2);
            if (b) {
                BytecodeManager.incBytecodes(3);
                final StringBuffer sb = new StringBuffer();
                BytecodeManager.incBytecodes(1);
                boolean b2;
                do {
                    final StringBuffer sb2 = sb;
                    BytecodeManager.incBytecodes(4);
                    this.appendReplacement(sb2, s);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    final boolean find2 = this.find();
                    BytecodeManager.incBytecodes(1);
                    b2 = find2;
                    BytecodeManager.incBytecodes(2);
                } while (b2);
                final StringBuffer sb3 = sb;
                BytecodeManager.incBytecodes(3);
                this.appendTail(sb3);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb4 = sb;
                BytecodeManager.incBytecodes(2);
                final String string = sb4.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            final CharSequence text = this.text;
            BytecodeManager.incBytecodes(3);
            final String string2 = text.toString();
            BytecodeManager.incBytecodes(1);
            return string2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String replaceFirst(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                final String s2 = "replacement";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.reset();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final boolean find = this.find();
            BytecodeManager.incBytecodes(1);
            if (!find) {
                final CharSequence text = this.text;
                BytecodeManager.incBytecodes(3);
                final String string = text.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuffer sb = new StringBuffer();
            BytecodeManager.incBytecodes(1);
            final StringBuffer sb2 = sb;
            BytecodeManager.incBytecodes(4);
            this.appendReplacement(sb2, s);
            BytecodeManager.incBytecodes(1);
            final StringBuffer sb3 = sb;
            BytecodeManager.incBytecodes(3);
            this.appendTail(sb3);
            BytecodeManager.incBytecodes(1);
            final StringBuffer sb4 = sb;
            BytecodeManager.incBytecodes(2);
            final String string2 = sb4.toString();
            BytecodeManager.incBytecodes(1);
            return string2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher region(final int from, final int to) {
        try {
            BytecodeManager.incBytecodes(2);
            if (from >= 0) {
                BytecodeManager.incBytecodes(3);
                final int textLength = this.getTextLength();
                BytecodeManager.incBytecodes(1);
                if (from <= textLength) {
                    BytecodeManager.incBytecodes(2);
                    if (to >= 0) {
                        BytecodeManager.incBytecodes(3);
                        final int textLength2 = this.getTextLength();
                        BytecodeManager.incBytecodes(1);
                        if (to <= textLength2) {
                            BytecodeManager.incBytecodes(3);
                            if (from > to) {
                                final String s = "start > end";
                                BytecodeManager.incBytecodes(4);
                                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(s);
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            BytecodeManager.incBytecodes(2);
                            this.reset();
                            BytecodeManager.incBytecodes(1);
                            this.from = from;
                            BytecodeManager.incBytecodes(3);
                            this.to = to;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(2);
                            return this;
                        }
                    }
                    final String s2 = "end";
                    BytecodeManager.incBytecodes(4);
                    final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
            }
            final String s3 = "start";
            BytecodeManager.incBytecodes(4);
            final IndexOutOfBoundsException ex3 = new IndexOutOfBoundsException(s3);
            BytecodeManager.incBytecodes(1);
            throw ex3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int regionStart() {
        try {
            final int from = this.from;
            BytecodeManager.incBytecodes(3);
            return from;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int regionEnd() {
        try {
            final int to = this.to;
            BytecodeManager.incBytecodes(3);
            return to;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasTransparentBounds() {
        try {
            final boolean transparentBounds = this.transparentBounds;
            BytecodeManager.incBytecodes(3);
            return transparentBounds;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher useTransparentBounds(final boolean transparentBounds) {
        try {
            this.transparentBounds = transparentBounds;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasAnchoringBounds() {
        try {
            final boolean anchoringBounds = this.anchoringBounds;
            BytecodeManager.incBytecodes(3);
            return anchoringBounds;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Matcher useAnchoringBounds(final boolean anchoringBounds) {
        try {
            this.anchoringBounds = anchoringBounds;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final String str = "java.util.regex.Matcher";
            BytecodeManager.incBytecodes(3);
            sb2.append(str);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb3 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb4 = new StringBuilder();
            final String str2 = "[pattern=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb4.append(str2);
            BytecodeManager.incBytecodes(2);
            final Pattern pattern = this.pattern();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(pattern);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            sb3.append(string);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb5 = sb;
            final String str3 = " region=";
            BytecodeManager.incBytecodes(3);
            sb5.append(str3);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb6 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb7 = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final int regionStart = this.regionStart();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append3 = sb7.append(regionStart);
            final String str4 = ",";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(str4);
            BytecodeManager.incBytecodes(2);
            final int regionEnd = this.regionEnd();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append5 = append4.append(regionEnd);
            BytecodeManager.incBytecodes(1);
            final String string2 = append5.toString();
            BytecodeManager.incBytecodes(1);
            sb6.append(string2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb8 = sb;
            final String str5 = " lastmatch=";
            BytecodeManager.incBytecodes(3);
            sb8.append(str5);
            BytecodeManager.incBytecodes(1);
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first >= 0) {
                BytecodeManager.incBytecodes(2);
                final String group = this.group();
                BytecodeManager.incBytecodes(1);
                if (group != null) {
                    final StringBuilder sb9 = sb;
                    BytecodeManager.incBytecodes(3);
                    final String group2 = this.group();
                    BytecodeManager.incBytecodes(1);
                    sb9.append(group2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final StringBuilder sb10 = sb;
            final String str6 = "]";
            BytecodeManager.incBytecodes(3);
            sb10.append(str6);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb11 = sb;
            BytecodeManager.incBytecodes(2);
            final String string3 = sb11.toString();
            BytecodeManager.incBytecodes(1);
            return string3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hitEnd() {
        try {
            final boolean hitEnd = this.hitEnd;
            BytecodeManager.incBytecodes(3);
            return hitEnd;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean requireEnd() {
        try {
            final boolean requireEnd = this.requireEnd;
            BytecodeManager.incBytecodes(3);
            return requireEnd;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean search(int first) {
        try {
            this.hitEnd = false;
            BytecodeManager.incBytecodes(3);
            this.requireEnd = false;
            BytecodeManager.incBytecodes(3);
            final int n = first;
            BytecodeManager.incBytecodes(2);
            int n2;
            if (n < 0) {
                n2 = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = first;
                BytecodeManager.incBytecodes(1);
            }
            first = n2;
            BytecodeManager.incBytecodes(1);
            this.first = first;
            BytecodeManager.incBytecodes(3);
            final int oldLast = this.oldLast;
            BytecodeManager.incBytecodes(4);
            int oldLast2;
            if (oldLast < 0) {
                oldLast2 = first;
                BytecodeManager.incBytecodes(2);
            }
            else {
                oldLast2 = this.oldLast;
                BytecodeManager.incBytecodes(2);
            }
            this.oldLast = oldLast2;
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length = this.groups.length;
                BytecodeManager.incBytecodes(5);
                if (n4 >= length) {
                    break;
                }
                this.groups[n3] = -1;
                BytecodeManager.incBytecodes(5);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            this.acceptMode = 0;
            BytecodeManager.incBytecodes(3);
            final Pattern.Node root = this.parentPattern.root;
            final int n5 = first;
            final CharSequence text = this.text;
            BytecodeManager.incBytecodes(8);
            final boolean match = root.match(this, n5, text);
            BytecodeManager.incBytecodes(1);
            final boolean b = match;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                this.first = -1;
                BytecodeManager.incBytecodes(3);
            }
            this.oldLast = this.last;
            BytecodeManager.incBytecodes(4);
            final boolean b2 = match;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean match(int first, final int acceptMode) {
        try {
            this.hitEnd = false;
            BytecodeManager.incBytecodes(3);
            this.requireEnd = false;
            BytecodeManager.incBytecodes(3);
            final int n = first;
            BytecodeManager.incBytecodes(2);
            int n2;
            if (n < 0) {
                n2 = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = first;
                BytecodeManager.incBytecodes(1);
            }
            first = n2;
            BytecodeManager.incBytecodes(1);
            this.first = first;
            BytecodeManager.incBytecodes(3);
            final int oldLast = this.oldLast;
            BytecodeManager.incBytecodes(4);
            int oldLast2;
            if (oldLast < 0) {
                oldLast2 = first;
                BytecodeManager.incBytecodes(2);
            }
            else {
                oldLast2 = this.oldLast;
                BytecodeManager.incBytecodes(2);
            }
            this.oldLast = oldLast2;
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int length = this.groups.length;
                BytecodeManager.incBytecodes(5);
                if (n4 >= length) {
                    break;
                }
                this.groups[n3] = -1;
                BytecodeManager.incBytecodes(5);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            this.acceptMode = acceptMode;
            BytecodeManager.incBytecodes(3);
            final Pattern.Node matchRoot = this.parentPattern.matchRoot;
            final int n5 = first;
            final CharSequence text = this.text;
            BytecodeManager.incBytecodes(8);
            final boolean match = matchRoot.match(this, n5, text);
            BytecodeManager.incBytecodes(1);
            final boolean b = match;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                this.first = -1;
                BytecodeManager.incBytecodes(3);
            }
            this.oldLast = this.last;
            BytecodeManager.incBytecodes(4);
            final boolean b2 = match;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int getTextLength() {
        try {
            final CharSequence text = this.text;
            BytecodeManager.incBytecodes(3);
            final int length = text.length();
            BytecodeManager.incBytecodes(1);
            return length;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    CharSequence getSubSequence(final int n, final int n2) {
        try {
            final CharSequence text = this.text;
            BytecodeManager.incBytecodes(5);
            final CharSequence subSequence = text.subSequence(n, n2);
            BytecodeManager.incBytecodes(1);
            return subSequence;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    char charAt(final int n) {
        try {
            final CharSequence text = this.text;
            BytecodeManager.incBytecodes(4);
            final char char1 = text.charAt(n);
            BytecodeManager.incBytecodes(1);
            return char1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int getMatchedGroupIndex(final String str) {
        try {
            final String s = "Group name";
            BytecodeManager.incBytecodes(3);
            Objects.requireNonNull(str, s);
            BytecodeManager.incBytecodes(1);
            final int first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first < 0) {
                final String s2 = "No match found";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Pattern parentPattern = this.parentPattern;
            BytecodeManager.incBytecodes(3);
            final Map<String, Integer> namedGroups = parentPattern.namedGroups();
            BytecodeManager.incBytecodes(2);
            final boolean containsKey = namedGroups.containsKey(str);
            BytecodeManager.incBytecodes(1);
            if (!containsKey) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str2 = "No group with name <";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final String str3 = ">";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex2 = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final Pattern parentPattern2 = this.parentPattern;
            BytecodeManager.incBytecodes(3);
            final Map<String, Integer> namedGroups2 = parentPattern2.namedGroups();
            BytecodeManager.incBytecodes(2);
            final Integer n = namedGroups2.get(str);
            BytecodeManager.incBytecodes(2);
            final int intValue = n;
            BytecodeManager.incBytecodes(1);
            return intValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
