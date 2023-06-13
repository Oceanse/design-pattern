package structuremode.bridgepattern;

/**
 * 视频播放器接口
 */
public interface VideoPlayer {
    void play(String fileName);
}

//avi文件
class AVIPlayer implements VideoPlayer {
    public void play(String fileName) {
        if (fileName.endsWith(".avi")) {
            System.out.println("avi视频文件：" + fileName);
        } else {
            System.out.println("AVI播放器不支持当前文件类型");
        }
    }
}

//rmvb文件
class RMVBPlayer implements VideoPlayer {
    public void play(String fileName) {
        if (fileName.endsWith(".rmvb")) {
            System.out.println("rmvb视频文件：" + fileName);
        } else {
            System.out.println("RMVB播放器不支持当前文件类型");
        }
    }
}