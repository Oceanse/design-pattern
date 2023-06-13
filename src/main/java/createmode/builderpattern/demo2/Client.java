package createmode.builderpattern.demo2;

/**
 * https://www.bookstack.cn/read/design-pattern-java/%E5%A4%8D%E6%9D%82%E5%AF%B9%E8%B1%A1%E7%9A%84%E7%BB%84%E8%A3%85%E4%B8%8E%E5%88%9B%E5%BB%BA%E2%80%94%E2%80%94%E5%BB%BA%E9%80%A0%E8%80%85%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89.md
 */
public class Client {
    public static void main(String[] args) {
        //指挥者针对抽象建造者编程，客户端只需要知道具体建造者的类型，即可通过指挥者类调用建造者的相关方法，
        ActorController actorController=new ActorController(new HeroBuilder());
        Actor hero = actorController.construct();
        System.out.println("hero = " + hero);

        //切换不同的具体建造者
        actorController.setActorBuilder(new AngelBuilder());
        Actor angel = actorController.construct();
        System.out.println("angel = " + angel);
    }
}
