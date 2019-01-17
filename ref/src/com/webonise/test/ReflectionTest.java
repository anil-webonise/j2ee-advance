package com.webonise.test;

import com.webonise.reflection.ConcreteClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionTest {

    public static void main(String... args) {
        Class<?> concreteClass = ConcreteClass.class;
        try {
            concreteClass = Class.forName("com.webonise.reflection.ConcreteClass");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(" now our Class Name: " + concreteClass.getCanonicalName());
        // output --> now our Class Name: com.webonise.reflection.ConcreteClass

        System.out.println("**************************************************************");

        // primitive types
        Class<?> booleanClass = boolean.class;
        System.out.println(" primitive type: " + booleanClass.getCanonicalName());
        // output -->  primitive type: boolean

        // Get supper class
        System.out.println("**************************Get Super Class************************************");
        try {
            Class<?> superClass = Class.forName("com.webonise.reflection.ConcreteClass").getSuperclass();
            System.out.println("super class  " + superClass);
            /**
             * output is -> super class  class com.webonise.reflection.BaseClass
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // get public memeber of class
        System.out.println("**************************Get getClasses************************************");
        Class<?>[] classes = concreteClass.getClasses();
        /**
         * Returns an array containing Class objects representing all
         * the public classes and interfaces that are members of the class represented by this Class object.
         */
        System.out.println(Arrays.toString(classes));
        /**
         * output is ->[class com.webonise.reflection.ConcreteClass$ConcreteClassPublicInnerClass,
         * interface com.webonise.reflection.ConcreteClass$ConcreteClassPublicInteface,
         * class com.webonise.reflection.ConcreteClass$ConcreteClassPublicEnum,
         * class com.webonise.reflection.BaseClass$BaseClassEnumMember,
         * class com.webonise.reflection.BaseClass$BaseInnerClass]
         */
        System.out.println("**************************Get getDeclaredClasses************************************");
        // get all classes ans intefaces and enum in Concreate class
        /**
         * @return Class<?>[]
         * Returns an array of Class objects reflecting all the
         * classes and interfaces declared as members of the class
         * represented by this Class object.
         */
        try {
            Class<?>[] expAllClasses = Class.forName("com.webonise.reflection.ConcreteClass").getDeclaredClasses();
            System.out.println(Arrays.toString(expAllClasses));
            /**
             * output is  ->[class com.webonise.reflection.ConcreteClass$ConcreteDeClassfaultInnerClass,
             * class com.webonise.reflection.ConcreteClass$ConcreteClassProtectedInnerClass,
             * class com.webonise.reflection.ConcreteClass$ConcreteClassPrivateInnerClass,
             * class com.webonise.reflection.ConcreteClass$ConcreteClassPublicInnerClass,
             * interface com.webonise.reflection.ConcreteClass$ConcreteClassPublicInteface,
             * class com.webonise.reflection.ConcreteClass$ConcreteClassPublicEnum,
             * class com.webonise.reflection.ConcreteClass$ConcreteClassDefaultEnum]
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get inner class***********************************");
        // get inner class
        try {
            Class<?> innerClass = Class.forName("com.webonise.reflection.ConcreteClass$ConcreteDeClassfaultInnerClass");
            System.out.println(innerClass.getDeclaringClass().getCanonicalName()); //com.webonise.reflection.ConcreteClass
            System.out.println(innerClass.getEnclosingClass().getCanonicalName()); //com.webonise.reflection.ConcreteClass

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Gets the package for this class***********************************");
        // Gets the package for this class.
        try {
            System.out.println(Class.forName("com.webonise.reflection.BaseInterface").getPackage().getName());
            // output is -> com.webonise.reflection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Getting Class Modifier**********************************");
        //
        System.out.println(Modifier.toString(concreteClass.getModifiers())); // output is -> public
        try {
            System.out.println(Modifier.toString(Class.forName("com.webonise.reflection.BaseInterface").getModifiers()));
            // output is  -> public abstract interface
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Getting Type Parameter**********************************");
        try {
            TypeVariable<?>[] variable = Class.forName("java.util.Map").getTypeParameters();
            for (TypeVariable<?> t : variable) {
                System.out.println(t.getName() + " , ");
            }
            /**
             * output is -> K ,
             *              V,
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get Implemented Interfaces**********************************");
        try {
            Type[] interfaces = Class.forName("java.util.ArrayList").getGenericInterfaces();
            System.out.println(Arrays.toString(interfaces));
            /**
             * output is -> [java.util.List<E>, interface java.util.RandomAccess,
             * interface java.lang.Cloneable, interface java.io.Serializable]
             */
            System.out.println(Arrays.toString(Class.forName("java.util.ArrayList").getInterfaces()));
            /**
             * output is -> [interface java.util.List, interface java.util.RandomAccess,
             * interface java.lang.Cloneable,
             * interface java.io.Serializable]
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Public Methods**********************************");
        try {
            Method[] publicMethods = Class.forName("com.webonise.reflection.ConcreteClass").getMethods();
            System.out.println(Arrays.toString(publicMethods));
            /**
             * output is ->[public int com.webonise.reflection.ConcreteClass.method5(int),
             * public void com.webonise.reflection.ConcreteClass.method1(),
             * public int com.webonise.reflection.ConcreteClass.method2(java.lang.String),
             * public int com.webonise.reflection.ConcreteClass.method4(),
             * public static int com.webonise.reflection.BaseClass.method5(),
             * public static void com.webonise.reflection.BaseClass.method2(),
             * public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException,
             * public final native void java.lang.
             * Object.wait(long) throws java.lang.InterruptedException,
             * public final void java.lang.Object.wait() throws java.lang.InterruptedException,
             * public boolean java.lang.Object.equals(java.lang.Object),
             * public java.lang.String java.lang.Object.toString(),
             * public native int java.lang.Object.hashCode(),
             * public final native java.lang.Class java.lang.Object.getClass(),
             * public final native void java.lang.Object.notify(),
             * public final native void java.lang.Object.notifyAll()]
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Public Constructors*********************************");
        try {
            Constructor<?>[] publicConstructor = Class.forName("com.webonise.reflection.ConcreteClass").getConstructors();
            System.out.println(Arrays.toString(publicConstructor));
            // public constructor ->[public com.webonise.reflection.ConcreteClass(int)]
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Public Fields*********************************");
        try {
            Field[] publicFields = Class.forName("com.webonise.reflection.ConcreteClass").getFields();
            System.out.println(Arrays.toString(publicFields));
            /**
             * output is ->[public int com.webonise.reflection.ConcreteClass.publicInt,
             * public static final int com.webonise.reflection.BaseInterface.baseInterface,
             * public int com.webonise.reflection.BaseClass.baseInt]
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Annotations*********************************");
        try {
            Annotation[] annotations = Class.forName("com.webonise.reflection.ConcreteClass").getAnnotations();
            System.out.println(Arrays.toString(annotations));
            // output is ->[@java.lang.Deprecated()]
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get Public Field*********************************");
        try {
            Field field = Class.forName("com.webonise.reflection.ConcreteClass").getField("baseInterface");
            System.out.println(field);
            // o/p is->public static final int com.webonise.reflection.BaseInterface.baseInterface

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        }
        System.out.println("**************************Field Declaring Class********************************");
        try {
            Field field = Class.forName("com.webonise.reflection.ConcreteClass").getField("baseInterface");
            Class<?> fieldClass = field.getDeclaringClass();
            System.out.println(fieldClass.getCanonicalName());
            /**
             * output is ->public static final int com.webonise.reflection.BaseInterface.baseInterface
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        }
        System.out.println("**************************Get Field Type********************************");
        try {
            Field field = Class.forName("com.webonise.reflection.ConcreteClass").getField("baseInterface");
            Class<?> fieldType = field.getType();
            System.out.println(fieldType.getCanonicalName()); // o/p is ->int
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        }
    }
}
