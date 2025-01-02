package behaviormode.templatepattern.demo1;

/**
 * 查询操作类SelectOperation：
 */
public class SelectOperation extends DatabaseOperation {

    @Override
    protected void connect() {
        log("连接到数据库进行查询操作。");
    }

    @Override
    protected void executeSQL() {
        log("执行查询 SQL 语句。");
    }

    @Override
    protected void processResult() {
        log("处理查询结果。");
    }

    @Override
    protected void disconnect() {
        log("断开与数据库的连接。");
    }
}