package createmode.prototypepattern.demo1.singletonpattern;

/**
 * 懒汉式，线程安全
 * 这种方式具备很好的 lazy loading，能够在多线程中很好的工作，
 * 但是性能和效率很低，99% 情况下不需要同步,其实只有第一次执行此方法时，才真正需要同步。
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    /**
     * 同步方法保证线程安全
     * 在多线程高并发访问环境中，将会导致系统性能大大降低
     * @return
     */
    public static synchronized Singleton2 getSingletonInstance(){
        if(instance==null){
            instance=new Singleton2();
        }
        return instance;
    }
}
