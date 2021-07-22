// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import instrumented.java.util.List;
import instrumented.java.util.Enumeration;
import java.security.CodeSource;
import java.net.URL;
import java.io.IOException;
import aic2021.engine.BytecodeManager;
import sun.misc.JavaUtilJarAccess;

class JavaUtilJarAccessImpl implements JavaUtilJarAccess
{
    JavaUtilJarAccessImpl() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean jarFileHasClassPathAttribute(final JarFile jarFile) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean hasClassPathAttribute = jarFile.hasClassPathAttribute();
            BytecodeManager.incBytecodes(1);
            return hasClassPathAttribute;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CodeSource[] getCodeSources(final JarFile jarFile, final URL url) {
        try {
            BytecodeManager.incBytecodes(3);
            final CodeSource[] codeSources = jarFile.getCodeSources(url);
            BytecodeManager.incBytecodes(1);
            return codeSources;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CodeSource getCodeSource(final JarFile jarFile, final URL url, final String s) {
        try {
            BytecodeManager.incBytecodes(4);
            final CodeSource codeSource = jarFile.getCodeSource(url, s);
            BytecodeManager.incBytecodes(1);
            return codeSource;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<String> entryNames(final JarFile jarFile, final CodeSource[] array) {
        try {
            BytecodeManager.incBytecodes(3);
            final Enumeration<String> entryNames = jarFile.entryNames(array);
            BytecodeManager.incBytecodes(1);
            return entryNames;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<JarEntry> entries2(final JarFile jarFile) {
        try {
            BytecodeManager.incBytecodes(2);
            final Enumeration<JarEntry> entries2 = jarFile.entries2();
            BytecodeManager.incBytecodes(1);
            return entries2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setEagerValidation(final JarFile jarFile, final boolean eagerValidation) {
        try {
            BytecodeManager.incBytecodes(3);
            jarFile.setEagerValidation(eagerValidation);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public List<Object> getManifestDigests(final JarFile jarFile) {
        try {
            BytecodeManager.incBytecodes(2);
            final List<Object> manifestDigests = jarFile.getManifestDigests();
            BytecodeManager.incBytecodes(1);
            return manifestDigests;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
