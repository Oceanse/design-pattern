package structuremode.flyweightpattern.demo2;

/**
 * 客户端代码: 使用享元模式来实现数据库查询
 *
 */
public class FlyweightConnectionPoolExample {
    public static void main(String[] args) {
        // 创建连接池工厂
        ConnectionPoolFactory factory = new ConnectionPoolFactory(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "password"
        );

        try {
            // 获取连接并执行查询
            ConnectionFlyweight connection1 = factory.getConnection();
            connection1.executeQuery("SELECT * FROM users WHERE id = ?", new Object[]{1});
            connection1.executeQuery("SELECT * FROM products WHERE price > ?", new Object[]{100.0});

            // 释放连接
            factory.releaseConnection(connection1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

