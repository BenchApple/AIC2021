// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.zip.ZipEntry;

public class JarEntry extends ZipEntry
{
    Attributes attr;
    Certificate[] certs;
    CodeSigner[] signers;
    
    public JarEntry(final String name) {
        try {
            BytecodeManager.incBytecodes(3);
            super(name);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarEntry(final ZipEntry e) {
        try {
            BytecodeManager.incBytecodes(3);
            super(e);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarEntry(final JarEntry ze) {
        try {
            BytecodeManager.incBytecodes(3);
            this((ZipEntry)ze);
            this.attr = ze.attr;
            BytecodeManager.incBytecodes(4);
            this.certs = ze.certs;
            BytecodeManager.incBytecodes(4);
            this.signers = ze.signers;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Attributes getAttributes() throws IOException {
        try {
            final Attributes attr = this.attr;
            BytecodeManager.incBytecodes(3);
            return attr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Certificate[] getCertificates() {
        try {
            final Certificate[] certs = this.certs;
            BytecodeManager.incBytecodes(3);
            Certificate[] array;
            if (certs == null) {
                array = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Certificate[] certs2 = this.certs;
                BytecodeManager.incBytecodes(3);
                array = certs2.clone();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CodeSigner[] getCodeSigners() {
        try {
            final CodeSigner[] signers = this.signers;
            BytecodeManager.incBytecodes(3);
            CodeSigner[] array;
            if (signers == null) {
                array = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final CodeSigner[] signers2 = this.signers;
                BytecodeManager.incBytecodes(3);
                array = signers2.clone();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
