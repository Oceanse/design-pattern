package structuremode.decratorpattern.demo1;

/**
 * 抽象装饰类: 构件装饰类
 */
public abstract class ComponentDecorator extends Component {

    //消除重复
    protected Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

}



/**
 * 具体装饰类: 黑色边框装饰类
 */
class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        //通过父类构造器初始化自己的component属性
        super(component);
        this.component=component;
    }

    /**
     * 对原有的component方法进行装饰增强
     */
    @Override
    public void display() {
        component.display();
        this.setBlackBorder();//装饰
    }

    /**
     * 新增的装饰
     */
    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }
}



/**
 * 具体装饰类:滚动条装饰类
 */
class ScrollBarDecorator extends ComponentDecorator {

    /**
     * 要能联想到子类对象是拥有component属性的
     *
     * @param component
     */
    public ScrollBarDecorator(Component component) {
        //抽象类的构造器不能直接实例化生成对象，但是可以供子类调用
        super(component);
    }

    @Override
    public void display() {
        component.display();
        this.setScrollBar();
    }

    public void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }
}