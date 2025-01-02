package createmode.builderpattern.demo2;

/**
 * 假设我们正在开发一个在线餐厅点餐系统。用户可以定制他们的订单，包括选择主菜、配菜、饮料等。每个订单可以有多个选项，
 * 而且每个选项可能还有额外的选择。使用建造者模式可以帮助我们更清晰地管理和构建这样的订单。
 *
 * Order 类：定义了一个订单类，包含主菜、配菜、饮料和是否额外辣的属性。
 * Builder 类：内部类 Builder 负责构建 Order 对象。它提供了流式的 API，允许我们按需设置订单的不同属性。
 *
 * 优点：
 * 封装性：建过程与对象表示的分离
 * 易用性： 流式 API(通过链式调用的方式设置对象的各个属性)，使得代码易读且使用方便。
 * 灵活性：避免了构造函数中参数过多的问题;可以灵活创建不同配置形态的对象，比如按需设置不同属性组合的订单对象，比如配送订单和店内用餐订单
 * 扩展性：轻松地添加新的属性或配置选项，假设在未来我们需要为 Order 类添加一个新的属性 notes，以便客户可以添加订单备注，
 * 我们可以通过简单地在 Order 类中添加一个新的属性，在 Builder 类中添加相应的属性和设置方法来实现。
 *
 * 缺点
 * 增加复杂性：需要额外编写 Builder 类，增加了代码量。
 * 对象创建成本增加：通过 Builder 创建对象的成本比直接使用构造函数更高。
 * 尽管如此，在构建复杂对象时，建造者模式提供了很好的解决方案，使得代码更加清晰、可维护和易于扩展。
 */

public class Order {
    private String customerName; // 客户名称
    private String mainDish; // 主菜
    private String sideDish; // 配菜
    private String drink; // 饮料
    private boolean extraSpicy; // 是否额外辣
    private boolean isDelivery; // 是否配送
    private String deliveryAddress; // 配送地址（仅当配送时有效）
    private double totalPrice; // 总价

    // 构造函数私有化，不允许外部直接实例化
    private Order(Builder builder) {
        this.customerName = builder.customerName;
        this.mainDish = builder.mainDish;
        this.sideDish = builder.sideDish;
        this.drink = builder.drink;
        this.extraSpicy = builder.extraSpicy;
        this.isDelivery = builder.isDelivery;
        this.deliveryAddress = builder.deliveryAddress;
        this.totalPrice = builder.totalPrice;
    }

    // Getter 方法
    public String getCustomerName() {
        return customerName;
    }

    public String getMainDish() {
        return mainDish;
    }

    public String getSideDish() {
        return sideDish;
    }

    public String getDrink() {
        return drink;
    }

    public boolean isExtraSpicy() {
        return extraSpicy;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Builder 类
    public static class Builder {
        private String customerName;
        private String mainDish;
        private String sideDish;
        private String drink;
        private boolean extraSpicy;
        private boolean isDelivery;
        private String deliveryAddress;
        private double totalPrice;

        // 构造函数
        public Builder() {}

        // 设置客户名称
        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        // 设置主菜
        public Builder setMainDish(String mainDish) {
            this.mainDish = mainDish;
            return this;
        }

        // 设置配菜
        public Builder setSideDish(String sideDish) {
            this.sideDish = sideDish;
            return this;
        }

        // 设置饮料
        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        // 设置是否额外辣
        public Builder setExtraSpicy(boolean extraSpicy) {
            this.extraSpicy = extraSpicy;
            return this;
        }

        // 设置是否配送
        public Builder setDelivery(boolean isDelivery) {
            this.isDelivery = isDelivery;
            return this;
        }

        // 设置配送地址（仅当配送时有效）
        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        // 设置总价（可以根据菜品和配送情况计算）
        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        // 构建 Order 对象
        public Order build() {
            return new Order(this);
        }
    }
}