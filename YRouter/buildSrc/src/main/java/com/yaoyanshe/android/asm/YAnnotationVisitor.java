package com.yaoyanshe.android.asm;


import org.objectweb.asm.AnnotationVisitor;

public class YAnnotationVisitor extends AnnotationVisitor {

    public String annotationValue;

    public YAnnotationVisitor(int api) {
        super(api);
    }

    public YAnnotationVisitor(int api, AnnotationVisitor annotationVisitor) {
        super(api, annotationVisitor);
        YLog.log("*****************YAnnotationVisitor constructor*****************");
    }

    public YAnnotationVisitor(int asm5, AnnotationVisitor annotationVisitor, String desc) {
        super(asm5, annotationVisitor);
    }


    @Override
    public void visit(String name, Object value) {
        super.visit(name, value);
        YLog.log("*****************YAnnotationVisitor visit*****************");
        YLog.log("*****************YAnnotationVisitor name= " + name);
        annotationValue = value.toString();
        YLog.log("*****************YAnnotationVisitor value= " + annotationValue);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        YLog.log("*****************YAnnotationVisitor visitEnd*****************");
    }
}
