package createmode.singletonpattern;

/**
 * 懒汉式线程安全
 */
public class SingletonLazy2 {

    private static SingletonLazy2 instance;

    private SingletonLazy2(){}

    /**
     * 安全不高效
     * 同步方法保证线程安全，保证多线程高并发访问也只创建一个对象
     * 但是每次访问该方法都需要进行同步(加锁、释放锁)， 所以性能和效率很低
     * 但是实际上，99% 情况下不需要同步,只有第一次执行此方法初次创建对象时才真正需要同步，一旦对象创建完毕，便不再需要同步
     * @return
     */
    public static synchronized SingletonLazy2 getSingletonInstance(){
        if(instance==null){
            instance=new SingletonLazy2();
        }
        return instance;
    }


    /**
     * 安全高效
     * 双重校验锁(DCL，double-checked locking)：线程安全并性能高效
     * 只有对象为空时，也就是第一次调用的时候才会进行同步，之后调用该方法就不需要同步，性能大大提升
     * @return
     */
    public static SingletonLazy2 getSingletonInstance2() {
        //第一重判断
        if (instance == null) {
            synchronized (SingletonLazy2.class) {
                //第二重判断
                if (instance == null) {
                    instance = new SingletonLazy2();
                }
            }
        }
        return instance;
    }

}
