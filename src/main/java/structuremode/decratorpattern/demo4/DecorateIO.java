package structuremode.decratorpattern.demo4;

import org.testng.annotations.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DecorateIO {

    /**
     * BufferedInputStream 和 BufferedOutputStream：它们是对基本输入流和输出流的装饰，通过缓冲机制提高读写效率
     *
     * @throws IOException
     */
    @Test
    public void testBufferedStream() throws IOException {
        // 基础的文件输入流
        FileInputStream fileInputStream = new FileInputStream("input.txt");

        // 使用装饰者模式添加缓冲功能
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        // 基础的文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        // 使用装饰者模式添加缓冲功能
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        // 读取和写入数据
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, bytesRead);
        }

        // 关闭流
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

    @Test
    public static String receiveMessage(String filePath) throws IOException {
        ServerSocket serverSocket=new ServerSocket(55531);
        while(true){
            System.out.println("服务端等待客户端的连接请求...");
            Socket socket = serverSocket.accept();
            System.out.println("客户端 "+socket.getRemoteSocketAddress()+" 连接成功");
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(inputStream)));
            String message;
            if ((message=bufferedReader.readLine())!=null){
                System.out.println("服务端收到消息： "+message);
            }
        }
    }
}
