package structuremode.decratorpattern.demo1;

/**
 * 装饰者模式可以在不改变现有对象结构的前提下，动态添加新功能
 *
 * 角色：
 * Component（抽象组件）：：它是具体构件和抽象装饰类的共同父类，声明了在具体组件中实现的业务方法
 * ConcreteComponent（具体组件）：实现抽象组件的基本功能
 * Decorator（抽象装饰类）：实现并关联抽象组件
 * ConcreteDecorator（具体装饰类）：负责向组件添加新的功能
 *
 * 实现：
 * 装饰者继承并关联基础组件
 *
 * 优点：
 * 1 扩展性：在不改变对象本身的情况下，通过添加装饰器来扩展其功能，也符合开闭原则，例如可以动态地给基础咖啡添加牛奶或糖，而不需要修改基础咖啡的实现。
 * 2 可维护性：
 *     单一职责：每个装饰器只负责添加一个特定的功能，使得每个类的职责单一，易于理解和维护。例如，Milk 和 Sugar 分别只负责添加牛奶和糖的功能，而不是将所有功能混杂在一起。
 *     符合开闭原则：：不改变原有类，通过增加装饰器来增强功能。
 * 3 灵活性：装饰者模式支持灵活地组合不同的功能。在上面的示例中，可以自由地组合不同的装饰器，以实现不同的组合效果。例如，可以先添加牛奶再添加糖，或者只添加牛奶等。
 * 4 透明性：装饰者模式保证了客户端代码对装饰者和被装饰对象的透明性。客户端并不会觉得对象在装饰前和装饰后有什么不同。在上面的示例中，客户端始终使用 Coffee 接口来操作咖啡对象，无论它是否已经被装饰。
 *
 * 应用场景：
 * 不改变现有对象结构的前提下动态添加新功能
 * 餐饮系统：在上面的咖啡示例中，可以动态地为咖啡添加不同的配料（如牛奶、糖等），而不需要修改基础咖啡的实现；类似的还有一个简单的煎饼类，可以通过装饰者模式为其添加鸡蛋、香肠等配料，从而在不修改煎饼类本身的情况下，实现功能的扩展。
 * 用户界面组件：在GUI开发中，可以使用装饰者模式来为UI组件添加不同的样式或行为（如滚动条、边框等），而不需要修改每个组件的实现。
 *
 *
 * 与适配器模式：
 * 适配器模式用于接口转换，装饰者模式用于功能扩展。
 * 装饰者模式强调的是增强对象的功能，适配器模式强调的是兼容性。
 */
public class CoffeeShopMenu {
    public static void main(String[] args) {
        // 创建一个基础的 luckin Coffee
        Coffee luckin = new Luckin();
        System.out.println(luckin.getDescription() + " $" + luckin.cost());

        // 创建一个 Cappuccino，并添加牛奶
        Coffee luckinWithMilk = new Milk(luckin);
        System.out.println(luckinWithMilk.getDescription() + " $" + luckinWithMilk.cost());

        // 创建一个 LuckyBlend Coffee，然后依次添加牛奶和糖
        Coffee starbucksWithSugarAndMilk = new Sugar(new Milk(new Starbucks()));
        System.out.println(starbucksWithSugarAndMilk.getDescription() + " $" + starbucksWithSugarAndMilk.cost());
    }
}
