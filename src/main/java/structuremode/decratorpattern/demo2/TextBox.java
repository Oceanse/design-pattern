package structuremode.decratorpattern.demo2;

/**
 * 创建一个基本的文本框组件，实现Component接口
 */
public class TextBox implements Component {

    @Override
    public void display() {
        System.out.println("Displaying TextBox");
    }
}
