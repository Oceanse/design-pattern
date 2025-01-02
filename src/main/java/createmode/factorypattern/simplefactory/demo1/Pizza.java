package createmode.factorypattern.simplefactory.demo1;

/**
 * 在使用简单工厂模式时，首先需要对产品类进行重构，不能设计一个包罗万象的产品类，而需根据实际情况设计一个产品层次结构，
 * 将所有产品类公共的代码移至抽象产品类，并在抽象产品类中声明一些抽象业务方法，以供不同的具体产品类来实现
 */
public abstract class Pizza {
    public abstract void prepare();//面粉 酵母 白糖 水，制成面饼,然后涂上番茄酱，放上芝士碎、火腿、青椒等各种材料

    public abstract void bake();//空气炸锅烘焙

    public abstract void cut();//切割

    public abstract void box();//打包
}

/**
 * 芝士奶酪披萨
 */
class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("prepare simplefactory.CheesePizza ...");
    }

    @Override
    public void bake() {
        System.out.println("bake simplefactory.CheesePizza ...");
    }

    @Override
    public void cut() {
        System.out.println("cut simplefactory.CheesePizza ...");
    }

    @Override
    public void box() {
        System.out.println("box simplefactory.CheesePizza ...");
    }
}

/**
 * 蔬菜披萨
 */
class VeggiePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("prepare simplefactory.VeggiePizza ...");
    }

    @Override
    public void bake() {
        System.out.println("bake simplefactory.VeggiePizza ...");
    }

    @Override
    public void cut() {
        System.out.println("cut simplefactory.VeggiePizza ...");
    }

    @Override
    public void box() {
        System.out.println("box simplefactory.VeggiePizza ...");
    }
}

/**
 * 榴莲披萨
 */
class DurianPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("prepare simplefactory.PepperoniPizza ...");
    }

    @Override
    public void bake() {
        System.out.println("bake simplefactory.PepperoniPizza ...");
    }

    @Override
    public void cut() {
        System.out.println("cut simplefactory.PepperoniPizza ...");
    }

    @Override
    public void box() {
        System.out.println("box simplefactory.PepperoniPizza ...");
    }
}