package createmode.prototypepattern.demo1;

/**
 * Prototype（抽象原型类）：它是声明克隆方法的接口，是所有具体原型类的公共父类，可以是抽象类也可以是接口，甚至还可以是具体实现类。
 */
public abstract class IPrototype {
    public abstract void setAttr(String attr);
    public abstract String getAttr();
    public abstract IPrototype clone();

}
