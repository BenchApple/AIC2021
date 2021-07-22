// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import java.io.PrintStream;
import instrumented.java.util.Arrays;
import instrumented.java.util.Random;
import aic2021.engine.BytecodeManager;

class Base64
{
    private static final char[] intToBase64;
    private static final char[] intToAltBase64;
    private static final byte[] base64ToInt;
    private static final byte[] altBase64ToInt;
    
    Base64() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static String byteArrayToBase64(final byte[] array) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final String byteArrayToBase64 = byteArrayToBase64(array, b);
            BytecodeManager.incBytecodes(1);
            return byteArrayToBase64;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static String byteArrayToAltBase64(final byte[] array) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final String byteArrayToBase64 = byteArrayToBase64(array, b);
            BytecodeManager.incBytecodes(1);
            return byteArrayToBase64;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String byteArrayToBase64(final byte[] array, final boolean b) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length / 3;
            BytecodeManager.incBytecodes(4);
            final int n2 = length - 3 * n;
            BytecodeManager.incBytecodes(6);
            final int n3 = 4 * ((length + 2) / 3);
            BytecodeManager.incBytecodes(8);
            final int capacity = n3;
            BytecodeManager.incBytecodes(4);
            final StringBuffer sb = new StringBuffer(capacity);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            char[] array2;
            if (b) {
                array2 = Base64.intToAltBase64;
                BytecodeManager.incBytecodes(2);
            }
            else {
                array2 = Base64.intToBase64;
                BytecodeManager.incBytecodes(1);
            }
            final char[] array3 = array2;
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            int n5 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                final int n7 = n;
                BytecodeManager.incBytecodes(3);
                if (n6 >= n7) {
                    break;
                }
                final int n8 = array[n4++] & 0xFF;
                BytecodeManager.incBytecodes(7);
                final int n9 = array[n4++] & 0xFF;
                BytecodeManager.incBytecodes(7);
                final int n10 = array[n4++] & 0xFF;
                BytecodeManager.incBytecodes(7);
                final StringBuffer sb2 = sb;
                final char c = array3[n8 >> 2];
                BytecodeManager.incBytecodes(7);
                sb2.append(c);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb3 = sb;
                final char c2 = array3[(n8 << 4 & 0x3F) | n9 >> 4];
                BytecodeManager.incBytecodes(13);
                sb3.append(c2);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb4 = sb;
                final char c3 = array3[(n9 << 2 & 0x3F) | n10 >> 6];
                BytecodeManager.incBytecodes(13);
                sb4.append(c3);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb5 = sb;
                final char c4 = array3[n10 & 0x3F];
                BytecodeManager.incBytecodes(7);
                sb5.append(c4);
                BytecodeManager.incBytecodes(1);
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            final int n11 = n2;
            BytecodeManager.incBytecodes(2);
            if (n11 != 0) {
                final int n12 = array[n4++] & 0xFF;
                BytecodeManager.incBytecodes(7);
                final StringBuffer sb6 = sb;
                final char c5 = array3[n12 >> 2];
                BytecodeManager.incBytecodes(7);
                sb6.append(c5);
                BytecodeManager.incBytecodes(1);
                final int n13 = n2;
                final int n14 = 1;
                BytecodeManager.incBytecodes(3);
                if (n13 == n14) {
                    final StringBuffer sb7 = sb;
                    final char c6 = array3[n12 << 4 & 0x3F];
                    BytecodeManager.incBytecodes(9);
                    sb7.append(c6);
                    BytecodeManager.incBytecodes(1);
                    final StringBuffer sb8 = sb;
                    final String str = "==";
                    BytecodeManager.incBytecodes(3);
                    sb8.append(str);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int n15 = array[n4++] & 0xFF;
                    BytecodeManager.incBytecodes(7);
                    final StringBuffer sb9 = sb;
                    final char c7 = array3[(n12 << 4 & 0x3F) | n15 >> 4];
                    BytecodeManager.incBytecodes(13);
                    sb9.append(c7);
                    BytecodeManager.incBytecodes(1);
                    final StringBuffer sb10 = sb;
                    final char c8 = array3[n15 << 2 & 0x3F];
                    BytecodeManager.incBytecodes(9);
                    sb10.append(c8);
                    BytecodeManager.incBytecodes(1);
                    final StringBuffer sb11 = sb;
                    final char c9 = '=';
                    BytecodeManager.incBytecodes(3);
                    sb11.append(c9);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final StringBuffer sb12 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb12.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static byte[] base64ToByteArray(final String s) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final byte[] base64ToByteArray = base64ToByteArray(s, b);
            BytecodeManager.incBytecodes(1);
            return base64ToByteArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static byte[] altBase64ToByteArray(final String s) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final byte[] base64ToByteArray = base64ToByteArray(s, b);
            BytecodeManager.incBytecodes(1);
            return base64ToByteArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static byte[] base64ToByteArray(final String s, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            byte[] array;
            if (b) {
                array = Base64.altBase64ToInt;
                BytecodeManager.incBytecodes(2);
            }
            else {
                array = Base64.base64ToInt;
                BytecodeManager.incBytecodes(1);
            }
            final byte[] array2 = array;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            final int n = length / 4;
            BytecodeManager.incBytecodes(4);
            final int n2 = 4 * n;
            final int n3 = length;
            BytecodeManager.incBytecodes(5);
            if (n2 != n3) {
                final String s2 = "String length must be a multiple of four.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            int n5 = n;
            BytecodeManager.incBytecodes(2);
            final int n6 = length;
            BytecodeManager.incBytecodes(2);
            if (n6 != 0) {
                final int index = length - 1;
                BytecodeManager.incBytecodes(5);
                final char char1 = s.charAt(index);
                final int n7 = '=';
                BytecodeManager.incBytecodes(2);
                if (char1 == n7) {
                    ++n4;
                    BytecodeManager.incBytecodes(1);
                    --n5;
                    BytecodeManager.incBytecodes(1);
                }
                final int index2 = length - 2;
                BytecodeManager.incBytecodes(5);
                final char char2 = s.charAt(index2);
                final int n8 = '=';
                BytecodeManager.incBytecodes(2);
                if (char2 == n8) {
                    ++n4;
                    BytecodeManager.incBytecodes(1);
                }
            }
            final byte[] array3 = new byte[3 * n - n4];
            BytecodeManager.incBytecodes(6);
            int n9 = 0;
            int n10 = 0;
            BytecodeManager.incBytecodes(4);
            int n11 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n12 = n11;
                final int n13 = n5;
                BytecodeManager.incBytecodes(3);
                if (n12 >= n13) {
                    break;
                }
                final int index3 = n9++;
                BytecodeManager.incBytecodes(4);
                final char char3 = s.charAt(index3);
                final byte[] array4 = array2;
                BytecodeManager.incBytecodes(2);
                final int base64toInt = base64toInt(char3, array4);
                BytecodeManager.incBytecodes(1);
                final int index4 = n9++;
                BytecodeManager.incBytecodes(4);
                final char char4 = s.charAt(index4);
                final byte[] array5 = array2;
                BytecodeManager.incBytecodes(2);
                final int base64toInt2 = base64toInt(char4, array5);
                BytecodeManager.incBytecodes(1);
                final int index5 = n9++;
                BytecodeManager.incBytecodes(4);
                final char char5 = s.charAt(index5);
                final byte[] array6 = array2;
                BytecodeManager.incBytecodes(2);
                final int base64toInt3 = base64toInt(char5, array6);
                BytecodeManager.incBytecodes(1);
                final int index6 = n9++;
                BytecodeManager.incBytecodes(4);
                final char char6 = s.charAt(index6);
                final byte[] array7 = array2;
                BytecodeManager.incBytecodes(2);
                final int base64toInt4 = base64toInt(char6, array7);
                BytecodeManager.incBytecodes(1);
                array3[n10++] = (byte)(base64toInt << 2 | base64toInt2 >> 4);
                BytecodeManager.incBytecodes(12);
                array3[n10++] = (byte)(base64toInt2 << 4 | base64toInt3 >> 2);
                BytecodeManager.incBytecodes(12);
                array3[n10++] = (byte)(base64toInt3 << 6 | base64toInt4);
                BytecodeManager.incBytecodes(10);
                ++n11;
                BytecodeManager.incBytecodes(2);
            }
            final int n14 = n4;
            BytecodeManager.incBytecodes(2);
            if (n14 != 0) {
                final int index7 = n9++;
                BytecodeManager.incBytecodes(4);
                final char char7 = s.charAt(index7);
                final byte[] array8 = array2;
                BytecodeManager.incBytecodes(2);
                final int base64toInt5 = base64toInt(char7, array8);
                BytecodeManager.incBytecodes(1);
                final int index8 = n9++;
                BytecodeManager.incBytecodes(4);
                final char char8 = s.charAt(index8);
                final byte[] array9 = array2;
                BytecodeManager.incBytecodes(2);
                final int base64toInt6 = base64toInt(char8, array9);
                BytecodeManager.incBytecodes(1);
                array3[n10++] = (byte)(base64toInt5 << 2 | base64toInt6 >> 4);
                BytecodeManager.incBytecodes(12);
                final int n15 = n4;
                final int n16 = 1;
                BytecodeManager.incBytecodes(3);
                if (n15 == n16) {
                    final int index9 = n9++;
                    BytecodeManager.incBytecodes(4);
                    final char char9 = s.charAt(index9);
                    final byte[] array10 = array2;
                    BytecodeManager.incBytecodes(2);
                    final int base64toInt7 = base64toInt(char9, array10);
                    BytecodeManager.incBytecodes(1);
                    array3[n10++] = (byte)(base64toInt6 << 4 | base64toInt7 >> 2);
                    BytecodeManager.incBytecodes(12);
                }
            }
            final byte[] array11 = array3;
            BytecodeManager.incBytecodes(2);
            return array11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int base64toInt(final char c, final byte[] array) {
        try {
            final byte b = array[c];
            BytecodeManager.incBytecodes(4);
            final byte b2 = b;
            BytecodeManager.incBytecodes(2);
            if (b2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal character ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(c);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final byte b3 = b;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void main(final String[] array) {
        try {
            final String s = array[0];
            BytecodeManager.incBytecodes(4);
            final int int1 = Integer.parseInt(s);
            BytecodeManager.incBytecodes(1);
            final String s2 = array[1];
            BytecodeManager.incBytecodes(4);
            final int int2 = Integer.parseInt(s2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final Random random = new Random();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = int1;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    final int n6 = int2;
                    BytecodeManager.incBytecodes(3);
                    if (n5 >= n6) {
                        break;
                    }
                    final byte[] array2 = new byte[n4];
                    BytecodeManager.incBytecodes(2);
                    int n7 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n8 = n7;
                        final int n9 = n4;
                        BytecodeManager.incBytecodes(3);
                        if (n8 >= n9) {
                            break;
                        }
                        final byte[] array3 = array2;
                        final int n10 = n7;
                        final Random random2 = random;
                        BytecodeManager.incBytecodes(4);
                        array3[n10] = (byte)random2.nextInt();
                        BytecodeManager.incBytecodes(2);
                        ++n7;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte[] array4 = array2;
                    BytecodeManager.incBytecodes(2);
                    final String byteArrayToBase64 = byteArrayToBase64(array4);
                    BytecodeManager.incBytecodes(1);
                    final String s3 = byteArrayToBase64;
                    BytecodeManager.incBytecodes(2);
                    final byte[] base64ToByteArray = base64ToByteArray(s3);
                    BytecodeManager.incBytecodes(1);
                    final byte[] array5 = array2;
                    final byte[] array6 = base64ToByteArray;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = Arrays.equals(array5, array6);
                    BytecodeManager.incBytecodes(1);
                    if (!equals) {
                        final PrintStream out = System.out;
                        final String x = "Dismal failure!";
                        BytecodeManager.incBytecodes(3);
                        out.println(x);
                    }
                    final byte[] array7 = array2;
                    BytecodeManager.incBytecodes(2);
                    final String byteArrayToAltBase64 = byteArrayToAltBase64(array7);
                    BytecodeManager.incBytecodes(1);
                    final String s4 = byteArrayToAltBase64;
                    BytecodeManager.incBytecodes(2);
                    final byte[] altBase64ToByteArray = altBase64ToByteArray(s4);
                    BytecodeManager.incBytecodes(1);
                    final byte[] array8 = array2;
                    final byte[] array9 = altBase64ToByteArray;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals2 = Arrays.equals(array8, array9);
                    BytecodeManager.incBytecodes(1);
                    if (!equals2) {
                        final PrintStream out2 = System.out;
                        final String x2 = "Alternate dismal failure!";
                        BytecodeManager.incBytecodes(3);
                        out2.println(x2);
                    }
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            intToBase64 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
            BytecodeManager.incBytecodes(258);
            intToAltBase64 = new char[] { '!', '\"', '#', '$', '%', '&', '\'', '(', ')', ',', '-', '.', ':', ';', '<', '>', '@', '[', ']', '^', '`', '_', '{', '|', '}', '~', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '?' };
            BytecodeManager.incBytecodes(258);
            base64ToInt = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
            BytecodeManager.incBytecodes(494);
            altBase64ToInt = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, -1, 62, 9, 10, 11, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 12, 13, 14, -1, 15, 63, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, 18, 19, 21, 20, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 22, 23, 24, 25 };
            BytecodeManager.incBytecodes(511);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
