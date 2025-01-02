package createmode.singletonpattern.singletonbroken.deserializebroken;


import org.testng.annotations.Test;

import java.io.*;

class MySingleton implements Serializable {

    private static MySingleton instance = new MySingleton();

    private MySingleton() {
    }

    public static MySingleton getSingletonInstance() {
        return instance;
    }

    /**
     * 下面是为了解决序列化反序列化破解单例模式
     */
    private Object readResolve() {
        return instance;
    }
}

public class SingletonDeserializeBrokenResolve2 {

    /**
     * 序列化和反序列化破坏了单例设计模式。
     * 具体阅读ObjectInputStream类
     */
    @Test
    public void testSingletonWithSerialize() throws Exception {
        //往文件中写对象
        writeObject2File();
        //从文件中读取对象
        MySingleton s1 = readObjectFromFile();
        MySingleton s2 = readObjectFromFile();

        //判断两个反序列化后的对象是否是同一个对象
        System.out.println(s1 == s2);
    }

    private static MySingleton readObjectFromFile() throws Exception {
        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/singletonFile"));
        //第一个读取Singleton对象
        MySingleton instance = (MySingleton) ois.readObject();

        return instance;
    }

    public static void writeObject2File() throws Exception {
        //获取Singleton类的对象
        MySingleton instance = MySingleton.getSingletonInstance();
        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/singletonFile"));
        //将instance对象写出到文件中
        oos.writeObject(instance);
    }
}
