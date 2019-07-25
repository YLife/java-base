package com.yl.base.jms.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSConsumer {

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER
                , ActiveMQConnectionFactory.DEFAULT_PASSWORD
                , ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        try {
            Destination destination = session.createQueue("HelloActiveMQ!");
            MessageConsumer consumer = session.createConsumer(destination);
            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                if (message == null) {
                    // 防止cpu空转
                    Thread.sleep(1000L);
                    continue;
                }
                System.out.println("收到消息：" + message.getText());
            }
        } finally {
            session.close();
            connection.stop();
            connection.close();
        }
    }
}
