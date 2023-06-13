package createmode.prototypepattern.demo6;

import java.io.*;

/**
 * 深拷贝方式2： 序列化
 * 在Java语言中，如果需要实现深克隆，可以通过序列化(Serialization)等方式来实现。
 * 通过序列化实现的拷贝不仅可以复制对象本身，而且可以复制其引用的成员对象，因此通过序列化将对象写到一个流中，
 * 再从流里将其读出来，可以实现深克隆。需要注意的是能够实现序列化的对象其类必须实现Serializable接口，
 */
public class WeeklyLog implements Serializable {
    private  Attachment attachment;
    private  String name;
    private  String date;
    private  String content;
    public  void setAttachment(Attachment attachment) {
        this.attachment  = attachment;
    }
    public  void setName(String name) {
        this.name  = name;
    }
    public  void setDate(String date) {
        this.date  = date;
    }
    public  void setContent(String content) {
        this.content  = content;
    }
    public  Attachment getAttachment(){
        return  (this.attachment);
    }
    public  String getName() {
        return  (this.name);
    }
    public  String getDate() {
        return  (this.date);
    }
    public  String getContent() {
        return  (this.content);
    }

    /**
     * 使用序列化技术实现深拷贝
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {

        //将对象写入流中
        ByteArrayOutputStream bao=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis=new  ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois=new  ObjectInputStream(bis);
        return (WeeklyLog)ois.readObject();
    }
}
//附件类
class  Attachment implements Serializable
{
    private  String name; //附件名
    public  void setName(String name)
    {
        this.name  = name;
    }
    public  String getName()
    {
        return  this.name;
    }
    public void download()
    {
        System.out.println("下载附件，文件名为" + name);
    }
}