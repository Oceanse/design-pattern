package structuremode.flyweightpattern.demo2;

import java.util.LinkedList;

/**
 * 享元工厂: 负责管理享元对象的创建和复用。
 *
 */
class ConnectionPoolFactory {
    private final LinkedList<ConnectionFlyweight> pool = new LinkedList<>();
    private static final int MAX_POOL_SIZE = 5;

    public ConnectionPoolFactory(String url, String user, String password) {
        // 初始化连接池
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            pool.add(new ConnectionFlyweight(url, user, password));
        }
    }

    // 获取共享连接
    public synchronized ConnectionFlyweight getConnection() {
        if (pool.isEmpty()) {
            throw new RuntimeException("No available connection in the pool.");
        }
        return pool.removeFirst();
    }

    // 释放连接
    public synchronized void releaseConnection(ConnectionFlyweight connection) {
        pool.addLast(connection);
    }
}
