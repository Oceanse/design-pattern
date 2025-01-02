package structuremode.proxypattern.dynamicproxy.demo2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample {
    public static void main(String[] args) {
        // 创建目标对象
        UserService target = new UserService();

        // 设置 Enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class); // 指示 Enhancer 生成一个继承自 UserService 的代理类。
        enhancer.setCallback(new UserServiceInterceptor(target)); // 设置拦截器

        // 创建代理对象:会基于目标类生成一个子类
        UserService proxy = (UserService) enhancer.create();

        // 调用代理方法，最终会触发了 MyMethodInterceptor 中的 intercept 方法
        proxy.addUser("Alice");
    }
}




// 动态生成的代理类，直接继承目标类 UserService
 class UserService$$EnhancerByCGLIB$$f47b8c3 extends UserService {

    // MethodInterceptor 回调对象
    private MethodInterceptor callback;

    // 代理类构造函数
    public UserService$$EnhancerByCGLIB$$f47b8c3(MethodInterceptor callback) {
        super();
        this.callback = callback;
    }

    // 重写目标方法 addUser
    @Override
    public void addUser(String name) {
        try {
        // 在这里调用 MethodInterceptor 的 intercept 方法来进行方法拦截
        Method method = UserService.class.getDeclaredMethod("addUser", String.class); // 获取目标方法
            // 使用 MethodProxy 调用目标方法，同时执行拦截器的增强逻辑
            callback.intercept(this, method, new Object[]{name}, MethodProxy.create(UserService.class, getClass(), "addUser", null,null));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
