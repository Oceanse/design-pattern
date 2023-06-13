package createmode.prototypepattern.demo1.singletonpattern;

import java.io.Serializable;

/**
 * 懒汉式，线程不安全,多个线程同时调用getSingletonInstance方法时候可能返回多个实例
 */
public class Singleton implements Serializable {

    private static Singleton instance;

    private Singleton(){}

    public static Singleton getSingletonInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
