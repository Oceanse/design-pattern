package createmode.prototypepattern.demo1.singletonpattern.singletonbroken.reflectbroken;

import createmode.prototypepattern.demo1.singletonpattern.Singleton3;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;

public class SingletonBrokenWhenReflect {
    /**
     * 反射破坏了单例设计模式。
     * 注意：枚举方式不会出现这个问题，枚举单例模式中，当通过反射方式调用构造方法进行创建创建时，直接抛异常
     */
    @Test
    public void testSingletonWithReflection() throws Exception {
        //获取Singleton类的字节码对象
        Class clazz = Singleton3.class;
        //获取Singleton类的私有无参构造方法对象
        Constructor constructor = clazz.getDeclaredConstructor();
        //取消访问检查
        constructor.setAccessible(true);

        //创建Singleton类的对象s1
        Singleton3 s1 = (Singleton3) constructor.newInstance();
        //创建Singleton类的对象s2
        Singleton3 s2 = (Singleton3) constructor.newInstance();

        //判断通过反射创建的两个Singleton对象是否是同一个对象
        System.out.println(s1 == s2);
    }


}
