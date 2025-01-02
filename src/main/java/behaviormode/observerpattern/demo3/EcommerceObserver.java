package behaviormode.observerpattern.demo3;

/**
 * 业务场景:
 * 在一个电商平台中，有商品库存管理系统。当商品库存数量发生变化时，需要通知多个相关方，
 * 比如商家（以便及时补货或调整销售策略）、购物车系统（如果商品库存不足可能需要提示用户）、订单系统（如果库存不足可能影响订单处理）等。
 */
public class EcommerceObserver {
    public static void main(String[] args) {
        // 创建商品库存对象
        ProductInventory productInventory = new ProductInventory("手机");
        // 创建商家对象
        Merchant merchant = new Merchant("商家 A");
        // 创建购物车系统对象
        ShoppingCartSystem shoppingCartSystem = new ShoppingCartSystem("用户购物车");
        // 创建订单系统对象
        OrderSystem orderSystem = new OrderSystem("订单处理系统");

        // 商家注册为观察者
        productInventory.registerObserver(merchant);
        // 购物车系统注册为观察者
        productInventory.registerObserver(shoppingCartSystem);
        // 订单系统注册为观察者
        productInventory.registerObserver(orderSystem);

        // 设置商品库存数量，触发通知
        productInventory.setQuantity(50);
    }
}
