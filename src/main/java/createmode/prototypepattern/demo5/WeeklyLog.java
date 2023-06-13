package createmode.prototypepattern.demo5;

import java.util.Comparator;

/**
 * 深拷贝方式1：
 * 原型对象和克隆对象彻底相互独立
 * 原型周报对象和克隆周报对象的attachment指向不同的附件对象
 */
public class WeeklyLog implements Cloneable{
    //为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含多个附件，可以通过List等集合对象来实现
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return (this.attachment);
    }

    public String getName() {
        return (this.name);
    }

    public String getDate() {
        return (this.date);
    }

    public String getContent() {
        return (this.content);
    }

    //使用clone()方法实现浅克隆
    public WeeklyLog clone() {
        WeeklyLog obj = null;
        try {
            obj = (WeeklyLog) super.clone();
            Attachment attachmentClone=(Attachment)this.attachment.clone();
            obj.setAttachment(attachmentClone);
            return obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }
}

//附件类
class Attachment implements Cloneable {
    private String name; //附件名

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void download() {
        System.out.println("下载附件，文件名为" + name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
