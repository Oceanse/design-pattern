package structuremode.facade;


//智能音箱
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