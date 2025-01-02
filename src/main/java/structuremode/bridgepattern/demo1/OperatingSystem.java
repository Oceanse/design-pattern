package structuremode.bridgepattern.demo1;


public abstract class OperatingSystem {

    //抽象关联取代了传统的多层继承
    protected VideoPlayer videoPlayer;

    public OperatingSystem(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    public abstract void play(String fileName);
}


//Windows版本
 class Windows extends OperatingSystem {

    public Windows(VideoPlayer videoPlayer) {
        super(videoPlayer);
    }

    public void play(String fileName) {
        System.out.println("当前文件将由windows player播放.");
        videoPlayer.play(fileName);
    }
}

//mac版本
 class Mac extends OperatingSystem {

    public Mac(VideoPlayer videoPlayer) {
        super(videoPlayer);
    }

    public void play(String fileName) {
        System.out.println("当前文件将由mac player播放.");
        videoPlayer.play(fileName);
    }
}
