// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.PermissionCollection;
import java.security.Permission;
import aic2021.engine.BytecodeManager;
import java.security.BasicPermission;

public final class PropertyPermission extends BasicPermission
{
    private static final int READ = 1;
    private static final int WRITE = 2;
    private static final int ALL = 3;
    private static final int NONE = 0;
    private transient int mask;
    private String actions;
    private static final long serialVersionUID = 885438825399942851L;
    
    private void init(final int mask) {
        try {
            final int n = mask & 0x3;
            BytecodeManager.incBytecodes(5);
            if (n != mask) {
                final String s = "invalid actions mask";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (mask == 0) {
                final String s2 = "invalid actions mask";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(2);
            final String name = this.getName();
            BytecodeManager.incBytecodes(1);
            if (name == null) {
                final String s3 = "name can't be null";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex3 = new NullPointerException(s3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            this.mask = mask;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PropertyPermission(final String name, final String actions) {
        try {
            BytecodeManager.incBytecodes(4);
            super(name, actions);
            BytecodeManager.incBytecodes(3);
            final int mask = getMask(actions);
            BytecodeManager.incBytecodes(1);
            this.init(mask);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean implies(final Permission permission) {
        try {
            final boolean b = permission instanceof PropertyPermission;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final PropertyPermission propertyPermission = (PropertyPermission)permission;
            BytecodeManager.incBytecodes(3);
            final int n = this.mask & propertyPermission.mask;
            final int mask = propertyPermission.mask;
            BytecodeManager.incBytecodes(8);
            boolean b3 = false;
            Label_0083: {
                if (n == mask) {
                    final PropertyPermission p = propertyPermission;
                    BytecodeManager.incBytecodes(3);
                    final boolean implies = super.implies(p);
                    BytecodeManager.incBytecodes(1);
                    if (implies) {
                        b3 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0083;
                    }
                }
                b3 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            if (o == this) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = o instanceof PropertyPermission;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final PropertyPermission propertyPermission = (PropertyPermission)o;
            BytecodeManager.incBytecodes(3);
            final int mask = this.mask;
            final int mask2 = propertyPermission.mask;
            BytecodeManager.incBytecodes(5);
            boolean b4 = false;
            Label_0116: {
                if (mask == mask2) {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String name = this.getName();
                    final PropertyPermission propertyPermission2 = propertyPermission;
                    BytecodeManager.incBytecodes(2);
                    final String name2 = propertyPermission2.getName();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = name.equals(name2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        b4 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0116;
                    }
                }
                b4 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            BytecodeManager.incBytecodes(2);
            final String name = this.getName();
            BytecodeManager.incBytecodes(1);
            final int hashCode = name.hashCode();
            BytecodeManager.incBytecodes(1);
            return hashCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int getMask(final String s) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final String s2 = "read";
            BytecodeManager.incBytecodes(3);
            if (s == s2) {
                final int n3 = 1;
                BytecodeManager.incBytecodes(2);
                return n3;
            }
            final String s3 = "write";
            BytecodeManager.incBytecodes(3);
            if (s == s3) {
                final int n4 = 2;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            final String s4 = "read,write";
            BytecodeManager.incBytecodes(3);
            if (s == s4) {
                final int n5 = 3;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            BytecodeManager.incBytecodes(2);
            final char[] charArray = s.toCharArray();
            BytecodeManager.incBytecodes(1);
            int n6 = charArray.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n7 = n6;
            BytecodeManager.incBytecodes(2);
            if (n7 < 0) {
                final int n8 = n;
                BytecodeManager.incBytecodes(2);
                return n8;
            }
            Label_0802: {
                Label_0716: {
                    while (true) {
                        final int n9 = n6;
                        final int n10 = -1;
                        BytecodeManager.incBytecodes(3);
                        if (n9 == n10) {
                            break Label_0802;
                        }
                        while (true) {
                            final int n11 = n6;
                            final int n12 = -1;
                            BytecodeManager.incBytecodes(3);
                            if (n11 == n12) {
                                break;
                            }
                            final char c2;
                            final char c = c2 = charArray[n6];
                            final int n13 = ' ';
                            BytecodeManager.incBytecodes(7);
                            if (c != n13) {
                                final char c3 = c2;
                                final int n14 = '\r';
                                BytecodeManager.incBytecodes(3);
                                if (c3 != n14) {
                                    final char c4 = c2;
                                    final int n15 = '\n';
                                    BytecodeManager.incBytecodes(3);
                                    if (c4 != n15) {
                                        final char c5 = c2;
                                        final int n16 = '\f';
                                        BytecodeManager.incBytecodes(3);
                                        if (c5 != n16) {
                                            final char c6 = c2;
                                            final int n17 = '\t';
                                            BytecodeManager.incBytecodes(3);
                                            if (c6 != n17) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            --n6;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n18 = n6;
                        final int n19 = 3;
                        BytecodeManager.incBytecodes(3);
                        int n28 = 0;
                        Label_0592: {
                            Label_0359: {
                                if (n18 >= n19) {
                                    final char c7 = charArray[n6 - 3];
                                    final int n20 = 'r';
                                    BytecodeManager.incBytecodes(7);
                                    if (c7 != n20) {
                                        final char c8 = charArray[n6 - 3];
                                        final int n21 = 'R';
                                        BytecodeManager.incBytecodes(7);
                                        if (c8 != n21) {
                                            break Label_0359;
                                        }
                                    }
                                    final char c9 = charArray[n6 - 2];
                                    final int n22 = 'e';
                                    BytecodeManager.incBytecodes(7);
                                    if (c9 != n22) {
                                        final char c10 = charArray[n6 - 2];
                                        final int n23 = 'E';
                                        BytecodeManager.incBytecodes(7);
                                        if (c10 != n23) {
                                            break Label_0359;
                                        }
                                    }
                                    final char c11 = charArray[n6 - 1];
                                    final int n24 = 'a';
                                    BytecodeManager.incBytecodes(7);
                                    if (c11 != n24) {
                                        final char c12 = charArray[n6 - 1];
                                        final int n25 = 'A';
                                        BytecodeManager.incBytecodes(7);
                                        if (c12 != n25) {
                                            break Label_0359;
                                        }
                                    }
                                    final char c13 = charArray[n6];
                                    final int n26 = 'd';
                                    BytecodeManager.incBytecodes(5);
                                    if (c13 != n26) {
                                        final char c14 = charArray[n6];
                                        final int n27 = 'D';
                                        BytecodeManager.incBytecodes(5);
                                        if (c14 != n27) {
                                            break Label_0359;
                                        }
                                    }
                                    n28 = 4;
                                    BytecodeManager.incBytecodes(2);
                                    n |= 0x1;
                                    BytecodeManager.incBytecodes(5);
                                    break Label_0592;
                                }
                            }
                            final int n29 = n6;
                            final int n30 = 4;
                            BytecodeManager.incBytecodes(3);
                            if (n29 < n30) {
                                break;
                            }
                            final char c15 = charArray[n6 - 4];
                            final int n31 = 'w';
                            BytecodeManager.incBytecodes(7);
                            if (c15 != n31) {
                                final char c16 = charArray[n6 - 4];
                                final int n32 = 'W';
                                BytecodeManager.incBytecodes(7);
                                if (c16 != n32) {
                                    break;
                                }
                            }
                            final char c17 = charArray[n6 - 3];
                            final int n33 = 'r';
                            BytecodeManager.incBytecodes(7);
                            if (c17 != n33) {
                                final char c18 = charArray[n6 - 3];
                                final int n34 = 'R';
                                BytecodeManager.incBytecodes(7);
                                if (c18 != n34) {
                                    break;
                                }
                            }
                            final char c19 = charArray[n6 - 2];
                            final int n35 = 'i';
                            BytecodeManager.incBytecodes(7);
                            if (c19 != n35) {
                                final char c20 = charArray[n6 - 2];
                                final int n36 = 'I';
                                BytecodeManager.incBytecodes(7);
                                if (c20 != n36) {
                                    break;
                                }
                            }
                            final char c21 = charArray[n6 - 1];
                            final int n37 = 't';
                            BytecodeManager.incBytecodes(7);
                            if (c21 != n37) {
                                final char c22 = charArray[n6 - 1];
                                final int n38 = 'T';
                                BytecodeManager.incBytecodes(7);
                                if (c22 != n38) {
                                    break;
                                }
                            }
                            final char c23 = charArray[n6];
                            final int n39 = 'e';
                            BytecodeManager.incBytecodes(5);
                            if (c23 != n39) {
                                final char c24 = charArray[n6];
                                final int n40 = 'E';
                                BytecodeManager.incBytecodes(5);
                                if (c24 != n40) {
                                    break;
                                }
                            }
                            n28 = 5;
                            BytecodeManager.incBytecodes(2);
                            n |= 0x2;
                            BytecodeManager.incBytecodes(5);
                        }
                        boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n41 = n6;
                            final int n42 = n28;
                            BytecodeManager.incBytecodes(3);
                            if (n41 < n42) {
                                break;
                            }
                            final boolean b2 = b;
                            BytecodeManager.incBytecodes(2);
                            if (b2) {
                                break;
                            }
                            final char c25 = charArray[n6 - n28];
                            BytecodeManager.incBytecodes(6);
                            switch (c25) {
                                case 44: {
                                    b = true;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                case 9:
                                case 10:
                                case 12:
                                case 13:
                                case 32: {
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                default: {
                                    break Label_0716;
                                }
                            }
                            --n6;
                            BytecodeManager.incBytecodes(2);
                        }
                        n6 -= n28;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "invalid permission: ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(s);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex = new IllegalArgumentException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "invalid permission: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(s);
                BytecodeManager.incBytecodes(1);
                final String string2 = append4.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n43 = n;
            BytecodeManager.incBytecodes(2);
            return n43;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static String getActions(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            final int n3 = n & 0x1;
            final int n4 = 1;
            BytecodeManager.incBytecodes(5);
            if (n3 == n4) {
                n2 = 1;
                BytecodeManager.incBytecodes(2);
                final StringBuilder sb2 = sb;
                final String str = "read";
                BytecodeManager.incBytecodes(3);
                sb2.append(str);
                BytecodeManager.incBytecodes(1);
            }
            final int n5 = n & 0x2;
            final int n6 = 2;
            BytecodeManager.incBytecodes(5);
            if (n5 == n6) {
                final int n7 = n2;
                BytecodeManager.incBytecodes(2);
                if (n7 != 0) {
                    final StringBuilder sb3 = sb;
                    final char c = ',';
                    BytecodeManager.incBytecodes(3);
                    sb3.append(c);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                }
                final StringBuilder sb4 = sb;
                final String str2 = "write";
                BytecodeManager.incBytecodes(3);
                sb4.append(str2);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder sb5 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb5.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getActions() {
        try {
            final String actions = this.actions;
            BytecodeManager.incBytecodes(3);
            if (actions == null) {
                final int mask = this.mask;
                BytecodeManager.incBytecodes(4);
                this.actions = getActions(mask);
                BytecodeManager.incBytecodes(1);
            }
            final String actions2 = this.actions;
            BytecodeManager.incBytecodes(3);
            return actions2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int getMask() {
        try {
            final int mask = this.mask;
            BytecodeManager.incBytecodes(3);
            return mask;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public PermissionCollection newPermissionCollection() {
        try {
            BytecodeManager.incBytecodes(3);
            final PropertyPermissionCollection collection = new PropertyPermissionCollection();
            BytecodeManager.incBytecodes(1);
            return collection;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            final String actions = this.actions;
            BytecodeManager.incBytecodes(3);
            if (actions == null) {
                BytecodeManager.incBytecodes(2);
                this.getActions();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            final String actions = this.actions;
            BytecodeManager.incBytecodes(4);
            final int mask = getMask(actions);
            BytecodeManager.incBytecodes(1);
            this.init(mask);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
