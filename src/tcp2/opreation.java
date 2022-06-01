package tcp2;

import javax.naming.ldap.SortKey;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

//前端 客户端
public class opreation {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);//创建socket网络连接
        OutputStream os=socket.getOutputStream();//创建输出流

        FileInputStream fis=new FileInputStream(new File("0.png"));//读取文件
        byte[] buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){//写出文件
            os.write(buffer,0,len);
        }

        socket.shutdownInput(); //通知服务器，完成连接，传输完毕
        InputStream inputStream= socket.getInputStream();//确认服务器接受完毕，才能断开连接
        //String byte[]
        ByteArrayOutputStream baos=new ByteArrayOutputStream();

        byte[] buffers=new byte[1024];
        int lens;
        while((lens=inputStream.read(buffers))!=-1){
            os.write(buffers,0,lens);
        }
        System.out.println(baos.toString());

        //关闭资源
        baos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }
}
