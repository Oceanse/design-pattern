package createmode.factorypattern.simplefactory.demo1;

/**
 * 模拟客户端： 通过使用工厂类的静态创建方法，而不是直接new来创建对象
 */
public class PizzaStore {
    public static void main(String[] args) {
        Pizza cheesePizza = SimplePizzaFactory.createPizza(PizzaTypeEnum.CHEESE);
        System.out.println();
        Pizza veggiePizza = SimplePizzaFactory.createPizza(PizzaTypeEnum.VEGGIE);
        System.out.println();
        Pizza pepperoniPizza = SimplePizzaFactory.createPizza(PizzaTypeEnum.PEPPERONI);
    }

}
