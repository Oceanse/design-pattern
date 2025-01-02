package structuremode.proxypattern.dynamicproxy.demo1;

public interface UserService {
    void addUser(String username);
}

/**
 * JDK 动态代理基于接口实现代理，目标类必须实现至少一个接口。
 */
 class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("User " + username + " added.");
    }
}
