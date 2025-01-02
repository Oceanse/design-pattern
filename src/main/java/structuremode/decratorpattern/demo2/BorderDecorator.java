package structuremode.decratorpattern.demo2;

/**
 * 创建一个为组件添加边框的装饰者
 */
public class BorderDecorator extends Decorator {

    public BorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        // 在显示之前添加边框逻辑
        System.out.println("Adding border...");
        super.display(); // 调用父类的display方法，间接调用被装饰组件的display方法
    }
}