package createmode.factorypattern.abstractfactory.demo3;

/**
 * 抽象产品 - 按钮
 */
public interface Button {
    void paint();
}


/**
 *  Windows风格的按钮
 */
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Windows style.");
    }
}

/**
 * Mac风格的按钮
 */
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Mac style.");
    }
}