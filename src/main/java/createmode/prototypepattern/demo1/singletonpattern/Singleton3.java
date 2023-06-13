package createmode.prototypepattern.demo1.singletonpattern;

import java.io.Serializable;

/**
 * 懒汉式(lazy loading): 双重校验锁（DCL，即 double-checked locking）
 * 线程安全,性能好， 只有第一次执行此方法时进行了加锁同步，其他场景不在加锁
 */
public class Singleton3 implements Serializable {

    private static Singleton3 instance;

    private Singleton3() {
    }


    /**
     * 双重校验锁,只有对象为空时，也就是第一次调用的时候才会进行同步，之后调用该方法就不需要同步，性能大大提升
     * @return
     */
    public static Singleton3 getSingletonInstance() {
        //第一重判断
        if (instance == null) {
            synchronized (Singleton3.class) {
                //第二重判断
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}