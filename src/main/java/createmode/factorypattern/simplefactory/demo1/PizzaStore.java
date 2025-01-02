package createmode.factorypattern.simplefactory.demo1;

/**
 * 模拟客户端： 客户端可以通过工厂方法和对应的产品参数创建不同的产品对象
 */
public class PizzaStore {
    public static void main(String[] args) {
        Pizza cheesePizza = SimplePizzaFactory.createPizza(PizzaTypeEnum.CHEESE);
        System.out.println(cheesePizza);
        Pizza veggiePizza = SimplePizzaFactory.createPizza(PizzaTypeEnum.VEGGIE);
        System.out.println(veggiePizza);
        Pizza durianiPizza = SimplePizzaFactory.createPizza(PizzaTypeEnum.DURIAN);
        System.out.println(durianiPizza);
    }

}
