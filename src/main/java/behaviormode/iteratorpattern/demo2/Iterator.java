package behaviormode.iteratorpattern.demo2;


import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 定义迭代器接口,可以根据需求创建不同的迭代器
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
}

/**
 * 定义具体的用户迭代器类
 */
class UserIterator implements Iterator<User> {
    private CopyOnWriteArrayList<User> users;
    private int position = 0;

    public UserIterator(CopyOnWriteArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean hasNext() {
        return position < users.size();
    }

    @Override
    public User next() {
        if (this.hasNext()) {
            User user = users.get(position);
            position++;
            return user;
        }
        return null;
    }
}

/**
 * 定义具体的帖子迭代器类
 */
class PostIterator implements Iterator<Post> {
    private CopyOnWriteArrayList<Post> posts;
    private int position = 0;

    public PostIterator(CopyOnWriteArrayList<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean hasNext() {
        return position < posts.size();
    }

    @Override
    public Post next() {
        if (this.hasNext()) {
            Post post = posts.get(position);
            position++;
            return post;
        }
        return null;
    }
}


class MyIterator<E>{
    private CopyOnWriteArrayList<E> elements;
    private int position = 0;

    public MyIterator(CopyOnWriteArrayList<E> elements) {
        this.elements = elements;
    }

    public boolean hasNext() {
        return position < elements.size();
    }

    public E next() {
        if (this.hasNext()) {
            E e = elements.get(position);
            position++;
            return e;
        }
        return null;
    }}