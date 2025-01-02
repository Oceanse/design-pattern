package createmode.singletonpattern;

import java.io.Serializable;


/**
 * 懒汉式(lazy loading): 双重校验锁存在指令重排序问题：
 *
 * instance = new Singleton(); 这行简单的赋值语句并不是一个原子操作，事实上，它可以”抽象“为下面几条JVM指令：
 * memory = allocate();    //1：分配对象的内存空间
 * initInstance(memory);   //2：初始化对象
 * instance = memory;      //3：设置instance指向刚分配的内存地址
 * 上面操作2依赖于操作1，但是操作3并不依赖于操作2，所以JVM可以以“优化”为目的对它们进行指令重排序，经过重排序后如下：
 * memory = allocate();    //1：分配对象的内存空间
 * instance = memory;      //3：设置instance指向刚分配的内存地址（此时对象还未初始化）
 * Instance(memory);       //2：初始化对象
 *
 * 可以看到指令重排之后，如果对象还没有初始化，此时，如果另一个线程调用getInstance方法，可能会得到一个没有完成初始化的“半个”单例，后面使用这个对象时候可能会引发NPE;
 * 也就是说，在只有DCL没有volatile的懒加载单例模式中，仍然存在着并发陷阱。我确实不会拿到两个不同的单例了，但我会拿到“半个”单例（未完成初始化）。
 * 为了解决这个该问题，只需要将instance声明为volatile变量：
 * private static volatile Singleton instance;
 * volatile用来防止指令重排，保证有序性
 */
public class SingletonLazy3 implements Serializable {

    //volatile用来防止指令重排，保证有序性
    private static volatile SingletonLazy3 instance;

    private SingletonLazy3() {
    }


    /**
     * 双重校验锁,只有对象为空时，也就是第一次调用的时候才会进行同步，之后调用该方法就不需要同步，性能大大提升
     * @return
     */
    public static SingletonLazy3 getSingletonInstance() {
        if (instance == null) {
            synchronized (SingletonLazy3.class) {
                if (instance == null) {
                    instance = new SingletonLazy3();
                }
            }
        }
        return instance;
    }
}
