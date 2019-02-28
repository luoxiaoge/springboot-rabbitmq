package com.rabbitmq.demo;

import com.rabbitmq.demo.springbootAck.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

}
