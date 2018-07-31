package win.yellowpal.springboot.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConf {
	
	public static final String exchange = "object_exchange";
	
	public static final String queue1 = "object_queue1";
	
	public static final String queue2 = "object_queue2";
	
	public static final String queue3 = "object_queue3";
	
	@Bean
	public Queue queue(){
		return new Queue("hello");
	}
	
	@Bean
	public FanoutExchange objectExchange(){
		return new FanoutExchange(exchange);
	}
	
	@Bean
	public Queue queue1(){
		return new Queue(queue1);
	}
	
	@Bean
	public Queue queue2(){
		return new Queue(queue2);
	}
	
	@Bean
	public Queue queue3(){
		return new Queue(queue3);
	}
	
	@Bean
	Binding bingdingQueue1(Queue queue1,FanoutExchange objectExchange){
		return BindingBuilder.bind(queue1).to(objectExchange);
	}
	
	@Bean
	Binding bingdingQueue2(Queue queue2,FanoutExchange objectExchange){
		return BindingBuilder.bind(queue2).to(objectExchange);
	}
	
	@Bean
	Binding bingdingQueue3(Queue queue3,FanoutExchange objectExchange){
		return BindingBuilder.bind(queue3).to(objectExchange);
	}

}
