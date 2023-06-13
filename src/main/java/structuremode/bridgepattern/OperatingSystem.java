package structuremode.bridgepattern;

/**
 * 桥接模式是一种很实用的结构型设计模式，如果软件系统中某个类存在两个独立变化的维度，通过该模式可以将这两个维度分离出来，使两者可以独立扩展，让系统更加符合“单一职责原则”。
 * 它将两个独立变化的维度设计为两个独立的继承等级结构，并且在抽象层建立一个抽象关联，该关联关系类似一条连接两个独立继承结构的桥，故名桥接模式。
 */
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
        videoPlayer.play(fileName);
    }
}

//mac版本
 class Mac extends OperatingSystem {

    public Mac(VideoPlayer videoPlayer) {
        super(videoPlayer);
    }

    public void play(String fileName) {
        videoPlayer.play(fileName);
    }
}
