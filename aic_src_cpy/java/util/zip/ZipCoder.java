// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import instrumented.java.util.Arrays;
import sun.nio.cs.ArrayEncoder;
import java.nio.charset.CoderResult;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import sun.nio.cs.ArrayDecoder;
import aic2021.engine.BytecodeManager;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.Charset;

final class ZipCoder
{
    private Charset cs;
    private CharsetDecoder dec;
    private CharsetEncoder enc;
    private boolean isUTF8;
    private ZipCoder utf8;
    
    String toString(final byte[] array, final int length) {
        try {
            BytecodeManager.incBytecodes(2);
            final CharsetDecoder decoder = this.decoder();
            BytecodeManager.incBytecodes(1);
            final CharsetDecoder reset = decoder.reset();
            BytecodeManager.incBytecodes(1);
            final float n = (float)length;
            final CharsetDecoder charsetDecoder = reset;
            BytecodeManager.incBytecodes(4);
            final int n2 = (int)(n * charsetDecoder.maxCharsPerByte());
            BytecodeManager.incBytecodes(3);
            final char[] array2 = new char[n2];
            BytecodeManager.incBytecodes(2);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 == 0) {
                final char[] value = array2;
                BytecodeManager.incBytecodes(4);
                final String s = new String(value);
                BytecodeManager.incBytecodes(1);
                return s;
            }
            final boolean isUTF8 = this.isUTF8;
            BytecodeManager.incBytecodes(3);
            if (isUTF8) {
                final boolean b = reset instanceof ArrayDecoder;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final ArrayDecoder arrayDecoder = (ArrayDecoder)reset;
                    final int n4 = 0;
                    final char[] array3 = array2;
                    BytecodeManager.incBytecodes(7);
                    final int decode = arrayDecoder.decode(array, n4, length, array3);
                    BytecodeManager.incBytecodes(1);
                    final int n5 = decode;
                    final int n6 = -1;
                    BytecodeManager.incBytecodes(3);
                    if (n5 == n6) {
                        final String s2 = "MALFORMED";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s2);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final char[] value2 = array2;
                    final int offset = 0;
                    final int count = decode;
                    BytecodeManager.incBytecodes(6);
                    final String s3 = new String(value2, offset, count);
                    BytecodeManager.incBytecodes(1);
                    return s3;
                }
            }
            final int offset2 = 0;
            BytecodeManager.incBytecodes(4);
            final ByteBuffer wrap = ByteBuffer.wrap(array, offset2, length);
            BytecodeManager.incBytecodes(1);
            final char[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            final CharBuffer wrap2 = CharBuffer.wrap(array4);
            BytecodeManager.incBytecodes(1);
            final CharsetDecoder charsetDecoder2 = reset;
            final ByteBuffer in = wrap;
            final CharBuffer out = wrap2;
            final boolean endOfInput = true;
            BytecodeManager.incBytecodes(5);
            final CoderResult decode2 = charsetDecoder2.decode(in, out, endOfInput);
            BytecodeManager.incBytecodes(1);
            final CoderResult coderResult = decode2;
            BytecodeManager.incBytecodes(2);
            final boolean underflow = coderResult.isUnderflow();
            BytecodeManager.incBytecodes(1);
            if (!underflow) {
                final CoderResult coderResult2 = decode2;
                BytecodeManager.incBytecodes(4);
                final String string = coderResult2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex2 = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final CharsetDecoder charsetDecoder3 = reset;
            final CharBuffer out2 = wrap2;
            BytecodeManager.incBytecodes(3);
            final CoderResult flush = charsetDecoder3.flush(out2);
            BytecodeManager.incBytecodes(1);
            final CoderResult coderResult3 = flush;
            BytecodeManager.incBytecodes(2);
            final boolean underflow2 = coderResult3.isUnderflow();
            BytecodeManager.incBytecodes(1);
            if (!underflow2) {
                final CoderResult coderResult4 = flush;
                BytecodeManager.incBytecodes(4);
                final String string2 = coderResult4.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex3 = new IllegalArgumentException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            final char[] value3 = array2;
            final int offset3 = 0;
            final CharBuffer charBuffer = wrap2;
            BytecodeManager.incBytecodes(6);
            final int position = charBuffer.position();
            BytecodeManager.incBytecodes(1);
            final String s4 = new String(value3, offset3, position);
            BytecodeManager.incBytecodes(1);
            return s4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    String toString(final byte[] ba) {
        try {
            final int length = ba.length;
            BytecodeManager.incBytecodes(5);
            final String string = this.toString(ba, length);
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    byte[] getBytes(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final CharsetEncoder encoder = this.encoder();
            BytecodeManager.incBytecodes(1);
            final CharsetEncoder reset = encoder.reset();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final char[] charArray = s.toCharArray();
            BytecodeManager.incBytecodes(1);
            final float n = (float)charArray.length;
            final CharsetEncoder charsetEncoder = reset;
            BytecodeManager.incBytecodes(5);
            final int n2 = (int)(n * charsetEncoder.maxBytesPerChar());
            BytecodeManager.incBytecodes(3);
            final byte[] array = new byte[n2];
            BytecodeManager.incBytecodes(2);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 == 0) {
                final byte[] array2 = array;
                BytecodeManager.incBytecodes(2);
                return array2;
            }
            final boolean isUTF8 = this.isUTF8;
            BytecodeManager.incBytecodes(3);
            if (isUTF8) {
                final boolean b = reset instanceof ArrayEncoder;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final ArrayEncoder arrayEncoder = (ArrayEncoder)reset;
                    final char[] array3 = charArray;
                    final int n4 = 0;
                    final int length = charArray.length;
                    final byte[] array4 = array;
                    BytecodeManager.incBytecodes(8);
                    final int encode = arrayEncoder.encode(array3, n4, length, array4);
                    BytecodeManager.incBytecodes(1);
                    final int n5 = encode;
                    final int n6 = -1;
                    BytecodeManager.incBytecodes(3);
                    if (n5 == n6) {
                        final String s2 = "MALFORMED";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s2);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final byte[] array5 = array;
                    final int n7 = encode;
                    BytecodeManager.incBytecodes(3);
                    final byte[] copy = Arrays.copyOf(array5, n7);
                    BytecodeManager.incBytecodes(1);
                    return copy;
                }
            }
            final byte[] array6 = array;
            BytecodeManager.incBytecodes(2);
            final ByteBuffer wrap = ByteBuffer.wrap(array6);
            BytecodeManager.incBytecodes(1);
            final char[] array7 = charArray;
            BytecodeManager.incBytecodes(2);
            final CharBuffer wrap2 = CharBuffer.wrap(array7);
            BytecodeManager.incBytecodes(1);
            final CharsetEncoder charsetEncoder2 = reset;
            final CharBuffer in = wrap2;
            final ByteBuffer out = wrap;
            final boolean endOfInput = true;
            BytecodeManager.incBytecodes(5);
            final CoderResult encode2 = charsetEncoder2.encode(in, out, endOfInput);
            BytecodeManager.incBytecodes(1);
            final CoderResult coderResult = encode2;
            BytecodeManager.incBytecodes(2);
            final boolean underflow = coderResult.isUnderflow();
            BytecodeManager.incBytecodes(1);
            if (!underflow) {
                final CoderResult coderResult2 = encode2;
                BytecodeManager.incBytecodes(4);
                final String string = coderResult2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex2 = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final CharsetEncoder charsetEncoder3 = reset;
            final ByteBuffer out2 = wrap;
            BytecodeManager.incBytecodes(3);
            final CoderResult flush = charsetEncoder3.flush(out2);
            BytecodeManager.incBytecodes(1);
            final CoderResult coderResult3 = flush;
            BytecodeManager.incBytecodes(2);
            final boolean underflow2 = coderResult3.isUnderflow();
            BytecodeManager.incBytecodes(1);
            if (!underflow2) {
                final CoderResult coderResult4 = flush;
                BytecodeManager.incBytecodes(4);
                final String string2 = coderResult4.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex3 = new IllegalArgumentException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            final ByteBuffer byteBuffer = wrap;
            BytecodeManager.incBytecodes(2);
            final int position = byteBuffer.position();
            final int length2 = array.length;
            BytecodeManager.incBytecodes(3);
            if (position == length2) {
                final byte[] array8 = array;
                BytecodeManager.incBytecodes(2);
                return array8;
            }
            final byte[] array9 = array;
            final ByteBuffer byteBuffer2 = wrap;
            BytecodeManager.incBytecodes(3);
            final int position2 = byteBuffer2.position();
            BytecodeManager.incBytecodes(1);
            final byte[] copy2 = Arrays.copyOf(array9, position2);
            BytecodeManager.incBytecodes(1);
            return copy2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    byte[] getBytesUTF8(final String s) {
        try {
            final boolean isUTF8 = this.isUTF8;
            BytecodeManager.incBytecodes(3);
            if (isUTF8) {
                BytecodeManager.incBytecodes(3);
                final byte[] bytes = this.getBytes(s);
                BytecodeManager.incBytecodes(1);
                return bytes;
            }
            final ZipCoder utf8 = this.utf8;
            BytecodeManager.incBytecodes(3);
            if (utf8 == null) {
                final Charset utf_8 = StandardCharsets.UTF_8;
                BytecodeManager.incBytecodes(5);
                this.utf8 = new ZipCoder(utf_8);
                BytecodeManager.incBytecodes(1);
            }
            final ZipCoder utf9 = this.utf8;
            BytecodeManager.incBytecodes(4);
            final byte[] bytes2 = utf9.getBytes(s);
            BytecodeManager.incBytecodes(1);
            return bytes2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    String toStringUTF8(final byte[] array, final int n) {
        try {
            final boolean isUTF8 = this.isUTF8;
            BytecodeManager.incBytecodes(3);
            if (isUTF8) {
                BytecodeManager.incBytecodes(4);
                final String string = this.toString(array, n);
                BytecodeManager.incBytecodes(1);
                return string;
            }
            final ZipCoder utf8 = this.utf8;
            BytecodeManager.incBytecodes(3);
            if (utf8 == null) {
                final Charset utf_8 = StandardCharsets.UTF_8;
                BytecodeManager.incBytecodes(5);
                this.utf8 = new ZipCoder(utf_8);
                BytecodeManager.incBytecodes(1);
            }
            final ZipCoder utf9 = this.utf8;
            BytecodeManager.incBytecodes(5);
            final String string2 = utf9.toString(array, n);
            BytecodeManager.incBytecodes(1);
            return string2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean isUTF8() {
        try {
            final boolean isUTF8 = this.isUTF8;
            BytecodeManager.incBytecodes(3);
            return isUTF8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private ZipCoder(final Charset cs) {
        try {
            BytecodeManager.incBytecodes(2);
            this.cs = cs;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            final String name = cs.name();
            final Charset utf_8 = StandardCharsets.UTF_8;
            BytecodeManager.incBytecodes(2);
            final String name2 = utf_8.name();
            BytecodeManager.incBytecodes(1);
            this.isUTF8 = name.equals(name2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static ZipCoder get(final Charset cs) {
        try {
            BytecodeManager.incBytecodes(4);
            final ZipCoder zipCoder = new ZipCoder(cs);
            BytecodeManager.incBytecodes(1);
            return zipCoder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharsetDecoder decoder() {
        try {
            final CharsetDecoder dec = this.dec;
            BytecodeManager.incBytecodes(3);
            if (dec == null) {
                final Charset cs = this.cs;
                BytecodeManager.incBytecodes(4);
                final CharsetDecoder decoder = cs.newDecoder();
                final CodingErrorAction report = CodingErrorAction.REPORT;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final CharsetDecoder onMalformedInput = decoder.onMalformedInput(report);
                final CodingErrorAction report2 = CodingErrorAction.REPORT;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                this.dec = onMalformedInput.onUnmappableCharacter(report2);
                BytecodeManager.incBytecodes(1);
            }
            final CharsetDecoder dec2 = this.dec;
            BytecodeManager.incBytecodes(3);
            return dec2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CharsetEncoder encoder() {
        try {
            final CharsetEncoder enc = this.enc;
            BytecodeManager.incBytecodes(3);
            if (enc == null) {
                final Charset cs = this.cs;
                BytecodeManager.incBytecodes(4);
                final CharsetEncoder encoder = cs.newEncoder();
                final CodingErrorAction report = CodingErrorAction.REPORT;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final CharsetEncoder onMalformedInput = encoder.onMalformedInput(report);
                final CodingErrorAction report2 = CodingErrorAction.REPORT;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                this.enc = onMalformedInput.onUnmappableCharacter(report2);
                BytecodeManager.incBytecodes(1);
            }
            final CharsetEncoder enc2 = this.enc;
            BytecodeManager.incBytecodes(3);
            return enc2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
