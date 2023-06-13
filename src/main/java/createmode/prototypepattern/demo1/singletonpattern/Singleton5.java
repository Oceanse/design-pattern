package createmode.prototypepattern.demo1.singletonpattern;

/**
 * 内部类实现单例：既可以实现延迟加载，又可以保证线程安全，不影响系统性能
 * 这种方式同样利用了classloader机制来保证初始化instance时只有一个线程，
 * 饿汉式只要Singleton类被装载了，那么instance就会被实例化，没有达到 lazy loading 效果,
 * 而这种内部类方式是 Singleton5 类被装载了(jvm装载外部类的时候不会装载内部类)，instance 不一定被初始化，只有通过显式调用 getSingletonInstance 方法时，
 * 才会显式装载 SingletonHolder 类，从而实例化 instance。
 */
public class Singleton5 {

    private Singleton5() {
    }

    private static class SingletonHolder {
        private static final Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getSingletonInstance() {
        return SingletonHolder.instance;
    }
}