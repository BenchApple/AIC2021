// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public final class StringJoiner
{
    private final String prefix;
    private final String delimiter;
    private final String suffix;
    private StringBuilder value;
    private String emptyValue;
    
    public StringJoiner(final CharSequence charSequence) {
        try {
            final String s = "";
            final String s2 = "";
            BytecodeManager.incBytecodes(5);
            this(charSequence, s, s2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringJoiner(final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3) {
        try {
            BytecodeManager.incBytecodes(2);
            final String s = "The prefix must not be null";
            BytecodeManager.incBytecodes(3);
            Objects.requireNonNull(charSequence2, s);
            BytecodeManager.incBytecodes(1);
            final String s2 = "The delimiter must not be null";
            BytecodeManager.incBytecodes(3);
            Objects.requireNonNull(charSequence, s2);
            BytecodeManager.incBytecodes(1);
            final String s3 = "The suffix must not be null";
            BytecodeManager.incBytecodes(3);
            Objects.requireNonNull(charSequence3, s3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.prefix = charSequence2.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.delimiter = charSequence.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.suffix = charSequence3.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            final String prefix = this.prefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb.append(prefix);
            final String suffix = this.suffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(suffix);
            BytecodeManager.incBytecodes(1);
            this.emptyValue = append2.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringJoiner setEmptyValue(final CharSequence charSequence) {
        try {
            final String s = "The empty value must not be null";
            BytecodeManager.incBytecodes(4);
            final CharSequence charSequence2 = Objects.requireNonNull(charSequence, s);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            this.emptyValue = charSequence2.toString();
            BytecodeManager.incBytecodes(1);
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
            final StringBuilder value = this.value;
            BytecodeManager.incBytecodes(3);
            if (value == null) {
                final String emptyValue = this.emptyValue;
                BytecodeManager.incBytecodes(3);
                return emptyValue;
            }
            final String suffix = this.suffix;
            final String anObject = "";
            BytecodeManager.incBytecodes(4);
            final boolean equals = suffix.equals(anObject);
            BytecodeManager.incBytecodes(1);
            if (equals) {
                final StringBuilder value2 = this.value;
                BytecodeManager.incBytecodes(3);
                final String string = value2.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            final StringBuilder value3 = this.value;
            BytecodeManager.incBytecodes(3);
            final int length = value3.length();
            BytecodeManager.incBytecodes(1);
            final StringBuilder value4 = this.value;
            final String suffix2 = this.suffix;
            BytecodeManager.incBytecodes(5);
            final StringBuilder append = value4.append(suffix2);
            BytecodeManager.incBytecodes(1);
            final String string2 = append.toString();
            BytecodeManager.incBytecodes(1);
            final StringBuilder value5 = this.value;
            final int length2 = length;
            BytecodeManager.incBytecodes(4);
            value5.setLength(length2);
            final String s = string2;
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringJoiner add(final CharSequence s) {
        try {
            BytecodeManager.incBytecodes(2);
            final StringBuilder prepareBuilder = this.prepareBuilder();
            BytecodeManager.incBytecodes(2);
            prepareBuilder.append(s);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StringJoiner merge(final StringJoiner stringJoiner) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(stringJoiner);
            BytecodeManager.incBytecodes(1);
            final StringBuilder value = stringJoiner.value;
            BytecodeManager.incBytecodes(3);
            if (value != null) {
                final StringBuilder value2 = stringJoiner.value;
                BytecodeManager.incBytecodes(3);
                final int length = value2.length();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final StringBuilder prepareBuilder = this.prepareBuilder();
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb = prepareBuilder;
                final StringBuilder value3 = stringJoiner.value;
                final String prefix = stringJoiner.prefix;
                BytecodeManager.incBytecodes(6);
                final int length2 = prefix.length();
                final int end = length;
                BytecodeManager.incBytecodes(2);
                sb.append(value3, length2, end);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private StringBuilder prepareBuilder() {
        try {
            final StringBuilder value = this.value;
            BytecodeManager.incBytecodes(3);
            if (value != null) {
                final StringBuilder value2 = this.value;
                final String delimiter = this.delimiter;
                BytecodeManager.incBytecodes(5);
                value2.append(delimiter);
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb = new StringBuilder();
                final String prefix = this.prefix;
                BytecodeManager.incBytecodes(3);
                this.value = sb.append(prefix);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder value3 = this.value;
            BytecodeManager.incBytecodes(3);
            return value3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int length() {
        try {
            final StringBuilder value = this.value;
            BytecodeManager.incBytecodes(3);
            int length2;
            if (value != null) {
                final StringBuilder value2 = this.value;
                BytecodeManager.incBytecodes(3);
                final int length = value2.length();
                final String suffix = this.suffix;
                BytecodeManager.incBytecodes(3);
                length2 = length + suffix.length();
                BytecodeManager.incBytecodes(2);
            }
            else {
                final String emptyValue = this.emptyValue;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                length2 = emptyValue.length();
            }
            BytecodeManager.incBytecodes(1);
            return length2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
