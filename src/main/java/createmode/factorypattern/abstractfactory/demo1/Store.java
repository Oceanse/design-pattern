package createmode.factorypattern.abstractfactory.demo1;

public class Store {
    public static void main(String[] args) {
        Factory appleFactory=new AppleFactory();
        Phone iphone = appleFactory.createPhone();
        Pad ipad = appleFactory.createPad();
        iphone.showInfo();
        ipad.showInfo();

        Factory huaweiFactory=new HuaweiFactory();
        Phone huaweiPhone = huaweiFactory.createPhone();
        Pad huaweiPad = huaweiFactory.createPad();
        huaweiPhone.showInfo();
        huaweiPad.showInfo();

    }
}
