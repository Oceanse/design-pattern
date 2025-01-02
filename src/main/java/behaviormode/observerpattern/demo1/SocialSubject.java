package behaviormode.observerpattern.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题接口，代表被观察者，这里可以是发布动态的用户主体
 */
public interface SocialSubject {

    /**
     * 注册观察者，即添加关注者
     */
    void registerFollower(SocialObserver observer);

    /**
     * 移除观察者，即取消关注
     */
    void removeFollower(SocialObserver observer);

    /**
     * 通知观察者，即发布新动态时通知关注者
     */
    void notifyFollowers(Post post);
}

/**
 * 具体主题实现类，代表用户发布动态的主体
 */
class User implements SocialSubject {
    private String name;
    // 关注者列表
    private List<SocialObserver> followers;

    //帖子列表
    private List<Post> posts;

    public User(String name) {
        this.name = name;
        followers = new ArrayList<>();
        posts = new ArrayList<>();
    }

    @Override
    public void registerFollower(SocialObserver observer) {
        followers.add(observer);
    }

    @Override
    public void removeFollower(SocialObserver observer) {
        followers.remove(observer);
    }

    @Override
    public void notifyFollowers(Post post) {
        for (SocialObserver follower : followers) {
            follower.update(name,post);
        }
    }

    // 用户发布新动态的方法
    public void post(String content) {
        Post newPost = new Post(content);
        posts.add(newPost);
        System.out.println(name + " posted: " + newPost.getContent());
        notifyFollowers(newPost);
    }

    public String getName() {
        return name;
    }

}