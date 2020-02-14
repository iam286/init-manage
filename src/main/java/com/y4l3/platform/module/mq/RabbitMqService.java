package com.y4l3.platform.module.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y4l3.platform.common.utils.Constants;
import com.y4l3.platform.common.utils.TimeUtils;

/**
 * 消息队列 业务 （测试用）
 * @author changzhongq
 * @time 2019年3月8日 上午9:22:08
 */
@Service
public class RabbitMqService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 测试rabbitmq消息发送
	 */
//	@Scheduled(cron = "0/5 * * * * ?")
	public void testMq() {
		String date = TimeUtils.getTimestamp().toString();
		System.err.println("发送消息成功：" + date);
		rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME, Constants.RABBIT_ROUTING_KEY, date.getBytes());
	}
}
