package behaviormode.templatepattern.demo1;

/**
 * 设计一个系统时知道了算法所需的关键步骤，而且确定了这些步骤的执行顺序，但某些步骤的具体实现还未知，
 * 或者说某些步骤的实现与具体的环境相关,因此可以将算法的一些步骤延迟到子类中去实现
 *
 * 模板方法（Template Method）模式包含以下主要角色：
 * 抽象类（Abstract Class）：负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成。
 *  模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法。
 *  基本方法：是实现算法各个步骤的方法，是模板方法的组成部分。基本方法又可以分为2种：
 *      抽象方法(Abstract Method) ：一个抽象方法由抽象类声明、由其具体子类实现。
 *      具体方法(Concrete Method) ：一个具体方法由一个抽象类或具体类声明并实现，其子类可以进行覆盖也可以直接继承。
 * 具体子类（Concrete Class）：实现抽象类中所定义的抽象方法。
 */
public class Client {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
