// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

final class DualPivotQuicksort
{
    private static final int MAX_RUN_COUNT = 67;
    private static final int MAX_RUN_LENGTH = 33;
    private static final int QUICKSORT_THRESHOLD = 286;
    private static final int INSERTION_SORT_THRESHOLD = 47;
    private static final int COUNTING_SORT_THRESHOLD_FOR_BYTE = 29;
    private static final int COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR = 3200;
    private static final int NUM_SHORT_VALUES = 65536;
    private static final int NUM_CHAR_VALUES = 65536;
    private static final int NUM_BYTE_VALUES = 256;
    
    private DualPivotQuicksort() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(int[] array, final int n, int n2, int[] array2, int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 286;
            BytecodeManager.incBytecodes(5);
            if (n5 < n6) {
                final int[] array3 = array;
                final int n7 = n2;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                sort(array3, n, n7, b);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int[] array4 = new int[68];
            BytecodeManager.incBytecodes(2);
            int n8 = 0;
            array4[0] = n;
            BytecodeManager.incBytecodes(6);
            int n9 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n2;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = array4[n8];
                    final int n13 = n2++;
                    BytecodeManager.incBytecodes(6);
                    if (n12 == n13) {
                        array4[++n8] = n2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        final int n14 = n8;
                        final int n15 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n14 == n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    byte b2 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n16 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        n16 <<= 1;
                        final int n17 = n8;
                        BytecodeManager.incBytecodes(7);
                        if (n16 >= n17) {
                            break;
                        }
                        b2 ^= 0x1;
                        BytecodeManager.incBytecodes(6);
                    }
                    final int n18 = n2 - n;
                    BytecodeManager.incBytecodes(4);
                    final int[] array5 = array2;
                    BytecodeManager.incBytecodes(2);
                    Label_0551: {
                        if (array5 != null) {
                            final int n19 = n18;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n19) {
                                final int n20 = n3 + n18;
                                final int length = array2.length;
                                BytecodeManager.incBytecodes(6);
                                if (n20 <= length) {
                                    break Label_0551;
                                }
                            }
                        }
                        array2 = new int[n18];
                        BytecodeManager.incBytecodes(2);
                        n3 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    int[] array8;
                    int n23;
                    int n24;
                    if (b3 == 0) {
                        final int[] array6 = array;
                        final int[] array7 = array2;
                        final int n21 = n3;
                        final int n22 = n18;
                        BytecodeManager.incBytecodes(6);
                        System.arraycopy(array6, n, array7, n21, n22);
                        array8 = array;
                        BytecodeManager.incBytecodes(2);
                        n23 = 0;
                        BytecodeManager.incBytecodes(2);
                        array = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = n3 - n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        array8 = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = 0;
                        BytecodeManager.incBytecodes(2);
                        n23 = n3 - n;
                        BytecodeManager.incBytecodes(4);
                    }
                    while (true) {
                        final int n25 = n8;
                        final int n26 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n25 <= n26) {
                            break;
                        }
                        int n28;
                        int n27 = (n28 = 0) + 2;
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            final int n29 = n27;
                            final int n30 = n8;
                            BytecodeManager.incBytecodes(3);
                            if (n29 > n30) {
                                break;
                            }
                            final int n31 = array4[n27];
                            final int n32 = array4[n27 - 1];
                            BytecodeManager.incBytecodes(10);
                            int n34;
                            int n33 = n34 = array4[n27 - 2];
                            int n35 = n32;
                            BytecodeManager.incBytecodes(10);
                            while (true) {
                                final int n36 = n33;
                                final int n37 = n31;
                                BytecodeManager.incBytecodes(3);
                                if (n36 >= n37) {
                                    break;
                                }
                                final int n38 = n35;
                                final int n39 = n31;
                                BytecodeManager.incBytecodes(3);
                                Label_0826: {
                                    Label_0777: {
                                        if (n38 < n39) {
                                            final int n40 = n34;
                                            final int n41 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n40 < n41) {
                                                final int n42 = array[n34 + n24];
                                                final int n43 = array[n35 + n24];
                                                BytecodeManager.incBytecodes(11);
                                                if (n42 <= n43) {
                                                    break Label_0777;
                                                }
                                            }
                                            array8[n33 + n23] = array[n35++ + n24];
                                            BytecodeManager.incBytecodes(11);
                                            break Label_0826;
                                        }
                                    }
                                    array8[n33 + n23] = array[n34++ + n24];
                                    BytecodeManager.incBytecodes(12);
                                }
                                ++n33;
                                BytecodeManager.incBytecodes(2);
                            }
                            array4[++n28] = n31;
                            BytecodeManager.incBytecodes(5);
                            n27 += 2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n44 = n8 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n44 != 0) {
                            int n45 = n2;
                            final int n46 = array4[n8 - 1];
                            BytecodeManager.incBytecodes(8);
                            while (true) {
                                final int n47 = --n45;
                                final int n48 = n46;
                                BytecodeManager.incBytecodes(4);
                                if (n47 < n48) {
                                    break;
                                }
                                array8[n45 + n23] = array[n45 + n24];
                                BytecodeManager.incBytecodes(11);
                            }
                            array4[++n28] = n2;
                            BytecodeManager.incBytecodes(5);
                        }
                        final int[] array9 = array;
                        array = array8;
                        array8 = array9;
                        BytecodeManager.incBytecodes(6);
                        final int n49 = n24;
                        n24 = n23;
                        n23 = n49;
                        BytecodeManager.incBytecodes(6);
                        n8 = n28;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final int n50 = array[n9];
                final int n51 = array[n9 + 1];
                BytecodeManager.incBytecodes(9);
                Label_0340: {
                    if (n50 < n51) {
                        while (true) {
                            final int n52 = ++n9;
                            final int n53 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n52 > n53) {
                                break;
                            }
                            final int n54 = array[n9 - 1];
                            final int n55 = array[n9];
                            BytecodeManager.incBytecodes(9);
                            if (n54 > n55) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final int n56 = array[n9];
                        final int n57 = array[n9 + 1];
                        BytecodeManager.incBytecodes(9);
                        if (n56 <= n57) {
                            int n58 = 33;
                            BytecodeManager.incBytecodes(2);
                            int i;
                            do {
                                final int n59 = ++n9;
                                final int n60 = n2;
                                BytecodeManager.incBytecodes(4);
                                if (n59 > n60) {
                                    break Label_0340;
                                }
                                final int n61 = array[n9 - 1];
                                final int n62 = array[n9];
                                BytecodeManager.incBytecodes(9);
                                if (n61 != n62) {
                                    break Label_0340;
                                }
                                i = --n58;
                                BytecodeManager.incBytecodes(3);
                            } while (i != 0);
                            final int[] array10 = array;
                            final int n63 = n2;
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(5);
                            sort(array10, n, n63, b4);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        while (true) {
                            final int n64 = ++n9;
                            final int n65 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n64 > n65) {
                                break;
                            }
                            final int n66 = array[n9 - 1];
                            final int n67 = array[n9];
                            BytecodeManager.incBytecodes(9);
                            if (n66 < n67) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        int n68 = array4[n8] - 1;
                        int n69 = n9;
                        BytecodeManager.incBytecodes(8);
                        while (true) {
                            final int n70 = ++n68;
                            final int n71 = --n69;
                            BytecodeManager.incBytecodes(5);
                            if (n70 >= n71) {
                                break;
                            }
                            final int n72 = array[n68];
                            array[n68] = array[n69];
                            array[n69] = n72;
                            BytecodeManager.incBytecodes(14);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n73 = ++n8;
                final int n74 = 67;
                BytecodeManager.incBytecodes(4);
                if (n73 == n74) {
                    final int[] array11 = array;
                    final int n75 = n2;
                    final boolean b5 = true;
                    BytecodeManager.incBytecodes(5);
                    sort(array11, n, n75, b5);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                array4[n8] = n9;
                BytecodeManager.incBytecodes(5);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void sort(final int[] array, int n, int n2, final boolean b) {
        try {
            final int n3 = n2 - n + 1;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3;
            final int n5 = 47;
            BytecodeManager.incBytecodes(3);
            if (n4 < n5) {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    int n7;
                    int n6 = n7 = n;
                    BytecodeManager.incBytecodes(4);
                Label_0045:
                    while (true) {
                        final int n8 = n6;
                        final int n9 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 < n9) {
                            final int n10 = array[n6 + 1];
                            BytecodeManager.incBytecodes(6);
                            while (true) {
                                int i;
                                int n11;
                                do {
                                    final int n12 = n10;
                                    final int n13 = array[n7];
                                    BytecodeManager.incBytecodes(5);
                                    if (n12 >= n13) {
                                        array[n7 + 1] = n10;
                                        BytecodeManager.incBytecodes(6);
                                        n7 = ++n6;
                                        BytecodeManager.incBytecodes(4);
                                        continue Label_0045;
                                    }
                                    array[n7 + 1] = array[n7];
                                    BytecodeManager.incBytecodes(8);
                                    i = n7--;
                                    n11 = n;
                                    BytecodeManager.incBytecodes(4);
                                } while (i != n11);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    int j;
                    int n14;
                    do {
                        final int n15 = n;
                        final int n16 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n15 >= n16) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        j = array[++n];
                        n14 = array[n - 1];
                        BytecodeManager.incBytecodes(10);
                    } while (j >= n14);
                    int n17 = n;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n18 = ++n;
                        final int n19 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (n18 > n19) {
                            break;
                        }
                        int n20 = array[n17];
                        int n21 = array[n];
                        BytecodeManager.incBytecodes(8);
                        final int n22 = n20;
                        final int n23 = n21;
                        BytecodeManager.incBytecodes(3);
                        if (n22 < n23) {
                            n21 = n20;
                            n20 = array[n];
                            BytecodeManager.incBytecodes(6);
                        }
                        while (true) {
                            final int n24 = n20;
                            final int n25 = array[--n17];
                            BytecodeManager.incBytecodes(6);
                            if (n24 >= n25) {
                                break;
                            }
                            array[n17 + 2] = array[n17];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[++n17 + 1] = n20;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final int n26 = n21;
                            final int n27 = array[--n17];
                            BytecodeManager.incBytecodes(6);
                            if (n26 >= n27) {
                                break;
                            }
                            array[n17 + 1] = array[n17];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[n17 + 1] = n21;
                        BytecodeManager.incBytecodes(6);
                        n17 = ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                    final int n28 = array[n2];
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n29 = n28;
                        final int n30 = array[--n2];
                        BytecodeManager.incBytecodes(6);
                        if (n29 >= n30) {
                            break;
                        }
                        array[n2 + 1] = array[n2];
                        BytecodeManager.incBytecodes(9);
                    }
                    array[n2 + 1] = n28;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n31 = (n3 >> 3) + (n3 >> 6) + 1;
            BytecodeManager.incBytecodes(10);
            final int n32 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n33 = n32 - n31;
            BytecodeManager.incBytecodes(4);
            final int n34 = n33 - n31;
            BytecodeManager.incBytecodes(4);
            final int n35 = n32 + n31;
            BytecodeManager.incBytecodes(4);
            final int n36 = n35 + n31;
            BytecodeManager.incBytecodes(4);
            final int n37 = array[n33];
            final int n38 = array[n34];
            BytecodeManager.incBytecodes(7);
            if (n37 < n38) {
                final int n39 = array[n33];
                array[n33] = array[n34];
                array[n34] = n39;
                BytecodeManager.incBytecodes(14);
            }
            final int n40 = array[n32];
            final int n41 = array[n33];
            BytecodeManager.incBytecodes(7);
            if (n40 < n41) {
                final int n42 = array[n32];
                array[n32] = array[n33];
                array[n33] = n42;
                BytecodeManager.incBytecodes(14);
                final int n43 = n42;
                final int n44 = array[n34];
                BytecodeManager.incBytecodes(5);
                if (n43 < n44) {
                    array[n33] = array[n34];
                    array[n34] = n42;
                    BytecodeManager.incBytecodes(10);
                }
            }
            final int n45 = array[n35];
            final int n46 = array[n32];
            BytecodeManager.incBytecodes(7);
            if (n45 < n46) {
                final int n47 = array[n35];
                array[n35] = array[n32];
                array[n32] = n47;
                BytecodeManager.incBytecodes(14);
                final int n48 = n47;
                final int n49 = array[n33];
                BytecodeManager.incBytecodes(5);
                if (n48 < n49) {
                    array[n32] = array[n33];
                    array[n33] = n47;
                    BytecodeManager.incBytecodes(10);
                    final int n50 = n47;
                    final int n51 = array[n34];
                    BytecodeManager.incBytecodes(5);
                    if (n50 < n51) {
                        array[n33] = array[n34];
                        array[n34] = n47;
                        BytecodeManager.incBytecodes(10);
                    }
                }
            }
            final int n52 = array[n36];
            final int n53 = array[n35];
            BytecodeManager.incBytecodes(7);
            if (n52 < n53) {
                final int n54 = array[n36];
                array[n36] = array[n35];
                array[n35] = n54;
                BytecodeManager.incBytecodes(14);
                final int n55 = n54;
                final int n56 = array[n32];
                BytecodeManager.incBytecodes(5);
                if (n55 < n56) {
                    array[n35] = array[n32];
                    array[n32] = n54;
                    BytecodeManager.incBytecodes(10);
                    final int n57 = n54;
                    final int n58 = array[n33];
                    BytecodeManager.incBytecodes(5);
                    if (n57 < n58) {
                        array[n32] = array[n33];
                        array[n33] = n54;
                        BytecodeManager.incBytecodes(10);
                        final int n59 = n54;
                        final int n60 = array[n34];
                        BytecodeManager.incBytecodes(5);
                        if (n59 < n60) {
                            array[n33] = array[n34];
                            array[n34] = n54;
                            BytecodeManager.incBytecodes(10);
                        }
                    }
                }
            }
            int n61 = n;
            BytecodeManager.incBytecodes(2);
            int n62 = n2;
            BytecodeManager.incBytecodes(2);
            final int n63 = array[n34];
            final int n64 = array[n33];
            BytecodeManager.incBytecodes(7);
            Label_1919: {
                if (n63 != n64) {
                    final int n65 = array[n33];
                    final int n66 = array[n32];
                    BytecodeManager.incBytecodes(7);
                    if (n65 != n66) {
                        final int n67 = array[n32];
                        final int n68 = array[n35];
                        BytecodeManager.incBytecodes(7);
                        if (n67 != n68) {
                            final int n69 = array[n35];
                            final int n70 = array[n36];
                            BytecodeManager.incBytecodes(7);
                            if (n69 != n70) {
                                final int n71 = array[n33];
                                BytecodeManager.incBytecodes(4);
                                final int n72 = array[n35];
                                BytecodeManager.incBytecodes(4);
                                array[n33] = array[n];
                                BytecodeManager.incBytecodes(6);
                                array[n35] = array[n2];
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final int n73 = array[++n61];
                                    final int n74 = n71;
                                    BytecodeManager.incBytecodes(6);
                                    if (n73 >= n74) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                while (true) {
                                    final int n75 = array[--n62];
                                    final int n76 = n72;
                                    BytecodeManager.incBytecodes(6);
                                    if (n75 <= n76) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                int n77 = n61 - 1;
                                BytecodeManager.incBytecodes(4);
                                while (true) {
                                    final int n78 = ++n77;
                                    final int n79 = n62;
                                    BytecodeManager.incBytecodes(4);
                                    if (n78 > n79) {
                                        break;
                                    }
                                    final int n80 = array[n77];
                                    BytecodeManager.incBytecodes(4);
                                    final int n81 = n80;
                                    final int n82 = n71;
                                    BytecodeManager.incBytecodes(3);
                                    Label_1260: {
                                        if (n81 < n82) {
                                            array[n77] = array[n61];
                                            BytecodeManager.incBytecodes(6);
                                            array[n61] = n80;
                                            BytecodeManager.incBytecodes(4);
                                            ++n61;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final int n83 = n80;
                                            final int n84 = n72;
                                            BytecodeManager.incBytecodes(3);
                                            if (n83 > n84) {
                                                int k;
                                                int n85;
                                                do {
                                                    final int n86 = array[n62];
                                                    final int n87 = n72;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (n86 <= n87) {
                                                        final int n88 = array[n62];
                                                        final int n89 = n71;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (n88 < n89) {
                                                            array[n77] = array[n61];
                                                            BytecodeManager.incBytecodes(6);
                                                            array[n61] = array[n62];
                                                            BytecodeManager.incBytecodes(6);
                                                            ++n61;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            array[n77] = array[n62];
                                                            BytecodeManager.incBytecodes(6);
                                                        }
                                                        array[n62] = n80;
                                                        BytecodeManager.incBytecodes(4);
                                                        --n62;
                                                        BytecodeManager.incBytecodes(1);
                                                        break Label_1260;
                                                    }
                                                    k = n62--;
                                                    n85 = n77;
                                                    BytecodeManager.incBytecodes(4);
                                                } while (k != n85);
                                                BytecodeManager.incBytecodes(1);
                                                break;
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                array[n] = array[n61 - 1];
                                array[n61 - 1] = n71;
                                BytecodeManager.incBytecodes(14);
                                array[n2] = array[n62 + 1];
                                array[n62 + 1] = n72;
                                BytecodeManager.incBytecodes(14);
                                final int n90 = n;
                                final int n91 = n61 - 2;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n90, n91, b);
                                final int n92 = n62 + 2;
                                final int n93 = n2;
                                final boolean b2 = false;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n92, n93, b2);
                                final int n94 = n61;
                                final int n95 = n34;
                                BytecodeManager.incBytecodes(3);
                                if (n94 < n95) {
                                    final int n96 = n36;
                                    final int n97 = n62;
                                    BytecodeManager.incBytecodes(3);
                                    if (n96 < n97) {
                                        while (true) {
                                            final int n98 = array[n61];
                                            final int n99 = n71;
                                            BytecodeManager.incBytecodes(5);
                                            if (n98 != n99) {
                                                break;
                                            }
                                            ++n61;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        while (true) {
                                            final int n100 = array[n62];
                                            final int n101 = n72;
                                            BytecodeManager.incBytecodes(5);
                                            if (n100 != n101) {
                                                break;
                                            }
                                            --n62;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        int n102 = n61 - 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n103 = ++n102;
                                            final int n104 = n62;
                                            BytecodeManager.incBytecodes(4);
                                            if (n103 > n104) {
                                                break;
                                            }
                                            final int n105 = array[n102];
                                            BytecodeManager.incBytecodes(4);
                                            final int n106 = n105;
                                            final int n107 = n71;
                                            BytecodeManager.incBytecodes(3);
                                            Label_1630: {
                                                if (n106 == n107) {
                                                    array[n102] = array[n61];
                                                    BytecodeManager.incBytecodes(6);
                                                    array[n61] = n105;
                                                    BytecodeManager.incBytecodes(4);
                                                    ++n61;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final int n108 = n105;
                                                    final int n109 = n72;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n108 == n109) {
                                                        int l;
                                                        int n110;
                                                        do {
                                                            final int n111 = array[n62];
                                                            final int n112 = n72;
                                                            BytecodeManager.incBytecodes(5);
                                                            if (n111 != n112) {
                                                                final int n113 = array[n62];
                                                                final int n114 = n71;
                                                                BytecodeManager.incBytecodes(5);
                                                                if (n113 == n114) {
                                                                    array[n102] = array[n61];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    array[n61] = n71;
                                                                    BytecodeManager.incBytecodes(4);
                                                                    ++n61;
                                                                    BytecodeManager.incBytecodes(2);
                                                                }
                                                                else {
                                                                    array[n102] = array[n62];
                                                                    BytecodeManager.incBytecodes(6);
                                                                }
                                                                array[n62] = n105;
                                                                BytecodeManager.incBytecodes(4);
                                                                --n62;
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_1630;
                                                            }
                                                            l = n62--;
                                                            n110 = n102;
                                                            BytecodeManager.incBytecodes(4);
                                                        } while (l != n110);
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                }
                                            }
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                }
                                final int n115 = n61;
                                final int n116 = n62;
                                final boolean b3 = false;
                                BytecodeManager.incBytecodes(5);
                                sort(array, n115, n116, b3);
                                BytecodeManager.incBytecodes(1);
                                break Label_1919;
                            }
                        }
                    }
                }
                final int n117 = array[n32];
                BytecodeManager.incBytecodes(4);
                int n118 = n61;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n119 = n118;
                    final int n120 = n62;
                    BytecodeManager.incBytecodes(3);
                    if (n119 > n120) {
                        break;
                    }
                    final int n121 = array[n118];
                    final int n122 = n117;
                    BytecodeManager.incBytecodes(5);
                    if (n121 == n122) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n123 = array[n118];
                        BytecodeManager.incBytecodes(4);
                        final int n124 = n123;
                        final int n125 = n117;
                        BytecodeManager.incBytecodes(3);
                        if (n124 < n125) {
                            array[n118] = array[n61];
                            BytecodeManager.incBytecodes(6);
                            array[n61] = n123;
                            BytecodeManager.incBytecodes(4);
                            ++n61;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            while (true) {
                                final int n126 = array[n62];
                                final int n127 = n117;
                                BytecodeManager.incBytecodes(5);
                                if (n126 <= n127) {
                                    break;
                                }
                                --n62;
                                BytecodeManager.incBytecodes(2);
                            }
                            final int n128 = array[n62];
                            final int n129 = n117;
                            BytecodeManager.incBytecodes(5);
                            if (n128 < n129) {
                                array[n118] = array[n61];
                                BytecodeManager.incBytecodes(6);
                                array[n61] = array[n62];
                                BytecodeManager.incBytecodes(6);
                                ++n61;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                array[n118] = n117;
                                BytecodeManager.incBytecodes(4);
                            }
                            array[n62] = n123;
                            BytecodeManager.incBytecodes(4);
                            --n62;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    ++n118;
                    BytecodeManager.incBytecodes(2);
                }
                final int n130 = n;
                final int n131 = n61 - 1;
                BytecodeManager.incBytecodes(7);
                sort(array, n130, n131, b);
                final int n132 = n62 + 1;
                final int n133 = n2;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(7);
                sort(array, n132, n133, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(long[] array, final int n, int n2, long[] array2, int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 286;
            BytecodeManager.incBytecodes(5);
            if (n5 < n6) {
                final long[] array3 = array;
                final int n7 = n2;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                sort(array3, n, n7, b);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int[] array4 = new int[68];
            BytecodeManager.incBytecodes(2);
            int n8 = 0;
            array4[0] = n;
            BytecodeManager.incBytecodes(6);
            int n9 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n2;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = array4[n8];
                    final int n13 = n2++;
                    BytecodeManager.incBytecodes(6);
                    if (n12 == n13) {
                        array4[++n8] = n2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        final int n14 = n8;
                        final int n15 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n14 == n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    byte b2 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n16 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        n16 <<= 1;
                        final int n17 = n8;
                        BytecodeManager.incBytecodes(7);
                        if (n16 >= n17) {
                            break;
                        }
                        b2 ^= 0x1;
                        BytecodeManager.incBytecodes(6);
                    }
                    final int n18 = n2 - n;
                    BytecodeManager.incBytecodes(4);
                    final long[] array5 = array2;
                    BytecodeManager.incBytecodes(2);
                    Label_0556: {
                        if (array5 != null) {
                            final int n19 = n18;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n19) {
                                final int n20 = n3 + n18;
                                final int length = array2.length;
                                BytecodeManager.incBytecodes(6);
                                if (n20 <= length) {
                                    break Label_0556;
                                }
                            }
                        }
                        array2 = new long[n18];
                        BytecodeManager.incBytecodes(2);
                        n3 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    long[] array8;
                    int n23;
                    int n24;
                    if (b3 == 0) {
                        final long[] array6 = array;
                        final long[] array7 = array2;
                        final int n21 = n3;
                        final int n22 = n18;
                        BytecodeManager.incBytecodes(6);
                        System.arraycopy(array6, n, array7, n21, n22);
                        array8 = array;
                        BytecodeManager.incBytecodes(2);
                        n23 = 0;
                        BytecodeManager.incBytecodes(2);
                        array = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = n3 - n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        array8 = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = 0;
                        BytecodeManager.incBytecodes(2);
                        n23 = n3 - n;
                        BytecodeManager.incBytecodes(4);
                    }
                    while (true) {
                        final int n25 = n8;
                        final int n26 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n25 <= n26) {
                            break;
                        }
                        int n28;
                        int n27 = (n28 = 0) + 2;
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            final int n29 = n27;
                            final int n30 = n8;
                            BytecodeManager.incBytecodes(3);
                            if (n29 > n30) {
                                break;
                            }
                            final int n31 = array4[n27];
                            final int n32 = array4[n27 - 1];
                            BytecodeManager.incBytecodes(10);
                            int n34;
                            int n33 = n34 = array4[n27 - 2];
                            int n35 = n32;
                            BytecodeManager.incBytecodes(10);
                            while (true) {
                                final int n36 = n33;
                                final int n37 = n31;
                                BytecodeManager.incBytecodes(3);
                                if (n36 >= n37) {
                                    break;
                                }
                                final int n38 = n35;
                                final int n39 = n31;
                                BytecodeManager.incBytecodes(3);
                                Label_0832: {
                                    Label_0783: {
                                        if (n38 < n39) {
                                            final int n40 = n34;
                                            final int n41 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n40 < n41) {
                                                final long n42 = lcmp(array[n34 + n24], array[n35 + n24]);
                                                BytecodeManager.incBytecodes(12);
                                                if (n42 <= 0) {
                                                    break Label_0783;
                                                }
                                            }
                                            array8[n33 + n23] = array[n35++ + n24];
                                            BytecodeManager.incBytecodes(11);
                                            break Label_0832;
                                        }
                                    }
                                    array8[n33 + n23] = array[n34++ + n24];
                                    BytecodeManager.incBytecodes(12);
                                }
                                ++n33;
                                BytecodeManager.incBytecodes(2);
                            }
                            array4[++n28] = n31;
                            BytecodeManager.incBytecodes(5);
                            n27 += 2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n43 = n8 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n43 != 0) {
                            int n44 = n2;
                            final int n45 = array4[n8 - 1];
                            BytecodeManager.incBytecodes(8);
                            while (true) {
                                final int n46 = --n44;
                                final int n47 = n45;
                                BytecodeManager.incBytecodes(4);
                                if (n46 < n47) {
                                    break;
                                }
                                array8[n44 + n23] = array[n44 + n24];
                                BytecodeManager.incBytecodes(11);
                            }
                            array4[++n28] = n2;
                            BytecodeManager.incBytecodes(5);
                        }
                        final long[] array9 = array;
                        array = array8;
                        array8 = array9;
                        BytecodeManager.incBytecodes(6);
                        final int n48 = n24;
                        n24 = n23;
                        n23 = n48;
                        BytecodeManager.incBytecodes(6);
                        n8 = n28;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final long n49 = lcmp(array[n9], array[n9 + 1]);
                BytecodeManager.incBytecodes(10);
                Label_0345: {
                    if (n49 < 0) {
                        while (true) {
                            final int n50 = ++n9;
                            final int n51 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n50 > n51) {
                                break;
                            }
                            final long n52 = lcmp(array[n9 - 1], array[n9]);
                            BytecodeManager.incBytecodes(10);
                            if (n52 > 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final long n53 = lcmp(array[n9], array[n9 + 1]);
                        BytecodeManager.incBytecodes(10);
                        if (n53 <= 0) {
                            int n54 = 33;
                            BytecodeManager.incBytecodes(2);
                            int i;
                            do {
                                final int n55 = ++n9;
                                final int n56 = n2;
                                BytecodeManager.incBytecodes(4);
                                if (n55 > n56) {
                                    break Label_0345;
                                }
                                final long n57 = lcmp(array[n9 - 1], array[n9]);
                                BytecodeManager.incBytecodes(10);
                                if (n57 != 0) {
                                    break Label_0345;
                                }
                                i = --n54;
                                BytecodeManager.incBytecodes(3);
                            } while (i != 0);
                            final long[] array10 = array;
                            final int n58 = n2;
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(5);
                            sort(array10, n, n58, b4);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        while (true) {
                            final int n59 = ++n9;
                            final int n60 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n59 > n60) {
                                break;
                            }
                            final long n61 = lcmp(array[n9 - 1], array[n9]);
                            BytecodeManager.incBytecodes(10);
                            if (n61 < 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        int n62 = array4[n8] - 1;
                        int n63 = n9;
                        BytecodeManager.incBytecodes(8);
                        while (true) {
                            final int n64 = ++n62;
                            final int n65 = --n63;
                            BytecodeManager.incBytecodes(5);
                            if (n64 >= n65) {
                                break;
                            }
                            final long n66 = array[n62];
                            array[n62] = array[n63];
                            array[n63] = n66;
                            BytecodeManager.incBytecodes(14);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n67 = ++n8;
                final int n68 = 67;
                BytecodeManager.incBytecodes(4);
                if (n67 == n68) {
                    final long[] array11 = array;
                    final int n69 = n2;
                    final boolean b5 = true;
                    BytecodeManager.incBytecodes(5);
                    sort(array11, n, n69, b5);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                array4[n8] = n9;
                BytecodeManager.incBytecodes(5);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void sort(final long[] array, int n, int n2, final boolean b) {
        try {
            final int n3 = n2 - n + 1;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3;
            final int n5 = 47;
            BytecodeManager.incBytecodes(3);
            if (n4 < n5) {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    int n7;
                    int n6 = n7 = n;
                    BytecodeManager.incBytecodes(4);
                Label_0045:
                    while (true) {
                        final int n8 = n6;
                        final int n9 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 < n9) {
                            final long n10 = array[n6 + 1];
                            BytecodeManager.incBytecodes(6);
                            while (true) {
                                int i;
                                int n11;
                                do {
                                    final long n12 = lcmp(n10, array[n7]);
                                    BytecodeManager.incBytecodes(6);
                                    if (n12 >= 0) {
                                        array[n7 + 1] = n10;
                                        BytecodeManager.incBytecodes(6);
                                        n7 = ++n6;
                                        BytecodeManager.incBytecodes(4);
                                        continue Label_0045;
                                    }
                                    array[n7 + 1] = array[n7];
                                    BytecodeManager.incBytecodes(8);
                                    i = n7--;
                                    n11 = n;
                                    BytecodeManager.incBytecodes(4);
                                } while (i != n11);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    long n13;
                    do {
                        final int n14 = n;
                        final int n15 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n14 >= n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        n13 = lcmp(array[++n], array[n - 1]);
                        BytecodeManager.incBytecodes(11);
                    } while (n13 >= 0);
                    int n16 = n;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n17 = ++n;
                        final int n18 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (n17 > n18) {
                            break;
                        }
                        long n19 = array[n16];
                        long n20 = array[n];
                        BytecodeManager.incBytecodes(8);
                        final long n21 = lcmp(n19, n20);
                        BytecodeManager.incBytecodes(4);
                        if (n21 < 0) {
                            n20 = n19;
                            n19 = array[n];
                            BytecodeManager.incBytecodes(6);
                        }
                        while (true) {
                            final long n22 = lcmp(n19, array[--n16]);
                            BytecodeManager.incBytecodes(7);
                            if (n22 >= 0) {
                                break;
                            }
                            array[n16 + 2] = array[n16];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[++n16 + 1] = n19;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final long n23 = lcmp(n20, array[--n16]);
                            BytecodeManager.incBytecodes(7);
                            if (n23 >= 0) {
                                break;
                            }
                            array[n16 + 1] = array[n16];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[n16 + 1] = n20;
                        BytecodeManager.incBytecodes(6);
                        n16 = ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                    final long n24 = array[n2];
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final long n25 = lcmp(n24, array[--n2]);
                        BytecodeManager.incBytecodes(7);
                        if (n25 >= 0) {
                            break;
                        }
                        array[n2 + 1] = array[n2];
                        BytecodeManager.incBytecodes(9);
                    }
                    array[n2 + 1] = n24;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n26 = (n3 >> 3) + (n3 >> 6) + 1;
            BytecodeManager.incBytecodes(10);
            final int n27 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n28 = n27 - n26;
            BytecodeManager.incBytecodes(4);
            final int n29 = n28 - n26;
            BytecodeManager.incBytecodes(4);
            final int n30 = n27 + n26;
            BytecodeManager.incBytecodes(4);
            final int n31 = n30 + n26;
            BytecodeManager.incBytecodes(4);
            final long n32 = lcmp(array[n28], array[n29]);
            BytecodeManager.incBytecodes(8);
            if (n32 < 0) {
                final long n33 = array[n28];
                array[n28] = array[n29];
                array[n29] = n33;
                BytecodeManager.incBytecodes(14);
            }
            final long n34 = lcmp(array[n27], array[n28]);
            BytecodeManager.incBytecodes(8);
            if (n34 < 0) {
                final long n35 = array[n27];
                array[n27] = array[n28];
                array[n28] = n35;
                BytecodeManager.incBytecodes(14);
                final long n36 = lcmp(n35, array[n29]);
                BytecodeManager.incBytecodes(6);
                if (n36 < 0) {
                    array[n28] = array[n29];
                    array[n29] = n35;
                    BytecodeManager.incBytecodes(10);
                }
            }
            final long n37 = lcmp(array[n30], array[n27]);
            BytecodeManager.incBytecodes(8);
            if (n37 < 0) {
                final long n38 = array[n30];
                array[n30] = array[n27];
                array[n27] = n38;
                BytecodeManager.incBytecodes(14);
                final long n39 = lcmp(n38, array[n28]);
                BytecodeManager.incBytecodes(6);
                if (n39 < 0) {
                    array[n27] = array[n28];
                    array[n28] = n38;
                    BytecodeManager.incBytecodes(10);
                    final long n40 = lcmp(n38, array[n29]);
                    BytecodeManager.incBytecodes(6);
                    if (n40 < 0) {
                        array[n28] = array[n29];
                        array[n29] = n38;
                        BytecodeManager.incBytecodes(10);
                    }
                }
            }
            final long n41 = lcmp(array[n31], array[n30]);
            BytecodeManager.incBytecodes(8);
            if (n41 < 0) {
                final long n42 = array[n31];
                array[n31] = array[n30];
                array[n30] = n42;
                BytecodeManager.incBytecodes(14);
                final long n43 = lcmp(n42, array[n27]);
                BytecodeManager.incBytecodes(6);
                if (n43 < 0) {
                    array[n30] = array[n27];
                    array[n27] = n42;
                    BytecodeManager.incBytecodes(10);
                    final long n44 = lcmp(n42, array[n28]);
                    BytecodeManager.incBytecodes(6);
                    if (n44 < 0) {
                        array[n27] = array[n28];
                        array[n28] = n42;
                        BytecodeManager.incBytecodes(10);
                        final long n45 = lcmp(n42, array[n29]);
                        BytecodeManager.incBytecodes(6);
                        if (n45 < 0) {
                            array[n28] = array[n29];
                            array[n29] = n42;
                            BytecodeManager.incBytecodes(10);
                        }
                    }
                }
            }
            int n46 = n;
            BytecodeManager.incBytecodes(2);
            int n47 = n2;
            BytecodeManager.incBytecodes(2);
            final long n48 = lcmp(array[n29], array[n28]);
            BytecodeManager.incBytecodes(8);
            Label_1955: {
                if (n48 != 0) {
                    final long n49 = lcmp(array[n28], array[n27]);
                    BytecodeManager.incBytecodes(8);
                    if (n49 != 0) {
                        final long n50 = lcmp(array[n27], array[n30]);
                        BytecodeManager.incBytecodes(8);
                        if (n50 != 0) {
                            final long n51 = lcmp(array[n30], array[n31]);
                            BytecodeManager.incBytecodes(8);
                            if (n51 != 0) {
                                final long n52 = array[n28];
                                BytecodeManager.incBytecodes(4);
                                final long n53 = array[n30];
                                BytecodeManager.incBytecodes(4);
                                array[n28] = array[n];
                                BytecodeManager.incBytecodes(6);
                                array[n30] = array[n2];
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final long n54 = lcmp(array[++n46], n52);
                                    BytecodeManager.incBytecodes(7);
                                    if (n54 >= 0) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                while (true) {
                                    final long n55 = lcmp(array[--n47], n53);
                                    BytecodeManager.incBytecodes(7);
                                    if (n55 <= 0) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                int n56 = n46 - 1;
                                BytecodeManager.incBytecodes(4);
                                while (true) {
                                    final int n57 = ++n56;
                                    final int n58 = n47;
                                    BytecodeManager.incBytecodes(4);
                                    if (n57 > n58) {
                                        break;
                                    }
                                    final long n59 = array[n56];
                                    BytecodeManager.incBytecodes(4);
                                    final long n60 = lcmp(n59, n52);
                                    BytecodeManager.incBytecodes(4);
                                    Label_1286: {
                                        if (n60 < 0) {
                                            array[n56] = array[n46];
                                            BytecodeManager.incBytecodes(6);
                                            array[n46] = n59;
                                            BytecodeManager.incBytecodes(4);
                                            ++n46;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final long n61 = lcmp(n59, n53);
                                            BytecodeManager.incBytecodes(4);
                                            if (n61 > 0) {
                                                int j;
                                                int n62;
                                                do {
                                                    final long n63 = lcmp(array[n47], n53);
                                                    BytecodeManager.incBytecodes(6);
                                                    if (n63 <= 0) {
                                                        final long n64 = lcmp(array[n47], n52);
                                                        BytecodeManager.incBytecodes(6);
                                                        if (n64 < 0) {
                                                            array[n56] = array[n46];
                                                            BytecodeManager.incBytecodes(6);
                                                            array[n46] = array[n47];
                                                            BytecodeManager.incBytecodes(6);
                                                            ++n46;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            array[n56] = array[n47];
                                                            BytecodeManager.incBytecodes(6);
                                                        }
                                                        array[n47] = n59;
                                                        BytecodeManager.incBytecodes(4);
                                                        --n47;
                                                        BytecodeManager.incBytecodes(1);
                                                        break Label_1286;
                                                    }
                                                    j = n47--;
                                                    n62 = n56;
                                                    BytecodeManager.incBytecodes(4);
                                                } while (j != n62);
                                                BytecodeManager.incBytecodes(1);
                                                break;
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                array[n] = array[n46 - 1];
                                array[n46 - 1] = n52;
                                BytecodeManager.incBytecodes(14);
                                array[n2] = array[n47 + 1];
                                array[n47 + 1] = n53;
                                BytecodeManager.incBytecodes(14);
                                final int n65 = n;
                                final int n66 = n46 - 2;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n65, n66, b);
                                final int n67 = n47 + 2;
                                final int n68 = n2;
                                final boolean b2 = false;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n67, n68, b2);
                                final int n69 = n46;
                                final int n70 = n29;
                                BytecodeManager.incBytecodes(3);
                                if (n69 < n70) {
                                    final int n71 = n31;
                                    final int n72 = n47;
                                    BytecodeManager.incBytecodes(3);
                                    if (n71 < n72) {
                                        while (true) {
                                            final long n73 = lcmp(array[n46], n52);
                                            BytecodeManager.incBytecodes(6);
                                            if (n73 != 0) {
                                                break;
                                            }
                                            ++n46;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        while (true) {
                                            final long n74 = lcmp(array[n47], n53);
                                            BytecodeManager.incBytecodes(6);
                                            if (n74 != 0) {
                                                break;
                                            }
                                            --n47;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        int n75 = n46 - 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n76 = ++n75;
                                            final int n77 = n47;
                                            BytecodeManager.incBytecodes(4);
                                            if (n76 > n77) {
                                                break;
                                            }
                                            final long n78 = array[n75];
                                            BytecodeManager.incBytecodes(4);
                                            final long n79 = lcmp(n78, n52);
                                            BytecodeManager.incBytecodes(4);
                                            Label_1662: {
                                                if (n79 == 0) {
                                                    array[n75] = array[n46];
                                                    BytecodeManager.incBytecodes(6);
                                                    array[n46] = n78;
                                                    BytecodeManager.incBytecodes(4);
                                                    ++n46;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final long n80 = lcmp(n78, n53);
                                                    BytecodeManager.incBytecodes(4);
                                                    if (n80 == 0) {
                                                        int k;
                                                        int n81;
                                                        do {
                                                            final long n82 = lcmp(array[n47], n53);
                                                            BytecodeManager.incBytecodes(6);
                                                            if (n82 != 0) {
                                                                final long n83 = lcmp(array[n47], n52);
                                                                BytecodeManager.incBytecodes(6);
                                                                if (n83 == 0) {
                                                                    array[n75] = array[n46];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    array[n46] = n52;
                                                                    BytecodeManager.incBytecodes(4);
                                                                    ++n46;
                                                                    BytecodeManager.incBytecodes(2);
                                                                }
                                                                else {
                                                                    array[n75] = array[n47];
                                                                    BytecodeManager.incBytecodes(6);
                                                                }
                                                                array[n47] = n78;
                                                                BytecodeManager.incBytecodes(4);
                                                                --n47;
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_1662;
                                                            }
                                                            k = n47--;
                                                            n81 = n75;
                                                            BytecodeManager.incBytecodes(4);
                                                        } while (k != n81);
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                }
                                            }
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                }
                                final int n84 = n46;
                                final int n85 = n47;
                                final boolean b3 = false;
                                BytecodeManager.incBytecodes(5);
                                sort(array, n84, n85, b3);
                                BytecodeManager.incBytecodes(1);
                                break Label_1955;
                            }
                        }
                    }
                }
                final long n86 = array[n27];
                BytecodeManager.incBytecodes(4);
                int n87 = n46;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n88 = n87;
                    final int n89 = n47;
                    BytecodeManager.incBytecodes(3);
                    if (n88 > n89) {
                        break;
                    }
                    final long n90 = lcmp(array[n87], n86);
                    BytecodeManager.incBytecodes(6);
                    if (n90 == 0) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final long n91 = array[n87];
                        BytecodeManager.incBytecodes(4);
                        final long n92 = lcmp(n91, n86);
                        BytecodeManager.incBytecodes(4);
                        if (n92 < 0) {
                            array[n87] = array[n46];
                            BytecodeManager.incBytecodes(6);
                            array[n46] = n91;
                            BytecodeManager.incBytecodes(4);
                            ++n46;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            while (true) {
                                final long n93 = lcmp(array[n47], n86);
                                BytecodeManager.incBytecodes(6);
                                if (n93 <= 0) {
                                    break;
                                }
                                --n47;
                                BytecodeManager.incBytecodes(2);
                            }
                            final long n94 = lcmp(array[n47], n86);
                            BytecodeManager.incBytecodes(6);
                            if (n94 < 0) {
                                array[n87] = array[n46];
                                BytecodeManager.incBytecodes(6);
                                array[n46] = array[n47];
                                BytecodeManager.incBytecodes(6);
                                ++n46;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                array[n87] = n86;
                                BytecodeManager.incBytecodes(4);
                            }
                            array[n47] = n91;
                            BytecodeManager.incBytecodes(4);
                            --n47;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    ++n87;
                    BytecodeManager.incBytecodes(2);
                }
                final int n95 = n;
                final int n96 = n46 - 1;
                BytecodeManager.incBytecodes(7);
                sort(array, n95, n96, b);
                final int n97 = n47 + 1;
                final int n98 = n2;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(7);
                sort(array, n97, n98, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(final short[] array, final int n, final int n2, final short[] array2, final int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 3200;
            BytecodeManager.incBytecodes(5);
            if (n5 > n6) {
                final int[] array3 = new int[65536];
                BytecodeManager.incBytecodes(2);
                int n7 = n - 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n8 = ++n7;
                    BytecodeManager.incBytecodes(4);
                    if (n8 > n2) {
                        break;
                    }
                    final int[] array4 = array3;
                    final int n9 = array[n7] + 32768;
                    ++array4[n9];
                    BytecodeManager.incBytecodes(12);
                }
                int n10 = 65536;
                int n11 = n2 + 1;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final int n12 = n11;
                    BytecodeManager.incBytecodes(3);
                    if (n12 <= n) {
                        break;
                    }
                    while (true) {
                        final int n13 = array3[--n10];
                        BytecodeManager.incBytecodes(5);
                        if (n13 != 0) {
                            break;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final short n14 = (short)(n10 - 32768);
                    BytecodeManager.incBytecodes(5);
                    int n15 = array3[n10];
                    BytecodeManager.incBytecodes(4);
                    int i;
                    do {
                        array[--n11] = n14;
                        BytecodeManager.incBytecodes(5);
                        i = --n15;
                        BytecodeManager.incBytecodes(3);
                    } while (i > 0);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(7);
                doSort(array, n, n2, array2, n3, n4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void doSort(short[] array, final int n, int n2, short[] array2, int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 286;
            BytecodeManager.incBytecodes(5);
            if (n5 < n6) {
                final short[] array3 = array;
                final int n7 = n2;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                sort(array3, n, n7, b);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int[] array4 = new int[68];
            BytecodeManager.incBytecodes(2);
            int n8 = 0;
            array4[0] = n;
            BytecodeManager.incBytecodes(6);
            int n9 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n2;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = array4[n8];
                    final int n13 = n2++;
                    BytecodeManager.incBytecodes(6);
                    if (n12 == n13) {
                        array4[++n8] = n2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        final int n14 = n8;
                        final int n15 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n14 == n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    byte b2 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n16 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        n16 <<= 1;
                        final int n17 = n8;
                        BytecodeManager.incBytecodes(7);
                        if (n16 >= n17) {
                            break;
                        }
                        b2 ^= 0x1;
                        BytecodeManager.incBytecodes(6);
                    }
                    final int n18 = n2 - n;
                    BytecodeManager.incBytecodes(4);
                    final short[] array5 = array2;
                    BytecodeManager.incBytecodes(2);
                    Label_0551: {
                        if (array5 != null) {
                            final int n19 = n18;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n19) {
                                final int n20 = n3 + n18;
                                final int length = array2.length;
                                BytecodeManager.incBytecodes(6);
                                if (n20 <= length) {
                                    break Label_0551;
                                }
                            }
                        }
                        array2 = new short[n18];
                        BytecodeManager.incBytecodes(2);
                        n3 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    short[] array8;
                    int n23;
                    int n24;
                    if (b3 == 0) {
                        final short[] array6 = array;
                        final short[] array7 = array2;
                        final int n21 = n3;
                        final int n22 = n18;
                        BytecodeManager.incBytecodes(6);
                        System.arraycopy(array6, n, array7, n21, n22);
                        array8 = array;
                        BytecodeManager.incBytecodes(2);
                        n23 = 0;
                        BytecodeManager.incBytecodes(2);
                        array = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = n3 - n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        array8 = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = 0;
                        BytecodeManager.incBytecodes(2);
                        n23 = n3 - n;
                        BytecodeManager.incBytecodes(4);
                    }
                    while (true) {
                        final int n25 = n8;
                        final int n26 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n25 <= n26) {
                            break;
                        }
                        int n28;
                        int n27 = (n28 = 0) + 2;
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            final int n29 = n27;
                            final int n30 = n8;
                            BytecodeManager.incBytecodes(3);
                            if (n29 > n30) {
                                break;
                            }
                            final int n31 = array4[n27];
                            final int n32 = array4[n27 - 1];
                            BytecodeManager.incBytecodes(10);
                            int n34;
                            int n33 = n34 = array4[n27 - 2];
                            int n35 = n32;
                            BytecodeManager.incBytecodes(10);
                            while (true) {
                                final int n36 = n33;
                                final int n37 = n31;
                                BytecodeManager.incBytecodes(3);
                                if (n36 >= n37) {
                                    break;
                                }
                                final int n38 = n35;
                                final int n39 = n31;
                                BytecodeManager.incBytecodes(3);
                                Label_0826: {
                                    Label_0777: {
                                        if (n38 < n39) {
                                            final int n40 = n34;
                                            final int n41 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n40 < n41) {
                                                final short n42 = array[n34 + n24];
                                                final short n43 = array[n35 + n24];
                                                BytecodeManager.incBytecodes(11);
                                                if (n42 <= n43) {
                                                    break Label_0777;
                                                }
                                            }
                                            array8[n33 + n23] = array[n35++ + n24];
                                            BytecodeManager.incBytecodes(11);
                                            break Label_0826;
                                        }
                                    }
                                    array8[n33 + n23] = array[n34++ + n24];
                                    BytecodeManager.incBytecodes(12);
                                }
                                ++n33;
                                BytecodeManager.incBytecodes(2);
                            }
                            array4[++n28] = n31;
                            BytecodeManager.incBytecodes(5);
                            n27 += 2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n44 = n8 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n44 != 0) {
                            int n45 = n2;
                            final int n46 = array4[n8 - 1];
                            BytecodeManager.incBytecodes(8);
                            while (true) {
                                final int n47 = --n45;
                                final int n48 = n46;
                                BytecodeManager.incBytecodes(4);
                                if (n47 < n48) {
                                    break;
                                }
                                array8[n45 + n23] = array[n45 + n24];
                                BytecodeManager.incBytecodes(11);
                            }
                            array4[++n28] = n2;
                            BytecodeManager.incBytecodes(5);
                        }
                        final short[] array9 = array;
                        array = array8;
                        array8 = array9;
                        BytecodeManager.incBytecodes(6);
                        final int n49 = n24;
                        n24 = n23;
                        n23 = n49;
                        BytecodeManager.incBytecodes(6);
                        n8 = n28;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final short n50 = array[n9];
                final short n51 = array[n9 + 1];
                BytecodeManager.incBytecodes(9);
                Label_0340: {
                    if (n50 < n51) {
                        while (true) {
                            final int n52 = ++n9;
                            final int n53 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n52 > n53) {
                                break;
                            }
                            final short n54 = array[n9 - 1];
                            final short n55 = array[n9];
                            BytecodeManager.incBytecodes(9);
                            if (n54 > n55) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final short n56 = array[n9];
                        final short n57 = array[n9 + 1];
                        BytecodeManager.incBytecodes(9);
                        if (n56 <= n57) {
                            int n58 = 33;
                            BytecodeManager.incBytecodes(2);
                            int i;
                            do {
                                final int n59 = ++n9;
                                final int n60 = n2;
                                BytecodeManager.incBytecodes(4);
                                if (n59 > n60) {
                                    break Label_0340;
                                }
                                final short n61 = array[n9 - 1];
                                final short n62 = array[n9];
                                BytecodeManager.incBytecodes(9);
                                if (n61 != n62) {
                                    break Label_0340;
                                }
                                i = --n58;
                                BytecodeManager.incBytecodes(3);
                            } while (i != 0);
                            final short[] array10 = array;
                            final int n63 = n2;
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(5);
                            sort(array10, n, n63, b4);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        while (true) {
                            final int n64 = ++n9;
                            final int n65 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n64 > n65) {
                                break;
                            }
                            final short n66 = array[n9 - 1];
                            final short n67 = array[n9];
                            BytecodeManager.incBytecodes(9);
                            if (n66 < n67) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        int n68 = array4[n8] - 1;
                        int n69 = n9;
                        BytecodeManager.incBytecodes(8);
                        while (true) {
                            final int n70 = ++n68;
                            final int n71 = --n69;
                            BytecodeManager.incBytecodes(5);
                            if (n70 >= n71) {
                                break;
                            }
                            final short n72 = array[n68];
                            array[n68] = array[n69];
                            array[n69] = n72;
                            BytecodeManager.incBytecodes(14);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n73 = ++n8;
                final int n74 = 67;
                BytecodeManager.incBytecodes(4);
                if (n73 == n74) {
                    final short[] array11 = array;
                    final int n75 = n2;
                    final boolean b5 = true;
                    BytecodeManager.incBytecodes(5);
                    sort(array11, n, n75, b5);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                array4[n8] = n9;
                BytecodeManager.incBytecodes(5);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void sort(final short[] array, int n, int n2, final boolean b) {
        try {
            final int n3 = n2 - n + 1;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3;
            final int n5 = 47;
            BytecodeManager.incBytecodes(3);
            if (n4 < n5) {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    int n7;
                    int n6 = n7 = n;
                    BytecodeManager.incBytecodes(4);
                Label_0045:
                    while (true) {
                        final int n8 = n6;
                        final int n9 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 < n9) {
                            final short n10 = array[n6 + 1];
                            BytecodeManager.incBytecodes(6);
                            while (true) {
                                int i;
                                int n11;
                                do {
                                    final short n12 = n10;
                                    final short n13 = array[n7];
                                    BytecodeManager.incBytecodes(5);
                                    if (n12 >= n13) {
                                        array[n7 + 1] = n10;
                                        BytecodeManager.incBytecodes(6);
                                        n7 = ++n6;
                                        BytecodeManager.incBytecodes(4);
                                        continue Label_0045;
                                    }
                                    array[n7 + 1] = array[n7];
                                    BytecodeManager.incBytecodes(8);
                                    i = n7--;
                                    n11 = n;
                                    BytecodeManager.incBytecodes(4);
                                } while (i != n11);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    short n14;
                    short n15;
                    do {
                        final int n16 = n;
                        final int n17 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n16 >= n17) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        n14 = array[++n];
                        n15 = array[n - 1];
                        BytecodeManager.incBytecodes(10);
                    } while (n14 >= n15);
                    int n18 = n;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n19 = ++n;
                        final int n20 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (n19 > n20) {
                            break;
                        }
                        short n21 = array[n18];
                        short n22 = array[n];
                        BytecodeManager.incBytecodes(8);
                        final short n23 = n21;
                        final short n24 = n22;
                        BytecodeManager.incBytecodes(3);
                        if (n23 < n24) {
                            n22 = n21;
                            n21 = array[n];
                            BytecodeManager.incBytecodes(6);
                        }
                        while (true) {
                            final short n25 = n21;
                            final short n26 = array[--n18];
                            BytecodeManager.incBytecodes(6);
                            if (n25 >= n26) {
                                break;
                            }
                            array[n18 + 2] = array[n18];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[++n18 + 1] = n21;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final short n27 = n22;
                            final short n28 = array[--n18];
                            BytecodeManager.incBytecodes(6);
                            if (n27 >= n28) {
                                break;
                            }
                            array[n18 + 1] = array[n18];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[n18 + 1] = n22;
                        BytecodeManager.incBytecodes(6);
                        n18 = ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                    final short n29 = array[n2];
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final short n30 = n29;
                        final short n31 = array[--n2];
                        BytecodeManager.incBytecodes(6);
                        if (n30 >= n31) {
                            break;
                        }
                        array[n2 + 1] = array[n2];
                        BytecodeManager.incBytecodes(9);
                    }
                    array[n2 + 1] = n29;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n32 = (n3 >> 3) + (n3 >> 6) + 1;
            BytecodeManager.incBytecodes(10);
            final int n33 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n34 = n33 - n32;
            BytecodeManager.incBytecodes(4);
            final int n35 = n34 - n32;
            BytecodeManager.incBytecodes(4);
            final int n36 = n33 + n32;
            BytecodeManager.incBytecodes(4);
            final int n37 = n36 + n32;
            BytecodeManager.incBytecodes(4);
            final short n38 = array[n34];
            final short n39 = array[n35];
            BytecodeManager.incBytecodes(7);
            if (n38 < n39) {
                final short n40 = array[n34];
                array[n34] = array[n35];
                array[n35] = n40;
                BytecodeManager.incBytecodes(14);
            }
            final short n41 = array[n33];
            final short n42 = array[n34];
            BytecodeManager.incBytecodes(7);
            if (n41 < n42) {
                final short n43 = array[n33];
                array[n33] = array[n34];
                array[n34] = n43;
                BytecodeManager.incBytecodes(14);
                final short n44 = n43;
                final short n45 = array[n35];
                BytecodeManager.incBytecodes(5);
                if (n44 < n45) {
                    array[n34] = array[n35];
                    array[n35] = n43;
                    BytecodeManager.incBytecodes(10);
                }
            }
            final short n46 = array[n36];
            final short n47 = array[n33];
            BytecodeManager.incBytecodes(7);
            if (n46 < n47) {
                final short n48 = array[n36];
                array[n36] = array[n33];
                array[n33] = n48;
                BytecodeManager.incBytecodes(14);
                final short n49 = n48;
                final short n50 = array[n34];
                BytecodeManager.incBytecodes(5);
                if (n49 < n50) {
                    array[n33] = array[n34];
                    array[n34] = n48;
                    BytecodeManager.incBytecodes(10);
                    final short n51 = n48;
                    final short n52 = array[n35];
                    BytecodeManager.incBytecodes(5);
                    if (n51 < n52) {
                        array[n34] = array[n35];
                        array[n35] = n48;
                        BytecodeManager.incBytecodes(10);
                    }
                }
            }
            final short n53 = array[n37];
            final short n54 = array[n36];
            BytecodeManager.incBytecodes(7);
            if (n53 < n54) {
                final short n55 = array[n37];
                array[n37] = array[n36];
                array[n36] = n55;
                BytecodeManager.incBytecodes(14);
                final short n56 = n55;
                final short n57 = array[n33];
                BytecodeManager.incBytecodes(5);
                if (n56 < n57) {
                    array[n36] = array[n33];
                    array[n33] = n55;
                    BytecodeManager.incBytecodes(10);
                    final short n58 = n55;
                    final short n59 = array[n34];
                    BytecodeManager.incBytecodes(5);
                    if (n58 < n59) {
                        array[n33] = array[n34];
                        array[n34] = n55;
                        BytecodeManager.incBytecodes(10);
                        final short n60 = n55;
                        final short n61 = array[n35];
                        BytecodeManager.incBytecodes(5);
                        if (n60 < n61) {
                            array[n34] = array[n35];
                            array[n35] = n55;
                            BytecodeManager.incBytecodes(10);
                        }
                    }
                }
            }
            int n62 = n;
            BytecodeManager.incBytecodes(2);
            int n63 = n2;
            BytecodeManager.incBytecodes(2);
            final short n64 = array[n35];
            final short n65 = array[n34];
            BytecodeManager.incBytecodes(7);
            Label_1919: {
                if (n64 != n65) {
                    final short n66 = array[n34];
                    final short n67 = array[n33];
                    BytecodeManager.incBytecodes(7);
                    if (n66 != n67) {
                        final short n68 = array[n33];
                        final short n69 = array[n36];
                        BytecodeManager.incBytecodes(7);
                        if (n68 != n69) {
                            final short n70 = array[n36];
                            final short n71 = array[n37];
                            BytecodeManager.incBytecodes(7);
                            if (n70 != n71) {
                                final short n72 = array[n34];
                                BytecodeManager.incBytecodes(4);
                                final short n73 = array[n36];
                                BytecodeManager.incBytecodes(4);
                                array[n34] = array[n];
                                BytecodeManager.incBytecodes(6);
                                array[n36] = array[n2];
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final short n74 = array[++n62];
                                    final short n75 = n72;
                                    BytecodeManager.incBytecodes(6);
                                    if (n74 >= n75) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                while (true) {
                                    final short n76 = array[--n63];
                                    final short n77 = n73;
                                    BytecodeManager.incBytecodes(6);
                                    if (n76 <= n77) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                int n78 = n62 - 1;
                                BytecodeManager.incBytecodes(4);
                                while (true) {
                                    final int n79 = ++n78;
                                    final int n80 = n63;
                                    BytecodeManager.incBytecodes(4);
                                    if (n79 > n80) {
                                        break;
                                    }
                                    final short n81 = array[n78];
                                    BytecodeManager.incBytecodes(4);
                                    final short n82 = n81;
                                    final short n83 = n72;
                                    BytecodeManager.incBytecodes(3);
                                    Label_1260: {
                                        if (n82 < n83) {
                                            array[n78] = array[n62];
                                            BytecodeManager.incBytecodes(6);
                                            array[n62] = n81;
                                            BytecodeManager.incBytecodes(4);
                                            ++n62;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final short n84 = n81;
                                            final short n85 = n73;
                                            BytecodeManager.incBytecodes(3);
                                            if (n84 > n85) {
                                                int j;
                                                int n86;
                                                do {
                                                    final short n87 = array[n63];
                                                    final short n88 = n73;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (n87 <= n88) {
                                                        final short n89 = array[n63];
                                                        final short n90 = n72;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (n89 < n90) {
                                                            array[n78] = array[n62];
                                                            BytecodeManager.incBytecodes(6);
                                                            array[n62] = array[n63];
                                                            BytecodeManager.incBytecodes(6);
                                                            ++n62;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            array[n78] = array[n63];
                                                            BytecodeManager.incBytecodes(6);
                                                        }
                                                        array[n63] = n81;
                                                        BytecodeManager.incBytecodes(4);
                                                        --n63;
                                                        BytecodeManager.incBytecodes(1);
                                                        break Label_1260;
                                                    }
                                                    j = n63--;
                                                    n86 = n78;
                                                    BytecodeManager.incBytecodes(4);
                                                } while (j != n86);
                                                BytecodeManager.incBytecodes(1);
                                                break;
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                array[n] = array[n62 - 1];
                                array[n62 - 1] = n72;
                                BytecodeManager.incBytecodes(14);
                                array[n2] = array[n63 + 1];
                                array[n63 + 1] = n73;
                                BytecodeManager.incBytecodes(14);
                                final int n91 = n;
                                final int n92 = n62 - 2;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n91, n92, b);
                                final int n93 = n63 + 2;
                                final int n94 = n2;
                                final boolean b2 = false;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n93, n94, b2);
                                final int n95 = n62;
                                final int n96 = n35;
                                BytecodeManager.incBytecodes(3);
                                if (n95 < n96) {
                                    final int n97 = n37;
                                    final int n98 = n63;
                                    BytecodeManager.incBytecodes(3);
                                    if (n97 < n98) {
                                        while (true) {
                                            final short n99 = array[n62];
                                            final short n100 = n72;
                                            BytecodeManager.incBytecodes(5);
                                            if (n99 != n100) {
                                                break;
                                            }
                                            ++n62;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        while (true) {
                                            final short n101 = array[n63];
                                            final short n102 = n73;
                                            BytecodeManager.incBytecodes(5);
                                            if (n101 != n102) {
                                                break;
                                            }
                                            --n63;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        int n103 = n62 - 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n104 = ++n103;
                                            final int n105 = n63;
                                            BytecodeManager.incBytecodes(4);
                                            if (n104 > n105) {
                                                break;
                                            }
                                            final short n106 = array[n103];
                                            BytecodeManager.incBytecodes(4);
                                            final short n107 = n106;
                                            final short n108 = n72;
                                            BytecodeManager.incBytecodes(3);
                                            Label_1630: {
                                                if (n107 == n108) {
                                                    array[n103] = array[n62];
                                                    BytecodeManager.incBytecodes(6);
                                                    array[n62] = n106;
                                                    BytecodeManager.incBytecodes(4);
                                                    ++n62;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final short n109 = n106;
                                                    final short n110 = n73;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n109 == n110) {
                                                        int k;
                                                        int n111;
                                                        do {
                                                            final short n112 = array[n63];
                                                            final short n113 = n73;
                                                            BytecodeManager.incBytecodes(5);
                                                            if (n112 != n113) {
                                                                final short n114 = array[n63];
                                                                final short n115 = n72;
                                                                BytecodeManager.incBytecodes(5);
                                                                if (n114 == n115) {
                                                                    array[n103] = array[n62];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    array[n62] = n72;
                                                                    BytecodeManager.incBytecodes(4);
                                                                    ++n62;
                                                                    BytecodeManager.incBytecodes(2);
                                                                }
                                                                else {
                                                                    array[n103] = array[n63];
                                                                    BytecodeManager.incBytecodes(6);
                                                                }
                                                                array[n63] = n106;
                                                                BytecodeManager.incBytecodes(4);
                                                                --n63;
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_1630;
                                                            }
                                                            k = n63--;
                                                            n111 = n103;
                                                            BytecodeManager.incBytecodes(4);
                                                        } while (k != n111);
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                }
                                            }
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                }
                                final int n116 = n62;
                                final int n117 = n63;
                                final boolean b3 = false;
                                BytecodeManager.incBytecodes(5);
                                sort(array, n116, n117, b3);
                                BytecodeManager.incBytecodes(1);
                                break Label_1919;
                            }
                        }
                    }
                }
                final short n118 = array[n33];
                BytecodeManager.incBytecodes(4);
                int n119 = n62;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n120 = n119;
                    final int n121 = n63;
                    BytecodeManager.incBytecodes(3);
                    if (n120 > n121) {
                        break;
                    }
                    final short n122 = array[n119];
                    final short n123 = n118;
                    BytecodeManager.incBytecodes(5);
                    if (n122 == n123) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final short n124 = array[n119];
                        BytecodeManager.incBytecodes(4);
                        final short n125 = n124;
                        final short n126 = n118;
                        BytecodeManager.incBytecodes(3);
                        if (n125 < n126) {
                            array[n119] = array[n62];
                            BytecodeManager.incBytecodes(6);
                            array[n62] = n124;
                            BytecodeManager.incBytecodes(4);
                            ++n62;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            while (true) {
                                final short n127 = array[n63];
                                final short n128 = n118;
                                BytecodeManager.incBytecodes(5);
                                if (n127 <= n128) {
                                    break;
                                }
                                --n63;
                                BytecodeManager.incBytecodes(2);
                            }
                            final short n129 = array[n63];
                            final short n130 = n118;
                            BytecodeManager.incBytecodes(5);
                            if (n129 < n130) {
                                array[n119] = array[n62];
                                BytecodeManager.incBytecodes(6);
                                array[n62] = array[n63];
                                BytecodeManager.incBytecodes(6);
                                ++n62;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                array[n119] = n118;
                                BytecodeManager.incBytecodes(4);
                            }
                            array[n63] = n124;
                            BytecodeManager.incBytecodes(4);
                            --n63;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    ++n119;
                    BytecodeManager.incBytecodes(2);
                }
                final int n131 = n;
                final int n132 = n62 - 1;
                BytecodeManager.incBytecodes(7);
                sort(array, n131, n132, b);
                final int n133 = n63 + 1;
                final int n134 = n2;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(7);
                sort(array, n133, n134, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(final char[] array, final int n, final int n2, final char[] array2, final int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 3200;
            BytecodeManager.incBytecodes(5);
            if (n5 > n6) {
                final int[] array3 = new int[65536];
                BytecodeManager.incBytecodes(2);
                int n7 = n - 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n8 = ++n7;
                    BytecodeManager.incBytecodes(4);
                    if (n8 > n2) {
                        break;
                    }
                    final int[] array4 = array3;
                    final char c = array[n7];
                    ++array4[c];
                    BytecodeManager.incBytecodes(10);
                }
                int n9 = 65536;
                int n10 = n2 + 1;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final int n11 = n10;
                    BytecodeManager.incBytecodes(3);
                    if (n11 <= n) {
                        break;
                    }
                    while (true) {
                        final int n12 = array3[--n9];
                        BytecodeManager.incBytecodes(5);
                        if (n12 != 0) {
                            break;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final char c2 = (char)n9;
                    BytecodeManager.incBytecodes(3);
                    int n13 = array3[n9];
                    BytecodeManager.incBytecodes(4);
                    int i;
                    do {
                        array[--n10] = c2;
                        BytecodeManager.incBytecodes(5);
                        i = --n13;
                        BytecodeManager.incBytecodes(3);
                    } while (i > 0);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(7);
                doSort(array, n, n2, array2, n3, n4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void doSort(char[] array, final int n, int n2, char[] array2, int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 286;
            BytecodeManager.incBytecodes(5);
            if (n5 < n6) {
                final char[] array3 = array;
                final int n7 = n2;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                sort(array3, n, n7, b);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int[] array4 = new int[68];
            BytecodeManager.incBytecodes(2);
            int n8 = 0;
            array4[0] = n;
            BytecodeManager.incBytecodes(6);
            int n9 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n2;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = array4[n8];
                    final int n13 = n2++;
                    BytecodeManager.incBytecodes(6);
                    if (n12 == n13) {
                        array4[++n8] = n2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        final int n14 = n8;
                        final int n15 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n14 == n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    byte b2 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n16 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        n16 <<= 1;
                        final int n17 = n8;
                        BytecodeManager.incBytecodes(7);
                        if (n16 >= n17) {
                            break;
                        }
                        b2 ^= 0x1;
                        BytecodeManager.incBytecodes(6);
                    }
                    final int n18 = n2 - n;
                    BytecodeManager.incBytecodes(4);
                    final char[] array5 = array2;
                    BytecodeManager.incBytecodes(2);
                    Label_0551: {
                        if (array5 != null) {
                            final int n19 = n18;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n19) {
                                final int n20 = n3 + n18;
                                final int length = array2.length;
                                BytecodeManager.incBytecodes(6);
                                if (n20 <= length) {
                                    break Label_0551;
                                }
                            }
                        }
                        array2 = new char[n18];
                        BytecodeManager.incBytecodes(2);
                        n3 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    char[] array8;
                    int n23;
                    int n24;
                    if (b3 == 0) {
                        final char[] array6 = array;
                        final char[] array7 = array2;
                        final int n21 = n3;
                        final int n22 = n18;
                        BytecodeManager.incBytecodes(6);
                        System.arraycopy(array6, n, array7, n21, n22);
                        array8 = array;
                        BytecodeManager.incBytecodes(2);
                        n23 = 0;
                        BytecodeManager.incBytecodes(2);
                        array = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = n3 - n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        array8 = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = 0;
                        BytecodeManager.incBytecodes(2);
                        n23 = n3 - n;
                        BytecodeManager.incBytecodes(4);
                    }
                    while (true) {
                        final int n25 = n8;
                        final int n26 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n25 <= n26) {
                            break;
                        }
                        int n28;
                        int n27 = (n28 = 0) + 2;
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            final int n29 = n27;
                            final int n30 = n8;
                            BytecodeManager.incBytecodes(3);
                            if (n29 > n30) {
                                break;
                            }
                            final int n31 = array4[n27];
                            final int n32 = array4[n27 - 1];
                            BytecodeManager.incBytecodes(10);
                            int n34;
                            int n33 = n34 = array4[n27 - 2];
                            int n35 = n32;
                            BytecodeManager.incBytecodes(10);
                            while (true) {
                                final int n36 = n33;
                                final int n37 = n31;
                                BytecodeManager.incBytecodes(3);
                                if (n36 >= n37) {
                                    break;
                                }
                                final int n38 = n35;
                                final int n39 = n31;
                                BytecodeManager.incBytecodes(3);
                                Label_0826: {
                                    Label_0777: {
                                        if (n38 < n39) {
                                            final int n40 = n34;
                                            final int n41 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n40 < n41) {
                                                final char c = array[n34 + n24];
                                                final char c2 = array[n35 + n24];
                                                BytecodeManager.incBytecodes(11);
                                                if (c <= c2) {
                                                    break Label_0777;
                                                }
                                            }
                                            array8[n33 + n23] = array[n35++ + n24];
                                            BytecodeManager.incBytecodes(11);
                                            break Label_0826;
                                        }
                                    }
                                    array8[n33 + n23] = array[n34++ + n24];
                                    BytecodeManager.incBytecodes(12);
                                }
                                ++n33;
                                BytecodeManager.incBytecodes(2);
                            }
                            array4[++n28] = n31;
                            BytecodeManager.incBytecodes(5);
                            n27 += 2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n42 = n8 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n42 != 0) {
                            int n43 = n2;
                            final int n44 = array4[n8 - 1];
                            BytecodeManager.incBytecodes(8);
                            while (true) {
                                final int n45 = --n43;
                                final int n46 = n44;
                                BytecodeManager.incBytecodes(4);
                                if (n45 < n46) {
                                    break;
                                }
                                array8[n43 + n23] = array[n43 + n24];
                                BytecodeManager.incBytecodes(11);
                            }
                            array4[++n28] = n2;
                            BytecodeManager.incBytecodes(5);
                        }
                        final char[] array9 = array;
                        array = array8;
                        array8 = array9;
                        BytecodeManager.incBytecodes(6);
                        final int n47 = n24;
                        n24 = n23;
                        n23 = n47;
                        BytecodeManager.incBytecodes(6);
                        n8 = n28;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final char c3 = array[n9];
                final char c4 = array[n9 + 1];
                BytecodeManager.incBytecodes(9);
                Label_0340: {
                    if (c3 < c4) {
                        while (true) {
                            final int n48 = ++n9;
                            final int n49 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n48 > n49) {
                                break;
                            }
                            final char c5 = array[n9 - 1];
                            final char c6 = array[n9];
                            BytecodeManager.incBytecodes(9);
                            if (c5 > c6) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final char c7 = array[n9];
                        final char c8 = array[n9 + 1];
                        BytecodeManager.incBytecodes(9);
                        if (c7 <= c8) {
                            int n50 = 33;
                            BytecodeManager.incBytecodes(2);
                            int i;
                            do {
                                final int n51 = ++n9;
                                final int n52 = n2;
                                BytecodeManager.incBytecodes(4);
                                if (n51 > n52) {
                                    break Label_0340;
                                }
                                final char c9 = array[n9 - 1];
                                final char c10 = array[n9];
                                BytecodeManager.incBytecodes(9);
                                if (c9 != c10) {
                                    break Label_0340;
                                }
                                i = --n50;
                                BytecodeManager.incBytecodes(3);
                            } while (i != 0);
                            final char[] array10 = array;
                            final int n53 = n2;
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(5);
                            sort(array10, n, n53, b4);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        while (true) {
                            final int n54 = ++n9;
                            final int n55 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n54 > n55) {
                                break;
                            }
                            final char c11 = array[n9 - 1];
                            final char c12 = array[n9];
                            BytecodeManager.incBytecodes(9);
                            if (c11 < c12) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        int n56 = array4[n8] - 1;
                        int n57 = n9;
                        BytecodeManager.incBytecodes(8);
                        while (true) {
                            final int n58 = ++n56;
                            final int n59 = --n57;
                            BytecodeManager.incBytecodes(5);
                            if (n58 >= n59) {
                                break;
                            }
                            final char c13 = array[n56];
                            array[n56] = array[n57];
                            array[n57] = c13;
                            BytecodeManager.incBytecodes(14);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n60 = ++n8;
                final int n61 = 67;
                BytecodeManager.incBytecodes(4);
                if (n60 == n61) {
                    final char[] array11 = array;
                    final int n62 = n2;
                    final boolean b5 = true;
                    BytecodeManager.incBytecodes(5);
                    sort(array11, n, n62, b5);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                array4[n8] = n9;
                BytecodeManager.incBytecodes(5);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void sort(final char[] array, int n, int n2, final boolean b) {
        try {
            final int n3 = n2 - n + 1;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3;
            final int n5 = 47;
            BytecodeManager.incBytecodes(3);
            if (n4 < n5) {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    int n7;
                    int n6 = n7 = n;
                    BytecodeManager.incBytecodes(4);
                Label_0045:
                    while (true) {
                        final int n8 = n6;
                        final int n9 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 < n9) {
                            final char c = array[n6 + 1];
                            BytecodeManager.incBytecodes(6);
                            while (true) {
                                int i;
                                int n10;
                                do {
                                    final char c2 = c;
                                    final char c3 = array[n7];
                                    BytecodeManager.incBytecodes(5);
                                    if (c2 >= c3) {
                                        array[n7 + 1] = c;
                                        BytecodeManager.incBytecodes(6);
                                        n7 = ++n6;
                                        BytecodeManager.incBytecodes(4);
                                        continue Label_0045;
                                    }
                                    array[n7 + 1] = array[n7];
                                    BytecodeManager.incBytecodes(8);
                                    i = n7--;
                                    n10 = n;
                                    BytecodeManager.incBytecodes(4);
                                } while (i != n10);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    char c4;
                    char c5;
                    do {
                        final int n11 = n;
                        final int n12 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n11 >= n12) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        c4 = array[++n];
                        c5 = array[n - 1];
                        BytecodeManager.incBytecodes(10);
                    } while (c4 >= c5);
                    int n13 = n;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n14 = ++n;
                        final int n15 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (n14 > n15) {
                            break;
                        }
                        char c6 = array[n13];
                        char c7 = array[n];
                        BytecodeManager.incBytecodes(8);
                        final char c8 = c6;
                        final char c9 = c7;
                        BytecodeManager.incBytecodes(3);
                        if (c8 < c9) {
                            c7 = c6;
                            c6 = array[n];
                            BytecodeManager.incBytecodes(6);
                        }
                        while (true) {
                            final char c10 = c6;
                            final char c11 = array[--n13];
                            BytecodeManager.incBytecodes(6);
                            if (c10 >= c11) {
                                break;
                            }
                            array[n13 + 2] = array[n13];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[++n13 + 1] = c6;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final char c12 = c7;
                            final char c13 = array[--n13];
                            BytecodeManager.incBytecodes(6);
                            if (c12 >= c13) {
                                break;
                            }
                            array[n13 + 1] = array[n13];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[n13 + 1] = c7;
                        BytecodeManager.incBytecodes(6);
                        n13 = ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                    final char c14 = array[n2];
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final char c15 = c14;
                        final char c16 = array[--n2];
                        BytecodeManager.incBytecodes(6);
                        if (c15 >= c16) {
                            break;
                        }
                        array[n2 + 1] = array[n2];
                        BytecodeManager.incBytecodes(9);
                    }
                    array[n2 + 1] = c14;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n16 = (n3 >> 3) + (n3 >> 6) + 1;
            BytecodeManager.incBytecodes(10);
            final int n17 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n18 = n17 - n16;
            BytecodeManager.incBytecodes(4);
            final int n19 = n18 - n16;
            BytecodeManager.incBytecodes(4);
            final int n20 = n17 + n16;
            BytecodeManager.incBytecodes(4);
            final int n21 = n20 + n16;
            BytecodeManager.incBytecodes(4);
            final char c17 = array[n18];
            final char c18 = array[n19];
            BytecodeManager.incBytecodes(7);
            if (c17 < c18) {
                final char c19 = array[n18];
                array[n18] = array[n19];
                array[n19] = c19;
                BytecodeManager.incBytecodes(14);
            }
            final char c20 = array[n17];
            final char c21 = array[n18];
            BytecodeManager.incBytecodes(7);
            if (c20 < c21) {
                final char c22 = array[n17];
                array[n17] = array[n18];
                array[n18] = c22;
                BytecodeManager.incBytecodes(14);
                final char c23 = c22;
                final char c24 = array[n19];
                BytecodeManager.incBytecodes(5);
                if (c23 < c24) {
                    array[n18] = array[n19];
                    array[n19] = c22;
                    BytecodeManager.incBytecodes(10);
                }
            }
            final char c25 = array[n20];
            final char c26 = array[n17];
            BytecodeManager.incBytecodes(7);
            if (c25 < c26) {
                final char c27 = array[n20];
                array[n20] = array[n17];
                array[n17] = c27;
                BytecodeManager.incBytecodes(14);
                final char c28 = c27;
                final char c29 = array[n18];
                BytecodeManager.incBytecodes(5);
                if (c28 < c29) {
                    array[n17] = array[n18];
                    array[n18] = c27;
                    BytecodeManager.incBytecodes(10);
                    final char c30 = c27;
                    final char c31 = array[n19];
                    BytecodeManager.incBytecodes(5);
                    if (c30 < c31) {
                        array[n18] = array[n19];
                        array[n19] = c27;
                        BytecodeManager.incBytecodes(10);
                    }
                }
            }
            final char c32 = array[n21];
            final char c33 = array[n20];
            BytecodeManager.incBytecodes(7);
            if (c32 < c33) {
                final char c34 = array[n21];
                array[n21] = array[n20];
                array[n20] = c34;
                BytecodeManager.incBytecodes(14);
                final char c35 = c34;
                final char c36 = array[n17];
                BytecodeManager.incBytecodes(5);
                if (c35 < c36) {
                    array[n20] = array[n17];
                    array[n17] = c34;
                    BytecodeManager.incBytecodes(10);
                    final char c37 = c34;
                    final char c38 = array[n18];
                    BytecodeManager.incBytecodes(5);
                    if (c37 < c38) {
                        array[n17] = array[n18];
                        array[n18] = c34;
                        BytecodeManager.incBytecodes(10);
                        final char c39 = c34;
                        final char c40 = array[n19];
                        BytecodeManager.incBytecodes(5);
                        if (c39 < c40) {
                            array[n18] = array[n19];
                            array[n19] = c34;
                            BytecodeManager.incBytecodes(10);
                        }
                    }
                }
            }
            int n22 = n;
            BytecodeManager.incBytecodes(2);
            int n23 = n2;
            BytecodeManager.incBytecodes(2);
            final char c41 = array[n19];
            final char c42 = array[n18];
            BytecodeManager.incBytecodes(7);
            Label_1919: {
                if (c41 != c42) {
                    final char c43 = array[n18];
                    final char c44 = array[n17];
                    BytecodeManager.incBytecodes(7);
                    if (c43 != c44) {
                        final char c45 = array[n17];
                        final char c46 = array[n20];
                        BytecodeManager.incBytecodes(7);
                        if (c45 != c46) {
                            final char c47 = array[n20];
                            final char c48 = array[n21];
                            BytecodeManager.incBytecodes(7);
                            if (c47 != c48) {
                                final char c49 = array[n18];
                                BytecodeManager.incBytecodes(4);
                                final char c50 = array[n20];
                                BytecodeManager.incBytecodes(4);
                                array[n18] = array[n];
                                BytecodeManager.incBytecodes(6);
                                array[n20] = array[n2];
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final char c51 = array[++n22];
                                    final char c52 = c49;
                                    BytecodeManager.incBytecodes(6);
                                    if (c51 >= c52) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                while (true) {
                                    final char c53 = array[--n23];
                                    final char c54 = c50;
                                    BytecodeManager.incBytecodes(6);
                                    if (c53 <= c54) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                int n24 = n22 - 1;
                                BytecodeManager.incBytecodes(4);
                                while (true) {
                                    final int n25 = ++n24;
                                    final int n26 = n23;
                                    BytecodeManager.incBytecodes(4);
                                    if (n25 > n26) {
                                        break;
                                    }
                                    final char c55 = array[n24];
                                    BytecodeManager.incBytecodes(4);
                                    final char c56 = c55;
                                    final char c57 = c49;
                                    BytecodeManager.incBytecodes(3);
                                    Label_1260: {
                                        if (c56 < c57) {
                                            array[n24] = array[n22];
                                            BytecodeManager.incBytecodes(6);
                                            array[n22] = c55;
                                            BytecodeManager.incBytecodes(4);
                                            ++n22;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final char c58 = c55;
                                            final char c59 = c50;
                                            BytecodeManager.incBytecodes(3);
                                            if (c58 > c59) {
                                                int j;
                                                int n27;
                                                do {
                                                    final char c60 = array[n23];
                                                    final char c61 = c50;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (c60 <= c61) {
                                                        final char c62 = array[n23];
                                                        final char c63 = c49;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (c62 < c63) {
                                                            array[n24] = array[n22];
                                                            BytecodeManager.incBytecodes(6);
                                                            array[n22] = array[n23];
                                                            BytecodeManager.incBytecodes(6);
                                                            ++n22;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            array[n24] = array[n23];
                                                            BytecodeManager.incBytecodes(6);
                                                        }
                                                        array[n23] = c55;
                                                        BytecodeManager.incBytecodes(4);
                                                        --n23;
                                                        BytecodeManager.incBytecodes(1);
                                                        break Label_1260;
                                                    }
                                                    j = n23--;
                                                    n27 = n24;
                                                    BytecodeManager.incBytecodes(4);
                                                } while (j != n27);
                                                BytecodeManager.incBytecodes(1);
                                                break;
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                array[n] = array[n22 - 1];
                                array[n22 - 1] = c49;
                                BytecodeManager.incBytecodes(14);
                                array[n2] = array[n23 + 1];
                                array[n23 + 1] = c50;
                                BytecodeManager.incBytecodes(14);
                                final int n28 = n;
                                final int n29 = n22 - 2;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n28, n29, b);
                                final int n30 = n23 + 2;
                                final int n31 = n2;
                                final boolean b2 = false;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n30, n31, b2);
                                final int n32 = n22;
                                final int n33 = n19;
                                BytecodeManager.incBytecodes(3);
                                if (n32 < n33) {
                                    final int n34 = n21;
                                    final int n35 = n23;
                                    BytecodeManager.incBytecodes(3);
                                    if (n34 < n35) {
                                        while (true) {
                                            final char c64 = array[n22];
                                            final char c65 = c49;
                                            BytecodeManager.incBytecodes(5);
                                            if (c64 != c65) {
                                                break;
                                            }
                                            ++n22;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        while (true) {
                                            final char c66 = array[n23];
                                            final char c67 = c50;
                                            BytecodeManager.incBytecodes(5);
                                            if (c66 != c67) {
                                                break;
                                            }
                                            --n23;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        int n36 = n22 - 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n37 = ++n36;
                                            final int n38 = n23;
                                            BytecodeManager.incBytecodes(4);
                                            if (n37 > n38) {
                                                break;
                                            }
                                            final char c68 = array[n36];
                                            BytecodeManager.incBytecodes(4);
                                            final char c69 = c68;
                                            final char c70 = c49;
                                            BytecodeManager.incBytecodes(3);
                                            Label_1630: {
                                                if (c69 == c70) {
                                                    array[n36] = array[n22];
                                                    BytecodeManager.incBytecodes(6);
                                                    array[n22] = c68;
                                                    BytecodeManager.incBytecodes(4);
                                                    ++n22;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final char c71 = c68;
                                                    final char c72 = c50;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (c71 == c72) {
                                                        int k;
                                                        int n39;
                                                        do {
                                                            final char c73 = array[n23];
                                                            final char c74 = c50;
                                                            BytecodeManager.incBytecodes(5);
                                                            if (c73 != c74) {
                                                                final char c75 = array[n23];
                                                                final char c76 = c49;
                                                                BytecodeManager.incBytecodes(5);
                                                                if (c75 == c76) {
                                                                    array[n36] = array[n22];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    array[n22] = c49;
                                                                    BytecodeManager.incBytecodes(4);
                                                                    ++n22;
                                                                    BytecodeManager.incBytecodes(2);
                                                                }
                                                                else {
                                                                    array[n36] = array[n23];
                                                                    BytecodeManager.incBytecodes(6);
                                                                }
                                                                array[n23] = c68;
                                                                BytecodeManager.incBytecodes(4);
                                                                --n23;
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_1630;
                                                            }
                                                            k = n23--;
                                                            n39 = n36;
                                                            BytecodeManager.incBytecodes(4);
                                                        } while (k != n39);
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                }
                                            }
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                }
                                final int n40 = n22;
                                final int n41 = n23;
                                final boolean b3 = false;
                                BytecodeManager.incBytecodes(5);
                                sort(array, n40, n41, b3);
                                BytecodeManager.incBytecodes(1);
                                break Label_1919;
                            }
                        }
                    }
                }
                final char c77 = array[n17];
                BytecodeManager.incBytecodes(4);
                int n42 = n22;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n43 = n42;
                    final int n44 = n23;
                    BytecodeManager.incBytecodes(3);
                    if (n43 > n44) {
                        break;
                    }
                    final char c78 = array[n42];
                    final char c79 = c77;
                    BytecodeManager.incBytecodes(5);
                    if (c78 == c79) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c80 = array[n42];
                        BytecodeManager.incBytecodes(4);
                        final char c81 = c80;
                        final char c82 = c77;
                        BytecodeManager.incBytecodes(3);
                        if (c81 < c82) {
                            array[n42] = array[n22];
                            BytecodeManager.incBytecodes(6);
                            array[n22] = c80;
                            BytecodeManager.incBytecodes(4);
                            ++n22;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            while (true) {
                                final char c83 = array[n23];
                                final char c84 = c77;
                                BytecodeManager.incBytecodes(5);
                                if (c83 <= c84) {
                                    break;
                                }
                                --n23;
                                BytecodeManager.incBytecodes(2);
                            }
                            final char c85 = array[n23];
                            final char c86 = c77;
                            BytecodeManager.incBytecodes(5);
                            if (c85 < c86) {
                                array[n42] = array[n22];
                                BytecodeManager.incBytecodes(6);
                                array[n22] = array[n23];
                                BytecodeManager.incBytecodes(6);
                                ++n22;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                array[n42] = c77;
                                BytecodeManager.incBytecodes(4);
                            }
                            array[n23] = c80;
                            BytecodeManager.incBytecodes(4);
                            --n23;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    ++n42;
                    BytecodeManager.incBytecodes(2);
                }
                final int n45 = n;
                final int n46 = n22 - 1;
                BytecodeManager.incBytecodes(7);
                sort(array, n45, n46, b);
                final int n47 = n23 + 1;
                final int n48 = n2;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(7);
                sort(array, n47, n48, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(final byte[] array, final int n, final int n2) {
        try {
            final int n3 = n2 - n;
            final int n4 = 29;
            BytecodeManager.incBytecodes(5);
            if (n3 > n4) {
                final int[] array2 = new int[256];
                BytecodeManager.incBytecodes(2);
                int n5 = n - 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n6 = ++n5;
                    BytecodeManager.incBytecodes(4);
                    if (n6 > n2) {
                        break;
                    }
                    final int[] array3 = array2;
                    final int n7 = array[n5] + 128;
                    ++array3[n7];
                    BytecodeManager.incBytecodes(12);
                }
                int n8 = 256;
                int n9 = n2 + 1;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final int n10 = n9;
                    BytecodeManager.incBytecodes(3);
                    if (n10 <= n) {
                        break;
                    }
                    while (true) {
                        final int n11 = array2[--n8];
                        BytecodeManager.incBytecodes(5);
                        if (n11 != 0) {
                            break;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final byte b = (byte)(n8 - 128);
                    BytecodeManager.incBytecodes(5);
                    int n12 = array2[n8];
                    BytecodeManager.incBytecodes(4);
                    int i;
                    do {
                        array[--n9] = b;
                        BytecodeManager.incBytecodes(5);
                        i = --n12;
                        BytecodeManager.incBytecodes(3);
                    } while (i > 0);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                int n14;
                int n13 = n14 = n;
                BytecodeManager.incBytecodes(4);
            Label_0195:
                while (true) {
                    final int n15 = n13;
                    BytecodeManager.incBytecodes(3);
                    if (n15 < n2) {
                        final byte b2 = array[n13 + 1];
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            int j;
                            do {
                                final byte b3 = b2;
                                final byte b4 = array[n14];
                                BytecodeManager.incBytecodes(5);
                                if (b3 >= b4) {
                                    array[n14 + 1] = b2;
                                    BytecodeManager.incBytecodes(6);
                                    n14 = ++n13;
                                    BytecodeManager.incBytecodes(4);
                                    continue Label_0195;
                                }
                                array[n14 + 1] = array[n14];
                                BytecodeManager.incBytecodes(8);
                                j = n14--;
                                BytecodeManager.incBytecodes(4);
                            } while (j != n);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                    }
                    break;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(final float[] array, int n, int n2, final float[] array2, final int n3, final int n4) {
        try {
            while (true) {
                final int n5 = n;
                final int n6 = n2;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    break;
                }
                final float v = array[n2];
                BytecodeManager.incBytecodes(4);
                final boolean naN = Float.isNaN(v);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    break;
                }
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            int n7 = n2;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n8 = --n7;
                final int n9 = n;
                BytecodeManager.incBytecodes(4);
                if (n8 < n9) {
                    break;
                }
                final float n10 = array[n7];
                BytecodeManager.incBytecodes(4);
                final float n11 = fcmpl(n10, n10);
                BytecodeManager.incBytecodes(4);
                if (n11 != 0) {
                    array[n7] = array[n2];
                    BytecodeManager.incBytecodes(6);
                    array[n2] = n10;
                    BytecodeManager.incBytecodes(4);
                    --n2;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            final int n12 = n;
            final int n13 = n2;
            BytecodeManager.incBytecodes(7);
            doSort(array, n12, n13, array2, n3, n4);
            int n14 = n2;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n15 = n;
                final int n16 = n14;
                BytecodeManager.incBytecodes(3);
                if (n15 >= n16) {
                    break;
                }
                final int n17 = n + n14 >>> 1;
                BytecodeManager.incBytecodes(6);
                final float n18 = array[n17];
                BytecodeManager.incBytecodes(4);
                final float n19 = fcmpg(n18, 0.0f);
                BytecodeManager.incBytecodes(4);
                if (n19 < 0) {
                    n = n17 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    n14 = n17;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            while (true) {
                final int n20 = n;
                final int n21 = n2;
                BytecodeManager.incBytecodes(3);
                if (n20 > n21) {
                    break;
                }
                final float n22 = array[n];
                BytecodeManager.incBytecodes(4);
                final int floatToRawIntBits = Float.floatToRawIntBits(n22);
                BytecodeManager.incBytecodes(1);
                if (floatToRawIntBits >= 0) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            int n23 = n;
            int n24 = n - 1;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n25 = ++n23;
                final int n26 = n2;
                BytecodeManager.incBytecodes(4);
                if (n25 > n26) {
                    break;
                }
                final float n27 = array[n23];
                BytecodeManager.incBytecodes(4);
                final float n28 = fcmpl(n27, 0.0f);
                BytecodeManager.incBytecodes(4);
                if (n28 != 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final float n29 = n27;
                BytecodeManager.incBytecodes(2);
                final int floatToRawIntBits2 = Float.floatToRawIntBits(n29);
                BytecodeManager.incBytecodes(1);
                if (floatToRawIntBits2 < 0) {
                    array[n23] = 0.0f;
                    BytecodeManager.incBytecodes(4);
                    array[++n24] = -0.0f;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void doSort(float[] array, final int n, int n2, float[] array2, int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 286;
            BytecodeManager.incBytecodes(5);
            if (n5 < n6) {
                final float[] array3 = array;
                final int n7 = n2;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                sort(array3, n, n7, b);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int[] array4 = new int[68];
            BytecodeManager.incBytecodes(2);
            int n8 = 0;
            array4[0] = n;
            BytecodeManager.incBytecodes(6);
            int n9 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n2;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = array4[n8];
                    final int n13 = n2++;
                    BytecodeManager.incBytecodes(6);
                    if (n12 == n13) {
                        array4[++n8] = n2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        final int n14 = n8;
                        final int n15 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n14 == n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    byte b2 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n16 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        n16 <<= 1;
                        final int n17 = n8;
                        BytecodeManager.incBytecodes(7);
                        if (n16 >= n17) {
                            break;
                        }
                        b2 ^= 0x1;
                        BytecodeManager.incBytecodes(6);
                    }
                    final int n18 = n2 - n;
                    BytecodeManager.incBytecodes(4);
                    final float[] array5 = array2;
                    BytecodeManager.incBytecodes(2);
                    Label_0556: {
                        if (array5 != null) {
                            final int n19 = n18;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n19) {
                                final int n20 = n3 + n18;
                                final int length = array2.length;
                                BytecodeManager.incBytecodes(6);
                                if (n20 <= length) {
                                    break Label_0556;
                                }
                            }
                        }
                        array2 = new float[n18];
                        BytecodeManager.incBytecodes(2);
                        n3 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    float[] array8;
                    int n23;
                    int n24;
                    if (b3 == 0) {
                        final float[] array6 = array;
                        final float[] array7 = array2;
                        final int n21 = n3;
                        final int n22 = n18;
                        BytecodeManager.incBytecodes(6);
                        System.arraycopy(array6, n, array7, n21, n22);
                        array8 = array;
                        BytecodeManager.incBytecodes(2);
                        n23 = 0;
                        BytecodeManager.incBytecodes(2);
                        array = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = n3 - n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        array8 = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = 0;
                        BytecodeManager.incBytecodes(2);
                        n23 = n3 - n;
                        BytecodeManager.incBytecodes(4);
                    }
                    while (true) {
                        final int n25 = n8;
                        final int n26 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n25 <= n26) {
                            break;
                        }
                        int n28;
                        int n27 = (n28 = 0) + 2;
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            final int n29 = n27;
                            final int n30 = n8;
                            BytecodeManager.incBytecodes(3);
                            if (n29 > n30) {
                                break;
                            }
                            final int n31 = array4[n27];
                            final int n32 = array4[n27 - 1];
                            BytecodeManager.incBytecodes(10);
                            int n34;
                            int n33 = n34 = array4[n27 - 2];
                            int n35 = n32;
                            BytecodeManager.incBytecodes(10);
                            while (true) {
                                final int n36 = n33;
                                final int n37 = n31;
                                BytecodeManager.incBytecodes(3);
                                if (n36 >= n37) {
                                    break;
                                }
                                final int n38 = n35;
                                final int n39 = n31;
                                BytecodeManager.incBytecodes(3);
                                Label_0832: {
                                    Label_0783: {
                                        if (n38 < n39) {
                                            final int n40 = n34;
                                            final int n41 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n40 < n41) {
                                                final float n42 = fcmpg(array[n34 + n24], array[n35 + n24]);
                                                BytecodeManager.incBytecodes(12);
                                                if (n42 <= 0) {
                                                    break Label_0783;
                                                }
                                            }
                                            array8[n33 + n23] = array[n35++ + n24];
                                            BytecodeManager.incBytecodes(11);
                                            break Label_0832;
                                        }
                                    }
                                    array8[n33 + n23] = array[n34++ + n24];
                                    BytecodeManager.incBytecodes(12);
                                }
                                ++n33;
                                BytecodeManager.incBytecodes(2);
                            }
                            array4[++n28] = n31;
                            BytecodeManager.incBytecodes(5);
                            n27 += 2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n43 = n8 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n43 != 0) {
                            int n44 = n2;
                            final int n45 = array4[n8 - 1];
                            BytecodeManager.incBytecodes(8);
                            while (true) {
                                final int n46 = --n44;
                                final int n47 = n45;
                                BytecodeManager.incBytecodes(4);
                                if (n46 < n47) {
                                    break;
                                }
                                array8[n44 + n23] = array[n44 + n24];
                                BytecodeManager.incBytecodes(11);
                            }
                            array4[++n28] = n2;
                            BytecodeManager.incBytecodes(5);
                        }
                        final float[] array9 = array;
                        array = array8;
                        array8 = array9;
                        BytecodeManager.incBytecodes(6);
                        final int n48 = n24;
                        n24 = n23;
                        n23 = n48;
                        BytecodeManager.incBytecodes(6);
                        n8 = n28;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final float n49 = fcmpg(array[n9], array[n9 + 1]);
                BytecodeManager.incBytecodes(10);
                Label_0345: {
                    if (n49 < 0) {
                        while (true) {
                            final int n50 = ++n9;
                            final int n51 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n50 > n51) {
                                break;
                            }
                            final float n52 = fcmpg(array[n9 - 1], array[n9]);
                            BytecodeManager.incBytecodes(10);
                            if (n52 > 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final float n53 = fcmpl(array[n9], array[n9 + 1]);
                        BytecodeManager.incBytecodes(10);
                        if (n53 <= 0) {
                            int n54 = 33;
                            BytecodeManager.incBytecodes(2);
                            int i;
                            do {
                                final int n55 = ++n9;
                                final int n56 = n2;
                                BytecodeManager.incBytecodes(4);
                                if (n55 > n56) {
                                    break Label_0345;
                                }
                                final float n57 = fcmpl(array[n9 - 1], array[n9]);
                                BytecodeManager.incBytecodes(10);
                                if (n57 != 0) {
                                    break Label_0345;
                                }
                                i = --n54;
                                BytecodeManager.incBytecodes(3);
                            } while (i != 0);
                            final float[] array10 = array;
                            final int n58 = n2;
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(5);
                            sort(array10, n, n58, b4);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        while (true) {
                            final int n59 = ++n9;
                            final int n60 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n59 > n60) {
                                break;
                            }
                            final float n61 = fcmpl(array[n9 - 1], array[n9]);
                            BytecodeManager.incBytecodes(10);
                            if (n61 < 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        int n62 = array4[n8] - 1;
                        int n63 = n9;
                        BytecodeManager.incBytecodes(8);
                        while (true) {
                            final int n64 = ++n62;
                            final int n65 = --n63;
                            BytecodeManager.incBytecodes(5);
                            if (n64 >= n65) {
                                break;
                            }
                            final float n66 = array[n62];
                            array[n62] = array[n63];
                            array[n63] = n66;
                            BytecodeManager.incBytecodes(14);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n67 = ++n8;
                final int n68 = 67;
                BytecodeManager.incBytecodes(4);
                if (n67 == n68) {
                    final float[] array11 = array;
                    final int n69 = n2;
                    final boolean b5 = true;
                    BytecodeManager.incBytecodes(5);
                    sort(array11, n, n69, b5);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                array4[n8] = n9;
                BytecodeManager.incBytecodes(5);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void sort(final float[] array, int n, int n2, final boolean b) {
        try {
            final int n3 = n2 - n + 1;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3;
            final int n5 = 47;
            BytecodeManager.incBytecodes(3);
            if (n4 < n5) {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    int n7;
                    int n6 = n7 = n;
                    BytecodeManager.incBytecodes(4);
                Label_0045:
                    while (true) {
                        final int n8 = n6;
                        final int n9 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 < n9) {
                            final float n10 = array[n6 + 1];
                            BytecodeManager.incBytecodes(6);
                            while (true) {
                                int i;
                                int n11;
                                do {
                                    final float n12 = fcmpg(n10, array[n7]);
                                    BytecodeManager.incBytecodes(6);
                                    if (n12 >= 0) {
                                        array[n7 + 1] = n10;
                                        BytecodeManager.incBytecodes(6);
                                        n7 = ++n6;
                                        BytecodeManager.incBytecodes(4);
                                        continue Label_0045;
                                    }
                                    array[n7 + 1] = array[n7];
                                    BytecodeManager.incBytecodes(8);
                                    i = n7--;
                                    n11 = n;
                                    BytecodeManager.incBytecodes(4);
                                } while (i != n11);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    float n13;
                    do {
                        final int n14 = n;
                        final int n15 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n14 >= n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        n13 = fcmpl(array[++n], array[n - 1]);
                        BytecodeManager.incBytecodes(11);
                    } while (n13 >= 0);
                    int n16 = n;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n17 = ++n;
                        final int n18 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (n17 > n18) {
                            break;
                        }
                        float n19 = array[n16];
                        float n20 = array[n];
                        BytecodeManager.incBytecodes(8);
                        final float n21 = fcmpg(n19, n20);
                        BytecodeManager.incBytecodes(4);
                        if (n21 < 0) {
                            n20 = n19;
                            n19 = array[n];
                            BytecodeManager.incBytecodes(6);
                        }
                        while (true) {
                            final float n22 = fcmpg(n19, array[--n16]);
                            BytecodeManager.incBytecodes(7);
                            if (n22 >= 0) {
                                break;
                            }
                            array[n16 + 2] = array[n16];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[++n16 + 1] = n19;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final float n23 = fcmpg(n20, array[--n16]);
                            BytecodeManager.incBytecodes(7);
                            if (n23 >= 0) {
                                break;
                            }
                            array[n16 + 1] = array[n16];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[n16 + 1] = n20;
                        BytecodeManager.incBytecodes(6);
                        n16 = ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                    final float n24 = array[n2];
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final float n25 = fcmpg(n24, array[--n2]);
                        BytecodeManager.incBytecodes(7);
                        if (n25 >= 0) {
                            break;
                        }
                        array[n2 + 1] = array[n2];
                        BytecodeManager.incBytecodes(9);
                    }
                    array[n2 + 1] = n24;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n26 = (n3 >> 3) + (n3 >> 6) + 1;
            BytecodeManager.incBytecodes(10);
            final int n27 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n28 = n27 - n26;
            BytecodeManager.incBytecodes(4);
            final int n29 = n28 - n26;
            BytecodeManager.incBytecodes(4);
            final int n30 = n27 + n26;
            BytecodeManager.incBytecodes(4);
            final int n31 = n30 + n26;
            BytecodeManager.incBytecodes(4);
            final float n32 = fcmpg(array[n28], array[n29]);
            BytecodeManager.incBytecodes(8);
            if (n32 < 0) {
                final float n33 = array[n28];
                array[n28] = array[n29];
                array[n29] = n33;
                BytecodeManager.incBytecodes(14);
            }
            final float n34 = fcmpg(array[n27], array[n28]);
            BytecodeManager.incBytecodes(8);
            if (n34 < 0) {
                final float n35 = array[n27];
                array[n27] = array[n28];
                array[n28] = n35;
                BytecodeManager.incBytecodes(14);
                final float n36 = fcmpg(n35, array[n29]);
                BytecodeManager.incBytecodes(6);
                if (n36 < 0) {
                    array[n28] = array[n29];
                    array[n29] = n35;
                    BytecodeManager.incBytecodes(10);
                }
            }
            final float n37 = fcmpg(array[n30], array[n27]);
            BytecodeManager.incBytecodes(8);
            if (n37 < 0) {
                final float n38 = array[n30];
                array[n30] = array[n27];
                array[n27] = n38;
                BytecodeManager.incBytecodes(14);
                final float n39 = fcmpg(n38, array[n28]);
                BytecodeManager.incBytecodes(6);
                if (n39 < 0) {
                    array[n27] = array[n28];
                    array[n28] = n38;
                    BytecodeManager.incBytecodes(10);
                    final float n40 = fcmpg(n38, array[n29]);
                    BytecodeManager.incBytecodes(6);
                    if (n40 < 0) {
                        array[n28] = array[n29];
                        array[n29] = n38;
                        BytecodeManager.incBytecodes(10);
                    }
                }
            }
            final float n41 = fcmpg(array[n31], array[n30]);
            BytecodeManager.incBytecodes(8);
            if (n41 < 0) {
                final float n42 = array[n31];
                array[n31] = array[n30];
                array[n30] = n42;
                BytecodeManager.incBytecodes(14);
                final float n43 = fcmpg(n42, array[n27]);
                BytecodeManager.incBytecodes(6);
                if (n43 < 0) {
                    array[n30] = array[n27];
                    array[n27] = n42;
                    BytecodeManager.incBytecodes(10);
                    final float n44 = fcmpg(n42, array[n28]);
                    BytecodeManager.incBytecodes(6);
                    if (n44 < 0) {
                        array[n27] = array[n28];
                        array[n28] = n42;
                        BytecodeManager.incBytecodes(10);
                        final float n45 = fcmpg(n42, array[n29]);
                        BytecodeManager.incBytecodes(6);
                        if (n45 < 0) {
                            array[n28] = array[n29];
                            array[n29] = n42;
                            BytecodeManager.incBytecodes(10);
                        }
                    }
                }
            }
            int n46 = n;
            BytecodeManager.incBytecodes(2);
            int n47 = n2;
            BytecodeManager.incBytecodes(2);
            final float n48 = fcmpl(array[n29], array[n28]);
            BytecodeManager.incBytecodes(8);
            Label_1959: {
                if (n48 != 0) {
                    final float n49 = fcmpl(array[n28], array[n27]);
                    BytecodeManager.incBytecodes(8);
                    if (n49 != 0) {
                        final float n50 = fcmpl(array[n27], array[n30]);
                        BytecodeManager.incBytecodes(8);
                        if (n50 != 0) {
                            final float n51 = fcmpl(array[n30], array[n31]);
                            BytecodeManager.incBytecodes(8);
                            if (n51 != 0) {
                                final float n52 = array[n28];
                                BytecodeManager.incBytecodes(4);
                                final float n53 = array[n30];
                                BytecodeManager.incBytecodes(4);
                                array[n28] = array[n];
                                BytecodeManager.incBytecodes(6);
                                array[n30] = array[n2];
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final float n54 = fcmpg(array[++n46], n52);
                                    BytecodeManager.incBytecodes(7);
                                    if (n54 >= 0) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                while (true) {
                                    final float n55 = fcmpl(array[--n47], n53);
                                    BytecodeManager.incBytecodes(7);
                                    if (n55 <= 0) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                int n56 = n46 - 1;
                                BytecodeManager.incBytecodes(4);
                                while (true) {
                                    final int n57 = ++n56;
                                    final int n58 = n47;
                                    BytecodeManager.incBytecodes(4);
                                    if (n57 > n58) {
                                        break;
                                    }
                                    final float n59 = array[n56];
                                    BytecodeManager.incBytecodes(4);
                                    final float n60 = fcmpg(n59, n52);
                                    BytecodeManager.incBytecodes(4);
                                    Label_1286: {
                                        if (n60 < 0) {
                                            array[n56] = array[n46];
                                            BytecodeManager.incBytecodes(6);
                                            array[n46] = n59;
                                            BytecodeManager.incBytecodes(4);
                                            ++n46;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final float n61 = fcmpl(n59, n53);
                                            BytecodeManager.incBytecodes(4);
                                            if (n61 > 0) {
                                                int j;
                                                int n62;
                                                do {
                                                    final float n63 = fcmpl(array[n47], n53);
                                                    BytecodeManager.incBytecodes(6);
                                                    if (n63 <= 0) {
                                                        final float n64 = fcmpg(array[n47], n52);
                                                        BytecodeManager.incBytecodes(6);
                                                        if (n64 < 0) {
                                                            array[n56] = array[n46];
                                                            BytecodeManager.incBytecodes(6);
                                                            array[n46] = array[n47];
                                                            BytecodeManager.incBytecodes(6);
                                                            ++n46;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            array[n56] = array[n47];
                                                            BytecodeManager.incBytecodes(6);
                                                        }
                                                        array[n47] = n59;
                                                        BytecodeManager.incBytecodes(4);
                                                        --n47;
                                                        BytecodeManager.incBytecodes(1);
                                                        break Label_1286;
                                                    }
                                                    j = n47--;
                                                    n62 = n56;
                                                    BytecodeManager.incBytecodes(4);
                                                } while (j != n62);
                                                BytecodeManager.incBytecodes(1);
                                                break;
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                array[n] = array[n46 - 1];
                                array[n46 - 1] = n52;
                                BytecodeManager.incBytecodes(14);
                                array[n2] = array[n47 + 1];
                                array[n47 + 1] = n53;
                                BytecodeManager.incBytecodes(14);
                                final int n65 = n;
                                final int n66 = n46 - 2;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n65, n66, b);
                                final int n67 = n47 + 2;
                                final int n68 = n2;
                                final boolean b2 = false;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n67, n68, b2);
                                final int n69 = n46;
                                final int n70 = n29;
                                BytecodeManager.incBytecodes(3);
                                if (n69 < n70) {
                                    final int n71 = n31;
                                    final int n72 = n47;
                                    BytecodeManager.incBytecodes(3);
                                    if (n71 < n72) {
                                        while (true) {
                                            final float n73 = fcmpl(array[n46], n52);
                                            BytecodeManager.incBytecodes(6);
                                            if (n73 != 0) {
                                                break;
                                            }
                                            ++n46;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        while (true) {
                                            final float n74 = fcmpl(array[n47], n53);
                                            BytecodeManager.incBytecodes(6);
                                            if (n74 != 0) {
                                                break;
                                            }
                                            --n47;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        int n75 = n46 - 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n76 = ++n75;
                                            final int n77 = n47;
                                            BytecodeManager.incBytecodes(4);
                                            if (n76 > n77) {
                                                break;
                                            }
                                            final float n78 = array[n75];
                                            BytecodeManager.incBytecodes(4);
                                            final float n79 = fcmpl(n78, n52);
                                            BytecodeManager.incBytecodes(4);
                                            Label_1664: {
                                                if (n79 == 0) {
                                                    array[n75] = array[n46];
                                                    BytecodeManager.incBytecodes(6);
                                                    array[n46] = n78;
                                                    BytecodeManager.incBytecodes(4);
                                                    ++n46;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final float n80 = fcmpl(n78, n53);
                                                    BytecodeManager.incBytecodes(4);
                                                    if (n80 == 0) {
                                                        int k;
                                                        int n81;
                                                        do {
                                                            final float n82 = fcmpl(array[n47], n53);
                                                            BytecodeManager.incBytecodes(6);
                                                            if (n82 != 0) {
                                                                final float n83 = fcmpl(array[n47], n52);
                                                                BytecodeManager.incBytecodes(6);
                                                                if (n83 == 0) {
                                                                    array[n75] = array[n46];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    array[n46] = array[n47];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    ++n46;
                                                                    BytecodeManager.incBytecodes(2);
                                                                }
                                                                else {
                                                                    array[n75] = array[n47];
                                                                    BytecodeManager.incBytecodes(6);
                                                                }
                                                                array[n47] = n78;
                                                                BytecodeManager.incBytecodes(4);
                                                                --n47;
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_1664;
                                                            }
                                                            k = n47--;
                                                            n81 = n75;
                                                            BytecodeManager.incBytecodes(4);
                                                        } while (k != n81);
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                }
                                            }
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                }
                                final int n84 = n46;
                                final int n85 = n47;
                                final boolean b3 = false;
                                BytecodeManager.incBytecodes(5);
                                sort(array, n84, n85, b3);
                                BytecodeManager.incBytecodes(1);
                                break Label_1959;
                            }
                        }
                    }
                }
                final float n86 = array[n27];
                BytecodeManager.incBytecodes(4);
                int n87 = n46;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n88 = n87;
                    final int n89 = n47;
                    BytecodeManager.incBytecodes(3);
                    if (n88 > n89) {
                        break;
                    }
                    final float n90 = fcmpl(array[n87], n86);
                    BytecodeManager.incBytecodes(6);
                    if (n90 == 0) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final float n91 = array[n87];
                        BytecodeManager.incBytecodes(4);
                        final float n92 = fcmpg(n91, n86);
                        BytecodeManager.incBytecodes(4);
                        if (n92 < 0) {
                            array[n87] = array[n46];
                            BytecodeManager.incBytecodes(6);
                            array[n46] = n91;
                            BytecodeManager.incBytecodes(4);
                            ++n46;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            while (true) {
                                final float n93 = fcmpl(array[n47], n86);
                                BytecodeManager.incBytecodes(6);
                                if (n93 <= 0) {
                                    break;
                                }
                                --n47;
                                BytecodeManager.incBytecodes(2);
                            }
                            final float n94 = fcmpg(array[n47], n86);
                            BytecodeManager.incBytecodes(6);
                            if (n94 < 0) {
                                array[n87] = array[n46];
                                BytecodeManager.incBytecodes(6);
                                array[n46] = array[n47];
                                BytecodeManager.incBytecodes(6);
                                ++n46;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                array[n87] = array[n47];
                                BytecodeManager.incBytecodes(6);
                            }
                            array[n47] = n91;
                            BytecodeManager.incBytecodes(4);
                            --n47;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    ++n87;
                    BytecodeManager.incBytecodes(2);
                }
                final int n95 = n;
                final int n96 = n46 - 1;
                BytecodeManager.incBytecodes(7);
                sort(array, n95, n96, b);
                final int n97 = n47 + 1;
                final int n98 = n2;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(7);
                sort(array, n97, n98, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(final double[] array, int n, int n2, final double[] array2, final int n3, final int n4) {
        try {
            while (true) {
                final int n5 = n;
                final int n6 = n2;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    break;
                }
                final double v = array[n2];
                BytecodeManager.incBytecodes(4);
                final boolean naN = Double.isNaN(v);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    break;
                }
                --n2;
                BytecodeManager.incBytecodes(2);
            }
            int n7 = n2;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n8 = --n7;
                final int n9 = n;
                BytecodeManager.incBytecodes(4);
                if (n8 < n9) {
                    break;
                }
                final double n10 = array[n7];
                BytecodeManager.incBytecodes(4);
                final double n11 = dcmpl(n10, n10);
                BytecodeManager.incBytecodes(4);
                if (n11 != 0) {
                    array[n7] = array[n2];
                    BytecodeManager.incBytecodes(6);
                    array[n2] = n10;
                    BytecodeManager.incBytecodes(4);
                    --n2;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            final int n12 = n;
            final int n13 = n2;
            BytecodeManager.incBytecodes(7);
            doSort(array, n12, n13, array2, n3, n4);
            int n14 = n2;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n15 = n;
                final int n16 = n14;
                BytecodeManager.incBytecodes(3);
                if (n15 >= n16) {
                    break;
                }
                final int n17 = n + n14 >>> 1;
                BytecodeManager.incBytecodes(6);
                final double n18 = array[n17];
                BytecodeManager.incBytecodes(4);
                final double n19 = dcmpg(n18, 0.0);
                BytecodeManager.incBytecodes(4);
                if (n19 < 0) {
                    n = n17 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    n14 = n17;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            while (true) {
                final int n20 = n;
                final int n21 = n2;
                BytecodeManager.incBytecodes(3);
                if (n20 > n21) {
                    break;
                }
                final double n22 = array[n];
                BytecodeManager.incBytecodes(4);
                final long n23 = lcmp(Double.doubleToRawLongBits(n22), 0L);
                BytecodeManager.incBytecodes(3);
                if (n23 >= 0) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            int n24 = n;
            int n25 = n - 1;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n26 = ++n24;
                final int n27 = n2;
                BytecodeManager.incBytecodes(4);
                if (n26 > n27) {
                    break;
                }
                final double n28 = array[n24];
                BytecodeManager.incBytecodes(4);
                final double n29 = dcmpl(n28, 0.0);
                BytecodeManager.incBytecodes(4);
                if (n29 != 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final double n30 = n28;
                BytecodeManager.incBytecodes(2);
                final long n31 = lcmp(Double.doubleToRawLongBits(n30), 0L);
                BytecodeManager.incBytecodes(3);
                if (n31 < 0) {
                    array[n24] = 0.0;
                    BytecodeManager.incBytecodes(4);
                    array[++n25] = -0.0;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void doSort(double[] array, final int n, int n2, double[] array2, int n3, final int n4) {
        try {
            final int n5 = n2 - n;
            final int n6 = 286;
            BytecodeManager.incBytecodes(5);
            if (n5 < n6) {
                final double[] array3 = array;
                final int n7 = n2;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                sort(array3, n, n7, b);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int[] array4 = new int[68];
            BytecodeManager.incBytecodes(2);
            int n8 = 0;
            array4[0] = n;
            BytecodeManager.incBytecodes(6);
            int n9 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n2;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = array4[n8];
                    final int n13 = n2++;
                    BytecodeManager.incBytecodes(6);
                    if (n12 == n13) {
                        array4[++n8] = n2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        final int n14 = n8;
                        final int n15 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n14 == n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                    byte b2 = 0;
                    BytecodeManager.incBytecodes(2);
                    int n16 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        n16 <<= 1;
                        final int n17 = n8;
                        BytecodeManager.incBytecodes(7);
                        if (n16 >= n17) {
                            break;
                        }
                        b2 ^= 0x1;
                        BytecodeManager.incBytecodes(6);
                    }
                    final int n18 = n2 - n;
                    BytecodeManager.incBytecodes(4);
                    final double[] array5 = array2;
                    BytecodeManager.incBytecodes(2);
                    Label_0556: {
                        if (array5 != null) {
                            final int n19 = n18;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n19) {
                                final int n20 = n3 + n18;
                                final int length = array2.length;
                                BytecodeManager.incBytecodes(6);
                                if (n20 <= length) {
                                    break Label_0556;
                                }
                            }
                        }
                        array2 = new double[n18];
                        BytecodeManager.incBytecodes(2);
                        n3 = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    final byte b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    double[] array8;
                    int n23;
                    int n24;
                    if (b3 == 0) {
                        final double[] array6 = array;
                        final double[] array7 = array2;
                        final int n21 = n3;
                        final int n22 = n18;
                        BytecodeManager.incBytecodes(6);
                        System.arraycopy(array6, n, array7, n21, n22);
                        array8 = array;
                        BytecodeManager.incBytecodes(2);
                        n23 = 0;
                        BytecodeManager.incBytecodes(2);
                        array = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = n3 - n;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        array8 = array2;
                        BytecodeManager.incBytecodes(2);
                        n24 = 0;
                        BytecodeManager.incBytecodes(2);
                        n23 = n3 - n;
                        BytecodeManager.incBytecodes(4);
                    }
                    while (true) {
                        final int n25 = n8;
                        final int n26 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n25 <= n26) {
                            break;
                        }
                        int n28;
                        int n27 = (n28 = 0) + 2;
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            final int n29 = n27;
                            final int n30 = n8;
                            BytecodeManager.incBytecodes(3);
                            if (n29 > n30) {
                                break;
                            }
                            final int n31 = array4[n27];
                            final int n32 = array4[n27 - 1];
                            BytecodeManager.incBytecodes(10);
                            int n34;
                            int n33 = n34 = array4[n27 - 2];
                            int n35 = n32;
                            BytecodeManager.incBytecodes(10);
                            while (true) {
                                final int n36 = n33;
                                final int n37 = n31;
                                BytecodeManager.incBytecodes(3);
                                if (n36 >= n37) {
                                    break;
                                }
                                final int n38 = n35;
                                final int n39 = n31;
                                BytecodeManager.incBytecodes(3);
                                Label_0832: {
                                    Label_0783: {
                                        if (n38 < n39) {
                                            final int n40 = n34;
                                            final int n41 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n40 < n41) {
                                                final double n42 = dcmpg(array[n34 + n24], array[n35 + n24]);
                                                BytecodeManager.incBytecodes(12);
                                                if (n42 <= 0) {
                                                    break Label_0783;
                                                }
                                            }
                                            array8[n33 + n23] = array[n35++ + n24];
                                            BytecodeManager.incBytecodes(11);
                                            break Label_0832;
                                        }
                                    }
                                    array8[n33 + n23] = array[n34++ + n24];
                                    BytecodeManager.incBytecodes(12);
                                }
                                ++n33;
                                BytecodeManager.incBytecodes(2);
                            }
                            array4[++n28] = n31;
                            BytecodeManager.incBytecodes(5);
                            n27 += 2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n43 = n8 & 0x1;
                        BytecodeManager.incBytecodes(4);
                        if (n43 != 0) {
                            int n44 = n2;
                            final int n45 = array4[n8 - 1];
                            BytecodeManager.incBytecodes(8);
                            while (true) {
                                final int n46 = --n44;
                                final int n47 = n45;
                                BytecodeManager.incBytecodes(4);
                                if (n46 < n47) {
                                    break;
                                }
                                array8[n44 + n23] = array[n44 + n24];
                                BytecodeManager.incBytecodes(11);
                            }
                            array4[++n28] = n2;
                            BytecodeManager.incBytecodes(5);
                        }
                        final double[] array9 = array;
                        array = array8;
                        array8 = array9;
                        BytecodeManager.incBytecodes(6);
                        final int n48 = n24;
                        n24 = n23;
                        n23 = n48;
                        BytecodeManager.incBytecodes(6);
                        n8 = n28;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final double n49 = dcmpg(array[n9], array[n9 + 1]);
                BytecodeManager.incBytecodes(10);
                Label_0345: {
                    if (n49 < 0) {
                        while (true) {
                            final int n50 = ++n9;
                            final int n51 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n50 > n51) {
                                break;
                            }
                            final double n52 = dcmpg(array[n9 - 1], array[n9]);
                            BytecodeManager.incBytecodes(10);
                            if (n52 > 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final double n53 = dcmpl(array[n9], array[n9 + 1]);
                        BytecodeManager.incBytecodes(10);
                        if (n53 <= 0) {
                            int n54 = 33;
                            BytecodeManager.incBytecodes(2);
                            int i;
                            do {
                                final int n55 = ++n9;
                                final int n56 = n2;
                                BytecodeManager.incBytecodes(4);
                                if (n55 > n56) {
                                    break Label_0345;
                                }
                                final double n57 = dcmpl(array[n9 - 1], array[n9]);
                                BytecodeManager.incBytecodes(10);
                                if (n57 != 0) {
                                    break Label_0345;
                                }
                                i = --n54;
                                BytecodeManager.incBytecodes(3);
                            } while (i != 0);
                            final double[] array10 = array;
                            final int n58 = n2;
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(5);
                            sort(array10, n, n58, b4);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        while (true) {
                            final int n59 = ++n9;
                            final int n60 = n2;
                            BytecodeManager.incBytecodes(4);
                            if (n59 > n60) {
                                break;
                            }
                            final double n61 = dcmpl(array[n9 - 1], array[n9]);
                            BytecodeManager.incBytecodes(10);
                            if (n61 < 0) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        int n62 = array4[n8] - 1;
                        int n63 = n9;
                        BytecodeManager.incBytecodes(8);
                        while (true) {
                            final int n64 = ++n62;
                            final int n65 = --n63;
                            BytecodeManager.incBytecodes(5);
                            if (n64 >= n65) {
                                break;
                            }
                            final double n66 = array[n62];
                            array[n62] = array[n63];
                            array[n63] = n66;
                            BytecodeManager.incBytecodes(14);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n67 = ++n8;
                final int n68 = 67;
                BytecodeManager.incBytecodes(4);
                if (n67 == n68) {
                    final double[] array11 = array;
                    final int n69 = n2;
                    final boolean b5 = true;
                    BytecodeManager.incBytecodes(5);
                    sort(array11, n, n69, b5);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                array4[n8] = n9;
                BytecodeManager.incBytecodes(5);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void sort(final double[] array, int n, int n2, final boolean b) {
        try {
            final int n3 = n2 - n + 1;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3;
            final int n5 = 47;
            BytecodeManager.incBytecodes(3);
            if (n4 < n5) {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    int n7;
                    int n6 = n7 = n;
                    BytecodeManager.incBytecodes(4);
                Label_0045:
                    while (true) {
                        final int n8 = n6;
                        final int n9 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 < n9) {
                            final double n10 = array[n6 + 1];
                            BytecodeManager.incBytecodes(6);
                            while (true) {
                                int i;
                                int n11;
                                do {
                                    final double n12 = dcmpg(n10, array[n7]);
                                    BytecodeManager.incBytecodes(6);
                                    if (n12 >= 0) {
                                        array[n7 + 1] = n10;
                                        BytecodeManager.incBytecodes(6);
                                        n7 = ++n6;
                                        BytecodeManager.incBytecodes(4);
                                        continue Label_0045;
                                    }
                                    array[n7 + 1] = array[n7];
                                    BytecodeManager.incBytecodes(8);
                                    i = n7--;
                                    n11 = n;
                                    BytecodeManager.incBytecodes(4);
                                } while (i != n11);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    double n13;
                    do {
                        final int n14 = n;
                        final int n15 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n14 >= n15) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        n13 = dcmpl(array[++n], array[n - 1]);
                        BytecodeManager.incBytecodes(11);
                    } while (n13 >= 0);
                    int n16 = n;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n17 = ++n;
                        final int n18 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (n17 > n18) {
                            break;
                        }
                        double n19 = array[n16];
                        double n20 = array[n];
                        BytecodeManager.incBytecodes(8);
                        final double n21 = dcmpg(n19, n20);
                        BytecodeManager.incBytecodes(4);
                        if (n21 < 0) {
                            n20 = n19;
                            n19 = array[n];
                            BytecodeManager.incBytecodes(6);
                        }
                        while (true) {
                            final double n22 = dcmpg(n19, array[--n16]);
                            BytecodeManager.incBytecodes(7);
                            if (n22 >= 0) {
                                break;
                            }
                            array[n16 + 2] = array[n16];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[++n16 + 1] = n19;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final double n23 = dcmpg(n20, array[--n16]);
                            BytecodeManager.incBytecodes(7);
                            if (n23 >= 0) {
                                break;
                            }
                            array[n16 + 1] = array[n16];
                            BytecodeManager.incBytecodes(9);
                        }
                        array[n16 + 1] = n20;
                        BytecodeManager.incBytecodes(6);
                        n16 = ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                    final double n24 = array[n2];
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final double n25 = dcmpg(n24, array[--n2]);
                        BytecodeManager.incBytecodes(7);
                        if (n25 >= 0) {
                            break;
                        }
                        array[n2 + 1] = array[n2];
                        BytecodeManager.incBytecodes(9);
                    }
                    array[n2 + 1] = n24;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n26 = (n3 >> 3) + (n3 >> 6) + 1;
            BytecodeManager.incBytecodes(10);
            final int n27 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n28 = n27 - n26;
            BytecodeManager.incBytecodes(4);
            final int n29 = n28 - n26;
            BytecodeManager.incBytecodes(4);
            final int n30 = n27 + n26;
            BytecodeManager.incBytecodes(4);
            final int n31 = n30 + n26;
            BytecodeManager.incBytecodes(4);
            final double n32 = dcmpg(array[n28], array[n29]);
            BytecodeManager.incBytecodes(8);
            if (n32 < 0) {
                final double n33 = array[n28];
                array[n28] = array[n29];
                array[n29] = n33;
                BytecodeManager.incBytecodes(14);
            }
            final double n34 = dcmpg(array[n27], array[n28]);
            BytecodeManager.incBytecodes(8);
            if (n34 < 0) {
                final double n35 = array[n27];
                array[n27] = array[n28];
                array[n28] = n35;
                BytecodeManager.incBytecodes(14);
                final double n36 = dcmpg(n35, array[n29]);
                BytecodeManager.incBytecodes(6);
                if (n36 < 0) {
                    array[n28] = array[n29];
                    array[n29] = n35;
                    BytecodeManager.incBytecodes(10);
                }
            }
            final double n37 = dcmpg(array[n30], array[n27]);
            BytecodeManager.incBytecodes(8);
            if (n37 < 0) {
                final double n38 = array[n30];
                array[n30] = array[n27];
                array[n27] = n38;
                BytecodeManager.incBytecodes(14);
                final double n39 = dcmpg(n38, array[n28]);
                BytecodeManager.incBytecodes(6);
                if (n39 < 0) {
                    array[n27] = array[n28];
                    array[n28] = n38;
                    BytecodeManager.incBytecodes(10);
                    final double n40 = dcmpg(n38, array[n29]);
                    BytecodeManager.incBytecodes(6);
                    if (n40 < 0) {
                        array[n28] = array[n29];
                        array[n29] = n38;
                        BytecodeManager.incBytecodes(10);
                    }
                }
            }
            final double n41 = dcmpg(array[n31], array[n30]);
            BytecodeManager.incBytecodes(8);
            if (n41 < 0) {
                final double n42 = array[n31];
                array[n31] = array[n30];
                array[n30] = n42;
                BytecodeManager.incBytecodes(14);
                final double n43 = dcmpg(n42, array[n27]);
                BytecodeManager.incBytecodes(6);
                if (n43 < 0) {
                    array[n30] = array[n27];
                    array[n27] = n42;
                    BytecodeManager.incBytecodes(10);
                    final double n44 = dcmpg(n42, array[n28]);
                    BytecodeManager.incBytecodes(6);
                    if (n44 < 0) {
                        array[n27] = array[n28];
                        array[n28] = n42;
                        BytecodeManager.incBytecodes(10);
                        final double n45 = dcmpg(n42, array[n29]);
                        BytecodeManager.incBytecodes(6);
                        if (n45 < 0) {
                            array[n28] = array[n29];
                            array[n29] = n42;
                            BytecodeManager.incBytecodes(10);
                        }
                    }
                }
            }
            int n46 = n;
            BytecodeManager.incBytecodes(2);
            int n47 = n2;
            BytecodeManager.incBytecodes(2);
            final double n48 = dcmpl(array[n29], array[n28]);
            BytecodeManager.incBytecodes(8);
            Label_1959: {
                if (n48 != 0) {
                    final double n49 = dcmpl(array[n28], array[n27]);
                    BytecodeManager.incBytecodes(8);
                    if (n49 != 0) {
                        final double n50 = dcmpl(array[n27], array[n30]);
                        BytecodeManager.incBytecodes(8);
                        if (n50 != 0) {
                            final double n51 = dcmpl(array[n30], array[n31]);
                            BytecodeManager.incBytecodes(8);
                            if (n51 != 0) {
                                final double n52 = array[n28];
                                BytecodeManager.incBytecodes(4);
                                final double n53 = array[n30];
                                BytecodeManager.incBytecodes(4);
                                array[n28] = array[n];
                                BytecodeManager.incBytecodes(6);
                                array[n30] = array[n2];
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final double n54 = dcmpg(array[++n46], n52);
                                    BytecodeManager.incBytecodes(7);
                                    if (n54 >= 0) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                while (true) {
                                    final double n55 = dcmpl(array[--n47], n53);
                                    BytecodeManager.incBytecodes(7);
                                    if (n55 <= 0) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                int n56 = n46 - 1;
                                BytecodeManager.incBytecodes(4);
                                while (true) {
                                    final int n57 = ++n56;
                                    final int n58 = n47;
                                    BytecodeManager.incBytecodes(4);
                                    if (n57 > n58) {
                                        break;
                                    }
                                    final double n59 = array[n56];
                                    BytecodeManager.incBytecodes(4);
                                    final double n60 = dcmpg(n59, n52);
                                    BytecodeManager.incBytecodes(4);
                                    Label_1286: {
                                        if (n60 < 0) {
                                            array[n56] = array[n46];
                                            BytecodeManager.incBytecodes(6);
                                            array[n46] = n59;
                                            BytecodeManager.incBytecodes(4);
                                            ++n46;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final double n61 = dcmpl(n59, n53);
                                            BytecodeManager.incBytecodes(4);
                                            if (n61 > 0) {
                                                int j;
                                                int n62;
                                                do {
                                                    final double n63 = dcmpl(array[n47], n53);
                                                    BytecodeManager.incBytecodes(6);
                                                    if (n63 <= 0) {
                                                        final double n64 = dcmpg(array[n47], n52);
                                                        BytecodeManager.incBytecodes(6);
                                                        if (n64 < 0) {
                                                            array[n56] = array[n46];
                                                            BytecodeManager.incBytecodes(6);
                                                            array[n46] = array[n47];
                                                            BytecodeManager.incBytecodes(6);
                                                            ++n46;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            array[n56] = array[n47];
                                                            BytecodeManager.incBytecodes(6);
                                                        }
                                                        array[n47] = n59;
                                                        BytecodeManager.incBytecodes(4);
                                                        --n47;
                                                        BytecodeManager.incBytecodes(1);
                                                        break Label_1286;
                                                    }
                                                    j = n47--;
                                                    n62 = n56;
                                                    BytecodeManager.incBytecodes(4);
                                                } while (j != n62);
                                                BytecodeManager.incBytecodes(1);
                                                break;
                                            }
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                array[n] = array[n46 - 1];
                                array[n46 - 1] = n52;
                                BytecodeManager.incBytecodes(14);
                                array[n2] = array[n47 + 1];
                                array[n47 + 1] = n53;
                                BytecodeManager.incBytecodes(14);
                                final int n65 = n;
                                final int n66 = n46 - 2;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n65, n66, b);
                                final int n67 = n47 + 2;
                                final int n68 = n2;
                                final boolean b2 = false;
                                BytecodeManager.incBytecodes(7);
                                sort(array, n67, n68, b2);
                                final int n69 = n46;
                                final int n70 = n29;
                                BytecodeManager.incBytecodes(3);
                                if (n69 < n70) {
                                    final int n71 = n31;
                                    final int n72 = n47;
                                    BytecodeManager.incBytecodes(3);
                                    if (n71 < n72) {
                                        while (true) {
                                            final double n73 = dcmpl(array[n46], n52);
                                            BytecodeManager.incBytecodes(6);
                                            if (n73 != 0) {
                                                break;
                                            }
                                            ++n46;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        while (true) {
                                            final double n74 = dcmpl(array[n47], n53);
                                            BytecodeManager.incBytecodes(6);
                                            if (n74 != 0) {
                                                break;
                                            }
                                            --n47;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        int n75 = n46 - 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n76 = ++n75;
                                            final int n77 = n47;
                                            BytecodeManager.incBytecodes(4);
                                            if (n76 > n77) {
                                                break;
                                            }
                                            final double n78 = array[n75];
                                            BytecodeManager.incBytecodes(4);
                                            final double n79 = dcmpl(n78, n52);
                                            BytecodeManager.incBytecodes(4);
                                            Label_1664: {
                                                if (n79 == 0) {
                                                    array[n75] = array[n46];
                                                    BytecodeManager.incBytecodes(6);
                                                    array[n46] = n78;
                                                    BytecodeManager.incBytecodes(4);
                                                    ++n46;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final double n80 = dcmpl(n78, n53);
                                                    BytecodeManager.incBytecodes(4);
                                                    if (n80 == 0) {
                                                        int k;
                                                        int n81;
                                                        do {
                                                            final double n82 = dcmpl(array[n47], n53);
                                                            BytecodeManager.incBytecodes(6);
                                                            if (n82 != 0) {
                                                                final double n83 = dcmpl(array[n47], n52);
                                                                BytecodeManager.incBytecodes(6);
                                                                if (n83 == 0) {
                                                                    array[n75] = array[n46];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    array[n46] = array[n47];
                                                                    BytecodeManager.incBytecodes(6);
                                                                    ++n46;
                                                                    BytecodeManager.incBytecodes(2);
                                                                }
                                                                else {
                                                                    array[n75] = array[n47];
                                                                    BytecodeManager.incBytecodes(6);
                                                                }
                                                                array[n47] = n78;
                                                                BytecodeManager.incBytecodes(4);
                                                                --n47;
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_1664;
                                                            }
                                                            k = n47--;
                                                            n81 = n75;
                                                            BytecodeManager.incBytecodes(4);
                                                        } while (k != n81);
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                }
                                            }
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                }
                                final int n84 = n46;
                                final int n85 = n47;
                                final boolean b3 = false;
                                BytecodeManager.incBytecodes(5);
                                sort(array, n84, n85, b3);
                                BytecodeManager.incBytecodes(1);
                                break Label_1959;
                            }
                        }
                    }
                }
                final double n86 = array[n27];
                BytecodeManager.incBytecodes(4);
                int n87 = n46;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n88 = n87;
                    final int n89 = n47;
                    BytecodeManager.incBytecodes(3);
                    if (n88 > n89) {
                        break;
                    }
                    final double n90 = dcmpl(array[n87], n86);
                    BytecodeManager.incBytecodes(6);
                    if (n90 == 0) {
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final double n91 = array[n87];
                        BytecodeManager.incBytecodes(4);
                        final double n92 = dcmpg(n91, n86);
                        BytecodeManager.incBytecodes(4);
                        if (n92 < 0) {
                            array[n87] = array[n46];
                            BytecodeManager.incBytecodes(6);
                            array[n46] = n91;
                            BytecodeManager.incBytecodes(4);
                            ++n46;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            while (true) {
                                final double n93 = dcmpl(array[n47], n86);
                                BytecodeManager.incBytecodes(6);
                                if (n93 <= 0) {
                                    break;
                                }
                                --n47;
                                BytecodeManager.incBytecodes(2);
                            }
                            final double n94 = dcmpg(array[n47], n86);
                            BytecodeManager.incBytecodes(6);
                            if (n94 < 0) {
                                array[n87] = array[n46];
                                BytecodeManager.incBytecodes(6);
                                array[n46] = array[n47];
                                BytecodeManager.incBytecodes(6);
                                ++n46;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                array[n87] = array[n47];
                                BytecodeManager.incBytecodes(6);
                            }
                            array[n47] = n91;
                            BytecodeManager.incBytecodes(4);
                            --n47;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    ++n87;
                    BytecodeManager.incBytecodes(2);
                }
                final int n95 = n;
                final int n96 = n46 - 1;
                BytecodeManager.incBytecodes(7);
                sort(array, n95, n96, b);
                final int n97 = n47 + 1;
                final int n98 = n2;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(7);
                sort(array, n97, n98, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
