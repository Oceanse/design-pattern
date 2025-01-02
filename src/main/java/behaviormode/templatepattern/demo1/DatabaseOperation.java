package behaviormode.templatepattern.demo1;

/**
 * 定义抽象类DatabaseOperation：
 */
public abstract class  DatabaseOperation {

        // 模板方法，定义了数据库操作的流程
        public final void executeOperation() {
            connect();
            executeSQL();
            processResult();
            disconnect();
        }

        protected abstract void connect();

        protected abstract void executeSQL();

        protected abstract void processResult();

        protected abstract void disconnect();

        // 公共方法，可被具体子类复用
        protected void log(String message) {
            System.out.println("[Database Log]: " + message);
        }
}
