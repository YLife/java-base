package com.yl.base.jms;

public interface JMSConsumer extends JMSClient {

    /**
     * @Function: com.yl.base.jms.JMSProvider::consumeMessage
     * @description 消费消息
     *@param mode 模式
     *
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/7/25 21:08
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/7/25      yanglun            v1.0.0              修改原因
     */
    void consumeMessage(String mode) throws Exception;
}
