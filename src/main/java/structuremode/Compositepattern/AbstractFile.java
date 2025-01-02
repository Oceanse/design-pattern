package structuremode.Compositepattern;

import java.util.ArrayList;

/**
 * 组合模式的关键是定义了一个抽象组件类，它既可以代表叶子组件，又可以代表容器组件，而客户端针对该抽象组件类进行编程，无须知道它到底表示的是叶子还是容器，可以对其进行统一处理。
 * 容器组件与抽象组件类之间还建立一个聚合关联关系，在容器对象中既可以包含叶子组件，也可以包含容器组件，以此实现递归组合，形成一个树形结构。
 * <p>
 * Component（抽象节点）：是叶子节点和容器节点的共同父节点，定义了对容器节点和叶子节点的统一操作，如 add、remove、getChild、display等。
 * Leaf（叶子节点）：叶子节点没有子节点，它实现了在抽象节点中定义的行为。
 * Composite（容器节点）：它提供一个集合用于存储子节点，其子节点可以是叶子节点，也可以是容器节点，它实现了在抽象节点中定义的行为。
 * Client（客户端）：使用 Component 接口的对象，无需关心它是叶子节点还是容器节点。
 * <p>
 * 优点：
 * 易用性(透明性)：客户端可以一致地处理叶子节点和容器节点，无需区分它们的具体类型
 * 扩展性：可以方便地添加新的叶子节点或者容器节点类型，因为新增加的类只需要实现相同的接口，而不会影响现有的代码结构。
 * <p>
 * 使用场景：
 * 组合模式适用于多种需要处理具有“部分-整体”层次结构的数据的情况，希望忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 * 文件系统：文件和文件夹可以形成一个树形结构，文件夹是复合组件，可以包含文件和其他文件夹，文件是叶子组件。
 */
//抽象构件:抽象文件类，是容器构件类和叶子构件类的共同父类
public abstract class AbstractFile {
    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void display();
}


/**
 * 叶子构件: 图像文件类
 */
class ImageFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void display() {
        System.out.println("图像文件: " + name);
    }
}


/**
 * 叶子构件: 文本文件类
 */
class TextFile extends AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void display() {
        System.out.println("文本文件: " + name);
    }
}


/**
 * 叶子构件: 视频文件类
 */
class VideoFile extends AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void display() {
        System.out.println("视频文件: " + name);
    }
}


/**
 * 容器构件: 文件夹类
 */
class Folder extends AbstractFile {
    //定义集合fileList，用于存储AbstractFile类型的成员
    private ArrayList<AbstractFile> fileList = new ArrayList<AbstractFile>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void display() {
        //递归调用成员构件的display()方法
        for (AbstractFile obj : fileList) {
            obj.display();
        }
    }
}