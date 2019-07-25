package com.yl.base.jms;

public abstract class AbstractJMSProvider implements JMSProvider {

    @Override
    public void produceMessage(String mode) throws Exception {
        if ("P2P".equals(mode)) {
            produceMessageByP2P();
        } else {
            produceMessageByPS();
        }
    }

    // 使用POINT TO POINT模式
    protected abstract void produceMessageByP2P() throws Exception;

    // 使用PUBLISH-SCRIBLE模式
    protected abstract void produceMessageByPS() throws Exception;
}
