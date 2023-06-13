package createmode.prototypepattern.demo7;

import java.util.Hashtable;

/**
 * 原型管理器(Prototype Manager)是将多个原型对象存储在一个集合中，提供一个专门负责克隆对象的工厂(也就是克隆方法)，
 * 如果需要获取某个原型对象的一个克隆，可以通过工厂方法(克隆方法)来获得。获得对象的拷贝后就可以对其进行其他处理，但是
 * 不会影响"原型集合"
 * <p>
 * 下面通过模拟一个简单的公文管理器来介绍原型管理器的设计与实现： Sunny软件公司在日常办公中有许多公文需要创建、递交和审批，
 * 例如《可行性分析报告》、《立项建议书》、《软件需求规格说明书》、《项目进展报告》等，为了提高工作效率，在OA系统中为各类公文均创建了模板，
 * 用户可以通过这些模板快速创建新的公文，这些公文模板需要统一进行管理，系统根据用户请求的不同生成不同的新公文。
 */
public class PrototypeManager {
    //定义一个Hashtable，用于存储原型对象
    private Hashtable<String, OfficialDocument> ht = new Hashtable();

    //饿汉式实现单例
    private static PrototypeManager pm = new PrototypeManager();

    //为Hashtable增加公文对象
    private PrototypeManager() {
        ht.put("far", new FAR());
        ht.put("srs", new SRS());
    }

    //增加新的公文对象
    public void addOfficialDocument(String key, OfficialDocument doc) {
        ht.put(key, doc);
    }

    //通过浅克隆获取新的公文对象
    public OfficialDocument getOfficialDocument(String key) {
        return (OfficialDocument) ht.get(key).clone();
    }

    //获取单例对象
    public static PrototypeManager getPrototypeManager() {
        return pm;
    }
}
