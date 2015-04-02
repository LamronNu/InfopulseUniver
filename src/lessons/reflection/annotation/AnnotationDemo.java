package lessons.reflection.annotation;

import java.util.HashMap;
import java.util.Map;

class Test{
    public static void main(String ...args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Map<String,Object> map = new HashMap<String,Object>();
        loadservice("lessons.reflection.annotation.SimpleService",map);
        loadservice("lessons.reflection.annotation.LazyService",map);
        loadservice("java.lang.String",map);
        for(Map.Entry etr:map.entrySet()){
            System.out.println("Ann "+etr.getKey()+" Obj= "+etr.getValue().toString());
        }
    }
    static void loadservice(String className,Map<String,Object> m) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class<?>clazz =Class.forName(className);
        if(clazz.isAnnotationPresent(Service.class))
        {
            Object serviceObj = clazz.newInstance();
            m.put(className, serviceObj);

        }
        else
        {
            System.out.println("This class"+clazz.getName()+" doesnt have annotation");
        }

    }
    static void inspect(Class<?> service){



        if(service.isAnnotationPresent(Service.class)==true)
        {
            Service an = service.getAnnotation(Service.class);
            System.out.println(service.getClass());
            System.out.println("name= "+" "+an.name());
            System.out.println("value= "+" "+an.lazyload());

        }
        else
        {
            System.out.println(service.getCanonicalName()+" No annotations");
        }
    }
}

public class AnnotationDemo {
}
