package behaviormode.iteratorpattern.demo2;

/**
 * 用户发布的动态帖子类
 */
public class Post {
    private String content;

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}

