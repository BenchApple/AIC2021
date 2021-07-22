// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.IOException;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import aic2021.engine.BytecodeManager;

public class Base64
{
    private Base64() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Encoder getEncoder() {
        try {
            final Encoder rfc4648 = Encoder.RFC4648;
            BytecodeManager.incBytecodes(2);
            return rfc4648;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Encoder getUrlEncoder() {
        try {
            final Encoder rfc4648_URLSAFE = Encoder.RFC4648_URLSAFE;
            BytecodeManager.incBytecodes(2);
            return rfc4648_URLSAFE;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Encoder getMimeEncoder() {
        try {
            final Encoder rfc2045 = Encoder.RFC2045;
            BytecodeManager.incBytecodes(2);
            return rfc2045;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Encoder getMimeEncoder(final int n, final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(array);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final int[] access$000 = Decoder.access$000();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            int n2 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 < n4) {
                    final byte b = array[n2];
                    BytecodeManager.incBytecodes(4);
                    final int n5 = access$000[b & 0xFF];
                    final int n6 = -1;
                    BytecodeManager.incBytecodes(7);
                    if (n5 != n6) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "Illegal base64 line separator character 0x";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final byte i = b;
                        final int radix = 16;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final String string = Integer.toString(i, radix);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder append2 = append.append(string);
                        BytecodeManager.incBytecodes(1);
                        final String string2 = append2.toString();
                        BytecodeManager.incBytecodes(1);
                        final IllegalArgumentException ex = new IllegalArgumentException(string2);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    if (n <= 0) {
                        final Encoder rfc4648 = Encoder.RFC4648;
                        BytecodeManager.incBytecodes(2);
                        return rfc4648;
                    }
                    final boolean b2 = false;
                    final int n7 = n >> 2 << 2;
                    final boolean b3 = true;
                    final Object object = null;
                    BytecodeManager.incBytecodes(12);
                    final Encoder encoder = new Encoder(b2, array, n7, b3);
                    BytecodeManager.incBytecodes(1);
                    return encoder;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Decoder getDecoder() {
        try {
            final Decoder rfc4648 = Decoder.RFC4648;
            BytecodeManager.incBytecodes(2);
            return rfc4648;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Decoder getUrlDecoder() {
        try {
            final Decoder rfc4648_URLSAFE = Decoder.RFC4648_URLSAFE;
            BytecodeManager.incBytecodes(2);
            return rfc4648_URLSAFE;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Decoder getMimeDecoder() {
        try {
            final Decoder rfc2045 = Decoder.RFC2045;
            BytecodeManager.incBytecodes(2);
            return rfc2045;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static class Encoder
    {
        private final byte[] newline;
        private final int linemax;
        private final boolean isURL;
        private final boolean doPadding;
        private static final char[] toBase64;
        private static final char[] toBase64URL;
        private static final int MIMELINEMAX = 76;
        private static final byte[] CRLF;
        static final Encoder RFC4648;
        static final Encoder RFC4648_URLSAFE;
        static final Encoder RFC2045;
        
        private Encoder(final boolean isURL, final byte[] newline, final int linemax, final boolean doPadding) {
            try {
                BytecodeManager.incBytecodes(2);
                this.isURL = isURL;
                BytecodeManager.incBytecodes(3);
                this.newline = newline;
                BytecodeManager.incBytecodes(3);
                this.linemax = linemax;
                BytecodeManager.incBytecodes(3);
                this.doPadding = doPadding;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private final int outLength(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean doPadding = this.doPadding;
                BytecodeManager.incBytecodes(3);
                int n2;
                if (doPadding) {
                    n2 = 4 * ((n + 2) / 3);
                    BytecodeManager.incBytecodes(9);
                }
                else {
                    final int n3 = n % 3;
                    BytecodeManager.incBytecodes(4);
                    final int n4 = 4 * (n / 3);
                    final int n5 = n3;
                    BytecodeManager.incBytecodes(7);
                    int n6;
                    if (n5 == 0) {
                        n6 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n6 = n3 + 1;
                        BytecodeManager.incBytecodes(3);
                    }
                    n2 = n4 + n6;
                    BytecodeManager.incBytecodes(2);
                }
                final int linemax = this.linemax;
                BytecodeManager.incBytecodes(3);
                if (linemax > 0) {
                    n2 += (n2 - 1) / this.linemax * this.newline.length;
                    BytecodeManager.incBytecodes(13);
                }
                final int n7 = n2;
                BytecodeManager.incBytecodes(2);
                return n7;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public byte[] encode(final byte[] array) {
            try {
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                final int outLength = this.outLength(length);
                BytecodeManager.incBytecodes(1);
                final byte[] array2 = new byte[outLength];
                BytecodeManager.incBytecodes(2);
                final int n = 0;
                final int length2 = array.length;
                final byte[] array3 = array2;
                BytecodeManager.incBytecodes(7);
                final int encode0 = this.encode0(array, n, length2, array3);
                BytecodeManager.incBytecodes(1);
                final int n2 = encode0;
                final int length3 = array2.length;
                BytecodeManager.incBytecodes(4);
                if (n2 != length3) {
                    final byte[] array4 = array2;
                    final int n3 = encode0;
                    BytecodeManager.incBytecodes(3);
                    final byte[] copy = Arrays.copyOf(array4, n3);
                    BytecodeManager.incBytecodes(1);
                    return copy;
                }
                final byte[] array5 = array2;
                BytecodeManager.incBytecodes(2);
                return array5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public int encode(final byte[] array, final byte[] array2) {
            try {
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                final int outLength = this.outLength(length);
                BytecodeManager.incBytecodes(1);
                final int length2 = array2.length;
                final int n = outLength;
                BytecodeManager.incBytecodes(4);
                if (length2 < n) {
                    final String s = "Output byte array is too small for encoding all input bytes";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n2 = 0;
                final int length3 = array.length;
                BytecodeManager.incBytecodes(7);
                final int encode0 = this.encode0(array, n2, length3, array2);
                BytecodeManager.incBytecodes(1);
                return encode0;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public String encodeToString(final byte[] array) {
            try {
                BytecodeManager.incBytecodes(3);
                final byte[] encode = this.encode(array);
                BytecodeManager.incBytecodes(1);
                final byte[] ascii = encode;
                final int hibyte = 0;
                final int offset = 0;
                final int length = encode.length;
                BytecodeManager.incBytecodes(8);
                final String s = new String(ascii, hibyte, offset, length);
                BytecodeManager.incBytecodes(1);
                return s;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public ByteBuffer encode(final ByteBuffer byteBuffer) {
            try {
                BytecodeManager.incBytecodes(3);
                final int remaining = byteBuffer.remaining();
                BytecodeManager.incBytecodes(1);
                final int outLength = this.outLength(remaining);
                BytecodeManager.incBytecodes(1);
                byte[] copy = new byte[outLength];
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final boolean hasArray = byteBuffer.hasArray();
                BytecodeManager.incBytecodes(1);
                int n3;
                if (hasArray) {
                    BytecodeManager.incBytecodes(3);
                    final byte[] array = byteBuffer.array();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int arrayOffset = byteBuffer.arrayOffset();
                    BytecodeManager.incBytecodes(2);
                    final int n = arrayOffset + byteBuffer.position();
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final int arrayOffset2 = byteBuffer.arrayOffset();
                    BytecodeManager.incBytecodes(2);
                    final int n2 = arrayOffset2 + byteBuffer.limit();
                    final byte[] array2 = copy;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    n3 = this.encode0(array, n, n2, array2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(3);
                    final int limit = byteBuffer.limit();
                    BytecodeManager.incBytecodes(1);
                    byteBuffer.position(limit);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    final byte[] array3 = new byte[byteBuffer.remaining()];
                    BytecodeManager.incBytecodes(1);
                    final byte[] dst = array3;
                    BytecodeManager.incBytecodes(3);
                    byteBuffer.get(dst);
                    BytecodeManager.incBytecodes(1);
                    final byte[] array4 = array3;
                    final int n4 = 0;
                    final int length = array3.length;
                    final byte[] array5 = copy;
                    BytecodeManager.incBytecodes(7);
                    n3 = this.encode0(array4, n4, length, array5);
                    BytecodeManager.incBytecodes(1);
                }
                final int n5 = n3;
                final int length2 = copy.length;
                BytecodeManager.incBytecodes(4);
                if (n5 != length2) {
                    final byte[] array6 = copy;
                    final int n6 = n3;
                    BytecodeManager.incBytecodes(3);
                    copy = Arrays.copyOf(array6, n6);
                    BytecodeManager.incBytecodes(1);
                }
                final byte[] array7 = copy;
                BytecodeManager.incBytecodes(2);
                final ByteBuffer wrap = ByteBuffer.wrap(array7);
                BytecodeManager.incBytecodes(1);
                return wrap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public OutputStream wrap(final OutputStream outputStream) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(outputStream);
                BytecodeManager.incBytecodes(1);
                final boolean isURL = this.isURL;
                BytecodeManager.incBytecodes(6);
                char[] array;
                if (isURL) {
                    array = Encoder.toBase64URL;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    array = Encoder.toBase64;
                    BytecodeManager.incBytecodes(1);
                }
                final byte[] newline = this.newline;
                final int linemax = this.linemax;
                final boolean doPadding = this.doPadding;
                BytecodeManager.incBytecodes(7);
                final EncOutputStream encOutputStream = new EncOutputStream(outputStream, array, newline, linemax, doPadding);
                BytecodeManager.incBytecodes(1);
                return encOutputStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Encoder withoutPadding() {
            try {
                final boolean doPadding = this.doPadding;
                BytecodeManager.incBytecodes(3);
                if (!doPadding) {
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                final boolean isURL = this.isURL;
                final byte[] newline = this.newline;
                final int linemax = this.linemax;
                final boolean b = false;
                BytecodeManager.incBytecodes(10);
                final Encoder encoder = new Encoder(isURL, newline, linemax, b);
                BytecodeManager.incBytecodes(1);
                return encoder;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int encode0(final byte[] array, final int n, final int n2, final byte[] array2) {
            try {
                final boolean isURL = this.isURL;
                BytecodeManager.incBytecodes(3);
                char[] array3;
                if (isURL) {
                    array3 = Encoder.toBase64URL;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    array3 = Encoder.toBase64;
                    BytecodeManager.incBytecodes(1);
                }
                final char[] array4 = array3;
                BytecodeManager.incBytecodes(1);
                int n3 = n;
                BytecodeManager.incBytecodes(2);
                int n4 = (n2 - n) / 3 * 3;
                BytecodeManager.incBytecodes(8);
                final int n5 = n + n4;
                BytecodeManager.incBytecodes(4);
                final int linemax = this.linemax;
                BytecodeManager.incBytecodes(3);
                if (linemax > 0) {
                    final int n6 = n4;
                    final int n7 = this.linemax / 4 * 3;
                    BytecodeManager.incBytecodes(8);
                    if (n6 > n7) {
                        n4 = this.linemax / 4 * 3;
                        BytecodeManager.incBytecodes(7);
                    }
                }
                int n8 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n9 = n3;
                    final int n10 = n5;
                    BytecodeManager.incBytecodes(3);
                    if (n9 >= n10) {
                        break;
                    }
                    final int a = n3 + n4;
                    final int b = n5;
                    BytecodeManager.incBytecodes(5);
                    final int min = Math.min(a, b);
                    BytecodeManager.incBytecodes(1);
                    int n11 = n3;
                    int n12 = n8;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n13 = n11;
                        final int n14 = min;
                        BytecodeManager.incBytecodes(3);
                        if (n13 >= n14) {
                            break;
                        }
                        final int n15 = (array[n11++] & 0xFF) << 16 | (array[n11++] & 0xFF) << 8 | (array[n11++] & 0xFF);
                        BytecodeManager.incBytecodes(25);
                        array2[n12++] = (byte)array4[n15 >>> 18 & 0x3F];
                        BytecodeManager.incBytecodes(12);
                        array2[n12++] = (byte)array4[n15 >>> 12 & 0x3F];
                        BytecodeManager.incBytecodes(12);
                        array2[n12++] = (byte)array4[n15 >>> 6 & 0x3F];
                        BytecodeManager.incBytecodes(12);
                        array2[n12++] = (byte)array4[n15 & 0x3F];
                        BytecodeManager.incBytecodes(10);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n16 = (min - n3) / 3 * 4;
                    BytecodeManager.incBytecodes(8);
                    n8 += n16;
                    BytecodeManager.incBytecodes(4);
                    n3 = min;
                    BytecodeManager.incBytecodes(2);
                    final int n17 = n16;
                    final int linemax2 = this.linemax;
                    BytecodeManager.incBytecodes(4);
                    if (n17 == linemax2) {
                        final int n18 = n3;
                        BytecodeManager.incBytecodes(3);
                        if (n18 < n2) {
                            final byte[] newline = this.newline;
                            final int length = newline.length;
                            int n19 = 0;
                            BytecodeManager.incBytecodes(8);
                            while (true) {
                                final int n20 = n19;
                                final int n21 = length;
                                BytecodeManager.incBytecodes(3);
                                if (n20 >= n21) {
                                    break;
                                }
                                final byte b2 = newline[n19];
                                BytecodeManager.incBytecodes(4);
                                array2[n8++] = b2;
                                BytecodeManager.incBytecodes(5);
                                ++n19;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final int n22 = n3;
                BytecodeManager.incBytecodes(3);
                if (n22 < n2) {
                    final int n23 = array[n3++] & 0xFF;
                    BytecodeManager.incBytecodes(7);
                    array2[n8++] = (byte)array4[n23 >> 2];
                    BytecodeManager.incBytecodes(10);
                    final int n24 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n24 == n2) {
                        array2[n8++] = (byte)array4[n23 << 4 & 0x3F];
                        BytecodeManager.incBytecodes(12);
                        final boolean doPadding = this.doPadding;
                        BytecodeManager.incBytecodes(3);
                        if (doPadding) {
                            array2[n8++] = 61;
                            BytecodeManager.incBytecodes(5);
                            array2[n8++] = 61;
                            BytecodeManager.incBytecodes(6);
                        }
                    }
                    else {
                        final int n25 = array[n3++] & 0xFF;
                        BytecodeManager.incBytecodes(7);
                        array2[n8++] = (byte)array4[(n23 << 4 & 0x3F) | n25 >> 4];
                        BytecodeManager.incBytecodes(16);
                        array2[n8++] = (byte)array4[n25 << 2 & 0x3F];
                        BytecodeManager.incBytecodes(12);
                        final boolean doPadding2 = this.doPadding;
                        BytecodeManager.incBytecodes(3);
                        if (doPadding2) {
                            array2[n8++] = 61;
                            BytecodeManager.incBytecodes(5);
                        }
                    }
                }
                final int n26 = n8;
                BytecodeManager.incBytecodes(2);
                return n26;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ char[] access$200() {
            try {
                final char[] toBase64 = Encoder.toBase64;
                BytecodeManager.incBytecodes(2);
                return toBase64;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ char[] access$300() {
            try {
                final char[] toBase64URL = Encoder.toBase64URL;
                BytecodeManager.incBytecodes(2);
                return toBase64URL;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                toBase64 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
                BytecodeManager.incBytecodes(258);
                toBase64URL = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_' };
                BytecodeManager.incBytecodes(258);
                CRLF = new byte[] { 13, 10 };
                BytecodeManager.incBytecodes(10);
                final boolean b = false;
                final byte[] array = null;
                final int n = -1;
                final boolean b2 = true;
                BytecodeManager.incBytecodes(7);
                RFC4648 = new Encoder(b, array, n, b2);
                BytecodeManager.incBytecodes(1);
                final boolean b3 = true;
                final byte[] array2 = null;
                final int n2 = -1;
                final boolean b4 = true;
                BytecodeManager.incBytecodes(7);
                RFC4648_URLSAFE = new Encoder(b3, array2, n2, b4);
                BytecodeManager.incBytecodes(1);
                final boolean b5 = false;
                final byte[] crlf = Encoder.CRLF;
                final int n3 = 76;
                final boolean b6 = true;
                BytecodeManager.incBytecodes(7);
                RFC2045 = new Encoder(b5, crlf, n3, b6);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public static class Decoder
    {
        private final boolean isURL;
        private final boolean isMIME;
        private static final int[] fromBase64;
        private static final int[] fromBase64URL;
        static final Decoder RFC4648;
        static final Decoder RFC4648_URLSAFE;
        static final Decoder RFC2045;
        
        private Decoder(final boolean isURL, final boolean isMIME) {
            try {
                BytecodeManager.incBytecodes(2);
                this.isURL = isURL;
                BytecodeManager.incBytecodes(3);
                this.isMIME = isMIME;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public byte[] decode(final byte[] array) {
            try {
                final int n = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(6);
                byte[] copy = new byte[this.outLength(array, n, length)];
                BytecodeManager.incBytecodes(1);
                final int n2 = 0;
                final int length2 = array.length;
                final byte[] array2 = copy;
                BytecodeManager.incBytecodes(7);
                final int decode0 = this.decode0(array, n2, length2, array2);
                BytecodeManager.incBytecodes(1);
                final int n3 = decode0;
                final int length3 = copy.length;
                BytecodeManager.incBytecodes(4);
                if (n3 != length3) {
                    final byte[] array3 = copy;
                    final int n4 = decode0;
                    BytecodeManager.incBytecodes(3);
                    copy = Arrays.copyOf(array3, n4);
                    BytecodeManager.incBytecodes(1);
                }
                final byte[] array4 = copy;
                BytecodeManager.incBytecodes(2);
                return array4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public byte[] decode(final String s) {
            try {
                final Charset iso_8859_1 = StandardCharsets.ISO_8859_1;
                BytecodeManager.incBytecodes(4);
                final byte[] bytes = s.getBytes(iso_8859_1);
                BytecodeManager.incBytecodes(1);
                final byte[] decode = this.decode(bytes);
                BytecodeManager.incBytecodes(1);
                return decode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public int decode(final byte[] array, final byte[] array2) {
            try {
                final int n = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(6);
                final int outLength = this.outLength(array, n, length);
                BytecodeManager.incBytecodes(1);
                final int length2 = array2.length;
                final int n2 = outLength;
                BytecodeManager.incBytecodes(4);
                if (length2 < n2) {
                    final String s = "Output byte array is too small for decoding all input bytes";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n3 = 0;
                final int length3 = array.length;
                BytecodeManager.incBytecodes(7);
                final int decode0 = this.decode0(array, n3, length3, array2);
                BytecodeManager.incBytecodes(1);
                return decode0;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public ByteBuffer decode(final ByteBuffer p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokevirtual   java/nio/ByteBuffer.position:()I
            //     9: istore_2       
            //    10: ldc             1
            //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    15: aload_1        
            //    16: ldc             2
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokevirtual   java/nio/ByteBuffer.hasArray:()Z
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: ifeq            126
            //    32: aload_1        
            //    33: ldc             2
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: invokevirtual   java/nio/ByteBuffer.array:()[B
            //    41: astore_3       
            //    42: ldc             1
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: aload_1        
            //    48: ldc             2
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   java/nio/ByteBuffer.arrayOffset:()I
            //    56: aload_1        
            //    57: ldc             2
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: invokevirtual   java/nio/ByteBuffer.position:()I
            //    65: iadd           
            //    66: istore          4
            //    68: ldc             2
            //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    73: aload_1        
            //    74: ldc             2
            //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    79: invokevirtual   java/nio/ByteBuffer.arrayOffset:()I
            //    82: aload_1        
            //    83: ldc             2
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: invokevirtual   java/nio/ByteBuffer.limit:()I
            //    91: iadd           
            //    92: istore          5
            //    94: ldc             2
            //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    99: aload_1        
            //   100: aload_1        
            //   101: ldc             3
            //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   106: invokevirtual   java/nio/ByteBuffer.limit:()I
            //   109: ldc             1
            //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   114: invokevirtual   java/nio/ByteBuffer.position:(I)Ljava/nio/Buffer;
            //   117: pop            
            //   118: ldc             2
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: goto            176
            //   126: aload_1        
            //   127: ldc             2
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: invokevirtual   java/nio/ByteBuffer.remaining:()I
            //   135: newarray        B
            //   137: astore_3       
            //   138: ldc             1
            //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   143: aload_1        
            //   144: aload_3        
            //   145: ldc             3
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: invokevirtual   java/nio/ByteBuffer.get:([B)Ljava/nio/ByteBuffer;
            //   153: pop            
            //   154: ldc             1
            //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   159: iconst_0       
            //   160: istore          4
            //   162: ldc             2
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: aload_3        
            //   168: arraylength    
            //   169: istore          5
            //   171: ldc             3
            //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   176: aload_0        
            //   177: aload_3        
            //   178: iload           4
            //   180: iload           5
            //   182: ldc             5
            //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   187: invokespecial   instrumented/java/util/Base64$Decoder.outLength:([BII)I
            //   190: newarray        B
            //   192: astore          6
            //   194: ldc             1
            //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   199: aload           6
            //   201: iconst_0       
            //   202: aload_0        
            //   203: aload_3        
            //   204: iload           4
            //   206: iload           5
            //   208: aload           6
            //   210: ldc             8
            //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   215: invokespecial   instrumented/java/util/Base64$Decoder.decode0:([BII[B)I
            //   218: ldc             1
            //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   223: invokestatic    java/nio/ByteBuffer.wrap:([BII)Ljava/nio/ByteBuffer;
            //   226: ldc             1
            //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   231: areturn        
            //   232: astore_3       
            //   233: ldc             501
            //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   238: aload_1        
            //   239: iload_2        
            //   240: ldc             3
            //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   245: invokevirtual   java/nio/ByteBuffer.position:(I)Ljava/nio/Buffer;
            //   248: pop            
            //   249: ldc             1
            //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   254: aload_3        
            //   255: ldc             2
            //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   260: athrow         
            //   261: athrow         
            //   262: athrow         
            //    StackMapTable: 00 05 FC 00 7E 01 FE 00 31 07 00 41 01 01 FF 00 37 00 03 07 00 02 07 00 5D 01 00 01 07 00 53 FF 00 1C 00 00 00 01 07 00 2C FF 00 00 00 00 00 01 07 00 5B
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                
            //  -----  -----  -----  -----  ------------------------------------
            //  15     262    262    263    Ljava/lang/VirtualMachineError;
            //  15     226    232    261    Ljava/lang/IllegalArgumentException;
            //  0      261    261    262    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0126:
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
        
        public InputStream wrap(final InputStream inputStream) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(inputStream);
                BytecodeManager.incBytecodes(1);
                final boolean isURL = this.isURL;
                BytecodeManager.incBytecodes(6);
                int[] array;
                if (isURL) {
                    array = Decoder.fromBase64URL;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    array = Decoder.fromBase64;
                    BytecodeManager.incBytecodes(1);
                }
                final boolean isMIME = this.isMIME;
                BytecodeManager.incBytecodes(3);
                final DecInputStream decInputStream = new DecInputStream(inputStream, array, isMIME);
                BytecodeManager.incBytecodes(1);
                return decInputStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int outLength(final byte[] array, int n, final int n2) {
            try {
                final boolean isURL = this.isURL;
                BytecodeManager.incBytecodes(3);
                int[] array2;
                if (isURL) {
                    array2 = Decoder.fromBase64URL;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    array2 = Decoder.fromBase64;
                    BytecodeManager.incBytecodes(1);
                }
                final int[] array3 = array2;
                BytecodeManager.incBytecodes(1);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                int n4 = n2 - n;
                BytecodeManager.incBytecodes(4);
                final int n5 = n4;
                BytecodeManager.incBytecodes(2);
                if (n5 == 0) {
                    final int n6 = 0;
                    BytecodeManager.incBytecodes(2);
                    return n6;
                }
                final int n7 = n4;
                final int n8 = 2;
                BytecodeManager.incBytecodes(3);
                if (n7 < n8) {
                    final boolean isMIME = this.isMIME;
                    BytecodeManager.incBytecodes(3);
                    if (isMIME) {
                        final int n9 = array3[0];
                        final int n10 = -1;
                        BytecodeManager.incBytecodes(5);
                        if (n9 == n10) {
                            final int n11 = 0;
                            BytecodeManager.incBytecodes(2);
                            return n11;
                        }
                    }
                    final String s = "Input byte[] should at least have 2 bytes for base64 bytes";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final boolean isMIME2 = this.isMIME;
                BytecodeManager.incBytecodes(3);
                if (isMIME2) {
                    int n12 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n13 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n13 >= n2) {
                            break;
                        }
                        final int n14 = array[n++] & 0xFF;
                        BytecodeManager.incBytecodes(7);
                        final int n15 = n14;
                        final int n16 = 61;
                        BytecodeManager.incBytecodes(3);
                        if (n15 == n16) {
                            n4 -= n2 - n + 1;
                            BytecodeManager.incBytecodes(8);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final int n17 = array3[n14];
                        final int n18 = -1;
                        BytecodeManager.incBytecodes(7);
                        if (n17 == n18) {
                            ++n12;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    n4 -= n12;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final byte b = array[n2 - 1];
                    final int n19 = 61;
                    BytecodeManager.incBytecodes(7);
                    if (b == n19) {
                        ++n3;
                        BytecodeManager.incBytecodes(1);
                        final byte b2 = array[n2 - 2];
                        final int n20 = 61;
                        BytecodeManager.incBytecodes(7);
                        if (b2 == n20) {
                            ++n3;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final int n21 = n3;
                BytecodeManager.incBytecodes(2);
                if (n21 == 0) {
                    final int n22 = n4 & 0x3;
                    BytecodeManager.incBytecodes(4);
                    if (n22 != 0) {
                        n3 = 4 - (n4 & 0x3);
                        BytecodeManager.incBytecodes(6);
                    }
                }
                final int n23 = 3 * ((n4 + 3) / 4) - n3;
                BytecodeManager.incBytecodes(10);
                return n23;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int decode0(final byte[] array, int n, final int n2, final byte[] array2) {
            try {
                final boolean isURL = this.isURL;
                BytecodeManager.incBytecodes(3);
                int[] array3;
                if (isURL) {
                    array3 = Decoder.fromBase64URL;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    array3 = Decoder.fromBase64;
                    BytecodeManager.incBytecodes(1);
                }
                final int[] array4 = array3;
                BytecodeManager.incBytecodes(1);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                int n5 = 18;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = n;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n2) {
                        break;
                    }
                    final int n7 = array[n++] & 0xFF;
                    BytecodeManager.incBytecodes(7);
                    final int n9;
                    final int n8 = n9 = array4[n7];
                    BytecodeManager.incBytecodes(6);
                    if (n8 < 0) {
                        final int n10 = n9;
                        final int n11 = -2;
                        BytecodeManager.incBytecodes(3);
                        if (n10 == n11) {
                            final int n12 = n5;
                            final int n13 = 6;
                            BytecodeManager.incBytecodes(3);
                            Label_0168: {
                                if (n12 == n13) {
                                    final int n14 = n;
                                    BytecodeManager.incBytecodes(3);
                                    if (n14 == n2) {
                                        break Label_0168;
                                    }
                                    final byte b = array[n++];
                                    final int n15 = 61;
                                    BytecodeManager.incBytecodes(6);
                                    if (b != n15) {
                                        break Label_0168;
                                    }
                                }
                                final int n16 = n5;
                                final int n17 = 18;
                                BytecodeManager.incBytecodes(3);
                                if (n16 != n17) {
                                    break;
                                }
                            }
                            final String s = "Input byte array has wrong 4-byte ending unit";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex = new IllegalArgumentException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        final boolean isMIME = this.isMIME;
                        BytecodeManager.incBytecodes(3);
                        if (!isMIME) {
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb = new StringBuilder();
                            final String str = "Illegal base64 character ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb.append(str);
                            final byte i = array[n - 1];
                            final int radix = 16;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final String string = Integer.toString(i, radix);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append2 = append.append(string);
                            BytecodeManager.incBytecodes(1);
                            final String string2 = append2.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        n4 |= n9 << n5;
                        BytecodeManager.incBytecodes(6);
                        n5 -= 6;
                        BytecodeManager.incBytecodes(1);
                        final int n18 = n5;
                        BytecodeManager.incBytecodes(2);
                        if (n18 < 0) {
                            array2[n3++] = (byte)(n4 >> 16);
                            BytecodeManager.incBytecodes(8);
                            array2[n3++] = (byte)(n4 >> 8);
                            BytecodeManager.incBytecodes(8);
                            array2[n3++] = (byte)n4;
                            BytecodeManager.incBytecodes(6);
                            n5 = 18;
                            BytecodeManager.incBytecodes(2);
                            n4 = 0;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n19 = n5;
                final int n20 = 6;
                BytecodeManager.incBytecodes(3);
                if (n19 == n20) {
                    array2[n3++] = (byte)(n4 >> 16);
                    BytecodeManager.incBytecodes(9);
                }
                else {
                    final int n21 = n5;
                    BytecodeManager.incBytecodes(2);
                    if (n21 == 0) {
                        array2[n3++] = (byte)(n4 >> 16);
                        BytecodeManager.incBytecodes(8);
                        array2[n3++] = (byte)(n4 >> 8);
                        BytecodeManager.incBytecodes(9);
                    }
                    else {
                        final int n22 = n5;
                        final int n23 = 12;
                        BytecodeManager.incBytecodes(3);
                        if (n22 == n23) {
                            final String s2 = "Last unit does not have enough valid bits";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex3 = new IllegalArgumentException(s2);
                            BytecodeManager.incBytecodes(1);
                            throw ex3;
                        }
                    }
                }
                Label_0617: {
                    while (true) {
                        final int n24 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n24 >= n2) {
                            break Label_0617;
                        }
                        final boolean isMIME2 = this.isMIME;
                        BytecodeManager.incBytecodes(3);
                        if (!isMIME2) {
                            break;
                        }
                        final int n25 = array4[array[n++]];
                        BytecodeManager.incBytecodes(7);
                        if (n25 >= 0) {
                            break;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb2 = new StringBuilder();
                    final String str2 = "Input byte array has incorrect ending byte at ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = sb2.append(str2);
                    final int j = n;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = append3.append(j);
                    BytecodeManager.incBytecodes(1);
                    final String string3 = append4.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex4 = new IllegalArgumentException(string3);
                    BytecodeManager.incBytecodes(1);
                    throw ex4;
                }
                final int n26 = n3;
                BytecodeManager.incBytecodes(2);
                return n26;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ int[] access$000() {
            try {
                final int[] fromBase64 = Decoder.fromBase64;
                BytecodeManager.incBytecodes(2);
                return fromBase64;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                fromBase64 = new int[256];
                BytecodeManager.incBytecodes(2);
                final int[] fromBase65 = Decoder.fromBase64;
                final int n = -1;
                BytecodeManager.incBytecodes(3);
                Arrays.fill(fromBase65, n);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    final int length = Encoder.access$200().length;
                    BytecodeManager.incBytecodes(2);
                    if (n3 >= length) {
                        break;
                    }
                    final int[] fromBase66 = Decoder.fromBase64;
                    BytecodeManager.incBytecodes(2);
                    fromBase66[Encoder.access$200()[n2]] = n2;
                    BytecodeManager.incBytecodes(4);
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                Decoder.fromBase64[61] = -2;
                BytecodeManager.incBytecodes(4);
                fromBase64URL = new int[256];
                BytecodeManager.incBytecodes(2);
                final int[] fromBase64URL2 = Decoder.fromBase64URL;
                final int n4 = -1;
                BytecodeManager.incBytecodes(3);
                Arrays.fill(fromBase64URL2, n4);
                int n5 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = n5;
                    BytecodeManager.incBytecodes(2);
                    final int length2 = Encoder.access$300().length;
                    BytecodeManager.incBytecodes(2);
                    if (n6 >= length2) {
                        break;
                    }
                    final int[] fromBase64URL3 = Decoder.fromBase64URL;
                    BytecodeManager.incBytecodes(2);
                    fromBase64URL3[Encoder.access$300()[n5]] = n5;
                    BytecodeManager.incBytecodes(4);
                    ++n5;
                    BytecodeManager.incBytecodes(2);
                }
                Decoder.fromBase64URL[61] = -2;
                BytecodeManager.incBytecodes(4);
                final boolean b = false;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(5);
                RFC4648 = new Decoder(b, b2);
                BytecodeManager.incBytecodes(1);
                final boolean b3 = true;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(5);
                RFC4648_URLSAFE = new Decoder(b3, b4);
                BytecodeManager.incBytecodes(1);
                final boolean b5 = false;
                final boolean b6 = true;
                BytecodeManager.incBytecodes(5);
                RFC2045 = new Decoder(b5, b6);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EncOutputStream extends FilterOutputStream
    {
        private int leftover;
        private int b0;
        private int b1;
        private int b2;
        private boolean closed;
        private final char[] base64;
        private final byte[] newline;
        private final int linemax;
        private final boolean doPadding;
        private int linepos;
        
        EncOutputStream(final OutputStream out, final char[] base64, final byte[] newline, final int linemax, final boolean doPadding) {
            try {
                BytecodeManager.incBytecodes(3);
                super(out);
                this.leftover = 0;
                BytecodeManager.incBytecodes(3);
                this.closed = false;
                BytecodeManager.incBytecodes(3);
                this.linepos = 0;
                BytecodeManager.incBytecodes(3);
                this.base64 = base64;
                BytecodeManager.incBytecodes(3);
                this.newline = newline;
                BytecodeManager.incBytecodes(3);
                this.linemax = linemax;
                BytecodeManager.incBytecodes(3);
                this.doPadding = doPadding;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void write(final int n) throws IOException {
            try {
                final byte[] array = { 0 };
                BytecodeManager.incBytecodes(2);
                array[0] = (byte)(n & 0xFF);
                BytecodeManager.incBytecodes(7);
                final byte[] array2 = array;
                final int n2 = 0;
                final int n3 = 1;
                BytecodeManager.incBytecodes(5);
                this.write(array2, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkNewline() throws IOException {
            try {
                final int linepos = this.linepos;
                final int linemax = this.linemax;
                BytecodeManager.incBytecodes(5);
                if (linepos == linemax) {
                    final OutputStream out = this.out;
                    final byte[] newline = this.newline;
                    BytecodeManager.incBytecodes(5);
                    out.write(newline);
                    this.linepos = 0;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void write(final byte[] array, int n, int n2) throws IOException {
            try {
                final boolean closed = this.closed;
                BytecodeManager.incBytecodes(3);
                if (closed) {
                    final String message = "Stream is closed";
                    BytecodeManager.incBytecodes(4);
                    final IOException ex = new IOException(message);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n3 = n;
                BytecodeManager.incBytecodes(2);
                if (n3 >= 0) {
                    final int n4 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n4 >= 0) {
                        final int n5 = n + n2;
                        final int length = array.length;
                        BytecodeManager.incBytecodes(6);
                        if (n5 <= length) {
                            final boolean b = n2 != 0;
                            BytecodeManager.incBytecodes(2);
                            if (!b) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final int leftover = this.leftover;
                            BytecodeManager.incBytecodes(3);
                            if (leftover != 0) {
                                final int leftover2 = this.leftover;
                                final int n6 = 1;
                                BytecodeManager.incBytecodes(4);
                                if (leftover2 == n6) {
                                    this.b1 = (array[n++] & 0xFF);
                                    BytecodeManager.incBytecodes(8);
                                    --n2;
                                    BytecodeManager.incBytecodes(1);
                                    final boolean b2 = n2 != 0;
                                    BytecodeManager.incBytecodes(2);
                                    if (!b2) {
                                        ++this.leftover;
                                        BytecodeManager.incBytecodes(6);
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                                this.b2 = (array[n++] & 0xFF);
                                BytecodeManager.incBytecodes(8);
                                --n2;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(2);
                                this.checkNewline();
                                final OutputStream out = this.out;
                                final char c = this.base64[this.b0 >> 2];
                                BytecodeManager.incBytecodes(10);
                                out.write(c);
                                final OutputStream out2 = this.out;
                                final char c2 = this.base64[(this.b0 << 4 & 0x3F) | this.b1 >> 4];
                                BytecodeManager.incBytecodes(17);
                                out2.write(c2);
                                final OutputStream out3 = this.out;
                                final char c3 = this.base64[(this.b1 << 2 & 0x3F) | this.b2 >> 6];
                                BytecodeManager.incBytecodes(17);
                                out3.write(c3);
                                final OutputStream out4 = this.out;
                                final char c4 = this.base64[this.b2 & 0x3F];
                                BytecodeManager.incBytecodes(10);
                                out4.write(c4);
                                this.linepos += 4;
                                BytecodeManager.incBytecodes(6);
                            }
                            int n7 = n2 / 3;
                            BytecodeManager.incBytecodes(4);
                            this.leftover = n2 - n7 * 3;
                            BytecodeManager.incBytecodes(7);
                            while (true) {
                                final int n8 = n7--;
                                BytecodeManager.incBytecodes(3);
                                if (n8 <= 0) {
                                    break;
                                }
                                BytecodeManager.incBytecodes(2);
                                this.checkNewline();
                                final int n9 = (array[n++] & 0xFF) << 16 | (array[n++] & 0xFF) << 8 | (array[n++] & 0xFF);
                                BytecodeManager.incBytecodes(25);
                                final OutputStream out5 = this.out;
                                final char c5 = this.base64[n9 >>> 18 & 0x3F];
                                BytecodeManager.incBytecodes(11);
                                out5.write(c5);
                                final OutputStream out6 = this.out;
                                final char c6 = this.base64[n9 >>> 12 & 0x3F];
                                BytecodeManager.incBytecodes(11);
                                out6.write(c6);
                                final OutputStream out7 = this.out;
                                final char c7 = this.base64[n9 >>> 6 & 0x3F];
                                BytecodeManager.incBytecodes(11);
                                out7.write(c7);
                                final OutputStream out8 = this.out;
                                final char c8 = this.base64[n9 & 0x3F];
                                BytecodeManager.incBytecodes(9);
                                out8.write(c8);
                                this.linepos += 4;
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                            }
                            final int leftover3 = this.leftover;
                            final int n10 = 1;
                            BytecodeManager.incBytecodes(4);
                            if (leftover3 == n10) {
                                this.b0 = (array[n++] & 0xFF);
                                BytecodeManager.incBytecodes(9);
                            }
                            else {
                                final int leftover4 = this.leftover;
                                final int n11 = 2;
                                BytecodeManager.incBytecodes(4);
                                if (leftover4 == n11) {
                                    this.b0 = (array[n++] & 0xFF);
                                    BytecodeManager.incBytecodes(8);
                                    this.b1 = (array[n++] & 0xFF);
                                    BytecodeManager.incBytecodes(8);
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                }
                BytecodeManager.incBytecodes(3);
                final ArrayIndexOutOfBoundsException ex2 = new ArrayIndexOutOfBoundsException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void close() throws IOException {
            try {
                final boolean closed = this.closed;
                BytecodeManager.incBytecodes(3);
                if (!closed) {
                    this.closed = true;
                    BytecodeManager.incBytecodes(3);
                    final int leftover = this.leftover;
                    final int n = 1;
                    BytecodeManager.incBytecodes(4);
                    if (leftover == n) {
                        BytecodeManager.incBytecodes(2);
                        this.checkNewline();
                        final OutputStream out = this.out;
                        final char c = this.base64[this.b0 >> 2];
                        BytecodeManager.incBytecodes(10);
                        out.write(c);
                        final OutputStream out2 = this.out;
                        final char c2 = this.base64[this.b0 << 4 & 0x3F];
                        BytecodeManager.incBytecodes(12);
                        out2.write(c2);
                        final boolean doPadding = this.doPadding;
                        BytecodeManager.incBytecodes(3);
                        if (doPadding) {
                            final OutputStream out3 = this.out;
                            final int n2 = 61;
                            BytecodeManager.incBytecodes(4);
                            out3.write(n2);
                            final OutputStream out4 = this.out;
                            final int n3 = 61;
                            BytecodeManager.incBytecodes(4);
                            out4.write(n3);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final int leftover2 = this.leftover;
                        final int n4 = 2;
                        BytecodeManager.incBytecodes(4);
                        if (leftover2 == n4) {
                            BytecodeManager.incBytecodes(2);
                            this.checkNewline();
                            final OutputStream out5 = this.out;
                            final char c3 = this.base64[this.b0 >> 2];
                            BytecodeManager.incBytecodes(10);
                            out5.write(c3);
                            final OutputStream out6 = this.out;
                            final char c4 = this.base64[(this.b0 << 4 & 0x3F) | this.b1 >> 4];
                            BytecodeManager.incBytecodes(17);
                            out6.write(c4);
                            final OutputStream out7 = this.out;
                            final char c5 = this.base64[this.b1 << 2 & 0x3F];
                            BytecodeManager.incBytecodes(12);
                            out7.write(c5);
                            final boolean doPadding2 = this.doPadding;
                            BytecodeManager.incBytecodes(3);
                            if (doPadding2) {
                                final OutputStream out8 = this.out;
                                final int n5 = 61;
                                BytecodeManager.incBytecodes(4);
                                out8.write(n5);
                            }
                        }
                    }
                    this.leftover = 0;
                    BytecodeManager.incBytecodes(3);
                    final OutputStream out9 = this.out;
                    BytecodeManager.incBytecodes(3);
                    out9.close();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class DecInputStream extends InputStream
    {
        private final InputStream is;
        private final boolean isMIME;
        private final int[] base64;
        private int bits;
        private int nextin;
        private int nextout;
        private boolean eof;
        private boolean closed;
        private byte[] sbBuf;
        
        DecInputStream(final InputStream is, final int[] base64, final boolean isMIME) {
            try {
                BytecodeManager.incBytecodes(2);
                this.bits = 0;
                BytecodeManager.incBytecodes(3);
                this.nextin = 18;
                BytecodeManager.incBytecodes(3);
                this.nextout = -8;
                BytecodeManager.incBytecodes(3);
                this.eof = false;
                BytecodeManager.incBytecodes(3);
                this.closed = false;
                BytecodeManager.incBytecodes(3);
                this.sbBuf = new byte[1];
                BytecodeManager.incBytecodes(3);
                this.is = is;
                BytecodeManager.incBytecodes(3);
                this.base64 = base64;
                BytecodeManager.incBytecodes(3);
                this.isMIME = isMIME;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int read() throws IOException {
            try {
                final byte[] sbBuf = this.sbBuf;
                final int n = 0;
                final int n2 = 1;
                BytecodeManager.incBytecodes(6);
                final int read = this.read(sbBuf, n, n2);
                final int n3 = -1;
                BytecodeManager.incBytecodes(2);
                int n4;
                if (read == n3) {
                    n4 = -1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n4 = (this.sbBuf[0] & 0xFF);
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return n4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int read(final byte[] array, int n, int n2) throws IOException {
            try {
                final boolean closed = this.closed;
                BytecodeManager.incBytecodes(3);
                if (closed) {
                    final String message = "Stream is closed";
                    BytecodeManager.incBytecodes(4);
                    final IOException ex = new IOException(message);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final boolean eof = this.eof;
                BytecodeManager.incBytecodes(3);
                if (eof) {
                    final int nextout = this.nextout;
                    BytecodeManager.incBytecodes(3);
                    if (nextout < 0) {
                        final int n3 = -1;
                        BytecodeManager.incBytecodes(2);
                        return n3;
                    }
                }
                final int n4 = n;
                BytecodeManager.incBytecodes(2);
                if (n4 >= 0) {
                    final int n5 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n5 >= 0) {
                        final int n6 = n2;
                        final int n7 = array.length - n;
                        BytecodeManager.incBytecodes(6);
                        if (n6 <= n7) {
                            final int n8 = n;
                            BytecodeManager.incBytecodes(2);
                            final int nextout2 = this.nextout;
                            BytecodeManager.incBytecodes(3);
                            if (nextout2 >= 0) {
                                int i;
                                do {
                                    final boolean b = n2 != 0;
                                    BytecodeManager.incBytecodes(2);
                                    if (!b) {
                                        final int n9 = n - n8;
                                        BytecodeManager.incBytecodes(4);
                                        return n9;
                                    }
                                    array[n++] = (byte)(this.bits >> this.nextout);
                                    BytecodeManager.incBytecodes(10);
                                    --n2;
                                    BytecodeManager.incBytecodes(1);
                                    this.nextout -= 8;
                                    BytecodeManager.incBytecodes(6);
                                    i = this.nextout;
                                    BytecodeManager.incBytecodes(3);
                                } while (i >= 0);
                                this.bits = 0;
                                BytecodeManager.incBytecodes(3);
                            }
                            while (true) {
                                final int n10 = n2;
                                BytecodeManager.incBytecodes(2);
                                if (n10 <= 0) {
                                    break;
                                }
                                final InputStream is = this.is;
                                BytecodeManager.incBytecodes(3);
                                final int read = is.read();
                                BytecodeManager.incBytecodes(1);
                                final int n11 = read;
                                final int n12 = -1;
                                BytecodeManager.incBytecodes(3);
                                if (n11 == n12) {
                                    this.eof = true;
                                    BytecodeManager.incBytecodes(3);
                                    final int nextin = this.nextin;
                                    final int n13 = 18;
                                    BytecodeManager.incBytecodes(4);
                                    if (nextin != n13) {
                                        final int nextin2 = this.nextin;
                                        final int n14 = 12;
                                        BytecodeManager.incBytecodes(4);
                                        if (nextin2 == n14) {
                                            final String message2 = "Base64 stream has one un-decoded dangling byte.";
                                            BytecodeManager.incBytecodes(4);
                                            final IOException ex2 = new IOException(message2);
                                            BytecodeManager.incBytecodes(1);
                                            throw ex2;
                                        }
                                        array[n++] = (byte)(this.bits >> 16);
                                        BytecodeManager.incBytecodes(9);
                                        --n2;
                                        BytecodeManager.incBytecodes(1);
                                        final int nextin3 = this.nextin;
                                        BytecodeManager.incBytecodes(3);
                                        if (nextin3 == 0) {
                                            final boolean b2 = n2 != 0;
                                            BytecodeManager.incBytecodes(2);
                                            if (!b2) {
                                                this.bits >>= 8;
                                                BytecodeManager.incBytecodes(6);
                                                this.nextout = 0;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                array[n++] = (byte)(this.bits >> 8);
                                                BytecodeManager.incBytecodes(9);
                                            }
                                        }
                                    }
                                    final int n15 = n;
                                    final int n16 = n8;
                                    BytecodeManager.incBytecodes(3);
                                    if (n15 == n16) {
                                        final int n17 = -1;
                                        BytecodeManager.incBytecodes(2);
                                        return n17;
                                    }
                                    final int n18 = n - n8;
                                    BytecodeManager.incBytecodes(4);
                                    return n18;
                                }
                                else {
                                    final int n19 = read;
                                    final int n20 = 61;
                                    BytecodeManager.incBytecodes(3);
                                    if (n19 == n20) {
                                        final int nextin4 = this.nextin;
                                        final int n21 = 18;
                                        BytecodeManager.incBytecodes(4);
                                        Label_0520: {
                                            if (nextin4 != n21) {
                                                final int nextin5 = this.nextin;
                                                final int n22 = 12;
                                                BytecodeManager.incBytecodes(4);
                                                if (nextin5 != n22) {
                                                    final int nextin6 = this.nextin;
                                                    final int n23 = 6;
                                                    BytecodeManager.incBytecodes(4);
                                                    if (nextin6 == n23) {
                                                        final InputStream is2 = this.is;
                                                        BytecodeManager.incBytecodes(2);
                                                        BytecodeManager.incBytecodes(1);
                                                        final int read2 = is2.read();
                                                        final int n24 = 61;
                                                        BytecodeManager.incBytecodes(2);
                                                        if (read2 != n24) {
                                                            break Label_0520;
                                                        }
                                                    }
                                                    array[n++] = (byte)(this.bits >> 16);
                                                    BytecodeManager.incBytecodes(9);
                                                    --n2;
                                                    BytecodeManager.incBytecodes(1);
                                                    final int nextin7 = this.nextin;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (nextin7 == 0) {
                                                        final boolean b3 = n2 != 0;
                                                        BytecodeManager.incBytecodes(2);
                                                        if (!b3) {
                                                            this.bits >>= 8;
                                                            BytecodeManager.incBytecodes(6);
                                                            this.nextout = 0;
                                                            BytecodeManager.incBytecodes(4);
                                                        }
                                                        else {
                                                            array[n++] = (byte)(this.bits >> 8);
                                                            BytecodeManager.incBytecodes(9);
                                                        }
                                                    }
                                                    this.eof = true;
                                                    BytecodeManager.incBytecodes(3);
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                            }
                                        }
                                        BytecodeManager.incBytecodes(5);
                                        final StringBuilder sb = new StringBuilder();
                                        final String str = "Illegal base64 ending sequence:";
                                        BytecodeManager.incBytecodes(2);
                                        final StringBuilder append = sb.append(str);
                                        final int nextin8 = this.nextin;
                                        BytecodeManager.incBytecodes(3);
                                        final StringBuilder append2 = append.append(nextin8);
                                        BytecodeManager.incBytecodes(1);
                                        final String string = append2.toString();
                                        BytecodeManager.incBytecodes(1);
                                        final IOException ex3 = new IOException(string);
                                        BytecodeManager.incBytecodes(1);
                                        throw ex3;
                                    }
                                    final int n26;
                                    final int n25 = n26 = this.base64[read];
                                    final int n27 = -1;
                                    BytecodeManager.incBytecodes(8);
                                    if (n25 == n27) {
                                        final boolean isMIME = this.isMIME;
                                        BytecodeManager.incBytecodes(3);
                                        if (!isMIME) {
                                            BytecodeManager.incBytecodes(5);
                                            final StringBuilder sb2 = new StringBuilder();
                                            final String str2 = "Illegal base64 character ";
                                            BytecodeManager.incBytecodes(2);
                                            final StringBuilder append3 = sb2.append(str2);
                                            final int j = n26;
                                            final int radix = 16;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            final String string2 = Integer.toString(j, radix);
                                            BytecodeManager.incBytecodes(1);
                                            final StringBuilder append4 = append3.append(string2);
                                            BytecodeManager.incBytecodes(1);
                                            final String string3 = append4.toString();
                                            BytecodeManager.incBytecodes(1);
                                            final IOException ex4 = new IOException(string3);
                                            BytecodeManager.incBytecodes(1);
                                            throw ex4;
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        this.bits |= n26 << this.nextin;
                                        BytecodeManager.incBytecodes(9);
                                        final int nextin9 = this.nextin;
                                        BytecodeManager.incBytecodes(3);
                                        if (nextin9 == 0) {
                                            this.nextin = 18;
                                            BytecodeManager.incBytecodes(3);
                                            this.nextout = 16;
                                            BytecodeManager.incBytecodes(3);
                                            while (true) {
                                                final int nextout3 = this.nextout;
                                                BytecodeManager.incBytecodes(3);
                                                if (nextout3 < 0) {
                                                    this.bits = 0;
                                                    BytecodeManager.incBytecodes(4);
                                                    break;
                                                }
                                                array[n++] = (byte)(this.bits >> this.nextout);
                                                BytecodeManager.incBytecodes(10);
                                                --n2;
                                                BytecodeManager.incBytecodes(1);
                                                this.nextout -= 8;
                                                BytecodeManager.incBytecodes(6);
                                                final boolean b4 = n2 != 0;
                                                BytecodeManager.incBytecodes(2);
                                                if (b4) {
                                                    continue;
                                                }
                                                final int nextout4 = this.nextout;
                                                BytecodeManager.incBytecodes(3);
                                                if (nextout4 >= 0) {
                                                    final int n28 = n - n8;
                                                    BytecodeManager.incBytecodes(4);
                                                    return n28;
                                                }
                                            }
                                        }
                                        else {
                                            this.nextin -= 6;
                                            BytecodeManager.incBytecodes(6);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            final int n29 = n - n8;
                            BytecodeManager.incBytecodes(4);
                            return n29;
                        }
                    }
                }
                BytecodeManager.incBytecodes(3);
                final IndexOutOfBoundsException ex5 = new IndexOutOfBoundsException();
                BytecodeManager.incBytecodes(1);
                throw ex5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int available() throws IOException {
            try {
                final boolean closed = this.closed;
                BytecodeManager.incBytecodes(3);
                if (closed) {
                    final String message = "Stream is closed";
                    BytecodeManager.incBytecodes(4);
                    final IOException ex = new IOException(message);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final InputStream is = this.is;
                BytecodeManager.incBytecodes(3);
                final int available = is.available();
                BytecodeManager.incBytecodes(1);
                return available;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void close() throws IOException {
            try {
                final boolean closed = this.closed;
                BytecodeManager.incBytecodes(3);
                if (!closed) {
                    this.closed = true;
                    BytecodeManager.incBytecodes(3);
                    final InputStream is = this.is;
                    BytecodeManager.incBytecodes(3);
                    is.close();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
