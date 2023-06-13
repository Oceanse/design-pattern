package structuremode.adaptorpattern;

/**
 * 适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁
 * 现有一台电脑只能读取SD卡，而要读取TF卡中的内容的话就需要使用到适配器模式, 创建一个SD卡适配器，将TF卡中的内容读取出来。
 * 使用场景：系统需要复用现有类(TFCard)，而该类的接口不符合系统的需求，可以使用适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 */
public class Computer {
    public String readSD(SDCard sdCard) {
        if(sdCard == null) {
            throw new NullPointerException("sd card null");
        }
        return sdCard.readSD();
    }
}
