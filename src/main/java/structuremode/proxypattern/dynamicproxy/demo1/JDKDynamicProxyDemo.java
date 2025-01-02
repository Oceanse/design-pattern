package structuremode.proxypattern.dynamicproxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * JDK 动态代理是一种在运行时动态生成代理类的技术，依赖 Java 的反射机制。
 * 运行时生成：Proxy.newProxyInstance 会在运行时动态生成代理类字节码，无需提前编写代理类代码。
 * 基于接口：目标类必须实现接口，代理类会动态实现这些接口。
 * 功能增强：可以在方法调用前后动态添加逻辑（如日志、权限验证、事务处理）。
 *
 * 缺点：
 * 仅支持接口代理：如果目标类未实现接口，JDK 动态代理无法使用。
 * 性能开销：动态生成代理类和反射调用有一定性能开销，适合轻量级增强场景。
 *
 * Spring AOP 的选择：
 * 优先使用 JDK 动态代理（如果目标类实现了接口）。
 * 如果目标类没有实现接口，则使用 CGLIB 动态代理。
 *
 */
public class JDKDynamicProxyDemo {
    public static void main(String[] args) {
        // 创建真实对象
        UserService realService = new UserServiceImpl();

        /**
         * 运行时创建代理对象，该类实现了目标接口。
         * newProxyInstance()方法参数说明：
         * ClassLoader loader ： 类加载器，用于加载动态生成的代理类到内存中，使用目标对象的类加载器即可
         * Class<?>[] interfaces ： 真实对象所实现的接口，目标对象和代理对象实现相同的接口
         * InvocationHandler h ： 代理对象的调用处理程序
         *
         * @return
         */
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                realService.getClass().getInterfaces(),
                new DynamicProxyHandler(realService)
        );

        // 使用代理对象
        proxyService.addUser("Alice");
    }
}


/**
 * 运行时生成的代理类伪代码示例
 *
 * 1) 动态生成代理类
 * Proxy.newProxyInstance 方法在运行时生成一个代理类，该类实现了目标接口。代理类本质上是一个实现了目标接口的类，而不是直接继承目标类;另外代理类的所有方法定义都来自目标接口，没有接口则无法生成代理类。
 * 代理类的名称类似于 com.sun.proxy.$Proxy0。
 * 代理类的字节码是在运行时动态生成的。
 *
 * 2) 代理类的行为
 * 代理类的每个方法都会调用 InvocationHandler.invoke 方法。
 * 在 invoke 方法中，可以通过反射调用目标类的方法，并在方法前后添加自定义逻辑。
 *
 * 注：
 * 在 JDK 动态代理中，默认情况下不会将其运行时生成的代理类字节码保存到文件中，
 * 通过Proxy.newProxyInstance 方法中指定的类加载器 ClassLoader直接加载到 JVM 内存中
 *
 *
 */
class $Proxy0 implements UserService {//生成的代理类实现了目标类接口UserService
    private InvocationHandler h;

    public $Proxy0(InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void addUser(String username) {
        try {
            Method method = UserService.class.getMethod("addUser", String.class);
            h.invoke(this, method, new Object[]{username});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}