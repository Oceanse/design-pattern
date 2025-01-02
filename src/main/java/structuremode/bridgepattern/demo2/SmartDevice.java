package structuremode.bridgepattern.demo2;

/**
 * 智能设备接口
 */
abstract class SmartDevice {
    protected ControlMode controlMode;

    public SmartDevice(ControlMode controlMethod) {
        this.controlMode = controlMethod;
    }

    public abstract void performAction();
}

/**
 *智能灯
 */
class SmartLight extends SmartDevice {
    public SmartLight(ControlMode controlMode) {
        super(controlMode);
    }

    @Override
    public void performAction() {
        System.out.println("Smart light is being controlled by " + controlMode.controlDevice() + " method.");
    }
}

/**
 *智能窗帘
 */
class SmartCurtain extends SmartDevice {
    public SmartCurtain(ControlMode controlMode) {
        super(controlMode);
    }

    @Override
    public void performAction() {
        System.out.println("Smart curtain is being controlled by " + controlMode.controlDevice() + " method.");
    }
}

/**
 *智能插座
 */
class SmartSocket extends SmartDevice {
    public SmartSocket(ControlMode controlMode) {
        super(controlMode);
    }

    @Override
    public void performAction() {
        System.out.println("Smart socket is being controlled by " + controlMode.controlDevice() + " method.");
    }
}
