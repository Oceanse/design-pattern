package createmode.singletonpattern.singletonbroken.reflectbroken;

class MySingleton2 {

//    //私有构造方法
//    private MySingleton2() {
//        /*
//           反射破解单例模式需要添加的代码
//        */
//        if (instance != null) {
//            throw new RuntimeException();
//        }
//    }
//
//    private static volatile MySingleton2 instance;
//
//    //对外提供静态方法获取该对象
//    public static MySingleton2 getInstance() {
//        if (instance == null) {
//            synchronized (MySingleton2.class) {
//                if (instance != null) {
//                    return instance;
//                }
//                instance = new MySingleton2();
//            }
//        }
//        return instance;
//    }
//}
//
//public class SingletonBrokenReflectResolve {
//
//
//    /**
//     * 反射破坏了单例设计模式。
//     * 注意：枚举方式不会出现这个问题，枚举单例模式中，当通过反射方式调用构造方法进行创建创建时，直接抛异常
//     */
//    @Test
//    public void testSingletonWithReflection() throws Exception {
//        //获取Singleton类的字节码对象
//        Class clazz = MySingleton2.class;
//        //获取Singleton类的私有无参构造方法对象
//        Constructor constructor = clazz.getDeclaredConstructor();
//        //取消访问检查
//        constructor.setAccessible(true);
//
//        //创建Singleton类的对象s1
//        MySingleton2 s1 = (MySingleton2) constructor.newInstance();
//        //创建Singleton类的对象s2
//        MySingleton2 s2 = (MySingleton2) constructor.newInstance();
//
//        //判断通过反射创建的两个Singleton对象是否是同一个对象
//        System.out.println(s1 == s2);
//    }


}
