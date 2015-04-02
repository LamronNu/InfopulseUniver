package lessons.reflection.annotation;

import org.apache.log4j.Logger;

@Service(name="lazy",lazyload=true)
class LazyService{
    @Init
    public void initServiceLazy()throws Exception{
        System.out.println("LazyService");
    }

}
