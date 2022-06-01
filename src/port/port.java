package port;

import java.net.InetSocketAddress;

public class port {
    public static void main(String[] args) {
        InetSocketAddress socketAddress =new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress1=new InetSocketAddress("localhost",8080);
        System.out.println(socketAddress);
        System.out.println(socketAddress1);

        System.out.println(socketAddress.getAddress());//获取主机
        System.out.println(socketAddress.getHostName());//获取名字
        System.out.println(socketAddress.getPort());//获取端口

    }
}
