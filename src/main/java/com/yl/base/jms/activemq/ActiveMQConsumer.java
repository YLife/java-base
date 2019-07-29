package com.yl.base.jms.activemq;

import com.yl.base.jms.AbstractJMSConsumer;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQConsumer extends AbstractJMSConsumer {

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageConsumer consumer;
    private TopicSubscriber subscriber;

    @Override
    public void establishConnection() throws Exception {
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER
                , ActiveMQConnectionFactory.DEFAULT_PASSWORD
                , ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        //connection.setClientID("007");
        connection.start();
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        //session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
    }

    @Override
    protected void consumeMessageByP2P() throws Exception {
        destination = session.createQueue("ActiveQuene");
        consumer = session.createConsumer(destination);
        receiveMessage();
    }

    @Override
    protected void consumeMessageByPS() throws Exception {
        destination = session.createTopic("ActiveTopic");
        consumer = session.createConsumer(destination);
        receiveMessage();
    }

    private void consumeMessageByListener() throws Exception{
        subscriber = session.createDurableSubscriber(session.createTopic("ActiveTopic"), "test-durable");
        subscriber.setMessageListener(new JMSListener());
    }

    private void receiveMessage() throws Exception {
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            if (message == null) {
                // 防止CPU空转
                Thread.sleep(1000L);
                continue;
            }
            session.commit();
            System.out.println("收到消息：" + message.getText());
        }
    }

    public static void main(String[] args) throws Exception {
        ActiveMQConsumer consumer = new ActiveMQConsumer();
        try {
            consumer.establishConnection();
            consumer.consumeMessage("P2P");
            //consumer.consumeMessage("PS");
            //consumer.consumeMessageByListener();
        } finally {
            //consumer.session.close();
            //consumer.connection.stop();
            //consumer.connection.close();
        }
    }
}
