package createmode.prototypepattern.demo3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单接口
 */
public interface Order extends Cloneable {
    String getId();
    String getCustomerName();
    void setCustomerName(String customerName);
    List<Item> getItems();
    Date getOrderDate();
    void setOrderDate(Date date);
    Order clone();

}

/**
 * 普通订单
 */
 class RegularOrder implements Order {
    // 订单唯一标识符
    private String id;

    // 下单客户的姓名
    private String customerName;

    // 订单中包含的所有商品项
    private List<Item> items;

    // 订单的创建日期
    private Date orderDate;

    public RegularOrder(String id, String customerName, List<Item> items) {
        this.id = id;
        this.customerName = customerName;
        this.items = items;
        this.orderDate = new Date();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName=customerName;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public RegularOrder clone() {
        try {
            RegularOrder orderCopy = (RegularOrder) super.clone();

            // 深拷贝 items 列表
            List<Item> deepCopiedItems = new ArrayList<>();
            for (Item item : this.items) {
                deepCopiedItems.add((Item)item.clone()); // 调用每个 Item 的 clone 方法
            }

            orderCopy.items = deepCopiedItems; //重新赋值列表属性
            return orderCopy;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    @Override
    public String toString() {
        return "RegularOrder{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                ", orderDate=" + orderDate +
                '}';
    }
}



/**
 * 团购订单
 */
 class GroupOrder implements Order {
   // 订单唯一标识符
    private String id;

    // 下单客户的姓名
    private String customerName;

    // 订单中包含的所有商品项
    private List<Item> items;

    // 订单的创建日期
    private Date orderDate;

    // 团购订单的参与人数
    private int groupSize;

    public GroupOrder(String id, String customerName, List<Item> items, int groupSize) {
        this.id = id;
        this.customerName = customerName;
        this.items = items;
        this.groupSize = groupSize;
        this.orderDate = new Date();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName=customerName;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    @Override
    public GroupOrder clone() {
        try {
            GroupOrder orderCopy = (GroupOrder) super.clone();

            // 深拷贝 items 列表
            List<Item> deepCopiedItems = new ArrayList<>();
            for (Item item : this.items) {
                deepCopiedItems.add((Item)item.clone()); // 调用每个 Item 的 clone 方法
            }

            orderCopy.items = deepCopiedItems; //重新赋值列表属性
            return orderCopy;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    @Override
    public String toString() {
        return "GroupOrder{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                ", orderDate=" + orderDate +
                ", groupSize=" + groupSize +
                '}';
    }
}

/**
 * 订单项
 */
 class Item implements Cloneable{
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
