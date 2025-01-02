package structuremode.proxypattern.staticproxy.demo1;

// 代理类
public class UserServiceProxy implements UserService {
    private final UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    /**
     * 日志记录:每次添加用户时记录日志
     * 性能监控:监控方法执行的耗时。
     * 权限控制:根据用户的权限决定是否允许访问目标方法。
     */
    @Override
    public void addUser(String username) {
        if ("ADMIN".equalsIgnoreCase(username)) {
            System.out.println("Logging: Start adding user.");
            long startTime = System.currentTimeMillis();
            userService.addUser(username); // 调用真实对象的方法
            long endTime = System.currentTimeMillis();
            System.out.println("Logging: Finished adding user and take " + (endTime - startTime) + " ms.");
        } else {
            System.out.println("AccessControl: Permission denied for user addition.");
        }
    }
}
