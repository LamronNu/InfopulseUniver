package lessons.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A {
    private int a;
    public void f(){
        System.out.println("a=" + a);
    }

    public A(int a) {
        this.a = a;
    }

    public A() {

    }

    public int getA() {
        return a;
    }
}

public class ReflectionTest {
    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //get class
        Class c = Class.forName("lessons.reflection.A");

        //constructor by default
        A pa1 = (A)c.newInstance();
        pa1.f();

        //constructor with parameters
        Class[] params = {int.class};
        Constructor con = c.getConstructor(params);
        Object[] ob = {new Integer(10)};
        A pa2 = (A) con.newInstance(ob);
        pa2.f();

        //private fields
        Field f = c.getDeclaredField("a");
        f.setAccessible(true);
        f.set(pa2, 100);
        pa2.f();

        //call methods
        Class[] mparams = {};
        Method m1 = c.getDeclaredMethod("f",mparams);
        m1.invoke(pa2);
        Method m2 = c.getDeclaredMethod("getA",mparams);
        int res = (Integer)m2.invoke(pa2, null);
        System.out.println(res);

    }
}
