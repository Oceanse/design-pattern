package structuremode.proxypattern.staticproxy.demo1;

// 真实主题
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("User " + username + " added.");
    }
}

