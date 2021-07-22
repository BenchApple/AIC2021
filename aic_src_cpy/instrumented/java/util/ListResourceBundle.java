// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import sun.util.ResourceBundleEnumeration;
import aic2021.engine.BytecodeManager;

public abstract class ListResourceBundle extends ResourceBundle
{
    private Map<String, Object> lookup;
    
    public ListResourceBundle() {
        try {
            BytecodeManager.incBytecodes(2);
            this.lookup = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final Object handleGetObject(final String s) {
        try {
            final Map<String, Object> lookup = this.lookup;
            BytecodeManager.incBytecodes(3);
            if (lookup == null) {
                BytecodeManager.incBytecodes(2);
                this.loadLookup();
            }
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Map<String, Object> lookup2 = this.lookup;
            BytecodeManager.incBytecodes(4);
            final Object value = lookup2.get(s);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Enumeration<String> getKeys() {
        try {
            final Map<String, Object> lookup = this.lookup;
            BytecodeManager.incBytecodes(3);
            if (lookup == null) {
                BytecodeManager.incBytecodes(2);
                this.loadLookup();
            }
            final ResourceBundle parent = this.parent;
            BytecodeManager.incBytecodes(3);
            final Map<String, Object> lookup2 = this.lookup;
            BytecodeManager.incBytecodes(5);
            final Set<String> keySet = lookup2.keySet();
            final ResourceBundle resourceBundle = parent;
            BytecodeManager.incBytecodes(2);
            Enumeration<String> keys;
            if (resourceBundle != null) {
                final ResourceBundle resourceBundle2 = parent;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                keys = resourceBundle2.getKeys();
                BytecodeManager.incBytecodes(1);
            }
            else {
                keys = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final ResourceBundleEnumeration resourceBundleEnumeration = new ResourceBundleEnumeration((Set)keySet, (Enumeration)keys);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<String>)resourceBundleEnumeration;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected Set<String> handleKeySet() {
        try {
            final Map<String, Object> lookup = this.lookup;
            BytecodeManager.incBytecodes(3);
            if (lookup == null) {
                BytecodeManager.incBytecodes(2);
                this.loadLookup();
            }
            final Map<String, Object> lookup2 = this.lookup;
            BytecodeManager.incBytecodes(3);
            final Set<String> keySet = lookup2.keySet();
            BytecodeManager.incBytecodes(1);
            return keySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected abstract Object[][] getContents();
    
    private synchronized void loadLookup() {
        try {
            final Map<String, Object> lookup = this.lookup;
            BytecodeManager.incBytecodes(3);
            if (lookup != null) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            final Object[][] contents = this.getContents();
            BytecodeManager.incBytecodes(1);
            final int length = contents.length;
            BytecodeManager.incBytecodes(5);
            final HashMap lookup2 = new HashMap<String, Object>(length);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Label_0166: {
                while (true) {
                    final int n2 = n;
                    final int length2 = contents.length;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= length2) {
                        break Label_0166;
                    }
                    final String s = (String)contents[n][0];
                    BytecodeManager.incBytecodes(7);
                    final Object o = contents[n][1];
                    BytecodeManager.incBytecodes(6);
                    final String s2 = s;
                    BytecodeManager.incBytecodes(2);
                    if (s2 == null) {
                        break;
                    }
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o2 == null) {
                        break;
                    }
                    final HashMap hashMap = lookup2;
                    final String s3 = s;
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(4);
                    hashMap.put(s3, o3);
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.lookup = (Map<String, Object>)lookup2;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
