// 
// Decompiled by Procyon v0.5.36
// 

package instrumenter;

import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassVisitor;

class ClassAdapter extends ClassVisitor implements Opcodes
{
    private String newClassName;
    private String newSuperName;
    
    public ClassAdapter(final ClassVisitor classVisitor) {
        super(327680, classVisitor);
    }
    
    public MethodVisitor visitMethod(final int n, final String str, final String s, final String s2, final String[] array) {
        if (Main.DEBUG && Main.playerCode) {
            System.err.println("VisitMethod " + str);
        }
        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                array[i] = InstrumentingMethodVisitor.newClass(array[i]);
            }
        }
        final MethodVisitor visitMethod = this.cv.visitMethod(n, str, InstrumentingMethodVisitor.newMethodDescReference(s), InstrumentingMethodVisitor.newMethodSignature(s2), array);
        return (MethodVisitor)((visitMethod == null) ? null : new InstrumentingMethodVisitor(visitMethod, n, this.newClassName, s, s2, array));
    }
    
    public void visit(final int n, final int n2, final String str, final String s, final String s2, final String[] array) {
        if (Main.DEBUG && Main.playerCode) {
            System.err.println("visit " + str);
        }
        this.newClassName = InstrumentingMethodVisitor.newClass(str);
        this.newSuperName = InstrumentingMethodVisitor.newClass(s2);
        for (int i = 0; i < array.length; ++i) {
            array[i] = InstrumentingMethodVisitor.newClass(array[i]);
        }
        super.visit(n, n2, this.newClassName, InstrumentingMethodVisitor.newMethodSignature(s), this.newSuperName, array);
    }
    
    public FieldVisitor visitField(final int n, final String s, final String s2, final String s3, final Object o) {
        if (Main.DEBUG && Main.playerCode) {
            System.err.println("FieldVisitor");
        }
        if (Main.playerCode && (n & 0x8) != 0x0) {
            Main.errorDetected("Cannot use static variables.");
        }
        return this.cv.visitField(n, s, InstrumentingMethodVisitor.newClassDescReference(s2), InstrumentingMethodVisitor.newFieldSignature(s3), o);
    }
    
    public void visitOuterClass(final String s, final String s2, final String s3) {
        if (Main.DEBUG && Main.playerCode) {
            System.err.println("Visit OuterClass");
        }
        super.visitOuterClass(InstrumentingMethodVisitor.newClass(s), s2, InstrumentingMethodVisitor.newMethodSignature(s3));
    }
    
    public void visitInnerClass(final String s, final String s2, final String s3, final int n) {
        if (Main.DEBUG && Main.playerCode) {
            System.err.println("Visit InnerClass");
        }
        super.visitInnerClass(InstrumentingMethodVisitor.newClass(s), InstrumentingMethodVisitor.newClass(s2), s3, n);
    }
}
