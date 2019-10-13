package com.yaoyanshe.android.asm;

import com.yaoyanshe.android.annotation.YCost;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class YMethodVisitor extends AdviceAdapter {


    protected YMethodVisitor(int api, MethodVisitor mv, int access, String name, String desc) {
        super(api, mv, access, name, desc);
        this.mv = mv;
        methodName = name;
    }

    /**
     * 是否有注释可以插入代码
     */
    public boolean isInject;
    private String methodName;
    private MethodVisitor mv;

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (Type.getDescriptor(YCost.class).equals(descriptor)) {
            isInject = true;
        }
        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        if (isInject) {
            YLog.log("====== 开始插入方法 = " + methodName);

            // NeacyCostManager.addStartTime("xxxx", System.currentTimeMillis());
            mv.visitLdcInsn(methodName);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "neacy/router/NeacyCostManager", "addStartTime", "(Ljava/lang/String;J)V", false);
        }
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        if (isInject) {
            mv.visitLdcInsn(methodName);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "neacy/router/NeacyCostManager", "addEndTime", "(Ljava/lang/String;J)V", false);

            // NeacyCostManager.startCost("xxxx");
            mv.visitLdcInsn(methodName);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "neacy/router/NeacyCostManager", "startCost", "(Ljava/lang/String;)V", false);

            YLog.log("==== 插入结束 ====");
        }
    }
}
