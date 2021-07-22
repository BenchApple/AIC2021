// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.math.BigDecimal;
import instrumented.java.math.BigInteger;
import instrumented.java.util.regex.MatchResult;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.charset.CharsetDecoder;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.io.FileInputStream;
import java.io.File;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.Charset;
import java.io.InputStreamReader;
import java.io.InputStream;
import aic2021.engine.BytecodeManager;
import java.io.IOException;
import sun.misc.LRUCache;
import instrumented.java.util.regex.Pattern;
import instrumented.java.util.regex.Matcher;
import java.nio.CharBuffer;
import java.io.Closeable;
import java.util.Iterator;

public final class Scanner implements Iterator<String>, Closeable
{
    private CharBuffer buf;
    private static final int BUFFER_SIZE = 1024;
    private int position;
    private Matcher matcher;
    private Pattern delimPattern;
    private Pattern hasNextPattern;
    private int hasNextPosition;
    private String hasNextResult;
    private Readable source;
    private boolean sourceClosed;
    private boolean needInput;
    private boolean skipped;
    private int savedScannerPosition;
    private Object typeCache;
    private boolean matchValid;
    private boolean closed;
    private int radix;
    private int defaultRadix;
    private Locale locale;
    private LRUCache<String, Pattern> patternCache;
    private IOException lastException;
    private static Pattern WHITESPACE_PATTERN;
    private static Pattern FIND_ANY_PATTERN;
    private static Pattern NON_ASCII_DIGIT;
    private String groupSeparator;
    private String decimalSeparator;
    private String nanString;
    private String infinityString;
    private String positivePrefix;
    private String negativePrefix;
    private String positiveSuffix;
    private String negativeSuffix;
    private static volatile Pattern boolPattern;
    private static final String BOOLEAN_PATTERN = "true|false";
    private Pattern integerPattern;
    private String digits;
    private String non0Digit;
    private int SIMPLE_GROUP_INDEX;
    private static volatile Pattern separatorPattern;
    private static volatile Pattern linePattern;
    private static final String LINE_SEPARATOR_PATTERN = "\r\n|[\n\r\u2028\u2029\u0085]";
    private static final String LINE_PATTERN = ".*(\r\n|[\n\r\u2028\u2029\u0085])|.+$";
    private Pattern floatPattern;
    private Pattern decimalPattern;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private static Pattern boolPattern() {
        try {
            Pattern boolPattern = Scanner.boolPattern;
            BytecodeManager.incBytecodes(2);
            final Pattern pattern = boolPattern;
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                final String s = "true|false";
                final int n = 2;
                BytecodeManager.incBytecodes(3);
                boolPattern = (Scanner.boolPattern = Pattern.compile(s, n));
                BytecodeManager.incBytecodes(3);
            }
            final Pattern pattern2 = boolPattern;
            BytecodeManager.incBytecodes(2);
            return pattern2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String buildIntegerPatternString() {
        try {
            final String digits = this.digits;
            final int beginIndex = 0;
            final int radix = this.radix;
            BytecodeManager.incBytecodes(6);
            final String substring = digits.substring(beginIndex, radix);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "((?i)[";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String str2 = substring;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            final String str3 = "]|\\p{javaDigit})";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str3);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb2 = new StringBuilder();
            final String str4 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = sb2.append(str4);
            final String non0Digit = this.non0Digit;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append5 = append4.append(non0Digit);
            final String str5 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(str5);
            final String str6 = "?";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append7 = append6.append(str6);
            final String str7 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append8 = append7.append(str7);
            final String str8 = "?(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append9 = append8.append(str8);
            final String groupSeparator = this.groupSeparator;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append10 = append9.append(groupSeparator);
            final String str9 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append11 = append10.append(str9);
            final String str10 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append12 = append11.append(str10);
            final String str11 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append13 = append12.append(str11);
            final String str12 = ")+)";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append14 = append13.append(str12);
            BytecodeManager.incBytecodes(1);
            final String string2 = append14.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb3 = new StringBuilder();
            final String str13 = "((";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append15 = sb3.append(str13);
            final String str14 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append16 = append15.append(str14);
            final String str15 = "++)|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append17 = append16.append(str15);
            final String str16 = string2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append18 = append17.append(str16);
            final String str17 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append19 = append18.append(str17);
            BytecodeManager.incBytecodes(1);
            final String string3 = append19.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb4 = new StringBuilder();
            final String str18 = "([-+]?(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append20 = sb4.append(str18);
            final String str19 = string3;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append21 = append20.append(str19);
            final String str20 = "))";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append22 = append21.append(str20);
            BytecodeManager.incBytecodes(1);
            final String string4 = append22.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb5 = new StringBuilder();
            final String negativePrefix = this.negativePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append23 = sb5.append(negativePrefix);
            final String str21 = string3;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append24 = append23.append(str21);
            final String negativeSuffix = this.negativeSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append25 = append24.append(negativeSuffix);
            BytecodeManager.incBytecodes(1);
            final String string5 = append25.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb6 = new StringBuilder();
            final String positivePrefix = this.positivePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append26 = sb6.append(positivePrefix);
            final String str22 = string3;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append27 = append26.append(str22);
            final String positiveSuffix = this.positiveSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append28 = append27.append(positiveSuffix);
            BytecodeManager.incBytecodes(1);
            final String string6 = append28.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb7 = new StringBuilder();
            final String str23 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append29 = sb7.append(str23);
            final String str24 = string4;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append30 = append29.append(str24);
            final String str25 = ")|(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append31 = append30.append(str25);
            final String str26 = string6;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append32 = append31.append(str26);
            final String str27 = ")|(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append33 = append32.append(str27);
            final String str28 = string5;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append34 = append33.append(str28);
            final String str29 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append35 = append34.append(str29);
            BytecodeManager.incBytecodes(1);
            final String string7 = append35.toString();
            BytecodeManager.incBytecodes(1);
            return string7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Pattern integerPattern() {
        try {
            final Pattern integerPattern = this.integerPattern;
            BytecodeManager.incBytecodes(3);
            if (integerPattern == null) {
                final LRUCache<String, Pattern> patternCache = this.patternCache;
                BytecodeManager.incBytecodes(5);
                final String buildIntegerPatternString = this.buildIntegerPatternString();
                BytecodeManager.incBytecodes(1);
                this.integerPattern = (Pattern)patternCache.forName((Object)buildIntegerPatternString);
                BytecodeManager.incBytecodes(2);
            }
            final Pattern integerPattern2 = this.integerPattern;
            BytecodeManager.incBytecodes(3);
            return integerPattern2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Pattern separatorPattern() {
        try {
            Pattern separatorPattern = Scanner.separatorPattern;
            BytecodeManager.incBytecodes(2);
            final Pattern pattern = separatorPattern;
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                final String s = "\r\n|[\n\r\u2028\u2029\u0085]";
                BytecodeManager.incBytecodes(2);
                separatorPattern = (Scanner.separatorPattern = Pattern.compile(s));
                BytecodeManager.incBytecodes(3);
            }
            final Pattern pattern2 = separatorPattern;
            BytecodeManager.incBytecodes(2);
            return pattern2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Pattern linePattern() {
        try {
            Pattern linePattern = Scanner.linePattern;
            BytecodeManager.incBytecodes(2);
            final Pattern pattern = linePattern;
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                final String s = ".*(\r\n|[\n\r\u2028\u2029\u0085])|.+$";
                BytecodeManager.incBytecodes(2);
                linePattern = (Scanner.linePattern = Pattern.compile(s));
                BytecodeManager.incBytecodes(3);
            }
            final Pattern pattern2 = linePattern;
            BytecodeManager.incBytecodes(2);
            return pattern2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void buildFloatAndDecimalPattern() {
        try {
            final String s = "([0-9]|(\\p{javaDigit}))";
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "([eE][+-]?";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String str2 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            final String str3 = "+)?";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str3);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb2 = new StringBuilder();
            final String str4 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = sb2.append(str4);
            final String non0Digit = this.non0Digit;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append5 = append4.append(non0Digit);
            final String str5 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(str5);
            final String str6 = "?";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append7 = append6.append(str6);
            final String str7 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append8 = append7.append(str7);
            final String str8 = "?(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append9 = append8.append(str8);
            final String groupSeparator = this.groupSeparator;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append10 = append9.append(groupSeparator);
            final String str9 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append11 = append10.append(str9);
            final String str10 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append12 = append11.append(str10);
            final String str11 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append13 = append12.append(str11);
            final String str12 = ")+)";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append14 = append13.append(str12);
            BytecodeManager.incBytecodes(1);
            final String string2 = append14.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb3 = new StringBuilder();
            final String str13 = "((";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append15 = sb3.append(str13);
            final String str14 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append16 = append15.append(str14);
            final String str15 = "++)|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append17 = append16.append(str15);
            final String str16 = string2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append18 = append17.append(str16);
            final String str17 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append19 = append18.append(str17);
            BytecodeManager.incBytecodes(1);
            final String string3 = append19.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb4 = new StringBuilder();
            final String str18 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append20 = sb4.append(str18);
            final String str19 = string3;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append21 = append20.append(str19);
            final String str20 = "|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append22 = append21.append(str20);
            final String str21 = string3;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append23 = append22.append(str21);
            final String decimalSeparator = this.decimalSeparator;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append24 = append23.append(decimalSeparator);
            final String str22 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append25 = append24.append(str22);
            final String str23 = "*+|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append26 = append25.append(str23);
            final String decimalSeparator2 = this.decimalSeparator;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append27 = append26.append(decimalSeparator2);
            final String str24 = s;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append28 = append27.append(str24);
            final String str25 = "++)";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append29 = append28.append(str25);
            BytecodeManager.incBytecodes(1);
            final String string4 = append29.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb5 = new StringBuilder();
            final String str26 = "(NaN|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append30 = sb5.append(str26);
            final String nanString = this.nanString;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append31 = append30.append(nanString);
            final String str27 = "|Infinity|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append32 = append31.append(str27);
            final String infinityString = this.infinityString;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append33 = append32.append(infinityString);
            final String str28 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append34 = append33.append(str28);
            BytecodeManager.incBytecodes(1);
            final String string5 = append34.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb6 = new StringBuilder();
            final String str29 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append35 = sb6.append(str29);
            final String positivePrefix = this.positivePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append36 = append35.append(positivePrefix);
            final String str30 = string4;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append37 = append36.append(str30);
            final String positiveSuffix = this.positiveSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append38 = append37.append(positiveSuffix);
            final String str31 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append39 = append38.append(str31);
            final String str32 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append40 = append39.append(str32);
            BytecodeManager.incBytecodes(1);
            final String string6 = append40.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb7 = new StringBuilder();
            final String str33 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append41 = sb7.append(str33);
            final String negativePrefix = this.negativePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append42 = append41.append(negativePrefix);
            final String str34 = string4;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append43 = append42.append(str34);
            final String negativeSuffix = this.negativeSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append44 = append43.append(negativeSuffix);
            final String str35 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append45 = append44.append(str35);
            final String str36 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append46 = append45.append(str36);
            BytecodeManager.incBytecodes(1);
            final String string7 = append46.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb8 = new StringBuilder();
            final String str37 = "(([-+]?";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append47 = sb8.append(str37);
            final String str38 = string4;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append48 = append47.append(str38);
            final String str39 = string;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append49 = append48.append(str39);
            final String str40 = ")|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append50 = append49.append(str40);
            final String str41 = string6;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append51 = append50.append(str41);
            final String str42 = "|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append52 = append51.append(str42);
            final String str43 = string7;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append53 = append52.append(str43);
            final String str44 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append54 = append53.append(str44);
            BytecodeManager.incBytecodes(1);
            final String string8 = append54.toString();
            BytecodeManager.incBytecodes(1);
            final String s2 = "[-+]?0[xX][0-9a-fA-F]*\\.[0-9a-fA-F]+([pP][-+]?[0-9]+)?";
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb9 = new StringBuilder();
            final String str45 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append55 = sb9.append(str45);
            final String positivePrefix2 = this.positivePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append56 = append55.append(positivePrefix2);
            final String str46 = string5;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append57 = append56.append(str46);
            final String positiveSuffix2 = this.positiveSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append58 = append57.append(positiveSuffix2);
            final String str47 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append59 = append58.append(str47);
            BytecodeManager.incBytecodes(1);
            final String string9 = append59.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb10 = new StringBuilder();
            final String str48 = "(";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append60 = sb10.append(str48);
            final String negativePrefix2 = this.negativePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append61 = append60.append(negativePrefix2);
            final String str49 = string5;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append62 = append61.append(str49);
            final String negativeSuffix2 = this.negativeSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append63 = append62.append(negativeSuffix2);
            final String str50 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append64 = append63.append(str50);
            BytecodeManager.incBytecodes(1);
            final String string10 = append64.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb11 = new StringBuilder();
            final String str51 = "(([-+]?";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append65 = sb11.append(str51);
            final String str52 = string5;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append66 = append65.append(str52);
            final String str53 = ")|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append67 = append66.append(str53);
            final String str54 = string9;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append68 = append67.append(str54);
            final String str55 = "|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append69 = append68.append(str55);
            final String str56 = string10;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append70 = append69.append(str56);
            final String str57 = ")";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append71 = append70.append(str57);
            BytecodeManager.incBytecodes(1);
            final String string11 = append71.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb12 = new StringBuilder();
            final String str58 = string8;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append72 = sb12.append(str58);
            final String str59 = "|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append73 = append72.append(str59);
            final String str60 = s2;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append74 = append73.append(str60);
            final String str61 = "|";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append75 = append74.append(str61);
            final String str62 = string11;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append76 = append75.append(str62);
            BytecodeManager.incBytecodes(1);
            final String string12 = append76.toString();
            BytecodeManager.incBytecodes(1);
            this.floatPattern = Pattern.compile(string12);
            BytecodeManager.incBytecodes(1);
            final String s3 = string8;
            BytecodeManager.incBytecodes(3);
            this.decimalPattern = Pattern.compile(s3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Pattern floatPattern() {
        try {
            final Pattern floatPattern = this.floatPattern;
            BytecodeManager.incBytecodes(3);
            if (floatPattern == null) {
                BytecodeManager.incBytecodes(2);
                this.buildFloatAndDecimalPattern();
            }
            final Pattern floatPattern2 = this.floatPattern;
            BytecodeManager.incBytecodes(3);
            return floatPattern2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Pattern decimalPattern() {
        try {
            final Pattern decimalPattern = this.decimalPattern;
            BytecodeManager.incBytecodes(3);
            if (decimalPattern == null) {
                BytecodeManager.incBytecodes(2);
                this.buildFloatAndDecimalPattern();
            }
            final Pattern decimalPattern2 = this.decimalPattern;
            BytecodeManager.incBytecodes(3);
            return decimalPattern2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Scanner(final Readable source, final Pattern delimPattern) {
        try {
            BytecodeManager.incBytecodes(2);
            this.sourceClosed = false;
            BytecodeManager.incBytecodes(3);
            this.needInput = false;
            BytecodeManager.incBytecodes(3);
            this.skipped = false;
            BytecodeManager.incBytecodes(3);
            this.savedScannerPosition = -1;
            BytecodeManager.incBytecodes(3);
            this.typeCache = null;
            BytecodeManager.incBytecodes(3);
            this.matchValid = false;
            BytecodeManager.incBytecodes(3);
            this.closed = false;
            BytecodeManager.incBytecodes(3);
            this.radix = 10;
            BytecodeManager.incBytecodes(3);
            this.defaultRadix = 10;
            BytecodeManager.incBytecodes(3);
            this.locale = null;
            BytecodeManager.incBytecodes(3);
            final int n = 7;
            BytecodeManager.incBytecodes(6);
            this.patternCache = new LRUCache<String, Pattern>(n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                protected Pattern create(final String s) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        final Pattern compile = Pattern.compile(s);
                        BytecodeManager.incBytecodes(1);
                        return compile;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                protected boolean hasName(final Pattern pattern, final String anObject) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        final String pattern2 = pattern.pattern();
                        BytecodeManager.incBytecodes(2);
                        final boolean equals = pattern2.equals(anObject);
                        BytecodeManager.incBytecodes(1);
                        return equals;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            this.groupSeparator = "\\,";
            BytecodeManager.incBytecodes(3);
            this.decimalSeparator = "\\.";
            BytecodeManager.incBytecodes(3);
            this.nanString = "NaN";
            BytecodeManager.incBytecodes(3);
            this.infinityString = "Infinity";
            BytecodeManager.incBytecodes(3);
            this.positivePrefix = "";
            BytecodeManager.incBytecodes(3);
            this.negativePrefix = "\\-";
            BytecodeManager.incBytecodes(3);
            this.positiveSuffix = "";
            BytecodeManager.incBytecodes(3);
            this.negativeSuffix = "";
            BytecodeManager.incBytecodes(3);
            this.digits = "0123456789abcdefghijklmnopqrstuvwxyz";
            BytecodeManager.incBytecodes(3);
            this.non0Digit = "[\\p{javaDigit}&&[^0]]";
            BytecodeManager.incBytecodes(3);
            this.SIMPLE_GROUP_INDEX = 5;
            BytecodeManager.incBytecodes(3);
            final boolean $assertionsDisabled = Scanner.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                BytecodeManager.incBytecodes(2);
                if (source == null) {
                    final String detailMessage = "source should not be null";
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final boolean $assertionsDisabled2 = Scanner.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled2) {
                BytecodeManager.incBytecodes(2);
                if (delimPattern == null) {
                    final String detailMessage2 = "pattern should not be null";
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError2 = new AssertionError((Object)detailMessage2);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            this.source = source;
            BytecodeManager.incBytecodes(3);
            this.delimPattern = delimPattern;
            BytecodeManager.incBytecodes(3);
            final int capacity = 1024;
            BytecodeManager.incBytecodes(3);
            this.buf = CharBuffer.allocate(capacity);
            BytecodeManager.incBytecodes(1);
            final CharBuffer buf = this.buf;
            final int n2 = 0;
            BytecodeManager.incBytecodes(4);
            buf.limit(n2);
            BytecodeManager.incBytecodes(1);
            final Pattern delimPattern2 = this.delimPattern;
            final CharBuffer buf2 = this.buf;
            BytecodeManager.incBytecodes(6);
            this.matcher = delimPattern2.matcher(buf2);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher = this.matcher;
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            matcher.useTransparentBounds(b);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher2 = this.matcher;
            final boolean b2 = false;
            BytecodeManager.incBytecodes(4);
            matcher2.useAnchoringBounds(b2);
            BytecodeManager.incBytecodes(1);
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this.useLocale(default1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final Readable readable) {
        try {
            final String s = "source";
            BytecodeManager.incBytecodes(4);
            final Readable readable2 = Objects.requireNonNull(readable, s);
            final Pattern whitespace_PATTERN = Scanner.WHITESPACE_PATTERN;
            BytecodeManager.incBytecodes(3);
            this(readable2, whitespace_PATTERN);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final InputStream in) {
        try {
            BytecodeManager.incBytecodes(5);
            final InputStreamReader inputStreamReader = new InputStreamReader(in);
            final Pattern whitespace_PATTERN = Scanner.WHITESPACE_PATTERN;
            BytecodeManager.incBytecodes(2);
            this(inputStreamReader, whitespace_PATTERN);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final InputStream inputStream, final String s) {
        try {
            final String s2 = "source";
            BytecodeManager.incBytecodes(4);
            final InputStream inputStream2 = Objects.requireNonNull(inputStream, s2);
            BytecodeManager.incBytecodes(3);
            final Charset charset = toCharset(s);
            BytecodeManager.incBytecodes(1);
            final Readable readable = makeReadable(inputStream2, charset);
            final Pattern whitespace_PATTERN = Scanner.WHITESPACE_PATTERN;
            BytecodeManager.incBytecodes(2);
            this(readable, whitespace_PATTERN);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Charset toCharset(final String s) {
        try {
            final String s2 = "charsetName";
            BytecodeManager.incBytecodes(3);
            Objects.requireNonNull(s, s2);
            BytecodeManager.incBytecodes(1);
            try {
                final String s3 = s;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final Charset charset = Charset.forName(s3);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                return charset;
            }
            catch (IllegalCharsetNameException | UnsupportedCharsetException ex2) {
                final Object o;
                final Throwable t = (Throwable)o;
                BytecodeManager.incBytecodes(501);
                final Throwable cause = t;
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(cause);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
        }
        finally {}
        try {
            final String s3 = s;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            final Charset charset = Charset.forName(s3);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            return charset;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static Readable makeReadable(final InputStream in, final Charset cs) {
        try {
            BytecodeManager.incBytecodes(5);
            final InputStreamReader inputStreamReader = new InputStreamReader(in, cs);
            BytecodeManager.incBytecodes(1);
            return inputStreamReader;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final File file) throws FileNotFoundException {
        try {
            BytecodeManager.incBytecodes(5);
            final FileInputStream fileInputStream = new FileInputStream(file);
            BytecodeManager.incBytecodes(1);
            final FileChannel channel = fileInputStream.getChannel();
            BytecodeManager.incBytecodes(1);
            this(channel);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final File file, final String s) throws FileNotFoundException {
        try {
            BytecodeManager.incBytecodes(3);
            final File file2 = Objects.requireNonNull(file);
            BytecodeManager.incBytecodes(3);
            final CharsetDecoder decoder = toDecoder(s);
            BytecodeManager.incBytecodes(1);
            this(file2, decoder);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Scanner(final File file, final CharsetDecoder charsetDecoder) throws FileNotFoundException {
        try {
            BytecodeManager.incBytecodes(5);
            final FileInputStream fileInputStream = new FileInputStream(file);
            BytecodeManager.incBytecodes(1);
            final FileChannel channel = fileInputStream.getChannel();
            BytecodeManager.incBytecodes(2);
            final Readable readable = makeReadable(channel, charsetDecoder);
            BytecodeManager.incBytecodes(1);
            this(readable);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static CharsetDecoder toDecoder(final String s) {
        try {
            final String s2 = "charsetName";
            BytecodeManager.incBytecodes(3);
            Objects.requireNonNull(s, s2);
            BytecodeManager.incBytecodes(1);
            try {
                final String s3 = s;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final Charset charset = Charset.forName(s3);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final CharsetDecoder charsetDecoder = charset.newDecoder();
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return charsetDecoder;
            }
            catch (IllegalCharsetNameException | UnsupportedCharsetException ex2) {
                BytecodeManager.incBytecodes(501);
                final String s4 = s;
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s4);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
        }
        finally {}
        try {
            final String s3 = s;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            final Charset charset = Charset.forName(s3);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            final CharsetDecoder charsetDecoder = charset.newDecoder();
            final int n3 = 1;
            BytecodeManager.incBytecodes(n3);
            return charsetDecoder;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static Readable makeReadable(final ReadableByteChannel ch, final CharsetDecoder dec) {
        try {
            final int minBufferCap = -1;
            BytecodeManager.incBytecodes(4);
            final Reader reader = Channels.newReader(ch, dec, minBufferCap);
            BytecodeManager.incBytecodes(1);
            return reader;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final Path path) throws IOException {
        try {
            final OpenOption[] options = new OpenOption[0];
            BytecodeManager.incBytecodes(4);
            final InputStream inputStream = Files.newInputStream(path, options);
            BytecodeManager.incBytecodes(1);
            this(inputStream);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final Path path, final String s) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            final Path path2 = Objects.requireNonNull(path);
            BytecodeManager.incBytecodes(3);
            final Charset charset = toCharset(s);
            BytecodeManager.incBytecodes(1);
            this(path2, charset);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Scanner(final Path path, final Charset charset) throws IOException {
        try {
            final OpenOption[] options = new OpenOption[0];
            BytecodeManager.incBytecodes(4);
            final InputStream inputStream = Files.newInputStream(path, options);
            BytecodeManager.incBytecodes(2);
            final Readable readable = makeReadable(inputStream, charset);
            BytecodeManager.incBytecodes(1);
            this(readable);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final String s) {
        try {
            BytecodeManager.incBytecodes(5);
            final StringReader stringReader = new StringReader(s);
            final Pattern whitespace_PATTERN = Scanner.WHITESPACE_PATTERN;
            BytecodeManager.incBytecodes(2);
            this(stringReader, whitespace_PATTERN);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final ReadableByteChannel readableByteChannel) {
        try {
            final String s = "source";
            BytecodeManager.incBytecodes(4);
            final ReadableByteChannel readableByteChannel2 = Objects.requireNonNull(readableByteChannel, s);
            BytecodeManager.incBytecodes(2);
            final Readable readable = makeReadable(readableByteChannel2);
            final Pattern whitespace_PATTERN = Scanner.WHITESPACE_PATTERN;
            BytecodeManager.incBytecodes(2);
            this(readable, whitespace_PATTERN);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Readable makeReadable(final ReadableByteChannel readableByteChannel) {
        try {
            BytecodeManager.incBytecodes(2);
            final Charset defaultCharset = Charset.defaultCharset();
            BytecodeManager.incBytecodes(1);
            final CharsetDecoder decoder = defaultCharset.newDecoder();
            BytecodeManager.incBytecodes(1);
            final Readable readable = makeReadable(readableByteChannel, decoder);
            BytecodeManager.incBytecodes(1);
            return readable;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner(final ReadableByteChannel readableByteChannel, final String s) {
        try {
            final String s2 = "source";
            BytecodeManager.incBytecodes(4);
            final ReadableByteChannel readableByteChannel2 = Objects.requireNonNull(readableByteChannel, s2);
            BytecodeManager.incBytecodes(3);
            final CharsetDecoder decoder = toDecoder(s);
            BytecodeManager.incBytecodes(1);
            final Readable readable = makeReadable(readableByteChannel2, decoder);
            final Pattern whitespace_PATTERN = Scanner.WHITESPACE_PATTERN;
            BytecodeManager.incBytecodes(2);
            this(readable, whitespace_PATTERN);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void saveState() {
        try {
            this.savedScannerPosition = this.position;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void revertState() {
        try {
            this.position = this.savedScannerPosition;
            BytecodeManager.incBytecodes(4);
            this.savedScannerPosition = -1;
            BytecodeManager.incBytecodes(3);
            this.skipped = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean revertState(final boolean b) {
        try {
            this.position = this.savedScannerPosition;
            BytecodeManager.incBytecodes(4);
            this.savedScannerPosition = -1;
            BytecodeManager.incBytecodes(3);
            this.skipped = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void cacheResult() {
        try {
            final Matcher matcher = this.matcher;
            BytecodeManager.incBytecodes(4);
            this.hasNextResult = matcher.group();
            BytecodeManager.incBytecodes(1);
            final Matcher matcher2 = this.matcher;
            BytecodeManager.incBytecodes(4);
            this.hasNextPosition = matcher2.end();
            BytecodeManager.incBytecodes(1);
            final Matcher matcher3 = this.matcher;
            BytecodeManager.incBytecodes(4);
            this.hasNextPattern = matcher3.pattern();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void cacheResult(final String hasNextResult) {
        try {
            this.hasNextResult = hasNextResult;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = this.matcher;
            BytecodeManager.incBytecodes(4);
            this.hasNextPosition = matcher.end();
            BytecodeManager.incBytecodes(1);
            final Matcher matcher2 = this.matcher;
            BytecodeManager.incBytecodes(4);
            this.hasNextPattern = matcher2.pattern();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void clearCaches() {
        try {
            this.hasNextPattern = null;
            BytecodeManager.incBytecodes(3);
            this.typeCache = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String getCachedResult() {
        try {
            this.position = this.hasNextPosition;
            BytecodeManager.incBytecodes(4);
            this.hasNextPattern = null;
            BytecodeManager.incBytecodes(3);
            this.typeCache = null;
            BytecodeManager.incBytecodes(3);
            final String hasNextResult = this.hasNextResult;
            BytecodeManager.incBytecodes(3);
            return hasNextResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void useTypeCache() {
        try {
            final boolean closed = this.closed;
            BytecodeManager.incBytecodes(3);
            if (closed) {
                final String s = "Scanner closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.position = this.hasNextPosition;
            BytecodeManager.incBytecodes(4);
            this.hasNextPattern = null;
            BytecodeManager.incBytecodes(3);
            this.typeCache = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readInput() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokevirtual   java/nio/CharBuffer.limit:()I
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokevirtual   java/nio/CharBuffer.capacity:()I
        //    24: ldc             1
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: if_icmpne       47
        //    32: aload_0        
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokespecial   instrumented/java/util/Scanner.makeSpace:()Z
        //    41: pop            
        //    42: ldc             1
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: aload_0        
        //    48: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //    51: ldc             3
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   java/nio/CharBuffer.position:()I
        //    59: istore_1       
        //    60: ldc             1
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: aload_0        
        //    66: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //    69: aload_0        
        //    70: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //    73: ldc             5
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokevirtual   java/nio/CharBuffer.limit:()I
        //    81: ldc             1
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: invokevirtual   java/nio/CharBuffer.position:(I)Ljava/nio/Buffer;
        //    89: pop            
        //    90: ldc             1
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: aload_0        
        //    96: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //    99: aload_0        
        //   100: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //   103: ldc             5
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: invokevirtual   java/nio/CharBuffer.capacity:()I
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokevirtual   java/nio/CharBuffer.limit:(I)Ljava/nio/Buffer;
        //   119: pop            
        //   120: ldc             1
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: iconst_0       
        //   126: istore_2       
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: aload_0        
        //   133: getfield        instrumented/java/util/Scanner.source:Ljava/lang/Readable;
        //   136: aload_0        
        //   137: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //   140: ldc             5
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokeinterface java/lang/Readable.read:(Ljava/nio/CharBuffer;)I
        //   150: istore_2       
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: ldc             1
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: goto            188
        //   164: astore_3       
        //   165: ldc_w           501
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: aload_0        
        //   172: aload_3        
        //   173: putfield        instrumented/java/util/Scanner.lastException:Ljava/io/IOException;
        //   176: ldc             3
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: iconst_m1      
        //   182: istore_2       
        //   183: ldc             2
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: iload_2        
        //   189: iconst_m1      
        //   190: ldc             3
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: if_icmpne       218
        //   198: aload_0        
        //   199: iconst_1       
        //   200: putfield        instrumented/java/util/Scanner.sourceClosed:Z
        //   203: ldc             3
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: aload_0        
        //   209: iconst_0       
        //   210: putfield        instrumented/java/util/Scanner.needInput:Z
        //   213: ldc             3
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: iload_2        
        //   219: ldc             2
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: ifle            237
        //   227: aload_0        
        //   228: iconst_0       
        //   229: putfield        instrumented/java/util/Scanner.needInput:Z
        //   232: ldc             3
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: aload_0        
        //   238: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //   241: aload_0        
        //   242: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //   245: ldc             5
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: invokevirtual   java/nio/CharBuffer.position:()I
        //   253: ldc             1
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokevirtual   java/nio/CharBuffer.limit:(I)Ljava/nio/Buffer;
        //   261: pop            
        //   262: ldc             1
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: aload_0        
        //   268: getfield        instrumented/java/util/Scanner.buf:Ljava/nio/CharBuffer;
        //   271: iload_1        
        //   272: ldc             4
        //   274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   277: invokevirtual   java/nio/CharBuffer.position:(I)Ljava/nio/Buffer;
        //   280: pop            
        //   281: ldc             1
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: ldc             1
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: return         
        //   292: athrow         
        //   293: athrow         
        //    StackMapTable: 00 07 2F FF 00 74 00 03 07 00 02 01 01 00 01 07 01 9B 17 1D 12 FF 00 36 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  132    293    293    294    Ljava/lang/VirtualMachineError;
        //  132    156    164    188    Ljava/io/IOException;
        //  0      292    292    293    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0188:
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
    
    private boolean makeSpace() {
        try {
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            final int savedScannerPosition = this.savedScannerPosition;
            final int n = -1;
            BytecodeManager.incBytecodes(4);
            int n2;
            if (savedScannerPosition == n) {
                n2 = this.position;
                BytecodeManager.incBytecodes(3);
            }
            else {
                n2 = this.savedScannerPosition;
                BytecodeManager.incBytecodes(2);
            }
            final int n3 = n2;
            BytecodeManager.incBytecodes(1);
            final CharBuffer buf = this.buf;
            final int n4 = n3;
            BytecodeManager.incBytecodes(4);
            buf.position(n4);
            BytecodeManager.incBytecodes(1);
            final int n5 = n3;
            BytecodeManager.incBytecodes(2);
            if (n5 > 0) {
                final CharBuffer buf2 = this.buf;
                BytecodeManager.incBytecodes(3);
                buf2.compact();
                BytecodeManager.incBytecodes(1);
                final int n6 = n3;
                BytecodeManager.incBytecodes(3);
                this.translateSavedIndexes(n6);
                this.position -= n3;
                BytecodeManager.incBytecodes(6);
                final CharBuffer buf3 = this.buf;
                BytecodeManager.incBytecodes(3);
                buf3.flip();
                BytecodeManager.incBytecodes(1);
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final CharBuffer buf4 = this.buf;
            BytecodeManager.incBytecodes(3);
            final int n7 = buf4.capacity() * 2;
            BytecodeManager.incBytecodes(3);
            final int capacity = n7;
            BytecodeManager.incBytecodes(2);
            final CharBuffer allocate = CharBuffer.allocate(capacity);
            BytecodeManager.incBytecodes(1);
            final CharBuffer charBuffer = allocate;
            final CharBuffer buf5 = this.buf;
            BytecodeManager.incBytecodes(4);
            charBuffer.put(buf5);
            BytecodeManager.incBytecodes(1);
            final CharBuffer charBuffer2 = allocate;
            BytecodeManager.incBytecodes(2);
            charBuffer2.flip();
            BytecodeManager.incBytecodes(1);
            final int n8 = n3;
            BytecodeManager.incBytecodes(3);
            this.translateSavedIndexes(n8);
            this.position -= n3;
            BytecodeManager.incBytecodes(6);
            this.buf = allocate;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = this.matcher;
            final CharBuffer buf6 = this.buf;
            BytecodeManager.incBytecodes(5);
            matcher.reset(buf6);
            BytecodeManager.incBytecodes(1);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void translateSavedIndexes(final int n) {
        try {
            final int savedScannerPosition = this.savedScannerPosition;
            final int n2 = -1;
            BytecodeManager.incBytecodes(4);
            if (savedScannerPosition != n2) {
                this.savedScannerPosition -= n;
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void throwFor() {
        try {
            this.skipped = false;
            BytecodeManager.incBytecodes(3);
            final boolean sourceClosed = this.sourceClosed;
            BytecodeManager.incBytecodes(3);
            if (sourceClosed) {
                final int position = this.position;
                final CharBuffer buf = this.buf;
                BytecodeManager.incBytecodes(5);
                final int limit = buf.limit();
                BytecodeManager.incBytecodes(1);
                if (position == limit) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            BytecodeManager.incBytecodes(3);
            final InputMismatchException ex2 = new InputMismatchException();
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean hasTokenInBuffer() {
        try {
            this.matchValid = false;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = this.matcher;
            final Pattern delimPattern = this.delimPattern;
            BytecodeManager.incBytecodes(5);
            matcher.usePattern(delimPattern);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher2 = this.matcher;
            final int position = this.position;
            final CharBuffer buf = this.buf;
            BytecodeManager.incBytecodes(7);
            final int limit = buf.limit();
            BytecodeManager.incBytecodes(1);
            matcher2.region(position, limit);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher3 = this.matcher;
            BytecodeManager.incBytecodes(3);
            final boolean looking = matcher3.lookingAt();
            BytecodeManager.incBytecodes(1);
            if (looking) {
                final Matcher matcher4 = this.matcher;
                BytecodeManager.incBytecodes(4);
                this.position = matcher4.end();
                BytecodeManager.incBytecodes(1);
            }
            final int position2 = this.position;
            final CharBuffer buf2 = this.buf;
            BytecodeManager.incBytecodes(5);
            final int limit2 = buf2.limit();
            BytecodeManager.incBytecodes(1);
            if (position2 == limit2) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String getCompleteTokenInBuffer(Pattern pattern) {
        try {
            this.matchValid = false;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = this.matcher;
            final Pattern delimPattern = this.delimPattern;
            BytecodeManager.incBytecodes(5);
            matcher.usePattern(delimPattern);
            BytecodeManager.incBytecodes(1);
            final boolean skipped = this.skipped;
            BytecodeManager.incBytecodes(3);
            if (!skipped) {
                final Matcher matcher2 = this.matcher;
                final int position = this.position;
                final CharBuffer buf = this.buf;
                BytecodeManager.incBytecodes(7);
                final int limit = buf.limit();
                BytecodeManager.incBytecodes(1);
                matcher2.region(position, limit);
                BytecodeManager.incBytecodes(1);
                final Matcher matcher3 = this.matcher;
                BytecodeManager.incBytecodes(3);
                final boolean looking = matcher3.lookingAt();
                BytecodeManager.incBytecodes(1);
                if (looking) {
                    final Matcher matcher4 = this.matcher;
                    BytecodeManager.incBytecodes(3);
                    final boolean hitEnd = matcher4.hitEnd();
                    BytecodeManager.incBytecodes(1);
                    if (hitEnd) {
                        final boolean sourceClosed = this.sourceClosed;
                        BytecodeManager.incBytecodes(3);
                        if (!sourceClosed) {
                            this.needInput = true;
                            BytecodeManager.incBytecodes(3);
                            final String s = null;
                            BytecodeManager.incBytecodes(2);
                            return s;
                        }
                    }
                    this.skipped = true;
                    BytecodeManager.incBytecodes(3);
                    final Matcher matcher5 = this.matcher;
                    BytecodeManager.incBytecodes(4);
                    this.position = matcher5.end();
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int position2 = this.position;
            final CharBuffer buf2 = this.buf;
            BytecodeManager.incBytecodes(5);
            final int limit2 = buf2.limit();
            BytecodeManager.incBytecodes(1);
            if (position2 == limit2) {
                final boolean sourceClosed2 = this.sourceClosed;
                BytecodeManager.incBytecodes(3);
                if (sourceClosed2) {
                    final String s2 = null;
                    BytecodeManager.incBytecodes(2);
                    return s2;
                }
                this.needInput = true;
                BytecodeManager.incBytecodes(3);
                final String s3 = null;
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            else {
                final Matcher matcher6 = this.matcher;
                final int position3 = this.position;
                final CharBuffer buf3 = this.buf;
                BytecodeManager.incBytecodes(7);
                final int limit3 = buf3.limit();
                BytecodeManager.incBytecodes(1);
                matcher6.region(position3, limit3);
                BytecodeManager.incBytecodes(1);
                final Matcher matcher7 = this.matcher;
                BytecodeManager.incBytecodes(3);
                boolean b = matcher7.find();
                BytecodeManager.incBytecodes(1);
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                if (b2) {
                    final Matcher matcher8 = this.matcher;
                    BytecodeManager.incBytecodes(3);
                    final int end = matcher8.end();
                    final int position4 = this.position;
                    BytecodeManager.incBytecodes(3);
                    if (end == position4) {
                        final Matcher matcher9 = this.matcher;
                        BytecodeManager.incBytecodes(3);
                        b = matcher9.find();
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final boolean b3 = b;
                BytecodeManager.incBytecodes(2);
                if (b3) {
                    final Matcher matcher10 = this.matcher;
                    BytecodeManager.incBytecodes(3);
                    final boolean requireEnd = matcher10.requireEnd();
                    BytecodeManager.incBytecodes(1);
                    if (requireEnd) {
                        final boolean sourceClosed3 = this.sourceClosed;
                        BytecodeManager.incBytecodes(3);
                        if (!sourceClosed3) {
                            this.needInput = true;
                            BytecodeManager.incBytecodes(3);
                            final String s4 = null;
                            BytecodeManager.incBytecodes(2);
                            return s4;
                        }
                    }
                    final Matcher matcher11 = this.matcher;
                    BytecodeManager.incBytecodes(3);
                    final int start = matcher11.start();
                    BytecodeManager.incBytecodes(1);
                    final Pattern pattern2 = pattern;
                    BytecodeManager.incBytecodes(2);
                    if (pattern2 == null) {
                        pattern = Scanner.FIND_ANY_PATTERN;
                        BytecodeManager.incBytecodes(2);
                    }
                    final Matcher matcher12 = this.matcher;
                    final Pattern pattern3 = pattern;
                    BytecodeManager.incBytecodes(4);
                    matcher12.usePattern(pattern3);
                    BytecodeManager.incBytecodes(1);
                    final Matcher matcher13 = this.matcher;
                    final int position5 = this.position;
                    final int n = start;
                    BytecodeManager.incBytecodes(6);
                    matcher13.region(position5, n);
                    BytecodeManager.incBytecodes(1);
                    final Matcher matcher14 = this.matcher;
                    BytecodeManager.incBytecodes(3);
                    final boolean matches = matcher14.matches();
                    BytecodeManager.incBytecodes(1);
                    if (matches) {
                        final Matcher matcher15 = this.matcher;
                        BytecodeManager.incBytecodes(3);
                        final String group = matcher15.group();
                        BytecodeManager.incBytecodes(1);
                        final Matcher matcher16 = this.matcher;
                        BytecodeManager.incBytecodes(4);
                        this.position = matcher16.end();
                        BytecodeManager.incBytecodes(1);
                        final String s5 = group;
                        BytecodeManager.incBytecodes(2);
                        return s5;
                    }
                    final String s6 = null;
                    BytecodeManager.incBytecodes(2);
                    return s6;
                }
                else {
                    final boolean sourceClosed4 = this.sourceClosed;
                    BytecodeManager.incBytecodes(3);
                    if (!sourceClosed4) {
                        this.needInput = true;
                        BytecodeManager.incBytecodes(3);
                        final String s7 = null;
                        BytecodeManager.incBytecodes(2);
                        return s7;
                    }
                    final Pattern pattern4 = pattern;
                    BytecodeManager.incBytecodes(2);
                    if (pattern4 == null) {
                        pattern = Scanner.FIND_ANY_PATTERN;
                        BytecodeManager.incBytecodes(2);
                    }
                    final Matcher matcher17 = this.matcher;
                    final Pattern pattern5 = pattern;
                    BytecodeManager.incBytecodes(4);
                    matcher17.usePattern(pattern5);
                    BytecodeManager.incBytecodes(1);
                    final Matcher matcher18 = this.matcher;
                    final int position6 = this.position;
                    final CharBuffer buf4 = this.buf;
                    BytecodeManager.incBytecodes(7);
                    final int limit4 = buf4.limit();
                    BytecodeManager.incBytecodes(1);
                    matcher18.region(position6, limit4);
                    BytecodeManager.incBytecodes(1);
                    final Matcher matcher19 = this.matcher;
                    BytecodeManager.incBytecodes(3);
                    final boolean matches2 = matcher19.matches();
                    BytecodeManager.incBytecodes(1);
                    if (matches2) {
                        final Matcher matcher20 = this.matcher;
                        BytecodeManager.incBytecodes(3);
                        final String group2 = matcher20.group();
                        BytecodeManager.incBytecodes(1);
                        final Matcher matcher21 = this.matcher;
                        BytecodeManager.incBytecodes(4);
                        this.position = matcher21.end();
                        BytecodeManager.incBytecodes(1);
                        final String s8 = group2;
                        BytecodeManager.incBytecodes(2);
                        return s8;
                    }
                    final String s9 = null;
                    BytecodeManager.incBytecodes(2);
                    return s9;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String findPatternInBuffer(final Pattern pattern, final int n) {
        try {
            this.matchValid = false;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = this.matcher;
            BytecodeManager.incBytecodes(4);
            matcher.usePattern(pattern);
            BytecodeManager.incBytecodes(1);
            final CharBuffer buf = this.buf;
            BytecodeManager.incBytecodes(3);
            final int limit = buf.limit();
            BytecodeManager.incBytecodes(1);
            int n2 = -1;
            BytecodeManager.incBytecodes(2);
            int n3 = limit;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                n2 = this.position + n;
                BytecodeManager.incBytecodes(5);
                final int n4 = n2;
                final int n5 = limit;
                BytecodeManager.incBytecodes(3);
                if (n4 < n5) {
                    n3 = n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final Matcher matcher2 = this.matcher;
            final int position = this.position;
            final int n6 = n3;
            BytecodeManager.incBytecodes(6);
            matcher2.region(position, n6);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher3 = this.matcher;
            BytecodeManager.incBytecodes(3);
            final boolean find = matcher3.find();
            BytecodeManager.incBytecodes(1);
            if (find) {
                final Matcher matcher4 = this.matcher;
                BytecodeManager.incBytecodes(3);
                final boolean hitEnd = matcher4.hitEnd();
                BytecodeManager.incBytecodes(1);
                if (hitEnd) {
                    final boolean sourceClosed = this.sourceClosed;
                    BytecodeManager.incBytecodes(3);
                    if (!sourceClosed) {
                        final int n7 = n3;
                        final int n8 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n7 != n8) {
                            this.needInput = true;
                            BytecodeManager.incBytecodes(3);
                            final String s = null;
                            BytecodeManager.incBytecodes(2);
                            return s;
                        }
                        final int n9 = n3;
                        final int n10 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n9 == n10) {
                            final Matcher matcher5 = this.matcher;
                            BytecodeManager.incBytecodes(3);
                            final boolean requireEnd = matcher5.requireEnd();
                            BytecodeManager.incBytecodes(1);
                            if (requireEnd) {
                                this.needInput = true;
                                BytecodeManager.incBytecodes(3);
                                final String s2 = null;
                                BytecodeManager.incBytecodes(2);
                                return s2;
                            }
                        }
                    }
                }
                final Matcher matcher6 = this.matcher;
                BytecodeManager.incBytecodes(4);
                this.position = matcher6.end();
                BytecodeManager.incBytecodes(1);
                final Matcher matcher7 = this.matcher;
                BytecodeManager.incBytecodes(3);
                final String group = matcher7.group();
                BytecodeManager.incBytecodes(1);
                return group;
            }
            final boolean sourceClosed2 = this.sourceClosed;
            BytecodeManager.incBytecodes(3);
            if (sourceClosed2) {
                final String s3 = null;
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            BytecodeManager.incBytecodes(2);
            Label_0348: {
                if (n != 0) {
                    final int n11 = n3;
                    final int n12 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n11 == n12) {
                        break Label_0348;
                    }
                }
                this.needInput = true;
                BytecodeManager.incBytecodes(3);
            }
            final String s4 = null;
            BytecodeManager.incBytecodes(2);
            return s4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String matchPatternInBuffer(final Pattern pattern) {
        try {
            this.matchValid = false;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = this.matcher;
            BytecodeManager.incBytecodes(4);
            matcher.usePattern(pattern);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher2 = this.matcher;
            final int position = this.position;
            final CharBuffer buf = this.buf;
            BytecodeManager.incBytecodes(7);
            final int limit = buf.limit();
            BytecodeManager.incBytecodes(1);
            matcher2.region(position, limit);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher3 = this.matcher;
            BytecodeManager.incBytecodes(3);
            final boolean looking = matcher3.lookingAt();
            BytecodeManager.incBytecodes(1);
            if (looking) {
                final Matcher matcher4 = this.matcher;
                BytecodeManager.incBytecodes(3);
                final boolean hitEnd = matcher4.hitEnd();
                BytecodeManager.incBytecodes(1);
                if (hitEnd) {
                    final boolean sourceClosed = this.sourceClosed;
                    BytecodeManager.incBytecodes(3);
                    if (!sourceClosed) {
                        this.needInput = true;
                        BytecodeManager.incBytecodes(3);
                        final String s = null;
                        BytecodeManager.incBytecodes(2);
                        return s;
                    }
                }
                final Matcher matcher5 = this.matcher;
                BytecodeManager.incBytecodes(4);
                this.position = matcher5.end();
                BytecodeManager.incBytecodes(1);
                final Matcher matcher6 = this.matcher;
                BytecodeManager.incBytecodes(3);
                final String group = matcher6.group();
                BytecodeManager.incBytecodes(1);
                return group;
            }
            final boolean sourceClosed2 = this.sourceClosed;
            BytecodeManager.incBytecodes(3);
            if (sourceClosed2) {
                final String s2 = null;
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            this.needInput = true;
            BytecodeManager.incBytecodes(3);
            final String s3 = null;
            BytecodeManager.incBytecodes(2);
            return s3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ensureOpen() {
        try {
            final boolean closed = this.closed;
            BytecodeManager.incBytecodes(3);
            if (closed) {
                final String s = "Scanner closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void close() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Scanner.closed:Z
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifeq            18
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: return         
        //    18: aload_0        
        //    19: getfield        instrumented/java/util/Scanner.source:Ljava/lang/Readable;
        //    22: instanceof      Ljava/io/Closeable;
        //    25: ldc             4
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifeq            75
        //    33: aload_0        
        //    34: getfield        instrumented/java/util/Scanner.source:Ljava/lang/Readable;
        //    37: checkcast       Ljava/io/Closeable;
        //    40: ldc             4
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: invokeinterface java/io/Closeable.close:()V
        //    50: ldc             1
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: goto            75
        //    58: astore_1       
        //    59: ldc_w           501
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: aload_0        
        //    66: aload_1        
        //    67: putfield        instrumented/java/util/Scanner.lastException:Ljava/io/IOException;
        //    70: ldc             3
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aload_0        
        //    76: iconst_1       
        //    77: putfield        instrumented/java/util/Scanner.sourceClosed:Z
        //    80: ldc             3
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: aload_0        
        //    86: aconst_null    
        //    87: putfield        instrumented/java/util/Scanner.source:Ljava/lang/Readable;
        //    90: ldc             3
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: aload_0        
        //    96: iconst_1       
        //    97: putfield        instrumented/java/util/Scanner.closed:Z
        //   100: ldc             3
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: return         
        //   111: athrow         
        //   112: athrow         
        //    StackMapTable: 00 05 12 67 07 01 9B 10 FF 00 23 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  33     112    112    113    Ljava/lang/VirtualMachineError;
        //  33     50     58     75     Ljava/io/IOException;
        //  0      111    111    112    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0075:
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
    
    public IOException ioException() {
        try {
            final IOException lastException = this.lastException;
            BytecodeManager.incBytecodes(3);
            return lastException;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Pattern delimiter() {
        try {
            final Pattern delimPattern = this.delimPattern;
            BytecodeManager.incBytecodes(3);
            return delimPattern;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner useDelimiter(final Pattern delimPattern) {
        try {
            this.delimPattern = delimPattern;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner useDelimiter(final String s) {
        try {
            final LRUCache<String, Pattern> patternCache = this.patternCache;
            BytecodeManager.incBytecodes(5);
            this.delimPattern = (Pattern)patternCache.forName((Object)s);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Locale locale() {
        try {
            final Locale locale = this.locale;
            BytecodeManager.incBytecodes(3);
            return locale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner useLocale(final Locale locale) {
        try {
            final Locale locale2 = this.locale;
            BytecodeManager.incBytecodes(4);
            final boolean equals = locale.equals(locale2);
            BytecodeManager.incBytecodes(1);
            if (equals) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            this.locale = locale;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(locale);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            final String str = "\\";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final DecimalFormatSymbols decimalFormatSymbols = instance;
            BytecodeManager.incBytecodes(2);
            final char groupingSeparator = decimalFormatSymbols.getGroupingSeparator();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(groupingSeparator);
            BytecodeManager.incBytecodes(1);
            this.groupSeparator = append2.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb2 = new StringBuilder();
            final String str2 = "\\";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = sb2.append(str2);
            final DecimalFormatSymbols decimalFormatSymbols2 = instance;
            BytecodeManager.incBytecodes(2);
            final char decimalSeparator = decimalFormatSymbols2.getDecimalSeparator();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append4 = append3.append(decimalSeparator);
            BytecodeManager.incBytecodes(1);
            this.decimalSeparator = append4.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb3 = new StringBuilder();
            final String str3 = "\\Q";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append5 = sb3.append(str3);
            final DecimalFormatSymbols decimalFormatSymbols3 = instance;
            BytecodeManager.incBytecodes(2);
            final String naN = decimalFormatSymbols3.getNaN();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append6 = append5.append(naN);
            final String str4 = "\\E";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append7 = append6.append(str4);
            BytecodeManager.incBytecodes(1);
            this.nanString = append7.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb4 = new StringBuilder();
            final String str5 = "\\Q";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append8 = sb4.append(str5);
            final DecimalFormatSymbols decimalFormatSymbols4 = instance;
            BytecodeManager.incBytecodes(2);
            final String infinity = decimalFormatSymbols4.getInfinity();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append9 = append8.append(infinity);
            final String str6 = "\\E";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append10 = append9.append(str6);
            BytecodeManager.incBytecodes(1);
            this.infinityString = append10.toString();
            BytecodeManager.incBytecodes(1);
            final DecimalFormat decimalFormat2 = decimalFormat;
            BytecodeManager.incBytecodes(3);
            this.positivePrefix = decimalFormat2.getPositivePrefix();
            BytecodeManager.incBytecodes(1);
            final String positivePrefix = this.positivePrefix;
            BytecodeManager.incBytecodes(3);
            final int length = positivePrefix.length();
            BytecodeManager.incBytecodes(1);
            if (length > 0) {
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb5 = new StringBuilder();
                final String str7 = "\\Q";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append11 = sb5.append(str7);
                final String positivePrefix2 = this.positivePrefix;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append12 = append11.append(positivePrefix2);
                final String str8 = "\\E";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append13 = append12.append(str8);
                BytecodeManager.incBytecodes(1);
                this.positivePrefix = append13.toString();
                BytecodeManager.incBytecodes(1);
            }
            final DecimalFormat decimalFormat3 = decimalFormat;
            BytecodeManager.incBytecodes(3);
            this.negativePrefix = decimalFormat3.getNegativePrefix();
            BytecodeManager.incBytecodes(1);
            final String negativePrefix = this.negativePrefix;
            BytecodeManager.incBytecodes(3);
            final int length2 = negativePrefix.length();
            BytecodeManager.incBytecodes(1);
            if (length2 > 0) {
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb6 = new StringBuilder();
                final String str9 = "\\Q";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append14 = sb6.append(str9);
                final String negativePrefix2 = this.negativePrefix;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append15 = append14.append(negativePrefix2);
                final String str10 = "\\E";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append16 = append15.append(str10);
                BytecodeManager.incBytecodes(1);
                this.negativePrefix = append16.toString();
                BytecodeManager.incBytecodes(1);
            }
            final DecimalFormat decimalFormat4 = decimalFormat;
            BytecodeManager.incBytecodes(3);
            this.positiveSuffix = decimalFormat4.getPositiveSuffix();
            BytecodeManager.incBytecodes(1);
            final String positiveSuffix = this.positiveSuffix;
            BytecodeManager.incBytecodes(3);
            final int length3 = positiveSuffix.length();
            BytecodeManager.incBytecodes(1);
            if (length3 > 0) {
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb7 = new StringBuilder();
                final String str11 = "\\Q";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append17 = sb7.append(str11);
                final String positiveSuffix2 = this.positiveSuffix;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append18 = append17.append(positiveSuffix2);
                final String str12 = "\\E";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append19 = append18.append(str12);
                BytecodeManager.incBytecodes(1);
                this.positiveSuffix = append19.toString();
                BytecodeManager.incBytecodes(1);
            }
            final DecimalFormat decimalFormat5 = decimalFormat;
            BytecodeManager.incBytecodes(3);
            this.negativeSuffix = decimalFormat5.getNegativeSuffix();
            BytecodeManager.incBytecodes(1);
            final String negativeSuffix = this.negativeSuffix;
            BytecodeManager.incBytecodes(3);
            final int length4 = negativeSuffix.length();
            BytecodeManager.incBytecodes(1);
            if (length4 > 0) {
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb8 = new StringBuilder();
                final String str13 = "\\Q";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append20 = sb8.append(str13);
                final String negativeSuffix2 = this.negativeSuffix;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append21 = append20.append(negativeSuffix2);
                final String str14 = "\\E";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append22 = append21.append(str14);
                BytecodeManager.incBytecodes(1);
                this.negativeSuffix = append22.toString();
                BytecodeManager.incBytecodes(1);
            }
            this.integerPattern = null;
            BytecodeManager.incBytecodes(3);
            this.floatPattern = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int radix() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(3);
            return defaultRadix;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner useRadix(final int n) {
        try {
            final int n2 = 2;
            BytecodeManager.incBytecodes(3);
            if (n >= n2) {
                final int n3 = 36;
                BytecodeManager.incBytecodes(3);
                if (n <= n3) {
                    final int defaultRadix = this.defaultRadix;
                    BytecodeManager.incBytecodes(4);
                    if (defaultRadix == n) {
                        BytecodeManager.incBytecodes(2);
                        return this;
                    }
                    this.defaultRadix = n;
                    BytecodeManager.incBytecodes(3);
                    this.integerPattern = null;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "radix:";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(n);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            final IllegalArgumentException ex = new IllegalArgumentException(string);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void setRadix(final int radix) {
        try {
            final int radix2 = this.radix;
            BytecodeManager.incBytecodes(4);
            if (radix2 != radix) {
                this.integerPattern = null;
                BytecodeManager.incBytecodes(3);
                this.radix = radix;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public MatchResult match() {
        try {
            final boolean matchValid = this.matchValid;
            BytecodeManager.incBytecodes(3);
            if (!matchValid) {
                final String s = "No match result available";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Matcher matcher = this.matcher;
            BytecodeManager.incBytecodes(3);
            final MatchResult matchResult = matcher.toMatchResult();
            BytecodeManager.incBytecodes(1);
            return matchResult;
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
            final String str = "java.util.Scanner";
            BytecodeManager.incBytecodes(3);
            sb2.append(str);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb3 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb4 = new StringBuilder();
            final String str2 = "[delimiters=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb4.append(str2);
            final Pattern delimPattern = this.delimPattern;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(delimPattern);
            final String str3 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str3);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            sb3.append(string);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb5 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb6 = new StringBuilder();
            final String str4 = "[position=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = sb6.append(str4);
            final int position = this.position;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append5 = append4.append(position);
            final String str5 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(str5);
            BytecodeManager.incBytecodes(1);
            final String string2 = append6.toString();
            BytecodeManager.incBytecodes(1);
            sb5.append(string2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb7 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb8 = new StringBuilder();
            final String str6 = "[match valid=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append7 = sb8.append(str6);
            final boolean matchValid = this.matchValid;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append8 = append7.append(matchValid);
            final String str7 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append9 = append8.append(str7);
            BytecodeManager.incBytecodes(1);
            final String string3 = append9.toString();
            BytecodeManager.incBytecodes(1);
            sb7.append(string3);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb9 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb10 = new StringBuilder();
            final String str8 = "[need input=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append10 = sb10.append(str8);
            final boolean needInput = this.needInput;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append11 = append10.append(needInput);
            final String str9 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append12 = append11.append(str9);
            BytecodeManager.incBytecodes(1);
            final String string4 = append12.toString();
            BytecodeManager.incBytecodes(1);
            sb9.append(string4);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb11 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb12 = new StringBuilder();
            final String str10 = "[source closed=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append13 = sb12.append(str10);
            final boolean sourceClosed = this.sourceClosed;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append14 = append13.append(sourceClosed);
            final String str11 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append15 = append14.append(str11);
            BytecodeManager.incBytecodes(1);
            final String string5 = append15.toString();
            BytecodeManager.incBytecodes(1);
            sb11.append(string5);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb13 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb14 = new StringBuilder();
            final String str12 = "[skipped=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append16 = sb14.append(str12);
            final boolean skipped = this.skipped;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append17 = append16.append(skipped);
            final String str13 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append18 = append17.append(str13);
            BytecodeManager.incBytecodes(1);
            final String string6 = append18.toString();
            BytecodeManager.incBytecodes(1);
            sb13.append(string6);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb15 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb16 = new StringBuilder();
            final String str14 = "[group separator=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append19 = sb16.append(str14);
            final String groupSeparator = this.groupSeparator;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append20 = append19.append(groupSeparator);
            final String str15 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append21 = append20.append(str15);
            BytecodeManager.incBytecodes(1);
            final String string7 = append21.toString();
            BytecodeManager.incBytecodes(1);
            sb15.append(string7);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb17 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb18 = new StringBuilder();
            final String str16 = "[decimal separator=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append22 = sb18.append(str16);
            final String decimalSeparator = this.decimalSeparator;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append23 = append22.append(decimalSeparator);
            final String str17 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append24 = append23.append(str17);
            BytecodeManager.incBytecodes(1);
            final String string8 = append24.toString();
            BytecodeManager.incBytecodes(1);
            sb17.append(string8);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb19 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb20 = new StringBuilder();
            final String str18 = "[positive prefix=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append25 = sb20.append(str18);
            final String positivePrefix = this.positivePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append26 = append25.append(positivePrefix);
            final String str19 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append27 = append26.append(str19);
            BytecodeManager.incBytecodes(1);
            final String string9 = append27.toString();
            BytecodeManager.incBytecodes(1);
            sb19.append(string9);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb21 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb22 = new StringBuilder();
            final String str20 = "[negative prefix=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append28 = sb22.append(str20);
            final String negativePrefix = this.negativePrefix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append29 = append28.append(negativePrefix);
            final String str21 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append30 = append29.append(str21);
            BytecodeManager.incBytecodes(1);
            final String string10 = append30.toString();
            BytecodeManager.incBytecodes(1);
            sb21.append(string10);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb23 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb24 = new StringBuilder();
            final String str22 = "[positive suffix=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append31 = sb24.append(str22);
            final String positiveSuffix = this.positiveSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append32 = append31.append(positiveSuffix);
            final String str23 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append33 = append32.append(str23);
            BytecodeManager.incBytecodes(1);
            final String string11 = append33.toString();
            BytecodeManager.incBytecodes(1);
            sb23.append(string11);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb25 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb26 = new StringBuilder();
            final String str24 = "[negative suffix=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append34 = sb26.append(str24);
            final String negativeSuffix = this.negativeSuffix;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append35 = append34.append(negativeSuffix);
            final String str25 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append36 = append35.append(str25);
            BytecodeManager.incBytecodes(1);
            final String string12 = append36.toString();
            BytecodeManager.incBytecodes(1);
            sb25.append(string12);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb27 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb28 = new StringBuilder();
            final String str26 = "[NaN string=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append37 = sb28.append(str26);
            final String nanString = this.nanString;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append38 = append37.append(nanString);
            final String str27 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append39 = append38.append(str27);
            BytecodeManager.incBytecodes(1);
            final String string13 = append39.toString();
            BytecodeManager.incBytecodes(1);
            sb27.append(string13);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb29 = sb;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb30 = new StringBuilder();
            final String str28 = "[infinity string=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append40 = sb30.append(str28);
            final String infinityString = this.infinityString;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append41 = append40.append(infinityString);
            final String str29 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append42 = append41.append(str29);
            BytecodeManager.incBytecodes(1);
            final String string14 = append42.toString();
            BytecodeManager.incBytecodes(1);
            sb29.append(string14);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb31 = sb;
            BytecodeManager.incBytecodes(2);
            final String string15 = sb31.toString();
            BytecodeManager.incBytecodes(1);
            return string15;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean hasNext() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            this.saveState();
            while (true) {
                final boolean sourceClosed = this.sourceClosed;
                BytecodeManager.incBytecodes(3);
                if (sourceClosed) {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasTokenInBuffer = this.hasTokenInBuffer();
                    BytecodeManager.incBytecodes(1);
                    final boolean b = hasTokenInBuffer;
                    BytecodeManager.incBytecodes(3);
                    final boolean revertState = this.revertState(b);
                    BytecodeManager.incBytecodes(1);
                    return revertState;
                }
                BytecodeManager.incBytecodes(2);
                final boolean hasTokenInBuffer2 = this.hasTokenInBuffer();
                BytecodeManager.incBytecodes(1);
                if (hasTokenInBuffer2) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean revertState2 = this.revertState(b2);
                    BytecodeManager.incBytecodes(1);
                    return revertState2;
                }
                BytecodeManager.incBytecodes(2);
                this.readInput();
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String next() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            String completeTokenInBuffer;
            while (true) {
                final Pattern pattern = null;
                BytecodeManager.incBytecodes(3);
                completeTokenInBuffer = this.getCompleteTokenInBuffer(pattern);
                BytecodeManager.incBytecodes(1);
                final String s = completeTokenInBuffer;
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    break;
                }
                final boolean needInput = this.needInput;
                BytecodeManager.incBytecodes(3);
                if (needInput) {
                    BytecodeManager.incBytecodes(2);
                    this.readInput();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    this.throwFor();
                }
                BytecodeManager.incBytecodes(1);
            }
            this.matchValid = true;
            BytecodeManager.incBytecodes(3);
            this.skipped = false;
            BytecodeManager.incBytecodes(3);
            final String s2 = completeTokenInBuffer;
            BytecodeManager.incBytecodes(2);
            return s2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void remove() {
        try {
            BytecodeManager.incBytecodes(3);
            final UnsupportedOperationException ex = new UnsupportedOperationException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNext(final String s) {
        try {
            final LRUCache<String, Pattern> patternCache = this.patternCache;
            BytecodeManager.incBytecodes(5);
            final Pattern pattern = (Pattern)patternCache.forName((Object)s);
            BytecodeManager.incBytecodes(2);
            final boolean hasNext = this.hasNext(pattern);
            BytecodeManager.incBytecodes(1);
            return hasNext;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String next(final String s) {
        try {
            final LRUCache<String, Pattern> patternCache = this.patternCache;
            BytecodeManager.incBytecodes(5);
            final Pattern pattern = (Pattern)patternCache.forName((Object)s);
            BytecodeManager.incBytecodes(2);
            final String next = this.next(pattern);
            BytecodeManager.incBytecodes(1);
            return next;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNext(final Pattern pattern) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.hasNextPattern = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.saveState();
            while (true) {
                BytecodeManager.incBytecodes(3);
                final String completeTokenInBuffer = this.getCompleteTokenInBuffer(pattern);
                BytecodeManager.incBytecodes(1);
                if (completeTokenInBuffer != null) {
                    this.matchValid = true;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.cacheResult();
                    final boolean b = true;
                    BytecodeManager.incBytecodes(3);
                    final boolean revertState = this.revertState(b);
                    BytecodeManager.incBytecodes(1);
                    return revertState;
                }
                final boolean needInput = this.needInput;
                BytecodeManager.incBytecodes(3);
                if (!needInput) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(3);
                    final boolean revertState2 = this.revertState(b2);
                    BytecodeManager.incBytecodes(1);
                    return revertState2;
                }
                BytecodeManager.incBytecodes(2);
                this.readInput();
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String next(final Pattern pattern) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Pattern hasNextPattern = this.hasNextPattern;
            BytecodeManager.incBytecodes(4);
            if (hasNextPattern == pattern) {
                BytecodeManager.incBytecodes(2);
                final String cachedResult = this.getCachedResult();
                BytecodeManager.incBytecodes(1);
                return cachedResult;
            }
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            String completeTokenInBuffer;
            while (true) {
                BytecodeManager.incBytecodes(3);
                completeTokenInBuffer = this.getCompleteTokenInBuffer(pattern);
                BytecodeManager.incBytecodes(1);
                final String s = completeTokenInBuffer;
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    break;
                }
                final boolean needInput = this.needInput;
                BytecodeManager.incBytecodes(3);
                if (needInput) {
                    BytecodeManager.incBytecodes(2);
                    this.readInput();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    this.throwFor();
                }
                BytecodeManager.incBytecodes(1);
            }
            this.matchValid = true;
            BytecodeManager.incBytecodes(3);
            this.skipped = false;
            BytecodeManager.incBytecodes(3);
            final String s2 = completeTokenInBuffer;
            BytecodeManager.incBytecodes(2);
            return s2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextLine() {
        try {
            BytecodeManager.incBytecodes(2);
            this.saveState();
            BytecodeManager.incBytecodes(2);
            final Pattern linePattern = linePattern();
            final int n = 0;
            BytecodeManager.incBytecodes(2);
            String s = this.findWithinHorizon(linePattern, n);
            BytecodeManager.incBytecodes(1);
            final String s2 = s;
            BytecodeManager.incBytecodes(2);
            if (s2 != null) {
                BytecodeManager.incBytecodes(2);
                final MatchResult match = this.match();
                BytecodeManager.incBytecodes(1);
                final MatchResult matchResult = match;
                final int n2 = 1;
                BytecodeManager.incBytecodes(3);
                final String group = matchResult.group(n2);
                BytecodeManager.incBytecodes(1);
                final String s3 = group;
                BytecodeManager.incBytecodes(2);
                if (s3 != null) {
                    final String s4 = s;
                    final int beginIndex = 0;
                    final String s5 = s;
                    BytecodeManager.incBytecodes(4);
                    final int length = s5.length();
                    final String s6 = group;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int endIndex = length - s6.length();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    s = s4.substring(beginIndex, endIndex);
                    BytecodeManager.incBytecodes(1);
                    final String s7 = s;
                    BytecodeManager.incBytecodes(3);
                    this.cacheResult(s7);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    this.cacheResult();
                }
            }
            BytecodeManager.incBytecodes(2);
            this.revertState();
            final String s8 = s;
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (s8 != null) {
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
    
    public String nextLine() {
        try {
            final Pattern hasNextPattern = this.hasNextPattern;
            BytecodeManager.incBytecodes(3);
            final Pattern linePattern = linePattern();
            BytecodeManager.incBytecodes(1);
            if (hasNextPattern == linePattern) {
                BytecodeManager.incBytecodes(2);
                final String cachedResult = this.getCachedResult();
                BytecodeManager.incBytecodes(1);
                return cachedResult;
            }
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            final Pattern linePattern2 = Scanner.linePattern;
            final int n = 0;
            BytecodeManager.incBytecodes(4);
            String s = this.findWithinHorizon(linePattern2, n);
            BytecodeManager.incBytecodes(1);
            final String s2 = s;
            BytecodeManager.incBytecodes(2);
            if (s2 == null) {
                final String s3 = "No line found";
                BytecodeManager.incBytecodes(4);
                final NoSuchElementException ex = new NoSuchElementException(s3);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final MatchResult match = this.match();
            BytecodeManager.incBytecodes(1);
            final MatchResult matchResult = match;
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            final String group = matchResult.group(n2);
            BytecodeManager.incBytecodes(1);
            final String s4 = group;
            BytecodeManager.incBytecodes(2);
            if (s4 != null) {
                final String s5 = s;
                final int beginIndex = 0;
                final String s6 = s;
                BytecodeManager.incBytecodes(4);
                final int length = s6.length();
                final String s7 = group;
                BytecodeManager.incBytecodes(2);
                final int endIndex = length - s7.length();
                BytecodeManager.incBytecodes(2);
                s = s5.substring(beginIndex, endIndex);
                BytecodeManager.incBytecodes(1);
            }
            final String s8 = s;
            BytecodeManager.incBytecodes(2);
            if (s8 == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex2 = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final String s9 = s;
            BytecodeManager.incBytecodes(2);
            return s9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String findInLine(final String s) {
        try {
            final LRUCache<String, Pattern> patternCache = this.patternCache;
            BytecodeManager.incBytecodes(5);
            final Pattern pattern = (Pattern)patternCache.forName((Object)s);
            BytecodeManager.incBytecodes(2);
            final String inLine = this.findInLine(pattern);
            BytecodeManager.incBytecodes(1);
            return inLine;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String findInLine(final Pattern pattern) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            this.saveState();
            int n2;
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Pattern separatorPattern = separatorPattern();
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                final String patternInBuffer = this.findPatternInBuffer(separatorPattern, n);
                BytecodeManager.incBytecodes(1);
                final String s = patternInBuffer;
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    final Matcher matcher = this.matcher;
                    BytecodeManager.incBytecodes(3);
                    n2 = matcher.start();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final boolean needInput = this.needInput;
                BytecodeManager.incBytecodes(3);
                if (!needInput) {
                    final CharBuffer buf = this.buf;
                    BytecodeManager.incBytecodes(3);
                    n2 = buf.limit();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                BytecodeManager.incBytecodes(2);
                this.readInput();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(2);
            this.revertState();
            final int n3 = n2 - this.position;
            BytecodeManager.incBytecodes(5);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 == 0) {
                final String s2 = null;
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            final int n5 = n3;
            BytecodeManager.incBytecodes(4);
            final String withinHorizon = this.findWithinHorizon(pattern, n5);
            BytecodeManager.incBytecodes(1);
            return withinHorizon;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String findWithinHorizon(final String s, final int n) {
        try {
            final LRUCache<String, Pattern> patternCache = this.patternCache;
            BytecodeManager.incBytecodes(5);
            final Pattern pattern = (Pattern)patternCache.forName((Object)s);
            BytecodeManager.incBytecodes(3);
            final String withinHorizon = this.findWithinHorizon(pattern, n);
            BytecodeManager.incBytecodes(1);
            return withinHorizon;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String findWithinHorizon(final Pattern pattern, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "horizon < 0";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            while (true) {
                BytecodeManager.incBytecodes(4);
                final String patternInBuffer = this.findPatternInBuffer(pattern, n);
                BytecodeManager.incBytecodes(1);
                final String s2 = patternInBuffer;
                BytecodeManager.incBytecodes(2);
                if (s2 != null) {
                    this.matchValid = true;
                    BytecodeManager.incBytecodes(3);
                    final String s3 = patternInBuffer;
                    BytecodeManager.incBytecodes(2);
                    return s3;
                }
                final boolean needInput = this.needInput;
                BytecodeManager.incBytecodes(3);
                if (!needInput) {
                    final String s4 = null;
                    BytecodeManager.incBytecodes(2);
                    return s4;
                }
                BytecodeManager.incBytecodes(2);
                this.readInput();
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner skip(final Pattern pattern) {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (pattern == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            while (true) {
                BytecodeManager.incBytecodes(3);
                final String matchPatternInBuffer = this.matchPatternInBuffer(pattern);
                BytecodeManager.incBytecodes(1);
                final String s = matchPatternInBuffer;
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    this.matchValid = true;
                    BytecodeManager.incBytecodes(3);
                    final Matcher matcher = this.matcher;
                    BytecodeManager.incBytecodes(4);
                    this.position = matcher.end();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                final boolean needInput = this.needInput;
                BytecodeManager.incBytecodes(3);
                if (!needInput) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex2 = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(2);
                this.readInput();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Scanner skip(final String s) {
        try {
            final LRUCache<String, Pattern> patternCache = this.patternCache;
            BytecodeManager.incBytecodes(5);
            final Pattern pattern = (Pattern)patternCache.forName((Object)s);
            BytecodeManager.incBytecodes(2);
            final Scanner skip = this.skip(pattern);
            BytecodeManager.incBytecodes(1);
            return skip;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextBoolean() {
        try {
            BytecodeManager.incBytecodes(2);
            final Pattern boolPattern = boolPattern();
            BytecodeManager.incBytecodes(1);
            final boolean hasNext = this.hasNext(boolPattern);
            BytecodeManager.incBytecodes(1);
            return hasNext;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean nextBoolean() {
        try {
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            BytecodeManager.incBytecodes(2);
            final Pattern boolPattern = boolPattern();
            BytecodeManager.incBytecodes(1);
            final String next = this.next(boolPattern);
            BytecodeManager.incBytecodes(1);
            final boolean boolean1 = Boolean.parseBoolean(next);
            BytecodeManager.incBytecodes(1);
            return boolean1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextByte() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final boolean hasNextByte = this.hasNextByte(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return hasNextByte;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextByte(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    10: aload_0        
        //    11: aload_0        
        //    12: ldc             3
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    28: istore_2       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: iload_2        
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ifeq            157
        //    43: aload_0        
        //    44: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //    47: aload_0        
        //    48: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //    51: ldc             5
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: ifnonnull       93
        //    67: aload_0        
        //    68: aload_0        
        //    69: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            102
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: astore_3       
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_0        
        //   109: aload_3        
        //   110: iload_1        
        //   111: ldc             4
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokestatic    java/lang/Byte.parseByte:(Ljava/lang/String;I)B
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokestatic    java/lang/Byte.valueOf:(B)Ljava/lang/Byte;
        //   127: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: goto            157
        //   143: astore_3       
        //   144: ldc_w           501
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: iconst_0       
        //   151: istore_2       
        //   152: ldc             2
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: iload_2        
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ireturn        
        //   164: athrow         
        //   165: athrow         
        //    StackMapTable: 00 06 FC 00 5D 01 48 07 00 6D 68 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  43     165    165    166    Ljava/lang/VirtualMachineError;
        //  43     135    143    157    Ljava/lang/NumberFormatException;
        //  0      164    164    165    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    public byte nextByte() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final byte nextByte = this.nextByte(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return nextByte;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public byte nextByte(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          77
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    16: instanceof      Ljava/lang/Byte;
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifeq            77
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/Scanner.radix:I
        //    31: iload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: if_icmpne       77
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    44: checkcast       Ljava/lang/Byte;
        //    47: ldc             4
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   java/lang/Byte.byteValue:()B
        //    55: istore_2       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_0        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   instrumented/java/util/Scanner.useTypeCache:()V
        //    70: iload_2        
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ireturn        
        //    77: aload_0        
        //    78: iload_1        
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    87: aload_0        
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokespecial   instrumented/java/util/Scanner.clearCaches:()V
        //    96: aload_0        
        //    97: aload_0        
        //    98: ldc             3
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/Scanner.next:(Linstrumented/java/util/regex/Pattern;)Ljava/lang/String;
        //   114: astore_2       
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: aload_0        
        //   121: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   124: aload_0        
        //   125: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //   128: ldc             5
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: ifnonnull       160
        //   144: aload_0        
        //   145: aload_2        
        //   146: ldc             3
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //   154: astore_2       
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: aload_2        
        //   161: iload_1        
        //   162: ldc             3
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokestatic    java/lang/Byte.parseByte:(Ljava/lang/String;I)B
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: ireturn        
        //   176: astore_2       
        //   177: ldc_w           501
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload_0        
        //   184: aload_0        
        //   185: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   188: ldc             4
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokevirtual   instrumented/java/util/regex/Matcher.start:()I
        //   196: putfield        instrumented/java/util/Scanner.position:I
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: new             Linstrumented/java/util/InputMismatchException;
        //   207: dup            
        //   208: aload_2        
        //   209: ldc             4
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokevirtual   java/lang/NumberFormatException.getMessage:()Ljava/lang/String;
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: invokespecial   instrumented/java/util/InputMismatchException.<init>:(Ljava/lang/String;)V
        //   225: ldc             1
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: athrow         
        //   231: athrow         
        //   232: athrow         
        //    StackMapTable: 00 05 FB 00 4D FC 00 52 07 00 6D FF 00 0F 00 02 07 00 02 01 00 01 07 02 F3 FF 00 36 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  96     232    232    233    Ljava/lang/VirtualMachineError;
        //  96     170    176    231    Ljava/lang/NumberFormatException;
        //  0      231    231    232    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0160:
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
    
    public boolean hasNextShort() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final boolean hasNextShort = this.hasNextShort(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return hasNextShort;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextShort(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    10: aload_0        
        //    11: aload_0        
        //    12: ldc             3
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    28: istore_2       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: iload_2        
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ifeq            157
        //    43: aload_0        
        //    44: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //    47: aload_0        
        //    48: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //    51: ldc             5
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: ifnonnull       93
        //    67: aload_0        
        //    68: aload_0        
        //    69: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            102
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: astore_3       
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_0        
        //   109: aload_3        
        //   110: iload_1        
        //   111: ldc             4
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokestatic    java/lang/Short.parseShort:(Ljava/lang/String;I)S
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokestatic    java/lang/Short.valueOf:(S)Ljava/lang/Short;
        //   127: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: goto            157
        //   143: astore_3       
        //   144: ldc_w           501
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: iconst_0       
        //   151: istore_2       
        //   152: ldc             2
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: iload_2        
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ireturn        
        //   164: athrow         
        //   165: athrow         
        //    StackMapTable: 00 06 FC 00 5D 01 48 07 00 6D 68 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  43     165    165    166    Ljava/lang/VirtualMachineError;
        //  43     135    143    157    Ljava/lang/NumberFormatException;
        //  0      164    164    165    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    public short nextShort() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final short nextShort = this.nextShort(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return nextShort;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public short nextShort(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          77
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    16: instanceof      Ljava/lang/Short;
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifeq            77
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/Scanner.radix:I
        //    31: iload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: if_icmpne       77
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    44: checkcast       Ljava/lang/Short;
        //    47: ldc             4
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   java/lang/Short.shortValue:()S
        //    55: istore_2       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_0        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   instrumented/java/util/Scanner.useTypeCache:()V
        //    70: iload_2        
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ireturn        
        //    77: aload_0        
        //    78: iload_1        
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    87: aload_0        
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokespecial   instrumented/java/util/Scanner.clearCaches:()V
        //    96: aload_0        
        //    97: aload_0        
        //    98: ldc             3
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/Scanner.next:(Linstrumented/java/util/regex/Pattern;)Ljava/lang/String;
        //   114: astore_2       
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: aload_0        
        //   121: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   124: aload_0        
        //   125: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //   128: ldc             5
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: ifnonnull       160
        //   144: aload_0        
        //   145: aload_2        
        //   146: ldc             3
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //   154: astore_2       
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: aload_2        
        //   161: iload_1        
        //   162: ldc             3
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokestatic    java/lang/Short.parseShort:(Ljava/lang/String;I)S
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: ireturn        
        //   176: astore_2       
        //   177: ldc_w           501
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload_0        
        //   184: aload_0        
        //   185: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   188: ldc             4
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokevirtual   instrumented/java/util/regex/Matcher.start:()I
        //   196: putfield        instrumented/java/util/Scanner.position:I
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: new             Linstrumented/java/util/InputMismatchException;
        //   207: dup            
        //   208: aload_2        
        //   209: ldc             4
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokevirtual   java/lang/NumberFormatException.getMessage:()Ljava/lang/String;
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: invokespecial   instrumented/java/util/InputMismatchException.<init>:(Ljava/lang/String;)V
        //   225: ldc             1
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: athrow         
        //   231: athrow         
        //   232: athrow         
        //    StackMapTable: 00 05 FB 00 4D FC 00 52 07 00 6D FF 00 0F 00 02 07 00 02 01 00 01 07 02 F3 FF 00 36 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  96     232    232    233    Ljava/lang/VirtualMachineError;
        //  96     170    176    231    Ljava/lang/NumberFormatException;
        //  0      231    231    232    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0160:
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
    
    public boolean hasNextInt() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final boolean hasNextInt = this.hasNextInt(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return hasNextInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextInt(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    10: aload_0        
        //    11: aload_0        
        //    12: ldc             3
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    28: istore_2       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: iload_2        
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ifeq            157
        //    43: aload_0        
        //    44: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //    47: aload_0        
        //    48: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //    51: ldc             5
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: ifnonnull       93
        //    67: aload_0        
        //    68: aload_0        
        //    69: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            102
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: astore_3       
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_0        
        //   109: aload_3        
        //   110: iload_1        
        //   111: ldc             4
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;I)I
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   127: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: goto            157
        //   143: astore_3       
        //   144: ldc_w           501
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: iconst_0       
        //   151: istore_2       
        //   152: ldc             2
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: iload_2        
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ireturn        
        //   164: athrow         
        //   165: athrow         
        //    StackMapTable: 00 06 FC 00 5D 01 48 07 00 6D 68 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  43     165    165    166    Ljava/lang/VirtualMachineError;
        //  43     135    143    157    Ljava/lang/NumberFormatException;
        //  0      164    164    165    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    private String processIntegerToken(final String s) {
        try {
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            final String str = "";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String groupSeparator = this.groupSeparator;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(groupSeparator);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            final String replacement = "";
            BytecodeManager.incBytecodes(2);
            String s2 = s.replaceAll(string, replacement);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final String negativePrefix = this.negativePrefix;
            BytecodeManager.incBytecodes(3);
            final int length = negativePrefix.length();
            BytecodeManager.incBytecodes(1);
            final int n2 = length;
            BytecodeManager.incBytecodes(2);
            if (n2 > 0) {
                final String s3 = s2;
                final String negativePrefix2 = this.negativePrefix;
                BytecodeManager.incBytecodes(4);
                final boolean startsWith = s3.startsWith(negativePrefix2);
                BytecodeManager.incBytecodes(1);
                if (startsWith) {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                    final String s4 = s2;
                    final int beginIndex = length;
                    BytecodeManager.incBytecodes(3);
                    s2 = s4.substring(beginIndex);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final String negativeSuffix = this.negativeSuffix;
            BytecodeManager.incBytecodes(3);
            final int length2 = negativeSuffix.length();
            BytecodeManager.incBytecodes(1);
            final int n3 = length2;
            BytecodeManager.incBytecodes(2);
            if (n3 > 0) {
                final String s5 = s2;
                final String negativeSuffix2 = this.negativeSuffix;
                BytecodeManager.incBytecodes(4);
                final boolean endsWith = s5.endsWith(negativeSuffix2);
                BytecodeManager.incBytecodes(1);
                if (endsWith) {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                    final String s6 = s2;
                    final String s7 = s2;
                    BytecodeManager.incBytecodes(3);
                    final int beginIndex2 = s7.length() - length2;
                    final String s8 = s2;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final int length3 = s8.length();
                    BytecodeManager.incBytecodes(1);
                    s2 = s6.substring(beginIndex2, length3);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n4 = n;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "-";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                final String str3 = s2;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str3);
                BytecodeManager.incBytecodes(1);
                s2 = append4.toString();
                BytecodeManager.incBytecodes(1);
            }
            final String s9 = s2;
            BytecodeManager.incBytecodes(2);
            return s9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextInt() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final int nextInt = this.nextInt(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return nextInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int nextInt(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          77
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    16: instanceof      Ljava/lang/Integer;
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifeq            77
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/Scanner.radix:I
        //    31: iload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: if_icmpne       77
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    44: checkcast       Ljava/lang/Integer;
        //    47: ldc             4
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   java/lang/Integer.intValue:()I
        //    55: istore_2       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_0        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   instrumented/java/util/Scanner.useTypeCache:()V
        //    70: iload_2        
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ireturn        
        //    77: aload_0        
        //    78: iload_1        
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    87: aload_0        
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokespecial   instrumented/java/util/Scanner.clearCaches:()V
        //    96: aload_0        
        //    97: aload_0        
        //    98: ldc             3
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/Scanner.next:(Linstrumented/java/util/regex/Pattern;)Ljava/lang/String;
        //   114: astore_2       
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: aload_0        
        //   121: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   124: aload_0        
        //   125: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //   128: ldc             5
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: ifnonnull       160
        //   144: aload_0        
        //   145: aload_2        
        //   146: ldc             3
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //   154: astore_2       
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: aload_2        
        //   161: iload_1        
        //   162: ldc             3
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;I)I
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: ireturn        
        //   176: astore_2       
        //   177: ldc_w           501
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload_0        
        //   184: aload_0        
        //   185: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   188: ldc             4
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokevirtual   instrumented/java/util/regex/Matcher.start:()I
        //   196: putfield        instrumented/java/util/Scanner.position:I
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: new             Linstrumented/java/util/InputMismatchException;
        //   207: dup            
        //   208: aload_2        
        //   209: ldc             4
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokevirtual   java/lang/NumberFormatException.getMessage:()Ljava/lang/String;
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: invokespecial   instrumented/java/util/InputMismatchException.<init>:(Ljava/lang/String;)V
        //   225: ldc             1
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: athrow         
        //   231: athrow         
        //   232: athrow         
        //    StackMapTable: 00 05 FB 00 4D FC 00 52 07 00 6D FF 00 0F 00 02 07 00 02 01 00 01 07 02 F3 FF 00 36 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  96     232    232    233    Ljava/lang/VirtualMachineError;
        //  96     170    176    231    Ljava/lang/NumberFormatException;
        //  0      231    231    232    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0160:
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
    
    public boolean hasNextLong() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final boolean hasNextLong = this.hasNextLong(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return hasNextLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextLong(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    10: aload_0        
        //    11: aload_0        
        //    12: ldc             3
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    28: istore_2       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: iload_2        
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ifeq            157
        //    43: aload_0        
        //    44: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //    47: aload_0        
        //    48: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //    51: ldc             5
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: ifnonnull       93
        //    67: aload_0        
        //    68: aload_0        
        //    69: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            102
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: astore_3       
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_0        
        //   109: aload_3        
        //   110: iload_1        
        //   111: ldc             4
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;I)J
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   127: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: goto            157
        //   143: astore_3       
        //   144: ldc_w           501
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: iconst_0       
        //   151: istore_2       
        //   152: ldc             2
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: iload_2        
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ireturn        
        //   164: athrow         
        //   165: athrow         
        //    StackMapTable: 00 06 FC 00 5D 01 48 07 00 6D 68 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  43     165    165    166    Ljava/lang/VirtualMachineError;
        //  43     135    143    157    Ljava/lang/NumberFormatException;
        //  0      164    164    165    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    public long nextLong() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final long nextLong = this.nextLong(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return nextLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long nextLong(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          77
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    16: instanceof      Ljava/lang/Long;
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifeq            77
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/Scanner.radix:I
        //    31: iload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: if_icmpne       77
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    44: checkcast       Ljava/lang/Long;
        //    47: ldc             4
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   java/lang/Long.longValue:()J
        //    55: lstore_2       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_0        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   instrumented/java/util/Scanner.useTypeCache:()V
        //    70: lload_2        
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: lreturn        
        //    77: aload_0        
        //    78: iload_1        
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    87: aload_0        
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokespecial   instrumented/java/util/Scanner.clearCaches:()V
        //    96: aload_0        
        //    97: aload_0        
        //    98: ldc             3
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/Scanner.next:(Linstrumented/java/util/regex/Pattern;)Ljava/lang/String;
        //   114: astore_2       
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: aload_0        
        //   121: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   124: aload_0        
        //   125: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //   128: ldc             5
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: ifnonnull       160
        //   144: aload_0        
        //   145: aload_2        
        //   146: ldc             3
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //   154: astore_2       
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: aload_2        
        //   161: iload_1        
        //   162: ldc             3
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;I)J
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: lreturn        
        //   176: astore_2       
        //   177: ldc_w           501
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload_0        
        //   184: aload_0        
        //   185: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   188: ldc             4
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokevirtual   instrumented/java/util/regex/Matcher.start:()I
        //   196: putfield        instrumented/java/util/Scanner.position:I
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: new             Linstrumented/java/util/InputMismatchException;
        //   207: dup            
        //   208: aload_2        
        //   209: ldc             4
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokevirtual   java/lang/NumberFormatException.getMessage:()Ljava/lang/String;
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: invokespecial   instrumented/java/util/InputMismatchException.<init>:(Ljava/lang/String;)V
        //   225: ldc             1
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: athrow         
        //   231: athrow         
        //   232: athrow         
        //    StackMapTable: 00 05 FB 00 4D FC 00 52 07 00 6D FF 00 0F 00 02 07 00 02 01 00 01 07 02 F3 FF 00 36 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  96     232    232    233    Ljava/lang/VirtualMachineError;
        //  96     170    176    231    Ljava/lang/NumberFormatException;
        //  0      231    231    232    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0160:
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
    
    private String processFloatToken(final String s) {
        try {
            final String groupSeparator = this.groupSeparator;
            final String replacement = "";
            BytecodeManager.incBytecodes(5);
            String s2 = s.replaceAll(groupSeparator, replacement);
            BytecodeManager.incBytecodes(1);
            final String decimalSeparator = this.decimalSeparator;
            final String anObject = "\\.";
            BytecodeManager.incBytecodes(4);
            final boolean equals = decimalSeparator.equals(anObject);
            BytecodeManager.incBytecodes(1);
            if (!equals) {
                final String s3 = s2;
                final String decimalSeparator2 = this.decimalSeparator;
                final String replacement2 = ".";
                BytecodeManager.incBytecodes(5);
                s2 = s3.replaceAll(decimalSeparator2, replacement2);
                BytecodeManager.incBytecodes(1);
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final String negativePrefix = this.negativePrefix;
            BytecodeManager.incBytecodes(3);
            final int length = negativePrefix.length();
            BytecodeManager.incBytecodes(1);
            final int n2 = length;
            BytecodeManager.incBytecodes(2);
            if (n2 > 0) {
                final String s4 = s2;
                final String negativePrefix2 = this.negativePrefix;
                BytecodeManager.incBytecodes(4);
                final boolean startsWith = s4.startsWith(negativePrefix2);
                BytecodeManager.incBytecodes(1);
                if (startsWith) {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                    final String s5 = s2;
                    final int beginIndex = length;
                    BytecodeManager.incBytecodes(3);
                    s2 = s5.substring(beginIndex);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final String negativeSuffix = this.negativeSuffix;
            BytecodeManager.incBytecodes(3);
            final int length2 = negativeSuffix.length();
            BytecodeManager.incBytecodes(1);
            final int n3 = length2;
            BytecodeManager.incBytecodes(2);
            if (n3 > 0) {
                final String s6 = s2;
                final String negativeSuffix2 = this.negativeSuffix;
                BytecodeManager.incBytecodes(4);
                final boolean endsWith = s6.endsWith(negativeSuffix2);
                BytecodeManager.incBytecodes(1);
                if (endsWith) {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                    final String s7 = s2;
                    final String s8 = s2;
                    BytecodeManager.incBytecodes(3);
                    final int beginIndex2 = s8.length() - length2;
                    final String s9 = s2;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final int length3 = s9.length();
                    BytecodeManager.incBytecodes(1);
                    s2 = s7.substring(beginIndex2, length3);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final String s10 = s2;
            final String nanString = this.nanString;
            BytecodeManager.incBytecodes(4);
            final boolean equals2 = s10.equals(nanString);
            BytecodeManager.incBytecodes(1);
            if (equals2) {
                s2 = "NaN";
                BytecodeManager.incBytecodes(2);
            }
            final String s11 = s2;
            final String infinityString = this.infinityString;
            BytecodeManager.incBytecodes(4);
            final boolean equals3 = s11.equals(infinityString);
            BytecodeManager.incBytecodes(1);
            if (equals3) {
                s2 = "Infinity";
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = n;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "-";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = s2;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                BytecodeManager.incBytecodes(1);
                s2 = append2.toString();
                BytecodeManager.incBytecodes(1);
            }
            final Pattern non_ASCII_DIGIT = Scanner.NON_ASCII_DIGIT;
            final String s12 = s2;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = non_ASCII_DIGIT.matcher(s12);
            BytecodeManager.incBytecodes(1);
            final Matcher matcher2 = matcher;
            BytecodeManager.incBytecodes(2);
            final boolean find = matcher2.find();
            BytecodeManager.incBytecodes(1);
            if (find) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                int n5 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = n5;
                    final String s13 = s2;
                    BytecodeManager.incBytecodes(3);
                    final int length4 = s13.length();
                    BytecodeManager.incBytecodes(1);
                    if (n6 >= length4) {
                        break;
                    }
                    final String s14 = s2;
                    final int index = n5;
                    BytecodeManager.incBytecodes(3);
                    final char char1 = s14.charAt(index);
                    BytecodeManager.incBytecodes(1);
                    final char ch = char1;
                    BytecodeManager.incBytecodes(2);
                    final boolean digit = Character.isDigit(ch);
                    BytecodeManager.incBytecodes(1);
                    if (digit) {
                        final char ch2 = char1;
                        final int radix = 10;
                        BytecodeManager.incBytecodes(3);
                        final int digit2 = Character.digit(ch2, radix);
                        BytecodeManager.incBytecodes(1);
                        final int n7 = digit2;
                        final int n8 = -1;
                        BytecodeManager.incBytecodes(3);
                        if (n7 != n8) {
                            final StringBuilder sb3 = sb2;
                            final int i = digit2;
                            BytecodeManager.incBytecodes(3);
                            sb3.append(i);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final StringBuilder sb4 = sb2;
                            final char c = char1;
                            BytecodeManager.incBytecodes(3);
                            sb4.append(c);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final StringBuilder sb5 = sb2;
                        final char c2 = char1;
                        BytecodeManager.incBytecodes(3);
                        sb5.append(c2);
                        BytecodeManager.incBytecodes(1);
                    }
                    ++n5;
                    BytecodeManager.incBytecodes(2);
                }
                final StringBuilder sb6 = sb2;
                BytecodeManager.incBytecodes(2);
                s2 = sb6.toString();
                BytecodeManager.incBytecodes(1);
            }
            final String s15 = s2;
            BytecodeManager.incBytecodes(2);
            return s15;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextFloat() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: bipush          10
        //     3: ldc             3
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    11: aload_0        
        //    12: aload_0        
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   instrumented/java/util/Scanner.floatPattern:()Linstrumented/java/util/regex/Pattern;
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    29: istore_1       
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: iload_1        
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: ifeq            111
        //    44: aload_0        
        //    45: aload_0        
        //    46: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    49: ldc             4
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokespecial   instrumented/java/util/Scanner.processFloatToken:(Ljava/lang/String;)Ljava/lang/String;
        //    57: astore_2       
        //    58: ldc             1
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: aload_0        
        //    64: aload_2        
        //    65: ldc             3
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
        //    81: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: goto            111
        //    97: astore_2       
        //    98: ldc_w           501
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: iconst_0       
        //   105: istore_1       
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: iload_1        
        //   112: ldc             2
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: ireturn        
        //   118: athrow         
        //   119: athrow         
        //    StackMapTable: 00 04 FF 00 61 00 02 07 00 02 01 00 01 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  44     119    119    120    Ljava/lang/VirtualMachineError;
        //  44     89     97     111    Ljava/lang/NumberFormatException;
        //  0      118    118    119    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0111:
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
    
    public float nextFloat() {
        try {
            final Object typeCache = this.typeCache;
            BytecodeManager.incBytecodes(3);
            if (typeCache != null) {
                final boolean b = this.typeCache instanceof Float;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final Float n = (Float)this.typeCache;
                    BytecodeManager.incBytecodes(4);
                    final float floatValue = n;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    this.useTypeCache();
                    final float n2 = floatValue;
                    BytecodeManager.incBytecodes(2);
                    return n2;
                }
            }
            final int radix = 10;
            BytecodeManager.incBytecodes(3);
            this.setRadix(radix);
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            try {
                final Scanner scanner = this;
                final Scanner scanner2 = this;
                final Scanner scanner3 = this;
                final int n3 = 4;
                BytecodeManager.incBytecodes(n3);
                final Pattern pattern = scanner3.floatPattern();
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                final String s = scanner2.next(pattern);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                final String s2 = scanner.processFloatToken(s);
                final int n6 = 1;
                BytecodeManager.incBytecodes(n6);
                final float n7 = Float.parseFloat(s2);
                final int n8 = 1;
                BytecodeManager.incBytecodes(n8);
                return n7;
            }
            catch (NumberFormatException ex2) {
                BytecodeManager.incBytecodes(501);
                final Scanner scanner4 = this;
                final Matcher matcher = this.matcher;
                BytecodeManager.incBytecodes(4);
                scanner4.position = matcher.start();
                BytecodeManager.incBytecodes(1);
                final NumberFormatException ex = ex2;
                BytecodeManager.incBytecodes(4);
                final String message = ex.getMessage();
                BytecodeManager.incBytecodes(1);
                final InputMismatchException ex3 = new InputMismatchException(message);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
        }
        finally {}
        try {
            final Scanner scanner = this;
            final Scanner scanner2 = this;
            final Scanner scanner3 = this;
            final int n3 = 4;
            BytecodeManager.incBytecodes(n3);
            final Pattern pattern = scanner3.floatPattern();
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            final String s = scanner2.next(pattern);
            final int n5 = 1;
            BytecodeManager.incBytecodes(n5);
            final String s2 = scanner.processFloatToken(s);
            final int n6 = 1;
            BytecodeManager.incBytecodes(n6);
            final float n7 = Float.parseFloat(s2);
            final int n8 = 1;
            BytecodeManager.incBytecodes(n8);
            return n7;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public boolean hasNextDouble() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: bipush          10
        //     3: ldc             3
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    11: aload_0        
        //    12: aload_0        
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   instrumented/java/util/Scanner.floatPattern:()Linstrumented/java/util/regex/Pattern;
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    29: istore_1       
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: iload_1        
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: ifeq            111
        //    44: aload_0        
        //    45: aload_0        
        //    46: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    49: ldc             4
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokespecial   instrumented/java/util/Scanner.processFloatToken:(Ljava/lang/String;)Ljava/lang/String;
        //    57: astore_2       
        //    58: ldc             1
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: aload_0        
        //    64: aload_2        
        //    65: ldc             3
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    81: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: goto            111
        //    97: astore_2       
        //    98: ldc_w           501
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: iconst_0       
        //   105: istore_1       
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: iload_1        
        //   112: ldc             2
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: ireturn        
        //   118: athrow         
        //   119: athrow         
        //    StackMapTable: 00 04 FF 00 61 00 02 07 00 02 01 00 01 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  44     119    119    120    Ljava/lang/VirtualMachineError;
        //  44     89     97     111    Ljava/lang/NumberFormatException;
        //  0      118    118    119    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0111:
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
    
    public double nextDouble() {
        try {
            final Object typeCache = this.typeCache;
            BytecodeManager.incBytecodes(3);
            if (typeCache != null) {
                final boolean b = this.typeCache instanceof Double;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final Double n = (Double)this.typeCache;
                    BytecodeManager.incBytecodes(4);
                    final double doubleValue = n;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    this.useTypeCache();
                    final double n2 = doubleValue;
                    BytecodeManager.incBytecodes(2);
                    return n2;
                }
            }
            final int radix = 10;
            BytecodeManager.incBytecodes(3);
            this.setRadix(radix);
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            try {
                final Scanner scanner = this;
                final Scanner scanner2 = this;
                final Scanner scanner3 = this;
                final int n3 = 4;
                BytecodeManager.incBytecodes(n3);
                final Pattern pattern = scanner3.floatPattern();
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                final String s = scanner2.next(pattern);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                final String s2 = scanner.processFloatToken(s);
                final int n6 = 1;
                BytecodeManager.incBytecodes(n6);
                final double n7 = Double.parseDouble(s2);
                final int n8 = 1;
                BytecodeManager.incBytecodes(n8);
                return n7;
            }
            catch (NumberFormatException ex2) {
                BytecodeManager.incBytecodes(501);
                final Scanner scanner4 = this;
                final Matcher matcher = this.matcher;
                BytecodeManager.incBytecodes(4);
                scanner4.position = matcher.start();
                BytecodeManager.incBytecodes(1);
                final NumberFormatException ex = ex2;
                BytecodeManager.incBytecodes(4);
                final String message = ex.getMessage();
                BytecodeManager.incBytecodes(1);
                final InputMismatchException ex3 = new InputMismatchException(message);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
        }
        finally {}
        try {
            final Scanner scanner = this;
            final Scanner scanner2 = this;
            final Scanner scanner3 = this;
            final int n3 = 4;
            BytecodeManager.incBytecodes(n3);
            final Pattern pattern = scanner3.floatPattern();
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            final String s = scanner2.next(pattern);
            final int n5 = 1;
            BytecodeManager.incBytecodes(n5);
            final String s2 = scanner.processFloatToken(s);
            final int n6 = 1;
            BytecodeManager.incBytecodes(n6);
            final double n7 = Double.parseDouble(s2);
            final int n8 = 1;
            BytecodeManager.incBytecodes(n8);
            return n7;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public boolean hasNextBigInteger() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final boolean hasNextBigInteger = this.hasNextBigInteger(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return hasNextBigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean hasNextBigInteger(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    10: aload_0        
        //    11: aload_0        
        //    12: ldc             3
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    28: istore_2       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: iload_2        
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ifeq            153
        //    43: aload_0        
        //    44: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //    47: aload_0        
        //    48: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //    51: ldc             5
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: ifnonnull       93
        //    67: aload_0        
        //    68: aload_0        
        //    69: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            102
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: astore_3       
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_0        
        //   109: new             Linstrumented/java/math/BigInteger;
        //   112: dup            
        //   113: aload_3        
        //   114: iload_1        
        //   115: ldc             6
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokespecial   instrumented/java/math/BigInteger.<init>:(Ljava/lang/String;I)V
        //   123: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //   126: ldc             1
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: goto            153
        //   139: astore_3       
        //   140: ldc_w           501
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: iconst_0       
        //   147: istore_2       
        //   148: ldc             2
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: iload_2        
        //   154: ldc             2
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: ireturn        
        //   160: athrow         
        //   161: athrow         
        //    StackMapTable: 00 06 FC 00 5D 01 48 07 00 6D 64 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  43     161    161    162    Ljava/lang/VirtualMachineError;
        //  43     131    139    153    Ljava/lang/NumberFormatException;
        //  0      160    160    161    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    public BigInteger nextBigInteger() {
        try {
            final int defaultRadix = this.defaultRadix;
            BytecodeManager.incBytecodes(4);
            final BigInteger nextBigInteger = this.nextBigInteger(defaultRadix);
            BytecodeManager.incBytecodes(1);
            return nextBigInteger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger nextBigInteger(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          69
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    16: instanceof      Linstrumented/java/math/BigInteger;
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifeq            69
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/Scanner.radix:I
        //    31: iload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: if_icmpne       69
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    44: checkcast       Linstrumented/java/math/BigInteger;
        //    47: astore_2       
        //    48: ldc             4
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: aload_0        
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokespecial   instrumented/java/util/Scanner.useTypeCache:()V
        //    62: aload_2        
        //    63: ldc             2
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: areturn        
        //    69: aload_0        
        //    70: iload_1        
        //    71: ldc             3
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    79: aload_0        
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokespecial   instrumented/java/util/Scanner.clearCaches:()V
        //    88: aload_0        
        //    89: aload_0        
        //    90: ldc             3
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokespecial   instrumented/java/util/Scanner.integerPattern:()Linstrumented/java/util/regex/Pattern;
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokevirtual   instrumented/java/util/Scanner.next:(Linstrumented/java/util/regex/Pattern;)Ljava/lang/String;
        //   106: astore_2       
        //   107: ldc             1
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: aload_0        
        //   113: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   116: aload_0        
        //   117: getfield        instrumented/java/util/Scanner.SIMPLE_GROUP_INDEX:I
        //   120: ldc             5
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: invokevirtual   instrumented/java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   128: ldc             1
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: ifnonnull       152
        //   136: aload_0        
        //   137: aload_2        
        //   138: ldc             3
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokespecial   instrumented/java/util/Scanner.processIntegerToken:(Ljava/lang/String;)Ljava/lang/String;
        //   146: astore_2       
        //   147: ldc             1
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: new             Linstrumented/java/math/BigInteger;
        //   155: dup            
        //   156: aload_2        
        //   157: iload_1        
        //   158: ldc             5
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: invokespecial   instrumented/java/math/BigInteger.<init>:(Ljava/lang/String;I)V
        //   166: ldc             1
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: areturn        
        //   172: astore_2       
        //   173: ldc_w           501
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: aload_0        
        //   180: aload_0        
        //   181: getfield        instrumented/java/util/Scanner.matcher:Linstrumented/java/util/regex/Matcher;
        //   184: ldc             4
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: invokevirtual   instrumented/java/util/regex/Matcher.start:()I
        //   192: putfield        instrumented/java/util/Scanner.position:I
        //   195: ldc             1
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: new             Linstrumented/java/util/InputMismatchException;
        //   203: dup            
        //   204: aload_2        
        //   205: ldc             4
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: invokevirtual   java/lang/NumberFormatException.getMessage:()Ljava/lang/String;
        //   213: ldc             1
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: invokespecial   instrumented/java/util/InputMismatchException.<init>:(Ljava/lang/String;)V
        //   221: ldc             1
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: athrow         
        //   227: athrow         
        //   228: athrow         
        //    StackMapTable: 00 05 FB 00 45 FC 00 52 07 00 6D FF 00 13 00 02 07 00 02 01 00 01 07 02 F3 FF 00 36 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  88     228    228    229    Ljava/lang/VirtualMachineError;
        //  88     166    172    227    Ljava/lang/NumberFormatException;
        //  0      227    227    228    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0152:
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
    
    public boolean hasNextBigDecimal() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: bipush          10
        //     3: ldc             3
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokespecial   instrumented/java/util/Scanner.setRadix:(I)V
        //    11: aload_0        
        //    12: aload_0        
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   instrumented/java/util/Scanner.decimalPattern:()Linstrumented/java/util/regex/Pattern;
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokevirtual   instrumented/java/util/Scanner.hasNext:(Linstrumented/java/util/regex/Pattern;)Z
        //    29: istore_1       
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: iload_1        
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: ifeq            107
        //    44: aload_0        
        //    45: aload_0        
        //    46: getfield        instrumented/java/util/Scanner.hasNextResult:Ljava/lang/String;
        //    49: ldc             4
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokespecial   instrumented/java/util/Scanner.processFloatToken:(Ljava/lang/String;)Ljava/lang/String;
        //    57: astore_2       
        //    58: ldc             1
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: aload_0        
        //    64: new             Linstrumented/java/math/BigDecimal;
        //    67: dup            
        //    68: aload_2        
        //    69: ldc             5
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: invokespecial   instrumented/java/math/BigDecimal.<init>:(Ljava/lang/String;)V
        //    77: putfield        instrumented/java/util/Scanner.typeCache:Ljava/lang/Object;
        //    80: ldc             1
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            107
        //    93: astore_2       
        //    94: ldc_w           501
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: iconst_0       
        //   101: istore_1       
        //   102: ldc             2
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: iload_1        
        //   108: ldc             2
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: ireturn        
        //   114: athrow         
        //   115: athrow         
        //    StackMapTable: 00 04 FF 00 5D 00 02 07 00 02 01 00 01 07 02 F3 0D FF 00 06 00 00 00 01 07 00 64 FF 00 00 00 00 00 01 07 01 59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  44     115    115    116    Ljava/lang/VirtualMachineError;
        //  44     85     93     107    Ljava/lang/NumberFormatException;
        //  0      114    114    115    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0107:
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
    
    public BigDecimal nextBigDecimal() {
        try {
            final Object typeCache = this.typeCache;
            BytecodeManager.incBytecodes(3);
            if (typeCache != null) {
                final boolean b = this.typeCache instanceof BigDecimal;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final BigDecimal bigDecimal = (BigDecimal)this.typeCache;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(2);
                    this.useTypeCache();
                    final BigDecimal bigDecimal2 = bigDecimal;
                    BytecodeManager.incBytecodes(2);
                    return bigDecimal2;
                }
            }
            final int radix = 10;
            BytecodeManager.incBytecodes(3);
            this.setRadix(radix);
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            try {
                final Scanner scanner = this;
                final Scanner scanner2 = this;
                final Scanner scanner3 = this;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final Pattern pattern = scanner3.decimalPattern();
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final String s = scanner2.next(pattern);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                final String s2 = scanner.processFloatToken(s);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                final String s3 = s2;
                final int n5 = 4;
                BytecodeManager.incBytecodes(n5);
                final BigDecimal bigDecimal3 = new BigDecimal(s3);
                final int n6 = 1;
                BytecodeManager.incBytecodes(n6);
                return bigDecimal3;
            }
            catch (NumberFormatException ex2) {
                BytecodeManager.incBytecodes(501);
                final Scanner scanner4 = this;
                final Matcher matcher = this.matcher;
                BytecodeManager.incBytecodes(4);
                scanner4.position = matcher.start();
                BytecodeManager.incBytecodes(1);
                final NumberFormatException ex = ex2;
                BytecodeManager.incBytecodes(4);
                final String message = ex.getMessage();
                BytecodeManager.incBytecodes(1);
                final InputMismatchException ex3 = new InputMismatchException(message);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
        }
        finally {}
        try {
            final Scanner scanner = this;
            final Scanner scanner2 = this;
            final Scanner scanner3 = this;
            final int n = 4;
            BytecodeManager.incBytecodes(n);
            final Pattern pattern = scanner3.decimalPattern();
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            final String s = scanner2.next(pattern);
            final int n3 = 1;
            BytecodeManager.incBytecodes(n3);
            final String s2 = scanner.processFloatToken(s);
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            final String s3 = s2;
            final int n5 = 4;
            BytecodeManager.incBytecodes(n5);
            final BigDecimal bigDecimal3 = new BigDecimal(s3);
            final int n6 = 1;
            BytecodeManager.incBytecodes(n6);
            return bigDecimal3;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public Scanner reset() {
        try {
            this.delimPattern = Scanner.WHITESPACE_PATTERN;
            BytecodeManager.incBytecodes(3);
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this.useLocale(default1);
            BytecodeManager.incBytecodes(1);
            final int n = 10;
            BytecodeManager.incBytecodes(3);
            this.useRadix(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.clearCaches();
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<Scanner> clazz = Scanner.class;
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
            BytecodeManager.incBytecodes(1);
            final String s = "\\p{javaWhitespace}+";
            BytecodeManager.incBytecodes(2);
            Scanner.WHITESPACE_PATTERN = Pattern.compile(s);
            BytecodeManager.incBytecodes(1);
            final String s2 = "(?s).*";
            BytecodeManager.incBytecodes(2);
            Scanner.FIND_ANY_PATTERN = Pattern.compile(s2);
            BytecodeManager.incBytecodes(1);
            final String s3 = "[\\p{javaDigit}&&[^0-9]]";
            BytecodeManager.incBytecodes(2);
            Scanner.NON_ASCII_DIGIT = Pattern.compile(s3);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
