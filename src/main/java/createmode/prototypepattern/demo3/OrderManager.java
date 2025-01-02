package createmode.prototypepattern.demo3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 先克隆再修改：如果需要大量的定制化的相似对象，可以先克隆一个原型对象，然后对这个原型对象进行修改获得不同形态的相似对象，而不需要每次从头开始创建。
 *
 * 再来一单场景：
 * 假设你正在开发一个电子商务平台，该平台需要处理各种类型的订单，例如普通订单、团购订单、预售订单等。
 * 每种订单类型可能有一些特定的属性和处理逻辑。当我们需要创建一个新的订单时，如果每次都通过构造函数来初始化这些订单，
 * 可能会导致代码冗余和效率低下。因此，我们可以使用原型模式来克隆已有的订单实例，然后进行少量修改，从而快速生成新的订单对象。
 */
public class OrderManager {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个普通订单
        List<Item> items = new ArrayList<>();
        items.add(new Item("Book", 9.99));
        RegularOrder regularOrder = new RegularOrder("ORD12345", "Alice", items);
        // 再来一单
        RegularOrder clonedRegularOrder = regularOrder.clone();
        // 修改订单日期
        Thread.sleep(1000);
        clonedRegularOrder.setOrderDate(new Date());
        // 输出结果
        System.out.println("Original Regular Order: " + regularOrder);
        System.out.println("Cloned Regular Order: " + clonedRegularOrder);


        // 创建一个团购订单
        GroupOrder groupOrder = new GroupOrder("GRP67890", "Bob", items, 5);
        // 再来一单，修改团购人数和订单日期
        GroupOrder clonedGroupOrder = groupOrder.clone();
        groupOrder.setGroupSize(10);
        Thread.sleep(1000);
        groupOrder.setOrderDate(new Date());
        System.out.println("Original Group Order  : " + groupOrder);
        System.out.println("Cloned Group Order : " + clonedGroupOrder);
    }
}
