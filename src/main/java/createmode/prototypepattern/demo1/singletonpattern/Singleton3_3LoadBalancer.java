package createmode.prototypepattern.demo1.singletonpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 懒汉式单例类在第一次使用时创建，无须一直占用系统资源，实现了延迟加载，但是必须处理好多个线程同时访问的问题，
 * 特别是当单例类作为资源控制器，在实例化时必然涉及资源初始化，而资源初始化很有可能耗费大量时间，这意味着出现多线程
 * 同时首次引用此类的机率变得较大，需要通过双重检查锁定等机制进行控制，这将导致系统性能受到一定影响。
 */
public class Singleton3_3LoadBalancer {

    //私有静态成员变量，存储唯一实例
    private static volatile Singleton3_3LoadBalancer instance = null;

    //服务器集合
    private List serverList = null;

    //私有构造函数
    private Singleton3_3LoadBalancer() {
        serverList = new ArrayList();
    }

    //公有静态成员方法，返回唯一实例
    public static Singleton3_3LoadBalancer getLoadBalancer() {
        if (instance == null) {
            synchronized (Singleton3_3LoadBalancer.class) {
                if (instance == null) {
                    instance = new Singleton3_3LoadBalancer();
                    //初始化。。。
                }
            }
        }
        return instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }
    //删除服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }
    //使用Random类随机获取服务器
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String)serverList.get(i);
    }
}

class Client {
    public static void main(String args[]) {
        //创建四个LoadBalancer对象
        Singleton3_3LoadBalancer balancer1,balancer2,balancer3,balancer4;
        balancer1 = Singleton3_3LoadBalancer.getLoadBalancer();
        balancer2 = Singleton3_3LoadBalancer.getLoadBalancer();
        balancer3 = Singleton3_3LoadBalancer.getLoadBalancer();
        balancer4 = Singleton3_3LoadBalancer.getLoadBalancer();
        //判断服务器负载均衡器是否相同
        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }
        //增加服务器
        balancer1.addServer("Server 1");
        balancer1.addServer("Server 2");
        balancer1.addServer("Server 3");
        balancer1.addServer("Server 4");
        //模拟客户端请求的分发
        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求至服务器： " + server);
        }
    }
}
