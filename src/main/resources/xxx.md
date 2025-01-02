在设计模式的学习中，大家经常会看到诸如“XXX模式符合XXX原则”、“XXX模式违反了XXX原则”这样的语句。  
面向对象设计原则是一组指导方针，用于指导如何设计类、接口和其他组件，以确保代码具有良好的结构和质量。这些原则强调了诸如高内聚性、低耦合性、易于扩展和修改等特性。 
设计模式是针对特定问题的解决方案模板，它描述了在某些情况下如何解决问题的最佳实践。设计模式通常是在遵循面向对象设计原则的基础上形成的，并且可以被视为具体实现这些原则的方式。

### 单一职责原则
单一职责原则强调一个模块只负责一项功能(一个类只做一件事)，目标是确保代码的高内聚性和低耦合性  
**不符合单一职责原则的设计示例**
```
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // 用户信息相关方法
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 数据库操作
    public void saveToDatabase() {
        // 保存用户到数据库的逻辑
    }

    // 发送邮件
    public void sendWelcomeEmail() {
        // 发送欢迎邮件的逻辑
    }
}
```
在这个设计中，User 类承担了多个职责：管理用户信息、执行数据库操作和发送邮件。这违反了SRP，因为如果任何一个职责发生变化，
比如数据库结构改变或者邮件服务提供商更新API，我们就不得不修改 User 类，增加了出错的风险。  

**符合单一职责原则的设计示例**
```
// 用户信息管理类
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// 数据库操作类
class UserRepository {
    public void save(User user) {
        // 保存用户到数据库的逻辑
    }
}

// 邮件发送类
class EmailService {
    public void sendWelcomeEmail(User user) {
        // 发送欢迎邮件的逻辑
    }
}
```
在这个改进后的设计中：  
User 类只负责管理用户信息。  
UserRepository 类负责与数据库交互，保存用户数据。  
EmailService 类负责发送邮件   
通过这种方式，每个类都有明确的职责，并且如果某个特定功能需要更改，我们只需要修改相应的类，而不会影响其他部分。这正是单一职责原则所追求的效果——使代码更加清晰、稳定和易于维护。
###开闭原则

### 开闭原则
开闭原则（Open/Closed Principle, OCP）强调软件实体（如类、模块、函数等）应该对扩展开放（Open for extension），对修改关闭（Closed for modification）。  
这意味着我们应该能够通过添加新的功能来扩展一个实体的行为，而无需修改现有代码。这样做可以减少由于修改现有代码而导致的错误风险，并且有助于可维护性和可扩展性。


### 合成复用原则
合成复用原则（Composite Reuse Principle，CRP）也叫组合 / 聚合复用原则。  
在软件设计中，尽量使用 对象组合（Composition） 和 聚合（Aggregation） 来实现代码复用，而不是通过类的继承。
继承是一种紧耦合的关系，可能会导致代码的维护困难，而组合和聚合是一种松耦合的关系，更灵活且可扩展。  
```
// 定义接口：为功能模块解耦
interface Engine {
    void start();
}

//电动发动机
class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine starting");
    }
}

//燃油发动机
class CombustionEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Combustion engine starting");
    }
}


// 定义 Car 类，组合一个 Engine 对象
class Car {
    //这里也体现了里氏代换原则，出现父类的地方可以由子类替换；
    //这里也体现了依赖倒转原则,高层模块（Car）依赖抽象层(Engine)
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

// 测试代码
public class Main {
    public static void main(String[] args) {
        Car electricCar = new Car(new ElectricEngine());
        electricCar.drive();

        Car combustionCar = new Car(new CombustionEngine());
        combustionCar.drive();
    }
}

```


### 里氏代换原则
里氏代换原则（Liskov Substitution Principle, LSP）强调父类对象可以被其子类替换，程序将不会产生任何错误和异常；  也就是子类对象必须能够替换掉所有使用基类对象的地方，而不会导致程序出现错误或者不符合预期的行为。
由于使用基类对象的地方都可以使用子类对象，因此在程序中尽量使用基类类型来对对象进行定义，而在运行时再确定其子类类型，用子类对象来替换父类对象。  
在定义成员变量/局部变量、传递参数、确定方法返回类型时都可使用里氏代换原则。针对基类编程，在程序运行时再确定具体子类。  
在遵循里氏代换原则的情况下，子类可以扩展父类的行为，但不能破坏父类原有的行为  
优点：扩展性好，支持开闭原则
**错误示例：违反里氏代换原则的例子**
```
// 基类 Shape
abstract class Shape {
    public abstract double area();
}

// 子类 Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    // 违反LSP的方法 - 设置宽度会影响高度
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

// 子类 Square
class Square extends Rectangle {
    public Square(double size) {
        super(size, size);
    }

    @Override
    public void setWidth(double size) {
        super.setWidth(size);
        super.setHeight(size);  // 强化了前置条件
    }

    @Override
    public void setHeight(double size) {
        super.setWidth(size);
        super.setHeight(size);  // 强化了前置条件
    }
}
```
在这个例子中，Square类继承自Rectangle，并且重写了setWidth和setHeight方法以确保宽度和高度总是相等。  
如果用子类Square替换Rectangle，会违反了LSP，**因为子类Square改变了父类Rectangle的预期行为，即设置宽度或高度时不会影响另一个维度**。

**正确示例： 符合里氏代换原则**
```
// 基类 Shape
abstract class Shape {
    public abstract double area();
}

// 独立的 Rectangle 类
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

// 独立的 Square 类
class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}

public class AreaCalculator {
    public static double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(4, 5));
        shapes.add(new Square(3));

        System.out.println("Total Area: " + calculateTotalArea(shapes));
    }
}
```
通过这种方式，我们确保了任何可以接受Shape的地方都可以接受Rectangle或Square，并且程序的行为不会因此发生变化。这正是里氏代换原则所追求的目标。  


### 依赖倒转原则
基本概念：  
高层模块：通常是指系统中的业务逻辑或核心功能部分。  
低层模块：指实现细节部分，如数据库操作、文件读写等。  
抽象：可以是接口或抽象类，定义了高层模块和低层模块之间的契约。  

在传统的编程实践中，高层次模块通常直接依赖于低层次模块的具体实现。然而，DIP建议我们打破这种常规，让高层次模块和低层次模块都依赖于抽象，而不是彼此直接依赖。  
依赖倒转原则的目标是通过依赖抽象，而非具体实现，来实现高层模块和低层模块的解耦
核心思想:  
1 高层模块（调用者）不应该直接依赖于具体实现（低层模块），而是通过抽象（接口或抽象类）进行交互。  
2 依赖于接口，而不是实现，通过接口解耦高层模块和低层模块之间的关系。  
**违背依赖倒转原则示例**
```
//低层模块1
class EmailNotification {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

//低层模块2
class SMSNotification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// 高层模块
class NotificationService {
    
    // 高层模块依赖低层模块
    private EmailNotification emailNotification = new EmailNotification();
    private SMSNotification smsNotification = new SMSNotification();

    public void sendEmail(String message) {
        emailNotification.send(message);
    }

    public void sendSMS(String message) {
        smsNotification.send(message);
    }
}
```
问题分析 ：  
1 高层模块（NotificationService）依赖低层模块（EmailNotification，SMSNotification）  
2 扩展性差：增加通知类型时候需要修改NotificationService，不符合开闭原则

**符合依赖倒转原则示例**
```
// 抽象接口
interface Notification {
    void send(String message);
}

// 具体实现（低层模块1）
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

// 具体实现（低层模块2）
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// 高层模块
class NotificationService {
    private Notification notification;  // 高层模块依赖抽象层

    // 构造函数注入
    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void sendMessage(String message) {
        notification.send(message);
    }
}
```
高层模块NotificationService 依赖于 抽象Notification 接口，而不是具体的实现类。  
在上述重构过程中，我们使用了开闭原则、里氏代换原则和依赖倒转原则，在大多数情况下，这三个设计原则会同时出现，
开闭原则是目标，里氏代换原则是基础，依赖倒转原则是手段，它们相辅相成，相互补充，目标一致，只是分析问题时所站角度不同而已。



### 迪米特法则
迪米特法则（Law of Demeter, LoD），也被称为“最少知道原则”（Principle of Least Knowledge）  
它强调一个软件实体应当尽可能少地与其他实体发生相互作用，即只与它的“朋友”交谈，而不与“陌生人”交谈,确保它们之间的依赖关系最小化  
在迪米特法则中，“**朋友**”指的是：  
当前对象本身。   
被当前对象直接创建的对象。  
当前对象的方法参数。  
当前对象的成员变量。  
当前对象的成员变量调用的返回值。  
非“朋友”的对象，当前对象不应该直接调用其方法或访问其数据。  

**错误示例：违反迪米特法则的例子**  
```
class Engine {
    public void start() {
        System.out.println("Engine starts");
    }
}

class Car {
    private Engine engine = new Engine();

    public Engine getEngine() {
        return engine;
    }
}

class Driver {
    public void drive(Car car) {
        car.getEngine().start(); // Driver直接与Engine交互
    }
}

```
在示例中，Driver 的朋友是 Car。这是因为 Car 是 Driver 的方法参数，而方法参数在迪米特法则中被视为“朋友”。
Driver 直接访问了 Car 的内部细节（Engine 对象），这违反了迪米特法则。  


**正确示例： 符合迪米特法则的例子**
```
class Engine {
    public void start() {
        System.out.println("Engine starts");
    }
}

class Car {
    private Engine engine = new Engine();

    public void startEngine() { // 提供对Engine的间接访问
        engine.start();
    }
}

class Driver {
    public void drive(Car car) {
        car.startEngine(); // 只与Car交互，减少对Engine的了解
    }
}
```
Driver 只与 Car 交互，减少了对 Engine 的了解，符合迪米特法则。  
**优点**  
降低对象之间的耦合度。  
提高系统的可维护性和扩展性。  
增强代码的健壮性，减少因对象内部结构变化导致的连锁反应。  

### 接口隔离原则
接口隔离原则（Interface Segregation Principle, ISP）强调客户端不应该被迫依赖于它们不使用的接口。换句话说，一个类不应该实现它不需要的方法。  
ISP提倡将大而全的接口拆分为小而精的接口，使得每个接口只包含一组紧密相关的操作，客户端只依赖它们真正需要的接口
“隔离” 更强调通过设计使得不同职责的接口之间有清晰的界限(每个接口只包含特定的、紧密相关的方法)，让客户端和接口之间的依赖关系更加合理和健壮。
假设一个餐厅提供菜单服务：
如果餐厅给每位顾客一张包含所有菜品和饮品的“大菜单”，很多顾客可能只对其中部分内容感兴趣，其他内容对他们是“冗余”的。
如果餐厅将菜单分为“素食菜单”“饮品菜单”“甜点菜单”等，顾客就可以根据自己的需求选择对应的菜单。
这里的“菜单”可以类比为“接口”，“分菜单”就是对接口的隔离。
**错误示例：违背接口隔离原则的例子**
```
interface Animal {
    void eat();
    void run();
    void fly();
}

class Bird implements Animal {
    @Override
    public void eat() {
        System.out.println("Bird eats seeds");
    }

    @Override
    public void run() {
        System.out.println("Bird hops around");
    }

    @Override
    public void fly() {
        System.out.println("Bird flies in the sky");
    }
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }

    @Override
    public void run() {
        System.out.println("Dog runs fast");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dog can't fly");
    }
}
```
Dog 类不需要 fly 方法，却被强制实现，这违背了接口隔离原则。  
添加新功能时可能会对所有实现类造成影响。


**正确示例：遵循接口隔离原则的例子**
```
interface Eatable {
    void eat();
}

interface Runnable {
    void run();
}

interface Flyable {
    void fly();
}


class Bird implements Eatable, Runnable, Flyable {
    @Override
    public void eat() {
        System.out.println("Bird eats seeds");
    }

    @Override
    public void run() {
        System.out.println("Bird hops around");
    }

    @Override
    public void fly() {
        System.out.println("Bird flies in the sky");
    }
}

class Dog implements Eatable, Runnable {
    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }

    @Override
    public void run() {
        System.out.println("Dog runs fast");
    }
}

```
将 Animal 接口拆分为多个独立的小接口，每个接口只关注一种能力，子类根据实际需要实现了相应的接口。