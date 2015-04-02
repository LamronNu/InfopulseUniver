package lessons.reflection.annotation;

import org.apache.log4j.Logger;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Service {
    String name();


    boolean lazyload() default false;

}
