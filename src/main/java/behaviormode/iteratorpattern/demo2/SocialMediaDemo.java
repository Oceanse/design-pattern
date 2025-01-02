package behaviormode.iteratorpattern.demo2;


/**
 * 假设我们正在开发一个社交媒体平台，该平台允许用户关注其他用户，并且可以查看他们所关注用户的动态（例如发布的帖子）。
 * 我们使用迭代器模式来遍历一个用户的粉丝列表和动态列表户，并且不暴露底层的数据结构(不需要知道用户粉丝以及帖子列表是如何具体实现的)
 *
 * 不同的遍历方式：当集合需要提供多种遍历方式时，迭代器模式可以提供多种不同的迭代器实现。
 * UserIterator：这是用户迭代器的具体实现，它能够遍历用户列表。
 * PostIterator：这是帖子迭代器的具体实现，它能够遍历帖子列表。
 *
 */
public class SocialMediaDemo {
    public static void main(String[] args) {
        // 创建用户 user1 user2 user3 user4
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");
        User user4=new User("Ocean");

        // user1 user2 user3 添加动态
        user1.addPost(new Post("Hello World!"));
        user2.addPost(new Post("Good Morning!"));
        user3.addPost(new Post("How are you?"));
        user4.addPost(new Post("Reborn"));
        user4.addPost(new Post("Come back"));

        //user1 user2 user3 关注 user4
        user4.addFollower(user1);
        user4.addFollower(user2);
        user4.addFollower(user3);

        // 获取用户迭代器
        Iterator<User> iterator = user4.createFollowersIterator();
        System.out.println("获取粉丝及其动态：");
        // 遍历关注列表及其动态
        while (iterator.hasNext()) {
            User currentUser = iterator.next();
            Post latestPost = currentUser.getLatestPost();
            if (latestPost != null) {
                System.out.println(currentUser.getName() + "'s latest post: " + latestPost.getContent());
            } else {
                System.out.println(currentUser.getName() + " has no posts yet.");
            }
        }


        // 获取帖子迭代器
        System.out.println("\n获取当前用户动态：");
        Iterator<Post> postsIterator = user4.createPostsIterator();
        // 遍历关注列表及其动态
        while (postsIterator.hasNext()) {
            Post post = postsIterator.next();
            System.out.println(post.getContent());
        }


    }
}