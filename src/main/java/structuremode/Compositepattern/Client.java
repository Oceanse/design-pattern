package structuremode.Compositepattern;

public class Client {
    public static void main(String[] args) {
        //针对抽象构件编程
        AbstractFile file1,file2,file3,file4,file5,folder1,folder2,folder3,folder4;

        //容器构件
        folder1 = new Folder("Sunny的资料");
        folder2 = new Folder("图像文件");
        folder3 = new Folder("文本文件");
        folder4 = new Folder("视频文件");

        //叶子构件
        file1 = new ImageFile("小龙女.jpg");
        file2 = new ImageFile("张无忌.gif");
        file3 = new TextFile("九阴真经.txt");
        file4 = new TextFile("葵花宝典.doc");
        file5 = new VideoFile("笑傲江湖.rmvb");

        //叶子构件分类放到容器构件中
        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);

        //所有容器构件最后放置到一个统一的容器中
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        //从“Sunny的资料”节点开始进行杀毒操作
       // folder1.killVirus();

        //如果需要更换操作节点，例如只需对文件夹“文本文件”进行杀毒，客户端代码只需修改一行:
        folder3.killVirus();
    }
}
