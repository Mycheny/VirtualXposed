package io.virtualapp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MyClass {

    public void test(String[] arg){
        for (String string : arg) {
            System.out.println(string);
        }
    }
    @Test
    public void demo1() throws Exception {
        //获取字节码对象
        Class<MyClass> clazz = (Class<MyClass>) Class.forName("io.virtualapp.MyClass");
        //获取一个对象
        Constructor con =  clazz.getConstructor();
        MyClass m = (MyClass) con.newInstance();
        String[] s = new String[]{"aa","bb"};
        //获取Method对象
        Method method = clazz.getMethod("test", String[].class);
        //调用invoke方法来调用
//        method.invoke(m, s);
        method.invoke(m, new Object[]{s});
        method.invoke(m,  (Object) s);
    }
}
