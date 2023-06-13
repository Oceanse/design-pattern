package structuremode.bridgepattern;

/**
 * 需要开发一个跨平台视频播放器，可以在不同操作系统平台（如Windows、Mac、Linux等）上播放多种格式的视频文件，常见的视频格式包括RMVB、AVI、WMV等。
 * 该播放器包含了操作系统和播放器类型两个维度，适合使用桥接模式。
 *
 * 优点：
 * 桥接模式提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统。
 * 如：如果现在还有一种视频文件类型wmv，我们只需要再定义一个类实现VideoFile接口即可，其他类不需要发生变化。
 * 或者我们要新增一个操作系统，其他类不需要发生变化。
 *
 * 使用场景:
 * 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
 */
public class Client {
    public static void main(String[] args) {
        //windows支持 AVI和RMVB播放器
        OperatingSystem windows = new Windows(new AVIPlayer());
        windows.play("战狼3.avi");
        OperatingSystem windows2 = new Windows(new RMVBPlayer());
        windows2.play("天空之城.rmvb");

        //mac只支持 AVI播放器
        OperatingSystem mac = new Mac(new AVIPlayer());
        windows.play("这个杀手不太冷.avi");
    }
}
