package win.yellowpal.springboot.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import win.yellowpal.springboot.domain.Test;

@Component
@RabbitListener(queues="object_queue1")
public class ObjectReceiver {

	@RabbitHandler
	public void receiver(Test test){
		System.out.println("test:"+test);
	}
}
