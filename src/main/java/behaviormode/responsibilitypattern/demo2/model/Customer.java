package behaviormode.responsibilitypattern.demo2.model;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    // 获取客户名称
    public String getName() {
        return name;
    }
}
