package createmode.singletonpattern.singletonbroken.deserializebroken;


import org.testng.annotations.Test;

import java.io.*;

public class SingletonBrokenWhenDeserialize {

    /**
     * 序列化和反序列化破坏了单例设计模式。
     * 注意：枚举方式不会出现这两个问题。
     */
    @Test
    public void testSingletonWithSerialize() throws Exception {
        //往文件中写对象
        writeObject2File();
        //从文件中读取对象
        SingleTonDemo s1 = readObjectFromFile();
        SingleTonDemo s2 = readObjectFromFile();

        //判断两个反序列化后的对象是否是同一个对象
        System.out.println(s1 == s2);
    }

    private static SingleTonDemo readObjectFromFile() throws Exception {
        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/singletonFile"));
        //第一个读取Singleton对象
        SingleTonDemo instance = (SingleTonDemo) ois.readObject();

        return instance;
    }

    public static void writeObject2File() throws Exception {
        //获取Singleton类的对象
        SingleTonDemo instance = SingleTonDemo.getInstance();
        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/singletonFile"));
        //将instance对象写出到文件中
        oos.writeObject(instance);
    }
}


class SingleTonDemo implements Serializable {

    private SingleTonDemo(){}

  static class SingletonHolder {
        private static final SingleTonDemo instance=new SingleTonDemo();
  }

    public static SingleTonDemo getInstance(){
        return SingletonHolder.instance;
    }
}
