package createmode.prototypepattern.demo1;

/**
 * ConcretePrototype（具体原型类）：它实现在抽象原型类中声明的克隆方法，在克隆方法中返回自己的一个克隆对象。
 * 通过已创建的对象可以快速创建新的对象，然后再根据需要修改，无须再从头开始创建。原型模式为工作流系统中任务单的快速生成提供了一种解决方案。
 * 在使用原型模式时，我们需要首先创建一个原型对象，再通过复制这个原型对象来创建更多同类型的对象。
 * 需要注意的是通过克隆方法所创建的对象是全新的对象，它们在内存中拥有新的地址，通常对克隆所产生的
 * 对象进行修改对原型对象不会造成任何影响，每一个克隆对象都是相互独立的。
 * 原型模式的核心在于如何实现克隆方法
 * 个人理解：原型模式就是克隆一个完全相同的独立的对象
 */
public class ConcretePrototype extends IPrototype {
    //成员属性
    private String attr;

    public ConcretePrototype() {
    }

    public ConcretePrototype(String attr) {
        this.attr = attr;
    }

    @Override
    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String getAttr() {
        return this.attr;
    }

    public IPrototype clone() {
        IPrototype prototype = new ConcretePrototype();
        prototype.setAttr(this.attr);
        return prototype;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "attr='" + attr + '\'' +
                '}';
    }
}
