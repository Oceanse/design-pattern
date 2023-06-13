package createmode.builderpattern.background;

/**
 * 产品和产品的创建过程封装在一起，耦合性增强
 */
public abstract class AbstractHouse {

    /**
     * 地基
     */
    private String basic;

    /**
     * 墙
     */
    private String walls;

    /**
     * 封顶
     */
    private String roofed;


    /**
     * 打地基
     */
    public abstract void buildBasic();

    /**
     * 砌墙
     */
    public abstract void buildWalls();

    /**
     * 封顶
     */
    public abstract void roofed();

    /**
     * 建造房屋的方法
     */
    public void build(){
        buildBasic();
        buildWalls();
        roofed();
    }
}
