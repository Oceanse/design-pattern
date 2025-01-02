package structuremode.decratorpattern.demo2;

/**
 * 在图形用户界面（GUI）开发中，常常需要为各种基础组件（如按钮、文本框等）添加额外的样式行为
 * 使用装饰者模式，可以创建不同的装饰类来为基础组件添加这些功能，而不需要修改组件的原始代码。
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个基本的文本框组件
        Component textBox = new TextBox();

        // 添加边框装饰
        Component borderedTextBox = new BorderDecorator(textBox);

        // 添加背景色装饰
        Component coloredTextBox = new BackgroundColorDecorator(borderedTextBox, "red");

        // 显示文本框
        coloredTextBox.display();
    }
}
