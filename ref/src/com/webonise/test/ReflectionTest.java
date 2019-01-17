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

        System.out.println("**************************************************************");

        // primitive types
        Class<?> booleanClass = boolean.class;
        System.out.println(" primitive type: " + booleanClass.getCanonicalName());

        // Get supper class
        System.out.println("**************************Get Super Class************************************");
        try {
            Class<?> superClass = Class.forName("com.webonise.reflection.ConcreteClass").getSuperclass();
            System.out.println("super class  " + superClass);
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get inner class***********************************");
        // get inner class
        try {
            Class<?> innerClass = Class.forName("com.webonise.reflection.ConcreteClass$ConcreteDeClassfaultInnerClass");
            System.out.println(innerClass.getDeclaringClass().getCanonicalName());
            System.out.println(innerClass.getEnclosingClass().getCanonicalName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Gets the package for this class***********************************");
        // Gets the package for this class.
        try {
            System.out.println(Class.forName("com.webonise.reflection.BaseInterface").getPackage().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Getting Class Modifier**********************************");
        //
        System.out.println(Modifier.toString(concreteClass.getModifiers()));
        try {
            System.out.println(Modifier.toString(Class.forName("com.webonise.reflection.BaseInterface").getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Getting Type Parameter**********************************");
        try {
            TypeVariable<?>[] variable = Class.forName("java.util.Map").getTypeParameters();
            for (TypeVariable<?> t : variable) {
                System.out.println(t.getName() + " , ");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get Implemented Interfaces**********************************");
        try {
            Type[] interfaces = Class.forName("java.util.ArrayList").getGenericInterfaces();
            System.out.println(Arrays.toString(interfaces));
            System.out.println(Arrays.toString(Class.forName("java.util.ArrayList").getInterfaces()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Public Methods**********************************");
        try {
            Method[] publicMethods = Class.forName("com.webonise.reflection.ConcreteClass").getMethods();
            System.out.println(Arrays.toString(publicMethods));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Public Constructors*********************************");
        try {
            Constructor<?>[] publicConstructor = Class.forName("com.webonise.reflection.ConcreteClass").getConstructors();
            System.out.println(Arrays.toString(publicConstructor));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Public Fields*********************************");
        try {
            Field[] publicFields = Class.forName("com.webonise.reflection.ConcreteClass").getFields();
            System.out.println(Arrays.toString(publicFields));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get All Annotations*********************************");
        try {
            Annotation[] publicFields = Class.forName("com.webonise.reflection.ConcreteClass").getAnnotations();
            System.out.println(Arrays.toString(publicFields));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("**************************Get Public Field*********************************");
        try {
            Field field = Class.forName("com.webonise.reflection.ConcreteClass").getField("baseInterface");
            System.out.println(field);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        }
        System.out.println("**************************Field Declaring Class********************************");
        try {
            Field field = Class.forName("com.webonise.reflection.ConcreteClass").getField("baseInterface");
            Class<?> fieldClass=field.getDeclaringClass();
            System.out.println(fieldClass.getCanonicalName());
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        }
        System.out.println("**************************Get Field Type********************************");
        try {
            Field field = Class.forName("com.webonise.reflection.ConcreteClass").getField("baseInterface");
            Class<?> fieldType=field.getType();
            System.out.println(fieldType.getCanonicalName());
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        }
    }
}
