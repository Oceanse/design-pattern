package createmode.factorypattern.abstractfactory.demo1;


/**
 * 抽象工厂模式：一个工厂创建一组相关对象
 * 工厂方法模式中使用一个工厂创建一类产品，这样可能会导致系统中存在大量的工厂类，比如这里有华为手机、苹果手机、华为pad、苹果pad四种产品，那么我们就需要设计四个具体工厂来生产这四种产品；
 * 抽象工厂模式,一个工厂会生产一系列或者一组相关产品，这些产品构成了一个产品族，比如AppleFactory生产iphone、ipad、mac；
 * 抽象工厂的作用就是在一定前提下，帮你分类这些工厂，比如按品牌分类：AppleFactory和HuaweiFactory，AppleFactory生产一族产品，HuaweiFactory生产一族产品，这样会大大缩减系统中的工厂数量。
 *
 * 角色构成：
 * 抽象工厂（Abstract Factory）：它声明了一组用于创建一族产品（一个产品族）的方法，每一个方法对应一种产品。
 * 具体工厂（Concrete Factory）：它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。
 * 抽象产品（Product）：定义产品的接口。
 * 具体产品（Concrete Product）：实现抽象产品的接口，由具体工厂创建。
 *
 * 优点：
 * 扩展性：添加新的产品族时，只需增加一个新的具体工厂类即可，无需修改现有代码，符合“开闭原则”
 * 维护性：单一职责的程大于于简单工厂模式，小于工厂模式
 * 复用性：无
 * 易用性：客户端代码与具体产品的创建过程解耦，只需要与抽象工厂接口交互即可
 *
 * 缺点：
 * 增加复杂性：每个产品族都需要一个具体的工厂类，增加了系统的复杂性(如果产品族非常多，就成了缺点)。
 * 难以支持新产品：如果需要添加一个新产品，则需要修改现有工厂类或创建新的抽象工厂。
 * 对于增加新的产品(属于现有产品族)，比如当前案例新增生产笔记本电脑，需要修改所有的工厂角色，包括抽象工厂类，在所有的工厂类中都需要增加生产新产品的方法，违背了“开闭原则”，这也是抽象工厂模式最大的缺点
 * 在抽象工厂模式中，增加新的产品族很方便，但是增加新的产品等级结构很麻烦，抽象工厂模式的这种性质称为“开闭原则”的倾斜性，为增加新产品族提供方便，但不能为增加新产品结构提供这样的方便，因此要求设计人员在设计
 * 之初就能够全面考虑，不会在设计完成之后向系统中增加新的产品等级结构，也不会删除已有的产品等级结构，否则将会导致系统出现较大的修改，为后续维护工作带来诸多麻烦。
 *
 * 使用场景
 * 创建一组相关的产品：当需要创建一组相关的产品时，可以使用抽象工厂模式来确保这些产品的创建是一致的。
 *
 */
public class Store {
    public static void main(String[] args) {
        Factory appleFactory=new AppleFactory();
        Phone iphone = appleFactory.createPhone();
        Pad ipad = appleFactory.createPad();
        iphone.showInfo();
        ipad.showInfo();

        Factory huaweiFactory=new HuaweiFactory();
        Phone huaweiPhone = huaweiFactory.createPhone();
        Pad huaweiPad = huaweiFactory.createPad();
        huaweiPhone.showInfo();
        huaweiPad.showInfo();

    }
}
