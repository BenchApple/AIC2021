// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.regex;

import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;
import aic2021.engine.BytecodeManager;

public class PatternSyntaxException extends IllegalArgumentException
{
    private static final long serialVersionUID = -3864639126226059218L;
    private final String desc;
    private final String pattern;
    private final int index;
    private static final String nl;
    
    public PatternSyntaxException(final String desc, final String pattern, final int index) {
        try {
            BytecodeManager.incBytecodes(2);
            this.desc = desc;
            BytecodeManager.incBytecodes(3);
            this.pattern = pattern;
            BytecodeManager.incBytecodes(3);
            this.index = index;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getIndex() {
        try {
            final int index = this.index;
            BytecodeManager.incBytecodes(3);
            return index;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getDescription() {
        try {
            final String desc = this.desc;
            BytecodeManager.incBytecodes(3);
            return desc;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getPattern() {
        try {
            final String pattern = this.pattern;
            BytecodeManager.incBytecodes(3);
            return pattern;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getMessage() {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuffer sb = new StringBuffer();
            BytecodeManager.incBytecodes(1);
            final StringBuffer sb2 = sb;
            final String desc = this.desc;
            BytecodeManager.incBytecodes(4);
            sb2.append(desc);
            BytecodeManager.incBytecodes(1);
            final int index = this.index;
            BytecodeManager.incBytecodes(3);
            if (index >= 0) {
                final StringBuffer sb3 = sb;
                final String str = " near index ";
                BytecodeManager.incBytecodes(3);
                sb3.append(str);
                BytecodeManager.incBytecodes(1);
                final StringBuffer sb4 = sb;
                final int index2 = this.index;
                BytecodeManager.incBytecodes(4);
                sb4.append(index2);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuffer sb5 = sb;
            final String nl = PatternSyntaxException.nl;
            BytecodeManager.incBytecodes(3);
            sb5.append(nl);
            BytecodeManager.incBytecodes(1);
            final StringBuffer sb6 = sb;
            final String pattern = this.pattern;
            BytecodeManager.incBytecodes(4);
            sb6.append(pattern);
            BytecodeManager.incBytecodes(1);
            final int index3 = this.index;
            BytecodeManager.incBytecodes(3);
            if (index3 >= 0) {
                final StringBuffer sb7 = sb;
                final String nl2 = PatternSyntaxException.nl;
                BytecodeManager.incBytecodes(3);
                sb7.append(nl2);
                BytecodeManager.incBytecodes(1);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int index4 = this.index;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= index4) {
                        break;
                    }
                    final StringBuffer sb8 = sb;
                    final char c = ' ';
                    BytecodeManager.incBytecodes(3);
                    sb8.append(c);
                    ++n;
                    BytecodeManager.incBytecodes(3);
                }
                final StringBuffer sb9 = sb;
                final char c2 = '^';
                BytecodeManager.incBytecodes(3);
                sb9.append(c2);
                BytecodeManager.incBytecodes(1);
            }
            final StringBuffer sb10 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb10.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String theProp = "line.separator";
            BytecodeManager.incBytecodes(4);
            final GetPropertyAction action = new GetPropertyAction(theProp);
            BytecodeManager.incBytecodes(1);
            nl = AccessController.doPrivileged((PrivilegedAction<String>)action);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
