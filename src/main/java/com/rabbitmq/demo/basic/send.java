package com.rabbitmq.demo.basic;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luoc
 * 1，使用阿里云的时候必须去网页打开端口
 * 2,ping 域名是否可以接受数据
 * 3，端口不通时首先检查端口问题
 *  telnet 192.168.198.100 5672
 *  Trying 192.168.198.100...
 *  Connected to 192.168.198.100.
 *
 */
@Slf4j
public class send {
     private final  static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
         ConnectionFactory factory = new ConnectionFactory();
        /* factory.setUsername("test");
         factory.setPassword("test");*/
         factory.setHost("39.108.251.121");
         factory.setPort(5672);
         try {
             // 建立链接
             Connection connection = factory.newConnection();
             // 创建管道
             Channel channel = connection.createChannel();
             // 创建队列
             channel.queueDeclare(QUEUE_NAME,false,false,false,null);
             String message = "hello World";
             channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));
             System.out.println("[X] Sent '" + message + "'");
         }catch (Exception e){
            log.error("Exception:{}",e);
         }
    }
}
