package behaviormode.observerpattern.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义主题接口（被观察者）
 */
public interface StockSubject {
    // 注册观察者
    void registerObserver(StockObserver observer);
    // 移除观察者
    void removeObserver(StockObserver observer);
    // 通知所有观察者
    void notifyObservers();
}


/**
 * 具体主题实现类（股票）
 */
class Stock implements StockSubject {
    private String stockName;//股票名称
    private double price;//股价
    private List<StockObserver> observers; //股票投资者

    public Stock(String stockName) {
        this.stockName = stockName;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }

    // 设置股票价格并通知观察者
    public void setPrice(double newPrice) {
        price = newPrice;
        System.out.println("股票 " + stockName + " 的价格更新为：" + price);
        notifyObservers();
    }

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }
}