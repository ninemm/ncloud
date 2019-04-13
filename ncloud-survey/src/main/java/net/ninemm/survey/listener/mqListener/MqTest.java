package net.ninemm.survey.listener.mqListener;

import io.jboot.components.mq.JbootmqMessageListener;

/**
 * @description:
 * @author: lsy
 * @create: 2019-03-28 10:03
 **/
public class MqTest implements JbootmqMessageListener {
    @Override
    public void onMessage(String channel, Object message) {
        System.out.println(channel+message);
    }
}
