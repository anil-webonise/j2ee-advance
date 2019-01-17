package com.webonise.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;
@Deprecated
public class ConcreteClass extends BaseClass implements BaseInterface {
    public int publicInt;
    protected boolean protectedBoolean;
    Object defaultObject;
    private String privateString = "Private String";

    public ConcreteClass(int i) {
        this.publicInt = i;
    }



    @Override
    public void method1() {
        System.out.println("method1 Impl");
    }

    @Override
    public int method2(String str) {
        System.out.println("method2 Impl");
        return 0;
    }

    @Override
    public int method4() {
        System.out.println("method4 Impl");
        return 0;
    }
    // inner class

    public int method5(int i) {
        System.out.println("method5");
        return 0;
    }

    // enum
    enum ConcreteClassDefaultEnum {
    }

    public enum ConcreteClassPublicEnum {}

    // interface
    public interface ConcreteClassPublicInteface {
    }

    public class ConcreteClassPublicInnerClass {
    }

    private class ConcreteClassPrivateInnerClass {
    }

    protected class ConcreteClassProtectedInnerClass {
    }

    class ConcreteDeClassfaultInnerClass {
    }

}
