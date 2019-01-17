package com.webonise.reflection;

public class BaseClass {
    public int baseInt;

    public static void method2() {
        System.out.println("method3()");

    }

    public int method4() {
        System.out.println("method4()");
        return 0;
    }
    public static int method5() {
        System.out.println("method5()");
        return 0;
    }
    void method6(){
        System.out.println("method6()");
    }
    // inner class
    public class BaseInnerClass{

    }
    public  enum BaseClassEnumMember{}
}

