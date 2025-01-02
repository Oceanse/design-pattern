package createmode.singletonpattern;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉式-线程不安全场景： 多个线程同时调用getSingletonInstance方法时候可能返回多个实例
 */
public class SingletonLazy {

    private static  SingletonLazy instance;

    /**
     * 构造函数私有化，防止在外部创建对象
     */
    private SingletonLazy() {
    }

    /**
     * 检查-更新模式存在线程安全问题
     * @return
     */
    public static SingletonLazy getSingletonInstance()  {
        if(instance ==null){
            //模拟长时间初始化对象，增大race condition
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            instance =new SingletonLazy();
        }
        return instance;
    }


    /**
     * 测试多线程环境下可能创建多个实例的问题
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // 控制并发线程的同步

        // 存储所有线程获取的单例对象
        SingletonLazy[] instances = new SingletonLazy[3];

        // 启动10个线程来请求单例对象
        for (int i = 0; i < 3; i++) {
            final int index = i;
            new Thread(() -> {
                SingletonLazy singleton = SingletonLazy.getSingletonInstance();
                instances[index] = singleton;
                latch.countDown(); // 减少计数器
            }).start();
        }
        // 等待所有线程完成
        latch.await();

        // 检查是否创建了多个实例
        boolean isSingleton = true;
        //获取数组中第一个对象
        SingletonLazy firstInstance = instances[0];
        //检查数组中的对象是否相同，以此判断是否创建了多个实例。
        for (int i = 1; i < instances.length; i++) {
            if (instances[i] != firstInstance) {
                isSingleton = false;
                break;
            }
        }
        if (isSingleton) {
            System.out.println("Single instance created.");
        } else {
            System.err.println("Multiple instances created.");
        }

    }

}
