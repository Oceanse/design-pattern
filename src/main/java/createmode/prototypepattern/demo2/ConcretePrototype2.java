package createmode.prototypepattern.demo2;

/**
 * 学过Java语言的人都知道，所有的Java类都继承自java.lang.Object。事实上，Object类提供一个clone()方法，
 * 可以将一个Java对象复制一份。因此在Java中可以直接使用Object提供的clone()方法来实现对象的克隆，Java语言中的原型模式实现很简单。
 *
 * 需要注意的是能够实现克隆的Java类必须实现一个标识接口Cloneable，表示这个Java类支持被复制。
 * 如果一个类没有实现这个接口但是调用了clone()方法，Java编译器将抛出一个CloneNotSupportedException异常。
 */
public class ConcretePrototype2 implements Cloneable {
    //成员属性
    private String attr;

    public ConcretePrototype2() {
    }

    public ConcretePrototype2(String attr) {
        this.attr = attr;
    }

    public void setAttr(String attr2) {
        this.attr = attr2;
    }

    public String getAttr() {
        return this.attr;
    }

    @Override
    public ConcretePrototype2 clone() throws CloneNotSupportedException {
        ConcretePrototype2 clone = null;
        try {
            clone = (ConcretePrototype2)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "ConcretePrototype2{" +
                "attr='" + attr + '\'' +
                '}';
    }
}
