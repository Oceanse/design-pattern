package structuremode.flyweightpattern.demo2;

import java.util.HashMap;

/**
 * 提供了一个工厂类（BoxFactory），用来管理享元对象（也就是AbstractBox子类对象），
 * 该工厂类对象只需要一个，所以可以使用单例模式。并给工厂类提供一个获取形状的方法。
 */
public class BoxFactory {
    private static HashMap<String, AbstractBox> objectPool;



    private BoxFactory() {
        objectPool = new HashMap<String, AbstractBox>();
        AbstractBox iBox = new IBox();
        AbstractBox lBox = new LBox();
        AbstractBox oBox = new OBox();
        objectPool.put("I", iBox);
        objectPool.put("L", lBox);
        objectPool.put("O", oBox);
    }

    public static final BoxFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final BoxFactory INSTANCE = new BoxFactory();
    }

    public AbstractBox getBox(String key) {
        return objectPool.get(key);
    }
}
