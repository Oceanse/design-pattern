package createmode.singletonpattern.singletonbroken.deserializebroken;


import createmode.singletonpattern.SingletonEnum;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 枚举单例
 */
public class SingletonDeserializeBrokenResolve {

    /**
     * 序列化和反序列化破坏了单例设计模式。
     * 注意：枚举方式不会出现这个问题。
     */
    @Test
    public void testSingletonWithSerializeWithEnum() throws Exception {
        //往文件中写对象
        writeObject2File();
        //从文件中读取对象
        SingletonEnum s1 = readObjectFromFile();
        SingletonEnum s2 = readObjectFromFile();

        //判断两个反序列化后的对象是否是同一个对象
        System.out.println(s1 == s2);
    }

    private static SingletonEnum readObjectFromFile() throws Exception {
        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/singletonFile"));
        //第一个读取Singleton对象
        SingletonEnum instance = (SingletonEnum) ois.readObject();

        return instance;
    }

    public static void writeObject2File() throws Exception {
        //获取Singleton类的对象
        SingletonEnum instance = SingletonEnum.INSTANCE;
        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/singletonFile"));
        //将instance对象写出到文件中
        oos.writeObject(instance);
    }

}
