package createmode.factorypattern.abstractfactory.demo3;

/**
 * 抽象工厂
 */
public interface GUIFactory {
    Button createButton();
    TextField createTextField();
}

/**
 *  Windows工厂
 */
 class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

/**
 * Mac工厂
 */
 class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}