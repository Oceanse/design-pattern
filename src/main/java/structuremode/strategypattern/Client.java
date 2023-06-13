package structuremode.strategypattern;

public class Client {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println();

        //学生折扣策略对象
        Discount studentDiscount=new StudentDiscount();
        mt.setDiscount(studentDiscount); //注入折扣对象
        double currentPrice = mt.getPrice();
        System.out.println("优惠后价为：" + currentPrice);
        System.out.println();

        //vip折扣策略对象
        Discount vipDiscount=new VIPDiscount();
        mt.setDiscount(vipDiscount); //注入折扣对象
        double currentPrice2 = mt.getPrice();
        System.out.println("优惠价为：" + currentPrice2);
        System.out.println();

        //儿童折扣策略对象
        Discount childrenDiscount=new ChildrenDiscount();
        mt.setDiscount(childrenDiscount); //注入折扣对象
        double currentPrice3 = mt.getPrice();
        System.out.println("优惠价为：" + currentPrice3);
    }
}
