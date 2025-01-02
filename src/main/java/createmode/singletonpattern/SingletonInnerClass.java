package createmode.singletonpattern;

/**
 * 内部类实现单例：线程安全,延迟加载，防止指令重排序
 * 线程安全：通过classloader机制来保证初始化instance时只有一个线程，无需加锁，不存在指令重排序问题
 * 延迟加载：jvm装载外部类的时候不会装载内部类，只有通过显式调用 getSingletonInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。
 */
public class SingletonInnerClass {

    private SingletonInnerClass() {
        // 防止反射攻击
        if (SingletonHolder.instance != null) {
            throw new IllegalStateException("Singleton cannot be instantiated via reflection!");
        }
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }


    public static SingletonInnerClass getSingletonInstance() {
        return SingletonHolder.instance;
    }
}