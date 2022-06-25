package com.company;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException,
                                            NoSuchMethodException {
	    Class employeeClass = Class.forName("com.company.Employee");
//        Class employeeClass2 = Main.class;
//        Main emp = new Main();
//        Class employeeClass3 = emp.getClass();
        Field someFild = employeeClass.getField("id");
        System.out.println("Type of id field = " + someFild.getType());
        Field[] fields = employeeClass.getFields();
        for(Field field: fields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        Field[] declaredFields = employeeClass.getDeclaredFields();
        for(Field field: declaredFields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println();

        Method someMethod1 = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary = " +
                someMethod1.getReturnType() + ", parameter types = " +
                Arrays.toString(someMethod1.getParameterTypes()));
        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);

        System.out.println("Return type of method setSalary = " +
                someMethod2.getReturnType() + ", parameter types = " +
                Arrays.toString(someMethod1.getParameterTypes()));
        Method[] methods = employeeClass.getMethods();

        for(Method method: methods) {
            System.out.println("Name of method = " +
                    method.getName() + " " +
                    "Return type = " +
                    someMethod2.getReturnType() + ", parameter types = " +
                    Arrays.toString(someMethod1.getParameterTypes()));
        }

        Method[] methods2 = employeeClass.getDeclaredMethods();

        for(Method method: methods2) {
            if(Modifier.isPublic(method.getModifiers())) {
                System.out.println("Name of method = " +
                        method.getName() + " " +
                        "Return type = " +
                        someMethod2.getReturnType() + ", parameter types = " +
                        Arrays.toString(someMethod1.getParameterTypes()));
            }
        }

        Constructor constructor = employeeClass.getConstructor();

        System.out.println("Constructor has " + constructor.getParameterCount() +  " parameters, their types are: " +
                Arrays.toString(constructor.getParameterTypes()));

    }
}