package com.yl.base.jms.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JMSListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        int count = 0;
        try {
            // 重发次数
            count = textMessage.getIntProperty("JMSXDeliveryCount");
            System.out.println(textMessage.getText());
            System.out.println("do business...");
            // 客户端手动确认消费成功
            message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
            // 最多重发10次
            if (count < 10) {
                throw new RuntimeException(e);
            }
            try {
                // 客户端手动确认消费成功
                message.acknowledge();
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
        }
    }
}
