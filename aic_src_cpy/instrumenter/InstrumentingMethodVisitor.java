// 
// Decompiled by Procyon v0.5.36
// 

package instrumenter;

import org.objectweb.asm.signature.SignatureWriter;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureReader;
import java.util.List;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Type;
import java.util.Iterator;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;
import java.util.HashSet;
import java.util.Set;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

class InstrumentingMethodVisitor extends MethodNode implements Opcodes
{
    private int bytecodeCtr;
    private MethodVisitor methodWriter;
    private LabelNode startLabel;
    private final Set<LabelNode> exceptionHandlers;
    private final Set<LabelNode> tryCatchStarts;
    
    public InstrumentingMethodVisitor(final MethodVisitor methodWriter, final int n, final String s, final String s2, final String s3, final String[] array) {
        super(327680, n, s, s2, s3, array);
        this.bytecodeCtr = 0;
        this.exceptionHandlers = new HashSet<LabelNode>();
        this.tryCatchStarts = new HashSet<LabelNode>();
        this.methodWriter = methodWriter;
    }
    
    public void visitMaxs(final int n, final int n2) {
        final Iterator<TryCatchBlockNode> iterator = (Iterator<TryCatchBlockNode>)this.tryCatchBlocks.iterator();
        while (iterator.hasNext()) {
            this.visitTryCatchBlockNode(iterator.next());
        }
        for (final AbstractInsnNode abstractInsnNode : this.instructions.toArray()) {
            switch (abstractInsnNode.getType()) {
                case 4: {
                    this.visitFieldInsnNode((FieldInsnNode)abstractInsnNode);
                    break;
                }
                case 0: {
                    this.visitInsnNode((InsnNode)abstractInsnNode);
                    break;
                }
                case 6: {
                    this.visitInvokeDynamicInsnNode((InvokeDynamicInsnNode)abstractInsnNode);
                    break;
                }
                case 9: {
                    this.visitLdcInsnNode((LdcInsnNode)abstractInsnNode);
                    break;
                }
                case 5: {
                    this.visitMethodInsnNode((MethodInsnNode)abstractInsnNode);
                    break;
                }
                case 13: {
                    this.visitMultiANewArrayInsnNode((MultiANewArrayInsnNode)abstractInsnNode);
                    break;
                }
                case 3: {
                    this.visitTypeInsnNode((TypeInsnNode)abstractInsnNode);
                    break;
                }
                case 2: {
                    this.visitVarInsnNode((VarInsnNode)abstractInsnNode);
                    break;
                }
                case 8: {
                    this.visitLabelNode((LabelNode)abstractInsnNode);
                    break;
                }
                case 14: {
                    this.visitFrameNode((FrameNode)abstractInsnNode);
                    break;
                }
                case 7:
                case 11:
                case 12: {
                    ++this.bytecodeCtr;
                    this.endOfBasicBlock(abstractInsnNode);
                    break;
                }
                case 1: {
                    this.visitIntInsnNode((IntInsnNode)abstractInsnNode);
                    break;
                }
                case 10: {
                    ++this.bytecodeCtr;
                    break;
                }
            }
        }
        this.startLabel = new LabelNode(new Label());
        this.instructions.insert((AbstractInsnNode)this.startLabel);
        final boolean b = this.tryCatchBlocks.size() > 0;
        this.addDebugHandler();
        if (b) {
            this.addRobotDeathHandler();
        }
        final Iterator<LocalVariableNode> iterator2 = (Iterator<LocalVariableNode>)this.localVariables.iterator();
        while (iterator2.hasNext()) {
            this.visitLocalVariableNode(iterator2.next());
        }
        super.visitMaxs(0, 0);
    }
    
    private void addRobotDeathHandler() {
        final LabelNode labelNode = new LabelNode(new Label());
        LabelNode labelNode2 = null;
        for (final AbstractInsnNode abstractInsnNode : this.instructions.toArray()) {
            if (abstractInsnNode.getType() == 8 && this.tryCatchStarts.contains(abstractInsnNode)) {
                labelNode2 = (LabelNode)abstractInsnNode;
                break;
            }
        }
        this.tryCatchBlocks.add(0, new TryCatchBlockNode(labelNode2, labelNode, labelNode, "java/lang/VirtualMachineError"));
        this.instructions.add((AbstractInsnNode)labelNode);
        this.instructions.add((AbstractInsnNode)new FrameNode(0, 0, new Object[0], 1, new Object[] { "java/lang/VirtualMachineError" }));
        this.instructions.add((AbstractInsnNode)new InsnNode(191));
    }
    
    private void visitFieldInsnNode(final FieldInsnNode fieldInsnNode) {
        ++this.bytecodeCtr;
        fieldInsnNode.owner = newClass(fieldInsnNode.owner);
        fieldInsnNode.desc = newClassDescReference(fieldInsnNode.desc);
    }
    
    private void visitLdcInsnNode(final LdcInsnNode ldcInsnNode) {
        ++this.bytecodeCtr;
        if (ldcInsnNode.cst instanceof Type) {
            ldcInsnNode.cst = Type.getType(newClassDescReference(ldcInsnNode.cst.toString()));
        }
    }
    
    private void visitInsnNode(final InsnNode insnNode) {
        ++this.bytecodeCtr;
        switch (insnNode.getOpcode()) {
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177: {
                this.endOfBasicBlock((AbstractInsnNode)insnNode);
                break;
            }
            case 191: {
                this.endOfBasicBlock((AbstractInsnNode)insnNode);
                break;
            }
            case 194:
            case 195: {
                if (Main.playerCode) {
                    Main.errorDetected("Players cannot exit monitor!");
                }
                this.instructions.set((AbstractInsnNode)insnNode, (AbstractInsnNode)new InsnNode(87));
                break;
            }
        }
    }
    
    private void visitTryCatchBlockNode(final TryCatchBlockNode tryCatchBlockNode) {
        this.exceptionHandlers.add(tryCatchBlockNode.handler);
        this.tryCatchStarts.add(tryCatchBlockNode.start);
        if (tryCatchBlockNode.type != null) {
            tryCatchBlockNode.type = newClass(tryCatchBlockNode.type);
        }
    }
    
    private void visitInvokeDynamicInsnNode(final InvokeDynamicInsnNode invokeDynamicInsnNode) {
        invokeDynamicInsnNode.desc = newMethodDescReference(invokeDynamicInsnNode.desc);
        for (int i = 0; i < invokeDynamicInsnNode.bsmArgs.length; ++i) {
            final Object o = invokeDynamicInsnNode.bsmArgs[i];
            if (o instanceof Type) {
                invokeDynamicInsnNode.bsmArgs[i] = Type.getType(newMethodDescReference(((Type)o).getDescriptor()));
            }
            else if (o instanceof Handle) {
                final Handle handle = (Handle)o;
                if (Main.playerCode) {
                    this.checkDisallowedMethod(handle.getOwner(), handle.getName(), handle.getDesc());
                }
                invokeDynamicInsnNode.bsmArgs[i] = new Handle(handle.getTag(), newClass(handle.getOwner()), handle.getName(), newMethodDescReference(handle.getDesc()));
            }
        }
    }
    
    public void visitMethodInsnNode(final MethodInsnNode methodInsnNode) {
        if (Main.playerCode) {
            this.checkDisallowedMethod(methodInsnNode.owner, methodInsnNode.name, methodInsnNode.desc);
        }
        final String string = methodInsnNode.owner + "/" + methodInsnNode.name;
        if (Main.methodBytecode.containsKey(string)) {
            this.bytecodeCtr += Main.methodBytecode.get(string);
        }
        else {
            ++this.bytecodeCtr;
        }
        methodInsnNode.owner = newClass(methodInsnNode.owner);
        methodInsnNode.desc = newMethodDescReference(methodInsnNode.desc);
        this.endOfBasicBlock((AbstractInsnNode)methodInsnNode);
    }
    
    void checkDisallowedMethod(final String s, final String s2, final String s3) {
        if ((s3.equals("()V") && (s2.equals("wait") || s2.equals("notify") || s2.equals("notifyAll"))) || (s2.equals("wait") && (s3.equals("(J)V") || s3.equals("(JI)V")))) {
            Main.errorDetected("Error: Found wait or notify methods");
        }
        if (s.equals("java/lang/Class") && !s2.equals("desiredAssertionStatus")) {
            Main.errorDetected("Error: Method name is desiredAssertionStatus");
        }
        if (s.equals("java/io/PrintStream") && s2.equals("<init>") && s3.startsWith("(Ljava/lang/String;")) {
            Main.errorDetected("Error: Using PrintStream");
        }
        if (s.equals("java/io/PrintStream") && (s2.equals("println") || s2.equals("print")) && s3.startsWith("(Ljava/lang/String;")) {
            Main.errorDetected("Error: Using println/print from PrintStream");
        }
        if (s.equals("java/lang/String") && s2.equals("intern")) {
            Main.errorDetected("Error: Using intern from String");
        }
        if (s.equals("java/lang/System") && (s2.equals("currentTimeMillis") || s2.equals("gc") || s2.equals("getProperties") || s2.equals("getSecurityManager") || s2.equals("getenv") || s2.equals("load") || s2.equals("loadLibrary") || s2.equals("mapLibraryName") || s2.equals("nanoTime") || s2.equals("runFinalization") || s2.equals("runFinalizersOnExit") || s2.equals("setProperties") || s2.equals("setSecurityManager"))) {
            Main.errorDetected("Error: Using disallowed methods from System");
        }
        if (s.startsWith("java/lang/invoke/")) {
            Main.errorDetected("Error: Using java/lang/invoke");
        }
    }
    
    private void visitMultiANewArrayInsnNode(final MultiANewArrayInsnNode multiANewArrayInsnNode) {
        multiANewArrayInsnNode.desc = newClassDescReference(multiANewArrayInsnNode.desc);
        ++this.bytecodeCtr;
    }
    
    private void visitVarInsnNode(final VarInsnNode varInsnNode) {
        ++this.bytecodeCtr;
        if (varInsnNode.getOpcode() == 169) {
            this.endOfBasicBlock((AbstractInsnNode)varInsnNode);
        }
    }
    
    private void visitIntInsnNode(final IntInsnNode intInsnNode) {
        if (intInsnNode.getOpcode() != 188) {
            ++this.bytecodeCtr;
        }
    }
    
    private void visitTypeInsnNode(final TypeInsnNode typeInsnNode) {
        typeInsnNode.desc = newClass(typeInsnNode.desc);
        if (typeInsnNode.getOpcode() != 189) {
            ++this.bytecodeCtr;
        }
    }
    
    private void visitLocalVariableNode(final LocalVariableNode localVariableNode) {
        localVariableNode.desc = newClassDescReference(localVariableNode.desc);
        localVariableNode.signature = newFieldSignature(localVariableNode.signature);
    }
    
    private void visitLabelNode(final LabelNode labelNode) {
        this.endOfBasicBlock((AbstractInsnNode)labelNode);
        if (this.exceptionHandlers.contains(labelNode)) {
            this.bytecodeCtr += 500;
        }
    }
    
    private void replaceVars(final List<Object> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) instanceof String) {
                list.set(i, newClass(list.get(i)));
            }
        }
    }
    
    private void visitFrameNode(final FrameNode frameNode) {
        this.replaceVars(frameNode.local);
        this.replaceVars(frameNode.stack);
    }
    
    public void addDebugHandler() {
        final LabelNode labelNode = new LabelNode(new Label());
        this.tryCatchBlocks.add(new TryCatchBlockNode(this.startLabel, labelNode, labelNode, (String)null));
        this.instructions.add((AbstractInsnNode)labelNode);
        this.instructions.add((AbstractInsnNode)new FrameNode(0, 0, new Object[0], 1, new Object[] { "java/lang/Throwable" }));
        this.instructions.add((AbstractInsnNode)new InsnNode(191));
    }
    
    public void visitEnd() {
        this.accept(this.methodWriter);
    }
    
    private void endOfBasicBlock(final AbstractInsnNode abstractInsnNode) {
        if (this.bytecodeCtr < 0) {
            this.bytecodeCtr = -this.bytecodeCtr;
        }
        else if (this.bytecodeCtr == 0) {
            return;
        }
        if (this.bytecodeCtr > 1000000000) {
            this.bytecodeCtr = 1000000000;
        }
        this.instructions.insertBefore(abstractInsnNode, (AbstractInsnNode)new LdcInsnNode((Object)this.bytecodeCtr));
        this.instructions.insertBefore(abstractInsnNode, (AbstractInsnNode)new MethodInsnNode(184, "aic2021/engine/BytecodeManager", "incBytecodes", "(I)V", false));
        this.bytecodeCtr = 0;
    }
    
    private static void checkDisallowedClasses(final String s) {
        if (Main.disallowedClasses.contains(s)) {
            Main.errorDetected("Class " + s + " is illegal.");
        }
        final int lastIndex = s.lastIndexOf(47);
        if (lastIndex == -1 || !Main.allowedClasses.contains(s.substring(0, lastIndex))) {
            Main.errorDetected("Class " + s + " is illegal.");
        }
    }
    
    static String newClass(final String str) {
        if (str == null) {
            return null;
        }
        if (str.charAt(0) == '[') {
            final int lastIndex = str.lastIndexOf(91);
            if (str.charAt(lastIndex + 1) == 'L') {
                return str.substring(0, lastIndex + 2) + newClass(str.substring(lastIndex + 2, str.length() - 1)) + ";";
            }
            return str;
        }
        else {
            if (Main.playerCode && str.startsWith(Main.packageName + '/')) {
                return str;
            }
            if (Main.playerCode && str.startsWith("java/util/Random")) {
                Main.errorDetected("Class java/util/Random is illegal, use Math.random() instead.");
            }
            if (Main.playerCode) {
                checkDisallowedClasses(str);
            }
            if (Main.DEBUG && Main.playerCode) {
                System.err.println("Input " + str);
            }
            if (str.startsWith("java/util/invoke") || str.startsWith("java/util/jar") || str.startsWith("java/util/zip") || str.equals("java/util/Iterator") || str.equals("java/util/concurrent/TimeUnit")) {
                if (Main.DEBUG && Main.playerCode) {
                    System.err.println("Output " + str);
                }
                return str;
            }
            if (str.startsWith("java/util/") || str.startsWith("java/math/")) {
                if (Main.DEBUG && Main.playerCode) {
                    System.err.println("Output instrumented/" + str);
                }
                return "instrumented/" + str;
            }
            if (Main.DEBUG && Main.playerCode) {
                System.err.println("Output " + str);
            }
            return str;
        }
    }
    
    static String newClassDescReference(final String s) {
        if (s == null) {
            return null;
        }
        if (s.charAt(0) == 'L') {
            return "L" + newClass(s.substring(1, s.length() - 1)) + ";";
        }
        if (s.charAt(0) == '[') {
            final int lastIndex = s.lastIndexOf(91);
            return s.substring(0, lastIndex + 1) + newClassDescReference(s.substring(lastIndex + 1, s.length()));
        }
        return s;
    }
    
    static String newMethodDescReference(final String s) {
        String str = "(";
        for (final Type type : Type.getArgumentTypes(s)) {
            if (type.getSort() == 9 || type.getSort() == 10) {
                str += newClassDescReference(type.toString());
            }
            else {
                str += type.toString();
            }
        }
        final String string = str + ")";
        final Type returnType = Type.getReturnType(s);
        String s2;
        if (returnType.getSort() == 9 || returnType.getSort() == 10) {
            s2 = string + newClassDescReference(returnType.toString());
        }
        else {
            s2 = string + returnType.toString();
        }
        return s2;
    }
    
    static String newFieldSignature(final String s) {
        if (s == null) {
            return null;
        }
        final NewSignatureWriter newSignatureWriter = new NewSignatureWriter();
        new SignatureReader(s).acceptType((SignatureVisitor)newSignatureWriter);
        return newSignatureWriter.toString();
    }
    
    static String newMethodSignature(final String s) {
        if (s == null) {
            return null;
        }
        final NewSignatureWriter newSignatureWriter = new NewSignatureWriter();
        new SignatureReader(s).accept((SignatureVisitor)newSignatureWriter);
        return newSignatureWriter.toString();
    }
    
    private static class NewSignatureWriter extends SignatureWriter
    {
        public void visitClassType(final String s) {
            super.visitClassType(InstrumentingMethodVisitor.newClass(s));
        }
    }
}
