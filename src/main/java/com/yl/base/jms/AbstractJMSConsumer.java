package com.yl.base.jms;

public abstract class AbstractJMSConsumer implements JMSConsumer {

    @Override
    public void consumeMessage(String mode) throws Exception {
        if ("P2P".equals(mode)) {
            consumeMessageByP2P();
        } else {
            consumeMessageByPS();
        }
    }

    // 使用POINT TO POINT模式
    protected abstract void consumeMessageByP2P() throws Exception;

    // 使用PUBLISH-SCRIBLE模式
    protected abstract void consumeMessageByPS() throws Exception;
}
