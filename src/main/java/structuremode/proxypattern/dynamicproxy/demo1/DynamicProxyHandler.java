package structuremode.proxypattern.dynamicproxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建动态代理处理器
 */
public class DynamicProxyHandler implements InvocationHandler {
    private final Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    /**
     * proxy ： 代理对象，通常情况下在 invoke 方法内部不需要直接使用这个代理对象，但它可以用来获取关于代理对象的信息，比如类名等。
     * method ： 表示被调用的目标方法，如果调用的是 addUser(String username)，那么对应的就是addUser(String username)的Method 对象。
     * args ： 目标方法调用时传递的实际参数。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logging: Before calling " + method.getName());
        Object result = method.invoke(target, args); // 调用目标对象的方法
        System.out.println("Logging: After calling " + method.getName());
        return result;
    }
}

