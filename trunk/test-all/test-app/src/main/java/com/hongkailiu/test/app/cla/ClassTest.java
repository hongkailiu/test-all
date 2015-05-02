package com.hongkailiu.test.app.cla;

import lombok.extern.log4j.Log4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Log4j public class ClassTest {

    private ClassTest(){

    }

    public static void main(String[] args) {
        log.info("ClassTest");
        log.info("getName: " + ClassTest.class.getName());
        try {
            Class<?> clazz = java.lang.Class.forName("java.lang.Integer");
            log.info("aaa: " + clazz);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }

        Class<? extends Integer> iClazz = Integer.class;
        log.info("bbb: " + iClazz);
        Class<?> superIClazz = iClazz.getSuperclass();
        log.info("ccc: " + superIClazz);
        ClassLoader classLoader = iClazz.getClassLoader();
        log.info("classLoader: " + classLoader);
        try {
            // ref: http://stackoverflow.com/questions/1438420/how-to-get-a-class-object-from-the-class-name-in-java
            Class<?> clazzA = java.lang.Class.forName("com.hongkailiu.test.app.cla.A");
            A a1 = (A) clazzA.newInstance();
            log.info("a1: " + a1);
            Constructor<?> contructor1 = clazzA.getConstructor(int.class);
            A a2 = (A) contructor1.newInstance(6);
            log.info("a2: " + a2);
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        } catch (SecurityException e) {
            log.error(e);
        } catch (NoSuchMethodException e) {
            log.error(e);
        } catch (IllegalArgumentException e) {
            log.error(e);
        } catch (InvocationTargetException e) {
            log.error(e);
        }
    }
}
