package createmode.factorypattern.factory.demo1;

/**
 * 工厂方法模式的角色:
 * 抽象工厂（Abstract Factory）
 * 具体工厂（Concrete Factory）
 * 抽象产品（Product）
 * 具体产品（Concrete Product）
 *
 * 优点：
 * 扩展性：当需要添加新产品时，只需新增一个具体产品类和对应的工厂类，而不必修改已有的代码，这符合开闭原则
 * 可维护性：每个工厂生产一种产品，符合单一职责，容易维护
 * 复用性：无
 * 易用性：客户端不需要知道具体产品的创建过程，只需要获取对应的产品工厂即可创建所需产品
 *
 * 缺点：
 * 类爆炸：对于每一种产品，都需要一个相应的工厂类，这增加了系统的复杂性。
 */
public class PhoneStore {
    public static void main(String[] args) {
        IphoneFactory iphoneFactory = new IphoneFactory();
        Phone iphone = iphoneFactory.createPhone();
        iphone.showInfo();

        HuaweiPhoneFactory huaweiPhoneFactory = new HuaweiPhoneFactory();
        Phone huaweiPhone = huaweiPhoneFactory.createPhone();
        huaweiPhone.showInfo();
    }
}
