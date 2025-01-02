package structuremode.decratorpattern.demo2;

/**
 *创建一个装饰者基类，该类实现了Component接口，并持有一个Component类型的成员变量
 */
public abstract class Decorator implements Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        // 默认行为是调用被装饰组件的display方法
        component.display();
    }
}
