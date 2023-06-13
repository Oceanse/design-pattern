package structuremode.proxypattern.dynamicproxy;

/**
 * 卖票接口
 */
public interface SellTickets {
    void sell();
}

/**
 * 火车站  火车站具有卖票功能，所以需要实现SellTickets接口
 */
class TrainStation implements SellTickets {

    public void sell() {
        System.out.println("火车站卖票");
    }
}