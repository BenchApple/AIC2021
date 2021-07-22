// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import instrumented.java.util.GregorianCalendar;
import aic2021.engine.BytecodeManager;

public class XMLFormatter extends Formatter
{
    private LogManager manager;
    
    public XMLFormatter() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            this.manager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void a2(final StringBuilder sb, final int i) {
        try {
            final int n = 10;
            BytecodeManager.incBytecodes(3);
            if (i < n) {
                final char c = '0';
                BytecodeManager.incBytecodes(3);
                sb.append(c);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(3);
            sb.append(i);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void appendISO8601(final StringBuilder sb, final long timeInMillis) {
        try {
            BytecodeManager.incBytecodes(3);
            final GregorianCalendar gregorianCalendar = new GregorianCalendar();
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
            BytecodeManager.incBytecodes(3);
            gregorianCalendar2.setTimeInMillis(timeInMillis);
            final GregorianCalendar gregorianCalendar3 = gregorianCalendar;
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            final int value = gregorianCalendar3.get(n);
            BytecodeManager.incBytecodes(1);
            sb.append(value);
            BytecodeManager.incBytecodes(1);
            final char c = '-';
            BytecodeManager.incBytecodes(3);
            sb.append(c);
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar4 = gregorianCalendar;
            final int n2 = 2;
            BytecodeManager.incBytecodes(5);
            final int n3 = gregorianCalendar4.get(n2) + 1;
            BytecodeManager.incBytecodes(3);
            this.a2(sb, n3);
            final char c2 = '-';
            BytecodeManager.incBytecodes(3);
            sb.append(c2);
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar5 = gregorianCalendar;
            final int n4 = 5;
            BytecodeManager.incBytecodes(5);
            final int value2 = gregorianCalendar5.get(n4);
            BytecodeManager.incBytecodes(1);
            this.a2(sb, value2);
            final char c3 = 'T';
            BytecodeManager.incBytecodes(3);
            sb.append(c3);
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar6 = gregorianCalendar;
            final int n5 = 11;
            BytecodeManager.incBytecodes(5);
            final int value3 = gregorianCalendar6.get(n5);
            BytecodeManager.incBytecodes(1);
            this.a2(sb, value3);
            final char c4 = ':';
            BytecodeManager.incBytecodes(3);
            sb.append(c4);
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar7 = gregorianCalendar;
            final int n6 = 12;
            BytecodeManager.incBytecodes(5);
            final int value4 = gregorianCalendar7.get(n6);
            BytecodeManager.incBytecodes(1);
            this.a2(sb, value4);
            final char c5 = ':';
            BytecodeManager.incBytecodes(3);
            sb.append(c5);
            BytecodeManager.incBytecodes(1);
            final GregorianCalendar gregorianCalendar8 = gregorianCalendar;
            final int n7 = 13;
            BytecodeManager.incBytecodes(5);
            final int value5 = gregorianCalendar8.get(n7);
            BytecodeManager.incBytecodes(1);
            this.a2(sb, value5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void escape(final StringBuilder sb, String s) {
        try {
            final String s2 = s;
            BytecodeManager.incBytecodes(2);
            if (s2 == null) {
                s = "<null>";
                BytecodeManager.incBytecodes(2);
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final String s3 = s;
                BytecodeManager.incBytecodes(3);
                final int length = s3.length();
                BytecodeManager.incBytecodes(1);
                if (n2 >= length) {
                    break;
                }
                final String s4 = s;
                final int index = n;
                BytecodeManager.incBytecodes(3);
                final char char1 = s4.charAt(index);
                BytecodeManager.incBytecodes(1);
                final char c = char1;
                final int n3 = '<';
                BytecodeManager.incBytecodes(3);
                if (c == n3) {
                    final String str = "&lt;";
                    BytecodeManager.incBytecodes(3);
                    sb.append(str);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final char c2 = char1;
                    final int n4 = '>';
                    BytecodeManager.incBytecodes(3);
                    if (c2 == n4) {
                        final String str2 = "&gt;";
                        BytecodeManager.incBytecodes(3);
                        sb.append(str2);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final char c3 = char1;
                        final int n5 = '&';
                        BytecodeManager.incBytecodes(3);
                        if (c3 == n5) {
                            final String str3 = "&amp;";
                            BytecodeManager.incBytecodes(3);
                            sb.append(str3);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final char c4 = char1;
                            BytecodeManager.incBytecodes(3);
                            sb.append(c4);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
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
    
    @Override
    public String format(final LogRecord p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: sipush          500
        //     7: ldc             4
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    15: astore_2       
        //    16: ldc             1
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: aload_2        
        //    22: ldc             "<record>\n"
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    32: pop            
        //    33: ldc             1
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: aload_2        
        //    39: ldc             "  <date>"
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    49: pop            
        //    50: ldc             1
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: aload_0        
        //    56: aload_2        
        //    57: aload_1        
        //    58: ldc             4
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: invokevirtual   instrumented/java/util/logging/LogRecord.getMillis:()J
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: invokespecial   instrumented/java/util/logging/XMLFormatter.appendISO8601:(Ljava/lang/StringBuilder;J)V
        //    74: aload_2        
        //    75: ldc             "</date>\n"
        //    77: ldc             3
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: pop            
        //    86: ldc             1
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_2        
        //    92: ldc             "  <millis>"
        //    94: ldc             3
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: pop            
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_2        
        //   109: aload_1        
        //   110: ldc             3
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: invokevirtual   instrumented/java/util/logging/LogRecord.getMillis:()J
        //   118: ldc             1
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   126: pop            
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: aload_2        
        //   133: ldc             "</millis>\n"
        //   135: ldc             3
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   143: pop            
        //   144: ldc             1
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: aload_2        
        //   150: ldc             "  <sequence>"
        //   152: ldc             3
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: pop            
        //   161: ldc             1
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload_2        
        //   167: aload_1        
        //   168: ldc             3
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: invokevirtual   instrumented/java/util/logging/LogRecord.getSequenceNumber:()J
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   184: pop            
        //   185: ldc             1
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: aload_2        
        //   191: ldc             "</sequence>\n"
        //   193: ldc             3
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   201: pop            
        //   202: ldc             1
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: aload_1        
        //   208: ldc             2
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: invokevirtual   instrumented/java/util/logging/LogRecord.getLoggerName:()Ljava/lang/String;
        //   216: astore_3       
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: aload_3        
        //   223: ldc             2
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: ifnull          276
        //   231: aload_2        
        //   232: ldc             "  <logger>"
        //   234: ldc             3
        //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   239: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   242: pop            
        //   243: ldc             1
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: aload_0        
        //   249: aload_2        
        //   250: aload_3        
        //   251: ldc             4
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   259: aload_2        
        //   260: ldc             "</logger>\n"
        //   262: ldc             3
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   270: pop            
        //   271: ldc             1
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: aload_2        
        //   277: ldc             "  <level>"
        //   279: ldc             3
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   287: pop            
        //   288: ldc             1
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: aload_0        
        //   294: aload_2        
        //   295: aload_1        
        //   296: ldc             4
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: invokevirtual   instrumented/java/util/logging/LogRecord.getLevel:()Linstrumented/java/util/logging/Level;
        //   304: ldc             1
        //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   309: invokevirtual   instrumented/java/util/logging/Level.toString:()Ljava/lang/String;
        //   312: ldc             1
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   320: aload_2        
        //   321: ldc             "</level>\n"
        //   323: ldc             3
        //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   328: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   331: pop            
        //   332: ldc             1
        //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   337: aload_1        
        //   338: ldc             2
        //   340: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   343: invokevirtual   instrumented/java/util/logging/LogRecord.getSourceClassName:()Ljava/lang/String;
        //   346: ldc             1
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: ifnull          407
        //   354: aload_2        
        //   355: ldc             "  <class>"
        //   357: ldc             3
        //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   362: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   365: pop            
        //   366: ldc             1
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: aload_0        
        //   372: aload_2        
        //   373: aload_1        
        //   374: ldc             4
        //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   379: invokevirtual   instrumented/java/util/logging/LogRecord.getSourceClassName:()Ljava/lang/String;
        //   382: ldc             1
        //   384: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   387: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   390: aload_2        
        //   391: ldc             "</class>\n"
        //   393: ldc             3
        //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   398: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   401: pop            
        //   402: ldc             1
        //   404: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   407: aload_1        
        //   408: ldc             2
        //   410: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   413: invokevirtual   instrumented/java/util/logging/LogRecord.getSourceMethodName:()Ljava/lang/String;
        //   416: ldc             1
        //   418: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   421: ifnull          477
        //   424: aload_2        
        //   425: ldc             "  <method>"
        //   427: ldc             3
        //   429: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   432: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   435: pop            
        //   436: ldc             1
        //   438: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   441: aload_0        
        //   442: aload_2        
        //   443: aload_1        
        //   444: ldc             4
        //   446: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   449: invokevirtual   instrumented/java/util/logging/LogRecord.getSourceMethodName:()Ljava/lang/String;
        //   452: ldc             1
        //   454: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   457: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   460: aload_2        
        //   461: ldc             "</method>\n"
        //   463: ldc             3
        //   465: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   468: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   471: pop            
        //   472: ldc             1
        //   474: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   477: aload_2        
        //   478: ldc             "  <thread>"
        //   480: ldc             3
        //   482: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   485: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   488: pop            
        //   489: ldc             1
        //   491: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   494: aload_2        
        //   495: aload_1        
        //   496: ldc             3
        //   498: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   501: invokevirtual   instrumented/java/util/logging/LogRecord.getThreadID:()I
        //   504: ldc             1
        //   506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   509: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   512: pop            
        //   513: ldc             1
        //   515: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   518: aload_2        
        //   519: ldc             "</thread>\n"
        //   521: ldc             3
        //   523: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   526: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   529: pop            
        //   530: ldc             1
        //   532: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   535: aload_1        
        //   536: ldc             2
        //   538: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   541: invokevirtual   instrumented/java/util/logging/LogRecord.getMessage:()Ljava/lang/String;
        //   544: ldc             1
        //   546: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   549: ifnull          632
        //   552: aload_0        
        //   553: aload_1        
        //   554: ldc             3
        //   556: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   559: invokevirtual   instrumented/java/util/logging/XMLFormatter.formatMessage:(Linstrumented/java/util/logging/LogRecord;)Ljava/lang/String;
        //   562: astore          4
        //   564: ldc             1
        //   566: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   569: aload_2        
        //   570: ldc             "  <message>"
        //   572: ldc             3
        //   574: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   577: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   580: pop            
        //   581: ldc             1
        //   583: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   586: aload_0        
        //   587: aload_2        
        //   588: aload           4
        //   590: ldc             4
        //   592: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   595: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   598: aload_2        
        //   599: ldc             "</message>"
        //   601: ldc             3
        //   603: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   606: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   609: pop            
        //   610: ldc             1
        //   612: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   615: aload_2        
        //   616: ldc             "\n"
        //   618: ldc             3
        //   620: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   623: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   626: pop            
        //   627: ldc             1
        //   629: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   632: aload_1        
        //   633: ldc             2
        //   635: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   638: invokevirtual   instrumented/java/util/logging/LogRecord.getResourceBundle:()Linstrumented/java/util/ResourceBundle;
        //   641: astore          4
        //   643: ldc             1
        //   645: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   648: aload           4
        //   650: ldc             2
        //   652: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   655: ifnull          791
        //   658: aload           4
        //   660: aload_1        
        //   661: ldc             3
        //   663: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   666: invokevirtual   instrumented/java/util/logging/LogRecord.getMessage:()Ljava/lang/String;
        //   669: ldc             1
        //   671: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   674: invokevirtual   instrumented/java/util/ResourceBundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   677: ldc             1
        //   679: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   682: ifnull          791
        //   685: aload_2        
        //   686: ldc             "  <key>"
        //   688: ldc             3
        //   690: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   693: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   696: pop            
        //   697: ldc             1
        //   699: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   702: aload_0        
        //   703: aload_2        
        //   704: aload_1        
        //   705: ldc             4
        //   707: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   710: invokevirtual   instrumented/java/util/logging/LogRecord.getMessage:()Ljava/lang/String;
        //   713: ldc             1
        //   715: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   718: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   721: aload_2        
        //   722: ldc             "</key>\n"
        //   724: ldc             3
        //   726: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   729: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   732: pop            
        //   733: ldc             1
        //   735: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   738: aload_2        
        //   739: ldc             "  <catalog>"
        //   741: ldc             3
        //   743: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   746: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   749: pop            
        //   750: ldc             1
        //   752: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   755: aload_0        
        //   756: aload_2        
        //   757: aload_1        
        //   758: ldc             4
        //   760: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   763: invokevirtual   instrumented/java/util/logging/LogRecord.getResourceBundleName:()Ljava/lang/String;
        //   766: ldc             1
        //   768: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   771: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   774: aload_2        
        //   775: ldc             "</catalog>\n"
        //   777: ldc             3
        //   779: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   782: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   785: pop            
        //   786: ldc             1
        //   788: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   791: ldc             1
        //   793: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   796: goto            806
        //   799: astore          5
        //   801: ldc             501
        //   803: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   806: aload_1        
        //   807: ldc             2
        //   809: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   812: invokevirtual   instrumented/java/util/logging/LogRecord.getParameters:()[Ljava/lang/Object;
        //   815: astore          5
        //   817: ldc             1
        //   819: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   822: aload           5
        //   824: ldc             2
        //   826: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   829: ifnull          997
        //   832: aload           5
        //   834: arraylength    
        //   835: ldc             3
        //   837: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   840: ifeq            997
        //   843: aload_1        
        //   844: ldc             1
        //   846: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   849: ldc             1
        //   851: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   854: invokevirtual   instrumented/java/util/logging/LogRecord.getMessage:()Ljava/lang/String;
        //   857: ldc             "{"
        //   859: ldc             2
        //   861: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   864: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   867: iconst_m1      
        //   868: ldc             2
        //   870: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   873: if_icmpne       997
        //   876: iconst_0       
        //   877: istore          6
        //   879: ldc             2
        //   881: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   884: iload           6
        //   886: aload           5
        //   888: arraylength    
        //   889: ldc             4
        //   891: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   894: if_icmpge       997
        //   897: aload_2        
        //   898: ldc             "  <param>"
        //   900: ldc             3
        //   902: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   905: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   908: pop            
        //   909: ldc             1
        //   911: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   914: aload_0        
        //   915: aload_2        
        //   916: aload           5
        //   918: iload           6
        //   920: aaload         
        //   921: ldc             6
        //   923: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   926: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   929: ldc             1
        //   931: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   934: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //   937: ldc             1
        //   939: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   942: goto            969
        //   945: astore          7
        //   947: ldc             501
        //   949: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   952: aload_2        
        //   953: ldc             "???"
        //   955: ldc             3
        //   957: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   960: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   963: pop            
        //   964: ldc             1
        //   966: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   969: aload_2        
        //   970: ldc             "</param>\n"
        //   972: ldc             3
        //   974: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   977: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   980: pop            
        //   981: ldc             1
        //   983: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   986: iinc            6, 1
        //   989: ldc             2
        //   991: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   994: goto            884
        //   997: aload_1        
        //   998: ldc             2
        //  1000: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1003: invokevirtual   instrumented/java/util/logging/LogRecord.getThrown:()Ljava/lang/Throwable;
        //  1006: ldc             1
        //  1008: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1011: ifnull          1400
        //  1014: aload_1        
        //  1015: ldc             2
        //  1017: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1020: invokevirtual   instrumented/java/util/logging/LogRecord.getThrown:()Ljava/lang/Throwable;
        //  1023: astore          6
        //  1025: ldc             1
        //  1027: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1030: aload_2        
        //  1031: ldc             "  <exception>\n"
        //  1033: ldc             3
        //  1035: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1038: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1041: pop            
        //  1042: ldc             1
        //  1044: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1047: aload_2        
        //  1048: ldc             "    <message>"
        //  1050: ldc             3
        //  1052: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1055: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1058: pop            
        //  1059: ldc             1
        //  1061: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1064: aload_0        
        //  1065: aload_2        
        //  1066: aload           6
        //  1068: ldc             4
        //  1070: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1073: invokevirtual   java/lang/Throwable.toString:()Ljava/lang/String;
        //  1076: ldc             1
        //  1078: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1081: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //  1084: aload_2        
        //  1085: ldc             "</message>\n"
        //  1087: ldc             3
        //  1089: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1092: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1095: pop            
        //  1096: ldc             1
        //  1098: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1101: aload           6
        //  1103: ldc             2
        //  1105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1108: invokevirtual   java/lang/Throwable.getStackTrace:()[Ljava/lang/StackTraceElement;
        //  1111: astore          7
        //  1113: ldc             1
        //  1115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1118: iconst_0       
        //  1119: istore          8
        //  1121: ldc             2
        //  1123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1126: iload           8
        //  1128: aload           7
        //  1130: arraylength    
        //  1131: ldc             4
        //  1133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1136: if_icmpge       1382
        //  1139: aload           7
        //  1141: iload           8
        //  1143: aaload         
        //  1144: astore          9
        //  1146: ldc             4
        //  1148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1151: aload_2        
        //  1152: ldc             "    <frame>\n"
        //  1154: ldc             3
        //  1156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1159: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1162: pop            
        //  1163: ldc             1
        //  1165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1168: aload_2        
        //  1169: ldc             "      <class>"
        //  1171: ldc             3
        //  1173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1176: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1179: pop            
        //  1180: ldc             1
        //  1182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1185: aload_0        
        //  1186: aload_2        
        //  1187: aload           9
        //  1189: ldc             4
        //  1191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1194: invokevirtual   java/lang/StackTraceElement.getClassName:()Ljava/lang/String;
        //  1197: ldc             1
        //  1199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1202: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //  1205: aload_2        
        //  1206: ldc             "</class>\n"
        //  1208: ldc             3
        //  1210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1213: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1216: pop            
        //  1217: ldc             1
        //  1219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1222: aload_2        
        //  1223: ldc             "      <method>"
        //  1225: ldc             3
        //  1227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1230: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1233: pop            
        //  1234: ldc             1
        //  1236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1239: aload_0        
        //  1240: aload_2        
        //  1241: aload           9
        //  1243: ldc             4
        //  1245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1248: invokevirtual   java/lang/StackTraceElement.getMethodName:()Ljava/lang/String;
        //  1251: ldc             1
        //  1253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1256: invokespecial   instrumented/java/util/logging/XMLFormatter.escape:(Ljava/lang/StringBuilder;Ljava/lang/String;)V
        //  1259: aload_2        
        //  1260: ldc             "</method>\n"
        //  1262: ldc             3
        //  1264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1267: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1270: pop            
        //  1271: ldc             1
        //  1273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1276: aload           9
        //  1278: ldc             2
        //  1280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1283: invokevirtual   java/lang/StackTraceElement.getLineNumber:()I
        //  1286: ldc             1
        //  1288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1291: iflt            1353
        //  1294: aload_2        
        //  1295: ldc             "      <line>"
        //  1297: ldc             3
        //  1299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1302: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1305: pop            
        //  1306: ldc             1
        //  1308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1311: aload_2        
        //  1312: aload           9
        //  1314: ldc             3
        //  1316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1319: invokevirtual   java/lang/StackTraceElement.getLineNumber:()I
        //  1322: ldc             1
        //  1324: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1327: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //  1330: pop            
        //  1331: ldc             1
        //  1333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1336: aload_2        
        //  1337: ldc             "</line>\n"
        //  1339: ldc             3
        //  1341: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1344: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1347: pop            
        //  1348: ldc             1
        //  1350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1353: aload_2        
        //  1354: ldc_w           "    </frame>\n"
        //  1357: ldc             3
        //  1359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1362: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1365: pop            
        //  1366: ldc             1
        //  1368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1371: iinc            8, 1
        //  1374: ldc             2
        //  1376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1379: goto            1126
        //  1382: aload_2        
        //  1383: ldc_w           "  </exception>\n"
        //  1386: ldc             3
        //  1388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1391: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1394: pop            
        //  1395: ldc             1
        //  1397: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1400: aload_2        
        //  1401: ldc_w           "</record>\n"
        //  1404: ldc             3
        //  1406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1409: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1412: pop            
        //  1413: ldc             1
        //  1415: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1418: aload_2        
        //  1419: ldc             2
        //  1421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1424: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1427: ldc             1
        //  1429: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1432: areturn        
        //  1433: athrow         
        //  1434: athrow         
        //    StackMapTable: 00 11 FD 01 14 07 00 21 07 00 40 FB 00 82 FB 00 45 FB 00 9A FC 00 9E 07 00 B3 47 07 00 57 06 FD 00 4D 07 00 CF 01 7C 07 00 57 17 FA 00 1B FE 00 80 07 00 1C 07 00 EA 01 FC 00 E2 07 00 F0 F9 00 1C F9 00 11 FF 00 20 00 00 00 01 07 00 1C FF 00 00 00 00 00 01 07 00 55
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  648    1434   1434   1435   Ljava/lang/VirtualMachineError;
        //  648    791    799    806    Ljava/lang/Exception;
        //  914    937    945    969    Ljava/lang/Exception;
        //  0      1433   1433   1434   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0791:
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
    
    @Override
    public String getHead(final Handler p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokespecial   java/lang/StringBuilder.<init>:()V
        //    12: astore_2       
        //    13: ldc             1
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: aload_2        
        //    19: ldc_w           "<?xml version=\"1.0\""
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    30: pop            
        //    31: ldc             1
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: aload_1        
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: ifnull          63
        //    45: aload_1        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: invokevirtual   instrumented/java/util/logging/Handler.getEncoding:()Ljava/lang/String;
        //    54: astore_3       
        //    55: ldc             2
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: goto            70
        //    63: aconst_null    
        //    64: astore_3       
        //    65: ldc             2
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: aload_3        
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ifnonnull       101
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokestatic    java/nio/charset/Charset.defaultCharset:()Ljava/nio/charset/Charset;
        //    87: ldc             1
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokevirtual   java/nio/charset/Charset.name:()Ljava/lang/String;
        //    95: astore_3       
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: aload_3        
        //   102: ldc             2
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokestatic    java/nio/charset/Charset.forName:(Ljava/lang/String;)Ljava/nio/charset/Charset;
        //   110: astore          4
        //   112: ldc             1
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: aload           4
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokevirtual   java/nio/charset/Charset.name:()Ljava/lang/String;
        //   127: astore_3       
        //   128: ldc             1
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: goto            148
        //   141: astore          4
        //   143: ldc             501
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: aload_2        
        //   149: ldc_w           " encoding=\""
        //   152: ldc             3
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: pop            
        //   161: ldc             1
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload_2        
        //   167: aload_3        
        //   168: ldc             3
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: pop            
        //   177: ldc             1
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: aload_2        
        //   183: ldc_w           "\""
        //   186: ldc             3
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   194: pop            
        //   195: ldc             1
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: aload_2        
        //   201: ldc_w           " standalone=\"no\"?>\n"
        //   204: ldc             3
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: pop            
        //   213: ldc             1
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: aload_2        
        //   219: ldc_w           "<!DOCTYPE log SYSTEM \"logger.dtd\">\n"
        //   222: ldc             3
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   230: pop            
        //   231: ldc             1
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: aload_2        
        //   237: ldc_w           "<log>\n"
        //   240: ldc             3
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   248: pop            
        //   249: ldc             1
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: aload_2        
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: areturn        
        //   269: athrow         
        //   270: athrow         
        //    StackMapTable: 00 07 FC 00 3F 07 00 21 FC 00 06 07 00 40 1E 67 07 00 57 06 FF 00 78 00 00 00 01 07 00 1C FF 00 00 00 00 00 01 07 00 55
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  101    270    270    271    Ljava/lang/VirtualMachineError;
        //  101    133    141    148    Ljava/lang/Exception;
        //  0      269    269    270    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0101:
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
    
    @Override
    public String getTail(final Handler handler) {
        try {
            final String s = "</log>\n";
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
