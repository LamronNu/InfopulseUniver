package lessons.reflection.annotation;

@Service(name="simple",lazyload=true)
class SimpleService {
    @Init
    public void initService(){
        System.out.println("SimpleService");
    }
    public void A(){
        System.out.println("SimpleService");
    }

}
