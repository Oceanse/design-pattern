package structuremode.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理代理类在编译期就生成，而动态代理代理类则是在Java运行时动态生成。动态代理又有JDK代理和CGLib代理两种。
 * Java中提供了一个动态代理类Proxy，可以使用其创建代理对象的静态方newProxyInstance方在Java运行时获取代理对象。
 */
public class ProxyFactory {
    /**
     * newProxyInstance()方法参数说明：
     * ClassLoader loader ： 类加载器，用于加载代理类，使用真实对象的类加载器即可
     * Class<?>[] interfaces ： 真实对象所实现的接口，代理模式真实对象和代理对象实现相同的接口
     * InvocationHandler h ： 代理对象的调用处理程序
     *
     * @return
     */
    public SellTickets getProxyObject() {

        //目标对象
        TrainStation trainStation = new TrainStation();

        //生成代理对象
        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                      InvocationHandler中invoke方法参数说明：
                          proxy ： 代理对象，就是上面返回的proxyInstance，两个是同一个对象，在invoke方法中可以不用处理
                          method ： 对应于在代理对象上调用的接口方法的 Method 实例
                          args ： 代理对象调用接口方法时传递的实际参数
                   */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理点收取一些服务费用(JDK动态代理方式)");
                        //执行真实对象
                        Object result = method.invoke(trainStation, args);
                        return result;
                    }
                }
        );
        return proxyInstance;
    }
}
