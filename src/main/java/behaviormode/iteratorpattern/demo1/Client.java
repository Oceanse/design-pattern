package behaviormode.iteratorpattern.demo1;

import java.util.ArrayList;

/**
 * 迭代模式（Iterator Pattern）也称为迭代器模式，它提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露该对象的内部表示。
 *
 * 使用场景:
 * 访问一个聚合对象的内容而无需暴露它的内部表示。例如，当你需要遍历一个自定义的数据结构时，使用迭代器可以将遍历的逻辑与数据结构的实现分离。
 * 不同的遍历方式：当集合需要提供多种遍历方式（如正序、倒序、随机等）时，迭代器模式可以为同一个聚合对象提供多种不同的迭代器实现。
 *
 * 迭代器模式的基本组成部分
 * Iterator（迭代器）接口：定义了访问和遍历集合元素的方法。
 * ConcreteIterator（具体迭代器）类：实现了 Iterator 接口，负责遍历集合中的元素。
 * Aggregate（聚合）接口：定义了一个用于创建 Iterator 的方法。
 * ConcreteAggregate（具体聚合）类：实现了 Aggregate 接口，维护了一个 Collection，并且提供了一个创建 Iterator 的方法。
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<String> names=new ArrayList<>();
        names.add("ocean");
        names.add("mxz");
        names.add("pza");
        names.add("pgp");

        //顺序迭代
        System.out.print("顺序遍历：");
        ProductList<String> productList=new ProductList<>(names);
        AbstractIterator<String> iteratorByOrder = productList.createIteratorByOrder();
        while (iteratorByOrder.hasNext()){
            System.out.print(iteratorByOrder.next()+" ");
        }

        //倒序迭代
        System.out.print("\n倒序遍历：");
        AbstractIterator<String> iteratorByReverse = productList.createIteratorByReverse();
        while (iteratorByReverse.hasNext()){
            System.out.print(iteratorByReverse.next()+" ");
        }



    }
}
