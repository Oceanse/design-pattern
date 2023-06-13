package behaviormode.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObjectList<E> {
    protected ArrayList<E> objectList;

    public AbstractObjectList(ArrayList<E> objects) {
        this.objectList = objects;
    }

    public void addObject(E obj) {
        this.objectList.add(obj);
    }
    public void removeObject(E obj) {
        this.objectList.remove(obj);
    }

    public List<E> getObjectList() {
        return this.objectList;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator<E> createIterator();
}


//商品数据类：具体聚合类
class ProductList<E> extends AbstractObjectList<E> {
    public ProductList(ArrayList<E> products) {
        super(products);
    }
    //实现创建迭代器对象的具体工厂方法
    public AbstractIterator createIterator() {
        return new ProductIterator(objectList);
    }
}
