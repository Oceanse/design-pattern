package structuremode.decratorpattern.demo2;

/**
 *创建一个为组件设置背景色的装饰者
 */
public class BackgroundColorDecorator extends Decorator {

    private String color;

    public BackgroundColorDecorator(Component component, String color) {
        super(component);
        this.color = color;
    }

    @Override
    public void display() {
        // 在显示之前设置背景色逻辑
        System.out.println("Setting background color to " + color);
        super.display(); // 调用父类的display方法，间接调用被装饰组件的display方法
    }
}
