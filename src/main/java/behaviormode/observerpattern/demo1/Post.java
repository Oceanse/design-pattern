package behaviormode.observerpattern.demo1;

import java.util.Date;

public class Post {
    private String content;
    private String timestamp;

    public Post(String content) {
        this.content = content;
        this.timestamp = new Date().toString();
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}