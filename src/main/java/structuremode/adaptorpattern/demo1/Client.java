package structuremode.adaptorpattern.demo1;

/**
 * 适配器模式在不修改代码的前提下，将一种接口转换成客户端期望的另一种接口，使其能够兼容新系统。
 * 适配器模式的核心思想是“变换接口，兼容不同”，在系统需要对接遗留模块或外部库时尤为实用。
 *
 * 角色：
 * 目标接口（Target）：客户端需要的接口，可以是一个抽象类或接口，也可以是具体类。
 * 被适配者（Adaptee）：已有的接口或类。
 * 适配器（Adapter）：将目标接口和被适配者连接起来，进行接口转换。
 *
 * 实现：
 * 实现新系统标准，关联旧组件或者第三方组件
 *
 * 使用场景：
 * 当你需要复用一些已有组件，但是它们的接口不符合要求，可以对其进行适配，当然有新的组件加入进来时候，可以一样进行适配，具体来说：
 * 1 复用第三方库：当集成第三方库时，这些库可能提供了不同的接口或API。适配器模式可以用来将这些不同的API转换成应用程序期望的统一接口。
 *   例如，假设你的应用需要使用多个不同的支付网关，每个网关都有自己的API，你可以为每个支付网关写一个适配器，使得它们都符合一个通用的支付接口。
 * 2 复用遗留系统：在企业级应用中，常常需要将遗留系统（Legacy Systems）与新的系统集成。适配器模式可以用来将旧的API转换成应用程序期望的统一接口。
 *   假设一个公司有一个老旧的财务系统，使用的是特定的数据库格式和数据访问接口。现在公司决定引入一个新的数据分析工具，这个工具需要从财务系统中获取数据进行分析。
 *   但是新的数据分析工具无法直接与老旧财务系统的接口进行通信。这时，可以开发一个适配器，将老旧财务系统的接口转换为新的数据分析工具能够识别的接口。
 *
 *
 * 优势：
 * 复用性强：复用旧组件或者第三方组件到新的环境中，而无需修改原有组件的代码(遵循开闭原则)，从而减少编码工作量。
 * 扩展性强：集成旧系统或者第三方系统时候，只需创建一个新的适配器类即可，符合开闭原则
 * 易用性强：适配器模式可以将复杂不兼容的接口简化为一个简单的接口给客户端使用。
 *
 */
public class Client {

    public static void main(String[] args) {
        SDCard sdCard = new SDCardImpl();
        SDAdapter sdAdapter=new SDAdapter(sdCard);
        Computer computer = new Computer(sdAdapter);
        computer.writeTypeC("Message from sdCard");
        System.out.println(computer.readTypeC());

        System.out.println("------------");

        TFCard tfCard = new TFCardImpl();
        TFAdapter tfAdapter = new TFAdapter(tfCard);
        computer = new Computer(tfAdapter);
        computer.writeTypeC("Message from tfCard");
        System.out.println(computer.readTypeC());
    }

}
