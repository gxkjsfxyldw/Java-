package tcp2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

//服务器  后端
public class server {
    public static void main(String[] args) throws IOException {

        ServerSocket server=new ServerSocket(9090);//创建端口
        Socket socket=server.accept();//等待监听客户端连接
        InputStream is=socket.getInputStream();//获取数据流

        FileOutputStream fos=new FileOutputStream(new File("1.png"));//文件输出
        byte[] buffer=new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){//不等于-1 表示没到文件底部
              fos.write(buffer,0,len);
        }

        OutputStream os =socket.getOutputStream();//通知客户端接受完毕
        os.write("接受完成，请断开连接".getBytes());

        //关闭资源
        fos.close();
        is.close();
        socket.close();
        server.close();
    }
}
