package behaviormode.iteratorpattern.demo2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 聚合对象：用户类
 *
 * CopyOnWriteArrayList
 * 内部使用了 CopyOnWriteArrayList 作为线程安全的数据结构，每次向 CopyOnWriteArrayList 中添加或删除元素时，都会创建一个新的数组，并将旧数组的内容复制到新数组中，然后在新数组中进行修改
 * 因此在多线程环境下，迭代器在创建时获取了一个快照，即使有其他线程在遍历过程中修改了用户列表，也不会影响当前线程的迭代过程，迭代器也不会抛出 ConcurrentModificationException
 * 但是迭代器继续遍历的是创建时的列表版本，而不是最新的版本。
 * 总的来说，CopyOnWriteArrayList 在读多写少的场景下非常适合，因为它提供了线程安全的迭代器，但在写操作频繁的情况下，需要权衡其带来的性能和内存开销。
 * 每次修改都会创建一个新的数组，这可能会导致较大的内存开销。因此，在操作非常频繁的场景下，使用 CopyOnWriteArrayList 可能不是最佳选择。
 * 总的来说，CopyOnWriteArrayList 在读多写少的场景下非常适合，因为它提供了线程安全的迭代器，但在写操作频繁的情况下，需要权衡其带来的性能和内存开销。
 */
public class User {
    private String name;
    private CopyOnWriteArrayList<Post> posts;
    private CopyOnWriteArrayList<User> followers;

    public User(String name) {
        this.name = name;
        this.posts = new CopyOnWriteArrayList<>();
        this.followers=new CopyOnWriteArrayList<>();
    }

    //发布动态
    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post){
        posts.remove(post);
    }

    //关注
    public void addFollower(User follower) {
        followers.add(follower);
    }

    //取消关注
    public void removeFollower(User follower) {
        followers.remove(follower);
    }

    //获取粉丝列表
    public List<User> getFollowers() {
        return followers;
    }

    public List<Post> getPosts() {
        return posts;
    }
    //获取最新动态

    public Post getLatestPost() {
        if (!posts.isEmpty()) {
            return posts.get(posts.size() - 1);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    //创建用户迭代器
    public Iterator createFollowersIterator() {
        return new UserIterator(followers);
    }

    //创建帖子迭代器
    public Iterator createPostsIterator() {
        return new PostIterator(posts);
    }


    //创建帖子迭代器
    public Iterator createPostsIterator2() {
        return new PostIterator(posts);
    }

}
