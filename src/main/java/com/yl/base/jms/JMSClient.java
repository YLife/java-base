package com.yl.base.jms;

import javax.jms.JMSException;

public interface JMSClient {

    /**
     * @Function: com.yl.base.jms.JMSProducer::establishConnection
     * @description 建立连接
     *
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/7/25 21:06
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/7/25      yanglun            v1.0.0              修改原因
     */
    void establishConnection() throws Exception;

}
