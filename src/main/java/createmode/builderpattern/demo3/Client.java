package createmode.builderpattern.demo3;

/**
 * https://www.bookstack.cn/read/design-pattern-java/%E5%A4%8D%E6%9D%82%E5%AF%B9%E8%B1%A1%E7%9A%84%E7%BB%84%E8%A3%85%E4%B8%8E%E5%88%9B%E5%BB%BA%E2%80%94%E2%80%94%E5%BB%BA%E9%80%A0%E8%80%85%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89.md
 */
public class Client {
    public static void main(String[] args) {
        Actor hero = new HeroBuilder().construct();
        System.out.println("hero = " + hero);

        Actor angel = new AngelBuilder().construct();
        System.out.println("angel = " + angel);
    }
}
