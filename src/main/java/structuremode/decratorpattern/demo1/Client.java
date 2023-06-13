package structuremode.decratorpattern.demo1;

/**
 * 客户端
 * 装饰模式(Decorator Pattern)：动态地给一个对象增加一些额外的职责，在不改变一个对象本身功能的基础上给对象增加额外的新行为，
 * 装饰模式是一种用于替代继承的技术，它通过一种无须定义子类的方式来给对象动态增加职责，使用对象之间的关联关系取代类之间的继承关系。
 * 在装饰模式中引入了装饰类，在装饰类中既可以调用待装饰的原有类的方法，还可以增加新的方法，以扩充原有类的功能。
 */
public class Client {
    public  static void main(String args[])
    {
        Component  component,componentWithScrollBar,componentWithScrollBarAndBlackBorder; //全部使用抽象构件定义
        component = new Window();
        component.display();
        System.out.println();

        componentWithScrollBar = new  ScrollBarDecorator(component);
        componentWithScrollBar.display();
        System.out.println();

        componentWithScrollBarAndBlackBorder = new  BlackBorderDecorator(componentWithScrollBar); //将装饰了一次之后的对象继续注入到另一个装饰类中，进行第二次装饰
        componentWithScrollBarAndBlackBorder.display();
    }
}
