package behaviormode.iteratorpattern.demo1;

import java.util.ArrayList;


/**
 * 迭代器接口定义了基本的迭代方法 hasNext() 和 next()
 */
public interface AbstractIterator<E> {
     E next();
     boolean hasNext();
}

/**
 * 顺序遍历迭代器，实现了具体的迭代逻辑
 */
 class ProductIteratorByOrder<E> implements AbstractIterator<E>{

     int cursor=0;

     ArrayList<E> list;

     public ProductIteratorByOrder(ArrayList<E> list) {
          this.list = list;
     }

     @Override
     public E next() {
          E obj = list.get(cursor);
          cursor++;
          return obj;
     }

     @Override
     public boolean hasNext() {
          return cursor<list.size();
     }
}

/**
 * 倒序遍历迭代器，实现了具体的迭代逻辑
 */
class ProductIteratorByReverse<E> implements AbstractIterator<E>{

    ArrayList<E> list;
    int cursor;

    public ProductIteratorByReverse(ArrayList<E> list) {
        this.list = list;
        cursor=list.size()-1;
    }

    @Override
    public E next() {
        E obj = list.get(cursor);
        cursor--;
        return obj;
    }

    @Override
    public boolean hasNext() {
        return cursor>-1;
    }
}
