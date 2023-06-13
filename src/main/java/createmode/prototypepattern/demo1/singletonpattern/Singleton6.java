package createmode.prototypepattern.demo1.singletonpattern;

/**
 * Singleton5 instance = new Singleton5(),JVM主要干了三件事：
 * 1、在堆空间里分配一部分空间；
 * 2、执行 Monitor 的构造方法进行初始化；
 * 3、把 monitor 对象指向在堆空间里分配好的空间。
 * 编译器在生成汇编代码的时候会对流程顺序进行优化(指令重排序), 有可能是按照1、2、3的顺序执行，也有可能按照1、3、2的顺序执行。
 * 如果是按照1、3、2的顺序执行，恰巧在执行到3的时候（还没执行2），突然跑来了一个线程，进来 getSingletonInstance() 方法之后判断
 * instance 不为空就返回了 instance 实例, 此时 instance 实例虽不为空，但它还没进行初始化,所以后面使用这个对象可能会发生npe
 *
 * volatile可以保证可见性和有序性
 */
public class Singleton6 {

    private Singleton6() {
    }

    private static class SingletonHolder {
        private  static volatile Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getSingletonInstance() {
        return SingletonHolder.instance;
    }
}