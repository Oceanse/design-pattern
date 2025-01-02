package structuremode.bridgepattern.demo2;


/**
 * 控制方式接口
 */
interface ControlMode {
    String controlDevice();
}

/**
 * APP 控制
 */
class MobileAppControl implements ControlMode {
    @Override
    public String controlDevice() {
        return "mobile app";
    }
}

/**
 * 语音控制
 */
class VoiceControl implements ControlMode {
    @Override
    public String controlDevice() {
        return "voice";
    }
}

/**
 * 手势控制
 */
class GestureControl implements ControlMode {
    @Override
    public String controlDevice() {
        return "gesture";
    }
}