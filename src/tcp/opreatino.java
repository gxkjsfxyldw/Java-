package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class opreatino {

    public static void main(String[] args) {
        //客户端  前端

        Socket socket= null;
        OutputStream os=null;
    try {
        InetAddress serverip=InetAddress.getByName("127.0.0.1");//连接服务器地址
        int port=8090;//连接服务器端口
        socket=new Socket(serverip,port);//创建socket连接
        os=socket.getOutputStream();//创建数据流
        os.write("hello world".getBytes());//发送数据流

    } catch (Exception e) {
        e.printStackTrace();
    }finally {//下面都是一些关闭的异常捕获
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
