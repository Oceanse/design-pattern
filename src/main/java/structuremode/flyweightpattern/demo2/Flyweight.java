package structuremode.flyweightpattern.demo2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 抽象享元类：数据库连接抽象类
 * 内部状态：数据库连接对象及其固定属性。
 * 外部状态：每次查询的上下文（SQL 语句和参数）。
 * 好处：享元模式在数据库连接池中可以通过共享连接对象，减少内存和资源消耗，同时外部状态使得每个使用者能够灵活地在共享对象上执行不同操作。
 */
interface Flyweight {
    void executeQuery(String query, Object[] params);
}


/**
 * 具体享元类：数据库连接具体类
 */
class ConnectionFlyweight implements Flyweight {
    private final Connection connection; // 内部状态：固定的数据库连接

    public ConnectionFlyweight(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection.", e);
        }
    }

    @Override
    public void executeQuery(String query, Object[] params) {//外部状态：每次查询的上下文（SQL 语句和参数）
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // 设置外部状态（查询参数）
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            System.out.println("Executing query: " + statement);
            statement.executeQuery(); // 执行查询
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
