package createmode.singletonpattern;

/**
 * 饿汉式:类加载时就完成对象初始化
 *
 * 优点：
 * 1 线程安全：JVM 的类加载机制天然保证了线程安全，(如果多个线程同时请求加载同一个尚未加载的类，JVM确保这个类只会被加载一次),防止指令重排序，无需加锁
 * 2 响应快：单例对象在应用程序启动时已经被初始化好，首次访问延迟小
 * 3 实现简单：代码结构简单明了，没有复杂的延迟加载逻辑或同步控制。
 *
 * 缺点：
 * 浪费内存空间：在类加载时就创建实例，即使在整个生命周期中可能不会被使用，浪费内存
 * 增大启动时间：由于实例化是在类加载阶段完成，如果单例对象初始化复杂，会导致类加载时间变长，影响启动效率。
 *
 * 饿汉式单例模式适用场景：
 * 对象在系统运行中一定会被用到
 * 单例对象占用资源较少，初始化过程相对简单，消耗资源少
 */
public class SingletonEager {

    private static final SingletonEager INSTANCE=new SingletonEager();

    /**
     * 构造函数私有化，防止在外部创建对象
     */
    private SingletonEager() {
        // 防止反射攻击
        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton cannot be instantiated via reflection!");
        }
    }

    /**
     * 提供一个公共的静态方法来获取单例对象
     */
    public static SingletonEager getSingletonInstance() {
        return INSTANCE;
    }
}