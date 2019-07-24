package com.yl.base.jms.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer {

    public static void main(String[] args) throws JMSException, InterruptedException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER
                , ActiveMQConnectionFactory.DEFAULT_PASSWORD
                , "failover://tcp://localhost:61616");
        // 创建连接
        Connection connection = connectionFactory.createConnection();
        // 开启连接
        connection.start();
        // 创建session会话对象 param1：是否开启事务 param2：签收方式
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        // 创建destination目的地
        Destination destination = session.createQueue("HelloActiveMQ!");
        // 创建producer生产者
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 10; i++) {
            TextMessage message = session.createTextMessage("我是消息" + i);
            producer.send(message);
            System.out.println("发送消息：" + message.getText());
            session.commit();
            Thread.sleep(1000l);
        }
    }

}
