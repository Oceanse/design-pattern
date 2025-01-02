package structuremode.facade.demo1;


/**
 * 当前场景：
 * 小明的爷爷已经60岁了，一个人在家生活：每次都需要打开灯、打开电视、打开空调；睡觉时关闭灯、关闭电视、关闭空调；
 * 操作起来都比较麻烦。所以小明给爷爷买了智能音箱，可以通过语音直接控制这些智能家电的开启和关闭。
 */
public class SmartAppliancesFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    public void say(String message) {
        if(message.contains("打开")) {
            onAll();
        } else if(message.contains("关闭")) {
            offAll();
        } else {
            System.out.println("我还听不懂你说的！！！");
        }
    }

    //起床后一键开电器
    private void onAll() {
        light.on();
        tv.on();
        airCondition.on();
    }

    //睡觉一键关电器
    private void offAll() {
        light.off();
        tv.off();
        airCondition.off();
    }
}