package createmode.factorypattern.factory.demo1;

/**
 * 工厂方法模式定义了一个创建对象的抽象工厂接口，把生产对象推迟到工厂子类，由工厂子类决定要实例化哪一类对象
 * 核心是定义抽象接口，通过工厂子类创建具体产品，不同的子类生产不同的产品，每个工厂只生产一类产品
 * 一个产品类对应的是一个工厂，客户端想要创建对象，用户只需要关心需要具体产品对应的具体工厂实现
 *
 * 优点：
 * 1 系统的扩展性高,如果新增产品,只需要一个具体工厂实现类和具体产品类即可,符合开闭原则
 * 2 简单工厂只有一个工厂，所有的类的实例化都揉在一个方法里面，而工厂方法是多个工厂，一个产品对应一个工厂，遵循了职责单一的原则，维护扩展方便
 *
 * 缺点:
 * 工厂方法模式通过引入工厂等级结构,解决了简单工厂模式中工厂类的职责过大的问题.但是由于工厂方法模式中每个工厂只生产一类产品,
 * 每次增加一个产品,都需要增加一个具体工厂实现类和具体产品类,这样使得系统中类的个数成倍增加,在一定程度上增加了系统的复杂度
 */
public interface PhoneFactory {
    Phone createPhone();
}

class IphoneFactory implements PhoneFactory {

    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

class HuaweiPhoneFactory implements PhoneFactory {

    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }
}
