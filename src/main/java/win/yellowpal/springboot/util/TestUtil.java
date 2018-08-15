package win.yellowpal.springboot.util;

public class TestUtil {

	private static int i = 4;
	
	public static int test(){
		if(i <= 0){
			return i;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i--;
	}
	
	public static void main(String[] args) {
		test();
	}
}
