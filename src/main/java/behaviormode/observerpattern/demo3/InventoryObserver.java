package behaviormode.observerpattern.demo3;

/**
 * 定义观察者接口
 */
public interface InventoryObserver {
    // 当被观察的库存发生变化时，观察者进行更新
    void update(InventorySubject inventory);
}

/**
 * 具体观察者实现类（商家）
 * 当库存发生变化时，商家会收到通知，并根据库存情况调整补货或销售策略。
 */
class Merchant implements InventoryObserver {
    // 商家名称
    private String merchantName;

    public Merchant(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public void update(InventorySubject inventory) {
        if (inventory instanceof ProductInventory) {
            ProductInventory productInventory = (ProductInventory) inventory;
            // 根据库存情况进行相应的补货或销售策略调整
            String productName = productInventory.getProductName();
            int quantity = productInventory.getQuantity();
            System.out.println(merchantName + " 收到商品 " + productName + " 的库存更新通知，当前库存数量为：" + quantity);

            // 根据库存情况进行相应的补货或销售策略调整
            if (quantity < 10) { // 设定安全库存水平为10
                // 库存低于安全水平时触发补货
                System.out.println(merchantName + "：商品 " + productName + " 库存低于安全水平，已触发紧急补货订单。");
            } else if (quantity > 100) { // 设定过剩库存水平为100
                // 库存过高时发起促销活动
                System.out.println(merchantName + "：商品 " + productName + " 库存过高，已发起促销活动。");
            } else {
                // 正常库存水平下的提示
                System.out.println(merchantName + "：商品 " + productName + " 库存正常，无需额外操作。");
            }
        }
        }

    }

/**
 * 具体观察者实现类（购物车系统）
 * 当库存发生变化时，购物车系统会收到通知，并根据库存情况对购物车中的商品进行提示或处理。
 *
 * 库存不足提示：
 * 如果购物车中有商品的库存数量低于一定阈值（例如只剩1件或少于5件），购物车系统可以显示一条提示消息告知用户该商品库存紧张。
 * 例如：“商品X库存仅剩1件，请尽快下单。”
 *
 *  库存耗尽提示：
 * 如果购物车中有商品的库存数量变为0，购物车系统可以显示一条提示消息告知用户该商品已经售罄，并询问用户是否需要将其从购物车中移除。
 * 例如：“商品Y已售罄，是否移除此商品？”
 *
 *  库存增加提示：
 * 如果某个商品的库存突然增加（可能是补货或退货），购物车系统可以显示一条提示消息，告知用户现在可以购买之前缺货的商品。
 * 例如：“商品Z库存增加，现在可以下单。”
 */
class ShoppingCartSystem implements InventoryObserver {
    // 购物车名称
    private String cartName;

    public ShoppingCartSystem(String cartName) {
        this.cartName = cartName;
    }

    @Override
    public void update(InventorySubject inventory) {
        if (inventory instanceof ProductInventory) {
            ProductInventory productInventory = (ProductInventory) inventory;
            System.out.println(cartName + " 收到商品 " + productInventory.getProductName() + " 的库存更新通知，当前库存数量为：" + productInventory.getQuantity());

            // 根据库存情况进行相应的提示或处理购物车中的商品
            String productName = ((ProductInventory) inventory).getProductName();
            int quantity = ((ProductInventory) inventory).getQuantity();
            if (quantity == 0) {
                // 库存为零时处理
                System.out.println(cartName + "：商品 " + productName + " 已售罄，已从您的购物车中移除。");
                // 移除购物车中的商品
                // cart.removeItem(productName);
            } else if (quantity < 5) {
                // 库存紧张时提示
                System.out.println(cartName + "：商品 " + productName + " 库存紧张，请尽快下单！");
            } else {
                // 库存正常时提示
                System.out.println(cartName + "：商品 " + productName + " 库存充足，可以下单。");
            }
        }
    }
}

/**
 * 具体观察者实现类（订单系统）
 * 当库存发生变化时，订单系统会收到通知，并根据库存情况进行相应的订单处理。
 */
class OrderSystem implements InventoryObserver {
    // 订单系统名称
    private String orderSystemName;

    public OrderSystem(String orderSystemName) {
        this.orderSystemName = orderSystemName;
    }

    @Override
    public void update(InventorySubject inventory) {
        if (inventory instanceof ProductInventory) {
            ProductInventory productInventory = (ProductInventory) inventory;
            System.out.println(orderSystemName + " 收到商品 " + productInventory.getProductName() + " 的库存更新通知，当前库存数量为：" + productInventory.getQuantity());
            // 根据库存情况进行相应的订单处理
        }
    }
}