package structuremode.proxypattern.dynamicproxy.demo2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceInterceptor implements MethodInterceptor {
    private final Object target;

    public UserServiceInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 可以添加前置和后置处理逻辑
     * @param obj 增强后的代理对象
     * @param method 当前被调用的方法对象。
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before method: " + method.getName());
        // 调用目标类的方法
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}

