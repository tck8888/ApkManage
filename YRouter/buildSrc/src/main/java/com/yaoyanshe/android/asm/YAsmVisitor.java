package com.yaoyanshe.android.asm;

import com.yaoyanshe.android.annotation.YProtocol;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class YAsmVisitor extends ClassVisitor {

    // 如果当前class有协议注解的时候
    public YAnnotationVisitor mProtocolAnnotation;
    public String protocolActivityName;
    public YMethodVisitor mMethodVisitor;

    public YAsmVisitor(int api) {
        super(api);
    }

    public YAsmVisitor(int api, ClassVisitor cv) {
        super(api, cv);
        YLog.log("------------------- NeacyAsmVisitor constructor -----------------");
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        YLog.log("====== NeacyAsmVisitor visit ======");
        YLog.log("=== visit.name === " + name); // com/neacy/router/MainActivity

        protocolActivityName = name.replace("/", ".");

        YLog.log("====---- name经过转换之后 == " + protocolActivityName);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        YLog.log("=====---------- NeacyAsmVisitor visitAnnotation ----------=====");
        YLog.log("=== visitAnnotation.desc === " + desc);
        AnnotationVisitor annotationVisitor = super.visitAnnotation(desc, visible);

        if (Type.getDescriptor(YProtocol.class).equals(desc)) {// 如果注解不为空的话
            mProtocolAnnotation = new YAnnotationVisitor(Opcodes.ASM5, annotationVisitor, desc);
            return mProtocolAnnotation;
        }
        return annotationVisitor;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        YLog.log("=====---------- visitMethod ----------=====");
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        mMethodVisitor = new YMethodVisitor(Opcodes.ASM5, mv, access, name, desc);
        return mMethodVisitor;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        YLog.log("====== NeacyAsmVisitor visitEnd ======");
        YLog.log(".");
        YLog.log(".");
        YLog.log(".");
        YLog.log(".");
    }
}
