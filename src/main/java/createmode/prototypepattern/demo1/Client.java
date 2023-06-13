package createmode.prototypepattern.demo1;

import createmode.prototypepattern.demo1.ConcretePrototype;
import createmode.prototypepattern.demo1.IPrototype;
import createmode.prototypepattern.demo2.ConcretePrototype2;

/**
 * Client（客户类）：让一个原型对象克隆自身从而创建一个新的对象，在客户类中只需要直接实例化或通过工厂方法等方式创建一个原型对象，
 * 再通过调用该对象的克隆方法即可得到多个相同的对象。由于客户类针对抽象原型类Prototype编程，因此用户可以根据需要选择具体原型类，
 * 系统具有较好的可扩展性，增加或更换具体原型类都很方便。
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        IPrototype prototype = new ConcretePrototype("attr1");
        IPrototype clone = prototype.clone();
        System.out.println("prototype = " + prototype);
        System.out.println("clone = " + clone);
        System.out.println(Integer.toHexString(prototype.hashCode()));
        System.out.println(Integer.toHexString(clone.hashCode()));
        System.out.println();
    }
}
