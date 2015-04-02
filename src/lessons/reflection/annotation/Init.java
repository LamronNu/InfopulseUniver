package lessons.reflection.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited

public @interface Init {
    boolean SupressExeption() default false;
}
