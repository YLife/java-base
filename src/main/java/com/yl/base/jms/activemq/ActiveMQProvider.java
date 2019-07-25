package com.yl.base.jms.activemq;

import com.yl.base.jms.AbstractJMSProvider;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQProvider extends AbstractJMSProvider {

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer producer;

    @Override
    public void establishConnection() throws Exception {
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER
                , ActiveMQConnectionFactory.DEFAULT_PASSWORD
                , ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
    }

    @Override
    protected void produceMessageByP2P() throws Exception {
        destination = session.createQueue("ActiveQuene");
        producer = session.createProducer(destination);
        producerMessage("Quene");
    }

    @Override
    protected void produceMessageByPS() throws Exception {
        destination = session.createTopic("ActiveTopic");
        producer = session.createProducer(destination);
        producerMessage("Topic");
    }

    private void producerMessage(String mode) throws JMSException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            TextMessage message = session.createTextMessage("我是" + mode + "消息" + i);
            producer.send(message);
            System.out.println("发送消息：" + message.getText());
            session.commit();
            Thread.sleep(1000L);
        }
    }

    public static void main(String[] args) throws Exception {
        ActiveMQProvider provider = new ActiveMQProvider();
        try {
            provider.establishConnection();
            //provider.produceMessage("P2P");
            provider.produceMessage("PS");
        } finally {
            provider.session.close();
            provider.connection.stop();
            provider.connection.close();
        }
    }
}
