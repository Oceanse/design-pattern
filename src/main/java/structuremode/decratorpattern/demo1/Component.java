package structuremode.decratorpattern.demo1;

/**
 * 抽象界面构件类：抽象构件类，为了突出与模式相关的核心代码，对原有控件代码进行了大量的简化
 */
public abstract class Component {
    public abstract void display();
}

/**
 * 具体构件类:窗体类
 */
class Window extends Component {
    public void display() {
        System.out.println("显示窗体！");
    }
}

/**
 * 具体构件类:文本框类
 */
class TextBox extends Component {
    public void display() {
        System.out.println("显示文本框！");
    }
}

/**
 * 具体构件类:列表框类
 */
class ListBox extends Component {
    public void display() {
        System.out.println("显示列表框！");
    }
}
