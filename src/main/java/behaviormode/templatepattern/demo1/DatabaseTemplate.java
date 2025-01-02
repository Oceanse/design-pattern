package behaviormode.templatepattern.demo1;

/**
 * 模板方法模式的基本组成部分:
 *  1) AbstractClass（抽象类）：
 *  定义了一系列基本操作这些基本操作可以是具体方法，也可以是抽象方法，
 *  实现了一个模板方法(Template Method)，用于定义一个调用上面的基本操作完成的顶层算法结构框架，子类不能改变这个整体结构，保证了算法的一致性和可靠性。为防止恶意操作，一般模板方法都加上 final 关键词。
 *
 *  2) ConcreteClass（具体子类）：
 *  实现或者覆盖父类中声明的抽象基本操作
 *
 * 优点：
 * 扩展性：新增子类可以根据需要重写抽象方法，实现不同的业务逻辑。比如当需要添加新的数据库操作类型时，只需要创建一个新的子类继承自DatabaseOperation，并实现特定的抽象方法即可。
 * 复用性：模板方法模式可以封装算法的整体结构，使得子类可以直接继承复用，减少了重复代码的编写。
 *
 * 缺点：
 * 子类的约束：子类必须遵循父类定义的算法结构，这可能会限制子类的灵活性。
 *
 * 应用场景：
 * 1 多个子类有相同的算法骨架，但具体实现不同：例如，在一个数据处理系统中，不同的数据处理方式可能有相同的处理流程，但具体的处理步骤不同。可以使用模板方法模式将处理流程定义在抽象类中，让子类实现具体的处理步骤。
 * 2 算法的结构相对稳定，而具体的实现细节容易变化：在这种情况下，使用模板方法模式可以将算法的结构封装在抽象类中，当具体的实现细节变化时，只需要修改子类的实现即可。
 * 3 希望减少代码重复，提高代码的可维护性：通过将算法的骨架定义在抽象类中，子类可以复用这些代码，减少了重复代码的编写，提高了代码的可维护性。
 *
 */
public class DatabaseTemplate {
    public static void main(String[] args) {
        DatabaseOperation insertOperation = new InsertOperation();
        insertOperation.executeOperation();

        DatabaseOperation selectOperation = new SelectOperation();
        selectOperation.executeOperation();
    }
}
