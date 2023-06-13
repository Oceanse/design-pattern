package createmode.factorypattern.simplefactory.demo1;

/**
 * 简单工厂模式定义了一个类，这个类专门用于创建其他类的实例，这些被创建的类都有一个共同的父类，可以根据传递的参数不同，返回不同类的实例
 *
 *
 * 角色：
 * ● Factory（工厂角色）：工厂角色即工厂类，它是简单工厂模式的核心，负责实现创建所有产品实例的内部逻辑；工厂类可以被外界直接调用，创建所需的产品对象；在工厂类中提供了静态的工厂方法factoryMethod()，它的返回类型为抽象产品类型Product。
 * ● Product（抽象产品角色）：它是工厂类所创建的所有对象的父类，封装了各种产品对象的公有方法，它的引入将提高系统的灵活性，使得在工厂类中只需定义一个通用的工厂方法，因为所有创建的具体产品对象都是其子类对象。
 * ● ConcreteProduct（具体产品角色）：它是简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体类的实例。每一个具体产品角色都继承了抽象产品角色，需要实现在抽象产品中声明的抽象方法。
 *
 * 步骤：
 * 首先将不同产品类的公共的代码进行抽象，封装在抽象产品类中， 让每一个具体产品子类继承抽象类，
 * 然后提供一个工厂类用于生产各种产品，在工厂类中提供一个创建产品的工厂方法，该方法可以根据所传入的参数不同创建不同的具体产品对象；
 * 客户端只需调用工厂类的工厂方法并传入相应的参数即可得到一个产品对象。
 *
 * 优点：
 * 简单工厂模式提供了专门的工厂类用于管理创建对象，复杂的创建过程也封装在工厂方法中，从而实现了对责任的分割，将对象的创建和使用分离开来，
 * 客户端无须知道创建对象的复杂过程，也无需知道具体产品类的类名，只需要知道具体产品类所对应的参数就可以使用工厂方法获取到想要的产品，而无须直接使用new关键字来创建对象(new 完后可能还需要复杂处理)
 * 总之就是减轻了客户端创建对象的复杂度，使得客户端更加简单方便，体验更好
 *
 * 缺点：
 * 1、 由于工厂类集中了所有产品创建逻辑，一旦不能正常工作，整个系统都要受到影响，违背单一职责
 * 2、 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护，违背了开闭原则
 *
 * 使用场景：
 * 工厂类负责创建的对象比较少
 */
public class SimplePizzaFactory {

    /**
     * 在没有工厂类之前，客户端一般会使用new关键字来直接创建产品对象，而在引入工厂类之后，客户端可以通过工厂类静态工厂方法和传入的不同参数创建不同的产品对象
     * @param type
     * @return
     */
    public static Pizza createPizza(PizzaTypeEnum type) {
        Pizza pizza;
        switch (type) {
            case CHEESE:
                pizza = new CheesePizza();
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                break;
            case VEGGIE:
                pizza = new VeggiePizza();
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                break;
            case PEPPERONI:
                pizza = new PepperoniPizza();
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                break;
            default:
                pizza = null;
                break;
        }
        return pizza;
//        Pizza pizza;
//        if(type.equals(simplefactory.abstractfactory.PizzaTypeEnum.CHEESE)){
//            pizza= new simplefactory.CheesePizza();
//        }else if(type.equals(simplefactory.abstractfactory.PizzaTypeEnum.VEGGIE)){
//            pizza=new simplefactory.VeggiePizza();
//        }else if (type.equals(simplefactory.abstractfactory.PizzaTypeEnum.PEPPERONI)){
//            pizza=new simplefactory.PepperoniPizza();
//        }else {
//            pizza=null;
//        }
    }

    public static void main(String[] args) {
        System.out.println(PizzaTypeEnum.CHEESE == (PizzaTypeEnum.CHEESE));
    }
}
