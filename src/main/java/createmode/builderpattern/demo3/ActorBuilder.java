package createmode.builderpattern.demo3;

/**
 * 角色建造器：抽象建造者
 * 省略指挥者类ActorController： 在有些情况下，为了简化系统结构，可以将Director和抽象建造者Builder进行合并，在Builder中提供封装创建流程的construct()方法。
 */
public abstract class ActorBuilder {
    /**
     * 初始化产品
     */
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    /**
     * 工厂方法，返回一个完整的游戏角色对象
     */
    public Actor createActor() {
        return actor;
    }


    /**
     * 通过引入钩子方法，我们可以在Director中对复杂产品的构建进行精细的控制，不仅指定buildPartX()方法的执行顺序，还可以控制是否需要执行某个buildPartX()方法。
     * 钩子方法的返回类型通常为boolean类型，方法名一般为isXXX(),定义在抽象建造者类中
     * 方法isBareheaded()，用于判断某个角色是否为“光头(Bareheaded)”，其返回值默认为false
     * 如果某个角色无须构建头发部件，例如“恶魔(Devil)”，则对应的具体建造器DevilBuilder将覆盖isBareheaded()方法，
     * 并将返回值改为true
     *
     * @return
     */
    public boolean isBareheaded() {
        return false;
    }

    //逐步构建复杂产品对象
    public Actor construct() {
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        //如果isBareheaded()方法返回true，即没有头发，则跳过构建发型的方法buildHairstyle()；否则将执行buildHairstyle()方法。
        if (!isBareheaded()) {
            this.buildHairstyle();
        }
        Actor actor = this.createActor();
        return actor;
    }
}
