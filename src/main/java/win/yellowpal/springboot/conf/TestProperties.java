package win.yellowpal.springboot.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperties {
	
	@Value("www.title")
	public static String title;
}
