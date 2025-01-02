package behaviormode.templatepattern.demo3;

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        GameLevel beginnerLevel = new BeginnerLevel();
        beginnerLevel.playLevel();

        System.out.println();

        GameLevel advancedLevel = new AdvancedLevel();
        advancedLevel.playLevel();
    }
}
