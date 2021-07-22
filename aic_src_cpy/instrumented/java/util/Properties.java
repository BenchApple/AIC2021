// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.security.AccessController;
import jdk.internal.util.xml.BasicXmlPropertiesProvider;
import java.security.PrivilegedAction;
import java.util.Iterator;
import sun.util.spi.XmlPropertiesProvider;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import aic2021.engine.BytecodeManager;

public class Properties extends Hashtable<Object, Object>
{
    private static final long serialVersionUID = 4112578634029874840L;
    protected Properties defaults;
    private static final char[] hexDigit;
    
    public Properties() {
        try {
            final Properties properties = null;
            BytecodeManager.incBytecodes(3);
            this(properties);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Properties(final Properties defaults) {
        try {
            BytecodeManager.incBytecodes(2);
            this.defaults = defaults;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized Object setProperty(final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(4);
            final String put = ((Hashtable<String, String>)this).put(s, s2);
            BytecodeManager.incBytecodes(1);
            return put;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void load(final Reader reader) throws IOException {
        try {
            BytecodeManager.incBytecodes(6);
            final LineReader lineReader = new LineReader(reader);
            BytecodeManager.incBytecodes(1);
            this.load0(lineReader);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void load(final InputStream inputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(6);
            final LineReader lineReader = new LineReader(inputStream);
            BytecodeManager.incBytecodes(1);
            this.load0(lineReader);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void load0(final LineReader lineReader) throws IOException {
        try {
            final char[] array = new char[1024];
            BytecodeManager.incBytecodes(2);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final int line;
                final int n = line = lineReader.readLine();
                BytecodeManager.incBytecodes(3);
                if (n < 0) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                int n3 = line;
                BytecodeManager.incBytecodes(2);
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n2;
                    final int n6 = line;
                    BytecodeManager.incBytecodes(3);
                    if (n5 >= n6) {
                        break;
                    }
                    final char c = lineReader.lineBuf[n2];
                    BytecodeManager.incBytecodes(5);
                    final char c2 = c;
                    final int n7 = '=';
                    BytecodeManager.incBytecodes(3);
                    Label_0156: {
                        if (c2 != n7) {
                            final char c3 = c;
                            final int n8 = ':';
                            BytecodeManager.incBytecodes(3);
                            if (c3 != n8) {
                                break Label_0156;
                            }
                        }
                        final int n9 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n9 == 0) {
                            n3 = n2 + 1;
                            BytecodeManager.incBytecodes(4);
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    final char c4 = c;
                    final int n10 = ' ';
                    BytecodeManager.incBytecodes(3);
                    Label_0221: {
                        if (c4 != n10) {
                            final char c5 = c;
                            final int n11 = '\t';
                            BytecodeManager.incBytecodes(3);
                            if (c5 != n11) {
                                final char c6 = c;
                                final int n12 = '\f';
                                BytecodeManager.incBytecodes(3);
                                if (c6 != n12) {
                                    break Label_0221;
                                }
                            }
                        }
                        final int n13 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n13 == 0) {
                            n3 = n2 + 1;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    final char c7 = c;
                    final int n14 = '\\';
                    BytecodeManager.incBytecodes(3);
                    if (c7 == n14) {
                        final int n15 = n4;
                        BytecodeManager.incBytecodes(2);
                        int n16;
                        if (n15 == 0) {
                            n16 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n16 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        n4 = n16;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n4 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                while (true) {
                    final int n17 = n3;
                    final int n18 = line;
                    BytecodeManager.incBytecodes(3);
                    if (n17 >= n18) {
                        break;
                    }
                    final char c8 = lineReader.lineBuf[n3];
                    BytecodeManager.incBytecodes(5);
                    final char c9 = c8;
                    final int n19 = ' ';
                    BytecodeManager.incBytecodes(3);
                    if (c9 != n19) {
                        final char c10 = c8;
                        final int n20 = '\t';
                        BytecodeManager.incBytecodes(3);
                        if (c10 != n20) {
                            final char c11 = c8;
                            final int n21 = '\f';
                            BytecodeManager.incBytecodes(3);
                            if (c11 != n21) {
                                final boolean b2 = b;
                                BytecodeManager.incBytecodes(2);
                                if (b2) {
                                    break;
                                }
                                final char c12 = c8;
                                final int n22 = '=';
                                BytecodeManager.incBytecodes(3);
                                if (c12 != n22) {
                                    final char c13 = c8;
                                    final int n23 = ':';
                                    BytecodeManager.incBytecodes(3);
                                    if (c13 != n23) {
                                        break;
                                    }
                                }
                                b = true;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final char[] lineBuf = lineReader.lineBuf;
                final int n24 = 0;
                final int n25 = n2;
                final char[] array2 = array;
                BytecodeManager.incBytecodes(7);
                final String loadConvert = this.loadConvert(lineBuf, n24, n25, array2);
                BytecodeManager.incBytecodes(1);
                final char[] lineBuf2 = lineReader.lineBuf;
                final int n26 = n3;
                final int n27 = line - n3;
                final char[] array3 = array;
                BytecodeManager.incBytecodes(9);
                final String loadConvert2 = this.loadConvert(lineBuf2, n26, n27, array3);
                BytecodeManager.incBytecodes(1);
                final String s = loadConvert;
                final String s2 = loadConvert2;
                BytecodeManager.incBytecodes(4);
                ((Hashtable<String, String>)this).put(s, s2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String loadConvert(final char[] array, int n, final int n2, char[] array2) {
        try {
            final int length = array2.length;
            BytecodeManager.incBytecodes(4);
            if (length < n2) {
                int n3 = n2 * 2;
                BytecodeManager.incBytecodes(4);
                final int n4 = n3;
                BytecodeManager.incBytecodes(2);
                if (n4 < 0) {
                    n3 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                }
                array2 = new char[n3];
                BytecodeManager.incBytecodes(2);
            }
            final char[] array3 = array2;
            BytecodeManager.incBytecodes(2);
            int n5 = 0;
            BytecodeManager.incBytecodes(2);
            final int n6 = n + n2;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n7 = n;
                final int n8 = n6;
                BytecodeManager.incBytecodes(3);
                if (n7 >= n8) {
                    final char[] value = array3;
                    final int offset = 0;
                    final int count = n5;
                    BytecodeManager.incBytecodes(6);
                    final String s = new String(value, offset, count);
                    BytecodeManager.incBytecodes(1);
                    return s;
                }
                final char c = array[n++];
                BytecodeManager.incBytecodes(5);
                final char c2 = c;
                final int n9 = '\\';
                BytecodeManager.incBytecodes(3);
                if (c2 == n9) {
                    char c3 = array[n++];
                    BytecodeManager.incBytecodes(5);
                    final char c4 = c3;
                    final int n10 = 'u';
                    BytecodeManager.incBytecodes(3);
                    if (c4 == n10) {
                        int n11 = 0;
                        BytecodeManager.incBytecodes(2);
                        int n12 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n13 = n12;
                            final int n14 = 4;
                            BytecodeManager.incBytecodes(3);
                            if (n13 >= n14) {
                                array3[n5++] = (char)n11;
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final char c5 = array[n++];
                            BytecodeManager.incBytecodes(5);
                            final char c6 = c5;
                            BytecodeManager.incBytecodes(2);
                            switch (c6) {
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
                                    n11 = (n11 << 4) + c5 - 48;
                                    BytecodeManager.incBytecodes(8);
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102: {
                                    n11 = (n11 << 4) + 10 + c5 - 97;
                                    BytecodeManager.incBytecodes(10);
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                case 65:
                                case 66:
                                case 67:
                                case 68:
                                case 69:
                                case 70: {
                                    n11 = (n11 << 4) + 10 + c5 - 65;
                                    BytecodeManager.incBytecodes(10);
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                default: {
                                    final String s2 = "Malformed \\uxxxx encoding.";
                                    BytecodeManager.incBytecodes(4);
                                    final IllegalArgumentException ex = new IllegalArgumentException(s2);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex;
                                }
                            }
                            ++n12;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    else {
                        final char c7 = c3;
                        final int n15 = 't';
                        BytecodeManager.incBytecodes(3);
                        if (c7 == n15) {
                            c3 = '\t';
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            final char c8 = c3;
                            final int n16 = 'r';
                            BytecodeManager.incBytecodes(3);
                            if (c8 == n16) {
                                c3 = '\r';
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final char c9 = c3;
                                final int n17 = 'n';
                                BytecodeManager.incBytecodes(3);
                                if (c9 == n17) {
                                    c3 = '\n';
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final char c10 = c3;
                                    final int n18 = 'f';
                                    BytecodeManager.incBytecodes(3);
                                    if (c10 == n18) {
                                        c3 = '\f';
                                        BytecodeManager.incBytecodes(2);
                                    }
                                }
                            }
                        }
                        array3[n5++] = c3;
                        BytecodeManager.incBytecodes(6);
                    }
                }
                else {
                    array3[n5++] = c;
                    BytecodeManager.incBytecodes(6);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String saveConvert(final String s, final boolean b, final boolean b2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            int n = length * 2;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                n = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
            }
            final int capacity = n;
            BytecodeManager.incBytecodes(4);
            final StringBuffer sb = new StringBuffer(capacity);
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final int index = n3;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index);
                BytecodeManager.incBytecodes(1);
                final char c = char1;
                final int n6 = '=';
                BytecodeManager.incBytecodes(3);
                Label_0784: {
                    if (c > n6) {
                        final char c2 = char1;
                        final int n7 = '\u007f';
                        BytecodeManager.incBytecodes(3);
                        if (c2 < n7) {
                            final char c3 = char1;
                            final int n8 = '\\';
                            BytecodeManager.incBytecodes(3);
                            if (c3 == n8) {
                                final StringBuffer sb2 = sb;
                                final char c4 = '\\';
                                BytecodeManager.incBytecodes(3);
                                sb2.append(c4);
                                final StringBuffer sb3 = sb;
                                final char c5 = '\\';
                                BytecodeManager.incBytecodes(4);
                                sb3.append(c5);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break Label_0784;
                            }
                            final StringBuffer sb4 = sb;
                            final char c6 = char1;
                            BytecodeManager.incBytecodes(3);
                            sb4.append(c6);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_0784;
                        }
                    }
                    final char c7 = char1;
                    BytecodeManager.incBytecodes(2);
                    switch (c7) {
                        case 32: {
                            final int n9 = n3;
                            BytecodeManager.incBytecodes(2);
                            Label_0333: {
                                if (n9 != 0) {
                                    BytecodeManager.incBytecodes(2);
                                    if (!b) {
                                        break Label_0333;
                                    }
                                }
                                final StringBuffer sb5 = sb;
                                final char c8 = '\\';
                                BytecodeManager.incBytecodes(3);
                                sb5.append(c8);
                                BytecodeManager.incBytecodes(1);
                            }
                            final StringBuffer sb6 = sb;
                            final char c9 = ' ';
                            BytecodeManager.incBytecodes(3);
                            sb6.append(c9);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 9: {
                            final StringBuffer sb7 = sb;
                            final char c10 = '\\';
                            BytecodeManager.incBytecodes(3);
                            sb7.append(c10);
                            final StringBuffer sb8 = sb;
                            final char c11 = 't';
                            BytecodeManager.incBytecodes(4);
                            sb8.append(c11);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 10: {
                            final StringBuffer sb9 = sb;
                            final char c12 = '\\';
                            BytecodeManager.incBytecodes(3);
                            sb9.append(c12);
                            final StringBuffer sb10 = sb;
                            final char c13 = 'n';
                            BytecodeManager.incBytecodes(4);
                            sb10.append(c13);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 13: {
                            final StringBuffer sb11 = sb;
                            final char c14 = '\\';
                            BytecodeManager.incBytecodes(3);
                            sb11.append(c14);
                            final StringBuffer sb12 = sb;
                            final char c15 = 'r';
                            BytecodeManager.incBytecodes(4);
                            sb12.append(c15);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 12: {
                            final StringBuffer sb13 = sb;
                            final char c16 = '\\';
                            BytecodeManager.incBytecodes(3);
                            sb13.append(c16);
                            final StringBuffer sb14 = sb;
                            final char c17 = 'f';
                            BytecodeManager.incBytecodes(4);
                            sb14.append(c17);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        case 33:
                        case 35:
                        case 58:
                        case 61: {
                            final StringBuffer sb15 = sb;
                            final char c18 = '\\';
                            BytecodeManager.incBytecodes(3);
                            sb15.append(c18);
                            final StringBuffer sb16 = sb;
                            final char c19 = char1;
                            BytecodeManager.incBytecodes(4);
                            sb16.append(c19);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        default: {
                            final char c20 = char1;
                            final int n10 = ' ';
                            BytecodeManager.incBytecodes(3);
                            boolean b3 = false;
                            Label_0593: {
                                if (c20 >= n10) {
                                    final char c21 = char1;
                                    final int n11 = '~';
                                    BytecodeManager.incBytecodes(3);
                                    if (c21 <= n11) {
                                        b3 = false;
                                        BytecodeManager.incBytecodes(1);
                                        break Label_0593;
                                    }
                                }
                                b3 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            final boolean b4 = b3 & b2;
                            BytecodeManager.incBytecodes(3);
                            if (b4) {
                                final StringBuffer sb17 = sb;
                                final char c22 = '\\';
                                BytecodeManager.incBytecodes(3);
                                sb17.append(c22);
                                BytecodeManager.incBytecodes(1);
                                final StringBuffer sb18 = sb;
                                final char c23 = 'u';
                                BytecodeManager.incBytecodes(3);
                                sb18.append(c23);
                                BytecodeManager.incBytecodes(1);
                                final StringBuffer sb19 = sb;
                                final int n12 = char1 >> 12 & 0xF;
                                BytecodeManager.incBytecodes(7);
                                final char hex = toHex(n12);
                                BytecodeManager.incBytecodes(1);
                                sb19.append(hex);
                                BytecodeManager.incBytecodes(1);
                                final StringBuffer sb20 = sb;
                                final int n13 = char1 >> 8 & 0xF;
                                BytecodeManager.incBytecodes(7);
                                final char hex2 = toHex(n13);
                                BytecodeManager.incBytecodes(1);
                                sb20.append(hex2);
                                BytecodeManager.incBytecodes(1);
                                final StringBuffer sb21 = sb;
                                final int n14 = char1 >> 4 & 0xF;
                                BytecodeManager.incBytecodes(7);
                                final char hex3 = toHex(n14);
                                BytecodeManager.incBytecodes(1);
                                sb21.append(hex3);
                                BytecodeManager.incBytecodes(1);
                                final StringBuffer sb22 = sb;
                                final int n15 = char1 & '\u000f';
                                BytecodeManager.incBytecodes(5);
                                final char hex4 = toHex(n15);
                                BytecodeManager.incBytecodes(1);
                                sb22.append(hex4);
                                BytecodeManager.incBytecodes(2);
                                break;
                            }
                            final StringBuffer sb23 = sb;
                            final char c24 = char1;
                            BytecodeManager.incBytecodes(3);
                            sb23.append(c24);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                }
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuffer sb24 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb24.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void writeComments(final BufferedWriter bufferedWriter, final String s) throws IOException {
        try {
            final String str = "#";
            BytecodeManager.incBytecodes(3);
            bufferedWriter.write(str);
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            final char[] array = new char[6];
            BytecodeManager.incBytecodes(2);
            array[0] = '\\';
            BytecodeManager.incBytecodes(4);
            array[1] = 'u';
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n3 = n;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final int index = n;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index);
                BytecodeManager.incBytecodes(1);
                final char c = char1;
                final int n5 = '\u00ff';
                BytecodeManager.incBytecodes(3);
                Label_0465: {
                    if (c <= n5) {
                        final char c2 = char1;
                        final int n6 = '\n';
                        BytecodeManager.incBytecodes(3);
                        if (c2 != n6) {
                            final char c3 = char1;
                            final int n7 = '\r';
                            BytecodeManager.incBytecodes(3);
                            if (c3 != n7) {
                                break Label_0465;
                            }
                        }
                    }
                    final int n8 = n2;
                    final int n9 = n;
                    BytecodeManager.incBytecodes(3);
                    if (n8 != n9) {
                        final int beginIndex = n2;
                        final int endIndex = n;
                        BytecodeManager.incBytecodes(5);
                        final String substring = s.substring(beginIndex, endIndex);
                        BytecodeManager.incBytecodes(1);
                        bufferedWriter.write(substring);
                    }
                    final char c4 = char1;
                    final int n10 = '\u00ff';
                    BytecodeManager.incBytecodes(3);
                    Label_0455: {
                        if (c4 > n10) {
                            final char[] array2 = array;
                            final int n11 = 2;
                            final int n12 = char1 >> 12 & 0xF;
                            BytecodeManager.incBytecodes(8);
                            array2[n11] = toHex(n12);
                            BytecodeManager.incBytecodes(1);
                            final char[] array3 = array;
                            final int n13 = 3;
                            final int n14 = char1 >> 8 & 0xF;
                            BytecodeManager.incBytecodes(8);
                            array3[n13] = toHex(n14);
                            BytecodeManager.incBytecodes(1);
                            final char[] array4 = array;
                            final int n15 = 4;
                            final int n16 = char1 >> 4 & 0xF;
                            BytecodeManager.incBytecodes(8);
                            array4[n15] = toHex(n16);
                            BytecodeManager.incBytecodes(1);
                            final char[] array5 = array;
                            final int n17 = 5;
                            final int n18 = char1 & '\u000f';
                            BytecodeManager.incBytecodes(6);
                            array5[n17] = toHex(n18);
                            BytecodeManager.incBytecodes(1);
                            final char[] value = array;
                            BytecodeManager.incBytecodes(5);
                            final String str2 = new String(value);
                            BytecodeManager.incBytecodes(1);
                            bufferedWriter.write(str2);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            BytecodeManager.incBytecodes(2);
                            bufferedWriter.newLine();
                            final char c5 = char1;
                            final int n19 = '\r';
                            BytecodeManager.incBytecodes(3);
                            if (c5 == n19) {
                                final int n20 = n;
                                final int n21 = length - 1;
                                BytecodeManager.incBytecodes(5);
                                if (n20 != n21) {
                                    final int index2 = n + 1;
                                    BytecodeManager.incBytecodes(4);
                                    BytecodeManager.incBytecodes(1);
                                    final char char2 = s.charAt(index2);
                                    final int n22 = '\n';
                                    BytecodeManager.incBytecodes(2);
                                    if (char2 == n22) {
                                        ++n;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            final int n23 = n;
                            final int n24 = length - 1;
                            BytecodeManager.incBytecodes(5);
                            if (n23 != n24) {
                                final int index3 = n + 1;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final char char3 = s.charAt(index3);
                                final int n25 = '#';
                                BytecodeManager.incBytecodes(2);
                                if (char3 == n25) {
                                    break Label_0455;
                                }
                                final int index4 = n + 1;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final char char4 = s.charAt(index4);
                                final int n26 = '!';
                                BytecodeManager.incBytecodes(2);
                                if (char4 == n26) {
                                    break Label_0455;
                                }
                            }
                            final String str3 = "#";
                            BytecodeManager.incBytecodes(3);
                            bufferedWriter.write(str3);
                        }
                    }
                    n2 = n + 1;
                    BytecodeManager.incBytecodes(4);
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            final int n27 = n2;
            final int n28 = n;
            BytecodeManager.incBytecodes(3);
            if (n27 != n28) {
                final int beginIndex2 = n2;
                final int endIndex2 = n;
                BytecodeManager.incBytecodes(5);
                final String substring2 = s.substring(beginIndex2, endIndex2);
                BytecodeManager.incBytecodes(1);
                bufferedWriter.write(substring2);
            }
            BytecodeManager.incBytecodes(2);
            bufferedWriter.newLine();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void save(final OutputStream outputStream, final String s) {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(4);
                    this.store(outputStream, s);
                    BytecodeManager.incBytecodes(1);
                }
                catch (IOException ex) {
                    BytecodeManager.incBytecodes(501);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public void store(final Writer out, final String s) throws IOException {
        try {
            final boolean b = out instanceof BufferedWriter;
            BytecodeManager.incBytecodes(4);
            BufferedWriter bufferedWriter;
            if (b) {
                bufferedWriter = (BufferedWriter)out;
                BytecodeManager.incBytecodes(3);
            }
            else {
                bufferedWriter = new BufferedWriter(out);
                BytecodeManager.incBytecodes(4);
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(3);
            this.store0(bufferedWriter, s, b2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void store(final OutputStream out, final String s) throws IOException {
        try {
            final String charsetName = "8859_1";
            BytecodeManager.incBytecodes(8);
            final OutputStreamWriter out2 = new OutputStreamWriter(out, charsetName);
            BytecodeManager.incBytecodes(1);
            final BufferedWriter bufferedWriter = new BufferedWriter(out2);
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            this.store0(bufferedWriter, s, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void store0(final BufferedWriter p0, final String p1, final boolean p2) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          19
        //     9: aload_1        
        //    10: aload_2        
        //    11: ldc             3
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokestatic    instrumented/java/util/Properties.writeComments:(Ljava/io/BufferedWriter;Ljava/lang/String;)V
        //    19: aload_1        
        //    20: new             Ljava/lang/StringBuilder;
        //    23: dup            
        //    24: ldc             4
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: invokespecial   java/lang/StringBuilder.<init>:()V
        //    32: ldc             "#"
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    42: new             Linstrumented/java/util/Date;
        //    45: dup            
        //    46: ldc             3
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: invokespecial   instrumented/java/util/Date.<init>:()V
        //    54: ldc             1
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokevirtual   instrumented/java/util/Date.toString:()Ljava/lang/String;
        //    62: ldc             1
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: invokevirtual   java/io/BufferedWriter.write:(Ljava/lang/String;)V
        //    86: aload_1        
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokevirtual   java/io/BufferedWriter.newLine:()V
        //    95: aload_0        
        //    96: dup            
        //    97: astore          4
        //    99: pop            
        //   100: ldc             4
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: aload_0        
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/Properties.keys:()Linstrumented/java/util/Enumeration;
        //   114: astore          5
        //   116: ldc             1
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: aload           5
        //   123: ldc             2
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: invokeinterface instrumented/java/util/Enumeration.hasMoreElements:()Z
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: ifeq            300
        //   141: aload           5
        //   143: ldc             2
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: invokeinterface instrumented/java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //   153: checkcast       Ljava/lang/String;
        //   156: astore          6
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: aload_0        
        //   164: aload           6
        //   166: ldc             3
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: invokevirtual   instrumented/java/util/Properties.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   174: checkcast       Ljava/lang/String;
        //   177: astore          7
        //   179: ldc             2
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: aload_0        
        //   185: aload           6
        //   187: iconst_1       
        //   188: iload_3        
        //   189: ldc             5
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokespecial   instrumented/java/util/Properties.saveConvert:(Ljava/lang/String;ZZ)Ljava/lang/String;
        //   197: astore          6
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: aload_0        
        //   205: aload           7
        //   207: iconst_0       
        //   208: iload_3        
        //   209: ldc             5
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokespecial   instrumented/java/util/Properties.saveConvert:(Ljava/lang/String;ZZ)Ljava/lang/String;
        //   217: astore          7
        //   219: ldc             1
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: aload_1        
        //   225: new             Ljava/lang/StringBuilder;
        //   228: dup            
        //   229: ldc             4
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: invokespecial   java/lang/StringBuilder.<init>:()V
        //   237: aload           6
        //   239: ldc             2
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: ldc             "="
        //   249: ldc             2
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: aload           7
        //   259: ldc             2
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   267: ldc             1
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   275: ldc             1
        //   277: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   280: invokevirtual   java/io/BufferedWriter.write:(Ljava/lang/String;)V
        //   283: aload_1        
        //   284: ldc             2
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokevirtual   java/io/BufferedWriter.newLine:()V
        //   292: ldc             1
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: goto            121
        //   300: aload           4
        //   302: pop            
        //   303: ldc             2
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: ldc             1
        //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   313: goto            334
        //   316: astore          8
        //   318: aload           4
        //   320: pop            
        //   321: ldc             503
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: aload           8
        //   328: ldc             2
        //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   333: athrow         
        //   334: aload_1        
        //   335: ldc             2
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: invokevirtual   java/io/BufferedWriter.flush:()V
        //   343: ldc             1
        //   345: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   348: return         
        //   349: athrow         
        //   350: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 07 13 FD 00 65 07 00 B4 07 00 B6 FA 00 B2 4F 07 00 23 FA 00 11 FF 00 0E 00 00 00 01 07 00 23 FF 00 00 00 00 00 01 07 00 8D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  105    350    350    351    Ljava/lang/VirtualMachineError;
        //  105    308    316    334    Any
        //  316    326    316    334    Any
        //  0      349    349    350    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0121:
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
    
    public synchronized void loadFromXML(final InputStream inputStream) throws IOException, InvalidPropertiesFormatException {
        try {
            BytecodeManager.incBytecodes(3);
            final InputStream inputStream2 = Objects.requireNonNull(inputStream);
            BytecodeManager.incBytecodes(2);
            XmlSupport.load(this, inputStream2);
            BytecodeManager.incBytecodes(2);
            inputStream.close();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void storeToXML(final OutputStream outputStream, final String s) throws IOException {
        try {
            final String s2 = "UTF-8";
            BytecodeManager.incBytecodes(5);
            this.storeToXML(outputStream, s, s2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void storeToXML(final OutputStream outputStream, final String s, final String s2) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            final OutputStream outputStream2 = Objects.requireNonNull(outputStream);
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final String s3 = Objects.requireNonNull(s2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            XmlSupport.save(this, outputStream2, s, s3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getProperty(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final String value = super.get(s);
            BytecodeManager.incBytecodes(1);
            final boolean b = value instanceof String;
            BytecodeManager.incBytecodes(3);
            String s2;
            if (b) {
                s2 = value;
                BytecodeManager.incBytecodes(3);
            }
            else {
                s2 = null;
                BytecodeManager.incBytecodes(1);
            }
            final String s3 = s2;
            BytecodeManager.incBytecodes(1);
            final String s4 = s3;
            BytecodeManager.incBytecodes(2);
            String property = null;
            Label_0100: {
                if (s4 == null) {
                    final Properties defaults = this.defaults;
                    BytecodeManager.incBytecodes(3);
                    if (defaults != null) {
                        final Properties defaults2 = this.defaults;
                        BytecodeManager.incBytecodes(4);
                        property = defaults2.getProperty(s);
                        BytecodeManager.incBytecodes(1);
                        break Label_0100;
                    }
                }
                property = s3;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return property;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getProperty(final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(3);
            final String property = this.getProperty(s);
            BytecodeManager.incBytecodes(1);
            final String s3 = property;
            BytecodeManager.incBytecodes(2);
            String s4;
            if (s3 == null) {
                s4 = s2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                s4 = property;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return s4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<?> propertyNames() {
        try {
            BytecodeManager.incBytecodes(3);
            final Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
            BytecodeManager.incBytecodes(1);
            final Hashtable<String, Object> hashtable2 = hashtable;
            BytecodeManager.incBytecodes(3);
            this.enumerate(hashtable2);
            final Hashtable<String, Object> hashtable3 = hashtable;
            BytecodeManager.incBytecodes(2);
            final Enumeration<String> keys = hashtable3.keys();
            BytecodeManager.incBytecodes(1);
            return keys;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Set<String> stringPropertyNames() {
        try {
            BytecodeManager.incBytecodes(3);
            final Hashtable<String, String> hashtable = new Hashtable<String, String>();
            BytecodeManager.incBytecodes(1);
            final Hashtable<String, String> hashtable2 = hashtable;
            BytecodeManager.incBytecodes(3);
            this.enumerateStringProperties(hashtable2);
            final Hashtable<String, String> hashtable3 = hashtable;
            BytecodeManager.incBytecodes(2);
            final Set<String> keySet = hashtable3.keySet();
            BytecodeManager.incBytecodes(1);
            return keySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void list(final PrintStream printStream) {
        try {
            final String x = "-- listing properties --";
            BytecodeManager.incBytecodes(3);
            printStream.println(x);
            BytecodeManager.incBytecodes(3);
            final Hashtable<String, String> hashtable = new Hashtable<String, String>();
            BytecodeManager.incBytecodes(1);
            final Hashtable<String, String> hashtable2 = hashtable;
            BytecodeManager.incBytecodes(3);
            this.enumerate((Hashtable<String, Object>)hashtable2);
            final Hashtable<String, String> hashtable3 = hashtable;
            BytecodeManager.incBytecodes(2);
            final Enumeration<String> keys = hashtable3.keys();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Enumeration<String> enumeration = keys;
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = enumeration.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreElements) {
                    break;
                }
                final Enumeration<String> enumeration2 = keys;
                BytecodeManager.incBytecodes(2);
                final String s = enumeration2.nextElement();
                BytecodeManager.incBytecodes(2);
                final Hashtable<String, String> hashtable4 = hashtable;
                final String s2 = s;
                BytecodeManager.incBytecodes(3);
                String string = hashtable4.get(s2);
                BytecodeManager.incBytecodes(2);
                final String s3 = string;
                BytecodeManager.incBytecodes(2);
                final int length = s3.length();
                final int n = 40;
                BytecodeManager.incBytecodes(2);
                if (length > n) {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb = new StringBuilder();
                    final String s4 = string;
                    final int beginIndex = 0;
                    final int endIndex = 37;
                    BytecodeManager.incBytecodes(4);
                    final String substring = s4.substring(beginIndex, endIndex);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append = sb.append(substring);
                    final String str = "...";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str);
                    BytecodeManager.incBytecodes(1);
                    string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                final String str3 = "=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str3);
                final String str4 = string;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string2 = append5.toString();
                BytecodeManager.incBytecodes(1);
                printStream.println(string2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void list(final PrintWriter printWriter) {
        try {
            final String x = "-- listing properties --";
            BytecodeManager.incBytecodes(3);
            printWriter.println(x);
            BytecodeManager.incBytecodes(3);
            final Hashtable<String, String> hashtable = new Hashtable<String, String>();
            BytecodeManager.incBytecodes(1);
            final Hashtable<String, String> hashtable2 = hashtable;
            BytecodeManager.incBytecodes(3);
            this.enumerate((Hashtable<String, Object>)hashtable2);
            final Hashtable<String, String> hashtable3 = hashtable;
            BytecodeManager.incBytecodes(2);
            final Enumeration<String> keys = hashtable3.keys();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Enumeration<String> enumeration = keys;
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = enumeration.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreElements) {
                    break;
                }
                final Enumeration<String> enumeration2 = keys;
                BytecodeManager.incBytecodes(2);
                final String s = enumeration2.nextElement();
                BytecodeManager.incBytecodes(2);
                final Hashtable<String, String> hashtable4 = hashtable;
                final String s2 = s;
                BytecodeManager.incBytecodes(3);
                String string = hashtable4.get(s2);
                BytecodeManager.incBytecodes(2);
                final String s3 = string;
                BytecodeManager.incBytecodes(2);
                final int length = s3.length();
                final int n = 40;
                BytecodeManager.incBytecodes(2);
                if (length > n) {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb = new StringBuilder();
                    final String s4 = string;
                    final int beginIndex = 0;
                    final int endIndex = 37;
                    BytecodeManager.incBytecodes(4);
                    final String substring = s4.substring(beginIndex, endIndex);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append = sb.append(substring);
                    final String str = "...";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str);
                    BytecodeManager.incBytecodes(1);
                    string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                final String str3 = "=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str3);
                final String str4 = string;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string2 = append5.toString();
                BytecodeManager.incBytecodes(1);
                printWriter.println(string2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void enumerate(final Hashtable<String, Object> hashtable) {
        try {
            final Properties defaults = this.defaults;
            BytecodeManager.incBytecodes(3);
            if (defaults != null) {
                final Properties defaults2 = this.defaults;
                BytecodeManager.incBytecodes(4);
                defaults2.enumerate(hashtable);
            }
            BytecodeManager.incBytecodes(2);
            final Enumeration<Object> keys = ((Hashtable<Object, V>)this).keys();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Enumeration<Object> enumeration = keys;
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = enumeration.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreElements) {
                    break;
                }
                final Enumeration<String> enumeration2 = (Enumeration<String>)keys;
                BytecodeManager.incBytecodes(2);
                final String s = enumeration2.nextElement();
                BytecodeManager.incBytecodes(2);
                final String s2 = s;
                final String s3 = s;
                BytecodeManager.incBytecodes(5);
                final Object value = ((Hashtable<K, Object>)this).get(s3);
                BytecodeManager.incBytecodes(1);
                hashtable.put(s2, value);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void enumerateStringProperties(final Hashtable<String, String> hashtable) {
        try {
            final Properties defaults = this.defaults;
            BytecodeManager.incBytecodes(3);
            if (defaults != null) {
                final Properties defaults2 = this.defaults;
                BytecodeManager.incBytecodes(4);
                defaults2.enumerateStringProperties(hashtable);
            }
            BytecodeManager.incBytecodes(2);
            final Enumeration<String> keys = ((Hashtable<String, V>)this).keys();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Enumeration<String> enumeration = keys;
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = enumeration.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreElements) {
                    break;
                }
                final Enumeration<String> enumeration2 = keys;
                BytecodeManager.incBytecodes(2);
                final String nextElement = enumeration2.nextElement();
                BytecodeManager.incBytecodes(1);
                final String s = nextElement;
                BytecodeManager.incBytecodes(3);
                final Object value = ((Hashtable<K, Object>)this).get(s);
                BytecodeManager.incBytecodes(1);
                final boolean b = nextElement instanceof String;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final boolean b2 = value instanceof String;
                    BytecodeManager.incBytecodes(3);
                    if (b2) {
                        final String s2 = nextElement;
                        final String s3 = (String)value;
                        BytecodeManager.incBytecodes(6);
                        hashtable.put(s2, s3);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static char toHex(final int n) {
        try {
            final char c = Properties.hexDigit[n & 0xF];
            BytecodeManager.incBytecodes(6);
            return c;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            hexDigit = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
            BytecodeManager.incBytecodes(67);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    class LineReader
    {
        byte[] inByteBuf;
        char[] inCharBuf;
        char[] lineBuf;
        int inLimit;
        int inOff;
        InputStream inStream;
        Reader reader;
        
        public LineReader(final InputStream inStream) {
            try {
                BytecodeManager.incBytecodes(5);
                this.lineBuf = new char[1024];
                BytecodeManager.incBytecodes(3);
                this.inLimit = 0;
                BytecodeManager.incBytecodes(3);
                this.inOff = 0;
                BytecodeManager.incBytecodes(3);
                this.inStream = inStream;
                BytecodeManager.incBytecodes(3);
                this.inByteBuf = new byte[8192];
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public LineReader(final Reader reader) {
            try {
                BytecodeManager.incBytecodes(5);
                this.lineBuf = new char[1024];
                BytecodeManager.incBytecodes(3);
                this.inLimit = 0;
                BytecodeManager.incBytecodes(3);
                this.inOff = 0;
                BytecodeManager.incBytecodes(3);
                this.reader = reader;
                BytecodeManager.incBytecodes(3);
                this.inCharBuf = new char[8192];
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        int readLine() throws IOException {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                boolean b = true;
                BytecodeManager.incBytecodes(2);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int inOff = this.inOff;
                    final int inLimit = this.inLimit;
                    BytecodeManager.incBytecodes(5);
                    if (inOff >= inLimit) {
                        final InputStream inStream = this.inStream;
                        BytecodeManager.incBytecodes(4);
                        int inLimit2;
                        if (inStream == null) {
                            final Reader reader = this.reader;
                            final char[] inCharBuf = this.inCharBuf;
                            BytecodeManager.incBytecodes(5);
                            inLimit2 = reader.read(inCharBuf);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final InputStream inStream2 = this.inStream;
                            final byte[] inByteBuf = this.inByteBuf;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            inLimit2 = inStream2.read(inByteBuf);
                        }
                        this.inLimit = inLimit2;
                        BytecodeManager.incBytecodes(1);
                        this.inOff = 0;
                        BytecodeManager.incBytecodes(3);
                        final int inLimit3 = this.inLimit;
                        BytecodeManager.incBytecodes(3);
                        if (inLimit3 <= 0) {
                            final int n4 = n;
                            BytecodeManager.incBytecodes(2);
                            if (n4 != 0) {
                                final int n5 = n2;
                                BytecodeManager.incBytecodes(2);
                                if (n5 == 0) {
                                    final int n6 = n3;
                                    BytecodeManager.incBytecodes(2);
                                    if (n6 != 0) {
                                        --n;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final int n7 = n;
                                    BytecodeManager.incBytecodes(2);
                                    return n7;
                                }
                            }
                            final int n8 = -1;
                            BytecodeManager.incBytecodes(2);
                            return n8;
                        }
                    }
                    final InputStream inStream3 = this.inStream;
                    BytecodeManager.incBytecodes(3);
                    char c;
                    if (inStream3 != null) {
                        c = (char)(0xFF & this.inByteBuf[this.inOff++]);
                        BytecodeManager.incBytecodes(15);
                    }
                    else {
                        c = this.inCharBuf[this.inOff++];
                        BytecodeManager.incBytecodes(11);
                    }
                    final boolean b5 = b4;
                    BytecodeManager.incBytecodes(2);
                    if (b5) {
                        b4 = false;
                        BytecodeManager.incBytecodes(2);
                        final char c2 = c;
                        final int n9 = '\n';
                        BytecodeManager.incBytecodes(3);
                        if (c2 == n9) {
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                    }
                    final boolean b6 = b;
                    BytecodeManager.incBytecodes(2);
                    if (b6) {
                        final char c3 = c;
                        final int n10 = ' ';
                        BytecodeManager.incBytecodes(3);
                        if (c3 == n10) {
                            continue;
                        }
                        final char c4 = c;
                        final int n11 = '\t';
                        BytecodeManager.incBytecodes(3);
                        if (c4 == n11) {
                            continue;
                        }
                        final char c5 = c;
                        final int n12 = '\f';
                        BytecodeManager.incBytecodes(3);
                        if (c5 == n12) {
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        final boolean b7 = b3;
                        BytecodeManager.incBytecodes(2);
                        if (!b7) {
                            final char c6 = c;
                            final int n13 = '\r';
                            BytecodeManager.incBytecodes(3);
                            if (c6 == n13) {
                                continue;
                            }
                            final char c7 = c;
                            final int n14 = '\n';
                            BytecodeManager.incBytecodes(3);
                            if (c7 == n14) {
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        b = false;
                        BytecodeManager.incBytecodes(2);
                        b3 = false;
                        BytecodeManager.incBytecodes(2);
                    }
                    final boolean b8 = b2;
                    BytecodeManager.incBytecodes(2);
                    Label_0478: {
                        if (b8) {
                            b2 = false;
                            BytecodeManager.incBytecodes(2);
                            final char c8 = c;
                            final int n15 = '#';
                            BytecodeManager.incBytecodes(3);
                            if (c8 != n15) {
                                final char c9 = c;
                                final int n16 = '!';
                                BytecodeManager.incBytecodes(3);
                                if (c9 != n16) {
                                    break Label_0478;
                                }
                            }
                            n2 = 1;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                    }
                    final char c10 = c;
                    final int n17 = '\n';
                    BytecodeManager.incBytecodes(3);
                    if (c10 != n17) {
                        final char c11 = c;
                        final int n18 = '\r';
                        BytecodeManager.incBytecodes(3);
                        if (c11 != n18) {
                            this.lineBuf[n++] = c;
                            BytecodeManager.incBytecodes(6);
                            final int n19 = n;
                            final int length = this.lineBuf.length;
                            BytecodeManager.incBytecodes(5);
                            if (n19 == length) {
                                int n20 = this.lineBuf.length * 2;
                                BytecodeManager.incBytecodes(6);
                                final int n21 = n20;
                                BytecodeManager.incBytecodes(2);
                                if (n21 < 0) {
                                    n20 = Integer.MAX_VALUE;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final char[] lineBuf = new char[n20];
                                BytecodeManager.incBytecodes(2);
                                final char[] lineBuf2 = this.lineBuf;
                                final int n22 = 0;
                                final char[] array = lineBuf;
                                final int n23 = 0;
                                final int length2 = this.lineBuf.length;
                                BytecodeManager.incBytecodes(9);
                                System.arraycopy(lineBuf2, n22, array, n23, length2);
                                this.lineBuf = lineBuf;
                                BytecodeManager.incBytecodes(3);
                            }
                            final char c12 = c;
                            final int n24 = '\\';
                            BytecodeManager.incBytecodes(3);
                            if (c12 == n24) {
                                final int n25 = n3;
                                BytecodeManager.incBytecodes(2);
                                int n26;
                                if (n25 == 0) {
                                    n26 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    n26 = 0;
                                    BytecodeManager.incBytecodes(1);
                                }
                                n3 = n26;
                                BytecodeManager.incBytecodes(2);
                                continue;
                            }
                            n3 = 0;
                            BytecodeManager.incBytecodes(3);
                            continue;
                        }
                    }
                    final int n27 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n27 == 0) {
                        final int n28 = n;
                        BytecodeManager.incBytecodes(2);
                        if (n28 != 0) {
                            final int inOff2 = this.inOff;
                            final int inLimit4 = this.inLimit;
                            BytecodeManager.incBytecodes(5);
                            if (inOff2 >= inLimit4) {
                                final InputStream inStream4 = this.inStream;
                                BytecodeManager.incBytecodes(4);
                                int inLimit5;
                                if (inStream4 == null) {
                                    final Reader reader2 = this.reader;
                                    final char[] inCharBuf2 = this.inCharBuf;
                                    BytecodeManager.incBytecodes(4);
                                    BytecodeManager.incBytecodes(1);
                                    inLimit5 = reader2.read(inCharBuf2);
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final InputStream inStream5 = this.inStream;
                                    final byte[] inByteBuf2 = this.inByteBuf;
                                    BytecodeManager.incBytecodes(4);
                                    BytecodeManager.incBytecodes(1);
                                    inLimit5 = inStream5.read(inByteBuf2);
                                }
                                this.inLimit = inLimit5;
                                BytecodeManager.incBytecodes(1);
                                this.inOff = 0;
                                BytecodeManager.incBytecodes(3);
                                final int inLimit6 = this.inLimit;
                                BytecodeManager.incBytecodes(3);
                                if (inLimit6 <= 0) {
                                    final int n29 = n3;
                                    BytecodeManager.incBytecodes(2);
                                    if (n29 != 0) {
                                        --n;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final int n30 = n;
                                    BytecodeManager.incBytecodes(2);
                                    return n30;
                                }
                            }
                            final int n31 = n3;
                            BytecodeManager.incBytecodes(2);
                            if (n31 == 0) {
                                final int n32 = n;
                                BytecodeManager.incBytecodes(2);
                                return n32;
                            }
                            --n;
                            BytecodeManager.incBytecodes(1);
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            n3 = 0;
                            BytecodeManager.incBytecodes(2);
                            final char c13 = c;
                            final int n33 = '\r';
                            BytecodeManager.incBytecodes(3);
                            if (c13 == n33) {
                                b4 = true;
                                BytecodeManager.incBytecodes(3);
                                continue;
                            }
                            continue;
                        }
                    }
                    n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                    b = true;
                    BytecodeManager.incBytecodes(2);
                    n = 0;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class XmlSupport
    {
        private static final XmlPropertiesProvider PROVIDER;
        
        private XmlSupport() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static XmlPropertiesProvider loadProviderFromProperty(final ClassLoader p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     2: ldc             2
            //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     7: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
            //    10: astore_1       
            //    11: ldc             1
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: aload_1        
            //    17: ldc             2
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: ifnonnull       32
            //    25: aconst_null    
            //    26: ldc             2
            //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    31: areturn        
            //    32: aload_1        
            //    33: iconst_1       
            //    34: aload_0        
            //    35: ldc             4
            //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    40: invokestatic    java/lang/Class.forName:(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
            //    43: astore_2       
            //    44: ldc             1
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: aload_2        
            //    50: ldc             2
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
            //    58: checkcast       Lsun/util/spi/XmlPropertiesProvider;
            //    61: ldc             1
            //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    66: ldc             1
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: areturn        
            //    72: astore_2       
            //    73: ldc             501
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: new             Linstrumented/java/util/ServiceConfigurationError;
            //    81: dup            
            //    82: aconst_null    
            //    83: aload_2        
            //    84: ldc             5
            //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    89: invokespecial   instrumented/java/util/ServiceConfigurationError.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
            //    92: ldc             1
            //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    97: athrow         
            //    98: athrow         
            //    99: athrow         
            //    StackMapTable: 00 04 FC 00 20 07 00 2E 67 07 00 3D FF 00 19 00 00 00 01 07 00 1A FF 00 00 00 00 00 01 07 00 1E
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                              
            //  -----  -----  -----  -----  ----------------------------------
            //  32     99     99     100    Ljava/lang/VirtualMachineError;
            //  32     66     72     98     Ljava/lang/ClassNotFoundException;
            //  32     66     72     98     Ljava/lang/IllegalAccessException;
            //  32     66     72     98     Ljava/lang/InstantiationException;
            //  0      98     98     99     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0032:
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
        
        private static XmlPropertiesProvider loadProviderAsService(final ClassLoader classLoader) {
            try {
                final Class<XmlPropertiesProvider> clazz = XmlPropertiesProvider.class;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final ServiceLoader<XmlPropertiesProvider> load = ServiceLoader.load(clazz, classLoader);
                BytecodeManager.incBytecodes(1);
                final Iterator<XmlPropertiesProvider> iterator = load.iterator();
                BytecodeManager.incBytecodes(1);
                final Iterator<XmlPropertiesProvider> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                XmlPropertiesProvider xmlPropertiesProvider;
                if (hasNext) {
                    final Iterator<XmlPropertiesProvider> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    xmlPropertiesProvider = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    xmlPropertiesProvider = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return xmlPropertiesProvider;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static XmlPropertiesProvider loadProvider() {
            try {
                BytecodeManager.incBytecodes(3);
                final PrivilegedAction<XmlPropertiesProvider> action = new PrivilegedAction<XmlPropertiesProvider>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public XmlPropertiesProvider run() {
                        try {
                            BytecodeManager.incBytecodes(1);
                            final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                            BytecodeManager.incBytecodes(1);
                            final ClassLoader classLoader = systemClassLoader;
                            BytecodeManager.incBytecodes(2);
                            final XmlPropertiesProvider access$000 = XmlSupport.access$000(classLoader);
                            BytecodeManager.incBytecodes(1);
                            final XmlPropertiesProvider xmlPropertiesProvider = access$000;
                            BytecodeManager.incBytecodes(2);
                            if (xmlPropertiesProvider != null) {
                                final XmlPropertiesProvider xmlPropertiesProvider2 = access$000;
                                BytecodeManager.incBytecodes(2);
                                return xmlPropertiesProvider2;
                            }
                            final ClassLoader classLoader2 = systemClassLoader;
                            BytecodeManager.incBytecodes(2);
                            final XmlPropertiesProvider access$2 = XmlSupport.access$100(classLoader2);
                            BytecodeManager.incBytecodes(1);
                            final XmlPropertiesProvider xmlPropertiesProvider3 = access$2;
                            BytecodeManager.incBytecodes(2);
                            if (xmlPropertiesProvider3 != null) {
                                final XmlPropertiesProvider xmlPropertiesProvider4 = access$2;
                                BytecodeManager.incBytecodes(2);
                                return xmlPropertiesProvider4;
                            }
                            BytecodeManager.incBytecodes(3);
                            final BasicXmlPropertiesProvider basicXmlPropertiesProvider = new BasicXmlPropertiesProvider();
                            BytecodeManager.incBytecodes(1);
                            return (XmlPropertiesProvider)basicXmlPropertiesProvider;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                final XmlPropertiesProvider xmlPropertiesProvider = AccessController.doPrivileged((PrivilegedAction<XmlPropertiesProvider>)action);
                BytecodeManager.incBytecodes(2);
                return xmlPropertiesProvider;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static void load(final Properties properties, final InputStream inputStream) throws IOException, InvalidPropertiesFormatException {
            try {
                final XmlPropertiesProvider provider = XmlSupport.PROVIDER;
                BytecodeManager.incBytecodes(4);
                provider.load(properties, inputStream);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static void save(final Properties properties, final OutputStream outputStream, final String s, final String s2) throws IOException {
            try {
                final XmlPropertiesProvider provider = XmlSupport.PROVIDER;
                BytecodeManager.incBytecodes(6);
                provider.store(properties, outputStream, s, s2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ XmlPropertiesProvider access$000(final ClassLoader classLoader) {
            try {
                BytecodeManager.incBytecodes(2);
                final XmlPropertiesProvider loadProviderFromProperty = loadProviderFromProperty(classLoader);
                BytecodeManager.incBytecodes(1);
                return loadProviderFromProperty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ XmlPropertiesProvider access$100(final ClassLoader classLoader) {
            try {
                BytecodeManager.incBytecodes(2);
                final XmlPropertiesProvider loadProviderAsService = loadProviderAsService(classLoader);
                BytecodeManager.incBytecodes(1);
                return loadProviderAsService;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(1);
                PROVIDER = loadProvider();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
