package lessons.reflection.SpringExample;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;

interface MyInterface{
    public void f();
}

class A implements MyInterface{

    @Override
    public void f() {
        System.out.println("A");
    }
}

class B implements MyInterface{

    @Override
    public void f() {
        System.out.println("B");
    }
}



class MyClass{
    MyInterface m;

    public void f(){
        m.f();
    }
}

class ClassFactory{
    public static final String DATA_DELIMITER = " : ";
    static Map<String, List<String[]>> configMap = new HashMap<>();

    private static void getConfig(String fileConfig) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileConfig));
        String currentRow = "";
        List currentList;
        String currentKey;
        while (in.hasNext()){
            currentRow = in.nextLine();
            currentKey = currentRow.split(DATA_DELIMITER)[0];
            currentList = configMap.get(currentKey);
            if (currentList == null){
                currentList = new ArrayList<>();
            }
            currentList.add(currentRow.split(DATA_DELIMITER));
            configMap.put(currentKey, currentList);
        }
    }

    public static Object createClass(String className, String fileConfig) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        getConfig(fileConfig);
        Class classObj = Class.forName(className);
        Object obj = classObj.newInstance();
        List<String[]> parameters = configMap.get(className);
        if (parameters != null){
            for (String[] parameter : parameters){//MyClass : MyInterface : m : A
                Class fieldInterface = Class.forName(parameter[1]);//??
                Class fieldClass = Class.forName(parameter[3]);
                Field field = classObj.getDeclaredField(parameter[2]);
                field.set(obj, fieldClass.newInstance());
            }
        }
        return obj;
    }
}

public class Demo {
    public static void main(String[] args) {
        MyClass mc = null;
        try {
            mc = (MyClass) ClassFactory.createClass("lessons.reflection.SpringExample.MyClass", "src\\lessons\\reflection\\SpringExample\\config.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        mc.f();
    }
}
