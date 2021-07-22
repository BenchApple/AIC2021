// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.math;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
import java.io.PrintStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.io.ObjectInputStream;
import aic2021.engine.BytecodeManager;

public class BigDecimal extends Number implements Comparable<BigDecimal>
{
    private final BigInteger intVal;
    private final int scale;
    private transient int precision;
    private transient String stringCache;
    static final long INFLATED = Long.MIN_VALUE;
    private static final BigInteger INFLATED_BIGINT;
    private final transient long intCompact;
    private static final int MAX_COMPACT_DIGITS = 18;
    private static final long serialVersionUID = 6108874887143696463L;
    private static final ThreadLocal<StringBuilderHelper> threadLocalStringBuilderHelper;
    private static final BigDecimal[] zeroThroughTen;
    private static final BigDecimal[] ZERO_SCALED_BY;
    private static final long HALF_LONG_MAX_VALUE = 4611686018427387903L;
    private static final long HALF_LONG_MIN_VALUE = -4611686018427387904L;
    public static final BigDecimal ZERO;
    public static final BigDecimal ONE;
    public static final BigDecimal TEN;
    public static final int ROUND_UP = 0;
    public static final int ROUND_DOWN = 1;
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_FLOOR = 3;
    public static final int ROUND_HALF_UP = 4;
    public static final int ROUND_HALF_DOWN = 5;
    public static final int ROUND_HALF_EVEN = 6;
    public static final int ROUND_UNNECESSARY = 7;
    private static final double[] double10pow;
    private static final float[] float10pow;
    private static final long[] LONG_TEN_POWERS_TABLE;
    private static volatile BigInteger[] BIG_TEN_POWERS_TABLE;
    private static final int BIG_TEN_POWERS_TABLE_INITLEN;
    private static final int BIG_TEN_POWERS_TABLE_MAX;
    private static final long[] THRESHOLDS_TABLE;
    private static final long DIV_NUM_BASE = 4294967296L;
    private static final long[][] LONGLONG_TEN_POWERS_TABLE;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    BigDecimal(final BigInteger intVal, final long intCompact, final int scale, final int precision) {
        try {
            BytecodeManager.incBytecodes(2);
            this.scale = scale;
            BytecodeManager.incBytecodes(3);
            this.precision = precision;
            BytecodeManager.incBytecodes(3);
            this.intCompact = intCompact;
            BytecodeManager.incBytecodes(3);
            this.intVal = intVal;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final char[] array, final int n, final int n2) {
        try {
            final MathContext unlimited = MathContext.UNLIMITED;
            BytecodeManager.incBytecodes(6);
            this(array, n, n2, unlimited);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final char[] p0, final int p1, final int p2, final MathContext p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   java/lang/Number.<init>:()V
        //     9: iload_2        
        //    10: iload_3        
        //    11: iadd           
        //    12: aload_1        
        //    13: arraylength    
        //    14: ldc             6
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: if_icmpgt       31
        //    22: iload_2        
        //    23: ldc             2
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ifge            51
        //    31: new             Ljava/lang/NumberFormatException;
        //    34: dup            
        //    35: ldc             "Bad offset or len arguments for char[] input."
        //    37: ldc             4
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokespecial   java/lang/NumberFormatException.<init>:(Ljava/lang/String;)V
        //    45: ldc             1
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: athrow         
        //    51: iconst_0       
        //    52: istore          5
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: iconst_0       
        //    60: istore          6
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: lconst_0       
        //    68: lstore          7
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aconst_null    
        //    76: astore          9
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: iconst_0       
        //    84: istore          10
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_1        
        //    92: iload_2        
        //    93: caload         
        //    94: bipush          45
        //    96: ldc             5
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: if_icmpne       131
        //   104: iconst_1       
        //   105: istore          10
        //   107: ldc             2
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: iinc            2, 1
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: iinc            3, -1
        //   123: ldc             2
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: goto            160
        //   131: aload_1        
        //   132: iload_2        
        //   133: caload         
        //   134: bipush          43
        //   136: ldc             5
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: if_icmpne       160
        //   144: iinc            2, 1
        //   147: ldc             1
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: iinc            3, -1
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: iconst_0       
        //   161: istore          11
        //   163: ldc             2
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: lconst_0       
        //   169: lstore          12
        //   171: ldc             2
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: iload_3        
        //   177: bipush          18
        //   179: ldc             3
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: if_icmpgt       196
        //   187: iconst_1       
        //   188: ldc             2
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: goto            202
        //   196: iconst_0       
        //   197: ldc             1
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: istore          15
        //   204: ldc             1
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: iconst_0       
        //   210: istore          16
        //   212: ldc             2
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: iload           15
        //   219: ldc             2
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: ifeq            1021
        //   227: iload_3        
        //   228: ldc             2
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: ifle            779
        //   236: aload_1        
        //   237: iload_2        
        //   238: caload         
        //   239: istore          14
        //   241: ldc             4
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: iload           14
        //   248: bipush          48
        //   250: ldc             3
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: if_icmpne       333
        //   258: iload           5
        //   260: ldc             2
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: ifne            279
        //   268: iconst_1       
        //   269: istore          5
        //   271: ldc             3
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: goto            312
        //   279: lload           7
        //   281: lconst_0       
        //   282: lcmp           
        //   283: ldc             4
        //   285: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   288: ifeq            312
        //   291: lload           7
        //   293: ldc2_w          10
        //   296: lmul           
        //   297: lstore          7
        //   299: ldc             4
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: iinc            5, 1
        //   307: ldc             1
        //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   312: iload           11
        //   314: ldc             2
        //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   319: ifeq            765
        //   322: iinc            6, 1
        //   325: ldc             2
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: goto            765
        //   333: iload           14
        //   335: bipush          49
        //   337: ldc             3
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: if_icmplt       443
        //   345: iload           14
        //   347: bipush          57
        //   349: ldc             3
        //   351: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   354: if_icmpgt       443
        //   357: iload           14
        //   359: bipush          48
        //   361: isub           
        //   362: istore          17
        //   364: ldc             4
        //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   369: iload           5
        //   371: iconst_1       
        //   372: ldc             3
        //   374: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   377: if_icmpne       392
        //   380: lload           7
        //   382: lconst_0       
        //   383: lcmp           
        //   384: ldc             4
        //   386: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   389: ifeq            400
        //   392: iinc            5, 1
        //   395: ldc             1
        //   397: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   400: lload           7
        //   402: ldc2_w          10
        //   405: lmul           
        //   406: iload           17
        //   408: i2l            
        //   409: ladd           
        //   410: lstore          7
        //   412: ldc             7
        //   414: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   417: iload           11
        //   419: ldc             2
        //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   424: ifeq            435
        //   427: iinc            6, 1
        //   430: ldc             1
        //   432: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   435: ldc             1
        //   437: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   440: goto            765
        //   443: iload           14
        //   445: bipush          46
        //   447: ldc             3
        //   449: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   452: if_icmpne       494
        //   455: iload           11
        //   457: ldc             2
        //   459: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   462: ifeq            483
        //   465: new             Ljava/lang/NumberFormatException;
        //   468: dup            
        //   469: ldc             3
        //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   474: invokespecial   java/lang/NumberFormatException.<init>:()V
        //   477: ldc             1
        //   479: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   482: athrow         
        //   483: iconst_1       
        //   484: istore          11
        //   486: ldc             3
        //   488: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   491: goto            765
        //   494: iload           14
        //   496: ldc             2
        //   498: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   501: invokestatic    java/lang/Character.isDigit:(C)Z
        //   504: ldc             1
        //   506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   509: ifeq            672
        //   512: iload           14
        //   514: bipush          10
        //   516: ldc             3
        //   518: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   521: invokestatic    java/lang/Character.digit:(CI)I
        //   524: istore          17
        //   526: ldc             1
        //   528: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   531: iload           17
        //   533: ldc             2
        //   535: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   538: ifne            598
        //   541: iload           5
        //   543: ldc             2
        //   545: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   548: ifne            562
        //   551: iconst_1       
        //   552: istore          5
        //   554: ldc             3
        //   556: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   559: goto            646
        //   562: lload           7
        //   564: lconst_0       
        //   565: lcmp           
        //   566: ldc             4
        //   568: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   571: ifeq            646
        //   574: lload           7
        //   576: ldc2_w          10
        //   579: lmul           
        //   580: lstore          7
        //   582: ldc             4
        //   584: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   587: iinc            5, 1
        //   590: ldc             2
        //   592: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   595: goto            646
        //   598: iload           5
        //   600: iconst_1       
        //   601: ldc             3
        //   603: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   606: if_icmpne       621
        //   609: lload           7
        //   611: lconst_0       
        //   612: lcmp           
        //   613: ldc             4
        //   615: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   618: ifeq            629
        //   621: iinc            5, 1
        //   624: ldc             1
        //   626: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   629: lload           7
        //   631: ldc2_w          10
        //   634: lmul           
        //   635: iload           17
        //   637: i2l            
        //   638: ladd           
        //   639: lstore          7
        //   641: ldc             7
        //   643: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   646: iload           11
        //   648: ldc             2
        //   650: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   653: ifeq            664
        //   656: iinc            6, 1
        //   659: ldc             1
        //   661: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   664: ldc             1
        //   666: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   669: goto            765
        //   672: iload           14
        //   674: bipush          101
        //   676: ldc             3
        //   678: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   681: if_icmpeq       696
        //   684: iload           14
        //   686: bipush          69
        //   688: ldc             3
        //   690: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   693: if_icmpne       747
        //   696: aload_1        
        //   697: iload_2        
        //   698: iload_3        
        //   699: ldc             4
        //   701: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   704: invokestatic    instrumented/java/math/BigDecimal.parseExp:([CII)J
        //   707: lstore          12
        //   709: ldc             1
        //   711: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   714: lload           12
        //   716: l2i            
        //   717: i2l            
        //   718: lload           12
        //   720: lcmp           
        //   721: ldc             6
        //   723: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   726: ifeq            779
        //   729: new             Ljava/lang/NumberFormatException;
        //   732: dup            
        //   733: ldc             3
        //   735: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   738: invokespecial   java/lang/NumberFormatException.<init>:()V
        //   741: ldc             1
        //   743: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   746: athrow         
        //   747: new             Ljava/lang/NumberFormatException;
        //   750: dup            
        //   751: ldc             3
        //   753: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   756: invokespecial   java/lang/NumberFormatException.<init>:()V
        //   759: ldc             1
        //   761: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   764: athrow         
        //   765: iinc            2, 1
        //   768: iinc            3, -1
        //   771: ldc             3
        //   773: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   776: goto            227
        //   779: iload           5
        //   781: ldc             2
        //   783: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   786: ifne            807
        //   789: new             Ljava/lang/NumberFormatException;
        //   792: dup            
        //   793: ldc             3
        //   795: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   798: invokespecial   java/lang/NumberFormatException.<init>:()V
        //   801: ldc             1
        //   803: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   806: athrow         
        //   807: lload           12
        //   809: lconst_0       
        //   810: lcmp           
        //   811: ldc             4
        //   813: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   816: ifeq            839
        //   819: aload_0        
        //   820: iload           6
        //   822: lload           12
        //   824: ldc             4
        //   826: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   829: invokespecial   instrumented/java/math/BigDecimal.adjustScale:(IJ)I
        //   832: istore          6
        //   834: ldc             1
        //   836: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   839: iload           10
        //   841: ldc             2
        //   843: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   846: ifeq            860
        //   849: lload           7
        //   851: lneg           
        //   852: ldc             3
        //   854: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   857: goto            867
        //   860: lload           7
        //   862: ldc             1
        //   864: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   867: lstore          7
        //   869: ldc             1
        //   871: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   874: aload           4
        //   876: getfield        instrumented/java/math/MathContext.precision:I
        //   879: istore          17
        //   881: ldc             3
        //   883: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   886: iload           5
        //   888: iload           17
        //   890: isub           
        //   891: istore          18
        //   893: ldc             4
        //   895: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   898: iload           17
        //   900: ldc             2
        //   902: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   905: ifle            1013
        //   908: iload           18
        //   910: ldc             2
        //   912: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   915: ifle            1013
        //   918: iload           18
        //   920: ldc             2
        //   922: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   925: ifle            1013
        //   928: iload           6
        //   930: i2l            
        //   931: iload           18
        //   933: i2l            
        //   934: lsub           
        //   935: ldc             6
        //   937: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   940: invokestatic    instrumented/java/math/BigDecimal.checkScaleNonZero:(J)I
        //   943: istore          6
        //   945: ldc             1
        //   947: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   950: lload           7
        //   952: getstatic       instrumented/java/math/BigDecimal.LONG_TEN_POWERS_TABLE:[J
        //   955: iload           18
        //   957: laload         
        //   958: aload           4
        //   960: getfield        instrumented/java/math/MathContext.roundingMode:Linstrumented/java/math/RoundingMode;
        //   963: getfield        instrumented/java/math/RoundingMode.oldMode:I
        //   966: ldc             8
        //   968: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   971: invokestatic    instrumented/java/math/BigDecimal.divideAndRound:(JJI)J
        //   974: lstore          7
        //   976: ldc             1
        //   978: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   981: lload           7
        //   983: ldc             2
        //   985: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   988: invokestatic    instrumented/java/math/BigDecimal.longDigitLength:(J)I
        //   991: istore          5
        //   993: ldc             1
        //   995: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   998: iload           5
        //  1000: iload           17
        //  1002: isub           
        //  1003: istore          18
        //  1005: ldc             5
        //  1007: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1010: goto            918
        //  1013: ldc             1
        //  1015: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1018: goto            1882
        //  1021: iload_3        
        //  1022: newarray        C
        //  1024: astore          17
        //  1026: ldc             2
        //  1028: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1031: iload_3        
        //  1032: ldc             2
        //  1034: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1037: ifle            1421
        //  1040: aload_1        
        //  1041: iload_2        
        //  1042: caload         
        //  1043: istore          14
        //  1045: ldc             4
        //  1047: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1050: iload           14
        //  1052: bipush          48
        //  1054: ldc             3
        //  1056: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1059: if_icmplt       1074
        //  1062: iload           14
        //  1064: bipush          57
        //  1066: ldc             3
        //  1068: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1071: if_icmple       1092
        //  1074: iload           14
        //  1076: ldc             2
        //  1078: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1081: invokestatic    java/lang/Character.isDigit:(C)Z
        //  1084: ldc             1
        //  1086: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1089: ifeq            1258
        //  1092: iload           14
        //  1094: bipush          48
        //  1096: ldc             3
        //  1098: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1101: if_icmpeq       1124
        //  1104: iload           14
        //  1106: bipush          10
        //  1108: ldc             3
        //  1110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1113: invokestatic    java/lang/Character.digit:(CI)I
        //  1116: ldc             1
        //  1118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1121: ifne            1193
        //  1124: iload           5
        //  1126: ldc             2
        //  1128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1131: ifne            1157
        //  1134: aload           17
        //  1136: iload           16
        //  1138: iload           14
        //  1140: castore        
        //  1141: ldc             4
        //  1143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1146: iconst_1       
        //  1147: istore          5
        //  1149: ldc             3
        //  1151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1154: goto            1237
        //  1157: iload           16
        //  1159: ldc             2
        //  1161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1164: ifeq            1237
        //  1167: aload           17
        //  1169: iload           16
        //  1171: iinc            16, 1
        //  1174: iload           14
        //  1176: castore        
        //  1177: ldc             5
        //  1179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1182: iinc            5, 1
        //  1185: ldc             2
        //  1187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1190: goto            1237
        //  1193: iload           5
        //  1195: iconst_1       
        //  1196: ldc             3
        //  1198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1201: if_icmpne       1214
        //  1204: iload           16
        //  1206: ldc             2
        //  1208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1211: ifeq            1222
        //  1214: iinc            5, 1
        //  1217: ldc             1
        //  1219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1222: aload           17
        //  1224: iload           16
        //  1226: iinc            16, 1
        //  1229: iload           14
        //  1231: castore        
        //  1232: ldc             5
        //  1234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1237: iload           11
        //  1239: ldc             2
        //  1241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1244: ifeq            1407
        //  1247: iinc            6, 1
        //  1250: ldc             2
        //  1252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1255: goto            1407
        //  1258: iload           14
        //  1260: bipush          46
        //  1262: ldc             3
        //  1264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1267: if_icmpne       1314
        //  1270: iload           11
        //  1272: ldc             2
        //  1274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1277: ifeq            1298
        //  1280: new             Ljava/lang/NumberFormatException;
        //  1283: dup            
        //  1284: ldc             3
        //  1286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1289: invokespecial   java/lang/NumberFormatException.<init>:()V
        //  1292: ldc             1
        //  1294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1297: athrow         
        //  1298: iconst_1       
        //  1299: istore          11
        //  1301: ldc             2
        //  1303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1306: ldc             1
        //  1308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1311: goto            1407
        //  1314: iload           14
        //  1316: bipush          101
        //  1318: ldc             3
        //  1320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1323: if_icmpeq       1356
        //  1326: iload           14
        //  1328: bipush          69
        //  1330: ldc             3
        //  1332: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1335: if_icmpeq       1356
        //  1338: new             Ljava/lang/NumberFormatException;
        //  1341: dup            
        //  1342: ldc             3
        //  1344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1347: invokespecial   java/lang/NumberFormatException.<init>:()V
        //  1350: ldc             1
        //  1352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1355: athrow         
        //  1356: aload_1        
        //  1357: iload_2        
        //  1358: iload_3        
        //  1359: ldc             4
        //  1361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1364: invokestatic    instrumented/java/math/BigDecimal.parseExp:([CII)J
        //  1367: lstore          12
        //  1369: ldc             1
        //  1371: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1374: lload           12
        //  1376: l2i            
        //  1377: i2l            
        //  1378: lload           12
        //  1380: lcmp           
        //  1381: ldc             6
        //  1383: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1386: ifeq            1421
        //  1389: new             Ljava/lang/NumberFormatException;
        //  1392: dup            
        //  1393: ldc             3
        //  1395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1398: invokespecial   java/lang/NumberFormatException.<init>:()V
        //  1401: ldc             1
        //  1403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1406: athrow         
        //  1407: iinc            2, 1
        //  1410: iinc            3, -1
        //  1413: ldc             3
        //  1415: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1418: goto            1031
        //  1421: iload           5
        //  1423: ldc             2
        //  1425: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1428: ifne            1449
        //  1431: new             Ljava/lang/NumberFormatException;
        //  1434: dup            
        //  1435: ldc             3
        //  1437: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1440: invokespecial   java/lang/NumberFormatException.<init>:()V
        //  1443: ldc             1
        //  1445: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1448: athrow         
        //  1449: lload           12
        //  1451: lconst_0       
        //  1452: lcmp           
        //  1453: ldc             4
        //  1455: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1458: ifeq            1481
        //  1461: aload_0        
        //  1462: iload           6
        //  1464: lload           12
        //  1466: ldc             4
        //  1468: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1471: invokespecial   instrumented/java/math/BigDecimal.adjustScale:(IJ)I
        //  1474: istore          6
        //  1476: ldc             1
        //  1478: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1481: new             Linstrumented/java/math/BigInteger;
        //  1484: dup            
        //  1485: aload           17
        //  1487: iload           10
        //  1489: ldc             5
        //  1491: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1494: ifeq            1506
        //  1497: iconst_m1      
        //  1498: ldc             2
        //  1500: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1503: goto            1512
        //  1506: iconst_1       
        //  1507: ldc             1
        //  1509: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1512: iload           5
        //  1514: ldc             2
        //  1516: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1519: invokespecial   instrumented/java/math/BigInteger.<init>:([CII)V
        //  1522: astore          9
        //  1524: ldc             1
        //  1526: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1529: aload           9
        //  1531: ldc             2
        //  1533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1536: invokestatic    instrumented/java/math/BigDecimal.compactValFor:(Linstrumented/java/math/BigInteger;)J
        //  1539: lstore          7
        //  1541: ldc             1
        //  1543: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1546: aload           4
        //  1548: getfield        instrumented/java/math/MathContext.precision:I
        //  1551: istore          18
        //  1553: ldc             3
        //  1555: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1558: iload           18
        //  1560: ldc             2
        //  1562: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1565: ifle            1882
        //  1568: iload           5
        //  1570: iload           18
        //  1572: ldc             3
        //  1574: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1577: if_icmple       1882
        //  1580: lload           7
        //  1582: ldc2_w          -9223372036854775808
        //  1585: lcmp           
        //  1586: ldc             4
        //  1588: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1591: ifne            1753
        //  1594: iload           5
        //  1596: iload           18
        //  1598: isub           
        //  1599: istore          19
        //  1601: ldc             4
        //  1603: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1606: iload           19
        //  1608: ldc             2
        //  1610: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1613: ifle            1753
        //  1616: iload           6
        //  1618: i2l            
        //  1619: iload           19
        //  1621: i2l            
        //  1622: lsub           
        //  1623: ldc             6
        //  1625: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1628: invokestatic    instrumented/java/math/BigDecimal.checkScaleNonZero:(J)I
        //  1631: istore          6
        //  1633: ldc             1
        //  1635: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1638: aload           9
        //  1640: iload           19
        //  1642: aload           4
        //  1644: getfield        instrumented/java/math/MathContext.roundingMode:Linstrumented/java/math/RoundingMode;
        //  1647: getfield        instrumented/java/math/RoundingMode.oldMode:I
        //  1650: ldc             6
        //  1652: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1655: invokestatic    instrumented/java/math/BigDecimal.divideAndRoundByTenPow:(Linstrumented/java/math/BigInteger;II)Linstrumented/java/math/BigInteger;
        //  1658: astore          9
        //  1660: ldc             1
        //  1662: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1665: aload           9
        //  1667: ldc             2
        //  1669: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1672: invokestatic    instrumented/java/math/BigDecimal.compactValFor:(Linstrumented/java/math/BigInteger;)J
        //  1675: lstore          7
        //  1677: ldc             1
        //  1679: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1682: lload           7
        //  1684: ldc2_w          -9223372036854775808
        //  1687: lcmp           
        //  1688: ldc             4
        //  1690: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1693: ifeq            1721
        //  1696: lload           7
        //  1698: ldc             2
        //  1700: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1703: invokestatic    instrumented/java/math/BigDecimal.longDigitLength:(J)I
        //  1706: istore          5
        //  1708: ldc             1
        //  1710: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1713: ldc             1
        //  1715: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1718: goto            1753
        //  1721: aload           9
        //  1723: ldc             2
        //  1725: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1728: invokestatic    instrumented/java/math/BigDecimal.bigDigitLength:(Linstrumented/java/math/BigInteger;)I
        //  1731: istore          5
        //  1733: ldc             1
        //  1735: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1738: iload           5
        //  1740: iload           18
        //  1742: isub           
        //  1743: istore          19
        //  1745: ldc             5
        //  1747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1750: goto            1606
        //  1753: lload           7
        //  1755: ldc2_w          -9223372036854775808
        //  1758: lcmp           
        //  1759: ldc             4
        //  1761: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1764: ifeq            1882
        //  1767: iload           5
        //  1769: iload           18
        //  1771: isub           
        //  1772: istore          19
        //  1774: ldc             4
        //  1776: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1779: iload           19
        //  1781: ldc             2
        //  1783: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1786: ifle            1874
        //  1789: iload           6
        //  1791: i2l            
        //  1792: iload           19
        //  1794: i2l            
        //  1795: lsub           
        //  1796: ldc             6
        //  1798: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1801: invokestatic    instrumented/java/math/BigDecimal.checkScaleNonZero:(J)I
        //  1804: istore          6
        //  1806: ldc             1
        //  1808: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1811: lload           7
        //  1813: getstatic       instrumented/java/math/BigDecimal.LONG_TEN_POWERS_TABLE:[J
        //  1816: iload           19
        //  1818: laload         
        //  1819: aload           4
        //  1821: getfield        instrumented/java/math/MathContext.roundingMode:Linstrumented/java/math/RoundingMode;
        //  1824: getfield        instrumented/java/math/RoundingMode.oldMode:I
        //  1827: ldc             8
        //  1829: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1832: invokestatic    instrumented/java/math/BigDecimal.divideAndRound:(JJI)J
        //  1835: lstore          7
        //  1837: ldc             1
        //  1839: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1842: lload           7
        //  1844: ldc             2
        //  1846: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1849: invokestatic    instrumented/java/math/BigDecimal.longDigitLength:(J)I
        //  1852: istore          5
        //  1854: ldc             1
        //  1856: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1859: iload           5
        //  1861: iload           18
        //  1863: isub           
        //  1864: istore          19
        //  1866: ldc             5
        //  1868: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1871: goto            1779
        //  1874: aconst_null    
        //  1875: astore          9
        //  1877: ldc             2
        //  1879: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1882: ldc             1
        //  1884: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1887: goto            1940
        //  1890: astore          10
        //  1892: ldc             501
        //  1894: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1897: new             Ljava/lang/NumberFormatException;
        //  1900: dup            
        //  1901: ldc             3
        //  1903: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1906: invokespecial   java/lang/NumberFormatException.<init>:()V
        //  1909: ldc             1
        //  1911: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1914: athrow         
        //  1915: astore          10
        //  1917: ldc             501
        //  1919: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1922: new             Ljava/lang/NumberFormatException;
        //  1925: dup            
        //  1926: ldc             3
        //  1928: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1931: invokespecial   java/lang/NumberFormatException.<init>:()V
        //  1934: ldc             1
        //  1936: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1939: athrow         
        //  1940: aload_0        
        //  1941: iload           6
        //  1943: putfield        instrumented/java/math/BigDecimal.scale:I
        //  1946: ldc             3
        //  1948: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1951: aload_0        
        //  1952: iload           5
        //  1954: putfield        instrumented/java/math/BigDecimal.precision:I
        //  1957: ldc             3
        //  1959: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1962: aload_0        
        //  1963: lload           7
        //  1965: putfield        instrumented/java/math/BigDecimal.intCompact:J
        //  1968: ldc             3
        //  1970: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1973: aload_0        
        //  1974: aload           9
        //  1976: putfield        instrumented/java/math/BigDecimal.intVal:Linstrumented/java/math/BigInteger;
        //  1979: ldc             3
        //  1981: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1984: ldc             1
        //  1986: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1989: return         
        //  1990: athrow         
        //  1991: athrow         
        //    StackMapTable: 00 40 FF 00 1F 00 05 07 00 02 07 00 7E 01 01 07 00 6F 00 00 13 FF 00 4F 00 0A 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 01 00 00 1C FD 00 23 01 04 45 01 FE 00 18 00 01 01 FF 00 33 00 0F 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 01 01 04 01 01 01 00 00 20 14 FC 00 3A 01 07 FA 00 22 07 27 0A FC 00 43 01 23 16 07 10 FA 00 11 07 17 32 11 FF 00 0D 00 0F 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 01 01 04 00 01 01 00 00 1B 1F 14 46 04 FD 00 32 01 01 F9 00 5E 07 FC 00 09 07 00 7E FF 00 2A 00 10 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 01 01 04 01 01 01 07 00 7E 00 00 11 1F 20 23 14 07 0E 14 27 0F 29 32 FF 00 0D 00 10 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 01 01 04 00 01 01 07 00 7E 00 00 1B 1F FF 00 18 00 10 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 01 01 04 00 01 01 07 00 7E 00 03 08 05 C9 08 05 C9 07 00 7E FF 00 05 00 10 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 01 01 04 00 01 01 07 00 7E 00 04 08 05 C9 08 05 C9 07 00 7E 01 FD 00 5D 01 01 FB 00 72 FA 00 1F FC 00 19 01 FB 00 5E FF 00 07 00 09 07 00 02 07 00 7E 01 01 07 00 6F 01 01 04 07 00 87 00 00 47 07 00 7A 58 07 00 7C 18 FF 00 31 00 00 00 01 07 00 6C FF 00 00 00 00 00 01 07 00 78
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                      
        //  -----  -----  -----  -----  ------------------------------------------
        //  83     1991   1991   1992   Ljava/lang/VirtualMachineError;
        //  83     1882   1890   1915   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  83     1882   1915   1940   Ljava/lang/NegativeArraySizeException;
        //  0      1990   1990   1991   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0131:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    private int adjustScale(int n, final long n2) {
        try {
            final long n3 = n - n2;
            BytecodeManager.incBytecodes(5);
            final long n4 = lcmp(n3, 2147483647L);
            BytecodeManager.incBytecodes(4);
            if (n4 <= 0) {
                final long n5 = lcmp(n3, -2147483648L);
                BytecodeManager.incBytecodes(4);
                if (n5 >= 0) {
                    n = (int)n3;
                    BytecodeManager.incBytecodes(3);
                    final int n6 = n;
                    BytecodeManager.incBytecodes(2);
                    return n6;
                }
            }
            final String s = "Scale out of range.";
            BytecodeManager.incBytecodes(4);
            final NumberFormatException ex = new NumberFormatException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long parseExp(final char[] array, int n, int n2) {
        try {
            long n3 = 0L;
            BytecodeManager.incBytecodes(2);
            ++n;
            BytecodeManager.incBytecodes(1);
            char c = array[n];
            BytecodeManager.incBytecodes(4);
            --n2;
            BytecodeManager.incBytecodes(1);
            final char c2 = c;
            final int n4 = '-';
            BytecodeManager.incBytecodes(3);
            int n5;
            if (c2 == n4) {
                n5 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n5 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n6 = n5;
            BytecodeManager.incBytecodes(1);
            final int n7 = n6;
            BytecodeManager.incBytecodes(2);
            Label_0115: {
                if (n7 == 0) {
                    final char c3 = c;
                    final int n8 = '+';
                    BytecodeManager.incBytecodes(3);
                    if (c3 != n8) {
                        break Label_0115;
                    }
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                c = array[n];
                BytecodeManager.incBytecodes(4);
                --n2;
                BytecodeManager.incBytecodes(1);
            }
            final int n9 = n2;
            BytecodeManager.incBytecodes(2);
            if (n9 <= 0) {
                BytecodeManager.incBytecodes(3);
                final NumberFormatException ex = new NumberFormatException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            while (true) {
                final int n10 = n2;
                final int n11 = 10;
                BytecodeManager.incBytecodes(3);
                if (n10 <= n11) {
                    break;
                }
                final char c4 = c;
                final int n12 = '0';
                BytecodeManager.incBytecodes(3);
                if (c4 != n12) {
                    final char ch = c;
                    final int radix = 10;
                    BytecodeManager.incBytecodes(3);
                    final int digit = Character.digit(ch, radix);
                    BytecodeManager.incBytecodes(1);
                    if (digit != 0) {
                        break;
                    }
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                c = array[n];
                BytecodeManager.incBytecodes(4);
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n13 = n2;
            final int n14 = 10;
            BytecodeManager.incBytecodes(3);
            if (n13 > n14) {
                BytecodeManager.incBytecodes(3);
                final NumberFormatException ex2 = new NumberFormatException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            while (true) {
                final char c5 = c;
                final int n15 = '0';
                BytecodeManager.incBytecodes(3);
                int digit2 = 0;
                Label_0329: {
                    if (c5 >= n15) {
                        final char c6 = c;
                        final int n16 = '9';
                        BytecodeManager.incBytecodes(3);
                        if (c6 <= n16) {
                            digit2 = c - '0';
                            BytecodeManager.incBytecodes(5);
                            break Label_0329;
                        }
                    }
                    final char ch2 = c;
                    final int radix2 = 10;
                    BytecodeManager.incBytecodes(3);
                    digit2 = Character.digit(ch2, radix2);
                    BytecodeManager.incBytecodes(1);
                    final int n17 = digit2;
                    BytecodeManager.incBytecodes(2);
                    if (n17 < 0) {
                        BytecodeManager.incBytecodes(3);
                        final NumberFormatException ex3 = new NumberFormatException();
                        BytecodeManager.incBytecodes(1);
                        throw ex3;
                    }
                }
                n3 = n3 * 10L + digit2;
                BytecodeManager.incBytecodes(7);
                final boolean b = n2 != 0;
                final boolean b2 = true;
                BytecodeManager.incBytecodes(3);
                if (b == b2) {
                    BytecodeManager.incBytecodes(1);
                    final int n18 = n6;
                    BytecodeManager.incBytecodes(2);
                    if (n18 != 0) {
                        n3 = -n3;
                        BytecodeManager.incBytecodes(3);
                    }
                    final long n19 = n3;
                    BytecodeManager.incBytecodes(2);
                    return n19;
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                c = array[n];
                BytecodeManager.incBytecodes(4);
                --n2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final char[] array) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            this(array, n, length);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final char[] array, final MathContext mathContext) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            this(array, n, length, mathContext);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final char[] charArray = s.toCharArray();
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            this(charArray, n, length);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final String s, final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(3);
            final char[] charArray = s.toCharArray();
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final int length = s.length();
            BytecodeManager.incBytecodes(2);
            this(charArray, n, length, mathContext);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final double n) {
        try {
            final MathContext unlimited = MathContext.UNLIMITED;
            BytecodeManager.incBytecodes(4);
            this(n, unlimited);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final double value, final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final boolean infinite = Double.isInfinite(value);
            BytecodeManager.incBytecodes(1);
            if (!infinite) {
                BytecodeManager.incBytecodes(2);
                final boolean naN = Double.isNaN(value);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    BytecodeManager.incBytecodes(2);
                    final long doubleToLongBits = Double.doubleToLongBits(value);
                    BytecodeManager.incBytecodes(1);
                    final long n = lcmp(doubleToLongBits >> 63, 0L);
                    BytecodeManager.incBytecodes(6);
                    int n2;
                    if (n == 0) {
                        n2 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n2 = -1;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(1);
                    int n4 = (int)(doubleToLongBits >> 52 & 0x7FFL);
                    BytecodeManager.incBytecodes(7);
                    final int n5 = n4;
                    BytecodeManager.incBytecodes(2);
                    long n6;
                    if (n5 == 0) {
                        n6 = (doubleToLongBits & 0xFFFFFFFFFFFFFL) << 1;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        n6 = ((doubleToLongBits & 0xFFFFFFFFFFFFFL) | 0x10000000000000L);
                        BytecodeManager.incBytecodes(5);
                    }
                    long n7 = n6;
                    BytecodeManager.incBytecodes(1);
                    n4 -= 1075;
                    BytecodeManager.incBytecodes(1);
                    final long n8 = lcmp(n7, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n8 == 0) {
                        this.intVal = BigInteger.ZERO;
                        BytecodeManager.incBytecodes(3);
                        this.scale = 0;
                        BytecodeManager.incBytecodes(3);
                        this.intCompact = 0L;
                        BytecodeManager.incBytecodes(3);
                        this.precision = 1;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    while (true) {
                        final long n9 = lcmp(n7 & 0x1L, 0L);
                        BytecodeManager.incBytecodes(6);
                        if (n9 != 0) {
                            break;
                        }
                        n7 >>= 1;
                        BytecodeManager.incBytecodes(4);
                        ++n4;
                        BytecodeManager.incBytecodes(2);
                    }
                    int scale = 0;
                    BytecodeManager.incBytecodes(2);
                    long intCompact = n3 * n7;
                    BytecodeManager.incBytecodes(5);
                    final int n10 = n4;
                    BytecodeManager.incBytecodes(2);
                    BigInteger intVal;
                    if (n10 == 0) {
                        final long n11 = lcmp(intCompact, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(4);
                        BigInteger inflated_BIGINT;
                        if (n11 == 0) {
                            inflated_BIGINT = BigDecimal.INFLATED_BIGINT;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            inflated_BIGINT = null;
                            BytecodeManager.incBytecodes(1);
                        }
                        intVal = inflated_BIGINT;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int n12 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n12 < 0) {
                            final long n13 = 5L;
                            BytecodeManager.incBytecodes(2);
                            final BigInteger value2 = BigInteger.valueOf(n13);
                            final int n14 = -n4;
                            BytecodeManager.incBytecodes(3);
                            final BigInteger pow = value2.pow(n14);
                            final long n15 = intCompact;
                            BytecodeManager.incBytecodes(2);
                            intVal = pow.multiply(n15);
                            BytecodeManager.incBytecodes(1);
                            scale = -n4;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            final long n16 = 2L;
                            BytecodeManager.incBytecodes(2);
                            final BigInteger value3 = BigInteger.valueOf(n16);
                            final int n17 = n4;
                            BytecodeManager.incBytecodes(2);
                            final BigInteger pow2 = value3.pow(n17);
                            final long n18 = intCompact;
                            BytecodeManager.incBytecodes(2);
                            intVal = pow2.multiply(n18);
                            BytecodeManager.incBytecodes(1);
                        }
                        final BigInteger bigInteger = intVal;
                        BytecodeManager.incBytecodes(2);
                        intCompact = compactValFor(bigInteger);
                        BytecodeManager.incBytecodes(1);
                    }
                    int precision = 0;
                    BytecodeManager.incBytecodes(2);
                    final int precision2 = mathContext.precision;
                    BytecodeManager.incBytecodes(3);
                    final int n19 = precision2;
                    BytecodeManager.incBytecodes(2);
                    if (n19 > 0) {
                        final int oldMode = mathContext.roundingMode.oldMode;
                        BytecodeManager.incBytecodes(4);
                        final long n20 = lcmp(intCompact, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(4);
                        if (n20 == 0) {
                            final BigInteger bigInteger2 = intVal;
                            BytecodeManager.incBytecodes(2);
                            precision = bigDigitLength(bigInteger2);
                            BytecodeManager.incBytecodes(1);
                            int n21 = precision - precision2;
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final int n22 = n21;
                                BytecodeManager.incBytecodes(2);
                                if (n22 <= 0) {
                                    break;
                                }
                                final long n23 = scale - (long)n21;
                                BytecodeManager.incBytecodes(6);
                                scale = checkScaleNonZero(n23);
                                BytecodeManager.incBytecodes(1);
                                final BigInteger bigInteger3 = intVal;
                                final int n24 = n21;
                                final int n25 = oldMode;
                                BytecodeManager.incBytecodes(4);
                                intVal = divideAndRoundByTenPow(bigInteger3, n24, n25);
                                BytecodeManager.incBytecodes(1);
                                final BigInteger bigInteger4 = intVal;
                                BytecodeManager.incBytecodes(2);
                                intCompact = compactValFor(bigInteger4);
                                BytecodeManager.incBytecodes(1);
                                final long n26 = lcmp(intCompact, Long.MIN_VALUE);
                                BytecodeManager.incBytecodes(4);
                                if (n26 != 0) {
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                final BigInteger bigInteger5 = intVal;
                                BytecodeManager.incBytecodes(2);
                                precision = bigDigitLength(bigInteger5);
                                BytecodeManager.incBytecodes(1);
                                n21 = precision - precision2;
                                BytecodeManager.incBytecodes(5);
                            }
                        }
                        final long n27 = lcmp(intCompact, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(4);
                        if (n27 != 0) {
                            final long n28 = intCompact;
                            BytecodeManager.incBytecodes(2);
                            precision = longDigitLength(n28);
                            BytecodeManager.incBytecodes(1);
                            int n29 = precision - precision2;
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final int n30 = n29;
                                BytecodeManager.incBytecodes(2);
                                if (n30 <= 0) {
                                    break;
                                }
                                final long n31 = scale - (long)n29;
                                BytecodeManager.incBytecodes(6);
                                scale = checkScaleNonZero(n31);
                                BytecodeManager.incBytecodes(1);
                                final long n32 = intCompact;
                                final long n33 = BigDecimal.LONG_TEN_POWERS_TABLE[n29];
                                final int oldMode2 = mathContext.roundingMode.oldMode;
                                BytecodeManager.incBytecodes(8);
                                intCompact = divideAndRound(n32, n33, oldMode2);
                                BytecodeManager.incBytecodes(1);
                                final long n34 = intCompact;
                                BytecodeManager.incBytecodes(2);
                                precision = longDigitLength(n34);
                                BytecodeManager.incBytecodes(1);
                                n29 = precision - precision2;
                                BytecodeManager.incBytecodes(5);
                            }
                            intVal = null;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    this.intVal = intVal;
                    BytecodeManager.incBytecodes(3);
                    this.intCompact = intCompact;
                    BytecodeManager.incBytecodes(3);
                    this.scale = scale;
                    BytecodeManager.incBytecodes(3);
                    this.precision = precision;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            final String s = "Infinite or NaN";
            BytecodeManager.incBytecodes(4);
            final NumberFormatException ex = new NumberFormatException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final BigInteger intVal) {
        try {
            BytecodeManager.incBytecodes(2);
            this.scale = 0;
            BytecodeManager.incBytecodes(3);
            this.intVal = intVal;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.intCompact = compactValFor(intVal);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final BigInteger bigInteger, final MathContext mathContext) {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            this(bigInteger, n, mathContext);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final BigInteger intVal, final int scale) {
        try {
            BytecodeManager.incBytecodes(2);
            this.intVal = intVal;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.intCompact = compactValFor(intVal);
            BytecodeManager.incBytecodes(1);
            this.scale = scale;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(BigInteger divideAndRoundByTenPow, int scale, final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(2);
            final BigInteger bigInteger = divideAndRoundByTenPow;
            BytecodeManager.incBytecodes(2);
            long intCompact = compactValFor(bigInteger);
            BytecodeManager.incBytecodes(1);
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            int precision2 = 0;
            BytecodeManager.incBytecodes(2);
            final int n = precision;
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                final int oldMode = mathContext.roundingMode.oldMode;
                BytecodeManager.incBytecodes(4);
                final long n2 = lcmp(intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n2 == 0) {
                    final BigInteger bigInteger2 = divideAndRoundByTenPow;
                    BytecodeManager.incBytecodes(2);
                    precision2 = bigDigitLength(bigInteger2);
                    BytecodeManager.incBytecodes(1);
                    int n3 = precision2 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n4 = n3;
                        BytecodeManager.incBytecodes(2);
                        if (n4 <= 0) {
                            break;
                        }
                        final long n5 = scale - (long)n3;
                        BytecodeManager.incBytecodes(6);
                        scale = checkScaleNonZero(n5);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger3 = divideAndRoundByTenPow;
                        final int n6 = n3;
                        final int n7 = oldMode;
                        BytecodeManager.incBytecodes(4);
                        divideAndRoundByTenPow = divideAndRoundByTenPow(bigInteger3, n6, n7);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger4 = divideAndRoundByTenPow;
                        BytecodeManager.incBytecodes(2);
                        intCompact = compactValFor(bigInteger4);
                        BytecodeManager.incBytecodes(1);
                        final long n8 = lcmp(intCompact, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(4);
                        if (n8 != 0) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final BigInteger bigInteger5 = divideAndRoundByTenPow;
                        BytecodeManager.incBytecodes(2);
                        precision2 = bigDigitLength(bigInteger5);
                        BytecodeManager.incBytecodes(1);
                        n3 = precision2 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final long n9 = lcmp(intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n9 != 0) {
                    final long n10 = intCompact;
                    BytecodeManager.incBytecodes(2);
                    precision2 = longDigitLength(n10);
                    BytecodeManager.incBytecodes(1);
                    int n11 = precision2 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n12 = n11;
                        BytecodeManager.incBytecodes(2);
                        if (n12 <= 0) {
                            break;
                        }
                        final long n13 = scale - (long)n11;
                        BytecodeManager.incBytecodes(6);
                        scale = checkScaleNonZero(n13);
                        BytecodeManager.incBytecodes(1);
                        final long n14 = intCompact;
                        final long n15 = BigDecimal.LONG_TEN_POWERS_TABLE[n11];
                        final int n16 = oldMode;
                        BytecodeManager.incBytecodes(6);
                        intCompact = divideAndRound(n14, n15, n16);
                        BytecodeManager.incBytecodes(1);
                        final long n17 = intCompact;
                        BytecodeManager.incBytecodes(2);
                        precision2 = longDigitLength(n17);
                        BytecodeManager.incBytecodes(1);
                        n11 = precision2 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                    divideAndRoundByTenPow = null;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.intVal = divideAndRoundByTenPow;
            BytecodeManager.incBytecodes(3);
            this.intCompact = intCompact;
            BytecodeManager.incBytecodes(3);
            this.scale = scale;
            BytecodeManager.incBytecodes(3);
            this.precision = precision2;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.intCompact = n;
            BytecodeManager.incBytecodes(4);
            this.scale = 0;
            BytecodeManager.incBytecodes(3);
            this.intVal = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final int n, final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(2);
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            long divideAndRound = n;
            BytecodeManager.incBytecodes(3);
            int checkScaleNonZero = 0;
            BytecodeManager.incBytecodes(2);
            int precision2 = 0;
            BytecodeManager.incBytecodes(2);
            final int n2 = precision;
            BytecodeManager.incBytecodes(2);
            if (n2 > 0) {
                final long n3 = divideAndRound;
                BytecodeManager.incBytecodes(2);
                precision2 = longDigitLength(n3);
                BytecodeManager.incBytecodes(1);
                int n4 = precision2 - precision;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n5 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n5 <= 0) {
                        break;
                    }
                    final long n6 = checkScaleNonZero - (long)n4;
                    BytecodeManager.incBytecodes(6);
                    checkScaleNonZero = checkScaleNonZero(n6);
                    BytecodeManager.incBytecodes(1);
                    final long n7 = divideAndRound;
                    final long n8 = BigDecimal.LONG_TEN_POWERS_TABLE[n4];
                    final int oldMode = mathContext.roundingMode.oldMode;
                    BytecodeManager.incBytecodes(8);
                    divideAndRound = divideAndRound(n7, n8, oldMode);
                    BytecodeManager.incBytecodes(1);
                    final long n9 = divideAndRound;
                    BytecodeManager.incBytecodes(2);
                    precision2 = longDigitLength(n9);
                    BytecodeManager.incBytecodes(1);
                    n4 = precision2 - precision;
                    BytecodeManager.incBytecodes(5);
                }
            }
            this.intVal = null;
            BytecodeManager.incBytecodes(3);
            this.intCompact = divideAndRound;
            BytecodeManager.incBytecodes(3);
            this.scale = checkScaleNonZero;
            BytecodeManager.incBytecodes(3);
            this.precision = precision2;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(final long intCompact) {
        try {
            BytecodeManager.incBytecodes(2);
            this.intCompact = intCompact;
            BytecodeManager.incBytecodes(3);
            final long n = lcmp(intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            BigInteger inflated_BIGINT;
            if (n == 0) {
                inflated_BIGINT = BigDecimal.INFLATED_BIGINT;
                BytecodeManager.incBytecodes(2);
            }
            else {
                inflated_BIGINT = null;
                BytecodeManager.incBytecodes(1);
            }
            this.intVal = inflated_BIGINT;
            BytecodeManager.incBytecodes(1);
            this.scale = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal(long intCompact, final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(2);
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int oldMode = mathContext.roundingMode.oldMode;
            BytecodeManager.incBytecodes(4);
            int precision2 = 0;
            BytecodeManager.incBytecodes(2);
            int scale = 0;
            BytecodeManager.incBytecodes(2);
            final long n = lcmp(intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            BigInteger inflated_BIGINT;
            if (n == 0) {
                inflated_BIGINT = BigDecimal.INFLATED_BIGINT;
                BytecodeManager.incBytecodes(2);
            }
            else {
                inflated_BIGINT = null;
                BytecodeManager.incBytecodes(1);
            }
            BigInteger divideAndRoundByTenPow = inflated_BIGINT;
            BytecodeManager.incBytecodes(1);
            final int n2 = precision;
            BytecodeManager.incBytecodes(2);
            if (n2 > 0) {
                final long n3 = lcmp(intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n3 == 0) {
                    precision2 = 19;
                    BytecodeManager.incBytecodes(2);
                    int n4 = precision2 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n5 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n5 <= 0) {
                            break;
                        }
                        final long n6 = scale - (long)n4;
                        BytecodeManager.incBytecodes(6);
                        scale = checkScaleNonZero(n6);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger = divideAndRoundByTenPow;
                        final int n7 = n4;
                        final int n8 = oldMode;
                        BytecodeManager.incBytecodes(4);
                        divideAndRoundByTenPow = divideAndRoundByTenPow(bigInteger, n7, n8);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger2 = divideAndRoundByTenPow;
                        BytecodeManager.incBytecodes(2);
                        intCompact = compactValFor(bigInteger2);
                        BytecodeManager.incBytecodes(1);
                        final long n9 = lcmp(intCompact, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(4);
                        if (n9 != 0) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final BigInteger bigInteger3 = divideAndRoundByTenPow;
                        BytecodeManager.incBytecodes(2);
                        precision2 = bigDigitLength(bigInteger3);
                        BytecodeManager.incBytecodes(1);
                        n4 = precision2 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final long n10 = lcmp(intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n10 != 0) {
                    final long n11 = intCompact;
                    BytecodeManager.incBytecodes(2);
                    precision2 = longDigitLength(n11);
                    BytecodeManager.incBytecodes(1);
                    int n12 = precision2 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n13 = n12;
                        BytecodeManager.incBytecodes(2);
                        if (n13 <= 0) {
                            break;
                        }
                        final long n14 = scale - (long)n12;
                        BytecodeManager.incBytecodes(6);
                        scale = checkScaleNonZero(n14);
                        BytecodeManager.incBytecodes(1);
                        final long n15 = intCompact;
                        final long n16 = BigDecimal.LONG_TEN_POWERS_TABLE[n12];
                        final int oldMode2 = mathContext.roundingMode.oldMode;
                        BytecodeManager.incBytecodes(8);
                        intCompact = divideAndRound(n15, n16, oldMode2);
                        BytecodeManager.incBytecodes(1);
                        final long n17 = intCompact;
                        BytecodeManager.incBytecodes(2);
                        precision2 = longDigitLength(n17);
                        BytecodeManager.incBytecodes(1);
                        n12 = precision2 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                    divideAndRoundByTenPow = null;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.intVal = divideAndRoundByTenPow;
            BytecodeManager.incBytecodes(3);
            this.intCompact = intCompact;
            BytecodeManager.incBytecodes(3);
            this.scale = scale;
            BytecodeManager.incBytecodes(3);
            this.precision = precision2;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BigDecimal valueOf(final long n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigDecimal value = valueOf(n);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigDecimal zeroValue = zeroValueOf(n2);
                BytecodeManager.incBytecodes(1);
                return zeroValue;
            }
            final long n4 = lcmp(n, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(6);
            BigInteger inflated_BIGINT;
            if (n4 == 0) {
                inflated_BIGINT = BigDecimal.INFLATED_BIGINT;
                BytecodeManager.incBytecodes(2);
            }
            else {
                inflated_BIGINT = null;
                BytecodeManager.incBytecodes(1);
            }
            final int n5 = 0;
            BytecodeManager.incBytecodes(4);
            final BigDecimal bigDecimal = new BigDecimal(inflated_BIGINT, n, n2, n5);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BigDecimal valueOf(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 >= 0) {
                final long n3 = lcmp(n, (long)BigDecimal.zeroThroughTen.length);
                BytecodeManager.incBytecodes(6);
                if (n3 < 0) {
                    final BigDecimal bigDecimal = BigDecimal.zeroThroughTen[(int)n];
                    BytecodeManager.incBytecodes(5);
                    return bigDecimal;
                }
            }
            final long n4 = lcmp(n, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n4 != 0) {
                final BigInteger bigInteger = null;
                final int n5 = 0;
                final int n6 = 0;
                BytecodeManager.incBytecodes(7);
                final BigDecimal bigDecimal2 = new BigDecimal(bigInteger, n, n5, n6);
                BytecodeManager.incBytecodes(1);
                return bigDecimal2;
            }
            final BigInteger inflated_BIGINT = BigDecimal.INFLATED_BIGINT;
            final int n7 = 0;
            final int n8 = 0;
            BytecodeManager.incBytecodes(7);
            final BigDecimal bigDecimal3 = new BigDecimal(inflated_BIGINT, n, n7, n8);
            BytecodeManager.incBytecodes(1);
            return bigDecimal3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static BigDecimal valueOf(final long n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                final long n4 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(4);
                if (n4 >= 0) {
                    final long n5 = lcmp(n, (long)BigDecimal.zeroThroughTen.length);
                    BytecodeManager.incBytecodes(6);
                    if (n5 < 0) {
                        final BigDecimal bigDecimal = BigDecimal.zeroThroughTen[(int)n];
                        BytecodeManager.incBytecodes(5);
                        return bigDecimal;
                    }
                }
            }
            final long n6 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n6 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigDecimal zeroValue = zeroValueOf(n2);
                BytecodeManager.incBytecodes(1);
                return zeroValue;
            }
            final long n7 = lcmp(n, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(6);
            BigInteger inflated_BIGINT;
            if (n7 == 0) {
                inflated_BIGINT = BigDecimal.INFLATED_BIGINT;
                BytecodeManager.incBytecodes(2);
            }
            else {
                inflated_BIGINT = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(4);
            final BigDecimal bigDecimal2 = new BigDecimal(inflated_BIGINT, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return bigDecimal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static BigDecimal valueOf(final BigInteger bigInteger, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            final long compactVal = compactValFor(bigInteger);
            BytecodeManager.incBytecodes(1);
            final long n3 = lcmp(compactVal, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigDecimal zeroValue = zeroValueOf(n);
                BytecodeManager.incBytecodes(1);
                return zeroValue;
            }
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final long n4 = lcmp(compactVal, 0L);
                BytecodeManager.incBytecodes(4);
                if (n4 >= 0) {
                    final long n5 = lcmp(compactVal, (long)BigDecimal.zeroThroughTen.length);
                    BytecodeManager.incBytecodes(6);
                    if (n5 < 0) {
                        final BigDecimal bigDecimal = BigDecimal.zeroThroughTen[(int)compactVal];
                        BytecodeManager.incBytecodes(5);
                        return bigDecimal;
                    }
                }
            }
            final long n6 = compactVal;
            BytecodeManager.incBytecodes(7);
            final BigDecimal bigDecimal2 = new BigDecimal(bigInteger, n6, n, n2);
            BytecodeManager.incBytecodes(1);
            return bigDecimal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static BigDecimal zeroValueOf(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int length = BigDecimal.ZERO_SCALED_BY.length;
                BytecodeManager.incBytecodes(4);
                if (n < length) {
                    final BigDecimal bigDecimal = BigDecimal.ZERO_SCALED_BY[n];
                    BytecodeManager.incBytecodes(4);
                    return bigDecimal;
                }
            }
            final BigInteger zero = BigInteger.ZERO;
            final long n2 = 0L;
            final int n3 = 1;
            BytecodeManager.incBytecodes(7);
            final BigDecimal bigDecimal2 = new BigDecimal(zero, n2, n, n3);
            BytecodeManager.incBytecodes(1);
            return bigDecimal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static BigDecimal valueOf(final double d) {
        try {
            BytecodeManager.incBytecodes(4);
            final String string = Double.toString(d);
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal = new BigDecimal(string);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal add(final BigDecimal bigDecimal) {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                final long n2 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n2 != 0) {
                    final long intCompact = this.intCompact;
                    final int scale = this.scale;
                    final long intCompact2 = bigDecimal.intCompact;
                    final int scale2 = bigDecimal.scale;
                    BytecodeManager.incBytecodes(9);
                    final BigDecimal add = add(intCompact, scale, intCompact2, scale2);
                    BytecodeManager.incBytecodes(1);
                    return add;
                }
                final long intCompact3 = this.intCompact;
                final int scale3 = this.scale;
                final BigInteger intVal = bigDecimal.intVal;
                final int scale4 = bigDecimal.scale;
                BytecodeManager.incBytecodes(9);
                final BigDecimal add2 = add(intCompact3, scale3, intVal, scale4);
                BytecodeManager.incBytecodes(1);
                return add2;
            }
            else {
                final long n3 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n3 != 0) {
                    final long intCompact4 = bigDecimal.intCompact;
                    final int scale5 = bigDecimal.scale;
                    final BigInteger intVal2 = this.intVal;
                    final int scale6 = this.scale;
                    BytecodeManager.incBytecodes(9);
                    final BigDecimal add3 = add(intCompact4, scale5, intVal2, scale6);
                    BytecodeManager.incBytecodes(1);
                    return add3;
                }
                final BigInteger intVal3 = this.intVal;
                final int scale7 = this.scale;
                final BigInteger intVal4 = bigDecimal.intVal;
                final int scale8 = bigDecimal.scale;
                BytecodeManager.incBytecodes(9);
                final BigDecimal add4 = add(intVal3, scale7, intVal4, scale8);
                BytecodeManager.incBytecodes(1);
                return add4;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal add(BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            if (precision == 0) {
                final BigDecimal bigDecimal2 = bigDecimal;
                BytecodeManager.incBytecodes(3);
                final BigDecimal add = this.add(bigDecimal2);
                BytecodeManager.incBytecodes(1);
                return add;
            }
            BigDecimal bigDecimal3 = this;
            BytecodeManager.incBytecodes(2);
            final BigDecimal bigDecimal4 = bigDecimal3;
            BytecodeManager.incBytecodes(2);
            final int signum = bigDecimal4.signum();
            BytecodeManager.incBytecodes(1);
            int n;
            if (signum == 0) {
                n = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal5 = bigDecimal;
            BytecodeManager.incBytecodes(2);
            final int signum2 = bigDecimal5.signum();
            BytecodeManager.incBytecodes(1);
            int n3;
            if (signum2 == 0) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            final int n5 = n2;
            BytecodeManager.incBytecodes(2);
            if (n5 == 0) {
                final int n6 = n4;
                BytecodeManager.incBytecodes(2);
                if (n6 == 0) {
                    final long n7 = bigDecimal3.scale - (long)bigDecimal.scale;
                    BytecodeManager.incBytecodes(8);
                    final long n8 = lcmp(n7, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n8 != 0) {
                        final BigDecimal bigDecimal6 = bigDecimal3;
                        final BigDecimal bigDecimal7 = bigDecimal;
                        final long n9 = n7;
                        BytecodeManager.incBytecodes(6);
                        final BigDecimal[] preAlign = this.preAlign(bigDecimal6, bigDecimal7, n9, mathContext);
                        BytecodeManager.incBytecodes(1);
                        final BigDecimal[] array = preAlign;
                        BytecodeManager.incBytecodes(2);
                        matchScale(array);
                        bigDecimal3 = preAlign[0];
                        BytecodeManager.incBytecodes(4);
                        bigDecimal = preAlign[1];
                        BytecodeManager.incBytecodes(4);
                    }
                    final BigDecimal bigDecimal8 = bigDecimal3;
                    BytecodeManager.incBytecodes(2);
                    final BigInteger inflated = bigDecimal8.inflated();
                    final BigDecimal bigDecimal9 = bigDecimal;
                    BytecodeManager.incBytecodes(2);
                    final BigInteger inflated2 = bigDecimal9.inflated();
                    BytecodeManager.incBytecodes(1);
                    final BigInteger add2 = inflated.add(inflated2);
                    final int scale = bigDecimal3.scale;
                    BytecodeManager.incBytecodes(4);
                    final BigDecimal doRound = doRound(add2, scale, mathContext);
                    BytecodeManager.incBytecodes(1);
                    return doRound;
                }
            }
            final BigDecimal bigDecimal10 = bigDecimal3;
            BytecodeManager.incBytecodes(2);
            final int scale2 = bigDecimal10.scale();
            final BigDecimal bigDecimal11 = bigDecimal;
            BytecodeManager.incBytecodes(2);
            final int scale3 = bigDecimal11.scale();
            BytecodeManager.incBytecodes(1);
            final int max = Math.max(scale2, scale3);
            BytecodeManager.incBytecodes(1);
            final int n10 = n2;
            BytecodeManager.incBytecodes(2);
            if (n10 != 0) {
                final int n11 = n4;
                BytecodeManager.incBytecodes(2);
                if (n11 != 0) {
                    final int n12 = max;
                    BytecodeManager.incBytecodes(2);
                    final BigDecimal zeroValue = zeroValueOf(n12);
                    BytecodeManager.incBytecodes(1);
                    return zeroValue;
                }
            }
            final int n13 = n2;
            BytecodeManager.incBytecodes(2);
            BigDecimal bigDecimal13;
            if (n13 != 0) {
                final BigDecimal bigDecimal12 = bigDecimal;
                BytecodeManager.incBytecodes(3);
                bigDecimal13 = doRound(bigDecimal12, mathContext);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final BigDecimal bigDecimal14 = bigDecimal3;
                BytecodeManager.incBytecodes(3);
                bigDecimal13 = doRound(bigDecimal14, mathContext);
            }
            final BigDecimal bigDecimal15 = bigDecimal13;
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal16 = bigDecimal15;
            BytecodeManager.incBytecodes(2);
            final int scale4 = bigDecimal16.scale();
            final int n14 = max;
            BytecodeManager.incBytecodes(2);
            if (scale4 == n14) {
                final BigDecimal bigDecimal17 = bigDecimal15;
                BytecodeManager.incBytecodes(2);
                return bigDecimal17;
            }
            final BigDecimal bigDecimal18 = bigDecimal15;
            BytecodeManager.incBytecodes(2);
            final int scale5 = bigDecimal18.scale();
            final int n15 = max;
            BytecodeManager.incBytecodes(2);
            if (scale5 > n15) {
                final BigInteger intVal = bigDecimal15.intVal;
                final long intCompact = bigDecimal15.intCompact;
                final int scale6 = bigDecimal15.scale;
                final int n16 = max;
                BytecodeManager.incBytecodes(8);
                final BigDecimal stripZerosToMatchScale = stripZerosToMatchScale(intVal, intCompact, scale6, n16);
                BytecodeManager.incBytecodes(1);
                return stripZerosToMatchScale;
            }
            final int precision2 = mathContext.precision;
            final BigDecimal bigDecimal19 = bigDecimal15;
            BytecodeManager.incBytecodes(4);
            final int n17 = precision2 - bigDecimal19.precision();
            BytecodeManager.incBytecodes(2);
            final int n18 = max;
            final BigDecimal bigDecimal20 = bigDecimal15;
            BytecodeManager.incBytecodes(3);
            final int n19 = n18 - bigDecimal20.scale();
            BytecodeManager.incBytecodes(2);
            final int n20 = n17;
            final int n21 = n19;
            BytecodeManager.incBytecodes(3);
            if (n20 >= n21) {
                final BigDecimal bigDecimal21 = bigDecimal15;
                final int scale7 = max;
                BytecodeManager.incBytecodes(3);
                final BigDecimal setScale = bigDecimal21.setScale(scale7);
                BytecodeManager.incBytecodes(1);
                return setScale;
            }
            final BigDecimal bigDecimal22 = bigDecimal15;
            final BigDecimal bigDecimal23 = bigDecimal15;
            BytecodeManager.incBytecodes(3);
            final int scale8 = bigDecimal23.scale() + n17;
            BytecodeManager.incBytecodes(3);
            final BigDecimal setScale2 = bigDecimal22.setScale(scale8);
            BytecodeManager.incBytecodes(1);
            return setScale2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigDecimal[] preAlign(final BigDecimal bigDecimal, final BigDecimal bigDecimal2, final long n, final MathContext mathContext) {
        try {
            final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final long n2 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(4);
                if (n2 == 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            BigDecimal bigDecimal3;
            BigDecimal value;
            if (n3 < 0) {
                bigDecimal3 = bigDecimal;
                BytecodeManager.incBytecodes(2);
                value = bigDecimal2;
                BytecodeManager.incBytecodes(3);
            }
            else {
                bigDecimal3 = bigDecimal2;
                BytecodeManager.incBytecodes(2);
                value = bigDecimal;
                BytecodeManager.incBytecodes(2);
            }
            final long n4 = bigDecimal3.scale;
            final BigDecimal bigDecimal4 = bigDecimal3;
            BytecodeManager.incBytecodes(5);
            final long n5 = n4 - bigDecimal4.precision() + mathContext.precision;
            BytecodeManager.incBytecodes(7);
            final long n6 = value.scale;
            final BigDecimal bigDecimal5 = value;
            BytecodeManager.incBytecodes(5);
            final long n7 = n6 - bigDecimal5.precision() + 1L;
            BytecodeManager.incBytecodes(5);
            final long n8 = lcmp(n7, (long)(bigDecimal3.scale + 2));
            BytecodeManager.incBytecodes(8);
            if (n8 > 0) {
                final long n9 = lcmp(n7, n5 + 2L);
                BytecodeManager.incBytecodes(6);
                if (n9 > 0) {
                    final BigDecimal bigDecimal6 = value;
                    BytecodeManager.incBytecodes(2);
                    final long n10 = bigDecimal6.signum();
                    final long a = bigDecimal3.scale;
                    final long b = n5;
                    BytecodeManager.incBytecodes(7);
                    final long n11 = Math.max(a, b) + 3L;
                    BytecodeManager.incBytecodes(3);
                    final int checkScale = this.checkScale(n11);
                    BytecodeManager.incBytecodes(1);
                    value = valueOf(n10, checkScale);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final BigDecimal[] array = { bigDecimal3, value };
            BytecodeManager.incBytecodes(10);
            final BigDecimal[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal subtract(final BigDecimal bigDecimal) {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                final long n2 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n2 != 0) {
                    final long intCompact = this.intCompact;
                    final int scale = this.scale;
                    final long n3 = -bigDecimal.intCompact;
                    final int scale2 = bigDecimal.scale;
                    BytecodeManager.incBytecodes(10);
                    final BigDecimal add = add(intCompact, scale, n3, scale2);
                    BytecodeManager.incBytecodes(1);
                    return add;
                }
                final long intCompact2 = this.intCompact;
                final int scale3 = this.scale;
                final BigInteger intVal = bigDecimal.intVal;
                BytecodeManager.incBytecodes(7);
                final BigInteger negate = intVal.negate();
                final int scale4 = bigDecimal.scale;
                BytecodeManager.incBytecodes(3);
                final BigDecimal add2 = add(intCompact2, scale3, negate, scale4);
                BytecodeManager.incBytecodes(1);
                return add2;
            }
            else {
                final long n4 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n4 != 0) {
                    final long n5 = -bigDecimal.intCompact;
                    final int scale5 = bigDecimal.scale;
                    final BigInteger intVal2 = this.intVal;
                    final int scale6 = this.scale;
                    BytecodeManager.incBytecodes(10);
                    final BigDecimal add3 = add(n5, scale5, intVal2, scale6);
                    BytecodeManager.incBytecodes(1);
                    return add3;
                }
                final BigInteger intVal3 = this.intVal;
                final int scale7 = this.scale;
                final BigInteger intVal4 = bigDecimal.intVal;
                BytecodeManager.incBytecodes(7);
                final BigInteger negate2 = intVal4.negate();
                final int scale8 = bigDecimal.scale;
                BytecodeManager.incBytecodes(3);
                final BigDecimal add4 = add(intVal3, scale7, negate2, scale8);
                BytecodeManager.incBytecodes(1);
                return add4;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal subtract(final BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            if (precision == 0) {
                BytecodeManager.incBytecodes(3);
                final BigDecimal subtract = this.subtract(bigDecimal);
                BytecodeManager.incBytecodes(1);
                return subtract;
            }
            BytecodeManager.incBytecodes(3);
            final BigDecimal negate = bigDecimal.negate();
            BytecodeManager.incBytecodes(2);
            final BigDecimal add = this.add(negate, mathContext);
            BytecodeManager.incBytecodes(1);
            return add;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal multiply(final BigDecimal bigDecimal) {
        try {
            final long n = this.scale + (long)bigDecimal.scale;
            BytecodeManager.incBytecodes(9);
            final int checkScale = this.checkScale(n);
            BytecodeManager.incBytecodes(1);
            final long n2 = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n2 != 0) {
                final long n3 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n3 != 0) {
                    final long intCompact = this.intCompact;
                    final long intCompact2 = bigDecimal.intCompact;
                    final int n4 = checkScale;
                    BytecodeManager.incBytecodes(6);
                    final BigDecimal multiply = multiply(intCompact, intCompact2, n4);
                    BytecodeManager.incBytecodes(1);
                    return multiply;
                }
                final long intCompact3 = this.intCompact;
                final BigInteger intVal = bigDecimal.intVal;
                final int n5 = checkScale;
                BytecodeManager.incBytecodes(6);
                final BigDecimal multiply2 = multiply(intCompact3, intVal, n5);
                BytecodeManager.incBytecodes(1);
                return multiply2;
            }
            else {
                final long n6 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n6 != 0) {
                    final long intCompact4 = bigDecimal.intCompact;
                    final BigInteger intVal2 = this.intVal;
                    final int n7 = checkScale;
                    BytecodeManager.incBytecodes(6);
                    final BigDecimal multiply3 = multiply(intCompact4, intVal2, n7);
                    BytecodeManager.incBytecodes(1);
                    return multiply3;
                }
                final BigInteger intVal3 = this.intVal;
                final BigInteger intVal4 = bigDecimal.intVal;
                final int n8 = checkScale;
                BytecodeManager.incBytecodes(6);
                final BigDecimal multiply4 = multiply(intVal3, intVal4, n8);
                BytecodeManager.incBytecodes(1);
                return multiply4;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal multiply(final BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            if (precision == 0) {
                BytecodeManager.incBytecodes(3);
                final BigDecimal multiply = this.multiply(bigDecimal);
                BytecodeManager.incBytecodes(1);
                return multiply;
            }
            final long n = this.scale + (long)bigDecimal.scale;
            BytecodeManager.incBytecodes(9);
            final int checkScale = this.checkScale(n);
            BytecodeManager.incBytecodes(1);
            final long n2 = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n2 != 0) {
                final long n3 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n3 != 0) {
                    final long intCompact = this.intCompact;
                    final long intCompact2 = bigDecimal.intCompact;
                    final int n4 = checkScale;
                    BytecodeManager.incBytecodes(7);
                    final BigDecimal multiplyAndRound = multiplyAndRound(intCompact, intCompact2, n4, mathContext);
                    BytecodeManager.incBytecodes(1);
                    return multiplyAndRound;
                }
                final long intCompact3 = this.intCompact;
                final BigInteger intVal = bigDecimal.intVal;
                final int n5 = checkScale;
                BytecodeManager.incBytecodes(7);
                final BigDecimal multiplyAndRound2 = multiplyAndRound(intCompact3, intVal, n5, mathContext);
                BytecodeManager.incBytecodes(1);
                return multiplyAndRound2;
            }
            else {
                final long n6 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n6 != 0) {
                    final long intCompact4 = bigDecimal.intCompact;
                    final BigInteger intVal2 = this.intVal;
                    final int n7 = checkScale;
                    BytecodeManager.incBytecodes(7);
                    final BigDecimal multiplyAndRound3 = multiplyAndRound(intCompact4, intVal2, n7, mathContext);
                    BytecodeManager.incBytecodes(1);
                    return multiplyAndRound3;
                }
                final BigInteger intVal3 = this.intVal;
                final BigInteger intVal4 = bigDecimal.intVal;
                final int n8 = checkScale;
                BytecodeManager.incBytecodes(7);
                final BigDecimal multiplyAndRound4 = multiplyAndRound(intVal3, intVal4, n8, mathContext);
                BytecodeManager.incBytecodes(1);
                return multiplyAndRound4;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal divide(final BigDecimal bigDecimal, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n2 >= 0) {
                final int n3 = 7;
                BytecodeManager.incBytecodes(3);
                if (n2 <= n3) {
                    final long n4 = lcmp(this.intCompact, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n4 != 0) {
                        final long n5 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n5 != 0) {
                            final long intCompact = this.intCompact;
                            final int scale = this.scale;
                            final long intCompact2 = bigDecimal.intCompact;
                            final int scale2 = bigDecimal.scale;
                            BytecodeManager.incBytecodes(11);
                            final BigDecimal divide = divide(intCompact, scale, intCompact2, scale2, n, n2);
                            BytecodeManager.incBytecodes(1);
                            return divide;
                        }
                        final long intCompact3 = this.intCompact;
                        final int scale3 = this.scale;
                        final BigInteger intVal = bigDecimal.intVal;
                        final int scale4 = bigDecimal.scale;
                        BytecodeManager.incBytecodes(11);
                        final BigDecimal divide2 = divide(intCompact3, scale3, intVal, scale4, n, n2);
                        BytecodeManager.incBytecodes(1);
                        return divide2;
                    }
                    else {
                        final long n6 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n6 != 0) {
                            final BigInteger intVal2 = this.intVal;
                            final int scale5 = this.scale;
                            final long intCompact4 = bigDecimal.intCompact;
                            final int scale6 = bigDecimal.scale;
                            BytecodeManager.incBytecodes(11);
                            final BigDecimal divide3 = divide(intVal2, scale5, intCompact4, scale6, n, n2);
                            BytecodeManager.incBytecodes(1);
                            return divide3;
                        }
                        final BigInteger intVal3 = this.intVal;
                        final int scale7 = this.scale;
                        final BigInteger intVal4 = bigDecimal.intVal;
                        final int scale8 = bigDecimal.scale;
                        BytecodeManager.incBytecodes(11);
                        final BigDecimal divide4 = divide(intVal3, scale7, intVal4, scale8, n, n2);
                        BytecodeManager.incBytecodes(1);
                        return divide4;
                    }
                }
            }
            final String s = "Invalid rounding mode";
            BytecodeManager.incBytecodes(4);
            final IllegalArgumentException ex = new IllegalArgumentException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal divide(final BigDecimal bigDecimal, final int n, final RoundingMode roundingMode) {
        try {
            final int oldMode = roundingMode.oldMode;
            BytecodeManager.incBytecodes(6);
            final BigDecimal divide = this.divide(bigDecimal, n, oldMode);
            BytecodeManager.incBytecodes(1);
            return divide;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal divide(final BigDecimal bigDecimal, final int n) {
        try {
            final int scale = this.scale;
            BytecodeManager.incBytecodes(6);
            final BigDecimal divide = this.divide(bigDecimal, scale, n);
            BytecodeManager.incBytecodes(1);
            return divide;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal divide(final BigDecimal bigDecimal, final RoundingMode roundingMode) {
        try {
            final int scale = this.scale;
            final int oldMode = roundingMode.oldMode;
            BytecodeManager.incBytecodes(7);
            final BigDecimal divide = this.divide(bigDecimal, scale, oldMode);
            BytecodeManager.incBytecodes(1);
            return divide;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal divide(final BigDecimal p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/math/BigDecimal.signum:()I
        //     9: ldc             1
        //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    14: ifne            76
        //    17: aload_0        
        //    18: ldc             2
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: invokevirtual   instrumented/java/math/BigDecimal.signum:()I
        //    26: ldc             1
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: ifne            55
        //    34: new             Ljava/lang/ArithmeticException;
        //    37: dup            
        //    38: ldc_w           "Division undefined"
        //    41: ldc             4
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokespecial   java/lang/ArithmeticException.<init>:(Ljava/lang/String;)V
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: athrow         
        //    55: new             Ljava/lang/ArithmeticException;
        //    58: dup            
        //    59: ldc_w           "Division by zero"
        //    62: ldc             4
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   java/lang/ArithmeticException.<init>:(Ljava/lang/String;)V
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: athrow         
        //    76: aload_0        
        //    77: getfield        instrumented/java/math/BigDecimal.scale:I
        //    80: i2l            
        //    81: aload_1        
        //    82: getfield        instrumented/java/math/BigDecimal.scale:I
        //    85: i2l            
        //    86: lsub           
        //    87: ldc             8
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokestatic    instrumented/java/math/BigDecimal.saturateLong:(J)I
        //    95: istore_2       
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: aload_0        
        //   102: ldc             2
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   instrumented/java/math/BigDecimal.signum:()I
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: ifne            133
        //   118: iload_2        
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokestatic    instrumented/java/math/BigDecimal.zeroValueOf:(I)Linstrumented/java/math/BigDecimal;
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: areturn        
        //   133: new             Linstrumented/java/math/MathContext;
        //   136: dup            
        //   137: aload_0        
        //   138: ldc             4
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokevirtual   instrumented/java/math/BigDecimal.precision:()I
        //   146: i2l            
        //   147: ldc2_w          10.0
        //   150: aload_1        
        //   151: ldc             3
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: ldc             1
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokevirtual   instrumented/java/math/BigDecimal.precision:()I
        //   164: i2d            
        //   165: dmul           
        //   166: ldc2_w          3.0
        //   169: ddiv           
        //   170: ldc             5
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokestatic    java/lang/Math.ceil:(D)D
        //   178: d2l            
        //   179: ladd           
        //   180: ldc2_w          2147483647
        //   183: ldc             3
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokestatic    java/lang/Math.min:(JJ)J
        //   196: l2i            
        //   197: getstatic       instrumented/java/math/RoundingMode.UNNECESSARY:Linstrumented/java/math/RoundingMode;
        //   200: ldc             3
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: invokespecial   instrumented/java/math/MathContext.<init>:(ILinstrumented/java/math/RoundingMode;)V
        //   208: astore_3       
        //   209: ldc             1
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: aload_0        
        //   215: aload_1        
        //   216: aload_3        
        //   217: ldc             4
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: invokevirtual   instrumented/java/math/BigDecimal.divide:(Linstrumented/java/math/BigDecimal;Linstrumented/java/math/MathContext;)Linstrumented/java/math/BigDecimal;
        //   225: astore          4
        //   227: ldc             1
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: ldc             1
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: goto            268
        //   240: astore          5
        //   242: ldc             501
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: new             Ljava/lang/ArithmeticException;
        //   250: dup            
        //   251: ldc_w           "Non-terminating decimal expansion; no exact representable decimal result."
        //   254: ldc             4
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: invokespecial   java/lang/ArithmeticException.<init>:(Ljava/lang/String;)V
        //   262: ldc             1
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: athrow         
        //   268: aload           4
        //   270: ldc             2
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: invokevirtual   instrumented/java/math/BigDecimal.scale:()I
        //   278: istore          5
        //   280: ldc             1
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: iload_2        
        //   286: iload           5
        //   288: ldc             3
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: if_icmple       315
        //   296: aload           4
        //   298: iload_2        
        //   299: bipush          7
        //   301: ldc             4
        //   303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   306: invokevirtual   instrumented/java/math/BigDecimal.setScale:(II)Linstrumented/java/math/BigDecimal;
        //   309: ldc             1
        //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   314: areturn        
        //   315: aload           4
        //   317: ldc             2
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: areturn        
        //   323: athrow         
        //   324: athrow         
        //    StackMapTable: 00 08 37 14 FC 00 38 01 FF 00 6A 00 04 07 00 02 07 00 02 01 07 00 6F 00 01 07 01 A5 FC 00 1B 07 00 02 FC 00 2E 01 FF 00 07 00 00 00 01 07 00 6C FF 00 00 00 00 00 01 07 00 78
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  214    324    324    325    Ljava/lang/VirtualMachineError;
        //  214    232    240    268    Ljava/lang/ArithmeticException;
        //  0      323    323    324    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0268:
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
    
    public BigDecimal divide(final BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int n = precision;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(3);
                final BigDecimal divide = this.divide(bigDecimal);
                BytecodeManager.incBytecodes(1);
                return divide;
            }
            BytecodeManager.incBytecodes(2);
            final long n2 = this.scale - (long)bigDecimal.scale;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(2);
            final int signum = bigDecimal.signum();
            BytecodeManager.incBytecodes(1);
            if (signum == 0) {
                BytecodeManager.incBytecodes(2);
                final int signum2 = this.signum();
                BytecodeManager.incBytecodes(1);
                if (signum2 == 0) {
                    final String s = "Division undefined";
                    BytecodeManager.incBytecodes(4);
                    final ArithmeticException ex = new ArithmeticException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final String s2 = "Division by zero";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex2 = new ArithmeticException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            else {
                BytecodeManager.incBytecodes(2);
                final int signum3 = this.signum();
                BytecodeManager.incBytecodes(1);
                if (signum3 == 0) {
                    final long n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    final int saturateLong = saturateLong(n3);
                    BytecodeManager.incBytecodes(1);
                    final BigDecimal zeroValue = zeroValueOf(saturateLong);
                    BytecodeManager.incBytecodes(1);
                    return zeroValue;
                }
                BytecodeManager.incBytecodes(2);
                final int precision2 = this.precision();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final int precision3 = bigDecimal.precision();
                BytecodeManager.incBytecodes(1);
                final long n4 = lcmp(this.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n4 != 0) {
                    final long n5 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n5 != 0) {
                        final long intCompact = this.intCompact;
                        final int n6 = precision2;
                        final long intCompact2 = bigDecimal.intCompact;
                        final int n7 = precision3;
                        final long n8 = n2;
                        BytecodeManager.incBytecodes(9);
                        final BigDecimal divide2 = divide(intCompact, n6, intCompact2, n7, n8, mathContext);
                        BytecodeManager.incBytecodes(1);
                        return divide2;
                    }
                    final long intCompact3 = this.intCompact;
                    final int n9 = precision2;
                    final BigInteger intVal = bigDecimal.intVal;
                    final int n10 = precision3;
                    final long n11 = n2;
                    BytecodeManager.incBytecodes(9);
                    final BigDecimal divide3 = divide(intCompact3, n9, intVal, n10, n11, mathContext);
                    BytecodeManager.incBytecodes(1);
                    return divide3;
                }
                else {
                    final long n12 = lcmp(bigDecimal.intCompact, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n12 != 0) {
                        final BigInteger intVal2 = this.intVal;
                        final int n13 = precision2;
                        final long intCompact4 = bigDecimal.intCompact;
                        final int n14 = precision3;
                        final long n15 = n2;
                        BytecodeManager.incBytecodes(9);
                        final BigDecimal divide4 = divide(intVal2, n13, intCompact4, n14, n15, mathContext);
                        BytecodeManager.incBytecodes(1);
                        return divide4;
                    }
                    final BigInteger intVal3 = this.intVal;
                    final int n16 = precision2;
                    final BigInteger intVal4 = bigDecimal.intVal;
                    final int n17 = precision3;
                    final long n18 = n2;
                    BytecodeManager.incBytecodes(9);
                    final BigDecimal divide5 = divide(intVal3, n16, intVal4, n17, n18, mathContext);
                    BytecodeManager.incBytecodes(1);
                    return divide5;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal divideToIntegralValue(final BigDecimal bigDecimal) {
        try {
            final long n = this.scale - (long)bigDecimal.scale;
            BytecodeManager.incBytecodes(8);
            final int saturateLong = saturateLong(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final int compareMagnitude = this.compareMagnitude(bigDecimal);
            BytecodeManager.incBytecodes(1);
            if (compareMagnitude < 0) {
                final int n2 = saturateLong;
                BytecodeManager.incBytecodes(2);
                final BigDecimal zeroValue = zeroValueOf(n2);
                BytecodeManager.incBytecodes(1);
                return zeroValue;
            }
            BytecodeManager.incBytecodes(2);
            final int signum = this.signum();
            BytecodeManager.incBytecodes(1);
            if (signum == 0) {
                BytecodeManager.incBytecodes(2);
                final int signum2 = bigDecimal.signum();
                BytecodeManager.incBytecodes(1);
                if (signum2 != 0) {
                    final int n3 = saturateLong;
                    final int n4 = 7;
                    BytecodeManager.incBytecodes(4);
                    final BigDecimal setScale = this.setScale(n3, n4);
                    BytecodeManager.incBytecodes(1);
                    return setScale;
                }
            }
            BytecodeManager.incBytecodes(2);
            final long n5 = this.precision();
            final double n6 = 10.0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final double a = n6 * bigDecimal.precision() / 3.0;
            BytecodeManager.incBytecodes(5);
            final long n7 = n5 + (long)Math.ceil(a);
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final long n8 = this.scale();
            BytecodeManager.incBytecodes(3);
            final long a2 = n8 - bigDecimal.scale();
            BytecodeManager.incBytecodes(3);
            final long a3 = n7 + Math.abs(a2) + 2L;
            final long b = 2147483647L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final int n9 = (int)Math.min(a3, b);
            BytecodeManager.incBytecodes(2);
            final int n10 = n9;
            final RoundingMode down = RoundingMode.DOWN;
            BytecodeManager.incBytecodes(7);
            final MathContext mathContext = new MathContext(n10, down);
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal2 = this.divide(bigDecimal, mathContext);
            BytecodeManager.incBytecodes(1);
            final int scale = bigDecimal2.scale;
            BytecodeManager.incBytecodes(3);
            if (scale > 0) {
                final BigDecimal bigDecimal3 = bigDecimal2;
                final int n11 = 0;
                final RoundingMode down2 = RoundingMode.DOWN;
                BytecodeManager.incBytecodes(4);
                final BigDecimal setScale2 = bigDecimal3.setScale(n11, down2);
                BytecodeManager.incBytecodes(1);
                final BigInteger intVal = setScale2.intVal;
                final long intCompact = setScale2.intCompact;
                final int scale2 = setScale2.scale;
                final int n12 = saturateLong;
                BytecodeManager.incBytecodes(8);
                bigDecimal2 = stripZerosToMatchScale(intVal, intCompact, scale2, n12);
                BytecodeManager.incBytecodes(1);
            }
            final int scale3 = bigDecimal2.scale;
            final int n13 = saturateLong;
            BytecodeManager.incBytecodes(4);
            if (scale3 < n13) {
                final BigDecimal bigDecimal4 = bigDecimal2;
                final int n14 = saturateLong;
                final int n15 = 7;
                BytecodeManager.incBytecodes(4);
                bigDecimal2 = bigDecimal4.setScale(n14, n15);
                BytecodeManager.incBytecodes(1);
            }
            final BigDecimal bigDecimal5 = bigDecimal2;
            BytecodeManager.incBytecodes(2);
            return bigDecimal5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal divideToIntegralValue(final BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            if (precision != 0) {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final int compareMagnitude = this.compareMagnitude(bigDecimal);
                BytecodeManager.incBytecodes(1);
                if (compareMagnitude >= 0) {
                    final long n = this.scale - (long)bigDecimal.scale;
                    BytecodeManager.incBytecodes(8);
                    final int saturateLong = saturateLong(n);
                    BytecodeManager.incBytecodes(1);
                    final int precision2 = mathContext.precision;
                    final RoundingMode down = RoundingMode.DOWN;
                    BytecodeManager.incBytecodes(8);
                    final MathContext mathContext2 = new MathContext(precision2, down);
                    BytecodeManager.incBytecodes(1);
                    BigDecimal bigDecimal2 = this.divide(bigDecimal, mathContext2);
                    BytecodeManager.incBytecodes(1);
                    final BigDecimal bigDecimal3 = bigDecimal2;
                    BytecodeManager.incBytecodes(2);
                    final int scale = bigDecimal3.scale();
                    BytecodeManager.incBytecodes(1);
                    if (scale < 0) {
                        final BigDecimal bigDecimal4 = bigDecimal2;
                        BytecodeManager.incBytecodes(3);
                        final BigDecimal multiply = bigDecimal4.multiply(bigDecimal);
                        BytecodeManager.incBytecodes(1);
                        final BigDecimal bigDecimal5 = multiply;
                        BytecodeManager.incBytecodes(3);
                        final BigDecimal subtract = this.subtract(bigDecimal5);
                        BytecodeManager.incBytecodes(2);
                        final int compareMagnitude2 = subtract.compareMagnitude(bigDecimal);
                        BytecodeManager.incBytecodes(1);
                        if (compareMagnitude2 >= 0) {
                            final String s = "Division impossible";
                            BytecodeManager.incBytecodes(4);
                            final ArithmeticException ex = new ArithmeticException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final BigDecimal bigDecimal6 = bigDecimal2;
                        BytecodeManager.incBytecodes(2);
                        final int scale2 = bigDecimal6.scale();
                        BytecodeManager.incBytecodes(1);
                        if (scale2 > 0) {
                            final BigDecimal bigDecimal7 = bigDecimal2;
                            final int n2 = 0;
                            final RoundingMode down2 = RoundingMode.DOWN;
                            BytecodeManager.incBytecodes(4);
                            bigDecimal2 = bigDecimal7.setScale(n2, down2);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final int n3 = saturateLong;
                    final BigDecimal bigDecimal8 = bigDecimal2;
                    BytecodeManager.incBytecodes(3);
                    final int scale3 = bigDecimal8.scale();
                    BytecodeManager.incBytecodes(1);
                    if (n3 > scale3) {
                        final int precision3 = mathContext.precision;
                        final BigDecimal bigDecimal9 = bigDecimal2;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final int n4 = precision3 - bigDecimal9.precision();
                        BytecodeManager.incBytecodes(4);
                        if (n4 > 0) {
                            final BigDecimal bigDecimal10 = bigDecimal2;
                            final BigDecimal bigDecimal11 = bigDecimal2;
                            BytecodeManager.incBytecodes(3);
                            final int scale4 = bigDecimal11.scale();
                            final int a = n4;
                            final int b = saturateLong - bigDecimal2.scale;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final int scale5 = scale4 + Math.min(a, b);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final BigDecimal setScale = bigDecimal10.setScale(scale5);
                            BytecodeManager.incBytecodes(1);
                            return setScale;
                        }
                    }
                    final BigInteger intVal = bigDecimal2.intVal;
                    final long intCompact = bigDecimal2.intCompact;
                    final int scale6 = bigDecimal2.scale;
                    final int n5 = saturateLong;
                    BytecodeManager.incBytecodes(8);
                    final BigDecimal stripZerosToMatchScale = stripZerosToMatchScale(intVal, intCompact, scale6, n5);
                    BytecodeManager.incBytecodes(1);
                    return stripZerosToMatchScale;
                }
            }
            BytecodeManager.incBytecodes(3);
            final BigDecimal divideToIntegralValue = this.divideToIntegralValue(bigDecimal);
            BytecodeManager.incBytecodes(1);
            return divideToIntegralValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal remainder(final BigDecimal bigDecimal) {
        try {
            BytecodeManager.incBytecodes(3);
            final BigDecimal[] divideAndRemainder = this.divideAndRemainder(bigDecimal);
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal2 = divideAndRemainder[1];
            BytecodeManager.incBytecodes(4);
            return bigDecimal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal remainder(final BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(4);
            final BigDecimal[] divideAndRemainder = this.divideAndRemainder(bigDecimal, mathContext);
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal2 = divideAndRemainder[1];
            BytecodeManager.incBytecodes(4);
            return bigDecimal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal[] divideAndRemainder(final BigDecimal bigDecimal) {
        try {
            final BigDecimal[] array = new BigDecimal[2];
            BytecodeManager.incBytecodes(2);
            final BigDecimal[] array2 = array;
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            array2[n] = this.divideToIntegralValue(bigDecimal);
            BytecodeManager.incBytecodes(1);
            final BigDecimal[] array3 = array;
            final int n2 = 1;
            final BigDecimal bigDecimal2 = array[0];
            BytecodeManager.incBytecodes(8);
            final BigDecimal multiply = bigDecimal2.multiply(bigDecimal);
            BytecodeManager.incBytecodes(1);
            array3[n2] = this.subtract(multiply);
            BytecodeManager.incBytecodes(1);
            final BigDecimal[] array4 = array;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal[] divideAndRemainder(final BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            if (precision == 0) {
                BytecodeManager.incBytecodes(3);
                final BigDecimal[] divideAndRemainder = this.divideAndRemainder(bigDecimal);
                BytecodeManager.incBytecodes(1);
                return divideAndRemainder;
            }
            final BigDecimal[] array = new BigDecimal[2];
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final BigDecimal[] array2 = array;
            final int n = 0;
            BytecodeManager.incBytecodes(6);
            array2[n] = this.divideToIntegralValue(bigDecimal, mathContext);
            BytecodeManager.incBytecodes(1);
            final BigDecimal[] array3 = array;
            final int n2 = 1;
            final BigDecimal bigDecimal2 = array[0];
            BytecodeManager.incBytecodes(8);
            final BigDecimal multiply = bigDecimal2.multiply(bigDecimal);
            BytecodeManager.incBytecodes(1);
            array3[n2] = this.subtract(multiply);
            BytecodeManager.incBytecodes(1);
            final BigDecimal[] array4 = array;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal pow(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int n2 = 999999999;
                BytecodeManager.incBytecodes(3);
                if (n <= n2) {
                    final long n3 = this.scale * (long)n;
                    BytecodeManager.incBytecodes(8);
                    final int checkScale = this.checkScale(n3);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(4);
                    final BigInteger inflated = this.inflated();
                    BytecodeManager.incBytecodes(2);
                    final BigInteger pow = inflated.pow(n);
                    final int n4 = checkScale;
                    BytecodeManager.incBytecodes(2);
                    final BigDecimal bigDecimal = new BigDecimal(pow, n4);
                    BytecodeManager.incBytecodes(1);
                    return bigDecimal;
                }
            }
            final String s = "Invalid operation";
            BytecodeManager.incBytecodes(4);
            final ArithmeticException ex = new ArithmeticException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal pow(final int a, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            if (precision == 0) {
                BytecodeManager.incBytecodes(3);
                final BigDecimal pow = this.pow(a);
                BytecodeManager.incBytecodes(1);
                return pow;
            }
            final int n = -999999999;
            BytecodeManager.incBytecodes(3);
            if (a >= n) {
                final int n2 = 999999999;
                BytecodeManager.incBytecodes(3);
                if (a <= n2) {
                    BytecodeManager.incBytecodes(2);
                    if (a == 0) {
                        final BigDecimal one = BigDecimal.ONE;
                        BytecodeManager.incBytecodes(2);
                        return one;
                    }
                    BytecodeManager.incBytecodes(2);
                    MathContext mathContext2 = mathContext;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    int abs = Math.abs(a);
                    BytecodeManager.incBytecodes(1);
                    final int precision2 = mathContext.precision;
                    BytecodeManager.incBytecodes(3);
                    if (precision2 > 0) {
                        final long n3 = abs;
                        BytecodeManager.incBytecodes(3);
                        final int longDigitLength = longDigitLength(n3);
                        BytecodeManager.incBytecodes(1);
                        final int n4 = longDigitLength;
                        final int precision3 = mathContext.precision;
                        BytecodeManager.incBytecodes(4);
                        if (n4 > precision3) {
                            final String s = "Invalid operation";
                            BytecodeManager.incBytecodes(4);
                            final ArithmeticException ex = new ArithmeticException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        final int n5 = mathContext.precision + longDigitLength + 1;
                        final RoundingMode roundingMode = mathContext.roundingMode;
                        BytecodeManager.incBytecodes(11);
                        mathContext2 = new MathContext(n5, roundingMode);
                        BytecodeManager.incBytecodes(1);
                    }
                    BigDecimal bigDecimal = BigDecimal.ONE;
                    BytecodeManager.incBytecodes(2);
                    int n6 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n7 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        abs += abs;
                        BytecodeManager.incBytecodes(4);
                        final int n8 = abs;
                        BytecodeManager.incBytecodes(2);
                        if (n8 < 0) {
                            n6 = 1;
                            BytecodeManager.incBytecodes(2);
                            final BigDecimal bigDecimal2 = bigDecimal;
                            final MathContext mathContext3 = mathContext2;
                            BytecodeManager.incBytecodes(4);
                            bigDecimal = bigDecimal2.multiply(this, mathContext3);
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n9 = n7;
                        final int n10 = 31;
                        BytecodeManager.incBytecodes(3);
                        if (n9 == n10) {
                            break;
                        }
                        final int n11 = n6;
                        BytecodeManager.incBytecodes(2);
                        if (n11 != 0) {
                            final BigDecimal bigDecimal3 = bigDecimal;
                            final BigDecimal bigDecimal4 = bigDecimal;
                            final MathContext mathContext4 = mathContext2;
                            BytecodeManager.incBytecodes(4);
                            bigDecimal = bigDecimal3.multiply(bigDecimal4, mathContext4);
                            BytecodeManager.incBytecodes(1);
                        }
                        ++n7;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    if (a < 0) {
                        final BigDecimal one2 = BigDecimal.ONE;
                        final BigDecimal bigDecimal5 = bigDecimal;
                        final MathContext mathContext5 = mathContext2;
                        BytecodeManager.incBytecodes(4);
                        bigDecimal = one2.divide(bigDecimal5, mathContext5);
                        BytecodeManager.incBytecodes(1);
                    }
                    final BigDecimal bigDecimal6 = bigDecimal;
                    BytecodeManager.incBytecodes(3);
                    final BigDecimal doRound = doRound(bigDecimal6, mathContext);
                    BytecodeManager.incBytecodes(1);
                    return doRound;
                }
            }
            final String s2 = "Invalid operation";
            BytecodeManager.incBytecodes(4);
            final ArithmeticException ex2 = new ArithmeticException(s2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal abs() {
        try {
            BytecodeManager.incBytecodes(2);
            final int signum = this.signum();
            BytecodeManager.incBytecodes(1);
            BigDecimal negate;
            if (signum < 0) {
                BytecodeManager.incBytecodes(2);
                negate = this.negate();
                BytecodeManager.incBytecodes(1);
            }
            else {
                negate = this;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return negate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal abs(final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(2);
            final int signum = this.signum();
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal;
            if (signum < 0) {
                BytecodeManager.incBytecodes(3);
                bigDecimal = this.negate(mathContext);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(3);
                bigDecimal = this.plus(mathContext);
            }
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal negate() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n == 0) {
                final BigInteger intVal = this.intVal;
                BytecodeManager.incBytecodes(5);
                final BigInteger negate = intVal.negate();
                final long n2 = Long.MIN_VALUE;
                final int scale = this.scale;
                final int precision = this.precision;
                BytecodeManager.incBytecodes(6);
                final BigDecimal bigDecimal = new BigDecimal(negate, n2, scale, precision);
                BytecodeManager.incBytecodes(1);
                return bigDecimal;
            }
            final long n3 = -this.intCompact;
            final int scale2 = this.scale;
            final int precision2 = this.precision;
            BytecodeManager.incBytecodes(8);
            final BigDecimal value = valueOf(n3, scale2, precision2);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal negate(final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(2);
            final BigDecimal negate = this.negate();
            BytecodeManager.incBytecodes(2);
            final BigDecimal plus = negate.plus(mathContext);
            BytecodeManager.incBytecodes(1);
            return plus;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal plus() {
        try {
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal plus(final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            if (precision == 0) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(this, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int signum() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            int n2;
            if (n != 0) {
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                n2 = Long.signum(intCompact);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final BigInteger intVal = this.intVal;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                n2 = intVal.signum();
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int scale() {
        try {
            final int scale = this.scale;
            BytecodeManager.incBytecodes(3);
            return scale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int precision() {
        try {
            int precision = this.precision;
            BytecodeManager.incBytecodes(3);
            final int n = precision;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(3);
                final long n2 = lcmp(intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n2 != 0) {
                    final long n3 = intCompact;
                    BytecodeManager.incBytecodes(2);
                    precision = longDigitLength(n3);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final BigInteger intVal = this.intVal;
                    BytecodeManager.incBytecodes(3);
                    precision = bigDigitLength(intVal);
                    BytecodeManager.incBytecodes(1);
                }
                this.precision = precision;
                BytecodeManager.incBytecodes(3);
            }
            final int n4 = precision;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger unscaledValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final BigInteger inflated = this.inflated();
            BytecodeManager.incBytecodes(1);
            return inflated;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal round(final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(3);
            final BigDecimal plus = this.plus(mathContext);
            BytecodeManager.incBytecodes(1);
            return plus;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal setScale(final int n, final RoundingMode roundingMode) {
        try {
            final int oldMode = roundingMode.oldMode;
            BytecodeManager.incBytecodes(5);
            final BigDecimal setScale = this.setScale(n, oldMode);
            BytecodeManager.incBytecodes(1);
            return setScale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal setScale(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n2 >= 0) {
                final int n3 = 7;
                BytecodeManager.incBytecodes(3);
                if (n2 <= n3) {
                    final int scale = this.scale;
                    BytecodeManager.incBytecodes(3);
                    final int n4 = scale;
                    BytecodeManager.incBytecodes(3);
                    if (n == n4) {
                        BytecodeManager.incBytecodes(2);
                        return this;
                    }
                    BytecodeManager.incBytecodes(2);
                    final int signum = this.signum();
                    BytecodeManager.incBytecodes(1);
                    if (signum == 0) {
                        BytecodeManager.incBytecodes(2);
                        final BigDecimal zeroValue = zeroValueOf(n);
                        BytecodeManager.incBytecodes(1);
                        return zeroValue;
                    }
                    final long n5 = lcmp(this.intCompact, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n5 != 0) {
                        final long intCompact = this.intCompact;
                        BytecodeManager.incBytecodes(3);
                        final int n6 = scale;
                        BytecodeManager.incBytecodes(3);
                        if (n > n6) {
                            final long n7 = n - (long)scale;
                            BytecodeManager.incBytecodes(7);
                            final int checkScale = this.checkScale(n7);
                            BytecodeManager.incBytecodes(1);
                            final long n8 = intCompact;
                            final int n9 = checkScale;
                            BytecodeManager.incBytecodes(3);
                            final long longMultiplyPowerTen;
                            final long n10 = lcmp(longMultiplyPowerTen = longMultiplyPowerTen(n8, n9), Long.MIN_VALUE);
                            BytecodeManager.incBytecodes(5);
                            if (n10 != 0) {
                                final long n11 = longMultiplyPowerTen;
                                BytecodeManager.incBytecodes(3);
                                final BigDecimal value = valueOf(n11, n);
                                BytecodeManager.incBytecodes(1);
                                return value;
                            }
                            final int n12 = checkScale;
                            BytecodeManager.incBytecodes(3);
                            final BigInteger bigMultiplyPowerTen = this.bigMultiplyPowerTen(n12);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger bigInteger = bigMultiplyPowerTen;
                            final long n13 = Long.MIN_VALUE;
                            final int precision = this.precision;
                            BytecodeManager.incBytecodes(8);
                            int n14;
                            if (precision > 0) {
                                n14 = this.precision + checkScale;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                n14 = 0;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            final BigDecimal bigDecimal = new BigDecimal(bigInteger, n13, n, n14);
                            BytecodeManager.incBytecodes(1);
                            return bigDecimal;
                        }
                        else {
                            final long n15 = scale - (long)n;
                            BytecodeManager.incBytecodes(7);
                            final int checkScale2 = this.checkScale(n15);
                            BytecodeManager.incBytecodes(1);
                            final int n16 = checkScale2;
                            final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
                            BytecodeManager.incBytecodes(4);
                            if (n16 < length) {
                                final long n17 = intCompact;
                                final long n18 = BigDecimal.LONG_TEN_POWERS_TABLE[checkScale2];
                                BytecodeManager.incBytecodes(8);
                                final BigDecimal divideAndRound = divideAndRound(n17, n18, n, n2, n);
                                BytecodeManager.incBytecodes(1);
                                return divideAndRound;
                            }
                            BytecodeManager.incBytecodes(2);
                            final BigInteger inflated = this.inflated();
                            final int n19 = checkScale2;
                            BytecodeManager.incBytecodes(2);
                            final BigInteger bigTenToThe = bigTenToThe(n19);
                            BytecodeManager.incBytecodes(4);
                            final BigDecimal divideAndRound2 = divideAndRound(inflated, bigTenToThe, n, n2, n);
                            BytecodeManager.incBytecodes(1);
                            return divideAndRound2;
                        }
                    }
                    else {
                        final int n20 = scale;
                        BytecodeManager.incBytecodes(3);
                        if (n > n20) {
                            final long n21 = n - (long)scale;
                            BytecodeManager.incBytecodes(7);
                            final int checkScale3 = this.checkScale(n21);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger intVal = this.intVal;
                            final int n22 = checkScale3;
                            BytecodeManager.incBytecodes(4);
                            final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(intVal, n22);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger bigInteger2 = bigMultiplyPowerTen2;
                            final long n23 = Long.MIN_VALUE;
                            final int precision2 = this.precision;
                            BytecodeManager.incBytecodes(8);
                            int n24;
                            if (precision2 > 0) {
                                n24 = this.precision + checkScale3;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                n24 = 0;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            final BigDecimal bigDecimal2 = new BigDecimal(bigInteger2, n23, n, n24);
                            BytecodeManager.incBytecodes(1);
                            return bigDecimal2;
                        }
                        final long n25 = scale - (long)n;
                        BytecodeManager.incBytecodes(7);
                        final int checkScale4 = this.checkScale(n25);
                        BytecodeManager.incBytecodes(1);
                        final int n26 = checkScale4;
                        final int length2 = BigDecimal.LONG_TEN_POWERS_TABLE.length;
                        BytecodeManager.incBytecodes(4);
                        if (n26 < length2) {
                            final BigInteger intVal2 = this.intVal;
                            final long n27 = BigDecimal.LONG_TEN_POWERS_TABLE[checkScale4];
                            BytecodeManager.incBytecodes(9);
                            final BigDecimal divideAndRound3 = divideAndRound(intVal2, n27, n, n2, n);
                            BytecodeManager.incBytecodes(1);
                            return divideAndRound3;
                        }
                        final BigInteger intVal3 = this.intVal;
                        final int n28 = checkScale4;
                        BytecodeManager.incBytecodes(4);
                        final BigInteger bigTenToThe2 = bigTenToThe(n28);
                        BytecodeManager.incBytecodes(4);
                        final BigDecimal divideAndRound4 = divideAndRound(intVal3, bigTenToThe2, n, n2, n);
                        BytecodeManager.incBytecodes(1);
                        return divideAndRound4;
                    }
                }
            }
            final String s = "Invalid rounding mode";
            BytecodeManager.incBytecodes(4);
            final IllegalArgumentException ex = new IllegalArgumentException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal setScale(final int n) {
        try {
            final int n2 = 7;
            BytecodeManager.incBytecodes(4);
            final BigDecimal setScale = this.setScale(n, n2);
            BytecodeManager.incBytecodes(1);
            return setScale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal movePointLeft(final int n) {
        try {
            final long n2 = this.scale + (long)n;
            BytecodeManager.incBytecodes(8);
            final int checkScale = this.checkScale(n2);
            BytecodeManager.incBytecodes(1);
            final BigInteger intVal = this.intVal;
            final long intCompact = this.intCompact;
            final int n3 = checkScale;
            final int n4 = 0;
            BytecodeManager.incBytecodes(9);
            final BigDecimal bigDecimal = new BigDecimal(intVal, intCompact, n3, n4);
            BytecodeManager.incBytecodes(1);
            final int scale = bigDecimal.scale;
            BytecodeManager.incBytecodes(3);
            BigDecimal setScale;
            if (scale < 0) {
                final BigDecimal bigDecimal2 = bigDecimal;
                final int n5 = 0;
                final int n6 = 7;
                BytecodeManager.incBytecodes(4);
                setScale = bigDecimal2.setScale(n5, n6);
                BytecodeManager.incBytecodes(1);
            }
            else {
                setScale = bigDecimal;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return setScale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal movePointRight(final int n) {
        try {
            final long n2 = this.scale - (long)n;
            BytecodeManager.incBytecodes(8);
            final int checkScale = this.checkScale(n2);
            BytecodeManager.incBytecodes(1);
            final BigInteger intVal = this.intVal;
            final long intCompact = this.intCompact;
            final int n3 = checkScale;
            final int n4 = 0;
            BytecodeManager.incBytecodes(9);
            final BigDecimal bigDecimal = new BigDecimal(intVal, intCompact, n3, n4);
            BytecodeManager.incBytecodes(1);
            final int scale = bigDecimal.scale;
            BytecodeManager.incBytecodes(3);
            BigDecimal setScale;
            if (scale < 0) {
                final BigDecimal bigDecimal2 = bigDecimal;
                final int n5 = 0;
                final int n6 = 7;
                BytecodeManager.incBytecodes(4);
                setScale = bigDecimal2.setScale(n5, n6);
                BytecodeManager.incBytecodes(1);
            }
            else {
                setScale = bigDecimal;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return setScale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal scaleByPowerOfTen(final int n) {
        try {
            final BigInteger intVal = this.intVal;
            final long intCompact = this.intCompact;
            final long n2 = this.scale - (long)n;
            BytecodeManager.incBytecodes(13);
            BytecodeManager.incBytecodes(1);
            final int checkScale = this.checkScale(n2);
            final int precision = this.precision;
            BytecodeManager.incBytecodes(3);
            final BigDecimal bigDecimal = new BigDecimal(intVal, intCompact, checkScale, precision);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal stripTrailingZeros() {
        try {
            final long n = lcmp(this.intCompact, 0L);
            BytecodeManager.incBytecodes(5);
            Label_0046: {
                if (n != 0) {
                    final BigInteger intVal = this.intVal;
                    BytecodeManager.incBytecodes(3);
                    if (intVal != null) {
                        final BigInteger intVal2 = this.intVal;
                        BytecodeManager.incBytecodes(3);
                        final int signum = intVal2.signum();
                        BytecodeManager.incBytecodes(1);
                        if (signum == 0) {
                            break Label_0046;
                        }
                    }
                    final long n2 = lcmp(this.intCompact, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n2 != 0) {
                        final long intCompact = this.intCompact;
                        final int scale = this.scale;
                        final long n3 = Long.MIN_VALUE;
                        BytecodeManager.incBytecodes(6);
                        final BigDecimal andStripZerosToMatchScale = createAndStripZerosToMatchScale(intCompact, scale, n3);
                        BytecodeManager.incBytecodes(1);
                        return andStripZerosToMatchScale;
                    }
                    final BigInteger intVal3 = this.intVal;
                    final int scale2 = this.scale;
                    final long n4 = Long.MIN_VALUE;
                    BytecodeManager.incBytecodes(6);
                    final BigDecimal andStripZerosToMatchScale2 = createAndStripZerosToMatchScale(intVal3, scale2, n4);
                    BytecodeManager.incBytecodes(1);
                    return andStripZerosToMatchScale2;
                }
            }
            final BigDecimal zero = BigDecimal.ZERO;
            BytecodeManager.incBytecodes(2);
            return zero;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int compareTo(final BigDecimal bigDecimal) {
        try {
            final int scale = this.scale;
            final int scale2 = bigDecimal.scale;
            BytecodeManager.incBytecodes(5);
            if (scale == scale2) {
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(3);
                final long intCompact2 = bigDecimal.intCompact;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n != 0) {
                    final long n2 = lcmp(intCompact2, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(4);
                    if (n2 != 0) {
                        final long n3 = lcmp(intCompact, intCompact2);
                        BytecodeManager.incBytecodes(4);
                        int n5;
                        if (n3 != 0) {
                            final long n4 = lcmp(intCompact, intCompact2);
                            BytecodeManager.incBytecodes(4);
                            if (n4 > 0) {
                                n5 = 1;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                n5 = -1;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        else {
                            n5 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return n5;
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            final int signum = this.signum();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int signum2 = bigDecimal.signum();
            BytecodeManager.incBytecodes(1);
            final int n6 = signum;
            final int n7 = signum2;
            BytecodeManager.incBytecodes(3);
            if (n6 != n7) {
                final int n8 = signum;
                final int n9 = signum2;
                BytecodeManager.incBytecodes(3);
                int n10;
                if (n8 > n9) {
                    n10 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n10 = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n10;
            }
            final int n11 = signum;
            BytecodeManager.incBytecodes(2);
            if (n11 == 0) {
                final int n12 = 0;
                BytecodeManager.incBytecodes(2);
                return n12;
            }
            BytecodeManager.incBytecodes(3);
            final int compareMagnitude = this.compareMagnitude(bigDecimal);
            BytecodeManager.incBytecodes(1);
            final int n13 = signum;
            BytecodeManager.incBytecodes(2);
            int n14;
            if (n13 > 0) {
                n14 = compareMagnitude;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n14 = -compareMagnitude;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return n14;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int compareMagnitude(final BigDecimal bigDecimal) {
        try {
            long n = bigDecimal.intCompact;
            BytecodeManager.incBytecodes(3);
            long n2 = this.intCompact;
            BytecodeManager.incBytecodes(3);
            final long n3 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 == 0) {
                final long n4 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(4);
                int n5;
                if (n4 == 0) {
                    n5 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n5 = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n5;
            }
            final long n6 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n6 == 0) {
                final int n7 = 1;
                BytecodeManager.incBytecodes(2);
                return n7;
            }
            final long n8 = this.scale - (long)bigDecimal.scale;
            BytecodeManager.incBytecodes(8);
            final long n9 = lcmp(n8, 0L);
            BytecodeManager.incBytecodes(4);
            Label_0445: {
                if (n9 != 0) {
                    BytecodeManager.incBytecodes(2);
                    final long n10 = this.precision() - (long)this.scale;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(2);
                    final long n11 = bigDecimal.precision() - (long)bigDecimal.scale;
                    BytecodeManager.incBytecodes(6);
                    final long n12 = lcmp(n10, n11);
                    BytecodeManager.incBytecodes(4);
                    if (n12 < 0) {
                        final int n13 = -1;
                        BytecodeManager.incBytecodes(2);
                        return n13;
                    }
                    final long n14 = lcmp(n10, n11);
                    BytecodeManager.incBytecodes(4);
                    if (n14 > 0) {
                        final int n15 = 1;
                        BytecodeManager.incBytecodes(2);
                        return n15;
                    }
                    BytecodeManager.incBytecodes(2);
                    final long n16 = lcmp(n8, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n16 < 0) {
                        final long n17 = lcmp(n8, -2147483648L);
                        BytecodeManager.incBytecodes(4);
                        if (n17 > 0) {
                            final long n18 = lcmp(n2, Long.MIN_VALUE);
                            BytecodeManager.incBytecodes(4);
                            if (n18 != 0) {
                                final long n19 = n2;
                                final int n20 = (int)(-n8);
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final long n21 = lcmp(n2 = longMultiplyPowerTen(n19, n20), Long.MIN_VALUE);
                                BytecodeManager.incBytecodes(5);
                                if (n21 != 0) {
                                    break Label_0445;
                                }
                            }
                            final long n22 = lcmp(n, Long.MIN_VALUE);
                            BytecodeManager.incBytecodes(4);
                            if (n22 == 0) {
                                final int n23 = (int)(-n8);
                                BytecodeManager.incBytecodes(5);
                                final BigInteger bigMultiplyPowerTen = this.bigMultiplyPowerTen(n23);
                                BytecodeManager.incBytecodes(1);
                                final BigInteger bigInteger = bigMultiplyPowerTen;
                                final BigInteger intVal = bigDecimal.intVal;
                                BytecodeManager.incBytecodes(4);
                                final int compareMagnitude = bigInteger.compareMagnitude(intVal);
                                BytecodeManager.incBytecodes(1);
                                return compareMagnitude;
                            }
                        }
                    }
                    else {
                        final long n24 = lcmp(n8, 2147483647L);
                        BytecodeManager.incBytecodes(4);
                        if (n24 <= 0) {
                            final long n25 = lcmp(n, Long.MIN_VALUE);
                            BytecodeManager.incBytecodes(4);
                            if (n25 != 0) {
                                final long n26 = n;
                                final int n27 = (int)n8;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final long n28 = lcmp(n = longMultiplyPowerTen(n26, n27), Long.MIN_VALUE);
                                BytecodeManager.incBytecodes(5);
                                if (n28 != 0) {
                                    break Label_0445;
                                }
                            }
                            final long n29 = lcmp(n2, Long.MIN_VALUE);
                            BytecodeManager.incBytecodes(4);
                            if (n29 == 0) {
                                final int n30 = (int)n8;
                                BytecodeManager.incBytecodes(4);
                                final BigInteger bigMultiplyPowerTen2 = bigDecimal.bigMultiplyPowerTen(n30);
                                BytecodeManager.incBytecodes(1);
                                final BigInteger intVal2 = this.intVal;
                                final BigInteger bigInteger2 = bigMultiplyPowerTen2;
                                BytecodeManager.incBytecodes(4);
                                final int compareMagnitude2 = intVal2.compareMagnitude(bigInteger2);
                                BytecodeManager.incBytecodes(1);
                                return compareMagnitude2;
                            }
                        }
                    }
                }
            }
            final long n31 = lcmp(n2, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n31 != 0) {
                final long n32 = lcmp(n, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                int longCompareMagnitude;
                if (n32 != 0) {
                    final long n33 = n2;
                    final long n34 = n;
                    BytecodeManager.incBytecodes(3);
                    longCompareMagnitude = longCompareMagnitude(n33, n34);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    longCompareMagnitude = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return longCompareMagnitude;
            }
            final long n35 = lcmp(n, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n35 != 0) {
                final int n36 = 1;
                BytecodeManager.incBytecodes(2);
                return n36;
            }
            final BigInteger intVal3 = this.intVal;
            final BigInteger intVal4 = bigDecimal.intVal;
            BytecodeManager.incBytecodes(5);
            final int compareMagnitude3 = intVal3.compareMagnitude(intVal4);
            BytecodeManager.incBytecodes(1);
            return compareMagnitude3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            final boolean b = o instanceof BigDecimal;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final BigDecimal bigDecimal = (BigDecimal)o;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            if (o == this) {
                final boolean b3 = true;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final int scale = this.scale;
            final int scale2 = bigDecimal.scale;
            BytecodeManager.incBytecodes(5);
            if (scale != scale2) {
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            final long intCompact = this.intCompact;
            BytecodeManager.incBytecodes(3);
            long n = bigDecimal.intCompact;
            BytecodeManager.incBytecodes(3);
            final long n2 = lcmp(intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n2 != 0) {
                final long n3 = lcmp(n, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n3 == 0) {
                    final BigInteger intVal = bigDecimal.intVal;
                    BytecodeManager.incBytecodes(3);
                    n = compactValFor(intVal);
                    BytecodeManager.incBytecodes(1);
                }
                final long n4 = lcmp(n, intCompact);
                BytecodeManager.incBytecodes(4);
                boolean b5;
                if (n4 == 0) {
                    b5 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b5 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b5;
            }
            final long n5 = lcmp(n, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n5 != 0) {
                final long n6 = n;
                final BigInteger intVal2 = this.intVal;
                BytecodeManager.incBytecodes(4);
                final long n7 = lcmp(n6, compactValFor(intVal2));
                BytecodeManager.incBytecodes(2);
                boolean b6;
                if (n7 == 0) {
                    b6 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b6 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b6;
            }
            BytecodeManager.incBytecodes(2);
            final BigInteger inflated = this.inflated();
            final BigDecimal bigDecimal2 = bigDecimal;
            BytecodeManager.incBytecodes(2);
            final BigInteger inflated2 = bigDecimal2.inflated();
            BytecodeManager.incBytecodes(1);
            final boolean equals = inflated.equals(inflated2);
            BytecodeManager.incBytecodes(1);
            return equals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal min(final BigDecimal bigDecimal) {
        try {
            BytecodeManager.incBytecodes(3);
            final int compareTo = this.compareTo(bigDecimal);
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal2;
            if (compareTo <= 0) {
                bigDecimal2 = this;
                BytecodeManager.incBytecodes(2);
            }
            else {
                bigDecimal2 = bigDecimal;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return bigDecimal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal max(final BigDecimal bigDecimal) {
        try {
            BytecodeManager.incBytecodes(3);
            final int compareTo = this.compareTo(bigDecimal);
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal2;
            if (compareTo >= 0) {
                bigDecimal2 = this;
                BytecodeManager.incBytecodes(2);
            }
            else {
                bigDecimal2 = bigDecimal;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return bigDecimal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                final long n2 = lcmp(this.intCompact, 0L);
                BytecodeManager.incBytecodes(5);
                long intCompact;
                if (n2 < 0) {
                    intCompact = -this.intCompact;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    intCompact = this.intCompact;
                    BytecodeManager.incBytecodes(2);
                }
                final long n3 = intCompact;
                BytecodeManager.incBytecodes(1);
                final int n4 = (int)((int)(n3 >>> 32) * 31 + (n3 & 0xFFFFFFFFL));
                BytecodeManager.incBytecodes(13);
                final int n5 = 31;
                final long n6 = lcmp(this.intCompact, 0L);
                BytecodeManager.incBytecodes(6);
                int n7;
                if (n6 < 0) {
                    n7 = -n4;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n7 = n4;
                    BytecodeManager.incBytecodes(1);
                }
                final int n8 = n5 * n7 + this.scale;
                BytecodeManager.incBytecodes(5);
                return n8;
            }
            final int n9 = 31;
            final BigInteger intVal = this.intVal;
            BytecodeManager.incBytecodes(4);
            final int n10 = n9 * intVal.hashCode() + this.scale;
            BytecodeManager.incBytecodes(5);
            return n10;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            String stringCache = this.stringCache;
            BytecodeManager.incBytecodes(3);
            final String s = stringCache;
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                final boolean b = true;
                BytecodeManager.incBytecodes(4);
                stringCache = (this.stringCache = this.layoutChars(b));
                BytecodeManager.incBytecodes(3);
            }
            final String s2 = stringCache;
            BytecodeManager.incBytecodes(2);
            return s2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String toEngineeringString() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final String layoutChars = this.layoutChars(b);
            BytecodeManager.incBytecodes(1);
            return layoutChars;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String toPlainString() {
        try {
            final int scale = this.scale;
            BytecodeManager.incBytecodes(3);
            if (scale == 0) {
                final long n = lcmp(this.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n != 0) {
                    final long intCompact = this.intCompact;
                    BytecodeManager.incBytecodes(3);
                    final String string = Long.toString(intCompact);
                    BytecodeManager.incBytecodes(1);
                    return string;
                }
                final BigInteger intVal = this.intVal;
                BytecodeManager.incBytecodes(3);
                final String string2 = intVal.toString();
                BytecodeManager.incBytecodes(1);
                return string2;
            }
            else {
                final int scale2 = this.scale;
                BytecodeManager.incBytecodes(3);
                if (scale2 >= 0) {
                    final long n2 = lcmp(this.intCompact, Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    String s;
                    if (n2 != 0) {
                        final long intCompact2 = this.intCompact;
                        BytecodeManager.incBytecodes(3);
                        final long abs = Math.abs(intCompact2);
                        BytecodeManager.incBytecodes(1);
                        s = Long.toString(abs);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final BigInteger intVal2 = this.intVal;
                        BytecodeManager.incBytecodes(3);
                        final BigInteger abs2 = intVal2.abs();
                        BytecodeManager.incBytecodes(1);
                        s = abs2.toString();
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(3);
                    final int signum = this.signum();
                    final String s2 = s;
                    final int scale3 = this.scale;
                    BytecodeManager.incBytecodes(4);
                    final String valueString = this.getValueString(signum, s2, scale3);
                    BytecodeManager.incBytecodes(1);
                    return valueString;
                }
                BytecodeManager.incBytecodes(2);
                final int signum2 = this.signum();
                BytecodeManager.incBytecodes(1);
                if (signum2 == 0) {
                    final String s3 = "0";
                    BytecodeManager.incBytecodes(2);
                    return s3;
                }
                final long n3 = -this.scale;
                BytecodeManager.incBytecodes(5);
                final int checkScaleNonZero = checkScaleNonZero(n3);
                BytecodeManager.incBytecodes(1);
                final long n4 = lcmp(this.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                StringBuilder sb;
                if (n4 != 0) {
                    final int capacity = 20 + checkScaleNonZero;
                    BytecodeManager.incBytecodes(6);
                    sb = new StringBuilder(capacity);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb2 = sb;
                    final long intCompact3 = this.intCompact;
                    BytecodeManager.incBytecodes(4);
                    sb2.append(intCompact3);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final BigInteger intVal3 = this.intVal;
                    BytecodeManager.incBytecodes(3);
                    final String string3 = intVal3.toString();
                    BytecodeManager.incBytecodes(1);
                    final String s4 = string3;
                    BytecodeManager.incBytecodes(4);
                    final int capacity2 = s4.length() + checkScaleNonZero;
                    BytecodeManager.incBytecodes(3);
                    sb = new StringBuilder(capacity2);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb3 = sb;
                    final String str = string3;
                    BytecodeManager.incBytecodes(3);
                    sb3.append(str);
                    BytecodeManager.incBytecodes(1);
                }
                int n5 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = n5;
                    final int n7 = checkScaleNonZero;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n7) {
                        break;
                    }
                    final StringBuilder sb4 = sb;
                    final char c = '0';
                    BytecodeManager.incBytecodes(3);
                    sb4.append(c);
                    BytecodeManager.incBytecodes(1);
                    ++n5;
                    BytecodeManager.incBytecodes(2);
                }
                final StringBuilder sb5 = sb;
                BytecodeManager.incBytecodes(2);
                final String string4 = sb5.toString();
                BytecodeManager.incBytecodes(1);
                return string4;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String getValueString(final int n, final String str, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n3 = str.length() - n2;
            BytecodeManager.incBytecodes(3);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 == 0) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                String str2;
                if (n < 0) {
                    str2 = "-0.";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    str2 = "0.";
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            final int n5 = n3;
            BytecodeManager.incBytecodes(2);
            StringBuilder sb2;
            if (n5 > 0) {
                BytecodeManager.incBytecodes(4);
                sb2 = new StringBuilder(str);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb3 = sb2;
                final int offset = n3;
                final char c = '.';
                BytecodeManager.incBytecodes(4);
                sb3.insert(offset, c);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                if (n < 0) {
                    final StringBuilder sb4 = sb2;
                    final int offset2 = 0;
                    final char c2 = '-';
                    BytecodeManager.incBytecodes(4);
                    sb4.insert(offset2, c2);
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                final int n6 = 3 - n3;
                BytecodeManager.incBytecodes(7);
                final int capacity = n6 + str.length();
                BytecodeManager.incBytecodes(2);
                sb2 = new StringBuilder(capacity);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb5 = sb2;
                BytecodeManager.incBytecodes(3);
                String str3;
                if (n < 0) {
                    str3 = "-0.";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    str3 = "0.";
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                sb5.append(str3);
                BytecodeManager.incBytecodes(1);
                int n7 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n8 = n7;
                    final int n9 = -n3;
                    BytecodeManager.incBytecodes(4);
                    if (n8 >= n9) {
                        break;
                    }
                    final StringBuilder sb6 = sb2;
                    final char c3 = '0';
                    BytecodeManager.incBytecodes(3);
                    sb6.append(c3);
                    BytecodeManager.incBytecodes(1);
                    ++n7;
                    BytecodeManager.incBytecodes(2);
                }
                final StringBuilder sb7 = sb2;
                BytecodeManager.incBytecodes(3);
                sb7.append(str);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder sb8 = sb2;
            BytecodeManager.incBytecodes(2);
            final String string2 = sb8.toString();
            BytecodeManager.incBytecodes(1);
            return string2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger toBigInteger() {
        try {
            final int n = 0;
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final BigDecimal setScale = this.setScale(n, n2);
            BytecodeManager.incBytecodes(1);
            final BigInteger inflated = setScale.inflated();
            BytecodeManager.incBytecodes(1);
            return inflated;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigInteger toBigIntegerExact() {
        try {
            final int n = 0;
            final int n2 = 7;
            BytecodeManager.incBytecodes(4);
            final BigDecimal setScale = this.setScale(n, n2);
            BytecodeManager.incBytecodes(1);
            final BigInteger inflated = setScale.inflated();
            BytecodeManager.incBytecodes(1);
            return inflated;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long longValue() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            long n2 = 0L;
            Label_0062: {
                if (n != 0) {
                    final int scale = this.scale;
                    BytecodeManager.incBytecodes(3);
                    if (scale == 0) {
                        n2 = this.intCompact;
                        BytecodeManager.incBytecodes(3);
                        break Label_0062;
                    }
                }
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger = this.toBigInteger();
                BytecodeManager.incBytecodes(1);
                n2 = bigInteger.longValue();
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long longValueExact() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                final int scale = this.scale;
                BytecodeManager.incBytecodes(3);
                if (scale == 0) {
                    final long intCompact = this.intCompact;
                    BytecodeManager.incBytecodes(3);
                    return intCompact;
                }
            }
            BytecodeManager.incBytecodes(2);
            final int n2 = this.precision() - this.scale;
            final int n3 = 19;
            BytecodeManager.incBytecodes(5);
            if (n2 > n3) {
                final String s = "Overflow";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int signum = this.signum();
            BytecodeManager.incBytecodes(1);
            if (signum == 0) {
                final long n4 = 0L;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            BytecodeManager.incBytecodes(2);
            final int n5 = this.precision() - this.scale;
            BytecodeManager.incBytecodes(4);
            if (n5 <= 0) {
                final String s2 = "Rounding necessary";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex2 = new ArithmeticException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n6 = 0;
            final int n7 = 7;
            BytecodeManager.incBytecodes(4);
            final BigDecimal setScale = this.setScale(n6, n7);
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal = setScale;
            BytecodeManager.incBytecodes(2);
            final int precision = bigDecimal.precision();
            final int n8 = 19;
            BytecodeManager.incBytecodes(2);
            if (precision >= n8) {
                final BigDecimal bigDecimal2 = setScale;
                BytecodeManager.incBytecodes(2);
                LongOverflow.check(bigDecimal2);
            }
            final BigDecimal bigDecimal3 = setScale;
            BytecodeManager.incBytecodes(2);
            final BigInteger inflated = bigDecimal3.inflated();
            BytecodeManager.incBytecodes(1);
            final long longValue = inflated.longValue();
            BytecodeManager.incBytecodes(1);
            return longValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int intValue() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            int intValue = 0;
            Label_0063: {
                if (n != 0) {
                    final int scale = this.scale;
                    BytecodeManager.incBytecodes(3);
                    if (scale == 0) {
                        intValue = (int)this.intCompact;
                        BytecodeManager.incBytecodes(4);
                        break Label_0063;
                    }
                }
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger = this.toBigInteger();
                BytecodeManager.incBytecodes(1);
                intValue = bigInteger.intValue();
            }
            BytecodeManager.incBytecodes(1);
            return intValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int intValueExact() {
        try {
            BytecodeManager.incBytecodes(2);
            final long longValueExact = this.longValueExact();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp((long)(int)longValueExact, longValueExact);
            BytecodeManager.incBytecodes(6);
            if (n != 0) {
                final String s = "Overflow";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = (int)longValueExact;
            BytecodeManager.incBytecodes(3);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public short shortValueExact() {
        try {
            BytecodeManager.incBytecodes(2);
            final long longValueExact = this.longValueExact();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp((long)(short)longValueExact, longValueExact);
            BytecodeManager.incBytecodes(7);
            if (n != 0) {
                final String s = "Overflow";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final short n2 = (short)longValueExact;
            BytecodeManager.incBytecodes(4);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public byte byteValueExact() {
        try {
            BytecodeManager.incBytecodes(2);
            final long longValueExact = this.longValueExact();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp((long)(byte)longValueExact, longValueExact);
            BytecodeManager.incBytecodes(7);
            if (n != 0) {
                final String s = "Overflow";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final byte b = (byte)longValueExact;
            BytecodeManager.incBytecodes(4);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public float floatValue() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                final int scale = this.scale;
                BytecodeManager.incBytecodes(3);
                if (scale == 0) {
                    final float n2 = (float)this.intCompact;
                    BytecodeManager.incBytecodes(4);
                    return n2;
                }
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(3);
                final long n3 = lcmp(Math.abs(intCompact), 4194304L);
                BytecodeManager.incBytecodes(3);
                if (n3 < 0) {
                    final int scale2 = this.scale;
                    BytecodeManager.incBytecodes(3);
                    if (scale2 > 0) {
                        final int scale3 = this.scale;
                        final int length = BigDecimal.float10pow.length;
                        BytecodeManager.incBytecodes(5);
                        if (scale3 < length) {
                            final float n4 = this.intCompact / BigDecimal.float10pow[this.scale];
                            BytecodeManager.incBytecodes(9);
                            return n4;
                        }
                    }
                    final int scale4 = this.scale;
                    BytecodeManager.incBytecodes(3);
                    if (scale4 < 0) {
                        final int scale5 = this.scale;
                        final int n5 = -BigDecimal.float10pow.length;
                        BytecodeManager.incBytecodes(6);
                        if (scale5 > n5) {
                            final float n6 = this.intCompact * BigDecimal.float10pow[-this.scale];
                            BytecodeManager.incBytecodes(10);
                            return n6;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            final String string = this.toString();
            BytecodeManager.incBytecodes(1);
            final float float1 = Float.parseFloat(string);
            BytecodeManager.incBytecodes(1);
            return float1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public double doubleValue() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n != 0) {
                final int scale = this.scale;
                BytecodeManager.incBytecodes(3);
                if (scale == 0) {
                    final double n2 = (double)this.intCompact;
                    BytecodeManager.incBytecodes(4);
                    return n2;
                }
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(3);
                final long n3 = lcmp(Math.abs(intCompact), 4503599627370496L);
                BytecodeManager.incBytecodes(3);
                if (n3 < 0) {
                    final int scale2 = this.scale;
                    BytecodeManager.incBytecodes(3);
                    if (scale2 > 0) {
                        final int scale3 = this.scale;
                        final int length = BigDecimal.double10pow.length;
                        BytecodeManager.incBytecodes(5);
                        if (scale3 < length) {
                            final double n4 = this.intCompact / BigDecimal.double10pow[this.scale];
                            BytecodeManager.incBytecodes(9);
                            return n4;
                        }
                    }
                    final int scale4 = this.scale;
                    BytecodeManager.incBytecodes(3);
                    if (scale4 < 0) {
                        final int scale5 = this.scale;
                        final int n5 = -BigDecimal.double10pow.length;
                        BytecodeManager.incBytecodes(6);
                        if (scale5 > n5) {
                            final double n6 = this.intCompact * BigDecimal.double10pow[-this.scale];
                            BytecodeManager.incBytecodes(10);
                            return n6;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            final String string = this.toString();
            BytecodeManager.incBytecodes(1);
            final double double1 = Double.parseDouble(string);
            BytecodeManager.incBytecodes(1);
            return double1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BigDecimal ulp() {
        try {
            final long n = 1L;
            BytecodeManager.incBytecodes(3);
            final int scale = this.scale();
            final int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final BigDecimal value = valueOf(n, scale, n2);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String layoutChars(final boolean b) {
        try {
            final int scale = this.scale;
            BytecodeManager.incBytecodes(3);
            if (scale == 0) {
                final long n = lcmp(this.intCompact, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                String s;
                if (n != 0) {
                    final long intCompact = this.intCompact;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    s = Long.toString(intCompact);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final BigInteger intVal = this.intVal;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    s = intVal.toString();
                }
                BytecodeManager.incBytecodes(1);
                return s;
            }
            final int scale2 = this.scale;
            final int n2 = 2;
            BytecodeManager.incBytecodes(4);
            if (scale2 == n2) {
                final long n3 = lcmp(this.intCompact, 0L);
                BytecodeManager.incBytecodes(5);
                if (n3 >= 0) {
                    final long n4 = lcmp(this.intCompact, 2147483647L);
                    BytecodeManager.incBytecodes(5);
                    if (n4 < 0) {
                        final int n5 = (int)this.intCompact % 100;
                        BytecodeManager.incBytecodes(6);
                        final int n6 = (int)this.intCompact / 100;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder sb = new StringBuilder();
                        final int i = n6;
                        BytecodeManager.incBytecodes(2);
                        final String string = Integer.toString(i);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder append = sb.append(string);
                        final char c = '.';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(c);
                        final char c2 = StringBuilderHelper.DIGIT_TENS[n5];
                        BytecodeManager.incBytecodes(4);
                        final StringBuilder append3 = append2.append(c2);
                        final char c3 = StringBuilderHelper.DIGIT_ONES[n5];
                        BytecodeManager.incBytecodes(4);
                        final StringBuilder append4 = append3.append(c3);
                        BytecodeManager.incBytecodes(1);
                        final String string2 = append4.toString();
                        BytecodeManager.incBytecodes(1);
                        return string2;
                    }
                }
            }
            final ThreadLocal<StringBuilderHelper> threadLocalStringBuilderHelper = BigDecimal.threadLocalStringBuilderHelper;
            BytecodeManager.incBytecodes(2);
            final StringBuilderHelper stringBuilderHelper = threadLocalStringBuilderHelper.get();
            BytecodeManager.incBytecodes(2);
            final long n7 = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            int putIntCompact;
            char[] array;
            if (n7 != 0) {
                final StringBuilderHelper stringBuilderHelper2 = stringBuilderHelper;
                final long intCompact2 = this.intCompact;
                BytecodeManager.incBytecodes(4);
                final long abs = Math.abs(intCompact2);
                BytecodeManager.incBytecodes(1);
                putIntCompact = stringBuilderHelper2.putIntCompact(abs);
                BytecodeManager.incBytecodes(1);
                final StringBuilderHelper stringBuilderHelper3 = stringBuilderHelper;
                BytecodeManager.incBytecodes(2);
                array = stringBuilderHelper3.getCompactCharArray();
                BytecodeManager.incBytecodes(2);
            }
            else {
                putIntCompact = 0;
                BytecodeManager.incBytecodes(2);
                final BigInteger intVal2 = this.intVal;
                BytecodeManager.incBytecodes(3);
                final BigInteger abs2 = intVal2.abs();
                BytecodeManager.incBytecodes(1);
                final String string3 = abs2.toString();
                BytecodeManager.incBytecodes(1);
                array = string3.toCharArray();
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilderHelper stringBuilderHelper4 = stringBuilderHelper;
            BytecodeManager.incBytecodes(2);
            final StringBuilder stringBuilder = stringBuilderHelper4.getStringBuilder();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int signum = this.signum();
            BytecodeManager.incBytecodes(1);
            if (signum < 0) {
                final StringBuilder sb2 = stringBuilder;
                final char c4 = '-';
                BytecodeManager.incBytecodes(3);
                sb2.append(c4);
                BytecodeManager.incBytecodes(1);
            }
            final int n8 = array.length - putIntCompact;
            BytecodeManager.incBytecodes(5);
            long n9 = -this.scale + (long)(n8 - 1);
            BytecodeManager.incBytecodes(10);
            final int scale3 = this.scale;
            BytecodeManager.incBytecodes(3);
            Label_1250: {
                if (scale3 >= 0) {
                    final long n10 = lcmp(n9, -6L);
                    BytecodeManager.incBytecodes(4);
                    if (n10 >= 0) {
                        int n11 = this.scale - n8;
                        BytecodeManager.incBytecodes(5);
                        final int n12 = n11;
                        BytecodeManager.incBytecodes(2);
                        if (n12 >= 0) {
                            final StringBuilder sb3 = stringBuilder;
                            final char c5 = '0';
                            BytecodeManager.incBytecodes(3);
                            sb3.append(c5);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb4 = stringBuilder;
                            final char c6 = '.';
                            BytecodeManager.incBytecodes(3);
                            sb4.append(c6);
                            BytecodeManager.incBytecodes(1);
                            while (true) {
                                final int n13 = n11;
                                BytecodeManager.incBytecodes(2);
                                if (n13 <= 0) {
                                    break;
                                }
                                final StringBuilder sb5 = stringBuilder;
                                final char c7 = '0';
                                BytecodeManager.incBytecodes(3);
                                sb5.append(c7);
                                BytecodeManager.incBytecodes(1);
                                --n11;
                                BytecodeManager.incBytecodes(2);
                            }
                            final StringBuilder sb6 = stringBuilder;
                            final char[] str = array;
                            final int offset = putIntCompact;
                            final int len = n8;
                            BytecodeManager.incBytecodes(5);
                            sb6.append(str, offset, len);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final StringBuilder sb7 = stringBuilder;
                            final char[] str2 = array;
                            final int offset2 = putIntCompact;
                            final int len2 = -n11;
                            BytecodeManager.incBytecodes(6);
                            sb7.append(str2, offset2, len2);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb8 = stringBuilder;
                            final char c8 = '.';
                            BytecodeManager.incBytecodes(3);
                            sb8.append(c8);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb9 = stringBuilder;
                            final char[] str3 = array;
                            final int offset3 = -n11 + putIntCompact;
                            final int scale4 = this.scale;
                            BytecodeManager.incBytecodes(9);
                            sb9.append(str3, offset3, scale4);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        break Label_1250;
                    }
                }
                BytecodeManager.incBytecodes(2);
                if (b) {
                    final StringBuilder sb10 = stringBuilder;
                    final char c9 = array[putIntCompact];
                    BytecodeManager.incBytecodes(5);
                    sb10.append(c9);
                    BytecodeManager.incBytecodes(1);
                    final int n14 = n8;
                    final int n15 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n14 > n15) {
                        final StringBuilder sb11 = stringBuilder;
                        final char c10 = '.';
                        BytecodeManager.incBytecodes(3);
                        sb11.append(c10);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb12 = stringBuilder;
                        final char[] str4 = array;
                        final int offset4 = putIntCompact + 1;
                        final int len3 = n8 - 1;
                        BytecodeManager.incBytecodes(9);
                        sb12.append(str4, offset4, len3);
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    int n16 = (int)(n9 % 3L);
                    BytecodeManager.incBytecodes(5);
                    final int n17 = n16;
                    BytecodeManager.incBytecodes(2);
                    if (n17 < 0) {
                        n16 += 3;
                        BytecodeManager.incBytecodes(1);
                    }
                    n9 -= n16;
                    BytecodeManager.incBytecodes(5);
                    ++n16;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    final int signum2 = this.signum();
                    BytecodeManager.incBytecodes(1);
                    if (signum2 == 0) {
                        final int n18 = n16;
                        BytecodeManager.incBytecodes(2);
                        switch (n18) {
                            case 1: {
                                final StringBuilder sb13 = stringBuilder;
                                final char c11 = '0';
                                BytecodeManager.incBytecodes(3);
                                sb13.append(c11);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            case 2: {
                                final StringBuilder sb14 = stringBuilder;
                                final String str5 = "0.00";
                                BytecodeManager.incBytecodes(3);
                                sb14.append(str5);
                                BytecodeManager.incBytecodes(1);
                                n9 += 3L;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            case 3: {
                                final StringBuilder sb15 = stringBuilder;
                                final String str6 = "0.0";
                                BytecodeManager.incBytecodes(3);
                                sb15.append(str6);
                                BytecodeManager.incBytecodes(1);
                                n9 += 3L;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            default: {
                                BytecodeManager.incBytecodes(5);
                                final StringBuilder sb16 = new StringBuilder();
                                final String str7 = "Unexpected sig value ";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append5 = sb16.append(str7);
                                final int j = n16;
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append6 = append5.append(j);
                                BytecodeManager.incBytecodes(1);
                                final String string4 = append6.toString();
                                BytecodeManager.incBytecodes(1);
                                final AssertionError assertionError = new AssertionError((Object)string4);
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                    }
                    else {
                        final int n19 = n16;
                        final int n20 = n8;
                        BytecodeManager.incBytecodes(3);
                        if (n19 >= n20) {
                            final StringBuilder sb17 = stringBuilder;
                            final char[] str8 = array;
                            final int offset5 = putIntCompact;
                            final int len4 = n8;
                            BytecodeManager.incBytecodes(5);
                            sb17.append(str8, offset5, len4);
                            BytecodeManager.incBytecodes(1);
                            int n21 = n16 - n8;
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final int n22 = n21;
                                BytecodeManager.incBytecodes(2);
                                if (n22 <= 0) {
                                    break;
                                }
                                final StringBuilder sb18 = stringBuilder;
                                final char c12 = '0';
                                BytecodeManager.incBytecodes(3);
                                sb18.append(c12);
                                BytecodeManager.incBytecodes(1);
                                --n21;
                                BytecodeManager.incBytecodes(2);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final StringBuilder sb19 = stringBuilder;
                            final char[] str9 = array;
                            final int offset6 = putIntCompact;
                            final int len5 = n16;
                            BytecodeManager.incBytecodes(5);
                            sb19.append(str9, offset6, len5);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb20 = stringBuilder;
                            final char c13 = '.';
                            BytecodeManager.incBytecodes(3);
                            sb20.append(c13);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb21 = stringBuilder;
                            final char[] str10 = array;
                            final int offset7 = putIntCompact + n16;
                            final int len6 = n8 - n16;
                            BytecodeManager.incBytecodes(9);
                            sb21.append(str10, offset7, len6);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final long n23 = lcmp(n9, 0L);
                BytecodeManager.incBytecodes(4);
                if (n23 != 0) {
                    final StringBuilder sb22 = stringBuilder;
                    final char c14 = 'E';
                    BytecodeManager.incBytecodes(3);
                    sb22.append(c14);
                    BytecodeManager.incBytecodes(1);
                    final long n24 = lcmp(n9, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n24 > 0) {
                        final StringBuilder sb23 = stringBuilder;
                        final char c15 = '+';
                        BytecodeManager.incBytecodes(3);
                        sb23.append(c15);
                        BytecodeManager.incBytecodes(1);
                    }
                    final StringBuilder sb24 = stringBuilder;
                    final long lng = n9;
                    BytecodeManager.incBytecodes(3);
                    sb24.append(lng);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final StringBuilder sb25 = stringBuilder;
            BytecodeManager.incBytecodes(2);
            final String string5 = sb25.toString();
            BytecodeManager.incBytecodes(1);
            return string5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger bigTenToThe(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final BigInteger zero = BigInteger.ZERO;
                BytecodeManager.incBytecodes(2);
                return zero;
            }
            final int big_TEN_POWERS_TABLE_MAX = BigDecimal.BIG_TEN_POWERS_TABLE_MAX;
            BytecodeManager.incBytecodes(3);
            if (n >= big_TEN_POWERS_TABLE_MAX) {
                final BigInteger ten = BigInteger.TEN;
                BytecodeManager.incBytecodes(3);
                final BigInteger pow = ten.pow(n);
                BytecodeManager.incBytecodes(1);
                return pow;
            }
            final BigInteger[] big_TEN_POWERS_TABLE = BigDecimal.BIG_TEN_POWERS_TABLE;
            BytecodeManager.incBytecodes(2);
            final int length = big_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(4);
            if (n < length) {
                final BigInteger bigInteger = big_TEN_POWERS_TABLE[n];
                BytecodeManager.incBytecodes(4);
                return bigInteger;
            }
            BytecodeManager.incBytecodes(2);
            final BigInteger expandBigIntegerTenPowers = expandBigIntegerTenPowers(n);
            BytecodeManager.incBytecodes(1);
            return expandBigIntegerTenPowers;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger expandBigIntegerTenPowers(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: dup            
        //     3: astore_1       
        //     4: pop            
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: getstatic       instrumented/java/math/BigDecimal.BIG_TEN_POWERS_TABLE:[Linstrumented/java/math/BigInteger;
        //    13: astore_2       
        //    14: ldc             2
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: aload_2        
        //    20: arraylength    
        //    21: istore_3       
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: iload_3        
        //    28: iload_0        
        //    29: ldc             3
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: if_icmpgt       159
        //    37: iload_3        
        //    38: iconst_1       
        //    39: ishl           
        //    40: istore          4
        //    42: ldc             4
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: iload           4
        //    49: iload_0        
        //    50: ldc             3
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: if_icmpgt       72
        //    58: iload           4
        //    60: iconst_1       
        //    61: ishl           
        //    62: istore          4
        //    64: ldc             5
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: goto            47
        //    72: aload_2        
        //    73: iload           4
        //    75: ldc             3
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //    83: checkcast       [Linstrumented/java/math/BigInteger;
        //    86: astore_2       
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: iload_3        
        //    93: istore          5
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: iload           5
        //   102: iload           4
        //   104: ldc             3
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: if_icmpge       150
        //   112: aload_2        
        //   113: iload           5
        //   115: aload_2        
        //   116: iload           5
        //   118: iconst_1       
        //   119: isub           
        //   120: aaload         
        //   121: getstatic       instrumented/java/math/BigInteger.TEN:Linstrumented/java/math/BigInteger;
        //   124: ldc_w           9
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: invokevirtual   instrumented/java/math/BigInteger.multiply:(Linstrumented/java/math/BigInteger;)Linstrumented/java/math/BigInteger;
        //   133: aastore        
        //   134: ldc             1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: iinc            5, 1
        //   142: ldc             2
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: goto            100
        //   150: aload_2        
        //   151: putstatic       instrumented/java/math/BigDecimal.BIG_TEN_POWERS_TABLE:[Linstrumented/java/math/BigInteger;
        //   154: ldc             2
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: aload_2        
        //   160: iload_0        
        //   161: aaload         
        //   162: aload_1        
        //   163: pop            
        //   164: ldc             5
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: ldc             1
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: areturn        
        //   175: astore          6
        //   177: aload_1        
        //   178: pop            
        //   179: ldc_w           503
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: aload           6
        //   187: ldc             2
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: athrow         
        //   193: athrow         
        //   194: athrow         
        //    StackMapTable: 00 08 FF 00 2F 00 05 01 07 02 E1 07 02 DA 01 01 00 00 18 FC 00 1B 01 FA 00 31 FA 00 08 FF 00 0F 00 02 01 07 02 E1 00 01 07 00 6C FF 00 11 00 00 00 01 07 00 6C FF 00 00 00 00 00 01 07 00 78
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  10     194    194    195    Ljava/lang/VirtualMachineError;
        //  10     169    175    193    Any
        //  175    185    175    193    Any
        //  0      193    193    194    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0047:
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
    
    private static long longMultiplyPowerTen(final long a, final int n) {
        try {
            final long n2 = lcmp(a, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 != 0) {
                BytecodeManager.incBytecodes(2);
                if (n > 0) {
                    final long[] long_TEN_POWERS_TABLE = BigDecimal.LONG_TEN_POWERS_TABLE;
                    BytecodeManager.incBytecodes(2);
                    final long[] thresholds_TABLE = BigDecimal.THRESHOLDS_TABLE;
                    BytecodeManager.incBytecodes(2);
                    final int length = long_TEN_POWERS_TABLE.length;
                    BytecodeManager.incBytecodes(4);
                    if (n < length) {
                        final int length2 = thresholds_TABLE.length;
                        BytecodeManager.incBytecodes(4);
                        if (n < length2) {
                            final long n3 = long_TEN_POWERS_TABLE[n];
                            BytecodeManager.incBytecodes(4);
                            final long n4 = lcmp(a, 1L);
                            BytecodeManager.incBytecodes(4);
                            if (n4 == 0) {
                                final long n5 = n3;
                                BytecodeManager.incBytecodes(2);
                                return n5;
                            }
                            BytecodeManager.incBytecodes(2);
                            final long n6 = lcmp(Math.abs(a), thresholds_TABLE[n]);
                            BytecodeManager.incBytecodes(5);
                            if (n6 <= 0) {
                                final long n7 = a * n3;
                                BytecodeManager.incBytecodes(4);
                                return n7;
                            }
                        }
                    }
                    final long n8 = Long.MIN_VALUE;
                    BytecodeManager.incBytecodes(2);
                    return n8;
                }
            }
            BytecodeManager.incBytecodes(2);
            return a;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger bigMultiplyPowerTen(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger inflated = this.inflated();
                BytecodeManager.incBytecodes(1);
                return inflated;
            }
            final long n2 = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n2 != 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger bigTenToThe = bigTenToThe(n);
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(3);
                final BigInteger multiply = bigTenToThe.multiply(intCompact);
                BytecodeManager.incBytecodes(1);
                return multiply;
            }
            final BigInteger intVal = this.intVal;
            BytecodeManager.incBytecodes(4);
            final BigInteger bigTenToThe2 = bigTenToThe(n);
            BytecodeManager.incBytecodes(1);
            final BigInteger multiply2 = intVal.multiply(bigTenToThe2);
            BytecodeManager.incBytecodes(1);
            return multiply2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigInteger inflated() {
        try {
            final BigInteger intVal = this.intVal;
            BytecodeManager.incBytecodes(3);
            if (intVal == null) {
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(3);
                final BigInteger value = BigInteger.valueOf(intCompact);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            final BigInteger intVal2 = this.intVal;
            BytecodeManager.incBytecodes(3);
            return intVal2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void matchScale(final BigDecimal[] array) {
        try {
            final int scale = array[0].scale;
            final int scale2 = array[1].scale;
            BytecodeManager.incBytecodes(9);
            if (scale == scale2) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int scale3 = array[0].scale;
            final int scale4 = array[1].scale;
            BytecodeManager.incBytecodes(9);
            if (scale3 < scale4) {
                final int n = 0;
                final BigDecimal bigDecimal = array[0];
                final int scale5 = array[1].scale;
                final int n2 = 7;
                BytecodeManager.incBytecodes(11);
                array[n] = bigDecimal.setScale(scale5, n2);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int scale6 = array[1].scale;
                final int scale7 = array[0].scale;
                BytecodeManager.incBytecodes(9);
                if (scale6 < scale7) {
                    final int n3 = 1;
                    final BigDecimal bigDecimal2 = array[1];
                    final int scale8 = array[0].scale;
                    final int n4 = 7;
                    BytecodeManager.incBytecodes(11);
                    array[n3] = bigDecimal2.setScale(scale8, n4);
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            final BigInteger intVal = this.intVal;
            BytecodeManager.incBytecodes(3);
            if (intVal == null) {
                final String s = "BigDecimal: null intVal in stream";
                BytecodeManager.incBytecodes(2);
                final String reason = s;
                BytecodeManager.incBytecodes(4);
                final StreamCorruptedException ex = new StreamCorruptedException(reason);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BigInteger intVal2 = this.intVal;
            BytecodeManager.incBytecodes(4);
            final long compactVal = compactValFor(intVal2);
            BytecodeManager.incBytecodes(1);
            UnsafeHolder.setIntCompactVolatile(this, compactVal);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            final BigInteger intVal = this.intVal;
            BytecodeManager.incBytecodes(3);
            if (intVal == null) {
                final long intCompact = this.intCompact;
                BytecodeManager.incBytecodes(4);
                final BigInteger value = BigInteger.valueOf(intCompact);
                BytecodeManager.incBytecodes(1);
                UnsafeHolder.setIntValVolatile(this, value);
            }
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int longDigitLength(long n) {
        try {
            final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final long n2 = lcmp(n, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n2 == 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 < 0) {
                n = -n;
                BytecodeManager.incBytecodes(3);
            }
            final long n4 = lcmp(n, 10L);
            BytecodeManager.incBytecodes(4);
            if (n4 < 0) {
                final int n5 = 1;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            final int n6 = 64;
            final long i = n;
            BytecodeManager.incBytecodes(3);
            final int n7 = (n6 - Long.numberOfLeadingZeros(i) + 1) * 1233 >>> 12;
            BytecodeManager.incBytecodes(8);
            final long[] long_TEN_POWERS_TABLE = BigDecimal.LONG_TEN_POWERS_TABLE;
            BytecodeManager.incBytecodes(2);
            final int n8 = n7;
            final int length = long_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(4);
            int n10 = 0;
            Label_0158: {
                if (n8 < length) {
                    final long n9 = lcmp(n, long_TEN_POWERS_TABLE[n7]);
                    BytecodeManager.incBytecodes(6);
                    if (n9 >= 0) {
                        n10 = n7 + 1;
                        BytecodeManager.incBytecodes(3);
                        break Label_0158;
                    }
                }
                n10 = n7;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return n10;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int bigDigitLength(final BigInteger bigInteger) {
        try {
            final int signum = bigInteger.signum;
            BytecodeManager.incBytecodes(3);
            if (signum == 0) {
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            BytecodeManager.incBytecodes(2);
            final int n2 = (int)((bigInteger.bitLength() + 1L) * 646456993L >>> 31);
            BytecodeManager.incBytecodes(9);
            final int n3 = n2;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigTenToThe = bigTenToThe(n3);
            BytecodeManager.incBytecodes(1);
            final int compareMagnitude = bigInteger.compareMagnitude(bigTenToThe);
            BytecodeManager.incBytecodes(1);
            int n4;
            if (compareMagnitude < 0) {
                n4 = n2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n4 = n2 + 1;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int checkScale(final long n) {
        try {
            int n2 = (int)n;
            BytecodeManager.incBytecodes(3);
            final long n3 = lcmp((long)n2, n);
            BytecodeManager.incBytecodes(5);
            Label_0156: {
                if (n3 != 0) {
                    final long n4 = lcmp(n, 2147483647L);
                    BytecodeManager.incBytecodes(4);
                    int n5;
                    if (n4 > 0) {
                        n5 = Integer.MAX_VALUE;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n5 = Integer.MIN_VALUE;
                        BytecodeManager.incBytecodes(1);
                    }
                    n2 = n5;
                    BytecodeManager.incBytecodes(1);
                    final long n6 = lcmp(this.intCompact, 0L);
                    BytecodeManager.incBytecodes(5);
                    if (n6 != 0) {
                        final BigInteger intVal = this.intVal;
                        BytecodeManager.incBytecodes(5);
                        if (intVal != null) {
                            final BigInteger bigInteger = intVal;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final int signum = bigInteger.signum();
                            BytecodeManager.incBytecodes(1);
                            if (signum == 0) {
                                break Label_0156;
                            }
                        }
                        final int n7 = n2;
                        BytecodeManager.incBytecodes(4);
                        String s;
                        if (n7 > 0) {
                            s = "Underflow";
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            s = "Overflow";
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArithmeticException ex = new ArithmeticException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
            }
            final int n8 = n2;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long compactValFor(final BigInteger bigInteger) {
        try {
            final int[] mag = bigInteger.mag;
            BytecodeManager.incBytecodes(3);
            final int length = mag.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                final long n2 = 0L;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final int n3 = mag[0];
            BytecodeManager.incBytecodes(4);
            final int n4 = length;
            final int n5 = 2;
            BytecodeManager.incBytecodes(3);
            Label_0072: {
                if (n4 <= n5) {
                    final int n6 = length;
                    final int n7 = 2;
                    BytecodeManager.incBytecodes(3);
                    if (n6 == n7) {
                        final int n8 = n3;
                        BytecodeManager.incBytecodes(2);
                        if (n8 < 0) {
                            break Label_0072;
                        }
                    }
                    final int n9 = length;
                    final int n10 = 2;
                    BytecodeManager.incBytecodes(3);
                    long n11;
                    if (n9 == n10) {
                        n11 = ((long)mag[1] & 0xFFFFFFFFL) + ((long)n3 << 32);
                        BytecodeManager.incBytecodes(12);
                    }
                    else {
                        n11 = ((long)n3 & 0xFFFFFFFFL);
                        BytecodeManager.incBytecodes(4);
                    }
                    final long n12 = n11;
                    BytecodeManager.incBytecodes(1);
                    final int signum = bigInteger.signum;
                    BytecodeManager.incBytecodes(3);
                    long n13;
                    if (signum < 0) {
                        n13 = -n12;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        n13 = n12;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n13;
                }
            }
            final long n14 = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(2);
            return n14;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int longCompareMagnitude(long n, long n2) {
        try {
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 < 0) {
                n = -n;
                BytecodeManager.incBytecodes(3);
            }
            final long n4 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            if (n4 < 0) {
                n2 = -n2;
                BytecodeManager.incBytecodes(3);
            }
            final long n5 = lcmp(n, n2);
            BytecodeManager.incBytecodes(4);
            int n6;
            if (n5 < 0) {
                n6 = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final long n7 = lcmp(n, n2);
                BytecodeManager.incBytecodes(4);
                if (n7 == 0) {
                    n6 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n6 = 1;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int saturateLong(final long n) {
        try {
            final int n2 = (int)n;
            BytecodeManager.incBytecodes(3);
            final long n3 = lcmp(n, (long)n2);
            BytecodeManager.incBytecodes(5);
            int n4;
            if (n3 == 0) {
                n4 = n2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final long n5 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(4);
                if (n5 < 0) {
                    n4 = Integer.MIN_VALUE;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n4 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void print(final String s, final BigDecimal bigDecimal) {
        try {
            final PrintStream err = System.err;
            final String format = "%s:\tintCompact %d\tintVal %d\tscale %d\tprecision %d%n";
            final Object[] args = new Object[5];
            args[0] = s;
            final int n = 1;
            final long intCompact = bigDecimal.intCompact;
            BytecodeManager.incBytecodes(11);
            BytecodeManager.incBytecodes(1);
            args[n] = intCompact;
            args[2] = bigDecimal.intVal;
            final int n2 = 3;
            final int scale = bigDecimal.scale;
            BytecodeManager.incBytecodes(10);
            BytecodeManager.incBytecodes(1);
            args[n2] = scale;
            final int n3 = 4;
            final int precision = bigDecimal.precision;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            args[n3] = precision;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            err.format(format, args);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private BigDecimal audit() {
        try {
            final long n = lcmp(this.intCompact, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(5);
            if (n == 0) {
                final BigInteger intVal = this.intVal;
                BytecodeManager.incBytecodes(3);
                if (intVal == null) {
                    final String s = "audit";
                    BytecodeManager.incBytecodes(3);
                    print(s, this);
                    final String detailMessage = "null intVal";
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
                final int precision = this.precision;
                BytecodeManager.incBytecodes(3);
                if (precision > 0) {
                    final int precision2 = this.precision;
                    final BigInteger intVal2 = this.intVal;
                    BytecodeManager.incBytecodes(5);
                    final int bigDigitLength = bigDigitLength(intVal2);
                    BytecodeManager.incBytecodes(1);
                    if (precision2 != bigDigitLength) {
                        final String s2 = "audit";
                        BytecodeManager.incBytecodes(3);
                        print(s2, this);
                        final String detailMessage2 = "precision mismatch";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError2 = new AssertionError((Object)detailMessage2);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError2;
                    }
                }
            }
            else {
                final BigInteger intVal3 = this.intVal;
                BytecodeManager.incBytecodes(3);
                if (intVal3 != null) {
                    final BigInteger intVal4 = this.intVal;
                    BytecodeManager.incBytecodes(3);
                    final long longValue = intVal4.longValue();
                    BytecodeManager.incBytecodes(1);
                    final long n2 = lcmp(longValue, this.intCompact);
                    BytecodeManager.incBytecodes(5);
                    if (n2 != 0) {
                        final String s3 = "audit";
                        BytecodeManager.incBytecodes(3);
                        print(s3, this);
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "Inconsistent state, intCompact=";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final long intCompact = this.intCompact;
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder append2 = append.append(intCompact);
                        final String str2 = "\t intVal=";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = append2.append(str2);
                        final long lng = longValue;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append4 = append3.append(lng);
                        BytecodeManager.incBytecodes(1);
                        final String string = append4.toString();
                        BytecodeManager.incBytecodes(1);
                        final AssertionError assertionError3 = new AssertionError((Object)string);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError3;
                    }
                }
                final int precision3 = this.precision;
                BytecodeManager.incBytecodes(3);
                if (precision3 > 0) {
                    final int precision4 = this.precision;
                    final long intCompact2 = this.intCompact;
                    BytecodeManager.incBytecodes(5);
                    final int longDigitLength = longDigitLength(intCompact2);
                    BytecodeManager.incBytecodes(1);
                    if (precision4 != longDigitLength) {
                        final String s4 = "audit";
                        BytecodeManager.incBytecodes(3);
                        print(s4, this);
                        final String detailMessage3 = "precision mismatch";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError4 = new AssertionError((Object)detailMessage3);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError4;
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int checkScaleNonZero(final long n) {
        try {
            final int n2 = (int)n;
            BytecodeManager.incBytecodes(3);
            final long n3 = lcmp((long)n2, n);
            BytecodeManager.incBytecodes(5);
            if (n3 != 0) {
                final int n4 = n2;
                BytecodeManager.incBytecodes(4);
                String s;
                if (n4 > 0) {
                    s = "Underflow";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    s = "Overflow";
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n5 = n2;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int checkScale(final long n, final long n2) {
        try {
            int n3 = (int)n2;
            BytecodeManager.incBytecodes(3);
            final long n4 = lcmp((long)n3, n2);
            BytecodeManager.incBytecodes(5);
            if (n4 != 0) {
                final long n5 = lcmp(n2, 2147483647L);
                BytecodeManager.incBytecodes(4);
                int n6;
                if (n5 > 0) {
                    n6 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n6 = Integer.MIN_VALUE;
                    BytecodeManager.incBytecodes(1);
                }
                n3 = n6;
                BytecodeManager.incBytecodes(1);
                final long n7 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(4);
                if (n7 != 0) {
                    final int n8 = n3;
                    BytecodeManager.incBytecodes(4);
                    String s;
                    if (n8 > 0) {
                        s = "Underflow";
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        s = "Overflow";
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final ArithmeticException ex = new ArithmeticException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            final int n9 = n3;
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int checkScale(final BigInteger bigInteger, final long n) {
        try {
            int n2 = (int)n;
            BytecodeManager.incBytecodes(3);
            final long n3 = lcmp((long)n2, n);
            BytecodeManager.incBytecodes(5);
            if (n3 != 0) {
                final long n4 = lcmp(n, 2147483647L);
                BytecodeManager.incBytecodes(4);
                int n5;
                if (n4 > 0) {
                    n5 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n5 = Integer.MIN_VALUE;
                    BytecodeManager.incBytecodes(1);
                }
                n2 = n5;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final int signum = bigInteger.signum();
                BytecodeManager.incBytecodes(1);
                if (signum != 0) {
                    final int n6 = n2;
                    BytecodeManager.incBytecodes(4);
                    String s;
                    if (n6 > 0) {
                        s = "Underflow";
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        s = "Overflow";
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final ArithmeticException ex = new ArithmeticException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
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
    
    private static BigDecimal doRound(final BigDecimal bigDecimal, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final int n2 = precision;
            BytecodeManager.incBytecodes(2);
            if (n2 > 0) {
                BigInteger bigInteger = bigDecimal.intVal;
                BytecodeManager.incBytecodes(3);
                long n3 = bigDecimal.intCompact;
                BytecodeManager.incBytecodes(3);
                int n4 = bigDecimal.scale;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                int n5 = bigDecimal.precision();
                BytecodeManager.incBytecodes(1);
                final int oldMode = mathContext.roundingMode.oldMode;
                BytecodeManager.incBytecodes(4);
                final long n6 = lcmp(n3, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n6 == 0) {
                    int n7 = n5 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n8 = n7;
                        BytecodeManager.incBytecodes(2);
                        if (n8 <= 0) {
                            break;
                        }
                        final long n9 = n4 - (long)n7;
                        BytecodeManager.incBytecodes(6);
                        n4 = checkScaleNonZero(n9);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger2 = bigInteger;
                        final int n10 = n7;
                        final int n11 = oldMode;
                        BytecodeManager.incBytecodes(4);
                        bigInteger = divideAndRoundByTenPow(bigInteger2, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        n = 1;
                        BytecodeManager.incBytecodes(2);
                        final BigInteger bigInteger3 = bigInteger;
                        BytecodeManager.incBytecodes(2);
                        n3 = compactValFor(bigInteger3);
                        BytecodeManager.incBytecodes(1);
                        final long n12 = lcmp(n3, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(4);
                        if (n12 != 0) {
                            final long n13 = n3;
                            BytecodeManager.incBytecodes(2);
                            n5 = longDigitLength(n13);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final BigInteger bigInteger4 = bigInteger;
                        BytecodeManager.incBytecodes(2);
                        n5 = bigDigitLength(bigInteger4);
                        BytecodeManager.incBytecodes(1);
                        n7 = n5 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final long n14 = lcmp(n3, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n14 != 0) {
                    int n15 = n5 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n16 = n15;
                        BytecodeManager.incBytecodes(2);
                        if (n16 <= 0) {
                            break;
                        }
                        final long n17 = n4 - (long)n15;
                        BytecodeManager.incBytecodes(6);
                        n4 = checkScaleNonZero(n17);
                        BytecodeManager.incBytecodes(1);
                        final long n18 = n3;
                        final long n19 = BigDecimal.LONG_TEN_POWERS_TABLE[n15];
                        final int oldMode2 = mathContext.roundingMode.oldMode;
                        BytecodeManager.incBytecodes(8);
                        n3 = divideAndRound(n18, n19, oldMode2);
                        BytecodeManager.incBytecodes(1);
                        n = 1;
                        BytecodeManager.incBytecodes(2);
                        final long n20 = n3;
                        BytecodeManager.incBytecodes(2);
                        n5 = longDigitLength(n20);
                        BytecodeManager.incBytecodes(1);
                        n15 = n5 - precision;
                        BytecodeManager.incBytecodes(4);
                        bigInteger = null;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final int n21 = n;
                BytecodeManager.incBytecodes(2);
                BigDecimal bigDecimal2;
                if (n21 != 0) {
                    final BigInteger bigInteger5;
                    final long n22;
                    final int n23;
                    final int n24;
                    bigDecimal2 = new BigDecimal(bigInteger5, n22, n23, n24);
                    bigInteger5 = bigInteger;
                    n22 = n3;
                    n23 = n4;
                    n24 = n5;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    bigDecimal2 = bigDecimal;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return bigDecimal2;
            }
            BytecodeManager.incBytecodes(2);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal doRound(long divideAndRound, int checkScaleNonZero, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int n = precision;
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                final int n2 = precision;
                final int n3 = 19;
                BytecodeManager.incBytecodes(3);
                if (n2 < n3) {
                    final long n4 = divideAndRound;
                    BytecodeManager.incBytecodes(2);
                    int n5 = longDigitLength(n4);
                    BytecodeManager.incBytecodes(1);
                    int n6 = n5 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n7 = n6;
                        BytecodeManager.incBytecodes(2);
                        if (n7 <= 0) {
                            break;
                        }
                        final long n8 = checkScaleNonZero - (long)n6;
                        BytecodeManager.incBytecodes(6);
                        checkScaleNonZero = checkScaleNonZero(n8);
                        BytecodeManager.incBytecodes(1);
                        final long n9 = divideAndRound;
                        final long n10 = BigDecimal.LONG_TEN_POWERS_TABLE[n6];
                        final int oldMode = mathContext.roundingMode.oldMode;
                        BytecodeManager.incBytecodes(8);
                        divideAndRound = divideAndRound(n9, n10, oldMode);
                        BytecodeManager.incBytecodes(1);
                        final long n11 = divideAndRound;
                        BytecodeManager.incBytecodes(2);
                        n5 = longDigitLength(n11);
                        BytecodeManager.incBytecodes(1);
                        n6 = n5 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                    final long n12 = divideAndRound;
                    final int n13 = checkScaleNonZero;
                    final int n14 = n5;
                    BytecodeManager.incBytecodes(4);
                    final BigDecimal value = valueOf(n12, n13, n14);
                    BytecodeManager.incBytecodes(1);
                    return value;
                }
            }
            final long n15 = divideAndRound;
            final int n16 = checkScaleNonZero;
            BytecodeManager.incBytecodes(3);
            final BigDecimal value2 = valueOf(n15, n16);
            BytecodeManager.incBytecodes(1);
            return value2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal doRound(BigInteger divideAndRoundByTenPow, int n, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            final int n3 = precision;
            BytecodeManager.incBytecodes(2);
            if (n3 > 0) {
                final BigInteger bigInteger = divideAndRoundByTenPow;
                BytecodeManager.incBytecodes(2);
                long n4 = compactValFor(bigInteger);
                BytecodeManager.incBytecodes(1);
                final int oldMode = mathContext.roundingMode.oldMode;
                BytecodeManager.incBytecodes(4);
                final long n5 = lcmp(n4, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n5 == 0) {
                    final BigInteger bigInteger2 = divideAndRoundByTenPow;
                    BytecodeManager.incBytecodes(2);
                    n2 = bigDigitLength(bigInteger2);
                    BytecodeManager.incBytecodes(1);
                    int n6 = n2 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n7 = n6;
                        BytecodeManager.incBytecodes(2);
                        if (n7 <= 0) {
                            break;
                        }
                        final long n8 = n - (long)n6;
                        BytecodeManager.incBytecodes(6);
                        n = checkScaleNonZero(n8);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger3 = divideAndRoundByTenPow;
                        final int n9 = n6;
                        final int n10 = oldMode;
                        BytecodeManager.incBytecodes(4);
                        divideAndRoundByTenPow = divideAndRoundByTenPow(bigInteger3, n9, n10);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger4 = divideAndRoundByTenPow;
                        BytecodeManager.incBytecodes(2);
                        n4 = compactValFor(bigInteger4);
                        BytecodeManager.incBytecodes(1);
                        final long n11 = lcmp(n4, Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(4);
                        if (n11 != 0) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final BigInteger bigInteger5 = divideAndRoundByTenPow;
                        BytecodeManager.incBytecodes(2);
                        n2 = bigDigitLength(bigInteger5);
                        BytecodeManager.incBytecodes(1);
                        n6 = n2 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final long n12 = lcmp(n4, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n12 != 0) {
                    final long n13 = n4;
                    BytecodeManager.incBytecodes(2);
                    int n14 = longDigitLength(n13);
                    BytecodeManager.incBytecodes(1);
                    int n15 = n14 - precision;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n16 = n15;
                        BytecodeManager.incBytecodes(2);
                        if (n16 <= 0) {
                            break;
                        }
                        final long n17 = n - (long)n15;
                        BytecodeManager.incBytecodes(6);
                        n = checkScaleNonZero(n17);
                        BytecodeManager.incBytecodes(1);
                        final long n18 = n4;
                        final long n19 = BigDecimal.LONG_TEN_POWERS_TABLE[n15];
                        final int oldMode2 = mathContext.roundingMode.oldMode;
                        BytecodeManager.incBytecodes(8);
                        n4 = divideAndRound(n18, n19, oldMode2);
                        BytecodeManager.incBytecodes(1);
                        final long n20 = n4;
                        BytecodeManager.incBytecodes(2);
                        n14 = longDigitLength(n20);
                        BytecodeManager.incBytecodes(1);
                        n15 = n14 - precision;
                        BytecodeManager.incBytecodes(5);
                    }
                    final long n21 = n4;
                    final int n22 = n;
                    final int n23 = n14;
                    BytecodeManager.incBytecodes(4);
                    final BigDecimal value = valueOf(n21, n22, n23);
                    BytecodeManager.incBytecodes(1);
                    return value;
                }
            }
            final BigInteger bigInteger6 = divideAndRoundByTenPow;
            final long n24 = Long.MIN_VALUE;
            final int n25 = n;
            final int n26 = n2;
            BytecodeManager.incBytecodes(7);
            final BigDecimal bigDecimal = new BigDecimal(bigInteger6, n24, n25, n26);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger divideAndRoundByTenPow(BigInteger bigInteger, final int n, final int n2) {
        try {
            final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(4);
            if (n < length) {
                final BigInteger bigInteger2 = bigInteger;
                final long n3 = BigDecimal.LONG_TEN_POWERS_TABLE[n];
                BytecodeManager.incBytecodes(6);
                bigInteger = divideAndRound(bigInteger2, n3, n2);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final BigInteger bigInteger3 = bigInteger;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigTenToThe = bigTenToThe(n);
                BytecodeManager.incBytecodes(2);
                bigInteger = divideAndRound(bigInteger3, bigTenToThe, n2);
                BytecodeManager.incBytecodes(1);
            }
            final BigInteger bigInteger4 = bigInteger;
            BytecodeManager.incBytecodes(2);
            return bigInteger4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divideAndRound(final long n, final long n2, final int n3, final int n4, final int n5) {
        try {
            final long n6 = n / n2;
            BytecodeManager.incBytecodes(4);
            final int n7 = 1;
            BytecodeManager.incBytecodes(3);
            if (n4 == n7) {
                BytecodeManager.incBytecodes(3);
                if (n3 == n5) {
                    final long n8 = n6;
                    BytecodeManager.incBytecodes(3);
                    final BigDecimal value = valueOf(n8, n3);
                    BytecodeManager.incBytecodes(1);
                    return value;
                }
            }
            final long n9 = n % n2;
            BytecodeManager.incBytecodes(4);
            final long n10 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            boolean b;
            if (n10 < 0) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            final long n11 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            boolean b2;
            if (n11 < 0) {
                b2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            int n12;
            if (b == b2) {
                n12 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n12 = -1;
                BytecodeManager.incBytecodes(1);
            }
            final int n13 = n12;
            BytecodeManager.incBytecodes(1);
            final long n14 = lcmp(n9, 0L);
            BytecodeManager.incBytecodes(4);
            if (n14 != 0) {
                final int n15 = n13;
                final long n16 = n6;
                final long n17 = n9;
                BytecodeManager.incBytecodes(6);
                final boolean needIncrement = needIncrement(n2, n4, n15, n16, n17);
                BytecodeManager.incBytecodes(1);
                final boolean b3 = needIncrement;
                BytecodeManager.incBytecodes(2);
                long n18;
                if (b3) {
                    n18 = n6 + n13;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    n18 = n6;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(2);
                final BigDecimal value2 = valueOf(n18, n3);
                BytecodeManager.incBytecodes(1);
                return value2;
            }
            BytecodeManager.incBytecodes(3);
            if (n5 != n3) {
                final long n19 = n6;
                final long n20 = n5;
                BytecodeManager.incBytecodes(5);
                final BigDecimal andStripZerosToMatchScale = createAndStripZerosToMatchScale(n19, n3, n20);
                BytecodeManager.incBytecodes(1);
                return andStripZerosToMatchScale;
            }
            final long n21 = n6;
            BytecodeManager.incBytecodes(3);
            final BigDecimal value3 = valueOf(n21, n3);
            BytecodeManager.incBytecodes(1);
            return value3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long divideAndRound(final long n, final long n2, final int n3) {
        try {
            final long n4 = n / n2;
            BytecodeManager.incBytecodes(4);
            final int n5 = 1;
            BytecodeManager.incBytecodes(3);
            if (n3 == n5) {
                final long n6 = n4;
                BytecodeManager.incBytecodes(2);
                return n6;
            }
            final long n7 = n % n2;
            BytecodeManager.incBytecodes(4);
            final long n8 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            boolean b;
            if (n8 < 0) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            final long n9 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            boolean b2;
            if (n9 < 0) {
                b2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            int n10;
            if (b == b2) {
                n10 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n10 = -1;
                BytecodeManager.incBytecodes(1);
            }
            final int n11 = n10;
            BytecodeManager.incBytecodes(1);
            final long n12 = lcmp(n7, 0L);
            BytecodeManager.incBytecodes(4);
            if (n12 != 0) {
                final int n13 = n11;
                final long n14 = n4;
                final long n15 = n7;
                BytecodeManager.incBytecodes(6);
                final boolean needIncrement = needIncrement(n2, n3, n13, n14, n15);
                BytecodeManager.incBytecodes(1);
                final boolean b3 = needIncrement;
                BytecodeManager.incBytecodes(2);
                long n16;
                if (b3) {
                    n16 = n4 + n11;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    n16 = n4;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n16;
            }
            final long n17 = n4;
            BytecodeManager.incBytecodes(2);
            return n17;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean commonNeedIncrement(final int i, final int n, final int n2, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            switch (i) {
                case 7: {
                    final String s = "Rounding necessary";
                    BytecodeManager.incBytecodes(4);
                    final ArithmeticException ex = new ArithmeticException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                case 0: {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                case 1: {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                case 2: {
                    BytecodeManager.incBytecodes(2);
                    boolean b4;
                    if (n > 0) {
                        b4 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b4 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b4;
                }
                case 3: {
                    BytecodeManager.incBytecodes(2);
                    boolean b5;
                    if (n < 0) {
                        b5 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b5 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b5;
                }
                default: {
                    final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    Label_0250: {
                        if (!$assertionsDisabled) {
                            final int n3 = 4;
                            BytecodeManager.incBytecodes(3);
                            if (i >= n3) {
                                final int n4 = 6;
                                BytecodeManager.incBytecodes(3);
                                if (i <= n4) {
                                    break Label_0250;
                                }
                            }
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb = new StringBuilder();
                            final String str = "Unexpected rounding mode";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb.append(str);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final RoundingMode value = RoundingMode.valueOf(i);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder append2 = append.append(value);
                            BytecodeManager.incBytecodes(1);
                            final String string = append2.toString();
                            BytecodeManager.incBytecodes(1);
                            final AssertionError assertionError = new AssertionError((Object)string);
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    if (n2 < 0) {
                        final boolean b6 = false;
                        BytecodeManager.incBytecodes(2);
                        return b6;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (n2 > 0) {
                        final boolean b7 = true;
                        BytecodeManager.incBytecodes(2);
                        return b7;
                    }
                    final boolean $assertionsDisabled2 = BigDecimal.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled2) {
                        BytecodeManager.incBytecodes(2);
                        if (n2 != 0) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError2 = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError2;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    switch (i) {
                        case 5: {
                            final boolean b8 = false;
                            BytecodeManager.incBytecodes(2);
                            return b8;
                        }
                        case 4: {
                            final boolean b9 = true;
                            BytecodeManager.incBytecodes(2);
                            return b9;
                        }
                        case 6: {
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        default: {
                            BytecodeManager.incBytecodes(5);
                            final StringBuilder sb2 = new StringBuilder();
                            final String str2 = "Unexpected rounding mode";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = sb2.append(str2);
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append4 = append3.append(i);
                            BytecodeManager.incBytecodes(1);
                            final String string2 = append4.toString();
                            BytecodeManager.incBytecodes(1);
                            final AssertionError assertionError3 = new AssertionError((Object)string2);
                            BytecodeManager.incBytecodes(1);
                            throw assertionError3;
                        }
                    }
                    break;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean needIncrement(final long n, final int n2, final int n3, final long n4, final long n5) {
        try {
            final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final long n6 = lcmp(n5, 0L);
                BytecodeManager.incBytecodes(4);
                if (n6 == 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final long n7 = lcmp(n5, -4611686018427387904L);
            BytecodeManager.incBytecodes(4);
            int longCompareMagnitude = 0;
            Label_0102: {
                if (n7 > 0) {
                    final long n8 = lcmp(n5, 4611686018427387903L);
                    BytecodeManager.incBytecodes(4);
                    if (n8 <= 0) {
                        final long n9 = 2L * n5;
                        BytecodeManager.incBytecodes(5);
                        longCompareMagnitude = longCompareMagnitude(n9, n);
                        BytecodeManager.incBytecodes(1);
                        break Label_0102;
                    }
                }
                longCompareMagnitude = 1;
                BytecodeManager.incBytecodes(3);
            }
            final int n10 = longCompareMagnitude;
            final long n11 = lcmp(n4 & 0x1L, 0L);
            BytecodeManager.incBytecodes(9);
            boolean b;
            if (n11 != 0) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final boolean commonNeedIncrement = commonNeedIncrement(n2, n3, n10, b);
            BytecodeManager.incBytecodes(1);
            return commonNeedIncrement;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger divideAndRound(final BigInteger bigInteger, final long n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int[] mag = bigInteger.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(mag);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger;
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(4);
            final long divide = mutableBigInteger3.divide(n, mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final long n3 = lcmp(divide, 0L);
            BytecodeManager.incBytecodes(4);
            boolean b;
            if (n3 == 0) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            final boolean b2 = b;
            BytecodeManager.incBytecodes(1);
            final long n4 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            int signum;
            if (n4 < 0) {
                signum = -bigInteger.signum;
                BytecodeManager.incBytecodes(4);
            }
            else {
                signum = bigInteger.signum;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = signum;
            BytecodeManager.incBytecodes(1);
            final boolean b3 = b2;
            BytecodeManager.incBytecodes(2);
            if (!b3) {
                final int n6 = n5;
                final MutableBigInteger mutableBigInteger5 = mutableBigInteger2;
                final long n7 = divide;
                BytecodeManager.incBytecodes(6);
                final boolean needIncrement = needIncrement(n, n2, n6, mutableBigInteger5, n7);
                BytecodeManager.incBytecodes(1);
                if (needIncrement) {
                    final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
                    final MutableBigInteger one = MutableBigInteger.ONE;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger6.add(one);
                }
            }
            final MutableBigInteger mutableBigInteger7 = mutableBigInteger2;
            final int n8 = n5;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger2 = mutableBigInteger7.toBigInteger(n8);
            BytecodeManager.incBytecodes(1);
            return bigInteger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divideAndRound(final BigInteger bigInteger, final long n, final int n2, final int n3, final int n4) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int[] mag = bigInteger.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(mag);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger3 = mutableBigInteger;
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger2;
            BytecodeManager.incBytecodes(4);
            final long divide = mutableBigInteger3.divide(n, mutableBigInteger4);
            BytecodeManager.incBytecodes(1);
            final long n5 = lcmp(divide, 0L);
            BytecodeManager.incBytecodes(4);
            boolean b;
            if (n5 == 0) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            final boolean b2 = b;
            BytecodeManager.incBytecodes(1);
            final long n6 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            int signum;
            if (n6 < 0) {
                signum = -bigInteger.signum;
                BytecodeManager.incBytecodes(4);
            }
            else {
                signum = bigInteger.signum;
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = signum;
            BytecodeManager.incBytecodes(1);
            final boolean b3 = b2;
            BytecodeManager.incBytecodes(2);
            if (!b3) {
                final int n8 = n7;
                final MutableBigInteger mutableBigInteger5 = mutableBigInteger2;
                final long n9 = divide;
                BytecodeManager.incBytecodes(6);
                final boolean needIncrement = needIncrement(n, n3, n8, mutableBigInteger5, n9);
                BytecodeManager.incBytecodes(1);
                if (needIncrement) {
                    final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
                    final MutableBigInteger one = MutableBigInteger.ONE;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger6.add(one);
                }
                final MutableBigInteger mutableBigInteger7 = mutableBigInteger2;
                final int n10 = n7;
                BytecodeManager.incBytecodes(4);
                final BigDecimal bigDecimal = mutableBigInteger7.toBigDecimal(n10, n2);
                BytecodeManager.incBytecodes(1);
                return bigDecimal;
            }
            BytecodeManager.incBytecodes(3);
            if (n4 == n2) {
                final MutableBigInteger mutableBigInteger8 = mutableBigInteger2;
                final int n11 = n7;
                BytecodeManager.incBytecodes(4);
                final BigDecimal bigDecimal2 = mutableBigInteger8.toBigDecimal(n11, n2);
                BytecodeManager.incBytecodes(1);
                return bigDecimal2;
            }
            final MutableBigInteger mutableBigInteger9 = mutableBigInteger2;
            final int n12 = n7;
            BytecodeManager.incBytecodes(3);
            final long compactValue = mutableBigInteger9.toCompactValue(n12);
            BytecodeManager.incBytecodes(1);
            final long n13 = lcmp(compactValue, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n13 != 0) {
                final long n14 = compactValue;
                final long n15 = n4;
                BytecodeManager.incBytecodes(5);
                final BigDecimal andStripZerosToMatchScale = createAndStripZerosToMatchScale(n14, n2, n15);
                BytecodeManager.incBytecodes(1);
                return andStripZerosToMatchScale;
            }
            final MutableBigInteger mutableBigInteger10 = mutableBigInteger2;
            final int n16 = n7;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger2 = mutableBigInteger10.toBigInteger(n16);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = bigInteger2;
            final long n17 = n4;
            BytecodeManager.incBytecodes(5);
            final BigDecimal andStripZerosToMatchScale2 = createAndStripZerosToMatchScale(bigInteger3, n2, n17);
            BytecodeManager.incBytecodes(1);
            return andStripZerosToMatchScale2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean needIncrement(final long n, final int n2, final int n3, final MutableBigInteger mutableBigInteger, final long n4) {
        try {
            final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final long n5 = lcmp(n4, 0L);
                BytecodeManager.incBytecodes(4);
                if (n5 == 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final long n6 = lcmp(n4, -4611686018427387904L);
            BytecodeManager.incBytecodes(4);
            int longCompareMagnitude = 0;
            Label_0102: {
                if (n6 > 0) {
                    final long n7 = lcmp(n4, 4611686018427387903L);
                    BytecodeManager.incBytecodes(4);
                    if (n7 <= 0) {
                        final long n8 = 2L * n4;
                        BytecodeManager.incBytecodes(5);
                        longCompareMagnitude = longCompareMagnitude(n8, n);
                        BytecodeManager.incBytecodes(1);
                        break Label_0102;
                    }
                }
                longCompareMagnitude = 1;
                BytecodeManager.incBytecodes(3);
            }
            final int n9 = longCompareMagnitude;
            BytecodeManager.incBytecodes(5);
            final boolean odd = mutableBigInteger.isOdd();
            BytecodeManager.incBytecodes(1);
            final boolean commonNeedIncrement = commonNeedIncrement(n2, n3, n9, odd);
            BytecodeManager.incBytecodes(1);
            return commonNeedIncrement;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger divideAndRound(final BigInteger bigInteger, final BigInteger bigInteger2, final int n) {
        try {
            final int[] mag = bigInteger.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(mag);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final int[] mag2 = bigInteger2.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mag2);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divide = mutableBigInteger4.divide(mutableBigInteger5, mutableBigInteger6);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger7 = divide;
            BytecodeManager.incBytecodes(2);
            final boolean zero = mutableBigInteger7.isZero();
            BytecodeManager.incBytecodes(1);
            final int signum = bigInteger.signum;
            final int signum2 = bigInteger2.signum;
            BytecodeManager.incBytecodes(5);
            int n2;
            if (signum != signum2) {
                n2 = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = 1;
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = n2;
            BytecodeManager.incBytecodes(1);
            final boolean b = zero;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                final MutableBigInteger mutableBigInteger8 = mutableBigInteger3;
                final int n4 = n3;
                final MutableBigInteger mutableBigInteger9 = mutableBigInteger2;
                final MutableBigInteger mutableBigInteger10 = divide;
                BytecodeManager.incBytecodes(6);
                final boolean needIncrement = needIncrement(mutableBigInteger8, n, n4, mutableBigInteger9, mutableBigInteger10);
                BytecodeManager.incBytecodes(1);
                if (needIncrement) {
                    final MutableBigInteger mutableBigInteger11 = mutableBigInteger2;
                    final MutableBigInteger one = MutableBigInteger.ONE;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger11.add(one);
                }
            }
            final MutableBigInteger mutableBigInteger12 = mutableBigInteger2;
            final int n5 = n3;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger3 = mutableBigInteger12.toBigInteger(n5);
            BytecodeManager.incBytecodes(1);
            return bigInteger3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divideAndRound(final BigInteger bigInteger, final BigInteger bigInteger2, final int n, final int n2, final int n3) {
        try {
            final int[] mag = bigInteger.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger = new MutableBigInteger(mag);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final MutableBigInteger mutableBigInteger2 = new MutableBigInteger();
            BytecodeManager.incBytecodes(1);
            final int[] mag2 = bigInteger2.mag;
            BytecodeManager.incBytecodes(5);
            final MutableBigInteger mutableBigInteger3 = new MutableBigInteger(mag2);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
            final MutableBigInteger mutableBigInteger5 = mutableBigInteger3;
            final MutableBigInteger mutableBigInteger6 = mutableBigInteger2;
            BytecodeManager.incBytecodes(4);
            final MutableBigInteger divide = mutableBigInteger4.divide(mutableBigInteger5, mutableBigInteger6);
            BytecodeManager.incBytecodes(1);
            final MutableBigInteger mutableBigInteger7 = divide;
            BytecodeManager.incBytecodes(2);
            final boolean zero = mutableBigInteger7.isZero();
            BytecodeManager.incBytecodes(1);
            final int signum = bigInteger.signum;
            final int signum2 = bigInteger2.signum;
            BytecodeManager.incBytecodes(5);
            int n4;
            if (signum != signum2) {
                n4 = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n4 = 1;
                BytecodeManager.incBytecodes(1);
            }
            final int n5 = n4;
            BytecodeManager.incBytecodes(1);
            final boolean b = zero;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                final MutableBigInteger mutableBigInteger8 = mutableBigInteger3;
                final int n6 = n5;
                final MutableBigInteger mutableBigInteger9 = mutableBigInteger2;
                final MutableBigInteger mutableBigInteger10 = divide;
                BytecodeManager.incBytecodes(6);
                final boolean needIncrement = needIncrement(mutableBigInteger8, n2, n6, mutableBigInteger9, mutableBigInteger10);
                BytecodeManager.incBytecodes(1);
                if (needIncrement) {
                    final MutableBigInteger mutableBigInteger11 = mutableBigInteger2;
                    final MutableBigInteger one = MutableBigInteger.ONE;
                    BytecodeManager.incBytecodes(3);
                    mutableBigInteger11.add(one);
                }
                final MutableBigInteger mutableBigInteger12 = mutableBigInteger2;
                final int n7 = n5;
                BytecodeManager.incBytecodes(4);
                final BigDecimal bigDecimal = mutableBigInteger12.toBigDecimal(n7, n);
                BytecodeManager.incBytecodes(1);
                return bigDecimal;
            }
            BytecodeManager.incBytecodes(3);
            if (n3 == n) {
                final MutableBigInteger mutableBigInteger13 = mutableBigInteger2;
                final int n8 = n5;
                BytecodeManager.incBytecodes(4);
                final BigDecimal bigDecimal2 = mutableBigInteger13.toBigDecimal(n8, n);
                BytecodeManager.incBytecodes(1);
                return bigDecimal2;
            }
            final MutableBigInteger mutableBigInteger14 = mutableBigInteger2;
            final int n9 = n5;
            BytecodeManager.incBytecodes(3);
            final long compactValue = mutableBigInteger14.toCompactValue(n9);
            BytecodeManager.incBytecodes(1);
            final long n10 = lcmp(compactValue, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n10 != 0) {
                final long n11 = compactValue;
                final long n12 = n3;
                BytecodeManager.incBytecodes(5);
                final BigDecimal andStripZerosToMatchScale = createAndStripZerosToMatchScale(n11, n, n12);
                BytecodeManager.incBytecodes(1);
                return andStripZerosToMatchScale;
            }
            final MutableBigInteger mutableBigInteger15 = mutableBigInteger2;
            final int n13 = n5;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigInteger3 = mutableBigInteger15.toBigInteger(n13);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger4 = bigInteger3;
            final long n14 = n3;
            BytecodeManager.incBytecodes(5);
            final BigDecimal andStripZerosToMatchScale2 = createAndStripZerosToMatchScale(bigInteger4, n, n14);
            BytecodeManager.incBytecodes(1);
            return andStripZerosToMatchScale2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean needIncrement(final MutableBigInteger mutableBigInteger, final int n, final int n2, final MutableBigInteger mutableBigInteger2, final MutableBigInteger mutableBigInteger3) {
        try {
            final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                BytecodeManager.incBytecodes(2);
                final boolean zero = mutableBigInteger3.isZero();
                BytecodeManager.incBytecodes(1);
                if (zero) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            BytecodeManager.incBytecodes(3);
            final int compareHalf = mutableBigInteger3.compareHalf(mutableBigInteger);
            BytecodeManager.incBytecodes(1);
            final int n3 = compareHalf;
            BytecodeManager.incBytecodes(5);
            final boolean odd = mutableBigInteger2.isOdd();
            BytecodeManager.incBytecodes(1);
            final boolean commonNeedIncrement = commonNeedIncrement(n, n2, n3, odd);
            BytecodeManager.incBytecodes(1);
            return commonNeedIncrement;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal createAndStripZerosToMatchScale(BigInteger bigInteger, int checkScale, final long n) {
        try {
            while (true) {
                final BigInteger bigInteger2 = bigInteger;
                final BigInteger ten = BigInteger.TEN;
                BytecodeManager.incBytecodes(3);
                final int compareMagnitude = bigInteger2.compareMagnitude(ten);
                BytecodeManager.incBytecodes(1);
                if (compareMagnitude < 0) {
                    break;
                }
                final long n2 = lcmp((long)checkScale, n);
                BytecodeManager.incBytecodes(5);
                if (n2 <= 0) {
                    break;
                }
                final BigInteger bigInteger3 = bigInteger;
                final int n3 = 0;
                BytecodeManager.incBytecodes(3);
                final boolean testBit = bigInteger3.testBit(n3);
                BytecodeManager.incBytecodes(1);
                if (testBit) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final BigInteger bigInteger4 = bigInteger;
                final BigInteger ten2 = BigInteger.TEN;
                BytecodeManager.incBytecodes(3);
                final BigInteger[] divideAndRemainder = bigInteger4.divideAndRemainder(ten2);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger5 = divideAndRemainder[1];
                BytecodeManager.incBytecodes(4);
                final int signum = bigInteger5.signum();
                BytecodeManager.incBytecodes(1);
                if (signum != 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                bigInteger = divideAndRemainder[0];
                BytecodeManager.incBytecodes(4);
                final BigInteger bigInteger6 = bigInteger;
                final long n4 = checkScale - 1L;
                BytecodeManager.incBytecodes(6);
                checkScale = checkScale(bigInteger6, n4);
                BytecodeManager.incBytecodes(2);
            }
            final BigInteger bigInteger7 = bigInteger;
            final int n5 = checkScale;
            final int n6 = 0;
            BytecodeManager.incBytecodes(4);
            final BigDecimal value = valueOf(bigInteger7, n5, n6);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal createAndStripZerosToMatchScale(long n, int checkScale, final long n2) {
        try {
            while (true) {
                final long a = n;
                BytecodeManager.incBytecodes(2);
                final long n3 = lcmp(Math.abs(a), 10L);
                BytecodeManager.incBytecodes(3);
                if (n3 < 0) {
                    break;
                }
                final long n4 = lcmp((long)checkScale, n2);
                BytecodeManager.incBytecodes(5);
                if (n4 <= 0) {
                    break;
                }
                final long n5 = lcmp(n & 0x1L, 0L);
                BytecodeManager.incBytecodes(6);
                if (n5 != 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final long n6 = n % 10L;
                BytecodeManager.incBytecodes(4);
                final long n7 = lcmp(n6, 0L);
                BytecodeManager.incBytecodes(4);
                if (n7 != 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                n /= 10L;
                BytecodeManager.incBytecodes(4);
                final long n8 = n;
                final long n9 = checkScale - 1L;
                BytecodeManager.incBytecodes(6);
                checkScale = checkScale(n8, n9);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            final long n10 = n;
            final int n11 = checkScale;
            BytecodeManager.incBytecodes(3);
            final BigDecimal value = valueOf(n10, n11);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal stripZerosToMatchScale(final BigInteger bigInteger, final long n, final int n2, final int n3) {
        try {
            final long n4 = lcmp(n, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n4 != 0) {
                final long n5 = n3;
                BytecodeManager.incBytecodes(5);
                final BigDecimal andStripZerosToMatchScale = createAndStripZerosToMatchScale(n, n2, n5);
                BytecodeManager.incBytecodes(1);
                return andStripZerosToMatchScale;
            }
            BytecodeManager.incBytecodes(2);
            BigInteger inflated_BIGINT;
            if (bigInteger == null) {
                inflated_BIGINT = BigDecimal.INFLATED_BIGINT;
                BytecodeManager.incBytecodes(2);
            }
            else {
                inflated_BIGINT = bigInteger;
                BytecodeManager.incBytecodes(1);
            }
            final long n6 = n3;
            BytecodeManager.incBytecodes(4);
            final BigDecimal andStripZerosToMatchScale2 = createAndStripZerosToMatchScale(inflated_BIGINT, n2, n6);
            BytecodeManager.incBytecodes(1);
            return andStripZerosToMatchScale2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long add(final long n, final long n2) {
        try {
            final long n3 = n + n2;
            BytecodeManager.incBytecodes(4);
            final long n4 = lcmp((n3 ^ n) & (n3 ^ n2), 0L);
            BytecodeManager.incBytecodes(10);
            if (n4 >= 0) {
                final long n5 = n3;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            final long n6 = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal add(final long n, final long n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(3);
            final long add = add(n, n2);
            BytecodeManager.incBytecodes(1);
            final long n4 = lcmp(add, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n4 != 0) {
                final long n5 = add;
                BytecodeManager.incBytecodes(3);
                final BigDecimal value = valueOf(n5, n3);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            BytecodeManager.incBytecodes(4);
            final BigInteger value2 = BigInteger.valueOf(n);
            BytecodeManager.incBytecodes(2);
            final BigInteger add2 = value2.add(n2);
            BytecodeManager.incBytecodes(2);
            final BigDecimal bigDecimal = new BigDecimal(add2, n3);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal add(final long n, final int n2, final long n3, final int n4) {
        try {
            final long n5 = n2 - (long)n4;
            BytecodeManager.incBytecodes(6);
            final long n6 = lcmp(n5, 0L);
            BytecodeManager.incBytecodes(4);
            if (n6 == 0) {
                BytecodeManager.incBytecodes(4);
                final BigDecimal add = add(n, n3, n2);
                BytecodeManager.incBytecodes(1);
                return add;
            }
            final long n7 = lcmp(n5, 0L);
            BytecodeManager.incBytecodes(4);
            if (n7 < 0) {
                final long n8 = -n5;
                BytecodeManager.incBytecodes(4);
                final int checkScale = checkScale(n, n8);
                BytecodeManager.incBytecodes(1);
                final int n9 = checkScale;
                BytecodeManager.incBytecodes(3);
                final long longMultiplyPowerTen = longMultiplyPowerTen(n, n9);
                BytecodeManager.incBytecodes(1);
                final long n10 = lcmp(longMultiplyPowerTen, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n10 != 0) {
                    final long n11 = longMultiplyPowerTen;
                    BytecodeManager.incBytecodes(4);
                    final BigDecimal add2 = add(n11, n3, n4);
                    BytecodeManager.incBytecodes(1);
                    return add2;
                }
                final int n12 = checkScale;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(n, n12);
                BytecodeManager.incBytecodes(2);
                final BigInteger add3 = bigMultiplyPowerTen.add(n3);
                BytecodeManager.incBytecodes(1);
                final long n13 = lcmp(n ^ n3, 0L);
                BytecodeManager.incBytecodes(6);
                BigDecimal value;
                if (n13 >= 0) {
                    final BigInteger bigInteger;
                    final long n14;
                    final int n15;
                    value = new BigDecimal(bigInteger, n14, n4, n15);
                    bigInteger = add3;
                    n14 = Long.MIN_VALUE;
                    n15 = 0;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final BigInteger bigInteger2 = add3;
                    final int n16 = 0;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    value = valueOf(bigInteger2, n4, n16);
                }
                BytecodeManager.incBytecodes(1);
                return value;
            }
            else {
                final long n17 = n5;
                BytecodeManager.incBytecodes(3);
                final int checkScale2 = checkScale(n3, n17);
                BytecodeManager.incBytecodes(1);
                final int n18 = checkScale2;
                BytecodeManager.incBytecodes(3);
                final long longMultiplyPowerTen2 = longMultiplyPowerTen(n3, n18);
                BytecodeManager.incBytecodes(1);
                final long n19 = lcmp(longMultiplyPowerTen2, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n19 != 0) {
                    final long n20 = longMultiplyPowerTen2;
                    BytecodeManager.incBytecodes(4);
                    final BigDecimal add4 = add(n, n20, n2);
                    BytecodeManager.incBytecodes(1);
                    return add4;
                }
                final int n21 = checkScale2;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(n3, n21);
                BytecodeManager.incBytecodes(2);
                final BigInteger add5 = bigMultiplyPowerTen2.add(n);
                BytecodeManager.incBytecodes(1);
                final long n22 = lcmp(n ^ n3, 0L);
                BytecodeManager.incBytecodes(6);
                BigDecimal value2;
                if (n22 >= 0) {
                    final BigInteger bigInteger3;
                    final long n23;
                    final int n24;
                    value2 = new BigDecimal(bigInteger3, n23, n2, n24);
                    bigInteger3 = add5;
                    n23 = Long.MIN_VALUE;
                    n24 = 0;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final BigInteger bigInteger4 = add5;
                    final int n25 = 0;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    value2 = valueOf(bigInteger4, n2, n25);
                }
                BytecodeManager.incBytecodes(1);
                return value2;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal add(final long i, final int n, BigInteger bigMultiplyPowerTen, final int n2) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            final long n4 = n3 - (long)n2;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(2);
            final int signum = Long.signum(i);
            final int signum2 = bigMultiplyPowerTen.signum;
            BytecodeManager.incBytecodes(3);
            int n5;
            if (signum == signum2) {
                n5 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n5 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n6 = n5;
            BytecodeManager.incBytecodes(1);
            final long n7 = lcmp(n4, 0L);
            BytecodeManager.incBytecodes(4);
            BigInteger bigInteger2;
            if (n7 < 0) {
                final long n8 = -n4;
                BytecodeManager.incBytecodes(4);
                final int checkScale = checkScale(i, n8);
                BytecodeManager.incBytecodes(1);
                n3 = n2;
                BytecodeManager.incBytecodes(2);
                final int n9 = checkScale;
                BytecodeManager.incBytecodes(3);
                final long longMultiplyPowerTen = longMultiplyPowerTen(i, n9);
                BytecodeManager.incBytecodes(1);
                final long n10 = lcmp(longMultiplyPowerTen, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                if (n10 == 0) {
                    final BigInteger bigInteger = bigMultiplyPowerTen;
                    final int n11 = checkScale;
                    BytecodeManager.incBytecodes(4);
                    final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(i, n11);
                    BytecodeManager.incBytecodes(1);
                    bigInteger2 = bigInteger.add(bigMultiplyPowerTen2);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final BigInteger bigInteger3 = bigMultiplyPowerTen;
                    final long n12 = longMultiplyPowerTen;
                    BytecodeManager.incBytecodes(3);
                    bigInteger2 = bigInteger3.add(n12);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                final BigInteger bigInteger4 = bigMultiplyPowerTen;
                final long n13 = n4;
                BytecodeManager.incBytecodes(3);
                final int checkScale2 = checkScale(bigInteger4, n13);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger5 = bigMultiplyPowerTen;
                final int n14 = checkScale2;
                BytecodeManager.incBytecodes(3);
                bigMultiplyPowerTen = bigMultiplyPowerTen(bigInteger5, n14);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger6 = bigMultiplyPowerTen;
                BytecodeManager.incBytecodes(3);
                bigInteger2 = bigInteger6.add(i);
                BytecodeManager.incBytecodes(1);
            }
            final int n15 = n6;
            BytecodeManager.incBytecodes(2);
            BigDecimal value;
            if (n15 != 0) {
                final BigInteger bigInteger7;
                final long n16;
                final int n17;
                final int n18;
                value = new BigDecimal(bigInteger7, n16, n17, n18);
                bigInteger7 = bigInteger2;
                n16 = Long.MIN_VALUE;
                n17 = n3;
                n18 = 0;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final BigInteger bigInteger8 = bigInteger2;
                final int n19 = n3;
                final int n20 = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                value = valueOf(bigInteger8, n19, n20);
            }
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal add(BigInteger bigMultiplyPowerTen, final int n, BigInteger bigMultiplyPowerTen2, final int n2) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            final long n4 = n3 - (long)n2;
            BytecodeManager.incBytecodes(6);
            final long n5 = lcmp(n4, 0L);
            BytecodeManager.incBytecodes(4);
            if (n5 != 0) {
                final long n6 = lcmp(n4, 0L);
                BytecodeManager.incBytecodes(4);
                if (n6 < 0) {
                    final BigInteger bigInteger = bigMultiplyPowerTen;
                    final long n7 = -n4;
                    BytecodeManager.incBytecodes(4);
                    final int checkScale = checkScale(bigInteger, n7);
                    BytecodeManager.incBytecodes(1);
                    n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    final BigInteger bigInteger2 = bigMultiplyPowerTen;
                    final int n8 = checkScale;
                    BytecodeManager.incBytecodes(3);
                    bigMultiplyPowerTen = bigMultiplyPowerTen(bigInteger2, n8);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final BigInteger bigInteger3 = bigMultiplyPowerTen2;
                    final long n9 = n4;
                    BytecodeManager.incBytecodes(3);
                    final int checkScale2 = checkScale(bigInteger3, n9);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger4 = bigMultiplyPowerTen2;
                    final int n10 = checkScale2;
                    BytecodeManager.incBytecodes(3);
                    bigMultiplyPowerTen2 = bigMultiplyPowerTen(bigInteger4, n10);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final BigInteger bigInteger5 = bigMultiplyPowerTen;
            final BigInteger bigInteger6 = bigMultiplyPowerTen2;
            BytecodeManager.incBytecodes(3);
            final BigInteger add = bigInteger5.add(bigInteger6);
            BytecodeManager.incBytecodes(1);
            final int signum = bigMultiplyPowerTen.signum;
            final int signum2 = bigMultiplyPowerTen2.signum;
            BytecodeManager.incBytecodes(5);
            BigDecimal value;
            if (signum == signum2) {
                final BigInteger bigInteger7;
                final long n11;
                final int n12;
                final int n13;
                value = new BigDecimal(bigInteger7, n11, n12, n13);
                bigInteger7 = add;
                n11 = Long.MIN_VALUE;
                n12 = n3;
                n13 = 0;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final BigInteger bigInteger8 = add;
                final int n14 = n3;
                final int n15 = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                value = valueOf(bigInteger8, n14, n15);
            }
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger bigMultiplyPowerTen(final long n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n2 <= 0) {
                BytecodeManager.incBytecodes(2);
                final BigInteger value = BigInteger.valueOf(n);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            BytecodeManager.incBytecodes(2);
            final BigInteger bigTenToThe = bigTenToThe(n2);
            BytecodeManager.incBytecodes(2);
            final BigInteger multiply = bigTenToThe.multiply(n);
            BytecodeManager.incBytecodes(1);
            return multiply;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigInteger bigMultiplyPowerTen(final BigInteger bigInteger, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                BytecodeManager.incBytecodes(2);
                return bigInteger;
            }
            final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(4);
            if (n < length) {
                final long n2 = BigDecimal.LONG_TEN_POWERS_TABLE[n];
                BytecodeManager.incBytecodes(5);
                final BigInteger multiply = bigInteger.multiply(n2);
                BytecodeManager.incBytecodes(1);
                return multiply;
            }
            BytecodeManager.incBytecodes(3);
            final BigInteger bigTenToThe = bigTenToThe(n);
            BytecodeManager.incBytecodes(1);
            final BigInteger multiply2 = bigInteger.multiply(bigTenToThe);
            BytecodeManager.incBytecodes(1);
            return multiply2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divideSmallFastPath(final long n, final int n2, final long n3, int n4, final long n5, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int oldMode = mathContext.roundingMode.oldMode;
            BytecodeManager.incBytecodes(4);
            final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0091: {
                if (!$assertionsDisabled) {
                    final int n6 = n4;
                    BytecodeManager.incBytecodes(3);
                    if (n2 <= n6) {
                        final int n7 = n4;
                        final int n8 = 18;
                        BytecodeManager.incBytecodes(3);
                        if (n7 < n8) {
                            final int n9 = precision;
                            final int n10 = 18;
                            BytecodeManager.incBytecodes(3);
                            if (n9 < n10) {
                                break Label_0091;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int n11 = n4 - n2;
            BytecodeManager.incBytecodes(4);
            final int n12 = n11;
            BytecodeManager.incBytecodes(2);
            long longMultiplyPowerTen;
            if (n12 == 0) {
                longMultiplyPowerTen = n;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n13 = n11;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                longMultiplyPowerTen = longMultiplyPowerTen(n, n13);
            }
            final long n14 = longMultiplyPowerTen;
            BytecodeManager.incBytecodes(1);
            final long n15 = n14;
            BytecodeManager.incBytecodes(3);
            final int longCompareMagnitude = longCompareMagnitude(n15, n3);
            BytecodeManager.incBytecodes(1);
            final int n16 = longCompareMagnitude;
            BytecodeManager.incBytecodes(2);
            BigDecimal bigDecimal;
            if (n16 > 0) {
                --n4;
                BytecodeManager.incBytecodes(1);
                final long n17 = n5 + n4 - n2 + precision;
                BytecodeManager.incBytecodes(11);
                final int checkScaleNonZero = checkScaleNonZero(n17);
                BytecodeManager.incBytecodes(1);
                final long n18 = precision + (long)n4 - n2;
                BytecodeManager.incBytecodes(9);
                final int checkScaleNonZero2 = checkScaleNonZero(n18);
                BytecodeManager.incBytecodes(1);
                if (checkScaleNonZero2 > 0) {
                    final long n19 = precision + (long)n4 - n2;
                    BytecodeManager.incBytecodes(9);
                    final int checkScaleNonZero3 = checkScaleNonZero(n19);
                    BytecodeManager.incBytecodes(1);
                    final int n20 = checkScaleNonZero3;
                    BytecodeManager.incBytecodes(3);
                    final long longMultiplyPowerTen2;
                    final long n21 = lcmp(longMultiplyPowerTen2 = longMultiplyPowerTen(n, n20), Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n21 == 0) {
                        bigDecimal = null;
                        BytecodeManager.incBytecodes(2);
                        final int n22 = precision - 1;
                        BytecodeManager.incBytecodes(4);
                        if (n22 >= 0) {
                            final int n23 = precision - 1;
                            final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
                            BytecodeManager.incBytecodes(6);
                            if (n23 < length) {
                                final long n24 = BigDecimal.LONG_TEN_POWERS_TABLE[precision - 1];
                                final long n25 = n14;
                                final int n26 = checkScaleNonZero;
                                final int n27 = oldMode;
                                BytecodeManager.incBytecodes(11);
                                final int checkScaleNonZero4 = checkScaleNonZero(n5);
                                BytecodeManager.incBytecodes(1);
                                bigDecimal = multiplyDivideAndRound(n24, n25, n3, n26, n27, checkScaleNonZero4);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final BigDecimal bigDecimal2 = bigDecimal;
                        BytecodeManager.incBytecodes(2);
                        if (bigDecimal2 == null) {
                            final long n28 = n14;
                            final int n29 = precision - 1;
                            BytecodeManager.incBytecodes(5);
                            final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(n28, n29);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger bigInteger = bigMultiplyPowerTen;
                            final int n30 = checkScaleNonZero;
                            final int n31 = oldMode;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final int checkScaleNonZero5 = checkScaleNonZero(n5);
                            BytecodeManager.incBytecodes(1);
                            bigDecimal = divideAndRound(bigInteger, n3, n30, n31, checkScaleNonZero5);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final long n32 = longMultiplyPowerTen2;
                        final int n33 = checkScaleNonZero;
                        final int n34 = oldMode;
                        BytecodeManager.incBytecodes(6);
                        final int checkScaleNonZero6 = checkScaleNonZero(n5);
                        BytecodeManager.incBytecodes(1);
                        bigDecimal = divideAndRound(n32, n3, n33, n34, checkScaleNonZero6);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final long n35 = n2 - (long)precision;
                    BytecodeManager.incBytecodes(6);
                    final int checkScaleNonZero7 = checkScaleNonZero(n35);
                    BytecodeManager.incBytecodes(1);
                    final int n36 = checkScaleNonZero7;
                    final int n37 = n4;
                    BytecodeManager.incBytecodes(3);
                    if (n36 == n37) {
                        final int n38 = checkScaleNonZero;
                        final int n39 = oldMode;
                        BytecodeManager.incBytecodes(6);
                        final int checkScaleNonZero8 = checkScaleNonZero(n5);
                        BytecodeManager.incBytecodes(1);
                        bigDecimal = divideAndRound(n, n3, n38, n39, checkScaleNonZero8);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final long n40 = checkScaleNonZero7 - (long)n4;
                        BytecodeManager.incBytecodes(6);
                        final int checkScaleNonZero9 = checkScaleNonZero(n40);
                        BytecodeManager.incBytecodes(1);
                        final int n41 = checkScaleNonZero9;
                        BytecodeManager.incBytecodes(3);
                        final long longMultiplyPowerTen3;
                        final long n42 = lcmp(longMultiplyPowerTen3 = longMultiplyPowerTen(n3, n41), Long.MIN_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n42 == 0) {
                            final int n43 = checkScaleNonZero9;
                            BytecodeManager.incBytecodes(3);
                            final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(n3, n43);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            final BigInteger value = BigInteger.valueOf(n);
                            final BigInteger bigInteger2 = bigMultiplyPowerTen2;
                            final int n44 = checkScaleNonZero;
                            final int n45 = oldMode;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final int checkScaleNonZero10 = checkScaleNonZero(n5);
                            BytecodeManager.incBytecodes(1);
                            bigDecimal = divideAndRound(value, bigInteger2, n44, n45, checkScaleNonZero10);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final long n46 = longMultiplyPowerTen3;
                            final int n47 = checkScaleNonZero;
                            final int n48 = oldMode;
                            BytecodeManager.incBytecodes(6);
                            final int checkScaleNonZero11 = checkScaleNonZero(n5);
                            BytecodeManager.incBytecodes(1);
                            bigDecimal = divideAndRound(n, n46, n47, n48, checkScaleNonZero11);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                final long n49 = n5 + n4 - n2 + precision;
                BytecodeManager.incBytecodes(11);
                final int checkScaleNonZero12 = checkScaleNonZero(n49);
                BytecodeManager.incBytecodes(1);
                final int n50 = longCompareMagnitude;
                BytecodeManager.incBytecodes(2);
                if (n50 == 0) {
                    final long n51 = lcmp(n14, 0L);
                    BytecodeManager.incBytecodes(4);
                    boolean b;
                    if (n51 < 0) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    final long n52 = lcmp(n3, 0L);
                    BytecodeManager.incBytecodes(4);
                    boolean b2;
                    if (n52 < 0) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b2 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    int n53;
                    if (b == b2) {
                        n53 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n53 = -1;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n54 = precision;
                    final int n55 = checkScaleNonZero12;
                    BytecodeManager.incBytecodes(4);
                    final int checkScaleNonZero13 = checkScaleNonZero(n5);
                    BytecodeManager.incBytecodes(1);
                    bigDecimal = roundedTenPower(n53, n54, n55, checkScaleNonZero13);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n56 = n14;
                    final int n57 = precision;
                    BytecodeManager.incBytecodes(3);
                    final long longMultiplyPowerTen4;
                    final long n58 = lcmp(longMultiplyPowerTen4 = longMultiplyPowerTen(n56, n57), Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n58 == 0) {
                        bigDecimal = null;
                        BytecodeManager.incBytecodes(2);
                        final int n59 = precision;
                        final int length2 = BigDecimal.LONG_TEN_POWERS_TABLE.length;
                        BytecodeManager.incBytecodes(4);
                        if (n59 < length2) {
                            final long n60 = BigDecimal.LONG_TEN_POWERS_TABLE[precision];
                            final long n61 = n14;
                            final int n62 = checkScaleNonZero12;
                            final int n63 = oldMode;
                            BytecodeManager.incBytecodes(9);
                            final int checkScaleNonZero14 = checkScaleNonZero(n5);
                            BytecodeManager.incBytecodes(1);
                            bigDecimal = multiplyDivideAndRound(n60, n61, n3, n62, n63, checkScaleNonZero14);
                            BytecodeManager.incBytecodes(1);
                        }
                        final BigDecimal bigDecimal3 = bigDecimal;
                        BytecodeManager.incBytecodes(2);
                        if (bigDecimal3 == null) {
                            final long n64 = n14;
                            final int n65 = precision;
                            BytecodeManager.incBytecodes(3);
                            final BigInteger bigMultiplyPowerTen3 = bigMultiplyPowerTen(n64, n65);
                            BytecodeManager.incBytecodes(1);
                            final BigInteger bigInteger3 = bigMultiplyPowerTen3;
                            final int n66 = checkScaleNonZero12;
                            final int n67 = oldMode;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final int checkScaleNonZero15 = checkScaleNonZero(n5);
                            BytecodeManager.incBytecodes(1);
                            bigDecimal = divideAndRound(bigInteger3, n3, n66, n67, checkScaleNonZero15);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final long n68 = longMultiplyPowerTen4;
                        final int n69 = checkScaleNonZero12;
                        final int n70 = oldMode;
                        BytecodeManager.incBytecodes(6);
                        final int checkScaleNonZero16 = checkScaleNonZero(n5);
                        BytecodeManager.incBytecodes(1);
                        bigDecimal = divideAndRound(n68, n3, n69, n70, checkScaleNonZero16);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final BigDecimal bigDecimal4 = bigDecimal;
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(bigDecimal4, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final long n, final int n2, final long n3, int n4, final long n5, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int n6 = n4;
            BytecodeManager.incBytecodes(3);
            if (n2 <= n6) {
                final int n7 = n4;
                final int n8 = 18;
                BytecodeManager.incBytecodes(3);
                if (n7 < n8) {
                    final int n9 = precision;
                    final int n10 = 18;
                    BytecodeManager.incBytecodes(3);
                    if (n9 < n10) {
                        final int n11 = n4;
                        BytecodeManager.incBytecodes(7);
                        final BigDecimal divideSmallFastPath = divideSmallFastPath(n, n2, n3, n11, n5, mathContext);
                        BytecodeManager.incBytecodes(1);
                        return divideSmallFastPath;
                    }
                }
            }
            final int n12 = n4;
            BytecodeManager.incBytecodes(5);
            final int compareMagnitudeNormalized = compareMagnitudeNormalized(n, n2, n3, n12);
            BytecodeManager.incBytecodes(1);
            if (compareMagnitudeNormalized > 0) {
                --n4;
                BytecodeManager.incBytecodes(1);
            }
            final int oldMode = mathContext.roundingMode.oldMode;
            BytecodeManager.incBytecodes(4);
            final long n13 = n5 + n4 - n2 + precision;
            BytecodeManager.incBytecodes(11);
            final int checkScaleNonZero = checkScaleNonZero(n13);
            BytecodeManager.incBytecodes(1);
            final long n14 = precision + (long)n4 - n2;
            BytecodeManager.incBytecodes(9);
            final int checkScaleNonZero2 = checkScaleNonZero(n14);
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal;
            if (checkScaleNonZero2 > 0) {
                final long n15 = precision + (long)n4 - n2;
                BytecodeManager.incBytecodes(9);
                final int checkScaleNonZero3 = checkScaleNonZero(n15);
                BytecodeManager.incBytecodes(1);
                final int n16 = checkScaleNonZero3;
                BytecodeManager.incBytecodes(3);
                final long longMultiplyPowerTen;
                final long n17 = lcmp(longMultiplyPowerTen = longMultiplyPowerTen(n, n16), Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n17 == 0) {
                    final int n18 = checkScaleNonZero3;
                    BytecodeManager.incBytecodes(3);
                    final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(n, n18);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger bigInteger = bigMultiplyPowerTen;
                    final int n19 = checkScaleNonZero;
                    final int n20 = oldMode;
                    BytecodeManager.incBytecodes(6);
                    final int checkScaleNonZero4 = checkScaleNonZero(n5);
                    BytecodeManager.incBytecodes(1);
                    bigDecimal = divideAndRound(bigInteger, n3, n19, n20, checkScaleNonZero4);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final long n21 = longMultiplyPowerTen;
                    final int n22 = checkScaleNonZero;
                    final int n23 = oldMode;
                    BytecodeManager.incBytecodes(6);
                    final int checkScaleNonZero5 = checkScaleNonZero(n5);
                    BytecodeManager.incBytecodes(1);
                    bigDecimal = divideAndRound(n21, n3, n22, n23, checkScaleNonZero5);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                final long n24 = n2 - (long)precision;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero6 = checkScaleNonZero(n24);
                BytecodeManager.incBytecodes(1);
                final int n25 = checkScaleNonZero6;
                final int n26 = n4;
                BytecodeManager.incBytecodes(3);
                if (n25 == n26) {
                    final int n27 = checkScaleNonZero;
                    final int n28 = oldMode;
                    BytecodeManager.incBytecodes(6);
                    final int checkScaleNonZero7 = checkScaleNonZero(n5);
                    BytecodeManager.incBytecodes(1);
                    bigDecimal = divideAndRound(n, n3, n27, n28, checkScaleNonZero7);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n29 = checkScaleNonZero6 - (long)n4;
                    BytecodeManager.incBytecodes(6);
                    final int checkScaleNonZero8 = checkScaleNonZero(n29);
                    BytecodeManager.incBytecodes(1);
                    final int n30 = checkScaleNonZero8;
                    BytecodeManager.incBytecodes(3);
                    final long longMultiplyPowerTen2;
                    final long n31 = lcmp(longMultiplyPowerTen2 = longMultiplyPowerTen(n3, n30), Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n31 == 0) {
                        final int n32 = checkScaleNonZero8;
                        BytecodeManager.incBytecodes(3);
                        final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(n3, n32);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final BigInteger value = BigInteger.valueOf(n);
                        final BigInteger bigInteger2 = bigMultiplyPowerTen2;
                        final int n33 = checkScaleNonZero;
                        final int n34 = oldMode;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int checkScaleNonZero9 = checkScaleNonZero(n5);
                        BytecodeManager.incBytecodes(1);
                        bigDecimal = divideAndRound(value, bigInteger2, n33, n34, checkScaleNonZero9);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final long n35 = longMultiplyPowerTen2;
                        final int n36 = checkScaleNonZero;
                        final int n37 = oldMode;
                        BytecodeManager.incBytecodes(6);
                        final int checkScaleNonZero10 = checkScaleNonZero(n5);
                        BytecodeManager.incBytecodes(1);
                        bigDecimal = divideAndRound(n, n35, n36, n37, checkScaleNonZero10);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final BigDecimal bigDecimal2 = bigDecimal;
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(bigDecimal2, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final BigInteger bigInteger, final int n, final long n2, int n3, final long n4, final MathContext mathContext) {
        try {
            final int n5 = n3;
            BytecodeManager.incBytecodes(5);
            final int n6 = -compareMagnitudeNormalized(n2, n5, bigInteger, n);
            BytecodeManager.incBytecodes(2);
            if (n6 > 0) {
                --n3;
                BytecodeManager.incBytecodes(1);
            }
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int oldMode = mathContext.roundingMode.oldMode;
            BytecodeManager.incBytecodes(4);
            final long n7 = n4 + n3 - n + precision;
            BytecodeManager.incBytecodes(11);
            final int checkScaleNonZero = checkScaleNonZero(n7);
            BytecodeManager.incBytecodes(1);
            final long n8 = precision + (long)n3 - n;
            BytecodeManager.incBytecodes(9);
            final int checkScaleNonZero2 = checkScaleNonZero(n8);
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal;
            if (checkScaleNonZero2 > 0) {
                final long n9 = precision + (long)n3 - n;
                BytecodeManager.incBytecodes(9);
                final int checkScaleNonZero3 = checkScaleNonZero(n9);
                BytecodeManager.incBytecodes(1);
                final int n10 = checkScaleNonZero3;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(bigInteger, n10);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger2 = bigMultiplyPowerTen;
                final int n11 = checkScaleNonZero;
                final int n12 = oldMode;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero4 = checkScaleNonZero(n4);
                BytecodeManager.incBytecodes(1);
                bigDecimal = divideAndRound(bigInteger2, n2, n11, n12, checkScaleNonZero4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final long n13 = n - (long)precision;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero5 = checkScaleNonZero(n13);
                BytecodeManager.incBytecodes(1);
                final int n14 = checkScaleNonZero5;
                final int n15 = n3;
                BytecodeManager.incBytecodes(3);
                if (n14 == n15) {
                    final int n16 = checkScaleNonZero;
                    final int n17 = oldMode;
                    BytecodeManager.incBytecodes(6);
                    final int checkScaleNonZero6 = checkScaleNonZero(n4);
                    BytecodeManager.incBytecodes(1);
                    bigDecimal = divideAndRound(bigInteger, n2, n16, n17, checkScaleNonZero6);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n18 = checkScaleNonZero5 - (long)n3;
                    BytecodeManager.incBytecodes(6);
                    final int checkScaleNonZero7 = checkScaleNonZero(n18);
                    BytecodeManager.incBytecodes(1);
                    final int n19 = checkScaleNonZero7;
                    BytecodeManager.incBytecodes(3);
                    final long longMultiplyPowerTen;
                    final long n20 = lcmp(longMultiplyPowerTen = longMultiplyPowerTen(n2, n19), Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n20 == 0) {
                        final int n21 = checkScaleNonZero7;
                        BytecodeManager.incBytecodes(3);
                        final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(n2, n21);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger bigInteger3 = bigMultiplyPowerTen2;
                        final int n22 = checkScaleNonZero;
                        final int n23 = oldMode;
                        BytecodeManager.incBytecodes(6);
                        final int checkScaleNonZero8 = checkScaleNonZero(n4);
                        BytecodeManager.incBytecodes(1);
                        bigDecimal = divideAndRound(bigInteger, bigInteger3, n22, n23, checkScaleNonZero8);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final long n24 = longMultiplyPowerTen;
                        final int n25 = checkScaleNonZero;
                        final int n26 = oldMode;
                        BytecodeManager.incBytecodes(6);
                        final int checkScaleNonZero9 = checkScaleNonZero(n4);
                        BytecodeManager.incBytecodes(1);
                        bigDecimal = divideAndRound(bigInteger, n24, n25, n26, checkScaleNonZero9);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final BigDecimal bigDecimal2 = bigDecimal;
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(bigDecimal2, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final long n, final int n2, final BigInteger bigInteger, int n3, final long n4, final MathContext mathContext) {
        try {
            final int n5 = n3;
            BytecodeManager.incBytecodes(5);
            final int compareMagnitudeNormalized = compareMagnitudeNormalized(n, n2, bigInteger, n5);
            BytecodeManager.incBytecodes(1);
            if (compareMagnitudeNormalized > 0) {
                --n3;
                BytecodeManager.incBytecodes(1);
            }
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int oldMode = mathContext.roundingMode.oldMode;
            BytecodeManager.incBytecodes(4);
            final long n6 = n4 + n3 - n2 + precision;
            BytecodeManager.incBytecodes(11);
            final int checkScaleNonZero = checkScaleNonZero(n6);
            BytecodeManager.incBytecodes(1);
            final long n7 = precision + (long)n3 - n2;
            BytecodeManager.incBytecodes(9);
            final int checkScaleNonZero2 = checkScaleNonZero(n7);
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal;
            if (checkScaleNonZero2 > 0) {
                final long n8 = precision + (long)n3 - n2;
                BytecodeManager.incBytecodes(9);
                final int checkScaleNonZero3 = checkScaleNonZero(n8);
                BytecodeManager.incBytecodes(1);
                final int n9 = checkScaleNonZero3;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(n, n9);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger2 = bigMultiplyPowerTen;
                final int n10 = checkScaleNonZero;
                final int n11 = oldMode;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero4 = checkScaleNonZero(n4);
                BytecodeManager.incBytecodes(1);
                bigDecimal = divideAndRound(bigInteger2, bigInteger, n10, n11, checkScaleNonZero4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final long n12 = n2 - (long)precision;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero5 = checkScaleNonZero(n12);
                BytecodeManager.incBytecodes(1);
                final long n13 = checkScaleNonZero5 - (long)n3;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero6 = checkScaleNonZero(n13);
                BytecodeManager.incBytecodes(1);
                final int n14 = checkScaleNonZero6;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(bigInteger, n14);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final BigInteger value = BigInteger.valueOf(n);
                final BigInteger bigInteger3 = bigMultiplyPowerTen2;
                final int n15 = checkScaleNonZero;
                final int n16 = oldMode;
                BytecodeManager.incBytecodes(5);
                final int checkScaleNonZero7 = checkScaleNonZero(n4);
                BytecodeManager.incBytecodes(1);
                bigDecimal = divideAndRound(value, bigInteger3, n15, n16, checkScaleNonZero7);
                BytecodeManager.incBytecodes(1);
            }
            final BigDecimal bigDecimal2 = bigDecimal;
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(bigDecimal2, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final BigInteger bigInteger, final int n, final BigInteger bigInteger2, int n2, final long n3, final MathContext mathContext) {
        try {
            final int n4 = n2;
            BytecodeManager.incBytecodes(5);
            final int compareMagnitudeNormalized = compareMagnitudeNormalized(bigInteger, n, bigInteger2, n4);
            BytecodeManager.incBytecodes(1);
            if (compareMagnitudeNormalized > 0) {
                --n2;
                BytecodeManager.incBytecodes(1);
            }
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            final int oldMode = mathContext.roundingMode.oldMode;
            BytecodeManager.incBytecodes(4);
            final long n5 = n3 + n2 - n + precision;
            BytecodeManager.incBytecodes(11);
            final int checkScaleNonZero = checkScaleNonZero(n5);
            BytecodeManager.incBytecodes(1);
            final long n6 = precision + (long)n2 - n;
            BytecodeManager.incBytecodes(9);
            final int checkScaleNonZero2 = checkScaleNonZero(n6);
            BytecodeManager.incBytecodes(1);
            BigDecimal bigDecimal;
            if (checkScaleNonZero2 > 0) {
                final long n7 = precision + (long)n2 - n;
                BytecodeManager.incBytecodes(9);
                final int checkScaleNonZero3 = checkScaleNonZero(n7);
                BytecodeManager.incBytecodes(1);
                final int n8 = checkScaleNonZero3;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(bigInteger, n8);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger3 = bigMultiplyPowerTen;
                final int n9 = checkScaleNonZero;
                final int n10 = oldMode;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero4 = checkScaleNonZero(n3);
                BytecodeManager.incBytecodes(1);
                bigDecimal = divideAndRound(bigInteger3, bigInteger2, n9, n10, checkScaleNonZero4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final long n11 = n - (long)precision;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero5 = checkScaleNonZero(n11);
                BytecodeManager.incBytecodes(1);
                final long n12 = checkScaleNonZero5 - (long)n2;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero6 = checkScaleNonZero(n12);
                BytecodeManager.incBytecodes(1);
                final int n13 = checkScaleNonZero6;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(bigInteger2, n13);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger4 = bigMultiplyPowerTen2;
                final int n14 = checkScaleNonZero;
                final int n15 = oldMode;
                BytecodeManager.incBytecodes(6);
                final int checkScaleNonZero7 = checkScaleNonZero(n3);
                BytecodeManager.incBytecodes(1);
                bigDecimal = divideAndRound(bigInteger, bigInteger4, n14, n15, checkScaleNonZero7);
                BytecodeManager.incBytecodes(1);
            }
            final BigDecimal bigDecimal2 = bigDecimal;
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(bigDecimal2, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal multiplyDivideAndRound(long abs, long abs2, long abs3, final int n, final int n2, final int n3) {
        try {
            final long i = abs;
            BytecodeManager.incBytecodes(2);
            final int signum = Long.signum(i);
            final long j = abs2;
            BytecodeManager.incBytecodes(2);
            final int n4 = signum * Long.signum(j);
            final long k = abs3;
            BytecodeManager.incBytecodes(3);
            final int n5 = n4 * Long.signum(k);
            BytecodeManager.incBytecodes(2);
            final long a = abs;
            BytecodeManager.incBytecodes(2);
            abs = Math.abs(a);
            BytecodeManager.incBytecodes(1);
            final long a2 = abs2;
            BytecodeManager.incBytecodes(2);
            abs2 = Math.abs(a2);
            BytecodeManager.incBytecodes(1);
            final long a3 = abs3;
            BytecodeManager.incBytecodes(2);
            abs3 = Math.abs(a3);
            BytecodeManager.incBytecodes(1);
            final long n6 = abs >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n7 = abs & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n8 = abs2 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n9 = abs2 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n10 = n7 * n9;
            BytecodeManager.incBytecodes(4);
            final long n11 = n10 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n12 = n10 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n13 = n6 * n9 + n12;
            BytecodeManager.incBytecodes(6);
            final long n14 = n13 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n15 = n13 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n16 = n7 * n8 + n14;
            BytecodeManager.incBytecodes(6);
            final long n17 = n16 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n18 = n15 + (n16 >>> 32);
            BytecodeManager.incBytecodes(6);
            final long n19 = n18 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n20 = n18 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n21 = n6 * n8 + n20;
            BytecodeManager.incBytecodes(6);
            final long n22 = n21 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n23 = (n21 >>> 32) + n19 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(8);
            final long n24 = n23;
            final long n25 = n22;
            BytecodeManager.incBytecodes(3);
            final long make64 = make64(n24, n25);
            BytecodeManager.incBytecodes(1);
            final long n26 = n17;
            final long n27 = n11;
            BytecodeManager.incBytecodes(3);
            final long make65 = make64(n26, n27);
            BytecodeManager.incBytecodes(1);
            final long n28 = make64;
            final long n29 = make65;
            final long n30 = abs3;
            final int n31 = n5;
            BytecodeManager.incBytecodes(8);
            final BigDecimal divideAndRound128 = divideAndRound128(n28, n29, n30, n31, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return divideAndRound128;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divideAndRound128(final long n, final long n2, long n3, final int n4, final int n5, final int n6, final int n7) {
        try {
            final long n8 = lcmp(n, n3);
            BytecodeManager.incBytecodes(4);
            if (n8 >= 0) {
                final BigDecimal bigDecimal = null;
                BytecodeManager.incBytecodes(2);
                return bigDecimal;
            }
            final long i = n3;
            BytecodeManager.incBytecodes(2);
            final int numberOfLeadingZeros = Long.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(1);
            n3 <<= numberOfLeadingZeros;
            BytecodeManager.incBytecodes(4);
            final long n9 = n3 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n10 = n3 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n11 = n2 << numberOfLeadingZeros;
            BytecodeManager.incBytecodes(4);
            final long n12 = n11 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n13 = n11 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n14 = n << numberOfLeadingZeros | n2 >>> 64 - numberOfLeadingZeros;
            BytecodeManager.incBytecodes(10);
            final long n15 = n14 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n16 = lcmp(n9, 1L);
            BytecodeManager.incBytecodes(4);
            long n17;
            long n18;
            if (n16 == 0) {
                n17 = n14;
                BytecodeManager.incBytecodes(2);
                n18 = 0L;
                BytecodeManager.incBytecodes(3);
            }
            else {
                final long n19 = lcmp(n14, 0L);
                BytecodeManager.incBytecodes(4);
                if (n19 >= 0) {
                    n17 = n14 / n9;
                    BytecodeManager.incBytecodes(4);
                    n18 = n14 - n17 * n9;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    final long n20 = n14;
                    final long n21 = n9;
                    BytecodeManager.incBytecodes(3);
                    final long[] divRemNegativeLong = divRemNegativeLong(n20, n21);
                    BytecodeManager.incBytecodes(1);
                    n17 = divRemNegativeLong[1];
                    BytecodeManager.incBytecodes(4);
                    n18 = divRemNegativeLong[0];
                    BytecodeManager.incBytecodes(4);
                }
            }
            while (true) {
                long n22;
                do {
                    final long n23 = lcmp(n17, 4294967296L);
                    BytecodeManager.incBytecodes(4);
                    if (n23 < 0) {
                        final long n24 = n17 * n10;
                        final long n25 = n18;
                        final long n26 = n12;
                        BytecodeManager.incBytecodes(6);
                        final long make64 = make64(n25, n26);
                        BytecodeManager.incBytecodes(1);
                        final boolean unsignedLongCompare = unsignedLongCompare(n24, make64);
                        BytecodeManager.incBytecodes(1);
                        if (!unsignedLongCompare) {
                            final long n27 = n15;
                            final long n28 = n12;
                            final long n29 = n9;
                            final long n30 = n10;
                            final long n31 = n17;
                            BytecodeManager.incBytecodes(6);
                            final long mulsub = mulsub(n27, n28, n29, n30, n31);
                            BytecodeManager.incBytecodes(1);
                            final long n32 = mulsub & 0xFFFFFFFFL;
                            BytecodeManager.incBytecodes(4);
                            final long n33 = lcmp(n9, 1L);
                            BytecodeManager.incBytecodes(4);
                            long n34;
                            long n35;
                            if (n33 == 0) {
                                n34 = mulsub;
                                BytecodeManager.incBytecodes(2);
                                n35 = 0L;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final long n36 = lcmp(mulsub, 0L);
                                BytecodeManager.incBytecodes(4);
                                if (n36 >= 0) {
                                    n34 = mulsub / n9;
                                    BytecodeManager.incBytecodes(4);
                                    n35 = mulsub - n34 * n9;
                                    BytecodeManager.incBytecodes(7);
                                }
                                else {
                                    final long n37 = mulsub;
                                    final long n38 = n9;
                                    BytecodeManager.incBytecodes(3);
                                    final long[] divRemNegativeLong2 = divRemNegativeLong(n37, n38);
                                    BytecodeManager.incBytecodes(1);
                                    n34 = divRemNegativeLong2[1];
                                    BytecodeManager.incBytecodes(4);
                                    n35 = divRemNegativeLong2[0];
                                    BytecodeManager.incBytecodes(4);
                                }
                            }
                            while (true) {
                                long n39;
                                do {
                                    final long n40 = lcmp(n34, 4294967296L);
                                    BytecodeManager.incBytecodes(4);
                                    if (n40 < 0) {
                                        final long n41 = n34 * n10;
                                        final long n42 = n35;
                                        final long n43 = n13;
                                        BytecodeManager.incBytecodes(6);
                                        final long make65 = make64(n42, n43);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean unsignedLongCompare2 = unsignedLongCompare(n41, make65);
                                        BytecodeManager.incBytecodes(1);
                                        if (!unsignedLongCompare2) {
                                            final int n44 = (int)n17;
                                            BytecodeManager.incBytecodes(3);
                                            if (n44 < 0) {
                                                final int[] array = { (int)n17, (int)n34 };
                                                BytecodeManager.incBytecodes(14);
                                                final MutableBigInteger mutableBigInteger = new MutableBigInteger(array);
                                                BytecodeManager.incBytecodes(1);
                                                final int n45 = 1;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 == n45) {
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n5 == n7) {
                                                        final MutableBigInteger mutableBigInteger2 = mutableBigInteger;
                                                        BytecodeManager.incBytecodes(4);
                                                        final BigDecimal bigDecimal2 = mutableBigInteger2.toBigDecimal(n4, n5);
                                                        BytecodeManager.incBytecodes(1);
                                                        return bigDecimal2;
                                                    }
                                                }
                                                final long n46 = n32;
                                                final long n47 = n13;
                                                final long n48 = n9;
                                                final long n49 = n10;
                                                final long n50 = n34;
                                                BytecodeManager.incBytecodes(6);
                                                final long n51 = mulsub(n46, n47, n48, n49, n50) >>> numberOfLeadingZeros;
                                                BytecodeManager.incBytecodes(3);
                                                final long n52 = lcmp(n51, 0L);
                                                BytecodeManager.incBytecodes(4);
                                                if (n52 != 0) {
                                                    final long n53 = n3 >>> numberOfLeadingZeros;
                                                    final MutableBigInteger mutableBigInteger3 = mutableBigInteger;
                                                    final long n54 = n51;
                                                    BytecodeManager.incBytecodes(8);
                                                    final boolean needIncrement = needIncrement(n53, n6, n4, mutableBigInteger3, n54);
                                                    BytecodeManager.incBytecodes(1);
                                                    if (needIncrement) {
                                                        final MutableBigInteger mutableBigInteger4 = mutableBigInteger;
                                                        final MutableBigInteger one = MutableBigInteger.ONE;
                                                        BytecodeManager.incBytecodes(3);
                                                        mutableBigInteger4.add(one);
                                                    }
                                                    final MutableBigInteger mutableBigInteger5 = mutableBigInteger;
                                                    BytecodeManager.incBytecodes(4);
                                                    final BigDecimal bigDecimal3 = mutableBigInteger5.toBigDecimal(n4, n5);
                                                    BytecodeManager.incBytecodes(1);
                                                    return bigDecimal3;
                                                }
                                                BytecodeManager.incBytecodes(3);
                                                if (n7 != n5) {
                                                    final MutableBigInteger mutableBigInteger6 = mutableBigInteger;
                                                    BytecodeManager.incBytecodes(3);
                                                    final BigInteger bigInteger = mutableBigInteger6.toBigInteger(n4);
                                                    BytecodeManager.incBytecodes(1);
                                                    final BigInteger bigInteger2 = bigInteger;
                                                    final long n55 = n7;
                                                    BytecodeManager.incBytecodes(5);
                                                    final BigDecimal andStripZerosToMatchScale = createAndStripZerosToMatchScale(bigInteger2, n5, n55);
                                                    BytecodeManager.incBytecodes(1);
                                                    return andStripZerosToMatchScale;
                                                }
                                                final MutableBigInteger mutableBigInteger7 = mutableBigInteger;
                                                BytecodeManager.incBytecodes(4);
                                                final BigDecimal bigDecimal4 = mutableBigInteger7.toBigDecimal(n4, n5);
                                                BytecodeManager.incBytecodes(1);
                                                return bigDecimal4;
                                            }
                                            else {
                                                final long n56 = n17;
                                                final long n57 = n34;
                                                BytecodeManager.incBytecodes(3);
                                                final long make66 = make64(n56, n57);
                                                BytecodeManager.incBytecodes(1);
                                                final long n58 = make66 * n4;
                                                BytecodeManager.incBytecodes(5);
                                                final int n59 = 1;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 == n59) {
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n5 == n7) {
                                                        final long n60 = n58;
                                                        BytecodeManager.incBytecodes(3);
                                                        final BigDecimal value = valueOf(n60, n5);
                                                        BytecodeManager.incBytecodes(1);
                                                        return value;
                                                    }
                                                }
                                                final long n61 = n32;
                                                final long n62 = n13;
                                                final long n63 = n9;
                                                final long n64 = n10;
                                                final long n65 = n34;
                                                BytecodeManager.incBytecodes(6);
                                                final long n66 = mulsub(n61, n62, n63, n64, n65) >>> numberOfLeadingZeros;
                                                BytecodeManager.incBytecodes(3);
                                                final long n67 = lcmp(n66, 0L);
                                                BytecodeManager.incBytecodes(4);
                                                if (n67 != 0) {
                                                    final long n68 = n3 >>> numberOfLeadingZeros;
                                                    final long n69 = n58;
                                                    final long n70 = n66;
                                                    BytecodeManager.incBytecodes(8);
                                                    final boolean needIncrement2 = needIncrement(n68, n6, n4, n69, n70);
                                                    BytecodeManager.incBytecodes(1);
                                                    final boolean b = needIncrement2;
                                                    BytecodeManager.incBytecodes(2);
                                                    long n71;
                                                    if (b) {
                                                        n71 = n58 + n4;
                                                        BytecodeManager.incBytecodes(5);
                                                    }
                                                    else {
                                                        n71 = n58;
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                    BytecodeManager.incBytecodes(2);
                                                    final BigDecimal value2 = valueOf(n71, n5);
                                                    BytecodeManager.incBytecodes(1);
                                                    return value2;
                                                }
                                                BytecodeManager.incBytecodes(3);
                                                if (n7 != n5) {
                                                    final long n72 = n58;
                                                    final long n73 = n7;
                                                    BytecodeManager.incBytecodes(5);
                                                    final BigDecimal andStripZerosToMatchScale2 = createAndStripZerosToMatchScale(n72, n5, n73);
                                                    BytecodeManager.incBytecodes(1);
                                                    return andStripZerosToMatchScale2;
                                                }
                                                final long n74 = n58;
                                                BytecodeManager.incBytecodes(3);
                                                final BigDecimal value3 = valueOf(n74, n5);
                                                BytecodeManager.incBytecodes(1);
                                                return value3;
                                            }
                                        }
                                    }
                                    --n34;
                                    BytecodeManager.incBytecodes(4);
                                    n35 += n9;
                                    BytecodeManager.incBytecodes(4);
                                    n39 = lcmp(n35, 4294967296L);
                                    BytecodeManager.incBytecodes(4);
                                } while (n39 < 0);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                    }
                    --n17;
                    BytecodeManager.incBytecodes(4);
                    n18 += n9;
                    BytecodeManager.incBytecodes(4);
                    n22 = lcmp(n18, 4294967296L);
                    BytecodeManager.incBytecodes(4);
                } while (n22 < 0);
                BytecodeManager.incBytecodes(1);
                continue;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal roundedTenPower(final int n, final int n2, final int n3, final int n4) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n3 <= n4) {
                BytecodeManager.incBytecodes(4);
                final BigDecimal scaledTenPow = scaledTenPow(n2, n, n3);
                BytecodeManager.incBytecodes(1);
                return scaledTenPow;
            }
            final int n5 = n3 - n4;
            BytecodeManager.incBytecodes(4);
            final int n6 = n5;
            BytecodeManager.incBytecodes(3);
            if (n6 < n2) {
                final int n7 = n2 - n5;
                BytecodeManager.incBytecodes(6);
                final BigDecimal scaledTenPow2 = scaledTenPow(n7, n, n4);
                BytecodeManager.incBytecodes(1);
                return scaledTenPow2;
            }
            final long n8 = n;
            final int n9 = n3 - n2;
            BytecodeManager.incBytecodes(6);
            final BigDecimal value = valueOf(n8, n9);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static BigDecimal scaledTenPow(final int n, final int n2, final int n3) {
        try {
            final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(4);
            if (n < length) {
                final long n4 = n2 * BigDecimal.LONG_TEN_POWERS_TABLE[n];
                BytecodeManager.incBytecodes(8);
                final BigDecimal value = valueOf(n4, n3);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            BytecodeManager.incBytecodes(2);
            BigInteger bigInteger = bigTenToThe(n);
            BytecodeManager.incBytecodes(1);
            final int n5 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n5) {
                final BigInteger bigInteger2 = bigInteger;
                BytecodeManager.incBytecodes(2);
                bigInteger = bigInteger2.negate();
                BytecodeManager.incBytecodes(1);
            }
            final BigInteger bigInteger3 = bigInteger;
            final long n6 = Long.MIN_VALUE;
            final int n7 = n + 1;
            BytecodeManager.incBytecodes(9);
            final BigDecimal bigDecimal = new BigDecimal(bigInteger3, n6, n3, n7);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long[] divRemNegativeLong(final long lng, final long n) {
        try {
            final boolean $assertionsDisabled = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final long n2 = lcmp(lng, 0L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Non-negative numerator ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(lng);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final AssertionError assertionError = new AssertionError((Object)string);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final boolean $assertionsDisabled2 = BigDecimal.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled2) {
                final long n3 = lcmp(n, 1L);
                BytecodeManager.incBytecodes(4);
                if (n3 == 0) {
                    final String detailMessage = "Unity denominator";
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError2 = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            long n4 = (lng >>> 1) / (n >>> 1);
            BytecodeManager.incBytecodes(8);
            long n5 = lng - n4 * n;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final long n6 = lcmp(n5, 0L);
                BytecodeManager.incBytecodes(4);
                if (n6 >= 0) {
                    break;
                }
                n5 += n;
                BytecodeManager.incBytecodes(4);
                --n4;
                BytecodeManager.incBytecodes(5);
            }
            while (true) {
                final long n7 = lcmp(n5, n);
                BytecodeManager.incBytecodes(4);
                if (n7 < 0) {
                    break;
                }
                n5 -= n;
                BytecodeManager.incBytecodes(4);
                ++n4;
                BytecodeManager.incBytecodes(5);
            }
            final long[] array = { n5, n4 };
            BytecodeManager.incBytecodes(10);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long make64(final long n, final long n2) {
        try {
            final long n3 = n << 32 | n2;
            BytecodeManager.incBytecodes(6);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long mulsub(final long n, final long n2, final long n3, final long n4, final long n5) {
        try {
            final long n6 = n2 - n5 * n4;
            BytecodeManager.incBytecodes(6);
            final long n7 = n + (n6 >>> 32) - n5 * n3;
            final long n8 = n6 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(13);
            final long make64 = make64(n7, n8);
            BytecodeManager.incBytecodes(1);
            return make64;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean unsignedLongCompare(final long n, final long n2) {
        try {
            final long n3 = lcmp(n + Long.MIN_VALUE, n2 + Long.MIN_VALUE);
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n3 > 0) {
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
    
    private static boolean unsignedLongCompareEq(final long n, final long n2) {
        try {
            final long n3 = lcmp(n + Long.MIN_VALUE, n2 + Long.MIN_VALUE);
            BytecodeManager.incBytecodes(8);
            boolean b;
            if (n3 >= 0) {
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
    
    private static int compareMagnitudeNormalized(long longMultiplyPowerTen, final int n, long longMultiplyPowerTen2, final int n2) {
        try {
            final int n3 = n - n2;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                final int n5 = n3;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    final long n6 = longMultiplyPowerTen;
                    final int n7 = -n3;
                    BytecodeManager.incBytecodes(4);
                    longMultiplyPowerTen = longMultiplyPowerTen(n6, n7);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long n8 = longMultiplyPowerTen2;
                    final int n9 = n3;
                    BytecodeManager.incBytecodes(3);
                    longMultiplyPowerTen2 = longMultiplyPowerTen(n8, n9);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final long n10 = lcmp(longMultiplyPowerTen, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n10 != 0) {
                final long n11 = lcmp(longMultiplyPowerTen2, Long.MIN_VALUE);
                BytecodeManager.incBytecodes(4);
                int longCompareMagnitude;
                if (n11 != 0) {
                    final long n12 = longMultiplyPowerTen;
                    final long n13 = longMultiplyPowerTen2;
                    BytecodeManager.incBytecodes(3);
                    longCompareMagnitude = longCompareMagnitude(n12, n13);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    longCompareMagnitude = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return longCompareMagnitude;
            }
            final int n14 = 1;
            BytecodeManager.incBytecodes(2);
            return n14;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int compareMagnitudeNormalized(final long n, final int n2, final BigInteger bigInteger, final int n3) {
        try {
            final long n4 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n4 == 0) {
                final int n5 = -1;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            final int n6 = n2 - n3;
            BytecodeManager.incBytecodes(4);
            final int n7 = n6;
            BytecodeManager.incBytecodes(2);
            if (n7 < 0) {
                final int n8 = -n6;
                BytecodeManager.incBytecodes(4);
                final long n9 = lcmp(longMultiplyPowerTen(n, n8), Long.MIN_VALUE);
                BytecodeManager.incBytecodes(3);
                if (n9 == 0) {
                    final int n10 = -n6;
                    BytecodeManager.incBytecodes(4);
                    final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(n, n10);
                    BytecodeManager.incBytecodes(2);
                    final int compareMagnitude = bigMultiplyPowerTen.compareMagnitude(bigInteger);
                    BytecodeManager.incBytecodes(1);
                    return compareMagnitude;
                }
            }
            final int n11 = -1;
            BytecodeManager.incBytecodes(2);
            return n11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int compareMagnitudeNormalized(final BigInteger bigInteger, final int n, final BigInteger bigInteger2, final int n2) {
        try {
            final int n3 = n - n2;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 < 0) {
                final int n5 = -n3;
                BytecodeManager.incBytecodes(4);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(bigInteger, n5);
                BytecodeManager.incBytecodes(2);
                final int compareMagnitude = bigMultiplyPowerTen.compareMagnitude(bigInteger2);
                BytecodeManager.incBytecodes(1);
                return compareMagnitude;
            }
            final int n6 = n3;
            BytecodeManager.incBytecodes(4);
            final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(bigInteger2, n6);
            BytecodeManager.incBytecodes(1);
            final int compareMagnitude2 = bigInteger.compareMagnitude(bigMultiplyPowerTen2);
            BytecodeManager.incBytecodes(1);
            return compareMagnitude2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long multiply(final long a, final long a2) {
        try {
            final long n = a * a2;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final long abs = Math.abs(a);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final long abs2 = Math.abs(a2);
            BytecodeManager.incBytecodes(1);
            final long n2 = lcmp((abs | abs2) >>> 31, 0L);
            BytecodeManager.incBytecodes(8);
            if (n2 != 0) {
                final long n3 = lcmp(a2, 0L);
                BytecodeManager.incBytecodes(4);
                if (n3 != 0) {
                    final long n4 = lcmp(n / a2, a);
                    BytecodeManager.incBytecodes(6);
                    if (n4 != 0) {
                        final long n5 = Long.MIN_VALUE;
                        BytecodeManager.incBytecodes(2);
                        return n5;
                    }
                }
            }
            final long n6 = n;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal multiply(final long n, final long n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(3);
            final long multiply = multiply(n, n2);
            BytecodeManager.incBytecodes(1);
            final long n4 = lcmp(multiply, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n4 != 0) {
                final long n5 = multiply;
                BytecodeManager.incBytecodes(3);
                final BigDecimal value = valueOf(n5, n3);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            BytecodeManager.incBytecodes(4);
            final BigInteger value2 = BigInteger.valueOf(n);
            BytecodeManager.incBytecodes(2);
            final BigInteger multiply2 = value2.multiply(n2);
            final long n6 = Long.MIN_VALUE;
            final int n7 = 0;
            BytecodeManager.incBytecodes(4);
            final BigDecimal bigDecimal = new BigDecimal(multiply2, n6, n3, n7);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal multiply(final long n, final BigInteger bigInteger, final int n2) {
        try {
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigDecimal zeroValue = zeroValueOf(n2);
                BytecodeManager.incBytecodes(1);
                return zeroValue;
            }
            BytecodeManager.incBytecodes(5);
            final BigInteger multiply = bigInteger.multiply(n);
            final long n4 = Long.MIN_VALUE;
            final int n5 = 0;
            BytecodeManager.incBytecodes(4);
            final BigDecimal bigDecimal = new BigDecimal(multiply, n4, n2, n5);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal multiply(final BigInteger bigInteger, final BigInteger bigInteger2, final int n) {
        try {
            BytecodeManager.incBytecodes(5);
            final BigInteger multiply = bigInteger.multiply(bigInteger2);
            final long n2 = Long.MIN_VALUE;
            final int n3 = 0;
            BytecodeManager.incBytecodes(4);
            final BigDecimal bigDecimal = new BigDecimal(multiply, n2, n, n3);
            BytecodeManager.incBytecodes(1);
            return bigDecimal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal multiplyAndRound(long n, long n2, final int n3, final MathContext mathContext) {
        try {
            final long n4 = n;
            final long n5 = n2;
            BytecodeManager.incBytecodes(3);
            final long multiply = multiply(n4, n5);
            BytecodeManager.incBytecodes(1);
            final long n6 = lcmp(multiply, Long.MIN_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n6 != 0) {
                final long n7 = multiply;
                BytecodeManager.incBytecodes(4);
                final BigDecimal doRound = doRound(n7, n3, mathContext);
                BytecodeManager.incBytecodes(1);
                return doRound;
            }
            int n8 = 1;
            BytecodeManager.incBytecodes(2);
            final long n9 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n9 < 0) {
                n = -n;
                BytecodeManager.incBytecodes(3);
                n8 = -1;
                BytecodeManager.incBytecodes(2);
            }
            final long n10 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            if (n10 < 0) {
                n2 = -n2;
                BytecodeManager.incBytecodes(3);
                n8 *= -1;
                BytecodeManager.incBytecodes(4);
            }
            final long n11 = n >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n12 = n & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n13 = n2 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n14 = n2 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n15 = n12 * n14;
            BytecodeManager.incBytecodes(4);
            final long n16 = n15 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n17 = n15 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n18 = n11 * n14 + n17;
            BytecodeManager.incBytecodes(6);
            final long n19 = n18 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n20 = n18 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n21 = n12 * n13 + n19;
            BytecodeManager.incBytecodes(6);
            final long n22 = n21 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n23 = n20 + (n21 >>> 32);
            BytecodeManager.incBytecodes(6);
            final long n24 = n23 >>> 32;
            BytecodeManager.incBytecodes(4);
            final long n25 = n23 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n26 = n11 * n13 + n25;
            BytecodeManager.incBytecodes(6);
            final long n27 = n26 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(4);
            final long n28 = (n26 >>> 32) + n24 & 0xFFFFFFFFL;
            BytecodeManager.incBytecodes(8);
            final long n29 = n28;
            final long n30 = n27;
            BytecodeManager.incBytecodes(3);
            final long make64 = make64(n29, n30);
            BytecodeManager.incBytecodes(1);
            final long n31 = n22;
            final long n32 = n16;
            BytecodeManager.incBytecodes(3);
            final long make65 = make64(n31, n32);
            BytecodeManager.incBytecodes(1);
            final long n33 = make64;
            final long n34 = make65;
            final int n35 = n8;
            BytecodeManager.incBytecodes(6);
            final BigDecimal doRound2 = doRound128(n33, n34, n35, n3, mathContext);
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal = doRound2;
            BytecodeManager.incBytecodes(2);
            if (bigDecimal != null) {
                final BigDecimal bigDecimal2 = doRound2;
                BytecodeManager.incBytecodes(2);
                return bigDecimal2;
            }
            final long n36 = n;
            BytecodeManager.incBytecodes(4);
            final BigInteger value = BigInteger.valueOf(n36);
            final long n37 = n2 * n8;
            BytecodeManager.incBytecodes(5);
            final BigInteger multiply2 = value.multiply(n37);
            final long n38 = Long.MIN_VALUE;
            final int n39 = 0;
            BytecodeManager.incBytecodes(4);
            final BigDecimal bigDecimal3 = new BigDecimal(multiply2, n38, n3, n39);
            BytecodeManager.incBytecodes(1);
            final BigDecimal bigDecimal4 = bigDecimal3;
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound3 = doRound(bigDecimal4, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal multiplyAndRound(final long n, final BigInteger bigInteger, final int n2, final MathContext mathContext) {
        try {
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 == 0) {
                BytecodeManager.incBytecodes(2);
                final BigDecimal zeroValue = zeroValueOf(n2);
                BytecodeManager.incBytecodes(1);
                return zeroValue;
            }
            BytecodeManager.incBytecodes(3);
            final BigInteger multiply = bigInteger.multiply(n);
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(multiply, n2, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal multiplyAndRound(final BigInteger bigInteger, final BigInteger bigInteger2, final int n, final MathContext mathContext) {
        try {
            BytecodeManager.incBytecodes(3);
            final BigInteger multiply = bigInteger.multiply(bigInteger2);
            BytecodeManager.incBytecodes(3);
            final BigDecimal doRound = doRound(multiply, n, mathContext);
            BytecodeManager.incBytecodes(1);
            return doRound;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal doRound128(final long n, final long n2, final int n3, int checkScaleNonZero, final MathContext mathContext) {
        try {
            final int precision = mathContext.precision;
            BytecodeManager.incBytecodes(3);
            BigDecimal divideAndRound128 = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final int n5;
            final int n4 = n5 = precision(n, n2) - precision;
            BytecodeManager.incBytecodes(5);
            if (n4 > 0) {
                final int n6 = n5;
                final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
                BytecodeManager.incBytecodes(4);
                if (n6 < length) {
                    final long n7 = checkScaleNonZero - (long)n5;
                    BytecodeManager.incBytecodes(6);
                    checkScaleNonZero = checkScaleNonZero(n7);
                    BytecodeManager.incBytecodes(1);
                    final long n8 = BigDecimal.LONG_TEN_POWERS_TABLE[n5];
                    final int n9 = checkScaleNonZero;
                    final int oldMode = mathContext.roundingMode.oldMode;
                    final int n10 = checkScaleNonZero;
                    BytecodeManager.incBytecodes(12);
                    divideAndRound128 = divideAndRound128(n, n2, n8, n3, n9, oldMode, n10);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final BigDecimal bigDecimal = divideAndRound128;
            BytecodeManager.incBytecodes(2);
            if (bigDecimal != null) {
                final BigDecimal bigDecimal2 = divideAndRound128;
                BytecodeManager.incBytecodes(3);
                final BigDecimal doRound = doRound(bigDecimal2, mathContext);
                BytecodeManager.incBytecodes(1);
                return doRound;
            }
            final BigDecimal bigDecimal3 = null;
            BytecodeManager.incBytecodes(2);
            return bigDecimal3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int precision(final long i, final long n) {
        try {
            final long n2 = lcmp(i, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 != 0) {
                final int n3 = 128;
                BytecodeManager.incBytecodes(3);
                final int n4 = (n3 - Long.numberOfLeadingZeros(i) + 1) * 1233 >>> 12;
                BytecodeManager.incBytecodes(8);
                final int n5 = n4 - 19;
                BytecodeManager.incBytecodes(4);
                final int n6 = n5;
                final int length = BigDecimal.LONGLONG_TEN_POWERS_TABLE.length;
                BytecodeManager.incBytecodes(4);
                int n9 = 0;
                Label_0193: {
                    if (n6 < length) {
                        final long n7 = BigDecimal.LONGLONG_TEN_POWERS_TABLE[n5][0];
                        final long n8 = BigDecimal.LONGLONG_TEN_POWERS_TABLE[n5][1];
                        BytecodeManager.incBytecodes(13);
                        final boolean longLongCompareMagnitude = longLongCompareMagnitude(i, n, n7, n8);
                        BytecodeManager.incBytecodes(1);
                        if (!longLongCompareMagnitude) {
                            n9 = n4 + 1;
                            BytecodeManager.incBytecodes(3);
                            break Label_0193;
                        }
                    }
                    n9 = n4;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return n9;
            }
            final long n10 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n10 >= 0) {
                BytecodeManager.incBytecodes(2);
                final int longDigitLength = longDigitLength(n);
                BytecodeManager.incBytecodes(1);
                return longDigitLength;
            }
            final long n11 = BigDecimal.LONGLONG_TEN_POWERS_TABLE[0][1];
            BytecodeManager.incBytecodes(7);
            final boolean unsignedLongCompareEq = unsignedLongCompareEq(n, n11);
            BytecodeManager.incBytecodes(1);
            int n12;
            if (unsignedLongCompareEq) {
                n12 = 20;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n12 = 19;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n12;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean longLongCompareMagnitude(final long n, final long n2, final long n3, final long n4) {
        try {
            final long n5 = lcmp(n, n3);
            BytecodeManager.incBytecodes(4);
            if (n5 != 0) {
                final long n6 = lcmp(n, n3);
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (n6 < 0) {
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
            final long n7 = lcmp(n2 + Long.MIN_VALUE, n4 + Long.MIN_VALUE);
            BytecodeManager.incBytecodes(8);
            boolean b2;
            if (n7 < 0) {
                b2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final long n, final int n2, final long n3, final int n4, final int n5, final int n6) {
        try {
            final long n7 = n5 + (long)n4;
            BytecodeManager.incBytecodes(7);
            final int checkScale = checkScale(n, n7);
            BytecodeManager.incBytecodes(2);
            if (checkScale > n2) {
                final int n8 = n5 + n4;
                BytecodeManager.incBytecodes(4);
                final int n9 = n8 - n2;
                BytecodeManager.incBytecodes(4);
                final int n10 = n9;
                final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
                BytecodeManager.incBytecodes(4);
                if (n10 < length) {
                    BytecodeManager.incBytecodes(2);
                    final int n11 = n9;
                    BytecodeManager.incBytecodes(3);
                    final long longMultiplyPowerTen;
                    final long n12 = lcmp(longMultiplyPowerTen = longMultiplyPowerTen(n, n11), Long.MIN_VALUE);
                    BytecodeManager.incBytecodes(5);
                    if (n12 != 0) {
                        final long n13 = longMultiplyPowerTen;
                        BytecodeManager.incBytecodes(6);
                        final BigDecimal divideAndRound = divideAndRound(n13, n3, n5, n6, n5);
                        BytecodeManager.incBytecodes(1);
                        return divideAndRound;
                    }
                    final long n14 = BigDecimal.LONG_TEN_POWERS_TABLE[n9];
                    BytecodeManager.incBytecodes(9);
                    final BigDecimal multiplyDivideAndRound = multiplyDivideAndRound(n14, n, n3, n5, n6, n5);
                    BytecodeManager.incBytecodes(1);
                    final BigDecimal bigDecimal = multiplyDivideAndRound;
                    BytecodeManager.incBytecodes(2);
                    if (bigDecimal != null) {
                        final BigDecimal bigDecimal2 = multiplyDivideAndRound;
                        BytecodeManager.incBytecodes(2);
                        return bigDecimal2;
                    }
                }
                final int n15 = n9;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(n, n15);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger = bigMultiplyPowerTen;
                BytecodeManager.incBytecodes(6);
                final BigDecimal divideAndRound2 = divideAndRound(bigInteger, n3, n5, n6, n5);
                BytecodeManager.incBytecodes(1);
                return divideAndRound2;
            }
            final long n16 = n2 - (long)n5;
            BytecodeManager.incBytecodes(7);
            final int checkScale2 = checkScale(n3, n16);
            BytecodeManager.incBytecodes(1);
            final int n17 = checkScale2 - n4;
            BytecodeManager.incBytecodes(4);
            final int n18 = n17;
            final int length2 = BigDecimal.LONG_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(4);
            if (n18 < length2) {
                BytecodeManager.incBytecodes(2);
                final int n19 = n17;
                BytecodeManager.incBytecodes(3);
                final long longMultiplyPowerTen2;
                final long n20 = lcmp(longMultiplyPowerTen2 = longMultiplyPowerTen(n3, n19), Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n20 != 0) {
                    final long n21 = longMultiplyPowerTen2;
                    BytecodeManager.incBytecodes(6);
                    final BigDecimal divideAndRound3 = divideAndRound(n, n21, n5, n6, n5);
                    BytecodeManager.incBytecodes(1);
                    return divideAndRound3;
                }
            }
            final int n22 = n17;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(n3, n22);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final BigInteger value = BigInteger.valueOf(n);
            final BigInteger bigInteger2 = bigMultiplyPowerTen2;
            BytecodeManager.incBytecodes(5);
            final BigDecimal divideAndRound4 = divideAndRound(value, bigInteger2, n5, n6, n5);
            BytecodeManager.incBytecodes(1);
            return divideAndRound4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final BigInteger bigInteger, final int n, final long n2, final int n3, final int n4, final int n5) {
        try {
            final long n6 = n4 + (long)n3;
            BytecodeManager.incBytecodes(7);
            final int checkScale = checkScale(bigInteger, n6);
            BytecodeManager.incBytecodes(2);
            if (checkScale > n) {
                final int n7 = n4 + n3;
                BytecodeManager.incBytecodes(4);
                final int n8 = n7 - n;
                BytecodeManager.incBytecodes(4);
                final int n9 = n8;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(bigInteger, n9);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger2 = bigMultiplyPowerTen;
                BytecodeManager.incBytecodes(6);
                final BigDecimal divideAndRound = divideAndRound(bigInteger2, n2, n4, n5, n4);
                BytecodeManager.incBytecodes(1);
                return divideAndRound;
            }
            final long n10 = n - (long)n4;
            BytecodeManager.incBytecodes(7);
            final int checkScale2 = checkScale(n2, n10);
            BytecodeManager.incBytecodes(1);
            final int n11 = checkScale2 - n3;
            BytecodeManager.incBytecodes(4);
            final int n12 = n11;
            final int length = BigDecimal.LONG_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(4);
            if (n12 < length) {
                BytecodeManager.incBytecodes(2);
                final int n13 = n11;
                BytecodeManager.incBytecodes(3);
                final long longMultiplyPowerTen;
                final long n14 = lcmp(longMultiplyPowerTen = longMultiplyPowerTen(n2, n13), Long.MIN_VALUE);
                BytecodeManager.incBytecodes(5);
                if (n14 != 0) {
                    final long n15 = longMultiplyPowerTen;
                    BytecodeManager.incBytecodes(6);
                    final BigDecimal divideAndRound2 = divideAndRound(bigInteger, n15, n4, n5, n4);
                    BytecodeManager.incBytecodes(1);
                    return divideAndRound2;
                }
            }
            final int n16 = n11;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(n2, n16);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger3 = bigMultiplyPowerTen2;
            BytecodeManager.incBytecodes(6);
            final BigDecimal divideAndRound3 = divideAndRound(bigInteger, bigInteger3, n4, n5, n4);
            BytecodeManager.incBytecodes(1);
            return divideAndRound3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final long n, final int n2, final BigInteger bigInteger, final int n3, final int n4, final int n5) {
        try {
            final long n6 = n4 + (long)n3;
            BytecodeManager.incBytecodes(7);
            final int checkScale = checkScale(n, n6);
            BytecodeManager.incBytecodes(2);
            if (checkScale > n2) {
                final int n7 = n4 + n3;
                BytecodeManager.incBytecodes(4);
                final int n8 = n7 - n2;
                BytecodeManager.incBytecodes(4);
                final int n9 = n8;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(n, n9);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger2 = bigMultiplyPowerTen;
                BytecodeManager.incBytecodes(6);
                final BigDecimal divideAndRound = divideAndRound(bigInteger2, bigInteger, n4, n5, n4);
                BytecodeManager.incBytecodes(1);
                return divideAndRound;
            }
            final long n10 = n2 - (long)n4;
            BytecodeManager.incBytecodes(7);
            final int checkScale2 = checkScale(bigInteger, n10);
            BytecodeManager.incBytecodes(1);
            final int n11 = checkScale2 - n3;
            BytecodeManager.incBytecodes(4);
            final int n12 = n11;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(bigInteger, n12);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final BigInteger value = BigInteger.valueOf(n);
            final BigInteger bigInteger3 = bigMultiplyPowerTen2;
            BytecodeManager.incBytecodes(5);
            final BigDecimal divideAndRound2 = divideAndRound(value, bigInteger3, n4, n5, n4);
            BytecodeManager.incBytecodes(1);
            return divideAndRound2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static BigDecimal divide(final BigInteger bigInteger, final int n, final BigInteger bigInteger2, final int n2, final int n3, final int n4) {
        try {
            final long n5 = n3 + (long)n2;
            BytecodeManager.incBytecodes(7);
            final int checkScale = checkScale(bigInteger, n5);
            BytecodeManager.incBytecodes(2);
            if (checkScale > n) {
                final int n6 = n3 + n2;
                BytecodeManager.incBytecodes(4);
                final int n7 = n6 - n;
                BytecodeManager.incBytecodes(4);
                final int n8 = n7;
                BytecodeManager.incBytecodes(3);
                final BigInteger bigMultiplyPowerTen = bigMultiplyPowerTen(bigInteger, n8);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger3 = bigMultiplyPowerTen;
                BytecodeManager.incBytecodes(6);
                final BigDecimal divideAndRound = divideAndRound(bigInteger3, bigInteger2, n3, n4, n3);
                BytecodeManager.incBytecodes(1);
                return divideAndRound;
            }
            final long n9 = n - (long)n3;
            BytecodeManager.incBytecodes(7);
            final int checkScale2 = checkScale(bigInteger2, n9);
            BytecodeManager.incBytecodes(1);
            final int n10 = checkScale2 - n2;
            BytecodeManager.incBytecodes(4);
            final int n11 = n10;
            BytecodeManager.incBytecodes(3);
            final BigInteger bigMultiplyPowerTen2 = bigMultiplyPowerTen(bigInteger2, n11);
            BytecodeManager.incBytecodes(1);
            final BigInteger bigInteger4 = bigMultiplyPowerTen2;
            BytecodeManager.incBytecodes(6);
            final BigDecimal divideAndRound2 = divideAndRound(bigInteger, bigInteger4, n3, n4, n3);
            BytecodeManager.incBytecodes(1);
            return divideAndRound2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ BigInteger access$000(final BigDecimal bigDecimal) {
        try {
            BytecodeManager.incBytecodes(2);
            final BigInteger inflated = bigDecimal.inflated();
            BytecodeManager.incBytecodes(1);
            return inflated;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<BigDecimal> clazz = BigDecimal.class;
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
            final long n = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(2);
            INFLATED_BIGINT = BigInteger.valueOf(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            threadLocalStringBuilderHelper = new ThreadLocal<StringBuilderHelper>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                protected StringBuilderHelper initialValue() {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final StringBuilderHelper stringBuilderHelper = new StringBuilderHelper();
                        BytecodeManager.incBytecodes(1);
                        return stringBuilderHelper;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final BigDecimal[] zeroThroughTen2 = new BigDecimal[11];
            final int n2 = 0;
            final BigInteger zero = BigInteger.ZERO;
            final long n3 = 0L;
            final int n4 = 0;
            final int n5 = 1;
            BytecodeManager.incBytecodes(10);
            zeroThroughTen2[n2] = new BigDecimal(zero, n3, n4, n5);
            final int n6 = 1;
            final BigInteger one = BigInteger.ONE;
            final long n7 = 1L;
            final int n8 = 0;
            final int n9 = 1;
            BytecodeManager.incBytecodes(10);
            zeroThroughTen2[n6] = new BigDecimal(one, n7, n8, n9);
            final int n10 = 2;
            final long n11 = 2L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value = BigInteger.valueOf(n11);
            final long n12 = 2L;
            final int n13 = 0;
            final int n14 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n10] = new BigDecimal(value, n12, n13, n14);
            final int n15 = 3;
            final long n16 = 3L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value2 = BigInteger.valueOf(n16);
            final long n17 = 3L;
            final int n18 = 0;
            final int n19 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n15] = new BigDecimal(value2, n17, n18, n19);
            final int n20 = 4;
            final long n21 = 4L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value3 = BigInteger.valueOf(n21);
            final long n22 = 4L;
            final int n23 = 0;
            final int n24 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n20] = new BigDecimal(value3, n22, n23, n24);
            final int n25 = 5;
            final long n26 = 5L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value4 = BigInteger.valueOf(n26);
            final long n27 = 5L;
            final int n28 = 0;
            final int n29 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n25] = new BigDecimal(value4, n27, n28, n29);
            final int n30 = 6;
            final long n31 = 6L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value5 = BigInteger.valueOf(n31);
            final long n32 = 6L;
            final int n33 = 0;
            final int n34 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n30] = new BigDecimal(value5, n32, n33, n34);
            final int n35 = 7;
            final long n36 = 7L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value6 = BigInteger.valueOf(n36);
            final long n37 = 7L;
            final int n38 = 0;
            final int n39 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n35] = new BigDecimal(value6, n37, n38, n39);
            final int n40 = 8;
            final long n41 = 8L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value7 = BigInteger.valueOf(n41);
            final long n42 = 8L;
            final int n43 = 0;
            final int n44 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n40] = new BigDecimal(value7, n42, n43, n44);
            final int n45 = 9;
            final long n46 = 9L;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final BigInteger value8 = BigInteger.valueOf(n46);
            final long n47 = 9L;
            final int n48 = 0;
            final int n49 = 1;
            BytecodeManager.incBytecodes(4);
            zeroThroughTen2[n45] = new BigDecimal(value8, n47, n48, n49);
            final int n50 = 10;
            final BigInteger ten = BigInteger.TEN;
            final long n51 = 10L;
            final int n52 = 0;
            final int n53 = 2;
            BytecodeManager.incBytecodes(10);
            zeroThroughTen2[n50] = new BigDecimal(ten, n51, n52, n53);
            zeroThroughTen = zeroThroughTen2;
            BytecodeManager.incBytecodes(2);
            final BigDecimal[] zero_SCALED_BY = new BigDecimal[16];
            zero_SCALED_BY[0] = BigDecimal.zeroThroughTen[0];
            final int n54 = 1;
            final BigInteger zero2 = BigInteger.ZERO;
            final long n55 = 0L;
            final int n56 = 1;
            final int n57 = 1;
            BytecodeManager.incBytecodes(16);
            zero_SCALED_BY[n54] = new BigDecimal(zero2, n55, n56, n57);
            final int n58 = 2;
            final BigInteger zero3 = BigInteger.ZERO;
            final long n59 = 0L;
            final int n60 = 2;
            final int n61 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n58] = new BigDecimal(zero3, n59, n60, n61);
            final int n62 = 3;
            final BigInteger zero4 = BigInteger.ZERO;
            final long n63 = 0L;
            final int n64 = 3;
            final int n65 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n62] = new BigDecimal(zero4, n63, n64, n65);
            final int n66 = 4;
            final BigInteger zero5 = BigInteger.ZERO;
            final long n67 = 0L;
            final int n68 = 4;
            final int n69 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n66] = new BigDecimal(zero5, n67, n68, n69);
            final int n70 = 5;
            final BigInteger zero6 = BigInteger.ZERO;
            final long n71 = 0L;
            final int n72 = 5;
            final int n73 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n70] = new BigDecimal(zero6, n71, n72, n73);
            final int n74 = 6;
            final BigInteger zero7 = BigInteger.ZERO;
            final long n75 = 0L;
            final int n76 = 6;
            final int n77 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n74] = new BigDecimal(zero7, n75, n76, n77);
            final int n78 = 7;
            final BigInteger zero8 = BigInteger.ZERO;
            final long n79 = 0L;
            final int n80 = 7;
            final int n81 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n78] = new BigDecimal(zero8, n79, n80, n81);
            final int n82 = 8;
            final BigInteger zero9 = BigInteger.ZERO;
            final long n83 = 0L;
            final int n84 = 8;
            final int n85 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n82] = new BigDecimal(zero9, n83, n84, n85);
            final int n86 = 9;
            final BigInteger zero10 = BigInteger.ZERO;
            final long n87 = 0L;
            final int n88 = 9;
            final int n89 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n86] = new BigDecimal(zero10, n87, n88, n89);
            final int n90 = 10;
            final BigInteger zero11 = BigInteger.ZERO;
            final long n91 = 0L;
            final int n92 = 10;
            final int n93 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n90] = new BigDecimal(zero11, n91, n92, n93);
            final int n94 = 11;
            final BigInteger zero12 = BigInteger.ZERO;
            final long n95 = 0L;
            final int n96 = 11;
            final int n97 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n94] = new BigDecimal(zero12, n95, n96, n97);
            final int n98 = 12;
            final BigInteger zero13 = BigInteger.ZERO;
            final long n99 = 0L;
            final int n100 = 12;
            final int n101 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n98] = new BigDecimal(zero13, n99, n100, n101);
            final int n102 = 13;
            final BigInteger zero14 = BigInteger.ZERO;
            final long n103 = 0L;
            final int n104 = 13;
            final int n105 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n102] = new BigDecimal(zero14, n103, n104, n105);
            final int n106 = 14;
            final BigInteger zero15 = BigInteger.ZERO;
            final long n107 = 0L;
            final int n108 = 14;
            final int n109 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n106] = new BigDecimal(zero15, n107, n108, n109);
            final int n110 = 15;
            final BigInteger zero16 = BigInteger.ZERO;
            final long n111 = 0L;
            final int n112 = 15;
            final int n113 = 1;
            BytecodeManager.incBytecodes(10);
            zero_SCALED_BY[n110] = new BigDecimal(zero16, n111, n112, n113);
            ZERO_SCALED_BY = zero_SCALED_BY;
            BytecodeManager.incBytecodes(2);
            ZERO = BigDecimal.zeroThroughTen[0];
            BytecodeManager.incBytecodes(4);
            ONE = BigDecimal.zeroThroughTen[1];
            BytecodeManager.incBytecodes(4);
            TEN = BigDecimal.zeroThroughTen[10];
            BytecodeManager.incBytecodes(4);
            double10pow = new double[] { 1.0, 10.0, 100.0, 1000.0, 10000.0, 100000.0, 1000000.0, 1.0E7, 1.0E8, 1.0E9, 1.0E10, 1.0E11, 1.0E12, 1.0E13, 1.0E14, 1.0E15, 1.0E16, 1.0E17, 1.0E18, 1.0E19, 1.0E20, 1.0E21, 1.0E22 };
            BytecodeManager.incBytecodes(94);
            float10pow = new float[] { 1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f };
            BytecodeManager.incBytecodes(46);
            LONG_TEN_POWERS_TABLE = new long[] { 1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
            BytecodeManager.incBytecodes(78);
            final BigInteger[] big_TEN_POWERS_TABLE = new BigInteger[19];
            big_TEN_POWERS_TABLE[0] = BigInteger.ONE;
            final int n114 = 1;
            final long n115 = 10L;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n114] = BigInteger.valueOf(n115);
            final int n116 = 2;
            final long n117 = 100L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n116] = BigInteger.valueOf(n117);
            final int n118 = 3;
            final long n119 = 1000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n118] = BigInteger.valueOf(n119);
            final int n120 = 4;
            final long n121 = 10000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n120] = BigInteger.valueOf(n121);
            final int n122 = 5;
            final long n123 = 100000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n122] = BigInteger.valueOf(n123);
            final int n124 = 6;
            final long n125 = 1000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n124] = BigInteger.valueOf(n125);
            final int n126 = 7;
            final long n127 = 10000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n126] = BigInteger.valueOf(n127);
            final int n128 = 8;
            final long n129 = 100000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n128] = BigInteger.valueOf(n129);
            final int n130 = 9;
            final long n131 = 1000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n130] = BigInteger.valueOf(n131);
            final int n132 = 10;
            final long n133 = 10000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n132] = BigInteger.valueOf(n133);
            final int n134 = 11;
            final long n135 = 100000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n134] = BigInteger.valueOf(n135);
            final int n136 = 12;
            final long n137 = 1000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n136] = BigInteger.valueOf(n137);
            final int n138 = 13;
            final long n139 = 10000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n138] = BigInteger.valueOf(n139);
            final int n140 = 14;
            final long n141 = 100000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n140] = BigInteger.valueOf(n141);
            final int n142 = 15;
            final long n143 = 1000000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n142] = BigInteger.valueOf(n143);
            final int n144 = 16;
            final long n145 = 10000000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n144] = BigInteger.valueOf(n145);
            final int n146 = 17;
            final long n147 = 100000000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n146] = BigInteger.valueOf(n147);
            final int n148 = 18;
            final long n149 = 1000000000000000000L;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            big_TEN_POWERS_TABLE[n148] = BigInteger.valueOf(n149);
            BigDecimal.BIG_TEN_POWERS_TABLE = big_TEN_POWERS_TABLE;
            BytecodeManager.incBytecodes(2);
            BIG_TEN_POWERS_TABLE_INITLEN = BigDecimal.BIG_TEN_POWERS_TABLE.length;
            BytecodeManager.incBytecodes(3);
            BIG_TEN_POWERS_TABLE_MAX = 16 * BigDecimal.BIG_TEN_POWERS_TABLE_INITLEN;
            BytecodeManager.incBytecodes(4);
            THRESHOLDS_TABLE = new long[] { Long.MAX_VALUE, 922337203685477580L, 92233720368547758L, 9223372036854775L, 922337203685477L, 92233720368547L, 9223372036854L, 922337203685L, 92233720368L, 9223372036L, 922337203L, 92233720L, 9223372L, 922337L, 92233L, 9223L, 922L, 92L, 9L };
            BytecodeManager.incBytecodes(78);
            LONGLONG_TEN_POWERS_TABLE = new long[][] { { 0L, -8446744073709551616L }, { 5L, 7766279631452241920L }, { 54L, 3875820019684212736L }, { 542L, 1864712049423024128L }, { 5421L, 200376420520689664L }, { 54210L, 2003764205206896640L }, { 542101L, 1590897978359414784L }, { 5421010L, -2537764290115403776L }, { 54210108L, -6930898827444486144L }, { 542101086L, 4477988020393345024L }, { 5421010862L, 7886392056514347008L }, { 54210108624L, 5076944270305263616L }, { 542101086242L, -4570789518076018688L }, { 5421010862427L, -8814407033341083648L }, { 54210108624275L, 4089650035136921600L }, { 542101086242752L, 4003012203950112768L }, { 5421010862427522L, 3136633892082024448L }, { 54210108624275221L, -5527149226598858752L }, { 542101086242752217L, 68739955140067328L }, { 5421010862427522170L, 687399551400673280L } };
            BytecodeManager.incBytecodes(243);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class LongOverflow
    {
        private static final BigInteger LONGMIN;
        private static final BigInteger LONGMAX;
        
        private LongOverflow() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static void check(final BigDecimal bigDecimal) {
            try {
                BytecodeManager.incBytecodes(2);
                final BigInteger access$000 = BigDecimal.access$000(bigDecimal);
                BytecodeManager.incBytecodes(1);
                final BigInteger bigInteger = access$000;
                final BigInteger longmin = LongOverflow.LONGMIN;
                BytecodeManager.incBytecodes(3);
                final int compareTo = bigInteger.compareTo(longmin);
                BytecodeManager.incBytecodes(1);
                if (compareTo >= 0) {
                    final BigInteger bigInteger2 = access$000;
                    final BigInteger longmax = LongOverflow.LONGMAX;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final int compareTo2 = bigInteger2.compareTo(longmax);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo2 <= 0) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                final String s = "Overflow";
                BytecodeManager.incBytecodes(4);
                final ArithmeticException ex = new ArithmeticException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final long n = Long.MIN_VALUE;
                BytecodeManager.incBytecodes(2);
                LONGMIN = BigInteger.valueOf(n);
                BytecodeManager.incBytecodes(1);
                final long n2 = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
                LONGMAX = BigInteger.valueOf(n2);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class StringBuilderHelper
    {
        final StringBuilder sb;
        final char[] cmpCharArray;
        static final char[] DIGIT_TENS;
        static final char[] DIGIT_ONES;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        StringBuilderHelper() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(4);
                this.sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                this.cmpCharArray = new char[19];
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        StringBuilder getStringBuilder() {
            try {
                final StringBuilder sb = this.sb;
                final int length = 0;
                BytecodeManager.incBytecodes(4);
                sb.setLength(length);
                final StringBuilder sb2 = this.sb;
                BytecodeManager.incBytecodes(3);
                return sb2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        char[] getCompactCharArray() {
            try {
                final char[] cmpCharArray = this.cmpCharArray;
                BytecodeManager.incBytecodes(3);
                return cmpCharArray;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        int putIntCompact(long n) {
            try {
                final boolean $assertionsDisabled = StringBuilderHelper.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n2 = lcmp(n, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n2 < 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                int length = this.cmpCharArray.length;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final long n3 = lcmp(n, 2147483647L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 <= 0) {
                        break;
                    }
                    final long n4 = n / 100L;
                    BytecodeManager.incBytecodes(4);
                    final int n5 = (int)(n - n4 * 100L);
                    BytecodeManager.incBytecodes(7);
                    n = n4;
                    BytecodeManager.incBytecodes(2);
                    this.cmpCharArray[--length] = StringBuilderHelper.DIGIT_ONES[n5];
                    BytecodeManager.incBytecodes(8);
                    this.cmpCharArray[--length] = StringBuilderHelper.DIGIT_TENS[n5];
                    BytecodeManager.incBytecodes(9);
                }
                int n6 = (int)n;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n7 = n6;
                    final int n8 = 100;
                    BytecodeManager.incBytecodes(3);
                    if (n7 < n8) {
                        break;
                    }
                    final int n9 = n6 / 100;
                    BytecodeManager.incBytecodes(4);
                    final int n10 = n6 - n9 * 100;
                    BytecodeManager.incBytecodes(6);
                    n6 = n9;
                    BytecodeManager.incBytecodes(2);
                    this.cmpCharArray[--length] = StringBuilderHelper.DIGIT_ONES[n10];
                    BytecodeManager.incBytecodes(8);
                    this.cmpCharArray[--length] = StringBuilderHelper.DIGIT_TENS[n10];
                    BytecodeManager.incBytecodes(9);
                }
                this.cmpCharArray[--length] = StringBuilderHelper.DIGIT_ONES[n6];
                BytecodeManager.incBytecodes(8);
                final int n11 = n6;
                final int n12 = 10;
                BytecodeManager.incBytecodes(3);
                if (n11 >= n12) {
                    this.cmpCharArray[--length] = StringBuilderHelper.DIGIT_TENS[n6];
                    BytecodeManager.incBytecodes(8);
                }
                final int n13 = length;
                BytecodeManager.incBytecodes(2);
                return n13;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<BigDecimal> clazz = BigDecimal.class;
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
                DIGIT_TENS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9' };
                BytecodeManager.incBytecodes(402);
                DIGIT_ONES = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
                BytecodeManager.incBytecodes(403);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class UnsafeHolder
    {
        private static final Unsafe unsafe;
        private static final long intCompactOffset;
        private static final long intValOffset;
        
        private UnsafeHolder() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static void setIntCompactVolatile(final BigDecimal o, final long x) {
            try {
                final Unsafe unsafe = UnsafeHolder.unsafe;
                final long intCompactOffset = UnsafeHolder.intCompactOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putLongVolatile(o, intCompactOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static void setIntValVolatile(final BigDecimal o, final BigInteger x) {
            try {
                final Unsafe unsafe = UnsafeHolder.unsafe;
                final long intValOffset = UnsafeHolder.intValOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putObjectVolatile(o, intValOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                try {
                    try {
                        BytecodeManager.incBytecodes(1);
                        unsafe = Unsafe.getUnsafe();
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe2 = UnsafeHolder.unsafe;
                        final Class<BigDecimal> clazz = BigDecimal.class;
                        final String name = "intCompact";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField = clazz.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        intCompactOffset = unsafe2.objectFieldOffset(declaredField);
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe3 = UnsafeHolder.unsafe;
                        final Class<BigDecimal> clazz2 = BigDecimal.class;
                        final String name2 = "intVal";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField2 = clazz2.getDeclaredField(name2);
                        BytecodeManager.incBytecodes(1);
                        intValOffset = unsafe3.objectFieldOffset(declaredField2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (Exception ex) {
                        BytecodeManager.incBytecodes(501);
                        final Exception thrown = ex;
                        BytecodeManager.incBytecodes(4);
                        final ExceptionInInitializerError exceptionInInitializerError = new ExceptionInInitializerError(thrown);
                        BytecodeManager.incBytecodes(1);
                        throw exceptionInInitializerError;
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
    }
}
