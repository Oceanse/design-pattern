package createmode.builderpattern.demo2;

/**
 * 概念：
 * 将一个复杂对象的构建与表示分离，使得同样的构建流程逐步创建出不同形态的产品。
 *
 * 使用场景：
 * 1 对象的创建过程复杂，对象包含的属性非常多，需要通过一系列的步骤来创建
 * 2 对象存在非常多的形态：比如需要创建很多不同的配置或表示形式的对象
 *
 * 优点：
 * 易用可读(可读性/易用性)：流式 API(通过链式调用的方式设置对象的各个属性)，使得代码更加直观和易读，客户端调用方便
 * 灵活性：：避免了构造函数中参数过多的问题;可以灵活创建不同配置形态的对象
 * 扩展性：轻松地添加新的属性或配置选项，我们可以通过简单地在产品类中添加一个新的属性，在 Builder 类中添加相应的属性和设置方法来实现。
 *
 * 缺点：
 * 增加复杂性：引入了多个类，增加了系统的复杂性。
 * 不适用于简单对象：如果对象的创建过程较为简单，使用建造者模式会显得过于冗余。
 *
 * 抽象工厂模式 vs 建造者模式
 * 抽象工厂模式生产一系列相关的产品，客户端通过选择具体工厂来生成所需对象
 * 建造者模式中侧重于一步步构造一个复杂对象，然后将结果返回。
 * 如如果将抽象工厂模式看成一个汽车配件生产厂，生成不同类型的汽车配件，那么建造者模式就是一个汽车组装厂，通过对配件进行组装返回一辆完整的汽车。
 *
 */
public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        // 创建一个店内用餐订单
        Order inStoreOrder = new Order.Builder()
                .setCustomerName("John")
                .setMainDish("Pizza")
                .setSideDish("Salad")
                .setDrink("Soda")
                .setExtraSpicy(false)
                .setTotalPrice(25.99)
                .build();

        System.out.println("In-store Order:");
        System.out.println("Customer Name: " + inStoreOrder.getCustomerName());
        System.out.println("Main Dish: " + inStoreOrder.getMainDish());
        System.out.println("Side Dish: " + inStoreOrder.getSideDish());
        System.out.println("Drink: " + inStoreOrder.getDrink());
        System.out.println("Extra Spicy: " + inStoreOrder.isExtraSpicy());
        System.out.println("Total Price: " + inStoreOrder.getTotalPrice());

        // 创建一个配送订单
        Order deliveryOrder = new Order.Builder()
                .setCustomerName("Alice")
                .setMainDish("Burger")
                .setSideDish("Fries")
                .setDrink("Coffee")
                .setExtraSpicy(false)
                .setDelivery(true)
                .setDeliveryAddress("123 Main St")
                .setTotalPrice(30.99)
                .build();

        System.out.println("\nDelivery Order:");
        System.out.println("Customer Name: " + deliveryOrder.getCustomerName());
        System.out.println("Main Dish: " + deliveryOrder.getMainDish());
        System.out.println("Side Dish: " + deliveryOrder.getSideDish());
        System.out.println("Drink: " + deliveryOrder.getDrink());
        System.out.println("Extra Spicy: " + deliveryOrder.isExtraSpicy());
        System.out.println("Delivery: " + deliveryOrder.isDelivery());
        System.out.println("Delivery Address: " + deliveryOrder.getDeliveryAddress());
        System.out.println("Total Price: " + deliveryOrder.getTotalPrice());
    }
}