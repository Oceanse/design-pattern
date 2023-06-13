package createmode.factorypattern.factory.demo1;

public class PhoneStore {
    public static void main(String[] args) {
        IphoneFactory iphoneFactory = new IphoneFactory();
        Phone iphone = iphoneFactory.createPhone();
        iphone.showInfo();

        HuaweiPhoneFactory huaweiPhoneFactory = new HuaweiPhoneFactory();
        Phone huaweiPhone = huaweiPhoneFactory.createPhone();
        huaweiPhone.showInfo();
    }
}
