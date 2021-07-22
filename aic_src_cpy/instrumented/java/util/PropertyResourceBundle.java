// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import sun.util.ResourceBundleEnumeration;
import java.io.Reader;
import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.InputStream;

public class PropertyResourceBundle extends ResourceBundle
{
    private Map<String, Object> lookup;
    
    public PropertyResourceBundle(final InputStream inputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final Properties properties = new Properties();
            BytecodeManager.incBytecodes(1);
            final Properties properties2 = properties;
            BytecodeManager.incBytecodes(3);
            properties2.load(inputStream);
            final Properties properties3 = properties;
            BytecodeManager.incBytecodes(5);
            this.lookup = new HashMap<String, Object>((Map<? extends String, ?>)properties3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PropertyResourceBundle(final Reader reader) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final Properties properties = new Properties();
            BytecodeManager.incBytecodes(1);
            final Properties properties2 = properties;
            BytecodeManager.incBytecodes(3);
            properties2.load(reader);
            final Properties properties3 = properties;
            BytecodeManager.incBytecodes(5);
            this.lookup = new HashMap<String, Object>((Map<? extends String, ?>)properties3);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object handleGetObject(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Map<String, Object> lookup = this.lookup;
            BytecodeManager.incBytecodes(4);
            final Object value = lookup.get(s);
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
            final ResourceBundle parent = this.parent;
            BytecodeManager.incBytecodes(3);
            final Map<String, Object> lookup = this.lookup;
            BytecodeManager.incBytecodes(5);
            final Set<String> keySet = lookup.keySet();
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
            final Set<String> keySet = lookup.keySet();
            BytecodeManager.incBytecodes(1);
            return keySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
