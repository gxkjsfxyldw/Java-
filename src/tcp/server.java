package tcp;

import javax.naming.ldap.SortKey;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

//服务端
//后端后台
public class server {
    public static void main(String[] args)  {
        ServerSocket server=null;
        Socket socket=null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;

        try {
            //1 创建地址
            server =new ServerSocket(8090);
            //2 等待客户端连接
            socket= server.accept();
            //读取客户端的消息
            is =socket.getInputStream();
            //管道流 写法
            baos =new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
             /*
            老式写法
            byte [] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){ //读取到文件末尾
                String msg=new String(buffer,0,len); //转换成string 字符时会有有问题
                System.out.println(msg);
            }
             */

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(baos!=null){
                try {
                    baos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                }catch (IOException e){
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
            if(server!=null){
                try {
                    server.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
