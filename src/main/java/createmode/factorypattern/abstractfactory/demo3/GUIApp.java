package createmode.factorypattern.abstractfactory.demo3;

/**
 * 假设我们正在开发一个图形界面库，这个库需要支持不同的操作系统（如Windows和MacOS），并且每个操作系统都有自己的风格的按钮和文本框。
 * 我们需要保证当用户选择了一个操作系统后，所创建的所有控件都符合该操作系统的风格。这里就可以使用抽象工厂模式来实现这一需求。
 */
public class GUIApp {
    public static void main(String[] args) {
        //Mac风格
        GUIFactory macFactory = new MacFactory();
        Button button = macFactory.createButton();
        TextField textField = macFactory.createTextField();
        button.paint();
        textField.paint();

        //Mac风格
        GUIFactory winFactory = new WindowsFactory();
        Button button2 = winFactory.createButton();
        TextField textField2 = winFactory.createTextField();
        button2.paint();
        textField2.paint();
    }
}