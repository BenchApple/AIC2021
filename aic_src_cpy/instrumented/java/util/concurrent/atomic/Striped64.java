// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import java.lang.reflect.Field;
import sun.misc.Contended;
import instrumented.java.util.function.DoubleBinaryOperator;
import instrumented.java.util.function.LongBinaryOperator;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;

abstract class Striped64 extends Number
{
    static final int NCPU;
    transient volatile Cell[] cells;
    transient volatile long base;
    transient volatile int cellsBusy;
    private static final Unsafe UNSAFE;
    private static final long BASE;
    private static final long CELLSBUSY;
    private static final long PROBE;
    
    Striped64() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean casBase(final long expected, final long x) {
        try {
            final Unsafe unsafe = Striped64.UNSAFE;
            final long base = Striped64.BASE;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapLong = unsafe.compareAndSwapLong(this, base, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean casCellsBusy() {
        try {
            final Unsafe unsafe = Striped64.UNSAFE;
            final long cellsbusy = Striped64.CELLSBUSY;
            final int expected = 0;
            final int x = 1;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapInt = unsafe.compareAndSwapInt(this, cellsbusy, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int getProbe() {
        try {
            final Unsafe unsafe = Striped64.UNSAFE;
            BytecodeManager.incBytecodes(2);
            final Thread currentThread = Thread.currentThread();
            final long probe = Striped64.PROBE;
            BytecodeManager.incBytecodes(2);
            final int int1 = unsafe.getInt(currentThread, probe);
            BytecodeManager.incBytecodes(1);
            return int1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int advanceProbe(int n) {
        try {
            n ^= n << 13;
            BytecodeManager.incBytecodes(6);
            n ^= n >>> 17;
            BytecodeManager.incBytecodes(6);
            n ^= n << 5;
            BytecodeManager.incBytecodes(6);
            final Unsafe unsafe = Striped64.UNSAFE;
            BytecodeManager.incBytecodes(2);
            final Thread currentThread = Thread.currentThread();
            final long probe = Striped64.PROBE;
            final int x = n;
            BytecodeManager.incBytecodes(3);
            unsafe.putInt(currentThread, probe, x);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void longAccumulate(final long p0, final LongBinaryOperator p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    instrumented/java/util/concurrent/atomic/Striped64.getProbe:()I
        //     8: dup            
        //     9: istore          5
        //    11: ldc             3
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: ifne            56
        //    19: ldc             1
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.current:()Linstrumented/java/util/concurrent/ThreadLocalRandom;
        //    27: pop            
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: ldc             1
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokestatic    instrumented/java/util/concurrent/atomic/Striped64.getProbe:()I
        //    41: istore          5
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: iconst_1       
        //    49: istore          4
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: iconst_0       
        //    57: istore          6
        //    59: ldc             2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //    68: dup            
        //    69: astore          7
        //    71: ldc             5
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ifnull          662
        //    79: aload           7
        //    81: arraylength    
        //    82: dup            
        //    83: istore          9
        //    85: ldc             5
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: ifle            662
        //    93: aload           7
        //    95: iload           9
        //    97: iconst_1       
        //    98: isub           
        //    99: iload           5
        //   101: iand           
        //   102: aaload         
        //   103: dup            
        //   104: astore          8
        //   106: ldc             10
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: ifnonnull       320
        //   114: aload_0        
        //   115: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   118: ldc             3
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: ifne            309
        //   126: new             Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   129: dup            
        //   130: lload_1        
        //   131: ldc             4
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokespecial   instrumented/java/util/concurrent/atomic/Striped64$Cell.<init>:(J)V
        //   139: astore          12
        //   141: ldc             1
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: aload_0        
        //   147: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   150: ldc             3
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: ifne            309
        //   158: aload_0        
        //   159: ldc             2
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casCellsBusy:()Z
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: ifeq            309
        //   175: iconst_0       
        //   176: istore          13
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload_0        
        //   184: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   187: dup            
        //   188: astore          14
        //   190: ldc             5
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: ifnull          253
        //   198: aload           14
        //   200: arraylength    
        //   201: dup            
        //   202: istore          15
        //   204: ldc             5
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: ifle            253
        //   212: aload           14
        //   214: iload           15
        //   216: iconst_1       
        //   217: isub           
        //   218: iload           5
        //   220: iand           
        //   221: dup            
        //   222: istore          16
        //   224: aaload         
        //   225: ldc             10
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: ifnonnull       253
        //   233: aload           14
        //   235: iload           16
        //   237: aload           12
        //   239: aastore        
        //   240: ldc             4
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: iconst_1       
        //   246: istore          13
        //   248: ldc             2
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: aload_0        
        //   254: iconst_0       
        //   255: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   258: ldc             3
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: goto            291
        //   271: astore          17
        //   273: ldc             501
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: aload_0        
        //   279: iconst_0       
        //   280: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   283: aload           17
        //   285: ldc             5
        //   287: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   290: athrow         
        //   291: iload           13
        //   293: ldc             2
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: ifeq            64
        //   301: ldc             1
        //   303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   306: goto            926
        //   309: iconst_0       
        //   310: istore          6
        //   312: ldc             3
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: goto            642
        //   320: iload           4
        //   322: ldc             2
        //   324: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   327: ifne            341
        //   330: iconst_1       
        //   331: istore          4
        //   333: ldc             3
        //   335: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   338: goto            642
        //   341: aload           8
        //   343: aload           8
        //   345: getfield        instrumented/java/util/concurrent/atomic/Striped64$Cell.value:J
        //   348: dup2           
        //   349: lstore          10
        //   351: aload_3        
        //   352: ldc             7
        //   354: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   357: ifnonnull       372
        //   360: lload           10
        //   362: lload_1        
        //   363: ladd           
        //   364: ldc             4
        //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   369: goto            391
        //   372: aload_3        
        //   373: lload           10
        //   375: lload_1        
        //   376: ldc             3
        //   378: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   381: ldc             1
        //   383: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   386: invokeinterface instrumented/java/util/function/LongBinaryOperator.applyAsLong:(JJ)J
        //   391: ldc             1
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64$Cell.cas:(JJ)Z
        //   399: ldc             1
        //   401: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   404: ifeq            415
        //   407: ldc             1
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: goto            926
        //   415: iload           9
        //   417: getstatic       instrumented/java/util/concurrent/atomic/Striped64.NCPU:I
        //   420: ldc             3
        //   422: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   425: if_icmpge       442
        //   428: aload_0        
        //   429: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   432: aload           7
        //   434: ldc             4
        //   436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   439: if_acmpeq       453
        //   442: iconst_0       
        //   443: istore          6
        //   445: ldc             3
        //   447: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   450: goto            642
        //   453: iload           6
        //   455: ldc             2
        //   457: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   460: ifne            474
        //   463: iconst_1       
        //   464: istore          6
        //   466: ldc             3
        //   468: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   471: goto            642
        //   474: aload_0        
        //   475: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   478: ldc             3
        //   480: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   483: ifne            642
        //   486: aload_0        
        //   487: ldc             2
        //   489: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   492: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casCellsBusy:()Z
        //   495: ldc             1
        //   497: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   500: ifeq            642
        //   503: aload_0        
        //   504: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   507: aload           7
        //   509: ldc             4
        //   511: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   514: if_acmpne       588
        //   517: iload           9
        //   519: iconst_1       
        //   520: ishl           
        //   521: anewarray       Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   524: astore          12
        //   526: ldc             4
        //   528: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   531: iconst_0       
        //   532: istore          13
        //   534: ldc             2
        //   536: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   539: iload           13
        //   541: iload           9
        //   543: ldc             3
        //   545: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   548: if_icmpge       577
        //   551: aload           12
        //   553: iload           13
        //   555: aload           7
        //   557: iload           13
        //   559: aaload         
        //   560: aastore        
        //   561: ldc             6
        //   563: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   566: iinc            13, 1
        //   569: ldc             2
        //   571: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   574: goto            539
        //   577: aload_0        
        //   578: aload           12
        //   580: putfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   583: ldc             3
        //   585: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   588: aload_0        
        //   589: iconst_0       
        //   590: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   593: ldc             3
        //   595: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   598: ldc             1
        //   600: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   603: goto            626
        //   606: astore          18
        //   608: ldc             501
        //   610: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   613: aload_0        
        //   614: iconst_0       
        //   615: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   618: aload           18
        //   620: ldc             5
        //   622: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   625: athrow         
        //   626: iconst_0       
        //   627: istore          6
        //   629: ldc             2
        //   631: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   634: ldc             1
        //   636: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   639: goto            64
        //   642: iload           5
        //   644: ldc             2
        //   646: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   649: invokestatic    instrumented/java/util/concurrent/atomic/Striped64.advanceProbe:(I)I
        //   652: istore          5
        //   654: ldc             2
        //   656: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   659: goto            918
        //   662: aload_0        
        //   663: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   666: ldc             3
        //   668: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   671: ifne            846
        //   674: aload_0        
        //   675: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   678: aload           7
        //   680: ldc             4
        //   682: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   685: if_acmpne       846
        //   688: aload_0        
        //   689: ldc             2
        //   691: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   694: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casCellsBusy:()Z
        //   697: ldc             1
        //   699: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   702: ifeq            846
        //   705: iconst_0       
        //   706: istore          12
        //   708: ldc             2
        //   710: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   713: aload_0        
        //   714: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   717: aload           7
        //   719: ldc             4
        //   721: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   724: if_acmpne       782
        //   727: iconst_2       
        //   728: anewarray       Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   731: astore          13
        //   733: ldc             2
        //   735: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   738: aload           13
        //   740: iload           5
        //   742: iconst_1       
        //   743: iand           
        //   744: new             Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   747: dup            
        //   748: lload_1        
        //   749: ldc             8
        //   751: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   754: invokespecial   instrumented/java/util/concurrent/atomic/Striped64$Cell.<init>:(J)V
        //   757: aastore        
        //   758: ldc             1
        //   760: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   763: aload_0        
        //   764: aload           13
        //   766: putfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   769: ldc             3
        //   771: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   774: iconst_1       
        //   775: istore          12
        //   777: ldc             2
        //   779: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   782: aload_0        
        //   783: iconst_0       
        //   784: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   787: ldc             3
        //   789: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   792: ldc             1
        //   794: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   797: goto            820
        //   800: astore          19
        //   802: ldc             501
        //   804: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   807: aload_0        
        //   808: iconst_0       
        //   809: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   812: aload           19
        //   814: ldc             5
        //   816: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   819: athrow         
        //   820: iload           12
        //   822: ldc             2
        //   824: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   827: ifeq            838
        //   830: ldc             1
        //   832: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   835: goto            926
        //   838: ldc             1
        //   840: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   843: goto            918
        //   846: aload_0        
        //   847: aload_0        
        //   848: getfield        instrumented/java/util/concurrent/atomic/Striped64.base:J
        //   851: dup2           
        //   852: lstore          10
        //   854: aload_3        
        //   855: ldc             7
        //   857: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   860: ifnonnull       875
        //   863: lload           10
        //   865: lload_1        
        //   866: ladd           
        //   867: ldc             4
        //   869: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   872: goto            894
        //   875: aload_3        
        //   876: lload           10
        //   878: lload_1        
        //   879: ldc             3
        //   881: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   884: ldc             1
        //   886: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   889: invokeinterface instrumented/java/util/function/LongBinaryOperator.applyAsLong:(JJ)J
        //   894: ldc             1
        //   896: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   899: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casBase:(JJ)Z
        //   902: ldc             1
        //   904: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   907: ifeq            918
        //   910: ldc             1
        //   912: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   915: goto            926
        //   918: ldc             1
        //   920: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   923: goto            64
        //   926: ldc             1
        //   928: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   931: return         
        //   932: athrow         
        //   933: athrow         
        //    StackMapTable: 00 20 FC 00 38 01 FC 00 07 01 FF 00 BC 00 0D 07 00 02 04 07 00 66 01 01 01 07 00 67 07 00 07 01 00 00 07 00 07 01 00 00 51 07 00 22 13 FF 00 11 00 09 07 00 02 04 07 00 66 01 01 01 07 00 67 07 00 07 01 00 00 0A 14 FF 00 1E 00 0A 07 00 02 04 07 00 66 01 01 01 07 00 67 07 00 07 01 04 00 02 07 00 07 04 FF 00 12 00 0A 07 00 02 04 07 00 66 01 01 01 07 00 67 07 00 07 01 04 00 03 07 00 07 04 04 17 1A 0A 14 FD 00 40 07 00 67 01 FA 00 25 FA 00 0A 51 07 00 22 13 FA 00 0F F9 00 13 FF 00 77 00 0C 07 00 02 04 07 00 66 01 01 01 07 00 67 00 00 00 00 01 00 00 51 07 00 22 13 FF 00 11 00 07 07 00 02 04 07 00 66 01 01 01 07 00 67 00 00 07 FF 00 1C 00 0A 07 00 02 04 07 00 66 01 01 01 07 00 67 00 00 04 00 02 07 00 02 04 FF 00 12 00 0A 07 00 02 04 07 00 66 01 01 01 07 00 67 00 00 04 00 03 07 00 02 04 04 FF 00 17 00 06 07 00 02 04 07 00 66 01 01 01 00 00 07 FF 00 05 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 50
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  183    933    933    934    Ljava/lang/VirtualMachineError;
        //  183    253    271    291    Any
        //  271    278    271    291    Any
        //  503    588    606    626    Any
        //  606    613    606    626    Any
        //  713    782    800    820    Any
        //  800    807    800    820    Any
        //  0      932    932    933    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0253:
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
    
    final void doubleAccumulate(final double p0, final DoubleBinaryOperator p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    instrumented/java/util/concurrent/atomic/Striped64.getProbe:()I
        //     8: dup            
        //     9: istore          5
        //    11: ldc             3
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: ifne            56
        //    19: ldc             1
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.current:()Linstrumented/java/util/concurrent/ThreadLocalRandom;
        //    27: pop            
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: ldc             1
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokestatic    instrumented/java/util/concurrent/atomic/Striped64.getProbe:()I
        //    41: istore          5
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: iconst_1       
        //    49: istore          4
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: iconst_0       
        //    57: istore          6
        //    59: ldc             2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //    68: dup            
        //    69: astore          7
        //    71: ldc             5
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ifnull          707
        //    79: aload           7
        //    81: arraylength    
        //    82: dup            
        //    83: istore          9
        //    85: ldc             5
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: ifle            707
        //    93: aload           7
        //    95: iload           9
        //    97: iconst_1       
        //    98: isub           
        //    99: iload           5
        //   101: iand           
        //   102: aaload         
        //   103: dup            
        //   104: astore          8
        //   106: ldc             10
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: ifnonnull       328
        //   114: aload_0        
        //   115: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   118: ldc             3
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: ifne            317
        //   126: new             Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   129: dup            
        //   130: dload_1        
        //   131: ldc             4
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokestatic    java/lang/Double.doubleToRawLongBits:(D)J
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: invokespecial   instrumented/java/util/concurrent/atomic/Striped64$Cell.<init>:(J)V
        //   147: astore          12
        //   149: ldc             1
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: aload_0        
        //   155: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   158: ldc             3
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ifne            317
        //   166: aload_0        
        //   167: ldc             2
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casCellsBusy:()Z
        //   175: ldc             1
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: ifeq            317
        //   183: iconst_0       
        //   184: istore          13
        //   186: ldc             2
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: aload_0        
        //   192: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   195: dup            
        //   196: astore          14
        //   198: ldc             5
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: ifnull          261
        //   206: aload           14
        //   208: arraylength    
        //   209: dup            
        //   210: istore          15
        //   212: ldc             5
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: ifle            261
        //   220: aload           14
        //   222: iload           15
        //   224: iconst_1       
        //   225: isub           
        //   226: iload           5
        //   228: iand           
        //   229: dup            
        //   230: istore          16
        //   232: aaload         
        //   233: ldc             10
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: ifnonnull       261
        //   241: aload           14
        //   243: iload           16
        //   245: aload           12
        //   247: aastore        
        //   248: ldc             4
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: iconst_1       
        //   254: istore          13
        //   256: ldc             2
        //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   261: aload_0        
        //   262: iconst_0       
        //   263: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   266: ldc             3
        //   268: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   271: ldc             1
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: goto            299
        //   279: astore          17
        //   281: ldc             501
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: aload_0        
        //   287: iconst_0       
        //   288: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   291: aload           17
        //   293: ldc             5
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: athrow         
        //   299: iload           13
        //   301: ldc             2
        //   303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   306: ifeq            64
        //   309: ldc             1
        //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   314: goto            1016
        //   317: iconst_0       
        //   318: istore          6
        //   320: ldc             3
        //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   325: goto            687
        //   328: iload           4
        //   330: ldc             2
        //   332: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   335: ifne            349
        //   338: iconst_1       
        //   339: istore          4
        //   341: ldc             3
        //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   346: goto            687
        //   349: aload           8
        //   351: aload           8
        //   353: getfield        instrumented/java/util/concurrent/atomic/Striped64$Cell.value:J
        //   356: dup2           
        //   357: lstore          10
        //   359: aload_3        
        //   360: ldc             7
        //   362: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   365: ifnonnull       401
        //   368: lload           10
        //   370: ldc             1
        //   372: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   375: ldc             1
        //   377: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   380: invokestatic    java/lang/Double.longBitsToDouble:(J)D
        //   383: dload_1        
        //   384: dadd           
        //   385: ldc             3
        //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   390: invokestatic    java/lang/Double.doubleToRawLongBits:(D)J
        //   393: ldc             1
        //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   398: goto            436
        //   401: aload_3        
        //   402: lload           10
        //   404: ldc             2
        //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   409: ldc             1
        //   411: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   414: invokestatic    java/lang/Double.longBitsToDouble:(J)D
        //   417: dload_1        
        //   418: ldc             2
        //   420: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   423: invokeinterface instrumented/java/util/function/DoubleBinaryOperator.applyAsDouble:(DD)D
        //   428: ldc             1
        //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   433: invokestatic    java/lang/Double.doubleToRawLongBits:(D)J
        //   436: ldc             1
        //   438: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   441: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64$Cell.cas:(JJ)Z
        //   444: ldc             1
        //   446: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   449: ifeq            460
        //   452: ldc             1
        //   454: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   457: goto            1016
        //   460: iload           9
        //   462: getstatic       instrumented/java/util/concurrent/atomic/Striped64.NCPU:I
        //   465: ldc             3
        //   467: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   470: if_icmpge       487
        //   473: aload_0        
        //   474: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   477: aload           7
        //   479: ldc             4
        //   481: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   484: if_acmpeq       498
        //   487: iconst_0       
        //   488: istore          6
        //   490: ldc             3
        //   492: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   495: goto            687
        //   498: iload           6
        //   500: ldc             2
        //   502: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   505: ifne            519
        //   508: iconst_1       
        //   509: istore          6
        //   511: ldc             3
        //   513: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   516: goto            687
        //   519: aload_0        
        //   520: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   523: ldc             3
        //   525: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   528: ifne            687
        //   531: aload_0        
        //   532: ldc             2
        //   534: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   537: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casCellsBusy:()Z
        //   540: ldc             1
        //   542: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   545: ifeq            687
        //   548: aload_0        
        //   549: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   552: aload           7
        //   554: ldc             4
        //   556: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   559: if_acmpne       633
        //   562: iload           9
        //   564: iconst_1       
        //   565: ishl           
        //   566: anewarray       Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   569: astore          12
        //   571: ldc             4
        //   573: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   576: iconst_0       
        //   577: istore          13
        //   579: ldc             2
        //   581: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   584: iload           13
        //   586: iload           9
        //   588: ldc             3
        //   590: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   593: if_icmpge       622
        //   596: aload           12
        //   598: iload           13
        //   600: aload           7
        //   602: iload           13
        //   604: aaload         
        //   605: aastore        
        //   606: ldc             6
        //   608: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   611: iinc            13, 1
        //   614: ldc             2
        //   616: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   619: goto            584
        //   622: aload_0        
        //   623: aload           12
        //   625: putfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   628: ldc             3
        //   630: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   633: aload_0        
        //   634: iconst_0       
        //   635: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   638: ldc             3
        //   640: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   643: ldc             1
        //   645: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   648: goto            671
        //   651: astore          18
        //   653: ldc             501
        //   655: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   658: aload_0        
        //   659: iconst_0       
        //   660: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   663: aload           18
        //   665: ldc             5
        //   667: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   670: athrow         
        //   671: iconst_0       
        //   672: istore          6
        //   674: ldc             2
        //   676: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   679: ldc             1
        //   681: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   684: goto            64
        //   687: iload           5
        //   689: ldc             2
        //   691: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   694: invokestatic    instrumented/java/util/concurrent/atomic/Striped64.advanceProbe:(I)I
        //   697: istore          5
        //   699: ldc             2
        //   701: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   704: goto            1008
        //   707: aload_0        
        //   708: getfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   711: ldc             3
        //   713: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   716: ifne            899
        //   719: aload_0        
        //   720: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   723: aload           7
        //   725: ldc             4
        //   727: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   730: if_acmpne       899
        //   733: aload_0        
        //   734: ldc             2
        //   736: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   739: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casCellsBusy:()Z
        //   742: ldc             1
        //   744: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   747: ifeq            899
        //   750: iconst_0       
        //   751: istore          12
        //   753: ldc             2
        //   755: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   758: aload_0        
        //   759: getfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   762: aload           7
        //   764: ldc             4
        //   766: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   769: if_acmpne       835
        //   772: iconst_2       
        //   773: anewarray       Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   776: astore          13
        //   778: ldc             2
        //   780: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   783: aload           13
        //   785: iload           5
        //   787: iconst_1       
        //   788: iand           
        //   789: new             Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   792: dup            
        //   793: dload_1        
        //   794: ldc             8
        //   796: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   799: invokestatic    java/lang/Double.doubleToRawLongBits:(D)J
        //   802: ldc             1
        //   804: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   807: invokespecial   instrumented/java/util/concurrent/atomic/Striped64$Cell.<init>:(J)V
        //   810: aastore        
        //   811: ldc             1
        //   813: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   816: aload_0        
        //   817: aload           13
        //   819: putfield        instrumented/java/util/concurrent/atomic/Striped64.cells:[Linstrumented/java/util/concurrent/atomic/Striped64$Cell;
        //   822: ldc             3
        //   824: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   827: iconst_1       
        //   828: istore          12
        //   830: ldc             2
        //   832: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   835: aload_0        
        //   836: iconst_0       
        //   837: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   840: ldc             3
        //   842: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   845: ldc             1
        //   847: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   850: goto            873
        //   853: astore          19
        //   855: ldc             501
        //   857: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   860: aload_0        
        //   861: iconst_0       
        //   862: putfield        instrumented/java/util/concurrent/atomic/Striped64.cellsBusy:I
        //   865: aload           19
        //   867: ldc             5
        //   869: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   872: athrow         
        //   873: iload           12
        //   875: ldc             2
        //   877: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   880: ifeq            891
        //   883: ldc             1
        //   885: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   888: goto            1016
        //   891: ldc             1
        //   893: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   896: goto            1008
        //   899: aload_0        
        //   900: aload_0        
        //   901: getfield        instrumented/java/util/concurrent/atomic/Striped64.base:J
        //   904: dup2           
        //   905: lstore          10
        //   907: aload_3        
        //   908: ldc             7
        //   910: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   913: ifnonnull       949
        //   916: lload           10
        //   918: ldc             1
        //   920: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   923: ldc             1
        //   925: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   928: invokestatic    java/lang/Double.longBitsToDouble:(J)D
        //   931: dload_1        
        //   932: dadd           
        //   933: ldc             3
        //   935: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   938: invokestatic    java/lang/Double.doubleToRawLongBits:(D)J
        //   941: ldc             1
        //   943: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   946: goto            984
        //   949: aload_3        
        //   950: lload           10
        //   952: ldc             2
        //   954: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   957: ldc             1
        //   959: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   962: invokestatic    java/lang/Double.longBitsToDouble:(J)D
        //   965: dload_1        
        //   966: ldc             2
        //   968: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   971: invokeinterface instrumented/java/util/function/DoubleBinaryOperator.applyAsDouble:(DD)D
        //   976: ldc             1
        //   978: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   981: invokestatic    java/lang/Double.doubleToRawLongBits:(D)J
        //   984: ldc             1
        //   986: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   989: invokevirtual   instrumented/java/util/concurrent/atomic/Striped64.casBase:(JJ)Z
        //   992: ldc             1
        //   994: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   997: ifeq            1008
        //  1000: ldc             1
        //  1002: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1005: goto            1016
        //  1008: ldc             1
        //  1010: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1013: goto            64
        //  1016: ldc             1
        //  1018: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1021: return         
        //  1022: athrow         
        //  1023: athrow         
        //    StackMapTable: 00 20 FC 00 38 01 FC 00 07 01 FF 00 C4 00 0D 07 00 02 03 07 00 86 01 01 01 07 00 67 07 00 07 01 00 00 07 00 07 01 00 00 51 07 00 22 13 FF 00 11 00 09 07 00 02 03 07 00 86 01 01 01 07 00 67 07 00 07 01 00 00 0A 14 FF 00 33 00 0A 07 00 02 03 07 00 86 01 01 01 07 00 67 07 00 07 01 04 00 02 07 00 07 04 FF 00 22 00 0A 07 00 02 03 07 00 86 01 01 01 07 00 67 07 00 07 01 04 00 03 07 00 07 04 04 17 1A 0A 14 FD 00 40 07 00 67 01 FA 00 25 FA 00 0A 51 07 00 22 13 FA 00 0F F9 00 13 FF 00 7F 00 0C 07 00 02 03 07 00 86 01 01 01 07 00 67 00 00 00 00 01 00 00 51 07 00 22 13 FF 00 11 00 07 07 00 02 03 07 00 86 01 01 01 07 00 67 00 00 07 FF 00 31 00 0A 07 00 02 03 07 00 86 01 01 01 07 00 67 00 00 04 00 02 07 00 02 04 FF 00 22 00 0A 07 00 02 03 07 00 86 01 01 01 07 00 67 00 00 04 00 03 07 00 02 04 04 FF 00 17 00 06 07 00 02 03 07 00 86 01 01 01 00 00 07 FF 00 05 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 50
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  191    1023   1023   1024   Ljava/lang/VirtualMachineError;
        //  191    261    279    299    Any
        //  279    286    279    299    Any
        //  548    633    651    671    Any
        //  651    658    651    671    Any
        //  758    835    853    873    Any
        //  853    860    853    873    Any
        //  0      1022   1022   1023   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0261:
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
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
        //     8: ldc             1
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: invokevirtual   java/lang/Runtime.availableProcessors:()I
        //    16: putstatic       instrumented/java/util/concurrent/atomic/Striped64.NCPU:I
        //    19: ldc             1
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ldc             1
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //    32: putstatic       instrumented/java/util/concurrent/atomic/Striped64.UNSAFE:Lsun/misc/Unsafe;
        //    35: ldc             1
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ldc             Linstrumented/java/util/concurrent/atomic/Striped64;.class
        //    42: astore_0       
        //    43: ldc             2
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: getstatic       instrumented/java/util/concurrent/atomic/Striped64.UNSAFE:Lsun/misc/Unsafe;
        //    51: aload_0        
        //    52: ldc             "base"
        //    54: ldc             3
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //    75: putstatic       instrumented/java/util/concurrent/atomic/Striped64.BASE:J
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: getstatic       instrumented/java/util/concurrent/atomic/Striped64.UNSAFE:Lsun/misc/Unsafe;
        //    86: aload_0        
        //    87: ldc             "cellsBusy"
        //    89: ldc             3
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   102: ldc             1
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   110: putstatic       instrumented/java/util/concurrent/atomic/Striped64.CELLSBUSY:J
        //   113: ldc             1
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: ldc             Ljava/lang/Thread;.class
        //   120: astore_1       
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: getstatic       instrumented/java/util/concurrent/atomic/Striped64.UNSAFE:Lsun/misc/Unsafe;
        //   129: aload_1        
        //   130: ldc             "threadLocalRandomProbe"
        //   132: ldc             3
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: ldc             1
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   145: ldc             1
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   153: putstatic       instrumented/java/util/concurrent/atomic/Striped64.PROBE:J
        //   156: ldc             1
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: ldc             1
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: goto            194
        //   169: astore_0       
        //   170: ldc             501
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: new             Ljava/lang/Error;
        //   178: dup            
        //   179: aload_0        
        //   180: ldc             4
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: athrow         
        //   194: ldc             1
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: return         
        //   200: athrow         
        //   201: athrow         
        //    StackMapTable: 00 04 F7 00 A9 07 00 91 18 FF 00 05 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 50
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  24     201    201    202    Ljava/lang/VirtualMachineError;
        //  24     161    169    194    Ljava/lang/Exception;
        //  0      200    200    201    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0194:
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
    
    @Contended
    static final class Cell
    {
        volatile long value;
        private static final Unsafe UNSAFE;
        private static final long valueOffset;
        
        Cell(final long value) {
            try {
                BytecodeManager.incBytecodes(2);
                this.value = value;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean cas(final long expected, final long x) {
            try {
                final Unsafe unsafe = Cell.UNSAFE;
                final long valueOffset = Cell.valueOffset;
                BytecodeManager.incBytecodes(6);
                final boolean compareAndSwapLong = unsafe.compareAndSwapLong(this, valueOffset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapLong;
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
                        UNSAFE = Unsafe.getUnsafe();
                        BytecodeManager.incBytecodes(1);
                        final Class<Cell> clazz = Cell.class;
                        BytecodeManager.incBytecodes(2);
                        final Unsafe unsafe = Cell.UNSAFE;
                        final Class<Cell> clazz2 = clazz;
                        final String name = "value";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField = clazz2.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        valueOffset = unsafe.objectFieldOffset(declaredField);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (Exception ex) {
                        BytecodeManager.incBytecodes(501);
                        final Exception cause = ex;
                        BytecodeManager.incBytecodes(4);
                        final Error error = new Error(cause);
                        BytecodeManager.incBytecodes(1);
                        throw error;
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
