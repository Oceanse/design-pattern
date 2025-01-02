package behaviormode.mediatorpattern.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者接口
 */
public interface ChatMediator {
    void sendMessage(String message, User sender, User receiver);
    void addUser(User user);
}

/**
 * 聊天室充当中介者角色
 */
class ChatRoom implements ChatMediator {

    //群成员
    private List<User> users = new ArrayList<>();

    //聊天服务器转发消息
    @Override
    public void sendMessage(String message, User sender, User receiver) {
        //私聊消息
        if (receiver != null) {
            receiver.receive(message);
        } else {  //群聊消息
                for (User recipient : users) {
                    if (recipient != sender) {//转发给除了自己之外的群成员
                        recipient.receive(message);
                    }
                }
            }
        }

    //加入到群聊
    @Override
    public void addUser(User user) {
        users.add(user);
    }


}
