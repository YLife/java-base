package com.yl.base.jms.kafka;

import com.yl.base.jms.AbstractJMSProvider;

import java.util.Properties;

/**
 * @author yanglun
 * @description: kafka producer study
 * @date 2019/8/4 23:31
 */
public class KafkaProducer {

    /**
     * @Function: com.yl.base.jms.kafka.KafkaProducer::synSend
     * @description 同步发送
     *
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/8/6 20:37
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/8/6      yanglun            v1.0.0              修改原因
     */
    public void syncSend() {

    }

    /**
     * @Function: com.yl.base.jms.kafka.KafkaProducer::asyncSend
     * @description 异步发送
     *
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/8/6 20:38
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/8/6      yanglun            v1.0.0              修改原因
     */
    public void asyncSend() {

    }

    private Properties getProperties() {
        Properties properties = new Properties();
        // kafka集群地址
        properties.put("bootstrap.servers", "");
        // 0：不用等待 1：等待leader写入数据成功 all(-1)：等待leader及follower都写入磁盘成功
        properties.put("acks", "all");
        // 重试次数
        properties.put("retries", "0");
        // producer积累到一定数据，一次发送
        properties.put("batch.size", 16384);
        // 消息缓冲区，消息不会立即发送，如果消息条数不够，则到了超时时间发送
        properties.put("linger.ms", 1);
        // producer积累到一定数据，一次发送
        properties.put("buffer.memory", 33554432);
        // key序列化方式
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化方式
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }


}
