// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public final class UUID implements Serializable, Comparable<UUID>
{
    private static final long serialVersionUID = -4856846361193249489L;
    private final long mostSigBits;
    private final long leastSigBits;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private UUID(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            long mostSigBits = 0L;
            BytecodeManager.incBytecodes(2);
            long leastSigBits = 0L;
            BytecodeManager.incBytecodes(2);
            final boolean $assertionsDisabled = UUID.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int length = array.length;
                final int n = 16;
                BytecodeManager.incBytecodes(4);
                if (length != n) {
                    final String detailMessage = "data must be 16 bytes in length";
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = 8;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                mostSigBits = (mostSigBits << 8 | (long)(array[n2] & 0xFF));
                BytecodeManager.incBytecodes(11);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            int n5 = 8;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                final int n7 = 16;
                BytecodeManager.incBytecodes(3);
                if (n6 >= n7) {
                    break;
                }
                leastSigBits = (leastSigBits << 8 | (long)(array[n5] & 0xFF));
                BytecodeManager.incBytecodes(11);
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            this.mostSigBits = mostSigBits;
            BytecodeManager.incBytecodes(3);
            this.leastSigBits = leastSigBits;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public UUID(final long mostSigBits, final long leastSigBits) {
        try {
            BytecodeManager.incBytecodes(2);
            this.mostSigBits = mostSigBits;
            BytecodeManager.incBytecodes(3);
            this.leastSigBits = leastSigBits;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static UUID randomUUID() {
        try {
            final SecureRandom numberGenerator = Holder.numberGenerator;
            BytecodeManager.incBytecodes(2);
            final byte[] array = new byte[16];
            BytecodeManager.incBytecodes(2);
            final SecureRandom secureRandom = numberGenerator;
            final byte[] bytes = array;
            BytecodeManager.incBytecodes(3);
            secureRandom.nextBytes(bytes);
            final byte[] array2 = array;
            final int n = 6;
            array2[n] &= 0xF;
            BytecodeManager.incBytecodes(8);
            final byte[] array3 = array;
            final int n2 = 6;
            array3[n2] |= 0x40;
            BytecodeManager.incBytecodes(8);
            final byte[] array4 = array;
            final int n3 = 8;
            array4[n3] &= 0x3F;
            BytecodeManager.incBytecodes(8);
            final byte[] array5 = array;
            final int n4 = 8;
            array5[n4] |= (byte)128;
            BytecodeManager.incBytecodes(8);
            final byte[] array6 = array;
            BytecodeManager.incBytecodes(4);
            final UUID uuid = new UUID(array6);
            BytecodeManager.incBytecodes(1);
            return uuid;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static UUID nameUUIDFromBytes(final byte[] input) {
        try {
            try {
                MessageDigest instance;
                try {
                    final String algorithm = "MD5";
                    BytecodeManager.incBytecodes(2);
                    instance = MessageDigest.getInstance(algorithm);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                catch (NoSuchAlgorithmException ex) {
                    BytecodeManager.incBytecodes(501);
                    final String message = "MD5 not supported";
                    final NoSuchAlgorithmException cause = ex;
                    BytecodeManager.incBytecodes(5);
                    final InternalError internalError = new InternalError(message, cause);
                    BytecodeManager.incBytecodes(1);
                    throw internalError;
                }
                final MessageDigest messageDigest = instance;
                BytecodeManager.incBytecodes(3);
                final byte[] digest = messageDigest.digest(input);
                BytecodeManager.incBytecodes(1);
                final byte[] array = digest;
                final int n = 6;
                array[n] &= 0xF;
                BytecodeManager.incBytecodes(8);
                final byte[] array2 = digest;
                final int n2 = 6;
                array2[n2] |= 0x30;
                BytecodeManager.incBytecodes(8);
                final byte[] array3 = digest;
                final int n3 = 8;
                array3[n3] &= 0x3F;
                BytecodeManager.incBytecodes(8);
                final byte[] array4 = digest;
                final int n4 = 8;
                array4[n4] |= (byte)128;
                BytecodeManager.incBytecodes(8);
                final byte[] array5 = digest;
                BytecodeManager.incBytecodes(4);
                final UUID uuid = new UUID(array5);
                BytecodeManager.incBytecodes(1);
                return uuid;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public static UUID fromString(final String str) {
        try {
            final String regex = "-";
            BytecodeManager.incBytecodes(3);
            final String[] split = str.split(regex);
            BytecodeManager.incBytecodes(1);
            final int length = split.length;
            final int n = 5;
            BytecodeManager.incBytecodes(4);
            if (length != n) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str2 = "Invalid UUID string: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = 5;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final String[] array = split;
                final int n5 = n2;
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str3 = "0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str3);
                final String str4 = split[n2];
                BytecodeManager.incBytecodes(4);
                final StringBuilder append4 = append3.append(str4);
                BytecodeManager.incBytecodes(1);
                array[n5] = append4.toString();
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final String nm = split[0];
            BytecodeManager.incBytecodes(4);
            final Long decode = Long.decode(nm);
            BytecodeManager.incBytecodes(1);
            final long longValue = decode;
            BytecodeManager.incBytecodes(1);
            final long n6 = longValue << 16;
            BytecodeManager.incBytecodes(4);
            final long n7 = n6;
            final String nm2 = split[1];
            BytecodeManager.incBytecodes(5);
            final Long decode2 = Long.decode(nm2);
            BytecodeManager.incBytecodes(1);
            final long n8 = n7 | (long)decode2;
            BytecodeManager.incBytecodes(2);
            final long n9 = n8 << 16;
            BytecodeManager.incBytecodes(4);
            final long n10 = n9;
            final String nm3 = split[2];
            BytecodeManager.incBytecodes(5);
            final Long decode3 = Long.decode(nm3);
            BytecodeManager.incBytecodes(1);
            final long n11 = n10 | (long)decode3;
            BytecodeManager.incBytecodes(2);
            final String nm4 = split[3];
            BytecodeManager.incBytecodes(4);
            final Long decode4 = Long.decode(nm4);
            BytecodeManager.incBytecodes(1);
            final long longValue2 = decode4;
            BytecodeManager.incBytecodes(1);
            final long n12 = longValue2 << 48;
            BytecodeManager.incBytecodes(4);
            final long n13 = n12;
            final String nm5 = split[4];
            BytecodeManager.incBytecodes(5);
            final Long decode5 = Long.decode(nm5);
            BytecodeManager.incBytecodes(1);
            final long n14 = n13 | (long)decode5;
            BytecodeManager.incBytecodes(2);
            final long n15 = n11;
            final long n16 = n14;
            BytecodeManager.incBytecodes(5);
            final UUID uuid = new UUID(n15, n16);
            BytecodeManager.incBytecodes(1);
            return uuid;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getLeastSignificantBits() {
        try {
            final long leastSigBits = this.leastSigBits;
            BytecodeManager.incBytecodes(3);
            return leastSigBits;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getMostSignificantBits() {
        try {
            final long mostSigBits = this.mostSigBits;
            BytecodeManager.incBytecodes(3);
            return mostSigBits;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int version() {
        try {
            final int n = (int)(this.mostSigBits >> 12 & 0xFL);
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int variant() {
        try {
            final int n = (int)(this.leastSigBits >>> (int)(64L - (this.leastSigBits >>> 62)) & this.leastSigBits >> 63);
            BytecodeManager.incBytecodes(17);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long timestamp() {
        try {
            BytecodeManager.incBytecodes(2);
            final int version = this.version();
            final int n = 1;
            BytecodeManager.incBytecodes(2);
            if (version != n) {
                final String message = "Not a time-based UUID";
                BytecodeManager.incBytecodes(4);
                final UnsupportedOperationException ex = new UnsupportedOperationException(message);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n2 = (this.mostSigBits & 0xFFFL) << 48 | (this.mostSigBits >> 16 & 0xFFFFL) << 32 | this.mostSigBits >>> 32;
            BytecodeManager.incBytecodes(21);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int clockSequence() {
        try {
            BytecodeManager.incBytecodes(2);
            final int version = this.version();
            final int n = 1;
            BytecodeManager.incBytecodes(2);
            if (version != n) {
                final String message = "Not a time-based UUID";
                BytecodeManager.incBytecodes(4);
                final UnsupportedOperationException ex = new UnsupportedOperationException(message);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = (int)((this.leastSigBits & 0x3FFF000000000000L) >>> 48);
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long node() {
        try {
            BytecodeManager.incBytecodes(2);
            final int version = this.version();
            final int n = 1;
            BytecodeManager.incBytecodes(2);
            if (version != n) {
                final String message = "Not a time-based UUID";
                BytecodeManager.incBytecodes(4);
                final UnsupportedOperationException ex = new UnsupportedOperationException(message);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n2 = this.leastSigBits & 0xFFFFFFFFFFFFL;
            BytecodeManager.incBytecodes(5);
            return n2;
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
            final long n = this.mostSigBits >> 32;
            final int n2 = 8;
            BytecodeManager.incBytecodes(6);
            final String digits = digits(n, n2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(digits);
            final String str = "-";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str);
            final long n3 = this.mostSigBits >> 16;
            final int n4 = 4;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String digits2 = digits(n3, n4);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append3 = append2.append(digits2);
            final String str2 = "-";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(str2);
            final long mostSigBits = this.mostSigBits;
            final int n5 = 4;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final String digits3 = digits(mostSigBits, n5);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append5 = append4.append(digits3);
            final String str3 = "-";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(str3);
            final long n6 = this.leastSigBits >> 48;
            final int n7 = 4;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String digits4 = digits(n6, n7);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append7 = append6.append(digits4);
            final String str4 = "-";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append8 = append7.append(str4);
            final long leastSigBits = this.leastSigBits;
            final int n8 = 12;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final String digits5 = digits(leastSigBits, n8);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append9 = append8.append(digits5);
            BytecodeManager.incBytecodes(1);
            final String string = append9.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String digits(final long n, final int n2) {
        try {
            final long n3 = 1L << n2 * 4;
            BytecodeManager.incBytecodes(6);
            final long i = n3 | (n & n3 - 1L);
            BytecodeManager.incBytecodes(8);
            final String hexString = Long.toHexString(i);
            final int beginIndex = 1;
            BytecodeManager.incBytecodes(2);
            final String substring = hexString.substring(beginIndex);
            BytecodeManager.incBytecodes(1);
            return substring;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final long n = this.mostSigBits ^ this.leastSigBits;
            BytecodeManager.incBytecodes(6);
            final int n2 = (int)(n >> 32) ^ (int)n;
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            final Object o2 = null;
            BytecodeManager.incBytecodes(3);
            if (o2 != o) {
                BytecodeManager.incBytecodes(2);
                final Class<?> class1 = o.getClass();
                final Class<UUID> clazz = UUID.class;
                BytecodeManager.incBytecodes(2);
                if (class1 == clazz) {
                    final UUID uuid = (UUID)o;
                    BytecodeManager.incBytecodes(3);
                    final long n = lcmp(this.mostSigBits, uuid.mostSigBits);
                    BytecodeManager.incBytecodes(6);
                    boolean b = false;
                    Label_0095: {
                        if (n == 0) {
                            final long n2 = lcmp(this.leastSigBits, uuid.leastSigBits);
                            BytecodeManager.incBytecodes(6);
                            if (n2 == 0) {
                                b = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0095;
                            }
                        }
                        b = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
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
    
    @Override
    public int compareTo(final UUID uuid) {
        try {
            final long n = lcmp(this.mostSigBits, uuid.mostSigBits);
            BytecodeManager.incBytecodes(6);
            int n2;
            if (n < 0) {
                n2 = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final long n3 = lcmp(this.mostSigBits, uuid.mostSigBits);
                BytecodeManager.incBytecodes(6);
                if (n3 > 0) {
                    n2 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n4 = lcmp(this.leastSigBits, uuid.leastSigBits);
                    BytecodeManager.incBytecodes(6);
                    if (n4 < 0) {
                        n2 = -1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final long n5 = lcmp(this.leastSigBits, uuid.leastSigBits);
                        BytecodeManager.incBytecodes(6);
                        if (n5 > 0) {
                            n2 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n2 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
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
            final Class<UUID> clazz = UUID.class;
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
    
    private static class Holder
    {
        static final SecureRandom numberGenerator;
        
        private Holder() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                numberGenerator = new SecureRandom();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
