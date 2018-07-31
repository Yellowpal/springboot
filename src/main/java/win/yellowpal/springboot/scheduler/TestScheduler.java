package win.yellowpal.springboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {
	private int count = 0;

	@Scheduled(cron = "*/10 * * * * ?")
	public void add() {
		System.out.println("this is scheduler task runing  " + (count++));
	}

	@Scheduled(fixedRate = 10000)
	public void test() {
		System.out.println("timestamp " + System.currentTimeMillis());
	}
}
