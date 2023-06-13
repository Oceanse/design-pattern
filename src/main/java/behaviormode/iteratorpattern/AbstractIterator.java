package behaviormode.iteratorpattern;

import java.util.ArrayList;

public interface AbstractIterator<E> {
     E next();
     boolean hasNext();
}

 class ProductIterator<E> implements AbstractIterator<E>{

     int cursor=0;

     ArrayList<E> list;

     public ProductIterator(ArrayList<E> list) {
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
