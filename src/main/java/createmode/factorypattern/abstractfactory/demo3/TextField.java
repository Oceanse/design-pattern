package createmode.factorypattern.abstractfactory.demo3;

/**
 * 抽象产品 - 文本框
  */
public interface TextField {
    void paint();
}


/**
 * Windows风格的文本框
 */
class WindowsTextField implements TextField {
    @Override
    public void paint() {
        System.out.println("Rendering a text field in Windows style.");
    }
}

/**
 *  Mac风格的文本框
 */
class MacTextField implements TextField {
    @Override
    public void paint() {
        System.out.println("Rendering a text field in Mac style.");
    }
}
