package createmode.factorypattern.abstractfactory.demo2;

//界面皮肤工厂接口：抽象工厂
public interface SkinFactory {
    public Button createButton();
    public TextField createTextField();
    public ComboBox createComboBox();
}

//Spring皮肤工厂：具体工厂,生产一个产品族中的所有产品
class SpringSkinFactory implements SkinFactory {
    public Button createButton() {
        return new SpringButton();
    }
    public TextField createTextField() {
        return new SpringTextField();
    }
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}


//Summer皮肤工厂：具体工厂,生产一个产品族中的所有产品
class SummerSkinFactory implements SkinFactory {
    public Button createButton() {
        return new SummerButton();
    }
    public TextField createTextField() {
        return new SummerTextField();
    }
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
