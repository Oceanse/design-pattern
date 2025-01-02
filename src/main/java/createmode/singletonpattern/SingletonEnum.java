package createmode.singletonpattern;

/**
 * 优点
 * 实现简单：只需要一个枚举类型即可实现单例。
 * 线程安全：枚举类型的单例实现是线程安全的，不需要额外的同步机制，不存在指令重排序问题
 * 懒加载：枚举类型的单例对象在第一次使用时加载，实现懒加载
 * 序列化支持：枚举类型的单例自动支持序列化，可以避免反序列化时创建新的实例。
 */
public enum SingletonEnum {
    INSTANCE
}
