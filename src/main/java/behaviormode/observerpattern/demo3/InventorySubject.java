package behaviormode.observerpattern.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义库存主题接口（被观察者）
 */
interface InventorySubject {
    void registerObserver(InventoryObserver observer);
    void removeObserver(InventoryObserver observer);
    void notifyObservers();
}

/**
 * 具体主题实现类（商品库存）
 */
class ProductInventory implements InventorySubject {
    // 商品名称
    private String productName;
    // 库存数量
    private int quantity;
    // 观察者列表
    private List<InventoryObserver> observers;

    public ProductInventory(String productName) {
        this.productName = productName;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(InventoryObserver observer) {
        // 将观察者添加到列表中
        observers.add(observer);
    }

    @Override
    public void removeObserver(InventoryObserver observer) {
        // 从列表中移除观察者
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (InventoryObserver observer : observers) {
            // 通知每个观察者库存变化
            observer.update(this);
        }
    }

    // 设置库存数量并通知观察者
    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
        System.out.println("商品 " + productName + " 的库存数量更新为：" + quantity);
        // 库存数量变化时通知所有观察者
        notifyObservers();
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}