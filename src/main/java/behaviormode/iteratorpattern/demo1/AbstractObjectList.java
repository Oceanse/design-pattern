package behaviormode.iteratorpattern.demo1;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObjectList<E> {
    private ArrayList<E> objectList;

    public AbstractObjectList(ArrayList<E> objects) {
        this.objectList = objects;
    }

    public void addObject(E obj) {
        this.objectList.add(obj);
    }
    public void removeObject(E obj) {
        this.objectList.remove(obj);
    }

    public ArrayList<E> getObjectList() {
        return this.objectList;
    }

    //顺序遍历迭代器
    public abstract AbstractIterator<E> createIteratorByOrder();
    //倒序遍历迭代器
    public abstract AbstractIterator<E> createIteratorByReverse();
}


/**
 * 商品数据类，实现了具体的聚合逻辑，维护了一个产品列表，并提供了创建不同迭代器的方法
 */
class ProductList<E> extends AbstractObjectList<E> {
    public ProductList(ArrayList<E> products) {
        super(products);
    }
    //创建顺序迭代器
    public AbstractIterator createIteratorByOrder() {
        return new ProductIteratorByOrder(getObjectList());
    }

    //创建倒序迭代器
    @Override
    public AbstractIterator<E> createIteratorByReverse() {
        return new ProductIteratorByReverse<>(getObjectList());
    }
}
