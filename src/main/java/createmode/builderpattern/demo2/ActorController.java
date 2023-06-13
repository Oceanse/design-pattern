package createmode.builderpattern.demo2;

/**
 * 游戏角色创建控制器：指挥者
 * 该类主要有两个作用：
 * 1 一方面它隔离了客户与创建过程；
 * 2 另一方面它控制产品的创建过程，包括某个buildPartX()方法是否被调用以及多个buildPartX()方法调用的先后次序等
 */
public class ActorController {

    ActorBuilder actorBuilder;
    public ActorController(ActorBuilder actorBuilder){
        this.actorBuilder=actorBuilder;
    }

    public void setActorBuilder(ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }

    //逐步构建复杂产品对象
    public Actor construct()
    {
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        actorBuilder.buildHairstyle();
        Actor actor=actorBuilder.createActor();
        return actor;
    }
}
