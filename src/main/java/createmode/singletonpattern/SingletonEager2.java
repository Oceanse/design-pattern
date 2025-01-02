package createmode.singletonpattern;


public class SingletonEager2 {

    private static final  SingletonEager2 INSTANCE;

    //类加载时候被初始化
    static {
        INSTANCE=new SingletonEager2();
    }


    private SingletonEager2() {
        // 防止反射攻击
        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton cannot be instantiated via reflection!");
        }
    }

    /**
     * 提供一个公共的静态方法来获取单例对象
     */
    public static SingletonEager2 getSingletonInstance() {
        return INSTANCE;
    }
}