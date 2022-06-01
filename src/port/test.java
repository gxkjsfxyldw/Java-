package port;

import java.net.InetAddress;
import java.net.UnknownHostException;

//测试网络ip
public class test {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 =InetAddress.getByName("www.gxstnu.edu.cn"); //inetAddress1 表示一个ip对象
            System.out.println(inetAddress1); //查询IP地址

            InetAddress inetAddress2 =InetAddress.getLocalHost(); //
            //常用方法
            System.out.println(inetAddress2); //地址
            System.out.println(inetAddress2.getHostAddress()); //ip
            System.out.println(inetAddress2.getHostName()); //主机名

        }catch (UnknownHostException e){

            e.printStackTrace();
        }
    }

}
