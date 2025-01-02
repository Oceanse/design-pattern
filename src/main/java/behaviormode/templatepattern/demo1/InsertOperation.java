package behaviormode.templatepattern.demo1;

/**
 * 插入操作类InsertOperation
 */
public class InsertOperation extends DatabaseOperation {

    @Override
    protected void connect() {
        log("连接到数据库进行插入操作。");
    }

    @Override
    protected void executeSQL() {
        log("执行插入 SQL 语句。");
    }

    @Override
    protected void processResult() {
        log("处理插入结果。");
    }

    @Override
    protected void disconnect() {
        log("断开与数据库的连接。");
    }
}