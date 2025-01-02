package behaviormode.observerpattern.demo1;

/**
 * 观察者接口，代表关注用户动态的人
 */
public interface SocialObserver {
    /**
     * 当被观察的主体有新动态时被调用
     */
    void update(String name, Post post);
}

/**
 *  具体观察者实现类，代表关注用户的人
 */
class Follower implements SocialObserver {
    private String followerName;

    public Follower(String followerName) {
        this.followerName = followerName;
    }

    @Override
    public void update(String name, Post post) {
            System.out.println(followerName + "收到了 " + name + " 的新动态通知：" + post);
    }
}