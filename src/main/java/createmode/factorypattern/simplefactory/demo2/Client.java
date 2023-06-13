package createmode.factorypattern.simplefactory.demo2;

public class Client {
    public static void main(String args[]) {
        Chart chart;
        chart = ChartFactory.getChart("histogram"); //通过静态工厂方法创建柱状图
        chart.display();
        System.out.println();

        chart = ChartFactory.getChart("pie"); //通过静态工厂方法创建饼图
        chart.display();
        System.out.println();

        chart = ChartFactory.getChart("line"); //通过静态工厂方法创建折线图
        chart.display();
    }
}
