package createmode.prototypepattern.demo1;

/**
 * 概念：
 * 先克隆，后修改(可选)
 * 原型模式（Prototype Pattern）之所以被称为“原型模式”，主要是因为它通过一个已存在的对象（称为“原型”）来创建新的对象。
 * 这个模式的核心思想是使用现有的对象作为模板（即原型），通过克隆一个原型对象，然后再根据需要修改，无须再从头开始创建，这样可以快速生成多个实例，而不需要每次都执行相同的初始化步骤。
 *
 * 优点：
 * 简化创建过程和成本：对于复杂的对象，创建过程可能非常繁琐，构造过程可能需要大量的计算或资源访问，直接使用构造器创建大量相同或者相似对象可能会非常耗时和消耗资源，
 * 原型模式通过克隆一个原型对象，然后再根据需要修改，无须再从头开始创建
 *
 *
 * 使用场景：
 * 当需要创建大量的相同相似复杂对象时，通过克隆一个原型对象，可以快速生成多个实例，而不需要每次从头开始创建。
 * 如果需要大量的定制化的相似对象，可以先克隆一个原型对象，然后对这个原型对象进行修改获得不同形态的相似对象
 *
 * 1 在数据库连接池中，需要创建多个连接对象来管理数据库连接。这些连接对象可能具有相同的配置信息（如用户名、密码等），但它们是独立的连接。
 * 2 在游戏开发中，经常需要创建大量的游戏角色。每个角色可能具有不同的属性（如生命值、攻击力、防御力等），但它们的基本属性模板通常是相似的。
 *   可以创建一个基础角色模板，并通过克隆该模板来创建多个角色。克隆后的角色可以根据需要进行适当的修改，以适应不同的游戏情境。
 * 3 文档模板：在文档处理系统中，创建多个相似的文档时，可以使用一个模板文档作为原型，通过复制并修改内容来生成新的文档。
 * 4 UI 控件的创建：在图形用户界面（GUI）应用程序中，可能需要创建多个相似的控件（如按钮、文本框等）。这些控件可能具有相同的样式和行为，但它们的位置和大小可能略有不同。
 *   可以创建一个控件模板，并通过克隆模板来创建多个控件。克隆后的控件可以根据需要进行调整，以适应不同的位置和大小需求。
 * 5 再来一单
 *
 */
public class Client {
    public static void main(String[] args) {
        DatabaseConnection originConnection = new DatabaseConnection("admin", "password", "mydatabase");

        // 克隆连接对象
        DatabaseConnection connection1 = originConnection.clone();
        connection1.setUsername("user1");

        DatabaseConnection connection2 = originConnection.clone();
        connection2.setUsername("user2");

        System.out.println("Origin Connection:");
        System.out.println("Username: " + originConnection.getUsername());
        System.out.println("Password: " + originConnection.getPassword());
        System.out.println("Database Name: " + originConnection.getDatabaseName());

        System.out.println("\nCloned Connection 1:");
        System.out.println("Username: " + connection1.getUsername());
        System.out.println("Password: " + connection1.getPassword());
        System.out.println("Database Name: " + connection1.getDatabaseName());

        System.out.println("\nCloned Connection 2:");
        System.out.println("Username: " + connection2.getUsername());
        System.out.println("Password: " + connection2.getPassword());
        System.out.println("Database Name: " + connection2.getDatabaseName());
    }
}
